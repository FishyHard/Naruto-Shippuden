
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

import net.mcreator.narutoshippudenmod.procedures.DisplayYukiSelectProcedure;
import net.mcreator.narutoshippudenmod.procedures.DisplayWindSelectProcedure;
import net.mcreator.narutoshippudenmod.procedures.DisplayWaterSelectProcedure;
import net.mcreator.narutoshippudenmod.procedures.DisplayUzumakiSelectProcedure;
import net.mcreator.narutoshippudenmod.procedures.DisplayUchihaSelectProcedure;
import net.mcreator.narutoshippudenmod.procedures.DisplayTsuchigumoSelectProcedure;
import net.mcreator.narutoshippudenmod.procedures.DisplayTenroSelectProcedure;
import net.mcreator.narutoshippudenmod.procedures.DisplayStoneSelectProcedure;
import net.mcreator.narutoshippudenmod.procedures.DisplayShimuraSelectProcedure;
import net.mcreator.narutoshippudenmod.procedures.DisplaySenjuSelectProcedure;
import net.mcreator.narutoshippudenmod.procedures.DisplaySandSelectProcedure;
import net.mcreator.narutoshippudenmod.procedures.DisplayOtsutsukiSelectProcedure;
import net.mcreator.narutoshippudenmod.procedures.DisplayNaraSelectProcedure;
import net.mcreator.narutoshippudenmod.procedures.DisplayNamikazeSelectProcedure;
import net.mcreator.narutoshippudenmod.procedures.DisplayMistSelectProcedure;
import net.mcreator.narutoshippudenmod.procedures.DisplayLightningSelectProcedure;
import net.mcreator.narutoshippudenmod.procedures.DisplayLeeSelectProcedure;
import net.mcreator.narutoshippudenmod.procedures.DisplayKuramaSelectProcedure;
import net.mcreator.narutoshippudenmod.procedures.DisplayKonohaSelectProcedure;
import net.mcreator.narutoshippudenmod.procedures.DisplayKazekageSelectProcedure;
import net.mcreator.narutoshippudenmod.procedures.DisplayInuzukaSelectProcedure;
import net.mcreator.narutoshippudenmod.procedures.DisplayIburiSelectProcedure;
import net.mcreator.narutoshippudenmod.procedures.DisplayHyugaSelectProcedure;
import net.mcreator.narutoshippudenmod.procedures.DisplayHatakeSelectProcedure;
import net.mcreator.narutoshippudenmod.procedures.DisplayFireSelectProcedure;
import net.mcreator.narutoshippudenmod.procedures.DisplayEarthSelectProcedure;
import net.mcreator.narutoshippudenmod.procedures.DisplayCloudSelectProcedure;
import net.mcreator.narutoshippudenmod.procedures.DisplayChinoikeSelectProcedure;
import net.mcreator.narutoshippudenmod.procedures.DisplayAkimichiSelectProcedure;
import net.mcreator.narutoshippudenmod.procedures.DisplayAburameSelectProcedure;
import net.mcreator.narutoshippudenmod.procedures.DiplaySarutobiSelectProcedure;
import net.mcreator.narutoshippudenmod.procedures.DiplayKaguyaSelectProcedure;
import net.mcreator.narutoshippudenmod.procedures.DiplayIzunoSelectProcedure;
import net.mcreator.narutoshippudenmod.procedures.DiplayHozukiSelectProcedure;
import net.mcreator.narutoshippudenmod.procedures.DiplayHoshigakiSelectProcedure;
import net.mcreator.narutoshippudenmod.procedures.DiplayFumaSelectProcedure;
import net.mcreator.narutoshippudenmod.NarutoShippudenMod;

import java.util.stream.Stream;
import java.util.Map;
import java.util.HashMap;
import java.util.AbstractMap;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class StatSelectGuiWindow extends ContainerScreen<StatSelectGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	private final static HashMap guistate = StatSelectGui.guistate;

	public StatSelectGuiWindow(StatSelectGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
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
		if (DisplayFireSelectProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/fire_release.png"));
			this.blit(ms, this.guiLeft + 72, this.guiTop + 78, 0, 0, 32, 32, 32, 32);
		}
		if (DisplayEarthSelectProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/earth_release.png"));
			this.blit(ms, this.guiLeft + 72, this.guiTop + 78, 0, 0, 32, 32, 32, 32);
		}
		if (DisplayLightningSelectProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/lightning_release.png"));
			this.blit(ms, this.guiLeft + 72, this.guiTop + 78, 0, 0, 32, 32, 32, 32);
		}
		if (DisplayWaterSelectProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/water_release.png"));
			this.blit(ms, this.guiLeft + 72, this.guiTop + 78, 0, 0, 32, 32, 32, 32);
		}
		if (DisplayWindSelectProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/wind_release.png"));
			this.blit(ms, this.guiLeft + 72, this.guiTop + 78, 0, 0, 32, 32, 32, 32);
		}
		if (DisplayUchihaSelectProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/uchiha.png"));
			this.blit(ms, this.guiLeft + 72, this.guiTop + -8, 0, 0, 32, 32, 32, 32);
		}
		if (DisplayUzumakiSelectProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/uzumaki.png"));
			this.blit(ms, this.guiLeft + 72, this.guiTop + -8, 0, 0, 32, 32, 32, 32);
		}
		if (DisplayHyugaSelectProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/hyuga.png"));
			this.blit(ms, this.guiLeft + 72, this.guiTop + -8, 0, 0, 32, 32, 32, 32);
		}
		if (DisplayHatakeSelectProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/hatake.png"));
			this.blit(ms, this.guiLeft + 72, this.guiTop + -8, 0, 0, 32, 32, 32, 32);
		}
		if (DisplayIburiSelectProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/iburi.png"));
			this.blit(ms, this.guiLeft + 72, this.guiTop + -8, 0, 0, 32, 32, 32, 32);
		}
		if (DisplayAburameSelectProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/aburame.png"));
			this.blit(ms, this.guiLeft + 72, this.guiTop + -8, 0, 0, 32, 32, 32, 32);
		}
		if (DisplayAkimichiSelectProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/akimichi.png"));
			this.blit(ms, this.guiLeft + 72, this.guiTop + -8, 0, 0, 32, 32, 32, 32);
		}
		if (DisplayChinoikeSelectProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/chinoike.png"));
			this.blit(ms, this.guiLeft + 72, this.guiTop + -8, 0, 0, 32, 32, 32, 32);
		}
		if (DisplayInuzukaSelectProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/inuzuka.png"));
			this.blit(ms, this.guiLeft + 72, this.guiTop + -8, 0, 0, 32, 32, 32, 32);
		}
		if (DisplayKazekageSelectProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/kazekage.png"));
			this.blit(ms, this.guiLeft + 72, this.guiTop + -8, 0, 0, 32, 32, 32, 32);
		}
		if (DisplayLeeSelectProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/lee.png"));
			this.blit(ms, this.guiLeft + 72, this.guiTop + -8, 0, 0, 32, 32, 32, 32);
		}
		if (DisplayNamikazeSelectProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/namikaze.png"));
			this.blit(ms, this.guiLeft + 72, this.guiTop + -8, 0, 0, 32, 32, 32, 32);
		}
		if (DisplayNaraSelectProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/nara.png"));
			this.blit(ms, this.guiLeft + 72, this.guiTop + -8, 0, 0, 32, 32, 32, 32);
		}
		if (DisplayOtsutsukiSelectProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/otsutsuki.png"));
			this.blit(ms, this.guiLeft + 72, this.guiTop + -8, 0, 0, 32, 32, 32, 32);
		}
		if (DisplaySenjuSelectProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/senju.png"));
			this.blit(ms, this.guiLeft + 72, this.guiTop + -8, 0, 0, 32, 32, 32, 32);
		}
		if (DisplayTenroSelectProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/tenro.png"));
			this.blit(ms, this.guiLeft + 57, this.guiTop + -20, 0, 0, 64, 64, 64, 64);
		}
		if (DisplayTsuchigumoSelectProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/tsuchigumo.png"));
			this.blit(ms, this.guiLeft + 72, this.guiTop + -8, 0, 0, 32, 32, 32, 32);
		}
		if (DisplayYukiSelectProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/yuki.png"));
			this.blit(ms, this.guiLeft + 72, this.guiTop + -8, 0, 0, 32, 32, 32, 32);
		}
		if (DisplayShimuraSelectProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/shimura.png"));
			this.blit(ms, this.guiLeft + 72, this.guiTop + -8, 0, 0, 32, 32, 32, 32);
		}
		if (DisplayKonohaSelectProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/konohagakure.png"));
			this.blit(ms, this.guiLeft + 72, this.guiTop + 34, 0, 0, 32, 32, 32, 32);
		}
		if (DisplayMistSelectProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/kirigakure.png"));
			this.blit(ms, this.guiLeft + 72, this.guiTop + 34, 0, 0, 32, 32, 32, 32);
		}
		if (DisplayStoneSelectProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/iwagakure.png"));
			this.blit(ms, this.guiLeft + 72, this.guiTop + 34, 0, 0, 32, 32, 32, 32);
		}
		if (DisplayCloudSelectProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/kumogakure.png"));
			this.blit(ms, this.guiLeft + 72, this.guiTop + 34, 0, 0, 32, 32, 32, 32);
		}
		if (DisplaySandSelectProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/sunagakure.png"));
			this.blit(ms, this.guiLeft + 72, this.guiTop + 34, 0, 0, 32, 32, 32, 32);
		}
		if (DisplayKuramaSelectProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/kurama_clan.png"));
			this.blit(ms, this.guiLeft + 72, this.guiTop + -8, 0, 0, 32, 32, 32, 32);
		}
		if (DiplaySarutobiSelectProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/sarutobi.png"));
			this.blit(ms, this.guiLeft + 72, this.guiTop + -8, 0, 0, 32, 32, 32, 32);
		}
		if (DiplayFumaSelectProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/fuuma.png"));
			this.blit(ms, this.guiLeft + 72, this.guiTop + -8, 0, 0, 32, 32, 32, 32);
		}
		if (DiplayHoshigakiSelectProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/hoshigaki.png"));
			this.blit(ms, this.guiLeft + 72, this.guiTop + -8, 0, 0, 32, 32, 32, 32);
		}
		if (DiplayHozukiSelectProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/hozuki.png"));
			this.blit(ms, this.guiLeft + 72, this.guiTop + -8, 0, 0, 32, 32, 32, 32);
		}
		if (DiplayKaguyaSelectProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/kaguya.png"));
			this.blit(ms, this.guiLeft + 72, this.guiTop + -8, 0, 0, 32, 32, 32, 32);
		}
		if (DiplayIzunoSelectProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/izuno.png"));
			this.blit(ms, this.guiLeft + 72, this.guiTop + -8, 0, 0, 32, 32, 32, 32);
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
		this.font.drawString(ms, "Clan", 77, 24, -1);
		this.font.drawString(ms, "Village", 70, 66, -1);
		this.font.drawString(ms, "Nature", 72, 109, -1);
		this.font.drawString(ms, "Release", 70, 118, -1);
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
		this.addButton(new Button(this.guiLeft + 55, this.guiTop + 0, 8, 20, new StringTextComponent("<"), e -> {
			if (true) {
				NarutoShippudenMod.PACKET_HANDLER.sendToServer(new StatSelectGui.ButtonPressedMessage(0, x, y, z));
				StatSelectGui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 111, this.guiTop + 0, 8, 20, new StringTextComponent(">"), e -> {
			if (true) {
				NarutoShippudenMod.PACKET_HANDLER.sendToServer(new StatSelectGui.ButtonPressedMessage(1, x, y, z));
				StatSelectGui.handleButtonAction(entity, 1, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 55, this.guiTop + 40, 8, 20, new StringTextComponent("<"), e -> {
			if (true) {
				NarutoShippudenMod.PACKET_HANDLER.sendToServer(new StatSelectGui.ButtonPressedMessage(2, x, y, z));
				StatSelectGui.handleButtonAction(entity, 2, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 111, this.guiTop + 40, 8, 20, new StringTextComponent(">"), e -> {
			if (true) {
				NarutoShippudenMod.PACKET_HANDLER.sendToServer(new StatSelectGui.ButtonPressedMessage(3, x, y, z));
				StatSelectGui.handleButtonAction(entity, 3, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 59, this.guiTop + 140, 56, 20, new StringTextComponent("Select"), e -> {
			if (true) {
				NarutoShippudenMod.PACKET_HANDLER.sendToServer(new StatSelectGui.ButtonPressedMessage(4, x, y, z));
				StatSelectGui.handleButtonAction(entity, 4, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 55, this.guiTop + 84, 8, 20, new StringTextComponent("<"), e -> {
			if (true) {
				NarutoShippudenMod.PACKET_HANDLER.sendToServer(new StatSelectGui.ButtonPressedMessage(5, x, y, z));
				StatSelectGui.handleButtonAction(entity, 5, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 111, this.guiTop + 84, 8, 20, new StringTextComponent(">"), e -> {
			if (true) {
				NarutoShippudenMod.PACKET_HANDLER.sendToServer(new StatSelectGui.ButtonPressedMessage(6, x, y, z));
				StatSelectGui.handleButtonAction(entity, 6, x, y, z);
			}
		}));
	}
}
