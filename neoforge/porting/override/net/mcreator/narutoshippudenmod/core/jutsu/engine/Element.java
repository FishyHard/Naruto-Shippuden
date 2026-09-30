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
			new BlockParticleOption(ParticleTypes.BLOCK, Blocks.OAK_LOG.defaultBlockState()), SoundEvents.WOOD_PLACE, SoundEvents.WOOD_BREAK),
	// clans
	/** Hyuga chakra: the Gentle Fist, Rotation and the twin lions. */
	CHAKRA(0xFF7FC4FF, 0xFFF0FAFF, true, new DustParticleOptions(0x9ED6FF, 1.0F), ParticleTypes.END_ROD, SoundEvents.BREEZE_SHOOT,
			SoundEvents.PLAYER_ATTACK_KNOCKBACK),
	/** Aburame destruction bugs. */
	INSECT(0xFF2A2B22, 0xFF6B7A3C, false, new DustParticleOptions(0x1C1C16, 1.0F), new DustParticleOptions(0x3B4128, 1.1F),
			SoundEvents.BEEHIVE_WORK, SoundEvents.SILVERFISH_HURT),
	/** Yamanaka mind techniques: a violet glow between minds. */
	MIND(0xFFB27CFF, 0xFFF3E6FF, true, new DustParticleOptions(0xC08CFF, 0.9F), ParticleTypes.ENCHANT, SoundEvents.ILLUSIONER_CAST_SPELL,
			SoundEvents.ILLUSIONER_MIRROR_MOVE),
	/** Chinoike blood: dark red. */
	BLOOD(0xFF9A0F1E, 0xFFFF5A5A, false, new DustParticleOptions(0x8C0A14, 1.1F), new DustParticleOptions(0xC21A28, 1.4F), SoundEvents.SLIME_SQUISH,
			SoundEvents.PLAYER_HURT_SWEET_BERRY_BUSH),
	/** Nara shadows: flat black on the ground, ink where they rise. */
	SHADOW(0xFF0C0C10, 0xFF26262E, false, new DustParticleOptions(0x0E0E12, 1.2F), ParticleTypes.SQUID_INK, SoundEvents.SCULK_CATALYST_BLOOM,
			SoundEvents.SCULK_BLOCK_SPREAD),
	/** The Eight Gates' green aura and steam. */
	GATE(0xFF5CFF86, 0xFFE8FFEC, true, new DustParticleOptions(0x6CFF94, 1.3F), ParticleTypes.CLOUD, SoundEvents.WARDEN_HEARTBEAT,
			SoundEvents.GENERIC_EXPLODE.value()),
	/** The Gate of Death's blood-red steam (Night Guy). */
	NIGHT(0xFFFF2E2E, 0xFFFFD6C8, true, new DustParticleOptions(0xFF2A2A, 1.6F), ParticleTypes.CLOUD, SoundEvents.WARDEN_SONIC_BOOM,
			SoundEvents.GENERIC_EXPLODE.value()),
	/** Uzumaki sealing chakra: the golden chains. */
	SEAL(0xFFFFC23D, 0xFFFFF5CC, true, new DustParticleOptions(0xFFCC4D, 1.0F), ParticleTypes.END_ROD, SoundEvents.CHAIN_PLACE,
			SoundEvents.AMETHYST_BLOCK_BREAK),
	/** Beast chakra (Inuzuka, Tenro, Izuno): grey fangs and claws. */
	BEAST(0xFFB8B0A4, 0xFFFFFFFF, false, new DustParticleOptions(0xA8A198, 1.2F), ParticleTypes.POOF, SoundEvents.EVOKER_FANGS_ATTACK,
			SoundEvents.PLAYER_ATTACK_SWEEP),
	// dojutsu
	/** Amaterasu's black flames, which nothing puts out. */
	AMATERASU(0xFF120E16, 0xFF3A1250, false, new DustParticleOptions(0x0C0A10, 1.5F), ParticleTypes.LARGE_SMOKE, SoundEvents.FIRECHARGE_USE,
			SoundEvents.FIRE_AMBIENT),
	/** Kamui's space-time swirl. */
	KAMUI(0xFF7A62A8, 0xFFE6DDFF, true, ParticleTypes.PORTAL, ParticleTypes.REVERSE_PORTAL, SoundEvents.ENDERMAN_TELEPORT, SoundEvents.ENDERMAN_TELEPORT),
	/** Sharingan genjutsu: red and black. */
	GENJUTSU(0xFFD4142A, 0xFFFFD0D0, true, new DustParticleOptions(0xD4142A, 1.0F), ParticleTypes.SQUID_INK, SoundEvents.ENDERMAN_STARE,
			SoundEvents.PHANTOM_BITE),
	/** The Kokugan: Isshiki's black rods and cubes, red light and dark dust. */
	KOKUGAN(0xFF1C1A22, 0xFFFF4A4A, false, new DustParticleOptions(0x16141C, 1.1F), new DustParticleOptions(0xFF3C3C, 0.8F),
			SoundEvents.ILLUSIONER_MIRROR_MOVE, SoundEvents.ANVIL_LAND);


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
