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
import net.neoforged.neoforge.event.server.ServerStartedEvent;
import net.neoforged.neoforge.event.entity.EntityTravelToDimensionEvent;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.event.level.BlockEvent;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.GlobalPos;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.storage.LevelData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.ChatFormatting;

import java.util.Collection;
import java.util.List;

/**
 * Chikyū, the story's world: the dimension is data (dimension/chikyu.json, biome chikyu_forest) on the
 * {@link ChikyuChunkGenerator}.
 * <ul>
 * <li>A player's first join puts them at the Leaf's Academy, and they respawn there (until they sleep in a bed).</li>
 * <li>The red torii outside the Leaf's great gate leads to a torii by the overworld's spawn, and that one back. The way
 * out gives a Leaf Return Scroll ({@link ChikyuContent}) for coming home from far away.</li>
 * <li>No other way in or out: nether portals do not light in Chikyū, and nothing travels from it to the Nether or the End.</li>
 * <li>Operators: {@code /naruto chikyu [players]} (to the Academy), {@code /naruto chikyu leave [players]} (to the overworld).</li>
 * </ul>
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
		overworldTorii = null;
	}

	// ---------------------------------------------------------------- the story's start
	private static final String STARTED = "naruto_shippuden:chikyu_started";

	@SubscribeEvent
	public static void onLogin(PlayerEvent.PlayerLoggedInEvent event) {
		if (!(event.getEntity() instanceof ServerPlayer player) || player.getPersistentData().getBooleanOr(STARTED, false))
			return;
		// the dev client's tests run in their own worlds and places; -PdevOnly=chikyu tests this start
		if (Boolean.getBoolean("naruto.devtest") && !System.getProperty("naruto.devtest.only", "").equals("chikyu"))
			return;
		player.getPersistentData().putBoolean(STARTED, true);
		travel(player);
		player.setRespawnPosition(new ServerPlayer.RespawnConfig(
				new LevelData.RespawnData(GlobalPos.of(CHIKYU, BlockPos.containing(LeafVillage.ARRIVAL)), 180f, 0f), true), false);
	}

	/** The player's own marks survive death. */
	@SubscribeEvent
	public static void onClone(PlayerEvent.Clone event) {
		for (String key : new String[]{STARTED})
			if (event.getOriginal().getPersistentData().contains(key))
				event.getEntity().getPersistentData().putBoolean(key, event.getOriginal().getPersistentData().getBooleanOr(key, false));
	}

	// ---------------------------------------------------------------- the toriis
	private static volatile BlockPos overworldTorii;

	/** The overworld's torii's middle, once this server has found or built it; null before. */
	public static BlockPos overworldToriiIfKnown() {
		return overworldTorii;
	}

	/** The overworld's torii, a few blocks north of the world spawn, standing on the ground; built if it is not there. */
	private static BlockPos overworldTorii(ServerLevel overworld) {
		BlockPos t = overworldTorii;
		if (t != null)
			return t;
		BlockPos spawn = overworld.getRespawnData().pos();
		int x = spawn.getX(), z = spawn.getZ() - 6;
		// already built: find its black foot under the west post
		for (int y = overworld.getMaxY(); y > overworld.getMinY(); y--)
			if (overworld.getBlockState(new BlockPos(x - 3, y, z)).is(Blocks.POLISHED_BLACKSTONE)
					&& overworld.getBlockState(new BlockPos(x - 3, y + 1, z)).is(Blocks.STRIPPED_MANGROVE_WOOD))
			{
				BlockPos base = new BlockPos(x, y, z);
				for (Object[] b : LeafVillage.torii())
					if (b[3] == ChikyuContent.TORII_PORTAL.defaultBlockState() && !overworld.getBlockState(base.offset((int) b[0], (int) b[1], (int) b[2])).is(ChikyuContent.TORII_PORTAL))
						overworld.setBlock(base.offset((int) b[0], (int) b[1], (int) b[2]), (BlockState) b[3], 3);
				return overworldTorii = base;
			}
		int y = Integer.MIN_VALUE;
		for (int dx = -3; dx <= 3; dx += 3)
			y = Math.max(y, overworld.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, x + dx, z));
		BlockPos base = new BlockPos(x, y, z);
		// the passage is clear, the posts stand on the ground
		for (int dx = -2; dx <= 2; dx++)
			for (int dy = 0; dy < 6; dy++)
				for (int dz = -3; dz <= 3; dz++)
					if (!overworld.getBlockState(base.offset(dx, dy, dz)).isAir())
						overworld.setBlock(base.offset(dx, dy, dz), Blocks.AIR.defaultBlockState(), 3);
		for (Object[] b : LeafVillage.torii())
			overworld.setBlock(base.offset((int) b[0], (int) b[1], (int) b[2]), (BlockState) b[3], 3);
		for (int dx = -3; dx <= 3; dx += 3)
			for (int dy = -1; dy > -12 && !overworld.getBlockState(base.offset(dx, dy, 0)).isSolid(); dy--)
				overworld.setBlock(base.offset(dx, dy, 0), Blocks.STRIPPED_MANGROVE_WOOD.defaultBlockState(), 3);
		return overworldTorii = base;
	}

	@SubscribeEvent
	public static void onServerStarted(ServerStartedEvent event) {
		overworldTorii(event.getServer().overworld());
	}

	/** Where a torii's light takes whatever steps into it: the Leaf's torii to the overworld's, and that one back. */
	public static TeleportTransition toriiDestination(ServerLevel level, Entity entity) {
		var after = TeleportTransition.PLAY_PORTAL_SOUND.then(TeleportTransition.PLACE_PORTAL_TICKET);
		if (level.dimension() == CHIKYU) {
			ServerLevel overworld = level.getServer().overworld();
			BlockPos t = overworldTorii(overworld);
			return new TeleportTransition(overworld, new Vec3(t.getX() + 0.5, t.getY(), t.getZ() + 3.5), Vec3.ZERO, 0f, entity.getXRot(),
					after.then(Chikyu::giveReturnScroll));
		}
		ServerLevel chikyu = level.getServer().getLevel(CHIKYU);
		if (chikyu == null)
			return null;
		return new TeleportTransition(chikyu, LeafVillage.TORII_ARRIVAL, Vec3.ZERO, 180f, entity.getXRot(), after);
	}

	/** The way home from wherever they wander in the overworld. */
	private static void giveReturnScroll(Entity entity) {
		if (entity instanceof ServerPlayer player && !player.getInventory().contains(new ItemStack(ChikyuContent.RETURN_SCROLL))) {
			player.getInventory().placeItemBackInInventory(new ItemStack(ChikyuContent.RETURN_SCROLL), net.minecraft.util.Prediction.SERVER_ONLY);
			player.sendSystemMessage(Component.translatable("item.naruto_shippuden.leaf_return_scroll.given").withStyle(ChatFormatting.GREEN));
		}
	}

	/** Back to the Leaf, between its gate and its torii, facing the gate. */
	public static void backToTheLeaf(ServerPlayer player) {
		ServerLevel chikyu = player.level().getServer().getLevel(CHIKYU);
		if (chikyu == null)
			return;
		player.teleport(new TeleportTransition(chikyu, LeafVillage.TORII_ARRIVAL, Vec3.ZERO, 180f, 0f, TeleportTransition.PLAY_PORTAL_SOUND));
	}

	// ---------------------------------------------------------------- no shortcuts
	@SubscribeEvent
	public static void onPortalSpawn(BlockEvent.PortalSpawnEvent event) {
		if (event.getLevel() instanceof Level level && level.dimension() == CHIKYU)
			event.setCanceled(true);
	}

	@SubscribeEvent
	public static void onTravel(EntityTravelToDimensionEvent event) {
		if (event.getEntity().level().dimension() == CHIKYU && (event.getDimension() == Level.NETHER || event.getDimension() == Level.END))
			event.setCanceled(true);
	}
}
