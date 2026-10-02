package net.mcreator.narutoshippudenmod.client;

import net.mcreator.narutoshippudenmod.story.Story;
import net.mcreator.narutoshippudenmod.story.StoryNpc;
import net.mcreator.narutoshippudenmod.story.TrackerConfig;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mojang.blaze3d.platform.InputConstants;

import net.minecraft.ChatFormatting;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.toasts.SystemToast;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.input.KeyEvent;
import net.minecraft.client.input.MouseButtonEvent;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.state.HumanoidRenderState;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.StringTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.Identifier;
import net.minecraft.util.FormattedCharSequence;
import net.minecraft.util.Mth;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterGuiLayersEvent;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.neoforged.neoforge.client.network.ClientPacketDistributor;

import com.mojang.blaze3d.vertex.PoseStack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * The story on the player's screen: the quest tracker (a small dark box in a corner, like the vanilla-style notices of
 * other mods: the quest in yellow, what to do in white, how far and which way the goal is in grey), the dialogue screen
 * (a vanilla panel along the bottom: who speaks, their words appearing letter by letter, choices as vanilla buttons), the
 * "New quest" / "Quest complete" toasts, and the story characters with a "!" or "?" over those who have something for you.
 * J hides or shows the tracker, K opens its settings (corner, size, distance from the edges).
 */
@EventBusSubscriber(modid = "naruto_shippuden", value = Dist.CLIENT)
public final class StoryClient {
	private static CompoundTag data = new CompoundTag();
	public static final KeyMapping TRACKER = new KeyMapping("key.naruto_shippuden.quest_tracker", InputConstants.KEY_J, EyeKeys.CATEGORY);
	public static final KeyMapping TRACKER_SETTINGS = new KeyMapping("key.naruto_shippuden.quest_tracker_settings", InputConstants.KEY_K, EyeKeys.CATEGORY);
	private static final SystemToast.SystemToastId TOAST = new SystemToast.SystemToastId(4000L);
	private static ItemStack icon;

	private StoryClient() {
	}

	// ---------------------------------------------------------------- from the server

	public static void onSync(CompoundTag tag) {
		data = tag;
		// what the player has learned: walls and water are walked on by the client (core/ChakraControl)
		Story.clientSkills = tag.getIntOr("skills", -1);
	}

	public static void onDialogue(CompoundTag tag) {
		Minecraft mc = Minecraft.getInstance();
		JsonArray lines = JsonParser.parseString(tag.getStringOr("lines", "[]")).getAsJsonArray();
		if (!lines.isEmpty())
			mc.gui.setScreen(new DialogueScreen(tag, lines));
	}

	public static void onToast(String head, String title) {
		SystemToast.addOrUpdate(Minecraft.getInstance().gui.toastManager(), TOAST, Component.literal(head).withStyle(ChatFormatting.YELLOW),
				Component.literal(title));
	}

	/** The mark over a character: "!" a quest to start, "?" a quest step to talk to them, "" nothing. */
	public static String mark(String character) {
		return data.getCompound("marks").map(m -> m.getStringOr(character, "")).orElse("");
	}

	// ---------------------------------------------------------------- keys

	@SubscribeEvent
	public static void registerKeys(RegisterKeyMappingsEvent event) {
		event.register(TRACKER);
		event.register(TRACKER_SETTINGS);
	}

	@SubscribeEvent
	public static void tick(ClientTickEvent.Post event) {
		Minecraft mc = Minecraft.getInstance();
		while (TRACKER.consumeClick())
			if (mc.gui.screen() == null) {
				TrackerConfig.HIDDEN.set(!TrackerConfig.HIDDEN.get());
				TrackerConfig.SPEC.save();
			}
		while (TRACKER_SETTINGS.consumeClick())
			if (mc.gui.screen() == null)
				mc.gui.setScreen(new TrackerSettingsScreen());
	}

	// ---------------------------------------------------------------- the tracker

	@SubscribeEvent
	public static void registerLayers(RegisterGuiLayersEvent event) {
		event.registerAboveAll(Identifier.fromNamespaceAndPath("naruto_shippuden", "quest_tracker"), StoryClient::renderTracker);
	}

	private static void renderTracker(GuiGraphicsExtractor graphics, DeltaTracker delta) {
		Minecraft mc = Minecraft.getInstance();
		if (mc.player == null || TrackerConfig.HIDDEN.get() || !data.contains("title"))
			return;
		drawTracker(graphics, mc, lines(mc), false);
	}

	/** The tracker's lines: the quest, the objective (with its count), the way to the goal, the keys. */
	private static List<Component> lines(Minecraft mc) {
		List<Component> out = new ArrayList<>();
		out.add(Component.literal(data.getStringOr("title", "")).withStyle(ChatFormatting.YELLOW));
		MutableComponent objective = Component.literal(data.getStringOr("objective", "")).withStyle(ChatFormatting.WHITE);
		if (data.contains("progress"))
			objective.append(Component.literal(" " + data.getStringOr("progress", "")).withStyle(ChatFormatting.GRAY));
		out.add(objective);
		if (data.contains("tx") && mc.player.level().dimension().identifier().toString().equals(data.getStringOr("tdim", ""))) {
			Vec3 target = new Vec3(data.getDoubleOr("tx", 0), data.getDoubleOr("ty", 0), data.getDoubleOr("tz", 0));
			Vec3 to = target.subtract(mc.player.position());
			int metres = (int) Math.round(Math.sqrt(to.x * to.x + to.z * to.z));
			if (metres > 3) {
				// the way, relative to where the player looks
				double angle = Mth.wrapDegrees(Math.toDegrees(Math.atan2(-to.x, to.z)) - mc.player.getYRot());
				String way = Math.abs(angle) < 35 ? "ahead" : Math.abs(angle) > 145 ? "behind you" : angle > 0 ? "to your right" : "to your left";
				out.add(Component.literal(metres + "m " + way).withStyle(ChatFormatting.GRAY));
			} else
				out.add(Component.literal("Here").withStyle(ChatFormatting.GRAY));
		}
		out.add(Component.literal(key(TRACKER) + " Hide  ·  " + key(TRACKER_SETTINGS) + " Settings").withStyle(ChatFormatting.DARK_GRAY));
		return out;
	}

	private static String key(KeyMapping key) {
		return key.getTranslatedKeyMessage().getString();
	}

	static void drawTracker(GuiGraphicsExtractor graphics, Minecraft mc, List<Component> lines, boolean preview) {
		Font font = mc.font;
		float scale = TrackerConfig.SCALE.get().floatValue();
		int textWidth = 0;
		for (Component line : lines)
			textWidth = Math.max(textWidth, font.width(line));
		int w = 4 + 18 + textWidth + 5, h = 4 + lines.size() * 10 + 2;
		String corner = TrackerConfig.CORNER.get();
		int sw = (int) (graphics.guiWidth() / scale), sh = (int) (graphics.guiHeight() / scale);
		int ox = (int) (TrackerConfig.OFFSET_X.get() / scale), oy = (int) (TrackerConfig.OFFSET_Y.get() / scale);
		int x = corner.endsWith("left") ? ox : sw - w - ox;
		int y = corner.startsWith("top") ? oy : sh - h - oy;
		graphics.pose().pushMatrix();
		graphics.pose().scale(scale, scale);
		graphics.fill(x, y, x + w, y + h, 0xC0101010);
		// a 1px grey frame, as the reference: top, bottom, sides
		graphics.fill(x, y, x + w, y + 1, 0xFF555555);
		graphics.fill(x, y + h - 1, x + w, y + h, 0xFF555555);
		graphics.fill(x, y, x + 1, y + h, 0xFF555555);
		graphics.fill(x + w - 1, y, x + w, y + h, 0xFF555555);
		if (icon == null)
			icon = new ItemStack(Items.WRITABLE_BOOK);
		graphics.item(icon, x + 3, y + (h - 16) / 2);
		for (int i = 0; i < lines.size(); i++)
			graphics.text(font, lines.get(i), x + 4 + 18, y + 4 + i * 10, 0xFFFFFFFF, true);
		graphics.pose().popMatrix();
	}

	// ---------------------------------------------------------------- the dialogue

	/** One conversation: lines one after another, choices as buttons; the result goes to the server at the end. */
	static class DialogueScreen extends Screen {
		private static final Identifier PANEL = Identifier.fromNamespaceAndPath("naruto_shippuden", "panel");
		private static final Identifier INSET = Identifier.fromNamespaceAndPath("naruto_shippuden", "inset");
		private static final int TEXT = 0xFF404040, MUTED = 0xFF707070, CHARS_PER_SECOND = 45;
		private final CompoundTag context;
		private final Deque<JsonObject> queue = new ArrayDeque<>();
		private final ListTag flags = new ListTag();
		private JsonObject line;
		private long lineStart;
		private boolean sent;

		DialogueScreen(CompoundTag context, JsonArray lines) {
			super(Component.literal("Dialogue"));
			this.context = context;
			for (JsonElement e : lines)
				queue.add(e.getAsJsonObject());
			next();
		}

		private void next() {
			line = queue.poll();
			lineStart = System.currentTimeMillis();
			if (minecraft != null)
				rebuildWidgets();
		}

		private String text() {
			return line == null ? "" : line.has("text") ? line.get("text").getAsString() : "";
		}

		private int shownChars() {
			return (int) Math.min(text().length(), (System.currentTimeMillis() - lineStart) * CHARS_PER_SECOND / 1000);
		}

		private boolean typing() {
			return shownChars() < text().length();
		}

		private int panelWidth() {
			return Math.min(width - 40, 340);
		}

		private int panelTop() {
			return height - 78;
		}

		/** Who speaks this line, to show them beside it: the player, or the nearest story character of that id. */
		private net.minecraft.world.entity.LivingEntity speaker() {
			if (line == null || minecraft == null || minecraft.player == null)
				return null;
			String who = line.has("speaker") ? line.get("speaker").getAsString() : "";
			if (who.equals("player"))
				return minecraft.player;
			StoryNpc.Npc best = null;
			for (StoryNpc.Npc npc : minecraft.level.getEntitiesOfClass(StoryNpc.Npc.class, minecraft.player.getBoundingBox().inflate(32), n -> n.character().equals(who)))
				if (best == null || npc.distanceToSqr(minecraft.player) < best.distanceToSqr(minecraft.player))
					best = npc;
			return best;
		}

		/** The speaker in a little window at the panel's left, as the inventory shows the player (turned a little toward the text). */
		private void portrait(GuiGraphicsExtractor graphics, net.minecraft.world.entity.LivingEntity entity, int x0, int y0, int x1, int y1) {
			graphics.blitSprite(RenderPipelines.GUI_TEXTURED, INSET, x0, y0, x1 - x0, y1 - y0);
			graphics.fill(x0 + 1, y0 + 1, x1 - 1, y1 - 1, 0xFF8B8B8B);
			var renderer = minecraft.getEntityRenderDispatcher().getRenderer(entity);
			var state = renderer.createRenderState(entity, 1.0F);
			state.shadowPieces.clear();
			state.outlineColor = 0;
			state.nameTag = null;
			float turn = -0.5F;
			if (state instanceof net.minecraft.client.renderer.entity.state.LivingEntityRenderState living) {
				living.bodyRot = 180.0F + turn * 20.0F;
				living.yRot = turn * 20.0F;
				living.xRot = 0;
				living.boundingBoxWidth = living.boundingBoxWidth / living.scale;
				living.boundingBoxHeight = living.boundingBoxHeight / living.scale;
				living.scale = 1.0F;
				// standing up, whatever the scene has them doing (Mizuki lying beaten, Iruka kneeling)
				living.pose = net.minecraft.world.entity.Pose.STANDING;
				living.bedOrientation = null;
				living.walkAnimationPos = 0;
				living.walkAnimationSpeed = 0;
				if (living instanceof HumanoidRenderState humanoid) {
					humanoid.isCrouching = false;
					humanoid.isPassenger = false;
					if (humanoid instanceof NpcState npc)
						npc.seated = false;
					// framed as standing too: lying or crouching shrinks the box the framing is measured from
					living.boundingBoxHeight = 1.8F;
				}
			}
			org.joml.Quaternionf rotation = new org.joml.Quaternionf().rotateZ((float) Math.PI);
			// framed from the chest up: big, the head and shoulders in the window
			graphics.entity(state, 38, new org.joml.Vector3f(0.0F, state.boundingBoxHeight / 2.0F + 0.45F, 0.0F), rotation, null, x0 + 1, y0 + 1, x1 - 1, y1 - 1);
		}

		@Override
		protected void init() {
			if (line == null || !line.has("choices") || typing())
				return;
			JsonArray choices = line.getAsJsonArray("choices");
			int bw = Math.min(panelWidth(), 240), bx = (width - bw) / 2;
			int by = panelTop() - 4 - choices.size() * 22;
			for (int i = 0; i < choices.size(); i++) {
				JsonObject choice = choices.get(i).getAsJsonObject();
				addRenderableWidget(Button.builder(Component.literal(choice.get("text").getAsString()), b -> choose(choice))
						.bounds(bx, by + i * 22, bw, 20).build());
			}
		}

		private void choose(JsonObject choice) {
			if (choice.has("flag"))
				flags.add(StringTag.valueOf(choice.get("flag").getAsString()));
			if (choice.has("lines")) {
				List<JsonObject> more = new ArrayList<>();
				choice.getAsJsonArray("lines").forEach(l -> more.add(l.getAsJsonObject()));
				for (int i = more.size() - 1; i >= 0; i--)
					queue.addFirst(more.get(i));
			}
			advance(true);
		}

		/** A click or a key: finish the line being written, or go to the next one (not past a choice). */
		private void advance(boolean chosen) {
			if (typing()) {
				lineStart = 0;
				rebuildWidgets();
				return;
			}
			if (!chosen && line != null && line.has("choices"))
				return;
			if (queue.isEmpty()) {
				finish();
				return;
			}
			next();
		}

		/** For the dev client's tests: the next line (finishing the one being written), or a choice by its index. */
		void devNext() {
			lineStart = 0;
			advance(false);
		}

		void devChoose(int i) {
			lineStart = 0;
			if (line != null && line.has("choices") && i < line.getAsJsonArray("choices").size())
				choose(line.getAsJsonArray("choices").get(i).getAsJsonObject());
		}

		private void finish() {
			if (!sent) {
				sent = true;
				CompoundTag result = new CompoundTag();
				result.putInt("npc", context.getIntOr("npc", -1));
				result.putString("quest", context.getStringOr("quest", ""));
				result.putString("kind", context.getStringOr("kind", ""));
				result.put("flags", flags);
				ClientPacketDistributor.sendToServer(new Story.Finished(result));
			}
			onClose();
		}

		@Override
		public boolean mouseClicked(MouseButtonEvent event, boolean doubleClick) {
			if (super.mouseClicked(event, doubleClick))
				return true;
			advance(false);
			return true;
		}

		@Override
		public boolean keyPressed(KeyEvent event) {
			int key = event.key();
			if (key == InputConstants.KEY_SPACE || key == InputConstants.KEY_RETURN || key == InputConstants.KEY_E) {
				advance(false);
				return true;
			}
			return super.keyPressed(event);
		}

		@Override
		public boolean isPauseScreen() {
			return false;
		}

		@Override
		public void tick() {
			// the choices appear once their line is written out
			if (line != null && line.has("choices") && !typing() && children().isEmpty())
				rebuildWidgets();
		}

		@Override
		public void extractBackground(GuiGraphicsExtractor graphics, int mouseX, int mouseY, float a) {
			if (line == null)
				return;
			int w = panelWidth(), x = (width - w) / 2, y = panelTop(), h = 70;
			graphics.blitSprite(RenderPipelines.GUI_TEXTURED, PANEL, x, y, w, h);
			net.minecraft.world.entity.LivingEntity who = speaker();
			int tx = x + 8;
			if (who != null) {
				portrait(graphics, who, x + 6, y + 6, x + 52, y + h - 6);
				tx = x + 58;
			}
			String name = line.has("name") ? line.get("name").getAsString() : "";
			graphics.text(font, name, tx, y + 6, TEXT, false);
			String shown = text().substring(0, shownChars());
			List<FormattedCharSequence> wrapped = font.split(Component.literal(shown), x + w - 8 - tx);
			for (int i = 0; i < wrapped.size() && i < 4; i++)
				graphics.text(font, wrapped.get(i), tx, y + 20 + i * 10, TEXT, false);
			if (!typing() && !line.has("choices") && (System.currentTimeMillis() / 400) % 2 == 0)
				graphics.text(font, "▼", x + w - 14, y + h - 12, MUTED, false);
		}
	}

	// ---------------------------------------------------------------- the tracker's settings

	/** Corner, size and distance from the edges, with the tracker shown as it will look. */
	static class TrackerSettingsScreen extends Screen {
		TrackerSettingsScreen() {
			super(Component.literal("Quest Tracker"));
		}

		@Override
		protected void init() {
			int cx = width / 2, y = height / 2 - 50;
			addRenderableWidget(Button.builder(Component.literal("Corner: " + TrackerConfig.CORNER.get().replace('_', ' ')), b -> {
				int i = List.of(TrackerConfig.CORNERS).indexOf(TrackerConfig.CORNER.get());
				TrackerConfig.CORNER.set(TrackerConfig.CORNERS[(i + 1) % TrackerConfig.CORNERS.length]);
				save();
			}).bounds(cx - 100, y, 200, 20).build());
			addRenderableWidget(new Slider(cx - 100, y + 24, 200, "Size", 0.5, 1.5, TrackerConfig.SCALE.get(), v -> Math.round(v * 100) + "%",
					v -> TrackerConfig.SCALE.set(Math.round(v * 20) / 20.0)));
			addRenderableWidget(new Slider(cx - 100, y + 48, 200, "Margin", 0, 100, TrackerConfig.OFFSET_X.get(), v -> (int) Math.round(v) + "px", v -> {
				TrackerConfig.OFFSET_X.set((int) Math.round(v));
				TrackerConfig.OFFSET_Y.set((int) Math.round(v));
			}));
			addRenderableWidget(Button.builder(Component.literal(TrackerConfig.HIDDEN.get() ? "Show tracker" : "Hide tracker"), b -> {
				TrackerConfig.HIDDEN.set(!TrackerConfig.HIDDEN.get());
				save();
			}).bounds(cx - 100, y + 72, 200, 20).build());
			addRenderableWidget(Button.builder(Component.literal("Done"), b -> onClose()).bounds(cx - 100, y + 100, 200, 20).build());
		}

		private void save() {
			TrackerConfig.SPEC.save();
			rebuildWidgets();
		}

		@Override
		public void onClose() {
			TrackerConfig.SPEC.save();
			super.onClose();
		}

		@Override
		public boolean isPauseScreen() {
			return false;
		}

		/** A vanilla slider (as the FOV one) over a range, showing "Name: value". */
		private static class Slider extends net.minecraft.client.gui.components.AbstractSliderButton {
			private final String name;
			private final double min, max;
			private final java.util.function.DoubleFunction<String> label;
			private final java.util.function.DoubleConsumer apply;

			Slider(int x, int y, int w, String name, double min, double max, double current, java.util.function.DoubleFunction<String> label,
					java.util.function.DoubleConsumer apply) {
				super(x, y, w, 20, Component.empty(), (Mth.clamp(current, min, max) - min) / (max - min));
				this.name = name;
				this.min = min;
				this.max = max;
				this.label = label;
				this.apply = apply;
				updateMessage();
			}

			private double actual() {
				return min + value * (max - min);
			}

			@Override
			protected void updateMessage() {
				setMessage(Component.literal(name + ": " + label.apply(actual())));
			}

			@Override
			protected void applyValue() {
				apply.accept(actual());
			}
		}

		@Override
		public void extractRenderState(GuiGraphicsExtractor graphics, int mouseX, int mouseY, float a) {
			super.extractRenderState(graphics, mouseX, mouseY, a);
			graphics.text(font, title, width / 2 - font.width(title) / 2, height / 2 - 70, 0xFFFFFFFF, true);
			List<Component> lines = data.contains("title") ? lines(minecraft) : List.of(Component.literal("Your quest").withStyle(ChatFormatting.YELLOW),
					Component.literal("What to do next"), Component.literal("40m ahead").withStyle(ChatFormatting.GRAY));
			drawTracker(graphics, minecraft, lines, true);
		}
	}

	// ---------------------------------------------------------------- the characters

	@SubscribeEvent
	public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(StoryNpc.entity, NpcRenderer::new);
	}

	public static class NpcState extends HumanoidRenderState {
		Identifier texture;
		String model = "legacy";
		/** A dojutsu over the face (the mod's eye textures, as players' eyes are drawn), or null. */
		Identifier eyes;
		/** Sitting on a chair: drawn in the riding pose, lowered so the hips rest on the seat. */
		boolean seated;
	}

	/** Drawn as a player: the old 64x32 skins (legacy), 64x64 player skins, or slim-armed ones; a mark over the name. Not with
	 * vanilla's AvatarRenderState (26.3 sends any of those to the player renderer, which draws the player's own skin), and
	 * not a HumanoidMobRenderer (its AgeableMobRenderer sets its own model in submit, undoing the choice of model). */
	static class NpcRenderer extends net.minecraft.client.renderer.entity.MobRenderer<StoryNpc.Npc, NpcState, HumanoidModel<NpcState>> {
		private final HumanoidModel<NpcState> legacy, wide, slim;

		@SuppressWarnings({"unchecked", "rawtypes"})
		NpcRenderer(EntityRendererProvider.Context context) {
			super(context, new HumanoidModel(context.bakeLayer(ModRenderers.LEGACY_HUMANOID)), 0.5F);
			this.legacy = this.model;
			this.wide = new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER));
			this.slim = new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_SLIM));
			this.addLayer(new net.minecraft.client.renderer.entity.layers.ItemInHandLayer<>(this));
			// what they wear (the forehead protector is the real headband item, not painted on the skin)
			this.addLayer(new net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer<>(this,
					net.minecraft.client.renderer.entity.ArmorModelSet.bake(ModelLayers.PLAYER_ARMOR, context.getModelSet(), HumanoidModel::new),
					context.getEquipmentRenderer()));
			// a dojutsu over the eyes, on the skin and under the headband
			this.addLayer(new net.minecraft.client.renderer.entity.layers.RenderLayer<>(this) {
				@Override
				public void submit(PoseStack pose, SubmitNodeCollector collector, int light, NpcState state, float yRot, float xRot) {
					if (state.eyes != null && !state.isInvisible)
						collector.order(1).submitModel(getParentModel(), state, pose,
								net.minecraft.client.renderer.rendertype.RenderTypes.entityCutoutZOffset(state.eyes), light,
								net.minecraft.client.renderer.entity.LivingEntityRenderer.getOverlayCoords(state, 0.0F), state.outlineColor);
				}
			});
		}

		@Override
		public NpcState createRenderState() {
			return new NpcState();
		}

		@Override
		public void extractRenderState(StoryNpc.Npc npc, NpcState state, float partialTicks) {
			super.extractRenderState(npc, state, partialTicks);
			HumanoidMobRenderer.extractHumanoidRenderState(npc, state, partialTicks, this.itemModelResolver);
			state.texture = npc.skin().isEmpty() ? Identifier.parse("naruto_shippuden:textures/entities/iruka_sensei.png") : Identifier.parse(npc.skin());
			state.model = npc.model();
			state.eyes = npc.eyes().isEmpty() ? null : Identifier.tryParse(npc.eyes());
			state.seated = npc.getPose() == net.minecraft.world.entity.Pose.SITTING;
			if (state.seated) {
				// seated, the body keeps facing the way the seat does (its yaw), only the head turns to look round
				float seat = npc.getYRot();
				state.yRot = net.minecraft.util.Mth.clamp(net.minecraft.util.Mth.wrapDegrees(state.bodyRot + state.yRot - seat), -70.0F, 70.0F);
				state.bodyRot = seat;
			}
			if (npc.getPose() == net.minecraft.world.entity.Pose.SWIMMING) {
				// lying down (StoryNpc holds it as SWIMMING for its box): drawn as a sleeper on the ground, no bed
				state.pose = net.minecraft.world.entity.Pose.SLEEPING;
				state.bedOrientation = null;
				state.swimAmount = 0;
			}
			if (state.seated)
				state.isPassenger = true;
		}

		@Override
		public void submit(NpcState state, PoseStack poseStack, SubmitNodeCollector collector, CameraRenderState camera) {
			this.model = switch (state.model) {
				case "player" -> wide;
				case "slim" -> slim;
				default -> legacy;
			};
			if (state.hasPose(net.minecraft.world.entity.Pose.SLEEPING) && state.bedOrientation == null) {
				// lying on the ground (no bed): vanilla lays the body out from the feet; centred on the position instead,
				// where the hitbox is. The head points along (-cos, sin) of the body's turn
				double b = Math.toRadians(state.bodyRot);
				poseStack.pushPose();
				poseStack.translate(0.9 * Math.cos(b), 0, -0.9 * Math.sin(b));
				super.submit(state, poseStack, collector, camera);
				poseStack.popPose();
				return;
			}
			if (state.seated) {
				// his feet are at the chair block's floor; the seat (a stair's step) is half a block up, his hips 3/4
				poseStack.pushPose();
				poseStack.translate(0, -0.25, 0);
				super.submit(state, poseStack, collector, camera);
				poseStack.popPose();
				return;
			}
			super.submit(state, poseStack, collector, camera);
		}

		@Override
		public Identifier getTextureLocation(NpcState state) {
			return state.texture;
		}

		@Override
		protected boolean shouldShowName(StoryNpc.Npc npc, double distanceToCameraSq) {
			return distanceToCameraSq < 16 * 16 && !npc.displayName().isEmpty();
		}

		@Override
		protected Component getNameTag(StoryNpc.Npc npc) {
			String mark = mark(npc.character());
			MutableComponent name = Component.literal(npc.displayName());
			return mark.isEmpty() ? name : Component.literal(mark + " ").withStyle(ChatFormatting.YELLOW, ChatFormatting.BOLD).append(name.withStyle(ChatFormatting.RESET));
		}
	}
}
