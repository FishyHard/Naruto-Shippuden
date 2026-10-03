package net.mcreator.narutoshippudenmod.core;

import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables;
import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables.PlayerVariables;
import net.mcreator.narutoshippudenmod.core.jutsu.engine.Element;
import net.mcreator.narutoshippudenmod.core.jutsu.engine.JutsuProjectile;
import net.mcreator.narutoshippudenmod.core.jutsu.engine.JutsuProjectile.Shape;
import net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques;

import net.minecraft.core.Holder;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.phys.Vec3;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

import org.jspecify.annotations.Nullable;

import java.util.Locale;

/**
 * The Susanoo, rebuilt: five stages for each Mangekyou (Ribcage, Skeleton, Humanoid, Armoured, Complete), grown with the
 * Susanoo key (core/Eyes) up to the stages bought from the Mangekyou scroll, drawn by client/SusanooRenderer.
 * <ul>
 * <li>It eats chakra every second, more the bigger it is, and breaks apart when the chakra runs out or the Mangekyou closes.</li>
 * <li>It takes blows for its user: projectiles stop against it, the rest is mostly held off (the stronger the stage, the more),
 * at a chakra cost. From the Humanoid up fire and falls don't touch the user.</li>
 * <li>Ribcage and Skeleton slow the user a little; the Humanoid and Armoured stride over blocks; the Complete one flies.</li>
 * <li>From the Skeleton up, attacking swings the Susanoo's own arm through everything in front (client/SusanooClient sends it);
 * from the Humanoid up, using an empty hand fires the stage's own weapon, its owner's (Sasuke's arrows and the Kagutsuchi
 * sword, Indra's Arrow at the Complete stage).</li>
 * </ul>
 * Nothing it does breaks blocks.
 */
@EventBusSubscriber(modid = "naruto_shippuden")
public final class Susanoo {
	public static final String[] STAGES = { "", "Ribcage", "Skeleton", "Humanoid", "Armoured", "Complete" };
	public static final int MAX = 5;
	/** The Complete Susanoo stands on the ground with its user floating in its chest this many blocks up. */
	public static final float HOVER = 12.5F;                     // the Complete one's head, where its user sits, over its feet

	/** Chakra a second, by stage. */
	private static final double[] DRAIN = { 0, 3, 6, 10, 15, 24 };
	/** The share of a blow that still reaches the user, by stage. */
	private static final float[] TAKEN = { 1, 0.5F, 0.4F, 0.3F, 0.2F, 0.1F };
	/** The arm's swing: reach, damage, cooldown. */
	private static final double[] REACH = { 0, 0, 6, 8, 9.5, 13 };
	private static final float[] STRIKE = { 0, 0, 9, 13, 18, 28 };
	private static final int[] STRIKE_COOLDOWN = { 0, 0, 14, 16, 18, 22 };
	/** Movement: speed (share), step height (blocks). */
	private static final double[] SPEED = { 0, -0.15, -0.1, 0, 0.05, 0.2 };
	private static final double[] STEP = { 0, 0, 0, 0.5, 1, 1.5 };

	private static final Identifier SPEED_ID = id("susanoo_speed"), STEP_ID = id("susanoo_step"), KNOCKBACK_ID = id("susanoo_knockback"),
			FALL_ID = id("susanoo_fall");

	private Susanoo() {
	}

	private static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath("naruto_shippuden", path);
	}

	/** Whose Susanoo: each one's shape, colour and weapons. */
	public enum Owner {
		SASUKE(Element.SUSANOO), ITACHI(Element.SUSANOO_RED), SHISUI(Element.SUSANOO_GREEN), MADARA(Element.SUSANOO_BLUE), OBITO(Element.SUSANOO_WHITE);

		public final Element element;

		Owner(Element element) {
			this.element = element;
		}

		public String id() {
			return name().toLowerCase(Locale.ROOT);
		}

		public static @Nullable Owner of(PlayerVariables v) {
			return v.MangekyouSharinganSasuke ? SASUKE : v.MangekyouSharinganItachi ? ITACHI : v.MangekyouSharinganShisui ? SHISUI
					: v.MangekyouSharinganMadara ? MADARA : v.MangekyouSharinganObito ? OBITO : null;
		}
	}

	public static int stage(Entity entity) {
		return entity instanceof Player ? (int) NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage : 0;
	}

	// ------------------------------------------------------------------ growing and breaking
	/** How many stages the player has bought, for their Mangekyou. */
	public static int learned(PlayerVariables v) {
		Owner owner = Owner.of(v);
		if (owner == null)
			return 0;
		double n = switch (owner) {
			case SASUKE -> v.mangekyousharingansasukesusanolearn;
			case ITACHI -> v.mangekyoushrainganitachisusanolearn;
			case SHISUI -> v.mangekyousharinganshisuisusanolearn;
			case MADARA -> v.mangekyousharinganmadarasusanolearn;
			case OBITO -> v.mangekyousharinganobitosusanolearn;
		};
		return (int) Math.min(MAX, n);
	}

	static void setStage(ServerPlayer player, int stage) {
		NarutoShippudenModVariables.ifPresent(player, v -> {
			v.mangekyousharingansusanostage = stage;
			v.syncPlayerVariables(player);
		});
		apply(player, stage);
	}

	/** Grows the Susanoo a stage (the key held). */
	public static void grow(ServerPlayer player) {
		PlayerVariables v = NarutoShippudenModVariables.get(player);
		if (!v.MangekyouSharinganActivate) {
			player.sendOverlayMessage(Component.literal("Activate the Mangekyou Sharingan first"));
			return;
		}
		int max = learned(v), stage = (int) v.mangekyousharingansusanostage;
		if (max == 0) {
			player.sendOverlayMessage(Component.literal("Learn the Susanoo from your Mangekyou scroll"));
			return;
		}
		if (stage >= max)
			return;
		if (v.ChakraAmount < DRAIN[stage + 1] * 3) {
			player.sendOverlayMessage(Component.literal("Not enough chakra for the " + STAGES[stage + 1] + " Susanoo"));
			return;
		}
		setStage(player, stage + 1);
		player.sendOverlayMessage(Component.literal("Susanoo: " + STAGES[stage + 1]));
		// (the Complete Susanoo lifts its user into its chest and flies: client/SusanooFlight)
		ServerLevel level = (ServerLevel) player.level();
		Owner owner = Owner.of(v);
		sound(player, SoundEvents.BEACON_POWER_SELECT, 1, 0.5F + stage * 0.12F);
		sound(player, SoundEvents.WARDEN_SONIC_CHARGE, 0.6F + stage * 0.1F, 1.4F - stage * 0.12F);
		if (owner != null)
			level.sendParticles(owner.element.trail, player.getX(), player.getY() + 1 + stage * 0.6, player.getZ(), 30 + stage * 25, 0.6 + stage * 0.6,
					0.8 + stage * 0.8, 0.6 + stage * 0.6, 0.02);
	}

	/** Lets the Susanoo go (the key tapped). */
	public static void dismiss(ServerPlayer player) {
		if (stage(player) <= 0)
			return;
		setStage(player, 0);
		sound(player, SoundEvents.BEACON_DEACTIVATE, 1, 0.8F);
	}

	/** Breaks apart: out of chakra, or the eye closed. */
	public static void collapse(ServerPlayer player, String why) {
		int stage = stage(player);
		if (stage <= 0)
			return;
		Owner owner = Owner.of(NarutoShippudenModVariables.get(player));
		setStage(player, 0);
		player.sendOverlayMessage(Component.literal(why));
		sound(player, SoundEvents.GLASS_BREAK, 1.2F, 0.5F);
		sound(player, SoundEvents.BEACON_DEACTIVATE, 1, 0.6F);
		if (owner != null)
			((ServerLevel) player.level()).sendParticles(owner.element.puff, player.getX(), player.getY() + stage, player.getZ(), 60 + stage * 30,
					stage * 0.7, stage, stage * 0.7, 0.05);
	}

	// ------------------------------------------------------------------ every tick
	@SubscribeEvent
	public static void tick(PlayerTickEvent.Post event) {
		if (!(event.getEntity() instanceof ServerPlayer player))
			return;
		PlayerVariables v = NarutoShippudenModVariables.get(player);
		int stage = (int) v.mangekyousharingansusanostage;
		if (player.getPersistentData().getIntOr("SusanooApplied", 0) != stage)
			apply(player, stage);
		if (player.getPersistentData().getBooleanOr("SusanooLanding", false)) {
			player.fallDistance = 0;
			if (player.onGround() || player.isInWater())
				player.getPersistentData().putBoolean("SusanooLanding", false);
		}
		if (stage <= 0)
			return;
		if (!v.MangekyouSharinganActivate || Owner.of(v) == null) {
			collapse(player, "Your Susanoo fades with your Mangekyou");
			return;
		}
		if (player.tickCount % 20 == 0 && !player.isCreative()) {
			if (v.ChakraAmount < DRAIN[stage]) {
				collapse(player, "Your chakra can't hold the Susanoo any longer");
				return;
			}
			NarutoShippudenModVariables.ifPresent(player, vars -> {
				vars.ChakraAmount -= DRAIN[stage];
				vars.syncPlayerVariables(player);
			});
		}
		if (stage >= 3 && player.isOnFire())
			player.clearFire();
		if (stage == MAX)
			player.fallDistance = 0;
	}

	/** The stage's hold on the body: speed, step, knockback, falls and, at the Complete stage, flight. */
	private static void apply(ServerPlayer player, int stage) {
		player.getPersistentData().putInt("SusanooApplied", stage);
		modifier(player, Attributes.MOVEMENT_SPEED, SPEED_ID, SPEED[stage], AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL);
		modifier(player, Attributes.STEP_HEIGHT, STEP_ID, STEP[stage], AttributeModifier.Operation.ADD_VALUE);
		modifier(player, Attributes.KNOCKBACK_RESISTANCE, KNOCKBACK_ID, stage >= 2 ? 1 : stage == 1 ? 0.5 : 0, AttributeModifier.Operation.ADD_VALUE);
		modifier(player, Attributes.SAFE_FALL_DISTANCE, FALL_ID, stage >= 3 ? 1000 : 0, AttributeModifier.Operation.ADD_VALUE);
		boolean flight = stage >= 5;
		boolean granted = player.getPersistentData().getBooleanOr("SusanooFlight", false);
		if (flight && !granted && !player.getAbilities().mayfly) {
			player.getAbilities().mayfly = true;
			player.getPersistentData().putBoolean("SusanooFlight", true);
			player.onUpdateAbilities();
		} else if (!flight && granted) {
			player.getPersistentData().putBoolean("SusanooFlight", false);
			if (!player.isCreative() && !player.isSpectator()) {
				// whoever was up in it comes down without a scratch
				if (!player.onGround())
					player.getPersistentData().putBoolean("SusanooLanding", true);
				player.getAbilities().mayfly = false;
				player.getAbilities().flying = false;
				player.onUpdateAbilities();
			}
		}
	}

	private static void modifier(LivingEntity entity, Holder<Attribute> attribute, Identifier id, double amount, AttributeModifier.Operation operation) {
		AttributeInstance instance = entity.getAttribute(attribute);
		if (instance == null)
			return;
		if (amount == 0)
			instance.removeModifier(id);
		else
			instance.addOrUpdateTransientModifier(new AttributeModifier(id, amount, operation));
	}

	// ------------------------------------------------------------------ the guard
	@SubscribeEvent
	public static void guard(LivingIncomingDamageEvent event) {
		if (!(event.getEntity() instanceof ServerPlayer player))
			return;
		int stage = stage(player);
		DamageSource source = event.getSource();
		if (stage <= 0 || source.is(DamageTypeTags.BYPASSES_INVULNERABILITY) || source.is(DamageTypeTags.BYPASSES_EFFECTS))
			return;
		Owner owner = Owner.of(NarutoShippudenModVariables.get(player));
		ServerLevel level = (ServerLevel) player.level();
		Vec3 from = source.getSourcePosition() != null ? source.getSourcePosition() : player.position().add(player.getLookAngle());
		Vec3 at = player.position().add(0, 1, 0).add(from.subtract(player.position()).multiply(1, 0, 1).normalize().scale(1 + stage * 0.6));
		// arrows, thrown weapons, jutsu: they stop against the Susanoo
		if (source.getDirectEntity() instanceof Projectile projectile && projectile.getOwner() != player) {
			event.setCanceled(true);
			projectile.discard();
			level.sendParticles(ParticleTypes.CRIT, at.x, at.y, at.z, 10, 0.2, 0.2, 0.2, 0.3);
			sound(player, SoundEvents.SHIELD_BLOCK.value(), 1, 0.6F);
			return;
		}
		if (stage >= 3 && source.is(DamageTypeTags.IS_FIRE)) {
			event.setCanceled(true);
			return;
		}
		float held = event.getAmount() * (1 - TAKEN[stage]);
		event.setAmount(event.getAmount() * TAKEN[stage]);
		if (!player.isCreative())
			NarutoShippudenModVariables.ifPresent(player, vars -> {
				vars.ChakraAmount = Math.max(0, vars.ChakraAmount - held * 1.5);
				vars.syncPlayerVariables(player);
			});
		if (owner != null && held > 0.5F)
			level.sendParticles(owner.element.trail, at.x, at.y, at.z, 8, 0.3, 0.3, 0.3, 0.02);
	}

	// ------------------------------------------------------------------ attacks
	/** The Susanoo's arm swings through whatever is in front (sent when the user attacks). */
	public static void strike(ServerPlayer player) {
		int stage = stage(player);
		if (stage < 2)
			return;
		long now = player.level().getGameTime();
		if (player.getPersistentData().getLongOr("SusanooStrikeReady", 0) > now)
			return;
		player.getPersistentData().putLong("SusanooStrikeReady", now + STRIKE_COOLDOWN[stage]);
		Owner owner = Owner.of(NarutoShippudenModVariables.get(player));
		if (owner == null)
			return;
		ServerLevel level = (ServerLevel) player.level();
		player.swing(InteractionHand.MAIN_HAND, net.minecraft.world.item.component.SwingAnimation.DEFAULT, true);
		Vec3 look = player.getLookAngle();
		Vec3 hit = player.getEyePosition().add(look.scale(REACH[stage] * 0.7));
		for (LivingEntity target : Techniques.cone(player, REACH[stage], 70)) {
			Techniques.damage(player, target, STRIKE[stage], owner.element);
			Vec3 away = target.position().subtract(player.position()).multiply(1, 0, 1).normalize();
			target.push(away.x * (0.6 + stage * 0.25), 0.3 + stage * 0.08, away.z * (0.6 + stage * 0.25));
			target.syncVelocity = true;
		}
		level.sendParticles(ParticleTypes.SWEEP_ATTACK, hit.x, hit.y, hit.z, 1 + stage / 2, stage * 0.4, 0.3, stage * 0.4, 0);
		level.sendParticles(owner.element.trail, hit.x, hit.y, hit.z, 10 + stage * 6, stage * 0.5, 0.5, stage * 0.5, 0.05);
		sound(player, SoundEvents.PLAYER_ATTACK_SWEEP, 1, 0.9F - stage * 0.1F);
		if (stage >= 4)
			sound(player, SoundEvents.WARDEN_ATTACK_IMPACT, 1, 0.8F);
	}

	/** The stage's own weapon, its owner's (sent when the user uses an empty hand). */
	public static void special(ServerPlayer player) {
		int stage = stage(player);
		PlayerVariables v = NarutoShippudenModVariables.get(player);
		Owner owner = Owner.of(v);
		if (stage < 3 || owner == null) {
			if (stage == 2)
				player.sendOverlayMessage(Component.literal("Your Susanoo has no weapon yet"));
			return;
		}
		long now = player.level().getGameTime();
		if (player.getPersistentData().getLongOr("SusanooSpecialReady", 0) > now)
			return;
		Weapon weapon = weapon(owner, stage);
		if (weapon == null) {
			player.sendOverlayMessage(Component.literal("This Susanoo's weapon is still to come"));
			return;
		}
		if (v.ChakraAmount < weapon.chakra && !player.isCreative()) {
			player.sendOverlayMessage(Component.literal(weapon.name + " needs " + (int) weapon.chakra + " chakra"));
			return;
		}
		player.getPersistentData().putLong("SusanooSpecialReady", now + weapon.cooldown);
		if (!player.isCreative())
			NarutoShippudenModVariables.ifPresent(player, vars -> {
				vars.ChakraAmount -= weapon.chakra;
				vars.syncPlayerVariables(player);
			});
		player.sendOverlayMessage(Component.literal(weapon.name));
		weapon.use.accept(player, owner);
	}

	private record Weapon(String name, double chakra, int cooldown, java.util.function.BiConsumer<ServerPlayer, Owner> use) {
	}

	private static @Nullable Weapon weapon(Owner owner, int stage) {
		return switch (owner) {
			case SASUKE -> switch (stage) {
				case 3 -> new Weapon("Susanoo: Arrow", 60, 30, Susanoo::arrow);
				case 4 -> new Weapon("Susanoo: Kagutsuchi no Tsurugi", 120, 60, Susanoo::kagutsuchiSword);
				case 5 -> new Weapon("Indra's Arrow", 400, 200, Susanoo::indrasArrow);
				default -> null;
			};
			default -> null;
		};
	}

	/** Sasuke's Humanoid stage: an arrow of violet flame from the Susanoo's bow, through the first enemies it meets. */
	private static void arrow(ServerPlayer p, Owner owner) {
		p.swing(InteractionHand.OFF_HAND, net.minecraft.world.item.component.SwingAnimation.DEFAULT, true);
		JutsuProjectile arrow = Techniques.shoot(p, owner.element, Shape.ROD, 1.2F, 3.2F, 24);
		arrow.pierce = 2;
		arrow.life = 40;
		arrow.knockback = 1.2F;
		arrow.onImpact = a -> Techniques.burst((ServerLevel) p.level(), a.position(), 2.5F, 8, 0.8F, owner.element, a);
		sound(p, SoundEvents.CROSSBOW_SHOOT, 1.2F, 0.5F);
		sound(p, SoundEvents.WARDEN_SONIC_BOOM, 0.5F, 1.8F);
	}

	/** Sasuke's Armoured stage: the Kagutsuchi sword's sweep, a wide arc of black Amaterasu flame. */
	private static void kagutsuchiSword(ServerPlayer p, Owner owner) {
		ServerLevel level = (ServerLevel) p.level();
		p.swing(InteractionHand.MAIN_HAND, net.minecraft.world.item.component.SwingAnimation.DEFAULT, true);
		for (LivingEntity target : Techniques.cone(p, 11, 100)) {
			Techniques.damage(p, target, 26, Element.AMATERASU);
			target.igniteForSeconds(10);
			Vec3 away = target.position().subtract(p.position()).multiply(1, 0, 1).normalize();
			target.push(away.x * 1.6, 0.5, away.z * 1.6);
			target.syncVelocity = true;
		}
		// the arc of black flame
		for (int i = -10; i <= 10; i++) {
			Vec3 dir = Techniques.turned(p, i * 5, 0).multiply(1, 0, 1).normalize();
			for (double r = 4; r <= 11; r += 1.5) {
				Vec3 at = p.position().add(dir.scale(r)).add(0, 1.2 + (11 - r) * 0.15, 0);
				level.sendParticles(Element.AMATERASU.trail, at.x, at.y, at.z, 2, 0.2, 0.2, 0.2, 0.01);
			}
		}
		level.sendParticles(ParticleTypes.SWEEP_ATTACK, p.getX() + p.getLookAngle().x * 5, p.getY() + 2, p.getZ() + p.getLookAngle().z * 5, 4, 3, 0.5, 3, 0);
		sound(p, SoundEvents.PLAYER_ATTACK_SWEEP, 1.5F, 0.5F);
		sound(p, SoundEvents.BLAZE_SHOOT, 1.2F, 0.6F);
	}

	/** Sasuke's Complete stage: Indra's Arrow, drawn for a second and a half, then loosed; it bursts in a great blast (nothing breaks). */
	private static void indrasArrow(ServerPlayer p, Owner owner) {
		ServerLevel level = (ServerLevel) p.level();
		sound(p, SoundEvents.WARDEN_SONIC_CHARGE, 2, 0.5F);
		Techniques.channel(p, 30, 2, i -> {
			Vec3 at = p.getEyePosition().add(p.getLookAngle().scale(4)).add(0, 1, 0);
			level.sendParticles(owner.element.trail, at.x, at.y, at.z, 12, 0.4 + i * 0.03, 0.4 + i * 0.03, 0.4 + i * 0.03, 0.02);
			level.sendParticles(ParticleTypes.ELECTRIC_SPARK, at.x, at.y, at.z, 4, 0.5, 0.5, 0.5, 0.1);
		});
		Techniques.after(level, 30, () -> {
			if (!p.isAlive() || stage(p) < 5)
				return;
			p.swing(InteractionHand.OFF_HAND, net.minecraft.world.item.component.SwingAnimation.DEFAULT, true);
			JutsuProjectile arrow = Techniques.shoot(p, owner.element, Shape.ROD, 3.5F, 3.6F, 60);
			arrow.pierce = -1;
			arrow.life = 50;
			arrow.knockback = 3;
			arrow.onImpact = a -> {
				Techniques.burst(level, a.position(), 9, 40, 3, owner.element, a);
				level.sendParticles(ParticleTypes.EXPLOSION_EMITTER, a.getX(), a.getY(), a.getZ(), 1, 0, 0, 0, 0);
				level.sendParticles(owner.element.puff, a.getX(), a.getY(), a.getZ(), 120, 4, 3, 4, 0.1);
			};
			sound(p, SoundEvents.WARDEN_SONIC_BOOM, 2, 0.6F);
			sound(p, SoundEvents.LIGHTNING_BOLT_THUNDER, 1.5F, 1.2F);
		});
	}

	private static void sound(ServerPlayer p, SoundEvent sound, float volume, float pitch) {
		p.level().playSound(null, p.getX(), p.getY(), p.getZ(), sound, SoundSource.PLAYERS, volume, pitch);
	}

	// ------------------------------------------------------------------ old saves
	/**
	 * The Humanoid stage came in between the Skeleton and the Armoured: a save from before has its bought Armoured and Complete
	 * stages moved up one (bought 3 = Armoured is now 4), once.
	 */
	@SubscribeEvent
	public static void login(PlayerEvent.PlayerLoggedInEvent event) {
		if (!(event.getEntity() instanceof ServerPlayer player) || player.getPersistentData().getBooleanOr("SusanooHumanoid", false))
			return;
		player.getPersistentData().putBoolean("SusanooHumanoid", true);
		NarutoShippudenModVariables.ifPresent(player, v -> {
			v.mangekyousharingansasukesusanolearn = up(v.mangekyousharingansasukesusanolearn);
			v.mangekyousharingansasukesusanorelease = up(v.mangekyousharingansasukesusanorelease);
			v.mangekyoushrainganitachisusanolearn = up(v.mangekyoushrainganitachisusanolearn);
			v.mangekyoushrainganitachisusanorelease = up(v.mangekyoushrainganitachisusanorelease);
			v.mangekyousharinganshisuisusanolearn = up(v.mangekyousharinganshisuisusanolearn);
			v.mangekyousharinganshisuisusanorelease = up(v.mangekyousharinganshisuisusanorelease);
			v.mangekyousharinganmadarasusanolearn = up(v.mangekyousharinganmadarasusanolearn);
			v.mangekyousharinganmadarasusanorelease = up(v.mangekyousharinganmadarasusanorelease);
			v.mangekyousharinganobitosusanolearn = up(v.mangekyousharinganobitosusanolearn);
			v.mangekyousharinganobitosusanorelease = up(v.mangekyousharinganobitosusanorelease);
			v.mangekyousharingansusanostage = 0;
			v.syncPlayerVariables(player);
		});
	}

	private static double up(double bought) {
		return bought >= 3 ? bought + 1 : bought;
	}
}
