package net.mcreator.narutoshippudenmod.world.chikyu;

import net.mcreator.narutoshippudenmod.compat.Registration;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeResolver;
import net.minecraft.world.level.biome.BiomeSource;
import net.minecraft.world.level.biome.Climate;

import java.util.stream.Stream;

/**
 * Chikyū's biomes follow its fixed land: the river (fish, squid, sugar cane), the flat ground the village stands on
 * and the river's valley (plains, the grass of the village preview), and the woods everywhere else.
 */
public class ChikyuBiomeSource extends BiomeSource implements BiomeResolver {
	public static final MapCodec<ChikyuBiomeSource> CODEC = RecordCodecBuilder.mapCodec(i -> i.group(
			Biome.CODEC.fieldOf("woods").forGetter(s -> s.woods),
			Biome.CODEC.fieldOf("flat").forGetter(s -> s.flat),
			Biome.CODEC.fieldOf("river").forGetter(s -> s.river)).apply(i, i.stable(ChikyuBiomeSource::new)));

	private final Holder<Biome> woods, flat, river;

	public static void register() {
		Registration.add(Registries.BIOME_SOURCE, "chikyu", () -> CODEC, null);
	}

	public ChikyuBiomeSource(Holder<Biome> woods, Holder<Biome> flat, Holder<Biome> river) {
		this.woods = woods;
		this.flat = flat;
		this.river = river;
	}

	@Override
	protected MapCodec<ChikyuBiomeSource> codec() {
		return CODEC;
	}

	@Override
	protected Stream<Holder<Biome>> collectPossibleBiomes() {
		return Stream.of(this.woods, this.flat, this.river);
	}

	@Override
	public BiomeResolver createResolver(Climate.Sampler sampler) {
		return this;
	}

	@Override
	public Holder<Biome> getNoiseBiome(int quartX, int quartY, int quartZ) {
		double x = (quartX << 2) + 2, z = (quartZ << 2) + 2;
		double r = LeafVillage.riverDistance(x, z);
		if (r <= LeafVillage.RIVER_W + 1)
			return this.river;
		return ChikyuChunkGenerator.outside(x, z) <= 0 ? this.flat : this.woods;
	}
}
