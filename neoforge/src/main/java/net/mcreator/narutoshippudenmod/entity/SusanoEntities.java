package net.mcreator.narutoshippudenmod.entity;

import net.mcreator.narutoshippudenmod.compat.Compat;
import net.mcreator.narutoshippudenmod.compat.Registration;
import net.mcreator.narutoshippudenmod.NarutoShippudenMod;
import net.minecraft.server.level.ServerLevel;

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
import net.minecraft.world.entity.AreaEffectCloud;

import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.arrow.AbstractArrow;
import net.minecraft.world.entity.projectile.throwableitemprojectile.ThrownSplashPotion;
import net.minecraft.network.protocol.Packet;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;



import net.minecraft.core.registries.BuiltInRegistries;

public final class SusanoEntities {
	private SusanoEntities() {
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class ArmoredSusanoMadaraEntity extends NarutoShippudenModElements.ModElement {
		public static EntityType<CustomEntity> entity;

		public ArmoredSusanoMadaraEntity(NarutoShippudenModElements instance) {
			super(instance, 1267);
			Registration.listen(NarutoShippudenMod.MOD_BUS, new EntityAttributesRegisterHandler());
		}

		@Override
		public void initElements() {
			elements.entities.add(() -> entity = (EntityType.Builder.<CustomEntity>of(CustomEntity::new, MobCategory.MONSTER) .setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune() .sized(0.2f, 0.2f)).build(Registration.entityKey("armored_susano_madara")));
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
	public static class ArmoredSusanoSasukeEntity extends NarutoShippudenModElements.ModElement {
		public static EntityType<CustomEntity> entity;

		public ArmoredSusanoSasukeEntity(NarutoShippudenModElements instance) {
			super(instance, 1334);
			Registration.listen(NarutoShippudenMod.MOD_BUS, new EntityAttributesRegisterHandler());
		}

		@Override
		public void initElements() {
			elements.entities.add(() -> entity = (EntityType.Builder.<CustomEntity>of(CustomEntity::new, MobCategory.MONSTER) .setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune() .sized(0.2f, 0.2f)).build(Registration.entityKey("armored_susano_sasuke")));
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
	public static class ArmoredSusanoShisuiEntity extends NarutoShippudenModElements.ModElement {
		public static EntityType<CustomEntity> entity;

		public ArmoredSusanoShisuiEntity(NarutoShippudenModElements instance) {
			super(instance, 1333);
			Registration.listen(NarutoShippudenMod.MOD_BUS, new EntityAttributesRegisterHandler());
		}

		@Override
		public void initElements() {
			elements.entities.add(() -> entity = (EntityType.Builder.<CustomEntity>of(CustomEntity::new, MobCategory.MONSTER) .setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune() .sized(0.2f, 0.2f)).build(Registration.entityKey("armored_susano_shisui")));
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
	public static class HumanoidSusanoItachiEntity extends NarutoShippudenModElements.ModElement {
		public static EntityType<CustomEntity> entity;

		public HumanoidSusanoItachiEntity(NarutoShippudenModElements instance) {
			super(instance, 1263);
			Registration.listen(NarutoShippudenMod.MOD_BUS, new EntityAttributesRegisterHandler());
		}

		@Override
		public void initElements() {
			elements.entities.add(() -> entity = (EntityType.Builder.<CustomEntity>of(CustomEntity::new, MobCategory.MONSTER) .setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune() .sized(0.2f, 0.2f)).build(Registration.entityKey("humanoid_susano_itachi")));
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
	public static class HumanoidSusanoMadaraEntity extends NarutoShippudenModElements.ModElement {
		public static EntityType<CustomEntity> entity;

		public HumanoidSusanoMadaraEntity(NarutoShippudenModElements instance) {
			super(instance, 1335);
			Registration.listen(NarutoShippudenMod.MOD_BUS, new EntityAttributesRegisterHandler());
		}

		@Override
		public void initElements() {
			elements.entities.add(() -> entity = (EntityType.Builder.<CustomEntity>of(CustomEntity::new, MobCategory.MONSTER) .setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune() .sized(0.2f, 0.2f)).build(Registration.entityKey("humanoid_susano_madara")));
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
	public static class HumanoidSusanoObitoEntity extends NarutoShippudenModElements.ModElement {
		public static EntityType<CustomEntity> entity;

		public HumanoidSusanoObitoEntity(NarutoShippudenModElements instance) {
			super(instance, 1265);
			Registration.listen(NarutoShippudenMod.MOD_BUS, new EntityAttributesRegisterHandler());
		}

		@Override
		public void initElements() {
			elements.entities.add(() -> entity = (EntityType.Builder.<CustomEntity>of(CustomEntity::new, MobCategory.MONSTER) .setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune() .sized(0.2f, 0.2f)).build(Registration.entityKey("humanoid_susano_obito")));
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
	public static class HumanoidSusanoSasukeEntity extends NarutoShippudenModElements.ModElement {
		public static EntityType<CustomEntity> entity;

		public HumanoidSusanoSasukeEntity(NarutoShippudenModElements instance) {
			super(instance, 1266);
			Registration.listen(NarutoShippudenMod.MOD_BUS, new EntityAttributesRegisterHandler());
		}

		@Override
		public void initElements() {
			elements.entities.add(() -> entity = (EntityType.Builder.<CustomEntity>of(CustomEntity::new, MobCategory.MONSTER) .setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune() .sized(0.2f, 0.2f)).build(Registration.entityKey("humanoid_susano_sasuke")));
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
	public static class HumanoidSusanoShisuiEntity extends NarutoShippudenModElements.ModElement {
		public static EntityType<CustomEntity> entity;

		public HumanoidSusanoShisuiEntity(NarutoShippudenModElements instance) {
			super(instance, 1264);
			Registration.listen(NarutoShippudenMod.MOD_BUS, new EntityAttributesRegisterHandler());
		}

		@Override
		public void initElements() {
			elements.entities.add(() -> entity = (EntityType.Builder.<CustomEntity>of(CustomEntity::new, MobCategory.MONSTER) .setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune() .sized(0.2f, 0.2f)).build(Registration.entityKey("humanoid_susano_shisui")));
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
	public static class RibcageSusanoEntity extends NarutoShippudenModElements.ModElement {
		public static EntityType<CustomEntity> entity;

		public RibcageSusanoEntity(NarutoShippudenModElements instance) {
			super(instance, 1219);
			Registration.listen(NarutoShippudenMod.MOD_BUS, new EntityAttributesRegisterHandler());
		}

		@Override
		public void initElements() {
			elements.entities.add(() -> entity = (EntityType.Builder.<CustomEntity>of(CustomEntity::new, MobCategory.MONSTER) .setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune() .sized(0.2f, 0.2f)).build(Registration.entityKey("ribcage_susano")));
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
	public static class SkeletonSusanoItachiEntity extends NarutoShippudenModElements.ModElement {
		public static EntityType<CustomEntity> entity;

		public SkeletonSusanoItachiEntity(NarutoShippudenModElements instance) {
			super(instance, 1222);
			Registration.listen(NarutoShippudenMod.MOD_BUS, new EntityAttributesRegisterHandler());
		}

		@Override
		public void initElements() {
			elements.entities.add(() -> entity = (EntityType.Builder.<CustomEntity>of(CustomEntity::new, MobCategory.MONSTER) .setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune() .sized(0.2f, 0.2f)).build(Registration.entityKey("skeleton_susano_itachi")));
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
	public static class SkeletonSusanoMadaraEntity extends NarutoShippudenModElements.ModElement {
		public static EntityType<CustomEntity> entity;

		public SkeletonSusanoMadaraEntity(NarutoShippudenModElements instance) {
			super(instance, 1223);
			Registration.listen(NarutoShippudenMod.MOD_BUS, new EntityAttributesRegisterHandler());
		}

		@Override
		public void initElements() {
			elements.entities.add(() -> entity = (EntityType.Builder.<CustomEntity>of(CustomEntity::new, MobCategory.MONSTER) .setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune() .sized(0.2f, 0.2f)).build(Registration.entityKey("skeleton_susano_madara")));
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
	public static class SkeletonSusanoObitoEntity extends NarutoShippudenModElements.ModElement {
		public static EntityType<CustomEntity> entity;

		public SkeletonSusanoObitoEntity(NarutoShippudenModElements instance) {
			super(instance, 1224);
			Registration.listen(NarutoShippudenMod.MOD_BUS, new EntityAttributesRegisterHandler());
		}

		@Override
		public void initElements() {
			elements.entities.add(() -> entity = (EntityType.Builder.<CustomEntity>of(CustomEntity::new, MobCategory.MONSTER) .setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune() .sized(0.2f, 0.2f)).build(Registration.entityKey("skeleton_susano_obito")));
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
	public static class SkeletonSusanoSasukeEntity extends NarutoShippudenModElements.ModElement {
		public static EntityType<CustomEntity> entity;

		public SkeletonSusanoSasukeEntity(NarutoShippudenModElements instance) {
			super(instance, 1221);
			Registration.listen(NarutoShippudenMod.MOD_BUS, new EntityAttributesRegisterHandler());
		}

		@Override
		public void initElements() {
			elements.entities.add(() -> entity = (EntityType.Builder.<CustomEntity>of(CustomEntity::new, MobCategory.MONSTER) .setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune() .sized(0.2f, 0.2f)).build(Registration.entityKey("skeleton_susano_sasuke")));
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
	public static class SkeletonSusanoShisuiEntity extends NarutoShippudenModElements.ModElement {
		public static EntityType<CustomEntity> entity;

		public SkeletonSusanoShisuiEntity(NarutoShippudenModElements instance) {
			super(instance, 1225);
			Registration.listen(NarutoShippudenMod.MOD_BUS, new EntityAttributesRegisterHandler());
		}

		@Override
		public void initElements() {
			elements.entities.add(() -> entity = (EntityType.Builder.<CustomEntity>of(CustomEntity::new, MobCategory.MONSTER) .setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune() .sized(0.2f, 0.2f)).build(Registration.entityKey("skeleton_susano_shisui")));
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
}
