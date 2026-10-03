package net.mcreator.narutoshippudenmod.client;

import net.mcreator.narutoshippudenmod.core.NarutoActions;
import net.mcreator.narutoshippudenmod.core.Susanoo;

import net.minecraft.client.Minecraft;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.InputEvent;
import net.neoforged.neoforge.client.network.ClientPacketDistributor;

/**
 * The Susanoo's hands (core/Susanoo): attacking swings its arm as well, from the Skeleton stage up; using an empty hand fires its
 * weapon, from the Humanoid stage up (the use is kept from doing anything else).
 */
@EventBusSubscriber(modid = "naruto_shippuden", value = Dist.CLIENT)
public final class SusanooClient {
	private SusanooClient() {
	}

	@SubscribeEvent
	public static void click(InputEvent.InteractionKeyMappingTriggered event) {
		var player = Minecraft.getInstance().player;
		if (player == null)
			return;
		int stage = Susanoo.stage(player);
		if (event.isAttack() && stage >= 2)
			ClientPacketDistributor.sendToServer(new NarutoActions.Action("susanoo", "strike", 0));
		else if (event.isUseItem() && stage >= 3 && player.getMainHandItem().isEmpty() && player.getOffhandItem().isEmpty()) {
			ClientPacketDistributor.sendToServer(new NarutoActions.Action("susanoo", "special", 0));
			event.setSwingHand(false);
			event.setCanceled(true);
		}
	}
}
