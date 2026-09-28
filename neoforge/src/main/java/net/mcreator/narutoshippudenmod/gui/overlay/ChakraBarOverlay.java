package net.mcreator.narutoshippudenmod.gui.overlay;

import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables;
import net.mcreator.narutoshippudenmod.core.jutsu.Jutsus;
import net.mcreator.narutoshippudenmod.gui.ModScreen;

import net.minecraft.client.DeltaTracker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.resources.Identifier;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterGuiLayersEvent;

/**
 * Chakra and health bars in the vanilla boss bar style, right of the hotbar like the attack indicator (1.16 drew two
 * vertical bars on the right edge of the screen).
 */
@EventBusSubscriber(modid = "naruto_shippuden", value = Dist.CLIENT)
public class ChakraBarOverlay {
	private static final Identifier CHAKRA_BACKGROUND = Identifier.withDefaultNamespace("boss_bar/blue_background");
	private static final Identifier CHAKRA_PROGRESS = Identifier.withDefaultNamespace("boss_bar/blue_progress");
	private static final Identifier HEALTH_BACKGROUND = Identifier.withDefaultNamespace("boss_bar/red_background");
	private static final Identifier HEALTH_PROGRESS = Identifier.withDefaultNamespace("boss_bar/red_progress");
	private static final int BAR_WIDTH = 60;

	public static void render(GuiGraphicsExtractor graphics, DeltaTracker deltaTracker) {
		Minecraft minecraft = Minecraft.getInstance();
		Player player = minecraft.player;
		if (player == null || player.isSpectator())
			return;
		NarutoShippudenModVariables.PlayerVariables vars = NarutoShippudenModVariables.get(player);
		Font font = minecraft.font;
		int width = graphics.guiWidth(), height = graphics.guiHeight();
		String chakra = (int) vars.ChakraAmount + "/" + (int) vars.ChakraMax;
		String health = (int) vars.Health + "/" + (int) vars.HealthMax;
		int textWidth = Math.max(font.width(chakra), font.width(health));
		// right of the hotbar (and its attack indicator); on narrow screens, against the right edge
		int left = Math.min(width / 2 + 91 + 28, width - BAR_WIDTH - textWidth - 6);
		row(graphics, font, left, height - 19, vars.ChakraAmount, vars.ChakraMax, chakra, CHAKRA_BACKGROUND, CHAKRA_PROGRESS, 0xFF55C8FF);
		row(graphics, font, left, height - 9, vars.Health, vars.HealthMax, health, HEALTH_BACKGROUND, HEALTH_PROGRESS, 0xFFFF5555);
		// the jutsu the held technique item will cast
		for (InteractionHand hand : InteractionHand.values()) {
			Jutsus.Technique technique = Jutsus.technique(player.getItemInHand(hand));
			if (technique != null) {
				Jutsus.Jutsu jutsu = technique.selected(vars);
				graphics.text(font, font.plainSubstrByWidth(jutsu.name(), width - left - 4), left, height - 31,
						jutsu.isLearned(vars) ? 0xFFFFFF55 : 0xFFAAAAAA, true);
				break;
			}
		}
	}

	private static void row(GuiGraphicsExtractor graphics, Font font, int left, int top, double value, double max, String text, Identifier background,
			Identifier progress, int color) {
		ModScreen.bar(graphics, background, progress, left, top, BAR_WIDTH, max <= 0 ? 0 : (float) (value / max));
		graphics.text(font, text, left + BAR_WIDTH + 4, top - 2, color, true);
	}

	@SubscribeEvent
	public static void register(RegisterGuiLayersEvent event) {
		event.registerAboveAll(Identifier.fromNamespaceAndPath("naruto_shippuden", "chakra_bar"), ChakraBarOverlay::render);
	}
}
