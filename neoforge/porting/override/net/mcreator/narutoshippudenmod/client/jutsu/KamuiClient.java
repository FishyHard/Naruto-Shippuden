package net.mcreator.narutoshippudenmod.client.jutsu;

import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.MovementInputUpdateEvent;

/**
 * Kamui Phantom Phasing on the client, which moves the player: once the player's input is read (after vanilla has turned
 * collisions back on for the tick, and before the player moves), collisions go off whenever they walk into a wall or stand
 * inside one. Inside blocks they hover, and sneaking sinks them.
 */
@EventBusSubscriber(modid = "naruto_shippuden", value = Dist.CLIENT)
public final class KamuiClient {
	private KamuiClient() {
	}

	@SubscribeEvent
	public static void phase(MovementInputUpdateEvent event) {
		Player player = event.getEntity();
		if (!NarutoShippudenModVariables.get(player).KamuiPhantomPhase || player.isSpectator())
			return;
		Vec2 input = event.getInput().getMoveVector();
		double yaw = Math.toRadians(player.getYRot());
		Vec3 forward = new Vec3(-Math.sin(yaw), 0, Math.cos(yaw)), left = new Vec3(Math.cos(yaw), 0, Math.sin(yaw));
		Vec3 walk = forward.scale(input.y).add(left.scale(input.x));
		if (walk.lengthSqr() > 1)
			walk = walk.normalize();
		boolean inside = !player.level().noCollision(player, player.getBoundingBox().deflate(0.05));
		boolean walling = walk.lengthSqr() > 0.01
				&& !player.level().noCollision(player, player.getBoundingBox().move(walk.x * 0.4, 0.05, walk.z * 0.4).deflate(0.05, 0, 0.05));
		boolean sinking = event.getInput().keyPresses.shift() && !player.level().noCollision(player, player.getBoundingBox().move(0, -0.2, 0));
		player.noPhysics = inside || walling || sinking;
		if (player.noPhysics) {
			Vec3 move = player.getDeltaMovement();
			double y = event.getInput().keyPresses.shift() ? -0.15 : event.getInput().keyPresses.jump() ? 0.2 : Math.max(0, move.y);
			player.setDeltaMovement(move.x, y, move.z);
			player.fallDistance = 0;
		}
	}
}
