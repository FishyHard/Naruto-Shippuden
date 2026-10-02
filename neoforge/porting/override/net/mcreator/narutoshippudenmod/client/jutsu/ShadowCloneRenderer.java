package net.mcreator.narutoshippudenmod.client.jutsu;

import net.mcreator.narutoshippudenmod.entity.JutsuEntities.ShadowCloneEntity;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.ArmorModelSet;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.client.renderer.entity.state.HumanoidRenderState;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import net.minecraft.client.resources.DefaultPlayerSkin;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.player.PlayerModelType;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

/**
 * A shadow clone looks exactly like the one who made it: their skin on their model (slim-armed skins on slim arms, or their
 * arms' empty texture shows as holes), their armour, what they hold. A MobRenderer, not a HumanoidMobRenderer: that one's
 * AgeableMobRenderer puts its own model back in submit, undoing the choice of arms.
 */
@EventBusSubscriber(modid = "naruto_shippuden", value = Dist.CLIENT)
public class ShadowCloneRenderer extends MobRenderer<ShadowCloneEntity.CustomEntity, ShadowCloneRenderer.State, HumanoidModel<ShadowCloneRenderer.State>> {
	private final HumanoidModel<State> wide, slim;

	public ShadowCloneRenderer(EntityRendererProvider.Context context) {
		super(context, new HumanoidModel<>(context.bakeLayer(ModelLayers.PLAYER)), 0.5F);
		this.wide = this.model;
		this.slim = new HumanoidModel<>(context.bakeLayer(ModelLayers.PLAYER_SLIM));
		addLayer(new ItemInHandLayer<>(this));
		addLayer(new HumanoidArmorLayer<>(this, ArmorModelSet.bake(ModelLayers.PLAYER_ARMOR, context.getModelSet(), HumanoidModel::new),
				context.getEquipmentRenderer()));
	}

	@SubscribeEvent
	public static void register(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(ShadowCloneEntity.entity, ShadowCloneRenderer::new);
	}

	public static class State extends HumanoidRenderState {
		Identifier skin = DefaultPlayerSkin.getDefaultTexture();
		boolean slim;
	}

	@Override
	public State createRenderState() {
		return new State();
	}

	@Override
	public void extractRenderState(ShadowCloneEntity.CustomEntity clone, State state, float partialTicks) {
		super.extractRenderState(clone, state, partialTicks);
		HumanoidMobRenderer.extractHumanoidRenderState(clone, state, partialTicks, this.itemModelResolver);
		var skin = clone.getOwner() instanceof AbstractClientPlayer owner ? owner.getSkin() : DefaultPlayerSkin.get(clone.getUUID());
		state.skin = skin.body().texturePath();
		state.slim = skin.model() == PlayerModelType.SLIM;
	}

	@Override
	public void submit(State state, PoseStack poseStack, SubmitNodeCollector collector, CameraRenderState camera) {
		this.model = state.slim ? slim : wide;
		super.submit(state, poseStack, collector, camera);
	}

	@Override
	public Identifier getTextureLocation(State state) {
		return state.skin;
	}
}
