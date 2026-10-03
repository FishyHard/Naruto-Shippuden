package net.mcreator.narutoshippudenmod.command;

import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables;
import net.mcreator.narutoshippudenmod.core.NarutoActions;
import net.mcreator.narutoshippudenmod.procedures.MissionAndCommandProcedures;

import com.mojang.brigadier.arguments.DoubleArgumentType;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.exceptions.DynamicCommandExceptionType;

import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.commands.SharedSuggestionProvider;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.RegisterCommandsEvent;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

/**
 * {@code /naruto}: one command for the mod.
 * <pre>
 * /naruto cheat | info | patreon                         open the cheat menu, the info card, the Patreon kit
 * /naruto get &lt;value&gt; [player]                            show a value (level, jp, sp, ninjutsu, ...)
 * /naruto set &lt;value&gt; &lt;amount&gt; [players]                  set it
 * /naruto add &lt;value&gt; &lt;amount&gt; [players]                  add to it (negative takes away)
 * /naruto dojutsu give &lt;dojutsu&gt; [players]               give at once
 * /naruto dojutsu awaken &lt;dojutsu&gt; [seconds] [players]   awaken (message and effects) after a delay
 * /naruto kekkeigenkai &lt;kekkei genkai&gt; [players]
 * /naruto rank &lt;rank&gt; [players]
 * /naruto reset &lt;stats|info|level|dojutsu&gt; [players]
 * </pre>
 * Everything but cheat, info and patreon needs operator rights. /naruto cheat replaces /narutoshippudencheat.
 */
@EventBusSubscriber(modid = "naruto_shippuden")
public final class NarutoCommand {
	private static final DynamicCommandExceptionType UNKNOWN = new DynamicCommandExceptionType(name -> Component.literal("Unknown: " + name));

	private NarutoCommand() {
	}

	@SubscribeEvent
	public static void register(RegisterCommandsEvent event) {
		LiteralArgumentBuilder<CommandSourceStack> root = Commands.literal("naruto");
		root.then(Commands.literal("cheat").executes(c -> page(c, "cheat")));
		root.then(Commands.literal("info").executes(c -> page(c, "info")));

		root.then(Commands.literal("get").requires(Commands.hasPermission(Commands.LEVEL_GAMEMASTERS))
				.then(Commands.argument("value", StringArgumentType.word()).suggests((c, b) -> SharedSuggestionProvider.suggest(NarutoActions.VALUES.keySet(), b))
						.executes(c -> get(c, c.getSource().getPlayerOrException()))
						.then(Commands.argument("player", EntityArgument.player()).executes(c -> get(c, EntityArgument.getPlayer(c, "player"))))));
		for (String mode : List.of("set", "add"))
			root.then(Commands.literal(mode).requires(Commands.hasPermission(Commands.LEVEL_GAMEMASTERS))
					.then(Commands.argument("value", StringArgumentType.word()).suggests((c, b) -> SharedSuggestionProvider.suggest(NarutoActions.VALUES.keySet(), b))
							.then(Commands.argument("amount", DoubleArgumentType.doubleArg()).executes(c -> set(c, self(c), mode.equals("add")))
									.then(Commands.argument("players", EntityArgument.players())
											.executes(c -> set(c, EntityArgument.getPlayers(c, "players"), mode.equals("add")))))));

		root.then(Commands.literal("dojutsu").requires(Commands.hasPermission(Commands.LEVEL_GAMEMASTERS))
				.then(Commands.literal("give").then(dojutsuArgument().executes(c -> dojutsu(c, self(c), -1))
						.then(Commands.argument("players", EntityArgument.players()).executes(c -> dojutsu(c, EntityArgument.getPlayers(c, "players"), -1)))))
				.then(Commands.literal("awaken").then(dojutsuArgument().executes(c -> dojutsu(c, self(c), 0))
						.then(Commands.argument("seconds", IntegerArgumentType.integer(0, 3600)).executes(c -> dojutsu(c, self(c), IntegerArgumentType.getInteger(c, "seconds")))
								.then(Commands.argument("players", EntityArgument.players())
										.executes(c -> dojutsu(c, EntityArgument.getPlayers(c, "players"), IntegerArgumentType.getInteger(c, "seconds"))))))));

		root.then(entries("kekkeigenkai", "kekkei_genkai", NarutoActions.KEKKEI_GENKAI, "Gave "));
		root.then(entries("rank", "rank", NarutoActions.RANKS, "Rank set to "));
		root.then(entries("reset", "reset", NarutoActions.RESETS, "Reset "));
		event.getDispatcher().register(root);
	}

	private static com.mojang.brigadier.builder.RequiredArgumentBuilder<CommandSourceStack, String> dojutsuArgument() {
		return Commands.argument("dojutsu", StringArgumentType.word()).suggests((c, b) -> SharedSuggestionProvider.suggest(NarutoActions.DOJUTSU.keySet(), b));
	}

	private static LiteralArgumentBuilder<CommandSourceStack> entries(String literal, String argument, Map<String, NarutoActions.Entry> entries, String verb) {
		return Commands.literal(literal).requires(Commands.hasPermission(Commands.LEVEL_GAMEMASTERS))
				.then(Commands.argument(argument, StringArgumentType.word()).suggests((c, b) -> SharedSuggestionProvider.suggest(entries.keySet(), b))
						.executes(c -> entry(c, self(c), entries.get(StringArgumentType.getString(c, argument)), StringArgumentType.getString(c, argument), verb))
						.then(Commands.argument("players", EntityArgument.players()).executes(c -> entry(c, EntityArgument.getPlayers(c, "players"),
								entries.get(StringArgumentType.getString(c, argument)), StringArgumentType.getString(c, argument), verb))));
	}

	private static Collection<ServerPlayer> self(CommandContext<CommandSourceStack> c) throws CommandSyntaxException {
		return List.of(c.getSource().getPlayerOrException());
	}

	private static int page(CommandContext<CommandSourceStack> c, String page) throws CommandSyntaxException {
		NarutoActions.run(c.getSource().getPlayerOrException(), NarutoActions.PAGES.get(page).run());
		return 1;
	}

	private static NarutoActions.Value value(CommandContext<CommandSourceStack> c) throws CommandSyntaxException {
		String name = StringArgumentType.getString(c, "value");
		NarutoActions.Value value = NarutoActions.VALUES.get(name);
		if (value == null)
			throw UNKNOWN.create(name);
		return value;
	}

	private static int get(CommandContext<CommandSourceStack> c, ServerPlayer player) throws CommandSyntaxException {
		NarutoActions.Value value = value(c);
		double amount = value.get().applyAsDouble(NarutoShippudenModVariables.get(player));
		c.getSource().sendSuccess(() -> Component.literal(player.getName().getString() + ": " + value.name() + " = " + format(amount)), false);
		return (int) amount;
	}

	private static int set(CommandContext<CommandSourceStack> c, Collection<ServerPlayer> players, boolean add) throws CommandSyntaxException {
		NarutoActions.Value value = value(c);
		double amount = DoubleArgumentType.getDouble(c, "amount");
		for (ServerPlayer player : players)
			NarutoActions.setValue(player, value, add ? value.get().applyAsDouble(NarutoShippudenModVariables.get(player)) + amount : amount);
		c.getSource().sendSuccess(() -> Component.literal((add ? "Added " + format(amount) + " to " : "Set ") + value.name()
				+ (add ? "" : " to " + format(amount)) + " for " + players.size() + " player(s)"), true);
		return players.size();
	}

	private static int dojutsu(CommandContext<CommandSourceStack> c, Collection<ServerPlayer> players, int seconds) throws CommandSyntaxException {
		String name = StringArgumentType.getString(c, "dojutsu");
		NarutoActions.Dojutsu dojutsu = NarutoActions.DOJUTSU.get(name);
		if (dojutsu == null)
			throw UNKNOWN.create(name);
		int done = 0;
		for (ServerPlayer player : players)
			if (NarutoActions.dojutsu(player, dojutsu, seconds))
				done++;
		int count = done;
		c.getSource().sendSuccess(() -> Component.literal((seconds < 0 ? "Gave " : "Awakening ") + dojutsu.name() + (seconds > 0 ? " in " + seconds + "s" : "")
				+ " for " + count + " player(s)"), true);
		return done;
	}

	private static int entry(CommandContext<CommandSourceStack> c, Collection<ServerPlayer> players, NarutoActions.Entry entry, String name, String verb)
			throws CommandSyntaxException {
		if (entry == null)
			throw UNKNOWN.create(name);
		Consumer<java.util.Map<String, Object>> run = entry.run();
		for (ServerPlayer player : players)
			NarutoActions.run(player, run);
		c.getSource().sendSuccess(() -> Component.literal(verb + entry.name() + " for " + players.size() + " player(s)"), true);
		return players.size();
	}

	private static String format(double amount) {
		return amount == Math.floor(amount) ? String.valueOf((long) amount) : String.valueOf(amount);
	}
}
