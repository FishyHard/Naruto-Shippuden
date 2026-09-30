package net.mcreator.narutoshippudenmod.client;

import net.mcreator.narutoshippudenmod.core.jutsu.ShinobiAI;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.state.ArmedEntityRenderState;
import net.minecraft.client.renderer.entity.state.EntityRenderState;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

import java.util.function.Function;

/**
 * The hidden village shinobi: their own model and skin, with arms that show what they do (the model itself only swings them while
 * walking): both hands raised together while weaving signs, a swing when they strike or throw, and the kunai or tanto they hold.
 */
public class ShinobiRenderer extends MobRenderer<Mob, ShinobiRenderer.State, EntityModel<EntityRenderState>> {
	public static class State extends ArmedEntityRenderState {
		/** 0 to 1: how far into weaving signs. */
		public float signs;
	}

	private final Identifier texture;

	/** parts: the model's frame (the arms hang from it), head, body, right arm, left arm. */
	@SuppressWarnings("unchecked")
	public static <M extends EntityModel<EntityRenderState>> void register(EntityRenderersEvent.RegisterRenderers event, EntityType<?> type,
			ModelLayerLocation layer, Function<ModelPart, M> model, Function<M, ModelPart[]> parts, Identifier texture) {
		event.registerEntityRenderer((EntityType<Mob>) type, context -> {
			M built = model.apply(context.bakeLayer(layer));
			return new ShinobiRenderer(context, built, parts.apply(built), texture);
		});
	}

	ShinobiRenderer(EntityRendererProvider.Context context, EntityModel<EntityRenderState> model, ModelPart[] parts, Identifier texture) {
		super(context, new Posed(model, parts), 0.5F);
		this.texture = texture;
		addLayer(new Held(this, parts));
	}

	@Override
	public State createRenderState() {
		return new State();
	}

	@Override
	public void extractRenderState(Mob entity, State state, float partialTicks) {
		super.extractRenderState(entity, state, partialTicks);
		ArmedEntityRenderState.extractArmedEntityRenderState(entity, state, itemModelResolver, partialTicks);
		state.signs = ShinobiAI.signs(entity, partialTicks);
	}

	@Override
	public Identifier getTextureLocation(State state) {
		return texture;
	}

	/** The shinobi's own model, posed on top of its walk. */
	static class Posed extends EntityModel<EntityRenderState> {
		private final EntityModel<EntityRenderState> model;
		private final ModelPart head, body, right, left;

		Posed(EntityModel<EntityRenderState> model, ModelPart[] parts) {
			super(model.root());
			this.model = model;
			this.head = parts[1];
			this.body = parts[2];
			this.right = parts[3];
			this.left = parts[4];
		}

		@Override
		public void setupAnim(EntityRenderState state) {
			model.setupAnim(state);
			if (!(state instanceof State s))
				return;
			// holding a weapon: the arm is raised a little, like a player's
			if (!s.rightHandItemState.isEmpty())
				right.xRot = right.xRot * 0.5F - Mth.PI / 10;
			float swing = s.swingAnimation;
			if (swing > 0) {
				body.yRot = Mth.sin(Mth.sqrt(swing) * Mth.TWO_PI) * 0.2F;
				right.yRot += body.yRot;
				left.yRot += body.yRot;
				left.xRot += body.yRot;
				float f = 1 - swing;
				f = 1 - f * f * f * f;
				float lift = Mth.sin(f * Mth.PI), follow = Mth.sin(swing * Mth.PI) * -(head.xRot - 0.7F) * 0.75F;
				right.xRot -= lift * 1.2F + follow;
				right.yRot += body.yRot * 2;
				right.zRot += Mth.sin(swing * Mth.PI) * -0.4F;
			}
			// weaving signs: both hands up in front of the chest, pressed together, changing sign
			float c = s.signs;
			if (c > 0) {
				float change = Mth.sin(s.ageInTicks * 1.3F) * 0.08F;
				right.xRot = Mth.lerp(c, right.xRot, -1.2F + change);
				left.xRot = Mth.lerp(c, left.xRot, -1.2F - change);
				right.yRot = Mth.lerp(c, right.yRot, -0.55F);
				left.yRot = Mth.lerp(c, left.yRot, 0.55F);
				right.zRot = Mth.lerp(c, right.zRot, 0);
				left.zRot = Mth.lerp(c, left.zRot, 0);
			}
		}
	}

	/** The kunai or tanto in the right hand, placed like vanilla's held items. */
	static class Held extends RenderLayer<State, EntityModel<EntityRenderState>> {
		private final ModelPart frame, arm;

		Held(ShinobiRenderer renderer, ModelPart[] parts) {
			super(renderer);
			this.frame = parts[0];
			this.arm = parts[3];
		}

		@Override
		public void submit(PoseStack pose, SubmitNodeCollector collector, int light, State state, float yRot, float xRot) {
			if (state.rightHandItemState.isEmpty() || state.signs > 0.5F)
				return;
			pose.pushPose();
			getParentModel().root().translateAndRotate(pose);
			frame.translateAndRotate(pose);
			arm.translateAndRotate(pose);
			pose.rotateDegrees(Axis.XP, -90);
			pose.rotateDegrees(Axis.YP, 180);
			pose.translate(1 / 16F, 2 / 16F, -10 / 16F);
			state.rightHandItemState.submit(pose, collector, light, OverlayTexture.NO_OVERLAY, state.outlineColor);
			pose.popPose();
		}
	}
}
