package net.mcreator.narutoshippudenmod.client;

import net.mcreator.narutoshippudenmod.core.Susanoo;

import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

/**
 * How the user moves in the Complete Susanoo (core/Susanoo), worked out on their own client the way Minecraft moves players:
 * <ul>
 * <li>standing: the Susanoo stands on the ground and holds its user in its chest, Susanoo.HOVER blocks up; it walks where they
 * steer (sprint for long strides), never falls, and follows the ground up and down;</li>
 * <li>jump: it takes off and flies the way an elytra glides, its wings carrying it: looking down dives and gains speed, looking
 * up climbs and loses it, holding forward beats the wings for thrust, holding jump lifts it; sneaking, or coming down near the
 * ground, lands it standing again.</li>
 * </ul>
 * Each tick the velocity is worked out before the player moves and put back after, so vanilla's own gravity and air drag don't
 * also act on it. A creative player flying the vanilla way is left alone.
 */
@EventBusSubscriber(modid = "naruto_shippuden", value = Dist.CLIENT)
public final class SusanooFlight {
	private SusanooFlight() {
	}

	public enum Mode {
		STAND, FLY
	}

	/** The local player's mode (others are drawn from how they move, SusanooRenderer.pose). */
	public static Mode mode = Mode.STAND;
	private static Vec3 velocity = Vec3.ZERO;
	private static boolean jumpWas;
	private static boolean active;

	/** How far below the feet the ground is (up to 40 blocks; 40 when there's none). */
	public static double gap(net.minecraft.world.entity.player.Player player) {
		var level = player.level();
		BlockPos feet = player.blockPosition();
		for (int dy = 0; dy < 40; dy++) {
			BlockPos at = feet.below(dy);
			var shape = level.getBlockState(at).getCollisionShape(level, at);
			if (!shape.isEmpty())
				return player.getY() - (at.getY() + shape.max(net.minecraft.core.Direction.Axis.Y));
		}
		return 40;
	}

	private static boolean controls(LocalPlayer player) {
		return Susanoo.stage(player) == Susanoo.MAX && !player.isSpectator() && !player.getAbilities().flying && !player.isPassenger()
				&& !player.isInWater() && !player.isInLava();
	}

	@SubscribeEvent
	public static void before(PlayerTickEvent.Pre event) {
		Minecraft mc = Minecraft.getInstance();
		if (!(event.getEntity() instanceof LocalPlayer player) || player != mc.player)
			return;
		if (!controls(player)) {
			if (active) {
				active = false;
				mode = Mode.STAND;
				player.setNoGravity(false);
			}
			return;
		}
		if (!active) {
			active = true;
			mode = Mode.STAND;
			velocity = player.getDeltaMovement();
		}
		player.setNoGravity(true);
		var keys = mc.options;
		boolean jump = keys.keyJump.isDown(), jumpTapped = jump && !jumpWas;
		jumpWas = jump;
		double gap = gap(player);
		Vec3 v = velocity;
		if (mode == Mode.STAND) {
			// held at the chest's height over the ground, eased toward it
			double vy = Mth.clamp((Susanoo.HOVER - gap) * 0.25, -0.9, 0.6);
			float forward = (keys.keyUp.isDown() ? 1 : 0) - (keys.keyDown.isDown() ? 1 : 0);
			float strafe = (keys.keyLeft.isDown() ? 1 : 0) - (keys.keyRight.isDown() ? 1 : 0);
			double len = Math.sqrt(forward * forward + strafe * strafe);
			double speed = keys.keySprint.isDown() ? 0.62 : 0.38;
			double tx = 0, tz = 0;
			if (len > 0) {
				float yaw = player.getYRot() * Mth.DEG_TO_RAD;
				double f = forward / len * speed, s = strafe / len * speed;
				tx = s * Mth.cos(yaw) - f * Mth.sin(yaw);
				tz = f * Mth.cos(yaw) + s * Mth.sin(yaw);
			}
			v = new Vec3(Mth.lerp(0.25, v.x, tx), vy, Mth.lerp(0.25, v.z, tz));
			if (jumpTapped) {
				// up into the air
				mode = Mode.FLY;
				Vec3 look = player.getLookAngle();
				v = new Vec3(look.x * 0.9, 1.1, look.z * 0.9);
			}
		} else {
			v = glide(player, v, keys.keyUp.isDown(), jump);
			if (keys.keyShift.isDown() || (gap <= Susanoo.HOVER + 0.5 && v.y <= 0))
				mode = Mode.STAND;                                        // landing: standing again at its full height
		}
		if (player.horizontalCollision)
			v = new Vec3(v.x * 0.3, v.y, v.z * 0.3);
		velocity = v;
		player.setDeltaMovement(v);
		player.fallDistance = 0;
	}

	@SubscribeEvent
	public static void after(PlayerTickEvent.Post event) {
		Minecraft mc = Minecraft.getInstance();
		if (!(event.getEntity() instanceof LocalPlayer player) || player != mc.player || !active)
			return;
		// what this tick worked out, without the drag and gravity vanilla added while moving
		player.setDeltaMovement(velocity);
		player.fallDistance = 0;
	}

	/** One tick of gliding the way an elytra does (LivingEntity's fall-flying), plus the wings' thrust and lift. */
	private static Vec3 glide(LocalPlayer player, Vec3 v, boolean thrust, boolean lift) {
		Vec3 look = player.getLookAngle();
		float pitch = player.getXRot() * Mth.DEG_TO_RAD;
		double lookH = Math.sqrt(look.x * look.x + look.z * look.z);
		double speedH = v.horizontalDistance();
		double liftK = Mth.cos(pitch) * Mth.cos(pitch) * Math.min(1, look.length() / 0.4);
		double gravity = 0.08;
		v = v.add(0, gravity * (-1 + liftK * 0.75), 0);
		if (v.y < 0 && lookH > 0) {
			double d = v.y * -0.1 * liftK;
			v = v.add(look.x * d / lookH, d, look.z * d / lookH);
		}
		if (pitch < 0 && lookH > 0) {
			double d = speedH * -Mth.sin(pitch) * 0.04;
			v = v.add(-look.x * d / lookH, d * 3.2, -look.z * d / lookH);
		}
		if (lookH > 0)
			v = v.add((look.x / lookH * speedH - v.x) * 0.1, 0, (look.z / lookH * speedH - v.z) * 0.1);
		v = v.multiply(0.99, 0.98, 0.99);
		if (thrust) {
			// the wings beat: like a firework's push, gentler, steadier
			Vec3 level = new Vec3(look.x, look.y * 0.5, look.z);     // its push mostly forward: it climbs when pointed well up
			v = v.add(level.scale(0.05)).add(level.scale(1.6).subtract(v).scale(0.045));
		}
		if (lift)
			v = v.add(0, 0.07, 0);
		double speed = v.length();
		if (speed > 2.4)
			v = v.scale(2.4 / speed);
		return v;
	}
}
