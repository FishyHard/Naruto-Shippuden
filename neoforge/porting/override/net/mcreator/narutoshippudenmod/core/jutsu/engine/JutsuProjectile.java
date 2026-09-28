package net.mcreator.narutoshippudenmod.core.jutsu.engine;

import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

import java.util.HashSet;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

import org.jspecify.annotations.Nullable;

/**
 * Every jutsu projectile: a fireball, a dragon, a shark, senbon, a Rasenshuriken. The look (shape, element, size) is synced to
 * clients, which draw the glowing model and the particle trail; the behaviour (damage, homing, piercing, what happens on impact)
 * lives on the server only. Jutsu are short-lived, so they are never saved.
 */
public class JutsuProjectile extends Projectile {
	private static final EntityDataAccessor<Byte> ELEMENT = SynchedEntityData.defineId(JutsuProjectile.class, EntityDataSerializers.BYTE);
	private static final EntityDataAccessor<Byte> SHAPE = SynchedEntityData.defineId(JutsuProjectile.class, EntityDataSerializers.BYTE);
	private static final EntityDataAccessor<Float> SIZE = SynchedEntityData.defineId(JutsuProjectile.class, EntityDataSerializers.FLOAT);

	public float damage;
	public int life = 60;
	public float gravity;
	/** How strongly it turns towards the nearest enemy in front of it each tick (0 = flies straight). */
	public float homing;
	/** How many enemies it passes through before bursting (-1 = all). */
	public int pierce;
	public float knockback = 0.4F;
	public BiConsumer<JutsuProjectile, LivingEntity> onHit = (p, target) -> {
	};
	public Consumer<JutsuProjectile> onImpact = p -> {
	};
	private final Set<Entity> hit = new HashSet<>();
	/** Client only: where it has been, newest first (the dragon's body follows it). */
	public final java.util.ArrayDeque<Vec3> path = new java.util.ArrayDeque<>();
	private boolean done;

	public JutsuProjectile(EntityType<? extends JutsuProjectile> type, Level level) {
		super(type, level);
		noPhysics = true;
	}

	@Override
	protected void defineSynchedData(SynchedEntityData.Builder builder) {
		builder.define(ELEMENT, (byte) 0).define(SHAPE, (byte) 0).define(SIZE, 0.5F);
	}

	public JutsuProjectile look(Element element, Shape shape, float size) {
		entityData.set(ELEMENT, (byte) element.ordinal());
		entityData.set(SHAPE, (byte) shape.ordinal());
		entityData.set(SIZE, size);
		refreshDimensions();
		return this;
	}

	public Element element() {
		return Element.values()[entityData.get(ELEMENT)];
	}

	public Shape shape() {
		return Shape.values()[entityData.get(SHAPE)];
	}

	public float size() {
		return entityData.get(SIZE);
	}

	@Override
	public void onSyncedDataUpdated(EntityDataAccessor<?> accessor) {
		super.onSyncedDataUpdated(accessor);
		if (SIZE.equals(accessor))
			refreshDimensions();
	}

	@Override
	public EntityDimensions getDimensions(Pose pose) {
		return EntityDimensions.scalable(size(), size());
	}

	@Override
	public void tick() {
		super.tick();
		Vec3 motion = getDeltaMovement();
		if (level() instanceof ServerLevel server) {
			if (tickCount > life) {
				impact(position());
				return;
			}
			if (homing > 0)
				motion = steer(server, motion);
			motion = motion.add(0, -gravity, 0);
			// trace from the centre: big projectiles would otherwise scrape the ground with their bottom edge
			Vec3 centre = new Vec3(0, size() / 2, 0), from = position().add(centre), to = from.add(motion);
			BlockHitResult block = server.clip(new ClipContext(from, to, ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, this));
			if (block.getType() != HitResult.Type.MISS)
				to = block.getLocation();
			AABB swept = getBoundingBox().expandTowards(to.subtract(from)).inflate(0.3);
			for (LivingEntity target : server.getEntitiesOfClass(LivingEntity.class, swept, this::canHit)) {
				hit.add(target);
				Techniques.damage(this, target, damage, element());
				if (knockback > 0)
					target.push(motion.normalize().x * knockback, 0.15 * knockback, motion.normalize().z * knockback);
				target.syncVelocity = true;
				onHit.accept(this, target);
				if (pierce >= 0 && hit.size() > pierce) {
					impact(target.position().add(0, target.getBbHeight() / 2, 0));
					return;
				}
			}
			if (block.getType() != HitResult.Type.MISS) {
				impact(to.subtract(centre));
				return;
			}
		} else {
			Techniques.trail(level(), this);
			if (shape() == Shape.DRAGON && path.size() > 4)
				for (int i = 0; i < 3; i++) {
					// the body burns along its whole length
					Vec3 at = path.stream().skip(level().getRandom().nextInt(Math.min(path.size(), 30))).findFirst().orElse(position());
					level().addParticle(element().trail, at.x + (random.nextDouble() - 0.5) * size(), at.y + random.nextDouble() * size(),
							at.z + (random.nextDouble() - 0.5) * size(), 0, 0.02, 0);
				}
			path.addFirst(position());
			if (path.size() > 80)
				path.removeLast();
		}
		setDeltaMovement(motion);
		setPos(position().add(motion));
		face(motion);
	}

	private boolean canHit(LivingEntity target) {
		return target.isAlive() && !hit.contains(target) && Techniques.isEnemy(getOwner(), target);
	}

	private Vec3 steer(ServerLevel server, Vec3 motion) {
		double speed = motion.length();
		LivingEntity best = null;
		double bestScore = 0.6;
		for (LivingEntity target : server.getEntitiesOfClass(LivingEntity.class, getBoundingBox().inflate(16), this::canHit)) {
			Vec3 to = target.getBoundingBox().getCenter().subtract(position());
			double score = to.normalize().dot(motion.normalize()) - to.length() / 64;
			if (score > bestScore) {
				bestScore = score;
				best = target;
			}
		}
		if (best == null)
			return motion;
		Vec3 wanted = best.getBoundingBox().getCenter().subtract(position()).normalize().scale(speed);
		return motion.lerp(wanted, homing).normalize().scale(speed);
	}

	private void face(Vec3 motion) {
		if (motion.lengthSqr() < 1.0E-6)
			return;
		double horizontal = motion.horizontalDistance();
		setYRot((float) (Mth.atan2(motion.x, motion.z) * Mth.RAD_TO_DEG));
		setXRot((float) (Mth.atan2(motion.y, horizontal) * Mth.RAD_TO_DEG));
		if (tickCount == 1) {
			yRotO = getYRot();
			xRotO = getXRot();
		}
	}

	/** Ends the jutsu here (once): runs its impact effect and disappears. */
	public void impact(Vec3 at) {
		if (done)
			return;
		done = true;
		setPos(at);
		onImpact.accept(this);
		discard();
	}

	public @Nullable LivingEntity caster() {
		return getOwner() instanceof LivingEntity living ? living : null;
	}

	@Override
	public boolean hurtServer(ServerLevel level, DamageSource source, float amount) {
		return false;
	}

	@Override
	public boolean shouldBeSaved() {
		return false;
	}

	@Override
	protected void readAdditionalSaveData(ValueInput input) {
	}

	@Override
	protected void addAdditionalSaveData(ValueOutput output) {
	}

	/** What the client draws. */
	public enum Shape {
		/** A glowing ball of chakra (fireball, water bullet, lightning ball). */
		ORB,
		/** A long serpent that follows its flight path (fire and water dragons). */
		DRAGON,
		SHARK,
		RASENSHURIKEN,
		/** A thin needle (senbon). */
		NEEDLE,
		/** Nothing but the particle trail (wind bullets). */
		NONE,
		/** A glowing cube (Dust Release). */
		CUBE
	}
}
