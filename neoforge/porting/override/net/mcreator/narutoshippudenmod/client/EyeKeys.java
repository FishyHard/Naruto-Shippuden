package net.mcreator.narutoshippudenmod.client;

import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables;
import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables.PlayerVariables;
import net.mcreator.narutoshippudenmod.core.ChakraControl;
import net.mcreator.narutoshippudenmod.core.Eyes;
import net.mcreator.narutoshippudenmod.core.Eyes.Eye;
import net.mcreator.narutoshippudenmod.core.NarutoActions;

import com.mojang.blaze3d.platform.InputConstants;

import net.minecraft.ChatFormatting;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.input.KeyEvent;
import net.minecraft.client.input.MouseButtonEvent;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Mth;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.neoforged.neoforge.client.network.ClientPacketDistributor;

import java.util.List;

/**
 * The Dojutsu key (tap: open, step up to the Mangekyou or close; sneak + tap: close all; hold: choose an eye on a wheel), the
 * Susanoo key (hold: build it up a stage at a time; tap: dismiss), Chakra Control (on and off) and Dash (a Body Flicker the way
 * the player is walking; see core/ChakraControl). All the mod's keys sit in their own Controls section.
 */
@EventBusSubscriber(modid = "naruto_shippuden", value = Dist.CLIENT)
public final class EyeKeys {
	public static final KeyMapping.Category CATEGORY = new KeyMapping.Category(Identifier.fromNamespaceAndPath("naruto_shippuden", "keys"));
	public static final KeyMapping DOJUTSU = new KeyMapping("key.naruto_shippuden.dojutsu", InputConstants.KEY_V, CATEGORY);
	public static final KeyMapping SUSANOO = new KeyMapping("key.naruto_shippuden.susanoo", InputConstants.KEY_B, CATEGORY);
	public static final KeyMapping CHAKRA_CONTROL = new KeyMapping("key.naruto_shippuden.chakra_control", InputConstants.KEY_G, CATEGORY);
	public static final KeyMapping DASH = new KeyMapping("key.naruto_shippuden.dash", InputConstants.KEY_LALT, CATEGORY);
	/** Ticks held before a press counts as a hold. */
	private static final int HOLD = 7;
	private static int dojutsuHeld, susanooHeld;

	private EyeKeys() {
	}

	@SubscribeEvent
	public static void registerKeys(RegisterKeyMappingsEvent event) {
		event.registerCategory(CATEGORY);
		event.register(DOJUTSU);
		event.register(SUSANOO);
		event.register(CHAKRA_CONTROL);
		event.register(DASH);
	}

	private static void send(String kind, String key, double amount) {
		ClientPacketDistributor.sendToServer(new NarutoActions.Action(kind, key, amount));
	}

	@SubscribeEvent
	public static void tick(ClientTickEvent.Post event) {
		Minecraft minecraft = Minecraft.getInstance();
		while (DOJUTSU.consumeClick() || SUSANOO.consumeClick()) {
			// presses are read from isDown below
		}
		if (minecraft.player == null || minecraft.gui.screen() != null) {
			dojutsuHeld = susanooHeld = 0;
			while (CHAKRA_CONTROL.consumeClick() || DASH.consumeClick()) {
			}
			return;
		}
		while (CHAKRA_CONTROL.consumeClick())
			send("chakra", "toggle", 0);
		while (DASH.consumeClick()) {
			var options = minecraft.options;
			int keys = (options.keyUp.isDown() ? ChakraControl.FORWARD : 0) | (options.keyDown.isDown() ? ChakraControl.BACK : 0)
					| (options.keyLeft.isDown() ? ChakraControl.LEFT : 0) | (options.keyRight.isDown() ? ChakraControl.RIGHT : 0)
					| (options.keyJump.isDown() ? ChakraControl.UP : 0);
			send("chakra", "dash", keys);
		}
		PlayerVariables variables = NarutoShippudenModVariables.get(minecraft.player);

		if (DOJUTSU.isDown()) {
			dojutsuHeld++;
			if (dojutsuHeld == HOLD && Eyes.owned(variables).size() >= 2) {
				dojutsuHeld = 0;
				minecraft.gui.setScreen(new EyeWheel(Eyes.owned(variables)));
			}
		} else if (dojutsuHeld > 0) {
			send("eye", "tap", minecraft.player.isShiftKeyDown() ? 1 : 0);
			dojutsuHeld = 0;
		}

		if (SUSANOO.isDown()) {
			susanooHeld++;
			if (susanooHeld >= HOLD && (susanooHeld - HOLD) % 14 == 0)
				send("susanoo", "grow", 0);
		} else if (susanooHeld > 0) {
			if (susanooHeld < HOLD)
				send("susanoo", variables.mangekyousharingansusanostage > 0 ? "dismiss" : "grow", 0);
			susanooHeld = 0;
		}
	}

	/** Hold the key, point at an eye, let go (or click). */
	static class EyeWheel extends Screen {
		private final List<Eye> eyes;
		private int hovered = -1;

		EyeWheel(List<Eye> eyes) {
			super(Component.literal("Dojutsu"));
			this.eyes = eyes;
		}

		@Override
		public boolean isPauseScreen() {
			return false;
		}

		@Override
		public void extractBackground(GuiGraphicsExtractor graphics, int mouseX, int mouseY, float a) {
			graphics.fillGradient(0, 0, width, height, 0x60000000, 0x80000000);
		}

		@Override
		public void extractRenderState(GuiGraphicsExtractor graphics, int mouseX, int mouseY, float a) {
			super.extractRenderState(graphics, mouseX, mouseY, a);
			PlayerVariables variables = NarutoShippudenModVariables.get(minecraft.player);
			int w = 0;
			for (Eye eye : eyes)
				w = Math.max(w, font.width(eye.name()) + 12);
			w = Mth.clamp(w, 80, 150);
			WheelLayout layout = WheelLayout.of(eyes.size(), w);
			hovered = layout.hovered(mouseX, mouseY, width, height);
			for (int i = 0; i < eyes.size(); i++) {
				Eye eye = eyes.get(i);
				int x = layout.x(i, width), y = layout.y(i, height);
				graphics.blitSprite(RenderPipelines.GUI_TEXTURED, i == hovered ? JutsuClient.PANEL : JutsuClient.INSET, x, y, w, 20);
				boolean open = eye.active().test(variables);
				int color = i == hovered ? JutsuClient.TEXT : open ? 0xFFFFFF55 : 0xFFFFFFFF;
				graphics.text(font, eye.name(), x + w / 2 - font.width(eye.name()) / 2, y + 6, color, i != hovered);
			}
			int bottom = layout.bottom(height);
			graphics.centeredText(font, Component.literal(hovered >= 0 ? eyes.get(hovered).name() : "Choose a dojutsu").withStyle(ChatFormatting.YELLOW),
					width / 2, bottom, -1);
			graphics.centeredText(font, "Tap to open or close, sneak and tap to close all", width / 2, bottom + 12, 0xFFE0E0E0);
		}

		private void choose() {
			if (hovered >= 0)
				send("eye", eyes.get(hovered).id(), 0);
			onClose();
		}

		@Override
		public boolean keyReleased(KeyEvent event) {
			if (DOJUTSU.matches(event)) {
				choose();
				return true;
			}
			return super.keyReleased(event);
		}

		@Override
		public boolean mouseClicked(MouseButtonEvent event, boolean doubleClick) {
			choose();
			return true;
		}
	}
}
