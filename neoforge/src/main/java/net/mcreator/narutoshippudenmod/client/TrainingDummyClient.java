package net.mcreator.narutoshippudenmod.client;

import net.mcreator.narutoshippudenmod.entity.NpcEntities.TrainingDummyEntity;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

/**
 * The training dummy, in the vanilla manner of the armor stand: a broad plank base and a stout post, a straw body and head
 * bound with red rope, straw arms on a wooden crossbar. Hit, it rocks back on its post and settles (no red flash: it is
 * straw), the way an armor stand wobbles.
 */
public final class TrainingDummyClient {
	public static final ModelLayerLocation LAYER = new ModelLayerLocation(Identifier.fromNamespaceAndPath("naruto_shippuden", "training_dummy"), "main");
	private static final Identifier TEXTURE = Identifier.parse("naruto_shippuden:textures/entities/training_dummy.png");

	private TrainingDummyClient() {
	}

	@SuppressWarnings("unchecked")
	public static void register(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer((EntityType<Mob>) (EntityType<?>) TrainingDummyEntity.entity, Renderer::new);
	}

	public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(LAYER, Model::createLayer);
	}

	public static class State extends LivingEntityRenderState {
		/** Ticks since the last hit (with the partial tick), or -1 when it stands still. */
		float sinceHit = -1;
	}

	public static class Model extends EntityModel<State> {
		private final ModelPart body;

		public Model(ModelPart root) {
			super(root);
			this.body = root.getChild("body");
		}

		public static LayerDefinition createLayer() {
			MeshDefinition mesh = new MeshDefinition();
			PartDefinition root = mesh.getRoot();
			root.addOrReplaceChild("stand", CubeListBuilder.create()
					.texOffs(0, 0).addBox(-6, -2, -6, 12, 2, 12)          // the plank base
					.texOffs(48, 0).addBox(-1, -16, -1, 2, 14, 2),        // the post
					PartPose.offset(0, 24, 0));
			root.addOrReplaceChild("body", CubeListBuilder.create()
					.texOffs(0, 16).addBox(-4, -10, -2.5F, 8, 10, 5)       // straw body
					.texOffs(26, 16).addBox(-4.5F, -3, -3, 9, 1, 6)        // rope belt
					.texOffs(0, 31).addBox(-9, -9, -1, 18, 2, 2)           // crossbar
					.texOffs(40, 31).addBox(-10, -9.5F, -1.5F, 4, 3, 3)    // straw arms
					.texOffs(40, 37).addBox(6, -9.5F, -1.5F, 4, 3, 3)
					.texOffs(54, 31).addBox(-1, -11, -1, 2, 1, 2)          // neck
					.texOffs(0, 43).addBox(-3, -17, -3, 6, 6, 6)           // straw head
					.texOffs(24, 43).addBox(-3.5F, -14, -3.5F, 7, 1, 7),   // rope band round the head
					PartPose.offset(0, 8, 0));                              // pivots on the top of the post
			return LayerDefinition.create(mesh, 64, 64);
		}

		@Override
		public void setupAnim(State state) {
			super.setupAnim(state);
			body.xRot = 0;
			body.zRot = 0;
			if (state.sinceHit >= 0) {
				// rocks back, swings past upright, settles: a damped swing over half a second
				float t = state.sinceHit;
				float swing = Mth.sin(t * 0.9F) * 0.32F * Math.max(0, 1 - t / 10);
				body.xRot = -swing;
				body.zRot = swing * 0.25F;
			}
		}
	}

	static class Renderer extends MobRenderer<Mob, State, Model> {
		Renderer(EntityRendererProvider.Context context) {
			super(context, new Model(context.bakeLayer(LAYER)), 0.5F);
		}

		@Override
		public State createRenderState() {
			return new State();
		}

		@Override
		public void extractRenderState(Mob dummy, State state, float partialTicks) {
			super.extractRenderState(dummy, state, partialTicks);
			state.sinceHit = dummy.hurtTime > 0 ? 10 - dummy.hurtTime + partialTicks : -1;
			state.hasRedOverlay = false;
		}

		@Override
		public Identifier getTextureLocation(State state) {
			return TEXTURE;
		}
	}
}
