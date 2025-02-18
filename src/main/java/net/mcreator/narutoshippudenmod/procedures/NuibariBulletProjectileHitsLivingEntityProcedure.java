package net.mcreator.narutoshippudenmod.procedures;

import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.narutoshippudenmod.potion.NuibariStringPotionEffect;
import net.mcreator.narutoshippudenmod.NarutoShippudenMod;

import java.util.Map;

public class NuibariBulletProjectileHitsLivingEntityProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure NuibariBulletProjectileHitsLivingEntity!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(NuibariStringPotionEffect.potion, (int) 200, (int) 1, (false), (false)));
	}
}
