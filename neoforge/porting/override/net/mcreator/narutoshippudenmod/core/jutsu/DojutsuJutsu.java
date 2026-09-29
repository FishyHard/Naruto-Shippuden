package net.mcreator.narutoshippudenmod.core.jutsu;

import static net.mcreator.narutoshippudenmod.core.jutsu.ClanJutsu.flag;
import static net.mcreator.narutoshippudenmod.core.jutsu.ClanJutsu.keep;
import static net.mcreator.narutoshippudenmod.core.jutsu.ClanJutsu.mode;
import static net.mcreator.narutoshippudenmod.core.jutsu.ClanJutsu.shell;
import static net.mcreator.narutoshippudenmod.core.jutsu.ClanJutsu.spawn;
import static net.mcreator.narutoshippudenmod.core.jutsu.ClanJutsu.target;
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
import static net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.turned;

import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables;
import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables.PlayerVariables;
import net.mcreator.narutoshippudenmod.compat.Compat;
import net.mcreator.narutoshippudenmod.core.EntityScale;
import net.mcreator.narutoshippudenmod.core.jutsu.NatureJutsu.Def;
import net.mcreator.narutoshippudenmod.core.jutsu.engine.Element;
import net.mcreator.narutoshippudenmod.core.jutsu.engine.JutsuProjectile;
import net.mcreator.narutoshippudenmod.core.jutsu.engine.JutsuProjectile.Shape;
import net.mcreator.narutoshippudenmod.core.jutsu.engine.JutsuRank;
import net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques;
import net.mcreator.narutoshippudenmod.entity.SummonEntities.CrowEntity;
import net.mcreator.narutoshippudenmod.particle.ModParticles.AmaterasuFireParticle;

import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.ObjDoubleConsumer;
import java.util.function.Predicate;
import java.util.function.ToDoubleFunction;

/**
 * The dojutsu on the jutsu engine. The Sharingan and Isshiki's eye are whole releases like the natures;
 * the Mangekyou Sharingan keep their scrolls (which also buy the Susanoo stages) and only their jutsu are remade here. Every jutsu
 * needs its eye active.
 */
@EventBusSubscriber(modid = "naruto_shippuden")
public final class DojutsuJutsu {
	private DojutsuJutsu() {
	}

	static void register() {
		nature("sharingan", "the Sharingan", v -> v.sharingan, v -> v.sharingantechnique, (v, i) -> v.sharingantechnique = i, v -> v.sharinganlearn,
				(v, i) -> v.sharinganlearn = i, v -> v.sharinganrelease, (v, i) -> v.sharinganrelease = i,
				new Def("Coercion Sharingan", JutsuRank.C, DojutsuJutsu::coercion),
				new Def("Demonic Illusion: Mirage Crow", JutsuRank.B, DojutsuJutsu::mirageCrow),
				new Def("Demonic Illusion: Shackling Stakes Technique", JutsuRank.A, DojutsuJutsu::shacklingStakes));
		requires("sharingan_release_technique", v -> v.sharingan && v.sharinganactivate, "Activate your Sharingan first");
		// the Kokugan (the items keep their old "isshiki_dojutsu" ids)
		nature("isshiki_dojutsu", "the Kokugan", v -> v.isshikidojutsu, v -> v.isshikidojutsutechnique, (v, i) -> v.isshikidojutsutechnique = i,
				v -> v.isshikidojutsulearn, (v, i) -> v.isshikidojutsulearn = i, v -> v.isshikidojutsurelease, (v, i) -> v.isshikidojutsurelease = i,
				new Def("Sukunahikona", JutsuRank.B, DojutsuJutsu::sukunahikona),
				new Def("Sukunahikona: Rapid Succession", JutsuRank.B, DojutsuJutsu::rapidSuccession),
				new Def("Lacquer Bloom", JutsuRank.A, DojutsuJutsu::lacquerBloom),
				new Def("Black Holy Hammer", JutsuRank.A, DojutsuJutsu::blackHolyHammer),
				new Def("Daikokuten: Daihakoten", JutsuRank.A, DojutsuJutsu::daihakoten),
				new Def("Daikokuten: Falling Star", JutsuRank.S, DojutsuJutsu::fallingStar));
		requires("isshiki_dojutsu_release_technique", v -> v.isshikidojutsu && v.isshikidojutsuactivate, "Activate the Kokugan first");

		// the Mangekyou: only the jutsu (their scrolls also sell the Susanoo stages)
		mangekyou("mangekyou_sharingan_itachi_release_technique", "Itachi", v -> v.MangekyouSharinganItachi, v -> 0, (v, i) -> {
		}, v -> v.mangekyoushrainganitachiamaterasulearn, new Def("Amaterasu", JutsuRank.A, DojutsuJutsu::amaterasu));
		mangekyou("mangekyou_sharingan_kakashi_release_technique", "Kakashi", v -> v.MangekyouSharinganKakashi, v -> 0, (v, i) -> {
		}, v -> v.mangekyousharingankakashikamuilearn, new Def("Kamui Long-Range", JutsuRank.A, p -> kamui(p, 30, 30)));
		mangekyou("mangekyou_sharingan_obito_release_technique", "Obito", v -> v.MangekyouSharinganObito, v -> v.mangekyousharinganobitokamuitechnique,
				(v, i) -> v.mangekyousharinganobitokamuitechnique = i, v -> v.mangekyousharinganobitokamuilearn,
				new Def("Kamui Self-Teleportation", JutsuRank.B, DojutsuJutsu::kamuiTeleport),
				new Def("Kamui Short-Range", JutsuRank.A, p -> kamui(p, 5, 12)),
				new Def("Kamui Phantom Phasing", JutsuRank.A, DojutsuJutsu::phantomPhasing));
		mangekyou("mangekyou_sharingan_sasuke_release_technique", "Sasuke", v -> v.MangekyouSharinganSasuke,
				v -> v.mangekyousharingansasukeamaterasutechnique,
				(v, i) -> v.mangekyousharingansasukeamaterasutechnique = i, v -> v.mangekyousharingansasukeamaterasulearn,
				new Def("Amaterasu", JutsuRank.A, DojutsuJutsu::amaterasu),
				new Def("Blaze Release: Kagutsuchi", JutsuRank.A, DojutsuJutsu::kagutsuchi),
				new Def("Blaze Release: Honoikazuchi", JutsuRank.S, DojutsuJutsu::honoikazuchi),
				new Def("Amaterasu: Flame Wrapping Fire", JutsuRank.S, DojutsuJutsu::flameWrapping));
	}

	private static void requires(String item, Predicate<PlayerVariables> requirement, String message) {
		Jutsus.Technique technique = Jutsus.TECHNIQUES.get(Identifier.fromNamespaceAndPath("naruto_shippuden", item));
		technique.requirement = requirement;
		technique.requirementMessage = message;
	}

	/** A Mangekyou technique item: its jutsu priced by rank, cast only with the Mangekyou active; the scroll is unchanged. */
	private static void mangekyou(String item, String whose, Predicate<PlayerVariables> has, ToDoubleFunction<PlayerVariables> selected,
			ObjDoubleConsumer<PlayerVariables> select, ToDoubleFunction<PlayerVariables> learned, Def... defs) {
		Jutsus.JutsuSpec[] specs = new Jutsus.JutsuSpec[defs.length];
		for (int i = 0; i < defs.length; i++) {
			JutsuRank rank = defs[i].rank();
			specs[i] = Jutsus.jutsu(defs[i].name(), learned, i + 1, "Ninjutsu", v -> v.ninjutsu, rank.ninjutsu, rank.chakra, rank.cooldowns());
		}
		Jutsus.technique(item, selected, select, v -> v.MangekyouSharinganActivate && has.test(v), deps -> {
			if (!(deps.get("entity") instanceof ServerPlayer player))
				return;
			Def def = defs[Mth.clamp((int) selected.applyAsDouble(NarutoShippudenModVariables.get(player)), 0, defs.length - 1)];
			NarutoShippudenModVariables.ifPresent(player, vars -> {
				vars.ChakraAmount -= def.rank().chakra;
				vars.syncPlayerVariables(player);
			});
			def.cast().accept(player);
		}, specs);
		requires(item, v -> v.MangekyouSharinganActivate && has.test(v), "Needs " + whose + "'s Mangekyou Sharingan, active");
	}

	private static void tell(ServerPlayer p, String message) {
		p.sendOverlayMessage(Component.literal(message));
	}

	private static ParticleOptions blackFire() {
		return AmaterasuFireParticle.particle != null ? AmaterasuFireParticle.particle : ParticleTypes.SOUL_FIRE_FLAME;
	}

	// ------------------------------------------------------------------ sharingan
	/** One look paralyses: the enemy stands frozen for three seconds, the tomoe spinning in front of their eyes. */
	private static void coercion(ServerPlayer p) {
		ServerLevel level = level(p);
		LivingEntity target = target(p, 16);
		if (target == null) {
			tell(p, "No one meets your gaze");
			return;
		}
		damage(p, target, 4, Element.GENJUTSU);
		sound(level, target.position(), SoundEvents.ENDERMAN_STARE, 1, 1.2F);
		channel(p, 60, 1, t -> {
			if (!target.isAlive())
				return;
			hold(target);
			double y = target.getEyeY() + 0.3;
			for (int i = 0; i < 3; i++) {
				double a = t * 0.35 + i * Math.PI * 2 / 3;
				level.sendParticles(Element.GENJUTSU.trail, target.getX() + Math.cos(a) * 0.6, y, target.getZ() + Math.sin(a) * 0.6, 1, 0, 0, 0, 0);
			}
			line(level, Element.GENJUTSU.trail, p.getEyePosition(), target.getEyePosition(), t % 10 == 0 ? 0.6 : 99);
		});
	}

	/** Freezes an entity in place (and stops a mob's plans). */
	private static void hold(LivingEntity target) {
		target.setDeltaMovement(0, Math.min(0, target.getDeltaMovement().y), 0);
		target.addEffect(new MobEffectInstance(MobEffects.SLOWNESS, 10, 9, false, false));
		if (target instanceof Mob mob) {
			mob.getNavigation().stop();
			mob.setTarget(null);
		}
	}

	/** A murder of crows bursts from the caster and swarms the enemy, blinding and pecking for four seconds. */
	private static void mirageCrow(ServerPlayer p) {
		ServerLevel level = level(p);
		LivingEntity target = target(p, 20);
		Vec3 centre = target != null ? target.position() : lookPoint(p, 20);
		List<CrowEntity.CustomEntity> crows = new ArrayList<>();
		for (int i = 0; i < 6; i++) {
			CrowEntity.CustomEntity crow = new CrowEntity.CustomEntity(CrowEntity.entity, level);
			Vec3 at = p.getEyePosition().add(turned(p, (i - 2.5F) * 25, 0).scale(1.2));
			crow.snapTo(at.x, at.y - 0.8, at.z, p.getYRot(), 0);
			crow.setNoAi(true);
			crow.setNoGravity(true);
			crow.setPermanentlyInvulnerable(true);
			crow.setSilent(true);
			level.addFreshEntity(crow);
			crows.add(crow);
		}
		level.sendParticles(ParticleTypes.LARGE_SMOKE, p.getX(), p.getEyeY(), p.getZ(), 20, 0.6, 0.4, 0.6, 0.02);
		sound(level, p.position(), SoundEvents.PHANTOM_FLAP, 1.5F, 1.3F);
		channel(p, 90, 1, t -> {
			Vec3 c = target != null && target.isAlive() ? target.position() : centre;
			for (int i = 0; i < crows.size(); i++) {
				CrowEntity.CustomEntity crow = crows.get(i);
				double a = t * 0.3 + i * Math.PI / 3, r = 1.3 + 0.3 * Math.sin(t * 0.2 + i);
				Vec3 to = c.add(Math.cos(a) * r, 0.8 + 0.6 * Math.sin(t * 0.25 + i * 2), Math.sin(a) * r);
				// fly in from the caster over the first ten ticks
				Vec3 at = t < 10 ? crow.position().lerp(to, 0.3) : to;
				crow.snapTo(at.x, at.y, at.z, (float) (Math.toDegrees(a) + 180), 0);
			}
			if (target != null && target.isAlive() && t >= 10) {
				target.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 30, 0, false, false));
				if (target instanceof Mob mob)
					mob.setTarget(null);
				if (t % 15 == 0) {
					damage(p, target, 2.5F, Element.GENJUTSU);
					level.sendParticles(ParticleTypes.CRIT, target.getX(), target.getY() + 1.2, target.getZ(), 6, 0.4, 0.5, 0.4, 0.1);
				}
			}
			if (t % 12 == 0)
				sound(level, c, SoundEvents.PHANTOM_FLAP, 1, 1.4F);
		});
		after(level, 90, () -> {
			for (CrowEntity.CustomEntity crow : crows) {
				level.sendParticles(ParticleTypes.LARGE_SMOKE, crow.getX(), crow.getY() + 0.5, crow.getZ(), 8, 0.2, 0.2, 0.2, 0.03);
				crow.discard();
			}
		});
	}

	/** Illusory stakes drive down into the enemy and pin them to the spot for five seconds. */
	private static void shacklingStakes(ServerPlayer p) {
		ServerLevel level = level(p);
		LivingEntity target = target(p, 20);
		Vec3 aim = target != null ? target.getBoundingBox().getCenter() : lookPoint(p, 20).add(0, 0.8, 0);
		for (int i = 0; i < 5; i++) {
			double a = i * Math.PI * 2 / 5;
			Vec3 from = aim.add(Math.cos(a) * 3, 5, Math.sin(a) * 3);
			JutsuProjectile stake = spawn(p, Element.GENJUTSU, Shape.NEEDLE, 0.7F, from, aim.subtract(from).normalize().scale(1.1), 5);
			stake.life = 20;
			stake.knockback = 0;
			stake.onHit = (s, hit) -> channel(p, 100, 1, t -> {
				if (!hit.isAlive())
					return;
				hold(hit);
				if (t % 4 == 0)
					level.sendParticles(Element.GENJUTSU.trail, hit.getX(), hit.getY() + 1, hit.getZ(), 4, 0.4, 0.6, 0.4, 0);
			});
		}
		sound(level, aim, SoundEvents.ENDERMAN_STARE, 1, 0.7F);
	}

	// ------------------------------------------------------------------ mangekyou: black flames
	/** Sets an entity alight with black flames that nothing puts out: they burn for as long as given. */
	private static void blackFlame(ServerPlayer p, LivingEntity target, int ticks) {
		ServerLevel level = level(p);
		float size = Math.max(target.getBbWidth(), target.getBbHeight()) + 0.5F;
		shell(p, target, target.getBoundingBox().getCenter(), Element.AMATERASU, size, ticks);
		channel(p, ticks, 2, t -> {
			if (!target.isAlive())
				return;
			AABB box = target.getBoundingBox();
			level.sendParticles(blackFire(), target.getX(), box.minY + box.getYsize() / 2, target.getZ(), 4, box.getXsize() / 2, box.getYsize() / 2,
					box.getZsize() / 2, 0.02);
			if (t % 10 == 0)
				damage(p, target, 2.5F, Element.AMATERASU);
		});
	}

	/** Black flames on the ground where nothing was looked at: anyone who walks in catches fire. */
	private static void blackFlameField(ServerPlayer p, Vec3 at, double radius, int ticks) {
		ServerLevel level = level(p);
		List<LivingEntity> lit = new ArrayList<>();
		channel(p, ticks, 2, t -> {
			level.sendParticles(blackFire(), at.x, at.y + 0.3, at.z, (int) (radius * 6), radius / 1.5, 0.2, radius / 1.5, 0.01);
			for (LivingEntity target : enemies(level, p, new AABB(at, at).inflate(radius, 2, radius), e -> !lit.contains(e))) {
				lit.add(target);
				blackFlame(p, target, 120);
			}
		});
	}

	/** Amaterasu: the one looked at bursts into black flame (or the spot looked at, if no one). */
	private static void amaterasu(ServerPlayer p) {
		ServerLevel level = level(p);
		LivingEntity target = target(p, 30);
		sound(level, p.getEyePosition(), SoundEvents.FIRECHARGE_USE, 1, 0.5F);
		// the price: the eye bleeds
		level.sendParticles(new net.minecraft.core.particles.DustParticleOptions(0x9A0000, 0.8F), p.getX(), p.getEyeY() - 0.1, p.getZ(), 4, 0.1, 0.05, 0.1, 0);
		if (target != null) {
			blackFlame(p, target, 160);
			level.sendParticles(blackFire(), target.getX(), target.getY() + 1, target.getZ(), 40, 0.5, 0.8, 0.5, 0.05);
		} else
			blackFlameField(p, lookPoint(p, 30), 2, 100);
	}

	/** Blaze Release: Kagutsuchi: the black flames shaped into a blade that sweeps in front of the caster. */
	private static void kagutsuchi(ServerPlayer p) {
		ServerLevel level = level(p);
		channel(p, 6, 1, t -> {
			double from = -60 + t * 24;
			for (double a = from; a < from + 24; a += 4) {
				Vec3 dir = turned(p, (float) a, 0);
				for (double d = 1; d <= 6; d += 0.8) {
					Vec3 at = p.getEyePosition().add(dir.scale(d)).subtract(0, 0.4, 0);
					level.sendParticles(blackFire(), at.x, at.y, at.z, 1, 0.05, 0.05, 0.05, 0.01);
				}
			}
		});
		for (LivingEntity target : cone(p, 6, 60)) {
			damage(p, target, 8, Element.AMATERASU);
			blackFlame(p, target, 100);
		}
		sound(level, p.position(), SoundEvents.PLAYER_ATTACK_SWEEP, 1.5F, 0.5F);
	}

	/** Blaze Release: Honoikazuchi: three arrows of black flame that seek, pierce and spread fire where they land. */
	private static void honoikazuchi(ServerPlayer p) {
		for (int i = -1; i <= 1; i++) {
			JutsuProjectile arrow = shoot(p, Element.AMATERASU, Shape.NEEDLE, 0.5F, turned(p, i * 8, -3).scale(1.8), 10);
			arrow.homing = 0.25F;
			arrow.life = 40;
			arrow.onHit = (a, target) -> blackFlame(p, target, 120);
			arrow.onImpact = a -> {
				burst(level(p), a.position(), 2.5F, 6, 0.6F, Element.AMATERASU, a);
				blackFlameField(p, a.position(), 1.5, 60);
			};
		}
		sound(level(p), p.getEyePosition(), SoundEvents.FIRECHARGE_USE, 1.5F, 0.4F);
	}

	/** Amaterasu: Flame Wrapping Fire: black flames wrap the caster for twenty seconds, burning whoever comes close. */
	private static void flameWrapping(ServerPlayer p) {
		ServerLevel level = level(p);
		Map<LivingEntity, Integer> lastLit = new HashMap<>();
		sound(level, p.position(), SoundEvents.FIRECHARGE_USE, 1.5F, 0.5F);
		mode(p, 400, 1, v -> {
		}, v -> {
		}, t -> {
			if (t % 10 == 0)
				keep(p, MobEffects.RESISTANCE, 1);
			p.clearFire();
			level.sendParticles(blackFire(), p.getX(), p.getY() + 1, p.getZ(), 3, 0.5, 0.8, 0.5, 0.02);
			for (LivingEntity target : enemies(level, p, p.getBoundingBox().inflate(2.5), e -> lastLit.getOrDefault(e, -99) + 40 <= t)) {
				lastLit.put(target, t);
				blackFlame(p, target, 80);
			}
		});
	}

	// ------------------------------------------------------------------ mangekyou: kamui
	private static final String KAMUI_RETURN = "naruto_shippuden:kamui_return";

	/**
	 * Kamui: space twists round the one looked at and swallows them into the Kamui dimension. Players come back after fifteen
	 * seconds; bosses are too big to take and are torn at instead.
	 */
	private static void kamui(ServerPlayer p, double range, int ticks) {
		ServerLevel level = level(p);
		LivingEntity target = target(p, range);
		if (target == null) {
			tell(p, "Nothing to take");
			return;
		}
		float size = Math.max(target.getBbWidth(), target.getBbHeight()) * 1.6F + 1;
		Vec3 centre = target.getBoundingBox().getCenter();
		wormhole(p, target, size, ticks + 6);
		sound(level, target.position(), SoundEvents.PORTAL_TRIGGER, 0.6F, 1.6F);
		channel(p, ticks, 2, t -> {
			if (!target.isAlive())
				return;
			hold(target);
			// sucked into the swirl: the target shrinks towards its centre
			EntityScale.set(target, EntityScale.BASE, Math.max(0.1, 1 - 0.9 * t / (double) ticks));
		});
		after(level, ticks, () -> {
			if (!target.isAlive())
				return;
			EntityScale.set(target, EntityScale.BASE, 1);
			level.sendParticles(ParticleTypes.REVERSE_PORTAL, centre.x, centre.y, centre.z, 40, 0.3, 0.6, 0.3, 0.2);
			sound(level, target.position(), SoundEvents.ENDERMAN_TELEPORT, 1.5F, 0.5F);
			boolean boss = target instanceof net.minecraft.world.entity.boss.enderdragon.EnderDragon
					|| target instanceof net.minecraft.world.entity.boss.wither.WitherBoss || target.getMaxHealth() > 300;
			if (boss) {
				damage(p, target, 40, Element.KAMUI);
				return;
			}
			if (level.dimension().identifier().getPath().equals("kamui_dimension")) {
				// already inside: Kamui throws them back out
				Compat.runCommand(target, "/execute in minecraft:overworld run tp ~ 100 ~");
				return;
			}
			if (target instanceof ServerPlayer victim) {
				net.minecraft.nbt.CompoundTag back = returnPoint(victim);
				Compat.runCommand(victim, "/execute in naruto_shippuden:kamui_dimension run tp @s ~ 71 ~");
				victim.sendOverlayMessage(Component.literal("You were taken into the Kamui dimension"));
				net.mcreator.narutoshippudenmod.core.NarutoActions.later(victim, 300, them -> {
					if (them.level().dimension().identifier().getPath().equals("kamui_dimension"))
						goBack(them, back);
				});
			} else
				Compat.runCommand(target, "/execute in naruto_shippuden:kamui_dimension run tp ~ 71 ~");
		});
	}

	private static net.minecraft.nbt.CompoundTag returnPoint(ServerPlayer p) {
		net.minecraft.nbt.CompoundTag back = new net.minecraft.nbt.CompoundTag();
		back.putString("dimension", p.level().dimension().identifier().toString());
		back.putDouble("x", p.getX());
		back.putDouble("y", p.getY());
		back.putDouble("z", p.getZ());
		return back;
	}

	private static void goBack(ServerPlayer p, net.minecraft.nbt.CompoundTag back) {
		String dimension = back.getStringOr("dimension", "minecraft:overworld");
		Compat.runCommand(p, String.format(java.util.Locale.ROOT, "/execute in %s run tp @s %.2f %.2f %.2f", dimension, back.getDoubleOr("x", p.getX()),
				back.getDoubleOr("y", 100), back.getDoubleOr("z", p.getZ())));
	}

	/** Kamui's swirling hole in space around an entity, following it. */
	private static void wormhole(ServerPlayer p, LivingEntity on, float size, int ticks) {
		JutsuProjectile hole = spawn(p, Element.KAMUI, Shape.VORTEX, size, on.getBoundingBox().getCenter().subtract(0, size / 2, 0), Vec3.ZERO, 0);
		hole.pierce = -1;
		hole.knockback = 0;
		hole.life = ticks;
		channel(p, ticks, 1, t -> {
			if (on.isAlive() && hole.isAlive())
				hole.setPos(on.getBoundingBox().getCenter().subtract(0, size / 2, 0));
		});
	}

	/** Kamui to the caster's own dimension, or back to where they left from. */
	private static void kamuiTeleport(ServerPlayer p) {
		ServerLevel level = level(p);
		wormhole(p, p, 3.4F, 18);
		sound(level, p.position(), SoundEvents.PORTAL_TRIGGER, 0.5F, 1.8F);
		// swirled away into the hole
		channel(p, 16, 2, t -> EntityScale.set(p, EntityScale.BASE, Math.max(0.1, 1 - t / 16.0)));
		boolean inKamui = level.dimension().identifier().getPath().equals("kamui_dimension");
		after(level, 16, () -> {
			EntityScale.set(p, EntityScale.BASE, 1);
			if (!p.isAlive())
				return;
			sound(level, p.position(), SoundEvents.ENDERMAN_TELEPORT, 1, 0.6F);
			if (inKamui)
				goBack(p, p.getPersistentData().getCompoundOrEmpty(KAMUI_RETURN));
			else {
				p.getPersistentData().put(KAMUI_RETURN, returnPoint(p));
				Compat.runCommand(p, "/execute in naruto_shippuden:kamui_dimension run tp @s ~ 71 ~");
			}
		});
	}

	private static final Map<UUID, Long> PHASING = new HashMap<>();

	/**
	 * Five seconds partly in the Kamui dimension: attacks and projectiles pass through, enemies lose track of the caster, and the
	 * caster walks through walls (see {@link #phaseThroughWalls}).
	 */
	private static void phantomPhasing(ServerPlayer p) {
		ServerLevel level = level(p);
		PHASING.put(p.getUUID(), level.getGameTime() + 100);
		flag(p, 100, v -> v.KamuiPhantomPhase = true, v -> v.KamuiPhantomPhase = false);
		wormhole(p, p, 2.6F, 100);
		sound(level, p.position(), SoundEvents.PORTAL_TRIGGER, 0.5F, 1.8F);
		channel(p, 100, 2, t -> {
			level.sendParticles(ParticleTypes.PORTAL, p.getX(), p.getY() + 1, p.getZ(), 4, 0.4, 0.8, 0.4, 0.3);
			for (Mob mob : level.getEntitiesOfClass(Mob.class, p.getBoundingBox().inflate(24), m -> m.getTarget() == p))
				mob.setTarget(null);
		});
		after(level, 102, () -> {
			// never leave the caster stuck inside a wall
			p.noPhysics = false;
			for (int i = 0; i < 12 && p.isAlive() && !level.noCollision(p); i++)
				p.teleportTo(p.getX(), p.getY() + 1, p.getZ());
		});
	}

	/**
	 * While phasing, blocks don't stop the caster. Vanilla turns collisions back on at the start of every player tick, so the
	 * client (which moves the player) turns them off again once the input is read (client/jutsu/KamuiClient), and the server
	 * leaves them off after its tick, which is when it checks the moves the client sends.
	 */
	@SubscribeEvent
	public static void phaseThroughWalls(net.neoforged.neoforge.event.tick.PlayerTickEvent.Post event) {
		if (!(event.getEntity() instanceof ServerPlayer player))
			return;
		if (!NarutoShippudenModVariables.get(player).KamuiPhantomPhase) {
			if (player.getPersistentData().getBooleanOr(PHASED, false)) {
				player.noPhysics = player.isSpectator();
				player.getPersistentData().remove(PHASED);
			}
			return;
		}
		player.getPersistentData().putBoolean(PHASED, true);
		player.noPhysics = true;
		player.fallDistance = 0;
	}

	private static final String PHASED = "naruto_shippuden:phased";

	@SubscribeEvent
	public static void phasedProjectile(net.neoforged.neoforge.event.entity.ProjectileImpactEvent event) {
		if (event.getRayTraceResult() instanceof net.minecraft.world.phys.EntityHitResult hit && isPhasing(hit.getEntity()))
			event.setCanceled(true);
	}

	private static boolean isPhasing(net.minecraft.world.entity.Entity entity) {
		Long until = PHASING.get(entity.getUUID());
		return until != null && entity.level().getGameTime() <= until;
	}

	@SubscribeEvent
	public static void phased(LivingIncomingDamageEvent event) {
		Long until = PHASING.get(event.getEntity().getUUID());
		if (until == null)
			return;
		if (event.getEntity().level().getGameTime() > until) {
			PHASING.remove(event.getEntity().getUUID());
			return;
		}
		if (!event.getSource().is(net.minecraft.tags.DamageTypeTags.BYPASSES_INVULNERABILITY)) {
			event.setCanceled(true);
			if (event.getEntity().level() instanceof ServerLevel level)
				level.sendParticles(ParticleTypes.REVERSE_PORTAL, event.getEntity().getX(), event.getEntity().getY() + 1, event.getEntity().getZ(), 10, 0.3,
						0.5, 0.3, 0.1);
		}
	}

	// ------------------------------------------------------------------ kokugan
	/** A black rod that appears tiny and snaps to full size (Sukunahikona undone), pointed along the given direction. */
	private static JutsuProjectile rod(ServerPlayer p, Vec3 at, Vec3 velocity, Vec3 facing, float size, float damage, int growAfter) {
		JutsuProjectile rod = spawn(p, Element.KOKUGAN, Shape.ROD, 0.12F, at, velocity, damage);
		rod.setYRot((float) (Mth.atan2(facing.x, facing.z) * Mth.RAD_TO_DEG));
		rod.setXRot((float) (Mth.atan2(facing.y, facing.horizontalDistance()) * Mth.RAD_TO_DEG));
		rod.knockback = 0.3F;
		after(level(p), growAfter, () -> {
			if (rod.isAlive()) {
				rod.look(Element.KOKUGAN, Shape.ROD, size);
				level(p).sendParticles(Element.KOKUGAN.puff, rod.getX(), rod.getY() + size / 2, rod.getZ(), 6, 0.2, 0.2, 0.2, 0.02);
			}
		});
		return rod;
	}

	/** Sukunahikona: the caster shrinks to a speck for three seconds; attacks miss them and enemies lose sight of them. */
	private static void sukunahikona(ServerPlayer p) {
		ServerLevel level = level(p);
		level.sendParticles(Element.KOKUGAN.trail, p.getX(), p.getY() + 1, p.getZ(), 20, 0.3, 0.6, 0.3, 0.05);
		sound(level, p.position(), SoundEvents.ILLUSIONER_MIRROR_MOVE, 1, 1.6F);
		PHASING.put(p.getUUID(), level.getGameTime() + 60);
		mode(p, 60, 0.12F, v -> {
		}, v -> {
		}, t -> {
			if (t % 10 == 0)
				keep(p, MobEffects.SPEED, 2);
			for (Mob mob : level.getEntitiesOfClass(Mob.class, p.getBoundingBox().inflate(24), m -> m.getTarget() == p))
				mob.setTarget(null);
			if (t == 59)
				level.sendParticles(Element.KOKUGAN.trail, p.getX(), p.getY() + 1, p.getZ(), 20, 0.3, 0.6, 0.3, 0.05);
		});
	}

	/** Sukunahikona: Rapid Succession: shrunken rods flicked out that snap to full size in flight. */
	private static void rapidSuccession(ServerPlayer p) {
		channel(p, 10, 2, t -> {
			Vec3 dir = turned(p, (p.getRandom().nextFloat() - 0.5F) * 6, (p.getRandom().nextFloat() - 0.5F) * 4);
			JutsuProjectile rod = rod(p, p.getEyePosition().add(dir.scale(0.8)).subtract(0, 0.2, 0), dir.scale(2.4), dir, 0.9F, 6, 3);
			rod.life = 25;
			rod.pierce = 1;
			sound(level(p), p.getEyePosition(), SoundEvents.ILLUSIONER_MIRROR_MOVE, 0.6F, 1.8F);
		});
	}

	/** Lacquer Bloom: shrunken rods under the enemy burst to full size, impaling and pinning them for three seconds. */
	private static void lacquerBloom(ServerPlayer p) {
		ServerLevel level = level(p);
		LivingEntity target = target(p, 24);
		Vec3 feet = target != null ? target.position() : lookPoint(p, 24);
		Vec3 centre = target != null ? target.getBoundingBox().getCenter() : feet.add(0, 1, 0);
		for (int i = 0; i < 6; i++) {
			double a = i * Math.PI / 3 + 0.3;
			Vec3 base = feet.add(Math.cos(a) * 1.6, 0, Math.sin(a) * 1.6), toward = centre.subtract(base).normalize();
			JutsuProjectile rod = rod(p, base.add(toward.scale(0.9)).subtract(0, 0.8, 0), Vec3.ZERO, toward, 1.6F, 0, 4 + i);
			rod.life = 70;
			rod.pierce = -1;
			rod.knockback = 0;
		}
		sound(level, feet, SoundEvents.ILLUSIONER_MIRROR_MOVE, 1.5F, 1.2F);
		after(level, 6, () -> {
			sound(level, feet, SoundEvents.TRIDENT_HIT, 1.5F, 0.6F);
			for (LivingEntity hit : enemies(level, p, new AABB(feet, feet).inflate(2.2, 3, 2.2), e -> true)) {
				damage(p, hit, 14, Element.KOKUGAN);
				channel(p, 60, 1, t -> {
					if (hit.isAlive())
						hold(hit);
				});
			}
		});
	}

	/** Black Holy Hammer: one enormous rod drops from above and nails the enemy to the ground. */
	private static void blackHolyHammer(ServerPlayer p) {
		ServerLevel level = level(p);
		LivingEntity target = target(p, 28);
		Vec3 at = target != null ? target.position() : lookPoint(p, 28);
		JutsuProjectile hammer = rod(p, at.add(0, 10, 0), new Vec3(0, -1.6, 0), new Vec3(0, -1, 0), 3.2F, 22, 1);
		hammer.life = 20;
		hammer.pierce = -1;
		hammer.knockback = 0;
		hammer.onHit = (h, hit) -> channel(p, 80, 1, t -> {
			if (hit.isAlive())
				hold(hit);
		});
		hammer.onImpact = h -> {
			burst(level, h.position(), 3, 8, 0.5F, Element.KOKUGAN, h);
			puff(level, h.position(), Element.EARTH, 2.5F);
			sound(level, h.position(), SoundEvents.ANVIL_LAND, 1.5F, 0.5F);
		};
		sound(level, at, SoundEvents.ILLUSIONER_MIRROR_MOVE, 1.5F, 0.6F);
	}

	/** A Daikokuten cube dropped from above; after landing it stays a moment before it is taken back. */
	private static void cube(ServerPlayer p, Vec3 over, float size, float damage) {
		ServerLevel level = level(p);
		JutsuProjectile cube = spawn(p, Element.KOKUGAN, Shape.DAIKOKUTEN, size, over, new Vec3(0, -1.3, 0), damage);
		cube.setYRot(p.getRandom().nextFloat() * 90);
		cube.pierce = -1;
		cube.life = 40;
		cube.knockback = 0;
		cube.onImpact = c -> {
			burst(level, c.position(), size + 1, damage * 0.6F, 1.2F, Element.KOKUGAN, c);
			puff(level, c.position(), Element.EARTH, size + 1);
			sound(level, c.position(), SoundEvents.ANVIL_LAND, 2, 0.4F);
			JutsuProjectile resting = spawn(p, Element.KOKUGAN, Shape.DAIKOKUTEN, size, c.position(), Vec3.ZERO, 0);
			resting.setYRot(c.getYRot());
			resting.pierce = -1;
			resting.knockback = 0;
			resting.life = 60;
			resting.onImpact = r -> level.sendParticles(Element.KOKUGAN.puff, r.getX(), r.getY() + size / 2, r.getZ(), 30, size / 2, size / 2, size / 2, 0.02);
		};
		level.sendParticles(Element.KOKUGAN.puff, over.x, over.y + size / 2, over.z, 30, size / 2, size / 2, size / 2, 0.02);
	}

	/** Daikokuten: Daihakoten: a huge black cube, taken out of a dimension where time does not flow, drops onto the enemy. */
	private static void daihakoten(ServerPlayer p) {
		LivingEntity target = target(p, 30);
		Vec3 at = target != null ? target.position() : lookPoint(p, 30);
		cube(p, at.add(0, 12, 0), 3.5F, 28);
		sound(level(p), at, SoundEvents.ILLUSIONER_MIRROR_MOVE, 2, 0.5F);
	}

	/** Daikokuten: Falling Star: a rain of cubes over the area looked at. */
	private static void fallingStar(ServerPlayer p) {
		Vec3 at = lookPoint(p, 30);
		sound(level(p), at, SoundEvents.ILLUSIONER_MIRROR_MOVE, 2, 0.4F);
		channel(p, 32, 4, t -> {
			double a = p.getRandom().nextDouble() * Math.PI * 2, r = p.getRandom().nextDouble() * 6;
			cube(p, at.add(Math.cos(a) * r, 14 + p.getRandom().nextDouble() * 4, Math.sin(a) * r), 2.4F + p.getRandom().nextFloat(), 18);
		});
	}
}
