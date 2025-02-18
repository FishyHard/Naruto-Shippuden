
package net.mcreator.narutoshippudenmod.gui;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.Minecraft;

import net.mcreator.narutoshippudenmod.NarutoShippudenMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class NarutoShippudenCheatGUIGuiWindow extends ContainerScreen<NarutoShippudenCheatGUIGui.GuiContainerMod> {
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
