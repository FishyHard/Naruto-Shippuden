
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

import net.mcreator.narutoshippudenmod.procedures.Headband3DisplayProcedure;
import net.mcreator.narutoshippudenmod.procedures.Headband2DisplayProcedure;
import net.mcreator.narutoshippudenmod.procedures.Headband1DisplayProcedure;
import net.mcreator.narutoshippudenmod.NarutoShippudenMod;

import java.util.stream.Stream;
import java.util.Map;
import java.util.HashMap;
import java.util.AbstractMap;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class GeninHeadbandSelectGuiWindow extends ContainerScreen<GeninHeadbandSelectGui.GuiContainerMod> {
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
