package net.mcreator.narutoshippudenmod.procedures;

import net.minecraftforge.fml.loading.FMLPaths;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.Map;
import java.util.Collections;

import java.io.IOException;
import java.io.FileWriter;
import java.io.File;

import com.google.gson.GsonBuilder;
import com.google.gson.Gson;

public class NarutoshippudenconfigProcedure {
	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void init(FMLCommonSetupEvent event) {
			executeProcedure(Collections.emptyMap());
		}
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		com.google.gson.JsonObject mainjsonobject = new com.google.gson.JsonObject();
		File NarutoShippuden = new File("");
		File PlayerSkin = new File("");
		String PlayerName = "";
		NarutoShippuden = (File) new File((FMLPaths.GAMEDIR.get().toString() + "/config/narutoshippuden"),
				File.separator + "narutoshippudenconfig.json");
		if (!NarutoShippuden.exists()) {
			try {
				NarutoShippuden.getParentFile().mkdirs();
				NarutoShippuden.createNewFile();
			} catch (IOException exception) {
				exception.printStackTrace();
			}
			mainjsonobject.addProperty("clan_random", (false));
			mainjsonobject.addProperty("gifts", (true));
			mainjsonobject.addProperty("patreon_kits", (true));
			mainjsonobject.addProperty("sharingan_awake", 1800);
			mainjsonobject.addProperty("mangekyou_sharingan_awake", 5400);
			mainjsonobject.addProperty("byakugan_awake", 2400);
			mainjsonobject.addProperty("ketsuryugan_awake", 2000);
			mainjsonobject.addProperty("tenseigan_awake", 7200);
			mainjsonobject.addProperty("rinnegan_awake", 10800);
			mainjsonobject.addProperty("isshiki_dojutsu_awake", 9000);
			mainjsonobject.addProperty("dna_kekkei_genkai_identify", 0.1);
			mainjsonobject.addProperty("dna_drop", 1);
			mainjsonobject.addProperty("kekkei_genkai_spawn_chance", 1);
			{
				Gson mainGSONBuilderVariable = new GsonBuilder().setPrettyPrinting().create();
				try {
					FileWriter fileWriter = new FileWriter(NarutoShippuden);
					fileWriter.write(mainGSONBuilderVariable.toJson(mainjsonobject));
					fileWriter.close();
				} catch (IOException exception) {
					exception.printStackTrace();
				}
			}
		}
	}
}
