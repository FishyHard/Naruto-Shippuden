package net.mcreator.narutoshippudenmod.gui;

import net.mcreator.narutoshippudenmod.NarutoShippudenMod;
import net.mcreator.narutoshippudenmod.gui.CheatGuis.MangekyouSharinganCheatGui;
import net.mcreator.narutoshippudenmod.gui.CheatGuis.NarutoShippudenCheatDojutsuGUIGui;
import net.mcreator.narutoshippudenmod.gui.CheatGuis.NarutoShippudenCheatGUIGui;
import net.mcreator.narutoshippudenmod.gui.CheatGuis.NarutoShippudenCheatKekkeiGenkaiGUIGui;
import net.mcreator.narutoshippudenmod.gui.CheatGuis.PasswordGUIDojutsuGui;

import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.components.Tooltip;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;

/** The cheat menus, laid out like vanilla containers (see {@link ModScreen}). */
public final class CheatScreens {
	private CheatScreens() {
	}

	public static class NarutoShippudenCheatGUIGuiWindow extends ModScreen<NarutoShippudenCheatGUIGui.GuiContainerMod> {
		public NarutoShippudenCheatGUIGuiWindow(NarutoShippudenCheatGUIGui.GuiContainerMod container, Inventory inventory, Component text) {
			super(container, inventory, Component.literal("Cheats"), 286, 178, container.entity, container.x, container.y, container.z);
		}

		@Override
		protected void send(int id) {
			NarutoShippudenMod.PACKET_HANDLER.sendToServer(new NarutoShippudenCheatGUIGui.ButtonPressedMessage(id, x, y, z));
			NarutoShippudenCheatGUIGui.handleButtonAction(entity, id, x, y, z);
		}

		@Override
		protected void init() {
			super.init();
			button("+100 Level XP", 20, 8, 18, 186);
			button("Reset Level, JP & SP", 19, 8, 40, 186);
			String[] jp = {"+100 JP", "+10 JP", "-10 JP", "-100 JP"}, sp = {"+100 SP", "+10 SP", "-10 SP", "-100 SP"};
			int[] jpIds = {0, 1, 6, 4}, spIds = {2, 3, 8, 7};
			for (int i = 0; i < 4; i++) {
				button(jp[i], jpIds[i], 8 + i * 47, 62, 45);
				button(sp[i], spIds[i], 8 + i * 47, 84, 45);
			}
			button("Add Max Chakra", 5, 8, 106, 186);
			button("Academy Student", 10, 8, 128, 186);
			String[] ranks = {"Genin", "Chunin", "Jonin", "Kage"};
			int[] rankIds = {9, 11, 12, 13};
			for (int i = 0; i < 4; i++)
				button(ranks[i], rankIds[i], 8 + i * 47, 150, 45);
			button("Dojutsu", 14, 202, 18, 76);
			button("Kekkei Genkai", 15, 202, 40, 76);
			button("Reset Stats", 16, 202, 106, 76).setTooltip(Tooltip.create(Component.literal("Reset upgrading stats")));
			button("Reset Info", 17, 202, 128, 76).setTooltip(Tooltip.create(Component.literal("Reset info card stats")));
			button("Select Menu", 18, 202, 150, 76);
		}

		@Override
		protected void labels(GuiGraphicsExtractor graphics, int mouseX, int mouseY) {
			graphics.text(font, "Reset", 202, 94, MUTED, false);
		}
	}

	public static class NarutoShippudenCheatDojutsuGUIGuiWindow extends ModScreen<NarutoShippudenCheatDojutsuGUIGui.GuiContainerMod> {
		public NarutoShippudenCheatDojutsuGUIGuiWindow(NarutoShippudenCheatDojutsuGUIGui.GuiContainerMod container, Inventory inventory, Component text) {
			super(container, inventory, Component.literal("Dojutsu Cheats"), 368, 210, container.entity, container.x, container.y, container.z);
		}

		@Override
		protected void send(int id) {
			NarutoShippudenMod.PACKET_HANDLER.sendToServer(new NarutoShippudenCheatDojutsuGUIGui.ButtonPressedMessage(id, x, y, z));
			NarutoShippudenCheatDojutsuGUIGui.handleButtonAction(entity, id, x, y, z);
		}

		@Override
		protected void init() {
			super.init();
			String[] give = {"Sharingan", "Byakugan", "Ketsuryugan", "Mangekyou Sharingan", "Rinnegan", "Tenseigan", "Isshiki Dojutsu", "Kakashi Sharingan",
					"Shimura Sharingan"};
			int[] giveIds = {0, 1, 2, 9, 11, 12, 8, 10, 15};
			for (int i = 0; i < give.length; i++)
				button(give[i], giveIds[i], 8 + i / 5 * 116, 30 + i % 5 * 21, 112);
			String[] awaken = {"Sharingan", "Byakugan", "Ketsuryugan", "Tenseigan", "Isshiki Dojutsu", "Kakashi Sharingan", "Shimura Sharingan"};
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
			NarutoShippudenCheatKekkeiGenkaiGUIGui.handleButtonAction(entity, id, x, y, z);
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
			MangekyouSharinganCheatGui.handleButtonAction(entity, id, x, y, z);
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

	public static class PasswordGUIDojutsuGuiWindow extends ModScreen<PasswordGUIDojutsuGui.GuiContainerMod> {
		public PasswordGUIDojutsuGuiWindow(PasswordGUIDojutsuGui.GuiContainerMod container, Inventory inventory, Component text) {
			super(container, inventory, Component.literal("Enter Password"), 176, 72, container.entity, container.x, container.y, container.z);
		}

		@Override
		protected void send(int id) {
			NarutoShippudenMod.PACKET_HANDLER.sendToServer(new PasswordGUIDojutsuGui.ButtonPressedMessage(id, x, y, z));
			PasswordGUIDojutsuGui.handleButtonAction(entity, id, x, y, z);
		}

		@Override
		protected void init() {
			super.init();
			setInitialFocus(textField("Password", 8, 18, 160, PasswordGUIDojutsuGui.guistate));
			button("Login", 0, 48, 44, 80);
		}
	}
}
