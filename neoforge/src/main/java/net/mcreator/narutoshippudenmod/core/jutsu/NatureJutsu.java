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
import net.mcreator.narutoshippudenmod.entity.SummonEntities.KirinEntity;

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
import net.minecraft.world.entity.Mob;
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

	private record Def(String name, JutsuRank rank, Consumer<ServerPlayer> cast) {
	}

	static void register() {
		nature("fire", "Fire", v -> v.firereleaselogic, v -> v.firetechnique, (v, i) -> v.firetechnique = i, v -> v.firelearn, (v, i) -> v.firelearn = i,
				v -> v.fire_release, (v, i) -> v.fire_release = i,
				new Def("Phoenix Sage Fire", JutsuRank.D, NatureJutsu::phoenixSageFire),
				new Def("Great Fireball Technique", JutsuRank.C, NatureJutsu::greatFireball),
				new Def("Great Flame Technique", JutsuRank.B, NatureJutsu::greatFlame),
				new Def("Great Dragon Fire Technique", JutsuRank.A, p -> dragon(p, Element.FIRE, 16, 3.5F, 0.6F)));
		nature("water", "Water", v -> v.waterreleaselogic, v -> v.water_technique, (v, i) -> v.water_technique = i, v -> v.waterlearn,
				(v, i) -> v.waterlearn = i, v -> v.water_release, (v, i) -> v.water_release = i,
				new Def("Water Gun Technique", JutsuRank.D, NatureJutsu::waterGun),
				new Def("Water Formation Wall", JutsuRank.C, NatureJutsu::waterWall),
				new Def("Water Shark Bullet Technique", JutsuRank.B, NatureJutsu::waterShark),
				new Def("Water Dragon Bullet Technique", JutsuRank.A, p -> dragon(p, Element.WATER, 18, 4, 2)));
		nature("wind", "Wind", v -> v.windreleaselogic, v -> v.wind_technique, (v, i) -> v.wind_technique = i, v -> v.windlearn, (v, i) -> v.windlearn = i,
				v -> v.wind_release, (v, i) -> v.wind_release = i,
				new Def("Gale Palm", JutsuRank.D, NatureJutsu::galePalm),
				new Def("Vacuum Sphere", JutsuRank.C, NatureJutsu::vacuumSphere),
				new Def("Wind Cloak", JutsuRank.B, NatureJutsu::windCloak),
				new Def("Rasenshuriken", JutsuRank.S, NatureJutsu::rasenshuriken));
		nature("earth", "Earth", v -> v.earthreleaselogic, v -> v.earth_technique, (v, i) -> v.earth_technique = i, v -> v.earthlearn,
				(v, i) -> v.earthlearn = i, v -> v.earth_release, (v, i) -> v.earth_release = i,
				new Def("Earth Spikes", JutsuRank.D, NatureJutsu::earthSpikes),
				new Def("Earth-Style Wall", JutsuRank.C, NatureJutsu::earthWall),
				new Def("Earth Golem", JutsuRank.B, NatureJutsu::earthGolem),
				new Def("Swamp of the Underworld", JutsuRank.A, NatureJutsu::swamp));
		nature("lightning", "Lightning", v -> v.lightningreleaselogic, v -> v.lightning_technique, (v, i) -> v.lightning_technique = i,
				v -> v.lightninglearn, (v, i) -> v.lightninglearn = i, v -> v.lightning_release, (v, i) -> v.lightning_release = i,
				new Def("Chidori Senbon", JutsuRank.D, NatureJutsu::chidoriSenbon),
				new Def("Lightning Ball", JutsuRank.C, NatureJutsu::lightningBall),
				new Def("Lariat", JutsuRank.B, p -> Techniques.dash(p, 10, 12, Element.LIGHTNING)),
				new Def("Kirin", JutsuRank.S, NatureJutsu::kirin));
	}

	/** Registers a nature's technique item and scroll, replacing the old MCreator ones. */
	private static void nature(String id, String title, Predicate<PlayerVariables> has, ToDoubleFunction<PlayerVariables> selected,
			ObjDoubleConsumer<PlayerVariables> select, ToDoubleFunction<PlayerVariables> learned, ObjDoubleConsumer<PlayerVariables> setLearned,
			ToDoubleFunction<PlayerVariables> bought, ObjDoubleConsumer<PlayerVariables> setBought, Def... defs) {
		String item = id + "_release_technique";
		Jutsus.JutsuSpec[] specs = new Jutsus.JutsuSpec[defs.length];
		for (int i = 0; i < defs.length; i++) {
			JutsuRank rank = defs[i].rank;
			specs[i] = Jutsus.jutsu(defs[i].name, learned, i + 1, "Ninjutsu", v -> v.ninjutsu, rank.ninjutsu, rank.chakra, rank.cooldowns());
		}
		Jutsus.technique(item, selected, select, has, deps -> {
			if (!(deps.get("entity") instanceof ServerPlayer player))
				return;
			PlayerVariables v = NarutoShippudenModVariables.get(player);
			Def def = defs[Mth.clamp((int) selected.applyAsDouble(v), 0, defs.length - 1)];
			NarutoShippudenModVariables.ifPresent(player, vars -> {
				vars.ChakraAmount -= def.rank.chakra;
				vars.syncPlayerVariables(player);
			});
			def.cast.accept(player);
		}, specs);
		Jutsus.TECHNIQUES.get(Identifier.fromNamespaceAndPath("naruto_shippuden", item)).requirementMessage = "You don't have the " + title + " nature";

		Jutsus.Tier[] tiers = new Jutsus.Tier[defs.length];
		for (int i = 0; i < defs.length; i++)
			tiers[i] = Jutsus.tier(defs[i].rank.jp, i + 1, i == 0 ? item : null);
		Jutsus.release(id + "_release", deps -> {
			if (!(deps.get("entity") instanceof ServerPlayer player))
				return;
			PlayerVariables v = NarutoShippudenModVariables.get(player);
			int next = (int) bought.applyAsDouble(v);
			if (!has.test(v)) {
				player.sendOverlayMessage(Component.literal("You don't have the " + title + " nature"));
				return;
			}
			if (next >= defs.length || v.jp < defs[next].rank.jp)
				return;
			NarutoShippudenModVariables.ifPresent(player, vars -> {
				vars.jp -= defs[next].rank.jp;
				setBought.accept(vars, next + 1);
				setLearned.accept(vars, Math.max(learned.applyAsDouble(vars), next + 1));
				vars.syncPlayerVariables(player);
			});
			if (next == 0)
				Compat.giveItemToPlayer(player, new ItemStack(BuiltInRegistries.ITEM.getValue(Identifier.fromNamespaceAndPath("naruto_shippuden", item))));
		}, Jutsus.track("", bought, -1, item, learned, tiers));
	}

	private static ServerLevel level(ServerPlayer player) {
		return (ServerLevel) player.level();
	}

	// ------------------------------------------------------------------ fire
	/** Five small fireballs in a fan. */
	private static void phoenixSageFire(ServerPlayer p) {
		for (int i = -2; i <= 2; i++) {
			JutsuProjectile fire = shoot(p, Element.FIRE, Shape.ORB, 0.45F, turned(p, i * 7, -2).scale(1.3), 4);
			fire.gravity = 0.012F;
			fire.life = 40;
			fire.onImpact = f -> puff(level(p), f.position(), Element.FIRE, 0.6F);
		}
		sound(level(p), p.getEyePosition(), SoundEvents.BLAZE_SHOOT, 1, 1.2F);
	}

	/** A great ball of fire that bursts into flames. */
	private static void greatFireball(ServerPlayer p) {
		JutsuProjectile ball = shoot(p, Element.FIRE, Shape.ORB, 2.2F, 0.9F, 12);
		ball.life = 45;
		ball.knockback = 1;
		ball.onImpact = f -> burst(level(p), f.position(), 3.5F, 10, 1, Element.FIRE, f);
		sound(level(p), p.getEyePosition(), SoundEvents.BLAZE_SHOOT, 1.5F, 0.6F);
	}

	/** Breathes a stream of fire for two seconds. */
	private static void greatFlame(ServerPlayer p) {
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
	private static void waterGun(ServerPlayer p) {
		channel(p, 9, 3, t -> {
			JutsuProjectile bullet = shoot(p, Element.WATER, Shape.ORB, 0.3F, 2.2F, 5);
			bullet.onImpact = b -> puff(level(p), b.position(), Element.WATER, 0.5F);
			sound(level(p), p.getEyePosition(), SoundEvents.PLAYER_SPLASH, 0.6F, 1.6F);
		});
	}

	/** A spinning wall of water around the caster for five seconds: pushes enemies out and stops projectiles. */
	private static void waterWall(ServerPlayer p) {
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
				target.needsSync = true;
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
	private static void waterShark(ServerPlayer p) {
		JutsuProjectile shark = shoot(p, Element.WATER, Shape.SHARK, 1.4F, 1.0F, 14);
		shark.homing = 0.12F;
		shark.life = 80;
		shark.knockback = 1.2F;
		shark.onImpact = s -> burst(level(p), s.position(), 3, 8, 1.2F, Element.WATER, s);
		sound(level(p), p.getEyePosition(), SoundEvents.PLAYER_SPLASH_HIGH_SPEED, 1.2F, 0.8F);
	}

	/** A dragon of fire or water that passes through everything in its way. */
	private static void dragon(ServerPlayer p, Element element, float damage, float radius, float knockback) {
		JutsuProjectile dragon = shoot(p, element, Shape.DRAGON, 1.6F, 0.95F, damage);
		dragon.pierce = -1;
		dragon.life = 55;
		dragon.knockback = knockback;
		dragon.onImpact = d -> burst(level(p), d.position(), radius, damage * 0.75F, knockback, element, d);
		sound(level(p), p.getEyePosition(), SoundEvents.ENDER_DRAGON_GROWL, 0.8F, element == Element.FIRE ? 1.3F : 1.6F);
	}

	// ------------------------------------------------------------------ wind
	/** A blast of wind from the palm that throws everything in front back. */
	private static void galePalm(ServerPlayer p) {
		ServerLevel level = level(p);
		Vec3 look = p.getLookAngle();
		for (LivingEntity target : cone(p, 8, 35)) {
			damage(p, target, 5, Element.WIND);
			target.push(look.x * 2.2, 0.45, look.z * 2.2);
			target.needsSync = true;
		}
		for (int i = 1; i <= 7; i++) {
			Vec3 at = p.getEyePosition().add(look.scale(i));
			level.sendParticles(ParticleTypes.GUST, at.x, at.y, at.z, 1, i * 0.12, i * 0.12, i * 0.12, 0);
		}
		sound(level, p.getEyePosition(), SoundEvents.WIND_CHARGE_BURST.value(), 1.2F, 0.8F);
	}

	/** Five rapid bullets of compressed air. */
	private static void vacuumSphere(ServerPlayer p) {
		channel(p, 15, 3, t -> {
			JutsuProjectile bullet = shoot(p, Element.WIND, Shape.ORB, 0.35F, 2.4F, 4);
			bullet.pierce = 1;
			bullet.onImpact = b -> level(p).sendParticles(ParticleTypes.GUST, b.getX(), b.getY(), b.getZ(), 1, 0, 0, 0, 0);
			sound(level(p), p.getEyePosition(), SoundEvents.BREEZE_SHOOT, 0.7F, 1.4F);
		});
	}

	/** Wraps the caster in wind for 20 seconds: faster, higher jumps, and melee hits blow enemies away. */
	private static void windCloak(ServerPlayer p) {
		p.addEffect(new MobEffectInstance(MobEffects.SPEED, 400, 1, false, false, true));
		p.addEffect(new MobEffectInstance(MobEffects.JUMP_BOOST, 400, 1, false, false, true));
		p.getPersistentData().putLong(Techniques.WIND_CLOAK, p.level().getGameTime() + 400);
		sound(level(p), p.position(), SoundEvents.BREEZE_WIND_CHARGE_BURST.value(), 1, 1.2F);
		channel(p, 400, 4, t -> level(p).sendParticles(ParticleTypes.SMALL_GUST, p.getX(), p.getY() + 1, p.getZ(), 2, 0.5, 0.6, 0.5, 0));
	}

	/** Thrown Rasenshuriken: on impact a storm of wind blades pulls enemies in and cuts them for three seconds. */
	private static void rasenshuriken(ServerPlayer p) {
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
					target.needsSync = true;
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
	private static final Predicate<BlockState> OPEN = BlockState::canBeReplaced;

	private static BlockState dripstone(SpeleothemThickness thickness) {
		return Blocks.POINTED_DRIPSTONE.defaultBlockState().setValue(PointedDripstoneBlock.TIP_DIRECTION, Direction.UP)
				.setValue(PointedDripstoneBlock.THICKNESS, thickness);
	}

	/** The ground on a column: the first open block with something solid under it, near y. */
	private static BlockPos ground(ServerLevel level, double x, double y, double z) {
		BlockPos pos = BlockPos.containing(x, y + 2, z);
		for (int i = 0; i < 6 && !(OPEN.test(level.getBlockState(pos)) && !OPEN.test(level.getBlockState(pos.below()))); i++)
			pos = pos.below();
		return pos;
	}

	/** Stone spikes burst out of the ground in a line, launching whatever stands there. */
	private static void earthSpikes(ServerPlayer p) {
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
				target.needsSync = true;
			}
		});
	}

	/** Raises a wall of earth in front of the caster that crumbles back after 12 seconds. */
	private static void earthWall(ServerPlayer p) {
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
	private static void earthGolem(ServerPlayer p) {
		ServerLevel level = level(p);
		Vec3 at = p.position().add(p.getLookAngle().multiply(1, 0, 1).normalize().scale(2));
		EarthGolemEntity.CustomEntity golem = new EarthGolemEntity.CustomEntity(EarthGolemEntity.entity, level);
		golem.snapTo(at.x, p.getY(), at.z, p.getYRot(), 0);
		golem.finalizeSpawn(level, level.getCurrentDifficultyAt(golem.blockPosition()), EntitySpawnReason.MOB_SUMMONED, null);
		golem.tame(p);
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
	private static void swamp(ServerPlayer p) {
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
	private static void chidoriSenbon(ServerPlayer p) {
		for (int i = -2; i <= 2; i++) {
			JutsuProjectile needle = shoot(p, Element.LIGHTNING, Shape.NEEDLE, 0.25F, turned(p, i * 5, 0).scale(2.6), 3);
			needle.life = 25;
			needle.knockback = 0;
		}
		sound(level(p), p.getEyePosition(), SoundEvents.TRIDENT_THROW.value(), 1, 1.6F);
	}

	/** A ball of lightning whose shock jumps to three more enemies nearby. */
	private static void lightningBall(ServerPlayer p) {
		JutsuProjectile ball = shoot(p, Element.LIGHTNING, Shape.ORB, 0.8F, 1.6F, 10);
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

	/** Kirin: the lightning beast dives from the sky onto the target, followed by a storm of bolts. */
	private static void kirin(ServerPlayer p) {
		ServerLevel level = level(p);
		Vec3 target = lookPoint(p, 40);
		Vec3 sky = target.add(0, 22, 0);
		level.sendParticles(ParticleTypes.LARGE_SMOKE, sky.x, sky.y, sky.z, 60, 4, 1, 4, 0.01);
		sound(level, target, SoundEvents.LIGHTNING_BOLT_THUNDER, 3, 0.7F);
		Mob beast = KirinEntity.entity.create(level, EntitySpawnReason.TRIGGERED);
		if (beast != null) {
			beast.setNoAi(true);
			beast.setPermanentlyInvulnerable(true);
			beast.snapTo(sky.x, sky.y, sky.z, p.getYRot(), 90);
			level.addFreshEntity(beast);
		}
		channel(p, 30, 1, t -> {
			if (beast != null && t < 20) {
				Vec3 pos = sky.lerp(target, (t + 1) / 20.0);
				beast.snapTo(pos.x, pos.y, pos.z, beast.getYRot(), 90);
				level.sendParticles(ParticleTypes.ELECTRIC_SPARK, pos.x, pos.y + 1, pos.z, 20, 0.8, 1.5, 0.8, 0.2);
			}
			if (t == 20) {
				if (beast != null)
					beast.discard();
				Techniques.strike(level, target, 5, 25, p);
			}
			if (t > 20 && t % 3 == 0) {
				double a = level.getRandom().nextDouble() * Math.PI * 2, r = 2 + level.getRandom().nextDouble() * 3;
				Techniques.strike(level, target.add(Math.cos(a) * r, 0, Math.sin(a) * r), 2.5F, 8, p);
			}
		});
	}
}
