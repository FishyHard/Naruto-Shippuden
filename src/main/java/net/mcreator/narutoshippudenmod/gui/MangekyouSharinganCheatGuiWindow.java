
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
public class MangekyouSharinganCheatGuiWindow extends ContainerScreen<MangekyouSharinganCheatGui.GuiContainerMod> {
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
