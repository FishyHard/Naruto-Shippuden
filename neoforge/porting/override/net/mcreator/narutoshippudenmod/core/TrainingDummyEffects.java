package net.mcreator.narutoshippudenmod.core;

import net.mcreator.narutoshippudenmod.entity.NpcEntities.TrainingDummyEntity;

import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;

/** A hit training dummy sheds bits of straw, as a hit armor stand sheds wood. */
@EventBusSubscriber(modid = "naruto_shippuden")
public final class TrainingDummyEffects {
	private TrainingDummyEffects() {
	}

	@SubscribeEvent
	public static void onHit(LivingDamageEvent.Post event) {
		if (event.getEntity().getType() == TrainingDummyEntity.entity && event.getEntity().level() instanceof ServerLevel level)
			level.sendParticles(new BlockParticleOption(ParticleTypes.BLOCK, Blocks.HAY_BLOCK.defaultBlockState()), event.getEntity().getX(),
					event.getEntity().getY() + 1.3, event.getEntity().getZ(), 10, 0.2, 0.3, 0.2, 0.05);
	}
}
