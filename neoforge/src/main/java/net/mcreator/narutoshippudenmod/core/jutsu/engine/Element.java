package net.mcreator.narutoshippudenmod.core.jutsu.engine;

import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.DustParticleOptions;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.Blocks;

/**
 * A chakra nature or kekkei genkai: its colours (for the models), whether it glows (chakra, fire, lightning) or is solid matter
 * (bone, iron sand, wood), its particles and its sounds.
 */
public enum Element {
	FIRE(0xFFFF6A1A, 0xFFFFE08A, true, ParticleTypes.FLAME, ParticleTypes.LARGE_SMOKE, SoundEvents.BLAZE_SHOOT, SoundEvents.GENERIC_EXPLODE.value()),
	WATER(0xFF2F8CFF, 0xFFCFEFFF, true, ParticleTypes.SPLASH, new DustParticleOptions(0x4FA8FF, 1.4F), SoundEvents.PLAYER_SPLASH_HIGH_SPEED,
			SoundEvents.GENERIC_SPLASH),
	WIND(0xFFBDF5E8, 0xFFFFFFFF, true, ParticleTypes.CLOUD, ParticleTypes.GUST, SoundEvents.BREEZE_SHOOT, SoundEvents.WIND_CHARGE_BURST.value()),
	EARTH(0xFF8A6A43, 0xFFD2B07A, false, new BlockParticleOption(ParticleTypes.BLOCK, Blocks.COARSE_DIRT.defaultBlockState()), ParticleTypes.DUST_PLUME,
			SoundEvents.ROOTED_DIRT_BREAK, SoundEvents.DRIPSTONE_BLOCK_BREAK),
	LIGHTNING(0xFF6FCBFF, 0xFFFFFFFF, true, ParticleTypes.ELECTRIC_SPARK, new DustParticleOptions(0xBFEFFF, 1.0F), SoundEvents.BEACON_POWER_SELECT,
			SoundEvents.LIGHTNING_BOLT_IMPACT),
	// kekkei genkai
	BOIL(0xFFF2F2F2, 0xFFFFFFFF, true, ParticleTypes.WHITE_SMOKE, ParticleTypes.CLOUD, SoundEvents.FIRE_EXTINGUISH, SoundEvents.LAVA_EXTINGUISH),
	BONE(0xFFEDE6D2, 0xFFFFFFFF, false, ParticleTypes.WHITE_ASH, new BlockParticleOption(ParticleTypes.BLOCK, Blocks.BONE_BLOCK.defaultBlockState()),
			SoundEvents.SKELETON_SHOOT, SoundEvents.BONE_BLOCK_BREAK),
	DUST(0xFFE9F4FF, 0xFFFFFFFF, true, ParticleTypes.END_ROD, ParticleTypes.WHITE_SMOKE, SoundEvents.BEACON_ACTIVATE, SoundEvents.GENERIC_EXPLODE.value()),
	ICE(0xFF8FD8FF, 0xFFF2FCFF, true, ParticleTypes.SNOWFLAKE, new BlockParticleOption(ParticleTypes.BLOCK, Blocks.PACKED_ICE.defaultBlockState()),
			SoundEvents.POWDER_SNOW_PLACE, SoundEvents.GLASS_BREAK),
	MAGNET(0xFF2B2B33, 0xFF6B6B7E, false, new DustParticleOptions(0x2E2E36, 1.3F),
			new BlockParticleOption(ParticleTypes.BLOCK, Blocks.COAL_BLOCK.defaultBlockState()), SoundEvents.CHAIN_PLACE, SoundEvents.CHAIN_BREAK),
	SMOKE(0xFF8C8C8C, 0xFFD6D6D6, false, ParticleTypes.LARGE_SMOKE, ParticleTypes.CAMPFIRE_COSY_SMOKE, SoundEvents.FIRE_EXTINGUISH,
			SoundEvents.FIRECHARGE_USE),
	STEEL(0xFF9EA8B2, 0xFFE8EEF4, false, ParticleTypes.CRIT, new BlockParticleOption(ParticleTypes.BLOCK, Blocks.IRON_BLOCK.defaultBlockState()),
			SoundEvents.ANVIL_PLACE, SoundEvents.ANVIL_LAND),
	STORM(0xFF4FB2FF, 0xFFE6F6FF, true, ParticleTypes.ELECTRIC_SPARK, ParticleTypes.END_ROD, SoundEvents.BEACON_POWER_SELECT,
			SoundEvents.LIGHTNING_BOLT_IMPACT),
	SWIFT(0xFFFFF6C8, 0xFFFFFFFF, true, ParticleTypes.END_ROD, ParticleTypes.CLOUD, SoundEvents.BREEZE_JUMP, SoundEvents.BREEZE_LAND),
	WOOD(0xFF7A5230, 0xFFB5D96A, false, new BlockParticleOption(ParticleTypes.BLOCK, Blocks.OAK_LEAVES.defaultBlockState()),
			new BlockParticleOption(ParticleTypes.BLOCK, Blocks.OAK_LOG.defaultBlockState()), SoundEvents.WOOD_PLACE, SoundEvents.WOOD_BREAK);

	/** ARGB colour of the outer body and of the bright core. */
	public final int color, core;
	/** Chakra and energy glow in the dark; bone, sand, steel and wood are lit like blocks. */
	public final boolean glows;
	public final ParticleOptions trail, puff;
	public final SoundEvent cast, impact;

	Element(int color, int core, boolean glows, ParticleOptions trail, ParticleOptions puff, SoundEvent cast, SoundEvent impact) {
		this.color = color;
		this.core = core;
		this.glows = glows;
		this.trail = trail;
		this.puff = puff;
		this.cast = cast;
		this.impact = impact;
	}
}
