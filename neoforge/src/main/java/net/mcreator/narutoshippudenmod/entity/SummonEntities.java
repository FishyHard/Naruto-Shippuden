package net.mcreator.narutoshippudenmod.entity;

import net.mcreator.narutoshippudenmod.compat.Compat;
import net.minecraft.util.RandomSource;
import net.mcreator.narutoshippudenmod.compat.Registration;
import net.mcreator.narutoshippudenmod.NarutoShippudenMod;

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
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.AreaEffectCloud;

import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.FlyingMoveControl;
import net.minecraft.world.entity.ai.goal.FollowOwnerGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.LeapAtTargetGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtTargetGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RangedAttackGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.projectile.arrow.AbstractArrow;
import net.minecraft.world.entity.projectile.throwableitemprojectile.ThrownSplashPotion;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.resources.Identifier;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.BossEvent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.server.level.ServerLevel;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;



import net.minecraft.core.registries.BuiltInRegistries;

public final class SummonEntities {
	private SummonEntities() {
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class AkamaruEntity extends NarutoShippudenModElements.ModElement {
		public static EntityType<CustomEntity> entity;

		public AkamaruEntity(NarutoShippudenModElements instance) {
			super(instance, 555);
			Registration.listen(NarutoShippudenMod.MOD_BUS, new EntityAttributesRegisterHandler());
		}

		@Override
		public void initElements() {
			elements.entities.add(() -> entity = (EntityType.Builder.<CustomEntity>of(CustomEntity::new, MobCategory.MONSTER) .setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3) .sized(0.7f, 0.7f)).build(Registration.entityKey("akamaru")));
		}

		@Override
		public void init(FMLCommonSetupEvent event) {
		}

		public static class EntityAttributesRegisterHandler {
			@SubscribeEvent
			public void onEntityAttributeCreation(EntityAttributeCreationEvent event) {
				AttributeSupplier.Builder ammma = Mob.createMobAttributes();
				ammma = ammma.add(Attributes.MOVEMENT_SPEED, 0.45);
				ammma = ammma.add(Attributes.MAX_HEALTH, 230);
				ammma = ammma.add(Attributes.ARMOR, 0);
				ammma = ammma.add(Attributes.ATTACK_DAMAGE, 9);
				ammma = ammma.add(Attributes.FOLLOW_RANGE, 16);
				event.put(entity, ammma.build());
			}
		}

		public static class CustomEntity extends TamableAnimal {

			public CustomEntity(EntityType<CustomEntity> type, Level world) {
				super(type, world);
				xpReward = 0;
				setNoAi(false);
				setPersistenceRequired();
			}

			@Override
			protected void registerGoals() {
				// a tamed wolf's mind: sits when told, follows, leaps and bites, defends its owner
				this.goalSelector.addGoal(1, new FloatGoal(this));
				this.goalSelector.addGoal(2, new net.minecraft.world.entity.ai.goal.SitWhenOrderedToGoal(this));
				this.goalSelector.addGoal(3, new net.minecraft.world.entity.ai.goal.LeapAtTargetGoal(this, 0.4F));
				this.goalSelector.addGoal(4, new MeleeAttackGoal(this, 1.2, true));
				this.goalSelector.addGoal(5, new FollowOwnerGoal(this, 1.1, 8F, 3F));
				this.goalSelector.addGoal(7, new net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal(this, 1));
				this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, Player.class, 8F));
				this.goalSelector.addGoal(9, new RandomLookAroundGoal(this));
				this.targetSelector.addGoal(1, new OwnerHurtByTargetGoal(this));
				this.targetSelector.addGoal(2, new OwnerHurtTargetGoal(this));
				this.targetSelector.addGoal(3, new net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal(this));
			}

			@Override
			public boolean removeWhenFarAway(double distanceToClosestPlayer) {
				return false;
			}

			@Override
			public net.minecraft.sounds.SoundEvent getAmbientSound() {
				return Compat.sound("entity.wolf.pant");
			}

			@Override
			public void playStepSound(BlockPos pos, BlockState blockIn) {
				this.playSound(Compat.sound("entity.wolf.step"), 0.15f, 1);
			}

			@Override
			public net.minecraft.sounds.SoundEvent getHurtSound(DamageSource ds) {
				return Compat.sound("entity.wolf.hurt");
			}

			@Override
			public net.minecraft.sounds.SoundEvent getDeathSound() {
				return Compat.sound("entity.wolf.death");
			}

			@Override
			public boolean hurtServer(ServerLevel level, DamageSource source, float amount) {
				if (source.is(net.minecraft.world.damagesource.DamageTypes.FALL))
					return false;
				if (source.is(net.minecraft.world.damagesource.DamageTypes.DROWN))
					return false;
				return super.hurtServer(level, source, amount);
			}

			@Override
			public SpawnGroupData finalizeSpawn(ServerLevelAccessor world, DifficultyInstance difficulty, EntitySpawnReason reason, SpawnGroupData livingdata) {
				SpawnGroupData retval = super.finalizeSpawn(world, difficulty, reason, livingdata);
				double x = this.getX();
				double y = this.getY();
				double z = this.getZ();
				Entity entity = this;

				return retval;
			}

			@Override
			public InteractionResult mobInteract(Player player, InteractionHand hand) {
				ItemStack stack = player.getItemInHand(hand);
				if (!this.isTame() || !this.isOwnedBy(player))
					return super.mobInteract(player, hand);
				if (this.isFood(stack) && this.getHealth() < this.getMaxHealth()) {
					if (!this.level().isClientSide()) {
						this.usePlayerItem(player, hand, stack);
						this.heal(8);
						this.level().broadcastEntityEvent(this, (byte) 7);
					}
					return InteractionResult.SUCCESS;
				}
				// right-click: sit / stand
				if (!this.level().isClientSide()) {
					this.setOrderedToSit(!this.isOrderedToSit());
					this.jumping = false;
					this.navigation.stop();
					this.setTarget(null);
				}
				return InteractionResult.SUCCESS;
			}

			@Override
			public AgeableMob getBreedOffspring(ServerLevel serverWorld, AgeableMob ageable) {
				CustomEntity retval = (CustomEntity) entity.create(serverWorld, EntitySpawnReason.BREEDING);
				retval.finalizeSpawn(serverWorld, serverWorld.getCurrentDifficultyAt(retval.blockPosition()), EntitySpawnReason.BREEDING, (SpawnGroupData) null);
				return retval;
			}

			@Override
			public boolean isFood(ItemStack stack) {
				return stack != null && stack.is(net.minecraft.tags.ItemTags.MEAT);
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class CrowEntity extends NarutoShippudenModElements.ModElement {
		public static EntityType<CustomEntity> entity;

		public CrowEntity(NarutoShippudenModElements instance) {
			super(instance, 394);
			Registration.listen(NarutoShippudenMod.MOD_BUS, new EntityAttributesRegisterHandler());
		}

		@Override
		public void initElements() {
			elements.entities.add(() -> entity = (EntityType.Builder.<CustomEntity>of(CustomEntity::new, MobCategory.CREATURE) .setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3) .sized(0.5f, 1.6f)).build(Registration.entityKey("crow")));
		}

		@Override
		public void init(FMLCommonSetupEvent event) {
		}

		public static class EntityAttributesRegisterHandler {
			@SubscribeEvent
			public void onEntityAttributeCreation(EntityAttributeCreationEvent event) {
				AttributeSupplier.Builder ammma = Mob.createMobAttributes();
				ammma = ammma.add(Attributes.MOVEMENT_SPEED, 0.3);
				ammma = ammma.add(Attributes.MAX_HEALTH, 10);
				ammma = ammma.add(Attributes.ARMOR, 0);
				ammma = ammma.add(Attributes.ATTACK_DAMAGE, 3);
				ammma = ammma.add(Attributes.FOLLOW_RANGE, 16);
				ammma = ammma.add(Attributes.FLYING_SPEED, 0.3);
				event.put(entity, ammma.build());
			}
		}

		public static class CustomEntity extends PathfinderMob {

			public CustomEntity(EntityType<CustomEntity> type, Level world) {
				super(type, world);
				xpReward = 0;
				setNoAi(false);
				setPersistenceRequired();
				this.moveControl = new FlyingMoveControl(this, 10, true);
				this.navigation = new FlyingPathNavigation(this, this.level());
			}

			@Override
			protected void registerGoals() {
				super.registerGoals();
				this.goalSelector.addGoal(1, new RandomStrollGoal(this, 0.8, 20) {
					@Override
					protected Vec3 getPosition() {
						RandomSource random = CustomEntity.this.getRandom();
						double dir_x = CustomEntity.this.getX() + ((random.nextFloat() * 2 - 1) * 16);
						double dir_y = CustomEntity.this.getY() + ((random.nextFloat() * 2 - 1) * 16);
						double dir_z = CustomEntity.this.getZ() + ((random.nextFloat() * 2 - 1) * 16);
						return new Vec3(dir_x, dir_y, dir_z);
					}
				});
				this.goalSelector.addGoal(2, new RandomLookAroundGoal(this));
				this.goalSelector.addGoal(3, new FloatGoal(this));
				this.goalSelector.addGoal(4, new LeapAtTargetGoal(this, (float) 0.5));
			}

			@Override
			public boolean removeWhenFarAway(double distanceToClosestPlayer) {
				return false;
			}

			@Override
			public net.minecraft.sounds.SoundEvent getHurtSound(DamageSource ds) {
				return Compat.sound("entity.generic.hurt");
			}

			@Override
			public net.minecraft.sounds.SoundEvent getDeathSound() {
				return Compat.sound("entity.generic.death");
			}

			@Override
			public boolean causeFallDamage(double l, float d, DamageSource damageSource) {
				return false;
			}

			@Override
			public SpawnGroupData finalizeSpawn(ServerLevelAccessor world, DifficultyInstance difficulty, EntitySpawnReason reason, SpawnGroupData livingdata) {
				SpawnGroupData retval = super.finalizeSpawn(world, difficulty, reason, livingdata);
				double x = this.getX();
				double y = this.getY();
				double z = this.getZ();
				Entity entity = this;

				CrowOnInitialEntitySpawnProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return retval;
			}

			@Override
			protected void checkFallDamage(double y, boolean onGroundIn, BlockState state, BlockPos pos) {
			}

			@Override
			public void setNoGravity(boolean ignored) {
				super.setNoGravity(true);
			}

			public void aiStep() {
				super.aiStep();
				this.setNoGravity(true);
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class EarthGolemEntity extends NarutoShippudenModElements.ModElement {
		public static EntityType<CustomEntity> entity;

		public EarthGolemEntity(NarutoShippudenModElements instance) {
			super(instance, 96);
			Registration.listen(NarutoShippudenMod.MOD_BUS, new EntityAttributesRegisterHandler());
		}

		@Override
		public void initElements() {
			elements.entities.add(() -> entity = (EntityType.Builder.<CustomEntity>of(CustomEntity::new, MobCategory.MONSTER) .setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3) .sized(1.5f, 3.5f)).build(Registration.entityKey("earth_golem")));
		}

		@Override
		public void init(FMLCommonSetupEvent event) {
		}

		public static class EntityAttributesRegisterHandler {
			@SubscribeEvent
			public void onEntityAttributeCreation(EntityAttributeCreationEvent event) {
				AttributeSupplier.Builder ammma = Mob.createMobAttributes();
				ammma = ammma.add(Attributes.MOVEMENT_SPEED, 0.3);
				ammma = ammma.add(Attributes.MAX_HEALTH, 210);
				ammma = ammma.add(Attributes.ARMOR, 0);
				ammma = ammma.add(Attributes.ATTACK_DAMAGE, 5);
				ammma = ammma.add(Attributes.FOLLOW_RANGE, 16);
				ammma = ammma.add(Attributes.KNOCKBACK_RESISTANCE, 1);
				ammma = ammma.add(Attributes.ATTACK_KNOCKBACK, 2);
				event.put(entity, ammma.build());
			}
		}

		public static class CustomEntity extends TamableAnimal {

			public CustomEntity(EntityType<CustomEntity> type, Level world) {
				super(type, world);
				xpReward = 0;
				setNoAi(false);
				setPersistenceRequired();
			}

			@Override
			protected void registerGoals() {
				super.registerGoals();
				this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.2, true) {
					@Override
					protected boolean canPerformAttack(LivingEntity entity) {
						return this.isTimeToAttack() && this.mob.distanceToSqr(entity) <= ((double) (4.0 + entity.getBbWidth() * entity.getBbWidth())) && this.mob.getSensing().hasLineOfSight(entity);
					}
				});
				this.goalSelector.addGoal(2, new OwnerHurtByTargetGoal(this));
				this.goalSelector.addGoal(3, new OwnerHurtTargetGoal(this));
				this.goalSelector.addGoal(4, new FollowOwnerGoal(this, 1, (float) 10, (float) 2));
				this.goalSelector.addGoal(5, new RandomStrollGoal(this, 1));
				this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
				this.goalSelector.addGoal(7, new FloatGoal(this));
			}

			@Override
			public boolean removeWhenFarAway(double distanceToClosestPlayer) {
				return false;
			}

			@Override
			public net.minecraft.sounds.SoundEvent getHurtSound(DamageSource ds) {
				return Compat.sound("entity.generic.hurt");
			}

			@Override
			public net.minecraft.sounds.SoundEvent getDeathSound() {
				return Compat.sound("entity.generic.death");
			}

			@Override
			public boolean hurtServer(ServerLevel level, DamageSource source, float amount) {
				if (source.is(net.minecraft.world.damagesource.DamageTypes.FALL))
					return false;
				if (source.is(net.minecraft.world.damagesource.DamageTypes.DROWN))
					return false;
				return super.hurtServer(level, source, amount);
			}

			@Override
			public SpawnGroupData finalizeSpawn(ServerLevelAccessor world, DifficultyInstance difficulty, EntitySpawnReason reason, SpawnGroupData livingdata) {
				SpawnGroupData retval = super.finalizeSpawn(world, difficulty, reason, livingdata);
				double x = this.getX();
				double y = this.getY();
				double z = this.getZ();
				Entity entity = this;

				EarthGolemOnInitialEntitySpawnProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return retval;
			}

			@Override
			public InteractionResult mobInteract(Player sourceentity, InteractionHand hand) {
				ItemStack itemstack = sourceentity.getItemInHand(hand);
				InteractionResult retval = InteractionResult.SUCCESS;
				Item item = itemstack.getItem();
				if (itemstack.getItem() instanceof SpawnEggItem) {
					retval = super.mobInteract(sourceentity, hand);
				} else if (this.level().isClientSide()) {
					retval = (this.isTame() && this.isOwnedBy(sourceentity) || this.isFood(itemstack))
							? InteractionResult.SUCCESS
							: InteractionResult.PASS;
				} else {
					if (this.isTame()) {
						if (this.isOwnedBy(sourceentity)) {
							if (item.components().has(net.minecraft.core.component.DataComponents.FOOD) && this.isFood(itemstack) && this.getHealth() < this.getMaxHealth()) {
								this.usePlayerItem((Player) sourceentity, hand, itemstack);
								this.heal((float) itemstack.get(net.minecraft.core.component.DataComponents.FOOD).nutrition());
								retval = InteractionResult.SUCCESS;
							} else if (this.isFood(itemstack) && this.getHealth() < this.getMaxHealth()) {
								this.usePlayerItem((Player) sourceentity, hand, itemstack);
								this.heal(4);
								retval = InteractionResult.SUCCESS;
							} else {
								retval = super.mobInteract(sourceentity, hand);
							}
						}
					} else if (this.isFood(itemstack)) {
						this.usePlayerItem((Player) sourceentity, hand, itemstack);
						if (this.random.nextInt(3) == 0 && !net.neoforged.neoforge.event.EventHooks.onAnimalTame(this, sourceentity)) {
							this.tame(sourceentity);
							this.level().broadcastEntityEvent(this, (byte) 7);
						} else {
							this.level().broadcastEntityEvent(this, (byte) 6);
						}
						this.setPersistenceRequired();
						retval = InteractionResult.SUCCESS;
					} else {
						retval = super.mobInteract(sourceentity, hand);
						if (retval == InteractionResult.SUCCESS || retval == InteractionResult.CONSUME)
							this.setPersistenceRequired();
					}
				}
				return retval;
			}

			@Override
			public AgeableMob getBreedOffspring(ServerLevel serverWorld, AgeableMob ageable) {
				CustomEntity retval = (CustomEntity) entity.create(serverWorld, EntitySpawnReason.BREEDING);
				retval.finalizeSpawn(serverWorld, serverWorld.getCurrentDifficultyAt(retval.blockPosition()), EntitySpawnReason.BREEDING, (SpawnGroupData) null);
				return retval;
			}

			@Override
			public boolean isFood(ItemStack stack) {
				if (stack == null)
					return false;
				return false;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class KirinEntity extends NarutoShippudenModElements.ModElement {
		public static EntityType<CustomEntity> entity;

		public KirinEntity(NarutoShippudenModElements instance) {
			super(instance, 75);
			Registration.listen(NarutoShippudenMod.MOD_BUS, new EntityAttributesRegisterHandler());
		}

		@Override
		public void initElements() {
			elements.entities.add(() -> entity = (EntityType.Builder.<CustomEntity>of(CustomEntity::new, MobCategory.MONSTER) .setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune() .sized(3f, 3f)).build(Registration.entityKey("kirin")));
		}

		@Override
		public void init(FMLCommonSetupEvent event) {
		}

		public static class EntityAttributesRegisterHandler {
			@SubscribeEvent
			public void onEntityAttributeCreation(EntityAttributeCreationEvent event) {
				AttributeSupplier.Builder ammma = Mob.createMobAttributes();
				ammma = ammma.add(Attributes.MOVEMENT_SPEED, 0.3);
				ammma = ammma.add(Attributes.MAX_HEALTH, 1000);
				ammma = ammma.add(Attributes.ARMOR, 0);
				ammma = ammma.add(Attributes.ATTACK_DAMAGE, 0);
				ammma = ammma.add(Attributes.FOLLOW_RANGE, 16);
				event.put(entity, ammma.build());
			}
		}

		public static class CustomEntity extends PathfinderMob {

			public CustomEntity(EntityType<CustomEntity> type, Level world) {
				super(type, world);
				xpReward = 0;
				setNoAi(false);
				setPersistenceRequired();
			}

			@Override
			protected void registerGoals() {
				super.registerGoals();

			}

			@Override
			public boolean removeWhenFarAway(double distanceToClosestPlayer) {
				return false;
			}

			@Override
			public net.minecraft.sounds.SoundEvent getHurtSound(DamageSource ds) {
				return Compat.sound("");
			}

			@Override
			public net.minecraft.sounds.SoundEvent getDeathSound() {
				return Compat.sound("");
			}

			@Override
			public boolean causeFallDamage(double l, float d, DamageSource damageSource) {
				double x = this.getX();
				double y = this.getY();
				double z = this.getZ();
				Entity entity = this;

				KirinEntityFallsProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", level()), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z), new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return super.causeFallDamage(l, d, damageSource);
			}

			@Override
			public boolean hurtServer(ServerLevel level, DamageSource source, float amount) {
				if (source.getDirectEntity() instanceof AbstractArrow)
					return false;
				if (source.getDirectEntity() instanceof Player)
					return false;
				if (source.getDirectEntity() instanceof ThrownSplashPotion || source.getDirectEntity() instanceof AreaEffectCloud)
					return false;
				if (source.is(net.minecraft.world.damagesource.DamageTypes.FALL))
					return false;
				if (source.is(net.minecraft.world.damagesource.DamageTypes.CACTUS))
					return false;
				if (source.is(net.minecraft.world.damagesource.DamageTypes.DROWN))
					return false;
				if (source.is(net.minecraft.world.damagesource.DamageTypes.LIGHTNING_BOLT))
					return false;
				if (source.is(net.minecraft.tags.DamageTypeTags.IS_EXPLOSION))
					return false;
				if (source.getMsgId().equals("trident"))
					return false;
				if (source.is(net.minecraft.world.damagesource.DamageTypes.FALLING_ANVIL))
					return false;
				if (source.is(net.minecraft.world.damagesource.DamageTypes.DRAGON_BREATH))
					return false;
				if (source.is(net.minecraft.world.damagesource.DamageTypes.WITHER))
					return false;
				if (source.getMsgId().equals("witherSkull"))
					return false;
				return super.hurtServer(level, source, amount);
			}

			@Override
			public SpawnGroupData finalizeSpawn(ServerLevelAccessor world, DifficultyInstance difficulty, EntitySpawnReason reason, SpawnGroupData livingdata) {
				SpawnGroupData retval = super.finalizeSpawn(world, difficulty, reason, livingdata);
				double x = this.getX();
				double y = this.getY();
				double z = this.getZ();
				Entity entity = this;

				RunningFireOnInitialEntitySpawnProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return retval;
			}

			@Override
			public boolean isPushable() {
				return false;
			}

			@Override
			protected void doPush(Entity entityIn) {
			}

			@Override
			protected void pushEntities() {
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class KuramaEntity extends NarutoShippudenModElements.ModElement {
		public static final int ROAR_TICKS = 30;
		public static EntityType<CustomEntity> entity;

		public KuramaEntity(NarutoShippudenModElements instance) {
			super(instance, 153);
			Registration.listen(NarutoShippudenMod.MOD_BUS, new EntityAttributesRegisterHandler());
		}

		@Override
		public void initElements() {
			elements.entities.add(() -> entity = (EntityType.Builder.<CustomEntity>of(CustomEntity::new, MobCategory.MONSTER) .setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).sized(15f, 20f)).build(Registration.entityKey("kurama")));
			elements.items.add(() -> new SpawnEggItem(Registration.itemProps("kurama_spawn_egg", "SpawnEggsItemGroup").spawnEgg(entity)));
		}

		@Override
		public void init(FMLCommonSetupEvent event) {
		}

		public static class EntityAttributesRegisterHandler {
			@SubscribeEvent
			public void onEntityAttributeCreation(EntityAttributeCreationEvent event) {
				AttributeSupplier.Builder ammma = Mob.createMobAttributes();
				ammma = ammma.add(Attributes.MOVEMENT_SPEED, 0.3);
				ammma = ammma.add(Attributes.MAX_HEALTH, 1000);
				ammma = ammma.add(Attributes.ARMOR, 0);
				ammma = ammma.add(Attributes.ATTACK_DAMAGE, 20);
				ammma = ammma.add(Attributes.FOLLOW_RANGE, 16);
				ammma = ammma.add(Attributes.KNOCKBACK_RESISTANCE, 1);
				ammma = ammma.add(Attributes.ATTACK_KNOCKBACK, 2);
				event.put(entity, ammma.build());
			}
		}

		public static class CustomEntity extends Monster implements RangedAttackMob {

			private final net.mcreator.narutoshippudenmod.core.MultipartHitbox hitbox = net.mcreator.narutoshippudenmod.core.MultipartHitbox.kurama(this);

			@Override
			public boolean isMultipartEntity() {
				return true;
			}

			@Override
			public net.neoforged.neoforge.entity.PartEntity<?>[] getParts() {
				return hitbox.parts();
			}

			@Override
			public boolean isPickable() {
				return false;
			}

			@Override
			public void recreateFromPacket(net.minecraft.network.protocol.game.ClientboundAddEntityPacket packet) {
				super.recreateFromPacket(packet);
				hitbox.syncIds(packet.getId());
			}

			@Override
			public void aiStep() {
				super.aiStep();
				hitbox.update();
			}

			/** Client side: the tick count when the last roar started (see client/KuramaAnimation). */
			public int roarTick = -1000;

			@Override
			public void handleEntityEvent(byte id) {
				if (id == 100)
					roarTick = tickCount;
				else
					super.handleEntityEvent(id);
			}

			public CustomEntity(EntityType<CustomEntity> type, Level world) {
				super(type, world);
				xpReward = 0;
				setNoAi(false);
				setPersistenceRequired();
			}

			@Override
			protected void registerGoals() {
				super.registerGoals();
				this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
				this.targetSelector.addGoal(2, new NearestAttackableTargetGoal(this, Player.class, false, false));
				this.targetSelector.addGoal(3, new NearestAttackableTargetGoal(this, ServerPlayer.class, false, false));
				this.goalSelector.addGoal(4, new LeapAtTargetGoal(this, (float) 0.2));
				this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));
				this.goalSelector.addGoal(6, new FloatGoal(this));
				this.goalSelector.addGoal(1, new RangedAttackGoal(this, 1.25, 20, 10) {
					@Override
					public boolean canContinueToUse() {
						return this.canUse();
					}
				});
			}

			@Override
			public boolean removeWhenFarAway(double distanceToClosestPlayer) {
				return false;
			}

			@Override
			public net.minecraft.sounds.SoundEvent getHurtSound(DamageSource ds) {
				return Compat.sound("entity.generic.hurt");
			}

			@Override
			public net.minecraft.sounds.SoundEvent getDeathSound() {
				return Compat.sound("entity.generic.death");
			}

			@Override
			public boolean hurtServer(ServerLevel level, DamageSource source, float amount) {
				if (source.getDirectEntity() instanceof ThrownSplashPotion || source.getDirectEntity() instanceof AreaEffectCloud)
					return false;
				if (source.is(net.minecraft.world.damagesource.DamageTypes.FALL))
					return false;
				if (source.is(net.minecraft.world.damagesource.DamageTypes.CACTUS))
					return false;
				if (source.is(net.minecraft.world.damagesource.DamageTypes.DROWN))
					return false;
				if (source.is(net.minecraft.world.damagesource.DamageTypes.LIGHTNING_BOLT))
					return false;
				if (source.is(net.minecraft.tags.DamageTypeTags.IS_EXPLOSION))
					return false;
				if (source.getMsgId().equals("trident"))
					return false;
				if (source.is(net.minecraft.world.damagesource.DamageTypes.FALLING_ANVIL))
					return false;
				if (source.is(net.minecraft.world.damagesource.DamageTypes.DRAGON_BREATH))
					return false;
				if (source.is(net.minecraft.world.damagesource.DamageTypes.WITHER))
					return false;
				if (source.getMsgId().equals("witherSkull"))
					return false;
				return super.hurtServer(level, source, amount);
			}

			@Override
			public void baseTick() {
				super.baseTick();
				double x = this.getX();
				double y = this.getY();
				double z = this.getZ();
				Entity entity = this;

				KuramaOnInitialEntitySpawnProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}

			public void performRangedAttack(LivingEntity target, float flval) {
				this.level().broadcastEntityEvent(this, (byte) 100);
				TailedBeastBombItem.shoot(this, target);
			}

			@Override
			public boolean canUsePortal(boolean allowPassengers) {
				return false;
			}

			private final ServerBossEvent bossInfo = new ServerBossEvent(java.util.UUID.randomUUID(), this.getDisplayName(), BossEvent.BossBarColor.YELLOW, BossEvent.BossBarOverlay.PROGRESS);

			@Override
			public void startSeenByPlayer(ServerPlayer player) {
				super.startSeenByPlayer(player);
				this.bossInfo.addPlayer(player);
			}

			@Override
			public void stopSeenByPlayer(ServerPlayer player) {
				super.stopSeenByPlayer(player);
				this.bossInfo.removePlayer(player);
			}

			@Override
			protected void customServerAiStep(ServerLevel level) {
				super.customServerAiStep(level);
				this.bossInfo.setProgress(this.getHealth() / this.getMaxHealth());
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class MonsterCatEntity extends NarutoShippudenModElements.ModElement {
		public static EntityType<CustomEntity> entity;

		public MonsterCatEntity(NarutoShippudenModElements instance) {
			super(instance, 840);
			Registration.listen(NarutoShippudenMod.MOD_BUS, new EntityAttributesRegisterHandler());
		}

		@Override
		public void initElements() {
			elements.entities.add(() -> entity = (EntityType.Builder.<CustomEntity>of(CustomEntity::new, MobCategory.MONSTER) .setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune() .sized(0.5f, 1.7f)).build(Registration.entityKey("monster_cat")));
		}

		@Override
		public void init(FMLCommonSetupEvent event) {
		}

		public static class EntityAttributesRegisterHandler {
			@SubscribeEvent
			public void onEntityAttributeCreation(EntityAttributeCreationEvent event) {
				AttributeSupplier.Builder ammma = Mob.createMobAttributes();
				ammma = ammma.add(Attributes.MOVEMENT_SPEED, 0.25);
				ammma = ammma.add(Attributes.MAX_HEALTH, 300);
				ammma = ammma.add(Attributes.ARMOR, 0);
				ammma = ammma.add(Attributes.ATTACK_DAMAGE, 9);
				ammma = ammma.add(Attributes.FOLLOW_RANGE, 16);
				event.put(entity, ammma.build());
			}
		}

		public static class CustomEntity extends PathfinderMob {

			public CustomEntity(EntityType<CustomEntity> type, Level world) {
				super(type, world);
				xpReward = 0;
				setNoAi(false);
				setPersistenceRequired();
			}

			@Override
			protected void registerGoals() {
				super.registerGoals();

			}

			@Override
			public boolean removeWhenFarAway(double distanceToClosestPlayer) {
				return false;
			}

			@Override
			public net.minecraft.sounds.SoundEvent getHurtSound(DamageSource ds) {
				return Compat.sound("");
			}

			@Override
			public net.minecraft.sounds.SoundEvent getDeathSound() {
				return Compat.sound("");
			}

			@Override
			public boolean hurtServer(ServerLevel level, DamageSource source, float amount) {
				if (source.getDirectEntity() instanceof AbstractArrow)
					return false;
				if (source.getDirectEntity() instanceof Player)
					return false;
				if (source.getDirectEntity() instanceof ThrownSplashPotion || source.getDirectEntity() instanceof AreaEffectCloud)
					return false;
				if (source.is(net.minecraft.world.damagesource.DamageTypes.FALL))
					return false;
				if (source.is(net.minecraft.world.damagesource.DamageTypes.CACTUS))
					return false;
				if (source.is(net.minecraft.world.damagesource.DamageTypes.DROWN))
					return false;
				if (source.is(net.minecraft.world.damagesource.DamageTypes.LIGHTNING_BOLT))
					return false;
				if (source.is(net.minecraft.tags.DamageTypeTags.IS_EXPLOSION))
					return false;
				if (source.getMsgId().equals("trident"))
					return false;
				if (source.is(net.minecraft.world.damagesource.DamageTypes.FALLING_ANVIL))
					return false;
				if (source.is(net.minecraft.world.damagesource.DamageTypes.DRAGON_BREATH))
					return false;
				if (source.is(net.minecraft.world.damagesource.DamageTypes.WITHER))
					return false;
				if (source.getMsgId().equals("witherSkull"))
					return false;
				return super.hurtServer(level, source, amount);
			}

			@Override
			public InteractionResult mobInteract(Player sourceentity, InteractionHand hand) {
				ItemStack itemstack = sourceentity.getItemInHand(hand);
				InteractionResult retval = InteractionResult.SUCCESS;
				super.mobInteract(sourceentity, hand);
				sourceentity.startRiding(this);
				return retval;
			}

			@Override
			public boolean isPushable() {
				return false;
			}

			@Override
			protected void doPush(Entity entityIn) {
			}

			@Override
			protected void pushEntities() {
			}

			@Override
			public void travel(Vec3 dir) {
				Entity entity = this.getPassengers().isEmpty() ? null : (Entity) this.getPassengers().get(0);
				if (this.isVehicle()) {
					this.setYRot(entity.getYRot());
					this.yRotO = this.getYRot();
					this.setXRot(entity.getXRot() * 0.5F);
					this.setRot(this.getYRot(), this.getXRot());
					// flying speed now comes from the movement attribute: this.getSpeed() * 0.15F
					this.yBodyRot = entity.getYRot();
					this.yHeadRot = entity.getYRot();
					// step height is the STEP_HEIGHT attribute now: 1.0F
					if (entity instanceof LivingEntity) {
						this.setSpeed((float) this.getAttributeValue(Attributes.MOVEMENT_SPEED));
						float forward = ((LivingEntity) entity).zza;
						float strafe = 0;
						super.travel(new Vec3(strafe, 0, forward));
					}
					
					double d1 = this.getX() - this.xo;
					double d0 = this.getZ() - this.zo;
					float f1 = (float) Math.sqrt(d1 * d1 + d0 * d0) * 4.0F;
					if (f1 > 1.0F)
						f1 = 1.0F;
					this.walkAnimation.update(f1, 0.4F, 1.0F);
					
					return;
				}
				// step height is the STEP_HEIGHT attribute now: 0.5F
				// flying speed now comes from the movement attribute: 0.02F
				super.travel(dir);
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class ThreeHeadAkamaruEntity extends NarutoShippudenModElements.ModElement {
		public static EntityType<CustomEntity> entity;

		public ThreeHeadAkamaruEntity(NarutoShippudenModElements instance) {
			super(instance, 1332);
			Registration.listen(NarutoShippudenMod.MOD_BUS, new EntityAttributesRegisterHandler());
		}

		@Override
		public void initElements() {
			elements.entities.add(() -> entity = (EntityType.Builder.<CustomEntity>of(CustomEntity::new, MobCategory.MONSTER) .setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune() .sized(0.7f, 0.7f)).build(Registration.entityKey("three_head_akamaru")));
		}

		@Override
		public void init(FMLCommonSetupEvent event) {
		}

		public static class EntityAttributesRegisterHandler {
			@SubscribeEvent
			public void onEntityAttributeCreation(EntityAttributeCreationEvent event) {
				AttributeSupplier.Builder ammma = Mob.createMobAttributes();
				ammma = ammma.add(Attributes.MOVEMENT_SPEED, 0.25);
				ammma = ammma.add(Attributes.MAX_HEALTH, 300);
				ammma = ammma.add(Attributes.ARMOR, 0);
				ammma = ammma.add(Attributes.ATTACK_DAMAGE, 9);
				ammma = ammma.add(Attributes.FOLLOW_RANGE, 16);
				event.put(entity, ammma.build());
			}
		}

		public static class CustomEntity extends TamableAnimal {

			public CustomEntity(EntityType<CustomEntity> type, Level world) {
				super(type, world);
				xpReward = 0;
				setNoAi(false);
				setPersistenceRequired();
			}

			@Override
			protected void registerGoals() {
				super.registerGoals();
				this.goalSelector.addGoal(1, new RandomStrollGoal(this, 1));
				this.goalSelector.addGoal(2, new LookAtPlayerGoal(this, Player.class, (float) 6));
				this.goalSelector.addGoal(3, new LookAtPlayerGoal(this, ServerPlayer.class, (float) 6));
				this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
				this.goalSelector.addGoal(5, new FloatGoal(this));
			}

			@Override
			public boolean removeWhenFarAway(double distanceToClosestPlayer) {
				return false;
			}

			@Override
			public net.minecraft.sounds.SoundEvent getAmbientSound() {
				return Compat.sound("entity.wolf.growl");
			}

			@Override
			public void playStepSound(BlockPos pos, BlockState blockIn) {
				this.playSound(Compat.sound("entity.wolf.step"), 0.15f, 1);
			}

			@Override
			public net.minecraft.sounds.SoundEvent getHurtSound(DamageSource ds) {
				return Compat.sound("entity.wolf.hurt");
			}

			@Override
			public net.minecraft.sounds.SoundEvent getDeathSound() {
				return Compat.sound("entity.wolf.death");
			}

			@Override
			public boolean hurtServer(ServerLevel level, DamageSource source, float amount) {
				if (source.getDirectEntity() instanceof AbstractArrow)
					return false;
				if (source.getDirectEntity() instanceof Player)
					return false;
				if (source.getDirectEntity() instanceof ThrownSplashPotion || source.getDirectEntity() instanceof AreaEffectCloud)
					return false;
				if (source.is(net.minecraft.world.damagesource.DamageTypes.FALL))
					return false;
				if (source.is(net.minecraft.world.damagesource.DamageTypes.CACTUS))
					return false;
				if (source.is(net.minecraft.world.damagesource.DamageTypes.DROWN))
					return false;
				if (source.is(net.minecraft.world.damagesource.DamageTypes.LIGHTNING_BOLT))
					return false;
				if (source.is(net.minecraft.tags.DamageTypeTags.IS_EXPLOSION))
					return false;
				if (source.getMsgId().equals("trident"))
					return false;
				if (source.is(net.minecraft.world.damagesource.DamageTypes.FALLING_ANVIL))
					return false;
				if (source.is(net.minecraft.world.damagesource.DamageTypes.DRAGON_BREATH))
					return false;
				if (source.is(net.minecraft.world.damagesource.DamageTypes.WITHER))
					return false;
				if (source.getMsgId().equals("witherSkull"))
					return false;
				return super.hurtServer(level, source, amount);
			}

			@Override
			public InteractionResult mobInteract(Player sourceentity, InteractionHand hand) {
				ItemStack itemstack = sourceentity.getItemInHand(hand);
				InteractionResult retval = InteractionResult.SUCCESS;
				Item item = itemstack.getItem();
				if (itemstack.getItem() instanceof SpawnEggItem) {
					retval = super.mobInteract(sourceentity, hand);
				} else if (this.level().isClientSide()) {
					retval = (this.isTame() && this.isOwnedBy(sourceentity) || this.isFood(itemstack))
							? InteractionResult.SUCCESS
							: InteractionResult.PASS;
				} else {
					if (this.isTame()) {
						if (this.isOwnedBy(sourceentity)) {
							if (item.components().has(net.minecraft.core.component.DataComponents.FOOD) && this.isFood(itemstack) && this.getHealth() < this.getMaxHealth()) {
								this.usePlayerItem((Player) sourceentity, hand, itemstack);
								this.heal((float) itemstack.get(net.minecraft.core.component.DataComponents.FOOD).nutrition());
								retval = InteractionResult.SUCCESS;
							} else if (this.isFood(itemstack) && this.getHealth() < this.getMaxHealth()) {
								this.usePlayerItem((Player) sourceentity, hand, itemstack);
								this.heal(4);
								retval = InteractionResult.SUCCESS;
							} else {
								retval = super.mobInteract(sourceentity, hand);
							}
						}
					} else if (this.isFood(itemstack)) {
						this.usePlayerItem((Player) sourceentity, hand, itemstack);
						if (this.random.nextInt(3) == 0 && !net.neoforged.neoforge.event.EventHooks.onAnimalTame(this, sourceentity)) {
							this.tame(sourceentity);
							this.level().broadcastEntityEvent(this, (byte) 7);
						} else {
							this.level().broadcastEntityEvent(this, (byte) 6);
						}
						this.setPersistenceRequired();
						retval = InteractionResult.SUCCESS;
					} else {
						retval = super.mobInteract(sourceentity, hand);
						if (retval == InteractionResult.SUCCESS || retval == InteractionResult.CONSUME)
							this.setPersistenceRequired();
					}
				}
				sourceentity.startRiding(this);
				return retval;
			}

			@Override
			public AgeableMob getBreedOffspring(ServerLevel serverWorld, AgeableMob ageable) {
				CustomEntity retval = (CustomEntity) entity.create(serverWorld, EntitySpawnReason.BREEDING);
				retval.finalizeSpawn(serverWorld, serverWorld.getCurrentDifficultyAt(retval.blockPosition()), EntitySpawnReason.BREEDING, (SpawnGroupData) null);
				return retval;
			}

			@Override
			public boolean isFood(ItemStack stack) {
				if (stack == null)
					return false;
				return false;
			}

			@Override
			public boolean isPushable() {
				return false;
			}

			@Override
			protected void doPush(Entity entityIn) {
			}

			@Override
			protected void pushEntities() {
			}

			@Override
			public void travel(Vec3 dir) {
				Entity entity = this.getPassengers().isEmpty() ? null : (Entity) this.getPassengers().get(0);
				if (this.isVehicle()) {
					this.setYRot(entity.getYRot());
					this.yRotO = this.getYRot();
					this.setXRot(entity.getXRot() * 0.5F);
					this.setRot(this.getYRot(), this.getXRot());
					// flying speed now comes from the movement attribute: this.getSpeed() * 0.15F
					this.yBodyRot = entity.getYRot();
					this.yHeadRot = entity.getYRot();
					// step height is the STEP_HEIGHT attribute now: 1.0F
					if (entity instanceof LivingEntity) {
						this.setSpeed((float) this.getAttributeValue(Attributes.MOVEMENT_SPEED));
						float forward = ((LivingEntity) entity).zza;
						float strafe = 0;
						super.travel(new Vec3(strafe, 0, forward));
					}
					
					double d1 = this.getX() - this.xo;
					double d0 = this.getZ() - this.zo;
					float f1 = (float) Math.sqrt(d1 * d1 + d0 * d0) * 4.0F;
					if (f1 > 1.0F)
						f1 = 1.0F;
					this.walkAnimation.update(f1, 0.4F, 1.0F);
					
					return;
				}
				// step height is the STEP_HEIGHT attribute now: 0.5F
				// flying speed now comes from the movement attribute: 0.02F
				super.travel(dir);
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class TwoHeadAkamaruEntity extends NarutoShippudenModElements.ModElement {
		public static EntityType<CustomEntity> entity;

		public TwoHeadAkamaruEntity(NarutoShippudenModElements instance) {
			super(instance, 563);
			Registration.listen(NarutoShippudenMod.MOD_BUS, new EntityAttributesRegisterHandler());
		}

		@Override
		public void initElements() {
			elements.entities.add(() -> entity = (EntityType.Builder.<CustomEntity>of(CustomEntity::new, MobCategory.MONSTER) .setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune() .sized(0.7f, 0.7f)).build(Registration.entityKey("two_head_akamaru")));
		}

		@Override
		public void init(FMLCommonSetupEvent event) {
		}

		public static class EntityAttributesRegisterHandler {
			@SubscribeEvent
			public void onEntityAttributeCreation(EntityAttributeCreationEvent event) {
				AttributeSupplier.Builder ammma = Mob.createMobAttributes();
				ammma = ammma.add(Attributes.MOVEMENT_SPEED, 0.25);
				ammma = ammma.add(Attributes.MAX_HEALTH, 300);
				ammma = ammma.add(Attributes.ARMOR, 0);
				ammma = ammma.add(Attributes.ATTACK_DAMAGE, 9);
				ammma = ammma.add(Attributes.FOLLOW_RANGE, 16);
				event.put(entity, ammma.build());
			}
		}

		public static class CustomEntity extends TamableAnimal {

			public CustomEntity(EntityType<CustomEntity> type, Level world) {
				super(type, world);
				xpReward = 0;
				setNoAi(false);
				setPersistenceRequired();
			}

			@Override
			protected void registerGoals() {
				super.registerGoals();
				this.goalSelector.addGoal(1, new RandomStrollGoal(this, 1));
				this.goalSelector.addGoal(2, new LookAtPlayerGoal(this, Player.class, (float) 6));
				this.goalSelector.addGoal(3, new LookAtPlayerGoal(this, ServerPlayer.class, (float) 6));
				this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
				this.goalSelector.addGoal(5, new FloatGoal(this));
			}

			@Override
			public boolean removeWhenFarAway(double distanceToClosestPlayer) {
				return false;
			}

			@Override
			public net.minecraft.sounds.SoundEvent getAmbientSound() {
				return Compat.sound("entity.wolf.growl");
			}

			@Override
			public void playStepSound(BlockPos pos, BlockState blockIn) {
				this.playSound(Compat.sound("entity.wolf.step"), 0.15f, 1);
			}

			@Override
			public net.minecraft.sounds.SoundEvent getHurtSound(DamageSource ds) {
				return Compat.sound("entity.wolf.hurt");
			}

			@Override
			public net.minecraft.sounds.SoundEvent getDeathSound() {
				return Compat.sound("entity.wolf.death");
			}

			@Override
			public boolean hurtServer(ServerLevel level, DamageSource source, float amount) {
				if (source.getDirectEntity() instanceof AbstractArrow)
					return false;
				if (source.getDirectEntity() instanceof Player)
					return false;
				if (source.getDirectEntity() instanceof ThrownSplashPotion || source.getDirectEntity() instanceof AreaEffectCloud)
					return false;
				if (source.is(net.minecraft.world.damagesource.DamageTypes.FALL))
					return false;
				if (source.is(net.minecraft.world.damagesource.DamageTypes.CACTUS))
					return false;
				if (source.is(net.minecraft.world.damagesource.DamageTypes.DROWN))
					return false;
				if (source.is(net.minecraft.world.damagesource.DamageTypes.LIGHTNING_BOLT))
					return false;
				if (source.is(net.minecraft.tags.DamageTypeTags.IS_EXPLOSION))
					return false;
				if (source.getMsgId().equals("trident"))
					return false;
				if (source.is(net.minecraft.world.damagesource.DamageTypes.FALLING_ANVIL))
					return false;
				if (source.is(net.minecraft.world.damagesource.DamageTypes.DRAGON_BREATH))
					return false;
				if (source.is(net.minecraft.world.damagesource.DamageTypes.WITHER))
					return false;
				if (source.getMsgId().equals("witherSkull"))
					return false;
				return super.hurtServer(level, source, amount);
			}

			@Override
			public InteractionResult mobInteract(Player sourceentity, InteractionHand hand) {
				ItemStack itemstack = sourceentity.getItemInHand(hand);
				InteractionResult retval = InteractionResult.SUCCESS;
				Item item = itemstack.getItem();
				if (itemstack.getItem() instanceof SpawnEggItem) {
					retval = super.mobInteract(sourceentity, hand);
				} else if (this.level().isClientSide()) {
					retval = (this.isTame() && this.isOwnedBy(sourceentity) || this.isFood(itemstack))
							? InteractionResult.SUCCESS
							: InteractionResult.PASS;
				} else {
					if (this.isTame()) {
						if (this.isOwnedBy(sourceentity)) {
							if (item.components().has(net.minecraft.core.component.DataComponents.FOOD) && this.isFood(itemstack) && this.getHealth() < this.getMaxHealth()) {
								this.usePlayerItem((Player) sourceentity, hand, itemstack);
								this.heal((float) itemstack.get(net.minecraft.core.component.DataComponents.FOOD).nutrition());
								retval = InteractionResult.SUCCESS;
							} else if (this.isFood(itemstack) && this.getHealth() < this.getMaxHealth()) {
								this.usePlayerItem((Player) sourceentity, hand, itemstack);
								this.heal(4);
								retval = InteractionResult.SUCCESS;
							} else {
								retval = super.mobInteract(sourceentity, hand);
							}
						}
					} else if (this.isFood(itemstack)) {
						this.usePlayerItem((Player) sourceentity, hand, itemstack);
						if (this.random.nextInt(3) == 0 && !net.neoforged.neoforge.event.EventHooks.onAnimalTame(this, sourceentity)) {
							this.tame(sourceentity);
							this.level().broadcastEntityEvent(this, (byte) 7);
						} else {
							this.level().broadcastEntityEvent(this, (byte) 6);
						}
						this.setPersistenceRequired();
						retval = InteractionResult.SUCCESS;
					} else {
						retval = super.mobInteract(sourceentity, hand);
						if (retval == InteractionResult.SUCCESS || retval == InteractionResult.CONSUME)
							this.setPersistenceRequired();
					}
				}
				sourceentity.startRiding(this);
				return retval;
			}

			@Override
			public AgeableMob getBreedOffspring(ServerLevel serverWorld, AgeableMob ageable) {
				CustomEntity retval = (CustomEntity) entity.create(serverWorld, EntitySpawnReason.BREEDING);
				retval.finalizeSpawn(serverWorld, serverWorld.getCurrentDifficultyAt(retval.blockPosition()), EntitySpawnReason.BREEDING, (SpawnGroupData) null);
				return retval;
			}

			@Override
			public boolean isFood(ItemStack stack) {
				if (stack == null)
					return false;
				return false;
			}

			@Override
			public boolean isPushable() {
				return false;
			}

			@Override
			protected void doPush(Entity entityIn) {
			}

			@Override
			protected void pushEntities() {
			}

			@Override
			public void travel(Vec3 dir) {
				Entity entity = this.getPassengers().isEmpty() ? null : (Entity) this.getPassengers().get(0);
				if (this.isVehicle()) {
					this.setYRot(entity.getYRot());
					this.yRotO = this.getYRot();
					this.setXRot(entity.getXRot() * 0.5F);
					this.setRot(this.getYRot(), this.getXRot());
					// flying speed now comes from the movement attribute: this.getSpeed() * 0.15F
					this.yBodyRot = entity.getYRot();
					this.yHeadRot = entity.getYRot();
					// step height is the STEP_HEIGHT attribute now: 1.0F
					if (entity instanceof LivingEntity) {
						this.setSpeed((float) this.getAttributeValue(Attributes.MOVEMENT_SPEED));
						float forward = ((LivingEntity) entity).zza;
						float strafe = 0;
						super.travel(new Vec3(strafe, 0, forward));
					}
					
					double d1 = this.getX() - this.xo;
					double d0 = this.getZ() - this.zo;
					float f1 = (float) Math.sqrt(d1 * d1 + d0 * d0) * 4.0F;
					if (f1 > 1.0F)
						f1 = 1.0F;
					this.walkAnimation.update(f1, 0.4F, 1.0F);
					
					return;
				}
				// step height is the STEP_HEIGHT attribute now: 0.5F
				// flying speed now comes from the movement attribute: 0.02F
				super.travel(dir);
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class WolfEntity extends NarutoShippudenModElements.ModElement {
		public static EntityType<CustomEntity> entity;

		public WolfEntity(NarutoShippudenModElements instance) {
			super(instance, 834);
			Registration.listen(NarutoShippudenMod.MOD_BUS, new EntityAttributesRegisterHandler());
		}

		@Override
		public void initElements() {
			elements.entities.add(() -> entity = (EntityType.Builder.<CustomEntity>of(CustomEntity::new, MobCategory.MONSTER) .setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune() .sized(0.5f, 1.7f)).build(Registration.entityKey("wolf")));
		}

		@Override
		public void init(FMLCommonSetupEvent event) {
		}

		public static class EntityAttributesRegisterHandler {
			@SubscribeEvent
			public void onEntityAttributeCreation(EntityAttributeCreationEvent event) {
				AttributeSupplier.Builder ammma = Mob.createMobAttributes();
				ammma = ammma.add(Attributes.MOVEMENT_SPEED, 0.25);
				ammma = ammma.add(Attributes.MAX_HEALTH, 300);
				ammma = ammma.add(Attributes.ARMOR, 0);
				ammma = ammma.add(Attributes.ATTACK_DAMAGE, 9);
				ammma = ammma.add(Attributes.FOLLOW_RANGE, 16);
				event.put(entity, ammma.build());
			}
		}

		public static class CustomEntity extends PathfinderMob {

			public CustomEntity(EntityType<CustomEntity> type, Level world) {
				super(type, world);
				xpReward = 0;
				setNoAi(false);
				setPersistenceRequired();
			}

			@Override
			protected void registerGoals() {
				super.registerGoals();

			}

			@Override
			public boolean removeWhenFarAway(double distanceToClosestPlayer) {
				return false;
			}

			@Override
			public net.minecraft.sounds.SoundEvent getAmbientSound() {
				return Compat.sound("entity.wolf.growl");
			}

			@Override
			public void playStepSound(BlockPos pos, BlockState blockIn) {
				this.playSound(Compat.sound("entity.wolf.step"), 0.15f, 1);
			}

			@Override
			public net.minecraft.sounds.SoundEvent getHurtSound(DamageSource ds) {
				return Compat.sound("entity.wolf.hurt");
			}

			@Override
			public net.minecraft.sounds.SoundEvent getDeathSound() {
				return Compat.sound("entity.wolf.death");
			}

			@Override
			public boolean hurtServer(ServerLevel level, DamageSource source, float amount) {
				if (source.getDirectEntity() instanceof AbstractArrow)
					return false;
				if (source.getDirectEntity() instanceof Player)
					return false;
				if (source.getDirectEntity() instanceof ThrownSplashPotion || source.getDirectEntity() instanceof AreaEffectCloud)
					return false;
				if (source.is(net.minecraft.world.damagesource.DamageTypes.FALL))
					return false;
				if (source.is(net.minecraft.world.damagesource.DamageTypes.CACTUS))
					return false;
				if (source.is(net.minecraft.world.damagesource.DamageTypes.DROWN))
					return false;
				if (source.is(net.minecraft.world.damagesource.DamageTypes.LIGHTNING_BOLT))
					return false;
				if (source.is(net.minecraft.tags.DamageTypeTags.IS_EXPLOSION))
					return false;
				if (source.getMsgId().equals("trident"))
					return false;
				if (source.is(net.minecraft.world.damagesource.DamageTypes.FALLING_ANVIL))
					return false;
				if (source.is(net.minecraft.world.damagesource.DamageTypes.DRAGON_BREATH))
					return false;
				if (source.is(net.minecraft.world.damagesource.DamageTypes.WITHER))
					return false;
				if (source.getMsgId().equals("witherSkull"))
					return false;
				return super.hurtServer(level, source, amount);
			}

			@Override
			public InteractionResult mobInteract(Player sourceentity, InteractionHand hand) {
				ItemStack itemstack = sourceentity.getItemInHand(hand);
				InteractionResult retval = InteractionResult.SUCCESS;
				super.mobInteract(sourceentity, hand);
				sourceentity.startRiding(this);
				return retval;
			}

			@Override
			public boolean isPushable() {
				return false;
			}

			@Override
			protected void doPush(Entity entityIn) {
			}

			@Override
			protected void pushEntities() {
			}

			@Override
			public void travel(Vec3 dir) {
				Entity entity = this.getPassengers().isEmpty() ? null : (Entity) this.getPassengers().get(0);
				if (this.isVehicle()) {
					this.setYRot(entity.getYRot());
					this.yRotO = this.getYRot();
					this.setXRot(entity.getXRot() * 0.5F);
					this.setRot(this.getYRot(), this.getXRot());
					// flying speed now comes from the movement attribute: this.getSpeed() * 0.15F
					this.yBodyRot = entity.getYRot();
					this.yHeadRot = entity.getYRot();
					// step height is the STEP_HEIGHT attribute now: 1.0F
					if (entity instanceof LivingEntity) {
						this.setSpeed((float) this.getAttributeValue(Attributes.MOVEMENT_SPEED));
						float forward = ((LivingEntity) entity).zza;
						float strafe = 0;
						super.travel(new Vec3(strafe, 0, forward));
					}
					
					double d1 = this.getX() - this.xo;
					double d0 = this.getZ() - this.zo;
					float f1 = (float) Math.sqrt(d1 * d1 + d0 * d0) * 4.0F;
					if (f1 > 1.0F)
						f1 = 1.0F;
					this.walkAnimation.update(f1, 0.4F, 1.0F);
					
					return;
				}
				// step height is the STEP_HEIGHT attribute now: 0.5F
				// flying speed now comes from the movement attribute: 0.02F
				super.travel(dir);
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class WoodGolemEntity extends NarutoShippudenModElements.ModElement {
		public static EntityType<CustomEntity> entity;

		public WoodGolemEntity(NarutoShippudenModElements instance) {
			super(instance, 802);
			Registration.listen(NarutoShippudenMod.MOD_BUS, new EntityAttributesRegisterHandler());
		}

		@Override
		public void initElements() {
			elements.entities.add(() -> entity = (EntityType.Builder.<CustomEntity>of(CustomEntity::new, MobCategory.MONSTER) .setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).sized(3f, 7f)).build(Registration.entityKey("wood_golem")));
		}

		@Override
		public void init(FMLCommonSetupEvent event) {
		}

		public static class EntityAttributesRegisterHandler {
			@SubscribeEvent
			public void onEntityAttributeCreation(EntityAttributeCreationEvent event) {
				AttributeSupplier.Builder ammma = Mob.createMobAttributes();
				ammma = ammma.add(Attributes.MOVEMENT_SPEED, 0.3);
				ammma = ammma.add(Attributes.MAX_HEALTH, 300);
				ammma = ammma.add(Attributes.ARMOR, 0);
				ammma = ammma.add(Attributes.ATTACK_DAMAGE, 15);
				ammma = ammma.add(Attributes.FOLLOW_RANGE, 16);
				ammma = ammma.add(Attributes.KNOCKBACK_RESISTANCE, 1);
				ammma = ammma.add(Attributes.ATTACK_KNOCKBACK, 2);
				event.put(entity, ammma.build());
			}
		}

		public static class CustomEntity extends TamableAnimal {

			public CustomEntity(EntityType<CustomEntity> type, Level world) {
				super(type, world);
				xpReward = 0;
				setNoAi(false);
				setPersistenceRequired();
			}

			@Override
			protected void registerGoals() {
				super.registerGoals();
				this.goalSelector.addGoal(1, new Goal() {
					{
						this.setFlags(EnumSet.of(Goal.Flag.MOVE));
					}

					public boolean canUse() {
						if (CustomEntity.this.getTarget() != null && !CustomEntity.this.getMoveControl().hasWanted()) {
							return true;
						} else {
							return false;
						}
					}

					@Override
					public boolean canContinueToUse() {
						return CustomEntity.this.getMoveControl().hasWanted() && CustomEntity.this.getTarget() != null
								&& CustomEntity.this.getTarget().isAlive();
					}

					@Override
					public void start() {
						LivingEntity livingentity = CustomEntity.this.getTarget();
						Vec3 vec3d = livingentity.getEyePosition(1);
						CustomEntity.this.moveControl.setWantedPosition(vec3d.x, vec3d.y, vec3d.z, 1);
					}

					@Override
					public void tick() {
						LivingEntity livingentity = CustomEntity.this.getTarget();
						if (CustomEntity.this.getBoundingBox().intersects(livingentity.getBoundingBox())) {
							CustomEntity.this.doHurtTarget((ServerLevel) CustomEntity.this.level(), livingentity);
						} else {
							double d0 = CustomEntity.this.distanceToSqr(livingentity);
							if (d0 < 16) {
								Vec3 vec3d = livingentity.getEyePosition(1);
								CustomEntity.this.moveControl.setWantedPosition(vec3d.x, vec3d.y, vec3d.z, 1);
							}
						}
					}
				});
				this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.2, false) {
					@Override
					protected boolean canPerformAttack(LivingEntity entity) {
						return this.isTimeToAttack() && this.mob.distanceToSqr(entity) <= ((double) (4.0 + entity.getBbWidth() * entity.getBbWidth())) && this.mob.getSensing().hasLineOfSight(entity);
					}
				});
				this.goalSelector.addGoal(3, new OwnerHurtByTargetGoal(this));
				this.goalSelector.addGoal(4, new OwnerHurtTargetGoal(this));
				this.goalSelector.addGoal(5, new FollowOwnerGoal(this, 1, (float) 10, (float) 2));
				this.goalSelector.addGoal(6, new RandomStrollGoal(this, 1));
				this.goalSelector.addGoal(7, new RandomLookAroundGoal(this));
				this.goalSelector.addGoal(8, new FloatGoal(this));
			}

			@Override
			public boolean removeWhenFarAway(double distanceToClosestPlayer) {
				return false;
			}

			@Override
			public net.minecraft.sounds.SoundEvent getHurtSound(DamageSource ds) {
				return Compat.sound("entity.generic.hurt");
			}

			@Override
			public net.minecraft.sounds.SoundEvent getDeathSound() {
				return Compat.sound("entity.generic.death");
			}

			@Override
			public boolean hurtServer(ServerLevel level, DamageSource source, float amount) {
				if (source.is(net.minecraft.world.damagesource.DamageTypes.FALL))
					return false;
				if (source.is(net.minecraft.world.damagesource.DamageTypes.DROWN))
					return false;
				return super.hurtServer(level, source, amount);
			}

			@Override
			public SpawnGroupData finalizeSpawn(ServerLevelAccessor world, DifficultyInstance difficulty, EntitySpawnReason reason, SpawnGroupData livingdata) {
				SpawnGroupData retval = super.finalizeSpawn(world, difficulty, reason, livingdata);
				double x = this.getX();
				double y = this.getY();
				double z = this.getZ();
				Entity entity = this;

				EarthGolemOnInitialEntitySpawnProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return retval;
			}

			@Override
			public InteractionResult mobInteract(Player sourceentity, InteractionHand hand) {
				ItemStack itemstack = sourceentity.getItemInHand(hand);
				InteractionResult retval = InteractionResult.SUCCESS;
				Item item = itemstack.getItem();
				if (itemstack.getItem() instanceof SpawnEggItem) {
					retval = super.mobInteract(sourceentity, hand);
				} else if (this.level().isClientSide()) {
					retval = (this.isTame() && this.isOwnedBy(sourceentity) || this.isFood(itemstack))
							? InteractionResult.SUCCESS
							: InteractionResult.PASS;
				} else {
					if (this.isTame()) {
						if (this.isOwnedBy(sourceentity)) {
							if (item.components().has(net.minecraft.core.component.DataComponents.FOOD) && this.isFood(itemstack) && this.getHealth() < this.getMaxHealth()) {
								this.usePlayerItem((Player) sourceentity, hand, itemstack);
								this.heal((float) itemstack.get(net.minecraft.core.component.DataComponents.FOOD).nutrition());
								retval = InteractionResult.SUCCESS;
							} else if (this.isFood(itemstack) && this.getHealth() < this.getMaxHealth()) {
								this.usePlayerItem((Player) sourceentity, hand, itemstack);
								this.heal(4);
								retval = InteractionResult.SUCCESS;
							} else {
								retval = super.mobInteract(sourceentity, hand);
							}
						}
					} else if (this.isFood(itemstack)) {
						this.usePlayerItem((Player) sourceentity, hand, itemstack);
						if (this.random.nextInt(3) == 0 && !net.neoforged.neoforge.event.EventHooks.onAnimalTame(this, sourceentity)) {
							this.tame(sourceentity);
							this.level().broadcastEntityEvent(this, (byte) 7);
						} else {
							this.level().broadcastEntityEvent(this, (byte) 6);
						}
						this.setPersistenceRequired();
						retval = InteractionResult.SUCCESS;
					} else {
						retval = super.mobInteract(sourceentity, hand);
						if (retval == InteractionResult.SUCCESS || retval == InteractionResult.CONSUME)
							this.setPersistenceRequired();
					}
				}
				return retval;
			}

			@Override
			public AgeableMob getBreedOffspring(ServerLevel serverWorld, AgeableMob ageable) {
				CustomEntity retval = (CustomEntity) entity.create(serverWorld, EntitySpawnReason.BREEDING);
				retval.finalizeSpawn(serverWorld, serverWorld.getCurrentDifficultyAt(retval.blockPosition()), EntitySpawnReason.BREEDING, (SpawnGroupData) null);
				return retval;
			}

			@Override
			public boolean isFood(ItemStack stack) {
				if (stack == null)
					return false;
				return false;
			}
		}
	}
}
