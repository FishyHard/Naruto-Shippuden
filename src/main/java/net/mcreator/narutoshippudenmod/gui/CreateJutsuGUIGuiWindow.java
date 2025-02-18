
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

import net.mcreator.narutoshippudenmod.procedures.DisplayUnlearnCustomJutsu1Procedure;
import net.mcreator.narutoshippudenmod.procedures.DisplayLearnCustomJutsu1Procedure;
import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables;
import net.mcreator.narutoshippudenmod.NarutoShippudenMod;

import java.util.stream.Stream;
import java.util.Map;
import java.util.HashMap;
import java.util.AbstractMap;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class CreateJutsuGUIGuiWindow extends ContainerScreen<CreateJutsuGUIGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	private final static HashMap guistate = CreateJutsuGUIGui.guistate;

	public CreateJutsuGUIGuiWindow(CreateJutsuGUIGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
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
				.bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/info_card_custom_jutsu_texture.png"));
		this.blit(ms, this.guiLeft + -24, this.guiTop + 19, 0, 0, 229, 175, 229, 175);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/warning_under_dev.png"));
		this.blit(ms, this.guiLeft + 27, this.guiTop + 74, 0, 0, 125, 29, 125, 29);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/warning_under_dev.png"));
		this.blit(ms, this.guiLeft + 27, this.guiTop + 119, 0, 0, 125, 29, 125, 29);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/warning_under_dev.png"));
		this.blit(ms, this.guiLeft + 27, this.guiTop + 164, 0, 0, 125, 29, 125, 29);

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
		if (DisplayUnlearnCustomJutsu1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
			this.font.drawString(ms, "Release:", -20, 25, -1);
		if (DisplayUnlearnCustomJutsu1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
			this.font.drawString(ms, "" + ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsurelease1save) + "", 24, 25, -1);
		if (DisplayUnlearnCustomJutsu1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
			this.font.drawString(ms, "Type:", -20, 61, -1);
		if (DisplayUnlearnCustomJutsu1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
			this.font.drawString(ms, "" + ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsutype1save) + "", 9, 61, -1);
		if (DisplayUnlearnCustomJutsu1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
			this.font.drawString(ms, "Speed:", -20, 43, -1);
		if (DisplayUnlearnCustomJutsu1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
			this.font.drawString(ms, "" + ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuspeed1save) + "", 15, 43, -1);
		if (DisplayUnlearnCustomJutsu1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
			this.font.drawString(ms, "!!WARNING!! You get only half of JP price ", 67, -2, -65536);
		if (DisplayUnlearnCustomJutsu1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
			this.font.drawString(ms, "you bought if you unlearn it.", 69, 7, -65536);
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
				NarutoShippudenMod.PACKET_HANDLER.sendToServer(new CreateJutsuGUIGui.ButtonPressedMessage(0, x, y, z));
				CreateJutsuGUIGui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + -11, this.guiTop + 79, 36, 20, new StringTextComponent("Create"), e -> {
			if (true) {
				NarutoShippudenMod.PACKET_HANDLER.sendToServer(new CreateJutsuGUIGui.ButtonPressedMessage(1, x, y, z));
				CreateJutsuGUIGui.handleButtonAction(entity, 1, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + -11, this.guiTop + 34, 36, 20, new StringTextComponent("Create"), e -> {
			if (DisplayLearnCustomJutsu1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				NarutoShippudenMod.PACKET_HANDLER.sendToServer(new CreateJutsuGUIGui.ButtonPressedMessage(2, x, y, z));
				CreateJutsuGUIGui.handleButtonAction(entity, 2, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (DisplayLearnCustomJutsu1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addButton(new Button(this.guiLeft + -11, this.guiTop + 124, 36, 20, new StringTextComponent("Create"), e -> {
			if (true) {
				NarutoShippudenMod.PACKET_HANDLER.sendToServer(new CreateJutsuGUIGui.ButtonPressedMessage(3, x, y, z));
				CreateJutsuGUIGui.handleButtonAction(entity, 3, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + -11, this.guiTop + 169, 36, 20, new StringTextComponent("Create"), e -> {
			if (true) {
				NarutoShippudenMod.PACKET_HANDLER.sendToServer(new CreateJutsuGUIGui.ButtonPressedMessage(4, x, y, z));
				CreateJutsuGUIGui.handleButtonAction(entity, 4, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 204, this.guiTop + 34, 36, 20, new StringTextComponent("Unlearn"), e -> {
			if (DisplayUnlearnCustomJutsu1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				NarutoShippudenMod.PACKET_HANDLER.sendToServer(new CreateJutsuGUIGui.ButtonPressedMessage(5, x, y, z));
				CreateJutsuGUIGui.handleButtonAction(entity, 5, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (DisplayUnlearnCustomJutsu1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
	}
}
