package net.mcreator.narutoshippudenmod.compat;

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
			player.drop(stack, false);
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
		return type.is(TagKey.create(Registries.ENTITY_TYPE, tag));
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
}
