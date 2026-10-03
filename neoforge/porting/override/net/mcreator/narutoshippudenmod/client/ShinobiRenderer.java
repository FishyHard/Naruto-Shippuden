package net.mcreator.narutoshippudenmod.client;

import net.mcreator.narutoshippudenmod.core.jutsu.ShinobiAI;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.ArmorModelSet;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.client.renderer.entity.state.EntityRenderState;
import net.minecraft.client.renderer.entity.state.HumanoidRenderState;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

import org.jspecify.annotations.Nullable;

import java.util.function.Function;

/**
 * The hidden village shinobi, drawn on the player's model: one of six skins of their village (by their variant,
 * ShinobiAI.texture), what they wear as real armour (the forehead protector, the jonin vest: ShinobiAI.dress), what they hold,
 * and both hands raised together while they weave signs.
 */
public class ShinobiRenderer extends MobRenderer<Mob, ShinobiRenderer.State, HumanoidModel<ShinobiRenderer.State>> {
	public static class State extends HumanoidRenderState {
		/** 0 to 1: how far into weaving signs. */
		public float signs;
		/** Its village's look for its variant. */
		public @Nullable Identifier skin;
	}

	private final Identifier texture;

	/**
	 * Called by the generated renderers (rule shinobi_renderer). Their old model is no longer drawn: the skins are player skins,
	 * and the player's model takes armour; layer, model and parts are kept only for that call.
	 */
	@SuppressWarnings("unchecked")
	public static <M extends EntityModel<EntityRenderState>> void register(EntityRenderersEvent.RegisterRenderers event, EntityType<?> type,
			ModelLayerLocation layer, Function<ModelPart, M> model, Function<M, ModelPart[]> parts, Identifier texture) {
		event.registerEntityRenderer((EntityType<Mob>) type, context -> new ShinobiRenderer(context, texture));
	}

	ShinobiRenderer(EntityRendererProvider.Context context, Identifier texture) {
		super(context, new Posed(context.bakeLayer(ModelLayers.PLAYER)), 0.5F);
		this.texture = texture;
		addLayer(new HumanoidArmorLayer<>(this, ArmorModelSet.bake(ModelLayers.PLAYER_ARMOR, context.getModelSet(), HumanoidModel::new),
				context.getEquipmentRenderer()));
		addLayer(new ItemInHandLayer<>(this));
	}

	@Override
	public State createRenderState() {
		return new State();
	}

	@Override
	public void extractRenderState(Mob entity, State state, float partialTicks) {
		super.extractRenderState(entity, state, partialTicks);
		HumanoidMobRenderer.extractHumanoidRenderState(entity, state, partialTicks, itemModelResolver);
		state.signs = ShinobiAI.signs(entity, partialTicks);
		state.skin = ShinobiAI.texture(entity);
	}

	@Override
	public Identifier getTextureLocation(State state) {
		return state.skin != null ? state.skin : texture;
	}

	/** The player's model, with the sign-weaving pose over its own (walk, swing, held item). */
	static class Posed extends HumanoidModel<State> {
		Posed(ModelPart root) {
			super(root);
		}

		@Override
		public void setupAnim(State s) {
			super.setupAnim(s);
			// weaving signs: both hands up in front of the chest, pressed together, changing sign
			float c = s.signs;
			if (c > 0) {
				float change = Mth.sin(s.ageInTicks * 1.3F) * 0.08F;
				rightArm.xRot = Mth.lerp(c, rightArm.xRot, -1.2F + change);
				leftArm.xRot = Mth.lerp(c, leftArm.xRot, -1.2F - change);
				rightArm.yRot = Mth.lerp(c, rightArm.yRot, -0.55F);
				leftArm.yRot = Mth.lerp(c, leftArm.yRot, 0.55F);
				rightArm.zRot = Mth.lerp(c, rightArm.zRot, 0);
				leftArm.zRot = Mth.lerp(c, leftArm.zRot, 0);
			}
		}
	}
}
