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
 * <li>Medicine (up to 300): +2 max health per 15 points (up to +40, three rows of hearts), and faster natural healing.</li>
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
		return Math.floor(Math.max(0, Math.min(300, v.medicine)) / 15) * 2;
	}

	public static double speed(PlayerVariables v) {
		return Math.max(0, Math.min(10, v.speed)) * 0.035;
	}

	public static double fists(PlayerVariables v) {
		return Math.floor(Math.max(0, Math.min(120, v.taijutsu)) / 15);
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
		// a medic's body mends itself: up to 1.5 health every 5 seconds at 300 Medicine
		if (player.tickCount % 100 == 0 && v.medicine >= 20 && player.getHealth() < player.getMaxHealth() && player.getFoodData().getFoodLevel() > 6)
			player.heal((float) (Math.min(300, v.medicine) / 200));
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
