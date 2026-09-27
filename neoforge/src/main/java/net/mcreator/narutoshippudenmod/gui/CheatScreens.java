package net.mcreator.narutoshippudenmod.gui;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;
import java.util.HashMap;
import net.mcreator.narutoshippudenmod.NarutoShippudenMod;
import net.mcreator.narutoshippudenmod.gui.CheatGuis.MangekyouSharinganCheatGui;
import net.mcreator.narutoshippudenmod.gui.CheatGuis.NarutoShippudenCheatDojutsuGUIGui;
import net.mcreator.narutoshippudenmod.gui.CheatGuis.NarutoShippudenCheatGUIGui;
import net.mcreator.narutoshippudenmod.gui.CheatGuis.NarutoShippudenCheatKekkeiGenkaiGUIGui;
import net.mcreator.narutoshippudenmod.gui.CheatGuis.PasswordGUIDojutsuGui;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.Button;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.client.input.KeyEvent;
import net.minecraft.resources.Identifier;

public final class CheatScreens {
	private CheatScreens() {
	}

	public static class MangekyouSharinganCheatGuiWindow extends AbstractContainerScreen<MangekyouSharinganCheatGui.GuiContainerMod> {
		private Level world;
		private int x, y, z;
		private Player entity;
		private final static HashMap guistate = MangekyouSharinganCheatGui.guistate;

		public MangekyouSharinganCheatGuiWindow(MangekyouSharinganCheatGui.GuiContainerMod container, Inventory inventory, Component text) {
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
			this.addRenderableWidget(Button.builder(Component.literal("Sasuke"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new MangekyouSharinganCheatGui.ButtonPressedMessage(0, x, y, z));
					MangekyouSharinganCheatGui.handleButtonAction(entity, 0, x, y, z);
				}
			}).bounds(this.leftPos + -119, this.topPos + -29, 90, 20).build());
			this.addRenderableWidget(Button.builder(Component.literal("Madara"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new MangekyouSharinganCheatGui.ButtonPressedMessage(1, x, y, z));
					MangekyouSharinganCheatGui.handleButtonAction(entity, 1, x, y, z);
				}
			}).bounds(this.leftPos + -119, this.topPos + 11, 90, 20).build());
			this.addRenderableWidget(Button.builder(Component.literal("Itachi"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new MangekyouSharinganCheatGui.ButtonPressedMessage(2, x, y, z));
					MangekyouSharinganCheatGui.handleButtonAction(entity, 2, x, y, z);
				}
			}).bounds(this.leftPos + -119, this.topPos + -9, 90, 20).build());
			this.addRenderableWidget(Button.builder(Component.literal("Obito"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new MangekyouSharinganCheatGui.ButtonPressedMessage(3, x, y, z));
					MangekyouSharinganCheatGui.handleButtonAction(entity, 3, x, y, z);
				}
			}).bounds(this.leftPos + -119, this.topPos + 31, 90, 20).build());
			this.addRenderableWidget(Button.builder(Component.literal("Shisui"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new MangekyouSharinganCheatGui.ButtonPressedMessage(4, x, y, z));
					MangekyouSharinganCheatGui.handleButtonAction(entity, 4, x, y, z);
				}
			}).bounds(this.leftPos + -119, this.topPos + 51, 90, 20).build());
			this.addRenderableWidget(Button.builder(Component.literal("Kakashi"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new MangekyouSharinganCheatGui.ButtonPressedMessage(5, x, y, z));
					MangekyouSharinganCheatGui.handleButtonAction(entity, 5, x, y, z);
				}
			}).bounds(this.leftPos + -119, this.topPos + 71, 90, 20).build());
		}
	}

	public static class NarutoShippudenCheatDojutsuGUIGuiWindow extends AbstractContainerScreen<NarutoShippudenCheatDojutsuGUIGui.GuiContainerMod> {
		private Level world;
		private int x, y, z;
		private Player entity;
		private final static HashMap guistate = NarutoShippudenCheatDojutsuGUIGui.guistate;

		public NarutoShippudenCheatDojutsuGUIGuiWindow(NarutoShippudenCheatDojutsuGUIGui.GuiContainerMod container, Inventory inventory,
				Component text) {
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
			return super.keyPressed(event);
		}

		@Override
		protected void containerTick() {
		}

		@Override
		protected void extractLabels(GuiGraphicsExtractor graphics, int mouseX, int mouseY) {
			graphics.text(this.font, "Give Instantly:", -119, -29, -1, false);
			graphics.text(this.font, "Awake in 10 seconds:", 39, -29, -1, false);
		}

		@Override
		public void removed() {
			super.removed();
		}

		@Override
		protected void init() {
			super.init();
			this.addRenderableWidget(Button.builder(Component.literal("Sharingan"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new NarutoShippudenCheatDojutsuGUIGui.ButtonPressedMessage(0, x, y, z));
					NarutoShippudenCheatDojutsuGUIGui.handleButtonAction(entity, 0, x, y, z);
				}
			}).bounds(this.leftPos + -119, this.topPos + -11, 77, 20).build());
			this.addRenderableWidget(Button.builder(Component.literal("Byakugan"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new NarutoShippudenCheatDojutsuGUIGui.ButtonPressedMessage(1, x, y, z));
					NarutoShippudenCheatDojutsuGUIGui.handleButtonAction(entity, 1, x, y, z);
				}
			}).bounds(this.leftPos + -119, this.topPos + 9, 77, 20).build());
			this.addRenderableWidget(Button.builder(Component.literal("Ketsuryugan"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new NarutoShippudenCheatDojutsuGUIGui.ButtonPressedMessage(2, x, y, z));
					NarutoShippudenCheatDojutsuGUIGui.handleButtonAction(entity, 2, x, y, z);
				}
			}).bounds(this.leftPos + -119, this.topPos + 29, 77, 20).build());
			this.addRenderableWidget(Button.builder(Component.literal("Back"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new NarutoShippudenCheatDojutsuGUIGui.ButtonPressedMessage(3, x, y, z));
					NarutoShippudenCheatDojutsuGUIGui.handleButtonAction(entity, 3, x, y, z);
				}
			}).bounds(this.leftPos + 176, this.topPos + 54, 61, 20).build());
			this.addRenderableWidget(Button.builder(Component.literal("Sharingan"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new NarutoShippudenCheatDojutsuGUIGui.ButtonPressedMessage(4, x, y, z));
					NarutoShippudenCheatDojutsuGUIGui.handleButtonAction(entity, 4, x, y, z);
				}
			}).bounds(this.leftPos + 39, this.topPos + -11, 103, 20).build());
			this.addRenderableWidget(Button.builder(Component.literal("Byakugan"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new NarutoShippudenCheatDojutsuGUIGui.ButtonPressedMessage(5, x, y, z));
					NarutoShippudenCheatDojutsuGUIGui.handleButtonAction(entity, 5, x, y, z);
				}
			}).bounds(this.leftPos + 39, this.topPos + 9, 103, 20).build());
			this.addRenderableWidget(Button.builder(Component.literal("Ketsuryugan"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new NarutoShippudenCheatDojutsuGUIGui.ButtonPressedMessage(6, x, y, z));
					NarutoShippudenCheatDojutsuGUIGui.handleButtonAction(entity, 6, x, y, z);
				}
			}).bounds(this.leftPos + 39, this.topPos + 29, 103, 20).build());
			this.addRenderableWidget(Button.builder(Component.literal("Reset Dojutsu"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new NarutoShippudenCheatDojutsuGUIGui.ButtonPressedMessage(7, x, y, z));
					NarutoShippudenCheatDojutsuGUIGui.handleButtonAction(entity, 7, x, y, z);
				}
			}).bounds(this.leftPos + -119, this.topPos + 169, 136, 20).build());
			this.addRenderableWidget(Button.builder(Component.literal("Isshiki Dojutsu"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new NarutoShippudenCheatDojutsuGUIGui.ButtonPressedMessage(8, x, y, z));
					NarutoShippudenCheatDojutsuGUIGui.handleButtonAction(entity, 8, x, y, z);
				}
			}).bounds(this.leftPos + -119, this.topPos + 109, 77, 20).build());
			this.addRenderableWidget(Button.builder(Component.literal("Mangekyou Sharingan"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new NarutoShippudenCheatDojutsuGUIGui.ButtonPressedMessage(9, x, y, z));
					NarutoShippudenCheatDojutsuGUIGui.handleButtonAction(entity, 9, x, y, z);
				}
			}).bounds(this.leftPos + -119, this.topPos + 49, 77, 20).build());
			this.addRenderableWidget(Button.builder(Component.literal("Kakashi Sharingan"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new NarutoShippudenCheatDojutsuGUIGui.ButtonPressedMessage(10, x, y, z));
					NarutoShippudenCheatDojutsuGUIGui.handleButtonAction(entity, 10, x, y, z);
				}
			}).bounds(this.leftPos + -42, this.topPos + -11, 80, 20).build());
			this.addRenderableWidget(Button.builder(Component.literal("Rinnegan"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new NarutoShippudenCheatDojutsuGUIGui.ButtonPressedMessage(11, x, y, z));
					NarutoShippudenCheatDojutsuGUIGui.handleButtonAction(entity, 11, x, y, z);
				}
			}).bounds(this.leftPos + -119, this.topPos + 69, 77, 20).build());
			this.addRenderableWidget(Button.builder(Component.literal("Tenseigan"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new NarutoShippudenCheatDojutsuGUIGui.ButtonPressedMessage(12, x, y, z));
					NarutoShippudenCheatDojutsuGUIGui.handleButtonAction(entity, 12, x, y, z);
				}
			}).bounds(this.leftPos + -119, this.topPos + 89, 77, 20).build());
			this.addRenderableWidget(Button.builder(Component.literal("Tenseigan"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new NarutoShippudenCheatDojutsuGUIGui.ButtonPressedMessage(13, x, y, z));
					NarutoShippudenCheatDojutsuGUIGui.handleButtonAction(entity, 13, x, y, z);
				}
			}).bounds(this.leftPos + 39, this.topPos + 49, 103, 20).build());
			this.addRenderableWidget(Button.builder(Component.literal("Isshiki Dojutsu"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new NarutoShippudenCheatDojutsuGUIGui.ButtonPressedMessage(14, x, y, z));
					NarutoShippudenCheatDojutsuGUIGui.handleButtonAction(entity, 14, x, y, z);
				}
			}).bounds(this.leftPos + 39, this.topPos + 69, 103, 20).build());
			this.addRenderableWidget(Button.builder(Component.literal("Shimura Sharingan"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new NarutoShippudenCheatDojutsuGUIGui.ButtonPressedMessage(15, x, y, z));
					NarutoShippudenCheatDojutsuGUIGui.handleButtonAction(entity, 15, x, y, z);
				}
			}).bounds(this.leftPos + -42, this.topPos + 9, 80, 20).build());
			this.addRenderableWidget(Button.builder(Component.literal("Kakashi Sharingan"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new NarutoShippudenCheatDojutsuGUIGui.ButtonPressedMessage(16, x, y, z));
					NarutoShippudenCheatDojutsuGUIGui.handleButtonAction(entity, 16, x, y, z);
				}
			}).bounds(this.leftPos + 39, this.topPos + 89, 103, 20).build());
			this.addRenderableWidget(Button.builder(Component.literal("Shimura Sharingan"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new NarutoShippudenCheatDojutsuGUIGui.ButtonPressedMessage(17, x, y, z));
					NarutoShippudenCheatDojutsuGUIGui.handleButtonAction(entity, 17, x, y, z);
				}
			}).bounds(this.leftPos + 39, this.topPos + 109, 103, 20).build());
		}
	}

	public static class NarutoShippudenCheatGUIGuiWindow extends AbstractContainerScreen<NarutoShippudenCheatGUIGui.GuiContainerMod> {
		private Level world;
		private int x, y, z;
		private Player entity;
		private final static HashMap guistate = NarutoShippudenCheatGUIGui.guistate;

		public NarutoShippudenCheatGUIGuiWindow(NarutoShippudenCheatGUIGui.GuiContainerMod container, Inventory inventory, Component text) {
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
			return super.keyPressed(event);
		}

		@Override
		protected void containerTick() {
		}

		@Override
		protected void extractLabels(GuiGraphicsExtractor graphics, int mouseX, int mouseY) {
			graphics.text(this.font, "Rank Set:", 18, 119, -1, false);
		}

		@Override
		public void removed() {
			super.removed();
		}

		@Override
		protected void init() {
			super.init();
			this.addRenderableWidget(Button.builder(Component.literal("+100JP"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new NarutoShippudenCheatGUIGui.ButtonPressedMessage(0, x, y, z));
					NarutoShippudenCheatGUIGui.handleButtonAction(entity, 0, x, y, z);
				}
			}).bounds(this.leftPos + 18, this.topPos + 54, 34, 20).build());
			this.addRenderableWidget(Button.builder(Component.literal("+10JP"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new NarutoShippudenCheatGUIGui.ButtonPressedMessage(1, x, y, z));
					NarutoShippudenCheatGUIGui.handleButtonAction(entity, 1, x, y, z);
				}
			}).bounds(this.leftPos + 18, this.topPos + 74, 34, 20).build());
			this.addRenderableWidget(Button.builder(Component.literal("+100SP"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new NarutoShippudenCheatGUIGui.ButtonPressedMessage(2, x, y, z));
					NarutoShippudenCheatGUIGui.handleButtonAction(entity, 2, x, y, z);
				}
			}).bounds(this.leftPos + 52, this.topPos + 54, 34, 20).build());
			this.addRenderableWidget(Button.builder(Component.literal("+10SP"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new NarutoShippudenCheatGUIGui.ButtonPressedMessage(3, x, y, z));
					NarutoShippudenCheatGUIGui.handleButtonAction(entity, 3, x, y, z);
				}
			}).bounds(this.leftPos + 52, this.topPos + 74, 34, 20).build());
			this.addRenderableWidget(Button.builder(Component.literal("-100JP"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new NarutoShippudenCheatGUIGui.ButtonPressedMessage(4, x, y, z));
					NarutoShippudenCheatGUIGui.handleButtonAction(entity, 4, x, y, z);
				}
			}).bounds(this.leftPos + 86, this.topPos + 54, 34, 20).build());
			this.addRenderableWidget(Button.builder(Component.literal("Add Max Chakra"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new NarutoShippudenCheatGUIGui.ButtonPressedMessage(5, x, y, z));
					NarutoShippudenCheatGUIGui.handleButtonAction(entity, 5, x, y, z);
				}
			}).bounds(this.leftPos + 18, this.topPos + 94, 136, 20).build());
			this.addRenderableWidget(Button.builder(Component.literal("-10JP"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new NarutoShippudenCheatGUIGui.ButtonPressedMessage(6, x, y, z));
					NarutoShippudenCheatGUIGui.handleButtonAction(entity, 6, x, y, z);
				}
			}).bounds(this.leftPos + 86, this.topPos + 74, 34, 20).build());
			this.addRenderableWidget(Button.builder(Component.literal("-100SP"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new NarutoShippudenCheatGUIGui.ButtonPressedMessage(7, x, y, z));
					NarutoShippudenCheatGUIGui.handleButtonAction(entity, 7, x, y, z);
				}
			}).bounds(this.leftPos + 120, this.topPos + 54, 34, 20).build());
			this.addRenderableWidget(Button.builder(Component.literal("-10SP"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new NarutoShippudenCheatGUIGui.ButtonPressedMessage(8, x, y, z));
					NarutoShippudenCheatGUIGui.handleButtonAction(entity, 8, x, y, z);
				}
			}).bounds(this.leftPos + 120, this.topPos + 74, 34, 20).build());
			this.addRenderableWidget(Button.builder(Component.literal("Genin"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new NarutoShippudenCheatGUIGui.ButtonPressedMessage(9, x, y, z));
					NarutoShippudenCheatGUIGui.handleButtonAction(entity, 9, x, y, z);
				}
			}).bounds(this.leftPos + 18, this.topPos + 134, 34, 20).build());
			this.addRenderableWidget(Button.builder(Component.literal("Academy Student"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new NarutoShippudenCheatGUIGui.ButtonPressedMessage(10, x, y, z));
					NarutoShippudenCheatGUIGui.handleButtonAction(entity, 10, x, y, z);
				}
			}).bounds(this.leftPos + 66, this.topPos + 114, 89, 20).build());
			this.addRenderableWidget(Button.builder(Component.literal("Chunin"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new NarutoShippudenCheatGUIGui.ButtonPressedMessage(11, x, y, z));
					NarutoShippudenCheatGUIGui.handleButtonAction(entity, 11, x, y, z);
				}
			}).bounds(this.leftPos + 52, this.topPos + 134, 34, 20).build());
			this.addRenderableWidget(Button.builder(Component.literal("Jonin"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new NarutoShippudenCheatGUIGui.ButtonPressedMessage(12, x, y, z));
					NarutoShippudenCheatGUIGui.handleButtonAction(entity, 12, x, y, z);
				}
			}).bounds(this.leftPos + 86, this.topPos + 134, 34, 20).build());
			this.addRenderableWidget(Button.builder(Component.literal("Kage"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new NarutoShippudenCheatGUIGui.ButtonPressedMessage(13, x, y, z));
					NarutoShippudenCheatGUIGui.handleButtonAction(entity, 13, x, y, z);
				}
			}).bounds(this.leftPos + 120, this.topPos + 134, 34, 20).build());
			this.addRenderableWidget(Button.builder(Component.literal("Dojutsu"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new NarutoShippudenCheatGUIGui.ButtonPressedMessage(14, x, y, z));
					NarutoShippudenCheatGUIGui.handleButtonAction(entity, 14, x, y, z);
				}
			}).bounds(this.leftPos + 176, this.topPos + 54, 70, 20).build());
			this.addRenderableWidget(Button.builder(Component.literal("Kekkei Genkai"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new NarutoShippudenCheatGUIGui.ButtonPressedMessage(15, x, y, z));
					NarutoShippudenCheatGUIGui.handleButtonAction(entity, 15, x, y, z);
				}
			}).bounds(this.leftPos + 176, this.topPos + 74, 70, 20).build());
			this.addRenderableWidget(Button.builder(Component.literal("Reset Upgrading Stats"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new NarutoShippudenCheatGUIGui.ButtonPressedMessage(16, x, y, z));
					NarutoShippudenCheatGUIGui.handleButtonAction(entity, 16, x, y, z);
				}
			}).bounds(this.leftPos + 18, this.topPos + 154, 136, 20).build());
			this.addRenderableWidget(Button.builder(Component.literal("Reset Info Stats"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new NarutoShippudenCheatGUIGui.ButtonPressedMessage(17, x, y, z));
					NarutoShippudenCheatGUIGui.handleButtonAction(entity, 17, x, y, z);
				}
			}).bounds(this.leftPos + 18, this.topPos + 174, 136, 20).build());
			this.addRenderableWidget(Button.builder(Component.literal("Select Menu"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new NarutoShippudenCheatGUIGui.ButtonPressedMessage(18, x, y, z));
					NarutoShippudenCheatGUIGui.handleButtonAction(entity, 18, x, y, z);
				}
			}).bounds(this.leftPos + 18, this.topPos + 194, 136, 20).build());
			this.addRenderableWidget(Button.builder(Component.literal("Reset LEVEL & JP & SP"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new NarutoShippudenCheatGUIGui.ButtonPressedMessage(19, x, y, z));
					NarutoShippudenCheatGUIGui.handleButtonAction(entity, 19, x, y, z);
				}
			}).bounds(this.leftPos + 18, this.topPos + 34, 136, 20).build());
			this.addRenderableWidget(Button.builder(Component.literal("+100 LvL XP"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new NarutoShippudenCheatGUIGui.ButtonPressedMessage(20, x, y, z));
					NarutoShippudenCheatGUIGui.handleButtonAction(entity, 20, x, y, z);
				}
			}).bounds(this.leftPos + 18, this.topPos + 14, 136, 20).build());
		}
	}

	public static class NarutoShippudenCheatKekkeiGenkaiGUIGuiWindow extends AbstractContainerScreen<NarutoShippudenCheatKekkeiGenkaiGUIGui.GuiContainerMod> {
		private Level world;
		private int x, y, z;
		private Player entity;
		private final static HashMap guistate = NarutoShippudenCheatKekkeiGenkaiGUIGui.guistate;

		public NarutoShippudenCheatKekkeiGenkaiGUIGuiWindow(NarutoShippudenCheatKekkeiGenkaiGUIGui.GuiContainerMod container, Inventory inventory,
				Component text) {
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
			this.addRenderableWidget(Button.builder(Component.literal("Wood Release"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new NarutoShippudenCheatKekkeiGenkaiGUIGui.ButtonPressedMessage(0, x, y, z));
					NarutoShippudenCheatKekkeiGenkaiGUIGui.handleButtonAction(entity, 0, x, y, z);
				}
			}).bounds(this.leftPos + 0, this.topPos + 54, 68, 20).build());
			this.addRenderableWidget(Button.builder(Component.literal("Lava Release"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new NarutoShippudenCheatKekkeiGenkaiGUIGui.ButtonPressedMessage(1, x, y, z));
					NarutoShippudenCheatKekkeiGenkaiGUIGui.handleButtonAction(entity, 1, x, y, z);
				}
			}).bounds(this.leftPos + 0, this.topPos + 74, 68, 20).build());
			this.addRenderableWidget(Button.builder(Component.literal("Smoke Release"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new NarutoShippudenCheatKekkeiGenkaiGUIGui.ButtonPressedMessage(2, x, y, z));
					NarutoShippudenCheatKekkeiGenkaiGUIGui.handleButtonAction(entity, 2, x, y, z);
				}
			}).bounds(this.leftPos + 107, this.topPos + 74, 68, 20).build());
			this.addRenderableWidget(Button.builder(Component.literal("Back"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new NarutoShippudenCheatKekkeiGenkaiGUIGui.ButtonPressedMessage(3, x, y, z));
					NarutoShippudenCheatKekkeiGenkaiGUIGui.handleButtonAction(entity, 3, x, y, z);
				}
			}).bounds(this.leftPos + 176, this.topPos + 54, 61, 20).build());
			this.addRenderableWidget(Button.builder(Component.literal("Ice Release"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new NarutoShippudenCheatKekkeiGenkaiGUIGui.ButtonPressedMessage(4, x, y, z));
					NarutoShippudenCheatKekkeiGenkaiGUIGui.handleButtonAction(entity, 4, x, y, z);
				}
			}).bounds(this.leftPos + 107, this.topPos + 54, 68, 20).build());
			this.addRenderableWidget(Button.builder(Component.literal("Storm Release"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new NarutoShippudenCheatKekkeiGenkaiGUIGui.ButtonPressedMessage(5, x, y, z));
					NarutoShippudenCheatKekkeiGenkaiGUIGui.handleButtonAction(entity, 5, x, y, z);
				}
			}).bounds(this.leftPos + 0, this.topPos + 94, 68, 20).build());
			this.addRenderableWidget(Button.builder(Component.literal("Boil Release"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new NarutoShippudenCheatKekkeiGenkaiGUIGui.ButtonPressedMessage(6, x, y, z));
					NarutoShippudenCheatKekkeiGenkaiGUIGui.handleButtonAction(entity, 6, x, y, z);
				}
			}).bounds(this.leftPos + 107, this.topPos + 94, 68, 20).build());
			this.addRenderableWidget(Button.builder(Component.literal("Dust Release"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new NarutoShippudenCheatKekkeiGenkaiGUIGui.ButtonPressedMessage(7, x, y, z));
					NarutoShippudenCheatKekkeiGenkaiGUIGui.handleButtonAction(entity, 7, x, y, z);
				}
			}).bounds(this.leftPos + 0, this.topPos + 114, 68, 20).build());
			this.addRenderableWidget(Button.builder(Component.literal("Steel Release"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new NarutoShippudenCheatKekkeiGenkaiGUIGui.ButtonPressedMessage(8, x, y, z));
					NarutoShippudenCheatKekkeiGenkaiGUIGui.handleButtonAction(entity, 8, x, y, z);
				}
			}).bounds(this.leftPos + 107, this.topPos + 114, 68, 20).build());
			this.addRenderableWidget(Button.builder(Component.literal("Swift Release"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new NarutoShippudenCheatKekkeiGenkaiGUIGui.ButtonPressedMessage(9, x, y, z));
					NarutoShippudenCheatKekkeiGenkaiGUIGui.handleButtonAction(entity, 9, x, y, z);
				}
			}).bounds(this.leftPos + 0, this.topPos + 134, 68, 20).build());
			this.addRenderableWidget(Button.builder(Component.literal("Paper Release"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new NarutoShippudenCheatKekkeiGenkaiGUIGui.ButtonPressedMessage(10, x, y, z));
					NarutoShippudenCheatKekkeiGenkaiGUIGui.handleButtonAction(entity, 10, x, y, z);
				}
			}).bounds(this.leftPos + 107, this.topPos + 134, 68, 20).build());
			this.addRenderableWidget(Button.builder(Component.literal("Inferno Release"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new NarutoShippudenCheatKekkeiGenkaiGUIGui.ButtonPressedMessage(11, x, y, z));
					NarutoShippudenCheatKekkeiGenkaiGUIGui.handleButtonAction(entity, 11, x, y, z);
				}
			}).bounds(this.leftPos + -108, this.topPos + 54, 87, 20).build());
			this.addRenderableWidget(Button.builder(Component.literal("Explosion Release"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new NarutoShippudenCheatKekkeiGenkaiGUIGui.ButtonPressedMessage(12, x, y, z));
					NarutoShippudenCheatKekkeiGenkaiGUIGui.handleButtonAction(entity, 12, x, y, z);
				}
			}).bounds(this.leftPos + -108, this.topPos + 74, 87, 20).build());
			this.addRenderableWidget(Button.builder(Component.literal("Typhoon Release"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new NarutoShippudenCheatKekkeiGenkaiGUIGui.ButtonPressedMessage(13, x, y, z));
					NarutoShippudenCheatKekkeiGenkaiGUIGui.handleButtonAction(entity, 13, x, y, z);
				}
			}).bounds(this.leftPos + -108, this.topPos + 94, 87, 20).build());
			this.addRenderableWidget(Button.builder(Component.literal("Manget Release"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new NarutoShippudenCheatKekkeiGenkaiGUIGui.ButtonPressedMessage(14, x, y, z));
					NarutoShippudenCheatKekkeiGenkaiGUIGui.handleButtonAction(entity, 14, x, y, z);
				}
			}).bounds(this.leftPos + -108, this.topPos + 114, 87, 20).build());
			this.addRenderableWidget(Button.builder(Component.literal("Bone Release"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new NarutoShippudenCheatKekkeiGenkaiGUIGui.ButtonPressedMessage(15, x, y, z));
					NarutoShippudenCheatKekkeiGenkaiGUIGui.handleButtonAction(entity, 15, x, y, z);
				}
			}).bounds(this.leftPos + -108, this.topPos + 134, 87, 20).build());
		}
	}

	public static class PasswordGUIDojutsuGuiWindow extends AbstractContainerScreen<PasswordGUIDojutsuGui.GuiContainerMod> {
		private Level world;
		private int x, y, z;
		private Player entity;
		private final static HashMap guistate = PasswordGUIDojutsuGui.guistate;
		EditBox Password;

		public PasswordGUIDojutsuGuiWindow(PasswordGUIDojutsuGui.GuiContainerMod container, Inventory inventory, Component text) {
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
			if (Password.isFocused())
				return Password.keyPressed(event);
			return super.keyPressed(event);
		}

		@Override
		protected void containerTick() {
		}

		@Override
		protected void extractLabels(GuiGraphicsExtractor graphics, int mouseX, int mouseY) {
			graphics.text(this.font, "Enter Password:", 47, 33, -1, false);
		}

		@Override
		public void removed() {
			super.removed();
		}

		@Override
		protected void init() {
			super.init();
			Password = new EditBox(this.font, this.leftPos + 24, this.topPos + 43, 126, 20, Component.literal(""));
			guistate.put("text:Password", Password);
			Password.setMaxLength(32767);
			this.addRenderableWidget(this.Password);
			this.addRenderableWidget(Button.builder(Component.literal("Login"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new PasswordGUIDojutsuGui.ButtonPressedMessage(0, x, y, z));
					PasswordGUIDojutsuGui.handleButtonAction(entity, 0, x, y, z);
				}
			}).bounds(this.leftPos + 60, this.topPos + 70, 51, 20).build());
		}
	}
}
