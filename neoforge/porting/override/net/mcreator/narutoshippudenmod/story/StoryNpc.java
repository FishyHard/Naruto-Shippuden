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

		// sparring: with whom, how many hits they still need, a breather after a lost round, and how it fights
		private UUID sparWith;
		private int sparHitsLeft, sparHits, sparPause, sparRank, substituteReady;
		private boolean sparThrows, sparSubstitution;
		// a clone in a scene: whom it rushes, and how long it lasts before it vanishes in smoke
		private UUID rushAt;
		private int lifeLeft = -1;
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
			for (net.minecraft.world.entity.EquipmentSlot slot : net.minecraft.world.entity.EquipmentSlot.values()) {
				String id = c.equipment().get(slot.getName());
				net.minecraft.world.item.ItemStack want = id == null ? net.minecraft.world.item.ItemStack.EMPTY
						: new net.minecraft.world.item.ItemStack(net.minecraft.core.registries.BuiltInRegistries.ITEM.getValue(net.minecraft.resources.Identifier.parse(id)));
				if (!net.minecraft.world.item.ItemStack.isSameItem(getItemBySlot(slot), want) && (id != null || !getItemBySlot(slot).isEmpty())) {
					setItemSlot(slot, want);
					setDropChance(slot, 0);
				}
			}
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
		public void spar(ServerPlayer player, int hits, double damage, int rank, boolean throwsWeapons, boolean substitution) {
			sparWith = player.getUUID();
			sparHits = hits;
			sparHitsLeft = hits;
			sparPause = 0;
			sparRank = rank;
			sparThrows = throwsWeapons;
			sparSubstitution = substitution;
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
			goalSelector.addGoal(1, new SparCombat(this));
			goalSelector.addGoal(2, new LookAtPlayerGoal(this, Player.class, 8.0F, 1.0F));
			goalSelector.addGoal(3, new RandomLookAroundGoal(this));
		}

		/**
		 * How a sparring partner fights, in the manner of the village shinobi (core/jutsu/ShinobiAI): it circles at arm's
		 * length and steps in to strike, throws kunai and shuriken from a distance (if its style does), Body Flickers back in
		 * when the player runs off, and keeps moving rather than walking straight at them.
		 */
		static final class SparCombat extends net.minecraft.world.entity.ai.goal.Goal {
			private final Npc npc;
			private int melee, thrown = 30, flicker = 60, strafe;
			private boolean left;

			SparCombat(Npc npc) {
				this.npc = npc;
				setFlags(java.util.EnumSet.of(Flag.MOVE, Flag.LOOK));
			}

			@Override
			public boolean canUse() {
				// its partner directly, not the mob's target: vanilla drops creative players as targets
				ServerPlayer p = npc.sparPlayer();
				return npc.sparPause <= 0 && p != null && p.isAlive();
			}

			@Override
			public boolean requiresUpdateEveryTick() {
				return true;
			}

			@Override
			public void stop() {
				npc.getNavigation().stop();
				npc.getMoveControl().strafe(0, 0);
			}

			@Override
			public void tick() {
				net.minecraft.world.entity.LivingEntity target = npc.sparPlayer();
				if (target == null || !(npc.level() instanceof ServerLevel level))
					return;
				double distance = npc.distanceTo(target);
				boolean sees = npc.getSensing().hasLineOfSight(target);
				npc.getLookControl().setLookAt(target, 30, 30);
				melee--;
				thrown--;
				flicker--;
				// Body Flicker: the player ran off; suddenly it is beside them again
				if (flicker <= 0 && sees && distance > 9) {
					flicker = 120 - npc.sparRank * 20;
					net.minecraft.world.phys.Vec3 to = target.position().add(npc.position().subtract(target.position()).normalize().scale(2.5));
					puff(level, npc);
					npc.teleportTo(to.x, target.getY(), to.z);
					puff(level, npc);
					level.playSound(null, npc.blockPosition(), net.minecraft.sounds.SoundEvents.BREEZE_JUMP, net.minecraft.sounds.SoundSource.NEUTRAL, 0.8F, 1.6F);
					return;
				}
				// kunai and shuriken from range
				if (npc.sparThrows && thrown <= 0 && sees && distance > 4 && distance < 14) {
					net.mcreator.narutoshippudenmod.core.jutsu.ShinobiAI.throwWeapon(npc, target, npc.sparRank);
					thrown = 50 + npc.getRandom().nextInt(40) - npc.sparRank * 10;
				}
				// up close: a strike, then it steps back out
				if (distance < 2.6 && melee <= 0 && sees) {
					npc.swing(InteractionHand.MAIN_HAND, net.minecraft.world.item.component.SwingAnimation.DEFAULT, true);
					npc.doHurtTarget(level, target);
					melee = 18 - npc.sparRank * 3;
					strafe = 0;
				}
				// footwork: in when it can strike, otherwise circling at a few blocks
				double keep = melee <= 0 ? 1.5 : 3.5;
				if (!sees || distance > keep + 3)
					npc.getNavigation().moveTo(target, 1.25);
				else {
					npc.getNavigation().stop();
					if (--strafe <= 0) {
						strafe = 15 + npc.getRandom().nextInt(25);
						left = npc.getRandom().nextBoolean();
					}
					float forward = distance > keep + 0.5 ? 0.7F : distance < keep - 1 ? -0.5F : 0;
					npc.getMoveControl().strafe(forward, left ? 0.55F : -0.55F);
					if (npc.horizontalCollision && npc.onGround())
						npc.getJumpControl().jump();
				}
			}
		}

		static void puff(ServerLevel level, Entity at) {
			level.sendParticles(net.minecraft.core.particles.ParticleTypes.CLOUD, at.getX(), at.getY() + 1, at.getZ(), 14, 0.3, 0.5, 0.3, 0.03);
			level.sendParticles(net.minecraft.core.particles.ParticleTypes.POOF, at.getX(), at.getY() + 1, at.getZ(), 6, 0.3, 0.5, 0.3, 0.02);
		}

		// ------------------------------------------------------------ scene effects: clones that rush, poses

		/** A clone in a scene: it rushes the target, striking, and vanishes in smoke after its time. */
		public void rush(Entity target, int ticks) {
			rushAt = target.getUUID();
			lifeLeft = ticks;
		}

		public void setStoryPose(String pose) {
			setPose(switch (pose) {
				case "crouch" -> net.minecraft.world.entity.Pose.CROUCHING;
				case "lie" -> net.minecraft.world.entity.Pose.SLEEPING;
				default -> net.minecraft.world.entity.Pose.STANDING;
			});
		}

		@Override
		public void aiStep() {
			super.aiStep();
			if (level().isClientSide())
				return;
			if (lifeLeft >= 0 && level() instanceof ServerLevel level) {
				if (--lifeLeft <= 0) {
					puff(level, this);
					level.playSound(null, blockPosition(), net.minecraft.sounds.SoundEvents.PUFFER_FISH_BLOW_OUT, net.minecraft.sounds.SoundSource.NEUTRAL, 0.6F, 1.4F);
					discard();
					return;
				}
				Entity target = rushAt == null ? null : level.getEntity(rushAt);
				if (target != null) {
					getLookControl().setLookAt(target, 30, 30);
					if (distanceToSqr(target) > 2.5 * 2.5)
						getNavigation().moveTo(target.getX(), target.getY(), target.getZ(), 1.4);
					else if (tickCount % 6 == getId() % 6) {
						swing(InteractionHand.MAIN_HAND, net.minecraft.world.item.component.SwingAnimation.DEFAULT, true);
						level.sendParticles(net.minecraft.core.particles.ParticleTypes.CRIT, target.getX(), target.getY() + 1, target.getZ(), 3, 0.3, 0.3, 0.3, 0.1);
						level.playSound(null, target.blockPosition(), net.minecraft.sounds.SoundEvents.PLAYER_ATTACK_STRONG, net.minecraft.sounds.SoundSource.NEUTRAL, 0.4F, 1.1F + getRandom().nextFloat() * 0.3F);
					}
				}
				return;
			}
			if (sparWith == null)
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
			if (target instanceof Player p && p.isCreative())
				return false;
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
			// the Substitution Jutsu: a puff of smoke, a log where it stood, and it is behind its opponent
			if (sparSubstitution && tickCount > substituteReady && getRandom().nextInt(6) == 0 && source.getEntity() instanceof ServerPlayer p) {
				substituteReady = tickCount + 160;
				puff(level, this);
				net.minecraft.world.entity.item.ItemEntity log = new net.minecraft.world.entity.item.ItemEntity(level, getX(), getY() + 0.5, getZ(),
						new net.minecraft.world.item.ItemStack(net.minecraft.world.item.Items.OAK_LOG));
				log.setPickUpDelay(32767);
				log.lifespan = 40;
				level.addFreshEntity(log);
				net.minecraft.world.phys.Vec3 behind = p.position().subtract(p.getLookAngle().multiply(1, 0, 1).normalize().scale(2));
				teleportTo(behind.x, p.getY(), behind.z);
				puff(level, this);
				level.playSound(null, blockPosition(), net.minecraft.sounds.SoundEvents.PUFFER_FISH_BLOW_OUT, net.minecraft.sounds.SoundSource.NEUTRAL, 0.7F, 1.2F);
				return false;
			}
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

		/** A scene character is seen only by its player, who meanwhile does not see the same character's usual figure (nor any
		 * character before the quest it waits for). */
		@Override
		public boolean broadcastToPlayer(ServerPlayer player) {
			if (sceneOwner != null)
				return sceneOwner.equals(player.getUUID());
			return Story.seesUsual(player, character()) && super.broadcastToPlayer(player);
		}

		@Override
		public void onAddedToLevel() {
			super.onAddedToLevel();
			if (sceneOwner != null && level() instanceof ServerLevel level)
				Story.sceneAdded(level, sceneOwner, character());
		}

		@Override
		public void onRemovedFromLevel() {
			super.onRemovedFromLevel();
			if (sceneOwner != null && level() instanceof ServerLevel level)
				Story.sceneRemoved(level, sceneOwner, character());
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
			output.putString("StoryPose", getPose() == net.minecraft.world.entity.Pose.CROUCHING ? "crouch" : getPose() == net.minecraft.world.entity.Pose.SLEEPING ? "lie" : "");
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
			setStoryPose(input.getStringOr("StoryPose", ""));
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
