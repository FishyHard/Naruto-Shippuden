package net.mcreator.narutoshippudenmod.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.ArmorModelSet;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.state.EntityRenderState;
import net.minecraft.client.renderer.entity.state.HumanoidRenderState;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

import java.util.function.Function;

/** The renderer shapes the mod uses, shared by every entity instead of one anonymous class each. */
@SuppressWarnings({"unchecked", "rawtypes"})
@EventBusSubscriber(modid = "naruto_shippuden", value = Dist.CLIENT)
public final class ModRenderers {
	/** 1.16 humanoid layout (64x32, left limbs mirror the right ones); the NPC skins use it, not the 64x64 player one. */
	public static final ModelLayerLocation LEGACY_HUMANOID = new ModelLayerLocation(Identifier.fromNamespaceAndPath("naruto_shippuden", "legacy_humanoid"), "main");

	private ModRenderers() {
	}

	@SubscribeEvent
	public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(LEGACY_HUMANOID, () -> LayerDefinition.create(HumanoidModel.createMesh(CubeDeformation.NONE, 0.0F), 64, 32));
	}

	/** Mob drawn with one of the mod's models and a fixed texture. */
	public static void mob(EntityRenderersEvent.RegisterRenderers event, EntityType<?> type, ModelLayerLocation layer,
			Function<ModelPart, ? extends EntityModel<EntityRenderState>> model, float shadow, Identifier texture) {
		event.registerEntityRenderer((EntityType<Mob>) type, context -> new ModelMobRenderer(context, model.apply(context.bakeLayer(layer)), shadow, texture));
	}

	/** Player-shaped mob (shinobi NPCs, clones), optionally wearing armor. */
	public static void humanoid(EntityRenderersEvent.RegisterRenderers event, EntityType<?> type, float shadow, Identifier texture, boolean armor) {
		event.registerEntityRenderer((EntityType<Mob>) type, context -> new PlayerShapedRenderer(context, shadow, texture, armor));
	}

	/** Projectile drawn with a model, turned to its flight direction. */
	public static void projectile(EntityRenderersEvent.RegisterRenderers event, EntityType<?> type, ModelLayerLocation layer,
			Function<ModelPart, ? extends EntityModel<EntityRenderState>> model, Identifier texture) {
		event.registerEntityRenderer((EntityType<Entity>) type, context -> new ProjectileRenderer(context, model.apply(context.bakeLayer(layer)), texture));
	}

	/** Projectile drawn as its item sprite. */
	public static void sprite(EntityRenderersEvent.RegisterRenderers event, EntityType<?> type) {
		event.registerEntityRenderer((EntityType) type, context -> new ThrownItemRenderer(context));
	}

	static class ModelMobRenderer extends MobRenderer<Mob, LivingEntityRenderState, EntityModel<EntityRenderState>> {
		private final Identifier texture;

		ModelMobRenderer(EntityRendererProvider.Context context, EntityModel<EntityRenderState> model, float shadow, Identifier texture) {
			super(context, model, shadow);
			this.texture = texture;
		}

		@Override
		public LivingEntityRenderState createRenderState() {
			return new LivingEntityRenderState();
		}

		@Override
		public Identifier getTextureLocation(LivingEntityRenderState state) {
			return texture;
		}
	}

	static class PlayerShapedRenderer extends HumanoidMobRenderer<Mob, HumanoidRenderState, HumanoidModel<HumanoidRenderState>> {
		private final Identifier texture;

		PlayerShapedRenderer(EntityRendererProvider.Context context, float shadow, Identifier texture, boolean armor) {
			super(context, new HumanoidModel<>(context.bakeLayer(LEGACY_HUMANOID)), shadow);
			this.texture = texture;
			if (armor)
				this.addLayer(new HumanoidArmorLayer<>(this, ArmorModelSet.bake(ModelLayers.PLAYER_ARMOR, context.getModelSet(), HumanoidModel::new),
						context.getEquipmentRenderer()));
		}

		@Override
		public HumanoidRenderState createRenderState() {
			return new HumanoidRenderState();
		}

		@Override
		public Identifier getTextureLocation(HumanoidRenderState state) {
			return texture;
		}
	}

	public static class ProjectileState extends EntityRenderState {
		public float yRot;
		public float xRot;
	}

	static class ProjectileRenderer extends EntityRenderer<Entity, ProjectileState> {
		private final EntityModel<EntityRenderState> model;
		private final Identifier texture;

		ProjectileRenderer(EntityRendererProvider.Context context, EntityModel<EntityRenderState> model, Identifier texture) {
			super(context);
			this.model = model;
			this.texture = texture;
		}

		@Override
		public ProjectileState createRenderState() {
			return new ProjectileState();
		}

		@Override
		public void extractRenderState(Entity entity, ProjectileState state, float partialTicks) {
			super.extractRenderState(entity, state, partialTicks);
			state.yRot = entity.getYRot(partialTicks);
			state.xRot = entity.getXRot(partialTicks);
		}

		@Override
		public void submit(ProjectileState state, PoseStack poseStack, SubmitNodeCollector collector, CameraRenderState camera) {
			poseStack.pushPose();
			poseStack.rotateDegrees(Axis.YP, state.yRot - 90.0F);
			poseStack.rotateDegrees(Axis.ZP, 90.0F + state.xRot);
			collector.submitModel(model, state, poseStack, texture, state.lightCoords, OverlayTexture.NO_OVERLAY, state.outlineColor);
			poseStack.popPose();
			super.submit(state, poseStack, collector, camera);
		}
	}
}
