package net.mcreator.narutoshippudenmod.procedures;

import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.monster.piglin.PiglinEntity;
import net.minecraft.entity.monster.piglin.PiglinBruteEntity;
import net.minecraft.entity.monster.ZombifiedPiglinEntity;
import net.minecraft.entity.monster.ZombieVillagerEntity;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.entity.monster.WitchEntity;
import net.minecraft.entity.monster.VindicatorEntity;
import net.minecraft.entity.monster.SkeletonEntity;
import net.minecraft.entity.monster.PillagerEntity;
import net.minecraft.entity.monster.IllusionerEntity;
import net.minecraft.entity.monster.HuskEntity;
import net.minecraft.entity.monster.CreeperEntity;
import net.minecraft.entity.merchant.villager.VillagerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.narutoshippudenmod.potion.DrowningPotionEffect;
import net.mcreator.narutoshippudenmod.entity.ShikamaruEntity;
import net.mcreator.narutoshippudenmod.entity.AsumaEntity;
import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables;
import net.mcreator.narutoshippudenmod.NarutoShippudenMod;

import java.util.Map;

public class DrowningWaterBlobTechniqueProjectileHitsLivingEntityProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NarutoShippudenMod.LOGGER
						.warn("Failed to load dependency entity for procedure DrowningWaterBlobTechniqueProjectileHitsLivingEntity!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof AsumaEntity.CustomEntity || entity instanceof ShikamaruEntity.CustomEntity || entity instanceof CreeperEntity
				|| entity instanceof HuskEntity || entity instanceof IllusionerEntity || entity instanceof PiglinEntity
				|| entity instanceof PiglinBruteEntity || entity instanceof PillagerEntity || entity instanceof SkeletonEntity
				|| entity instanceof VillagerEntity || entity instanceof VindicatorEntity || entity instanceof WitchEntity
				|| entity instanceof ZombieEntity || entity instanceof ZombieVillagerEntity || entity instanceof ZombifiedPiglinEntity) {
			entity.getPersistentData().putBoolean("waterblob", (true));
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(DrowningPotionEffect.potion, (int) 300, (int) 1, (false), (false)));
		}
		if (!(entity instanceof AsumaEntity.CustomEntity || entity instanceof ShikamaruEntity.CustomEntity || entity instanceof CreeperEntity
				|| entity instanceof HuskEntity || entity instanceof IllusionerEntity || entity instanceof PiglinEntity
				|| entity instanceof PiglinBruteEntity || entity instanceof PillagerEntity || entity instanceof SkeletonEntity
				|| entity instanceof VillagerEntity || entity instanceof VindicatorEntity || entity instanceof WitchEntity
				|| entity instanceof ZombieEntity || entity instanceof ZombieVillagerEntity || entity instanceof ZombifiedPiglinEntity
				|| entity instanceof PlayerEntity)) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(DrowningPotionEffect.potion, (int) 300, (int) 1, (false), (false)));
		}
		if (entity instanceof PlayerEntity) {
			{
				boolean _setval = (true);
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.waterblob = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(DrowningPotionEffect.potion, (int) 300, (int) 1, (false), (false)));
		}
	}
}
