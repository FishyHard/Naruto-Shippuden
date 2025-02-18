
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

import net.mcreator.narutoshippudenmod.procedures.DisplayYukiInfoProcedure;
import net.mcreator.narutoshippudenmod.procedures.DisplayWoodInfoProcedure;
import net.mcreator.narutoshippudenmod.procedures.DisplayWindInfoProcedure;
import net.mcreator.narutoshippudenmod.procedures.DisplayWaterInfoProcedure;
import net.mcreator.narutoshippudenmod.procedures.DisplayUzumakiInfoProcedure;
import net.mcreator.narutoshippudenmod.procedures.DisplayUchihaInfoProcedure;
import net.mcreator.narutoshippudenmod.procedures.DisplayTyphoonInfoProcedure;
import net.mcreator.narutoshippudenmod.procedures.DisplayTsuchigumoInfoProcedure;
import net.mcreator.narutoshippudenmod.procedures.DisplayTenseiganInfoProcedure;
import net.mcreator.narutoshippudenmod.procedures.DisplayTenroInfoProcedure;
import net.mcreator.narutoshippudenmod.procedures.DisplaySwiftInfoProcedure;
import net.mcreator.narutoshippudenmod.procedures.DisplayStormInfoProcedure;
import net.mcreator.narutoshippudenmod.procedures.DisplaySteelInfoProcedure;
import net.mcreator.narutoshippudenmod.procedures.DisplaySmokeInfoProcedure;
import net.mcreator.narutoshippudenmod.procedures.DisplayShimuraInfoProcedure;
import net.mcreator.narutoshippudenmod.procedures.DisplaySharinganInfoProcedure;
import net.mcreator.narutoshippudenmod.procedures.DisplaySenjuInfoProcedure;
import net.mcreator.narutoshippudenmod.procedures.DisplaySarutobiInfoProcedure;
import net.mcreator.narutoshippudenmod.procedures.DisplayRinneganInfoProcedure;
import net.mcreator.narutoshippudenmod.procedures.DisplayOtsutsukiInfoProcedure;
import net.mcreator.narutoshippudenmod.procedures.DisplayNaraInfoProcedure;
import net.mcreator.narutoshippudenmod.procedures.DisplayNamikazeInfoProcedure;
import net.mcreator.narutoshippudenmod.procedures.DisplayMagnetInfoProcedure;
import net.mcreator.narutoshippudenmod.procedures.DisplayMSShisuiInfoProcedure;
import net.mcreator.narutoshippudenmod.procedures.DisplayMSSasukeInfoProcedure;
import net.mcreator.narutoshippudenmod.procedures.DisplayMSObitoInfoProcedure;
import net.mcreator.narutoshippudenmod.procedures.DisplayMSMadaraInfoProcedure;
import net.mcreator.narutoshippudenmod.procedures.DisplayMSItachiInfoProcedure;
import net.mcreator.narutoshippudenmod.procedures.DisplayLightningInfoProcedure;
import net.mcreator.narutoshippudenmod.procedures.DisplayLeeInfoProcedure;
import net.mcreator.narutoshippudenmod.procedures.DisplayKuramaInfoProcedure;
import net.mcreator.narutoshippudenmod.procedures.DisplayKetsuryuganInfoProcedure;
import net.mcreator.narutoshippudenmod.procedures.DisplayKazekageInfoProcedure;
import net.mcreator.narutoshippudenmod.procedures.DisplayKaguyaInfoProcedure;
import net.mcreator.narutoshippudenmod.procedures.DisplayIzunoInfoProcedure;
import net.mcreator.narutoshippudenmod.procedures.DisplayIsshikiDojutsuInfoProcedure;
import net.mcreator.narutoshippudenmod.procedures.DisplayInuzukaInfoProcedure;
import net.mcreator.narutoshippudenmod.procedures.DisplayIceInfoProcedure;
import net.mcreator.narutoshippudenmod.procedures.DisplayIburiInfoProcedure;
import net.mcreator.narutoshippudenmod.procedures.DisplayHyugaInfoProcedure;
import net.mcreator.narutoshippudenmod.procedures.DisplayHozukiInfoProcedure;
import net.mcreator.narutoshippudenmod.procedures.DisplayHoshigakiInfoProcedure;
import net.mcreator.narutoshippudenmod.procedures.DisplayHatakeInfoProcedure;
import net.mcreator.narutoshippudenmod.procedures.DisplayFumaInfoProcedure;
import net.mcreator.narutoshippudenmod.procedures.DisplayFireInfoProcedure;
import net.mcreator.narutoshippudenmod.procedures.DisplayEarthInfoProcedure;
import net.mcreator.narutoshippudenmod.procedures.DisplayDustInfoProcedure;
import net.mcreator.narutoshippudenmod.procedures.DisplayChinoikeInfoProcedure;
import net.mcreator.narutoshippudenmod.procedures.DisplayByakuganInfoProcedure;
import net.mcreator.narutoshippudenmod.procedures.DisplayBoneInfoProcedure;
import net.mcreator.narutoshippudenmod.procedures.DisplayBoilInfoProcedure;
import net.mcreator.narutoshippudenmod.procedures.DisplayAkimichiInfoProcedure;
import net.mcreator.narutoshippudenmod.procedures.DisplayAburameInfoProcedure;
import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables;
import net.mcreator.narutoshippudenmod.NarutoShippudenMod;

import java.util.stream.Stream;
import java.util.Map;
import java.util.HashMap;
import java.util.AbstractMap;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class InfoCardGuiWindow extends ContainerScreen<InfoCardGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	private final static HashMap guistate = InfoCardGui.guistate;

	public InfoCardGuiWindow(InfoCardGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
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

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/info_card_texture.png"));
		this.blit(ms, this.guiLeft + -126, this.guiTop + -39, 0, 0, 350, 250, 350, 250);

		if (DisplayAburameInfoProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/aburame.png"));
			this.blit(ms, this.guiLeft + -80, this.guiTop + 138, 0, 0, 32, 32, 32, 32);
		}
		if (DisplayAkimichiInfoProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/akimichi.png"));
			this.blit(ms, this.guiLeft + -80, this.guiTop + 138, 0, 0, 32, 32, 32, 32);
		}
		if (DisplayChinoikeInfoProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/chinoike.png"));
			this.blit(ms, this.guiLeft + -80, this.guiTop + 138, 0, 0, 32, 32, 32, 32);
		}
		if (DisplayHatakeInfoProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/hatake.png"));
			this.blit(ms, this.guiLeft + -80, this.guiTop + 138, 0, 0, 32, 32, 32, 32);
		}
		if (DisplayHyugaInfoProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/hyuga.png"));
			this.blit(ms, this.guiLeft + -80, this.guiTop + 138, 0, 0, 32, 32, 32, 32);
		}
		if (DisplayIburiInfoProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/iburi.png"));
			this.blit(ms, this.guiLeft + -80, this.guiTop + 138, 0, 0, 32, 32, 32, 32);
		}
		if (DisplayInuzukaInfoProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/inuzuka.png"));
			this.blit(ms, this.guiLeft + -80, this.guiTop + 138, 0, 0, 32, 32, 32, 32);
		}
		if (DisplayKazekageInfoProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/kazekage.png"));
			this.blit(ms, this.guiLeft + -80, this.guiTop + 138, 0, 0, 32, 32, 32, 32);
		}
		if (DisplayLeeInfoProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/lee.png"));
			this.blit(ms, this.guiLeft + -80, this.guiTop + 138, 0, 0, 32, 32, 32, 32);
		}
		if (DisplayNamikazeInfoProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/namikaze.png"));
			this.blit(ms, this.guiLeft + -80, this.guiTop + 138, 0, 0, 32, 32, 32, 32);
		}
		if (DisplayNaraInfoProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/nara.png"));
			this.blit(ms, this.guiLeft + -80, this.guiTop + 138, 0, 0, 32, 32, 32, 32);
		}
		if (DisplayOtsutsukiInfoProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/otsutsuki.png"));
			this.blit(ms, this.guiLeft + -80, this.guiTop + 138, 0, 0, 32, 32, 32, 32);
		}
		if (DisplaySenjuInfoProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/senju.png"));
			this.blit(ms, this.guiLeft + -80, this.guiTop + 138, 0, 0, 32, 32, 32, 32);
		}
		if (DisplayShimuraInfoProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/shimura.png"));
			this.blit(ms, this.guiLeft + -80, this.guiTop + 138, 0, 0, 32, 32, 32, 32);
		}
		if (DisplayTenroInfoProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/tenro.png"));
			this.blit(ms, this.guiLeft + -80, this.guiTop + 138, 0, 0, 32, 32, 32, 32);
		}
		if (DisplayTsuchigumoInfoProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/tsuchigumo.png"));
			this.blit(ms, this.guiLeft + -80, this.guiTop + 138, 0, 0, 32, 32, 32, 32);
		}
		if (DisplayUchihaInfoProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/uchiha.png"));
			this.blit(ms, this.guiLeft + -80, this.guiTop + 138, 0, 0, 32, 32, 32, 32);
		}
		if (DisplayUzumakiInfoProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/uzumaki.png"));
			this.blit(ms, this.guiLeft + -80, this.guiTop + 138, 0, 0, 32, 32, 32, 32);
		}
		if (DisplayYukiInfoProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/yuki.png"));
			this.blit(ms, this.guiLeft + -80, this.guiTop + 138, 0, 0, 32, 32, 32, 32);
		}
		if (DisplayFireInfoProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/fire_release_info.png"));
			this.blit(ms, this.guiLeft + 57, this.guiTop + 157, 0, 0, 16, 16, 16, 16);
		}
		if (DisplayLightningInfoProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager()
					.bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/lightning_release_info.png"));
			this.blit(ms, this.guiLeft + 76, this.guiTop + 157, 0, 0, 16, 16, 16, 16);
		}
		if (DisplayWindInfoProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/wind_release_info.png"));
			this.blit(ms, this.guiLeft + 95, this.guiTop + 157, 0, 0, 16, 16, 16, 16);
		}
		if (DisplayWaterInfoProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/water_release_info.png"));
			this.blit(ms, this.guiLeft + 114, this.guiTop + 157, 0, 0, 16, 16, 16, 16);
		}
		if (DisplayEarthInfoProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/earth_release_info.png"));
			this.blit(ms, this.guiLeft + 133, this.guiTop + 157, 0, 0, 16, 16, 16, 16);
		}
		if (DisplayFumaInfoProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/fuuma.png"));
			this.blit(ms, this.guiLeft + -80, this.guiTop + 138, 0, 0, 32, 32, 32, 32);
		}
		if (DisplayHoshigakiInfoProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/hoshigaki.png"));
			this.blit(ms, this.guiLeft + -80, this.guiTop + 138, 0, 0, 32, 32, 32, 32);
		}
		if (DisplayHozukiInfoProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/hozuki.png"));
			this.blit(ms, this.guiLeft + -80, this.guiTop + 138, 0, 0, 32, 32, 32, 32);
		}
		if (DisplayIzunoInfoProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/izuno.png"));
			this.blit(ms, this.guiLeft + -80, this.guiTop + 138, 0, 0, 32, 32, 32, 32);
		}
		if (DisplayKaguyaInfoProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/kaguya.png"));
			this.blit(ms, this.guiLeft + -80, this.guiTop + 138, 0, 0, 32, 32, 32, 32);
		}
		if (DisplayKuramaInfoProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/kurama_clan.png"));
			this.blit(ms, this.guiLeft + -80, this.guiTop + 138, 0, 0, 32, 32, 32, 32);
		}
		if (DisplaySarutobiInfoProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/sarutobi.png"));
			this.blit(ms, this.guiLeft + -80, this.guiTop + 138, 0, 0, 32, 32, 32, 32);
		}
		if (DisplayIceInfoProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/ice_release.png"));
			this.blit(ms, this.guiLeft + 57, this.guiTop + 13, 0, 0, 16, 16, 16, 16);
		}
		if (DisplayWoodInfoProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/wood_release.png"));
			this.blit(ms, this.guiLeft + 76, this.guiTop + 13, 0, 0, 16, 16, 16, 16);
		}
		if (DisplayMagnetInfoProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/magnet_release.png"));
			this.blit(ms, this.guiLeft + 95, this.guiTop + 13, 0, 0, 16, 16, 16, 16);
		}
		if (DisplayStormInfoProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/storm_release.png"));
			this.blit(ms, this.guiLeft + 114, this.guiTop + 13, 0, 0, 16, 16, 16, 16);
		}
		if (DisplaySmokeInfoProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/smoke_release.png"));
			this.blit(ms, this.guiLeft + 133, this.guiTop + 13, 0, 0, 16, 16, 16, 16);
		}
		if (DisplaySteelInfoProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/steel_release.png"));
			this.blit(ms, this.guiLeft + 152, this.guiTop + 13, 0, 0, 16, 16, 16, 16);
		}
		if (DisplayBoilInfoProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/boil_release.png"));
			this.blit(ms, this.guiLeft + 171, this.guiTop + 13, 0, 0, 16, 16, 16, 16);
		}
		if (DisplayBoneInfoProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/bone_release.png"));
			this.blit(ms, this.guiLeft + 190, this.guiTop + 13, 0, 0, 16, 16, 16, 16);
		}
		if (DisplaySwiftInfoProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/swift_release.png"));
			this.blit(ms, this.guiLeft + 57, this.guiTop + 32, 0, 0, 16, 16, 16, 16);
		}
		if (DisplayTyphoonInfoProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/typhoon_release.png"));
			this.blit(ms, this.guiLeft + 76, this.guiTop + 32, 0, 0, 16, 16, 16, 16);
		}
		if (DisplayDustInfoProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/dust_release.png"));
			this.blit(ms, this.guiLeft + 95, this.guiTop + 32, 0, 0, 16, 16, 16, 16);
		}
		if (DisplaySharinganInfoProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/sharingan.png"));
			this.blit(ms, this.guiLeft + 57, this.guiTop + 109, 0, 0, 16, 16, 16, 16);
		}
		if (DisplayByakuganInfoProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/byakugan.png"));
			this.blit(ms, this.guiLeft + 76, this.guiTop + 109, 0, 0, 16, 16, 16, 16);
		}
		if (DisplayKetsuryuganInfoProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/ketsuryugan.png"));
			this.blit(ms, this.guiLeft + 95, this.guiTop + 109, 0, 0, 16, 16, 16, 16);
		}
		if (DisplayMSItachiInfoProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager()
					.bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/mangekyou_sharingan_itachi.png"));
			this.blit(ms, this.guiLeft + 57, this.guiTop + 90, 0, 0, 16, 16, 16, 16);
		}
		if (DisplayMSMadaraInfoProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager()
					.bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/mangekyou_sharingan_madara.png"));
			this.blit(ms, this.guiLeft + 57, this.guiTop + 90, 0, 0, 16, 16, 16, 16);
		}
		if (DisplayMSObitoInfoProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager()
					.bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/mangekyou_sharingan_obito.png"));
			this.blit(ms, this.guiLeft + 57, this.guiTop + 90, 0, 0, 16, 16, 16, 16);
		}
		if (DisplayMSSasukeInfoProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager()
					.bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/mangekyou_sharingan_sasuke.png"));
			this.blit(ms, this.guiLeft + 57, this.guiTop + 90, 0, 0, 16, 16, 16, 16);
		}
		if (DisplayMSShisuiInfoProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager()
					.bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/mangekyou_sharingan_shisui.png"));
			this.blit(ms, this.guiLeft + 57, this.guiTop + 90, 0, 0, 16, 16, 16, 16);
		}
		if (DisplayTenseiganInfoProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/tenseigan.png"));
			this.blit(ms, this.guiLeft + 76, this.guiTop + 90, 0, 0, 16, 16, 16, 16);
		}
		if (DisplayRinneganInfoProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/rinnegan.png"));
			this.blit(ms, this.guiLeft + 57, this.guiTop + 71, 0, 0, 16, 16, 16, 16);
		}
		if (DisplayIsshikiDojutsuInfoProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/isshiki_dojutsu.png"));
			this.blit(ms, this.guiLeft + 114, this.guiTop + 109, 0, 0, 16, 16, 16, 16);
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
		this.font.drawString(ms, "LvL XP Max:", 121, -13, -16777216);
		this.font.drawString(ms, "" + (int) ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).sp) + "", 196, -23, -16777216);
		this.font.drawString(ms, "SP:", 179, -23, -16777216);
		this.font.drawString(ms, "" + (int) ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).jp) + "", 138, -23, -16777216);
		this.font.drawString(ms, "JP:", 121, -23, -16777216);
		this.font.drawString(ms, "" + ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).rank) + "", -78, 118, -16777216);
		this.font.drawString(ms, "Level:", 52, -23, -16777216);
		this.font.drawString(ms, "" + (int) ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).LEVELSTAT) + "", 85, -23, -16777216);
		this.font.drawString(ms, "LvL XP:", 52, -13, -16777216);
		this.font.drawString(ms, "" + (int) ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).LEVEL) + "", 89, -13, -16777216);
		this.font.drawString(ms, "" + (int) ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).LEVELMAX) + "", 180, -13, -16777216);
		this.font.drawString(ms, "" + ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).village) + "", -71, 87, -16777216);
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
		this.addButton(new Button(this.guiLeft + -105, this.guiTop + 182, 68, 20, new StringTextComponent("Next Page"), e -> {
			if (true) {
				NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardGui.ButtonPressedMessage(0, x, y, z));
				InfoCardGui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + -13, this.guiTop + -20, 56, 20, new StringTextComponent("Quests"), e -> {
			if (true) {
				NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardGui.ButtonPressedMessage(1, x, y, z));
				InfoCardGui.handleButtonAction(entity, 1, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + -13, this.guiTop + 5, 56, 20, new StringTextComponent("Mini Game"), e -> {
			if (true) {
				NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardGui.ButtonPressedMessage(2, x, y, z));
				InfoCardGui.handleButtonAction(entity, 2, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + -13, this.guiTop + 30, 56, 20, new StringTextComponent("Dojutsu"), e -> {
			if (true) {
				NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardGui.ButtonPressedMessage(3, x, y, z));
				InfoCardGui.handleButtonAction(entity, 3, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + -13, this.guiTop + 55, 56, 20, new StringTextComponent("Jutsu"), e -> {
			if (true) {
				NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardGui.ButtonPressedMessage(4, x, y, z));
				InfoCardGui.handleButtonAction(entity, 4, x, y, z);
			}
		}));
	}
}
