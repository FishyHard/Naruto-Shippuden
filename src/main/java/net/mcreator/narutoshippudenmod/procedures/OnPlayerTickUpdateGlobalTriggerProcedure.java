package net.mcreator.narutoshippudenmod.procedures;

import net.minecraftforge.fml.loading.FMLPaths;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.vector.Vector2f;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Direction;
import net.minecraft.util.DamageSource;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tags.BlockTags;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.command.ICommandSource;
import net.minecraft.command.CommandSource;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;

import net.mcreator.narutoshippudenmod.particle.AmaterasuFireParticle;
import net.mcreator.narutoshippudenmod.item.WindReleaseTechniqueItem;
import net.mcreator.narutoshippudenmod.item.UzumakiChainItem;
import net.mcreator.narutoshippudenmod.item.TenroReleaseTechniqueItem;
import net.mcreator.narutoshippudenmod.item.SteelReleaseTechniqueItem;
import net.mcreator.narutoshippudenmod.item.SmokeReleaseTechniqueItem;
import net.mcreator.narutoshippudenmod.item.MagnetReleaseTechniqueItem;
import net.mcreator.narutoshippudenmod.item.LaserCircusItem;
import net.mcreator.narutoshippudenmod.item.IzunoReleaseTechniqueItem;
import net.mcreator.narutoshippudenmod.item.HozukiReleaseTechniqueItem;
import net.mcreator.narutoshippudenmod.item.HiramekareiSplittedItem;
import net.mcreator.narutoshippudenmod.item.HiramekareiItem;
import net.mcreator.narutoshippudenmod.item.BoneReleaseTechniqueItem;
import net.mcreator.narutoshippudenmod.item.AkimichiReleaseTechniqueItem;
import net.mcreator.narutoshippudenmod.entity.ShadowImitationEntityEntity;
import net.mcreator.narutoshippudenmod.block.NaraShadowBlock;
import net.mcreator.narutoshippudenmod.block.AmaterasuSpreadBlock;
import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables;
import net.mcreator.narutoshippudenmod.NarutoShippudenMod;

import java.util.stream.Stream;
import java.util.stream.Collectors;
import java.util.function.Function;
import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.Comparator;
import java.util.AbstractMap;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

import com.google.gson.Gson;

public class OnPlayerTickUpdateGlobalTriggerProcedure {
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
			if (!((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount >= (entity
							.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraMax)) {
				{
					double _setval = ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount + 0.25);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ChakraAmount = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		} else if (entity.isSneaking()) {
			if (!((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount >= (entity
							.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraMax)) {
				{
					double _setval = ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount + 0.5);
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
			if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).LEVELMINIGAME >= (entity
							.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoShippudenModVariables.PlayerVariables())).LEVELMAXMINIGAME) {
				if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).LEVELMINIGAME == (entity
								.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NarutoShippudenModVariables.PlayerVariables())).LEVELMAXMINIGAME) {
					{
						double _setval = 0;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.LEVELMINIGAME = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NarutoShippudenModVariables.PlayerVariables())).LEVELMAXMINIGAME + 2);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.LEVELMAXMINIGAME = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NarutoShippudenModVariables.PlayerVariables())).LEVELSTATMINIGAME + 1);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.LEVELSTATMINIGAME = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NarutoShippudenModVariables.PlayerVariables())).jp + 1);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NarutoShippudenModVariables.PlayerVariables())).sp + 1);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.sp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity)
								.sendStatusMessage(
										new StringTextComponent(("Level Up! Level: "
												+ (entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
														.orElse(new NarutoShippudenModVariables.PlayerVariables())).LEVELSTATMINIGAME
												+ " JP +1" + " SP +1")),
										(true));
					}
				}
				if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).LEVELMINIGAME >= (entity
								.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NarutoShippudenModVariables.PlayerVariables())).LEVELMAXMINIGAME) {
					{
						double _setval = ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NarutoShippudenModVariables.PlayerVariables())).LEVELMINIGAME
								- (entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).LEVELMAXMINIGAME);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.LEVELMINIGAME = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NarutoShippudenModVariables.PlayerVariables())).LEVELMAXMINIGAME + 2);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.LEVELMAXMINIGAME = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NarutoShippudenModVariables.PlayerVariables())).LEVELSTATMINIGAME + 1);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.LEVELSTATMINIGAME = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NarutoShippudenModVariables.PlayerVariables())).jp + 1);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NarutoShippudenModVariables.PlayerVariables())).sp + 1);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.sp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity)
								.sendStatusMessage(
										new StringTextComponent(("Level Up! Level: "
												+ (entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
														.orElse(new NarutoShippudenModVariables.PlayerVariables())).LEVELSTATMINIGAME
												+ " JP +1" + " SP +1")),
										(true));
					}
				}
			}
		}
		if (entity.ticksExisted % 20 == 0 && !world.isRemote()) {
			{
				double _setval = ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).NarutoTimerAwakening + 1);
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.NarutoTimerAwakening = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).calendar_calculator + 1);
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
				if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).uchihareleaselogic == true) {
					if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoShippudenModVariables.PlayerVariables())).NarutoTimerAwakening >= mainjsonobject.get("sharingan_awake")
									.getAsDouble()) {
						if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NarutoShippudenModVariables.PlayerVariables())).sharingan == false) {
							SharinganAwakeProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
									(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
						}
					}
					if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoShippudenModVariables.PlayerVariables())).NarutoTimerAwakening >= mainjsonobject
									.get("mangekyou_sharingan_awake").getAsDouble()) {
						if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NarutoShippudenModVariables.PlayerVariables())).mangekyouletter == false) {
							MSharinganAwakeProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
									(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
						}
					}
				}
				if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).hatakereleaselogic == true) {
					if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoShippudenModVariables.PlayerVariables())).NarutoTimerAwakening >= mainjsonobject.get("sharingan_awake")
									.getAsDouble()) {
						if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NarutoShippudenModVariables.PlayerVariables())).SharinganKakashi == false) {
							KakashiSharinganAwakeProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
									.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
						}
					}
					if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoShippudenModVariables.PlayerVariables())).NarutoTimerAwakening >= mainjsonobject
									.get("mangekyou_sharingan_awake").getAsDouble()) {
						if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NarutoShippudenModVariables.PlayerVariables())).MangekyouSharinganKakashi == false) {
							KakashiMSharinganAwakeProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
									.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
						}
					}
				}
				if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).shimurareleaselogic == true) {
					if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoShippudenModVariables.PlayerVariables())).NarutoTimerAwakening >= mainjsonobject.get("sharingan_awake")
									.getAsDouble()) {
						if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NarutoShippudenModVariables.PlayerVariables())).SharinganShimura == false) {
							ShimuraSharinganAwakeProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
									.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
						}
					}
				}
				if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).hyugareleaselogic == true) {
					if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoShippudenModVariables.PlayerVariables())).NarutoTimerAwakening >= mainjsonobject.get("byakugan_awake")
									.getAsDouble()) {
						if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NarutoShippudenModVariables.PlayerVariables())).byakugan == false) {
							ByakuganAwakeProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
									(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
						}
					}
				}
				if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).chinoikereleaselogic == true) {
					if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoShippudenModVariables.PlayerVariables())).NarutoTimerAwakening >= mainjsonobject
									.get("ketsuryugan_awake").getAsDouble()) {
						if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NarutoShippudenModVariables.PlayerVariables())).ketsuryugan == false) {
							KetsuryuganAwakeProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
									.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
						}
					}
				}
				if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).otsutsukireleaselogic == true) {
					if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoShippudenModVariables.PlayerVariables())).otsutsuki_path == 1) {
						if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NarutoShippudenModVariables.PlayerVariables())).NarutoTimerAwakening >= mainjsonobject
										.get("byakugan_awake").getAsDouble()) {
							if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NarutoShippudenModVariables.PlayerVariables())).byakugan == false) {
								ByakuganAwakeProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
										.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
							}
						}
					} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoShippudenModVariables.PlayerVariables())).otsutsuki_path == 2) {
						if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NarutoShippudenModVariables.PlayerVariables())).NarutoTimerAwakening >= mainjsonobject
										.get("sharingan_awake").getAsDouble()) {
							if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NarutoShippudenModVariables.PlayerVariables())).sharingan == false) {
								SharinganAwakeProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
										.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
							}
						}
					} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoShippudenModVariables.PlayerVariables())).otsutsuki_path == 3) {
						if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NarutoShippudenModVariables.PlayerVariables())).NarutoTimerAwakening >= mainjsonobject
										.get("isshiki_dojutsu_awake").getAsDouble()) {
							if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NarutoShippudenModVariables.PlayerVariables())).isshikidojutsu == false) {
								IsshikiDojutsuAwakeProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
										.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
							}
						}
					}
				}
				if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).otsutsuki_path == 1) {
					if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoShippudenModVariables.PlayerVariables())).NarutoTimerAwakening >= mainjsonobject.get("tenseigan_awake")
									.getAsDouble()) {
						if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NarutoShippudenModVariables.PlayerVariables())).tenseigan == false) {
							TenseiganAwakeProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
									(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
						}
					}
				} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).otsutsuki_path == 2) {
					if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoShippudenModVariables.PlayerVariables())).NarutoTimerAwakening >= mainjsonobject
									.get("mangekyou_sharingan_awake").getAsDouble()) {
						if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NarutoShippudenModVariables.PlayerVariables())).otsutsuki_mangekyou == false) {
							MangekyouOtsutsukiAwakeProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
									.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
						}
					}
				}
				if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).otsutsuki_path == 2) {
					if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoShippudenModVariables.PlayerVariables())).NarutoTimerAwakening >= mainjsonobject.get("rinnegan_awake")
									.getAsDouble()) {
						if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NarutoShippudenModVariables.PlayerVariables())).rinnegan == false) {
							RinneganAwakeProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
									(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
						}
					}
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).uzumakichains == true) {
			if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).ninjutsu >= 10) {
				if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount >= 1) {
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
						double _setval = ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount - 1);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.ChakraAmount = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			}
		}
		if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).tenromode == true) {
			if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).ninjutsu >= 20) {
				if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount >= 2) {
					{
						double _setval = ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount - 2);
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
				} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount <= 1.9) {
					{
						boolean _setval = (false);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.tenromode = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoShippudenModVariables.PlayerVariables())).rank).equals("Academy Student")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(TenroReleaseTechniqueItem.block, (int) 1500);
					} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoShippudenModVariables.PlayerVariables())).rank).equals("Genin")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(TenroReleaseTechniqueItem.block, (int) 1250);
					} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoShippudenModVariables.PlayerVariables())).rank).equals("Chunin")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(TenroReleaseTechniqueItem.block, (int) 1000);
					} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoShippudenModVariables.PlayerVariables())).rank).equals("Jonin")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(TenroReleaseTechniqueItem.block, (int) 750);
					} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoShippudenModVariables.PlayerVariables())).rank).equals("Kage")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(TenroReleaseTechniqueItem.block, (int) 500);
					}
				}
			}
		}
		if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).swiftmode == true) {
			if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).ninjutsu >= 30) {
				if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).taijutsu >= 20) {
					if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount >= 4) {
						if (entity instanceof LivingEntity)
							((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SPEED, (int) 10, (int) 30, (false), (false)));
						if (entity instanceof LivingEntity)
							((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.STRENGTH, (int) 10, (int) 1, (false), (false)));
						{
							double _setval = ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount - 4);
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.ChakraAmount = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
				}
			}
		}
		if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).stormlaser == true) {
			if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).ninjutsu >= 25) {
				if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount >= 1.7) {
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
						double _setval = ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount - 1.7);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.ChakraAmount = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			}
		}
		if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).hoshigakireleaselogic == true) {
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
		if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).DanceOfTheLarch == true) {
			if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount >= 4) {
				{
					double _setval = ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount - 4);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ChakraAmount = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.RESISTANCE, (int) 10, (int) 2, (false), (false)));
			} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount <= 3.9) {
				{
					boolean _setval = (false);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.DanceOfTheLarch = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).rank).equals("Academy Student")) {
					if (entity instanceof PlayerEntity)
						((PlayerEntity) entity).getCooldownTracker().setCooldown(BoneReleaseTechniqueItem.block, (int) 750);
				} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).rank).equals("Genin")) {
					if (entity instanceof PlayerEntity)
						((PlayerEntity) entity).getCooldownTracker().setCooldown(BoneReleaseTechniqueItem.block, (int) 500);
				} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).rank).equals("Chunin")) {
					if (entity instanceof PlayerEntity)
						((PlayerEntity) entity).getCooldownTracker().setCooldown(BoneReleaseTechniqueItem.block, (int) 300);
				} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).rank).equals("Jonin")) {
					if (entity instanceof PlayerEntity)
						((PlayerEntity) entity).getCooldownTracker().setCooldown(BoneReleaseTechniqueItem.block, (int) 200);
				} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).rank).equals("Kage")) {
					if (entity instanceof PlayerEntity)
						((PlayerEntity) entity).getCooldownTracker().setCooldown(BoneReleaseTechniqueItem.block, (int) 100);
				}
			}
		}
		if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).ImperviousArmor == true) {
			if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount >= 7) {
				{
					double _setval = ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount - 7);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ChakraAmount = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.RESISTANCE, (int) 10, (int) 3, (false), (false)));
			} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount <= 6.9) {
				{
					boolean _setval = (false);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ImperviousArmor = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).rank).equals("Academy Student")) {
					if (entity instanceof PlayerEntity)
						((PlayerEntity) entity).getCooldownTracker().setCooldown(SteelReleaseTechniqueItem.block, (int) 750);
				} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).rank).equals("Genin")) {
					if (entity instanceof PlayerEntity)
						((PlayerEntity) entity).getCooldownTracker().setCooldown(SteelReleaseTechniqueItem.block, (int) 500);
				} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).rank).equals("Chunin")) {
					if (entity instanceof PlayerEntity)
						((PlayerEntity) entity).getCooldownTracker().setCooldown(SteelReleaseTechniqueItem.block, (int) 300);
				} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).rank).equals("Jonin")) {
					if (entity instanceof PlayerEntity)
						((PlayerEntity) entity).getCooldownTracker().setCooldown(SteelReleaseTechniqueItem.block, (int) 200);
				} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).rank).equals("Kage")) {
					if (entity instanceof PlayerEntity)
						((PlayerEntity) entity).getCooldownTracker().setCooldown(SteelReleaseTechniqueItem.block, (int) 100);
				}
			}
		}
		if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).magnet_coat == 1) {
			if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount >= 5) {
				{
					double _setval = ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount - 5);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ChakraAmount = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.RESISTANCE, (int) 10, (int) 2, (false), (false)));
			} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount <= 4.9) {
				{
					double _setval = 0;
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.magnet_coat = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).rank).equals("Academy Student")) {
					if (entity instanceof PlayerEntity)
						((PlayerEntity) entity).getCooldownTracker().setCooldown(MagnetReleaseTechniqueItem.block, (int) 750);
				} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).rank).equals("Genin")) {
					if (entity instanceof PlayerEntity)
						((PlayerEntity) entity).getCooldownTracker().setCooldown(MagnetReleaseTechniqueItem.block, (int) 500);
				} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).rank).equals("Chunin")) {
					if (entity instanceof PlayerEntity)
						((PlayerEntity) entity).getCooldownTracker().setCooldown(MagnetReleaseTechniqueItem.block, (int) 300);
				} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).rank).equals("Jonin")) {
					if (entity instanceof PlayerEntity)
						((PlayerEntity) entity).getCooldownTracker().setCooldown(MagnetReleaseTechniqueItem.block, (int) 200);
				} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).rank).equals("Kage")) {
					if (entity instanceof PlayerEntity)
						((PlayerEntity) entity).getCooldownTracker().setCooldown(MagnetReleaseTechniqueItem.block, (int) 100);
				}
			}
		} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).magnet_coat == 2) {
			if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount >= 7) {
				{
					double _setval = ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount - 7);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ChakraAmount = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.RESISTANCE, (int) 10, (int) 3, (false), (false)));
			} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount <= 6.9) {
				{
					double _setval = 0;
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.magnet_coat = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).rank).equals("Academy Student")) {
					if (entity instanceof PlayerEntity)
						((PlayerEntity) entity).getCooldownTracker().setCooldown(MagnetReleaseTechniqueItem.block, (int) 750);
				} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).rank).equals("Genin")) {
					if (entity instanceof PlayerEntity)
						((PlayerEntity) entity).getCooldownTracker().setCooldown(MagnetReleaseTechniqueItem.block, (int) 500);
				} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).rank).equals("Chunin")) {
					if (entity instanceof PlayerEntity)
						((PlayerEntity) entity).getCooldownTracker().setCooldown(MagnetReleaseTechniqueItem.block, (int) 300);
				} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).rank).equals("Jonin")) {
					if (entity instanceof PlayerEntity)
						((PlayerEntity) entity).getCooldownTracker().setCooldown(MagnetReleaseTechniqueItem.block, (int) 200);
				} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).rank).equals("Kage")) {
					if (entity instanceof PlayerEntity)
						((PlayerEntity) entity).getCooldownTracker().setCooldown(MagnetReleaseTechniqueItem.block, (int) 100);
				}
			}
		} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).magnet_coat == 3) {
			if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount >= 6) {
				{
					double _setval = ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount - 6);
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
			} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount <= 5.9) {
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
				if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).rank).equals("Academy Student")) {
					if (entity instanceof PlayerEntity)
						((PlayerEntity) entity).getCooldownTracker().setCooldown(MagnetReleaseTechniqueItem.block, (int) 750);
				} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).rank).equals("Genin")) {
					if (entity instanceof PlayerEntity)
						((PlayerEntity) entity).getCooldownTracker().setCooldown(MagnetReleaseTechniqueItem.block, (int) 500);
				} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).rank).equals("Chunin")) {
					if (entity instanceof PlayerEntity)
						((PlayerEntity) entity).getCooldownTracker().setCooldown(MagnetReleaseTechniqueItem.block, (int) 300);
				} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).rank).equals("Jonin")) {
					if (entity instanceof PlayerEntity)
						((PlayerEntity) entity).getCooldownTracker().setCooldown(MagnetReleaseTechniqueItem.block, (int) 200);
				} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).rank).equals("Kage")) {
					if (entity instanceof PlayerEntity)
						((PlayerEntity) entity).getCooldownTracker().setCooldown(MagnetReleaseTechniqueItem.block, (int) 100);
				}
			}
		}
		if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).Great_Water_Arm == true) {
			if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount >= 2) {
				{
					double _setval = ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount - 2);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ChakraAmount = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.STRENGTH, (int) 10, (int) 2, (false), (false)));
			} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount <= 1.9) {
				{
					boolean _setval = (false);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.Great_Water_Arm = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).rank).equals("Academy Student")) {
					if (entity instanceof PlayerEntity)
						((PlayerEntity) entity).getCooldownTracker().setCooldown(HozukiReleaseTechniqueItem.block, (int) 750);
				} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).rank).equals("Genin")) {
					if (entity instanceof PlayerEntity)
						((PlayerEntity) entity).getCooldownTracker().setCooldown(HozukiReleaseTechniqueItem.block, (int) 500);
				} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).rank).equals("Chunin")) {
					if (entity instanceof PlayerEntity)
						((PlayerEntity) entity).getCooldownTracker().setCooldown(HozukiReleaseTechniqueItem.block, (int) 300);
				} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).rank).equals("Jonin")) {
					if (entity instanceof PlayerEntity)
						((PlayerEntity) entity).getCooldownTracker().setCooldown(HozukiReleaseTechniqueItem.block, (int) 200);
				} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).rank).equals("Kage")) {
					if (entity instanceof PlayerEntity)
						((PlayerEntity) entity).getCooldownTracker().setCooldown(HozukiReleaseTechniqueItem.block, (int) 100);
				}
			}
		}
		if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).izunochakramode == true) {
			if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).ninjutsu >= 20) {
				if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount >= 1) {
					{
						double _setval = ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount - 1);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.ChakraAmount = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof LivingEntity)
						((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SPEED, (int) 10, (int) 1, (false), (false)));
					if (entity instanceof LivingEntity)
						((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.STRENGTH, (int) 10, (int) 1, (false), (false)));
				} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount <= 0.9) {
					{
						boolean _setval = (false);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.izunochakramode = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoShippudenModVariables.PlayerVariables())).rank).equals("Academy Student")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(IzunoReleaseTechniqueItem.block, (int) 750);
					} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoShippudenModVariables.PlayerVariables())).rank).equals("Genin")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(IzunoReleaseTechniqueItem.block, (int) 500);
					} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoShippudenModVariables.PlayerVariables())).rank).equals("Chunin")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(IzunoReleaseTechniqueItem.block, (int) 300);
					} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoShippudenModVariables.PlayerVariables())).rank).equals("Jonin")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(IzunoReleaseTechniqueItem.block, (int) 200);
					} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoShippudenModVariables.PlayerVariables())).rank).equals("Kage")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(IzunoReleaseTechniqueItem.block, (int) 100);
					}
				}
			}
		}
		if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).HumanBulletTank == true) {
			if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).ninjutsu >= 25) {
				if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount >= 2) {
					{
						double _setval = ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount - 2);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.ChakraAmount = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof LivingEntity)
						((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SPEED, (int) 10, (int) 19, (false), (false)));
				} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount <= 1.9) {
					{
						boolean _setval = (false);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.HumanBulletTank = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoShippudenModVariables.PlayerVariables())).rank).equals("Academy Student")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(AkimichiReleaseTechniqueItem.block, (int) 750);
					} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoShippudenModVariables.PlayerVariables())).rank).equals("Genin")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(AkimichiReleaseTechniqueItem.block, (int) 500);
					} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoShippudenModVariables.PlayerVariables())).rank).equals("Chunin")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(AkimichiReleaseTechniqueItem.block, (int) 300);
					} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoShippudenModVariables.PlayerVariables())).rank).equals("Jonin")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(AkimichiReleaseTechniqueItem.block, (int) 200);
					} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoShippudenModVariables.PlayerVariables())).rank).equals("Kage")) {
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
		if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).SpikedHumanBulletTank == true) {
			if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).ninjutsu >= 30) {
				if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount >= 3) {
					{
						double _setval = ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount - 3);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.ChakraAmount = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof LivingEntity)
						((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SPEED, (int) 10, (int) 19, (false), (false)));
				} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount <= 2.9) {
					{
						boolean _setval = (false);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.SpikedHumanBulletTank = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoShippudenModVariables.PlayerVariables())).rank).equals("Academy Student")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(AkimichiReleaseTechniqueItem.block, (int) 750);
					} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoShippudenModVariables.PlayerVariables())).rank).equals("Genin")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(AkimichiReleaseTechniqueItem.block, (int) 500);
					} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoShippudenModVariables.PlayerVariables())).rank).equals("Chunin")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(AkimichiReleaseTechniqueItem.block, (int) 300);
					} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoShippudenModVariables.PlayerVariables())).rank).equals("Jonin")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(AkimichiReleaseTechniqueItem.block, (int) 200);
					} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoShippudenModVariables.PlayerVariables())).rank).equals("Kage")) {
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
		if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).ButterflyMode == true) {
			if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount >= 4) {
				{
					double _setval = ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount - 4);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ChakraAmount = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof PlayerEntity) {
					((PlayerEntity) entity).abilities.isFlying = (true);
					((PlayerEntity) entity).sendPlayerAbilities();
				}
			} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount <= 3.9) {
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
				if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).rank).equals("Academy Student")) {
					if (entity instanceof PlayerEntity)
						((PlayerEntity) entity).getCooldownTracker().setCooldown(AkimichiReleaseTechniqueItem.block, (int) 750);
				} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).rank).equals("Genin")) {
					if (entity instanceof PlayerEntity)
						((PlayerEntity) entity).getCooldownTracker().setCooldown(AkimichiReleaseTechniqueItem.block, (int) 500);
				} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).rank).equals("Chunin")) {
					if (entity instanceof PlayerEntity)
						((PlayerEntity) entity).getCooldownTracker().setCooldown(AkimichiReleaseTechniqueItem.block, (int) 300);
				} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).rank).equals("Jonin")) {
					if (entity instanceof PlayerEntity)
						((PlayerEntity) entity).getCooldownTracker().setCooldown(AkimichiReleaseTechniqueItem.block, (int) 200);
				} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).rank).equals("Kage")) {
					if (entity instanceof PlayerEntity)
						((PlayerEntity) entity).getCooldownTracker().setCooldown(AkimichiReleaseTechniqueItem.block, (int) 100);
				}
			}
		}
		if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).izunocat == true) {
			if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).ninjutsu >= 25) {
				if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount >= 3) {
					{
						double _setval = ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount - 3);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.ChakraAmount = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof LivingEntity)
						((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.STRENGTH, (int) 10, (int) 3, (false), (false)));
				} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount <= 2.9) {
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
							_ent.world.getServer().getCommandManager().handleCommand(
									_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4), "/scale set pehkui:hitbox_height 1");
						}
					}
					{
						Entity _ent = entity;
						if (!_ent.world.isRemote && _ent.world.getServer() != null) {
							_ent.world.getServer().getCommandManager().handleCommand(
									_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4), "/scale set pehkui:hitbox_width 1");
						}
					}
					{
						Entity _ent = entity;
						if (!_ent.world.isRemote && _ent.world.getServer() != null) {
							_ent.world.getServer().getCommandManager().handleCommand(
									_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4), "/scale set pehkui:eye_height 1");
						}
					}
					if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoShippudenModVariables.PlayerVariables())).rank).equals("Academy Student")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(IzunoReleaseTechniqueItem.block, (int) 1500);
					} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoShippudenModVariables.PlayerVariables())).rank).equals("Genin")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(IzunoReleaseTechniqueItem.block, (int) 1250);
					} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoShippudenModVariables.PlayerVariables())).rank).equals("Chunin")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(IzunoReleaseTechniqueItem.block, (int) 1000);
					} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoShippudenModVariables.PlayerVariables())).rank).equals("Jonin")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(IzunoReleaseTechniqueItem.block, (int) 750);
					} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoShippudenModVariables.PlayerVariables())).rank).equals("Kage")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(IzunoReleaseTechniqueItem.block, (int) 500);
					}
				}
			}
		}
		if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).taijutsu >= 121) {
			{
				double _setval = ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).taijutsu - 1);
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.taijutsu = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).sp + 1);
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.sp = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Your Taijutsu is maxed."), (true));
			}
		}
		if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).kenjutsu >= 101) {
			{
				double _setval = ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).kenjutsu - 1);
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.kenjutsu = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).sp + 1);
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.sp = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Your Kenjutsu is maxed."), (true));
			}
		}
		if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).shurikenjutsu >= 26) {
			{
				double _setval = ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).shurikenjutsu - 1);
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.shurikenjutsu = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).sp + 1);
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.sp = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Your Shurikenjutsu is maxed."), (true));
			}
		}
		if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).summoning >= 61) {
			{
				double _setval = ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).summoning - 1);
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.summoning = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).sp + 1);
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.sp = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Your Summoning is maxed."), (true));
			}
		}
		if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).kinjutsu >= 101) {
			{
				double _setval = ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).kinjutsu - 1);
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.kinjutsu = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).sp + 1);
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.sp = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Your Kinjutsu is maxed."), (true));
			}
		}
		if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).medicine >= 301) {
			{
				double _setval = ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).medicine - 1);
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.medicine = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).sp + 1);
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.sp = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).maxhealth - 2);
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
								+ (entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).maxhealth));
			}
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Your Medicine is maxed."), (true));
			}
		}
		if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).speed >= 11) {
			{
				double _setval = ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).speed - 1);
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.speed = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).sp + 1);
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.sp = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).maxspeed - 0.005);
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
								+ (entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).maxspeed));
			}
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Your Speed is maxed."), (true));
			}
		}
		if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).jutsupowerstat >= 11) {
			{
				double _setval = ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).jutsupowerstat - 1);
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.jutsupowerstat = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).sp + 1);
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.sp = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Your Jutsu Power is maxed."), (true));
			}
		}
		if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).genjutsu >= 71) {
			{
				double _setval = ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).genjutsu - 1);
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.genjutsu = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).sp + 1);
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.sp = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Your Genjutsu is maxed."), (true));
			}
		}
		if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).IQ >= 221) {
			{
				double _setval = ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).IQ - 1);
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.IQ = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).sp + 1);
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.sp = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Your IQ is maxed."), (true));
			}
		}
		if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).SmokeForm == true) {
			if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount >= 4) {
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
					double _setval = ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount - 4);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ChakraAmount = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount <= 3.9) {
				{
					boolean _setval = (false);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.SmokeForm = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).rank).equals("Academy Student")) {
					if (entity instanceof PlayerEntity)
						((PlayerEntity) entity).getCooldownTracker().setCooldown(SmokeReleaseTechniqueItem.block, (int) 750);
				} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).rank).equals("Genin")) {
					if (entity instanceof PlayerEntity)
						((PlayerEntity) entity).getCooldownTracker().setCooldown(SmokeReleaseTechniqueItem.block, (int) 500);
				} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).rank).equals("Chunin")) {
					if (entity instanceof PlayerEntity)
						((PlayerEntity) entity).getCooldownTracker().setCooldown(SmokeReleaseTechniqueItem.block, (int) 300);
				} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).rank).equals("Jonin")) {
					if (entity instanceof PlayerEntity)
						((PlayerEntity) entity).getCooldownTracker().setCooldown(SmokeReleaseTechniqueItem.block, (int) 200);
				} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).rank).equals("Kage")) {
					if (entity instanceof PlayerEntity)
						((PlayerEntity) entity).getCooldownTracker().setCooldown(SmokeReleaseTechniqueItem.block, (int) 100);
				}
			}
		}
		if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).WindMode == true) {
			if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount >= 1) {
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SPEED, (int) 50, (int) 2, (false), (false)));
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.HASTE, (int) 50, (int) 2, (false), (false)));
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.JUMP_BOOST, (int) 50, (int) 1, (false), (false)));
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.RESISTANCE, (int) 50, (int) 0, (false), (false)));
				{
					double _setval = ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount - 1);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ChakraAmount = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount <= 0.9) {
				{
					boolean _setval = (false);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.WindMode = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).rank).equals("Academy Student")) {
					if (entity instanceof PlayerEntity)
						((PlayerEntity) entity).getCooldownTracker().setCooldown(WindReleaseTechniqueItem.block, (int) 200);
				} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).rank).equals("Genin")) {
					if (entity instanceof PlayerEntity)
						((PlayerEntity) entity).getCooldownTracker().setCooldown(WindReleaseTechniqueItem.block, (int) 160);
				} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).rank).equals("Chunin")) {
					if (entity instanceof PlayerEntity)
						((PlayerEntity) entity).getCooldownTracker().setCooldown(WindReleaseTechniqueItem.block, (int) 120);
				} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).rank).equals("Jonin")) {
					if (entity instanceof PlayerEntity)
						((PlayerEntity) entity).getCooldownTracker().setCooldown(WindReleaseTechniqueItem.block, (int) 80);
				} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).rank).equals("Kage")) {
					if (entity instanceof PlayerEntity)
						((PlayerEntity) entity).getCooldownTracker().setCooldown(WindReleaseTechniqueItem.block, (int) 40);
				}
			}
		}
		if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).VolticThomasCannonDamage == true) {
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
		if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).PassingFang == true) {
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
		if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).NaraClanShadow == true) {
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
				if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).Shadow1X
						- (entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NarutoShippudenModVariables.PlayerVariables())).Shadow2X)
						* ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NarutoShippudenModVariables.PlayerVariables())).Shadow1X
								- (entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).Shadow2X) >= ((entity
												.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
												.orElse(new NarutoShippudenModVariables.PlayerVariables())).Shadow1Z
												- (entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
														.orElse(new NarutoShippudenModVariables.PlayerVariables())).Shadow2Z)
												* ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
														.orElse(new NarutoShippudenModVariables.PlayerVariables())).Shadow1Z
														- (entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
																.orElse(new NarutoShippudenModVariables.PlayerVariables())).Shadow2Z)) {
					if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoShippudenModVariables.PlayerVariables())).Shadow1X > (entity
									.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NarutoShippudenModVariables.PlayerVariables())).Shadow2X) {
						world.setBlockState(
								new BlockPos(
										(entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
												.orElse(new NarutoShippudenModVariables.PlayerVariables())).Shadow1X - 1,
										entity.getPosY(),
										(entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
												.orElse(new NarutoShippudenModVariables.PlayerVariables())).Shadow1Z),
								NaraShadowBlock.block.getDefaultState(), 3);
						{
							double _setval = ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NarutoShippudenModVariables.PlayerVariables())).Shadow1X - 1);
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.Shadow1X = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoShippudenModVariables.PlayerVariables())).Shadow1X < (entity
									.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NarutoShippudenModVariables.PlayerVariables())).Shadow2X) {
						world.setBlockState(
								new BlockPos(
										(entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
												.orElse(new NarutoShippudenModVariables.PlayerVariables())).Shadow1X + 1,
										entity.getPosY(),
										(entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
												.orElse(new NarutoShippudenModVariables.PlayerVariables())).Shadow1Z),
								NaraShadowBlock.block.getDefaultState(), 3);
						{
							double _setval = ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NarutoShippudenModVariables.PlayerVariables())).Shadow1X + 1);
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.Shadow1X = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
				} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).Shadow1X
						- (entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NarutoShippudenModVariables.PlayerVariables())).Shadow2X)
						* ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NarutoShippudenModVariables.PlayerVariables())).Shadow1X
								- (entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).Shadow2X) < ((entity
												.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
												.orElse(new NarutoShippudenModVariables.PlayerVariables())).Shadow1Z
												- (entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
														.orElse(new NarutoShippudenModVariables.PlayerVariables())).Shadow2Z)
												* ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
														.orElse(new NarutoShippudenModVariables.PlayerVariables())).Shadow1Z
														- (entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
																.orElse(new NarutoShippudenModVariables.PlayerVariables())).Shadow2Z)) {
					if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoShippudenModVariables.PlayerVariables())).Shadow1Z > (entity
									.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NarutoShippudenModVariables.PlayerVariables())).Shadow2Z) {
						world.setBlockState(
								new BlockPos(
										(entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
												.orElse(new NarutoShippudenModVariables.PlayerVariables())).Shadow1X,
										entity.getPosY(),
										(entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
												.orElse(new NarutoShippudenModVariables.PlayerVariables())).Shadow1Z - 1),
								NaraShadowBlock.block.getDefaultState(), 3);
						{
							double _setval = ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NarutoShippudenModVariables.PlayerVariables())).Shadow1Z - 1);
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.Shadow1Z = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoShippudenModVariables.PlayerVariables())).Shadow1Z < (entity
									.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NarutoShippudenModVariables.PlayerVariables())).Shadow2Z) {
						world.setBlockState(
								new BlockPos(
										(entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
												.orElse(new NarutoShippudenModVariables.PlayerVariables())).Shadow1X,
										entity.getPosY(),
										(entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
												.orElse(new NarutoShippudenModVariables.PlayerVariables())).Shadow1Z + 1),
								NaraShadowBlock.block.getDefaultState(), 3);
						{
							double _setval = ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NarutoShippudenModVariables.PlayerVariables())).Shadow1Z + 1);
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
							.getPosX()) != (entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NarutoShippudenModVariables.PlayerVariables())).ShadowX1
									- (entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new NarutoShippudenModVariables.PlayerVariables())).ShadowX2
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
											.getPosZ()) != (entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
													.orElse(new NarutoShippudenModVariables.PlayerVariables())).ShadowZ1
													- (entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
															.orElse(new NarutoShippudenModVariables.PlayerVariables())).ShadowZ2)) {
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
								.floor((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).OriginalX1
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
								.floor((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).OriginalX1
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
								.floor((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).OriginalZ1
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
								.floor((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).OriginalZ1
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
		if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).medicine <= 300) {
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
		} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).medicine >= 301) {
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
		if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).Kagutsuchi == true) {
			if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount >= 5) {
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
					double _setval = ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount - 5);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ChakraAmount = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount <= 4.9) {
				{
					boolean _setval = (false);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.Kagutsuchi = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
		if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).AmaterasuSusano == true) {
			if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).mangekyousharingansusanostage == 1) {
				if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount >= 2) {
					{
						double _setval = ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount - 2);
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
				} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount <= 1.9) {
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
			} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).mangekyousharingansusanostage == 2) {
				if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount >= 4) {
					{
						double _setval = ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount - 4);
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
				} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount <= 3.9) {
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
			} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).mangekyousharingansusanostage == 3) {
				if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount >= 6) {
					{
						double _setval = ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount - 6);
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
				} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount <= 5.9) {
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
			} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).mangekyousharingansusanostage == 4) {
				if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount >= 8) {
					{
						double _setval = ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount - 8);
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
				} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount <= 7.9) {
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
		} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).AmaterasuSusano == false) {
			if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).mangekyousharingansusanostage == 1) {
				if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount >= 1) {
					{
						double _setval = ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount - 1);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.ChakraAmount = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof LivingEntity)
						((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.RESISTANCE, (int) 10, (int) 0, (false), (false)));
				} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount <= 0.9) {
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
			} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).mangekyousharingansusanostage == 2) {
				if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount >= 3) {
					{
						double _setval = ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount - 3);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.ChakraAmount = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof LivingEntity)
						((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.RESISTANCE, (int) 10, (int) 1, (false), (false)));
				} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount <= 2.9) {
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
			} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).mangekyousharingansusanostage == 3) {
				if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount >= 5) {
					{
						double _setval = ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount - 5);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.ChakraAmount = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof LivingEntity)
						((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.RESISTANCE, (int) 10, (int) 2, (false), (false)));
				} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount <= 4.9) {
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
			} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).mangekyousharingansusanostage == 4) {
				if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount >= 7) {
					{
						double _setval = ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount - 7);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.ChakraAmount = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof LivingEntity)
						((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.RESISTANCE, (int) 10, (int) 3, (false), (false)));
				} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount <= 6.9) {
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
					- Math.ceil((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount
							* (76 / Math.max((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraMax, 1))));
			entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.ChakraBarfill = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			double _setval = (0 + 76
					- Math.ceil((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoShippudenModVariables.PlayerVariables())).Health
							* (76 / Math.max((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NarutoShippudenModVariables.PlayerVariables())).HealthMax, 1))));
			entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.HPBarfill = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).DashCooldown == true) {
			if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).DashCooldownTicks <= 59) {
				{
					double _setval = ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoShippudenModVariables.PlayerVariables())).DashCooldownTicks + 1);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.DashCooldownTicks = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).DashCooldownTicks >= 60) {
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
		if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).UpDashCooldown == true) {
			if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).UpDashCooldownTicks <= 59) {
				{
					double _setval = ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoShippudenModVariables.PlayerVariables())).UpDashCooldownTicks + 1);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.UpDashCooldownTicks = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).UpDashCooldownTicks >= 60) {
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
		if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).Dash == true) {
			if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).DashReset <= 9) {
				{
					double _setval = ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoShippudenModVariables.PlayerVariables())).DashReset + 1);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.DashReset = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).DashReset >= 10) {
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
		if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).Chakra_Control == true) {
			if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).WallClimb == false) {
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
			if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).WaterWalk == false) {
				if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).WHold == true) {
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
