package net.mcreator.narutoshippudenmod.procedures;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.narutoshippudenmod.NarutoShippudenMod;

import java.util.Map;

public class ShadowImitationEntityOnEntityTickUpdateProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure ShadowImitationEntityOnEntityTickUpdate!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		(entity.getRidingEntity()).rotationYaw = (float) ((((entity instanceof TameableEntity)
				? ((TameableEntity) entity).getOwner()
				: null).rotationYaw));
		entity.setRenderYawOffset(entity.rotationYaw);
		entity.prevRotationYaw = entity.rotationYaw;
		if (entity instanceof LivingEntity) {
			((LivingEntity) entity).prevRenderYawOffset = entity.rotationYaw;
			((LivingEntity) entity).rotationYawHead = entity.rotationYaw;
			((LivingEntity) entity).prevRotationYawHead = entity.rotationYaw;
		}
		(entity.getRidingEntity()).rotationPitch = (float) ((((entity instanceof TameableEntity)
				? ((TameableEntity) entity).getOwner()
				: null).rotationPitch));
		if ((entity.getRidingEntity()) instanceof LivingEntity)
			((LivingEntity) (entity.getRidingEntity())).addPotionEffect(new EffectInstance(Effects.SLOWNESS, (int) 60, (int) 99, (false), (false)));
	}
}
