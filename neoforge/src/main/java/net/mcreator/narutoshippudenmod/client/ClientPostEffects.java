package net.mcreator.narutoshippudenmod.client;

import net.minecraft.client.Minecraft;
import net.minecraft.resources.Identifier;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ViewportEvent;

/**
 * Full-screen post effects the mod turns on (genjutsu, sharingan views). 26.3 rebuilds the list of post effects every
 * frame, so the active one is added back while the camera is set up.
 */
@EventBusSubscriber(modid = "naruto_shippuden", value = Dist.CLIENT)
public final class ClientPostEffects {
	private static Identifier active;

	private ClientPostEffects() {
	}

	/** Accepts the 1.16 form ("ns:shaders/post/name.json") or a post effect id. */
	public static void set(Identifier effect) {
		String path = effect.getPath();
		if (path.startsWith("shaders/post/"))
			path = path.substring("shaders/post/".length());
		if (path.endsWith(".json"))
			path = path.substring(0, path.length() - 5);
		active = Identifier.fromNamespaceAndPath(effect.getNamespace(), path);
	}

	public static void clear() {
		active = null;
	}

	public static Identifier current() {
		return active;
	}

	@SubscribeEvent
	public static void addActiveEffect(ViewportEvent.ComputeCameraAngles event) {
		if (active != null && !Minecraft.getInstance().gameRenderer.getRequestedPostEffects().contains(active))
			Minecraft.getInstance().gameRenderer.getRequestedPostEffects().add(active);
	}
}
