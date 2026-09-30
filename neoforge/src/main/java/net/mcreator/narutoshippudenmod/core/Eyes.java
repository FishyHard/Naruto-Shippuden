package net.mcreator.narutoshippudenmod.core;

import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables;
import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables.PlayerVariables;
import net.mcreator.narutoshippudenmod.procedures.KeybindProcedures;

import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.ToDoubleFunction;

import org.jspecify.annotations.Nullable;

/**
 * Dojutsu and Susanoo on two keys. The Dojutsu key: tap to open your eye, tap again to step the Sharingan up to the Mangekyou
 * (or close it), sneak and tap to close every eye, hold to choose between eyes on a wheel. The Susanoo key: hold to build the
 * Susanoo up stage by stage, tap to dismiss it. Opening and closing still run each eye's own procedure (messages, effects).
 */
@EventBusSubscriber(modid = "naruto_shippuden")
public final class Eyes {
	private Eyes() {
	}

	public record Eye(String id, String name, Predicate<PlayerVariables> has, Predicate<PlayerVariables> active, Consumer<Map<String, Object>> toggle) {
	}

	public static final Eye SHARINGAN = new Eye("sharingan", "Sharingan", v -> v.sharingan || v.SharinganKakashi || v.SharinganShimura,
			v -> v.sharinganactivate || v.shimura_active, KeybindProcedures.SharinganOnKeyPressedProcedure::executeProcedure);
	public static final Eye MANGEKYOU = new Eye("mangekyou", "Mangekyou Sharingan", v -> v.MangekyouSharinganItachi || v.MangekyouSharinganSasuke
			|| v.MangekyouSharinganMadara || v.MangekyouSharinganObito || v.MangekyouSharinganShisui || v.MangekyouSharinganKakashi,
			v -> v.MangekyouSharinganActivate, KeybindProcedures.MangekyouSharinganOnKeyPressedProcedure::executeProcedure);
	public static final List<Eye> EYES = List.of(SHARINGAN, MANGEKYOU,
			new Eye("byakugan", "Byakugan", v -> v.byakugan, v -> v.byakuganactivate, KeybindProcedures.ByakuganOnKeyPressedProcedure::executeProcedure),
			new Eye("rinnegan", "Rinnegan", v -> v.rinnegan, v -> v.rinneganactivate, KeybindProcedures.RinneganOnKeyPressedProcedure::executeProcedure),
			new Eye("tenseigan", "Tenseigan", v -> v.tenseigan, v -> v.tenseiganactivate, KeybindProcedures.TenseiganOnKeyPressedProcedure::executeProcedure),
			new Eye("ketsuryugan", "Ketsuryugan", v -> v.ketsuryugan, v -> v.ketsuryuganactivate,
					KeybindProcedures.KetsuryuganOnKeyPressedProcedure::executeProcedure),
			new Eye("isshiki", "Kokugan", v -> v.isshikidojutsu, v -> v.isshikidojutsuactivate,
					KeybindProcedures.IsshikiDojutsuOnKeyPressedProcedure::executeProcedure));
	private static final String PREFERRED = "naruto_shippuden:preferred_eye";

	public static List<Eye> owned(PlayerVariables v) {
		return EYES.stream().filter(e -> e.has().test(v)).toList();
	}

	private static Map<String, Object> dependencies(ServerPlayer player) {
		Map<String, Object> dependencies = new HashMap<>();
		dependencies.put("entity", player);
		dependencies.put("world", player.level());
		dependencies.put("x", player.getX());
		dependencies.put("y", player.getY());
		dependencies.put("z", player.getZ());
		return dependencies;
	}

	private static void toggle(ServerPlayer player, Eye eye) {
		eye.toggle().accept(dependencies(player));
	}

	public static void closeAll(ServerPlayer player) {
		// the Mangekyou (and its Susanoo) close before the Sharingan under them
		if (NarutoShippudenModVariables.get(player).mangekyousharingansusanostage > 0)
			setStage(player, 0);
		for (Eye eye : List.of(MANGEKYOU, SHARINGAN))
			if (eye.active().test(NarutoShippudenModVariables.get(player)))
				toggle(player, eye);
		for (Eye eye : EYES)
			if (eye != MANGEKYOU && eye != SHARINGAN && eye.active().test(NarutoShippudenModVariables.get(player)))
				toggle(player, eye);
	}

	private static @Nullable Eye find(String id) {
		return EYES.stream().filter(e -> e.id().equals(id)).findFirst().orElse(null);
	}

	/** The Dojutsu key tapped (sneaking: close everything). */
	public static void tap(ServerPlayer player, boolean sneaking) {
		PlayerVariables v = NarutoShippudenModVariables.get(player);
		boolean anyOpen = EYES.stream().anyMatch(e -> e.active().test(v));
		if (sneaking || anyOpen && !(SHARINGAN.active().test(v) && MANGEKYOU.has().test(v) && !MANGEKYOU.active().test(v))) {
			if (anyOpen)
				closeAll(player);
			return;
		}
		if (anyOpen) {
			// Sharingan open and the Mangekyou awakened: step up
			toggle(player, MANGEKYOU);
			return;
		}
		List<Eye> owned = owned(v);
		if (owned.isEmpty()) {
			player.sendOverlayMessage(Component.literal("You haven't awakened a dojutsu"));
			return;
		}
		Eye preferred = find(player.getPersistentData().getStringOr(PREFERRED, ""));
		toggle(player, preferred != null && owned.contains(preferred) ? preferred : owned.getFirst());
	}

	/** An eye chosen on the wheel: the others close and it opens. */
	public static void select(ServerPlayer player, String id) {
		Eye eye = find(id);
		if (eye == null || !eye.has().test(NarutoShippudenModVariables.get(player)))
			return;
		player.getPersistentData().putString(PREFERRED, id);
		closeAll(player);
		if (eye == MANGEKYOU && SHARINGAN.has().test(NarutoShippudenModVariables.get(player)))
			toggle(player, SHARINGAN);
		toggle(player, eye);
	}

	// ------------------------------------------------------------------ one mangekyou
	private record Mangekyou(String id, String name, Predicate<PlayerVariables> has, BiConsumer<PlayerVariables, Boolean> set) {
	}

	private static final List<Mangekyou> MANGEKYOU_KINDS = List.of(
			new Mangekyou("itachi", "Itachi", v -> v.MangekyouSharinganItachi, (v, b) -> v.MangekyouSharinganItachi = b),
			new Mangekyou("sasuke", "Sasuke", v -> v.MangekyouSharinganSasuke, (v, b) -> v.MangekyouSharinganSasuke = b),
			new Mangekyou("madara", "Madara", v -> v.MangekyouSharinganMadara, (v, b) -> v.MangekyouSharinganMadara = b),
			new Mangekyou("obito", "Obito", v -> v.MangekyouSharinganObito, (v, b) -> v.MangekyouSharinganObito = b),
			new Mangekyou("shisui", "Shisui", v -> v.MangekyouSharinganShisui, (v, b) -> v.MangekyouSharinganShisui = b),
			new Mangekyou("kakashi", "Kakashi", v -> v.MangekyouSharinganKakashi, (v, b) -> v.MangekyouSharinganKakashi = b));
	private static final String MANGEKYOU_KEPT = "naruto_shippuden:mangekyou";

	/**
	 * A player has one Mangekyou Sharingan. Awakening (or cheating in) another replaces the one they had, so their eyes and
	 * techniques never mix.
	 */
	@SubscribeEvent
	public static void oneMangekyou(PlayerTickEvent.Post event) {
		if (!(event.getEntity() instanceof ServerPlayer player) || player.tickCount % 10 != 0)
			return;
		PlayerVariables v = NarutoShippudenModVariables.get(player);
		List<Mangekyou> owned = MANGEKYOU_KINDS.stream().filter(m -> m.has().test(v)).toList();
		String kept = player.getPersistentData().getStringOr(MANGEKYOU_KEPT, "");
		if (owned.size() <= 1) {
			if (owned.size() == 1 && !owned.getFirst().id().equals(kept))
				player.getPersistentData().putString(MANGEKYOU_KEPT, owned.getFirst().id());
			return;
		}
		// the newest one stays (the last one that isn't the one they had)
		Mangekyou keep = owned.stream().filter(m -> !m.id().equals(kept)).reduce((a, b) -> b).orElse(owned.getFirst());
		NarutoShippudenModVariables.ifPresent(player, vars -> {
			for (Mangekyou m : owned)
				if (m != keep)
					m.set().accept(vars, false);
			vars.mangekyousharingansusanostage = 0;
			vars.syncPlayerVariables(player);
		});
		player.getPersistentData().putString(MANGEKYOU_KEPT, keep.id());
		player.sendOverlayMessage(Component.literal("Your Mangekyou Sharingan is now " + keep.name() + "'s"));
	}

	// ------------------------------------------------------------------ susanoo
	private static final String[] STAGES = { "", "Ribcage", "Skeleton", "Armoured", "Complete" };

	/** How many Susanoo stages the player has bought, for their Mangekyou. */
	private static int maxStage(PlayerVariables v) {
		ToDoubleFunction<PlayerVariables> learned = v.MangekyouSharinganItachi ? x -> x.mangekyoushrainganitachisusanolearn
				: v.MangekyouSharinganSasuke ? x -> x.mangekyousharingansasukesusanolearn
				: v.MangekyouSharinganMadara ? x -> x.mangekyousharinganmadarasusanolearn
				: v.MangekyouSharinganObito ? x -> x.mangekyousharinganobitosusanolearn
				: v.MangekyouSharinganShisui ? x -> x.mangekyousharinganshisuisusanolearn : x -> 0;
		return (int) Math.min(4, learned.applyAsDouble(v));
	}

	private static void setStage(ServerPlayer player, int stage) {
		NarutoShippudenModVariables.ifPresent(player, v -> {
			v.mangekyousharingansusanostage = stage;
			v.syncPlayerVariables(player);
		});
	}

	/** Susanoo key held: one stage more (up to what the player has learned). */
	public static void growSusanoo(ServerPlayer player) {
		PlayerVariables v = NarutoShippudenModVariables.get(player);
		if (!v.MangekyouSharinganActivate) {
			player.sendOverlayMessage(Component.literal("Activate the Mangekyou Sharingan first"));
			return;
		}
		int max = maxStage(v), stage = (int) v.mangekyousharingansusanostage;
		if (max == 0) {
			player.sendOverlayMessage(Component.literal("Learn the Susanoo from your Mangekyou scroll"));
			return;
		}
		if (stage >= max)
			return;
		setStage(player, stage + 1);
		player.sendOverlayMessage(Component.literal("Susanoo: " + STAGES[stage + 1]));
		player.level().playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.BEACON_POWER_SELECT, SoundSource.PLAYERS, 1,
				0.5F + stage * 0.15F);
	}

	/** Susanoo key tapped while it is out. */
	public static void dismissSusanoo(ServerPlayer player) {
		if (NarutoShippudenModVariables.get(player).mangekyousharingansusanostage <= 0)
			return;
		setStage(player, 0);
		player.level().playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.BEACON_DEACTIVATE, SoundSource.PLAYERS, 1, 0.8F);
	}
}
