package net.mcreator.narutoshippudenmod.core.jutsu;

import net.mcreator.narutoshippudenmod.compat.ModArrow;
import net.mcreator.narutoshippudenmod.core.jutsu.engine.Element;
import net.mcreator.narutoshippudenmod.core.jutsu.engine.JutsuEngine;
import net.mcreator.narutoshippudenmod.core.jutsu.engine.JutsuProjectile;
import net.mcreator.narutoshippudenmod.core.jutsu.engine.JutsuProjectile.Shape;
import net.mcreator.narutoshippudenmod.item.ClanItems.FumaShurikenClanItem;
import net.mcreator.narutoshippudenmod.item.ClanItems.ShurikenClanItem;
import net.mcreator.narutoshippudenmod.item.ClanItems.ToroiUniqueFumaShurikenClanItem;
import net.mcreator.narutoshippudenmod.item.ProjectileItems.ExplosiveKunaiBulletItem;
import net.mcreator.narutoshippudenmod.item.ProjectileItems.FumaShurikenBulletItem;
import net.mcreator.narutoshippudenmod.item.ProjectileItems.KunaiBulletItem;
import net.mcreator.narutoshippudenmod.item.ProjectileItems.PoisonKunaiBulletItem;
import net.mcreator.narutoshippudenmod.item.ProjectileItems.ShurikenBulletItem;
import net.mcreator.narutoshippudenmod.item.ProjectileItems.ToroiUniqueFumaShurikenBulletItem;
import net.mcreator.narutoshippudenmod.procedures.WeaponProcedures;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.phys.Vec3;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

import org.jspecify.annotations.Nullable;

/**
 * Thrown shuriken and kunai fly as the jutsu projectiles the Fuma clan throws (the same model, size, trail and smooth flight)
 * instead of arrows. What they did when they landed stays: a thrown weapon drops back as an item where it hits a block, an
 * explosive kunai goes off, a poisoned kunai poisons. The Flying Thunder God kunai stays an arrow, to mark where to teleport.
 */
@EventBusSubscriber(modid = "naruto_shippuden")
public final class ThrownWeapons {
	private ThrownWeapons() {
	}

	/** How a thrown weapon flies and lands: blockHit is its old landing procedure (drop the item, explode). */
	private record Kind(Element element, Shape shape, float size, float damage, @Nullable Consumer<Map<String, Object>> blockHit, boolean alwaysLands,
			boolean poison) {
	}

	private static @Nullable Map<EntityType<?>, Kind> kinds;

	private static Map<EntityType<?>, Kind> kinds() {
		if (kinds == null) {
			kinds = new HashMap<>();
			kinds.put(ShurikenBulletItem.arrow, new Kind(Element.STEEL, Shape.SHURIKEN, 0.5F, 5, WeaponProcedures.ShurikenBulletProjectileHitsBlockProcedure::executeProcedure,
					false, false));
			kinds.put(FumaShurikenBulletItem.arrow, new Kind(Element.STEEL, Shape.SHURIKEN, 1.3F, 10,
					WeaponProcedures.FumaShurikenBulletProjectileHitsBlockProcedure::executeProcedure, false, false));
			kinds.put(ToroiUniqueFumaShurikenBulletItem.arrow, new Kind(Element.MAGNET, Shape.SHURIKEN, 1.6F, 14,
					WeaponProcedures.ToroiUniqueFumaShurikenBulletProjectileHitsBlockProcedure::executeProcedure, false, false));
			kinds.put(KunaiBulletItem.arrow, new Kind(Element.STEEL, Shape.KUNAI, 0.6F, 7, WeaponProcedures.KunaiBulletProjectileHitsBlockProcedure::executeProcedure,
					false, false));
			kinds.put(PoisonKunaiBulletItem.arrow, new Kind(Element.INSECT, Shape.KUNAI, 0.6F, 7,
					WeaponProcedures.PoisonKunaiBulletProjectileHitsBlockProcedure::executeProcedure, false, true));
			kinds.put(ExplosiveKunaiBulletItem.arrow, new Kind(Element.FIRE, Shape.KUNAI, 0.6F, 7,
					WeaponProcedures.ExplosiveKunaiBulletProjectileHitsBlockProcedure::executeProcedure, true, false));
			kinds.put(ShurikenClanItem.arrow, new Kind(Element.STEEL, Shape.SHURIKEN, 0.5F, 5, null, false, false));
			kinds.put(FumaShurikenClanItem.arrow, new Kind(Element.STEEL, Shape.SHURIKEN, 1.3F, 10, null, false, false));
			kinds.put(ToroiUniqueFumaShurikenClanItem.arrow, new Kind(Element.MAGNET, Shape.SHURIKEN, 1.6F, 14, null, false, false));
		}
		return kinds;
	}

	@SubscribeEvent
	public static void thrown(EntityJoinLevelEvent event) {
		if (!(event.getLevel() instanceof ServerLevel level) || !(event.getEntity() instanceof ModArrow arrow) || event.loadedFromDisk())
			return;
		Kind kind = kinds().get(arrow.getType());
		if (kind == null)
			return;
		event.setCanceled(true);
		JutsuProjectile weapon = new JutsuProjectile(JutsuEngine.PROJECTILE, level);
		weapon.look(kind.element(), kind.shape(), kind.size());
		weapon.setOwner(arrow.getOwner());
		weapon.setPos(arrow.position().subtract(0, kind.size() / 2, 0));
		weapon.setDeltaMovement(arrow.getDeltaMovement());
		weapon.damage = kind.damage();
		weapon.gravity = 0.02F;
		weapon.life = 60;
		weapon.knockback = 0.3F;
		boolean[] struck = { false };
		weapon.onHit = (w, target) -> {
			struck[0] = true;
			if (kind.poison())
				target.addEffect(new MobEffectInstance(MobEffects.POISON, 600, 0, false, false));
		};
		weapon.onImpact = w -> {
			if (kind.blockHit() != null && (kind.alwaysLands() || !struck[0]))
				kind.blockHit().accept(at(level, w.position()));
		};
		level.addFreshEntity(weapon);
	}

	private static Map<String, Object> at(ServerLevel level, Vec3 position) {
		Map<String, Object> dependencies = new HashMap<>();
		dependencies.put("world", level);
		dependencies.put("x", position.x);
		dependencies.put("y", position.y);
		dependencies.put("z", position.z);
		return dependencies;
	}
}
