package net.mcreator.narutoshippudenmod.client;

import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables;
import net.mcreator.narutoshippudenmod.core.ModelSwapRenderers;
import net.mcreator.narutoshippudenmod.core.Susanoo;
import net.mcreator.narutoshippudenmod.core.Susanoo.Owner;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.entity.state.AvatarRenderState;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.CalculateDetachedCameraDistanceEvent;
import net.neoforged.neoforge.client.event.RenderLivingEvent;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

/**
 * Draws a player's Susanoo (core/Susanoo) round them: the owner's model for the stage (SusanooModels), see-through and glowing,
 * scaled up stage by stage. It forms over half a second (the rib rings rise one after another, the rest swells out of them and
 * fades in) and, let go, fades and shrinks away. It turns with the body, looks where the user looks, breathes, its flames
 * flicker, its right arm swings when the user attacks and its left draws the bow; the Complete one walks and beats its wings.
 * The third-person camera stands back far enough to see it.
 */
@EventBusSubscriber(modid = "naruto_shippuden", value = Dist.CLIENT)
public final class SusanooRenderer {
	/** How much bigger each stage is drawn than its model. */
	private static final float[] SCALE = { 0, 1.0F, 1.9F, 2.7F, 3.2F, 4.8F };
	/** Third-person camera distance by stage. */
	private static final float[] CAMERA = { 0, 4, 6, 9, 11, 18 };
	private static final int FORM = 12, FADE = 10;
	/** How tall the Complete Susanoo stands, in blocks. */
	private static final float COMPLETE_HEIGHT = 18;

	private static final Map<Owner, Map<String, SusanooModel>> MODELS = new EnumMap<>(Owner.class);
	/** Per player: the stage shown, the stage before it (fading out), and when it changed. */
	private static final Map<Integer, float[]> CHANGES = new HashMap<>();

	private SusanooRenderer() {
	}

	/** What the model needs to pose itself, made fresh for each frame (drawing happens after the frame is gathered). */
	static final class State {
		int stage;
		float form, age, attack, offAttack, headYaw, headPitch, walkPos, walkSpeed, flying, breaking;
	}

	static final class SusanooModel extends Model<State> {
		final Identifier texture;
		final float scale;
		private final java.util.function.Function<String, ModelPart> lookup;

		/** How far down (blocks) the model is drawn: the Complete one's feet on the ground under its floating user. */
		final float drop;
		/** The middle of its body (x, z in Blockbench's units), where its user goes. */
		float[] seat = { 0, 0 };

		SusanooModel(ModelPart root, Identifier texture, float scale, float drop) {
			super(root, RenderTypes::entityTranslucentCull);
			this.texture = texture;
			this.scale = scale;
			this.drop = drop;
			this.lookup = root.createPartLookup();
		}

		/** A part by name anywhere in the model, or null. */
		ModelPart find(String name) {
			return lookup.apply(name);
		}

		@Override
		public void setupAnim(State s) {
			super.setupAnim(s);
			ModelPart body = find("body");
			float breathe = Mth.sin(s.age * 0.08F) * 0.6F;
			if (body != null) {
				body.y += breathe;
				// the rib rings rise one after another as it forms
				for (int i = 0; i < 5; i++) {
					ModelPart ring = find("ring" + i);
					if (ring != null)
						ring.visible = s.form > i * 0.15F || s.stage > 1;
				}
				ModelPart head = find("head");
				if (head != null) {
					head.yRot = s.headYaw * Mth.DEG_TO_RAD * 0.8F;
					head.xRot = s.headPitch * Mth.DEG_TO_RAD * 0.6F;
					ModelPart jaw = find("jaw");
					if (jaw != null)
						jaw.xRot = 0.08F + Math.max(0, Mth.sin(s.age * 0.05F)) * 0.08F + s.attack * 0.25F;
				}
				swing(find("right_arm"), s.attack, 1);
				ModelPart left = find("left_arm");
				if (left != null && s.offAttack > 0) {
					// drawing the bow: the arm held out in front
					left.xRot = Mth.lerp(s.offAttack, left.xRot, -1.45F);
					left.yRot = Mth.lerp(s.offAttack, left.yRot, 0.15F);
				}
				for (String w : new String[] { "right_wing", "left_wing" }) {
					ModelPart wing = find(w);
					if (wing != null) {
						// as the model holds them on the ground, a slow beat; flying, spread wider and beating hard
						boolean right = w.startsWith("right");
						float beat = Mth.sin(s.age * (0.1F + s.flying * 0.16F)) * (0.05F + s.flying * 0.18F);
						wing.yRot += (right ? 1 : -1) * beat;
						wing.zRot += (right ? -1 : 1) * s.flying * 0.3F;
					}
				}
				flicker(this, s.age);
			}
			// the Complete one walks
			for (String l : new String[] { "right_leg", "left_leg" }) {
				ModelPart leg = find(l);
				if (leg == null || s.flying > 0)
					continue;                                     // in the air the legs keep the pose's own shape
				float sign = l.startsWith("right") ? 1 : -1;
				leg.xRot = Mth.cos(s.walkPos * 0.6662F + (sign > 0 ? 0 : Mth.PI)) * s.walkSpeed * 0.9F - s.flying * 0.25F;
				ModelPart shin = find("shin") != null ? part(leg, "shin") : null;
				if (shin != null)
					shin.xRot = Math.max(0, -leg.xRot) * 0.8F + s.flying * 0.35F;
			}
		}

		/** The arm's blow: raised back, then struck forward and across. */
		private static void swing(ModelPart arm, float attack, float side) {
			if (arm == null || attack <= 0)
				return;
			float f = 1 - (1 - attack) * (1 - attack) * (1 - attack);
			float lift = Mth.sin(f * Mth.PI);
			arm.xRot -= lift * 1.9F;
			arm.yRot += Mth.sin(attack * Mth.PI) * 0.5F * side;
			arm.zRot += Mth.sin(attack * Mth.PI) * -0.3F * side;
			ModelPart fore = arm.hasChild("forearm") ? arm.getChild("forearm") : null;
			if (fore != null)
				fore.xRot *= 1 - lift;
		}

		/** Flames lick up and down. */
		private static void flicker(SusanooModel model, float age) {
			for (String name : new String[] { "flame_waist", "flame_s-1", "flame_s1", "flame_mane" }) {
				ModelPart flame = model.find(name);
				if (flame != null) {
					float k = name.hashCode() * 0.37F;
					flame.yScale = 0.85F + Mth.sin(age * 0.45F + k) * 0.15F + Mth.sin(age * 1.1F + k * 2) * 0.06F;
					flame.xScale = 1 + Mth.sin(age * 0.3F + k) * 0.05F;
				}
			}
		}

		private static ModelPart part(ModelPart parent, String name) {
			return parent != null && parent.hasChild(name) ? parent.getChild(name) : null;
		}
	}

	/**
	 * The converted model for the owner and stage (its own texture, drawn at its own size), else the built one. A pose ("5_float",
	 * "5_fly") falls back to the stage's own model when the owner has none.
	 */
	private static SusanooModel model(Owner owner, int stage, String pose) {
		String key = pose.isEmpty() ? String.valueOf(stage) : stage + "_" + pose;
		var models = MODELS.computeIfAbsent(owner, o -> new HashMap<>());
		SusanooModel found = models.get(key);
		if (found != null)
			return found;
		if (!pose.isEmpty() && SusanooModels.converted(owner, key) == null) {
			found = model(owner, stage, "");
			models.put(key, found);
			return found;
		}
		found = load(owner, stage, key);
		models.put(key, found);
		return found;
	}

	private static SusanooModel load(Owner owner, int s, String key) {
		{
			var converted = SusanooModels.converted(owner, key);
			if (converted != null) {
				// the Complete ones are all drawn COMPLETE_HEIGHT blocks tall, their feet HOVER blocks under the user, who floats in the chest
				// (its floating and flying poses at the standing one's scale, so all three are the same size)
				var standing = s == Susanoo.MAX ? SusanooModels.converted(owner, String.valueOf(s)) : null;
				float tall = standing != null ? standing.height() : converted.height();
				float scale = s == Susanoo.MAX && tall > 0 ? COMPLETE_HEIGHT * 16 / tall : 1;
				float drop = s == Susanoo.MAX ? -Susanoo.HOVER - converted.bottom() * scale / 16 : 0;
				SusanooModel made = new SusanooModel(converted.layer().bakeRoot(),
						Identifier.fromNamespaceAndPath("naruto_shippuden", "textures/entities/susanoo/" + owner.id() + "_" + key + ".png"), scale, drop);
				made.seat = converted.seat();
				if (s == Susanoo.MAX && !key.equals(String.valueOf(s)) && made.seat.length > 2) {
					// floating and flying: its user in its head (standing, its feet are on the ground instead)
					SusanooModel posed = new SusanooModel(converted.layer().bakeRoot(), made.texture, scale, 1.0F - made.seat[2] * scale / 16);
					posed.seat = made.seat;
					return posed;
				}
				return made;
			}
			return new SusanooModel(SusanooModels.layer(owner, s).bakeRoot(), Identifier.fromNamespaceAndPath("naruto_shippuden",
					"textures/entities/susanoo/" + owner.id() + ".png"), SCALE[s], 0);
		}
	}

	/** The Complete Susanoo's pose: standing on the ground, floating up in the air, or flying fast. */
	private static String pose(Player player, int stage) {
		if (stage != Susanoo.MAX)
			return "";
		boolean flying = player == Minecraft.getInstance().player ? SusanooFlight.mode == SusanooFlight.Mode.FLY
				: SusanooFlight.gap(player) > Susanoo.HOVER + 2;
		if (!flying)
			return "";
		Vec3 moved = new Vec3(player.getX() - player.xo, player.getY() - player.yo, player.getZ() - player.zo);
		return moved.horizontalDistance() > 0.45 ? "fly" : "float";
	}

	/** Models are built again when resources reload (F3+T), so a new conversion shows without a restart. */
	@SubscribeEvent
	public static void reload(net.neoforged.neoforge.client.event.AddClientReloadListenersEvent event) {
		event.addListener(Identifier.fromNamespaceAndPath("naruto_shippuden", "susanoo_models"),
				(net.minecraft.server.packs.resources.ResourceManagerReloadListener) manager -> MODELS.clear());
	}

	@SubscribeEvent
	public static void render(RenderLivingEvent.Post<?, ?, ?> event) {
		if (!(event.getRenderState() instanceof AvatarRenderState state) || state.isInvisible)
			return;
		LivingEntity entity = ModelSwapRenderers.entity(event);
		if (!(entity instanceof Player player))
			return;
		var vars = NarutoShippudenModVariables.get(player);
		Owner owner = Owner.of(vars);
		int stage = (int) vars.mangekyousharingansusanostage;
		float now = player.tickCount + Minecraft.getInstance().getDeltaTracker().getGameTimeDeltaPartialTick(false);
		float[] change = CHANGES.computeIfAbsent(player.getId(), id -> new float[] { 0, 0, -100 });
		if (change[0] != stage) {
			change[1] = change[0];
			change[0] = stage;
			change[2] = now;
		}
		float since = now - change[2];
		int shown = stage;
		float alpha = 1, grow = 1;
		if (stage == 0 || (stage < change[1] && since < FADE)) {
			// let go (or dropped to a smaller stage): the old one fades and sinks away
			if (since >= FADE || change[1] == 0 || owner == null) {
				if (stage == 0)
					return;
			} else {
				draw(event, state, player, owner, (int) change[1], since, 1 - since / FADE, 1 + since / FADE * 0.15F, 1);
				if (stage == 0)
					return;
			}
		}
		if (owner == null || shown <= 0)
			return;
		float form = Math.min(1, since / FORM);
		if (change[1] < stage) {
			alpha = 0.25F + 0.75F * form;
			grow = 0.6F + 0.4F * (1 - (1 - form) * (1 - form));
		}
		draw(event, state, player, owner, shown, now, alpha, grow, form);
	}

	private static void draw(RenderLivingEvent<?, ?, ?> event, AvatarRenderState state, Player player, Owner owner, int stage, float age, float alpha,
			float grow, float form) {
		State s = new State();
		s.stage = stage;
		s.form = form;
		s.age = player.tickCount + Minecraft.getInstance().getDeltaTracker().getGameTimeDeltaPartialTick(false);
		boolean offHand = state.currentSwing != null && state.currentSwing.hand() == net.minecraft.world.InteractionHand.OFF_HAND;
		s.attack = offHand ? 0 : state.swingAnimation;
		s.offAttack = offHand ? state.swingAnimation : 0;
		s.headYaw = Mth.wrapDegrees(state.yRot);
		s.headPitch = state.xRot;
		s.walkPos = state.walkAnimationPos;
		s.walkSpeed = Math.min(1, state.walkAnimationSpeed);
		String flightPose = pose(player, stage);
		s.flying = flightPose.equals("fly") ? 1 : flightPose.equals("float") ? 0.5F : 0;
		PoseStack pose = event.getPoseStack();
		pose.pushPose();
		pose.rotateDegrees(Axis.YP, 180.0F - state.bodyRot);
		SusanooModel model = model(owner, stage, pose(player, stage));
		pose.translate(0, model.drop, 0);
		float k = model.scale * grow;
		pose.scale(-k, -k, k);
		// from the Humanoid up its user is inside it, in the middle of its body
		if (stage >= 3)
			pose.translate(model.seat[0] / 16, 0, -model.seat[1] / 16);
		int a = Mth.clamp((int) (alpha * 255), 0, 255);
		event.getSubmitNodeCollector().submitModel(model, s, pose, RenderTypes.entityTranslucentCull(model.texture), 0xF000F0,
				OverlayTexture.NO_OVERLAY, (a << 24) | 0xFFFFFF, null, state.outlineColor);
		pose.popPose();
	}

	@SubscribeEvent
	public static void camera(CalculateDetachedCameraDistanceEvent event) {
		Player player = Minecraft.getInstance().player;
		if (player == null)
			return;
		int stage = Susanoo.stage(player);
		if (stage > 0)
			event.setDistance(Math.max(event.getDistance(), CAMERA[stage]));
	}
}
