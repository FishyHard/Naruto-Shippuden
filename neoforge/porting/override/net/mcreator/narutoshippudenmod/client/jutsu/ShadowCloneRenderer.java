package net.mcreator.narutoshippudenmod.client.jutsu;

import net.mcreator.narutoshippudenmod.entity.JutsuEntities.ShadowCloneEntity;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.entity.ArmorModelSet;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.state.HumanoidRenderState;
import net.minecraft.client.resources.DefaultPlayerSkin;
import net.minecraft.resources.Identifier;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

/** A shadow clone looks exactly like the one who made it: their skin, their armour, what they hold. */
@EventBusSubscriber(modid = "naruto_shippuden", value = Dist.CLIENT)
public class ShadowCloneRenderer extends HumanoidMobRenderer<ShadowCloneEntity.CustomEntity, ShadowCloneRenderer.State, HumanoidModel<ShadowCloneRenderer.State>> {
	public ShadowCloneRenderer(EntityRendererProvider.Context context) {
		super(context, new HumanoidModel<>(context.bakeLayer(ModelLayers.PLAYER)), 0.5F);
		addLayer(new HumanoidArmorLayer<>(this, ArmorModelSet.bake(ModelLayers.PLAYER_ARMOR, context.getModelSet(), HumanoidModel::new),
				context.getEquipmentRenderer()));
	}

	@SubscribeEvent
	public static void register(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(ShadowCloneEntity.entity, ShadowCloneRenderer::new);
	}

	public static class State extends HumanoidRenderState {
		Identifier skin = DefaultPlayerSkin.getDefaultTexture();
	}

	@Override
	public State createRenderState() {
		return new State();
	}

	@Override
	public void extractRenderState(ShadowCloneEntity.CustomEntity clone, State state, float partialTicks) {
		super.extractRenderState(clone, state, partialTicks);
		state.skin = clone.getOwner() instanceof AbstractClientPlayer owner ? owner.getSkin().body().texturePath()
				: DefaultPlayerSkin.get(clone.getUUID()).body().texturePath();
	}

	@Override
	public Identifier getTextureLocation(State state) {
		return state.skin;
	}
}
