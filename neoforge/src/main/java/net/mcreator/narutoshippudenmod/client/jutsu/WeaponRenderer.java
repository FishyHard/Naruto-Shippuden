package net.mcreator.narutoshippudenmod.client.jutsu;

import net.mcreator.narutoshippudenmod.compat.ModArrow;
import net.mcreator.narutoshippudenmod.core.jutsu.engine.Element;
import net.mcreator.narutoshippudenmod.item.ClanItems.FumaShurikenClanItem;
import net.mcreator.narutoshippudenmod.item.ClanItems.ShurikenClanItem;
import net.mcreator.narutoshippudenmod.item.ClanItems.ToroiUniqueFumaShurikenClanItem;
import net.mcreator.narutoshippudenmod.item.ProjectileItems.ExplosiveKunaiBulletItem;
import net.mcreator.narutoshippudenmod.item.ProjectileItems.FlyingThunderGodKunaiBulletItem;
import net.mcreator.narutoshippudenmod.item.ProjectileItems.FumaShurikenBulletItem;
import net.mcreator.narutoshippudenmod.item.ProjectileItems.KunaiBulletItem;
import net.mcreator.narutoshippudenmod.item.ProjectileItems.PoisonKunaiBulletItem;
import net.mcreator.narutoshippudenmod.item.ProjectileItems.ShurikenBulletItem;
import net.mcreator.narutoshippudenmod.item.ProjectileItems.ToroiUniqueFumaShurikenBulletItem;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.state.EntityRenderState;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.EntityType;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

import java.util.function.Consumer;

/**
 * Thrown shuriken and kunai drawn exactly like the Fuma clan's shuriken jutsu (same model, size and chakra-steel material)
 * instead of flat sprites. Shuriken spin in
 * flight; kunai fly point first (poison kunai have a purple blade, explosive kunai a paper tag, the Flying Thunder God kunai its
 * three prongs).
 */
@EventBusSubscriber(modid = "naruto_shippuden", value = Dist.CLIENT)
public class WeaponRenderer extends EntityRenderer<ModArrow, WeaponRenderer.State> {
	private static final int HANDLE = 0xFF2B2B33, POISON = 0xFF9C6FC4, PAPER = 0xFFEDE3C8;

	enum Kind {
		SHURIKEN, FUMA, TOROI, KUNAI, POISON_KUNAI, EXPLOSIVE_KUNAI, THUNDER_GOD_KUNAI
	}

	private final Kind kind;
	private static ModelPart shuriken, blade, handle, tag, prongs;

	public WeaponRenderer(EntityRendererProvider.Context context, Kind kind) {
		super(context);
		this.kind = kind;
	}

	@SubscribeEvent
	public static void register(EntityRenderersEvent.RegisterRenderers event) {
		reg(event, ShurikenBulletItem.arrow, Kind.SHURIKEN);
		reg(event, ShurikenClanItem.arrow, Kind.SHURIKEN);
		reg(event, FumaShurikenBulletItem.arrow, Kind.FUMA);
		reg(event, FumaShurikenClanItem.arrow, Kind.FUMA);
		reg(event, ToroiUniqueFumaShurikenBulletItem.arrow, Kind.TOROI);
		reg(event, ToroiUniqueFumaShurikenClanItem.arrow, Kind.TOROI);
		reg(event, KunaiBulletItem.arrow, Kind.KUNAI);
		reg(event, PoisonKunaiBulletItem.arrow, Kind.POISON_KUNAI);
		reg(event, ExplosiveKunaiBulletItem.arrow, Kind.EXPLOSIVE_KUNAI);
		reg(event, FlyingThunderGodKunaiBulletItem.arrow, Kind.THUNDER_GOD_KUNAI);
	}

	@SuppressWarnings("unchecked")
	private static void reg(EntityRenderersEvent.RegisterRenderers event, EntityType<?> type, Kind kind) {
		event.registerEntityRenderer((EntityType<ModArrow>) type, context -> new WeaponRenderer(context, kind));
	}

	private static ModelPart bake(Consumer<PartDefinition> shape) {
		MeshDefinition mesh = new MeshDefinition();
		shape.accept(mesh.getRoot());
		return LayerDefinition.create(mesh, 128, 128).bakeRoot();
	}

	private static void models() {
		if (shuriken != null)
			return;
		shuriken = bake(JutsuProjectileRenderer::shuriken);
		// the kunai, point towards +Z: a leaf blade with a diamond cross-section, 8 long
		blade = bake(root -> {
			float[][] steps = { { 2.6F, 2.2F }, { 2.4F, 2 }, { 1.9F, 1.8F }, { 1.3F, 1.5F }, { 0.7F, 1.2F } };
			float z = 0;
			for (int i = 0; i < steps.length; i++) {
				float w = steps[i][0], len = steps[i][1];
				JutsuProjectileRenderer.box(root, "b" + i, PartPose.rotation(0, 0, 0.785F), -w / 2, -w / 2, z, w, w, len);
				z += len;
			}
			// the flat of the blade
			JutsuProjectileRenderer.box(root, "flat", 0, -0.2F, 0, 0.1F, 0.4F, z);
		});
		handle = bake(root -> {
			JutsuProjectileRenderer.box(root, "grip", -0.5F, -0.5F, -5, 1, 1, 5);
			JutsuProjectileRenderer.box(root, "guard", PartPose.rotation(0, 0, 0.785F), -0.8F, -0.8F, -0.4F, 1.6F, 1.6F, 0.6F);
			// the ring at the end
			JutsuProjectileRenderer.box(root, "ringT", -1.3F, 1, -7.5F, 2.6F, 0.5F, 0.5F);
			JutsuProjectileRenderer.box(root, "ringB", -1.3F, -1.5F, -7.5F, 2.6F, 0.5F, 0.5F);
			JutsuProjectileRenderer.box(root, "ringL", 0.8F, -1.5F, -7.5F, 0.5F, 3, 0.5F);
			JutsuProjectileRenderer.box(root, "ringR", -1.3F, -1.5F, -7.5F, 0.5F, 3, 0.5F);
			JutsuProjectileRenderer.box(root, "neck", -0.3F, -0.3F, -7, 0.6F, 0.6F, 2);
		});
		tag = bake(root -> JutsuProjectileRenderer.box(root, "tag", PartPose.rotation(0.3F, 0, 0), -1.4F, -4, -5, 2.8F, 4, 0.2F));
		prongs = bake(root -> {
			JutsuProjectileRenderer.box(root, "l", PartPose.rotation(0, 0.5F, 0), -0.5F, -0.4F, 0, 1, 0.8F, 4.5F);
			JutsuProjectileRenderer.box(root, "r", PartPose.rotation(0, -0.5F, 0), -0.5F, -0.4F, 0, 1, 0.8F, 4.5F);
		});
	}

	public static class State extends EntityRenderState {
		float yRot, xRot;
		boolean stuck;
	}

	@Override
	public State createRenderState() {
		return new State();
	}

	@Override
	public void extractRenderState(ModArrow arrow, State state, float partialTicks) {
		super.extractRenderState(arrow, state, partialTicks);
		state.yRot = arrow.getYRot(partialTicks);
		state.xRot = arrow.getXRot(partialTicks);
		state.stuck = arrow.getDeltaMovement().lengthSqr() < 1.0E-4;
	}

	/** The same chakra-steel look as the Fuma clan's shuriken jutsu. */
	private static void draw(SubmitNodeCollector collector, ModelPart part, PoseStack pose, int light, int color) {
		collector.submitModelPart(part, pose, RenderTypes.entityTranslucent(JutsuProjectileRenderer.CHAKRA), light, OverlayTexture.NO_OVERLAY, null,
				0xF2000000 | color & 0xFFFFFF);
	}

	@Override
	public void submit(State state, PoseStack pose, SubmitNodeCollector collector, CameraRenderState camera) {
		models();
		pose.pushPose();
		pose.rotateDegrees(Axis.YP, state.yRot);
		int light = state.lightCoords;
		switch (kind) {
			case SHURIKEN, FUMA, TOROI -> {
				// sized like the jutsu ones (Shuriken Barrage, Fuma Shuriken, Toroi's), flat and spinning
				float size = kind == Kind.SHURIKEN ? 0.5F : kind == Kind.FUMA ? 1.3F : 1.6F;
				pose.rotateDegrees(Axis.XP, -state.xRot * 0.3F);
				pose.scale(size * 0.9F, size * 0.9F, size * 0.9F);
				if (!state.stuck)
					pose.rotateDegrees(Axis.YP, -state.ageInTicks * 50);
				JutsuProjectileRenderer.glow(collector, shuriken, pose, kind == Kind.TOROI ? Element.MAGNET : Element.STEEL, state.ageInTicks, 0, light);
			}
			default -> {
				pose.rotateDegrees(Axis.XP, -state.xRot);
				pose.scale(0.6F, 0.6F, 0.6F);
				pose.translate(0, 0, -2 / 16F);
				draw(collector, blade, pose, light, kind == Kind.POISON_KUNAI ? POISON : Element.STEEL.color);
				draw(collector, handle, pose, light, HANDLE);
				if (kind == Kind.EXPLOSIVE_KUNAI)
					draw(collector, tag, pose, light, PAPER);
				if (kind == Kind.THUNDER_GOD_KUNAI)
					draw(collector, prongs, pose, light, Element.STEEL.color);
			}
		}
		pose.popPose();
		super.submit(state, pose, collector, camera);
	}
}
