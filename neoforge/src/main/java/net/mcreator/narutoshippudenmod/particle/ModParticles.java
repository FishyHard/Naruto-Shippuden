package net.mcreator.narutoshippudenmod.particle;

import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.mcreator.narutoshippudenmod.compat.Registration;

public final class ModParticles {
	private ModParticles() {
	}

	public static void register() {
		AmaterasuFireParticle.register();
		AshParticle.register();
		BlueSteamParticle.register();
		ChakraParticle.register();
		FlameParticle.register();
		GreenSteamParticle.register();
		RedSteamParticle.register();
	}

	public static class AmaterasuFireParticle {
		public static SimpleParticleType particle;

		static void register() {
			Registration.add(Registries.PARTICLE_TYPE, "amaterasu_fire", () -> new SimpleParticleType(false), h -> particle = (SimpleParticleType) h.value());
		}
	}

	public static class AshParticle {
		public static SimpleParticleType particle;

		static void register() {
			Registration.add(Registries.PARTICLE_TYPE, "ash", () -> new SimpleParticleType(false), h -> particle = (SimpleParticleType) h.value());
		}
	}

	public static class BlueSteamParticle {
		public static SimpleParticleType particle;

		static void register() {
			Registration.add(Registries.PARTICLE_TYPE, "blue_steam", () -> new SimpleParticleType(false), h -> particle = (SimpleParticleType) h.value());
		}
	}

	public static class ChakraParticle {
		public static SimpleParticleType particle;

		static void register() {
			Registration.add(Registries.PARTICLE_TYPE, "chakra", () -> new SimpleParticleType(false), h -> particle = (SimpleParticleType) h.value());
		}
	}

	public static class FlameParticle {
		public static SimpleParticleType particle;

		static void register() {
			Registration.add(Registries.PARTICLE_TYPE, "flame", () -> new SimpleParticleType(false), h -> particle = (SimpleParticleType) h.value());
		}
	}

	public static class GreenSteamParticle {
		public static SimpleParticleType particle;

		static void register() {
			Registration.add(Registries.PARTICLE_TYPE, "green_steam", () -> new SimpleParticleType(false), h -> particle = (SimpleParticleType) h.value());
		}
	}

	public static class RedSteamParticle {
		public static SimpleParticleType particle;

		static void register() {
			Registration.add(Registries.PARTICLE_TYPE, "red_steam", () -> new SimpleParticleType(false), h -> particle = (SimpleParticleType) h.value());
		}
	}

}
