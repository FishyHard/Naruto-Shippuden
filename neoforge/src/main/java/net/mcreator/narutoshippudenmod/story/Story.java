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
 * data/&lt;ns&gt;/story/characters/&lt;id&gt;.json  {"name", "skin", "model": "legacy"|"player"|"slim", "home": [x, y, z], "yaw", "idle": [lines]}
 * data/&lt;ns&gt;/story/quests/&lt;id&gt;.json      {"title", "chapter", "after": [quest ids], "start": "auto" | character id,
 *                                          "offer": [lines], "steps": [steps], "rewards": {"items": [{"id", "count"}], "xp", "commands"}}
 * </pre>
 * A quest starts by itself ("auto") or when its character is talked to, once every quest in "after" is done. Steps, done one
 * after another, each with an optional "text" (the tracker's objective) and "on_start" (commands run as the player):
 * <pre>
 * {"type": "talk", "npc": id, "dialogue": [lines]}            talk to that character
 * {"type": "goto", "pos": [x, y, z], "radius": r}             go there (in Chikyū, or "dimension")
 * {"type": "kill", "entity": id, "count": n}                   defeat n of them
 * {"type": "collect", "item": id, "count": n, "take": bool}   have n in the inventory (taken when "take")
 * {"type": "wait", "seconds": s}                               let time pass
 * {"type": "event", "event": name}                            something code reports with {@link #event}
 * </pre>
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

	public record Character(String id, String name, Identifier skin, String model, BlockPos home, float yaw, List<String> idle) {
	}

	public record Quest(String id, String title, int chapter, List<String> after, String start, JsonArray offer, List<JsonObject> steps,
			JsonObject rewards) {
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
						o.has("yaw") ? o.get("yaw").getAsFloat() : 0, idle));
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
						o.has("rewards") ? o.getAsJsonObject("rewards") : new JsonObject()));
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
		check(player, quest, step);
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
		if (r.has("xp"))
			player.giveExperiencePoints(r.get("xp").getAsInt());
		if (r.has("commands"))
			r.getAsJsonArray("commands").forEach(c -> Compat.runCommand(player, c.getAsString()));
		announce(player, Component.literal("Quest complete").withStyle(ChatFormatting.GREEN), quest.title(), SoundEvents.UI_TOAST_CHALLENGE_COMPLETE);
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
				if (player.level().dimension().identifier().toString().equals(dim)
						&& player.distanceToSqr(pos.get(0).getAsDouble() + 0.5, pos.get(1).getAsDouble(), pos.get(2).getAsDouble() + 0.5) <= r * r)
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
		if (!(event.getSource().getEntity() instanceof ServerPlayer player))
			return;
		String type = BuiltInRegistries.ENTITY_TYPE.getKey(event.getEntity().getType()).toString();
		for (Quest q : new ArrayList<>(quests.values())) {
			JsonObject step = step(player, q);
			if (step == null || !str(step, "type", "").equals("kill") || !str(step, "entity", "").equals(type))
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
		for (Quest q : quests.values()) {
			JsonObject step = step(player, q);
			if (step != null && str(step, "type", "").equals("talk") && str(step, "npc", "").equals(who)) {
				openDialogue(player, npc, q.id(), "step", step.has("dialogue") ? step.getAsJsonArray("dialogue") : new JsonArray());
				return;
			}
		}
		for (Quest q : quests.values())
			if (q.start().equals(who) && startable(player, q)) {
				openDialogue(player, npc, q.id(), "offer", q.offer());
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
		CompoundTag flags = section(state(player), "flags");
		result.getListOrEmpty("flags").forEach(f -> f.asString().ifPresent(name -> flags.putInt(name, flags.getIntOr(name, 0) + 1)));
		Quest q = quests.get(result.getStringOr("quest", ""));
		if (q == null)
			return;
		switch (result.getStringOr("kind", "")) {
			case "offer" -> {
				if (q.start().equals(npc.character()) && startable(player, q))
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
			if (type.equals("kill") || type.equals("collect"))
				out.putString("progress", count + "/" + (step.has("count") ? step.get("count").getAsInt() : 1));
			JsonArray pos = null;
			String dim = Chikyu.CHIKYU.identifier().toString();
			if (type.equals("goto")) {
				pos = step.getAsJsonArray("pos");
				dim = str(step, "dimension", dim);
			} else if (type.equals("talk") && characters.get(str(step, "npc", "")) instanceof Character c && c.home() != null) {
				pos = new JsonArray();
				pos.add(c.home().getX());
				pos.add(c.home().getY());
				pos.add(c.home().getZ());
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
			else if (!quest.start().equals("auto") && startable(player, quest) && !marks.contains(quest.start()))
				marks.putString(quest.start(), "!");
		}
		out.put("marks", marks);
		PacketDistributor.sendToPlayer(player, new Sync(out));
	}

	private static String objective(JsonObject step) {
		if (step.has("text"))
			return step.get("text").getAsString();
		return switch (str(step, "type", "")) {
			case "talk" -> "Talk to " + (characters.get(str(step, "npc", "")) instanceof Character c ? c.name() : str(step, "npc", "someone"));
			case "goto" -> "Go to the marked place";
			case "kill" -> "Defeat " + str(step, "entity", "them");
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
		if (server.getTickCount() % 40 != 0 || characters.isEmpty())
			return;
		ServerLevel level = server.getLevel(Chikyu.CHIKYU);
		if (level == null || level.players().isEmpty())
			return;
		for (Character c : characters.values()) {
			if (c.home() == null || !level.isLoaded(c.home()) || level.getNearestPlayer(c.home().getX(), c.home().getY(), c.home().getZ(), 96, false) == null)
				continue;
			List<StoryNpc.Npc> found = level.getEntities(StoryNpc.entity, new net.minecraft.world.phys.AABB(c.home()).inflate(64), n -> n.character().equals(c.id()));
			if (found.isEmpty()) {
				StoryNpc.Npc npc = StoryNpc.entity.create(level, EntitySpawnReason.EVENT);
				if (npc != null) {
					npc.applyCharacter(c);
					npc.snapTo(c.home().getX() + 0.5, c.home().getY(), c.home().getZ() + 0.5, c.yaw(), 0);
					npc.setYHeadRot(c.yaw());
					npc.setYBodyRot(c.yaw());
					level.addFreshEntity(npc);
				}
			} else {
				for (int i = 1; i < found.size(); i++)
					found.get(i).discard();
				StoryNpc.Npc npc = found.getFirst();
				npc.applyCharacter(c);
				if (npc.distanceToSqr(c.home().getX() + 0.5, c.home().getY(), c.home().getZ() + 0.5) > 4 * 4)
					npc.snapTo(c.home().getX() + 0.5, c.home().getY(), c.home().getZ() + 0.5, c.yaw(), 0);
			}
		}
	}

	// ---------------------------------------------------------------- commands for testing and mending

	@SubscribeEvent
	public static void registerCommands(RegisterCommandsEvent event) {
		event.getDispatcher().register(Commands.literal("naruto").then(Commands.literal("story").requires(Commands.hasPermission(Commands.LEVEL_GAMEMASTERS))
				.then(Commands.literal("start").then(Commands.argument("quest", StringArgumentType.word())
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
				.then(Commands.literal("reset").executes(c -> forPlayers(c.getSource(), List.of(c.getSource().getPlayerOrException()), p -> {
					p.getPersistentData().remove(KEY);
					autoStart(p);
					sync(p);
				})).then(Commands.argument("players", EntityArgument.players()).executes(c -> forPlayers(c.getSource(), EntityArgument.getPlayers(c, "players"), p -> {
					p.getPersistentData().remove(KEY);
					autoStart(p);
					sync(p);
				}))))));
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
