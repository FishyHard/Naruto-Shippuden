package net.mcreator.narutoshippudenmod.world.dimension;

import net.minecraft.core.registries.Registries;

import com.google.common.collect.ImmutableSet;
import it.unimi.dsi.fastutil.objects.Object2ObjectMap;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;
import net.mcreator.narutoshippudenmod.NarutoShippudenModElements;
import net.mcreator.narutoshippudenmod.block.ModBlocks.KamuiVoidBlock;
import net.mcreator.narutoshippudenmod.procedures.DojutsuProcedures.KamuiDimensionPlayerEntersDimensionProcedure;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.world.phys.Vec3;
import net.minecraft.core.Registry;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.levelgen.carver.WorldCarver;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.bus.api.SubscribeEvent;

import net.neoforged.fml.util.ObfuscationReflectionHelper;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraft.core.registries.BuiltInRegistries;

public final class ModDimensions {
	private ModDimensions() {
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class KamuiDimensionDimension extends NarutoShippudenModElements.ModElement {
		public KamuiDimensionDimension(NarutoShippudenModElements instance) {
			super(instance, 1233);
			NeoForge.EVENT_BUS.register(this);
		}

		@Override
		public void init(FMLCommonSetupEvent event) {
			Set<Block> replaceableBlocks = new HashSet<>();
			replaceableBlocks.add(KamuiVoidBlock.block);
			replaceableBlocks.add(BuiltInRegistries.BIOMES.getValue(Identifier.parse("naruto_shippuden:kamui_biome")).getGenerationSettings()
					.getSurfaceBuilder().get().config().getTopMaterial().getBlock());
			replaceableBlocks.add(BuiltInRegistries.BIOMES.getValue(Identifier.parse("naruto_shippuden:kamui_biome")).getGenerationSettings()
					.getSurfaceBuilder().get().config().getUnderMaterial().getBlock());
			DeferredWorkQueue.runLater(() -> {
				try {
					ObfuscationReflectionHelper.setPrivateValue(WorldCarver.class, WorldCarver.CAVE, new ImmutableSet.Builder<Block>()
							.addAll((Set<Block>) ObfuscationReflectionHelper.getPrivateValue(WorldCarver.class, WorldCarver.CAVE, "replaceableBlocks"))
							.addAll(replaceableBlocks).build(), "replaceableBlocks");
					ObfuscationReflectionHelper.setPrivateValue(WorldCarver.class, WorldCarver.CANYON, new ImmutableSet.Builder<Block>()
							.addAll((Set<Block>) ObfuscationReflectionHelper.getPrivateValue(WorldCarver.class, WorldCarver.CANYON, "replaceableBlocks"))
							.addAll(replaceableBlocks).build(), "replaceableBlocks");
				} catch (Exception e) {
					e.printStackTrace();
				}
			});
		}

		@Override
		@OnlyIn(Dist.CLIENT)
		public void clientLoad(FMLClientSetupEvent event) {
			DimensionRenderInfo customEffect = new DimensionRenderInfo(Float.NaN, true, DimensionRenderInfo.FogType.NONE, false, false) {
				@Override
				public Vec3 getBrightnessDependentFogColor(Vec3 color, float sunHeight) {
					return new Vec3(0, 0, 0);
				}

				@Override
				public boolean isFoggyAt(int x, int y) {
					return false;
				}
			};
			DeferredWorkQueue.runLater(() -> {
				try {
					Object2ObjectMap<Identifier, DimensionRenderInfo> effectsRegistry = (Object2ObjectMap<Identifier, DimensionRenderInfo>) ObfuscationReflectionHelper
							.getPrivateValue(DimensionRenderInfo.class, null, "EFFECTS");
					effectsRegistry.put(Identifier.parse("naruto_shippuden:kamui_dimension"), customEffect);
				} catch (Exception e) {
					e.printStackTrace();
				}
			});
		}

		@SubscribeEvent
		public void onPlayerChangedDimensionEvent(PlayerEvent.PlayerChangedDimensionEvent event) {
			Entity entity = event.getPlayer();
			Level world = entity.level();
			double x = entity.getX();
			double y = entity.getY();
			double z = entity.getZ();
			if (event.getTo() == ResourceKey.create(Registries.DIMENSION, Identifier.parse("naruto_shippuden:kamui_dimension"))) {

				KamuiDimensionPlayerEntersDimensionProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("z", z),
								new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class StoryModeDimensionDimension extends NarutoShippudenModElements.ModElement {
		public StoryModeDimensionDimension(NarutoShippudenModElements instance) {
			super(instance, 166);
		}

		@Override
		public void init(FMLCommonSetupEvent event) {
			Set<Block> replaceableBlocks = new HashSet<>();
			replaceableBlocks.add(Blocks.STONE);
			replaceableBlocks.add(BuiltInRegistries.BIOMES.getValue(Identifier.parse("naruto_shippuden:story_mode_biome")).getGenerationSettings()
					.getSurfaceBuilder().get().config().getTopMaterial().getBlock());
			replaceableBlocks.add(BuiltInRegistries.BIOMES.getValue(Identifier.parse("naruto_shippuden:story_mode_biome")).getGenerationSettings()
					.getSurfaceBuilder().get().config().getUnderMaterial().getBlock());
			DeferredWorkQueue.runLater(() -> {
				try {
					ObfuscationReflectionHelper.setPrivateValue(WorldCarver.class, WorldCarver.CAVE, new ImmutableSet.Builder<Block>()
							.addAll((Set<Block>) ObfuscationReflectionHelper.getPrivateValue(WorldCarver.class, WorldCarver.CAVE, "replaceableBlocks"))
							.addAll(replaceableBlocks).build(), "replaceableBlocks");
					ObfuscationReflectionHelper.setPrivateValue(WorldCarver.class, WorldCarver.CANYON, new ImmutableSet.Builder<Block>()
							.addAll((Set<Block>) ObfuscationReflectionHelper.getPrivateValue(WorldCarver.class, WorldCarver.CANYON, "replaceableBlocks"))
							.addAll(replaceableBlocks).build(), "replaceableBlocks");
				} catch (Exception e) {
					e.printStackTrace();
				}
			});
		}

		@Override
		@OnlyIn(Dist.CLIENT)
		public void clientLoad(FMLClientSetupEvent event) {
			DimensionRenderInfo customEffect = new DimensionRenderInfo(128, true, DimensionRenderInfo.FogType.NORMAL, false, false) {
				@Override
				public Vec3 getBrightnessDependentFogColor(Vec3 color, float sunHeight) {
					return new Vec3(0.470588235294, 0.823529411765, 0.894117647059);
				}

				@Override
				public boolean isFoggyAt(int x, int y) {
					return false;
				}
			};
			DeferredWorkQueue.runLater(() -> {
				try {
					Object2ObjectMap<Identifier, DimensionRenderInfo> effectsRegistry = (Object2ObjectMap<Identifier, DimensionRenderInfo>) ObfuscationReflectionHelper
							.getPrivateValue(DimensionRenderInfo.class, null, "EFFECTS");
					effectsRegistry.put(Identifier.parse("naruto_shippuden:story_mode_dimension"), customEffect);
				} catch (Exception e) {
					e.printStackTrace();
				}
			});
		}
	}
}
