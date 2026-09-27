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
		FuramingoganParticleParticle.register();
		GreenSteamParticle.register();
		KamuiParticleParticle.register();
		LightningParticle.register();
		RedSteamParticle.register();
		SmokeParticle.register();
		StormParticle.register();
		TailedBeastBombParticleBlueParticle.register();
		TailedBeastBombParticleRedParticle.register();
		VolticParticleParticle.register();
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

	public static class FuramingoganParticleParticle {
		public static SimpleParticleType particle;

		static void register() {
			Registration.add(Registries.PARTICLE_TYPE, "furamingogan_particle", () -> new SimpleParticleType(false), h -> particle = (SimpleParticleType) h.value());
		}
	}

	public static class GreenSteamParticle {
		public static SimpleParticleType particle;

		static void register() {
			Registration.add(Registries.PARTICLE_TYPE, "green_steam", () -> new SimpleParticleType(false), h -> particle = (SimpleParticleType) h.value());
		}
	}

	public static class KamuiParticleParticle {
		public static SimpleParticleType particle;

		static void register() {
			Registration.add(Registries.PARTICLE_TYPE, "kamui_particle", () -> new SimpleParticleType(false), h -> particle = (SimpleParticleType) h.value());
		}
	}

	public static class LightningParticle {
		public static SimpleParticleType particle;

		static void register() {
			Registration.add(Registries.PARTICLE_TYPE, "lightning", () -> new SimpleParticleType(false), h -> particle = (SimpleParticleType) h.value());
		}
	}

	public static class RedSteamParticle {
		public static SimpleParticleType particle;

		static void register() {
			Registration.add(Registries.PARTICLE_TYPE, "red_steam", () -> new SimpleParticleType(false), h -> particle = (SimpleParticleType) h.value());
		}
	}

	public static class SmokeParticle {
		public static SimpleParticleType particle;

		static void register() {
			Registration.add(Registries.PARTICLE_TYPE, "smoke", () -> new SimpleParticleType(false), h -> particle = (SimpleParticleType) h.value());
		}
	}

	public static class StormParticle {
		public static SimpleParticleType particle;

		static void register() {
			Registration.add(Registries.PARTICLE_TYPE, "storm", () -> new SimpleParticleType(false), h -> particle = (SimpleParticleType) h.value());
		}
	}

	public static class TailedBeastBombParticleBlueParticle {
		public static SimpleParticleType particle;

		static void register() {
			Registration.add(Registries.PARTICLE_TYPE, "tailed_beast_bomb_particle_blue", () -> new SimpleParticleType(false), h -> particle = (SimpleParticleType) h.value());
		}
	}

	public static class TailedBeastBombParticleRedParticle {
		public static SimpleParticleType particle;

		static void register() {
			Registration.add(Registries.PARTICLE_TYPE, "tailed_beast_bomb_particle_red", () -> new SimpleParticleType(false), h -> particle = (SimpleParticleType) h.value());
		}
	}

	public static class VolticParticleParticle {
		public static SimpleParticleType particle;

		static void register() {
			Registration.add(Registries.PARTICLE_TYPE, "voltic_particle", () -> new SimpleParticleType(false), h -> particle = (SimpleParticleType) h.value());
		}
	}
}
