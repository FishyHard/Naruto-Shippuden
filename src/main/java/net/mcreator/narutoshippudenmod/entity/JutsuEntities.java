package net.mcreator.narutoshippudenmod.entity;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;
import javax.annotation.Nullable;
import net.mcreator.narutoshippudenmod.NarutoShippudenModElements;
import net.mcreator.narutoshippudenmod.entity.renderer.JutsuRenderers.ButterflyModeRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.JutsuRenderers.CatChakraModeRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.JutsuRenderers.CatChakraModeSneakRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.JutsuRenderers.DanceOfTheLarchRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.JutsuRenderers.DanceoftheLarchSneakRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.JutsuRenderers.DeadDemonConsumingSealRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.JutsuRenderers.DisruptionCubeRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.JutsuRenderers.DrowningWaterBlobTechniqueEntityRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.JutsuRenderers.DrowningWaterBlobTechniqueEntitySneakRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.JutsuRenderers.EightTrigramsPalmsRevolvingHeavenRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.JutsuRenderers.EightTrigramsSixtyFourPalmsRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.JutsuRenderers.FangRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.JutsuRenderers.FlyingThunderGodKunaiEntityRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.JutsuRenderers.HumanBulletTankRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.JutsuRenderers.IceMirrorRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.JutsuRenderers.IceSpearRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.JutsuRenderers.InsectJarTechniqueRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.JutsuRenderers.MagnetCoatRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.JutsuRenderers.MagnetCoatSneakRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.JutsuRenderers.MagnetHandsRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.JutsuRenderers.MagnetHandsSneakRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.JutsuRenderers.MagnetWingsRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.JutsuRenderers.RunningFireRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.JutsuRenderers.ShadowCloneRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.JutsuRenderers.ShadowImitationEntity2Renderer;
import net.mcreator.narutoshippudenmod.entity.renderer.JutsuRenderers.ShadowImitationEntityRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.JutsuRenderers.ShadowImitationFieldTechniqueRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.JutsuRenderers.SpikedHumanBulletTankRenderer;
import net.mcreator.narutoshippudenmod.procedures.ClanProcedures.EightTrigramsPalmsRevolvingHeavenOnInitialEntitySpawnProcedure;
import net.mcreator.narutoshippudenmod.procedures.ClanProcedures.ShadowCloneEntityDiesProcedure;
import net.mcreator.narutoshippudenmod.procedures.ClanProcedures.ShadowCloneOnEntityTickUpdateProcedure;
import net.mcreator.narutoshippudenmod.procedures.ClanProcedures.ShadowCloneOnInitialEntitySpawnProcedure;
import net.mcreator.narutoshippudenmod.procedures.ClanProcedures.ShadowImitationEntityOnEntityTickUpdateProcedure;
import net.mcreator.narutoshippudenmod.procedures.ClanProcedures.ShadowImitationEntityOnInitialEntitySpawnProcedure;
import net.mcreator.narutoshippudenmod.procedures.ClanProcedures.ShadowImitationFieldTechniqueOnEntityTickUpdateProcedure;
import net.mcreator.narutoshippudenmod.procedures.ClanProcedures.ShadowImitationFieldTechniquePlayerCollidesWithThisEntityProcedure;
import net.mcreator.narutoshippudenmod.procedures.EntityProcedures.DisruptionCubeEntityFallsProcedure;
import net.mcreator.narutoshippudenmod.procedures.EntityProcedures.DisruptionCubePlayerCollidesWithThisEntityProcedure;
import net.mcreator.narutoshippudenmod.procedures.EntityProcedures.RunningFireOnInitialEntitySpawnProcedure;
import net.mcreator.narutoshippudenmod.procedures.EntityProcedures.RunningFirePlayerCollidesWithThisEntityProcedure;
import net.mcreator.narutoshippudenmod.procedures.KekkeiGenkaiProcedures.IceSpearOnEntityTickUpdateProcedure;
import net.mcreator.narutoshippudenmod.procedures.KekkeiGenkaiProcedures.IceSpearOnInitialEntitySpawnProcedure;
import net.minecraft.block.BlockState;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.AreaEffectCloudEntity;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.controller.FlyingMovementController;
import net.minecraft.entity.ai.goal.FollowOwnerGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.OwnerHurtByTargetGoal;
import net.minecraft.entity.ai.goal.OwnerHurtTargetGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
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
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.registries.ForgeRegistries;

public final class JutsuEntities {
	private JutsuEntities() {
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class ButterflyModeEntity extends NarutoShippudenModElements.ModElement {
		public static EntityType entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER)
				.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).immuneToFire()
				.size(0.1f, 0.1f)).build("butterfly_mode").setRegistryName("butterfly_mode");

		public ButterflyModeEntity(NarutoShippudenModElements instance) {
			super(instance, 1159);
			FMLJavaModLoadingContext.get().getModEventBus().register(new ButterflyModeRenderer.ModelRegisterHandler());
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
	public static class CatChakraModeEntity extends NarutoShippudenModElements.ModElement {
		public static EntityType entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER)
				.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).immuneToFire()
				.size(0.5f, 1.7f)).build("cat_chakra_mode").setRegistryName("cat_chakra_mode");

		public CatChakraModeEntity(NarutoShippudenModElements instance) {
			super(instance, 841);
			FMLJavaModLoadingContext.get().getModEventBus().register(new CatChakraModeRenderer.ModelRegisterHandler());
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
	public static class CatChakraModeSneakEntity extends NarutoShippudenModElements.ModElement {
		public static EntityType entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER)
				.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).immuneToFire()
				.size(0.5f, 1.7f)).build("cat_chakra_mode_sneak").setRegistryName("cat_chakra_mode_sneak");

		public CatChakraModeSneakEntity(NarutoShippudenModElements instance) {
			super(instance, 1009);
			FMLJavaModLoadingContext.get().getModEventBus().register(new CatChakraModeSneakRenderer.ModelRegisterHandler());
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
	public static class DanceOfTheLarchEntity extends NarutoShippudenModElements.ModElement {
		public static EntityType entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER)
				.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).immuneToFire()
				.size(0.1f, 0.1f)).build("dance_of_the_larch").setRegistryName("dance_of_the_larch");

		public DanceOfTheLarchEntity(NarutoShippudenModElements instance) {
			super(instance, 955);
			FMLJavaModLoadingContext.get().getModEventBus().register(new DanceOfTheLarchRenderer.ModelRegisterHandler());
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
	public static class DanceoftheLarchSneakEntity extends NarutoShippudenModElements.ModElement {
		public static EntityType entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER)
				.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).immuneToFire()
				.size(0.1f, 0.1f)).build("danceofthe_larch_sneak").setRegistryName("danceofthe_larch_sneak");

		public DanceoftheLarchSneakEntity(NarutoShippudenModElements instance) {
			super(instance, 1008);
			FMLJavaModLoadingContext.get().getModEventBus().register(new DanceoftheLarchSneakRenderer.ModelRegisterHandler());
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
	public static class DeadDemonConsumingSealEntity extends NarutoShippudenModElements.ModElement {
		public static EntityType entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER)
				.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).immuneToFire()
				.size(0.2f, 0.2f)).build("dead_demon_consuming_seal").setRegistryName("dead_demon_consuming_seal");

		public DeadDemonConsumingSealEntity(NarutoShippudenModElements instance) {
			super(instance, 682);
			FMLJavaModLoadingContext.get().getModEventBus().register(new DeadDemonConsumingSealRenderer.ModelRegisterHandler());
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
	public static class DisruptionCubeEntity extends NarutoShippudenModElements.ModElement {
		public static EntityType entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER)
				.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).immuneToFire()
				.size(13f, 13f)).build("disruption_cube").setRegistryName("disruption_cube");

		public DisruptionCubeEntity(NarutoShippudenModElements instance) {
			super(instance, 549);
			FMLJavaModLoadingContext.get().getModEventBus().register(new DisruptionCubeRenderer.ModelRegisterHandler());
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

				DisruptionCubeEntityFallsProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z))
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
			public void onCollideWithPlayer(PlayerEntity sourceentity) {
				super.onCollideWithPlayer(sourceentity);
				Entity entity = this;
				double x = this.getPosX();
				double y = this.getPosY();
				double z = this.getPosZ();

				DisruptionCubePlayerCollidesWithThisEntityProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
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
	public static class DrowningWaterBlobTechniqueEntityEntity extends NarutoShippudenModElements.ModElement {
		public static EntityType entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER)
				.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).immuneToFire()
				.size(0.1f, 0.1f)).build("drowning_water_blob_technique_entity").setRegistryName("drowning_water_blob_technique_entity");

		public DrowningWaterBlobTechniqueEntityEntity(NarutoShippudenModElements instance) {
			super(instance, 949);
			FMLJavaModLoadingContext.get().getModEventBus().register(new DrowningWaterBlobTechniqueEntityRenderer.ModelRegisterHandler());
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
	public static class DrowningWaterBlobTechniqueEntitySneakEntity extends NarutoShippudenModElements.ModElement {
		public static EntityType entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER)
				.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).immuneToFire()
				.size(0.1f, 0.1f)).build("drowning_water_blob_technique_entity_sneak").setRegistryName("drowning_water_blob_technique_entity_sneak");

		public DrowningWaterBlobTechniqueEntitySneakEntity(NarutoShippudenModElements instance) {
			super(instance, 1007);
			FMLJavaModLoadingContext.get().getModEventBus().register(new DrowningWaterBlobTechniqueEntitySneakRenderer.ModelRegisterHandler());
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
	public static class EightTrigramsPalmsRevolvingHeavenEntity extends NarutoShippudenModElements.ModElement {
		public static EntityType entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER)
				.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).immuneToFire()
				.size(0.1f, 0.1f)).build("eight_trigrams_palms_revolving_heaven").setRegistryName("eight_trigrams_palms_revolving_heaven");

		public EightTrigramsPalmsRevolvingHeavenEntity(NarutoShippudenModElements instance) {
			super(instance, 450);
			FMLJavaModLoadingContext.get().getModEventBus().register(new EightTrigramsPalmsRevolvingHeavenRenderer.ModelRegisterHandler());
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
				ammma = ammma.createMutableAttribute(Attributes.MOVEMENT_SPEED, 0);
				ammma = ammma.createMutableAttribute(Attributes.MAX_HEALTH, 1000);
				ammma = ammma.createMutableAttribute(Attributes.ARMOR, 0);
				ammma = ammma.createMutableAttribute(Attributes.ATTACK_DAMAGE, 0);
				ammma = ammma.createMutableAttribute(Attributes.FOLLOW_RANGE, 16);
				ammma = ammma.createMutableAttribute(Attributes.FLYING_SPEED, 0);
				event.put(entity, ammma.create());
			}
		}

		public static class CustomEntity extends MonsterEntity {
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
				return false;
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
	public static class EightTrigramsSixtyFourPalmsEntity extends NarutoShippudenModElements.ModElement {
		public static EntityType entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER)
				.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).immuneToFire()
				.size(1f, 0.1f)).build("eight_trigrams_sixty_four_palms").setRegistryName("eight_trigrams_sixty_four_palms");

		public EightTrigramsSixtyFourPalmsEntity(NarutoShippudenModElements instance) {
			super(instance, 531);
			FMLJavaModLoadingContext.get().getModEventBus().register(new EightTrigramsSixtyFourPalmsRenderer.ModelRegisterHandler());
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
				ammma = ammma.createMutableAttribute(Attributes.MOVEMENT_SPEED, 0);
				ammma = ammma.createMutableAttribute(Attributes.MAX_HEALTH, 1000);
				ammma = ammma.createMutableAttribute(Attributes.ARMOR, 0);
				ammma = ammma.createMutableAttribute(Attributes.ATTACK_DAMAGE, 0);
				ammma = ammma.createMutableAttribute(Attributes.FLYING_SPEED, 0);
				event.put(entity, ammma.create());
			}
		}

		public static class CustomEntity extends MonsterEntity {
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
				return false;
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

				EightTrigramsPalmsRevolvingHeavenOnInitialEntitySpawnProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
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
	public static class FangEntity extends NarutoShippudenModElements.ModElement {
		public static EntityType entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER)
				.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).immuneToFire()
				.size(0.7f, 0.7f)).build("fang").setRegistryName("fang");

		public FangEntity(NarutoShippudenModElements instance) {
			super(instance, 740);
			FMLJavaModLoadingContext.get().getModEventBus().register(new FangRenderer.ModelRegisterHandler());
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
				ammma = ammma.createMutableAttribute(Attributes.MAX_HEALTH, 150);
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
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class FlyingThunderGodKunaiEntityEntity extends NarutoShippudenModElements.ModElement {
		public static EntityType entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER)
				.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).immuneToFire()
				.size(0.3f, 0.3f)).build("flying_thunder_god_kunai_entity").setRegistryName("flying_thunder_god_kunai_entity");

		public FlyingThunderGodKunaiEntityEntity(NarutoShippudenModElements instance) {
			super(instance, 734);
			FMLJavaModLoadingContext.get().getModEventBus().register(new FlyingThunderGodKunaiEntityRenderer.ModelRegisterHandler());
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

		public static class CustomEntity extends MonsterEntity {
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
	public static class HumanBulletTankEntity extends NarutoShippudenModElements.ModElement {
		public static EntityType entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER)
				.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).immuneToFire()
				.size(0.1f, 0.1f)).build("human_bullet_tank").setRegistryName("human_bullet_tank");

		public HumanBulletTankEntity(NarutoShippudenModElements instance) {
			super(instance, 1019);
			FMLJavaModLoadingContext.get().getModEventBus().register(new HumanBulletTankRenderer.ModelRegisterHandler());
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
	public static class IceMirrorEntity extends NarutoShippudenModElements.ModElement {
		public static EntityType entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER)
				.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).immuneToFire()
				.size(0.1f, 0.1f)).build("ice_mirror").setRegistryName("ice_mirror");

		public IceMirrorEntity(NarutoShippudenModElements instance) {
			super(instance, 943);
			FMLJavaModLoadingContext.get().getModEventBus().register(new IceMirrorRenderer.ModelRegisterHandler());
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
	public static class IceSpearEntity extends NarutoShippudenModElements.ModElement {
		public static EntityType entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER)
				.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).immuneToFire()
				.size(1f, 7f)).build("ice_spear").setRegistryName("ice_spear");

		public IceSpearEntity(NarutoShippudenModElements instance) {
			super(instance, 803);
			FMLJavaModLoadingContext.get().getModEventBus().register(new IceSpearRenderer.ModelRegisterHandler());
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
				ammma = ammma.createMutableAttribute(Attributes.MOVEMENT_SPEED, 0);
				ammma = ammma.createMutableAttribute(Attributes.MAX_HEALTH, 1000);
				ammma = ammma.createMutableAttribute(Attributes.ARMOR, 0);
				ammma = ammma.createMutableAttribute(Attributes.ATTACK_DAMAGE, 0);
				ammma = ammma.createMutableAttribute(Attributes.FOLLOW_RANGE, 16);
				event.put(entity, ammma.create());
			}
		}

		public static class CustomEntity extends MonsterEntity {
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
			public ILivingEntityData onInitialSpawn(IServerWorld world, DifficultyInstance difficulty, SpawnReason reason,
					@Nullable ILivingEntityData livingdata, @Nullable CompoundNBT tag) {
				ILivingEntityData retval = super.onInitialSpawn(world, difficulty, reason, livingdata, tag);
				double x = this.getPosX();
				double y = this.getPosY();
				double z = this.getPosZ();
				Entity entity = this;

				IceSpearOnInitialEntitySpawnProcedure
						.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("entity", entity))
								.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return retval;
			}

			@Override
			public void baseTick() {
				super.baseTick();
				double x = this.getPosX();
				double y = this.getPosY();
				double z = this.getPosZ();
				Entity entity = this;

				IceSpearOnEntityTickUpdateProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
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
	public static class InsectJarTechniqueEntity extends NarutoShippudenModElements.ModElement {
		public static EntityType entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER)
				.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).immuneToFire()
				.size(0.1f, 0.1f)).build("insect_jar_technique").setRegistryName("insect_jar_technique");

		public InsectJarTechniqueEntity(NarutoShippudenModElements instance) {
			super(instance, 929);
			FMLJavaModLoadingContext.get().getModEventBus().register(new InsectJarTechniqueRenderer.ModelRegisterHandler());
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
				ammma = ammma.createMutableAttribute(Attributes.MOVEMENT_SPEED, 0);
				ammma = ammma.createMutableAttribute(Attributes.MAX_HEALTH, 1000);
				ammma = ammma.createMutableAttribute(Attributes.ARMOR, 0);
				ammma = ammma.createMutableAttribute(Attributes.ATTACK_DAMAGE, 0);
				ammma = ammma.createMutableAttribute(Attributes.FOLLOW_RANGE, 16);
				ammma = ammma.createMutableAttribute(Attributes.FLYING_SPEED, 0);
				event.put(entity, ammma.create());
			}
		}

		public static class CustomEntity extends MonsterEntity {
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
				return false;
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
	public static class MagnetCoatEntity extends NarutoShippudenModElements.ModElement {
		public static EntityType entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER)
				.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).immuneToFire()
				.size(0.1f, 0.1f)).build("magnet_coat").setRegistryName("magnet_coat");

		public MagnetCoatEntity(NarutoShippudenModElements instance) {
			super(instance, 988);
			FMLJavaModLoadingContext.get().getModEventBus().register(new MagnetCoatRenderer.ModelRegisterHandler());
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
	public static class MagnetCoatSneakEntity extends NarutoShippudenModElements.ModElement {
		public static EntityType entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER)
				.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).immuneToFire()
				.size(0.1f, 0.1f)).build("magnet_coat_sneak").setRegistryName("magnet_coat_sneak");

		public MagnetCoatSneakEntity(NarutoShippudenModElements instance) {
			super(instance, 1010);
			FMLJavaModLoadingContext.get().getModEventBus().register(new MagnetCoatSneakRenderer.ModelRegisterHandler());
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
	public static class MagnetHandsEntity extends NarutoShippudenModElements.ModElement {
		public static EntityType entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER)
				.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).immuneToFire()
				.size(0.1f, 0.1f)).build("magnet_hands").setRegistryName("magnet_hands");

		public MagnetHandsEntity(NarutoShippudenModElements instance) {
			super(instance, 990);
			FMLJavaModLoadingContext.get().getModEventBus().register(new MagnetHandsRenderer.ModelRegisterHandler());
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
	public static class MagnetHandsSneakEntity extends NarutoShippudenModElements.ModElement {
		public static EntityType entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER)
				.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).immuneToFire()
				.size(0.1f, 0.1f)).build("magnet_hands_sneak").setRegistryName("magnet_hands_sneak");

		public MagnetHandsSneakEntity(NarutoShippudenModElements instance) {
			super(instance, 1012);
			FMLJavaModLoadingContext.get().getModEventBus().register(new MagnetHandsSneakRenderer.ModelRegisterHandler());
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
	public static class MagnetWingsEntity extends NarutoShippudenModElements.ModElement {
		public static EntityType entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER)
				.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).immuneToFire()
				.size(0.1f, 0.1f)).build("magnet_wings").setRegistryName("magnet_wings");

		public MagnetWingsEntity(NarutoShippudenModElements instance) {
			super(instance, 989);
			FMLJavaModLoadingContext.get().getModEventBus().register(new MagnetWingsRenderer.ModelRegisterHandler());
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
	public static class RunningFireEntity extends NarutoShippudenModElements.ModElement {
		public static EntityType entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER)
				.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).immuneToFire()
				.size(4f, 0.3f)).build("running_fire").setRegistryName("running_fire");

		public RunningFireEntity(NarutoShippudenModElements instance) {
			super(instance, 21);
			FMLJavaModLoadingContext.get().getModEventBus().register(new RunningFireRenderer.ModelRegisterHandler());
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
				ammma = ammma.createMutableAttribute(Attributes.MOVEMENT_SPEED, 0);
				ammma = ammma.createMutableAttribute(Attributes.MAX_HEALTH, 1000);
				ammma = ammma.createMutableAttribute(Attributes.ARMOR, 0);
				ammma = ammma.createMutableAttribute(Attributes.ATTACK_DAMAGE, 0);
				ammma = ammma.createMutableAttribute(Attributes.FOLLOW_RANGE, 16);
				ammma = ammma.createMutableAttribute(Attributes.FLYING_SPEED, 0);
				event.put(entity, ammma.create());
			}
		}

		public static class CustomEntity extends MonsterEntity {
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
				return false;
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
			public void onCollideWithPlayer(PlayerEntity sourceentity) {
				super.onCollideWithPlayer(sourceentity);
				Entity entity = this;
				double x = this.getPosX();
				double y = this.getPosY();
				double z = this.getPosZ();

				RunningFirePlayerCollidesWithThisEntityProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z), new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
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
	public static class ShadowCloneEntity extends NarutoShippudenModElements.ModElement {
		public static EntityType entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.CREATURE)
				.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new)
				.size(0.6f, 1.8f)).build("shadow_clone").setRegistryName("shadow_clone");

		public ShadowCloneEntity(NarutoShippudenModElements instance) {
			super(instance, 1187);
			FMLJavaModLoadingContext.get().getModEventBus().register(new ShadowCloneRenderer.ModelRegisterHandler());
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
				ammma = ammma.createMutableAttribute(Attributes.MAX_HEALTH, 5);
				ammma = ammma.createMutableAttribute(Attributes.ARMOR, 0);
				ammma = ammma.createMutableAttribute(Attributes.ATTACK_DAMAGE, 3);
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
				this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.2, false) {
					@Override
					protected double getAttackReachSqr(LivingEntity entity) {
						return (double) (4.0 + entity.getWidth() * entity.getWidth());
					}
				});
				this.goalSelector.addGoal(2, new FollowOwnerGoal(this, 1, (float) 10, (float) 2, false));
				this.goalSelector.addGoal(3, new RandomWalkingGoal(this, 1));
				this.goalSelector.addGoal(4, new OwnerHurtByTargetGoal(this));
				this.goalSelector.addGoal(5, new OwnerHurtTargetGoal(this));
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
			public void onDeath(DamageSource source) {
				super.onDeath(source);
				double x = this.getPosX();
				double y = this.getPosY();
				double z = this.getPosZ();
				Entity sourceentity = source.getTrueSource();
				Entity entity = this;

				ShadowCloneEntityDiesProcedure
						.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("entity", entity))
								.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}

			@Override
			public ILivingEntityData onInitialSpawn(IServerWorld world, DifficultyInstance difficulty, SpawnReason reason,
					@Nullable ILivingEntityData livingdata, @Nullable CompoundNBT tag) {
				ILivingEntityData retval = super.onInitialSpawn(world, difficulty, reason, livingdata, tag);
				double x = this.getPosX();
				double y = this.getPosY();
				double z = this.getPosZ();
				Entity entity = this;

				ShadowCloneOnInitialEntitySpawnProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z), new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
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
			public void baseTick() {
				super.baseTick();
				double x = this.getPosX();
				double y = this.getPosY();
				double z = this.getPosZ();
				Entity entity = this;

				ShadowCloneOnEntityTickUpdateProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z), new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
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
	public static class ShadowImitationEntity2Entity extends NarutoShippudenModElements.ModElement {
		public static EntityType entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER)
				.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).immuneToFire()
				.size(0.6f, 1.8f)).build("shadow_imitation_entity_2").setRegistryName("shadow_imitation_entity_2");

		public ShadowImitationEntity2Entity(NarutoShippudenModElements instance) {
			super(instance, 995);
			FMLJavaModLoadingContext.get().getModEventBus().register(new ShadowImitationEntity2Renderer.ModelRegisterHandler());
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
	public static class ShadowImitationEntityEntity extends NarutoShippudenModElements.ModElement {
		public static EntityType entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER)
				.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).immuneToFire()
				.size(0.6f, 1.8f)).build("shadow_imitation_entity").setRegistryName("shadow_imitation_entity");

		public ShadowImitationEntityEntity(NarutoShippudenModElements instance) {
			super(instance, 994);
			FMLJavaModLoadingContext.get().getModEventBus().register(new ShadowImitationEntityRenderer.ModelRegisterHandler());
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
			public ILivingEntityData onInitialSpawn(IServerWorld world, DifficultyInstance difficulty, SpawnReason reason,
					@Nullable ILivingEntityData livingdata, @Nullable CompoundNBT tag) {
				ILivingEntityData retval = super.onInitialSpawn(world, difficulty, reason, livingdata, tag);
				double x = this.getPosX();
				double y = this.getPosY();
				double z = this.getPosZ();
				Entity entity = this;

				ShadowImitationEntityOnInitialEntitySpawnProcedure
						.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("entity", entity))
								.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
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
				sourceentity.startRiding(this);
				return retval;
			}

			@Override
			public void baseTick() {
				super.baseTick();
				double x = this.getPosX();
				double y = this.getPosY();
				double z = this.getPosZ();
				Entity entity = this;

				ShadowImitationEntityOnEntityTickUpdateProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
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
	public static class ShadowImitationFieldTechniqueEntity extends NarutoShippudenModElements.ModElement {
		public static EntityType entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER)
				.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).immuneToFire()
				.size(1f, 1f)).build("shadow_imitation_field_technique").setRegistryName("shadow_imitation_field_technique");

		public ShadowImitationFieldTechniqueEntity(NarutoShippudenModElements instance) {
			super(instance, 1021);
			FMLJavaModLoadingContext.get().getModEventBus().register(new ShadowImitationFieldTechniqueRenderer.ModelRegisterHandler());
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
				ammma = ammma.createMutableAttribute(Attributes.MOVEMENT_SPEED, 0);
				ammma = ammma.createMutableAttribute(Attributes.MAX_HEALTH, 1000);
				ammma = ammma.createMutableAttribute(Attributes.ARMOR, 0);
				ammma = ammma.createMutableAttribute(Attributes.ATTACK_DAMAGE, 0);
				ammma = ammma.createMutableAttribute(Attributes.FOLLOW_RANGE, 16);
				ammma = ammma.createMutableAttribute(Attributes.FLYING_SPEED, 0);
				event.put(entity, ammma.create());
			}
		}

		public static class CustomEntity extends MonsterEntity {
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
				return false;
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
			public void baseTick() {
				super.baseTick();
				double x = this.getPosX();
				double y = this.getPosY();
				double z = this.getPosZ();
				Entity entity = this;

				ShadowImitationFieldTechniqueOnEntityTickUpdateProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}

			@Override
			public void onCollideWithPlayer(PlayerEntity sourceentity) {
				super.onCollideWithPlayer(sourceentity);
				Entity entity = this;
				double x = this.getPosX();
				double y = this.getPosY();
				double z = this.getPosZ();

				ShadowImitationFieldTechniquePlayerCollidesWithThisEntityProcedure.executeProcedure(
						Stream.of(new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("sourceentity", sourceentity))
								.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
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
	public static class SpikedHumanBulletTankEntity extends NarutoShippudenModElements.ModElement {
		public static EntityType entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER)
				.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).immuneToFire()
				.size(0.1f, 0.1f)).build("spiked_human_bullet_tank").setRegistryName("spiked_human_bullet_tank");

		public SpikedHumanBulletTankEntity(NarutoShippudenModElements instance) {
			super(instance, 1160);
			FMLJavaModLoadingContext.get().getModEventBus().register(new SpikedHumanBulletTankRenderer.ModelRegisterHandler());
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
}
