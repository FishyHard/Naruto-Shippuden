package net.mcreator.narutoshippudenmod.core.jutsu;

import static net.mcreator.narutoshippudenmod.core.jutsu.NatureJutsu.OPEN;
import static net.mcreator.narutoshippudenmod.core.jutsu.NatureJutsu.ground;
import static net.mcreator.narutoshippudenmod.core.jutsu.NatureJutsu.level;
import static net.mcreator.narutoshippudenmod.core.jutsu.NatureJutsu.nature;
import static net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.burst;
import static net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.channel;
import static net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.cone;
import static net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.damage;
import static net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.enemies;
import static net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.lookPoint;
import static net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.place;
import static net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.puff;
import static net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.shoot;
import static net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.sound;
import static net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.turned;

import net.mcreator.narutoshippudenmod.core.jutsu.NatureJutsu.Def;
import net.mcreator.narutoshippudenmod.core.jutsu.engine.Element;
import net.mcreator.narutoshippudenmod.core.jutsu.engine.JutsuEngine;
import net.mcreator.narutoshippudenmod.core.jutsu.engine.JutsuProjectile;
import net.mcreator.narutoshippudenmod.core.jutsu.engine.JutsuProjectile.Shape;
import net.mcreator.narutoshippudenmod.core.jutsu.engine.JutsuRank;
import net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques;
import net.mcreator.narutoshippudenmod.entity.SummonEntities.WoodGolemEntity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import java.util.ArrayList;
import java.util.List;

/**
 * The kekkei genkai releases on the jutsu engine. Like the natures, they keep the old save variables and price every jutsu by its
 * {@link JutsuRank}.
 */
final class KekkeiGenkaiJutsu {
	private KekkeiGenkaiJutsu() {
	}

	static void register() {
		nature("boil", "Boil Release", v -> v.boilreleaselogic, v -> v.boiltechnique, (v, i) -> v.boiltechnique = i, v -> v.boillearn,
				(v, i) -> v.boillearn = i, v -> v.boilrelease, (v, i) -> v.boilrelease = i,
				new Def("Skilled Mist Technique", JutsuRank.C, KekkeiGenkaiJutsu::skilledMist),
				new Def("Steam Dash", JutsuRank.B, p -> Techniques.dash(p, 12, 11, Element.BOIL)),
				new Def("Unrivalled Strength", JutsuRank.A, KekkeiGenkaiJutsu::unrivalledStrength));
		nature("bone", "Bone Release", v -> v.bonereleaselogic, v -> v.bonetechnique, (v, i) -> v.bonetechnique = i, v -> v.bonelearn,
				(v, i) -> v.bonelearn = i, v -> v.bone_release, (v, i) -> v.bone_release = i,
				new Def("Finger Drill Bullets", JutsuRank.D, KekkeiGenkaiJutsu::fingerBullets),
				new Def("Dance of the Camellia", JutsuRank.C, KekkeiGenkaiJutsu::camellia),
				new Def("Dance of the Clematis: Flower", JutsuRank.B, KekkeiGenkaiJutsu::clematis),
				new Def("Dance of the Seedling Fern", JutsuRank.A, KekkeiGenkaiJutsu::seedlingFern));
		nature("dust", "Dust Release", v -> v.dustreleaselogic, v -> v.dusttechnique, (v, i) -> v.dusttechnique = i, v -> v.dustlearn,
				(v, i) -> v.dustlearn = i, v -> v.dustrelease, (v, i) -> v.dustrelease = i,
				new Def("Dust Prism", JutsuRank.A, p -> dust(p, 0.8F, 1.8F, 14, 2.5F)),
				new Def("Detachment of the Primitive World", JutsuRank.S, p -> dust(p, 2.2F, 0.7F, 30, 6)));
		nature("ice", "Ice Release", v -> v.icereleaselogic, v -> v.icetechnique, (v, i) -> v.icetechnique = i, v -> v.icelearn,
				(v, i) -> v.icelearn = i, v -> v.ice_release, (v, i) -> v.ice_release = i,
				new Def("Certain-Kill Ice Spears", JutsuRank.C, KekkeiGenkaiJutsu::iceSpears),
				new Def("Demonic Mirroring Ice Crystals", JutsuRank.B, KekkeiGenkaiJutsu::iceMirrors),
				new Def("Black Dragon Blizzard", JutsuRank.A, KekkeiGenkaiJutsu::blizzard));
		nature("magnet", "Magnet Release", v -> v.magnetreleaselogic, v -> v.magnettechnique, (v, i) -> v.magnettechnique = i, v -> v.magnetlearn,
				(v, i) -> v.magnetlearn = i, v -> v.magnet_release, (v, i) -> v.magnet_release = i,
				new Def("Black Iron Fist", JutsuRank.C, KekkeiGenkaiJutsu::ironFist),
				new Def("Iron Sand Drizzle", JutsuRank.B, KekkeiGenkaiJutsu::drizzle),
				new Def("Iron Sand Coat", JutsuRank.B, p -> armor(p, Element.MAGNET, 300, 1)),
				new Def("Black Iron Wings", JutsuRank.A, KekkeiGenkaiJutsu::ironWings));
		nature("smoke", "Smoke Release", v -> v.smokereleaselogic, v -> v.smoketechnique, (v, i) -> v.smoketechnique = i, v -> v.smokelearn,
				(v, i) -> v.smokelearn = i, v -> v.smokerelease, (v, i) -> v.smokerelease = i,
				new Def("Smoke Gun", JutsuRank.C, KekkeiGenkaiJutsu::smokeGun),
				new Def("Smoke Fist", JutsuRank.B, KekkeiGenkaiJutsu::smokeFist),
				new Def("Smoke Form", JutsuRank.A, KekkeiGenkaiJutsu::smokeForm));
		nature("steel", "Steel Release", v -> v.steelreleaselogic, v -> v.steeltechnique, (v, i) -> v.steeltechnique = i, v -> v.steellearn,
				(v, i) -> v.steellearn = i, v -> v.steelrelease, (v, i) -> v.steelrelease = i,
				new Def("Steel Projectile", JutsuRank.C, KekkeiGenkaiJutsu::steelProjectile),
				new Def("Impervious Armour", JutsuRank.A, p -> armor(p, Element.STEEL, 200, 3)));
		nature("storm", "Storm Release", v -> v.stormreleaselogic, v -> v.stormtechnique, (v, i) -> v.stormtechnique = i, v -> v.stormlearn,
				(v, i) -> v.stormlearn = i, v -> v.storm_release, (v, i) -> v.storm_release = i,
				new Def("Laser Circus", JutsuRank.B, KekkeiGenkaiJutsu::laserCircus),
				new Def("Thunder Cloud Inner Wave", JutsuRank.A, KekkeiGenkaiJutsu::thunderCloud));
		nature("swift", "Swift Release", v -> v.swiftreleaselogic, v -> 0, (v, i) -> {
		}, v -> v.swiftlearn, (v, i) -> v.swiftlearn = i, v -> v.swiftrelease, (v, i) -> v.swiftrelease = i,
				new Def("Shadowless Flight", JutsuRank.A, KekkeiGenkaiJutsu::shadowlessFlight));
		nature("typhoon", "Typhoon Release", v -> v.typhoonreleaslogic, v -> v.typhoontechnique, (v, i) -> v.typhoontechnique = i,
				v -> v.typhoonlearn, (v, i) -> v.typhoonlearn = i, v -> v.typhoonrelease, (v, i) -> v.typhoonrelease = i,
				new Def("Great Consecutive Bursting Strong Winds", JutsuRank.B, KekkeiGenkaiJutsu::burstingWinds),
				new Def("Great Consecutive Bursting Extreme Winds", JutsuRank.A, KekkeiGenkaiJutsu::tornado));
		nature("wood", "Wood Release", v -> v.woodreleaselogic, v -> v.woodtechnique, (v, i) -> v.woodtechnique = i, v -> v.woodlearn,
				(v, i) -> v.woodlearn = i, v -> v.wood_release, (v, i) -> v.wood_release = i,
				new Def("Tree Bind Flourishing Burial", JutsuRank.B, KekkeiGenkaiJutsu::treeBind),
				new Def("Wood Dragon Technique", JutsuRank.A, KekkeiGenkaiJutsu::woodDragon),
				new Def("Wood Human Technique", JutsuRank.S, KekkeiGenkaiJutsu::woodHuman));
	}

	/** A field that does something to every enemy in it every few ticks, with particles. */
	private static void field(ServerPlayer p, Vec3 at, double radius, int ticks, int every, Element element, java.util.function.BiConsumer<LivingEntity, Integer> effect) {
		ServerLevel level = level(p);
		channel(p, ticks, every, t -> {
			level.sendParticles(element.trail, at.x, at.y + 0.5, at.z, (int) (radius * radius), radius / 1.6, 0.6, radius / 1.6, 0.01);
			for (LivingEntity target : enemies(level, p, new AABB(at, at).inflate(radius, 3, radius), e -> e.distanceToSqr(at) <= radius * radius + 9))
				effect.accept(target, t);
		});
	}

	/** Timed self buff shown by particles: resistance (and slowness for heavy armor). */
	private static void armor(ServerPlayer p, Element element, int ticks, int resistance) {
		p.addEffect(new MobEffectInstance(MobEffects.RESISTANCE, ticks, resistance, false, false, true));
		if (element == Element.STEEL)
			p.addEffect(new MobEffectInstance(MobEffects.SLOWNESS, ticks, 0, false, false, true));
		sound(level(p), p.position(), element.impact, 1, 0.8F);
		channel(p, ticks, 5, t -> level(p).sendParticles(element.puff, p.getX(), p.getY() + 1, p.getZ(), 4, 0.4, 0.7, 0.4, 0.02));
	}

	// ------------------------------------------------------------------ boil
	/** A cloud of acidic mist where the caster looks: burns and weakens for six seconds. */
	private static void skilledMist(ServerPlayer p) {
		Vec3 at = lookPoint(p, 16);
		sound(level(p), at, SoundEvents.LAVA_EXTINGUISH, 2, 0.6F);
		field(p, at, 4, 120, 5, Element.BOIL, (target, t) -> {
			if (t % 10 == 0)
				damage(p, target, 2, Element.BOIL);
		});
	}

	/** Twenty seconds of boiling strength: much stronger, tougher, and steaming. */
	private static void unrivalledStrength(ServerPlayer p) {
		p.addEffect(new MobEffectInstance(MobEffects.STRENGTH, 400, 2, false, false, true));
		p.addEffect(new MobEffectInstance(MobEffects.RESISTANCE, 400, 0, false, false, true));
		sound(level(p), p.position(), SoundEvents.LAVA_EXTINGUISH, 1.5F, 0.5F);
		channel(p, 400, 3, t -> level(p).sendParticles(ParticleTypes.WHITE_SMOKE, p.getX(), p.getY() + 1.2, p.getZ(), 3, 0.35, 0.5, 0.35, 0.02));
	}

	// ------------------------------------------------------------------ bone
	/** Six bone bullets shot from the fingertips. */
	private static void fingerBullets(ServerPlayer p) {
		channel(p, 12, 2, t -> {
			JutsuProjectile bone = shoot(p, Element.BONE, Shape.NEEDLE, 0.22F, turned(p, (t % 3 - 1) * 3, 0).scale(2.4F), 4);
			bone.knockback = 0.1F;
			sound(level(p), p.getEyePosition(), SoundEvents.SKELETON_SHOOT, 0.6F, 1.6F);
		});
	}

	/** A lunge with a bone sword that pierces everything just in front. */
	private static void camellia(ServerPlayer p) {
		ServerLevel level = level(p);
		Vec3 look = p.getLookAngle();
		for (LivingEntity target : cone(p, 4.5, 30))
			damage(p, target, 12, Element.BONE);
		for (int i = 1; i <= 4; i++) {
			Vec3 at = p.getEyePosition().add(look.scale(i));
			level.sendParticles(ParticleTypes.SWEEP_ATTACK, at.x, at.y - 0.3, at.z, 1, 0, 0, 0, 0);
		}
		p.setDeltaMovement(look.x * 0.8, 0.1, look.z * 0.8);
		p.syncVelocity = true;
		sound(level, p.position(), SoundEvents.PLAYER_ATTACK_SWEEP, 1, 0.7F);
	}

	/** A great spiralling bone drill that bores through everything in its way. */
	private static void clematis(ServerPlayer p) {
		JutsuProjectile drill = shoot(p, Element.BONE, Shape.NEEDLE, 0.8F, 1.3F, 14);
		drill.pierce = -1;
		drill.knockback = 1;
		drill.onImpact = d -> puff(level(p), d.position(), Element.BONE, 1.5F);
		sound(level(p), p.getEyePosition(), SoundEvents.BONE_BLOCK_BREAK, 1.5F, 0.6F);
	}

	/** A forest of bone spikes bursts from the ground all around the caster. */
	private static void seedlingFern(ServerPlayer p) {
		ServerLevel level = level(p);
		List<LivingEntity> struck = new ArrayList<>();
		sound(level, p.position(), SoundEvents.BONE_BLOCK_BREAK, 2, 0.5F);
		channel(p, 10, 1, ring -> {
			int r = 3 + ring / 2;
			for (int i = 0; i < 6 + r * 3; i++) {
				double a = level.getRandom().nextDouble() * Math.PI * 2;
				BlockPos base = ground(level, p.getX() + Math.cos(a) * r, p.getY(), p.getZ() + Math.sin(a) * r);
				int height = 1 + level.getRandom().nextInt(3);
				for (int h = 0; h < height; h++)
					place(level, base.above(h), Blocks.BONE_BLOCK.defaultBlockState(), 100 - ring, OPEN);
			}
			for (LivingEntity target : enemies(level, p, p.getBoundingBox().inflate(r + 1, 2, r + 1), e -> !struck.contains(e))) {
				struck.add(target);
				damage(p, target, 14, Element.BONE);
				target.push(0, 0.8, 0);
				target.syncVelocity = true;
			}
		});
	}

	// ------------------------------------------------------------------ dust
	/** A glowing cube that erases what it touches in a great white burst. */
	private static void dust(ServerPlayer p, float size, float speed, float damage, float radius) {
		JutsuProjectile cube = shoot(p, Element.DUST, Shape.CUBE, size, speed, damage);
		cube.life = 60;
		cube.onImpact = c -> {
			ServerLevel level = level(p);
			burst(level, c.position(), radius, damage, 0.4F, Element.DUST, c);
			level.sendParticles(ParticleTypes.END_ROD, c.getX(), c.getY(), c.getZ(), (int) (radius * 40), radius / 2, radius / 2, radius / 2, 0.15);
		};
		sound(level(p), p.getEyePosition(), SoundEvents.BEACON_ACTIVATE, 1.5F, 1.5F);
	}

	// ------------------------------------------------------------------ ice
	/** Five spears of ice; each freezes what it hits. */
	private static void iceSpears(ServerPlayer p) {
		for (int i = -2; i <= 2; i++) {
			JutsuProjectile spear = shoot(p, Element.ICE, Shape.NEEDLE, 0.4F, turned(p, i * 6, -1).scale(1.9), 6);
			spear.life = 30;
			spear.onImpact = s -> puff(level(p), s.position(), Element.ICE, 0.6F);
		}
		sound(level(p), p.getEyePosition(), SoundEvents.GLASS_BREAK, 1, 1.5F);
	}

	/** A dome of ice mirrors traps the enemies where the caster looks; inside they freeze and are cut. */
	private static void iceMirrors(ServerPlayer p) {
		ServerLevel level = level(p);
		Vec3 at = lookPoint(p, 18);
		BlockPos centre = ground(level, at.x, at.y, at.z);
		for (int i = 0; i < 16; i++) {
			double a = i * Math.PI / 8;
			BlockPos base = ground(level, centre.getX() + Math.cos(a) * 3.5, centre.getY(), centre.getZ() + Math.sin(a) * 3.5);
			for (int h = 0; h < 3; h++)
				place(level, base.above(h), Blocks.PACKED_ICE.defaultBlockState(), 140, OPEN);
		}
		sound(level, at, SoundEvents.GLASS_PLACE, 2, 0.6F);
		field(p, Vec3.atBottomCenterOf(centre), 3.2, 140, 5, Element.ICE, (target, t) -> {
			target.addEffect(new MobEffectInstance(MobEffects.SLOWNESS, 20, 3, false, false));
			if (t % 15 == 0) {
				damage(p, target, 4, Element.ICE);
				level.sendParticles(ParticleTypes.SWEEP_ATTACK, target.getX(), target.getY() + 1, target.getZ(), 1, 0, 0, 0, 0);
			}
		});
	}

	/** A black dragon of ice that freezes everything it passes. */
	private static void blizzard(ServerPlayer p) {
		JutsuProjectile dragon = shoot(p, Element.ICE, Shape.DRAGON, 1.7F, 0.95F, 16);
		dragon.pierce = -1;
		dragon.life = 55;
		dragon.onImpact = d -> burst(level(p), d.position(), 4, 12, 0.8F, Element.ICE, d);
		sound(level(p), p.getEyePosition(), SoundEvents.ENDER_DRAGON_GROWL, 0.8F, 1.5F);
	}

	// ------------------------------------------------------------------ magnet
	/** A giant fist of iron sand punches forward. */
	private static void ironFist(ServerPlayer p) {
		JutsuProjectile fist = shoot(p, Element.MAGNET, Shape.ORB, 1.5F, 1.4F, 12);
		fist.life = 14;
		fist.knockback = 2.2F;
		fist.onImpact = f -> puff(level(p), f.position(), Element.MAGNET, 1.2F);
		sound(level(p), p.getEyePosition(), SoundEvents.CHAIN_BREAK, 1.5F, 0.6F);
	}

	/** Iron sand rains down on the area the caster looks at for two seconds. */
	private static void drizzle(ServerPlayer p) {
		ServerLevel level = level(p);
		Vec3 at = lookPoint(p, 24);
		channel(p, 40, 2, t -> {
			Vec3 from = at.add((level.getRandom().nextDouble() - 0.5) * 8, 12, (level.getRandom().nextDouble() - 0.5) * 8);
			JutsuProjectile grain = new JutsuProjectile(JutsuEngine.PROJECTILE, level);
			grain.look(Element.MAGNET, Shape.NEEDLE, 0.3F);
			grain.setOwner(p);
			grain.setPos(from);
			grain.setDeltaMovement(0, -1.6, 0);
			grain.damage = 3;
			grain.life = 20;
			level.addFreshEntity(grain);
		});
		sound(level, at, SoundEvents.SAND_FALL, 2, 0.5F);
	}

	/** Wings of iron sand: a great leap and a slow glide down. */
	private static void ironWings(ServerPlayer p) {
		Vec3 look = p.getLookAngle().multiply(1, 0, 1).normalize();
		p.setDeltaMovement(look.x * 1.2, 1.4, look.z * 1.2);
		p.syncVelocity = true;
		p.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 160, 0, false, false, true));
		sound(level(p), p.position(), SoundEvents.PHANTOM_FLAP, 1.5F, 0.6F);
		channel(p, 160, 2, t -> {
			p.fallDistance = 0;
			level(p).sendParticles(Element.MAGNET.trail, p.getX(), p.getY() + 1.2, p.getZ(), 6, 1.2, 0.2, 1.2, 0.01);
		});
	}

	// ------------------------------------------------------------------ smoke
	/** A shell of smoke that bursts into a blinding cloud. */
	private static void smokeGun(ServerPlayer p) {
		JutsuProjectile shell = shoot(p, Element.SMOKE, Shape.ORB, 0.7F, 1.5F, 7);
		shell.onImpact = s -> {
			burst(level(p), s.position(), 3, 5, 0.3F, Element.SMOKE, s);
			level(p).sendParticles(ParticleTypes.CAMPFIRE_COSY_SMOKE, s.getX(), s.getY(), s.getZ(), 30, 1.5, 1, 1.5, 0.01);
		};
		sound(level(p), p.getEyePosition(), SoundEvents.FIRECHARGE_USE, 1, 0.6F);
	}

	/** A heavy fist of smoke that sends enemies flying. */
	private static void smokeFist(ServerPlayer p) {
		JutsuProjectile fist = shoot(p, Element.SMOKE, Shape.ORB, 1.6F, 1.2F, 13);
		fist.life = 16;
		fist.pierce = 2;
		fist.knockback = 2.5F;
		sound(level(p), p.getEyePosition(), SoundEvents.FIRECHARGE_USE, 1.5F, 0.5F);
	}

	/** The caster's body turns to smoke for ten seconds: invisible, fast, and hard to hit. */
	private static void smokeForm(ServerPlayer p) {
		p.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 200, 0, false, false, true));
		p.addEffect(new MobEffectInstance(MobEffects.SPEED, 200, 1, false, false, true));
		p.addEffect(new MobEffectInstance(MobEffects.RESISTANCE, 200, 1, false, false, true));
		sound(level(p), p.position(), SoundEvents.FIRE_EXTINGUISH, 1.5F, 0.6F);
		channel(p, 200, 2, t -> level(p).sendParticles(ParticleTypes.LARGE_SMOKE, p.getX(), p.getY() + 0.8, p.getZ(), 3, 0.3, 0.6, 0.3, 0.01));
	}

	// ------------------------------------------------------------------ steel
	/** A lance of steel that punches through two enemies. */
	private static void steelProjectile(ServerPlayer p) {
		JutsuProjectile lance = shoot(p, Element.STEEL, Shape.NEEDLE, 0.6F, 2.2F, 13);
		lance.pierce = 2;
		lance.knockback = 1;
		sound(level(p), p.getEyePosition(), SoundEvents.ANVIL_LAND, 0.6F, 1.8F);
	}

	// ------------------------------------------------------------------ storm
	/** Six beams of storm light that bend towards enemies. */
	private static void laserCircus(ServerPlayer p) {
		for (int i = 0; i < 6; i++) {
			JutsuProjectile beam = shoot(p, Element.STORM, Shape.NEEDLE, 0.3F, turned(p, (i - 2.5F) * 12, -10).scale(1.4), 6);
			beam.homing = 0.25F;
			beam.life = 50;
			beam.knockback = 0.2F;
		}
		sound(level(p), p.getEyePosition(), SoundEvents.BEACON_POWER_SELECT, 1.5F, 1.6F);
	}

	/** A thundercloud over the target that strikes enemies below it for five seconds. */
	private static void thunderCloud(ServerPlayer p) {
		ServerLevel level = level(p);
		Vec3 at = lookPoint(p, 30);
		channel(p, 100, 2, t -> {
			level.sendParticles(ParticleTypes.LARGE_SMOKE, at.x, at.y + 9, at.z, 12, 4, 0.6, 4, 0.01);
			if (t % 12 == 0) {
				List<LivingEntity> below = enemies(level, p, new AABB(at, at).inflate(6, 8, 6), e -> true);
				Vec3 hit = below.isEmpty() ? at.add((level.getRandom().nextDouble() - 0.5) * 8, 0, (level.getRandom().nextDouble() - 0.5) * 8)
						: below.get(level.getRandom().nextInt(below.size())).position();
				Techniques.strike(level, hit, 2.5F, 8, p);
			}
		});
	}

	// ------------------------------------------------------------------ swift
	/** Moves faster than the eye can follow: a blur of dashes through enemies, then a burst of speed. */
	private static void shadowlessFlight(ServerPlayer p) {
		Techniques.dash(p, 16, 12, Element.SWIFT);
		p.addEffect(new MobEffectInstance(MobEffects.SPEED, 120, 3, false, false, true));
	}

	// ------------------------------------------------------------------ typhoon
	/** Three blasts of wind in quick succession. */
	private static void burstingWinds(ServerPlayer p) {
		channel(p, 15, 5, t -> {
			Vec3 look = p.getLookAngle();
			for (LivingEntity target : cone(p, 10, 30)) {
				damage(p, target, 5, Element.WIND);
				target.push(look.x * 1.5, 0.35, look.z * 1.5);
				target.syncVelocity = true;
			}
			for (int i = 2; i <= 9; i += 2) {
				Vec3 at = p.getEyePosition().add(look.scale(i));
				level(p).sendParticles(ParticleTypes.GUST, at.x, at.y, at.z, 1, 0.3, 0.3, 0.3, 0);
			}
			sound(level(p), p.getEyePosition(), SoundEvents.WIND_CHARGE_BURST.value(), 1, 0.7F + t * 0.02F);
		});
	}

	/** A tornado where the caster looks: lifts and spins enemies for four seconds. */
	private static void tornado(ServerPlayer p) {
		ServerLevel level = level(p);
		Vec3 at = lookPoint(p, 24);
		sound(level, at, SoundEvents.BREEZE_WIND_CHARGE_BURST.value(), 2, 0.5F);
		channel(p, 80, 1, t -> {
			for (int i = 0; i < 4; i++) {
				double y = level.getRandom().nextDouble() * 7, a = t * 0.5 + i * Math.PI / 2 + y, r = 0.6 + y * 0.35;
				level.sendParticles(ParticleTypes.CLOUD, at.x + Math.cos(a) * r, at.y + y, at.z + Math.sin(a) * r, 1, 0, 0, 0, 0);
			}
			if (t % 4 == 0)
				level.sendParticles(ParticleTypes.GUST, at.x, at.y + 1, at.z, 1, 0.5, 0.5, 0.5, 0);
			for (LivingEntity target : enemies(level, p, new AABB(at, at).inflate(4, 8, 4), e -> true)) {
				Vec3 in = at.subtract(target.position()).multiply(1, 0, 1).scale(0.08);
				Vec3 spin = new Vec3(-in.z, 0, in.x).scale(2);
				target.setDeltaMovement(in.x + spin.x, 0.18, in.z + spin.z);
				target.syncVelocity = true;
				target.fallDistance = 0;
				if (t % 8 == 0)
					damage(p, target, 3, Element.WIND);
			}
		});
	}

	// ------------------------------------------------------------------ wood
	/** Roots and trunks burst up around the enemies where the caster looks, binding and crushing them. */
	private static void treeBind(ServerPlayer p) {
		ServerLevel level = level(p);
		Vec3 at = lookPoint(p, 20);
		BlockState log = Blocks.OAK_LOG.defaultBlockState(), leaves = Blocks.OAK_LEAVES.defaultBlockState();
		for (int i = 0; i < 14; i++) {
			double a = level.getRandom().nextDouble() * Math.PI * 2, r = 1.5 + level.getRandom().nextDouble() * 3;
			BlockPos base = ground(level, at.x + Math.cos(a) * r, at.y, at.z + Math.sin(a) * r);
			int h = 2 + level.getRandom().nextInt(3);
			for (int y = 0; y < h; y++)
				place(level, base.above(y), y == h - 1 ? leaves : log, 160, OPEN);
		}
		sound(level, at, SoundEvents.WOOD_PLACE, 2, 0.5F);
		field(p, at, 4.5, 160, 5, Element.WOOD, (target, t) -> {
			target.addEffect(new MobEffectInstance(MobEffects.SLOWNESS, 20, 5, false, false));
			target.setDeltaMovement(0, Math.min(0, target.getDeltaMovement().y), 0);
			target.syncVelocity = true;
			if (t % 20 == 0)
				damage(p, target, 3, Element.WOOD);
		});
	}

	/** A wooden dragon that rams through everything and crushes it. */
	private static void woodDragon(ServerPlayer p) {
		JutsuProjectile dragon = shoot(p, Element.WOOD, Shape.DRAGON, 1.8F, 0.9F, 18);
		dragon.pierce = -1;
		dragon.life = 60;
		dragon.knockback = 1.5F;
		dragon.onImpact = d -> burst(level(p), d.position(), 3.5F, 12, 1.5F, Element.WOOD, d);
		sound(level(p), p.getEyePosition(), SoundEvents.WOOD_BREAK, 2, 0.5F);
	}

	/** The Wood Human: a giant wooden golem that fights for the caster for 40 seconds. */
	private static void woodHuman(ServerPlayer p) {
		ServerLevel level = level(p);
		Vec3 at = p.position().add(p.getLookAngle().multiply(1, 0, 1).normalize().scale(4));
		WoodGolemEntity.CustomEntity golem = new WoodGolemEntity.CustomEntity(WoodGolemEntity.entity, level);
		golem.snapTo(at.x, p.getY(), at.z, p.getYRot(), 0);
		golem.finalizeSpawn(level, level.getCurrentDifficultyAt(golem.blockPosition()), EntitySpawnReason.MOB_SUMMONED, null);
		golem.tame(p);
		level.addFreshEntity(golem);
		puff(level, at.add(0, 2, 0), Element.WOOD, 3);
		sound(level, at, SoundEvents.WOOD_BREAK, 2, 0.4F);
		Techniques.after(level, 800, () -> {
			if (golem.isAlive()) {
				puff(level, golem.position().add(0, 2, 0), Element.WOOD, 3);
				golem.discard();
			}
		});
	}
}
