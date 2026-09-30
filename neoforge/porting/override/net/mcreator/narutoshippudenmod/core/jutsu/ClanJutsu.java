package net.mcreator.narutoshippudenmod.core.jutsu;

import static net.mcreator.narutoshippudenmod.core.jutsu.NatureJutsu.level;
import static net.mcreator.narutoshippudenmod.core.jutsu.NatureJutsu.nature;
import static net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.after;
import static net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.burst;
import static net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.channel;
import static net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.cone;
import static net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.damage;
import static net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.enemies;
import static net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.line;
import static net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.lookPoint;
import static net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.puff;
import static net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.shoot;
import static net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.sound;
import static net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.spray;
import static net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.turned;

import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables;
import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables.PlayerVariables;
import net.mcreator.narutoshippudenmod.core.EntityScale;
import net.mcreator.narutoshippudenmod.core.jutsu.NatureJutsu.Def;
import net.mcreator.narutoshippudenmod.core.jutsu.engine.Displays;
import net.mcreator.narutoshippudenmod.core.jutsu.engine.Element;
import net.mcreator.narutoshippudenmod.core.jutsu.engine.JutsuEngine;
import net.mcreator.narutoshippudenmod.core.jutsu.engine.JutsuProjectile;
import net.mcreator.narutoshippudenmod.core.jutsu.engine.JutsuProjectile.Shape;
import net.mcreator.narutoshippudenmod.core.jutsu.engine.JutsuRank;
import net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques;
import net.mcreator.narutoshippudenmod.entity.SummonEntities.AkamaruEntity;

import net.minecraft.core.Holder;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.OwnableEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.Display;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

import org.jspecify.annotations.Nullable;
import org.joml.Matrix4f;

/**
 * The clans' techniques on the jutsu engine. Transformations (the Akimichi tank and butterfly, Passing Fang) keep their player models, switched on by the old flags for a set time; the Eight Gates are timed modes that
 * cost health. Like the natures, each clan keeps its old save variables and prices every jutsu by its {@link JutsuRank}.
 */
@EventBusSubscriber(modid = "naruto_shippuden")
public final class ClanJutsu {
	private ClanJutsu() {
	}

	static void register() {
		Jutsus.TECHNIQUES.get(Identifier.fromNamespaceAndPath("naruto_shippuden", "shadow_clone_technique")).onSneak = ShadowClones::release;
		FlyingRaijin.register();
		nature("aburame", "Aburame Clan", v -> v.aburamereleaselogic, v -> v.aburametechnique, (v, i) -> v.aburametechnique = i, v -> v.aburamelearn,
				(v, i) -> v.aburamelearn = i, v -> v.aburame_release, (v, i) -> v.aburame_release = i,
				new Def("Parasitic Destruction Insect Technique", JutsuRank.C, ClanJutsu::insectCloud),
				new Def("Insect Clone Technique", JutsuRank.C, ClanJutsu::insectClone),
				new Def("Insect Jar Technique", JutsuRank.B, ClanJutsu::insectJar),
				new Def("Secret Technique: Insect Bog", JutsuRank.A, ClanJutsu::insectBog),
				new Def("Secret Technique: Insect Sphere", JutsuRank.S, ClanJutsu::insectSphere));
		nature("akimichi", "Akimichi Clan", v -> v.akimichireleaselogic, v -> v.akimichitechnique, (v, i) -> v.akimichitechnique = i,
				v -> v.akimichilearn, (v, i) -> v.akimichilearn = i, v -> v.akimichirelease, (v, i) -> v.akimichirelease = i,
				new Def("Partial Multi-Size Technique", JutsuRank.D, ClanJutsu::partialMultiSize),
				new Def("Multi-Size Technique", JutsuRank.C, ClanJutsu::expansion),
				new Def("Human Bullet Tank", JutsuRank.B, p -> bulletTank(p, false)),
				new Def("Super Open Hand Slap", JutsuRank.B, ClanJutsu::openHandSlap, "Taijutsu"),
				new Def("Spiked Human Bullet Tank", JutsuRank.A, p -> bulletTank(p, true)),
				new Def("Butterfly Mode", JutsuRank.S, ClanJutsu::butterfly),
				new Def("Butterfly Bullet Bombing", JutsuRank.S, ClanJutsu::butterflyBombing, "Taijutsu"));
		nature("fuma", "Fuma Clan", v -> v.fumareleaselogic, v -> v.fumatechnique, (v, i) -> v.fumatechnique = i, v -> v.fumalearn,
				(v, i) -> v.fumalearn = i, v -> v.fumarelease, (v, i) -> v.fumarelease = i,
				new Def("Shuriken Barrage", JutsuRank.D, ClanJutsu::shurikenBarrage),
				new Def("Fuma Shuriken", JutsuRank.C, ClanJutsu::fumaShuriken),
				new Def("Toroi's Magnetic Fuma Shuriken", JutsuRank.B, ClanJutsu::toroiShuriken));
		nature("hozuki", "Hozuki Clan", v -> v.hozukireleaselogic, v -> v.hozukitechnique, (v, i) -> v.hozukitechnique = i, v -> v.hozukilearn,
				(v, i) -> v.hozukilearn = i, v -> v.hozukirelease, (v, i) -> v.hozukirelease = i,
				new Def("Water Gun Technique", JutsuRank.D, ClanJutsu::waterPistol),
				new Def("Water Gun: Two Guns", JutsuRank.D, ClanJutsu::twoGuns),
				new Def("Hydrification Technique", JutsuRank.C, ClanJutsu::hydrification),
				new Def("Drowning Water Blob Technique", JutsuRank.C, ClanJutsu::drowningBlob),
				new Def("Great Water Arm Technique", JutsuRank.B, ClanJutsu::waterArm),
				new Def("Tate Eboshi", JutsuRank.A, ClanJutsu::tateEboshi));
		nature("hyuga", "Hyuga Clan", v -> v.hyugareleaselogic, v -> v.hyugatechnique, (v, i) -> v.hyugatechnique = i, v -> v.hyugalearn,
				(v, i) -> v.hyugalearn = i, v -> v.hyugarelease, (v, i) -> v.hyugarelease = i,
				new Def("Gentle Fist", JutsuRank.D, ClanJutsu::gentleFist, "Taijutsu"),
				new Def("Gentle Step Twin Lion Fists", JutsuRank.C, ClanJutsu::twinLions),
				new Def("Eight Trigrams Twin Lions Crumbling Attack", JutsuRank.B, ClanJutsu::crumblingAttack),
				new Def("Gentle Fist Art One Blow Body", JutsuRank.B, ClanJutsu::oneBlowBody, "Taijutsu"),
				new Def("Eight Trigrams Palms Revolving Heaven", JutsuRank.A, ClanJutsu::rotation),
				new Def("Eight Trigrams Sixty-Four Palms", JutsuRank.S, ClanJutsu::sixtyFourPalms, "Taijutsu"));
		nature("inuzuka", "Inuzuka Clan", v -> v.inuzukareleaselogic, v -> v.inuzukatechnique, (v, i) -> v.inuzukatechnique = i,
				v -> v.inuzukalearn, (v, i) -> v.inuzukalearn = i, v -> v.inuzuka_release, (v, i) -> v.inuzuka_release = i,
				new Def("Akamaru", JutsuRank.D, ClanJutsu::akamaru, "Summoning"),
				new Def("Four Legs Technique", JutsuRank.D, ClanJutsu::fourLegs, "Taijutsu"),
				new Def("Dynamic Marking", JutsuRank.D, ClanJutsu::dynamicMarking),
				new Def("Passing Fang", JutsuRank.C, ClanJutsu::passingFang, "Taijutsu"),
				new Def("Beast Human Clone", JutsuRank.C, ClanJutsu::manBeastClone),
				new Def("Fang Passing Fang", JutsuRank.B, ClanJutsu::fangOverFang, "Taijutsu"),
				new Def("Fang Rotating Fang", JutsuRank.A, ClanJutsu::fangRotatingFang, "Taijutsu"));
		nature("lee", "Lee Clan", v -> v.leereleaselogic, v -> v.lee_technique, (v, i) -> v.lee_technique = i, v -> v.leelearn,
				(v, i) -> v.leelearn = i, v -> v.lee_release, (v, i) -> v.lee_release = i,
				new Def("Drunken Fist", JutsuRank.D, ClanJutsu::drunkenFist, "Taijutsu"),
				new Def("Gate of Opening", JutsuRank.D, p -> gate(p, 1), "Taijutsu"),
				new Def("Gate of Healing", JutsuRank.D, p -> gate(p, 2), "Taijutsu"),
				new Def("Gate of Life", JutsuRank.C, p -> gate(p, 3), "Taijutsu"),
				new Def("Gate of Pain", JutsuRank.C, p -> gate(p, 4), "Taijutsu"),
				new Def("Gate of Limit: Hidden Lotus", JutsuRank.B, p -> gate(p, 5), "Taijutsu"),
				new Def("Gate of View: Morning Peacock", JutsuRank.B, p -> gate(p, 6), "Taijutsu"),
				new Def("Gate of Wonder: Daytime Tiger", JutsuRank.A, p -> gate(p, 7), "Taijutsu"),
				new Def("Gate of Death: Night Guy", JutsuRank.S, p -> gate(p, 8), "Taijutsu"));
		nature("nara", "Nara Clan", v -> v.narareleaselogic, v -> v.naratechnique, (v, i) -> v.naratechnique = i, v -> v.naralearn,
				(v, i) -> v.naralearn = i, v -> v.nararelease, (v, i) -> v.nararelease = i,
				new Def("Shadow Imitation Shuriken Technique", JutsuRank.D, ClanJutsu::shadowShuriken),
				new Def("Shadow Imitation Technique", JutsuRank.C, ClanJutsu::shadowImitation),
				new Def("Shadow Gathering Technique", JutsuRank.B, ClanJutsu::shadowGathering),
				new Def("Shadow–Neck Binding Technique", JutsuRank.B, ClanJutsu::neckBinding),
				new Def("Shadow Sewing Technique", JutsuRank.A, ClanJutsu::shadowSewing),
				new Def("Shadow Imitation Field Technique", JutsuRank.S, ClanJutsu::imitationField));
		Jutsus.TECHNIQUES.get(Identifier.fromNamespaceAndPath("naruto_shippuden", "nara_release_technique")).onSneak = ClanJutsu::releaseShadow;
		nature("sarutobi", "Sarutobi Clan", v -> v.sarutobireleaselogic, v -> v.sarutobitechnique, (v, i) -> v.sarutobitechnique = i,
				v -> v.sarutobilearn, (v, i) -> v.sarutobilearn = i, v -> v.sarutobirelease, (v, i) -> v.sarutobirelease = i,
				new Def("Ash Pile Burning", JutsuRank.C, ClanJutsu::ashPile),
				new Def("Great Flame Technique", JutsuRank.B, NatureJutsu::greatFlame),
				new Def("Fire Dragon Flame Bullet", JutsuRank.A, ClanJutsu::flameBullet));
		nature("uzumaki", "Uzumaki Clan", v -> v.uzumakireleaselogic, v -> v.uzumakitechnique, (v, i) -> v.uzumakitechnique = i,
				v -> v.uzumakilearn, (v, i) -> v.uzumakilearn = i, v -> v.uzumakirelease, (v, i) -> v.uzumakirelease = i,
				new Def("Adamantine Sealing Chains", JutsuRank.C, ClanJutsu::sealingChains),
				new Def("Heal Bite", JutsuRank.B, ClanJutsu::healBite),
				new Def("Four Symbols Seal", JutsuRank.B, ClanJutsu::fourSymbolsSeal),
				new Def("Uzumaki Sealing Technique", JutsuRank.A, ClanJutsu::uzumakiSealing),
				new Def("Dead Demon Consuming Seal", JutsuRank.S, ClanJutsu::deadDemon));
		nature("tsuchigumo", "Tsuchigumo Clan", v -> v.tsuchigumoreleaselogic, v -> v.tsuchigumotechnique, (v, i) -> v.tsuchigumotechnique = i, v -> v.tsuchigumolearn, (v, i) -> v.tsuchigumolearn = i, v -> v.tsuchigumorelease, (v, i) -> v.tsuchigumorelease = i,
				new Def("Creation of Heaven and Earth", JutsuRank.A, ClanJutsu::creation),
				new Def("Fury", JutsuRank.S, ClanJutsu::fury));
		nature("uchiha", "Uchiha Clan", v -> v.uchihareleaselogic, v -> v.uchihatechnique, (v, i) -> v.uchihatechnique = i, v -> v.uchihalearn,
				(v, i) -> v.uchihalearn = i, v -> v.uchiharelease, (v, i) -> v.uchiharelease = i,
				new Def("Manipulating Windmill Triple Blades", JutsuRank.D, ClanJutsu::windmillBlades),
				new Def("Uchiha Return", JutsuRank.C, ClanJutsu::uchihaReturn),
				new Def("Uchiha Flame Formation", JutsuRank.A, ClanJutsu::flameFormation),
				new Def("Great Fire Destruction", JutsuRank.S, ClanJutsu::greatFireDestruction));
		nature("yamanaka", "Yamanaka Clan", v -> v.yamanakareleaselogic, v -> v.yamanakatechnique, (v, i) -> v.yamanakatechnique = i, v -> v.yamanakalearn,
				(v, i) -> v.yamanakalearn = i, v -> v.yamanakarelease, (v, i) -> v.yamanakarelease = i,
				new Def("Mind Body Transmission Technique", JutsuRank.D, ClanJutsu::mindTransmission),
				new Def("Mind Body Switch Technique", JutsuRank.C, ClanJutsu::mindSwitch),
				new Def("Mind Body Disturbance Technique", JutsuRank.B, ClanJutsu::mindDisturbance),
				new Def("Mind Body Transmission Formation", JutsuRank.A, ClanJutsu::mindFormation),
				new Def("Mind Clone Switch Technique", JutsuRank.S, ClanJutsu::mindCloneSwitch));
	}

	/** The old item hooks (hit or swing with a clan technique) did the old jutsu's effects; the remade jutsu don't use them. */
	public static void unused(Map<String, Object> dependencies) {
	}

	// ------------------------------------------------------------------ helpers
	static void set(ServerPlayer p, Consumer<PlayerVariables> change) {
		NarutoShippudenModVariables.ifPresent(p, v -> {
			change.accept(v);
			v.syncPlayerVariables(p);
		});
	}

	/** Keeps an effect on while re-applied every 10 ticks (no particles, shown on the HUD). */
	static void keep(LivingEntity entity, Holder<MobEffect> effect, int amplifier) {
		if (amplifier >= 0)
			entity.addEffect(new MobEffectInstance(effect, effect == MobEffects.NIGHT_VISION ? 260 : 25, amplifier, false, false, true));
	}

	private static void tell(ServerPlayer p, String message) {
		p.sendOverlayMessage(Component.literal(message));
	}

	/** The enemy the caster is looking at (closest to the crosshair, in sight), within range. */
	static @Nullable LivingEntity target(ServerPlayer p, double range) {
		Vec3 eye = p.getEyePosition(), look = p.getLookAngle();
		LivingEntity best = null;
		double bestScore = 0.9;
		for (LivingEntity e : enemies(level(p), p, p.getBoundingBox().inflate(range), e -> true)) {
			Vec3 to = e.getBoundingBox().getCenter().subtract(eye);
			double distance = to.length(), score = to.normalize().dot(look) - distance / (range * 20);
			if (distance <= range && score > bestScore && p.hasLineOfSight(e)) {
				bestScore = score;
				best = e;
			}
		}
		return best;
	}

	/** A projectile that starts somewhere other than the caster's eyes. */
	static JutsuProjectile spawn(ServerPlayer p, Element element, Shape shape, float size, Vec3 at, Vec3 velocity, float damage) {
		JutsuProjectile projectile = new JutsuProjectile(JutsuEngine.PROJECTILE, level(p));
		projectile.look(element, shape, size);
		projectile.setOwner(p);
		projectile.setPos(at);
		projectile.setDeltaMovement(velocity);
		projectile.damage = damage;
		level(p).addFreshEntity(projectile);
		return projectile;
	}

	/** A see-through sphere around an entity (or standing at a point) for a while: Rotation, water prisons, insect jars. */
	static JutsuProjectile shell(ServerPlayer p, @Nullable Entity on, Vec3 at, Element element, float size, int ticks) {
		JutsuProjectile shell = spawn(p, element, Shape.SHELL, size, at.subtract(0, size / 2, 0), Vec3.ZERO, 0);
		shell.pierce = -1;
		shell.knockback = 0;
		shell.life = ticks;
		if (on != null)
			channel(p, ticks, 1, t -> {
				if (on.isAlive() && shell.isAlive())
					shell.setPos(on.getBoundingBox().getCenter().subtract(0, size / 2, 0));
			});
		return shell;
	}

	/** Turns a flag on for a while (a model such as Passing Fang's drill), without ending the caster's mode. */
	static void flag(ServerPlayer p, int ticks, Consumer<PlayerVariables> on, Consumer<PlayerVariables> off) {
		set(p, on);
		after(level(p), ticks, () -> set(p, off));
	}

	// ------------------------------------------------------------------ modes (one at a time: a new one ends the last)
	private static final Map<UUID, Integer> MODE = new HashMap<>();
	private static final Map<UUID, Runnable> MODE_END = new HashMap<>();

	/**
	 * A timed transformation or stance: on sets its flags (and the model), each runs every tick, and off (plus the size going
	 * back to normal) runs when it ends, when another mode starts, or when the caster dies or leaves.
	 */
	static void mode(ServerPlayer p, int ticks, float scale, Consumer<PlayerVariables> on, Consumer<PlayerVariables> off, IntConsumer each) {
		endMode(p);
		int generation = MODE.merge(p.getUUID(), 1, Integer::sum);
		set(p, on);
		if (scale != 1)
			EntityScale.set(p, EntityScale.BASE, scale);
		MODE_END.put(p.getUUID(), () -> {
			set(p, off);
			if (scale != 1)
				EntityScale.set(p, EntityScale.BASE, 1);
		});
		channel(p, ticks, 1, t -> {
			if (!Integer.valueOf(generation).equals(MODE.get(p.getUUID())))
				return;
			each.accept(t);
			if (t == ticks - 1)
				endMode(p);
		});
	}

	private static void endMode(ServerPlayer p) {
		Runnable end = MODE_END.remove(p.getUUID());
		if (end != null)
			end.run();
	}

	/** Ends the caster's transformation or stance at once. */
	public static void stop(ServerPlayer p) {
		endMode(p);
		letGo(p);
		DRUNK.remove(p.getUUID());
		set(p, ClanJutsu::clearFlags);
	}

	/** Flags left on by a crash or an old save would keep the model forever. */
	static void clearFlags(PlayerVariables v) {
		v.HumanBulletTank = v.SpikedHumanBulletTank = v.ButterflyMode = false;
		v.tenromode = v.izunochakramode = v.izunocat = v.PassingFang = v.deathgod = v.Gate8 = false;
		v.EightTrigramsPalmsRevolvingHeaven = v.InsectJarTechnique = false;
		v.inuzuka_mode = 0;
		v.gateslee = 0;
		v.magnet_coat = 0;
	}

	@SubscribeEvent
	public static void loggedIn(PlayerEvent.PlayerLoggedInEvent event) {
		if (event.getEntity() instanceof ServerPlayer player)
			set(player, ClanJutsu::clearFlags);
	}

	@SubscribeEvent
	public static void loggedOut(PlayerEvent.PlayerLoggedOutEvent event) {
		if (event.getEntity() instanceof ServerPlayer player) {
			endMode(player);
			letGo(player);
		}
	}

	@SubscribeEvent
	public static void died(LivingDeathEvent event) {
		if (event.getEntity() instanceof ServerPlayer player) {
			endMode(player);
			letGo(player);
			set(player, ClanJutsu::clearFlags);
		}
	}

	// ------------------------------------------------------------------ aburame
	/** A buzzing swarm of insects around a point that poisons and eats at everything in it. */
	private static void swarm(ServerPlayer p, Vec3 at, double radius, int ticks) {
		ServerLevel level = level(p);
		channel(p, ticks, 2, t -> {
			for (int i = 0; i < 40; i++) {
				double a = level.getRandom().nextDouble() * Math.PI * 2, r = Math.sqrt(level.getRandom().nextDouble()) * radius;
				double y = level.getRandom().nextDouble() * 2.4;
				level.sendParticles(i % 4 == 0 ? Element.INSECT.puff : Element.INSECT.trail, at.x + Math.cos(a) * r, at.y + y, at.z + Math.sin(a) * r, 1, 0.1, 0.1, 0.1, 0.03);
			}
			if (t % 10 == 0) {
				for (LivingEntity target : enemies(level, p, new AABB(at, at).inflate(radius, 3, radius), e -> e.distanceToSqr(at) <= radius * radius + 4))
					damage(p, target, 1.5F, Element.INSECT);
				sound(level, at, SoundEvents.BEEHIVE_WORK, 0.8F, 1.5F);
			}
		});
	}

	/** A cloud of insects flies out (drawn to enemies) and swarms where it lands for five seconds. */
	private static void insectCloud(ServerPlayer p) {
		JutsuProjectile cloud = shoot(p, Element.INSECT, Shape.NONE, 1.4F, 0.7F, 2);
		cloud.homing = 0.15F;
		cloud.life = 40;
		cloud.knockback = 0;
		cloud.onImpact = c -> swarm(p, c.position(), 3.5, 100);
		channel(p, 40, 1, t -> {
			if (cloud.isAlive())
				level(p).sendParticles(Element.INSECT.trail, cloud.getX(), cloud.getY() + 0.7, cloud.getZ(), 25, 0.7, 0.6, 0.7, 0.04);
		});
		sound(level(p), p.getEyePosition(), SoundEvents.BEEHIVE_WORK, 1.5F, 1.2F);
	}

	/** Insects wall in the enemy being looked at (or the spot): trapped, slowed and drained for five seconds. */
	private static void insectJar(ServerPlayer p) {
		ServerLevel level = level(p);
		LivingEntity target = target(p, 20);
		sound(level, p.getEyePosition(), SoundEvents.BEEHIVE_WORK, 2, 0.9F);
		if (target == null) {
			Vec3 at = lookPoint(p, 20);
			shell(p, null, at.add(0, 1.2, 0), Element.INSECT, 4.5F, 100);
			swarm(p, at, 2.2, 100);
			return;
		}
		float size = Math.max(target.getBbWidth(), target.getBbHeight()) + 1.2F;
		shell(p, target, target.getBoundingBox().getCenter(), Element.INSECT, size, 100);
		channel(p, 100, 5, t -> {
			if (!target.isAlive())
				return;
			target.addEffect(new MobEffectInstance(MobEffects.SLOWNESS, 10, 3, false, false));
			if (t % 10 == 0) {
				damage(p, target, 2.5F, Element.INSECT);
				// the bugs feed on chakra
				if (target instanceof ServerPlayer victim)
					set(victim, v -> v.ChakraAmount = Math.max(0, v.ChakraAmount - 20));
			}
		});
	}

	/** A carpet of insects spreads forward over the ground, bogging down and eating everything on it. */
	private static void insectBog(ServerPlayer p) {
		ServerLevel level = level(p);
		Vec3 origin = p.position(), dir = p.getLookAngle().multiply(1, 0, 1).normalize(), side = new Vec3(-dir.z, 0, dir.x);
		double cos = Math.cos(Math.toRadians(35));
		sound(level, origin, SoundEvents.BEEHIVE_WORK, 2, 0.6F);
		channel(p, 80, 2, t -> {
			double reach = Math.min(14, 2 + t * 0.4);
			for (int i = 0; i < 22; i++) {
				double d = level.getRandom().nextDouble() * reach, s = (level.getRandom().nextDouble() - 0.5) * d * 1.2;
				Vec3 at = origin.add(dir.scale(d)).add(side.scale(s));
				level.sendParticles(i % 3 == 0 ? Element.INSECT.puff : Element.INSECT.trail, at.x, at.y + 0.15, at.z, 1, 0.2, 0.05, 0.2, 0.01);
			}
			if (t % 10 != 0)
				return;
			Vec3 middle = origin.add(dir.scale(reach / 2));
			for (LivingEntity target : enemies(level, p, new AABB(middle, middle).inflate(reach / 2 + 1, 2, reach / 2 + 1), e -> {
				Vec3 to = e.position().subtract(origin).multiply(1, 0, 1);
				return to.length() <= reach && to.normalize().dot(dir) >= cos;
			})) {
				target.addEffect(new MobEffectInstance(MobEffects.SLOWNESS, 30, 4, false, false));
				target.setDeltaMovement(target.getDeltaMovement().multiply(0.2, 0, 0.2).add(0, Math.min(0, target.getDeltaMovement().y), 0));
				damage(p, target, 3, Element.INSECT);
			}
		});
	}

	// ------------------------------------------------------------------ akimichi
	/** Grows to a giant for twenty seconds: much stronger and tougher, a little slower. */
	private static void expansion(ServerPlayer p) {
		puff(level(p), p.position().add(0, 1, 0), Element.BEAST, 2);
		sound(level(p), p.position(), SoundEvents.RAVAGER_ROAR, 1, 0.8F);
		mode(p, 400, 2.5F, v -> {
		}, v -> {
		}, t -> {
			if (t % 10 == 0) {
				keep(p, MobEffects.STRENGTH, 1);
				keep(p, MobEffects.RESISTANCE, 0);
				keep(p, MobEffects.SLOWNESS, 0);
			}
		});
	}

	/** Swells into a rolling ball (spiked: bigger, faster, longer) that the caster steers, flattening whatever it runs over. */
	private static void bulletTank(ServerPlayer p, boolean spiked) {
		ServerLevel level = level(p);
		int ticks = spiked ? 80 : 60;
		float hurt = spiked ? 12 : 8;
		double speed = spiked ? 1.1 : 0.9;
		Map<LivingEntity, Integer> lastHit = new HashMap<>();
		sound(level, p.position(), SoundEvents.RAVAGER_ROAR, 1, spiked ? 0.7F : 0.9F);
		mode(p, ticks, spiked ? 1.25F : 1, v -> {
			if (spiked)
				v.SpikedHumanBulletTank = true;
			else
				v.HumanBulletTank = true;
		}, v -> v.HumanBulletTank = v.SpikedHumanBulletTank = false, t -> {
			Vec3 look = p.getLookAngle().multiply(1, 0, 1).normalize();
			p.setDeltaMovement(look.x * speed, p.getDeltaMovement().y, look.z * speed);
			p.syncVelocity = true;
			p.fallDistance = 0;
			if (t % 10 == 0)
				keep(p, MobEffects.RESISTANCE, 2);
			level.sendParticles(Element.EARTH.trail, p.getX(), p.getY() + 0.1, p.getZ(), 4, 0.6, 0.05, 0.6, 0.05);
			if (t % 6 == 0)
				sound(level, p.position(), SoundEvents.ROOTED_DIRT_BREAK, 1, 0.5F);
			for (LivingEntity target : enemies(level, p, p.getBoundingBox().inflate(0.8), e -> lastHit.getOrDefault(e, -99) + 10 <= t)) {
				lastHit.put(target, t);
				damage(p, target, hurt, Element.EARTH);
				target.push(look.x * 1.5, 0.55, look.z * 1.5);
				target.syncVelocity = true;
				sound(level, target.position(), SoundEvents.PLAYER_ATTACK_KNOCKBACK, 1, 0.6F);
			}
		});
	}

	private static final Identifier BUTTERFLY_WINGS = Identifier.fromNamespaceAndPath("naruto_shippuden", "butterfly_wings");
	/** Butterfly Mode's wing colours (client/jutsu/AkimichiRenderer draws the wings): every Akimichi is born with one of them. */
	public static final Map<String, Integer> WING_COLOURS = new java.util.LinkedHashMap<>();
	static {
		String[] names = { "Blue", "Green", "Orange", "Pink", "Purple", "Red", "Yellow", "Cyan", "White", "Gold", "Lime", "Crimson", "Violet", "Teal" };
		int[] rgb = { 0x5AB4FF, 0x6BFF7A, 0xFF9A3C, 0xFF7AD0, 0xB070FF, 0xFF4A4A, 0xFFE24A, 0x4AF0FF, 0xF4F4FF, 0xFFC640, 0xB6FF4A, 0xC8143C, 0x8A4AFF,
				0x2AC8A8 };
		for (int i = 0; i < names.length; i++)
			WING_COLOURS.put(names[i], rgb[i]);
	}

	private static String randomWings(ServerPlayer p) {
		List<String> names = List.copyOf(WING_COLOURS.keySet());
		return names.get(p.getRandom().nextInt(names.size()));
	}

	/** Chakra dust in the caster's wing colour. */
	private static net.minecraft.core.particles.DustParticleOptions wingDust(ServerPlayer p, float size) {
		return new net.minecraft.core.particles.DustParticleOptions(WING_COLOURS.getOrDefault(NarutoShippudenModVariables.get(p).ButterFlyModeColor, 0x5AB4FF), size);
	}

	private static final String WINGS_GIVEN = "naruto_shippuden:wings_given";

	/** An Akimichi gets their wing colour once, at random, when they become one (players from before get theirs too). */
	@SubscribeEvent
	public static void wingColour(net.neoforged.neoforge.event.tick.PlayerTickEvent.Post event) {
		if (!(event.getEntity() instanceof ServerPlayer p) || p.tickCount % 40 != 0 || p.getPersistentData().getBooleanOr(WINGS_GIVEN, false)
				|| !NarutoShippudenModVariables.get(p).akimichireleaselogic)
			return;
		String colour = randomWings(p);
		set(p, v -> v.ButterFlyModeColor = colour);
		p.getPersistentData().putBoolean(WINGS_GIVEN, true);
	}

	/** Burns fat into chakra: glowing butterfly wings and thirty seconds of overwhelming strength. */
	private static void butterfly(ServerPlayer p) {
		ServerLevel level = level(p);
		level.sendParticles(wingDust(p, 2), p.getX(), p.getY() + 1, p.getZ(), 60, 1.2, 1, 1.2, 0.1);
		level.sendParticles(wingDust(p, 1), p.getX(), p.getY() + 1, p.getZ(), 60, 0.5, 1, 0.5, 0.25);
		sound(level, p.position(), SoundEvents.BEACON_POWER_SELECT, 1.5F, 0.6F);
		net.minecraft.world.entity.ai.attributes.AttributeInstance glide = p.getAttribute(net.neoforged.neoforge.common.NeoForgeMod.GLIDING_FLIGHT);
		mode(p, 600, 1, v -> {
			v.ButterflyMode = true;
			if (!WING_COLOURS.containsKey(v.ButterFlyModeColor))
				v.ButterFlyModeColor = randomWings(p);
			// the wings glide like an elytra (jump in mid-air to spread them)
			if (glide != null && !glide.hasModifier(BUTTERFLY_WINGS))
				glide.addTransientModifier(new net.minecraft.world.entity.ai.attributes.AttributeModifier(BUTTERFLY_WINGS, 1,
						net.minecraft.world.entity.ai.attributes.AttributeModifier.Operation.ADD_VALUE));
		}, v -> {
			v.ButterflyMode = false;
			if (glide != null)
				glide.removeModifier(BUTTERFLY_WINGS);
		}, t -> {
			if (t % 10 == 0) {
				keep(p, MobEffects.STRENGTH, 3);
				keep(p, MobEffects.SPEED, 1);
				keep(p, MobEffects.RESISTANCE, 1);
				keep(p, MobEffects.JUMP_BOOST, 1);
			}
			// the wings beat: while gliding they carry the caster along their look (climbing too), like a steady rocket
			if (p.isFallFlying() && t % 2 == 0) {
				Vec3 look = p.getLookAngle(), motion = p.getDeltaMovement();
				Vec3 pushed = motion.add(look.scale(0.1)).add(look.scale(1.2).subtract(motion).scale(0.08));
				p.setDeltaMovement(pushed.length() > 1.6 ? pushed.normalize().scale(1.6) : pushed);
				p.syncVelocity = true;
			}
			if (t % 3 == 0)
				level.sendParticles(wingDust(p, 1), p.getX(), p.getY() + 1.3, p.getZ(), 3, 0.9, 0.5, 0.9, 0.01);
		});
	}

	// ------------------------------------------------------------------ fuma
	/** Five shuriken in a fan. */
	private static void shurikenBarrage(ServerPlayer p) {
		for (int i = -2; i <= 2; i++) {
			JutsuProjectile star = shoot(p, Element.STEEL, Shape.SHURIKEN, 0.5F, turned(p, i * 6, 0).scale(1.9), 4);
			star.life = 25;
			star.knockback = 0.2F;
		}
		sound(level(p), p.getEyePosition(), SoundEvents.PLAYER_ATTACK_SWEEP, 1, 1.8F);
	}

	/** A great windmill shuriken that cuts through everything on its way out, then comes back to the thrower. */
	private static void fumaShuriken(ServerPlayer p) {
		JutsuProjectile star = shoot(p, Element.STEEL, Shape.SHURIKEN, 1.6F, 1.3F, 10);
		star.pierce = -1;
		star.life = 60;
		star.knockback = 0.8F;
		channel(p, 60, 1, t -> {
			if (!star.isAlive())
				return;
			if (t >= 14) {
				Vec3 back = p.getEyePosition().subtract(0, 1, 0).subtract(star.position());
				if (back.length() < 1.5) {
					star.discard();
					return;
				}
				star.setDeltaMovement(back.normalize().scale(1.3));
			}
			if (t % 5 == 0)
				sound(level(p), star.position(), SoundEvents.PLAYER_ATTACK_SWEEP, 0.7F, 0.6F);
		});
		sound(level(p), p.getEyePosition(), SoundEvents.PLAYER_ATTACK_SWEEP, 1.2F, 0.7F);
	}

	/** An iron shuriken steered by magnetism: it seeks its target and bursts into four smaller seeking blades. */
	private static void toroiShuriken(ServerPlayer p) {
		JutsuProjectile star = shoot(p, Element.MAGNET, Shape.SHURIKEN, 2.4F, 1.0F, 14);
		star.pierce = 1;
		star.homing = 0.1F;
		star.life = 50;
		star.knockback = 1.2F;
		star.onImpact = s -> {
			ServerLevel level = level(p);
			puff(level, s.position(), Element.MAGNET, 1.5F);
			for (int i = 0; i < 4; i++) {
				double a = i * Math.PI / 2 + Math.PI / 4;
				JutsuProjectile blade = spawn(p, Element.MAGNET, Shape.SHURIKEN, 0.8F, s.position().add(0, 0.4, 0),
						new Vec3(Math.cos(a) * 0.9, 0.25, Math.sin(a) * 0.9), 7);
				blade.homing = 0.35F;
				blade.life = 30;
			}
			sound(level, s.position(), SoundEvents.CHAIN_BREAK, 1.5F, 0.6F);
		};
		channel(p, 50, 2, t -> {
			if (star.isAlive())
				level(p).sendParticles(Element.MAGNET.trail, star.getX(), star.getY() + 1.2, star.getZ(), 4, 1, 0.2, 1, 0.02);
		});
		sound(level(p), p.getEyePosition(), SoundEvents.CHAIN_PLACE, 1.5F, 0.5F);
	}

	// ------------------------------------------------------------------ hozuki
	/** A quick stream of water bullets flicked from the fingertip. */
	private static void waterPistol(ServerPlayer p) {
		channel(p, 10, 2, t -> {
			JutsuProjectile bullet = shoot(p, Element.WATER, Shape.ORB, 0.3F,
					turned(p, (p.getRandom().nextFloat() - 0.5F) * 4, (p.getRandom().nextFloat() - 0.5F) * 4).scale(2.2), 3);
			bullet.life = 25;
			bullet.knockback = 0.3F;
			sound(level(p), p.getEyePosition(), SoundEvents.PLAYER_SPLASH_HIGH_SPEED, 0.5F, 1.8F);
		});
	}

	/** A blob of water that swallows whoever it hits: trapped in a floating sphere, they slowly drown. */
	private static void drowningBlob(ServerPlayer p) {
		JutsuProjectile blob = shoot(p, Element.WATER, Shape.ORB, 0.8F, 1.0F, 3);
		blob.homing = 0.12F;
		blob.life = 40;
		blob.knockback = 0;
		blob.onHit = (b, target) -> {
			ServerLevel level = level(p);
			float size = Math.max(target.getBbWidth(), target.getBbHeight()) + 1.2F;
			shell(p, target, target.getBoundingBox().getCenter(), Element.WATER, size, 80);
			channel(p, 80, 2, t -> {
				if (!target.isAlive())
					return;
				target.addEffect(new MobEffectInstance(MobEffects.SLOWNESS, 10, 3, false, false));
				target.addEffect(new MobEffectInstance(MobEffects.MINING_FATIGUE, 10, 2, false, false));
				target.setAirSupply(Math.max(-20, target.getAirSupply() - 8));
				level.sendParticles(ParticleTypes.BUBBLE, target.getX(), target.getEyeY(), target.getZ(), 3, 0.3, 0.3, 0.3, 0.05);
				if (t % 20 == 0)
					damage(p, target, 2, Element.WATER);
			});
			sound(level, target.position(), SoundEvents.PLAYER_SPLASH, 1.2F, 0.6F);
		};
		sound(level(p), p.getEyePosition(), SoundEvents.PLAYER_SPLASH_HIGH_SPEED, 1, 1);
	}

	/** The arm swells with water into a giant fist that punches forward, still joined to the arm. */
	private static void waterArm(ServerPlayer p) {
		ServerLevel level = level(p);
		JutsuProjectile fist = shoot(p, Element.WATER, Shape.ORB, 1.9F, 1.3F, 16);
		fist.life = 12;
		fist.pierce = 3;
		fist.knockback = 3;
		fist.onImpact = f -> burst(level, f.position().add(0, 0.9, 0), 2.5F, 6, 1, Element.WATER, f);
		channel(p, 13, 1, t -> {
			if (!fist.isAlive())
				return;
			Vec3 shoulder = p.getEyePosition().subtract(0, 0.5, 0).add(turned(p, 90, 0).scale(0.35));
			line(level, Element.WATER.puff, shoulder, fist.getBoundingBox().getCenter(), 0.3);
		});
		sound(level, p.getEyePosition(), SoundEvents.PLAYER_SPLASH_HIGH_SPEED, 1.5F, 0.6F);
	}

	// ------------------------------------------------------------------ hyuga
	/** A palm strike that closes the chakra points: weakens, and drains an enemy ninja's chakra. */
	private static void gentleFist(ServerPlayer p) {
		ServerLevel level = level(p);
		Vec3 look = p.getLookAngle();
		p.setDeltaMovement(look.x * 0.5, 0.05, look.z * 0.5);
		p.syncVelocity = true;
		for (LivingEntity target : cone(p, 3.8, 40)) {
			damage(p, target, 7, Element.CHAKRA);
			if (target instanceof ServerPlayer victim)
				set(victim, v -> v.ChakraAmount = Math.max(0, v.ChakraAmount - 60));
			puff(level, target.getBoundingBox().getCenter(), Element.CHAKRA, 0.6F);
		}
		Vec3 palm = p.getEyePosition().add(look.scale(1.5)).subtract(0, 0.3, 0);
		level.sendParticles(ParticleTypes.END_ROD, palm.x, palm.y, palm.z, 10, 0.15, 0.15, 0.15, 0.08);
		sound(level, p.position(), SoundEvents.PLAYER_ATTACK_STRONG, 1, 1.3F);
	}

	/** Two roaring chakra lions leap from the palms at the enemy. */
	private static void twinLions(ServerPlayer p) {
		for (int side = -1; side <= 1; side += 2) {
			JutsuProjectile lion = shoot(p, Element.CHAKRA, Shape.LION, 1.1F, turned(p, side * 10, 0).scale(1.1), 9);
			lion.homing = 0.15F;
			lion.life = 40;
			lion.knockback = 1;
			lion.onImpact = l -> puff(level(p), l.position(), Element.CHAKRA, 1);
		}
		sound(level(p), p.getEyePosition(), SoundEvents.RAVAGER_ROAR, 0.8F, 1.6F);
	}

	/** A rush through the enemies, ending in a crushing blast of the lions' chakra. */
	private static void crumblingAttack(ServerPlayer p) {
		ServerLevel level = level(p);
		Techniques.dash(p, 8, 8, Element.CHAKRA);
		after(level, 8, () -> {
			Vec3 at = p.position().add(0, 1, 0).add(p.getLookAngle().multiply(1, 0, 1).normalize().scale(1.5));
			burst(level, at, 3.5F, 16, 1.5F, Element.CHAKRA, p);
			sound(level, at, SoundEvents.RAVAGER_ROAR, 1, 1.4F);
		});
	}

	/** Rotation: a spinning dome of chakra that throws back everything around and turns aside projectiles. */
	private static void rotation(ServerPlayer p) {
		ServerLevel level = level(p);
		shell(p, p, p.getBoundingBox().getCenter(), Element.CHAKRA, 4.6F, 30);
		sound(level, p.position(), SoundEvents.BREEZE_WIND_CHARGE_BURST.value(), 1.5F, 0.8F);
		channel(p, 30, 1, t -> {
			keep(p, MobEffects.RESISTANCE, 4);
			p.setDeltaMovement(0, Math.min(0, p.getDeltaMovement().y), 0);
			p.syncVelocity = true;
			Vec3 c = p.getBoundingBox().getCenter();
			for (LivingEntity target : enemies(level, p, p.getBoundingBox().inflate(3.3), e -> e.distanceToSqr(c) < 3.6 * 3.6)) {
				Vec3 away = target.position().subtract(p.position()).multiply(1, 0, 1).normalize();
				target.push(away.x * 1.2, 0.35, away.z * 1.2);
				target.syncVelocity = true;
				if (t % 5 == 0)
					damage(p, target, 3, Element.CHAKRA);
			}
			for (Projectile shot : level.getEntitiesOfClass(Projectile.class, p.getBoundingBox().inflate(3.3), e -> e.getOwner() != p)) {
				puff(level, shot.position(), Element.CHAKRA, 0.5F);
				shot.discard();
			}
			for (int i = 0; i < 6; i++) {
				double a = t * 0.7 + i * Math.PI / 3;
				level.sendParticles(Element.CHAKRA.trail, c.x + Math.cos(a) * 2.4, c.y - 1 + level.getRandom().nextDouble() * 2.5, c.z + Math.sin(a) * 2.4,
						1, 0, 0, 0, 0);
			}
		});
	}

	private static final String[] PALMS = { "Two palms!", "Four palms!", "Eight palms!", "Sixteen palms!", "Thirty-two palms!", "Sixty-four palms!" };

	/** Sixty-four palms at the chakra points of everyone in reach, holding them in place, then a final blow that throws them. */
	private static void sixtyFourPalms(ServerPlayer p) {
		ServerLevel level = level(p);
		Vec3 feet = p.position();
		sound(level, feet, SoundEvents.BEACON_ACTIVATE, 1, 1.4F);
		channel(p, 32, 1, t -> {
			p.setDeltaMovement(0, Math.min(0, p.getDeltaMovement().y), 0);
			p.syncVelocity = true;
			if (t % 4 == 0)
				// the trigram circle on the ground
				for (int i = 0; i < 32; i++) {
					double a = i * Math.PI / 16;
					level.sendParticles(Element.CHAKRA.trail, feet.x + Math.cos(a) * 3, feet.y + 0.1, feet.z + Math.sin(a) * 3, 1, 0, 0, 0, 0);
				}
			if (Integer.bitCount(t + 1) == 1)
				tell(p, PALMS[Integer.numberOfTrailingZeros(t + 1)]);
			for (LivingEntity target : cone(p, 4, 45)) {
				target.setDeltaMovement(0, Math.min(0, target.getDeltaMovement().y), 0);
				damage(p, target, 0.7F, Element.CHAKRA);
				Vec3 c = target.getBoundingBox().getCenter();
				level.sendParticles(ParticleTypes.CRIT, c.x, c.y, c.z, 2, 0.3, 0.4, 0.3, 0.1);
				level.sendParticles(Element.CHAKRA.trail, c.x, c.y, c.z, 2, 0.3, 0.4, 0.3, 0);
				if (t == 31) {
					Vec3 away = target.position().subtract(p.position()).multiply(1, 0, 1).normalize();
					damage(p, target, 10, Element.CHAKRA);
					target.push(away.x * 2, 0.6, away.z * 2);
					target.syncVelocity = true;
				}
			}
			if (t % 2 == 0)
				sound(level, p.position(), SoundEvents.PLAYER_ATTACK_WEAK, 0.7F, 1.2F + t * 0.02F);
		});
	}

	// ------------------------------------------------------------------ inuzuka
	/** The caster's Akamaru within range, if any. */
	private static AkamaruEntity.@Nullable CustomEntity akamaruOf(ServerPlayer p, double range) {
		return level(p).getEntitiesOfClass(AkamaruEntity.CustomEntity.class, p.getBoundingBox().inflate(range), d -> d.isOwnedBy(p)).stream().findFirst()
				.orElse(null);
	}

	/** Akamaru to the caster's side: called over (and healed) if he is around, otherwise summoned. He stays, like a tamed wolf. */
	private static void akamaru(ServerPlayer p) {
		ServerLevel level = level(p);
		Vec3 at = p.position().add(p.getLookAngle().multiply(1, 0, 1).normalize().scale(2));
		AkamaruEntity.CustomEntity dog = akamaruOf(p, 96);
		if (dog != null) {
			dog.setOrderedToSit(false);
			dog.teleportTo(at.x, p.getY(), at.z);
			dog.heal(dog.getMaxHealth());
		} else {
			dog = new AkamaruEntity.CustomEntity(AkamaruEntity.entity, level);
			dog.snapTo(at.x, p.getY(), at.z, p.getYRot(), 0);
			dog.finalizeSpawn(level, level.getCurrentDifficultyAt(dog.blockPosition()), EntitySpawnReason.MOB_SUMMONED, null);
			dog.tame(p);
			level.addFreshEntity(dog);
		}
		level.sendParticles(ParticleTypes.POOF, at.x, at.y + 0.4, at.z, 20, 0.4, 0.4, 0.4, 0.05);
		sound(level, at, SoundEvents.WOLF_SHAKE, 1, 1);
	}

	/** Akamaru within range for a jutsu that needs him; if he isn't there, the cast costs nothing. */
	private static AkamaruEntity.@Nullable CustomEntity needAkamaru(ServerPlayer p, double range, JutsuRank rank, int index) {
		AkamaruEntity.CustomEntity dog = akamaruOf(p, range);
		if (dog == null)
			Jutsus.miss(p, "Akamaru has to be close");
		return dog;
	}

	/** The enemy each Inuzuka has marked with Dynamic Marking (while it still glows). */
	private static final Map<UUID, LivingEntity> MARKED = new HashMap<>();

	private static @Nullable LivingEntity marked(ServerPlayer p) {
		LivingEntity target = MARKED.get(p.getUUID());
		if (target == null || !target.isAlive() || target.level() != p.level() || !target.hasEffect(MobEffects.GLOWING) || target.distanceToSqr(p) > 32 * 32) {
			MARKED.remove(p.getUUID());
			return null;
		}
		return target;
	}

	/** Who the fangs go for: the marked enemy (the nose finds it anywhere near), else the one looked at. */
	private static @Nullable LivingEntity prey(ServerPlayer p, double range) {
		LivingEntity target = marked(p);
		return target != null ? target : target(p, range);
	}

	private static Vec3 towards(Entity from, @Nullable LivingEntity to, Vec3 otherwise) {
		if (to == null)
			return otherwise;
		Vec3 d = to.position().subtract(from.position()).multiply(1, 0, 1);
		return d.lengthSqr() < 1.0E-4 ? otherwise : d.normalize();
	}

	/** A spinning charge along a direction that tears through everything it meets (Passing Fang's drill). */
	private static void fang(ServerPlayer p, Vec3 dir, int ticks, float damage) {
		List<Entity> struck = new ArrayList<>();
		sound(level(p), p.position(), SoundEvents.TRIDENT_RIPTIDE_1.value(), 1, 1.2F);
		channel(p, ticks + 3, 1, t -> {
			ServerLevel level = level(p);
			p.fallDistance = 0;
			if (t < ticks) {
				p.setDeltaMovement(dir.x * 1.4, Math.max(p.getDeltaMovement().y, 0.05), dir.z * 1.4);
				p.syncVelocity = true;
			}
			level.sendParticles(ParticleTypes.SWEEP_ATTACK, p.getX(), p.getY() + 0.8, p.getZ(), 1, 0.4, 0.4, 0.4, 0);
			level.sendParticles(Element.BEAST.trail, p.getX(), p.getY() + 0.8, p.getZ(), 3, 0.4, 0.5, 0.4, 0.02);
			for (LivingEntity target : enemies(level, p, p.getBoundingBox().inflate(1.2), e -> !struck.contains(e) && !(e instanceof AkamaruEntity.CustomEntity))) {
				struck.add(target);
				damage(p, target, damage, Element.BEAST);
				target.push(dir.x * 1.1, 0.5, dir.z * 1.1);
				target.syncVelocity = true;
			}
		});
	}

	/** Beast Mimicry: down on all fours, fast and savage, for thirty seconds (Akamaru, if near, too). */
	private static void fourLegs(ServerPlayer p) {
		ServerLevel level = level(p);
		sound(level, p.position(), SoundEvents.WOLF_GROWL_BABY.value(), 1.2F, 0.55F);
		level.sendParticles(ParticleTypes.POOF, p.getX(), p.getY() + 0.8, p.getZ(), 20, 0.4, 0.5, 0.4, 0.04);
		AkamaruEntity.CustomEntity dog = akamaruOf(p, 16);
		mode(p, 600, 1, v -> {
		}, v -> {
		}, t -> {
			if (t % 10 == 0) {
				keep(p, MobEffects.SPEED, 2);
				keep(p, MobEffects.STRENGTH, 0);
				keep(p, MobEffects.JUMP_BOOST, 1);
				if (dog != null && dog.isAlive()) {
					keep(dog, MobEffects.SPEED, 1);
					keep(dog, MobEffects.STRENGTH, 1);
				}
			}
			if (t % 3 == 0 && p.getDeltaMovement().horizontalDistanceSqr() > 0.01)
				level.sendParticles(Element.BEAST.trail, p.getX(), p.getY() + 0.2, p.getZ(), 1, 0.3, 0.1, 0.3, 0.01);
		});
	}

	/** Akamaru marks an enemy with his scent: it glows for a minute, he goes for it, and the fangs find it. */
	private static void dynamicMarking(ServerPlayer p) {
		AkamaruEntity.CustomEntity dog = needAkamaru(p, 16, JutsuRank.D, 2);
		if (dog == null)
			return;
		LivingEntity target = target(p, 24);
		if (target == null) {
			Jutsus.miss(p, "Look at an enemy to mark");
			return;
		}
		ServerLevel level = level(p);
		target.addEffect(new MobEffectInstance(MobEffects.GLOWING, 1200, 0, false, false));
		MARKED.put(p.getUUID(), target);
		dog.setOrderedToSit(false);
		dog.setTarget(target);
		sound(level, dog.position(), SoundEvents.WOLF_AMBIENT_BABY.value(), 1.2F, 0.8F);
		level.sendParticles(Element.BEAST.puff, target.getX(), target.getY() + target.getBbHeight() * 0.6, target.getZ(), 16, 0.3, 0.4, 0.3, 0.02);
	}

	/** Spins into a grey drill and tears through everything in a line (at the marked enemy, if there is one). */
	private static void passingFang(ServerPlayer p) {
		flag(p, 14, v -> v.PassingFang = true, v -> v.PassingFang = false);
		fang(p, towards(p, marked(p), p.getLookAngle().multiply(1, 0, 1).normalize()), 11, 12);
	}

	/** Akamaru turns into his partner's double for thirty seconds and fights at full strength. */
	private static void manBeastClone(ServerPlayer p) {
		AkamaruEntity.CustomEntity dog = needAkamaru(p, 16, JutsuRank.C, 4);
		if (dog == null)
			return;
		ServerLevel level = level(p);
		dog.setForm(1);
		level.sendParticles(ParticleTypes.POOF, dog.getX(), dog.getY() + 0.8, dog.getZ(), 30, 0.4, 0.6, 0.4, 0.05);
		sound(level, dog.position(), SoundEvents.ILLUSIONER_MIRROR_MOVE, 1, 1);
		channel(p, 600, 10, t -> {
			if (dog.isAlive() && dog.form() == 1) {
				keep(dog, MobEffects.STRENGTH, 1);
				keep(dog, MobEffects.SPEED, 1);
			}
		});
		after(level, 600, () -> {
			if (dog.isAlive() && dog.form() == 1) {
				dog.setForm(0);
				level.sendParticles(ParticleTypes.POOF, dog.getX(), dog.getY() + 0.5, dog.getZ(), 30, 0.4, 0.5, 0.4, 0.05);
			}
		});
	}

	/** Partner and Akamaru both spin into fangs and hit the enemy again and again from both sides. */
	private static void fangOverFang(ServerPlayer p) {
		AkamaruEntity.CustomEntity dog = needAkamaru(p, 16, JutsuRank.B, 5);
		if (dog == null)
			return;
		ServerLevel level = level(p);
		int before = dog.form();
		dog.setForm(2);
		dog.setOrderedToSit(false);
		flag(p, 44, v -> v.PassingFang = true, v -> v.PassingFang = false);
		for (int i = 0; i < 3; i++)
			after(level, i * 14, () -> fang(p, towards(p, prey(p, 20), p.getLookAngle().multiply(1, 0, 1).normalize()), 9, 10));
		List<Entity> struck = new ArrayList<>();
		channel(p, 42, 1, t -> {
			if (!dog.isAlive())
				return;
			LivingEntity target = prey(p, 20);
			Vec3 dir = towards(dog, target, dog.getLookAngle().multiply(1, 0, 1).normalize());
			dog.setDeltaMovement(dir.x * 1.3, Math.max(dog.getDeltaMovement().y, 0.05), dir.z * 1.3);
			dog.fallDistance = 0;
			if (t % 14 == 0)
				struck.clear();
			level.sendParticles(Element.BEAST.trail, dog.getX(), dog.getY() + 0.4, dog.getZ(), 3, 0.3, 0.3, 0.3, 0.02);
			for (LivingEntity hit : enemies(level, p, dog.getBoundingBox().inflate(1), e -> e != dog && !struck.contains(e))) {
				struck.add(hit);
				damage(p, hit, 9, Element.BEAST);
				hit.push(dir.x, 0.4, dir.z);
				hit.syncVelocity = true;
			}
		});
		after(level, 44, () -> {
			if (dog.isAlive() && dog.form() == 2)
				dog.setForm(before == 1 ? 1 : 0);
		});
	}

	// ------------------------------------------------------------------ lee
	private static final Map<UUID, Integer> DRUNK = new HashMap<>();

	/** Twenty seconds of the Drunken Fist: staggering out of the way and lashing out at anything that comes close. */
	private static void drunkenFist(ServerPlayer p) {
		ServerLevel level = level(p);
		int generation = DRUNK.merge(p.getUUID(), 1, Integer::sum);
		sound(level, p.position(), SoundEvents.GENERIC_DRINK.value(), 1, 0.7F);
		channel(p, 400, 2, t -> {
			if (!Integer.valueOf(generation).equals(DRUNK.get(p.getUUID())))
				return;
			if (t % 10 == 0)
				keep(p, MobEffects.SPEED, 1);
			if (t % 8 != 0)
				return;
			List<LivingEntity> near = cone(p, 3.5, 75);
			if (near.isEmpty())
				return;
			// sway to one side, then swing
			Vec3 look = p.getLookAngle().multiply(1, 0, 1).normalize(), side = new Vec3(-look.z, 0, look.x).scale(p.getRandom().nextBoolean() ? 0.5 : -0.5);
			p.setDeltaMovement(side.x + look.x * 0.2, 0.15, side.z + look.z * 0.2);
			p.syncVelocity = true;
			p.swing(net.minecraft.world.InteractionHand.MAIN_HAND, net.minecraft.world.item.component.SwingAnimation.DEFAULT, true);
			for (LivingEntity target : near) {
				damage(p, target, 5, Element.BEAST);
				target.push(look.x * 0.6, 0.25, look.z * 0.6);
				target.syncVelocity = true;
				level.sendParticles(ParticleTypes.SWEEP_ATTACK, target.getX(), target.getY() + 1, target.getZ(), 1, 0, 0, 0, 0);
			}
			sound(level, p.position(), SoundEvents.PLAYER_ATTACK_STRONG, 1, 0.8F + p.getRandom().nextFloat() * 0.4F);
		});
	}

	private static final int[] GATE_SPEED = { 0, 0, 1, 1, 2, 2, 3, 4 }, GATE_STRENGTH = { 0, 0, 1, 1, 2, 3, 4, 6 };

	/**
	 * Opens the Eight Gates up to the given one: more speed and strength with each gate, a heavier toll on the body from the
	 * third, and from the fifth a technique on opening. After the Gate of Death the body is left spent.
	 */
	private static void gate(ServerPlayer p, int gate) {
		ServerLevel level = level(p);
		Element aura = gate == 8 ? Element.NIGHT : Element.GATE;
		int ticks = gate >= 6 && gate < 8 ? 300 : 400;
		puff(level, p.position().add(0, 1, 0), aura, 1 + gate * 0.3F);
		level.sendParticles(ParticleTypes.CLOUD, p.getX(), p.getY() + 0.5, p.getZ(), gate * 8, 0.6, 0.8, 0.6, 0.15);
		sound(level, p.position(), SoundEvents.WARDEN_HEARTBEAT, 2, 1.3F - gate * 0.08F);
		if (gate >= 5)
			// the chakra released cracks the ground
			burst(level, p.position(), 2 + gate * 0.3F, gate * 2, 1, aura, p);
		mode(p, ticks, 1, v -> {
			v.gateslee = gate;
			v.Gate8 = gate == 8;
		}, v -> {
			v.gateslee = 0;
			v.Gate8 = false;
			if (gate == 8 && p.isAlive()) {
				p.setHealth(Math.min(p.getHealth(), 2));
				p.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 1200, 2));
				p.addEffect(new MobEffectInstance(MobEffects.SLOWNESS, 1200, 1));
			}
		}, t -> {
			if (t % 10 == 0) {
				keep(p, MobEffects.SPEED, GATE_SPEED[gate - 1]);
				keep(p, MobEffects.STRENGTH, GATE_STRENGTH[gate - 1]);
				keep(p, MobEffects.RESISTANCE, gate >= 7 ? 2 : gate >= 4 ? 1 : -1);
				keep(p, MobEffects.REGENERATION, gate == 2 ? 1 : -1);
			}
			if (gate >= 3 && t % 40 == 20 && p.getHealth() > (gate - 2) * 0.5F + 1)
				p.setHealth(p.getHealth() - (gate - 2) * 0.5F);
			if (t % 2 == 0) {
				level.sendParticles(aura.trail, p.getX(), p.getY() + 1, p.getZ(), gate, 0.4, 0.8, 0.4, 0.02);
				if (gate >= 3)
					level.sendParticles(ParticleTypes.CLOUD, p.getX(), p.getY() + 1.2, p.getZ(), 1, 0.3, 0.5, 0.3, 0.02);
			}
		});
		switch (gate) {
			case 5 -> hiddenLotus(p);
			case 6 -> morningPeacock(p);
			case 7 -> daytimeTiger(p);
			case 8 -> nightGuy(p);
			default -> {
			}
		}
	}

	/** Kicks the enemy high into the air, follows, and drives them into the ground. */
	private static void hiddenLotus(ServerPlayer p) {
		ServerLevel level = level(p);
		LivingEntity target = target(p, 5);
		if (target == null)
			return;
		target.setDeltaMovement(0, 1.6, 0);
		target.syncVelocity = true;
		p.setDeltaMovement(0, 1.5, 0);
		p.syncVelocity = true;
		sound(level, target.position(), SoundEvents.PLAYER_ATTACK_KNOCKBACK, 1.5F, 0.6F);
		after(level, 14, () -> {
			if (target.isAlive()) {
				target.setDeltaMovement(0, -2.5, 0);
				target.syncVelocity = true;
			}
		});
		after(level, 20, () -> {
			burst(level, target.position(), 3, 18, 1, Element.GATE, p);
			puff(level, target.position(), Element.EARTH, 2.5F);
		});
	}

	/** A storm of punches so fast they catch fire, fanned out like a peacock's tail. */
	private static void morningPeacock(ServerPlayer p) {
		channel(p, 20, 1, t -> {
			for (int i = 0; i < 2; i++) {
				JutsuProjectile punch = shoot(p, Element.FIRE, Shape.ORB, 0.35F,
						turned(p, (p.getRandom().nextFloat() - 0.5F) * 40, (p.getRandom().nextFloat() - 0.5F) * 24).scale(1.6), 3);
				punch.life = 12;
				punch.knockback = 0.2F;
			}
			if (t % 3 == 0)
				sound(level(p), p.getEyePosition(), SoundEvents.PLAYER_ATTACK_STRONG, 0.8F, 1.4F);
		});
		sound(level(p), p.getEyePosition(), SoundEvents.BLAZE_SHOOT, 1.2F, 0.8F);
	}

	/** One punch that compresses the air into a charging tiger. */
	private static void daytimeTiger(ServerPlayer p) {
		ServerLevel level = level(p);
		sound(level, p.getEyePosition(), SoundEvents.WARDEN_SONIC_BOOM, 1.5F, 0.8F);
		after(level, 6, () -> {
			JutsuProjectile tiger = shoot(p, Element.GATE, Shape.LION, 3.2F, 0.95F, 26);
			tiger.pierce = -1;
			tiger.life = 40;
			tiger.knockback = 2.5F;
			tiger.onImpact = t -> burst(level, t.position().add(0, 1.6, 0), 5, 18, 2, Element.GATE, t);
		});
	}

	/** Night Guy: a kick that rides a blood-red dragon of steam through everything ahead. */
	private static void nightGuy(ServerPlayer p) {
		ServerLevel level = level(p);
		Vec3 look = p.getLookAngle().multiply(1, 0, 1).normalize();
		JutsuProjectile dragon = shoot(p, Element.NIGHT, Shape.DRAGON, 2.2F, new Vec3(look.x * 1.5, 0, look.z * 1.5), 40);
		dragon.pierce = -1;
		dragon.life = 22;
		dragon.knockback = 3;
		dragon.onImpact = d -> burst(level, d.position(), 4, 20, 2, Element.NIGHT, d);
		sound(level, p.position(), SoundEvents.WARDEN_SONIC_BOOM, 2, 0.5F);
		channel(p, 16, 1, t -> {
			keep(p, MobEffects.RESISTANCE, 4);
			p.setDeltaMovement(look.x * 1.5, Math.max(0.02, p.getDeltaMovement().y), look.z * 1.5);
			p.syncVelocity = true;
			p.fallDistance = 0;
		});
	}

	// ------------------------------------------------------------------ added from the wiki
	// aburame
	/** Insect Clone Technique: a double made of insects takes the caster's place while they vanish; when it breaks it swarms. */
	private static void insectClone(ServerPlayer p) {
		ServerLevel level = level(p);
		net.mcreator.narutoshippudenmod.entity.JutsuEntities.ShadowCloneEntity.CustomEntity clone = new net.mcreator.narutoshippudenmod.entity.JutsuEntities.ShadowCloneEntity.CustomEntity(
				net.mcreator.narutoshippudenmod.entity.JutsuEntities.ShadowCloneEntity.entity, level);
		clone.snapTo(p.getX(), p.getY(), p.getZ(), p.getYRot(), 0);
		clone.setYHeadRot(p.getYRot());
		clone.tame(p);
		clone.setCustomName(p.getDisplayName());
		clone.setCustomNameVisible(false);
		level.addFreshEntity(clone);
		p.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 80, 0, false, false, true));
		p.addEffect(new MobEffectInstance(MobEffects.SPEED, 80, 1, false, false, true));
		level.sendParticles(Element.INSECT.puff, p.getX(), p.getY() + 1, p.getZ(), 40, 0.4, 0.8, 0.4, 0.05);
		sound(level, p.position(), SoundEvents.BEEHIVE_WORK, 1.5F, 1.3F);
		Vec3[] last = { clone.position() };
		boolean[] burst = { false };
		channel(p, 400, 2, t -> {
			if (burst[0])
				return;
			if (clone.isAlive() && t < 398) {
				last[0] = clone.position();
				if (t % 6 == 0)
					level.sendParticles(Element.INSECT.trail, clone.getX(), clone.getY() + 1, clone.getZ(), 3, 0.3, 0.6, 0.3, 0.02);
				return;
			}
			burst[0] = true;
			clone.discard();
			swarm(p, last[0], 3, 80);
		});
	}

	/** Secret Technique: Insect Sphere: a great sphere of insects closes round the caster and everything near, eating at their chakra. */
	private static void insectSphere(ServerPlayer p) {
		ServerLevel level = level(p);
		Vec3 c = p.getBoundingBox().getCenter();
		shell(p, null, c, Element.INSECT, 10, 100);
		sound(level, c, SoundEvents.BEEHIVE_WORK, 2, 0.6F);
		channel(p, 100, 2, t -> {
			for (int i = 0; i < 30; i++) {
				double a = level.getRandom().nextDouble() * Math.PI * 2, b = level.getRandom().nextDouble() * Math.PI - Math.PI / 2;
				level.sendParticles(Element.INSECT.trail, c.x + Math.cos(a) * Math.cos(b) * 5, c.y + Math.sin(b) * 5, c.z + Math.sin(a) * Math.cos(b) * 5, 1, 0, 0, 0, 0);
			}
			for (LivingEntity target : enemies(level, p, new AABB(c, c).inflate(5), e -> e.distanceToSqr(c) < 25)) {
				hold(target);
				if (t % 10 == 0) {
					damage(p, target, 2.5F, Element.INSECT);
					if (target instanceof ServerPlayer victim)
						set(victim, v -> v.ChakraAmount = Math.max(0, v.ChakraAmount - 25));
				}
			}
		});
	}

	// akimichi
	/** Partial Multi-Size Technique: one arm swells to giant size and swats everything in front away. */
	private static void partialMultiSize(ServerPlayer p) {
		JutsuProjectile fist = shoot(p, Element.BEAST, Shape.ORB, 2.2F, 1.3F, 10);
		fist.life = 9;
		fist.pierce = 3;
		fist.knockback = 2.5F;
		fist.onImpact = f -> puff(level(p), f.position(), Element.BEAST, 1.2F);
		sound(level(p), p.position(), SoundEvents.RAVAGER_ATTACK, 1.2F, 0.8F);
	}

	/** Super Open Hand Slap: a giant open hand slaps down everything in front of the caster. */
	private static void openHandSlap(ServerPlayer p) {
		ServerLevel level = level(p);
		Vec3 look = p.getLookAngle().multiply(1, 0, 1).normalize();
		after(level, 5, () -> {
			for (LivingEntity target : cone(p, 7, 55)) {
				damage(p, target, 15, Element.BEAST);
				target.push(look.x * 2.5, 0.5, look.z * 2.5);
				target.syncVelocity = true;
			}
			Vec3 at = p.position().add(look.scale(3.5));
			level.sendParticles(ParticleTypes.EXPLOSION, at.x, at.y + 1, at.z, 3, 1.5, 0.5, 1.5, 0);
			level.sendParticles(Element.EARTH.puff, at.x, at.y, at.z, 20, 2, 0.2, 2, 0.05);
			sound(level, at, SoundEvents.GENERIC_EXPLODE.value(), 1.2F, 0.7F);
		});
		sound(level, p.position(), SoundEvents.RAVAGER_ROAR, 1, 1.1F);
	}

	/** Butterfly Bullet Bombing: in Butterfly Mode, the caster leaps and drives a fist of chakra into the ground below. */
	private static void butterflyBombing(ServerPlayer p) {
		if (!NarutoShippudenModVariables.get(p).ButterflyMode) {
			Jutsus.miss(p, "Needs Butterfly Mode");
			return;
		}
		ServerLevel level = level(p);
		p.setDeltaMovement(p.getLookAngle().x * 0.5, 1.3, p.getLookAngle().z * 0.5);
		p.syncVelocity = true;
		sound(level, p.position(), SoundEvents.BEACON_POWER_SELECT, 1.5F, 0.6F);
		after(level, 12, () -> {
			p.setDeltaMovement(0, -2.2, 0);
			p.syncVelocity = true;
		});
		boolean[] done = { false };
		channel(p, 50, 1, t -> {
			p.fallDistance = 0;
			if (done[0] || t < 13 || !p.onGround())
				return;
			done[0] = true;
			burst(level, p.position(), 6.5F, 30, 2.5F, Element.BEAST, p);
			level.sendParticles(wingDust(p, 2), p.getX(), p.getY() + 0.5, p.getZ(), 120, 3, 0.5, 3, 0.2);
			level.sendParticles(ParticleTypes.EXPLOSION_EMITTER, p.getX(), p.getY(), p.getZ(), 1, 0, 0, 0, 0);
			sound(level, p.position(), SoundEvents.GENERIC_EXPLODE.value(), 2.5F, 0.6F);
		});
	}

	// hozuki
	/** Water Gun: Two Guns: water bullets fired from both hands in turn. */
	private static void twoGuns(ServerPlayer p) {
		channel(p, 18, 3, t -> {
			Vec3 side = turned(p, 90, 0).scale((t / 3) % 2 == 0 ? 0.4 : -0.4);
			JutsuProjectile bullet = shoot(p, Element.WATER, Shape.ORB, 0.35F, 2.4F, 5);
			bullet.setPos(bullet.position().add(side));
			bullet.onImpact = b -> puff(level(p), b.position(), Element.WATER, 0.5F);
			sound(level(p), p.getEyePosition(), SoundEvents.PLAYER_SPLASH_HIGH_SPEED, 0.6F, 1.7F);
		});
	}

	/** Until when each Hozuki's body is liquid (Hydrification). */
	private static final Map<UUID, Long> LIQUID = new HashMap<>();

	/** Hydrification Technique: for ten seconds the body turns to water: blows and weapons pass through it, jutsu do half. */
	private static void hydrification(ServerPlayer p) {
		LIQUID.put(p.getUUID(), level(p).getGameTime() + 200);
		sound(level(p), p.position(), SoundEvents.PLAYER_SPLASH, 1.5F, 1.2F);
		channel(p, 200, 3, t -> level(p).sendParticles(ParticleTypes.DRIPPING_WATER, p.getX(), p.getY() + 1, p.getZ(), 4, 0.35, 0.7, 0.35, 0));
	}

	@SubscribeEvent
	public static void liquidBody(net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent event) {
		if (!(event.getEntity() instanceof ServerPlayer p) || LIQUID.getOrDefault(p.getUUID(), 0L) <= p.level().getGameTime())
			return;
		if (event.getSource().is(Techniques.JUTSU))
			event.setAmount(event.getAmount() * 0.5F);
		else if (!event.getSource().is(net.minecraft.tags.DamageTypeTags.BYPASSES_INVULNERABILITY)) {
			event.setCanceled(true);
			level(p).sendParticles(ParticleTypes.SPLASH, p.getX(), p.getY() + 1, p.getZ(), 20, 0.3, 0.5, 0.3, 0.1);
		}
	}

	/** Water Release: Tate Eboshi: a towering wave rises where the caster looks and comes crashing down. */
	private static void tateEboshi(ServerPlayer p) {
		ServerLevel level = level(p);
		Vec3 at = lookPoint(p, 18);
		channel(p, 14, 1, t -> level.sendParticles(ParticleTypes.SPLASH, at.x, at.y + t * 0.5, at.z, 30, 2.5, 0.3, 2.5, 0.1));
		sound(level, at, SoundEvents.PLAYER_SPLASH_HIGH_SPEED, 2, 0.4F);
		after(level, 14, () -> {
			burst(level, at, 5, 16, 1.6F, Element.WATER, p);
			level.sendParticles(ParticleTypes.FALLING_WATER, at.x, at.y + 4, at.z, 200, 3, 2, 3, 0);
			for (LivingEntity target : enemies(level, p, new AABB(at, at).inflate(5), e -> e.distanceToSqr(at) < 25))
				target.addEffect(new MobEffectInstance(MobEffects.SLOWNESS, 60, 2, false, false));
			sound(level, at, SoundEvents.PLAYER_SPLASH, 2.5F, 0.4F);
		});
	}

	// hyuga
	/** Gentle Fist Art One Blow Body: the caster hurls their whole body forward behind a palm full of chakra. */
	private static void oneBlowBody(ServerPlayer p) {
		ServerLevel level = level(p);
		Vec3 look = p.getLookAngle().multiply(1, 0, 1).normalize();
		boolean[] done = { false };
		sound(level, p.position(), SoundEvents.BREEZE_SHOOT, 1.2F, 0.6F);
		channel(p, 10, 1, t -> {
			if (done[0])
				return;
			p.setDeltaMovement(look.x * 1.7, Math.min(p.getDeltaMovement().y, 0.05), look.z * 1.7);
			p.syncVelocity = true;
			level.sendParticles(Element.CHAKRA.trail, p.getX(), p.getY() + 1, p.getZ(), 6, 0.3, 0.5, 0.3, 0.02);
			LivingEntity hit = enemies(level, p, p.getBoundingBox().inflate(0.8).move(look.scale(0.8)), e -> true).stream().findFirst().orElse(null);
			if (hit == null)
				return;
			done[0] = true;
			damage(p, hit, 16, Element.CHAKRA);
			hit.push(look.x * 3.2, 0.6, look.z * 3.2);
			hit.syncVelocity = true;
			puff(level, hit.getBoundingBox().getCenter(), Element.CHAKRA, 1.2F);
			sound(level, hit.position(), SoundEvents.PLAYER_ATTACK_KNOCKBACK, 1.5F, 0.6F);
			p.setDeltaMovement(Vec3.ZERO);
			p.syncVelocity = true;
		});
	}

	// inuzuka
	/** Fang Rotating Fang: partner and Akamaru roll into buzz-saws and circle the enemy, tearing at it from every side. */
	private static void fangRotatingFang(ServerPlayer p) {
		AkamaruEntity.CustomEntity dog = needAkamaru(p, 16, JutsuRank.A, 6);
		if (dog == null)
			return;
		LivingEntity target = prey(p, 20);
		if (target == null) {
			Jutsus.miss(p, "Look at an enemy");
			return;
		}
		ServerLevel level = level(p);
		int before = dog.form();
		dog.setForm(2);
		dog.setOrderedToSit(false);
		flag(p, 64, v -> v.PassingFang = true, v -> v.PassingFang = false);
		sound(level, p.position(), SoundEvents.TRIDENT_RIPTIDE_2.value(), 1, 1);
		channel(p, 60, 1, t -> {
			if (!target.isAlive())
				return;
			Vec3 c = target.position();
			for (int k = 0; k < 2; k++) {
				Entity spinner = k == 0 ? p : dog;
				if (!spinner.isAlive())
					continue;
				double a = t * 0.35 + k * Math.PI, r = 2.2 + target.getBbWidth() / 2;
				Vec3 want = c.add(Math.cos(a) * r, 0, Math.sin(a) * r);
				Vec3 v = want.subtract(spinner.position());
				spinner.setDeltaMovement(v.x * 0.6, Math.max(spinner.getDeltaMovement().y, 0.02), v.z * 0.6);
				if (spinner instanceof ServerPlayer sp)
					sp.syncVelocity = true;
				spinner.fallDistance = 0;
				level.sendParticles(Element.BEAST.trail, spinner.getX(), spinner.getY() + 0.6, spinner.getZ(), 3, 0.3, 0.3, 0.3, 0.02);
			}
			if (t % 4 == 0) {
				damage(p, target, 3.5F, Element.BEAST);
				level.sendParticles(ParticleTypes.SWEEP_ATTACK, c.x, c.y + 1, c.z, 1, 0.4, 0.4, 0.4, 0);
			}
		});
		after(level, 62, () -> {
			if (dog.isAlive() && dog.form() == 2)
				dog.setForm(before == 1 ? 1 : 0);
		});
	}

	// uzumaki
	/** Until when each player's chakra is sealed (Four Symbols Seal): they can't cast jutsu. */
	private static final Map<UUID, Long> SEALED = new HashMap<>();

	/** Whether a player's chakra is sealed away and they can't use jutsu. */
	public static boolean sealed(ServerPlayer p) {
		return SEALED.getOrDefault(p.getUUID(), 0L) > p.level().getGameTime();
	}

	/** Four Symbols Seal: a seal pressed on the enemy looked at locks their chakra away for twenty seconds. */
	private static void fourSymbolsSeal(ServerPlayer p) {
		ServerLevel level = level(p);
		LivingEntity target = target(p, 6);
		if (target == null) {
			Jutsus.miss(p, "Get close to an enemy to seal");
			return;
		}
		damage(p, target, 6, Element.SEAL);
		if (target instanceof ServerPlayer victim) {
			SEALED.put(victim.getUUID(), level.getGameTime() + 400);
			stop(victim);
			tell(victim, "Your chakra has been sealed");
		} else {
			target.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 400, 2));
			target.addEffect(new MobEffectInstance(MobEffects.SLOWNESS, 400, 1));
		}
		channel(p, 60, 2, t -> {
			if (!target.isAlive())
				return;
			for (int i = 0; i < 4; i++) {
				double a = t * 0.3 + i * Math.PI / 2;
				level.sendParticles(Element.SEAL.trail, target.getX() + Math.cos(a) * 0.7, target.getY() + target.getBbHeight() * 0.55, target.getZ() + Math.sin(a) * 0.7, 1,
						0, 0, 0, 0);
			}
		});
		sound(level, target.position(), SoundEvents.CHAIN_PLACE, 1.5F, 1.4F);
	}

	/** Uzumaki Sealing Technique: seal script wraps the enemy looked at; a weakened enemy is sealed away completely. */
	private static void uzumakiSealing(ServerPlayer p) {
		ServerLevel level = level(p);
		LivingEntity target = target(p, 10);
		if (target == null) {
			Jutsus.miss(p, "Look at an enemy to seal");
			return;
		}
		sound(level, target.position(), SoundEvents.CHAIN_PLACE, 1.5F, 0.6F);
		channel(p, 30, 1, t -> {
			if (!target.isAlive())
				return;
			hold(target);
			double h = target.getBbHeight() * t / 30.0;
			for (int i = 0; i < 6; i++) {
				double a = t * 0.5 + i * Math.PI / 3;
				level.sendParticles(Element.SEAL.trail, target.getX() + Math.cos(a) * 0.8, target.getY() + h, target.getZ() + Math.sin(a) * 0.8, 1, 0, 0, 0, 0);
			}
		});
		after(level, 30, () -> {
			if (!target.isAlive())
				return;
			puff(level, target.getBoundingBox().getCenter(), Element.SEAL, 1.5F);
			sound(level, target.position(), SoundEvents.ENDER_EYE_DEATH, 1.5F, 0.6F);
			boolean weak = target.getHealth() <= target.getMaxHealth() * 0.3F && !(target instanceof Player) && target.getMaxHealth() <= 300;
			damage(p, target, weak ? 10000 : 20, Element.SEAL);
		});
	}

	// tsuchigumo
	/** Until when each Tsuchigumo's Fury is fed by natural energy (Creation of Heaven and Earth). */
	private static final Map<UUID, Long> CREATION = new HashMap<>();

	/**
	 * Creation of Heaven and Earth: the seal on Fury is released and natural energy gathers from the earth and air: for a minute the
	 * next Fury is far larger.
	 */
	private static void creation(ServerPlayer p) {
		ServerLevel level = level(p);
		sound(level, p.position(), SoundEvents.BEACON_ACTIVATE, 1.5F, 0.5F);
		channel(p, 40, 1, t -> {
			hold(p);
			double r = 6 * (1 - t / 40.0);
			for (int i = 0; i < 8; i++) {
				double a = i * Math.PI / 4 + t * 0.2;
				level.sendParticles(Element.EARTH.trail, p.getX() + Math.cos(a) * r, p.getY() + 0.2 + t * 0.03, p.getZ() + Math.sin(a) * r, 1, 0, 0, 0, 0);
				level.sendParticles(ParticleTypes.END_ROD, p.getX() + Math.cos(-a) * r, p.getY() + 3 - t * 0.05, p.getZ() + Math.sin(-a) * r, 1, 0, 0, 0, 0);
			}
		});
		after(level, 40, () -> {
			CREATION.put(p.getUUID(), level.getGameTime() + 1200);
			set(p, v -> v.ChakraAmount = Math.min(v.ChakraMax, v.ChakraAmount + v.ChakraMax * 0.3));
			tell(p, "Natural energy gathers: your next Fury is far stronger");
			sound(level, p.position(), SoundEvents.BEACON_POWER_SELECT, 1.5F, 0.7F);
		});
	}

	// ------------------------------------------------------------------ uchiha
	/** Manipulating Windmill Triple Blades: three windmill shuriken on wires curve round the enemy and bind them. */
	private static void windmillBlades(ServerPlayer p) {
		ServerLevel level = level(p);
		for (int i = -1; i <= 1; i++) {
			JutsuProjectile blade = shoot(p, Element.STEEL, Shape.SHURIKEN, 0.9F, turned(p, i * 25, -5).scale(1.4), 5);
			blade.homing = 0.25F;
			blade.life = 30;
			blade.knockback = 0;
			channel(p, 30, 2, t -> {
				if (blade.isAlive())
					line(level, ParticleTypes.CRIT, p.getEyePosition().subtract(0, 0.3, 0), blade.getBoundingBox().getCenter(), 0.7);
			});
			blade.onHit = (b, target) -> channel(p, 50, 2, t -> {
				if (!target.isAlive())
					return;
				hold(target);
				line(level, ParticleTypes.CRIT, p.getEyePosition().subtract(0, 0.3, 0), target.getBoundingBox().getCenter(), 0.6);
			});
		}
		sound(level, p.getEyePosition(), SoundEvents.PLAYER_ATTACK_SWEEP, 1.2F, 1.3F);
	}

	/** Uchiha Return: the war fan sweeps before the caster for a second and a half and sends every projectile back to its thrower. */
	private static void uchihaReturn(ServerPlayer p) {
		ServerLevel level = level(p);
		sound(level, p.position(), SoundEvents.BREEZE_WIND_CHARGE_BURST.value(), 1.2F, 1.2F);
		for (LivingEntity target : enemies(level, p, p.getBoundingBox().inflate(2.5), e -> true)) {
			Vec3 away = target.position().subtract(p.position()).multiply(1, 0, 1).normalize();
			target.push(away.x * 1.5, 0.4, away.z * 1.5);
			target.syncVelocity = true;
		}
		channel(p, 30, 1, t -> {
			Vec3 look = p.getLookAngle();
			for (int i = -3; i <= 3; i++) {
				Vec3 at = p.getEyePosition().add(turned(p, i * 20, 0).scale(1.6));
				level.sendParticles(ParticleTypes.CLOUD, at.x, at.y - 0.2, at.z, 1, 0.1, 0.2, 0.1, 0);
			}
			for (Projectile shot : level.getEntitiesOfClass(Projectile.class, p.getBoundingBox().inflate(3.5), e -> e.getOwner() != p)) {
				Entity thrower = shot.getOwner();
				Vec3 back = thrower != null ? thrower.getBoundingBox().getCenter().subtract(shot.position()).normalize() : look;
				shot.setDeltaMovement(back.scale(Math.max(1.2, shot.getDeltaMovement().length())));
				shot.setOwner(p);
				if (shot instanceof JutsuProjectile jutsu)
					jutsu.homing = 0.3F;
				level.sendParticles(ParticleTypes.GUST, shot.getX(), shot.getY(), shot.getZ(), 1, 0, 0, 0, 0);
				sound(level, shot.position(), SoundEvents.SHIELD_BLOCK.value(), 1, 1.2F);
			}
		});
	}

	/** Uchiha Flame Formation: a ring of fire rises round the caster for ten seconds that burns up projectiles and drives enemies back. */
	private static void flameFormation(ServerPlayer p) {
		ServerLevel level = level(p);
		Vec3 c = p.position();
		sound(level, c, SoundEvents.BLAZE_SHOOT, 2, 0.5F);
		channel(p, 200, 1, t -> {
			for (int i = 0; i < 24; i++) {
				double a = i * Math.PI / 12 + t * 0.05;
				level.sendParticles(ParticleTypes.FLAME, c.x + Math.cos(a) * 4, c.y + level.getRandom().nextDouble() * 3, c.z + Math.sin(a) * 4, 1, 0, 0.1, 0, 0.02);
			}
			for (Projectile shot : level.getEntitiesOfClass(Projectile.class, new AABB(c, c).inflate(5, 4, 5),
					e -> e.getOwner() != p && Math.abs(e.position().subtract(c).horizontalDistance() - 4) < 1)) {
				puff(level, shot.position(), Element.FIRE, 0.5F);
				shot.discard();
			}
			for (LivingEntity target : enemies(level, p, new AABB(c, c).inflate(5, 4, 5), e -> Math.abs(e.position().subtract(c).horizontalDistance() - 4) < 1)) {
				Vec3 out = target.position().subtract(c).multiply(1, 0, 1).normalize();
				target.push(out.x * 0.8, 0.2, out.z * 0.8);
				target.syncVelocity = true;
				if (t % 10 == 0)
					damage(p, target, 4, Element.FIRE);
			}
			if (t % 20 == 0)
				sound(level, c, SoundEvents.FIRE_AMBIENT, 1.5F, 0.8F);
		});
	}

	/** Great Fire Destruction: a vast sheet of fire spreads out in front of the caster, as wide as a battlefield. */
	private static void greatFireDestruction(ServerPlayer p) {
		ServerLevel level = level(p);
		sound(level, p.getEyePosition(), SoundEvents.BLAZE_SHOOT, 2, 0.4F);
		channel(p, 36, 2, t -> {
			for (int i = -5; i <= 5; i++) {
				JutsuProjectile sheet = shoot(p, Element.FIRE, Shape.ORB, 2.2F, turned(p, i * 12 + (level.getRandom().nextFloat() - 0.5F) * 8, 4 - t * 0.2F).scale(0.7), 7);
				sheet.pierce = -1;
				sheet.life = 26;
				sheet.knockback = 0.3F;
			}
			if (t % 8 == 0)
				sound(level, p.getEyePosition(), SoundEvents.FIRE_AMBIENT, 2, 0.5F);
		});
	}

	// ------------------------------------------------------------------ yamanaka
	/**
	 * The Yamanaka's mind goes into the targets: the caster's own body lies limp and helpless. A possessed creature turns on the
	 * caster's enemies (and on the others possessed); a possessed player stands frozen, their hands not their own. It ends after
	 * ticks, when the targets are gone, or at once if the caster's empty body is hurt.
	 */
	private static void possess(ServerPlayer p, List<LivingEntity> targets, int ticks) {
		ServerLevel level = level(p);
		float health = p.getHealth();
		boolean[] over = { false };
		sound(level, p.position(), Element.MIND.cast, 1.5F, 1.2F);
		for (LivingEntity e : targets)
			puff(level, e.getBoundingBox().getCenter(), Element.MIND, 0.8F);
		channel(p, ticks, 1, t -> {
			if (over[0])
				return;
			targets.removeIf(e -> !e.isAlive() || e.level() != p.level());
			if (targets.isEmpty() || p.getHealth() < health - 0.5F || t == ticks - 1) {
				over[0] = true;
				for (LivingEntity e : targets)
					e.addEffect(new MobEffectInstance(MobEffects.NAUSEA, 60, 0, false, false));
				tell(p, "Your mind returns to your body");
				sound(level, p.position(), Element.MIND.impact, 1, 1.4F);
				return;
			}
			hold(p);
			if (t % 3 == 0)
				level.sendParticles(Element.MIND.trail, p.getX(), p.getEyeY() + 0.3, p.getZ(), 1, 0.2, 0.1, 0.2, 0);
			for (LivingEntity e : targets) {
				if (t % 5 == 0) {
					line(level, Element.MIND.trail, p.getEyePosition(), e.getEyePosition(), 1.2);
					level.sendParticles(Element.MIND.puff, e.getX(), e.getEyeY() + 0.4, e.getZ(), 2, 0.2, 0.1, 0.2, 0.2);
				}
				if (e instanceof net.minecraft.world.entity.Mob mob) {
					LivingEntity prey = mob.getTarget();
					if (prey == null || !prey.isAlive() || prey == p || prey == mob || !Techniques.isEnemy(p, prey)) {
						prey = level.getEntitiesOfClass(LivingEntity.class, mob.getBoundingBox().inflate(16),
								x -> x != mob && x != p && x.isAlive() && Techniques.isEnemy(p, x) && !(x instanceof net.minecraft.world.entity.decoration.ArmorStand)).stream()
								.min((a, b) -> Double.compare(a.distanceToSqr(mob), b.distanceToSqr(mob))).orElse(null);
						mob.setTarget(prey);
					}
					if (t % 10 == 0)
						keep(mob, MobEffects.STRENGTH, 1);
				} else {
					hold(e);
					e.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 10, 9, false, false));
				}
			}
		});
	}

	/** Mind Body Transmission Technique: the caster's mind reaches out to everything alive nearby; for fifteen seconds all of it glows. */
	private static void mindTransmission(ServerPlayer p) {
		ServerLevel level = level(p);
		List<LivingEntity> found = level.getEntitiesOfClass(LivingEntity.class, p.getBoundingBox().inflate(40), e -> e != p && e.isAlive());
		for (LivingEntity e : found)
			e.addEffect(new MobEffectInstance(MobEffects.GLOWING, 300, 0, false, false));
		channel(p, 20, 1, t -> {
			double r = t * 2;
			for (int i = 0; i < 24; i++) {
				double a = i * Math.PI / 12;
				level.sendParticles(Element.MIND.trail, p.getX() + Math.cos(a) * r, p.getY() + 1, p.getZ() + Math.sin(a) * r, 1, 0, 0, 0, 0);
			}
		});
		sound(level, p.position(), Element.MIND.cast, 1.5F, 1.6F);
		tell(p, found.isEmpty() ? "You sense no one nearby" : "You sense " + found.size() + " minds nearby");
	}

	/** Mind Body Switch Technique: the caster's mind jumps into the enemy looked at and takes over their body for twelve seconds. */
	private static void mindSwitch(ServerPlayer p) {
		LivingEntity target = target(p, 16);
		if (target == null) {
			Jutsus.miss(p, "Look at an enemy to take over");
			return;
		}
		possess(p, new ArrayList<>(List.of(target)), target instanceof Player ? 100 : 240);
	}

	/** Mind Body Disturbance Technique: the enemy's nerves are thrown into confusion for six seconds: they stagger and lash out blindly. */
	private static void mindDisturbance(ServerPlayer p) {
		ServerLevel level = level(p);
		LivingEntity target = target(p, 16);
		if (target == null) {
			Jutsus.miss(p, "Look at an enemy");
			return;
		}
		sound(level, target.position(), Element.MIND.impact, 1.2F, 0.8F);
		channel(p, 120, 2, t -> {
			if (!target.isAlive())
				return;
			target.addEffect(new MobEffectInstance(MobEffects.NAUSEA, 60, 0, false, false));
			target.addEffect(new MobEffectInstance(MobEffects.SLOWNESS, 10, 1, false, false));
			if (t % 10 == 0) {
				Vec3 lurch = new Vec3(level.getRandom().nextGaussian(), 0, level.getRandom().nextGaussian()).normalize().scale(0.6);
				target.push(lurch.x, 0.1, lurch.z);
				target.syncVelocity = true;
				target.setYRot(level.getRandom().nextFloat() * 360);
				if (target instanceof net.minecraft.world.entity.Mob mob)
					mob.setTarget(level.getEntitiesOfClass(LivingEntity.class, mob.getBoundingBox().inflate(10), x -> x != mob && x != p && x.isAlive()).stream()
							.findAny().orElse(null));
				level.sendParticles(Element.MIND.puff, target.getX(), target.getEyeY() + 0.4, target.getZ(), 6, 0.3, 0.1, 0.3, 0.2);
			}
			if (t % 20 == 0)
				damage(p, target, 3, Element.MIND);
		});
	}

	/**
	 * Mind Body Transmission Formation: the caster links the minds of every ally nearby for thirty seconds: they move and strike as
	 * one (faster and stronger), and every enemy around is laid bare.
	 */
	private static void mindFormation(ServerPlayer p) {
		ServerLevel level = level(p);
		sound(level, p.position(), Element.MIND.cast, 2, 0.8F);
		channel(p, 600, 10, t -> {
			for (Player ally : level.getEntitiesOfClass(Player.class, p.getBoundingBox().inflate(32), x -> x == p || !Techniques.isEnemy(p, x) || x.isAlliedTo(p))) {
				ally.addEffect(new MobEffectInstance(MobEffects.SPEED, 25, 0, false, false, true));
				ally.addEffect(new MobEffectInstance(MobEffects.STRENGTH, 25, 0, false, false, true));
				if (t % 40 == 0)
					level.sendParticles(Element.MIND.trail, ally.getX(), ally.getEyeY() + 0.5, ally.getZ(), 3, 0.2, 0.1, 0.2, 0);
			}
			if (t % 40 == 0)
				for (LivingEntity enemy : enemies(level, p, p.getBoundingBox().inflate(32), e -> !(e instanceof Player)))
					enemy.addEffect(new MobEffectInstance(MobEffects.GLOWING, 45, 0, false, false));
		});
		tell(p, "Minds linked");
	}

	/** Mind Clone Switch Technique: the caster's mind splits into up to five enemies in front and takes them all over for ten seconds. */
	private static void mindCloneSwitch(ServerPlayer p) {
		List<LivingEntity> targets = new ArrayList<>(cone(p, 24, 50));
		targets.removeIf(e -> !p.hasLineOfSight(e));
		if (targets.isEmpty()) {
			Jutsus.miss(p, "No enemies in view");
			return;
		}
		targets.sort((a, b) -> Double.compare(a.distanceToSqr(p), b.distanceToSqr(p)));
		possess(p, new ArrayList<>(targets.subList(0, Math.min(5, targets.size()))), 200);
	}

	// ------------------------------------------------------------------ nara
	private static final BlockState SHADE = Blocks.CONCRETE.pick(net.minecraft.world.item.DyeColor.BLACK).defaultBlockState();

	/** Someone a Nara's shadow has caught: where they are held, how they are turned from the caster, and the shadow joining them. */
	private static final class Caught {
		Vec3 spot;
		final float yawOffset;
		final List<Display.BlockDisplay> link;
		final List<Display.BlockDisplay> pool = new ArrayList<>();
		Vec3 linkedFrom = Vec3.ZERO, linkedTo = Vec3.ZERO;

		Caught(LivingEntity e, ServerPlayer p, List<Display.BlockDisplay> link) {
			spot = e.position();
			yawOffset = Mth.wrapDegrees(e.getYRot() - p.getYRot());
			this.link = link;
		}
	}

	/** A Nara's shadow: who it holds, the shadows still creeping, and every piece drawn on the ground. */
	private static final class Hold {
		final Map<LivingEntity, Caught> held = new java.util.LinkedHashMap<>();
		final List<Display.BlockDisplay> drawn = new ArrayList<>();
		int creeping;
		boolean bound, ended;
	}

	/** Each Nara's current shadow (one at a time: a new shadow jutsu lets go of the last). */
	private static final Map<UUID, Hold> HOLDS = new HashMap<>();
	/** Until when (game time) each Nara's shadow is strengthened by Shadow Gathering. */
	private static final Map<UUID, Long> GATHERED = new HashMap<>();

	private static Hold newHold(ServerPlayer p) {
		letGo(p);
		Hold hold = new Hold();
		HOLDS.put(p.getUUID(), hold);
		return hold;
	}

	/** The shadow draws back and lets go. */
	private static void endHold(ServerPlayer p, Hold hold) {
		if (hold.ended)
			return;
		hold.ended = true;
		HOLDS.remove(p.getUUID(), hold);
		for (Display.BlockDisplay piece : hold.drawn)
			Displays.remove(piece, 6);
	}

	private static void letGo(ServerPlayer p) {
		Hold hold = HOLDS.get(p.getUUID());
		if (hold != null)
			endHold(p, hold);
	}

	/** Sneak + right-click: lets go of whoever the shadow holds (with nothing held, the jutsu is cast as usual). */
	private static void releaseShadow(ServerPlayer p) {
		Hold hold = HOLDS.get(p.getUUID());
		if (hold != null) {
			endHold(p, hold);
			tell(p, "Shadow released");
			return;
		}
		net.minecraft.world.InteractionHand hand = Jutsus.technique(p.getMainHandItem()) != null ? net.minecraft.world.InteractionHand.MAIN_HAND
				: net.minecraft.world.InteractionHand.OFF_HAND;
		p.setShiftKeyDown(false);
		try {
			Jutsus.cast(p, hand);
		} finally {
			p.setShiftKeyDown(true);
		}
	}

	/** How much further and faster the caster's shadow goes (doubled by Shadow Gathering). */
	private static double reach(ServerPlayer p) {
		return GATHERED.getOrDefault(p.getUUID(), 0L) > level(p).getGameTime() ? 2 : 1;
	}

	/** The top of the ground under a point (looking a little above and below it), or the point's own height over a drop. */
	static double ground(ServerLevel level, double x, double y, double z) {
		net.minecraft.core.BlockPos.MutableBlockPos pos = net.minecraft.core.BlockPos.containing(x, y + 1.5, z).mutable();
		for (int i = 0; i < 6; i++, pos.move(0, -1, 0)) {
			net.minecraft.world.phys.shapes.VoxelShape shape = level.getBlockState(pos).getCollisionShape(level, pos);
			if (!shape.isEmpty() && pos.getY() + shape.max(net.minecraft.core.Direction.Axis.Y) <= y + 1.6)
				return pos.getY() + shape.max(net.minecraft.core.Direction.Axis.Y);
		}
		return y;
	}

	/** A piece of shadow laid flat on the ground, turned by yaw. */
	private static Display.BlockDisplay lay(ServerLevel level, Hold hold, Vec3 at, float yaw, float width, float length, int life) {
		Display.BlockDisplay piece = Displays.grow(level, new Vec3(at.x, ground(level, at.x, at.y, at.z) + 0.015, at.z), SHADE,
				Displays.box(yaw, 0, width, 0.02F, length), 2, life, false);
		hold.drawn.add(piece);
		return piece;
	}

	/** A round pool of shadow under someone caught (it moves with them). */
	private static void pool(ServerLevel level, Hold hold, Caught caught, LivingEntity target, int life) {
		float size = target.getBbWidth() + 0.9F;
		for (int i = 0; i < 2; i++)
			caught.pool.add(lay(level, hold, target.position(), (float) (i * Math.PI / 4), size, size, life));
	}

	/** Lays the pieces of a shadow evenly along the ground from one point to another. */
	private static void relink(ServerLevel level, List<Display.BlockDisplay> link, Vec3 from, Vec3 to) {
		Vec3 d = new Vec3(to.x - from.x, 0, to.z - from.z);
		int n = link.size();
		if (n == 0 || d.lengthSqr() < 1.0E-4)
			return;
		float yaw = (float) Math.atan2(d.x, d.z), length = (float) (d.length() / n) + 0.2F;
		for (int i = 0; i < n; i++) {
			Vec3 at = from.add(d.scale((i + 0.5) / n));
			Display.BlockDisplay piece = link.get(i);
			piece.setPos(at.x, ground(level, at.x, Math.max(from.y, to.y), at.z) + 0.015, at.z);
			Displays.animate(piece, Displays.box(yaw, 0, 0.7F, 0.02F, length), 1);
		}
	}

	/**
	 * The caster's shadow stretches over the ground towards the target (following it as it runs) and catches it on reaching its
	 * feet. It gives up after range blocks, or if the target gets away or dies. The pieces live for life ticks unless let go.
	 */
	private static void creep(ServerPlayer p, Hold hold, LivingEntity target, double baseRange, double baseSpeed, int life, Consumer<Caught> onCatch) {
		ServerLevel level = level(p);
		double boost = reach(p), range = baseRange * boost, speed = baseSpeed * Math.sqrt(boost);
		Vec3[] tip = { p.position() };
		double[] run = { 0 };
		boolean[] done = { false };
		List<Display.BlockDisplay> link = new ArrayList<>();
		hold.creeping++;
		sound(level, p.position(), Element.SHADOW.cast, 1.2F, 0.7F);
		channel(p, (int) (range / speed) + 4, 1, t -> {
			if (hold.ended || done[0])
				return;
			Vec3 to = target.position().subtract(tip[0]), flat = new Vec3(to.x, 0, to.z);
			boolean lost = !target.isAlive() || target.level() != p.level() || run[0] >= range || t >= (int) (range / speed) + 3;
			if (!lost && flat.length() < 0.9 && Math.abs(to.y) < 2.5) {
				done[0] = true;
				hold.creeping--;
				Caught caught = new Caught(target, p, link);
				hold.held.put(target, caught);
				pool(level, hold, caught, target, life);
				sound(level, target.position(), Element.SHADOW.impact, 1.5F, 0.6F);
				onCatch.accept(caught);
				return;
			}
			if (lost) {
				done[0] = true;
				hold.creeping--;
				if (target.isAlive())
					tell(p, "The shadow can't reach that far");
				for (Display.BlockDisplay piece : link)
					Displays.remove(piece, 6);
				if (hold.held.isEmpty() && hold.creeping == 0)
					endHold(p, hold);
				return;
			}
			Vec3 step = flat.normalize().scale(Math.min(speed, flat.length())), from = tip[0];
			Vec3 next = from.add(step);
			tip[0] = new Vec3(next.x, ground(level, next.x, from.y, next.z), next.z);
			run[0] += step.length();
			Vec3 middle = from.add(tip[0]).scale(0.5);
			link.add(lay(level, hold, new Vec3(middle.x, Math.max(from.y, tip[0].y), middle.z), (float) Math.atan2(step.x, step.z), 0.7F,
					(float) step.length() + 0.2F, life));
			level.sendParticles(Element.SHADOW.trail, tip[0].x, tip[0].y + 0.1, tip[0].z, 3, 0.2, 0.02, 0.2, 0);
		});
	}

	/**
	 * Holds whoever the shadow has caught for ticks: they can't move by themselves, and (mimic) copy every step, turn, look and swing
	 * the caster makes, each in their own facing (step forward and they step forward; turn right and they turn right). The shadow
	 * joining them stays laid between their feet. each runs every tick. The hold ends early once everyone held is gone and nothing
	 * is still creeping.
	 */
	private static void bind(ServerPlayer p, Hold hold, int ticks, boolean mimic, IntConsumer each) {
		ServerLevel level = level(p);
		hold.bound = true;
		Vec3[] last = { p.position() };
		float[] lastLook = { p.getYRot(), p.getXRot() };
		boolean[] swinging = { p.isSwinging() };
		channel(p, ticks, 1, t -> {
			if (hold.ended)
				return;
			hold.held.keySet().removeIf(e -> !e.isAlive() || e.level() != p.level());
			if (hold.held.isEmpty() && hold.creeping == 0 || t == ticks - 1) {
				endHold(p, hold);
				return;
			}
			Vec3 step = p.position().subtract(last[0]);
			last[0] = p.position();
			float yaw = p.getYRot(), pitch = p.getXRot();
			boolean moved = mimic && step.lengthSqr() > 1.0E-6 && step.lengthSqr() < 4;
			boolean turned = mimic && (yaw != lastLook[0] || pitch != lastLook[1]);
			lastLook[0] = yaw;
			lastLook[1] = pitch;
			boolean swing = mimic && p.isSwinging() && !swinging[0];
			swinging[0] = p.isSwinging();
			for (Map.Entry<LivingEntity, Caught> entry : hold.held.entrySet()) {
				LivingEntity e = entry.getKey();
				Caught c = entry.getValue();
				hold(e);
				e.fallDistance = 0;
				if (e instanceof ServerPlayer victim)
					victim.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 10, 9, false, false));
				if (moved) {
					e.setPos(c.spot);
					e.move(net.minecraft.world.entity.MoverType.SELF, step.yRot((float) -Math.toRadians(c.yawOffset)));
					c.spot = e.position();
				}
				float faceYaw = yaw + c.yawOffset;
				if (e instanceof ServerPlayer victim) {
					if (moved || turned || victim.position().distanceToSqr(c.spot) > 0.04)
						victim.teleportTo(level, c.spot.x, c.spot.y, c.spot.z, java.util.Set.of(), mimic ? faceYaw : victim.getYRot(), mimic ? pitch : victim.getXRot(), false);
				} else {
					if (e.position().distanceToSqr(c.spot) > 0.04)
						e.teleportTo(c.spot.x, c.spot.y, c.spot.z);
					if (mimic) {
						e.setYRot(faceYaw);
						e.setXRot(pitch);
						e.setYHeadRot(faceYaw);
						e.setYBodyRot(faceYaw);
					}
				}
				if (swing)
					e.swing(net.minecraft.world.InteractionHand.MAIN_HAND, net.minecraft.world.item.component.SwingAnimation.DEFAULT, true);
				// the shadow stays joined to both of them
				if (!c.link.isEmpty() && (c.linkedFrom.distanceToSqr(p.position()) > 1.0E-4 || c.linkedTo.distanceToSqr(e.position()) > 1.0E-4)) {
					c.linkedFrom = p.position();
					c.linkedTo = e.position();
					relink(level, c.link, p.position(), e.position());
				}
				for (Display.BlockDisplay piece : c.pool)
					if (piece.position().distanceToSqr(e.position()) > 1.0E-4)
						piece.setPos(e.getX(), ground(level, e.getX(), e.getY(), e.getZ()) + 0.015, e.getZ());
			}
			if (t % 4 == 0)
				for (LivingEntity e : hold.held.keySet())
					level.sendParticles(Element.SHADOW.trail, e.getX(), e.getY() + 0.1, e.getZ(), 2, e.getBbWidth() * 0.4, 0.02, e.getBbWidth() * 0.4, 0);
			each.accept(t);
		});
	}

	/** A shuriken thrown along the caster's shadow: whoever it hits is pinned where they stand for three seconds. */
	private static void shadowShuriken(ServerPlayer p) {
		JutsuProjectile star = shoot(p, Element.SHADOW, Shape.SHURIKEN, 0.6F, 1.6F, 5);
		star.life = 30;
		star.knockback = 0;
		star.onHit = (s, target) -> {
			ServerLevel level = level(p);
			Hold hold = newHold(p);
			Caught caught = new Caught(target, p, List.of());
			hold.held.put(target, caught);
			pool(level, hold, caught, target, 70);
			bind(p, hold, 60, false, t -> {
			});
			sound(level, target.position(), Element.SHADOW.impact, 1.2F, 0.8F);
		};
		sound(level(p), p.getEyePosition(), SoundEvents.PLAYER_ATTACK_SWEEP, 1, 1.6F);
	}

	/** The shadow creeps to the enemy being looked at and catches it: for ten seconds it copies every move the caster makes. */
	private static void shadowImitation(ServerPlayer p) {
		LivingEntity target = target(p, 20 * reach(p));
		if (target == null) {
			Jutsus.miss(p, "Look at an enemy to catch");
			return;
		}
		Hold hold = newHold(p);
		creep(p, hold, target, 20, 0.9, 240, c -> {
			tell(p, "Shadow Imitation complete");
			bind(p, hold, 200, true, t -> {
			});
		});
	}

	/**
	 * The shadows of everything around are drawn into the caster's own: for thirty seconds it reaches twice as far and creeps faster.
	 */
	private static void shadowGathering(ServerPlayer p) {
		ServerLevel level = level(p);
		GATHERED.put(p.getUUID(), level.getGameTime() + 600);
		Vec3 c = p.position();
		sound(level, c, Element.SHADOW.cast, 1.5F, 0.5F);
		channel(p, 30, 1, t -> {
			double r = 8 * (1 - t / 30.0);
			for (int i = 0; i < 16; i++) {
				double a = i * Math.PI / 8 + t * 0.1;
				double x = p.getX() + Math.cos(a) * r, z = p.getZ() + Math.sin(a) * r;
				level.sendParticles(Element.SHADOW.trail, x, ground(level, x, p.getY(), z) + 0.1, z, 1, 0.1, 0, 0.1, 0);
			}
		});
		Hold hold = new Hold();
		for (int i = 0; i < 2; i++) {
			Display.BlockDisplay piece = lay(level, hold, c, (float) (i * Math.PI / 4), 3, 3, 40);
			after(level, 30, () -> Displays.remove(piece, 8));
		}
		tell(p, "The shadows gather: your shadow reaches twice as far");
	}

	/** Shadow Imitation, then hands of shadow climb the caught enemy's body and choke them for six seconds. */
	private static void neckBinding(ServerPlayer p) {
		LivingEntity target = target(p, 20 * reach(p));
		if (target == null) {
			Jutsus.miss(p, "Look at an enemy to catch");
			return;
		}
		Hold hold = newHold(p);
		creep(p, hold, target, 20, 0.9, 160, c -> {
			ServerLevel level = level(p);
			bind(p, hold, 120, true, t -> {
				if (!target.isAlive())
					return;
				// the hands climb up to the neck over the first second
				double reach = Math.min(1, t / 20.0) * target.getBbHeight() * 0.85;
				for (int i = 0; i < 3; i++) {
					double a = t * 0.4 + i * Math.PI * 2 / 3, r = target.getBbWidth() * 0.55;
					level.sendParticles(Element.SHADOW.trail, target.getX() + Math.cos(a) * r, target.getY() + reach * (0.4 + 0.2 * i), target.getZ() + Math.sin(a) * r,
							1, 0, 0, 0, 0);
				}
				if (t < 20)
					return;
				level.sendParticles(ParticleTypes.SQUID_INK, target.getX(), target.getY() + reach, target.getZ(), 2, target.getBbWidth() * 0.3, 0.1,
						target.getBbWidth() * 0.3, 0);
				target.setAirSupply(Math.max(-20, target.getAirSupply() - 10));
				if (t % 10 == 0) {
					damage(p, target, 3, Element.SHADOW);
					sound(level, target.position(), SoundEvents.PLAYER_HURT_DROWN, 0.8F, 0.7F);
				}
			});
		});
	}

	/** A spike of shadow rising out of the ground at from, through to, and on past it (grows out of the ground). */
	private static void tendril(ServerLevel level, Hold hold, Vec3 from, Vec3 through, int life) {
		Vec3 dir = through.subtract(from);
		float length = (float) dir.length() * 1.8F;
		dir = dir.normalize();
		float yaw = (float) Math.atan2(dir.x, dir.z), pitch = (float) Math.asin(dir.y);
		java.util.function.Function<Float, Matrix4f> shape = l -> new Matrix4f().rotateY(yaw).rotateX(-pitch).scale(0.13F, 0.13F, l).translate(-0.5F, -0.5F, 0);
		Display.BlockDisplay spike = Displays.grow(level, from, SHADE, shape.apply(0.05F), 1, life, false);
		hold.drawn.add(spike);
		after(level, 2, () -> Displays.animate(spike, shape.apply(length), 4));
	}

	/**
	 * Shadows creep out to up to five enemies nearby; where one reaches, spikes of shadow burst out of the ground all round it and run
	 * it through, pinning it for four seconds.
	 */
	private static void shadowSewing(ServerPlayer p) {
		ServerLevel level = level(p);
		double range = 16 * reach(p);
		List<LivingEntity> near = new ArrayList<>(enemies(level, p, p.getBoundingBox().inflate(range), e -> e.distanceToSqr(p) < range * range && p.hasLineOfSight(e)));
		if (near.isEmpty()) {
			Jutsus.miss(p, "No one within your shadow's reach");
			return;
		}
		near.sort((a, b) -> Double.compare(a.distanceToSqr(p), b.distanceToSqr(p)));
		Hold hold = newHold(p);
		for (LivingEntity target : near.subList(0, Math.min(5, near.size())))
			creep(p, hold, target, 16, 1.4, 150, c -> {
				Vec3 body = target.getBoundingBox().getCenter();
				double r = 1.8 + target.getBbWidth();
				float turn = level.getRandom().nextFloat() * 6.3F;
				for (int i = 0; i < 7; i++) {
					double a = turn + i * Math.PI * 2 / 7, rr = r * (0.8 + level.getRandom().nextDouble() * 0.5);
					double x = target.getX() + Math.cos(a) * rr, z = target.getZ() + Math.sin(a) * rr;
					Vec3 through = body.add((level.getRandom().nextDouble() - 0.5) * 0.4, (level.getRandom().nextDouble() - 0.3) * target.getBbHeight() * 0.4,
							(level.getRandom().nextDouble() - 0.5) * 0.4);
					tendril(level, hold, new Vec3(x, ground(level, x, target.getY(), z), z), through, 90);
				}
				damage(p, target, 10, Element.SHADOW);
				level.sendParticles(ParticleTypes.SQUID_INK, body.x, body.y, body.z, 12, 0.3, 0.4, 0.3, 0.05);
				sound(level, target.position(), SoundEvents.TRIDENT_HIT, 1.2F, 0.6F);
				if (!hold.bound)
					bind(p, hold, 100, false, t -> {
					});
			});
		sound(level, p.position(), SoundEvents.PLAYER_ATTACK_SWEEP, 1, 0.6F);
	}

	/**
	 * Shadow Imitation Field: the caster's shadow spreads into a great pool on the ground around them (it stays where it spread), and
	 * everyone it reaches is caught and copies the caster's moves for eight seconds.
	 */
	private static void imitationField(ServerPlayer p) {
		ServerLevel level = level(p);
		Hold hold = newHold(p);
		Vec3 c = p.position();
		double y = ground(level, c.x, c.y, c.z) + 0.015;
		int spread = 30, ticks = spread + 160;
		float radius = (float) (14 * Math.sqrt(reach(p))), row = 1.4F;
		// a round pool made of strips across it, growing out from the caster's feet
		for (float z = -radius + row / 2; z < radius; z += row) {
			float chord = 2 * (float) Math.sqrt(radius * radius - z * z);
			Matrix4f shape = new Matrix4f().translate(0, 0, z).scale(chord, 0.02F, row + 0.02F).translate(-0.5F, 0, -0.5F);
			Display.BlockDisplay strip = Displays.grow(level, new Vec3(c.x, y, c.z), SHADE, new Matrix4f().scale(0.03F, 1, 0.03F).mul(shape), 1, ticks + 10, false);
			hold.drawn.add(strip);
			after(level, 3, () -> Displays.animate(strip, shape, spread));
		}
		sound(level, c, Element.SHADOW.cast, 2, 0.5F);
		sound(level, c, SoundEvents.SCULK_SHRIEKER_SHRIEK, 0.8F, 0.6F);
		int[] caught = { 0 };
		hold.creeping++;
		bind(p, hold, ticks, true, t -> {
			double r = radius * Math.min(1, (t + 1) / (double) (spread + 3));
			if (t <= spread + 3) {
				// the caster stands still while the shadow spreads
				hold(p);
				for (int i = 0; i < 24; i++) {
					double a = level.getRandom().nextDouble() * Math.PI * 2;
					level.sendParticles(Element.SHADOW.trail, c.x + Math.cos(a) * r, y + 0.1, c.z + Math.sin(a) * r, 1, 0, 0.02, 0, 0);
				}
				for (LivingEntity e : enemies(level, p, new AABB(c, c).inflate(r, 3, r),
						e -> !hold.held.containsKey(e) && e.position().subtract(c).horizontalDistanceSqr() <= r * r && Math.abs(e.getY() - y) < 3)) {
					hold.held.put(e, new Caught(e, p, List.of()));
					caught[0]++;
					sound(level, e.position(), Element.SHADOW.impact, 1, 0.6F);
				}
			}
			if (t == spread + 3) {
				hold.creeping--;
				tell(p, caught[0] == 0 ? "No one was caught" : "Shadow Imitation Field caught " + caught[0]);
			}
		});
	}

	// ------------------------------------------------------------------ sarutobi
	/** Breathes a cloud of hot ash that blinds, then ignites it with a click of the teeth. */
	private static void ashPile(ServerPlayer p) {
		ServerLevel level = level(p);
		List<Vec3> points = new ArrayList<>();
		sound(level, p.getEyePosition(), SoundEvents.FIRE_EXTINGUISH, 1.2F, 0.5F);
		channel(p, 20, 1, t -> {
			Vec3 mouth = p.getEyePosition().add(p.getLookAngle().scale(0.6)).subtract(0, 0.2, 0);
			for (int i = 0; i < 6; i++)
				spray(level, i % 2 == 0 ? ParticleTypes.LARGE_SMOKE : ParticleTypes.SMOKE, mouth, p.getLookAngle(), 0.35 + level.getRandom().nextDouble() * 0.2, 0.5);
			if (t % 4 == 0)
				points.add(lookPoint(p, 3 + t * 0.45));
			for (LivingEntity target : cone(p, 11, 25))
				target.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 60, 0, false, false));
		});
		after(level, 45, () -> {
			if (!p.isAlive())
				return;
			sound(level, p.position(), SoundEvents.FLINTANDSTEEL_USE, 1.5F, 1);
			for (Vec3 at : points) {
				burst(level, at, 3, 10, 0.6F, Element.FIRE, p);
				level.sendParticles(ParticleTypes.FLAME, at.x, at.y, at.z, 30, 1.2, 1, 1.2, 0.05);
			}
		});
	}

	/** A fire dragon that spits fireballs at enemies near its path. */
	private static void flameBullet(ServerPlayer p) {
		ServerLevel level = level(p);
		JutsuProjectile dragon = shoot(p, Element.FIRE, Shape.DRAGON, 1.2F, 1.0F, 12);
		dragon.life = 50;
		dragon.pierce = -1;
		dragon.knockback = 1;
		dragon.onImpact = d -> burst(level, d.position(), 3, 10, 1, Element.FIRE, d);
		channel(p, 50, 10, t -> {
			if (t == 0 || !dragon.isAlive())
				return;
			Vec3 mouth = dragon.getBoundingBox().getCenter();
			enemies(level, p, dragon.getBoundingBox().inflate(16), e -> true).stream()
					.min((a, b) -> Double.compare(a.distanceToSqr(mouth), b.distanceToSqr(mouth))).ifPresent(target -> {
						Vec3 aim = target.getBoundingBox().getCenter().subtract(mouth).normalize().scale(1.4);
						JutsuProjectile ball = spawn(p, Element.FIRE, Shape.ORB, 0.5F, mouth, aim, 6);
						ball.life = 20;
						ball.onImpact = b -> puff(level, b.position(), Element.FIRE, 0.8F);
						sound(level, mouth, SoundEvents.BLAZE_SHOOT, 1, 1.2F);
					});
		});
		sound(level, p.getEyePosition(), SoundEvents.BLAZE_SHOOT, 1.5F, 0.6F);
	}

	// ------------------------------------------------------------------ uzumaki
	/**
	 * Heal Bite: the ally looked at (a player or the caster's own creature; the caster if no one) bites the caster and draws their
	 * chakra, healing even deadly wounds and restoring their stamina. It drains the caster hard: a third of their chakra on top of
	 * the jutsu's price, and what is missing comes out of their own health.
	 */
	private static void healBite(ServerPlayer p) {
		ServerLevel level = level(p);
		Vec3 eye = p.getEyePosition(), look = p.getLookAngle();
		LivingEntity ally = level.getEntitiesOfClass(LivingEntity.class, p.getBoundingBox().inflate(5),
				e -> e != p && e.isAlive() && (e instanceof Player || e instanceof OwnableEntity own && own.getOwner() == p)
						&& e.getBoundingBox().getCenter().subtract(eye).normalize().dot(look) > 0.85)
				.stream().min((a, b) -> Double.compare(a.distanceToSqr(p), b.distanceToSqr(p))).orElse(p);
		ally.setHealth(ally.getMaxHealth());
		ally.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 100, 1));
		if (ally instanceof ServerPlayer bitten) {
			bitten.getFoodData().eat(10, 0.6F);
			if (bitten != p)
				set(bitten, v -> v.ChakraAmount = Math.min(v.ChakraMax, v.ChakraAmount + v.ChakraMax * 0.4));
		}
		// the price: a third of the caster's chakra, and health for what is not there
		PlayerVariables vars = NarutoShippudenModVariables.get(p);
		double drain = vars.ChakraMax / 3, missing = Math.max(0, drain - vars.ChakraAmount);
		set(p, v -> v.ChakraAmount = Math.max(0, v.ChakraAmount - drain));
		if (missing > 0)
			p.setHealth(Math.max(1, p.getHealth() - (float) (missing / vars.ChakraMax * 20)));
		p.getFoodData().setFoodLevel(Math.max(0, p.getFoodData().getFoodLevel() - 4));
		if (ally != p)
			line(level, ParticleTypes.HEART, p.getBoundingBox().getCenter(), ally.getBoundingBox().getCenter(), 0.8);
		puff(level, ally.position().add(0, 1, 0), Element.SEAL, 0.8F);
		level.sendParticles(ParticleTypes.HEART, ally.getX(), ally.getY() + ally.getBbHeight() + 0.3, ally.getZ(), 6, 0.4, 0.2, 0.4, 0);
		sound(level, p.position(), SoundEvents.GENERIC_EAT.value(), 1, 0.8F);
		tell(p, ally == p ? "You bite your own arm to heal" : "Your chakra heals " + ally.getDisplayName().getString());
	}

	/** Golden chakra chains shoot from the back, seek enemies and bind them in place for four seconds. */
	private static void sealingChains(ServerPlayer p) {
		ServerLevel level = level(p);
		Vec3 look = p.getLookAngle();
		for (int i = 0; i < 5; i++) {
			JutsuProjectile chain = shoot(p, Element.SEAL, Shape.NEEDLE, 0.3F, turned(p, (i - 2) * 12, -8 + (i % 2) * 10).scale(1.5), 4);
			chain.setPos(p.position().add(0, 1.1, 0).subtract(look.multiply(1, 0, 1).scale(0.4)));
			chain.homing = 0.3F;
			chain.life = 30;
			chain.knockback = 0;
			channel(p, 30, 1, t -> {
				if (chain.isAlive())
					line(level, Element.SEAL.trail, p.position().add(0, 1.1, 0), chain.getBoundingBox().getCenter(), 0.45);
			});
			chain.onHit = (c, target) -> channel(p, 80, 1, t -> {
				if (!target.isAlive())
					return;
				target.setDeltaMovement(0, Math.min(0, target.getDeltaMovement().y), 0);
				target.addEffect(new MobEffectInstance(MobEffects.SLOWNESS, 10, 5, false, false));
				if (t % 2 == 0)
					line(level, Element.SEAL.trail, p.position().add(0, 1.1, 0), target.getBoundingBox().getCenter(), 0.5);
				if (t % 20 == 0)
					damage(p, target, 2, Element.SEAL);
			});
		}
		sound(level, p.position(), SoundEvents.CHAIN_PLACE, 1.5F, 0.8F);
	}

	/**
	 * Dead Demon Consuming Seal. The caster's soul is drawn half out and the Shinigami appears behind them; its arm reaches through
	 * them and grabs the soul of the enemy close in front, who is held fast, stripped of their jutsu and then sealed away. A soul
	 * too strong to pull out whole loses its arms instead (it can barely fight for a minute). Either way the Shinigami then
	 * consumes the caster's own soul: they have ten seconds left.
	 */
	private static void deadDemon(ServerPlayer p) {
		ServerLevel level = level(p);
		LivingEntity target = target(p, 6);
		if (target == null) {
			Jutsus.miss(p, "The Shinigami needs a soul within reach");
			return;
		}
		flag(p, 90, v -> v.deathgod = true, v -> v.deathgod = false);
		sound(level, p.position(), SoundEvents.WITHER_SPAWN, 1, 0.6F);
		tell(p, "The Shinigami reaches through your soul...");
		channel(p, 60, 1, t -> {
			if (!target.isAlive())
				return;
			hold(target);
			hold(p);
			if (target instanceof ServerPlayer victim && t == 20) {
				// the grabbed soul can't keep any jutsu going
				stop(victim);
				victim.removeAllEffects();
			}
			if (t >= 20 && t % 2 == 0)
				line(level, ParticleTypes.SOUL, p.getBoundingBox().getCenter(), target.getBoundingBox().getCenter(), 0.5);
			if (t % 4 == 0)
				level.sendParticles(ParticleTypes.SOUL_FIRE_FLAME, p.getX(), p.getY() + 2.4, p.getZ(), 3, 0.5, 0.5, 0.5, 0.01);
		});
		after(level, 60, () -> {
			if (!p.isAlive())
				return;
			if (target.isAlive()) {
				boolean whole = target instanceof Player || target.getMaxHealth() <= 200;
				level.sendParticles(ParticleTypes.SCULK_SOUL, target.getX(), target.getY() + 1, target.getZ(), 25, 0.4, 0.6, 0.4, 0.05);
				puff(level, target.getBoundingBox().getCenter(), Element.SEAL, 1.5F);
				sound(level, target.position(), SoundEvents.WITHER_DEATH, 0.8F, 1.2F);
				if (whole)
					damage(p, target, 10000, Element.SEAL);
				else {
					// only the arms of the soul come away
					damage(p, target, 30, Element.SEAL);
					target.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 1200, 9));
					target.addEffect(new MobEffectInstance(MobEffects.MINING_FATIGUE, 1200, 4));
				}
			}
			tell(p, "The Shinigami is consuming your soul");
			p.addEffect(new MobEffectInstance(MobEffects.SLOWNESS, 200, 2));
			p.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 200, 2));
			channel(p, 200, 10, t -> level.sendParticles(ParticleTypes.SOUL, p.getX(), p.getY() + 1, p.getZ(), 3, 0.3, 0.5, 0.3, 0.02));
			after(level, 200, () -> {
				if (p.isAlive())
					p.hurtServer(level, p.damageSources().magic(), Float.MAX_VALUE);
			});
		});
	}

	/** Freezes an entity in place. */
	static void hold(LivingEntity target) {
		target.setDeltaMovement(0, Math.min(0, target.getDeltaMovement().y), 0);
		target.addEffect(new MobEffectInstance(MobEffects.SLOWNESS, 10, 9, false, false));
		if (target instanceof net.minecraft.world.entity.Mob mob) {
			mob.getNavigation().stop();
			mob.setTarget(null);
		}
	}

	// ------------------------------------------------------------------ tsuchigumo
	/** The clan's forbidden technique: a ball of chakra swells where the caster looks and explodes like a small sun. */
	private static void fury(ServerPlayer p) {
		ServerLevel level = level(p);
		float power = CREATION.getOrDefault(p.getUUID(), 0L) > level.getGameTime() ? 1.6F : 1;
		CREATION.remove(p.getUUID());
		Vec3 at = lookPoint(p, 30);
		JutsuProjectile core = spawn(p, Element.FIRE, Shape.ORB, 0.5F, at, Vec3.ZERO, 0);
		core.pierce = -1;
		core.knockback = 0;
		core.life = 40;
		channel(p, 30, 1, t -> {
			float size = (0.5F + t * 0.12F) * power;
			core.look(Element.FIRE, Shape.ORB, size);
			core.setPos(at.subtract(0, size / 2, 0));
			level.sendParticles(Element.EARTH.trail, at.x, at.y - size / 2, at.z, 6, 2.5, 0.2, 2.5, 0.1);
			if (t % 6 == 0)
				sound(level, at, SoundEvents.BEACON_POWER_SELECT, 1.5F, 0.5F + t * 0.03F);
		});
		after(level, 30, () -> {
			burst(level, at, 8 * power, 35 * power, 2.5F, Element.FIRE, core);
			core.discard();
			level.sendParticles(ParticleTypes.EXPLOSION_EMITTER, at.x, at.y, at.z, 3, 2, 1, 2, 0);
			puff(level, at, Element.EARTH, 5);
			sound(level, at, SoundEvents.GENERIC_EXPLODE.value(), 3, 0.6F);
		});
	}
}
