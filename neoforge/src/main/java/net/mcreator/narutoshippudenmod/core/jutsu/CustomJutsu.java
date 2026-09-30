package net.mcreator.narutoshippudenmod.core.jutsu;

import static net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.burst;
import static net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.channel;
import static net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.cone;
import static net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.damage;
import static net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.lookPoint;
import static net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.puff;
import static net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.shoot;
import static net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.sound;
import static net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.spray;
import static net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.turned;

import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables;
import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables.PlayerVariables;
import net.mcreator.narutoshippudenmod.core.jutsu.Jutsus.Jutsu;
import net.mcreator.narutoshippudenmod.core.jutsu.Jutsus.Technique;
import net.mcreator.narutoshippudenmod.core.jutsu.engine.Element;
import net.mcreator.narutoshippudenmod.core.jutsu.engine.JutsuProjectile;
import net.mcreator.narutoshippudenmod.core.jutsu.engine.JutsuProjectile.Shape;
import net.mcreator.narutoshippudenmod.core.jutsu.engine.JutsuRank;
import net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.jspecify.annotations.Nullable;

/**
 * Custom jutsu, made in the Jutsu Creation page of the info card: a name, a release the player has, a form (how it flies or
 * spreads), a size, a speed and a power. The design gets a {@link JutsuRank} from those choices, which sets its JP price, chakra,
 * cooldown and the Ninjutsu it needs, exactly like the wiki jutsu. A made jutsu is not an item: it joins the wheel of that
 * release's technique, after the release's own jutsu. The element (colours, particles, side effect) comes from the release.
 */
@EventBusSubscriber(modid = "naruto_shippuden")
public final class CustomJutsu {
	public static final int SLOTS = 4;
	public static final String[] NATURES = { "fire", "water", "wind", "earth", "lightning" };
	public static final String[] KEKKEI_GENKAI = { "boil", "bone", "dust", "ice", "magnet", "smoke", "steel", "storm", "swift", "typhoon", "wood" };
	public static final String[] SIZES = { "Small", "Medium", "Large" };
	public static final String[] SPEEDS = { "Slow", "Normal", "Fast" };
	public static final int MAX_POWER = 5;
	public static final int NAME_LENGTH = 32;

	private CustomJutsu() {
	}

	/** How the jutsu takes shape. weight: how much it adds to the rank; damage: of each hit, relative to a sphere. */
	public enum Form {
		BULLETS("Bullets", "Three quick bullets", 0, 0.45F),
		SPHERE("Sphere", "A great ball that bursts", 0, 1),
		SHURIKEN("Shuriken", "A spinning blade that cuts through", 0, 0.8F),
		BEAST("Beast", "A beast that hunts the enemy", 1, 0.85F),
		DRAGON("Dragon", "A dragon that rams through everything", 1, 1.1F),
		WAVE("Wave", "A wide wave rolling forward", 1, 0.6F),
		STREAM("Stream", "A stream breathed out for two seconds", 1, 0.3F),
		BURST("Burst", "A blast all around the caster", 1, 0.9F),
		RAIN("Rain", "A rain of bullets where you look", 1, 0.5F);

		public final String title, description;
		final int weight;
		final float damage;

		Form(String title, String description, int weight, float damage) {
			this.title = title;
			this.description = description;
			this.weight = weight;
			this.damage = damage;
		}
	}

	/** One design. size and speed are indices into {@link #SIZES} and {@link #SPEEDS}, power is 1 to {@link #MAX_POWER}. */
	public record Design(String name, String release, Form form, int size, int speed, int power) {
		public JutsuRank rank() {
			int score = power - 1 + form.weight + (size == 2 ? 1 : 0) + (speed == 2 ? 1 : 0) - (size == 0 ? 1 : 0);
			return JutsuRank.values()[Math.max(0, Math.min(JutsuRank.values().length - 1, score))];
		}

		/** Learning costs more than a scroll jutsu of the same rank: it's the player's own invention. */
		public int price() {
			return Math.round(rank().jp * 1.5F) + 10;
		}

		/** Damage of each hit, before Ninjutsu. */
		public float damage() {
			float base = new float[] { 5, 8, 11, 15, 19 }[Math.max(0, Math.min(MAX_POWER, power) - 1)];
			return base * form.damage * new float[] { 0.85F, 1, 1.15F }[size];
		}

		float scale() {
			return new float[] { 0.7F, 1, 1.5F }[size];
		}

		float velocity() {
			return new float[] { 0.7F, 1, 1.4F }[speed];
		}

		public Element element() {
			return CustomJutsu.element(release);
		}

		public String releaseTitle() {
			return title(release) + " Release";
		}

		public String encode() {
			return String.join("|", name, release, form.name(), String.valueOf(size), String.valueOf(speed), String.valueOf(power));
		}

		static @Nullable Design decode(String line) {
			String[] parts = line.split("\\|");
			if (parts.length != 6)
				return null;
			try {
				return new Design(parts[0], parts[1], Form.valueOf(parts[2]), clamp(Integer.parseInt(parts[3]), 2), clamp(Integer.parseInt(parts[4]), 2),
						Math.max(1, Math.min(MAX_POWER, Integer.parseInt(parts[5]))));
			} catch (IllegalArgumentException e) {
				return null;
			}
		}

		private static int clamp(int value, int max) {
			return Math.max(0, Math.min(max, value));
		}
	}

	public static Element element(String release) {
		return switch (release) {
			case "typhoon" -> Element.WIND;
			default -> {
				try {
					yield Element.valueOf(release.toUpperCase(Locale.ROOT));
				} catch (IllegalArgumentException e) {
					yield Element.FIRE;
				}
			}
		};
	}

	public static String title(String release) {
		return release.substring(0, 1).toUpperCase(Locale.ROOT) + release.substring(1);
	}

	/** Keeps a name to letters, digits, spaces and a little punctuation, and at most {@link #NAME_LENGTH} long. */
	public static String cleanName(String name) {
		String cleaned = name.replaceAll("[^\\p{L}\\p{N} :'\\-!.,]", "").trim();
		return cleaned.length() > NAME_LENGTH ? cleaned.substring(0, NAME_LENGTH).trim() : cleaned;
	}

	// ------------------------------------------------------------------ the player's designs
	private static String cachedText = "";
	private static List<Design> cached = List.of();

	public static List<Design> designs(PlayerVariables variables) {
		String text = variables.custom_jutsu;
		synchronized (CustomJutsu.class) {
			if (!text.equals(cachedText)) {
				List<Design> list = new ArrayList<>();
				for (String line : text.split("\n"))
					if (!line.isBlank()) {
						Design design = Design.decode(line);
						if (design != null)
							list.add(design);
					}
				cachedText = text;
				cached = List.copyOf(list);
			}
			return cached;
		}
	}

	private static void save(ServerPlayer player, List<Design> designs) {
		StringBuilder text = new StringBuilder();
		for (Design design : designs)
			text.append(text.isEmpty() ? "" : "\n").append(design.encode());
		NarutoShippudenModVariables.ifPresent(player, v -> {
			v.custom_jutsu = text.toString();
			v.syncPlayerVariables(player);
		});
	}

	static Identifier techniqueOf(String release) {
		return Identifier.fromNamespaceAndPath("naruto_shippuden", release + "_release_technique");
	}

	/** The releases this player could make a jutsu with: the natures and kekkei genkai they have. */
	public static List<String> releases(PlayerVariables variables) {
		List<String> list = new ArrayList<>();
		for (String[] group : new String[][] { NATURES, KEKKEI_GENKAI })
			for (String release : group) {
				Technique technique = Jutsus.TECHNIQUES.get(techniqueOf(release));
				if (technique != null && (technique.requirement == null || technique.requirement.test(variables)))
					list.add(release);
			}
		return list;
	}

	/** Whether the player has learned a jutsu of this release from its scroll (and so has its technique item to cast from). */
	public static boolean learned(PlayerVariables variables, String release) {
		Technique technique = Jutsus.TECHNIQUES.get(techniqueOf(release));
		return technique != null && !technique.jutsu.isEmpty() && technique.jutsu.getFirst().isLearned(variables);
	}

	// ------------------------------------------------------------------ on the wheel
	static void register() {
		Jutsus.EXTRA = (technique, variables) -> {
			List<Design> designs = designs(variables);
			if (designs.isEmpty())
				return List.of();
			List<Jutsu> list = new ArrayList<>();
			for (Design design : designs)
				if (techniqueOf(design.release()).equals(technique.item)) {
					JutsuRank rank = design.rank();
					list.add(new Jutsu(technique, technique.jutsu.size() + list.size(), design.name(), v -> 1, 0, "Ninjutsu", v -> v.ninjutsu, rank.ninjutsu,
							rank.chakra, rank.cooldowns(), p -> cast(p, design)));
				}
			return list;
		};
	}

	// ------------------------------------------------------------------ making and forgetting (from the Jutsu Creation page)
	/** Learns a design sent by the page ("name|release|FORM|size|speed|power"). */
	public static void create(ServerPlayer player, String encoded) {
		Design sent = Design.decode(encoded);
		if (sent == null)
			return;
		Design design = new Design(cleanName(sent.name()), sent.release(), sent.form(), sent.size(), sent.speed(), sent.power());
		PlayerVariables variables = NarutoShippudenModVariables.get(player);
		List<Design> designs = new ArrayList<>(designs(variables));
		String problem = design.name().isEmpty() ? "Give the jutsu a name"
				: designs.size() >= SLOTS ? "All " + SLOTS + " slots are used: forget a jutsu first"
						: !releases(variables).contains(design.release()) ? "You don't have " + design.releaseTitle()
								: !learned(variables, design.release()) ? "Learn a jutsu from the " + design.releaseTitle() + " scroll first"
								: designs.stream().anyMatch(d -> d.name().equalsIgnoreCase(design.name())) ? "You already have a jutsu called that"
										: variables.jp < design.price() ? "Not enough JP (" + design.price() + " needed)" : null;
		if (problem != null) {
			player.sendOverlayMessage(Component.literal(problem));
			return;
		}
		designs.add(design);
		NarutoShippudenModVariables.ifPresent(player, v -> v.jp -= design.price());
		save(player, designs);
		player.sendOverlayMessage(Component.literal("Created " + design.name() + ": it's on the " + design.releaseTitle() + " wheel"));
	}

	/** Forgets the jutsu in a slot, giving back half of its price. */
	public static void forget(ServerPlayer player, int slot) {
		List<Design> designs = new ArrayList<>(designs(NarutoShippudenModVariables.get(player)));
		if (slot < 0 || slot >= designs.size())
			return;
		Design design = designs.remove(slot);
		int refund = design.price() / 2;
		NarutoShippudenModVariables.ifPresent(player, v -> v.jp += refund);
		save(player, designs);
		player.sendOverlayMessage(Component.literal("Forgot " + design.name() + " (+" + refund + " JP)"));
	}

	/**
	 * The old one-slot system gave a separate item: its design moves onto the wheel the first time the player joins, and the old
	 * items disappear.
	 */
	@SubscribeEvent
	public static void migrate(PlayerEvent.PlayerLoggedInEvent event) {
		if (!(event.getEntity() instanceof ServerPlayer player))
			return;
		PlayerVariables v = NarutoShippudenModVariables.get(player);
		if (v.customjutsu1learn) {
			String release = v.customjutsurelease1save.replace("\"", "").trim().toLowerCase(Locale.ROOT);
			String type = v.customjutsutype1save.replace("\"", "").trim();
			Form form = type.equals("Disk") ? Form.SHURIKEN : type.equals("Wave") ? Form.WAVE : Form.SPHERE;
			int speed = v.customjutsuspeed1save.contains("Fast") ? 2 : 1;
			int power = (int) Math.max(1, Math.min(MAX_POWER, Math.round(v.customjutsuchakra1save / 100)));
			String name = cleanName(v.jutsunamesave1.replace("\"", ""));
			List<Design> designs = new ArrayList<>(designs(v));
			if (!release.isEmpty() && designs.size() < SLOTS)
				designs.add(new Design(name.isEmpty() ? title(release) + " " + form.title : name, release, form, 1, speed, power));
			save(player, designs);
			NarutoShippudenModVariables.ifPresent(player, vars -> vars.customjutsu1learn = false);
		}
		for (int slot = 0; slot < player.getInventory().getContainerSize(); slot++) {
			ItemStack stack = player.getInventory().getItem(slot);
			String path = BuiltInRegistries.ITEM.getKey(stack.getItem()).getPath();
			if (path.startsWith("custom_") && path.endsWith("_release_technique"))
				player.getInventory().setItem(slot, ItemStack.EMPTY);
		}
	}

	// ------------------------------------------------------------------ casting
	static void cast(LivingEntity p, Design design) {
		ServerLevel level = (ServerLevel) p.level();
		Element element = design.element();
		float damage = design.damage(), scale = design.scale(), speed = design.velocity();
		sound(level, p.getEyePosition(), element.cast, 1.2F, 1.1F - scale * 0.2F);
		switch (design.form()) {
			case BULLETS -> channel(p, 9, 3, t -> {
				JutsuProjectile bullet = shoot(p, element, Shape.ORB, 0.35F * scale, 2.0F * speed, damage);
				bullet.onImpact = b -> puff(level, b.position(), element, 0.5F * scale);
				sound(level, p.getEyePosition(), element.cast, 0.6F, 1.5F);
			});
			case SPHERE -> {
				JutsuProjectile ball = shoot(p, element, Shape.ORB, 1.6F * scale, 0.9F * speed, damage);
				ball.life = 50;
				ball.knockback = 1;
				ball.onImpact = b -> burst(level, b.position(), 3 * scale, damage * 0.8F, 1, element, b);
			}
			case SHURIKEN -> {
				JutsuProjectile blade = shoot(p, element, Shape.SHURIKEN, 1.1F * scale, 1.4F * speed, damage);
				blade.pierce = 3;
				blade.life = 40;
			}
			case BEAST -> {
				JutsuProjectile beast = shoot(p, element, Shape.LION, 1.0F * scale, 1.2F * speed, damage);
				beast.homing = 0.18F;
				beast.life = 60;
				beast.onImpact = b -> burst(level, b.position(), 2.2F * scale, damage * 0.5F, 0.8F, element, b);
			}
			case DRAGON -> {
				JutsuProjectile dragon = shoot(p, element, Shape.DRAGON, 1.5F * scale, 0.9F * speed, damage);
				dragon.pierce = -1;
				dragon.life = 55;
				dragon.knockback = 1.2F;
				dragon.onImpact = d -> burst(level, d.position(), 3.5F * scale, damage * 0.7F, 1.2F, element, d);
			}
			case WAVE -> {
				for (int i = -3; i <= 3; i++) {
					JutsuProjectile wave = shoot(p, element, Shape.ORB, 1.3F * scale, turned(p, i * 9, 0).scale(0.8 * speed), damage);
					wave.pierce = -1;
					wave.life = 26;
					wave.knockback = 0.8F;
				}
			}
			case STREAM -> channel(p, 40, 1, t -> {
				Vec3 mouth = p.getEyePosition().add(p.getLookAngle().scale(0.8)).subtract(0, 0.2, 0);
				for (int i = 0; i < 6; i++)
					spray(level, i == 0 ? element.puff : element.trail, mouth, p.getLookAngle(), (0.45 + level.getRandom().nextDouble() * 0.3) * speed, 0.3 * scale);
				if (t % 4 == 0)
					for (LivingEntity target : cone(p, 8 * speed, 22 * scale))
						damage(p, target, damage, element);
			});
			case BURST -> {
				Techniques.burst(level, p.getBoundingBox().getCenter(), 4.5F * scale, damage, 1.4F * speed, element, p);
				channel(p, 8, 1, t -> puff(level, p.getBoundingBox().getCenter(), element, (1 + t * 0.5F) * scale));
			}
			case RAIN -> {
				Vec3 target = lookPoint(p, 30);
				channel(p, 20, 2, t -> {
					double a = level.getRandom().nextDouble() * Math.PI * 2, r = level.getRandom().nextDouble() * 3.5 * scale;
					Vec3 from = target.add(Math.cos(a) * r, 12, Math.sin(a) * r);
					JutsuProjectile drop = ClanJutsu.spawn(p, element, Shape.ORB, 0.6F * scale, from, new Vec3(0, -1.4 * speed, 0), damage);
					drop.onImpact = d -> burst(level, d.position(), 1.6F * scale, damage * 0.5F, 0.4F, element, d);
				});
			}
		}
	}
}
