package net.mcreator.narutoshippudenmod.client;

import net.mcreator.narutoshippudenmod.particle.ModParticles;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.particle.SingleQuadParticle;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.RandomSource;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;

/** Particle behaviour and providers (client only). */
public final class ModParticleProviders {
	private ModParticleProviders() {
	}

	public static void register(RegisterParticleProvidersEvent event) {
		event.registerSpriteSet(ModParticles.AmaterasuFireParticle.particle, AmaterasuFireParticle.CustomParticleFactory::new);
		event.registerSpriteSet(ModParticles.AshParticle.particle, AshParticle.CustomParticleFactory::new);
		event.registerSpriteSet(ModParticles.BlueSteamParticle.particle, BlueSteamParticle.CustomParticleFactory::new);
		event.registerSpriteSet(ModParticles.ChakraParticle.particle, ChakraParticle.CustomParticleFactory::new);
		event.registerSpriteSet(ModParticles.FlameParticle.particle, FlameParticle.CustomParticleFactory::new);
		event.registerSpriteSet(ModParticles.GreenSteamParticle.particle, GreenSteamParticle.CustomParticleFactory::new);
		event.registerSpriteSet(ModParticles.KamuiParticleParticle.particle, KamuiParticleParticle.CustomParticleFactory::new);
		event.registerSpriteSet(ModParticles.LightningParticle.particle, LightningParticle.CustomParticleFactory::new);
		event.registerSpriteSet(ModParticles.RedSteamParticle.particle, RedSteamParticle.CustomParticleFactory::new);
		event.registerSpriteSet(ModParticles.SmokeParticle.particle, SmokeParticle.CustomParticleFactory::new);
		event.registerSpriteSet(ModParticles.StormParticle.particle, StormParticle.CustomParticleFactory::new);
		event.registerSpriteSet(ModParticles.TailedBeastBombParticleBlueParticle.particle, TailedBeastBombParticleBlueParticle.CustomParticleFactory::new);
		event.registerSpriteSet(ModParticles.TailedBeastBombParticleRedParticle.particle, TailedBeastBombParticleRedParticle.CustomParticleFactory::new);
	}

	static class AmaterasuFireParticle {
		static class CustomParticle extends SingleQuadParticle {
			private final SpriteSet spriteSet;

			protected CustomParticle(ClientLevel world, double x, double y, double z, double vx, double vy, double vz, SpriteSet spriteSet) {
				super(world, x, y, z, spriteSet.first());
				this.spriteSet = spriteSet;
				this.setSize((float) 0.2, (float) 0.2);
				this.quadSize *= (float) 1;
				this.lifetime = 60;
				this.gravity = (float) 0;
				this.hasPhysics = false;
				this.xd = vx * 1;
				this.yd = vy * 1;
				this.zd = vz * 1;
				this.setSpriteFromAge(spriteSet);
			}

			@Override
			public SingleQuadParticle.Layer getLayer() {
				return SingleQuadParticle.Layer.TRANSLUCENT;
			}

			@Override
			public void tick() {
				super.tick();
				if (!this.removed) {
					this.setSprite(this.spriteSet.get((this.age / 2) % 32 + 1, 32));
				}
			}
		}

		static class CustomParticleFactory implements ParticleProvider<SimpleParticleType> {
			private final SpriteSet spriteSet;

			public CustomParticleFactory(SpriteSet spriteSet) {
				this.spriteSet = spriteSet;
			}

			public Particle createParticle(SimpleParticleType typeIn, ClientLevel worldIn, double x, double y, double z, double xSpeed, double ySpeed,
					double zSpeed, RandomSource random) {
				return new CustomParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, this.spriteSet);
			}
		}
	}

	static class AshParticle {
		static class CustomParticle extends SingleQuadParticle {
			private final SpriteSet spriteSet;

			protected CustomParticle(ClientLevel world, double x, double y, double z, double vx, double vy, double vz, SpriteSet spriteSet) {
				super(world, x, y, z, spriteSet.first());
				this.spriteSet = spriteSet;
				this.setSize((float) 0.2, (float) 0.2);
				this.quadSize *= (float) 30;
				this.lifetime = 20;
				this.gravity = (float) 0;
				this.hasPhysics = false;
				this.xd = vx * 1;
				this.yd = vy * 1;
				this.zd = vz * 1;
				this.setSpriteFromAge(spriteSet);
			}

			@Override
			public SingleQuadParticle.Layer getLayer() {
				return SingleQuadParticle.Layer.TRANSLUCENT;
			}

			@Override
			public void tick() {
				super.tick();
				if (!this.removed) {
					this.setSprite(this.spriteSet.get((this.age / 3) % 3 + 1, 3));
				}
			}
		}

		static class CustomParticleFactory implements ParticleProvider<SimpleParticleType> {
			private final SpriteSet spriteSet;

			public CustomParticleFactory(SpriteSet spriteSet) {
				this.spriteSet = spriteSet;
			}

			public Particle createParticle(SimpleParticleType typeIn, ClientLevel worldIn, double x, double y, double z, double xSpeed, double ySpeed,
					double zSpeed, RandomSource random) {
				return new CustomParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, this.spriteSet);
			}
		}
	}

	static class BlueSteamParticle {
		static class CustomParticle extends SingleQuadParticle {
			private final SpriteSet spriteSet;

			protected CustomParticle(ClientLevel world, double x, double y, double z, double vx, double vy, double vz, SpriteSet spriteSet) {
				super(world, x, y, z, spriteSet.first());
				this.spriteSet = spriteSet;
				this.setSize((float) 0.2, (float) 0.2);
				this.quadSize *= (float) 3;
				this.lifetime = 25;
				this.gravity = (float) 0;
				this.hasPhysics = true;
				this.xd = vx * 1;
				this.yd = vy * 1;
				this.zd = vz * 1;
				this.setSpriteFromAge(spriteSet);
			}

			@Override
			public SingleQuadParticle.Layer getLayer() {
				return SingleQuadParticle.Layer.TRANSLUCENT;
			}

			@Override
			public void tick() {
				super.tick();
				if (!this.removed) {
					this.setSprite(this.spriteSet.get((this.age / 5) % 3 + 1, 3));
				}
			}
		}

		static class CustomParticleFactory implements ParticleProvider<SimpleParticleType> {
			private final SpriteSet spriteSet;

			public CustomParticleFactory(SpriteSet spriteSet) {
				this.spriteSet = spriteSet;
			}

			public Particle createParticle(SimpleParticleType typeIn, ClientLevel worldIn, double x, double y, double z, double xSpeed, double ySpeed,
					double zSpeed, RandomSource random) {
				return new CustomParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, this.spriteSet);
			}
		}
	}

	static class ChakraParticle {
		static class CustomParticle extends SingleQuadParticle {
			private final SpriteSet spriteSet;

			protected CustomParticle(ClientLevel world, double x, double y, double z, double vx, double vy, double vz, SpriteSet spriteSet) {
				super(world, x, y, z, spriteSet.first());
				this.spriteSet = spriteSet;
				this.setSize((float) 0.2, (float) 0.2);
				this.quadSize *= (float) 1.5;
				this.lifetime = 29;
				this.gravity = (float) 0;
				this.hasPhysics = true;
				this.xd = vx * 1;
				this.yd = vy * 1;
				this.zd = vz * 1;
				this.setSpriteFromAge(spriteSet);
			}

			@Override
			public SingleQuadParticle.Layer getLayer() {
				return SingleQuadParticle.Layer.TRANSLUCENT;
			}

			@Override
			public void tick() {
				super.tick();
				if (!this.removed) {
					this.setSprite(this.spriteSet.get((this.age / 3) % 10 + 1, 10));
				}
			}
		}

		static class CustomParticleFactory implements ParticleProvider<SimpleParticleType> {
			private final SpriteSet spriteSet;

			public CustomParticleFactory(SpriteSet spriteSet) {
				this.spriteSet = spriteSet;
			}

			public Particle createParticle(SimpleParticleType typeIn, ClientLevel worldIn, double x, double y, double z, double xSpeed, double ySpeed,
					double zSpeed, RandomSource random) {
				return new CustomParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, this.spriteSet);
			}
		}
	}

	static class FlameParticle {
		static class CustomParticle extends SingleQuadParticle {
			private final SpriteSet spriteSet;

			protected CustomParticle(ClientLevel world, double x, double y, double z, double vx, double vy, double vz, SpriteSet spriteSet) {
				super(world, x, y, z, spriteSet.first());
				this.spriteSet = spriteSet;
				this.setSize((float) 0.2, (float) 0.2);
				this.quadSize *= (float) 5;
				this.lifetime = 100;
				this.gravity = (float) 0;
				this.hasPhysics = false;
				this.xd = vx * 1;
				this.yd = vy * 1;
				this.zd = vz * 1;
				this.setSpriteFromAge(spriteSet);
			}

			@Override
			public SingleQuadParticle.Layer getLayer() {
				return SingleQuadParticle.Layer.TRANSLUCENT;
			}

			@Override
			public void tick() {
				super.tick();
				if (!this.removed) {
					this.setSprite(this.spriteSet.get((this.age / 3) % 4 + 1, 4));
				}
			}
		}

		static class CustomParticleFactory implements ParticleProvider<SimpleParticleType> {
			private final SpriteSet spriteSet;

			public CustomParticleFactory(SpriteSet spriteSet) {
				this.spriteSet = spriteSet;
			}

			public Particle createParticle(SimpleParticleType typeIn, ClientLevel worldIn, double x, double y, double z, double xSpeed, double ySpeed,
					double zSpeed, RandomSource random) {
				return new CustomParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, this.spriteSet);
			}
		}
	}


	static class GreenSteamParticle {
		static class CustomParticle extends SingleQuadParticle {
			private final SpriteSet spriteSet;

			protected CustomParticle(ClientLevel world, double x, double y, double z, double vx, double vy, double vz, SpriteSet spriteSet) {
				super(world, x, y, z, spriteSet.first());
				this.spriteSet = spriteSet;
				this.setSize((float) 0.2, (float) 0.2);
				this.quadSize *= (float) 3;
				this.lifetime = 25;
				this.gravity = (float) 0;
				this.hasPhysics = true;
				this.xd = vx * 1;
				this.yd = vy * 1;
				this.zd = vz * 1;
				this.setSpriteFromAge(spriteSet);
			}

			@Override
			public SingleQuadParticle.Layer getLayer() {
				return SingleQuadParticle.Layer.TRANSLUCENT;
			}

			@Override
			public void tick() {
				super.tick();
				if (!this.removed) {
					this.setSprite(this.spriteSet.get((this.age / 5) % 3 + 1, 3));
				}
			}
		}

		static class CustomParticleFactory implements ParticleProvider<SimpleParticleType> {
			private final SpriteSet spriteSet;

			public CustomParticleFactory(SpriteSet spriteSet) {
				this.spriteSet = spriteSet;
			}

			public Particle createParticle(SimpleParticleType typeIn, ClientLevel worldIn, double x, double y, double z, double xSpeed, double ySpeed,
					double zSpeed, RandomSource random) {
				return new CustomParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, this.spriteSet);
			}
		}
	}

	static class KamuiParticleParticle {
		static class CustomParticle extends SingleQuadParticle {
			private final SpriteSet spriteSet;

			protected CustomParticle(ClientLevel world, double x, double y, double z, double vx, double vy, double vz, SpriteSet spriteSet) {
				super(world, x, y, z, spriteSet.first());
				this.spriteSet = spriteSet;
				this.setSize((float) 0.2, (float) 0.2);
				this.quadSize *= (float) 10;
				this.lifetime = 23;
				this.gravity = (float) 0;
				this.hasPhysics = false;
				this.xd = vx * 1;
				this.yd = vy * 1;
				this.zd = vz * 1;
				this.setSpriteFromAge(spriteSet);
			}

			@Override
			public SingleQuadParticle.Layer getLayer() {
				return SingleQuadParticle.Layer.TRANSLUCENT;
			}

			@Override
			public void tick() {
				super.tick();
				if (!this.removed) {
					this.setSprite(this.spriteSet.get((this.age / 3) % 8 + 1, 8));
				}
			}
		}

		static class CustomParticleFactory implements ParticleProvider<SimpleParticleType> {
			private final SpriteSet spriteSet;

			public CustomParticleFactory(SpriteSet spriteSet) {
				this.spriteSet = spriteSet;
			}

			public Particle createParticle(SimpleParticleType typeIn, ClientLevel worldIn, double x, double y, double z, double xSpeed, double ySpeed,
					double zSpeed, RandomSource random) {
				return new CustomParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, this.spriteSet);
			}
		}
	}

	static class LightningParticle {
		static class CustomParticle extends SingleQuadParticle {
			private final SpriteSet spriteSet;

			protected CustomParticle(ClientLevel world, double x, double y, double z, double vx, double vy, double vz, SpriteSet spriteSet) {
				super(world, x, y, z, spriteSet.first());
				this.spriteSet = spriteSet;
				this.setSize((float) 0.2, (float) 0.2);
				this.quadSize *= (float) 5;
				this.lifetime = 20;
				this.gravity = (float) 0;
				this.hasPhysics = false;
				this.xd = vx * 1;
				this.yd = vy * 1;
				this.zd = vz * 1;
				this.setSpriteFromAge(spriteSet);
			}

			@Override
			public SingleQuadParticle.Layer getLayer() {
				return SingleQuadParticle.Layer.TRANSLUCENT;
			}

			@Override
			public void tick() {
				super.tick();
				if (!this.removed) {
					this.setSprite(this.spriteSet.get((this.age / 3) % 9 + 1, 9));
				}
			}
		}

		static class CustomParticleFactory implements ParticleProvider<SimpleParticleType> {
			private final SpriteSet spriteSet;

			public CustomParticleFactory(SpriteSet spriteSet) {
				this.spriteSet = spriteSet;
			}

			public Particle createParticle(SimpleParticleType typeIn, ClientLevel worldIn, double x, double y, double z, double xSpeed, double ySpeed,
					double zSpeed, RandomSource random) {
				return new CustomParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, this.spriteSet);
			}
		}
	}

	static class RedSteamParticle {
		static class CustomParticle extends SingleQuadParticle {
			private final SpriteSet spriteSet;

			protected CustomParticle(ClientLevel world, double x, double y, double z, double vx, double vy, double vz, SpriteSet spriteSet) {
				super(world, x, y, z, spriteSet.first());
				this.spriteSet = spriteSet;
				this.setSize((float) 0.2, (float) 0.2);
				this.quadSize *= (float) 3;
				this.lifetime = 25;
				this.gravity = (float) 0;
				this.hasPhysics = true;
				this.xd = vx * 1;
				this.yd = vy * 1;
				this.zd = vz * 1;
				this.setSpriteFromAge(spriteSet);
			}

			@Override
			public SingleQuadParticle.Layer getLayer() {
				return SingleQuadParticle.Layer.TRANSLUCENT;
			}

			@Override
			public void tick() {
				super.tick();
				if (!this.removed) {
					this.setSprite(this.spriteSet.get((this.age / 5) % 3 + 1, 3));
				}
			}
		}

		static class CustomParticleFactory implements ParticleProvider<SimpleParticleType> {
			private final SpriteSet spriteSet;

			public CustomParticleFactory(SpriteSet spriteSet) {
				this.spriteSet = spriteSet;
			}

			public Particle createParticle(SimpleParticleType typeIn, ClientLevel worldIn, double x, double y, double z, double xSpeed, double ySpeed,
					double zSpeed, RandomSource random) {
				return new CustomParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, this.spriteSet);
			}
		}
	}

	static class SmokeParticle {
		static class CustomParticle extends SingleQuadParticle {
			private final SpriteSet spriteSet;

			protected CustomParticle(ClientLevel world, double x, double y, double z, double vx, double vy, double vz, SpriteSet spriteSet) {
				super(world, x, y, z, spriteSet.first());
				this.spriteSet = spriteSet;
				this.setSize((float) 0.2, (float) 0.2);
				this.quadSize *= (float) 30;
				this.lifetime = 132;
				this.gravity = (float) 0;
				this.hasPhysics = false;
				this.xd = vx * 1;
				this.yd = vy * 1;
				this.zd = vz * 1;
				this.setSpriteFromAge(spriteSet);
			}

			@Override
			public SingleQuadParticle.Layer getLayer() {
				return SingleQuadParticle.Layer.TRANSLUCENT;
			}

			@Override
			public void tick() {
				super.tick();
				if (!this.removed) {
					this.setSprite(this.spriteSet.get((this.age / 3) % 3 + 1, 3));
				}
			}
		}

		static class CustomParticleFactory implements ParticleProvider<SimpleParticleType> {
			private final SpriteSet spriteSet;

			public CustomParticleFactory(SpriteSet spriteSet) {
				this.spriteSet = spriteSet;
			}

			public Particle createParticle(SimpleParticleType typeIn, ClientLevel worldIn, double x, double y, double z, double xSpeed, double ySpeed,
					double zSpeed, RandomSource random) {
				return new CustomParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, this.spriteSet);
			}
		}
	}

	static class StormParticle {
		static class CustomParticle extends SingleQuadParticle {
			private final SpriteSet spriteSet;

			protected CustomParticle(ClientLevel world, double x, double y, double z, double vx, double vy, double vz, SpriteSet spriteSet) {
				super(world, x, y, z, spriteSet.first());
				this.spriteSet = spriteSet;
				this.setSize((float) 0.2, (float) 0.2);
				this.quadSize *= (float) 5;
				this.lifetime = 132;
				this.gravity = (float) 0;
				this.hasPhysics = false;
				this.xd = vx * 1;
				this.yd = vy * 1;
				this.zd = vz * 1;
				this.setSpriteFromAge(spriteSet);
			}

			@Override
			public SingleQuadParticle.Layer getLayer() {
				return SingleQuadParticle.Layer.TRANSLUCENT;
			}

			@Override
			public void tick() {
				super.tick();
				if (!this.removed) {
					this.setSprite(this.spriteSet.get((this.age / 3) % 9 + 1, 9));
				}
			}
		}

		static class CustomParticleFactory implements ParticleProvider<SimpleParticleType> {
			private final SpriteSet spriteSet;

			public CustomParticleFactory(SpriteSet spriteSet) {
				this.spriteSet = spriteSet;
			}

			public Particle createParticle(SimpleParticleType typeIn, ClientLevel worldIn, double x, double y, double z, double xSpeed, double ySpeed,
					double zSpeed, RandomSource random) {
				return new CustomParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, this.spriteSet);
			}
		}
	}

	static class TailedBeastBombParticleBlueParticle {
		static class CustomParticle extends SingleQuadParticle {
			private final SpriteSet spriteSet;

			protected CustomParticle(ClientLevel world, double x, double y, double z, double vx, double vy, double vz, SpriteSet spriteSet) {
				super(world, x, y, z, spriteSet.first());
				this.spriteSet = spriteSet;
				this.setSize((float) 0.2, (float) 0.2);
				this.quadSize *= (float) 1;
				this.lifetime = 4;
				this.gravity = (float) 0;
				this.hasPhysics = true;
				this.xd = vx * 1;
				this.yd = vy * 1;
				this.zd = vz * 1;
				this.setSprite(spriteSet.get(this.random));
			}

			@Override
			public SingleQuadParticle.Layer getLayer() {
				return SingleQuadParticle.Layer.TRANSLUCENT;
			}

			@Override
			public void tick() {
				super.tick();
			}
		}

		static class CustomParticleFactory implements ParticleProvider<SimpleParticleType> {
			private final SpriteSet spriteSet;

			public CustomParticleFactory(SpriteSet spriteSet) {
				this.spriteSet = spriteSet;
			}

			public Particle createParticle(SimpleParticleType typeIn, ClientLevel worldIn, double x, double y, double z, double xSpeed, double ySpeed,
					double zSpeed, RandomSource random) {
				return new CustomParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, this.spriteSet);
			}
		}
	}

	static class TailedBeastBombParticleRedParticle {
		static class CustomParticle extends SingleQuadParticle {
			private final SpriteSet spriteSet;

			protected CustomParticle(ClientLevel world, double x, double y, double z, double vx, double vy, double vz, SpriteSet spriteSet) {
				super(world, x, y, z, spriteSet.first());
				this.spriteSet = spriteSet;
				this.setSize((float) 0.2, (float) 0.2);
				this.quadSize *= (float) 1;
				this.lifetime = 4;
				this.gravity = (float) 0;
				this.hasPhysics = true;
				this.xd = vx * 1;
				this.yd = vy * 1;
				this.zd = vz * 1;
				this.setSprite(spriteSet.get(this.random));
			}

			@Override
			public SingleQuadParticle.Layer getLayer() {
				return SingleQuadParticle.Layer.TRANSLUCENT;
			}

			@Override
			public void tick() {
				super.tick();
			}
		}

		static class CustomParticleFactory implements ParticleProvider<SimpleParticleType> {
			private final SpriteSet spriteSet;

			public CustomParticleFactory(SpriteSet spriteSet) {
				this.spriteSet = spriteSet;
			}

			public Particle createParticle(SimpleParticleType typeIn, ClientLevel worldIn, double x, double y, double z, double xSpeed, double ySpeed,
					double zSpeed, RandomSource random) {
				return new CustomParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, this.spriteSet);
			}
		}
	}

}
