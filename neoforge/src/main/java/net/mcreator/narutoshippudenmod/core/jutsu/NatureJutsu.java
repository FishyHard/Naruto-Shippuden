package net.mcreator.narutoshippudenmod.core.jutsu;

import static net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.burst;
import static net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.channel;
import static net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.cone;
import static net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.damage;
import static net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.enemies;
import static net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.line;
import static net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.lookPoint;
import static net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.place;
import static net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.puff;
import static net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.shoot;
import static net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.sound;
import static net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.spray;
import static net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.turned;

import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables;
import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables.PlayerVariables;
import net.mcreator.narutoshippudenmod.compat.Compat;
import net.mcreator.narutoshippudenmod.core.jutsu.engine.Element;
import net.mcreator.narutoshippudenmod.core.jutsu.engine.JutsuProjectile;
import net.mcreator.narutoshippudenmod.core.jutsu.engine.JutsuProjectile.Shape;
import net.mcreator.narutoshippudenmod.core.jutsu.engine.JutsuRank;
import net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques;
import net.mcreator.narutoshippudenmod.entity.SummonEntities.EarthGolemEntity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Mth;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.PointedDripstoneBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.SpeleothemThickness;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.ObjDoubleConsumer;
import java.util.function.Predicate;
import java.util.function.ToDoubleFunction;

/**
 * The five chakra natures, remade on the jutsu engine. Each nature has four jutsu, learned in order from its scroll (the price,
 * Ninjutsu, chakra and cooldown come from the jutsu's {@link JutsuRank}); damage grows with Ninjutsu. The old save variables
 * (learned count, selected jutsu, bought count) are kept, so existing progress carries over.
 */
final class NatureJutsu {
	private NatureJutsu() {
	}

	/** A jutsu of a release: its rank sets the price and the level of its stat (Ninjutsu unless given) it needs. */
	record Def(String name, JutsuRank rank, Consumer<ServerPlayer> cast, String stat) {
		Def(String name, JutsuRank rank, Consumer<ServerPlayer> cast) {
			this(name, rank, cast, "Ninjutsu");
		}

		ToDoubleFunction<PlayerVariables> statValue() {
			return switch (stat) {
				case "Taijutsu" -> v -> v.taijutsu;
				case "Summoning" -> v -> v.summoning;
				default -> v -> v.ninjutsu;
			};
		}
	}

	static void register() {
		nature("fire", "Fire", v -> v.firereleaselogic, v -> v.firetechnique, (v, i) -> v.firetechnique = i, v -> v.firelearn, (v, i) -> v.firelearn = i,
				v -> v.fire_release, (v, i) -> v.fire_release = i,
				new Def("Phoenix Sage Fire Technique", JutsuRank.D, NatureJutsu::phoenixSageFire),
				new Def("Great Fireball Technique", JutsuRank.C, NatureJutsu::greatFireball),
				new Def("Great Flame Technique", JutsuRank.B, NatureJutsu::greatFlame),
				new Def("Great Dragon Fire Technique", JutsuRank.A, p -> dragon(p, Element.FIRE, 16, 3.5F, 0.6F)),
				new Def("Great Fire Annihilation", JutsuRank.S, NatureJutsu::greatFireAnnihilation));
		nature("water", "Water", v -> v.waterreleaselogic, v -> v.water_technique, (v, i) -> v.water_technique = i, v -> v.waterlearn,
				(v, i) -> v.waterlearn = i, v -> v.water_release, (v, i) -> v.water_release = i,
				new Def("Water Gun Technique", JutsuRank.D, NatureJutsu::waterGun),
				new Def("Water Formation Wall", JutsuRank.C, NatureJutsu::waterWall),
				new Def("Water Prison Technique", JutsuRank.C, NatureJutsu::waterPrison),
				new Def("Water Shark Bullet Technique", JutsuRank.B, NatureJutsu::waterShark),
				new Def("Water Dragon Bullet Technique", JutsuRank.A, p -> dragon(p, Element.WATER, 18, 4, 2)),
				new Def("Great Waterfall Technique", JutsuRank.S, NatureJutsu::greatWaterfall));
		nature("wind", "Wind", v -> v.windreleaselogic, v -> v.wind_technique, (v, i) -> v.wind_technique = i, v -> v.windlearn, (v, i) -> v.windlearn = i,
				v -> v.wind_release, (v, i) -> v.wind_release = i,
				new Def("Gale Palm", JutsuRank.D, NatureJutsu::galePalm),
				new Def("Vacuum Sphere", JutsuRank.C, NatureJutsu::vacuumSphere),
				new Def("Great Breakthrough", JutsuRank.B, NatureJutsu::greatBreakthrough),
				new Def("Vacuum Great Sphere", JutsuRank.A, NatureJutsu::vacuumGreatSphere),
				new Def("Rasenshuriken", JutsuRank.S, NatureJutsu::rasenshuriken));
		nature("earth", "Earth", v -> v.earthreleaselogic, v -> v.earth_technique, (v, i) -> v.earth_technique = i, v -> v.earthlearn,
				(v, i) -> v.earthlearn = i, v -> v.earth_release, (v, i) -> v.earth_release = i,
				new Def("Double Suicide Decapitation Technique", JutsuRank.D, NatureJutsu::doubleSuicide),
				new Def("Rock Pillar Spears", JutsuRank.C, NatureJutsu::earthSpikes),
				new Def("Earth-Style Wall", JutsuRank.C, NatureJutsu::earthWall),
				new Def("Golem Technique", JutsuRank.B, NatureJutsu::earthGolem),
				new Def("Earth Dragon Bullet", JutsuRank.B, NatureJutsu::earthDragonBullet),
				new Def("Swamp of the Underworld", JutsuRank.A, NatureJutsu::swamp));
		nature("lightning", "Lightning", v -> v.lightningreleaselogic, v -> v.lightning_technique, (v, i) -> v.lightning_technique = i,
				v -> v.lightninglearn, (v, i) -> v.lightninglearn = i, v -> v.lightning_release, (v, i) -> v.lightning_release = i,
				new Def("Chidori Senbon", JutsuRank.D, NatureJutsu::chidoriSenbon),
				new Def("Lightning Beast Tracking Fang", JutsuRank.C, NatureJutsu::lightningBall),
				new Def("Lariat", JutsuRank.B, NatureJutsu::lariat),
				new Def("Chidori", JutsuRank.A, NatureJutsu::chidori),
				new Def("Four Pillar Bind", JutsuRank.A, NatureJutsu::fourPillarBind),
				new Def("Kirin", JutsuRank.S, NatureJutsu::kirin));
	}

	/** Registers a release's technique item and scroll (natures and kekkei genkai), replacing the old MCreator ones. */
	static void nature(String id, String title, Predicate<PlayerVariables> has, ToDoubleFunction<PlayerVariables> selected,
			ObjDoubleConsumer<PlayerVariables> select, ToDoubleFunction<PlayerVariables> learned, ObjDoubleConsumer<PlayerVariables> setLearned,
			ToDoubleFunction<PlayerVariables> bought, ObjDoubleConsumer<PlayerVariables> setBought, Def... defs) {
		String item = id + "_release_technique";
		Jutsus.JutsuSpec[] specs = new Jutsus.JutsuSpec[defs.length];
		for (int i = 0; i < defs.length; i++) {
			JutsuRank rank = defs[i].rank;
			specs[i] = Jutsus.jutsu(defs[i].name, learned, i + 1, defs[i].stat, defs[i].statValue(), rank.ninjutsu, rank.chakra, rank.cooldowns());
		}
		Jutsus.technique(item, selected, select, has, deps -> {
			if (!(deps.get("entity") instanceof ServerPlayer player))
				return;
			PlayerVariables v = NarutoShippudenModVariables.get(player);
			Def def = defs[Jutsus.index(selected.applyAsDouble(v), defs.length)];
			NarutoShippudenModVariables.ifPresent(player, vars -> {
				vars.ChakraAmount -= def.rank.chakra;
				vars.syncPlayerVariables(player);
			});
			def.cast.accept(player);
			if (Jutsus.missed)
				NarutoShippudenModVariables.ifPresent(player, vars -> {
					vars.ChakraAmount += def.rank.chakra;
					vars.syncPlayerVariables(player);
				});
		}, specs);
		Jutsus.TECHNIQUES.get(Identifier.fromNamespaceAndPath("naruto_shippuden", item)).requirementMessage = missing(title);

		Jutsus.Tier[] tiers = new Jutsus.Tier[defs.length];
		for (int i = 0; i < defs.length; i++)
			tiers[i] = Jutsus.tier(defs[i].rank.jp, i + 1, i == 0 ? item : null);
		Jutsus.Track track = Jutsus.track("", bought, -1, item, learned, tiers);
		Jutsus.release(id + "_release", deps -> {
			if (!(deps.get("entity") instanceof ServerPlayer player))
				return;
			PlayerVariables v = NarutoShippudenModVariables.get(player);
			int next = track.owned(v);
			if (!has.test(v)) {
				player.sendOverlayMessage(Component.literal(missing(title)));
				return;
			}
			if (next >= defs.length || v.jp < defs[next].rank.jp)
				return;
			NarutoShippudenModVariables.ifPresent(player, vars -> {
				vars.jp -= defs[next].rank.jp;
				setBought.accept(vars, next + 1);
				setLearned.accept(vars, Math.max(learned.applyAsDouble(vars), next + 1));
				track.learnTier(vars, next);
				vars.syncPlayerVariables(player);
			});
			if (next == 0)
				Compat.giveItemToPlayer(player, new ItemStack(BuiltInRegistries.ITEM.getValue(Identifier.fromNamespaceAndPath("naruto_shippuden", item))));
		}, track);
	}

	/** "You don't have the Fire nature" / "You haven't unlocked Ice Release" / "You aren't of the Hyuga Clan". */
	private static String missing(String title) {
		if (title.startsWith("the "))
			return "You don't have " + title;
		if (title.endsWith("Clan"))
			return "You aren't of the " + title;
		return title.endsWith("Release") ? "You haven't unlocked " + title : "You don't have the " + title + " nature";
	}

	static ServerLevel level(LivingEntity caster) {
		return (ServerLevel) caster.level();
	}

	// ------------------------------------------------------------------ fire
	/** Five small fireballs in a fan. */
	static void phoenixSageFire(LivingEntity p) {
		for (int i = -2; i <= 2; i++) {
			JutsuProjectile fire = shoot(p, Element.FIRE, Shape.ORB, 0.45F, turned(p, i * 7, -2).scale(1.3), 4);
			fire.gravity = 0.012F;
			fire.life = 40;
			fire.onImpact = f -> puff(level(p), f.position(), Element.FIRE, 0.6F);
		}
		sound(level(p), p.getEyePosition(), SoundEvents.BLAZE_SHOOT, 1, 1.2F);
	}

	/** A great ball of fire that bursts into flames. */
	static void greatFireball(LivingEntity p) {
		JutsuProjectile ball = shoot(p, Element.FIRE, Shape.ORB, 2.2F, 0.9F, 12);
		ball.life = 45;
		ball.knockback = 1;
		ball.onImpact = f -> burst(level(p), f.position(), 3.5F, 10, 1, Element.FIRE, f);
		sound(level(p), p.getEyePosition(), SoundEvents.BLAZE_SHOOT, 1.5F, 0.6F);
	}

	/** Breathes a stream of fire for two seconds. */
	static void greatFlame(LivingEntity p) {
		ServerLevel level = level(p);
		sound(level, p.getEyePosition(), SoundEvents.FIRECHARGE_USE, 1.2F, 0.7F);
		channel(p, 40, 1, t -> {
			Vec3 mouth = p.getEyePosition().add(p.getLookAngle().scale(0.8)).subtract(0, 0.2, 0);
			for (int i = 0; i < 8; i++)
				spray(level, i == 0 ? ParticleTypes.LARGE_SMOKE : ParticleTypes.FLAME, mouth, p.getLookAngle(), 0.5 + level.getRandom().nextDouble() * 0.3, 0.3);
			if (t % 2 == 0) {
				// glowing blobs of flame that swell as they fly (visual only; the cone below does the damage)
				JutsuProjectile blob = shoot(p, Element.FIRE, Shape.ORB, 0.5F + level.getRandom().nextFloat() * 0.5F,
						turned(p, (level.getRandom().nextFloat() - 0.5F) * 16, (level.getRandom().nextFloat() - 0.5F) * 10).scale(0.8), 0);
				blob.setPos(blob.position().add(p.getLookAngle().scale(1.5)));
				blob.life = 11;
				blob.pierce = -1;
				blob.knockback = 0;
			}
			if (t % 4 == 0)
				for (LivingEntity target : cone(p, 9, 22))
					damage(p, target, 3, Element.FIRE);
			if (t % 10 == 0)
				sound(level, mouth, SoundEvents.FIRE_AMBIENT, 1.5F, 0.8F);
		});
	}

	// ------------------------------------------------------------------ water
	/** Three quick water bullets. */
	static void waterGun(LivingEntity p) {
		channel(p, 9, 3, t -> {
			JutsuProjectile bullet = shoot(p, Element.WATER, Shape.ORB, 0.3F, 2.2F, 5);
			bullet.onImpact = b -> puff(level(p), b.position(), Element.WATER, 0.5F);
			sound(level(p), p.getEyePosition(), SoundEvents.PLAYER_SPLASH, 0.6F, 1.6F);
		});
	}

	/** A spinning wall of water around the caster for five seconds: pushes enemies out and stops projectiles. */
	static void waterWall(LivingEntity p) {
		ServerLevel level = level(p);
		sound(level, p.position(), SoundEvents.PLAYER_SPLASH_HIGH_SPEED, 1.5F, 0.7F);
		p.addEffect(new MobEffectInstance(MobEffects.RESISTANCE, 100, 1, false, false));
		channel(p, 100, 1, t -> {
			Vec3 c = p.position();
			for (int i = 0; i < 10; i++) {
				double a = (t * 0.35 + i * Math.PI / 5), y = level.getRandom().nextDouble() * 2.6;
				level.sendParticles(i % 2 == 0 ? ParticleTypes.SPLASH : ParticleTypes.FALLING_WATER, c.x + Math.cos(a) * 2.5, c.y + y, c.z + Math.sin(a) * 2.5, 1,
						0.05, 0.05, 0.05, 0);
			}
			for (LivingEntity target : enemies(level, p, p.getBoundingBox().inflate(2.8), e -> true)) {
				Vec3 away = target.position().subtract(c).multiply(1, 0, 1).normalize();
				target.push(away.x * 0.6, 0.1, away.z * 0.6);
				target.syncVelocity = true;
			}
			for (Projectile incoming : level.getEntitiesOfClass(Projectile.class, p.getBoundingBox().inflate(3),
					e -> Techniques.isEnemy(p, e) && e.getOwner() != p)) {
				puff(level, incoming.position(), Element.WATER, 0.5F);
				incoming.discard();
			}
			p.clearFire();
		});
	}

	/** A shark of water that hunts the nearest enemy. */
	static void waterShark(LivingEntity p) {
		JutsuProjectile shark = shoot(p, Element.WATER, Shape.SHARK, 1.4F, 1.0F, 14);
		shark.homing = 0.12F;
		shark.life = 80;
		shark.knockback = 1.2F;
		shark.onImpact = s -> burst(level(p), s.position(), 3, 8, 1.2F, Element.WATER, s);
		sound(level(p), p.getEyePosition(), SoundEvents.PLAYER_SPLASH_HIGH_SPEED, 1.2F, 0.8F);
	}

	/** A dragon of fire or water that passes through everything in its way. */
	static void dragon(LivingEntity p, Element element, float damage, float radius, float knockback) {
		JutsuProjectile dragon = shoot(p, element, Shape.DRAGON, 1.6F, 0.95F, damage);
		dragon.pierce = -1;
		dragon.life = 55;
		dragon.knockback = knockback;
		dragon.onImpact = d -> burst(level(p), d.position(), radius, damage * 0.75F, knockback, element, d);
		sound(level(p), p.getEyePosition(), SoundEvents.ENDER_DRAGON_GROWL, 0.8F, element == Element.FIRE ? 1.3F : 1.6F);
	}

	// ------------------------------------------------------------------ wind
	/** A blast of wind from the palm that throws everything in front back. */
	static void galePalm(LivingEntity p) {
		ServerLevel level = level(p);
		Vec3 look = p.getLookAngle();
		for (LivingEntity target : cone(p, 8, 35)) {
			damage(p, target, 5, Element.WIND);
			target.push(look.x * 2.2, 0.45, look.z * 2.2);
			target.syncVelocity = true;
		}
		for (int i = 1; i <= 7; i++) {
			Vec3 at = p.getEyePosition().add(look.scale(i));
			level.sendParticles(ParticleTypes.GUST, at.x, at.y, at.z, 1, i * 0.12, i * 0.12, i * 0.12, 0);
		}
		sound(level, p.getEyePosition(), SoundEvents.WIND_CHARGE_BURST.value(), 1.2F, 0.8F);
	}

	/** Five rapid bullets of compressed air. */
	static void vacuumSphere(LivingEntity p) {
		channel(p, 15, 3, t -> {
			JutsuProjectile bullet = shoot(p, Element.WIND, Shape.ORB, 0.35F, 2.4F, 4);
			bullet.pierce = 1;
			bullet.onImpact = b -> level(p).sendParticles(ParticleTypes.GUST, b.getX(), b.getY(), b.getZ(), 1, 0, 0, 0, 0);
			sound(level(p), p.getEyePosition(), SoundEvents.BREEZE_SHOOT, 0.7F, 1.4F);
		});
	}

	/** Thrown Rasenshuriken: on impact a storm of wind blades pulls enemies in and cuts them for three seconds. */
	static void rasenshuriken(LivingEntity p) {
		JutsuProjectile shuriken = shoot(p, Element.WIND, Shape.RASENSHURIKEN, 1.8F, 1.1F, 8);
		shuriken.life = 60;
		shuriken.onImpact = s -> {
			ServerLevel level = level(p);
			Vec3 c = s.position();
			sound(level, c, SoundEvents.WIND_CHARGE_BURST.value(), 2, 0.6F);
			Techniques.after(level, 0, () -> channel(p, 60, 2, t -> {
				level.sendParticles(ParticleTypes.SWEEP_ATTACK, c.x, c.y, c.z, 6, 2.5, 1.2, 2.5, 0);
				level.sendParticles(ParticleTypes.GUST_EMITTER_SMALL, c.x, c.y, c.z, 1, 0, 0, 0, 0);
				for (LivingEntity target : enemies(level, p, new AABB(c, c).inflate(4.5), e -> e.distanceToSqr(c) < 20)) {
					Vec3 in = c.subtract(target.position()).normalize().scale(0.25);
					target.setDeltaMovement(target.getDeltaMovement().scale(0.5).add(in));
					target.syncVelocity = true;
					if (t % 6 == 0)
						damage(s, target, 2.5F, Element.WIND);
				}
				if (t == 58)
					burst(level, c, 4.5F, 14, 1.5F, Element.WIND, s);
			}));
		};
		sound(level(p), p.getEyePosition(), SoundEvents.BREEZE_CHARGE, 1.5F, 1.5F);
	}

	// ------------------------------------------------------------------ earth
	static final Predicate<BlockState> OPEN = BlockState::canBeReplaced;

	private static BlockState dripstone(SpeleothemThickness thickness) {
		return Blocks.POINTED_DRIPSTONE.defaultBlockState().setValue(PointedDripstoneBlock.TIP_DIRECTION, Direction.UP)
				.setValue(PointedDripstoneBlock.THICKNESS, thickness);
	}

	/** The ground on a column: the first open block with something solid under it, near y. */
	static BlockPos ground(ServerLevel level, double x, double y, double z) {
		BlockPos pos = BlockPos.containing(x, y + 2, z);
		for (int i = 0; i < 6 && !(OPEN.test(level.getBlockState(pos)) && !OPEN.test(level.getBlockState(pos.below()))); i++)
			pos = pos.below();
		return pos;
	}

	/** Stone spikes burst out of the ground in a line, launching whatever stands there. */
	static void earthSpikes(LivingEntity p) {
		ServerLevel level = level(p);
		Vec3 dir = p.getLookAngle().multiply(1, 0, 1).normalize();
		List<LivingEntity> struck = new ArrayList<>();
		channel(p, 12, 1, t -> {
			Vec3 at = p.position().add(dir.scale(2 + t));
			BlockPos base = ground(level, at.x, p.getY(), at.z);
			place(level, base, dripstone(SpeleothemThickness.BASE), 50 - t, OPEN);
			place(level, base.above(), dripstone(SpeleothemThickness.FRUSTUM), 50 - t, OPEN);
			place(level, base.above(2), dripstone(SpeleothemThickness.TIP), 50 - t, OPEN);
			level.sendParticles(Element.EARTH.puff, base.getX() + 0.5, base.getY(), base.getZ() + 0.5, 3, 0.3, 0.1, 0.3, 0.02);
			sound(level, Vec3.atCenterOf(base), SoundEvents.POINTED_DRIPSTONE_LAND, 1, 0.8F);
			for (LivingEntity target : enemies(level, p, new AABB(base).inflate(0.8, 1.5, 0.8), e -> !struck.contains(e))) {
				struck.add(target);
				damage(p, target, 9, Element.EARTH);
				target.push(0, 0.9, 0);
				target.syncVelocity = true;
			}
		});
	}

	/** Raises a wall of earth in front of the caster that crumbles back after 12 seconds. */
	static void earthWall(LivingEntity p) {
		ServerLevel level = level(p);
		Vec3 dir = p.getLookAngle().multiply(1, 0, 1).normalize(), side = new Vec3(-dir.z, 0, dir.x);
		Vec3 centre = p.position().add(dir.scale(3));
		sound(level, centre, SoundEvents.ROOTED_DIRT_PLACE, 1.5F, 0.6F);
		List<BlockPos> base = new ArrayList<>();
		for (int s = -3; s <= 3; s++) {
			Vec3 at = centre.add(side.scale(s));
			base.add(ground(level, at.x, p.getY(), at.z));
		}
		channel(p, 4, 1, row -> {
			for (int s = -3; s <= 3; s++) {
				BlockPos pos = base.get(s + 3).above(row);
				BlockState state = (s + row) % 3 == 0 ? Blocks.PACKED_MUD.defaultBlockState() : Blocks.MUD_BRICKS.defaultBlockState();
				if (place(level, pos, state, 240 - row, OPEN))
					level.sendParticles(Element.EARTH.trail, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, 6, 0.4, 0.4, 0.4, 0.05);
			}
			sound(level, centre, SoundEvents.MUD_BRICKS_PLACE, 1, 0.8F + row * 0.1F);
		});
	}

	/** Summons an earth golem that fights for the caster for 30 seconds. */
	static void earthGolem(LivingEntity p) {
		ServerLevel level = level(p);
		Vec3 at = p.position().add(p.getLookAngle().multiply(1, 0, 1).normalize().scale(2));
		EarthGolemEntity.CustomEntity golem = new EarthGolemEntity.CustomEntity(EarthGolemEntity.entity, level);
		golem.snapTo(at.x, p.getY(), at.z, p.getYRot(), 0);
		golem.finalizeSpawn(level, level.getCurrentDifficultyAt(golem.blockPosition()), EntitySpawnReason.MOB_SUMMONED, null);
		if (p instanceof net.minecraft.world.entity.player.Player player)
			golem.tame(player);
		level.addFreshEntity(golem);
		puff(level, at.add(0, 1, 0), Element.EARTH, 1.5F);
		sound(level, at, SoundEvents.IRON_GOLEM_REPAIR, 1, 0.6F);
		Techniques.after(level, 600, () -> {
			if (golem.isAlive()) {
				puff(level, golem.position().add(0, 1, 0), Element.EARTH, 1.5F);
				golem.discard();
			}
		});
	}

	/** Turns the ground where the caster looks into deep mud for eight seconds: enemies sink, slow down and choke. */
	static void swamp(LivingEntity p) {
		ServerLevel level = level(p);
		Vec3 c = lookPoint(p, 24);
		BlockPos centre = BlockPos.containing(c);
		for (BlockPos pos : BlockPos.betweenClosed(centre.offset(-5, -3, -5), centre.offset(5, 2, 5))) {
			BlockState state = level.getBlockState(pos);
			if (pos.distSqr(centre) <= 30 && OPEN.test(level.getBlockState(pos.above()))
					&& (state.is(BlockTags.DIRT) || state.is(BlockTags.SAND) || state.is(BlockTags.BASE_STONE_OVERWORLD)))
				place(level, pos, Blocks.MUD.defaultBlockState(), 160, s -> true);
		}
		sound(level, c, SoundEvents.MUD_BREAK, 2, 0.5F);
		channel(p, 160, 5, t -> {
			level.sendParticles(Element.EARTH.trail, c.x, c.y + 0.2, c.z, 12, 3, 0.1, 3, 0.02);
			for (LivingEntity target : enemies(level, p, new AABB(c, c).inflate(5.5, 3, 5.5), e -> true)) {
				target.addEffect(new MobEffectInstance(MobEffects.SLOWNESS, 20, 3, false, false));
				target.setDeltaMovement(target.getDeltaMovement().multiply(0.3, 1, 0.3).add(0, -0.08, 0));
				if (t % 10 == 0)
					damage(p, target, 1.5F, Element.EARTH);
			}
		});
	}

	// ------------------------------------------------------------------ lightning
	/** Five needles of lightning in a fan; each numbs what it hits. */
	static void chidoriSenbon(LivingEntity p) {
		for (int i = -2; i <= 2; i++) {
			JutsuProjectile needle = shoot(p, Element.LIGHTNING, Shape.NEEDLE, 0.25F, turned(p, i * 5, 0).scale(2.6), 3);
			needle.life = 25;
			needle.knockback = 0;
		}
		sound(level(p), p.getEyePosition(), SoundEvents.TRIDENT_THROW.value(), 1, 1.6F);
	}

	/** Lightning Beast Tracking Fang: a beast of lightning that hunts the enemy; its shock jumps to three more enemies nearby. */
	static void lightningBall(LivingEntity p) {
		JutsuProjectile ball = shoot(p, Element.LIGHTNING, Shape.LION, 0.9F, 1.4F, 10);
		ball.homing = 0.2F;
		ball.life = 50;
		ball.onHit = (b, first) -> {
			ServerLevel level = level(p);
			LivingEntity from = first;
			List<LivingEntity> chained = new ArrayList<>(List.of(first));
			for (int i = 0; i < 3; i++) {
				LivingEntity source = from;
				LivingEntity next = enemies(level, p, source.getBoundingBox().inflate(6), e -> !chained.contains(e)).stream()
						.min((a, c) -> Double.compare(a.distanceToSqr(source), c.distanceToSqr(source))).orElse(null);
				if (next == null)
					break;
				line(level, ParticleTypes.ELECTRIC_SPARK, source.getBoundingBox().getCenter(), next.getBoundingBox().getCenter(), 0.3);
				damage(b, next, 6, Element.LIGHTNING);
				chained.add(next);
				from = next;
			}
		};
		ball.onImpact = b -> puff(level(p), b.position(), Element.LIGHTNING, 1);
		sound(level(p), p.getEyePosition(), SoundEvents.BEACON_POWER_SELECT, 1, 2);
	}

	/**
	 * Lightning Lariat: the caster charges up in crackling lightning armor, then charges forward (steering with their look) and
	 * clotheslines the first enemy in the way, launching it with a shockwave. Running into a wall ends the charge in a shockwave too.
	 */
	static void lariat(LivingEntity p) {
		ServerLevel level = level(p);
		sound(level, p.position(), SoundEvents.BEACON_POWER_SELECT, 1.2F, 0.6F);
		p.addEffect(new MobEffectInstance(MobEffects.RESISTANCE, 40, 2, false, false));
		boolean[] done = { false };
		channel(p, 26, 1, t -> {
			Vec3 body = p.position().add(0, 1, 0);
			level.sendParticles(ParticleTypes.ELECTRIC_SPARK, body.x, body.y, body.z, done[0] ? 2 : 10, 0.45, 0.8, 0.45, 0.25);
			if (done[0])
				return;
			if (t < 8) {
				// charging: rooted in place, the armor flares up
				p.setDeltaMovement(0, Math.min(p.getDeltaMovement().y, 0), 0);
				p.syncVelocity = true;
				if (t % 3 == 0)
					sound(level, body, SoundEvents.BEACON_POWER_SELECT, 0.6F, 1.2F + t * 0.1F);
				return;
			}
			Vec3 look = p.getLookAngle().multiply(1, 0, 1).normalize();
			p.setDeltaMovement(look.x * 1.6, Math.min(p.getDeltaMovement().y, 0.1), look.z * 1.6);
			p.syncVelocity = true;
			p.fallDistance = 0;
			line(level, ParticleTypes.ELECTRIC_SPARK, body, body.subtract(look.scale(2.5)), 0.4);
			LivingEntity hit = enemies(level, p, p.getBoundingBox().inflate(0.9).move(look.scale(0.8)), e -> true).stream().findFirst().orElse(null);
			if (hit != null || p.horizontalCollision) {
				done[0] = true;
				Vec3 at = hit != null ? hit.getBoundingBox().getCenter() : body.add(look);
				if (hit != null) {
					damage(p, hit, 18, Element.LIGHTNING);
					hit.setDeltaMovement(look.x * 2.6, 0.9, look.z * 2.6);
					hit.syncVelocity = true;
				}
				burst(level, at, 3, 7, 1.5F, Element.LIGHTNING, p);
				level.sendParticles(ParticleTypes.EXPLOSION, at.x, at.y, at.z, 1, 0, 0, 0, 0);
				sound(level, at, SoundEvents.LIGHTNING_BOLT_IMPACT, 1.5F, 1.4F);
				p.setDeltaMovement(look.scale(-0.3).add(0, 0.2, 0));
				p.syncVelocity = true;
			}
		});
	}

	/** Kirin: thunderclouds gather over the target, then a huge dragon of lightning dives onto it, followed by a storm of bolts. */
	static void kirin(LivingEntity p) {
		ServerLevel level = level(p);
		Vec3 target = lookPoint(p, 40);
		Vec3 sky = target.add(p.getLookAngle().multiply(-1, 0, -1).normalize().scale(10)).add(0, 26, 0);
		sound(level, target, SoundEvents.LIGHTNING_BOLT_THUNDER, 3, 0.7F);
		channel(p, 12, 2, t -> {
			level.sendParticles(ParticleTypes.LARGE_SMOKE, sky.x, sky.y, sky.z, 40, 5, 1, 5, 0.01);
			level.sendParticles(ParticleTypes.ELECTRIC_SPARK, sky.x, sky.y - 1, sky.z, 30, 5, 1, 5, 0.3);
		});
		Techniques.after(level, 12, () -> {
			JutsuProjectile kirin = new JutsuProjectile(net.mcreator.narutoshippudenmod.core.jutsu.engine.JutsuEngine.PROJECTILE, level);
			kirin.look(Element.LIGHTNING, Shape.DRAGON, 3.2F);
			kirin.setOwner(p);
			kirin.setPos(sky);
			kirin.setDeltaMovement(target.subtract(sky).normalize().scale(1.9));
			kirin.damage = 20;
			kirin.pierce = -1;
			kirin.life = 40;
			kirin.onImpact = k -> {
				Techniques.strike(level, target, 5.5F, 25, k);
				channel(p, 24, 3, t -> {
					double a = level.getRandom().nextDouble() * Math.PI * 2, r = 2 + level.getRandom().nextDouble() * 4;
					Techniques.strike(level, target.add(Math.cos(a) * r, 0, Math.sin(a) * r), 2.5F, 8, k);
				});
			};
			level.addFreshEntity(kirin);
			sound(level, sky, SoundEvents.ENDER_DRAGON_GROWL, 3, 1.8F);
		});
	}

	// ------------------------------------------------------------------ added from the wiki
	/** Great Fire Annihilation: a sea of flame pours out in a wide front and burns everything across a great distance. */
	static void greatFireAnnihilation(LivingEntity p) {
		ServerLevel level = level(p);
		sound(level, p.getEyePosition(), SoundEvents.BLAZE_SHOOT, 2, 0.4F);
		sound(level, p.getEyePosition(), SoundEvents.FIRECHARGE_USE, 2, 0.5F);
		channel(p, 30, 3, t -> {
			for (int i = -3; i <= 3; i++) {
				JutsuProjectile wave = shoot(p, Element.FIRE, Shape.ORB, 1.8F + level.getRandom().nextFloat(),
						turned(p, i * 11 + (level.getRandom().nextFloat() - 0.5F) * 8, (level.getRandom().nextFloat() - 0.3F) * 6).scale(0.85), 6);
				wave.pierce = -1;
				wave.life = 28;
				wave.knockback = 0.5F;
			}
			Vec3 mouth = p.getEyePosition().add(p.getLookAngle().scale(0.8)).subtract(0, 0.2, 0);
			for (int i = 0; i < 10; i++)
				spray(level, i % 3 == 0 ? ParticleTypes.LARGE_SMOKE : ParticleTypes.FLAME, mouth, p.getLookAngle(), 0.6 + level.getRandom().nextDouble() * 0.4, 0.8);
			if (t % 9 == 0)
				sound(level, mouth, SoundEvents.FIRE_AMBIENT, 2, 0.6F);
		});
	}

	/**
	 * Water Prison: a sphere of water closes round the enemy looked at. As long as the caster keeps their hand in it (stays where they
	 * stand) the enemy is trapped and drowns; walking away bursts the prison.
	 */
	static void waterPrison(LivingEntity p) {
		ServerLevel level = level(p);
		LivingEntity target = ClanJutsu.target(p, 10);
		if (target == null) {
			Jutsus.miss(p, "Look at an enemy within reach");
			return;
		}
		float size = Math.max(target.getBbWidth(), target.getBbHeight()) + 1.2F;
		JutsuProjectile prison = ClanJutsu.shell(p, target, target.getBoundingBox().getCenter(), Element.WATER, size, 200);
		Vec3 anchor = p.position();
		sound(level, target.position(), SoundEvents.PLAYER_SPLASH_HIGH_SPEED, 1.5F, 0.6F);
		channel(p, 200, 1, t -> {
			if (!prison.isAlive())
				return;
			if (!target.isAlive() || p.position().distanceToSqr(anchor) > 2.5) {
				puff(level, prison.position().add(0, size / 2, 0), Element.WATER, size / 2);
				sound(level, prison.position(), SoundEvents.PLAYER_SPLASH, 1.5F, 0.8F);
				prison.discard();
				return;
			}
			ClanJutsu.hold(target);
			target.setAirSupply(Math.max(-20, target.getAirSupply() - 6));
			target.clearFire();
			level.sendParticles(ParticleTypes.BUBBLE, target.getX(), target.getEyeY(), target.getZ(), 2, 0.3, 0.3, 0.3, 0.05);
			if (t % 4 == 0)
				line(level, Element.WATER.trail, p.getEyePosition().subtract(0, 0.4, 0), target.getBoundingBox().getCenter(), 0.5);
			if (t % 20 == 0)
				damage(p, target, 2.5F, Element.WATER);
		});
	}

	/** Great Waterfall Technique: a torrent of water rises in front of the caster and crashes forward, sweeping everything away. */
	static void greatWaterfall(LivingEntity p) {
		ServerLevel level = level(p);
		Vec3 dir = p.getLookAngle().multiply(1, 0, 1).normalize(), side = new Vec3(-dir.z, 0, dir.x), origin = p.position();
		List<LivingEntity> struck = new ArrayList<>();
		// the wall of water itself: two rows of great water blobs rolling forward
		for (int row = 0; row < 2; row++)
			for (int i = -3; i <= 3; i++) {
				Vec3 at = origin.add(dir.scale(2)).add(side.scale(i * 1.8)).add(0, row * 1.8, 0);
				JutsuProjectile wave = ClanJutsu.spawn(p, Element.WATER, Shape.ORB, 2.4F, at, dir.scale(0.8), 0);
				wave.pierce = -1;
				wave.knockback = 0;
				wave.life = 30;
			}
		sound(level, origin, SoundEvents.PLAYER_SPLASH_HIGH_SPEED, 2, 0.4F);
		channel(p, 30, 1, t -> {
			Vec3 front = origin.add(dir.scale(3 + t * 0.8));
			for (int i = -6; i <= 6; i++) {
				Vec3 at = front.add(side.scale(i));
				level.sendParticles(i % 2 == 0 ? ParticleTypes.SPLASH : ParticleTypes.FALLING_WATER, at.x, at.y + level.getRandom().nextDouble() * 4, at.z, 2, 0.3, 0.3,
						0.3, 0.1);
			}
			for (LivingEntity target : enemies(level, p, new AABB(front, front).inflate(6.5, 4, 6.5), e -> {
				Vec3 to = e.position().subtract(front);
				return Math.abs(to.dot(side)) <= 6.5 && Math.abs(to.dot(dir)) <= 1.8;
			})) {
				target.setDeltaMovement(dir.x * 1.2, 0.35, dir.z * 1.2);
				target.syncVelocity = true;
				target.clearFire();
				if (!struck.contains(target)) {
					struck.add(target);
					damage(p, target, 16, Element.WATER);
				}
			}
			if (t % 6 == 0)
				sound(level, front, SoundEvents.PLAYER_SPLASH, 1.5F, 0.5F);
		});
	}

	/** Great Breakthrough: a gale from the mouth that blasts everything in front far away and blows projectiles out of the air. */
	static void greatBreakthrough(LivingEntity p) {
		ServerLevel level = level(p);
		Vec3 look = p.getLookAngle();
		for (LivingEntity target : cone(p, 14, 45)) {
			damage(p, target, 8, Element.WIND);
			target.push(look.x * 3, 0.6, look.z * 3);
			target.syncVelocity = true;
		}
		for (Projectile shot : level.getEntitiesOfClass(Projectile.class, p.getBoundingBox().inflate(14),
				e -> e.getOwner() != p && e.position().subtract(p.getEyePosition()).normalize().dot(look) > 0.7)) {
			level.sendParticles(ParticleTypes.GUST, shot.getX(), shot.getY(), shot.getZ(), 1, 0, 0, 0, 0);
			shot.discard();
		}
		channel(p, 8, 1, t -> {
			for (int i = 1; i <= 12; i += 2) {
				Vec3 at = p.getEyePosition().add(look.scale(i + t * 0.5));
				level.sendParticles(ParticleTypes.GUST, at.x, at.y, at.z, 1, i * 0.18, i * 0.14, i * 0.18, 0);
				level.sendParticles(ParticleTypes.CLOUD, at.x, at.y, at.z, 3, i * 0.2, i * 0.15, i * 0.2, 0.05);
			}
		});
		sound(level, p.getEyePosition(), SoundEvents.BREEZE_WIND_CHARGE_BURST.value(), 2, 0.5F);
	}

	/** Vacuum Great Sphere: three great balls of compressed air, each bursting where it lands. */
	static void vacuumGreatSphere(LivingEntity p) {
		channel(p, 18, 6, t -> {
			JutsuProjectile sphere = shoot(p, Element.WIND, Shape.ORB, 1.3F, 2.0F, 10);
			sphere.life = 30;
			sphere.onImpact = s -> burst(level(p), s.position(), 3.2F, 8, 1.2F, Element.WIND, s);
			sound(level(p), p.getEyePosition(), SoundEvents.BREEZE_SHOOT, 1.2F, 0.7F);
		});
	}

	/**
	 * Double Suicide Decapitation Technique: the caster sinks into the ground, burrows under the enemy looked at and drags them down
	 * into the earth up to their chest, stuck there for three seconds.
	 */
	static void doubleSuicide(LivingEntity p) {
		ServerLevel level = level(p);
		LivingEntity target = ClanJutsu.target(p, 12);
		if (target == null) {
			Jutsus.miss(p, "Look at an enemy to drag down");
			return;
		}
		Vec3 from = p.position();
		p.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 14, 0, false, false));
		channel(p, 10, 1, t -> {
			Vec3 at = from.lerp(target.position(), (t + 1) / 12.0);
			p.teleportTo(at.x, at.y, at.z);
			p.fallDistance = 0;
			BlockState soil = level.getBlockState(BlockPos.containing(at.x, at.y - 0.5, at.z));
			if (!soil.isAir())
				level.sendParticles(new net.minecraft.core.particles.BlockParticleOption(ParticleTypes.BLOCK, soil), at.x, at.y + 0.1, at.z, 8, 0.3, 0.1, 0.3, 0.1);
		});
		Techniques.after(level, 10, () -> {
			if (!target.isAlive())
				return;
			p.removeEffect(MobEffects.INVISIBILITY);
			BlockState soil = level.getBlockState(target.blockPosition().below());
			BlockState mound = soil.isAir() || !soil.isSolid() ? Blocks.DIRT.defaultBlockState() : soil;
			for (int dx = -1; dx <= 1; dx++)
				for (int dz = -1; dz <= 1; dz++)
					if (dx != 0 || dz != 0)
						place(level, target.blockPosition().offset(dx, 0, dz), mound, 60, OPEN);
			damage(p, target, 6, Element.EARTH);
			sound(level, target.position(), SoundEvents.ROOTED_DIRT_BREAK, 1.5F, 0.6F);
			Vec3 spot = target.position();
			channel(p, 60, 1, t -> {
				if (!target.isAlive())
					return;
				ClanJutsu.hold(target);
				if (target.position().distanceToSqr(spot) > 0.04)
					target.teleportTo(spot.x, spot.y, spot.z);
			});
		});
	}

	/** Earth Dragon Bullet: a dragon of mud that rams through everything and spits balls of mud at enemies near its path. */
	static void earthDragonBullet(LivingEntity p) {
		ServerLevel level = level(p);
		JutsuProjectile dragon = shoot(p, Element.EARTH, Shape.DRAGON, 1.5F, 0.9F, 12);
		dragon.pierce = -1;
		dragon.life = 45;
		dragon.knockback = 1.2F;
		dragon.onImpact = d -> burst(level, d.position(), 3, 8, 1, Element.EARTH, d);
		channel(p, 45, 8, t -> {
			if (t == 0 || !dragon.isAlive())
				return;
			Vec3 mouth = dragon.getBoundingBox().getCenter();
			enemies(level, p, dragon.getBoundingBox().inflate(12), e -> true).stream()
					.min((a, b) -> Double.compare(a.distanceToSqr(mouth), b.distanceToSqr(mouth))).ifPresent(target -> {
						JutsuProjectile mud = ClanJutsu.spawn(p, Element.EARTH, Shape.ORB, 0.5F, mouth, target.getBoundingBox().getCenter().subtract(mouth).normalize().scale(1.3), 5);
						mud.life = 20;
						mud.onHit = (m, hit) -> hit.addEffect(new MobEffectInstance(MobEffects.SLOWNESS, 60, 2, false, false));
					});
		});
		sound(level, p.getEyePosition(), SoundEvents.MUD_BREAK, 2, 0.5F);
	}

	/** Chidori: lightning gathers in the hand with the chirping of a thousand birds, then the caster lunges and runs the enemy through. */
	static void chidori(LivingEntity p) {
		ServerLevel level = level(p);
		boolean[] done = { false };
		channel(p, 30, 1, t -> {
			Vec3 look = p.getLookAngle().multiply(1, 0, 1).normalize(), side = new Vec3(-look.z, 0, look.x);
			Vec3 hand = p.position().add(0, 1.0, 0).add(look.scale(0.6)).add(side.scale(0.35));
			level.sendParticles(ParticleTypes.ELECTRIC_SPARK, hand.x, hand.y, hand.z, done[0] ? 2 : 8, 0.18, 0.18, 0.18, 0.3);
			if (done[0])
				return;
			if (t < 16) {
				p.setDeltaMovement(0, Math.min(p.getDeltaMovement().y, 0), 0);
				p.syncVelocity = true;
				if (t % 2 == 0)
					sound(level, hand, SoundEvents.AMETHYST_BLOCK_CHIME, 0.9F, 1.6F + level.getRandom().nextFloat() * 0.4F);
				return;
			}
			p.setDeltaMovement(look.x * 1.8, Math.min(p.getDeltaMovement().y, 0.05), look.z * 1.8);
			p.syncVelocity = true;
			p.fallDistance = 0;
			line(level, ParticleTypes.ELECTRIC_SPARK, hand, hand.subtract(look.scale(2)), 0.3);
			LivingEntity hit = enemies(level, p, p.getBoundingBox().inflate(0.8).move(look.scale(0.9)), e -> true).stream().findFirst().orElse(null);
			if (hit != null || p.horizontalCollision) {
				done[0] = true;
				Vec3 at = hit != null ? hit.getBoundingBox().getCenter() : hand;
				if (hit != null) {
					damage(p, hit, 22, Element.LIGHTNING);
					hit.push(look.x * 1.2, 0.3, look.z * 1.2);
					hit.syncVelocity = true;
				}
				level.sendParticles(ParticleTypes.ELECTRIC_SPARK, at.x, at.y, at.z, 60, 0.4, 0.4, 0.4, 0.8);
				sound(level, at, SoundEvents.LIGHTNING_BOLT_IMPACT, 1.2F, 1.8F);
				p.setDeltaMovement(Vec3.ZERO);
				p.syncVelocity = true;
			}
		});
	}

	/**
	 * Four Pillar Bind: four stone pillars rise round the enemy looked at and lightning arcs between them, pinning and shocking
	 * everything inside for four seconds.
	 */
	static void fourPillarBind(LivingEntity p) {
		ServerLevel level = level(p);
		LivingEntity aimed = ClanJutsu.target(p, 20);
		Vec3 c = aimed != null ? aimed.position() : lookPoint(p, 20);
		List<Vec3> tops = new ArrayList<>();
		for (int i = 0; i < 4; i++) {
			int dx = i % 2 == 0 ? -2 : 2, dz = i < 2 ? -2 : 2;
			BlockPos base = ground(level, c.x + dx, c.y, c.z + dz);
			for (int h = 0; h < 3; h++)
				place(level, base.above(h), Blocks.STONE_BRICKS.defaultBlockState(), 90, OPEN);
			tops.add(Vec3.atCenterOf(base.above(3)));
		}
		// round the square, not across it
		java.util.Collections.swap(tops, 2, 3);
		sound(level, c, SoundEvents.STONE_PLACE, 1.5F, 0.6F);
		channel(p, 86, 2, t -> {
			if (t < 6)
				return;
			for (int i = 0; i < 4; i++)
				line(level, ParticleTypes.ELECTRIC_SPARK, tops.get(i), tops.get((i + 1) % 4), 0.4);
			for (LivingEntity target : enemies(level, p, new AABB(c, c).inflate(2.2, 4, 2.2), e -> true)) {
				ClanJutsu.hold(target);
				line(level, ParticleTypes.ELECTRIC_SPARK, tops.get(level.getRandom().nextInt(4)), target.getBoundingBox().getCenter(), 0.35);
				if (t % 10 == 0)
					damage(p, target, 3, Element.LIGHTNING);
			}
			if (t % 8 == 0)
				sound(level, c, SoundEvents.BEACON_POWER_SELECT, 0.8F, 1.8F);
		});
	}
}
