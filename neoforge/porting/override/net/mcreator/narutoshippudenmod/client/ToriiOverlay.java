package net.mcreator.narutoshippudenmod.client;

import net.mcreator.narutoshippudenmod.world.chikyu.ChikyuContent;

import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.util.ARGB;
import net.minecraft.util.Mth;
import net.minecraft.world.level.block.Portal;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterGuiLayersEvent;
import net.neoforged.neoforge.client.gui.VanillaGuiLayers;

/**
 * Standing in a torii swirls the screen as vanilla's nether portal does (vanilla does the swirl, the sound and the
 * timing), but vanilla's overlay is always the nether portal's purple: while the torii's swirl is on, it is drawn
 * with the torii's own green light instead.
 */
@EventBusSubscriber(modid = "naruto_shippuden", value = Dist.CLIENT)
public final class ToriiOverlay {
	/** Whether the swirl now on screen (or fading off it) came from a torii. */
	private static boolean fromTorii;

	private ToriiOverlay() {
	}

	@SubscribeEvent
	public static void register(RegisterGuiLayersEvent event) {
		event.wrapLayer(VanillaGuiLayers.CAMERA_OVERLAYS, layer -> (graphics, delta) -> {
			LocalPlayer player = Minecraft.getInstance().player;
			if (player == null || ChikyuContent.TORII_PORTAL == null) {
				layer.render(graphics, delta);
				return;
			}
			if (player.portalProcess != null)
				fromTorii = player.portalProcess.isSamePortal((Portal) ChikyuContent.TORII_PORTAL);
			float o = player.oPortalEffectIntensity, n = player.portalEffectIntensity;
			if (!fromTorii || o <= 0 && n <= 0) {
				layer.render(graphics, delta);
				return;
			}
			// vanilla's camera overlays without its purple portal, then the green one, as vanilla draws its own
			player.oPortalEffectIntensity = 0;
			player.portalEffectIntensity = 0;
			try {
				layer.render(graphics, delta);
			} finally {
				player.oPortalEffectIntensity = o;
				player.portalEffectIntensity = n;
			}
			float alpha = Mth.lerp(delta.getGameTimeDeltaPartialTick(false), o, n);
			if (alpha < 1.0F) {
				alpha *= alpha;
				alpha *= alpha;
				alpha = alpha * 0.8F + 0.2F;
			}
			TextureAtlasSprite sprite = Minecraft.getInstance().getModelManager().getBlockStateModelSet()
					.getParticleMaterial(ChikyuContent.TORII_PORTAL.defaultBlockState()).sprite();
			graphics.blitSprite(RenderPipelines.GUI_TEXTURED, sprite, 0, 0, graphics.guiWidth(), graphics.guiHeight(), ARGB.white(alpha));
		});
	}
}
