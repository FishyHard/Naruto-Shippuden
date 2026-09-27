package net.mcreator.narutoshippudenmod.entity;

import net.mcreator.narutoshippudenmod.compat.Compat;
import net.mcreator.narutoshippudenmod.compat.Registration;
import net.mcreator.narutoshippudenmod.NarutoShippudenMod;
import net.minecraft.server.level.ServerLevel;

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
import net.minecraft.client.resources.model.sprite.Material;
import net.minecraft.world.entity.AreaEffectCloud;

import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.LeapAtTargetGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.arrow.AbstractArrow;
import net.minecraft.world.entity.projectile.throwableitemprojectile.ThrownSplashPotion;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.resources.Identifier;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.Heightmap;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;



import net.minecraft.core.registries.BuiltInRegistries;

public final class NpcEntities {
	private NpcEntities() {
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class AsumaEntity extends NarutoShippudenModElements.ModElement {
		public static EntityType<CustomEntity> entity;

		public AsumaEntity(NarutoShippudenModElements instance) {
			super(instance, 390);
			NarutoShippudenMod.MOD_BUS.register(new EntityAttributesRegisterHandler());
			NeoForge.EVENT_BUS.register(this);
		}

		@Override
		public void initElements() {
			Compat.spawnPlacement(() -> entity, net.minecraft.world.entity.SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
					(entityType, world, reason, pos,
							random) -> (world.getBlockState(pos.below()).is(Compat.materialTag("GRASS")) && world.getRawBrightness(pos, 0) > 8));
			elements.entities.add(() -> entity = (EntityType.Builder.<CustomEntity>of(CustomEntity::new, MobCategory.CREATURE) .setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3) .sized(0.6f, 1.8f)).build(Registration.entityKey("asuma")));
			elements.items.add(() -> new SpawnEggItem(Registration.itemProps("asuma_spawn_egg", "SpawnEggsItemGroup").spawnEgg(entity)));
		}

		@Override
		public void init(FMLCommonSetupEvent event) {
					}

		public static class EntityAttributesRegisterHandler {
			@SubscribeEvent
			public void onEntityAttributeCreation(EntityAttributeCreationEvent event) {
				AttributeSupplier.Builder ammma = Mob.createMobAttributes();
				ammma = ammma.add(Attributes.MOVEMENT_SPEED, 0.3);
				ammma = ammma.add(Attributes.MAX_HEALTH, 200);
				ammma = ammma.add(Attributes.ARMOR, 0);
				ammma = ammma.add(Attributes.ATTACK_DAMAGE, 4);
				ammma = ammma.add(Attributes.FOLLOW_RANGE, 16);
				event.put(entity, ammma.build());
			}
		}

		public static class CustomEntity extends PathfinderMob {

			public CustomEntity(EntityType<CustomEntity> type, Level world) {
				super(type, world);
				xpReward = 0;
				setNoAi(false);
				this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(ChakraBladeItem.block));
				this.setItemSlot(EquipmentSlot.OFFHAND, new ItemStack(ChakraBladeItem.block));
			}

			@Override
			protected void registerGoals() {
				super.registerGoals();
				this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.5, true) {
					@Override
					protected boolean canPerformAttack(LivingEntity entity) {
						return this.isTimeToAttack() && this.mob.distanceToSqr(entity) <= ((double) (4.0 + entity.getBbWidth() * entity.getBbWidth())) && this.mob.getSensing().hasLineOfSight(entity);
					}
				});
				this.goalSelector.addGoal(2, new RandomStrollGoal(this, 0.8));
				this.targetSelector.addGoal(3, new HurtByTargetGoal(this));
				this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
				this.goalSelector.addGoal(5, new FloatGoal(this));
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
				double x = this.getX();
				double y = this.getY();
				double z = this.getZ();
				Entity entity = this;
				Entity sourceentity = source.getEntity();

				AsumaEntityIsHurtProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", level()), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z), new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return super.hurtServer(level, source, amount);
			}

			@Override
			public SpawnGroupData finalizeSpawn(ServerLevelAccessor world, DifficultyInstance difficulty, EntitySpawnReason reason, SpawnGroupData livingdata) {
				SpawnGroupData retval = super.finalizeSpawn(world, difficulty, reason, livingdata);
				double x = this.getX();
				double y = this.getY();
				double z = this.getZ();
				Entity entity = this;

				NarutoShippudenEntityChakraProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return retval;
			}

			@Override
			public InteractionResult mobInteract(Player sourceentity, InteractionHand hand) {
				ItemStack itemstack = sourceentity.getItemInHand(hand);
				InteractionResult retval = InteractionResult.SUCCESS;
				super.mobInteract(sourceentity, hand);
				double x = this.getX();
				double y = this.getY();
				double z = this.getZ();
				Entity entity = this;

				AsumaRightClickedOnEntityProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", level()), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z), new AbstractMap.SimpleEntry<>("sourceentity", sourceentity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return retval;
			}

			@Override
			public void baseTick() {
				super.baseTick();
				double x = this.getX();
				double y = this.getY();
				double z = this.getZ();
				Entity entity = this;

				AsumaOnEntityTickUpdateProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", level()), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z), new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class EarthGolemShinobiEntity extends NarutoShippudenModElements.ModElement {
		public static EntityType<CustomEntity> entity;

		public EarthGolemShinobiEntity(NarutoShippudenModElements instance) {
			super(instance, 1108);
			NarutoShippudenMod.MOD_BUS.register(new EntityAttributesRegisterHandler());
		}

		@Override
		public void initElements() {
			elements.entities.add(() -> entity = (EntityType.Builder.<CustomEntity>of(CustomEntity::new, MobCategory.MONSTER) .setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3) .sized(1.5f, 3.5f)).build(Registration.entityKey("earth_golem_shinobi")));
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
				ammma = ammma.add(Attributes.ATTACK_DAMAGE, 8);
				ammma = ammma.add(Attributes.FOLLOW_RANGE, 16);
				ammma = ammma.add(Attributes.KNOCKBACK_RESISTANCE, 1);
				ammma = ammma.add(Attributes.ATTACK_KNOCKBACK, 2);
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
				this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.2, true) {
					@Override
					protected boolean canPerformAttack(LivingEntity entity) {
						return this.isTimeToAttack() && this.mob.distanceToSqr(entity) <= ((double) (4.0 + entity.getBbWidth() * entity.getBbWidth())) && this.mob.getSensing().hasLineOfSight(entity);
					}
				});
				this.targetSelector.addGoal(2, new HurtByTargetGoal(this));
				this.goalSelector.addGoal(3, new RandomStrollGoal(this, 0.8));
				this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
				this.targetSelector.addGoal(5, new NearestAttackableTargetGoal(this, Player.class, false, false));
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

				EarthGolemShinobiOnInitialEntitySpawnProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return retval;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class HiddenCloudShinobiEntity extends NarutoShippudenModElements.ModElement {
		public static EntityType<CustomEntity> entity;

		public HiddenCloudShinobiEntity(NarutoShippudenModElements instance) {
			super(instance, 1102);
			NarutoShippudenMod.MOD_BUS.register(new EntityAttributesRegisterHandler());
			NeoForge.EVENT_BUS.register(this);
		}

		@Override
		public void initElements() {
			Compat.spawnPlacement(() -> entity, net.minecraft.world.entity.SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
					(entityType, world, reason, pos,
							random) -> (world.getBlockState(pos.below()).is(Compat.materialTag("GRASS")) && world.getRawBrightness(pos, 0) > 8));
			elements.entities.add(() -> entity = (EntityType.Builder.<CustomEntity>of(CustomEntity::new, MobCategory.CREATURE) .setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3) .sized(0.6f, 1.8f)).build(Registration.entityKey("hidden_cloud_shinobi")));
			elements.items.add(() -> new SpawnEggItem(Registration.itemProps("hidden_cloud_shinobi_spawn_egg", "SpawnEggsItemGroup").spawnEgg(entity)));
		}

		@Override
		public void init(FMLCommonSetupEvent event) {
					}

		public static class EntityAttributesRegisterHandler {
			@SubscribeEvent
			public void onEntityAttributeCreation(EntityAttributeCreationEvent event) {
				AttributeSupplier.Builder ammma = Mob.createMobAttributes();
				ammma = ammma.add(Attributes.MOVEMENT_SPEED, 0.3);
				ammma = ammma.add(Attributes.MAX_HEALTH, 40);
				ammma = ammma.add(Attributes.ARMOR, 0);
				ammma = ammma.add(Attributes.ATTACK_DAMAGE, 4);
				ammma = ammma.add(Attributes.FOLLOW_RANGE, 16);
				event.put(entity, ammma.build());
			}
		}

		public static class CustomEntity extends PathfinderMob {

			public CustomEntity(EntityType<CustomEntity> type, Level world) {
				super(type, world);
				xpReward = 0;
				setNoAi(false);
			}

			@Override
			protected void registerGoals() {
				super.registerGoals();
				this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.5, true) {
					@Override
					protected boolean canPerformAttack(LivingEntity entity) {
						return this.isTimeToAttack() && this.mob.distanceToSqr(entity) <= ((double) (4.0 + entity.getBbWidth() * entity.getBbWidth())) && this.mob.getSensing().hasLineOfSight(entity);
					}
				});
				this.goalSelector.addGoal(2, new RandomStrollGoal(this, 0.8));
				this.targetSelector.addGoal(3, new HurtByTargetGoal(this));
				this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
				this.goalSelector.addGoal(5, new FloatGoal(this));
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
				if (source.is(net.minecraft.world.damagesource.DamageTypes.CACTUS))
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

				HiddenShinobiEntityDiesProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", level()), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z), new AbstractMap.SimpleEntry<>("entity", entity),
								new AbstractMap.SimpleEntry<>("sourceentity", sourceentity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}

			@Override
			public SpawnGroupData finalizeSpawn(ServerLevelAccessor world, DifficultyInstance difficulty, EntitySpawnReason reason, SpawnGroupData livingdata) {
				SpawnGroupData retval = super.finalizeSpawn(world, difficulty, reason, livingdata);
				double x = this.getX();
				double y = this.getY();
				double z = this.getZ();
				Entity entity = this;

				NarutoShippudenEntityChakraProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return retval;
			}

			@Override
			public void awardKillScore(Entity entity, DamageSource damageSource) {
				super.awardKillScore(entity, damageSource);
				double x = this.getX();
				double y = this.getY();
				double z = this.getZ();
				Entity sourceentity = this;

				HiddenShinobiKillsEntityProcedure.executeProcedure(
						Stream.of(new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("sourceentity", sourceentity))
								.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}

			@Override
			public void baseTick() {
				super.baseTick();
				double x = this.getX();
				double y = this.getY();
				double z = this.getZ();
				Entity entity = this;

				HiddenCloudShinobiOnEntityTickUpdateProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", level()), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z), new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class HiddenLeafShinobiEntity extends NarutoShippudenModElements.ModElement {
		public static EntityType<CustomEntity> entity;

		public HiddenLeafShinobiEntity(NarutoShippudenModElements instance) {
			super(instance, 1098);
			NarutoShippudenMod.MOD_BUS.register(new EntityAttributesRegisterHandler());
			NeoForge.EVENT_BUS.register(this);
		}

		@Override
		public void initElements() {
			Compat.spawnPlacement(() -> entity, net.minecraft.world.entity.SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
					(entityType, world, reason, pos,
							random) -> (world.getBlockState(pos.below()).is(Compat.materialTag("GRASS")) && world.getRawBrightness(pos, 0) > 8));
			elements.entities.add(() -> entity = (EntityType.Builder.<CustomEntity>of(CustomEntity::new, MobCategory.CREATURE) .setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3) .sized(0.6f, 1.8f)).build(Registration.entityKey("hidden_leaf_shinobi")));
			elements.items.add(() -> new SpawnEggItem(Registration.itemProps("hidden_leaf_shinobi_spawn_egg", "SpawnEggsItemGroup").spawnEgg(entity)));
		}

		@Override
		public void init(FMLCommonSetupEvent event) {
					}

		public static class EntityAttributesRegisterHandler {
			@SubscribeEvent
			public void onEntityAttributeCreation(EntityAttributeCreationEvent event) {
				AttributeSupplier.Builder ammma = Mob.createMobAttributes();
				ammma = ammma.add(Attributes.MOVEMENT_SPEED, 0.3);
				ammma = ammma.add(Attributes.MAX_HEALTH, 40);
				ammma = ammma.add(Attributes.ARMOR, 0);
				ammma = ammma.add(Attributes.ATTACK_DAMAGE, 4);
				ammma = ammma.add(Attributes.FOLLOW_RANGE, 16);
				event.put(entity, ammma.build());
			}
		}

		public static class CustomEntity extends PathfinderMob {

			public CustomEntity(EntityType<CustomEntity> type, Level world) {
				super(type, world);
				xpReward = 0;
				setNoAi(false);
			}

			@Override
			protected void registerGoals() {
				super.registerGoals();
				this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.5, true) {
					@Override
					protected boolean canPerformAttack(LivingEntity entity) {
						return this.isTimeToAttack() && this.mob.distanceToSqr(entity) <= ((double) (4.0 + entity.getBbWidth() * entity.getBbWidth())) && this.mob.getSensing().hasLineOfSight(entity);
					}
				});
				this.goalSelector.addGoal(2, new RandomStrollGoal(this, 0.8));
				this.targetSelector.addGoal(3, new HurtByTargetGoal(this));
				this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
				this.goalSelector.addGoal(5, new FloatGoal(this));
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
				if (source.is(net.minecraft.world.damagesource.DamageTypes.CACTUS))
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

				HiddenShinobiEntityDiesProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", level()), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z), new AbstractMap.SimpleEntry<>("entity", entity),
								new AbstractMap.SimpleEntry<>("sourceentity", sourceentity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}

			@Override
			public SpawnGroupData finalizeSpawn(ServerLevelAccessor world, DifficultyInstance difficulty, EntitySpawnReason reason, SpawnGroupData livingdata) {
				SpawnGroupData retval = super.finalizeSpawn(world, difficulty, reason, livingdata);
				double x = this.getX();
				double y = this.getY();
				double z = this.getZ();
				Entity entity = this;

				NarutoShippudenEntityChakraProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return retval;
			}

			@Override
			public void awardKillScore(Entity entity, DamageSource damageSource) {
				super.awardKillScore(entity, damageSource);
				double x = this.getX();
				double y = this.getY();
				double z = this.getZ();
				Entity sourceentity = this;

				HiddenShinobiKillsEntityProcedure.executeProcedure(
						Stream.of(new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("sourceentity", sourceentity))
								.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}

			@Override
			public void baseTick() {
				super.baseTick();
				double x = this.getX();
				double y = this.getY();
				double z = this.getZ();
				Entity entity = this;

				HiddenLeafShinobiOnEntityTickUpdateProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", level()), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z), new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class HiddenMistShinobiEntity extends NarutoShippudenModElements.ModElement {
		public static EntityType<CustomEntity> entity;

		public HiddenMistShinobiEntity(NarutoShippudenModElements instance) {
			super(instance, 1100);
			NarutoShippudenMod.MOD_BUS.register(new EntityAttributesRegisterHandler());
			NeoForge.EVENT_BUS.register(this);
		}

		@Override
		public void initElements() {
			Compat.spawnPlacement(() -> entity, net.minecraft.world.entity.SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
					(entityType, world, reason, pos,
							random) -> (world.getBlockState(pos.below()).is(Compat.materialTag("GRASS")) && world.getRawBrightness(pos, 0) > 8));
			elements.entities.add(() -> entity = (EntityType.Builder.<CustomEntity>of(CustomEntity::new, MobCategory.CREATURE) .setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3) .sized(0.6f, 1.8f)).build(Registration.entityKey("hidden_mist_shinobi")));
			elements.items.add(() -> new SpawnEggItem(Registration.itemProps("hidden_mist_shinobi_spawn_egg", "SpawnEggsItemGroup").spawnEgg(entity)));
		}

		@Override
		public void init(FMLCommonSetupEvent event) {
					}

		public static class EntityAttributesRegisterHandler {
			@SubscribeEvent
			public void onEntityAttributeCreation(EntityAttributeCreationEvent event) {
				AttributeSupplier.Builder ammma = Mob.createMobAttributes();
				ammma = ammma.add(Attributes.MOVEMENT_SPEED, 0.3);
				ammma = ammma.add(Attributes.MAX_HEALTH, 40);
				ammma = ammma.add(Attributes.ARMOR, 0);
				ammma = ammma.add(Attributes.ATTACK_DAMAGE, 4);
				ammma = ammma.add(Attributes.FOLLOW_RANGE, 16);
				event.put(entity, ammma.build());
			}
		}

		public static class CustomEntity extends PathfinderMob {

			public CustomEntity(EntityType<CustomEntity> type, Level world) {
				super(type, world);
				xpReward = 0;
				setNoAi(false);
			}

			@Override
			protected void registerGoals() {
				super.registerGoals();
				this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.5, true) {
					@Override
					protected boolean canPerformAttack(LivingEntity entity) {
						return this.isTimeToAttack() && this.mob.distanceToSqr(entity) <= ((double) (4.0 + entity.getBbWidth() * entity.getBbWidth())) && this.mob.getSensing().hasLineOfSight(entity);
					}
				});
				this.goalSelector.addGoal(2, new RandomStrollGoal(this, 0.8));
				this.targetSelector.addGoal(3, new HurtByTargetGoal(this));
				this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
				this.goalSelector.addGoal(5, new FloatGoal(this));
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
				if (source.is(net.minecraft.world.damagesource.DamageTypes.CACTUS))
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

				HiddenShinobiEntityDiesProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", level()), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z), new AbstractMap.SimpleEntry<>("entity", entity),
								new AbstractMap.SimpleEntry<>("sourceentity", sourceentity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}

			@Override
			public SpawnGroupData finalizeSpawn(ServerLevelAccessor world, DifficultyInstance difficulty, EntitySpawnReason reason, SpawnGroupData livingdata) {
				SpawnGroupData retval = super.finalizeSpawn(world, difficulty, reason, livingdata);
				double x = this.getX();
				double y = this.getY();
				double z = this.getZ();
				Entity entity = this;

				NarutoShippudenEntityChakraProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return retval;
			}

			@Override
			public void awardKillScore(Entity entity, DamageSource damageSource) {
				super.awardKillScore(entity, damageSource);
				double x = this.getX();
				double y = this.getY();
				double z = this.getZ();
				Entity sourceentity = this;

				HiddenShinobiKillsEntityProcedure.executeProcedure(
						Stream.of(new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("sourceentity", sourceentity))
								.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}

			@Override
			public void baseTick() {
				super.baseTick();
				double x = this.getX();
				double y = this.getY();
				double z = this.getZ();
				Entity entity = this;

				HiddenMistShinobiOnEntityTickUpdateProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", level()), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z), new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class HiddenSandShinobiEntity extends NarutoShippudenModElements.ModElement {
		public static EntityType<CustomEntity> entity;

		public HiddenSandShinobiEntity(NarutoShippudenModElements instance) {
			super(instance, 1104);
			NarutoShippudenMod.MOD_BUS.register(new EntityAttributesRegisterHandler());
			NeoForge.EVENT_BUS.register(this);
		}

		@Override
		public void initElements() {
			Compat.spawnPlacement(() -> entity, net.minecraft.world.entity.SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
					(entityType, world, reason, pos,
							random) -> (world.getBlockState(pos.below()).is(Compat.materialTag("GRASS")) && world.getRawBrightness(pos, 0) > 8));
			elements.entities.add(() -> entity = (EntityType.Builder.<CustomEntity>of(CustomEntity::new, MobCategory.CREATURE) .setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3) .sized(0.6f, 1.8f)).build(Registration.entityKey("hidden_sand_shinobi")));
			elements.items.add(() -> new SpawnEggItem(Registration.itemProps("hidden_sand_shinobi_spawn_egg", "SpawnEggsItemGroup").spawnEgg(entity)));
		}

		@Override
		public void init(FMLCommonSetupEvent event) {
					}

		public static class EntityAttributesRegisterHandler {
			@SubscribeEvent
			public void onEntityAttributeCreation(EntityAttributeCreationEvent event) {
				AttributeSupplier.Builder ammma = Mob.createMobAttributes();
				ammma = ammma.add(Attributes.MOVEMENT_SPEED, 0.3);
				ammma = ammma.add(Attributes.MAX_HEALTH, 40);
				ammma = ammma.add(Attributes.ARMOR, 0);
				ammma = ammma.add(Attributes.ATTACK_DAMAGE, 4);
				ammma = ammma.add(Attributes.FOLLOW_RANGE, 16);
				event.put(entity, ammma.build());
			}
		}

		public static class CustomEntity extends PathfinderMob {

			public CustomEntity(EntityType<CustomEntity> type, Level world) {
				super(type, world);
				xpReward = 0;
				setNoAi(false);
			}

			@Override
			protected void registerGoals() {
				super.registerGoals();
				this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.5, true) {
					@Override
					protected boolean canPerformAttack(LivingEntity entity) {
						return this.isTimeToAttack() && this.mob.distanceToSqr(entity) <= ((double) (4.0 + entity.getBbWidth() * entity.getBbWidth())) && this.mob.getSensing().hasLineOfSight(entity);
					}
				});
				this.goalSelector.addGoal(2, new RandomStrollGoal(this, 0.8));
				this.targetSelector.addGoal(3, new HurtByTargetGoal(this));
				this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
				this.goalSelector.addGoal(5, new FloatGoal(this));
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
				if (source.is(net.minecraft.world.damagesource.DamageTypes.CACTUS))
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

				HiddenShinobiEntityDiesProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", level()), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z), new AbstractMap.SimpleEntry<>("entity", entity),
								new AbstractMap.SimpleEntry<>("sourceentity", sourceentity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}

			@Override
			public SpawnGroupData finalizeSpawn(ServerLevelAccessor world, DifficultyInstance difficulty, EntitySpawnReason reason, SpawnGroupData livingdata) {
				SpawnGroupData retval = super.finalizeSpawn(world, difficulty, reason, livingdata);
				double x = this.getX();
				double y = this.getY();
				double z = this.getZ();
				Entity entity = this;

				NarutoShippudenEntityChakraProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return retval;
			}

			@Override
			public void awardKillScore(Entity entity, DamageSource damageSource) {
				super.awardKillScore(entity, damageSource);
				double x = this.getX();
				double y = this.getY();
				double z = this.getZ();
				Entity sourceentity = this;

				HiddenShinobiKillsEntityProcedure.executeProcedure(
						Stream.of(new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("sourceentity", sourceentity))
								.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}

			@Override
			public void baseTick() {
				super.baseTick();
				double x = this.getX();
				double y = this.getY();
				double z = this.getZ();
				Entity entity = this;

				HiddenSandShinobiOnEntityTickUpdateProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", level()), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z), new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class HiddenStoneShinobiEntity extends NarutoShippudenModElements.ModElement {
		public static EntityType<CustomEntity> entity;

		public HiddenStoneShinobiEntity(NarutoShippudenModElements instance) {
			super(instance, 1106);
			NarutoShippudenMod.MOD_BUS.register(new EntityAttributesRegisterHandler());
			NeoForge.EVENT_BUS.register(this);
		}

		@Override
		public void initElements() {
			Compat.spawnPlacement(() -> entity, net.minecraft.world.entity.SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
					(entityType, world, reason, pos,
							random) -> (world.getBlockState(pos.below()).is(Compat.materialTag("GRASS")) && world.getRawBrightness(pos, 0) > 8));
			elements.entities.add(() -> entity = (EntityType.Builder.<CustomEntity>of(CustomEntity::new, MobCategory.CREATURE) .setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3) .sized(0.6f, 1.8f)).build(Registration.entityKey("hidden_stone_shinobi")));
			elements.items.add(() -> new SpawnEggItem(Registration.itemProps("hidden_stone_shinobi_spawn_egg", "SpawnEggsItemGroup").spawnEgg(entity)));
		}

		@Override
		public void init(FMLCommonSetupEvent event) {
					}

		public static class EntityAttributesRegisterHandler {
			@SubscribeEvent
			public void onEntityAttributeCreation(EntityAttributeCreationEvent event) {
				AttributeSupplier.Builder ammma = Mob.createMobAttributes();
				ammma = ammma.add(Attributes.MOVEMENT_SPEED, 0.3);
				ammma = ammma.add(Attributes.MAX_HEALTH, 40);
				ammma = ammma.add(Attributes.ARMOR, 0);
				ammma = ammma.add(Attributes.ATTACK_DAMAGE, 4);
				ammma = ammma.add(Attributes.FOLLOW_RANGE, 16);
				event.put(entity, ammma.build());
			}
		}

		public static class CustomEntity extends PathfinderMob {

			public CustomEntity(EntityType<CustomEntity> type, Level world) {
				super(type, world);
				xpReward = 0;
				setNoAi(false);
			}

			@Override
			protected void registerGoals() {
				super.registerGoals();
				this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.5, true) {
					@Override
					protected boolean canPerformAttack(LivingEntity entity) {
						return this.isTimeToAttack() && this.mob.distanceToSqr(entity) <= ((double) (4.0 + entity.getBbWidth() * entity.getBbWidth())) && this.mob.getSensing().hasLineOfSight(entity);
					}
				});
				this.goalSelector.addGoal(2, new RandomStrollGoal(this, 0.8));
				this.targetSelector.addGoal(3, new HurtByTargetGoal(this));
				this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
				this.goalSelector.addGoal(5, new FloatGoal(this));
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
				if (source.is(net.minecraft.world.damagesource.DamageTypes.CACTUS))
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

				HiddenShinobiEntityDiesProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", level()), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z), new AbstractMap.SimpleEntry<>("entity", entity),
								new AbstractMap.SimpleEntry<>("sourceentity", sourceentity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}

			@Override
			public SpawnGroupData finalizeSpawn(ServerLevelAccessor world, DifficultyInstance difficulty, EntitySpawnReason reason, SpawnGroupData livingdata) {
				SpawnGroupData retval = super.finalizeSpawn(world, difficulty, reason, livingdata);
				double x = this.getX();
				double y = this.getY();
				double z = this.getZ();
				Entity entity = this;

				NarutoShippudenEntityChakraProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return retval;
			}

			@Override
			public void awardKillScore(Entity entity, DamageSource damageSource) {
				super.awardKillScore(entity, damageSource);
				double x = this.getX();
				double y = this.getY();
				double z = this.getZ();
				Entity sourceentity = this;

				HiddenShinobiKillsEntityProcedure.executeProcedure(
						Stream.of(new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("sourceentity", sourceentity))
								.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}

			@Override
			public void baseTick() {
				super.baseTick();
				double x = this.getX();
				double y = this.getY();
				double z = this.getZ();
				Entity entity = this;

				HiddenStoneShinobiOnEntityTickUpdateProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", level()), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z), new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class IrukaSenseiCloneEntity extends NarutoShippudenModElements.ModElement {
		public static EntityType<CustomEntity> entity;

		public IrukaSenseiCloneEntity(NarutoShippudenModElements instance) {
			super(instance, 1184);
			NarutoShippudenMod.MOD_BUS.register(new EntityAttributesRegisterHandler());
		}

		@Override
		public void initElements() {
			elements.entities.add(() -> entity = (EntityType.Builder.<CustomEntity>of(CustomEntity::new, MobCategory.CREATURE) .setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune() .sized(0.6f, 1.8f)).build(Registration.entityKey("iruka_sensei_clone")));
		}

		@Override
		public void init(FMLCommonSetupEvent event) {
		}

		public static class EntityAttributesRegisterHandler {
			@SubscribeEvent
			public void onEntityAttributeCreation(EntityAttributeCreationEvent event) {
				AttributeSupplier.Builder ammma = Mob.createMobAttributes();
				ammma = ammma.add(Attributes.MOVEMENT_SPEED, 0.3);
				ammma = ammma.add(Attributes.MAX_HEALTH, 20);
				ammma = ammma.add(Attributes.ARMOR, 0);
				ammma = ammma.add(Attributes.ATTACK_DAMAGE, 3);
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
				this.goalSelector.addGoal(1, new RandomLookAroundGoal(this));
				this.goalSelector.addGoal(2, new FloatGoal(this));
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

				IrukaSenseiCloneOnInitialEntitySpawnProcedure
						.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("entity", entity))
								.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
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
	public static class IrukaSenseiEntity extends NarutoShippudenModElements.ModElement {
		public static EntityType<CustomEntity> entity;

		public IrukaSenseiEntity(NarutoShippudenModElements instance) {
			super(instance, 1183);
			NarutoShippudenMod.MOD_BUS.register(new EntityAttributesRegisterHandler());
		}

		@Override
		public void initElements() {
			elements.entities.add(() -> entity = (EntityType.Builder.<CustomEntity>of(CustomEntity::new, MobCategory.CREATURE) .setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune() .sized(0.6f, 1.8f)).build(Registration.entityKey("iruka_sensei")));
		}

		@Override
		public void init(FMLCommonSetupEvent event) {
		}

		public static class EntityAttributesRegisterHandler {
			@SubscribeEvent
			public void onEntityAttributeCreation(EntityAttributeCreationEvent event) {
				AttributeSupplier.Builder ammma = Mob.createMobAttributes();
				ammma = ammma.add(Attributes.MOVEMENT_SPEED, 0.3);
				ammma = ammma.add(Attributes.MAX_HEALTH, 200);
				ammma = ammma.add(Attributes.ARMOR, 0);
				ammma = ammma.add(Attributes.ATTACK_DAMAGE, 3);
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
				this.goalSelector.addGoal(1, new RandomLookAroundGoal(this));
				this.goalSelector.addGoal(2, new FloatGoal(this));
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
			public void baseTick() {
				super.baseTick();
				double x = this.getX();
				double y = this.getY();
				double z = this.getZ();
				Entity entity = this;

				IrukaSenseiOnEntityTickUpdateProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", level()), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z), new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
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
	public static class ShikamaruEntity extends NarutoShippudenModElements.ModElement {
		public static EntityType<CustomEntity> entity;

		public ShikamaruEntity(NarutoShippudenModElements instance) {
			super(instance, 220);
			NarutoShippudenMod.MOD_BUS.register(new EntityAttributesRegisterHandler());
			NeoForge.EVENT_BUS.register(this);
		}

		@Override
		public void initElements() {
			Compat.spawnPlacement(() -> entity, net.minecraft.world.entity.SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
					(entityType, world, reason, pos,
							random) -> (world.getBlockState(pos.below()).is(Compat.materialTag("GRASS")) && world.getRawBrightness(pos, 0) > 8));
			elements.entities.add(() -> entity = (EntityType.Builder.<CustomEntity>of(CustomEntity::new, MobCategory.CREATURE) .setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3) .sized(0.6f, 1.8f)).build(Registration.entityKey("shikamaru")));
			elements.items.add(() -> new SpawnEggItem(Registration.itemProps("shikamaru_spawn_egg", "SpawnEggsItemGroup").spawnEgg(entity)));
		}

		@Override
		public void init(FMLCommonSetupEvent event) {
					}

		public static class EntityAttributesRegisterHandler {
			@SubscribeEvent
			public void onEntityAttributeCreation(EntityAttributeCreationEvent event) {
				AttributeSupplier.Builder ammma = Mob.createMobAttributes();
				ammma = ammma.add(Attributes.MOVEMENT_SPEED, 0.3);
				ammma = ammma.add(Attributes.MAX_HEALTH, 200);
				ammma = ammma.add(Attributes.ARMOR, 0);
				ammma = ammma.add(Attributes.ATTACK_DAMAGE, 3);
				ammma = ammma.add(Attributes.FOLLOW_RANGE, 16);
				event.put(entity, ammma.build());
			}
		}

		public static class CustomEntity extends PathfinderMob {

			public CustomEntity(EntityType<CustomEntity> type, Level world) {
				super(type, world);
				xpReward = 0;
				setNoAi(false);
			}

			@Override
			protected void registerGoals() {
				super.registerGoals();
				this.goalSelector.addGoal(1, new RandomStrollGoal(this, 1));
				this.goalSelector.addGoal(2, new RandomLookAroundGoal(this));
				this.goalSelector.addGoal(3, new FloatGoal(this));
				this.goalSelector.addGoal(4, new LeapAtTargetGoal(this, (float) 0.5));
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
			public InteractionResult mobInteract(Player sourceentity, InteractionHand hand) {
				ItemStack itemstack = sourceentity.getItemInHand(hand);
				InteractionResult retval = InteractionResult.SUCCESS;
				super.mobInteract(sourceentity, hand);
				double x = this.getX();
				double y = this.getY();
				double z = this.getZ();
				Entity entity = this;

				ShikamaruRightClickedOnEntityProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", level()), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z), new AbstractMap.SimpleEntry<>("sourceentity", sourceentity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return retval;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class TrainingDummyEntity extends NarutoShippudenModElements.ModElement {
		public static EntityType<CustomEntity> entity;

		public TrainingDummyEntity(NarutoShippudenModElements instance) {
			super(instance, 1191);
			NarutoShippudenMod.MOD_BUS.register(new EntityAttributesRegisterHandler());
		}

		@Override
		public void initElements() {
			elements.entities.add(() -> entity = (EntityType.Builder.<CustomEntity>of(CustomEntity::new, MobCategory.MONSTER) .setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3) .sized(0.6f, 1.8f)).build(Registration.entityKey("training_dummy")));
		}

		@Override
		public void init(FMLCommonSetupEvent event) {
		}

		public static class EntityAttributesRegisterHandler {
			@SubscribeEvent
			public void onEntityAttributeCreation(EntityAttributeCreationEvent event) {
				AttributeSupplier.Builder ammma = Mob.createMobAttributes();
				ammma = ammma.add(Attributes.MOVEMENT_SPEED, 0.1);
				ammma = ammma.add(Attributes.MAX_HEALTH, 1000);
				ammma = ammma.add(Attributes.ARMOR, 0);
				ammma = ammma.add(Attributes.ATTACK_DAMAGE, 0);
				ammma = ammma.add(Attributes.FOLLOW_RANGE, 16);
				ammma = ammma.add(Attributes.KNOCKBACK_RESISTANCE, 1000);
				event.put(entity, ammma.build());
			}
		}

		public static class CustomEntity extends PathfinderMob {

			public CustomEntity(EntityType<CustomEntity> type, Level world) {
				super(type, world);
				xpReward = 0;
				setNoAi(true);
				setPersistenceRequired();
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
				double x = this.getX();
				double y = this.getY();
				double z = this.getZ();
				Entity entity = this;
				Entity sourceentity = source.getEntity();

				TrainingDummyEntityIsHurtProcedure.executeProcedure(
						Stream.of(new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("sourceentity", sourceentity))
								.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				if (source.getDirectEntity() instanceof ThrownSplashPotion || source.getDirectEntity() instanceof AreaEffectCloud)
					return false;
				if (source.is(net.minecraft.world.damagesource.DamageTypes.FALL))
					return false;
				if (source.is(net.minecraft.world.damagesource.DamageTypes.CACTUS))
					return false;
				if (source.is(net.minecraft.world.damagesource.DamageTypes.DROWN))
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

				TrainingDummyOnEntityTickUpdateProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", level()), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z), new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
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
