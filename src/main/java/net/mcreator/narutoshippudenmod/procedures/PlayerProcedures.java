package net.mcreator.narutoshippudenmod.procedures;

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
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.AbstractClientPlayerEntity;
import net.minecraft.client.network.play.NetworkPlayerInfo;
import net.minecraft.client.renderer.entity.PlayerRenderer;
import net.minecraft.command.CommandSource;
import net.minecraft.command.ICommandSource;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.PacketBuffer;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.tags.BlockTags;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.vector.Vector2f;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.GameRules;
import net.minecraft.world.GameType;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerWakeUpEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.loading.FMLPaths;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.items.ItemHandlerHelper;

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
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
			IWorld world = (IWorld) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			if (world instanceof ServerWorld) {
				((ServerWorld) world).spawnParticle(ChakraParticle.particle, x, y, z, (int) 1, 0, 0, 0, 0.01);
			}
			if (world instanceof ServerWorld) {
				((ServerWorld) world).spawnParticle(ChakraParticle.particle, x, (y + 0.5), z, (int) 1, 0, 0, 0, 0.01);
			}
			if (world instanceof ServerWorld) {
				((ServerWorld) world).spawnParticle(ChakraParticle.particle, x, (y + 1), z, (int) 1, 0, 0, 0, 0.01);
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
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.LEVEL = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = (NarutoShippudenModVariables.get(entity).LEVELMAX + 1);
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.LEVELMAX = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = (NarutoShippudenModVariables.get(entity).LEVELSTAT + 1);
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.LEVELSTAT = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = (NarutoShippudenModVariables.get(entity).jp + 1);
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.jp = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = (NarutoShippudenModVariables.get(entity).sp + 1);
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.sp = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(
									new StringTextComponent(
											("Level Up! Level: " + NarutoShippudenModVariables.get(entity).LEVELSTAT + " JP +1" + " SP +1")),
									(true));
						}
					}
					if (NarutoShippudenModVariables.get(entity).LEVEL >= NarutoShippudenModVariables.get(entity).LEVELMAX) {
						{
							double _setval = (NarutoShippudenModVariables.get(entity).LEVEL
									- NarutoShippudenModVariables.get(entity).LEVELMAX);
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.LEVEL = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = (NarutoShippudenModVariables.get(entity).LEVELMAX + 1);
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.LEVELMAX = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = (NarutoShippudenModVariables.get(entity).LEVELSTAT + 1);
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.LEVELSTAT = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = (NarutoShippudenModVariables.get(entity).jp + 1);
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.jp = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = (NarutoShippudenModVariables.get(entity).sp + 1);
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.sp = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(
									new StringTextComponent(
											("Level Up! Level: " + NarutoShippudenModVariables.get(entity).LEVELSTAT + " JP +1" + " SP +1")),
									(true));
						}
					}
				}
				if (NarutoShippudenModVariables.get(entity).LEVELMINIGAME >= NarutoShippudenModVariables.get(entity).LEVELMAXMINIGAME) {
					if (NarutoShippudenModVariables.get(entity).LEVELMINIGAME == NarutoShippudenModVariables.get(entity).LEVELMAXMINIGAME) {
						{
							double _setval = 0;
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.LEVELMINIGAME = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = (NarutoShippudenModVariables.get(entity).LEVELMAXMINIGAME + 2);
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.LEVELMAXMINIGAME = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = (NarutoShippudenModVariables.get(entity).LEVELSTATMINIGAME + 1);
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.LEVELSTATMINIGAME = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = (NarutoShippudenModVariables.get(entity).jp + 1);
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.jp = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = (NarutoShippudenModVariables.get(entity).sp + 1);
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.sp = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity)
									.sendStatusMessage(
											new StringTextComponent(("Level Up! Level: "
													+ NarutoShippudenModVariables.get(entity).LEVELSTATMINIGAME
													+ " JP +1" + " SP +1")),
											(true));
						}
					}
					if (NarutoShippudenModVariables.get(entity).LEVELMINIGAME >= NarutoShippudenModVariables.get(entity).LEVELMAXMINIGAME) {
						{
							double _setval = (NarutoShippudenModVariables.get(entity).LEVELMINIGAME
									- NarutoShippudenModVariables.get(entity).LEVELMAXMINIGAME);
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.LEVELMINIGAME = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = (NarutoShippudenModVariables.get(entity).LEVELMAXMINIGAME + 2);
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.LEVELMAXMINIGAME = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = (NarutoShippudenModVariables.get(entity).LEVELSTATMINIGAME + 1);
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.LEVELSTATMINIGAME = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = (NarutoShippudenModVariables.get(entity).jp + 1);
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.jp = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = (NarutoShippudenModVariables.get(entity).sp + 1);
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.sp = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity)
									.sendStatusMessage(
											new StringTextComponent(("Level Up! Level: "
													+ NarutoShippudenModVariables.get(entity).LEVELSTATMINIGAME
													+ " JP +1" + " SP +1")),
											(true));
						}
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).LEVELSTAT == NarutoShippudenModVariables.get(entity).LevelStatMaxChange) {
				{
					double _setval = 1;
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.LEVELMAX = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).LevelStatMaxChange + 100);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.LevelStatMaxChange = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
	}

	public static class NarutoshippudenconfigProcedure {
		@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
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
		@Mod.EventBusSubscriber
		private static class GlobalTrigger {
			@SubscribeEvent
			public static void onEntityTick(LivingEvent.LivingUpdateEvent event) {
				Entity entity = event.getEntityLiving();
				World world = entity.world;
				double i = entity.getPosX();
				double j = entity.getPosY();
				double k = entity.getPosZ();
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
			IWorld world = (IWorld) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			Entity entity = (Entity) dependencies.get("entity");
			double chain = 0;
			double chainwait = 0;
			if (entity instanceof PlayerEntity) {
				if (new Object() {
					public boolean checkGamemode(Entity _ent) {
						if (_ent instanceof ServerPlayerEntity) {
							return ((ServerPlayerEntity) _ent).interactionManager.getGameType() == GameType.SPECTATOR;
						} else if (_ent instanceof PlayerEntity && _ent.world.isRemote()) {
							NetworkPlayerInfo _npi = Minecraft.getInstance().getConnection()
									.getPlayerInfo(((AbstractClientPlayerEntity) _ent).getGameProfile().getId());
							return _npi != null && _npi.getGameType() == GameType.SPECTATOR;
						}
						return false;
					}
				}.checkGamemode(entity)) {
					entity.noClip = true;
				} else if (!(new Object() {
					public boolean checkGamemode(Entity _ent) {
						if (_ent instanceof ServerPlayerEntity) {
							return ((ServerPlayerEntity) _ent).interactionManager.getGameType() == GameType.SPECTATOR;
						} else if (_ent instanceof PlayerEntity && _ent.world.isRemote()) {
							NetworkPlayerInfo _npi = Minecraft.getInstance().getConnection()
									.getPlayerInfo(((AbstractClientPlayerEntity) _ent).getGameProfile().getId());
							return _npi != null && _npi.getGameType() == GameType.SPECTATOR;
						}
						return false;
					}
				}.checkGamemode(entity))) {
					if (NarutoShippudenModVariables.get(entity).KamuiPhantomPhase == true) {
						entity.noClip = true;
						entity.setMotion((entity.getLookVec().x * 0.25), (entity.getLookVec().y * 0.25), (entity.getLookVec().z * 0.25));
					} else if (NarutoShippudenModVariables.get(entity).KamuiPhantomPhase == false) {
						entity.noClip = false;
					}
				}
			}
			if (entity.getPersistentData().getBoolean("Amaterasu") == true) {
				if (world instanceof ServerWorld) {
					((ServerWorld) world).spawnParticle(AmaterasuFireParticle.particle, x, y, z, (int) 3, 0, 0, 0, 0.05);
				}
			}
		}
	}

	public static class OnPlayerTickUpdateGlobalTriggerProcedure {
		@Mod.EventBusSubscriber
		private static class GlobalTrigger {
			@SubscribeEvent
			public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
				if (event.phase == TickEvent.Phase.END) {
					Entity entity = event.player;
					World world = entity.world;
					double i = entity.getPosX();
					double j = entity.getPosY();
					double k = entity.getPosZ();
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
			IWorld world = (IWorld) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			Entity entity = (Entity) dependencies.get("entity");
			File NarutoShippuden = new File("");
			com.google.gson.JsonObject mainjsonobject = new com.google.gson.JsonObject();
			Entity shadow = null;

			LevelUPProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			if (!entity.isSneaking()) {
				if (!(NarutoShippudenModVariables.get(entity).ChakraAmount >= NarutoShippudenModVariables.get(entity).ChakraMax)) {
					{
						double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount + 0.25);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.ChakraAmount = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if (entity.isSneaking()) {
				if (!(NarutoShippudenModVariables.get(entity).ChakraAmount >= NarutoShippudenModVariables.get(entity).ChakraMax)) {
					{
						double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount + 0.5);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
			if (entity.ticksExisted % 40 == 0 && !world.isRemote()) {
				if (NarutoShippudenModVariables.get(entity).LEVELMINIGAME >= NarutoShippudenModVariables.get(entity).LEVELMAXMINIGAME) {
					if (NarutoShippudenModVariables.get(entity).LEVELMINIGAME == NarutoShippudenModVariables.get(entity).LEVELMAXMINIGAME) {
						{
							double _setval = 0;
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.LEVELMINIGAME = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = (NarutoShippudenModVariables.get(entity).LEVELMAXMINIGAME + 2);
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.LEVELMAXMINIGAME = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = (NarutoShippudenModVariables.get(entity).LEVELSTATMINIGAME + 1);
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.LEVELSTATMINIGAME = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = (NarutoShippudenModVariables.get(entity).jp + 1);
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.jp = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = (NarutoShippudenModVariables.get(entity).sp + 1);
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.sp = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity)
									.sendStatusMessage(
											new StringTextComponent(("Level Up! Level: "
													+ NarutoShippudenModVariables.get(entity).LEVELSTATMINIGAME
													+ " JP +1" + " SP +1")),
											(true));
						}
					}
					if (NarutoShippudenModVariables.get(entity).LEVELMINIGAME >= NarutoShippudenModVariables.get(entity).LEVELMAXMINIGAME) {
						{
							double _setval = (NarutoShippudenModVariables.get(entity).LEVELMINIGAME
									- NarutoShippudenModVariables.get(entity).LEVELMAXMINIGAME);
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.LEVELMINIGAME = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = (NarutoShippudenModVariables.get(entity).LEVELMAXMINIGAME + 2);
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.LEVELMAXMINIGAME = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = (NarutoShippudenModVariables.get(entity).LEVELSTATMINIGAME + 1);
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.LEVELSTATMINIGAME = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = (NarutoShippudenModVariables.get(entity).jp + 1);
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.jp = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = (NarutoShippudenModVariables.get(entity).sp + 1);
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.sp = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity)
									.sendStatusMessage(
											new StringTextComponent(("Level Up! Level: "
													+ NarutoShippudenModVariables.get(entity).LEVELSTATMINIGAME
													+ " JP +1" + " SP +1")),
											(true));
						}
					}
				}
			}
			if (entity.ticksExisted % 20 == 0 && !world.isRemote()) {
				{
					double _setval = (NarutoShippudenModVariables.get(entity).NarutoTimerAwakening + 1);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.NarutoTimerAwakening = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).calendar_calculator + 1);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
							World projectileLevel = _shootFrom.world;
							if (!projectileLevel.isRemote()) {
								ProjectileEntity _entityToSpawn = new Object() {
									public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
										AbstractArrowEntity entityToSpawn = new UzumakiChainItem.ArrowCustomEntity(UzumakiChainItem.arrow, world);
										entityToSpawn.setShooter(shooter);
										entityToSpawn.setDamage(damage);
										entityToSpawn.setKnockbackStrength(knockback);
										entityToSpawn.setSilent(true);

										return entityToSpawn;
									}
								}.getArrow(projectileLevel, entity, 1, 0);
								_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
								_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1, 0);
								projectileLevel.addEntity(_entityToSpawn);
							}
						}
						{
							double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 1);
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.ChakraAmount = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof LivingEntity)
							((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.JUMP_BOOST, (int) 10, (int) 0, (false), (false)));
						if (entity instanceof LivingEntity)
							((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SPEED, (int) 10, (int) 1, (false), (false)));
						if (entity instanceof LivingEntity)
							((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.STRENGTH, (int) 10, (int) 1, (false), (false)));
					} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 1.9) {
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
			}
			if (NarutoShippudenModVariables.get(entity).swiftmode == true) {
				if (NarutoShippudenModVariables.get(entity).ninjutsu >= 30) {
					if (NarutoShippudenModVariables.get(entity).taijutsu >= 20) {
						if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 4) {
							if (entity instanceof LivingEntity)
								((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SPEED, (int) 10, (int) 30, (false), (false)));
							if (entity instanceof LivingEntity)
								((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.STRENGTH, (int) 10, (int) 1, (false), (false)));
							{
								double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 4);
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
							World projectileLevel = _shootFrom.world;
							if (!projectileLevel.isRemote()) {
								ProjectileEntity _entityToSpawn = new Object() {
									public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
										AbstractArrowEntity entityToSpawn = new LaserCircusItem.ArrowCustomEntity(LaserCircusItem.arrow, world);
										entityToSpawn.setShooter(shooter);
										entityToSpawn.setDamage(damage);
										entityToSpawn.setKnockbackStrength(knockback);
										entityToSpawn.setSilent(true);

										return entityToSpawn;
									}
								}.getArrow(projectileLevel, entity, 1, 0);
								_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
								_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1, 0);
								projectileLevel.addEntity(_entityToSpawn);
							}
						}
						{
							double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 1.7);
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.ChakraAmount = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
				}
			}
			if (NarutoShippudenModVariables.get(entity).hoshigakireleaselogic == true) {
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.RESISTANCE, (int) 10, (int) 0, (false), (false)));
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.WATER_BREATHING, (int) 10, (int) 99, (false), (false)));
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SPEED, (int) 10, (int) 0, (false), (false)));
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.STRENGTH, (int) 10, (int) 0, (false), (false)));
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.CONDUIT_POWER, (int) 10, (int) 3, (false), (false)));
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.DOLPHINS_GRACE, (int) 10, (int) 3, (false), (false)));
			}
			if (NarutoShippudenModVariables.get(entity).DanceOfTheLarch == true) {
				if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 4) {
					{
						double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 4);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.ChakraAmount = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof LivingEntity)
						((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.RESISTANCE, (int) 10, (int) 2, (false), (false)));
				} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 3.9) {
					{
						boolean _setval = (false);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.DanceOfTheLarch = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(BoneReleaseTechniqueItem.block, (int) 750);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(BoneReleaseTechniqueItem.block, (int) 500);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(BoneReleaseTechniqueItem.block, (int) 300);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(BoneReleaseTechniqueItem.block, (int) 200);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(BoneReleaseTechniqueItem.block, (int) 100);
					}
				}
			}
			if (NarutoShippudenModVariables.get(entity).ImperviousArmor == true) {
				if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 7) {
					{
						double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 7);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.ChakraAmount = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof LivingEntity)
						((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.RESISTANCE, (int) 10, (int) 3, (false), (false)));
				} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 6.9) {
					{
						boolean _setval = (false);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.ImperviousArmor = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(SteelReleaseTechniqueItem.block, (int) 750);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(SteelReleaseTechniqueItem.block, (int) 500);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(SteelReleaseTechniqueItem.block, (int) 300);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(SteelReleaseTechniqueItem.block, (int) 200);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(SteelReleaseTechniqueItem.block, (int) 100);
					}
				}
			}
			if (NarutoShippudenModVariables.get(entity).magnet_coat == 1) {
				if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 5) {
					{
						double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 5);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.ChakraAmount = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof LivingEntity)
						((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.RESISTANCE, (int) 10, (int) 2, (false), (false)));
				} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 4.9) {
					{
						double _setval = 0;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.magnet_coat = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(MagnetReleaseTechniqueItem.block, (int) 750);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(MagnetReleaseTechniqueItem.block, (int) 500);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(MagnetReleaseTechniqueItem.block, (int) 300);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(MagnetReleaseTechniqueItem.block, (int) 200);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(MagnetReleaseTechniqueItem.block, (int) 100);
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).magnet_coat == 2) {
				if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 7) {
					{
						double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 7);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.ChakraAmount = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof LivingEntity)
						((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.RESISTANCE, (int) 10, (int) 3, (false), (false)));
				} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 6.9) {
					{
						double _setval = 0;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.magnet_coat = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(MagnetReleaseTechniqueItem.block, (int) 750);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(MagnetReleaseTechniqueItem.block, (int) 500);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(MagnetReleaseTechniqueItem.block, (int) 300);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(MagnetReleaseTechniqueItem.block, (int) 200);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(MagnetReleaseTechniqueItem.block, (int) 100);
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).magnet_coat == 3) {
				if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 6) {
					{
						double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 6);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.ChakraAmount = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof LivingEntity)
						((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.RESISTANCE, (int) 10, (int) 2, (false), (false)));
					if (entity instanceof PlayerEntity) {
						((PlayerEntity) entity).abilities.isFlying = (true);
						((PlayerEntity) entity).sendPlayerAbilities();
					}
				} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 5.9) {
					{
						double _setval = 0;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.magnet_coat = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity) {
						((PlayerEntity) entity).abilities.isFlying = (false);
						((PlayerEntity) entity).sendPlayerAbilities();
					}
					entity.setMotion(0, (-100), 0);
					if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(MagnetReleaseTechniqueItem.block, (int) 750);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(MagnetReleaseTechniqueItem.block, (int) 500);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(MagnetReleaseTechniqueItem.block, (int) 300);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(MagnetReleaseTechniqueItem.block, (int) 200);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(MagnetReleaseTechniqueItem.block, (int) 100);
					}
				}
			}
			if (NarutoShippudenModVariables.get(entity).Great_Water_Arm == true) {
				if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 2) {
					{
						double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 2);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.ChakraAmount = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof LivingEntity)
						((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.STRENGTH, (int) 10, (int) 2, (false), (false)));
				} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 1.9) {
					{
						boolean _setval = (false);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.Great_Water_Arm = _setval;
							capability.syncPlayerVariables(entity);
						});
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
			}
			if (NarutoShippudenModVariables.get(entity).izunochakramode == true) {
				if (NarutoShippudenModVariables.get(entity).ninjutsu >= 20) {
					if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 1) {
						{
							double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 1);
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.ChakraAmount = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof LivingEntity)
							((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SPEED, (int) 10, (int) 1, (false), (false)));
						if (entity instanceof LivingEntity)
							((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.STRENGTH, (int) 10, (int) 1, (false), (false)));
					} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 0.9) {
						{
							boolean _setval = (false);
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
				}
			}
			if (NarutoShippudenModVariables.get(entity).HumanBulletTank == true) {
				if (NarutoShippudenModVariables.get(entity).ninjutsu >= 25) {
					if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 2) {
						{
							double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 2);
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.ChakraAmount = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof LivingEntity)
							((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SPEED, (int) 10, (int) 19, (false), (false)));
					} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 1.9) {
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
				}
				{
					List<Entity> _entfound = world
							.getEntitiesWithinAABB(Entity.class,
									new AxisAlignedBB((entity.getPosX()) - (3 / 2d), (entity.getPosY()) - (3 / 2d), (entity.getPosZ()) - (3 / 2d),
											(entity.getPosX()) + (3 / 2d), (entity.getPosY()) + (3 / 2d), (entity.getPosZ()) + (3 / 2d)),
									null)
							.stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
								}
							}.compareDistOf((entity.getPosX()), (entity.getPosY()), (entity.getPosZ()))).collect(Collectors.toList());
					for (Entity entityiterator : _entfound) {
						if (entityiterator instanceof LivingEntity) {
							if (!(entityiterator == entity)) {
								entityiterator.attackEntityFrom(DamageSource.IN_WALL, (float) 2);
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
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.ChakraAmount = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof LivingEntity)
							((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SPEED, (int) 10, (int) 19, (false), (false)));
					} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 2.9) {
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
				}
				{
					List<Entity> _entfound = world
							.getEntitiesWithinAABB(Entity.class,
									new AxisAlignedBB((entity.getPosX()) - (3 / 2d), (entity.getPosY()) - (3 / 2d), (entity.getPosZ()) - (3 / 2d),
											(entity.getPosX()) + (3 / 2d), (entity.getPosY()) + (3 / 2d), (entity.getPosZ()) + (3 / 2d)),
									null)
							.stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
								}
							}.compareDistOf((entity.getPosX()), (entity.getPosY()), (entity.getPosZ()))).collect(Collectors.toList());
					for (Entity entityiterator : _entfound) {
						if (entityiterator instanceof LivingEntity) {
							if (!(entityiterator == entity)) {
								entityiterator.attackEntityFrom(DamageSource.IN_WALL, (float) 4);
							}
						}
					}
				}
			}
			if (NarutoShippudenModVariables.get(entity).ButterflyMode == true) {
				if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 4) {
					{
						double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 4);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.ChakraAmount = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity) {
						((PlayerEntity) entity).abilities.isFlying = (true);
						((PlayerEntity) entity).sendPlayerAbilities();
					}
				} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 3.9) {
					{
						boolean _setval = (false);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.ButterflyMode = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity) {
						((PlayerEntity) entity).abilities.isFlying = (false);
						((PlayerEntity) entity).sendPlayerAbilities();
					}
					entity.setMotion(0, (-100), 0);
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
			}
			if (NarutoShippudenModVariables.get(entity).izunocat == true) {
				if (NarutoShippudenModVariables.get(entity).ninjutsu >= 25) {
					if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 3) {
						{
							double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 3);
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.ChakraAmount = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof LivingEntity)
							((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.STRENGTH, (int) 10, (int) 3, (false), (false)));
					} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 2.9) {
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
				}
			}
			if (NarutoShippudenModVariables.get(entity).taijutsu >= 121) {
				{
					double _setval = (NarutoShippudenModVariables.get(entity).taijutsu - 1);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.taijutsu = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).sp + 1);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.sp = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Your Taijutsu is maxed."), (true));
				}
			}
			if (NarutoShippudenModVariables.get(entity).kenjutsu >= 101) {
				{
					double _setval = (NarutoShippudenModVariables.get(entity).kenjutsu - 1);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.kenjutsu = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).sp + 1);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.sp = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Your Kenjutsu is maxed."), (true));
				}
			}
			if (NarutoShippudenModVariables.get(entity).shurikenjutsu >= 26) {
				{
					double _setval = (NarutoShippudenModVariables.get(entity).shurikenjutsu - 1);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.shurikenjutsu = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).sp + 1);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.sp = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Your Shurikenjutsu is maxed."), (true));
				}
			}
			if (NarutoShippudenModVariables.get(entity).summoning >= 61) {
				{
					double _setval = (NarutoShippudenModVariables.get(entity).summoning - 1);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.summoning = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).sp + 1);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.sp = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Your Summoning is maxed."), (true));
				}
			}
			if (NarutoShippudenModVariables.get(entity).kinjutsu >= 101) {
				{
					double _setval = (NarutoShippudenModVariables.get(entity).kinjutsu - 1);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.kinjutsu = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).sp + 1);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.sp = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Your Kinjutsu is maxed."), (true));
				}
			}
			if (NarutoShippudenModVariables.get(entity).medicine >= 301) {
				{
					double _setval = (NarutoShippudenModVariables.get(entity).medicine - 1);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.medicine = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).sp + 1);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.sp = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).maxhealth - 2);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.maxhealth = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("/attribute " + entity.getDisplayName().getString() + " minecraft:generic.max_health base set "
									+ NarutoShippudenModVariables.get(entity).maxhealth));
				}
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Your Medicine is maxed."), (true));
				}
			}
			if (NarutoShippudenModVariables.get(entity).speed >= 11) {
				{
					double _setval = (NarutoShippudenModVariables.get(entity).speed - 1);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.speed = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).sp + 1);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.sp = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).maxspeed - 0.005);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.maxspeed = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("/attribute " + entity.getDisplayName().getString() + " minecraft:generic.movement_speed base set "
									+ NarutoShippudenModVariables.get(entity).maxspeed));
				}
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Your Speed is maxed."), (true));
				}
			}
			if (NarutoShippudenModVariables.get(entity).jutsupowerstat >= 11) {
				{
					double _setval = (NarutoShippudenModVariables.get(entity).jutsupowerstat - 1);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.jutsupowerstat = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).sp + 1);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.sp = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Your Jutsu Power is maxed."), (true));
				}
			}
			if (NarutoShippudenModVariables.get(entity).genjutsu >= 71) {
				{
					double _setval = (NarutoShippudenModVariables.get(entity).genjutsu - 1);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.genjutsu = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).sp + 1);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.sp = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Your Genjutsu is maxed."), (true));
				}
			}
			if (NarutoShippudenModVariables.get(entity).IQ >= 221) {
				{
					double _setval = (NarutoShippudenModVariables.get(entity).IQ - 1);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.IQ = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).sp + 1);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.sp = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Your IQ is maxed."), (true));
				}
			}
			if (NarutoShippudenModVariables.get(entity).SmokeForm == true) {
				if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 4) {
					if (entity instanceof LivingEntity)
						((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.FIRE_RESISTANCE, (int) 50, (int) 1, (false), (false)));
					if (entity instanceof LivingEntity)
						((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.RESISTANCE, (int) 50, (int) 1, (false), (false)));
					if (entity instanceof LivingEntity)
						((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.INVISIBILITY, (int) 50, (int) 1, (false), (false)));
					if (entity instanceof LivingEntity)
						((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.JUMP_BOOST, (int) 50, (int) 0, (false), (false)));
					if (entity instanceof LivingEntity)
						((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SLOWNESS, (int) 50, (int) 0, (false), (false)));
					if (world instanceof ServerWorld) {
						((ServerWorld) world).spawnParticle(ParticleTypes.CLOUD, x, (y + 1), z, (int) 5, 0, 0, 0, 0);
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 4);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.ChakraAmount = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 3.9) {
					{
						boolean _setval = (false);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.SmokeForm = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(SmokeReleaseTechniqueItem.block, (int) 750);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(SmokeReleaseTechniqueItem.block, (int) 500);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(SmokeReleaseTechniqueItem.block, (int) 300);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(SmokeReleaseTechniqueItem.block, (int) 200);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(SmokeReleaseTechniqueItem.block, (int) 100);
					}
				}
			}
			if (NarutoShippudenModVariables.get(entity).WindMode == true) {
				if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 1) {
					if (entity instanceof LivingEntity)
						((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SPEED, (int) 50, (int) 2, (false), (false)));
					if (entity instanceof LivingEntity)
						((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.HASTE, (int) 50, (int) 2, (false), (false)));
					if (entity instanceof LivingEntity)
						((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.JUMP_BOOST, (int) 50, (int) 1, (false), (false)));
					if (entity instanceof LivingEntity)
						((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.RESISTANCE, (int) 50, (int) 0, (false), (false)));
					{
						double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 1);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.ChakraAmount = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 0.9) {
					{
						boolean _setval = (false);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.WindMode = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(WindReleaseTechniqueItem.block, (int) 200);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(WindReleaseTechniqueItem.block, (int) 160);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(WindReleaseTechniqueItem.block, (int) 120);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(WindReleaseTechniqueItem.block, (int) 80);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(WindReleaseTechniqueItem.block, (int) 40);
					}
				}
			}
			if (NarutoShippudenModVariables.get(entity).VolticThomasCannonDamage == true) {
				{
					List<Entity> _entfound = world
							.getEntitiesWithinAABB(Entity.class,
									new AxisAlignedBB(x - (3 / 2d), y - (3 / 2d), z - (3 / 2d), x + (3 / 2d), y + (3 / 2d), z + (3 / 2d)), null)
							.stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
								}
							}.compareDistOf(x, y, z)).collect(Collectors.toList());
					for (Entity entityiterator : _entfound) {
						if (!(entityiterator == entity)) {
							entityiterator.attackEntityFrom(DamageSource.GENERIC, (float) 55);
						}
					}
				}
			}
			if (NarutoShippudenModVariables.get(entity).PassingFang == true) {
				{
					List<Entity> _entfound = world
							.getEntitiesWithinAABB(Entity.class,
									new AxisAlignedBB(x - (3 / 2d), y - (3 / 2d), z - (3 / 2d), x + (3 / 2d), y + (3 / 2d), z + (3 / 2d)), null)
							.stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
								}
							}.compareDistOf(x, y, z)).collect(Collectors.toList());
					for (Entity entityiterator : _entfound) {
						if (!(entityiterator == entity)) {
							entityiterator.attackEntityFrom(DamageSource.GENERIC, (float) 20);
						}
					}
				}
			}
			if (NarutoShippudenModVariables.get(entity).NaraClanShadow == true) {
				if (shadow == null) {
					shadow = (Entity) world
							.getEntitiesWithinAABB(LivingEntity.class,
									new AxisAlignedBB(
											(entity.world.rayTraceBlocks(
													new RayTraceContext(entity.getEyePosition(1f),
															entity.getEyePosition(1f).add(entity.getLook(1f).x * 5, entity.getLook(1f).y * 5,
																	entity.getLook(1f).z * 5),
															RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
													.getPos().getX()) - (5 / 2d),
											(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
													entity.getEyePosition(1f).add(entity.getLook(1f).x * 5, entity.getLook(1f).y * 5,
															entity.getLook(1f).z * 5),
													RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getY())
													- (5 / 2d),
											(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
													entity.getEyePosition(1f).add(entity.getLook(1f).x * 5, entity.getLook(1f).y * 5,
															entity.getLook(1f).z * 5),
													RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getZ())
													- (5 / 2d),
											(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
													entity.getEyePosition(1f).add(entity.getLook(1f).x * 5, entity.getLook(1f).y * 5,
															entity.getLook(1f).z * 5),
													RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getX())
													+ (5 / 2d),
											(entity.world
													.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
															entity.getEyePosition(1f)
																	.add(entity.getLook(1f).x * 5, entity.getLook(1f).y * 5, entity.getLook(1f).z * 5),
															RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
													.getPos().getY()) + (5 / 2d),
											(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
													entity.getEyePosition(1f).add(entity.getLook(1f).x * 5, entity.getLook(1f).y * 5,
															entity.getLook(1f).z * 5),
													RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getZ())
													+ (5 / 2d)),
									null)
							.stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
								}
							}.compareDistOf(
									(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
											entity.getEyePosition(1f).add(entity.getLook(1f).x * 5, entity.getLook(1f).y * 5, entity.getLook(1f).z * 5),
											RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getX()),
									(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
											entity.getEyePosition(1f).add(entity.getLook(1f).x * 5, entity.getLook(1f).y * 5, entity.getLook(1f).z * 5),
											RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getY()),
									(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
											entity.getEyePosition(1f).add(entity.getLook(1f).x * 5, entity.getLook(1f).y * 5, entity.getLook(1f).z * 5),
											RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getZ())))
							.findFirst().orElse(null);
				}
				{
					double _setval = Math.floor(entity.getPosX());
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.Shadow1X = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = Math.floor(entity.getPosZ());
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.Shadow1Z = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = Math.floor(shadow.getPosX());
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.Shadow2X = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = Math.floor(shadow.getPosZ());
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.Shadow2Z = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (entity.getPosX());
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.OriginalX1 = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (entity.getPosZ());
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
							world.setBlockState(
									new BlockPos(
											NarutoShippudenModVariables.get(entity).Shadow1X - 1,
											entity.getPosY(),
											NarutoShippudenModVariables.get(entity).Shadow1Z),
									NaraShadowBlock.block.getDefaultState(), 3);
							{
								double _setval = (NarutoShippudenModVariables.get(entity).Shadow1X - 1);
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.Shadow1X = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						} else if (NarutoShippudenModVariables.get(entity).Shadow1X < NarutoShippudenModVariables.get(entity).Shadow2X) {
							world.setBlockState(
									new BlockPos(
											NarutoShippudenModVariables.get(entity).Shadow1X + 1,
											entity.getPosY(),
											NarutoShippudenModVariables.get(entity).Shadow1Z),
									NaraShadowBlock.block.getDefaultState(), 3);
							{
								double _setval = (NarutoShippudenModVariables.get(entity).Shadow1X + 1);
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
							world.setBlockState(
									new BlockPos(
											NarutoShippudenModVariables.get(entity).Shadow1X,
											entity.getPosY(),
											NarutoShippudenModVariables.get(entity).Shadow1Z - 1),
									NaraShadowBlock.block.getDefaultState(), 3);
							{
								double _setval = (NarutoShippudenModVariables.get(entity).Shadow1Z - 1);
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.Shadow1Z = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						} else if (NarutoShippudenModVariables.get(entity).Shadow1Z < NarutoShippudenModVariables.get(entity).Shadow2Z) {
							world.setBlockState(
									new BlockPos(
											NarutoShippudenModVariables.get(entity).Shadow1X,
											entity.getPosY(),
											NarutoShippudenModVariables.get(entity).Shadow1Z + 1),
									NaraShadowBlock.block.getDefaultState(), 3);
							{
								double _setval = (NarutoShippudenModVariables.get(entity).Shadow1Z + 1);
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.Shadow1Z = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						}
					}
				}
				if (((Entity) world
						.getEntitiesWithinAABB(ShadowImitationEntityEntity.CustomEntity.class,
								new AxisAlignedBB((entity.getPosX()) - (30 / 2d), (entity.getPosY()) - (30 / 2d), (entity.getPosZ()) - (30 / 2d),
										(entity.getPosX()) + (30 / 2d), (entity.getPosY()) + (30 / 2d), (entity.getPosZ()) + (30 / 2d)),
								null)
						.stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
							}
						}.compareDistOf((entity.getPosX()), (entity.getPosY()), (entity.getPosZ()))).findFirst().orElse(null)) != null
						&& (Math.floor(entity.getPosX()) - Math.floor(((Entity) world
								.getEntitiesWithinAABB(ShadowImitationEntityEntity.CustomEntity.class,
										new AxisAlignedBB((entity.getPosX()) - (30 / 2d), (entity.getPosY()) - (30 / 2d), (entity.getPosZ()) - (30 / 2d),
												(entity.getPosX()) + (30 / 2d), (entity.getPosY()) + (30 / 2d), (entity.getPosZ()) + (30 / 2d)),
										null)
								.stream().sorted(new Object() {
									Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
										return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
									}
								}.compareDistOf((entity.getPosX()), (entity.getPosY()), (entity.getPosZ()))).findFirst().orElse(null))
								.getPosX()) != NarutoShippudenModVariables.get(entity).ShadowX1
										- NarutoShippudenModVariables.get(entity).ShadowX2
								|| Math.floor(entity.getPosZ())
										- Math.floor(((Entity) world
												.getEntitiesWithinAABB(ShadowImitationEntityEntity.CustomEntity.class,
														new AxisAlignedBB((entity.getPosX()) - (30 / 2d), (entity.getPosY()) - (30 / 2d),
																(entity.getPosZ()) - (30 / 2d), (entity.getPosX()) + (30 / 2d),
																(entity.getPosY()) + (30 / 2d), (entity.getPosZ()) + (30 / 2d)),
														null)
												.stream().sorted(new Object() {
													Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
														return Comparator
																.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
													}
												}.compareDistOf((entity.getPosX()), (entity.getPosY()), (entity.getPosZ()))).findFirst().orElse(null))
												.getPosZ()) != NarutoShippudenModVariables.get(entity).ShadowZ1
														- NarutoShippudenModVariables.get(entity).ShadowZ2)) {
					if (Math.floor(entity.getPosX() + ((Entity) world
							.getEntitiesWithinAABB(ShadowImitationEntityEntity.CustomEntity.class,
									new AxisAlignedBB((entity.getPosX()) - (30 / 2d), (entity.getPosY()) - (30 / 2d), (entity.getPosZ()) - (30 / 2d),
											(entity.getPosX()) + (30 / 2d), (entity.getPosY()) + (30 / 2d), (entity.getPosZ()) + (30 / 2d)),
									null)
							.stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
								}
							}.compareDistOf((entity.getPosX()), (entity.getPosY()), (entity.getPosZ()))).findFirst().orElse(null)).getPosX()) > Math
									.floor(NarutoShippudenModVariables.get(entity).OriginalX1
											+ ((Entity) world
													.getEntitiesWithinAABB(ShadowImitationEntityEntity.CustomEntity.class,
															new AxisAlignedBB((entity.getPosX()) - (30 / 2d), (entity.getPosY()) - (30 / 2d),
																	(entity.getPosZ()) - (30 / 2d), (entity.getPosX()) + (30 / 2d),
																	(entity.getPosY()) + (30 / 2d), (entity.getPosZ()) + (30 / 2d)),
															null)
													.stream().sorted(new Object() {
														Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
															return Comparator
																	.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
														}
													}.compareDistOf((entity.getPosX()), (entity.getPosY()), (entity.getPosZ()))).findFirst().orElse(null))
													.getPosX())) {
						(((Entity) world
								.getEntitiesWithinAABB(ShadowImitationEntityEntity.CustomEntity.class,
										new AxisAlignedBB((entity.getPosX()) - (30 / 2d), (entity.getPosY()) - (30 / 2d), (entity.getPosZ()) - (30 / 2d),
												(entity.getPosX()) + (30 / 2d), (entity.getPosY()) + (30 / 2d), (entity.getPosZ()) + (30 / 2d)),
										null)
								.stream().sorted(new Object() {
									Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
										return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
									}
								}.compareDistOf((entity.getPosX()), (entity.getPosY()), (entity.getPosZ()))).findFirst().orElse(null)).getRidingEntity())
								.setMotion(0.3, 0, 0);
						{
							double _setval = (entity.getPosX());
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.OriginalX1 = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					} else if (Math.floor(entity.getPosX() + ((Entity) world
							.getEntitiesWithinAABB(ShadowImitationEntityEntity.CustomEntity.class,
									new AxisAlignedBB((entity.getPosX()) - (30 / 2d), (entity.getPosY()) - (30 / 2d), (entity.getPosZ()) - (30 / 2d),
											(entity.getPosX()) + (30 / 2d), (entity.getPosY()) + (30 / 2d), (entity.getPosZ()) + (30 / 2d)),
									null)
							.stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
								}
							}.compareDistOf((entity.getPosX()), (entity.getPosY()), (entity.getPosZ()))).findFirst().orElse(null)).getPosX()) < Math
									.floor(NarutoShippudenModVariables.get(entity).OriginalX1
											+ ((Entity) world
													.getEntitiesWithinAABB(ShadowImitationEntityEntity.CustomEntity.class,
															new AxisAlignedBB((entity.getPosX()) - (30 / 2d), (entity.getPosY()) - (30 / 2d),
																	(entity.getPosZ()) - (30 / 2d), (entity.getPosX()) + (30 / 2d),
																	(entity.getPosY()) + (30 / 2d), (entity.getPosZ()) + (30 / 2d)),
															null)
													.stream().sorted(new Object() {
														Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
															return Comparator
																	.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
														}
													}.compareDistOf((entity.getPosX()), (entity.getPosY()), (entity.getPosZ()))).findFirst().orElse(null))
													.getPosX())) {
						(((Entity) world
								.getEntitiesWithinAABB(ShadowImitationEntityEntity.CustomEntity.class,
										new AxisAlignedBB((entity.getPosX()) - (30 / 2d), (entity.getPosY()) - (30 / 2d), (entity.getPosZ()) - (30 / 2d),
												(entity.getPosX()) + (30 / 2d), (entity.getPosY()) + (30 / 2d), (entity.getPosZ()) + (30 / 2d)),
										null)
								.stream().sorted(new Object() {
									Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
										return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
									}
								}.compareDistOf((entity.getPosX()), (entity.getPosY()), (entity.getPosZ()))).findFirst().orElse(null)).getRidingEntity())
								.setMotion((-0.3), 0, 0);
						{
							double _setval = (entity.getPosX());
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.OriginalX1 = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					} else if (Math.floor(entity.getPosZ() + ((Entity) world
							.getEntitiesWithinAABB(ShadowImitationEntityEntity.CustomEntity.class,
									new AxisAlignedBB((entity.getPosX()) - (30 / 2d), (entity.getPosY()) - (30 / 2d), (entity.getPosZ()) - (30 / 2d),
											(entity.getPosX()) + (30 / 2d), (entity.getPosY()) + (30 / 2d), (entity.getPosZ()) + (30 / 2d)),
									null)
							.stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
								}
							}.compareDistOf((entity.getPosX()), (entity.getPosY()), (entity.getPosZ()))).findFirst().orElse(null)).getPosZ()) > Math
									.floor(NarutoShippudenModVariables.get(entity).OriginalZ1
											+ ((Entity) world
													.getEntitiesWithinAABB(ShadowImitationEntityEntity.CustomEntity.class,
															new AxisAlignedBB((entity.getPosX()) - (30 / 2d), (entity.getPosY()) - (30 / 2d),
																	(entity.getPosZ()) - (30 / 2d), (entity.getPosX()) + (30 / 2d),
																	(entity.getPosY()) + (30 / 2d), (entity.getPosZ()) + (30 / 2d)),
															null)
													.stream().sorted(new Object() {
														Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
															return Comparator
																	.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
														}
													}.compareDistOf((entity.getPosX()), (entity.getPosY()), (entity.getPosZ()))).findFirst().orElse(null))
													.getPosZ())) {
						(((Entity) world
								.getEntitiesWithinAABB(ShadowImitationEntityEntity.CustomEntity.class,
										new AxisAlignedBB((entity.getPosX()) - (30 / 2d), (entity.getPosY()) - (30 / 2d), (entity.getPosZ()) - (30 / 2d),
												(entity.getPosX()) + (30 / 2d), (entity.getPosY()) + (30 / 2d), (entity.getPosZ()) + (30 / 2d)),
										null)
								.stream().sorted(new Object() {
									Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
										return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
									}
								}.compareDistOf((entity.getPosX()), (entity.getPosY()), (entity.getPosZ()))).findFirst().orElse(null)).getRidingEntity())
								.setMotion(0, 0, 0.3);
						{
							double _setval = (entity.getPosZ());
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.OriginalZ1 = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					} else if (Math.floor(entity.getPosZ() + ((Entity) world
							.getEntitiesWithinAABB(ShadowImitationEntityEntity.CustomEntity.class,
									new AxisAlignedBB((entity.getPosX()) - (30 / 2d), (entity.getPosY()) - (30 / 2d), (entity.getPosZ()) - (30 / 2d),
											(entity.getPosX()) + (30 / 2d), (entity.getPosY()) + (30 / 2d), (entity.getPosZ()) + (30 / 2d)),
									null)
							.stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
								}
							}.compareDistOf((entity.getPosX()), (entity.getPosY()), (entity.getPosZ()))).findFirst().orElse(null)).getPosZ()) < Math
									.floor(NarutoShippudenModVariables.get(entity).OriginalZ1
											+ ((Entity) world
													.getEntitiesWithinAABB(ShadowImitationEntityEntity.CustomEntity.class,
															new AxisAlignedBB((entity.getPosX()) - (30 / 2d), (entity.getPosY()) - (30 / 2d),
																	(entity.getPosZ()) - (30 / 2d), (entity.getPosX()) + (30 / 2d),
																	(entity.getPosY()) + (30 / 2d), (entity.getPosZ()) + (30 / 2d)),
															null)
													.stream().sorted(new Object() {
														Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
															return Comparator
																	.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
														}
													}.compareDistOf((entity.getPosX()), (entity.getPosY()), (entity.getPosZ()))).findFirst().orElse(null))
													.getPosZ())) {
						(((Entity) world
								.getEntitiesWithinAABB(ShadowImitationEntityEntity.CustomEntity.class,
										new AxisAlignedBB((entity.getPosX()) - (30 / 2d), (entity.getPosY()) - (30 / 2d), (entity.getPosZ()) - (30 / 2d),
												(entity.getPosX()) + (30 / 2d), (entity.getPosY()) + (30 / 2d), (entity.getPosZ()) + (30 / 2d)),
										null)
								.stream().sorted(new Object() {
									Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
										return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
									}
								}.compareDistOf((entity.getPosX()), (entity.getPosY()), (entity.getPosZ()))).findFirst().orElse(null)).getRidingEntity())
								.setMotion(0, 0, (-0.3));
						{
							double _setval = (entity.getPosZ());
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.Health = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMaxHealth() : -1);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.HealthMax = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (NarutoShippudenModVariables.get(entity).medicine >= 301) {
				{
					double _setval = 620;
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.Health = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = 620;
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.HealthMax = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if (NarutoShippudenModVariables.get(entity).Kagutsuchi == true) {
				if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 5) {
					if (world
							.isAirBlock(
									new BlockPos(
											entity.world.rayTraceBlocks(
													new RayTraceContext(entity.getEyePosition(1f),
															entity.getEyePosition(1f).add(entity.getLook(1f).x * 8, entity.getLook(1f).y * 8,
																	entity.getLook(1f).z * 8),
															RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
													.getPos().getX(),
											entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
													entity.getEyePosition(1f).add(entity.getLook(1f).x * 8, entity.getLook(1f).y * 8,
															entity.getLook(1f).z * 8),
													RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getY(),
											entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
													entity.getEyePosition(1f).add(entity.getLook(1f).x * 8, entity.getLook(1f).y * 8,
															entity.getLook(1f).z * 8),
													RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getZ()))
							|| !world
									.getBlockState(new BlockPos(
											entity.world
													.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
															entity.getEyePosition(1f).add(entity.getLook(1f).x * 8, entity.getLook(1f).y * 8,
																	entity.getLook(1f).z * 8),
															RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
													.getPos().getX(),
											entity.world
													.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
															entity.getEyePosition(1f).add(entity.getLook(1f).x * 8, entity.getLook(1f).y * 8,
																	entity.getLook(1f).z * 8),
															RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
													.getPos().getY(),
											entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
													entity.getEyePosition(1f).add(entity.getLook(1f).x * 8, entity.getLook(1f).y * 8,
															entity.getLook(1f).z * 8),
													RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getZ()))
									.isSolid()) {
						world.setBlockState(
								new BlockPos(
										entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
												entity.getEyePosition(1f).add(entity.getLook(1f).x * 8, entity.getLook(1f).y * 8,
														entity.getLook(1f).z * 8),
												RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos()
												.getX(),
										entity.world
												.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
														entity.getEyePosition(1f).add(entity.getLook(1f).x * 8, entity.getLook(1f).y * 8,
																entity.getLook(1f).z * 8),
														RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
												.getPos().getY(),
										entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
												entity.getEyePosition(1f).add(entity.getLook(1f).x * 8, entity.getLook(1f).y * 8,
														entity.getLook(1f).z * 8),
												RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getZ()),
								AmaterasuSpreadBlock.block.getDefaultState(), 3);
						if (!world.isRemote()) {
							BlockPos _bp = new BlockPos(
									entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
											entity.getEyePosition(1f).add(entity.getLook(1f).x * 8, entity.getLook(1f).y * 8, entity.getLook(1f).z * 8),
											RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getX(),
									entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
											entity.getEyePosition(1f).add(entity.getLook(1f).x * 8, entity.getLook(1f).y * 8, entity.getLook(1f).z * 8),
											RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getY(),
									entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
											entity.getEyePosition(1f).add(entity.getLook(1f).x * 8, entity.getLook(1f).y * 8, entity.getLook(1f).z * 8),
											RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getZ());
							TileEntity _tileEntity = world.getTileEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_tileEntity != null)
								_tileEntity.getTileData().putBoolean("kagutsuchi", (true));
							if (world instanceof World)
								((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
						}
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 5);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.ChakraAmount = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 4.9) {
					{
						boolean _setval = (false);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.ChakraAmount = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof LivingEntity)
							((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.RESISTANCE, (int) 10, (int) 0, (false), (false)));
						if (world instanceof ServerWorld) {
							((ServerWorld) world).spawnParticle(AmaterasuFireParticle.particle, x, (y + 1), z, (int) 5, 0, 0, 0, 0.01);
						}
					} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 1.9) {
						{
							double _setval = 0;
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.mangekyousharingansusanostage = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							boolean _setval = (false);
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.AmaterasuSusano = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof LivingEntity) {
							((LivingEntity) entity).removePotionEffect(Effects.RESISTANCE);
						}
					}
				} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 2) {
					if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 4) {
						{
							double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 4);
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.ChakraAmount = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof LivingEntity)
							((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.RESISTANCE, (int) 10, (int) 1, (false), (false)));
						if (world instanceof ServerWorld) {
							((ServerWorld) world).spawnParticle(AmaterasuFireParticle.particle, x, (y + 2), z, (int) 5, 0, 0, 0, 0.01);
						}
					} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 3.9) {
						{
							double _setval = 0;
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.mangekyousharingansusanostage = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							boolean _setval = (false);
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.AmaterasuSusano = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof LivingEntity) {
							((LivingEntity) entity).removePotionEffect(Effects.RESISTANCE);
						}
					}
				} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 3) {
					if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 6) {
						{
							double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 6);
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.ChakraAmount = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof LivingEntity)
							((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.RESISTANCE, (int) 10, (int) 2, (false), (false)));
						if (world instanceof ServerWorld) {
							((ServerWorld) world).spawnParticle(AmaterasuFireParticle.particle, x, (y + 2), z, (int) 5, 0, 0, 0, 0.01);
						}
					} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 5.9) {
						{
							double _setval = 0;
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.mangekyousharingansusanostage = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							boolean _setval = (false);
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.AmaterasuSusano = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof LivingEntity) {
							((LivingEntity) entity).removePotionEffect(Effects.RESISTANCE);
						}
					}
				} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 4) {
					if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 8) {
						{
							double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 8);
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.ChakraAmount = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof LivingEntity)
							((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.RESISTANCE, (int) 10, (int) 3, (false), (false)));
						if (world instanceof ServerWorld) {
							((ServerWorld) world).spawnParticle(AmaterasuFireParticle.particle, x, (y + 2), z, (int) 5, 0, 0, 0, 0.01);
						}
					} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 7.9) {
						{
							double _setval = 0;
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.mangekyousharingansusanostage = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							boolean _setval = (false);
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.AmaterasuSusano = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof LivingEntity) {
							((LivingEntity) entity).removePotionEffect(Effects.RESISTANCE);
						}
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).AmaterasuSusano == false) {
				if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 1) {
					if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 1) {
						{
							double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 1);
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.ChakraAmount = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof LivingEntity)
							((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.RESISTANCE, (int) 10, (int) 0, (false), (false)));
					} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 0.9) {
						{
							double _setval = 0;
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.mangekyousharingansusanostage = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof LivingEntity) {
							((LivingEntity) entity).removePotionEffect(Effects.RESISTANCE);
						}
					}
				} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 2) {
					if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 3) {
						{
							double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 3);
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.ChakraAmount = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof LivingEntity)
							((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.RESISTANCE, (int) 10, (int) 1, (false), (false)));
					} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 2.9) {
						{
							double _setval = 0;
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.mangekyousharingansusanostage = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof LivingEntity) {
							((LivingEntity) entity).removePotionEffect(Effects.RESISTANCE);
						}
					}
				} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 3) {
					if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 5) {
						{
							double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 5);
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.ChakraAmount = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof LivingEntity)
							((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.RESISTANCE, (int) 10, (int) 2, (false), (false)));
					} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 4.9) {
						{
							double _setval = 0;
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.mangekyousharingansusanostage = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof LivingEntity) {
							((LivingEntity) entity).removePotionEffect(Effects.RESISTANCE);
						}
					}
				} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 4) {
					if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 7) {
						{
							double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 7);
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.ChakraAmount = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof LivingEntity)
							((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.RESISTANCE, (int) 10, (int) 3, (false), (false)));
					} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 6.9) {
						{
							double _setval = 0;
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.mangekyousharingansusanostage = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof LivingEntity) {
							((LivingEntity) entity).removePotionEffect(Effects.RESISTANCE);
						}
					}
				}
			}
			if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem() == HiramekareiItem.block
					|| ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
							.getItem() == HiramekareiSplittedItem.block) {
				if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
						.getBoolean("HiramekareiSharp") == true) {
					if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
							.getDouble("Chakra") >= 1) {
						((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
								.putDouble("Chakra", (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
										.getOrCreateTag().getDouble("Chakra") - 1));
						((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
								.putDouble("HiramekareiSharp", 1);
					} else if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
							.getDouble("Chakra") <= 0.9) {
						((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
								.putDouble("HiramekareiSharp", 0);
						((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
								.putBoolean("HiramekareiSharp", (false));
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Hiramekarei Sharp: Off"), (true));
						}
					}
				} else {
					((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
							.putDouble("HiramekareiSharp", 0);
				}
			} else if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
					.getItem() == HiramekareiItem.block
					|| ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
							.getItem() == HiramekareiSplittedItem.block) {
				if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY).getOrCreateTag()
						.getBoolean("HiramekareiSharp") == true) {
					if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY).getOrCreateTag()
							.getDouble("Chakra") >= 1) {
						((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY).getOrCreateTag()
								.putDouble("Chakra", (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
										.getOrCreateTag().getDouble("Chakra") - 1));
						((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY).getOrCreateTag()
								.putDouble("HiramekareiSharp", 1);
					} else if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY).getOrCreateTag()
							.getDouble("Chakra") <= 0.9) {
						((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY).getOrCreateTag()
								.putDouble("HiramekareiSharp", 0);
						((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY).getOrCreateTag()
								.putBoolean("HiramekareiSharp", (false));
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Hiramekarei Sharp: Off"), (true));
						}
					}
				} else {
					((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY).getOrCreateTag()
							.putDouble("HiramekareiSharp", 0);
				}
			}
			{
				double _setval = (0 + 76
						- Math.ceil(NarutoShippudenModVariables.get(entity).ChakraAmount
								* (76 / Math.max(NarutoShippudenModVariables.get(entity).ChakraMax, 1))));
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.ChakraBarfill = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = (0 + 76
						- Math.ceil(NarutoShippudenModVariables.get(entity).Health
								* (76 / Math.max(NarutoShippudenModVariables.get(entity).HealthMax, 1))));
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.HPBarfill = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (NarutoShippudenModVariables.get(entity).DashCooldown == true) {
				if (NarutoShippudenModVariables.get(entity).DashCooldownTicks <= 59) {
					{
						double _setval = (NarutoShippudenModVariables.get(entity).DashCooldownTicks + 1);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.DashCooldownTicks = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else if (NarutoShippudenModVariables.get(entity).DashCooldownTicks >= 60) {
					{
						boolean _setval = (false);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.DashCooldown = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = 0;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.WPressed = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = 0;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.APressed = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = 0;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.DPressed = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = 0;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.SPressed = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = 0;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.UpDashCooldownTicks = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else if (NarutoShippudenModVariables.get(entity).UpDashCooldownTicks >= 60) {
					{
						boolean _setval = (false);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.UpDashCooldown = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = 0;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.SpacePressed = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = 0;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.DashReset = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else if (NarutoShippudenModVariables.get(entity).DashReset >= 10) {
					{
						double _setval = 0;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.WPressed = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = 0;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.APressed = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = 0;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.DPressed = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = 0;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.SPressed = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = 0;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.DashReset = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						boolean _setval = (false);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.Dash = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			}
			if (NarutoShippudenModVariables.get(entity).Chakra_Control == true) {
				if (NarutoShippudenModVariables.get(entity).WallClimb == false) {
					if (Blocks.WATER == (world.getFluidState(new BlockPos(entity.getPosX(), entity.getPosY() - 1, entity.getPosZ())).getBlockState())
							.getBlock()
							|| Blocks.WATER == (world.getFluidState(new BlockPos(entity.getPosX(), entity.getPosY() - 1, entity.getPosZ()))
									.getBlockState()).getBlock()
							|| Blocks.BUBBLE_COLUMN == (world.getFluidState(new BlockPos(entity.getPosX(), entity.getPosY() - 1, entity.getPosZ()))
									.getBlockState()).getBlock()) {
						entity.setNoGravity((true));
						{
							boolean _setval = (true);
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.WaterWalk = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					} else {
						entity.setNoGravity((false));
						{
							boolean _setval = (false);
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.WaterWalk = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
				}
				if (NarutoShippudenModVariables.get(entity).WaterWalk == false) {
					if (NarutoShippudenModVariables.get(entity).WHold == true) {
						if ((entity.getHorizontalFacing()) == Direction.NORTH) {
							if (!BlockTags.getCollection().getTagByID(new ResourceLocation("minecraft:all_signs"))
									.contains((world.getBlockState(new BlockPos(x, y, z - 1))).getBlock())
									&& !BlockTags.getCollection().getTagByID(new ResourceLocation("minecraft:banners"))
											.contains((world.getBlockState(new BlockPos(x, y, z - 1))).getBlock())
									&& !BlockTags.getCollection().getTagByID(new ResourceLocation("minecraft:beds"))
											.contains((world.getBlockState(new BlockPos(x, y, z - 1))).getBlock())
									&& !BlockTags.getCollection().getTagByID(new ResourceLocation("minecraft:bee_growables"))
											.contains((world.getBlockState(new BlockPos(x, y, z - 1))).getBlock())
									&& !BlockTags.getCollection().getTagByID(new ResourceLocation("minecraft:buttons"))
											.contains((world.getBlockState(new BlockPos(x, y, z - 1))).getBlock())
									&& !BlockTags.getCollection().getTagByID(new ResourceLocation("minecraft:campfires"))
											.contains((world.getBlockState(new BlockPos(x, y, z - 1))).getBlock())
									&& !BlockTags.getCollection().getTagByID(new ResourceLocation("minecraft:climbable"))
											.contains((world.getBlockState(new BlockPos(x, y, z - 1))).getBlock())
									&& !BlockTags.getCollection().getTagByID(new ResourceLocation("minecraft:crops"))
											.contains((world.getBlockState(new BlockPos(x, y, z - 1))).getBlock())
									&& !BlockTags.getCollection().getTagByID(new ResourceLocation("minecraft:wool_carpets"))
											.contains((world.getBlockState(new BlockPos(x, y, z - 1))).getBlock())
									&& !BlockTags.getCollection().getTagByID(new ResourceLocation("minecraft:fall_damage_resetting"))
											.contains((world.getBlockState(new BlockPos(x, y, z - 1))).getBlock())
									&& !BlockTags.getCollection().getTagByID(new ResourceLocation("minecraft:fence_gates"))
											.contains((world.getBlockState(new BlockPos(x, y, z - 1))).getBlock())
									&& !BlockTags.getCollection().getTagByID(new ResourceLocation("minecraft:fences"))
											.contains((world.getBlockState(new BlockPos(x, y, z - 1))).getBlock())
									&& !BlockTags.getCollection().getTagByID(new ResourceLocation("minecraft:flower_pots"))
											.contains((world.getBlockState(new BlockPos(x, y, z - 1))).getBlock())
									&& !BlockTags.getCollection().getTagByID(new ResourceLocation("minecraft:flowers"))
											.contains((world.getBlockState(new BlockPos(x, y, z - 1))).getBlock())
									&& !BlockTags.getCollection().getTagByID(new ResourceLocation("minecraft:rails"))
											.contains((world.getBlockState(new BlockPos(x, y, z - 1))).getBlock())
									&& !BlockTags.getCollection().getTagByID(new ResourceLocation("minecraft:trapdoors"))
											.contains((world.getBlockState(new BlockPos(x, y, z - 1))).getBlock())
									&& !BlockTags.getCollection().getTagByID(new ResourceLocation("minecraft:unstable_bottom_center"))
											.contains((world.getBlockState(new BlockPos(x, y, z - 1))).getBlock())
									&& !BlockTags.getCollection().getTagByID(new ResourceLocation("minecraft:wall_corals"))
											.contains((world.getBlockState(new BlockPos(x, y, z - 1))).getBlock())
									&& !BlockTags.getCollection().getTagByID(new ResourceLocation("minecraft:wall_signs"))
											.contains((world.getBlockState(new BlockPos(x, y, z - 1))).getBlock())
									&& !BlockTags.getCollection().getTagByID(new ResourceLocation("minecraft:wither_immune"))
											.contains((world.getBlockState(new BlockPos(x, y, z - 1))).getBlock())
									&& !BlockTags.getCollection().getTagByID(new ResourceLocation("minecraft:pressure_plates"))
											.contains((world.getBlockState(new BlockPos(x, y, z - 1))).getBlock())
									&& !BlockTags.getCollection().getTagByID(new ResourceLocation("minecraft:replaceable_plants"))
											.contains((world.getBlockState(new BlockPos(x, y, z - 1))).getBlock())
									&& !BlockTags.getCollection().getTagByID(new ResourceLocation("minecraft:wall_post_override"))
											.contains((world.getBlockState(new BlockPos(x, y, z - 1))).getBlock())
									&& !BlockTags.getCollection().getTagByID(new ResourceLocation("minecraft:underwater_bonemeals"))
											.contains((world.getBlockState(new BlockPos(x, y, z - 1))).getBlock())
									&& !BlockTags.getCollection().getTagByID(new ResourceLocation("minecraft:piglin_repellents"))
											.contains((world.getBlockState(new BlockPos(x, y, z - 1))).getBlock())
									&& !((world.getBlockState(new BlockPos(x, y, z - 1))).getBlock() == Blocks.BROWN_MUSHROOM)
									&& !((world.getBlockState(new BlockPos(x, y, z - 1))).getBlock() == Blocks.RED_MUSHROOM)
									&& !((world.getBlockState(new BlockPos(x, y, z - 1))).getBlock() == Blocks.WARPED_FUNGUS)
									&& !((world.getBlockState(new BlockPos(x, y, z - 1))).getBlock() == Blocks.CRIMSON_FUNGUS)
									&& !((world.getBlockState(new BlockPos(x, y, z - 1))).getBlock() == Blocks.CRIMSON_ROOTS)
									&& !((world.getBlockState(new BlockPos(x, y, z - 1))).getBlock() == Blocks.WARPED_ROOTS)
									&& !((world.getBlockState(new BlockPos(x, y, z - 1))).getBlock() == Blocks.NETHER_SPROUTS)
									&& !((world.getBlockState(new BlockPos(x, y, z - 1))).getBlock() == Blocks.SNOW)
									&& !((world.getBlockState(new BlockPos(x, y, z - 1))).getBlock() == Blocks.TORCH)
									&& !((world.getBlockState(new BlockPos(x, y, z - 1))).getBlock() == Blocks.WALL_TORCH)
									&& !((world.getBlockState(new BlockPos(x, y, z - 1))).getBlock() == Blocks.REDSTONE_TORCH)
									&& !((world.getBlockState(new BlockPos(x, y, z - 1))).getBlock() == Blocks.REDSTONE_WALL_TORCH)
									&& !((world.getBlockState(new BlockPos(x, y, z - 1))).getBlock() == Blocks.REDSTONE_TORCH)
									&& !((world.getBlockState(new BlockPos(x, y, z - 1))).getBlock() == Blocks.BELL)
									&& !((world.getBlockState(new BlockPos(x, y, z - 1))).getBlock() == Blocks.REPEATER)
									&& !((world.getBlockState(new BlockPos(x, y, z - 1))).getBlock() == Blocks.REPEATER)
									&& !((world.getBlockState(new BlockPos(x, y, z - 1))).getBlock() == Blocks.COMPARATOR)
									&& !((world.getBlockState(new BlockPos(x, y, z - 1))).getBlock() == Blocks.COMPARATOR)
									&& !((world.getBlockState(new BlockPos(x, y, z - 1))).getBlock() == Blocks.TRIPWIRE_HOOK)
									&& !((world.getBlockState(new BlockPos(x, y, z - 1))).getBlock() == Blocks.LEVER)
									&& !((world.getBlockState(new BlockPos(x, y, z - 1))).getBlock() == Blocks.REDSTONE_WIRE)
									&& !world.isAirBlock(new BlockPos(x, y, z - 1))
									&& !((world.getBlockState(new BlockPos(x, y, z - 1))).getBlock() == Blocks.GRASS)
									&& !((world.getBlockState(new BlockPos(x, y, z - 1))).getBlock() == Blocks.FERN)
									&& !((world.getBlockState(new BlockPos(x, y, z - 1))).getBlock() == Blocks.DEAD_BUSH)
									&& !((world.getBlockState(new BlockPos(x, y, z - 1))).getBlock() == Blocks.GRASS)
									&& !((world.getBlockState(new BlockPos(x, y, z - 1))).getBlock() == Blocks.SUGAR_CANE)
									&& !((world.getBlockState(new BlockPos(x, y, z - 1))).getBlock() == Blocks.TALL_GRASS)) {
								if (entity instanceof LivingEntity)
									((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.LEVITATION, (int) 3, (int) 2, (false), (false)));
								{
									boolean _setval = (true);
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.WallClimb = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else {
								{
									boolean _setval = (false);
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.WallClimb = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							}
						} else if ((entity.getHorizontalFacing()) == Direction.SOUTH) {
							if (!BlockTags.getCollection().getTagByID(new ResourceLocation("minecraft:all_signs"))
									.contains((world.getBlockState(new BlockPos(x, y, z + 1))).getBlock())
									&& !BlockTags.getCollection().getTagByID(new ResourceLocation("minecraft:banners"))
											.contains((world.getBlockState(new BlockPos(x, y, z + 1))).getBlock())
									&& !BlockTags.getCollection().getTagByID(new ResourceLocation("minecraft:beds"))
											.contains((world.getBlockState(new BlockPos(x, y, z + 1))).getBlock())
									&& !BlockTags.getCollection().getTagByID(new ResourceLocation("minecraft:bee_growables"))
											.contains((world.getBlockState(new BlockPos(x, y, z + 1))).getBlock())
									&& !BlockTags.getCollection().getTagByID(new ResourceLocation("minecraft:buttons"))
											.contains((world.getBlockState(new BlockPos(x, y, z + 1))).getBlock())
									&& !BlockTags.getCollection().getTagByID(new ResourceLocation("minecraft:campfires"))
											.contains((world.getBlockState(new BlockPos(x, y, z + 1))).getBlock())
									&& !BlockTags.getCollection().getTagByID(new ResourceLocation("minecraft:climbable"))
											.contains((world.getBlockState(new BlockPos(x, y, z + 1))).getBlock())
									&& !BlockTags.getCollection().getTagByID(new ResourceLocation("minecraft:crops"))
											.contains((world.getBlockState(new BlockPos(x, y, z + 1))).getBlock())
									&& !BlockTags.getCollection().getTagByID(new ResourceLocation("minecraft:wool_carpets"))
											.contains((world.getBlockState(new BlockPos(x, y, z + 1))).getBlock())
									&& !BlockTags.getCollection().getTagByID(new ResourceLocation("minecraft:fall_damage_resetting"))
											.contains((world.getBlockState(new BlockPos(x, y, z + 1))).getBlock())
									&& !BlockTags.getCollection().getTagByID(new ResourceLocation("minecraft:fence_gates"))
											.contains((world.getBlockState(new BlockPos(x, y, z + 1))).getBlock())
									&& !BlockTags.getCollection().getTagByID(new ResourceLocation("minecraft:fences"))
											.contains((world.getBlockState(new BlockPos(x, y, z + 1))).getBlock())
									&& !BlockTags.getCollection().getTagByID(new ResourceLocation("minecraft:flower_pots"))
											.contains((world.getBlockState(new BlockPos(x, y, z + 1))).getBlock())
									&& !BlockTags.getCollection().getTagByID(new ResourceLocation("minecraft:flowers"))
											.contains((world.getBlockState(new BlockPos(x, y, z + 1))).getBlock())
									&& !BlockTags.getCollection().getTagByID(new ResourceLocation("minecraft:rails"))
											.contains((world.getBlockState(new BlockPos(x, y, z + 1))).getBlock())
									&& !BlockTags.getCollection().getTagByID(new ResourceLocation("minecraft:trapdoors"))
											.contains((world.getBlockState(new BlockPos(x, y, z + 1))).getBlock())
									&& !BlockTags.getCollection().getTagByID(new ResourceLocation("minecraft:unstable_bottom_center"))
											.contains((world.getBlockState(new BlockPos(x, y, z + 1))).getBlock())
									&& !BlockTags.getCollection().getTagByID(new ResourceLocation("minecraft:wall_corals"))
											.contains((world.getBlockState(new BlockPos(x, y, z + 1))).getBlock())
									&& !BlockTags.getCollection().getTagByID(new ResourceLocation("minecraft:wall_signs"))
											.contains((world.getBlockState(new BlockPos(x, y, z + 1))).getBlock())
									&& !BlockTags.getCollection().getTagByID(new ResourceLocation("minecraft:wither_immune"))
											.contains((world.getBlockState(new BlockPos(x, y, z + 1))).getBlock())
									&& !BlockTags.getCollection().getTagByID(new ResourceLocation("minecraft:pressure_plates"))
											.contains((world.getBlockState(new BlockPos(x, y, z + 1))).getBlock())
									&& !BlockTags.getCollection().getTagByID(new ResourceLocation("minecraft:replaceable_plants"))
											.contains((world.getBlockState(new BlockPos(x, y, z + 1))).getBlock())
									&& !BlockTags.getCollection().getTagByID(new ResourceLocation("minecraft:wall_post_override"))
											.contains((world.getBlockState(new BlockPos(x, y, z + 1))).getBlock())
									&& !BlockTags.getCollection().getTagByID(new ResourceLocation("minecraft:underwater_bonemeals"))
											.contains((world.getBlockState(new BlockPos(x, y, z + 1))).getBlock())
									&& !BlockTags.getCollection().getTagByID(new ResourceLocation("minecraft:piglin_repellents"))
											.contains((world.getBlockState(new BlockPos(x, y, z + 1))).getBlock())
									&& !((world.getBlockState(new BlockPos(x, y, z + 1))).getBlock() == Blocks.BROWN_MUSHROOM)
									&& !((world.getBlockState(new BlockPos(x, y, z + 1))).getBlock() == Blocks.RED_MUSHROOM)
									&& !((world.getBlockState(new BlockPos(x, y, z + 1))).getBlock() == Blocks.WARPED_FUNGUS)
									&& !((world.getBlockState(new BlockPos(x, y, z + 1))).getBlock() == Blocks.CRIMSON_FUNGUS)
									&& !((world.getBlockState(new BlockPos(x, y, z + 1))).getBlock() == Blocks.CRIMSON_ROOTS)
									&& !((world.getBlockState(new BlockPos(x, y, z + 1))).getBlock() == Blocks.WARPED_ROOTS)
									&& !((world.getBlockState(new BlockPos(x, y, z + 1))).getBlock() == Blocks.NETHER_SPROUTS)
									&& !((world.getBlockState(new BlockPos(x, y, z + 1))).getBlock() == Blocks.SNOW)
									&& !((world.getBlockState(new BlockPos(x, y, z + 1))).getBlock() == Blocks.TORCH)
									&& !((world.getBlockState(new BlockPos(x, y, z + 1))).getBlock() == Blocks.WALL_TORCH)
									&& !((world.getBlockState(new BlockPos(x, y, z + 1))).getBlock() == Blocks.REDSTONE_TORCH)
									&& !((world.getBlockState(new BlockPos(x, y, z + 1))).getBlock() == Blocks.REDSTONE_WALL_TORCH)
									&& !((world.getBlockState(new BlockPos(x, y, z + 1))).getBlock() == Blocks.REDSTONE_TORCH)
									&& !((world.getBlockState(new BlockPos(x, y, z + 1))).getBlock() == Blocks.BELL)
									&& !((world.getBlockState(new BlockPos(x, y, z + 1))).getBlock() == Blocks.REPEATER)
									&& !((world.getBlockState(new BlockPos(x, y, z + 1))).getBlock() == Blocks.REPEATER)
									&& !((world.getBlockState(new BlockPos(x, y, z + 1))).getBlock() == Blocks.COMPARATOR)
									&& !((world.getBlockState(new BlockPos(x, y, z + 1))).getBlock() == Blocks.COMPARATOR)
									&& !((world.getBlockState(new BlockPos(x, y, z + 1))).getBlock() == Blocks.TRIPWIRE_HOOK)
									&& !((world.getBlockState(new BlockPos(x, y, z + 1))).getBlock() == Blocks.LEVER)
									&& !((world.getBlockState(new BlockPos(x, y, z + 1))).getBlock() == Blocks.REDSTONE_WIRE)
									&& !((world.getBlockState(new BlockPos(x, y, z + 1))).getBlock() == Blocks.TRIPWIRE)
									&& !world.isAirBlock(new BlockPos(x, y, z + 1))
									&& !((world.getBlockState(new BlockPos(x, y, z + 1))).getBlock() == Blocks.GRASS)
									&& !((world.getBlockState(new BlockPos(x, y, z + 1))).getBlock() == Blocks.FERN)
									&& !((world.getBlockState(new BlockPos(x, y, z + 1))).getBlock() == Blocks.GRASS)
									&& !((world.getBlockState(new BlockPos(x, y, z + 1))).getBlock() == Blocks.DEAD_BUSH)
									&& !((world.getBlockState(new BlockPos(x, y, z + 1))).getBlock() == Blocks.SUGAR_CANE)
									&& !((world.getBlockState(new BlockPos(x, y, z + 1))).getBlock() == Blocks.TALL_GRASS)) {
								if (entity instanceof LivingEntity)
									((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.LEVITATION, (int) 3, (int) 2, (false), (false)));
								{
									boolean _setval = (true);
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.WallClimb = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else {
								{
									boolean _setval = (false);
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.WallClimb = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							}
						} else if ((entity.getHorizontalFacing()) == Direction.WEST) {
							if (!BlockTags.getCollection().getTagByID(new ResourceLocation("minecraft:all_signs"))
									.contains((world.getBlockState(new BlockPos(x - 1, y, z))).getBlock())
									&& !BlockTags.getCollection().getTagByID(new ResourceLocation("minecraft:banners"))
											.contains((world.getBlockState(new BlockPos(x - 1, y, z))).getBlock())
									&& !BlockTags.getCollection().getTagByID(new ResourceLocation("minecraft:beds"))
											.contains((world.getBlockState(new BlockPos(x - 1, y, z))).getBlock())
									&& !BlockTags.getCollection().getTagByID(new ResourceLocation("minecraft:bee_growables"))
											.contains((world.getBlockState(new BlockPos(x - 1, y, z))).getBlock())
									&& !BlockTags.getCollection().getTagByID(new ResourceLocation("minecraft:buttons"))
											.contains((world.getBlockState(new BlockPos(x - 1, y, z))).getBlock())
									&& !BlockTags.getCollection().getTagByID(new ResourceLocation("minecraft:campfires"))
											.contains((world.getBlockState(new BlockPos(x - 1, y, z))).getBlock())
									&& !BlockTags.getCollection().getTagByID(new ResourceLocation("minecraft:climbable"))
											.contains((world.getBlockState(new BlockPos(x - 1, y, z))).getBlock())
									&& !BlockTags.getCollection().getTagByID(new ResourceLocation("minecraft:crops"))
											.contains((world.getBlockState(new BlockPos(x - 1, y, z))).getBlock())
									&& !BlockTags.getCollection().getTagByID(new ResourceLocation("minecraft:wool_carpets"))
											.contains((world.getBlockState(new BlockPos(x - 1, y, z))).getBlock())
									&& !BlockTags.getCollection().getTagByID(new ResourceLocation("minecraft:fall_damage_resetting"))
											.contains((world.getBlockState(new BlockPos(x - 1, y, z))).getBlock())
									&& !BlockTags.getCollection().getTagByID(new ResourceLocation("minecraft:fence_gates"))
											.contains((world.getBlockState(new BlockPos(x - 1, y, z))).getBlock())
									&& !BlockTags.getCollection().getTagByID(new ResourceLocation("minecraft:fences"))
											.contains((world.getBlockState(new BlockPos(x - 1, y, z))).getBlock())
									&& !BlockTags.getCollection().getTagByID(new ResourceLocation("minecraft:flower_pots"))
											.contains((world.getBlockState(new BlockPos(x - 1, y, z))).getBlock())
									&& !BlockTags.getCollection().getTagByID(new ResourceLocation("minecraft:flowers"))
											.contains((world.getBlockState(new BlockPos(x - 1, y, z))).getBlock())
									&& !BlockTags.getCollection().getTagByID(new ResourceLocation("minecraft:rails"))
											.contains((world.getBlockState(new BlockPos(x - 1, y, z))).getBlock())
									&& !BlockTags.getCollection().getTagByID(new ResourceLocation("minecraft:trapdoors"))
											.contains((world.getBlockState(new BlockPos(x - 1, y, z))).getBlock())
									&& !BlockTags.getCollection().getTagByID(new ResourceLocation("minecraft:unstable_bottom_center"))
											.contains((world.getBlockState(new BlockPos(x - 1, y, z))).getBlock())
									&& !BlockTags.getCollection().getTagByID(new ResourceLocation("minecraft:wall_corals"))
											.contains((world.getBlockState(new BlockPos(x - 1, y, z))).getBlock())
									&& !BlockTags.getCollection().getTagByID(new ResourceLocation("minecraft:wall_signs"))
											.contains((world.getBlockState(new BlockPos(x - 1, y, z))).getBlock())
									&& !BlockTags.getCollection().getTagByID(new ResourceLocation("minecraft:wither_immune"))
											.contains((world.getBlockState(new BlockPos(x - 1, y, z))).getBlock())
									&& !BlockTags.getCollection().getTagByID(new ResourceLocation("minecraft:pressure_plates"))
											.contains((world.getBlockState(new BlockPos(x - 1, y, z))).getBlock())
									&& !BlockTags.getCollection().getTagByID(new ResourceLocation("minecraft:replaceable_plants"))
											.contains((world.getBlockState(new BlockPos(x - 1, y, z))).getBlock())
									&& !BlockTags.getCollection().getTagByID(new ResourceLocation("minecraft:wall_post_override"))
											.contains((world.getBlockState(new BlockPos(x - 1, y, z))).getBlock())
									&& !BlockTags.getCollection().getTagByID(new ResourceLocation("minecraft:underwater_bonemeals"))
											.contains((world.getBlockState(new BlockPos(x - 1, y, z))).getBlock())
									&& !BlockTags.getCollection().getTagByID(new ResourceLocation("minecraft:piglin_repellents"))
											.contains((world.getBlockState(new BlockPos(x - 1, y, z))).getBlock())
									&& !((world.getBlockState(new BlockPos(x - 1, y, z))).getBlock() == Blocks.BROWN_MUSHROOM)
									&& !((world.getBlockState(new BlockPos(x - 1, y, z))).getBlock() == Blocks.RED_MUSHROOM)
									&& !((world.getBlockState(new BlockPos(x - 1, y, z))).getBlock() == Blocks.WARPED_FUNGUS)
									&& !((world.getBlockState(new BlockPos(x - 1, y, z))).getBlock() == Blocks.CRIMSON_FUNGUS)
									&& !((world.getBlockState(new BlockPos(x - 1, y, z))).getBlock() == Blocks.CRIMSON_ROOTS)
									&& !((world.getBlockState(new BlockPos(x - 1, y, z))).getBlock() == Blocks.WARPED_ROOTS)
									&& !((world.getBlockState(new BlockPos(x - 1, y, z))).getBlock() == Blocks.NETHER_SPROUTS)
									&& !((world.getBlockState(new BlockPos(x - 1, y, z))).getBlock() == Blocks.SNOW)
									&& !((world.getBlockState(new BlockPos(x - 1, y, z))).getBlock() == Blocks.TORCH)
									&& !((world.getBlockState(new BlockPos(x - 1, y, z))).getBlock() == Blocks.WALL_TORCH)
									&& !((world.getBlockState(new BlockPos(x - 1, y, z))).getBlock() == Blocks.REDSTONE_TORCH)
									&& !((world.getBlockState(new BlockPos(x - 1, y, z))).getBlock() == Blocks.REDSTONE_WALL_TORCH)
									&& !((world.getBlockState(new BlockPos(x - 1, y, z))).getBlock() == Blocks.REDSTONE_TORCH)
									&& !((world.getBlockState(new BlockPos(x - 1, y, z))).getBlock() == Blocks.BELL)
									&& !((world.getBlockState(new BlockPos(x - 1, y, z))).getBlock() == Blocks.REPEATER)
									&& !((world.getBlockState(new BlockPos(x - 1, y, z))).getBlock() == Blocks.REPEATER)
									&& !((world.getBlockState(new BlockPos(x - 1, y, z))).getBlock() == Blocks.COMPARATOR)
									&& !((world.getBlockState(new BlockPos(x - 1, y, z))).getBlock() == Blocks.COMPARATOR)
									&& !((world.getBlockState(new BlockPos(x - 1, y, z))).getBlock() == Blocks.TRIPWIRE_HOOK)
									&& !((world.getBlockState(new BlockPos(x - 1, y, z))).getBlock() == Blocks.LEVER)
									&& !((world.getBlockState(new BlockPos(x - 1, y, z))).getBlock() == Blocks.REDSTONE_WIRE)
									&& !((world.getBlockState(new BlockPos(x - 1, y, z))).getBlock() == Blocks.TRIPWIRE)
									&& !world.isAirBlock(new BlockPos(x - 1, y, z))
									&& !((world.getBlockState(new BlockPos(x - 1, y, z))).getBlock() == Blocks.GRASS)
									&& !((world.getBlockState(new BlockPos(x - 1, y, z))).getBlock() == Blocks.FERN)
									&& !((world.getBlockState(new BlockPos(x - 1, y, z))).getBlock() == Blocks.GRASS)
									&& !((world.getBlockState(new BlockPos(x - 1, y, z))).getBlock() == Blocks.DEAD_BUSH)
									&& !((world.getBlockState(new BlockPos(x - 1, y, z))).getBlock() == Blocks.SUGAR_CANE)
									&& !((world.getBlockState(new BlockPos(x - 1, y, z))).getBlock() == Blocks.TALL_GRASS)) {
								if (entity instanceof LivingEntity)
									((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.LEVITATION, (int) 3, (int) 2, (false), (false)));
								{
									boolean _setval = (true);
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.WallClimb = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else {
								{
									boolean _setval = (false);
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.WallClimb = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							}
						} else if ((entity.getHorizontalFacing()) == Direction.EAST) {
							if (!BlockTags.getCollection().getTagByID(new ResourceLocation("minecraft:all_signs"))
									.contains((world.getBlockState(new BlockPos(x + 1, y, z))).getBlock())
									&& !BlockTags.getCollection().getTagByID(new ResourceLocation("minecraft:banners"))
											.contains((world.getBlockState(new BlockPos(x + 1, y, z))).getBlock())
									&& !BlockTags.getCollection().getTagByID(new ResourceLocation("minecraft:beds"))
											.contains((world.getBlockState(new BlockPos(x + 1, y, z))).getBlock())
									&& !BlockTags.getCollection().getTagByID(new ResourceLocation("minecraft:bee_growables"))
											.contains((world.getBlockState(new BlockPos(x + 1, y, z))).getBlock())
									&& !BlockTags.getCollection().getTagByID(new ResourceLocation("minecraft:buttons"))
											.contains((world.getBlockState(new BlockPos(x + 1, y, z))).getBlock())
									&& !BlockTags.getCollection().getTagByID(new ResourceLocation("minecraft:campfires"))
											.contains((world.getBlockState(new BlockPos(x + 1, y, z))).getBlock())
									&& !BlockTags.getCollection().getTagByID(new ResourceLocation("minecraft:climbable"))
											.contains((world.getBlockState(new BlockPos(x + 1, y, z))).getBlock())
									&& !BlockTags.getCollection().getTagByID(new ResourceLocation("minecraft:crops"))
											.contains((world.getBlockState(new BlockPos(x + 1, y, z))).getBlock())
									&& !BlockTags.getCollection().getTagByID(new ResourceLocation("minecraft:wool_carpets"))
											.contains((world.getBlockState(new BlockPos(x + 1, y, z))).getBlock())
									&& !BlockTags.getCollection().getTagByID(new ResourceLocation("minecraft:fall_damage_resetting"))
											.contains((world.getBlockState(new BlockPos(x + 1, y, z))).getBlock())
									&& !BlockTags.getCollection().getTagByID(new ResourceLocation("minecraft:fence_gates"))
											.contains((world.getBlockState(new BlockPos(x + 1, y, z))).getBlock())
									&& !BlockTags.getCollection().getTagByID(new ResourceLocation("minecraft:fences"))
											.contains((world.getBlockState(new BlockPos(x + 1, y, z))).getBlock())
									&& !BlockTags.getCollection().getTagByID(new ResourceLocation("minecraft:flower_pots"))
											.contains((world.getBlockState(new BlockPos(x + 1, y, z))).getBlock())
									&& !BlockTags.getCollection().getTagByID(new ResourceLocation("minecraft:flowers"))
											.contains((world.getBlockState(new BlockPos(x + 1, y, z))).getBlock())
									&& !BlockTags.getCollection().getTagByID(new ResourceLocation("minecraft:rails"))
											.contains((world.getBlockState(new BlockPos(x + 1, y, z))).getBlock())
									&& !BlockTags.getCollection().getTagByID(new ResourceLocation("minecraft:trapdoors"))
											.contains((world.getBlockState(new BlockPos(x + 1, y, z))).getBlock())
									&& !BlockTags.getCollection().getTagByID(new ResourceLocation("minecraft:unstable_bottom_center"))
											.contains((world.getBlockState(new BlockPos(x + 1, y, z))).getBlock())
									&& !BlockTags.getCollection().getTagByID(new ResourceLocation("minecraft:wall_corals"))
											.contains((world.getBlockState(new BlockPos(x + 1, y, z))).getBlock())
									&& !BlockTags.getCollection().getTagByID(new ResourceLocation("minecraft:wall_signs"))
											.contains((world.getBlockState(new BlockPos(x + 1, y, z))).getBlock())
									&& !BlockTags.getCollection().getTagByID(new ResourceLocation("minecraft:wither_immune"))
											.contains((world.getBlockState(new BlockPos(x + 1, y, z))).getBlock())
									&& !BlockTags.getCollection().getTagByID(new ResourceLocation("minecraft:pressure_plates"))
											.contains((world.getBlockState(new BlockPos(x + 1, y, z))).getBlock())
									&& !BlockTags.getCollection().getTagByID(new ResourceLocation("minecraft:replaceable_plants"))
											.contains((world.getBlockState(new BlockPos(x + 1, y, z))).getBlock())
									&& !BlockTags.getCollection().getTagByID(new ResourceLocation("minecraft:wall_post_override"))
											.contains((world.getBlockState(new BlockPos(x + 1, y, z))).getBlock())
									&& !BlockTags.getCollection().getTagByID(new ResourceLocation("minecraft:underwater_bonemeals"))
											.contains((world.getBlockState(new BlockPos(x + 1, y, z))).getBlock())
									&& !BlockTags.getCollection().getTagByID(new ResourceLocation("minecraft:piglin_repellents"))
											.contains((world.getBlockState(new BlockPos(x + 1, y, z))).getBlock())
									&& !((world.getBlockState(new BlockPos(x + 1, y, z))).getBlock() == Blocks.BROWN_MUSHROOM)
									&& !((world.getBlockState(new BlockPos(x + 1, y, z))).getBlock() == Blocks.RED_MUSHROOM)
									&& !((world.getBlockState(new BlockPos(x + 1, y, z))).getBlock() == Blocks.WARPED_FUNGUS)
									&& !((world.getBlockState(new BlockPos(x + 1, y, z))).getBlock() == Blocks.CRIMSON_FUNGUS)
									&& !((world.getBlockState(new BlockPos(x + 1, y, z))).getBlock() == Blocks.CRIMSON_ROOTS)
									&& !((world.getBlockState(new BlockPos(x + 1, y, z))).getBlock() == Blocks.WARPED_ROOTS)
									&& !((world.getBlockState(new BlockPos(x + 1, y, z))).getBlock() == Blocks.NETHER_SPROUTS)
									&& !((world.getBlockState(new BlockPos(x + 1, y, z))).getBlock() == Blocks.SNOW)
									&& !((world.getBlockState(new BlockPos(x + 1, y, z))).getBlock() == Blocks.TORCH)
									&& !((world.getBlockState(new BlockPos(x + 1, y, z))).getBlock() == Blocks.WALL_TORCH)
									&& !((world.getBlockState(new BlockPos(x + 1, y, z))).getBlock() == Blocks.REDSTONE_TORCH)
									&& !((world.getBlockState(new BlockPos(x + 1, y, z))).getBlock() == Blocks.REDSTONE_WALL_TORCH)
									&& !((world.getBlockState(new BlockPos(x + 1, y, z))).getBlock() == Blocks.REDSTONE_TORCH)
									&& !((world.getBlockState(new BlockPos(x + 1, y, z))).getBlock() == Blocks.BELL)
									&& !((world.getBlockState(new BlockPos(x + 1, y, z))).getBlock() == Blocks.REPEATER)
									&& !((world.getBlockState(new BlockPos(x + 1, y, z))).getBlock() == Blocks.REPEATER)
									&& !((world.getBlockState(new BlockPos(x + 1, y, z))).getBlock() == Blocks.COMPARATOR)
									&& !((world.getBlockState(new BlockPos(x + 1, y, z))).getBlock() == Blocks.COMPARATOR)
									&& !((world.getBlockState(new BlockPos(x + 1, y, z))).getBlock() == Blocks.TRIPWIRE_HOOK)
									&& !((world.getBlockState(new BlockPos(x + 1, y, z))).getBlock() == Blocks.LEVER)
									&& !((world.getBlockState(new BlockPos(x + 1, y, z))).getBlock() == Blocks.REDSTONE_WIRE)
									&& !((world.getBlockState(new BlockPos(x + 1, y, z))).getBlock() == Blocks.TRIPWIRE)
									&& !world.isAirBlock(new BlockPos(x + 1, y, z))
									&& !((world.getBlockState(new BlockPos(x + 1, y, z))).getBlock() == Blocks.GRASS)
									&& !((world.getBlockState(new BlockPos(x + 1, y, z))).getBlock() == Blocks.FERN)
									&& !((world.getBlockState(new BlockPos(x + 1, y, z))).getBlock() == Blocks.GRASS)
									&& !((world.getBlockState(new BlockPos(x + 1, y, z))).getBlock() == Blocks.DEAD_BUSH)
									&& !((world.getBlockState(new BlockPos(x + 1, y, z))).getBlock() == Blocks.SUGAR_CANE)
									&& !((world.getBlockState(new BlockPos(x + 1, y, z))).getBlock() == Blocks.TALL_GRASS)) {
								if (entity instanceof LivingEntity)
									((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.LEVITATION, (int) 3, (int) 2, (false), (false)));
								{
									boolean _setval = (true);
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.WallClimb = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else {
								{
									boolean _setval = (false);
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
		@Mod.EventBusSubscriber
		private static class GlobalTrigger {
			@SubscribeEvent
			public static void onEntityAttacked(LivingAttackEvent event) {
				if (event != null && event.getEntity() != null) {
					Entity entity = event.getEntity();
					Entity sourceentity = event.getSource().getTrueSource();
					Entity immediatesourceentity = event.getSource().getImmediateSource();
					double i = entity.getPosX();
					double j = entity.getPosY();
					double k = entity.getPosZ();
					double amount = event.getAmount();
					World world = entity.world;
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
			if (entity instanceof PlayerEntity) {
				if (NarutoShippudenModVariables.get(entity).DanceOfTheLarch == true) {
					sourceentity.attackEntityFrom(DamageSource.GENERIC, (float) 5);
				}
			}
			if (entity instanceof PlayerEntity) {
				if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage >= 1) {
					if (NarutoShippudenModVariables.get(entity).AmaterasuSusano == true) {
						if (sourceentity instanceof PlayerEntity) {
							if (NarutoShippudenModVariables.get(sourceentity).mangekyousharingansasukeamaterasulearn == 0) {
								if (NarutoShippudenModVariables.get(sourceentity).MangekyouSharinganSasuke == false
										&& NarutoShippudenModVariables.get(sourceentity).MangekyouSharinganItachi == false) {
									sourceentity.getPersistentData().putBoolean("Amaterasu", (true));
									if (sourceentity instanceof LivingEntity)
										((LivingEntity) sourceentity)
												.addPotionEffect(new EffectInstance(Effects.WITHER, (int) 999999, (int) 3, (false), (false)));
									sourceentity.attackEntityFrom(DamageSource.WITHER, (float) 5);
								}
							}
						} else if (!(sourceentity instanceof PlayerEntity)) {
							if (NarutoShippudenModVariables.get(sourceentity).mangekyousharingansasukeamaterasulearn == 0) {
								if (NarutoShippudenModVariables.get(sourceentity).MangekyouSharinganSasuke == false
										&& NarutoShippudenModVariables.get(sourceentity).MangekyouSharinganItachi == false) {
									if (sourceentity instanceof LivingEntity)
										((LivingEntity) sourceentity)
												.addPotionEffect(new EffectInstance(Effects.WITHER, (int) 999999, (int) 3, (false), (false)));
									sourceentity.attackEntityFrom(DamageSource.WITHER, (float) 5);
								}
							}
						}
					}
				}
			}
			if (entity instanceof PlayerEntity) {
				if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
						.getItem() == GunbaiBlockItem.block
						|| ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
								.getItem() == GunbaiBlockItem.block) {
					if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
							.getItem() == GunbaiBlockItem.block) {
						if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
								.getBoolean("defense") == true) {
							copy = ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY);
							{
								CompoundNBT _nbtTag = (copy).getTag();
								if (_nbtTag != null)
									(NarutoShippudenModVariables.get(entity).gunbaicopy).setTag(_nbtTag.copy());
							}
							if (entity instanceof LivingEntity) {
								ItemStack _setstack = (NarutoShippudenModVariables.get(entity).gunbaicopy);
								_setstack.setCount((int) 1);
								((LivingEntity) entity).setHeldItem(Hand.MAIN_HAND, _setstack);
								if (entity instanceof ServerPlayerEntity)
									((ServerPlayerEntity) entity).inventory.markDirty();
							}
							((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
									.putBoolean("defense", (false));
							if (entity instanceof PlayerEntity)
								((PlayerEntity) entity).getCooldownTracker().setCooldown(
										((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem(),
										(int) 300);
							if (dependencies.get("event") != null) {
								Object _obj = dependencies.get("event");
								if (_obj instanceof Event) {
									Event _evt = (Event) _obj;
									if (_evt.isCancelable())
										_evt.setCanceled(true);
								}
							}
						}
					} else if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
							.getItem() == GunbaiBlockItem.block) {
						if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY).getOrCreateTag()
								.getBoolean("defense") == true) {
							copy = ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY);
							{
								CompoundNBT _nbtTag = (copy).getTag();
								if (_nbtTag != null)
									(NarutoShippudenModVariables.get(entity).gunbaicopy).setTag(_nbtTag.copy());
							}
							if (entity instanceof LivingEntity) {
								ItemStack _setstack = (NarutoShippudenModVariables.get(entity).gunbaicopy);
								_setstack.setCount((int) 1);
								((LivingEntity) entity).setHeldItem(Hand.OFF_HAND, _setstack);
								if (entity instanceof ServerPlayerEntity)
									((ServerPlayerEntity) entity).inventory.markDirty();
							}
							((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY).getOrCreateTag()
									.putBoolean("defense", (false));
							if (entity instanceof PlayerEntity)
								((PlayerEntity) entity).getCooldownTracker().setCooldown(
										((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY).getItem(),
										(int) 300);
							if (dependencies.get("event") != null) {
								Object _obj = dependencies.get("event");
								if (_obj instanceof Event) {
									Event _evt = (Event) _obj;
									if (_evt.isCancelable())
										_evt.setCanceled(true);
								}
							}
						}
					}
				}
			}
		}
	}

	public static class PlayerDrinksMilkProcedure {
		@Mod.EventBusSubscriber
		private static class GlobalTrigger {
			@SubscribeEvent
			public static void onUseItemStart(LivingEntityUseItemEvent.Finish event) {
				if (event != null && event.getEntity() != null) {
					Entity entity = event.getEntity();
					double i = entity.getPosX();
					double j = entity.getPosY();
					double k = entity.getPosZ();
					double duration = event.getDuration();
					ItemStack itemstack = event.getItem();
					World world = entity.world;
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
				if (entity.getPersistentData().getBoolean("Amaterasu") == true) {
					if (entity instanceof LivingEntity)
						((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.WITHER, (int) 999999, (int) 3, (false), (false)));
				}
			}
		}
	}

	public static class PlayerJoinTheWorldProcedure {
		@Mod.EventBusSubscriber
		private static class GlobalTrigger {
			@SubscribeEvent
			public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
				Entity entity = event.getPlayer();
				Map<String, Object> dependencies = new HashMap<>();
				dependencies.put("x", entity.getPosX());
				dependencies.put("y", entity.getPosY());
				dependencies.put("z", entity.getPosZ());
				dependencies.put("world", entity.world);
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
			IWorld world = (IWorld) dependencies.get("world");
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
								if (_ent instanceof ServerPlayerEntity) {
									BlockPos _bpos = new BlockPos(x, y, z);
									NetworkHooks.openGui((ServerPlayerEntity) _ent, new INamedContainerProvider() {
										@Override
										public ITextComponent getDisplayName() {
											return new StringTextComponent("StatSelect");
										}

										@Override
										public Container createMenu(int id, PlayerInventory inventory, PlayerEntity player) {
											return new StatSelectGui.GuiContainerMod(id, inventory,
													new PacketBuffer(Unpooled.buffer()).writeBlockPos(_bpos));
										}
									}, _bpos);
								}
							}
						} else if (mainjsonobject.get("clan_random").getAsBoolean() == true) {
							if (entity instanceof PlayerEntity) {
								ItemStack _setstack = new ItemStack(ChakraPaperItem.block);
								_setstack.setCount((int) 1);
								ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
							}
							if (entity instanceof PlayerEntity) {
								ItemStack _setstack = new ItemStack(ClanPaperItem.block);
								_setstack.setCount((int) 1);
								ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
							}
							Random = (MathHelper.nextInt(new Random(), 1, 1000));
							if (Random <= mainjsonobject.get("kekkei_genkai_spawn_chance").getAsDouble() * 10) {
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Looks like you were borned with Kekkei Genkai."),
											(true));
								}
								randomkkg = (MathHelper.nextInt(new Random(), 1, 11));
								if (randomkkg == 1) {
									if (entity instanceof PlayerEntity) {
										ItemStack _setstack = new ItemStack(SmokeReleaseItem.block);
										_setstack.setCount((int) 1);
										ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
									}
									{
										boolean _setval = (true);
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.smokereleaselogic = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (randomkkg == 2) {
									if (entity instanceof PlayerEntity) {
										ItemStack _setstack = new ItemStack(MagnetReleaseItem.block);
										_setstack.setCount((int) 1);
										ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
									}
									{
										boolean _setval = (true);
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.magnetreleaselogic = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (randomkkg == 3) {
									if (entity instanceof PlayerEntity) {
										ItemStack _setstack = new ItemStack(StormReleaseItem.block);
										_setstack.setCount((int) 1);
										ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
									}
									{
										boolean _setval = (true);
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.stormreleaselogic = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (randomkkg == 4) {
									if (entity instanceof PlayerEntity) {
										ItemStack _setstack = new ItemStack(WoodReleaseItem.block);
										_setstack.setCount((int) 1);
										ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
									}
									{
										boolean _setval = (true);
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.woodreleaselogic = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (randomkkg == 5) {
									if (entity instanceof PlayerEntity) {
										ItemStack _setstack = new ItemStack(IceReleaseItem.block);
										_setstack.setCount((int) 1);
										ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
									}
									{
										boolean _setval = (true);
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.icereleaselogic = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (randomkkg == 6) {
									if (entity instanceof PlayerEntity) {
										ItemStack _setstack = new ItemStack(BoneReleaseItem.block);
										_setstack.setCount((int) 1);
										ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
									}
									{
										boolean _setval = (true);
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.bonereleaselogic = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (randomkkg == 7) {
									if (entity instanceof PlayerEntity) {
										ItemStack _setstack = new ItemStack(TyphoonReleaseItem.block);
										_setstack.setCount((int) 1);
										ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
									}
									{
										boolean _setval = (true);
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.typhoonreleaslogic = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (randomkkg == 8) {
									if (entity instanceof PlayerEntity) {
										ItemStack _setstack = new ItemStack(SwiftReleaseItem.block);
										_setstack.setCount((int) 1);
										ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
									}
									{
										boolean _setval = (true);
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.swiftreleaselogic = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (randomkkg == 9) {
									if (entity instanceof PlayerEntity) {
										ItemStack _setstack = new ItemStack(BoilReleaseItem.block);
										_setstack.setCount((int) 1);
										ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
									}
									{
										boolean _setval = (true);
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.boilreleaselogic = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (randomkkg == 10) {
									if (entity instanceof PlayerEntity) {
										ItemStack _setstack = new ItemStack(DustReleaseItem.block);
										_setstack.setCount((int) 1);
										ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
									}
									{
										boolean _setval = (true);
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.dustreleaselogic = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (randomkkg == 11) {
									if (entity instanceof PlayerEntity) {
										ItemStack _setstack = new ItemStack(SteelReleaseItem.block);
										_setstack.setCount((int) 1);
										ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
									}
									{
										boolean _setval = (true);
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.steelreleaselogic = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								}
							}
						}
						if (world instanceof World) {
							((World) world).getGameRules().get(GameRules.KEEP_INVENTORY).set((true), ((World) world).getServer());
						}
						if (world instanceof World) {
							((World) world).getGameRules().get(GameRules.FALL_DAMAGE).set((false), ((World) world).getServer());
						}
						if (entity instanceof PlayerEntity) {
							ItemStack _setstack = new ItemStack(IchirakuRamenItem.block);
							_setstack.setCount((int) 16);
							ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
						}
						if (entity instanceof PlayerEntity) {
							ItemStack _setstack = new ItemStack(StoryModeItem.block);
							_setstack.setCount((int) 1);
							ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
						}
						{
							boolean _setval = (true);
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.joinworld = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							String _setval = (entity.getDisplayName().getString());
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.player_name = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						PlayerName = (entity.getDisplayName().getString());
					} else if (NarutoShippudenModVariables.get(entity).joinworld == true) {
						if (world instanceof World) {
							((World) world).getGameRules().get(GameRules.KEEP_INVENTORY).set((true), ((World) world).getServer());
						}
						if (world instanceof World) {
							((World) world).getGameRules().get(GameRules.FALL_DAMAGE).set((false), ((World) world).getServer());
						}
					}
					if ((entity.getDisplayName().getString()).equals("BoxDeity")) {
						{
							boolean _setval = (true);
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.BoxDeity = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							String _setval = "Voltic Mode";
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.DojutsuSelectResize = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
					if ((entity.getDisplayName().getString()).equals("TheSirMarcus")) {
						{
							boolean _setval = (true);
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.TheSirMarcus = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							String _setval = "Furamingogan";
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
		@Mod.EventBusSubscriber
		private static class GlobalTrigger {
			@SubscribeEvent
			public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
				Entity entity = event.getPlayer();
				Map<String, Object> dependencies = new HashMap<>();
				dependencies.put("x", entity.getPosX());
				dependencies.put("y", entity.getPosY());
				dependencies.put("z", entity.getPosZ());
				dependencies.put("world", entity.world);
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
		@Mod.EventBusSubscriber
		private static class GlobalTrigger {
			@OnlyIn(Dist.CLIENT)
			@SubscribeEvent
			public static void KleidersRenderEvent(RenderLivingEvent event) {
				Entity entity = event.getEntity();
				World world = entity.world;
				double i = entity.getPosX();
				double j = entity.getPosY();
				double k = entity.getPosZ();
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
				if (_evt.getRenderer() instanceof PlayerRenderer) {
					if (_evt instanceof RenderLivingEvent.Pre) {
						_evt.setCanceled(true);
					}
					ModelSwapRenderers.renderPlayerAs(_evt, "naruto_shippuden:textures/entities/two_head_akamaru.png", TwoHeadAkamaruRenderer.ModelTwo_Head_Akamaru::new);
				}
			}
			if (NarutoShippudenModVariables.get(entity).inuzuka_mode == 2) {
				if (_evt.getRenderer() instanceof PlayerRenderer) {
					if (_evt instanceof RenderLivingEvent.Pre) {
						_evt.setCanceled(true);
					}
					ModelSwapRenderers.renderPlayerAs(_evt, "naruto_shippuden:textures/entities/two_head_akamaru.png", ThreeHeadAkamaruRenderer.ModelThree_Head_Akamaru::new);
				}
			}
			if (NarutoShippudenModVariables.get(entity).PassingFang == true) {
				if (_evt.getRenderer() instanceof PlayerRenderer) {
					if (_evt instanceof RenderLivingEvent.Pre) {
						_evt.setCanceled(true);
					}
					ModelSwapRenderers.renderPlayerAs(_evt, "naruto_shippuden:textures/entities/passing_fang.png", FangRenderer.Modelfang::new);
				}
			}
			if (NarutoShippudenModVariables.get(entity).tenromode == true) {
				if (_evt.getRenderer() instanceof PlayerRenderer) {
					if (_evt instanceof RenderLivingEvent.Pre) {
						_evt.setCanceled(true);
					}
					ModelSwapRenderers.renderPlayerAs(_evt, "naruto_shippuden:textures/entities/wolf.png", WolfRenderer.Modelwolf::new);
				}
			}
			if (NarutoShippudenModVariables.get(entity).izunochakramode == true) {
				if (entity.isSneaking()) {
					if (_evt.getRenderer() instanceof PlayerRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						ModelSwapRenderers.renderPlayerAs(_evt, "naruto_shippuden:textures/entities/catchakramode.png", CatChakraModeSneakRenderer.Modelcatchakramodesneak::new);
					}
				} else if (!entity.isSneaking()) {
					if (_evt.getRenderer() instanceof PlayerRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						ModelSwapRenderers.renderPlayerAs(_evt, "naruto_shippuden:textures/entities/catchakramode.png", CatChakraModeRenderer.Modelcatchakramode::new);
					}
				}
			}
			if (NarutoShippudenModVariables.get(entity).izunocat == true) {
				if (_evt.getRenderer() instanceof PlayerRenderer) {
					if (_evt instanceof RenderLivingEvent.Pre) {
						_evt.setCanceled(true);
					}
					ModelSwapRenderers.renderPlayerAs(_evt, "naruto_shippuden:textures/entities/monstercat.png", MonsterCatRenderer.Modelmonstercat::new);
				}
			}
			if (entity.getPersistentData().getBoolean("mirror") == true) {
				if (!ModelSwapRenderers.isOwnRenderer(_evt.getRenderer())) {
					if (_evt instanceof RenderLivingEvent.Pre) {
						//  _evt.setCanceled(true); 
					}
					ModelSwapRenderers.renderMobAs(_evt, "naruto_shippuden:textures/entities/mirror.png", IceMirrorRenderer.Modelice_mirror::new);
				}
			}
			if (NarutoShippudenModVariables.get(entity).ice_mirror == true) {
				if (_evt.getRenderer() instanceof PlayerRenderer) {
					if (_evt instanceof RenderLivingEvent.Pre) {
						//  _evt.setCanceled(true); 
					}
					ModelSwapRenderers.renderPlayerAs(_evt, "naruto_shippuden:textures/entities/mirror.png", IceMirrorRenderer.Modelice_mirror::new);
				}
			}
			if (entity.getPersistentData().getBoolean("waterblob") == true) {
				if (!ModelSwapRenderers.isOwnRenderer(_evt.getRenderer())) {
					if (_evt instanceof RenderLivingEvent.Pre) {
						//  _evt.setCanceled(true); 
					}
					ModelSwapRenderers.renderMobAs(_evt, "naruto_shippuden:textures/entities/drowning_water_blob_technique.png", DrowningWaterBlobTechniqueEntityRenderer.ModelDrowning_Water_Blob_Technique::new);
				}
			}
			if (NarutoShippudenModVariables.get(entity).waterblob == true) {
				if (entity.isSneaking()) {
					if (_evt.getRenderer() instanceof PlayerRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						ModelSwapRenderers.renderPlayerAs(_evt, "naruto_shippuden:textures/entities/drowning_water_blob_technique.png", DrowningWaterBlobTechniqueEntitySneakRenderer.ModelDrowning_Water_Blob_Technique_Sneak::new);
					}
				} else if (!entity.isSneaking()) {
					if (_evt.getRenderer() instanceof PlayerRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						ModelSwapRenderers.renderPlayerAs(_evt, "naruto_shippuden:textures/entities/drowning_water_blob_technique.png", DrowningWaterBlobTechniqueEntityRenderer.ModelDrowning_Water_Blob_Technique::new);
					}
				}
			}
			if (NarutoShippudenModVariables.get(entity).DanceOfTheLarch == true) {
				if (entity.isSneaking()) {
					if (_evt.getRenderer() instanceof PlayerRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						ModelSwapRenderers.renderPlayerAs(_evt, "naruto_shippuden:textures/entities/bone.png", DanceoftheLarchSneakRenderer.ModelDance_of_the_Larch_Sneak::new);
					}
				} else if (!entity.isSneaking()) {
					if (_evt.getRenderer() instanceof PlayerRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						ModelSwapRenderers.renderPlayerAs(_evt, "naruto_shippuden:textures/entities/bone.png", DanceOfTheLarchRenderer.ModelDance_of_the_Larch::new);
					}
				}
			}
			if (NarutoShippudenModVariables.get(entity).hoshigakireleaselogic == true) {
				if (_evt.getRenderer() instanceof PlayerRenderer) {
					if (_evt instanceof RenderLivingEvent.Pre) {
						//  _evt.setCanceled(true); 
					}
					ModelSwapRenderers.renderDojutsu(_evt, "naruto_shippuden:textures/face_paint/hoshigaki.png");
				}
			}
			if (NarutoShippudenModVariables.get(entity).magnet_coat == 1) {
				if (entity.isSneaking()) {
					if (_evt.getRenderer() instanceof PlayerRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						ModelSwapRenderers.renderPlayerAs(_evt, "naruto_shippuden:textures/entities/iron_sand.png", MagnetCoatSneakRenderer.ModelBlack_Iron_Sand_Coat_Sneak::new);
					}
				} else if (!entity.isSneaking()) {
					if (_evt.getRenderer() instanceof PlayerRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						ModelSwapRenderers.renderPlayerAs(_evt, "naruto_shippuden:textures/entities/iron_sand.png", MagnetCoatRenderer.ModelBlack_Iron_Sand_Coat::new);
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).magnet_coat == 2) {
				if (entity.isSneaking()) {
					if (_evt.getRenderer() instanceof PlayerRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						ModelSwapRenderers.renderPlayerAs(_evt, "naruto_shippuden:textures/entities/iron_sand.png", MagnetHandsSneakRenderer.ModelBlack_Iron_Sand_Hand_Sneak::new);
					}
				} else if (!entity.isSneaking()) {
					if (_evt.getRenderer() instanceof PlayerRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						ModelSwapRenderers.renderPlayerAs(_evt, "naruto_shippuden:textures/entities/iron_sand.png", MagnetHandsRenderer.ModelBlack_Iron_Sand_Hand::new);
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).magnet_coat == 3) {
				if (_evt.getRenderer() instanceof PlayerRenderer) {
					if (_evt instanceof RenderLivingEvent.Pre) {
						//  _evt.setCanceled(true); 
					}
					ModelSwapRenderers.renderPlayerAs(_evt, "naruto_shippuden:textures/entities/iron_sand.png", MagnetWingsRenderer.ModelBlack_Iron_Sand_Wings::new);
				}
			}
			if (NarutoShippudenModVariables.get(entity).deathgod == true) {
				if (_evt.getRenderer() instanceof PlayerRenderer) {
					if (_evt instanceof RenderLivingEvent.Pre) {
						//  _evt.setCanceled(true); 
					}
					ModelSwapRenderers.renderPlayerAs(_evt, "naruto_shippuden:textures/entities/dead_demon_consuming_seal.png", DeadDemonConsumingSealRenderer.ModelDead_Demon_Consuming_Seal::new);
				}
			}
			if (NarutoShippudenModVariables.get(entity).EightTrigramsPalmsRevolvingHeaven == true) {
				if (_evt.getRenderer() instanceof PlayerRenderer) {
					if (_evt instanceof RenderLivingEvent.Pre) {
						_evt.setCanceled(true);
					}
					ModelSwapRenderers.renderPlayerAs(_evt, "naruto_shippuden:textures/entities/eight_trigrams_palms_revolving_heaven.png", EightTrigramsPalmsRevolvingHeavenRenderer.Modeleight_trigrams_palms_revolving_heaven::new);
				}
			}
			if (NarutoShippudenModVariables.get(entity).InsectJarTechnique == true) {
				if (_evt.getRenderer() instanceof PlayerRenderer) {
					if (_evt instanceof RenderLivingEvent.Pre) {
						_evt.setCanceled(true);
					}
					ModelSwapRenderers.renderPlayerAs(_evt, "naruto_shippuden:textures/entities/bugs.png", InsectJarTechniqueRenderer.Modeleight_trigrams_palms_revolving_heaven::new);
				}
			}
			if (NarutoShippudenModVariables.get(entity).HumanBulletTank == true) {
				if (_evt.getRenderer() instanceof PlayerRenderer) {
					if (_evt instanceof RenderLivingEvent.Pre) {
						_evt.setCanceled(true);
					}
					ModelSwapRenderers.renderPlayerAs(_evt, "naruto_shippuden:textures/entities/human_bullet_tank.png", HumanBulletTankRenderer.ModelHuman_Bullet_Tank::new);
				}
			}
			if (NarutoShippudenModVariables.get(entity).SpikedHumanBulletTank == true) {
				if (_evt.getRenderer() instanceof PlayerRenderer) {
					if (_evt instanceof RenderLivingEvent.Pre) {
						_evt.setCanceled(true);
					}
					ModelSwapRenderers.renderPlayerAs(_evt, "naruto_shippuden:textures/entities/spiked_human_bullet_tank.png", SpikedHumanBulletTankRenderer.Modelspiked_human_bullet_tank::new);
				}
			}
			if (NarutoShippudenModVariables.get(entity).ButterflyMode == true) {
				if ((NarutoShippudenModVariables.get(entity).ButterFlyModeColor).equals("Blue")) {
					if (_evt.getRenderer() instanceof PlayerRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						ModelSwapRenderers.renderPlayerAs(_evt, "naruto_shippuden:textures/entities/akimichi_butterfly_blue.png", ButterflyModeRenderer.ModelButterflyMode::new);
					}
				} else if ((NarutoShippudenModVariables.get(entity).ButterFlyModeColor).equals("Green")) {
					if (_evt.getRenderer() instanceof PlayerRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						ModelSwapRenderers.renderPlayerAs(_evt, "naruto_shippuden:textures/entities/akimichi_butterfly_green.png", ButterflyModeRenderer.ModelButterflyMode::new);
					}
				} else if ((NarutoShippudenModVariables.get(entity).ButterFlyModeColor).equals("Orange")) {
					if (_evt.getRenderer() instanceof PlayerRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						ModelSwapRenderers.renderPlayerAs(_evt, "naruto_shippuden:textures/entities/akimichi_butterfly_orange.png", ButterflyModeRenderer.ModelButterflyMode::new);
					}
				} else if ((NarutoShippudenModVariables.get(entity).ButterFlyModeColor).equals("Pink")) {
					if (_evt.getRenderer() instanceof PlayerRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						ModelSwapRenderers.renderPlayerAs(_evt, "naruto_shippuden:textures/entities/akimichi_butterfly_pink.png", ButterflyModeRenderer.ModelButterflyMode::new);
					}
				} else if ((NarutoShippudenModVariables.get(entity).ButterFlyModeColor).equals("Purple")) {
					if (_evt.getRenderer() instanceof PlayerRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						ModelSwapRenderers.renderPlayerAs(_evt, "naruto_shippuden:textures/entities/akimichi_butterfly_purple.png", ButterflyModeRenderer.ModelButterflyMode::new);
					}
				} else if ((NarutoShippudenModVariables.get(entity).ButterFlyModeColor).equals("Red")) {
					if (_evt.getRenderer() instanceof PlayerRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						ModelSwapRenderers.renderPlayerAs(_evt, "naruto_shippuden:textures/entities/akimichi_butterfly_red.png", ButterflyModeRenderer.ModelButterflyMode::new);
					}
				} else if ((NarutoShippudenModVariables.get(entity).ButterFlyModeColor).equals("Yellow")) {
					if (_evt.getRenderer() instanceof PlayerRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						ModelSwapRenderers.renderPlayerAs(_evt, "naruto_shippuden:textures/entities/akimichi_butterfly_yellow.png", ButterflyModeRenderer.ModelButterflyMode::new);
					}
				}
			}
			if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 1) {
				if (NarutoShippudenModVariables.get(entity).MangekyouSharinganSasuke == true) {
					if (_evt.getRenderer() instanceof PlayerRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						ModelSwapRenderers.renderPlayerAs(_evt, "naruto_shippuden:textures/susano/susano_sasuke.png", RibcageSusanoRenderer.Modelribcage::new);
					}
				} else if (NarutoShippudenModVariables.get(entity).MangekyouSharinganItachi == true) {
					if (_evt.getRenderer() instanceof PlayerRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						ModelSwapRenderers.renderPlayerAs(_evt, "naruto_shippuden:textures/susano/susano_itachi.png", RibcageSusanoRenderer.Modelribcage::new);
					}
				} else if (NarutoShippudenModVariables.get(entity).MangekyouSharinganMadara == true) {
					if (_evt.getRenderer() instanceof PlayerRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						ModelSwapRenderers.renderPlayerAs(_evt, "naruto_shippuden:textures/susano/susano_madara.png", RibcageSusanoRenderer.Modelribcage::new);
					}
				} else if (NarutoShippudenModVariables.get(entity).MangekyouSharinganObito == true) {
					if (_evt.getRenderer() instanceof PlayerRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						ModelSwapRenderers.renderPlayerAs(_evt, "naruto_shippuden:textures/susano/susano_obito.png", RibcageSusanoRenderer.Modelribcage::new);
					}
				} else if (NarutoShippudenModVariables.get(entity).MangekyouSharinganShisui == true) {
					if (_evt.getRenderer() instanceof PlayerRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						ModelSwapRenderers.renderPlayerAs(_evt, "naruto_shippuden:textures/susano/susano_shisui.png", RibcageSusanoRenderer.Modelribcage::new);
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 2) {
				if (NarutoShippudenModVariables.get(entity).MangekyouSharinganSasuke == true) {
					if (_evt.getRenderer() instanceof PlayerRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						ModelSwapRenderers.renderPlayerAs(_evt, "naruto_shippuden:textures/susano/susano_sasuke.png", SkeletonSusanoSasukeRenderer.Modelsusanoskeletonsasuke::new);
					}
				} else if (NarutoShippudenModVariables.get(entity).MangekyouSharinganItachi == true) {
					if (_evt.getRenderer() instanceof PlayerRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						ModelSwapRenderers.renderPlayerAs(_evt, "naruto_shippuden:textures/susano/susano_itachi.png", SkeletonSusanoItachiRenderer.Modelsusanoskeletonitachi::new);
					}
				} else if (NarutoShippudenModVariables.get(entity).MangekyouSharinganMadara == true) {
					if (_evt.getRenderer() instanceof PlayerRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						ModelSwapRenderers.renderPlayerAs(_evt, "naruto_shippuden:textures/susano/susano_madara.png", SkeletonSusanoMadaraRenderer.Modelsusanoskeletonmadara::new);
					}
				} else if (NarutoShippudenModVariables.get(entity).MangekyouSharinganObito == true) {
					if (_evt.getRenderer() instanceof PlayerRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						ModelSwapRenderers.renderPlayerAs(_evt, "naruto_shippuden:textures/susano/susano_obito.png", SkeletonSusanoObitoRenderer.Modelsusanoskeletonobito::new);
					}
				} else if (NarutoShippudenModVariables.get(entity).MangekyouSharinganShisui == true) {
					if (_evt.getRenderer() instanceof PlayerRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						ModelSwapRenderers.renderPlayerAs(_evt, "naruto_shippuden:textures/susano/susano_shisui.png", SkeletonSusanoShisuiRenderer.Modelsusanoskeletonshisui::new);
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 3) {
				if (NarutoShippudenModVariables.get(entity).MangekyouSharinganSasuke == true) {
					if (_evt.getRenderer() instanceof PlayerRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						ModelSwapRenderers.renderPlayerAs(_evt, "naruto_shippuden:textures/susano/susano_sasuke.png", HumanoidSusanoSasukeRenderer.Modelsusanohumanoidsasuke::new);
					}
				} else if (NarutoShippudenModVariables.get(entity).MangekyouSharinganItachi == true) {
					if (_evt.getRenderer() instanceof PlayerRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						ModelSwapRenderers.renderPlayerAs(_evt, "naruto_shippuden:textures/susano/susano_itachi.png", HumanoidSusanoItachiRenderer.Modelsusanohumanoiditachi::new);
					}
				} else if (NarutoShippudenModVariables.get(entity).MangekyouSharinganMadara == true) {
					if (_evt.getRenderer() instanceof PlayerRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						ModelSwapRenderers.renderPlayerAs(_evt, "naruto_shippuden:textures/susano/susano_madara.png", HumanoidSusanoMadaraRenderer.Modelsusanohumanoidmadara::new);
					}
				} else if (NarutoShippudenModVariables.get(entity).MangekyouSharinganObito == true) {
					if (_evt.getRenderer() instanceof PlayerRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						ModelSwapRenderers.renderPlayerAs(_evt, "naruto_shippuden:textures/susano/susano_obito.png", HumanoidSusanoObitoRenderer.Modelsusanohumanoidobito::new);
					}
				} else if (NarutoShippudenModVariables.get(entity).MangekyouSharinganShisui == true) {
					if (_evt.getRenderer() instanceof PlayerRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						ModelSwapRenderers.renderPlayerAs(_evt, "naruto_shippuden:textures/susano/susano_shisui.png", HumanoidSusanoShisuiRenderer.Modelsusanohumanoidshisui::new);
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 4) {
				if (NarutoShippudenModVariables.get(entity).MangekyouSharinganSasuke == true) {
					if (_evt.getRenderer() instanceof PlayerRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						ModelSwapRenderers.renderPlayerAs(_evt, "naruto_shippuden:textures/susano/susano_sasuke.png", ArmoredSusanoSasukeRenderer.Modelsusanoarmoredsasuke::new);
					}
				} else if (NarutoShippudenModVariables.get(entity).MangekyouSharinganMadara == true) {
					if (_evt.getRenderer() instanceof PlayerRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						ModelSwapRenderers.renderPlayerAs(_evt, "naruto_shippuden:textures/susano/susano_madara.png", ArmoredSusanoMadaraRenderer.Modelsusanoarmoredmadara::new);
					}
				} else if (NarutoShippudenModVariables.get(entity).MangekyouSharinganShisui == true) {
					if (_evt.getRenderer() instanceof PlayerRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						ModelSwapRenderers.renderPlayerAs(_evt, "naruto_shippuden:textures/susano/susano_shisui.png", ArmoredSusanoShisuiRenderer.Modelsusanoarmoredshisui::new);
					}
				}
			}
		}
	}

	public static class PlayerRespawnsProcedure {
		@Mod.EventBusSubscriber
		private static class GlobalTrigger {
			@SubscribeEvent
			public static void onPlayerRespawned(PlayerEvent.PlayerRespawnEvent event) {
				Entity entity = event.getPlayer();
				Map<String, Object> dependencies = new HashMap<>();
				dependencies.put("x", entity.getPosX());
				dependencies.put("y", entity.getPosY());
				dependencies.put("z", entity.getPosZ());
				dependencies.put("world", entity.world);
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
			IWorld world = (IWorld) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).deathgod == true) {
				{
					boolean _setval = (false);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.deathgod = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (false);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.deathgodcooldown = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof PlayerEntity)
					((PlayerEntity) entity).getCooldownTracker().setCooldown(UzumakiReleaseTechniqueItem.block, (int) 6000);
			}
			if (NarutoShippudenModVariables.get(entity).EightTrigramsPalmsRevolvingHeaven == true) {
				{
					boolean _setval = (false);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.EightTrigramsPalmsRevolvingHeaven = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if (NarutoShippudenModVariables.get(entity).InsectJarTechnique == true) {
				{
					boolean _setval = (false);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.InsectJarTechnique = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if (NarutoShippudenModVariables.get(entity).deathgodcooldown == true) {
				{
					boolean _setval = (false);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.deathgodcooldown = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof PlayerEntity)
					((PlayerEntity) entity).getCooldownTracker().setCooldown(UzumakiReleaseTechniqueItem.block, (int) 6000);
			}
			if (entity instanceof PlayerEntity) {
				{
					boolean _setval = (false);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ice_mirror = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (false);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.waterblob = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if (NarutoShippudenModVariables.get(entity).Gate8 == true) {
				{
					boolean _setval = (false);
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
			if (NarutoShippudenModVariables.get(entity).medicine <= 300) {
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("/attribute " + entity.getDisplayName().getString() + " minecraft:generic.max_health base set "
									+ NarutoShippudenModVariables.get(entity).maxhealth));
				}
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).setHealth((float) ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMaxHealth() : -1));
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ChakraMax);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ChakraAmount = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (NarutoShippudenModVariables.get(entity).medicine >= 301) {
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("/attribute " + entity.getDisplayName().getString() + " minecraft:generic.max_health base set " + 620));
				}
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).setHealth((float) 620);
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ChakraMax);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ChakraAmount = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if (NarutoShippudenModVariables.get(entity).izanagiuse == true) {
				{
					boolean _setval = (false);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.izanagiuse = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
	}

	public static class PlayerWakeUpGlobalProcedure {
		@Mod.EventBusSubscriber
		private static class GlobalTrigger {
			@SubscribeEvent
			public static void onEntityEndSleep(PlayerWakeUpEvent event) {
				Entity entity = event.getEntity();
				World world = entity.world;
				double i = entity.getPosX();
				double j = entity.getPosY();
				double k = entity.getPosZ();
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
			IWorld world = (IWorld) dependencies.get("world");
			Entity entity = (Entity) dependencies.get("entity");
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
					if (world.getWorldInfo().getDayTime() % 24000 == 20) {
						{
							double _setval = (NarutoShippudenModVariables.get(entity).ChakraMax);
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.ChakraAmount = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
					MinecraftForge.EVENT_BUS.unregister(this);
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
			IWorld world = (IWorld) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).sp >= NarutoShippudenModVariables.get(entity).spusecount) {
				{
					double _setval = (NarutoShippudenModVariables.get(entity).sp
							- NarutoShippudenModVariables.get(entity).spusecount);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.sp = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).speed
							+ NarutoShippudenModVariables.get(entity).spusecount);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.speed = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).maxspeed
							+ NarutoShippudenModVariables.get(entity).spusecount * 0.005);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.maxspeed = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							("/attribute " + entity.getDisplayName().getString() + " minecraft:generic.movement_speed base set "
									+ NarutoShippudenModVariables.get(entity).maxspeed));
				}
			} else if (NarutoShippudenModVariables.get(entity).sp <= NarutoShippudenModVariables.get(entity).spusecount) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(
							("Not Enough SP Use Selected: " + NarutoShippudenModVariables.get(entity).spusecount)),
							(false));
				}
			}
		}
	}
}
