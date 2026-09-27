package net.mcreator.narutoshippudenmod.world.biome;

import net.mcreator.narutoshippudenmod.NarutoShippudenModElements;
import net.mcreator.narutoshippudenmod.block.ModBlocks.KamuiVoidBlock;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeAmbience;
import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public final class ModBiomes {
	private ModBiomes() {
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class KamuiBiomeBiome extends NarutoShippudenModElements.ModElement {
		public static Biome biome;

		public KamuiBiomeBiome(NarutoShippudenModElements instance) {
			super(instance, 1235);
			FMLJavaModLoadingContext.get().getModEventBus().register(new BiomeRegisterHandler());
		}

		private static class BiomeRegisterHandler {
			@SubscribeEvent
			public void registerBiomes(RegistryEvent.Register<Biome> event) {
				if (biome == null) {
					BiomeAmbience effects = new BiomeAmbience.Builder().setFogColor(12638463).setWaterColor(4159204).setWaterFogColor(329011)
							.withSkyColor(7972607).withFoliageColor(10387789).withGrassColor(9470285).build();
					BiomeGenerationSettings.Builder biomeGenerationSettings = new BiomeGenerationSettings.Builder()
							.withSurfaceBuilder(SurfaceBuilder.DEFAULT.func_242929_a(new SurfaceBuilderConfig(Blocks.AIR.getDefaultState(),
									KamuiVoidBlock.block.getDefaultState(), KamuiVoidBlock.block.getDefaultState())));
					MobSpawnInfo.Builder mobSpawnInfo = new MobSpawnInfo.Builder().isValidSpawnBiomeForPlayer();
					biome = new Biome.Builder().precipitation(Biome.RainType.RAIN).category(Biome.Category.PLAINS).depth(-1f).scale(0f).temperature(0.5f)
							.downfall(0.1f).setEffects(effects).withMobSpawnSettings(mobSpawnInfo.copy())
							.withGenerationSettings(biomeGenerationSettings.build()).build();
					event.getRegistry().register(biome.setRegistryName("naruto_shippuden:kamui_biome"));
				}
			}
		}

		@Override
		public void init(FMLCommonSetupEvent event) {
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class StoryModeBiomeBiome extends NarutoShippudenModElements.ModElement {
		public static Biome biome;

		public StoryModeBiomeBiome(NarutoShippudenModElements instance) {
			super(instance, 166);
			FMLJavaModLoadingContext.get().getModEventBus().register(new BiomeRegisterHandler());
		}

		private static class BiomeRegisterHandler {
			@SubscribeEvent
			public void registerBiomes(RegistryEvent.Register<Biome> event) {
				if (biome == null) {
					BiomeAmbience effects = new BiomeAmbience.Builder().setFogColor(-8858908).setWaterColor(-13207090).setWaterFogColor(329011)
							.withSkyColor(-8858908).withFoliageColor(10387789).withGrassColor(-13135304).build();
					BiomeGenerationSettings.Builder biomeGenerationSettings = new BiomeGenerationSettings.Builder()
							.withSurfaceBuilder(SurfaceBuilder.DEFAULT.func_242929_a(new SurfaceBuilderConfig(Blocks.DIRT.getDefaultState(),
									Blocks.DIRT.getDefaultState(), Blocks.DIRT.getDefaultState())));
					DefaultBiomeFeatures.withLavaAndWaterLakes(biomeGenerationSettings);
					DefaultBiomeFeatures.withJungleGrass(biomeGenerationSettings);
					MobSpawnInfo.Builder mobSpawnInfo = new MobSpawnInfo.Builder().isValidSpawnBiomeForPlayer();
					biome = new Biome.Builder().precipitation(Biome.RainType.RAIN).category(Biome.Category.PLAINS).depth(-1f).scale(0f).temperature(0.5f)
							.downfall(0.1f).setEffects(effects).withMobSpawnSettings(mobSpawnInfo.copy())
							.withGenerationSettings(biomeGenerationSettings.build()).build();
					event.getRegistry().register(biome.setRegistryName("naruto_shippuden:story_mode_biome"));
				}
			}
		}

		@Override
		public void init(FMLCommonSetupEvent event) {
		}
	}
}
