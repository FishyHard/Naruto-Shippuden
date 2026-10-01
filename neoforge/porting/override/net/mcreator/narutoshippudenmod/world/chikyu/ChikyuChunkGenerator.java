package net.mcreator.narutoshippudenmod.world.chikyu;

import net.mcreator.narutoshippudenmod.compat.Registration;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.WorldGenRegion;
import net.minecraft.util.Mth;
import net.minecraft.util.random.WeightedList;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelHeightAccessor;
import net.minecraft.world.level.NaturalSpawner;
import net.minecraft.world.level.NoiseColumn;
import net.minecraft.world.level.StructureManager;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeManager;
import net.minecraft.world.level.biome.BiomeSource;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.LegacyRandomSource;
import net.minecraft.world.level.levelgen.RandomState;
import net.minecraft.world.level.levelgen.RandomSupport;
import net.minecraft.world.level.levelgen.WorldgenRandom;
import net.minecraft.world.level.levelgen.blending.Blender;
import net.minecraft.world.level.levelgen.densityfunction.SamplerContext;
import net.minecraft.world.level.levelgen.synth.SimplexNoise;
import org.jspecify.annotations.Nullable;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

/**
 * Chikyū's land: one fixed map (the same in every world, whatever the seed). The Hidden Leaf stands on flat ground round
 * the world's centre; past it the land rises into wooded hills. The village's own blocks are laid chunk by chunk from
 * {@link LeafVillage} as each chunk is decorated, so it is built exactly where and when the player first sees it.
 */
public class ChikyuChunkGenerator extends ChunkGenerator {
	public static final MapCodec<ChikyuChunkGenerator> CODEC = RecordCodecBuilder.mapCodec(
			i -> i.group(BiomeSource.CODEC.fieldOf("biome_source").forGetter(g -> g.biomeSource)).apply(i, i.stable(ChikyuChunkGenerator::new)));

	/** The top grass block of the flat ground; the village templates' ground layer lands on it. */
	public static final int SURFACE = 64;
	private static final int MIN_Y = -64, DEPTH = 384;
	private static final SimplexNoise HILLS = new SimplexNoise(new LegacyRandomSource(0x4E41525554_4FL));
	private static final SimplexNoise DETAIL = new SimplexNoise(new LegacyRandomSource(0x4B4F4E4F4841L));

	public static void register() {
		Registration.add(Registries.CHUNK_GENERATOR, "chikyu", () -> CODEC, null);
	}

	public ChikyuChunkGenerator(BiomeSource biomeSource) {
		super(biomeSource);
	}

	@Override
	protected MapCodec<? extends ChunkGenerator> codec() {
		return CODEC;
	}

	// ---------------------------------------------------------------- the shape of the land

	/** How far (x, z) lies outside the village's flat ground, in blocks; 0 inside it. */
	static double outside(double x, double z) {
		double circle = Math.max(0, Math.sqrt(x * x + z * z) - LeafVillage.FLAT_RADIUS);
		double dx = Math.max(Math.max(LeafVillage.FLAT_X1 - x, x - LeafVillage.FLAT_X2), 0);
		double dz = Math.max(Math.max(LeafVillage.FLAT_Z1 - z, z - LeafVillage.FLAT_Z2), 0);
		double river = Math.max(0, LeafVillage.riverDistance(x, z) - 14);
		return Math.min(Math.min(circle, Math.sqrt(dx * dx + dz * dz)), river);
	}

	/** The top solid block of the column at (x, z). */
	public static int height(int x, int z) {
		double d = outside(x, z);
		if (d <= 0)
			return SURFACE;
		double t = Mth.smoothstep((float) Math.min(1.0, d / 90.0));
		double hills = 12 + 20 * HILLS.get(x * 0.0045, z * 0.0045) + 6 * DETAIL.get(x * 0.02, z * 0.02);
		return SURFACE + (int) Math.round(t * Math.max(1.0, hills));
	}

	private static BlockState stateAt(int y, int top) {
		if (y == MIN_Y)
			return Blocks.BEDROCK.defaultBlockState();
		if (y == top)
			return Blocks.GRASS_BLOCK.defaultBlockState();
		if (y >= top - 3)
			return Blocks.DIRT.defaultBlockState();
		return y < 0 ? Blocks.DEEPSLATE.defaultBlockState() : Blocks.STONE.defaultBlockState();
	}

	@Override
	public CompletableFuture<ChunkAccess> buildTerrain(ChunkAccess chunk, Blender blender, RandomState randomState, StructureManager structureManager,
			BiomeManager biomeManager, @Nullable WorldGenRegion carverBiomeRegion, Set<Holder<Biome>> possibleBiomes) {
		BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos();
		Heightmap oceanFloor = chunk.getOrCreateHeightmapUnprimed(Heightmap.Types.OCEAN_FLOOR_WG);
		Heightmap worldSurface = chunk.getOrCreateHeightmapUnprimed(Heightmap.Types.WORLD_SURFACE_WG);
		ChunkPos cp = chunk.getPos();
		for (int x = 0; x < 16; x++)
			for (int z = 0; z < 16; z++) {
				int top = height(cp.getMinBlockX() + x, cp.getMinBlockZ() + z);
				for (int y = MIN_Y; y <= top; y++) {
					BlockState state = stateAt(y, top);
					chunk.setBlockState(pos.set(x, y, z), state);
					oceanFloor.update(x, y, z, state);
					worldSurface.update(x, y, z, state);
				}
			}
		return CompletableFuture.completedFuture(chunk);
	}

	@Override
	public int getBaseHeight(int x, int z, Heightmap.Types type, LevelHeightAccessor heightAccessor, RandomState randomState) {
		return height(x, z) + 1;
	}

	@Override
	public NoiseColumn getBaseColumn(int x, int z, LevelHeightAccessor heightAccessor, RandomState randomState) {
		int top = height(x, z);
		BlockState[] states = new BlockState[DEPTH];
		for (int i = 0; i < DEPTH; i++)
			states[i] = MIN_Y + i <= top ? stateAt(MIN_Y + i, top) : Blocks.AIR.defaultBlockState();
		return new NoiseColumn(MIN_Y, states);
	}

	// ---------------------------------------------------------------- the village, the woods, the animals

	/** True when the chunk touches the village's flat ground (or the edge of it), where the woods must not grow. */
	private static boolean villageChunk(ChunkPos cp) {
		return outside(cp.getMiddleBlockX(), cp.getMiddleBlockZ()) < 24;
	}

	@Override
	public void applyBiomeDecoration(WorldGenLevel level, ChunkAccess chunk, StructureManager structureManager) {
		LeafVillage.placeChunk(level, chunk.getPos());
		if (!villageChunk(chunk.getPos()))
			super.applyBiomeDecoration(level, chunk, structureManager);
	}

	@Override
	public void spawnOriginalMobs(WorldGenRegion region) {
		ChunkPos center = region.getCenter();
		if (villageChunk(center))
			return;
		BlockPos sourcePos = center.getWorldPosition().atY(region.getMaxY());
		WorldgenRandom random = new WorldgenRandom(new LegacyRandomSource(RandomSupport.generateUniqueSeed()));
		random.setDecorationSeed(region.getSeed(), center.getMinBlockX(), center.getMinBlockZ());
		NaturalSpawner.spawnMobsForChunkGeneration(region, sourcePos, center, random);
	}

	/** No monsters spawn on their own inside the village. */
	@Override
	public WeightedList<MobSpawnSettings.SpawnerData> getMobsAt(Level level, StructureManager structureManager, MobCategory mobCategory, BlockPos pos) {
		if (mobCategory == MobCategory.MONSTER && outside(pos.getX(), pos.getZ()) < 8)
			return WeightedList.of();
		return super.getMobsAt(level, structureManager, mobCategory, pos);
	}

	@Override
	public void addDebugScreenInfo(List<String> result, RandomState randomState, BlockPos feetPos, SamplerContext samplerContext) {
	}

	@Override
	public int getSpawnHeight(LevelHeightAccessor heightAccessor) {
		return SURFACE + 1;
	}

	@Override
	public int getMinY() {
		return MIN_Y;
	}

	@Override
	public int getGenDepth() {
		return DEPTH;
	}

	@Override
	public int getSeaLevel() {
		return 63;
	}
}
