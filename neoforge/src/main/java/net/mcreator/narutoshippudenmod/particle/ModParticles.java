package net.mcreator.narutoshippudenmod.particle;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.SingleQuadParticle;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleType;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;

public final class ModParticles {
	private ModParticles() {
	}

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class AmaterasuFireParticle {
		public static final SimpleParticleType particle = new SimpleParticleType(false);

		@SubscribeEvent
		public static void registerParticleType(RegistryEvent.Register<ParticleType<?>> event) {
			event.getRegistry().register(particle.setRegistryName("amaterasu_fire"));
		}

		@OnlyIn(Dist.CLIENT)
		@SubscribeEvent
		public static void registerParticle(RegisterParticleProvidersEvent event) {
			Minecraft.getInstance().particleEngine.register(particle, CustomParticleFactory::new);
		}

		@OnlyIn(Dist.CLIENT)
		private static class CustomParticle extends SingleQuadParticle {
			private final SpriteSet spriteSet;

			protected CustomParticle(ClientLevel world, double x, double y, double z, double vx, double vy, double vz, SpriteSet spriteSet) {
				super(world, x, y, z);
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
			public ParticleRenderType getRenderType() {
				return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
			}

			@Override
			public void tick() {
				super.tick();
				if (!this.removed) {
					this.setSprite(this.spriteSet.get((this.age / 2) % 32 + 1, 32));
				}
			}
		}

		@OnlyIn(Dist.CLIENT)
		private static class CustomParticleFactory implements ParticleProvider<SimpleParticleType> {
			private final SpriteSet spriteSet;

			public CustomParticleFactory(SpriteSet spriteSet) {
				this.spriteSet = spriteSet;
			}

			public Particle createParticle(SimpleParticleType typeIn, ClientLevel worldIn, double x, double y, double z, double xSpeed, double ySpeed,
					double zSpeed) {
				return new CustomParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, this.spriteSet);
			}
		}
	}

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class AshParticle {
		public static final SimpleParticleType particle = new SimpleParticleType(false);

		@SubscribeEvent
		public static void registerParticleType(RegistryEvent.Register<ParticleType<?>> event) {
			event.getRegistry().register(particle.setRegistryName("ash"));
		}

		@OnlyIn(Dist.CLIENT)
		@SubscribeEvent
		public static void registerParticle(RegisterParticleProvidersEvent event) {
			Minecraft.getInstance().particleEngine.register(particle, CustomParticleFactory::new);
		}

		@OnlyIn(Dist.CLIENT)
		private static class CustomParticle extends SingleQuadParticle {
			private final SpriteSet spriteSet;

			protected CustomParticle(ClientLevel world, double x, double y, double z, double vx, double vy, double vz, SpriteSet spriteSet) {
				super(world, x, y, z);
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
			public ParticleRenderType getRenderType() {
				return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
			}

			@Override
			public void tick() {
				super.tick();
				if (!this.removed) {
					this.setSprite(this.spriteSet.get((this.age / 3) % 3 + 1, 3));
				}
			}
		}

		@OnlyIn(Dist.CLIENT)
		private static class CustomParticleFactory implements ParticleProvider<SimpleParticleType> {
			private final SpriteSet spriteSet;

			public CustomParticleFactory(SpriteSet spriteSet) {
				this.spriteSet = spriteSet;
			}

			public Particle createParticle(SimpleParticleType typeIn, ClientLevel worldIn, double x, double y, double z, double xSpeed, double ySpeed,
					double zSpeed) {
				return new CustomParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, this.spriteSet);
			}
		}
	}

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class BlueSteamParticle {
		public static final SimpleParticleType particle = new SimpleParticleType(false);

		@SubscribeEvent
		public static void registerParticleType(RegistryEvent.Register<ParticleType<?>> event) {
			event.getRegistry().register(particle.setRegistryName("blue_steam"));
		}

		@OnlyIn(Dist.CLIENT)
		@SubscribeEvent
		public static void registerParticle(RegisterParticleProvidersEvent event) {
			Minecraft.getInstance().particleEngine.register(particle, CustomParticleFactory::new);
		}

		@OnlyIn(Dist.CLIENT)
		private static class CustomParticle extends SingleQuadParticle {
			private final SpriteSet spriteSet;

			protected CustomParticle(ClientLevel world, double x, double y, double z, double vx, double vy, double vz, SpriteSet spriteSet) {
				super(world, x, y, z);
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
			public ParticleRenderType getRenderType() {
				return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
			}

			@Override
			public void tick() {
				super.tick();
				if (!this.removed) {
					this.setSprite(this.spriteSet.get((this.age / 5) % 3 + 1, 3));
				}
			}
		}

		@OnlyIn(Dist.CLIENT)
		private static class CustomParticleFactory implements ParticleProvider<SimpleParticleType> {
			private final SpriteSet spriteSet;

			public CustomParticleFactory(SpriteSet spriteSet) {
				this.spriteSet = spriteSet;
			}

			public Particle createParticle(SimpleParticleType typeIn, ClientLevel worldIn, double x, double y, double z, double xSpeed, double ySpeed,
					double zSpeed) {
				return new CustomParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, this.spriteSet);
			}
		}
	}

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class ChakraParticle {
		public static final SimpleParticleType particle = new SimpleParticleType(false);

		@SubscribeEvent
		public static void registerParticleType(RegistryEvent.Register<ParticleType<?>> event) {
			event.getRegistry().register(particle.setRegistryName("chakra"));
		}

		@OnlyIn(Dist.CLIENT)
		@SubscribeEvent
		public static void registerParticle(RegisterParticleProvidersEvent event) {
			Minecraft.getInstance().particleEngine.register(particle, CustomParticleFactory::new);
		}

		@OnlyIn(Dist.CLIENT)
		private static class CustomParticle extends SingleQuadParticle {
			private final SpriteSet spriteSet;

			protected CustomParticle(ClientLevel world, double x, double y, double z, double vx, double vy, double vz, SpriteSet spriteSet) {
				super(world, x, y, z);
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
			public ParticleRenderType getRenderType() {
				return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
			}

			@Override
			public void tick() {
				super.tick();
				if (!this.removed) {
					this.setSprite(this.spriteSet.get((this.age / 3) % 10 + 1, 10));
				}
			}
		}

		@OnlyIn(Dist.CLIENT)
		private static class CustomParticleFactory implements ParticleProvider<SimpleParticleType> {
			private final SpriteSet spriteSet;

			public CustomParticleFactory(SpriteSet spriteSet) {
				this.spriteSet = spriteSet;
			}

			public Particle createParticle(SimpleParticleType typeIn, ClientLevel worldIn, double x, double y, double z, double xSpeed, double ySpeed,
					double zSpeed) {
				return new CustomParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, this.spriteSet);
			}
		}
	}

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class FlameParticle {
		public static final SimpleParticleType particle = new SimpleParticleType(false);

		@SubscribeEvent
		public static void registerParticleType(RegistryEvent.Register<ParticleType<?>> event) {
			event.getRegistry().register(particle.setRegistryName("flame"));
		}

		@OnlyIn(Dist.CLIENT)
		@SubscribeEvent
		public static void registerParticle(RegisterParticleProvidersEvent event) {
			Minecraft.getInstance().particleEngine.register(particle, CustomParticleFactory::new);
		}

		@OnlyIn(Dist.CLIENT)
		private static class CustomParticle extends SingleQuadParticle {
			private final SpriteSet spriteSet;

			protected CustomParticle(ClientLevel world, double x, double y, double z, double vx, double vy, double vz, SpriteSet spriteSet) {
				super(world, x, y, z);
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
			public ParticleRenderType getRenderType() {
				return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
			}

			@Override
			public void tick() {
				super.tick();
				if (!this.removed) {
					this.setSprite(this.spriteSet.get((this.age / 3) % 4 + 1, 4));
				}
			}
		}

		@OnlyIn(Dist.CLIENT)
		private static class CustomParticleFactory implements ParticleProvider<SimpleParticleType> {
			private final SpriteSet spriteSet;

			public CustomParticleFactory(SpriteSet spriteSet) {
				this.spriteSet = spriteSet;
			}

			public Particle createParticle(SimpleParticleType typeIn, ClientLevel worldIn, double x, double y, double z, double xSpeed, double ySpeed,
					double zSpeed) {
				return new CustomParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, this.spriteSet);
			}
		}
	}

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class FuramingoganParticleParticle {
		public static final SimpleParticleType particle = new SimpleParticleType(false);

		@SubscribeEvent
		public static void registerParticleType(RegistryEvent.Register<ParticleType<?>> event) {
			event.getRegistry().register(particle.setRegistryName("furamingogan_particle"));
		}

		@OnlyIn(Dist.CLIENT)
		@SubscribeEvent
		public static void registerParticle(RegisterParticleProvidersEvent event) {
			Minecraft.getInstance().particleEngine.register(particle, CustomParticleFactory::new);
		}

		@OnlyIn(Dist.CLIENT)
		private static class CustomParticle extends SingleQuadParticle {
			private final SpriteSet spriteSet;

			protected CustomParticle(ClientLevel world, double x, double y, double z, double vx, double vy, double vz, SpriteSet spriteSet) {
				super(world, x, y, z);
				this.spriteSet = spriteSet;
				this.setSize((float) 0.2, (float) 0.2);
				this.quadSize *= (float) 3;
				this.lifetime = 100;
				this.gravity = (float) 0;
				this.hasPhysics = true;
				this.xd = vx * 1;
				this.yd = vy * 1;
				this.zd = vz * 1;
				this.setSpriteFromAge(spriteSet);
			}

			@Override
			public ParticleRenderType getRenderType() {
				return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
			}

			@Override
			public void tick() {
				super.tick();
				if (!this.removed) {
					this.setSprite(this.spriteSet.get((this.age / 5) % 3 + 1, 3));
				}
			}
		}

		@OnlyIn(Dist.CLIENT)
		private static class CustomParticleFactory implements ParticleProvider<SimpleParticleType> {
			private final SpriteSet spriteSet;

			public CustomParticleFactory(SpriteSet spriteSet) {
				this.spriteSet = spriteSet;
			}

			public Particle createParticle(SimpleParticleType typeIn, ClientLevel worldIn, double x, double y, double z, double xSpeed, double ySpeed,
					double zSpeed) {
				return new CustomParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, this.spriteSet);
			}
		}
	}

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class GreenSteamParticle {
		public static final SimpleParticleType particle = new SimpleParticleType(false);

		@SubscribeEvent
		public static void registerParticleType(RegistryEvent.Register<ParticleType<?>> event) {
			event.getRegistry().register(particle.setRegistryName("green_steam"));
		}

		@OnlyIn(Dist.CLIENT)
		@SubscribeEvent
		public static void registerParticle(RegisterParticleProvidersEvent event) {
			Minecraft.getInstance().particleEngine.register(particle, CustomParticleFactory::new);
		}

		@OnlyIn(Dist.CLIENT)
		private static class CustomParticle extends SingleQuadParticle {
			private final SpriteSet spriteSet;

			protected CustomParticle(ClientLevel world, double x, double y, double z, double vx, double vy, double vz, SpriteSet spriteSet) {
				super(world, x, y, z);
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
			public ParticleRenderType getRenderType() {
				return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
			}

			@Override
			public void tick() {
				super.tick();
				if (!this.removed) {
					this.setSprite(this.spriteSet.get((this.age / 5) % 3 + 1, 3));
				}
			}
		}

		@OnlyIn(Dist.CLIENT)
		private static class CustomParticleFactory implements ParticleProvider<SimpleParticleType> {
			private final SpriteSet spriteSet;

			public CustomParticleFactory(SpriteSet spriteSet) {
				this.spriteSet = spriteSet;
			}

			public Particle createParticle(SimpleParticleType typeIn, ClientLevel worldIn, double x, double y, double z, double xSpeed, double ySpeed,
					double zSpeed) {
				return new CustomParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, this.spriteSet);
			}
		}
	}

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class KamuiParticleParticle {
		public static final SimpleParticleType particle = new SimpleParticleType(true);

		@SubscribeEvent
		public static void registerParticleType(RegistryEvent.Register<ParticleType<?>> event) {
			event.getRegistry().register(particle.setRegistryName("kamui_particle"));
		}

		@OnlyIn(Dist.CLIENT)
		@SubscribeEvent
		public static void registerParticle(RegisterParticleProvidersEvent event) {
			Minecraft.getInstance().particleEngine.register(particle, CustomParticleFactory::new);
		}

		@OnlyIn(Dist.CLIENT)
		private static class CustomParticle extends SingleQuadParticle {
			private final SpriteSet spriteSet;

			protected CustomParticle(ClientLevel world, double x, double y, double z, double vx, double vy, double vz, SpriteSet spriteSet) {
				super(world, x, y, z);
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
			public ParticleRenderType getRenderType() {
				return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
			}

			@Override
			public void tick() {
				super.tick();
				if (!this.removed) {
					this.setSprite(this.spriteSet.get((this.age / 3) % 8 + 1, 8));
				}
			}
		}

		@OnlyIn(Dist.CLIENT)
		private static class CustomParticleFactory implements ParticleProvider<SimpleParticleType> {
			private final SpriteSet spriteSet;

			public CustomParticleFactory(SpriteSet spriteSet) {
				this.spriteSet = spriteSet;
			}

			public Particle createParticle(SimpleParticleType typeIn, ClientLevel worldIn, double x, double y, double z, double xSpeed, double ySpeed,
					double zSpeed) {
				return new CustomParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, this.spriteSet);
			}
		}
	}

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class LightningParticle {
		public static final SimpleParticleType particle = new SimpleParticleType(false);

		@SubscribeEvent
		public static void registerParticleType(RegistryEvent.Register<ParticleType<?>> event) {
			event.getRegistry().register(particle.setRegistryName("lightning"));
		}

		@OnlyIn(Dist.CLIENT)
		@SubscribeEvent
		public static void registerParticle(RegisterParticleProvidersEvent event) {
			Minecraft.getInstance().particleEngine.register(particle, CustomParticleFactory::new);
		}

		@OnlyIn(Dist.CLIENT)
		private static class CustomParticle extends SingleQuadParticle {
			private final SpriteSet spriteSet;

			protected CustomParticle(ClientLevel world, double x, double y, double z, double vx, double vy, double vz, SpriteSet spriteSet) {
				super(world, x, y, z);
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
			public ParticleRenderType getRenderType() {
				return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
			}

			@Override
			public void tick() {
				super.tick();
				if (!this.removed) {
					this.setSprite(this.spriteSet.get((this.age / 3) % 9 + 1, 9));
				}
			}
		}

		@OnlyIn(Dist.CLIENT)
		private static class CustomParticleFactory implements ParticleProvider<SimpleParticleType> {
			private final SpriteSet spriteSet;

			public CustomParticleFactory(SpriteSet spriteSet) {
				this.spriteSet = spriteSet;
			}

			public Particle createParticle(SimpleParticleType typeIn, ClientLevel worldIn, double x, double y, double z, double xSpeed, double ySpeed,
					double zSpeed) {
				return new CustomParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, this.spriteSet);
			}
		}
	}

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class RedSteamParticle {
		public static final SimpleParticleType particle = new SimpleParticleType(false);

		@SubscribeEvent
		public static void registerParticleType(RegistryEvent.Register<ParticleType<?>> event) {
			event.getRegistry().register(particle.setRegistryName("red_steam"));
		}

		@OnlyIn(Dist.CLIENT)
		@SubscribeEvent
		public static void registerParticle(RegisterParticleProvidersEvent event) {
			Minecraft.getInstance().particleEngine.register(particle, CustomParticleFactory::new);
		}

		@OnlyIn(Dist.CLIENT)
		private static class CustomParticle extends SingleQuadParticle {
			private final SpriteSet spriteSet;

			protected CustomParticle(ClientLevel world, double x, double y, double z, double vx, double vy, double vz, SpriteSet spriteSet) {
				super(world, x, y, z);
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
			public ParticleRenderType getRenderType() {
				return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
			}

			@Override
			public void tick() {
				super.tick();
				if (!this.removed) {
					this.setSprite(this.spriteSet.get((this.age / 5) % 3 + 1, 3));
				}
			}
		}

		@OnlyIn(Dist.CLIENT)
		private static class CustomParticleFactory implements ParticleProvider<SimpleParticleType> {
			private final SpriteSet spriteSet;

			public CustomParticleFactory(SpriteSet spriteSet) {
				this.spriteSet = spriteSet;
			}

			public Particle createParticle(SimpleParticleType typeIn, ClientLevel worldIn, double x, double y, double z, double xSpeed, double ySpeed,
					double zSpeed) {
				return new CustomParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, this.spriteSet);
			}
		}
	}

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class SmokeParticle {
		public static final SimpleParticleType particle = new SimpleParticleType(false);

		@SubscribeEvent
		public static void registerParticleType(RegistryEvent.Register<ParticleType<?>> event) {
			event.getRegistry().register(particle.setRegistryName("smoke"));
		}

		@OnlyIn(Dist.CLIENT)
		@SubscribeEvent
		public static void registerParticle(RegisterParticleProvidersEvent event) {
			Minecraft.getInstance().particleEngine.register(particle, CustomParticleFactory::new);
		}

		@OnlyIn(Dist.CLIENT)
		private static class CustomParticle extends SingleQuadParticle {
			private final SpriteSet spriteSet;

			protected CustomParticle(ClientLevel world, double x, double y, double z, double vx, double vy, double vz, SpriteSet spriteSet) {
				super(world, x, y, z);
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
			public ParticleRenderType getRenderType() {
				return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
			}

			@Override
			public void tick() {
				super.tick();
				if (!this.removed) {
					this.setSprite(this.spriteSet.get((this.age / 3) % 3 + 1, 3));
				}
			}
		}

		@OnlyIn(Dist.CLIENT)
		private static class CustomParticleFactory implements ParticleProvider<SimpleParticleType> {
			private final SpriteSet spriteSet;

			public CustomParticleFactory(SpriteSet spriteSet) {
				this.spriteSet = spriteSet;
			}

			public Particle createParticle(SimpleParticleType typeIn, ClientLevel worldIn, double x, double y, double z, double xSpeed, double ySpeed,
					double zSpeed) {
				return new CustomParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, this.spriteSet);
			}
		}
	}

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class StormParticle {
		public static final SimpleParticleType particle = new SimpleParticleType(false);

		@SubscribeEvent
		public static void registerParticleType(RegistryEvent.Register<ParticleType<?>> event) {
			event.getRegistry().register(particle.setRegistryName("storm"));
		}

		@OnlyIn(Dist.CLIENT)
		@SubscribeEvent
		public static void registerParticle(RegisterParticleProvidersEvent event) {
			Minecraft.getInstance().particleEngine.register(particle, CustomParticleFactory::new);
		}

		@OnlyIn(Dist.CLIENT)
		private static class CustomParticle extends SingleQuadParticle {
			private final SpriteSet spriteSet;

			protected CustomParticle(ClientLevel world, double x, double y, double z, double vx, double vy, double vz, SpriteSet spriteSet) {
				super(world, x, y, z);
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
			public ParticleRenderType getRenderType() {
				return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
			}

			@Override
			public void tick() {
				super.tick();
				if (!this.removed) {
					this.setSprite(this.spriteSet.get((this.age / 3) % 9 + 1, 9));
				}
			}
		}

		@OnlyIn(Dist.CLIENT)
		private static class CustomParticleFactory implements ParticleProvider<SimpleParticleType> {
			private final SpriteSet spriteSet;

			public CustomParticleFactory(SpriteSet spriteSet) {
				this.spriteSet = spriteSet;
			}

			public Particle createParticle(SimpleParticleType typeIn, ClientLevel worldIn, double x, double y, double z, double xSpeed, double ySpeed,
					double zSpeed) {
				return new CustomParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, this.spriteSet);
			}
		}
	}

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class TailedBeastBombParticleBlueParticle {
		public static final SimpleParticleType particle = new SimpleParticleType(false);

		@SubscribeEvent
		public static void registerParticleType(RegistryEvent.Register<ParticleType<?>> event) {
			event.getRegistry().register(particle.setRegistryName("tailed_beast_bomb_particle_blue"));
		}

		@OnlyIn(Dist.CLIENT)
		@SubscribeEvent
		public static void registerParticle(RegisterParticleProvidersEvent event) {
			Minecraft.getInstance().particleEngine.register(particle, CustomParticleFactory::new);
		}

		@OnlyIn(Dist.CLIENT)
		private static class CustomParticle extends SingleQuadParticle {
			private final SpriteSet spriteSet;

			protected CustomParticle(ClientLevel world, double x, double y, double z, double vx, double vy, double vz, SpriteSet spriteSet) {
				super(world, x, y, z);
				this.spriteSet = spriteSet;
				this.setSize((float) 0.2, (float) 0.2);
				this.quadSize *= (float) 1;
				this.lifetime = 4;
				this.gravity = (float) 0;
				this.hasPhysics = true;
				this.xd = vx * 1;
				this.yd = vy * 1;
				this.zd = vz * 1;
				this.pickSprite(spriteSet);
			}

			@Override
			public ParticleRenderType getRenderType() {
				return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
			}

			@Override
			public void tick() {
				super.tick();
			}
		}

		@OnlyIn(Dist.CLIENT)
		private static class CustomParticleFactory implements ParticleProvider<SimpleParticleType> {
			private final SpriteSet spriteSet;

			public CustomParticleFactory(SpriteSet spriteSet) {
				this.spriteSet = spriteSet;
			}

			public Particle createParticle(SimpleParticleType typeIn, ClientLevel worldIn, double x, double y, double z, double xSpeed, double ySpeed,
					double zSpeed) {
				return new CustomParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, this.spriteSet);
			}
		}
	}

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class TailedBeastBombParticleRedParticle {
		public static final SimpleParticleType particle = new SimpleParticleType(false);

		@SubscribeEvent
		public static void registerParticleType(RegistryEvent.Register<ParticleType<?>> event) {
			event.getRegistry().register(particle.setRegistryName("tailed_beast_bomb_particle_red"));
		}

		@OnlyIn(Dist.CLIENT)
		@SubscribeEvent
		public static void registerParticle(RegisterParticleProvidersEvent event) {
			Minecraft.getInstance().particleEngine.register(particle, CustomParticleFactory::new);
		}

		@OnlyIn(Dist.CLIENT)
		private static class CustomParticle extends SingleQuadParticle {
			private final SpriteSet spriteSet;

			protected CustomParticle(ClientLevel world, double x, double y, double z, double vx, double vy, double vz, SpriteSet spriteSet) {
				super(world, x, y, z);
				this.spriteSet = spriteSet;
				this.setSize((float) 0.2, (float) 0.2);
				this.quadSize *= (float) 1;
				this.lifetime = 4;
				this.gravity = (float) 0;
				this.hasPhysics = true;
				this.xd = vx * 1;
				this.yd = vy * 1;
				this.zd = vz * 1;
				this.pickSprite(spriteSet);
			}

			@Override
			public ParticleRenderType getRenderType() {
				return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
			}

			@Override
			public void tick() {
				super.tick();
			}
		}

		@OnlyIn(Dist.CLIENT)
		private static class CustomParticleFactory implements ParticleProvider<SimpleParticleType> {
			private final SpriteSet spriteSet;

			public CustomParticleFactory(SpriteSet spriteSet) {
				this.spriteSet = spriteSet;
			}

			public Particle createParticle(SimpleParticleType typeIn, ClientLevel worldIn, double x, double y, double z, double xSpeed, double ySpeed,
					double zSpeed) {
				return new CustomParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, this.spriteSet);
			}
		}
	}

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class VolticParticleParticle {
		public static final SimpleParticleType particle = new SimpleParticleType(false);

		@SubscribeEvent
		public static void registerParticleType(RegistryEvent.Register<ParticleType<?>> event) {
			event.getRegistry().register(particle.setRegistryName("voltic_particle"));
		}

		@OnlyIn(Dist.CLIENT)
		@SubscribeEvent
		public static void registerParticle(RegisterParticleProvidersEvent event) {
			Minecraft.getInstance().particleEngine.register(particle, CustomParticleFactory::new);
		}

		@OnlyIn(Dist.CLIENT)
		private static class CustomParticle extends SingleQuadParticle {
			private final SpriteSet spriteSet;

			protected CustomParticle(ClientLevel world, double x, double y, double z, double vx, double vy, double vz, SpriteSet spriteSet) {
				super(world, x, y, z);
				this.spriteSet = spriteSet;
				this.setSize((float) 0.2, (float) 0.2);
				this.quadSize *= (float) 3;
				this.lifetime = 100;
				this.gravity = (float) 0;
				this.hasPhysics = true;
				this.xd = vx * 1;
				this.yd = vy * 1;
				this.zd = vz * 1;
				this.setSpriteFromAge(spriteSet);
			}

			@Override
			public ParticleRenderType getRenderType() {
				return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
			}

			@Override
			public void tick() {
				super.tick();
				if (!this.removed) {
					this.setSprite(this.spriteSet.get((this.age / 5) % 3 + 1, 3));
				}
			}
		}

		@OnlyIn(Dist.CLIENT)
		private static class CustomParticleFactory implements ParticleProvider<SimpleParticleType> {
			private final SpriteSet spriteSet;

			public CustomParticleFactory(SpriteSet spriteSet) {
				this.spriteSet = spriteSet;
			}

			public Particle createParticle(SimpleParticleType typeIn, ClientLevel worldIn, double x, double y, double z, double xSpeed, double ySpeed,
					double zSpeed) {
				return new CustomParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, this.spriteSet);
			}
		}
	}
}
