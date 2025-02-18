package net.mcreator.narutoshippudenmod.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.narutoshippudenmod.block.AmaterasuBlock;
import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables;
import net.mcreator.narutoshippudenmod.NarutoShippudenMod;

import java.util.Map;

public class AmaterasuFlameProjectileHitsLivingEntityProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure AmaterasuFlameProjectileHitsLivingEntity!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure AmaterasuFlameProjectileHitsLivingEntity!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof PlayerEntity) {
			if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).mangekyousharingansasukeamaterasulearn == 0) {
				if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).MangekyouSharinganSasuke == false
						&& (entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NarutoShippudenModVariables.PlayerVariables())).MangekyouSharinganItachi == false) {
					entity.getPersistentData().putBoolean("Amaterasu", (true));
					if (entity instanceof LivingEntity)
						((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.WITHER, (int) 999999, (int) 3, (false), (false)));
					entity.attackEntityFrom(DamageSource.WITHER, (float) 5);
				}
			}
		} else if (!(entity instanceof PlayerEntity)) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.WITHER, (int) 999999, (int) 3, (false), (false)));
			entity.attackEntityFrom(DamageSource.WITHER, (float) 5);
		}
		if (world.isAirBlock(new BlockPos(entity.getPosX(), entity.getPosY(), entity.getPosZ()))) {
			world.setBlockState(new BlockPos(entity.getPosX(), entity.getPosY(), entity.getPosZ()), AmaterasuBlock.block.getDefaultState(), 3);
		} else if (!world.isAirBlock(new BlockPos(entity.getPosX(), entity.getPosY(), entity.getPosZ()))) {
			if (!world.getBlockState(new BlockPos(entity.getPosX(), entity.getPosY(), entity.getPosZ())).isSolid()) {
				world.setBlockState(new BlockPos(entity.getPosX(), entity.getPosY(), entity.getPosZ()), AmaterasuBlock.block.getDefaultState(), 3);
			}
		}
	}
}
