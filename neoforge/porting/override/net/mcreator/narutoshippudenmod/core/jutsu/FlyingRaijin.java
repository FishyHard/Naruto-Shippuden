package net.mcreator.narutoshippudenmod.core.jutsu;

import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables;
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
 * and moves to a mark in an instant. The Flying Raijin Kunai is a technique item: its wheel chooses what right-click does.
 * <ol>
 * <li>Throw Marked Kunai: where it lands a formula stays; a creature it hits carries the formula for a minute.</li>
 * <li>Write Formula: the formula on the ground where you stand.</li>
 * <li>Marking Strike: the creature in front of you, and for ten seconds every creature you hit, carries the formula.</li>
 * <li>Flying Raijin: move to the mark you look towards (or the newest), behind a marked creature, facing it.</li>
 * <li>Flying Raijin: Level Two: the same, taking everyone who touches you along.</li>
 * <li>Release Formulae: erase every formula you have written.</li>
 * </ol>
 * Up to three formulae stay on the ground (the oldest fades for a new one); only you see them, as a golden glimmer while you
 * hold the kunai.
 */
@EventBusSubscriber(modid = "naruto_shippuden")
public final class FlyingRaijin {
	private static final String MARKS = "naruto_shippuden:raijin_marks";
	private static final int MAX_MARKS = 3, MARKED_FOR = 1200;
	private static final double THROW_COST = 10, SEAL_COST = 20, JUMP_COST = 30;
	private static final DustParticleOptions GOLD = new DustParticleOptions(0xFFD84A, 1.1F);
	/** Creatures carrying someone's formula: caster → (creature → until). */
	private static final Map<UUID, Map<UUID, Long>> MARKED = new HashMap<>();

	private FlyingRaijin() {
	}

	private static final String STRIKING = "naruto_shippuden:raijin_strike";

	/** The kunai's wheel. */
	static void register() {
		String[] names = { "Throw Marked Kunai", "Write Formula", "Marking Strike", "Flying Raijin", "Flying Raijin: Level Two", "Release Formulae" };
		double[] chakra = { THROW_COST, SEAL_COST, 20, JUMP_COST, 60, 0 };
		Jutsus.JutsuSpec[] specs = new Jutsus.JutsuSpec[names.length];
		for (int i = 0; i < names.length; i++)
			specs[i] = Jutsus.jutsu(names[i], v -> names.length, i + 1, "Shurikenjutsu", v -> v.shurikenjutsu, i == 4 ? 35 : 25, chakra[i],
					i == 4 ? new int[] { 60, 50, 40, 30, 20 } : new int[] { 10, 10, 10, 10, 10 });
		Jutsus.technique("flying_thunder_god_kunai", v -> v.flyingthundergodkunaiteleportselect, (v, i) -> v.flyingthundergodkunaiteleportselect = i,
				v -> v.ninjutsu >= 10, deps -> {
					if (deps.get("entity") instanceof ServerPlayer p)
						cast(p, (int) NarutoShippudenModVariables.get(p).flyingthundergodkunaiteleportselect, chakra);
				}, specs);
		Jutsus.TECHNIQUES.get(net.minecraft.resources.Identifier.fromNamespaceAndPath("naruto_shippuden", "flying_thunder_god_kunai")).requirementMessage =
				"Needs 10 Ninjutsu";
	}

	private static void cast(ServerPlayer p, int option, double[] chakra) {
		NarutoShippudenModVariables.ifPresent(p, vars -> {
			vars.ChakraAmount -= chakra[Math.max(0, Math.min(option, chakra.length - 1))];
			vars.syncPlayerVariables(p);
		});
		switch (option) {
			case 1 -> {
				addMark(p, p.position());
				p.sendOverlayMessage(Component.literal("Formula written (" + marks(p).size() + "/" + MAX_MARKS + ")"));
			}
			case 2 -> strike(p);
			case 3 -> jump(p, false);
			case 4 -> jump(p, true);
			case 5 -> release(p);
			default -> throwKunai(p);
		}
	}

	private static void throwKunai(ServerPlayer p) {
		FlyingThunderGodKunaiBulletItem.ArrowCustomEntity kunai = new FlyingThunderGodKunaiBulletItem.ArrowCustomEntity(FlyingThunderGodKunaiBulletItem.arrow,
				p, p.level());
		kunai.setOwner(p);
		kunai.setBaseDamage(3);
		kunai.pickup = AbstractArrow.Pickup.DISALLOWED;
		kunai.setSilent(true);
		kunai.setPos(p.getX(), p.getEyeY() - 0.1, p.getZ());
		kunai.shoot(p.getLookAngle().x, p.getLookAngle().y, p.getLookAngle().z, 3, 0);
		p.level().addFreshEntity(kunai);
	}

	private static void mark(ServerPlayer p, LivingEntity target) {
		MARKED.computeIfAbsent(p.getUUID(), u -> new HashMap<>()).put(target.getUUID(), p.level().getGameTime() + MARKED_FOR);
		target.addEffect(new MobEffectInstance(MobEffects.GLOWING, 40, 0, false, false));
		((ServerLevel) p.level()).sendParticles(GOLD, target.getX(), target.getY() + target.getBbHeight() / 2, target.getZ(), 16, 0.3, 0.4, 0.3, 0);
		p.sendOverlayMessage(Component.literal("Formula on " + target.getDisplayName().getString()));
	}

	/** Marking Strike: a touch marks the creature in front of you, and your hits mark for ten seconds. */
	private static void strike(ServerPlayer p) {
		p.getPersistentData().putLong(STRIKING, p.level().getGameTime() + 200);
		LivingEntity target = ClanJutsu.target(p, 4);
		if (target != null)
			mark(p, target);
		else
			p.sendOverlayMessage(Component.literal("Your hits mark for 10 seconds"));
	}

	@SubscribeEvent
	public static void hitMarks(net.neoforged.neoforge.event.entity.living.LivingDamageEvent.Post event) {
		if (event.getSource().getDirectEntity() instanceof ServerPlayer p && event.getEntity() != p
				&& p.level().getGameTime() < p.getPersistentData().getLongOr(STRIKING, 0))
			mark(p, event.getEntity());
	}

	/** Release Formulae: every formula written fades. */
	private static void release(ServerPlayer p) {
		ListTag list = marks(p).copy();
		int count = list.size() + MARKED.getOrDefault(p.getUUID(), Map.of()).size();
		while (!list.isEmpty())
			removeSeal(p, list.getCompoundOrEmpty(0), list, 0);
		p.getPersistentData().put(MARKS, list);
		MARKED.remove(p.getUUID());
		p.sendOverlayMessage(Component.literal(count == 0 ? "No formulae to release" : "Released " + count + " formula" + (count == 1 ? "" : "e")));
	}

	/** A thrown kunai landed: the formula stays where it stuck. */
	public static void landed(Entity kunai, Map<String, Object> deps) {
		if (kunai instanceof AbstractArrow arrow && arrow.getOwner() instanceof ServerPlayer p)
			addMark(p, kunai.position());
	}

	/** A thrown kunai hit a creature: it carries the formula for a minute. */
	@SubscribeEvent
	public static void hit(ProjectileImpactEvent event) {
		if (event.getProjectile().getType() == FlyingThunderGodKunaiBulletItem.arrow && event.getRayTraceResult() instanceof EntityHitResult hit
				&& hit.getEntity() instanceof LivingEntity target && event.getProjectile().getOwner() instanceof ServerPlayer p && target != p)
			mark(p, target);
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

	/** Move to the mark looked towards (within 25 degrees), else the newest; at Level Two whoever touches you comes along. */
	private static void jump(ServerPlayer p, boolean levelTwo) {
		List<Target> targets = targets(p);
		if (targets.isEmpty()) {
			p.sendOverlayMessage(Component.literal("No formula to move to"));
			return;
		}
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
		if (to.at().distanceTo(p.position()) < 1.5)
			return;
		ServerLevel level = (ServerLevel) p.level();
		List<LivingEntity> along = levelTwo
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
