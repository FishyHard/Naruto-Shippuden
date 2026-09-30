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
				new Def("Genjutsu: Sharingan", JutsuRank.D, DojutsuJutsu::genjutsuSharingan),
				new Def("Coercion Sharingan", JutsuRank.C, DojutsuJutsu::coercion),
				new Def("Demonic Illusion: Mirage Crow", JutsuRank.B, DojutsuJutsu::mirageCrow),
				new Def("Demonic Illusion: Shackling Stakes Technique", JutsuRank.A, DojutsuJutsu::shacklingStakes),
				new Def("Izanagi", JutsuRank.S, DojutsuJutsu::izanagi),
				new Def("Izanami", JutsuRank.S, DojutsuJutsu::izanami));
		requires("sharingan_release_technique", v -> v.sharingan && v.sharinganactivate, "Activate your Sharingan first");
		// the Kokugan (the items keep their old "isshiki_dojutsu" ids)
		nature("isshiki_dojutsu", "the Kokugan", v -> v.isshikidojutsu, v -> v.isshikidojutsutechnique, (v, i) -> v.isshikidojutsutechnique = i,
				v -> v.isshikidojutsulearn, (v, i) -> v.isshikidojutsulearn = i, v -> v.isshikidojutsurelease, (v, i) -> v.isshikidojutsurelease = i,
				new Def("Sukunahikona", JutsuRank.B, DojutsuJutsu::sukunahikona),
				new Def("Sukunahikona: Rapid Succession", JutsuRank.B, DojutsuJutsu::rapidSuccession),
				new Def("Lacquer Bloom", JutsuRank.A, DojutsuJutsu::lacquerBloom),
				new Def("Black Holy Hammer", JutsuRank.A, DojutsuJutsu::blackHolyHammer),
				new Def("Daihakoten", JutsuRank.A, DojutsuJutsu::daihakoten),
				new Def("Daikokuten: Falling Star", JutsuRank.S, DojutsuJutsu::fallingStar));
		requires("isshiki_dojutsu_release_technique", v -> v.isshikidojutsu && v.isshikidojutsuactivate, "Activate the Kokugan first");
		nature("byakugan", "the Byakugan", v -> v.byakugan, v -> v.byakugantechnique, (v, i) -> v.byakugantechnique = i, v -> v.byakuganlearn,
				(v, i) -> v.byakuganlearn = i, v -> v.byakuganrelease, (v, i) -> v.byakuganrelease = i,
				new Def("Palm Bottom", JutsuRank.D, DojutsuJutsu::palmBottom, "Taijutsu"),
				new Def("Eight Trigrams Vacuum Palm", JutsuRank.C, DojutsuJutsu::vacuumPalm),
				new Def("Eight Trigrams Vacuum Wall Palm", JutsuRank.B, DojutsuJutsu::vacuumWallPalm),
				new Def("Rabbit Hair Needle", JutsuRank.A, DojutsuJutsu::rabbitHairNeedle),
				new Def("Eight Trigrams One Hundred Twenty-Eight Palms", JutsuRank.S, DojutsuJutsu::hundredTwentyEightPalms, "Taijutsu"));
		requires("byakugan_release_technique", v -> v.byakugan && v.byakuganactivate, "Activate your Byakugan first");
		nature("ketsuryugan", "the Ketsuryugan", v -> v.ketsuryugan, v -> v.ketsuryugantechnique, (v, i) -> v.ketsuryugantechnique = i, v -> v.ketsuryuganlearn,
				(v, i) -> v.ketsuryuganlearn = i, v -> v.ketsuryuganrelease, (v, i) -> v.ketsuryuganrelease = i,
				new Def("Genjutsu: Ketsuryugan", JutsuRank.C, DojutsuJutsu::ketsuryuganGenjutsu),
				new Def("Blood Transformation Technique", JutsuRank.B, DojutsuJutsu::bloodTransformation),
				new Def("Blood Dragon Ascension", JutsuRank.A, DojutsuJutsu::bloodDragon),
				new Def("Exploding Human Technique", JutsuRank.S, DojutsuJutsu::explodingHuman));
		requires("ketsuryugan_release_technique", v -> v.ketsuryugan && v.ketsuryuganactivate, "Activate your Ketsuryugan first");
		nature("rinnegan", "the Rinnegan", v -> v.rinnegan, v -> v.rinnegantechnique, (v, i) -> v.rinnegantechnique = i, v -> v.rinneganlearn,
				(v, i) -> v.rinneganlearn = i, v -> v.rinneganrelease, (v, i) -> v.rinneganrelease = i,
				new Def("Bansho Ten'in", JutsuRank.C, DojutsuJutsu::banshoTenin),
				new Def("Shinra Tensei", JutsuRank.B, DojutsuJutsu::shinraTensei),
				new Def("Asura Attack", JutsuRank.B, DojutsuJutsu::asuraAttack),
				new Def("Blocking Technique Absorption Seal", JutsuRank.B, DojutsuJutsu::absorptionSeal),
				new Def("Human Path", JutsuRank.A, DojutsuJutsu::humanPath),
				new Def("Amenotejikara", JutsuRank.A, DojutsuJutsu::amenotejikara),
				new Def("Chibaku Tensei", JutsuRank.S, DojutsuJutsu::chibakuTensei),
				new Def("Tengai Shinsei", JutsuRank.S, DojutsuJutsu::tengaiShinsei));
		requires("rinnegan_release_technique", v -> v.rinnegan && v.rinneganactivate, "Activate your Rinnegan first");
		nature("tenseigan", "the Tenseigan", v -> v.tenseigan, v -> v.tenseigantechnique, (v, i) -> v.tenseigantechnique = i, v -> v.tenseiganlearn,
				(v, i) -> v.tenseiganlearn = i, v -> v.tenseiganrelease, (v, i) -> v.tenseiganrelease = i,
				new Def("Silver Wheel Reincarnation Explosion", JutsuRank.B, DojutsuJutsu::silverWheel),
				new Def("Golden Wheel Reincarnation Explosion", JutsuRank.A, DojutsuJutsu::goldenWheel),
				new Def("Localised Reincarnation Explosion", JutsuRank.A, DojutsuJutsu::localisedExplosion),
				new Def("Tenseigan Chakra Mode", JutsuRank.S, DojutsuJutsu::tenseiganMode));
		requires("tenseigan_release_technique", v -> v.tenseigan && v.tenseiganactivate, "Activate your Tenseigan first");

		// the Mangekyou: only the jutsu (their scrolls also sell the Susanoo stages)
		mangekyou("mangekyou_sharingan_itachi_release_technique", "Itachi", v -> v.MangekyouSharinganItachi, v -> v.mangekyousharinganitachitechnique,
				(v, i) -> v.mangekyousharinganitachitechnique = i, v -> v.mangekyoushrainganitachiamaterasulearn,
				new Def("Amaterasu", JutsuRank.A, DojutsuJutsu::amaterasu),
				new Def("Tsukuyomi", JutsuRank.S, DojutsuJutsu::tsukuyomi));
		mangekyouScroll("itachi", net.mcreator.narutoshippudenmod.procedures.DojutsuProcedures.MangekyouSharinganItachiReleaseRightclickedProcedure::executeProcedure,
				v -> v.mangekyoushrainganitachiamaterasulearn, (v, i) -> v.mangekyoushrainganitachiamaterasulearn = i, new JutsuRank[] { JutsuRank.A, JutsuRank.S },
				susanoo(v -> v.mangekyoushrainganitachisusanorelease, v -> v.mangekyoushrainganitachisusanolearn, 3));
		mangekyou("mangekyou_sharingan_kakashi_release_technique", "Kakashi", v -> v.MangekyouSharinganKakashi, v -> v.mangekyousharingankakashitechnique,
				(v, i) -> v.mangekyousharingankakashitechnique = i, v -> v.mangekyousharingankakashikamuilearn,
				new Def("Kamui Long-Range", JutsuRank.A, p -> kamui(p, 30, 30)),
				new Def("Kamui Lightning Cutter", JutsuRank.A, DojutsuJutsu::kamuiLightningCutter),
				new Def("Kamui Shuriken", JutsuRank.S, DojutsuJutsu::kamuiShuriken));
		mangekyouScroll("kakashi", deps -> {
		}, v -> v.mangekyousharingankakashikamuilearn, (v, i) -> v.mangekyousharingankakashikamuilearn = i,
				new JutsuRank[] { JutsuRank.A, JutsuRank.A, JutsuRank.S }, null);
		mangekyou("mangekyou_sharingan_shisui_release_technique", "Shisui", v -> v.MangekyouSharinganShisui, v -> v.mangekyousharinganshisuitechnique,
				(v, i) -> v.mangekyousharinganshisuitechnique = i, v -> v.mangekyousharinganshisuilearn,
				new Def("Kotoamatsukami", JutsuRank.S, DojutsuJutsu::kotoamatsukami));
		mangekyouScroll("shisui", net.mcreator.narutoshippudenmod.procedures.DojutsuProcedures.MangekyouSharinganShisuiReleaseRightclickedProcedure::executeProcedure,
				v -> v.mangekyousharinganshisuilearn, (v, i) -> v.mangekyousharinganshisuilearn = i, new JutsuRank[] { JutsuRank.S },
				susanoo(v -> v.mangekyousharinganshisuisusanorelease, v -> v.mangekyousharinganshisuisusanolearn, 4));
		mangekyou("mangekyou_sharingan_madara_release_technique", "Madara", v -> v.MangekyouSharinganMadara, v -> v.mangekyousharinganmadaratechnique,
				(v, i) -> v.mangekyousharinganmadaratechnique = i, v -> v.mangekyousharinganmadaralearn,
				new Def("Genjutsu: Sharingan", JutsuRank.A, DojutsuJutsu::madaraGenjutsu),
				new Def("Susanoo: Fist", JutsuRank.S, DojutsuJutsu::susanooFist));
		mangekyouScroll("madara", net.mcreator.narutoshippudenmod.procedures.DojutsuProcedures.MangekyouSharinganMadaraReleaseRightclickedProcedure::executeProcedure,
				v -> v.mangekyousharinganmadaralearn, (v, i) -> v.mangekyousharinganmadaralearn = i, new JutsuRank[] { JutsuRank.A, JutsuRank.S },
				susanoo(v -> v.mangekyousharinganmadarasusanorelease, v -> v.mangekyousharinganmadarasusanolearn, 4));
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
			Def def = defs[Jutsus.index(selected.applyAsDouble(NarutoShippudenModVariables.get(player)), defs.length)];
			NarutoShippudenModVariables.ifPresent(player, vars -> {
				vars.ChakraAmount -= def.rank().chakra;
				vars.syncPlayerVariables(player);
			});
			def.cast().accept(player);
			if (Jutsus.missed)
				NarutoShippudenModVariables.ifPresent(player, vars -> {
					vars.ChakraAmount += def.rank().chakra;
					vars.syncPlayerVariables(player);
				});
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
			Jutsus.miss(p, "No one meets your gaze");
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
			Jutsus.miss(p, "Nothing to take");
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

	// ------------------------------------------------------------------ mangekyou scrolls
	/**
	 * A Mangekyou scroll whose jutsu track is bought here (the old procedures only knew each eye's first jutsu); its Susanoo track, if
	 * it has one, is still bought by the old procedure.
	 */
	private static void mangekyouScroll(String eye, java.util.function.Consumer<Map<String, Object>> oldBuy, ToDoubleFunction<PlayerVariables> learned,
			ObjDoubleConsumer<PlayerVariables> setLearned, JutsuRank[] ranks, Jutsus.@org.jspecify.annotations.Nullable Track susanoo) {
		String item = "mangekyou_sharingan_" + eye + "_release", technique = item + "_technique";
		Jutsus.Tier[] tiers = new Jutsus.Tier[ranks.length];
		for (int i = 0; i < ranks.length; i++)
			tiers[i] = Jutsus.tier(ranks[i].jp, i + 1, i == 0 ? technique : null);
		Jutsus.Track jutsu = Jutsus.track("", learned, susanoo == null ? -1 : 0, technique, learned, tiers);
		Jutsus.release(item, deps -> {
			if (!(deps.get("entity") instanceof ServerPlayer player))
				return;
			PlayerVariables v = NarutoShippudenModVariables.get(player);
			if (susanoo != null && v.MangekyouSharinganRelease != 0) {
				oldBuy.accept(deps);
				return;
			}
			int next = (int) learned.applyAsDouble(v);
			if (next >= ranks.length || v.jp < ranks[next].jp)
				return;
			NarutoShippudenModVariables.ifPresent(player, vars -> {
				vars.jp -= ranks[next].jp;
				setLearned.accept(vars, next + 1);
				vars.syncPlayerVariables(player);
			});
			if (next == 0)
				Compat.giveItemToPlayer(player,
						new net.minecraft.world.item.ItemStack(net.minecraft.core.registries.BuiltInRegistries.ITEM.getValue(Identifier.fromNamespaceAndPath("naruto_shippuden", technique))));
		}, susanoo == null ? new Jutsus.Track[] { jutsu } : new Jutsus.Track[] { jutsu, susanoo });
	}

	private static Jutsus.Track susanoo(ToDoubleFunction<PlayerVariables> bought, ToDoubleFunction<PlayerVariables> learned, int stages) {
		Jutsus.Tier[] tiers = new Jutsus.Tier[stages];
		for (int i = 0; i < stages; i++)
			tiers[i] = Jutsus.tier(10 * (i + 1), i + 1, null);
		return Jutsus.track("Susanoo", bought, 1, null, learned, tiers);
	}

	// ------------------------------------------------------------------ sharingan (added from the wiki)
	/** Genjutsu: Sharingan: one look and the enemy's senses are thrown off for five seconds: they reel and strike at anything. */
	private static void genjutsuSharingan(ServerPlayer p) {
		ServerLevel level = level(p);
		LivingEntity target = target(p, 12);
		if (target == null) {
			Jutsus.miss(p, "No one meets your gaze");
			return;
		}
		damage(p, target, 2, Element.GENJUTSU);
		sound(level, target.position(), SoundEvents.ENDERMAN_STARE, 0.8F, 1.5F);
		channel(p, 100, 5, t -> {
			if (!target.isAlive())
				return;
			target.addEffect(new MobEffectInstance(MobEffects.SLOWNESS, 10, 1, false, false));
			target.addEffect(new MobEffectInstance(MobEffects.DARKNESS, 30, 0, false, false));
			if (target instanceof Mob mob && t % 20 == 0)
				mob.setTarget(level.getEntitiesOfClass(LivingEntity.class, mob.getBoundingBox().inflate(10), x -> x != mob && x != p && x.isAlive()).stream().findAny()
						.orElse(null));
			level.sendParticles(Element.GENJUTSU.trail, target.getX(), target.getEyeY() + 0.3, target.getZ(), 2, 0.3, 0.1, 0.3, 0);
		});
	}

	/** Until when each caster's reality is being rewritten (Izanagi). */
	private static final Map<UUID, Long> IZANAGI = new HashMap<>();

	/**
	 * Izanagi: for ten seconds the caster rewrites reality: every wound they take is undone as if it never happened. When it ends,
	 * the eye that cast it goes dark: the Sharingan closes.
	 */
	private static void izanagi(ServerPlayer p) {
		ServerLevel level = level(p);
		IZANAGI.put(p.getUUID(), level.getGameTime() + 200);
		sound(level, p.position(), SoundEvents.ENDERMAN_STARE, 1.2F, 0.6F);
		channel(p, 200, 4, t -> level.sendParticles(Element.GENJUTSU.trail, p.getX(), p.getY() + 1, p.getZ(), 2, 0.4, 0.7, 0.4, 0));
		after(level, 200, () -> {
			if (!p.isAlive())
				return;
			net.mcreator.narutoshippudenmod.core.Eyes.closeAll(p);
			p.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 100, 0, false, false));
			tell(p, "Izanagi ends; the eye that cast it goes dark");
		});
	}

	@SubscribeEvent
	public static void rewrittenReality(LivingIncomingDamageEvent event) {
		if (!(event.getEntity() instanceof ServerPlayer p) || IZANAGI.getOrDefault(p.getUUID(), 0L) <= p.level().getGameTime()
				|| event.getSource().is(net.minecraft.tags.DamageTypeTags.BYPASSES_INVULNERABILITY))
			return;
		event.setCanceled(true);
		level(p).sendParticles(Element.GENJUTSU.puff, p.getX(), p.getY() + 1, p.getZ(), 12, 0.4, 0.7, 0.4, 0.05);
	}

	/**
	 * Izanami: the enemy looked at is caught in a loop. For eight seconds they live the same moment again and again: every two
	 * seconds they are sent back to the place and facing they had when the caster's eye met theirs, forget what they were doing, and
	 * (a player) can do nothing in between. Like Izanagi, it costs the eye: the Sharingan closes when the loop ends.
	 */
	private static void izanami(ServerPlayer p) {
		ServerLevel level = level(p);
		LivingEntity target = target(p, 12);
		if (target == null) {
			Jutsus.miss(p, "No one meets your gaze");
			return;
		}
		Vec3 spot = target.position();
		float yaw = target.getYRot(), pitch = target.getXRot();
		sound(level, target.position(), SoundEvents.ENDERMAN_STARE, 1.2F, 0.5F);
		channel(p, 160, 1, t -> {
			if (!target.isAlive())
				return;
			target.addEffect(new MobEffectInstance(MobEffects.DARKNESS, 30, 0, false, false));
			if (target instanceof ServerPlayer victim)
				ClanJutsu.restrain(victim, t < 159);
			if (t % 40 != 39)
				return;
			if (target instanceof ServerPlayer victim)
				victim.sendOverlayMessage(Component.literal("The same moment, again..."));
			if (target instanceof ServerPlayer victim)
				victim.teleportTo(level, spot.x, spot.y, spot.z, java.util.Set.of(), yaw, pitch, false);
			else {
				target.teleportTo(spot.x, spot.y, spot.z);
				target.setYRot(yaw);
				if (target instanceof Mob mob)
					mob.setTarget(null);
			}
			damage(p, target, 4, Element.GENJUTSU);
			level.sendParticles(Element.GENJUTSU.puff, spot.x, spot.y + 1, spot.z, 20, 0.4, 0.7, 0.4, 0.05);
			sound(level, spot, SoundEvents.ILLUSIONER_MIRROR_MOVE, 1, 0.6F);
		});
		after(level, 160, () -> {
			if (target instanceof ServerPlayer victim)
				ClanJutsu.restrain(victim, false);
			if (p.isAlive()) {
				net.mcreator.narutoshippudenmod.core.Eyes.closeAll(p);
				tell(p, "Izanami ends; the eye that cast it goes dark");
			}
		});
	}

	// ------------------------------------------------------------------ byakugan
	/** Palm Bottom: a sharp palm strike that knocks the enemy back. */
	private static void palmBottom(ServerPlayer p) {
		ServerLevel level = level(p);
		Vec3 look = p.getLookAngle();
		for (LivingEntity target : cone(p, 3.8, 30)) {
			damage(p, target, 7, Element.CHAKRA);
			target.push(look.x * 2, 0.4, look.z * 2);
			target.syncVelocity = true;
		}
		Vec3 palm = p.getEyePosition().add(look.scale(1.5)).subtract(0, 0.3, 0);
		level.sendParticles(ParticleTypes.END_ROD, palm.x, palm.y, palm.z, 8, 0.15, 0.15, 0.15, 0.1);
		sound(level, p.position(), SoundEvents.PLAYER_ATTACK_STRONG, 1, 1.4F);
	}

	/** Eight Trigrams Vacuum Palm: a blast of chakra from the palm strikes an enemy from afar. */
	private static void vacuumPalm(ServerPlayer p) {
		JutsuProjectile palm = shoot(p, Element.CHAKRA, Shape.ORB, 0.7F, 2.2F, 10);
		palm.life = 20;
		palm.knockback = 2.2F;
		palm.onImpact = b -> puff(level(p), b.position(), Element.CHAKRA, 0.8F);
		sound(level(p), p.getEyePosition(), SoundEvents.BREEZE_SHOOT, 1.2F, 1.2F);
	}

	/** Eight Trigrams Vacuum Wall Palm: a wall of chakra pressure hurled from both palms that flattens everything in front. */
	private static void vacuumWallPalm(ServerPlayer p) {
		ServerLevel level = level(p);
		Vec3 look = p.getLookAngle();
		for (LivingEntity target : cone(p, 11, 45)) {
			damage(p, target, 13, Element.CHAKRA);
			target.push(look.x * 3, 0.5, look.z * 3);
			target.syncVelocity = true;
		}
		for (int i = 1; i <= 10; i += 2) {
			Vec3 at = p.getEyePosition().add(look.scale(i));
			level.sendParticles(Element.CHAKRA.trail, at.x, at.y, at.z, 12, i * 0.15, i * 0.12, i * 0.15, 0);
		}
		sound(level, p.getEyePosition(), SoundEvents.BREEZE_WIND_CHARGE_BURST.value(), 1.5F, 0.9F);
	}

	/** Rabbit Hair Needle: a volley of chakra-hardened needles that seek out enemies. */
	private static void rabbitHairNeedle(ServerPlayer p) {
		for (int i = 0; i < 8; i++) {
			JutsuProjectile needle = shoot(p, Element.CHAKRA, Shape.NEEDLE, 0.25F, turned(p, (i - 3.5F) * 7, -4).scale(1.8), 5);
			needle.homing = 0.3F;
			needle.life = 35;
			needle.knockback = 0.1F;
		}
		sound(level(p), p.getEyePosition(), SoundEvents.TRIDENT_THROW.value(), 1, 1.8F);
	}

	private static final String[] PALMS = { "Two palms!", "Four palms!", "Eight palms!", "Sixteen palms!", "Thirty-two palms!", "Sixty-four palms!",
			"One hundred twenty-eight palms!" };

	/** Eight Trigrams One Hundred Twenty-Eight Palms: twice the sixty-four, faster, with a final blow that sends everyone flying. */
	private static void hundredTwentyEightPalms(ServerPlayer p) {
		ServerLevel level = level(p);
		Vec3 feet = p.position();
		channel(p, 64, 1, t -> {
			p.setDeltaMovement(0, Math.min(0, p.getDeltaMovement().y), 0);
			p.syncVelocity = true;
			if (t % 4 == 0)
				for (int i = 0; i < 40; i++) {
					double a = i * Math.PI / 20;
					level.sendParticles(Element.CHAKRA.trail, feet.x + Math.cos(a) * 3.5, feet.y + 0.1, feet.z + Math.sin(a) * 3.5, 1, 0, 0, 0, 0);
				}
			if (Integer.bitCount(t + 1) == 1 || t == 63)
				tell(p, PALMS[Math.min(6, Integer.numberOfTrailingZeros(Integer.highestOneBit(t + 1)))]);
			for (LivingEntity target : cone(p, 4.5, 50)) {
				target.setDeltaMovement(0, Math.min(0, target.getDeltaMovement().y), 0);
				damage(p, target, 0.6F, Element.CHAKRA);
				if (t == 63) {
					Vec3 away = target.position().subtract(p.position()).multiply(1, 0, 1).normalize();
					damage(p, target, 16, Element.CHAKRA);
					target.push(away.x * 2.5, 0.7, away.z * 2.5);
					target.syncVelocity = true;
				}
			}
			if (t % 2 == 0)
				sound(level, p.position(), SoundEvents.PLAYER_ATTACK_WEAK, 0.7F, 1.3F + t * 0.01F);
		});
	}

	// ------------------------------------------------------------------ ketsuryugan
	/** Genjutsu: Ketsuryugan: the blood-red eyes hypnotise the enemy looked at for six seconds: they stand still, their will gone. */
	private static void ketsuryuganGenjutsu(ServerPlayer p) {
		ServerLevel level = level(p);
		LivingEntity target = target(p, 14);
		if (target == null) {
			Jutsus.miss(p, "No one meets your gaze");
			return;
		}
		sound(level, target.position(), SoundEvents.ENDERMAN_STARE, 1, 0.8F);
		channel(p, 120, 1, t -> {
			if (!target.isAlive())
				return;
			hold(target);
			target.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 10, 4, false, false));
			if (t % 6 == 0)
				level.sendParticles(Element.BLOOD.trail, target.getX(), target.getEyeY() + 0.3, target.getZ(), 2, 0.3, 0.1, 0.3, 0);
		});
	}

	/** Until when each caster's body is blood (Blood Transformation). */
	private static final Map<UUID, Long> BLOOD_FORM = new HashMap<>();

	/** Blood Transformation Technique: the body dissolves into blood for three seconds: nothing can hurt it and it moves like a flood. */
	private static void bloodTransformation(ServerPlayer p) {
		ServerLevel level = level(p);
		BLOOD_FORM.put(p.getUUID(), level.getGameTime() + 60);
		p.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 60, 0, false, false));
		p.addEffect(new MobEffectInstance(MobEffects.SPEED, 60, 3, false, false));
		sound(level, p.position(), SoundEvents.SLIME_SQUISH, 1.5F, 0.6F);
		channel(p, 60, 1, t -> level.sendParticles(Element.BLOOD.puff, p.getX(), p.getY() + 0.3, p.getZ(), 6, 0.4, 0.2, 0.4, 0.02));
		after(level, 60, () -> puff(level, p.position().add(0, 1, 0), Element.BLOOD, 1));
	}

	@SubscribeEvent
	public static void bloodBody(LivingIncomingDamageEvent event) {
		if (event.getEntity() instanceof ServerPlayer p && BLOOD_FORM.getOrDefault(p.getUUID(), 0L) > p.level().getGameTime()
				&& !event.getSource().is(net.minecraft.tags.DamageTypeTags.BYPASSES_INVULNERABILITY))
			event.setCanceled(true);
	}

	/** Blood Dragon Ascension: a dragon of blood surges out and tears through everything in its path. */
	private static void bloodDragon(ServerPlayer p) {
		JutsuProjectile dragon = shoot(p, Element.BLOOD, Shape.DRAGON, 1.5F, 1.0F, 16);
		dragon.pierce = -1;
		dragon.life = 50;
		dragon.knockback = 1.2F;
		dragon.onImpact = d -> Techniques.burst(level(p), d.position(), 3.5F, 10, 1, Element.BLOOD, d);
		sound(level(p), p.getEyePosition(), SoundEvents.ENDER_DRAGON_GROWL, 0.8F, 1.2F);
	}

	/**
	 * Exploding Human Technique: the caster's chakra seeps into the enemy's blood; for three seconds it boils, then the enemy bursts,
	 * hurting everyone around them too.
	 */
	private static void explodingHuman(ServerPlayer p) {
		ServerLevel level = level(p);
		LivingEntity target = target(p, 10);
		if (target == null) {
			Jutsus.miss(p, "Look at an enemy");
			return;
		}
		sound(level, target.position(), SoundEvents.WARDEN_HEARTBEAT, 2, 1);
		channel(p, 60, 1, t -> {
			if (!target.isAlive())
				return;
			hold(target);
			level.sendParticles(Element.BLOOD.puff, target.getX(), target.getY() + target.getBbHeight() / 2, target.getZ(), 1 + t / 10, target.getBbWidth() * 0.4,
					target.getBbHeight() * 0.3, target.getBbWidth() * 0.4, 0.02);
			if (t % 15 == 0)
				sound(level, target.position(), SoundEvents.WARDEN_HEARTBEAT, 2, 1 + t / 60F);
		});
		after(level, 60, () -> {
			if (!target.isAlive())
				return;
			Vec3 c = target.getBoundingBox().getCenter();
			damage(p, target, 30, Element.BLOOD);
			Techniques.burst(level, c, 4, 12, 1.5F, Element.BLOOD, p);
			level.sendParticles(Element.BLOOD.puff, c.x, c.y, c.z, 80, 1, 1, 1, 0.2);
			sound(level, c, SoundEvents.GENERIC_EXPLODE.value(), 1.5F, 1.3F);
		});
	}

	// ------------------------------------------------------------------ rinnegan
	/** Banshō Ten'in: the enemy looked at is pulled through the air straight to the caster. */
	private static void banshoTenin(ServerPlayer p) {
		ServerLevel level = level(p);
		LivingEntity target = target(p, 30);
		if (target == null) {
			Jutsus.miss(p, "Look at what to pull");
			return;
		}
		sound(level, p.position(), SoundEvents.BREEZE_INHALE, 1.5F, 0.6F);
		channel(p, 14, 1, t -> {
			if (!target.isAlive())
				return;
			Vec3 pull = p.getEyePosition().subtract(target.getBoundingBox().getCenter());
			if (pull.length() < 2) {
				if (t < 13) {
					damage(p, target, 6, Element.KOKUGAN);
					target.setDeltaMovement(Vec3.ZERO);
				}
				return;
			}
			target.setDeltaMovement(pull.normalize().scale(1.6));
			target.syncVelocity = true;
			line(level, Element.KAMUI.trail, p.getEyePosition(), target.getBoundingBox().getCenter(), 1.5);
		});
	}

	/** Shinra Tensei: a repulsive force bursts out of the caster and flings everything around away, turning projectiles aside. */
	private static void shinraTensei(ServerPlayer p) {
		ServerLevel level = level(p);
		Vec3 c = p.getBoundingBox().getCenter();
		for (LivingEntity target : enemies(level, p, p.getBoundingBox().inflate(8), e -> e.distanceToSqr(c) < 64)) {
			Vec3 away = target.getBoundingBox().getCenter().subtract(c).normalize();
			damage(p, target, 12, Element.KAMUI);
			target.push(away.x * 3.5, 0.8, away.z * 3.5);
			target.syncVelocity = true;
		}
		for (net.minecraft.world.entity.projectile.Projectile shot : level.getEntitiesOfClass(net.minecraft.world.entity.projectile.Projectile.class,
				p.getBoundingBox().inflate(8), e -> e.getOwner() != p))
			shot.setDeltaMovement(shot.position().subtract(c).normalize().scale(1.5));
		channel(p, 8, 1, t -> {
			for (int i = 0; i < 32; i++) {
				double a = i * Math.PI / 16;
				level.sendParticles(ParticleTypes.CLOUD, c.x + Math.cos(a) * t, c.y - 0.8, c.z + Math.sin(a) * t, 1, 0, 0.05, 0, 0);
			}
		});
		sound(level, c, SoundEvents.WARDEN_SONIC_BOOM, 1.5F, 0.7F);
	}

	/** Asura Attack: the arm splits open and fires a volley of missiles that seek enemies and explode. */
	private static void asuraAttack(ServerPlayer p) {
		channel(p, 18, 3, t -> {
			JutsuProjectile missile = shoot(p, Element.STEEL, Shape.ROD, 0.4F, turned(p, (level(p).getRandom().nextFloat() - 0.5F) * 30, -8).scale(1.3), 4);
			missile.homing = 0.3F;
			missile.life = 45;
			missile.onImpact = m -> Techniques.burst(level(p), m.position(), 2.5F, 6, 0.8F, Element.FIRE, m);
			sound(level(p), p.getEyePosition(), SoundEvents.FIREWORK_ROCKET_LAUNCH, 1, 0.8F);
		});
	}

	/** Blocking Technique Absorption Seal: for eight seconds every jutsu that reaches the caster is drunk in as chakra. */
	private static void absorptionSeal(ServerPlayer p) {
		ServerLevel level = level(p);
		shell(p, p, p.getBoundingBox().getCenter(), Element.KAMUI, 3, 160);
		sound(level, p.position(), SoundEvents.BEACON_ACTIVATE, 1, 1.4F);
		channel(p, 160, 1, t -> {
			for (JutsuProjectile shot : level.getEntitiesOfClass(JutsuProjectile.class, p.getBoundingBox().inflate(2.2), e -> e.getOwner() != p)) {
				NarutoShippudenModVariables.ifPresent(p, v -> {
					v.ChakraAmount = Math.min(v.ChakraMax, v.ChakraAmount + 40);
					v.syncPlayerVariables(p);
				});
				puff(level, shot.position(), Element.KAMUI, 0.6F);
				shot.discard();
			}
		});
	}

	/** Human Path: the caster grips the enemy and pulls their soul out of their body. */
	private static void humanPath(ServerPlayer p) {
		ServerLevel level = level(p);
		LivingEntity target = target(p, 4);
		if (target == null) {
			Jutsus.miss(p, "Get hold of an enemy first");
			return;
		}
		sound(level, target.position(), SoundEvents.SOUL_ESCAPE.value(), 2, 0.6F);
		channel(p, 30, 1, t -> {
			if (!target.isAlive())
				return;
			hold(target);
			hold(p);
			line(level, ParticleTypes.SOUL, target.getBoundingBox().getCenter(), p.getEyePosition(), 0.5);
		});
		after(level, 30, () -> {
			if (!target.isAlive())
				return;
			damage(p, target, 20, Element.KOKUGAN);
			target.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 200, 2));
			level.sendParticles(ParticleTypes.SCULK_SOUL, target.getX(), target.getY() + 1, target.getZ(), 20, 0.3, 0.5, 0.3, 0.05);
		});
	}

	/** Amenotejikara: the caster and the one looked at instantly swap places. */
	private static void amenotejikara(ServerPlayer p) {
		ServerLevel level = level(p);
		LivingEntity target = target(p, 30);
		if (target == null) {
			Jutsus.miss(p, "Look at who to swap with");
			return;
		}
		Vec3 mine = p.position(), theirs = target.position();
		level.sendParticles(ParticleTypes.REVERSE_PORTAL, mine.x, mine.y + 1, mine.z, 30, 0.3, 0.6, 0.3, 0.1);
		level.sendParticles(ParticleTypes.REVERSE_PORTAL, theirs.x, theirs.y + 1, theirs.z, 30, 0.3, 0.6, 0.3, 0.1);
		p.teleportTo(theirs.x, theirs.y, theirs.z);
		target.teleportTo(mine.x, mine.y, mine.z);
		sound(level, mine, SoundEvents.ENDERMAN_TELEPORT, 1, 1.4F);
		sound(level, theirs, SoundEvents.ENDERMAN_TELEPORT, 1, 1.4F);
	}

	/** Chibaku Tensei: a black core rises above the spot looked at and drags every enemy around up into it, crushing them. */
	private static void chibakuTensei(ServerPlayer p) {
		ServerLevel level = level(p);
		Vec3 core = lookPoint(p, 30).add(0, 9, 0);
		JutsuProjectile ball = spawn(p, Element.KOKUGAN, Shape.ORB, 1.2F, core.subtract(0, 0.6, 0), Vec3.ZERO, 0);
		ball.pierce = -1;
		ball.knockback = 0;
		ball.life = 130;
		sound(level, core, SoundEvents.BEACON_ACTIVATE, 2, 0.4F);
		channel(p, 120, 1, t -> {
			float size = Math.min(5, 1.2F + t * 0.05F);
			ball.look(Element.KOKUGAN, Shape.ORB, size);
			ball.setPos(core.subtract(0, size / 2, 0));
			level.sendParticles(Element.EARTH.trail, core.x, core.y, core.z, 6, size, size, size, 0.05);
			for (LivingEntity target : enemies(level, p, new AABB(core, core).inflate(16, 14, 16), e -> e.distanceToSqr(core) < 18 * 18)) {
				Vec3 pull = core.subtract(target.getBoundingBox().getCenter());
				target.setDeltaMovement(pull.length() > size ? pull.normalize().scale(0.8) : Vec3.ZERO);
				target.syncVelocity = true;
				target.fallDistance = 0;
				if (t % 10 == 0 && pull.length() < size + 1.5)
					damage(p, target, 4, Element.EARTH);
			}
		});
		after(level, 120, () -> {
			Techniques.burst(level, core, 6, 20, 1, Element.EARTH, ball);
			ball.discard();
			level.sendParticles(Element.EARTH.puff, core.x, core.y, core.z, 80, 3, 3, 3, 0.1);
		});
	}

	/** Tengai Shinsei: a huge meteorite falls out of the sky onto the spot looked at. */
	private static void tengaiShinsei(ServerPlayer p) {
		ServerLevel level = level(p);
		Vec3 at = lookPoint(p, 40);
		Vec3 from = at.add(p.getLookAngle().multiply(-1, 0, -1).normalize().scale(12)).add(0, 36, 0);
		JutsuProjectile rock = spawn(p, Element.EARTH, Shape.CUBE, 6, from, at.subtract(from).normalize().scale(1.3), 30);
		rock.pierce = -1;
		rock.life = 60;
		rock.knockback = 2;
		rock.onImpact = r -> {
			Techniques.burst(level, r.position(), 9, 40, 2.5F, Element.EARTH, r);
			level.sendParticles(ParticleTypes.EXPLOSION_EMITTER, r.getX(), r.getY(), r.getZ(), 3, 3, 1, 3, 0);
			level.sendParticles(Element.EARTH.puff, r.getX(), r.getY(), r.getZ(), 150, 5, 2, 5, 0.2);
			sound(level, r.position(), SoundEvents.GENERIC_EXPLODE.value(), 4, 0.5F);
		};
		sound(level, at, SoundEvents.WITHER_SPAWN, 2, 0.5F);
	}

	// ------------------------------------------------------------------ tenseigan
	/** Silver Wheel Reincarnation Explosion: spheres of chakra fly out and blow apart where they hit. */
	private static void silverWheel(ServerPlayer p) {
		for (int i = -2; i <= 2; i++) {
			JutsuProjectile sphere = shoot(p, Element.CHAKRA, Shape.ORB, 0.8F, turned(p, i * 12, -5).scale(1.4), 6);
			sphere.homing = 0.1F;
			sphere.life = 40;
			sphere.onImpact = s -> Techniques.burst(level(p), s.position(), 3, 8, 1, Element.CHAKRA, s);
		}
		sound(level(p), p.getEyePosition(), SoundEvents.BEACON_POWER_SELECT, 1.2F, 1.4F);
	}

	/** Golden Wheel Reincarnation Explosion: gravity draws everything round the spot looked at into one point, then it explodes. */
	private static void goldenWheel(ServerPlayer p) {
		ServerLevel level = level(p);
		Vec3 c = lookPoint(p, 30).add(0, 1.5, 0);
		JutsuProjectile core = spawn(p, Element.CHAKRA, Shape.ORB, 0.6F, c, Vec3.ZERO, 0);
		core.pierce = -1;
		core.knockback = 0;
		core.life = 50;
		sound(level, c, SoundEvents.BEACON_ACTIVATE, 2, 0.6F);
		channel(p, 40, 1, t -> {
			level.sendParticles(ParticleTypes.END_ROD, c.x, c.y, c.z, 6, 4, 2, 4, -0.2);
			for (LivingEntity target : enemies(level, p, new AABB(c, c).inflate(9), e -> e.distanceToSqr(c) < 81)) {
				Vec3 pull = c.subtract(target.getBoundingBox().getCenter());
				target.setDeltaMovement(pull.normalize().scale(Math.min(0.7, pull.length() * 0.3)));
				target.syncVelocity = true;
			}
		});
		after(level, 40, () -> {
			Techniques.burst(level, c, 7, 26, 2, Element.CHAKRA, core);
			core.discard();
			level.sendParticles(ParticleTypes.EXPLOSION_EMITTER, c.x, c.y, c.z, 1, 0, 0, 0, 0);
			sound(level, c, SoundEvents.GENERIC_EXPLODE.value(), 2.5F, 0.9F);
		});
	}

	/** Localised Reincarnation Explosion: a burst of repelling force round the caster that blasts every enemy near away. */
	private static void localisedExplosion(ServerPlayer p) {
		ServerLevel level = level(p);
		Vec3 c = p.getBoundingBox().getCenter();
		Techniques.burst(level, c, 5.5F, 18, 3, Element.CHAKRA, p);
		level.sendParticles(ParticleTypes.END_ROD, c.x, c.y, c.z, 80, 2.5, 1.5, 2.5, 0.3);
		sound(level, c, SoundEvents.GENERIC_EXPLODE.value(), 1.5F, 1.2F);
	}

	/**
	 * Tenseigan Chakra Mode: thirty seconds cloaked in blazing chakra: flight, great strength and speed, and truth-seeking balls
	 * circling the caster.
	 */
	private static void tenseiganMode(ServerPlayer p) {
		ServerLevel level = level(p);
		puff(level, p.position().add(0, 1, 0), Element.CHAKRA, 2);
		sound(level, p.position(), SoundEvents.BEACON_ACTIVATE, 1.5F, 1.2F);
		mode(p, 600, 1, v -> {
		}, v -> {
			if (!p.isCreative() && !p.isSpectator()) {
				p.getAbilities().mayfly = false;
				p.getAbilities().flying = false;
				p.onUpdateAbilities();
				p.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 100, 0, false, false, true));
			}
		}, t -> {
			if (!p.getAbilities().mayfly) {
				p.getAbilities().mayfly = true;
				p.onUpdateAbilities();
			}
			p.fallDistance = 0;
			if (t % 10 == 0) {
				keep(p, MobEffects.STRENGTH, 2);
				keep(p, MobEffects.SPEED, 1);
				keep(p, MobEffects.RESISTANCE, 1);
			}
			if (t % 2 == 0)
				for (int i = 0; i < 6; i++) {
					double a = t * 0.12 + i * Math.PI / 3;
					level.sendParticles(Element.KOKUGAN.trail, p.getX() + Math.cos(a) * 1.1, p.getY() + 1.6, p.getZ() + Math.sin(a) * 1.1, 1, 0, 0, 0, 0);
				}
			if (t % 3 == 0)
				level.sendParticles(Element.CHAKRA.trail, p.getX(), p.getY() + 1, p.getZ(), 3, 0.4, 0.8, 0.4, 0.02);
		});
	}

	// ------------------------------------------------------------------ mangekyou (added from the wiki)
	/** Tsukuyomi: the enemy is pulled into Itachi's world of illusion and tortured there; outside, they stand broken for five seconds. */
	private static void tsukuyomi(ServerPlayer p) {
		ServerLevel level = level(p);
		LivingEntity target = target(p, 12);
		if (target == null) {
			Jutsus.miss(p, "No one meets your gaze");
			return;
		}
		sound(level, target.position(), SoundEvents.ENDERMAN_STARE, 1.5F, 0.4F);
		channel(p, 100, 1, t -> {
			if (!target.isAlive())
				return;
			hold(target);
			target.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 30, 0, false, false));
			target.addEffect(new MobEffectInstance(MobEffects.NAUSEA, 120, 0, false, false));
			if (t % 20 == 0)
				damage(p, target, 5, Element.GENJUTSU);
			if (t % 4 == 0)
				level.sendParticles(Element.GENJUTSU.trail, target.getX(), target.getY() + 1, target.getZ(), 4, 0.5, 0.8, 0.5, 0);
		});
		p.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 100, 0, false, false, true));
	}

	/** Kamui Lightning Cutter: a Lightning Cutter driven through the enemy with Kamui wrapped round it, tearing space where it strikes. */
	private static void kamuiLightningCutter(ServerPlayer p) {
		ServerLevel level = level(p);
		boolean[] done = { false };
		channel(p, 24, 1, t -> {
			Vec3 look = p.getLookAngle().multiply(1, 0, 1).normalize();
			Vec3 hand = p.position().add(0, 1, 0).add(look.scale(0.6));
			level.sendParticles(t % 2 == 0 ? ParticleTypes.ELECTRIC_SPARK : Element.KAMUI.trail, hand.x, hand.y, hand.z, 6, 0.15, 0.15, 0.15, 0.2);
			if (done[0] || t < 10) {
				if (t < 10 && t % 3 == 0)
					sound(level, hand, SoundEvents.AMETHYST_BLOCK_CHIME, 0.8F, 1.7F);
				return;
			}
			p.setDeltaMovement(look.x * 1.8, Math.min(p.getDeltaMovement().y, 0.05), look.z * 1.8);
			p.syncVelocity = true;
			LivingEntity hit = enemies(level, p, p.getBoundingBox().inflate(0.8).move(look.scale(0.9)), e -> true).stream().findFirst().orElse(null);
			if (hit == null)
				return;
			done[0] = true;
			damage(p, hit, 20, Element.LIGHTNING);
			wormhole(p, hit, Math.max(hit.getBbWidth(), hit.getBbHeight()) + 1, 20);
			after(level, 20, () -> {
				if (hit.isAlive())
					damage(p, hit, 12, Element.KAMUI);
			});
			sound(level, hit.position(), SoundEvents.LIGHTNING_BOLT_IMPACT, 1.2F, 1.6F);
			p.setDeltaMovement(Vec3.ZERO);
			p.syncVelocity = true;
		});
	}

	/** Kamui Shuriken: the Susanoo's great shuriken, each warping away whatever it cuts. */
	private static void kamuiShuriken(ServerPlayer p) {
		for (int i = -1; i <= 1; i += 2) {
			JutsuProjectile star = shoot(p, Element.KAMUI, Shape.SHURIKEN, 1.8F, turned(p, i * 8, 0).scale(1.3), 14);
			star.homing = 0.12F;
			star.life = 40;
			star.onHit = (s, target) -> {
				wormhole(p, target, Math.max(target.getBbWidth(), target.getBbHeight()) + 1, 16);
				after(level(p), 16, () -> {
					if (target.isAlive())
						damage(p, target, 10, Element.KAMUI);
				});
			};
		}
		sound(level(p), p.getEyePosition(), SoundEvents.PLAYER_ATTACK_SWEEP, 1.5F, 0.6F);
	}

	/**
	 * Takes over a creature's will for a while: it fights the caster's enemies and never the caster. A player is held still with their
	 * blows against the caster turned aside.
	 */
	private static final Map<UUID, UUID> CONTROLLED = new HashMap<>();

	private static void control(ServerPlayer p, LivingEntity target, int ticks, Element element) {
		ServerLevel level = level(p);
		CONTROLLED.put(target.getUUID(), p.getUUID());
		channel(p, ticks, 1, t -> {
			if (!target.isAlive())
				return;
			if (t % 8 == 0)
				level.sendParticles(element.trail, target.getX(), target.getEyeY() + 0.4, target.getZ(), 3, 0.3, 0.1, 0.3, 0);
			if (target instanceof Mob mob) {
				LivingEntity prey = mob.getTarget();
				if (prey == null || !prey.isAlive() || prey == p || !Techniques.isEnemy(p, prey))
					mob.setTarget(level.getEntitiesOfClass(LivingEntity.class, mob.getBoundingBox().inflate(20),
							x -> x != mob && x != p && x.isAlive() && Techniques.isEnemy(p, x) && !(x instanceof net.minecraft.world.entity.decoration.ArmorStand))
							.stream().min((a, b) -> Double.compare(a.distanceToSqr(mob), b.distanceToSqr(mob))).orElse(null));
			} else if (t < 80)
				hold(target);
		});
		after(level, ticks, () -> CONTROLLED.remove(target.getUUID(), p.getUUID()));
	}

	@SubscribeEvent
	public static void controlledBlow(LivingIncomingDamageEvent event) {
		net.minecraft.world.entity.Entity attacker = event.getSource().getEntity();
		if (attacker != null && event.getEntity().getUUID().equals(CONTROLLED.get(attacker.getUUID())))
			event.setCanceled(true);
	}

	/** Kotoamatsukami: Shisui's genjutsu rewrites the enemy's will so perfectly they never know: for a minute they fight for the caster. */
	private static void kotoamatsukami(ServerPlayer p) {
		LivingEntity target = target(p, 20);
		if (target == null) {
			Jutsus.miss(p, "No one meets your gaze");
			return;
		}
		sound(level(p), target.position(), SoundEvents.ILLUSIONER_CAST_SPELL, 1.5F, 0.6F);
		puff(level(p), target.getBoundingBox().getCenter(), Element.GENJUTSU, 1);
		control(p, target, target instanceof Player ? 400 : 1200, Element.GENJUTSU);
		tell(p, target.getDisplayName().getString() + " is yours to command");
	}

	/** Genjutsu: Sharingan: Madara's eyes bend even a great beast to his will; for forty seconds it fights for him. */
	private static void madaraGenjutsu(ServerPlayer p) {
		LivingEntity target = target(p, 20);
		if (target == null) {
			Jutsus.miss(p, "No one meets your gaze");
			return;
		}
		sound(level(p), target.position(), SoundEvents.ENDERMAN_STARE, 1.5F, 0.5F);
		control(p, target, target instanceof Player ? 100 : 800, Element.GENJUTSU);
	}

	/** Susanoo: Fist: a giant fist of the Susanoo's chakra smashes forward through everything in its way. */
	private static void susanooFist(ServerPlayer p) {
		JutsuProjectile fist = shoot(p, Element.KAMUI, Shape.ORB, 3.2F, 1.3F, 24);
		fist.pierce = -1;
		fist.life = 16;
		fist.knockback = 3;
		fist.onImpact = f -> Techniques.burst(level(p), f.position(), 4, 12, 2, Element.KAMUI, f);
		sound(level(p), p.getEyePosition(), SoundEvents.WARDEN_SONIC_BOOM, 1.2F, 0.6F);
	}
}
