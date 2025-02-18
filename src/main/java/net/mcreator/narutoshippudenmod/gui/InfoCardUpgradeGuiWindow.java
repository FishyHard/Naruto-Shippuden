
package net.mcreator.narutoshippudenmod.gui;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.Minecraft;

import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables;
import net.mcreator.narutoshippudenmod.NarutoShippudenMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class InfoCardUpgradeGuiWindow extends ContainerScreen<InfoCardUpgradeGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	private final static HashMap guistate = InfoCardUpgradeGui.guistate;

	public InfoCardUpgradeGuiWindow(InfoCardUpgradeGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
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

		Minecraft.getInstance().getTextureManager()
				.bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/info_card_upgrading_texture.png"));
		this.blit(ms, this.guiLeft + -126, this.guiTop + -39, 0, 0, 350, 250, 350, 250);

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
		this.font.drawString(ms, "SP Use Count", -105, 64, -1);
		this.font.drawString(ms, "Selected:", -105, 74, -1);
		this.font.drawString(ms, "" + (int) ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).spusecount) + "", -55, 74, -1);
		this.font.drawString(ms, "" + (int) ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).ninjutsu) + "", 91, -22, -16777216);
		this.font.drawString(ms, "" + (int) ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).taijutsu) + "", 91, 6, -16777216);
		this.font.drawString(ms, "" + (int) ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).kenjutsu) + "", 91, 30, -16777216);
		this.font.drawString(ms, "" + (int) ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).shurikenjutsu) + "", 115, 54, -16777216);
		this.font.drawString(ms, "" + (int) ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).summoning) + "", 101, 77, -16777216);
		this.font.drawString(ms, "" + (int) ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).kinjutsu) + "", 88, 102, -16777216);
		this.font.drawString(ms, "" + (int) ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).senjutsu) + "", 93, 126, -16777216);
		this.font.drawString(ms, "" + (int) ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).medicine) + "", 96, 150, -16777216);
		this.font.drawString(ms, "" + (int) ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).speed) + "", 79, 174, -16777216);
		this.font.drawString(ms, "" + (int) ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).jutsupowerstat) + "", 200, -21, -16777216);
		this.font.drawString(ms, "" + (int) ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).genjutsu) + "", 188, 6, -16777216);
		this.font.drawString(ms, "" + (int) ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).IQ) + "", 154, 31, -16777216);
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
		this.addButton(new Button(this.guiLeft + -105, this.guiTop + 182, 68, 20, new StringTextComponent("Previous Page"), e -> {
			if (true) {
				NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardUpgradeGui.ButtonPressedMessage(0, x, y, z));
				InfoCardUpgradeGui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + -105, this.guiTop + 86, 22, 20, new StringTextComponent("1"), e -> {
			if (true) {
				NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardUpgradeGui.ButtonPressedMessage(1, x, y, z));
				InfoCardUpgradeGui.handleButtonAction(entity, 1, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + -83, this.guiTop + 86, 22, 20, new StringTextComponent("5"), e -> {
			if (true) {
				NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardUpgradeGui.ButtonPressedMessage(2, x, y, z));
				InfoCardUpgradeGui.handleButtonAction(entity, 2, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + -61, this.guiTop + 86, 22, 20, new StringTextComponent("10"), e -> {
			if (true) {
				NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardUpgradeGui.ButtonPressedMessage(3, x, y, z));
				InfoCardUpgradeGui.handleButtonAction(entity, 3, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 76, this.guiTop + -28, 10, 20, new StringTextComponent("+"), e -> {
			if (true) {
				NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardUpgradeGui.ButtonPressedMessage(4, x, y, z));
				InfoCardUpgradeGui.handleButtonAction(entity, 4, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 76, this.guiTop + 0, 10, 20, new StringTextComponent("+"), e -> {
			if (true) {
				NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardUpgradeGui.ButtonPressedMessage(5, x, y, z));
				InfoCardUpgradeGui.handleButtonAction(entity, 5, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 76, this.guiTop + 24, 10, 20, new StringTextComponent("+"), e -> {
			if (true) {
				NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardUpgradeGui.ButtonPressedMessage(6, x, y, z));
				InfoCardUpgradeGui.handleButtonAction(entity, 6, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 100, this.guiTop + 48, 10, 20, new StringTextComponent("+"), e -> {
			if (true) {
				NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardUpgradeGui.ButtonPressedMessage(7, x, y, z));
				InfoCardUpgradeGui.handleButtonAction(entity, 7, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 85, this.guiTop + 71, 10, 20, new StringTextComponent("+"), e -> {
			if (true) {
				NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardUpgradeGui.ButtonPressedMessage(8, x, y, z));
				InfoCardUpgradeGui.handleButtonAction(entity, 8, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 75, this.guiTop + 96, 10, 20, new StringTextComponent("+"), e -> {
			if (true) {
				NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardUpgradeGui.ButtonPressedMessage(9, x, y, z));
				InfoCardUpgradeGui.handleButtonAction(entity, 9, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 76, this.guiTop + 120, 10, 20, new StringTextComponent("+"), e -> {
			if (true) {
				NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardUpgradeGui.ButtonPressedMessage(10, x, y, z));
				InfoCardUpgradeGui.handleButtonAction(entity, 10, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 78, this.guiTop + 144, 10, 20, new StringTextComponent("+"), e -> {
			if (true) {
				NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardUpgradeGui.ButtonPressedMessage(11, x, y, z));
				InfoCardUpgradeGui.handleButtonAction(entity, 11, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 62, this.guiTop + 168, 10, 20, new StringTextComponent("+"), e -> {
			if (true) {
				NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardUpgradeGui.ButtonPressedMessage(12, x, y, z));
				InfoCardUpgradeGui.handleButtonAction(entity, 12, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 187, this.guiTop + -28, 10, 20, new StringTextComponent("+"), e -> {
			if (true) {
				NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardUpgradeGui.ButtonPressedMessage(13, x, y, z));
				InfoCardUpgradeGui.handleButtonAction(entity, 13, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 170, this.guiTop + -1, 10, 20, new StringTextComponent("+"), e -> {
			if (true) {
				NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardUpgradeGui.ButtonPressedMessage(14, x, y, z));
				InfoCardUpgradeGui.handleButtonAction(entity, 14, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 139, this.guiTop + 24, 10, 20, new StringTextComponent("+"), e -> {
			if (true) {
				NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardUpgradeGui.ButtonPressedMessage(15, x, y, z));
				InfoCardUpgradeGui.handleButtonAction(entity, 15, x, y, z);
			}
		}));
	}
}
