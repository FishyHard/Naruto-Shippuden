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
		double river = Math.max(0, LeafVillage.riverDistance(x, z) - 14);
		return Math.min(circle, river);
	}

	// ---------------------------------------------------------------- the mountains round the north
	// As porting/structures_gen/leaf_ring.mountain(), the same heights block for block, but without its fade at the
	// template's edges: the range runs on into the wild land, wraps a little round the outside of the wall, and sinks
	// into the hills far from the village. Village coordinates (x east, z south from its north-west corner) inside.
	private static final double CX = 200, CZ = 215, R = 185, MOUNTAIN_FROM = R - 12, RIDGE_Z = 60, HMAX = 84;
	private static final int FACES_X1 = 113 + 16, FACES_X2 = 113 + 159, ROCK_Z0 = 8;

	/** build.py's _hash, bit for bit (Python's big ints agree with a long's low bits, all it keeps). */
	static double hash(long x, long y, long z, long salt) {
		long h = (x * 73856093L) ^ (y * 19349663L) ^ (z * 83492791L) ^ (salt * 2654435761L);
		h = (h ^ (h >> 13)) * 1274126177L;
		return ((h ^ (h >> 16)) & 0xffffffffL) / (double) 0xffffffffL;
	}

	/** How high the mountains stand over the flat ground at world (wx, wz), and how deep in them it is (d, for the grass). */
	private static double[] mountain(int wx, int wz) {
		int x = wx - LeafVillage.OX, z = wz - LeafVillage.OZ;
		if (x >= FACES_X1 && x <= FACES_X2 && z >= ROCK_Z0 && z < 120)
			return null;                                    // the Hokage Rock's own template stands there
		double bank = LeafVillage.riverDistance(wx + 0.5, wz + 0.5) - LeafVillage.RIVER_W;
		if (bank <= 2)
			return null;                                    // the river and its banks
		double px = x + 0.5 - CX, pz = z + 0.5 - CZ;
		double r = Math.sqrt(px * px + pz * pz);
		double ang = Math.toDegrees(Math.atan2(pz, px));
		ang = ang < 0 ? ang + 360 : ang;
		boolean north = ang >= 186 && ang <= 354;
		double w = 1;
		if (!north) {
			// outside the wall the range wraps a little south round it, sinking as it goes
			double off = ang < 186 && ang > 90 ? 186 - ang : ang > 354 ? ang - 354 : ang + 6;
			w = Math.max(0, 1 - off / 25) * Mth.clamp((r - (R + 8)) / 30, 0, 1);
			if (w <= 0 && z >= RIDGE_Z)
				return null;
		}
		double d = Math.max(w > 0 ? r - MOUNTAIN_FROM : -99, RIDGE_Z - z);
		if (d <= 0)
			return null;
		double n = (hash(Math.floorDiv(x, 4), 0, Math.floorDiv(z, 4), 112) - 0.5) * 6 + (hash(Math.floorDiv(x, 9), 1, Math.floorDiv(z, 9), 113) - 0.5) * 12;
		double h = Math.min(HMAX - 6.0, d * 3.0) + n * Math.min(1.0, d / 6);
		h *= north || z < RIDGE_Z ? 1 : w;
		h *= Mth.clamp((650 - r) / 230, 0, 1);              // far from the village it sinks into the hills
		h = Math.min(h, (bank - 2) * 2.2);                 // and slopes down to the river's valley
		return h < 1 ? null : new double[]{(int) h, d};
	}

	private static final BlockState[] ROCK = {Blocks.SANDSTONE.defaultBlockState(), Blocks.SANDSTONE.defaultBlockState(), Blocks.SANDSTONE.defaultBlockState(),
			Blocks.SANDSTONE.defaultBlockState(), Blocks.SMOOTH_SANDSTONE.defaultBlockState(), Blocks.SMOOTH_SANDSTONE.defaultBlockState(),
			Blocks.TERRACOTTA.defaultBlockState(), Blocks.GRANITE.defaultBlockState()};

	private static BlockState rock(int x, int y, int z) {
		return ROCK[Math.min(7, (int) (hash(x, y, z, 111) * 8))];
	}

	/** The top solid block of the column at (x, z), with or without mountains. */
	public static int height(int x, int z) {
		double[] m = mountain(x, z);
		return Math.max(hillHeight(x, z), m == null ? SURFACE : SURFACE + (int) m[0]);
	}

	private static int hillHeight(int x, int z) {
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
				int wx = cp.getMinBlockX() + x, wz = cp.getMinBlockZ() + z;
				double[] m = mountain(wx, wz);
				int hills = hillHeight(wx, wz);
				int top = Math.max(hills, m == null ? SURFACE : SURFACE + (int) m[0]);
				boolean rocky = m != null && SURFACE + (int) m[0] > hills;
				// the river: two deep (three in its middle) over a gravel bed, level with the flat ground
				double river = LeafVillage.riverDistance(wx + 0.5, wz + 0.5);
				boolean water = top == SURFACE && river <= LeafVillage.RIVER_W;
				int bed = river < LeafVillage.RIVER_W - 1.5 ? SURFACE - 3 : SURFACE - 2;
				for (int y = MIN_Y; y <= top; y++) {
					BlockState state = rocky && y >= SURFACE ? (y == top && m[1] > 9 ? Blocks.GRASS_BLOCK.defaultBlockState() : rock(wx, y, wz))
							: !water || y < bed ? stateAt(y, top)
							: y == bed ? Blocks.GRAVEL.defaultBlockState() : Blocks.WATER.defaultBlockState();
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
		ChunkPos cp = chunk.getPos();
		if (!villageChunk(cp) || allMountain(cp))
			super.applyBiomeDecoration(level, chunk, structureManager);
	}

	/** True when the chunk is mountain all over (its corners and middle), so its woods cannot reach the village. */
	private static boolean allMountain(ChunkPos cp) {
		for (int[] o : new int[][]{{0, 0}, {15, 0}, {0, 15}, {15, 15}, {8, 8}})
			if (height(cp.getMinBlockX() + o[0], cp.getMinBlockZ() + o[1]) < SURFACE + 8)
				return false;
		return true;
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
