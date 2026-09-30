package net.mcreator.narutoshippudenmod.item;

import net.mcreator.narutoshippudenmod.compat.Compat;
import net.minecraft.util.RandomSource;
import net.minecraft.core.registries.Registries;
import net.mcreator.narutoshippudenmod.compat.Registration;
import net.mcreator.narutoshippudenmod.compat.ModArrow;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.stream.Stream;
import net.mcreator.narutoshippudenmod.NarutoShippudenModElements;
import net.mcreator.narutoshippudenmod.entity.renderer.ProjectileRenderers.GreatFireDragonRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.ProjectileRenderers.LaserCircusRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.ProjectileRenderers.UzumakiChainRenderer;
import net.mcreator.narutoshippudenmod.procedures.ClanProcedures.UzumakiChainProjectileHitsLivingEntityProcedure;
import net.mcreator.narutoshippudenmod.procedures.ClanProcedures.UzumakiChainWhileProjectileFlyingTickProcedure;
import net.mcreator.narutoshippudenmod.procedures.JutsuEffectProcedures.GreatFireballWhileProjectileFlyingTickProcedure;
import net.mcreator.narutoshippudenmod.procedures.JutsuEffectProcedures.LaserCircusProjectileHitsLivingEntityProcedure;
import net.mcreator.narutoshippudenmod.procedures.JutsuEffectProcedures.LaserCircusWhileProjectileFlyingTickProcedure;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.ItemSupplier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.projectile.arrow.AbstractArrow;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;

import net.minecraft.world.item.ItemUseAnimation;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.network.protocol.Packet;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.util.Mth;
import net.minecraft.world.level.Level;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

import net.minecraft.core.registries.BuiltInRegistries;

public final class JutsuProjectileItems {
	private JutsuProjectileItems() {
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class GreatFireDragonItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "great_fire_dragon", v -> block = (Item) v);
		}
		public static EntityType<ArrowCustomEntity> arrow;

		public GreatFireDragonItem(NarutoShippudenModElements instance) {
			super(instance, 67);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemRanged());
			elements.entities.add(() -> arrow = (EntityType.Builder.<ArrowCustomEntity>of(ArrowCustomEntity::new, MobCategory.MISC) .setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1) .sized(3f, 3f)).build(Registration.entityKey("projectile_great_fire_dragon")));
		}

		public static class ItemRanged extends Item {
			public ItemRanged() {
				super(Registration.itemProps("great_fire_dragon", null).stacksTo(1));
			}

			@Override
			public InteractionResult use(Level world, Player entity, InteractionHand hand) {
				entity.startUsingItem(hand);
				return InteractionResult.SUCCESS;
			}

			@Override
			public ItemUseAnimation getUseAnimation(ItemStack itemstack) {
				return ItemUseAnimation.NONE;
			}

			@Override
			public int getUseDuration(ItemStack itemstack, LivingEntity user) {
				return 72000;
			}

			@Override
			public boolean releaseUsing(ItemStack itemstack, Level world, LivingEntity entityLiving, int timeLeft) {
				if (!world.isClientSide() && entityLiving instanceof ServerPlayer) {
					ServerPlayer entity = (ServerPlayer) entityLiving;
					double x = entity.getX();
					double y = entity.getY();
					double z = entity.getZ();
					if (true) {
						ArrowCustomEntity entityarrow = shoot(world, entity, world.getRandom(), 1f, 10, 1);
						itemstack.hurtAndBreak(1, entity, entity.getUsedItemHand());
						entityarrow.pickup = AbstractArrow.Pickup.DISALLOWED;
					}
				}
				return true;
			}
		}

		public static class ArrowCustomEntity extends ModArrow implements ItemSupplier {

			public ArrowCustomEntity(EntityType<? extends ArrowCustomEntity> type, Level world) {
				super(type, world);
			}

			public ArrowCustomEntity(EntityType<? extends ArrowCustomEntity> type, double x, double y, double z, Level world) {
				super(type, x, y, z, world);
			}

			public ArrowCustomEntity(EntityType<? extends ArrowCustomEntity> type, LivingEntity entity, Level world) {
				super(type, entity, world);
			}

			@Override
			public ItemStack getItem() {
				return ItemStack.EMPTY;
			}

			@Override
			protected ItemStack getPickupItem() {
				return ItemStack.EMPTY;
			}

			@Override
			protected void doPostHurtEffects(LivingEntity entity) {
				super.doPostHurtEffects(entity);
				entity.setArrowCount(entity.getArrowCount() - 1);
			}

			@Override
			public void tick() {
				super.tick();
				double x = this.getX();
				double y = this.getY();
				double z = this.getZ();
				Level world = this.level();
				Entity entity = this.getOwner();
				Entity immediatesourceentity = this;

				GreatFireballWhileProjectileFlyingTickProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("immediatesourceentity", immediatesourceentity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				if (this.isInGround())
					this.discard();
			}
		}

		public static ArrowCustomEntity shoot(Level world, LivingEntity entity, RandomSource random, float power, double damage, int knockback) {
			ArrowCustomEntity entityarrow = new ArrowCustomEntity(arrow, entity, world);
			entityarrow.shoot(entity.getViewVector(1).x, entity.getViewVector(1).y, entity.getViewVector(1).z, power * 2, 0);
			entityarrow.setSilent(true);
			entityarrow.setCritArrow(false);
			entityarrow.setBaseDamage(damage);
			Compat.setKnockback(entityarrow, knockback);
			entityarrow.igniteForSeconds(100);
			world.addFreshEntity(entityarrow);
			double x = entity.getX();
			double y = entity.getY();
			double z = entity.getZ();
			world.playSound((Player) null, (double) x, (double) y, (double) z,
					Compat.sound(""), SoundSource.PLAYERS, 1,
					1f / (random.nextFloat() * 0.5f + 1) + (power / 2));
			return entityarrow;
		}

		public static ArrowCustomEntity shoot(LivingEntity entity, LivingEntity target) {
			ArrowCustomEntity entityarrow = new ArrowCustomEntity(arrow, entity, entity.level());
			double d0 = target.getY() + (double) target.getEyeHeight() - 1.1;
			double d1 = target.getX() - entity.getX();
			double d3 = target.getZ() - entity.getZ();
			entityarrow.shoot(d1, d0 - entityarrow.getY() + (double) (float) Math.sqrt(d1 * d1 + d3 * d3) * 0.2F, d3, 1f * 2, 12.0F);
			entityarrow.setSilent(true);
			entityarrow.setBaseDamage(10);
			Compat.setKnockback(entityarrow, 1);
			entityarrow.setCritArrow(false);
			entityarrow.igniteForSeconds(100);
			entity.level().addFreshEntity(entityarrow);
			double x = entity.getX();
			double y = entity.getY();
			double z = entity.getZ();
			entity.level().playSound((Player) null, (double) x, (double) y, (double) z,
					Compat.sound(""), SoundSource.PLAYERS, 1,
					1f / (RandomSource.create().nextFloat() * 0.5f + 1));
			return entityarrow;
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class LaserCircusItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "laser_circus", v -> block = (Item) v);
		}
		public static EntityType<ArrowCustomEntity> arrow;

		public LaserCircusItem(NarutoShippudenModElements instance) {
			super(instance, 749);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemRanged());
			elements.entities.add(() -> arrow = (EntityType.Builder.<ArrowCustomEntity>of(ArrowCustomEntity::new, MobCategory.MISC) .setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1) .sized(2.5f, 2.5f)).build(Registration.entityKey("projectile_laser_circus")));
		}

		public static class ItemRanged extends Item {
			public ItemRanged() {
				super(Registration.itemProps("laser_circus", null).stacksTo(1));
			}

			@Override
			public InteractionResult use(Level world, Player entity, InteractionHand hand) {
				entity.startUsingItem(hand);
				return InteractionResult.SUCCESS;
			}

			@Override
			public ItemUseAnimation getUseAnimation(ItemStack itemstack) {
				return ItemUseAnimation.NONE;
			}

			@Override
			public int getUseDuration(ItemStack itemstack, LivingEntity user) {
				return 72000;
			}

			@Override
			public boolean releaseUsing(ItemStack itemstack, Level world, LivingEntity entityLiving, int timeLeft) {
				if (!world.isClientSide() && entityLiving instanceof ServerPlayer) {
					ServerPlayer entity = (ServerPlayer) entityLiving;
					double x = entity.getX();
					double y = entity.getY();
					double z = entity.getZ();
					if (true) {
						ArrowCustomEntity entityarrow = shoot(world, entity, world.getRandom(), 1f, 1, 0);
						itemstack.hurtAndBreak(1, entity, entity.getUsedItemHand());
						entityarrow.pickup = AbstractArrow.Pickup.DISALLOWED;
					}
				}
				return true;
			}
		}

		public static class ArrowCustomEntity extends ModArrow implements ItemSupplier {

			public ArrowCustomEntity(EntityType<? extends ArrowCustomEntity> type, Level world) {
				super(type, world);
			}

			public ArrowCustomEntity(EntityType<? extends ArrowCustomEntity> type, double x, double y, double z, Level world) {
				super(type, x, y, z, world);
			}

			public ArrowCustomEntity(EntityType<? extends ArrowCustomEntity> type, LivingEntity entity, Level world) {
				super(type, entity, world);
			}

			@Override
			public ItemStack getItem() {
				return ItemStack.EMPTY;
			}

			@Override
			protected ItemStack getPickupItem() {
				return ItemStack.EMPTY;
			}

			@Override
			protected void doPostHurtEffects(LivingEntity entity) {
				super.doPostHurtEffects(entity);
				entity.setArrowCount(entity.getArrowCount() - 1);
			}

			@Override
			public void onHitEntity(EntityHitResult entityRayTraceResult) {
				super.onHitEntity(entityRayTraceResult);
				Entity entity = entityRayTraceResult.getEntity();
				Entity sourceentity = this.getOwner();
				Entity immediatesourceentity = this;
				double x = this.getX();
				double y = this.getY();
				double z = this.getZ();
				Level world = this.level();

				LaserCircusProjectileHitsLivingEntityProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}

			@Override
			public void tick() {
				super.tick();
				double x = this.getX();
				double y = this.getY();
				double z = this.getZ();
				Level world = this.level();
				Entity entity = this.getOwner();
				Entity immediatesourceentity = this;

				LaserCircusWhileProjectileFlyingTickProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z), new AbstractMap.SimpleEntry<>("immediatesourceentity", immediatesourceentity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				if (this.isInGround())
					this.discard();
			}
		}

		public static ArrowCustomEntity shoot(Level world, LivingEntity entity, RandomSource random, float power, double damage, int knockback) {
			ArrowCustomEntity entityarrow = new ArrowCustomEntity(arrow, entity, world);
			entityarrow.shoot(entity.getViewVector(1).x, entity.getViewVector(1).y, entity.getViewVector(1).z, power * 2, 0);
			entityarrow.setSilent(true);
			entityarrow.setCritArrow(false);
			entityarrow.setBaseDamage(damage);
			Compat.setKnockback(entityarrow, knockback);
			world.addFreshEntity(entityarrow);
			double x = entity.getX();
			double y = entity.getY();
			double z = entity.getZ();
			world.playSound((Player) null, (double) x, (double) y, (double) z,
					Compat.sound(""), SoundSource.PLAYERS, 1,
					1f / (random.nextFloat() * 0.5f + 1) + (power / 2));
			return entityarrow;
		}

		public static ArrowCustomEntity shoot(LivingEntity entity, LivingEntity target) {
			ArrowCustomEntity entityarrow = new ArrowCustomEntity(arrow, entity, entity.level());
			double d0 = target.getY() + (double) target.getEyeHeight() - 1.1;
			double d1 = target.getX() - entity.getX();
			double d3 = target.getZ() - entity.getZ();
			entityarrow.shoot(d1, d0 - entityarrow.getY() + (double) (float) Math.sqrt(d1 * d1 + d3 * d3) * 0.2F, d3, 1f * 2, 12.0F);
			entityarrow.setSilent(true);
			entityarrow.setBaseDamage(1);
			Compat.setKnockback(entityarrow, 0);
			entityarrow.setCritArrow(false);
			entity.level().addFreshEntity(entityarrow);
			double x = entity.getX();
			double y = entity.getY();
			double z = entity.getZ();
			entity.level().playSound((Player) null, (double) x, (double) y, (double) z,
					Compat.sound(""), SoundSource.PLAYERS, 1,
					1f / (RandomSource.create().nextFloat() * 0.5f + 1));
			return entityarrow;
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class UzumakiChainItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "uzumaki_chain", v -> block = (Item) v);
		}
		public static EntityType<ArrowCustomEntity> arrow;

		public UzumakiChainItem(NarutoShippudenModElements instance) {
			super(instance, 440);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemRanged());
			elements.entities.add(() -> arrow = (EntityType.Builder.<ArrowCustomEntity>of(ArrowCustomEntity::new, MobCategory.MISC) .setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1) .sized(2.5f, 2.5f)).build(Registration.entityKey("projectile_uzumaki_chain")));
		}

		public static class ItemRanged extends Item {
			public ItemRanged() {
				super(Registration.itemProps("uzumaki_chain", null).stacksTo(1));
			}

			@Override
			public InteractionResult use(Level world, Player entity, InteractionHand hand) {
				entity.startUsingItem(hand);
				return InteractionResult.SUCCESS;
			}

			@Override
			public ItemUseAnimation getUseAnimation(ItemStack itemstack) {
				return ItemUseAnimation.NONE;
			}

			@Override
			public int getUseDuration(ItemStack itemstack, LivingEntity user) {
				return 72000;
			}

			@Override
			public boolean releaseUsing(ItemStack itemstack, Level world, LivingEntity entityLiving, int timeLeft) {
				if (!world.isClientSide() && entityLiving instanceof ServerPlayer) {
					ServerPlayer entity = (ServerPlayer) entityLiving;
					double x = entity.getX();
					double y = entity.getY();
					double z = entity.getZ();
					if (true) {
						ArrowCustomEntity entityarrow = shoot(world, entity, world.getRandom(), 1f, 1, 0);
						itemstack.hurtAndBreak(1, entity, entity.getUsedItemHand());
						entityarrow.pickup = AbstractArrow.Pickup.DISALLOWED;
					}
				}
				return true;
			}
		}

		public static class ArrowCustomEntity extends ModArrow implements ItemSupplier {

			public ArrowCustomEntity(EntityType<? extends ArrowCustomEntity> type, Level world) {
				super(type, world);
			}

			public ArrowCustomEntity(EntityType<? extends ArrowCustomEntity> type, double x, double y, double z, Level world) {
				super(type, x, y, z, world);
			}

			public ArrowCustomEntity(EntityType<? extends ArrowCustomEntity> type, LivingEntity entity, Level world) {
				super(type, entity, world);
			}

			@Override
			public ItemStack getItem() {
				return ItemStack.EMPTY;
			}

			@Override
			protected ItemStack getPickupItem() {
				return ItemStack.EMPTY;
			}

			@Override
			protected void doPostHurtEffects(LivingEntity entity) {
				super.doPostHurtEffects(entity);
				entity.setArrowCount(entity.getArrowCount() - 1);
			}

			@Override
			public void onHitEntity(EntityHitResult entityRayTraceResult) {
				super.onHitEntity(entityRayTraceResult);
				Entity entity = entityRayTraceResult.getEntity();
				Entity sourceentity = this.getOwner();
				Entity immediatesourceentity = this;
				double x = this.getX();
				double y = this.getY();
				double z = this.getZ();
				Level world = this.level();

				UzumakiChainProjectileHitsLivingEntityProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}

			@Override
			public void tick() {
				super.tick();
				double x = this.getX();
				double y = this.getY();
				double z = this.getZ();
				Level world = this.level();
				Entity entity = this.getOwner();
				Entity immediatesourceentity = this;

				UzumakiChainWhileProjectileFlyingTickProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("immediatesourceentity", immediatesourceentity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				if (this.isInGround()) {
					this.discard();
				}
			}
		}

		public static ArrowCustomEntity shoot(Level world, LivingEntity entity, RandomSource random, float power, double damage, int knockback) {
			ArrowCustomEntity entityarrow = new ArrowCustomEntity(arrow, entity, world);
			entityarrow.shoot(entity.getViewVector(1).x, entity.getViewVector(1).y, entity.getViewVector(1).z, power * 2, 0);
			entityarrow.setSilent(true);
			entityarrow.setCritArrow(false);
			entityarrow.setBaseDamage(damage);
			Compat.setKnockback(entityarrow, knockback);
			entityarrow.setNoGravity(true);
			world.addFreshEntity(entityarrow);
			double x = entity.getX();
			double y = entity.getY();
			double z = entity.getZ();
			world.playSound((Player) null, (double) x, (double) y, (double) z,
					Compat.sound(""), SoundSource.PLAYERS, 1,
					1f / (random.nextFloat() * 0.5f + 1) + (power / 2));
			return entityarrow;
		}

		public static ArrowCustomEntity shoot(LivingEntity entity, LivingEntity target) {
			ArrowCustomEntity entityarrow = new ArrowCustomEntity(arrow, entity, entity.level());
			double d0 = target.getY() + (double) target.getEyeHeight() - 1.1;
			double d1 = target.getX() - entity.getX();
			double d3 = target.getZ() - entity.getZ();
			entityarrow.shoot(d1, d0 - entityarrow.getY() + (double) (float) Math.sqrt(d1 * d1 + d3 * d3) * 0.2F, d3, 1f * 2, 12.0F);
			entityarrow.setSilent(true);
			entityarrow.setBaseDamage(1);
			Compat.setKnockback(entityarrow, 0);
			entityarrow.setCritArrow(false);
			entity.level().addFreshEntity(entityarrow);
			double x = entity.getX();
			double y = entity.getY();
			double z = entity.getZ();
			entity.level().playSound((Player) null, (double) x, (double) y, (double) z,
					Compat.sound(""), SoundSource.PLAYERS, 1,
					1f / (RandomSource.create().nextFloat() * 0.5f + 1));
			return entityarrow;
		}
	}

}
