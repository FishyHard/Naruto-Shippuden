package net.mcreator.narutoshippudenmod.core;

import net.mcreator.narutoshippudenmod.NarutoShippudenMod;

import net.minecraft.server.level.ServerPlayer;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

/**
 * Development only (-Dnaruto.devtest=true): the time the mod's player tick listeners take (from the first to the last listener on
 * PlayerTickEvent.Post) and how many variable syncs go out, logged every ten seconds as "DEVTEST tick".
 */
@EventBusSubscriber(modid = "naruto_shippuden")
public final class TickProfiler {
	public static final boolean ENABLED = Boolean.getBoolean("naruto.devtest");
	private static long start, nanos, ticks, maxNanos;
	public static long syncs;
	/** Who asked for the syncs that went out (the first request each tick), by method. */
	private static final java.util.Map<String, Integer> SYNC_FROM = new java.util.HashMap<>();

	public static void syncFrom(StackTraceElement[] stack) {
		// the first frame outside the variables class (a lambda passed to ifPresent counts as its caller's)
		StackTraceElement at = stack[stack.length - 1];
		for (int i = 1; i < stack.length; i++)
			if (!stack[i].getClassName().startsWith("net.mcreator.narutoshippudenmod.NarutoShippudenModVariables")) {
				at = stack[i];
				break;
			}
		String where = at.getClassName().replaceAll(".*\\.", "") + "." + at.getMethodName() + ":" + at.getLineNumber();
		SYNC_FROM.merge(where, 1, Integer::sum);
	}

	private TickProfiler() {
	}

	@SubscribeEvent(priority = EventPriority.HIGHEST)
	public static void begin(PlayerTickEvent.Post event) {
		if (ENABLED && event.getEntity() instanceof ServerPlayer)
			start = System.nanoTime();
	}

	@SubscribeEvent(priority = EventPriority.LOWEST)
	public static void end(PlayerTickEvent.Post event) {
		if (!ENABLED || !(event.getEntity() instanceof ServerPlayer player))
			return;
		long took = System.nanoTime() - start;
		nanos += took;
		maxNanos = Math.max(maxNanos, took);
		if (++ticks % 200 == 0) {
			NarutoShippudenMod.LOGGER.info("DEVTEST tick: {} us average, {} us worst, {} syncs a second", nanos / ticks / 1000, maxNanos / 1000,
					syncs * 20.0 / 200);
			SYNC_FROM.entrySet().stream().sorted((a, b) -> b.getValue() - a.getValue()).limit(6)
					.forEach(e -> NarutoShippudenMod.LOGGER.info("DEVTEST tick sync from {} x{}", e.getKey(), e.getValue()));
			SYNC_FROM.clear();
			nanos = maxNanos = syncs = 0;
			ticks = 0;
		}
	}
}
