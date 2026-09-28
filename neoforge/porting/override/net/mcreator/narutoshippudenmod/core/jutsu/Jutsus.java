package net.mcreator.narutoshippudenmod.core.jutsu;

import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables;
import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables.PlayerVariables;

import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.UseCooldown;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.ObjDoubleConsumer;
import java.util.function.ToDoubleFunction;

import org.jspecify.annotations.Nullable;

/**
 * The jutsu system: which jutsu each technique item has, how releases are learned, and the rules for casting.
 * <ul>
 * <li>Selecting: the jutsu wheel (client) sends the choice, stored in the item's old technique variable.</li>
 * <li>Casting: right-clicking a technique item checks unlock, stat, chakra and that jutsu's cooldown here, then runs
 * the jutsu's original procedure for its effect. The cooldown only starts when the cast goes through, and each jutsu
 * has its own (its cooldown group is put on the item, so the vanilla cooldown overlay shows the selected one).</li>
 * <li>Learning: right-clicking a release opens the jutsu scroll (client); Learn buys the next tier with the original
 * procedure.</li>
 * </ul>
 * The numbers are in {@link JutsuTable}.
 */
@EventBusSubscriber(modid = "naruto_shippuden")
public final class Jutsus {
	public static final String[] RANKS = {"Academy Student", "Genin", "Chunin", "Jonin", "Kage"};
	public static final Map<Identifier, Technique> TECHNIQUES = new LinkedHashMap<>();
	public static final Map<Identifier, Release> RELEASES = new LinkedHashMap<>();

	private Jutsus() {
	}

	// ------------------------------------------------------------------ model
	public static final class Technique {
		public final Identifier item;
		final ToDoubleFunction<PlayerVariables> selected;
		final ObjDoubleConsumer<PlayerVariables> select;
		final Consumer<Map<String, Object>> cast;
		public final List<Jutsu> jutsu = new ArrayList<>();

		Technique(Identifier item, ToDoubleFunction<PlayerVariables> selected, ObjDoubleConsumer<PlayerVariables> select, Consumer<Map<String, Object>> cast) {
			this.item = item;
			this.selected = selected;
			this.select = select;
			this.cast = cast;
		}

		public Jutsu selected(PlayerVariables variables) {
			int index = (int) selected.applyAsDouble(variables);
			return jutsu.get(index >= 0 && index < jutsu.size() ? index : 0);
		}
	}

	public record Jutsu(Technique technique, int index, String name, ToDoubleFunction<PlayerVariables> learned, double tier, @Nullable String statName,
			ToDoubleFunction<PlayerVariables> stat, double statMin, double chakra, int[] cooldowns) {
		public Identifier cooldownGroup() {
			return technique.item.withSuffix("/" + index);
		}

		public boolean isLearned(PlayerVariables variables) {
			return learned.applyAsDouble(variables) >= tier;
		}

		public boolean meetsStat(PlayerVariables variables) {
			return statName == null || stat.applyAsDouble(variables) >= statMin;
		}

		/** Cooldown in ticks for the player's rank. */
		public int cooldown(PlayerVariables variables) {
			for (int i = 0; i < RANKS.length; i++)
				if (RANKS[i].equals(variables.rank))
					return cooldowns[i];
			return cooldowns[0];
		}
	}

	/** A learnable tier of a release: JP price, the learn value it sets (0 = none) and the item it gives, if any. */
	public record Tier(int cost, double learn, @Nullable Identifier gives) {
	}

	public record Release(Identifier item, ToDoubleFunction<PlayerVariables> bought, Consumer<Map<String, Object>> buy, @Nullable Technique technique,
			@Nullable ToDoubleFunction<PlayerVariables> learnVariable, List<Tier> tiers) {
		/** How many tiers the player has bought. */
		public int owned(PlayerVariables variables) {
			return (int) bought.applyAsDouble(variables);
		}

		/** The jutsu a tier unlocks (by its learn value), empty for tiers that only give an item. */
		public List<Jutsu> unlocks(Tier tier) {
			List<Jutsu> list = new ArrayList<>();
			if (technique != null && tier.learn() > 0)
				for (Jutsu jutsu : technique.jutsu)
					if (jutsu.tier() == tier.learn())
						list.add(jutsu);
			return list;
		}
	}

	// ------------------------------------------------------------------ table builders (used by JutsuTable)
	record JutsuSpec(String name, ToDoubleFunction<PlayerVariables> learned, double tier, @Nullable String statName, ToDoubleFunction<PlayerVariables> stat,
			double statMin, double chakra, int[] cooldowns) {
	}

	static JutsuSpec jutsu(String name, ToDoubleFunction<PlayerVariables> learned, double tier, @Nullable String statName,
			ToDoubleFunction<PlayerVariables> stat, double statMin, double chakra, int... cooldowns) {
		return new JutsuSpec(name, learned, tier, statName, stat, statMin, chakra, cooldowns);
	}

	static void technique(String item, ToDoubleFunction<PlayerVariables> selected, ObjDoubleConsumer<PlayerVariables> select,
			Consumer<Map<String, Object>> cast, JutsuSpec... specs) {
		Technique technique = new Technique(id(item), selected, select, cast);
		for (JutsuSpec s : specs)
			technique.jutsu.add(new Jutsu(technique, technique.jutsu.size(), s.name(), s.learned(), s.tier(), s.statName(), s.stat(), s.statMin(), s.chakra(),
					s.cooldowns()));
		TECHNIQUES.put(technique.item, technique);
	}

	static Tier tier(int cost, double learn, @Nullable String gives) {
		return new Tier(cost, learn, gives == null ? null : id(gives));
	}

	static void release(String item, ToDoubleFunction<PlayerVariables> bought, Consumer<Map<String, Object>> buy, @Nullable String technique,
			@Nullable ToDoubleFunction<PlayerVariables> learnVariable, Tier... tiers) {
		RELEASES.put(id(item), new Release(id(item), bought, buy, technique == null ? null : TECHNIQUES.get(id(technique)), learnVariable, List.of(tiers)));
	}

	private static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath("naruto_shippuden", path);
	}

	static {
		JutsuTable.register();
	}

	public static @Nullable Technique technique(ItemStack stack) {
		return stack.isEmpty() ? null : TECHNIQUES.get(BuiltInRegistries.ITEM.getKey(stack.getItem()));
	}

	public static @Nullable Release release(ItemStack stack) {
		return stack.isEmpty() ? null : RELEASES.get(BuiltInRegistries.ITEM.getKey(stack.getItem()));
	}

	// ------------------------------------------------------------------ server actions
	private static Map<String, Object> dependencies(ServerPlayer player, ItemStack stack) {
		Map<String, Object> dependencies = new HashMap<>();
		dependencies.put("entity", player);
		dependencies.put("world", player.level());
		dependencies.put("x", player.getX());
		dependencies.put("y", player.getY());
		dependencies.put("z", player.getZ());
		dependencies.put("itemstack", stack);
		return dependencies;
	}

	private static void tell(Player player, String message) {
		player.sendOverlayMessage(Component.literal(message));
	}

	/** Gives the stack the selected jutsu's cooldown group, so the vanilla overlay shows that jutsu's cooldown. */
	static void showCooldownOf(ItemStack stack, Jutsu jutsu) {
		UseCooldown current = stack.get(DataComponents.USE_COOLDOWN);
		if (current == null || !current.cooldownGroup().equals(Optional.of(jutsu.cooldownGroup())))
			stack.set(DataComponents.USE_COOLDOWN, new UseCooldown(0.0F, Optional.of(jutsu.cooldownGroup())));
	}

	public static void cast(ServerPlayer player, InteractionHand hand) {
		ItemStack stack = player.getItemInHand(hand);
		Technique technique = technique(stack);
		if (technique == null)
			return;
		PlayerVariables variables = NarutoShippudenModVariables.get(player);
		Jutsu jutsu = technique.selected(variables);
		showCooldownOf(stack, jutsu);
		if (!jutsu.isLearned(variables)) {
			tell(player, "You haven't learned " + jutsu.name() + " yet");
			return;
		}
		if (!jutsu.meetsStat(variables)) {
			tell(player, jutsu.name() + " needs " + (int) jutsu.statMin() + " " + jutsu.statName());
			return;
		}
		if (variables.ChakraAmount < jutsu.chakra()) {
			tell(player, "Not enough chakra (" + (int) jutsu.chakra() + " needed)");
			return;
		}
		if (player.getCooldowns().isOnCooldown(stack))
			return;
		// the procedures pick the jutsu from the technique variable and cycle it instead while sneaking
		boolean sneaking = player.isShiftKeyDown();
		if (sneaking)
			player.setShiftKeyDown(false);
		try {
			technique.cast.accept(dependencies(player, stack));
		} finally {
			if (sneaking)
				player.setShiftKeyDown(true);
		}
		// they also put one shared cooldown on the item: replace it with this jutsu's own
		player.getCooldowns().removeCooldown(technique.item);
		int cooldown = jutsu.cooldown(variables);
		if (cooldown > 0)
			player.getCooldowns().addCooldown(jutsu.cooldownGroup(), cooldown);
	}

	public static void select(ServerPlayer player, Identifier item, int index) {
		Technique technique = TECHNIQUES.get(item);
		if (technique == null || index < 0 || index >= technique.jutsu.size())
			return;
		Jutsu jutsu = technique.jutsu.get(index);
		NarutoShippudenModVariables.ifPresent(player, variables -> {
			technique.select.accept(variables, index);
			variables.syncPlayerVariables(player);
		});
		for (InteractionHand hand : InteractionHand.values())
			if (technique(player.getItemInHand(hand)) == technique)
				showCooldownOf(player.getItemInHand(hand), jutsu);
		tell(player, "Selected: " + jutsu.name());
	}

	public static void learn(ServerPlayer player, Identifier item) {
		Release release = RELEASES.get(item);
		if (release == null)
			return;
		PlayerVariables variables = NarutoShippudenModVariables.get(player);
		int next = release.owned(variables);
		if (next >= release.tiers().size())
			return;
		if (variables.jp < release.tiers().get(next).cost()) {
			tell(player, "Not enough JP");
			return;
		}
		release.buy().accept(dependencies(player, player.getMainHandItem()));
	}

	// ------------------------------------------------------------------ right-clicks
	/** Technique items cast through {@link #cast}; releases open the jutsu scroll (client) instead of buying blindly. */
	@SubscribeEvent
	public static void onRightClickItem(PlayerInteractEvent.RightClickItem event) {
		ItemStack stack = event.getItemStack();
		boolean technique = technique(stack) != null;
		if (!technique && release(stack) == null)
			return;
		event.setCanceled(true);
		event.setCancellationResult(InteractionResult.SUCCESS);
		if (technique && event.getEntity() instanceof ServerPlayer player)
			cast(player, event.getHand());
	}
}
