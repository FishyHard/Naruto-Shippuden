
package net.mcreator.narutoshippudenmod.gui.overlay;

import net.neoforged.fml.common.Mod;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.EventPriority;

import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.player.Player;
import net.minecraft.client.Minecraft;

import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.HealthDisplayLength2Procedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.HealthDisplayLength1Procedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.ChakraDisplayLength7Procedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.ChakraDisplayLength6Procedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.ChakraDisplayLength5Procedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.ChakraDisplayLength4Procedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.ChakraDisplayLength3Procedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.ChakraDisplayLength2Procedure;
import net.mcreator.narutoshippudenmod.procedures.GuiDisplayProcedures.ChakraDisplayLength1Procedure;
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
			int w = event.getWindow().getGuiScaledWidth();
			int h = event.getWindow().getGuiScaledHeight();
			int posX = w / 2;
			int posY = h / 2;
			Level _world = null;
			double _x = 0;
			double _y = 0;
			double _z = 0;
			Player entity = Minecraft.getInstance().player;
			if (entity != null) {
				_world = entity.level();
				_x = entity.getX();
				_y = entity.getY();
				_z = entity.getZ();
			}
			Level world = _world;
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
					Minecraft.getInstance().font
							.draw(event.getMatrixStack(),
									"" + (int) (NarutoShippudenModVariables.get(entity).ChakraAmount) + "",
									w - 13, h / 2 - 30, -16737793);
				if (ChakraDisplayLength1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					Minecraft.getInstance().font
							.draw(event.getMatrixStack(),
									"" + (int) (NarutoShippudenModVariables.get(entity).ChakraMax) + "",
									w - 13, h / 2 - 10, -16737793);
				if (ChakraDisplayLength2Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					Minecraft.getInstance().font
							.draw(event.getMatrixStack(),
									"" + (int) (NarutoShippudenModVariables.get(entity).ChakraAmount) + "",
									w - 19, h / 2 - 30, -16737793);
				if (ChakraDisplayLength2Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					Minecraft.getInstance().font
							.draw(event.getMatrixStack(),
									"" + (int) (NarutoShippudenModVariables.get(entity).ChakraMax) + "",
									w - 19, h / 2 - 10, -16737793);
				if (ChakraDisplayLength3Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					Minecraft.getInstance().font
							.draw(event.getMatrixStack(),
									"" + (int) (NarutoShippudenModVariables.get(entity).ChakraAmount) + "",
									w - 25, h / 2 - 30, -16737793);
				if (ChakraDisplayLength3Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					Minecraft.getInstance().font
							.draw(event.getMatrixStack(),
									"" + (int) (NarutoShippudenModVariables.get(entity).ChakraMax) + "",
									w - 25, h / 2 - 10, -16737793);
				if (ChakraDisplayLength4Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					Minecraft.getInstance().font
							.draw(event.getMatrixStack(),
									"" + (int) (NarutoShippudenModVariables.get(entity).ChakraAmount) + "",
									w - 31, h / 2 - 30, -16737793);
				if (ChakraDisplayLength4Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					Minecraft.getInstance().font
							.draw(event.getMatrixStack(),
									"" + (int) (NarutoShippudenModVariables.get(entity).ChakraMax) + "",
									w - 31, h / 2 - 10, -16737793);
				if (ChakraDisplayLength5Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					Minecraft.getInstance().font
							.draw(event.getMatrixStack(),
									"" + (int) (NarutoShippudenModVariables.get(entity).ChakraAmount) + "",
									w - 37, h / 2 - 30, -16737793);
				if (ChakraDisplayLength5Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					Minecraft.getInstance().font
							.draw(event.getMatrixStack(),
									"" + (int) (NarutoShippudenModVariables.get(entity).ChakraMax) + "",
									w - 37, h / 2 - 10, -16737793);
				if (ChakraDisplayLength6Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					Minecraft.getInstance().font
							.draw(event.getMatrixStack(),
									"" + (int) (NarutoShippudenModVariables.get(entity).ChakraAmount) + "",
									w - 43, h / 2 - 30, -16737793);
				if (ChakraDisplayLength6Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					Minecraft.getInstance().font
							.draw(event.getMatrixStack(),
									"" + (int) (NarutoShippudenModVariables.get(entity).ChakraMax) + "",
									w - 43, h / 2 - 10, -16737793);
				if (ChakraDisplayLength7Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					Minecraft.getInstance().font
							.draw(event.getMatrixStack(),
									"" + (int) (NarutoShippudenModVariables.get(entity).ChakraAmount) + "",
									w - 49, h / 2 - 30, -16737793);
				if (ChakraDisplayLength7Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					Minecraft.getInstance().font
							.draw(event.getMatrixStack(),
									"" + (int) (NarutoShippudenModVariables.get(entity).ChakraMax) + "",
									w - 49, h / 2 - 10, -16737793);
				if (HealthDisplayLength2Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					Minecraft.getInstance().font
							.draw(event.getMatrixStack(),
									"" + (int) (NarutoShippudenModVariables.get(entity).Health) + "",
									w - 25, h / 2 + 60, -3796205);
				if (HealthDisplayLength1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					Minecraft.getInstance().font.draw(event.getMatrixStack(),
							"" + (int) (NarutoShippudenModVariables.get(entity).Health) + "",
									w - 19, h / 2 + 60, -3796205);
				if (HealthDisplayLength2Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					Minecraft.getInstance().font
							.draw(event.getMatrixStack(),
									"" + (int) (NarutoShippudenModVariables.get(entity).HealthMax) + "",
									w - 25, h / 2 + 80, -3796205);
				if (HealthDisplayLength1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					Minecraft.getInstance().font
							.draw(event.getMatrixStack(),
									"" + (int) (NarutoShippudenModVariables.get(entity).HealthMax) + "",
									w - 19, h / 2 + 80, -3796205);
				Minecraft.getInstance().getTextureManager().bind(Identifier.parse("naruto_shippuden:textures/screens/chakrabar.png"));
				int xLoc = w - 7;
				int yLoc = h / 2 - 50;
				int mainImagePositionX = 0;
				int mainImagePositionY = 0;
				int imageWidth = 7;
				int imageHeight = 76;
				int progressImagePositionX = 8;
				int progressImagePositionY = 0;
				int progressHorizontal = 7;
				int progressVertical = (int) NarutoShippudenModVariables.get(entity).ChakraBarfill;
				Minecraft.getInstance().gui.blit(event.getMatrixStack(), xLoc, yLoc, mainImagePositionX, mainImagePositionY, imageWidth,
						imageHeight, 15, 76);
				Minecraft.getInstance().gui.blit(event.getMatrixStack(), xLoc, yLoc, progressImagePositionX, progressImagePositionY,
						progressHorizontal, progressVertical, 15, 76);
				Minecraft.getInstance().getTextureManager().bind(Identifier.parse("naruto_shippuden:textures/screens/healthbar.png"));
				int xLoc2 = w - 7;
				int yLoc2 = h / 2 + 40;
				int progressVertical2 = (int) NarutoShippudenModVariables.get(entity).HPBarfill;
				Minecraft.getInstance().gui.blit(event.getMatrixStack(), xLoc2, yLoc2, mainImagePositionX, mainImagePositionY, imageWidth,
						imageHeight, 15, 76);
				Minecraft.getInstance().gui.blit(event.getMatrixStack(), xLoc2, yLoc2, progressImagePositionX, progressImagePositionY,
						progressHorizontal, progressVertical2, 15, 76);
			}
			RenderSystem.depthMask(true);
			RenderSystem.enableDepthTest();
			RenderSystem.enableAlphaTest();
			RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
		}
	}
}
