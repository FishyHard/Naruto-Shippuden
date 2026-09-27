package net.mcreator.narutoshippudenmod.potion;

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
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierManager;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.EffectType;
import net.minecraft.world.World;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

public final class ModEffects {
	private ModEffects() {
	}

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class CoercionSharinganEffectPotionEffect {
		@ObjectHolder("naruto_shippuden:coercion_sharingan_effect")
		public static final Effect potion = null;

		@SubscribeEvent
		public static void registerEffect(RegistryEvent.Register<Effect> event) {
			event.getRegistry().register(new EffectCustom());
		}

		public static class EffectCustom extends Effect {
			public EffectCustom() {
				super(EffectType.HARMFUL, -1);
				setRegistryName("coercion_sharingan_effect");
			}

			@Override
			public String getName() {
				return "effect.coercion_sharingan_effect";
			}

			@Override
			public boolean isBeneficial() {
				return false;
			}

			@Override
			public boolean isInstant() {
				return false;
			}

			@Override
			public boolean shouldRenderInvText(EffectInstance effect) {
				return false;
			}

			@Override
			public boolean shouldRender(EffectInstance effect) {
				return false;
			}

			@Override
			public boolean shouldRenderHUD(EffectInstance effect) {
				return false;
			}

			@Override
			public boolean isReady(int duration, int amplifier) {
				return true;
			}
		}
	}

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class DespawnPotionEffect {
		@ObjectHolder("naruto_shippuden:despawn")
		public static final Effect potion = null;

		@SubscribeEvent
		public static void registerEffect(RegistryEvent.Register<Effect> event) {
			event.getRegistry().register(new EffectCustom());
		}

		public static class EffectCustom extends Effect {
			public EffectCustom() {
				super(EffectType.NEUTRAL, -1);
				setRegistryName("despawn");
			}

			@Override
			public String getName() {
				return "effect.despawn";
			}

			@Override
			public boolean isBeneficial() {
				return false;
			}

			@Override
			public boolean isInstant() {
				return false;
			}

			@Override
			public boolean shouldRenderInvText(EffectInstance effect) {
				return false;
			}

			@Override
			public boolean shouldRender(EffectInstance effect) {
				return false;
			}

			@Override
			public boolean shouldRenderHUD(EffectInstance effect) {
				return false;
			}

			@Override
			public void removeAttributesModifiersFromEntity(LivingEntity entity, AttributeModifierManager attributeMapIn, int amplifier) {
				super.removeAttributesModifiersFromEntity(entity, attributeMapIn, amplifier);
				World world = entity.world;
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();

				DespawnEntityProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}

			@Override
			public boolean isReady(int duration, int amplifier) {
				return true;
			}
		}
	}

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class DrowningPotionEffect {
		@ObjectHolder("naruto_shippuden:drowning")
		public static final Effect potion = null;

		@SubscribeEvent
		public static void registerEffect(RegistryEvent.Register<Effect> event) {
			event.getRegistry().register(new EffectCustom());
		}

		public static class EffectCustom extends Effect {
			public EffectCustom() {
				super(EffectType.NEUTRAL, -1);
				setRegistryName("drowning");
			}

			@Override
			public String getName() {
				return "effect.drowning";
			}

			@Override
			public boolean isBeneficial() {
				return false;
			}

			@Override
			public boolean isInstant() {
				return false;
			}

			@Override
			public boolean shouldRenderInvText(EffectInstance effect) {
				return false;
			}

			@Override
			public boolean shouldRender(EffectInstance effect) {
				return false;
			}

			@Override
			public boolean shouldRenderHUD(EffectInstance effect) {
				return false;
			}

			@Override
			public void performEffect(LivingEntity entity, int amplifier) {
				World world = entity.world;
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();

				DrowningOnEffectActiveTickProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}

			@Override
			public void removeAttributesModifiersFromEntity(LivingEntity entity, AttributeModifierManager attributeMapIn, int amplifier) {
				super.removeAttributesModifiersFromEntity(entity, attributeMapIn, amplifier);
				World world = entity.world;
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();

				DrowningEffectExpiresProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}

			@Override
			public boolean isReady(int duration, int amplifier) {
				return true;
			}
		}
	}

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class GatesBluePotionEffect {
		@ObjectHolder("naruto_shippuden:gates_blue")
		public static final Effect potion = null;

		@SubscribeEvent
		public static void registerEffect(RegistryEvent.Register<Effect> event) {
			event.getRegistry().register(new EffectCustom());
		}

		public static class EffectCustom extends Effect {
			public EffectCustom() {
				super(EffectType.NEUTRAL, -1);
				setRegistryName("gates_blue");
			}

			@Override
			public String getName() {
				return "effect.gates_blue";
			}

			@Override
			public boolean isBeneficial() {
				return false;
			}

			@Override
			public boolean isInstant() {
				return false;
			}

			@Override
			public boolean shouldRenderInvText(EffectInstance effect) {
				return false;
			}

			@Override
			public boolean shouldRender(EffectInstance effect) {
				return false;
			}

			@Override
			public boolean shouldRenderHUD(EffectInstance effect) {
				return false;
			}

			@Override
			public void performEffect(LivingEntity entity, int amplifier) {
				World world = entity.world;
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();

				GatesBlueOnEffectActiveTickProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}

			@Override
			public void removeAttributesModifiersFromEntity(LivingEntity entity, AttributeModifierManager attributeMapIn, int amplifier) {
				super.removeAttributesModifiersFromEntity(entity, attributeMapIn, amplifier);
				World world = entity.world;
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();

				DespawnEffectExpiresProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}

			@Override
			public boolean isReady(int duration, int amplifier) {
				return true;
			}
		}
	}

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class GatesGreen2PotionEffect {
		@ObjectHolder("naruto_shippuden:gates_green_2")
		public static final Effect potion = null;

		@SubscribeEvent
		public static void registerEffect(RegistryEvent.Register<Effect> event) {
			event.getRegistry().register(new EffectCustom());
		}

		public static class EffectCustom extends Effect {
			public EffectCustom() {
				super(EffectType.NEUTRAL, -1);
				setRegistryName("gates_green_2");
			}

			@Override
			public String getName() {
				return "effect.gates_green_2";
			}

			@Override
			public boolean isBeneficial() {
				return false;
			}

			@Override
			public boolean isInstant() {
				return false;
			}

			@Override
			public boolean shouldRenderInvText(EffectInstance effect) {
				return false;
			}

			@Override
			public boolean shouldRender(EffectInstance effect) {
				return false;
			}

			@Override
			public boolean shouldRenderHUD(EffectInstance effect) {
				return false;
			}

			@Override
			public void performEffect(LivingEntity entity, int amplifier) {
				World world = entity.world;
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();

				GatesGreenOnEffectActiveTickProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}

			@Override
			public void removeAttributesModifiersFromEntity(LivingEntity entity, AttributeModifierManager attributeMapIn, int amplifier) {
				super.removeAttributesModifiersFromEntity(entity, attributeMapIn, amplifier);
				World world = entity.world;
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();

				GatesGreen2EffectExpiresProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}

			@Override
			public boolean isReady(int duration, int amplifier) {
				return true;
			}
		}
	}

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class GatesGreen3PotionEffect {
		@ObjectHolder("naruto_shippuden:gates_green_3")
		public static final Effect potion = null;

		@SubscribeEvent
		public static void registerEffect(RegistryEvent.Register<Effect> event) {
			event.getRegistry().register(new EffectCustom());
		}

		public static class EffectCustom extends Effect {
			public EffectCustom() {
				super(EffectType.NEUTRAL, -1);
				setRegistryName("gates_green_3");
			}

			@Override
			public String getName() {
				return "effect.gates_green_3";
			}

			@Override
			public boolean isBeneficial() {
				return false;
			}

			@Override
			public boolean isInstant() {
				return false;
			}

			@Override
			public boolean shouldRenderInvText(EffectInstance effect) {
				return false;
			}

			@Override
			public boolean shouldRender(EffectInstance effect) {
				return false;
			}

			@Override
			public boolean shouldRenderHUD(EffectInstance effect) {
				return false;
			}

			@Override
			public void performEffect(LivingEntity entity, int amplifier) {
				World world = entity.world;
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();

				GatesGreenOnEffectActiveTickProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}

			@Override
			public void removeAttributesModifiersFromEntity(LivingEntity entity, AttributeModifierManager attributeMapIn, int amplifier) {
				super.removeAttributesModifiersFromEntity(entity, attributeMapIn, amplifier);
				World world = entity.world;
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();

				GatesGreen3EffectExpiresProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}

			@Override
			public boolean isReady(int duration, int amplifier) {
				return true;
			}
		}
	}

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class GatesGreen4PotionEffect {
		@ObjectHolder("naruto_shippuden:gates_green_4")
		public static final Effect potion = null;

		@SubscribeEvent
		public static void registerEffect(RegistryEvent.Register<Effect> event) {
			event.getRegistry().register(new EffectCustom());
		}

		public static class EffectCustom extends Effect {
			public EffectCustom() {
				super(EffectType.NEUTRAL, -1);
				setRegistryName("gates_green_4");
			}

			@Override
			public String getName() {
				return "effect.gates_green_4";
			}

			@Override
			public boolean isBeneficial() {
				return false;
			}

			@Override
			public boolean isInstant() {
				return false;
			}

			@Override
			public boolean shouldRenderInvText(EffectInstance effect) {
				return false;
			}

			@Override
			public boolean shouldRender(EffectInstance effect) {
				return false;
			}

			@Override
			public boolean shouldRenderHUD(EffectInstance effect) {
				return false;
			}

			@Override
			public void performEffect(LivingEntity entity, int amplifier) {
				World world = entity.world;
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();

				GatesGreenOnEffectActiveTickProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}

			@Override
			public void removeAttributesModifiersFromEntity(LivingEntity entity, AttributeModifierManager attributeMapIn, int amplifier) {
				super.removeAttributesModifiersFromEntity(entity, attributeMapIn, amplifier);
				World world = entity.world;
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();

				GatesGreen4EffectExpiresProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}

			@Override
			public boolean isReady(int duration, int amplifier) {
				return true;
			}
		}
	}

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class GatesGreen5PotionEffect {
		@ObjectHolder("naruto_shippuden:gates_green_5")
		public static final Effect potion = null;

		@SubscribeEvent
		public static void registerEffect(RegistryEvent.Register<Effect> event) {
			event.getRegistry().register(new EffectCustom());
		}

		public static class EffectCustom extends Effect {
			public EffectCustom() {
				super(EffectType.NEUTRAL, -1);
				setRegistryName("gates_green_5");
			}

			@Override
			public String getName() {
				return "effect.gates_green_5";
			}

			@Override
			public boolean isBeneficial() {
				return false;
			}

			@Override
			public boolean isInstant() {
				return false;
			}

			@Override
			public boolean shouldRenderInvText(EffectInstance effect) {
				return false;
			}

			@Override
			public boolean shouldRender(EffectInstance effect) {
				return false;
			}

			@Override
			public boolean shouldRenderHUD(EffectInstance effect) {
				return false;
			}

			@Override
			public void performEffect(LivingEntity entity, int amplifier) {
				World world = entity.world;
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();

				GatesGreenOnEffectActiveTickProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}

			@Override
			public void removeAttributesModifiersFromEntity(LivingEntity entity, AttributeModifierManager attributeMapIn, int amplifier) {
				super.removeAttributesModifiersFromEntity(entity, attributeMapIn, amplifier);
				World world = entity.world;
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();

				GatesGreen5EffectExpiresProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}

			@Override
			public boolean isReady(int duration, int amplifier) {
				return true;
			}
		}
	}

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class GatesGreen6PotionEffect {
		@ObjectHolder("naruto_shippuden:gates_green_6")
		public static final Effect potion = null;

		@SubscribeEvent
		public static void registerEffect(RegistryEvent.Register<Effect> event) {
			event.getRegistry().register(new EffectCustom());
		}

		public static class EffectCustom extends Effect {
			public EffectCustom() {
				super(EffectType.NEUTRAL, -1);
				setRegistryName("gates_green_6");
			}

			@Override
			public String getName() {
				return "effect.gates_green_6";
			}

			@Override
			public boolean isBeneficial() {
				return false;
			}

			@Override
			public boolean isInstant() {
				return false;
			}

			@Override
			public boolean shouldRenderInvText(EffectInstance effect) {
				return false;
			}

			@Override
			public boolean shouldRender(EffectInstance effect) {
				return false;
			}

			@Override
			public boolean shouldRenderHUD(EffectInstance effect) {
				return false;
			}

			@Override
			public void performEffect(LivingEntity entity, int amplifier) {
				World world = entity.world;
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();

				GatesGreenOnEffectActiveTickProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}

			@Override
			public void removeAttributesModifiersFromEntity(LivingEntity entity, AttributeModifierManager attributeMapIn, int amplifier) {
				super.removeAttributesModifiersFromEntity(entity, attributeMapIn, amplifier);
				World world = entity.world;
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();

				GatesGreen6EffectExpiresProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}

			@Override
			public boolean isReady(int duration, int amplifier) {
				return true;
			}
		}
	}

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class GatesGreenPotionEffect {
		@ObjectHolder("naruto_shippuden:gates_green")
		public static final Effect potion = null;

		@SubscribeEvent
		public static void registerEffect(RegistryEvent.Register<Effect> event) {
			event.getRegistry().register(new EffectCustom());
		}

		public static class EffectCustom extends Effect {
			public EffectCustom() {
				super(EffectType.NEUTRAL, -1);
				setRegistryName("gates_green");
			}

			@Override
			public String getName() {
				return "effect.gates_green";
			}

			@Override
			public boolean isBeneficial() {
				return false;
			}

			@Override
			public boolean isInstant() {
				return false;
			}

			@Override
			public boolean shouldRenderInvText(EffectInstance effect) {
				return false;
			}

			@Override
			public boolean shouldRender(EffectInstance effect) {
				return false;
			}

			@Override
			public boolean shouldRenderHUD(EffectInstance effect) {
				return false;
			}

			@Override
			public void performEffect(LivingEntity entity, int amplifier) {
				World world = entity.world;
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();

				GatesGreenOnEffectActiveTickProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}

			@Override
			public void removeAttributesModifiersFromEntity(LivingEntity entity, AttributeModifierManager attributeMapIn, int amplifier) {
				super.removeAttributesModifiersFromEntity(entity, attributeMapIn, amplifier);
				World world = entity.world;
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();

				DespawnEffectExpiresProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}

			@Override
			public boolean isReady(int duration, int amplifier) {
				return true;
			}
		}
	}

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class GatesRedPotionEffect {
		@ObjectHolder("naruto_shippuden:gates_red")
		public static final Effect potion = null;

		@SubscribeEvent
		public static void registerEffect(RegistryEvent.Register<Effect> event) {
			event.getRegistry().register(new EffectCustom());
		}

		public static class EffectCustom extends Effect {
			public EffectCustom() {
				super(EffectType.NEUTRAL, -1);
				setRegistryName("gates_red");
			}

			@Override
			public String getName() {
				return "effect.gates_red";
			}

			@Override
			public boolean isBeneficial() {
				return false;
			}

			@Override
			public boolean isInstant() {
				return false;
			}

			@Override
			public boolean shouldRenderInvText(EffectInstance effect) {
				return false;
			}

			@Override
			public boolean shouldRender(EffectInstance effect) {
				return false;
			}

			@Override
			public boolean shouldRenderHUD(EffectInstance effect) {
				return false;
			}

			@Override
			public void performEffect(LivingEntity entity, int amplifier) {
				World world = entity.world;
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();

				GatesRedOnEffectActiveTickProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}

			@Override
			public void removeAttributesModifiersFromEntity(LivingEntity entity, AttributeModifierManager attributeMapIn, int amplifier) {
				super.removeAttributesModifiersFromEntity(entity, attributeMapIn, amplifier);
				World world = entity.world;
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();

				GatesRedEffectExpiresProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}

			@Override
			public boolean isReady(int duration, int amplifier) {
				return true;
			}
		}
	}

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class HyugaPotionEffect {
		@ObjectHolder("naruto_shippuden:hyuga")
		public static final Effect potion = null;

		@SubscribeEvent
		public static void registerEffect(RegistryEvent.Register<Effect> event) {
			event.getRegistry().register(new EffectCustom());
		}

		public static class EffectCustom extends Effect {
			public EffectCustom() {
				super(EffectType.NEUTRAL, -1);
				setRegistryName("hyuga");
			}

			@Override
			public String getName() {
				return "effect.hyuga";
			}

			@Override
			public boolean isBeneficial() {
				return false;
			}

			@Override
			public boolean isInstant() {
				return false;
			}

			@Override
			public boolean shouldRenderInvText(EffectInstance effect) {
				return false;
			}

			@Override
			public boolean shouldRender(EffectInstance effect) {
				return false;
			}

			@Override
			public boolean shouldRenderHUD(EffectInstance effect) {
				return false;
			}

			@Override
			public void removeAttributesModifiersFromEntity(LivingEntity entity, AttributeModifierManager attributeMapIn, int amplifier) {
				super.removeAttributesModifiersFromEntity(entity, attributeMapIn, amplifier);
				World world = entity.world;
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();

				HyugaEffectExpiresProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}

			@Override
			public boolean isReady(int duration, int amplifier) {
				return true;
			}
		}
	}

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class IceMirrorEffectPotionEffect {
		@ObjectHolder("naruto_shippuden:ice_mirror_effect")
		public static final Effect potion = null;

		@SubscribeEvent
		public static void registerEffect(RegistryEvent.Register<Effect> event) {
			event.getRegistry().register(new EffectCustom());
		}

		public static class EffectCustom extends Effect {
			public EffectCustom() {
				super(EffectType.NEUTRAL, -1);
				setRegistryName("ice_mirror_effect");
			}

			@Override
			public String getName() {
				return "effect.ice_mirror_effect";
			}

			@Override
			public boolean isBeneficial() {
				return false;
			}

			@Override
			public boolean isInstant() {
				return false;
			}

			@Override
			public boolean shouldRenderInvText(EffectInstance effect) {
				return false;
			}

			@Override
			public boolean shouldRender(EffectInstance effect) {
				return false;
			}

			@Override
			public boolean shouldRenderHUD(EffectInstance effect) {
				return false;
			}

			@Override
			public void performEffect(LivingEntity entity, int amplifier) {
				World world = entity.world;
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();

				IceMirrorEffectOnEffectActiveTickProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}

			@Override
			public void removeAttributesModifiersFromEntity(LivingEntity entity, AttributeModifierManager attributeMapIn, int amplifier) {
				super.removeAttributesModifiersFromEntity(entity, attributeMapIn, amplifier);
				World world = entity.world;
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();

				IceMirrorEffectEffectExpiresProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}

			@Override
			public boolean isReady(int duration, int amplifier) {
				return true;
			}
		}
	}

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class InuzukaAkamaruPotionEffect {
		@ObjectHolder("naruto_shippuden:inuzuka_akamaru")
		public static final Effect potion = null;

		@SubscribeEvent
		public static void registerEffect(RegistryEvent.Register<Effect> event) {
			event.getRegistry().register(new EffectCustom());
		}

		public static class EffectCustom extends Effect {
			public EffectCustom() {
				super(EffectType.NEUTRAL, -1);
				setRegistryName("inuzuka_akamaru");
			}

			@Override
			public String getName() {
				return "effect.inuzuka_akamaru";
			}

			@Override
			public boolean isBeneficial() {
				return false;
			}

			@Override
			public boolean isInstant() {
				return false;
			}

			@Override
			public boolean shouldRenderInvText(EffectInstance effect) {
				return false;
			}

			@Override
			public boolean shouldRender(EffectInstance effect) {
				return false;
			}

			@Override
			public boolean shouldRenderHUD(EffectInstance effect) {
				return false;
			}

			@Override
			public void removeAttributesModifiersFromEntity(LivingEntity entity, AttributeModifierManager attributeMapIn, int amplifier) {
				super.removeAttributesModifiersFromEntity(entity, attributeMapIn, amplifier);
				World world = entity.world;
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();

				InuzukaAkamaruEffectExpiresProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}

			@Override
			public boolean isReady(int duration, int amplifier) {
				return true;
			}
		}
	}

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class NuibariStringPotionEffect {
		@ObjectHolder("naruto_shippuden:nuibari_string")
		public static final Effect potion = null;

		@SubscribeEvent
		public static void registerEffect(RegistryEvent.Register<Effect> event) {
			event.getRegistry().register(new EffectCustom());
		}

		public static class EffectCustom extends Effect {
			public EffectCustom() {
				super(EffectType.HARMFUL, -1);
				setRegistryName("nuibari_string");
			}

			@Override
			public String getName() {
				return "effect.nuibari_string";
			}

			@Override
			public boolean isBeneficial() {
				return false;
			}

			@Override
			public boolean isInstant() {
				return false;
			}

			@Override
			public boolean shouldRenderInvText(EffectInstance effect) {
				return false;
			}

			@Override
			public boolean shouldRender(EffectInstance effect) {
				return false;
			}

			@Override
			public boolean shouldRenderHUD(EffectInstance effect) {
				return false;
			}

			@Override
			public boolean isReady(int duration, int amplifier) {
				return true;
			}
		}
	}

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class RidingPotionEffect {
		@ObjectHolder("naruto_shippuden:riding")
		public static final Effect potion = null;

		@SubscribeEvent
		public static void registerEffect(RegistryEvent.Register<Effect> event) {
			event.getRegistry().register(new EffectCustom());
		}

		public static class EffectCustom extends Effect {
			public EffectCustom() {
				super(EffectType.NEUTRAL, -1);
				setRegistryName("riding");
			}

			@Override
			public String getName() {
				return "effect.riding";
			}

			@Override
			public boolean isBeneficial() {
				return false;
			}

			@Override
			public boolean isInstant() {
				return false;
			}

			@Override
			public boolean shouldRenderInvText(EffectInstance effect) {
				return false;
			}

			@Override
			public boolean shouldRender(EffectInstance effect) {
				return false;
			}

			@Override
			public boolean shouldRenderHUD(EffectInstance effect) {
				return false;
			}

			@Override
			public boolean isReady(int duration, int amplifier) {
				return true;
			}
		}
	}

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class TreeBindFlourishingBurialPotionEffect {
		@ObjectHolder("naruto_shippuden:tree_bind_flourishing_burial")
		public static final Effect potion = null;

		@SubscribeEvent
		public static void registerEffect(RegistryEvent.Register<Effect> event) {
			event.getRegistry().register(new EffectCustom());
		}

		public static class EffectCustom extends Effect {
			public EffectCustom() {
				super(EffectType.NEUTRAL, -1);
				setRegistryName("tree_bind_flourishing_burial");
			}

			@Override
			public String getName() {
				return "effect.tree_bind_flourishing_burial";
			}

			@Override
			public boolean isBeneficial() {
				return false;
			}

			@Override
			public boolean isInstant() {
				return false;
			}

			@Override
			public boolean shouldRenderInvText(EffectInstance effect) {
				return false;
			}

			@Override
			public boolean shouldRender(EffectInstance effect) {
				return false;
			}

			@Override
			public boolean shouldRenderHUD(EffectInstance effect) {
				return false;
			}

			@Override
			public void applyAttributesModifiersToEntity(LivingEntity entity, AttributeModifierManager attributeMapIn, int amplifier) {
				World world = entity.world;
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();

				TreeBindFlourishingBurialEffectStartedappliedProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z), new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}

			@Override
			public void performEffect(LivingEntity entity, int amplifier) {
				World world = entity.world;
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();

				TreeBindFlourishingBurialOnEffectActiveTickProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z), new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}

			@Override
			public void removeAttributesModifiersFromEntity(LivingEntity entity, AttributeModifierManager attributeMapIn, int amplifier) {
				super.removeAttributesModifiersFromEntity(entity, attributeMapIn, amplifier);
				World world = entity.world;
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();

				TreeBindFlourishingBurialEffectExpiresProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}

			@Override
			public boolean isReady(int duration, int amplifier) {
				return true;
			}
		}
	}
}
