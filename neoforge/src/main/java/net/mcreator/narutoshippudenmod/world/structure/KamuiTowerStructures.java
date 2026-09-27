package net.mcreator.narutoshippudenmod.world.structure;

import net.minecraft.util.RandomSource;
import net.minecraft.core.registries.Registries;
import net.neoforged.fml.common.EventBusSubscriber;

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
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockIgnoreProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;


import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import com.mojang.serialization.MapCodec;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.mcreator.narutoshippudenmod.compat.Registration;

public final class KamuiTowerStructures {
	private KamuiTowerStructures() {
	}

	public static void register() {
		KamuiTower1Structure.register();
		KamuiTower2Structure.register();
		KamuiTower3Structure.register();
		KamuiTower4Structure.register();
		KamuiTower5Structure.register();
		KamuiTower6Structure.register();
		KamuiTower7Structure.register();
		KamuiTower8Structure.register();
		KamuiTower9Structure.register();
	}

	public record KamuiTower1Structure() implements Feature {
		public static final MapCodec<KamuiTower1Structure> CODEC = MapCodec.unit(KamuiTower1Structure::new);

		static void register() {
			Registration.add(Registries.FEATURE_TYPE, "kamui_tower_1", () -> CODEC, null);
		}

		@Override
		public MapCodec<KamuiTower1Structure> codec() {
			return CODEC;
		}

		@Override
		public boolean place(WorldGenLevel world, ChunkGenerator generator, RandomSource random, BlockPos pos) {

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
								StructureTemplate template = world.getLevel().getServer().getStructureTemplateManager().getOrCreate(Identifier.fromNamespaceAndPath("naruto_shippuden", "kamui_tower1"));
								if (template == null)
									return false;
								template.placeInWorld(world, spawnTo, spawnTo, new StructurePlaceSettings().setRotation(rotation).setRandom(random).setMirror(mirror)
												.addProcessor(BlockIgnoreProcessor.STRUCTURE_BLOCK).setIgnoreEntities(false), random, 2);
							}
						}
						return true;
		}
	}

	public record KamuiTower2Structure() implements Feature {
		public static final MapCodec<KamuiTower2Structure> CODEC = MapCodec.unit(KamuiTower2Structure::new);

		static void register() {
			Registration.add(Registries.FEATURE_TYPE, "kamui_tower_2", () -> CODEC, null);
		}

		@Override
		public MapCodec<KamuiTower2Structure> codec() {
			return CODEC;
		}

		@Override
		public boolean place(WorldGenLevel world, ChunkGenerator generator, RandomSource random, BlockPos pos) {

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
								StructureTemplate template = world.getLevel().getServer().getStructureTemplateManager().getOrCreate(Identifier.fromNamespaceAndPath("naruto_shippuden", "kamui_tower2"));
								if (template == null)
									return false;
								template.placeInWorld(world, spawnTo, spawnTo, new StructurePlaceSettings().setRotation(rotation).setRandom(random).setMirror(mirror)
												.addProcessor(BlockIgnoreProcessor.STRUCTURE_BLOCK).setIgnoreEntities(false), random, 2);
							}
						}
						return true;
		}
	}

	public record KamuiTower3Structure() implements Feature {
		public static final MapCodec<KamuiTower3Structure> CODEC = MapCodec.unit(KamuiTower3Structure::new);

		static void register() {
			Registration.add(Registries.FEATURE_TYPE, "kamui_tower_3", () -> CODEC, null);
		}

		@Override
		public MapCodec<KamuiTower3Structure> codec() {
			return CODEC;
		}

		@Override
		public boolean place(WorldGenLevel world, ChunkGenerator generator, RandomSource random, BlockPos pos) {

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
								StructureTemplate template = world.getLevel().getServer().getStructureTemplateManager().getOrCreate(Identifier.fromNamespaceAndPath("naruto_shippuden", "kamui_tower3"));
								if (template == null)
									return false;
								template.placeInWorld(world, spawnTo, spawnTo, new StructurePlaceSettings().setRotation(rotation).setRandom(random).setMirror(mirror)
												.addProcessor(BlockIgnoreProcessor.STRUCTURE_BLOCK).setIgnoreEntities(false), random, 2);
							}
						}
						return true;
		}
	}

	public record KamuiTower4Structure() implements Feature {
		public static final MapCodec<KamuiTower4Structure> CODEC = MapCodec.unit(KamuiTower4Structure::new);

		static void register() {
			Registration.add(Registries.FEATURE_TYPE, "kamui_tower_4", () -> CODEC, null);
		}

		@Override
		public MapCodec<KamuiTower4Structure> codec() {
			return CODEC;
		}

		@Override
		public boolean place(WorldGenLevel world, ChunkGenerator generator, RandomSource random, BlockPos pos) {

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
								StructureTemplate template = world.getLevel().getServer().getStructureTemplateManager().getOrCreate(Identifier.fromNamespaceAndPath("naruto_shippuden", "kamui_tower4"));
								if (template == null)
									return false;
								template.placeInWorld(world, spawnTo, spawnTo, new StructurePlaceSettings().setRotation(rotation).setRandom(random).setMirror(mirror)
												.addProcessor(BlockIgnoreProcessor.STRUCTURE_BLOCK).setIgnoreEntities(false), random, 2);
							}
						}
						return true;
		}
	}

	public record KamuiTower5Structure() implements Feature {
		public static final MapCodec<KamuiTower5Structure> CODEC = MapCodec.unit(KamuiTower5Structure::new);

		static void register() {
			Registration.add(Registries.FEATURE_TYPE, "kamui_tower_5", () -> CODEC, null);
		}

		@Override
		public MapCodec<KamuiTower5Structure> codec() {
			return CODEC;
		}

		@Override
		public boolean place(WorldGenLevel world, ChunkGenerator generator, RandomSource random, BlockPos pos) {

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
								StructureTemplate template = world.getLevel().getServer().getStructureTemplateManager().getOrCreate(Identifier.fromNamespaceAndPath("naruto_shippuden", "kamui_tower5"));
								if (template == null)
									return false;
								template.placeInWorld(world, spawnTo, spawnTo, new StructurePlaceSettings().setRotation(rotation).setRandom(random).setMirror(mirror)
												.addProcessor(BlockIgnoreProcessor.STRUCTURE_BLOCK).setIgnoreEntities(false), random, 2);
							}
						}
						return true;
		}
	}

	public record KamuiTower6Structure() implements Feature {
		public static final MapCodec<KamuiTower6Structure> CODEC = MapCodec.unit(KamuiTower6Structure::new);

		static void register() {
			Registration.add(Registries.FEATURE_TYPE, "kamui_tower_6", () -> CODEC, null);
		}

		@Override
		public MapCodec<KamuiTower6Structure> codec() {
			return CODEC;
		}

		@Override
		public boolean place(WorldGenLevel world, ChunkGenerator generator, RandomSource random, BlockPos pos) {

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
								StructureTemplate template = world.getLevel().getServer().getStructureTemplateManager().getOrCreate(Identifier.fromNamespaceAndPath("naruto_shippuden", "kamui_tower6"));
								if (template == null)
									return false;
								template.placeInWorld(world, spawnTo, spawnTo, new StructurePlaceSettings().setRotation(rotation).setRandom(random).setMirror(mirror)
												.addProcessor(BlockIgnoreProcessor.STRUCTURE_BLOCK).setIgnoreEntities(false), random, 2);
							}
						}
						return true;
		}
	}

	public record KamuiTower7Structure() implements Feature {
		public static final MapCodec<KamuiTower7Structure> CODEC = MapCodec.unit(KamuiTower7Structure::new);

		static void register() {
			Registration.add(Registries.FEATURE_TYPE, "kamui_tower_7", () -> CODEC, null);
		}

		@Override
		public MapCodec<KamuiTower7Structure> codec() {
			return CODEC;
		}

		@Override
		public boolean place(WorldGenLevel world, ChunkGenerator generator, RandomSource random, BlockPos pos) {

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
								StructureTemplate template = world.getLevel().getServer().getStructureTemplateManager().getOrCreate(Identifier.fromNamespaceAndPath("naruto_shippuden", "kamui_tower7"));
								if (template == null)
									return false;
								template.placeInWorld(world, spawnTo, spawnTo, new StructurePlaceSettings().setRotation(rotation).setRandom(random).setMirror(mirror)
												.addProcessor(BlockIgnoreProcessor.STRUCTURE_BLOCK).setIgnoreEntities(false), random, 2);
							}
						}
						return true;
		}
	}

	public record KamuiTower8Structure() implements Feature {
		public static final MapCodec<KamuiTower8Structure> CODEC = MapCodec.unit(KamuiTower8Structure::new);

		static void register() {
			Registration.add(Registries.FEATURE_TYPE, "kamui_tower_8", () -> CODEC, null);
		}

		@Override
		public MapCodec<KamuiTower8Structure> codec() {
			return CODEC;
		}

		@Override
		public boolean place(WorldGenLevel world, ChunkGenerator generator, RandomSource random, BlockPos pos) {

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
								StructureTemplate template = world.getLevel().getServer().getStructureTemplateManager().getOrCreate(Identifier.fromNamespaceAndPath("naruto_shippuden", "kamui_tower8"));
								if (template == null)
									return false;
								template.placeInWorld(world, spawnTo, spawnTo, new StructurePlaceSettings().setRotation(rotation).setRandom(random).setMirror(mirror)
												.addProcessor(BlockIgnoreProcessor.STRUCTURE_BLOCK).setIgnoreEntities(false), random, 2);
							}
						}
						return true;
		}
	}

	public record KamuiTower9Structure() implements Feature {
		public static final MapCodec<KamuiTower9Structure> CODEC = MapCodec.unit(KamuiTower9Structure::new);

		static void register() {
			Registration.add(Registries.FEATURE_TYPE, "kamui_tower_9", () -> CODEC, null);
		}

		@Override
		public MapCodec<KamuiTower9Structure> codec() {
			return CODEC;
		}

		@Override
		public boolean place(WorldGenLevel world, ChunkGenerator generator, RandomSource random, BlockPos pos) {

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
								StructureTemplate template = world.getLevel().getServer().getStructureTemplateManager().getOrCreate(Identifier.fromNamespaceAndPath("naruto_shippuden", "kamui_tower9"));
								if (template == null)
									return false;
								template.placeInWorld(world, spawnTo, spawnTo, new StructurePlaceSettings().setRotation(rotation).setRandom(random).setMirror(mirror)
												.addProcessor(BlockIgnoreProcessor.STRUCTURE_BLOCK).setIgnoreEntities(false), random, 2);
							}
						}
						return true;
		}
	}
}
