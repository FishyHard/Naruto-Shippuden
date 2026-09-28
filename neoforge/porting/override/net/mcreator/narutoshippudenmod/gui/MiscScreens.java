package net.mcreator.narutoshippudenmod.gui;

import net.mcreator.narutoshippudenmod.NarutoShippudenMod;
import net.mcreator.narutoshippudenmod.gui.MiscGuis.AdventCalendarGUIGui;
import net.mcreator.narutoshippudenmod.gui.MiscGuis.GeninHeadbandSelectGui;
import net.mcreator.narutoshippudenmod.gui.MiscGuis.PatreonKitGui;
import net.mcreator.narutoshippudenmod.procedures.GiftProcedures;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures;

import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.player.Inventory;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

/** Advent calendar, headband colour and Patreon kit, laid out like vanilla containers (see {@link ModScreen}). */
public final class MiscScreens {
	private MiscScreens() {
	}

	public static class AdventCalendarGUIGuiWindow extends ModScreen<AdventCalendarGUIGui.GuiContainerMod> {
		static final Identifier CHECKMARK = Identifier.withDefaultNamespace("icon/checkmark");
		/** Day n can be opened while Gift&lt;n&gt; is true and shows as opened while GiftOpenDisplay&lt;n&gt; is. */
		static final List<Predicate<Map<String, Object>>> CAN_OPEN = List.of(GiftProcedures.Gift1Procedure::executeProcedure,
				GiftProcedures.Gift2Procedure::executeProcedure, GiftProcedures.Gift3Procedure::executeProcedure, GiftProcedures.Gift4Procedure::executeProcedure,
				GiftProcedures.Gift5Procedure::executeProcedure, GiftProcedures.Gift6Procedure::executeProcedure, GiftProcedures.Gift7Procedure::executeProcedure,
				GiftProcedures.Gift8Procedure::executeProcedure, GiftProcedures.Gift9Procedure::executeProcedure, GiftProcedures.Gift10Procedure::executeProcedure,
				GiftProcedures.Gift11Procedure::executeProcedure, GiftProcedures.Gift12Procedure::executeProcedure, GiftProcedures.Gift13Procedure::executeProcedure,
				GiftProcedures.Gift14Procedure::executeProcedure, GiftProcedures.Gift15Procedure::executeProcedure, GiftProcedures.Gift16Procedure::executeProcedure,
				GiftProcedures.Gift17Procedure::executeProcedure, GiftProcedures.Gift18Procedure::executeProcedure, GiftProcedures.Gift19Procedure::executeProcedure,
				GiftProcedures.Gift20Procedure::executeProcedure, GiftProcedures.Gift21Procedure::executeProcedure, GiftProcedures.Gift22Procedure::executeProcedure,
				GiftProcedures.Gift23Procedure::executeProcedure, GiftProcedures.Gift24Procedure::executeProcedure, GiftProcedures.Gift25Procedure::executeProcedure);
		static final List<Predicate<Map<String, Object>>> OPENED = List.of(GuiDisplayProcedures.GiftOpenDisplay1Procedure::executeProcedure,
				GuiDisplayProcedures.GiftOpenDisplay2Procedure::executeProcedure, GuiDisplayProcedures.GiftOpenDisplay3Procedure::executeProcedure,
				GuiDisplayProcedures.GiftOpenDisplay4Procedure::executeProcedure, GuiDisplayProcedures.GiftOpenDisplay5Procedure::executeProcedure,
				GuiDisplayProcedures.GiftOpenDisplay6Procedure::executeProcedure, GuiDisplayProcedures.GiftOpenDisplay7Procedure::executeProcedure,
				GuiDisplayProcedures.GiftOpenDisplay8Procedure::executeProcedure, GuiDisplayProcedures.GiftOpenDisplay9Procedure::executeProcedure,
				GuiDisplayProcedures.GiftOpenDisplay10Procedure::executeProcedure, GuiDisplayProcedures.GiftOpenDisplay11Procedure::executeProcedure,
				GuiDisplayProcedures.GiftOpenDisplay12Procedure::executeProcedure, GuiDisplayProcedures.GiftOpenDisplay13Procedure::executeProcedure,
				GuiDisplayProcedures.GiftOpenDisplay14Procedure::executeProcedure, GuiDisplayProcedures.GiftOpenDisplay15Procedure::executeProcedure,
				GuiDisplayProcedures.GiftOpenDisplay16Procedure::executeProcedure, GuiDisplayProcedures.GiftOpenDisplay17Procedure::executeProcedure,
				GuiDisplayProcedures.GiftOpenDisplay18Procedure::executeProcedure, GuiDisplayProcedures.GiftOpenDisplay19Procedure::executeProcedure,
				GuiDisplayProcedures.GiftOpenDisplay20Procedure::executeProcedure, GuiDisplayProcedures.GiftOpenDisplay21Procedure::executeProcedure,
				GuiDisplayProcedures.GiftOpenDisplay22Procedure::executeProcedure, GuiDisplayProcedures.GiftOpenDisplay23Procedure::executeProcedure,
				GuiDisplayProcedures.GiftOpenDisplay24Procedure::executeProcedure, GuiDisplayProcedures.GiftOpenDisplay25Procedure::executeProcedure);

		public AdventCalendarGUIGuiWindow(AdventCalendarGUIGui.GuiContainerMod container, Inventory inventory, Component text) {
			super(container, inventory, Component.literal("Advent Calendar"), 176, 164, container.entity, container.x, container.y, container.z);
		}

		@Override
		protected void send(int id) {
			NarutoShippudenMod.PACKET_HANDLER.sendToServer(new AdventCalendarGUIGui.ButtonPressedMessage(id, x, y, z));
			AdventCalendarGUIGui.handleButtonAction(entity, id, x, y, z);
		}

		private static int cellX(int day) {
			return 19 + (day - 1) % 5 * 28;
		}

		private static int cellY(int day) {
			return 18 + (day - 1) / 5 * 28;
		}

		/** The generated ids follow the button order, which had days 5 and 8 swapped. */
		private static int id(int day) {
			return day == 5 ? 7 : day == 8 ? 4 : day - 1;
		}

		@Override
		protected void init() {
			super.init();
			for (int day = 1; day <= 25; day++)
				button(String.valueOf(day), id(day), cellX(day) + 1, cellY(day) + 1, 24, 24, CAN_OPEN.get(day - 1));
		}

		@Override
		protected void background(GuiGraphicsExtractor graphics, int mouseX, int mouseY) {
			for (int day = 1; day <= 25; day++) {
				int cx = cellX(day), cy = cellY(day);
				if (is(OPENED.get(day - 1))) {
					darkInset(graphics, cx, cy, 26, 26);
					graphics.blitSprite(RenderPipelines.GUI_TEXTURED, CHECKMARK, leftPos + cx + 8, topPos + cy + 9, 9, 8);
				} else {
					inset(graphics, cx, cy, 26, 26);
				}
			}
		}

		@Override
		protected void labels(GuiGraphicsExtractor graphics, int mouseX, int mouseY) {
			for (int day = 1; day <= 25; day++)
				if (!is(OPENED.get(day - 1)) && !is(CAN_OPEN.get(day - 1)))
					graphics.text(font, String.valueOf(day), cellX(day) + 13 - font.width(String.valueOf(day)) / 2, cellY(day) + 9, 0xFFFFFFFF, true);
		}
	}

	public static class GeninHeadbandSelectGuiWindow extends ModScreen<GeninHeadbandSelectGui.GuiContainerMod> {
		static final ModScreen.Icon[] HEADBANDS = {icon(GuiDisplayProcedures.Headband1DisplayProcedure::executeProcedure, "hidden_leaf_blue_inventory_gui", "Blue"),
				icon(GuiDisplayProcedures.Headband2DisplayProcedure::executeProcedure, "hidden_leaf_black_inventory_gui", "Black"),
				icon(GuiDisplayProcedures.Headband3DisplayProcedure::executeProcedure, "hidden_leaf_red_inventory_gui", "Red")};

		public GeninHeadbandSelectGuiWindow(GeninHeadbandSelectGui.GuiContainerMod container, Inventory inventory, Component text) {
			super(container, inventory, Component.literal("Headband Color"), 176, 98, container.entity, container.x, container.y, container.z);
		}

		@Override
		protected void send(int id) {
			NarutoShippudenMod.PACKET_HANDLER.sendToServer(new GeninHeadbandSelectGui.ButtonPressedMessage(id, x, y, z));
			GeninHeadbandSelectGui.handleButtonAction(entity, id, x, y, z);
		}

		@Override
		protected void init() {
			super.init();
			button("<", 0, 46, 26, 20);
			button(">", 1, 110, 26, 20);
			button("Select", 2, 48, 70, 80);
		}

		@Override
		protected void background(GuiGraphicsExtractor graphics, int mouseX, int mouseY) {
			inset(graphics, 70, 18, 36, 36);
			ModScreen.Icon headband = first(HEADBANDS);
			if (headband != null)
				texture(graphics, headband.texture(), 72, 20, 32, 32);
		}

		@Override
		protected void labels(GuiGraphicsExtractor graphics, int mouseX, int mouseY) {
			ModScreen.Icon headband = first(HEADBANDS);
			textCentered(graphics, headband == null ? "-" : headband.name(), 88, 58, TEXT);
		}
	}

	public static class PatreonKitGuiWindow extends ModScreen<PatreonKitGui.GuiContainerMod> {
		public PatreonKitGuiWindow(PatreonKitGui.GuiContainerMod container, Inventory inventory, Component text) {
			super(container, inventory, Component.literal("Patreon Kit"), 176, 72, container.entity, container.x, container.y, container.z);
		}

		@Override
		protected void send(int id) {
			NarutoShippudenMod.PACKET_HANDLER.sendToServer(new PatreonKitGui.ButtonPressedMessage(id, x, y, z));
			PatreonKitGui.handleButtonAction(entity, id, x, y, z);
		}

		@Override
		protected void init() {
			super.init();
			setInitialFocus(textField("PatreonKit", 8, 18, 160, PatreonKitGui.guistate));
			button("Claim", 0, 48, 44, 80);
		}
	}
}
