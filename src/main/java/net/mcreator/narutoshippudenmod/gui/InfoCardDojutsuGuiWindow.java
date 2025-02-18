
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

import net.mcreator.narutoshippudenmod.procedures.DisplayVoltic2x2Pupils2x1Procedure;
import net.mcreator.narutoshippudenmod.procedures.DisplayVoltic2x2Pupils1x1Procedure;
import net.mcreator.narutoshippudenmod.procedures.DisplayVoltic2x1Pupils2x1Procedure;
import net.mcreator.narutoshippudenmod.procedures.DisplayVoltic2x1Pupils1x1Procedure;
import net.mcreator.narutoshippudenmod.procedures.DisplayTenseigan2x2Pupils1x1Procedure;
import net.mcreator.narutoshippudenmod.procedures.DisplayTenseigan2x21Pupils2x1Procedure;
import net.mcreator.narutoshippudenmod.procedures.DisplayTenseigan2x1Pupils2x1Procedure;
import net.mcreator.narutoshippudenmod.procedures.DisplayTenseigan2x1Pupils1x1Procedure;
import net.mcreator.narutoshippudenmod.procedures.DisplayShisuiDojutsu2x2Pupils2x1Procedure;
import net.mcreator.narutoshippudenmod.procedures.DisplayShisuiDojutsu2x2Pupils1x1Procedure;
import net.mcreator.narutoshippudenmod.procedures.DisplayShisuiDojutsu2x1Pupils2x1Procedure;
import net.mcreator.narutoshippudenmod.procedures.DisplayShisuiDojutsu2x1Pupils1x1Procedure;
import net.mcreator.narutoshippudenmod.procedures.DisplaySharingan2x2Pupils2x1Procedure;
import net.mcreator.narutoshippudenmod.procedures.DisplaySharingan2x2Pupils1x1Procedure;
import net.mcreator.narutoshippudenmod.procedures.DisplaySharingan2x1Pupils2x1Procedure;
import net.mcreator.narutoshippudenmod.procedures.DisplaySharingan2x1Pupils1x1Procedure;
import net.mcreator.narutoshippudenmod.procedures.DisplayScarProcedure;
import net.mcreator.narutoshippudenmod.procedures.DisplaySasukeDojutsu2x2Pupils2x1Procedure;
import net.mcreator.narutoshippudenmod.procedures.DisplaySasukeDojutsu2x2Pupils1x1Procedure;
import net.mcreator.narutoshippudenmod.procedures.DisplaySasukeDojutsu2x1Pupils2x1Procedure;
import net.mcreator.narutoshippudenmod.procedures.DisplaySasukeDojutsu2x1Pupils1x1Procedure;
import net.mcreator.narutoshippudenmod.procedures.DisplayRinnegan2x2Pupils2x1Procedure;
import net.mcreator.narutoshippudenmod.procedures.DisplayRinnegan2x2Pupils1x1Procedure;
import net.mcreator.narutoshippudenmod.procedures.DisplayRinnegan2x1Pupils2x1Procedure;
import net.mcreator.narutoshippudenmod.procedures.DisplayRinnegan2x1Pupils1x1Procedure;
import net.mcreator.narutoshippudenmod.procedures.DisplayObitoDojutsu2x2Pupils2x1Procedure;
import net.mcreator.narutoshippudenmod.procedures.DisplayObitoDojutsu2x2Pupils1x1Procedure;
import net.mcreator.narutoshippudenmod.procedures.DisplayObitoDojutsu2x1Pupils2x1Procedure;
import net.mcreator.narutoshippudenmod.procedures.DisplayObitoDojutsu2x1Pupils1x1Procedure;
import net.mcreator.narutoshippudenmod.procedures.DisplayMinus2SelectProcedure;
import net.mcreator.narutoshippudenmod.procedures.DisplayMarcus2x2Pupils2x1Procedure;
import net.mcreator.narutoshippudenmod.procedures.DisplayMarcus2x2Pupils1x1Procedure;
import net.mcreator.narutoshippudenmod.procedures.DisplayMarcus2x1Pupils2x1Procedure;
import net.mcreator.narutoshippudenmod.procedures.DisplayMarcus2x1Pupils1x1Procedure;
import net.mcreator.narutoshippudenmod.procedures.DisplayMadaraDojutsu2x2Pupils2x1Procedure;
import net.mcreator.narutoshippudenmod.procedures.DisplayMadaraDojutsu2x2Pupils1x1Procedure;
import net.mcreator.narutoshippudenmod.procedures.DisplayMadaraDojutsu2x1Pupils2x1Procedure;
import net.mcreator.narutoshippudenmod.procedures.DisplayMadaraDojutsu2x1Pupils1x1Procedure;
import net.mcreator.narutoshippudenmod.procedures.DisplayKetsuryugan2x2Pupils2x1Procedure;
import net.mcreator.narutoshippudenmod.procedures.DisplayKetsuryugan2x2Pupils1x1Procedure;
import net.mcreator.narutoshippudenmod.procedures.DisplayKetsuryugan2x1Pupils2x1Procedure;
import net.mcreator.narutoshippudenmod.procedures.DisplayKetsuryugan2x1Pupils1x1Procedure;
import net.mcreator.narutoshippudenmod.procedures.DisplayKakashiDojutsu2x2Pupils2x1Procedure;
import net.mcreator.narutoshippudenmod.procedures.DisplayKakashiDojutsu2x2Pupils1x1Procedure;
import net.mcreator.narutoshippudenmod.procedures.DisplayKakashiDojutsu2x1Pupils2x1Procedure;
import net.mcreator.narutoshippudenmod.procedures.DisplayKakashiDojutsu2x1Pupils1x1Procedure;
import net.mcreator.narutoshippudenmod.procedures.DisplayKakashi1Dojutsu2x2Pupils2x1Procedure;
import net.mcreator.narutoshippudenmod.procedures.DisplayKakashi1Dojutsu2x2Pupils1x1Procedure;
import net.mcreator.narutoshippudenmod.procedures.DisplayKakashi1Dojutsu2x1Pupils2x1Procedure;
import net.mcreator.narutoshippudenmod.procedures.DisplayKakashi1Dojutsu2x1Pupils1x1Procedure;
import net.mcreator.narutoshippudenmod.procedures.DisplayItachiDojutsu2x2Pupils2x1Procedure;
import net.mcreator.narutoshippudenmod.procedures.DisplayItachiDojutsu2x2Pupils1x1Procedure;
import net.mcreator.narutoshippudenmod.procedures.DisplayItachiDojutsu2x1Pupils2x1Procedure;
import net.mcreator.narutoshippudenmod.procedures.DisplayItachiDojutsu2x1Pupils1x1Procedure;
import net.mcreator.narutoshippudenmod.procedures.DisplayIsshikiDojutsu2x2Pupils2x1Procedure;
import net.mcreator.narutoshippudenmod.procedures.DisplayIsshikiDojutsu2x2Pupils1x1Procedure;
import net.mcreator.narutoshippudenmod.procedures.DisplayIsshikiDojutsu2x1Pupils2x1Procedure;
import net.mcreator.narutoshippudenmod.procedures.DisplayIsshikiDojutsu2x1Pupils1x1Procedure;
import net.mcreator.narutoshippudenmod.procedures.DisplayByakuganActivated2x2Procedure;
import net.mcreator.narutoshippudenmod.procedures.DisplayByakuganActivated2x1Procedure;
import net.mcreator.narutoshippudenmod.procedures.DisplayByakugan2x2Pupils2x1Procedure;
import net.mcreator.narutoshippudenmod.procedures.DisplayByakugan2x2Pupils1x1Procedure;
import net.mcreator.narutoshippudenmod.procedures.DisplayByakugan2x1Pupils2x1Procedure;
import net.mcreator.narutoshippudenmod.procedures.DisplayByakugan2x1Pupils1x1Procedure;
import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables;
import net.mcreator.narutoshippudenmod.NarutoShippudenMod;

import java.util.stream.Stream;
import java.util.Map;
import java.util.HashMap;
import java.util.AbstractMap;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class InfoCardDojutsuGuiWindow extends ContainerScreen<InfoCardDojutsuGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	private final static HashMap guistate = InfoCardDojutsuGui.guistate;

	public InfoCardDojutsuGuiWindow(InfoCardDojutsuGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
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
				.bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/info_card_dojutsu_texture.png"));
		this.blit(ms, this.guiLeft + -126, this.guiTop + -39, 0, 0, 350, 250, 350, 250);

		if (DisplaySharingan2x1Pupils2x1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager()
					.bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/sharingan2px1px2gui.png"));
			this.blit(ms, this.guiLeft + -85, this.guiTop + 68, 0, 0, 96, 16, 96, 16);
		}
		if (DisplaySharingan2x2Pupils2x1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager()
					.bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/sharingan2px2px1gui.png"));
			this.blit(ms, this.guiLeft + -85, this.guiTop + 68, 0, 0, 96, 32, 96, 32);
		}
		if (DisplaySharingan2x2Pupils1x1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager()
					.bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/sharingan2px2px2gui.png"));
			this.blit(ms, this.guiLeft + -85, this.guiTop + 68, 0, 0, 96, 32, 96, 32);
		}
		if (DisplaySharingan2x1Pupils1x1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/sharingan2px1pxgui.png"));
			this.blit(ms, this.guiLeft + -85, this.guiTop + 68, 0, 0, 96, 16, 96, 16);
		}
		if (DisplayByakugan2x2Pupils2x1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager()
					.bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/byakugan_2x2_pupils_1x2_gui.png"));
			this.blit(ms, this.guiLeft + -85, this.guiTop + 68, 0, 0, 96, 32, 96, 32);
		}
		if (DisplayByakugan2x2Pupils1x1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager()
					.bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/byakugan_2x2_pupils_1x1_gui.png"));
			this.blit(ms, this.guiLeft + -85, this.guiTop + 68, 0, 0, 96, 32, 96, 32);
		}
		if (DisplayByakugan2x1Pupils1x1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager()
					.bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/byakugan_2x1_pupils_1x1_gui.png"));
			this.blit(ms, this.guiLeft + -85, this.guiTop + 68, 0, 0, 96, 16, 96, 16);
		}
		if (DisplayByakugan2x1Pupils2x1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager()
					.bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/byakugan_2x1_pupils_2x1_gui.png"));
			this.blit(ms, this.guiLeft + -85, this.guiTop + 68, 0, 0, 96, 16, 96, 16);
		}
		if (DisplayByakuganActivated2x1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager()
					.bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/byakugan_activated_gui.png"));
			this.blit(ms, this.guiLeft + -99, this.guiTop + 59, 0, 0, 125, 52, 125, 52);
		}
		if (DisplayByakuganActivated2x2Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager()
					.bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/byakugan_activated_gui.png"));
			this.blit(ms, this.guiLeft + -99, this.guiTop + 74, 0, 0, 125, 52, 125, 52);
		}
		if (DisplayKetsuryugan2x1Pupils1x1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager()
					.bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/ketsuryugan_2x1_pupils_1x1_gui.png"));
			this.blit(ms, this.guiLeft + -85, this.guiTop + 68, 0, 0, 96, 16, 96, 16);
		}
		if (DisplayKetsuryugan2x1Pupils2x1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager()
					.bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/ketsuryugan_2x1_pupils_2x1_gui.png"));
			this.blit(ms, this.guiLeft + -85, this.guiTop + 68, 0, 0, 96, 16, 96, 16);
		}
		if (DisplayKetsuryugan2x2Pupils1x1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager()
					.bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/ketsuryugan_2x2_pupils_1x1_gui.png"));
			this.blit(ms, this.guiLeft + -85, this.guiTop + 68, 0, 0, 96, 32, 96, 32);
		}
		if (DisplayKetsuryugan2x2Pupils2x1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager()
					.bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/ketsuryugan_2x2_pupils_1x2_gui.png"));
			this.blit(ms, this.guiLeft + -85, this.guiTop + 68, 0, 0, 96, 32, 96, 32);
		}
		if (DisplayIsshikiDojutsu2x1Pupils1x1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
				.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager()
					.bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/isshiki_dojutsu_2x1_pupils_1x1_gui.png"));
			this.blit(ms, this.guiLeft + -85, this.guiTop + 68, 0, 0, 96, 16, 96, 16);
		}
		if (DisplayIsshikiDojutsu2x1Pupils2x1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
				.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager()
					.bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/isshiki_dojutsu_2x1_pupils_2x1_gui.png"));
			this.blit(ms, this.guiLeft + -85, this.guiTop + 68, 0, 0, 96, 16, 96, 16);
		}
		if (DisplayIsshikiDojutsu2x2Pupils1x1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
				.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager()
					.bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/isshiki_dojutsu_2x2_pupils_1x1_gui.png"));
			this.blit(ms, this.guiLeft + -85, this.guiTop + 68, 0, 0, 96, 32, 96, 32);
		}
		if (DisplayIsshikiDojutsu2x2Pupils2x1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
				.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager()
					.bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/isshiki_dojutsu_2x2_pupils_1x2_gui.png"));
			this.blit(ms, this.guiLeft + -85, this.guiTop + 68, 0, 0, 96, 32, 96, 32);
		}
		if (DisplayVoltic2x1Pupils1x1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager()
					.bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/voltic_mode_2x1_pupils_1x1_gui.png"));
			this.blit(ms, this.guiLeft + -85, this.guiTop + 68, 0, 0, 96, 16, 96, 16);
		}
		if (DisplayVoltic2x1Pupils2x1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager()
					.bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/voltic_mode_2x1_pupils_2x1_gui.png"));
			this.blit(ms, this.guiLeft + -85, this.guiTop + 68, 0, 0, 96, 16, 96, 16);
		}
		if (DisplayVoltic2x2Pupils2x1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager()
					.bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/voltic_mode_2x2_pupils_1x1_gui.png"));
			this.blit(ms, this.guiLeft + -85, this.guiTop + 68, 0, 0, 96, 32, 96, 32);
		}
		if (DisplayVoltic2x2Pupils1x1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager()
					.bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/voltic_mode_2x2_pupils_1x2_gui.png"));
			this.blit(ms, this.guiLeft + -85, this.guiTop + 68, 0, 0, 96, 32, 96, 32);
		}
		if (DisplaySasukeDojutsu2x2Pupils1x1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
				.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager()
					.bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/sasukemangekyo2px2px2gui.png"));
			this.blit(ms, this.guiLeft + -85, this.guiTop + 68, 0, 0, 96, 32, 96, 32);
		}
		if (DisplaySasukeDojutsu2x2Pupils2x1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
				.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager()
					.bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/sasukemangekyo2px2px1gui.png"));
			this.blit(ms, this.guiLeft + -85, this.guiTop + 68, 0, 0, 96, 32, 96, 32);
		}
		if (DisplaySasukeDojutsu2x1Pupils2x1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
				.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager()
					.bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/sasukemangekyo2px1px2gui.png"));
			this.blit(ms, this.guiLeft + -85, this.guiTop + 68, 0, 0, 96, 16, 96, 16);
		}
		if (DisplaySasukeDojutsu2x1Pupils1x1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
				.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager()
					.bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/sasukemangekyo2px1pxgui.png"));
			this.blit(ms, this.guiLeft + -85, this.guiTop + 68, 0, 0, 96, 16, 96, 16);
		}
		if (DisplayItachiDojutsu2x1Pupils1x1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
				.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager()
					.bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/itachimangekyo2px1pxgui.png"));
			this.blit(ms, this.guiLeft + -85, this.guiTop + 68, 0, 0, 96, 16, 96, 16);
		}
		if (DisplayItachiDojutsu2x1Pupils2x1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
				.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager()
					.bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/itachimangekyo2px1px2gui.png"));
			this.blit(ms, this.guiLeft + -85, this.guiTop + 68, 0, 0, 96, 16, 96, 16);
		}
		if (DisplayItachiDojutsu2x2Pupils2x1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
				.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager()
					.bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/itachimangekyo2px2px1gui.png"));
			this.blit(ms, this.guiLeft + -85, this.guiTop + 68, 0, 0, 96, 32, 96, 32);
		}
		if (DisplayItachiDojutsu2x2Pupils1x1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
				.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager()
					.bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/itachimangekyo2px2px2gui.png"));
			this.blit(ms, this.guiLeft + -85, this.guiTop + 68, 0, 0, 96, 32, 96, 32);
		}
		if (DisplayMadaraDojutsu2x1Pupils1x1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
				.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager()
					.bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/madaramangekyo2px1pxgui.png"));
			this.blit(ms, this.guiLeft + -85, this.guiTop + 68, 0, 0, 96, 16, 96, 16);
		}
		if (DisplayMadaraDojutsu2x1Pupils2x1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
				.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager()
					.bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/madaramangekyo2px1px2gui.png"));
			this.blit(ms, this.guiLeft + -85, this.guiTop + 68, 0, 0, 96, 16, 96, 16);
		}
		if (DisplayMadaraDojutsu2x2Pupils1x1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
				.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager()
					.bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/madaramangekyo2px2px2gui.png"));
			this.blit(ms, this.guiLeft + -85, this.guiTop + 68, 0, 0, 96, 32, 96, 32);
		}
		if (DisplayMadaraDojutsu2x2Pupils2x1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
				.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager()
					.bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/madaramangekyo2px2px1gui.png"));
			this.blit(ms, this.guiLeft + -85, this.guiTop + 68, 0, 0, 96, 32, 96, 32);
		}
		if (DisplayObitoDojutsu2x1Pupils1x1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager()
					.bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/obitomangekyo2px1pxgui.png"));
			this.blit(ms, this.guiLeft + -85, this.guiTop + 68, 0, 0, 96, 16, 96, 16);
		}
		if (DisplayObitoDojutsu2x1Pupils2x1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager()
					.bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/obitomangekyo2px1px2gui.png"));
			this.blit(ms, this.guiLeft + -85, this.guiTop + 68, 0, 0, 96, 16, 96, 16);
		}
		if (DisplayObitoDojutsu2x2Pupils1x1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager()
					.bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/obitomangekyo2px2px2gui.png"));
			this.blit(ms, this.guiLeft + -85, this.guiTop + 68, 0, 0, 96, 32, 96, 32);
		}
		if (DisplayObitoDojutsu2x2Pupils2x1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager()
					.bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/obitomangekyo2px2px1gui.png"));
			this.blit(ms, this.guiLeft + -85, this.guiTop + 68, 0, 0, 96, 32, 96, 32);
		}
		if (DisplayShisuiDojutsu2x1Pupils1x1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
				.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager()
					.bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/shisuimangekyo2px1pxgui.png"));
			this.blit(ms, this.guiLeft + -85, this.guiTop + 68, 0, 0, 96, 16, 96, 16);
		}
		if (DisplayShisuiDojutsu2x1Pupils2x1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
				.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager()
					.bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/shisuimangekyo2px1px2gui.png"));
			this.blit(ms, this.guiLeft + -85, this.guiTop + 68, 0, 0, 96, 16, 96, 16);
		}
		if (DisplayShisuiDojutsu2x2Pupils1x1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
				.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager()
					.bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/shisuimangekyo2px2px2gui.png"));
			this.blit(ms, this.guiLeft + -85, this.guiTop + 68, 0, 0, 96, 32, 96, 32);
		}
		if (DisplayShisuiDojutsu2x2Pupils2x1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
				.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager()
					.bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/shisuimangekyo2px2px1gui.png"));
			this.blit(ms, this.guiLeft + -85, this.guiTop + 68, 0, 0, 96, 32, 96, 32);
		}
		if (DisplayScarProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/scargui.png"));
			this.blit(ms, this.guiLeft + -21, this.guiTop + 49, 0, 0, 32, 78, 32, 78);
		}
		if (DisplayKakashi1Dojutsu2x1Pupils1x1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
				.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager()
					.bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/kakashisharingan2px1px2gui.png"));
			this.blit(ms, this.guiLeft + -85, this.guiTop + 68, 0, 0, 96, 16, 96, 16);
		}
		if (DisplayKakashi1Dojutsu2x1Pupils2x1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
				.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager()
					.bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/kakashisharingan2px1pxgui.png"));
			this.blit(ms, this.guiLeft + -85, this.guiTop + 68, 0, 0, 96, 16, 96, 16);
		}
		if (DisplayKakashi1Dojutsu2x2Pupils1x1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
				.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager()
					.bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/kakashisharingan2px2px2gui.png"));
			this.blit(ms, this.guiLeft + -85, this.guiTop + 68, 0, 0, 96, 32, 96, 32);
		}
		if (DisplayKakashi1Dojutsu2x2Pupils2x1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
				.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager()
					.bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/kakashisharingan2px2px1gui.png"));
			this.blit(ms, this.guiLeft + -85, this.guiTop + 68, 0, 0, 96, 32, 96, 32);
		}
		if (DisplayKakashiDojutsu2x1Pupils1x1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
				.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager()
					.bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/kakashimangekyo2px1pxgui.png"));
			this.blit(ms, this.guiLeft + -85, this.guiTop + 68, 0, 0, 96, 16, 96, 16);
		}
		if (DisplayKakashiDojutsu2x1Pupils2x1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
				.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager()
					.bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/kakashimangekyo2px1px2gui.png"));
			this.blit(ms, this.guiLeft + -85, this.guiTop + 68, 0, 0, 96, 16, 96, 16);
		}
		if (DisplayKakashiDojutsu2x2Pupils1x1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
				.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager()
					.bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/kakashimangekyo2px2px2gui.png"));
			this.blit(ms, this.guiLeft + -85, this.guiTop + 68, 0, 0, 96, 32, 96, 32);
		}
		if (DisplayKakashiDojutsu2x2Pupils2x1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
				.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager()
					.bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/kakashimangekyo2px2px1gui.png"));
			this.blit(ms, this.guiLeft + -85, this.guiTop + 68, 0, 0, 96, 32, 96, 32);
		}
		if (DisplayMarcus2x1Pupils1x1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager()
					.bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/furamingogan_2x1_pupils_1x1_gui.png"));
			this.blit(ms, this.guiLeft + -85, this.guiTop + 68, 0, 0, 96, 16, 96, 16);
		}
		if (DisplayMarcus2x1Pupils2x1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager()
					.bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/furamingogan_2x1_pupils_2x1_gui.png"));
			this.blit(ms, this.guiLeft + -85, this.guiTop + 68, 0, 0, 96, 16, 96, 16);
		}
		if (DisplayMarcus2x2Pupils1x1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager()
					.bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/furamingogan_2x2_pupils_1x1_gui.png"));
			this.blit(ms, this.guiLeft + -85, this.guiTop + 68, 0, 0, 96, 32, 96, 32);
		}
		if (DisplayMarcus2x2Pupils2x1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager()
					.bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/furamingogan_2x2_pupils_1x2_gui.png"));
			this.blit(ms, this.guiLeft + -85, this.guiTop + 68, 0, 0, 96, 32, 96, 32);
		}
		if (DisplayRinnegan2x1Pupils1x1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/rinnegan2px1px_gui.png"));
			this.blit(ms, this.guiLeft + -85, this.guiTop + 68, 0, 0, 96, 16, 96, 16);
		}
		if (DisplayRinnegan2x1Pupils2x1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager()
					.bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/rinnegan2px1px2_gui.png"));
			this.blit(ms, this.guiLeft + -85, this.guiTop + 68, 0, 0, 96, 16, 96, 16);
		}
		if (DisplayRinnegan2x2Pupils1x1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager()
					.bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/rinnegan2px2px1_gui.png"));
			this.blit(ms, this.guiLeft + -85, this.guiTop + 68, 0, 0, 96, 32, 96, 32);
		}
		if (DisplayRinnegan2x2Pupils2x1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager()
					.bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/rinnegan2px2px2_gui.png"));
			this.blit(ms, this.guiLeft + -85, this.guiTop + 68, 0, 0, 96, 32, 96, 32);
		}
		if (DisplayTenseigan2x1Pupils1x1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager()
					.bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/tenseigan2px1px_gui.png"));
			this.blit(ms, this.guiLeft + -85, this.guiTop + 68, 0, 0, 96, 16, 96, 16);
		}
		if (DisplayTenseigan2x1Pupils2x1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager()
					.bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/tenseigan1px2px2_gui.png"));
			this.blit(ms, this.guiLeft + -85, this.guiTop + 68, 0, 0, 96, 16, 96, 16);
		}
		if (DisplayTenseigan2x2Pupils1x1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager()
					.bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/tenseigan2px2px2_gui.png"));
			this.blit(ms, this.guiLeft + -85, this.guiTop + 68, 0, 0, 96, 32, 96, 32);
		}
		if (DisplayTenseigan2x21Pupils2x1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
			Minecraft.getInstance().getTextureManager()
					.bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/tenseigan2px2px1_gui.png"));
			this.blit(ms, this.guiLeft + -85, this.guiTop + 68, 0, 0, 96, 32, 96, 32);
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
		this.font.drawString(ms, "Dojutsu", 42, 35, -16777216);
		this.font.drawString(ms, "Pupils Height", 42, 65, -16777216);
		this.font.drawString(ms, "Eyes Height", 41, 93, -16777216);
		this.font.drawString(ms, "" + (int) ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).Eyes_Height) + "", 149, 93, -16777216);
		this.font.drawString(ms, "" + (int) ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).Pupils_Height) + "", 149, 66, -16777216);
		this.font.drawString(ms, "" + ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).DojutsuSelectResize) + "", 109, 35, -16777216);
		if (DisplayMinus2SelectProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
				(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
			this.font.drawString(ms, "" + ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).DojutsuSelect2) + "", 126, 3, -16777216);
		this.font.drawString(ms, "" + ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).DojutsuSelect3) + "", 109, 44, -16777216);
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
		this.addButton(new Button(this.guiLeft + -13, this.guiTop + -20, 56, 20, new StringTextComponent("Back"), e -> {
			if (true) {
				NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardDojutsuGui.ButtonPressedMessage(0, x, y, z));
				InfoCardDojutsuGui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 87, this.guiTop + 30, 20, 20, new StringTextComponent("<"), e -> {
			if (true) {
				NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardDojutsuGui.ButtonPressedMessage(1, x, y, z));
				InfoCardDojutsuGui.handleButtonAction(entity, 1, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 184, this.guiTop + 30, 20, 20, new StringTextComponent(">"), e -> {
			if (true) {
				NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardDojutsuGui.ButtonPressedMessage(2, x, y, z));
				InfoCardDojutsuGui.handleButtonAction(entity, 2, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 117, this.guiTop + 60, 20, 20, new StringTextComponent("<"), e -> {
			if (true) {
				NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardDojutsuGui.ButtonPressedMessage(3, x, y, z));
				InfoCardDojutsuGui.handleButtonAction(entity, 3, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 166, this.guiTop + 60, 20, 20, new StringTextComponent(">"), e -> {
			if (true) {
				NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardDojutsuGui.ButtonPressedMessage(4, x, y, z));
				InfoCardDojutsuGui.handleButtonAction(entity, 4, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 117, this.guiTop + 88, 20, 20, new StringTextComponent("<"), e -> {
			if (true) {
				NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardDojutsuGui.ButtonPressedMessage(5, x, y, z));
				InfoCardDojutsuGui.handleButtonAction(entity, 5, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 166, this.guiTop + 88, 20, 20, new StringTextComponent(">"), e -> {
			if (true) {
				NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardDojutsuGui.ButtonPressedMessage(6, x, y, z));
				InfoCardDojutsuGui.handleButtonAction(entity, 6, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + -65, this.guiTop + 165, 56, 20, new StringTextComponent("Select"), e -> {
			if (true) {
				NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardDojutsuGui.ButtonPressedMessage(7, x, y, z));
				InfoCardDojutsuGui.handleButtonAction(entity, 7, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 87, this.guiTop + -2, 20, 20, new StringTextComponent("<"), e -> {
			if (DisplayMinus2SelectProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardDojutsuGui.ButtonPressedMessage(8, x, y, z));
				InfoCardDojutsuGui.handleButtonAction(entity, 8, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (DisplayMinus2SelectProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
		this.addButton(new Button(this.guiLeft + 184, this.guiTop + -2, 20, 20, new StringTextComponent(">"), e -> {
			if (DisplayMinus2SelectProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardDojutsuGui.ButtonPressedMessage(9, x, y, z));
				InfoCardDojutsuGui.handleButtonAction(entity, 9, x, y, z);
			}
		}) {
			@Override
			public void render(MatrixStack ms, int gx, int gy, float ticks) {
				if (DisplayMinus2SelectProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					super.render(ms, gx, gy, ticks);
			}
		});
	}
}
