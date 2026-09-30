package net.mcreator.narutoshippudenmod.core.jutsu;

import static net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.channel;
import static net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.enemies;
import static net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.sound;

import net.mcreator.narutoshippudenmod.core.jutsu.engine.Element;
import net.mcreator.narutoshippudenmod.core.jutsu.engine.JutsuProjectile;
import net.mcreator.narutoshippudenmod.core.jutsu.engine.JutsuProjectile.Shape;
import net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques;

import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.GoalSelector;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import java.util.EnumSet;

/**
 * Kurama, the Nine-Tailed Fox, remade (model, textures, hitboxes and animations untouched; its roar animation plays with the big
 * attacks). It senses the ill will of players from far off and comes for them:
 * <ul>
 * <li>close in front, claw swipes; close at the sides or behind, a sweep of its nine tails;</li>
 * <li>a roar that blasts everything in front away (with the roar animation);</li>
 * <li>the Tailed Beast Ball: chakra drawn in to its mouth for two seconds, a black sphere growing there, then fired at the enemy
 * for a huge blast; and a volley of smaller ones;</li>
 * <li>a leap at far enemies that lands in a shockwave.</li>
 * </ul>
 * Below half health it fights harder and faster. It heals slowly by itself (it used to heal every tick, so it could not be killed).
 * Nothing it does breaks blocks.
 */
public final class Kurama {
	/** Entity event: the roar animation (see client/KuramaAnimation). */
	private static final byte ROAR = 100;

	private Kurama() {
	}

	public static void goals(PathfinderMob kurama, GoalSelector goals, GoalSelector targets) {
		goals.addGoal(0, new FloatGoal(kurama));
		goals.addGoal(1, new Fight(kurama));
		goals.addGoal(5, new WaterAvoidingRandomStrollGoal(kurama, 0.6));
		goals.addGoal(6, new RandomLookAroundGoal(kurama));
		targets.addGoal(1, new HurtByTargetGoal(kurama));
		targets.addGoal(2, new NearestAttackableTargetGoal<>(kurama, Player.class, false));
	}

	/** Every tick (both sides; the server does the work): slow healing, a faint chakra glow, reach and footing for its size. */
	public static void tick(Mob kurama) {
		if (!(kurama.level() instanceof ServerLevel level))
			return;
		if (kurama.tickCount == 1) {
			base(kurama, Attributes.FOLLOW_RANGE, 64);
			base(kurama, Attributes.STEP_HEIGHT, 3);
		}
		int every = kurama.getTarget() == null ? 20 : 100;
		if (kurama.tickCount % every == 0 && kurama.getHealth() < kurama.getMaxHealth())
			kurama.heal(kurama.getTarget() == null ? 4 : 2);
		boolean enraged = kurama.getHealth() < kurama.getMaxHealth() / 2;
		if (kurama.tickCount % (enraged ? 1 : 3) == 0) {
			AABB box = kurama.getBoundingBox();
			double x = Mth.lerp(level.getRandom().nextDouble(), box.minX, box.maxX), y = Mth.lerp(level.getRandom().nextDouble(), box.minY, box.maxY),
					z = Mth.lerp(level.getRandom().nextDouble(), box.minZ, box.maxZ);
			level.sendParticles(Element.KURAMA.trail, x, y, z, 1, 0.3, 0.3, 0.3, 0.01);
		}
	}

	private static void base(Mob mob, net.minecraft.core.Holder<net.minecraft.world.entity.ai.attributes.Attribute> attribute, double value) {
		AttributeInstance instance = mob.getAttribute(attribute);
		if (instance != null)
			instance.setBaseValue(value);
	}

	/** Where its facing points (the body, not the head, so the claws and roar go where it stands turned). */
	static Vec3 front(Mob kurama) {
		return Vec3.directionFromRotation(0, kurama.yBodyRot);
	}

	/** Its mouth: at the front of the head. */
	static Vec3 mouth(Mob kurama) {
		return kurama.position().add(0, kurama.getBbHeight() * 0.62, 0).add(front(kurama).scale(kurama.getBbWidth() * 0.55));
	}

	static final class Fight extends Goal {
		private final PathfinderMob kurama;
		private int claw, tails = 40, roar = 120, ball = 160, volley = 220, leap = 100, busy;

		Fight(PathfinderMob kurama) {
			this.kurama = kurama;
			setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
		}

		@Override
		public boolean canUse() {
			LivingEntity target = kurama.getTarget();
			return target != null && target.isAlive();
		}

		@Override
		public boolean requiresUpdateEveryTick() {
			return true;
		}

		@Override
		public void stop() {
			kurama.getNavigation().stop();
			busy = 0;
		}

		@Override
		public void tick() {
			LivingEntity target = kurama.getTarget();
			if (target == null)
				return;
			ServerLevel level = (ServerLevel) kurama.level();
			boolean enraged = kurama.getHealth() < kurama.getMaxHealth() / 2;
			int step = enraged ? 2 : 1;
			claw -= step;
			tails -= step;
			roar -= step;
			ball -= step;
			volley -= step;
			leap -= step;
			kurama.getLookControl().setLookAt(target, 10, 20);
			Vec3 to = target.position().subtract(kurama.position());
			double distance = Math.sqrt(to.x * to.x + to.z * to.z);
			// turn the body towards the enemy (slowly: it's huge)
			float wanted = (float) (Mth.atan2(to.z, to.x) * Mth.RAD_TO_DEG) - 90;
			kurama.setYBodyRot(Mth.approachDegrees(kurama.yBodyRot, wanted, 6));
			kurama.setYRot(kurama.yBodyRot);
			if (busy > 0) {
				busy--;
				kurama.getNavigation().stop();
				return;
			}
			double reach = kurama.getBbWidth() * 0.5 + 7;
			double facing = to.multiply(1, 0, 1).normalize().dot(front(kurama));
			boolean sees = kurama.getSensing().hasLineOfSight(target);
			if (distance < reach && facing > 0.45 && claw <= 0) {
				clawSwipe(level, target);
				claw = 30;
				busy = 10;
			} else if (distance < reach + 1 && facing <= 0.45 && tails <= 0) {
				tailSweep(level);
				tails = 90;
				busy = 14;
			} else if (distance < 24 && facing > 0.6 && roar <= 0 && kurama.getRandom().nextInt(20) == 0) {
				roar(level);
				roar = 260;
				busy = 30;
			} else if (distance > 14 && distance < 60 && sees && ball <= 0 && facing > 0.8) {
				tailedBeastBall(level, target);
				ball = 420;
				volley = Math.max(volley, 120);
				busy = 60;
			} else if (distance > 10 && distance < 44 && sees && volley <= 0 && facing > 0.8) {
				volley(level, target);
				volley = 320;
				busy = 40;
			} else if (distance > 24 && kurama.onGround() && leap <= 0 && sees) {
				leap(level, to);
				leap = 220;
				busy = 20;
			}
			// walk in to claw range; stay put (just turning) once there
			if (busy == 0) {
				if (distance > reach - 2)
					kurama.getMoveControl().setWantedPosition(target.getX(), target.getY(), target.getZ(), enraged ? 1.3 : 1.0);
				else
					kurama.getNavigation().stop();
			}
		}

		private void log(String attack) {
			if (Boolean.getBoolean("naruto.devtest"))
				net.mcreator.narutoshippudenmod.NarutoShippudenMod.LOGGER.info("DEVTEST kurama attack {}", attack);
		}

		private void roarAnimation(ServerLevel level) {
			level.broadcastEntityEvent(kurama, ROAR);
		}

		/** A swipe of the claws across its front: everything there is torn and thrown aside. */
		private void clawSwipe(ServerLevel level, LivingEntity target) {
			log("clawSwipe");
			Vec3 front = front(kurama), side = new Vec3(-front.z, 0, front.x);
			Vec3 centre = kurama.position().add(front.scale(kurama.getBbWidth() * 0.5 + 3)).add(0, 2, 0);
			for (int i = -4; i <= 4; i++) {
				Vec3 at = centre.add(side.scale(i * 1.4)).add(front.scale(-Math.abs(i) * 0.4)).add(0, i * 0.3, 0);
				level.sendParticles(ParticleTypes.SWEEP_ATTACK, at.x, at.y, at.z, 1, 0, 0, 0, 0);
				level.sendParticles(Element.KURAMA.trail, at.x, at.y, at.z, 3, 0.3, 0.3, 0.3, 0.02);
			}
			sound(level, centre, SoundEvents.RAVAGER_ATTACK, 3, 0.6F);
			sound(level, centre, SoundEvents.PLAYER_ATTACK_SWEEP, 3, 0.5F);
			for (LivingEntity victim : enemies(level, kurama, new AABB(centre, centre).inflate(7, 5, 7), e -> {
				Vec3 d = e.position().subtract(kurama.position()).multiply(1, 0, 1);
				return d.normalize().dot(front) > 0.3 && d.length() < kurama.getBbWidth() * 0.5 + 8;
			})) {
				Techniques.damage(kurama, victim, 16, Element.KURAMA);
				Vec3 away = side.scale(kurama.getRandom().nextBoolean() ? 1 : -1).add(front);
				victim.push(away.x * 1.4, 0.6, away.z * 1.4);
				victim.syncVelocity = true;
			}
		}

		/** Its nine tails sweep all around it: whatever is beside or behind it is thrown far. */
		private void tailSweep(ServerLevel level) {
			log("tailSweep");
			Vec3 c = kurama.position();
			double radius = kurama.getBbWidth() * 0.5 + 7;
			sound(level, c, SoundEvents.WARDEN_ATTACK_IMPACT, 3, 0.6F);
			channel(kurama, 10, 1, t -> {
				double a = Math.toRadians(kurama.yBodyRot + 90) + t * Math.PI / 5;
				for (int k = 0; k < 3; k++) {
					double r = radius * (0.5 + k * 0.25);
					level.sendParticles(Element.KURAMA.puff, c.x + Math.cos(a) * r, c.y + 1 + k, c.z + Math.sin(a) * r, 3, 0.4, 0.4, 0.4, 0.02);
					level.sendParticles(ParticleTypes.CLOUD, c.x + Math.cos(a) * r, c.y + 0.3, c.z + Math.sin(a) * r, 2, 0.5, 0.1, 0.5, 0.05);
				}
			});
			for (LivingEntity victim : enemies(level, kurama, kurama.getBoundingBox().inflate(7, 2, 7), e -> e.position().distanceTo(c) < radius + 1)) {
				Techniques.damage(kurama, victim, 12, Element.KURAMA);
				Vec3 away = victim.position().subtract(c).multiply(1, 0, 1).normalize();
				victim.push(away.x * 2.4, 0.8, away.z * 2.4);
				victim.syncVelocity = true;
			}
		}

		/** A roar that tears the air: everything in front is blasted away, dazed and slowed. */
		private void roar(ServerLevel level) {
			log("roar");
			roarAnimation(level);
			Vec3 mouth = mouth(kurama), front = front(kurama);
			sound(level, mouth, SoundEvents.RAVAGER_ROAR, 5, 0.4F);
			sound(level, mouth, SoundEvents.ENDER_DRAGON_GROWL, 3, 0.6F);
			channel(kurama, 14, 2, t -> {
				Vec3 at = mouth.add(front.scale(3 + t * 1.8)).subtract(0, t * 0.4, 0);
				level.sendParticles(ParticleTypes.SONIC_BOOM, at.x, at.y, at.z, 1, 0, 0, 0, 0);
				level.sendParticles(ParticleTypes.CLOUD, at.x, at.y, at.z, 10, 1 + t * 0.3, 1 + t * 0.2, 1 + t * 0.3, 0.05);
			});
			for (LivingEntity victim : enemies(level, kurama, kurama.getBoundingBox().inflate(26), e -> {
				Vec3 d = e.position().subtract(kurama.position());
				return d.length() < 30 && d.multiply(1, 0, 1).normalize().dot(front) > 0.5;
			})) {
				Techniques.damage(kurama, victim, 8, Element.KURAMA);
				victim.push(front.x * 3.2, 0.9, front.z * 3.2);
				victim.syncVelocity = true;
				victim.addEffect(new MobEffectInstance(MobEffects.NAUSEA, 120, 0, false, false));
				victim.addEffect(new MobEffectInstance(MobEffects.SLOWNESS, 60, 2, false, false));
			}
		}

		/**
		 * The Tailed Beast Ball: black and white chakra is drawn in to the open mouth and packed into a sphere that grows for two
		 * seconds, then it is fired at the enemy and bursts in a huge blast.
		 */
		private void tailedBeastBall(ServerLevel level, LivingEntity target) {
			log("tailedBeastBall");
			roarAnimation(level);
			JutsuProjectile ball = ClanJutsu.spawn(kurama, Element.BIJU, Shape.ORB, 0.3F, mouth(kurama), Vec3.ZERO, 30);
			ball.life = 200;
			ball.pierce = -1;
			ball.knockback = 2;
			sound(level, mouth(kurama), SoundEvents.WARDEN_SONIC_CHARGE, 4, 0.5F);
			channel(kurama, 50, 1, t -> {
				if (!ball.isAlive())
					return;
				Vec3 mouth = mouth(kurama);
				if (t < 40) {
					ball.setPos(mouth.subtract(0, ball.size() / 2, 0));
					ball.setDeltaMovement(Vec3.ZERO);
					ball.look(Element.BIJU, Shape.ORB, 0.3F + t * 0.09F);
					// chakra drawn in from all around
					for (int i = 0; i < 6; i++) {
						Vec3 d = new Vec3(level.getRandom().nextGaussian(), level.getRandom().nextGaussian(), level.getRandom().nextGaussian()).normalize();
						Vec3 from = mouth.add(d.scale(7));
						Vec3 in = mouth.subtract(from).normalize();
						level.sendParticles(i % 2 == 0 ? Element.BIJU.trail : ParticleTypes.END_ROD, from.x, from.y, from.z, 0, in.x, in.y, in.z, 0.45);
					}
					if (t % 8 == 0)
						sound(level, mouth, SoundEvents.BEACON_AMBIENT, 3, 0.5F + t * 0.02F);
					return;
				}
				if (t == 40) {
					roarAnimation(level);
					Vec3 aim = target.getBoundingBox().getCenter().add(target.getDeltaMovement().scale(mouth.distanceTo(target.position()) / 1.5));
					ball.setDeltaMovement(aim.subtract(ball.getBoundingBox().getCenter()).normalize().scale(1.5));
					ball.onImpact = b -> {
						Vec3 at = b.position();
						Techniques.burst(level, at, 9, 30, 2.5F, Element.BIJU, b);
						level.sendParticles(ParticleTypes.EXPLOSION_EMITTER, at.x, at.y, at.z, 3, 2, 1, 2, 0);
						level.sendParticles(Element.BIJU.trail, at.x, at.y, at.z, 120, 5, 3, 5, 0.2);
						sound(level, at, SoundEvents.GENERIC_EXPLODE.value(), 6, 0.5F);
					};
					sound(level, mouth, SoundEvents.WARDEN_SONIC_BOOM, 5, 0.5F);
				}
			});
		}

		/** Smaller Tailed Beast Balls fired one after another. */
		private void volley(ServerLevel level, LivingEntity target) {
			log("volley");
			roarAnimation(level);
			channel(kurama, 30, 6, t -> {
				if (!target.isAlive())
					return;
				Vec3 mouth = mouth(kurama);
				Vec3 aim = target.getBoundingBox().getCenter().add(target.getDeltaMovement().scale(mouth.distanceTo(target.position()) / 1.8));
				JutsuProjectile shot = ClanJutsu.spawn(kurama, Element.BIJU, Shape.ORB, 1.3F, mouth, aim.subtract(mouth).normalize().scale(1.8), 10);
				shot.life = 50;
				shot.onImpact = b -> {
					Techniques.burst(level, b.position(), 3.5F, 10, 1.2F, Element.BIJU, b);
					level.sendParticles(ParticleTypes.EXPLOSION, b.getX(), b.getY(), b.getZ(), 1, 0, 0, 0, 0);
				};
				sound(level, mouth, SoundEvents.WARDEN_SONIC_BOOM, 2, 1.4F);
			});
		}

		/** A leap at a far enemy; where it lands the ground shakes and everything near is thrown up. */
		private void leap(ServerLevel level, Vec3 to) {
			log("leap");
			Vec3 flat = to.multiply(1, 0, 1);
			double speed = Math.min(2.4, flat.length() / 12);
			kurama.setDeltaMovement(flat.normalize().scale(speed).add(0, 1.1, 0));
			kurama.syncVelocity = true;
			sound(level, kurama.position(), SoundEvents.RAVAGER_STEP, 4, 0.5F);
			boolean[] landed = { false };
			channel(kurama, 80, 1, t -> {
				kurama.fallDistance = 0;
				if (landed[0] || t < 5 || !kurama.onGround())
					return;
				landed[0] = true;
				Vec3 c = kurama.position();
				BlockState ground = level.getBlockState(kurama.blockPosition().below());
				if (!ground.isAir())
					level.sendParticles(new BlockParticleOption(ParticleTypes.BLOCK, ground), c.x, c.y + 0.2, c.z, 200, 6, 0.3, 6, 0.3);
				level.sendParticles(ParticleTypes.EXPLOSION, c.x, c.y + 0.5, c.z, 6, 5, 0.3, 5, 0);
				sound(level, c, SoundEvents.GENERIC_EXPLODE.value(), 4, 0.5F);
				for (LivingEntity victim : enemies(level, kurama, kurama.getBoundingBox().inflate(9, 3, 9), e -> true)) {
					Techniques.damage(kurama, victim, 16, Element.KURAMA);
					victim.push(0, 1.1, 0);
					victim.syncVelocity = true;
				}
			});
		}
	}
}
