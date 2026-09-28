package net.mcreator.narutoshippudenmod.core;

import net.mcreator.narutoshippudenmod.NarutoShippudenMod;
import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables;
import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables.PlayerVariables;
import net.mcreator.narutoshippudenmod.economy.Ryo;

import net.minecraft.ChatFormatting;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.OwnableEntity;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;

import java.util.UUID;

import org.jspecify.annotations.Nullable;

/**
 * Levels, XP and who gets the kill. Kills give XP by the victim's strength (animals none, a zombie 5, bosses a lot) and drop Ryo;
 * each level needs {@code 10 + 5 * level} XP and gives JP, SP and max chakra. Kills made by a player's jutsu, clones, summons or
 * their projectiles count as the player's: everything spawned while a jutsu is cast remembers its caster.
 */
@EventBusSubscriber(modid = NarutoShippudenMod.MODID)
public final class Progression {
	public static final int JP_PER_LEVEL = 3;
	public static final int SP_PER_LEVEL = 5;
	public static final int CHAKRA_PER_LEVEL = 5;
	private static final String OWNER = "naruto_shippuden:owner";
	private static final ThreadLocal<ServerPlayer> CASTER = new ThreadLocal<>();

	private Progression() {
	}

	public static int xpToNext(int level) {
		return 10 + 5 * level;
	}

	// ------------------------------------------------------------------ ownership
	/** Runs a jutsu; whatever it spawns belongs to the player. */
	public static void casting(ServerPlayer player, Runnable jutsu) {
		ServerPlayer previous = CASTER.get();
		CASTER.set(player);
		try {
			jutsu.run();
		} finally {
			CASTER.set(previous);
		}
	}

	@SubscribeEvent
	public static void spawned(EntityJoinLevelEvent event) {
		ServerPlayer caster = CASTER.get();
		if (caster != null && !event.getLevel().isClientSide() && !(event.getEntity() instanceof Player))
			event.getEntity().getPersistentData().putString(OWNER, caster.getUUID().toString());
	}

	/** The player behind an entity: itself, a projectile's shooter, a summon's owner or a jutsu's caster (followed a few steps). */
	public static @Nullable Entity owner(@Nullable Entity entity) {
		for (int i = 0; i < 5 && entity != null && !(entity instanceof Player); i++) {
			Entity next = null;
			if (entity instanceof Projectile projectile)
				next = projectile.getOwner();
			else if (entity instanceof OwnableEntity ownable)
				next = ownable.getOwner();
			if (next == null) {
				String uuid = entity.getPersistentData().getStringOr(OWNER, "");
				if (!uuid.isEmpty())
					next = entity.level().getPlayerByUUID(UUID.fromString(uuid));
			}
			if (next == null)
				break;
			entity = next;
		}
		return entity;
	}

	@SubscribeEvent
	public static void damaged(LivingDamageEvent.Post event) {
		Entity source = event.getSource().getEntity();
		if (source != null && !(source instanceof Player) && owner(source) instanceof Player player)
			event.getEntity().setLastHurtByPlayer(player, 100);
	}

	/** Who a death counts for: the owner of whatever dealt the blow, else the last player to hurt it, else the direct killer. */
	public static @Nullable Entity credit(LivingDeathEvent event) {
		Entity killer = owner(event.getSource().getEntity());
		if (killer instanceof Player)
			return killer;
		Player last = event.getEntity().getLastHurtByPlayer();
		return last != null ? last : killer;
	}

	// ------------------------------------------------------------------ rewards
	public static int killXp(LivingEntity victim) {
		if (victim instanceof Player)
			return 25;
		if (owner(victim) instanceof Player)
			return 0;
		Identifier id = BuiltInRegistries.ENTITY_TYPE.getKey(victim.getType());
		boolean mod = id.getNamespace().equals(NarutoShippudenMod.MODID);
		if (id.getPath().contains("dummy") || !(victim instanceof Enemy || mod && !(victim instanceof Animal)))
			return 0;
		return Math.min(500, Math.max(1, Math.round(victim.getMaxHealth() / 4)));
	}

	/** XP (and Ryo, dropped where the victim died) for a kill. */
	public static void onKill(@Nullable Entity killer, Entity victim) {
		if (!(killer instanceof ServerPlayer player) || !(victim instanceof LivingEntity living))
			return;
		int xp = killXp(living);
		if (xp <= 0)
			return;
		addXp(player, xp);
		player.sendOverlayMessage(Component.literal("+" + xp + " XP").withStyle(ChatFormatting.GREEN));
		if (!(victim instanceof Player) && victim.level() instanceof ServerLevel level)
			Ryo.drop(level, victim.position(), Math.round(xp * (0.5F + level.getRandom().nextFloat())));
	}

	public static void addXp(ServerPlayer player, double xp) {
		NarutoShippudenModVariables.ifPresent(player, v -> v.LEVEL += xp);
		levelUp(player);
	}

	/** Turns banked XP into levels (called every tick, so XP from gifts and missions levels up too). */
	public static void levelUp(Entity entity) {
		PlayerVariables v = NarutoShippudenModVariables.get(entity);
		int level = (int) v.LEVELSTAT, cap = (int) v.LevelStatMaxChange, gained = 0;
		double xp = v.LEVEL;
		while (level < cap && xp >= xpToNext(level)) {
			xp -= xpToNext(level);
			level++;
			gained++;
		}
		if (gained == 0 && v.LEVELMAX == xpToNext(level))
			return;
		int levels = gained, newLevel = level;
		double left = xp;
		NarutoShippudenModVariables.ifPresent(entity, vars -> {
			vars.LEVEL = left;
			vars.LEVELSTAT = newLevel;
			vars.LEVELMAX = xpToNext(newLevel);
			vars.jp += JP_PER_LEVEL * levels;
			vars.sp += SP_PER_LEVEL * levels;
			vars.ChakraMax += CHAKRA_PER_LEVEL * levels;
			vars.syncPlayerVariables(entity);
		});
		if (gained > 0 && entity instanceof ServerPlayer player) {
			player.sendOverlayMessage(Component.literal("Level " + level + "  ").withStyle(ChatFormatting.YELLOW)
					.append(Component.literal("+" + JP_PER_LEVEL * gained + " JP  +" + SP_PER_LEVEL * gained + " SP").withStyle(ChatFormatting.GREEN)));
			player.level().playSound(null, player.blockPosition(), SoundEvents.PLAYER_LEVELUP, SoundSource.PLAYERS, 0.75F, 1.0F);
		}
	}
}
