package net.mcreator.narutoshippudenmod.core.jutsu;

import static net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.puff;
import static net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.sound;

import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables;
import net.mcreator.narutoshippudenmod.core.jutsu.engine.Element;
import net.mcreator.narutoshippudenmod.core.jutsu.engine.JutsuProjectile;
import net.mcreator.narutoshippudenmod.core.jutsu.engine.JutsuProjectile.Shape;
import net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques;
import net.mcreator.narutoshippudenmod.entity.NpcEntities.HiddenCloudShinobiEntity;
import net.mcreator.narutoshippudenmod.entity.NpcEntities.HiddenLeafShinobiEntity;
import net.mcreator.narutoshippudenmod.entity.NpcEntities.HiddenMistShinobiEntity;
import net.mcreator.narutoshippudenmod.entity.NpcEntities.HiddenSandShinobiEntity;
import net.mcreator.narutoshippudenmod.entity.NpcEntities.HiddenStoneShinobiEntity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.GoalSelector;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.TargetGoal;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.Vec3;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import org.jspecify.annotations.Nullable;

/**
 * The shinobi of the hidden villages. Each is a Genin, Chunin or Jonin (rolled when it spawns: health, chakra, speed, how many and
 * how strong its jutsu are, how fast it weaves signs). They fight like shinobi, with the same jutsu the player learns:
 * <ul>
 * <li>they keep to the range their village's nature works best at, strafing round the enemy, and close in or back off;</li>
 * <li>they weave hand signs (a visible pause, arms raised) before each jutsu of their village's nature, and spend chakra on it;</li>
 * <li>they throw kunai and shuriken, strike up close, Body Flicker in from afar, and use the Substitution Jutsu to escape a blow
 * (a log is left behind);</li>
 * <li>when out of chakra and hurt they fall back to recover.</li>
 * </ul>
 * They are peaceful until attacked; they call their comrades, defend players of their own village, fight monsters, and never hit
 * their own with their jutsu.
 * <p>
 * Each is one of six {@link Style}s, read from its UUID (so the client, which knows the UUID, draws the matching look without any
 * sync; client/ShinobiRenderer): balanced, taijutsu, marksman, ninjutsu, kenjutsu or medical ninja. The style changes its stats,
 * weapon, the range it keeps, how often it throws, strikes or weaves signs, and gives it its own moves (a leap and a heavy kick,
 * a fan of shuriken, explosive tags and a jump back, quicker signs, a dash and a parry, healing).
 */
@EventBusSubscriber(modid = "naruto_shippuden")
public final class ShinobiAI {
	public static final String[] RANKS = { "Genin", "Chunin", "Jonin" };
	/** Entity event: the shinobi starts weaving signs (the client raises its arms). */
	public static final byte SIGNS = 71;

	private ShinobiAI() {
	}

	/** A jutsu a shinobi knows: from which rank, its chakra, own cooldown and the distances it's used at. */
	record Move(String name, int rank, int chakra, int cooldown, double min, double max, boolean guard, Consumer<LivingEntity> cast) {
	}

	/** A village: its name, nature, the range it likes to fight at and its jutsu. */
	enum Village {
		LEAF("Leaf", "Hidden Leaf", Element.FIRE, 8, List.of(
				new Move("Phoenix Sage Fire Technique", 0, 60, 100, 4, 16, false, NatureJutsu::phoenixSageFire),
				new Move("Great Fireball Technique", 1, 120, 160, 5, 20, false, NatureJutsu::greatFireball),
				new Move("Great Flame Technique", 2, 180, 240, 3, 9, false, NatureJutsu::greatFlame),
				new Move("Great Dragon Fire Technique", 2, 250, 320, 7, 22, false, p -> NatureJutsu.dragon(p, Element.FIRE, 16, 3.5F, 0.6F)))),
		MIST("Mist", "Hidden Mist", Element.WATER, 8, List.of(
				new Move("Water Gun Technique", 0, 50, 80, 3, 16, false, NatureJutsu::waterGun),
				new Move("Water Formation Wall", 1, 150, 400, 0, 5, true, NatureJutsu::waterWall),
				new Move("Water Shark Bullet Technique", 1, 150, 180, 5, 20, false, NatureJutsu::waterShark),
				new Move("Water Prison Technique", 2, 200, 420, 2, 8, false, NatureJutsu::waterPrison),
				new Move("Water Dragon Bullet Technique", 2, 260, 320, 7, 22, false, p -> NatureJutsu.dragon(p, Element.WATER, 18, 4, 2)))),
		SAND("Sand", "Hidden Sand", Element.WIND, 7, List.of(
				new Move("Gale Palm", 0, 50, 90, 2, 8, false, NatureJutsu::galePalm),
				new Move("Vacuum Sphere", 1, 120, 140, 5, 18, false, NatureJutsu::vacuumSphere),
				new Move("Great Breakthrough", 2, 180, 240, 3, 12, false, NatureJutsu::greatBreakthrough),
				new Move("Vacuum Great Sphere", 2, 240, 300, 6, 20, false, NatureJutsu::vacuumGreatSphere))),
		STONE("Stone", "Hidden Stone", Element.EARTH, 5, List.of(
				new Move("Rock Pillar Spears", 0, 80, 120, 3, 12, false, NatureJutsu::earthSpikes),
				new Move("Earth-Style Wall", 1, 150, 400, 0, 5, true, NatureJutsu::earthWall),
				new Move("Earth Dragon Bullet", 1, 180, 220, 5, 18, false, NatureJutsu::earthDragonBullet),
				new Move("Double Suicide Decapitation Technique", 2, 150, 320, 3, 11, false, NatureJutsu::doubleSuicide),
				new Move("Swamp of the Underworld", 2, 250, 420, 5, 20, false, NatureJutsu::swamp))),
		CLOUD("Cloud", "Hidden Cloud", Element.LIGHTNING, 6, List.of(
				new Move("Chidori Senbon", 0, 60, 80, 4, 16, false, NatureJutsu::chidoriSenbon),
				new Move("Lightning Beast Tracking Fang", 1, 140, 160, 5, 18, false, NatureJutsu::lightningBall),
				new Move("Lariat", 2, 200, 240, 3, 10, false, NatureJutsu::lariat),
				new Move("Chidori", 2, 250, 300, 3, 8, false, NatureJutsu::chidori)));

		final String title, village;
		final Element element;
		final double range;
		final List<Move> moves;

		Village(String title, String village, Element element, double range, List<Move> moves) {
			this.title = title;
			this.village = village;
			this.element = element;
			this.range = range;
			this.moves = moves;
		}
	}

	static @Nullable Village village(@Nullable Entity entity) {
		if (entity instanceof HiddenLeafShinobiEntity.CustomEntity)
			return Village.LEAF;
		if (entity instanceof HiddenMistShinobiEntity.CustomEntity)
			return Village.MIST;
		if (entity instanceof HiddenSandShinobiEntity.CustomEntity)
			return Village.SAND;
		if (entity instanceof HiddenStoneShinobiEntity.CustomEntity)
			return Village.STONE;
		if (entity instanceof HiddenCloudShinobiEntity.CustomEntity)
			return Village.CLOUD;
		return null;
	}

	/** How a shinobi fights. The n-th look of each village (textures/entities/shinobi/&lt;village&gt;_n.png) fights in the n-th style. */
	public enum Style {
		BALANCED(""), TAIJUTSU(" (Taijutsu)"), MARKSMAN(" (Marksman)"), NINJUTSU(" (Ninjutsu)"), KENJUTSU(" (Swordsman)"), MEDIC(" (Medical Ninja)");

		final String label;

		Style(String label) {
			this.label = label;
		}
	}

	/** Which of its village's six looks and styles a shinobi has: from its UUID, which server and client both know. */
	public static int variant(Entity entity) {
		java.util.UUID id = entity.getUUID();
		long h = id.getMostSignificantBits() ^ id.getLeastSignificantBits();
		return (int) Math.floorMod(h ^ (h >>> 32), (long) Style.values().length);
	}

	public static Style style(Entity entity) {
		return Style.values()[variant(entity)];
	}

	/** Client: the shinobi's skin, its village's and its variant's. */
	public static @Nullable Identifier texture(Entity entity) {
		Village village = village(entity);
		return village == null ? null
				: Identifier.fromNamespaceAndPath("naruto_shippuden", "textures/entities/shinobi/" + village.name().toLowerCase(java.util.Locale.ROOT) + "_" + variant(entity) + ".png");
	}

	private static void dev(Entity mob, String what) {
		if (Boolean.getBoolean("naruto.devtest"))
			net.mcreator.narutoshippudenmod.NarutoShippudenMod.LOGGER.info("DEVTEST style {} {}: {}", mob.getName().getString(), style(mob), what);
	}

	static int rank(Entity mob) {
		return Mth.clamp(mob.getPersistentData().getIntOr("ShinobiRank", 0), 0, 2);
	}

	private static double chakra(Entity mob) {
		return mob.getPersistentData().getDoubleOr("ChakraAmount", 0);
	}

	private static double maxChakra(Entity mob) {
		return Math.max(1, mob.getPersistentData().getDoubleOr("ChakraMax", 1));
	}

	private static void spend(Entity mob, double amount) {
		if (amount >= 100)
			dev(mob, "spends " + (int) amount + " of " + (int) chakra(mob));
		mob.getPersistentData().putDouble("ChakraAmount", Math.max(0, chakra(mob) - amount));
	}

	/** Whether this player is of the shinobi's village. */
	static boolean villager(Village village, Entity entity) {
		return entity instanceof Player player && village.village.equals(NarutoShippudenModVariables.get(player).village);
	}

	static {
		// a shinobi's jutsu spare its comrades and the players of its village (unless that's who it fights)
		Techniques.ALLIES = (caster, target) -> {
			Village village = village(caster);
			if (village == null)
				return false;
			if (caster instanceof Mob mob && mob.getTarget() == target)
				return false;
			return village(target) == village || villager(village, target);
		};
	}

	// ------------------------------------------------------------------ spawning
	/** Called when the shinobi first spawns: its rank, stats, name and kunai. */
	public static void spawned(PathfinderMob mob) {
		// a rank given in the summon command wins
		if (mob.getPersistentData().contains("ShinobiRank") && !mob.getPersistentData().getBooleanOr("ShinobiReady", false)) {
			spawned(mob, rank(mob));
			return;
		}
		float roll = mob.getRandom().nextFloat();
		spawned(mob, roll < 0.6F ? 0 : roll < 0.9F ? 1 : 2);
	}

	public static void spawned(PathfinderMob mob, int rank) {
		Village village = village(mob);
		if (village == null)
			return;
		Style style = style(mob);
		mob.getPersistentData().putInt("ShinobiRank", rank);
		mob.getPersistentData().putBoolean("ShinobiReady", true);
		mob.getPersistentData().putFloat("JutsuPower", new float[] { 0.8F, 1.0F, 1.3F }[rank] * (style == Style.NINJUTSU ? 1.15F : 1));
		// health, strike, speed and chakra, scaled by the style: brawlers are tough and quick, ninjutsu users carry more chakra
		double health = switch (style) {
			case TAIJUTSU -> 1.25;
			case KENJUTSU -> 1.1;
			case MARKSMAN, NINJUTSU -> 0.9;
			default -> 1;
		}, attack = switch (style) {
			case TAIJUTSU -> 2;
			case KENJUTSU -> 3;
			case NINJUTSU, MEDIC -> -1;
			default -> 0;
		}, speed = switch (style) {
			case TAIJUTSU -> 0.04;
			case MARKSMAN, KENJUTSU -> 0.02;
			default -> 0;
		}, chakraScale = switch (style) {
			case NINJUTSU -> 1.5;
			case MEDIC -> 1.25;
			case TAIJUTSU -> 0.6;
			case KENJUTSU -> 0.8;
			default -> 1;
		};
		base(mob, Attributes.MAX_HEALTH, new double[] { 40, 60, 90 }[rank] * health);
		base(mob, Attributes.ATTACK_DAMAGE, new double[] { 3, 4, 6 }[rank] + attack);
		base(mob, Attributes.MOVEMENT_SPEED, new double[] { 0.3, 0.32, 0.34 }[rank] + speed);
		base(mob, Attributes.FOLLOW_RANGE, 32);
		mob.setHealth(mob.getMaxHealth());
		double chakra = (new double[] { 600, 1100, 1800 }[rank] + mob.getRandom().nextInt(200)) * chakraScale;
		mob.getPersistentData().putDouble("ChakraMax", chakra);
		mob.getPersistentData().putDouble("ChakraAmount", chakra);
		mob.setCustomName(Component.literal(village.title + " " + RANKS[rank] + style.label));
		mob.setCustomNameVisible(false);
		// brawlers fight bare-handed, swordsmen with a tanto, the rest with a kunai (some Jonin with a tanto)
		String weapon = switch (style) {
			case TAIJUTSU -> null;
			case KENJUTSU -> "tanto";
			case BALANCED -> rank == 2 && mob.getRandom().nextBoolean() ? "tanto" : "kunai";
			default -> "kunai";
		};
		mob.setItemSlot(EquipmentSlot.MAINHAND, weapon == null ? ItemStack.EMPTY
				: new ItemStack(BuiltInRegistries.ITEM.getValue(Identifier.fromNamespaceAndPath("naruto_shippuden", weapon))));
		dress(mob);
	}

	/** Each variant's forehead protector (the genin headband item): its cloth's colour, "" = blue. */
	private static final Map<Village, String[]> BANDS = Map.of(
			Village.LEAF, new String[] { "", "_red", "", "", "_black", "" },
			Village.SAND, new String[] { "", "_black", "_black", "_red", "_black", "" },
			Village.MIST, new String[] { "_black", "", "_black", "_black", "_red", "" },
			Village.CLOUD, new String[] { "_black", "_black", "", "_red", "_black", "" },
			Village.STONE, new String[] { "", "_black", "_red", "_black", "_black", "" });
	private static final Map<Village, String> HIDDEN = Map.of(Village.LEAF, "konohagakure", Village.SAND, "sunagakure", Village.MIST, "kirigakure",
			Village.CLOUD, "kumogakure", Village.STONE, "iwagakure");

	/**
	 * What a shinobi wears as real armour (nothing of it is painted on the skins, porting/skins/shinobi.py): its village's
	 * forehead protector, and for the Leaf's Chunin and Jonin who fight in the uniform, the jonin vest. Never dropped.
	 */
	static void dress(Mob mob) {
		Village village = village(mob);
		if (village == null)
			return;
		Style style = style(mob);
		mob.setItemSlot(EquipmentSlot.HEAD, new ItemStack(BuiltInRegistries.ITEM.getValue(Identifier.fromNamespaceAndPath("naruto_shippuden",
				"genin_" + HIDDEN.get(village) + BANDS.get(village)[style.ordinal()] + "_helmet"))));
		boolean vest = village == Village.LEAF && rank(mob) >= 1 && (style == Style.BALANCED || style == Style.MARKSMAN || style == Style.NINJUTSU);
		mob.setItemSlot(EquipmentSlot.CHEST, vest ? new ItemStack(BuiltInRegistries.ITEM.getValue(Identifier.fromNamespaceAndPath("naruto_shippuden", "jonin_vest")))
				: ItemStack.EMPTY);
		mob.setDropChance(EquipmentSlot.HEAD, 0);
		mob.setDropChance(EquipmentSlot.CHEST, 0);
		mob.getPersistentData().putBoolean("ShinobiDressed", true);
	}

	private static void base(Mob mob, net.minecraft.core.Holder<net.minecraft.world.entity.ai.attributes.Attribute> attribute, double value) {
		AttributeInstance instance = mob.getAttribute(attribute);
		if (instance != null)
			instance.setBaseValue(value);
	}

	// ------------------------------------------------------------------ goals
	/** Replaces the MCreator goals (melee only, jutsu fired on a timer). */
	public static void goals(PathfinderMob mob, GoalSelector goals, GoalSelector targets) {
		Village village = village(mob);
		goals.addGoal(0, new FloatGoal(mob));
		goals.addGoal(1, new Combat(mob));
		goals.addGoal(5, new WaterAvoidingRandomStrollGoal(mob, 0.8));
		goals.addGoal(6, new LookAtPlayerGoal(mob, Player.class, 8));
		goals.addGoal(7, new RandomLookAroundGoal(mob));
		targets.addGoal(1, new HurtByTargetGoal(mob).setAlertOthers());
		targets.addGoal(2, new Defend(mob));
		// missing-nin (summoned with the tag "missing_nin", as a story mission's enemies) hunt players on sight
		targets.addGoal(2, new NearestAttackableTargetGoal<>(mob, Player.class, 10, true, false,
				(target, level) -> mob.entityTags().contains("missing_nin")));
		targets.addGoal(3, new NearestAttackableTargetGoal<>(mob, Monster.class, 10, true, false,
				(target, level) -> !(target instanceof Creeper) && village != null));
	}

	/** Takes up the fights of the players of its village and of its comrades nearby. */
	static final class Defend extends TargetGoal {
		private @Nullable LivingEntity enemy;

		Defend(Mob mob) {
			super(mob, false);
			setFlags(EnumSet.of(Goal.Flag.TARGET));
		}

		@Override
		public boolean canUse() {
			Village village = village(mob);
			if (village == null)
				return false;
			for (LivingEntity friend : mob.level().getEntitiesOfClass(LivingEntity.class, mob.getBoundingBox().inflate(16),
					e -> e != mob && (villager(village, e) || village(e) == village))) {
				LivingEntity attacker = friend.getLastHurtByMob();
				if (attacker != null && attacker.isAlive() && friend.tickCount - friend.getLastHurtByMobTimestamp() < 100 && !villager(village, attacker)
						&& village(attacker) != village) {
					enemy = attacker;
					return true;
				}
				// what the player of its village attacks, it attacks too
				if (villager(village, friend) && friend.getLastHurtMob() instanceof LivingEntity hit && hit.isAlive() && hit != mob
						&& friend.tickCount - friend.getLastHurtMobTimestamp() < 100 && village(hit) != village && !villager(village, hit)) {
					enemy = hit;
					return true;
				}
			}
			return false;
		}

		@Override
		public void start() {
			mob.setTarget(enemy);
			super.start();
		}
	}

	/** Everything a shinobi does in a fight. */
	static final class Combat extends Goal {
		private final PathfinderMob mob;
		private final Map<Move, Long> cooldowns = new HashMap<>();
		private int melee, thrown, jutsu = 40, flicker = 100, strafe, retreat, rooted, special = 40, hits;
		private boolean left, back;
		private @Nullable Move casting;
		private int castLeft;

		Combat(PathfinderMob mob) {
			this.mob = mob;
			setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
		}

		@Override
		public boolean canUse() {
			LivingEntity target = mob.getTarget();
			return target != null && target.isAlive() && village(mob) != null;
		}

		@Override
		public boolean canContinueToUse() {
			return canUse() && (castLeft > 0 || mob.distanceToSqr(mob.getTarget()) < 48 * 48);
		}

		@Override
		public boolean requiresUpdateEveryTick() {
			return true;
		}

		@Override
		public void stop() {
			casting = null;
			castLeft = 0;
			mob.getNavigation().stop();
			mob.getMoveControl().strafe(0, 0);
		}

		@Override
		public void tick() {
			LivingEntity target = mob.getTarget();
			if (target == null)
				return;
			ServerLevel level = (ServerLevel) mob.level();
			Village village = village(mob);
			Style style = style(mob);
			int rank = rank(mob);
			double distance = mob.distanceTo(target);
			boolean sees = mob.getSensing().hasLineOfSight(target);
			mob.getLookControl().setLookAt(target, 30, 30);
			melee--;
			thrown--;
			jutsu--;
			flicker--;
			special--;

			// weaving signs: rooted in place, chakra gathering at the hands, then the jutsu
			if (castLeft > 0) {
				mob.getNavigation().stop();
				mob.getMoveControl().strafe(0, 0);
				face(mob, target, 0);
				Vec3 hands = mob.position().add(0, 1.2, 0).add(Vec3.directionFromRotation(0, mob.getYRot()).scale(0.4));
				level.sendParticles(village.element.trail, hands.x, hands.y, hands.z, 2, 0.15, 0.15, 0.15, 0.01);
				if (--castLeft == 0 && casting != null) {
					Move move = casting;
					casting = null;
					face(mob, target, distance);
					Jutsus.missed = false;
					if (Boolean.getBoolean("naruto.devtest"))
						net.mcreator.narutoshippudenmod.NarutoShippudenMod.LOGGER.info("DEVTEST shinobi {} casts {}", mob.getName().getString(), move.name());
					move.cast().accept(mob);
					if (!Jutsus.missed)
						spend(mob, move.chakra());
					Jutsus.missed = false;
					// held still while the jutsu plays out: a prison is kept only while the caster stays; a charge steers by the look
					rooted = move.name().startsWith("Water Prison") ? 100 : move.name().equals("Chidori") || move.name().equals("Lariat") ? 30 : 12;
				}
				return;
			}
			if (rooted > 0) {
				rooted--;
				mob.getNavigation().stop();
				mob.getMoveControl().strafe(0, 0);
				face(mob, target, 0);
				return;
			}

			// out of chakra and hurt: fall back and gather chakra
			if (retreat > 0) {
				retreat--;
				Vec3 away = mob.position().subtract(target.position()).normalize().scale(10).add(mob.position());
				mob.getNavigation().moveTo(away.x, away.y, away.z, 1.3);
				return;
			}
			if (chakra(mob) < maxChakra(mob) * 0.12 && mob.getHealth() < mob.getMaxHealth() * 0.35 && mob.getRandom().nextInt(40) == 0) {
				retreat = 80;
				return;
			}

			// a medic treats the badly hurt first, itself or a comrade
			if (style == Style.MEDIC && heal(mob, level)) {
				rooted = 10;
				return;
			}
			// the style's own move
			if (special <= 0 && sees && mob.onGround() && styleMove(level, target, style, rank, distance))
				return;

			// jutsu
			if (jutsu <= 0 && sees) {
				Move move = pick(village, rank, distance, level.getGameTime());
				if (move != null) {
					casting = move;
					castLeft = new int[] { 16, 12, 8 }[rank];
					if (style == Style.NINJUTSU)
						castLeft = castLeft * 2 / 3;                  // quicker hands
					cooldowns.put(move, level.getGameTime() + move.cooldown());
					jutsu = (int) ((new int[] { 70, 50, 35 }[rank] + mob.getRandom().nextInt(30)) * switch (style) {
						case NINJUTSU -> 0.55;
						case MEDIC -> 1.2;
						case MARKSMAN -> 1.5;
						case KENJUTSU -> 2.0;
						case TAIJUTSU -> 2.5;
						default -> 1.0;
					});
					level.broadcastEntityEvent(mob, SIGNS);
					sound(level, mob.position(), SoundEvents.ARMOR_EQUIP_LEATHER.value(), 1, 1.6F);
					return;
				}
			}
			// Body Flicker: far away and in sight, it's suddenly close
			if (flicker <= 0 && sees && distance > 14 && chakra(mob) > 40) {
				flicker = 160;
				Vec3 to = target.position().add(mob.position().subtract(target.position()).normalize().scale(3.5));
				BlockPos ground = NatureJutsu.ground(level, to.x, target.getY(), to.z);
				if (level.getBlockState(ground).isAir() && level.getBlockState(ground.above()).isAir()) {
					puff(level, mob.position().add(0, 1, 0), Element.SMOKE, 0.8F);
					mob.teleportTo(ground.getX() + 0.5, ground.getY(), ground.getZ() + 0.5);
					puff(level, mob.position().add(0, 1, 0), Element.SMOKE, 0.8F);
					sound(level, mob.position(), SoundEvents.BREEZE_JUMP, 1, 1.6F);
					spend(mob, 40);
					return;
				}
			}
			// kunai and shuriken: the marksman throws often and from far, the close fighters only at an enemy out of reach
			boolean close = style == Style.TAIJUTSU || style == Style.KENJUTSU;
			if (thrown <= 0 && sees && distance > (style == Style.MARKSMAN ? 2 : close ? 8 : 4) && distance < (style == Style.MARKSMAN ? 26 : 18)) {
				if (style == Style.MARKSMAN)
					volley(mob, target, rank);
				else
					throwWeapon(mob, target, rank);
				thrown = (int) ((30 + mob.getRandom().nextInt(30) - rank * 5) * (style == Style.MARKSMAN ? 0.5 : close ? 2 : 1));
			}
			// up close: strike
			double reach = style == Style.KENJUTSU ? 3.3 : 2.8;
			if (distance < reach && melee <= 0 && sees) {
				strike(level, target, style, rank);
				melee = (int) ((20 - rank * 3) * switch (style) {
					case TAIJUTSU -> 0.6;
					case KENJUTSU -> 0.8;
					case NINJUTSU, MARKSMAN -> 1.4;
					default -> 1.0;
				});
			}

			// footwork: keep to the style's range (the village's for the balanced), circling the enemy
			double preferred = switch (style) {
				case TAIJUTSU, KENJUTSU -> 1.8;
				case MARKSMAN -> 12;
				case NINJUTSU -> village.range + 4;
				case MEDIC -> village.range + 2;
				default -> village.range;
			};
			if (chakra(mob) < 120 && style != Style.MARKSMAN)
				preferred = Math.min(preferred, 2);
			if (!sees || distance > preferred + (preferred < 3 ? 0.8 : 3)) {
				mob.getNavigation().moveTo(target, 1.2 + rank * 0.05);
			} else {
				mob.getNavigation().stop();
				if (--strafe <= 0) {
					strafe = 20 + mob.getRandom().nextInt(30);
					left = mob.getRandom().nextBoolean();
				}
				back = distance < preferred - 2 && preferred > 3;
				float forward = back ? -0.6F : distance > preferred + 1 ? 0.5F : 0;
				mob.getMoveControl().strafe(forward, left ? 0.6F : -0.6F);
				if (mob.horizontalCollision && mob.onGround() && mob.getRandom().nextInt(5) == 0)
					mob.getJumpControl().jump();
			}
		}

		/** A blow up close: a brawler's third blow is a kick that sends the enemy flying, a swordsman's cuts all round, a medic's
		 * chakra scalpel weakens. */
		private void strike(ServerLevel level, LivingEntity target, Style style, int rank) {
			Weapons.swing(mob);
			mob.doHurtTarget(level, target);
			hits++;
			Vec3 away = target.position().subtract(mob.position()).multiply(1, 0, 1).normalize();
			switch (style) {
				case TAIJUTSU -> {
					if (hits % 3 == 0) {
						dev(mob, "kick");
						// the Leaf Hurricane's kind of kick
						target.push(away.x * (1.1 + rank * 0.2), 0.45, away.z * (1.1 + rank * 0.2));
						target.syncVelocity = true;
						Techniques.damage(mob, target, 2 + rank * 2, Element.WIND);
						level.sendParticles(ParticleTypes.SWEEP_ATTACK, target.getX(), target.getY() + 1, target.getZ(), 1, 0, 0, 0, 0);
						sound(level, target.position(), SoundEvents.PLAYER_ATTACK_KNOCKBACK, 1, 0.8F);
					}
				}
				case KENJUTSU -> {
					// the cut carries on to whoever else stands in front
					for (LivingEntity other : Techniques.cone(mob, 3.3, 70))
						if (other != target)
							Techniques.damage(mob, other, 2 + rank * 2, Element.STEEL);
					level.sendParticles(ParticleTypes.SWEEP_ATTACK, target.getX(), target.getY() + 1, target.getZ(), 1, 0, 0, 0, 0);
					sound(level, target.position(), SoundEvents.PLAYER_ATTACK_SWEEP, 1, 1.2F);
				}
				case MEDIC -> {
					if (hits % 2 == 0) {
						dev(mob, "scalpel");
						target.addEffect(new net.minecraft.world.effect.MobEffectInstance(net.minecraft.world.effect.MobEffects.WEAKNESS, 80 + rank * 40, rank == 2 ? 1 : 0));
						target.addEffect(new net.minecraft.world.effect.MobEffectInstance(net.minecraft.world.effect.MobEffects.SLOWNESS, 60, 0));
						level.sendParticles(new net.minecraft.core.particles.DustParticleOptions(0x7CFFB0, 1.0F), target.getX(), target.getY() + 1, target.getZ(), 10, 0.3,
								0.4, 0.3, 0);
					}
				}
				default -> {
				}
			}
		}

		/** The style's own move, when its time has come: true if it did one. */
		private boolean styleMove(ServerLevel level, LivingEntity target, Style style, int rank, double distance) {
			Vec3 to = target.position().subtract(mob.position()).multiply(1, 0, 1).normalize();
			switch (style) {
				case TAIJUTSU -> {
					// a leap straight at the enemy, landing in reach
					if (distance < 4 || distance > 11)
						return false;
					mob.setDeltaMovement(to.x * (0.5 + distance * 0.07), 0.48, to.z * (0.5 + distance * 0.07));
					melee = 0;
					special = 70 - rank * 10;
					dev(mob, "leap");
					sound(level, mob.position(), SoundEvents.BREEZE_JUMP, 1, 1.2F);
					level.sendParticles(ParticleTypes.CLOUD, mob.getX(), mob.getY() + 0.1, mob.getZ(), 6, 0.3, 0, 0.3, 0.02);
					return true;
				}
				case KENJUTSU -> {
					// a dash in with the blade, cutting on arrival
					if (distance < 4 || distance > 10)
						return false;
					face(mob, target, 0);
					mob.setDeltaMovement(to.x * 1.5, 0.12, to.z * 1.5);
					melee = 0;
					special = 90 - rank * 15;
					dev(mob, "dash");
					sound(level, mob.position(), SoundEvents.PLAYER_ATTACK_SWEEP, 1, 1.6F);
					Techniques.line(level, ParticleTypes.CRIT, mob.position().add(0, 1, 0), target.position().add(0, 1, 0), 0.6);
					return true;
				}
				case MARKSMAN -> {
					// pressed close: a jump back, a volley as it lands
					if (distance > 4)
						return false;
					mob.setDeltaMovement(-to.x * 1.0, 0.45, -to.z * 1.0);
					thrown = 6;
					special = 60 - rank * 10;
					dev(mob, "jump back");
					sound(level, mob.position(), SoundEvents.BREEZE_JUMP, 1, 1.5F);
					return true;
				}
				case NINJUTSU -> {
					// pressed close: Body Flicker away to its range
					if (distance > 3 || chakra(mob) < 40)
						return false;
					Vec3 away = mob.position().subtract(target.position()).multiply(1, 0, 1).normalize().scale(9).add(mob.position());
					BlockPos ground = NatureJutsu.ground(level, away.x, mob.getY(), away.z);
					if (!level.getBlockState(ground).isAir() || !level.getBlockState(ground.above()).isAir())
						return false;
					puff(level, mob.position().add(0, 1, 0), Element.SMOKE, 0.8F);
					mob.teleportTo(ground.getX() + 0.5, ground.getY(), ground.getZ() + 0.5);
					puff(level, mob.position().add(0, 1, 0), Element.SMOKE, 0.6F);
					sound(level, mob.position(), SoundEvents.BREEZE_JUMP, 1, 1.6F);
					spend(mob, 40);
					jutsu = Math.min(jutsu, 6);
					dev(mob, "flicker away");
					special = 120 - rank * 20;
					return true;
				}
				default -> {
					return false;
				}
			}
		}

		/** The jutsu to use now: one it knows, can pay for, isn't cooling down and suits the distance (a wall when pressed close). */
		private @Nullable Move pick(Village village, int rank, double distance, long time) {
			List<Move> usable = new ArrayList<>();
			for (Move move : village.moves) {
				if (move.rank() > rank || move.chakra() > chakra(mob) || cooldowns.getOrDefault(move, 0L) > time)
					continue;
				if (move.guard() ? distance < move.max() && mob.getLastHurtByMob() != null && mob.tickCount - mob.getLastHurtByMobTimestamp() < 40
						: distance >= move.min() && distance <= move.max())
					usable.add(move);
			}
			if (usable.isEmpty())
				return null;
			if (style(mob) == Style.NINJUTSU)
				usable.sort((a, b) -> Integer.compare(b.rank(), a.rank()));
			// the strongest known move is the likeliest
			usable.sort((a, b) -> Integer.compare(b.rank(), a.rank()));
			return mob.getRandom().nextInt(3) == 0 ? usable.get(mob.getRandom().nextInt(usable.size())) : usable.getFirst();
		}
	}

	/** Turns to face the target (leading a moving one by how far it will get before a jutsu arrives). */
	static void face(Mob mob, LivingEntity target, double distance) {
		Vec3 aim = target.getBoundingBox().getCenter().add(target.getDeltaMovement().multiply(1, 0, 1).scale(distance / 1.2));
		Vec3 d = aim.subtract(mob.getEyePosition());
		float yaw = (float) (Mth.atan2(d.z, d.x) * Mth.RAD_TO_DEG) - 90;
		float pitch = (float) -(Mth.atan2(d.y, Math.sqrt(d.x * d.x + d.z * d.z)) * Mth.RAD_TO_DEG);
		mob.setYRot(yaw);
		mob.setXRot(pitch);
		mob.setYHeadRot(yaw);
		mob.setYBodyRot(yaw);
	}

	/** A kunai or shuriken (Jonin throw three shuriken in a fan). */
	public static void throwWeapon(Mob mob, LivingEntity target, int rank) {
		ServerLevel level = (ServerLevel) mob.level();
		face(mob, target, mob.distanceTo(target));
		Weapons.swing(mob);
		boolean shuriken = mob.getRandom().nextBoolean();
		int count = shuriken && rank == 2 ? 3 : 1;
		for (int i = 0; i < count; i++) {
			float spread = (i - (count - 1) / 2F) * 6;
			JutsuProjectile weapon = Techniques.shoot(mob, Element.STEEL, shuriken ? Shape.SHURIKEN : Shape.KUNAI, shuriken ? 0.45F : 0.5F,
					Techniques.turned(mob, spread, -2).scale(1.5), 3 + rank);
			weapon.gravity = 0.02F;
			weapon.life = 30;
			weapon.knockback = 0.2F;
		}
		sound(level, mob.getEyePosition(), SoundEvents.TRIDENT_THROW.value(), 0.8F, 1.6F);
	}

	/**
	 * The marksman's throw: a fan of shuriken (three, five for a Jonin) or a kunai, which from a Chunin up may carry an explosive
	 * tag that bursts where it lands (nothing breaks).
	 */
	static void volley(Mob mob, LivingEntity target, int rank) {
		ServerLevel level = (ServerLevel) mob.level();
		float roll = mob.getRandom().nextFloat();
		if (rank >= 1 && roll < 0.3F) {
			face(mob, target, mob.distanceTo(target));
			Weapons.swing(mob);
			JutsuProjectile kunai = Techniques.shoot(mob, Element.STEEL, Shape.KUNAI, 0.5F, Techniques.turned(mob, 0, -3).scale(1.4), 3 + rank);
			kunai.gravity = 0.02F;
			kunai.life = 40;
			float blast = 4 + rank * 2;
			dev(mob, "explosive tag");
			kunai.onImpact = p -> {
				Techniques.burst(level, p.position(), 2.5F, blast, 0.7F, Element.FIRE, p);
				level.sendParticles(ParticleTypes.EXPLOSION, p.getX(), p.getY(), p.getZ(), 1, 0, 0, 0, 0);
			};
			sound(level, mob.getEyePosition(), SoundEvents.TRIDENT_THROW.value(), 0.8F, 1.4F);
			return;
		}
		if (roll < 0.65F) {
			face(mob, target, mob.distanceTo(target));
			Weapons.swing(mob);
			int count = rank == 2 ? 5 : 3;
			dev(mob, "fan of " + count);
			for (int i = 0; i < count; i++) {
				JutsuProjectile shuriken = Techniques.shoot(mob, Element.STEEL, Shape.SHURIKEN, 0.45F,
						Techniques.turned(mob, (i - (count - 1) / 2F) * 5, -2).scale(1.6), 2 + rank);
				shuriken.gravity = 0.02F;
				shuriken.life = 34;
				shuriken.knockback = 0.15F;
			}
			sound(level, mob.getEyePosition(), SoundEvents.TRIDENT_THROW.value(), 0.8F, 1.7F);
			return;
		}
		throwWeapon(mob, target, rank);
	}

	/**
	 * A medic's Mystical Palm: the most hurt of itself, its comrades and the players of its village within reach (below half health)
	 * is healed, at a chakra cost, every few seconds. In a fight and out of one.
	 */
	static boolean heal(PathfinderMob mob, ServerLevel level) {
		long time = level.getGameTime();
		if (mob.getPersistentData().getLongOr("HealReady", 0) > time || chakra(mob) < 60)
			return false;
		Village village = village(mob);
		LivingEntity patient = null;
		for (LivingEntity e : level.getEntitiesOfClass(LivingEntity.class, mob.getBoundingBox().inflate(10),
				e -> e.isAlive() && (e == mob || village(e) == village || villager(village, e)) && e.getHealth() < e.getMaxHealth() * 0.5F))
			if (patient == null || e.getHealth() / e.getMaxHealth() < patient.getHealth() / patient.getMaxHealth())
				patient = e;
		if (patient == null)
			return false;
		int rank = rank(mob);
		dev(mob, "heals " + patient.getName().getString() + " at " + (int) patient.getHealth());
		patient.heal(6 + 4 * rank);
		spend(mob, 60);
		mob.getPersistentData().putLong("HealReady", time + new int[] { 200, 160, 120 }[rank]);
		level.broadcastEntityEvent(mob, SIGNS);
		face(mob, patient, 0);
		if (patient != mob)
			Techniques.line(level, new net.minecraft.core.particles.DustParticleOptions(0x7CFFB0, 1.0F), mob.position().add(0, 1.2, 0),
					patient.position().add(0, 1, 0), 0.4);
		level.sendParticles(ParticleTypes.HAPPY_VILLAGER, patient.getX(), patient.getY() + 1, patient.getZ(), 12, 0.4, 0.6, 0.4, 0);
		sound(level, patient.position(), SoundEvents.AMETHYST_BLOCK_CHIME, 1, 1.2F);
		return true;
	}

	// ------------------------------------------------------------------ every tick
	/** Replaces the MCreator tick procedure (timed jutsu): chakra comes back, faster out of a fight. */
	public static void tick(PathfinderMob mob) {
		if (mob.level().isClientSide() || village(mob) == null)
			return;
		// summoned with a rank but without spawning ({NeoForgeData:{ShinobiRank:2}}), or from an old save: set it up now
		if (!mob.getPersistentData().getBooleanOr("ShinobiReady", false) && mob.tickCount > 1) {
			if (mob.getPersistentData().contains("ShinobiRank"))
				spawned(mob, rank(mob));
			else
				spawned(mob);
		}
		// (read after the setup: read before, the new chakra was capped at the old maximum of none)
		double max = maxChakra(mob);
		mob.getPersistentData().putDouble("ChakraAmount", Math.min(max, chakra(mob) + (mob.getTarget() == null ? 2 : 0.4)));
		// shinobi from before they wore their protectors
		if (mob.getPersistentData().getBooleanOr("ShinobiReady", false) && !mob.getPersistentData().getBooleanOr("ShinobiDressed", false))
			dress(mob);
		if (mob.getTarget() == null && mob.tickCount % 20 == 0 && mob.level() instanceof ServerLevel level) {
			Style style = style(mob);
			// out of a fight a medic looks after whoever is hurt; a brawler trains, punching the air where it stands
			if (style == Style.MEDIC)
				heal(mob, level);
			else if (style == Style.TAIJUTSU && mob.getNavigation().isDone() && mob.getRandom().nextInt(6) == 0)
				Techniques.channel(mob, 18, 6, i -> Weapons.swing(mob));
		}
	}

	// ------------------------------------------------------------------ Substitution Jutsu
	/**
	 * A blow (not a fall, fire or drowning) is taken by a log instead: the shinobi is suddenly a few blocks away, beside or behind the
	 * attacker. Jonin do it more often than Genin.
	 */
	@SubscribeEvent
	public static void substitution(LivingIncomingDamageEvent event) {
		if (!(event.getEntity() instanceof PathfinderMob mob) || village(mob) == null || !(mob.level() instanceof ServerLevel level))
			return;
		DamageSource source = event.getSource();
		Entity attacker = source.getEntity();
		if (attacker == null || source.is(DamageTypes.ON_FIRE) || source.is(DamageTypes.IN_FIRE) || event.getAmount() < 2)
			return;
		int rank = rank(mob);
		long time = level.getGameTime();
		// a swordsman turns a blow aimed at it from the front aside with its blade
		if (style(mob) == Style.KENJUTSU && source.getDirectEntity() == attacker && mob.distanceTo(attacker) < 4.5
				&& mob.getPersistentData().getLongOr("ParryReady", 0) <= time && mob.getRandom().nextFloat() < new float[] { 0.25F, 0.35F, 0.45F }[rank]) {
			Vec3 facing = Vec3.directionFromRotation(0, mob.getYRot());
			Vec3 toward = attacker.position().subtract(mob.position()).multiply(1, 0, 1).normalize();
			if (facing.dot(toward) > 0.3) {
				event.setCanceled(true);
				dev(mob, "parry");
				mob.getPersistentData().putLong("ParryReady", time + 40);
				Weapons.swing(mob);
				attacker.push(toward.x * 0.6, 0.15, toward.z * 0.6);
				attacker.syncVelocity = true;
				level.sendParticles(ParticleTypes.CRIT, mob.getX() + toward.x, mob.getY() + 1.3, mob.getZ() + toward.z, 10, 0.2, 0.2, 0.2, 0.2);
				sound(level, mob.position(), SoundEvents.ANVIL_LAND, 0.5F, 1.8F);
				if (attacker instanceof LivingEntity living && mob.getTarget() == null)
					mob.setTarget(living);
				return;
			}
		}
		if (mob.getPersistentData().getLongOr("SubstitutionReady", 0) > time || mob.getRandom().nextFloat() > new float[] { 0.35F, 0.5F, 0.7F }[rank]
				|| chakra(mob) < 30)
			return;
		Vec3 from = attacker.position();
		Vec3 side = Vec3.directionFromRotation(0, attacker.getYRot() + (mob.getRandom().nextBoolean() ? 90 : -90) + mob.getRandom().nextInt(90) - 45);
		Vec3 to = from.add(side.scale(3 + mob.getRandom().nextInt(3)));
		BlockPos ground = NatureJutsu.ground(level, to.x, mob.getY(), to.z);
		if (!level.getBlockState(ground).isAir() || !level.getBlockState(ground.above()).isAir())
			return;
		event.setCanceled(true);
		mob.getPersistentData().putLong("SubstitutionReady", time + new int[] { 300, 220, 160 }[rank]);
		spend(mob, 30);
		BlockPos log = mob.blockPosition();
		puff(level, mob.position().add(0, 1, 0), Element.SMOKE, 1);
		Techniques.place(level, log, Blocks.OAK_LOG.defaultBlockState(), 40, NatureJutsu.OPEN);
		sound(level, mob.position(), SoundEvents.WOOD_BREAK, 1, 0.8F);
		sound(level, mob.position(), SoundEvents.FIRE_EXTINGUISH, 0.8F, 1.6F);
		mob.teleportTo(ground.getX() + 0.5, ground.getY(), ground.getZ() + 0.5);
		puff(level, mob.position().add(0, 1, 0), Element.SMOKE, 0.7F);
		if (attacker instanceof LivingEntity living && mob.getTarget() == null)
			mob.setTarget(living);
	}

	// ------------------------------------------------------------------ client: the sign-weaving pose
	private static final Map<Integer, Integer> SIGNS_STARTED = new HashMap<>();

	/** Client side: the entity event that starts the pose. Returns false for events it doesn't know. */
	public static boolean clientEvent(Entity entity, byte id) {
		if (id != SIGNS)
			return false;
		SIGNS_STARTED.put(entity.getId(), entity.tickCount);
		return true;
	}

	/** Client side: how far into weaving signs the shinobi is, 0 (not) to 1 (hands together). */
	public static float signs(Entity entity, float partialTicks) {
		Integer start = SIGNS_STARTED.get(entity.getId());
		if (start == null)
			return 0;
		float t = entity.tickCount + partialTicks - start;
		if (t < 0 || t > 22) {
			if (t > 40)
				SIGNS_STARTED.remove(entity.getId());
			return 0;
		}
		return t < 4 ? t / 4 : t < 16 ? 1 : 1 - (t - 16) / 6;
	}
}
