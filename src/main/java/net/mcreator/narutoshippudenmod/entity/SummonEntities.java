package net.mcreator.narutoshippudenmod.entity;

import java.util.AbstractMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.stream.Stream;
import javax.annotation.Nullable;
import net.mcreator.narutoshippudenmod.NarutoShippudenModElements;
import net.mcreator.narutoshippudenmod.entity.renderer.SummonRenderers.AkamaruRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.SummonRenderers.CrowRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.SummonRenderers.EarthGolemRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.SummonRenderers.KirinRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.SummonRenderers.KuramaRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.SummonRenderers.MonsterCatRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.SummonRenderers.ThreeHeadAkamaruRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.SummonRenderers.TwoHeadAkamaruRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.SummonRenderers.WolfRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.SummonRenderers.WoodGolemRenderer;
import net.mcreator.narutoshippudenmod.item.JutsuProjectileItems.TailedBeastBombItem;
import net.mcreator.narutoshippudenmod.itemgroup.ModItemGroups.SpawnEggsItemGroup;
import net.mcreator.narutoshippudenmod.procedures.ClanProcedures.AkamaruOnInitialEntitySpawnProcedure;
import net.mcreator.narutoshippudenmod.procedures.ClanProcedures.AkamaruRightClickedOnEntityProcedure;
import net.mcreator.narutoshippudenmod.procedures.ClanProcedures.FollowAkamaruProcedure;
import net.mcreator.narutoshippudenmod.procedures.ClanProcedures.NotFollowAkamaruProcedure;
import net.mcreator.narutoshippudenmod.procedures.EntityProcedures.CrowOnInitialEntitySpawnProcedure;
import net.mcreator.narutoshippudenmod.procedures.EntityProcedures.EarthGolemOnInitialEntitySpawnProcedure;
import net.mcreator.narutoshippudenmod.procedures.EntityProcedures.KirinEntityFallsProcedure;
import net.mcreator.narutoshippudenmod.procedures.EntityProcedures.KuramaOnInitialEntitySpawnProcedure;
import net.mcreator.narutoshippudenmod.procedures.EntityProcedures.RunningFireOnInitialEntitySpawnProcedure;
import net.minecraft.block.BlockState;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.AreaEffectCloudEntity;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.controller.FlyingMovementController;
import net.minecraft.entity.ai.goal.FollowOwnerGoal;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.LeapAtTargetGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.OwnerHurtByTargetGoal;
import net.minecraft.entity.ai.goal.OwnerHurtTargetGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.RangedAttackGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.entity.projectile.PotionEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.pathfinding.FlyingPathNavigator;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.BossInfo;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerBossInfo;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.registries.ForgeRegistries;

public final class SummonEntities {
	private SummonEntities() {
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class AkamaruEntity extends NarutoShippudenModElements.ModElement {
		public static EntityType entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER)
				.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new)
				.size(0.7f, 0.7f)).build("akamaru").setRegistryName("akamaru");

		public AkamaruEntity(NarutoShippudenModElements instance) {
			super(instance, 555);
			FMLJavaModLoadingContext.get().getModEventBus().register(new AkamaruRenderer.ModelRegisterHandler());
			FMLJavaModLoadingContext.get().getModEventBus().register(new EntityAttributesRegisterHandler());
		}

		@Override
		public void initElements() {
			elements.entities.add(() -> entity);
		}

		@Override
		public void init(FMLCommonSetupEvent event) {
		}

		private static class EntityAttributesRegisterHandler {
			@SubscribeEvent
			public void onEntityAttributeCreation(EntityAttributeCreationEvent event) {
				AttributeModifierMap.MutableAttribute ammma = MobEntity.func_233666_p_();
				ammma = ammma.createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.45);
				ammma = ammma.createMutableAttribute(Attributes.MAX_HEALTH, 230);
				ammma = ammma.createMutableAttribute(Attributes.ARMOR, 0);
				ammma = ammma.createMutableAttribute(Attributes.ATTACK_DAMAGE, 9);
				ammma = ammma.createMutableAttribute(Attributes.FOLLOW_RANGE, 16);
				event.put(entity, ammma.create());
			}
		}

		public static class CustomEntity extends TameableEntity {
			public CustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
				this(entity, world);
			}

			public CustomEntity(EntityType<CustomEntity> type, World world) {
				super(type, world);
				experienceValue = 0;
				setNoAI(false);
				enablePersistence();
			}

			@Override
			public IPacket<?> createSpawnPacket() {
				return NetworkHooks.getEntitySpawningPacket(this);
			}

			@Override
			protected void registerGoals() {
				super.registerGoals();
				this.goalSelector.addGoal(1, new FollowOwnerGoal(this, 1, (float) 6, (float) 32, false) {
					@Override
					public boolean shouldExecute() {
						double x = CustomEntity.this.getPosX();
						double y = CustomEntity.this.getPosY();
						double z = CustomEntity.this.getPosZ();
						Entity entity = CustomEntity.this;
						return super.shouldExecute() && FollowAkamaruProcedure.executeProcedure(
								Stream.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("entity", entity))
										.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
					}
				});
				this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.2, false) {
					@Override
					protected double getAttackReachSqr(LivingEntity entity) {
						return (double) (4.0 + entity.getWidth() * entity.getWidth());
					}

					@Override
					public boolean shouldExecute() {
						double x = CustomEntity.this.getPosX();
						double y = CustomEntity.this.getPosY();
						double z = CustomEntity.this.getPosZ();
						Entity entity = CustomEntity.this;
						return super.shouldExecute() && FollowAkamaruProcedure.executeProcedure(
								Stream.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("entity", entity))
										.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
					}

				});
				this.goalSelector.addGoal(3, new OwnerHurtByTargetGoal(this) {
					@Override
					public boolean shouldExecute() {
						double x = CustomEntity.this.getPosX();
						double y = CustomEntity.this.getPosY();
						double z = CustomEntity.this.getPosZ();
						Entity entity = CustomEntity.this;
						return super.shouldExecute() && FollowAkamaruProcedure.executeProcedure(
								Stream.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("entity", entity))
										.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
					}
				});
				this.goalSelector.addGoal(4, new OwnerHurtTargetGoal(this) {
					@Override
					public boolean shouldExecute() {
						double x = CustomEntity.this.getPosX();
						double y = CustomEntity.this.getPosY();
						double z = CustomEntity.this.getPosZ();
						Entity entity = CustomEntity.this;
						return super.shouldExecute() && FollowAkamaruProcedure.executeProcedure(
								Stream.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("entity", entity))
										.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
					}
				});
				this.goalSelector.addGoal(5, new LookAtGoal(this, PlayerEntity.class, (float) 6));
				this.goalSelector.addGoal(6, new LookAtGoal(this, ServerPlayerEntity.class, (float) 6));
				this.goalSelector.addGoal(7, new LookRandomlyGoal(this) {
					@Override
					public boolean shouldExecute() {
						double x = CustomEntity.this.getPosX();
						double y = CustomEntity.this.getPosY();
						double z = CustomEntity.this.getPosZ();
						Entity entity = CustomEntity.this;
						return super.shouldExecute() && NotFollowAkamaruProcedure.executeProcedure(
								Stream.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("entity", entity))
										.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
					}
				});
				this.goalSelector.addGoal(8, new SwimGoal(this) {
					@Override
					public boolean shouldExecute() {
						double x = CustomEntity.this.getPosX();
						double y = CustomEntity.this.getPosY();
						double z = CustomEntity.this.getPosZ();
						Entity entity = CustomEntity.this;
						return super.shouldExecute() && NotFollowAkamaruProcedure.executeProcedure(
								Stream.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("entity", entity))
										.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
					}
				});
				this.goalSelector.addGoal(9, new RandomWalkingGoal(this, 1) {
					@Override
					public boolean shouldExecute() {
						double x = CustomEntity.this.getPosX();
						double y = CustomEntity.this.getPosY();
						double z = CustomEntity.this.getPosZ();
						Entity entity = CustomEntity.this;
						return super.shouldExecute() && NotFollowAkamaruProcedure.executeProcedure(
								Stream.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("entity", entity))
										.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
					}
				});
			}

			@Override
			public CreatureAttribute getCreatureAttribute() {
				return CreatureAttribute.UNDEFINED;
			}

			@Override
			public boolean canDespawn(double distanceToClosestPlayer) {
				return false;
			}

			@Override
			public net.minecraft.util.SoundEvent getAmbientSound() {
				return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wolf.pant"));
			}

			@Override
			public void playStepSound(BlockPos pos, BlockState blockIn) {
				this.playSound((net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wolf.step")), 0.15f, 1);
			}

			@Override
			public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
				return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wolf.hurt"));
			}

			@Override
			public net.minecraft.util.SoundEvent getDeathSound() {
				return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wolf.death"));
			}

			@Override
			public boolean attackEntityFrom(DamageSource source, float amount) {
				if (source == DamageSource.FALL)
					return false;
				if (source == DamageSource.DROWN)
					return false;
				return super.attackEntityFrom(source, amount);
			}

			@Override
			public ILivingEntityData onInitialSpawn(IServerWorld world, DifficultyInstance difficulty, SpawnReason reason,
					@Nullable ILivingEntityData livingdata, @Nullable CompoundNBT tag) {
				ILivingEntityData retval = super.onInitialSpawn(world, difficulty, reason, livingdata, tag);
				double x = this.getPosX();
				double y = this.getPosY();
				double z = this.getPosZ();
				Entity entity = this;

				AkamaruOnInitialEntitySpawnProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return retval;
			}

			@Override
			public ActionResultType func_230254_b_(PlayerEntity sourceentity, Hand hand) {
				ItemStack itemstack = sourceentity.getHeldItem(hand);
				ActionResultType retval = ActionResultType.func_233537_a_(this.world.isRemote());
				Item item = itemstack.getItem();
				if (itemstack.getItem() instanceof SpawnEggItem) {
					retval = super.func_230254_b_(sourceentity, hand);
				} else if (this.world.isRemote()) {
					retval = (this.isTamed() && this.isOwner(sourceentity) || this.isBreedingItem(itemstack))
							? ActionResultType.func_233537_a_(this.world.isRemote())
							: ActionResultType.PASS;
				} else {
					if (this.isTamed()) {
						if (this.isOwner(sourceentity)) {
							if (item.isFood() && this.isBreedingItem(itemstack) && this.getHealth() < this.getMaxHealth()) {
								this.consumeItemFromStack(sourceentity, itemstack);
								this.heal((float) item.getFood().getHealing());
								retval = ActionResultType.func_233537_a_(this.world.isRemote());
							} else if (this.isBreedingItem(itemstack) && this.getHealth() < this.getMaxHealth()) {
								this.consumeItemFromStack(sourceentity, itemstack);
								this.heal(4);
								retval = ActionResultType.func_233537_a_(this.world.isRemote());
							} else {
								retval = super.func_230254_b_(sourceentity, hand);
							}
						}
					} else if (this.isBreedingItem(itemstack)) {
						this.consumeItemFromStack(sourceentity, itemstack);
						if (this.rand.nextInt(3) == 0 && !net.minecraftforge.event.ForgeEventFactory.onAnimalTame(this, sourceentity)) {
							this.setTamedBy(sourceentity);
							this.world.setEntityState(this, (byte) 7);
						} else {
							this.world.setEntityState(this, (byte) 6);
						}
						this.enablePersistence();
						retval = ActionResultType.func_233537_a_(this.world.isRemote());
					} else {
						retval = super.func_230254_b_(sourceentity, hand);
						if (retval == ActionResultType.SUCCESS || retval == ActionResultType.CONSUME)
							this.enablePersistence();
					}
				}
				double x = this.getPosX();
				double y = this.getPosY();
				double z = this.getPosZ();
				Entity entity = this;

				AkamaruRightClickedOnEntityProcedure.executeProcedure(
						Stream.of(new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("sourceentity", sourceentity))
								.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return retval;
			}

			@Override
			public AgeableEntity func_241840_a(ServerWorld serverWorld, AgeableEntity ageable) {
				CustomEntity retval = (CustomEntity) entity.create(serverWorld);
				retval.onInitialSpawn(serverWorld, serverWorld.getDifficultyForLocation(new BlockPos(retval.getPosition())), SpawnReason.BREEDING,
						(ILivingEntityData) null, (CompoundNBT) null);
				return retval;
			}

			@Override
			public boolean isBreedingItem(ItemStack stack) {
				if (stack == null)
					return false;
				return false;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class CrowEntity extends NarutoShippudenModElements.ModElement {
		public static EntityType entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.CREATURE)
				.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new)
				.size(0.5f, 1.6f)).build("crow").setRegistryName("crow");

		public CrowEntity(NarutoShippudenModElements instance) {
			super(instance, 394);
			FMLJavaModLoadingContext.get().getModEventBus().register(new CrowRenderer.ModelRegisterHandler());
			FMLJavaModLoadingContext.get().getModEventBus().register(new EntityAttributesRegisterHandler());
		}

		@Override
		public void initElements() {
			elements.entities.add(() -> entity);
		}

		@Override
		public void init(FMLCommonSetupEvent event) {
		}

		private static class EntityAttributesRegisterHandler {
			@SubscribeEvent
			public void onEntityAttributeCreation(EntityAttributeCreationEvent event) {
				AttributeModifierMap.MutableAttribute ammma = MobEntity.func_233666_p_();
				ammma = ammma.createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.3);
				ammma = ammma.createMutableAttribute(Attributes.MAX_HEALTH, 10);
				ammma = ammma.createMutableAttribute(Attributes.ARMOR, 0);
				ammma = ammma.createMutableAttribute(Attributes.ATTACK_DAMAGE, 3);
				ammma = ammma.createMutableAttribute(Attributes.FOLLOW_RANGE, 16);
				ammma = ammma.createMutableAttribute(Attributes.FLYING_SPEED, 0.3);
				event.put(entity, ammma.create());
			}
		}

		public static class CustomEntity extends CreatureEntity {
			public CustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
				this(entity, world);
			}

			public CustomEntity(EntityType<CustomEntity> type, World world) {
				super(type, world);
				experienceValue = 0;
				setNoAI(false);
				enablePersistence();
				this.moveController = new FlyingMovementController(this, 10, true);
				this.navigator = new FlyingPathNavigator(this, this.world);
			}

			@Override
			public IPacket<?> createSpawnPacket() {
				return NetworkHooks.getEntitySpawningPacket(this);
			}

			@Override
			protected void registerGoals() {
				super.registerGoals();
				this.goalSelector.addGoal(1, new RandomWalkingGoal(this, 0.8, 20) {
					@Override
					protected Vector3d getPosition() {
						Random random = CustomEntity.this.getRNG();
						double dir_x = CustomEntity.this.getPosX() + ((random.nextFloat() * 2 - 1) * 16);
						double dir_y = CustomEntity.this.getPosY() + ((random.nextFloat() * 2 - 1) * 16);
						double dir_z = CustomEntity.this.getPosZ() + ((random.nextFloat() * 2 - 1) * 16);
						return new Vector3d(dir_x, dir_y, dir_z);
					}
				});
				this.goalSelector.addGoal(2, new LookRandomlyGoal(this));
				this.goalSelector.addGoal(3, new SwimGoal(this));
				this.goalSelector.addGoal(4, new LeapAtTargetGoal(this, (float) 0.5));
			}

			@Override
			public CreatureAttribute getCreatureAttribute() {
				return CreatureAttribute.UNDEFINED;
			}

			@Override
			public boolean canDespawn(double distanceToClosestPlayer) {
				return false;
			}

			@Override
			public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
				return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.hurt"));
			}

			@Override
			public net.minecraft.util.SoundEvent getDeathSound() {
				return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.death"));
			}

			@Override
			public boolean onLivingFall(float l, float d) {
				return false;
			}

			@Override
			public ILivingEntityData onInitialSpawn(IServerWorld world, DifficultyInstance difficulty, SpawnReason reason,
					@Nullable ILivingEntityData livingdata, @Nullable CompoundNBT tag) {
				ILivingEntityData retval = super.onInitialSpawn(world, difficulty, reason, livingdata, tag);
				double x = this.getPosX();
				double y = this.getPosY();
				double z = this.getPosZ();
				Entity entity = this;

				CrowOnInitialEntitySpawnProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return retval;
			}

			@Override
			protected void updateFallState(double y, boolean onGroundIn, BlockState state, BlockPos pos) {
			}

			@Override
			public void setNoGravity(boolean ignored) {
				super.setNoGravity(true);
			}

			public void livingTick() {
				super.livingTick();
				this.setNoGravity(true);
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class EarthGolemEntity extends NarutoShippudenModElements.ModElement {
		public static EntityType entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER)
				.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new)
				.size(1.5f, 3.5f)).build("earth_golem").setRegistryName("earth_golem");

		public EarthGolemEntity(NarutoShippudenModElements instance) {
			super(instance, 96);
			FMLJavaModLoadingContext.get().getModEventBus().register(new EarthGolemRenderer.ModelRegisterHandler());
			FMLJavaModLoadingContext.get().getModEventBus().register(new EntityAttributesRegisterHandler());
		}

		@Override
		public void initElements() {
			elements.entities.add(() -> entity);
		}

		@Override
		public void init(FMLCommonSetupEvent event) {
		}

		private static class EntityAttributesRegisterHandler {
			@SubscribeEvent
			public void onEntityAttributeCreation(EntityAttributeCreationEvent event) {
				AttributeModifierMap.MutableAttribute ammma = MobEntity.func_233666_p_();
				ammma = ammma.createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.3);
				ammma = ammma.createMutableAttribute(Attributes.MAX_HEALTH, 210);
				ammma = ammma.createMutableAttribute(Attributes.ARMOR, 0);
				ammma = ammma.createMutableAttribute(Attributes.ATTACK_DAMAGE, 5);
				ammma = ammma.createMutableAttribute(Attributes.FOLLOW_RANGE, 16);
				ammma = ammma.createMutableAttribute(Attributes.KNOCKBACK_RESISTANCE, 1);
				ammma = ammma.createMutableAttribute(Attributes.ATTACK_KNOCKBACK, 2);
				event.put(entity, ammma.create());
			}
		}

		public static class CustomEntity extends TameableEntity {
			public CustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
				this(entity, world);
			}

			public CustomEntity(EntityType<CustomEntity> type, World world) {
				super(type, world);
				experienceValue = 0;
				setNoAI(false);
				enablePersistence();
			}

			@Override
			public IPacket<?> createSpawnPacket() {
				return NetworkHooks.getEntitySpawningPacket(this);
			}

			@Override
			protected void registerGoals() {
				super.registerGoals();
				this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.2, true) {
					@Override
					protected double getAttackReachSqr(LivingEntity entity) {
						return (double) (4.0 + entity.getWidth() * entity.getWidth());
					}
				});
				this.goalSelector.addGoal(2, new OwnerHurtByTargetGoal(this));
				this.goalSelector.addGoal(3, new OwnerHurtTargetGoal(this));
				this.goalSelector.addGoal(4, new FollowOwnerGoal(this, 1, (float) 10, (float) 2, false));
				this.goalSelector.addGoal(5, new RandomWalkingGoal(this, 1));
				this.goalSelector.addGoal(6, new LookRandomlyGoal(this));
				this.goalSelector.addGoal(7, new SwimGoal(this));
			}

			@Override
			public CreatureAttribute getCreatureAttribute() {
				return CreatureAttribute.UNDEFINED;
			}

			@Override
			public boolean canDespawn(double distanceToClosestPlayer) {
				return false;
			}

			@Override
			public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
				return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.hurt"));
			}

			@Override
			public net.minecraft.util.SoundEvent getDeathSound() {
				return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.death"));
			}

			@Override
			public boolean attackEntityFrom(DamageSource source, float amount) {
				if (source == DamageSource.FALL)
					return false;
				if (source == DamageSource.DROWN)
					return false;
				return super.attackEntityFrom(source, amount);
			}

			@Override
			public ILivingEntityData onInitialSpawn(IServerWorld world, DifficultyInstance difficulty, SpawnReason reason,
					@Nullable ILivingEntityData livingdata, @Nullable CompoundNBT tag) {
				ILivingEntityData retval = super.onInitialSpawn(world, difficulty, reason, livingdata, tag);
				double x = this.getPosX();
				double y = this.getPosY();
				double z = this.getPosZ();
				Entity entity = this;

				EarthGolemOnInitialEntitySpawnProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return retval;
			}

			@Override
			public ActionResultType func_230254_b_(PlayerEntity sourceentity, Hand hand) {
				ItemStack itemstack = sourceentity.getHeldItem(hand);
				ActionResultType retval = ActionResultType.func_233537_a_(this.world.isRemote());
				Item item = itemstack.getItem();
				if (itemstack.getItem() instanceof SpawnEggItem) {
					retval = super.func_230254_b_(sourceentity, hand);
				} else if (this.world.isRemote()) {
					retval = (this.isTamed() && this.isOwner(sourceentity) || this.isBreedingItem(itemstack))
							? ActionResultType.func_233537_a_(this.world.isRemote())
							: ActionResultType.PASS;
				} else {
					if (this.isTamed()) {
						if (this.isOwner(sourceentity)) {
							if (item.isFood() && this.isBreedingItem(itemstack) && this.getHealth() < this.getMaxHealth()) {
								this.consumeItemFromStack(sourceentity, itemstack);
								this.heal((float) item.getFood().getHealing());
								retval = ActionResultType.func_233537_a_(this.world.isRemote());
							} else if (this.isBreedingItem(itemstack) && this.getHealth() < this.getMaxHealth()) {
								this.consumeItemFromStack(sourceentity, itemstack);
								this.heal(4);
								retval = ActionResultType.func_233537_a_(this.world.isRemote());
							} else {
								retval = super.func_230254_b_(sourceentity, hand);
							}
						}
					} else if (this.isBreedingItem(itemstack)) {
						this.consumeItemFromStack(sourceentity, itemstack);
						if (this.rand.nextInt(3) == 0 && !net.minecraftforge.event.ForgeEventFactory.onAnimalTame(this, sourceentity)) {
							this.setTamedBy(sourceentity);
							this.world.setEntityState(this, (byte) 7);
						} else {
							this.world.setEntityState(this, (byte) 6);
						}
						this.enablePersistence();
						retval = ActionResultType.func_233537_a_(this.world.isRemote());
					} else {
						retval = super.func_230254_b_(sourceentity, hand);
						if (retval == ActionResultType.SUCCESS || retval == ActionResultType.CONSUME)
							this.enablePersistence();
					}
				}
				return retval;
			}

			@Override
			public AgeableEntity func_241840_a(ServerWorld serverWorld, AgeableEntity ageable) {
				CustomEntity retval = (CustomEntity) entity.create(serverWorld);
				retval.onInitialSpawn(serverWorld, serverWorld.getDifficultyForLocation(new BlockPos(retval.getPosition())), SpawnReason.BREEDING,
						(ILivingEntityData) null, (CompoundNBT) null);
				return retval;
			}

			@Override
			public boolean isBreedingItem(ItemStack stack) {
				if (stack == null)
					return false;
				return false;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class KirinEntity extends NarutoShippudenModElements.ModElement {
		public static EntityType entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER)
				.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).immuneToFire()
				.size(3f, 3f)).build("kirin").setRegistryName("kirin");

		public KirinEntity(NarutoShippudenModElements instance) {
			super(instance, 75);
			FMLJavaModLoadingContext.get().getModEventBus().register(new KirinRenderer.ModelRegisterHandler());
			FMLJavaModLoadingContext.get().getModEventBus().register(new EntityAttributesRegisterHandler());
		}

		@Override
		public void initElements() {
			elements.entities.add(() -> entity);
		}

		@Override
		public void init(FMLCommonSetupEvent event) {
		}

		private static class EntityAttributesRegisterHandler {
			@SubscribeEvent
			public void onEntityAttributeCreation(EntityAttributeCreationEvent event) {
				AttributeModifierMap.MutableAttribute ammma = MobEntity.func_233666_p_();
				ammma = ammma.createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.3);
				ammma = ammma.createMutableAttribute(Attributes.MAX_HEALTH, 1000);
				ammma = ammma.createMutableAttribute(Attributes.ARMOR, 0);
				ammma = ammma.createMutableAttribute(Attributes.ATTACK_DAMAGE, 0);
				ammma = ammma.createMutableAttribute(Attributes.FOLLOW_RANGE, 16);
				event.put(entity, ammma.create());
			}
		}

		public static class CustomEntity extends CreatureEntity {
			public CustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
				this(entity, world);
			}

			public CustomEntity(EntityType<CustomEntity> type, World world) {
				super(type, world);
				experienceValue = 0;
				setNoAI(false);
				enablePersistence();
			}

			@Override
			public IPacket<?> createSpawnPacket() {
				return NetworkHooks.getEntitySpawningPacket(this);
			}

			@Override
			protected void registerGoals() {
				super.registerGoals();

			}

			@Override
			public CreatureAttribute getCreatureAttribute() {
				return CreatureAttribute.UNDEFINED;
			}

			@Override
			public boolean canDespawn(double distanceToClosestPlayer) {
				return false;
			}

			@Override
			public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
				return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(""));
			}

			@Override
			public net.minecraft.util.SoundEvent getDeathSound() {
				return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(""));
			}

			@Override
			public boolean onLivingFall(float l, float d) {
				double x = this.getPosX();
				double y = this.getPosY();
				double z = this.getPosZ();
				Entity entity = this;

				KirinEntityFallsProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z), new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return super.onLivingFall(l, d);
			}

			@Override
			public boolean attackEntityFrom(DamageSource source, float amount) {
				if (source.getImmediateSource() instanceof AbstractArrowEntity)
					return false;
				if (source.getImmediateSource() instanceof PlayerEntity)
					return false;
				if (source.getImmediateSource() instanceof PotionEntity || source.getImmediateSource() instanceof AreaEffectCloudEntity)
					return false;
				if (source == DamageSource.FALL)
					return false;
				if (source == DamageSource.CACTUS)
					return false;
				if (source == DamageSource.DROWN)
					return false;
				if (source == DamageSource.LIGHTNING_BOLT)
					return false;
				if (source.isExplosion())
					return false;
				if (source.getDamageType().equals("trident"))
					return false;
				if (source == DamageSource.ANVIL)
					return false;
				if (source == DamageSource.DRAGON_BREATH)
					return false;
				if (source == DamageSource.WITHER)
					return false;
				if (source.getDamageType().equals("witherSkull"))
					return false;
				return super.attackEntityFrom(source, amount);
			}

			@Override
			public ILivingEntityData onInitialSpawn(IServerWorld world, DifficultyInstance difficulty, SpawnReason reason,
					@Nullable ILivingEntityData livingdata, @Nullable CompoundNBT tag) {
				ILivingEntityData retval = super.onInitialSpawn(world, difficulty, reason, livingdata, tag);
				double x = this.getPosX();
				double y = this.getPosY();
				double z = this.getPosZ();
				Entity entity = this;

				RunningFireOnInitialEntitySpawnProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return retval;
			}

			@Override
			public boolean canBePushed() {
				return false;
			}

			@Override
			protected void collideWithEntity(Entity entityIn) {
			}

			@Override
			protected void collideWithNearbyEntities() {
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class KuramaEntity extends NarutoShippudenModElements.ModElement {
		public static EntityType entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER)
				.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).size(15f, 20f))
				.build("kurama").setRegistryName("kurama");

		public KuramaEntity(NarutoShippudenModElements instance) {
			super(instance, 153);
			FMLJavaModLoadingContext.get().getModEventBus().register(new KuramaRenderer.ModelRegisterHandler());
			FMLJavaModLoadingContext.get().getModEventBus().register(new EntityAttributesRegisterHandler());
		}

		@Override
		public void initElements() {
			elements.entities.add(() -> entity);
			elements.items.add(() -> new SpawnEggItem(entity, -1149696, -5302505, new Item.Properties().group(SpawnEggsItemGroup.tab))
					.setRegistryName("kurama_spawn_egg"));
		}

		@Override
		public void init(FMLCommonSetupEvent event) {
		}

		private static class EntityAttributesRegisterHandler {
			@SubscribeEvent
			public void onEntityAttributeCreation(EntityAttributeCreationEvent event) {
				AttributeModifierMap.MutableAttribute ammma = MobEntity.func_233666_p_();
				ammma = ammma.createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.3);
				ammma = ammma.createMutableAttribute(Attributes.MAX_HEALTH, 1000);
				ammma = ammma.createMutableAttribute(Attributes.ARMOR, 0);
				ammma = ammma.createMutableAttribute(Attributes.ATTACK_DAMAGE, 20);
				ammma = ammma.createMutableAttribute(Attributes.FOLLOW_RANGE, 16);
				ammma = ammma.createMutableAttribute(Attributes.KNOCKBACK_RESISTANCE, 1);
				ammma = ammma.createMutableAttribute(Attributes.ATTACK_KNOCKBACK, 2);
				event.put(entity, ammma.create());
			}
		}

		public static class CustomEntity extends MonsterEntity implements IRangedAttackMob {
			public CustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
				this(entity, world);
			}

			public CustomEntity(EntityType<CustomEntity> type, World world) {
				super(type, world);
				experienceValue = 0;
				setNoAI(false);
				enablePersistence();
			}

			@Override
			public IPacket<?> createSpawnPacket() {
				return NetworkHooks.getEntitySpawningPacket(this);
			}

			@Override
			protected void registerGoals() {
				super.registerGoals();
				this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
				this.targetSelector.addGoal(2, new NearestAttackableTargetGoal(this, PlayerEntity.class, false, false));
				this.targetSelector.addGoal(3, new NearestAttackableTargetGoal(this, ServerPlayerEntity.class, false, false));
				this.goalSelector.addGoal(4, new LeapAtTargetGoal(this, (float) 0.2));
				this.goalSelector.addGoal(5, new LookRandomlyGoal(this));
				this.goalSelector.addGoal(6, new SwimGoal(this));
				this.goalSelector.addGoal(1, new RangedAttackGoal(this, 1.25, 20, 10) {
					@Override
					public boolean shouldContinueExecuting() {
						return this.shouldExecute();
					}
				});
			}

			@Override
			public CreatureAttribute getCreatureAttribute() {
				return CreatureAttribute.UNDEFINED;
			}

			@Override
			public boolean canDespawn(double distanceToClosestPlayer) {
				return false;
			}

			@Override
			public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
				return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.hurt"));
			}

			@Override
			public net.minecraft.util.SoundEvent getDeathSound() {
				return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.death"));
			}

			@Override
			public boolean attackEntityFrom(DamageSource source, float amount) {
				if (source.getImmediateSource() instanceof PotionEntity || source.getImmediateSource() instanceof AreaEffectCloudEntity)
					return false;
				if (source == DamageSource.FALL)
					return false;
				if (source == DamageSource.CACTUS)
					return false;
				if (source == DamageSource.DROWN)
					return false;
				if (source == DamageSource.LIGHTNING_BOLT)
					return false;
				if (source.isExplosion())
					return false;
				if (source.getDamageType().equals("trident"))
					return false;
				if (source == DamageSource.ANVIL)
					return false;
				if (source == DamageSource.DRAGON_BREATH)
					return false;
				if (source == DamageSource.WITHER)
					return false;
				if (source.getDamageType().equals("witherSkull"))
					return false;
				return super.attackEntityFrom(source, amount);
			}

			@Override
			public void baseTick() {
				super.baseTick();
				double x = this.getPosX();
				double y = this.getPosY();
				double z = this.getPosZ();
				Entity entity = this;

				KuramaOnInitialEntitySpawnProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}

			public void attackEntityWithRangedAttack(LivingEntity target, float flval) {
				TailedBeastBombItem.shoot(this, target);
			}

			@Override
			public boolean isNonBoss() {
				return false;
			}

			private final ServerBossInfo bossInfo = new ServerBossInfo(this.getDisplayName(), BossInfo.Color.YELLOW, BossInfo.Overlay.PROGRESS);

			@Override
			public void addTrackingPlayer(ServerPlayerEntity player) {
				super.addTrackingPlayer(player);
				this.bossInfo.addPlayer(player);
			}

			@Override
			public void removeTrackingPlayer(ServerPlayerEntity player) {
				super.removeTrackingPlayer(player);
				this.bossInfo.removePlayer(player);
			}

			@Override
			public void updateAITasks() {
				super.updateAITasks();
				this.bossInfo.setPercent(this.getHealth() / this.getMaxHealth());
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class MonsterCatEntity extends NarutoShippudenModElements.ModElement {
		public static EntityType entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER)
				.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).immuneToFire()
				.size(0.5f, 1.7f)).build("monster_cat").setRegistryName("monster_cat");

		public MonsterCatEntity(NarutoShippudenModElements instance) {
			super(instance, 840);
			FMLJavaModLoadingContext.get().getModEventBus().register(new MonsterCatRenderer.ModelRegisterHandler());
			FMLJavaModLoadingContext.get().getModEventBus().register(new EntityAttributesRegisterHandler());
		}

		@Override
		public void initElements() {
			elements.entities.add(() -> entity);
		}

		@Override
		public void init(FMLCommonSetupEvent event) {
		}

		private static class EntityAttributesRegisterHandler {
			@SubscribeEvent
			public void onEntityAttributeCreation(EntityAttributeCreationEvent event) {
				AttributeModifierMap.MutableAttribute ammma = MobEntity.func_233666_p_();
				ammma = ammma.createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.25);
				ammma = ammma.createMutableAttribute(Attributes.MAX_HEALTH, 300);
				ammma = ammma.createMutableAttribute(Attributes.ARMOR, 0);
				ammma = ammma.createMutableAttribute(Attributes.ATTACK_DAMAGE, 9);
				ammma = ammma.createMutableAttribute(Attributes.FOLLOW_RANGE, 16);
				event.put(entity, ammma.create());
			}
		}

		public static class CustomEntity extends CreatureEntity {
			public CustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
				this(entity, world);
			}

			public CustomEntity(EntityType<CustomEntity> type, World world) {
				super(type, world);
				experienceValue = 0;
				setNoAI(false);
				enablePersistence();
			}

			@Override
			public IPacket<?> createSpawnPacket() {
				return NetworkHooks.getEntitySpawningPacket(this);
			}

			@Override
			protected void registerGoals() {
				super.registerGoals();

			}

			@Override
			public CreatureAttribute getCreatureAttribute() {
				return CreatureAttribute.UNDEFINED;
			}

			@Override
			public boolean canDespawn(double distanceToClosestPlayer) {
				return false;
			}

			@Override
			public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
				return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(""));
			}

			@Override
			public net.minecraft.util.SoundEvent getDeathSound() {
				return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(""));
			}

			@Override
			public boolean attackEntityFrom(DamageSource source, float amount) {
				if (source.getImmediateSource() instanceof AbstractArrowEntity)
					return false;
				if (source.getImmediateSource() instanceof PlayerEntity)
					return false;
				if (source.getImmediateSource() instanceof PotionEntity || source.getImmediateSource() instanceof AreaEffectCloudEntity)
					return false;
				if (source == DamageSource.FALL)
					return false;
				if (source == DamageSource.CACTUS)
					return false;
				if (source == DamageSource.DROWN)
					return false;
				if (source == DamageSource.LIGHTNING_BOLT)
					return false;
				if (source.isExplosion())
					return false;
				if (source.getDamageType().equals("trident"))
					return false;
				if (source == DamageSource.ANVIL)
					return false;
				if (source == DamageSource.DRAGON_BREATH)
					return false;
				if (source == DamageSource.WITHER)
					return false;
				if (source.getDamageType().equals("witherSkull"))
					return false;
				return super.attackEntityFrom(source, amount);
			}

			@Override
			public ActionResultType func_230254_b_(PlayerEntity sourceentity, Hand hand) {
				ItemStack itemstack = sourceentity.getHeldItem(hand);
				ActionResultType retval = ActionResultType.func_233537_a_(this.world.isRemote());
				super.func_230254_b_(sourceentity, hand);
				sourceentity.startRiding(this);
				return retval;
			}

			@Override
			public boolean canBePushed() {
				return false;
			}

			@Override
			protected void collideWithEntity(Entity entityIn) {
			}

			@Override
			protected void collideWithNearbyEntities() {
			}

			@Override
			public void travel(Vector3d dir) {
				Entity entity = this.getPassengers().isEmpty() ? null : (Entity) this.getPassengers().get(0);
				if (this.isBeingRidden()) {
					this.rotationYaw = entity.rotationYaw;
					this.prevRotationYaw = this.rotationYaw;
					this.rotationPitch = entity.rotationPitch * 0.5F;
					this.setRotation(this.rotationYaw, this.rotationPitch);
					this.jumpMovementFactor = this.getAIMoveSpeed() * 0.15F;
					this.renderYawOffset = entity.rotationYaw;
					this.rotationYawHead = entity.rotationYaw;
					this.stepHeight = 1.0F;
					if (entity instanceof LivingEntity) {
						this.setAIMoveSpeed((float) this.getAttributeValue(Attributes.MOVEMENT_SPEED));
						float forward = ((LivingEntity) entity).moveForward;
						float strafe = 0;
						super.travel(new Vector3d(strafe, 0, forward));
					}
					this.prevLimbSwingAmount = this.limbSwingAmount;
					double d1 = this.getPosX() - this.prevPosX;
					double d0 = this.getPosZ() - this.prevPosZ;
					float f1 = MathHelper.sqrt(d1 * d1 + d0 * d0) * 4.0F;
					if (f1 > 1.0F)
						f1 = 1.0F;
					this.limbSwingAmount += (f1 - this.limbSwingAmount) * 0.4F;
					this.limbSwing += this.limbSwingAmount;
					return;
				}
				this.stepHeight = 0.5F;
				this.jumpMovementFactor = 0.02F;
				super.travel(dir);
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class ThreeHeadAkamaruEntity extends NarutoShippudenModElements.ModElement {
		public static EntityType entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER)
				.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).immuneToFire()
				.size(0.7f, 0.7f)).build("three_head_akamaru").setRegistryName("three_head_akamaru");

		public ThreeHeadAkamaruEntity(NarutoShippudenModElements instance) {
			super(instance, 1332);
			FMLJavaModLoadingContext.get().getModEventBus().register(new ThreeHeadAkamaruRenderer.ModelRegisterHandler());
			FMLJavaModLoadingContext.get().getModEventBus().register(new EntityAttributesRegisterHandler());
		}

		@Override
		public void initElements() {
			elements.entities.add(() -> entity);
		}

		@Override
		public void init(FMLCommonSetupEvent event) {
		}

		private static class EntityAttributesRegisterHandler {
			@SubscribeEvent
			public void onEntityAttributeCreation(EntityAttributeCreationEvent event) {
				AttributeModifierMap.MutableAttribute ammma = MobEntity.func_233666_p_();
				ammma = ammma.createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.25);
				ammma = ammma.createMutableAttribute(Attributes.MAX_HEALTH, 300);
				ammma = ammma.createMutableAttribute(Attributes.ARMOR, 0);
				ammma = ammma.createMutableAttribute(Attributes.ATTACK_DAMAGE, 9);
				ammma = ammma.createMutableAttribute(Attributes.FOLLOW_RANGE, 16);
				event.put(entity, ammma.create());
			}
		}

		public static class CustomEntity extends TameableEntity {
			public CustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
				this(entity, world);
			}

			public CustomEntity(EntityType<CustomEntity> type, World world) {
				super(type, world);
				experienceValue = 0;
				setNoAI(false);
				enablePersistence();
			}

			@Override
			public IPacket<?> createSpawnPacket() {
				return NetworkHooks.getEntitySpawningPacket(this);
			}

			@Override
			protected void registerGoals() {
				super.registerGoals();
				this.goalSelector.addGoal(1, new RandomWalkingGoal(this, 1));
				this.goalSelector.addGoal(2, new LookAtGoal(this, PlayerEntity.class, (float) 6));
				this.goalSelector.addGoal(3, new LookAtGoal(this, ServerPlayerEntity.class, (float) 6));
				this.goalSelector.addGoal(4, new LookRandomlyGoal(this));
				this.goalSelector.addGoal(5, new SwimGoal(this));
			}

			@Override
			public CreatureAttribute getCreatureAttribute() {
				return CreatureAttribute.UNDEFINED;
			}

			@Override
			public boolean canDespawn(double distanceToClosestPlayer) {
				return false;
			}

			@Override
			public net.minecraft.util.SoundEvent getAmbientSound() {
				return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wolf.growl"));
			}

			@Override
			public void playStepSound(BlockPos pos, BlockState blockIn) {
				this.playSound((net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wolf.step")), 0.15f, 1);
			}

			@Override
			public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
				return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wolf.hurt"));
			}

			@Override
			public net.minecraft.util.SoundEvent getDeathSound() {
				return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wolf.death"));
			}

			@Override
			public boolean attackEntityFrom(DamageSource source, float amount) {
				if (source.getImmediateSource() instanceof AbstractArrowEntity)
					return false;
				if (source.getImmediateSource() instanceof PlayerEntity)
					return false;
				if (source.getImmediateSource() instanceof PotionEntity || source.getImmediateSource() instanceof AreaEffectCloudEntity)
					return false;
				if (source == DamageSource.FALL)
					return false;
				if (source == DamageSource.CACTUS)
					return false;
				if (source == DamageSource.DROWN)
					return false;
				if (source == DamageSource.LIGHTNING_BOLT)
					return false;
				if (source.isExplosion())
					return false;
				if (source.getDamageType().equals("trident"))
					return false;
				if (source == DamageSource.ANVIL)
					return false;
				if (source == DamageSource.DRAGON_BREATH)
					return false;
				if (source == DamageSource.WITHER)
					return false;
				if (source.getDamageType().equals("witherSkull"))
					return false;
				return super.attackEntityFrom(source, amount);
			}

			@Override
			public ActionResultType func_230254_b_(PlayerEntity sourceentity, Hand hand) {
				ItemStack itemstack = sourceentity.getHeldItem(hand);
				ActionResultType retval = ActionResultType.func_233537_a_(this.world.isRemote());
				Item item = itemstack.getItem();
				if (itemstack.getItem() instanceof SpawnEggItem) {
					retval = super.func_230254_b_(sourceentity, hand);
				} else if (this.world.isRemote()) {
					retval = (this.isTamed() && this.isOwner(sourceentity) || this.isBreedingItem(itemstack))
							? ActionResultType.func_233537_a_(this.world.isRemote())
							: ActionResultType.PASS;
				} else {
					if (this.isTamed()) {
						if (this.isOwner(sourceentity)) {
							if (item.isFood() && this.isBreedingItem(itemstack) && this.getHealth() < this.getMaxHealth()) {
								this.consumeItemFromStack(sourceentity, itemstack);
								this.heal((float) item.getFood().getHealing());
								retval = ActionResultType.func_233537_a_(this.world.isRemote());
							} else if (this.isBreedingItem(itemstack) && this.getHealth() < this.getMaxHealth()) {
								this.consumeItemFromStack(sourceentity, itemstack);
								this.heal(4);
								retval = ActionResultType.func_233537_a_(this.world.isRemote());
							} else {
								retval = super.func_230254_b_(sourceentity, hand);
							}
						}
					} else if (this.isBreedingItem(itemstack)) {
						this.consumeItemFromStack(sourceentity, itemstack);
						if (this.rand.nextInt(3) == 0 && !net.minecraftforge.event.ForgeEventFactory.onAnimalTame(this, sourceentity)) {
							this.setTamedBy(sourceentity);
							this.world.setEntityState(this, (byte) 7);
						} else {
							this.world.setEntityState(this, (byte) 6);
						}
						this.enablePersistence();
						retval = ActionResultType.func_233537_a_(this.world.isRemote());
					} else {
						retval = super.func_230254_b_(sourceentity, hand);
						if (retval == ActionResultType.SUCCESS || retval == ActionResultType.CONSUME)
							this.enablePersistence();
					}
				}
				sourceentity.startRiding(this);
				return retval;
			}

			@Override
			public AgeableEntity func_241840_a(ServerWorld serverWorld, AgeableEntity ageable) {
				CustomEntity retval = (CustomEntity) entity.create(serverWorld);
				retval.onInitialSpawn(serverWorld, serverWorld.getDifficultyForLocation(new BlockPos(retval.getPosition())), SpawnReason.BREEDING,
						(ILivingEntityData) null, (CompoundNBT) null);
				return retval;
			}

			@Override
			public boolean isBreedingItem(ItemStack stack) {
				if (stack == null)
					return false;
				return false;
			}

			@Override
			public boolean canBePushed() {
				return false;
			}

			@Override
			protected void collideWithEntity(Entity entityIn) {
			}

			@Override
			protected void collideWithNearbyEntities() {
			}

			@Override
			public void travel(Vector3d dir) {
				Entity entity = this.getPassengers().isEmpty() ? null : (Entity) this.getPassengers().get(0);
				if (this.isBeingRidden()) {
					this.rotationYaw = entity.rotationYaw;
					this.prevRotationYaw = this.rotationYaw;
					this.rotationPitch = entity.rotationPitch * 0.5F;
					this.setRotation(this.rotationYaw, this.rotationPitch);
					this.jumpMovementFactor = this.getAIMoveSpeed() * 0.15F;
					this.renderYawOffset = entity.rotationYaw;
					this.rotationYawHead = entity.rotationYaw;
					this.stepHeight = 1.0F;
					if (entity instanceof LivingEntity) {
						this.setAIMoveSpeed((float) this.getAttributeValue(Attributes.MOVEMENT_SPEED));
						float forward = ((LivingEntity) entity).moveForward;
						float strafe = 0;
						super.travel(new Vector3d(strafe, 0, forward));
					}
					this.prevLimbSwingAmount = this.limbSwingAmount;
					double d1 = this.getPosX() - this.prevPosX;
					double d0 = this.getPosZ() - this.prevPosZ;
					float f1 = MathHelper.sqrt(d1 * d1 + d0 * d0) * 4.0F;
					if (f1 > 1.0F)
						f1 = 1.0F;
					this.limbSwingAmount += (f1 - this.limbSwingAmount) * 0.4F;
					this.limbSwing += this.limbSwingAmount;
					return;
				}
				this.stepHeight = 0.5F;
				this.jumpMovementFactor = 0.02F;
				super.travel(dir);
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class TwoHeadAkamaruEntity extends NarutoShippudenModElements.ModElement {
		public static EntityType entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER)
				.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).immuneToFire()
				.size(0.7f, 0.7f)).build("two_head_akamaru").setRegistryName("two_head_akamaru");

		public TwoHeadAkamaruEntity(NarutoShippudenModElements instance) {
			super(instance, 563);
			FMLJavaModLoadingContext.get().getModEventBus().register(new TwoHeadAkamaruRenderer.ModelRegisterHandler());
			FMLJavaModLoadingContext.get().getModEventBus().register(new EntityAttributesRegisterHandler());
		}

		@Override
		public void initElements() {
			elements.entities.add(() -> entity);
		}

		@Override
		public void init(FMLCommonSetupEvent event) {
		}

		private static class EntityAttributesRegisterHandler {
			@SubscribeEvent
			public void onEntityAttributeCreation(EntityAttributeCreationEvent event) {
				AttributeModifierMap.MutableAttribute ammma = MobEntity.func_233666_p_();
				ammma = ammma.createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.25);
				ammma = ammma.createMutableAttribute(Attributes.MAX_HEALTH, 300);
				ammma = ammma.createMutableAttribute(Attributes.ARMOR, 0);
				ammma = ammma.createMutableAttribute(Attributes.ATTACK_DAMAGE, 9);
				ammma = ammma.createMutableAttribute(Attributes.FOLLOW_RANGE, 16);
				event.put(entity, ammma.create());
			}
		}

		public static class CustomEntity extends TameableEntity {
			public CustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
				this(entity, world);
			}

			public CustomEntity(EntityType<CustomEntity> type, World world) {
				super(type, world);
				experienceValue = 0;
				setNoAI(false);
				enablePersistence();
			}

			@Override
			public IPacket<?> createSpawnPacket() {
				return NetworkHooks.getEntitySpawningPacket(this);
			}

			@Override
			protected void registerGoals() {
				super.registerGoals();
				this.goalSelector.addGoal(1, new RandomWalkingGoal(this, 1));
				this.goalSelector.addGoal(2, new LookAtGoal(this, PlayerEntity.class, (float) 6));
				this.goalSelector.addGoal(3, new LookAtGoal(this, ServerPlayerEntity.class, (float) 6));
				this.goalSelector.addGoal(4, new LookRandomlyGoal(this));
				this.goalSelector.addGoal(5, new SwimGoal(this));
			}

			@Override
			public CreatureAttribute getCreatureAttribute() {
				return CreatureAttribute.UNDEFINED;
			}

			@Override
			public boolean canDespawn(double distanceToClosestPlayer) {
				return false;
			}

			@Override
			public net.minecraft.util.SoundEvent getAmbientSound() {
				return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wolf.growl"));
			}

			@Override
			public void playStepSound(BlockPos pos, BlockState blockIn) {
				this.playSound((net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wolf.step")), 0.15f, 1);
			}

			@Override
			public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
				return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wolf.hurt"));
			}

			@Override
			public net.minecraft.util.SoundEvent getDeathSound() {
				return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wolf.death"));
			}

			@Override
			public boolean attackEntityFrom(DamageSource source, float amount) {
				if (source.getImmediateSource() instanceof AbstractArrowEntity)
					return false;
				if (source.getImmediateSource() instanceof PlayerEntity)
					return false;
				if (source.getImmediateSource() instanceof PotionEntity || source.getImmediateSource() instanceof AreaEffectCloudEntity)
					return false;
				if (source == DamageSource.FALL)
					return false;
				if (source == DamageSource.CACTUS)
					return false;
				if (source == DamageSource.DROWN)
					return false;
				if (source == DamageSource.LIGHTNING_BOLT)
					return false;
				if (source.isExplosion())
					return false;
				if (source.getDamageType().equals("trident"))
					return false;
				if (source == DamageSource.ANVIL)
					return false;
				if (source == DamageSource.DRAGON_BREATH)
					return false;
				if (source == DamageSource.WITHER)
					return false;
				if (source.getDamageType().equals("witherSkull"))
					return false;
				return super.attackEntityFrom(source, amount);
			}

			@Override
			public ActionResultType func_230254_b_(PlayerEntity sourceentity, Hand hand) {
				ItemStack itemstack = sourceentity.getHeldItem(hand);
				ActionResultType retval = ActionResultType.func_233537_a_(this.world.isRemote());
				Item item = itemstack.getItem();
				if (itemstack.getItem() instanceof SpawnEggItem) {
					retval = super.func_230254_b_(sourceentity, hand);
				} else if (this.world.isRemote()) {
					retval = (this.isTamed() && this.isOwner(sourceentity) || this.isBreedingItem(itemstack))
							? ActionResultType.func_233537_a_(this.world.isRemote())
							: ActionResultType.PASS;
				} else {
					if (this.isTamed()) {
						if (this.isOwner(sourceentity)) {
							if (item.isFood() && this.isBreedingItem(itemstack) && this.getHealth() < this.getMaxHealth()) {
								this.consumeItemFromStack(sourceentity, itemstack);
								this.heal((float) item.getFood().getHealing());
								retval = ActionResultType.func_233537_a_(this.world.isRemote());
							} else if (this.isBreedingItem(itemstack) && this.getHealth() < this.getMaxHealth()) {
								this.consumeItemFromStack(sourceentity, itemstack);
								this.heal(4);
								retval = ActionResultType.func_233537_a_(this.world.isRemote());
							} else {
								retval = super.func_230254_b_(sourceentity, hand);
							}
						}
					} else if (this.isBreedingItem(itemstack)) {
						this.consumeItemFromStack(sourceentity, itemstack);
						if (this.rand.nextInt(3) == 0 && !net.minecraftforge.event.ForgeEventFactory.onAnimalTame(this, sourceentity)) {
							this.setTamedBy(sourceentity);
							this.world.setEntityState(this, (byte) 7);
						} else {
							this.world.setEntityState(this, (byte) 6);
						}
						this.enablePersistence();
						retval = ActionResultType.func_233537_a_(this.world.isRemote());
					} else {
						retval = super.func_230254_b_(sourceentity, hand);
						if (retval == ActionResultType.SUCCESS || retval == ActionResultType.CONSUME)
							this.enablePersistence();
					}
				}
				sourceentity.startRiding(this);
				return retval;
			}

			@Override
			public AgeableEntity func_241840_a(ServerWorld serverWorld, AgeableEntity ageable) {
				CustomEntity retval = (CustomEntity) entity.create(serverWorld);
				retval.onInitialSpawn(serverWorld, serverWorld.getDifficultyForLocation(new BlockPos(retval.getPosition())), SpawnReason.BREEDING,
						(ILivingEntityData) null, (CompoundNBT) null);
				return retval;
			}

			@Override
			public boolean isBreedingItem(ItemStack stack) {
				if (stack == null)
					return false;
				return false;
			}

			@Override
			public boolean canBePushed() {
				return false;
			}

			@Override
			protected void collideWithEntity(Entity entityIn) {
			}

			@Override
			protected void collideWithNearbyEntities() {
			}

			@Override
			public void travel(Vector3d dir) {
				Entity entity = this.getPassengers().isEmpty() ? null : (Entity) this.getPassengers().get(0);
				if (this.isBeingRidden()) {
					this.rotationYaw = entity.rotationYaw;
					this.prevRotationYaw = this.rotationYaw;
					this.rotationPitch = entity.rotationPitch * 0.5F;
					this.setRotation(this.rotationYaw, this.rotationPitch);
					this.jumpMovementFactor = this.getAIMoveSpeed() * 0.15F;
					this.renderYawOffset = entity.rotationYaw;
					this.rotationYawHead = entity.rotationYaw;
					this.stepHeight = 1.0F;
					if (entity instanceof LivingEntity) {
						this.setAIMoveSpeed((float) this.getAttributeValue(Attributes.MOVEMENT_SPEED));
						float forward = ((LivingEntity) entity).moveForward;
						float strafe = 0;
						super.travel(new Vector3d(strafe, 0, forward));
					}
					this.prevLimbSwingAmount = this.limbSwingAmount;
					double d1 = this.getPosX() - this.prevPosX;
					double d0 = this.getPosZ() - this.prevPosZ;
					float f1 = MathHelper.sqrt(d1 * d1 + d0 * d0) * 4.0F;
					if (f1 > 1.0F)
						f1 = 1.0F;
					this.limbSwingAmount += (f1 - this.limbSwingAmount) * 0.4F;
					this.limbSwing += this.limbSwingAmount;
					return;
				}
				this.stepHeight = 0.5F;
				this.jumpMovementFactor = 0.02F;
				super.travel(dir);
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class WolfEntity extends NarutoShippudenModElements.ModElement {
		public static EntityType entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER)
				.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).immuneToFire()
				.size(0.5f, 1.7f)).build("wolf").setRegistryName("wolf");

		public WolfEntity(NarutoShippudenModElements instance) {
			super(instance, 834);
			FMLJavaModLoadingContext.get().getModEventBus().register(new WolfRenderer.ModelRegisterHandler());
			FMLJavaModLoadingContext.get().getModEventBus().register(new EntityAttributesRegisterHandler());
		}

		@Override
		public void initElements() {
			elements.entities.add(() -> entity);
		}

		@Override
		public void init(FMLCommonSetupEvent event) {
		}

		private static class EntityAttributesRegisterHandler {
			@SubscribeEvent
			public void onEntityAttributeCreation(EntityAttributeCreationEvent event) {
				AttributeModifierMap.MutableAttribute ammma = MobEntity.func_233666_p_();
				ammma = ammma.createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.25);
				ammma = ammma.createMutableAttribute(Attributes.MAX_HEALTH, 300);
				ammma = ammma.createMutableAttribute(Attributes.ARMOR, 0);
				ammma = ammma.createMutableAttribute(Attributes.ATTACK_DAMAGE, 9);
				ammma = ammma.createMutableAttribute(Attributes.FOLLOW_RANGE, 16);
				event.put(entity, ammma.create());
			}
		}

		public static class CustomEntity extends CreatureEntity {
			public CustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
				this(entity, world);
			}

			public CustomEntity(EntityType<CustomEntity> type, World world) {
				super(type, world);
				experienceValue = 0;
				setNoAI(false);
				enablePersistence();
			}

			@Override
			public IPacket<?> createSpawnPacket() {
				return NetworkHooks.getEntitySpawningPacket(this);
			}

			@Override
			protected void registerGoals() {
				super.registerGoals();

			}

			@Override
			public CreatureAttribute getCreatureAttribute() {
				return CreatureAttribute.UNDEFINED;
			}

			@Override
			public boolean canDespawn(double distanceToClosestPlayer) {
				return false;
			}

			@Override
			public net.minecraft.util.SoundEvent getAmbientSound() {
				return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wolf.growl"));
			}

			@Override
			public void playStepSound(BlockPos pos, BlockState blockIn) {
				this.playSound((net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wolf.step")), 0.15f, 1);
			}

			@Override
			public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
				return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wolf.hurt"));
			}

			@Override
			public net.minecraft.util.SoundEvent getDeathSound() {
				return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wolf.death"));
			}

			@Override
			public boolean attackEntityFrom(DamageSource source, float amount) {
				if (source.getImmediateSource() instanceof AbstractArrowEntity)
					return false;
				if (source.getImmediateSource() instanceof PlayerEntity)
					return false;
				if (source.getImmediateSource() instanceof PotionEntity || source.getImmediateSource() instanceof AreaEffectCloudEntity)
					return false;
				if (source == DamageSource.FALL)
					return false;
				if (source == DamageSource.CACTUS)
					return false;
				if (source == DamageSource.DROWN)
					return false;
				if (source == DamageSource.LIGHTNING_BOLT)
					return false;
				if (source.isExplosion())
					return false;
				if (source.getDamageType().equals("trident"))
					return false;
				if (source == DamageSource.ANVIL)
					return false;
				if (source == DamageSource.DRAGON_BREATH)
					return false;
				if (source == DamageSource.WITHER)
					return false;
				if (source.getDamageType().equals("witherSkull"))
					return false;
				return super.attackEntityFrom(source, amount);
			}

			@Override
			public ActionResultType func_230254_b_(PlayerEntity sourceentity, Hand hand) {
				ItemStack itemstack = sourceentity.getHeldItem(hand);
				ActionResultType retval = ActionResultType.func_233537_a_(this.world.isRemote());
				super.func_230254_b_(sourceentity, hand);
				sourceentity.startRiding(this);
				return retval;
			}

			@Override
			public boolean canBePushed() {
				return false;
			}

			@Override
			protected void collideWithEntity(Entity entityIn) {
			}

			@Override
			protected void collideWithNearbyEntities() {
			}

			@Override
			public void travel(Vector3d dir) {
				Entity entity = this.getPassengers().isEmpty() ? null : (Entity) this.getPassengers().get(0);
				if (this.isBeingRidden()) {
					this.rotationYaw = entity.rotationYaw;
					this.prevRotationYaw = this.rotationYaw;
					this.rotationPitch = entity.rotationPitch * 0.5F;
					this.setRotation(this.rotationYaw, this.rotationPitch);
					this.jumpMovementFactor = this.getAIMoveSpeed() * 0.15F;
					this.renderYawOffset = entity.rotationYaw;
					this.rotationYawHead = entity.rotationYaw;
					this.stepHeight = 1.0F;
					if (entity instanceof LivingEntity) {
						this.setAIMoveSpeed((float) this.getAttributeValue(Attributes.MOVEMENT_SPEED));
						float forward = ((LivingEntity) entity).moveForward;
						float strafe = 0;
						super.travel(new Vector3d(strafe, 0, forward));
					}
					this.prevLimbSwingAmount = this.limbSwingAmount;
					double d1 = this.getPosX() - this.prevPosX;
					double d0 = this.getPosZ() - this.prevPosZ;
					float f1 = MathHelper.sqrt(d1 * d1 + d0 * d0) * 4.0F;
					if (f1 > 1.0F)
						f1 = 1.0F;
					this.limbSwingAmount += (f1 - this.limbSwingAmount) * 0.4F;
					this.limbSwing += this.limbSwingAmount;
					return;
				}
				this.stepHeight = 0.5F;
				this.jumpMovementFactor = 0.02F;
				super.travel(dir);
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class WoodGolemEntity extends NarutoShippudenModElements.ModElement {
		public static EntityType entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER)
				.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).size(3f, 7f))
				.build("wood_golem").setRegistryName("wood_golem");

		public WoodGolemEntity(NarutoShippudenModElements instance) {
			super(instance, 802);
			FMLJavaModLoadingContext.get().getModEventBus().register(new WoodGolemRenderer.ModelRegisterHandler());
			FMLJavaModLoadingContext.get().getModEventBus().register(new EntityAttributesRegisterHandler());
		}

		@Override
		public void initElements() {
			elements.entities.add(() -> entity);
		}

		@Override
		public void init(FMLCommonSetupEvent event) {
		}

		private static class EntityAttributesRegisterHandler {
			@SubscribeEvent
			public void onEntityAttributeCreation(EntityAttributeCreationEvent event) {
				AttributeModifierMap.MutableAttribute ammma = MobEntity.func_233666_p_();
				ammma = ammma.createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.3);
				ammma = ammma.createMutableAttribute(Attributes.MAX_HEALTH, 300);
				ammma = ammma.createMutableAttribute(Attributes.ARMOR, 0);
				ammma = ammma.createMutableAttribute(Attributes.ATTACK_DAMAGE, 15);
				ammma = ammma.createMutableAttribute(Attributes.FOLLOW_RANGE, 16);
				ammma = ammma.createMutableAttribute(Attributes.KNOCKBACK_RESISTANCE, 1);
				ammma = ammma.createMutableAttribute(Attributes.ATTACK_KNOCKBACK, 2);
				event.put(entity, ammma.create());
			}
		}

		public static class CustomEntity extends TameableEntity {
			public CustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
				this(entity, world);
			}

			public CustomEntity(EntityType<CustomEntity> type, World world) {
				super(type, world);
				experienceValue = 0;
				setNoAI(false);
				enablePersistence();
			}

			@Override
			public IPacket<?> createSpawnPacket() {
				return NetworkHooks.getEntitySpawningPacket(this);
			}

			@Override
			protected void registerGoals() {
				super.registerGoals();
				this.goalSelector.addGoal(1, new Goal() {
					{
						this.setMutexFlags(EnumSet.of(Goal.Flag.MOVE));
					}

					public boolean shouldExecute() {
						if (CustomEntity.this.getAttackTarget() != null && !CustomEntity.this.getMoveHelper().isUpdating()) {
							return true;
						} else {
							return false;
						}
					}

					@Override
					public boolean shouldContinueExecuting() {
						return CustomEntity.this.getMoveHelper().isUpdating() && CustomEntity.this.getAttackTarget() != null
								&& CustomEntity.this.getAttackTarget().isAlive();
					}

					@Override
					public void startExecuting() {
						LivingEntity livingentity = CustomEntity.this.getAttackTarget();
						Vector3d vec3d = livingentity.getEyePosition(1);
						CustomEntity.this.moveController.setMoveTo(vec3d.x, vec3d.y, vec3d.z, 1);
					}

					@Override
					public void tick() {
						LivingEntity livingentity = CustomEntity.this.getAttackTarget();
						if (CustomEntity.this.getBoundingBox().intersects(livingentity.getBoundingBox())) {
							CustomEntity.this.attackEntityAsMob(livingentity);
						} else {
							double d0 = CustomEntity.this.getDistanceSq(livingentity);
							if (d0 < 16) {
								Vector3d vec3d = livingentity.getEyePosition(1);
								CustomEntity.this.moveController.setMoveTo(vec3d.x, vec3d.y, vec3d.z, 1);
							}
						}
					}
				});
				this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.2, false) {
					@Override
					protected double getAttackReachSqr(LivingEntity entity) {
						return (double) (4.0 + entity.getWidth() * entity.getWidth());
					}
				});
				this.goalSelector.addGoal(3, new OwnerHurtByTargetGoal(this));
				this.goalSelector.addGoal(4, new OwnerHurtTargetGoal(this));
				this.goalSelector.addGoal(5, new FollowOwnerGoal(this, 1, (float) 10, (float) 2, false));
				this.goalSelector.addGoal(6, new RandomWalkingGoal(this, 1));
				this.goalSelector.addGoal(7, new LookRandomlyGoal(this));
				this.goalSelector.addGoal(8, new SwimGoal(this));
			}

			@Override
			public CreatureAttribute getCreatureAttribute() {
				return CreatureAttribute.UNDEFINED;
			}

			@Override
			public boolean canDespawn(double distanceToClosestPlayer) {
				return false;
			}

			@Override
			public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
				return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.hurt"));
			}

			@Override
			public net.minecraft.util.SoundEvent getDeathSound() {
				return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.death"));
			}

			@Override
			public boolean attackEntityFrom(DamageSource source, float amount) {
				if (source == DamageSource.FALL)
					return false;
				if (source == DamageSource.DROWN)
					return false;
				return super.attackEntityFrom(source, amount);
			}

			@Override
			public ILivingEntityData onInitialSpawn(IServerWorld world, DifficultyInstance difficulty, SpawnReason reason,
					@Nullable ILivingEntityData livingdata, @Nullable CompoundNBT tag) {
				ILivingEntityData retval = super.onInitialSpawn(world, difficulty, reason, livingdata, tag);
				double x = this.getPosX();
				double y = this.getPosY();
				double z = this.getPosZ();
				Entity entity = this;

				EarthGolemOnInitialEntitySpawnProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return retval;
			}

			@Override
			public ActionResultType func_230254_b_(PlayerEntity sourceentity, Hand hand) {
				ItemStack itemstack = sourceentity.getHeldItem(hand);
				ActionResultType retval = ActionResultType.func_233537_a_(this.world.isRemote());
				Item item = itemstack.getItem();
				if (itemstack.getItem() instanceof SpawnEggItem) {
					retval = super.func_230254_b_(sourceentity, hand);
				} else if (this.world.isRemote()) {
					retval = (this.isTamed() && this.isOwner(sourceentity) || this.isBreedingItem(itemstack))
							? ActionResultType.func_233537_a_(this.world.isRemote())
							: ActionResultType.PASS;
				} else {
					if (this.isTamed()) {
						if (this.isOwner(sourceentity)) {
							if (item.isFood() && this.isBreedingItem(itemstack) && this.getHealth() < this.getMaxHealth()) {
								this.consumeItemFromStack(sourceentity, itemstack);
								this.heal((float) item.getFood().getHealing());
								retval = ActionResultType.func_233537_a_(this.world.isRemote());
							} else if (this.isBreedingItem(itemstack) && this.getHealth() < this.getMaxHealth()) {
								this.consumeItemFromStack(sourceentity, itemstack);
								this.heal(4);
								retval = ActionResultType.func_233537_a_(this.world.isRemote());
							} else {
								retval = super.func_230254_b_(sourceentity, hand);
							}
						}
					} else if (this.isBreedingItem(itemstack)) {
						this.consumeItemFromStack(sourceentity, itemstack);
						if (this.rand.nextInt(3) == 0 && !net.minecraftforge.event.ForgeEventFactory.onAnimalTame(this, sourceentity)) {
							this.setTamedBy(sourceentity);
							this.world.setEntityState(this, (byte) 7);
						} else {
							this.world.setEntityState(this, (byte) 6);
						}
						this.enablePersistence();
						retval = ActionResultType.func_233537_a_(this.world.isRemote());
					} else {
						retval = super.func_230254_b_(sourceentity, hand);
						if (retval == ActionResultType.SUCCESS || retval == ActionResultType.CONSUME)
							this.enablePersistence();
					}
				}
				return retval;
			}

			@Override
			public AgeableEntity func_241840_a(ServerWorld serverWorld, AgeableEntity ageable) {
				CustomEntity retval = (CustomEntity) entity.create(serverWorld);
				retval.onInitialSpawn(serverWorld, serverWorld.getDifficultyForLocation(new BlockPos(retval.getPosition())), SpawnReason.BREEDING,
						(ILivingEntityData) null, (CompoundNBT) null);
				return retval;
			}

			@Override
			public boolean isBreedingItem(ItemStack stack) {
				if (stack == null)
					return false;
				return false;
			}
		}
	}
}
