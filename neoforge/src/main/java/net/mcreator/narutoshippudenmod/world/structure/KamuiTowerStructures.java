package net.mcreator.narutoshippudenmod.world.structure;

import net.minecraft.util.RandomSource;
import net.minecraft.core.registries.Registries;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.stream.Stream;
import net.mcreator.narutoshippudenmod.procedures.DojutsuProcedures.KamuiTower1AdditionalGenerationConditionProcedure;
import net.mcreator.narutoshippudenmod.procedures.DojutsuProcedures.KamuiTower4AdditionalGenerationConditionProcedure;
import net.mcreator.narutoshippudenmod.procedures.DojutsuProcedures.KamuiTower7AdditionalGenerationConditionProcedure;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockIgnoreProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.level.levelgen.feature.configurations.DecoratorConfiguration;
import net.minecraft.world.level.levelgen.placement.FeatureDecorator;


import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;

public final class KamuiTowerStructures {
	private KamuiTowerStructures() {
	}

	@Mod.EventBusSubscriber
	public static class KamuiTower1Structure {
		private static Feature<NoneFeatureConfiguration> feature = null;
		private static ConfiguredFeature<?, ?> configuredFeature = null;

		@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
		public static class FeatureRegisterHandler {
			@SubscribeEvent
			public static void registerFeature(RegistryEvent.Register<Feature<?>> event) {
				feature = new Feature<NoneFeatureConfiguration>(NoneFeatureConfiguration.CODEC) {
					@Override
					public boolean place(WorldGenLevel world, ChunkGenerator generator, RandomSource random, BlockPos pos, NoneFeatureConfiguration config) {
						int ci = (pos.getX() >> 4) << 4;
						int ck = (pos.getZ() >> 4) << 4;
						ResourceKey<Level> dimensionType = world.getLevel().dimension();
						boolean dimensionCriteria = false;
						if (dimensionType == ResourceKey.create(Registries.DIMENSION, Identifier.parse("naruto_shippuden:kamui_dimension")))
							dimensionCriteria = true;
						if (!dimensionCriteria)
							return false;
						if ((random.nextInt(1000000) + 1) <= 550000) {
							int count = random.nextInt(1) + 1;
							for (int a = 0; a < count; a++) {
								int i = ci + random.nextInt(16);
								int k = ck + random.nextInt(16);
								int j = world.getHeight(Heightmap.Types.WORLD_SURFACE_WG, i, k);
								j -= 1;
								Rotation rotation = Rotation.NONE;
								Mirror mirror = Mirror.NONE;
								BlockPos spawnTo = BlockPos.containing(i + 0, j + 1, k + 0);
								int x = spawnTo.getX();
								int y = spawnTo.getY();
								int z = spawnTo.getZ();
								if (!KamuiTower1AdditionalGenerationConditionProcedure.executeProcedure(Stream
										.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x),
												new AbstractMap.SimpleEntry<>("z", z))
										.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
									continue;
								StructureTemplate template = world.getLevel().getStructureManager()
										.getOrCreate(Identifier.fromNamespaceAndPath("naruto_shippuden", "kamui_tower1"));
								if (template == null)
									return false;
								template.placeInWorldChunk(world, spawnTo,
										new StructurePlaceSettings().setRotation(rotation).setRandom(random).setMirror(mirror)
												.addProcessor(BlockIgnoreProcessor.STRUCTURE_BLOCK).setChunkPos(null).setIgnoreEntities(false),
										random);
							}
						}
						return true;
					}
				};
				configuredFeature = feature.configured(FeatureConfiguration.NONE)
						.decorated(FeatureDecorator.NOPE.configured(DecoratorConfiguration.NONE));
				event.getRegistry().register(feature.setRegistryName("kamui_tower_1"));
				Registry.register(BuiltInRegistries.CONFIGURED_FEATURE, Identifier.parse("naruto_shippuden:kamui_tower_1"), configuredFeature);
			}
		}

		@SubscribeEvent
		public static void addFeatureToBiomes(BiomeLoadingEvent event) {
			event.getGeneration().getFeatures(GenerationStep.Decoration.SURFACE_STRUCTURES).add(() -> configuredFeature);
		}
	}

	@Mod.EventBusSubscriber
	public static class KamuiTower2Structure {
		private static Feature<NoneFeatureConfiguration> feature = null;
		private static ConfiguredFeature<?, ?> configuredFeature = null;

		@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
		public static class FeatureRegisterHandler {
			@SubscribeEvent
			public static void registerFeature(RegistryEvent.Register<Feature<?>> event) {
				feature = new Feature<NoneFeatureConfiguration>(NoneFeatureConfiguration.CODEC) {
					@Override
					public boolean place(WorldGenLevel world, ChunkGenerator generator, RandomSource random, BlockPos pos, NoneFeatureConfiguration config) {
						int ci = (pos.getX() >> 4) << 4;
						int ck = (pos.getZ() >> 4) << 4;
						ResourceKey<Level> dimensionType = world.getLevel().dimension();
						boolean dimensionCriteria = false;
						if (dimensionType == ResourceKey.create(Registries.DIMENSION, Identifier.parse("naruto_shippuden:kamui_dimension")))
							dimensionCriteria = true;
						if (!dimensionCriteria)
							return false;
						if ((random.nextInt(1000000) + 1) <= 550000) {
							int count = random.nextInt(1) + 1;
							for (int a = 0; a < count; a++) {
								int i = ci + random.nextInt(16);
								int k = ck + random.nextInt(16);
								int j = world.getHeight(Heightmap.Types.WORLD_SURFACE_WG, i, k);
								j -= 1;
								Rotation rotation = Rotation.NONE;
								Mirror mirror = Mirror.NONE;
								BlockPos spawnTo = BlockPos.containing(i + 0, j + 1, k + 0);
								int x = spawnTo.getX();
								int y = spawnTo.getY();
								int z = spawnTo.getZ();
								if (!KamuiTower1AdditionalGenerationConditionProcedure.executeProcedure(Stream
										.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x),
												new AbstractMap.SimpleEntry<>("z", z))
										.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
									continue;
								StructureTemplate template = world.getLevel().getStructureManager()
										.getOrCreate(Identifier.fromNamespaceAndPath("naruto_shippuden", "kamui_tower2"));
								if (template == null)
									return false;
								template.placeInWorldChunk(world, spawnTo,
										new StructurePlaceSettings().setRotation(rotation).setRandom(random).setMirror(mirror)
												.addProcessor(BlockIgnoreProcessor.STRUCTURE_BLOCK).setChunkPos(null).setIgnoreEntities(false),
										random);
							}
						}
						return true;
					}
				};
				configuredFeature = feature.configured(FeatureConfiguration.NONE)
						.decorated(FeatureDecorator.NOPE.configured(DecoratorConfiguration.NONE));
				event.getRegistry().register(feature.setRegistryName("kamui_tower_2"));
				Registry.register(BuiltInRegistries.CONFIGURED_FEATURE, Identifier.parse("naruto_shippuden:kamui_tower_2"), configuredFeature);
			}
		}

		@SubscribeEvent
		public static void addFeatureToBiomes(BiomeLoadingEvent event) {
			event.getGeneration().getFeatures(GenerationStep.Decoration.SURFACE_STRUCTURES).add(() -> configuredFeature);
		}
	}

	@Mod.EventBusSubscriber
	public static class KamuiTower3Structure {
		private static Feature<NoneFeatureConfiguration> feature = null;
		private static ConfiguredFeature<?, ?> configuredFeature = null;

		@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
		public static class FeatureRegisterHandler {
			@SubscribeEvent
			public static void registerFeature(RegistryEvent.Register<Feature<?>> event) {
				feature = new Feature<NoneFeatureConfiguration>(NoneFeatureConfiguration.CODEC) {
					@Override
					public boolean place(WorldGenLevel world, ChunkGenerator generator, RandomSource random, BlockPos pos, NoneFeatureConfiguration config) {
						int ci = (pos.getX() >> 4) << 4;
						int ck = (pos.getZ() >> 4) << 4;
						ResourceKey<Level> dimensionType = world.getLevel().dimension();
						boolean dimensionCriteria = false;
						if (dimensionType == ResourceKey.create(Registries.DIMENSION, Identifier.parse("naruto_shippuden:kamui_dimension")))
							dimensionCriteria = true;
						if (!dimensionCriteria)
							return false;
						if ((random.nextInt(1000000) + 1) <= 550000) {
							int count = random.nextInt(1) + 1;
							for (int a = 0; a < count; a++) {
								int i = ci + random.nextInt(16);
								int k = ck + random.nextInt(16);
								int j = world.getHeight(Heightmap.Types.WORLD_SURFACE_WG, i, k);
								j -= 1;
								Rotation rotation = Rotation.NONE;
								Mirror mirror = Mirror.NONE;
								BlockPos spawnTo = BlockPos.containing(i + 0, j + 1, k + 0);
								int x = spawnTo.getX();
								int y = spawnTo.getY();
								int z = spawnTo.getZ();
								if (!KamuiTower1AdditionalGenerationConditionProcedure.executeProcedure(Stream
										.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x),
												new AbstractMap.SimpleEntry<>("z", z))
										.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
									continue;
								StructureTemplate template = world.getLevel().getStructureManager()
										.getOrCreate(Identifier.fromNamespaceAndPath("naruto_shippuden", "kamui_tower3"));
								if (template == null)
									return false;
								template.placeInWorldChunk(world, spawnTo,
										new StructurePlaceSettings().setRotation(rotation).setRandom(random).setMirror(mirror)
												.addProcessor(BlockIgnoreProcessor.STRUCTURE_BLOCK).setChunkPos(null).setIgnoreEntities(false),
										random);
							}
						}
						return true;
					}
				};
				configuredFeature = feature.configured(FeatureConfiguration.NONE)
						.decorated(FeatureDecorator.NOPE.configured(DecoratorConfiguration.NONE));
				event.getRegistry().register(feature.setRegistryName("kamui_tower_3"));
				Registry.register(BuiltInRegistries.CONFIGURED_FEATURE, Identifier.parse("naruto_shippuden:kamui_tower_3"), configuredFeature);
			}
		}

		@SubscribeEvent
		public static void addFeatureToBiomes(BiomeLoadingEvent event) {
			event.getGeneration().getFeatures(GenerationStep.Decoration.SURFACE_STRUCTURES).add(() -> configuredFeature);
		}
	}

	@Mod.EventBusSubscriber
	public static class KamuiTower4Structure {
		private static Feature<NoneFeatureConfiguration> feature = null;
		private static ConfiguredFeature<?, ?> configuredFeature = null;

		@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
		public static class FeatureRegisterHandler {
			@SubscribeEvent
			public static void registerFeature(RegistryEvent.Register<Feature<?>> event) {
				feature = new Feature<NoneFeatureConfiguration>(NoneFeatureConfiguration.CODEC) {
					@Override
					public boolean place(WorldGenLevel world, ChunkGenerator generator, RandomSource random, BlockPos pos, NoneFeatureConfiguration config) {
						int ci = (pos.getX() >> 4) << 4;
						int ck = (pos.getZ() >> 4) << 4;
						ResourceKey<Level> dimensionType = world.getLevel().dimension();
						boolean dimensionCriteria = false;
						if (dimensionType == ResourceKey.create(Registries.DIMENSION, Identifier.parse("naruto_shippuden:kamui_dimension")))
							dimensionCriteria = true;
						if (!dimensionCriteria)
							return false;
						if ((random.nextInt(1000000) + 1) <= 800000) {
							int count = random.nextInt(1) + 1;
							for (int a = 0; a < count; a++) {
								int i = ci + random.nextInt(16);
								int k = ck + random.nextInt(16);
								int j = world.getHeight(Heightmap.Types.WORLD_SURFACE_WG, i, k);
								j -= 1;
								Rotation rotation = Rotation.NONE;
								Mirror mirror = Mirror.NONE;
								BlockPos spawnTo = BlockPos.containing(i + 0, j + 1, k + 0);
								int x = spawnTo.getX();
								int y = spawnTo.getY();
								int z = spawnTo.getZ();
								if (!KamuiTower4AdditionalGenerationConditionProcedure.executeProcedure(Stream
										.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x),
												new AbstractMap.SimpleEntry<>("z", z))
										.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
									continue;
								StructureTemplate template = world.getLevel().getStructureManager()
										.getOrCreate(Identifier.fromNamespaceAndPath("naruto_shippuden", "kamui_tower4"));
								if (template == null)
									return false;
								template.placeInWorldChunk(world, spawnTo,
										new StructurePlaceSettings().setRotation(rotation).setRandom(random).setMirror(mirror)
												.addProcessor(BlockIgnoreProcessor.STRUCTURE_BLOCK).setChunkPos(null).setIgnoreEntities(false),
										random);
							}
						}
						return true;
					}
				};
				configuredFeature = feature.configured(FeatureConfiguration.NONE)
						.decorated(FeatureDecorator.NOPE.configured(DecoratorConfiguration.NONE));
				event.getRegistry().register(feature.setRegistryName("kamui_tower_4"));
				Registry.register(BuiltInRegistries.CONFIGURED_FEATURE, Identifier.parse("naruto_shippuden:kamui_tower_4"), configuredFeature);
			}
		}

		@SubscribeEvent
		public static void addFeatureToBiomes(BiomeLoadingEvent event) {
			event.getGeneration().getFeatures(GenerationStep.Decoration.SURFACE_STRUCTURES).add(() -> configuredFeature);
		}
	}

	@Mod.EventBusSubscriber
	public static class KamuiTower5Structure {
		private static Feature<NoneFeatureConfiguration> feature = null;
		private static ConfiguredFeature<?, ?> configuredFeature = null;

		@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
		public static class FeatureRegisterHandler {
			@SubscribeEvent
			public static void registerFeature(RegistryEvent.Register<Feature<?>> event) {
				feature = new Feature<NoneFeatureConfiguration>(NoneFeatureConfiguration.CODEC) {
					@Override
					public boolean place(WorldGenLevel world, ChunkGenerator generator, RandomSource random, BlockPos pos, NoneFeatureConfiguration config) {
						int ci = (pos.getX() >> 4) << 4;
						int ck = (pos.getZ() >> 4) << 4;
						ResourceKey<Level> dimensionType = world.getLevel().dimension();
						boolean dimensionCriteria = false;
						if (dimensionType == ResourceKey.create(Registries.DIMENSION, Identifier.parse("naruto_shippuden:kamui_dimension")))
							dimensionCriteria = true;
						if (!dimensionCriteria)
							return false;
						if ((random.nextInt(1000000) + 1) <= 800000) {
							int count = random.nextInt(1) + 1;
							for (int a = 0; a < count; a++) {
								int i = ci + random.nextInt(16);
								int k = ck + random.nextInt(16);
								int j = world.getHeight(Heightmap.Types.WORLD_SURFACE_WG, i, k);
								j -= 1;
								Rotation rotation = Rotation.NONE;
								Mirror mirror = Mirror.NONE;
								BlockPos spawnTo = BlockPos.containing(i + 0, j + 1, k + 0);
								int x = spawnTo.getX();
								int y = spawnTo.getY();
								int z = spawnTo.getZ();
								if (!KamuiTower4AdditionalGenerationConditionProcedure.executeProcedure(Stream
										.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x),
												new AbstractMap.SimpleEntry<>("z", z))
										.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
									continue;
								StructureTemplate template = world.getLevel().getStructureManager()
										.getOrCreate(Identifier.fromNamespaceAndPath("naruto_shippuden", "kamui_tower5"));
								if (template == null)
									return false;
								template.placeInWorldChunk(world, spawnTo,
										new StructurePlaceSettings().setRotation(rotation).setRandom(random).setMirror(mirror)
												.addProcessor(BlockIgnoreProcessor.STRUCTURE_BLOCK).setChunkPos(null).setIgnoreEntities(false),
										random);
							}
						}
						return true;
					}
				};
				configuredFeature = feature.configured(FeatureConfiguration.NONE)
						.decorated(FeatureDecorator.NOPE.configured(DecoratorConfiguration.NONE));
				event.getRegistry().register(feature.setRegistryName("kamui_tower_5"));
				Registry.register(BuiltInRegistries.CONFIGURED_FEATURE, Identifier.parse("naruto_shippuden:kamui_tower_5"), configuredFeature);
			}
		}

		@SubscribeEvent
		public static void addFeatureToBiomes(BiomeLoadingEvent event) {
			event.getGeneration().getFeatures(GenerationStep.Decoration.SURFACE_STRUCTURES).add(() -> configuredFeature);
		}
	}

	@Mod.EventBusSubscriber
	public static class KamuiTower6Structure {
		private static Feature<NoneFeatureConfiguration> feature = null;
		private static ConfiguredFeature<?, ?> configuredFeature = null;

		@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
		public static class FeatureRegisterHandler {
			@SubscribeEvent
			public static void registerFeature(RegistryEvent.Register<Feature<?>> event) {
				feature = new Feature<NoneFeatureConfiguration>(NoneFeatureConfiguration.CODEC) {
					@Override
					public boolean place(WorldGenLevel world, ChunkGenerator generator, RandomSource random, BlockPos pos, NoneFeatureConfiguration config) {
						int ci = (pos.getX() >> 4) << 4;
						int ck = (pos.getZ() >> 4) << 4;
						ResourceKey<Level> dimensionType = world.getLevel().dimension();
						boolean dimensionCriteria = false;
						if (dimensionType == ResourceKey.create(Registries.DIMENSION, Identifier.parse("naruto_shippuden:kamui_dimension")))
							dimensionCriteria = true;
						if (!dimensionCriteria)
							return false;
						if ((random.nextInt(1000000) + 1) <= 800000) {
							int count = random.nextInt(1) + 1;
							for (int a = 0; a < count; a++) {
								int i = ci + random.nextInt(16);
								int k = ck + random.nextInt(16);
								int j = world.getHeight(Heightmap.Types.WORLD_SURFACE_WG, i, k);
								j -= 1;
								Rotation rotation = Rotation.NONE;
								Mirror mirror = Mirror.NONE;
								BlockPos spawnTo = BlockPos.containing(i + 0, j + 1, k + 0);
								int x = spawnTo.getX();
								int y = spawnTo.getY();
								int z = spawnTo.getZ();
								if (!KamuiTower4AdditionalGenerationConditionProcedure.executeProcedure(Stream
										.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x),
												new AbstractMap.SimpleEntry<>("z", z))
										.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
									continue;
								StructureTemplate template = world.getLevel().getStructureManager()
										.getOrCreate(Identifier.fromNamespaceAndPath("naruto_shippuden", "kamui_tower6"));
								if (template == null)
									return false;
								template.placeInWorldChunk(world, spawnTo,
										new StructurePlaceSettings().setRotation(rotation).setRandom(random).setMirror(mirror)
												.addProcessor(BlockIgnoreProcessor.STRUCTURE_BLOCK).setChunkPos(null).setIgnoreEntities(false),
										random);
							}
						}
						return true;
					}
				};
				configuredFeature = feature.configured(FeatureConfiguration.NONE)
						.decorated(FeatureDecorator.NOPE.configured(DecoratorConfiguration.NONE));
				event.getRegistry().register(feature.setRegistryName("kamui_tower_6"));
				Registry.register(BuiltInRegistries.CONFIGURED_FEATURE, Identifier.parse("naruto_shippuden:kamui_tower_6"), configuredFeature);
			}
		}

		@SubscribeEvent
		public static void addFeatureToBiomes(BiomeLoadingEvent event) {
			event.getGeneration().getFeatures(GenerationStep.Decoration.SURFACE_STRUCTURES).add(() -> configuredFeature);
		}
	}

	@Mod.EventBusSubscriber
	public static class KamuiTower7Structure {
		private static Feature<NoneFeatureConfiguration> feature = null;
		private static ConfiguredFeature<?, ?> configuredFeature = null;

		@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
		public static class FeatureRegisterHandler {
			@SubscribeEvent
			public static void registerFeature(RegistryEvent.Register<Feature<?>> event) {
				feature = new Feature<NoneFeatureConfiguration>(NoneFeatureConfiguration.CODEC) {
					@Override
					public boolean place(WorldGenLevel world, ChunkGenerator generator, RandomSource random, BlockPos pos, NoneFeatureConfiguration config) {
						int ci = (pos.getX() >> 4) << 4;
						int ck = (pos.getZ() >> 4) << 4;
						ResourceKey<Level> dimensionType = world.getLevel().dimension();
						boolean dimensionCriteria = false;
						if (dimensionType == ResourceKey.create(Registries.DIMENSION, Identifier.parse("naruto_shippuden:kamui_dimension")))
							dimensionCriteria = true;
						if (!dimensionCriteria)
							return false;
						if ((random.nextInt(1000000) + 1) <= 550000) {
							int count = random.nextInt(1) + 1;
							for (int a = 0; a < count; a++) {
								int i = ci + random.nextInt(16);
								int k = ck + random.nextInt(16);
								int j = world.getHeight(Heightmap.Types.WORLD_SURFACE_WG, i, k);
								j -= 1;
								Rotation rotation = Rotation.NONE;
								Mirror mirror = Mirror.NONE;
								BlockPos spawnTo = BlockPos.containing(i + 0, j + 1, k + 0);
								int x = spawnTo.getX();
								int y = spawnTo.getY();
								int z = spawnTo.getZ();
								if (!KamuiTower7AdditionalGenerationConditionProcedure.executeProcedure(Stream
										.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x),
												new AbstractMap.SimpleEntry<>("z", z))
										.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
									continue;
								StructureTemplate template = world.getLevel().getStructureManager()
										.getOrCreate(Identifier.fromNamespaceAndPath("naruto_shippuden", "kamui_tower7"));
								if (template == null)
									return false;
								template.placeInWorldChunk(world, spawnTo,
										new StructurePlaceSettings().setRotation(rotation).setRandom(random).setMirror(mirror)
												.addProcessor(BlockIgnoreProcessor.STRUCTURE_BLOCK).setChunkPos(null).setIgnoreEntities(false),
										random);
							}
						}
						return true;
					}
				};
				configuredFeature = feature.configured(FeatureConfiguration.NONE)
						.decorated(FeatureDecorator.NOPE.configured(DecoratorConfiguration.NONE));
				event.getRegistry().register(feature.setRegistryName("kamui_tower_7"));
				Registry.register(BuiltInRegistries.CONFIGURED_FEATURE, Identifier.parse("naruto_shippuden:kamui_tower_7"), configuredFeature);
			}
		}

		@SubscribeEvent
		public static void addFeatureToBiomes(BiomeLoadingEvent event) {
			event.getGeneration().getFeatures(GenerationStep.Decoration.SURFACE_STRUCTURES).add(() -> configuredFeature);
		}
	}

	@Mod.EventBusSubscriber
	public static class KamuiTower8Structure {
		private static Feature<NoneFeatureConfiguration> feature = null;
		private static ConfiguredFeature<?, ?> configuredFeature = null;

		@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
		public static class FeatureRegisterHandler {
			@SubscribeEvent
			public static void registerFeature(RegistryEvent.Register<Feature<?>> event) {
				feature = new Feature<NoneFeatureConfiguration>(NoneFeatureConfiguration.CODEC) {
					@Override
					public boolean place(WorldGenLevel world, ChunkGenerator generator, RandomSource random, BlockPos pos, NoneFeatureConfiguration config) {
						int ci = (pos.getX() >> 4) << 4;
						int ck = (pos.getZ() >> 4) << 4;
						ResourceKey<Level> dimensionType = world.getLevel().dimension();
						boolean dimensionCriteria = false;
						if (dimensionType == ResourceKey.create(Registries.DIMENSION, Identifier.parse("naruto_shippuden:kamui_dimension")))
							dimensionCriteria = true;
						if (!dimensionCriteria)
							return false;
						if ((random.nextInt(1000000) + 1) <= 550000) {
							int count = random.nextInt(1) + 1;
							for (int a = 0; a < count; a++) {
								int i = ci + random.nextInt(16);
								int k = ck + random.nextInt(16);
								int j = world.getHeight(Heightmap.Types.WORLD_SURFACE_WG, i, k);
								j -= 1;
								Rotation rotation = Rotation.NONE;
								Mirror mirror = Mirror.NONE;
								BlockPos spawnTo = BlockPos.containing(i + 0, j + 1, k + 0);
								int x = spawnTo.getX();
								int y = spawnTo.getY();
								int z = spawnTo.getZ();
								if (!KamuiTower7AdditionalGenerationConditionProcedure.executeProcedure(Stream
										.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x),
												new AbstractMap.SimpleEntry<>("z", z))
										.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
									continue;
								StructureTemplate template = world.getLevel().getStructureManager()
										.getOrCreate(Identifier.fromNamespaceAndPath("naruto_shippuden", "kamui_tower8"));
								if (template == null)
									return false;
								template.placeInWorldChunk(world, spawnTo,
										new StructurePlaceSettings().setRotation(rotation).setRandom(random).setMirror(mirror)
												.addProcessor(BlockIgnoreProcessor.STRUCTURE_BLOCK).setChunkPos(null).setIgnoreEntities(false),
										random);
							}
						}
						return true;
					}
				};
				configuredFeature = feature.configured(FeatureConfiguration.NONE)
						.decorated(FeatureDecorator.NOPE.configured(DecoratorConfiguration.NONE));
				event.getRegistry().register(feature.setRegistryName("kamui_tower_8"));
				Registry.register(BuiltInRegistries.CONFIGURED_FEATURE, Identifier.parse("naruto_shippuden:kamui_tower_8"), configuredFeature);
			}
		}

		@SubscribeEvent
		public static void addFeatureToBiomes(BiomeLoadingEvent event) {
			event.getGeneration().getFeatures(GenerationStep.Decoration.SURFACE_STRUCTURES).add(() -> configuredFeature);
		}
	}

	@Mod.EventBusSubscriber
	public static class KamuiTower9Structure {
		private static Feature<NoneFeatureConfiguration> feature = null;
		private static ConfiguredFeature<?, ?> configuredFeature = null;

		@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
		public static class FeatureRegisterHandler {
			@SubscribeEvent
			public static void registerFeature(RegistryEvent.Register<Feature<?>> event) {
				feature = new Feature<NoneFeatureConfiguration>(NoneFeatureConfiguration.CODEC) {
					@Override
					public boolean place(WorldGenLevel world, ChunkGenerator generator, RandomSource random, BlockPos pos, NoneFeatureConfiguration config) {
						int ci = (pos.getX() >> 4) << 4;
						int ck = (pos.getZ() >> 4) << 4;
						ResourceKey<Level> dimensionType = world.getLevel().dimension();
						boolean dimensionCriteria = false;
						if (dimensionType == ResourceKey.create(Registries.DIMENSION, Identifier.parse("naruto_shippuden:kamui_dimension")))
							dimensionCriteria = true;
						if (!dimensionCriteria)
							return false;
						if ((random.nextInt(1000000) + 1) <= 550000) {
							int count = random.nextInt(1) + 1;
							for (int a = 0; a < count; a++) {
								int i = ci + random.nextInt(16);
								int k = ck + random.nextInt(16);
								int j = world.getHeight(Heightmap.Types.WORLD_SURFACE_WG, i, k);
								j -= 1;
								Rotation rotation = Rotation.NONE;
								Mirror mirror = Mirror.NONE;
								BlockPos spawnTo = BlockPos.containing(i + 0, j + 1, k + 0);
								int x = spawnTo.getX();
								int y = spawnTo.getY();
								int z = spawnTo.getZ();
								if (!KamuiTower7AdditionalGenerationConditionProcedure.executeProcedure(Stream
										.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x),
												new AbstractMap.SimpleEntry<>("z", z))
										.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
									continue;
								StructureTemplate template = world.getLevel().getStructureManager()
										.getOrCreate(Identifier.fromNamespaceAndPath("naruto_shippuden", "kamui_tower9"));
								if (template == null)
									return false;
								template.placeInWorldChunk(world, spawnTo,
										new StructurePlaceSettings().setRotation(rotation).setRandom(random).setMirror(mirror)
												.addProcessor(BlockIgnoreProcessor.STRUCTURE_BLOCK).setChunkPos(null).setIgnoreEntities(false),
										random);
							}
						}
						return true;
					}
				};
				configuredFeature = feature.configured(FeatureConfiguration.NONE)
						.decorated(FeatureDecorator.NOPE.configured(DecoratorConfiguration.NONE));
				event.getRegistry().register(feature.setRegistryName("kamui_tower_9"));
				Registry.register(BuiltInRegistries.CONFIGURED_FEATURE, Identifier.parse("naruto_shippuden:kamui_tower_9"), configuredFeature);
			}
		}

		@SubscribeEvent
		public static void addFeatureToBiomes(BiomeLoadingEvent event) {
			event.getGeneration().getFeatures(GenerationStep.Decoration.SURFACE_STRUCTURES).add(() -> configuredFeature);
		}
	}
}
