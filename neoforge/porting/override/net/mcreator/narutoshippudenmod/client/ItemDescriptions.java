package net.mcreator.narutoshippudenmod.client;

import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables;
import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables.PlayerVariables;
import net.mcreator.narutoshippudenmod.core.jutsu.Jutsus;
import net.mcreator.narutoshippudenmod.core.jutsu.Jutsus.Jutsu;
import net.mcreator.narutoshippudenmod.core.jutsu.Jutsus.Release;
import net.mcreator.narutoshippudenmod.core.jutsu.Jutsus.Technique;
import net.mcreator.narutoshippudenmod.core.jutsu.Jutsus.Track;

import net.minecraft.ChatFormatting;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;

/**
 * Every item description, written like vanilla ones: gray facts, blue effects, requirements that turn red while unmet. Technique
 * items and jutsu scrolls describe themselves from the jutsu table; everything else is listed here.
 */
@EventBusSubscriber(modid = "naruto_shippuden", value = Dist.CLIENT)
public final class ItemDescriptions {
	private static final Map<String, List<Function<PlayerVariables, Component>>> LINES = new HashMap<>();

	private ItemDescriptions() {
	}

	private static Function<PlayerVariables, Component> gray(String text) {
		Component line = Component.literal(text).withStyle(ChatFormatting.GRAY);
		return v -> line;
	}

	private static Function<PlayerVariables, Component> blue(String text) {
		Component line = Component.literal(text).withStyle(ChatFormatting.BLUE);
		return v -> line;
	}

	private static Function<PlayerVariables, Component> hint(String text) {
		Component line = Component.literal(text).withStyle(ChatFormatting.DARK_GRAY);
		return v -> line;
	}

	private static Function<PlayerVariables, Component> kenjutsu(int min) {
		return requires("Kenjutsu", v -> v.kenjutsu, min);
	}

	private static Function<PlayerVariables, Component> shurikenjutsu(int min) {
		return requires("Shurikenjutsu", v -> v.shurikenjutsu, min);
	}

	private static Function<PlayerVariables, Component> requires(String stat, ToDoubleFunction<PlayerVariables> value, double min) {
		return v -> requirement(stat, value.applyAsDouble(v), min);
	}

	private static Component requirement(String stat, double value, double min) {
		return Component.literal("Requires " + (int) min + " " + stat).withStyle(value >= min ? ChatFormatting.GRAY : ChatFormatting.RED);
	}

	@SafeVarargs
	private static void add(String items, Function<PlayerVariables, Component>... lines) {
		for (String item : items.split(" "))
			LINES.put(item, List.of(lines));
	}

	static {
		add("earth_dna fire_dna_release lightning_dna water_dna_release wind_dna", gray("70% implant chance"));
		add("boil_dna_release bone_dna_release dust_dna_release ice_dna_release magnet_dna_release smoke_dna_release steel_dna_release"
				+ " storm_dna_release swift_dna_release typhoon_dna_release wood_dna_release", gray("50% implant chance"));
		add("undefined_dna", gray("50% chance to identify"));
		add("bronze_ryo", gray("9 craft into 1 Silver Ryo"));
		add("silver_ryo", gray("Worth 9 Bronze Ryo"), gray("9 craft into 1 Gold Ryo"));
		add("gold_ryo", gray("Worth 9 Silver Ryo"));
		add("iron_defense", gray("Build an Iron Golem"));
		add("pillage_the_post", gray("Kill 5 Pillagers"));
		add("save_the_village", gray("Kill 10 Zombies"));
		add("clan_reset_stat", gray("Resets your clan"));
		add("chakra_nature_reset", gray("Resets your chakra natures"));

		add("shuriken", shurikenjutsu(5));
		add("kunai", shurikenjutsu(10));
		add("poison_kunai", shurikenjutsu(15));
		add("explosive_kunai fuma_shuriken", shurikenjutsu(20));
		add("toroi_unique_fuma_shuriken", shurikenjutsu(25));
		add("flying_thunder_god_kunai", blue("Teleport: 50 Chakra"), shurikenjutsu(25), requires("Ninjutsu", v -> v.ninjutsu, 10));

		add("tanto", kenjutsu(5));
		add("katana", kenjutsu(15));
		add("triple_blade_scythe", kenjutsu(30));
		add("shichiseiken", kenjutsu(35));
		add("white_light_chakra_sabre", blue("Chakra Flow: 20 Chakra/s"), kenjutsu(10));
		add("chakra_blade", blue("Flying Swallow: 20 Chakra/s"), kenjutsu(20));
		add("kusanagi_sasuke", blue("Lightning Chakra: 20 Chakra/s"), kenjutsu(25));
		add("gunbai gunbai_block", blue("Block: stops any attack"), blue("Wind Push: knocks enemies back"), kenjutsu(25),
				hint("Sneak and right-click to switch"));
		add("kabutowari", blue("Launches enemies into the air"), kenjutsu(45));
		add("kubikiribocho", blue("Repairs 15 durability per kill"), kenjutsu(45));
		add("samehada", blue("Chakra Steal: 5% of the target's chakra"), blue("Chakra Heal: 0.2% of the target's health"),
				gray("Uses 10 Chakra/s"), kenjutsu(45), hint("Sneak and right-click to switch"));
		add("hiramekarei hiramekarei_hammer_form hiramekarei_splitted", blue("Chakra Storing: 20 Chakra/s"),
				blue("Long-Sword Form: 20 stored Chakra/s"), blue("Twinsword Form: 20 stored Chakra/s"), blue("Hammer Form: 300 stored Chakra"),
				kenjutsu(45), hint("Sneak and right-click to switch"));
		add("kiba_sword", blue("Lightning Ball: 100 Chakra"), blue("Lightning: 150 Chakra"), blue("Lightning Wave: 200 Chakra"), kenjutsu(45),
				hint("Hold one in each hand"), hint("Sneak and right-click to switch"));
		add("nuibari", blue("Throw Needle"), blue("Pull Needle"), kenjutsu(45), hint("Sneak and right-click to switch"));
		add("shibuki", blue("Paper Bomb Trap: 350 Chakra"), blue("Explosion: 20 Chakra/s"), blue("Explosion Trail: 100 Chakra/s"), kenjutsu(45),
				hint("Sneak and right-click to switch"));
		add("otsutsuki_axe otsutsuki_bat otsutsuki_blade otsutsuki_chopping_sword otsutsuki_hammer otsutsuki_katana otsutsuki_spear otsutsuki_sword",
				gray("Right-click to transform"), hint("Sneak and right-click to pick a form"));
	}

	@SubscribeEvent
	public static void tooltip(ItemTooltipEvent event) {
		if (event.getEntity() == null)
			return;
		PlayerVariables variables = NarutoShippudenModVariables.get(event.getEntity());
		ItemStack stack = event.getItemStack();
		List<Component> lines = new ArrayList<>();
		Technique technique = Jutsus.technique(stack);
		Release release = Jutsus.release(stack);
		if (technique != null)
			technique(technique, stack, variables, lines);
		else if (release != null)
			release(release, variables, lines);
		else {
			List<Function<PlayerVariables, Component>> table = LINES.get(BuiltInRegistries.ITEM.getKey(stack.getItem()).getPath());
			if (table == null)
				return;
			for (Function<PlayerVariables, Component> line : table)
				lines.add(line.apply(variables));
		}
		// right under the name, above attributes and the advanced id, like vanilla item details
		event.getToolTip().addAll(Math.min(1, event.getToolTip().size()), lines);
	}

	private static void technique(Technique technique, ItemStack stack, PlayerVariables variables, List<Component> lines) {
		Jutsu jutsu = technique.selected(variables);
		String name = jutsu.name();
		// the custom jutsu items cast the jutsu made in the Jutsu Creation screen
		String custom = variables.jutsunamesave1.replace("\"", "").trim();
		if (name.equals("Custom Jutsu") && !custom.isEmpty())
			name = custom;
		if (!name.equals(stack.getHoverName().getString()))
			lines.add(Component.literal(name).withStyle(ChatFormatting.GRAY));
		if (!jutsu.isLearned(variables)) {
			lines.add(Component.literal("Not learned").withStyle(ChatFormatting.RED));
		} else {
			StringBuilder cost = new StringBuilder();
			if (jutsu.chakra() > 0)
				cost.append((int) jutsu.chakra()).append(" Chakra");
			int cooldown = jutsu.cooldown(variables);
			if (cooldown > 0)
				cost.append(cost.isEmpty() ? "" : ", ").append(JutsuClient.seconds(cooldown)).append(" cooldown");
			if (!cost.isEmpty())
				lines.add(Component.literal(cost.toString()).withStyle(ChatFormatting.BLUE));
			if (jutsu.statName() != null)
				lines.add(requirement(jutsu.statName(), jutsu.stat().applyAsDouble(variables), jutsu.statMin()));
		}
		if (technique.jutsu.size() > 1)
			lines.add(Component.literal("Hold ").append(JutsuClient.WHEEL.getTranslatedKeyMessage()).append(" to choose a jutsu")
					.withStyle(ChatFormatting.DARK_GRAY));
	}

	private static void release(Release release, PlayerVariables variables, List<Component> lines) {
		int owned = 0, total = 0;
		String next = null;
		int price = 0;
		for (Track track : release.tracks()) {
			int bought = Math.min(track.owned(variables), track.tiers().size());
			owned += bought;
			total += track.tiers().size();
			if (next == null && bought < track.tiers().size()) {
				next = track.name(bought);
				price = track.tiers().get(bought).cost();
			}
		}
		lines.add(Component.literal(owned + "/" + total + " learned").withStyle(ChatFormatting.GRAY));
		if (next != null)
			lines.add(Component.literal("Next: " + next + " (" + price + " JP)").withStyle(ChatFormatting.BLUE));
		lines.add(Component.literal("Right-click to open").withStyle(ChatFormatting.DARK_GRAY));
	}
}
