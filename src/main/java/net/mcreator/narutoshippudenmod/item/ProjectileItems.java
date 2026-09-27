package net.mcreator.narutoshippudenmod.item;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.stream.Stream;
import net.mcreator.narutoshippudenmod.NarutoShippudenModElements;
import net.mcreator.narutoshippudenmod.entity.renderer.ProjectileRenderers.ExplosiveKunaiBulletRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.ProjectileRenderers.FireDragonFlameBulletRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.ProjectileRenderers.FlyingThunderGodKunaiBulletRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.ProjectileRenderers.FumaShurikenBulletRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.ProjectileRenderers.IronSandBulletRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.ProjectileRenderers.KunaiBulletRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.ProjectileRenderers.NuibariBulletRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.ProjectileRenderers.PoisonKunaiBulletRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.ProjectileRenderers.ShurikenBulletRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.ProjectileRenderers.ToroiUniqueFumaShurikenBulletRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.ProjectileRenderers.WaterSharkBulletRenderer;
import net.mcreator.narutoshippudenmod.item.WeaponItems.FlyingThunderGodKunaiItem;
import net.mcreator.narutoshippudenmod.item.WeaponItems.FumaShurikenItem;
import net.mcreator.narutoshippudenmod.item.WeaponItems.ToroiUniqueFumaShurikenItem;
import net.mcreator.narutoshippudenmod.procedures.JutsuEffectProcedures.GreatFireballWhileProjectileFlyingTickProcedure;
import net.mcreator.narutoshippudenmod.procedures.WeaponProcedures.ExplosiveKunaiBulletProjectileHitsBlockProcedure;
import net.mcreator.narutoshippudenmod.procedures.WeaponProcedures.FlyingThunderGodKunaiBulletProjectileHitsBlockProcedure;
import net.mcreator.narutoshippudenmod.procedures.WeaponProcedures.FumaShurikenBulletProjectileHitsBlockProcedure;
import net.mcreator.narutoshippudenmod.procedures.WeaponProcedures.KunaiBulletProjectileHitsBlockProcedure;
import net.mcreator.narutoshippudenmod.procedures.WeaponProcedures.NuibariBulletProjectileHitsLivingEntityProcedure;
import net.mcreator.narutoshippudenmod.procedures.WeaponProcedures.PoisonKunaiBulletProjectileHitsBlockProcedure;
import net.mcreator.narutoshippudenmod.procedures.WeaponProcedures.PoisonKunaiBulletProjectileHitsLivingEntityProcedure;
import net.mcreator.narutoshippudenmod.procedures.WeaponProcedures.ShurikenBulletProjectileHitsBlockProcedure;
import net.mcreator.narutoshippudenmod.procedures.WeaponProcedures.ToroiUniqueFumaShurikenBulletProjectileHitsBlockProcedure;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.IRendersAsItem;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.UseAction;
import net.minecraft.network.IPacket;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ObjectHolder;

public final class ProjectileItems {
	private ProjectileItems() {
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class ExplosiveKunaiBulletItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:explosive_kunai_bullet")
		public static final Item block = null;
		public static final EntityType arrow = (EntityType.Builder.<ArrowCustomEntity>create(ArrowCustomEntity::new, EntityClassification.MISC)
				.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).setCustomClientFactory(ArrowCustomEntity::new)
				.size(0.5f, 0.5f)).build("projectile_explosive_kunai_bullet").setRegistryName("projectile_explosive_kunai_bullet");

		public ExplosiveKunaiBulletItem(NarutoShippudenModElements instance) {
			super(instance, 966);
			FMLJavaModLoadingContext.get().getModEventBus().register(new ExplosiveKunaiBulletRenderer.ModelRegisterHandler());
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemRanged());
			elements.entities.add(() -> arrow);
		}

		public static class ItemRanged extends Item {
			public ItemRanged() {
				super(new Item.Properties().group(null).maxStackSize(0));
				setRegistryName("explosive_kunai_bullet");
			}

			@Override
			public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
				entity.setActiveHand(hand);
				return new ActionResult(ActionResultType.SUCCESS, entity.getHeldItem(hand));
			}

			@Override
			public UseAction getUseAction(ItemStack itemstack) {
				return UseAction.NONE;
			}

			@Override
			public int getUseDuration(ItemStack itemstack) {
				return 72000;
			}

			@Override
			public void onPlayerStoppedUsing(ItemStack itemstack, World world, LivingEntity entityLiving, int timeLeft) {
				if (!world.isRemote && entityLiving instanceof ServerPlayerEntity) {
					ServerPlayerEntity entity = (ServerPlayerEntity) entityLiving;
					double x = entity.getPosX();
					double y = entity.getPosY();
					double z = entity.getPosZ();
					if (true) {
						ArrowCustomEntity entityarrow = shoot(world, entity, random, 2f, 0, 0);
						itemstack.damageItem(1, entity, e -> e.sendBreakAnimation(entity.getActiveHand()));
						entityarrow.pickupStatus = AbstractArrowEntity.PickupStatus.DISALLOWED;
					}
				}
			}
		}

		@OnlyIn(value = Dist.CLIENT, _interface = IRendersAsItem.class)
		public static class ArrowCustomEntity extends AbstractArrowEntity implements IRendersAsItem {
			public ArrowCustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
				super(arrow, world);
			}

			public ArrowCustomEntity(EntityType<? extends ArrowCustomEntity> type, World world) {
				super(type, world);
			}

			public ArrowCustomEntity(EntityType<? extends ArrowCustomEntity> type, double x, double y, double z, World world) {
				super(type, x, y, z, world);
			}

			public ArrowCustomEntity(EntityType<? extends ArrowCustomEntity> type, LivingEntity entity, World world) {
				super(type, entity, world);
			}

			@Override
			public IPacket<?> createSpawnPacket() {
				return NetworkHooks.getEntitySpawningPacket(this);
			}

			@Override
			@OnlyIn(Dist.CLIENT)
			public ItemStack getItem() {
				return ItemStack.EMPTY;
			}

			@Override
			protected ItemStack getArrowStack() {
				return ItemStack.EMPTY;
			}

			@Override
			protected void arrowHit(LivingEntity entity) {
				super.arrowHit(entity);
				entity.setArrowCountInEntity(entity.getArrowCountInEntity() - 1);
			}

			@Override
			public void onEntityHit(EntityRayTraceResult entityRayTraceResult) {
				super.onEntityHit(entityRayTraceResult);
				Entity entity = entityRayTraceResult.getEntity();
				Entity sourceentity = this.func_234616_v_();
				Entity immediatesourceentity = this;
				double x = this.getPosX();
				double y = this.getPosY();
				double z = this.getPosZ();
				World world = this.world;

				ExplosiveKunaiBulletProjectileHitsBlockProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}

			@Override
			public void func_230299_a_(BlockRayTraceResult blockRayTraceResult) {
				super.func_230299_a_(blockRayTraceResult);
				double x = blockRayTraceResult.getPos().getX();
				double y = blockRayTraceResult.getPos().getY();
				double z = blockRayTraceResult.getPos().getZ();
				World world = this.world;
				Entity entity = this.func_234616_v_();
				Entity immediatesourceentity = this;

				ExplosiveKunaiBulletProjectileHitsBlockProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}

			@Override
			public void tick() {
				super.tick();
				double x = this.getPosX();
				double y = this.getPosY();
				double z = this.getPosZ();
				World world = this.world;
				Entity entity = this.func_234616_v_();
				Entity immediatesourceentity = this;
				if (this.inGround)
					this.remove();
			}
		}

		public static ArrowCustomEntity shoot(World world, LivingEntity entity, Random random, float power, double damage, int knockback) {
			ArrowCustomEntity entityarrow = new ArrowCustomEntity(arrow, entity, world);
			entityarrow.shoot(entity.getLook(1).x, entity.getLook(1).y, entity.getLook(1).z, power * 2, 0);
			entityarrow.setSilent(true);
			entityarrow.setIsCritical(false);
			entityarrow.setDamage(damage);
			entityarrow.setKnockbackStrength(knockback);
			world.addEntity(entityarrow);
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			world.playSound((PlayerEntity) null, (double) x, (double) y, (double) z,
					(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("")), SoundCategory.PLAYERS, 1,
					1f / (random.nextFloat() * 0.5f + 1) + (power / 2));
			return entityarrow;
		}

		public static ArrowCustomEntity shoot(LivingEntity entity, LivingEntity target) {
			ArrowCustomEntity entityarrow = new ArrowCustomEntity(arrow, entity, entity.world);
			double d0 = target.getPosY() + (double) target.getEyeHeight() - 1.1;
			double d1 = target.getPosX() - entity.getPosX();
			double d3 = target.getPosZ() - entity.getPosZ();
			entityarrow.shoot(d1, d0 - entityarrow.getPosY() + (double) MathHelper.sqrt(d1 * d1 + d3 * d3) * 0.2F, d3, 2f * 2, 12.0F);
			entityarrow.setSilent(true);
			entityarrow.setDamage(0);
			entityarrow.setKnockbackStrength(0);
			entityarrow.setIsCritical(false);
			entity.world.addEntity(entityarrow);
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			entity.world.playSound((PlayerEntity) null, (double) x, (double) y, (double) z,
					(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("")), SoundCategory.PLAYERS, 1,
					1f / (new Random().nextFloat() * 0.5f + 1));
			return entityarrow;
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class FireDragonFlameBulletItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:fire_dragon_flame_bullet")
		public static final Item block = null;
		public static final EntityType arrow = (EntityType.Builder.<ArrowCustomEntity>create(ArrowCustomEntity::new, EntityClassification.MISC)
				.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).setCustomClientFactory(ArrowCustomEntity::new)
				.size(3f, 3f)).build("projectile_fire_dragon_flame_bullet").setRegistryName("projectile_fire_dragon_flame_bullet");

		public FireDragonFlameBulletItem(NarutoShippudenModElements instance) {
			super(instance, 938);
			FMLJavaModLoadingContext.get().getModEventBus().register(new FireDragonFlameBulletRenderer.ModelRegisterHandler());
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemRanged());
			elements.entities.add(() -> arrow);
		}

		public static class ItemRanged extends Item {
			public ItemRanged() {
				super(new Item.Properties().group(null).maxStackSize(0));
				setRegistryName("fire_dragon_flame_bullet");
			}

			@Override
			public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
				entity.setActiveHand(hand);
				return new ActionResult(ActionResultType.SUCCESS, entity.getHeldItem(hand));
			}

			@Override
			public UseAction getUseAction(ItemStack itemstack) {
				return UseAction.NONE;
			}

			@Override
			public int getUseDuration(ItemStack itemstack) {
				return 72000;
			}

			@Override
			public void onPlayerStoppedUsing(ItemStack itemstack, World world, LivingEntity entityLiving, int timeLeft) {
				if (!world.isRemote && entityLiving instanceof ServerPlayerEntity) {
					ServerPlayerEntity entity = (ServerPlayerEntity) entityLiving;
					double x = entity.getPosX();
					double y = entity.getPosY();
					double z = entity.getPosZ();
					if (true) {
						ArrowCustomEntity entityarrow = shoot(world, entity, random, 1f, 15, 1);
						itemstack.damageItem(1, entity, e -> e.sendBreakAnimation(entity.getActiveHand()));
						entityarrow.pickupStatus = AbstractArrowEntity.PickupStatus.DISALLOWED;
					}
				}
			}
		}

		@OnlyIn(value = Dist.CLIENT, _interface = IRendersAsItem.class)
		public static class ArrowCustomEntity extends AbstractArrowEntity implements IRendersAsItem {
			public ArrowCustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
				super(arrow, world);
			}

			public ArrowCustomEntity(EntityType<? extends ArrowCustomEntity> type, World world) {
				super(type, world);
			}

			public ArrowCustomEntity(EntityType<? extends ArrowCustomEntity> type, double x, double y, double z, World world) {
				super(type, x, y, z, world);
			}

			public ArrowCustomEntity(EntityType<? extends ArrowCustomEntity> type, LivingEntity entity, World world) {
				super(type, entity, world);
			}

			@Override
			public IPacket<?> createSpawnPacket() {
				return NetworkHooks.getEntitySpawningPacket(this);
			}

			@Override
			@OnlyIn(Dist.CLIENT)
			public ItemStack getItem() {
				return ItemStack.EMPTY;
			}

			@Override
			protected ItemStack getArrowStack() {
				return ItemStack.EMPTY;
			}

			@Override
			protected void arrowHit(LivingEntity entity) {
				super.arrowHit(entity);
				entity.setArrowCountInEntity(entity.getArrowCountInEntity() - 1);
			}

			@Override
			public void tick() {
				super.tick();
				double x = this.getPosX();
				double y = this.getPosY();
				double z = this.getPosZ();
				World world = this.world;
				Entity entity = this.func_234616_v_();
				Entity immediatesourceentity = this;

				GreatFireballWhileProjectileFlyingTickProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("immediatesourceentity", immediatesourceentity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				if (this.inGround)
					this.remove();
			}
		}

		public static ArrowCustomEntity shoot(World world, LivingEntity entity, Random random, float power, double damage, int knockback) {
			ArrowCustomEntity entityarrow = new ArrowCustomEntity(arrow, entity, world);
			entityarrow.shoot(entity.getLook(1).x, entity.getLook(1).y, entity.getLook(1).z, power * 2, 0);
			entityarrow.setSilent(true);
			entityarrow.setIsCritical(false);
			entityarrow.setDamage(damage);
			entityarrow.setKnockbackStrength(knockback);
			entityarrow.setFire(100);
			world.addEntity(entityarrow);
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			world.playSound((PlayerEntity) null, (double) x, (double) y, (double) z,
					(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("")), SoundCategory.PLAYERS, 1,
					1f / (random.nextFloat() * 0.5f + 1) + (power / 2));
			return entityarrow;
		}

		public static ArrowCustomEntity shoot(LivingEntity entity, LivingEntity target) {
			ArrowCustomEntity entityarrow = new ArrowCustomEntity(arrow, entity, entity.world);
			double d0 = target.getPosY() + (double) target.getEyeHeight() - 1.1;
			double d1 = target.getPosX() - entity.getPosX();
			double d3 = target.getPosZ() - entity.getPosZ();
			entityarrow.shoot(d1, d0 - entityarrow.getPosY() + (double) MathHelper.sqrt(d1 * d1 + d3 * d3) * 0.2F, d3, 1f * 2, 12.0F);
			entityarrow.setSilent(true);
			entityarrow.setDamage(15);
			entityarrow.setKnockbackStrength(1);
			entityarrow.setIsCritical(false);
			entityarrow.setFire(100);
			entity.world.addEntity(entityarrow);
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			entity.world.playSound((PlayerEntity) null, (double) x, (double) y, (double) z,
					(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("")), SoundCategory.PLAYERS, 1,
					1f / (new Random().nextFloat() * 0.5f + 1));
			return entityarrow;
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class FlyingThunderGodKunaiBulletItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:flying_thunder_god_kunai_bullet")
		public static final Item block = null;
		public static final EntityType arrow = (EntityType.Builder.<ArrowCustomEntity>create(ArrowCustomEntity::new, EntityClassification.MISC)
				.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).setCustomClientFactory(ArrowCustomEntity::new)
				.size(0.5f, 0.5f)).build("projectile_flying_thunder_god_kunai_bullet").setRegistryName("projectile_flying_thunder_god_kunai_bullet");

		public FlyingThunderGodKunaiBulletItem(NarutoShippudenModElements instance) {
			super(instance, 732);
			FMLJavaModLoadingContext.get().getModEventBus().register(new FlyingThunderGodKunaiBulletRenderer.ModelRegisterHandler());
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemRanged());
			elements.entities.add(() -> arrow);
		}

		public static class ItemRanged extends Item {
			public ItemRanged() {
				super(new Item.Properties().group(null).maxStackSize(0));
				setRegistryName("flying_thunder_god_kunai_bullet");
			}

			@Override
			public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
				entity.setActiveHand(hand);
				return new ActionResult(ActionResultType.SUCCESS, entity.getHeldItem(hand));
			}

			@Override
			public UseAction getUseAction(ItemStack itemstack) {
				return UseAction.NONE;
			}

			@Override
			public int getUseDuration(ItemStack itemstack) {
				return 72000;
			}

			@Override
			public void onPlayerStoppedUsing(ItemStack itemstack, World world, LivingEntity entityLiving, int timeLeft) {
				if (!world.isRemote && entityLiving instanceof ServerPlayerEntity) {
					ServerPlayerEntity entity = (ServerPlayerEntity) entityLiving;
					double x = entity.getPosX();
					double y = entity.getPosY();
					double z = entity.getPosZ();
					if (true) {
						ArrowCustomEntity entityarrow = shoot(world, entity, random, 0f, 0, 0);
						itemstack.damageItem(1, entity, e -> e.sendBreakAnimation(entity.getActiveHand()));
						entityarrow.pickupStatus = AbstractArrowEntity.PickupStatus.DISALLOWED;
					}
				}
			}
		}

		@OnlyIn(value = Dist.CLIENT, _interface = IRendersAsItem.class)
		public static class ArrowCustomEntity extends AbstractArrowEntity implements IRendersAsItem {
			public ArrowCustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
				super(arrow, world);
			}

			public ArrowCustomEntity(EntityType<? extends ArrowCustomEntity> type, World world) {
				super(type, world);
			}

			public ArrowCustomEntity(EntityType<? extends ArrowCustomEntity> type, double x, double y, double z, World world) {
				super(type, x, y, z, world);
			}

			public ArrowCustomEntity(EntityType<? extends ArrowCustomEntity> type, LivingEntity entity, World world) {
				super(type, entity, world);
			}

			@Override
			public IPacket<?> createSpawnPacket() {
				return NetworkHooks.getEntitySpawningPacket(this);
			}

			@Override
			@OnlyIn(Dist.CLIENT)
			public ItemStack getItem() {
				return new ItemStack(FlyingThunderGodKunaiItem.block);
			}

			@Override
			protected ItemStack getArrowStack() {
				return ItemStack.EMPTY;
			}

			@Override
			protected void arrowHit(LivingEntity entity) {
				super.arrowHit(entity);
				entity.setArrowCountInEntity(entity.getArrowCountInEntity() - 1);
			}

			@Override
			public void func_230299_a_(BlockRayTraceResult blockRayTraceResult) {
				super.func_230299_a_(blockRayTraceResult);
				double x = blockRayTraceResult.getPos().getX();
				double y = blockRayTraceResult.getPos().getY();
				double z = blockRayTraceResult.getPos().getZ();
				World world = this.world;
				Entity entity = this.func_234616_v_();
				Entity immediatesourceentity = this;

				FlyingThunderGodKunaiBulletProjectileHitsBlockProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z), new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}

			@Override
			public void tick() {
				super.tick();
				double x = this.getPosX();
				double y = this.getPosY();
				double z = this.getPosZ();
				World world = this.world;
				Entity entity = this.func_234616_v_();
				Entity immediatesourceentity = this;
				if (this.inGround)
					this.remove();
			}
		}

		public static ArrowCustomEntity shoot(World world, LivingEntity entity, Random random, float power, double damage, int knockback) {
			ArrowCustomEntity entityarrow = new ArrowCustomEntity(arrow, entity, world);
			entityarrow.shoot(entity.getLook(1).x, entity.getLook(1).y, entity.getLook(1).z, power * 2, 0);
			entityarrow.setSilent(true);
			entityarrow.setIsCritical(false);
			entityarrow.setDamage(damage);
			entityarrow.setKnockbackStrength(knockback);
			world.addEntity(entityarrow);
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			world.playSound((PlayerEntity) null, (double) x, (double) y, (double) z,
					(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("")), SoundCategory.PLAYERS, 1,
					1f / (random.nextFloat() * 0.5f + 1) + (power / 2));
			return entityarrow;
		}

		public static ArrowCustomEntity shoot(LivingEntity entity, LivingEntity target) {
			ArrowCustomEntity entityarrow = new ArrowCustomEntity(arrow, entity, entity.world);
			double d0 = target.getPosY() + (double) target.getEyeHeight() - 1.1;
			double d1 = target.getPosX() - entity.getPosX();
			double d3 = target.getPosZ() - entity.getPosZ();
			entityarrow.shoot(d1, d0 - entityarrow.getPosY() + (double) MathHelper.sqrt(d1 * d1 + d3 * d3) * 0.2F, d3, 0f * 2, 12.0F);
			entityarrow.setSilent(true);
			entityarrow.setDamage(0);
			entityarrow.setKnockbackStrength(0);
			entityarrow.setIsCritical(false);
			entity.world.addEntity(entityarrow);
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			entity.world.playSound((PlayerEntity) null, (double) x, (double) y, (double) z,
					(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("")), SoundCategory.PLAYERS, 1,
					1f / (new Random().nextFloat() * 0.5f + 1));
			return entityarrow;
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class FumaShurikenBulletItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:fuma_shuriken_bullet")
		public static final Item block = null;
		public static final EntityType arrow = (EntityType.Builder.<ArrowCustomEntity>create(ArrowCustomEntity::new, EntityClassification.MISC)
				.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).setCustomClientFactory(ArrowCustomEntity::new)
				.size(0.5f, 0.5f)).build("projectile_fuma_shuriken_bullet").setRegistryName("projectile_fuma_shuriken_bullet");

		public FumaShurikenBulletItem(NarutoShippudenModElements instance) {
			super(instance, 975);
			FMLJavaModLoadingContext.get().getModEventBus().register(new FumaShurikenBulletRenderer.ModelRegisterHandler());
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemRanged());
			elements.entities.add(() -> arrow);
		}

		public static class ItemRanged extends Item {
			public ItemRanged() {
				super(new Item.Properties().group(null).maxStackSize(0));
				setRegistryName("fuma_shuriken_bullet");
			}

			@Override
			public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
				entity.setActiveHand(hand);
				return new ActionResult(ActionResultType.SUCCESS, entity.getHeldItem(hand));
			}

			@Override
			public UseAction getUseAction(ItemStack itemstack) {
				return UseAction.NONE;
			}

			@Override
			public int getUseDuration(ItemStack itemstack) {
				return 72000;
			}

			@Override
			public void onPlayerStoppedUsing(ItemStack itemstack, World world, LivingEntity entityLiving, int timeLeft) {
				if (!world.isRemote && entityLiving instanceof ServerPlayerEntity) {
					ServerPlayerEntity entity = (ServerPlayerEntity) entityLiving;
					double x = entity.getPosX();
					double y = entity.getPosY();
					double z = entity.getPosZ();
					if (true) {
						ArrowCustomEntity entityarrow = shoot(world, entity, random, 0f, 0, 0);
						itemstack.damageItem(1, entity, e -> e.sendBreakAnimation(entity.getActiveHand()));
						entityarrow.pickupStatus = AbstractArrowEntity.PickupStatus.DISALLOWED;
					}
				}
			}
		}

		@OnlyIn(value = Dist.CLIENT, _interface = IRendersAsItem.class)
		public static class ArrowCustomEntity extends AbstractArrowEntity implements IRendersAsItem {
			public ArrowCustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
				super(arrow, world);
			}

			public ArrowCustomEntity(EntityType<? extends ArrowCustomEntity> type, World world) {
				super(type, world);
			}

			public ArrowCustomEntity(EntityType<? extends ArrowCustomEntity> type, double x, double y, double z, World world) {
				super(type, x, y, z, world);
			}

			public ArrowCustomEntity(EntityType<? extends ArrowCustomEntity> type, LivingEntity entity, World world) {
				super(type, entity, world);
			}

			@Override
			public IPacket<?> createSpawnPacket() {
				return NetworkHooks.getEntitySpawningPacket(this);
			}

			@Override
			@OnlyIn(Dist.CLIENT)
			public ItemStack getItem() {
				return new ItemStack(FumaShurikenItem.block);
			}

			@Override
			protected ItemStack getArrowStack() {
				return ItemStack.EMPTY;
			}

			@Override
			protected void arrowHit(LivingEntity entity) {
				super.arrowHit(entity);
				entity.setArrowCountInEntity(entity.getArrowCountInEntity() - 1);
			}

			@Override
			public void func_230299_a_(BlockRayTraceResult blockRayTraceResult) {
				super.func_230299_a_(blockRayTraceResult);
				double x = blockRayTraceResult.getPos().getX();
				double y = blockRayTraceResult.getPos().getY();
				double z = blockRayTraceResult.getPos().getZ();
				World world = this.world;
				Entity entity = this.func_234616_v_();
				Entity immediatesourceentity = this;

				FumaShurikenBulletProjectileHitsBlockProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}

			@Override
			public void tick() {
				super.tick();
				double x = this.getPosX();
				double y = this.getPosY();
				double z = this.getPosZ();
				World world = this.world;
				Entity entity = this.func_234616_v_();
				Entity immediatesourceentity = this;
				if (this.inGround)
					this.remove();
			}
		}

		public static ArrowCustomEntity shoot(World world, LivingEntity entity, Random random, float power, double damage, int knockback) {
			ArrowCustomEntity entityarrow = new ArrowCustomEntity(arrow, entity, world);
			entityarrow.shoot(entity.getLook(1).x, entity.getLook(1).y, entity.getLook(1).z, power * 2, 0);
			entityarrow.setSilent(true);
			entityarrow.setIsCritical(false);
			entityarrow.setDamage(damage);
			entityarrow.setKnockbackStrength(knockback);
			world.addEntity(entityarrow);
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			world.playSound((PlayerEntity) null, (double) x, (double) y, (double) z,
					(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("")), SoundCategory.PLAYERS, 1,
					1f / (random.nextFloat() * 0.5f + 1) + (power / 2));
			return entityarrow;
		}

		public static ArrowCustomEntity shoot(LivingEntity entity, LivingEntity target) {
			ArrowCustomEntity entityarrow = new ArrowCustomEntity(arrow, entity, entity.world);
			double d0 = target.getPosY() + (double) target.getEyeHeight() - 1.1;
			double d1 = target.getPosX() - entity.getPosX();
			double d3 = target.getPosZ() - entity.getPosZ();
			entityarrow.shoot(d1, d0 - entityarrow.getPosY() + (double) MathHelper.sqrt(d1 * d1 + d3 * d3) * 0.2F, d3, 0f * 2, 12.0F);
			entityarrow.setSilent(true);
			entityarrow.setDamage(0);
			entityarrow.setKnockbackStrength(0);
			entityarrow.setIsCritical(false);
			entity.world.addEntity(entityarrow);
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			entity.world.playSound((PlayerEntity) null, (double) x, (double) y, (double) z,
					(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("")), SoundCategory.PLAYERS, 1,
					1f / (new Random().nextFloat() * 0.5f + 1));
			return entityarrow;
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class IronSandBulletItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:iron_sand_bullet")
		public static final Item block = null;
		public static final EntityType arrow = (EntityType.Builder.<ArrowCustomEntity>create(ArrowCustomEntity::new, EntityClassification.MISC)
				.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).setCustomClientFactory(ArrowCustomEntity::new)
				.size(0.5f, 0.5f)).build("projectile_iron_sand_bullet").setRegistryName("projectile_iron_sand_bullet");

		public IronSandBulletItem(NarutoShippudenModElements instance) {
			super(instance, 574);
			FMLJavaModLoadingContext.get().getModEventBus().register(new IronSandBulletRenderer.ModelRegisterHandler());
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemRanged());
			elements.entities.add(() -> arrow);
		}

		public static class ItemRanged extends Item {
			public ItemRanged() {
				super(new Item.Properties().group(null).maxStackSize(0));
				setRegistryName("iron_sand_bullet");
			}

			@Override
			public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
				entity.setActiveHand(hand);
				return new ActionResult(ActionResultType.SUCCESS, entity.getHeldItem(hand));
			}

			@Override
			public UseAction getUseAction(ItemStack itemstack) {
				return UseAction.NONE;
			}

			@Override
			public int getUseDuration(ItemStack itemstack) {
				return 72000;
			}

			@Override
			public void onPlayerStoppedUsing(ItemStack itemstack, World world, LivingEntity entityLiving, int timeLeft) {
				if (!world.isRemote && entityLiving instanceof ServerPlayerEntity) {
					ServerPlayerEntity entity = (ServerPlayerEntity) entityLiving;
					double x = entity.getPosX();
					double y = entity.getPosY();
					double z = entity.getPosZ();
					if (true) {
						ArrowCustomEntity entityarrow = shoot(world, entity, random, 1f, 10, 1);
						itemstack.damageItem(1, entity, e -> e.sendBreakAnimation(entity.getActiveHand()));
						entityarrow.pickupStatus = AbstractArrowEntity.PickupStatus.DISALLOWED;
					}
				}
			}
		}

		@OnlyIn(value = Dist.CLIENT, _interface = IRendersAsItem.class)
		public static class ArrowCustomEntity extends AbstractArrowEntity implements IRendersAsItem {
			public ArrowCustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
				super(arrow, world);
			}

			public ArrowCustomEntity(EntityType<? extends ArrowCustomEntity> type, World world) {
				super(type, world);
			}

			public ArrowCustomEntity(EntityType<? extends ArrowCustomEntity> type, double x, double y, double z, World world) {
				super(type, x, y, z, world);
			}

			public ArrowCustomEntity(EntityType<? extends ArrowCustomEntity> type, LivingEntity entity, World world) {
				super(type, entity, world);
			}

			@Override
			public IPacket<?> createSpawnPacket() {
				return NetworkHooks.getEntitySpawningPacket(this);
			}

			@Override
			@OnlyIn(Dist.CLIENT)
			public ItemStack getItem() {
				return ItemStack.EMPTY;
			}

			@Override
			protected ItemStack getArrowStack() {
				return ItemStack.EMPTY;
			}

			@Override
			protected void arrowHit(LivingEntity entity) {
				super.arrowHit(entity);
				entity.setArrowCountInEntity(entity.getArrowCountInEntity() - 1);
			}

			@Override
			public void tick() {
				super.tick();
				double x = this.getPosX();
				double y = this.getPosY();
				double z = this.getPosZ();
				World world = this.world;
				Entity entity = this.func_234616_v_();
				Entity immediatesourceentity = this;

				GreatFireballWhileProjectileFlyingTickProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("immediatesourceentity", immediatesourceentity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				if (this.inGround)
					this.remove();
			}
		}

		public static ArrowCustomEntity shoot(World world, LivingEntity entity, Random random, float power, double damage, int knockback) {
			ArrowCustomEntity entityarrow = new ArrowCustomEntity(arrow, entity, world);
			entityarrow.shoot(entity.getLook(1).x, entity.getLook(1).y, entity.getLook(1).z, power * 2, 0);
			entityarrow.setSilent(true);
			entityarrow.setIsCritical(false);
			entityarrow.setDamage(damage);
			entityarrow.setKnockbackStrength(knockback);
			world.addEntity(entityarrow);
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			world.playSound((PlayerEntity) null, (double) x, (double) y, (double) z,
					(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("")), SoundCategory.PLAYERS, 1,
					1f / (random.nextFloat() * 0.5f + 1) + (power / 2));
			return entityarrow;
		}

		public static ArrowCustomEntity shoot(LivingEntity entity, LivingEntity target) {
			ArrowCustomEntity entityarrow = new ArrowCustomEntity(arrow, entity, entity.world);
			double d0 = target.getPosY() + (double) target.getEyeHeight() - 1.1;
			double d1 = target.getPosX() - entity.getPosX();
			double d3 = target.getPosZ() - entity.getPosZ();
			entityarrow.shoot(d1, d0 - entityarrow.getPosY() + (double) MathHelper.sqrt(d1 * d1 + d3 * d3) * 0.2F, d3, 1f * 2, 12.0F);
			entityarrow.setSilent(true);
			entityarrow.setDamage(10);
			entityarrow.setKnockbackStrength(1);
			entityarrow.setIsCritical(false);
			entity.world.addEntity(entityarrow);
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			entity.world.playSound((PlayerEntity) null, (double) x, (double) y, (double) z,
					(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("")), SoundCategory.PLAYERS, 1,
					1f / (new Random().nextFloat() * 0.5f + 1));
			return entityarrow;
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class KunaiBulletItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:kunai_bullet")
		public static final Item block = null;
		public static final EntityType arrow = (EntityType.Builder.<ArrowCustomEntity>create(ArrowCustomEntity::new, EntityClassification.MISC)
				.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).setCustomClientFactory(ArrowCustomEntity::new)
				.size(0.5f, 0.5f)).build("projectile_kunai_bullet").setRegistryName("projectile_kunai_bullet");

		public KunaiBulletItem(NarutoShippudenModElements instance) {
			super(instance, 964);
			FMLJavaModLoadingContext.get().getModEventBus().register(new KunaiBulletRenderer.ModelRegisterHandler());
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemRanged());
			elements.entities.add(() -> arrow);
		}

		public static class ItemRanged extends Item {
			public ItemRanged() {
				super(new Item.Properties().group(null).maxStackSize(0));
				setRegistryName("kunai_bullet");
			}

			@Override
			public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
				entity.setActiveHand(hand);
				return new ActionResult(ActionResultType.SUCCESS, entity.getHeldItem(hand));
			}

			@Override
			public UseAction getUseAction(ItemStack itemstack) {
				return UseAction.NONE;
			}

			@Override
			public int getUseDuration(ItemStack itemstack) {
				return 72000;
			}

			@Override
			public void onPlayerStoppedUsing(ItemStack itemstack, World world, LivingEntity entityLiving, int timeLeft) {
				if (!world.isRemote && entityLiving instanceof ServerPlayerEntity) {
					ServerPlayerEntity entity = (ServerPlayerEntity) entityLiving;
					double x = entity.getPosX();
					double y = entity.getPosY();
					double z = entity.getPosZ();
					if (true) {
						ArrowCustomEntity entityarrow = shoot(world, entity, random, 2f, 0, 0);
						itemstack.damageItem(1, entity, e -> e.sendBreakAnimation(entity.getActiveHand()));
						entityarrow.pickupStatus = AbstractArrowEntity.PickupStatus.DISALLOWED;
					}
				}
			}
		}

		@OnlyIn(value = Dist.CLIENT, _interface = IRendersAsItem.class)
		public static class ArrowCustomEntity extends AbstractArrowEntity implements IRendersAsItem {
			public ArrowCustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
				super(arrow, world);
			}

			public ArrowCustomEntity(EntityType<? extends ArrowCustomEntity> type, World world) {
				super(type, world);
			}

			public ArrowCustomEntity(EntityType<? extends ArrowCustomEntity> type, double x, double y, double z, World world) {
				super(type, x, y, z, world);
			}

			public ArrowCustomEntity(EntityType<? extends ArrowCustomEntity> type, LivingEntity entity, World world) {
				super(type, entity, world);
			}

			@Override
			public IPacket<?> createSpawnPacket() {
				return NetworkHooks.getEntitySpawningPacket(this);
			}

			@Override
			@OnlyIn(Dist.CLIENT)
			public ItemStack getItem() {
				return ItemStack.EMPTY;
			}

			@Override
			protected ItemStack getArrowStack() {
				return ItemStack.EMPTY;
			}

			@Override
			protected void arrowHit(LivingEntity entity) {
				super.arrowHit(entity);
				entity.setArrowCountInEntity(entity.getArrowCountInEntity() - 1);
			}

			@Override
			public void func_230299_a_(BlockRayTraceResult blockRayTraceResult) {
				super.func_230299_a_(blockRayTraceResult);
				double x = blockRayTraceResult.getPos().getX();
				double y = blockRayTraceResult.getPos().getY();
				double z = blockRayTraceResult.getPos().getZ();
				World world = this.world;
				Entity entity = this.func_234616_v_();
				Entity immediatesourceentity = this;

				KunaiBulletProjectileHitsBlockProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}

			@Override
			public void tick() {
				super.tick();
				double x = this.getPosX();
				double y = this.getPosY();
				double z = this.getPosZ();
				World world = this.world;
				Entity entity = this.func_234616_v_();
				Entity immediatesourceentity = this;
				if (this.inGround)
					this.remove();
			}
		}

		public static ArrowCustomEntity shoot(World world, LivingEntity entity, Random random, float power, double damage, int knockback) {
			ArrowCustomEntity entityarrow = new ArrowCustomEntity(arrow, entity, world);
			entityarrow.shoot(entity.getLook(1).x, entity.getLook(1).y, entity.getLook(1).z, power * 2, 0);
			entityarrow.setSilent(true);
			entityarrow.setIsCritical(false);
			entityarrow.setDamage(damage);
			entityarrow.setKnockbackStrength(knockback);
			world.addEntity(entityarrow);
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			world.playSound((PlayerEntity) null, (double) x, (double) y, (double) z,
					(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("")), SoundCategory.PLAYERS, 1,
					1f / (random.nextFloat() * 0.5f + 1) + (power / 2));
			return entityarrow;
		}

		public static ArrowCustomEntity shoot(LivingEntity entity, LivingEntity target) {
			ArrowCustomEntity entityarrow = new ArrowCustomEntity(arrow, entity, entity.world);
			double d0 = target.getPosY() + (double) target.getEyeHeight() - 1.1;
			double d1 = target.getPosX() - entity.getPosX();
			double d3 = target.getPosZ() - entity.getPosZ();
			entityarrow.shoot(d1, d0 - entityarrow.getPosY() + (double) MathHelper.sqrt(d1 * d1 + d3 * d3) * 0.2F, d3, 2f * 2, 12.0F);
			entityarrow.setSilent(true);
			entityarrow.setDamage(0);
			entityarrow.setKnockbackStrength(0);
			entityarrow.setIsCritical(false);
			entity.world.addEntity(entityarrow);
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			entity.world.playSound((PlayerEntity) null, (double) x, (double) y, (double) z,
					(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("")), SoundCategory.PLAYERS, 1,
					1f / (new Random().nextFloat() * 0.5f + 1));
			return entityarrow;
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class NuibariBulletItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:nuibari_bullet")
		public static final Item block = null;
		public static final EntityType arrow = (EntityType.Builder.<ArrowCustomEntity>create(ArrowCustomEntity::new, EntityClassification.MISC)
				.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).setCustomClientFactory(ArrowCustomEntity::new)
				.size(0.5f, 0.5f)).build("projectile_nuibari_bullet").setRegistryName("projectile_nuibari_bullet");

		public NuibariBulletItem(NarutoShippudenModElements instance) {
			super(instance, 1319);
			FMLJavaModLoadingContext.get().getModEventBus().register(new NuibariBulletRenderer.ModelRegisterHandler());
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemRanged());
			elements.entities.add(() -> arrow);
		}

		public static class ItemRanged extends Item {
			public ItemRanged() {
				super(new Item.Properties().group(null).maxStackSize(0));
				setRegistryName("nuibari_bullet");
			}

			@Override
			public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
				entity.setActiveHand(hand);
				return new ActionResult(ActionResultType.SUCCESS, entity.getHeldItem(hand));
			}

			@Override
			public UseAction getUseAction(ItemStack itemstack) {
				return UseAction.NONE;
			}

			@Override
			public int getUseDuration(ItemStack itemstack) {
				return 72000;
			}

			@Override
			public void onPlayerStoppedUsing(ItemStack itemstack, World world, LivingEntity entityLiving, int timeLeft) {
				if (!world.isRemote && entityLiving instanceof ServerPlayerEntity) {
					ServerPlayerEntity entity = (ServerPlayerEntity) entityLiving;
					double x = entity.getPosX();
					double y = entity.getPosY();
					double z = entity.getPosZ();
					if (true) {
						ArrowCustomEntity entityarrow = shoot(world, entity, random, 0f, 0, 0);
						itemstack.damageItem(1, entity, e -> e.sendBreakAnimation(entity.getActiveHand()));
						entityarrow.pickupStatus = AbstractArrowEntity.PickupStatus.DISALLOWED;
					}
				}
			}
		}

		@OnlyIn(value = Dist.CLIENT, _interface = IRendersAsItem.class)
		public static class ArrowCustomEntity extends AbstractArrowEntity implements IRendersAsItem {
			public ArrowCustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
				super(arrow, world);
			}

			public ArrowCustomEntity(EntityType<? extends ArrowCustomEntity> type, World world) {
				super(type, world);
			}

			public ArrowCustomEntity(EntityType<? extends ArrowCustomEntity> type, double x, double y, double z, World world) {
				super(type, x, y, z, world);
			}

			public ArrowCustomEntity(EntityType<? extends ArrowCustomEntity> type, LivingEntity entity, World world) {
				super(type, entity, world);
			}

			@Override
			public IPacket<?> createSpawnPacket() {
				return NetworkHooks.getEntitySpawningPacket(this);
			}

			@Override
			@OnlyIn(Dist.CLIENT)
			public ItemStack getItem() {
				return ItemStack.EMPTY;
			}

			@Override
			protected ItemStack getArrowStack() {
				return ItemStack.EMPTY;
			}

			@Override
			protected void arrowHit(LivingEntity entity) {
				super.arrowHit(entity);
				entity.setArrowCountInEntity(entity.getArrowCountInEntity() - 1);
			}

			@Override
			public void onEntityHit(EntityRayTraceResult entityRayTraceResult) {
				super.onEntityHit(entityRayTraceResult);
				Entity entity = entityRayTraceResult.getEntity();
				Entity sourceentity = this.func_234616_v_();
				Entity immediatesourceentity = this;
				double x = this.getPosX();
				double y = this.getPosY();
				double z = this.getPosZ();
				World world = this.world;

				NuibariBulletProjectileHitsLivingEntityProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}

			@Override
			public void tick() {
				super.tick();
				double x = this.getPosX();
				double y = this.getPosY();
				double z = this.getPosZ();
				World world = this.world;
				Entity entity = this.func_234616_v_();
				Entity immediatesourceentity = this;

				GreatFireballWhileProjectileFlyingTickProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("immediatesourceentity", immediatesourceentity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				if (this.inGround)
					this.remove();
			}
		}

		public static ArrowCustomEntity shoot(World world, LivingEntity entity, Random random, float power, double damage, int knockback) {
			ArrowCustomEntity entityarrow = new ArrowCustomEntity(arrow, entity, world);
			entityarrow.shoot(entity.getLook(1).x, entity.getLook(1).y, entity.getLook(1).z, power * 2, 0);
			entityarrow.setSilent(true);
			entityarrow.setIsCritical(false);
			entityarrow.setDamage(damage);
			entityarrow.setKnockbackStrength(knockback);
			world.addEntity(entityarrow);
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			world.playSound((PlayerEntity) null, (double) x, (double) y, (double) z,
					(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("")), SoundCategory.PLAYERS, 1,
					1f / (random.nextFloat() * 0.5f + 1) + (power / 2));
			return entityarrow;
		}

		public static ArrowCustomEntity shoot(LivingEntity entity, LivingEntity target) {
			ArrowCustomEntity entityarrow = new ArrowCustomEntity(arrow, entity, entity.world);
			double d0 = target.getPosY() + (double) target.getEyeHeight() - 1.1;
			double d1 = target.getPosX() - entity.getPosX();
			double d3 = target.getPosZ() - entity.getPosZ();
			entityarrow.shoot(d1, d0 - entityarrow.getPosY() + (double) MathHelper.sqrt(d1 * d1 + d3 * d3) * 0.2F, d3, 0f * 2, 12.0F);
			entityarrow.setSilent(true);
			entityarrow.setDamage(0);
			entityarrow.setKnockbackStrength(0);
			entityarrow.setIsCritical(false);
			entity.world.addEntity(entityarrow);
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			entity.world.playSound((PlayerEntity) null, (double) x, (double) y, (double) z,
					(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("")), SoundCategory.PLAYERS, 1,
					1f / (new Random().nextFloat() * 0.5f + 1));
			return entityarrow;
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class PoisonKunaiBulletItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:poison_kunai_bullet")
		public static final Item block = null;
		public static final EntityType arrow = (EntityType.Builder.<ArrowCustomEntity>create(ArrowCustomEntity::new, EntityClassification.MISC)
				.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).setCustomClientFactory(ArrowCustomEntity::new)
				.size(0.5f, 0.5f)).build("projectile_poison_kunai_bullet").setRegistryName("projectile_poison_kunai_bullet");

		public PoisonKunaiBulletItem(NarutoShippudenModElements instance) {
			super(instance, 1325);
			FMLJavaModLoadingContext.get().getModEventBus().register(new PoisonKunaiBulletRenderer.ModelRegisterHandler());
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemRanged());
			elements.entities.add(() -> arrow);
		}

		public static class ItemRanged extends Item {
			public ItemRanged() {
				super(new Item.Properties().group(null).maxStackSize(0));
				setRegistryName("poison_kunai_bullet");
			}

			@Override
			public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
				entity.setActiveHand(hand);
				return new ActionResult(ActionResultType.SUCCESS, entity.getHeldItem(hand));
			}

			@Override
			public UseAction getUseAction(ItemStack itemstack) {
				return UseAction.NONE;
			}

			@Override
			public int getUseDuration(ItemStack itemstack) {
				return 72000;
			}

			@Override
			public void onPlayerStoppedUsing(ItemStack itemstack, World world, LivingEntity entityLiving, int timeLeft) {
				if (!world.isRemote && entityLiving instanceof ServerPlayerEntity) {
					ServerPlayerEntity entity = (ServerPlayerEntity) entityLiving;
					double x = entity.getPosX();
					double y = entity.getPosY();
					double z = entity.getPosZ();
					if (true) {
						ArrowCustomEntity entityarrow = shoot(world, entity, random, 2f, 0, 0);
						itemstack.damageItem(1, entity, e -> e.sendBreakAnimation(entity.getActiveHand()));
						entityarrow.pickupStatus = AbstractArrowEntity.PickupStatus.DISALLOWED;
					}
				}
			}
		}

		@OnlyIn(value = Dist.CLIENT, _interface = IRendersAsItem.class)
		public static class ArrowCustomEntity extends AbstractArrowEntity implements IRendersAsItem {
			public ArrowCustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
				super(arrow, world);
			}

			public ArrowCustomEntity(EntityType<? extends ArrowCustomEntity> type, World world) {
				super(type, world);
			}

			public ArrowCustomEntity(EntityType<? extends ArrowCustomEntity> type, double x, double y, double z, World world) {
				super(type, x, y, z, world);
			}

			public ArrowCustomEntity(EntityType<? extends ArrowCustomEntity> type, LivingEntity entity, World world) {
				super(type, entity, world);
			}

			@Override
			public IPacket<?> createSpawnPacket() {
				return NetworkHooks.getEntitySpawningPacket(this);
			}

			@Override
			@OnlyIn(Dist.CLIENT)
			public ItemStack getItem() {
				return ItemStack.EMPTY;
			}

			@Override
			protected ItemStack getArrowStack() {
				return ItemStack.EMPTY;
			}

			@Override
			protected void arrowHit(LivingEntity entity) {
				super.arrowHit(entity);
				entity.setArrowCountInEntity(entity.getArrowCountInEntity() - 1);
			}

			@Override
			public void onEntityHit(EntityRayTraceResult entityRayTraceResult) {
				super.onEntityHit(entityRayTraceResult);
				Entity entity = entityRayTraceResult.getEntity();
				Entity sourceentity = this.func_234616_v_();
				Entity immediatesourceentity = this;
				double x = this.getPosX();
				double y = this.getPosY();
				double z = this.getPosZ();
				World world = this.world;

				PoisonKunaiBulletProjectileHitsLivingEntityProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}

			@Override
			public void func_230299_a_(BlockRayTraceResult blockRayTraceResult) {
				super.func_230299_a_(blockRayTraceResult);
				double x = blockRayTraceResult.getPos().getX();
				double y = blockRayTraceResult.getPos().getY();
				double z = blockRayTraceResult.getPos().getZ();
				World world = this.world;
				Entity entity = this.func_234616_v_();
				Entity immediatesourceentity = this;

				PoisonKunaiBulletProjectileHitsBlockProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}

			@Override
			public void tick() {
				super.tick();
				double x = this.getPosX();
				double y = this.getPosY();
				double z = this.getPosZ();
				World world = this.world;
				Entity entity = this.func_234616_v_();
				Entity immediatesourceentity = this;
				if (this.inGround)
					this.remove();
			}
		}

		public static ArrowCustomEntity shoot(World world, LivingEntity entity, Random random, float power, double damage, int knockback) {
			ArrowCustomEntity entityarrow = new ArrowCustomEntity(arrow, entity, world);
			entityarrow.shoot(entity.getLook(1).x, entity.getLook(1).y, entity.getLook(1).z, power * 2, 0);
			entityarrow.setSilent(true);
			entityarrow.setIsCritical(false);
			entityarrow.setDamage(damage);
			entityarrow.setKnockbackStrength(knockback);
			world.addEntity(entityarrow);
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			world.playSound((PlayerEntity) null, (double) x, (double) y, (double) z,
					(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("")), SoundCategory.PLAYERS, 1,
					1f / (random.nextFloat() * 0.5f + 1) + (power / 2));
			return entityarrow;
		}

		public static ArrowCustomEntity shoot(LivingEntity entity, LivingEntity target) {
			ArrowCustomEntity entityarrow = new ArrowCustomEntity(arrow, entity, entity.world);
			double d0 = target.getPosY() + (double) target.getEyeHeight() - 1.1;
			double d1 = target.getPosX() - entity.getPosX();
			double d3 = target.getPosZ() - entity.getPosZ();
			entityarrow.shoot(d1, d0 - entityarrow.getPosY() + (double) MathHelper.sqrt(d1 * d1 + d3 * d3) * 0.2F, d3, 2f * 2, 12.0F);
			entityarrow.setSilent(true);
			entityarrow.setDamage(0);
			entityarrow.setKnockbackStrength(0);
			entityarrow.setIsCritical(false);
			entity.world.addEntity(entityarrow);
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			entity.world.playSound((PlayerEntity) null, (double) x, (double) y, (double) z,
					(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("")), SoundCategory.PLAYERS, 1,
					1f / (new Random().nextFloat() * 0.5f + 1));
			return entityarrow;
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class ShurikenBulletItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:shuriken_bullet")
		public static final Item block = null;
		public static final EntityType arrow = (EntityType.Builder.<ArrowCustomEntity>create(ArrowCustomEntity::new, EntityClassification.MISC)
				.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).setCustomClientFactory(ArrowCustomEntity::new)
				.size(0.5f, 0.5f)).build("projectile_shuriken_bullet").setRegistryName("projectile_shuriken_bullet");

		public ShurikenBulletItem(NarutoShippudenModElements instance) {
			super(instance, 968);
			FMLJavaModLoadingContext.get().getModEventBus().register(new ShurikenBulletRenderer.ModelRegisterHandler());
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemRanged());
			elements.entities.add(() -> arrow);
		}

		public static class ItemRanged extends Item {
			public ItemRanged() {
				super(new Item.Properties().group(null).maxStackSize(0));
				setRegistryName("shuriken_bullet");
			}

			@Override
			public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
				entity.setActiveHand(hand);
				return new ActionResult(ActionResultType.SUCCESS, entity.getHeldItem(hand));
			}

			@Override
			public UseAction getUseAction(ItemStack itemstack) {
				return UseAction.NONE;
			}

			@Override
			public int getUseDuration(ItemStack itemstack) {
				return 72000;
			}

			@Override
			public void onPlayerStoppedUsing(ItemStack itemstack, World world, LivingEntity entityLiving, int timeLeft) {
				if (!world.isRemote && entityLiving instanceof ServerPlayerEntity) {
					ServerPlayerEntity entity = (ServerPlayerEntity) entityLiving;
					double x = entity.getPosX();
					double y = entity.getPosY();
					double z = entity.getPosZ();
					if (true) {
						ArrowCustomEntity entityarrow = shoot(world, entity, random, 2f, 0, 0);
						itemstack.damageItem(1, entity, e -> e.sendBreakAnimation(entity.getActiveHand()));
						entityarrow.pickupStatus = AbstractArrowEntity.PickupStatus.DISALLOWED;
					}
				}
			}
		}

		@OnlyIn(value = Dist.CLIENT, _interface = IRendersAsItem.class)
		public static class ArrowCustomEntity extends AbstractArrowEntity implements IRendersAsItem {
			public ArrowCustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
				super(arrow, world);
			}

			public ArrowCustomEntity(EntityType<? extends ArrowCustomEntity> type, World world) {
				super(type, world);
			}

			public ArrowCustomEntity(EntityType<? extends ArrowCustomEntity> type, double x, double y, double z, World world) {
				super(type, x, y, z, world);
			}

			public ArrowCustomEntity(EntityType<? extends ArrowCustomEntity> type, LivingEntity entity, World world) {
				super(type, entity, world);
			}

			@Override
			public IPacket<?> createSpawnPacket() {
				return NetworkHooks.getEntitySpawningPacket(this);
			}

			@Override
			@OnlyIn(Dist.CLIENT)
			public ItemStack getItem() {
				return ItemStack.EMPTY;
			}

			@Override
			protected ItemStack getArrowStack() {
				return ItemStack.EMPTY;
			}

			@Override
			protected void arrowHit(LivingEntity entity) {
				super.arrowHit(entity);
				entity.setArrowCountInEntity(entity.getArrowCountInEntity() - 1);
			}

			@Override
			public void func_230299_a_(BlockRayTraceResult blockRayTraceResult) {
				super.func_230299_a_(blockRayTraceResult);
				double x = blockRayTraceResult.getPos().getX();
				double y = blockRayTraceResult.getPos().getY();
				double z = blockRayTraceResult.getPos().getZ();
				World world = this.world;
				Entity entity = this.func_234616_v_();
				Entity immediatesourceentity = this;

				ShurikenBulletProjectileHitsBlockProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}

			@Override
			public void tick() {
				super.tick();
				double x = this.getPosX();
				double y = this.getPosY();
				double z = this.getPosZ();
				World world = this.world;
				Entity entity = this.func_234616_v_();
				Entity immediatesourceentity = this;
				if (this.inGround)
					this.remove();
			}
		}

		public static ArrowCustomEntity shoot(World world, LivingEntity entity, Random random, float power, double damage, int knockback) {
			ArrowCustomEntity entityarrow = new ArrowCustomEntity(arrow, entity, world);
			entityarrow.shoot(entity.getLook(1).x, entity.getLook(1).y, entity.getLook(1).z, power * 2, 0);
			entityarrow.setSilent(true);
			entityarrow.setIsCritical(false);
			entityarrow.setDamage(damage);
			entityarrow.setKnockbackStrength(knockback);
			world.addEntity(entityarrow);
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			world.playSound((PlayerEntity) null, (double) x, (double) y, (double) z,
					(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("")), SoundCategory.PLAYERS, 1,
					1f / (random.nextFloat() * 0.5f + 1) + (power / 2));
			return entityarrow;
		}

		public static ArrowCustomEntity shoot(LivingEntity entity, LivingEntity target) {
			ArrowCustomEntity entityarrow = new ArrowCustomEntity(arrow, entity, entity.world);
			double d0 = target.getPosY() + (double) target.getEyeHeight() - 1.1;
			double d1 = target.getPosX() - entity.getPosX();
			double d3 = target.getPosZ() - entity.getPosZ();
			entityarrow.shoot(d1, d0 - entityarrow.getPosY() + (double) MathHelper.sqrt(d1 * d1 + d3 * d3) * 0.2F, d3, 2f * 2, 12.0F);
			entityarrow.setSilent(true);
			entityarrow.setDamage(0);
			entityarrow.setKnockbackStrength(0);
			entityarrow.setIsCritical(false);
			entity.world.addEntity(entityarrow);
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			entity.world.playSound((PlayerEntity) null, (double) x, (double) y, (double) z,
					(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("")), SoundCategory.PLAYERS, 1,
					1f / (new Random().nextFloat() * 0.5f + 1));
			return entityarrow;
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class ToroiUniqueFumaShurikenBulletItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:toroi_unique_fuma_shuriken_bullet")
		public static final Item block = null;
		public static final EntityType arrow = (EntityType.Builder.<ArrowCustomEntity>create(ArrowCustomEntity::new, EntityClassification.MISC)
				.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).setCustomClientFactory(ArrowCustomEntity::new)
				.size(0.5f, 0.5f)).build("projectile_toroi_unique_fuma_shuriken_bullet").setRegistryName("projectile_toroi_unique_fuma_shuriken_bullet");

		public ToroiUniqueFumaShurikenBulletItem(NarutoShippudenModElements instance) {
			super(instance, 979);
			FMLJavaModLoadingContext.get().getModEventBus().register(new ToroiUniqueFumaShurikenBulletRenderer.ModelRegisterHandler());
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemRanged());
			elements.entities.add(() -> arrow);
		}

		public static class ItemRanged extends Item {
			public ItemRanged() {
				super(new Item.Properties().group(null).maxStackSize(0));
				setRegistryName("toroi_unique_fuma_shuriken_bullet");
			}

			@Override
			public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
				entity.setActiveHand(hand);
				return new ActionResult(ActionResultType.SUCCESS, entity.getHeldItem(hand));
			}

			@Override
			public UseAction getUseAction(ItemStack itemstack) {
				return UseAction.NONE;
			}

			@Override
			public int getUseDuration(ItemStack itemstack) {
				return 72000;
			}

			@Override
			public void onPlayerStoppedUsing(ItemStack itemstack, World world, LivingEntity entityLiving, int timeLeft) {
				if (!world.isRemote && entityLiving instanceof ServerPlayerEntity) {
					ServerPlayerEntity entity = (ServerPlayerEntity) entityLiving;
					double x = entity.getPosX();
					double y = entity.getPosY();
					double z = entity.getPosZ();
					if (true) {
						ArrowCustomEntity entityarrow = shoot(world, entity, random, 0f, 0, 0);
						itemstack.damageItem(1, entity, e -> e.sendBreakAnimation(entity.getActiveHand()));
						entityarrow.pickupStatus = AbstractArrowEntity.PickupStatus.DISALLOWED;
					}
				}
			}
		}

		@OnlyIn(value = Dist.CLIENT, _interface = IRendersAsItem.class)
		public static class ArrowCustomEntity extends AbstractArrowEntity implements IRendersAsItem {
			public ArrowCustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
				super(arrow, world);
			}

			public ArrowCustomEntity(EntityType<? extends ArrowCustomEntity> type, World world) {
				super(type, world);
			}

			public ArrowCustomEntity(EntityType<? extends ArrowCustomEntity> type, double x, double y, double z, World world) {
				super(type, x, y, z, world);
			}

			public ArrowCustomEntity(EntityType<? extends ArrowCustomEntity> type, LivingEntity entity, World world) {
				super(type, entity, world);
			}

			@Override
			public IPacket<?> createSpawnPacket() {
				return NetworkHooks.getEntitySpawningPacket(this);
			}

			@Override
			@OnlyIn(Dist.CLIENT)
			public ItemStack getItem() {
				return new ItemStack(ToroiUniqueFumaShurikenItem.block);
			}

			@Override
			protected ItemStack getArrowStack() {
				return ItemStack.EMPTY;
			}

			@Override
			protected void arrowHit(LivingEntity entity) {
				super.arrowHit(entity);
				entity.setArrowCountInEntity(entity.getArrowCountInEntity() - 1);
			}

			@Override
			public void func_230299_a_(BlockRayTraceResult blockRayTraceResult) {
				super.func_230299_a_(blockRayTraceResult);
				double x = blockRayTraceResult.getPos().getX();
				double y = blockRayTraceResult.getPos().getY();
				double z = blockRayTraceResult.getPos().getZ();
				World world = this.world;
				Entity entity = this.func_234616_v_();
				Entity immediatesourceentity = this;

				ToroiUniqueFumaShurikenBulletProjectileHitsBlockProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}

			@Override
			public void tick() {
				super.tick();
				double x = this.getPosX();
				double y = this.getPosY();
				double z = this.getPosZ();
				World world = this.world;
				Entity entity = this.func_234616_v_();
				Entity immediatesourceentity = this;
				if (this.inGround)
					this.remove();
			}
		}

		public static ArrowCustomEntity shoot(World world, LivingEntity entity, Random random, float power, double damage, int knockback) {
			ArrowCustomEntity entityarrow = new ArrowCustomEntity(arrow, entity, world);
			entityarrow.shoot(entity.getLook(1).x, entity.getLook(1).y, entity.getLook(1).z, power * 2, 0);
			entityarrow.setSilent(true);
			entityarrow.setIsCritical(false);
			entityarrow.setDamage(damage);
			entityarrow.setKnockbackStrength(knockback);
			world.addEntity(entityarrow);
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			world.playSound((PlayerEntity) null, (double) x, (double) y, (double) z,
					(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("")), SoundCategory.PLAYERS, 1,
					1f / (random.nextFloat() * 0.5f + 1) + (power / 2));
			return entityarrow;
		}

		public static ArrowCustomEntity shoot(LivingEntity entity, LivingEntity target) {
			ArrowCustomEntity entityarrow = new ArrowCustomEntity(arrow, entity, entity.world);
			double d0 = target.getPosY() + (double) target.getEyeHeight() - 1.1;
			double d1 = target.getPosX() - entity.getPosX();
			double d3 = target.getPosZ() - entity.getPosZ();
			entityarrow.shoot(d1, d0 - entityarrow.getPosY() + (double) MathHelper.sqrt(d1 * d1 + d3 * d3) * 0.2F, d3, 0f * 2, 12.0F);
			entityarrow.setSilent(true);
			entityarrow.setDamage(0);
			entityarrow.setKnockbackStrength(0);
			entityarrow.setIsCritical(false);
			entity.world.addEntity(entityarrow);
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			entity.world.playSound((PlayerEntity) null, (double) x, (double) y, (double) z,
					(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("")), SoundCategory.PLAYERS, 1,
					1f / (new Random().nextFloat() * 0.5f + 1));
			return entityarrow;
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class WaterSharkBulletItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:water_shark_bullet")
		public static final Item block = null;
		public static final EntityType arrow = (EntityType.Builder.<ArrowCustomEntity>create(ArrowCustomEntity::new, EntityClassification.MISC)
				.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).setCustomClientFactory(ArrowCustomEntity::new)
				.size(2f, 2f)).build("projectile_water_shark_bullet").setRegistryName("projectile_water_shark_bullet");

		public WaterSharkBulletItem(NarutoShippudenModElements instance) {
			super(instance, 77);
			FMLJavaModLoadingContext.get().getModEventBus().register(new WaterSharkBulletRenderer.ModelRegisterHandler());
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemRanged());
			elements.entities.add(() -> arrow);
		}

		public static class ItemRanged extends Item {
			public ItemRanged() {
				super(new Item.Properties().group(null).maxStackSize(0));
				setRegistryName("water_shark_bullet");
			}

			@Override
			public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
				entity.setActiveHand(hand);
				return new ActionResult(ActionResultType.SUCCESS, entity.getHeldItem(hand));
			}

			@Override
			public UseAction getUseAction(ItemStack itemstack) {
				return UseAction.NONE;
			}

			@Override
			public int getUseDuration(ItemStack itemstack) {
				return 72000;
			}

			@Override
			public void onPlayerStoppedUsing(ItemStack itemstack, World world, LivingEntity entityLiving, int timeLeft) {
				if (!world.isRemote && entityLiving instanceof ServerPlayerEntity) {
					ServerPlayerEntity entity = (ServerPlayerEntity) entityLiving;
					double x = entity.getPosX();
					double y = entity.getPosY();
					double z = entity.getPosZ();
					if (true) {
						ArrowCustomEntity entityarrow = shoot(world, entity, random, 1f, 10, 1);
						itemstack.damageItem(1, entity, e -> e.sendBreakAnimation(entity.getActiveHand()));
						entityarrow.pickupStatus = AbstractArrowEntity.PickupStatus.DISALLOWED;
					}
				}
			}
		}

		@OnlyIn(value = Dist.CLIENT, _interface = IRendersAsItem.class)
		public static class ArrowCustomEntity extends AbstractArrowEntity implements IRendersAsItem {
			public ArrowCustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
				super(arrow, world);
			}

			public ArrowCustomEntity(EntityType<? extends ArrowCustomEntity> type, World world) {
				super(type, world);
			}

			public ArrowCustomEntity(EntityType<? extends ArrowCustomEntity> type, double x, double y, double z, World world) {
				super(type, x, y, z, world);
			}

			public ArrowCustomEntity(EntityType<? extends ArrowCustomEntity> type, LivingEntity entity, World world) {
				super(type, entity, world);
			}

			@Override
			public IPacket<?> createSpawnPacket() {
				return NetworkHooks.getEntitySpawningPacket(this);
			}

			@Override
			@OnlyIn(Dist.CLIENT)
			public ItemStack getItem() {
				return ItemStack.EMPTY;
			}

			@Override
			protected ItemStack getArrowStack() {
				return ItemStack.EMPTY;
			}

			@Override
			protected void arrowHit(LivingEntity entity) {
				super.arrowHit(entity);
				entity.setArrowCountInEntity(entity.getArrowCountInEntity() - 1);
			}

			@Override
			public void tick() {
				super.tick();
				double x = this.getPosX();
				double y = this.getPosY();
				double z = this.getPosZ();
				World world = this.world;
				Entity entity = this.func_234616_v_();
				Entity immediatesourceentity = this;

				GreatFireballWhileProjectileFlyingTickProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("immediatesourceentity", immediatesourceentity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				if (this.inGround)
					this.remove();
			}
		}

		public static ArrowCustomEntity shoot(World world, LivingEntity entity, Random random, float power, double damage, int knockback) {
			ArrowCustomEntity entityarrow = new ArrowCustomEntity(arrow, entity, world);
			entityarrow.shoot(entity.getLook(1).x, entity.getLook(1).y, entity.getLook(1).z, power * 2, 0);
			entityarrow.setSilent(true);
			entityarrow.setIsCritical(false);
			entityarrow.setDamage(damage);
			entityarrow.setKnockbackStrength(knockback);
			world.addEntity(entityarrow);
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			world.playSound((PlayerEntity) null, (double) x, (double) y, (double) z,
					(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("")), SoundCategory.PLAYERS, 1,
					1f / (random.nextFloat() * 0.5f + 1) + (power / 2));
			return entityarrow;
		}

		public static ArrowCustomEntity shoot(LivingEntity entity, LivingEntity target) {
			ArrowCustomEntity entityarrow = new ArrowCustomEntity(arrow, entity, entity.world);
			double d0 = target.getPosY() + (double) target.getEyeHeight() - 1.1;
			double d1 = target.getPosX() - entity.getPosX();
			double d3 = target.getPosZ() - entity.getPosZ();
			entityarrow.shoot(d1, d0 - entityarrow.getPosY() + (double) MathHelper.sqrt(d1 * d1 + d3 * d3) * 0.2F, d3, 1f * 2, 12.0F);
			entityarrow.setSilent(true);
			entityarrow.setDamage(10);
			entityarrow.setKnockbackStrength(1);
			entityarrow.setIsCritical(false);
			entity.world.addEntity(entityarrow);
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			entity.world.playSound((PlayerEntity) null, (double) x, (double) y, (double) z,
					(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("")), SoundCategory.PLAYERS, 1,
					1f / (new Random().nextFloat() * 0.5f + 1));
			return entityarrow;
		}
	}
}
