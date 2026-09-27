package net.mcreator.narutoshippudenmod.item;

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
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.IRendersAsItem;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.item.SwordItem;
import net.minecraft.item.UseAction;
import net.minecraft.item.crafting.Ingredient;
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

public final class JutsuProjectileItems {
	private JutsuProjectileItems() {
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class AmaterasuFlameItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:amaterasu_flame")
		public static final Item block = null;
		public static final EntityType arrow = (EntityType.Builder.<ArrowCustomEntity>create(ArrowCustomEntity::new, EntityClassification.MISC)
				.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).setCustomClientFactory(ArrowCustomEntity::new)
				.size(0.5f, 0.5f)).build("projectile_amaterasu_flame").setRegistryName("projectile_amaterasu_flame");

		public AmaterasuFlameItem(NarutoShippudenModElements instance) {
			super(instance, 1213);
			FMLJavaModLoadingContext.get().getModEventBus().register(new AmaterasuFlameRenderer.ModelRegisterHandler());
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemRanged());
			elements.entities.add(() -> arrow);
		}

		public static class ItemRanged extends Item {
			public ItemRanged() {
				super(new Item.Properties().group(null).maxStackSize(0));
				setRegistryName("amaterasu_flame");
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
						ArrowCustomEntity entityarrow = shoot(world, entity, random, 12f, 1, 0);
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

				AmaterasuFlameProjectileHitsLivingEntityProcedure
						.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("entity", entity))
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

				AmaterasuFlameProjectileHitsBlockProcedure.executeProcedure(Stream
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
			entityarrow.shoot(d1, d0 - entityarrow.getPosY() + (double) MathHelper.sqrt(d1 * d1 + d3 * d3) * 0.2F, d3, 12f * 2, 12.0F);
			entityarrow.setSilent(true);
			entityarrow.setDamage(1);
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
	public static class BlackIceDragonItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:black_ice_dragon")
		public static final Item block = null;
		public static final EntityType arrow = (EntityType.Builder.<ArrowCustomEntity>create(ArrowCustomEntity::new, EntityClassification.MISC)
				.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).setCustomClientFactory(ArrowCustomEntity::new)
				.size(3f, 3f)).build("projectile_black_ice_dragon").setRegistryName("projectile_black_ice_dragon");

		public BlackIceDragonItem(NarutoShippudenModElements instance) {
			super(instance, 809);
			FMLJavaModLoadingContext.get().getModEventBus().register(new BlackIceDragonRenderer.ModelRegisterHandler());
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemRanged());
			elements.entities.add(() -> arrow);
		}

		public static class ItemRanged extends Item {
			public ItemRanged() {
				super(new Item.Properties().group(null).maxStackSize(0));
				setRegistryName("black_ice_dragon");
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
			public void onEntityHit(EntityRayTraceResult entityRayTraceResult) {
				super.onEntityHit(entityRayTraceResult);
				Entity entity = entityRayTraceResult.getEntity();
				Entity sourceentity = this.func_234616_v_();
				Entity immediatesourceentity = this;
				double x = this.getPosX();
				double y = this.getPosY();
				double z = this.getPosZ();
				World world = this.world;

				BlackIceDragonProjectileHitsLivingEntityProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
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
	public static class BladeOfLightningItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:blade_of_lightning")
		public static final Item block = null;

		public BladeOfLightningItem(NarutoShippudenModElements instance) {
			super(instance, 670);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new SwordItem(new IItemTier() {
				public int getMaxUses() {
					return 1;
				}

				public float getEfficiency() {
					return 0f;
				}

				public float getAttackDamage() {
					return 36f;
				}

				public int getHarvestLevel() {
					return 0;
				}

				public int getEnchantability() {
					return 0;
				}

				public Ingredient getRepairMaterial() {
					return Ingredient.EMPTY;
				}
			}, 3, -3f, new Item.Properties().group(null)) {
			}.setRegistryName("blade_of_lightning"));
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class ChidoriSenbonItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:chidori_senbon")
		public static final Item block = null;
		public static final EntityType arrow = (EntityType.Builder.<ArrowCustomEntity>create(ArrowCustomEntity::new, EntityClassification.MISC)
				.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).setCustomClientFactory(ArrowCustomEntity::new)
				.size(5.5f, 5.5f)).build("projectile_chidori_senbon").setRegistryName("projectile_chidori_senbon");

		public ChidoriSenbonItem(NarutoShippudenModElements instance) {
			super(instance, 91);
			FMLJavaModLoadingContext.get().getModEventBus().register(new ChidoriSenbonRenderer.ModelRegisterHandler());
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemRanged());
			elements.entities.add(() -> arrow);
		}

		public static class ItemRanged extends Item {
			public ItemRanged() {
				super(new Item.Properties().group(null).maxStackSize(0));
				setRegistryName("chidori_senbon");
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
				if (this.inGround) {
					this.remove();
				}
			}
		}

		public static ArrowCustomEntity shoot(World world, LivingEntity entity, Random random, float power, double damage, int knockback) {
			ArrowCustomEntity entityarrow = new ArrowCustomEntity(arrow, entity, world);
			entityarrow.shoot(entity.getLook(1).x, entity.getLook(1).y, entity.getLook(1).z, power * 2, 0);
			entityarrow.setSilent(true);
			entityarrow.setIsCritical(false);
			entityarrow.setDamage(damage);
			entityarrow.setKnockbackStrength(knockback);
			entityarrow.setNoGravity(true);
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
			entityarrow.setDamage(10);
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
	public static class DemonicIllusionShacklingStakesTechniqueItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:demonic_illusion_shackling_stakes_technique")
		public static final Item block = null;
		public static final EntityType arrow = (EntityType.Builder.<ArrowCustomEntity>create(ArrowCustomEntity::new, EntityClassification.MISC)
				.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).setCustomClientFactory(ArrowCustomEntity::new)
				.size(0.5f, 0.5f)).build("projectile_demonic_illusion_shackling_stakes_technique")
				.setRegistryName("projectile_demonic_illusion_shackling_stakes_technique");

		public DemonicIllusionShacklingStakesTechniqueItem(NarutoShippudenModElements instance) {
			super(instance, 433);
			FMLJavaModLoadingContext.get().getModEventBus().register(new DemonicIllusionShacklingStakesTechniqueRenderer.ModelRegisterHandler());
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemRanged());
			elements.entities.add(() -> arrow);
		}

		public static class ItemRanged extends Item {
			public ItemRanged() {
				super(new Item.Properties().group(null).maxStackSize(0));
				setRegistryName("demonic_illusion_shackling_stakes_technique");
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
						ArrowCustomEntity entityarrow = shoot(world, entity, random, 4f, 1, 0);
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

				DemonicIllusionShacklingStakesTechniqueProjectileHitsLivingEntityProcedure.executeProcedure(Stream
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
			entityarrow.shoot(d1, d0 - entityarrow.getPosY() + (double) MathHelper.sqrt(d1 * d1 + d3 * d3) * 0.2F, d3, 4f * 2, 12.0F);
			entityarrow.setSilent(true);
			entityarrow.setDamage(1);
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
	public static class DrowningWaterBlobTechniqueItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:drowning_water_blob_technique")
		public static final Item block = null;
		public static final EntityType arrow = (EntityType.Builder.<ArrowCustomEntity>create(ArrowCustomEntity::new, EntityClassification.MISC)
				.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).setCustomClientFactory(ArrowCustomEntity::new)
				.size(0.5f, 0.5f)).build("projectile_drowning_water_blob_technique").setRegistryName("projectile_drowning_water_blob_technique");

		public DrowningWaterBlobTechniqueItem(NarutoShippudenModElements instance) {
			super(instance, 945);
			FMLJavaModLoadingContext.get().getModEventBus().register(new DrowningWaterBlobTechniqueRenderer.ModelRegisterHandler());
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemRanged());
			elements.entities.add(() -> arrow);
		}

		public static class ItemRanged extends Item {
			public ItemRanged() {
				super(new Item.Properties().group(null).maxStackSize(0));
				setRegistryName("drowning_water_blob_technique");
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
						ArrowCustomEntity entityarrow = shoot(world, entity, random, 12f, 1, 0);
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

				DrowningWaterBlobTechniqueProjectileHitsLivingEntityProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
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
			entityarrow.shoot(d1, d0 - entityarrow.getPosY() + (double) MathHelper.sqrt(d1 * d1 + d3 * d3) * 0.2F, d3, 12f * 2, 12.0F);
			entityarrow.setSilent(true);
			entityarrow.setDamage(1);
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
	public static class EarthBallItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:earth_ball")
		public static final Item block = null;
		public static final EntityType arrow = (EntityType.Builder.<ArrowCustomEntity>create(ArrowCustomEntity::new, EntityClassification.MISC)
				.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).setCustomClientFactory(ArrowCustomEntity::new)
				.size(3f, 3f)).build("projectile_earth_ball").setRegistryName("projectile_earth_ball");

		public EarthBallItem(NarutoShippudenModElements instance) {
			super(instance, 506);
			FMLJavaModLoadingContext.get().getModEventBus().register(new EarthBallRenderer.ModelRegisterHandler());
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemRanged());
			elements.entities.add(() -> arrow);
		}

		public static class ItemRanged extends Item {
			public ItemRanged() {
				super(new Item.Properties().group(null).maxStackSize(0));
				setRegistryName("earth_ball");
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
						ArrowCustomEntity entityarrow = shoot(world, entity, random, 1f, 20, 0);
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
				if (this.inGround) {
					this.remove();
				}
			}
		}

		public static ArrowCustomEntity shoot(World world, LivingEntity entity, Random random, float power, double damage, int knockback) {
			ArrowCustomEntity entityarrow = new ArrowCustomEntity(arrow, entity, world);
			entityarrow.shoot(entity.getLook(1).x, entity.getLook(1).y, entity.getLook(1).z, power * 2, 0);
			entityarrow.setSilent(true);
			entityarrow.setIsCritical(false);
			entityarrow.setDamage(damage);
			entityarrow.setKnockbackStrength(knockback);
			entityarrow.setNoGravity(true);
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
			entityarrow.setDamage(20);
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
	public static class EarthDiskItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:earth_disk")
		public static final Item block = null;
		public static final EntityType arrow = (EntityType.Builder.<ArrowCustomEntity>create(ArrowCustomEntity::new, EntityClassification.MISC)
				.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).setCustomClientFactory(ArrowCustomEntity::new)
				.size(2.5f, 2.5f)).build("projectile_earth_disk").setRegistryName("projectile_earth_disk");

		public EarthDiskItem(NarutoShippudenModElements instance) {
			super(instance, 504);
			FMLJavaModLoadingContext.get().getModEventBus().register(new EarthDiskRenderer.ModelRegisterHandler());
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemRanged());
			elements.entities.add(() -> arrow);
		}

		public static class ItemRanged extends Item {
			public ItemRanged() {
				super(new Item.Properties().group(null).maxStackSize(0));
				setRegistryName("earth_disk");
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
						ArrowCustomEntity entityarrow = shoot(world, entity, random, 1f, 20, 0);
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
				if (this.inGround) {
					this.remove();
				}
			}
		}

		public static ArrowCustomEntity shoot(World world, LivingEntity entity, Random random, float power, double damage, int knockback) {
			ArrowCustomEntity entityarrow = new ArrowCustomEntity(arrow, entity, world);
			entityarrow.shoot(entity.getLook(1).x, entity.getLook(1).y, entity.getLook(1).z, power * 2, 0);
			entityarrow.setSilent(true);
			entityarrow.setIsCritical(false);
			entityarrow.setDamage(damage);
			entityarrow.setKnockbackStrength(knockback);
			entityarrow.setNoGravity(true);
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
			entityarrow.setDamage(20);
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
	public static class EarthSpearItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:earth_spear")
		public static final Item block = null;
		public static final EntityType arrow = (EntityType.Builder.<ArrowCustomEntity>create(ArrowCustomEntity::new, EntityClassification.MISC)
				.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).setCustomClientFactory(ArrowCustomEntity::new)
				.size(1.5f, 1.5f)).build("projectile_earth_spear").setRegistryName("projectile_earth_spear");

		public EarthSpearItem(NarutoShippudenModElements instance) {
			super(instance, 98);
			FMLJavaModLoadingContext.get().getModEventBus().register(new EarthSpearRenderer.ModelRegisterHandler());
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemRanged());
			elements.entities.add(() -> arrow);
		}

		public static class ItemRanged extends Item {
			public ItemRanged() {
				super(new Item.Properties().group(null).maxStackSize(0));
				setRegistryName("earth_spear");
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
				if (this.inGround) {
					this.remove();
				}
			}
		}

		public static ArrowCustomEntity shoot(World world, LivingEntity entity, Random random, float power, double damage, int knockback) {
			ArrowCustomEntity entityarrow = new ArrowCustomEntity(arrow, entity, world);
			entityarrow.shoot(entity.getLook(1).x, entity.getLook(1).y, entity.getLook(1).z, power * 2, 0);
			entityarrow.setSilent(true);
			entityarrow.setIsCritical(false);
			entityarrow.setDamage(damage);
			entityarrow.setKnockbackStrength(knockback);
			entityarrow.setNoGravity(true);
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
	public static class EarthWaveItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:earth_wave")
		public static final Item block = null;
		public static final EntityType arrow = (EntityType.Builder.<ArrowCustomEntity>create(ArrowCustomEntity::new, EntityClassification.MISC)
				.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).setCustomClientFactory(ArrowCustomEntity::new)
				.size(0.5f, 0.5f)).build("projectile_earth_wave").setRegistryName("projectile_earth_wave");

		public EarthWaveItem(NarutoShippudenModElements instance) {
			super(instance, 505);
			FMLJavaModLoadingContext.get().getModEventBus().register(new EarthWaveRenderer.ModelRegisterHandler());
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemRanged());
			elements.entities.add(() -> arrow);
		}

		public static class ItemRanged extends Item {
			public ItemRanged() {
				super(new Item.Properties().group(null).maxStackSize(0));
				setRegistryName("earth_wave");
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
						ArrowCustomEntity entityarrow = shoot(world, entity, random, 1f, 20, 0);
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
			entityarrow.setDamage(20);
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
	public static class FireBallItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:fire_ball")
		public static final Item block = null;
		public static final EntityType arrow = (EntityType.Builder.<ArrowCustomEntity>create(ArrowCustomEntity::new, EntityClassification.MISC)
				.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).setCustomClientFactory(ArrowCustomEntity::new)
				.size(3f, 3f)).build("projectile_fire_ball").setRegistryName("projectile_fire_ball");

		public FireBallItem(NarutoShippudenModElements instance) {
			super(instance, 497);
			FMLJavaModLoadingContext.get().getModEventBus().register(new FireBallRenderer.ModelRegisterHandler());
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemRanged());
			elements.entities.add(() -> arrow);
		}

		public static class ItemRanged extends Item {
			public ItemRanged() {
				super(new Item.Properties().group(null).maxStackSize(0));
				setRegistryName("fire_ball");
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
						ArrowCustomEntity entityarrow = shoot(world, entity, random, 1f, 20, 0);
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
				if (this.inGround) {
					this.remove();
				}
			}
		}

		public static ArrowCustomEntity shoot(World world, LivingEntity entity, Random random, float power, double damage, int knockback) {
			ArrowCustomEntity entityarrow = new ArrowCustomEntity(arrow, entity, world);
			entityarrow.shoot(entity.getLook(1).x, entity.getLook(1).y, entity.getLook(1).z, power * 2, 0);
			entityarrow.setSilent(true);
			entityarrow.setIsCritical(false);
			entityarrow.setDamage(damage);
			entityarrow.setKnockbackStrength(knockback);
			entityarrow.setNoGravity(true);
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
			entityarrow.setDamage(20);
			entityarrow.setKnockbackStrength(0);
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
	public static class FireDiskItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:fire_disk")
		public static final Item block = null;
		public static final EntityType arrow = (EntityType.Builder.<ArrowCustomEntity>create(ArrowCustomEntity::new, EntityClassification.MISC)
				.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).setCustomClientFactory(ArrowCustomEntity::new)
				.size(2.5f, 2.5f)).build("projectile_fire_disk").setRegistryName("projectile_fire_disk");

		public FireDiskItem(NarutoShippudenModElements instance) {
			super(instance, 495);
			FMLJavaModLoadingContext.get().getModEventBus().register(new FireDiskRenderer.ModelRegisterHandler());
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemRanged());
			elements.entities.add(() -> arrow);
		}

		public static class ItemRanged extends Item {
			public ItemRanged() {
				super(new Item.Properties().group(null).maxStackSize(0));
				setRegistryName("fire_disk");
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
						ArrowCustomEntity entityarrow = shoot(world, entity, random, 1f, 20, 0);
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
				if (this.inGround) {
					this.remove();
				}
			}
		}

		public static ArrowCustomEntity shoot(World world, LivingEntity entity, Random random, float power, double damage, int knockback) {
			ArrowCustomEntity entityarrow = new ArrowCustomEntity(arrow, entity, world);
			entityarrow.shoot(entity.getLook(1).x, entity.getLook(1).y, entity.getLook(1).z, power * 2, 0);
			entityarrow.setSilent(true);
			entityarrow.setIsCritical(false);
			entityarrow.setDamage(damage);
			entityarrow.setKnockbackStrength(knockback);
			entityarrow.setNoGravity(true);
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
			entityarrow.setDamage(20);
			entityarrow.setKnockbackStrength(0);
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
	public static class FireWaveItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:fire_wave")
		public static final Item block = null;
		public static final EntityType arrow = (EntityType.Builder.<ArrowCustomEntity>create(ArrowCustomEntity::new, EntityClassification.MISC)
				.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).setCustomClientFactory(ArrowCustomEntity::new)
				.size(2.5f, 2.5f)).build("projectile_fire_wave").setRegistryName("projectile_fire_wave");

		public FireWaveItem(NarutoShippudenModElements instance) {
			super(instance, 496);
			FMLJavaModLoadingContext.get().getModEventBus().register(new FireWaveRenderer.ModelRegisterHandler());
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemRanged());
			elements.entities.add(() -> arrow);
		}

		public static class ItemRanged extends Item {
			public ItemRanged() {
				super(new Item.Properties().group(null).maxStackSize(0));
				setRegistryName("fire_wave");
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
						ArrowCustomEntity entityarrow = shoot(world, entity, random, 1f, 20, 0);
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
				if (this.inGround) {
					this.remove();
				}
			}
		}

		public static ArrowCustomEntity shoot(World world, LivingEntity entity, Random random, float power, double damage, int knockback) {
			ArrowCustomEntity entityarrow = new ArrowCustomEntity(arrow, entity, world);
			entityarrow.shoot(entity.getLook(1).x, entity.getLook(1).y, entity.getLook(1).z, power * 2, 0);
			entityarrow.setSilent(true);
			entityarrow.setIsCritical(false);
			entityarrow.setDamage(damage);
			entityarrow.setKnockbackStrength(knockback);
			entityarrow.setNoGravity(true);
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
			entityarrow.setDamage(20);
			entityarrow.setKnockbackStrength(0);
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
	public static class FistRockItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:fist_rock")
		public static final Item block = null;

		public FistRockItem(NarutoShippudenModElements instance) {
			super(instance, 94);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(new Item.Properties().group(null).maxStackSize(1).rarity(Rarity.COMMON));
				setRegistryName("fist_rock");
			}

			@Override
			public UseAction getUseAction(ItemStack itemstack) {
				return UseAction.EAT;
			}

			@Override
			public int getItemEnchantability() {
				return 0;
			}

			@Override
			public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
				return 1F;
			}

			@Override
			public boolean hitEntity(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
				boolean retval = super.hitEntity(itemstack, entity, sourceentity);
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();
				World world = entity.world;

				FistRockLivingEntityIsHitWithItemProcedure.executeProcedure(
						Stream.of(new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("sourceentity", sourceentity))
								.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return retval;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class FurykickItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:furykick")
		public static final Item block = null;
		public static final EntityType arrow = (EntityType.Builder.<ArrowCustomEntity>create(ArrowCustomEntity::new, EntityClassification.MISC)
				.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).setCustomClientFactory(ArrowCustomEntity::new)
				.size(0.5f, 0.5f)).build("projectile_furykick").setRegistryName("projectile_furykick");

		public FurykickItem(NarutoShippudenModElements instance) {
			super(instance, 836);
			FMLJavaModLoadingContext.get().getModEventBus().register(new FurykickRenderer.ModelRegisterHandler());
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemRanged());
			elements.entities.add(() -> arrow);
		}

		public static class ItemRanged extends Item {
			public ItemRanged() {
				super(new Item.Properties().group(null).maxStackSize(0));
				setRegistryName("furykick");
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
						ArrowCustomEntity entityarrow = shoot(world, entity, random, 12f, 1, 0);
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
			entityarrow.shoot(d1, d0 - entityarrow.getPosY() + (double) MathHelper.sqrt(d1 * d1 + d3 * d3) * 0.2F, d3, 12f * 2, 12.0F);
			entityarrow.setSilent(true);
			entityarrow.setDamage(1);
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
	public static class GreatFireDragonItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:great_fire_dragon")
		public static final Item block = null;
		public static final EntityType arrow = (EntityType.Builder.<ArrowCustomEntity>create(ArrowCustomEntity::new, EntityClassification.MISC)
				.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).setCustomClientFactory(ArrowCustomEntity::new)
				.size(3f, 3f)).build("projectile_great_fire_dragon").setRegistryName("projectile_great_fire_dragon");

		public GreatFireDragonItem(NarutoShippudenModElements instance) {
			super(instance, 67);
			FMLJavaModLoadingContext.get().getModEventBus().register(new GreatFireDragonRenderer.ModelRegisterHandler());
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemRanged());
			elements.entities.add(() -> arrow);
		}

		public static class ItemRanged extends Item {
			public ItemRanged() {
				super(new Item.Properties().group(null).maxStackSize(0));
				setRegistryName("great_fire_dragon");
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
			entityarrow.setDamage(10);
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
	public static class GreatFireballItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:great_fireball")
		public static final Item block = null;
		public static final EntityType arrow = (EntityType.Builder.<ArrowCustomEntity>create(ArrowCustomEntity::new, EntityClassification.MISC)
				.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).setCustomClientFactory(ArrowCustomEntity::new)
				.size(3f, 3f)).build("projectile_great_fireball").setRegistryName("projectile_great_fireball");

		public GreatFireballItem(NarutoShippudenModElements instance) {
			super(instance, 47);
			FMLJavaModLoadingContext.get().getModEventBus().register(new GreatFireballRenderer.ModelRegisterHandler());
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemRanged());
			elements.entities.add(() -> arrow);
		}

		public static class ItemRanged extends Item {
			public ItemRanged() {
				super(new Item.Properties().group(null).maxStackSize(0));
				setRegistryName("great_fireball");
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
			entityarrow.setDamage(10);
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
	public static class InsectBogItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:insect_bog")
		public static final Item block = null;
		public static final EntityType arrow = (EntityType.Builder.<ArrowCustomEntity>create(ArrowCustomEntity::new, EntityClassification.MISC)
				.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).setCustomClientFactory(ArrowCustomEntity::new)
				.size(3f, 3f)).build("projectile_insect_bog").setRegistryName("projectile_insect_bog");

		public InsectBogItem(NarutoShippudenModElements instance) {
			super(instance, 933);
			FMLJavaModLoadingContext.get().getModEventBus().register(new InsectBogRenderer.ModelRegisterHandler());
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemRanged());
			elements.entities.add(() -> arrow);
		}

		public static class ItemRanged extends Item {
			public ItemRanged() {
				super(new Item.Properties().group(null).maxStackSize(0));
				setRegistryName("insect_bog");
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
						ArrowCustomEntity entityarrow = shoot(world, entity, random, 1f, 13, 1);
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

				InsectBogProjectileHitsLivingEntityProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
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
			entityarrow.shoot(d1, d0 - entityarrow.getPosY() + (double) MathHelper.sqrt(d1 * d1 + d3 * d3) * 0.2F, d3, 1f * 2, 12.0F);
			entityarrow.setSilent(true);
			entityarrow.setDamage(13);
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
	public static class LaserCircusItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:laser_circus")
		public static final Item block = null;
		public static final EntityType arrow = (EntityType.Builder.<ArrowCustomEntity>create(ArrowCustomEntity::new, EntityClassification.MISC)
				.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).setCustomClientFactory(ArrowCustomEntity::new)
				.size(2.5f, 2.5f)).build("projectile_laser_circus").setRegistryName("projectile_laser_circus");

		public LaserCircusItem(NarutoShippudenModElements instance) {
			super(instance, 749);
			FMLJavaModLoadingContext.get().getModEventBus().register(new LaserCircusRenderer.ModelRegisterHandler());
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemRanged());
			elements.entities.add(() -> arrow);
		}

		public static class ItemRanged extends Item {
			public ItemRanged() {
				super(new Item.Properties().group(null).maxStackSize(0));
				setRegistryName("laser_circus");
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
						ArrowCustomEntity entityarrow = shoot(world, entity, random, 1f, 1, 0);
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

				LaserCircusProjectileHitsLivingEntityProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
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

				LaserCircusWhileProjectileFlyingTickProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z), new AbstractMap.SimpleEntry<>("immediatesourceentity", immediatesourceentity))
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
			entityarrow.setDamage(1);
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
	public static class LightningBallCustomItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:lightning_ball_custom")
		public static final Item block = null;
		public static final EntityType arrow = (EntityType.Builder.<ArrowCustomEntity>create(ArrowCustomEntity::new, EntityClassification.MISC)
				.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).setCustomClientFactory(ArrowCustomEntity::new)
				.size(3f, 3f)).build("projectile_lightning_ball_custom").setRegistryName("projectile_lightning_ball_custom");

		public LightningBallCustomItem(NarutoShippudenModElements instance) {
			super(instance, 509);
			FMLJavaModLoadingContext.get().getModEventBus().register(new LightningBallCustomRenderer.ModelRegisterHandler());
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemRanged());
			elements.entities.add(() -> arrow);
		}

		public static class ItemRanged extends Item {
			public ItemRanged() {
				super(new Item.Properties().group(null).maxStackSize(0));
				setRegistryName("lightning_ball_custom");
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
						ArrowCustomEntity entityarrow = shoot(world, entity, random, 1f, 20, 0);
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
				if (this.inGround) {
					this.remove();
				}
			}
		}

		public static ArrowCustomEntity shoot(World world, LivingEntity entity, Random random, float power, double damage, int knockback) {
			ArrowCustomEntity entityarrow = new ArrowCustomEntity(arrow, entity, world);
			entityarrow.shoot(entity.getLook(1).x, entity.getLook(1).y, entity.getLook(1).z, power * 2, 0);
			entityarrow.setSilent(true);
			entityarrow.setIsCritical(false);
			entityarrow.setDamage(damage);
			entityarrow.setKnockbackStrength(knockback);
			entityarrow.setNoGravity(true);
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
			entityarrow.setDamage(20);
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
	public static class LightningBallItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:lightning_ball")
		public static final Item block = null;
		public static final EntityType arrow = (EntityType.Builder.<ArrowCustomEntity>create(ArrowCustomEntity::new, EntityClassification.MISC)
				.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).setCustomClientFactory(ArrowCustomEntity::new)
				.size(3f, 3f)).build("projectile_lightning_ball").setRegistryName("projectile_lightning_ball");

		public LightningBallItem(NarutoShippudenModElements instance) {
			super(instance, 93);
			FMLJavaModLoadingContext.get().getModEventBus().register(new LightningBallRenderer.ModelRegisterHandler());
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemRanged());
			elements.entities.add(() -> arrow);
		}

		public static class ItemRanged extends Item {
			public ItemRanged() {
				super(new Item.Properties().group(null).maxStackSize(0));
				setRegistryName("lightning_ball");
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
			entityarrow.setDamage(10);
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
	public static class LightningDiskItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:lightning_disk")
		public static final Item block = null;
		public static final EntityType arrow = (EntityType.Builder.<ArrowCustomEntity>create(ArrowCustomEntity::new, EntityClassification.MISC)
				.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).setCustomClientFactory(ArrowCustomEntity::new)
				.size(2.5f, 2.5f)).build("projectile_lightning_disk").setRegistryName("projectile_lightning_disk");

		public LightningDiskItem(NarutoShippudenModElements instance) {
			super(instance, 507);
			FMLJavaModLoadingContext.get().getModEventBus().register(new LightningDiskRenderer.ModelRegisterHandler());
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemRanged());
			elements.entities.add(() -> arrow);
		}

		public static class ItemRanged extends Item {
			public ItemRanged() {
				super(new Item.Properties().group(null).maxStackSize(0));
				setRegistryName("lightning_disk");
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
						ArrowCustomEntity entityarrow = shoot(world, entity, random, 1f, 20, 0);
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
				if (this.inGround) {
					this.remove();
				}
			}
		}

		public static ArrowCustomEntity shoot(World world, LivingEntity entity, Random random, float power, double damage, int knockback) {
			ArrowCustomEntity entityarrow = new ArrowCustomEntity(arrow, entity, world);
			entityarrow.shoot(entity.getLook(1).x, entity.getLook(1).y, entity.getLook(1).z, power * 2, 0);
			entityarrow.setSilent(true);
			entityarrow.setIsCritical(false);
			entityarrow.setDamage(damage);
			entityarrow.setKnockbackStrength(knockback);
			entityarrow.setNoGravity(true);
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
			entityarrow.setDamage(20);
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
	public static class LightningWaveItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:lightning_wave")
		public static final Item block = null;
		public static final EntityType arrow = (EntityType.Builder.<ArrowCustomEntity>create(ArrowCustomEntity::new, EntityClassification.MISC)
				.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).setCustomClientFactory(ArrowCustomEntity::new)
				.size(0.5f, 0.5f)).build("projectile_lightning_wave").setRegistryName("projectile_lightning_wave");

		public LightningWaveItem(NarutoShippudenModElements instance) {
			super(instance, 508);
			FMLJavaModLoadingContext.get().getModEventBus().register(new LightningWaveRenderer.ModelRegisterHandler());
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemRanged());
			elements.entities.add(() -> arrow);
		}

		public static class ItemRanged extends Item {
			public ItemRanged() {
				super(new Item.Properties().group(null).maxStackSize(0));
				setRegistryName("lightning_wave");
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
						ArrowCustomEntity entityarrow = shoot(world, entity, random, 1f, 20, 0);
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
			entityarrow.setDamage(20);
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
	public static class MirrorItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:mirror")
		public static final Item block = null;
		public static final EntityType arrow = (EntityType.Builder.<ArrowCustomEntity>create(ArrowCustomEntity::new, EntityClassification.MISC)
				.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).setCustomClientFactory(ArrowCustomEntity::new)
				.size(0.5f, 0.5f)).build("projectile_mirror").setRegistryName("projectile_mirror");

		public MirrorItem(NarutoShippudenModElements instance) {
			super(instance, 820);
			FMLJavaModLoadingContext.get().getModEventBus().register(new MirrorRenderer.ModelRegisterHandler());
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemRanged());
			elements.entities.add(() -> arrow);
		}

		public static class ItemRanged extends Item {
			public ItemRanged() {
				super(new Item.Properties().group(null).maxStackSize(0));
				setRegistryName("mirror");
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
						ArrowCustomEntity entityarrow = shoot(world, entity, random, 12f, 1, 0);
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

				MirrorProjectileHitsLivingEntityProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
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
			entityarrow.shoot(d1, d0 - entityarrow.getPosY() + (double) MathHelper.sqrt(d1 * d1 + d3 * d3) * 0.2F, d3, 12f * 2, 12.0F);
			entityarrow.setSilent(true);
			entityarrow.setDamage(1);
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
	public static class NeedleSenbonItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:needle_senbon")
		public static final Item block = null;
		public static final EntityType arrow = (EntityType.Builder.<ArrowCustomEntity>create(ArrowCustomEntity::new, EntityClassification.MISC)
				.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).setCustomClientFactory(ArrowCustomEntity::new)
				.size(5.5f, 5.5f)).build("projectile_needle_senbon").setRegistryName("projectile_needle_senbon");

		public NeedleSenbonItem(NarutoShippudenModElements instance) {
			super(instance, 835);
			FMLJavaModLoadingContext.get().getModEventBus().register(new NeedleSenbonRenderer.ModelRegisterHandler());
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemRanged());
			elements.entities.add(() -> arrow);
		}

		public static class ItemRanged extends Item {
			public ItemRanged() {
				super(new Item.Properties().group(null).maxStackSize(0));
				setRegistryName("needle_senbon");
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
			entityarrow.setDamage(10);
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
	public static class PhoenixFlowerJutsuItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:phoenix_flower_jutsu")
		public static final Item block = null;
		public static final EntityType arrow = (EntityType.Builder.<ArrowCustomEntity>create(ArrowCustomEntity::new, EntityClassification.MISC)
				.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).setCustomClientFactory(ArrowCustomEntity::new)
				.size(1.0f, 1.0f)).build("projectile_phoenix_flower_jutsu").setRegistryName("projectile_phoenix_flower_jutsu");

		public PhoenixFlowerJutsuItem(NarutoShippudenModElements instance) {
			super(instance, 74);
			FMLJavaModLoadingContext.get().getModEventBus().register(new PhoenixFlowerJutsuRenderer.ModelRegisterHandler());
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemRanged());
			elements.entities.add(() -> arrow);
		}

		public static class ItemRanged extends Item {
			public ItemRanged() {
				super(new Item.Properties().group(null).maxStackSize(0));
				setRegistryName("phoenix_flower_jutsu");
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
			entityarrow.setDamage(10);
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
	public static class RasenshurikenItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:rasenshuriken")
		public static final Item block = null;
		public static final EntityType arrow = (EntityType.Builder.<ArrowCustomEntity>create(ArrowCustomEntity::new, EntityClassification.MISC)
				.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).setCustomClientFactory(ArrowCustomEntity::new)
				.size(3f, 3f)).build("projectile_rasenshuriken").setRegistryName("projectile_rasenshuriken");

		public RasenshurikenItem(NarutoShippudenModElements instance) {
			super(instance, 80);
			FMLJavaModLoadingContext.get().getModEventBus().register(new RasenshurikenRenderer.ModelRegisterHandler());
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemRanged());
			elements.entities.add(() -> arrow);
		}

		public static class ItemRanged extends Item {
			public ItemRanged() {
				super(new Item.Properties().group(null).maxStackSize(0));
				setRegistryName("rasenshuriken");
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
			public void onEntityHit(EntityRayTraceResult entityRayTraceResult) {
				super.onEntityHit(entityRayTraceResult);
				Entity entity = entityRayTraceResult.getEntity();
				Entity sourceentity = this.func_234616_v_();
				Entity immediatesourceentity = this;
				double x = this.getPosX();
				double y = this.getPosY();
				double z = this.getPosZ();
				World world = this.world;

				RasenshurikenProjectileHitsBlockProcedure.executeProcedure(Stream
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

				RasenshurikenProjectileHitsBlockProcedure.executeProcedure(Stream
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
	public static class SmokeGunItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:smoke_gun")
		public static final Item block = null;
		public static final EntityType arrow = (EntityType.Builder.<ArrowCustomEntity>create(ArrowCustomEntity::new, EntityClassification.MISC)
				.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).setCustomClientFactory(ArrowCustomEntity::new)
				.size(2.5f, 2.5f)).build("projectile_smoke_gun").setRegistryName("projectile_smoke_gun");

		public SmokeGunItem(NarutoShippudenModElements instance) {
			super(instance, 464);
			FMLJavaModLoadingContext.get().getModEventBus().register(new SmokeGunRenderer.ModelRegisterHandler());
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemRanged());
			elements.entities.add(() -> arrow);
		}

		public static class ItemRanged extends Item {
			public ItemRanged() {
				super(new Item.Properties().group(null).maxStackSize(0));
				setRegistryName("smoke_gun");
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
						ArrowCustomEntity entityarrow = shoot(world, entity, random, 12f, 1, 0);
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

				SmokeGunWhileProjectileFlyingTickProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z), new AbstractMap.SimpleEntry<>("immediatesourceentity", immediatesourceentity))
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
			entityarrow.shoot(d1, d0 - entityarrow.getPosY() + (double) MathHelper.sqrt(d1 * d1 + d3 * d3) * 0.2F, d3, 12f * 2, 12.0F);
			entityarrow.setSilent(true);
			entityarrow.setDamage(1);
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
	public static class SteelProjectileItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:steel_projectile")
		public static final Item block = null;
		public static final EntityType arrow = (EntityType.Builder.<ArrowCustomEntity>create(ArrowCustomEntity::new, EntityClassification.MISC)
				.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).setCustomClientFactory(ArrowCustomEntity::new)
				.size(1.0f, 1.0f)).build("projectile_steel_projectile").setRegistryName("projectile_steel_projectile");

		public SteelProjectileItem(NarutoShippudenModElements instance) {
			super(instance, 1084);
			FMLJavaModLoadingContext.get().getModEventBus().register(new SteelProjectileRenderer.ModelRegisterHandler());
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemRanged());
			elements.entities.add(() -> arrow);
		}

		public static class ItemRanged extends Item {
			public ItemRanged() {
				super(new Item.Properties().group(null).maxStackSize(0));
				setRegistryName("steel_projectile");
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
	public static class TailedBeastBombItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:tailed_beast_bomb")
		public static final Item block = null;
		public static final EntityType arrow = (EntityType.Builder.<ArrowCustomEntity>create(ArrowCustomEntity::new, EntityClassification.MISC)
				.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).setCustomClientFactory(ArrowCustomEntity::new)
				.size(4.5f, 4.5f)).build("projectile_tailed_beast_bomb").setRegistryName("projectile_tailed_beast_bomb");

		public TailedBeastBombItem(NarutoShippudenModElements instance) {
			super(instance, 160);
			FMLJavaModLoadingContext.get().getModEventBus().register(new TailedBeastBombRenderer.ModelRegisterHandler());
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemRanged());
			elements.entities.add(() -> arrow);
		}

		public static class ItemRanged extends Item {
			public ItemRanged() {
				super(new Item.Properties().group(null).maxStackSize(0));
				setRegistryName("tailed_beast_bomb");
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
						ArrowCustomEntity entityarrow = shoot(world, entity, random, 3f, 90, 1);
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

				TailedBeastBombProjectileHitsBlockProcedure.executeProcedure(Stream
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

				TailedBeastBombWhileProjectileFlyingTickProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z), new AbstractMap.SimpleEntry<>("immediatesourceentity", immediatesourceentity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				if (this.inGround) {

					TailedBeastBombProjectileHitsBlockProcedure.executeProcedure(Stream
							.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x),
									new AbstractMap.SimpleEntry<>("y", y), new AbstractMap.SimpleEntry<>("z", z))
							.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
					this.remove();
				}
			}
		}

		public static ArrowCustomEntity shoot(World world, LivingEntity entity, Random random, float power, double damage, int knockback) {
			ArrowCustomEntity entityarrow = new ArrowCustomEntity(arrow, entity, world);
			entityarrow.shoot(entity.getLook(1).x, entity.getLook(1).y, entity.getLook(1).z, power * 2, 0);
			entityarrow.setSilent(true);
			entityarrow.setIsCritical(false);
			entityarrow.setDamage(damage);
			entityarrow.setKnockbackStrength(knockback);
			entityarrow.setNoGravity(true);
			world.addEntity(entityarrow);
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			world.playSound((PlayerEntity) null, (double) x, (double) y, (double) z,
					(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
							.getValue(new ResourceLocation("naruto_shippuden:dust_release_and_tailed_beast_bomb")),
					SoundCategory.PLAYERS, 1, 1f / (random.nextFloat() * 0.5f + 1) + (power / 2));
			return entityarrow;
		}

		public static ArrowCustomEntity shoot(LivingEntity entity, LivingEntity target) {
			ArrowCustomEntity entityarrow = new ArrowCustomEntity(arrow, entity, entity.world);
			double d0 = target.getPosY() + (double) target.getEyeHeight() - 1.1;
			double d1 = target.getPosX() - entity.getPosX();
			double d3 = target.getPosZ() - entity.getPosZ();
			entityarrow.shoot(d1, d0 - entityarrow.getPosY() + (double) MathHelper.sqrt(d1 * d1 + d3 * d3) * 0.2F, d3, 3f * 2, 12.0F);
			entityarrow.setSilent(true);
			entityarrow.setDamage(90);
			entityarrow.setKnockbackStrength(1);
			entityarrow.setIsCritical(false);
			entity.world.addEntity(entityarrow);
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			entity.world.playSound((PlayerEntity) null, (double) x, (double) y, (double) z,
					(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
							.getValue(new ResourceLocation("naruto_shippuden:dust_release_and_tailed_beast_bomb")),
					SoundCategory.PLAYERS, 1, 1f / (new Random().nextFloat() * 0.5f + 1));
			return entityarrow;
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class TreeBindItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:tree_bind")
		public static final Item block = null;
		public static final EntityType arrow = (EntityType.Builder.<ArrowCustomEntity>create(ArrowCustomEntity::new, EntityClassification.MISC)
				.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).setCustomClientFactory(ArrowCustomEntity::new)
				.size(0.5f, 0.5f)).build("projectile_tree_bind").setRegistryName("projectile_tree_bind");

		public TreeBindItem(NarutoShippudenModElements instance) {
			super(instance, 789);
			FMLJavaModLoadingContext.get().getModEventBus().register(new TreeBindRenderer.ModelRegisterHandler());
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemRanged());
			elements.entities.add(() -> arrow);
		}

		public static class ItemRanged extends Item {
			public ItemRanged() {
				super(new Item.Properties().group(null).maxStackSize(0));
				setRegistryName("tree_bind");
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
						ArrowCustomEntity entityarrow = shoot(world, entity, random, 12f, 1, 0);
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

				TreeBindProjectileHitsLivingEntityProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
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
			entityarrow.shoot(d1, d0 - entityarrow.getPosY() + (double) MathHelper.sqrt(d1 * d1 + d3 * d3) * 0.2F, d3, 12f * 2, 12.0F);
			entityarrow.setSilent(true);
			entityarrow.setDamage(1);
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
	public static class UzumakiChainItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:uzumaki_chain")
		public static final Item block = null;
		public static final EntityType arrow = (EntityType.Builder.<ArrowCustomEntity>create(ArrowCustomEntity::new, EntityClassification.MISC)
				.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).setCustomClientFactory(ArrowCustomEntity::new)
				.size(2.5f, 2.5f)).build("projectile_uzumaki_chain").setRegistryName("projectile_uzumaki_chain");

		public UzumakiChainItem(NarutoShippudenModElements instance) {
			super(instance, 440);
			FMLJavaModLoadingContext.get().getModEventBus().register(new UzumakiChainRenderer.ModelRegisterHandler());
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemRanged());
			elements.entities.add(() -> arrow);
		}

		public static class ItemRanged extends Item {
			public ItemRanged() {
				super(new Item.Properties().group(null).maxStackSize(0));
				setRegistryName("uzumaki_chain");
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
						ArrowCustomEntity entityarrow = shoot(world, entity, random, 1f, 1, 0);
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

				UzumakiChainProjectileHitsLivingEntityProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
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

				UzumakiChainWhileProjectileFlyingTickProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("immediatesourceentity", immediatesourceentity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				if (this.inGround) {
					this.remove();
				}
			}
		}

		public static ArrowCustomEntity shoot(World world, LivingEntity entity, Random random, float power, double damage, int knockback) {
			ArrowCustomEntity entityarrow = new ArrowCustomEntity(arrow, entity, world);
			entityarrow.shoot(entity.getLook(1).x, entity.getLook(1).y, entity.getLook(1).z, power * 2, 0);
			entityarrow.setSilent(true);
			entityarrow.setIsCritical(false);
			entityarrow.setDamage(damage);
			entityarrow.setKnockbackStrength(knockback);
			entityarrow.setNoGravity(true);
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
			entityarrow.setDamage(1);
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
	public static class VacuumSphereItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:vacuum_sphere")
		public static final Item block = null;
		public static final EntityType arrow = (EntityType.Builder.<ArrowCustomEntity>create(ArrowCustomEntity::new, EntityClassification.MISC)
				.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).setCustomClientFactory(ArrowCustomEntity::new)
				.size(1f, 1f)).build("projectile_vacuum_sphere").setRegistryName("projectile_vacuum_sphere");

		public VacuumSphereItem(NarutoShippudenModElements instance) {
			super(instance, 83);
			FMLJavaModLoadingContext.get().getModEventBus().register(new VacuumSphereRenderer.ModelRegisterHandler());
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemRanged());
			elements.entities.add(() -> arrow);
		}

		public static class ItemRanged extends Item {
			public ItemRanged() {
				super(new Item.Properties().group(null).maxStackSize(0));
				setRegistryName("vacuum_sphere");
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

				VacuumSphereWhileProjectileFlyingTickProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z), new AbstractMap.SimpleEntry<>("immediatesourceentity", immediatesourceentity))
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
	public static class WaterBallItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:water_ball")
		public static final Item block = null;
		public static final EntityType arrow = (EntityType.Builder.<ArrowCustomEntity>create(ArrowCustomEntity::new, EntityClassification.MISC)
				.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).setCustomClientFactory(ArrowCustomEntity::new)
				.size(3f, 3f)).build("projectile_water_ball").setRegistryName("projectile_water_ball");

		public WaterBallItem(NarutoShippudenModElements instance) {
			super(instance, 500);
			FMLJavaModLoadingContext.get().getModEventBus().register(new WaterBallRenderer.ModelRegisterHandler());
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemRanged());
			elements.entities.add(() -> arrow);
		}

		public static class ItemRanged extends Item {
			public ItemRanged() {
				super(new Item.Properties().group(null).maxStackSize(0));
				setRegistryName("water_ball");
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
						ArrowCustomEntity entityarrow = shoot(world, entity, random, 1f, 20, 0);
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
				if (this.inGround) {
					this.remove();
				}
			}
		}

		public static ArrowCustomEntity shoot(World world, LivingEntity entity, Random random, float power, double damage, int knockback) {
			ArrowCustomEntity entityarrow = new ArrowCustomEntity(arrow, entity, world);
			entityarrow.shoot(entity.getLook(1).x, entity.getLook(1).y, entity.getLook(1).z, power * 2, 0);
			entityarrow.setSilent(true);
			entityarrow.setIsCritical(false);
			entityarrow.setDamage(damage);
			entityarrow.setKnockbackStrength(knockback);
			entityarrow.setNoGravity(true);
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
			entityarrow.setDamage(20);
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
	public static class WaterDiskItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:water_disk")
		public static final Item block = null;
		public static final EntityType arrow = (EntityType.Builder.<ArrowCustomEntity>create(ArrowCustomEntity::new, EntityClassification.MISC)
				.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).setCustomClientFactory(ArrowCustomEntity::new)
				.size(2.5f, 2.5f)).build("projectile_water_disk").setRegistryName("projectile_water_disk");

		public WaterDiskItem(NarutoShippudenModElements instance) {
			super(instance, 498);
			FMLJavaModLoadingContext.get().getModEventBus().register(new WaterDiskRenderer.ModelRegisterHandler());
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemRanged());
			elements.entities.add(() -> arrow);
		}

		public static class ItemRanged extends Item {
			public ItemRanged() {
				super(new Item.Properties().group(null).maxStackSize(0));
				setRegistryName("water_disk");
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
						ArrowCustomEntity entityarrow = shoot(world, entity, random, 1f, 20, 0);
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
				if (this.inGround) {
					this.remove();
				}
			}
		}

		public static ArrowCustomEntity shoot(World world, LivingEntity entity, Random random, float power, double damage, int knockback) {
			ArrowCustomEntity entityarrow = new ArrowCustomEntity(arrow, entity, world);
			entityarrow.shoot(entity.getLook(1).x, entity.getLook(1).y, entity.getLook(1).z, power * 2, 0);
			entityarrow.setSilent(true);
			entityarrow.setIsCritical(false);
			entityarrow.setDamage(damage);
			entityarrow.setKnockbackStrength(knockback);
			entityarrow.setNoGravity(true);
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
			entityarrow.setDamage(20);
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
	public static class WaterDragonItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:water_dragon")
		public static final Item block = null;
		public static final EntityType arrow = (EntityType.Builder.<ArrowCustomEntity>create(ArrowCustomEntity::new, EntityClassification.MISC)
				.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).setCustomClientFactory(ArrowCustomEntity::new)
				.size(3f, 3f)).build("projectile_water_dragon").setRegistryName("projectile_water_dragon");

		public WaterDragonItem(NarutoShippudenModElements instance) {
			super(instance, 76);
			FMLJavaModLoadingContext.get().getModEventBus().register(new WaterDragonRenderer.ModelRegisterHandler());
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemRanged());
			elements.entities.add(() -> arrow);
		}

		public static class ItemRanged extends Item {
			public ItemRanged() {
				super(new Item.Properties().group(null).maxStackSize(0));
				setRegistryName("water_dragon");
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
	public static class WaterGunItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:water_gun")
		public static final Item block = null;
		public static final EntityType arrow = (EntityType.Builder.<ArrowCustomEntity>create(ArrowCustomEntity::new, EntityClassification.MISC)
				.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).setCustomClientFactory(ArrowCustomEntity::new)
				.size(1.0f, 1.0f)).build("projectile_water_gun").setRegistryName("projectile_water_gun");

		public WaterGunItem(NarutoShippudenModElements instance) {
			super(instance, 79);
			FMLJavaModLoadingContext.get().getModEventBus().register(new WaterGunRenderer.ModelRegisterHandler());
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemRanged());
			elements.entities.add(() -> arrow);
		}

		public static class ItemRanged extends Item {
			public ItemRanged() {
				super(new Item.Properties().group(null).maxStackSize(0));
				setRegistryName("water_gun");
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
			entityarrow.setDamage(10);
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
	public static class WaterWaveItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:water_wave")
		public static final Item block = null;
		public static final EntityType arrow = (EntityType.Builder.<ArrowCustomEntity>create(ArrowCustomEntity::new, EntityClassification.MISC)
				.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).setCustomClientFactory(ArrowCustomEntity::new)
				.size(0.5f, 0.5f)).build("projectile_water_wave").setRegistryName("projectile_water_wave");

		public WaterWaveItem(NarutoShippudenModElements instance) {
			super(instance, 499);
			FMLJavaModLoadingContext.get().getModEventBus().register(new WaterWaveRenderer.ModelRegisterHandler());
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemRanged());
			elements.entities.add(() -> arrow);
		}

		public static class ItemRanged extends Item {
			public ItemRanged() {
				super(new Item.Properties().group(null).maxStackSize(0));
				setRegistryName("water_wave");
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
						ArrowCustomEntity entityarrow = shoot(world, entity, random, 1f, 20, 0);
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
			entityarrow.setDamage(20);
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
	public static class WindBallItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:wind_ball")
		public static final Item block = null;
		public static final EntityType arrow = (EntityType.Builder.<ArrowCustomEntity>create(ArrowCustomEntity::new, EntityClassification.MISC)
				.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).setCustomClientFactory(ArrowCustomEntity::new)
				.size(3f, 3f)).build("projectile_wind_ball").setRegistryName("projectile_wind_ball");

		public WindBallItem(NarutoShippudenModElements instance) {
			super(instance, 503);
			FMLJavaModLoadingContext.get().getModEventBus().register(new WindBallRenderer.ModelRegisterHandler());
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemRanged());
			elements.entities.add(() -> arrow);
		}

		public static class ItemRanged extends Item {
			public ItemRanged() {
				super(new Item.Properties().group(null).maxStackSize(0));
				setRegistryName("wind_ball");
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
						ArrowCustomEntity entityarrow = shoot(world, entity, random, 1f, 20, 0);
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
				if (this.inGround) {
					this.remove();
				}
			}
		}

		public static ArrowCustomEntity shoot(World world, LivingEntity entity, Random random, float power, double damage, int knockback) {
			ArrowCustomEntity entityarrow = new ArrowCustomEntity(arrow, entity, world);
			entityarrow.shoot(entity.getLook(1).x, entity.getLook(1).y, entity.getLook(1).z, power * 2, 0);
			entityarrow.setSilent(true);
			entityarrow.setIsCritical(false);
			entityarrow.setDamage(damage);
			entityarrow.setKnockbackStrength(knockback);
			entityarrow.setNoGravity(true);
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
			entityarrow.setDamage(20);
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
	public static class WindDiskItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:wind_disk")
		public static final Item block = null;
		public static final EntityType arrow = (EntityType.Builder.<ArrowCustomEntity>create(ArrowCustomEntity::new, EntityClassification.MISC)
				.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).setCustomClientFactory(ArrowCustomEntity::new)
				.size(2.5f, 2.5f)).build("projectile_wind_disk").setRegistryName("projectile_wind_disk");

		public WindDiskItem(NarutoShippudenModElements instance) {
			super(instance, 501);
			FMLJavaModLoadingContext.get().getModEventBus().register(new WindDiskRenderer.ModelRegisterHandler());
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemRanged());
			elements.entities.add(() -> arrow);
		}

		public static class ItemRanged extends Item {
			public ItemRanged() {
				super(new Item.Properties().group(null).maxStackSize(0));
				setRegistryName("wind_disk");
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
						ArrowCustomEntity entityarrow = shoot(world, entity, random, 1f, 20, 0);
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
				if (this.inGround) {
					this.remove();
				}
			}
		}

		public static ArrowCustomEntity shoot(World world, LivingEntity entity, Random random, float power, double damage, int knockback) {
			ArrowCustomEntity entityarrow = new ArrowCustomEntity(arrow, entity, world);
			entityarrow.shoot(entity.getLook(1).x, entity.getLook(1).y, entity.getLook(1).z, power * 2, 0);
			entityarrow.setSilent(true);
			entityarrow.setIsCritical(false);
			entityarrow.setDamage(damage);
			entityarrow.setKnockbackStrength(knockback);
			entityarrow.setNoGravity(true);
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
			entityarrow.setDamage(20);
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
	public static class WindWaveItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:wind_wave")
		public static final Item block = null;
		public static final EntityType arrow = (EntityType.Builder.<ArrowCustomEntity>create(ArrowCustomEntity::new, EntityClassification.MISC)
				.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).setCustomClientFactory(ArrowCustomEntity::new)
				.size(0.5f, 0.5f)).build("projectile_wind_wave").setRegistryName("projectile_wind_wave");

		public WindWaveItem(NarutoShippudenModElements instance) {
			super(instance, 502);
			FMLJavaModLoadingContext.get().getModEventBus().register(new WindWaveRenderer.ModelRegisterHandler());
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemRanged());
			elements.entities.add(() -> arrow);
		}

		public static class ItemRanged extends Item {
			public ItemRanged() {
				super(new Item.Properties().group(null).maxStackSize(0));
				setRegistryName("wind_wave");
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
						ArrowCustomEntity entityarrow = shoot(world, entity, random, 1f, 20, 0);
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
			entityarrow.setDamage(20);
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
	public static class WoodDragonItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:wood_dragon")
		public static final Item block = null;
		public static final EntityType arrow = (EntityType.Builder.<ArrowCustomEntity>create(ArrowCustomEntity::new, EntityClassification.MISC)
				.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).setCustomClientFactory(ArrowCustomEntity::new)
				.size(3f, 3f)).build("projectile_wood_dragon").setRegistryName("projectile_wood_dragon");

		public WoodDragonItem(NarutoShippudenModElements instance) {
			super(instance, 788);
			FMLJavaModLoadingContext.get().getModEventBus().register(new WoodDragonRenderer.ModelRegisterHandler());
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemRanged());
			elements.entities.add(() -> arrow);
		}

		public static class ItemRanged extends Item {
			public ItemRanged() {
				super(new Item.Properties().group(null).maxStackSize(0));
				setRegistryName("wood_dragon");
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
