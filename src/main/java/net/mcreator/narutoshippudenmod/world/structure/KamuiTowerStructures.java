package net.mcreator.narutoshippudenmod.world.structure;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.stream.Stream;
import net.mcreator.narutoshippudenmod.procedures.DojutsuProcedures.KamuiTower1AdditionalGenerationConditionProcedure;
import net.mcreator.narutoshippudenmod.procedures.DojutsuProcedures.KamuiTower4AdditionalGenerationConditionProcedure;
import net.mcreator.narutoshippudenmod.procedures.DojutsuProcedures.KamuiTower7AdditionalGenerationConditionProcedure;
import net.minecraft.util.Mirror;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.World;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.template.BlockIgnoreStructureProcessor;
import net.minecraft.world.gen.feature.template.PlacementSettings;
import net.minecraft.world.gen.feature.template.Template;
import net.minecraft.world.gen.placement.IPlacementConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public final class KamuiTowerStructures {
	private KamuiTowerStructures() {
	}

	@Mod.EventBusSubscriber
	public static class KamuiTower1Structure {
		private static Feature<NoFeatureConfig> feature = null;
		private static ConfiguredFeature<?, ?> configuredFeature = null;

		@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
		private static class FeatureRegisterHandler {
			@SubscribeEvent
			public static void registerFeature(RegistryEvent.Register<Feature<?>> event) {
				feature = new Feature<NoFeatureConfig>(NoFeatureConfig.field_236558_a_) {
					@Override
					public boolean generate(ISeedReader world, ChunkGenerator generator, Random random, BlockPos pos, NoFeatureConfig config) {
						int ci = (pos.getX() >> 4) << 4;
						int ck = (pos.getZ() >> 4) << 4;
						RegistryKey<World> dimensionType = world.getWorld().getDimensionKey();
						boolean dimensionCriteria = false;
						if (dimensionType == RegistryKey.getOrCreateKey(Registry.WORLD_KEY, new ResourceLocation("naruto_shippuden:kamui_dimension")))
							dimensionCriteria = true;
						if (!dimensionCriteria)
							return false;
						if ((random.nextInt(1000000) + 1) <= 550000) {
							int count = random.nextInt(1) + 1;
							for (int a = 0; a < count; a++) {
								int i = ci + random.nextInt(16);
								int k = ck + random.nextInt(16);
								int j = world.getHeight(Heightmap.Type.WORLD_SURFACE_WG, i, k);
								j -= 1;
								Rotation rotation = Rotation.NONE;
								Mirror mirror = Mirror.NONE;
								BlockPos spawnTo = new BlockPos(i + 0, j + 1, k + 0);
								int x = spawnTo.getX();
								int y = spawnTo.getY();
								int z = spawnTo.getZ();
								if (!KamuiTower1AdditionalGenerationConditionProcedure.executeProcedure(Stream
										.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x),
												new AbstractMap.SimpleEntry<>("z", z))
										.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
									continue;
								Template template = world.getWorld().getStructureTemplateManager()
										.getTemplateDefaulted(new ResourceLocation("naruto_shippuden", "kamui_tower1"));
								if (template == null)
									return false;
								template.func_237144_a_(world, spawnTo,
										new PlacementSettings().setRotation(rotation).setRandom(random).setMirror(mirror)
												.addProcessor(BlockIgnoreStructureProcessor.STRUCTURE_BLOCK).setChunk(null).setIgnoreEntities(false),
										random);
							}
						}
						return true;
					}
				};
				configuredFeature = feature.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG)
						.withPlacement(Placement.NOPE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG));
				event.getRegistry().register(feature.setRegistryName("kamui_tower_1"));
				Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, new ResourceLocation("naruto_shippuden:kamui_tower_1"), configuredFeature);
			}
		}

		@SubscribeEvent
		public static void addFeatureToBiomes(BiomeLoadingEvent event) {
			event.getGeneration().getFeatures(GenerationStage.Decoration.SURFACE_STRUCTURES).add(() -> configuredFeature);
		}
	}

	@Mod.EventBusSubscriber
	public static class KamuiTower2Structure {
		private static Feature<NoFeatureConfig> feature = null;
		private static ConfiguredFeature<?, ?> configuredFeature = null;

		@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
		private static class FeatureRegisterHandler {
			@SubscribeEvent
			public static void registerFeature(RegistryEvent.Register<Feature<?>> event) {
				feature = new Feature<NoFeatureConfig>(NoFeatureConfig.field_236558_a_) {
					@Override
					public boolean generate(ISeedReader world, ChunkGenerator generator, Random random, BlockPos pos, NoFeatureConfig config) {
						int ci = (pos.getX() >> 4) << 4;
						int ck = (pos.getZ() >> 4) << 4;
						RegistryKey<World> dimensionType = world.getWorld().getDimensionKey();
						boolean dimensionCriteria = false;
						if (dimensionType == RegistryKey.getOrCreateKey(Registry.WORLD_KEY, new ResourceLocation("naruto_shippuden:kamui_dimension")))
							dimensionCriteria = true;
						if (!dimensionCriteria)
							return false;
						if ((random.nextInt(1000000) + 1) <= 550000) {
							int count = random.nextInt(1) + 1;
							for (int a = 0; a < count; a++) {
								int i = ci + random.nextInt(16);
								int k = ck + random.nextInt(16);
								int j = world.getHeight(Heightmap.Type.WORLD_SURFACE_WG, i, k);
								j -= 1;
								Rotation rotation = Rotation.NONE;
								Mirror mirror = Mirror.NONE;
								BlockPos spawnTo = new BlockPos(i + 0, j + 1, k + 0);
								int x = spawnTo.getX();
								int y = spawnTo.getY();
								int z = spawnTo.getZ();
								if (!KamuiTower1AdditionalGenerationConditionProcedure.executeProcedure(Stream
										.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x),
												new AbstractMap.SimpleEntry<>("z", z))
										.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
									continue;
								Template template = world.getWorld().getStructureTemplateManager()
										.getTemplateDefaulted(new ResourceLocation("naruto_shippuden", "kamui_tower2"));
								if (template == null)
									return false;
								template.func_237144_a_(world, spawnTo,
										new PlacementSettings().setRotation(rotation).setRandom(random).setMirror(mirror)
												.addProcessor(BlockIgnoreStructureProcessor.STRUCTURE_BLOCK).setChunk(null).setIgnoreEntities(false),
										random);
							}
						}
						return true;
					}
				};
				configuredFeature = feature.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG)
						.withPlacement(Placement.NOPE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG));
				event.getRegistry().register(feature.setRegistryName("kamui_tower_2"));
				Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, new ResourceLocation("naruto_shippuden:kamui_tower_2"), configuredFeature);
			}
		}

		@SubscribeEvent
		public static void addFeatureToBiomes(BiomeLoadingEvent event) {
			event.getGeneration().getFeatures(GenerationStage.Decoration.SURFACE_STRUCTURES).add(() -> configuredFeature);
		}
	}

	@Mod.EventBusSubscriber
	public static class KamuiTower3Structure {
		private static Feature<NoFeatureConfig> feature = null;
		private static ConfiguredFeature<?, ?> configuredFeature = null;

		@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
		private static class FeatureRegisterHandler {
			@SubscribeEvent
			public static void registerFeature(RegistryEvent.Register<Feature<?>> event) {
				feature = new Feature<NoFeatureConfig>(NoFeatureConfig.field_236558_a_) {
					@Override
					public boolean generate(ISeedReader world, ChunkGenerator generator, Random random, BlockPos pos, NoFeatureConfig config) {
						int ci = (pos.getX() >> 4) << 4;
						int ck = (pos.getZ() >> 4) << 4;
						RegistryKey<World> dimensionType = world.getWorld().getDimensionKey();
						boolean dimensionCriteria = false;
						if (dimensionType == RegistryKey.getOrCreateKey(Registry.WORLD_KEY, new ResourceLocation("naruto_shippuden:kamui_dimension")))
							dimensionCriteria = true;
						if (!dimensionCriteria)
							return false;
						if ((random.nextInt(1000000) + 1) <= 550000) {
							int count = random.nextInt(1) + 1;
							for (int a = 0; a < count; a++) {
								int i = ci + random.nextInt(16);
								int k = ck + random.nextInt(16);
								int j = world.getHeight(Heightmap.Type.WORLD_SURFACE_WG, i, k);
								j -= 1;
								Rotation rotation = Rotation.NONE;
								Mirror mirror = Mirror.NONE;
								BlockPos spawnTo = new BlockPos(i + 0, j + 1, k + 0);
								int x = spawnTo.getX();
								int y = spawnTo.getY();
								int z = spawnTo.getZ();
								if (!KamuiTower1AdditionalGenerationConditionProcedure.executeProcedure(Stream
										.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x),
												new AbstractMap.SimpleEntry<>("z", z))
										.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
									continue;
								Template template = world.getWorld().getStructureTemplateManager()
										.getTemplateDefaulted(new ResourceLocation("naruto_shippuden", "kamui_tower3"));
								if (template == null)
									return false;
								template.func_237144_a_(world, spawnTo,
										new PlacementSettings().setRotation(rotation).setRandom(random).setMirror(mirror)
												.addProcessor(BlockIgnoreStructureProcessor.STRUCTURE_BLOCK).setChunk(null).setIgnoreEntities(false),
										random);
							}
						}
						return true;
					}
				};
				configuredFeature = feature.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG)
						.withPlacement(Placement.NOPE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG));
				event.getRegistry().register(feature.setRegistryName("kamui_tower_3"));
				Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, new ResourceLocation("naruto_shippuden:kamui_tower_3"), configuredFeature);
			}
		}

		@SubscribeEvent
		public static void addFeatureToBiomes(BiomeLoadingEvent event) {
			event.getGeneration().getFeatures(GenerationStage.Decoration.SURFACE_STRUCTURES).add(() -> configuredFeature);
		}
	}

	@Mod.EventBusSubscriber
	public static class KamuiTower4Structure {
		private static Feature<NoFeatureConfig> feature = null;
		private static ConfiguredFeature<?, ?> configuredFeature = null;

		@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
		private static class FeatureRegisterHandler {
			@SubscribeEvent
			public static void registerFeature(RegistryEvent.Register<Feature<?>> event) {
				feature = new Feature<NoFeatureConfig>(NoFeatureConfig.field_236558_a_) {
					@Override
					public boolean generate(ISeedReader world, ChunkGenerator generator, Random random, BlockPos pos, NoFeatureConfig config) {
						int ci = (pos.getX() >> 4) << 4;
						int ck = (pos.getZ() >> 4) << 4;
						RegistryKey<World> dimensionType = world.getWorld().getDimensionKey();
						boolean dimensionCriteria = false;
						if (dimensionType == RegistryKey.getOrCreateKey(Registry.WORLD_KEY, new ResourceLocation("naruto_shippuden:kamui_dimension")))
							dimensionCriteria = true;
						if (!dimensionCriteria)
							return false;
						if ((random.nextInt(1000000) + 1) <= 800000) {
							int count = random.nextInt(1) + 1;
							for (int a = 0; a < count; a++) {
								int i = ci + random.nextInt(16);
								int k = ck + random.nextInt(16);
								int j = world.getHeight(Heightmap.Type.WORLD_SURFACE_WG, i, k);
								j -= 1;
								Rotation rotation = Rotation.NONE;
								Mirror mirror = Mirror.NONE;
								BlockPos spawnTo = new BlockPos(i + 0, j + 1, k + 0);
								int x = spawnTo.getX();
								int y = spawnTo.getY();
								int z = spawnTo.getZ();
								if (!KamuiTower4AdditionalGenerationConditionProcedure.executeProcedure(Stream
										.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x),
												new AbstractMap.SimpleEntry<>("z", z))
										.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
									continue;
								Template template = world.getWorld().getStructureTemplateManager()
										.getTemplateDefaulted(new ResourceLocation("naruto_shippuden", "kamui_tower4"));
								if (template == null)
									return false;
								template.func_237144_a_(world, spawnTo,
										new PlacementSettings().setRotation(rotation).setRandom(random).setMirror(mirror)
												.addProcessor(BlockIgnoreStructureProcessor.STRUCTURE_BLOCK).setChunk(null).setIgnoreEntities(false),
										random);
							}
						}
						return true;
					}
				};
				configuredFeature = feature.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG)
						.withPlacement(Placement.NOPE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG));
				event.getRegistry().register(feature.setRegistryName("kamui_tower_4"));
				Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, new ResourceLocation("naruto_shippuden:kamui_tower_4"), configuredFeature);
			}
		}

		@SubscribeEvent
		public static void addFeatureToBiomes(BiomeLoadingEvent event) {
			event.getGeneration().getFeatures(GenerationStage.Decoration.SURFACE_STRUCTURES).add(() -> configuredFeature);
		}
	}

	@Mod.EventBusSubscriber
	public static class KamuiTower5Structure {
		private static Feature<NoFeatureConfig> feature = null;
		private static ConfiguredFeature<?, ?> configuredFeature = null;

		@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
		private static class FeatureRegisterHandler {
			@SubscribeEvent
			public static void registerFeature(RegistryEvent.Register<Feature<?>> event) {
				feature = new Feature<NoFeatureConfig>(NoFeatureConfig.field_236558_a_) {
					@Override
					public boolean generate(ISeedReader world, ChunkGenerator generator, Random random, BlockPos pos, NoFeatureConfig config) {
						int ci = (pos.getX() >> 4) << 4;
						int ck = (pos.getZ() >> 4) << 4;
						RegistryKey<World> dimensionType = world.getWorld().getDimensionKey();
						boolean dimensionCriteria = false;
						if (dimensionType == RegistryKey.getOrCreateKey(Registry.WORLD_KEY, new ResourceLocation("naruto_shippuden:kamui_dimension")))
							dimensionCriteria = true;
						if (!dimensionCriteria)
							return false;
						if ((random.nextInt(1000000) + 1) <= 800000) {
							int count = random.nextInt(1) + 1;
							for (int a = 0; a < count; a++) {
								int i = ci + random.nextInt(16);
								int k = ck + random.nextInt(16);
								int j = world.getHeight(Heightmap.Type.WORLD_SURFACE_WG, i, k);
								j -= 1;
								Rotation rotation = Rotation.NONE;
								Mirror mirror = Mirror.NONE;
								BlockPos spawnTo = new BlockPos(i + 0, j + 1, k + 0);
								int x = spawnTo.getX();
								int y = spawnTo.getY();
								int z = spawnTo.getZ();
								if (!KamuiTower4AdditionalGenerationConditionProcedure.executeProcedure(Stream
										.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x),
												new AbstractMap.SimpleEntry<>("z", z))
										.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
									continue;
								Template template = world.getWorld().getStructureTemplateManager()
										.getTemplateDefaulted(new ResourceLocation("naruto_shippuden", "kamui_tower5"));
								if (template == null)
									return false;
								template.func_237144_a_(world, spawnTo,
										new PlacementSettings().setRotation(rotation).setRandom(random).setMirror(mirror)
												.addProcessor(BlockIgnoreStructureProcessor.STRUCTURE_BLOCK).setChunk(null).setIgnoreEntities(false),
										random);
							}
						}
						return true;
					}
				};
				configuredFeature = feature.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG)
						.withPlacement(Placement.NOPE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG));
				event.getRegistry().register(feature.setRegistryName("kamui_tower_5"));
				Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, new ResourceLocation("naruto_shippuden:kamui_tower_5"), configuredFeature);
			}
		}

		@SubscribeEvent
		public static void addFeatureToBiomes(BiomeLoadingEvent event) {
			event.getGeneration().getFeatures(GenerationStage.Decoration.SURFACE_STRUCTURES).add(() -> configuredFeature);
		}
	}

	@Mod.EventBusSubscriber
	public static class KamuiTower6Structure {
		private static Feature<NoFeatureConfig> feature = null;
		private static ConfiguredFeature<?, ?> configuredFeature = null;

		@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
		private static class FeatureRegisterHandler {
			@SubscribeEvent
			public static void registerFeature(RegistryEvent.Register<Feature<?>> event) {
				feature = new Feature<NoFeatureConfig>(NoFeatureConfig.field_236558_a_) {
					@Override
					public boolean generate(ISeedReader world, ChunkGenerator generator, Random random, BlockPos pos, NoFeatureConfig config) {
						int ci = (pos.getX() >> 4) << 4;
						int ck = (pos.getZ() >> 4) << 4;
						RegistryKey<World> dimensionType = world.getWorld().getDimensionKey();
						boolean dimensionCriteria = false;
						if (dimensionType == RegistryKey.getOrCreateKey(Registry.WORLD_KEY, new ResourceLocation("naruto_shippuden:kamui_dimension")))
							dimensionCriteria = true;
						if (!dimensionCriteria)
							return false;
						if ((random.nextInt(1000000) + 1) <= 800000) {
							int count = random.nextInt(1) + 1;
							for (int a = 0; a < count; a++) {
								int i = ci + random.nextInt(16);
								int k = ck + random.nextInt(16);
								int j = world.getHeight(Heightmap.Type.WORLD_SURFACE_WG, i, k);
								j -= 1;
								Rotation rotation = Rotation.NONE;
								Mirror mirror = Mirror.NONE;
								BlockPos spawnTo = new BlockPos(i + 0, j + 1, k + 0);
								int x = spawnTo.getX();
								int y = spawnTo.getY();
								int z = spawnTo.getZ();
								if (!KamuiTower4AdditionalGenerationConditionProcedure.executeProcedure(Stream
										.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x),
												new AbstractMap.SimpleEntry<>("z", z))
										.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
									continue;
								Template template = world.getWorld().getStructureTemplateManager()
										.getTemplateDefaulted(new ResourceLocation("naruto_shippuden", "kamui_tower6"));
								if (template == null)
									return false;
								template.func_237144_a_(world, spawnTo,
										new PlacementSettings().setRotation(rotation).setRandom(random).setMirror(mirror)
												.addProcessor(BlockIgnoreStructureProcessor.STRUCTURE_BLOCK).setChunk(null).setIgnoreEntities(false),
										random);
							}
						}
						return true;
					}
				};
				configuredFeature = feature.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG)
						.withPlacement(Placement.NOPE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG));
				event.getRegistry().register(feature.setRegistryName("kamui_tower_6"));
				Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, new ResourceLocation("naruto_shippuden:kamui_tower_6"), configuredFeature);
			}
		}

		@SubscribeEvent
		public static void addFeatureToBiomes(BiomeLoadingEvent event) {
			event.getGeneration().getFeatures(GenerationStage.Decoration.SURFACE_STRUCTURES).add(() -> configuredFeature);
		}
	}

	@Mod.EventBusSubscriber
	public static class KamuiTower7Structure {
		private static Feature<NoFeatureConfig> feature = null;
		private static ConfiguredFeature<?, ?> configuredFeature = null;

		@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
		private static class FeatureRegisterHandler {
			@SubscribeEvent
			public static void registerFeature(RegistryEvent.Register<Feature<?>> event) {
				feature = new Feature<NoFeatureConfig>(NoFeatureConfig.field_236558_a_) {
					@Override
					public boolean generate(ISeedReader world, ChunkGenerator generator, Random random, BlockPos pos, NoFeatureConfig config) {
						int ci = (pos.getX() >> 4) << 4;
						int ck = (pos.getZ() >> 4) << 4;
						RegistryKey<World> dimensionType = world.getWorld().getDimensionKey();
						boolean dimensionCriteria = false;
						if (dimensionType == RegistryKey.getOrCreateKey(Registry.WORLD_KEY, new ResourceLocation("naruto_shippuden:kamui_dimension")))
							dimensionCriteria = true;
						if (!dimensionCriteria)
							return false;
						if ((random.nextInt(1000000) + 1) <= 550000) {
							int count = random.nextInt(1) + 1;
							for (int a = 0; a < count; a++) {
								int i = ci + random.nextInt(16);
								int k = ck + random.nextInt(16);
								int j = world.getHeight(Heightmap.Type.WORLD_SURFACE_WG, i, k);
								j -= 1;
								Rotation rotation = Rotation.NONE;
								Mirror mirror = Mirror.NONE;
								BlockPos spawnTo = new BlockPos(i + 0, j + 1, k + 0);
								int x = spawnTo.getX();
								int y = spawnTo.getY();
								int z = spawnTo.getZ();
								if (!KamuiTower7AdditionalGenerationConditionProcedure.executeProcedure(Stream
										.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x),
												new AbstractMap.SimpleEntry<>("z", z))
										.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
									continue;
								Template template = world.getWorld().getStructureTemplateManager()
										.getTemplateDefaulted(new ResourceLocation("naruto_shippuden", "kamui_tower7"));
								if (template == null)
									return false;
								template.func_237144_a_(world, spawnTo,
										new PlacementSettings().setRotation(rotation).setRandom(random).setMirror(mirror)
												.addProcessor(BlockIgnoreStructureProcessor.STRUCTURE_BLOCK).setChunk(null).setIgnoreEntities(false),
										random);
							}
						}
						return true;
					}
				};
				configuredFeature = feature.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG)
						.withPlacement(Placement.NOPE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG));
				event.getRegistry().register(feature.setRegistryName("kamui_tower_7"));
				Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, new ResourceLocation("naruto_shippuden:kamui_tower_7"), configuredFeature);
			}
		}

		@SubscribeEvent
		public static void addFeatureToBiomes(BiomeLoadingEvent event) {
			event.getGeneration().getFeatures(GenerationStage.Decoration.SURFACE_STRUCTURES).add(() -> configuredFeature);
		}
	}

	@Mod.EventBusSubscriber
	public static class KamuiTower8Structure {
		private static Feature<NoFeatureConfig> feature = null;
		private static ConfiguredFeature<?, ?> configuredFeature = null;

		@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
		private static class FeatureRegisterHandler {
			@SubscribeEvent
			public static void registerFeature(RegistryEvent.Register<Feature<?>> event) {
				feature = new Feature<NoFeatureConfig>(NoFeatureConfig.field_236558_a_) {
					@Override
					public boolean generate(ISeedReader world, ChunkGenerator generator, Random random, BlockPos pos, NoFeatureConfig config) {
						int ci = (pos.getX() >> 4) << 4;
						int ck = (pos.getZ() >> 4) << 4;
						RegistryKey<World> dimensionType = world.getWorld().getDimensionKey();
						boolean dimensionCriteria = false;
						if (dimensionType == RegistryKey.getOrCreateKey(Registry.WORLD_KEY, new ResourceLocation("naruto_shippuden:kamui_dimension")))
							dimensionCriteria = true;
						if (!dimensionCriteria)
							return false;
						if ((random.nextInt(1000000) + 1) <= 550000) {
							int count = random.nextInt(1) + 1;
							for (int a = 0; a < count; a++) {
								int i = ci + random.nextInt(16);
								int k = ck + random.nextInt(16);
								int j = world.getHeight(Heightmap.Type.WORLD_SURFACE_WG, i, k);
								j -= 1;
								Rotation rotation = Rotation.NONE;
								Mirror mirror = Mirror.NONE;
								BlockPos spawnTo = new BlockPos(i + 0, j + 1, k + 0);
								int x = spawnTo.getX();
								int y = spawnTo.getY();
								int z = spawnTo.getZ();
								if (!KamuiTower7AdditionalGenerationConditionProcedure.executeProcedure(Stream
										.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x),
												new AbstractMap.SimpleEntry<>("z", z))
										.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
									continue;
								Template template = world.getWorld().getStructureTemplateManager()
										.getTemplateDefaulted(new ResourceLocation("naruto_shippuden", "kamui_tower8"));
								if (template == null)
									return false;
								template.func_237144_a_(world, spawnTo,
										new PlacementSettings().setRotation(rotation).setRandom(random).setMirror(mirror)
												.addProcessor(BlockIgnoreStructureProcessor.STRUCTURE_BLOCK).setChunk(null).setIgnoreEntities(false),
										random);
							}
						}
						return true;
					}
				};
				configuredFeature = feature.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG)
						.withPlacement(Placement.NOPE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG));
				event.getRegistry().register(feature.setRegistryName("kamui_tower_8"));
				Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, new ResourceLocation("naruto_shippuden:kamui_tower_8"), configuredFeature);
			}
		}

		@SubscribeEvent
		public static void addFeatureToBiomes(BiomeLoadingEvent event) {
			event.getGeneration().getFeatures(GenerationStage.Decoration.SURFACE_STRUCTURES).add(() -> configuredFeature);
		}
	}

	@Mod.EventBusSubscriber
	public static class KamuiTower9Structure {
		private static Feature<NoFeatureConfig> feature = null;
		private static ConfiguredFeature<?, ?> configuredFeature = null;

		@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
		private static class FeatureRegisterHandler {
			@SubscribeEvent
			public static void registerFeature(RegistryEvent.Register<Feature<?>> event) {
				feature = new Feature<NoFeatureConfig>(NoFeatureConfig.field_236558_a_) {
					@Override
					public boolean generate(ISeedReader world, ChunkGenerator generator, Random random, BlockPos pos, NoFeatureConfig config) {
						int ci = (pos.getX() >> 4) << 4;
						int ck = (pos.getZ() >> 4) << 4;
						RegistryKey<World> dimensionType = world.getWorld().getDimensionKey();
						boolean dimensionCriteria = false;
						if (dimensionType == RegistryKey.getOrCreateKey(Registry.WORLD_KEY, new ResourceLocation("naruto_shippuden:kamui_dimension")))
							dimensionCriteria = true;
						if (!dimensionCriteria)
							return false;
						if ((random.nextInt(1000000) + 1) <= 550000) {
							int count = random.nextInt(1) + 1;
							for (int a = 0; a < count; a++) {
								int i = ci + random.nextInt(16);
								int k = ck + random.nextInt(16);
								int j = world.getHeight(Heightmap.Type.WORLD_SURFACE_WG, i, k);
								j -= 1;
								Rotation rotation = Rotation.NONE;
								Mirror mirror = Mirror.NONE;
								BlockPos spawnTo = new BlockPos(i + 0, j + 1, k + 0);
								int x = spawnTo.getX();
								int y = spawnTo.getY();
								int z = spawnTo.getZ();
								if (!KamuiTower7AdditionalGenerationConditionProcedure.executeProcedure(Stream
										.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x),
												new AbstractMap.SimpleEntry<>("z", z))
										.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll)))
									continue;
								Template template = world.getWorld().getStructureTemplateManager()
										.getTemplateDefaulted(new ResourceLocation("naruto_shippuden", "kamui_tower9"));
								if (template == null)
									return false;
								template.func_237144_a_(world, spawnTo,
										new PlacementSettings().setRotation(rotation).setRandom(random).setMirror(mirror)
												.addProcessor(BlockIgnoreStructureProcessor.STRUCTURE_BLOCK).setChunk(null).setIgnoreEntities(false),
										random);
							}
						}
						return true;
					}
				};
				configuredFeature = feature.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG)
						.withPlacement(Placement.NOPE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG));
				event.getRegistry().register(feature.setRegistryName("kamui_tower_9"));
				Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, new ResourceLocation("naruto_shippuden:kamui_tower_9"), configuredFeature);
			}
		}

		@SubscribeEvent
		public static void addFeatureToBiomes(BiomeLoadingEvent event) {
			event.getGeneration().getFeatures(GenerationStage.Decoration.SURFACE_STRUCTURES).add(() -> configuredFeature);
		}
	}
}
