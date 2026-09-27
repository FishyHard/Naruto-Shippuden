package net.mcreator.narutoshippudenmod.gui;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;
import net.mcreator.narutoshippudenmod.NarutoShippudenMod;
import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables;
import net.mcreator.narutoshippudenmod.gui.JutsuCreationGuis.CreateJutsuGUI2Gui;
import net.mcreator.narutoshippudenmod.gui.JutsuCreationGuis.CreateJutsuGUIGui;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplayLearnCustomJutsu1Procedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.DisplayUnlearnCustomJutsu1Procedure;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.Button;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.Identifier;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.client.input.KeyEvent;

public final class JutsuCreationScreens {
	private JutsuCreationScreens() {
	}

	public static class CreateJutsuGUI2GuiWindow extends AbstractContainerScreen<CreateJutsuGUI2Gui.GuiContainerMod> {
		private Level world;
		private int x, y, z;
		private Player entity;
		private final static HashMap guistate = CreateJutsuGUI2Gui.guistate;
		EditBox Jutsu_Name;

		public CreateJutsuGUI2GuiWindow(CreateJutsuGUI2Gui.GuiContainerMod container, Inventory inventory, Component text) {
			super(container, inventory, text, 176, 166);
			this.world = container.world;
			this.x = container.x;
			this.y = container.y;
			this.z = container.z;
			this.entity = container.entity;
		}

		

		@Override
		public void extractBackground(GuiGraphicsExtractor graphics, int gx, int gy, float partialTicks) {
			super.extractBackground(graphics, gx, gy, partialTicks);
			Identifier _tex = null;

			_tex = Identifier.parse("naruto_shippuden:textures/screens/info_card_mini_game_texture.png");
			graphics.blit(RenderPipelines.GUI_TEXTURED, _tex, this.leftPos + 6, this.topPos + 21, 0, 0, 162, 124, 162, 124);
		}

		@Override
		public boolean keyPressed(KeyEvent event) {
			int key = event.key();
			if (key == 256) {
				this.minecraft.player.closeContainer();
				return true;
			}
			if (Jutsu_Name.isFocused())
				return Jutsu_Name.keyPressed(event);
			return super.keyPressed(event);
		}

		@Override
		protected void containerTick() {
		}

		@Override
		protected void extractLabels(GuiGraphicsExtractor graphics, int mouseX, int mouseY) {
			graphics.text(this.font, "Name:", 15, 31, -16777216, false);
			graphics.text(this.font, "Owner:", 15, 52, -16777216, false);
			graphics.text(this.font, "Type:", 15, 74, -16777216, false);
			graphics.text(this.font, "Speed:", 15, 97, -16777216, false);
			graphics.text(this.font, "Release:", 15, 122, -16777216, false);
			graphics.text(this.font, "Chakra:", 108, 98, -16777216, false);
			graphics.text(this.font, "" + (NarutoShippudenModVariables.get(entity).player_name) + "", 48, 52, -16777216, false);
			graphics.text(this.font, "" + (NarutoShippudenModVariables.get(entity).customjutsutype) + "", 42, 74, -16777216, false);
			graphics.text(this.font, "" + (NarutoShippudenModVariables.get(entity).customjutsuspeed) + "", 48, 97, -16777216, false);
			graphics.text(this.font, "" + (NarutoShippudenModVariables.get(entity).customjutsurelease) + "", 58, 122, -16777216, false);
			graphics.text(this.font, "" + (int) (NarutoShippudenModVariables.get(entity).customjutsuchakra) + "", 146, 98, -16777216, false);
			graphics.text(this.font, "Check JP Price:", 175, 24, -1, false);
			graphics.text(this.font, "" + (int) (NarutoShippudenModVariables.get(entity).customjutsujpcost) + "", 255, 24, -1, false);
		}

		@Override
		public void removed() {
			super.removed();
		}

		@Override
		protected void init() {
			super.init();
			this.addRenderableWidget(Button.builder(Component.literal("Back"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new CreateJutsuGUI2Gui.ButtonPressedMessage(0, x, y, z));
					CreateJutsuGUI2Gui.handleButtonAction(entity, 0, x, y, z);
				}
			}).bounds(this.leftPos + 6, this.topPos + -1, 56, 20).build());
			Jutsu_Name = new EditBox(this.font, this.leftPos + 42, this.topPos + 25, 65, 20, Component.literal(""));
			guistate.put("text:Jutsu_Name", Jutsu_Name);
			Jutsu_Name.setMaxLength(32767);
			this.addRenderableWidget(this.Jutsu_Name);
			this.addRenderableWidget(Button.builder(Component.literal("<"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new CreateJutsuGUI2Gui.ButtonPressedMessage(1, x, y, z));
					CreateJutsuGUI2Gui.handleButtonAction(entity, 1, x, y, z);
				}
			}).bounds(this.leftPos + -9, this.topPos + 116, 8, 20).build());
			this.addRenderableWidget(Button.builder(Component.literal(">"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new CreateJutsuGUI2Gui.ButtonPressedMessage(2, x, y, z));
					CreateJutsuGUI2Gui.handleButtonAction(entity, 2, x, y, z);
				}
			}).bounds(this.leftPos + 0, this.topPos + 116, 8, 20).build());
			this.addRenderableWidget(Button.builder(Component.literal("<"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new CreateJutsuGUI2Gui.ButtonPressedMessage(3, x, y, z));
					CreateJutsuGUI2Gui.handleButtonAction(entity, 3, x, y, z);
				}
			}).bounds(this.leftPos + -9, this.topPos + 91, 8, 20).build());
			this.addRenderableWidget(Button.builder(Component.literal(">"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new CreateJutsuGUI2Gui.ButtonPressedMessage(4, x, y, z));
					CreateJutsuGUI2Gui.handleButtonAction(entity, 4, x, y, z);
				}
			}).bounds(this.leftPos + 0, this.topPos + 91, 8, 20).build());
			this.addRenderableWidget(Button.builder(Component.literal("<"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new CreateJutsuGUI2Gui.ButtonPressedMessage(5, x, y, z));
					CreateJutsuGUI2Gui.handleButtonAction(entity, 5, x, y, z);
				}
			}).bounds(this.leftPos + -9, this.topPos + 68, 8, 20).build());
			this.addRenderableWidget(Button.builder(Component.literal(">"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new CreateJutsuGUI2Gui.ButtonPressedMessage(6, x, y, z));
					CreateJutsuGUI2Gui.handleButtonAction(entity, 6, x, y, z);
				}
			}).bounds(this.leftPos + 0, this.topPos + 68, 8, 20).build());
			this.addRenderableWidget(Button.builder(Component.literal("<"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new CreateJutsuGUI2Gui.ButtonPressedMessage(7, x, y, z));
					CreateJutsuGUI2Gui.handleButtonAction(entity, 7, x, y, z);
				}
			}).bounds(this.leftPos + 90, this.topPos + 92, 8, 20).build());
			this.addRenderableWidget(Button.builder(Component.literal(">"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new CreateJutsuGUI2Gui.ButtonPressedMessage(8, x, y, z));
					CreateJutsuGUI2Gui.handleButtonAction(entity, 8, x, y, z);
				}
			}).bounds(this.leftPos + 99, this.topPos + 92, 8, 20).build());
			this.addRenderableWidget(Button.builder(Component.literal("Price"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new CreateJutsuGUI2Gui.ButtonPressedMessage(9, x, y, z));
					CreateJutsuGUI2Gui.handleButtonAction(entity, 9, x, y, z);
				}
			}).bounds(this.leftPos + 175, this.topPos + 36, 51, 20).build());
			this.addRenderableWidget(Button.builder(Component.literal("Learn"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new CreateJutsuGUI2Gui.ButtonPressedMessage(10, x, y, z));
					CreateJutsuGUI2Gui.handleButtonAction(entity, 10, x, y, z);
				}
			}).bounds(this.leftPos + 175, this.topPos + 56, 51, 20).build());
		}
	}

	public static class CreateJutsuGUIGuiWindow extends AbstractContainerScreen<CreateJutsuGUIGui.GuiContainerMod> {
		private final java.util.List<Runnable> _visibility = new java.util.ArrayList<>();

		@Override
		public void extractRenderState(GuiGraphicsExtractor graphics, int mouseX, int mouseY, float partialTicks) {
			_visibility.forEach(Runnable::run);
			super.extractRenderState(graphics, mouseX, mouseY, partialTicks);
		}

		private Level world;
		private int x, y, z;
		private Player entity;
		private final static HashMap guistate = CreateJutsuGUIGui.guistate;

		public CreateJutsuGUIGuiWindow(CreateJutsuGUIGui.GuiContainerMod container, Inventory inventory, Component text) {
			super(container, inventory, text, 176, 166);
			this.world = container.world;
			this.x = container.x;
			this.y = container.y;
			this.z = container.z;
			this.entity = container.entity;
		}

		

		@Override
		public void extractBackground(GuiGraphicsExtractor graphics, int gx, int gy, float partialTicks) {
			super.extractBackground(graphics, gx, gy, partialTicks);
			Identifier _tex = null;

			_tex = Identifier.parse("naruto_shippuden:textures/screens/info_card_custom_jutsu_texture.png");
			graphics.blit(RenderPipelines.GUI_TEXTURED, _tex, this.leftPos + -24, this.topPos + 19, 0, 0, 229, 175, 229, 175);

			_tex = Identifier.parse("naruto_shippuden:textures/screens/warning_under_dev.png");
			graphics.blit(RenderPipelines.GUI_TEXTURED, _tex, this.leftPos + 27, this.topPos + 74, 0, 0, 125, 29, 125, 29);

			_tex = Identifier.parse("naruto_shippuden:textures/screens/warning_under_dev.png");
			graphics.blit(RenderPipelines.GUI_TEXTURED, _tex, this.leftPos + 27, this.topPos + 119, 0, 0, 125, 29, 125, 29);

			_tex = Identifier.parse("naruto_shippuden:textures/screens/warning_under_dev.png");
			graphics.blit(RenderPipelines.GUI_TEXTURED, _tex, this.leftPos + 27, this.topPos + 164, 0, 0, 125, 29, 125, 29);
		}

		@Override
		public boolean keyPressed(KeyEvent event) {
			int key = event.key();
			if (key == 256) {
				this.minecraft.player.closeContainer();
				return true;
			}
			return super.keyPressed(event);
		}

		@Override
		protected void containerTick() {
		}

		@Override
		protected void extractLabels(GuiGraphicsExtractor graphics, int mouseX, int mouseY) {
			if (DisplayUnlearnCustomJutsu1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
				graphics.text(this.font, "Release:", -20, 25, -1, false);
			if (DisplayUnlearnCustomJutsu1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
				graphics.text(this.font, "" + (NarutoShippudenModVariables.get(entity).customjutsurelease1save) + "", 24, 25, -1, false);
			if (DisplayUnlearnCustomJutsu1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
				graphics.text(this.font, "Type:", -20, 61, -1, false);
			if (DisplayUnlearnCustomJutsu1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
				graphics.text(this.font, "" + (NarutoShippudenModVariables.get(entity).customjutsutype1save) + "", 9, 61, -1, false);
			if (DisplayUnlearnCustomJutsu1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
				graphics.text(this.font, "Speed:", -20, 43, -1, false);
			if (DisplayUnlearnCustomJutsu1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
				graphics.text(this.font, "" + (NarutoShippudenModVariables.get(entity).customjutsuspeed1save) + "", 15, 43, -1, false);
			if (DisplayUnlearnCustomJutsu1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
				graphics.text(this.font, "!!WARNING!! You get only half of JP price ", 67, -2, -65536, false);
			if (DisplayUnlearnCustomJutsu1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
				graphics.text(this.font, "you bought if you unlearn it.", 69, 7, -65536, false);
		}

		@Override
		public void removed() {
			super.removed();
		}

		@Override
		protected void init() {
			super.init();
			this.addRenderableWidget(Button.builder(Component.literal("Back"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new CreateJutsuGUIGui.ButtonPressedMessage(0, x, y, z));
					CreateJutsuGUIGui.handleButtonAction(entity, 0, x, y, z);
				}
			}).bounds(this.leftPos + 6, this.topPos + -1, 56, 20).build());
			this.addRenderableWidget(Button.builder(Component.literal("Create"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new CreateJutsuGUIGui.ButtonPressedMessage(1, x, y, z));
					CreateJutsuGUIGui.handleButtonAction(entity, 1, x, y, z);
				}
			}).bounds(this.leftPos + -11, this.topPos + 79, 36, 20).build());
			Button _button1 = Button.builder(Component.literal("Create"), e -> {
				if (DisplayLearnCustomJutsu1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new CreateJutsuGUIGui.ButtonPressedMessage(2, x, y, z));
					CreateJutsuGUIGui.handleButtonAction(entity, 2, x, y, z);
				}
			}).bounds(this.leftPos + -11, this.topPos + 34, 36, 20).build();
			this.addRenderableWidget(_button1);
			_visibility.add(() -> _button1.visible = true);
			this.addRenderableWidget(Button.builder(Component.literal("Create"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new CreateJutsuGUIGui.ButtonPressedMessage(3, x, y, z));
					CreateJutsuGUIGui.handleButtonAction(entity, 3, x, y, z);
				}
			}).bounds(this.leftPos + -11, this.topPos + 124, 36, 20).build());
			this.addRenderableWidget(Button.builder(Component.literal("Create"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new CreateJutsuGUIGui.ButtonPressedMessage(4, x, y, z));
					CreateJutsuGUIGui.handleButtonAction(entity, 4, x, y, z);
				}
			}).bounds(this.leftPos + -11, this.topPos + 169, 36, 20).build());
			Button _button2 = Button.builder(Component.literal("Unlearn"), e -> {
				if (DisplayUnlearnCustomJutsu1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new CreateJutsuGUIGui.ButtonPressedMessage(5, x, y, z));
					CreateJutsuGUIGui.handleButtonAction(entity, 5, x, y, z);
				}
			}).bounds(this.leftPos + 204, this.topPos + 34, 36, 20).build();
			this.addRenderableWidget(_button2);
			_visibility.add(() -> _button2.visible = true);
		}
	}
}
