package net.mcreator.narutoshippudenmod.gui;

import com.mojang.blaze3d.matrix.MatrixStack;
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
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public final class MiscScreens {
	private MiscScreens() {
	}

	@OnlyIn(Dist.CLIENT)
	public static class AdventCalendarGUIGuiWindow extends ContainerScreen<AdventCalendarGUIGui.GuiContainerMod> {
		private World world;
		private int x, y, z;
		private PlayerEntity entity;
		private final static HashMap guistate = AdventCalendarGUIGui.guistate;

		public AdventCalendarGUIGuiWindow(AdventCalendarGUIGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
			super(container, inventory, text);
			this.world = container.world;
			this.x = container.x;
			this.y = container.y;
			this.z = container.z;
			this.entity = container.entity;
			this.xSize = 176;
			this.ySize = 166;
		}

		@Override
		public void render(MatrixStack ms, int mouseX, int mouseY, float partialTicks) {
			this.renderBackground(ms);
			super.render(ms, mouseX, mouseY, partialTicks);
			this.renderHoveredTooltip(ms, mouseX, mouseY);
		}

		@Override
		protected void drawGuiContainerBackgroundLayer(MatrixStack ms, float partialTicks, int gx, int gy) {
			RenderSystem.color4f(1, 1, 1, 1);
			RenderSystem.enableBlend();
			RenderSystem.defaultBlendFunc();

			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/calendar_gui.png"));
			this.blit(ms, this.guiLeft + 0, this.guiTop + -37, 0, 0, 175, 239, 175, 239);

			if (GiftOpenDisplay21Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/calendar_open.png"));
				this.blit(ms, this.guiLeft + -1, this.guiTop + 120, 0, 0, 42, 42, 42, 42);
			}
			if (GiftOpenDisplay22Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/calendar_open.png"));
				this.blit(ms, this.guiLeft + 29, this.guiTop + 120, 0, 0, 42, 42, 42, 42);
			}
			if (GiftOpenDisplay23Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/calendar_open.png"));
				this.blit(ms, this.guiLeft + 60, this.guiTop + 120, 0, 0, 42, 42, 42, 42);
			}
			if (GiftOpenDisplay24Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/calendar_open.png"));
				this.blit(ms, this.guiLeft + 91, this.guiTop + 120, 0, 0, 42, 42, 42, 42);
			}
			if (GiftOpenDisplay25Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/calendar_open.png"));
				this.blit(ms, this.guiLeft + 122, this.guiTop + 120, 0, 0, 42, 42, 42, 42);
			}
			if (GiftOpenDisplay16Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/calendar_open.png"));
				this.blit(ms, this.guiLeft + -1, this.guiTop + 89, 0, 0, 42, 42, 42, 42);
			}
			if (GiftOpenDisplay17Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/calendar_open.png"));
				this.blit(ms, this.guiLeft + 29, this.guiTop + 89, 0, 0, 42, 42, 42, 42);
			}
			if (GiftOpenDisplay18Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/calendar_open.png"));
				this.blit(ms, this.guiLeft + 60, this.guiTop + 89, 0, 0, 42, 42, 42, 42);
			}
			if (GiftOpenDisplay19Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/calendar_open.png"));
				this.blit(ms, this.guiLeft + 91, this.guiTop + 89, 0, 0, 42, 42, 42, 42);
			}
			if (GiftOpenDisplay20Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/calendar_open.png"));
				this.blit(ms, this.guiLeft + 122, this.guiTop + 89, 0, 0, 42, 42, 42, 42);
			}
			if (GiftOpenDisplay11Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/calendar_open.png"));
				this.blit(ms, this.guiLeft + -1, this.guiTop + 59, 0, 0, 42, 42, 42, 42);
			}
			if (GiftOpenDisplay12Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/calendar_open.png"));
				this.blit(ms, this.guiLeft + 29, this.guiTop + 59, 0, 0, 42, 42, 42, 42);
			}
			if (GiftOpenDisplay13Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/calendar_open.png"));
				this.blit(ms, this.guiLeft + 60, this.guiTop + 59, 0, 0, 42, 42, 42, 42);
			}
			if (GiftOpenDisplay14Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/calendar_open.png"));
				this.blit(ms, this.guiLeft + 91, this.guiTop + 59, 0, 0, 42, 42, 42, 42);
			}
			if (GiftOpenDisplay15Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/calendar_open.png"));
				this.blit(ms, this.guiLeft + 122, this.guiTop + 59, 0, 0, 42, 42, 42, 42);
			}
			if (GiftOpenDisplay6Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/calendar_open.png"));
				this.blit(ms, this.guiLeft + -1, this.guiTop + 29, 0, 0, 42, 42, 42, 42);
			}
			if (GiftOpenDisplay7Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/calendar_open.png"));
				this.blit(ms, this.guiLeft + 29, this.guiTop + 29, 0, 0, 42, 42, 42, 42);
			}
			if (GiftOpenDisplay8Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/calendar_open.png"));
				this.blit(ms, this.guiLeft + 60, this.guiTop + 29, 0, 0, 42, 42, 42, 42);
			}
			if (GiftOpenDisplay1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/calendar_open.png"));
				this.blit(ms, this.guiLeft + -1, this.guiTop + -2, 0, 0, 42, 42, 42, 42);
			}
			if (GiftOpenDisplay2Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/calendar_open.png"));
				this.blit(ms, this.guiLeft + 29, this.guiTop + -2, 0, 0, 42, 42, 42, 42);
			}
			if (GiftOpenDisplay3Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/calendar_open.png"));
				this.blit(ms, this.guiLeft + 60, this.guiTop + -2, 0, 0, 42, 42, 42, 42);
			}
			if (GiftOpenDisplay9Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/calendar_open.png"));
				this.blit(ms, this.guiLeft + 91, this.guiTop + 29, 0, 0, 42, 42, 42, 42);
			}
			if (GiftOpenDisplay10Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/calendar_open.png"));
				this.blit(ms, this.guiLeft + 122, this.guiTop + 28, 0, 0, 42, 42, 42, 42);
			}
			if (GiftOpenDisplay4Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/calendar_open.png"));
				this.blit(ms, this.guiLeft + 91, this.guiTop + -2, 0, 0, 42, 42, 42, 42);
			}
			if (GiftOpenDisplay5Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/calendar_open.png"));
				this.blit(ms, this.guiLeft + 122, this.guiTop + -2, 0, 0, 42, 42, 42, 42);
			}
			RenderSystem.disableBlend();
		}

		@Override
		public boolean keyPressed(int key, int b, int c) {
			if (key == 256) {
				this.minecraft.player.closeScreen();
				return true;
			}
			return super.keyPressed(key, b, c);
		}

		@Override
		public void tick() {
			super.tick();
		}

		@Override
		protected void drawGuiContainerForegroundLayer(MatrixStack ms, int mouseX, int mouseY) {
		}

		@Override
		public void onClose() {
			super.onClose();
			Minecraft.getInstance().keyboardListener.enableRepeatEvents(false);
		}

		@Override
		public void init(Minecraft minecraft, int width, int height) {
			super.init(minecraft, width, height);
			minecraft.keyboardListener.enableRepeatEvents(true);
			this.addButton(new Button(this.guiLeft + 177, this.guiTop + -38, 30, 20, new StringTextComponent("1"), e -> {
				if (Gift1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new AdventCalendarGUIGui.ButtonPressedMessage(0, x, y, z));
					AdventCalendarGUIGui.handleButtonAction(entity, 0, x, y, z);
				}
			}) {
				@Override
				public void render(MatrixStack ms, int gx, int gy, float ticks) {
					if (Gift1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
							(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
						super.render(ms, gx, gy, ticks);
				}
			});
			this.addButton(new Button(this.guiLeft + 177, this.guiTop + -20, 30, 20, new StringTextComponent("2"), e -> {
				if (Gift2Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new AdventCalendarGUIGui.ButtonPressedMessage(1, x, y, z));
					AdventCalendarGUIGui.handleButtonAction(entity, 1, x, y, z);
				}
			}) {
				@Override
				public void render(MatrixStack ms, int gx, int gy, float ticks) {
					if (Gift2Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
							(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
						super.render(ms, gx, gy, ticks);
				}
			});
			this.addButton(new Button(this.guiLeft + 177, this.guiTop + -2, 30, 20, new StringTextComponent("3"), e -> {
				if (Gift3Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new AdventCalendarGUIGui.ButtonPressedMessage(2, x, y, z));
					AdventCalendarGUIGui.handleButtonAction(entity, 2, x, y, z);
				}
			}) {
				@Override
				public void render(MatrixStack ms, int gx, int gy, float ticks) {
					if (Gift3Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
							(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
						super.render(ms, gx, gy, ticks);
				}
			});
			this.addButton(new Button(this.guiLeft + 177, this.guiTop + 16, 30, 20, new StringTextComponent("4"), e -> {
				if (Gift4Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new AdventCalendarGUIGui.ButtonPressedMessage(3, x, y, z));
					AdventCalendarGUIGui.handleButtonAction(entity, 3, x, y, z);
				}
			}) {
				@Override
				public void render(MatrixStack ms, int gx, int gy, float ticks) {
					if (Gift4Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
							(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
						super.render(ms, gx, gy, ticks);
				}
			});
			this.addButton(new Button(this.guiLeft + 177, this.guiTop + 88, 30, 20, new StringTextComponent("8"), e -> {
				if (Gift8Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new AdventCalendarGUIGui.ButtonPressedMessage(4, x, y, z));
					AdventCalendarGUIGui.handleButtonAction(entity, 4, x, y, z);
				}
			}) {
				@Override
				public void render(MatrixStack ms, int gx, int gy, float ticks) {
					if (Gift8Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
							(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
						super.render(ms, gx, gy, ticks);
				}
			});
			this.addButton(new Button(this.guiLeft + 177, this.guiTop + 52, 30, 20, new StringTextComponent("6"), e -> {
				if (Gift6Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new AdventCalendarGUIGui.ButtonPressedMessage(5, x, y, z));
					AdventCalendarGUIGui.handleButtonAction(entity, 5, x, y, z);
				}
			}) {
				@Override
				public void render(MatrixStack ms, int gx, int gy, float ticks) {
					if (Gift6Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
							(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
						super.render(ms, gx, gy, ticks);
				}
			});
			this.addButton(new Button(this.guiLeft + 177, this.guiTop + 70, 30, 20, new StringTextComponent("7"), e -> {
				if (Gift7Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new AdventCalendarGUIGui.ButtonPressedMessage(6, x, y, z));
					AdventCalendarGUIGui.handleButtonAction(entity, 6, x, y, z);
				}
			}) {
				@Override
				public void render(MatrixStack ms, int gx, int gy, float ticks) {
					if (Gift7Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
							(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
						super.render(ms, gx, gy, ticks);
				}
			});
			this.addButton(new Button(this.guiLeft + 177, this.guiTop + 34, 30, 20, new StringTextComponent("5"), e -> {
				if (Gift5Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new AdventCalendarGUIGui.ButtonPressedMessage(7, x, y, z));
					AdventCalendarGUIGui.handleButtonAction(entity, 7, x, y, z);
				}
			}) {
				@Override
				public void render(MatrixStack ms, int gx, int gy, float ticks) {
					if (Gift5Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
							(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
						super.render(ms, gx, gy, ticks);
				}
			});
			this.addButton(new Button(this.guiLeft + 177, this.guiTop + 106, 30, 20, new StringTextComponent("9"), e -> {
				if (Gift9Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new AdventCalendarGUIGui.ButtonPressedMessage(8, x, y, z));
					AdventCalendarGUIGui.handleButtonAction(entity, 8, x, y, z);
				}
			}) {
				@Override
				public void render(MatrixStack ms, int gx, int gy, float ticks) {
					if (Gift9Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
							(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
						super.render(ms, gx, gy, ticks);
				}
			});
			this.addButton(new Button(this.guiLeft + 177, this.guiTop + 124, 30, 20, new StringTextComponent("10"), e -> {
				if (Gift10Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new AdventCalendarGUIGui.ButtonPressedMessage(9, x, y, z));
					AdventCalendarGUIGui.handleButtonAction(entity, 9, x, y, z);
				}
			}) {
				@Override
				public void render(MatrixStack ms, int gx, int gy, float ticks) {
					if (Gift10Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
							(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
						super.render(ms, gx, gy, ticks);
				}
			});
			this.addButton(new Button(this.guiLeft + 177, this.guiTop + 142, 30, 20, new StringTextComponent("11"), e -> {
				if (Gift11Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new AdventCalendarGUIGui.ButtonPressedMessage(10, x, y, z));
					AdventCalendarGUIGui.handleButtonAction(entity, 10, x, y, z);
				}
			}) {
				@Override
				public void render(MatrixStack ms, int gx, int gy, float ticks) {
					if (Gift11Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
							(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
						super.render(ms, gx, gy, ticks);
				}
			});
			this.addButton(new Button(this.guiLeft + 177, this.guiTop + 160, 30, 20, new StringTextComponent("12"), e -> {
				if (Gift12Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new AdventCalendarGUIGui.ButtonPressedMessage(11, x, y, z));
					AdventCalendarGUIGui.handleButtonAction(entity, 11, x, y, z);
				}
			}) {
				@Override
				public void render(MatrixStack ms, int gx, int gy, float ticks) {
					if (Gift12Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
							(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
						super.render(ms, gx, gy, ticks);
				}
			});
			this.addButton(new Button(this.guiLeft + 177, this.guiTop + 178, 30, 20, new StringTextComponent("13"), e -> {
				if (Gift13Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new AdventCalendarGUIGui.ButtonPressedMessage(12, x, y, z));
					AdventCalendarGUIGui.handleButtonAction(entity, 12, x, y, z);
				}
			}) {
				@Override
				public void render(MatrixStack ms, int gx, int gy, float ticks) {
					if (Gift13Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
							(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
						super.render(ms, gx, gy, ticks);
				}
			});
			this.addButton(new Button(this.guiLeft + 204, this.guiTop + -38, 30, 20, new StringTextComponent("14"), e -> {
				if (Gift14Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new AdventCalendarGUIGui.ButtonPressedMessage(13, x, y, z));
					AdventCalendarGUIGui.handleButtonAction(entity, 13, x, y, z);
				}
			}) {
				@Override
				public void render(MatrixStack ms, int gx, int gy, float ticks) {
					if (Gift14Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
							(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
						super.render(ms, gx, gy, ticks);
				}
			});
			this.addButton(new Button(this.guiLeft + 204, this.guiTop + -20, 30, 20, new StringTextComponent("15"), e -> {
				if (Gift15Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new AdventCalendarGUIGui.ButtonPressedMessage(14, x, y, z));
					AdventCalendarGUIGui.handleButtonAction(entity, 14, x, y, z);
				}
			}) {
				@Override
				public void render(MatrixStack ms, int gx, int gy, float ticks) {
					if (Gift15Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
							(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
						super.render(ms, gx, gy, ticks);
				}
			});
			this.addButton(new Button(this.guiLeft + 204, this.guiTop + -2, 30, 20, new StringTextComponent("16"), e -> {
				if (Gift16Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new AdventCalendarGUIGui.ButtonPressedMessage(15, x, y, z));
					AdventCalendarGUIGui.handleButtonAction(entity, 15, x, y, z);
				}
			}) {
				@Override
				public void render(MatrixStack ms, int gx, int gy, float ticks) {
					if (Gift16Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
							(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
						super.render(ms, gx, gy, ticks);
				}
			});
			this.addButton(new Button(this.guiLeft + 204, this.guiTop + 16, 30, 20, new StringTextComponent("17"), e -> {
				if (Gift17Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new AdventCalendarGUIGui.ButtonPressedMessage(16, x, y, z));
					AdventCalendarGUIGui.handleButtonAction(entity, 16, x, y, z);
				}
			}) {
				@Override
				public void render(MatrixStack ms, int gx, int gy, float ticks) {
					if (Gift17Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
							(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
						super.render(ms, gx, gy, ticks);
				}
			});
			this.addButton(new Button(this.guiLeft + 204, this.guiTop + 34, 30, 20, new StringTextComponent("18"), e -> {
				if (Gift18Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new AdventCalendarGUIGui.ButtonPressedMessage(17, x, y, z));
					AdventCalendarGUIGui.handleButtonAction(entity, 17, x, y, z);
				}
			}) {
				@Override
				public void render(MatrixStack ms, int gx, int gy, float ticks) {
					if (Gift18Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
							(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
						super.render(ms, gx, gy, ticks);
				}
			});
			this.addButton(new Button(this.guiLeft + 204, this.guiTop + 52, 30, 20, new StringTextComponent("19"), e -> {
				if (Gift19Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new AdventCalendarGUIGui.ButtonPressedMessage(18, x, y, z));
					AdventCalendarGUIGui.handleButtonAction(entity, 18, x, y, z);
				}
			}) {
				@Override
				public void render(MatrixStack ms, int gx, int gy, float ticks) {
					if (Gift19Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
							(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
						super.render(ms, gx, gy, ticks);
				}
			});
			this.addButton(new Button(this.guiLeft + 204, this.guiTop + 70, 30, 20, new StringTextComponent("20"), e -> {
				if (Gift20Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new AdventCalendarGUIGui.ButtonPressedMessage(19, x, y, z));
					AdventCalendarGUIGui.handleButtonAction(entity, 19, x, y, z);
				}
			}) {
				@Override
				public void render(MatrixStack ms, int gx, int gy, float ticks) {
					if (Gift20Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
							(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
						super.render(ms, gx, gy, ticks);
				}
			});
			this.addButton(new Button(this.guiLeft + 204, this.guiTop + 88, 30, 20, new StringTextComponent("21"), e -> {
				if (Gift21Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new AdventCalendarGUIGui.ButtonPressedMessage(20, x, y, z));
					AdventCalendarGUIGui.handleButtonAction(entity, 20, x, y, z);
				}
			}) {
				@Override
				public void render(MatrixStack ms, int gx, int gy, float ticks) {
					if (Gift21Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
							(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
						super.render(ms, gx, gy, ticks);
				}
			});
			this.addButton(new Button(this.guiLeft + 204, this.guiTop + 106, 30, 20, new StringTextComponent("22"), e -> {
				if (Gift22Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new AdventCalendarGUIGui.ButtonPressedMessage(21, x, y, z));
					AdventCalendarGUIGui.handleButtonAction(entity, 21, x, y, z);
				}
			}) {
				@Override
				public void render(MatrixStack ms, int gx, int gy, float ticks) {
					if (Gift22Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
							(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
						super.render(ms, gx, gy, ticks);
				}
			});
			this.addButton(new Button(this.guiLeft + 204, this.guiTop + 124, 30, 20, new StringTextComponent("23"), e -> {
				if (Gift23Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new AdventCalendarGUIGui.ButtonPressedMessage(22, x, y, z));
					AdventCalendarGUIGui.handleButtonAction(entity, 22, x, y, z);
				}
			}) {
				@Override
				public void render(MatrixStack ms, int gx, int gy, float ticks) {
					if (Gift23Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
							(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
						super.render(ms, gx, gy, ticks);
				}
			});
			this.addButton(new Button(this.guiLeft + 204, this.guiTop + 142, 30, 20, new StringTextComponent("24"), e -> {
				if (Gift24Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new AdventCalendarGUIGui.ButtonPressedMessage(23, x, y, z));
					AdventCalendarGUIGui.handleButtonAction(entity, 23, x, y, z);
				}
			}) {
				@Override
				public void render(MatrixStack ms, int gx, int gy, float ticks) {
					if (Gift24Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
							(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
						super.render(ms, gx, gy, ticks);
				}
			});
			this.addButton(new Button(this.guiLeft + 204, this.guiTop + 160, 30, 20, new StringTextComponent("25"), e -> {
				if (Gift25Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new AdventCalendarGUIGui.ButtonPressedMessage(24, x, y, z));
					AdventCalendarGUIGui.handleButtonAction(entity, 24, x, y, z);
				}
			}) {
				@Override
				public void render(MatrixStack ms, int gx, int gy, float ticks) {
					if (Gift25Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
							(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
						super.render(ms, gx, gy, ticks);
				}
			});
		}
	}

	@OnlyIn(Dist.CLIENT)
	public static class GeninHeadbandSelectGuiWindow extends ContainerScreen<GeninHeadbandSelectGui.GuiContainerMod> {
		private World world;
		private int x, y, z;
		private PlayerEntity entity;
		private final static HashMap guistate = GeninHeadbandSelectGui.guistate;

		public GeninHeadbandSelectGuiWindow(GeninHeadbandSelectGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
			super(container, inventory, text);
			this.world = container.world;
			this.x = container.x;
			this.y = container.y;
			this.z = container.z;
			this.entity = container.entity;
			this.xSize = 176;
			this.ySize = 166;
		}

		@Override
		public void render(MatrixStack ms, int mouseX, int mouseY, float partialTicks) {
			this.renderBackground(ms);
			super.render(ms, mouseX, mouseY, partialTicks);
			this.renderHoveredTooltip(ms, mouseX, mouseY);
		}

		@Override
		protected void drawGuiContainerBackgroundLayer(MatrixStack ms, float partialTicks, int gx, int gy) {
			RenderSystem.color4f(1, 1, 1, 1);
			RenderSystem.enableBlend();
			RenderSystem.defaultBlendFunc();
			if (Headband2DisplayProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager()
						.bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/hidden_leaf_black_inventory_gui.png"));
				this.blit(ms, this.guiLeft + 72, this.guiTop + 34, 0, 0, 32, 32, 32, 32);
			}
			if (Headband1DisplayProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager()
						.bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/hidden_leaf_blue_inventory_gui.png"));
				this.blit(ms, this.guiLeft + 72, this.guiTop + 34, 0, 0, 32, 32, 32, 32);
			}
			if (Headband3DisplayProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager()
						.bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/hidden_leaf_red_inventory_gui.png"));
				this.blit(ms, this.guiLeft + 72, this.guiTop + 34, 0, 0, 32, 32, 32, 32);
			}
			RenderSystem.disableBlend();
		}

		@Override
		public boolean keyPressed(int key, int b, int c) {
			if (key == 256) {
				this.minecraft.player.closeScreen();
				return true;
			}
			return super.keyPressed(key, b, c);
		}

		@Override
		public void tick() {
			super.tick();
		}

		@Override
		protected void drawGuiContainerForegroundLayer(MatrixStack ms, int mouseX, int mouseY) {
			this.font.drawString(ms, "Headband Color", 51, 65, -1);
		}

		@Override
		public void onClose() {
			super.onClose();
			Minecraft.getInstance().keyboardListener.enableRepeatEvents(false);
		}

		@Override
		public void init(Minecraft minecraft, int width, int height) {
			super.init(minecraft, width, height);
			minecraft.keyboardListener.enableRepeatEvents(true);
			this.addButton(new Button(this.guiLeft + 55, this.guiTop + 40, 8, 20, new StringTextComponent("<"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new GeninHeadbandSelectGui.ButtonPressedMessage(0, x, y, z));
					GeninHeadbandSelectGui.handleButtonAction(entity, 0, x, y, z);
				}
			}));
			this.addButton(new Button(this.guiLeft + 111, this.guiTop + 40, 8, 20, new StringTextComponent(">"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new GeninHeadbandSelectGui.ButtonPressedMessage(1, x, y, z));
					GeninHeadbandSelectGui.handleButtonAction(entity, 1, x, y, z);
				}
			}));
			this.addButton(new Button(this.guiLeft + 60, this.guiTop + 79, 56, 20, new StringTextComponent("Select"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new GeninHeadbandSelectGui.ButtonPressedMessage(2, x, y, z));
					GeninHeadbandSelectGui.handleButtonAction(entity, 2, x, y, z);
				}
			}));
		}
	}

	@OnlyIn(Dist.CLIENT)
	public static class PatreonKitGuiWindow extends ContainerScreen<PatreonKitGui.GuiContainerMod> {
		private World world;
		private int x, y, z;
		private PlayerEntity entity;
		private final static HashMap guistate = PatreonKitGui.guistate;
		TextFieldWidget PatreonKit;

		public PatreonKitGuiWindow(PatreonKitGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
			super(container, inventory, text);
			this.world = container.world;
			this.x = container.x;
			this.y = container.y;
			this.z = container.z;
			this.entity = container.entity;
			this.xSize = 176;
			this.ySize = 166;
		}

		@Override
		public void render(MatrixStack ms, int mouseX, int mouseY, float partialTicks) {
			this.renderBackground(ms);
			super.render(ms, mouseX, mouseY, partialTicks);
			this.renderHoveredTooltip(ms, mouseX, mouseY);
			PatreonKit.render(ms, mouseX, mouseY, partialTicks);
		}

		@Override
		protected void drawGuiContainerBackgroundLayer(MatrixStack ms, float partialTicks, int gx, int gy) {
			RenderSystem.color4f(1, 1, 1, 1);
			RenderSystem.enableBlend();
			RenderSystem.defaultBlendFunc();
			RenderSystem.disableBlend();
		}

		@Override
		public boolean keyPressed(int key, int b, int c) {
			if (key == 256) {
				this.minecraft.player.closeScreen();
				return true;
			}
			if (PatreonKit.isFocused())
				return PatreonKit.keyPressed(key, b, c);
			return super.keyPressed(key, b, c);
		}

		@Override
		public void tick() {
			super.tick();
			PatreonKit.tick();
		}

		@Override
		protected void drawGuiContainerForegroundLayer(MatrixStack ms, int mouseX, int mouseY) {
		}

		@Override
		public void onClose() {
			super.onClose();
			Minecraft.getInstance().keyboardListener.enableRepeatEvents(false);
		}

		@Override
		public void init(Minecraft minecraft, int width, int height) {
			super.init(minecraft, width, height);
			minecraft.keyboardListener.enableRepeatEvents(true);
			PatreonKit = new TextFieldWidget(this.font, this.guiLeft + 27, this.guiTop + 25, 120, 20, new StringTextComponent(""));
			guistate.put("text:PatreonKit", PatreonKit);
			PatreonKit.setMaxStringLength(32767);
			this.children.add(this.PatreonKit);
			this.addButton(new Button(this.guiLeft + 62, this.guiTop + 55, 51, 20, new StringTextComponent("Claim"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new PatreonKitGui.ButtonPressedMessage(0, x, y, z));
					PatreonKitGui.handleButtonAction(entity, 0, x, y, z);
				}
			}));
		}
	}
}
