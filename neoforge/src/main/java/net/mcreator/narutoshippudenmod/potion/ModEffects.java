package net.mcreator.narutoshippudenmod.potion;

import net.minecraft.core.registries.Registries;
import net.mcreator.narutoshippudenmod.compat.Registration;
import net.neoforged.fml.common.EventBusSubscriber;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;
import net.mcreator.narutoshippudenmod.procedures.ClanProcedures.DrowningEffectExpiresProcedure;
import net.mcreator.narutoshippudenmod.procedures.ClanProcedures.DrowningOnEffectActiveTickProcedure;
import net.mcreator.narutoshippudenmod.procedures.ClanProcedures.GatesBlueOnEffectActiveTickProcedure;
import net.mcreator.narutoshippudenmod.procedures.ClanProcedures.GatesGreen2EffectExpiresProcedure;
import net.mcreator.narutoshippudenmod.procedures.ClanProcedures.GatesGreen3EffectExpiresProcedure;
import net.mcreator.narutoshippudenmod.procedures.ClanProcedures.GatesGreen4EffectExpiresProcedure;
import net.mcreator.narutoshippudenmod.procedures.ClanProcedures.GatesGreen5EffectExpiresProcedure;
import net.mcreator.narutoshippudenmod.procedures.ClanProcedures.GatesGreen6EffectExpiresProcedure;
import net.mcreator.narutoshippudenmod.procedures.ClanProcedures.GatesGreenOnEffectActiveTickProcedure;
import net.mcreator.narutoshippudenmod.procedures.ClanProcedures.GatesRedEffectExpiresProcedure;
import net.mcreator.narutoshippudenmod.procedures.ClanProcedures.GatesRedOnEffectActiveTickProcedure;
import net.mcreator.narutoshippudenmod.procedures.ClanProcedures.HyugaEffectExpiresProcedure;
import net.mcreator.narutoshippudenmod.procedures.ClanProcedures.InuzukaAkamaruEffectExpiresProcedure;
import net.mcreator.narutoshippudenmod.procedures.EntityProcedures.DespawnEffectExpiresProcedure;
import net.mcreator.narutoshippudenmod.procedures.EntityProcedures.DespawnEntityProcedure;
import net.mcreator.narutoshippudenmod.procedures.KekkeiGenkaiProcedures.IceMirrorEffectEffectExpiresProcedure;
import net.mcreator.narutoshippudenmod.procedures.KekkeiGenkaiProcedures.IceMirrorEffectOnEffectActiveTickProcedure;
import net.mcreator.narutoshippudenmod.procedures.KekkeiGenkaiProcedures.TreeBindFlourishingBurialEffectExpiresProcedure;
import net.mcreator.narutoshippudenmod.procedures.KekkeiGenkaiProcedures.TreeBindFlourishingBurialEffectStartedappliedProcedure;
import net.mcreator.narutoshippudenmod.procedures.KekkeiGenkaiProcedures.TreeBindFlourishingBurialOnEffectActiveTickProcedure;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.level.Level;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.minecraft.core.Holder;
import net.minecraft.server.level.ServerLevel;
import net.neoforged.neoforge.event.entity.living.MobEffectEvent;

public final class ModEffects {
	private ModEffects() {
	}

	public static void register() {

		CoercionSharinganEffectPotionEffect.register();

		DespawnPotionEffect.register();

		DrowningPotionEffect.register();

		GatesBluePotionEffect.register();

		GatesGreen2PotionEffect.register();

		GatesGreen3PotionEffect.register();

		GatesGreen4PotionEffect.register();

		GatesGreen5PotionEffect.register();

		GatesGreen6PotionEffect.register();

		GatesGreenPotionEffect.register();

		GatesRedPotionEffect.register();

		HyugaPotionEffect.register();

		IceMirrorEffectPotionEffect.register();

		InuzukaAkamaruPotionEffect.register();

		TreeBindFlourishingBurialPotionEffect.register();

	}

	private static void onEnd(MobEffectInstance instance, LivingEntity entity) {

		if (instance == null)

			return;

		if (instance.getEffect() == DespawnPotionEffect.potion)
			DespawnPotionEffect.onEnd(entity);

		if (instance.getEffect() == DrowningPotionEffect.potion)
			DrowningPotionEffect.onEnd(entity);

		if (instance.getEffect() == GatesBluePotionEffect.potion)
			GatesBluePotionEffect.onEnd(entity);

		if (instance.getEffect() == GatesGreen2PotionEffect.potion)
			GatesGreen2PotionEffect.onEnd(entity);

		if (instance.getEffect() == GatesGreen3PotionEffect.potion)
			GatesGreen3PotionEffect.onEnd(entity);

		if (instance.getEffect() == GatesGreen4PotionEffect.potion)
			GatesGreen4PotionEffect.onEnd(entity);

		if (instance.getEffect() == GatesGreen5PotionEffect.potion)
			GatesGreen5PotionEffect.onEnd(entity);

		if (instance.getEffect() == GatesGreen6PotionEffect.potion)
			GatesGreen6PotionEffect.onEnd(entity);

		if (instance.getEffect() == GatesGreenPotionEffect.potion)
			GatesGreenPotionEffect.onEnd(entity);

		if (instance.getEffect() == GatesRedPotionEffect.potion)
			GatesRedPotionEffect.onEnd(entity);

		if (instance.getEffect() == HyugaPotionEffect.potion)
			HyugaPotionEffect.onEnd(entity);

		if (instance.getEffect() == IceMirrorEffectPotionEffect.potion)
			IceMirrorEffectPotionEffect.onEnd(entity);

		if (instance.getEffect() == InuzukaAkamaruPotionEffect.potion)
			InuzukaAkamaruPotionEffect.onEnd(entity);

		if (instance.getEffect() == TreeBindFlourishingBurialPotionEffect.potion)
			TreeBindFlourishingBurialPotionEffect.onEnd(entity);

	}

	@EventBusSubscriber(modid = "naruto_shippuden")
	public static class EndEvents {
		@SubscribeEvent
		public static void onExpired(MobEffectEvent.Expired event) {
			onEnd(event.getEffectInstance(), event.getEntity());
		}

		@SubscribeEvent
		public static void onRemoved(MobEffectEvent.Remove event) {
			onEnd(event.getEffectInstance(), event.getEntity());
		}
	}

	public static class CoercionSharinganEffectPotionEffect {
		public static Holder<MobEffect> potion;
		public static final boolean HIDDEN = true;

		static void register() {
			Registration.add(Registries.MOB_EFFECT, "coercion_sharingan_effect", EffectCustom::new, h -> potion = h);
		}

		public static class EffectCustom extends MobEffect {
			public EffectCustom() {
				super(MobEffectCategory.HARMFUL, -1);
			}

			@Override
			public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {

				return true;
			}
		}
	}

	public static class DespawnPotionEffect {
		public static Holder<MobEffect> potion;
		public static final boolean HIDDEN = true;

		static void register() {
			Registration.add(Registries.MOB_EFFECT, "despawn", EffectCustom::new, h -> potion = h);
		}

		public static class EffectCustom extends MobEffect {
			public EffectCustom() {
				super(MobEffectCategory.NEUTRAL, -1);
			}

			@Override
			public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {

				return true;
			}
		}

		/** Runs when the effect ends (expired or removed); was removeAttributeModifiers in 1.16. */
		static void onEnd(LivingEntity entity) {

				Level world = entity.level();
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();

				DespawnEntityProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
		}
	}

	public static class DrowningPotionEffect {
		public static Holder<MobEffect> potion;
		public static final boolean HIDDEN = true;

		static void register() {
			Registration.add(Registries.MOB_EFFECT, "drowning", EffectCustom::new, h -> potion = h);
		}

		public static class EffectCustom extends MobEffect {
			public EffectCustom() {
				super(MobEffectCategory.NEUTRAL, -1);
			}

			@Override
			public boolean applyEffectTick(ServerLevel serverLevel, LivingEntity entity, int amplifier) {

				Level world = entity.level();
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();

				DrowningOnEffectActiveTickProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return true;
			}

			@Override
			public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {

				return true;
			}
		}

		/** Runs when the effect ends (expired or removed); was removeAttributeModifiers in 1.16. */
		static void onEnd(LivingEntity entity) {

				Level world = entity.level();
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();

				DrowningEffectExpiresProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
		}
	}

	public static class GatesBluePotionEffect {
		public static Holder<MobEffect> potion;
		public static final boolean HIDDEN = true;

		static void register() {
			Registration.add(Registries.MOB_EFFECT, "gates_blue", EffectCustom::new, h -> potion = h);
		}

		public static class EffectCustom extends MobEffect {
			public EffectCustom() {
				super(MobEffectCategory.NEUTRAL, -1);
			}

			@Override
			public boolean applyEffectTick(ServerLevel serverLevel, LivingEntity entity, int amplifier) {

				Level world = entity.level();
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();

				GatesBlueOnEffectActiveTickProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return true;
			}

			@Override
			public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {

				return true;
			}
		}

		/** Runs when the effect ends (expired or removed); was removeAttributeModifiers in 1.16. */
		static void onEnd(LivingEntity entity) {

				Level world = entity.level();
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();

				DespawnEffectExpiresProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
		}
	}

	public static class GatesGreen2PotionEffect {
		public static Holder<MobEffect> potion;
		public static final boolean HIDDEN = true;

		static void register() {
			Registration.add(Registries.MOB_EFFECT, "gates_green_2", EffectCustom::new, h -> potion = h);
		}

		public static class EffectCustom extends MobEffect {
			public EffectCustom() {
				super(MobEffectCategory.NEUTRAL, -1);
			}

			@Override
			public boolean applyEffectTick(ServerLevel serverLevel, LivingEntity entity, int amplifier) {

				Level world = entity.level();
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();

				GatesGreenOnEffectActiveTickProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return true;
			}

			@Override
			public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {

				return true;
			}
		}

		/** Runs when the effect ends (expired or removed); was removeAttributeModifiers in 1.16. */
		static void onEnd(LivingEntity entity) {

				Level world = entity.level();
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();

				GatesGreen2EffectExpiresProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
		}
	}

	public static class GatesGreen3PotionEffect {
		public static Holder<MobEffect> potion;
		public static final boolean HIDDEN = true;

		static void register() {
			Registration.add(Registries.MOB_EFFECT, "gates_green_3", EffectCustom::new, h -> potion = h);
		}

		public static class EffectCustom extends MobEffect {
			public EffectCustom() {
				super(MobEffectCategory.NEUTRAL, -1);
			}

			@Override
			public boolean applyEffectTick(ServerLevel serverLevel, LivingEntity entity, int amplifier) {

				Level world = entity.level();
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();

				GatesGreenOnEffectActiveTickProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return true;
			}

			@Override
			public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {

				return true;
			}
		}

		/** Runs when the effect ends (expired or removed); was removeAttributeModifiers in 1.16. */
		static void onEnd(LivingEntity entity) {

				Level world = entity.level();
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();

				GatesGreen3EffectExpiresProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
		}
	}

	public static class GatesGreen4PotionEffect {
		public static Holder<MobEffect> potion;
		public static final boolean HIDDEN = true;

		static void register() {
			Registration.add(Registries.MOB_EFFECT, "gates_green_4", EffectCustom::new, h -> potion = h);
		}

		public static class EffectCustom extends MobEffect {
			public EffectCustom() {
				super(MobEffectCategory.NEUTRAL, -1);
			}

			@Override
			public boolean applyEffectTick(ServerLevel serverLevel, LivingEntity entity, int amplifier) {

				Level world = entity.level();
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();

				GatesGreenOnEffectActiveTickProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return true;
			}

			@Override
			public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {

				return true;
			}
		}

		/** Runs when the effect ends (expired or removed); was removeAttributeModifiers in 1.16. */
		static void onEnd(LivingEntity entity) {

				Level world = entity.level();
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();

				GatesGreen4EffectExpiresProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
		}
	}

	public static class GatesGreen5PotionEffect {
		public static Holder<MobEffect> potion;
		public static final boolean HIDDEN = true;

		static void register() {
			Registration.add(Registries.MOB_EFFECT, "gates_green_5", EffectCustom::new, h -> potion = h);
		}

		public static class EffectCustom extends MobEffect {
			public EffectCustom() {
				super(MobEffectCategory.NEUTRAL, -1);
			}

			@Override
			public boolean applyEffectTick(ServerLevel serverLevel, LivingEntity entity, int amplifier) {

				Level world = entity.level();
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();

				GatesGreenOnEffectActiveTickProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return true;
			}

			@Override
			public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {

				return true;
			}
		}

		/** Runs when the effect ends (expired or removed); was removeAttributeModifiers in 1.16. */
		static void onEnd(LivingEntity entity) {

				Level world = entity.level();
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();

				GatesGreen5EffectExpiresProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
		}
	}

	public static class GatesGreen6PotionEffect {
		public static Holder<MobEffect> potion;
		public static final boolean HIDDEN = true;

		static void register() {
			Registration.add(Registries.MOB_EFFECT, "gates_green_6", EffectCustom::new, h -> potion = h);
		}

		public static class EffectCustom extends MobEffect {
			public EffectCustom() {
				super(MobEffectCategory.NEUTRAL, -1);
			}

			@Override
			public boolean applyEffectTick(ServerLevel serverLevel, LivingEntity entity, int amplifier) {

				Level world = entity.level();
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();

				GatesGreenOnEffectActiveTickProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return true;
			}

			@Override
			public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {

				return true;
			}
		}

		/** Runs when the effect ends (expired or removed); was removeAttributeModifiers in 1.16. */
		static void onEnd(LivingEntity entity) {

				Level world = entity.level();
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();

				GatesGreen6EffectExpiresProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
		}
	}

	public static class GatesGreenPotionEffect {
		public static Holder<MobEffect> potion;
		public static final boolean HIDDEN = true;

		static void register() {
			Registration.add(Registries.MOB_EFFECT, "gates_green", EffectCustom::new, h -> potion = h);
		}

		public static class EffectCustom extends MobEffect {
			public EffectCustom() {
				super(MobEffectCategory.NEUTRAL, -1);
			}

			@Override
			public boolean applyEffectTick(ServerLevel serverLevel, LivingEntity entity, int amplifier) {

				Level world = entity.level();
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();

				GatesGreenOnEffectActiveTickProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return true;
			}

			@Override
			public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {

				return true;
			}
		}

		/** Runs when the effect ends (expired or removed); was removeAttributeModifiers in 1.16. */
		static void onEnd(LivingEntity entity) {

				Level world = entity.level();
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();

				DespawnEffectExpiresProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
		}
	}

	public static class GatesRedPotionEffect {
		public static Holder<MobEffect> potion;
		public static final boolean HIDDEN = true;

		static void register() {
			Registration.add(Registries.MOB_EFFECT, "gates_red", EffectCustom::new, h -> potion = h);
		}

		public static class EffectCustom extends MobEffect {
			public EffectCustom() {
				super(MobEffectCategory.NEUTRAL, -1);
			}

			@Override
			public boolean applyEffectTick(ServerLevel serverLevel, LivingEntity entity, int amplifier) {

				Level world = entity.level();
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();

				GatesRedOnEffectActiveTickProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return true;
			}

			@Override
			public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {

				return true;
			}
		}

		/** Runs when the effect ends (expired or removed); was removeAttributeModifiers in 1.16. */
		static void onEnd(LivingEntity entity) {

				Level world = entity.level();
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();

				GatesRedEffectExpiresProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
		}
	}

	public static class HyugaPotionEffect {
		public static Holder<MobEffect> potion;
		public static final boolean HIDDEN = true;

		static void register() {
			Registration.add(Registries.MOB_EFFECT, "hyuga", EffectCustom::new, h -> potion = h);
		}

		public static class EffectCustom extends MobEffect {
			public EffectCustom() {
				super(MobEffectCategory.NEUTRAL, -1);
			}

			@Override
			public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {

				return true;
			}
		}

		/** Runs when the effect ends (expired or removed); was removeAttributeModifiers in 1.16. */
		static void onEnd(LivingEntity entity) {

				Level world = entity.level();
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();

				HyugaEffectExpiresProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
		}
	}

	public static class IceMirrorEffectPotionEffect {
		public static Holder<MobEffect> potion;
		public static final boolean HIDDEN = true;

		static void register() {
			Registration.add(Registries.MOB_EFFECT, "ice_mirror_effect", EffectCustom::new, h -> potion = h);
		}

		public static class EffectCustom extends MobEffect {
			public EffectCustom() {
				super(MobEffectCategory.NEUTRAL, -1);
			}

			@Override
			public boolean applyEffectTick(ServerLevel serverLevel, LivingEntity entity, int amplifier) {

				Level world = entity.level();
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();

				IceMirrorEffectOnEffectActiveTickProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return true;
			}

			@Override
			public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {

				return true;
			}
		}

		/** Runs when the effect ends (expired or removed); was removeAttributeModifiers in 1.16. */
		static void onEnd(LivingEntity entity) {

				Level world = entity.level();
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();

				IceMirrorEffectEffectExpiresProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
		}
	}

	public static class InuzukaAkamaruPotionEffect {
		public static Holder<MobEffect> potion;
		public static final boolean HIDDEN = true;

		static void register() {
			Registration.add(Registries.MOB_EFFECT, "inuzuka_akamaru", EffectCustom::new, h -> potion = h);
		}

		public static class EffectCustom extends MobEffect {
			public EffectCustom() {
				super(MobEffectCategory.NEUTRAL, -1);
			}

			@Override
			public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {

				return true;
			}
		}

		/** Runs when the effect ends (expired or removed); was removeAttributeModifiers in 1.16. */
		static void onEnd(LivingEntity entity) {

				Level world = entity.level();
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();

				InuzukaAkamaruEffectExpiresProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
		}
	}

	public static class TreeBindFlourishingBurialPotionEffect {
		public static Holder<MobEffect> potion;
		public static final boolean HIDDEN = true;

		static void register() {
			Registration.add(Registries.MOB_EFFECT, "tree_bind_flourishing_burial", EffectCustom::new, h -> potion = h);
		}

		public static class EffectCustom extends MobEffect {
			public EffectCustom() {
				super(MobEffectCategory.NEUTRAL, -1);
			}

			@Override
			public boolean applyEffectTick(ServerLevel serverLevel, LivingEntity entity, int amplifier) {

				Level world = entity.level();
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();

				TreeBindFlourishingBurialOnEffectActiveTickProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z), new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return true;
			}

			@Override
			public void onEffectStarted(LivingEntity entity, int amplifier) {

				Level world = entity.level();
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();

				TreeBindFlourishingBurialEffectStartedappliedProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z), new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}

			@Override
			public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {

				return true;
			}
		}

		/** Runs when the effect ends (expired or removed); was removeAttributeModifiers in 1.16. */
		static void onEnd(LivingEntity entity) {

				Level world = entity.level();
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();

				TreeBindFlourishingBurialEffectExpiresProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
		}
	}
}
