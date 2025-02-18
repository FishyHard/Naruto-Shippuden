
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
public class NarutoShippudenCheatKekkeiGenkaiGUIGuiWindow extends ContainerScreen<NarutoShippudenCheatKekkeiGenkaiGUIGui.GuiContainerMod> {
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
