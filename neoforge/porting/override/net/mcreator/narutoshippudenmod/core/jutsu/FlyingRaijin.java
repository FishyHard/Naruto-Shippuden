package net.mcreator.narutoshippudenmod.core.jutsu;

import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables;
import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables.PlayerVariables;
import net.mcreator.narutoshippudenmod.compat.Compat;
import net.mcreator.narutoshippudenmod.entity.JutsuEntities.FlyingThunderGodKunaiEntityEntity;
import net.mcreator.narutoshippudenmod.item.ProjectileItems.FlyingThunderGodKunaiBulletItem;
import net.mcreator.narutoshippudenmod.item.WeaponItems.FlyingThunderGodKunaiItem;

import net.minecraft.core.particles.DustParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.arrow.AbstractArrow;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.ProjectileImpactEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.jspecify.annotations.Nullable;

/**
 * The Flying Raijin (Flying Thunder God) Technique, Minato's space-time jutsu: the user marks places and people with a formula
 * and moves to a mark in an instant.
 * <ul>
 * <li>Right-click throws a marked kunai: where it lands a formula stays; a creature it hits carries the formula for a minute.</li>
 * <li>Sneak and right-click writes the formula on the ground where you stand.</li>
 * <li>Left-click moves you to the mark you look towards (or the newest one), behind a marked creature, facing it. Sneak while you
 * go to take whoever is touching you with you.</li>
 * </ul>
 * Up to three formulae stay on the ground (the oldest fades for a new one); only you see them, as a golden glimmer while you
 * hold the kunai.
 */
@EventBusSubscriber(modid = "naruto_shippuden")
public final class FlyingRaijin {
	private static final String MARKS = "naruto_shippuden:raijin_marks", READY = "naruto_shippuden:raijin_ready";
	private static final int MAX_MARKS = 3, MARKED_FOR = 1200;
	private static final double THROW_COST = 10, SEAL_COST = 20, JUMP_COST = 30;
	private static final DustParticleOptions GOLD = new DustParticleOptions(0xFFD84A, 1.1F);
	/** Creatures carrying someone's formula: caster → (creature → until). */
	private static final Map<UUID, Map<UUID, Long>> MARKED = new HashMap<>();

	private FlyingRaijin() {
	}

	private static @Nullable ServerPlayer player(Map<String, Object> deps) {
		return deps.get("entity") instanceof ServerPlayer p ? p : null;
	}

	private static boolean able(ServerPlayer p, double chakra) {
		PlayerVariables v = NarutoShippudenModVariables.get(p);
		if (v.shurikenjutsu < 25 || v.ninjutsu < 10) {
			p.sendOverlayMessage(Component.literal("Needs 25 Shurikenjutsu and 10 Ninjutsu"));
			return false;
		}
		if (v.ChakraAmount < chakra) {
			p.sendOverlayMessage(Component.literal("Not enough chakra"));
			return false;
		}
		NarutoShippudenModVariables.ifPresent(p, vars -> {
			vars.ChakraAmount -= chakra;
			vars.syncPlayerVariables(p);
		});
		return true;
	}

	// ------------------------------------------------------------------ marking
	/** Right-click: throw a marked kunai, or (sneaking) write the formula at your feet. */
	public static void use(Map<String, Object> deps) {
		ServerPlayer p = player(deps);
		if (p == null)
			return;
		if (p.isShiftKeyDown()) {
			if (able(p, SEAL_COST)) {
				addMark(p, p.position());
				p.sendOverlayMessage(Component.literal("Formula written (" + marks(p).size() + "/" + MAX_MARKS + ")"));
			}
			return;
		}
		if (p.getCooldowns().isOnCooldown(new net.minecraft.world.item.ItemStack(FlyingThunderGodKunaiItem.block)) || !able(p, THROW_COST))
			return;
		FlyingThunderGodKunaiBulletItem.ArrowCustomEntity kunai = new FlyingThunderGodKunaiBulletItem.ArrowCustomEntity(FlyingThunderGodKunaiBulletItem.arrow,
				p, p.level());
		kunai.setOwner(p);
		kunai.setBaseDamage(3);
		kunai.pickup = AbstractArrow.Pickup.DISALLOWED;
		kunai.setSilent(true);
		kunai.setPos(p.getX(), p.getEyeY() - 0.1, p.getZ());
		kunai.shoot(p.getLookAngle().x, p.getLookAngle().y, p.getLookAngle().z, 3, 0);
		p.level().addFreshEntity(kunai);
		p.getCooldowns().addCooldown(new net.minecraft.world.item.ItemStack(FlyingThunderGodKunaiItem.block), 10);
	}

	/** A thrown kunai landed: the formula stays where it stuck. */
	public static void landed(Entity kunai, Map<String, Object> deps) {
		if (kunai instanceof AbstractArrow arrow && arrow.getOwner() instanceof ServerPlayer p)
			addMark(p, kunai.position());
	}

	/** A thrown kunai hit a creature: it carries the formula for a minute. */
	@SubscribeEvent
	public static void hit(ProjectileImpactEvent event) {
		if (event.getProjectile().getType() != FlyingThunderGodKunaiBulletItem.arrow || !(event.getRayTraceResult() instanceof EntityHitResult hit)
				|| !(hit.getEntity() instanceof LivingEntity target) || !(event.getProjectile().getOwner() instanceof ServerPlayer p) || target == p)
			return;
		MARKED.computeIfAbsent(p.getUUID(), u -> new HashMap<>()).put(target.getUUID(), p.level().getGameTime() + MARKED_FOR);
		target.addEffect(new MobEffectInstance(MobEffects.GLOWING, 40, 0, false, false));
		p.sendOverlayMessage(Component.literal("Formula on " + target.getDisplayName().getString()));
	}

	private static ListTag marks(ServerPlayer p) {
		return p.getPersistentData().getListOrEmpty(MARKS);
	}

	private static void addMark(ServerPlayer p, Vec3 at) {
		ListTag list = marks(p).copy();
		String dimension = p.level().dimension().identifier().toString();
		while (list.size() >= MAX_MARKS)
			removeSeal(p, list.getCompoundOrEmpty(0), list, 0);
		CompoundTag mark = new CompoundTag();
		mark.putString("dimension", dimension);
		mark.putDouble("x", at.x);
		mark.putDouble("y", at.y);
		mark.putDouble("z", at.z);
		// the formula written on the ground
		FlyingThunderGodKunaiEntityEntity.CustomEntity seal = new FlyingThunderGodKunaiEntityEntity.CustomEntity(FlyingThunderGodKunaiEntityEntity.entity,
				p.level());
		seal.snapTo(at.x, at.y, at.z, p.getYRot(), 0);
		seal.setNoAi(true);
		p.level().addFreshEntity(seal);
		mark.putString("seal", seal.getUUID().toString());
		list.add(mark);
		p.getPersistentData().put(MARKS, list);
		((ServerLevel) p.level()).sendParticles(GOLD, at.x, at.y + 0.1, at.z, 20, 0.3, 0.05, 0.3, 0);
	}

	private static void removeSeal(ServerPlayer p, CompoundTag mark, ListTag list, int index) {
		list.remove(index);
		String seal = mark.getStringOr("seal", "");
		if (!seal.isEmpty() && p.level() instanceof ServerLevel level) {
			Entity entity = level.getEntity(UUID.fromString(seal));
			if (entity != null)
				entity.discard();
		}
	}

	// ------------------------------------------------------------------ moving
	private record Target(Vec3 at, float yRot, @Nullable LivingEntity creature) {
	}

	private static List<Target> targets(ServerPlayer p) {
		List<Target> targets = new ArrayList<>();
		String dimension = p.level().dimension().identifier().toString();
		for (Tag tag : marks(p))
			if (tag instanceof CompoundTag mark && mark.getStringOr("dimension", "").equals(dimension))
				targets.add(new Target(new Vec3(mark.getDoubleOr("x", 0), mark.getDoubleOr("y", 0), mark.getDoubleOr("z", 0)), p.getYRot(), null));
		Map<UUID, Long> marked = MARKED.getOrDefault(p.getUUID(), Map.of());
		long now = p.level().getGameTime();
		marked.values().removeIf(until -> until < now);
		for (UUID id : marked.keySet())
			if (((ServerLevel) p.level()).getEntity(id) instanceof LivingEntity creature && creature.isAlive()) {
				// behind them, facing them
				Vec3 facing = creature.getLookAngle().multiply(1, 0, 1).normalize();
				Vec3 behind = creature.position().subtract(facing.scale(creature.getBbWidth() / 2 + 0.9));
				targets.add(new Target(behind, creature.getYRot(), creature));
			}
		return targets;
	}

	/** Left-click: move to the mark looked towards (within 25 degrees), else the newest. */
	public static void swing(Map<String, Object> deps) {
		ServerPlayer p = player(deps);
		if (p == null || p.level().getGameTime() < p.getPersistentData().getLongOr(READY, 0))
			return;
		List<Target> targets = targets(p);
		if (targets.isEmpty())
			return;
		Vec3 eye = p.getEyePosition(), look = p.getLookAngle();
		Target best = null;
		double bestDot = Math.cos(Math.toRadians(25));
		for (Target t : targets) {
			double dot = t.at().add(0, 0.5, 0).subtract(eye).normalize().dot(look);
			if (dot > bestDot) {
				bestDot = dot;
				best = t;
			}
		}
		Target to = best != null ? best : targets.getLast();
		if (to.at().distanceTo(p.position()) < 1.5 || !able(p, JUMP_COST))
			return;
		p.getPersistentData().putLong(READY, p.level().getGameTime() + 8);
		ServerLevel level = (ServerLevel) p.level();
		// sneaking: whoever touches you comes along
		List<LivingEntity> along = p.isShiftKeyDown()
				? level.getEntitiesOfClass(LivingEntity.class, p.getBoundingBox().inflate(1.5), e -> e != p && e.isAlive() && e != to.creature())
				: List.of();
		flash(level, p.position());
		Vec3 from = p.position();
		p.teleportTo(to.at().x, to.at().y, to.at().z);
		if (to.creature() != null) {
			p.setYRot(to.yRot());
			p.connection.teleport(to.at().x, to.at().y, to.at().z, to.yRot(), p.getXRot());
		}
		p.fallDistance = 0;
		for (LivingEntity other : along)
			other.teleportTo(to.at().x + (other.getX() - from.x), to.at().y, to.at().z + (other.getZ() - from.z));
		flash(level, to.at());
	}

	private static void flash(ServerLevel level, Vec3 at) {
		level.sendParticles(GOLD, at.x, at.y + 1, at.z, 30, 0.35, 0.7, 0.35, 0.02);
		level.sendParticles(ParticleTypes.ELECTRIC_SPARK, at.x, at.y + 1, at.z, 12, 0.3, 0.6, 0.3, 0.3);
		level.playSound(null, at.x, at.y, at.z, Compat.sound("naruto_shippuden:flying_thunder_god_sound"), SoundSource.PLAYERS, 1, 1);
	}

	/** Holding the kunai, you see your formulae glimmer. */
	@SubscribeEvent
	public static void glimmer(PlayerTickEvent.Post event) {
		if (!(event.getEntity() instanceof ServerPlayer p) || p.tickCount % 10 != 0 || !p.getMainHandItem().is(FlyingThunderGodKunaiItem.block))
			return;
		ServerLevel level = (ServerLevel) p.level();
		for (Target t : targets(p))
			level.sendParticles(p, GOLD, true, false, t.at().x, t.at().y + (t.creature() != null ? t.creature().getBbHeight() + 0.3 : 0.15), t.at().z, 4, 0.2,
					0.05, 0.2, 0);
	}
}
