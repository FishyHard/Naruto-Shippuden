package net.mcreator.narutoshippudenmod.story;

import net.mcreator.narutoshippudenmod.compat.Compat;
import net.mcreator.narutoshippudenmod.world.chikyu.Chikyu;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.logging.LogUtils;

import net.minecraft.ChatFormatting;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.commands.SharedSuggestionProvider;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.StringTag;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.Identifier;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.SimplePreparableReloadListener;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.profiling.ProfilerFiller;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.AddServerReloadListenersEvent;
import net.neoforged.neoforge.event.RegisterCommandsEvent;
import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.neoforge.event.tick.ServerTickEvent;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.handling.IPayloadContext;

import org.slf4j.Logger;

import java.io.Reader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * The story's quest engine. Quests and characters are data:
 * <pre>
 * data/&lt;ns&gt;/story/characters/&lt;id&gt;.json  {"name", "skin", "model": "legacy"|"player"|"slim", "home": [x, y, z], "yaw", "idle": [lines],
 *                                          "after": quest id (the character is there only for players who have done it),
 *                                          "until": quest id (and gone once they have done that one),
 *                                          "equipment": {"head": item id, "mainhand": item id, ...} (the headband is worn, not painted),
 *                                          "graduate": {equipment}, "graduate_skin": texture, "graduate_after": quest id (what it
 *                                          wears, and looks like, once that is done: Naruto's goggles give way to the headband),
 *                                          "eyes": texture (a dojutsu over its face)}
 * data/&lt;ns&gt;/story/quests/&lt;id&gt;.json      {"title", "chapter", "after": [quest ids], "start": "auto" | character id,
 *                                          "offer": [lines], "steps": [steps], "rewards": {"items": [{"id", "count"}], "xp" (shinobi XP), "vanilla_xp", "commands",
 *                                          "time" (the time of day it moves on to)}}
 * </pre>
 * A quest starts by itself ("auto") or when its character is talked to, once every quest in "after" is done. A filler
 * ("fillers/..." quests, side stories) is only offered while no main-story quest is going: till then its character says its
 * "later" line (or a general "come back later"). Steps, done one
 * after another, each with an optional "text" (the tracker's objective), "on_start" (commands run as the player) and "time"
 * ("morning", "day", "evening", "night": the time of day the step happens at; time moves on to it):
 * <pre>
 * {"type": "talk", "npc": id, "dialogue": [lines]}            talk to that character
 * {"type": "goto", "pos": [x, y, z], "radius": r, "min_y": y} go there (in Chikyū, or "dimension"); min_y: and be at least
 *                                                              that high (standing on water, up a wall)
 * {"type": "kill", "entity": id, "count": n}                   defeat n of them
 * {"type": "hit", "entity": id, "count": n}                    land n hits on them (training dummies, sparring)
 * {"type": "collect", "item": id, "count": n, "take": bool}   have n in the inventory (taken when "take")
 * {"type": "wait", "seconds": s}                               let time pass
 * {"type": "spar", "npc": id, "hits": n, "damage": d,         spar with that character until landing n hits; it fights back
 *  "rank": 0-2, "throws": bool, "substitution": bool}          (rank: how fast and hard; throws kunai; dodges by Substitution)
 * {"type": "event", "event": name}                            something code reports with {@link #event}
 * </pre>
 * Any step may also bring "spawn": [{"character", "pos", "yaw", "steps", "pose"}]: scene characters for this player only, standing
 * (or sitting: "pose": "sit", the feet half a block under the seat) there from this step for "steps" steps (1 by default), then gone; and "effects": [{"type": "clones", "character", "around",
 * "count", "seconds"} | {"type": "pose", "character", "pose": "crouch"|"lie"|"sit"|"stand"} | {"type": "smoke", "character"} |
 * {"type": "walk", "character", "points": [[x, z], ...], "speed", "loop", "slip"}], played on the player's scene characters as
 * the step starts ("walk": along the ground, up walls and over water, as a teammate showing a lesson; "delay" in ticks).
 * A sparring partner waits until the player comes within a few blocks, and stops when they go off. A choice may carry "commands" (run as the player when it is chosen).
 * A dialogue line is {"speaker": character id | "player", "text", "choices": [{"text", "flag", "lines": [lines]}]}: the
 * dialogue screen shows them in turn, a choice shows its own lines next and sets its flag on the player.
 *
 * <p>A player's progress lives in their persistent data under {@value #KEY} (it survives death): "done" quests, the
 * "active" ones with their step and count, the "flags" set by choices, and the "focus" quest the tracker shows.
 */
@EventBusSubscriber(modid = "naruto_shippuden")
public final class Story {
	private static final Logger LOGGER = LogUtils.getLogger();
	public static final String KEY = "naruto_shippuden:story";

	/**
	 * A story character: "after" and "until" are the quests between which its usual figure is there for a player (Mizuki is
	 * gone once he has shown what he is), "graduate" what it wears for players who have done the "graduate_after" quest (the
	 * headband, once the class has passed), "eyes" a dojutsu drawn over its face (the mod's own eye textures).
	 */
	public record Character(String id, String name, Identifier skin, String model, BlockPos home, float yaw, List<String> idle, String after,
			Map<String, String> equipment, String until, Map<String, String> graduate, String graduateAfter, String eyes, String graduateSkin, String pose) {
	}

	public record Quest(String id, String title, int chapter, List<String> after, String start, JsonArray offer, List<JsonObject> steps,
			JsonObject rewards, String later) {
	}

	private static volatile Map<String, Character> characters = Map.of();
	private static volatile Map<String, Quest> quests = Map.of();

	private Story() {
	}

	public static Map<String, Character> characters() {
		return characters;
	}

	public static Map<String, Quest> quests() {
		return quests;
	}

	// ---------------------------------------------------------------- loading the data

	@SubscribeEvent
	public static void addReloadListener(AddServerReloadListenersEvent event) {
		event.addListener(Identifier.fromNamespaceAndPath("naruto_shippuden", "story"), new Loader());
	}

	private static final class Loader extends SimplePreparableReloadListener<Object[]> {
		@Override
		protected Object[] prepare(ResourceManager manager, ProfilerFiller profiler) {
			Map<String, Character> chars = new TreeMap<>();
			for (var e : read(manager, "story/characters").entrySet()) {
				JsonObject o = e.getValue();
				JsonArray home = o.has("home") ? o.getAsJsonArray("home") : null;
				List<String> idle = new ArrayList<>();
				if (o.has("idle"))
					o.getAsJsonArray("idle").forEach(l -> idle.add(l.getAsString()));
				chars.put(e.getKey(), new Character(e.getKey(), str(o, "name", e.getKey()),
						Identifier.parse(str(o, "skin", "naruto_shippuden:textures/entities/iruka_sensei.png")), str(o, "model", "legacy"),
						home == null ? null : new BlockPos(home.get(0).getAsInt(), home.get(1).getAsInt(), home.get(2).getAsInt()),
						o.has("yaw") ? o.get("yaw").getAsFloat() : 0, idle, str(o, "after", ""), equipment(o, "equipment"), str(o, "until", ""),
						equipment(o, "graduate"), str(o, "graduate_after", ""), str(o, "eyes", ""), str(o, "graduate_skin", ""), str(o, "pose", "")));
			}
			Map<String, Quest> qs = new TreeMap<>();
			for (var e : read(manager, "story/quests").entrySet()) {
				JsonObject o = e.getValue();
				List<String> after = new ArrayList<>();
				if (o.has("after"))
					o.getAsJsonArray("after").forEach(a -> after.add(a.getAsString()));
				List<JsonObject> steps = new ArrayList<>();
				o.getAsJsonArray("steps").forEach(s -> steps.add(s.getAsJsonObject()));
				qs.put(e.getKey(), new Quest(e.getKey(), str(o, "title", e.getKey()), o.has("chapter") ? o.get("chapter").getAsInt() : 0, after,
						str(o, "start", "auto"), o.has("offer") ? o.getAsJsonArray("offer") : new JsonArray(), steps,
						o.has("rewards") ? o.getAsJsonObject("rewards") : new JsonObject(), str(o, "later", "")));
			}
			return new Object[]{chars, qs};
		}

		@SuppressWarnings("unchecked")
		@Override
		protected void apply(Object[] data, ResourceManager manager, ProfilerFiller profiler) {
			characters = (Map<String, Character>) data[0];
			quests = (Map<String, Quest>) data[1];
			LOGGER.info("Story: {} characters, {} quests", characters.size(), quests.size());
		}

		private static Map<String, JsonObject> read(ResourceManager manager, String dir) {
			Map<String, JsonObject> out = new LinkedHashMap<>();
			for (var e : manager.listResources(dir, id -> id.getPath().endsWith(".json")).entrySet()) {
				String path = e.getKey().getPath();
				String id = path.substring(dir.length() + 1, path.length() - 5);
				try (Reader reader = e.getValue().openAsReader()) {
					out.put(id, JsonParser.parseReader(reader).getAsJsonObject());
				} catch (Exception ex) {
					LOGGER.error("Story: cannot read {}", e.getKey(), ex);
				}
			}
			return out;
		}
	}

	/** "equipment": {"head": item id, "mainhand": item id, ...}: what the character wears and holds. */
	private static Map<String, String> equipment(JsonObject o, String key) {
		Map<String, String> out = new LinkedHashMap<>();
		if (o.has(key))
			for (var e : o.getAsJsonObject(key).entrySet())
				out.put(e.getKey(), e.getValue().getAsString());
		return out;
	}

	static String str(JsonObject o, String key, String fallback) {
		return o.has(key) ? o.get(key).getAsString() : fallback;
	}

	// ---------------------------------------------------------------- a player's progress

	static CompoundTag state(ServerPlayer player) {
		CompoundTag root = player.getPersistentData();
		CompoundTag state = root.getCompound(KEY).orElse(null);
		if (state == null) {
			state = new CompoundTag();
			root.put(KEY, state);
		}
		return state;
	}

	private static CompoundTag section(CompoundTag state, String name) {
		CompoundTag tag = state.getCompound(name).orElse(null);
		if (tag == null) {
			tag = new CompoundTag();
			state.put(name, tag);
		}
		return tag;
	}

	public static boolean isDone(ServerPlayer player, String quest) {
		return section(state(player), "done").contains(quest);
	}

	public static boolean isActive(ServerPlayer player, String quest) {
		return section(state(player), "active").contains(quest);
	}

	public static int flag(ServerPlayer player, String flag) {
		return section(state(player), "flags").getIntOr(flag, 0);
	}

	private static boolean startable(ServerPlayer player, Quest quest) {
		if (isDone(player, quest.id()) || isActive(player, quest.id()))
			return false;
		for (String a : quest.after())
			if (!isDone(player, a))
				return false;
		return true;
	}

	/** A filler (a side story, "fillers/...") waits while the player is in the middle of the main story. */
	public static boolean isFiller(Quest quest) {
		return quest.id().startsWith("fillers/");
	}

	/** Whether the player has a main-story quest going (a filler can't be started meanwhile). */
	private static boolean onMainQuest(ServerPlayer player) {
		for (String id : section(state(player), "active").keySet())
			if (!id.startsWith("fillers/"))
				return true;
		return false;
	}

	/** Startable, and not a filler held back by a main-story quest in progress. */
	private static boolean offerable(ServerPlayer player, Quest quest) {
		return startable(player, quest) && !(isFiller(quest) && onMainQuest(player));
	}

	/** The current step of an active quest, or null. */
	private static JsonObject step(ServerPlayer player, Quest quest) {
		CompoundTag active = section(state(player), "active").getCompound(quest.id()).orElse(null);
		if (active == null)
			return null;
		int i = active.getIntOr("step", 0);
		return i < quest.steps().size() ? quest.steps().get(i) : null;
	}

	private static CompoundTag progress(ServerPlayer player, Quest quest) {
		return section(section(state(player), "active"), quest.id());
	}

	/** The index of the quest's current step for the player, or -1 when it is not active. */
	public static int stepIndex(ServerPlayer player, String quest) {
		return section(state(player), "active").getCompound(quest).map(t -> t.getIntOr("step", 0)).orElse(-1);
	}

	/** A sparring partner took a hit: the tracker's count. */
	public static void sparProgress(ServerPlayer player, StoryNpc.Npc npc, int hits, int of) {
		for (Quest q : quests.values()) {
			JsonObject step = step(player, q);
			if (step != null && str(step, "type", "").equals("spar") && str(step, "npc", "").equals(npc.character())) {
				progress(player, q).putInt("count", hits);
				sync(player);
			}
		}
	}

	/** The player landed the last hit of a spar. */
	public static void sparWon(ServerPlayer player, StoryNpc.Npc npc) {
		for (Quest q : new ArrayList<>(quests.values())) {
			JsonObject step = step(player, q);
			if (step != null && str(step, "type", "").equals("spar") && str(step, "npc", "").equals(npc.character()))
				advance(player, q);
		}
	}

	/** The story character of that id nearest the player: their own scene character first, else anyone's. */
	private static StoryNpc.Npc findNpc(ServerPlayer player, String character, double range) {
		List<StoryNpc.Npc> near = player.level().getEntities(StoryNpc.entity, player.getBoundingBox().inflate(range), n -> n.character().equals(character));
		near.sort(java.util.Comparator.comparingDouble((StoryNpc.Npc n) -> n.isScene() && n.sceneFor(player.getUUID()) ? 0 : 1)
				.thenComparingDouble(n -> n.distanceToSqr(player)));
		return near.isEmpty() ? null : near.getFirst();
	}

	/** {"points": [[x, z], ...], "speed": blocks a tick, "loop", "slip": chance}: over the ground, up walls, on water. */
	private static void walk(StoryNpc.Npc npc, JsonObject o) {
		if (!o.has("points"))
			return;
		List<net.minecraft.world.phys.Vec3> points = new ArrayList<>();
		for (JsonElement pt : o.getAsJsonArray("points"))
			points.add(new net.minecraft.world.phys.Vec3(pt.getAsJsonArray().get(0).getAsDouble() + 0.5, 0, pt.getAsJsonArray().get(1).getAsDouble() + 0.5));
		npc.walk(points, o.has("speed") ? o.get("speed").getAsDouble() : 0.12, o.has("loop") && o.get("loop").getAsBoolean(),
				o.has("slip") ? o.get("slip").getAsFloat() : 0);
	}

	private static StoryNpc.Npc sceneNpc(ServerLevel level, ServerPlayer player, String character) {
		List<? extends StoryNpc.Npc> mine = level.getEntities(StoryNpc.entity, n -> n.isScene() && n.sceneFor(player.getUUID()) && n.character().equals(character));
		return mine.isEmpty() ? null : mine.getFirst();
	}

	/** Whether the player's quest is at a spar with this character now (a partner stops when it isn't: skipped, or done). */
	public static boolean sparringNow(ServerPlayer player, String character) {
		for (Quest q : quests.values()) {
			JsonObject step = step(player, q);
			if (step != null && str(step, "type", "").equals("spar") && str(step, "npc", "").equals(character))
				return true;
		}
		return false;
	}

	/** Places a step's scene characters for this player. */
	private static void spawnScene(ServerPlayer player, Quest quest, JsonObject step) {
		if (!step.has("spawn") || !(player.level() instanceof ServerLevel level))
			return;
		int at = stepIndex(player, quest.id());
		for (JsonElement e : step.getAsJsonArray("spawn")) {
			JsonObject o = e.getAsJsonObject();
			Character c = characters.get(str(o, "character", ""));
			if (c == null)
				continue;
			JsonArray pos = o.getAsJsonArray("pos");
			double x = pos.get(0).getAsDouble() + 0.5, y = pos.get(1).getAsDouble(), z = pos.get(2).getAsDouble() + 0.5;
			boolean there = !level.getEntities(StoryNpc.entity, new net.minecraft.world.phys.AABB(x - 8, y - 4, z - 8, x + 8, y + 4, z + 8),
					n -> n.isScene() && n.sceneFor(player.getUUID()) && n.character().equals(c.id())).isEmpty();
			if (there)
				continue;
			StoryNpc.Npc npc = StoryNpc.entity.create(level, EntitySpawnReason.EVENT);
			if (npc == null)
				continue;
			float yaw = o.has("yaw") ? o.get("yaw").getAsFloat() : 0;
			npc.applyCharacter(c, equipmentFor(player, c));
			npc.setSkin(skinFor(player, c));
			npc.setScene(player.getUUID(), quest.id(), at, at + (o.has("steps") ? o.get("steps").getAsInt() : 1));
			npc.snapTo(x, y, z, yaw, 0);
			npc.setYHeadRot(yaw);
			npc.setYBodyRot(yaw);
			if (o.has("pose"))
				npc.setStoryPose(str(o, "pose", "stand"));
			// its walk from the step's effects, given now: the place may be far off, in chunks not loaded yet
			if (step.has("effects"))
				for (JsonElement fx : step.getAsJsonArray("effects")) {
					JsonObject f = fx.getAsJsonObject();
					if (str(f, "type", "").equals("walk") && str(f, "character", "").equals(c.id()) && !f.has("delay"))
						walk(npc, f);
				}
			level.addFreshEntity(npc);
		}
	}

	/** A step's effects on the player's scene: clones rushing someone, a pose, a puff of smoke. */
	private static void effects(ServerPlayer player, Quest quest, JsonObject step) {
		if (!step.has("effects") || !(player.level() instanceof ServerLevel level))
			return;
		int at = stepIndex(player, quest.id());
		for (JsonElement e : step.getAsJsonArray("effects")) {
			JsonObject o = e.getAsJsonObject();
			int delay = o.has("delay") ? o.get("delay").getAsInt() : 0;
			if (delay > 0) {
				JsonObject now = o.deepCopy();
				now.remove("delay");
				JsonObject single = new JsonObject();
				JsonArray list = new JsonArray();
				list.add(now);
				single.add("effects", list);
				LATER.add(new Later(level.getServer().getTickCount() + delay, player.getUUID(), quest.id(), at, single));
				continue;
			}
			// the player's own scene figure wherever it stands (a lesson may start far from where it is shown), else the nearest
			StoryNpc.Npc who = sceneNpc(level, player, str(o, "character", ""));
			if (who == null)
				who = findNpc(player, str(o, "character", ""), 48);
			switch (str(o, "type", "")) {
				case "pose" -> {
					if (who != null)
						who.setStoryPose(str(o, "pose", "stand"));
				}
				case "smoke" -> {
					if (who != null)
						StoryNpc.Npc.puff(level, who);
				}
				case "walk" -> {
					// given to the scene figure as it was placed (spawnScene); here only for one placed earlier, or delayed
					if (who != null && who.isScene() && !who.walking())
						walk(who, o);
				}
				case "clones" -> {
					Character c = characters.get(str(o, "character", ""));
					StoryNpc.Npc target = findNpc(player, str(o, "around", ""), 48);
					if (c == null || target == null)
						break;
					int count = o.has("count") ? o.get("count").getAsInt() : 12, ticks = (o.has("seconds") ? o.get("seconds").getAsInt() : 8) * 20;
					for (int i = 0; i < count; i++) {
						StoryNpc.Npc clone = StoryNpc.entity.create(level, EntitySpawnReason.EVENT);
						if (clone == null)
							continue;
						double a = i * 2 * Math.PI / count, r = 5 + level.getRandom().nextDouble() * 4;
						double x = target.getX() + Math.cos(a) * r, z = target.getZ() + Math.sin(a) * r;
						int y = level.getHeight(net.minecraft.world.level.levelgen.Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) Math.floor(x), (int) Math.floor(z));
						clone.applyCharacter(c);
						clone.setScene(player.getUUID(), quest.id(), at, at + 1);
						clone.snapTo(x, y, z, 0, 0);
						clone.rush(target, ticks + level.getRandom().nextInt(30));
						level.addFreshEntity(clone);
						StoryNpc.Npc.puff(level, clone);
					}
					level.playSound(null, target.blockPosition(), SoundEvents.PUFFER_FISH_BLOW_OUT, SoundSource.NEUTRAL, 1.5F, 0.8F);
				}
				default -> {
				}
			}
		}
	}

	private record Later(long tick, java.util.UUID player, String quest, int step, JsonObject effects) {
	}

	/** Effects with a "delay" (in ticks), played then if the player is still on that step. */
	private static final List<Later> LATER = new java.util.concurrent.CopyOnWriteArrayList<>();

	private static void playLater(MinecraftServer server) {
		for (Later l : LATER) {
			if (l.tick() > server.getTickCount())
				continue;
			LATER.remove(l);
			ServerPlayer p = server.getPlayerList().getPlayer(l.player());
			Quest q = quests.get(l.quest());
			if (p != null && q != null && stepIndex(p, q.id()) == l.step())
				effects(p, q, l.effects());
		}
	}

	// ---------------------------------------------------------------- whose scene is where

	/** For each player, how many scene figures of each character they have (they don't see that character's usual figure). */
	private static final java.util.Map<java.util.UUID, java.util.Map<String, Integer>> SCENES = new java.util.concurrent.ConcurrentHashMap<>();

	/** Whether the player sees this character's usual figure: not while they have a scene figure of it, nor before its "after" quest. */
	public static boolean seesUsual(ServerPlayer player, String character) {
		if (hasScene(player.getUUID(), character))
			return false;
		Character c = characters.get(character);
		return c == null || (c.after().isEmpty() || isDone(player, c.after())) && (c.until().isEmpty() || !isDone(player, c.until()));
	}

	/** What the character wears for this player: its "graduate" outfit once they have done the quest it waits for. */
	public static Map<String, String> equipmentFor(ServerPlayer player, Character c) {
		return !c.graduate().isEmpty() && graduated(player, c) ? c.graduate() : c.equipment();
	}

	/** The character's skin for this player: its "graduate_skin" once they have done the quest it waits for. */
	public static String skinFor(ServerPlayer player, Character c) {
		return !c.graduateSkin().isEmpty() && graduated(player, c) ? c.graduateSkin() : c.skin().toString();
	}

	private static boolean graduated(ServerPlayer player, Character c) {
		return !c.graduateAfter().isEmpty() && isDone(player, c.graduateAfter());
	}

	// ---------------------------------------------------------------- what the player has learned

	/** Skills the story teaches (Chakra Control, then walls, water and the dash): the quest, and the step from which it is known. */
	private record Lesson(int bit, String quest, int step) {
	}

	private static final Map<String, Lesson> LESSONS = Map.of(
			"chakra_control", new Lesson(1, "chapter2/01_chakra_control", 0),
			"walls", new Lesson(2, "chapter2/01_chakra_control", 2),
			"water", new Lesson(4, "chapter2/02_water_walking", 0),
			"dash", new Lesson(8, "chapter2/03_body_flicker", 0));

	/** What the client was told it knows (the client moves the player on walls and water itself); everything until told. */
	public static volatile int clientSkills = -1;

	private static int skills(ServerPlayer player) {
		int bits = 0;
		for (Lesson l : LESSONS.values())
			if (!quests.containsKey(l.quest()) || isDone(player, l.quest()) || stepIndex(player, l.quest()) >= l.step())
				bits |= l.bit();
		return bits;
	}

	/** Whether the player has learned this skill in the story (creative players know everything). */
	public static boolean knows(net.minecraft.world.entity.player.Player player, String skill) {
		Lesson l = LESSONS.get(skill);
		if (l == null || player.isCreative())
			return true;
		int bits = player instanceof ServerPlayer sp ? skills(sp) : clientSkills;
		return (bits & l.bit()) != 0;
	}

	public static boolean hasScene(java.util.UUID player, String character) {
		java.util.Map<String, Integer> m = SCENES.get(player);
		return m != null && m.getOrDefault(character, 0) > 0;
	}

	public static void sceneAdded(ServerLevel level, java.util.UUID player, String character) {
		boolean was = hasScene(player, character);
		SCENES.computeIfAbsent(player, k -> new java.util.concurrent.ConcurrentHashMap<>()).merge(character, 1, Integer::sum);
		if (!was)
			retrack(level, character);
	}

	public static void sceneRemoved(ServerLevel level, java.util.UUID player, String character) {
		java.util.Map<String, Integer> m = SCENES.get(player);
		if (m == null)
			return;
		m.computeIfPresent(character, (k, v) -> v <= 1 ? null : v - 1);
		if (!hasScene(player, character))
			retrack(level, character);
	}

	/** Who sees the character's usual figure is decided when it starts being tracked: track it afresh so the change shows now. */
	private static void retrack(ServerLevel level, String character) {
		if (level.getServer() == null || !level.getServer().isSameThread())
			return;
		for (Entity e : level.getAllEntities())
			if (e instanceof StoryNpc.Npc npc && !npc.isScene() && npc.character().equals(character)) {
				level.getChunkSource().removeEntity(npc);
				level.getChunkSource().addEntity(npc);
			}
	}

	/** Forgets the player's story and starts it over; every figure is tracked afresh, so what they wear (the headbands
	 * the class have once passed) and who is there is as at the start for them now, not when they were last seen. */
	private static void reset(ServerPlayer player) {
		player.getPersistentData().remove(KEY);
		autoStart(player);
		sync(player);
		ServerLevel level = (ServerLevel) player.level();
		for (Entity e : level.getAllEntities())
			if (e instanceof StoryNpc.Npc npc && !npc.isScene()) {
				level.getChunkSource().removeEntity(npc);
				level.getChunkSource().addEntity(npc);
			}
	}

	/** The Chakra Paper was used (StuffItems, by the rule chakra_paper_story). */
	public static void chakraPaperUsed(Entity entity) {
		if (entity instanceof ServerPlayer player)
			event(player, "chakra_paper");
	}

	/** Starts a quest for the player (or restarts it), and its first step. */
	public static void start(ServerPlayer player, Quest quest) {
		CompoundTag p = new CompoundTag();
		p.putInt("step", 0);
		section(state(player), "active").put(quest.id(), p);
		section(state(player), "done").remove(quest.id());
		state(player).putString("focus", quest.id());
		announce(player, Component.literal("New quest").withStyle(ChatFormatting.YELLOW), quest.title(), SoundEvents.UI_TOAST_IN);
		beginStep(player, quest);
		sync(player);
	}

	private static void beginStep(ServerPlayer player, Quest quest) {
		JsonObject step = step(player, quest);
		if (step == null) {
			complete(player, quest);
			return;
		}
		if (step.has("on_start"))
			step.getAsJsonArray("on_start").forEach(c -> Compat.runCommand(player, c.getAsString()));
		if (step.has("time"))
			timeOfDay(player, str(step, "time", ""));
		spawnScene(player, quest, step);
		effects(player, quest, step);
		check(player, quest, step);
	}

	/**
	 * A step set at a time of day ("morning", "day", "evening", "night"): if it is not that time, time moves on to it (never
	 * back), as a story skips to the next scene.
	 */
	private static void timeOfDay(ServerPlayer player, String when) {
		int[] window = switch (when) {
			case "morning" -> new int[]{0, 3000, 500};
			case "day" -> new int[]{1000, 11000, 3000};
			case "evening" -> new int[]{11000, 13000, 11600};
			case "night" -> new int[]{13500, 22500, 16000};
			default -> null;
		};
		if (window == null)
			return;
		int now = (int) Math.floorMod(player.level().getDefaultClockTime(), 24000L);
		if (now >= window[0] && now < window[1])
			return;
		Compat.runCommand(player, "time add " + Math.floorMod(window[2] - now, 24000));
	}

	/** On to the quest's next step (or its end). */
	public static void advance(ServerPlayer player, Quest quest) {
		CompoundTag p = progress(player, quest);
		p.putInt("step", p.getIntOr("step", 0) + 1);
		p.putInt("count", 0);
		p.putInt("timer", 0);
		player.level().playSound(null, player.blockPosition(), SoundEvents.EXPERIENCE_ORB_PICKUP, SoundSource.PLAYERS, 0.5f, 1.2f);
		beginStep(player, quest);
		sync(player);
	}

	private static void complete(ServerPlayer player, Quest quest) {
		section(state(player), "active").remove(quest.id());
		section(state(player), "done").putBoolean(quest.id(), true);
		if (quest.id().equals(state(player).getStringOr("focus", "")))
			state(player).remove("focus");
		JsonObject r = quest.rewards();
		if (r.has("items"))
			for (JsonElement e : r.getAsJsonArray("items")) {
				JsonObject i = e.getAsJsonObject();
				Item item = BuiltInRegistries.ITEM.getValue(Identifier.parse(i.get("id").getAsString()));
				player.getInventory().placeItemBackInInventory(new ItemStack(item, i.has("count") ? i.get("count").getAsInt() : 1),
						net.minecraft.util.Prediction.SERVER_ONLY);
			}
		if (r.has("xp")) {
			// the shinobi XP of the mod's levels (the info card), not vanilla's
			int xp = r.get("xp").getAsInt();
			net.mcreator.narutoshippudenmod.core.Progression.addXp(player, xp);
			player.sendOverlayMessage(Component.literal("+" + xp + " XP").withStyle(ChatFormatting.GREEN));
		}
		if (r.has("vanilla_xp"))
			player.giveExperiencePoints(r.get("vanilla_xp").getAsInt());
		if (r.has("commands"))
			r.getAsJsonArray("commands").forEach(c -> Compat.runCommand(player, c.getAsString()));
		if (r.has("time"))
			timeOfDay(player, r.get("time").getAsString());
		announce(player, Component.literal("Quest complete").withStyle(ChatFormatting.GREEN), quest.title(), SoundEvents.UI_TOAST_CHALLENGE_COMPLETE);
		// characters who wait for this quest appear now
		if (player.level() instanceof ServerLevel level)
			for (Character c : characters.values())
				if (c.after().equals(quest.id()) || c.until().equals(quest.id()) || c.graduateAfter().equals(quest.id()))
					retrack(level, c.id());
		autoStart(player);
		sync(player);
	}

	/** Starts every "auto" quest whose quests before it are done. */
	public static void autoStart(ServerPlayer player) {
		for (Quest q : quests.values())
			if (q.start().equals("auto") && startable(player, q))
				start(player, q);
	}

	private static void announce(ServerPlayer player, Component head, String title, net.minecraft.sounds.SoundEvent sound) {
		PacketDistributor.sendToPlayer(player, new Toast(head.getString(), title));
		player.level().playSound(null, player.blockPosition(), sound, SoundSource.PLAYERS, 1.0f, 1.0f);
	}

	/** Something happened that a quest may wait for (code calls this: "chakra_paper_used", "graduated", ...). */
	public static void event(ServerPlayer player, String name) {
		for (Quest q : new ArrayList<>(quests.values())) {
			JsonObject step = step(player, q);
			if (step != null && str(step, "type", "").equals("event") && str(step, "event", "").equals(name))
				advance(player, q);
		}
	}

	/** Checks a step that completes by itself (being somewhere, having items, time); advances it when done. */
	private static void check(ServerPlayer player, Quest quest, JsonObject step) {
		switch (str(step, "type", "")) {
			case "goto" -> {
				JsonArray pos = step.getAsJsonArray("pos");
				double r = step.has("radius") ? step.get("radius").getAsDouble() : 4;
				String dim = str(step, "dimension", Chikyu.CHIKYU.identifier().toString());
				double dx = player.getX() - pos.get(0).getAsDouble() - 0.5, dz = player.getZ() - pos.get(2).getAsDouble() - 0.5;
				double dy = step.has("min_y") ? 0 : player.getY() - pos.get(1).getAsDouble();
				if (player.level().dimension().identifier().toString().equals(dim) && dx * dx + dy * dy + dz * dz <= r * r
						&& (!step.has("min_y") || player.getY() >= step.get("min_y").getAsDouble()))
					advance(player, quest);
			}
			case "collect" -> {
				Item item = BuiltInRegistries.ITEM.getValue(Identifier.parse(step.get("item").getAsString()));
				int need = step.has("count") ? step.get("count").getAsInt() : 1;
				int have = player.getInventory().countItem(item);
				CompoundTag p = progress(player, quest);
				if (p.getIntOr("count", 0) != Math.min(have, need)) {
					p.putInt("count", Math.min(have, need));
					sync(player);
				}
				if (have >= need) {
					if (step.has("take") && step.get("take").getAsBoolean())
						player.getInventory().clearOrCountMatchingItems(s -> s.is(item), false, need, player.inventoryMenu.getCraftSlots());
					advance(player, quest);
				}
			}
			case "spar" -> {
				// a partner already at it with this player, or the nearest one starts
				String who = str(step, "npc", "");
				boolean going = !player.level().getEntities(StoryNpc.entity, player.getBoundingBox().inflate(32), n -> n.isSparringWith(player)).isEmpty();
				if (!going) {
					// the partner waits where it is until the player comes over
					StoryNpc.Npc npc = findNpc(player, who, 24);
					if (npc != null && !npc.isSparring() && npc.distanceToSqr(player) < 7 * 7 && npc.getY() - player.getY() < 3)
						npc.spar(player, step.has("hits") ? step.get("hits").getAsInt() : 5, step.has("damage") ? step.get("damage").getAsDouble() : 2,
								step.has("rank") ? step.get("rank").getAsInt() : 0, step.has("throws") && step.get("throws").getAsBoolean(),
								step.has("substitution") && step.get("substitution").getAsBoolean());
				}
			}
			case "wait" -> {
				CompoundTag p = progress(player, quest);
				int t = p.getIntOr("timer", 0) + 10;
				p.putInt("timer", t);
				if (t >= (step.has("seconds") ? step.get("seconds").getAsInt() : 5) * 20)
					advance(player, quest);
			}
			default -> {
			}
		}
	}

	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		if (!(event.getEntity() instanceof ServerPlayer player) || player.tickCount % 10 != 0 || quests.isEmpty())
			return;
		CompoundTag active = section(state(player), "active");
		if (active.isEmpty())
			return;
		for (String id : new ArrayList<>(active.keySet())) {
			Quest q = quests.get(id);
			JsonObject step = q == null ? null : step(player, q);
			if (step != null)
				check(player, q, step);
		}
	}

	@SubscribeEvent
	public static void onKill(LivingDeathEvent event) {
		if (event.getSource().getEntity() instanceof ServerPlayer player)
			counted(player, "kill", event.getEntity());
	}

	@SubscribeEvent
	public static void onHit(net.neoforged.neoforge.event.entity.living.LivingDamageEvent.Post event) {
		if (event.getSource().getEntity() instanceof ServerPlayer player && event.getEntity() != player)
			counted(player, "hit", event.getEntity());
	}

	/** One more for the steps of that type that count this kind of entity. */
	private static void counted(ServerPlayer player, String kind, Entity target) {
		if (quests.isEmpty())
			return;
		String type = BuiltInRegistries.ENTITY_TYPE.getKey(target.getType()).toString();
		for (Quest q : new ArrayList<>(quests.values())) {
			JsonObject step = step(player, q);
			if (step == null || !str(step, "type", "").equals(kind) || !str(step, "entity", "").equals(type))
				continue;
			CompoundTag p = progress(player, q);
			int n = p.getIntOr("count", 0) + 1;
			p.putInt("count", n);
			if (n >= (step.has("count") ? step.get("count").getAsInt() : 1))
				advance(player, q);
			else
				sync(player);
		}
	}

	@SubscribeEvent
	public static void onLogin(PlayerEvent.PlayerLoggedInEvent event) {
		if (event.getEntity() instanceof ServerPlayer player) {
			autoStart(player);
			sync(player);
		}
	}

	@SubscribeEvent
	public static void onRespawn(PlayerEvent.PlayerRespawnEvent event) {
		if (event.getEntity() instanceof ServerPlayer player)
			sync(player);
	}

	@SubscribeEvent
	public static void onChangedDimension(PlayerEvent.PlayerChangedDimensionEvent event) {
		if (event.getEntity() instanceof ServerPlayer player)
			sync(player);
	}

	/** The story goes on after death. */
	@SubscribeEvent
	public static void onClone(PlayerEvent.Clone event) {
		event.getOriginal().getPersistentData().getCompound(KEY).ifPresent(s -> event.getEntity().getPersistentData().put(KEY, s.copy()));
	}

	// ---------------------------------------------------------------- talking

	/** A player talks to a story character: their quest's dialogue, a new quest, or a passing word. */
	public static void talk(ServerPlayer player, StoryNpc.Npc npc) {
		String who = npc.character();
		// the quest the tracker shows first, then the others
		List<Quest> order = new ArrayList<>(quests.values());
		Quest focus = quests.get(state(player).getStringOr("focus", ""));
		if (focus != null) {
			order.remove(focus);
			order.addFirst(focus);
		}
		for (Quest q : order) {
			JsonObject step = step(player, q);
			if (step != null && str(step, "type", "").equals("talk") && str(step, "npc", "").equals(who)) {
				openDialogue(player, npc, q.id(), "step", step.has("dialogue") ? step.getAsJsonArray("dialogue") : new JsonArray());
				return;
			}
		}
		Quest later = null;
		for (Quest q : quests.values())
			if (q.start().equals(who) && offerable(player, q)) {
				openDialogue(player, npc, q.id(), "offer", q.offer());
				return;
			} else if (later == null && q.start().equals(who) && startable(player, q))
				later = q;
		// a side story they'd offer, but the player has the main story to see to first
		if (later != null) {
			JsonArray lines = new JsonArray();
			JsonObject line = new JsonObject();
			line.addProperty("speaker", who);
			line.addProperty("text", later.later().isEmpty() ? "You look busy. Come back once you've finished what you're doing, and we'll talk." : later.later());
			lines.add(line);
			openDialogue(player, npc, "", "idle", lines);
			return;
		}
		Character c = characters.get(who);
		if (c != null && !c.idle().isEmpty()) {
			JsonArray lines = new JsonArray();
			JsonObject line = new JsonObject();
			line.addProperty("speaker", who);
			line.addProperty("text", c.idle().get(player.getRandom().nextInt(c.idle().size())));
			lines.add(line);
			openDialogue(player, npc, "", "idle", lines);
		}
	}

	private static void openDialogue(ServerPlayer player, StoryNpc.Npc npc, String quest, String kind, JsonArray lines) {
		CompoundTag tag = new CompoundTag();
		tag.putInt("npc", npc.getId());
		tag.putString("quest", quest);
		tag.putString("kind", kind);
		tag.putString("lines", resolveSpeakers(player, lines).toString());
		PacketDistributor.sendToPlayer(player, new Dialogue(tag));
	}

	/** Gives each line its speaker's display name ("name"), recursively through choices. */
	private static JsonArray resolveSpeakers(ServerPlayer player, JsonArray lines) {
		JsonArray out = new JsonArray();
		for (JsonElement e : lines) {
			JsonObject line = e.getAsJsonObject().deepCopy();
			String speaker = str(line, "speaker", "");
			Character c = characters.get(speaker);
			line.addProperty("name", speaker.equals("player") ? player.getName().getString() : c != null ? c.name() : speaker);
			if (line.has("choices"))
				for (JsonElement ch : line.getAsJsonArray("choices")) {
					JsonObject choice = ch.getAsJsonObject();
					if (choice.has("lines"))
						choice.add("lines", resolveSpeakers(player, choice.getAsJsonArray("lines")));
				}
			out.add(line);
		}
		return out;
	}

	/** The dialogue screen was read to its end: set the chosen flags, then go on with the quest. */
	private static void finished(ServerPlayer player, CompoundTag result) {
		Entity e = player.level().getEntity(result.getIntOr("npc", -1));
		if (!(e instanceof StoryNpc.Npc npc) || npc.distanceToSqr(player) > 12 * 12)
			return;
		Quest q = quests.get(result.getStringOr("quest", ""));
		// only the choices this very dialogue offers count (and run their commands)
		JsonArray dialogue = null;
		if (q != null && result.getStringOr("kind", "").equals("offer"))
			dialogue = q.offer();
		else if (q != null && step(player, q) instanceof JsonObject st && st.has("dialogue"))
			dialogue = st.getAsJsonArray("dialogue");
		java.util.Map<String, JsonObject> offered = new java.util.HashMap<>();
		if (dialogue != null)
			choices(dialogue, offered);
		CompoundTag flags = section(state(player), "flags");
		result.getListOrEmpty("flags").forEach(f -> f.asString().ifPresent(name -> {
			JsonObject choice = offered.get(name);
			if (choice == null)
				return;
			flags.putInt(name, flags.getIntOr(name, 0) + 1);
			if (choice.has("commands"))
				choice.getAsJsonArray("commands").forEach(c -> Compat.runCommand(player, c.getAsString()));
		}));
		if (q == null)
			return;
		switch (result.getStringOr("kind", "")) {
			case "offer" -> {
				if (q.start().equals(npc.character()) && offerable(player, q))
					start(player, q);
			}
			case "step" -> {
				JsonObject step = step(player, q);
				if (step != null && str(step, "type", "").equals("talk") && str(step, "npc", "").equals(npc.character()))
					advance(player, q);
			}
			default -> {
			}
		}
	}

	/** Every choice with a flag in these lines (and in the lines the choices lead to), by flag. */
	private static void choices(JsonArray lines, java.util.Map<String, JsonObject> out) {
		for (JsonElement e : lines) {
			JsonObject line = e.getAsJsonObject();
			if (!line.has("choices"))
				continue;
			for (JsonElement c : line.getAsJsonArray("choices")) {
				JsonObject choice = c.getAsJsonObject();
				if (choice.has("flag"))
					out.put(choice.get("flag").getAsString(), choice);
				if (choice.has("lines"))
					choices(choice.getAsJsonArray("lines"), out);
			}
		}
	}

	// ---------------------------------------------------------------- what the client shows

	/** The tracker's quest and objective, and the marks over characters who have something for the player. */
	public static void sync(ServerPlayer player) {
		CompoundTag out = new CompoundTag();
		CompoundTag active = section(state(player), "active");
		String focus = state(player).getStringOr("focus", "");
		if (!active.contains(focus))
			focus = active.keySet().stream().findFirst().orElse("");
		Quest q = quests.get(focus);
		JsonObject step = q == null ? null : step(player, q);
		if (q != null && step != null) {
			out.putString("title", q.title());
			out.putString("objective", objective(step));
			int count = progress(player, q).getIntOr("count", 0);
			String type = str(step, "type", "");
			if (type.equals("kill") || type.equals("hit") || type.equals("collect"))
				out.putString("progress", count + "/" + (step.has("count") ? step.get("count").getAsInt() : 1));
			else if (type.equals("spar"))
				out.putString("progress", count + "/" + (step.has("hits") ? step.get("hits").getAsInt() : 5));
			JsonArray pos = null;
			String dim = Chikyu.CHIKYU.identifier().toString();
			if (type.equals("goto")) {
				pos = step.getAsJsonArray("pos");
				dim = str(step, "dimension", dim);
			} else if (type.equals("talk") || type.equals("spar")) {
				// the character's own scene figure if the step placed one, else where they live
				StoryNpc.Npc npc = findNpc(player, str(step, "npc", ""), 160);
				BlockPos at = npc != null && npc.isScene() ? npc.blockPosition()
						: characters.get(str(step, "npc", "")) instanceof Character c && c.home() != null ? c.home() : npc != null ? npc.blockPosition() : null;
				if (at != null) {
					pos = new JsonArray();
					pos.add(at.getX());
					pos.add(at.getY());
					pos.add(at.getZ());
				}
			}
			if (pos != null) {
				out.putDouble("tx", pos.get(0).getAsDouble() + 0.5);
				out.putDouble("ty", pos.get(1).getAsDouble());
				out.putDouble("tz", pos.get(2).getAsDouble() + 0.5);
				out.putString("tdim", dim);
			}
		}
		CompoundTag marks = new CompoundTag();
		for (Quest quest : quests.values()) {
			JsonObject s = step(player, quest);
			if (s != null && str(s, "type", "").equals("talk"))
				marks.putString(str(s, "npc", ""), "?");
			else if (!quest.start().equals("auto") && offerable(player, quest) && !marks.contains(quest.start()))
				marks.putString(quest.start(), "!");
		}
		out.put("marks", marks);
		out.putInt("skills", skills(player));
		PacketDistributor.sendToPlayer(player, new Sync(out));
	}

	private static String objective(JsonObject step) {
		if (step.has("text"))
			return step.get("text").getAsString();
		return switch (str(step, "type", "")) {
			case "talk" -> "Talk to " + (characters.get(str(step, "npc", "")) instanceof Character c ? c.name() : str(step, "npc", "someone"));
			case "goto" -> "Go to the marked place";
			case "kill" -> "Defeat " + str(step, "entity", "them");
			case "hit" -> "Hit " + str(step, "entity", "it");
			case "spar" -> "Spar with " + (characters.get(str(step, "npc", "")) instanceof Character c ? c.name() : "your partner");
			case "collect" -> "Gather " + str(step, "item", "it");
			case "wait" -> "Wait";
			default -> "Carry on";
		};
	}

	// ---------------------------------------------------------------- the payloads

	/** Server to client: the tracker and the marks. */
	public record Sync(CompoundTag data) implements CustomPacketPayload {
		public static final Type<Sync> TYPE = new Type<>(Identifier.fromNamespaceAndPath("naruto_shippuden", "story_sync"));
		public static final StreamCodec<RegistryFriendlyByteBuf, Sync> CODEC = StreamCodec.composite(ByteBufCodecs.TRUSTED_COMPOUND_TAG, Sync::data, Sync::new);

		@Override
		public Type<Sync> type() {
			return TYPE;
		}
	}

	/** Server to client: open the dialogue screen. */
	public record Dialogue(CompoundTag data) implements CustomPacketPayload {
		public static final Type<Dialogue> TYPE = new Type<>(Identifier.fromNamespaceAndPath("naruto_shippuden", "story_dialogue"));
		public static final StreamCodec<RegistryFriendlyByteBuf, Dialogue> CODEC = StreamCodec.composite(ByteBufCodecs.TRUSTED_COMPOUND_TAG, Dialogue::data,
				Dialogue::new);

		@Override
		public Type<Dialogue> type() {
			return TYPE;
		}
	}

	/** Server to client: a "New quest" / "Quest complete" notice. */
	public record Toast(String head, String title) implements CustomPacketPayload {
		public static final Type<Toast> TYPE = new Type<>(Identifier.fromNamespaceAndPath("naruto_shippuden", "story_toast"));
		public static final StreamCodec<RegistryFriendlyByteBuf, Toast> CODEC = StreamCodec.composite(ByteBufCodecs.STRING_UTF8, Toast::head,
				ByteBufCodecs.STRING_UTF8, Toast::title, Toast::new);

		@Override
		public Type<Toast> type() {
			return TYPE;
		}
	}

	/** Client to server: the dialogue was read to its end, with the flags of the choices made. */
	public record Finished(CompoundTag data) implements CustomPacketPayload {
		public static final Type<Finished> TYPE = new Type<>(Identifier.fromNamespaceAndPath("naruto_shippuden", "story_finished"));
		public static final StreamCodec<RegistryFriendlyByteBuf, Finished> CODEC = StreamCodec.composite(ByteBufCodecs.COMPOUND_TAG, Finished::data,
				Finished::new);

		@Override
		public Type<Finished> type() {
			return TYPE;
		}
	}

	@SubscribeEvent
	public static void registerPayloads(RegisterPayloadHandlersEvent event) {
		event.registrar("1")
				.playToClient(Sync.TYPE, Sync.CODEC, (p, c) -> c.enqueueWork(() -> net.mcreator.narutoshippudenmod.client.StoryClient.onSync(p.data())))
				.playToClient(Dialogue.TYPE, Dialogue.CODEC,
						(p, c) -> c.enqueueWork(() -> net.mcreator.narutoshippudenmod.client.StoryClient.onDialogue(p.data())))
				.playToClient(Toast.TYPE, Toast.CODEC, (p, c) -> c.enqueueWork(() -> net.mcreator.narutoshippudenmod.client.StoryClient.onToast(p.head(), p.title())))
				.playToServer(Finished.TYPE, Finished.CODEC, Story::handleFinished);
	}

	private static void handleFinished(Finished payload, IPayloadContext context) {
		context.enqueueWork(() -> {
			if (context.player() instanceof ServerPlayer player)
				finished(player, payload.data());
		});
	}

	// ---------------------------------------------------------------- the characters in the world

	/** Keeps every character with a home standing there in Chikyū while a player is near: spawned if missing, walked home if gone. */
	@SubscribeEvent
	public static void onServerTick(ServerTickEvent.Post event) {
		MinecraftServer server = event.getServer();
		if (!LATER.isEmpty())
			playLater(server);
		if (server.getTickCount() % 40 != 0 || characters.isEmpty())
			return;
		ServerLevel level = server.getLevel(Chikyu.CHIKYU);
		if (level == null || level.players().isEmpty())
			return;
		// scene characters whose player has moved on (or left) go
		for (Entity e : level.getAllEntities())
			if (e instanceof StoryNpc.Npc npc && npc.isScene() && npc.sceneOver(server))
				npc.discard();
		for (Character c : characters.values()) {
			// any player near, whatever their game mode (a spectator looking round sees the village as it is)
			if (c.home() == null || !level.isLoaded(c.home())
					|| level.players().stream().noneMatch(p -> p.distanceToSqr(c.home().getX() + 0.5, c.home().getY(), c.home().getZ() + 0.5) < 96 * 96))
				continue;
			List<StoryNpc.Npc> found = level.getEntities(StoryNpc.entity, new net.minecraft.world.phys.AABB(c.home()).inflate(64),
					n -> n.character().equals(c.id()) && !n.isScene());
			if (found.isEmpty()) {
				StoryNpc.Npc npc = StoryNpc.entity.create(level, EntitySpawnReason.EVENT);
				if (npc != null) {
					npc.applyCharacter(c);
					npc.snapTo(c.home().getX() + 0.5, c.home().getY(), c.home().getZ() + 0.5, c.yaw(), 0);
					if (!c.pose().isEmpty())
						npc.setStoryPose(c.pose());
					npc.setYHeadRot(c.yaw());
					npc.setYBodyRot(c.yaw());
					level.addFreshEntity(npc);
				}
			} else {
				for (int i = 1; i < found.size(); i++)
					found.get(i).discard();
				StoryNpc.Npc npc = found.getFirst();
				npc.applyCharacter(c);
				// one who sits (the Hokage at his desk) stays in his seat, facing the way he should
				boolean seated = !c.pose().isEmpty();
				if (seated && !npc.isScene())
					npc.setStoryPose(c.pose());
				if (!npc.isSparring() && npc.distanceToSqr(c.home().getX() + 0.5, c.home().getY(), c.home().getZ() + 0.5) > (seated ? 0.1 : 4 * 4)) {
					npc.snapTo(c.home().getX() + 0.5, c.home().getY(), c.home().getZ() + 0.5, c.yaw(), 0);
					npc.setYBodyRot(c.yaw());
				}
			}
		}
	}

	// ---------------------------------------------------------------- commands for testing and mending

	@SubscribeEvent
	public static void registerCommands(RegisterCommandsEvent event) {
		event.getDispatcher().register(Commands.literal("naruto").then(Commands.literal("story").requires(Commands.hasPermission(Commands.LEVEL_GAMEMASTERS))
				.then(Commands.literal("start").then(Commands.argument("quest", StringArgumentType.greedyString())
						.suggests((c, b) -> SharedSuggestionProvider.suggest(quests.keySet(), b))
						.executes(c -> forPlayers(c.getSource(), List.of(c.getSource().getPlayerOrException()), p -> {
							Quest q = quests.get(StringArgumentType.getString(c, "quest"));
							if (q != null)
								start(p, q);
						}))))
				.then(Commands.literal("skip").executes(c -> forPlayers(c.getSource(), List.of(c.getSource().getPlayerOrException()), p -> {
					String focus = state(p).getStringOr("focus", "");
					Quest q = quests.get(focus);
					if (q != null && isActive(p, focus))
						advance(p, q);
				})))
				.then(Commands.literal("talk").executes(c -> forPlayers(c.getSource(), List.of(c.getSource().getPlayerOrException()), p -> {
					// talks to the nearest story character, as a right-click would (for tests)
					List<StoryNpc.Npc> near = p.level().getEntities(StoryNpc.entity, p.getBoundingBox().inflate(8), n -> true);
					near.sort(java.util.Comparator.comparingDouble(n -> n.distanceToSqr(p)));
					if (!near.isEmpty())
						talk(p, near.getFirst());
				})))
				.then(Commands.literal("event").then(Commands.argument("name", StringArgumentType.word())
						.executes(c -> forPlayers(c.getSource(), List.of(c.getSource().getPlayerOrException()), p -> event(p, StringArgumentType.getString(c, "name"))))))
				.then(Commands.literal("reset").executes(c -> forPlayers(c.getSource(), List.of(c.getSource().getPlayerOrException()), Story::reset)).then(Commands.argument("players", EntityArgument.players()).executes(c -> forPlayers(c.getSource(), EntityArgument.getPlayers(c, "players"), Story::reset))))));
	}

	private static int forPlayers(CommandSourceStack source, Collection<ServerPlayer> players, java.util.function.Consumer<ServerPlayer> action) {
		players.forEach(action);
		source.sendSuccess(() -> Component.literal("Story: done for " + players.size() + " player(s)"), true);
		return players.size();
	}

	static ListTag strings(List<String> list) {
		ListTag out = new ListTag();
		list.forEach(s -> out.add(StringTag.valueOf(s)));
		return out;
	}
}
