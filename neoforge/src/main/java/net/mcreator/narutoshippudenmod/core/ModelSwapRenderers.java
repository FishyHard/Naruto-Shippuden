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
		draw(event, MODELS.computeIfAbsent(layer, l -> factory.apply(Minecraft.getInstance().getEntityModels().bakeLayer(l))),
				RenderTypes.entityTranslucent(Identifier.parse(texture)), 1.0F);
	}

	/** Draws a mob with a custom model and texture (was KleidersEntityRenderer). */
	public static void renderMobAs(RenderLivingEvent<?, ?, ?> event, String texture, ModelLayerLocation layer,
			Function<ModelPart, ? extends EntityModel<?>> factory) {
		renderPlayerAs(event, texture, layer, factory);
	}

	/** Draws the player model again with an overlay texture, used for dojutsu eyes (was InternalPlayerRenderer). */
	public static void renderDojutsu(RenderLivingEvent<?, ?, ?> event, String texture) {
		if (!(event.getRenderState() instanceof AvatarRenderState))
			return;
		if (overlayModel == null)
			overlayModel = new PlayerModel(Minecraft.getInstance().getEntityModels().bakeLayer(ModelLayers.PLAYER), false);
		// the eyes lie exactly on the skin, so they need the decal render type (depth offset) to show on top of it
		draw(event, overlayModel, RenderTypes.entityCutoutZOffset(Identifier.parse(texture)), 0.9375F);
	}

	/** Same transforms LivingEntityRenderer applies before drawing its own model. */
	private static void draw(RenderLivingEvent<?, ?, ?> event, EntityModel model, net.minecraft.client.renderer.rendertype.RenderType renderType, float modelScale) {
		LivingEntityRenderState state = event.getRenderState();
		PoseStack pose = event.getPoseStack();
		pose.pushPose();
		pose.scale(state.scale, state.scale, state.scale);
		if (!state.hasPose(Pose.SLEEPING))
			pose.rotateDegrees(Axis.YP, 180.0F - state.bodyRot);
		pose.scale(-1.0F, -1.0F, 1.0F);
		pose.scale(modelScale, modelScale, modelScale);
		pose.translate(0.0F, -1.501F, 0.0F);
		model.setupAnim(state);
		event.getSubmitNodeCollector().submitModel(model, state, pose, renderType, state.lightCoords,
				LivingEntityRenderer.getOverlayCoords(state, 0.0F), state.outlineColor);
		pose.popPose();
	}
}
