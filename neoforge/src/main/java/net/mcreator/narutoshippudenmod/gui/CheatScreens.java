package net.mcreator.narutoshippudenmod.gui;

import net.mcreator.narutoshippudenmod.NarutoShippudenMod;
import net.mcreator.narutoshippudenmod.gui.CheatGuis.MangekyouSharinganCheatGui;
import net.mcreator.narutoshippudenmod.gui.CheatGuis.NarutoShippudenCheatDojutsuGUIGui;
import net.mcreator.narutoshippudenmod.gui.CheatGuis.NarutoShippudenCheatGUIGui;
import net.mcreator.narutoshippudenmod.gui.CheatGuis.NarutoShippudenCheatKekkeiGenkaiGUIGui;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures;
import net.mcreator.narutoshippudenmod.core.NarutoActions;

import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.Tooltip;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.player.Inventory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

/** The cheat menus, laid out like vanilla containers (see {@link ModScreen}). */
public final class CheatScreens {
	private CheatScreens() {
	}

	/** The cheat menu: exact values, dojutsu (given now or awakened after a delay) and kekkei genkai, on three tabs. */
	public static class NarutoShippudenCheatGUIGuiWindow extends ModScreen<NarutoShippudenCheatGUIGui.GuiContainerMod> {
		static final Identifier CHECKMARK = Identifier.withDefaultNamespace("icon/checkmark");
		static final String[] TABS = {"Player", "Dojutsu", "Kekkei Genkai"};
		static final String[] FIELDS = {"level", "xp", "jp", "sp", "max_chakra"};
		static final String[] STATS = {"ninjutsu", "taijutsu", "kenjutsu", "shurikenjutsu", "summoning", "kinjutsu", "senjutsu", "medicine", "speed",
				"jutsu_power", "genjutsu", "iq", "chakra"};
		static final Map<String, Predicate<Map<String, Object>>> OWNED_DOJUTSU = Map.ofEntries(
				Map.entry("sharingan", GuiDisplayProcedures.DisplaySharinganInfoProcedure::executeProcedure),
				Map.entry("byakugan", GuiDisplayProcedures.DisplayByakuganInfoProcedure::executeProcedure),
				Map.entry("ketsuryugan", GuiDisplayProcedures.DisplayKetsuryuganInfoProcedure::executeProcedure),
				Map.entry("rinnegan", GuiDisplayProcedures.DisplayRinneganInfoProcedure::executeProcedure),
				Map.entry("tenseigan", GuiDisplayProcedures.DisplayTenseiganInfoProcedure::executeProcedure),
				Map.entry("isshiki_dojutsu", GuiDisplayProcedures.DisplayIsshikiDojutsuInfoProcedure::executeProcedure),
				Map.entry("mangekyou_sasuke", GuiDisplayProcedures.DisplayMSSasukeInfoProcedure::executeProcedure),
				Map.entry("mangekyou_itachi", GuiDisplayProcedures.DisplayMSItachiInfoProcedure::executeProcedure),
				Map.entry("mangekyou_madara", GuiDisplayProcedures.DisplayMSMadaraInfoProcedure::executeProcedure),
				Map.entry("mangekyou_obito", GuiDisplayProcedures.DisplayMSObitoInfoProcedure::executeProcedure),
				Map.entry("mangekyou_shisui", GuiDisplayProcedures.DisplayMSShisuiInfoProcedure::executeProcedure));
		static final Map<String, Predicate<Map<String, Object>>> OWNED_KEKKEI_GENKAI = Map.ofEntries(
				Map.entry("ice", GuiDisplayProcedures.DisplayIceInfoProcedure::executeProcedure),
				Map.entry("wood", GuiDisplayProcedures.DisplayWoodInfoProcedure::executeProcedure),
				Map.entry("magnet", GuiDisplayProcedures.DisplayMagnetInfoProcedure::executeProcedure),
				Map.entry("storm", GuiDisplayProcedures.DisplayStormInfoProcedure::executeProcedure),
				Map.entry("smoke", GuiDisplayProcedures.DisplaySmokeInfoProcedure::executeProcedure),
				Map.entry("steel", GuiDisplayProcedures.DisplaySteelInfoProcedure::executeProcedure),
				Map.entry("boil", GuiDisplayProcedures.DisplayBoilInfoProcedure::executeProcedure),
				Map.entry("bone", GuiDisplayProcedures.DisplayBoneInfoProcedure::executeProcedure),
				Map.entry("swift", GuiDisplayProcedures.DisplaySwiftInfoProcedure::executeProcedure),
				Map.entry("typhoon", GuiDisplayProcedures.DisplayTyphoonInfoProcedure::executeProcedure),
				Map.entry("dust", GuiDisplayProcedures.DisplayDustInfoProcedure::executeProcedure));

		private static int tab;
		private static int stat;
		private static String dojutsu = "sharingan";
		private static String awakenSeconds = "10";
		/** Checkmarks drawn in the labels pass: (x, y) of owned entries on the current tab. */
		private final List<int[]> checks = new ArrayList<>();
		private final List<Runnable> checkUpdates = new ArrayList<>();

		public NarutoShippudenCheatGUIGuiWindow(NarutoShippudenCheatGUIGui.GuiContainerMod container, Inventory inventory, Component text) {
			super(container, inventory, Component.literal("Cheats"), 302, 224, container.entity, container.x, container.y, container.z);
		}

		@Override
		protected void send(int id) {
			NarutoShippudenMod.PACKET_HANDLER.sendToServer(new NarutoShippudenCheatGUIGui.ButtonPressedMessage(id, x, y, z));
		}

		private Button add(String label, int bx, int by, int width, Runnable onPress) {
			Button button = Button.builder(Component.literal(label), b -> onPress.run()).bounds(leftPos + bx, topPos + by, width, 20).build();
			addRenderableWidget(button);
			return button;
		}

		@Override
		protected void init() {
			super.init();
			checkUpdates.clear();
			for (int i = 0; i < TABS.length; i++) {
				int index = i;
				add(TABS[i], 8 + i * 96, 16, 94, () -> {
					tab = index;
					rebuildWidgets();
				}).active = i != tab;
			}
			if (tab == 0)
				playerTab();
			else if (tab == 1)
				dojutsuTab();
			else
				kekkeiGenkaiTab();
			onRefresh(() -> {
				checks.clear();
				checkUpdates.forEach(Runnable::run);
			});
		}

		private void valueRow(String key, int by, int fieldX) {
			NarutoActions.Value value = NarutoActions.VALUES.get(key);
			EditBox field = numberField(fieldX, by, 70, value.get().applyAsDouble(vars()));
			add("Set", 230, by, 64, () -> {
				action("set", key, parse(field, 0));
				field.setFocused(false);
			});
			onRefresh(() -> {
				if (!field.isFocused())
					field.setValue(number(NarutoActions.VALUES.get(key).get().applyAsDouble(vars())));
			});
		}

		private void playerTab() {
			for (int i = 0; i < FIELDS.length; i++)
				valueRow(FIELDS[i], 42 + i * 21, 156);
			add("<", 8, 147, 20, () -> {
				stat = (stat + STATS.length - 1) % STATS.length;
				rebuildWidgets();
			});
			add(">", 132, 147, 20, () -> {
				stat = (stat + 1) % STATS.length;
				rebuildWidgets();
			});
			valueRow(STATS[stat], 147, 156);
			String[] ranks = NarutoActions.RANKS.keySet().toArray(new String[0]);
			String[] rankLabels = {"Academy", "Genin", "Chunin", "Jonin", "Kage"};
			int[] rankWidths = {58, 44, 46, 44, 46};
			for (int i = 0, rx = 48; i < ranks.length; rx += rankWidths[i] + 2, i++) {
				String rank = ranks[i];
				Button button = add(rankLabels[i], rx, 172, rankWidths[i], () -> action("rank", rank, 0));
				onRefresh(() -> button.active = !NarutoActions.RANKS.get(rank).name().equalsIgnoreCase(clean(vars().rank, "")));
			}
			String[][] resets = {{"stats", "Stats", "Reset the upgrading stats"}, {"info", "Info", "Reset the info card stats"},
					{"level", "Level", "Reset level, JP and SP"}, {"dojutsu", "Dojutsu", "Remove all dojutsu"}};
			int[] resetWidths = {58, 44, 46, 44};
			for (int i = 0, rx = 48; i < resets.length; rx += resetWidths[i] + 2, i++) {
				String key = resets[i][0];
				add(resets[i][1], rx, 196, resetWidths[i], () -> action("reset", key, 0)).setTooltip(Tooltip.create(Component.literal(resets[i][2])));
			}
			add("Path", 248, 196, 46, () -> action("page", "select", 0))
					.setTooltip(Tooltip.create(Component.literal("Choose clan, village and nature again")));
		}

		private void dojutsuTab() {
			String[] ids = NarutoActions.DOJUTSU.keySet().toArray(new String[0]);
			for (int i = 0; i < ids.length; i++) {
				String id = ids[i];
				int bx = 8 + i / 7 * 145, by = 42 + i % 7 * 21;
				Button button = add(NarutoActions.DOJUTSU.get(id).name().replace("Mangekyou Sharingan", "Mangekyou"), bx, by, 141, () -> {
					dojutsu = id;
					rebuildWidgets();
				});
				button.active = !id.equals(dojutsu);
				check(OWNED_DOJUTSU.get(id), bx + 141, by);
			}
			add("Give Now", 8, 196, 62, () -> action("dojutsu", dojutsu, -1))
					.setTooltip(Tooltip.create(Component.literal("Give " + NarutoActions.DOJUTSU.get(dojutsu).name() + " at once")));
			EditBox seconds = new EditBox(font, leftPos + 142, topPos + 196, 30, 20, Component.literal(""));
			seconds.setMaxLength(4);
			seconds.setValue(awakenSeconds);
			digitsOnly(seconds, false, value -> awakenSeconds = value);
			addRenderableWidget(seconds);
			boolean letter = dojutsu.startsWith("mangekyou") && !dojutsu.equals("mangekyou_kakashi");
			add("Awaken", 186, 196, 50, () -> action("dojutsu", dojutsu, Math.max(0, parse(seconds, 10))))
					.setTooltip(Tooltip.create(Component.literal(letter ? "Starts the Mangekyou letter quest after the delay"
							: "Awakens it with the message and effects after the delay")));
			add("Reset All", 240, 196, 54, () -> action("reset", "dojutsu", 0));
		}

		private void kekkeiGenkaiTab() {
			String[] ids = NarutoActions.KEKKEI_GENKAI.keySet().toArray(new String[0]);
			for (int i = 0; i < ids.length; i++) {
				String id = ids[i];
				int bx = 8 + i / 6 * 145, by = 42 + i % 6 * 21;
				add(NarutoActions.KEKKEI_GENKAI.get(id).name(), bx, by, 141, () -> action("kekkei_genkai", id, 0));
				check(OWNED_KEKKEI_GENKAI.get(id), bx + 141, by);
			}
		}

		/** Shows a checkmark left of the button's right edge while {@code owned} is true. */
		private void check(Predicate<Map<String, Object>> owned, int right, int by) {
			if (owned != null)
				checkUpdates.add(() -> {
					if (is(owned))
						checks.add(new int[] {right - 14, by + 6});
				});
		}

		@Override
		protected void labels(GuiGraphicsExtractor graphics, int mouseX, int mouseY) {
			if (tab == 0) {
				for (int i = 0; i < FIELDS.length; i++)
					text(graphics, NarutoActions.VALUES.get(FIELDS[i]).name(), 8, 48 + i * 21);
				textCentered(graphics, NarutoActions.VALUES.get(STATS[stat]).name(), 80, 153, TEXT);
				text(graphics, "Rank", 8, 178);
				text(graphics, "Reset", 8, 202);
			} else if (tab == 1) {
				text(graphics, "Awaken after", 76, 202);
				text(graphics, "s", 176, 202);
			} else {
				graphics.text(font, "Click to give. Checked ones you already have.", 8, 176, MUTED, false);
			}
			for (int[] check : checks)
				graphics.blitSprite(RenderPipelines.GUI_TEXTURED, CHECKMARK, check[0], check[1], 9, 8);
		}
	}

	public static class NarutoShippudenCheatDojutsuGUIGuiWindow extends ModScreen<NarutoShippudenCheatDojutsuGUIGui.GuiContainerMod> {
		public NarutoShippudenCheatDojutsuGUIGuiWindow(NarutoShippudenCheatDojutsuGUIGui.GuiContainerMod container, Inventory inventory, Component text) {
			super(container, inventory, Component.literal("Dojutsu Cheats"), 368, 210, container.entity, container.x, container.y, container.z);
		}

		@Override
		protected void send(int id) {
			NarutoShippudenMod.PACKET_HANDLER.sendToServer(new NarutoShippudenCheatDojutsuGUIGui.ButtonPressedMessage(id, x, y, z));
		}

		@Override
		protected void init() {
			super.init();
			String[] give = {"Sharingan", "Byakugan", "Ketsuryugan", "Mangekyou Sharingan", "Rinnegan", "Tenseigan", "Kokugan", "Kakashi Sharingan",
					"Shimura Sharingan"};
			int[] giveIds = {0, 1, 2, 9, 11, 12, 8, 10, 15};
			for (int i = 0; i < give.length; i++)
				button(give[i], giveIds[i], 8 + i / 5 * 116, 30 + i % 5 * 21, 112);
			String[] awaken = {"Sharingan", "Byakugan", "Ketsuryugan", "Tenseigan", "Kokugan", "Kakashi Sharingan", "Shimura Sharingan"};
			int[] awakenIds = {4, 5, 6, 13, 14, 16, 17};
			for (int i = 0; i < awaken.length; i++)
				button(awaken[i], awakenIds[i], 248, 30 + i * 21, 112);
			button("Reset Dojutsu", 7, 8, 182, 112);
			button("Back", 3, 248, 182, 112);
		}

		@Override
		protected void labels(GuiGraphicsExtractor graphics, int mouseX, int mouseY) {
			graphics.text(font, "Give instantly", 8, 19, MUTED, false);
			graphics.text(font, "Awaken in 10 seconds", 248, 19, MUTED, false);
		}
	}

	public static class NarutoShippudenCheatKekkeiGenkaiGUIGuiWindow extends ModScreen<NarutoShippudenCheatKekkeiGenkaiGUIGui.GuiContainerMod> {
		public NarutoShippudenCheatKekkeiGenkaiGUIGuiWindow(NarutoShippudenCheatKekkeiGenkaiGUIGui.GuiContainerMod container, Inventory inventory,
				Component text) {
			super(container, inventory, Component.literal("Kekkei Genkai Cheats"), 336, 156, container.entity, container.x, container.y, container.z);
		}

		@Override
		protected void send(int id) {
			NarutoShippudenMod.PACKET_HANDLER.sendToServer(new NarutoShippudenCheatKekkeiGenkaiGUIGui.ButtonPressedMessage(id, x, y, z));
		}

		@Override
		protected void init() {
			super.init();
			String[] names = {"Inferno Release", "Explosion Release", "Typhoon Release", "Magnet Release", "Bone Release", "Wood Release", "Lava Release",
					"Storm Release", "Dust Release", "Swift Release", "Ice Release", "Smoke Release", "Boil Release", "Steel Release", "Paper Release"};
			int[] ids = {11, 12, 13, 14, 15, 0, 1, 5, 7, 9, 4, 2, 6, 8, 10};
			for (int i = 0; i < names.length; i++)
				button(names[i], ids[i], 8 + i / 5 * 108, 18 + i % 5 * 21, 104);
			button("Back", 3, 116, 128, 104);
		}
	}

	public static class MangekyouSharinganCheatGuiWindow extends ModScreen<MangekyouSharinganCheatGui.GuiContainerMod> {
		public MangekyouSharinganCheatGuiWindow(MangekyouSharinganCheatGui.GuiContainerMod container, Inventory inventory, Component text) {
			super(container, inventory, Component.literal("Mangekyou Sharingan"), 180, 88, container.entity, container.x, container.y, container.z);
		}

		@Override
		protected void send(int id) {
			NarutoShippudenMod.PACKET_HANDLER.sendToServer(new MangekyouSharinganCheatGui.ButtonPressedMessage(id, x, y, z));
		}

		@Override
		protected void init() {
			super.init();
			String[] names = {"Sasuke", "Itachi", "Madara", "Obito", "Shisui", "Kakashi"};
			int[] ids = {0, 2, 1, 3, 4, 5};
			for (int i = 0; i < names.length; i++)
				button(names[i], ids[i], 8 + i / 3 * 84, 18 + i % 3 * 21, 80);
		}
	}

}
