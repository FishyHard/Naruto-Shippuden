package net.mcreator.narutoshippudenmod.world.chikyu;

import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.portal.TeleportTransition;
import net.minecraft.world.phys.Vec3;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.RegisterCommandsEvent;
import net.neoforged.neoforge.event.server.ServerStoppedEvent;

import java.util.Collection;
import java.util.List;

/**
 * Chikyū, the story's world: the dimension is data (dimension/chikyu.json, biome chikyu_forest) on the
 * {@link ChikyuChunkGenerator}. Until the story's start takes players there, operators travel with
 * {@code /naruto chikyu [players]} (to the Leaf's Academy) and {@code /naruto chikyu leave [players]} (back to the overworld).
 */
@EventBusSubscriber(modid = "naruto_shippuden")
public final class Chikyu {
	public static final ResourceKey<Level> CHIKYU = ResourceKey.create(Registries.DIMENSION, Identifier.fromNamespaceAndPath("naruto_shippuden", "chikyu"));

	private Chikyu() {
	}

	/** Sends the player to the Leaf, on the street before the Academy. */
	public static void travel(ServerPlayer player) {
		ServerLevel level = player.level().getServer().getLevel(CHIKYU);
		if (level == null)
			return;
		player.teleport(new TeleportTransition(level, LeafVillage.ARRIVAL, Vec3.ZERO, 180f, 0f, TeleportTransition.DO_NOTHING));
	}

	@SubscribeEvent
	public static void registerCommands(RegisterCommandsEvent event) {
		event.getDispatcher().register(Commands.literal("naruto").then(Commands.literal("chikyu").requires(Commands.hasPermission(Commands.LEVEL_GAMEMASTERS))
				.executes(c -> go(c.getSource(), List.of(c.getSource().getPlayerOrException()), false))
				.then(Commands.argument("players", EntityArgument.players()).executes(c -> go(c.getSource(), EntityArgument.getPlayers(c, "players"), false)))
				.then(Commands.literal("leave").executes(c -> go(c.getSource(), List.of(c.getSource().getPlayerOrException()), true))
						.then(Commands.argument("players", EntityArgument.players()).executes(c -> go(c.getSource(), EntityArgument.getPlayers(c, "players"), true))))));
	}

	private static int go(CommandSourceStack source, Collection<ServerPlayer> players, boolean leave) {
		for (ServerPlayer player : players) {
			if (leave)
				player.teleport(TeleportTransition.createDefault(player, TeleportTransition.DO_NOTHING));
			else
				travel(player);
		}
		source.sendSuccess(() -> Component.literal((leave ? "Sent %d player(s) back to the overworld" : "Sent %d player(s) to the Hidden Leaf").formatted(players.size())), true);
		return players.size();
	}

	@SubscribeEvent
	public static void onServerStopped(ServerStoppedEvent event) {
		LeafVillage.forget();
	}
}
