
package net.mcreator.narutoshippudenmod.gui.overlay;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.Minecraft;

import net.mcreator.narutoshippudenmod.procedures.HealthDisplayLength2Procedure;
import net.mcreator.narutoshippudenmod.procedures.HealthDisplayLength1Procedure;
import net.mcreator.narutoshippudenmod.procedures.ChakraDisplayLength7Procedure;
import net.mcreator.narutoshippudenmod.procedures.ChakraDisplayLength6Procedure;
import net.mcreator.narutoshippudenmod.procedures.ChakraDisplayLength5Procedure;
import net.mcreator.narutoshippudenmod.procedures.ChakraDisplayLength4Procedure;
import net.mcreator.narutoshippudenmod.procedures.ChakraDisplayLength3Procedure;
import net.mcreator.narutoshippudenmod.procedures.ChakraDisplayLength2Procedure;
import net.mcreator.narutoshippudenmod.procedures.ChakraDisplayLength1Procedure;
import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables;

import java.util.stream.Stream;
import java.util.Map;
import java.util.HashMap;
import java.util.AbstractMap;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.platform.GlStateManager;

@Mod.EventBusSubscriber
public class ChakraBarOverlay {
	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public static void eventHandler(RenderGameOverlayEvent.Post event) {
		if (event.getType() == RenderGameOverlayEvent.ElementType.HELMET) {
			int w = event.getWindow().getScaledWidth();
			int h = event.getWindow().getScaledHeight();
			int posX = w / 2;
			int posY = h / 2;
			World _world = null;
			double _x = 0;
			double _y = 0;
			double _z = 0;
			PlayerEntity entity = Minecraft.getInstance().player;
			if (entity != null) {
				_world = entity.world;
				_x = entity.getPosX();
				_y = entity.getPosY();
				_z = entity.getPosZ();
			}
			World world = _world;
			double x = _x;
			double y = _y;
			double z = _z;
			RenderSystem.disableDepthTest();
			RenderSystem.depthMask(false);
			RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA,
					GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
			RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
			RenderSystem.disableAlphaTest();
			if (true) {
				if (ChakraDisplayLength1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					Minecraft.getInstance().fontRenderer
							.drawString(event.getMatrixStack(),
									"" + (int) ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount) + "",
									w - 13, h / 2 - 30, -16737793);
				if (ChakraDisplayLength1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					Minecraft.getInstance().fontRenderer
							.drawString(event.getMatrixStack(),
									"" + (int) ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraMax) + "",
									w - 13, h / 2 - 10, -16737793);
				if (ChakraDisplayLength2Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					Minecraft.getInstance().fontRenderer
							.drawString(event.getMatrixStack(),
									"" + (int) ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount) + "",
									w - 19, h / 2 - 30, -16737793);
				if (ChakraDisplayLength2Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					Minecraft.getInstance().fontRenderer
							.drawString(event.getMatrixStack(),
									"" + (int) ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraMax) + "",
									w - 19, h / 2 - 10, -16737793);
				if (ChakraDisplayLength3Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					Minecraft.getInstance().fontRenderer
							.drawString(event.getMatrixStack(),
									"" + (int) ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount) + "",
									w - 25, h / 2 - 30, -16737793);
				if (ChakraDisplayLength3Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					Minecraft.getInstance().fontRenderer
							.drawString(event.getMatrixStack(),
									"" + (int) ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraMax) + "",
									w - 25, h / 2 - 10, -16737793);
				if (ChakraDisplayLength4Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					Minecraft.getInstance().fontRenderer
							.drawString(event.getMatrixStack(),
									"" + (int) ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount) + "",
									w - 31, h / 2 - 30, -16737793);
				if (ChakraDisplayLength4Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					Minecraft.getInstance().fontRenderer
							.drawString(event.getMatrixStack(),
									"" + (int) ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraMax) + "",
									w - 31, h / 2 - 10, -16737793);
				if (ChakraDisplayLength5Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					Minecraft.getInstance().fontRenderer
							.drawString(event.getMatrixStack(),
									"" + (int) ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount) + "",
									w - 37, h / 2 - 30, -16737793);
				if (ChakraDisplayLength5Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					Minecraft.getInstance().fontRenderer
							.drawString(event.getMatrixStack(),
									"" + (int) ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraMax) + "",
									w - 37, h / 2 - 10, -16737793);
				if (ChakraDisplayLength6Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					Minecraft.getInstance().fontRenderer
							.drawString(event.getMatrixStack(),
									"" + (int) ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount) + "",
									w - 43, h / 2 - 30, -16737793);
				if (ChakraDisplayLength6Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					Minecraft.getInstance().fontRenderer
							.drawString(event.getMatrixStack(),
									"" + (int) ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraMax) + "",
									w - 43, h / 2 - 10, -16737793);
				if (ChakraDisplayLength7Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					Minecraft.getInstance().fontRenderer
							.drawString(event.getMatrixStack(),
									"" + (int) ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount) + "",
									w - 49, h / 2 - 30, -16737793);
				if (ChakraDisplayLength7Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					Minecraft.getInstance().fontRenderer
							.drawString(event.getMatrixStack(),
									"" + (int) ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraMax) + "",
									w - 49, h / 2 - 10, -16737793);
				if (HealthDisplayLength2Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					Minecraft.getInstance().fontRenderer
							.drawString(event.getMatrixStack(),
									"" + (int) ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new NarutoShippudenModVariables.PlayerVariables())).Health) + "",
									w - 25, h / 2 + 60, -3796205);
				if (HealthDisplayLength1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					Minecraft.getInstance().fontRenderer.drawString(event.getMatrixStack(),
							"" + (int) ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NarutoShippudenModVariables.PlayerVariables())).Health) + "",
									w - 19, h / 2 + 60, -3796205);
				if (HealthDisplayLength2Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					Minecraft.getInstance().fontRenderer
							.drawString(event.getMatrixStack(),
									"" + (int) ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new NarutoShippudenModVariables.PlayerVariables())).HealthMax) + "",
									w - 25, h / 2 + 80, -3796205);
				if (HealthDisplayLength1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					Minecraft.getInstance().fontRenderer
							.drawString(event.getMatrixStack(),
									"" + (int) ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new NarutoShippudenModVariables.PlayerVariables())).HealthMax) + "",
									w - 19, h / 2 + 80, -3796205);
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/chakrabar.png"));
				int xLoc = w - 7;
				int yLoc = h / 2 - 50;
				int mainImagePositionX = 0;
				int mainImagePositionY = 0;
				int imageWidth = 7;
				int imageHeight = 76;
				int progressImagePositionX = 8;
				int progressImagePositionY = 0;
				int progressHorizontal = 7;
				int progressVertical = (int) (entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraBarfill;
				Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), xLoc, yLoc, mainImagePositionX, mainImagePositionY, imageWidth,
						imageHeight, 15, 76);
				Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), xLoc, yLoc, progressImagePositionX, progressImagePositionY,
						progressHorizontal, progressVertical, 15, 76);
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("naruto_shippuden:textures/screens/healthbar.png"));
				int xLoc2 = w - 7;
				int yLoc2 = h / 2 + 40;
				int progressVertical2 = (int) (entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).HPBarfill;
				Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), xLoc2, yLoc2, mainImagePositionX, mainImagePositionY, imageWidth,
						imageHeight, 15, 76);
				Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), xLoc2, yLoc2, progressImagePositionX, progressImagePositionY,
						progressHorizontal, progressVertical2, 15, 76);
			}
			RenderSystem.depthMask(true);
			RenderSystem.enableDepthTest();
			RenderSystem.enableAlphaTest();
			RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
		}
	}
}
