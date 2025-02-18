
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
public class NarutoShippudenCheatDojutsuGUIGuiWindow extends ContainerScreen<NarutoShippudenCheatDojutsuGUIGui.GuiContainerMod> {
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
