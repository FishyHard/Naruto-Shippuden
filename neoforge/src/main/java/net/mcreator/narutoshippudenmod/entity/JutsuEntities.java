package net.mcreator.narutoshippudenmod.entity;

import net.mcreator.narutoshippudenmod.compat.Compat;
import net.mcreator.narutoshippudenmod.compat.Registration;
import net.mcreator.narutoshippudenmod.NarutoShippudenMod;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;
import javax.annotation.Nullable;
import net.mcreator.narutoshippudenmod.NarutoShippudenModElements;
import net.mcreator.narutoshippudenmod.entity.renderer.JutsuRenderers.DanceOfTheLarchRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.JutsuRenderers.DanceoftheLarchSneakRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.JutsuRenderers.DeadDemonConsumingSealRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.JutsuRenderers.DrowningWaterBlobTechniqueEntityRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.JutsuRenderers.DrowningWaterBlobTechniqueEntitySneakRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.JutsuRenderers.EightTrigramsPalmsRevolvingHeavenRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.JutsuRenderers.FangRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.JutsuRenderers.FlyingThunderGodKunaiEntityRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.JutsuRenderers.IceMirrorRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.JutsuRenderers.InsectJarTechniqueRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.JutsuRenderers.MagnetCoatRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.JutsuRenderers.MagnetCoatSneakRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.JutsuRenderers.MagnetHandsRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.JutsuRenderers.MagnetHandsSneakRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.JutsuRenderers.MagnetWingsRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.JutsuRenderers.ShadowCloneRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.JutsuRenderers.ShadowImitationEntity2Renderer;
import net.mcreator.narutoshippudenmod.entity.renderer.JutsuRenderers.ShadowImitationEntityRenderer;
import net.mcreator.narutoshippudenmod.procedures.ClanProcedures.ShadowCloneEntityDiesProcedure;
import net.mcreator.narutoshippudenmod.procedures.ClanProcedures.ShadowCloneOnEntityTickUpdateProcedure;
import net.mcreator.narutoshippudenmod.procedures.ClanProcedures.ShadowCloneOnInitialEntitySpawnProcedure;
import net.mcreator.narutoshippudenmod.procedures.ClanProcedures.ShadowImitationEntityOnEntityTickUpdateProcedure;
import net.mcreator.narutoshippudenmod.procedures.ClanProcedures.ShadowImitationEntityOnInitialEntitySpawnProcedure;
import net.mcreator.narutoshippudenmod.procedures.EntityProcedures.RunningFireOnInitialEntitySpawnProcedure;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.AreaEffectCloud;

import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.FlyingMoveControl;
import net.minecraft.world.entity.ai.goal.FollowOwnerGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtTargetGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
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
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.server.level.ServerLevel;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;



import net.minecraft.core.registries.BuiltInRegistries;

public final class JutsuEntities {
	private JutsuEntities() {
	}




	@NarutoShippudenModElements.ModElement.Tag
	public static class DanceOfTheLarchEntity extends NarutoShippudenModElements.ModElement {
		public static EntityType<CustomEntity> entity;

		public DanceOfTheLarchEntity(NarutoShippudenModElements instance) {
			super(instance, 955);
			Registration.listen(NarutoShippudenMod.MOD_BUS, new EntityAttributesRegisterHandler());
		}

		@Override
		public void initElements() {
			elements.entities.add(() -> entity = (EntityType.Builder.<CustomEntity>of(CustomEntity::new, MobCategory.MONSTER) .setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune() .sized(0.1f, 0.1f)).build(Registration.entityKey("dance_of_the_larch")));
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
	public static class DanceoftheLarchSneakEntity extends NarutoShippudenModElements.ModElement {
		public static EntityType<CustomEntity> entity;

		public DanceoftheLarchSneakEntity(NarutoShippudenModElements instance) {
			super(instance, 1008);
			Registration.listen(NarutoShippudenMod.MOD_BUS, new EntityAttributesRegisterHandler());
		}

		@Override
		public void initElements() {
			elements.entities.add(() -> entity = (EntityType.Builder.<CustomEntity>of(CustomEntity::new, MobCategory.MONSTER) .setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune() .sized(0.1f, 0.1f)).build(Registration.entityKey("danceofthe_larch_sneak")));
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
	public static class DeadDemonConsumingSealEntity extends NarutoShippudenModElements.ModElement {
		public static EntityType<CustomEntity> entity;

		public DeadDemonConsumingSealEntity(NarutoShippudenModElements instance) {
			super(instance, 682);
			Registration.listen(NarutoShippudenMod.MOD_BUS, new EntityAttributesRegisterHandler());
		}

		@Override
		public void initElements() {
			elements.entities.add(() -> entity = (EntityType.Builder.<CustomEntity>of(CustomEntity::new, MobCategory.MONSTER) .setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune() .sized(0.2f, 0.2f)).build(Registration.entityKey("dead_demon_consuming_seal")));
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
	public static class DrowningWaterBlobTechniqueEntityEntity extends NarutoShippudenModElements.ModElement {
		public static EntityType<CustomEntity> entity;

		public DrowningWaterBlobTechniqueEntityEntity(NarutoShippudenModElements instance) {
			super(instance, 949);
			Registration.listen(NarutoShippudenMod.MOD_BUS, new EntityAttributesRegisterHandler());
		}

		@Override
		public void initElements() {
			elements.entities.add(() -> entity = (EntityType.Builder.<CustomEntity>of(CustomEntity::new, MobCategory.MONSTER) .setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune() .sized(0.1f, 0.1f)).build(Registration.entityKey("drowning_water_blob_technique_entity")));
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
	public static class DrowningWaterBlobTechniqueEntitySneakEntity extends NarutoShippudenModElements.ModElement {
		public static EntityType<CustomEntity> entity;

		public DrowningWaterBlobTechniqueEntitySneakEntity(NarutoShippudenModElements instance) {
			super(instance, 1007);
			Registration.listen(NarutoShippudenMod.MOD_BUS, new EntityAttributesRegisterHandler());
		}

		@Override
		public void initElements() {
			elements.entities.add(() -> entity = (EntityType.Builder.<CustomEntity>of(CustomEntity::new, MobCategory.MONSTER) .setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune() .sized(0.1f, 0.1f)).build(Registration.entityKey("drowning_water_blob_technique_entity_sneak")));
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
	public static class EightTrigramsPalmsRevolvingHeavenEntity extends NarutoShippudenModElements.ModElement {
		public static EntityType<CustomEntity> entity;

		public EightTrigramsPalmsRevolvingHeavenEntity(NarutoShippudenModElements instance) {
			super(instance, 450);
			Registration.listen(NarutoShippudenMod.MOD_BUS, new EntityAttributesRegisterHandler());
		}

		@Override
		public void initElements() {
			elements.entities.add(() -> entity = (EntityType.Builder.<CustomEntity>of(CustomEntity::new, MobCategory.MONSTER) .setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune() .sized(0.1f, 0.1f)).build(Registration.entityKey("eight_trigrams_palms_revolving_heaven")));
		}

		@Override
		public void init(FMLCommonSetupEvent event) {
		}

		public static class EntityAttributesRegisterHandler {
			@SubscribeEvent
			public void onEntityAttributeCreation(EntityAttributeCreationEvent event) {
				AttributeSupplier.Builder ammma = Mob.createMobAttributes();
				ammma = ammma.add(Attributes.MOVEMENT_SPEED, 0);
				ammma = ammma.add(Attributes.MAX_HEALTH, 1000);
				ammma = ammma.add(Attributes.ARMOR, 0);
				ammma = ammma.add(Attributes.ATTACK_DAMAGE, 0);
				ammma = ammma.add(Attributes.FOLLOW_RANGE, 16);
				ammma = ammma.add(Attributes.FLYING_SPEED, 0);
				event.put(entity, ammma.build());
			}
		}

		public static class CustomEntity extends Monster {

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
				return false;
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
	public static class FangEntity extends NarutoShippudenModElements.ModElement {
		public static EntityType<CustomEntity> entity;

		public FangEntity(NarutoShippudenModElements instance) {
			super(instance, 740);
			Registration.listen(NarutoShippudenMod.MOD_BUS, new EntityAttributesRegisterHandler());
		}

		@Override
		public void initElements() {
			elements.entities.add(() -> entity = (EntityType.Builder.<CustomEntity>of(CustomEntity::new, MobCategory.MONSTER) .setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune() .sized(0.7f, 0.7f)).build(Registration.entityKey("fang")));
		}

		@Override
		public void init(FMLCommonSetupEvent event) {
		}

		public static class EntityAttributesRegisterHandler {
			@SubscribeEvent
			public void onEntityAttributeCreation(EntityAttributeCreationEvent event) {
				AttributeSupplier.Builder ammma = Mob.createMobAttributes();
				ammma = ammma.add(Attributes.MOVEMENT_SPEED, 0.25);
				ammma = ammma.add(Attributes.MAX_HEALTH, 150);
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
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class FlyingThunderGodKunaiEntityEntity extends NarutoShippudenModElements.ModElement {
		public static EntityType<CustomEntity> entity;

		public FlyingThunderGodKunaiEntityEntity(NarutoShippudenModElements instance) {
			super(instance, 734);
			Registration.listen(NarutoShippudenMod.MOD_BUS, new EntityAttributesRegisterHandler());
		}

		@Override
		public void initElements() {
			elements.entities.add(() -> entity = (EntityType.Builder.<CustomEntity>of(CustomEntity::new, MobCategory.MONSTER) .setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune() .sized(0.3f, 0.3f)).build(Registration.entityKey("flying_thunder_god_kunai_entity")));
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

		public static class CustomEntity extends Monster {

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
	public static class IceMirrorEntity extends NarutoShippudenModElements.ModElement {
		public static EntityType<CustomEntity> entity;

		public IceMirrorEntity(NarutoShippudenModElements instance) {
			super(instance, 943);
			Registration.listen(NarutoShippudenMod.MOD_BUS, new EntityAttributesRegisterHandler());
		}

		@Override
		public void initElements() {
			elements.entities.add(() -> entity = (EntityType.Builder.<CustomEntity>of(CustomEntity::new, MobCategory.MONSTER) .setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune() .sized(0.1f, 0.1f)).build(Registration.entityKey("ice_mirror")));
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
	public static class InsectJarTechniqueEntity extends NarutoShippudenModElements.ModElement {
		public static EntityType<CustomEntity> entity;

		public InsectJarTechniqueEntity(NarutoShippudenModElements instance) {
			super(instance, 929);
			Registration.listen(NarutoShippudenMod.MOD_BUS, new EntityAttributesRegisterHandler());
		}

		@Override
		public void initElements() {
			elements.entities.add(() -> entity = (EntityType.Builder.<CustomEntity>of(CustomEntity::new, MobCategory.MONSTER) .setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune() .sized(0.1f, 0.1f)).build(Registration.entityKey("insect_jar_technique")));
		}

		@Override
		public void init(FMLCommonSetupEvent event) {
		}

		public static class EntityAttributesRegisterHandler {
			@SubscribeEvent
			public void onEntityAttributeCreation(EntityAttributeCreationEvent event) {
				AttributeSupplier.Builder ammma = Mob.createMobAttributes();
				ammma = ammma.add(Attributes.MOVEMENT_SPEED, 0);
				ammma = ammma.add(Attributes.MAX_HEALTH, 1000);
				ammma = ammma.add(Attributes.ARMOR, 0);
				ammma = ammma.add(Attributes.ATTACK_DAMAGE, 0);
				ammma = ammma.add(Attributes.FOLLOW_RANGE, 16);
				ammma = ammma.add(Attributes.FLYING_SPEED, 0);
				event.put(entity, ammma.build());
			}
		}

		public static class CustomEntity extends Monster {

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
				return false;
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
	public static class MagnetCoatEntity extends NarutoShippudenModElements.ModElement {
		public static EntityType<CustomEntity> entity;

		public MagnetCoatEntity(NarutoShippudenModElements instance) {
			super(instance, 988);
			Registration.listen(NarutoShippudenMod.MOD_BUS, new EntityAttributesRegisterHandler());
		}

		@Override
		public void initElements() {
			elements.entities.add(() -> entity = (EntityType.Builder.<CustomEntity>of(CustomEntity::new, MobCategory.MONSTER) .setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune() .sized(0.1f, 0.1f)).build(Registration.entityKey("magnet_coat")));
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
	public static class MagnetCoatSneakEntity extends NarutoShippudenModElements.ModElement {
		public static EntityType<CustomEntity> entity;

		public MagnetCoatSneakEntity(NarutoShippudenModElements instance) {
			super(instance, 1010);
			Registration.listen(NarutoShippudenMod.MOD_BUS, new EntityAttributesRegisterHandler());
		}

		@Override
		public void initElements() {
			elements.entities.add(() -> entity = (EntityType.Builder.<CustomEntity>of(CustomEntity::new, MobCategory.MONSTER) .setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune() .sized(0.1f, 0.1f)).build(Registration.entityKey("magnet_coat_sneak")));
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
	public static class MagnetHandsEntity extends NarutoShippudenModElements.ModElement {
		public static EntityType<CustomEntity> entity;

		public MagnetHandsEntity(NarutoShippudenModElements instance) {
			super(instance, 990);
			Registration.listen(NarutoShippudenMod.MOD_BUS, new EntityAttributesRegisterHandler());
		}

		@Override
		public void initElements() {
			elements.entities.add(() -> entity = (EntityType.Builder.<CustomEntity>of(CustomEntity::new, MobCategory.MONSTER) .setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune() .sized(0.1f, 0.1f)).build(Registration.entityKey("magnet_hands")));
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
	public static class MagnetHandsSneakEntity extends NarutoShippudenModElements.ModElement {
		public static EntityType<CustomEntity> entity;

		public MagnetHandsSneakEntity(NarutoShippudenModElements instance) {
			super(instance, 1012);
			Registration.listen(NarutoShippudenMod.MOD_BUS, new EntityAttributesRegisterHandler());
		}

		@Override
		public void initElements() {
			elements.entities.add(() -> entity = (EntityType.Builder.<CustomEntity>of(CustomEntity::new, MobCategory.MONSTER) .setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune() .sized(0.1f, 0.1f)).build(Registration.entityKey("magnet_hands_sneak")));
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
	public static class MagnetWingsEntity extends NarutoShippudenModElements.ModElement {
		public static EntityType<CustomEntity> entity;

		public MagnetWingsEntity(NarutoShippudenModElements instance) {
			super(instance, 989);
			Registration.listen(NarutoShippudenMod.MOD_BUS, new EntityAttributesRegisterHandler());
		}

		@Override
		public void initElements() {
			elements.entities.add(() -> entity = (EntityType.Builder.<CustomEntity>of(CustomEntity::new, MobCategory.MONSTER) .setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune() .sized(0.1f, 0.1f)).build(Registration.entityKey("magnet_wings")));
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
	public static class ShadowCloneEntity extends NarutoShippudenModElements.ModElement {
		public static EntityType<CustomEntity> entity;

		public ShadowCloneEntity(NarutoShippudenModElements instance) {
			super(instance, 1187);
			Registration.listen(NarutoShippudenMod.MOD_BUS, new EntityAttributesRegisterHandler());
		}

		@Override
		public void initElements() {
			elements.entities.add(() -> entity = (EntityType.Builder.<CustomEntity>of(CustomEntity::new, MobCategory.CREATURE) .setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3) .sized(0.6f, 1.8f)).build(Registration.entityKey("shadow_clone")));
		}

		@Override
		public void init(FMLCommonSetupEvent event) {
		}

		public static class EntityAttributesRegisterHandler {
			@SubscribeEvent
			public void onEntityAttributeCreation(EntityAttributeCreationEvent event) {
				AttributeSupplier.Builder ammma = Mob.createMobAttributes();
				ammma = ammma.add(Attributes.MOVEMENT_SPEED, 0.3);
				ammma = ammma.add(Attributes.MAX_HEALTH, 5);
				ammma = ammma.add(Attributes.ARMOR, 0);
				ammma = ammma.add(Attributes.ATTACK_DAMAGE, 3);
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
				this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.2, false) {
					@Override
					protected boolean canPerformAttack(LivingEntity entity) {
						return this.isTimeToAttack() && this.mob.distanceToSqr(entity) <= ((double) (4.0 + entity.getBbWidth() * entity.getBbWidth())) && this.mob.getSensing().hasLineOfSight(entity);
					}
				});
				this.goalSelector.addGoal(2, new FollowOwnerGoal(this, 1, (float) 10, (float) 2));
				this.goalSelector.addGoal(3, new RandomStrollGoal(this, 1));
				this.goalSelector.addGoal(4, new OwnerHurtByTargetGoal(this));
				this.goalSelector.addGoal(5, new OwnerHurtTargetGoal(this));
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
			public void die(DamageSource source) {
				super.die(source);
				double x = this.getX();
				double y = this.getY();
				double z = this.getZ();
				Entity sourceentity = source.getEntity();
				Entity entity = this;

				ShadowCloneEntityDiesProcedure
						.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", level()), new AbstractMap.SimpleEntry<>("entity", entity))
								.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}

			@Override
			public SpawnGroupData finalizeSpawn(ServerLevelAccessor world, DifficultyInstance difficulty, EntitySpawnReason reason, SpawnGroupData livingdata) {
				SpawnGroupData retval = super.finalizeSpawn(world, difficulty, reason, livingdata);
				double x = this.getX();
				double y = this.getY();
				double z = this.getZ();
				Entity entity = this;

				ShadowCloneOnInitialEntitySpawnProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z), new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
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
			public void baseTick() {
				super.baseTick();
				double x = this.getX();
				double y = this.getY();
				double z = this.getZ();
				Entity entity = this;

				ShadowCloneOnEntityTickUpdateProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", level()), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z), new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
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
	public static class ShadowImitationEntity2Entity extends NarutoShippudenModElements.ModElement {
		public static EntityType<CustomEntity> entity;

		public ShadowImitationEntity2Entity(NarutoShippudenModElements instance) {
			super(instance, 995);
			Registration.listen(NarutoShippudenMod.MOD_BUS, new EntityAttributesRegisterHandler());
		}

		@Override
		public void initElements() {
			elements.entities.add(() -> entity = (EntityType.Builder.<CustomEntity>of(CustomEntity::new, MobCategory.MONSTER) .setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune() .sized(0.6f, 1.8f)).build(Registration.entityKey("shadow_imitation_entity_2")));
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
	public static class ShadowImitationEntityEntity extends NarutoShippudenModElements.ModElement {
		public static EntityType<CustomEntity> entity;

		public ShadowImitationEntityEntity(NarutoShippudenModElements instance) {
			super(instance, 994);
			Registration.listen(NarutoShippudenMod.MOD_BUS, new EntityAttributesRegisterHandler());
		}

		@Override
		public void initElements() {
			elements.entities.add(() -> entity = (EntityType.Builder.<CustomEntity>of(CustomEntity::new, MobCategory.MONSTER) .setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune() .sized(0.6f, 1.8f)).build(Registration.entityKey("shadow_imitation_entity")));
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
			public SpawnGroupData finalizeSpawn(ServerLevelAccessor world, DifficultyInstance difficulty, EntitySpawnReason reason, SpawnGroupData livingdata) {
				SpawnGroupData retval = super.finalizeSpawn(world, difficulty, reason, livingdata);
				double x = this.getX();
				double y = this.getY();
				double z = this.getZ();
				Entity entity = this;

				ShadowImitationEntityOnInitialEntitySpawnProcedure
						.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("entity", entity))
								.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
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
				sourceentity.startRiding(this);
				return retval;
			}

			@Override
			public void baseTick() {
				super.baseTick();
				double x = this.getX();
				double y = this.getY();
				double z = this.getZ();
				Entity entity = this;

				ShadowImitationEntityOnEntityTickUpdateProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
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


}
