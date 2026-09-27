package net.mcreator.narutoshippudenmod.world.dimension;

import net.mcreator.narutoshippudenmod.procedures.DojutsuProcedures.KamuiDimensionPlayerEntersDimensionProcedure;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;

import java.util.HashMap;
import java.util.Map;

/** The Kamui and story mode dimensions are data (dimension, dimension_type and biome json); only this event is code. */
@EventBusSubscriber(modid = "naruto_shippuden")
public final class ModDimensions {
	public static final ResourceKey<Level> KAMUI = ResourceKey.create(Registries.DIMENSION,
			Identifier.fromNamespaceAndPath("naruto_shippuden", "kamui_dimension"));

	private ModDimensions() {
	}

	@SubscribeEvent
	public static void onPlayerChangedDimension(PlayerEvent.PlayerChangedDimensionEvent event) {
		if (event.getTo() != KAMUI)
			return;
		Entity entity = event.getEntity();
		Map<String, Object> dependencies = new HashMap<>();
		dependencies.put("world", entity.level());
		dependencies.put("x", entity.getX());
		dependencies.put("z", entity.getZ());
		dependencies.put("entity", entity);
		KamuiDimensionPlayerEntersDimensionProcedure.executeProcedure(dependencies);
	}
}
