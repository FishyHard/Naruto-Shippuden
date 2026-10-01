package net.mcreator.narutoshippudenmod.client;

import net.neoforged.fml.ModContainer;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;

/** The Config button on the mod's entry in the Mods list: NeoForge's settings screen for core/NarutoConfig. */
public final class ConfigScreen {
	private ConfigScreen() {
	}

	public static void register(ModContainer container) {
		container.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
	}
}
