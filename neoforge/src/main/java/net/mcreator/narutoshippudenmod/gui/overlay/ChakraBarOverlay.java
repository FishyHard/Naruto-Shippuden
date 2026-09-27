
package net.mcreator.narutoshippudenmod.gui.overlay;

import net.neoforged.fml.common.EventBusSubscriber;

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
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.renderer.RenderPipelines;
import net.neoforged.neoforge.client.event.RegisterGuiLayersEvent;

@EventBusSubscriber(modid = "naruto_shippuden", value = Dist.CLIENT)
public class ChakraBarOverlay {
	/** Chakra and health numbers on the right side of the screen. */
	public static void render(GuiGraphicsExtractor graphics, DeltaTracker deltaTracker) {
		Identifier _tex = null;
{
			int w = graphics.guiWidth();
			int h = graphics.guiHeight();
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
			if (true) {
				if (ChakraDisplayLength1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					graphics.text(Minecraft.getInstance().font, "" + (int) (NarutoShippudenModVariables.get(entity).ChakraAmount) + "", w - 13, h / 2 - 30, -16737793, false);
				if (ChakraDisplayLength1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					graphics.text(Minecraft.getInstance().font, "" + (int) (NarutoShippudenModVariables.get(entity).ChakraMax) + "", w - 13, h / 2 - 10, -16737793, false);
				if (ChakraDisplayLength2Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					graphics.text(Minecraft.getInstance().font, "" + (int) (NarutoShippudenModVariables.get(entity).ChakraAmount) + "", w - 19, h / 2 - 30, -16737793, false);
				if (ChakraDisplayLength2Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					graphics.text(Minecraft.getInstance().font, "" + (int) (NarutoShippudenModVariables.get(entity).ChakraMax) + "", w - 19, h / 2 - 10, -16737793, false);
				if (ChakraDisplayLength3Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					graphics.text(Minecraft.getInstance().font, "" + (int) (NarutoShippudenModVariables.get(entity).ChakraAmount) + "", w - 25, h / 2 - 30, -16737793, false);
				if (ChakraDisplayLength3Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					graphics.text(Minecraft.getInstance().font, "" + (int) (NarutoShippudenModVariables.get(entity).ChakraMax) + "", w - 25, h / 2 - 10, -16737793, false);
				if (ChakraDisplayLength4Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					graphics.text(Minecraft.getInstance().font, "" + (int) (NarutoShippudenModVariables.get(entity).ChakraAmount) + "", w - 31, h / 2 - 30, -16737793, false);
				if (ChakraDisplayLength4Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					graphics.text(Minecraft.getInstance().font, "" + (int) (NarutoShippudenModVariables.get(entity).ChakraMax) + "", w - 31, h / 2 - 10, -16737793, false);
				if (ChakraDisplayLength5Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					graphics.text(Minecraft.getInstance().font, "" + (int) (NarutoShippudenModVariables.get(entity).ChakraAmount) + "", w - 37, h / 2 - 30, -16737793, false);
				if (ChakraDisplayLength5Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					graphics.text(Minecraft.getInstance().font, "" + (int) (NarutoShippudenModVariables.get(entity).ChakraMax) + "", w - 37, h / 2 - 10, -16737793, false);
				if (ChakraDisplayLength6Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					graphics.text(Minecraft.getInstance().font, "" + (int) (NarutoShippudenModVariables.get(entity).ChakraAmount) + "", w - 43, h / 2 - 30, -16737793, false);
				if (ChakraDisplayLength6Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					graphics.text(Minecraft.getInstance().font, "" + (int) (NarutoShippudenModVariables.get(entity).ChakraMax) + "", w - 43, h / 2 - 10, -16737793, false);
				if (ChakraDisplayLength7Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					graphics.text(Minecraft.getInstance().font, "" + (int) (NarutoShippudenModVariables.get(entity).ChakraAmount) + "", w - 49, h / 2 - 30, -16737793, false);
				if (ChakraDisplayLength7Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					graphics.text(Minecraft.getInstance().font, "" + (int) (NarutoShippudenModVariables.get(entity).ChakraMax) + "", w - 49, h / 2 - 10, -16737793, false);
				if (HealthDisplayLength2Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					graphics.text(Minecraft.getInstance().font, "" + (int) (NarutoShippudenModVariables.get(entity).Health) + "", w - 25, h / 2 + 60, -3796205, false);
				if (HealthDisplayLength1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					graphics.text(Minecraft.getInstance().font, "" + (int) (NarutoShippudenModVariables.get(entity).Health) + "", w - 19, h / 2 + 60, -3796205, false);
				if (HealthDisplayLength2Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					graphics.text(Minecraft.getInstance().font, "" + (int) (NarutoShippudenModVariables.get(entity).HealthMax) + "", w - 25, h / 2 + 80, -3796205, false);
				if (HealthDisplayLength1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
					graphics.text(Minecraft.getInstance().font, "" + (int) (NarutoShippudenModVariables.get(entity).HealthMax) + "", w - 19, h / 2 + 80, -3796205, false);
				_tex = Identifier.parse("naruto_shippuden:textures/screens/chakrabar.png");
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
				graphics.blit(RenderPipelines.GUI_TEXTURED, _tex, xLoc, yLoc, mainImagePositionX, mainImagePositionY, imageWidth,
						imageHeight, 15, 76);
				graphics.blit(RenderPipelines.GUI_TEXTURED, _tex, xLoc, yLoc, progressImagePositionX, progressImagePositionY,
						progressHorizontal, progressVertical, 15, 76);
				_tex = Identifier.parse("naruto_shippuden:textures/screens/healthbar.png");
				int xLoc2 = w - 7;
				int yLoc2 = h / 2 + 40;
				int progressVertical2 = (int) NarutoShippudenModVariables.get(entity).HPBarfill;
				graphics.blit(RenderPipelines.GUI_TEXTURED, _tex, xLoc2, yLoc2, mainImagePositionX, mainImagePositionY, imageWidth,
						imageHeight, 15, 76);
				graphics.blit(RenderPipelines.GUI_TEXTURED, _tex, xLoc2, yLoc2, progressImagePositionX, progressImagePositionY,
						progressHorizontal, progressVertical2, 15, 76);
			}
		}
	
	}

	@SubscribeEvent
	public static void register(RegisterGuiLayersEvent event) {
		event.registerAboveAll(Identifier.fromNamespaceAndPath("naruto_shippuden", "chakra_bar"), ChakraBarOverlay::render);
	}
}
