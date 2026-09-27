package net.mcreator.narutoshippudenmod;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RenderGuiLayerEvent;
import net.neoforged.neoforge.client.gui.VanillaGuiLayers;

/** Hides the vanilla hearts; the mod draws its own health numbers in the chakra bar overlay. */
@EventBusSubscriber(modid = NarutoShippudenMod.MODID, value = Dist.CLIENT)
public final class OverlayEventHandler {
	private OverlayEventHandler() {
	}

	@SubscribeEvent
	public static void hideVanillaHealth(RenderGuiLayerEvent.Pre event) {
		if (event.getName().equals(VanillaGuiLayers.PLAYER_HEALTH))
			event.setCanceled(true);
	}
}
