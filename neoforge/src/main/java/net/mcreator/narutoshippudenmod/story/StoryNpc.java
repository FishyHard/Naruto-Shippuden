package net.mcreator.narutoshippudenmod.story;

import net.mcreator.narutoshippudenmod.NarutoShippudenMod;
import net.mcreator.narutoshippudenmod.NarutoShippudenModElements;
import net.mcreator.narutoshippudenmod.compat.Registration;

import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;

/**
 * A story character standing in the world (Iruka at the Academy, ...): which one it is comes from its character id (the
 * file in story/characters), which also gives its name and skin. It stays where the story put it, looks at whoever is
 * near, cannot be hurt or pushed, and right-clicking it talks to it ({@link Story#talk}).
 */
@NarutoShippudenModElements.ModElement.Tag
public class StoryNpc extends NarutoShippudenModElements.ModElement {
	public static EntityType<Npc> entity;

	public StoryNpc(NarutoShippudenModElements instance) {
		super(instance, 5001);
		Registration.listen(NarutoShippudenMod.MOD_BUS, this);
	}

	@Override
	public void initElements() {
		elements.entities.add(() -> entity = EntityType.Builder.<Npc>of(Npc::new, MobCategory.MISC).sized(0.6F, 1.8F).clientTrackingRange(10)
				.build(Registration.entityKey("story_npc")));
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
	}

	@SubscribeEvent
	public void attributes(EntityAttributeCreationEvent event) {
		event.put(entity, Mob.createMobAttributes().add(Attributes.MOVEMENT_SPEED, 0.0).add(Attributes.MAX_HEALTH, 20).build());
	}

	public static class Npc extends PathfinderMob {
		private static final EntityDataAccessor<String> CHARACTER = SynchedEntityData.defineId(Npc.class, EntityDataSerializers.STRING);
		// what the client draws: the character's name, skin and model (legacy 64x32, player 64x64, slim), copied from its file
		private static final EntityDataAccessor<String> NAME = SynchedEntityData.defineId(Npc.class, EntityDataSerializers.STRING);
		private static final EntityDataAccessor<String> SKIN = SynchedEntityData.defineId(Npc.class, EntityDataSerializers.STRING);
		private static final EntityDataAccessor<String> MODEL = SynchedEntityData.defineId(Npc.class, EntityDataSerializers.STRING);

		public Npc(EntityType<Npc> type, Level level) {
			super(type, level);
			setPersistenceRequired();
			setPermanentlyInvulnerable(true);
		}

		public String character() {
			return entityData.get(CHARACTER);
		}

		public void setCharacter(String id) {
			entityData.set(CHARACTER, id);
		}

		/** Takes the character's name, skin and model (the server keeps them up to date with the data files). */
		public void applyCharacter(Story.Character c) {
			entityData.set(CHARACTER, c.id());
			entityData.set(NAME, c.name());
			entityData.set(SKIN, c.skin().toString());
			entityData.set(MODEL, c.model());
		}

		public String displayName() {
			return entityData.get(NAME);
		}

		public String skin() {
			return entityData.get(SKIN);
		}

		public String model() {
			return entityData.get(MODEL);
		}

		@Override
		protected void defineSynchedData(SynchedEntityData.Builder builder) {
			super.defineSynchedData(builder);
			builder.define(CHARACTER, "").define(NAME, "").define(SKIN, "").define(MODEL, "legacy");
		}

		@Override
		protected void registerGoals() {
			goalSelector.addGoal(1, new LookAtPlayerGoal(this, Player.class, 8.0F, 1.0F));
			goalSelector.addGoal(2, new RandomLookAroundGoal(this));
		}

		@Override
		public InteractionResult mobInteract(Player player, InteractionHand hand) {
			if (hand != InteractionHand.MAIN_HAND)
				return InteractionResult.PASS;
			if (player instanceof ServerPlayer serverPlayer)
				Story.talk(serverPlayer, this);
			return InteractionResult.SUCCESS;
		}

		@Override
		public boolean hurtServer(ServerLevel level, DamageSource source, float amount) {
			return false;
		}

		@Override
		public boolean isPushable() {
			return false;
		}

		@Override
		protected void doPush(Entity entity) {
		}

		@Override
		protected void pushEntities() {
		}

		@Override
		public boolean removeWhenFarAway(double distanceSqr) {
			return false;
		}

		@Override
		protected void addAdditionalSaveData(ValueOutput output) {
			super.addAdditionalSaveData(output);
			output.putString("Character", character());
			output.putString("StoryName", displayName());
			output.putString("StorySkin", skin());
			output.putString("StoryModel", model());
		}

		@Override
		protected void readAdditionalSaveData(ValueInput input) {
			super.readAdditionalSaveData(input);
			setCharacter(input.getStringOr("Character", ""));
			entityData.set(NAME, input.getStringOr("StoryName", ""));
			entityData.set(SKIN, input.getStringOr("StorySkin", ""));
			entityData.set(MODEL, input.getStringOr("StoryModel", "legacy"));
		}
	}
}
