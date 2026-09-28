package net.mcreator.narutoshippudenmod.core.jutsu.engine;

import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.DustParticleOptions;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.Blocks;

/** A chakra nature: its colours (for the glowing models), its particles and its sounds. */
public enum Element {
	FIRE(0xFFFF6A1A, 0xFFFFE08A, ParticleTypes.FLAME, ParticleTypes.LARGE_SMOKE, SoundEvents.BLAZE_SHOOT, SoundEvents.GENERIC_EXPLODE.value()),
	WATER(0xFF2F8CFF, 0xFFCFEFFF, ParticleTypes.SPLASH, new DustParticleOptions(0x4FA8FF, 1.4F), SoundEvents.PLAYER_SPLASH_HIGH_SPEED,
			SoundEvents.GENERIC_SPLASH),
	WIND(0xFFBDF5E8, 0xFFFFFFFF, ParticleTypes.CLOUD, ParticleTypes.GUST, SoundEvents.BREEZE_SHOOT, SoundEvents.WIND_CHARGE_BURST.value()),
	EARTH(0xFF8A6A43, 0xFFD2B07A, new BlockParticleOption(ParticleTypes.BLOCK, Blocks.COARSE_DIRT.defaultBlockState()), ParticleTypes.DUST_PLUME,
			SoundEvents.ROOTED_DIRT_BREAK, SoundEvents.DRIPSTONE_BLOCK_BREAK),
	LIGHTNING(0xFF6FCBFF, 0xFFFFFFFF, ParticleTypes.ELECTRIC_SPARK, new DustParticleOptions(0xBFEFFF, 1.0F), SoundEvents.BEACON_POWER_SELECT,
			SoundEvents.LIGHTNING_BOLT_IMPACT);

	/** ARGB colour of the outer glow and of the bright core. */
	public final int color, core;
	public final ParticleOptions trail, puff;
	public final SoundEvent cast, impact;

	Element(int color, int core, ParticleOptions trail, ParticleOptions puff, SoundEvent cast, SoundEvent impact) {
		this.color = color;
		this.core = core;
		this.trail = trail;
		this.puff = puff;
		this.cast = cast;
		this.impact = impact;
	}
}
