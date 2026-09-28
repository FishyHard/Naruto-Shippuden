package net.mcreator.narutoshippudenmod.core;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import net.minecraft.world.phys.EntityHitResult;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.entity.PartEntity;
import net.neoforged.neoforge.event.entity.ProjectileImpactEvent;

import org.jspecify.annotations.Nullable;

/**
 * Ender-dragon style hitbox: several part entities that follow the body of a big mob and forward damage to it. The
 * owner makes itself unpickable, returns {@link #parts()} from getParts(), calls {@link #update()} every tick and
 * {@link #syncIds(int)} from recreateFromPacket.
 */
@EventBusSubscriber(modid = "naruto_shippuden")
public final class MultipartHitbox {
	private final Mob owner;
	private final float[][] layout;
	private final Part[] parts;
	private float scale = 1;

	/** Each entry is {left, bottom, forward, width, height} in blocks, relative to the owner's feet and body rotation. */
	public MultipartHitbox(Mob owner, float[][] layout) {
		this.owner = owner;
		this.layout = layout;
		this.parts = new Part[layout.length];
		for (int i = 0; i < layout.length; i++)
			parts[i] = new Part(this, layout[i][3], layout[i][4]);
	}

	/** Kurama: head, three body sections, four legs and four tail clusters, measured from the (4.5x scaled) model. */
	public static MultipartHitbox kurama(Mob owner) {
		return new MultipartHitbox(owner, new float[][]{
				{0, 11, 19, 12, 10},
				{0, 10.3F, 11, 9.5F, 9}, {0, 10.3F, 3, 9.5F, 9}, {0, 10.3F, -5, 9.5F, 9},
				{-7.4F, 0, 6.7F, 7, 11}, {7.4F, 0, 6.7F, 7, 11}, {-4.7F, 0, -7.8F, 6, 11}, {4.7F, 0, -7.8F, 6, 11},
				{0, 14, -22, 10, 26}, {12, 13, -20, 14, 22}, {-12, 13, -20, 14, 22}, {0, 16, -32, 8, 16}});
	}

	public PartEntity<?>[] parts() {
		return parts;
	}

	public void syncIds(int ownerId) {
		for (int i = 0; i < parts.length; i++)
			parts[i].setId(ownerId + i + 1);
	}

	public void update() {
		float newScale = owner.getScale();
		boolean rescale = newScale != scale;
		scale = newScale;
		float rot = owner.yBodyRot * Mth.DEG_TO_RAD;
		float sin = Mth.sin(rot), cos = Mth.cos(rot);
		for (int i = 0; i < parts.length; i++) {
			float[] l = layout[i];
			Part part = parts[i];
			if (rescale)
				part.refreshDimensions();
			part.setOldPosAndRot();
			double left = l[0] * scale, forward = l[2] * scale;
			part.setPos(owner.getX() + left * cos - forward * sin, owner.getY() + l[1] * scale, owner.getZ() + left * sin + forward * cos);
		}
	}

	/** The owner's own projectiles start inside its parts; let them pass through. */
	@SubscribeEvent
	public static void onProjectileImpact(ProjectileImpactEvent event) {
		if (event.getRayTraceResult() instanceof EntityHitResult hit && hit.getEntity() instanceof Part part
				&& event.getProjectile().getOwner() == part.getParent())
			event.setCanceled(true);
	}

	public static final class Part extends PartEntity<Mob> {
		private final MultipartHitbox hitbox;
		private final EntityDimensions size;

		Part(MultipartHitbox hitbox, float width, float height) {
			super(hitbox.owner);
			this.hitbox = hitbox;
			this.size = EntityDimensions.scalable(width, height);
			this.refreshDimensions();
		}

		@Override
		protected void defineSynchedData(SynchedEntityData.Builder entityData) {
		}

		@Override
		protected void readAdditionalSaveData(ValueInput input) {
		}

		@Override
		protected void addAdditionalSaveData(ValueOutput output) {
		}

		@Override
		public boolean isPickable() {
			return true;
		}

		@Override
		public @Nullable ItemStack getPickResult() {
			return getParent().getPickResult();
		}

		@Override
		public boolean hurtServer(ServerLevel level, DamageSource source, float damage) {
			return !this.isInvulnerableToBase(source) && getParent().hurtServer(level, source, damage);
		}

		@Override
		public boolean is(Entity other) {
			return this == other || getParent() == other;
		}

		@Override
		public EntityDimensions getDimensions(Pose pose) {
			return hitbox == null ? size : size.scale(hitbox.scale);
		}

		@Override
		public boolean shouldBeSaved() {
			return false;
		}
	}
}
