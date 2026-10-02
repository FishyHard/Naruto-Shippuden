package net.mcreator.narutoshippudenmod.world.chikyu;

import net.mcreator.narutoshippudenmod.core.NarutoConfig;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.permissions.Permissions;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BoneMealItem;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.FireChargeItem;
import net.minecraft.world.item.FlintAndSteelItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.BaseFireBlock;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.minecraft.util.TriState;
import net.neoforged.neoforge.event.entity.EntityMobGriefingEvent;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.neoforge.event.level.BlockEvent;
import net.neoforged.neoforge.event.level.ExplosionEvent;
import net.neoforged.neoforge.event.level.block.BreakBlockEvent;
import net.neoforged.neoforge.event.tick.LevelTickEvent;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * The hidden villages are not for building in (config chikyu.protect_villages): inside the Leaf's wall (and its gate)
 * and at both toriis nobody breaks or places blocks, empties or fills buckets, lights fires, strips or tills; explosions
 * leave the blocks standing, fire goes out as soon as it catches, and mobs cannot grief. Small plants (flowers, grass, ferns,
 * mushrooms) can be picked, and grow back a couple of minutes later. Doors, buttons, seats and the
 * like still work. Operators in creative mode can still build, to mend things on a server.
 */
@EventBusSubscriber(modid = "naruto_shippuden")
public final class VillageProtection {
	private record Fire(net.minecraft.resources.ResourceKey<Level> level, BlockPos pos) {
	}

	private static final Queue<Fire> FIRES = new ConcurrentLinkedQueue<>();

	/** A plant picked in the village, and the game time it grows back at. */
	private record Regrow(net.minecraft.resources.ResourceKey<Level> level, BlockPos pos, net.minecraft.world.level.block.state.BlockState state, long at) {
	}

	private static final Queue<Regrow> REGROW = new ConcurrentLinkedQueue<>();
	private static final int REGROW_TICKS = 20 * 120;

	/** The village's small plants: anyone may pick them (a quest may want flowers); they grow back. */
	private static boolean pickable(net.minecraft.world.level.block.state.BlockState state) {
		return state.is(net.minecraft.tags.BlockTags.SMALL_FLOWERS) || state.is(Blocks.SHORT_GRASS) || state.is(Blocks.FERN)
				|| state.is(Blocks.RED_MUSHROOM) || state.is(Blocks.BROWN_MUSHROOM);
	}

	private VillageProtection() {
	}

	/** True when (pos) in this level is protected village ground. */
	public static boolean isProtected(LevelAccessor accessor, BlockPos pos) {
		if (!(accessor instanceof Level level) || !NarutoConfig.PROTECT_VILLAGES.get())
			return false;
		int x = pos.getX(), z = pos.getZ();
		if (level.dimension() == Chikyu.CHIKYU) {
			if ((long) x * x + (long) z * z <= 190L * 190L)
				return true;                                // inside the round wall, the wall itself, the mountains' face
			if (x >= -33 && x <= 33 && z >= 168 && z <= 200)
				return true;                                // the great gate
			BlockPos t = LeafVillage.TORII;
			return x >= t.getX() - 6 && x <= t.getX() + 6 && z >= t.getZ() - 1 && z <= t.getZ() + 1;
		}
		if (level.dimension() == Level.OVERWORLD) {
			BlockPos t = Chikyu.overworldToriiIfKnown();
			return t != null && x >= t.getX() - 6 && x <= t.getX() + 6 && z >= t.getZ() - 1 && z <= t.getZ() + 1
					&& pos.getY() >= t.getY() - 13 && pos.getY() <= t.getY() + 8;
		}
		return false;
	}

	private static boolean builder(Player player) {
		return player != null && player.isCreative() && player.permissions().hasPermission(Permissions.COMMANDS_GAMEMASTER);
	}

	@SubscribeEvent
	public static void onBreak(BreakBlockEvent event) {
		if (!isProtected(event.getLevel(), event.getPos()) || builder(event.getPlayer()))
			return;
		var state = event.getLevel().getBlockState(event.getPos());
		if (pickable(state) && event.getLevel() instanceof Level level)
			REGROW.add(new Regrow(level.dimension(), event.getPos().immutable(), state, level.getGameTime() + REGROW_TICKS));
		else
			event.setCanceled(true);
	}

	@SubscribeEvent
	public static void onPlace(BlockEvent.EntityPlaceEvent event) {
		if (isProtected(event.getLevel(), event.getPos()) && !(event.getEntity() instanceof Player p && builder(p)))
			event.setCanceled(true);
	}

	/** Items that change blocks without placing one: buckets, fire, bone meal. */
	private static boolean changesBlocks(Item item) {
		return item instanceof BucketItem || item instanceof FlintAndSteelItem || item instanceof FireChargeItem || item instanceof BoneMealItem;
	}

	@SubscribeEvent
	public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
		if (changesBlocks(event.getItemStack().getItem()) && !builder(event.getEntity())
				&& (isProtected(event.getLevel(), event.getPos()) || isProtected(event.getLevel(), event.getPos().relative(event.getFace() == null ? net.minecraft.core.Direction.UP : event.getFace()))))
			event.setUseItem(TriState.FALSE);
	}

	@SubscribeEvent
	public static void onRightClickItem(PlayerInteractEvent.RightClickItem event) {
		// a bucket aimed at the river from the bank
		if (event.getItemStack().getItem() instanceof BucketItem && !builder(event.getEntity()) && isProtected(event.getLevel(), event.getEntity().blockPosition()))
			event.setCanceled(true);
	}

	@SubscribeEvent
	public static void onToolUse(BlockEvent.BlockToolModificationEvent event) {
		if (!event.isSimulated() && isProtected(event.getLevel(), event.getPos()) && !builder(event.getPlayer()))
			event.setCanceled(true);
	}

	@SubscribeEvent
	public static void onTrample(BlockEvent.FarmlandTrampleEvent event) {
		if (isProtected(event.getLevel(), event.getPos()))
			event.setCanceled(true);
	}

	@SubscribeEvent
	public static void onExplosion(ExplosionEvent.Detonate event) {
		event.getAffectedBlocks().removeIf(pos -> isProtected(event.getLevel(), pos));
	}

	@SubscribeEvent
	public static void onGrief(EntityMobGriefingEvent event) {
		if (isProtected(event.getEntity().level(), event.getEntity().blockPosition()))
			event.setCanGrief(false);
	}

	/** Fire however it starts (jutsu, lightning, lava): it goes out on the next tick, before it can burn anything. */
	@SubscribeEvent
	public static void onNeighborNotify(BlockEvent.NeighborNotifyEvent event) {
		if (event.getState().getBlock() instanceof BaseFireBlock && isProtected(event.getLevel(), event.getPos()))
			FIRES.add(new Fire(((Level) event.getLevel()).dimension(), event.getPos().immutable()));
	}

	@SubscribeEvent
	public static void onLevelTick(LevelTickEvent.Post event) {
		if (!REGROW.isEmpty() && event.getLevel() instanceof ServerLevel here && here.getGameTime() % 20 == 0)
			REGROW.removeIf(r -> {
				if (r.level() != here.dimension() || here.getGameTime() < r.at())
					return false;
				// back where it was, if nothing has taken the spot (and the chunk is there to grow in)
				if (!here.isLoaded(r.pos()))
					return false;
				if (here.getBlockState(r.pos()).isAir() && r.state().canSurvive(here, r.pos()))
					here.setBlock(r.pos(), r.state(), 3);
				return true;
			});
		if (FIRES.isEmpty() || !(event.getLevel() instanceof ServerLevel level) || level.dimension() != Chikyu.CHIKYU && level.dimension() != Level.OVERWORLD)
			return;
		FIRES.removeIf(f -> {
			if (f.level() != level.dimension())
				return false;
			if (level.getBlockState(f.pos()).getBlock() instanceof BaseFireBlock)
				level.setBlock(f.pos(), Blocks.AIR.defaultBlockState(), 3);
			return true;
		});
	}
}
