package net.mcreator.narutoshippudenmod.world.chikyu;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mojang.logging.LogUtils;

import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.ints.IntArrayList;
import it.unimi.dsi.fastutil.longs.Long2ObjectOpenHashMap;

import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.DoubleTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.NbtAccounter;
import net.minecraft.nbt.NbtIo;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.resources.Identifier;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ProblemReporter;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntitySpawnRequest;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.level.storage.TagValueInput;
import net.minecraft.world.phys.Vec3;

import org.slf4j.Logger;

import java.io.InputStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The Hidden Leaf in Chikyū, built from {@code data/naruto_shippuden/village/leaf.json} (written by
 * porting/structures_gen/gen.py --village) and the {@code structure/leaf/*.nbt} templates it names.
 *
 * <p>The first time a Chikyū chunk is decorated, every template is read once and its blocks are sorted by the world
 * chunk they land in (rotated and moved to their place), the streets first and then the pieces in the file's order, as
 * the flat-world preview placed them. After that each chunk only sets its own share. The village's (0, 0) corner is at
 * world (OX, OZ), so the middle of its round wall is the world's centre.
 */
public final class LeafVillage {
	private static final Logger LOGGER = LogUtils.getLogger();
	public static final int OX = -200, OZ = -215;
	/** The world y of every template's bottom layer: their ground layer (template y 1) is the flat ground. */
	public static final int Y0 = ChikyuChunkGenerator.SURFACE - 1;
	/** Where a player arrives: on the street before the Academy yard's gate, looking at the Academy. */
	public static final Vec3 ARRIVAL = new Vec3(116.5 + OX, ChikyuChunkGenerator.SURFACE + 1, 168.5 + OZ);

	// the village's flat ground, in world coordinates: the round wall's circle with room round it, the mountains' box
	// to the north, and the river's valley through and out of it
	static final double FLAT_RADIUS = 250;
	static final double FLAT_X1 = -75 + OX, FLAT_X2 = 475 + OX, FLAT_Z1 = -75 + OZ, FLAT_Z2 = 232 + OZ;
	private static final int[][] RIVER = {{470, 120}, {395, 160}, {360, 215}, {345, 270}, {318, 318}, {270, 342}, {200, 350},
			{140, 345}, {100, 330}, {70, 322}, {40, 345}, {5, 380}, {-40, 420}};

	/** How far (x, z) in world coordinates is from the river's middle line. */
	static double riverDistance(double x, double z) {
		double best = Double.MAX_VALUE;
		for (int i = 0; i + 1 < RIVER.length; i++) {
			double ax = RIVER[i][0] + OX, az = RIVER[i][1] + OZ, bx = RIVER[i + 1][0] + OX, bz = RIVER[i + 1][1] + OZ;
			double dx = bx - ax, dz = bz - az;
			double t = Math.max(0, Math.min(1, ((x - ax) * dx + (z - az) * dz) / (dx * dx + dz * dz)));
			best = Math.min(best, Math.hypot(x - ax - t * dx, z - az - t * dz));
		}
		return best;
	}

	/** One world chunk's share of the village: blocks in placing order, packed x | z << 4 | (y - minY) << 8. */
	private static final class ChunkPlan {
		final IntArrayList packed = new IntArrayList();
		final List<BlockState> states = new ArrayList<>();
		final Int2ObjectOpenHashMap<CompoundTag> blockEntities = new Int2ObjectOpenHashMap<>();
		final List<EntityPlan> entities = new ArrayList<>();
	}

	private record EntityPlan(Vec3 pos, BlockPos blockPos, CompoundTag nbt, Rotation rotation) {
	}

	private static final int MIN_Y = -64;
	private static volatile Long2ObjectOpenHashMap<ChunkPlan> plans;

	private LeafVillage() {
	}

	/** Sets the village's blocks and entities that fall in this chunk. */
	public static void placeChunk(WorldGenLevel level, ChunkPos cp) {
		ChunkPlan plan = plans(level.getLevel().getServer()).get(cp.pack());
		if (plan == null)
			return;
		BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos();
		int bx = cp.getMinBlockX(), bz = cp.getMinBlockZ();
		for (int i = 0; i < plan.packed.size(); i++) {
			int p = plan.packed.getInt(i);
			pos.set(bx + (p & 15), (p >> 8) + MIN_Y, bz + (p >> 4 & 15));
			BlockState state = plan.states.get(i);
			CompoundTag nbt = plan.blockEntities.get(i);
			if (nbt != null)
				level.setBlock(pos, Blocks.BARRIER.defaultBlockState(), 820);
			level.setBlock(pos, state, Block.UPDATE_CLIENTS);
			if (nbt != null) {
				BlockEntity be = level.getBlockEntity(pos);
				if (be != null)
					be.loadWithComponents(TagValueInput.create(ProblemReporter.DISCARDING, level.registryAccess(), nbt));
			}
		}
		for (EntityPlan e : plan.entities) {
			CompoundTag tag = e.nbt().copy();
			ListTag posTag = new ListTag();
			posTag.add(DoubleTag.valueOf(e.pos().x));
			posTag.add(DoubleTag.valueOf(e.pos().y));
			posTag.add(DoubleTag.valueOf(e.pos().z));
			tag.put("Pos", posTag);
			tag.remove("UUID");
			if (tag.contains("block_pos"))
				tag.store("block_pos", BlockPos.CODEC, e.blockPos());
			try {
				EntityType.create(TagValueInput.create(ProblemReporter.DISCARDING, level.registryAccess(), tag), level.getLevel(),
						new EntitySpawnRequest(EntitySpawnReason.STRUCTURE, false)).ifPresent(entity -> {
							float yRot = entity.rotate(e.rotation());
							entity.snapTo(e.pos().x, e.pos().y, e.pos().z, yRot, entity.getXRot());
							entity.setYBodyRot(yRot);
							entity.setYHeadRot(yRot);
							level.addFreshEntityWithPassengers(entity);
						});
			} catch (Exception ex) {
				LOGGER.warn("Leaf village: could not place entity {}", tag, ex);
			}
		}
	}

	private static Long2ObjectOpenHashMap<ChunkPlan> plans(MinecraftServer server) {
		Long2ObjectOpenHashMap<ChunkPlan> p = plans;
		if (p == null) {
			synchronized (LeafVillage.class) {
				p = plans;
				if (p == null)
					plans = p = load(server);
			}
		}
		return p;
	}

	/** Forgets the sorted village, so a changed data pack is read again (the server calls this when it stops). */
	public static void forget() {
		plans = null;
	}

	private static ChunkPlan at(Long2ObjectOpenHashMap<ChunkPlan> map, int x, int z) {
		return map.computeIfAbsent(ChunkPos.pack(x >> 4, z >> 4), k -> new ChunkPlan());
	}

	private static void add(Long2ObjectOpenHashMap<ChunkPlan> map, int x, int y, int z, BlockState state, CompoundTag nbt) {
		ChunkPlan plan = at(map, x, z);
		if (nbt != null)
			plan.blockEntities.put(plan.packed.size(), nbt);
		plan.packed.add((x & 15) | (z & 15) << 4 | (y - MIN_Y) << 8);
		plan.states.add(state);
	}

	private static Long2ObjectOpenHashMap<ChunkPlan> load(MinecraftServer server) {
		long start = System.currentTimeMillis();
		Long2ObjectOpenHashMap<ChunkPlan> map = new Long2ObjectOpenHashMap<>();
		HolderGetter<Block> blocks = server.registryAccess().lookupOrThrow(Registries.BLOCK);
		JsonObject layout;
		try (Reader reader = server.getResourceManager().openAsReader(Identifier.fromNamespaceAndPath("naruto_shippuden", "village/leaf.json"))) {
			layout = JsonParser.parseReader(reader).getAsJsonObject();
		} catch (Exception e) {
			LOGGER.error("Leaf village: cannot read village/leaf.json", e);
			return map;
		}
		// the streets: earth paths on the flat ground, under everything else
		BlockState path = Blocks.DIRT_PATH.defaultBlockState();
		for (JsonElement r : layout.getAsJsonArray("roads")) {
			var a = r.getAsJsonArray();
			for (int x = a.get(0).getAsInt(); x <= a.get(2).getAsInt(); x++)
				for (int z = a.get(1).getAsInt(); z <= a.get(3).getAsInt(); z++)
					add(map, x + OX, ChikyuChunkGenerator.SURFACE, z + OZ, path, null);
		}
		Map<String, CompoundTag> templates = new HashMap<>();
		int count = 0;
		for (JsonElement el : layout.getAsJsonArray("pieces")) {
			JsonObject piece = el.getAsJsonObject();
			String name = piece.get("piece").getAsString();
			CompoundTag tpl = templates.computeIfAbsent(name, n -> {
				try (InputStream in = server.getResourceManager().open(Identifier.fromNamespaceAndPath("naruto_shippuden", "structure/" + n + ".nbt"))) {
					return NbtIo.readCompressed(in, NbtAccounter.unlimitedHeap());
				} catch (Exception e) {
					LOGGER.error("Leaf village: cannot read template {}", n, e);
					return null;
				}
			});
			if (tpl == null)
				continue;
			Rotation rotation = switch (piece.get("rotation").getAsString()) {
				case "clockwise_90" -> Rotation.CLOCKWISE_90;
				case "counterclockwise_90" -> Rotation.COUNTERCLOCKWISE_90;
				case "180" -> Rotation.CLOCKWISE_180;
				default -> Rotation.NONE;
			};
			BlockPos origin = new BlockPos(piece.get("x").getAsInt() + OX, Y0, piece.get("z").getAsInt() + OZ);
			ListTag paletteTag = tpl.getListOrEmpty("palette");
			BlockState[] palette = new BlockState[paletteTag.size()];
			for (int i = 0; i < palette.length; i++)
				palette[i] = NbtUtils.readBlockState(blocks, paletteTag.getCompoundOrEmpty(i)).rotate(rotation);
			ListTag blockList = tpl.getListOrEmpty("blocks");
			for (int i = 0; i < blockList.size(); i++) {
				CompoundTag b = blockList.getCompoundOrEmpty(i);
				ListTag p = b.getListOrEmpty("pos");
				BlockState state = palette[b.getIntOr("state", 0)];
				if (state.is(Blocks.STRUCTURE_VOID))
					continue;
				BlockPos w = StructureTemplate.transform(new BlockPos(p.getIntOr(0, 0), p.getIntOr(1, 0), p.getIntOr(2, 0)), Mirror.NONE, rotation, BlockPos.ZERO)
						.offset(origin);
				add(map, w.getX(), w.getY(), w.getZ(), state, b.getCompound("nbt").orElse(null));
				count++;
			}
			for (CompoundTag e : tpl.getListOrEmpty("entities").compoundStream().toList()) {
				ListTag p = e.getListOrEmpty("pos");
				ListTag bp = e.getListOrEmpty("blockPos");
				Vec3 pos = StructureTemplate.transform(new Vec3(p.getDoubleOr(0, 0), p.getDoubleOr(1, 0), p.getDoubleOr(2, 0)), Mirror.NONE, rotation, BlockPos.ZERO)
						.add(origin.getX(), origin.getY(), origin.getZ());
				BlockPos blockPos = StructureTemplate.transform(new BlockPos(bp.getIntOr(0, 0), bp.getIntOr(1, 0), bp.getIntOr(2, 0)), Mirror.NONE, rotation, BlockPos.ZERO)
						.offset(origin);
				e.getCompound("nbt").ifPresent(nbt -> at(map, blockPos.getX(), blockPos.getZ()).entities.add(new EntityPlan(pos, blockPos, nbt, rotation)));
			}
		}
		LOGGER.info("Leaf village: {} blocks in {} chunks, sorted in {} ms", count, map.size(), System.currentTimeMillis() - start);
		return map;
	}
}
