package net.mcreator.narutoshippudenmod.core;

import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;

import net.mcreator.narutoshippudenmod.NarutoShippudenMod;
import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables;

import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.GameType;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.RegisterCommandsEvent;

import java.util.Set;

/**
 * Development only (-Dnaruto.devtest=true): the server half of the dev tests (client/DevTest). In singleplayer the test calls these
 * directly; against a dedicated server it sends /narutodev, so the same code runs there:
 * <ul>
 * <li>{@code setup}: every release learned, the eyes awakened, chakra to spare (the jutsu test);</li>
 * <li>{@code prepare <technique> <index>}: before one cast (eyes for it, chakra, its cooldown cleared, the jutsu selected);</li>
 * <li>{@code mimic <step>}: logs where the Shadow Imitation caster and its catch stand;</li>
 * <li>{@code watch}: every other player becomes a spectator beside the arena, looking at it (the watcher client);</li>
 * <li>{@code shot <name>}: tells the other players to save a screenshot ("DEVSHOT name" in chat).</li>
 * </ul>
 */
@EventBusSubscriber(modid = "naruto_shippuden")
public final class DevServer {
	/** Custom jutsu the jutsu test gives the player: one of each form, over the five natures. */
	public static final String TEST_CUSTOM = String.join("\n", "Test Bullets|fire|BULLETS|1|2|3", "Test Sphere|fire|SPHERE|2|1|5",
			"Test Rain|fire|RAIN|1|1|4", "Test Shuriken|water|SHURIKEN|1|2|3", "Test Stream|water|STREAM|2|1|3", "Test Beast|lightning|BEAST|1|1|4",
			"Test Dragon|earth|DRAGON|2|1|5", "Test Wave|wind|WAVE|1|1|3", "Test Burst|wind|BURST|2|1|4");

	private DevServer() {
	}

	@SubscribeEvent
	public static void register(RegisterCommandsEvent event) {
		if (!TickProfiler.ENABLED)
			return;
		event.getDispatcher().register(Commands.literal("narutodev").requires(source -> source.getPlayer() != null)
				.then(Commands.literal("setup").executes(c -> run(() -> setup(c.getSource().getPlayerOrException()))))
				.then(Commands.literal("prepare").then(Commands.argument("technique", StringArgumentType.word())
						.then(Commands.argument("index", IntegerArgumentType.integer(0)).executes(c -> run(() -> prepare(c.getSource().getPlayerOrException(),
								StringArgumentType.getString(c, "technique"), IntegerArgumentType.getInteger(c, "index")))))))
				.then(Commands.literal("mimic").then(Commands.argument("step", IntegerArgumentType.integer(0))
						.executes(c -> run(() -> mimic(c.getSource().getPlayerOrException(), IntegerArgumentType.getInteger(c, "step"))))))
				.then(Commands.literal("watch").executes(c -> run(() -> watch(c.getSource().getPlayerOrException()))))
				.then(Commands.literal("shot").then(Commands.argument("name", StringArgumentType.word())
						.executes(c -> run(() -> shot(c.getSource().getPlayerOrException(), StringArgumentType.getString(c, "name")))))));
	}

	private interface Task {
		void run() throws Exception;
	}

	private static int run(Task task) {
		try {
			task.run();
			return 1;
		} catch (Exception e) {
			NarutoShippudenMod.LOGGER.warn("DEVTEST narutodev failed", e);
			return 0;
		}
	}

	/** The technique item a test name stands for ("fire" is fire_release_technique; weapons and full ids as they are). */
	public static String item(String nature) {
		return nature.endsWith("technique") || net.mcreator.narutoshippudenmod.core.jutsu.Weapons.KENJUTSU.containsKey(nature) ? nature
				: nature + "_release_technique";
	}

	public static void setup(ServerPlayer player) {
		NarutoShippudenModVariables.ifPresent(player, v -> {
			v.firereleaselogic = v.waterreleaselogic = v.windreleaselogic = v.earthreleaselogic = v.lightningreleaselogic = true;
			v.firelearn = v.waterlearn = v.windlearn = v.earthlearn = v.lightninglearn = 9;
			v.boilreleaselogic = v.bonereleaselogic = v.dustreleaselogic = v.icereleaselogic = v.magnetreleaselogic = v.smokereleaselogic = true;
			v.steelreleaselogic = v.stormreleaselogic = v.swiftreleaselogic = v.typhoonreleaslogic = v.woodreleaselogic = true;
			v.boillearn = v.bonelearn = v.dustlearn = v.icelearn = v.magnetlearn = v.smokelearn = v.steellearn = v.stormlearn = v.swiftlearn = 9;
			v.typhoonlearn = v.woodlearn = 9;
			v.aburamereleaselogic = v.akimichireleaselogic = v.fumareleaselogic = v.hozukireleaselogic = v.hyugareleaselogic = true;
			v.inuzukareleaselogic = v.leereleaselogic = v.narareleaselogic = v.sarutobireleaselogic = true;
			v.uzumakireleaselogic = v.tsuchigumoreleaselogic = true;
			v.aburamelearn = v.akimichilearn = v.fumalearn = v.hozukilearn = v.hyugalearn = v.inuzukalearn = v.leelearn = 9;
			v.naralearn = v.sarutobilearn = v.uzumakilearn = v.tsuchigumolearn = 9;
			v.uchihareleaselogic = v.yamanakareleaselogic = true;
			v.uchihalearn = v.yamanakalearn = 9;
			v.byakugan = v.ketsuryugan = v.rinnegan = v.tenseigan = true;
			v.ketsuryuganactivate = v.rinneganactivate = v.tenseiganactivate = true;
			v.byakuganlearn = v.ketsuryuganlearn = v.rinneganlearn = v.tenseiganlearn = 9;
			v.mangekyousharinganshisuilearn = v.mangekyousharinganmadaralearn = 9;
			v.taijutsu = v.summoning = 60;
			v.sharingan = v.sharinganactivate = v.isshikidojutsu = v.isshikidojutsuactivate = v.MangekyouSharinganActivate = true;
			v.sharinganlearn = v.isshikidojutsulearn = v.mangekyoushrainganitachiamaterasulearn = 9;
			v.mangekyousharingankakashikamuilearn = v.mangekyousharinganobitokamuilearn = v.mangekyousharingansasukeamaterasulearn = 9;
			v.ninjutsu = 60;
			v.kenjutsu = 100;
			v.custom_jutsu = TEST_CUSTOM;
			net.mcreator.narutoshippudenmod.core.jutsu.Jutsus.migrate(v, true);
			v.byakuganactivate = false;
			v.ChakraMax = 5000;
			v.ChakraAmount = 5000;
			v.syncPlayerVariables(player);
		});
	}

	public static void prepare(ServerPlayer player, String nature, int i) {
		net.mcreator.narutoshippudenmod.core.jutsu.ClanJutsu.stop(player);
		NarutoShippudenModVariables.ifPresent(player, v -> {
			v.ChakraAmount = 5000;
			// the eye this technique needs (Izanagi closes them; only one Mangekyou at a time)
			v.sharinganactivate = v.MangekyouSharinganActivate = true;
			v.byakuganactivate = nature.equals("byakugan");
			v.ketsuryuganactivate = v.rinneganactivate = v.tenseiganactivate = true;
			v.MangekyouSharinganItachi = nature.contains("itachi");
			v.MangekyouSharinganKakashi = nature.contains("kakashi");
			v.MangekyouSharinganObito = nature.contains("obito");
			v.MangekyouSharinganSasuke = nature.contains("sasuke");
			v.MangekyouSharinganShisui = nature.contains("shisui");
			v.MangekyouSharinganMadara = nature.contains("madara");
			v.syncPlayerVariables(player);
		});
		player.getCooldowns().removeCooldown(net.minecraft.resources.Identifier.fromNamespaceAndPath("naruto_shippuden", item(nature) + "/" + i));
		player.removeAllEffects();
		if (nature.equals("hiramekarei"))
			net.mcreator.narutoshippudenmod.compat.StackTag.of(player.getMainHandItem()).putDouble("StoredChakra", 1000);
		if (nature.equals("chakra_blade"))
			player.setItemInHand(net.minecraft.world.InteractionHand.OFF_HAND, player.getMainHandItem().copy());
		net.mcreator.narutoshippudenmod.core.jutsu.Jutsus.select(player,
				net.minecraft.resources.Identifier.fromNamespaceAndPath("naruto_shippuden", item(nature)), i);
	}

	public static void mimic(ServerPlayer player, int n) {
		net.minecraft.world.entity.LivingEntity husk = player.level().getEntitiesOfClass(net.minecraft.world.entity.monster.zombie.Husk.class,
				player.getBoundingBox().inflate(30)).stream().min(java.util.Comparator.comparingDouble(h -> Math.abs(h.getX() - player.getX()))).orElse(null);
		NarutoShippudenMod.LOGGER.info("DEVTEST nara mimic {}: caster x {} husk x {}", n, String.format("%.2f", player.getX()),
				husk == null ? "none" : String.format("%.2f", husk.getX()));
	}

	/** The other players watch from the arena's side: spectators 9 blocks to the left of the caster, level with the targets' middle. */
	public static void watch(ServerPlayer caster) {
		for (ServerPlayer other : caster.level().getServer().getPlayerList().getPlayers()) {
			if (other == caster)
				continue;
			other.setGameMode(GameType.SPECTATOR);
			double x = caster.getX() - 9, y = caster.getY() + 2.5, z = caster.getZ() + 8;
			other.teleportTo(caster.level(), x, y, z, Set.of(), -90, 10, true);
			NarutoShippudenMod.LOGGER.info("DEVTEST watcher {} at {} {} {}", other.getName().getString(), (int) x, (int) y, (int) z);
		}
	}

	public static void shot(ServerPlayer caster, String name) {
		for (ServerPlayer other : caster.level().getServer().getPlayerList().getPlayers())
			if (other != caster)
				other.sendSystemMessage(Component.literal("DEVSHOT " + name));
	}
}
