
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
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.Minecraft;

import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables;
import net.mcreator.narutoshippudenmod.NarutoShippudenMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class CreateJutsuGUI2GuiWindow extends ContainerScreen<CreateJutsuGUI2Gui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	private final static HashMap guistate = CreateJutsuGUI2Gui.guistate;
	TextFieldWidget Jutsu_Name;

	public CreateJutsuGUI2GuiWindow(CreateJutsuGUI2Gui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
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
		Jutsu_Name.render(ms, mouseX, mouseY, partialTicks);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(MatrixStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.color4f(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();

		Minecraft.getInstance().getTextureManager()
				.bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/info_card_mini_game_texture.png"));
		this.blit(ms, this.guiLeft + 6, this.guiTop + 21, 0, 0, 162, 124, 162, 124);

		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeScreen();
			return true;
		}
		if (Jutsu_Name.isFocused())
			return Jutsu_Name.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void tick() {
		super.tick();
		Jutsu_Name.tick();
	}

	@Override
	protected void drawGuiContainerForegroundLayer(MatrixStack ms, int mouseX, int mouseY) {
		this.font.drawString(ms, "Name:", 15, 31, -16777216);
		this.font.drawString(ms, "Owner:", 15, 52, -16777216);
		this.font.drawString(ms, "Type:", 15, 74, -16777216);
		this.font.drawString(ms, "Speed:", 15, 97, -16777216);
		this.font.drawString(ms, "Release:", 15, 122, -16777216);
		this.font.drawString(ms, "Chakra:", 108, 98, -16777216);
		this.font.drawString(ms, "" + ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).player_name) + "", 48, 52, -16777216);
		this.font.drawString(ms, "" + ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsutype) + "", 42, 74, -16777216);
		this.font.drawString(ms, "" + ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuspeed) + "", 48, 97, -16777216);
		this.font.drawString(ms, "" + ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsurelease) + "", 58, 122, -16777216);
		this.font.drawString(ms, "" + (int) ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra) + "", 146, 98, -16777216);
		this.font.drawString(ms, "Check JP Price:", 175, 24, -1);
		this.font.drawString(ms, "" + (int) ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsujpcost) + "", 255, 24, -1);
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
		this.addButton(new Button(this.guiLeft + 6, this.guiTop + -1, 56, 20, new StringTextComponent("Back"), e -> {
			if (true) {
				NarutoShippudenMod.PACKET_HANDLER.sendToServer(new CreateJutsuGUI2Gui.ButtonPressedMessage(0, x, y, z));
				CreateJutsuGUI2Gui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		Jutsu_Name = new TextFieldWidget(this.font, this.guiLeft + 42, this.guiTop + 25, 65, 20, new StringTextComponent(""));
		guistate.put("text:Jutsu_Name", Jutsu_Name);
		Jutsu_Name.setMaxStringLength(32767);
		this.children.add(this.Jutsu_Name);
		this.addButton(new Button(this.guiLeft + -9, this.guiTop + 116, 8, 20, new StringTextComponent("<"), e -> {
			if (true) {
				NarutoShippudenMod.PACKET_HANDLER.sendToServer(new CreateJutsuGUI2Gui.ButtonPressedMessage(1, x, y, z));
				CreateJutsuGUI2Gui.handleButtonAction(entity, 1, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 0, this.guiTop + 116, 8, 20, new StringTextComponent(">"), e -> {
			if (true) {
				NarutoShippudenMod.PACKET_HANDLER.sendToServer(new CreateJutsuGUI2Gui.ButtonPressedMessage(2, x, y, z));
				CreateJutsuGUI2Gui.handleButtonAction(entity, 2, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + -9, this.guiTop + 91, 8, 20, new StringTextComponent("<"), e -> {
			if (true) {
				NarutoShippudenMod.PACKET_HANDLER.sendToServer(new CreateJutsuGUI2Gui.ButtonPressedMessage(3, x, y, z));
				CreateJutsuGUI2Gui.handleButtonAction(entity, 3, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 0, this.guiTop + 91, 8, 20, new StringTextComponent(">"), e -> {
			if (true) {
				NarutoShippudenMod.PACKET_HANDLER.sendToServer(new CreateJutsuGUI2Gui.ButtonPressedMessage(4, x, y, z));
				CreateJutsuGUI2Gui.handleButtonAction(entity, 4, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + -9, this.guiTop + 68, 8, 20, new StringTextComponent("<"), e -> {
			if (true) {
				NarutoShippudenMod.PACKET_HANDLER.sendToServer(new CreateJutsuGUI2Gui.ButtonPressedMessage(5, x, y, z));
				CreateJutsuGUI2Gui.handleButtonAction(entity, 5, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 0, this.guiTop + 68, 8, 20, new StringTextComponent(">"), e -> {
			if (true) {
				NarutoShippudenMod.PACKET_HANDLER.sendToServer(new CreateJutsuGUI2Gui.ButtonPressedMessage(6, x, y, z));
				CreateJutsuGUI2Gui.handleButtonAction(entity, 6, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 90, this.guiTop + 92, 8, 20, new StringTextComponent("<"), e -> {
			if (true) {
				NarutoShippudenMod.PACKET_HANDLER.sendToServer(new CreateJutsuGUI2Gui.ButtonPressedMessage(7, x, y, z));
				CreateJutsuGUI2Gui.handleButtonAction(entity, 7, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 99, this.guiTop + 92, 8, 20, new StringTextComponent(">"), e -> {
			if (true) {
				NarutoShippudenMod.PACKET_HANDLER.sendToServer(new CreateJutsuGUI2Gui.ButtonPressedMessage(8, x, y, z));
				CreateJutsuGUI2Gui.handleButtonAction(entity, 8, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 175, this.guiTop + 36, 51, 20, new StringTextComponent("Price"), e -> {
			if (true) {
				NarutoShippudenMod.PACKET_HANDLER.sendToServer(new CreateJutsuGUI2Gui.ButtonPressedMessage(9, x, y, z));
				CreateJutsuGUI2Gui.handleButtonAction(entity, 9, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 175, this.guiTop + 56, 51, 20, new StringTextComponent("Learn"), e -> {
			if (true) {
				NarutoShippudenMod.PACKET_HANDLER.sendToServer(new CreateJutsuGUI2Gui.ButtonPressedMessage(10, x, y, z));
				CreateJutsuGUI2Gui.handleButtonAction(entity, 10, x, y, z);
			}
		}));
	}
}
