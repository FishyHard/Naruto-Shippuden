package net.mcreator.narutoshippudenmod.compat;

import java.util.function.Supplier;

import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.permissions.PermissionSet;
import net.minecraft.tags.TagKey;
import net.minecraft.world.damagesource.DamageSources;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.level.LevelEvent;

/** Small helpers standing in for 1.16 APIs that no longer exist in the same shape. */
@EventBusSubscriber(modid = "naruto_shippuden")
public final class Compat {
	private static DamageSources damageSources;

	private Compat() {
	}

	/** Damage sources were static constants in 1.16; now they come from the registry of a loaded level. */
	public static DamageSources damage() {
		return damageSources;
	}

	@SubscribeEvent
	public static void onLevelLoad(LevelEvent.Load event) {
		if (event.getLevel() instanceof Level level)
			damageSources = level.damageSources();
	}

	/** Gives the stack to the player, dropping whatever does not fit (was ItemHandlerHelper.giveItemToPlayer). */
	public static void giveItemToPlayer(Player player, ItemStack stack) {
		if (!player.getInventory().add(stack))
			player.drop(stack, false, net.minecraft.util.Prediction.SERVER_ONLY);
	}

	/** Runs a command as the entity with full permissions and no chat output (server side only). */
	public static void runCommand(Entity entity, String command) {
		if (entity.level() instanceof ServerLevel level)
			level.getServer().getCommands().performPrefixedCommand(
					entity.createCommandSourceStackForNameResolution(level).withSuppressedOutput().withPermission(PermissionSet.ALL_PERMISSIONS),
					command);
	}

	/** Runs a command at a position with full permissions and no chat output (server side only). */
	public static void runCommandAt(LevelAccessor world, double x, double y, double z, String command) {
		if (world instanceof ServerLevel level)
			level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, level,
					PermissionSet.ALL_PERMISSIONS, Component.literal(""), level.getServer()).withSuppressedOutput(), command);
	}

	public static boolean blockHasTag(Block block, Identifier tag) {
		return block.defaultBlockState().is(TagKey.create(Registries.BLOCK, tag));
	}

	public static boolean blockHasTag(BlockState state, Identifier tag) {
		return state.is(TagKey.create(Registries.BLOCK, tag));
	}

	public static boolean itemHasTag(Item item, Identifier tag) {
		return item.builtInRegistryHolder().is(TagKey.create(Registries.ITEM, tag));
	}

	public static boolean entityHasTag(EntityType<?> type, Identifier tag) {
		return type.builtInRegistryHolder().is(TagKey.create(Registries.ENTITY_TYPE, tag));
	}

	/** Knockback for the mod's projectiles (arrows lost the knockback field). */
	public static void setKnockback(Entity projectile, int knockback) {
		if (projectile instanceof ModArrow arrow)
			arrow.setKnockback(knockback);
	}

	/** Sound by id; ids that are not registered give a silent, unregistered event instead of null. */
	public static net.minecraft.sounds.SoundEvent sound(String id) {
		Identifier key = Identifier.tryParse(id);
		if (key == null || key.getPath().isEmpty())
			key = Identifier.fromNamespaceAndPath("naruto_shippuden", "silent");
		net.minecraft.sounds.SoundEvent sound = net.minecraft.core.registries.BuiltInRegistries.SOUND_EVENT.getValue(key);
		return sound != null ? sound : net.minecraft.sounds.SoundEvent.createVariableRangeEvent(key);
	}

	public static boolean blockHasTag(Identifier tag, Block block) {
		return blockHasTag(block, tag);
	}

	public static boolean blockHasTag(Identifier tag, BlockState state) {
		return blockHasTag(state, tag);
	}

	public static boolean itemHasTag(Identifier tag, Item item) {
		return itemHasTag(item, tag);
	}

	public static boolean entityHasTag(Identifier tag, EntityType<?> type) {
		return entityHasTag(type, tag);
	}

	/** Custom item name (was ItemStack.setHoverName). */
	public static ItemStack setName(ItemStack stack, Component name) {
		stack.set(net.minecraft.core.component.DataComponents.CUSTOM_NAME, name);
		return stack;
	}

	/** Replaces the stack's custom data (was ItemStack.setTag). */
	public static void setCustomData(ItemStack stack, net.minecraft.nbt.CompoundTag tag) {
		net.minecraft.world.item.component.CustomData.set(net.minecraft.core.component.DataComponents.CUSTOM_DATA, stack, tag);
	}

	/** Block "materials" are gone; the checks the mod made map onto these tags. */
	public static TagKey<Block> materialTag(String material) {
		return switch (material) {
			case "GRASS" -> net.minecraft.tags.BlockTags.DIRT;
			case "STONE" -> net.minecraft.tags.BlockTags.BASE_STONE_OVERWORLD;
			case "WOOD", "NETHER_WOOD" -> net.minecraft.tags.BlockTags.LOGS;
			case "LEAVES" -> net.minecraft.tags.BlockTags.LEAVES;
			case "SAND" -> net.minecraft.tags.BlockTags.SAND;
			case "SNOW", "TOP_SNOW" -> net.minecraft.tags.BlockTags.SNOW;
			case "ICE", "ICE_SOLID" -> net.minecraft.tags.BlockTags.ICE;
			case "WOOL" -> net.minecraft.tags.BlockTags.WOOL;
			case "DIRT" -> net.minecraft.tags.BlockTags.DIRT;
			case "PLANT", "REPLACEABLE_PLANT" -> net.minecraft.tags.BlockTags.REPLACEABLE_BY_TREES;
			default -> TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath("naruto_shippuden", "material_" + material.toLowerCase()));
		};
	}

	private record SpawnPlacementEntry(Supplier<? extends EntityType<?>> type, net.minecraft.world.entity.SpawnPlacementType placement,
			net.minecraft.world.level.levelgen.Heightmap.Types heightmap, net.minecraft.world.entity.SpawnPlacements.SpawnPredicate<?> predicate) {
	}

	private static final java.util.List<SpawnPlacementEntry> SPAWN_PLACEMENTS = new java.util.ArrayList<>();

	/** Recorded now, applied when NeoForge asks for spawn placements (the entity type does not exist yet). */
	public static <T extends Entity> void spawnPlacement(Supplier<EntityType<T>> type, net.minecraft.world.entity.SpawnPlacementType placement,
			net.minecraft.world.level.levelgen.Heightmap.Types heightmap, net.minecraft.world.entity.SpawnPlacements.SpawnPredicate<T> predicate) {
		SPAWN_PLACEMENTS.add(new SpawnPlacementEntry(type, placement, heightmap, predicate));
	}

	@SuppressWarnings({"unchecked", "rawtypes"})
	@SubscribeEvent
	public static void registerSpawnPlacements(net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent event) {
		for (SpawnPlacementEntry entry : SPAWN_PLACEMENTS)
			event.register((EntityType) entry.type().get(), entry.placement(), entry.heightmap(), (net.minecraft.world.entity.SpawnPlacements.SpawnPredicate) entry.predicate(),
					net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent.Operation.REPLACE);
	}

	/**
	 * An entity's game mode, safe on a dedicated server (the old procedures asked the client's player list for it, a client-only class).
	 * On the client only creative and spectator can be told apart; anything else reads as survival.
	 */
	public static boolean isGameMode(net.minecraft.world.entity.Entity entity, net.minecraft.world.level.GameType mode) {
		if (entity instanceof net.minecraft.server.level.ServerPlayer player)
			return player.gameMode.getGameModeForPlayer() == mode;
		if (entity instanceof net.minecraft.world.entity.player.Player player)
			return (player.isSpectator() ? net.minecraft.world.level.GameType.SPECTATOR
					: player.isCreative() ? net.minecraft.world.level.GameType.CREATIVE : net.minecraft.world.level.GameType.SURVIVAL) == mode;
		return false;
	}
}
