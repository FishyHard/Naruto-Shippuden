package net.mcreator.narutoshippudenmod.story;

import net.neoforged.neoforge.common.ModConfigSpec;

/** Where the quest tracker sits on this player's screen and how big it is (naruto_shippuden-client.toml). */
public final class TrackerConfig {
	public static final ModConfigSpec SPEC;
	public static final ModConfigSpec.ConfigValue<String> CORNER;
	public static final ModConfigSpec.DoubleValue SCALE;
	public static final ModConfigSpec.IntValue OFFSET_X, OFFSET_Y;
	public static final ModConfigSpec.BooleanValue HIDDEN;
	public static final String[] CORNERS = {"top_right", "top_left", "bottom_right", "bottom_left"};

	static {
		ModConfigSpec.Builder b = new ModConfigSpec.Builder();
		b.comment("The quest tracker (J hides it, K opens its settings)").push("quest_tracker");
		CORNER = b.comment("Screen corner: top_right, top_left, bottom_right or bottom_left").define("corner", "top_right");
		SCALE = b.comment("Size, 1.0 = the font's own size").defineInRange("scale", 1.0, 0.5, 1.5);
		OFFSET_X = b.comment("Pixels in from the corner, sideways").defineInRange("offset_x", 4, 0, 400);
		OFFSET_Y = b.comment("Pixels in from the corner, up or down").defineInRange("offset_y", 4, 0, 400);
		HIDDEN = b.comment("Hidden").define("hidden", false);
		b.pop();
		SPEC = b.build();
	}

	private TrackerConfig() {
	}
}
