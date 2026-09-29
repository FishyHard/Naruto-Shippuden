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
				new Def("Parasitic Insect Cloud", JutsuRank.C, ClanJutsu::insectCloud),
				new Def("Insect Jar Technique", JutsuRank.B, ClanJutsu::insectJar),
				new Def("Insect Bog", JutsuRank.A, ClanJutsu::insectBog));
		nature("akimichi", "Akimichi Clan", v -> v.akimichireleaselogic, v -> v.akimichitechnique, (v, i) -> v.akimichitechnique = i,
				v -> v.akimichilearn, (v, i) -> v.akimichilearn = i, v -> v.akimichirelease, (v, i) -> v.akimichirelease = i,
				new Def("Expansion Technique", JutsuRank.C, ClanJutsu::expansion),
				new Def("Human Bullet Tank", JutsuRank.B, p -> bulletTank(p, false)),
				new Def("Spiked Human Bullet Tank", JutsuRank.A, p -> bulletTank(p, true)),
				new Def("Butterfly Mode", JutsuRank.S, ClanJutsu::butterfly));
		nature("fuma", "Fuma Clan", v -> v.fumareleaselogic, v -> v.fumatechnique, (v, i) -> v.fumatechnique = i, v -> v.fumalearn,
				(v, i) -> v.fumalearn = i, v -> v.fumarelease, (v, i) -> v.fumarelease = i,
				new Def("Shuriken Barrage", JutsuRank.D, ClanJutsu::shurikenBarrage),
				new Def("Fuma Shuriken", JutsuRank.C, ClanJutsu::fumaShuriken),
				new Def("Toroi's Magnetic Fuma Shuriken", JutsuRank.B, ClanJutsu::toroiShuriken));
		nature("hozuki", "Hozuki Clan", v -> v.hozukireleaselogic, v -> v.hozukitechnique, (v, i) -> v.hozukitechnique = i, v -> v.hozukilearn,
				(v, i) -> v.hozukilearn = i, v -> v.hozukirelease, (v, i) -> v.hozukirelease = i,
				new Def("Water Gun Technique", JutsuRank.D, ClanJutsu::waterPistol),
				new Def("Drowning Water Blob Technique", JutsuRank.C, ClanJutsu::drowningBlob),
				new Def("Great Water Arm Technique", JutsuRank.B, ClanJutsu::waterArm));
		nature("hyuga", "Hyuga Clan", v -> v.hyugareleaselogic, v -> v.hyugatechnique, (v, i) -> v.hyugatechnique = i, v -> v.hyugalearn,
				(v, i) -> v.hyugalearn = i, v -> v.hyugarelease, (v, i) -> v.hyugarelease = i,
				new Def("Gentle Fist", JutsuRank.D, ClanJutsu::gentleFist, "Taijutsu"),
				new Def("Gentle Step Twin Lion Fists", JutsuRank.C, ClanJutsu::twinLions),
				new Def("Eight Trigrams Twin Lions Crumbling Attack", JutsuRank.B, ClanJutsu::crumblingAttack),
				new Def("Eight Trigrams Palms Revolving Heaven", JutsuRank.A, ClanJutsu::rotation),
				new Def("Eight Trigrams Sixty-Four Palms", JutsuRank.S, ClanJutsu::sixtyFourPalms, "Taijutsu"));
		nature("inuzuka", "Inuzuka Clan", v -> v.inuzukareleaselogic, v -> v.inuzukatechnique, (v, i) -> v.inuzukatechnique = i,
				v -> v.inuzukalearn, (v, i) -> v.inuzukalearn = i, v -> v.inuzuka_release, (v, i) -> v.inuzuka_release = i,
				new Def("Akamaru", JutsuRank.D, ClanJutsu::akamaru, "Summoning"),
				new Def("Four Legs Technique", JutsuRank.D, ClanJutsu::fourLegs, "Taijutsu"),
				new Def("Dynamic Marking", JutsuRank.D, ClanJutsu::dynamicMarking),
				new Def("Passing Fang", JutsuRank.C, ClanJutsu::passingFang, "Taijutsu"),
				new Def("Man Beast Clone", JutsuRank.C, ClanJutsu::manBeastClone),
				new Def("Fang Over Fang", JutsuRank.B, ClanJutsu::fangOverFang, "Taijutsu"),
				new Def("Tunneling Fang", JutsuRank.A, ClanJutsu::tunnelingFang, "Taijutsu"));
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
				new Def("Shadow Neck Binding Technique", JutsuRank.B, ClanJutsu::neckBinding),
				new Def("Shadow Sewing Technique", JutsuRank.A, ClanJutsu::shadowSewing),
				new Def("Shadow Gathering Technique", JutsuRank.S, ClanJutsu::shadowGathering));
		Jutsus.TECHNIQUES.get(Identifier.fromNamespaceAndPath("naruto_shippuden", "nara_release_technique")).onSneak = ClanJutsu::releaseShadow;
		nature("sarutobi", "Sarutobi Clan", v -> v.sarutobireleaselogic, v -> v.sarutobitechnique, (v, i) -> v.sarutobitechnique = i,
				v -> v.sarutobilearn, (v, i) -> v.sarutobilearn = i, v -> v.sarutobirelease, (v, i) -> v.sarutobirelease = i,
				new Def("Ash Pile Burning", JutsuRank.C, ClanJutsu::ashPile),
				new Def("Fire Dragon Flame Bullet", JutsuRank.B, ClanJutsu::flameBullet));
		nature("uzumaki", "Uzumaki Clan", v -> v.uzumakireleaselogic, v -> v.uzumakitechnique, (v, i) -> v.uzumakitechnique = i,
				v -> v.uzumakilearn, (v, i) -> v.uzumakilearn = i, v -> v.uzumakirelease, (v, i) -> v.uzumakirelease = i,
				new Def("Adamantine Sealing Chains", JutsuRank.C, ClanJutsu::sealingChains),
				new Def("Heal Bite", JutsuRank.B, ClanJutsu::healBite),
				new Def("Dead Demon Consuming Seal", JutsuRank.S, ClanJutsu::deadDemon));
		nature("tsuchigumo", "Tsuchigumo Clan", v -> v.tsuchigumoreleaselogic, v -> 0, (v, i) -> {
		}, v -> v.tsuchigumolearn, (v, i) -> v.tsuchigumolearn = i, v -> v.tsuchigumorelease, (v, i) -> v.tsuchigumorelease = i,
				new Def("Forbidden Technique: Fury", JutsuRank.S, ClanJutsu::fury));
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

	/** Akamaru within range for a jutsu that needs him; if he isn't there, the chakra and the cooldown are given back. */
	private static AkamaruEntity.@Nullable CustomEntity needAkamaru(ServerPlayer p, double range, JutsuRank rank, int index) {
		AkamaruEntity.CustomEntity dog = akamaruOf(p, range);
		if (dog == null) {
			tell(p, "Akamaru has to be close");
			set(p, v -> v.ChakraAmount += rank.chakra);
			after(level(p), 1, () -> p.getCooldowns().removeCooldown(Identifier.fromNamespaceAndPath("naruto_shippuden", "inuzuka_release_technique/" + index)));
		}
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
			tell(p, "Look at an enemy to mark");
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

	/** Spins down into the earth, digs under the enemy and bursts up beneath it. */
	private static void tunnelingFang(ServerPlayer p) {
		LivingEntity target = prey(p, 24);
		if (target == null) {
			tell(p, "Nothing to dig towards");
			return;
		}
		ServerLevel level = level(p);
		Vec3 from = p.position();
		int ticks = 20;
		p.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, ticks + 2, 0, false, false));
		flag(p, ticks + 12, v -> v.PassingFang = true, v -> v.PassingFang = false);
		channel(p, ticks, 1, t -> {
			if (!target.isAlive())
				return;
			Vec3 at = from.lerp(target.position(), (t + 1) / (double) ticks);
			p.teleportTo(at.x, at.y, at.z);
			p.fallDistance = 0;
			net.minecraft.world.level.block.state.BlockState ground = level.getBlockState(net.minecraft.core.BlockPos.containing(at.x, at.y - 0.5, at.z));
			if (!ground.isAir())
				level.sendParticles(new net.minecraft.core.particles.BlockParticleOption(ParticleTypes.BLOCK, ground), at.x, at.y + 0.1, at.z, 12, 0.4, 0.1, 0.4, 0.1);
			if (t % 4 == 0)
				sound(level, at, SoundEvents.ROOTED_DIRT_BREAK, 1, 0.6F);
		});
		after(level, ticks, () -> {
			p.removeEffect(MobEffects.INVISIBILITY);
			p.setDeltaMovement(0, 0.9, 0);
			p.syncVelocity = true;
			sound(level, p.position(), SoundEvents.GENERIC_EXPLODE.value(), 0.7F, 1.4F);
			net.minecraft.world.level.block.state.BlockState ground = level.getBlockState(p.blockPosition().below());
			if (!ground.isAir())
				level.sendParticles(new net.minecraft.core.particles.BlockParticleOption(ParticleTypes.BLOCK, ground), p.getX(), p.getY() + 0.3, p.getZ(), 60, 0.8, 0.4, 0.8, 0.2);
			for (LivingEntity hit : enemies(level, p, p.getBoundingBox().inflate(2), e -> !(e instanceof AkamaruEntity.CustomEntity))) {
				damage(p, hit, 22, Element.BEAST);
				hit.push(0, 1.2, 0);
				hit.syncVelocity = true;
			}
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

	// ------------------------------------------------------------------ nara
	private static final BlockState SHADE = Blocks.CONCRETE.pick(net.minecraft.world.item.DyeColor.BLACK).defaultBlockState();

	/** A Nara's shadow hold: who it holds and where, the shadow drawn on the ground, and how far the caster has walked it since it caught. */
	private static final class Hold {
		final Map<LivingEntity, Vec3> held = new java.util.LinkedHashMap<>();
		final List<Display.BlockDisplay> drawn = new ArrayList<>();
		final List<Matrix4f> shapes = new ArrayList<>();
		Vec3 offset = Vec3.ZERO;
		boolean caught, ended;
	}

	/** Each Nara's current shadow (one at a time: a new shadow jutsu lets go of the last). */
	private static final Map<UUID, Hold> HOLDS = new HashMap<>();

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

	/** The top of the ground under a point (looking a little above and below it), or the point's own height over a drop. */
	private static double ground(ServerLevel level, double x, double y, double z) {
		net.minecraft.core.BlockPos.MutableBlockPos pos = net.minecraft.core.BlockPos.containing(x, y + 1.5, z).mutable();
		for (int i = 0; i < 6; i++, pos.move(0, -1, 0)) {
			net.minecraft.world.phys.shapes.VoxelShape shape = level.getBlockState(pos).getCollisionShape(level, pos);
			if (!shape.isEmpty() && pos.getY() + shape.max(net.minecraft.core.Direction.Axis.Y) <= y + 1.6)
				return pos.getY() + shape.max(net.minecraft.core.Direction.Axis.Y);
		}
		return y;
	}

	/** A piece of shadow laid flat on the ground, turned by yaw. */
	private static void lay(ServerLevel level, Hold hold, Vec3 at, float yaw, float width, float length, int life) {
		Matrix4f shape = Displays.box(yaw, 0, width, 0.02F, length);
		hold.drawn.add(Displays.grow(level, new Vec3(at.x, ground(level, at.x, at.y, at.z) + 0.015, at.z), SHADE, shape, 2, life, false));
		hold.shapes.add(shape);
	}

	/** A round pool of shadow under someone caught. */
	private static void pool(ServerLevel level, Hold hold, LivingEntity target, int life) {
		float size = target.getBbWidth() + 0.9F;
		for (int i = 0; i < 2; i++)
			lay(level, hold, target.position(), (float) (i * Math.PI / 4), size, size, life);
	}

	/**
	 * The caster's shadow stretches over the ground towards the target (following it as it runs) and catches it on reaching its
	 * feet. It gives up after range blocks, or if the target gets away or dies. The pieces live for life ticks unless let go.
	 */
	private static void creep(ServerPlayer p, LivingEntity target, double range, int life, Consumer<Hold> caught) {
		ServerLevel level = level(p);
		Hold hold = newHold(p);
		Vec3[] tip = { p.position() };
		double[] run = { 0 };
		sound(level, p.position(), Element.SHADOW.cast, 1.2F, 0.7F);
		channel(p, (int) (range / 0.9) + 4, 1, t -> {
			if (hold.ended || hold.caught)
				return;
			if (!target.isAlive() || target.level() != p.level()) {
				endHold(p, hold);
				return;
			}
			Vec3 to = target.position().subtract(tip[0]), flat = new Vec3(to.x, 0, to.z);
			if (flat.length() < 0.9 && Math.abs(to.y) < 2.5) {
				hold.caught = true;
				hold.held.put(target, target.position());
				pool(level, hold, target, life);
				sound(level, target.position(), Element.SHADOW.impact, 1.5F, 0.6F);
				caught.accept(hold);
				return;
			}
			if (run[0] >= range) {
				tell(p, "The shadow can't reach that far");
				endHold(p, hold);
				return;
			}
			Vec3 step = flat.normalize().scale(Math.min(0.9, flat.length())), from = tip[0];
			Vec3 next = from.add(step);
			tip[0] = new Vec3(next.x, ground(level, next.x, from.y, next.z), next.z);
			run[0] += step.length();
			Vec3 middle = from.add(tip[0]).scale(0.5);
			lay(level, hold, new Vec3(middle.x, Math.max(from.y, tip[0].y), middle.z), (float) Math.atan2(step.x, step.z), 0.7F, (float) step.length() + 0.2F, life);
			level.sendParticles(Element.SHADOW.trail, tip[0].x, tip[0].y + 0.1, tip[0].z, 3, 0.2, 0.02, 0.2, 0);
		});
	}

	/**
	 * Holds whoever the shadow has caught for ticks: they can't move by themselves, and (mimic) copy every step and turn the caster
	 * makes, while the shadow on the ground moves along. each runs every tick. The hold ends early when everyone held is gone
	 * (after the first grace ticks, while the shadow may still be catching).
	 */
	private static void bind(ServerPlayer p, Hold hold, int ticks, int grace, boolean mimic, IntConsumer each) {
		ServerLevel level = level(p);
		Vec3[] last = { p.position() };
		channel(p, ticks, 1, t -> {
			if (hold.ended)
				return;
			hold.held.keySet().removeIf(e -> !e.isAlive() || e.level() != p.level());
			if (hold.held.isEmpty() && t >= grace || t == ticks - 1) {
				endHold(p, hold);
				return;
			}
			Vec3 step = p.position().subtract(last[0]);
			last[0] = p.position();
			boolean moved = mimic && step.lengthSqr() > 1.0E-6 && step.lengthSqr() < 4;
			for (Map.Entry<LivingEntity, Vec3> entry : hold.held.entrySet()) {
				LivingEntity e = entry.getKey();
				hold(e);
				e.fallDistance = 0;
				if (e instanceof ServerPlayer victim)
					victim.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 10, 9, false, false));
				Vec3 spot = entry.getValue();
				if (moved) {
					e.setPos(spot);
					e.move(net.minecraft.world.entity.MoverType.SELF, step);
					spot = e.position();
					entry.setValue(spot);
				}
				if (moved && e instanceof ServerPlayer || e.position().distanceToSqr(spot) > 0.04)
					e.teleportTo(spot.x, spot.y, spot.z);
				if (mimic && !(e instanceof Player)) {
					e.setYRot(p.getYRot());
					e.setYHeadRot(p.getYHeadRot());
					e.setYBodyRot(p.yBodyRot);
				}
			}
			if (moved)
				hold.offset = hold.offset.add(step);
			if (moved && t >= grace)
				for (int i = 0; i < hold.drawn.size(); i++)
					Displays.animate(hold.drawn.get(i), new Matrix4f().translation((float) hold.offset.x, 0, (float) hold.offset.z).mul(hold.shapes.get(i)), 1);
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
			hold.held.put(target, target.position());
			pool(level, hold, target, 70);
			bind(p, hold, 60, 0, false, t -> {
			});
			sound(level, target.position(), Element.SHADOW.impact, 1.2F, 0.8F);
		};
		sound(level(p), p.getEyePosition(), SoundEvents.PLAYER_ATTACK_SWEEP, 1, 1.6F);
	}

	/** The shadow creeps to the enemy being looked at and catches it: for ten seconds it copies every move the caster makes. */
	private static void shadowImitation(ServerPlayer p) {
		LivingEntity target = target(p, 20);
		if (target == null) {
			tell(p, "Look at an enemy to catch");
			return;
		}
		creep(p, target, 20, 240, hold -> {
			tell(p, "Shadow Imitation complete");
			bind(p, hold, 200, 0, true, t -> {
			});
		});
	}

	/** Shadow Imitation, then hands of shadow climb the caught enemy's body and choke them for six seconds. */
	private static void neckBinding(ServerPlayer p) {
		LivingEntity target = target(p, 20);
		if (target == null) {
			tell(p, "Look at an enemy to catch");
			return;
		}
		creep(p, target, 20, 160, hold -> {
			ServerLevel level = level(p);
			bind(p, hold, 120, 0, true, t -> {
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

	/** Threads of shadow shoot out at up to five enemies nearby, pierce them and pin them for four seconds. */
	private static void shadowSewing(ServerPlayer p) {
		ServerLevel level = level(p);
		List<LivingEntity> near = new ArrayList<>(enemies(level, p, p.getBoundingBox().inflate(16), e -> e.distanceToSqr(p) < 16 * 16 && p.hasLineOfSight(e)));
		near.sort((a, b) -> Double.compare(a.distanceToSqr(p), b.distanceToSqr(p)));
		Hold hold = newHold(p);
		Vec3 feet = p.position().add(0, 0.2, 0);
		int threads = Math.max(1, Math.min(5, near.size()));
		for (int i = 0; i < threads; i++) {
			LivingEntity aim = i < near.size() ? near.get(i) : null;
			Vec3 velocity = aim == null ? p.getLookAngle().scale(1.5) : aim.getBoundingBox().getCenter().subtract(feet).normalize().scale(1.5);
			JutsuProjectile thread = spawn(p, Element.SHADOW, Shape.NEEDLE, 0.35F, feet, velocity, 9);
			thread.homing = 0.4F;
			thread.life = 30;
			thread.knockback = 0;
			channel(p, 30, 1, t -> {
				if (thread.isAlive())
					line(level, Element.SHADOW.trail, feet, thread.getBoundingBox().getCenter(), 0.35);
			});
			thread.onHit = (s, target) -> {
				if (hold.ended || hold.held.containsKey(target))
					return;
				boolean first = hold.held.isEmpty();
				hold.held.put(target, target.position());
				if (first)
					bind(p, hold, 80, 0, false, t -> {
						if (t % 2 == 0)
							for (LivingEntity e : hold.held.keySet())
								line(level, Element.SHADOW.trail, p.position().add(0, 0.2, 0), e.getBoundingBox().getCenter(), 0.45);
					});
			};
		}
		sound(level, p.position(), Element.SHADOW.cast, 1.5F, 1.2F);
		sound(level, p.position(), SoundEvents.PLAYER_ATTACK_SWEEP, 1, 0.6F);
	}

	/**
	 * The shadows all around are gathered into the caster's: a pool spreads over the ground to fourteen blocks, and every enemy it
	 * reaches is caught and copies the caster's moves for eight seconds.
	 */
	private static void shadowGathering(ServerPlayer p) {
		ServerLevel level = level(p);
		Hold hold = newHold(p);
		Vec3 c = p.position();
		double y = ground(level, c.x, c.y, c.z) + 0.015;
		int spread = 30, ticks = spread + 160;
		float radius = 14, row = 1.4F;
		// a round pool made of strips across it, growing out from the caster's feet
		for (float z = -radius + row / 2; z < radius; z += row) {
			float chord = 2 * (float) Math.sqrt(radius * radius - z * z);
			Matrix4f shape = new Matrix4f().translate(0, 0, z).scale(chord, 0.02F, row + 0.02F).translate(-0.5F, 0, -0.5F);
			Display.BlockDisplay strip = Displays.grow(level, new Vec3(c.x, y, c.z), SHADE, new Matrix4f().scale(0.03F, 1, 0.03F).mul(shape), 1, ticks + 10, false);
			hold.drawn.add(strip);
			hold.shapes.add(shape);
			after(level, 3, () -> Displays.animate(strip, shape, spread));
		}
		sound(level, c, Element.SHADOW.cast, 2, 0.5F);
		sound(level, c, SoundEvents.SCULK_SHRIEKER_SHRIEK, 0.8F, 0.6F);
		int[] caught = { 0 };
		bind(p, hold, ticks, spread + 4, true, t -> {
			double r = radius * Math.min(1, (t + 1) / (double) (spread + 3));
			Vec3 at = c.add(hold.offset.x, 0, hold.offset.z);
			if (t <= spread + 3) {
				// the caster stands still while the shadows gather
				hold(p);
				for (int i = 0; i < 24; i++) {
					double a = level.getRandom().nextDouble() * Math.PI * 2;
					level.sendParticles(Element.SHADOW.trail, at.x + Math.cos(a) * r, y + 0.1, at.z + Math.sin(a) * r, 1, 0, 0.02, 0, 0);
				}
				for (LivingEntity e : enemies(level, p, new AABB(at, at).inflate(r, 3, r),
						e -> !hold.held.containsKey(e) && e.position().subtract(at).horizontalDistanceSqr() <= r * r && Math.abs(e.getY() - y) < 3)) {
					hold.held.put(e, e.position());
					caught[0]++;
					sound(level, e.position(), Element.SHADOW.impact, 1, 0.6F);
				}
			}
			if (t == spread + 3)
				tell(p, caught[0] == 0 ? "No one was caught" : "Shadow Gathering caught " + caught[0]);
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
			tell(p, "The Shinigami needs a soul within reach");
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
	private static void hold(LivingEntity target) {
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
		Vec3 at = lookPoint(p, 30);
		JutsuProjectile core = spawn(p, Element.FIRE, Shape.ORB, 0.5F, at, Vec3.ZERO, 0);
		core.pierce = -1;
		core.knockback = 0;
		core.life = 40;
		channel(p, 30, 1, t -> {
			float size = 0.5F + t * 0.12F;
			core.look(Element.FIRE, Shape.ORB, size);
			core.setPos(at.subtract(0, size / 2, 0));
			level.sendParticles(Element.EARTH.trail, at.x, at.y - size / 2, at.z, 6, 2.5, 0.2, 2.5, 0.1);
			if (t % 6 == 0)
				sound(level, at, SoundEvents.BEACON_POWER_SELECT, 1.5F, 0.5F + t * 0.03F);
		});
		after(level, 30, () -> {
			burst(level, at, 8, 35, 2.5F, Element.FIRE, core);
			core.discard();
			level.sendParticles(ParticleTypes.EXPLOSION_EMITTER, at.x, at.y, at.z, 3, 2, 1, 2, 0);
			puff(level, at, Element.EARTH, 5);
			sound(level, at, SoundEvents.GENERIC_EXPLODE.value(), 3, 0.6F);
		});
	}
}
