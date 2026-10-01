package net.mcreator.narutoshippudenmod.core;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.mcreator.narutoshippudenmod.NarutoShippudenMod;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.fml.loading.FMLPaths;
import net.neoforged.neoforge.common.ModConfigSpec;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.function.Consumer;

/**
 * The mod's settings: config/naruto_shippuden-common.toml, also editable in game (Mods, Naruto Shippuden, Config). Values are read
 * from memory; the old code used to read config/narutoshippuden/narutoshippudenconfig.json from disk, some of it every tick. That
 * file is imported once, then renamed to .old.
 */
@EventBusSubscriber(modid = "naruto_shippuden")
public final class NarutoConfig {
	public static final ModConfigSpec SPEC;

	public static final ModConfigSpec.BooleanValue RANDOM_CLAN;
	public static final ModConfigSpec.DoubleValue KEKKEI_GENKAI_AT_BIRTH;

	public static final ModConfigSpec.DoubleValue SHARINGAN;
	public static final ModConfigSpec.DoubleValue MANGEKYOU_SHARINGAN;
	public static final ModConfigSpec.DoubleValue BYAKUGAN;
	public static final ModConfigSpec.DoubleValue KETSURYUGAN;
	public static final ModConfigSpec.DoubleValue TENSEIGAN;
	public static final ModConfigSpec.DoubleValue RINNEGAN;
	public static final ModConfigSpec.DoubleValue KOKUGAN;

	public static final ModConfigSpec.BooleanValue COMBINE_NATURES;
	public static final ModConfigSpec.BooleanValue PROTECT_VILLAGES;

	static {
		ModConfigSpec.Builder b = new ModConfigSpec.Builder();
		b.comment("Starting out: what new players get the first time they join").push("clans");
		RANDOM_CLAN = b.comment("true: new players get a Clan Paper and a Chakra Paper to roll their clan and nature at random.",
				"false: new players choose their clan on a screen.").define("random_clan", false);
		KEKKEI_GENKAI_AT_BIRTH = b.comment("Percent chance a new player is born with a random kekkei genkai.")
				.defineInRange("kekkei_genkai_at_birth_percent", 1.0, 0, 100);
		b.pop();

		b.comment("Eyes: minutes of play before a clan member's eye awakens on its own").push("awakening");
		SHARINGAN = minutes(b, "sharingan", "Uchiha", 30);
		MANGEKYOU_SHARINGAN = minutes(b, "mangekyou_sharingan", "Uchiha (the letter that starts it)", 90);
		BYAKUGAN = minutes(b, "byakugan", "Hyuga", 40);
		KETSURYUGAN = minutes(b, "ketsuryugan", "Chinoike", 33.3);
		TENSEIGAN = minutes(b, "tenseigan", "Otsutsuki (Byakugan path)", 120);
		RINNEGAN = minutes(b, "rinnegan", "Otsutsuki (Sharingan path)", 180);
		KOKUGAN = minutes(b, "kokugan", "Otsutsuki (Kokugan path)", 150);
		b.pop();

		b.comment("DNA: shinobi drop it; right-click to identify, then to implant").push("dna");
		COMBINE_NATURES = b.comment("true: a kekkei genkai needs the natures it combines (Ice: Water and Wind, Wood: Earth and Water...).",
				"false: any kekkei genkai DNA can be implanted.").define("combine_natures", true);
		b.pop();

		b.comment("Chikyu, the story's world").push("chikyu");
		PROTECT_VILLAGES = b.comment("true: nobody can break or place blocks inside the hidden villages' walls or at the toriis, and explosions,",
				"fire and mobs do them no harm (doors, buttons and seats still work; operators in creative mode can still build).",
				"false: the villages are open to build in, like the wild land.").define("protect_villages", true);
		b.pop();
		SPEC = b.build();
	}

	private static ModConfigSpec.DoubleValue minutes(ModConfigSpec.Builder b, String name, String who, double minutes) {
		return b.comment(who).defineInRange(name + "_minutes", minutes, 0, 100000);
	}

	private NarutoConfig() {
	}

	/** A value, or its default before the config has loaded. */
	private static <T> T get(ModConfigSpec.ConfigValue<T> value) {
		return SPEC.isLoaded() ? value.get() : value.getDefault();
	}

	public static boolean randomClan() {
		return get(RANDOM_CLAN);
	}

	public static double kekkeiGenkaiAtBirth() {
		return get(KEKKEI_GENKAI_AT_BIRTH);
	}

	public static boolean combineNatures() {
		return get(COMBINE_NATURES);
	}

	/** The awakening times in seconds (the old procedures count seconds of play). */
	public static double seconds(ModConfigSpec.DoubleValue minutes) {
		return get(minutes) * 60;
	}

	// ------------------------------------------------------------------ the old JSON file
	private static final Path OLD = FMLPaths.CONFIGDIR.get().resolve("narutoshippuden/narutoshippudenconfig.json");

	/** Brings the old file's values over (once), then renames it so it isn't read again. */
	@SubscribeEvent
	public static void onLoad(ModConfigEvent.Loading event) {
		if (event.getConfig().getSpec() != SPEC || !Files.exists(OLD))
			return;
		try {
			JsonObject old = new Gson().fromJson(Files.readString(OLD), JsonObject.class);
			if (old != null) {
				take(old, "clan_random", e -> RANDOM_CLAN.set(e.getAsBoolean()));
				take(old, "kekkei_genkai_spawn_chance", e -> KEKKEI_GENKAI_AT_BIRTH.set(clamp(e.getAsDouble(), 100)));
				take(old, "sharingan_awake", e -> SHARINGAN.set(clamp(e.getAsDouble() / 60, 100000)));
				take(old, "mangekyou_sharingan_awake", e -> MANGEKYOU_SHARINGAN.set(clamp(e.getAsDouble() / 60, 100000)));
				take(old, "byakugan_awake", e -> BYAKUGAN.set(clamp(e.getAsDouble() / 60, 100000)));
				take(old, "ketsuryugan_awake", e -> KETSURYUGAN.set(clamp(e.getAsDouble() / 60, 100000)));
				take(old, "tenseigan_awake", e -> TENSEIGAN.set(clamp(e.getAsDouble() / 60, 100000)));
				take(old, "rinnegan_awake", e -> RINNEGAN.set(clamp(e.getAsDouble() / 60, 100000)));
				take(old, "isshiki_dojutsu_awake", e -> KOKUGAN.set(clamp(e.getAsDouble() / 60, 100000)));
				take(old, "dna_combine_natures", e -> COMBINE_NATURES.set(e.getAsBoolean()));
				SPEC.save();
			}
			Files.move(OLD, OLD.resolveSibling("narutoshippudenconfig.json.old"));
			NarutoShippudenMod.LOGGER.info("Moved the old Naruto Shippuden config into naruto_shippuden-common.toml");
		} catch (IOException | RuntimeException e) {
			NarutoShippudenMod.LOGGER.warn("Couldn't read the old Naruto Shippuden config: {}", e.toString());
		}
	}

	private static void take(JsonObject old, String key, Consumer<JsonElement> set) {
		if (old.has(key) && old.get(key).isJsonPrimitive())
			set.accept(old.get(key));
	}

	/** Within 0..max, to two decimals (2000 seconds is 33.33 minutes). */
	private static double clamp(double value, double max) {
		return Math.round(Math.max(0, Math.min(max, value)) * 100) / 100.0;
	}
}
