package net.mcreator.narutoshippudenmod.client;

import net.minecraft.util.Mth;

/**
 * Where the buttons of a choice wheel (jutsu, dojutsu) sit: round an oval, starting at the top, grown until no two buttons
 * (w by 20) touch, so every name stays readable.
 */
public record WheelLayout(int count, int width, int rx, int ry) {
	public static WheelLayout of(int count, int width) {
		int rx = width / 2 + 24, ry = 44;
		for (int tries = 0; tries < 100 && crowded(count, width, rx, ry); tries++) {
			rx += 4;
			ry += 2;
		}
		return new WheelLayout(count, width, rx, ry);
	}

	private static float angle(int i, int count) {
		return (float) (-Math.PI / 2 + i * 2 * Math.PI / count);
	}

	private static boolean crowded(int n, int w, int rx, int ry) {
		for (int i = 0; i < n; i++)
			for (int j = i + 1; j < n; j++) {
				float dx = (Mth.cos(angle(i, n)) - Mth.cos(angle(j, n))) * rx, dy = (Mth.sin(angle(i, n)) - Mth.sin(angle(j, n))) * ry;
				if (Math.abs(dx) < w + 6 && Math.abs(dy) < 24)
					return true;
			}
		return false;
	}

	/** The left edge of button i on a screen this wide. */
	public int x(int i, int screenWidth) {
		return screenWidth / 2 + Math.round(Mth.cos(angle(i, count)) * rx) - width / 2;
	}

	/** The top edge of button i on a screen this tall. */
	public int y(int i, int screenHeight) {
		return screenHeight / 2 + Math.round(Mth.sin(angle(i, count)) * ry) - 10;
	}

	/** Where text under the wheel can start. */
	public int bottom(int screenHeight) {
		return screenHeight / 2 + ry + 22;
	}

	/** The button the mouse points at (by angle, outside the middle), or -1. */
	public int hovered(double mouseX, double mouseY, int screenWidth, int screenHeight) {
		double dx = mouseX - screenWidth / 2.0, dy = mouseY - screenHeight / 2.0;
		if (dx * dx + dy * dy <= 18 * 18)
			return -1;
		return Math.floorMod((int) Math.round((Math.atan2(dy, dx) + Math.PI / 2) / (2 * Math.PI) * count), count);
	}
}
