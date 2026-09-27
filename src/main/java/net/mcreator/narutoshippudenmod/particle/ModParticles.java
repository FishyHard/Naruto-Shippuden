package net.mcreator.narutoshippudenmod.particle;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.IAnimatedSprite;
import net.minecraft.client.particle.IParticleFactory;
import net.minecraft.client.particle.IParticleRenderType;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.SpriteTexturedParticle;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particles.BasicParticleType;
import net.minecraft.particles.ParticleType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.ParticleFactoryRegisterEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public final class ModParticles {
	private ModParticles() {
	}

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class AmaterasuFireParticle {
		public static final BasicParticleType particle = new BasicParticleType(false);

		@SubscribeEvent
		public static void registerParticleType(RegistryEvent.Register<ParticleType<?>> event) {
			event.getRegistry().register(particle.setRegistryName("amaterasu_fire"));
		}

		@OnlyIn(Dist.CLIENT)
		@SubscribeEvent
		public static void registerParticle(ParticleFactoryRegisterEvent event) {
			Minecraft.getInstance().particles.registerFactory(particle, CustomParticleFactory::new);
		}

		@OnlyIn(Dist.CLIENT)
		private static class CustomParticle extends SpriteTexturedParticle {
			private final IAnimatedSprite spriteSet;

			protected CustomParticle(ClientWorld world, double x, double y, double z, double vx, double vy, double vz, IAnimatedSprite spriteSet) {
				super(world, x, y, z);
				this.spriteSet = spriteSet;
				this.setSize((float) 0.2, (float) 0.2);
				this.particleScale *= (float) 1;
				this.maxAge = 60;
				this.particleGravity = (float) 0;
				this.canCollide = false;
				this.motionX = vx * 1;
				this.motionY = vy * 1;
				this.motionZ = vz * 1;
				this.selectSpriteWithAge(spriteSet);
			}

			@Override
			public IParticleRenderType getRenderType() {
				return IParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
			}

			@Override
			public void tick() {
				super.tick();
				if (!this.isExpired) {
					this.setSprite(this.spriteSet.get((this.age / 2) % 32 + 1, 32));
				}
			}
		}

		@OnlyIn(Dist.CLIENT)
		private static class CustomParticleFactory implements IParticleFactory<BasicParticleType> {
			private final IAnimatedSprite spriteSet;

			public CustomParticleFactory(IAnimatedSprite spriteSet) {
				this.spriteSet = spriteSet;
			}

			public Particle makeParticle(BasicParticleType typeIn, ClientWorld worldIn, double x, double y, double z, double xSpeed, double ySpeed,
					double zSpeed) {
				return new CustomParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, this.spriteSet);
			}
		}
	}

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class AshParticle {
		public static final BasicParticleType particle = new BasicParticleType(false);

		@SubscribeEvent
		public static void registerParticleType(RegistryEvent.Register<ParticleType<?>> event) {
			event.getRegistry().register(particle.setRegistryName("ash"));
		}

		@OnlyIn(Dist.CLIENT)
		@SubscribeEvent
		public static void registerParticle(ParticleFactoryRegisterEvent event) {
			Minecraft.getInstance().particles.registerFactory(particle, CustomParticleFactory::new);
		}

		@OnlyIn(Dist.CLIENT)
		private static class CustomParticle extends SpriteTexturedParticle {
			private final IAnimatedSprite spriteSet;

			protected CustomParticle(ClientWorld world, double x, double y, double z, double vx, double vy, double vz, IAnimatedSprite spriteSet) {
				super(world, x, y, z);
				this.spriteSet = spriteSet;
				this.setSize((float) 0.2, (float) 0.2);
				this.particleScale *= (float) 30;
				this.maxAge = 20;
				this.particleGravity = (float) 0;
				this.canCollide = false;
				this.motionX = vx * 1;
				this.motionY = vy * 1;
				this.motionZ = vz * 1;
				this.selectSpriteWithAge(spriteSet);
			}

			@Override
			public IParticleRenderType getRenderType() {
				return IParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
			}

			@Override
			public void tick() {
				super.tick();
				if (!this.isExpired) {
					this.setSprite(this.spriteSet.get((this.age / 3) % 3 + 1, 3));
				}
			}
		}

		@OnlyIn(Dist.CLIENT)
		private static class CustomParticleFactory implements IParticleFactory<BasicParticleType> {
			private final IAnimatedSprite spriteSet;

			public CustomParticleFactory(IAnimatedSprite spriteSet) {
				this.spriteSet = spriteSet;
			}

			public Particle makeParticle(BasicParticleType typeIn, ClientWorld worldIn, double x, double y, double z, double xSpeed, double ySpeed,
					double zSpeed) {
				return new CustomParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, this.spriteSet);
			}
		}
	}

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class BlueSteamParticle {
		public static final BasicParticleType particle = new BasicParticleType(false);

		@SubscribeEvent
		public static void registerParticleType(RegistryEvent.Register<ParticleType<?>> event) {
			event.getRegistry().register(particle.setRegistryName("blue_steam"));
		}

		@OnlyIn(Dist.CLIENT)
		@SubscribeEvent
		public static void registerParticle(ParticleFactoryRegisterEvent event) {
			Minecraft.getInstance().particles.registerFactory(particle, CustomParticleFactory::new);
		}

		@OnlyIn(Dist.CLIENT)
		private static class CustomParticle extends SpriteTexturedParticle {
			private final IAnimatedSprite spriteSet;

			protected CustomParticle(ClientWorld world, double x, double y, double z, double vx, double vy, double vz, IAnimatedSprite spriteSet) {
				super(world, x, y, z);
				this.spriteSet = spriteSet;
				this.setSize((float) 0.2, (float) 0.2);
				this.particleScale *= (float) 3;
				this.maxAge = 25;
				this.particleGravity = (float) 0;
				this.canCollide = true;
				this.motionX = vx * 1;
				this.motionY = vy * 1;
				this.motionZ = vz * 1;
				this.selectSpriteWithAge(spriteSet);
			}

			@Override
			public IParticleRenderType getRenderType() {
				return IParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
			}

			@Override
			public void tick() {
				super.tick();
				if (!this.isExpired) {
					this.setSprite(this.spriteSet.get((this.age / 5) % 3 + 1, 3));
				}
			}
		}

		@OnlyIn(Dist.CLIENT)
		private static class CustomParticleFactory implements IParticleFactory<BasicParticleType> {
			private final IAnimatedSprite spriteSet;

			public CustomParticleFactory(IAnimatedSprite spriteSet) {
				this.spriteSet = spriteSet;
			}

			public Particle makeParticle(BasicParticleType typeIn, ClientWorld worldIn, double x, double y, double z, double xSpeed, double ySpeed,
					double zSpeed) {
				return new CustomParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, this.spriteSet);
			}
		}
	}

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class ChakraParticle {
		public static final BasicParticleType particle = new BasicParticleType(false);

		@SubscribeEvent
		public static void registerParticleType(RegistryEvent.Register<ParticleType<?>> event) {
			event.getRegistry().register(particle.setRegistryName("chakra"));
		}

		@OnlyIn(Dist.CLIENT)
		@SubscribeEvent
		public static void registerParticle(ParticleFactoryRegisterEvent event) {
			Minecraft.getInstance().particles.registerFactory(particle, CustomParticleFactory::new);
		}

		@OnlyIn(Dist.CLIENT)
		private static class CustomParticle extends SpriteTexturedParticle {
			private final IAnimatedSprite spriteSet;

			protected CustomParticle(ClientWorld world, double x, double y, double z, double vx, double vy, double vz, IAnimatedSprite spriteSet) {
				super(world, x, y, z);
				this.spriteSet = spriteSet;
				this.setSize((float) 0.2, (float) 0.2);
				this.particleScale *= (float) 1.5;
				this.maxAge = 29;
				this.particleGravity = (float) 0;
				this.canCollide = true;
				this.motionX = vx * 1;
				this.motionY = vy * 1;
				this.motionZ = vz * 1;
				this.selectSpriteWithAge(spriteSet);
			}

			@Override
			public IParticleRenderType getRenderType() {
				return IParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
			}

			@Override
			public void tick() {
				super.tick();
				if (!this.isExpired) {
					this.setSprite(this.spriteSet.get((this.age / 3) % 10 + 1, 10));
				}
			}
		}

		@OnlyIn(Dist.CLIENT)
		private static class CustomParticleFactory implements IParticleFactory<BasicParticleType> {
			private final IAnimatedSprite spriteSet;

			public CustomParticleFactory(IAnimatedSprite spriteSet) {
				this.spriteSet = spriteSet;
			}

			public Particle makeParticle(BasicParticleType typeIn, ClientWorld worldIn, double x, double y, double z, double xSpeed, double ySpeed,
					double zSpeed) {
				return new CustomParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, this.spriteSet);
			}
		}
	}

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class FlameParticle {
		public static final BasicParticleType particle = new BasicParticleType(false);

		@SubscribeEvent
		public static void registerParticleType(RegistryEvent.Register<ParticleType<?>> event) {
			event.getRegistry().register(particle.setRegistryName("flame"));
		}

		@OnlyIn(Dist.CLIENT)
		@SubscribeEvent
		public static void registerParticle(ParticleFactoryRegisterEvent event) {
			Minecraft.getInstance().particles.registerFactory(particle, CustomParticleFactory::new);
		}

		@OnlyIn(Dist.CLIENT)
		private static class CustomParticle extends SpriteTexturedParticle {
			private final IAnimatedSprite spriteSet;

			protected CustomParticle(ClientWorld world, double x, double y, double z, double vx, double vy, double vz, IAnimatedSprite spriteSet) {
				super(world, x, y, z);
				this.spriteSet = spriteSet;
				this.setSize((float) 0.2, (float) 0.2);
				this.particleScale *= (float) 5;
				this.maxAge = 100;
				this.particleGravity = (float) 0;
				this.canCollide = false;
				this.motionX = vx * 1;
				this.motionY = vy * 1;
				this.motionZ = vz * 1;
				this.selectSpriteWithAge(spriteSet);
			}

			@Override
			public IParticleRenderType getRenderType() {
				return IParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
			}

			@Override
			public void tick() {
				super.tick();
				if (!this.isExpired) {
					this.setSprite(this.spriteSet.get((this.age / 3) % 4 + 1, 4));
				}
			}
		}

		@OnlyIn(Dist.CLIENT)
		private static class CustomParticleFactory implements IParticleFactory<BasicParticleType> {
			private final IAnimatedSprite spriteSet;

			public CustomParticleFactory(IAnimatedSprite spriteSet) {
				this.spriteSet = spriteSet;
			}

			public Particle makeParticle(BasicParticleType typeIn, ClientWorld worldIn, double x, double y, double z, double xSpeed, double ySpeed,
					double zSpeed) {
				return new CustomParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, this.spriteSet);
			}
		}
	}

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class FuramingoganParticleParticle {
		public static final BasicParticleType particle = new BasicParticleType(false);

		@SubscribeEvent
		public static void registerParticleType(RegistryEvent.Register<ParticleType<?>> event) {
			event.getRegistry().register(particle.setRegistryName("furamingogan_particle"));
		}

		@OnlyIn(Dist.CLIENT)
		@SubscribeEvent
		public static void registerParticle(ParticleFactoryRegisterEvent event) {
			Minecraft.getInstance().particles.registerFactory(particle, CustomParticleFactory::new);
		}

		@OnlyIn(Dist.CLIENT)
		private static class CustomParticle extends SpriteTexturedParticle {
			private final IAnimatedSprite spriteSet;

			protected CustomParticle(ClientWorld world, double x, double y, double z, double vx, double vy, double vz, IAnimatedSprite spriteSet) {
				super(world, x, y, z);
				this.spriteSet = spriteSet;
				this.setSize((float) 0.2, (float) 0.2);
				this.particleScale *= (float) 3;
				this.maxAge = 100;
				this.particleGravity = (float) 0;
				this.canCollide = true;
				this.motionX = vx * 1;
				this.motionY = vy * 1;
				this.motionZ = vz * 1;
				this.selectSpriteWithAge(spriteSet);
			}

			@Override
			public IParticleRenderType getRenderType() {
				return IParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
			}

			@Override
			public void tick() {
				super.tick();
				if (!this.isExpired) {
					this.setSprite(this.spriteSet.get((this.age / 5) % 3 + 1, 3));
				}
			}
		}

		@OnlyIn(Dist.CLIENT)
		private static class CustomParticleFactory implements IParticleFactory<BasicParticleType> {
			private final IAnimatedSprite spriteSet;

			public CustomParticleFactory(IAnimatedSprite spriteSet) {
				this.spriteSet = spriteSet;
			}

			public Particle makeParticle(BasicParticleType typeIn, ClientWorld worldIn, double x, double y, double z, double xSpeed, double ySpeed,
					double zSpeed) {
				return new CustomParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, this.spriteSet);
			}
		}
	}

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class GreenSteamParticle {
		public static final BasicParticleType particle = new BasicParticleType(false);

		@SubscribeEvent
		public static void registerParticleType(RegistryEvent.Register<ParticleType<?>> event) {
			event.getRegistry().register(particle.setRegistryName("green_steam"));
		}

		@OnlyIn(Dist.CLIENT)
		@SubscribeEvent
		public static void registerParticle(ParticleFactoryRegisterEvent event) {
			Minecraft.getInstance().particles.registerFactory(particle, CustomParticleFactory::new);
		}

		@OnlyIn(Dist.CLIENT)
		private static class CustomParticle extends SpriteTexturedParticle {
			private final IAnimatedSprite spriteSet;

			protected CustomParticle(ClientWorld world, double x, double y, double z, double vx, double vy, double vz, IAnimatedSprite spriteSet) {
				super(world, x, y, z);
				this.spriteSet = spriteSet;
				this.setSize((float) 0.2, (float) 0.2);
				this.particleScale *= (float) 3;
				this.maxAge = 25;
				this.particleGravity = (float) 0;
				this.canCollide = true;
				this.motionX = vx * 1;
				this.motionY = vy * 1;
				this.motionZ = vz * 1;
				this.selectSpriteWithAge(spriteSet);
			}

			@Override
			public IParticleRenderType getRenderType() {
				return IParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
			}

			@Override
			public void tick() {
				super.tick();
				if (!this.isExpired) {
					this.setSprite(this.spriteSet.get((this.age / 5) % 3 + 1, 3));
				}
			}
		}

		@OnlyIn(Dist.CLIENT)
		private static class CustomParticleFactory implements IParticleFactory<BasicParticleType> {
			private final IAnimatedSprite spriteSet;

			public CustomParticleFactory(IAnimatedSprite spriteSet) {
				this.spriteSet = spriteSet;
			}

			public Particle makeParticle(BasicParticleType typeIn, ClientWorld worldIn, double x, double y, double z, double xSpeed, double ySpeed,
					double zSpeed) {
				return new CustomParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, this.spriteSet);
			}
		}
	}

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class KamuiParticleParticle {
		public static final BasicParticleType particle = new BasicParticleType(true);

		@SubscribeEvent
		public static void registerParticleType(RegistryEvent.Register<ParticleType<?>> event) {
			event.getRegistry().register(particle.setRegistryName("kamui_particle"));
		}

		@OnlyIn(Dist.CLIENT)
		@SubscribeEvent
		public static void registerParticle(ParticleFactoryRegisterEvent event) {
			Minecraft.getInstance().particles.registerFactory(particle, CustomParticleFactory::new);
		}

		@OnlyIn(Dist.CLIENT)
		private static class CustomParticle extends SpriteTexturedParticle {
			private final IAnimatedSprite spriteSet;

			protected CustomParticle(ClientWorld world, double x, double y, double z, double vx, double vy, double vz, IAnimatedSprite spriteSet) {
				super(world, x, y, z);
				this.spriteSet = spriteSet;
				this.setSize((float) 0.2, (float) 0.2);
				this.particleScale *= (float) 10;
				this.maxAge = 23;
				this.particleGravity = (float) 0;
				this.canCollide = false;
				this.motionX = vx * 1;
				this.motionY = vy * 1;
				this.motionZ = vz * 1;
				this.selectSpriteWithAge(spriteSet);
			}

			@Override
			public IParticleRenderType getRenderType() {
				return IParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
			}

			@Override
			public void tick() {
				super.tick();
				if (!this.isExpired) {
					this.setSprite(this.spriteSet.get((this.age / 3) % 8 + 1, 8));
				}
			}
		}

		@OnlyIn(Dist.CLIENT)
		private static class CustomParticleFactory implements IParticleFactory<BasicParticleType> {
			private final IAnimatedSprite spriteSet;

			public CustomParticleFactory(IAnimatedSprite spriteSet) {
				this.spriteSet = spriteSet;
			}

			public Particle makeParticle(BasicParticleType typeIn, ClientWorld worldIn, double x, double y, double z, double xSpeed, double ySpeed,
					double zSpeed) {
				return new CustomParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, this.spriteSet);
			}
		}
	}

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class LightningParticle {
		public static final BasicParticleType particle = new BasicParticleType(false);

		@SubscribeEvent
		public static void registerParticleType(RegistryEvent.Register<ParticleType<?>> event) {
			event.getRegistry().register(particle.setRegistryName("lightning"));
		}

		@OnlyIn(Dist.CLIENT)
		@SubscribeEvent
		public static void registerParticle(ParticleFactoryRegisterEvent event) {
			Minecraft.getInstance().particles.registerFactory(particle, CustomParticleFactory::new);
		}

		@OnlyIn(Dist.CLIENT)
		private static class CustomParticle extends SpriteTexturedParticle {
			private final IAnimatedSprite spriteSet;

			protected CustomParticle(ClientWorld world, double x, double y, double z, double vx, double vy, double vz, IAnimatedSprite spriteSet) {
				super(world, x, y, z);
				this.spriteSet = spriteSet;
				this.setSize((float) 0.2, (float) 0.2);
				this.particleScale *= (float) 5;
				this.maxAge = 20;
				this.particleGravity = (float) 0;
				this.canCollide = false;
				this.motionX = vx * 1;
				this.motionY = vy * 1;
				this.motionZ = vz * 1;
				this.selectSpriteWithAge(spriteSet);
			}

			@Override
			public IParticleRenderType getRenderType() {
				return IParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
			}

			@Override
			public void tick() {
				super.tick();
				if (!this.isExpired) {
					this.setSprite(this.spriteSet.get((this.age / 3) % 9 + 1, 9));
				}
			}
		}

		@OnlyIn(Dist.CLIENT)
		private static class CustomParticleFactory implements IParticleFactory<BasicParticleType> {
			private final IAnimatedSprite spriteSet;

			public CustomParticleFactory(IAnimatedSprite spriteSet) {
				this.spriteSet = spriteSet;
			}

			public Particle makeParticle(BasicParticleType typeIn, ClientWorld worldIn, double x, double y, double z, double xSpeed, double ySpeed,
					double zSpeed) {
				return new CustomParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, this.spriteSet);
			}
		}
	}

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class RedSteamParticle {
		public static final BasicParticleType particle = new BasicParticleType(false);

		@SubscribeEvent
		public static void registerParticleType(RegistryEvent.Register<ParticleType<?>> event) {
			event.getRegistry().register(particle.setRegistryName("red_steam"));
		}

		@OnlyIn(Dist.CLIENT)
		@SubscribeEvent
		public static void registerParticle(ParticleFactoryRegisterEvent event) {
			Minecraft.getInstance().particles.registerFactory(particle, CustomParticleFactory::new);
		}

		@OnlyIn(Dist.CLIENT)
		private static class CustomParticle extends SpriteTexturedParticle {
			private final IAnimatedSprite spriteSet;

			protected CustomParticle(ClientWorld world, double x, double y, double z, double vx, double vy, double vz, IAnimatedSprite spriteSet) {
				super(world, x, y, z);
				this.spriteSet = spriteSet;
				this.setSize((float) 0.2, (float) 0.2);
				this.particleScale *= (float) 3;
				this.maxAge = 25;
				this.particleGravity = (float) 0;
				this.canCollide = true;
				this.motionX = vx * 1;
				this.motionY = vy * 1;
				this.motionZ = vz * 1;
				this.selectSpriteWithAge(spriteSet);
			}

			@Override
			public IParticleRenderType getRenderType() {
				return IParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
			}

			@Override
			public void tick() {
				super.tick();
				if (!this.isExpired) {
					this.setSprite(this.spriteSet.get((this.age / 5) % 3 + 1, 3));
				}
			}
		}

		@OnlyIn(Dist.CLIENT)
		private static class CustomParticleFactory implements IParticleFactory<BasicParticleType> {
			private final IAnimatedSprite spriteSet;

			public CustomParticleFactory(IAnimatedSprite spriteSet) {
				this.spriteSet = spriteSet;
			}

			public Particle makeParticle(BasicParticleType typeIn, ClientWorld worldIn, double x, double y, double z, double xSpeed, double ySpeed,
					double zSpeed) {
				return new CustomParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, this.spriteSet);
			}
		}
	}

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class SmokeParticle {
		public static final BasicParticleType particle = new BasicParticleType(false);

		@SubscribeEvent
		public static void registerParticleType(RegistryEvent.Register<ParticleType<?>> event) {
			event.getRegistry().register(particle.setRegistryName("smoke"));
		}

		@OnlyIn(Dist.CLIENT)
		@SubscribeEvent
		public static void registerParticle(ParticleFactoryRegisterEvent event) {
			Minecraft.getInstance().particles.registerFactory(particle, CustomParticleFactory::new);
		}

		@OnlyIn(Dist.CLIENT)
		private static class CustomParticle extends SpriteTexturedParticle {
			private final IAnimatedSprite spriteSet;

			protected CustomParticle(ClientWorld world, double x, double y, double z, double vx, double vy, double vz, IAnimatedSprite spriteSet) {
				super(world, x, y, z);
				this.spriteSet = spriteSet;
				this.setSize((float) 0.2, (float) 0.2);
				this.particleScale *= (float) 30;
				this.maxAge = 132;
				this.particleGravity = (float) 0;
				this.canCollide = false;
				this.motionX = vx * 1;
				this.motionY = vy * 1;
				this.motionZ = vz * 1;
				this.selectSpriteWithAge(spriteSet);
			}

			@Override
			public IParticleRenderType getRenderType() {
				return IParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
			}

			@Override
			public void tick() {
				super.tick();
				if (!this.isExpired) {
					this.setSprite(this.spriteSet.get((this.age / 3) % 3 + 1, 3));
				}
			}
		}

		@OnlyIn(Dist.CLIENT)
		private static class CustomParticleFactory implements IParticleFactory<BasicParticleType> {
			private final IAnimatedSprite spriteSet;

			public CustomParticleFactory(IAnimatedSprite spriteSet) {
				this.spriteSet = spriteSet;
			}

			public Particle makeParticle(BasicParticleType typeIn, ClientWorld worldIn, double x, double y, double z, double xSpeed, double ySpeed,
					double zSpeed) {
				return new CustomParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, this.spriteSet);
			}
		}
	}

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class StormParticle {
		public static final BasicParticleType particle = new BasicParticleType(false);

		@SubscribeEvent
		public static void registerParticleType(RegistryEvent.Register<ParticleType<?>> event) {
			event.getRegistry().register(particle.setRegistryName("storm"));
		}

		@OnlyIn(Dist.CLIENT)
		@SubscribeEvent
		public static void registerParticle(ParticleFactoryRegisterEvent event) {
			Minecraft.getInstance().particles.registerFactory(particle, CustomParticleFactory::new);
		}

		@OnlyIn(Dist.CLIENT)
		private static class CustomParticle extends SpriteTexturedParticle {
			private final IAnimatedSprite spriteSet;

			protected CustomParticle(ClientWorld world, double x, double y, double z, double vx, double vy, double vz, IAnimatedSprite spriteSet) {
				super(world, x, y, z);
				this.spriteSet = spriteSet;
				this.setSize((float) 0.2, (float) 0.2);
				this.particleScale *= (float) 5;
				this.maxAge = 132;
				this.particleGravity = (float) 0;
				this.canCollide = false;
				this.motionX = vx * 1;
				this.motionY = vy * 1;
				this.motionZ = vz * 1;
				this.selectSpriteWithAge(spriteSet);
			}

			@Override
			public IParticleRenderType getRenderType() {
				return IParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
			}

			@Override
			public void tick() {
				super.tick();
				if (!this.isExpired) {
					this.setSprite(this.spriteSet.get((this.age / 3) % 9 + 1, 9));
				}
			}
		}

		@OnlyIn(Dist.CLIENT)
		private static class CustomParticleFactory implements IParticleFactory<BasicParticleType> {
			private final IAnimatedSprite spriteSet;

			public CustomParticleFactory(IAnimatedSprite spriteSet) {
				this.spriteSet = spriteSet;
			}

			public Particle makeParticle(BasicParticleType typeIn, ClientWorld worldIn, double x, double y, double z, double xSpeed, double ySpeed,
					double zSpeed) {
				return new CustomParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, this.spriteSet);
			}
		}
	}

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class TailedBeastBombParticleBlueParticle {
		public static final BasicParticleType particle = new BasicParticleType(false);

		@SubscribeEvent
		public static void registerParticleType(RegistryEvent.Register<ParticleType<?>> event) {
			event.getRegistry().register(particle.setRegistryName("tailed_beast_bomb_particle_blue"));
		}

		@OnlyIn(Dist.CLIENT)
		@SubscribeEvent
		public static void registerParticle(ParticleFactoryRegisterEvent event) {
			Minecraft.getInstance().particles.registerFactory(particle, CustomParticleFactory::new);
		}

		@OnlyIn(Dist.CLIENT)
		private static class CustomParticle extends SpriteTexturedParticle {
			private final IAnimatedSprite spriteSet;

			protected CustomParticle(ClientWorld world, double x, double y, double z, double vx, double vy, double vz, IAnimatedSprite spriteSet) {
				super(world, x, y, z);
				this.spriteSet = spriteSet;
				this.setSize((float) 0.2, (float) 0.2);
				this.particleScale *= (float) 1;
				this.maxAge = 4;
				this.particleGravity = (float) 0;
				this.canCollide = true;
				this.motionX = vx * 1;
				this.motionY = vy * 1;
				this.motionZ = vz * 1;
				this.selectSpriteRandomly(spriteSet);
			}

			@Override
			public IParticleRenderType getRenderType() {
				return IParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
			}

			@Override
			public void tick() {
				super.tick();
			}
		}

		@OnlyIn(Dist.CLIENT)
		private static class CustomParticleFactory implements IParticleFactory<BasicParticleType> {
			private final IAnimatedSprite spriteSet;

			public CustomParticleFactory(IAnimatedSprite spriteSet) {
				this.spriteSet = spriteSet;
			}

			public Particle makeParticle(BasicParticleType typeIn, ClientWorld worldIn, double x, double y, double z, double xSpeed, double ySpeed,
					double zSpeed) {
				return new CustomParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, this.spriteSet);
			}
		}
	}

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class TailedBeastBombParticleRedParticle {
		public static final BasicParticleType particle = new BasicParticleType(false);

		@SubscribeEvent
		public static void registerParticleType(RegistryEvent.Register<ParticleType<?>> event) {
			event.getRegistry().register(particle.setRegistryName("tailed_beast_bomb_particle_red"));
		}

		@OnlyIn(Dist.CLIENT)
		@SubscribeEvent
		public static void registerParticle(ParticleFactoryRegisterEvent event) {
			Minecraft.getInstance().particles.registerFactory(particle, CustomParticleFactory::new);
		}

		@OnlyIn(Dist.CLIENT)
		private static class CustomParticle extends SpriteTexturedParticle {
			private final IAnimatedSprite spriteSet;

			protected CustomParticle(ClientWorld world, double x, double y, double z, double vx, double vy, double vz, IAnimatedSprite spriteSet) {
				super(world, x, y, z);
				this.spriteSet = spriteSet;
				this.setSize((float) 0.2, (float) 0.2);
				this.particleScale *= (float) 1;
				this.maxAge = 4;
				this.particleGravity = (float) 0;
				this.canCollide = true;
				this.motionX = vx * 1;
				this.motionY = vy * 1;
				this.motionZ = vz * 1;
				this.selectSpriteRandomly(spriteSet);
			}

			@Override
			public IParticleRenderType getRenderType() {
				return IParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
			}

			@Override
			public void tick() {
				super.tick();
			}
		}

		@OnlyIn(Dist.CLIENT)
		private static class CustomParticleFactory implements IParticleFactory<BasicParticleType> {
			private final IAnimatedSprite spriteSet;

			public CustomParticleFactory(IAnimatedSprite spriteSet) {
				this.spriteSet = spriteSet;
			}

			public Particle makeParticle(BasicParticleType typeIn, ClientWorld worldIn, double x, double y, double z, double xSpeed, double ySpeed,
					double zSpeed) {
				return new CustomParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, this.spriteSet);
			}
		}
	}

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class VolticParticleParticle {
		public static final BasicParticleType particle = new BasicParticleType(false);

		@SubscribeEvent
		public static void registerParticleType(RegistryEvent.Register<ParticleType<?>> event) {
			event.getRegistry().register(particle.setRegistryName("voltic_particle"));
		}

		@OnlyIn(Dist.CLIENT)
		@SubscribeEvent
		public static void registerParticle(ParticleFactoryRegisterEvent event) {
			Minecraft.getInstance().particles.registerFactory(particle, CustomParticleFactory::new);
		}

		@OnlyIn(Dist.CLIENT)
		private static class CustomParticle extends SpriteTexturedParticle {
			private final IAnimatedSprite spriteSet;

			protected CustomParticle(ClientWorld world, double x, double y, double z, double vx, double vy, double vz, IAnimatedSprite spriteSet) {
				super(world, x, y, z);
				this.spriteSet = spriteSet;
				this.setSize((float) 0.2, (float) 0.2);
				this.particleScale *= (float) 3;
				this.maxAge = 100;
				this.particleGravity = (float) 0;
				this.canCollide = true;
				this.motionX = vx * 1;
				this.motionY = vy * 1;
				this.motionZ = vz * 1;
				this.selectSpriteWithAge(spriteSet);
			}

			@Override
			public IParticleRenderType getRenderType() {
				return IParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
			}

			@Override
			public void tick() {
				super.tick();
				if (!this.isExpired) {
					this.setSprite(this.spriteSet.get((this.age / 5) % 3 + 1, 3));
				}
			}
		}

		@OnlyIn(Dist.CLIENT)
		private static class CustomParticleFactory implements IParticleFactory<BasicParticleType> {
			private final IAnimatedSprite spriteSet;

			public CustomParticleFactory(IAnimatedSprite spriteSet) {
				this.spriteSet = spriteSet;
			}

			public Particle makeParticle(BasicParticleType typeIn, ClientWorld worldIn, double x, double y, double z, double xSpeed, double ySpeed,
					double zSpeed) {
				return new CustomParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, this.spriteSet);
			}
		}
	}
}
