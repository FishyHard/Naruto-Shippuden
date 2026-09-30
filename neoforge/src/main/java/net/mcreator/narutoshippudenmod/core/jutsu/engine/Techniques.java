package net.mcreator.narutoshippudenmod.core.jutsu.engine;

import net.mcreator.narutoshippudenmod.NarutoShippudenMod;
import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables;
import net.mcreator.narutoshippudenmod.core.Progression;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityTypes;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.decoration.ArmorStand;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.neoforged.neoforge.event.level.block.BreakBlockEvent;
import net.neoforged.neoforge.event.server.ServerStoppingEvent;
import net.neoforged.neoforge.event.tick.ServerTickEvent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.IntConsumer;
import java.util.function.Predicate;

import org.jspecify.annotations.Nullable;

/**
 * The building blocks every jutsu is made of: shooting projectiles, bursts, cones, channelled streams, dashes, strikes and
 * temporary blocks (walls, spikes, mud), plus damage, targeting and particles. Jutsu definitions only combine these.
 */
@EventBusSubscriber(modid = NarutoShippudenMod.MODID)
public final class Techniques {
	public static final ResourceKey<DamageType> JUTSU = ResourceKey.create(Registries.DAMAGE_TYPE,
			Identifier.fromNamespaceAndPath(NarutoShippudenMod.MODID, "jutsu"));

	private Techniques() {
	}

	// ------------------------------------------------------------------ damage and targets
	/** Jutsu damage grows with Ninjutsu: +1% per point, up to 2.5x. */
	public static float power(@Nullable Entity caster) {
		if (caster instanceof ServerPlayer player)
			return 1 + Math.min(1.5F, (float) NarutoShippudenModVariables.get(player).ninjutsu / 100F);
		// shinobi NPCs: set by their rank
		if (caster != null && caster.getPersistentData().contains("JutsuPower"))
			return caster.getPersistentData().getFloatOr("JutsuPower", 1);
		return 1;
	}

	/** Who a caster must not hit even though they aren't its summons (a shinobi's own village); set by ShinobiAI. */
	public static java.util.function.BiPredicate<Entity, Entity> ALLIES = (caster, target) -> false;

	/** The old jutsu's power tier (0 to 9), which grows with Ninjutsu (it used to be chosen with its own key and stat). */
	public static double jutsuPower(Entity entity) {
		return Math.min(9, Math.floor(NarutoShippudenModVariables.get(entity).ninjutsu / 10));
	}

	/** Hurts a target with a jutsu (direct = the projectile or the caster), adding the element's side effect. */
	public static void damage(Entity direct, LivingEntity target, float amount, Element element) {
		if (amount <= 0 || !(target.level() instanceof ServerLevel level))
			return;
		Entity caster = Progression.owner(direct);
		DamageSource source = new DamageSource(level.registryAccess().lookupOrThrow(Registries.DAMAGE_TYPE).getOrThrow(JUTSU), direct, caster);
		target.setInvulnerableTime(0);
		target.hurtServer(level, source, amount * power(caster));
		switch (element) {
			case FIRE -> target.igniteForSeconds(4);
			case WATER -> target.clearFire();
			case LIGHTNING, STORM -> target.addEffect(new MobEffectInstance(MobEffects.SLOWNESS, 30, 2, false, false));
			case ICE -> target.addEffect(new MobEffectInstance(MobEffects.SLOWNESS, 60, 3, false, false));
			case BOIL -> target.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 80, 1, false, false));
			case SMOKE -> target.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 40, 0, false, false));
			case INSECT -> target.addEffect(new MobEffectInstance(MobEffects.POISON, 60, 0, false, false));
			case SHADOW -> target.addEffect(new MobEffectInstance(MobEffects.SLOWNESS, 40, 2, false, false));
			case MIND -> target.addEffect(new MobEffectInstance(MobEffects.NAUSEA, 80, 0, false, false));
			case BLOOD -> target.addEffect(new MobEffectInstance(MobEffects.WITHER, 40, 0, false, false));
			// the Gentle Fist closes chakra points
			case CHAKRA -> target.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 100, 1, false, false));
			case SEAL -> target.addEffect(new MobEffectInstance(MobEffects.SLOWNESS, 40, 4, false, false));
			case GENJUTSU -> {
				target.addEffect(new MobEffectInstance(MobEffects.NAUSEA, 100, 0, false, false));
				target.addEffect(new MobEffectInstance(MobEffects.DARKNESS, 60, 0, false, false));
			}
			default -> {
			}
		}
	}

	/** Whether a jutsu cast by caster may hit this: not the caster, their summons and clones, or armor stands. */
	public static boolean isEnemy(@Nullable Entity caster, Entity target) {
		if (target == caster || target instanceof ArmorStand || !target.isAlive())
			return false;
		if (caster != null && ALLIES.test(caster, target))
			return false;
		return caster == null || Progression.owner(target) != caster;
	}

	public static List<LivingEntity> enemies(ServerLevel level, @Nullable Entity caster, AABB area, Predicate<LivingEntity> also) {
		return level.getEntitiesOfClass(LivingEntity.class, area, e -> isEnemy(caster, e) && also.test(e));
	}

	/** Damages enemies within radius (less at the edge) and throws them outwards. */
	public static void burst(ServerLevel level, Vec3 at, float radius, float damage, float knockback, Element element, Entity direct) {
		Entity caster = Progression.owner(direct);
		for (LivingEntity target : enemies(level, caster, new AABB(at, at).inflate(radius), e -> e.distanceToSqr(at) <= radius * radius)) {
			double falloff = 1 - 0.5 * target.distanceTo(direct) / radius;
			damage(direct, target, (float) (damage * Mth.clamp(falloff, 0.5, 1)), element);
			Vec3 away = target.position().subtract(at).normalize();
			target.push(away.x * knockback, 0.25 + knockback * 0.2, away.z * knockback);
			target.syncVelocity = true;
		}
		puff(level, at, element, radius);
		sound(level, at, element.impact, 1.2F, 0.9F + level.getRandom().nextFloat() * 0.2F);
	}

	/** Enemies in front of the caster within range and angle (degrees from the look direction). */
	public static List<LivingEntity> cone(LivingEntity caster, double range, double angle) {
		Vec3 eye = caster.getEyePosition(), look = caster.getLookAngle();
		double cos = Math.cos(Math.toRadians(angle));
		return enemies((ServerLevel) caster.level(), caster, caster.getBoundingBox().inflate(range), e -> {
			Vec3 to = e.getBoundingBox().getCenter().subtract(eye);
			return to.length() <= range && to.normalize().dot(look) >= cos;
		});
	}

	/** The block or point the caster looks at, at most range away. */
	public static Vec3 lookPoint(LivingEntity caster, double range) {
		Vec3 eye = caster.getEyePosition(), end = eye.add(caster.getLookAngle().scale(range));
		HitResult hit = caster.level().clip(new ClipContext(eye, end, ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, caster));
		return hit.getType() == HitResult.Type.MISS ? end : hit.getLocation();
	}

	// ------------------------------------------------------------------ projectiles
	/** A projectile from the caster's eyes along their look, with the given look, speed and damage. */
	public static JutsuProjectile shoot(LivingEntity caster, Element element, JutsuProjectile.Shape shape, float size, float speed, float damage) {
		return shoot(caster, element, shape, size, caster.getLookAngle().scale(speed), damage);
	}

	public static JutsuProjectile shoot(LivingEntity caster, Element element, JutsuProjectile.Shape shape, float size, Vec3 velocity, float damage) {
		JutsuProjectile projectile = new JutsuProjectile(JutsuEngine.PROJECTILE, caster.level());
		projectile.look(element, shape, size);
		projectile.setOwner(caster);
		Vec3 start = caster.getEyePosition().add(caster.getLookAngle().scale(0.6 + size / 2)).subtract(0, size / 2, 0);
		projectile.setPos(start);
		projectile.setDeltaMovement(velocity);
		projectile.damage = damage;
		caster.level().addFreshEntity(projectile);
		return projectile;
	}

	/** The look direction turned by yaw degrees (for fans of projectiles). */
	public static Vec3 turned(LivingEntity caster, float yaw, float pitch) {
		return Vec3.directionFromRotation(caster.getXRot() + pitch, caster.getYRot() + yaw);
	}

	// ------------------------------------------------------------------ particles and sound
	/** Client side: the trail a projectile leaves every tick. */
	public static void trail(Level level, JutsuProjectile projectile) {
		Element element = projectile.element();
		float size = projectile.size();
		Vec3 c = projectile.getBoundingBox().getCenter();
		int count = 1 + (int) (size * 2);
		for (int i = 0; i < count; i++) {
			double dx = (level.getRandom().nextDouble() - 0.5) * size, dy = (level.getRandom().nextDouble() - 0.5) * size,
					dz = (level.getRandom().nextDouble() - 0.5) * size;
			level.addParticle(element.trail, c.x + dx, c.y + dy, c.z + dz, 0, 0.01, 0);
		}
		if (level.getRandom().nextInt(3) == 0)
			level.addParticle(element.puff, c.x, c.y, c.z, 0, 0, 0);
	}

	/** An element-coloured puff of particles filling a sphere. */
	public static void puff(ServerLevel level, Vec3 at, Element element, float radius) {
		int count = (int) (radius * radius * 6);
		level.sendParticles(element.trail, at.x, at.y, at.z, count, radius / 2, radius / 2, radius / 2, 0.08);
		level.sendParticles(element.puff, at.x, at.y, at.z, count / 3 + 1, radius / 2, radius / 3, radius / 2, 0.02);
	}

	/** A line of particles (lightning arcs, chakra threads). */
	public static void line(ServerLevel level, ParticleOptions particle, Vec3 from, Vec3 to, double step) {
		Vec3 delta = to.subtract(from);
		int n = (int) Math.max(1, delta.length() / step);
		for (int i = 0; i <= n; i++) {
			Vec3 p = from.add(delta.scale(i / (double) n));
			level.sendParticles(particle, p.x, p.y, p.z, 1, 0.05, 0.05, 0.05, 0);
		}
	}

	/** Particles flying along a direction (count 0 makes the offset the velocity), for streams of fire, water and wind. */
	public static void spray(ServerLevel level, ParticleOptions particle, Vec3 from, Vec3 direction, double speed, double spread) {
		Vec3 d = direction.add((level.getRandom().nextDouble() - 0.5) * spread, (level.getRandom().nextDouble() - 0.5) * spread,
				(level.getRandom().nextDouble() - 0.5) * spread).normalize();
		level.sendParticles(particle, from.x, from.y, from.z, 0, d.x, d.y, d.z, speed);
	}

	public static void sound(ServerLevel level, Vec3 at, SoundEvent sound, float volume, float pitch) {
		level.playSound(null, at.x, at.y, at.z, sound, SoundSource.PLAYERS, volume, pitch);
	}

	// ------------------------------------------------------------------ movement
	/** Rushes the caster forward for a few ticks; enemies they pass through are hurt once and thrown. */
	public static void dash(ServerPlayer caster, double distance, float damage, Element element) {
		Vec3 look = caster.getLookAngle().multiply(1, 0, 1).normalize();
		int ticks = Math.max(3, (int) Math.round(distance / 1.4));
		List<Entity> struck = new ArrayList<>();
		sound((ServerLevel) caster.level(), caster.position(), element.cast, 1, 1.4F);
		channel(caster, ticks + 4, 1, tick -> {
			caster.fallDistance = 0;
			ServerLevel level = (ServerLevel) caster.level();
			if (tick < ticks) {
				caster.setDeltaMovement(look.x * 1.4, Math.max(caster.getDeltaMovement().y, 0.05), look.z * 1.4);
				caster.syncVelocity = true;
			}
			puff(level, caster.position().add(0, 1, 0), element, 0.6F);
			for (LivingEntity target : enemies(level, caster, caster.getBoundingBox().inflate(1.2), e -> !struck.contains(e))) {
				struck.add(target);
				damage(caster, target, damage, element);
				target.push(look.x * 1.2, 0.5, look.z * 1.2);
				target.syncVelocity = true;
			}
		});
	}

	/** A lightning bolt (only its look and sound) plus a jutsu burst where it lands. */
	public static void strike(ServerLevel level, Vec3 at, float radius, float damage, Entity direct) {
		LightningBolt bolt = EntityTypes.LIGHTNING_BOLT.create(level, EntitySpawnReason.TRIGGERED);
		if (bolt != null) {
			bolt.snapTo(at);
			bolt.setVisualOnly(true);
			level.addFreshEntity(bolt);
		}
		burst(level, at, radius, damage, 0.6F, Element.LIGHTNING, direct);
	}

	// ------------------------------------------------------------------ scheduling
	private record Task(ServerLevel level, @Nullable LivingEntity owner, int ticks, int every, IntConsumer step, int[] tick) {
	}

	private static final List<Task> TASKS = new ArrayList<>();

	/** Runs step every few ticks for a while (stops early if the owner dies or leaves). */
	public static void channel(LivingEntity owner, int ticks, int every, IntConsumer step) {
		TASKS.add(new Task((ServerLevel) owner.level(), owner, ticks, every, step, new int[1]));
	}

	/** Runs once after a delay. */
	public static void after(ServerLevel level, int delay, Runnable action) {
		TASKS.add(new Task(level, null, delay + 1, 1, t -> {
			if (t == delay)
				action.run();
		}, new int[1]));
	}

	@SubscribeEvent
	public static void tick(ServerTickEvent.Post event) {
		for (Task task : List.copyOf(TASKS)) {
			if (!task.level.tickRateManager().runsNormally())
				continue;
			int t = task.tick[0]++;
			if (task.owner != null && (!task.owner.isAlive() || task.owner.isRemoved())) {
				TASKS.remove(task);
				continue;
			}
			if (t % task.every == 0)
				task.step.accept(t);
			if (t + 1 >= task.ticks)
				TASKS.remove(task);
		}
		restoreBlocks(false);
	}

	// ------------------------------------------------------------------ temporary blocks
	private record Placed(ServerLevel level, BlockState original, BlockState placed, long until) {
	}

	private static final Map<BlockPos, Placed> PLACED = new HashMap<>();

	/** Puts a block that goes back to what was there after some ticks (and drops nothing if broken). */
	public static boolean place(ServerLevel level, BlockPos pos, BlockState state, int ticks, Predicate<BlockState> replaces) {
		BlockState old = level.getBlockState(pos);
		if (PLACED.containsKey(pos) || !replaces.test(old) || level.getBlockEntity(pos) != null)
			return false;
		level.setBlock(pos, state, Block.UPDATE_CLIENTS | Block.UPDATE_KNOWN_SHAPE);
		PLACED.put(pos.immutable(), new Placed(level, old, state, level.getGameTime() + ticks));
		return true;
	}

	private static void restoreBlocks(boolean all) {
		for (Iterator<Map.Entry<BlockPos, Placed>> it = PLACED.entrySet().iterator(); it.hasNext();) {
			Map.Entry<BlockPos, Placed> entry = it.next();
			Placed placed = entry.getValue();
			if (!all && placed.level.getGameTime() < placed.until)
				continue;
			if (placed.level.getBlockState(entry.getKey()).is(placed.placed.getBlock()))
				placed.level.setBlock(entry.getKey(), placed.original, Block.UPDATE_CLIENTS | Block.UPDATE_KNOWN_SHAPE);
			it.remove();
		}
	}

	@SubscribeEvent
	public static void broken(BreakBlockEvent event) {
		Placed placed = PLACED.remove(event.getPos());
		if (placed != null && event.getLevel() instanceof ServerLevel level) {
			event.setCanceled(true);
			level.setBlock(event.getPos(), placed.original, Block.UPDATE_ALL);
		}
	}

	@SubscribeEvent
	public static void stopping(ServerStoppingEvent event) {
		restoreBlocks(true);
		TASKS.clear();
	}
}
