
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

import net.mcreator.narutoshippudenmod.procedures.Display9MiniProcedure;
import net.mcreator.narutoshippudenmod.procedures.Display8MiniProcedure;
import net.mcreator.narutoshippudenmod.procedures.Display7MiniProcedure;
import net.mcreator.narutoshippudenmod.procedures.Display6MiniProcedure;
import net.mcreator.narutoshippudenmod.procedures.Display5MiniProcedure;
import net.mcreator.narutoshippudenmod.procedures.Display4MiniProcedure;
import net.mcreator.narutoshippudenmod.procedures.Display48MiniProcedure;
import net.mcreator.narutoshippudenmod.procedures.Display47MiniProcedure;
import net.mcreator.narutoshippudenmod.procedures.Display46MiniProcedure;
import net.mcreator.narutoshippudenmod.procedures.Display45MiniProcedure;
import net.mcreator.narutoshippudenmod.procedures.Display44MiniProcedure;
import net.mcreator.narutoshippudenmod.procedures.Display43MiniProcedure;
import net.mcreator.narutoshippudenmod.procedures.Display42MiniProcedure;
import net.mcreator.narutoshippudenmod.procedures.Display41MiniProcedure;
import net.mcreator.narutoshippudenmod.procedures.Display40MiniProcedure;
import net.mcreator.narutoshippudenmod.procedures.Display3MiniProcedure;
import net.mcreator.narutoshippudenmod.procedures.Display39MiniProcedure;
import net.mcreator.narutoshippudenmod.procedures.Display38MiniProcedure;
import net.mcreator.narutoshippudenmod.procedures.Display37MiniProcedure;
import net.mcreator.narutoshippudenmod.procedures.Display36MiniProcedure;
import net.mcreator.narutoshippudenmod.procedures.Display35MiniProcedure;
import net.mcreator.narutoshippudenmod.procedures.Display34MiniProcedure;
import net.mcreator.narutoshippudenmod.procedures.Display33MiniProcedure;
import net.mcreator.narutoshippudenmod.procedures.Display32MiniProcedure;
import net.mcreator.narutoshippudenmod.procedures.Display31MiniProcedure;
import net.mcreator.narutoshippudenmod.procedures.Display30MiniProcedure;
import net.mcreator.narutoshippudenmod.procedures.Display2MiniProcedure;
import net.mcreator.narutoshippudenmod.procedures.Display29MiniProcedure;
import net.mcreator.narutoshippudenmod.procedures.Display28MiniProcedure;
import net.mcreator.narutoshippudenmod.procedures.Display27MiniProcedure;
import net.mcreator.narutoshippudenmod.procedures.Display26MiniProcedure;
import net.mcreator.narutoshippudenmod.procedures.Display25MiniProcedure;
import net.mcreator.narutoshippudenmod.procedures.Display24MiniProcedure;
import net.mcreator.narutoshippudenmod.procedures.Display23MiniProcedure;
import net.mcreator.narutoshippudenmod.procedures.Display22MiniProcedure;
import net.mcreator.narutoshippudenmod.procedures.Display21MiniProcedure;
import net.mcreator.narutoshippudenmod.procedures.Display20MiniProcedure;
import net.mcreator.narutoshippudenmod.procedures.Display1MiniProcedure;
import net.mcreator.narutoshippudenmod.procedures.Display19MiniProcedure;
import net.mcreator.narutoshippudenmod.procedures.Display18MiniProcedure;
import net.mcreator.narutoshippudenmod.procedures.Display17MiniProcedure;
import net.mcreator.narutoshippudenmod.procedures.Display16MiniProcedure;
import net.mcreator.narutoshippudenmod.procedures.Display15MiniProcedure;
import net.mcreator.narutoshippudenmod.procedures.Display14MiniProcedure;
import net.mcreator.narutoshippudenmod.procedures.Display13MiniProcedure;
import net.mcreator.narutoshippudenmod.procedures.Display12MiniProcedure;
import net.mcreator.narutoshippudenmod.procedures.Display11MiniProcedure;
import net.mcreator.narutoshippudenmod.procedures.Display10MiniProcedure;
import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables;
import net.mcreator.narutoshippudenmod.NarutoShippudenMod;

import java.util.stream.Stream;
import java.util.Map;
import java.util.HashMap;
import java.util.AbstractMap;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class InfoCardMiniGameGuiWindow extends ContainerScreen<InfoCardMiniGameGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	private final static HashMap guistate = InfoCardMiniGameGui.guistate;

	public InfoCardMiniGameGuiWindow(InfoCardMiniGameGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
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
		return super.keyPressed(key, b, c);
	}

	@Override
	public void tick() {
		super.tick();
	}

	@Override
	protected void drawGuiContainerForegroundLayer(MatrixStack ms, int mouseX, int mouseY) {
		this.font.drawString(ms, "LvL XP Max:", 134, 9, -1);
		this.font.drawString(ms, "" + (int) ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).LEVELMINIGAME) + "", 103, 9, -1);
		this.font.drawString(ms, "LvL XP:", 64, 9, -1);
		this.font.drawString(ms, "" + (int) ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).LEVELMAXMINIGAME) + "", 195, 9, -1);
		this.font.drawString(ms, "Level:", 64, -4, -1);
		this.font.drawString(ms, "" + (int) ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).LEVELSTATMINIGAME) + "", 98, -4, -1);
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
				NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardMiniGameGui.ButtonPressedMessage(0, x, y, z));
				InfoCardMiniGameGui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 27, this.guiTop + 23, 20, 20, new StringTextComponent(" "), e -> {
			if (Display2MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardMiniGameGui.ButtonPressedMessage(1, x, y, z));
				InfoCardMiniGameGui.handleButtonAction(entity, 1, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (Display2MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addButton(new Button(this.guiLeft + 7, this.guiTop + 43, 20, 20, new StringTextComponent(" "), e -> {
			if (Display9MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardMiniGameGui.ButtonPressedMessage(2, x, y, z));
				InfoCardMiniGameGui.handleButtonAction(entity, 2, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (Display9MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addButton(new Button(this.guiLeft + 7, this.guiTop + 63, 20, 20, new StringTextComponent(" "), e -> {
			if (Display17MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardMiniGameGui.ButtonPressedMessage(3, x, y, z));
				InfoCardMiniGameGui.handleButtonAction(entity, 3, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (Display17MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addButton(new Button(this.guiLeft + 7, this.guiTop + 83, 20, 20, new StringTextComponent(" "), e -> {
			if (Display25MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardMiniGameGui.ButtonPressedMessage(4, x, y, z));
				InfoCardMiniGameGui.handleButtonAction(entity, 4, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (Display25MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addButton(new Button(this.guiLeft + 7, this.guiTop + 103, 20, 20, new StringTextComponent(" "), e -> {
			if (Display33MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardMiniGameGui.ButtonPressedMessage(5, x, y, z));
				InfoCardMiniGameGui.handleButtonAction(entity, 5, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (Display33MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addButton(new Button(this.guiLeft + 7, this.guiTop + 123, 20, 20, new StringTextComponent(" "), e -> {
			if (Display41MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardMiniGameGui.ButtonPressedMessage(6, x, y, z));
				InfoCardMiniGameGui.handleButtonAction(entity, 6, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (Display41MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addButton(new Button(this.guiLeft + 7, this.guiTop + 23, 20, 20, new StringTextComponent(" "), e -> {
			if (Display1MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardMiniGameGui.ButtonPressedMessage(7, x, y, z));
				InfoCardMiniGameGui.handleButtonAction(entity, 7, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (Display1MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addButton(new Button(this.guiLeft + 27, this.guiTop + 43, 20, 20, new StringTextComponent(" "), e -> {
			if (Display10MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardMiniGameGui.ButtonPressedMessage(8, x, y, z));
				InfoCardMiniGameGui.handleButtonAction(entity, 8, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (Display10MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addButton(new Button(this.guiLeft + 27, this.guiTop + 63, 20, 20, new StringTextComponent(" "), e -> {
			if (Display18MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardMiniGameGui.ButtonPressedMessage(9, x, y, z));
				InfoCardMiniGameGui.handleButtonAction(entity, 9, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (Display18MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addButton(new Button(this.guiLeft + 27, this.guiTop + 83, 20, 20, new StringTextComponent(" "), e -> {
			if (Display26MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardMiniGameGui.ButtonPressedMessage(10, x, y, z));
				InfoCardMiniGameGui.handleButtonAction(entity, 10, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (Display26MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addButton(new Button(this.guiLeft + 27, this.guiTop + 103, 20, 20, new StringTextComponent(" "), e -> {
			if (Display34MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardMiniGameGui.ButtonPressedMessage(11, x, y, z));
				InfoCardMiniGameGui.handleButtonAction(entity, 11, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (Display34MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addButton(new Button(this.guiLeft + 27, this.guiTop + 123, 20, 20, new StringTextComponent(" "), e -> {
			if (Display42MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardMiniGameGui.ButtonPressedMessage(12, x, y, z));
				InfoCardMiniGameGui.handleButtonAction(entity, 12, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (Display42MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addButton(new Button(this.guiLeft + 47, this.guiTop + 23, 20, 20, new StringTextComponent(" "), e -> {
			if (Display3MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardMiniGameGui.ButtonPressedMessage(13, x, y, z));
				InfoCardMiniGameGui.handleButtonAction(entity, 13, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (Display3MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addButton(new Button(this.guiLeft + 47, this.guiTop + 43, 20, 20, new StringTextComponent(" "), e -> {
			if (Display11MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardMiniGameGui.ButtonPressedMessage(14, x, y, z));
				InfoCardMiniGameGui.handleButtonAction(entity, 14, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (Display11MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addButton(new Button(this.guiLeft + 47, this.guiTop + 63, 20, 20, new StringTextComponent(" "), e -> {
			if (Display19MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardMiniGameGui.ButtonPressedMessage(15, x, y, z));
				InfoCardMiniGameGui.handleButtonAction(entity, 15, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (Display19MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addButton(new Button(this.guiLeft + 47, this.guiTop + 83, 20, 20, new StringTextComponent(" "), e -> {
			if (Display27MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardMiniGameGui.ButtonPressedMessage(16, x, y, z));
				InfoCardMiniGameGui.handleButtonAction(entity, 16, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (Display27MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addButton(new Button(this.guiLeft + 47, this.guiTop + 103, 20, 20, new StringTextComponent(" "), e -> {
			if (Display35MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardMiniGameGui.ButtonPressedMessage(17, x, y, z));
				InfoCardMiniGameGui.handleButtonAction(entity, 17, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (Display35MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addButton(new Button(this.guiLeft + 87, this.guiTop + 23, 20, 20, new StringTextComponent(" "), e -> {
			if (Display5MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardMiniGameGui.ButtonPressedMessage(18, x, y, z));
				InfoCardMiniGameGui.handleButtonAction(entity, 18, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (Display5MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addButton(new Button(this.guiLeft + 67, this.guiTop + 23, 20, 20, new StringTextComponent(" "), e -> {
			if (Display4MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardMiniGameGui.ButtonPressedMessage(19, x, y, z));
				InfoCardMiniGameGui.handleButtonAction(entity, 19, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (Display4MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addButton(new Button(this.guiLeft + 67, this.guiTop + 43, 20, 20, new StringTextComponent(" "), e -> {
			if (Display12MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardMiniGameGui.ButtonPressedMessage(20, x, y, z));
				InfoCardMiniGameGui.handleButtonAction(entity, 20, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (Display12MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addButton(new Button(this.guiLeft + 67, this.guiTop + 63, 20, 20, new StringTextComponent(" "), e -> {
			if (Display20MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardMiniGameGui.ButtonPressedMessage(21, x, y, z));
				InfoCardMiniGameGui.handleButtonAction(entity, 21, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (Display20MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addButton(new Button(this.guiLeft + 67, this.guiTop + 83, 20, 20, new StringTextComponent(" "), e -> {
			if (Display28MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardMiniGameGui.ButtonPressedMessage(22, x, y, z));
				InfoCardMiniGameGui.handleButtonAction(entity, 22, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (Display28MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addButton(new Button(this.guiLeft + 67, this.guiTop + 103, 20, 20, new StringTextComponent(" "), e -> {
			if (Display36MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardMiniGameGui.ButtonPressedMessage(23, x, y, z));
				InfoCardMiniGameGui.handleButtonAction(entity, 23, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (Display36MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addButton(new Button(this.guiLeft + 67, this.guiTop + 123, 20, 20, new StringTextComponent(" "), e -> {
			if (Display44MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardMiniGameGui.ButtonPressedMessage(24, x, y, z));
				InfoCardMiniGameGui.handleButtonAction(entity, 24, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (Display44MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addButton(new Button(this.guiLeft + 47, this.guiTop + 123, 20, 20, new StringTextComponent(" "), e -> {
			if (Display43MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardMiniGameGui.ButtonPressedMessage(25, x, y, z));
				InfoCardMiniGameGui.handleButtonAction(entity, 25, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (Display43MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addButton(new Button(this.guiLeft + 87, this.guiTop + 43, 20, 20, new StringTextComponent(" "), e -> {
			if (Display13MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardMiniGameGui.ButtonPressedMessage(26, x, y, z));
				InfoCardMiniGameGui.handleButtonAction(entity, 26, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (Display13MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addButton(new Button(this.guiLeft + 87, this.guiTop + 63, 20, 20, new StringTextComponent(" "), e -> {
			if (Display21MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardMiniGameGui.ButtonPressedMessage(27, x, y, z));
				InfoCardMiniGameGui.handleButtonAction(entity, 27, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (Display21MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addButton(new Button(this.guiLeft + 87, this.guiTop + 83, 20, 20, new StringTextComponent(" "), e -> {
			if (Display29MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardMiniGameGui.ButtonPressedMessage(28, x, y, z));
				InfoCardMiniGameGui.handleButtonAction(entity, 28, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (Display29MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addButton(new Button(this.guiLeft + 87, this.guiTop + 103, 20, 20, new StringTextComponent(" "), e -> {
			if (Display37MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardMiniGameGui.ButtonPressedMessage(29, x, y, z));
				InfoCardMiniGameGui.handleButtonAction(entity, 29, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (Display37MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addButton(new Button(this.guiLeft + 87, this.guiTop + 123, 20, 20, new StringTextComponent(" "), e -> {
			if (Display45MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardMiniGameGui.ButtonPressedMessage(30, x, y, z));
				InfoCardMiniGameGui.handleButtonAction(entity, 30, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (Display45MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addButton(new Button(this.guiLeft + 107, this.guiTop + 23, 20, 20, new StringTextComponent(" "), e -> {
			if (Display6MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardMiniGameGui.ButtonPressedMessage(31, x, y, z));
				InfoCardMiniGameGui.handleButtonAction(entity, 31, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (Display6MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addButton(new Button(this.guiLeft + 107, this.guiTop + 43, 20, 20, new StringTextComponent(" "), e -> {
			if (Display14MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardMiniGameGui.ButtonPressedMessage(32, x, y, z));
				InfoCardMiniGameGui.handleButtonAction(entity, 32, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (Display14MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addButton(new Button(this.guiLeft + 107, this.guiTop + 63, 20, 20, new StringTextComponent(" "), e -> {
			if (Display22MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardMiniGameGui.ButtonPressedMessage(33, x, y, z));
				InfoCardMiniGameGui.handleButtonAction(entity, 33, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (Display22MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addButton(new Button(this.guiLeft + 107, this.guiTop + 83, 20, 20, new StringTextComponent(" "), e -> {
			if (Display30MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardMiniGameGui.ButtonPressedMessage(34, x, y, z));
				InfoCardMiniGameGui.handleButtonAction(entity, 34, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (Display30MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addButton(new Button(this.guiLeft + 107, this.guiTop + 103, 20, 20, new StringTextComponent(" "), e -> {
			if (Display38MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardMiniGameGui.ButtonPressedMessage(35, x, y, z));
				InfoCardMiniGameGui.handleButtonAction(entity, 35, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (Display38MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addButton(new Button(this.guiLeft + 107, this.guiTop + 123, 20, 20, new StringTextComponent(" "), e -> {
			if (Display46MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardMiniGameGui.ButtonPressedMessage(36, x, y, z));
				InfoCardMiniGameGui.handleButtonAction(entity, 36, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (Display46MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addButton(new Button(this.guiLeft + 127, this.guiTop + 23, 20, 20, new StringTextComponent(" "), e -> {
			if (Display7MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardMiniGameGui.ButtonPressedMessage(37, x, y, z));
				InfoCardMiniGameGui.handleButtonAction(entity, 37, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (Display7MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addButton(new Button(this.guiLeft + 127, this.guiTop + 43, 20, 20, new StringTextComponent(" "), e -> {
			if (Display15MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardMiniGameGui.ButtonPressedMessage(38, x, y, z));
				InfoCardMiniGameGui.handleButtonAction(entity, 38, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (Display15MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addButton(new Button(this.guiLeft + 127, this.guiTop + 63, 20, 20, new StringTextComponent(" "), e -> {
			if (Display23MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardMiniGameGui.ButtonPressedMessage(39, x, y, z));
				InfoCardMiniGameGui.handleButtonAction(entity, 39, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (Display23MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addButton(new Button(this.guiLeft + 127, this.guiTop + 83, 20, 20, new StringTextComponent(" "), e -> {
			if (Display31MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardMiniGameGui.ButtonPressedMessage(40, x, y, z));
				InfoCardMiniGameGui.handleButtonAction(entity, 40, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (Display31MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addButton(new Button(this.guiLeft + 127, this.guiTop + 103, 20, 20, new StringTextComponent(" "), e -> {
			if (Display39MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardMiniGameGui.ButtonPressedMessage(41, x, y, z));
				InfoCardMiniGameGui.handleButtonAction(entity, 41, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (Display39MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addButton(new Button(this.guiLeft + 127, this.guiTop + 123, 20, 20, new StringTextComponent(" "), e -> {
			if (Display47MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardMiniGameGui.ButtonPressedMessage(42, x, y, z));
				InfoCardMiniGameGui.handleButtonAction(entity, 42, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (Display47MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addButton(new Button(this.guiLeft + 147, this.guiTop + 123, 20, 20, new StringTextComponent(" "), e -> {
			if (Display48MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardMiniGameGui.ButtonPressedMessage(43, x, y, z));
				InfoCardMiniGameGui.handleButtonAction(entity, 43, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (Display48MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addButton(new Button(this.guiLeft + 147, this.guiTop + 103, 20, 20, new StringTextComponent(" "), e -> {
			if (Display40MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardMiniGameGui.ButtonPressedMessage(44, x, y, z));
				InfoCardMiniGameGui.handleButtonAction(entity, 44, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (Display40MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addButton(new Button(this.guiLeft + 147, this.guiTop + 83, 20, 20, new StringTextComponent(" "), e -> {
			if (Display32MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardMiniGameGui.ButtonPressedMessage(45, x, y, z));
				InfoCardMiniGameGui.handleButtonAction(entity, 45, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (Display32MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addButton(new Button(this.guiLeft + 147, this.guiTop + 63, 20, 20, new StringTextComponent(" "), e -> {
			if (Display24MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardMiniGameGui.ButtonPressedMessage(46, x, y, z));
				InfoCardMiniGameGui.handleButtonAction(entity, 46, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (Display24MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addButton(new Button(this.guiLeft + 147, this.guiTop + 43, 20, 20, new StringTextComponent(" "), e -> {
			if (Display16MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardMiniGameGui.ButtonPressedMessage(47, x, y, z));
				InfoCardMiniGameGui.handleButtonAction(entity, 47, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (Display16MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addButton(new Button(this.guiLeft + 147, this.guiTop + 23, 20, 20, new StringTextComponent(" "), e -> {
			if (Display8MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardMiniGameGui.ButtonPressedMessage(48, x, y, z));
				InfoCardMiniGameGui.handleButtonAction(entity, 48, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (Display8MiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
	}
}
