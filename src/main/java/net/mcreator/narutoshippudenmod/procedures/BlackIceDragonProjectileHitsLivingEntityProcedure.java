package net.mcreator.narutoshippudenmod.procedures;

import net.minecraft.util.DamageSource;
import net.minecraft.entity.Entity;

import net.mcreator.narutoshippudenmod.NarutoShippudenMod;

import java.util.Map;

public class BlackIceDragonProjectileHitsLivingEntityProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure BlackIceDragonProjectileHitsLivingEntity!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.setMotion(0, 3, 0);
		entity.attackEntityFrom(DamageSource.GENERIC, (float) 15);
	}
}
