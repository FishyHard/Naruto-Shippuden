package net.mcreator.narutoshippudenmod.gui;

import net.mcreator.narutoshippudenmod.NarutoShippudenMod;
import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables.PlayerVariables;
import net.mcreator.narutoshippudenmod.gui.JutsuCreationGuis.CreateJutsuGUI2Gui;
import net.mcreator.narutoshippudenmod.gui.JutsuCreationGuis.CreateJutsuGUIGui;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures;

import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.Tooltip;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.player.Inventory;

import java.util.Map;
import java.util.function.Predicate;

/** Custom jutsu list and editor, laid out like vanilla containers (see {@link ModScreen}). */
public final class JutsuCreationScreens {
	private JutsuCreationScreens() {
	}

	/** The jutsu slots: only the first one works, the other three were never finished. */
	public static class CreateJutsuGUIGuiWindow extends ModScreen<CreateJutsuGUIGui.GuiContainerMod> {
		static final Identifier LOCKED = Identifier.withDefaultNamespace("widget/locked_button_disabled");
		static final Predicate<Map<String, Object>> HAS_JUTSU = GuiDisplayProcedures.DisplayUnlearnCustomJutsu1Procedure::executeProcedure;
		static final Predicate<Map<String, Object>> CAN_CREATE = GuiDisplayProcedures.DisplayLearnCustomJutsu1Procedure::executeProcedure;

		public CreateJutsuGUIGuiWindow(CreateJutsuGUIGui.GuiContainerMod container, Inventory inventory, Component text) {
			super(container, inventory, Component.literal("Custom Jutsu"), 260, 176, container.entity, container.x, container.y, container.z);
		}

		@Override
		protected void send(int id) {
			NarutoShippudenMod.PACKET_HANDLER.sendToServer(new CreateJutsuGUIGui.ButtonPressedMessage(id, x, y, z));
			CreateJutsuGUIGui.handleButtonAction(entity, id, x, y, z);
		}

		@Override
		protected void init() {
			super.init();
			button("Create", 2, 196, 20, 52, 20, CAN_CREATE);
			button("Unlearn", 5, 196, 20, 52, 20, HAS_JUTSU).setTooltip(Tooltip.create(Component.literal("You get back half of the JP price.")));
			int[] unfinished = {1, 3, 4};
			for (int i = 0; i < 3; i++) {
				Button button = button("Create", unfinished[i], 196, 48 + i * 28, 52);
				button.active = false;
			}
			button("Back", 0, 8, 148, 60);
		}

		@Override
		protected void background(GuiGraphicsExtractor graphics, int mouseX, int mouseY) {
			for (int i = 0; i < 4; i++)
				inset(graphics, 8, 18 + i * 28, 244, 24);
			for (int i = 1; i < 4; i++)
				graphics.blitSprite(RenderPipelines.GUI_TEXTURED, LOCKED, leftPos + 12, topPos + 20 + i * 28, 20, 20);
		}

		@Override
		protected void labels(GuiGraphicsExtractor graphics, int mouseX, int mouseY) {
			PlayerVariables vars = vars();
			if (is(HAS_JUTSU)) {
				graphics.text(font, clean(vars.customjutsurelease1save, "?") + " Release", 14, 22, 0xFFFFFFFF, true);
				graphics.text(font, clean(vars.customjutsutype1save, "?") + ", " + clean(vars.customjutsuspeed1save, "?"), 14, 31, 0xFFE0E0E0, true);
				graphics.text(font, "Unlearning gives back only half of the JP price.", 8, 132, 0xFFAA0000, false);
			} else {
				graphics.text(font, "Empty slot", 14, 26, 0xFFE0E0E0, true);
			}
			for (int i = 1; i < 4; i++)
				graphics.text(font, "Coming soon", 38, 26 + i * 28, 0xFFB0B0B0, true);
		}
	}

	public static class CreateJutsuGUI2GuiWindow extends ModScreen<CreateJutsuGUI2Gui.GuiContainerMod> {
		public CreateJutsuGUI2GuiWindow(CreateJutsuGUI2Gui.GuiContainerMod container, Inventory inventory, Component text) {
			super(container, inventory, Component.literal("Create Jutsu"), 224, 200, container.entity, container.x, container.y, container.z);
		}

		@Override
		protected void send(int id) {
			NarutoShippudenMod.PACKET_HANDLER.sendToServer(new CreateJutsuGUI2Gui.ButtonPressedMessage(id, x, y, z));
			CreateJutsuGUI2Gui.handleButtonAction(entity, id, x, y, z);
		}

		@Override
		protected void init() {
			super.init();
			setInitialFocus(textField("Jutsu_Name", 64, 18, 152, CreateJutsuGUI2Gui.guistate));
			int[][] ids = {{5, 6}, {3, 4}, {1, 2}, {7, 8}};
			for (int row = 0; row < 4; row++) {
				button("<", ids[row][0], 64, 58 + row * 22, 20);
				button(">", ids[row][1], 196, 58 + row * 22, 20);
			}
			button("Check Price", 9, 124, 150, 92);
			button("Back", 0, 8, 172, 100);
			button("Learn", 10, 116, 172, 100);
		}

		@Override
		protected void labels(GuiGraphicsExtractor graphics, int mouseX, int mouseY) {
			PlayerVariables vars = vars();
			text(graphics, "Name", 8, 24);
			text(graphics, "Owner", 8, 44);
			text(graphics, clean(vars.player_name, "-"), 64, 44);
			String[] names = {"Type", "Speed", "Release", "Chakra"};
			String[] values = {vars.customjutsutype, vars.customjutsuspeed, vars.customjutsurelease, number(vars.customjutsuchakra)};
			for (int row = 0; row < 4; row++) {
				text(graphics, names[row], 8, 64 + row * 22);
				textCentered(graphics, clean(values[row], "-"), 140, 64 + row * 22, TEXT);
			}
			text(graphics, "Price: " + number(vars.customjutsujpcost) + " JP", 8, 156);
		}
	}
}
