package net.mcreator.narutoshippudenmod.compat;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.projectile.arrow.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

/**
 * Base for the mod's jutsu projectiles. Keeps the 1.16 constructor shapes and the per-projectile knockback value
 * (arrows only get knockback from weapon enchantments in 26.3).
 */
public abstract class ModArrow extends AbstractArrow {
	private int knockback;

	protected ModArrow(EntityType<? extends AbstractArrow> type, Level level) {
		super(type, level);
	}

	protected ModArrow(EntityType<? extends AbstractArrow> type, double x, double y, double z, Level level) {
		super(type, x, y, z, level, ItemStack.EMPTY, null);
	}

	protected ModArrow(EntityType<? extends AbstractArrow> type, LivingEntity owner, Level level) {
		super(type, owner, level, ItemStack.EMPTY, null);
	}

	public void setKnockback(int knockback) {
		this.knockback = knockback;
	}

	public int getKnockback() {
		return knockback;
	}

	@Override
	protected ItemStack getDefaultPickupItem() {
		return ItemStack.EMPTY;
	}

	@Override
	protected void doKnockback(LivingEntity mob, DamageSource damageSource) {
		super.doKnockback(mob, damageSource);
		if (knockback > 0) {
			double resistance = Math.max(0.0, 1.0 - mob.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
			Vec3 push = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * resistance);
			if (push.lengthSqr() > 0.0)
				mob.push(push.x, 0.1, push.z);
		}
	}
}
