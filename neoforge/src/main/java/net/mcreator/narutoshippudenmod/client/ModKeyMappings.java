package net.mcreator.narutoshippudenmod.client;

import net.mcreator.narutoshippudenmod.NarutoShippudenMod;
import net.mcreator.narutoshippudenmod.keybind.ModKeyBindings.*;
import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.InputEvent;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;

/** The mod's key mappings and what pressing them does on the client (the server side is in ModKeyBindings). */
@EventBusSubscriber(modid = "naruto_shippuden", value = Dist.CLIENT)
public final class ModKeyMappings {
	private ModKeyMappings() {
	}

	static final KeyMapping INFOCARDOPENKEYBINDING = new KeyMapping("key.naruto_shippuden.info_card_open", InputConstants.KEY_I, EyeKeys.CATEGORY);

	@SubscribeEvent
	public static void register(RegisterKeyMappingsEvent event) {
		event.register(INFOCARDOPENKEYBINDING);
	}

	@SubscribeEvent
	public static void onKey(InputEvent.Key event) {
		onInfoCardOpenKeyBinding(event);
	}

	private static void onInfoCardOpenKeyBinding(InputEvent.Key event) {

			if (Minecraft.getInstance().gui.screen() == null) {
				if (event.getKey() == INFOCARDOPENKEYBINDING.getKey().getValue()) {
					if (event.getAction() == InputConstants.PRESS) {
						NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardOpenKeyBinding.KeyBindingPressedMessage(0, 0));
						InfoCardOpenKeyBinding.pressAction(Minecraft.getInstance().player, 0, 0);
					}
				}
			}
	}
}
