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
import net.mcreator.narutoshippudenmod.entity.renderer.ProjectileRenderers.AmaterasuFlameRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.ProjectileRenderers.BlackIceDragonRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.ProjectileRenderers.ChidoriSenbonRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.ProjectileRenderers.DemonicIllusionShacklingStakesTechniqueRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.ProjectileRenderers.DrowningWaterBlobTechniqueRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.ProjectileRenderers.EarthBallRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.ProjectileRenderers.EarthDiskRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.ProjectileRenderers.EarthSpearRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.ProjectileRenderers.EarthWaveRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.ProjectileRenderers.FireBallRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.ProjectileRenderers.FireDiskRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.ProjectileRenderers.FireWaveRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.ProjectileRenderers.FurykickRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.ProjectileRenderers.GreatFireDragonRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.ProjectileRenderers.GreatFireballRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.ProjectileRenderers.InsectBogRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.ProjectileRenderers.LaserCircusRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.ProjectileRenderers.LightningBallCustomRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.ProjectileRenderers.LightningBallRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.ProjectileRenderers.LightningDiskRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.ProjectileRenderers.LightningWaveRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.ProjectileRenderers.MirrorRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.ProjectileRenderers.NeedleSenbonRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.ProjectileRenderers.PhoenixFlowerJutsuRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.ProjectileRenderers.RasenshurikenRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.ProjectileRenderers.SmokeGunRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.ProjectileRenderers.SteelProjectileRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.ProjectileRenderers.TailedBeastBombRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.ProjectileRenderers.TreeBindRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.ProjectileRenderers.UzumakiChainRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.ProjectileRenderers.VacuumSphereRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.ProjectileRenderers.WaterBallRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.ProjectileRenderers.WaterDiskRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.ProjectileRenderers.WaterDragonRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.ProjectileRenderers.WaterGunRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.ProjectileRenderers.WaterWaveRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.ProjectileRenderers.WindBallRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.ProjectileRenderers.WindDiskRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.ProjectileRenderers.WindWaveRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.ProjectileRenderers.WoodDragonRenderer;
import net.mcreator.narutoshippudenmod.procedures.ClanProcedures.DemonicIllusionShacklingStakesTechniqueProjectileHitsLivingEntityProcedure;
import net.mcreator.narutoshippudenmod.procedures.ClanProcedures.DrowningWaterBlobTechniqueProjectileHitsLivingEntityProcedure;
import net.mcreator.narutoshippudenmod.procedures.ClanProcedures.FistRockLivingEntityIsHitWithItemProcedure;
import net.mcreator.narutoshippudenmod.procedures.ClanProcedures.InsectBogProjectileHitsLivingEntityProcedure;
import net.mcreator.narutoshippudenmod.procedures.ClanProcedures.MirrorProjectileHitsLivingEntityProcedure;
import net.mcreator.narutoshippudenmod.procedures.ClanProcedures.UzumakiChainProjectileHitsLivingEntityProcedure;
import net.mcreator.narutoshippudenmod.procedures.ClanProcedures.UzumakiChainWhileProjectileFlyingTickProcedure;
import net.mcreator.narutoshippudenmod.procedures.JutsuEffectProcedures.AmaterasuFlameProjectileHitsBlockProcedure;
import net.mcreator.narutoshippudenmod.procedures.JutsuEffectProcedures.AmaterasuFlameProjectileHitsLivingEntityProcedure;
import net.mcreator.narutoshippudenmod.procedures.JutsuEffectProcedures.GreatFireballWhileProjectileFlyingTickProcedure;
import net.mcreator.narutoshippudenmod.procedures.JutsuEffectProcedures.LaserCircusProjectileHitsLivingEntityProcedure;
import net.mcreator.narutoshippudenmod.procedures.JutsuEffectProcedures.LaserCircusWhileProjectileFlyingTickProcedure;
import net.mcreator.narutoshippudenmod.procedures.JutsuEffectProcedures.RasenshurikenProjectileHitsBlockProcedure;
import net.mcreator.narutoshippudenmod.procedures.JutsuEffectProcedures.TailedBeastBombProjectileHitsBlockProcedure;
import net.mcreator.narutoshippudenmod.procedures.JutsuEffectProcedures.TailedBeastBombWhileProjectileFlyingTickProcedure;
import net.mcreator.narutoshippudenmod.procedures.JutsuEffectProcedures.VacuumSphereWhileProjectileFlyingTickProcedure;
import net.mcreator.narutoshippudenmod.procedures.KekkeiGenkaiProcedures.BlackIceDragonProjectileHitsLivingEntityProcedure;
import net.mcreator.narutoshippudenmod.procedures.KekkeiGenkaiProcedures.SmokeGunWhileProjectileFlyingTickProcedure;
import net.mcreator.narutoshippudenmod.procedures.KekkeiGenkaiProcedures.TreeBindProjectileHitsLivingEntityProcedure;
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
	public static class AmaterasuFlameItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "amaterasu_flame", v -> block = (Item) v);
		}
		public static EntityType<ArrowCustomEntity> arrow;

		public AmaterasuFlameItem(NarutoShippudenModElements instance) {
			super(instance, 1213);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemRanged());
			elements.entities.add(() -> arrow = (EntityType.Builder.<ArrowCustomEntity>of(ArrowCustomEntity::new, MobCategory.MISC) .setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1) .sized(0.5f, 0.5f)).build(Registration.entityKey("projectile_amaterasu_flame")));
		}

		public static class ItemRanged extends Item {
			public ItemRanged() {
				super(Registration.itemProps("amaterasu_flame", null).stacksTo(1));
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
						ArrowCustomEntity entityarrow = shoot(world, entity, world.getRandom(), 12f, 1, 0);
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

				AmaterasuFlameProjectileHitsLivingEntityProcedure
						.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("entity", entity))
								.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}

			@Override
			public void onHitBlock(BlockHitResult blockRayTraceResult) {
				super.onHitBlock(blockRayTraceResult);
				double x = blockRayTraceResult.getBlockPos().getX();
				double y = blockRayTraceResult.getBlockPos().getY();
				double z = blockRayTraceResult.getBlockPos().getZ();
				Level world = this.level();
				Entity entity = this.getOwner();
				Entity immediatesourceentity = this;

				AmaterasuFlameProjectileHitsBlockProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z))
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
			entityarrow.shoot(d1, d0 - entityarrow.getY() + (double) (float) Math.sqrt(d1 * d1 + d3 * d3) * 0.2F, d3, 12f * 2, 12.0F);
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
	public static class BlackIceDragonItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "black_ice_dragon", v -> block = (Item) v);
		}
		public static EntityType<ArrowCustomEntity> arrow;

		public BlackIceDragonItem(NarutoShippudenModElements instance) {
			super(instance, 809);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemRanged());
			elements.entities.add(() -> arrow = (EntityType.Builder.<ArrowCustomEntity>of(ArrowCustomEntity::new, MobCategory.MISC) .setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1) .sized(3f, 3f)).build(Registration.entityKey("projectile_black_ice_dragon")));
		}

		public static class ItemRanged extends Item {
			public ItemRanged() {
				super(Registration.itemProps("black_ice_dragon", null).stacksTo(1));
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
			public void onHitEntity(EntityHitResult entityRayTraceResult) {
				super.onHitEntity(entityRayTraceResult);
				Entity entity = entityRayTraceResult.getEntity();
				Entity sourceentity = this.getOwner();
				Entity immediatesourceentity = this;
				double x = this.getX();
				double y = this.getY();
				double z = this.getZ();
				Level world = this.level();

				BlackIceDragonProjectileHitsLivingEntityProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
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
	public static class BladeOfLightningItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "blade_of_lightning", v -> block = (Item) v);
		}

		public BladeOfLightningItem(NarutoShippudenModElements instance) {
			super(instance, 670);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new Item(Registration.itemProps("blade_of_lightning", null).sword(new ToolMaterial(net.minecraft.tags.BlockTags.INCORRECT_FOR_WOODEN_TOOL, 1, 0f, 36f, 1, net.minecraft.tags.ItemTags.WOODEN_TOOL_MATERIALS), 3, -3f)) {
			});
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class ChidoriSenbonItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "chidori_senbon", v -> block = (Item) v);
		}
		public static EntityType<ArrowCustomEntity> arrow;

		public ChidoriSenbonItem(NarutoShippudenModElements instance) {
			super(instance, 91);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemRanged());
			elements.entities.add(() -> arrow = (EntityType.Builder.<ArrowCustomEntity>of(ArrowCustomEntity::new, MobCategory.MISC) .setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1) .sized(5.5f, 5.5f)).build(Registration.entityKey("projectile_chidori_senbon")));
		}

		public static class ItemRanged extends Item {
			public ItemRanged() {
				super(Registration.itemProps("chidori_senbon", null).stacksTo(1));
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
	public static class DemonicIllusionShacklingStakesTechniqueItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "demonic_illusion_shackling_stakes_technique", v -> block = (Item) v);
		}
		public static EntityType<ArrowCustomEntity> arrow;

		public DemonicIllusionShacklingStakesTechniqueItem(NarutoShippudenModElements instance) {
			super(instance, 433);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemRanged());
			elements.entities.add(() -> arrow = (EntityType.Builder.<ArrowCustomEntity>of(ArrowCustomEntity::new, MobCategory.MISC) .setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1) .sized(0.5f, 0.5f)).build(Registration.entityKey("projectile_demonic_illusion_shackling_stakes_technique")));
		}

		public static class ItemRanged extends Item {
			public ItemRanged() {
				super(Registration.itemProps("demonic_illusion_shackling_stakes_technique", null).stacksTo(1));
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
						ArrowCustomEntity entityarrow = shoot(world, entity, world.getRandom(), 4f, 1, 0);
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

				DemonicIllusionShacklingStakesTechniqueProjectileHitsLivingEntityProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z), new AbstractMap.SimpleEntry<>("entity", entity))
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
			entityarrow.shoot(d1, d0 - entityarrow.getY() + (double) (float) Math.sqrt(d1 * d1 + d3 * d3) * 0.2F, d3, 4f * 2, 12.0F);
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
	public static class DrowningWaterBlobTechniqueItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "drowning_water_blob_technique", v -> block = (Item) v);
		}
		public static EntityType<ArrowCustomEntity> arrow;

		public DrowningWaterBlobTechniqueItem(NarutoShippudenModElements instance) {
			super(instance, 945);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemRanged());
			elements.entities.add(() -> arrow = (EntityType.Builder.<ArrowCustomEntity>of(ArrowCustomEntity::new, MobCategory.MISC) .setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1) .sized(0.5f, 0.5f)).build(Registration.entityKey("projectile_drowning_water_blob_technique")));
		}

		public static class ItemRanged extends Item {
			public ItemRanged() {
				super(Registration.itemProps("drowning_water_blob_technique", null).stacksTo(1));
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
						ArrowCustomEntity entityarrow = shoot(world, entity, world.getRandom(), 12f, 1, 0);
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

				DrowningWaterBlobTechniqueProjectileHitsLivingEntityProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
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
			entityarrow.shoot(d1, d0 - entityarrow.getY() + (double) (float) Math.sqrt(d1 * d1 + d3 * d3) * 0.2F, d3, 12f * 2, 12.0F);
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
	public static class EarthBallItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "earth_ball", v -> block = (Item) v);
		}
		public static EntityType<ArrowCustomEntity> arrow;

		public EarthBallItem(NarutoShippudenModElements instance) {
			super(instance, 506);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemRanged());
			elements.entities.add(() -> arrow = (EntityType.Builder.<ArrowCustomEntity>of(ArrowCustomEntity::new, MobCategory.MISC) .setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1) .sized(3f, 3f)).build(Registration.entityKey("projectile_earth_ball")));
		}

		public static class ItemRanged extends Item {
			public ItemRanged() {
				super(Registration.itemProps("earth_ball", null).stacksTo(1));
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
						ArrowCustomEntity entityarrow = shoot(world, entity, world.getRandom(), 1f, 20, 0);
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
			entityarrow.setBaseDamage(20);
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
	public static class EarthDiskItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "earth_disk", v -> block = (Item) v);
		}
		public static EntityType<ArrowCustomEntity> arrow;

		public EarthDiskItem(NarutoShippudenModElements instance) {
			super(instance, 504);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemRanged());
			elements.entities.add(() -> arrow = (EntityType.Builder.<ArrowCustomEntity>of(ArrowCustomEntity::new, MobCategory.MISC) .setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1) .sized(2.5f, 2.5f)).build(Registration.entityKey("projectile_earth_disk")));
		}

		public static class ItemRanged extends Item {
			public ItemRanged() {
				super(Registration.itemProps("earth_disk", null).stacksTo(1));
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
						ArrowCustomEntity entityarrow = shoot(world, entity, world.getRandom(), 1f, 20, 0);
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
			entityarrow.setBaseDamage(20);
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
	public static class EarthSpearItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "earth_spear", v -> block = (Item) v);
		}
		public static EntityType<ArrowCustomEntity> arrow;

		public EarthSpearItem(NarutoShippudenModElements instance) {
			super(instance, 98);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemRanged());
			elements.entities.add(() -> arrow = (EntityType.Builder.<ArrowCustomEntity>of(ArrowCustomEntity::new, MobCategory.MISC) .setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1) .sized(1.5f, 1.5f)).build(Registration.entityKey("projectile_earth_spear")));
		}

		public static class ItemRanged extends Item {
			public ItemRanged() {
				super(Registration.itemProps("earth_spear", null).stacksTo(1));
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
			entityarrow.setBaseDamage(10);
			Compat.setKnockback(entityarrow, 1);
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
	public static class EarthWaveItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "earth_wave", v -> block = (Item) v);
		}
		public static EntityType<ArrowCustomEntity> arrow;

		public EarthWaveItem(NarutoShippudenModElements instance) {
			super(instance, 505);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemRanged());
			elements.entities.add(() -> arrow = (EntityType.Builder.<ArrowCustomEntity>of(ArrowCustomEntity::new, MobCategory.MISC) .setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1) .sized(0.5f, 0.5f)).build(Registration.entityKey("projectile_earth_wave")));
		}

		public static class ItemRanged extends Item {
			public ItemRanged() {
				super(Registration.itemProps("earth_wave", null).stacksTo(1));
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
						ArrowCustomEntity entityarrow = shoot(world, entity, world.getRandom(), 1f, 20, 0);
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
			entityarrow.setBaseDamage(20);
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
	public static class FireBallItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "fire_ball", v -> block = (Item) v);
		}
		public static EntityType<ArrowCustomEntity> arrow;

		public FireBallItem(NarutoShippudenModElements instance) {
			super(instance, 497);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemRanged());
			elements.entities.add(() -> arrow = (EntityType.Builder.<ArrowCustomEntity>of(ArrowCustomEntity::new, MobCategory.MISC) .setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1) .sized(3f, 3f)).build(Registration.entityKey("projectile_fire_ball")));
		}

		public static class ItemRanged extends Item {
			public ItemRanged() {
				super(Registration.itemProps("fire_ball", null).stacksTo(1));
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
						ArrowCustomEntity entityarrow = shoot(world, entity, world.getRandom(), 1f, 20, 0);
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
			entityarrow.setBaseDamage(20);
			Compat.setKnockback(entityarrow, 0);
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
	public static class FireDiskItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "fire_disk", v -> block = (Item) v);
		}
		public static EntityType<ArrowCustomEntity> arrow;

		public FireDiskItem(NarutoShippudenModElements instance) {
			super(instance, 495);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemRanged());
			elements.entities.add(() -> arrow = (EntityType.Builder.<ArrowCustomEntity>of(ArrowCustomEntity::new, MobCategory.MISC) .setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1) .sized(2.5f, 2.5f)).build(Registration.entityKey("projectile_fire_disk")));
		}

		public static class ItemRanged extends Item {
			public ItemRanged() {
				super(Registration.itemProps("fire_disk", null).stacksTo(1));
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
						ArrowCustomEntity entityarrow = shoot(world, entity, world.getRandom(), 1f, 20, 0);
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
			entityarrow.setBaseDamage(20);
			Compat.setKnockback(entityarrow, 0);
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
	public static class FireWaveItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "fire_wave", v -> block = (Item) v);
		}
		public static EntityType<ArrowCustomEntity> arrow;

		public FireWaveItem(NarutoShippudenModElements instance) {
			super(instance, 496);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemRanged());
			elements.entities.add(() -> arrow = (EntityType.Builder.<ArrowCustomEntity>of(ArrowCustomEntity::new, MobCategory.MISC) .setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1) .sized(2.5f, 2.5f)).build(Registration.entityKey("projectile_fire_wave")));
		}

		public static class ItemRanged extends Item {
			public ItemRanged() {
				super(Registration.itemProps("fire_wave", null).stacksTo(1));
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
						ArrowCustomEntity entityarrow = shoot(world, entity, world.getRandom(), 1f, 20, 0);
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
			entityarrow.setBaseDamage(20);
			Compat.setKnockback(entityarrow, 0);
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
	public static class FistRockItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "fist_rock", v -> block = (Item) v);
		}

		public FistRockItem(NarutoShippudenModElements instance) {
			super(instance, 94);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("fist_rock", null).stacksTo(1).rarity(Rarity.COMMON));
			}

			@Override
			public ItemUseAnimation getUseAnimation(ItemStack itemstack) {
				return ItemUseAnimation.EAT;
			}

			@Override
			public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
				return 1F;
			}

			@Override
			public void hurtEnemy(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
				super.hurtEnemy(itemstack, entity, sourceentity);
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
				Level world = entity.level();

				FistRockLivingEntityIsHitWithItemProcedure.executeProcedure(
						Stream.of(new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("sourceentity", sourceentity))
								.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class FurykickItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "furykick", v -> block = (Item) v);
		}
		public static EntityType<ArrowCustomEntity> arrow;

		public FurykickItem(NarutoShippudenModElements instance) {
			super(instance, 836);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemRanged());
			elements.entities.add(() -> arrow = (EntityType.Builder.<ArrowCustomEntity>of(ArrowCustomEntity::new, MobCategory.MISC) .setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1) .sized(0.5f, 0.5f)).build(Registration.entityKey("projectile_furykick")));
		}

		public static class ItemRanged extends Item {
			public ItemRanged() {
				super(Registration.itemProps("furykick", null).stacksTo(1));
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
						ArrowCustomEntity entityarrow = shoot(world, entity, world.getRandom(), 12f, 1, 0);
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
			entityarrow.shoot(d1, d0 - entityarrow.getY() + (double) (float) Math.sqrt(d1 * d1 + d3 * d3) * 0.2F, d3, 12f * 2, 12.0F);
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
	public static class GreatFireballItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "great_fireball", v -> block = (Item) v);
		}
		public static EntityType<ArrowCustomEntity> arrow;

		public GreatFireballItem(NarutoShippudenModElements instance) {
			super(instance, 47);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemRanged());
			elements.entities.add(() -> arrow = (EntityType.Builder.<ArrowCustomEntity>of(ArrowCustomEntity::new, MobCategory.MISC) .setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1) .sized(3f, 3f)).build(Registration.entityKey("projectile_great_fireball")));
		}

		public static class ItemRanged extends Item {
			public ItemRanged() {
				super(Registration.itemProps("great_fireball", null).stacksTo(1));
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
	public static class InsectBogItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "insect_bog", v -> block = (Item) v);
		}
		public static EntityType<ArrowCustomEntity> arrow;

		public InsectBogItem(NarutoShippudenModElements instance) {
			super(instance, 933);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemRanged());
			elements.entities.add(() -> arrow = (EntityType.Builder.<ArrowCustomEntity>of(ArrowCustomEntity::new, MobCategory.MISC) .setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1) .sized(3f, 3f)).build(Registration.entityKey("projectile_insect_bog")));
		}

		public static class ItemRanged extends Item {
			public ItemRanged() {
				super(Registration.itemProps("insect_bog", null).stacksTo(1));
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
						ArrowCustomEntity entityarrow = shoot(world, entity, world.getRandom(), 1f, 13, 1);
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

				InsectBogProjectileHitsLivingEntityProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
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
			entityarrow.setBaseDamage(13);
			Compat.setKnockback(entityarrow, 1);
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
	public static class LightningBallCustomItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "lightning_ball_custom", v -> block = (Item) v);
		}
		public static EntityType<ArrowCustomEntity> arrow;

		public LightningBallCustomItem(NarutoShippudenModElements instance) {
			super(instance, 509);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemRanged());
			elements.entities.add(() -> arrow = (EntityType.Builder.<ArrowCustomEntity>of(ArrowCustomEntity::new, MobCategory.MISC) .setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1) .sized(3f, 3f)).build(Registration.entityKey("projectile_lightning_ball_custom")));
		}

		public static class ItemRanged extends Item {
			public ItemRanged() {
				super(Registration.itemProps("lightning_ball_custom", null).stacksTo(1));
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
						ArrowCustomEntity entityarrow = shoot(world, entity, world.getRandom(), 1f, 20, 0);
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
			entityarrow.setBaseDamage(20);
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
	public static class LightningBallItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "lightning_ball", v -> block = (Item) v);
		}
		public static EntityType<ArrowCustomEntity> arrow;

		public LightningBallItem(NarutoShippudenModElements instance) {
			super(instance, 93);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemRanged());
			elements.entities.add(() -> arrow = (EntityType.Builder.<ArrowCustomEntity>of(ArrowCustomEntity::new, MobCategory.MISC) .setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1) .sized(3f, 3f)).build(Registration.entityKey("projectile_lightning_ball")));
		}

		public static class ItemRanged extends Item {
			public ItemRanged() {
				super(Registration.itemProps("lightning_ball", null).stacksTo(1));
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
	public static class LightningDiskItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "lightning_disk", v -> block = (Item) v);
		}
		public static EntityType<ArrowCustomEntity> arrow;

		public LightningDiskItem(NarutoShippudenModElements instance) {
			super(instance, 507);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemRanged());
			elements.entities.add(() -> arrow = (EntityType.Builder.<ArrowCustomEntity>of(ArrowCustomEntity::new, MobCategory.MISC) .setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1) .sized(2.5f, 2.5f)).build(Registration.entityKey("projectile_lightning_disk")));
		}

		public static class ItemRanged extends Item {
			public ItemRanged() {
				super(Registration.itemProps("lightning_disk", null).stacksTo(1));
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
						ArrowCustomEntity entityarrow = shoot(world, entity, world.getRandom(), 1f, 20, 0);
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
			entityarrow.setBaseDamage(20);
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
	public static class LightningWaveItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "lightning_wave", v -> block = (Item) v);
		}
		public static EntityType<ArrowCustomEntity> arrow;

		public LightningWaveItem(NarutoShippudenModElements instance) {
			super(instance, 508);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemRanged());
			elements.entities.add(() -> arrow = (EntityType.Builder.<ArrowCustomEntity>of(ArrowCustomEntity::new, MobCategory.MISC) .setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1) .sized(0.5f, 0.5f)).build(Registration.entityKey("projectile_lightning_wave")));
		}

		public static class ItemRanged extends Item {
			public ItemRanged() {
				super(Registration.itemProps("lightning_wave", null).stacksTo(1));
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
						ArrowCustomEntity entityarrow = shoot(world, entity, world.getRandom(), 1f, 20, 0);
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
			entityarrow.setBaseDamage(20);
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
	public static class MirrorItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "mirror", v -> block = (Item) v);
		}
		public static EntityType<ArrowCustomEntity> arrow;

		public MirrorItem(NarutoShippudenModElements instance) {
			super(instance, 820);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemRanged());
			elements.entities.add(() -> arrow = (EntityType.Builder.<ArrowCustomEntity>of(ArrowCustomEntity::new, MobCategory.MISC) .setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1) .sized(0.5f, 0.5f)).build(Registration.entityKey("projectile_mirror")));
		}

		public static class ItemRanged extends Item {
			public ItemRanged() {
				super(Registration.itemProps("mirror", null).stacksTo(1));
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
						ArrowCustomEntity entityarrow = shoot(world, entity, world.getRandom(), 12f, 1, 0);
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

				MirrorProjectileHitsLivingEntityProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
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
			entityarrow.shoot(d1, d0 - entityarrow.getY() + (double) (float) Math.sqrt(d1 * d1 + d3 * d3) * 0.2F, d3, 12f * 2, 12.0F);
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
	public static class NeedleSenbonItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "needle_senbon", v -> block = (Item) v);
		}
		public static EntityType<ArrowCustomEntity> arrow;

		public NeedleSenbonItem(NarutoShippudenModElements instance) {
			super(instance, 835);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemRanged());
			elements.entities.add(() -> arrow = (EntityType.Builder.<ArrowCustomEntity>of(ArrowCustomEntity::new, MobCategory.MISC) .setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1) .sized(5.5f, 5.5f)).build(Registration.entityKey("projectile_needle_senbon")));
		}

		public static class ItemRanged extends Item {
			public ItemRanged() {
				super(Registration.itemProps("needle_senbon", null).stacksTo(1));
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
	public static class PhoenixFlowerJutsuItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "phoenix_flower_jutsu", v -> block = (Item) v);
		}
		public static EntityType<ArrowCustomEntity> arrow;

		public PhoenixFlowerJutsuItem(NarutoShippudenModElements instance) {
			super(instance, 74);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemRanged());
			elements.entities.add(() -> arrow = (EntityType.Builder.<ArrowCustomEntity>of(ArrowCustomEntity::new, MobCategory.MISC) .setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1) .sized(1.0f, 1.0f)).build(Registration.entityKey("projectile_phoenix_flower_jutsu")));
		}

		public static class ItemRanged extends Item {
			public ItemRanged() {
				super(Registration.itemProps("phoenix_flower_jutsu", null).stacksTo(1));
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
	public static class RasenshurikenItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "rasenshuriken", v -> block = (Item) v);
		}
		public static EntityType<ArrowCustomEntity> arrow;

		public RasenshurikenItem(NarutoShippudenModElements instance) {
			super(instance, 80);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemRanged());
			elements.entities.add(() -> arrow = (EntityType.Builder.<ArrowCustomEntity>of(ArrowCustomEntity::new, MobCategory.MISC) .setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1) .sized(3f, 3f)).build(Registration.entityKey("projectile_rasenshuriken")));
		}

		public static class ItemRanged extends Item {
			public ItemRanged() {
				super(Registration.itemProps("rasenshuriken", null).stacksTo(1));
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
			public void onHitEntity(EntityHitResult entityRayTraceResult) {
				super.onHitEntity(entityRayTraceResult);
				Entity entity = entityRayTraceResult.getEntity();
				Entity sourceentity = this.getOwner();
				Entity immediatesourceentity = this;
				double x = this.getX();
				double y = this.getY();
				double z = this.getZ();
				Level world = this.level();

				RasenshurikenProjectileHitsBlockProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}

			@Override
			public void onHitBlock(BlockHitResult blockRayTraceResult) {
				super.onHitBlock(blockRayTraceResult);
				double x = blockRayTraceResult.getBlockPos().getX();
				double y = blockRayTraceResult.getBlockPos().getY();
				double z = blockRayTraceResult.getBlockPos().getZ();
				Level world = this.level();
				Entity entity = this.getOwner();
				Entity immediatesourceentity = this;

				RasenshurikenProjectileHitsBlockProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z))
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
	public static class SmokeGunItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "smoke_gun", v -> block = (Item) v);
		}
		public static EntityType<ArrowCustomEntity> arrow;

		public SmokeGunItem(NarutoShippudenModElements instance) {
			super(instance, 464);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemRanged());
			elements.entities.add(() -> arrow = (EntityType.Builder.<ArrowCustomEntity>of(ArrowCustomEntity::new, MobCategory.MISC) .setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1) .sized(2.5f, 2.5f)).build(Registration.entityKey("projectile_smoke_gun")));
		}

		public static class ItemRanged extends Item {
			public ItemRanged() {
				super(Registration.itemProps("smoke_gun", null).stacksTo(1));
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
						ArrowCustomEntity entityarrow = shoot(world, entity, world.getRandom(), 12f, 1, 0);
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

				SmokeGunWhileProjectileFlyingTickProcedure.executeProcedure(Stream
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
			entityarrow.shoot(d1, d0 - entityarrow.getY() + (double) (float) Math.sqrt(d1 * d1 + d3 * d3) * 0.2F, d3, 12f * 2, 12.0F);
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
	public static class SteelProjectileItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "steel_projectile", v -> block = (Item) v);
		}
		public static EntityType<ArrowCustomEntity> arrow;

		public SteelProjectileItem(NarutoShippudenModElements instance) {
			super(instance, 1084);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemRanged());
			elements.entities.add(() -> arrow = (EntityType.Builder.<ArrowCustomEntity>of(ArrowCustomEntity::new, MobCategory.MISC) .setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1) .sized(1.0f, 1.0f)).build(Registration.entityKey("projectile_steel_projectile")));
		}

		public static class ItemRanged extends Item {
			public ItemRanged() {
				super(Registration.itemProps("steel_projectile", null).stacksTo(1));
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
	public static class TailedBeastBombItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "tailed_beast_bomb", v -> block = (Item) v);
		}
		public static EntityType<ArrowCustomEntity> arrow;

		public TailedBeastBombItem(NarutoShippudenModElements instance) {
			super(instance, 160);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemRanged());
			elements.entities.add(() -> arrow = (EntityType.Builder.<ArrowCustomEntity>of(ArrowCustomEntity::new, MobCategory.MISC) .setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1) .sized(4.5f, 4.5f)).build(Registration.entityKey("projectile_tailed_beast_bomb")));
		}

		public static class ItemRanged extends Item {
			public ItemRanged() {
				super(Registration.itemProps("tailed_beast_bomb", null).stacksTo(1));
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
						ArrowCustomEntity entityarrow = shoot(world, entity, world.getRandom(), 3f, 90, 1);
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
			public void onHitBlock(BlockHitResult blockRayTraceResult) {
				super.onHitBlock(blockRayTraceResult);
				double x = blockRayTraceResult.getBlockPos().getX();
				double y = blockRayTraceResult.getBlockPos().getY();
				double z = blockRayTraceResult.getBlockPos().getZ();
				Level world = this.level();
				Entity entity = this.getOwner();
				Entity immediatesourceentity = this;

				TailedBeastBombProjectileHitsBlockProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z))
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

				TailedBeastBombWhileProjectileFlyingTickProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z), new AbstractMap.SimpleEntry<>("immediatesourceentity", immediatesourceentity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				if (this.isInGround()) {

					TailedBeastBombProjectileHitsBlockProcedure.executeProcedure(Stream
							.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x),
									new AbstractMap.SimpleEntry<>("y", y), new AbstractMap.SimpleEntry<>("z", z))
							.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
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
					(net.minecraft.sounds.SoundEvent) BuiltInRegistries.SOUND_EVENT
							.getValue(Identifier.parse("naruto_shippuden:dust_release_and_tailed_beast_bomb")),
					SoundSource.PLAYERS, 1, 1f / (random.nextFloat() * 0.5f + 1) + (power / 2));
			return entityarrow;
		}

		public static ArrowCustomEntity shoot(LivingEntity entity, LivingEntity target) {
			ArrowCustomEntity entityarrow = new ArrowCustomEntity(arrow, entity, entity.level());
			double d0 = target.getY() + (double) target.getEyeHeight() - 1.1;
			double d1 = target.getX() - entity.getX();
			double d3 = target.getZ() - entity.getZ();
			entityarrow.shoot(d1, d0 - entityarrow.getY() + (double) (float) Math.sqrt(d1 * d1 + d3 * d3) * 0.2F, d3, 3f * 2, 12.0F);
			entityarrow.setSilent(true);
			entityarrow.setBaseDamage(90);
			Compat.setKnockback(entityarrow, 1);
			entityarrow.setCritArrow(false);
			entity.level().addFreshEntity(entityarrow);
			double x = entity.getX();
			double y = entity.getY();
			double z = entity.getZ();
			entity.level().playSound((Player) null, (double) x, (double) y, (double) z,
					(net.minecraft.sounds.SoundEvent) BuiltInRegistries.SOUND_EVENT
							.getValue(Identifier.parse("naruto_shippuden:dust_release_and_tailed_beast_bomb")),
					SoundSource.PLAYERS, 1, 1f / (RandomSource.create().nextFloat() * 0.5f + 1));
			return entityarrow;
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class TreeBindItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "tree_bind", v -> block = (Item) v);
		}
		public static EntityType<ArrowCustomEntity> arrow;

		public TreeBindItem(NarutoShippudenModElements instance) {
			super(instance, 789);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemRanged());
			elements.entities.add(() -> arrow = (EntityType.Builder.<ArrowCustomEntity>of(ArrowCustomEntity::new, MobCategory.MISC) .setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1) .sized(0.5f, 0.5f)).build(Registration.entityKey("projectile_tree_bind")));
		}

		public static class ItemRanged extends Item {
			public ItemRanged() {
				super(Registration.itemProps("tree_bind", null).stacksTo(1));
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
						ArrowCustomEntity entityarrow = shoot(world, entity, world.getRandom(), 12f, 1, 0);
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

				TreeBindProjectileHitsLivingEntityProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
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
			entityarrow.shoot(d1, d0 - entityarrow.getY() + (double) (float) Math.sqrt(d1 * d1 + d3 * d3) * 0.2F, d3, 12f * 2, 12.0F);
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

	@NarutoShippudenModElements.ModElement.Tag
	public static class VacuumSphereItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "vacuum_sphere", v -> block = (Item) v);
		}
		public static EntityType<ArrowCustomEntity> arrow;

		public VacuumSphereItem(NarutoShippudenModElements instance) {
			super(instance, 83);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemRanged());
			elements.entities.add(() -> arrow = (EntityType.Builder.<ArrowCustomEntity>of(ArrowCustomEntity::new, MobCategory.MISC) .setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1) .sized(1f, 1f)).build(Registration.entityKey("projectile_vacuum_sphere")));
		}

		public static class ItemRanged extends Item {
			public ItemRanged() {
				super(Registration.itemProps("vacuum_sphere", null).stacksTo(1));
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

				VacuumSphereWhileProjectileFlyingTickProcedure.executeProcedure(Stream
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
			entityarrow.setBaseDamage(10);
			Compat.setKnockback(entityarrow, 1);
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
	public static class WaterBallItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "water_ball", v -> block = (Item) v);
		}
		public static EntityType<ArrowCustomEntity> arrow;

		public WaterBallItem(NarutoShippudenModElements instance) {
			super(instance, 500);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemRanged());
			elements.entities.add(() -> arrow = (EntityType.Builder.<ArrowCustomEntity>of(ArrowCustomEntity::new, MobCategory.MISC) .setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1) .sized(3f, 3f)).build(Registration.entityKey("projectile_water_ball")));
		}

		public static class ItemRanged extends Item {
			public ItemRanged() {
				super(Registration.itemProps("water_ball", null).stacksTo(1));
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
						ArrowCustomEntity entityarrow = shoot(world, entity, world.getRandom(), 1f, 20, 0);
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
			entityarrow.setBaseDamage(20);
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
	public static class WaterDiskItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "water_disk", v -> block = (Item) v);
		}
		public static EntityType<ArrowCustomEntity> arrow;

		public WaterDiskItem(NarutoShippudenModElements instance) {
			super(instance, 498);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemRanged());
			elements.entities.add(() -> arrow = (EntityType.Builder.<ArrowCustomEntity>of(ArrowCustomEntity::new, MobCategory.MISC) .setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1) .sized(2.5f, 2.5f)).build(Registration.entityKey("projectile_water_disk")));
		}

		public static class ItemRanged extends Item {
			public ItemRanged() {
				super(Registration.itemProps("water_disk", null).stacksTo(1));
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
						ArrowCustomEntity entityarrow = shoot(world, entity, world.getRandom(), 1f, 20, 0);
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
			entityarrow.setBaseDamage(20);
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
	public static class WaterDragonItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "water_dragon", v -> block = (Item) v);
		}
		public static EntityType<ArrowCustomEntity> arrow;

		public WaterDragonItem(NarutoShippudenModElements instance) {
			super(instance, 76);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemRanged());
			elements.entities.add(() -> arrow = (EntityType.Builder.<ArrowCustomEntity>of(ArrowCustomEntity::new, MobCategory.MISC) .setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1) .sized(3f, 3f)).build(Registration.entityKey("projectile_water_dragon")));
		}

		public static class ItemRanged extends Item {
			public ItemRanged() {
				super(Registration.itemProps("water_dragon", null).stacksTo(1));
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
	public static class WaterGunItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "water_gun", v -> block = (Item) v);
		}
		public static EntityType<ArrowCustomEntity> arrow;

		public WaterGunItem(NarutoShippudenModElements instance) {
			super(instance, 79);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemRanged());
			elements.entities.add(() -> arrow = (EntityType.Builder.<ArrowCustomEntity>of(ArrowCustomEntity::new, MobCategory.MISC) .setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1) .sized(1.0f, 1.0f)).build(Registration.entityKey("projectile_water_gun")));
		}

		public static class ItemRanged extends Item {
			public ItemRanged() {
				super(Registration.itemProps("water_gun", null).stacksTo(1));
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
	public static class WaterWaveItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "water_wave", v -> block = (Item) v);
		}
		public static EntityType<ArrowCustomEntity> arrow;

		public WaterWaveItem(NarutoShippudenModElements instance) {
			super(instance, 499);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemRanged());
			elements.entities.add(() -> arrow = (EntityType.Builder.<ArrowCustomEntity>of(ArrowCustomEntity::new, MobCategory.MISC) .setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1) .sized(0.5f, 0.5f)).build(Registration.entityKey("projectile_water_wave")));
		}

		public static class ItemRanged extends Item {
			public ItemRanged() {
				super(Registration.itemProps("water_wave", null).stacksTo(1));
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
						ArrowCustomEntity entityarrow = shoot(world, entity, world.getRandom(), 1f, 20, 0);
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
			entityarrow.setBaseDamage(20);
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
	public static class WindBallItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "wind_ball", v -> block = (Item) v);
		}
		public static EntityType<ArrowCustomEntity> arrow;

		public WindBallItem(NarutoShippudenModElements instance) {
			super(instance, 503);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemRanged());
			elements.entities.add(() -> arrow = (EntityType.Builder.<ArrowCustomEntity>of(ArrowCustomEntity::new, MobCategory.MISC) .setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1) .sized(3f, 3f)).build(Registration.entityKey("projectile_wind_ball")));
		}

		public static class ItemRanged extends Item {
			public ItemRanged() {
				super(Registration.itemProps("wind_ball", null).stacksTo(1));
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
						ArrowCustomEntity entityarrow = shoot(world, entity, world.getRandom(), 1f, 20, 0);
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
			entityarrow.setBaseDamage(20);
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
	public static class WindDiskItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "wind_disk", v -> block = (Item) v);
		}
		public static EntityType<ArrowCustomEntity> arrow;

		public WindDiskItem(NarutoShippudenModElements instance) {
			super(instance, 501);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemRanged());
			elements.entities.add(() -> arrow = (EntityType.Builder.<ArrowCustomEntity>of(ArrowCustomEntity::new, MobCategory.MISC) .setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1) .sized(2.5f, 2.5f)).build(Registration.entityKey("projectile_wind_disk")));
		}

		public static class ItemRanged extends Item {
			public ItemRanged() {
				super(Registration.itemProps("wind_disk", null).stacksTo(1));
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
						ArrowCustomEntity entityarrow = shoot(world, entity, world.getRandom(), 1f, 20, 0);
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
			entityarrow.setBaseDamage(20);
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
	public static class WindWaveItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "wind_wave", v -> block = (Item) v);
		}
		public static EntityType<ArrowCustomEntity> arrow;

		public WindWaveItem(NarutoShippudenModElements instance) {
			super(instance, 502);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemRanged());
			elements.entities.add(() -> arrow = (EntityType.Builder.<ArrowCustomEntity>of(ArrowCustomEntity::new, MobCategory.MISC) .setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1) .sized(0.5f, 0.5f)).build(Registration.entityKey("projectile_wind_wave")));
		}

		public static class ItemRanged extends Item {
			public ItemRanged() {
				super(Registration.itemProps("wind_wave", null).stacksTo(1));
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
						ArrowCustomEntity entityarrow = shoot(world, entity, world.getRandom(), 1f, 20, 0);
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
			entityarrow.setBaseDamage(20);
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
	public static class WoodDragonItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "wood_dragon", v -> block = (Item) v);
		}
		public static EntityType<ArrowCustomEntity> arrow;

		public WoodDragonItem(NarutoShippudenModElements instance) {
			super(instance, 788);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemRanged());
			elements.entities.add(() -> arrow = (EntityType.Builder.<ArrowCustomEntity>of(ArrowCustomEntity::new, MobCategory.MISC) .setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1) .sized(3f, 3f)).build(Registration.entityKey("projectile_wood_dragon")));
		}

		public static class ItemRanged extends Item {
			public ItemRanged() {
				super(Registration.itemProps("wood_dragon", null).stacksTo(1));
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
