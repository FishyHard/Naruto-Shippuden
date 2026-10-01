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
import net.minecraft.world.level.chunk.LevelChunkSection;
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
		return outside(x, z, LeafVillage.riverDistance(x, z));
	}

	private static double outside(double x, double z, double river) {
		double circle = Math.max(0, Math.sqrt(x * x + z * z) - LeafVillage.FLAT_RADIUS);
		return Math.min(circle, Math.max(0, river - 14));
	}

	/** How far (x, z) is from the middle of the round wall's circle: the village proper is within FLAT_RADIUS. */
	static double fromCentre(double x, double z) {
		return Math.sqrt(x * x + z * z);
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
	private static double[] mountain(int wx, int wz, double river) {
		int x = wx - LeafVillage.OX, z = wz - LeafVillage.OZ;
		if (x >= FACES_X1 && x <= FACES_X2 && z >= ROCK_Z0 && z < 120)
			return null;                                    // the Hokage Rock's own template stands there
		double bank = river - LeafVillage.RIVER_W;
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

	/** One column of land: its top, whether that is mountain rock, whether its top is grass, and the river in it. */
	private record Column(int top, boolean rocky, boolean grassTop, boolean water, int bed, double outside) {
	}

	private static Column column(int wx, int wz) {
		double river = LeafVillage.riverDistance(wx + 0.5, wz + 0.5);
		double out = outside(wx, wz, river);
		double[] m = mountain(wx, wz, river);
		int hills = hillHeight(wx, wz, out);
		int top = Math.max(hills, m == null ? SURFACE : SURFACE + (int) m[0]);
		boolean rocky = m != null && SURFACE + (int) m[0] > hills;
		// the river: two deep (three in its middle) over a gravel bed, level with the flat ground
		boolean water = top == SURFACE && river <= LeafVillage.RIVER_W;
		int bed = river < LeafVillage.RIVER_W - 1.5 ? SURFACE - 3 : SURFACE - 2;
		return new Column(top, rocky, !rocky || m[1] > 9, water, bed, out);
	}

	/** The top solid block of the column at (x, z), with or without mountains. */
	public static int height(int x, int z) {
		return column(x, z).top();
	}

	private static int hillHeight(int x, int z, double out) {
		if (out <= 0)
			return SURFACE;
		double t = Mth.smoothstep((float) Math.min(1.0, out / 90.0));
		double hills = 12 + 20 * HILLS.get(x * 0.0045, z * 0.0045) + 6 * DETAIL.get(x * 0.02, z * 0.02);
		return SURFACE + (int) Math.round(t * Math.max(1.0, hills));
	}

	private static final BlockState BEDROCK = Blocks.BEDROCK.defaultBlockState(), GRASS = Blocks.GRASS_BLOCK.defaultBlockState(),
			DIRT = Blocks.DIRT.defaultBlockState(), STONE = Blocks.STONE.defaultBlockState(), DEEPSLATE = Blocks.DEEPSLATE.defaultBlockState(),
			GRAVEL = Blocks.GRAVEL.defaultBlockState(), WATER = Blocks.WATER.defaultBlockState(), LAVA = Blocks.LAVA.defaultBlockState(),
			AIR = Blocks.AIR.defaultBlockState();

	private static BlockState stateAt(int y, int top) {
		if (y == MIN_Y)
			return BEDROCK;
		if (y == top)
			return GRASS;
		if (y >= top - 3)
			return DIRT;
		return y < 0 ? DEEPSLATE : STONE;
	}

	private static BlockState stateAt(Column c, int wx, int y, int wz) {
		if (c.rocky() && y >= SURFACE)
			return y == c.top() && c.grassTop() ? GRASS : rock(wx, y, wz);
		if (c.water() && y >= c.bed())
			return y == c.bed() ? GRAVEL : WATER;
		return stateAt(y, c.top());
	}

	// ---------------------------------------------------------------- caves, in the wild land only
	// Noodle tunnels where two noises are both near zero, and wider caverns deep down; sampled on a 4-block lattice and
	// blended between, as vanilla does, so a chunk costs a few thousand noise samples, not a hundred thousand.
	private static final SimplexNoise CAVE_A = new SimplexNoise(new LegacyRandomSource(0x43415645_41L));
	private static final SimplexNoise CAVE_B = new SimplexNoise(new LegacyRandomSource(0x43415645_42L));
	private static final SimplexNoise CAVERN = new SimplexNoise(new LegacyRandomSource(0x43415645_43L));
	private static final int CELL = 4, LAVA_LEVEL = -55;

	/** Cave density over the chunk's lattice: below zero is open. */
	private static float[][][] caveLattice(ChunkPos cp) {
		int ny = DEPTH / CELL + 1;
		float[][][] d = new float[5][5][ny];
		for (int i = 0; i < 5; i++)
			for (int k = 0; k < 5; k++) {
				double x = cp.getMinBlockX() + i * CELL, z = cp.getMinBlockZ() + k * CELL;
				for (int j = 0; j < ny; j++) {
					double y = MIN_Y + j * CELL;
					double a = CAVE_A.get(x * 0.018, y * 0.03, z * 0.018), b = CAVE_B.get(x * 0.018, y * 0.03, z * 0.018);
					double noodle = a * a + b * b - 0.012;
					double cavern = y < 20 ? 0.55 - CAVERN.get(x * 0.011, y * 0.022, z * 0.011) : 1;
					d[i][k][j] = (float) Math.min(noodle * 8, cavern);
				}
			}
		return d;
	}

	private static float caveAt(float[][][] d, int x, int y, int z) {
		int i = x / CELL, k = z / CELL, j = (y - MIN_Y) / CELL;
		float fx = (x % CELL) / (float) CELL, fz = (z % CELL) / (float) CELL, fy = ((y - MIN_Y) % CELL) / (float) CELL;
		return Mth.lerp3(fx, fy, fz, d[i][k][j], d[i + 1][k][j], d[i][k][j + 1], d[i + 1][k][j + 1],
				d[i][k + 1][j], d[i + 1][k + 1][j], d[i][k + 1][j + 1], d[i + 1][k + 1][j + 1]);
	}

	@Override
	public CompletableFuture<ChunkAccess> buildTerrain(ChunkAccess chunk, Blender blender, RandomState randomState, StructureManager structureManager,
			BiomeManager biomeManager, @Nullable WorldGenRegion carverBiomeRegion, Set<Holder<Biome>> possibleBiomes) {
		Heightmap oceanFloor = chunk.getOrCreateHeightmapUnprimed(Heightmap.Types.OCEAN_FLOOR_WG);
		Heightmap worldSurface = chunk.getOrCreateHeightmapUnprimed(Heightmap.Types.WORLD_SURFACE_WG);
		ChunkPos cp = chunk.getPos();
		// caves only well away from the village and its river valley, so they never open under a street or a house
		boolean caves = fromCentre(cp.getMiddleBlockX(), cp.getMiddleBlockZ()) > LeafVillage.FLAT_RADIUS + 64;
		float[][][] lattice = caves ? caveLattice(cp) : null;
		LevelChunkSection[] sections = chunk.getSections();
		for (LevelChunkSection section : sections)
			section.acquire();
		try {
			for (int x = 0; x < 16; x++)
				for (int z = 0; z < 16; z++) {
					int wx = cp.getMinBlockX() + x, wz = cp.getMinBlockZ() + z;
					Column c = column(wx, wz);
					int caveTop = c.water() ? c.bed() - 8 : c.top() - 8;
					for (int y = MIN_Y; y <= c.top(); y++) {
						BlockState state = stateAt(c, wx, y, wz);
						if (lattice != null && y > MIN_Y + 4 && y < caveTop && caveAt(lattice, x, y, z) < 0)
							state = y <= LAVA_LEVEL ? LAVA : AIR;
						if (state != AIR)
							sections[chunk.getSectionIndex(y)].setBlockState(x, y & 15, z, state, false);
					}
					BlockState top = stateAt(c, wx, c.top(), wz);
					worldSurface.update(x, c.top(), z, top);
					oceanFloor.update(x, c.water() ? c.bed() : c.top(), z, c.water() ? GRAVEL : top);
				}
		} finally {
			for (LevelChunkSection section : sections)
				section.release();
		}
		return CompletableFuture.completedFuture(chunk);
	}

	@Override
	public int getBaseHeight(int x, int z, Heightmap.Types type, LevelHeightAccessor heightAccessor, RandomState randomState) {
		return height(x, z) + 1;
	}

	@Override
	public NoiseColumn getBaseColumn(int x, int z, LevelHeightAccessor heightAccessor, RandomState randomState) {
		Column c = column(x, z);
		BlockState[] states = new BlockState[DEPTH];
		for (int i = 0; i < DEPTH; i++)
			states[i] = MIN_Y + i <= c.top() ? stateAt(c, x, MIN_Y + i, z) : AIR;
		return new NoiseColumn(MIN_Y, states);
	}

	// ---------------------------------------------------------------- the village, the woods, the animals

	/** True when the chunk touches the village or the flat ring round its wall, where the woods must not grow. */
	private static boolean villageChunk(ChunkPos cp) {
		return fromCentre(cp.getMiddleBlockX(), cp.getMiddleBlockZ()) < LeafVillage.FLAT_RADIUS + 24;
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
		if (mobCategory == MobCategory.MONSTER && fromCentre(pos.getX(), pos.getZ()) < LeafVillage.FLAT_RADIUS - 50)
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
