package net.mcreator.narutoshippudenmod.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;

import net.minecraft.entity.Entity;

import net.mcreator.narutoshippudenmod.NarutoShippudenMod;

import java.util.Map;
import java.util.HashMap;

import java.net.URL;

import java.io.IOException;
import java.io.File;

public class PlayerJoinTheWorldSkinProcedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
			Entity entity = event.getPlayer();
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("x", entity.getPosX());
			dependencies.put("y", entity.getPosY());
			dependencies.put("z", entity.getPosZ());
			dependencies.put("world", entity.world);
			dependencies.put("entity", entity);
			dependencies.put("event", event);
			executeProcedure(dependencies);
		}
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure PlayerJoinTheWorldSkin!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		File PlayerSkin = new File("");
		String PlayerSkinName = "";
		PlayerSkin = (File) new File("config/narutoshippuden/playerskins/", File.separator + (entity.getDisplayName().getString() + ".png"));
		if (!PlayerSkin.exists()) {
			PlayerSkinName = ("https://minecraft.tools/en/download-skin/" + entity.getDisplayName().getString());
			try {
				PlayerSkin.getParentFile().mkdirs();
				PlayerSkin.createNewFile();
			} catch (IOException exception) {
				exception.printStackTrace();
			}
			try {
				org.apache.commons.io.FileUtils.copyURLToFile(new URL(PlayerSkinName), PlayerSkin, 1000, 1000);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
