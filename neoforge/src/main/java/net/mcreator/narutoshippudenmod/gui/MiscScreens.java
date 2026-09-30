package net.mcreator.narutoshippudenmod.gui;

import net.mcreator.narutoshippudenmod.NarutoShippudenMod;
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

/** Headband colour and Patreon kit, laid out like vanilla containers (see {@link ModScreen}). */
public final class MiscScreens {
	private MiscScreens() {
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
