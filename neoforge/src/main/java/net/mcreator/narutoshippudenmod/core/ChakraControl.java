package net.mcreator.narutoshippudenmod.core;

import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables;
import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables.PlayerVariables;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.Vec3;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

/**
 * Chakra Control, switched on and off with its key. While it is on, chakra moulded into the feet lets a ninja stand on water
 * (sneak to sink) and walk up walls and trees (walk into them to climb, sneak to cling, let go to slide down); the Dash key is a
 * Body Flicker in the direction being walked (up while jumping, once more in the air); sprinting punches carry chakra-enhanced
 * strength; and standing still while sneaking focuses: chakra comes back faster and the chakra of everything near is sensed.
 * Standing on water or clinging to a wall slowly uses chakra; with none left, Chakra Control lets go.
 */
@EventBusSubscriber(modid = "naruto_shippuden")
public final class ChakraControl {
	private static final double DASH_COST = 10, STRIKE_COST = 5, HOLD_COST = 2;
	private static final int DASH_COOLDOWN = 16, FOCUS_AFTER = 40;
	private static final String DASH_READY = "naruto_shippuden:dash_ready", AIR_DASHED = "naruto_shippuden:air_dashed",
			FOCUS = "naruto_shippuden:focus";
	/** Dash directions the client sends, as bits. */
	public static final int FORWARD = 1, BACK = 2, LEFT = 4, RIGHT = 8, UP = 16;

	private ChakraControl() {
	}

	private static PlayerVariables vars(Player player) {
		return NarutoShippudenModVariables.get(player);
	}

	private static void set(ServerPlayer player, java.util.function.Consumer<PlayerVariables> change) {
		NarutoShippudenModVariables.ifPresent(player, v -> {
			change.accept(v);
			v.syncPlayerVariables(player);
		});
	}

	public static void toggle(ServerPlayer player) {
		boolean on = !vars(player).Chakra_Control;
		if (on && vars(player).ChakraAmount < HOLD_COST) {
			player.sendOverlayMessage(Component.literal("Not enough chakra"));
			return;
		}
		set(player, v -> v.Chakra_Control = on);
		player.setNoGravity(false);
		player.sendOverlayMessage(Component.literal(on ? "Chakra Control on" : "Chakra Control off"));
		if (on)
			net.mcreator.narutoshippudenmod.story.Story.event(player, "chakra_control");
		player.level().playSound(null, player.getX(), player.getY(), player.getZ(), on ? SoundEvents.BEACON_ACTIVATE : SoundEvents.BEACON_DEACTIVATE,
				SoundSource.PLAYERS, 0.35F, 1.8F);
	}

	// ------------------------------------------------------------------ body flicker
	public static void dash(ServerPlayer player, int keys) {
		PlayerVariables v = vars(player);
		if (player.isSpectator() || player.isPassenger())
			return;
		if (!v.Chakra_Control) {
			player.sendOverlayMessage(Component.literal("Turn on Chakra Control to dash"));
			return;
		}
		long now = player.level().getGameTime();
		if (now < player.getPersistentData().getLongOr(DASH_READY, 0))
			return;
		boolean air = !player.onGround() && !player.isInWater() && !onWater(player);
		if (air && player.getPersistentData().getBooleanOr(AIR_DASHED, false))
			return;
		if (v.ChakraAmount < DASH_COST) {
			player.sendOverlayMessage(Component.literal("Not enough chakra"));
			return;
		}
		set(player, x -> x.ChakraAmount -= DASH_COST);
		player.getPersistentData().putLong(DASH_READY, now + DASH_COOLDOWN);
		if (air)
			player.getPersistentData().putBoolean(AIR_DASHED, true);

		double yaw = Math.toRadians(player.getYRot());
		Vec3 forward = new Vec3(-Math.sin(yaw), 0, Math.cos(yaw)), left = new Vec3(Math.cos(yaw), 0, Math.sin(yaw));
		int f = ((keys & FORWARD) != 0 ? 1 : 0) - ((keys & BACK) != 0 ? 1 : 0), s = ((keys & LEFT) != 0 ? 1 : 0) - ((keys & RIGHT) != 0 ? 1 : 0);
		Vec3 dir = forward.scale(f).add(left.scale(s));
		if (dir.lengthSqr() < 1.0E-4)
			dir = (keys & UP) != 0 ? Vec3.ZERO : forward;
		dir = dir.lengthSqr() > 0 ? dir.normalize() : dir;
		double up = (keys & UP) != 0 ? 0.95 : Math.max(0.2, player.getDeltaMovement().y);
		double speed = (keys & UP) != 0 ? 0.9 : 1.7;
		player.setDeltaMovement(dir.x * speed, up, dir.z * speed);
		player.syncVelocity = true;
		net.mcreator.narutoshippudenmod.story.Story.event(player, "dash");
		player.fallDistance = 0;

		ServerLevel level = (ServerLevel) player.level();
		level.sendParticles(ParticleTypes.CLOUD, player.getX(), player.getY() + 0.2, player.getZ(), 8, 0.25, 0.05, 0.25, 0.04);
		level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.BREEZE_JUMP, SoundSource.PLAYERS, 0.6F, 1.3F);
	}

	// ------------------------------------------------------------------ water and walls
	/** Standing on (or just in) the surface of water, feet out. */
	public static boolean onWater(Player player) {
		Level level = player.level();
		BlockPos below = BlockPos.containing(player.getX(), player.getY() - 0.2, player.getZ());
		FluidState fluid = level.getFluidState(below);
		if (fluid.isEmpty())
			return false;
		double surface = surface(below);
		return player.getY() >= surface - 0.4 && level.getFluidState(BlockPos.containing(player.getX(), player.getY() + 0.5, player.getZ())).isEmpty();
	}

	/**
	 * Where a ninja stands on water: level with the top of the block, like the ground beside it (the water itself is a little
	 * lower), so stepping on and off the shore never catches on the edge.
	 */
	private static double surface(BlockPos water) {
		return water.getY() + 1;
	}

	/** A wall right in front of the player (or pushed against). */
	public static boolean onWall(Player player) {
		if (player.horizontalCollision)
			return true;
		Vec3 look = Vec3.directionFromRotation(0, player.getYRot()).scale(0.15);
		return !player.level().noCollision(player, player.getBoundingBox().deflate(0.02, 0.1, 0.02).move(look.x, 0.1, look.z));
	}

	private static boolean active(Player player) {
		PlayerVariables v = vars(player);
		return v.Chakra_Control && v.ChakraAmount > 0 && !player.isSpectator() && !player.getAbilities().flying && !player.isPassenger()
				&& !player.isFallFlying();
	}

	@SubscribeEvent
	public static void tick(PlayerTickEvent.Post event) {
		Player player = event.getEntity();
		if (player.onGround())
			player.getPersistentData().remove(AIR_DASHED);
		if (!active(player)) {
			player.getPersistentData().remove(FOCUS);
			return;
		}
		boolean water = onWater(player), wall = onWall(player);
		if (player.level().isClientSide()) {
			if (player.isLocalPlayer())
				move(player, water, wall);
			return;
		}
		wall &= !player.onGround();
		ServerPlayer p = (ServerPlayer) player;
		if (water || wall)
			p.fallDistance = 0;
		if (player.isInWater() && !player.isShiftKeyDown())
			p.fallDistance = 0;
		long time = player.level().getGameTime();
		if ((water || wall) && time % 20 == 0)
			use(p, HOLD_COST);
		focus(p, time);
	}

	/** The local player's feet: the client moves the player, so it keeps them on the water and on the wall. */
	private static void move(Player player, boolean water, boolean wall) {
		Vec3 m = player.getDeltaMovement();
		// walking into a wall climbs it (from the ground too); hanging on one, sneak clings and letting go slides down
		if (wall && (player.zza > 0 || !player.onGround() && !water)) {
			double y = player.zza > 0 ? 0.22 : player.isShiftKeyDown() ? 0 : Math.max(m.y, -0.12);
			player.setDeltaMovement(m.x, y, m.z);
			player.fallDistance = 0;
			return;
		}
		if (player.isShiftKeyDown() && water)
			return;
		if (water && m.y <= 0) {
			BlockPos below = BlockPos.containing(player.getX(), player.getY() - 0.2, player.getZ());
			player.setPos(player.getX(), surface(below), player.getZ());
			player.setDeltaMovement(m.x, 0, m.z);
			player.setOnGround(true);
			player.fallDistance = 0;
			return;
		}
		if (player.isInWater() && !player.isUnderWater() && !player.isShiftKeyDown())
			// climbing out onto the surface
			player.setDeltaMovement(m.x, Math.max(m.y, 0.12), m.z);
	}

	private static boolean use(ServerPlayer player, double chakra) {
		if (vars(player).ChakraAmount >= chakra) {
			set(player, v -> v.ChakraAmount -= chakra);
			return true;
		}
		set(player, v -> v.Chakra_Control = false);
		player.sendOverlayMessage(Component.literal("Out of chakra: Chakra Control off"));
		return false;
	}

	/** Calm and focused: sneaking without moving. Chakra comes back faster and the chakra of everything near is sensed. */
	private static void focus(ServerPlayer player, long time) {
		Vec3 m = player.getDeltaMovement();
		boolean still = player.isShiftKeyDown() && player.onGround() && m.x * m.x + m.z * m.z < 1.0E-4;
		if (!still) {
			player.getPersistentData().remove(FOCUS);
			return;
		}
		int held = player.getPersistentData().getIntOr(FOCUS, 0) + 1;
		player.getPersistentData().putInt(FOCUS, held);
		if (held < FOCUS_AFTER)
			return;
		ServerLevel level = (ServerLevel) player.level();
		if (held == FOCUS_AFTER)
			player.sendOverlayMessage(Component.literal("Focusing chakra"));
		if (held % 20 == 0) {
			PlayerVariables v = vars(player);
			double regained = Math.max(1, v.ChakraMax * 0.02);
			set(player, x -> x.ChakraAmount = Math.min(x.ChakraMax, x.ChakraAmount + regained));
			level.sendParticles(ParticleTypes.ENCHANT, player.getX(), player.getY() + 1.2, player.getZ(), 6, 0.4, 0.5, 0.4, 0.4);
		}
		if (held % 60 == 0)
			for (LivingEntity near : level.getEntitiesOfClass(LivingEntity.class, player.getBoundingBox().inflate(24), e -> e != player && e.isAlive()))
				near.addEffect(new MobEffectInstance(MobEffects.GLOWING, 70, 0, false, false));
	}

	// ------------------------------------------------------------------ chakra-enhanced strength
	@SubscribeEvent
	public static void strike(LivingDamageEvent.Pre event) {
		if (!(event.getSource().getDirectEntity() instanceof ServerPlayer player) || !event.getSource().is(DamageTypes.PLAYER_ATTACK)
				|| !player.isSprinting() || !active(player) || vars(player).ChakraAmount < STRIKE_COST)
			return;
		set(player, v -> v.ChakraAmount -= STRIKE_COST);
		event.setNewDamage(event.getNewDamage() * 1.5F + 2);
		LivingEntity target = event.getEntity();
		Vec3 away = target.position().subtract(player.position()).multiply(1, 0, 1).normalize();
		target.push(away.x * 1.3, 0.45, away.z * 1.3);
		target.syncVelocity = true;
		ServerLevel level = (ServerLevel) player.level();
		level.sendParticles(ParticleTypes.CRIT, target.getX(), target.getY() + target.getBbHeight() / 2, target.getZ(), 14, 0.3, 0.3, 0.3, 0.4);
		level.playSound(null, target.getX(), target.getY(), target.getZ(), SoundEvents.PLAYER_ATTACK_KNOCKBACK, SoundSource.PLAYERS, 1, 0.8F);
	}

	@SubscribeEvent
	public static void loggedIn(PlayerEvent.PlayerLoggedInEvent event) {
		// the old water walking left players without gravity
		if (!event.getEntity().isCreative())
			event.getEntity().setNoGravity(false);
	}
}
