package net.mcreator.narutoshippudenmod.entity;

import net.mcreator.narutoshippudenmod.NarutoShippudenModElements;
import net.mcreator.narutoshippudenmod.entity.renderer.SusanoRenderers.ArmoredSusanoMadaraRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.SusanoRenderers.ArmoredSusanoSasukeRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.SusanoRenderers.ArmoredSusanoShisuiRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.SusanoRenderers.HumanoidSusanoItachiRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.SusanoRenderers.HumanoidSusanoMadaraRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.SusanoRenderers.HumanoidSusanoObitoRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.SusanoRenderers.HumanoidSusanoSasukeRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.SusanoRenderers.HumanoidSusanoShisuiRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.SusanoRenderers.RibcageSusanoRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.SusanoRenderers.SkeletonSusanoItachiRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.SusanoRenderers.SkeletonSusanoMadaraRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.SusanoRenderers.SkeletonSusanoObitoRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.SusanoRenderers.SkeletonSusanoSasukeRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.SusanoRenderers.SkeletonSusanoShisuiRenderer;
import net.minecraft.entity.AreaEffectCloudEntity;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.entity.projectile.PotionEntity;
import net.minecraft.network.IPacket;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.registries.ForgeRegistries;

public final class SusanoEntities {
	private SusanoEntities() {
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class ArmoredSusanoMadaraEntity extends NarutoShippudenModElements.ModElement {
		public static EntityType entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER)
				.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).immuneToFire()
				.size(0.2f, 0.2f)).build("armored_susano_madara").setRegistryName("armored_susano_madara");

		public ArmoredSusanoMadaraEntity(NarutoShippudenModElements instance) {
			super(instance, 1267);
			FMLJavaModLoadingContext.get().getModEventBus().register(new ArmoredSusanoMadaraRenderer.ModelRegisterHandler());
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
	public static class ArmoredSusanoSasukeEntity extends NarutoShippudenModElements.ModElement {
		public static EntityType entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER)
				.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).immuneToFire()
				.size(0.2f, 0.2f)).build("armored_susano_sasuke").setRegistryName("armored_susano_sasuke");

		public ArmoredSusanoSasukeEntity(NarutoShippudenModElements instance) {
			super(instance, 1334);
			FMLJavaModLoadingContext.get().getModEventBus().register(new ArmoredSusanoSasukeRenderer.ModelRegisterHandler());
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
	public static class ArmoredSusanoShisuiEntity extends NarutoShippudenModElements.ModElement {
		public static EntityType entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER)
				.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).immuneToFire()
				.size(0.2f, 0.2f)).build("armored_susano_shisui").setRegistryName("armored_susano_shisui");

		public ArmoredSusanoShisuiEntity(NarutoShippudenModElements instance) {
			super(instance, 1333);
			FMLJavaModLoadingContext.get().getModEventBus().register(new ArmoredSusanoShisuiRenderer.ModelRegisterHandler());
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
	public static class HumanoidSusanoItachiEntity extends NarutoShippudenModElements.ModElement {
		public static EntityType entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER)
				.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).immuneToFire()
				.size(0.2f, 0.2f)).build("humanoid_susano_itachi").setRegistryName("humanoid_susano_itachi");

		public HumanoidSusanoItachiEntity(NarutoShippudenModElements instance) {
			super(instance, 1263);
			FMLJavaModLoadingContext.get().getModEventBus().register(new HumanoidSusanoItachiRenderer.ModelRegisterHandler());
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
	public static class HumanoidSusanoMadaraEntity extends NarutoShippudenModElements.ModElement {
		public static EntityType entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER)
				.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).immuneToFire()
				.size(0.2f, 0.2f)).build("humanoid_susano_madara").setRegistryName("humanoid_susano_madara");

		public HumanoidSusanoMadaraEntity(NarutoShippudenModElements instance) {
			super(instance, 1335);
			FMLJavaModLoadingContext.get().getModEventBus().register(new HumanoidSusanoMadaraRenderer.ModelRegisterHandler());
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
	public static class HumanoidSusanoObitoEntity extends NarutoShippudenModElements.ModElement {
		public static EntityType entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER)
				.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).immuneToFire()
				.size(0.2f, 0.2f)).build("humanoid_susano_obito").setRegistryName("humanoid_susano_obito");

		public HumanoidSusanoObitoEntity(NarutoShippudenModElements instance) {
			super(instance, 1265);
			FMLJavaModLoadingContext.get().getModEventBus().register(new HumanoidSusanoObitoRenderer.ModelRegisterHandler());
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
	public static class HumanoidSusanoSasukeEntity extends NarutoShippudenModElements.ModElement {
		public static EntityType entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER)
				.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).immuneToFire()
				.size(0.2f, 0.2f)).build("humanoid_susano_sasuke").setRegistryName("humanoid_susano_sasuke");

		public HumanoidSusanoSasukeEntity(NarutoShippudenModElements instance) {
			super(instance, 1266);
			FMLJavaModLoadingContext.get().getModEventBus().register(new HumanoidSusanoSasukeRenderer.ModelRegisterHandler());
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
	public static class HumanoidSusanoShisuiEntity extends NarutoShippudenModElements.ModElement {
		public static EntityType entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER)
				.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).immuneToFire()
				.size(0.2f, 0.2f)).build("humanoid_susano_shisui").setRegistryName("humanoid_susano_shisui");

		public HumanoidSusanoShisuiEntity(NarutoShippudenModElements instance) {
			super(instance, 1264);
			FMLJavaModLoadingContext.get().getModEventBus().register(new HumanoidSusanoShisuiRenderer.ModelRegisterHandler());
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
	public static class RibcageSusanoEntity extends NarutoShippudenModElements.ModElement {
		public static EntityType entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER)
				.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).immuneToFire()
				.size(0.2f, 0.2f)).build("ribcage_susano").setRegistryName("ribcage_susano");

		public RibcageSusanoEntity(NarutoShippudenModElements instance) {
			super(instance, 1219);
			FMLJavaModLoadingContext.get().getModEventBus().register(new RibcageSusanoRenderer.ModelRegisterHandler());
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
	public static class SkeletonSusanoItachiEntity extends NarutoShippudenModElements.ModElement {
		public static EntityType entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER)
				.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).immuneToFire()
				.size(0.2f, 0.2f)).build("skeleton_susano_itachi").setRegistryName("skeleton_susano_itachi");

		public SkeletonSusanoItachiEntity(NarutoShippudenModElements instance) {
			super(instance, 1222);
			FMLJavaModLoadingContext.get().getModEventBus().register(new SkeletonSusanoItachiRenderer.ModelRegisterHandler());
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
	public static class SkeletonSusanoMadaraEntity extends NarutoShippudenModElements.ModElement {
		public static EntityType entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER)
				.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).immuneToFire()
				.size(0.2f, 0.2f)).build("skeleton_susano_madara").setRegistryName("skeleton_susano_madara");

		public SkeletonSusanoMadaraEntity(NarutoShippudenModElements instance) {
			super(instance, 1223);
			FMLJavaModLoadingContext.get().getModEventBus().register(new SkeletonSusanoMadaraRenderer.ModelRegisterHandler());
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
	public static class SkeletonSusanoObitoEntity extends NarutoShippudenModElements.ModElement {
		public static EntityType entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER)
				.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).immuneToFire()
				.size(0.2f, 0.2f)).build("skeleton_susano_obito").setRegistryName("skeleton_susano_obito");

		public SkeletonSusanoObitoEntity(NarutoShippudenModElements instance) {
			super(instance, 1224);
			FMLJavaModLoadingContext.get().getModEventBus().register(new SkeletonSusanoObitoRenderer.ModelRegisterHandler());
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
	public static class SkeletonSusanoSasukeEntity extends NarutoShippudenModElements.ModElement {
		public static EntityType entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER)
				.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).immuneToFire()
				.size(0.2f, 0.2f)).build("skeleton_susano_sasuke").setRegistryName("skeleton_susano_sasuke");

		public SkeletonSusanoSasukeEntity(NarutoShippudenModElements instance) {
			super(instance, 1221);
			FMLJavaModLoadingContext.get().getModEventBus().register(new SkeletonSusanoSasukeRenderer.ModelRegisterHandler());
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
	public static class SkeletonSusanoShisuiEntity extends NarutoShippudenModElements.ModElement {
		public static EntityType entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER)
				.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).immuneToFire()
				.size(0.2f, 0.2f)).build("skeleton_susano_shisui").setRegistryName("skeleton_susano_shisui");

		public SkeletonSusanoShisuiEntity(NarutoShippudenModElements instance) {
			super(instance, 1225);
			FMLJavaModLoadingContext.get().getModEventBus().register(new SkeletonSusanoShisuiRenderer.ModelRegisterHandler());
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
}
