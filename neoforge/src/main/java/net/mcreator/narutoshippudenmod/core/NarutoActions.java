package net.mcreator.narutoshippudenmod.core;

import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables;
import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables.PlayerVariables;
import net.mcreator.narutoshippudenmod.procedures.CheatProcedures;
import net.mcreator.narutoshippudenmod.procedures.DojutsuProcedures;
import net.mcreator.narutoshippudenmod.procedures.GuiProcedures;
import net.mcreator.narutoshippudenmod.procedures.KeybindProcedures;

import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.permissions.Permissions;
import net.minecraft.world.level.GameType;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.tick.ServerTickEvent;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.handling.IPayloadContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.ToDoubleFunction;

import org.jspecify.annotations.Nullable;

/**
 * Everything the cheat menu, the info card pages and the {@code /naruto} command can do, by name, on the server. The
 * menus send an {@link Action}; the command calls the same entries. Cheats need creative mode or operator rights, the
 * info card pages and the SP-per-click preference do not.
 */
@EventBusSubscriber(modid = "naruto_shippuden")
public final class NarutoActions {
	private NarutoActions() {
	}

	// ------------------------------------------------------------------ registries
	/** A number on the player that can be read and set. */
	public record Value(String name, ToDoubleFunction<PlayerVariables> get, BiConsumer<PlayerVariables, Double> set) {
	}

	/** Something done by running one of the generated procedures. */
	public record Entry(String name, Consumer<Map<String, Object>> run) {
	}

	/** A dojutsu: the cheat that gives it at once, and the awakening (message, effects) if it has one. */
	public record Dojutsu(String name, Consumer<Map<String, Object>> give, @Nullable Consumer<Map<String, Object>> awaken) {
	}

	public static final Map<String, Value> VALUES = new LinkedHashMap<>();
	public static final Map<String, Dojutsu> DOJUTSU = new LinkedHashMap<>();
	public static final Map<String, Entry> KEKKEI_GENKAI = new LinkedHashMap<>();
	public static final Map<String, Entry> RANKS = new LinkedHashMap<>();
	public static final Map<String, Entry> RESETS = new LinkedHashMap<>();
	/** Menus anyone may open (the info card pages); "cheat" checks creative mode itself, "select" is a cheat. */
	public static final Map<String, Entry> PAGES = new LinkedHashMap<>();
	public static final String SP_PER_CLICK = "sp_per_click";

	static {
		value("level", "Level", v -> v.LEVELSTAT, (v, n) -> {
			v.LEVELSTAT = n;
			v.LEVELMAX = n + 1;
			v.LEVEL = Math.min(v.LEVEL, v.LEVELMAX - 1);
		});
		value("xp", "Level XP", v -> v.LEVEL, (v, n) -> v.LEVEL = n);
		value("jp", "JP", v -> v.jp, (v, n) -> v.jp = n);
		value("sp", "SP", v -> v.sp, (v, n) -> v.sp = n);
		value("chakra", "Chakra", v -> v.ChakraAmount, (v, n) -> v.ChakraAmount = n);
		value("max_chakra", "Max Chakra", v -> v.ChakraMax, (v, n) -> v.ChakraMax = n);
		value("ninjutsu", "Ninjutsu", v -> v.ninjutsu, (v, n) -> v.ninjutsu = n);
		value("taijutsu", "Taijutsu", v -> v.taijutsu, (v, n) -> v.taijutsu = n);
		value("kenjutsu", "Kenjutsu", v -> v.kenjutsu, (v, n) -> v.kenjutsu = n);
		value("shurikenjutsu", "Shurikenjutsu", v -> v.shurikenjutsu, (v, n) -> v.shurikenjutsu = n);
		value("summoning", "Summoning", v -> v.summoning, (v, n) -> v.summoning = n);
		value("kinjutsu", "Kinjutsu", v -> v.kinjutsu, (v, n) -> v.kinjutsu = n);
		value("senjutsu", "Senjutsu", v -> v.senjutsu, (v, n) -> v.senjutsu = n);
		value("medicine", "Medicine", v -> v.medicine, (v, n) -> v.medicine = n);
		value("speed", "Speed", v -> v.speed, (v, n) -> v.speed = n);
		value("jutsu_power", "Jutsu Power", v -> v.jutsupowerstat, (v, n) -> v.jutsupowerstat = n);
		value("genjutsu", "Genjutsu", v -> v.genjutsu, (v, n) -> v.genjutsu = n);
		value("iq", "IQ", v -> v.IQ, (v, n) -> v.IQ = n);
		value(SP_PER_CLICK, "SP per click", v -> v.spusecount, (v, n) -> v.spusecount = Math.max(1, Math.min(1000, Math.floor(n))));

		dojutsu("sharingan", "Sharingan", CheatProcedures.CheatDojutsuButtonSharinganProcedure::executeProcedure,
				DojutsuProcedures.SharinganAwakeProcedure::executeProcedure);
		dojutsu("byakugan", "Byakugan", CheatProcedures.CheatDojutsuButtonByakuganProcedure::executeProcedure,
				DojutsuProcedures.ByakuganAwakeProcedure::executeProcedure);
		dojutsu("ketsuryugan", "Ketsuryugan", CheatProcedures.CheatDojutsuButtonKetsuryuganProcedure::executeProcedure,
				DojutsuProcedures.KetsuryuganAwakeProcedure::executeProcedure);
		dojutsu("rinnegan", "Rinnegan", CheatProcedures.CheatDojutsuButtonRinneganProcedure::executeProcedure,
				DojutsuProcedures.RinneganAwakeProcedure::executeProcedure);
		dojutsu("tenseigan", "Tenseigan", CheatProcedures.CheatDojutsuButtonTenseiganProcedure::executeProcedure,
				DojutsuProcedures.TenseiganAwakeProcedure::executeProcedure);
		dojutsu("isshiki_dojutsu", "Isshiki Dojutsu", CheatProcedures.CheatDojutsuButtonIsshikiDojutsuProcedure::executeProcedure,
				DojutsuProcedures.IsshikiDojutsuAwakeProcedure::executeProcedure);
		dojutsu("kakashi_sharingan", "Kakashi Sharingan", CheatProcedures.KakashiSharinganCheatProcedure::executeProcedure,
				DojutsuProcedures.KakashiSharinganAwakeProcedure::executeProcedure);
		dojutsu("shimura_sharingan", "Shimura Sharingan", CheatProcedures.CheatDojutstuButtonShimuraProcedure::executeProcedure,
				DojutsuProcedures.ShimuraSharinganAwakeProcedure::executeProcedure);
		// Mangekyou: awakening is the crow letter quest (Kakashi has his own)
		Consumer<Map<String, Object>> letter = DojutsuProcedures.MSharinganAwakeProcedure::executeProcedure;
		dojutsu("mangekyou_sasuke", "Mangekyou Sharingan (Sasuke)", CheatProcedures.SasukeMSCheatProcedure::executeProcedure, letter);
		dojutsu("mangekyou_itachi", "Mangekyou Sharingan (Itachi)", CheatProcedures.ItachiMSCheatProcedure::executeProcedure, letter);
		dojutsu("mangekyou_madara", "Mangekyou Sharingan (Madara)", CheatProcedures.MadaraMSCheatProcedure::executeProcedure, letter);
		dojutsu("mangekyou_obito", "Mangekyou Sharingan (Obito)", CheatProcedures.ObitoMSCheatProcedure::executeProcedure, letter);
		dojutsu("mangekyou_shisui", "Mangekyou Sharingan (Shisui)", CheatProcedures.ShisuiMSCheatProcedure::executeProcedure, letter);
		dojutsu("mangekyou_kakashi", "Mangekyou Sharingan (Kakashi)", CheatProcedures.KakashiMSCheatProcedure::executeProcedure,
				DojutsuProcedures.KakashiMSharinganAwakeProcedure::executeProcedure);

		kekkeiGenkai("ice", "Ice Release", CheatProcedures.CheatKekkeiGenkaiButtonIceReleaseProcedure::executeProcedure);
		kekkeiGenkai("wood", "Wood Release", CheatProcedures.CheatKekkeiGenkaiButtonWoodReleaseProcedure::executeProcedure);
		kekkeiGenkai("magnet", "Magnet Release", CheatProcedures.CheatKekkeiGenkaiButtonMagnetReleaseProcedure::executeProcedure);
		kekkeiGenkai("storm", "Storm Release", CheatProcedures.CheatKekkeiGenkaiButtonStormReleaseProcedure::executeProcedure);
		kekkeiGenkai("smoke", "Smoke Release", CheatProcedures.CheatKekkeiGenkaiButtonSmokeReleaseProcedure::executeProcedure);
		kekkeiGenkai("steel", "Steel Release", CheatProcedures.CheatKekkeiGenkaiButtonSteelReleaseProcedure::executeProcedure);
		kekkeiGenkai("boil", "Boil Release", CheatProcedures.CheatKekkeiGenkaiButtonBoilReleaseProcedure::executeProcedure);
		kekkeiGenkai("bone", "Bone Release", CheatProcedures.CheatKekkeiGenkaiButtonBoneReleaseProcedure::executeProcedure);
		kekkeiGenkai("swift", "Swift Release", CheatProcedures.CheatKekkeiGenkaiButtonSwiftReleaseProcedure::executeProcedure);
		kekkeiGenkai("typhoon", "Typhoon Release", CheatProcedures.CheatKekkeiGenkaiButtonTyphoonReleaseProcedure::executeProcedure);
		kekkeiGenkai("dust", "Dust Release", CheatProcedures.CheatKekkeiGenkaiButtonDustReleaseProcedure::executeProcedure);

		RANKS.put("academy_student", new Entry("Academy Student", GuiProcedures.RankSetAcademyStudentProcedure::executeProcedure));
		RANKS.put("genin", new Entry("Genin", GuiProcedures.RankSetGeninProcedure::executeProcedure));
		RANKS.put("chunin", new Entry("Chunin", GuiProcedures.RankSetChuninProcedure::executeProcedure));
		RANKS.put("jonin", new Entry("Jonin", GuiProcedures.RankSetJoninProcedure::executeProcedure));
		RANKS.put("kage", new Entry("Kage", GuiProcedures.RankSetKageProcedure::executeProcedure));

		RESETS.put("stats", new Entry("Upgrading stats", GuiProcedures.ResetUpgradeStatsProcedure::executeProcedure));
		RESETS.put("info", new Entry("Info card stats", GuiProcedures.ResetInfoStatsProcedure::executeProcedure));
		RESETS.put("level", new Entry("Level, JP and SP", GuiProcedures.ResetLevelJPandSPProcedure::executeProcedure));
		RESETS.put("dojutsu", new Entry("Dojutsu", GuiProcedures.ResetDojutsuProcedure::executeProcedure));

		PAGES.put("info", new Entry("Info Card", KeybindProcedures.InfoCardOpenOnKeyPressedProcedure::executeProcedure));
		PAGES.put("stats", new Entry("Stats", GuiProcedures.InfoCardNextPageProcedure::executeProcedure));
		PAGES.put("missions", new Entry("Missions", GuiProcedures.QuestGUIOpenProcedure::executeProcedure));
		PAGES.put("dojutsu", new Entry("Dojutsu", GuiProcedures.OpenDojutsuInfoCardProcedure::executeProcedure));
		PAGES.put("jutsu", new Entry("Jutsu", GuiProcedures.JutsuCreateGUIOpenProcedure::executeProcedure));
		PAGES.put("minigame", new Entry("Mini Game", GuiProcedures.MiniGameGUIOpenProcedure::executeProcedure));
		PAGES.put("cheat", new Entry("Cheats", CheatProcedures.CheatGUIProcedure::executeProcedure));
		PAGES.put("select", new Entry("Choose Your Path", GuiProcedures.SelectMenuProcedure::executeProcedure));
	}

	private static void value(String id, String name, ToDoubleFunction<PlayerVariables> get, BiConsumer<PlayerVariables, Double> set) {
		VALUES.put(id, new Value(name, get, set));
	}

	private static void dojutsu(String id, String name, Consumer<Map<String, Object>> give, @Nullable Consumer<Map<String, Object>> awaken) {
		DOJUTSU.put(id, new Dojutsu(name, give, awaken));
	}

	private static void kekkeiGenkai(String id, String name, Consumer<Map<String, Object>> give) {
		KEKKEI_GENKAI.put(id, new Entry(name, give));
	}

	// ------------------------------------------------------------------ running them
	public static boolean canCheat(ServerPlayer player) {
		return player.gameMode.getGameModeForPlayer() == GameType.CREATIVE || player.permissions().hasPermission(Permissions.COMMANDS_GAMEMASTER);
	}

	public static Map<String, Object> dependencies(ServerPlayer player) {
		Map<String, Object> dependencies = new HashMap<>();
		dependencies.put("entity", player);
		dependencies.put("world", player.level());
		dependencies.put("x", player.getX());
		dependencies.put("y", player.getY());
		dependencies.put("z", player.getZ());
		return dependencies;
	}

	public static void setValue(ServerPlayer player, Value value, double amount) {
		NarutoShippudenModVariables.ifPresent(player, variables -> {
			value.set().accept(variables, amount);
			variables.syncPlayerVariables(player);
		});
	}

	public static void run(ServerPlayer player, Consumer<Map<String, Object>> procedure) {
		procedure.accept(dependencies(player));
	}

	/** Gives a dojutsu at once ({@code seconds < 0}) or awakens it after {@code seconds}. */
	public static boolean dojutsu(ServerPlayer player, Dojutsu dojutsu, int seconds) {
		if (seconds < 0) {
			run(player, dojutsu.give());
			return true;
		}
		if (dojutsu.awaken() == null)
			return false;
		if (seconds == 0)
			run(player, dojutsu.awaken());
		else
			later(player, seconds * 20, target -> run(target, dojutsu.awaken()));
		return true;
	}

	/** Awakenings waiting to happen; kept by player id so they survive death and respawn. */
	private record Pending(long due, UUID player, Consumer<ServerPlayer> task) {
	}

	private static final List<Pending> PENDING = new ArrayList<>();

	public static void later(ServerPlayer player, int ticks, Consumer<ServerPlayer> task) {
		PENDING.add(new Pending(player.level().getServer().getTickCount() + ticks, player.getUUID(), task));
	}

	@SubscribeEvent
	public static void tick(ServerTickEvent.Post event) {
		if (PENDING.isEmpty())
			return;
		long now = event.getServer().getTickCount();
		for (Iterator<Pending> it = PENDING.iterator(); it.hasNext();) {
			Pending pending = it.next();
			if (now < pending.due())
				continue;
			it.remove();
			ServerPlayer player = event.getServer().getPlayerList().getPlayer(pending.player());
			if (player != null)
				pending.task().accept(player);
		}
	}

	// ------------------------------------------------------------------ network: the menus' requests
	/**
	 * kind: set (key = value id, amount), dojutsu (key = dojutsu id, amount = seconds, below 0 = give now), kekkei_genkai,
	 * rank, reset, page (key = id), jutsu (key = technique item id, amount = jutsu index), learn (key = release item id).
	 */
	public record Action(String kind, String key, double amount) implements CustomPacketPayload {
		public static final Type<Action> TYPE = new Type<>(Identifier.fromNamespaceAndPath("naruto_shippuden", "action"));
		public static final StreamCodec<RegistryFriendlyByteBuf, Action> CODEC = StreamCodec.composite(ByteBufCodecs.STRING_UTF8, Action::kind,
				ByteBufCodecs.STRING_UTF8, Action::key, ByteBufCodecs.DOUBLE, Action::amount, Action::new);

		@Override
		public Type<Action> type() {
			return TYPE;
		}
	}

	@SubscribeEvent
	public static void registerPayloads(RegisterPayloadHandlersEvent event) {
		event.registrar("1").playToServer(Action.TYPE, Action.CODEC, NarutoActions::handle);
	}

	private static void handle(Action action, IPayloadContext context) {
		context.enqueueWork(() -> {
			if (!(context.player() instanceof ServerPlayer player))
				return;
			boolean open = action.kind().equals("page") && !action.key().equals("select")
					|| action.kind().equals("set") && action.key().equals(SP_PER_CLICK) || action.kind().equals("jutsu") || action.kind().equals("learn");
			if (!open && !canCheat(player)) {
				player.sendSystemMessage(Component.literal("Cheats need creative mode or operator rights."));
				return;
			}
			switch (action.kind()) {
				case "set" -> {
					Value value = VALUES.get(action.key());
					if (value != null && Double.isFinite(action.amount()))
						setValue(player, value, action.amount());
				}
				case "dojutsu" -> {
					Dojutsu dojutsu = DOJUTSU.get(action.key());
					if (dojutsu != null)
						dojutsu(player, dojutsu, (int) Math.max(-1, Math.min(3600, action.amount())));
				}
				case "kekkei_genkai" -> runEntry(player, KEKKEI_GENKAI.get(action.key()));
				case "rank" -> runEntry(player, RANKS.get(action.key()));
				case "reset" -> runEntry(player, RESETS.get(action.key()));
				case "page" -> runEntry(player, PAGES.get(action.key()));
				case "jutsu" -> {
					Identifier item = Identifier.tryParse(action.key());
					if (item != null)
						net.mcreator.narutoshippudenmod.core.jutsu.Jutsus.select(player, item, (int) action.amount());
				}
				case "learn" -> {
					Identifier item = Identifier.tryParse(action.key());
					if (item != null)
						net.mcreator.narutoshippudenmod.core.jutsu.Jutsus.learn(player, item, (int) action.amount());
				}
				default -> {
				}
			}
		});
	}

	private static void runEntry(ServerPlayer player, @Nullable Entry entry) {
		if (entry != null)
			run(player, entry.run());
	}
}
