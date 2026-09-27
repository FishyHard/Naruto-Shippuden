package net.mcreator.narutoshippudenmod.procedures;

import net.minecraft.util.DamageSource;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables;
import net.mcreator.narutoshippudenmod.NarutoShippudenMod;

import java.util.Map;

public class AmaterasuEntityCollidesInTheBlockProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure AmaterasuEntityCollidesInTheBlock!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof PlayerEntity) {
			if (NarutoShippudenModVariables.get(entity).mangekyousharingansasukeamaterasulearn == 0) {
				if (NarutoShippudenModVariables.get(entity).MangekyouSharinganSasuke == false
						&& NarutoShippudenModVariables.get(entity).MangekyouSharinganItachi == false) {
					entity.getPersistentData().putBoolean("Amaterasu", (true));
					if (entity instanceof LivingEntity)
						((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.WITHER, (int) 999999, (int) 3, (false), (false)));
					entity.attackEntityFrom(DamageSource.WITHER, (float) 5);
				}
			}
		} else if (!(entity instanceof PlayerEntity)) {
			if (NarutoShippudenModVariables.get(entity).mangekyousharingansasukeamaterasulearn == 0) {
				if (NarutoShippudenModVariables.get(entity).MangekyouSharinganSasuke == false
						&& NarutoShippudenModVariables.get(entity).MangekyouSharinganItachi == false) {
					if (entity instanceof LivingEntity)
						((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.WITHER, (int) 999999, (int) 3, (false), (false)));
					entity.attackEntityFrom(DamageSource.WITHER, (float) 5);
				}
			}
		}
	}
}
