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
		} else if (cameraTaken) {
			cameraTaken = false;
			mc.setCameraEntity(mc.player);
		}
	}
}
