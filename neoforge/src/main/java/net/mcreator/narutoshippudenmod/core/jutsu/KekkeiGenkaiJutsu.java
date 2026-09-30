package net.mcreator.narutoshippudenmod.core.jutsu;

import static net.mcreator.narutoshippudenmod.core.jutsu.NatureJutsu.OPEN;
import static net.mcreator.narutoshippudenmod.core.jutsu.NatureJutsu.ground;
import static net.mcreator.narutoshippudenmod.core.jutsu.NatureJutsu.level;
import static net.mcreator.narutoshippudenmod.core.jutsu.NatureJutsu.nature;
import static net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.after;
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

import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables;
import net.mcreator.narutoshippudenmod.core.jutsu.engine.Displays;
import net.mcreator.narutoshippudenmod.core.jutsu.NatureJutsu.Def;
import net.mcreator.narutoshippudenmod.core.jutsu.engine.Element;
import net.mcreator.narutoshippudenmod.core.jutsu.engine.JutsuEngine;
import net.mcreator.narutoshippudenmod.core.jutsu.engine.JutsuProjectile;
import net.mcreator.narutoshippudenmod.core.jutsu.engine.JutsuProjectile.Shape;
import net.mcreator.narutoshippudenmod.core.jutsu.engine.JutsuRank;
import net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques;
import net.mcreator.narutoshippudenmod.entity.SummonEntities.WoodGolemEntity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.BlockParticleOption;
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

import org.jspecify.annotations.Nullable;

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
				new Def("Erupting Propulsion Fist", JutsuRank.B, KekkeiGenkaiJutsu::eruptingFist, "Taijutsu"),
				new Def("Steam Explosion", JutsuRank.A, KekkeiGenkaiJutsu::steamExplosion),
				new Def("Unrivalled Strength", JutsuRank.A, KekkeiGenkaiJutsu::unrivalledStrength));
		nature("bone", "Bone Release", v -> v.bonereleaselogic, v -> v.bonetechnique, (v, i) -> v.bonetechnique = i, v -> v.bonelearn,
				(v, i) -> v.bonelearn = i, v -> v.bone_release, (v, i) -> v.bone_release = i,
				new Def("Ten-Finger Drilling Bullets", JutsuRank.D, KekkeiGenkaiJutsu::fingerBullets),
				new Def("Dance of the Camellia", JutsuRank.C, KekkeiGenkaiJutsu::camellia, "Taijutsu"),
				new Def("Dance of the Willow", JutsuRank.C, KekkeiGenkaiJutsu::willow, "Taijutsu"),
				new Def("Dance of the Larch", JutsuRank.B, KekkeiGenkaiJutsu::larch),
				new Def("Dance of the Clematis: Vine", JutsuRank.B, KekkeiGenkaiJutsu::clematisVine),
				new Def("Dance of the Clematis: Flower", JutsuRank.A, KekkeiGenkaiJutsu::clematis),
				new Def("Dance of the Seedling Fern", JutsuRank.S, KekkeiGenkaiJutsu::seedlingFern));
		nature("dust", "Dust Release", v -> v.dustreleaselogic, v -> v.dusttechnique, (v, i) -> v.dusttechnique = i, v -> v.dustlearn,
				(v, i) -> v.dustlearn = i, v -> v.dustrelease, (v, i) -> v.dustrelease = i,
				new Def("Split Detachment of the Primitive World Technique", JutsuRank.A, KekkeiGenkaiJutsu::splitDust),
				new Def("Detachment of the Primitive World Technique", JutsuRank.A, p -> dust(p, 1.6F, 1.0F, 26, 5)),
				new Def("Detachment of the Primitive World Technique Area", JutsuRank.S, KekkeiGenkaiJutsu::dustArea));
		nature("ice", "Ice Release", v -> v.icereleaselogic, v -> v.icetechnique, (v, i) -> v.icetechnique = i, v -> v.icelearn,
				(v, i) -> v.icelearn = i, v -> v.ice_release, (v, i) -> v.ice_release = i,
				new Def("Certain-Kill Ice Spears", JutsuRank.C, KekkeiGenkaiJutsu::iceSpears),
				new Def("Swallow Snow Storm", JutsuRank.C, KekkeiGenkaiJutsu::snowSwallows),
				new Def("Demonic Mirroring Ice Crystals", JutsuRank.B, KekkeiGenkaiJutsu::iceMirrors),
				new Def("Ice Rock Dome of Magnificent Nothingness", JutsuRank.A, KekkeiGenkaiJutsu::iceDome),
				new Def("Black Dragon Blizzard", JutsuRank.A, KekkeiGenkaiJutsu::blizzard));
		nature("magnet", "Magnet Release", v -> v.magnetreleaselogic, v -> v.magnettechnique, (v, i) -> v.magnettechnique = i, v -> v.magnetlearn,
				(v, i) -> v.magnetlearn = i, v -> v.magnet_release, (v, i) -> v.magnet_release = i,
				new Def("Black Iron Fist", JutsuRank.C, KekkeiGenkaiJutsu::ironFist),
				new Def("Iron Sand Drizzle", JutsuRank.B, KekkeiGenkaiJutsu::drizzle),
				new Def("Iron Sand Wall", JutsuRank.B, KekkeiGenkaiJutsu::ironSandWall),
				new Def("Iron Sand Gathering Assault", JutsuRank.B, KekkeiGenkaiJutsu::gatheringAssault),
				new Def("Iron Sand: Black Iron Wings", JutsuRank.A, KekkeiGenkaiJutsu::ironWings),
				new Def("Iron Sand World Method", JutsuRank.S, KekkeiGenkaiJutsu::worldMethod));
		nature("smoke", "Smoke Release", v -> v.smokereleaselogic, v -> v.smoketechnique, (v, i) -> v.smoketechnique = i, v -> v.smokelearn,
				(v, i) -> v.smokelearn = i, v -> v.smokerelease, (v, i) -> v.smokerelease = i,
				new Def("Dark Spike Bullet", JutsuRank.C, KekkeiGenkaiJutsu::smokeGun),
				new Def("Vapor Blade", JutsuRank.C, KekkeiGenkaiJutsu::vaporBlade),
				new Def("Black Burst", JutsuRank.B, KekkeiGenkaiJutsu::smokeFist),
				new Def("Erupting Smoke", JutsuRank.B, KekkeiGenkaiJutsu::eruptingSmoke),
				new Def("Demonic Illusion: Drowning in Smoke", JutsuRank.A, KekkeiGenkaiJutsu::drowningInSmoke),
				new Def("Hiding with Smoke Technique", JutsuRank.A, KekkeiGenkaiJutsu::smokeForm));
		nature("steel", "Steel Release", v -> v.steelreleaselogic, v -> v.steeltechnique, (v, i) -> v.steeltechnique = i, v -> v.steellearn,
				(v, i) -> v.steellearn = i, v -> v.steelrelease, (v, i) -> v.steelrelease = i,
				new Def("Steel Projectile", JutsuRank.C, KekkeiGenkaiJutsu::steelProjectile),
				new Def("Steel Blades Technique", JutsuRank.B, KekkeiGenkaiJutsu::steelBlades, "Taijutsu"),
				new Def("Steel Shield Technique", JutsuRank.B, KekkeiGenkaiJutsu::steelShield),
				new Def("Impervious Armour", JutsuRank.A, p -> armor(p, Element.STEEL, 200, 3)));
		nature("storm", "Storm Release", v -> v.stormreleaselogic, v -> v.stormtechnique, (v, i) -> v.stormtechnique = i, v -> v.stormlearn,
				(v, i) -> v.stormlearn = i, v -> v.storm_release, (v, i) -> v.storm_release = i,
				new Def("Laser Circus", JutsuRank.B, KekkeiGenkaiJutsu::laserCircus),
				new Def("Black Hunting", JutsuRank.B, KekkeiGenkaiJutsu::blackHunting),
				new Def("Thunder Cloud Inner Wave", JutsuRank.A, KekkeiGenkaiJutsu::thunderCloud));
		nature("swift", "Swift Release", v -> v.swiftreleaselogic, v -> 0, (v, i) -> {
		}, v -> v.swiftlearn, (v, i) -> v.swiftlearn = i, v -> v.swiftrelease, (v, i) -> v.swiftrelease = i,
				new Def("Shadowless Flight", JutsuRank.A, KekkeiGenkaiJutsu::shadowlessFlight));
		nature("typhoon", "Typhoon Release", v -> v.typhoonreleaslogic, v -> v.typhoontechnique, (v, i) -> v.typhoontechnique = i,
				v -> v.typhoonlearn, (v, i) -> v.typhoonlearn = i, v -> v.typhoonrelease, (v, i) -> v.typhoonrelease = i,
				new Def("Consecutive Bursting Strong Winds", JutsuRank.B, KekkeiGenkaiJutsu::burstingWinds),
				new Def("Great Consecutive Bursting Extreme Winds", JutsuRank.A, KekkeiGenkaiJutsu::tornado));
		nature("wood", "Wood Release", v -> v.woodreleaselogic, v -> v.woodtechnique, (v, i) -> v.woodtechnique = i, v -> v.woodlearn,
				(v, i) -> v.woodlearn = i, v -> v.wood_release, (v, i) -> v.wood_release = i,
				new Def("Wood Spikes Ring", JutsuRank.C, KekkeiGenkaiJutsu::woodSpikesRing),
				new Def("Tree Bind Flourishing Burial", JutsuRank.B, KekkeiGenkaiJutsu::treeBind),
				new Def("Four-Pillar Prison Technique", JutsuRank.A, KekkeiGenkaiJutsu::fourPillarPrison),
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

	/**
	 * Demonic Mirroring Ice Crystals: a dome of framed ice mirrors rises round the enemy looked at. Nobody inside gets out, and
	 * needles of ice fly from the mirrors into everyone trapped until the dome shatters.
	 */
	private static void iceMirrors(ServerPlayer p) {
		ServerLevel level = level(p);
		LivingEntity aimed = ClanJutsu.target(p, 18);
		Vec3 look = aimed != null ? aimed.position() : lookPoint(p, 18);
		BlockPos floor = ground(level, look.x, look.y, look.z);
		Vec3 c = new Vec3(look.x, floor.getY(), look.z);
		int life = 140;
		BlockState glass = Blocks.ICE.defaultBlockState(), frost = Blocks.SNOW_BLOCK.defaultBlockState();
		List<Vec3> mirrors = new ArrayList<>();
		// rows: mirrors, radius, height, inward lean
		double[][] rows = { { 10, 4.2, 0.1, 0 }, { 10, 3.9, 2.55, 0.35 }, { 5, 2.5, 4.6, 0.95 } };
		int delay = 0;
		for (int row = 0; row < rows.length; row++) {
			int count = (int) rows[row][0];
			for (int i = 0; i < count; i++) {
				double a = i * Math.PI * 2 / count + row * Math.PI / count;
				double r = rows[row][1];
				Vec3 at = c.add(Math.cos(a) * r, rows[row][2], Math.sin(a) * r);
				float yaw = (float) (Math.PI / 2 - a), lean = (float) -rows[row][3];
				int wait = delay++;
				after(level, wait, () -> {
					Displays.grow(level, at, glass, Displays.box(yaw, lean, 1.6F, 2.3F, 0.08F), 8, life - wait, true);
					Displays.grow(level, at, frost, Displays.box(yaw, lean, -0.82F, 0, 0.14F, 2.3F, 0.14F), 8, life - wait, true);
					Displays.grow(level, at, frost, Displays.box(yaw, lean, 0.82F, 0, 0.14F, 2.3F, 0.14F), 8, life - wait, true);
					Displays.grow(level, at, frost, Displays.box(yaw, lean, 0, 2.24F, 1.78F, 0.14F, 0.14F), 8, life - wait, true);
					Displays.grow(level, at, frost, Displays.box(yaw, lean, 0, -0.06F, 1.78F, 0.14F, 0.14F), 8, life - wait, true);
					level.sendParticles(ParticleTypes.SNOWFLAKE, at.x, at.y + 1.1, at.z, 8, 0.4, 0.8, 0.4, 0.02);
				});
				// the middle of the mirror, a little inside the dome
				mirrors.add(at.add(0, 1.15 - rows[row][3], 0).add(new Vec3(c.x - at.x, 0, c.z - at.z).normalize().scale(0.3)));
			}
		}
		sound(level, c, SoundEvents.GLASS_PLACE, 2, 0.6F);
		sound(level, c, SoundEvents.POWDER_SNOW_PLACE, 2, 0.5F);
		channel(p, life, 1, t -> {
			List<LivingEntity> inside = enemies(level, p, new AABB(c, c).inflate(5.5, 6, 5.5), e -> e.getY() >= c.y - 1);
			inside.removeIf(e -> e.position().subtract(c).horizontalDistance() > 5.5);
			for (LivingEntity target : inside) {
				Vec3 from = target.position().subtract(c).multiply(1, 0, 1);
				target.addEffect(new MobEffectInstance(MobEffects.SLOWNESS, 10, 1, false, false));
				if (from.length() > 3.2) {
					// the mirrors let nobody out
					Vec3 in = from.normalize().scale(-0.35);
					target.setDeltaMovement(in.x, target.getDeltaMovement().y, in.z);
					target.syncVelocity = true;
				}
			}
			if (t < 16 || t % 4 != 0 || inside.isEmpty())
				return;
			Vec3 from = mirrors.get(level.getRandom().nextInt(mirrors.size()));
			LivingEntity target = inside.get(level.getRandom().nextInt(inside.size()));
			Vec3 aim = target.getBoundingBox().getCenter().subtract(from).normalize().scale(1.7);
			JutsuProjectile needle = ClanJutsu.spawn(p, Element.ICE, Shape.NEEDLE, 0.22F, from, aim, 3);
			needle.life = 12;
			needle.knockback = 0.05F;
			level.sendParticles(ParticleTypes.END_ROD, from.x, from.y, from.z, 4, 0.3, 0.5, 0.3, 0.02);
			sound(level, from, SoundEvents.AMETHYST_BLOCK_BREAK, 0.6F, 1.8F);
		});
		after(level, life, () -> {
			sound(level, c, SoundEvents.GLASS_BREAK, 2, 0.8F);
			for (Vec3 m : mirrors)
				level.sendParticles(Element.ICE.puff, m.x, m.y, m.z, 12, 0.5, 0.8, 0.5, 0.1);
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
		// the iron sand arms (their model) for a second, unless a coat or wings are on
		if (NarutoShippudenModVariables.get(p).magnet_coat == 0)
			ClanJutsu.flag(p, 100, v -> v.magnet_coat = 2, v -> {
				if (v.magnet_coat == 2)
					v.magnet_coat = 0;
			});
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

	private static final net.minecraft.resources.Identifier IRON_WINGS = net.minecraft.resources.Identifier.fromNamespaceAndPath("naruto_shippuden",
			"iron_sand_wings");

	/**
	 * Iron Sand: Black Iron Wings: wings of iron sand for twenty seconds. They glide like an elytra (jump in mid-air to spread them)
	 * and beat to carry the caster along their look, like Butterfly Mode's.
	 */
	private static void ironWings(ServerPlayer p) {
		Vec3 look = p.getLookAngle().multiply(1, 0, 1).normalize();
		p.setDeltaMovement(look.x * 0.5, 0.9, look.z * 0.5);
		p.syncVelocity = true;
		sound(level(p), p.position(), SoundEvents.PHANTOM_FLAP, 1.5F, 0.6F);
		net.minecraft.world.entity.ai.attributes.AttributeInstance glide = p.getAttribute(net.neoforged.neoforge.common.NeoForgeMod.GLIDING_FLIGHT);
		ClanJutsu.mode(p, 400, 1, v -> {
			v.magnet_coat = 3;
			if (glide != null && !glide.hasModifier(IRON_WINGS))
				glide.addTransientModifier(new net.minecraft.world.entity.ai.attributes.AttributeModifier(IRON_WINGS, 1,
						net.minecraft.world.entity.ai.attributes.AttributeModifier.Operation.ADD_VALUE));
		}, v -> {
			v.magnet_coat = 0;
			if (glide != null)
				glide.removeModifier(IRON_WINGS);
		}, t -> {
			if (t % 10 == 0)
				ClanJutsu.keep(p, MobEffects.RESISTANCE, 1);
			// the wings beat: while gliding they carry the caster along their look (climbing too)
			if (p.isFallFlying() && t % 2 == 0) {
				Vec3 dir = p.getLookAngle(), motion = p.getDeltaMovement();
				Vec3 pushed = motion.add(dir.scale(0.09)).add(dir.scale(1.1).subtract(motion).scale(0.07));
				p.setDeltaMovement(pushed.length() > 1.5 ? pushed.normalize().scale(1.5) : pushed);
				p.syncVelocity = true;
			}
			// feathers of iron sand drifting down from the wings
			if (t % 2 == 0) {
				Vec3 side = new Vec3(-Math.cos(Math.toRadians(p.getYRot())), 0, -Math.sin(Math.toRadians(p.getYRot())));
				for (int k = -1; k <= 1; k += 2) {
					Vec3 at = p.position().add(side.scale(k * (1.5 + p.getRandom().nextDouble() * 2.5)));
					level(p).sendParticles(Element.MAGNET.trail, at.x, at.y + 0.5 + p.getRandom().nextDouble() * 1.5, at.z, 2, 0.4, 0.3, 0.4, 0.01);
				}
			}
		});
		p.sendOverlayMessage(net.minecraft.network.chat.Component.literal("Jump in mid-air to spread your wings"));
	}

	// ------------------------------------------------------------------ smoke
	/** Smoke Release: Dark Spike Bullet: a spike of hardened smoke that bursts into a blinding cloud. */
	private static void smokeGun(ServerPlayer p) {
		JutsuProjectile shell = shoot(p, Element.SMOKE, Shape.NEEDLE, 0.5F, 1.8F, 8);
		shell.onImpact = s -> {
			burst(level(p), s.position(), 3, 5, 0.3F, Element.SMOKE, s);
			level(p).sendParticles(ParticleTypes.CAMPFIRE_COSY_SMOKE, s.getX(), s.getY(), s.getZ(), 30, 1.5, 1, 1.5, 0.01);
		};
		sound(level(p), p.getEyePosition(), SoundEvents.FIRECHARGE_USE, 1, 0.6F);
	}

	/** Smoke Release: Black Burst: a heavy fist of black smoke that sends enemies flying. */
	private static void smokeFist(ServerPlayer p) {
		JutsuProjectile fist = shoot(p, Element.SMOKE, Shape.ORB, 1.6F, 1.2F, 13);
		fist.life = 16;
		fist.pierce = 2;
		fist.knockback = 2.5F;
		sound(level(p), p.getEyePosition(), SoundEvents.FIRECHARGE_USE, 1.5F, 0.5F);
	}

	/** Hiding with Smoke Technique: the caster's body turns to smoke for ten seconds: invisible, fast, and hard to hit. */
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
	/** Three blasts of wind in quick succession, each a spiralling wave of air that hurls everything back. */
	private static void burstingWinds(ServerPlayer p) {
		ServerLevel level = level(p);
		channel(p, 15, 5, t -> {
			Vec3 look = p.getLookAngle(), eye = p.getEyePosition();
			for (LivingEntity target : cone(p, 11, 30)) {
				damage(p, target, 5, Element.WIND);
				target.push(look.x * 1.6, 0.4, look.z * 1.6);
				target.syncVelocity = true;
			}
			JutsuProjectile core = shoot(p, Element.WIND, Shape.ORB, 1.3F, 1.8F, 0);
			core.life = 6;
			core.pierce = -1;
			core.knockback = 0;
			// the wave rolls forward over a few ticks as widening rings of air
			Vec3 up = Math.abs(look.y) > 0.95 ? new Vec3(1, 0, 0) : new Vec3(0, 1, 0);
			Vec3 side = look.cross(up).normalize(), top = side.cross(look).normalize();
			channel(p, 6, 1, k -> {
				double d = 1.5 + k * 1.7, r = 0.6 + d * 0.32;
				Vec3 centre = eye.add(look.scale(d));
				for (int i = 0; i < 18; i++) {
					double a = i * Math.PI / 9 + k * 0.5 + t;
					Vec3 out = side.scale(Math.cos(a)).add(top.scale(Math.sin(a)));
					Vec3 at = centre.add(out.scale(r)), v = look.scale(0.6).add(out.scale(0.15));
					level.sendParticles(ParticleTypes.CLOUD, at.x, at.y, at.z, 0, v.x, v.y, v.z, 0.5);
				}
				level.sendParticles(ParticleTypes.GUST, centre.x, centre.y, centre.z, 1, r * 0.4, r * 0.4, r * 0.4, 0);
				level.sendParticles(ParticleTypes.SWEEP_ATTACK, centre.x, centre.y, centre.z, 2, r * 0.5, r * 0.5, r * 0.5, 0);
			});
			sound(level, eye, SoundEvents.WIND_CHARGE_BURST.value(), 1.2F, 0.7F + t * 0.02F);
			sound(level, eye, SoundEvents.BREEZE_SHOOT, 1, 0.6F);
		});
	}

	/**
	 * A tornado where the caster looks, drifting the way they faced: a spinning funnel of wind and torn-up ground that sucks
	 * enemies in, lifts them and spins them for four seconds.
	 */
	private static void tornado(ServerPlayer p) {
		ServerLevel level = level(p);
		Vec3 start = lookPoint(p, 24), drift = p.getLookAngle().multiply(1, 0, 1).normalize().scale(0.06);
		BlockState dirt = level.getBlockState(BlockPos.containing(start).below());
		BlockParticleOption debris = new BlockParticleOption(ParticleTypes.BLOCK, dirt.isAir() ? Blocks.DIRT.defaultBlockState() : dirt);
		sound(level, start, SoundEvents.BREEZE_WIND_CHARGE_BURST.value(), 2, 0.5F);
		channel(p, 80, 1, t -> {
			Vec3 at = start.add(drift.scale(t));
			for (int arm = 0; arm < 5; arm++)
				for (int k = 0; k < 7; k++) {
					double y = (k + level.getRandom().nextDouble()) * 1.5, r = 0.4 + y * 0.4, a = t * 0.55 + arm * Math.PI * 2 / 5 + y * 0.6;
					level.sendParticles(k % 3 == 0 ? ParticleTypes.POOF : ParticleTypes.CLOUD, at.x + Math.cos(a) * r, at.y + y, at.z + Math.sin(a) * r, 0,
							-Math.sin(a), 0.15, Math.cos(a), 0.35);
				}
			for (int i = 0; i < 6; i++) {
				double a = level.getRandom().nextDouble() * Math.PI * 2, r = 1.2 + level.getRandom().nextDouble() * 2.5;
				level.sendParticles(debris, at.x + Math.cos(a) * r, at.y + 0.2, at.z + Math.sin(a) * r, 0, -Math.sin(a) * 0.3, 0.5, Math.cos(a) * 0.3, 1);
			}
			if (t % 3 == 0)
				level.sendParticles(ParticleTypes.GUST, at.x, at.y + 1 + level.getRandom().nextDouble() * 7, at.z, 1, 1, 0.5, 1, 0);
			if (t % 10 == 0)
				sound(level, at, SoundEvents.BREEZE_IDLE_AIR, 1.5F, 0.5F);
			for (LivingEntity target : enemies(level, p, new AABB(at, at).inflate(5, 9, 5), e -> true)) {
				Vec3 in = at.subtract(target.position()).multiply(1, 0, 1).scale(0.1);
				Vec3 spin = new Vec3(-in.z, 0, in.x).scale(2.2);
				double height = target.getY() - at.y;
				target.setDeltaMovement(in.x + spin.x, height < 6 ? 0.22 : 0.02, in.z + spin.z);
				target.syncVelocity = true;
				target.fallDistance = 0;
				if (t % 8 == 0)
					damage(p, target, 3, Element.WIND);
			}
		});
	}

	// ------------------------------------------------------------------ wood
	/**
	 * Tree Bind Flourishing Burial: roots spiral up out of the ground round each enemy near the spot looked at, close in and grow
	 * into a tree with them inside, holding and crushing them, then burst open.
	 */
	private static void treeBind(ServerPlayer p) {
		ServerLevel level = level(p);
		LivingEntity aimed = ClanJutsu.target(p, 20);
		Vec3 at = aimed != null ? aimed.position() : lookPoint(p, 20);
		List<LivingEntity> caught = enemies(level, p, new AABB(at, at).inflate(3.5, 3, 3.5), e -> true);
		caught.sort((a, b) -> Double.compare(a.distanceToSqr(at), b.distanceToSqr(at)));
		sound(level, at, SoundEvents.WOOD_PLACE, 2, 0.5F);
		if (caught.isEmpty()) {
			BlockPos floor = ground(level, at.x, at.y, at.z);
			tree(p, new Vec3(at.x, floor.getY(), at.z), null);
			return;
		}
		for (LivingEntity target : caught.subList(0, Math.min(3, caught.size())))
			tree(p, target.position(), target);
	}

	private static void tree(ServerPlayer p, Vec3 base, @Nullable LivingEntity target) {
		ServerLevel level = level(p);
		int life = 160, grow = 20;
		BlockState log = Blocks.OAK_LOG.defaultBlockState(), leaves = Blocks.OAK_LEAVES.defaultBlockState();
		channel(p, grow, 1, t -> {
			for (int arm = 0; arm < 4; arm++) {
				double a = arm * Math.PI / 2 + t * 0.42, r = 0.45 + 1.5 * (1 - t / (double) grow), y = t * 0.17 - 0.4;
				Vec3 at = base.add(Math.cos(a) * r, y, Math.sin(a) * r);
				Displays.grow(level, at, log, Displays.box((float) -a, 0.5F, 0.55F, 0.75F, 0.55F), 3, life - t, false);
			}
			if (t % 4 == 0) {
				sound(level, base, SoundEvents.WOOD_PLACE, 1, 0.6F + t * 0.02F);
				level.sendParticles(Element.WOOD.puff, base.x, base.y + 0.2, base.z, 6, 1, 0.1, 1, 0.05);
			}
		});
		after(level, grow, () -> {
			// the crown bursts into leaf over the top
			for (int i = 0; i < 26; i++) {
				double a = level.getRandom().nextDouble() * Math.PI * 2, u = level.getRandom().nextDouble() * 2 - 1;
				double h = Math.sqrt(1 - u * u) * 1.5;
				Vec3 at = base.add(Math.cos(a) * h, 3.6 + u * 1.1, Math.sin(a) * h);
				Displays.grow(level, at, leaves, Displays.box((float) a, (float) (u * 0.6), 0.95F, 0.95F, 0.95F), 5, life - grow, false);
			}
			sound(level, base, SoundEvents.AZALEA_LEAVES_PLACE, 2, 0.6F);
		});
		if (target == null)
			return;
		channel(p, life, 1, t -> {
			if (!target.isAlive())
				return;
			Vec3 to = base.subtract(target.position());
			target.setDeltaMovement(to.x * 0.5, Math.min(0, target.getDeltaMovement().y), to.z * 0.5);
			target.syncVelocity = true;
			target.addEffect(new MobEffectInstance(MobEffects.SLOWNESS, 10, 6, false, false));
			if (t % 20 == 0 && t > 0)
				damage(p, target, 3, Element.WOOD);
			if (t == life - 1) {
				damage(p, target, 12, Element.WOOD);
				puff(level, target.position().add(0, 1, 0), Element.WOOD, 2);
				sound(level, base, SoundEvents.WOOD_BREAK, 2, 0.5F);
			}
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

	// ------------------------------------------------------------------ added from the wiki
	/** Erupting Propulsion Fist: steam bursts from the elbow and drives a punch that sends everything in front flying. */
	private static void eruptingFist(ServerPlayer p) {
		ServerLevel level = level(p);
		Vec3 look = p.getLookAngle().multiply(1, 0, 1).normalize();
		p.setDeltaMovement(look.x * 1.2, 0.1, look.z * 1.2);
		p.syncVelocity = true;
		after(level, 4, () -> {
			for (LivingEntity target : cone(p, 4.5, 40)) {
				damage(p, target, 16, Element.BOIL);
				target.push(look.x * 3, 0.7, look.z * 3);
				target.syncVelocity = true;
			}
			Vec3 at = p.getEyePosition().add(look.scale(1.5));
			level.sendParticles(ParticleTypes.WHITE_SMOKE, at.x, at.y, at.z, 40, 0.6, 0.6, 0.6, 0.15);
			level.sendParticles(ParticleTypes.EXPLOSION, at.x, at.y, at.z, 1, 0, 0, 0, 0);
			sound(level, at, SoundEvents.GENERIC_EXPLODE.value(), 1, 1.4F);
		});
		sound(level, p.position(), SoundEvents.LAVA_EXTINGUISH, 1.5F, 0.7F);
	}

	/** Steam Explosion: the steam built up in the body bursts out all at once, scalding and blasting everything around. */
	private static void steamExplosion(ServerPlayer p) {
		ServerLevel level = level(p);
		Vec3 c = p.position().add(0, 1, 0);
		sound(level, c, SoundEvents.LAVA_EXTINGUISH, 2, 0.5F);
		after(level, 8, () -> {
			burst(level, c, 5.5F, 14, 2, Element.BOIL, p);
			level.sendParticles(ParticleTypes.WHITE_SMOKE, c.x, c.y, c.z, 150, 2.5, 1.5, 2.5, 0.2);
			level.sendParticles(ParticleTypes.CLOUD, c.x, c.y, c.z, 60, 2, 1, 2, 0.3);
			field(p, p.position(), 5, 80, 5, Element.BOIL, (target, t) -> {
				if (t % 20 == 0)
					damage(p, target, 2, Element.BOIL);
			});
		});
		channel(p, 8, 1, t -> level.sendParticles(ParticleTypes.WHITE_SMOKE, c.x, c.y, c.z, 6, 0.4, 0.8, 0.4, 0.05));
	}

	/** Dance of the Willow: bones burst out of the arms and shoulders and slash everything around the caster. */
	private static void willow(ServerPlayer p) {
		ServerLevel level = level(p);
		for (LivingEntity target : enemies(level, p, p.getBoundingBox().inflate(3.5), e -> e.distanceToSqr(p) < 3.5 * 3.5)) {
			damage(p, target, 10, Element.BONE);
			Vec3 away = target.position().subtract(p.position()).multiply(1, 0, 1).normalize();
			target.push(away.x * 0.8, 0.3, away.z * 0.8);
			target.syncVelocity = true;
		}
		for (int i = 0; i < 12; i++) {
			double a = i * Math.PI / 6;
			level.sendParticles(ParticleTypes.SWEEP_ATTACK, p.getX() + Math.cos(a) * 2, p.getY() + 1, p.getZ() + Math.sin(a) * 2, 1, 0, 0, 0, 0);
		}
		level.sendParticles(Element.BONE.puff, p.getX(), p.getY() + 1, p.getZ(), 20, 0.6, 0.6, 0.6, 0.1);
		sound(level, p.position(), SoundEvents.BONE_BLOCK_BREAK, 1.5F, 0.8F);
		sound(level, p.position(), SoundEvents.PLAYER_ATTACK_SWEEP, 1.2F, 0.7F);
	}

	/** Dance of the Larch: spikes of bone jut out all over the body for eight seconds; whoever comes close is impaled. */
	private static void larch(ServerPlayer p) {
		ServerLevel level = level(p);
		sound(level, p.position(), SoundEvents.BONE_BLOCK_BREAK, 2, 0.6F);
		java.util.Map<LivingEntity, Integer> last = new java.util.HashMap<>();
		channel(p, 160, 2, t -> {
			if (t % 10 == 0)
				p.addEffect(new MobEffectInstance(MobEffects.RESISTANCE, 12, 2, false, false, true));
			level.sendParticles(Element.BONE.trail, p.getX(), p.getY() + 1, p.getZ(), 3, 0.5, 0.8, 0.5, 0.02);
			for (LivingEntity target : enemies(level, p, p.getBoundingBox().inflate(1.6), e -> last.getOrDefault(e, -99) + 10 <= t)) {
				last.put(target, t);
				damage(p, target, 5, Element.BONE);
				level.sendParticles(Element.BONE.puff, target.getX(), target.getY() + 1, target.getZ(), 8, 0.3, 0.4, 0.3, 0.05);
			}
		});
	}

	/** Dance of the Clematis: Vine: a whip of spine lashes out, wraps the first enemy in reach and drags them in. */
	private static void clematisVine(ServerPlayer p) {
		ServerLevel level = level(p);
		LivingEntity target = ClanJutsu.target(p, 12);
		Vec3 hand = p.getEyePosition().subtract(0, 0.4, 0);
		sound(level, hand, SoundEvents.SKELETON_SHOOT, 1.2F, 0.5F);
		if (target == null) {
			Techniques.line(level, Element.BONE.puff, hand, lookPoint(p, 12), 0.4);
			return;
		}
		damage(p, target, 9, Element.BONE);
		channel(p, 10, 1, t -> {
			if (!target.isAlive())
				return;
			Vec3 pull = hand.subtract(target.getBoundingBox().getCenter());
			if (pull.length() > 1.8) {
				target.setDeltaMovement(pull.normalize().scale(0.9));
				target.syncVelocity = true;
			}
			Techniques.line(level, Element.BONE.puff, hand, target.getBoundingBox().getCenter(), 0.35);
		});
	}

	/** Split Detachment of the Primitive World: five small cubes fanned out, each erasing what it touches. */
	private static void splitDust(ServerPlayer p) {
		for (int i = -2; i <= 2; i++) {
			JutsuProjectile cube = shoot(p, Element.DUST, Shape.CUBE, 0.6F, turned(p, i * 9, 0).scale(1.6), 9);
			cube.life = 50;
			cube.onImpact = c -> {
				ServerLevel level = level(p);
				burst(level, c.position(), 2.2F, 9, 0.3F, Element.DUST, c);
				level.sendParticles(ParticleTypes.END_ROD, c.getX(), c.getY(), c.getZ(), 40, 1, 1, 1, 0.1);
			};
		}
		sound(level(p), p.getEyePosition(), SoundEvents.BEACON_ACTIVATE, 1.5F, 1.8F);
	}

	/** Detachment of the Primitive World Technique Area: a cube of dust swells over the whole area looked at and erases it. */
	private static void dustArea(ServerPlayer p) {
		ServerLevel level = level(p);
		Vec3 at = lookPoint(p, 30).add(0, 1, 0);
		JutsuProjectile cube = ClanJutsu.spawn(p, Element.DUST, Shape.CUBE, 0.5F, at, Vec3.ZERO, 0);
		cube.pierce = -1;
		cube.knockback = 0;
		cube.life = 50;
		sound(level, at, SoundEvents.BEACON_ACTIVATE, 2, 0.8F);
		channel(p, 30, 1, t -> {
			float size = 0.5F + t * 0.45F;
			cube.look(Element.DUST, Shape.CUBE, size);
			cube.setPos(at.subtract(0, size / 2, 0));
			for (LivingEntity target : enemies(level, p, new AABB(at, at).inflate(size / 2), e -> true))
				target.addEffect(new MobEffectInstance(MobEffects.SLOWNESS, 10, 4, false, false));
		});
		after(level, 30, () -> {
			burst(level, at, 7.5F, 40, 0.3F, Element.DUST, cube);
			cube.discard();
			level.sendParticles(ParticleTypes.END_ROD, at.x, at.y, at.z, 300, 3.5, 3.5, 3.5, 0.2);
			level.sendParticles(ParticleTypes.EXPLOSION_EMITTER, at.x, at.y, at.z, 1, 0, 0, 0, 0);
			sound(level, at, SoundEvents.GENERIC_EXPLODE.value(), 2.5F, 1.6F);
		});
	}

	/** Swallow Snow Storm: a flock of ice swallows darts out and hunts down enemies, freezing them. */
	private static void snowSwallows(ServerPlayer p) {
		channel(p, 20, 2, t -> {
			JutsuProjectile swallow = shoot(p, Element.ICE, Shape.NEEDLE, 0.3F,
					turned(p, (level(p).getRandom().nextFloat() - 0.5F) * 50, (level(p).getRandom().nextFloat() - 0.2F) * 25).scale(1.3), 4);
			swallow.homing = 0.3F;
			swallow.life = 50;
			swallow.knockback = 0.1F;
			sound(level(p), p.getEyePosition(), SoundEvents.POWDER_SNOW_STEP, 0.8F, 1.8F);
		});
	}

	/**
	 * Ice Rock Dome of Magnificent Nothingness: a dome of thick ice closes over the enemy looked at: nobody inside gets out, and they
	 * freeze slowly for six seconds.
	 */
	private static void iceDome(ServerPlayer p) {
		ServerLevel level = level(p);
		LivingEntity aimed = ClanJutsu.target(p, 20);
		Vec3 look = aimed != null ? aimed.position() : lookPoint(p, 20);
		Vec3 c = new Vec3(look.x, ground(level, look.x, look.y, look.z).getY(), look.z);
		int life = 120;
		BlockPos centre = BlockPos.containing(c);
		// a dome of packed ice, built up from the ground
		for (int layer = 0; layer <= 4; layer++) {
			int y = layer;
			after(level, layer * 2, () -> {
				for (int dx = -4; dx <= 4; dx++)
					for (int dz = -4; dz <= 4; dz++) {
						double d = Math.sqrt(dx * dx + y * y * 1.1 + dz * dz);
						if (d >= 2.9 && d < 3.9)
							place(level, centre.offset(dx, y, dz), Blocks.PACKED_ICE.defaultBlockState(), life - y * 2, OPEN);
					}
			});
		}
		sound(level, c, SoundEvents.GLASS_PLACE, 2, 0.5F);
		channel(p, life, 2, t -> {
			for (LivingEntity target : enemies(level, p, new AABB(c, c).inflate(3.4, 4, 3.4), e -> e.position().subtract(c).horizontalDistance() < 3.4)) {
				target.addEffect(new MobEffectInstance(MobEffects.SLOWNESS, 10, 3, false, false));
				target.setTicksFrozen(Math.min(target.getTicksRequiredToFreeze() + 20, target.getTicksFrozen() + 6));
				Vec3 from = target.position().subtract(c).multiply(1, 0, 1);
				if (from.length() > 2.4) {
					Vec3 in = from.normalize().scale(-0.3);
					target.setDeltaMovement(in.x, target.getDeltaMovement().y, in.z);
					target.syncVelocity = true;
				}
				if (t % 20 == 0)
					damage(p, target, 3, Element.ICE);
			}
		});
		after(level, life, () -> {
			sound(level, c, SoundEvents.GLASS_BREAK, 2, 0.6F);
			level.sendParticles(Element.ICE.puff, c.x, c.y + 2, c.z, 60, 2.5, 1.5, 2.5, 0.1);
		});
	}

	/** Iron Sand Wall: iron sand sweeps up round the caster into a barrier for eight seconds that stops projectiles and blows. */
	private static void ironSandWall(ServerPlayer p) {
		ServerLevel level = level(p);
		sound(level, p.position(), SoundEvents.SAND_PLACE, 1.5F, 0.5F);
		ClanJutsu.shell(p, p, p.getBoundingBox().getCenter(), Element.MAGNET, 4.2F, 160);
		ClanJutsu.mode(p, 160, 1, v -> v.magnet_coat = 1, v -> v.magnet_coat = 0, t -> {
			if (t % 10 == 0)
				ClanJutsu.keep(p, MobEffects.RESISTANCE, 3);
			for (net.minecraft.world.entity.projectile.Projectile shot : level.getEntitiesOfClass(net.minecraft.world.entity.projectile.Projectile.class,
					p.getBoundingBox().inflate(2.6), e -> e.getOwner() != p)) {
				puff(level, shot.position(), Element.MAGNET, 0.5F);
				shot.discard();
			}
			if (t % 4 == 0)
				level.sendParticles(Element.MAGNET.trail, p.getX(), p.getY() + 1, p.getZ(), 6, 1.5, 1, 1.5, 0.02);
		});
	}

	/** Iron Sand Gathering Assault: a great mass of iron sand shoots forward and bursts into spikes where it strikes. */
	private static void gatheringAssault(ServerPlayer p) {
		ServerLevel level = level(p);
		JutsuProjectile mass = shoot(p, Element.MAGNET, Shape.ORB, 1.8F, 1.3F, 14);
		mass.life = 30;
		mass.knockback = 1.5F;
		mass.onImpact = m -> {
			burst(level, m.position(), 3, 8, 1, Element.MAGNET, m);
			for (int i = 0; i < 10; i++) {
				Vec3 dir = new Vec3(level.getRandom().nextGaussian(), Math.abs(level.getRandom().nextGaussian()) * 0.6, level.getRandom().nextGaussian()).normalize();
				JutsuProjectile spike = ClanJutsu.spawn(p, Element.MAGNET, Shape.NEEDLE, 0.3F, m.position().add(0, 0.5, 0), dir.scale(1.2), 4);
				spike.life = 8;
			}
			sound(level, m.position(), SoundEvents.CHAIN_BREAK, 1.5F, 0.5F);
		};
		sound(level, p.getEyePosition(), SoundEvents.SAND_FALL, 2, 0.6F);
	}

	/** Iron Sand World Method: iron sand spreads out from the caster in a web of spikes in every direction ahead. */
	private static void worldMethod(ServerPlayer p) {
		ServerLevel level = level(p);
		sound(level, p.position(), SoundEvents.CHAIN_PLACE, 2, 0.4F);
		channel(p, 12, 2, t -> {
			for (int i = 0; i < 8; i++) {
				JutsuProjectile spike = shoot(p, Element.MAGNET, Shape.NEEDLE, 0.35F,
						turned(p, (level.getRandom().nextFloat() - 0.5F) * 110, (level.getRandom().nextFloat() - 0.5F) * 60).scale(1.8), 7);
				spike.pierce = 2;
				spike.life = 16;
				spike.knockback = 0.2F;
			}
			if (t % 4 == 0)
				sound(level, p.getEyePosition(), SoundEvents.SAND_FALL, 1.5F, 0.8F);
		});
	}

	/** Smoke Release: Vapor Blade: a wide blade of smoke sweeps the front, cutting and blinding. */
	private static void vaporBlade(ServerPlayer p) {
		ServerLevel level = level(p);
		Vec3 look = p.getLookAngle();
		for (LivingEntity target : cone(p, 6.5, 55)) {
			damage(p, target, 9, Element.SMOKE);
			target.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 60, 0, false, false));
		}
		for (int i = -4; i <= 4; i++) {
			Vec3 at = p.getEyePosition().add(turned(p, i * 12, 0).scale(3.5)).subtract(0, 0.3, 0);
			level.sendParticles(ParticleTypes.SWEEP_ATTACK, at.x, at.y, at.z, 1, 0, 0, 0, 0);
			level.sendParticles(ParticleTypes.LARGE_SMOKE, at.x, at.y, at.z, 4, 0.2, 0.2, 0.2, 0.02);
		}
		sound(level, p.position(), SoundEvents.PLAYER_ATTACK_SWEEP, 1.2F, 0.6F);
	}

	/** Smoke Release: Erupting Smoke: smoke erupts from the ground where the caster looks, throwing enemies up and choking them. */
	private static void eruptingSmoke(ServerPlayer p) {
		ServerLevel level = level(p);
		Vec3 at = lookPoint(p, 20);
		sound(level, at, SoundEvents.FIRE_EXTINGUISH, 2, 0.4F);
		channel(p, 20, 2, t -> level.sendParticles(ParticleTypes.CAMPFIRE_COSY_SMOKE, at.x, at.y, at.z, 10, 2.5, 0.2, 2.5, 0.06));
		for (LivingEntity target : enemies(level, p, new AABB(at, at).inflate(4, 3, 4), e -> e.distanceToSqr(at) < 20)) {
			damage(p, target, 11, Element.SMOKE);
			target.push(0, 1.1, 0);
			target.syncVelocity = true;
		}
	}

	/** Demonic Illusion: Drowning in Smoke: the enemy looked at breathes in smoke and believes they are drowning in it. */
	private static void drowningInSmoke(ServerPlayer p) {
		ServerLevel level = level(p);
		LivingEntity target = ClanJutsu.target(p, 16);
		if (target == null) {
			Jutsus.miss(p, "Look at an enemy");
			return;
		}
		sound(level, target.position(), SoundEvents.FIRE_EXTINGUISH, 1.5F, 0.5F);
		channel(p, 120, 2, t -> {
			if (!target.isAlive())
				return;
			ClanJutsu.hold(target);
			target.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 20, 0, false, false));
			target.addEffect(new MobEffectInstance(MobEffects.NAUSEA, 60, 0, false, false));
			target.setAirSupply(Math.max(-20, target.getAirSupply() - 8));
			level.sendParticles(ParticleTypes.LARGE_SMOKE, target.getX(), target.getEyeY(), target.getZ(), 4, 0.3, 0.3, 0.3, 0.01);
			if (t % 20 == 0)
				damage(p, target, 3, Element.SMOKE);
		});
	}

	/** Steel Blades Technique: the arms harden into blades of steel for twenty seconds; the first swing cuts everything in front. */
	private static void steelBlades(ServerPlayer p) {
		ServerLevel level = level(p);
		for (LivingEntity target : cone(p, 4.5, 60))
			damage(p, target, 11, Element.STEEL);
		Vec3 look = p.getLookAngle();
		for (int i = -2; i <= 2; i++) {
			Vec3 at = p.getEyePosition().add(turned(p, i * 18, 0).scale(2.5)).subtract(0, 0.3, 0);
			level.sendParticles(ParticleTypes.SWEEP_ATTACK, at.x, at.y, at.z, 1, 0, 0, 0, 0);
		}
		p.addEffect(new MobEffectInstance(MobEffects.STRENGTH, 400, 2, false, false, true));
		channel(p, 400, 6, t -> level.sendParticles(Element.STEEL.trail, p.getX(), p.getY() + 1, p.getZ(), 2, 0.5, 0.4, 0.5, 0.05));
		sound(level, p.position(), SoundEvents.ANVIL_USE, 1, 1.4F);
	}

	/** Steel Shield Technique: a wall of steel rises in front of the caster for eight seconds and stops everything thrown at it. */
	private static void steelShield(ServerPlayer p) {
		ServerLevel level = level(p);
		Vec3 dir = p.getLookAngle().multiply(1, 0, 1).normalize(), side = new Vec3(-dir.z, 0, dir.x), at = p.position().add(dir.scale(2));
		for (int s = -1; s <= 1; s++) {
			Vec3 column = at.add(side.scale(s));
			BlockPos base = ground(level, column.x, p.getY(), column.z);
			for (int h = 0; h < 3; h++)
				place(level, base.above(h), Blocks.IRON_BLOCK.defaultBlockState(), 160, OPEN);
		}
		sound(level, at, SoundEvents.ANVIL_PLACE, 1.2F, 0.7F);
	}

	/** Storm Release: Black Hunting: dark storm light strikes down on every enemy round the spot looked at. */
	private static void blackHunting(ServerPlayer p) {
		ServerLevel level = level(p);
		Vec3 at = lookPoint(p, 30);
		List<LivingEntity> prey = enemies(level, p, new AABB(at, at).inflate(9, 6, 9), e -> true);
		sound(level, at, SoundEvents.BEACON_DEACTIVATE, 2, 0.6F);
		for (int i = 0; i < 8; i++) {
			int n = i;
			after(level, i * 3, () -> {
				Vec3 hit = prey.isEmpty() || !prey.get(n % prey.size()).isAlive()
						? at.add((level.getRandom().nextDouble() - 0.5) * 12, 0, (level.getRandom().nextDouble() - 0.5) * 12)
						: prey.get(n % prey.size()).getBoundingBox().getCenter();
				JutsuProjectile beam = ClanJutsu.spawn(p, Element.STORM, Shape.NEEDLE, 0.4F, hit.add(0, 12, 0), new Vec3(0, -2.4, 0), 7);
				beam.life = 10;
				beam.onImpact = b -> puff(level, b.position(), Element.STORM, 0.8F);
			});
		}
	}

	/** Wood Release: Wood Spikes Ring: a ring of sharpened wooden stakes bursts out of the ground round the caster. */
	private static void woodSpikesRing(ServerPlayer p) {
		ServerLevel level = level(p);
		sound(level, p.position(), SoundEvents.WOOD_BREAK, 2, 0.5F);
		BlockPos c = p.blockPosition();
		java.util.Set<BlockPos> ring = new java.util.LinkedHashSet<>();
		// separate stakes, not a wall: ten close in, fourteen further out between them
		for (int ring2 = 0; ring2 < 2; ring2++) {
			int n = ring2 == 0 ? 10 : 14;
			double r = ring2 == 0 ? 3 : 5;
			for (int i = 0; i < n; i++) {
				double a = (i + ring2 * 0.5) * Math.PI * 2 / n;
				ring.add(BlockPos.containing(c.getX() + 0.5 + Math.cos(a) * r, p.getY(), c.getZ() + 0.5 + Math.sin(a) * r));
			}
		}
		for (BlockPos column : ring) {
			BlockPos base = ground(level, column.getX() + 0.5, p.getY(), column.getZ() + 0.5);
			int height = 1 + level.getRandom().nextInt(2);
			for (int h = 0; h < height; h++)
				place(level, base.above(h), Blocks.OAK_LOG.defaultBlockState(), 80, OPEN);
			// a sharpened point on top
			place(level, base.above(height), Blocks.OAK_FENCE.defaultBlockState(), 80, OPEN);
			level.sendParticles(Element.WOOD.puff, base.getX() + 0.5, base.getY() + 1, base.getZ() + 0.5, 3, 0.3, 0.5, 0.3, 0.05);
		}
		for (LivingEntity target : enemies(level, p, p.getBoundingBox().inflate(5.5, 2, 5.5), e -> e.distanceToSqr(p) < 36)) {
			damage(p, target, 10, Element.WOOD);
			target.push(0, 0.6, 0);
			target.syncVelocity = true;
		}
	}

	/** Wood Release: Four-Pillar Prison Technique: a cage of thick wooden bars grows up round the enemy looked at, trapping them. */
	private static void fourPillarPrison(ServerPlayer p) {
		ServerLevel level = level(p);
		LivingEntity aimed = ClanJutsu.target(p, 24);
		Vec3 look = aimed != null ? aimed.position() : lookPoint(p, 24);
		BlockPos c = ground(level, look.x, look.y, look.z);
		int life = 160;
		sound(level, Vec3.atCenterOf(c), SoundEvents.WOOD_PLACE, 2, 0.5F);
		// grows up a layer at a time: pillars at the corners and the middle of each side, bars between, and a roof
		channel(p, 5, 1, h -> {
			for (int dx = -2; dx <= 2; dx++)
				for (int dz = -2; dz <= 2; dz++) {
					BlockPos pos = c.offset(dx, h, dz);
					boolean edge = Math.abs(dx) == 2 || Math.abs(dz) == 2;
					if (h == 4)
						place(level, pos, Blocks.SPRUCE_PLANKS.defaultBlockState(), life - h, OPEN);
					else if (edge)
						place(level, pos, (dx == 0 || dz == 0 || Math.abs(dx) == Math.abs(dz)) ? Blocks.SPRUCE_LOG.defaultBlockState() : Blocks.SPRUCE_FENCE.defaultBlockState(),
								life - h, OPEN);
				}
			sound(level, Vec3.atCenterOf(c.above(h)), SoundEvents.WOOD_PLACE, 1.2F, 0.7F + h * 0.1F);
		});
	
	}
}
