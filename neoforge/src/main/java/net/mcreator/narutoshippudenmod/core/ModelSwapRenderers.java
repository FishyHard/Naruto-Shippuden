package net.mcreator.narutoshippudenmod.core;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.player.PlayerModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.state.AvatarRenderState;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.resources.Identifier;
import net.minecraft.util.context.ContextKey;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Pose;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RenderLivingEvent;
import net.neoforged.neoforge.client.renderstate.RegisterRenderStateModifiersEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * Draws a living entity with a different model and/or texture from inside a {@link RenderLivingEvent}
 * (replacement for Kleiders Custom Renderer). Models are baked once per layer and reused.
 */
@EventBusSubscriber(modid = "naruto_shippuden", value = Dist.CLIENT)
@SuppressWarnings({"rawtypes", "unchecked"})
public final class ModelSwapRenderers {
	/** The entity a render state was extracted from; RenderLivingEvent only exposes the state. */
	public static final ContextKey<LivingEntity> ENTITY = new ContextKey<>(Identifier.fromNamespaceAndPath("naruto_shippuden", "entity"));
	private static final Map<ModelLayerLocation, EntityModel> MODELS = new HashMap<>();
	private static PlayerModel overlayModel;
	/** The eye overlay with its head's boxes moved down by n skin pixels (n = -3..3), its pivot at the neck as ever, so the
	 * eyes turn and nod with the head (moving the pivot instead swung them off the face as the head turned). */
	private static final Map<Integer, PlayerModel> SHIFTED = new HashMap<>();

	private ModelSwapRenderers() {
	}

	@SubscribeEvent
	public static void attachEntity(RegisterRenderStateModifiersEvent event) {
		event.registerEntityModifier((Class) LivingEntityRenderer.class,
				(entity, state) -> ((LivingEntityRenderState) state).setRenderData(ENTITY, (LivingEntity) entity));
	}

	/** The entity being rendered by this event. */
	public static LivingEntity entity(RenderLivingEvent<?, ?, ?> event) {
		return event.getRenderState().getRenderData(ENTITY);
	}

	/** Kept for the old call sites; the swaps no longer create renderers of their own. */
	public static boolean isOwnRenderer(Object renderer) {
		return false;
	}

	/** Draws the player with a custom model and texture (was KleidersPlayerRenderer). */
	public static void renderPlayerAs(RenderLivingEvent<?, ?, ?> event, String texture, ModelLayerLocation layer,
			Function<ModelPart, ? extends EntityModel<?>> factory) {
		// an invisible player (Tunneling Fang, a potion) shows no jutsu form either
		if (event.getRenderState().isInvisible)
			return;
		draw(event, MODELS.computeIfAbsent(layer, l -> factory.apply(Minecraft.getInstance().getEntityModels().bakeLayer(l))),
				RenderTypes.entityTranslucent(Identifier.parse(texture)), 1.0F);
	}

	/** Draws a mob with a custom model and texture (was KleidersEntityRenderer). */
	public static void renderMobAs(RenderLivingEvent<?, ?, ?> event, String texture, ModelLayerLocation layer,
			Function<ModelPart, ? extends EntityModel<?>> factory) {
		renderPlayerAs(event, texture, layer, factory);
	}

	/** Eye textures asked for in this frame's Pre event, drawn in Post (which never comes when a transformation replaces the model). */
	private static final Map<LivingEntityRenderState, java.util.List<String>> EYES = new java.util.IdentityHashMap<>();

	@SubscribeEvent(priority = net.neoforged.bus.api.EventPriority.HIGHEST)
	public static void forgetEyes(RenderLivingEvent.Pre<?, ?, ?> event) {
		EYES.remove(event.getRenderState());
	}

	@SubscribeEvent
	public static void drawEyes(RenderLivingEvent.Post<?, ?, ?> event) {
		java.util.List<String> textures = EYES.remove(event.getRenderState());
		if (textures == null)
			return;
		// the Mangekyou is the Sharingan, further: with both open only it shows (two eyes on one face fight for the same pixels, and
		// which won depended on the camera, so players saw different eyes)
		if (textures.stream().anyMatch(t -> t.contains("/mangekyou_sharingan/")))
			textures.removeIf(t -> t.contains("/dojutsu/sharingan/"));
		if (overlayModel == null)
			overlayModel = new PlayerModel(Minecraft.getInstance().getEntityModels().bakeLayer(ModelLayers.PLAYER), false);
		// the eyes lie exactly on the skin, so they need the decal render type (depth offset) to show on top of it
		// the eyes moved up or down the face by whole skin pixels (Info Card > Dojutsu > Position), to sit on a skin whose own
		// eyes are higher or lower than the dojutsu textures'
		LivingEntity entity = entity(event);
		float offset = entity == null ? 0 : (float) net.mcreator.narutoshippudenmod.NarutoShippudenModVariables.get(entity).Eyes_Offset;
		// a pixel up or down at most: further, the eyes leave the face's eye rows
		int shift = Math.max(-1, Math.min(1, Math.round(offset)));
		PlayerModel model = shift == 0 ? overlayModel : SHIFTED.computeIfAbsent(shift, ModelSwapRenderers::shiftedEyes);
		for (String texture : textures)
			draw(event, model, RenderTypes.entityCutoutZOffset(Identifier.parse(texture)), 0.9375F);
	}

	/**
	 * Draws the player model again with an eye texture (was InternalPlayerRenderer), once the player is drawn. Not while invisible
	 * or turned into something else, and a closed eye's look (the resting Byakugan) gives way to any open dojutsu.
	 */
	public static void renderDojutsu(RenderLivingEvent<?, ?, ?> event, String texture) {
		if (!(event.getRenderState() instanceof AvatarRenderState state) || state.isInvisible)
			return;
		LivingEntity entity = entity(event);
		if (texture.contains("_not_active") && entity != null) {
			var vars = net.mcreator.narutoshippudenmod.NarutoShippudenModVariables.get(entity);
			if (Eyes.EYES.stream().anyMatch(eye -> eye.active().test(vars)))
				return;
		}
		EYES.computeIfAbsent(state, s -> new java.util.ArrayList<>()).add(texture);
	}

	private static PlayerModel shiftedEyes(int n) {
		net.minecraft.client.model.geom.builders.CubeDeformation none = net.minecraft.client.model.geom.builders.CubeDeformation.NONE;
		net.minecraft.client.model.geom.builders.MeshDefinition mesh = PlayerModel.createMesh(none, false);
		net.minecraft.client.model.geom.builders.PartDefinition head = mesh.getRoot().addOrReplaceChild("head",
				net.minecraft.client.model.geom.builders.CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F + n, -4.0F, 8.0F, 8.0F, 8.0F, none),
				net.minecraft.client.model.geom.PartPose.ZERO);
		head.addOrReplaceChild("hat", net.minecraft.client.model.geom.builders.CubeListBuilder.create().texOffs(32, 0)
				.addBox(-4.0F, -8.0F + n, -4.0F, 8.0F, 8.0F, 8.0F, none.extend(0.5F)), net.minecraft.client.model.geom.PartPose.ZERO);
		return new PlayerModel(net.minecraft.client.model.geom.builders.LayerDefinition.create(mesh, 64, 64).bakeRoot(), false);
	}

	/**
	 * The body's turn, as the player's own renderer does it: facing, and lying along the flight when gliding or swimming, so
	 * eyes and Susanoo stay on the body in every pose.
	 */
	private static void rotations(LivingEntityRenderState state, PoseStack pose) {
		if (!state.hasPose(Pose.SLEEPING))
			pose.rotateDegrees(Axis.YP, 180.0F - state.bodyRot);
		if (!(state instanceof AvatarRenderState avatar))
			return;
		if (avatar.isFallFlying) {
			if (!avatar.isAutoSpinAttack)
				pose.rotateDegrees(Axis.XP, avatar.fallFlyingScale() * (-90.0F - avatar.xRot));
			if (avatar.shouldApplyFlyingYRot)
				pose.rotate(Axis.YP, avatar.flyingYRot);
		} else if (avatar.swimAmount > 0) {
			pose.rotateDegrees(Axis.XP, net.minecraft.util.Mth.lerp(avatar.swimAmount, 0.0F, avatar.isInWater ? -90.0F - avatar.xRot : -90.0F));
			if (avatar.isVisuallySwimming)
				pose.translate(0.0F, -1.0F, 0.3F);
		}
	}

	/** Same transforms LivingEntityRenderer applies before drawing its own model. */
	private static void draw(RenderLivingEvent<?, ?, ?> event, EntityModel model, net.minecraft.client.renderer.rendertype.RenderType renderType, float modelScale) {
		LivingEntityRenderState state = event.getRenderState();
		PoseStack pose = event.getPoseStack();
		pose.pushPose();
		pose.scale(state.scale, state.scale, state.scale);
		rotations(state, pose);
		pose.scale(-1.0F, -1.0F, 1.0F);
		pose.scale(modelScale, modelScale, modelScale);
		pose.translate(0.0F, -1.501F, 0.0F);
		model.setupAnim(state);
		event.getSubmitNodeCollector().submitModel(model, state, pose, renderType, state.lightCoords,
				LivingEntityRenderer.getOverlayCoords(state, 0.0F), state.outlineColor);
		pose.popPose();
	}
}
