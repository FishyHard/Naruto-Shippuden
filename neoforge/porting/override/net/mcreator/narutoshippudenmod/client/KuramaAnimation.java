package net.mcreator.narutoshippudenmod.client;

import net.mcreator.narutoshippudenmod.core.ModelSwapRenderers;
import net.mcreator.narutoshippudenmod.entity.SummonEntities.KuramaEntity;
import net.mcreator.narutoshippudenmod.entity.renderer.SummonRenderers.KuramaRenderer.Modelkurama;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.entity.state.EntityRenderState;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.util.Mth;

/**
 * Kurama's procedural animation (the 1.16 model only turned its head and swung its legs): a slow diagonal gait, head
 * tracking with breathing and a walking nod, nine tails swaying out of phase, a flinch when hurt and a roar (head up,
 * tails flared, front legs braced) when it fires a tailed beast bomb.
 */
public final class KuramaAnimation {
	private static final float DEG = Mth.DEG_TO_RAD;

	private KuramaAnimation() {
	}

	public static void animate(Modelkurama m, EntityRenderState state) {
		float age = state.ageInTicks;
		float walkPos = 0, walk = 0, headYaw = 0, headPitch = 0;
		boolean hurt = false;
		if (state instanceof LivingEntityRenderState living) {
			walkPos = living.walkAnimationPos;
			walk = Math.min(living.walkAnimationSpeed, 1);
			headYaw = living.yRot;
			headPitch = living.xRot;
			hurt = living.hasRedOverlay;
		}
		float roar = 0;
		if (state.getRenderData(ModelSwapRenderers.ENTITY) instanceof KuramaEntity.CustomEntity kurama) {
			float t = age - kurama.roarTick;
			if (t >= 0 && t < KuramaEntity.ROAR_TICKS)
				roar = t < 6 ? ease(t / 6) : t < 16 ? 1 : 1 - ease((t - 16) / (KuramaEntity.ROAR_TICKS - 16));
		}

		// Legs: diagonal pairs, a slow heavy cadence, a little sideways roll; front legs brace during the roar.
		float phase = walkPos * 0.45F;
		float stride = 0.55F * walk;
		float a = Mth.cos(phase) * stride, b = Mth.cos(phase + Mth.PI) * stride;
		float roll = Mth.sin(phase) * 0.05F * walk;
		m.RightFrontLeg.xRot = a - 0.18F * roar;
		m.LeftBackLeg.xRot = a;
		m.LeftFrontLeg.xRot = b - 0.18F * roar;
		m.RightBackLeg.xRot = b;
		m.RightFrontLeg.zRot = m.RightBackLeg.zRot = roll;
		m.LeftFrontLeg.zRot = m.LeftBackLeg.zRot = -roll;

		// Head: follows the look direction within the neck's reach, breathes, nods with the steps, flinches, roars.
		float breathe = Mth.sin(age * 0.06F) * 0.04F;
		float nod = Mth.cos(phase * 2) * 0.05F * walk;
		m.Head.yRot = Mth.clamp(headYaw, -40, 40) * DEG * (1 - roar * 0.5F);
		m.Head.xRot = Mth.clamp(headPitch, -25, 25) * DEG + breathe + nod - (hurt ? 0.12F : 0) - 0.45F * roar;
		m.Head.zRot = Mth.sin(age * 0.035F) * 0.03F;

		// Tails: each sways on its own rhythm, faster and wider while walking; they lift and fan out in the roar.
		ModelPart[] tails = {m.Tail1, m.Tail2, m.Tail3, m.Tail4, m.Tail5, m.Tail6, m.Tail7, m.Tail8, m.Tail9};
		float sway = 0.12F + 0.1F * walk + (hurt ? 0.08F : 0);
		for (int i = 0; i < tails.length; i++) {
			ModelPart tail = tails[i];
			float side = Math.abs(tail.x - 0.5F) < 1 ? 0 : Math.signum(tail.x);
			tail.yRot = Mth.sin(age * 0.07F + i * 0.8F) * sway;
			tail.xRot = Mth.sin(age * 0.055F + i * 1.4F) * 0.08F + Mth.cos(phase + i * 0.5F) * 0.06F * walk + 0.3F * roar;
			tail.zRot = Mth.sin(age * 0.045F + i * 2.1F) * 0.05F + side * 0.25F * roar;
		}
	}

	private static float ease(float t) {
		return t * t * (3 - 2 * t);
	}
}
