package net.mcreator.narutoshippudenmod.core.jutsu;

import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables;
import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables.PlayerVariables;
import net.mcreator.narutoshippudenmod.compat.Compat;
import net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques;
import net.mcreator.narutoshippudenmod.entity.JutsuEntities.ShadowCloneEntity;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.phys.Vec3;

import java.util.List;

/**
 * The Shadow Clone Technique: real clones that look like their maker (skin, armour, what they hold), fight at their side and
 * vanish in a puff of smoke when hit hard or after a minute. How many can be kept at once grows with Ninjutsu (one at the start,
 * up to eight: the Multiple Shadow Clone Technique), and each costs its share of chakra. Casting while sneaking dispels them all.
 */
public final class ShadowClones {
	private static final double CHAKRA_EACH = 25;
	private static final int LIFE = 1200;

	private ShadowClones() {
	}

	public static int limit(PlayerVariables v) {
		return (int) Math.min(8, 1 + Math.floor(v.ninjutsu / 15));
	}

	public static List<ShadowCloneEntity.CustomEntity> clonesOf(ServerPlayer p) {
		return p.level().getEntitiesOfClass(ShadowCloneEntity.CustomEntity.class, p.getBoundingBox().inflate(64), c -> c.isOwnedBy(p));
	}

	public static void cast(Entity entity) {
		if (!(entity instanceof ServerPlayer p))
			return;
		ServerLevel level = (ServerLevel) p.level();
		List<ShadowCloneEntity.CustomEntity> clones = clonesOf(p);
		if (p.isShiftKeyDown()) {
			clones.forEach(ShadowClones::dispel);
			p.sendOverlayMessage(Component.literal(clones.isEmpty() ? "No clones to release" : "Released " + clones.size() + " clone" + (clones.size() == 1 ? "" : "s")));
			return;
		}
		PlayerVariables v = NarutoShippudenModVariables.get(p);
		int room = limit(v) - clones.size(), afford = (int) Math.floor(v.ChakraAmount / CHAKRA_EACH), count = Math.min(room, afford);
		if (room <= 0) {
			p.sendOverlayMessage(Component.literal("You can't keep more than " + limit(v) + " clones"));
			return;
		}
		if (count <= 0) {
			p.sendOverlayMessage(Component.literal("Not enough chakra"));
			return;
		}
		NarutoShippudenModVariables.ifPresent(p, vars -> {
			vars.ChakraAmount -= count * CHAKRA_EACH;
			vars.syncPlayerVariables(p);
		});
		for (int i = 0; i < count; i++) {
			double a = (i + 0.5) * 2 * Math.PI / count + Math.toRadians(p.getYRot()), r = count > 3 ? 2.2 : 1.6;
			Vec3 at = p.position().add(Math.cos(a) * r, 0, Math.sin(a) * r);
			if (!level.noCollision(p.getBoundingBox().move(at.subtract(p.position()))))
				at = p.position();
			ShadowCloneEntity.CustomEntity clone = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, level);
			clone.snapTo(at.x, at.y, at.z, p.getYRot(), 0);
			clone.setYHeadRot(p.getYRot());
			clone.tame(p);
			clone.setCustomName(p.getDisplayName());
			clone.setCustomNameVisible(false);
			// a clone is as quick and strong as its maker, but one good hit dispels it
			clone.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(3 + v.taijutsu / 10);
			clone.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.32);
			level.addFreshEntity(clone);
			puff(level, clone);
			Techniques.after(level, LIFE, () -> {
				if (clone.isAlive())
					dispel(clone);
			});
		}
		level.playSound(null, p.getX(), p.getY(), p.getZ(), Compat.sound("naruto_shippuden:clone_death"), SoundSource.PLAYERS, 1, 1.4F);
		p.sendOverlayMessage(Component.literal("Shadow Clone Technique (" + (clones.size() + count) + "/" + limit(v) + ")"));
	}

	private static void puff(ServerLevel level, Entity clone) {
		level.sendParticles(ParticleTypes.POOF, clone.getX(), clone.getY() + 1, clone.getZ(), 20, 0.3, 0.6, 0.3, 0.04);
		level.sendParticles(ParticleTypes.CLOUD, clone.getX(), clone.getY() + 1, clone.getZ(), 8, 0.3, 0.6, 0.3, 0.02);
	}

	/** Gone in a puff of smoke. */
	public static void dispel(ShadowCloneEntity.CustomEntity clone) {
		if (clone.level() instanceof ServerLevel level) {
			puff(level, clone);
			level.playSound(null, clone.getX(), clone.getY(), clone.getZ(), Compat.sound("naruto_shippuden:clone_death"), SoundSource.NEUTRAL, 1, 1);
		}
		clone.discard();
	}
}
