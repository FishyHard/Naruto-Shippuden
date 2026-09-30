package net.mcreator.narutoshippudenmod.core.jutsu;

import static net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.burst;
import static net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.channel;
import static net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.cone;
import static net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.enemies;
import static net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.line;
import static net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.lookPoint;
import static net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.puff;
import static net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.sound;
import static net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.spray;

import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables;
import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables.PlayerVariables;
import net.mcreator.narutoshippudenmod.compat.StackTag;
import net.mcreator.narutoshippudenmod.core.jutsu.Jutsus.Jutsu;
import net.mcreator.narutoshippudenmod.core.jutsu.Jutsus.Technique;
import net.mcreator.narutoshippudenmod.core.jutsu.engine.Element;
import net.mcreator.narutoshippudenmod.core.jutsu.engine.JutsuProjectile;
import net.mcreator.narutoshippudenmod.core.jutsu.engine.JutsuProjectile.Shape;
import net.mcreator.narutoshippudenmod.core.jutsu.engine.JutsuRank;
import net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques;

import com.mojang.math.Transformation;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.DustParticleOptions;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Display;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityTypes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import net.neoforged.neoforge.event.server.ServerStoppingEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

import org.joml.Matrix4f;
import org.jspecify.annotations.Nullable;

/**
 * The shinobi weapons, remade on the jutsu engine. A weapon with abilities is a technique: right-click uses the art selected on
 * its wheel (hold X), each with its chakra, cooldown (from its {@link JutsuRank}) and the Kenjutsu it needs; the arts follow the
 * Naruto wiki. Every weapon also needs a base Kenjutsu to be used well: below it, it hits for half (it used to be dropped).
 * Art damage grows with Kenjutsu the way jutsu grow with Ninjutsu.
 * <ul>
 * <li>Flows: chakra run through the blade for a while (Flying Swallow, Chidori Katana): extra damage, reach and an effect on
 * every hit, drawn along the blade.</li>
 * <li>Flights: thrown weapons (Flying Revolving Sword, Scythe Throw, Earth Spider Sewing) fly as the real item and come back.</li>
 * <li>Passives: Samehada eats chakra, Kubikiribocho mends itself with blood, the Triple-Bladed Scythe collects blood for the
 * Jashin ritual.</li>
 * </ul>
 */
@EventBusSubscriber(modid = "naruto_shippuden")
public final class Weapons {
	private static final String DISPLAY_TAG = "naruto_shippuden.jutsu_display";
	private static final Identifier REACH = Identifier.fromNamespaceAndPath("naruto_shippuden", "weapon_flow_reach");
	/** The Kenjutsu each weapon needs to be used well, by item path. */
	public static final Map<String, Integer> KENJUTSU = new LinkedHashMap<>();
	/** What a weapon does on its own, for its tooltip. */
	public static final Map<String, String> PASSIVES = Map.of("samehada", "Eats the chakra of what it cuts", "kubikiribocho",
			"Mends itself with its victims' blood", "triple_blade_scythe", "Draws blood for the Jashin Ritual", "hiramekarei",
			"Stores chakra to unleash in new forms", "chakra_blade", "Stronger with a blade in each hand");

	private Weapons() {
	}

	// ------------------------------------------------------------------ registration
	private static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath("naruto_shippuden", path);
	}

	private static String path(ItemStack stack) {
		return BuiltInRegistries.ITEM.getKey(stack.getItem()).getPath();
	}

	/** The selected art of a weapon, from the player's "item=index" list. */
	static int selected(PlayerVariables v, String weapon) {
		for (String pair : v.weapon_arts.split(","))
			if (pair.startsWith(weapon + "="))
				try {
					return Integer.parseInt(pair.substring(weapon.length() + 1));
				} catch (NumberFormatException e) {
					return 0;
				}
		return 0;
	}

	static void select(PlayerVariables v, String weapon, double index) {
		StringBuilder text = new StringBuilder();
		for (String pair : v.weapon_arts.split(","))
			if (!pair.isEmpty() && !pair.startsWith(weapon + "="))
				text.append(text.isEmpty() ? "" : ",").append(pair);
		v.weapon_arts = text.append(text.isEmpty() ? "" : ",").append(weapon).append('=').append((int) index).toString();
	}

	/** A weapon with arts; the other items share its wheel (Hiramekarei's forms, the old Gunbai block item). */
	private static Technique weapon(String item, int kenjutsu, String... forms) {
		Technique technique = new Technique(id(item), v -> selected(v, item), (v, i) -> select(v, item, i), null, deps -> {
		});
		Jutsus.TECHNIQUES.put(technique.item, technique);
		KENJUTSU.put(item, kenjutsu);
		for (String form : forms) {
			Jutsus.TECHNIQUES.put(id(form), technique);
			KENJUTSU.put(form, kenjutsu);
		}
		return technique;
	}

	private static void art(Technique technique, String name, JutsuRank rank, int kenjutsu, Consumer<ServerPlayer> cast) {
		technique.jutsu.add(new Jutsu(technique, technique.jutsu.size(), name, v -> 1, 0, "Kenjutsu", v -> v.kenjutsu, kenjutsu, rank.chakra, rank.cooldowns(),
				cast));
	}

	/** An art that is switched on and off (Chakra Storing): costs nothing to start and has a short cooldown. */
	private static void toggle(Technique technique, String name, int kenjutsu, Consumer<ServerPlayer> cast) {
		technique.jutsu.add(new Jutsu(technique, technique.jutsu.size(), name, v -> 1, 0, "Kenjutsu", v -> v.kenjutsu, kenjutsu, 0,
				new int[] { 20, 20, 20, 20, 20 }, cast));
	}

	static void register() {
		KENJUTSU.put("tanto", 5);
		KENJUTSU.put("katana", 15);
		KENJUTSU.put("katana_jonin_1", 15);

		Technique sabre = weapon("white_light_chakra_sabre", 10);
		art(sabre, "White Light Blade", JutsuRank.C, 10, p -> flow(p, "White Light Blade", Element.DUST, 5, 1, 400, null));
		art(sabre, "White Light Streak", JutsuRank.B, 20, Weapons::whiteLightStreak);

		Technique blade = weapon("chakra_blade", 20);
		art(blade, "Flying Swallow", JutsuRank.C, 20, Weapons::flyingSwallow);
		art(blade, "Wind Blade Slash", JutsuRank.B, 25, Weapons::windBladeSlash);
		art(blade, "Burning Ash", JutsuRank.A, 30, Weapons::burningAsh);

		Technique kusanagi = weapon("kusanagi_sasuke", 25);
		art(kusanagi, "Chidori Katana", JutsuRank.C, 25, p -> flow(p, "Chidori Katana", Element.LIGHTNING, 6, 1, 400,
				(q, target) -> target.addEffect(new MobEffectInstance(MobEffects.SLOWNESS, 30, 3, false, false))));
		art(kusanagi, "Chidori Sharp Spear", JutsuRank.B, 30, Weapons::chidoriSharpSpear);
		art(kusanagi, "Chidori Current", JutsuRank.A, 35, Weapons::chidoriCurrent);

		Technique gunbai = weapon("gunbai", 25, "gunbai_block");
		art(gunbai, "Gunbai Fanned Wind", JutsuRank.C, 25, Weapons::fannedWind);
		art(gunbai, "Uchiha Return", JutsuRank.B, 30, Weapons::uchihaReturn);

		Technique scythe = weapon("triple_blade_scythe", 30);
		art(scythe, "Scythe Throw", JutsuRank.C, 30, Weapons::scytheThrow);
		art(scythe, "Jashin Ritual", JutsuRank.A, 40, Weapons::jashinRitual);

		Technique shichiseiken = weapon("shichiseiken", 35);
		art(shichiseiken, "Word Soul Curse", JutsuRank.B, 35, Weapons::wordSoulCurse);
		art(shichiseiken, "Benihisago Seal", JutsuRank.S, 45, Weapons::benihisagoSeal);

		Technique samehada = weapon("samehada", 45);
		art(samehada, "Chakra Feast", JutsuRank.C, 45, Weapons::chakraFeast);
		art(samehada, "Shark Skin Spikes", JutsuRank.B, 45, Weapons::sharkSkinSpikes);
		art(samehada, "Water Prison Shark Dance", JutsuRank.S, 55, Weapons::sharkDance);

		Technique kubikiribocho = weapon("kubikiribocho", 45);
		art(kubikiribocho, "Flying Revolving Sword", JutsuRank.B, 45, Weapons::flyingRevolvingSword);
		art(kubikiribocho, "Decapitating Slash", JutsuRank.A, 50, Weapons::decapitatingSlash);
		art(kubikiribocho, "Hidden Mist Technique", JutsuRank.C, 45, Weapons::hiddenMist);

		Technique hiramekarei = weapon("hiramekarei", 45, "hiramekarei_splitted", "hiramekarei_hammer_form");
		toggle(hiramekarei, "Chakra Storing", 45, Weapons::chakraStoring);
		art(hiramekarei, "Unleashing: Long-sword", JutsuRank.C, 45, p -> unleash(p, "hiramekarei", "Long-sword"));
		art(hiramekarei, "Unleashing: Hammer", JutsuRank.B, 50, p -> unleash(p, "hiramekarei_hammer_form", "Hammer"));
		art(hiramekarei, "Twinsword", JutsuRank.C, 45, p -> unleash(p, "hiramekarei_splitted", "Twinsword"));
		art(hiramekarei, "Fishbone Crystals", JutsuRank.B, 50, Weapons::fishboneCrystals);

		Technique kabutowari = weapon("kabutowari", 45);
		art(kabutowari, "First Axe Strike", JutsuRank.B, 45, Weapons::firstAxeStrike);
		art(kabutowari, "Bluntsword: Spin Strike", JutsuRank.B, 45, Weapons::spinStrike);
		art(kabutowari, "Iron Hammer of Kirigakure", JutsuRank.A, 50, Weapons::ironHammer);

		Technique kiba = weapon("kiba_sword", 45);
		art(kiba, "Thunderswords: Lightning Flow", JutsuRank.C, 45, p -> flow(p, "Lightning Flow", Element.LIGHTNING, 7, 0.5, 400, Weapons::arc));
		art(kiba, "Thunderswords Technique: Remote Control", JutsuRank.B, 50, Weapons::remoteControl);
		art(kiba, "Thunderswords Technique: Thunderbolt", JutsuRank.A, 55, Weapons::thunderbolt);

		Technique nuibari = weapon("nuibari", 45);
		art(nuibari, "Thread Pull", JutsuRank.C, 45, Weapons::threadPull);
		art(nuibari, "Earth Spider Sewing", JutsuRank.A, 50, Weapons::earthSpiderSewing);
		art(nuibari, "Nuibari: Fall", JutsuRank.B, 50, Weapons::nuibariFall);

		Technique shibuki = weapon("shibuki", 45);
		art(shibuki, "Blastsword: Consecutive Slashes", JutsuRank.B, 45, p -> flow(p, "Consecutive Slashes", Element.FIRE, 0, 0, 200, Weapons::blast));
		art(shibuki, "Blastsword: Earth Rupture", JutsuRank.A, 50, Weapons::earthRupture);
		art(shibuki, "Blasting Bridle Repeating Death", JutsuRank.S, 55, Weapons::repeatingDeath);
	}

	// ------------------------------------------------------------------ shared pieces
	static ServerLevel level(LivingEntity p) {
		return (ServerLevel) p.level();
	}

	/** Where the weapon hand is, roughly (the right hand, at the height it holds a blade). */
	static Vec3 hand(LivingEntity p) {
		Vec3 look = Vec3.directionFromRotation(0, p.getYRot()), side = new Vec3(-look.z, 0, look.x);
		return p.position().add(0, p.getBbHeight() * 0.62, 0).add(look.scale(0.35)).add(side.scale(0.38));
	}

	/** Art damage grows with Kenjutsu (+1% a point, up to 2.5x) instead of Ninjutsu. */
	static void hurt(LivingEntity p, LivingEntity target, float amount, Element element) {
		float kenjutsu = p instanceof ServerPlayer player ? 1 + Math.min(1.5F, (float) NarutoShippudenModVariables.get(player).kenjutsu / 100F) : 1;
		Techniques.damage(p, target, amount * kenjutsu / Techniques.power(p), element);
	}

	/** Kenjutsu-scaled burst (Techniques.burst scales with Ninjutsu). */
	static void blastAt(ServerLevel level, Vec3 at, float radius, float damage, float knockback, Element element, LivingEntity p) {
		for (LivingEntity target : enemies(level, p, new AABB(at, at).inflate(radius), e -> e.distanceToSqr(at) <= radius * radius)) {
			double falloff = 1 - 0.5 * target.distanceTo(p) / Math.max(radius, target.distanceTo(p));
			hurt(p, target, (float) (damage * Mth.clamp(falloff, 0.5, 1)), element);
			Vec3 away = target.position().subtract(at).normalize();
			target.push(away.x * knockback, 0.25 + knockback * 0.2, away.z * knockback);
			target.syncVelocity = true;
		}
		puff(level, at, element, radius * 0.8F);
		sound(level, at, element.impact, 1.2F, 0.9F + level.getRandom().nextFloat() * 0.2F);
	}

	static void swing(LivingEntity p) {
		p.swing(InteractionHand.MAIN_HAND, net.minecraft.world.item.component.SwingAnimation.DEFAULT, true);
	}

	private static void tell(ServerPlayer p, String message) {
		p.sendOverlayMessage(Component.literal(message));
	}

	private static long now(LivingEntity p) {
		return p.level().getGameTime();
	}

	// ------------------------------------------------------------------ flows (chakra through the blade)
	private record Flow(String name, String weapon, Element element, float damage, double reach, long until, @Nullable BiConsumer<ServerPlayer, LivingEntity> onHit) {
	}

	private static final Map<UUID, Flow> FLOWS = new HashMap<>();

	/** Runs chakra through the held blade for a while: extra damage and reach, an effect on each hit, drawn along the blade. */
	private static void flow(ServerPlayer p, String name, Element element, float damage, double reach, int ticks, @Nullable BiConsumer<ServerPlayer, LivingEntity> onHit) {
		endFlow(p);
		String weapon = path(p.getMainHandItem());
		FLOWS.put(p.getUUID(), new Flow(name, weapon.startsWith("hiramekarei") ? "hiramekarei" : weapon, element, damage, reach, now(p) + ticks, onHit));
		AttributeInstance range = p.getAttribute(Attributes.ENTITY_INTERACTION_RANGE);
		if (range != null && reach > 0)
			range.addOrUpdateTransientModifier(new AttributeModifier(REACH, reach, AttributeModifier.Operation.ADD_VALUE));
		sound(level(p), hand(p), element.cast, 1, 1.2F);
		puff(level(p), hand(p), element, 0.6F);
		tell(p, name + " (" + ticks / 20 + "s)");
	}

	private static void endFlow(ServerPlayer p) {
		if (FLOWS.remove(p.getUUID()) != null) {
			AttributeInstance range = p.getAttribute(Attributes.ENTITY_INTERACTION_RANGE);
			if (range != null)
				range.removeModifier(REACH);
		}
	}

	private static boolean holds(ServerPlayer p, String weapon) {
		String held = path(p.getMainHandItem());
		return held.equals(weapon) || weapon.equals("hiramekarei") && held.startsWith("hiramekarei");
	}

	/** The blade glows with its flow: particles along it every tick. */
	private static void drawFlow(ServerPlayer p, Flow flow) {
		ServerLevel level = level(p);
		Vec3 from = hand(p), to = from.add(p.getLookAngle().scale(1.1 + flow.reach * 0.6));
		for (int i = 0; i < 3; i++) {
			Vec3 at = from.lerp(to, level.getRandom().nextDouble());
			level.sendParticles(flow.element.trail, at.x, at.y, at.z, 1, 0.04, 0.04, 0.04, 0.01);
		}
		if (flow.element == Element.LIGHTNING && level.getRandom().nextInt(4) == 0)
			sound(level, from, SoundEvents.BEACON_POWER_SELECT, 0.25F, 1.8F + level.getRandom().nextFloat() * 0.2F);
	}

	// ------------------------------------------------------------------ flights (thrown weapons that come back)
	private static final List<Display.ItemDisplay> FLYING = new ArrayList<>();

	/**
	 * How a thrown weapon's model is turned in flight. The models lie in different planes: Kubikiribocho's blade is in its YZ plane,
	 * the scythe's in XY; both spin flat (blade level, edge leading round). Nuibari's needle runs along Y and points where it flies.
	 */
	enum Flight {
		FLAT_YZ, FLAT_XY, POINT
	}

	/**
	 * Throws the held weapon as its real item: it flies along the look, hitting each enemy in the way once, spins, and (if it
	 * returns) flies back to the hand when it reaches its range or a wall. {@code cable} draws a line back to the hand (the scythe's
	 * cable, Nuibari's thread). onHit sees each struck enemy; onEnd the point where it stopped.
	 */
	private static void fly(ServerPlayer p, Flight flight, double speed, double range, float damage, boolean returns, boolean cable, Element element,
			BiConsumer<Vec3, LivingEntity> onHit, @Nullable Consumer<Vec3> onEnd) {
		ServerLevel level = level(p);
		ItemStack look = p.getMainHandItem().copyWithCount(1);
		Vec3 origin = hand(p);
		Display.ItemDisplay display = new Display.ItemDisplay(EntityTypes.ITEM_DISPLAY, level);
		display.setPos(origin);
		display.getSlot(0).set(look);
		display.addTag(DISPLAY_TAG);
		level.addFreshEntity(display);
		FLYING.add(display);
		Vec3 dir = p.getLookAngle();
		Vec3[] pos = { origin };
		boolean[] back = { false };
		List<LivingEntity> struck = new ArrayList<>();
		double[] travelled = { 0 };
		sound(level, origin, SoundEvents.TRIDENT_THROW.value(), 1, 0.7F);
		int life = (int) (range / speed * (returns ? 2.6 : 1.2)) + 10;
		channel(p, life, 1, t -> {
			if (display.isRemoved())
				return;
			Vec3 at = pos[0];
			Vec3 step;
			if (!back[0]) {
				step = dir.scale(speed);
				HitResult wall = level.clip(new ClipContext(at, at.add(step), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, p));
				travelled[0] += speed;
				if (wall.getType() != HitResult.Type.MISS || travelled[0] >= range) {
					if (wall.getType() != HitResult.Type.MISS) {
						step = wall.getLocation().subtract(at).scale(0.9);
						sound(level, wall.getLocation(), SoundEvents.TRIDENT_HIT_GROUND, 1, 0.8F);
					}
					if (returns) {
						back[0] = true;
						struck.clear();
					} else {
						land(display, at.add(step), origin, t, onEnd);
						return;
					}
				}
			} else {
				Vec3 home = hand(p);
				step = home.subtract(at);
				if (step.length() < speed * 1.3) {
					level.sendParticles(ParticleTypes.CRIT, home.x, home.y, home.z, 6, 0.2, 0.2, 0.2, 0.1);
					sound(level, home, SoundEvents.TRIDENT_RETURN, 1, 1);
					if (onEnd != null)
						onEnd.accept(home);
					display.discard();
					FLYING.remove(display);
					return;
				}
				step = step.normalize().scale(speed * 1.2);
			}
			pos[0] = at.add(step);
			for (LivingEntity target : enemies(level, p, new AABB(pos[0], pos[0]).inflate(0.9), e -> !struck.contains(e))) {
				struck.add(target);
				hurt(p, target, damage, element);
				onHit.accept(pos[0], target);
				level.sendParticles(ParticleTypes.SWEEP_ATTACK, target.getX(), target.getY(0.5), target.getZ(), 1, 0, 0, 0, 0);
			}
			level.sendParticles(element.trail, pos[0].x, pos[0].y, pos[0].z, 1, 0.1, 0.1, 0.1, 0);
			if (cable && t % 2 == 0)
				line(level, ParticleTypes.WHITE_ASH, hand(p), pos[0], 0.6);
			if (t % 5 == 0)
				sound(level, pos[0], SoundEvents.PLAYER_ATTACK_SWEEP, 0.6F, 1.4F);
			// moved by its interpolated transform (a display snaps when it is moved by position)
			Vec3 offset = pos[0].subtract(origin);
			float spin = t * 1.1F;
			Matrix4f shape = new Matrix4f().translate((float) offset.x, (float) offset.y, (float) offset.z);
			switch (flight) {
				// laid level (the blade's plane turned horizontal), spinning round in that plane
				case FLAT_YZ -> shape.rotateY(-p.getYRot() * Mth.DEG_TO_RAD).rotateZ(Mth.HALF_PI).rotateX(spin).scale(1.4F);
				case FLAT_XY -> shape.rotateY(-p.getYRot() * Mth.DEG_TO_RAD).rotateX(Mth.HALF_PI).rotateZ(spin).scale(1.4F);
				// the needle (the model's +Y) along its flight, always the same side up, never spinning; centred on its middle
				case POINT -> shape.rotate(new org.joml.Quaternionf().rotationTo(0, 1, 0, (float) step.x, (float) step.y, (float) step.z)).scale(1.4F)
						.translate(0, -0.52F, 0);
			}
			if (t > 0) {
				display.setTransformationInterpolationDuration(1);
				display.setTransformation(new Transformation(shape));
				display.setTransformationInterpolationDelay(0);
			} else
				display.setTransformation(new Transformation(shape));
		});
		// the safety net: nothing flies forever
		Techniques.after(level, life + 2, () -> {
			if (!display.isRemoved()) {
				display.discard();
				FLYING.remove(display);
			}
		});
	}

	/** A weapon that doesn't come back stays stuck where it landed for a moment, then is back in the hand. */
	private static void land(Display.ItemDisplay display, Vec3 at, Vec3 origin, int t, @Nullable Consumer<Vec3> onEnd) {
		if (onEnd != null)
			onEnd.accept(at);
		Techniques.after((ServerLevel) display.level(), 10, () -> {
			display.discard();
			FLYING.remove(display);
		});
	}

	// ------------------------------------------------------------------ White Light Chakra Sabre
	/** A long white streak of light released by the swing, cutting through everything in a line. */
	private static void whiteLightStreak(ServerPlayer p) {
		ServerLevel level = level(p);
		Vec3 from = hand(p), look = p.getLookAngle();
		List<LivingEntity> struck = new ArrayList<>();
		sound(level, from, SoundEvents.BEACON_ACTIVATE, 1, 1.8F);
		sound(level, from, SoundEvents.PLAYER_ATTACK_SWEEP, 1, 0.8F);
		channel(p, 6, 1, t -> {
			for (int i = t * 3; i < t * 3 + 3; i++) {
				Vec3 at = from.add(look.scale(1 + i));
				level.sendParticles(ParticleTypes.END_ROD, at.x, at.y, at.z, 4, 0.25, 0.05, 0.25, 0.01);
				level.sendParticles(ParticleTypes.SWEEP_ATTACK, at.x, at.y, at.z, 1, 0, 0, 0, 0);
				for (LivingEntity target : enemies(level, p, new AABB(at, at).inflate(1.0), e -> !struck.contains(e))) {
					struck.add(target);
					hurt(p, target, 13, Element.DUST);
				}
			}
		});
	}

	// ------------------------------------------------------------------ Asuma's chakra blades
	/** Flying Swallow: wind chakra lengthens the blades into invisible edges. Stronger with a blade in each hand. */
	private static void flyingSwallow(ServerPlayer p) {
		boolean pair = path(p.getOffhandItem()).equals("chakra_blade");
		flow(p, "Flying Swallow", Element.WIND, pair ? 7 : 5, pair ? 1.5 : 1.2, 400, (q, target) -> {
			Vec3 away = target.position().subtract(q.position()).normalize();
			target.push(away.x * 0.4, 0.1, away.z * 0.4);
		});
	}

	/** A crescent of wind cut from the blades flies forward through every enemy in its way. */
	private static void windBladeSlash(ServerPlayer p) {
		ServerLevel level = level(p);
		Vec3 look = p.getLookAngle(), side = new Vec3(-look.z, 0, look.x).normalize();
		Vec3 start = hand(p);
		List<LivingEntity> struck = new ArrayList<>();
		sound(level, start, SoundEvents.BREEZE_SHOOT, 1.2F, 1.4F);
		channel(p, 12, 1, t -> {
			Vec3 centre = start.add(look.scale(1.5 + t * 1.3));
			double width = 1 + t * 0.12;
			for (int i = -4; i <= 4; i++) {
				// a crescent: the tips trail behind the middle
				Vec3 at = centre.add(side.scale(i * width * 0.35)).subtract(look.scale(Math.abs(i) * 0.15));
				level.sendParticles(ParticleTypes.CLOUD, at.x, at.y, at.z, 1, 0.02, 0.02, 0.02, 0);
			}
			level.sendParticles(ParticleTypes.SWEEP_ATTACK, centre.x, centre.y, centre.z, 1, 0, 0, 0, 0);
			for (LivingEntity target : enemies(level, p, new AABB(centre, centre).inflate(width, 1, width), e -> !struck.contains(e))) {
				struck.add(target);
				hurt(p, target, 11, Element.WIND);
				target.push(look.x * 0.8, 0.2, look.z * 0.8);
				target.syncVelocity = true;
			}
		});
	}

	/** Burning Ash: a cloud of chakra-laden ash is breathed out, then a click of the teeth sets it all ablaze (needs Fire). */
	private static void burningAsh(ServerPlayer p) {
		if (!NarutoShippudenModVariables.get(p).firereleaselogic) {
			Jutsus.miss(p, "Burning Ash needs the Fire nature");
			return;
		}
		ServerLevel level = level(p);
		List<Vec3> cloud = new ArrayList<>();
		sound(level, p.getEyePosition(), SoundEvents.FIRE_EXTINGUISH, 1.5F, 0.5F);
		channel(p, 30, 1, t -> {
			Vec3 mouth = p.getEyePosition().add(p.getLookAngle().scale(0.6)).subtract(0, 0.15, 0);
			for (int i = 0; i < 6; i++)
				spray(level, i % 2 == 0 ? ParticleTypes.LARGE_SMOKE : ParticleTypes.ASH, mouth, p.getLookAngle(), 0.35 + level.getRandom().nextDouble() * 0.25, 0.5);
			if (t % 6 == 0)
				cloud.add(p.getEyePosition().add(p.getLookAngle().scale(3 + t * 0.2)));
			for (LivingEntity target : cone(p, 9, 30))
				target.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 30, 0, false, false));
		});
		Techniques.after(level, 38, () -> {
			sound(level, p.getEyePosition(), SoundEvents.FLINTANDSTEEL_USE, 1.5F, 1);
			for (int i = 0; i < cloud.size(); i++) {
				Vec3 at = cloud.get(i);
				Techniques.after(level, i * 2, () -> {
					blastAt(level, at, 3.2F, 13, 0.8F, Element.FIRE, p);
					level.sendParticles(ParticleTypes.EXPLOSION, at.x, at.y, at.z, 1, 0, 0, 0, 0);
				});
			}
		});
	}

	// ------------------------------------------------------------------ Sword of Kusanagi
	/** Chidori Sharp Spear: the lightning on the blade shoots out into a long spear, running through everything in a line. */
	private static void chidoriSharpSpear(ServerPlayer p) {
		ServerLevel level = level(p);
		Vec3 from = hand(p), end = lookPoint(p, 14);
		Vec3 dir = end.subtract(from).normalize();
		double length = end.distanceTo(from);
		sound(level, from, SoundEvents.LIGHTNING_BOLT_IMPACT, 1, 1.8F);
		List<LivingEntity> struck = new ArrayList<>();
		channel(p, 10, 1, t -> {
			double reach = Math.min(length, (t + 1) * 3.5);
			Vec3 tip = from.add(dir.scale(reach));
			line(level, ParticleTypes.ELECTRIC_SPARK, from, tip, 0.25);
			for (LivingEntity target : enemies(level, p, new AABB(from, tip).inflate(0.6), e -> !struck.contains(e) && distanceToLine(e, from, tip) < 0.9)) {
				struck.add(target);
				hurt(p, target, 15, Element.LIGHTNING);
				level.sendParticles(ParticleTypes.ELECTRIC_SPARK, target.getX(), target.getY(0.5), target.getZ(), 20, 0.3, 0.4, 0.3, 0.4);
			}
		});
	}

	static double distanceToLine(Entity e, Vec3 a, Vec3 b) {
		Vec3 c = e.getBoundingBox().getCenter(), ab = b.subtract(a);
		double t = Mth.clamp(c.subtract(a).dot(ab) / Math.max(1e-6, ab.lengthSqr()), 0, 1);
		return c.distanceTo(a.add(ab.scale(t))) - e.getBbWidth() / 2;
	}

	/** Chidori Current: the sword is driven into the ground and lightning runs out through it, shocking and numbing everything around. */
	private static void chidoriCurrent(ServerPlayer p) {
		ServerLevel level = level(p);
		Vec3 c = p.position();
		sound(level, c, SoundEvents.LIGHTNING_BOLT_IMPACT, 1.5F, 1.2F);
		channel(p, 20, 2, t -> {
			double r = 1 + t * 0.35;
			for (int i = 0; i < 16; i++) {
				double a = i * Math.PI / 8 + t * 0.2;
				level.sendParticles(ParticleTypes.ELECTRIC_SPARK, c.x + Math.cos(a) * r, c.y + 0.2, c.z + Math.sin(a) * r, 2, 0.1, 0.2, 0.1, 0.2);
			}
			if (t % 4 == 0)
				for (LivingEntity target : enemies(level, p, new AABB(c, c).inflate(6, 3, 6), e -> e.distanceToSqr(c) < 36)) {
					hurt(p, target, 5, Element.LIGHTNING);
					target.addEffect(new MobEffectInstance(MobEffects.SLOWNESS, 40, 5, false, false));
					line(level, ParticleTypes.ELECTRIC_SPARK, c.add(0, 0.2, 0), target.getBoundingBox().getCenter(), 0.4);
				}
		});
	}

	// ------------------------------------------------------------------ Gunbai
	/** Gunbai Fanned Wind: a swing of the fan blows a gale that throws everything in front far back and blows projectiles away. */
	private static void fannedWind(ServerPlayer p) {
		ServerLevel level = level(p);
		Vec3 look = p.getLookAngle();
		for (LivingEntity target : cone(p, 14, 50)) {
			hurt(p, target, 7, Element.WIND);
			target.push(look.x * 3.2, 0.7, look.z * 3.2);
			target.syncVelocity = true;
		}
		for (Projectile shot : level.getEntitiesOfClass(Projectile.class, p.getBoundingBox().inflate(14),
				e -> e.getOwner() != p && e.position().subtract(p.getEyePosition()).normalize().dot(look) > 0.6)) {
			shot.setDeltaMovement(look.scale(1.5));
			shot.setOwner(p);
		}
		channel(p, 10, 1, t -> {
			for (int i = 1; i <= 14; i += 2) {
				Vec3 at = p.getEyePosition().add(look.scale(i + t * 0.6));
				level.sendParticles(ParticleTypes.GUST, at.x, at.y, at.z, 1, i * 0.2, i * 0.15, i * 0.2, 0);
				level.sendParticles(ParticleTypes.CLOUD, at.x, at.y, at.z, 2, i * 0.22, i * 0.16, i * 0.22, 0.06);
			}
		});
		sound(level, p.getEyePosition(), SoundEvents.BREEZE_WIND_CHARGE_BURST.value(), 2, 0.5F);
		swing(p);
	}

	/** An Uchiha Return guard: until the time runs out, what hits from the front is taken into the fan. */
	private record Guard(long until, float[] stored) {
	}

	private static final Map<UUID, Guard> GUARDS = new HashMap<>();

	/**
	 * Uchiha Return: for four seconds the fan takes every attack from the front (projectiles are sent back), then releases all of it
	 * at once as a blast of wind.
	 */
	private static void uchihaReturn(ServerPlayer p) {
		GUARDS.put(p.getUUID(), new Guard(now(p) + 80, new float[1]));
		sound(level(p), p.position(), SoundEvents.SHIELD_BLOCK.value(), 1.2F, 0.7F);
		tell(p, "Uchiha Return: facing the attack");
	}

	private static void releaseGuard(ServerPlayer p, Guard guard) {
		ServerLevel level = level(p);
		float stored = guard.stored[0];
		Vec3 look = p.getLookAngle();
		sound(level, p.getEyePosition(), SoundEvents.WIND_CHARGE_BURST.value(), 2, 0.6F);
		for (LivingEntity target : cone(p, 10, 45)) {
			hurt(p, target, 4 + Math.min(40, stored * 0.9F), Element.WIND);
			target.push(look.x * 2.2, 0.5, look.z * 2.2);
			target.syncVelocity = true;
		}
		for (int i = 1; i <= 10; i += 2) {
			Vec3 at = p.getEyePosition().add(look.scale(i));
			level.sendParticles(ParticleTypes.GUST, at.x, at.y, at.z, 1, i * 0.15, i * 0.12, i * 0.15, 0);
		}
		if (stored > 0)
			tell(p, "Uchiha Return: " + Math.round(stored) + " damage sent back");
	}

	// ------------------------------------------------------------------ Triple-Bladed Scythe
	/** Who each wielder has drawn blood from, and until when that blood is fresh. */
	private record Blood(UUID target, long until) {
	}

	private static final Map<UUID, Blood> BLOOD = new HashMap<>();

	private static void drawBlood(ServerPlayer p, LivingEntity target) {
		BLOOD.put(p.getUUID(), new Blood(target.getUUID(), now(p) + 600));
		level(p).sendParticles(Element.BLOOD.trail, target.getX(), target.getY(0.6), target.getZ(), 10, 0.2, 0.3, 0.2, 0.05);
	}

	/** Scythe Throw: the scythe flies out on its cable, cutting everything in the way and drawing blood, then is reeled back. */
	private static void scytheThrow(ServerPlayer p) {
		fly(p, Flight.FLAT_XY, 1.2, 16, 10, true, true, Element.STEEL, (at, target) -> drawBlood(p, target), null);
	}

	private record Ritual(Vec3 centre, long until, UUID target) {
	}

	private static final Map<UUID, Ritual> RITUALS = new HashMap<>();

	/**
	 * Jashin Ritual: with fresh blood of an enemy, the wielder draws Jashin's circle under their feet. For 20 seconds, while they stand
	 * in it, every wound they take is dealt to that enemy too.
	 */
	private static void jashinRitual(ServerPlayer p) {
		Blood blood = BLOOD.get(p.getUUID());
		if (blood == null || blood.until < now(p) || !(level(p).getEntity(blood.target) instanceof LivingEntity target) || !target.isAlive()) {
			Jutsus.miss(p, "Draw an enemy's blood with the scythe first");
			return;
		}
		RITUALS.put(p.getUUID(), new Ritual(p.position(), now(p) + 400, blood.target));
		sound(level(p), p.position(), SoundEvents.WITHER_SPAWN, 0.7F, 1.4F);
		tell(p, "Jashin Ritual: stay in the circle");
	}

	private static void drawRitual(ServerPlayer p, Ritual ritual) {
		ServerLevel level = level(p);
		Vec3 c = ritual.centre;
		DustParticleOptions red = new DustParticleOptions(0x9A0F1E, 1.2F);
		for (int i = 0; i < 24; i++) {
			double a = i * Math.PI / 12;
			level.sendParticles(red, c.x + Math.cos(a) * 1.6, c.y + 0.05, c.z + Math.sin(a) * 1.6, 1, 0, 0, 0, 0);
		}
		// the triangle inside
		for (int i = 0; i < 3; i++) {
			double a = i * Math.PI * 2 / 3 + Math.PI / 2, b = (i + 1) * Math.PI * 2 / 3 + Math.PI / 2;
			Vec3 from = c.add(Math.cos(a) * 1.6, 0.05, Math.sin(a) * 1.6), to = c.add(Math.cos(b) * 1.6, 0.05, Math.sin(b) * 1.6);
			for (int s = 0; s <= 6; s++) {
				Vec3 at = from.lerp(to, s / 6.0);
				level.sendParticles(red, at.x, at.y, at.z, 1, 0, 0, 0, 0);
			}
		}
	}

	// ------------------------------------------------------------------ Shichiseiken
	private static final Map<UUID, Blood> CURSED = new HashMap<>();

	/** Word Soul Curse: a cut of the Shichiseiken takes hold of the enemy's word soul for thirty seconds (they glow). */
	private static void wordSoulCurse(ServerPlayer p) {
		LivingEntity target = ClanJutsu.target(p, 6);
		if (target == null) {
			Jutsus.miss(p, "Look at an enemy within reach");
			return;
		}
		hurt(p, target, 8, Element.SEAL);
		target.addEffect(new MobEffectInstance(MobEffects.GLOWING, 600, 0, false, false));
		CURSED.put(p.getUUID(), new Blood(target.getUUID(), now(p) + 600));
		ServerLevel level = level(p);
		line(level, Element.SEAL.trail, hand(p), target.getBoundingBox().getCenter(), 0.3);
		sound(level, target.position(), SoundEvents.ILLUSIONER_CAST_SPELL, 1, 0.8F);
		swing(p);
	}

	/**
	 * Benihisago Seal: the cursed enemy's soul is drawn towards the sword: they are dragged in and held while it is torn from them.
	 * Costs enormous chakra, as the Sage's tools do.
	 */
	private static void benihisagoSeal(ServerPlayer p) {
		Blood curse = CURSED.get(p.getUUID());
		ServerLevel level = level(p);
		if (curse == null || curse.until < now(p) || !(level.getEntity(curse.target) instanceof LivingEntity target) || !target.isAlive()
				|| target.distanceTo(p) > 24) {
			Jutsus.miss(p, "Curse an enemy with the Shichiseiken first");
			return;
		}
		CURSED.remove(p.getUUID());
		sound(level, p.position(), SoundEvents.WARDEN_SONIC_CHARGE, 1.5F, 0.6F);
		channel(p, 80, 1, t -> {
			if (!target.isAlive())
				return;
			Vec3 to = p.getEyePosition().add(p.getLookAngle().scale(2.5)).subtract(0, 1, 0);
			Vec3 pull = to.subtract(target.position());
			if (pull.length() > 1.5) {
				target.setDeltaMovement(pull.normalize().scale(0.5));
				target.syncVelocity = true;
			} else
				ClanJutsu.hold(target);
			line(level, new DustParticleOptions(0xFFCC4D, 1.2F), target.getBoundingBox().getCenter(), hand(p), 0.35);
			if (t % 10 == 0) {
				hurt(p, target, 6, Element.SEAL);
				target.addEffect(new MobEffectInstance(MobEffects.WITHER, 40, 1, false, false));
				sound(level, target.position(), SoundEvents.SOUL_ESCAPE.value(), 1.5F, 0.8F);
			}
			level.sendParticles(ParticleTypes.SOUL, target.getX(), target.getY(0.6), target.getZ(), 2, 0.3, 0.4, 0.3, 0.02);
		});
	}

	// ------------------------------------------------------------------ Samehada
	private static double absorbed(ItemStack stack) {
		return StackTag.of(stack).getDoubleOr("Absorbed", 0);
	}

	/** Samehada's scales shave chakra off whatever they cut: some of it goes to the wielder, the rest is stored in the sword. */
	private static void absorb(ServerPlayer p, LivingEntity target, double fraction) {
		double taken;
		if (target instanceof Player victim) {
			double chakra = NarutoShippudenModVariables.get(victim).ChakraAmount;
			taken = Math.min(chakra, Math.max(15, chakra * fraction));
			NarutoShippudenModVariables.ifPresent(victim, v -> {
				v.ChakraAmount = Math.max(0, v.ChakraAmount - taken);
				v.syncPlayerVariables(victim);
			});
		} else {
			double chakra = target.getPersistentData().getDoubleOr("ChakraAmount", 0);
			taken = chakra > 0 ? Math.min(chakra, Math.max(15, chakra * fraction)) : 10;
			if (chakra > 0)
				target.getPersistentData().putDouble("ChakraAmount", chakra - taken);
		}
		NarutoShippudenModVariables.ifPresent(p, v -> {
			v.ChakraAmount = Math.min(v.ChakraMax, v.ChakraAmount + taken * 0.5);
			v.syncPlayerVariables(p);
		});
		ItemStack sword = p.getMainHandItem();
		StackTag.of(sword).putDouble("Absorbed", Math.min(2000, absorbed(sword) + taken * 0.5));
		line(level(p), Element.CHAKRA.trail, target.getBoundingBox().getCenter(), hand(p), 0.4);
	}

	/** Chakra Feast: Samehada gives back the chakra it has eaten as healing. */
	private static void chakraFeast(ServerPlayer p) {
		ItemStack sword = p.getMainHandItem();
		double stored = absorbed(sword);
		if (stored < 20) {
			Jutsus.miss(p, "Samehada hasn't eaten enough chakra (cut enemies with it)");
			return;
		}
		float heal = (float) Math.min(p.getMaxHealth() - p.getHealth(), stored / 10);
		p.heal(Math.max(2, heal));
		StackTag.of(sword).putDouble("Absorbed", Math.max(0, stored - Math.max(20, heal * 10)));
		p.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 100, 1, false, false));
		level(p).sendParticles(Element.CHAKRA.puff, p.getX(), p.getY(1), p.getZ(), 20, 0.4, 0.6, 0.4, 0.05);
		sound(level(p), p.position(), SoundEvents.GENERIC_EAT.value(), 1, 0.6F);
	}

	/** Shark Skin Spikes: the scales jut out into spikes, shredding everything around and eating their chakra. */
	private static void sharkSkinSpikes(ServerPlayer p) {
		ServerLevel level = level(p);
		Vec3 c = p.getBoundingBox().getCenter();
		for (LivingEntity target : enemies(level, p, p.getBoundingBox().inflate(4), e -> e.distanceToSqr(p) < 16)) {
			hurt(p, target, 12, Element.WATER);
			absorb(p, target, 0.1);
			Vec3 away = target.position().subtract(p.position()).normalize();
			target.push(away.x, 0.3, away.z);
			target.syncVelocity = true;
		}
		for (int i = 0; i < 24; i++) {
			Vec3 d = new Vec3(level.getRandom().nextGaussian(), level.getRandom().nextGaussian() * 0.5, level.getRandom().nextGaussian()).normalize();
			level.sendParticles(ParticleTypes.CRIT, c.x, c.y, c.z, 0, d.x, d.y, d.z, 0.8);
		}
		sound(level, c, SoundEvents.PUFFER_FISH_BLOW_UP, 1.5F, 0.6F);
		swing(p);
	}

	/**
	 * Water Prison Shark Dance: a great dome of water rises around the wielder for ten seconds. Inside, enemies are slowed and drown
	 * while sharks hunt them; the wielder breathes and moves freely.
	 */
	private static void sharkDance(ServerPlayer p) {
		ServerLevel level = level(p);
		Vec3 c = p.position();
		float radius = 7;
		JutsuProjectile dome = ClanJutsu.shell(p, null, c.add(0, 2, 0), Element.WATER, radius * 2, 200);
		sound(level, c, SoundEvents.PLAYER_SPLASH_HIGH_SPEED, 2, 0.4F);
		channel(p, 200, 1, t -> {
			if (!dome.isAlive())
				return;
			p.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 40, 0, false, false));
			p.addEffect(new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 40, 0, false, false));
			level.sendParticles(ParticleTypes.BUBBLE_COLUMN_UP, c.x, c.y + 1, c.z, 6, radius * 0.6, 2, radius * 0.6, 0.1);
			for (LivingEntity target : enemies(level, p, new AABB(c, c).inflate(radius), e -> e.distanceToSqr(c) < radius * radius)) {
				target.addEffect(new MobEffectInstance(MobEffects.SLOWNESS, 20, 2, false, false));
				target.addEffect(new MobEffectInstance(MobEffects.MINING_FATIGUE, 20, 1, false, false));
				target.setAirSupply(Math.max(-20, target.getAirSupply() - 5));
				target.clearFire();
				if (t % 25 == 0) {
					JutsuProjectile shark = ClanJutsu.spawn(p, Element.WATER, Shape.SHARK, 1, c.add(0, 1.5, 0), target.position().subtract(c).normalize().scale(0.8),
							0);
					shark.homing = 0.25F;
					shark.life = 30;
					shark.onHit = (s, hit) -> {
						hurt(p, hit, 7, Element.WATER);
						absorb(p, hit, 0.05);
					};
				}
			}
		});
	}

	// ------------------------------------------------------------------ Kubikiribocho
	/** Flying Revolving Sword: the great cleaver is thrown spinning, cuts through everything in its path and comes back. */
	private static void flyingRevolvingSword(ServerPlayer p) {
		fly(p, Flight.FLAT_YZ, 1.1, 14, 16, true, false, Element.STEEL, (at, target) -> {
			target.push(0, 0.3, 0);
			target.syncVelocity = true;
		}, null);
	}

	/** Decapitating Slash: a leap at the enemy looked at and one great downward cleave. */
	private static void decapitatingSlash(ServerPlayer p) {
		LivingEntity target = ClanJutsu.target(p, 12);
		if (target == null) {
			Jutsus.miss(p, "Look at an enemy within 12 blocks");
			return;
		}
		ServerLevel level = level(p);
		Vec3 to = target.position().subtract(p.position());
		p.setDeltaMovement(to.x * 0.18, 0.55, to.z * 0.18);
		p.syncVelocity = true;
		sound(level, p.position(), SoundEvents.PLAYER_ATTACK_KNOCKBACK, 1, 0.6F);
		boolean[] done = { false };
		channel(p, 30, 1, t -> {
			p.fallDistance = 0;
			if (done[0] || t < 4)
				return;
			if (p.distanceTo(target) < 3 || p.onGround()) {
				done[0] = true;
				if (p.distanceTo(target) < 4.5) {
					hurt(p, target, 26, Element.STEEL);
					level.sendParticles(Element.BLOOD.trail, target.getX(), target.getY(0.8), target.getZ(), 25, 0.3, 0.3, 0.3, 0.1);
				}
				level.sendParticles(ParticleTypes.SWEEP_ATTACK, target.getX(), target.getY(0.6), target.getZ(), 3, 0.5, 0.3, 0.5, 0);
				sound(level, target.position(), SoundEvents.PLAYER_ATTACK_CRIT, 1.5F, 0.6F);
				swing(p);
			}
		});
	}

	/** Hidden Mist Technique: a thick mist spreads around the wielder for fifteen seconds; enemies in it can't see, the wielder can't be seen. */
	private static void hiddenMist(ServerPlayer p) {
		ServerLevel level = level(p);
		Vec3 c = p.position();
		sound(level, c, SoundEvents.FIRE_EXTINGUISH, 1.5F, 0.4F);
		channel(p, 300, 2, t -> {
			level.sendParticles(ParticleTypes.CLOUD, c.x, c.y + 1, c.z, 14, 6, 1.5, 6, 0.005);
			level.sendParticles(ParticleTypes.WHITE_SMOKE, c.x, c.y + 0.5, c.z, 6, 7, 1, 7, 0.005);
			if (p.distanceToSqr(c) < 100)
				p.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 10, 0, false, false));
			for (LivingEntity target : enemies(level, p, new AABB(c, c).inflate(10, 4, 10), e -> e.distanceToSqr(c) < 100))
				target.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 30, 0, false, false));
		});
	}

	// ------------------------------------------------------------------ Hiramekarei
	private static double stored(ItemStack stack) {
		return StackTag.of(stack).getDoubleOr("StoredChakra", 0);
	}

	private static final java.util.Set<UUID> STORING = new java.util.HashSet<>();

	/** Chakra Storing: while on, the wielder's chakra flows into Hiramekarei (up to 1000), to be unleashed in its forms. */
	private static void chakraStoring(ServerPlayer p) {
		if (STORING.remove(p.getUUID()))
			tell(p, "Chakra Storing off (" + (int) stored(p.getMainHandItem()) + " stored)");
		else {
			STORING.add(p.getUUID());
			tell(p, "Chakra Storing on");
		}
	}

	/**
	 * Hiramekarei Unleashing: the stored chakra coats the sword in a new shape for twenty seconds (the hammer and the two swords are
	 * their own items; the long-sword is a flow). It takes 150 stored chakra.
	 */
	private static void unleash(ServerPlayer p, String item, String form) {
		ItemStack held = p.getMainHandItem();
		if (stored(held) < 150) {
			Jutsus.miss(p, "Store chakra in Hiramekarei first (150 needed)");
			return;
		}
		StackTag.of(held).putDouble("StoredChakra", stored(held) - 150);
		revertForm(p);
		ServerLevel level = level(p);
		puff(level, hand(p), Element.CHAKRA, 1);
		sound(level, hand(p), SoundEvents.BEACON_ACTIVATE, 1, 1.4F);
		if (form.equals("Long-sword")) {
			flow(p, "Hiramekarei: Long-sword", Element.CHAKRA, 8, 2.5, 400, null);
			return;
		}
		Item target = BuiltInRegistries.ITEM.getValue(id(item));
		ItemStack shaped = p.getMainHandItem().transmuteCopy(target, 1);
		StackTag.of(shaped).putDouble("FormUntil", now(p) + 400);
		// the twinsword is already two swords in one: it stays in the main hand
		p.setItemInHand(InteractionHand.MAIN_HAND, shaped);
		tell(p, "Hiramekarei: " + form + " (20s)");
	}

	/** Back to the plain sword (keeping its stored chakra), and the second twinsword goes away. */
	private static void revertForm(ServerPlayer p) {
		for (InteractionHand hand : InteractionHand.values()) {
			ItemStack stack = p.getItemInHand(hand);
			if (StackTag.of(stack).getBooleanOr("TwinCopy", false))
				p.setItemInHand(hand, ItemStack.EMPTY);
		}
		ItemStack main = p.getMainHandItem();
		String held = path(main);
		if (held.equals("hiramekarei_splitted") || held.equals("hiramekarei_hammer_form")) {
			ItemStack plain = main.transmuteCopy(BuiltInRegistries.ITEM.getValue(id("hiramekarei")), 1);
			StackTag.of(plain).putDouble("FormUntil", 0);
			p.setItemInHand(InteractionHand.MAIN_HAND, plain);
			puff(level(p), hand(p), Element.CHAKRA, 0.6F);
		}
	}

	/** Fishbone Crystals: a spray of light blue crystal bones that pierce and pin whoever they hit. */
	private static void fishboneCrystals(ServerPlayer p) {
		for (int i = -3; i <= 3; i++) {
			JutsuProjectile bone = Techniques.shoot(p, Element.ICE, Shape.NEEDLE, 0.35F, Techniques.turned(p, i * 6, -1).scale(2.2), 0);
			bone.life = 20;
			bone.knockback = 0;
			bone.onHit = (b, hit) -> {
				hurt(p, hit, 6, Element.ICE);
				hit.addEffect(new MobEffectInstance(MobEffects.SLOWNESS, 60, 5, false, false));
			};
		}
		sound(level(p), hand(p), SoundEvents.AMETHYST_BLOCK_BREAK, 1.5F, 1.2F);
		swing(p);
	}

	// ------------------------------------------------------------------ Kabutowari
	/** First Axe Strike: a rush at the enemy looked at and an axe blow that splits any guard (a raised shield is knocked aside). */
	private static void firstAxeStrike(ServerPlayer p) {
		LivingEntity target = ClanJutsu.target(p, 9);
		if (target == null) {
			Jutsus.miss(p, "Look at an enemy within 9 blocks");
			return;
		}
		ServerLevel level = level(p);
		Vec3 to = target.position().subtract(p.position()).multiply(1, 0, 1).normalize();
		boolean[] done = { false };
		channel(p, 12, 1, t -> {
			if (done[0])
				return;
			p.setDeltaMovement(to.x * 1.5, Math.min(p.getDeltaMovement().y, 0.1), to.z * 1.5);
			p.syncVelocity = true;
			level.sendParticles(Element.STEEL.trail, p.getX(), p.getY(0.5), p.getZ(), 2, 0.2, 0.3, 0.2, 0);
			if (p.distanceTo(target) < 2.6 || t == 11) {
				done[0] = true;
				p.setDeltaMovement(Vec3.ZERO);
				p.syncVelocity = true;
				if (p.distanceTo(target) > 3.5)
					return;
				if (target instanceof Player victim && victim.isBlocking()) {
					victim.getCooldowns().addCooldown(victim.getUseItem(), 100);
					victim.stopUsingItem();
					sound(level, target.position(), SoundEvents.SHIELD_BREAK.value(), 1.5F, 0.8F);
				}
				target.removeEffect(MobEffects.RESISTANCE);
				hurt(p, target, 18, Element.STEEL);
				level.sendParticles(ParticleTypes.SWEEP_ATTACK, target.getX(), target.getY(0.6), target.getZ(), 1, 0, 0, 0, 0);
				sound(level, target.position(), SoundEvents.ANVIL_LAND, 1, 0.8F);
				swing(p);
			}
		});
	}

	/** Bluntsword: Spin Strike: axe and hammer whirl round on their cord for two seconds, battering everything close and pulling it in. */
	private static void spinStrike(ServerPlayer p) {
		ServerLevel level = level(p);
		channel(p, 40, 1, t -> {
			Vec3 c = p.position().add(0, 1, 0);
			double a = t * 0.8;
			for (int k = 0; k < 2; k++) {
				double b = a + k * Math.PI;
				Vec3 at = c.add(Math.cos(b) * 3, 0, Math.sin(b) * 3);
				level.sendParticles(Element.STEEL.puff, at.x, at.y, at.z, 2, 0.2, 0.2, 0.2, 0);
				line(level, ParticleTypes.WHITE_ASH, c, at, 0.8);
			}
			if (t % 5 == 0) {
				sound(level, c, SoundEvents.PLAYER_ATTACK_SWEEP, 1, 0.6F);
				for (LivingEntity target : enemies(level, p, p.getBoundingBox().inflate(3.6, 1, 3.6), e -> e.distanceToSqr(p) < 14)) {
					hurt(p, target, 5, Element.STEEL);
					Vec3 in = p.position().subtract(target.position()).normalize().scale(0.25);
					target.setDeltaMovement(target.getDeltaMovement().add(in.x, 0.15, in.z));
					target.syncVelocity = true;
				}
			}
		});
	}

	/** Iron Hammer of Kirigakure: a leap and the hammer brought down with all its weight: a shockwave throws everything around up. */
	private static void ironHammer(ServerPlayer p) {
		ServerLevel level = level(p);
		p.setDeltaMovement(p.getLookAngle().x * 0.4, 0.9, p.getLookAngle().z * 0.4);
		p.syncVelocity = true;
		sound(level, p.position(), SoundEvents.PLAYER_ATTACK_KNOCKBACK, 1, 0.5F);
		boolean[] done = { false };
		channel(p, 60, 1, t -> {
			p.fallDistance = 0;
			if (done[0] || t < 6)
				return;
			if (t < 14 && !p.onGround())
				return;
			// down hard
			if (!p.onGround()) {
				p.setDeltaMovement(0, -1.6, 0);
				p.syncVelocity = true;
				return;
			}
			done[0] = true;
			Vec3 c = p.position();
			BlockState ground = level.getBlockState(p.blockPosition().below());
			if (!ground.isAir())
				level.sendParticles(new BlockParticleOption(ParticleTypes.BLOCK, ground), c.x, c.y + 0.1, c.z, 80, 2.5, 0.2, 2.5, 0.2);
			level.sendParticles(ParticleTypes.EXPLOSION, c.x, c.y + 0.3, c.z, 3, 1.5, 0.2, 1.5, 0);
			sound(level, c, SoundEvents.MACE_SMASH_GROUND_HEAVY, 2, 0.7F);
			for (LivingEntity target : enemies(level, p, p.getBoundingBox().inflate(6, 2, 6), e -> e.distanceToSqr(p) < 36)) {
				hurt(p, target, 20 - (float) target.distanceTo(p) * 1.5F, Element.EARTH);
				target.setDeltaMovement(target.getDeltaMovement().add(0, 0.9, 0));
				target.syncVelocity = true;
			}
			swing(p);
		});
	}

	// ------------------------------------------------------------------ Kiba
	/** Lightning jumps from the struck enemy to the nearest other one. */
	private static void arc(ServerPlayer p, LivingEntity from) {
		ServerLevel level = level(p);
		enemies(level, p, from.getBoundingBox().inflate(5), e -> e != from).stream().min((a, b) -> Double.compare(a.distanceToSqr(from), b.distanceToSqr(from)))
				.ifPresent(next -> {
					line(level, ParticleTypes.ELECTRIC_SPARK, from.getBoundingBox().getCenter(), next.getBoundingBox().getCenter(), 0.3);
					hurt(p, next, 5, Element.LIGHTNING);
				});
	}

	/** Thunderswords Technique: Remote Control: lightning leaves the blades and snakes along the ground to the enemy, then jumps on. */
	private static void remoteControl(ServerPlayer p) {
		ServerLevel level = level(p);
		LivingEntity target = ClanJutsu.target(p, 20);
		Vec3 end = target != null ? target.position() : lookPoint(p, 20);
		Vec3 start = p.position().add(0, 0.1, 0);
		sound(level, start, SoundEvents.BEACON_POWER_SELECT, 1.5F, 1.5F);
		int steps = (int) Math.max(4, end.distanceTo(start) / 1.2);
		List<LivingEntity> struck = new ArrayList<>();
		channel(p, steps + 1, 1, t -> {
			Vec3 at = start.lerp(end, t / (double) steps).add(0, 0.2, 0);
			Vec3 wobble = new Vec3(level.getRandom().nextGaussian() * 0.3, 0, level.getRandom().nextGaussian() * 0.3);
			line(level, ParticleTypes.ELECTRIC_SPARK, at, at.add(wobble).add(0, 0.6, 0), 0.2);
			for (LivingEntity hit : enemies(level, p, new AABB(at, at).inflate(1.2, 1.5, 1.2), e -> !struck.contains(e))) {
				struck.add(hit);
				hurt(p, hit, 12, Element.LIGHTNING);
				arc(p, hit);
				arc(p, hit);
			}
		});
	}

	/** Thunderswords Technique: Thunderbolt: the blades call lightning out of the sky onto where the wielder points, three times. */
	private static void thunderbolt(ServerPlayer p) {
		ServerLevel level = level(p);
		LivingEntity aimed = ClanJutsu.target(p, 30);
		sound(level, p.position(), SoundEvents.LIGHTNING_BOLT_THUNDER, 2, 1);
		for (int i = 0; i < 3; i++)
			Techniques.after(level, 8 + i * 8, () -> {
				Vec3 at = aimed != null && aimed.isAlive() ? aimed.position() : lookPoint(p, 30);
				Techniques.strike(level, at, 3.5F, 12, p);
			});
	}

	// ------------------------------------------------------------------ Nuibari
	/** Thread Pull: Nuibari's wire catches the enemy looked at and drags them onto the blade. */
	private static void threadPull(ServerPlayer p) {
		LivingEntity target = ClanJutsu.target(p, 16);
		if (target == null) {
			Jutsus.miss(p, "Look at an enemy within 16 blocks");
			return;
		}
		ServerLevel level = level(p);
		sound(level, target.position(), SoundEvents.FISHING_BOBBER_RETRIEVE, 1.5F, 0.8F);
		boolean[] done = { false };
		channel(p, 20, 1, t -> {
			if (done[0] || !target.isAlive())
				return;
			line(level, ParticleTypes.WHITE_ASH, hand(p), target.getBoundingBox().getCenter(), 0.4);
			Vec3 pull = p.position().subtract(target.position());
			if (pull.length() < 2.2) {
				done[0] = true;
				hurt(p, target, 10, Element.STEEL);
				target.setDeltaMovement(Vec3.ZERO);
				target.syncVelocity = true;
				swing(p);
				return;
			}
			target.setDeltaMovement(pull.normalize().scale(0.9).add(0, 0.1, 0));
			target.syncVelocity = true;
		});
	}

	/**
	 * Longsword Ninja Art — Earth Spider Sewing: Nuibari is thrown through every enemy in a line; its thread stitches them together
	 * and pulls them into one knot, held for three seconds.
	 */
	private static void earthSpiderSewing(ServerPlayer p) {
		ServerLevel level = level(p);
		List<LivingEntity> sewn = new ArrayList<>();
		fly(p, Flight.POINT, 1.6, 24, 12, false, true, Element.STEEL, (at, target) -> sewn.add(target), end -> {
			if (sewn.isEmpty())
				return;
			Vec3 knot = sewn.getLast().position();
			sound(level, knot, SoundEvents.CROSSBOW_LOADING_END.value(), 1.5F, 0.6F);
			channel(p, 60, 1, t -> {
				for (int i = 0; i < sewn.size(); i++) {
					LivingEntity target = sewn.get(i);
					if (!target.isAlive())
						continue;
					Vec3 to = knot.subtract(target.position());
					if (to.length() > 0.8) {
						target.setDeltaMovement(to.normalize().scale(0.6));
						target.syncVelocity = true;
					} else
						ClanJutsu.hold(target);
					if (i > 0 && t % 2 == 0)
						line(level, ParticleTypes.WHITE_ASH, sewn.get(i - 1).getBoundingBox().getCenter(), target.getBoundingBox().getCenter(), 0.4);
				}
				if (t % 20 == 0)
					for (LivingEntity target : sewn)
						hurt(p, target, 3, Element.STEEL);
			});
		});
	}

	/** Nuibari: Fall: a leap over the enemy looked at and a plunge straight down through them, pinning them for two seconds. */
	private static void nuibariFall(ServerPlayer p) {
		LivingEntity target = ClanJutsu.target(p, 14);
		if (target == null) {
			Jutsus.miss(p, "Look at an enemy within 14 blocks");
			return;
		}
		ServerLevel level = level(p);
		Vec3 above = target.position().add(0, 4, 0);
		p.teleportTo(above.x, above.y, above.z);
		puff(level, above, Element.STEEL, 0.6F);
		p.setDeltaMovement(0, -1.8, 0);
		p.syncVelocity = true;
		sound(level, above, SoundEvents.TRIDENT_RIPTIDE_1.value(), 1, 1.2F);
		Techniques.after(level, 4, () -> {
			p.fallDistance = 0;
			if (!target.isAlive() || p.distanceTo(target) > 4)
				return;
			hurt(p, target, 16, Element.STEEL);
			level.sendParticles(ParticleTypes.CRIT, target.getX(), target.getY(0.8), target.getZ(), 20, 0.3, 0.5, 0.3, 0.3);
			Vec3 spot = target.position();
			channel(p, 40, 1, t -> {
				if (target.isAlive()) {
					ClanJutsu.hold(target);
					if (target.position().distanceToSqr(spot) > 0.04)
						target.teleportTo(spot.x, spot.y, spot.z);
				}
			});
		});
	}

	// ------------------------------------------------------------------ Shibuki
	/** A paper tag on the struck enemy goes off (the wielder is braced against it). */
	private static void blast(ServerPlayer p, LivingEntity target) {
		ServerLevel level = level(p);
		Vec3 at = target.getBoundingBox().getCenter();
		p.addEffect(new MobEffectInstance(MobEffects.RESISTANCE, 5, 4, false, false));
		blastAt(level, at, 2.5F, 9, 1.1F, Element.FIRE, p);
		level.sendParticles(ParticleTypes.EXPLOSION, at.x, at.y, at.z, 1, 0, 0, 0, 0);
		sound(level, at, SoundEvents.GENERIC_EXPLODE.value(), 1, 1.2F);
	}

	/** Blastsword: Earth Rupture: the blade is slammed into the ground and a line of blasts tears forward through the earth. */
	private static void earthRupture(ServerPlayer p) {
		ServerLevel level = level(p);
		Vec3 dir = p.getLookAngle().multiply(1, 0, 1).normalize(), start = p.position();
		swing(p);
		p.addEffect(new MobEffectInstance(MobEffects.RESISTANCE, 40, 4, false, false));
		channel(p, 8, 1, t -> {
			Vec3 at = start.add(dir.scale(2 + t * 1.6));
			BlockPos ground = NatureJutsu.ground(level, at.x, start.y, at.z);
			Vec3 c = Vec3.atBottomCenterOf(ground);
			BlockState soil = level.getBlockState(ground.below());
			if (!soil.isAir())
				level.sendParticles(new BlockParticleOption(ParticleTypes.BLOCK, soil), c.x, c.y + 0.2, c.z, 30, 0.6, 0.3, 0.6, 0.3);
			level.sendParticles(ParticleTypes.EXPLOSION, c.x, c.y + 0.5, c.z, 1, 0, 0, 0, 0);
			sound(level, c, SoundEvents.GENERIC_EXPLODE.value(), 1, 1.1F);
			for (LivingEntity target : enemies(level, p, new AABB(c, c).inflate(2, 2, 2), e -> true)) {
				hurt(p, target, 10, Element.FIRE);
				target.push(0, 0.6, 0);
				target.syncVelocity = true;
			}
		});
	}

	/**
	 * Blastsword Technique: Blasting Bridle Repeating Death: the scroll of tags unrolls all around and they go off one after
	 * another in widening rings.
	 */
	private static void repeatingDeath(ServerPlayer p) {
		ServerLevel level = level(p);
		Vec3 c = p.position();
		p.addEffect(new MobEffectInstance(MobEffects.RESISTANCE, 60, 4, false, false));
		sound(level, c, SoundEvents.TNT_PRIMED, 1.5F, 1);
		channel(p, 30, 3, t -> {
			double r = 2 + t * 0.35;
			for (int i = 0; i < 6; i++) {
				double a = i * Math.PI / 3 + t * 0.4;
				Vec3 at = c.add(Math.cos(a) * r, 0.5, Math.sin(a) * r);
				level.sendParticles(ParticleTypes.EXPLOSION, at.x, at.y, at.z, 1, 0, 0, 0, 0);
				for (LivingEntity target : enemies(level, p, new AABB(at, at).inflate(1.8), e -> true)) {
					hurt(p, target, 6, Element.FIRE);
					Vec3 away = target.position().subtract(c).normalize();
					target.push(away.x * 0.6, 0.3, away.z * 0.6);
					target.syncVelocity = true;
				}
			}
			sound(level, c, SoundEvents.GENERIC_EXPLODE.value(), 1.2F, 1 + t * 0.01F);
		});
	}

	// ------------------------------------------------------------------ every tick: flows, guards, rituals, forms, storing
	@SubscribeEvent
	public static void tick(PlayerTickEvent.Post event) {
		if (!(event.getEntity() instanceof ServerPlayer p))
			return;
		long time = now(p);
		Flow flow = FLOWS.get(p.getUUID());
		if (flow != null) {
			if (flow.until < time || !holds(p, flow.weapon)) {
				endFlow(p);
				tell(p, flow.name + " ended");
			} else
				drawFlow(p, flow);
		}
		Guard guard = GUARDS.get(p.getUUID());
		if (guard != null) {
			if (guard.until < time || !holds(p, "gunbai")) {
				GUARDS.remove(p.getUUID());
				releaseGuard(p, guard);
			} else {
				Vec3 front = p.getEyePosition().add(p.getLookAngle().scale(0.8));
				level(p).sendParticles(Element.GENJUTSU.trail, front.x, front.y - 0.3, front.z, 2, 0.4, 0.4, 0.4, 0);
				// what flies at the fan goes back where it came from
				for (Projectile shot : level(p).getEntitiesOfClass(Projectile.class, p.getBoundingBox().inflate(2.5), e -> e.getOwner() != p
						&& e.getDeltaMovement().dot(p.position().subtract(e.position())) > 0 && e.position().subtract(p.position()).dot(p.getLookAngle()) > 0)) {
					shot.setDeltaMovement(shot.getDeltaMovement().scale(-1.1));
					shot.setOwner(p);
					if (shot instanceof JutsuProjectile jutsu)
						guard.stored[0] += jutsu.damage * 0.3F;
					sound(level(p), shot.position(), SoundEvents.SHIELD_BLOCK.value(), 1, 1.2F);
				}
			}
		}
		Ritual ritual = RITUALS.get(p.getUUID());
		if (ritual != null) {
			if (ritual.until < time)
				RITUALS.remove(p.getUUID());
			else if (time % 4 == 0)
				drawRitual(p, ritual);
		}
		if (STORING.contains(p.getUUID())) {
			ItemStack held = p.getMainHandItem();
			PlayerVariables v = NarutoShippudenModVariables.get(p);
			if (!path(held).startsWith("hiramekarei"))
				STORING.remove(p.getUUID());
			else if (time % 10 == 0 && v.ChakraAmount >= 5 && stored(held) < 1000) {
				NarutoShippudenModVariables.ifPresent(p, vars -> {
					vars.ChakraAmount -= 5;
					vars.syncPlayerVariables(p);
				});
				StackTag.of(held).putDouble("StoredChakra", stored(held) + 5);
				level(p).sendParticles(Element.CHAKRA.trail, hand(p).x, hand(p).y, hand(p).z, 3, 0.2, 0.3, 0.2, 0.01);
			}
		}
		if (time % 10 == 0)
			forms(p, time);
	}

	/** Forms run out; old second twinswords vanish; the old Gunbai block item turns back into the Gunbai. */
	private static void forms(ServerPlayer p, long time) {
		ItemStack main = p.getMainHandItem();
		String held = path(main);
		if ((held.equals("hiramekarei_splitted") || held.equals("hiramekarei_hammer_form")) && StackTag.of(main).getDoubleOr("FormUntil", 0) < time)
			revertForm(p);
		for (int slot = 0; slot < p.getInventory().getContainerSize(); slot++) {
			ItemStack stack = p.getInventory().getItem(slot);
			if (stack.isEmpty())
				continue;
			// the second twinsword an earlier version put in the off hand
			if (StackTag.of(stack).getBooleanOr("TwinCopy", false))
				p.getInventory().setItem(slot, ItemStack.EMPTY);
			else if (path(stack).equals("gunbai_block"))
				p.getInventory().setItem(slot, stack.transmuteCopy(BuiltInRegistries.ITEM.getValue(id("gunbai")), 1));
		}
	}

	// ------------------------------------------------------------------ hits
	private static final Map<UUID, Long> WARNED = new HashMap<>();

	/** Melee hits with a weapon: too little Kenjutsu halves them; a flow adds its damage; Uchiha Return takes attacks from the front. */
	@SubscribeEvent
	public static void incoming(LivingIncomingDamageEvent event) {
		LivingEntity victim = event.getEntity();
		if (victim instanceof ServerPlayer guarded) {
			Guard guard = GUARDS.get(guarded.getUUID());
			Entity from = event.getSource().getDirectEntity() != null ? event.getSource().getDirectEntity() : event.getSource().getEntity();
			if (guard != null && from != null && from != guarded && from.position().subtract(guarded.position()).dot(guarded.getLookAngle()) > 0) {
				guard.stored[0] += event.getAmount();
				event.setCanceled(true);
				sound(level(guarded), guarded.position(), SoundEvents.SHIELD_BLOCK.value(), 1, 0.9F);
				return;
			}
		}
		if (!(event.getSource().getDirectEntity() instanceof ServerPlayer p) || !event.getSource().is(DamageTypes.PLAYER_ATTACK))
			return;
		String weapon = path(p.getMainHandItem());
		Integer needed = KENJUTSU.get(weapon);
		if (needed != null && NarutoShippudenModVariables.get(p).kenjutsu < needed) {
			event.setAmount(event.getAmount() * 0.5F);
			if (WARNED.getOrDefault(p.getUUID(), 0L) < now(p)) {
				WARNED.put(p.getUUID(), now(p) + 200);
				tell(p, "Not enough Kenjutsu to wield this well (" + needed + " needed)");
			}
		}
		Flow flow = FLOWS.get(p.getUUID());
		if (flow != null && holds(p, flow.weapon))
			event.setAmount(event.getAmount() + flow.damage);
	}

	/** After a weapon hit lands: flows' effects, Samehada's feeding, Kubikiribocho's mending, the scythe's blood, the hammer's shockwave. */
	@SubscribeEvent
	public static void hit(LivingDamageEvent.Post event) {
		LivingEntity target = event.getEntity();
		if (event.getSource().getDirectEntity() instanceof ServerPlayer p && event.getSource().is(DamageTypes.PLAYER_ATTACK)) {
			ItemStack weapon = p.getMainHandItem();
			String held = path(weapon);
			Flow flow = FLOWS.get(p.getUUID());
			if (flow != null && holds(p, flow.weapon) && flow.onHit != null)
				flow.onHit.accept(p, target);
			switch (held) {
				case "samehada" -> absorb(p, target, 0.05);
				case "kubikiribocho" -> weapon.setDamageValue(Math.max(0, weapon.getDamageValue() - 5));
				case "triple_blade_scythe" -> drawBlood(p, target);
				case "hiramekarei_hammer_form" -> {
					ServerLevel level = level(p);
					for (LivingEntity near : enemies(level, p, target.getBoundingBox().inflate(2.5), e -> e != target))
						hurt(p, near, 6, Element.CHAKRA);
					puff(level, target.position(), Element.CHAKRA, 1.5F);
					sound(level, target.position(), SoundEvents.MACE_SMASH_GROUND, 1, 0.8F);
				}
				default -> {
				}
			}
		}
		// Jashin's curse: the ritual's wounds are shared with the marked enemy
		if (target instanceof ServerPlayer p && event.getInflictedDamage() > 0) {
			Ritual ritual = RITUALS.get(p.getUUID());
			if (ritual != null && ritual.until >= now(p) && p.position().distanceTo(ritual.centre) < 1.8
					&& level(p).getEntity(ritual.target) instanceof LivingEntity linked && linked.isAlive() && !event.getSource().is(Techniques.JUTSU)) {
				Techniques.damage(p, linked, event.getInflictedDamage() / Techniques.power(p), Element.BLOOD);
				level(p).sendParticles(Element.BLOOD.puff, linked.getX(), linked.getY(0.6), linked.getZ(), 12, 0.3, 0.4, 0.3, 0.05);
			}
		}
	}

	/** Kubikiribocho reforms from the iron in its victims' blood: a kill mends it a lot. */
	@SubscribeEvent
	public static void kill(LivingDeathEvent event) {
		if (event.getSource().getEntity() instanceof ServerPlayer p && path(p.getMainHandItem()).equals("kubikiribocho"))
			p.getMainHandItem().setDamageValue(Math.max(0, p.getMainHandItem().getDamageValue() - 20));
	}

	@SubscribeEvent
	public static void stopping(ServerStoppingEvent event) {
		for (Display.ItemDisplay display : FLYING)
			display.discard();
		FLYING.clear();
		FLOWS.clear();
		GUARDS.clear();
		RITUALS.clear();
		STORING.clear();
	}
}
