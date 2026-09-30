package net.mcreator.narutoshippudenmod.core;

import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables;
import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables.PlayerVariables;

import net.minecraft.core.Holder;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

/**
 * What the body stats do to the player, applied as attribute modifiers (the old procedures set attributes with /attribute
 * commands whose attribute names no longer exist, so Medicine and Speed did nothing):
 * <ul>
 * <li>Medicine (up to 300): +6 max health per 10 points (up to +180, 200 in all: a maxed Ninjutsu S-rank jutsu does about 60), and
 * faster natural healing.</li>
 * <li>Speed (up to 10): +3.5% walking speed a point (up to +35%).</li>
 * <li>Taijutsu (up to 120): harder bare-handed blows, +1 damage per 15 points (up to +8).</li>
 * </ul>
 * Ninjutsu and Kenjutsu make jutsu and weapon arts stronger (see Techniques and Weapons); the other stats unlock techniques.
 */
@EventBusSubscriber(modid = "naruto_shippuden")
public final class Stats {
	private static final Identifier MEDICINE = Identifier.fromNamespaceAndPath("naruto_shippuden", "stat_medicine");
	private static final Identifier SPEED = Identifier.fromNamespaceAndPath("naruto_shippuden", "stat_speed");
	private static final Identifier TAIJUTSU = Identifier.fromNamespaceAndPath("naruto_shippuden", "stat_taijutsu");

	private Stats() {
	}

	public static double health(PlayerVariables v) {
		return Math.floor(Math.max(0, Math.min(300, v.medicine)) / 10) * 6;
	}

	public static double speed(PlayerVariables v) {
		return Math.max(0, Math.min(10, v.speed)) * 0.035;
	}

	public static double fists(PlayerVariables v) {
		return Math.floor(Math.max(0, Math.min(120, v.taijutsu)) / 15);
	}

	// ------------------------------------------------------------------ upgrading with SP (the Stats page of the info card)
	/** A stat that SP can raise: its cap (0 = none) and what each point also adds (Ninjutsu: max chakra). */
	public record Stat(String name, java.util.function.ToDoubleFunction<PlayerVariables> get, java.util.function.ObjDoubleConsumer<PlayerVariables> set, int cap,
			java.util.function.ObjDoubleConsumer<PlayerVariables> perPoint) {
	}

	public static final java.util.Map<String, Stat> STATS = new java.util.LinkedHashMap<>();

	private static void stat(String name, java.util.function.ToDoubleFunction<PlayerVariables> get, java.util.function.ObjDoubleConsumer<PlayerVariables> set,
			int cap) {
		stat(name, get, set, cap, (v, n) -> {
		});
	}

	private static void stat(String name, java.util.function.ToDoubleFunction<PlayerVariables> get, java.util.function.ObjDoubleConsumer<PlayerVariables> set,
			int cap, java.util.function.ObjDoubleConsumer<PlayerVariables> perPoint) {
		STATS.put(name, new Stat(name, get, set, cap, perPoint));
	}

	static {
		stat("Ninjutsu", v -> v.ninjutsu, (v, n) -> v.ninjutsu = n, 0, (v, n) -> v.ChakraMax += 10 * n);
		stat("Taijutsu", v -> v.taijutsu, (v, n) -> v.taijutsu = n, 120);
		stat("Kenjutsu", v -> v.kenjutsu, (v, n) -> v.kenjutsu = n, 100);
		stat("Shurikenjutsu", v -> v.shurikenjutsu, (v, n) -> v.shurikenjutsu = n, 40);
		stat("Summoning", v -> v.summoning, (v, n) -> v.summoning = n, 60);
		stat("Kinjutsu", v -> v.kinjutsu, (v, n) -> v.kinjutsu = n, 100);
		stat("Senjutsu", v -> v.senjutsu, (v, n) -> v.senjutsu = n, 0, (v, n) -> v.SenjutsuChakraMax += 15 * n);
		stat("Medicine", v -> v.medicine, (v, n) -> v.medicine = n, 300);
		stat("Speed", v -> v.speed, (v, n) -> v.speed = n, 10);
		stat("Genjutsu", v -> v.genjutsu, (v, n) -> v.genjutsu = n, 70);
		stat("IQ", v -> v.IQ, (v, n) -> v.IQ = n, 220);
	}

	/**
	 * Spends up to the SP-per-click amount on a stat, never past its cap: 292 Medicine with 10 per click goes to 300 and keeps the
	 * other 2 SP. A maxed stat takes nothing.
	 */
	public static void upgrade(ServerPlayer player, String name) {
		Stat stat = STATS.get(name);
		if (stat == null)
			return;
		PlayerVariables v = NarutoShippudenModVariables.get(player);
		double value = stat.get().applyAsDouble(v);
		double room = stat.cap() > 0 ? stat.cap() - value : Double.MAX_VALUE;
		int amount = (int) Math.min(Math.min(Math.max(1, v.spusecount), Math.floor(v.sp)), room);
		if (room <= 0) {
			player.sendOverlayMessage(net.minecraft.network.chat.Component.literal(name + " is maxed"));
			return;
		}
		if (amount <= 0) {
			player.sendOverlayMessage(net.minecraft.network.chat.Component.literal("Not enough SP"));
			return;
		}
		NarutoShippudenModVariables.ifPresent(player, vars -> {
			vars.sp -= amount;
			stat.set().accept(vars, value + amount);
			stat.perPoint().accept(vars, amount);
			vars.syncPlayerVariables(player);
		});
		player.sendOverlayMessage(net.minecraft.network.chat.Component.literal("+" + amount + " " + name
				+ (stat.cap() > 0 && value + amount >= stat.cap() ? " (maxed)" : "")));
	}

	@SubscribeEvent
	public static void tick(PlayerTickEvent.Post event) {
		if (!(event.getEntity() instanceof ServerPlayer player) || player.tickCount % 10 != 0)
			return;
		PlayerVariables v = NarutoShippudenModVariables.get(player);
		// the old commands may have left a changed base behind on old saves
		base(player, Attributes.MAX_HEALTH, 20);
		base(player, Attributes.MOVEMENT_SPEED, 0.1);
		set(player, Attributes.MAX_HEALTH, MEDICINE, health(v), AttributeModifier.Operation.ADD_VALUE);
		set(player, Attributes.MOVEMENT_SPEED, SPEED, speed(v), AttributeModifier.Operation.ADD_MULTIPLIED_BASE);
		set(player, Attributes.ATTACK_DAMAGE, TAIJUTSU, player.getMainHandItem().isEmpty() ? fists(v) : 0, AttributeModifier.Operation.ADD_VALUE);
		if (player.getHealth() > player.getMaxHealth())
			player.setHealth(player.getMaxHealth());
		// a medic's body mends itself: up to 3 health every 5 seconds at 300 Medicine
		if (player.tickCount % 100 == 0 && v.medicine >= 20 && player.getHealth() < player.getMaxHealth() && player.getFoodData().getFoodLevel() > 6)
			player.heal((float) (Math.min(300, v.medicine) / 100));
	}

	private static void base(ServerPlayer player, Holder<Attribute> attribute, double value) {
		AttributeInstance instance = player.getAttribute(attribute);
		if (instance != null && instance.getBaseValue() != value)
			instance.setBaseValue(value);
	}

	private static void set(ServerPlayer player, Holder<Attribute> attribute, Identifier id, double amount, AttributeModifier.Operation operation) {
		AttributeInstance instance = player.getAttribute(attribute);
		if (instance == null)
			return;
		AttributeModifier current = instance.getModifier(id);
		if (current != null && current.amount() == amount)
			return;
		// permanent (saved), so a bigger health bar isn't cut back to 20 while the player loads
		instance.removeModifier(id);
		if (amount != 0)
			instance.addPermanentModifier(new AttributeModifier(id, amount, operation));
	}
}
