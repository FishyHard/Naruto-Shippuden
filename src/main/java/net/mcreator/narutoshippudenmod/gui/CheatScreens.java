package net.mcreator.narutoshippudenmod.gui;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import java.util.HashMap;
import net.mcreator.narutoshippudenmod.NarutoShippudenMod;
import net.mcreator.narutoshippudenmod.gui.CheatGuis.MangekyouSharinganCheatGui;
import net.mcreator.narutoshippudenmod.gui.CheatGuis.NarutoShippudenCheatDojutsuGUIGui;
import net.mcreator.narutoshippudenmod.gui.CheatGuis.NarutoShippudenCheatGUIGui;
import net.mcreator.narutoshippudenmod.gui.CheatGuis.NarutoShippudenCheatKekkeiGenkaiGUIGui;
import net.mcreator.narutoshippudenmod.gui.CheatGuis.PasswordGUIDojutsuGui;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public final class CheatScreens {
	private CheatScreens() {
	}

	@OnlyIn(Dist.CLIENT)
	public static class MangekyouSharinganCheatGuiWindow extends ContainerScreen<MangekyouSharinganCheatGui.GuiContainerMod> {
		private World world;
		private int x, y, z;
		private PlayerEntity entity;
		private final static HashMap guistate = MangekyouSharinganCheatGui.guistate;

		public MangekyouSharinganCheatGuiWindow(MangekyouSharinganCheatGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
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
			this.addButton(new Button(this.guiLeft + -119, this.guiTop + -29, 90, 20, new StringTextComponent("Sasuke"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new MangekyouSharinganCheatGui.ButtonPressedMessage(0, x, y, z));
					MangekyouSharinganCheatGui.handleButtonAction(entity, 0, x, y, z);
				}
			}));
			this.addButton(new Button(this.guiLeft + -119, this.guiTop + 11, 90, 20, new StringTextComponent("Madara"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new MangekyouSharinganCheatGui.ButtonPressedMessage(1, x, y, z));
					MangekyouSharinganCheatGui.handleButtonAction(entity, 1, x, y, z);
				}
			}));
			this.addButton(new Button(this.guiLeft + -119, this.guiTop + -9, 90, 20, new StringTextComponent("Itachi"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new MangekyouSharinganCheatGui.ButtonPressedMessage(2, x, y, z));
					MangekyouSharinganCheatGui.handleButtonAction(entity, 2, x, y, z);
				}
			}));
			this.addButton(new Button(this.guiLeft + -119, this.guiTop + 31, 90, 20, new StringTextComponent("Obito"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new MangekyouSharinganCheatGui.ButtonPressedMessage(3, x, y, z));
					MangekyouSharinganCheatGui.handleButtonAction(entity, 3, x, y, z);
				}
			}));
			this.addButton(new Button(this.guiLeft + -119, this.guiTop + 51, 90, 20, new StringTextComponent("Shisui"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new MangekyouSharinganCheatGui.ButtonPressedMessage(4, x, y, z));
					MangekyouSharinganCheatGui.handleButtonAction(entity, 4, x, y, z);
				}
			}));
			this.addButton(new Button(this.guiLeft + -119, this.guiTop + 71, 90, 20, new StringTextComponent("Kakashi"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new MangekyouSharinganCheatGui.ButtonPressedMessage(5, x, y, z));
					MangekyouSharinganCheatGui.handleButtonAction(entity, 5, x, y, z);
				}
			}));
		}
	}

	@OnlyIn(Dist.CLIENT)
	public static class NarutoShippudenCheatDojutsuGUIGuiWindow extends ContainerScreen<NarutoShippudenCheatDojutsuGUIGui.GuiContainerMod> {
		private World world;
		private int x, y, z;
		private PlayerEntity entity;
		private final static HashMap guistate = NarutoShippudenCheatDojutsuGUIGui.guistate;

		public NarutoShippudenCheatDojutsuGUIGuiWindow(NarutoShippudenCheatDojutsuGUIGui.GuiContainerMod container, PlayerInventory inventory,
				ITextComponent text) {
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
			this.font.drawString(ms, "Give Instantly:", -119, -29, -1);
			this.font.drawString(ms, "Awake in 10 seconds:", 39, -29, -1);
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
			this.addButton(new Button(this.guiLeft + -119, this.guiTop + -11, 77, 20, new StringTextComponent("Sharingan"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new NarutoShippudenCheatDojutsuGUIGui.ButtonPressedMessage(0, x, y, z));
					NarutoShippudenCheatDojutsuGUIGui.handleButtonAction(entity, 0, x, y, z);
				}
			}));
			this.addButton(new Button(this.guiLeft + -119, this.guiTop + 9, 77, 20, new StringTextComponent("Byakugan"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new NarutoShippudenCheatDojutsuGUIGui.ButtonPressedMessage(1, x, y, z));
					NarutoShippudenCheatDojutsuGUIGui.handleButtonAction(entity, 1, x, y, z);
				}
			}));
			this.addButton(new Button(this.guiLeft + -119, this.guiTop + 29, 77, 20, new StringTextComponent("Ketsuryugan"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new NarutoShippudenCheatDojutsuGUIGui.ButtonPressedMessage(2, x, y, z));
					NarutoShippudenCheatDojutsuGUIGui.handleButtonAction(entity, 2, x, y, z);
				}
			}));
			this.addButton(new Button(this.guiLeft + 176, this.guiTop + 54, 61, 20, new StringTextComponent("Back"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new NarutoShippudenCheatDojutsuGUIGui.ButtonPressedMessage(3, x, y, z));
					NarutoShippudenCheatDojutsuGUIGui.handleButtonAction(entity, 3, x, y, z);
				}
			}));
			this.addButton(new Button(this.guiLeft + 39, this.guiTop + -11, 103, 20, new StringTextComponent("Sharingan"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new NarutoShippudenCheatDojutsuGUIGui.ButtonPressedMessage(4, x, y, z));
					NarutoShippudenCheatDojutsuGUIGui.handleButtonAction(entity, 4, x, y, z);
				}
			}));
			this.addButton(new Button(this.guiLeft + 39, this.guiTop + 9, 103, 20, new StringTextComponent("Byakugan"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new NarutoShippudenCheatDojutsuGUIGui.ButtonPressedMessage(5, x, y, z));
					NarutoShippudenCheatDojutsuGUIGui.handleButtonAction(entity, 5, x, y, z);
				}
			}));
			this.addButton(new Button(this.guiLeft + 39, this.guiTop + 29, 103, 20, new StringTextComponent("Ketsuryugan"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new NarutoShippudenCheatDojutsuGUIGui.ButtonPressedMessage(6, x, y, z));
					NarutoShippudenCheatDojutsuGUIGui.handleButtonAction(entity, 6, x, y, z);
				}
			}));
			this.addButton(new Button(this.guiLeft + -119, this.guiTop + 169, 136, 20, new StringTextComponent("Reset Dojutsu"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new NarutoShippudenCheatDojutsuGUIGui.ButtonPressedMessage(7, x, y, z));
					NarutoShippudenCheatDojutsuGUIGui.handleButtonAction(entity, 7, x, y, z);
				}
			}));
			this.addButton(new Button(this.guiLeft + -119, this.guiTop + 109, 77, 20, new StringTextComponent("Isshiki Dojutsu"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new NarutoShippudenCheatDojutsuGUIGui.ButtonPressedMessage(8, x, y, z));
					NarutoShippudenCheatDojutsuGUIGui.handleButtonAction(entity, 8, x, y, z);
				}
			}));
			this.addButton(new Button(this.guiLeft + -119, this.guiTop + 49, 77, 20, new StringTextComponent("Mangekyou Sharingan"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new NarutoShippudenCheatDojutsuGUIGui.ButtonPressedMessage(9, x, y, z));
					NarutoShippudenCheatDojutsuGUIGui.handleButtonAction(entity, 9, x, y, z);
				}
			}));
			this.addButton(new Button(this.guiLeft + -42, this.guiTop + -11, 80, 20, new StringTextComponent("Kakashi Sharingan"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new NarutoShippudenCheatDojutsuGUIGui.ButtonPressedMessage(10, x, y, z));
					NarutoShippudenCheatDojutsuGUIGui.handleButtonAction(entity, 10, x, y, z);
				}
			}));
			this.addButton(new Button(this.guiLeft + -119, this.guiTop + 69, 77, 20, new StringTextComponent("Rinnegan"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new NarutoShippudenCheatDojutsuGUIGui.ButtonPressedMessage(11, x, y, z));
					NarutoShippudenCheatDojutsuGUIGui.handleButtonAction(entity, 11, x, y, z);
				}
			}));
			this.addButton(new Button(this.guiLeft + -119, this.guiTop + 89, 77, 20, new StringTextComponent("Tenseigan"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new NarutoShippudenCheatDojutsuGUIGui.ButtonPressedMessage(12, x, y, z));
					NarutoShippudenCheatDojutsuGUIGui.handleButtonAction(entity, 12, x, y, z);
				}
			}));
			this.addButton(new Button(this.guiLeft + 39, this.guiTop + 49, 103, 20, new StringTextComponent("Tenseigan"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new NarutoShippudenCheatDojutsuGUIGui.ButtonPressedMessage(13, x, y, z));
					NarutoShippudenCheatDojutsuGUIGui.handleButtonAction(entity, 13, x, y, z);
				}
			}));
			this.addButton(new Button(this.guiLeft + 39, this.guiTop + 69, 103, 20, new StringTextComponent("Isshiki Dojutsu"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new NarutoShippudenCheatDojutsuGUIGui.ButtonPressedMessage(14, x, y, z));
					NarutoShippudenCheatDojutsuGUIGui.handleButtonAction(entity, 14, x, y, z);
				}
			}));
			this.addButton(new Button(this.guiLeft + -42, this.guiTop + 9, 80, 20, new StringTextComponent("Shimura Sharingan"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new NarutoShippudenCheatDojutsuGUIGui.ButtonPressedMessage(15, x, y, z));
					NarutoShippudenCheatDojutsuGUIGui.handleButtonAction(entity, 15, x, y, z);
				}
			}));
			this.addButton(new Button(this.guiLeft + 39, this.guiTop + 89, 103, 20, new StringTextComponent("Kakashi Sharingan"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new NarutoShippudenCheatDojutsuGUIGui.ButtonPressedMessage(16, x, y, z));
					NarutoShippudenCheatDojutsuGUIGui.handleButtonAction(entity, 16, x, y, z);
				}
			}));
			this.addButton(new Button(this.guiLeft + 39, this.guiTop + 109, 103, 20, new StringTextComponent("Shimura Sharingan"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new NarutoShippudenCheatDojutsuGUIGui.ButtonPressedMessage(17, x, y, z));
					NarutoShippudenCheatDojutsuGUIGui.handleButtonAction(entity, 17, x, y, z);
				}
			}));
		}
	}

	@OnlyIn(Dist.CLIENT)
	public static class NarutoShippudenCheatGUIGuiWindow extends ContainerScreen<NarutoShippudenCheatGUIGui.GuiContainerMod> {
		private World world;
		private int x, y, z;
		private PlayerEntity entity;
		private final static HashMap guistate = NarutoShippudenCheatGUIGui.guistate;

		public NarutoShippudenCheatGUIGuiWindow(NarutoShippudenCheatGUIGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
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
			this.font.drawString(ms, "Rank Set:", 18, 119, -1);
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
			this.addButton(new Button(this.guiLeft + 18, this.guiTop + 54, 34, 20, new StringTextComponent("+100JP"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new NarutoShippudenCheatGUIGui.ButtonPressedMessage(0, x, y, z));
					NarutoShippudenCheatGUIGui.handleButtonAction(entity, 0, x, y, z);
				}
			}));
			this.addButton(new Button(this.guiLeft + 18, this.guiTop + 74, 34, 20, new StringTextComponent("+10JP"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new NarutoShippudenCheatGUIGui.ButtonPressedMessage(1, x, y, z));
					NarutoShippudenCheatGUIGui.handleButtonAction(entity, 1, x, y, z);
				}
			}));
			this.addButton(new Button(this.guiLeft + 52, this.guiTop + 54, 34, 20, new StringTextComponent("+100SP"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new NarutoShippudenCheatGUIGui.ButtonPressedMessage(2, x, y, z));
					NarutoShippudenCheatGUIGui.handleButtonAction(entity, 2, x, y, z);
				}
			}));
			this.addButton(new Button(this.guiLeft + 52, this.guiTop + 74, 34, 20, new StringTextComponent("+10SP"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new NarutoShippudenCheatGUIGui.ButtonPressedMessage(3, x, y, z));
					NarutoShippudenCheatGUIGui.handleButtonAction(entity, 3, x, y, z);
				}
			}));
			this.addButton(new Button(this.guiLeft + 86, this.guiTop + 54, 34, 20, new StringTextComponent("-100JP"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new NarutoShippudenCheatGUIGui.ButtonPressedMessage(4, x, y, z));
					NarutoShippudenCheatGUIGui.handleButtonAction(entity, 4, x, y, z);
				}
			}));
			this.addButton(new Button(this.guiLeft + 18, this.guiTop + 94, 136, 20, new StringTextComponent("Add Max Chakra"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new NarutoShippudenCheatGUIGui.ButtonPressedMessage(5, x, y, z));
					NarutoShippudenCheatGUIGui.handleButtonAction(entity, 5, x, y, z);
				}
			}));
			this.addButton(new Button(this.guiLeft + 86, this.guiTop + 74, 34, 20, new StringTextComponent("-10JP"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new NarutoShippudenCheatGUIGui.ButtonPressedMessage(6, x, y, z));
					NarutoShippudenCheatGUIGui.handleButtonAction(entity, 6, x, y, z);
				}
			}));
			this.addButton(new Button(this.guiLeft + 120, this.guiTop + 54, 34, 20, new StringTextComponent("-100SP"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new NarutoShippudenCheatGUIGui.ButtonPressedMessage(7, x, y, z));
					NarutoShippudenCheatGUIGui.handleButtonAction(entity, 7, x, y, z);
				}
			}));
			this.addButton(new Button(this.guiLeft + 120, this.guiTop + 74, 34, 20, new StringTextComponent("-10SP"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new NarutoShippudenCheatGUIGui.ButtonPressedMessage(8, x, y, z));
					NarutoShippudenCheatGUIGui.handleButtonAction(entity, 8, x, y, z);
				}
			}));
			this.addButton(new Button(this.guiLeft + 18, this.guiTop + 134, 34, 20, new StringTextComponent("Genin"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new NarutoShippudenCheatGUIGui.ButtonPressedMessage(9, x, y, z));
					NarutoShippudenCheatGUIGui.handleButtonAction(entity, 9, x, y, z);
				}
			}));
			this.addButton(new Button(this.guiLeft + 66, this.guiTop + 114, 89, 20, new StringTextComponent("Academy Student"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new NarutoShippudenCheatGUIGui.ButtonPressedMessage(10, x, y, z));
					NarutoShippudenCheatGUIGui.handleButtonAction(entity, 10, x, y, z);
				}
			}));
			this.addButton(new Button(this.guiLeft + 52, this.guiTop + 134, 34, 20, new StringTextComponent("Chunin"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new NarutoShippudenCheatGUIGui.ButtonPressedMessage(11, x, y, z));
					NarutoShippudenCheatGUIGui.handleButtonAction(entity, 11, x, y, z);
				}
			}));
			this.addButton(new Button(this.guiLeft + 86, this.guiTop + 134, 34, 20, new StringTextComponent("Jonin"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new NarutoShippudenCheatGUIGui.ButtonPressedMessage(12, x, y, z));
					NarutoShippudenCheatGUIGui.handleButtonAction(entity, 12, x, y, z);
				}
			}));
			this.addButton(new Button(this.guiLeft + 120, this.guiTop + 134, 34, 20, new StringTextComponent("Kage"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new NarutoShippudenCheatGUIGui.ButtonPressedMessage(13, x, y, z));
					NarutoShippudenCheatGUIGui.handleButtonAction(entity, 13, x, y, z);
				}
			}));
			this.addButton(new Button(this.guiLeft + 176, this.guiTop + 54, 70, 20, new StringTextComponent("Dojutsu"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new NarutoShippudenCheatGUIGui.ButtonPressedMessage(14, x, y, z));
					NarutoShippudenCheatGUIGui.handleButtonAction(entity, 14, x, y, z);
				}
			}));
			this.addButton(new Button(this.guiLeft + 176, this.guiTop + 74, 70, 20, new StringTextComponent("Kekkei Genkai"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new NarutoShippudenCheatGUIGui.ButtonPressedMessage(15, x, y, z));
					NarutoShippudenCheatGUIGui.handleButtonAction(entity, 15, x, y, z);
				}
			}));
			this.addButton(new Button(this.guiLeft + 18, this.guiTop + 154, 136, 20, new StringTextComponent("Reset Upgrading Stats"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new NarutoShippudenCheatGUIGui.ButtonPressedMessage(16, x, y, z));
					NarutoShippudenCheatGUIGui.handleButtonAction(entity, 16, x, y, z);
				}
			}));
			this.addButton(new Button(this.guiLeft + 18, this.guiTop + 174, 136, 20, new StringTextComponent("Reset Info Stats"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new NarutoShippudenCheatGUIGui.ButtonPressedMessage(17, x, y, z));
					NarutoShippudenCheatGUIGui.handleButtonAction(entity, 17, x, y, z);
				}
			}));
			this.addButton(new Button(this.guiLeft + 18, this.guiTop + 194, 136, 20, new StringTextComponent("Select Menu"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new NarutoShippudenCheatGUIGui.ButtonPressedMessage(18, x, y, z));
					NarutoShippudenCheatGUIGui.handleButtonAction(entity, 18, x, y, z);
				}
			}));
			this.addButton(new Button(this.guiLeft + 18, this.guiTop + 34, 136, 20, new StringTextComponent("Reset LEVEL & JP & SP"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new NarutoShippudenCheatGUIGui.ButtonPressedMessage(19, x, y, z));
					NarutoShippudenCheatGUIGui.handleButtonAction(entity, 19, x, y, z);
				}
			}));
			this.addButton(new Button(this.guiLeft + 18, this.guiTop + 14, 136, 20, new StringTextComponent("+100 LvL XP"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new NarutoShippudenCheatGUIGui.ButtonPressedMessage(20, x, y, z));
					NarutoShippudenCheatGUIGui.handleButtonAction(entity, 20, x, y, z);
				}
			}));
		}
	}

	@OnlyIn(Dist.CLIENT)
	public static class NarutoShippudenCheatKekkeiGenkaiGUIGuiWindow extends ContainerScreen<NarutoShippudenCheatKekkeiGenkaiGUIGui.GuiContainerMod> {
		private World world;
		private int x, y, z;
		private PlayerEntity entity;
		private final static HashMap guistate = NarutoShippudenCheatKekkeiGenkaiGUIGui.guistate;

		public NarutoShippudenCheatKekkeiGenkaiGUIGuiWindow(NarutoShippudenCheatKekkeiGenkaiGUIGui.GuiContainerMod container, PlayerInventory inventory,
				ITextComponent text) {
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
			this.addButton(new Button(this.guiLeft + 0, this.guiTop + 54, 68, 20, new StringTextComponent("Wood Release"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new NarutoShippudenCheatKekkeiGenkaiGUIGui.ButtonPressedMessage(0, x, y, z));
					NarutoShippudenCheatKekkeiGenkaiGUIGui.handleButtonAction(entity, 0, x, y, z);
				}
			}));
			this.addButton(new Button(this.guiLeft + 0, this.guiTop + 74, 68, 20, new StringTextComponent("Lava Release"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new NarutoShippudenCheatKekkeiGenkaiGUIGui.ButtonPressedMessage(1, x, y, z));
					NarutoShippudenCheatKekkeiGenkaiGUIGui.handleButtonAction(entity, 1, x, y, z);
				}
			}));
			this.addButton(new Button(this.guiLeft + 107, this.guiTop + 74, 68, 20, new StringTextComponent("Smoke Release"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new NarutoShippudenCheatKekkeiGenkaiGUIGui.ButtonPressedMessage(2, x, y, z));
					NarutoShippudenCheatKekkeiGenkaiGUIGui.handleButtonAction(entity, 2, x, y, z);
				}
			}));
			this.addButton(new Button(this.guiLeft + 176, this.guiTop + 54, 61, 20, new StringTextComponent("Back"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new NarutoShippudenCheatKekkeiGenkaiGUIGui.ButtonPressedMessage(3, x, y, z));
					NarutoShippudenCheatKekkeiGenkaiGUIGui.handleButtonAction(entity, 3, x, y, z);
				}
			}));
			this.addButton(new Button(this.guiLeft + 107, this.guiTop + 54, 68, 20, new StringTextComponent("Ice Release"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new NarutoShippudenCheatKekkeiGenkaiGUIGui.ButtonPressedMessage(4, x, y, z));
					NarutoShippudenCheatKekkeiGenkaiGUIGui.handleButtonAction(entity, 4, x, y, z);
				}
			}));
			this.addButton(new Button(this.guiLeft + 0, this.guiTop + 94, 68, 20, new StringTextComponent("Storm Release"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new NarutoShippudenCheatKekkeiGenkaiGUIGui.ButtonPressedMessage(5, x, y, z));
					NarutoShippudenCheatKekkeiGenkaiGUIGui.handleButtonAction(entity, 5, x, y, z);
				}
			}));
			this.addButton(new Button(this.guiLeft + 107, this.guiTop + 94, 68, 20, new StringTextComponent("Boil Release"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new NarutoShippudenCheatKekkeiGenkaiGUIGui.ButtonPressedMessage(6, x, y, z));
					NarutoShippudenCheatKekkeiGenkaiGUIGui.handleButtonAction(entity, 6, x, y, z);
				}
			}));
			this.addButton(new Button(this.guiLeft + 0, this.guiTop + 114, 68, 20, new StringTextComponent("Dust Release"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new NarutoShippudenCheatKekkeiGenkaiGUIGui.ButtonPressedMessage(7, x, y, z));
					NarutoShippudenCheatKekkeiGenkaiGUIGui.handleButtonAction(entity, 7, x, y, z);
				}
			}));
			this.addButton(new Button(this.guiLeft + 107, this.guiTop + 114, 68, 20, new StringTextComponent("Steel Release"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new NarutoShippudenCheatKekkeiGenkaiGUIGui.ButtonPressedMessage(8, x, y, z));
					NarutoShippudenCheatKekkeiGenkaiGUIGui.handleButtonAction(entity, 8, x, y, z);
				}
			}));
			this.addButton(new Button(this.guiLeft + 0, this.guiTop + 134, 68, 20, new StringTextComponent("Swift Release"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new NarutoShippudenCheatKekkeiGenkaiGUIGui.ButtonPressedMessage(9, x, y, z));
					NarutoShippudenCheatKekkeiGenkaiGUIGui.handleButtonAction(entity, 9, x, y, z);
				}
			}));
			this.addButton(new Button(this.guiLeft + 107, this.guiTop + 134, 68, 20, new StringTextComponent("Paper Release"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new NarutoShippudenCheatKekkeiGenkaiGUIGui.ButtonPressedMessage(10, x, y, z));
					NarutoShippudenCheatKekkeiGenkaiGUIGui.handleButtonAction(entity, 10, x, y, z);
				}
			}));
			this.addButton(new Button(this.guiLeft + -108, this.guiTop + 54, 87, 20, new StringTextComponent("Inferno Release"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new NarutoShippudenCheatKekkeiGenkaiGUIGui.ButtonPressedMessage(11, x, y, z));
					NarutoShippudenCheatKekkeiGenkaiGUIGui.handleButtonAction(entity, 11, x, y, z);
				}
			}));
			this.addButton(new Button(this.guiLeft + -108, this.guiTop + 74, 87, 20, new StringTextComponent("Explosion Release"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new NarutoShippudenCheatKekkeiGenkaiGUIGui.ButtonPressedMessage(12, x, y, z));
					NarutoShippudenCheatKekkeiGenkaiGUIGui.handleButtonAction(entity, 12, x, y, z);
				}
			}));
			this.addButton(new Button(this.guiLeft + -108, this.guiTop + 94, 87, 20, new StringTextComponent("Typhoon Release"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new NarutoShippudenCheatKekkeiGenkaiGUIGui.ButtonPressedMessage(13, x, y, z));
					NarutoShippudenCheatKekkeiGenkaiGUIGui.handleButtonAction(entity, 13, x, y, z);
				}
			}));
			this.addButton(new Button(this.guiLeft + -108, this.guiTop + 114, 87, 20, new StringTextComponent("Manget Release"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new NarutoShippudenCheatKekkeiGenkaiGUIGui.ButtonPressedMessage(14, x, y, z));
					NarutoShippudenCheatKekkeiGenkaiGUIGui.handleButtonAction(entity, 14, x, y, z);
				}
			}));
			this.addButton(new Button(this.guiLeft + -108, this.guiTop + 134, 87, 20, new StringTextComponent("Bone Release"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new NarutoShippudenCheatKekkeiGenkaiGUIGui.ButtonPressedMessage(15, x, y, z));
					NarutoShippudenCheatKekkeiGenkaiGUIGui.handleButtonAction(entity, 15, x, y, z);
				}
			}));
		}
	}

	@OnlyIn(Dist.CLIENT)
	public static class PasswordGUIDojutsuGuiWindow extends ContainerScreen<PasswordGUIDojutsuGui.GuiContainerMod> {
		private World world;
		private int x, y, z;
		private PlayerEntity entity;
		private final static HashMap guistate = PasswordGUIDojutsuGui.guistate;
		TextFieldWidget Password;

		public PasswordGUIDojutsuGuiWindow(PasswordGUIDojutsuGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
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
			Password.render(ms, mouseX, mouseY, partialTicks);
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
			if (Password.isFocused())
				return Password.keyPressed(key, b, c);
			return super.keyPressed(key, b, c);
		}

		@Override
		public void tick() {
			super.tick();
			Password.tick();
		}

		@Override
		protected void drawGuiContainerForegroundLayer(MatrixStack ms, int mouseX, int mouseY) {
			this.font.drawString(ms, "Enter Password:", 47, 33, -1);
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
			Password = new TextFieldWidget(this.font, this.guiLeft + 24, this.guiTop + 43, 126, 20, new StringTextComponent(""));
			guistate.put("text:Password", Password);
			Password.setMaxStringLength(32767);
			this.children.add(this.Password);
			this.addButton(new Button(this.guiLeft + 60, this.guiTop + 70, 51, 20, new StringTextComponent("Login"), e -> {
				if (true) {
					NarutoShippudenMod.PACKET_HANDLER.sendToServer(new PasswordGUIDojutsuGui.ButtonPressedMessage(0, x, y, z));
					PasswordGUIDojutsuGui.handleButtonAction(entity, 0, x, y, z);
				}
			}));
		}
	}
}
