package net.mcreator.narutoshippudenmod.client;

import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables;
import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables.PlayerVariables;
import net.mcreator.narutoshippudenmod.core.NarutoActions;

import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.Entity;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.neoforge.client.event.InputEvent;
import net.neoforged.neoforge.client.network.ClientPacketDistributor;

import org.jspecify.annotations.Nullable;

/**
 * The client side of being held or of holding another's body:
 * <ul>
 * <li>Restrained (caught in a shadow, a mind taken over): no swing, attack or use, no hotbar change, and none of the mod's keys.</li>
 * <li>Possessing (Mind Body Switch): the camera is the creature's eyes, and attacking makes the creature strike.</li>
 * </ul>
 */
@EventBusSubscriber(modid = "naruto_shippuden", value = Dist.CLIENT)
public final class Restrained {
	private static boolean cameraTaken;
	/** The look last sent while possessing (only changes are sent). */
	private static float sentYaw = Float.NaN, sentPitch = Float.NaN;

	private Restrained() {
	}

	private static @Nullable PlayerVariables vars() {
		Minecraft mc = Minecraft.getInstance();
		return mc.player == null ? null : NarutoShippudenModVariables.get(mc.player);
	}

	@SubscribeEvent
	public static void interaction(InputEvent.InteractionKeyMappingTriggered event) {
		PlayerVariables v = vars();
		if (v == null || !v.restrained && v.possessing <= 0)
			return;
		event.setCanceled(true);
		event.setSwingHand(false);
		if (!v.restrained && event.isAttack())
			ClientPacketDistributor.sendToServer(new NarutoActions.Action("mind", "attack", 0));
	}

	/** Caught: the mouse doesn't turn them (the server turns them with the caster, or holds their look). */
	@SubscribeEvent
	public static void noTurning(net.neoforged.neoforge.client.event.CalculatePlayerTurnEvent event) {
		PlayerVariables v = vars();
		if (v != null && v.restrained)
			// the game cubes (sensitivity * 0.6 + 0.2): this makes it 0
			event.setMouseSensitivity(-1 / 3.0);
	}

	/** Caught: they crouch when the one who caught them crouches (Shadow Imitation copies it), and only then. */
	@SubscribeEvent
	public static void crouch(net.neoforged.neoforge.client.event.MovementInputUpdateEvent event) {
		PlayerVariables v = vars();
		if (v == null || !v.restrained)
			return;
		event.getInput().keyPresses = new net.minecraft.world.entity.player.Input(false, false, false, false, false, v.mimic_sneak, false);
	}

	@SubscribeEvent
	public static void scroll(InputEvent.MouseScrollingEvent event) {
		PlayerVariables v = vars();
		if (v != null && (v.restrained || v.possessing > 0))
			event.setCanceled(true);
	}

	@SubscribeEvent
	public static void tick(ClientTickEvent.Pre event) {
		Minecraft mc = Minecraft.getInstance();
		PlayerVariables v = vars();
		if (v == null || mc.level == null)
			return;
		if (v.restrained)
			// caught: no step, jump, crouch or sprint of their own (the server moves them; their crouch copies the caster's, below)
			for (KeyMapping key : new KeyMapping[] { mc.options.keyUp, mc.options.keyDown, mc.options.keyLeft, mc.options.keyRight, mc.options.keyJump,
					mc.options.keyShift, mc.options.keySprint })
				key.setDown(false);
		if (v.restrained || v.possessing > 0) {
			for (KeyMapping key : mc.options.keyHotbarSlots)
				while (key.consumeClick()) {
				}
			for (KeyMapping key : new KeyMapping[] { mc.options.keyDrop, mc.options.keySwapOffhand })
				while (key.consumeClick()) {
				}
			for (KeyMapping key : mc.options.keyMappings)
				if (key.getCategory() == EyeKeys.CATEGORY) {
					while (key.consumeClick()) {
					}
					key.setDown(false);
				}
		}
		// seeing through the possessed creature's eyes
		Entity inside = v.possessing > 0 ? mc.level.getEntity((int) v.possessing - 1) : null;
		if (inside != null) {
			if (mc.getCameraEntity() != inside)
				mc.setCameraEntity(inside);
			inside.setYRot(mc.player.getYRot());
			inside.setXRot(mc.player.getXRot());
			inside.setYHeadRot(mc.player.getYRot());
			cameraTaken = true;
			// the game sends no look of its own while the camera is the creature: the server steers it by this one
			if (mc.player.getYRot() != sentYaw) {
				sentYaw = mc.player.getYRot();
				ClientPacketDistributor.sendToServer(new NarutoActions.Action("mind", "yaw", sentYaw));
			}
			if (mc.player.getXRot() != sentPitch) {
				sentPitch = mc.player.getXRot();
				ClientPacketDistributor.sendToServer(new NarutoActions.Action("mind", "pitch", sentPitch));
			}
		} else if (cameraTaken) {
			cameraTaken = false;
			sentYaw = sentPitch = Float.NaN;
			mc.setCameraEntity(mc.player);
		}
	}
}
