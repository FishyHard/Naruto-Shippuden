package net.mcreator.narutoshippudenmod.gui;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;
import net.mcreator.narutoshippudenmod.NarutoShippudenMod;
import net.mcreator.narutoshippudenmod.gui.MiscGuis.AdventCalendarGUIGui;
import net.mcreator.narutoshippudenmod.gui.MiscGuis.GeninHeadbandSelectGui;
import net.mcreator.narutoshippudenmod.gui.MiscGuis.PatreonKitGui;
import net.mcreator.narutoshippudenmod.procedures.GiftProcedures.Gift10Procedure;
import net.mcreator.narutoshippudenmod.procedures.GiftProcedures.Gift11Procedure;
import net.mcreator.narutoshippudenmod.procedures.GiftProcedures.Gift12Procedure;
import net.mcreator.narutoshippudenmod.procedures.GiftProcedures.Gift13Procedure;
import net.mcreator.narutoshippudenmod.procedures.GiftProcedures.Gift14Procedure;
import net.mcreator.narutoshippudenmod.procedures.GiftProcedures.Gift15Procedure;
import net.mcreator.narutoshippudenmod.procedures.GiftProcedures.Gift16Procedure;
import net.mcreator.narutoshippudenmod.procedures.GiftProcedures.Gift17Procedure;
import net.mcreator.narutoshippudenmod.procedures.GiftProcedures.Gift18Procedure;
import net.mcreator.narutoshippudenmod.procedures.GiftProcedures.Gift19Procedure;
import net.mcreator.narutoshippudenmod.procedures.GiftProcedures.Gift1Procedure;
import net.mcreator.narutoshippudenmod.procedures.GiftProcedures.Gift20Procedure;
import net.mcreator.narutoshippudenmod.procedures.GiftProcedures.Gift21Procedure;
import net.mcreator.narutoshippudenmod.procedures.GiftProcedures.Gift22Procedure;
import net.mcreator.narutoshippudenmod.procedures.GiftProcedures.Gift23Procedure;
import net.mcreator.narutoshippudenmod.procedures.GiftProcedures.Gift24Procedure;
import net.mcreator.narutoshippudenmod.procedures.GiftProcedures.Gift25Procedure;
import net.mcreator.narutoshippudenmod.procedures.GiftProcedures.Gift2Procedure;
import net.mcreator.narutoshippudenmod.procedures.GiftProcedures.Gift3Procedure;
import net.mcreator.narutoshippudenmod.procedures.GiftProcedures.Gift4Procedure;
import net.mcreator.narutoshippudenmod.procedures.GiftProcedures.Gift5Procedure;
import net.mcreator.narutoshippudenmod.procedures.GiftProcedures.Gift6Procedure;
import net.mcreator.narutoshippudenmod.procedures.GiftProcedures.Gift7Procedure;
import net.mcreator.narutoshippudenmod.procedures.GiftProcedures.Gift8Procedure;
import net.mcreator.narutoshippudenmod.procedures.GiftProcedures.Gift9Procedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.GiftOpenDisplay10Procedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.GiftOpenDisplay11Procedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.GiftOpenDisplay12Procedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.GiftOpenDisplay13Procedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.GiftOpenDisplay14Procedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.GiftOpenDisplay15Procedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.GiftOpenDisplay16Procedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.GiftOpenDisplay17Procedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.GiftOpenDisplay18Procedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.GiftOpenDisplay19Procedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.GiftOpenDisplay1Procedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.GiftOpenDisplay20Procedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.GiftOpenDisplay21Procedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.GiftOpenDisplay22Procedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.GiftOpenDisplay23Procedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.GiftOpenDisplay24Procedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.GiftOpenDisplay25Procedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.GiftOpenDisplay2Procedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.GiftOpenDisplay3Procedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.GiftOpenDisplay4Procedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.GiftOpenDisplay5Procedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.GiftOpenDisplay6Procedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.GiftOpenDisplay7Procedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.GiftOpenDisplay8Procedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.GiftOpenDisplay9Procedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.Headband1DisplayProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.Headband2DisplayProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.Headband3DisplayProcedure;
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

@OnlyIn(Dist.CLIENT)
public final class MiscScreens {
	private MiscScreens() {
	}

	@OnlyIn(Dist.CLIENT)
	public static class AdventCalendarGUIGuiWindow extends AbstractContainerScreen<AdventCalendarGUIGui.GuiContainerMod> {
		private final java.util.List<Runnable> _visibility = new java.util.ArrayList<>();

		@Override
		public void extractRenderState(GuiGraphicsExtractor graphics, int mouseX, int mouseY, float partialTicks) {
			_visibility.forEach(Runnable::run);
			super.extractRenderState(graphics, mouseX, mouseY, partialTicks);
		}

		private Level world;
		private int x, y, z;
		private Player entity;
		private final static HashMap guistate = AdventCalendarGUIGui.guistate;

		public AdventCalendarGUIGuiWindow(AdventCalendarGUIGui.GuiContainerMod container, Inventory inventory, Component text) {
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

			_tex = Identifier.parse("naruto_shippuden:textures/screens/calendar_gui.png");
			graphics.blit(RenderPipelines.GUI_TEXTURED, _tex, this.leftPos + 0, this.topPos + -37, 0, 0, 175, 239, 175, 239);

			if (GiftOpenDisplay21Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				_tex = Identifier.parse("naruto_shippuden:textures/screens/calendar_open.png");
				graphics.blit(RenderPipelines.GUI_TEXTURED, _tex, this.leftPos + -1, this.topPos + 120, 0, 0, 42, 42, 42, 42);
			}
			if (GiftOpenDisplay22Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				_tex = Identifier.parse("naruto_shippuden:textures/screens/calendar_open.png");
				graphics.blit(RenderPipelines.GUI_TEXTURED, _tex, this.leftPos + 29, this.topPos + 120, 0, 0, 42, 42, 42, 42);
			}
			if (GiftOpenDisplay23Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				_tex = Identifier.parse("naruto_shippuden:textures/screens/calendar_open.png");
				graphics.blit(RenderPipelines.GUI_TEXTURED, _tex, this.leftPos + 60, this.topPos + 120, 0, 0, 42, 42, 42, 42);
			}
			if (GiftOpenDisplay24Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				_tex = Identifier.parse("naruto_shippuden:textures/screens/calendar_open.png");
				graphics.blit(RenderPipelines.GUI_TEXTURED, _tex, this.leftPos + 91, this.topPos + 120, 0, 0, 42, 42, 42, 42);
			}
			if (GiftOpenDisplay25Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				_tex = Identifier.parse("naruto_shippuden:textures/screens/calendar_open.png");
				graphics.blit(RenderPipelines.GUI_TEXTURED, _tex, this.leftPos + 122, this.topPos + 120, 0, 0, 42, 42, 42, 42);
			}
			if (GiftOpenDisplay16Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				_tex = Identifier.parse("naruto_shippuden:textures/screens/calendar_open.png");
				graphics.blit(RenderPipelines.GUI_TEXTURED, _tex, this.leftPos + -1, this.topPos + 89, 0, 0, 42, 42, 42, 42);
			}
			if (GiftOpenDisplay17Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				_tex = Identifier.parse("naruto_shippuden:textures/screens/calendar_open.png");
				graphics.blit(RenderPipelines.GUI_TEXTURED, _tex, this.leftPos + 29, this.topPos + 89, 0, 0, 42, 42, 42, 42);
			}
			if (GiftOpenDisplay18Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				_tex = Identifier.parse("naruto_shippuden:textures/screens/calendar_open.png");
				graphics.blit(RenderPipelines.GUI_TEXTURED, _tex, this.leftPos + 60, this.topPos + 89, 0, 0, 42, 42, 42, 42);
			}
			if (GiftOpenDisplay19Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				_tex = Identifier.parse("naruto_shippuden:textures/screens/calendar_open.png");
				graphics.blit(RenderPipelines.GUI_TEXTURED, _tex, this.leftPos + 91, this.topPos + 89, 0, 0, 42, 42, 42, 42);
			}
			if (GiftOpenDisplay20Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				_tex = Identifier.parse("naruto_shippuden:textures/screens/calendar_open.png");
				graphics.blit(RenderPipelines.GUI_TEXTURED, _tex, this.leftPos + 122, this.topPos + 89, 0, 0, 42, 42, 42, 42);
			}
			if (GiftOpenDisplay11Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				_tex = Identifier.parse("naruto_shippuden:textures/screens/calendar_open.png");
				graphics.blit(RenderPipelines.GUI_TEXTURED, _tex, this.leftPos + -1, this.topPos + 59, 0, 0, 42, 42, 42, 42);
			}
			if (GiftOpenDisplay12Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				_tex = Identifier.parse("naruto_shippuden:textures/screens/calendar_open.png");
				graphics.blit(RenderPipelines.GUI_TEXTURED, _tex, this.leftPos + 29, this.topPos + 59, 0, 0, 42, 42, 42, 42);
			}
			if (GiftOpenDisplay13Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				_tex = Identifier.parse("naruto_shippuden:textures/screens/calendar_open.png");
				graphics.blit(RenderPipelines.GUI_TEXTURED, _tex, this.leftPos + 60, this.topPos + 59, 0, 0, 42, 42, 42, 42);
			}
			if (GiftOpenDisplay14Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				_tex = Identifier.parse("naruto_shippuden:textures/screens/calendar_open.png");
				graphics.blit(RenderPipelines.GUI_TEXTURED, _tex, this.leftPos + 91, this.topPos + 59, 0, 0, 42, 42, 42, 42);
			}
			if (GiftOpenDisplay15Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				_tex = Identifier.parse("naruto_shippuden:textures/screens/calendar_open.png");
				graphics.blit(RenderPipelines.GUI_TEXTURED, _tex, this.leftPos + 122, this.topPos + 59, 0, 0, 42, 42, 42, 42);
			}
			if (GiftOpenDisplay6Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				_tex = Identifier.parse("naruto_shippuden:textures/screens/calendar_open.png");
				graphics.blit(RenderPipelines.GUI_TEXTURED, _tex, this.leftPos + -1, this.topPos + 29, 0, 0, 42, 42, 42, 42);
			}
			if (GiftOpenDisplay7Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				_tex = Identifier.parse("naruto_shippuden:textures/screens/calendar_open.png");
				graphics.blit(RenderPipelines.GUI_TEXTURED, _tex, this.leftPos + 29, this.topPos + 29, 0, 0, 42, 42, 42, 42);
			}
			if (GiftOpenDisplay8Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				_tex = Identifier.parse("naruto_shippuden:textures/screens/calendar_open.png");
				graphics.blit(RenderPipelines.GUI_TEXTURED, _tex, this.leftPos + 60, this.topPos + 29, 0, 0, 42, 42, 42, 42);
			}
			if (GiftOpenDisplay1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				_tex = Identifier.parse("naruto_shippuden:textures/screens/calendar_open.png");
				graphics.blit(RenderPipelines.GUI_TEXTURED, _tex, this.leftPos + -1, this.topPos + -2, 0, 0, 42, 42, 42, 42);
			}
			if (GiftOpenDisplay2Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				_tex = Identifier.parse("naruto_shippuden:textures/screens/calendar_open.png");
				graphics.blit(RenderPipelines.GUI_TEXTURED, _tex, this.leftPos + 29, this.topPos + -2, 0, 0, 42, 42, 42, 42);
			}
			if (GiftOpenDisplay3Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				_tex = Identifier.parse("naruto_shippuden:textures/screens/calendar_open.png");
				graphics.blit(RenderPipelines.GUI_TEXTURED, _tex, this.leftPos + 60, this.topPos + -2, 0, 0, 42, 42, 42, 42);
			}
			if (GiftOpenDisplay9Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				_tex = Identifier.parse("naruto_shippuden:textures/screens/calendar_open.png");
				graphics.blit(RenderPipelines.GUI_TEXTURED, _tex, this.leftPos + 91, this.topPos + 29, 0, 0, 42, 42, 42, 42);
			}
			if (GiftOpenDisplay10Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				_tex = Identifier.parse("naruto_shippuden:textures/screens/calendar_open.png");
				graphics.blit(RenderPipelines.GUI_TEXTURED, _tex, this.leftPos + 122, this.topPos + 28, 0, 0, 42, 42, 42, 42);
			}
			if (GiftOpenDisplay4Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				_tex = Identifier.parse("naruto_shippuden:textures/screens/calendar_open.png");
				graphics.blit(RenderPipelines.GUI_TEXTURED, _tex, this.leftPos + 91, this.topPos + -2, 0, 0, 42, 42, 42, 42);
			}
			if (GiftOpenDisplay5Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				_tex = Identifier.parse("naruto_shippuden:textures/screens/calendar_open.png");
				graphics.blit(RenderPipelines.GUI_TEXTURED, _tex, this.leftPos + 122, this.topPos + -2, 0, 0, 42, 42, 42, 42);
			}
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
		}

		@Override
		public void removed() {
			super.removed();
		}

		@Override
		protected void init() {
			super.init();
			Button _button1 = Button.builder(Component.literal("1"), e -> {
				if (Gift1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new AdventCalendarGUIGui.ButtonPressedMessage(0, x, y, z));
					AdventCalendarGUIGui.handleButtonAction(entity, 0, x, y, z);
				}
			}).bounds(this.leftPos + 177, this.topPos + -38, 30, 20).build();
			this.addRenderableWidget(_button1);
			_visibility.add(() -> _button1.visible = true);
			Button _button2 = Button.builder(Component.literal("2"), e -> {
				if (Gift2Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new AdventCalendarGUIGui.ButtonPressedMessage(1, x, y, z));
					AdventCalendarGUIGui.handleButtonAction(entity, 1, x, y, z);
				}
			}).bounds(this.leftPos + 177, this.topPos + -20, 30, 20).build();
			this.addRenderableWidget(_button2);
			_visibility.add(() -> _button2.visible = true);
			Button _button3 = Button.builder(Component.literal("3"), e -> {
				if (Gift3Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new AdventCalendarGUIGui.ButtonPressedMessage(2, x, y, z));
					AdventCalendarGUIGui.handleButtonAction(entity, 2, x, y, z);
				}
			}).bounds(this.leftPos + 177, this.topPos + -2, 30, 20).build();
			this.addRenderableWidget(_button3);
			_visibility.add(() -> _button3.visible = true);
			Button _button4 = Button.builder(Component.literal("4"), e -> {
				if (Gift4Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new AdventCalendarGUIGui.ButtonPressedMessage(3, x, y, z));
					AdventCalendarGUIGui.handleButtonAction(entity, 3, x, y, z);
				}
			}).bounds(this.leftPos + 177, this.topPos + 16, 30, 20).build();
			this.addRenderableWidget(_button4);
			_visibility.add(() -> _button4.visible = true);
			Button _button5 = Button.builder(Component.literal("8"), e -> {
				if (Gift8Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new AdventCalendarGUIGui.ButtonPressedMessage(4, x, y, z));
					AdventCalendarGUIGui.handleButtonAction(entity, 4, x, y, z);
				}
			}).bounds(this.leftPos + 177, this.topPos + 88, 30, 20).build();
			this.addRenderableWidget(_button5);
			_visibility.add(() -> _button5.visible = true);
			Button _button6 = Button.builder(Component.literal("6"), e -> {
				if (Gift6Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new AdventCalendarGUIGui.ButtonPressedMessage(5, x, y, z));
					AdventCalendarGUIGui.handleButtonAction(entity, 5, x, y, z);
				}
			}).bounds(this.leftPos + 177, this.topPos + 52, 30, 20).build();
			this.addRenderableWidget(_button6);
			_visibility.add(() -> _button6.visible = true);
			Button _button7 = Button.builder(Component.literal("7"), e -> {
				if (Gift7Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new AdventCalendarGUIGui.ButtonPressedMessage(6, x, y, z));
					AdventCalendarGUIGui.handleButtonAction(entity, 6, x, y, z);
				}
			}).bounds(this.leftPos + 177, this.topPos + 70, 30, 20).build();
			this.addRenderableWidget(_button7);
			_visibility.add(() -> _button7.visible = true);
			Button _button8 = Button.builder(Component.literal("5"), e -> {
				if (Gift5Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new AdventCalendarGUIGui.ButtonPressedMessage(7, x, y, z));
					AdventCalendarGUIGui.handleButtonAction(entity, 7, x, y, z);
				}
			}).bounds(this.leftPos + 177, this.topPos + 34, 30, 20).build();
			this.addRenderableWidget(_button8);
			_visibility.add(() -> _button8.visible = true);
			Button _button9 = Button.builder(Component.literal("9"), e -> {
				if (Gift9Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new AdventCalendarGUIGui.ButtonPressedMessage(8, x, y, z));
					AdventCalendarGUIGui.handleButtonAction(entity, 8, x, y, z);
				}
			}).bounds(this.leftPos + 177, this.topPos + 106, 30, 20).build();
			this.addRenderableWidget(_button9);
			_visibility.add(() -> _button9.visible = true);
			Button _button10 = Button.builder(Component.literal("10"), e -> {
				if (Gift10Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new AdventCalendarGUIGui.ButtonPressedMessage(9, x, y, z));
					AdventCalendarGUIGui.handleButtonAction(entity, 9, x, y, z);
				}
			}).bounds(this.leftPos + 177, this.topPos + 124, 30, 20).build();
			this.addRenderableWidget(_button10);
			_visibility.add(() -> _button10.visible = true);
			Button _button11 = Button.builder(Component.literal("11"), e -> {
				if (Gift11Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new AdventCalendarGUIGui.ButtonPressedMessage(10, x, y, z));
					AdventCalendarGUIGui.handleButtonAction(entity, 10, x, y, z);
				}
			}).bounds(this.leftPos + 177, this.topPos + 142, 30, 20).build();
			this.addRenderableWidget(_button11);
			_visibility.add(() -> _button11.visible = true);
			Button _button12 = Button.builder(Component.literal("12"), e -> {
				if (Gift12Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new AdventCalendarGUIGui.ButtonPressedMessage(11, x, y, z));
					AdventCalendarGUIGui.handleButtonAction(entity, 11, x, y, z);
				}
			}).bounds(this.leftPos + 177, this.topPos + 160, 30, 20).build();
			this.addRenderableWidget(_button12);
			_visibility.add(() -> _button12.visible = true);
			Button _button13 = Button.builder(Component.literal("13"), e -> {
				if (Gift13Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new AdventCalendarGUIGui.ButtonPressedMessage(12, x, y, z));
					AdventCalendarGUIGui.handleButtonAction(entity, 12, x, y, z);
				}
			}).bounds(this.leftPos + 177, this.topPos + 178, 30, 20).build();
			this.addRenderableWidget(_button13);
			_visibility.add(() -> _button13.visible = true);
			Button _button14 = Button.builder(Component.literal("14"), e -> {
				if (Gift14Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new AdventCalendarGUIGui.ButtonPressedMessage(13, x, y, z));
					AdventCalendarGUIGui.handleButtonAction(entity, 13, x, y, z);
				}
			}).bounds(this.leftPos + 204, this.topPos + -38, 30, 20).build();
			this.addRenderableWidget(_button14);
			_visibility.add(() -> _button14.visible = true);
			Button _button15 = Button.builder(Component.literal("15"), e -> {
				if (Gift15Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new AdventCalendarGUIGui.ButtonPressedMessage(14, x, y, z));
					AdventCalendarGUIGui.handleButtonAction(entity, 14, x, y, z);
				}
			}).bounds(this.leftPos + 204, this.topPos + -20, 30, 20).build();
			this.addRenderableWidget(_button15);
			_visibility.add(() -> _button15.visible = true);
			Button _button16 = Button.builder(Component.literal("16"), e -> {
				if (Gift16Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new AdventCalendarGUIGui.ButtonPressedMessage(15, x, y, z));
					AdventCalendarGUIGui.handleButtonAction(entity, 15, x, y, z);
				}
			}).bounds(this.leftPos + 204, this.topPos + -2, 30, 20).build();
			this.addRenderableWidget(_button16);
			_visibility.add(() -> _button16.visible = true);
			Button _button17 = Button.builder(Component.literal("17"), e -> {
				if (Gift17Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new AdventCalendarGUIGui.ButtonPressedMessage(16, x, y, z));
					AdventCalendarGUIGui.handleButtonAction(entity, 16, x, y, z);
				}
			}).bounds(this.leftPos + 204, this.topPos + 16, 30, 20).build();
			this.addRenderableWidget(_button17);
			_visibility.add(() -> _button17.visible = true);
			Button _button18 = Button.builder(Component.literal("18"), e -> {
				if (Gift18Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new AdventCalendarGUIGui.ButtonPressedMessage(17, x, y, z));
					AdventCalendarGUIGui.handleButtonAction(entity, 17, x, y, z);
				}
			}).bounds(this.leftPos + 204, this.topPos + 34, 30, 20).build();
			this.addRenderableWidget(_button18);
			_visibility.add(() -> _button18.visible = true);
			Button _button19 = Button.builder(Component.literal("19"), e -> {
				if (Gift19Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new AdventCalendarGUIGui.ButtonPressedMessage(18, x, y, z));
					AdventCalendarGUIGui.handleButtonAction(entity, 18, x, y, z);
				}
			}).bounds(this.leftPos + 204, this.topPos + 52, 30, 20).build();
			this.addRenderableWidget(_button19);
			_visibility.add(() -> _button19.visible = true);
			Button _button20 = Button.builder(Component.literal("20"), e -> {
				if (Gift20Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new AdventCalendarGUIGui.ButtonPressedMessage(19, x, y, z));
					AdventCalendarGUIGui.handleButtonAction(entity, 19, x, y, z);
				}
			}).bounds(this.leftPos + 204, this.topPos + 70, 30, 20).build();
			this.addRenderableWidget(_button20);
			_visibility.add(() -> _button20.visible = true);
			Button _button21 = Button.builder(Component.literal("21"), e -> {
				if (Gift21Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new AdventCalendarGUIGui.ButtonPressedMessage(20, x, y, z));
					AdventCalendarGUIGui.handleButtonAction(entity, 20, x, y, z);
				}
			}).bounds(this.leftPos + 204, this.topPos + 88, 30, 20).build();
			this.addRenderableWidget(_button21);
			_visibility.add(() -> _button21.visible = true);
			Button _button22 = Button.builder(Component.literal("22"), e -> {
				if (Gift22Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new AdventCalendarGUIGui.ButtonPressedMessage(21, x, y, z));
					AdventCalendarGUIGui.handleButtonAction(entity, 21, x, y, z);
				}
			}).bounds(this.leftPos + 204, this.topPos + 106, 30, 20).build();
			this.addRenderableWidget(_button22);
			_visibility.add(() -> _button22.visible = true);
			Button _button23 = Button.builder(Component.literal("23"), e -> {
				if (Gift23Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new AdventCalendarGUIGui.ButtonPressedMessage(22, x, y, z));
					AdventCalendarGUIGui.handleButtonAction(entity, 22, x, y, z);
				}
			}).bounds(this.leftPos + 204, this.topPos + 124, 30, 20).build();
			this.addRenderableWidget(_button23);
			_visibility.add(() -> _button23.visible = true);
			Button _button24 = Button.builder(Component.literal("24"), e -> {
				if (Gift24Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new AdventCalendarGUIGui.ButtonPressedMessage(23, x, y, z));
					AdventCalendarGUIGui.handleButtonAction(entity, 23, x, y, z);
				}
			}).bounds(this.leftPos + 204, this.topPos + 142, 30, 20).build();
			this.addRenderableWidget(_button24);
			_visibility.add(() -> _button24.visible = true);
			Button _button25 = Button.builder(Component.literal("25"), e -> {
				if (Gift25Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new AdventCalendarGUIGui.ButtonPressedMessage(24, x, y, z));
					AdventCalendarGUIGui.handleButtonAction(entity, 24, x, y, z);
				}
			}).bounds(this.leftPos + 204, this.topPos + 160, 30, 20).build();
			this.addRenderableWidget(_button25);
			_visibility.add(() -> _button25.visible = true);
		}
	}

	@OnlyIn(Dist.CLIENT)
	public static class GeninHeadbandSelectGuiWindow extends AbstractContainerScreen<GeninHeadbandSelectGui.GuiContainerMod> {
		private Level world;
		private int x, y, z;
		private Player entity;
		private final static HashMap guistate = GeninHeadbandSelectGui.guistate;

		public GeninHeadbandSelectGuiWindow(GeninHeadbandSelectGui.GuiContainerMod container, Inventory inventory, Component text) {
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
			if (Headband2DisplayProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				_tex = Identifier.parse("naruto_shippuden:textures/screens/hidden_leaf_black_inventory_gui.png");
				graphics.blit(RenderPipelines.GUI_TEXTURED, _tex, this.leftPos + 72, this.topPos + 34, 0, 0, 32, 32, 32, 32);
			}
			if (Headband1DisplayProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				_tex = Identifier.parse("naruto_shippuden:textures/screens/hidden_leaf_blue_inventory_gui.png");
				graphics.blit(RenderPipelines.GUI_TEXTURED, _tex, this.leftPos + 72, this.topPos + 34, 0, 0, 32, 32, 32, 32);
			}
			if (Headband3DisplayProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				_tex = Identifier.parse("naruto_shippuden:textures/screens/hidden_leaf_red_inventory_gui.png");
				graphics.blit(RenderPipelines.GUI_TEXTURED, _tex, this.leftPos + 72, this.topPos + 34, 0, 0, 32, 32, 32, 32);
			}
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
			graphics.text(this.font, "Headband Color", 51, 65, -1, false);
		}

		@Override
		public void removed() {
			super.removed();
		}

		@Override
		protected void init() {
			super.init();
			this.addRenderableWidget(Button.builder(Component.literal("<"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new GeninHeadbandSelectGui.ButtonPressedMessage(0, x, y, z));
					GeninHeadbandSelectGui.handleButtonAction(entity, 0, x, y, z);
				}
			}).bounds(this.leftPos + 55, this.topPos + 40, 8, 20).build());
			this.addRenderableWidget(Button.builder(Component.literal(">"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new GeninHeadbandSelectGui.ButtonPressedMessage(1, x, y, z));
					GeninHeadbandSelectGui.handleButtonAction(entity, 1, x, y, z);
				}
			}).bounds(this.leftPos + 111, this.topPos + 40, 8, 20).build());
			this.addRenderableWidget(Button.builder(Component.literal("Select"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new GeninHeadbandSelectGui.ButtonPressedMessage(2, x, y, z));
					GeninHeadbandSelectGui.handleButtonAction(entity, 2, x, y, z);
				}
			}).bounds(this.leftPos + 60, this.topPos + 79, 56, 20).build());
		}
	}

	@OnlyIn(Dist.CLIENT)
	public static class PatreonKitGuiWindow extends AbstractContainerScreen<PatreonKitGui.GuiContainerMod> {
		private Level world;
		private int x, y, z;
		private Player entity;
		private final static HashMap guistate = PatreonKitGui.guistate;
		EditBox PatreonKit;

		public PatreonKitGuiWindow(PatreonKitGui.GuiContainerMod container, Inventory inventory, Component text) {
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
		}

		@Override
		public boolean keyPressed(KeyEvent event) {
			int key = event.key();
			if (key == 256) {
				this.minecraft.player.closeContainer();
				return true;
			}
			if (PatreonKit.isFocused())
				return PatreonKit.keyPressed(event);
			return super.keyPressed(event);
		}

		@Override
		protected void containerTick() {
		}

		@Override
		protected void extractLabels(GuiGraphicsExtractor graphics, int mouseX, int mouseY) {
		}

		@Override
		public void removed() {
			super.removed();
		}

		@Override
		protected void init() {
			super.init();
			PatreonKit = new EditBox(this.font, this.leftPos + 27, this.topPos + 25, 120, 20, Component.literal(""));
			guistate.put("text:PatreonKit", PatreonKit);
			PatreonKit.setMaxLength(32767);
			this.addRenderableWidget(this.PatreonKit);
			this.addRenderableWidget(Button.builder(Component.literal("Claim"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new PatreonKitGui.ButtonPressedMessage(0, x, y, z));
					PatreonKitGui.handleButtonAction(entity, 0, x, y, z);
				}
			}).bounds(this.leftPos + 62, this.topPos + 55, 51, 20).build());
		}
	}
}
