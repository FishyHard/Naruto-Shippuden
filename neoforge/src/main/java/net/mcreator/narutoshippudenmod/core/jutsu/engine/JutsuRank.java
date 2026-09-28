package net.mcreator.narutoshippudenmod.core.jutsu.engine;

/**
 * Jutsu ranks as in the series, E (academy basics) to S (forbidden-level): what learning one costs in JP, the Ninjutsu it needs,
 * its chakra cost and cooldown. Cooldowns shrink with the player's shinobi rank (Academy Student to Kage).
 */
public enum JutsuRank {
	E(3, 0, 25, 40),
	D(6, 5, 50, 80),
	C(12, 12, 100, 160),
	B(20, 22, 180, 280),
	A(32, 35, 300, 480),
	S(50, 50, 500, 900);

	private static final float[] RANK_COOLDOWN = { 1.25F, 1.0F, 0.85F, 0.7F, 0.55F };
	public final int jp, ninjutsu, chakra, cooldown;

	JutsuRank(int jp, int ninjutsu, int chakra, int cooldown) {
		this.jp = jp;
		this.ninjutsu = ninjutsu;
		this.chakra = chakra;
		this.cooldown = cooldown;
	}

	/** Cooldown in ticks for Academy Student, Genin, Chunin, Jonin and Kage. */
	public int[] cooldowns() {
		int[] ticks = new int[RANK_COOLDOWN.length];
		for (int i = 0; i < ticks.length; i++)
			ticks[i] = Math.round(cooldown * RANK_COOLDOWN[i]);
		return ticks;
	}
}
