package net.mcreator.narutoshippudenmod.world.biome;

import net.mcreator.narutoshippudenmod.NarutoShippudenMod;

import net.mcreator.narutoshippudenmod.NarutoShippudenModElements;
import net.mcreator.narutoshippudenmod.block.ModBlocks.KamuiVoidBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilderBaseConfiguration;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;


public final class ModBiomes {
	private ModBiomes() {
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class KamuiBiomeBiome extends NarutoShippudenModElements.ModElement {
		public static Biome biome;

		public KamuiBiomeBiome(NarutoShippudenModElements instance) {
			super(instance, 1235);
			NarutoShippudenMod.MOD_BUS.register(new BiomeRegisterHandler());
		}

		public static class BiomeRegisterHandler {
			@SubscribeEvent
			public void registerBiomes(RegistryEvent.Register<Biome> event) {
				if (biome == null) {
					BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder().fogColor(12638463).waterColor(4159204).waterFogColor(329011)
							.skyColor(7972607).foliageColorOverride(10387789).grassColorOverride(9470285).build();
					BiomeGenerationSettings.Builder biomeGenerationSettings = new BiomeGenerationSettings.Builder()
							.surfaceBuilder(SurfaceBuilder.DEFAULT.configured(new SurfaceBuilderBaseConfiguration(Blocks.AIR.defaultBlockState(),
									KamuiVoidBlock.block.defaultBlockState(), KamuiVoidBlock.block.defaultBlockState())));
					MobSpawnSettings.Builder mobSpawnInfo = new MobSpawnSettings.Builder().setPlayerCanSpawn();
					biome = new Biome.BiomeBuilder().precipitation(Biome.Precipitation.RAIN).biomeCategory(Biome.BiomeCategory.PLAINS).depth(-1f).scale(0f).temperature(0.5f)
							.downfall(0.1f).specialEffects(effects).mobSpawnSettings(mobSpawnInfo.build())
							.generationSettings(biomeGenerationSettings.build()).build();
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
			NarutoShippudenMod.MOD_BUS.register(new BiomeRegisterHandler());
		}

		public static class BiomeRegisterHandler {
			@SubscribeEvent
			public void registerBiomes(RegistryEvent.Register<Biome> event) {
				if (biome == null) {
					BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder().fogColor(-8858908).waterColor(-13207090).waterFogColor(329011)
							.skyColor(-8858908).foliageColorOverride(10387789).grassColorOverride(-13135304).build();
					BiomeGenerationSettings.Builder biomeGenerationSettings = new BiomeGenerationSettings.Builder()
							.surfaceBuilder(SurfaceBuilder.DEFAULT.configured(new SurfaceBuilderBaseConfiguration(Blocks.DIRT.defaultBlockState(),
									Blocks.DIRT.defaultBlockState(), Blocks.DIRT.defaultBlockState())));
					BiomeDefaultFeatures.addDefaultLakes(biomeGenerationSettings);
					BiomeDefaultFeatures.addJungleGrass(biomeGenerationSettings);
					MobSpawnSettings.Builder mobSpawnInfo = new MobSpawnSettings.Builder().setPlayerCanSpawn();
					biome = new Biome.BiomeBuilder().precipitation(Biome.Precipitation.RAIN).biomeCategory(Biome.BiomeCategory.PLAINS).depth(-1f).scale(0f).temperature(0.5f)
							.downfall(0.1f).specialEffects(effects).mobSpawnSettings(mobSpawnInfo.build())
							.generationSettings(biomeGenerationSettings.build()).build();
					event.getRegistry().register(biome.setRegistryName("naruto_shippuden:story_mode_biome"));
				}
			}
		}

		@Override
		public void init(FMLCommonSetupEvent event) {
		}
	}
}
