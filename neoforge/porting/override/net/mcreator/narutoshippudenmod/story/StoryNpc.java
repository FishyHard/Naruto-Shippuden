package net.mcreator.narutoshippudenmod.story;

import net.mcreator.narutoshippudenmod.NarutoShippudenMod;
import net.mcreator.narutoshippudenmod.NarutoShippudenModElements;
import net.mcreator.narutoshippudenmod.compat.Registration;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
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
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;

import java.util.UUID;

/**
 * A story character standing in the world (Iruka at the Academy, ...): which one it is comes from its character id (the
 * file in story/characters), which also gives its name and skin. It stays where the story put it, looks at whoever is
 * near, cannot be hurt or pushed, and right-clicking it talks to it ({@link Story#talk}).
 *
 * <p>Two things a quest step can make of it: a <b>sparring partner</b> ({@link Npc#spar}), who fights one player for real
 * (only that player's hits land, it never dies) until they have landed enough hits; and a <b>scene character</b>
 * ({@link Npc#setScene}), placed for one player's quest steps only and gone once the quest moves past them.
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
		event.put(entity, Mob.createMobAttributes().add(Attributes.MOVEMENT_SPEED, 0.32).add(Attributes.MAX_HEALTH, 20).add(Attributes.ATTACK_DAMAGE, 2)
				.add(Attributes.FOLLOW_RANGE, 32).build());
	}

	public static class Npc extends PathfinderMob {
		private static final EntityDataAccessor<String> CHARACTER = SynchedEntityData.defineId(Npc.class, EntityDataSerializers.STRING);
		// what the client draws: the character's name, skin and model (legacy 64x32, player 64x64, slim), copied from its file
		private static final EntityDataAccessor<String> NAME = SynchedEntityData.defineId(Npc.class, EntityDataSerializers.STRING);
		private static final EntityDataAccessor<String> SKIN = SynchedEntityData.defineId(Npc.class, EntityDataSerializers.STRING);
		private static final EntityDataAccessor<String> MODEL = SynchedEntityData.defineId(Npc.class, EntityDataSerializers.STRING);

		// sparring: with whom, how many hits they still need, a breather after a lost round
		private UUID sparWith;
		private int sparHitsLeft, sparHits, sparPause;
		// a scene character: whose quest, and the steps it is there for [from, until)
		private UUID sceneOwner;
		private String sceneQuest = "";
		private int sceneFrom, sceneUntil;

		public Npc(EntityType<Npc> type, Level level) {
			super(type, level);
			setPersistenceRequired();
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

		// ------------------------------------------------------------ scene characters

		public void setScene(UUID owner, String quest, int from, int until) {
			sceneOwner = owner;
			sceneQuest = quest;
			sceneFrom = from;
			sceneUntil = until;
		}

		public boolean isScene() {
			return sceneOwner != null;
		}

		public boolean sceneFor(UUID player) {
			return player.equals(sceneOwner);
		}

		/** A scene character whose player has gone, or whose quest has moved past its steps, leaves. */
		public boolean sceneOver(net.minecraft.server.MinecraftServer server) {
			ServerPlayer owner = server.getPlayerList().getPlayer(sceneOwner);
			if (owner == null)
				return true;
			int step = Story.stepIndex(owner, sceneQuest);
			return step < sceneFrom || step >= sceneUntil;
		}

		// ------------------------------------------------------------ sparring

		/** Starts sparring with the player: they must land this many hits; it hits back for damage. */
		public void spar(ServerPlayer player, int hits, double damage) {
			sparWith = player.getUUID();
			sparHits = hits;
			sparHitsLeft = hits;
			sparPause = 0;
			AttributeInstance attack = getAttribute(Attributes.ATTACK_DAMAGE);
			if (attack != null)
				attack.setBaseValue(damage);
			setTarget(player);
		}

		public void stopSparring() {
			sparWith = null;
			setTarget(null);
			getNavigation().stop();
		}

		public boolean isSparringWith(Entity e) {
			return sparWith != null && e != null && sparWith.equals(e.getUUID());
		}

		public boolean isSparring() {
			return sparWith != null;
		}

		private ServerPlayer sparPlayer() {
			return sparWith == null || !(level() instanceof ServerLevel level) ? null : level.getServer().getPlayerList().getPlayer(sparWith);
		}

		@Override
		protected void registerGoals() {
			goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.15, true) {
				@Override
				public boolean canUse() {
					return sparWith != null && sparPause <= 0 && super.canUse();
				}

				@Override
				public boolean canContinueToUse() {
					return sparWith != null && sparPause <= 0 && super.canContinueToUse();
				}
			});
			goalSelector.addGoal(2, new LookAtPlayerGoal(this, Player.class, 8.0F, 1.0F));
			goalSelector.addGoal(3, new RandomLookAroundGoal(this));
		}

		@Override
		public void aiStep() {
			super.aiStep();
			if (level().isClientSide() || sparWith == null)
				return;
			ServerPlayer p = sparPlayer();
			if (p == null || !p.isAlive() || p.level() != level() || p.distanceToSqr(this) > 32 * 32) {
				stopSparring();
				return;
			}
			if (sparPause > 0 && --sparPause == 0)
				setTarget(p);
			// the player is beaten: the round is lost, and starts over after a breath
			if (sparPause == 0 && p.getHealth() <= 5) {
				sparHitsLeft = sparHits;
				sparPause = 60;
				setTarget(null);
				getNavigation().stop();
				p.sendSystemMessage(Component.literal(displayName() + " wins this round. Catch your breath and try again!").withStyle(ChatFormatting.YELLOW));
				p.heal(p.getMaxHealth());
				Story.sparProgress(p, this, 0, sparHits);
			}
		}

		@Override
		public boolean doHurtTarget(ServerLevel level, Entity target) {
			// only the sparring partner is ever hit
			return isSparringWith(target) && super.doHurtTarget(level, target);
		}

		@Override
		public InteractionResult mobInteract(Player player, InteractionHand hand) {
			if (hand != InteractionHand.MAIN_HAND || sparWith != null)
				return InteractionResult.PASS;
			if (player instanceof ServerPlayer serverPlayer)
				Story.talk(serverPlayer, this);
			return InteractionResult.SUCCESS;
		}

		@Override
		public boolean hurtServer(ServerLevel level, DamageSource source, float amount) {
			// only a sparring partner's hits land, and they never wear it down: they count
			if (!isSparringWith(source.getEntity()) || sparPause > 0)
				return false;
			boolean hurt = super.hurtServer(level, source, Math.min(amount, 1));
			setHealth(getMaxHealth());
			if (hurt && source.getEntity() instanceof ServerPlayer p) {
				sparHitsLeft--;
				if (sparHitsLeft <= 0) {
					stopSparring();
					Story.sparWon(p, this);
				} else
					Story.sparProgress(p, this, sparHits - sparHitsLeft, sparHits);
			}
			return hurt;
		}

		@Override
		public boolean isPushable() {
			return sparWith != null;
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
			if (sceneOwner != null) {
				output.putString("SceneOwner", sceneOwner.toString());
				output.putString("SceneQuest", sceneQuest);
				output.putInt("SceneFrom", sceneFrom);
				output.putInt("SceneUntil", sceneUntil);
			}
		}

		@Override
		protected void readAdditionalSaveData(ValueInput input) {
			super.readAdditionalSaveData(input);
			setCharacter(input.getStringOr("Character", ""));
			entityData.set(NAME, input.getStringOr("StoryName", ""));
			entityData.set(SKIN, input.getStringOr("StorySkin", ""));
			entityData.set(MODEL, input.getStringOr("StoryModel", "legacy"));
			String owner = input.getStringOr("SceneOwner", "");
			if (!owner.isEmpty()) {
				sceneOwner = UUID.fromString(owner);
				sceneQuest = input.getStringOr("SceneQuest", "");
				sceneFrom = input.getIntOr("SceneFrom", 0);
				sceneUntil = input.getIntOr("SceneUntil", 0);
			}
		}

		@Override
		protected void defineSynchedData(SynchedEntityData.Builder builder) {
			super.defineSynchedData(builder);
			builder.define(CHARACTER, "").define(NAME, "").define(SKIN, "").define(MODEL, "legacy");
		}
	}
}
