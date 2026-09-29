package net.mcreator.narutoshippudenmod.gui;

import net.mcreator.narutoshippudenmod.NarutoShippudenMod;
import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables.PlayerVariables;
import net.mcreator.narutoshippudenmod.gui.InfoCardGuis.InfoCardDojutsuGui;
import net.mcreator.narutoshippudenmod.gui.InfoCardGuis.InfoCardGui;
import net.mcreator.narutoshippudenmod.gui.InfoCardGuis.InfoCardMiniGameGui;
import net.mcreator.narutoshippudenmod.gui.InfoCardGuis.InfoCardMissionsGui;
import net.mcreator.narutoshippudenmod.gui.InfoCardGuis.InfoCardUpgradeGui;
import net.mcreator.narutoshippudenmod.gui.InfoCardGuis.StatSelectGui;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures;

import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.Tooltip;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.function.ToDoubleFunction;

/** The info card and its pages, laid out like vanilla containers (see {@link ModScreen}). */
public final class InfoCardScreens {
	private InfoCardScreens() {
	}

	// ------------------------------------------------------------------ icon tables (procedure, texture, name)
	static final class Icons {
		static ModScreen.Icon icon(Predicate<Map<String, Object>> shown, String texture, String name) {
			return new ModScreen.Icon(shown, texture, name);
		}

		static final ModScreen.Icon[] CLANS = {
				icon(GuiDisplayProcedures.DisplayAburameInfoProcedure::executeProcedure, "aburame", "Aburame"),
				icon(GuiDisplayProcedures.DisplayAkimichiInfoProcedure::executeProcedure, "akimichi", "Akimichi"),
				icon(GuiDisplayProcedures.DisplayChinoikeInfoProcedure::executeProcedure, "chinoike", "Chinoike"),
				icon(GuiDisplayProcedures.DisplayHyugaInfoProcedure::executeProcedure, "hyuga", "Hyuga"),
				icon(GuiDisplayProcedures.DisplayIburiInfoProcedure::executeProcedure, "iburi", "Iburi"),
				icon(GuiDisplayProcedures.DisplayInuzukaInfoProcedure::executeProcedure, "inuzuka", "Inuzuka"),
				icon(GuiDisplayProcedures.DisplayLeeInfoProcedure::executeProcedure, "lee", "Lee"),
				icon(GuiDisplayProcedures.DisplayNaraInfoProcedure::executeProcedure, "nara", "Nara"),
				icon(GuiDisplayProcedures.DisplayTsuchigumoInfoProcedure::executeProcedure, "tsuchigumo", "Tsuchigumo"),
				icon(GuiDisplayProcedures.DisplayUchihaInfoProcedure::executeProcedure, "uchiha", "Uchiha"),
				icon(GuiDisplayProcedures.DisplayUzumakiInfoProcedure::executeProcedure, "uzumaki", "Uzumaki"),
				icon(GuiDisplayProcedures.DisplayFumaInfoProcedure::executeProcedure, "fuuma", "Fuma"),
				icon(GuiDisplayProcedures.DisplayHozukiInfoProcedure::executeProcedure, "hozuki", "Hozuki"),
				icon(GuiDisplayProcedures.DisplaySarutobiInfoProcedure::executeProcedure, "sarutobi", "Sarutobi")};
		static final ModScreen.Icon[] NATURES = {
				icon(GuiDisplayProcedures.DisplayFireInfoProcedure::executeProcedure, "fire_release_info", "Fire Release"),
				icon(GuiDisplayProcedures.DisplayLightningInfoProcedure::executeProcedure, "lightning_release_info", "Lightning Release"),
				icon(GuiDisplayProcedures.DisplayWindInfoProcedure::executeProcedure, "wind_release_info", "Wind Release"),
				icon(GuiDisplayProcedures.DisplayWaterInfoProcedure::executeProcedure, "water_release_info", "Water Release"),
				icon(GuiDisplayProcedures.DisplayEarthInfoProcedure::executeProcedure, "earth_release_info", "Earth Release")};
		static final ModScreen.Icon[] ABILITIES = {
				icon(GuiDisplayProcedures.DisplayIceInfoProcedure::executeProcedure, "ice_release", "Ice Release"),
				icon(GuiDisplayProcedures.DisplayWoodInfoProcedure::executeProcedure, "wood_release", "Wood Release"),
				icon(GuiDisplayProcedures.DisplayMagnetInfoProcedure::executeProcedure, "magnet_release", "Magnet Release"),
				icon(GuiDisplayProcedures.DisplayStormInfoProcedure::executeProcedure, "storm_release", "Storm Release"),
				icon(GuiDisplayProcedures.DisplaySmokeInfoProcedure::executeProcedure, "smoke_release", "Smoke Release"),
				icon(GuiDisplayProcedures.DisplaySteelInfoProcedure::executeProcedure, "steel_release", "Steel Release"),
				icon(GuiDisplayProcedures.DisplayBoilInfoProcedure::executeProcedure, "boil_release", "Boil Release"),
				icon(GuiDisplayProcedures.DisplayBoneInfoProcedure::executeProcedure, "bone_release", "Bone Release"),
				icon(GuiDisplayProcedures.DisplaySwiftInfoProcedure::executeProcedure, "swift_release", "Swift Release"),
				icon(GuiDisplayProcedures.DisplayTyphoonInfoProcedure::executeProcedure, "typhoon_release", "Typhoon Release"),
				icon(GuiDisplayProcedures.DisplayDustInfoProcedure::executeProcedure, "dust_release", "Dust Release"),
				icon(GuiDisplayProcedures.DisplaySharinganInfoProcedure::executeProcedure, "sharingan", "Sharingan"),
				icon(GuiDisplayProcedures.DisplayByakuganInfoProcedure::executeProcedure, "byakugan", "Byakugan"),
				icon(GuiDisplayProcedures.DisplayKetsuryuganInfoProcedure::executeProcedure, "ketsuryugan", "Ketsuryugan"),
				icon(GuiDisplayProcedures.DisplayMSItachiInfoProcedure::executeProcedure, "mangekyou_sharingan_itachi", "Mangekyou Sharingan (Itachi)"),
				icon(GuiDisplayProcedures.DisplayMSMadaraInfoProcedure::executeProcedure, "mangekyou_sharingan_madara", "Mangekyou Sharingan (Madara)"),
				icon(GuiDisplayProcedures.DisplayMSObitoInfoProcedure::executeProcedure, "mangekyou_sharingan_obito", "Mangekyou Sharingan (Obito)"),
				icon(GuiDisplayProcedures.DisplayMSSasukeInfoProcedure::executeProcedure, "mangekyou_sharingan_sasuke", "Mangekyou Sharingan (Sasuke)"),
				icon(GuiDisplayProcedures.DisplayMSShisuiInfoProcedure::executeProcedure, "mangekyou_sharingan_shisui", "Mangekyou Sharingan (Shisui)"),
				icon(GuiDisplayProcedures.DisplayTenseiganInfoProcedure::executeProcedure, "tenseigan", "Tenseigan"),
				icon(GuiDisplayProcedures.DisplayRinneganInfoProcedure::executeProcedure, "rinnegan", "Rinnegan"),
				icon(GuiDisplayProcedures.DisplayIsshikiDojutsuInfoProcedure::executeProcedure, "isshiki_dojutsu", "Kokugan")};
		static final ModScreen.Icon[] SELECT_CLANS = {
				icon(GuiDisplayProcedures.DisplayUchihaSelectProcedure::executeProcedure, "uchiha", "Uchiha"),
				icon(GuiDisplayProcedures.DisplayUzumakiSelectProcedure::executeProcedure, "uzumaki", "Uzumaki"),
				icon(GuiDisplayProcedures.DisplayHyugaSelectProcedure::executeProcedure, "hyuga", "Hyuga"),
				icon(GuiDisplayProcedures.DisplayIburiSelectProcedure::executeProcedure, "iburi", "Iburi"),
				icon(GuiDisplayProcedures.DisplayAburameSelectProcedure::executeProcedure, "aburame", "Aburame"),
				icon(GuiDisplayProcedures.DisplayAkimichiSelectProcedure::executeProcedure, "akimichi", "Akimichi"),
				icon(GuiDisplayProcedures.DisplayChinoikeSelectProcedure::executeProcedure, "chinoike", "Chinoike"),
				icon(GuiDisplayProcedures.DisplayInuzukaSelectProcedure::executeProcedure, "inuzuka", "Inuzuka"),
				icon(GuiDisplayProcedures.DisplayLeeSelectProcedure::executeProcedure, "lee", "Lee"),
				icon(GuiDisplayProcedures.DisplayNaraSelectProcedure::executeProcedure, "nara", "Nara"),
				icon(GuiDisplayProcedures.DisplayTsuchigumoSelectProcedure::executeProcedure, "tsuchigumo", "Tsuchigumo"),
				icon(GuiDisplayProcedures.DiplaySarutobiSelectProcedure::executeProcedure, "sarutobi", "Sarutobi"),
				icon(GuiDisplayProcedures.DiplayFumaSelectProcedure::executeProcedure, "fuuma", "Fuma"),
				icon(GuiDisplayProcedures.DiplayHozukiSelectProcedure::executeProcedure, "hozuki", "Hozuki")};
		static final ModScreen.Icon[] SELECT_VILLAGES = {
				icon(GuiDisplayProcedures.DisplayKonohaSelectProcedure::executeProcedure, "konohagakure", "Konohagakure"),
				icon(GuiDisplayProcedures.DisplayMistSelectProcedure::executeProcedure, "kirigakure", "Kirigakure"),
				icon(GuiDisplayProcedures.DisplayStoneSelectProcedure::executeProcedure, "iwagakure", "Iwagakure"),
				icon(GuiDisplayProcedures.DisplayCloudSelectProcedure::executeProcedure, "kumogakure", "Kumogakure"),
				icon(GuiDisplayProcedures.DisplaySandSelectProcedure::executeProcedure, "sunagakure", "Sunagakure")};
		static final ModScreen.Icon[] SELECT_NATURES = {
				icon(GuiDisplayProcedures.DisplayFireSelectProcedure::executeProcedure, "fire_release", "Fire Release"),
				icon(GuiDisplayProcedures.DisplayEarthSelectProcedure::executeProcedure, "earth_release", "Earth Release"),
				icon(GuiDisplayProcedures.DisplayLightningSelectProcedure::executeProcedure, "lightning_release", "Lightning Release"),
				icon(GuiDisplayProcedures.DisplayWaterSelectProcedure::executeProcedure, "water_release", "Water Release"),
				icon(GuiDisplayProcedures.DisplayWindSelectProcedure::executeProcedure, "wind_release", "Wind Release")};
	}

	/** One dojutsu preview layer: drawn at the eye position plus (dx, dy). */
	record Eye(Predicate<Map<String, Object>> shown, String texture, int dx, int dy, int width, int height) {
	}

	static final Eye[] EYES = {
			new Eye(GuiDisplayProcedures.DisplaySharingan2x1Pupils2x1Procedure::executeProcedure, "sharingan2px1px2gui", 0, 0, 96, 16),
			new Eye(GuiDisplayProcedures.DisplaySharingan2x2Pupils2x1Procedure::executeProcedure, "sharingan2px2px1gui", 0, 0, 96, 32),
			new Eye(GuiDisplayProcedures.DisplaySharingan2x2Pupils1x1Procedure::executeProcedure, "sharingan2px2px2gui", 0, 0, 96, 32),
			new Eye(GuiDisplayProcedures.DisplaySharingan2x1Pupils1x1Procedure::executeProcedure, "sharingan2px1pxgui", 0, 0, 96, 16),
			new Eye(GuiDisplayProcedures.DisplayByakugan2x2Pupils2x1Procedure::executeProcedure, "byakugan_2x2_pupils_1x2_gui", 0, 0, 96, 32),
			new Eye(GuiDisplayProcedures.DisplayByakugan2x2Pupils1x1Procedure::executeProcedure, "byakugan_2x2_pupils_1x1_gui", 0, 0, 96, 32),
			new Eye(GuiDisplayProcedures.DisplayByakugan2x1Pupils1x1Procedure::executeProcedure, "byakugan_2x1_pupils_1x1_gui", 0, 0, 96, 16),
			new Eye(GuiDisplayProcedures.DisplayByakugan2x1Pupils2x1Procedure::executeProcedure, "byakugan_2x1_pupils_2x1_gui", 0, 0, 96, 16),
			new Eye(GuiDisplayProcedures.DisplayByakuganActivated2x1Procedure::executeProcedure, "byakugan_activated_gui", -14, -9, 125, 52),
			new Eye(GuiDisplayProcedures.DisplayByakuganActivated2x2Procedure::executeProcedure, "byakugan_activated_gui", -14, 6, 125, 52),
			new Eye(GuiDisplayProcedures.DisplayKetsuryugan2x1Pupils1x1Procedure::executeProcedure, "ketsuryugan_2x1_pupils_1x1_gui", 0, 0, 96, 16),
			new Eye(GuiDisplayProcedures.DisplayKetsuryugan2x1Pupils2x1Procedure::executeProcedure, "ketsuryugan_2x1_pupils_2x1_gui", 0, 0, 96, 16),
			new Eye(GuiDisplayProcedures.DisplayKetsuryugan2x2Pupils1x1Procedure::executeProcedure, "ketsuryugan_2x2_pupils_1x1_gui", 0, 0, 96, 32),
			new Eye(GuiDisplayProcedures.DisplayKetsuryugan2x2Pupils2x1Procedure::executeProcedure, "ketsuryugan_2x2_pupils_1x2_gui", 0, 0, 96, 32),
			new Eye(GuiDisplayProcedures.DisplayIsshikiDojutsu2x1Pupils1x1Procedure::executeProcedure, "isshiki_dojutsu_2x1_pupils_1x1_gui", 0, 0, 96, 16),
			new Eye(GuiDisplayProcedures.DisplayIsshikiDojutsu2x1Pupils2x1Procedure::executeProcedure, "isshiki_dojutsu_2x1_pupils_2x1_gui", 0, 0, 96, 16),
			new Eye(GuiDisplayProcedures.DisplayIsshikiDojutsu2x2Pupils1x1Procedure::executeProcedure, "isshiki_dojutsu_2x2_pupils_1x1_gui", 0, 0, 96, 32),
			new Eye(GuiDisplayProcedures.DisplayIsshikiDojutsu2x2Pupils2x1Procedure::executeProcedure, "isshiki_dojutsu_2x2_pupils_1x2_gui", 0, 0, 96, 32),
			new Eye(GuiDisplayProcedures.DisplaySasukeDojutsu2x2Pupils1x1Procedure::executeProcedure, "sasukemangekyo2px2px2gui", 0, 0, 96, 32),
			new Eye(GuiDisplayProcedures.DisplaySasukeDojutsu2x2Pupils2x1Procedure::executeProcedure, "sasukemangekyo2px2px1gui", 0, 0, 96, 32),
			new Eye(GuiDisplayProcedures.DisplaySasukeDojutsu2x1Pupils2x1Procedure::executeProcedure, "sasukemangekyo2px1px2gui", 0, 0, 96, 16),
			new Eye(GuiDisplayProcedures.DisplaySasukeDojutsu2x1Pupils1x1Procedure::executeProcedure, "sasukemangekyo2px1pxgui", 0, 0, 96, 16),
			new Eye(GuiDisplayProcedures.DisplayItachiDojutsu2x1Pupils1x1Procedure::executeProcedure, "itachimangekyo2px1pxgui", 0, 0, 96, 16),
			new Eye(GuiDisplayProcedures.DisplayItachiDojutsu2x1Pupils2x1Procedure::executeProcedure, "itachimangekyo2px1px2gui", 0, 0, 96, 16),
			new Eye(GuiDisplayProcedures.DisplayItachiDojutsu2x2Pupils2x1Procedure::executeProcedure, "itachimangekyo2px2px1gui", 0, 0, 96, 32),
			new Eye(GuiDisplayProcedures.DisplayItachiDojutsu2x2Pupils1x1Procedure::executeProcedure, "itachimangekyo2px2px2gui", 0, 0, 96, 32),
			new Eye(GuiDisplayProcedures.DisplayMadaraDojutsu2x1Pupils1x1Procedure::executeProcedure, "madaramangekyo2px1pxgui", 0, 0, 96, 16),
			new Eye(GuiDisplayProcedures.DisplayMadaraDojutsu2x1Pupils2x1Procedure::executeProcedure, "madaramangekyo2px1px2gui", 0, 0, 96, 16),
			new Eye(GuiDisplayProcedures.DisplayMadaraDojutsu2x2Pupils1x1Procedure::executeProcedure, "madaramangekyo2px2px2gui", 0, 0, 96, 32),
			new Eye(GuiDisplayProcedures.DisplayMadaraDojutsu2x2Pupils2x1Procedure::executeProcedure, "madaramangekyo2px2px1gui", 0, 0, 96, 32),
			new Eye(GuiDisplayProcedures.DisplayObitoDojutsu2x1Pupils1x1Procedure::executeProcedure, "obitomangekyo2px1pxgui", 0, 0, 96, 16),
			new Eye(GuiDisplayProcedures.DisplayObitoDojutsu2x1Pupils2x1Procedure::executeProcedure, "obitomangekyo2px1px2gui", 0, 0, 96, 16),
			new Eye(GuiDisplayProcedures.DisplayObitoDojutsu2x2Pupils1x1Procedure::executeProcedure, "obitomangekyo2px2px2gui", 0, 0, 96, 32),
			new Eye(GuiDisplayProcedures.DisplayObitoDojutsu2x2Pupils2x1Procedure::executeProcedure, "obitomangekyo2px2px1gui", 0, 0, 96, 32),
			new Eye(GuiDisplayProcedures.DisplayShisuiDojutsu2x1Pupils1x1Procedure::executeProcedure, "shisuimangekyo2px1pxgui", 0, 0, 96, 16),
			new Eye(GuiDisplayProcedures.DisplayShisuiDojutsu2x1Pupils2x1Procedure::executeProcedure, "shisuimangekyo2px1px2gui", 0, 0, 96, 16),
			new Eye(GuiDisplayProcedures.DisplayShisuiDojutsu2x2Pupils1x1Procedure::executeProcedure, "shisuimangekyo2px2px2gui", 0, 0, 96, 32),
			new Eye(GuiDisplayProcedures.DisplayShisuiDojutsu2x2Pupils2x1Procedure::executeProcedure, "shisuimangekyo2px2px1gui", 0, 0, 96, 32),
			new Eye(GuiDisplayProcedures.DisplayScarProcedure::executeProcedure, "scargui", 64, -19, 32, 78),
			new Eye(GuiDisplayProcedures.DisplayKakashi1Dojutsu2x1Pupils1x1Procedure::executeProcedure, "kakashisharingan2px1px2gui", 0, 0, 96, 16),
			new Eye(GuiDisplayProcedures.DisplayKakashi1Dojutsu2x1Pupils2x1Procedure::executeProcedure, "kakashisharingan2px1pxgui", 0, 0, 96, 16),
			new Eye(GuiDisplayProcedures.DisplayKakashi1Dojutsu2x2Pupils1x1Procedure::executeProcedure, "kakashisharingan2px2px2gui", 0, 0, 96, 32),
			new Eye(GuiDisplayProcedures.DisplayKakashi1Dojutsu2x2Pupils2x1Procedure::executeProcedure, "kakashisharingan2px2px1gui", 0, 0, 96, 32),
			new Eye(GuiDisplayProcedures.DisplayKakashiDojutsu2x1Pupils1x1Procedure::executeProcedure, "kakashimangekyo2px1pxgui", 0, 0, 96, 16),
			new Eye(GuiDisplayProcedures.DisplayKakashiDojutsu2x1Pupils2x1Procedure::executeProcedure, "kakashimangekyo2px1px2gui", 0, 0, 96, 16),
			new Eye(GuiDisplayProcedures.DisplayKakashiDojutsu2x2Pupils1x1Procedure::executeProcedure, "kakashimangekyo2px2px2gui", 0, 0, 96, 32),
			new Eye(GuiDisplayProcedures.DisplayKakashiDojutsu2x2Pupils2x1Procedure::executeProcedure, "kakashimangekyo2px2px1gui", 0, 0, 96, 32),
			new Eye(GuiDisplayProcedures.DisplayRinnegan2x1Pupils1x1Procedure::executeProcedure, "rinnegan2px1px_gui", 0, 0, 96, 16),
			new Eye(GuiDisplayProcedures.DisplayRinnegan2x1Pupils2x1Procedure::executeProcedure, "rinnegan2px1px2_gui", 0, 0, 96, 16),
			new Eye(GuiDisplayProcedures.DisplayRinnegan2x2Pupils1x1Procedure::executeProcedure, "rinnegan2px2px1_gui", 0, 0, 96, 32),
			new Eye(GuiDisplayProcedures.DisplayRinnegan2x2Pupils2x1Procedure::executeProcedure, "rinnegan2px2px2_gui", 0, 0, 96, 32),
			new Eye(GuiDisplayProcedures.DisplayTenseigan2x1Pupils1x1Procedure::executeProcedure, "tenseigan2px1px_gui", 0, 0, 96, 16),
			new Eye(GuiDisplayProcedures.DisplayTenseigan2x1Pupils2x1Procedure::executeProcedure, "tenseigan1px2px2_gui", 0, 0, 96, 16),
			new Eye(GuiDisplayProcedures.DisplayTenseigan2x2Pupils1x1Procedure::executeProcedure, "tenseigan2px2px2_gui", 0, 0, 96, 32),
			new Eye(GuiDisplayProcedures.DisplayTenseigan2x21Pupils2x1Procedure::executeProcedure, "tenseigan2px2px1_gui", 0, 0, 96, 32)};

	// ------------------------------------------------------------------ info card
	public static class InfoCardGuiWindow extends ModScreen<InfoCardGui.GuiContainerMod> {
		public InfoCardGuiWindow(InfoCardGui.GuiContainerMod container, Inventory inventory, Component text) {
			super(container, inventory, Component.literal("Info Card"), 300, 174, container.entity, container.x, container.y, container.z);
		}

		@Override
		protected void send(int id) {
			NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardGui.ButtonPressedMessage(id, x, y, z));
			InfoCardGui.handleButtonAction(entity, id, x, y, z);
		}

		@Override
		protected void init() {
			super.init();
			pageTabs("info");
		}

		@Override
		protected void background(GuiGraphicsExtractor graphics, int mouseX, int mouseY) {
			playerPreview(graphics, 8, 40, 54, 72, mouseX, mouseY);
			iconSlot(graphics, first(Icons.CLANS), 274, 38, mouseX, mouseY);
			PlayerVariables vars = vars();
			float progress = vars.LEVELMAX <= 0 ? 0 : (float) (vars.LEVEL / vars.LEVELMAX);
			progressBar(graphics, 70, 89, 182, progress);
			if (hovered(70, 87, 182, 9, mouseX, mouseY))
				graphics.setTooltipForNextFrame(Component.literal(number(vars.LEVELMAX - vars.LEVEL) + " XP to level " + number(vars.LEVELSTAT + 1)), mouseX, mouseY);
			List<ModScreen.Icon> abilities = shown(Icons.ABILITIES);
			for (int i = 0; i < 16; i++)
				iconSlot(graphics, i < abilities.size() ? abilities.get(i) : null, 8 + i % 8 * 18, 130 + i / 8 * 18, mouseX, mouseY);
			List<ModScreen.Icon> natures = shown(Icons.NATURES);
			for (int i = 0; i < 5; i++)
				iconSlot(graphics, i < natures.size() ? natures.get(i) : null, 202 + i * 18, 130, mouseX, mouseY);
		}

		@Override
		protected void labels(GuiGraphicsExtractor graphics, int mouseX, int mouseY) {
			PlayerVariables vars = vars();
			ModScreen.Icon clan = first(Icons.CLANS);
			text(graphics, "Village: " + clean(vars.village, "None"), 70, 42);
			text(graphics, "Rank: " + clean(vars.rank, "None"), 70, 53);
			text(graphics, "Clan: " + (clan == null ? "None" : clan.name()), 70, 64);
			text(graphics, "Level " + number(vars.LEVELSTAT), 70, 78);
			textRight(graphics, number(vars.LEVEL) + " / " + number(vars.LEVELMAX) + " XP", 252, 78);
			text(graphics, "JP: " + number(vars.jp), 70, 100);
			text(graphics, "SP: " + number(vars.sp), 120, 100);
			text(graphics, "Chakra: " + number(vars.ChakraAmount) + " / " + number(vars.ChakraMax), 170, 100);
			text(graphics, "Kekkei Genkai & Dojutsu", 8, 120);
			text(graphics, "Nature", 202, 120);
		}
	}

	// ------------------------------------------------------------------ stats (upgrading)
	public static class InfoCardUpgradeGuiWindow extends ModScreen<InfoCardUpgradeGui.GuiContainerMod> {
		record Stat(String name, int id, ToDoubleFunction<PlayerVariables> value) {
		}

		static final Stat[] STATS = {new Stat("Ninjutsu", 4, v -> v.ninjutsu), new Stat("Taijutsu", 5, v -> v.taijutsu), new Stat("Kenjutsu", 6, v -> v.kenjutsu),
				new Stat("Shurikenjutsu", 7, v -> v.shurikenjutsu), new Stat("Summoning", 8, v -> v.summoning), new Stat("Kinjutsu", 9, v -> v.kinjutsu),
				new Stat("Senjutsu", 10, v -> v.senjutsu), new Stat("Medicine", 11, v -> v.medicine), new Stat("Speed", 12, v -> v.speed),
				new Stat("Jutsu Power", 13, v -> v.jutsupowerstat), new Stat("Genjutsu", 14, v -> v.genjutsu), new Stat("IQ", 15, v -> v.IQ)};

		private EditBox perClick;

		public InfoCardUpgradeGuiWindow(InfoCardUpgradeGui.GuiContainerMod container, Inventory inventory, Component text) {
			super(container, inventory, Component.literal("Stats"), 300, 200, container.entity, container.x, container.y, container.z);
		}

		@Override
		protected void send(int id) {
			NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardUpgradeGui.ButtonPressedMessage(id, x, y, z));
			InfoCardUpgradeGui.handleButtonAction(entity, id, x, y, z);
		}

		@Override
		protected void init() {
			super.init();
			pageTabs("stats");
			for (int i = 0; i < STATS.length; i++) {
				Button plus = button("+", STATS[i].id(), 8 + i / 6 * 144 + 120, 40 + i % 6 * 21, 20);
				onRefresh(() -> plus.active = vars().sp >= Math.max(1, vars().spusecount));
			}
			perClick = numberField(84, 172, 40, vars().spusecount);
			addRenderableWidget(Button.builder(Component.literal("Set"), b -> setPerClick(parse(perClick, 1))).bounds(leftPos + 126, topPos + 172, 32, 20).build());
			int[] amounts = {1, 5, 10};
			for (int i = 0; i < 3; i++) {
				int amount = amounts[i];
				Button quick = Button.builder(Component.literal(String.valueOf(amount)), b -> setPerClick(amount)).bounds(leftPos + 164 + i * 24, topPos + 172, 22, 20)
						.build();
				addRenderableWidget(quick);
				onRefresh(() -> quick.active = (int) vars().spusecount != amount);
			}
			Button max = Button.builder(Component.literal("All"), b -> setPerClick(Math.max(1, vars().sp))).bounds(leftPos + 236, topPos + 172, 56, 20)
					.tooltip(Tooltip.create(Component.literal("Spend all your SP with one click"))).build();
			addRenderableWidget(max);
			onRefresh(() -> {
				if (!perClick.isFocused())
					perClick.setValue(number(vars().spusecount));
			});
		}

		private void setPerClick(double amount) {
			action("set", "sp_per_click", Math.max(1, Math.min(1000, amount)));
			perClick.setFocused(false);
		}

		@Override
		protected void background(GuiGraphicsExtractor graphics, int mouseX, int mouseY) {
			for (int i = 0; i < STATS.length; i++)
				inset(graphics, 8 + i / 6 * 144, 40 + i % 6 * 21, 118, 20);
		}

		@Override
		protected void labels(GuiGraphicsExtractor graphics, int mouseX, int mouseY) {
			PlayerVariables vars = vars();
			textRight(graphics, "SP: " + number(vars.sp), 292, 6);
			for (int i = 0; i < STATS.length; i++) {
				int sx = 8 + i / 6 * 144, sy = 40 + i % 6 * 21;
				graphics.text(font, STATS[i].name(), sx + 5, sy + 6, 0xFFFFFFFF, true);
				String value = number(STATS[i].value().applyAsDouble(vars));
				graphics.text(font, value, sx + 114 - font.width(value), sy + 6, 0xFFFFFF55, true);
			}
			text(graphics, "SP per click", 8, 178);
		}
	}

	// ------------------------------------------------------------------ dojutsu appearance
	public static class InfoCardDojutsuGuiWindow extends ModScreen<InfoCardDojutsuGui.GuiContainerMod> {
		static final int EYE_X = 26, EYE_Y = 68;

		public InfoCardDojutsuGuiWindow(InfoCardDojutsuGui.GuiContainerMod container, Inventory inventory, Component text) {
			super(container, inventory, Component.literal("Dojutsu"), 300, 180, container.entity, container.x, container.y, container.z);
		}

		@Override
		protected void send(int id) {
			NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardDojutsuGui.ButtonPressedMessage(id, x, y, z));
			InfoCardDojutsuGui.handleButtonAction(entity, id, x, y, z);
		}

		@Override
		protected void init() {
			super.init();
			pageTabs("dojutsu");
			Predicate<Map<String, Object>> variants = GuiDisplayProcedures.DisplayMinus2SelectProcedure::executeProcedure;
			button("<", 8, 148, 50, 20, 20, variants);
			button(">", 9, 272, 50, 20, 20, variants);
			int[][] ids = {{1, 2}, {3, 4}, {5, 6}};
			for (int row = 0; row < 3; row++) {
				button("<", ids[row][0], 148, 84 + row * 34, 20);
				button(">", ids[row][1], 272, 84 + row * 34, 20);
			}
			button("Select", 7, 8, 134, 132).setTooltip(Tooltip.create(Component.literal("Use this dojutsu and eye shape")));
		}

		@Override
		protected void background(GuiGraphicsExtractor graphics, int mouseX, int mouseY) {
			darkInset(graphics, 8, 40, 132, 88);
			for (Eye eye : EYES)
				if (is(eye.shown()))
					texture(graphics, eye.texture(), EYE_X + eye.dx(), EYE_Y + eye.dy(), eye.width(), eye.height());
		}

		@Override
		protected void labels(GuiGraphicsExtractor graphics, int mouseX, int mouseY) {
			PlayerVariables vars = vars();
			if (is(GuiDisplayProcedures.DisplayMinus2SelectProcedure::executeProcedure)) {
				text(graphics, "Variant", 148, 40);
				textCentered(graphics, vars.DojutsuSelect2, 220, 56, TEXT);
			}
			text(graphics, "Dojutsu", 148, 74);
			String line2 = vars.DojutsuSelect3 == null ? "" : vars.DojutsuSelect3.trim();
			if (line2.isEmpty()) {
				textCentered(graphics, vars.DojutsuSelectResize, 220, 90, TEXT);
			} else {
				textCentered(graphics, vars.DojutsuSelectResize, 220, 85, TEXT);
				textCentered(graphics, line2, 220, 94, TEXT);
			}
			text(graphics, "Pupil Height", 148, 108);
			textCentered(graphics, number(vars.Pupils_Height), 220, 124, TEXT);
			text(graphics, "Eye Height", 148, 142);
			textCentered(graphics, number(vars.Eyes_Height), 220, 158, TEXT);
		}
	}

	// ------------------------------------------------------------------ missions
	public static class InfoCardMissionsGuiWindow extends ModScreen<InfoCardMissionsGui.GuiContainerMod> {
		record Rank(String letter, int color, ToDoubleFunction<PlayerVariables> count) {
		}

		static final Rank[] RANKS = {new Rank("D", 0xFFFFFFFF, v -> v.D_Mission), new Rank("C", 0xFF5555FF, v -> v.C_Mission),
				new Rank("B", 0xFF55FF55, v -> v.B_Mission), new Rank("A", 0xFFFF5555, v -> v.A_Mission), new Rank("S", 0xFFFFAA00, v -> v.S_Mission),
				new Rank("SS", 0xFFFFFF55, v -> v.SS_Mission)};

		public InfoCardMissionsGuiWindow(InfoCardMissionsGui.GuiContainerMod container, Inventory inventory, Component text) {
			super(container, inventory, Component.literal("Quests"), 300, 168, container.entity, container.x, container.y, container.z);
		}

		@Override
		protected void send(int id) {
			NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardMissionsGui.ButtonPressedMessage(id, x, y, z));
			InfoCardMissionsGui.handleButtonAction(entity, id, x, y, z);
		}

		@Override
		protected void init() {
			super.init();
			pageTabs("missions");
		}

		@Override
		protected void background(GuiGraphicsExtractor graphics, int mouseX, int mouseY) {
			for (int i = 0; i < RANKS.length; i++)
				inset(graphics, 8, 40 + i * 20, 18, 18);
		}

		@Override
		protected void labels(GuiGraphicsExtractor graphics, int mouseX, int mouseY) {
			PlayerVariables vars = vars();
			double total = 0;
			for (int i = 0; i < RANKS.length; i++) {
				Rank rank = RANKS[i];
				int ry = 40 + i * 20;
				double count = rank.count().applyAsDouble(vars);
				total += count;
				graphics.text(font, rank.letter(), 17 - font.width(rank.letter()) / 2, ry + 5, rank.color(), true);
				text(graphics, rank.letter() + "-Rank missions", 32, ry + 5);
				textRight(graphics, number(count), 144, ry + 5);
			}
			text(graphics, "Missions done", 160, 45);
			textRight(graphics, number(total), 292, 45);
			text(graphics, "Shinobi defeated", 160, 65);
			textRight(graphics, number(vars.Shinobi_Murder_Count), 292, 65);
		}
	}

	// ------------------------------------------------------------------ mini game: click the lit cell
	public static class InfoCardMiniGameGuiWindow extends ModScreen<InfoCardMiniGameGui.GuiContainerMod> {
		/** Cell n (row by row) is lit while Display<n>Mini is true; the ids are the generated ones. */
		static final int[] CELL_IDS = {7, 1, 13, 19, 18, 31, 37, 48, 2, 8, 14, 20, 26, 32, 38, 47, 3, 9, 15, 21, 27, 33, 39, 46, 4, 10, 16, 22, 28, 34, 40, 45, 5, 11, 17, 23, 29, 35, 41, 44, 6, 12, 25, 24, 30, 36, 42, 43};
		static final List<Predicate<Map<String, Object>>> CELLS = List.of(
				GuiDisplayProcedures.Display1MiniProcedure::executeProcedure,
				GuiDisplayProcedures.Display2MiniProcedure::executeProcedure,
				GuiDisplayProcedures.Display3MiniProcedure::executeProcedure,
				GuiDisplayProcedures.Display4MiniProcedure::executeProcedure,
				GuiDisplayProcedures.Display5MiniProcedure::executeProcedure,
				GuiDisplayProcedures.Display6MiniProcedure::executeProcedure,
				GuiDisplayProcedures.Display7MiniProcedure::executeProcedure,
				GuiDisplayProcedures.Display8MiniProcedure::executeProcedure,
				GuiDisplayProcedures.Display9MiniProcedure::executeProcedure,
				GuiDisplayProcedures.Display10MiniProcedure::executeProcedure,
				GuiDisplayProcedures.Display11MiniProcedure::executeProcedure,
				GuiDisplayProcedures.Display12MiniProcedure::executeProcedure,
				GuiDisplayProcedures.Display13MiniProcedure::executeProcedure,
				GuiDisplayProcedures.Display14MiniProcedure::executeProcedure,
				GuiDisplayProcedures.Display15MiniProcedure::executeProcedure,
				GuiDisplayProcedures.Display16MiniProcedure::executeProcedure,
				GuiDisplayProcedures.Display17MiniProcedure::executeProcedure,
				GuiDisplayProcedures.Display18MiniProcedure::executeProcedure,
				GuiDisplayProcedures.Display19MiniProcedure::executeProcedure,
				GuiDisplayProcedures.Display20MiniProcedure::executeProcedure,
				GuiDisplayProcedures.Display21MiniProcedure::executeProcedure,
				GuiDisplayProcedures.Display22MiniProcedure::executeProcedure,
				GuiDisplayProcedures.Display23MiniProcedure::executeProcedure,
				GuiDisplayProcedures.Display24MiniProcedure::executeProcedure,
				GuiDisplayProcedures.Display25MiniProcedure::executeProcedure,
				GuiDisplayProcedures.Display26MiniProcedure::executeProcedure,
				GuiDisplayProcedures.Display27MiniProcedure::executeProcedure,
				GuiDisplayProcedures.Display28MiniProcedure::executeProcedure,
				GuiDisplayProcedures.Display29MiniProcedure::executeProcedure,
				GuiDisplayProcedures.Display30MiniProcedure::executeProcedure,
				GuiDisplayProcedures.Display31MiniProcedure::executeProcedure,
				GuiDisplayProcedures.Display32MiniProcedure::executeProcedure,
				GuiDisplayProcedures.Display33MiniProcedure::executeProcedure,
				GuiDisplayProcedures.Display34MiniProcedure::executeProcedure,
				GuiDisplayProcedures.Display35MiniProcedure::executeProcedure,
				GuiDisplayProcedures.Display36MiniProcedure::executeProcedure,
				GuiDisplayProcedures.Display37MiniProcedure::executeProcedure,
				GuiDisplayProcedures.Display38MiniProcedure::executeProcedure,
				GuiDisplayProcedures.Display39MiniProcedure::executeProcedure,
				GuiDisplayProcedures.Display40MiniProcedure::executeProcedure,
				GuiDisplayProcedures.Display41MiniProcedure::executeProcedure,
				GuiDisplayProcedures.Display42MiniProcedure::executeProcedure,
				GuiDisplayProcedures.Display43MiniProcedure::executeProcedure,
				GuiDisplayProcedures.Display44MiniProcedure::executeProcedure,
				GuiDisplayProcedures.Display45MiniProcedure::executeProcedure,
				GuiDisplayProcedures.Display46MiniProcedure::executeProcedure,
				GuiDisplayProcedures.Display47MiniProcedure::executeProcedure,
				GuiDisplayProcedures.Display48MiniProcedure::executeProcedure);

		public InfoCardMiniGameGuiWindow(InfoCardMiniGameGui.GuiContainerMod container, Inventory inventory, Component text) {
			super(container, inventory, Component.literal("Mini Game"), 300, 170, container.entity, container.x, container.y, container.z);
		}

		@Override
		protected void send(int id) {
			NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardMiniGameGui.ButtonPressedMessage(id, x, y, z));
			InfoCardMiniGameGui.handleButtonAction(entity, id, x, y, z);
		}

		@Override
		protected void init() {
			super.init();
			pageTabs("minigame");
			for (int cell = 0; cell < 48; cell++)
				button(" ", CELL_IDS[cell], 8 + cell % 8 * 20, 40 + cell / 8 * 20, 20, 20, CELLS.get(cell));
		}

		@Override
		protected void background(GuiGraphicsExtractor graphics, int mouseX, int mouseY) {
			darkInset(graphics, 7, 39, 162, 122);
			PlayerVariables vars = vars();
			progressBar(graphics, 178, 68, 114, vars.LEVELMAXMINIGAME <= 0 ? 0 : (float) (vars.LEVELMINIGAME / vars.LEVELMAXMINIGAME));
		}

		@Override
		protected void labels(GuiGraphicsExtractor graphics, int mouseX, int mouseY) {
			PlayerVariables vars = vars();
			text(graphics, "Level " + number(vars.LEVELSTATMINIGAME), 178, 42);
			text(graphics, number(vars.LEVELMINIGAME) + " / " + number(vars.LEVELMAXMINIGAME) + " XP", 178, 56);
			graphics.text(font, "Click the lit square", 178, 84, MUTED, false);
			graphics.text(font, "before it moves.", 178, 94, MUTED, false);
		}
	}

	// ------------------------------------------------------------------ first join: clan, village and nature
	public static class StatSelectGuiWindow extends ModScreen<StatSelectGui.GuiContainerMod> {
		public StatSelectGuiWindow(StatSelectGui.GuiContainerMod container, Inventory inventory, Component text) {
			super(container, inventory, Component.literal("Choose Your Path"), 176, 166, container.entity, container.x, container.y, container.z);
		}

		@Override
		protected void send(int id) {
			NarutoShippudenMod.PACKET_HANDLER.sendToServer(new StatSelectGui.ButtonPressedMessage(id, x, y, z));
			StatSelectGui.handleButtonAction(entity, id, x, y, z);
		}

		@Override
		protected void init() {
			super.init();
			int[][] ids = {{0, 1}, {2, 3}, {5, 6}};
			for (int row = 0; row < 3; row++) {
				button("<", ids[row][0], 88, 26 + row * 40, 20);
				button(">", ids[row][1], 148, 26 + row * 40, 20);
			}
			button("Select", 4, 48, 138, 80);
		}

		private ModScreen.Icon[] row(int row) {
			return row == 0 ? Icons.SELECT_CLANS : row == 1 ? Icons.SELECT_VILLAGES : Icons.SELECT_NATURES;
		}

		@Override
		protected void background(GuiGraphicsExtractor graphics, int mouseX, int mouseY) {
			for (int row = 0; row < 3; row++) {
				int ry = 18 + row * 40;
				inset(graphics, 110, ry, 36, 36);
				ModScreen.Icon icon = first(row(row));
				if (icon != null)
					texture(graphics, icon.texture(), 112, ry + 2, 32, 32);
			}
		}

		@Override
		protected void labels(GuiGraphicsExtractor graphics, int mouseX, int mouseY) {
			String[] names = {"Clan", "Village", "Nature"};
			for (int row = 0; row < 3; row++) {
				int ry = 18 + row * 40;
				ModScreen.Icon icon = first(row(row));
				text(graphics, names[row], 8, ry + 8);
				graphics.text(font, icon == null ? "-" : icon.name(), 8, ry + 19, MUTED, false);
			}
		}
	}
}
