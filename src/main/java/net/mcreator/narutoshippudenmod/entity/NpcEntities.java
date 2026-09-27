package net.mcreator.narutoshippudenmod.entity;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;
import javax.annotation.Nullable;
import net.mcreator.narutoshippudenmod.NarutoShippudenModElements;
import net.mcreator.narutoshippudenmod.entity.renderer.NpcRenderers.AsumaRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.NpcRenderers.EarthGolemShinobiRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.NpcRenderers.HiddenCloudShinobiRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.NpcRenderers.HiddenLeafShinobiRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.NpcRenderers.HiddenMistShinobiRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.NpcRenderers.HiddenSandShinobiRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.NpcRenderers.HiddenStoneShinobiRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.NpcRenderers.IrukaSenseiCloneRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.NpcRenderers.IrukaSenseiRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.NpcRenderers.ShikamaruRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.NpcRenderers.TrainingDummyRenderer;
import net.mcreator.narutoshippudenmod.item.WeaponItems.ChakraBladeItem;
import net.mcreator.narutoshippudenmod.itemgroup.ModItemGroups.SpawnEggsItemGroup;
import net.mcreator.narutoshippudenmod.procedures.ClanProcedures.ShadowCloneEntityDiesProcedure;
import net.mcreator.narutoshippudenmod.procedures.EntityProcedures.AsumaEntityIsHurtProcedure;
import net.mcreator.narutoshippudenmod.procedures.EntityProcedures.AsumaOnEntityTickUpdateProcedure;
import net.mcreator.narutoshippudenmod.procedures.EntityProcedures.AsumaRightClickedOnEntityProcedure;
import net.mcreator.narutoshippudenmod.procedures.EntityProcedures.EarthGolemShinobiOnInitialEntitySpawnProcedure;
import net.mcreator.narutoshippudenmod.procedures.EntityProcedures.HiddenCloudShinobiOnEntityTickUpdateProcedure;
import net.mcreator.narutoshippudenmod.procedures.EntityProcedures.HiddenLeafShinobiOnEntityTickUpdateProcedure;
import net.mcreator.narutoshippudenmod.procedures.EntityProcedures.HiddenMistShinobiOnEntityTickUpdateProcedure;
import net.mcreator.narutoshippudenmod.procedures.EntityProcedures.HiddenSandShinobiOnEntityTickUpdateProcedure;
import net.mcreator.narutoshippudenmod.procedures.EntityProcedures.HiddenShinobiEntityDiesProcedure;
import net.mcreator.narutoshippudenmod.procedures.EntityProcedures.HiddenShinobiKillsEntityProcedure;
import net.mcreator.narutoshippudenmod.procedures.EntityProcedures.HiddenStoneShinobiOnEntityTickUpdateProcedure;
import net.mcreator.narutoshippudenmod.procedures.EntityProcedures.IrukaSenseiCloneOnInitialEntitySpawnProcedure;
import net.mcreator.narutoshippudenmod.procedures.EntityProcedures.IrukaSenseiOnEntityTickUpdateProcedure;
import net.mcreator.narutoshippudenmod.procedures.EntityProcedures.NarutoShippudenEntityChakraProcedure;
import net.mcreator.narutoshippudenmod.procedures.EntityProcedures.ShikamaruRightClickedOnEntityProcedure;
import net.mcreator.narutoshippudenmod.procedures.EntityProcedures.TrainingDummyEntityIsHurtProcedure;
import net.mcreator.narutoshippudenmod.procedures.EntityProcedures.TrainingDummyOnEntityTickUpdateProcedure;
import net.minecraft.block.material.Material;
import net.minecraft.entity.AreaEffectCloudEntity;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.LeapAtTargetGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.entity.projectile.PotionEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.gen.Heightmap;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.registries.ForgeRegistries;

public final class NpcEntities {
	private NpcEntities() {
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class AsumaEntity extends NarutoShippudenModElements.ModElement {
		public static EntityType entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.CREATURE)
				.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new)
				.size(0.6f, 1.8f)).build("asuma").setRegistryName("asuma");

		public AsumaEntity(NarutoShippudenModElements instance) {
			super(instance, 390);
			FMLJavaModLoadingContext.get().getModEventBus().register(new AsumaRenderer.ModelRegisterHandler());
			FMLJavaModLoadingContext.get().getModEventBus().register(new EntityAttributesRegisterHandler());
			MinecraftForge.EVENT_BUS.register(this);
		}

		@Override
		public void initElements() {
			elements.entities.add(() -> entity);
			elements.items.add(() -> new SpawnEggItem(entity, -11513752, -7510683, new Item.Properties().group(SpawnEggsItemGroup.tab))
					.setRegistryName("asuma_spawn_egg"));
		}

		@SubscribeEvent
		public void addFeatureToBiomes(BiomeLoadingEvent event) {
			boolean biomeCriteria = false;
			if (new ResourceLocation("plains").equals(event.getName()))
				biomeCriteria = true;
			if (new ResourceLocation("taiga_mountains").equals(event.getName()))
				biomeCriteria = true;
			if (new ResourceLocation("river").equals(event.getName()))
				biomeCriteria = true;
			if (!biomeCriteria)
				return;
			event.getSpawns().getSpawner(EntityClassification.CREATURE).add(new MobSpawnInfo.Spawners(entity, 10, 1, 1));
		}

		@Override
		public void init(FMLCommonSetupEvent event) {
			EntitySpawnPlacementRegistry.register(entity, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
					(entityType, world, reason, pos,
							random) -> (world.getBlockState(pos.down()).getMaterial() == Material.ORGANIC && world.getLightSubtracted(pos, 0) > 8));
		}

		private static class EntityAttributesRegisterHandler {
			@SubscribeEvent
			public void onEntityAttributeCreation(EntityAttributeCreationEvent event) {
				AttributeModifierMap.MutableAttribute ammma = MobEntity.func_233666_p_();
				ammma = ammma.createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.3);
				ammma = ammma.createMutableAttribute(Attributes.MAX_HEALTH, 200);
				ammma = ammma.createMutableAttribute(Attributes.ARMOR, 0);
				ammma = ammma.createMutableAttribute(Attributes.ATTACK_DAMAGE, 4);
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
				this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(ChakraBladeItem.block));
				this.setItemStackToSlot(EquipmentSlotType.OFFHAND, new ItemStack(ChakraBladeItem.block));
			}

			@Override
			public IPacket<?> createSpawnPacket() {
				return NetworkHooks.getEntitySpawningPacket(this);
			}

			@Override
			protected void registerGoals() {
				super.registerGoals();
				this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.5, true) {
					@Override
					protected double getAttackReachSqr(LivingEntity entity) {
						return (double) (4.0 + entity.getWidth() * entity.getWidth());
					}
				});
				this.goalSelector.addGoal(2, new RandomWalkingGoal(this, 0.8));
				this.targetSelector.addGoal(3, new HurtByTargetGoal(this));
				this.goalSelector.addGoal(4, new LookRandomlyGoal(this));
				this.goalSelector.addGoal(5, new SwimGoal(this));
			}

			@Override
			public CreatureAttribute getCreatureAttribute() {
				return CreatureAttribute.UNDEFINED;
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
				double x = this.getPosX();
				double y = this.getPosY();
				double z = this.getPosZ();
				Entity entity = this;
				Entity sourceentity = source.getTrueSource();

				AsumaEntityIsHurtProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z), new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
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

				NarutoShippudenEntityChakraProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return retval;
			}

			@Override
			public ActionResultType func_230254_b_(PlayerEntity sourceentity, Hand hand) {
				ItemStack itemstack = sourceentity.getHeldItem(hand);
				ActionResultType retval = ActionResultType.func_233537_a_(this.world.isRemote());
				super.func_230254_b_(sourceentity, hand);
				double x = this.getPosX();
				double y = this.getPosY();
				double z = this.getPosZ();
				Entity entity = this;

				AsumaRightClickedOnEntityProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z), new AbstractMap.SimpleEntry<>("sourceentity", sourceentity))
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

				AsumaOnEntityTickUpdateProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z), new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class EarthGolemShinobiEntity extends NarutoShippudenModElements.ModElement {
		public static EntityType entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER)
				.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new)
				.size(1.5f, 3.5f)).build("earth_golem_shinobi").setRegistryName("earth_golem_shinobi");

		public EarthGolemShinobiEntity(NarutoShippudenModElements instance) {
			super(instance, 1108);
			FMLJavaModLoadingContext.get().getModEventBus().register(new EarthGolemShinobiRenderer.ModelRegisterHandler());
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
				ammma = ammma.createMutableAttribute(Attributes.ATTACK_DAMAGE, 8);
				ammma = ammma.createMutableAttribute(Attributes.FOLLOW_RANGE, 16);
				ammma = ammma.createMutableAttribute(Attributes.KNOCKBACK_RESISTANCE, 1);
				ammma = ammma.createMutableAttribute(Attributes.ATTACK_KNOCKBACK, 2);
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
				this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.2, true) {
					@Override
					protected double getAttackReachSqr(LivingEntity entity) {
						return (double) (4.0 + entity.getWidth() * entity.getWidth());
					}
				});
				this.targetSelector.addGoal(2, new HurtByTargetGoal(this));
				this.goalSelector.addGoal(3, new RandomWalkingGoal(this, 0.8));
				this.goalSelector.addGoal(4, new LookRandomlyGoal(this));
				this.targetSelector.addGoal(5, new NearestAttackableTargetGoal(this, PlayerEntity.class, false, false));
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

				EarthGolemShinobiOnInitialEntitySpawnProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return retval;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class HiddenCloudShinobiEntity extends NarutoShippudenModElements.ModElement {
		public static EntityType entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.CREATURE)
				.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new)
				.size(0.6f, 1.8f)).build("hidden_cloud_shinobi").setRegistryName("hidden_cloud_shinobi");

		public HiddenCloudShinobiEntity(NarutoShippudenModElements instance) {
			super(instance, 1102);
			FMLJavaModLoadingContext.get().getModEventBus().register(new HiddenCloudShinobiRenderer.ModelRegisterHandler());
			FMLJavaModLoadingContext.get().getModEventBus().register(new EntityAttributesRegisterHandler());
			MinecraftForge.EVENT_BUS.register(this);
		}

		@Override
		public void initElements() {
			elements.entities.add(() -> entity);
			elements.items.add(() -> new SpawnEggItem(entity, -591950, -11311731, new Item.Properties().group(SpawnEggsItemGroup.tab))
					.setRegistryName("hidden_cloud_shinobi_spawn_egg"));
		}

		@SubscribeEvent
		public void addFeatureToBiomes(BiomeLoadingEvent event) {
			boolean biomeCriteria = false;
			if (new ResourceLocation("plains").equals(event.getName()))
				biomeCriteria = true;
			if (new ResourceLocation("taiga_mountains").equals(event.getName()))
				biomeCriteria = true;
			if (new ResourceLocation("river").equals(event.getName()))
				biomeCriteria = true;
			if (!biomeCriteria)
				return;
			event.getSpawns().getSpawner(EntityClassification.CREATURE).add(new MobSpawnInfo.Spawners(entity, 10, 1, 1));
		}

		@Override
		public void init(FMLCommonSetupEvent event) {
			EntitySpawnPlacementRegistry.register(entity, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
					(entityType, world, reason, pos,
							random) -> (world.getBlockState(pos.down()).getMaterial() == Material.ORGANIC && world.getLightSubtracted(pos, 0) > 8));
		}

		private static class EntityAttributesRegisterHandler {
			@SubscribeEvent
			public void onEntityAttributeCreation(EntityAttributeCreationEvent event) {
				AttributeModifierMap.MutableAttribute ammma = MobEntity.func_233666_p_();
				ammma = ammma.createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.3);
				ammma = ammma.createMutableAttribute(Attributes.MAX_HEALTH, 40);
				ammma = ammma.createMutableAttribute(Attributes.ARMOR, 0);
				ammma = ammma.createMutableAttribute(Attributes.ATTACK_DAMAGE, 4);
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
			}

			@Override
			public IPacket<?> createSpawnPacket() {
				return NetworkHooks.getEntitySpawningPacket(this);
			}

			@Override
			protected void registerGoals() {
				super.registerGoals();
				this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.5, true) {
					@Override
					protected double getAttackReachSqr(LivingEntity entity) {
						return (double) (4.0 + entity.getWidth() * entity.getWidth());
					}
				});
				this.goalSelector.addGoal(2, new RandomWalkingGoal(this, 0.8));
				this.targetSelector.addGoal(3, new HurtByTargetGoal(this));
				this.goalSelector.addGoal(4, new LookRandomlyGoal(this));
				this.goalSelector.addGoal(5, new SwimGoal(this));
			}

			@Override
			public CreatureAttribute getCreatureAttribute() {
				return CreatureAttribute.UNDEFINED;
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
				if (source == DamageSource.CACTUS)
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

				HiddenShinobiEntityDiesProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z), new AbstractMap.SimpleEntry<>("entity", entity),
								new AbstractMap.SimpleEntry<>("sourceentity", sourceentity))
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

				NarutoShippudenEntityChakraProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return retval;
			}

			@Override
			public void awardKillScore(Entity entity, int score, DamageSource damageSource) {
				super.awardKillScore(entity, score, damageSource);
				double x = this.getPosX();
				double y = this.getPosY();
				double z = this.getPosZ();
				Entity sourceentity = this;

				HiddenShinobiKillsEntityProcedure.executeProcedure(
						Stream.of(new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("sourceentity", sourceentity))
								.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}

			@Override
			public void baseTick() {
				super.baseTick();
				double x = this.getPosX();
				double y = this.getPosY();
				double z = this.getPosZ();
				Entity entity = this;

				HiddenCloudShinobiOnEntityTickUpdateProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z), new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class HiddenLeafShinobiEntity extends NarutoShippudenModElements.ModElement {
		public static EntityType entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.CREATURE)
				.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new)
				.size(0.6f, 1.8f)).build("hidden_leaf_shinobi").setRegistryName("hidden_leaf_shinobi");

		public HiddenLeafShinobiEntity(NarutoShippudenModElements instance) {
			super(instance, 1098);
			FMLJavaModLoadingContext.get().getModEventBus().register(new HiddenLeafShinobiRenderer.ModelRegisterHandler());
			FMLJavaModLoadingContext.get().getModEventBus().register(new EntityAttributesRegisterHandler());
			MinecraftForge.EVENT_BUS.register(this);
		}

		@Override
		public void initElements() {
			elements.entities.add(() -> entity);
			elements.items.add(() -> new SpawnEggItem(entity, -13750738, -13024682, new Item.Properties().group(SpawnEggsItemGroup.tab))
					.setRegistryName("hidden_leaf_shinobi_spawn_egg"));
		}

		@SubscribeEvent
		public void addFeatureToBiomes(BiomeLoadingEvent event) {
			boolean biomeCriteria = false;
			if (new ResourceLocation("plains").equals(event.getName()))
				biomeCriteria = true;
			if (new ResourceLocation("taiga_mountains").equals(event.getName()))
				biomeCriteria = true;
			if (new ResourceLocation("river").equals(event.getName()))
				biomeCriteria = true;
			if (!biomeCriteria)
				return;
			event.getSpawns().getSpawner(EntityClassification.CREATURE).add(new MobSpawnInfo.Spawners(entity, 10, 1, 1));
		}

		@Override
		public void init(FMLCommonSetupEvent event) {
			EntitySpawnPlacementRegistry.register(entity, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
					(entityType, world, reason, pos,
							random) -> (world.getBlockState(pos.down()).getMaterial() == Material.ORGANIC && world.getLightSubtracted(pos, 0) > 8));
		}

		private static class EntityAttributesRegisterHandler {
			@SubscribeEvent
			public void onEntityAttributeCreation(EntityAttributeCreationEvent event) {
				AttributeModifierMap.MutableAttribute ammma = MobEntity.func_233666_p_();
				ammma = ammma.createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.3);
				ammma = ammma.createMutableAttribute(Attributes.MAX_HEALTH, 40);
				ammma = ammma.createMutableAttribute(Attributes.ARMOR, 0);
				ammma = ammma.createMutableAttribute(Attributes.ATTACK_DAMAGE, 4);
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
			}

			@Override
			public IPacket<?> createSpawnPacket() {
				return NetworkHooks.getEntitySpawningPacket(this);
			}

			@Override
			protected void registerGoals() {
				super.registerGoals();
				this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.5, true) {
					@Override
					protected double getAttackReachSqr(LivingEntity entity) {
						return (double) (4.0 + entity.getWidth() * entity.getWidth());
					}
				});
				this.goalSelector.addGoal(2, new RandomWalkingGoal(this, 0.8));
				this.targetSelector.addGoal(3, new HurtByTargetGoal(this));
				this.goalSelector.addGoal(4, new LookRandomlyGoal(this));
				this.goalSelector.addGoal(5, new SwimGoal(this));
			}

			@Override
			public CreatureAttribute getCreatureAttribute() {
				return CreatureAttribute.UNDEFINED;
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
				if (source == DamageSource.CACTUS)
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

				HiddenShinobiEntityDiesProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z), new AbstractMap.SimpleEntry<>("entity", entity),
								new AbstractMap.SimpleEntry<>("sourceentity", sourceentity))
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

				NarutoShippudenEntityChakraProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return retval;
			}

			@Override
			public void awardKillScore(Entity entity, int score, DamageSource damageSource) {
				super.awardKillScore(entity, score, damageSource);
				double x = this.getPosX();
				double y = this.getPosY();
				double z = this.getPosZ();
				Entity sourceentity = this;

				HiddenShinobiKillsEntityProcedure.executeProcedure(
						Stream.of(new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("sourceentity", sourceentity))
								.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}

			@Override
			public void baseTick() {
				super.baseTick();
				double x = this.getPosX();
				double y = this.getPosY();
				double z = this.getPosZ();
				Entity entity = this;

				HiddenLeafShinobiOnEntityTickUpdateProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z), new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class HiddenMistShinobiEntity extends NarutoShippudenModElements.ModElement {
		public static EntityType entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.CREATURE)
				.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new)
				.size(0.6f, 1.8f)).build("hidden_mist_shinobi").setRegistryName("hidden_mist_shinobi");

		public HiddenMistShinobiEntity(NarutoShippudenModElements instance) {
			super(instance, 1100);
			FMLJavaModLoadingContext.get().getModEventBus().register(new HiddenMistShinobiRenderer.ModelRegisterHandler());
			FMLJavaModLoadingContext.get().getModEventBus().register(new EntityAttributesRegisterHandler());
			MinecraftForge.EVENT_BUS.register(this);
		}

		@Override
		public void initElements() {
			elements.entities.add(() -> entity);
			elements.items.add(() -> new SpawnEggItem(entity, -11190234, -13024682, new Item.Properties().group(SpawnEggsItemGroup.tab))
					.setRegistryName("hidden_mist_shinobi_spawn_egg"));
		}

		@SubscribeEvent
		public void addFeatureToBiomes(BiomeLoadingEvent event) {
			boolean biomeCriteria = false;
			if (new ResourceLocation("plains").equals(event.getName()))
				biomeCriteria = true;
			if (new ResourceLocation("taiga_mountains").equals(event.getName()))
				biomeCriteria = true;
			if (new ResourceLocation("river").equals(event.getName()))
				biomeCriteria = true;
			if (!biomeCriteria)
				return;
			event.getSpawns().getSpawner(EntityClassification.CREATURE).add(new MobSpawnInfo.Spawners(entity, 10, 1, 1));
		}

		@Override
		public void init(FMLCommonSetupEvent event) {
			EntitySpawnPlacementRegistry.register(entity, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
					(entityType, world, reason, pos,
							random) -> (world.getBlockState(pos.down()).getMaterial() == Material.ORGANIC && world.getLightSubtracted(pos, 0) > 8));
		}

		private static class EntityAttributesRegisterHandler {
			@SubscribeEvent
			public void onEntityAttributeCreation(EntityAttributeCreationEvent event) {
				AttributeModifierMap.MutableAttribute ammma = MobEntity.func_233666_p_();
				ammma = ammma.createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.3);
				ammma = ammma.createMutableAttribute(Attributes.MAX_HEALTH, 40);
				ammma = ammma.createMutableAttribute(Attributes.ARMOR, 0);
				ammma = ammma.createMutableAttribute(Attributes.ATTACK_DAMAGE, 4);
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
			}

			@Override
			public IPacket<?> createSpawnPacket() {
				return NetworkHooks.getEntitySpawningPacket(this);
			}

			@Override
			protected void registerGoals() {
				super.registerGoals();
				this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.5, true) {
					@Override
					protected double getAttackReachSqr(LivingEntity entity) {
						return (double) (4.0 + entity.getWidth() * entity.getWidth());
					}
				});
				this.goalSelector.addGoal(2, new RandomWalkingGoal(this, 0.8));
				this.targetSelector.addGoal(3, new HurtByTargetGoal(this));
				this.goalSelector.addGoal(4, new LookRandomlyGoal(this));
				this.goalSelector.addGoal(5, new SwimGoal(this));
			}

			@Override
			public CreatureAttribute getCreatureAttribute() {
				return CreatureAttribute.UNDEFINED;
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
				if (source == DamageSource.CACTUS)
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

				HiddenShinobiEntityDiesProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z), new AbstractMap.SimpleEntry<>("entity", entity),
								new AbstractMap.SimpleEntry<>("sourceentity", sourceentity))
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

				NarutoShippudenEntityChakraProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return retval;
			}

			@Override
			public void awardKillScore(Entity entity, int score, DamageSource damageSource) {
				super.awardKillScore(entity, score, damageSource);
				double x = this.getPosX();
				double y = this.getPosY();
				double z = this.getPosZ();
				Entity sourceentity = this;

				HiddenShinobiKillsEntityProcedure.executeProcedure(
						Stream.of(new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("sourceentity", sourceentity))
								.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}

			@Override
			public void baseTick() {
				super.baseTick();
				double x = this.getPosX();
				double y = this.getPosY();
				double z = this.getPosZ();
				Entity entity = this;

				HiddenMistShinobiOnEntityTickUpdateProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z), new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class HiddenSandShinobiEntity extends NarutoShippudenModElements.ModElement {
		public static EntityType entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.CREATURE)
				.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new)
				.size(0.6f, 1.8f)).build("hidden_sand_shinobi").setRegistryName("hidden_sand_shinobi");

		public HiddenSandShinobiEntity(NarutoShippudenModElements instance) {
			super(instance, 1104);
			FMLJavaModLoadingContext.get().getModEventBus().register(new HiddenSandShinobiRenderer.ModelRegisterHandler());
			FMLJavaModLoadingContext.get().getModEventBus().register(new EntityAttributesRegisterHandler());
			MinecraftForge.EVENT_BUS.register(this);
		}

		@Override
		public void initElements() {
			elements.entities.add(() -> entity);
			elements.items.add(() -> new SpawnEggItem(entity, -10066330, -15132391, new Item.Properties().group(SpawnEggsItemGroup.tab))
					.setRegistryName("hidden_sand_shinobi_spawn_egg"));
		}

		@SubscribeEvent
		public void addFeatureToBiomes(BiomeLoadingEvent event) {
			boolean biomeCriteria = false;
			if (new ResourceLocation("plains").equals(event.getName()))
				biomeCriteria = true;
			if (new ResourceLocation("taiga_mountains").equals(event.getName()))
				biomeCriteria = true;
			if (new ResourceLocation("river").equals(event.getName()))
				biomeCriteria = true;
			if (!biomeCriteria)
				return;
			event.getSpawns().getSpawner(EntityClassification.CREATURE).add(new MobSpawnInfo.Spawners(entity, 10, 1, 1));
		}

		@Override
		public void init(FMLCommonSetupEvent event) {
			EntitySpawnPlacementRegistry.register(entity, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
					(entityType, world, reason, pos,
							random) -> (world.getBlockState(pos.down()).getMaterial() == Material.ORGANIC && world.getLightSubtracted(pos, 0) > 8));
		}

		private static class EntityAttributesRegisterHandler {
			@SubscribeEvent
			public void onEntityAttributeCreation(EntityAttributeCreationEvent event) {
				AttributeModifierMap.MutableAttribute ammma = MobEntity.func_233666_p_();
				ammma = ammma.createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.3);
				ammma = ammma.createMutableAttribute(Attributes.MAX_HEALTH, 40);
				ammma = ammma.createMutableAttribute(Attributes.ARMOR, 0);
				ammma = ammma.createMutableAttribute(Attributes.ATTACK_DAMAGE, 4);
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
			}

			@Override
			public IPacket<?> createSpawnPacket() {
				return NetworkHooks.getEntitySpawningPacket(this);
			}

			@Override
			protected void registerGoals() {
				super.registerGoals();
				this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.5, true) {
					@Override
					protected double getAttackReachSqr(LivingEntity entity) {
						return (double) (4.0 + entity.getWidth() * entity.getWidth());
					}
				});
				this.goalSelector.addGoal(2, new RandomWalkingGoal(this, 0.8));
				this.targetSelector.addGoal(3, new HurtByTargetGoal(this));
				this.goalSelector.addGoal(4, new LookRandomlyGoal(this));
				this.goalSelector.addGoal(5, new SwimGoal(this));
			}

			@Override
			public CreatureAttribute getCreatureAttribute() {
				return CreatureAttribute.UNDEFINED;
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
				if (source == DamageSource.CACTUS)
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

				HiddenShinobiEntityDiesProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z), new AbstractMap.SimpleEntry<>("entity", entity),
								new AbstractMap.SimpleEntry<>("sourceentity", sourceentity))
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

				NarutoShippudenEntityChakraProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return retval;
			}

			@Override
			public void awardKillScore(Entity entity, int score, DamageSource damageSource) {
				super.awardKillScore(entity, score, damageSource);
				double x = this.getPosX();
				double y = this.getPosY();
				double z = this.getPosZ();
				Entity sourceentity = this;

				HiddenShinobiKillsEntityProcedure.executeProcedure(
						Stream.of(new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("sourceentity", sourceentity))
								.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}

			@Override
			public void baseTick() {
				super.baseTick();
				double x = this.getPosX();
				double y = this.getPosY();
				double z = this.getPosZ();
				Entity entity = this;

				HiddenSandShinobiOnEntityTickUpdateProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z), new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class HiddenStoneShinobiEntity extends NarutoShippudenModElements.ModElement {
		public static EntityType entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.CREATURE)
				.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new)
				.size(0.6f, 1.8f)).build("hidden_stone_shinobi").setRegistryName("hidden_stone_shinobi");

		public HiddenStoneShinobiEntity(NarutoShippudenModElements instance) {
			super(instance, 1106);
			FMLJavaModLoadingContext.get().getModEventBus().register(new HiddenStoneShinobiRenderer.ModelRegisterHandler());
			FMLJavaModLoadingContext.get().getModEventBus().register(new EntityAttributesRegisterHandler());
			MinecraftForge.EVENT_BUS.register(this);
		}

		@Override
		public void initElements() {
			elements.entities.add(() -> entity);
			elements.items.add(() -> new SpawnEggItem(entity, -6126278, -4748748, new Item.Properties().group(SpawnEggsItemGroup.tab))
					.setRegistryName("hidden_stone_shinobi_spawn_egg"));
		}

		@SubscribeEvent
		public void addFeatureToBiomes(BiomeLoadingEvent event) {
			boolean biomeCriteria = false;
			if (new ResourceLocation("plains").equals(event.getName()))
				biomeCriteria = true;
			if (new ResourceLocation("taiga_mountains").equals(event.getName()))
				biomeCriteria = true;
			if (new ResourceLocation("river").equals(event.getName()))
				biomeCriteria = true;
			if (!biomeCriteria)
				return;
			event.getSpawns().getSpawner(EntityClassification.CREATURE).add(new MobSpawnInfo.Spawners(entity, 10, 1, 1));
		}

		@Override
		public void init(FMLCommonSetupEvent event) {
			EntitySpawnPlacementRegistry.register(entity, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
					(entityType, world, reason, pos,
							random) -> (world.getBlockState(pos.down()).getMaterial() == Material.ORGANIC && world.getLightSubtracted(pos, 0) > 8));
		}

		private static class EntityAttributesRegisterHandler {
			@SubscribeEvent
			public void onEntityAttributeCreation(EntityAttributeCreationEvent event) {
				AttributeModifierMap.MutableAttribute ammma = MobEntity.func_233666_p_();
				ammma = ammma.createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.3);
				ammma = ammma.createMutableAttribute(Attributes.MAX_HEALTH, 40);
				ammma = ammma.createMutableAttribute(Attributes.ARMOR, 0);
				ammma = ammma.createMutableAttribute(Attributes.ATTACK_DAMAGE, 4);
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
			}

			@Override
			public IPacket<?> createSpawnPacket() {
				return NetworkHooks.getEntitySpawningPacket(this);
			}

			@Override
			protected void registerGoals() {
				super.registerGoals();
				this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.5, true) {
					@Override
					protected double getAttackReachSqr(LivingEntity entity) {
						return (double) (4.0 + entity.getWidth() * entity.getWidth());
					}
				});
				this.goalSelector.addGoal(2, new RandomWalkingGoal(this, 0.8));
				this.targetSelector.addGoal(3, new HurtByTargetGoal(this));
				this.goalSelector.addGoal(4, new LookRandomlyGoal(this));
				this.goalSelector.addGoal(5, new SwimGoal(this));
			}

			@Override
			public CreatureAttribute getCreatureAttribute() {
				return CreatureAttribute.UNDEFINED;
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
				if (source == DamageSource.CACTUS)
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

				HiddenShinobiEntityDiesProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z), new AbstractMap.SimpleEntry<>("entity", entity),
								new AbstractMap.SimpleEntry<>("sourceentity", sourceentity))
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

				NarutoShippudenEntityChakraProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return retval;
			}

			@Override
			public void awardKillScore(Entity entity, int score, DamageSource damageSource) {
				super.awardKillScore(entity, score, damageSource);
				double x = this.getPosX();
				double y = this.getPosY();
				double z = this.getPosZ();
				Entity sourceentity = this;

				HiddenShinobiKillsEntityProcedure.executeProcedure(
						Stream.of(new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("sourceentity", sourceentity))
								.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}

			@Override
			public void baseTick() {
				super.baseTick();
				double x = this.getPosX();
				double y = this.getPosY();
				double z = this.getPosZ();
				Entity entity = this;

				HiddenStoneShinobiOnEntityTickUpdateProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z), new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class IrukaSenseiCloneEntity extends NarutoShippudenModElements.ModElement {
		public static EntityType entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.CREATURE)
				.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).immuneToFire()
				.size(0.6f, 1.8f)).build("iruka_sensei_clone").setRegistryName("iruka_sensei_clone");

		public IrukaSenseiCloneEntity(NarutoShippudenModElements instance) {
			super(instance, 1184);
			FMLJavaModLoadingContext.get().getModEventBus().register(new IrukaSenseiCloneRenderer.ModelRegisterHandler());
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
				ammma = ammma.createMutableAttribute(Attributes.MAX_HEALTH, 20);
				ammma = ammma.createMutableAttribute(Attributes.ARMOR, 0);
				ammma = ammma.createMutableAttribute(Attributes.ATTACK_DAMAGE, 3);
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
				this.goalSelector.addGoal(1, new LookRandomlyGoal(this));
				this.goalSelector.addGoal(2, new SwimGoal(this));
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

				IrukaSenseiCloneOnInitialEntitySpawnProcedure
						.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("entity", entity))
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
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class IrukaSenseiEntity extends NarutoShippudenModElements.ModElement {
		public static EntityType entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.CREATURE)
				.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).immuneToFire()
				.size(0.6f, 1.8f)).build("iruka_sensei").setRegistryName("iruka_sensei");

		public IrukaSenseiEntity(NarutoShippudenModElements instance) {
			super(instance, 1183);
			FMLJavaModLoadingContext.get().getModEventBus().register(new IrukaSenseiRenderer.ModelRegisterHandler());
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
				ammma = ammma.createMutableAttribute(Attributes.MAX_HEALTH, 200);
				ammma = ammma.createMutableAttribute(Attributes.ARMOR, 0);
				ammma = ammma.createMutableAttribute(Attributes.ATTACK_DAMAGE, 3);
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
				this.goalSelector.addGoal(1, new LookRandomlyGoal(this));
				this.goalSelector.addGoal(2, new SwimGoal(this));
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

				IrukaSenseiOnEntityTickUpdateProcedure.executeProcedure(Stream
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
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class ShikamaruEntity extends NarutoShippudenModElements.ModElement {
		public static EntityType entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.CREATURE)
				.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new)
				.size(0.6f, 1.8f)).build("shikamaru").setRegistryName("shikamaru");

		public ShikamaruEntity(NarutoShippudenModElements instance) {
			super(instance, 220);
			FMLJavaModLoadingContext.get().getModEventBus().register(new ShikamaruRenderer.ModelRegisterHandler());
			FMLJavaModLoadingContext.get().getModEventBus().register(new EntityAttributesRegisterHandler());
			MinecraftForge.EVENT_BUS.register(this);
		}

		@Override
		public void initElements() {
			elements.entities.add(() -> entity);
			elements.items.add(() -> new SpawnEggItem(entity, -10182549, -12500671, new Item.Properties().group(SpawnEggsItemGroup.tab))
					.setRegistryName("shikamaru_spawn_egg"));
		}

		@SubscribeEvent
		public void addFeatureToBiomes(BiomeLoadingEvent event) {
			boolean biomeCriteria = false;
			if (new ResourceLocation("plains").equals(event.getName()))
				biomeCriteria = true;
			if (new ResourceLocation("taiga_mountains").equals(event.getName()))
				biomeCriteria = true;
			if (new ResourceLocation("river").equals(event.getName()))
				biomeCriteria = true;
			if (!biomeCriteria)
				return;
			event.getSpawns().getSpawner(EntityClassification.CREATURE).add(new MobSpawnInfo.Spawners(entity, 10, 1, 1));
		}

		@Override
		public void init(FMLCommonSetupEvent event) {
			EntitySpawnPlacementRegistry.register(entity, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
					(entityType, world, reason, pos,
							random) -> (world.getBlockState(pos.down()).getMaterial() == Material.ORGANIC && world.getLightSubtracted(pos, 0) > 8));
		}

		private static class EntityAttributesRegisterHandler {
			@SubscribeEvent
			public void onEntityAttributeCreation(EntityAttributeCreationEvent event) {
				AttributeModifierMap.MutableAttribute ammma = MobEntity.func_233666_p_();
				ammma = ammma.createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.3);
				ammma = ammma.createMutableAttribute(Attributes.MAX_HEALTH, 200);
				ammma = ammma.createMutableAttribute(Attributes.ARMOR, 0);
				ammma = ammma.createMutableAttribute(Attributes.ATTACK_DAMAGE, 3);
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
			}

			@Override
			public IPacket<?> createSpawnPacket() {
				return NetworkHooks.getEntitySpawningPacket(this);
			}

			@Override
			protected void registerGoals() {
				super.registerGoals();
				this.goalSelector.addGoal(1, new RandomWalkingGoal(this, 1));
				this.goalSelector.addGoal(2, new LookRandomlyGoal(this));
				this.goalSelector.addGoal(3, new SwimGoal(this));
				this.goalSelector.addGoal(4, new LeapAtTargetGoal(this, (float) 0.5));
			}

			@Override
			public CreatureAttribute getCreatureAttribute() {
				return CreatureAttribute.UNDEFINED;
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
			public ActionResultType func_230254_b_(PlayerEntity sourceentity, Hand hand) {
				ItemStack itemstack = sourceentity.getHeldItem(hand);
				ActionResultType retval = ActionResultType.func_233537_a_(this.world.isRemote());
				super.func_230254_b_(sourceentity, hand);
				double x = this.getPosX();
				double y = this.getPosY();
				double z = this.getPosZ();
				Entity entity = this;

				ShikamaruRightClickedOnEntityProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z), new AbstractMap.SimpleEntry<>("sourceentity", sourceentity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return retval;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class TrainingDummyEntity extends NarutoShippudenModElements.ModElement {
		public static EntityType entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER)
				.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new)
				.size(0.6f, 1.8f)).build("training_dummy").setRegistryName("training_dummy");

		public TrainingDummyEntity(NarutoShippudenModElements instance) {
			super(instance, 1191);
			FMLJavaModLoadingContext.get().getModEventBus().register(new TrainingDummyRenderer.ModelRegisterHandler());
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
				ammma = ammma.createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.1);
				ammma = ammma.createMutableAttribute(Attributes.MAX_HEALTH, 1000);
				ammma = ammma.createMutableAttribute(Attributes.ARMOR, 0);
				ammma = ammma.createMutableAttribute(Attributes.ATTACK_DAMAGE, 0);
				ammma = ammma.createMutableAttribute(Attributes.FOLLOW_RANGE, 16);
				ammma = ammma.createMutableAttribute(Attributes.KNOCKBACK_RESISTANCE, 1000);
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
				setNoAI(true);
				enablePersistence();
			}

			@Override
			public IPacket<?> createSpawnPacket() {
				return NetworkHooks.getEntitySpawningPacket(this);
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
				double x = this.getPosX();
				double y = this.getPosY();
				double z = this.getPosZ();
				Entity entity = this;
				Entity sourceentity = source.getTrueSource();

				TrainingDummyEntityIsHurtProcedure.executeProcedure(
						Stream.of(new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("sourceentity", sourceentity))
								.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				if (source.getImmediateSource() instanceof PotionEntity || source.getImmediateSource() instanceof AreaEffectCloudEntity)
					return false;
				if (source == DamageSource.FALL)
					return false;
				if (source == DamageSource.CACTUS)
					return false;
				if (source == DamageSource.DROWN)
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

				TrainingDummyOnEntityTickUpdateProcedure.executeProcedure(Stream
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
		}
	}
}
