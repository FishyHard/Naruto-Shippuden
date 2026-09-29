package net.mcreator.narutoshippudenmod.procedures;

import net.mcreator.narutoshippudenmod.compat.Compat;
import net.minecraft.util.RandomSource;
import net.minecraft.core.registries.Registries;
import net.mcreator.narutoshippudenmod.compat.Registration;
import net.mcreator.narutoshippudenmod.compat.ModArrow;
import net.neoforged.neoforge.event.tick.ServerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;
import net.mcreator.narutoshippudenmod.NarutoShippudenMod;
import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables;
import net.mcreator.narutoshippudenmod.core.EntityScale;
import net.mcreator.narutoshippudenmod.core.ModelSwapRenderers;
import net.mcreator.narutoshippudenmod.entity.JutsuEntities.DisruptionCubeEntity;
import net.mcreator.narutoshippudenmod.entity.SummonEntities.CrowEntity;
import net.mcreator.narutoshippudenmod.item.DojutsuItems.ByakuganReleaseItem;
import net.mcreator.narutoshippudenmod.item.DojutsuItems.CoercionSharinganItem;
import net.mcreator.narutoshippudenmod.item.DojutsuItems.IsshikiDojutsuReleaseItem;
import net.mcreator.narutoshippudenmod.item.DojutsuItems.KetsuryuganReleaseItem;
import net.mcreator.narutoshippudenmod.item.DojutsuItems.MangekyouSharinganItachiReleaseItem;
import net.mcreator.narutoshippudenmod.item.DojutsuItems.MangekyouSharinganKakashiReleaseItem;
import net.mcreator.narutoshippudenmod.item.DojutsuItems.MangekyouSharinganMadaraReleaseItem;
import net.mcreator.narutoshippudenmod.item.DojutsuItems.MangekyouSharinganObitoReleaseItem;
import net.mcreator.narutoshippudenmod.item.DojutsuItems.MangekyouSharinganSasukeReleaseItem;
import net.mcreator.narutoshippudenmod.item.DojutsuItems.MangekyouSharinganShisuiReleaseItem;
import net.mcreator.narutoshippudenmod.item.DojutsuItems.RinneganReleaseItem;
import net.mcreator.narutoshippudenmod.item.DojutsuItems.SharinganReleaseItem;
import net.mcreator.narutoshippudenmod.item.DojutsuItems.TenseiganReleaseItem;
import net.mcreator.narutoshippudenmod.item.JutsuProjectileItems.AmaterasuFlameItem;
import net.mcreator.narutoshippudenmod.item.JutsuProjectileItems.BladeOfLightningItem;
import net.mcreator.narutoshippudenmod.item.JutsuProjectileItems.DemonicIllusionShacklingStakesTechniqueItem;
import net.mcreator.narutoshippudenmod.item.MissionItems.LetterFromBrotherItem;
import net.mcreator.narutoshippudenmod.item.TechniqueItems.IsshikiDojutsuReleaseTechniqueItem;
import net.mcreator.narutoshippudenmod.item.TechniqueItems.MangekyouSharinganItachiReleaseTechniqueItem;
import net.mcreator.narutoshippudenmod.item.TechniqueItems.MangekyouSharinganKakashiReleaseTechniqueItem;
import net.mcreator.narutoshippudenmod.item.TechniqueItems.MangekyouSharinganObitoReleaseTechniqueItem;
import net.mcreator.narutoshippudenmod.item.TechniqueItems.MangekyouSharinganSasukeReleaseTechniqueItem;
import net.mcreator.narutoshippudenmod.item.TechniqueItems.SharinganReleaseTechniqueItem;
import net.mcreator.narutoshippudenmod.particle.ModParticles.AmaterasuFireParticle;
import net.mcreator.narutoshippudenmod.particle.ModParticles.KamuiParticleParticle;
import net.mcreator.narutoshippudenmod.potion.ModEffects.CoercionSharinganEffectPotionEffect;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.entity.player.AvatarRenderer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.player.Player;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.projectile.arrow.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.phys.AABB;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.level.ClipContext;
import net.minecraft.core.Registry;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.server.level.ServerLevel;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.client.event.RenderLivingEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.minecraft.core.registries.BuiltInRegistries;

public final class DojutsuProcedures {
	private DojutsuProcedures() {
	}

	public static class ByakuganAwake10SecondsProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("world") == null) {
				if (!dependencies.containsKey("world"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure ByakuganAwake10Seconds!");
				return;
			}
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure ByakuganAwake10Seconds!");
				return;
			}
			LevelAccessor world = (LevelAccessor) dependencies.get("world");
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).byakugan == false) {
				new Object() {
					private int ticks = 0;
					private float waitTicks;
					private LevelAccessor world;

					public void start(LevelAccessor world, int waitTicks) {
						this.waitTicks = waitTicks;
						Registration.listen(NeoForge.EVENT_BUS, this);
						this.world = world;
					}

					@SubscribeEvent
					public void tick(ServerTickEvent.Post event) {
						if (true) {
							this.ticks += 1;
							if (this.ticks >= this.waitTicks)
								run();
						}
					}

					private void run() {
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendSystemMessage(Component.literal(
									"You feel that the blood of the Hyuga clan flows in your veins, you have awakened the Byakugan"));
						}
						{
							String _setval = "1x1";
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.dojutsubyakugan = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof Player) {
							ItemStack _setstack = new ItemStack(ByakuganReleaseItem.block);
							_setstack.setCount((int) 1);
							Compat.giveItemToPlayer(((Player) entity), _setstack);
						}
						{
							boolean _setval = (true);
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.byakugan = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						NeoForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 200);
			} else if (NarutoShippudenModVariables.get(entity).byakugan == true) {
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendSystemMessage(Component.literal("You've already unlocked byakugan."));
				}
			}
		}
	}

	public static class ByakuganAwakeProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure ByakuganAwake!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (entity instanceof Player && !entity.level().isClientSide()) {
				((Player) entity).sendSystemMessage(
						Component.literal("You feel that the blood of the Hyuga clan flows in your veins, you have awakened the Byakugan"));
			}
			{
				String _setval = "1x1";
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.dojutsubyakugan = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof Player) {
				ItemStack _setstack = new ItemStack(ByakuganReleaseItem.block);
				_setstack.setCount((int) 1);
				Compat.giveItemToPlayer(((Player) entity), _setstack);
			}
			{
				boolean _setval = (true);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.byakugan = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}

	public static class CoercionSharinganProjectileHitsLivingEntityProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("world") == null) {
				if (!dependencies.containsKey("world"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure CoercionSharinganProjectileHitsLivingEntity!");
				return;
			}
			if (dependencies.get("x") == null) {
				if (!dependencies.containsKey("x"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency x for procedure CoercionSharinganProjectileHitsLivingEntity!");
				return;
			}
			if (dependencies.get("y") == null) {
				if (!dependencies.containsKey("y"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency y for procedure CoercionSharinganProjectileHitsLivingEntity!");
				return;
			}
			if (dependencies.get("z") == null) {
				if (!dependencies.containsKey("z"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency z for procedure CoercionSharinganProjectileHitsLivingEntity!");
				return;
			}
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure CoercionSharinganProjectileHitsLivingEntity!");
				return;
			}
			LevelAccessor world = (LevelAccessor) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			Entity entity = (Entity) dependencies.get("entity");
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.BLINDNESS, (int) 100, (int) 3, (false), (false)));
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.SLOWNESS, (int) 100, (int) 1, (false), (false)));
			if (entity instanceof LivingEntity)
				((LivingEntity) entity)
						.addEffect(new MobEffectInstance(CoercionSharinganEffectPotionEffect.potion, (int) 100, (int) 1, (false), (false)));
			if (world instanceof Level && !world.isClientSide()) {
				((Level) world).playSound(null, BlockPos.containing(x, y, z),
						Compat.sound("naruto_shippuden:sharingan"),
						SoundSource.NEUTRAL, (float) 1, (float) 1);
			} else {
				((Level) world).playLocalSound(x, y, z,
						Compat.sound("naruto_shippuden:sharingan"),
						SoundSource.NEUTRAL, (float) 1, (float) 1, false);
			}
			if (world.isClientSide()) {
				Minecraft.getInstance().player.displayItemActivation(new ItemStack(SharinganReleaseTechniqueItem.block));
			}
		}
	}

	public static class DojutsuRendererProcedure {
		@EventBusSubscriber(modid = "naruto_shippuden", value = net.neoforged.api.distmarker.Dist.CLIENT)
		private static class GlobalTrigger {
			@SubscribeEvent
			public static void KleidersRenderEvent(RenderLivingEvent.Pre event) {
				Entity entity = ModelSwapRenderers.entity(event);
			if (entity == null)
				return;
				Level world = entity.level();
				double i = entity.getX();
				double j = entity.getY();
				double k = entity.getZ();
				Map<String, Object> dependencies = new HashMap<>();
				dependencies.put("x", i);
				dependencies.put("y", j);
				dependencies.put("z", k);
				dependencies.put("world", world);
				dependencies.put("entity", entity);
				dependencies.put("event", event);
				executeProcedure(dependencies);
			}
		}

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DojutsuRenderer!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");

			// Enter the FTL code here
			Object _obj = dependencies.get("event");
			RenderLivingEvent _evt = (RenderLivingEvent) _obj;
			if (NarutoShippudenModVariables.get(entity).byakugan == true) {
				if (NarutoShippudenModVariables.get(entity).byakuganactivate == true) {
					if ((NarutoShippudenModVariables.get(entity).dojutsubyakugan).equals("1x1")) {
						if (_evt.getRenderer() instanceof AvatarRenderer) {
							if (_evt instanceof RenderLivingEvent.Pre) {
								//  _evt.setCanceled(true); 
							}
							ModelSwapRenderers.renderDojutsu(_evt, "naruto_shippuden:textures/dojutsu/byakugan/byakugan_2x1_pupils_1x1.png");
						}
					} else if ((NarutoShippudenModVariables.get(entity).dojutsubyakugan).equals("2x1")) {
						if (_evt.getRenderer() instanceof AvatarRenderer) {
							if (_evt instanceof RenderLivingEvent.Pre) {
								//  _evt.setCanceled(true); 
							}
							ModelSwapRenderers.renderDojutsu(_evt, "naruto_shippuden:textures/dojutsu/byakugan/byakugan_2x1_pupils_2x1.png");
						}
					} else if ((NarutoShippudenModVariables.get(entity).dojutsubyakugan).equals("1x2")) {
						if (_evt.getRenderer() instanceof AvatarRenderer) {
							if (_evt instanceof RenderLivingEvent.Pre) {
								//  _evt.setCanceled(true); 
							}
							ModelSwapRenderers.renderDojutsu(_evt, "naruto_shippuden:textures/dojutsu/byakugan/byakugan_2x2_pupils_1x1.png");
						}
					} else if ((NarutoShippudenModVariables.get(entity).dojutsubyakugan).equals("2x2")) {
						if (_evt.getRenderer() instanceof AvatarRenderer) {
							if (_evt instanceof RenderLivingEvent.Pre) {
								//  _evt.setCanceled(true); 
							}
							ModelSwapRenderers.renderDojutsu(_evt, "naruto_shippuden:textures/dojutsu/byakugan/byakugan_2x2_pupils_1x2.png");
						}
					}
				} else if (NarutoShippudenModVariables.get(entity).byakuganactivate == false) {
					if ((NarutoShippudenModVariables.get(entity).dojutsubyakugan).equals("1x1")) {
						if (_evt.getRenderer() instanceof AvatarRenderer) {
							if (_evt instanceof RenderLivingEvent.Pre) {
								//  _evt.setCanceled(true); 
							}
							ModelSwapRenderers.renderDojutsu(_evt, "naruto_shippuden:textures/dojutsu/byakugan/byakugan_2x1_pupils_1x1_not_active.png");
						}
					} else if ((NarutoShippudenModVariables.get(entity).dojutsubyakugan).equals("2x1")) {
						if (_evt.getRenderer() instanceof AvatarRenderer) {
							if (_evt instanceof RenderLivingEvent.Pre) {
								//  _evt.setCanceled(true); 
							}
							ModelSwapRenderers.renderDojutsu(_evt, "naruto_shippuden:textures/dojutsu/byakugan/byakugan_2x1_pupils_2x1_not_active.png");
						}
					} else if ((NarutoShippudenModVariables.get(entity).dojutsubyakugan).equals("1x2")) {
						if (_evt.getRenderer() instanceof AvatarRenderer) {
							if (_evt instanceof RenderLivingEvent.Pre) {
								//  _evt.setCanceled(true); 
							}
							ModelSwapRenderers.renderDojutsu(_evt, "naruto_shippuden:textures/dojutsu/byakugan/byakugan_2x2_pupils_1x1_not_active.png");
						}
					} else if ((NarutoShippudenModVariables.get(entity).dojutsubyakugan).equals("2x2")) {
						if (_evt.getRenderer() instanceof AvatarRenderer) {
							if (_evt instanceof RenderLivingEvent.Pre) {
								//  _evt.setCanceled(true); 
							}
							ModelSwapRenderers.renderDojutsu(_evt, "naruto_shippuden:textures/dojutsu/byakugan/byakugan_2x2_pupils_1x2_not_active.png");
						}
					}
				}
			}
			if (NarutoShippudenModVariables.get(entity).ketsuryuganactivate == true) {
				if ((NarutoShippudenModVariables.get(entity).dojutsuketsuryugan).equals("1x1")) {
					if (_evt.getRenderer() instanceof AvatarRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						ModelSwapRenderers.renderDojutsu(_evt, "naruto_shippuden:textures/dojutsu/ketsuryugan/ketsuryugan_2x1_pupils_1x1.png");
					}
				} else if ((NarutoShippudenModVariables.get(entity).dojutsuketsuryugan).equals("2x1")) {
					if (_evt.getRenderer() instanceof AvatarRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						ModelSwapRenderers.renderDojutsu(_evt, "naruto_shippuden:textures/dojutsu/ketsuryugan/ketsuryugan_2x1_pupils_2x1.png");
					}
				} else if ((NarutoShippudenModVariables.get(entity).dojutsuketsuryugan).equals("1x2")) {
					if (_evt.getRenderer() instanceof AvatarRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						ModelSwapRenderers.renderDojutsu(_evt, "naruto_shippuden:textures/dojutsu/ketsuryugan/ketsuryugan_2x2_pupils_1x1.png");
					}
				} else if ((NarutoShippudenModVariables.get(entity).dojutsuketsuryugan).equals("2x2")) {
					if (_evt.getRenderer() instanceof AvatarRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						ModelSwapRenderers.renderDojutsu(_evt, "naruto_shippuden:textures/dojutsu/ketsuryugan/ketsuryugan_2x2_pupils_1x2.png");
					}
				}
			}
			if (NarutoShippudenModVariables.get(entity).sharinganactivate == true) {
				if (NarutoShippudenModVariables.get(entity).sharingan == true) {
					if ((NarutoShippudenModVariables.get(entity).dojutsusharingan).equals("1x1")) {
						if (_evt.getRenderer() instanceof AvatarRenderer) {
							if (_evt instanceof RenderLivingEvent.Pre) {
								//  _evt.setCanceled(true); 
							}
							ModelSwapRenderers.renderDojutsu(_evt, "naruto_shippuden:textures/dojutsu/sharingan/sharingan2px1px.png");
						}
					} else if ((NarutoShippudenModVariables.get(entity).dojutsusharingan).equals("2x1")) {
						if (_evt.getRenderer() instanceof AvatarRenderer) {
							if (_evt instanceof RenderLivingEvent.Pre) {
								//  _evt.setCanceled(true); 
							}
							ModelSwapRenderers.renderDojutsu(_evt, "naruto_shippuden:textures/dojutsu/sharingan/sharingan2px1px2.png");
						}
					} else if ((NarutoShippudenModVariables.get(entity).dojutsusharingan).equals("1x2")) {
						if (_evt.getRenderer() instanceof AvatarRenderer) {
							if (_evt instanceof RenderLivingEvent.Pre) {
								//  _evt.setCanceled(true); 
							}
							ModelSwapRenderers.renderDojutsu(_evt, "naruto_shippuden:textures/dojutsu/sharingan/sharingan2px2px2.png");
						}
					} else if ((NarutoShippudenModVariables.get(entity).dojutsusharingan).equals("2x2")) {
						if (_evt.getRenderer() instanceof AvatarRenderer) {
							if (_evt instanceof RenderLivingEvent.Pre) {
								//  _evt.setCanceled(true); 
							}
							ModelSwapRenderers.renderDojutsu(_evt, "naruto_shippuden:textures/dojutsu/sharingan/sharingan2px2px1.png");
						}
					}
				}
				if (NarutoShippudenModVariables.get(entity).SharinganKakashi == true) {
					if ((NarutoShippudenModVariables.get(entity).dojutsusharingan).equals("1x1")) {
						if (_evt.getRenderer() instanceof AvatarRenderer) {
							if (_evt instanceof RenderLivingEvent.Pre) {
								//  _evt.setCanceled(true); 
							}
							ModelSwapRenderers.renderDojutsu(_evt, "naruto_shippuden:textures/dojutsu/sharingan/kakashi/kakashisharingan2px1px.png");
						}
					} else if ((NarutoShippudenModVariables.get(entity).dojutsusharingan).equals("2x1")) {
						if (_evt.getRenderer() instanceof AvatarRenderer) {
							if (_evt instanceof RenderLivingEvent.Pre) {
								//  _evt.setCanceled(true); 
							}
							ModelSwapRenderers.renderDojutsu(_evt, "naruto_shippuden:textures/dojutsu/sharingan/kakashi/kakashisharingan2px1px2.png");
						}
					} else if ((NarutoShippudenModVariables.get(entity).dojutsusharingan).equals("1x2")) {
						if (_evt.getRenderer() instanceof AvatarRenderer) {
							if (_evt instanceof RenderLivingEvent.Pre) {
								//  _evt.setCanceled(true); 
							}
							ModelSwapRenderers.renderDojutsu(_evt, "naruto_shippuden:textures/dojutsu/sharingan/kakashi/kakashisharingan2px2px2.png");
						}
					} else if ((NarutoShippudenModVariables.get(entity).dojutsusharingan).equals("2x2")) {
						if (_evt.getRenderer() instanceof AvatarRenderer) {
							if (_evt instanceof RenderLivingEvent.Pre) {
								//  _evt.setCanceled(true); 
							}
							ModelSwapRenderers.renderDojutsu(_evt, "naruto_shippuden:textures/dojutsu/sharingan/kakashi/kakashisharingan2px2px1.png");
						}
					}
				}
			}
			if (NarutoShippudenModVariables.get(entity).MangekyouSharinganActivate == true) {
				if (NarutoShippudenModVariables.get(entity).MangekyouSharinganSasuke == true) {
					if ((NarutoShippudenModVariables.get(entity).dojutsums).equals("1x1")) {
						if (_evt.getRenderer() instanceof AvatarRenderer) {
							if (_evt instanceof RenderLivingEvent.Pre) {
								//  _evt.setCanceled(true); 
							}
							ModelSwapRenderers.renderDojutsu(_evt, "naruto_shippuden:textures/dojutsu/mangekyou_sharingan/sasuke/sasukemangekyo2px1px.png");
						}
					} else if ((NarutoShippudenModVariables.get(entity).dojutsums).equals("2x1")) {
						if (_evt.getRenderer() instanceof AvatarRenderer) {
							if (_evt instanceof RenderLivingEvent.Pre) {
								//  _evt.setCanceled(true); 
							}
							ModelSwapRenderers.renderDojutsu(_evt, "naruto_shippuden:textures/dojutsu/mangekyou_sharingan/sasuke/sasukemangekyo2px1px2.png");
						}
					} else if ((NarutoShippudenModVariables.get(entity).dojutsums).equals("1x2")) {
						if (_evt.getRenderer() instanceof AvatarRenderer) {
							if (_evt instanceof RenderLivingEvent.Pre) {
								//  _evt.setCanceled(true); 
							}
							ModelSwapRenderers.renderDojutsu(_evt, "naruto_shippuden:textures/dojutsu/mangekyou_sharingan/sasuke/sasukemangekyo2px2px2.png");
						}
					} else if ((NarutoShippudenModVariables.get(entity).dojutsums).equals("2x2")) {
						if (_evt.getRenderer() instanceof AvatarRenderer) {
							if (_evt instanceof RenderLivingEvent.Pre) {
								//  _evt.setCanceled(true); 
							}
							ModelSwapRenderers.renderDojutsu(_evt, "naruto_shippuden:textures/dojutsu/mangekyou_sharingan/sasuke/sasukemangekyo2px2px1.png");
						}
					}
				} else if (NarutoShippudenModVariables.get(entity).MangekyouSharinganItachi == true) {
					if ((NarutoShippudenModVariables.get(entity).dojutsums).equals("1x1")) {
						if (_evt.getRenderer() instanceof AvatarRenderer) {
							if (_evt instanceof RenderLivingEvent.Pre) {
								//  _evt.setCanceled(true); 
							}
							ModelSwapRenderers.renderDojutsu(_evt, "naruto_shippuden:textures/dojutsu/mangekyou_sharingan/itachi/itachimangekyo2px1px.png");
						}
					} else if ((NarutoShippudenModVariables.get(entity).dojutsums).equals("2x1")) {
						if (_evt.getRenderer() instanceof AvatarRenderer) {
							if (_evt instanceof RenderLivingEvent.Pre) {
								//  _evt.setCanceled(true); 
							}
							ModelSwapRenderers.renderDojutsu(_evt, "naruto_shippuden:textures/dojutsu/mangekyou_sharingan/itachi/itachimangekyo2px1px2.png");
						}
					} else if ((NarutoShippudenModVariables.get(entity).dojutsums).equals("1x2")) {
						if (_evt.getRenderer() instanceof AvatarRenderer) {
							if (_evt instanceof RenderLivingEvent.Pre) {
								//  _evt.setCanceled(true); 
							}
							ModelSwapRenderers.renderDojutsu(_evt, "naruto_shippuden:textures/dojutsu/mangekyou_sharingan/itachi/itachimangekyo2px2px2.png");
						}
					} else if ((NarutoShippudenModVariables.get(entity).dojutsums).equals("2x2")) {
						if (_evt.getRenderer() instanceof AvatarRenderer) {
							if (_evt instanceof RenderLivingEvent.Pre) {
								//  _evt.setCanceled(true); 
							}
							ModelSwapRenderers.renderDojutsu(_evt, "naruto_shippuden:textures/dojutsu/mangekyou_sharingan/itachi/itachimangekyo2px2px1.png");
						}
					}
				} else if (NarutoShippudenModVariables.get(entity).MangekyouSharinganMadara == true) {
					if ((NarutoShippudenModVariables.get(entity).dojutsums).equals("1x1")) {
						if (_evt.getRenderer() instanceof AvatarRenderer) {
							if (_evt instanceof RenderLivingEvent.Pre) {
								//  _evt.setCanceled(true); 
							}
							ModelSwapRenderers.renderDojutsu(_evt, "naruto_shippuden:textures/dojutsu/mangekyou_sharingan/madara/madaramangekyo2px1px.png");
						}
					} else if ((NarutoShippudenModVariables.get(entity).dojutsums).equals("2x1")) {
						if (_evt.getRenderer() instanceof AvatarRenderer) {
							if (_evt instanceof RenderLivingEvent.Pre) {
								//  _evt.setCanceled(true); 
							}
							ModelSwapRenderers.renderDojutsu(_evt, "naruto_shippuden:textures/dojutsu/mangekyou_sharingan/madara/madaramangekyo2px1px2.png");
						}
					} else if ((NarutoShippudenModVariables.get(entity).dojutsums).equals("1x2")) {
						if (_evt.getRenderer() instanceof AvatarRenderer) {
							if (_evt instanceof RenderLivingEvent.Pre) {
								//  _evt.setCanceled(true); 
							}
							ModelSwapRenderers.renderDojutsu(_evt, "naruto_shippuden:textures/dojutsu/mangekyou_sharingan/madara/madaramangekyo2px2px2.png");
						}
					} else if ((NarutoShippudenModVariables.get(entity).dojutsums).equals("2x2")) {
						if (_evt.getRenderer() instanceof AvatarRenderer) {
							if (_evt instanceof RenderLivingEvent.Pre) {
								//  _evt.setCanceled(true); 
							}
							ModelSwapRenderers.renderDojutsu(_evt, "naruto_shippuden:textures/dojutsu/mangekyou_sharingan/madara/madaramangekyo2px2px1.png");
						}
					}
				} else if (NarutoShippudenModVariables.get(entity).MangekyouSharinganObito == true) {
					if ((NarutoShippudenModVariables.get(entity).dojutsums).equals("1x1")) {
						if (_evt.getRenderer() instanceof AvatarRenderer) {
							if (_evt instanceof RenderLivingEvent.Pre) {
								//  _evt.setCanceled(true); 
							}
							ModelSwapRenderers.renderDojutsu(_evt, "naruto_shippuden:textures/dojutsu/mangekyou_sharingan/obito/obitomangekyo2px1px.png");
						}
					} else if ((NarutoShippudenModVariables.get(entity).dojutsums).equals("2x1")) {
						if (_evt.getRenderer() instanceof AvatarRenderer) {
							if (_evt instanceof RenderLivingEvent.Pre) {
								//  _evt.setCanceled(true); 
							}
							ModelSwapRenderers.renderDojutsu(_evt, "naruto_shippuden:textures/dojutsu/mangekyou_sharingan/obito/obitomangekyo2px1px2");
						}
					} else if ((NarutoShippudenModVariables.get(entity).dojutsums).equals("1x2")) {
						if (_evt.getRenderer() instanceof AvatarRenderer) {
							if (_evt instanceof RenderLivingEvent.Pre) {
								//  _evt.setCanceled(true); 
							}
							ModelSwapRenderers.renderDojutsu(_evt, "naruto_shippuden:textures/dojutsu/mangekyou_sharingan/obito/obitomangekyo2px2px2.png");
						}
					} else if ((NarutoShippudenModVariables.get(entity).dojutsums).equals("2x2")) {
						if (_evt.getRenderer() instanceof AvatarRenderer) {
							if (_evt instanceof RenderLivingEvent.Pre) {
								//  _evt.setCanceled(true); 
							}
							ModelSwapRenderers.renderDojutsu(_evt, "naruto_shippuden:textures/dojutsu/mangekyou_sharingan/obito/obitomangekyo2px2px1.png");
						}
					}
				} else if (NarutoShippudenModVariables.get(entity).MangekyouSharinganShisui == true) {
					if ((NarutoShippudenModVariables.get(entity).dojutsums).equals("1x1")) {
						if (_evt.getRenderer() instanceof AvatarRenderer) {
							if (_evt instanceof RenderLivingEvent.Pre) {
								//  _evt.setCanceled(true); 
							}
							ModelSwapRenderers.renderDojutsu(_evt, "naruto_shippuden:textures/dojutsu/mangekyou_sharingan/shisui/shisuimangekyo2px1px.png");
						}
					} else if ((NarutoShippudenModVariables.get(entity).dojutsums).equals("2x1")) {
						if (_evt.getRenderer() instanceof AvatarRenderer) {
							if (_evt instanceof RenderLivingEvent.Pre) {
								//  _evt.setCanceled(true); 
							}
							ModelSwapRenderers.renderDojutsu(_evt, "naruto_shippuden:textures/dojutsu/mangekyou_sharingan/shisui/shisuimangekyo2px1px2.png");
						}
					} else if ((NarutoShippudenModVariables.get(entity).dojutsums).equals("1x2")) {
						if (_evt.getRenderer() instanceof AvatarRenderer) {
							if (_evt instanceof RenderLivingEvent.Pre) {
								//  _evt.setCanceled(true); 
							}
							ModelSwapRenderers.renderDojutsu(_evt, "naruto_shippuden:textures/dojutsu/mangekyou_sharingan/shisui/shisuimangekyo2px2px2.png");
						}
					} else if ((NarutoShippudenModVariables.get(entity).dojutsums).equals("2x2")) {
						if (_evt.getRenderer() instanceof AvatarRenderer) {
							if (_evt instanceof RenderLivingEvent.Pre) {
								//  _evt.setCanceled(true); 
							}
							ModelSwapRenderers.renderDojutsu(_evt, "naruto_shippuden:textures/dojutsu/mangekyou_sharingan/shisui/shisuimangekyo2px2px1.png");
						}
					}
				} else if (NarutoShippudenModVariables.get(entity).MangekyouSharinganKakashi == true) {
					if ((NarutoShippudenModVariables.get(entity).dojutsums).equals("1x1")) {
						if (_evt.getRenderer() instanceof AvatarRenderer) {
							if (_evt instanceof RenderLivingEvent.Pre) {
								//  _evt.setCanceled(true); 
							}
							ModelSwapRenderers.renderDojutsu(_evt, "naruto_shippuden:textures/dojutsu/mangekyou_sharingan/kakashi/kakashimangekyo2px1px.png");
						}
					} else if ((NarutoShippudenModVariables.get(entity).dojutsums).equals("2x1")) {
						if (_evt.getRenderer() instanceof AvatarRenderer) {
							if (_evt instanceof RenderLivingEvent.Pre) {
								//  _evt.setCanceled(true); 
							}
							ModelSwapRenderers.renderDojutsu(_evt, "naruto_shippuden:textures/dojutsu/mangekyou_sharingan/kakashi/kakashimangekyo2px1px2.png");
						}
					} else if ((NarutoShippudenModVariables.get(entity).dojutsums).equals("1x2")) {
						if (_evt.getRenderer() instanceof AvatarRenderer) {
							if (_evt instanceof RenderLivingEvent.Pre) {
								//  _evt.setCanceled(true); 
							}
							ModelSwapRenderers.renderDojutsu(_evt, "naruto_shippuden:textures/dojutsu/mangekyou_sharingan/kakashi/kakashimangekyo2px2px2.png");
						}
					} else if ((NarutoShippudenModVariables.get(entity).dojutsums).equals("2x2")) {
						if (_evt.getRenderer() instanceof AvatarRenderer) {
							if (_evt instanceof RenderLivingEvent.Pre) {
								//  _evt.setCanceled(true); 
							}
							ModelSwapRenderers.renderDojutsu(_evt, "naruto_shippuden:textures/dojutsu/mangekyou_sharingan/kakashi/kakashimangekyo2px2px1.png");
						}
					}
				}
			}
			if (NarutoShippudenModVariables.get(entity).rinneganactivate == true) {
				if ((NarutoShippudenModVariables.get(entity).dojutsurinnegan).equals("1x1")) {
					if (_evt.getRenderer() instanceof AvatarRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						ModelSwapRenderers.renderDojutsu(_evt, "naruto_shippuden:textures/dojutsu/rinnegan/rinnegan_2x1_pupils_1x1.png");
					}
				} else if ((NarutoShippudenModVariables.get(entity).dojutsurinnegan).equals("2x1")) {
					if (_evt.getRenderer() instanceof AvatarRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						ModelSwapRenderers.renderDojutsu(_evt, "naruto_shippuden:textures/dojutsu/rinnegan/rinnegan_2x1_pupils_2x1.png");
					}
				} else if ((NarutoShippudenModVariables.get(entity).dojutsurinnegan).equals("1x2")) {
					if (_evt.getRenderer() instanceof AvatarRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						ModelSwapRenderers.renderDojutsu(_evt, "naruto_shippuden:textures/dojutsu/rinnegan/rinnegan_2x2_pupils_1x1.png");
					}
				} else if ((NarutoShippudenModVariables.get(entity).dojutsurinnegan).equals("2x2")) {
					if (_evt.getRenderer() instanceof AvatarRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						ModelSwapRenderers.renderDojutsu(_evt, "naruto_shippuden:textures/dojutsu/rinnegan/rinnegan_2x2_pupils_1x2.png");
					}
				}
			}
			if (NarutoShippudenModVariables.get(entity).tenseiganactivate == true) {
				if ((NarutoShippudenModVariables.get(entity).dojutsutenseigan).equals("1x1")) {
					if (_evt.getRenderer() instanceof AvatarRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						ModelSwapRenderers.renderDojutsu(_evt, "naruto_shippuden:textures/dojutsu/tenseigan/tenseigan_2x1_pupils_1x1.png");
					}
				} else if ((NarutoShippudenModVariables.get(entity).dojutsutenseigan).equals("2x1")) {
					if (_evt.getRenderer() instanceof AvatarRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						ModelSwapRenderers.renderDojutsu(_evt, "naruto_shippuden:textures/dojutsu/tenseigan/tenseigan_2x1_pupils_2x1.png");
					}
				} else if ((NarutoShippudenModVariables.get(entity).dojutsutenseigan).equals("1x2")) {
					if (_evt.getRenderer() instanceof AvatarRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						ModelSwapRenderers.renderDojutsu(_evt, "naruto_shippuden:textures/dojutsu/tenseigan/tenseigan_2x2_pupils_1x1.png");
					}
				} else if ((NarutoShippudenModVariables.get(entity).dojutsutenseigan).equals("2x2")) {
					if (_evt.getRenderer() instanceof AvatarRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						ModelSwapRenderers.renderDojutsu(_evt, "naruto_shippuden:textures/dojutsu/tenseigan/tenseigan_2x2_pupils_1x2.png");
					}
				}
			}
			if (NarutoShippudenModVariables.get(entity).isshikidojutsuactivate == true) {
				if ((NarutoShippudenModVariables.get(entity).dojutsuisshiki).equals("1x1")) {
					if (_evt.getRenderer() instanceof AvatarRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						ModelSwapRenderers.renderDojutsu(_evt, "naruto_shippuden:textures/dojutsu/isshiki/isshiki_dojutsu_2x1_pupils_1x1.png");
					}
				} else if ((NarutoShippudenModVariables.get(entity).dojutsuisshiki).equals("2x1")) {
					if (_evt.getRenderer() instanceof AvatarRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						ModelSwapRenderers.renderDojutsu(_evt, "naruto_shippuden:textures/dojutsu/isshiki/isshiki_dojutsu_2x1_pupils_2x1.png");
					}
				} else if ((NarutoShippudenModVariables.get(entity).dojutsuisshiki).equals("1x2")) {
					if (_evt.getRenderer() instanceof AvatarRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						ModelSwapRenderers.renderDojutsu(_evt, "naruto_shippuden:textures/dojutsu/isshiki/isshiki_dojutsu_2x2_pupils_1x1.png");
					}
				} else if ((NarutoShippudenModVariables.get(entity).dojutsuisshiki).equals("2x2")) {
					if (_evt.getRenderer() instanceof AvatarRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						ModelSwapRenderers.renderDojutsu(_evt, "naruto_shippuden:textures/dojutsu/isshiki/isshiki_dojutsu_2x2_pupils_1x2.png");
					}
				}
			}
			if (NarutoShippudenModVariables.get(entity).shimura_active == true) {
				if ((NarutoShippudenModVariables.get(entity).dojutsusharingan).equals("1x1")) {
					if (_evt.getRenderer() instanceof AvatarRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						ModelSwapRenderers.renderDojutsu(_evt, "naruto_shippuden:textures/dojutsu/shimura/sharingan2px1px.png");
					}
				} else if ((NarutoShippudenModVariables.get(entity).dojutsusharingan).equals("2x1")) {
					if (_evt.getRenderer() instanceof AvatarRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						ModelSwapRenderers.renderDojutsu(_evt, "naruto_shippuden:textures/dojutsu/shimura/sharingan2px1px2.png");
					}
				} else if ((NarutoShippudenModVariables.get(entity).dojutsusharingan).equals("1x2")) {
					if (_evt.getRenderer() instanceof AvatarRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						ModelSwapRenderers.renderDojutsu(_evt, "naruto_shippuden:textures/dojutsu/shimura/sharingan2px2px2.png");
					}
				} else if ((NarutoShippudenModVariables.get(entity).dojutsusharingan).equals("2x2")) {
					if (_evt.getRenderer() instanceof AvatarRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						ModelSwapRenderers.renderDojutsu(_evt, "naruto_shippuden:textures/dojutsu/shimura/sharingan2px2px1.png");
					}
				}
				if (_evt.getRenderer() instanceof AvatarRenderer) {
					if (_evt instanceof RenderLivingEvent.Pre) {
						//  _evt.setCanceled(true); 
					}
					ModelSwapRenderers.renderDojutsu(_evt, "naruto_shippuden:textures/dojutsu/shimura/shimura_body.png");
				}
				if (_evt.getRenderer() instanceof AvatarRenderer) {
					if (_evt instanceof RenderLivingEvent.Pre) {
						//  _evt.setCanceled(true); 
					}
					ModelSwapRenderers.renderDojutsu(_evt, "naruto_shippuden:textures/dojutsu/shimura/shimura_head_open.png");
				}
			} else if (NarutoShippudenModVariables.get(entity).shimura_active == false) {
				if (NarutoShippudenModVariables.get(entity).shimurareleaselogic == true) {
					if (_evt.getRenderer() instanceof AvatarRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						ModelSwapRenderers.renderDojutsu(_evt, "naruto_shippuden:textures/dojutsu/shimura/shimura_body.png");
					}
					if (_evt.getRenderer() instanceof AvatarRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						ModelSwapRenderers.renderDojutsu(_evt, "naruto_shippuden:textures/dojutsu/shimura/shimura_head.png");
					}
				}
			}
		}
	}




	public static class IsshikiDojutsuAwake10SecondsProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("world") == null) {
				if (!dependencies.containsKey("world"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure IsshikiDojutsuAwake10Seconds!");
				return;
			}
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure IsshikiDojutsuAwake10Seconds!");
				return;
			}
			LevelAccessor world = (LevelAccessor) dependencies.get("world");
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).isshikidojutsu == false) {
				new Object() {
					private int ticks = 0;
					private float waitTicks;
					private LevelAccessor world;

					public void start(LevelAccessor world, int waitTicks) {
						this.waitTicks = waitTicks;
						Registration.listen(NeoForge.EVENT_BUS, this);
						this.world = world;
					}

					@SubscribeEvent
					public void tick(ServerTickEvent.Post event) {
						if (true) {
							this.ticks += 1;
							if (this.ticks >= this.waitTicks)
								run();
						}
					}

					private void run() {
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendSystemMessage(Component.literal("You've awakened Kokugan!"));
						}
						{
							boolean _setval = (true);
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.isshikidojutsu = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof LivingEntity)
							((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.NAUSEA, (int) 200, (int) 4, (false), (false)));
						if (entity instanceof LivingEntity)
							((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.BLINDNESS, (int) 60, (int) 1, (false), (false)));
						{
							String _setval = "1x1";
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.dojutsuisshiki = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof Player) {
							ItemStack _setstack = new ItemStack(IsshikiDojutsuReleaseItem.block);
							_setstack.setCount((int) 1);
							Compat.giveItemToPlayer(((Player) entity), _setstack);
						}
						NeoForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 200);
			} else if (NarutoShippudenModVariables.get(entity).isshikidojutsu == true) {
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendSystemMessage(Component.literal("You've already unlocked isshiki dojutsu."));
				}
			}
		}
	}

	public static class IsshikiDojutsuAwakeProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure IsshikiDojutsuAwake!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (entity instanceof Player && !entity.level().isClientSide()) {
				((Player) entity).sendSystemMessage(Component.literal("You've awakened Kokugan!"));
			}
			{
				boolean _setval = (true);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.isshikidojutsu = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.NAUSEA, (int) 200, (int) 4, (false), (false)));
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.BLINDNESS, (int) 60, (int) 1, (false), (false)));
			{
				String _setval = "1x1";
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.dojutsuisshiki = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof Player) {
				ItemStack _setstack = new ItemStack(IsshikiDojutsuReleaseItem.block);
				_setstack.setCount((int) 1);
				Compat.giveItemToPlayer(((Player) entity), _setstack);
			}
		}
	}

	public static class IsshikiDojutsuReleaseRightclickedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure IsshikiDojutsuReleaseRightclicked!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).isshikidojutsurelease == 0) {
				if (NarutoShippudenModVariables.get(entity).jp >= 25) {
					if (entity instanceof Player) {
						ItemStack _setstack = new ItemStack(IsshikiDojutsuReleaseTechniqueItem.block);
						_setstack.setCount((int) 1);
						Compat.giveItemToPlayer(((Player) entity), _setstack);
					}
					{
						double _setval = 1;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.isshikidojutsulearn = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 25);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(Component.literal("-25 JP"));
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).isshikidojutsurelease + 1);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.isshikidojutsurelease = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 24) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(Component.literal("Not Enough JP"));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).isshikidojutsurelease == 1) {
				if (NarutoShippudenModVariables.get(entity).jp >= 40) {
					{
						double _setval = 2;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.isshikidojutsulearn = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 40);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).isshikidojutsurelease + 1);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.isshikidojutsurelease = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(Component.literal("-40 JP"));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 39) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(Component.literal("Not Enough JP"));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).isshikidojutsurelease == 2) {
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendSystemMessage(Component.literal("Wait For Newer Updates"));
				}
			}
		}
	}

	public static class IsshikiDojutsuReleaseTechniqueEntitySwingsItemProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure IsshikiDojutsuReleaseTechniqueEntitySwingsItem!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (entity.isShiftKeyDown()) {
				if (NarutoShippudenModVariables.get(entity).sukunahikonasize == 0.1) {
					{
						double _setval = 0.2;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.sukunahikonasize = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Size: 0.2"));
					}
				} else if (NarutoShippudenModVariables.get(entity).sukunahikonasize == 0.2) {
					{
						double _setval = 0.3;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.sukunahikonasize = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Size: 0.3"));
					}
				} else if (NarutoShippudenModVariables.get(entity).sukunahikonasize == 0.3) {
					{
						double _setval = 0.4;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.sukunahikonasize = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Size: 0.4"));
					}
				} else if (NarutoShippudenModVariables.get(entity).sukunahikonasize == 0.4) {
					{
						double _setval = 0.5;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.sukunahikonasize = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Size: 0.5"));
					}
				} else if (NarutoShippudenModVariables.get(entity).sukunahikonasize == 0.5) {
					{
						double _setval = 0.6;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.sukunahikonasize = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Size: 0.6"));
					}
				} else if (NarutoShippudenModVariables.get(entity).sukunahikonasize == 0.6) {
					{
						double _setval = 0.7;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.sukunahikonasize = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Size: 0.7"));
					}
				} else if (NarutoShippudenModVariables.get(entity).sukunahikonasize == 0.7) {
					{
						double _setval = 0.8;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.sukunahikonasize = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Size: 0.8"));
					}
				} else if (NarutoShippudenModVariables.get(entity).sukunahikonasize == 0.8) {
					{
						double _setval = 0.9;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.sukunahikonasize = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Size: 0.9"));
					}
				} else if (NarutoShippudenModVariables.get(entity).sukunahikonasize == 0.9) {
					{
						double _setval = 1;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.sukunahikonasize = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Size: 1"));
					}
				} else if (NarutoShippudenModVariables.get(entity).sukunahikonasize == 1) {
					{
						double _setval = 0.1;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.sukunahikonasize = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Size: 0.1"));
					}
				}
			}
		}
	}

	public static class IsshikiDojutsuReleaseTechniqueRightclickedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("world") == null) {
				if (!dependencies.containsKey("world"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure IsshikiDojutsuReleaseTechniqueRightclicked!");
				return;
			}
			if (dependencies.get("y") == null) {
				if (!dependencies.containsKey("y"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency y for procedure IsshikiDojutsuReleaseTechniqueRightclicked!");
				return;
			}
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure IsshikiDojutsuReleaseTechniqueRightclicked!");
				return;
			}
			LevelAccessor world = (LevelAccessor) dependencies.get("world");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			Entity entity = (Entity) dependencies.get("entity");
			{
				if (NarutoShippudenModVariables.get(entity).isshikidojutsu == true) {
					if (NarutoShippudenModVariables.get(entity).isshikidojutsuactivate == true) {
						if (!entity.isShiftKeyDown()) {
							if (NarutoShippudenModVariables.get(entity).isshikidojutsutechnique == 0) {
								if (NarutoShippudenModVariables.get(entity).isshikidojutsulearn >= 1) {
									if (NarutoShippudenModVariables.get(entity).ninjutsu >= 25) {
										if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 500) {
											{
												Entity _ent = entity;
												if (!_ent.level().isClientSide() && _ent.level().getServer() != null) {
													EntityScale.set(_ent, EntityScale.BASE, NarutoShippudenModVariables.get(entity).sukunahikonasize);
												}
											}
											{
												double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 500);
												NarutoShippudenModVariables.ifPresent(entity, capability -> {
															capability.ChakraAmount = _setval;
															capability.syncPlayerVariables(entity);
														});
											}
										} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 499) {
											if (entity instanceof Player && !entity.level().isClientSide()) {
												((Player) entity).sendSystemMessage(Component.literal("Not Enough Chakra"));
											}
										}
									} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 24) {
										if (entity instanceof Player && !entity.level().isClientSide()) {
											((Player) entity).sendSystemMessage(Component.literal("Not Enough Ninjutsu"));
										}
									}
								} else if (!(NarutoShippudenModVariables.get(entity).isshikidojutsulearn >= 1)) {
									if (entity instanceof Player && !entity.level().isClientSide()) {
										((Player) entity).sendSystemMessage(Component.literal("You haven't unlocked this technique."));
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).isshikidojutsutechnique == 1) {
								if (NarutoShippudenModVariables.get(entity).isshikidojutsulearn >= 2) {
									if (NarutoShippudenModVariables.get(entity).ninjutsu >= 35) {
										if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 1000) {
											if (world instanceof ServerLevel) {
												Entity entityToSpawn = new DisruptionCubeEntity.CustomEntity(DisruptionCubeEntity.entity, (Level) world);
												entityToSpawn.snapTo(
														(entity.level()
																.clip(new ClipContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getViewVector(1f).x * 20,
																				entity.getViewVector(1f).y * 20, entity.getViewVector(1f).z * 20),
																		ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getX()),
														(y + 20),
														(entity.level()
																.clip(new ClipContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getViewVector(1f).x * 20,
																				entity.getViewVector(1f).y * 20, entity.getViewVector(1f).z * 20),
																		ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getZ()),
														(float) 0, (float) 0);
												entityToSpawn.setYBodyRot((float) 0);
												entityToSpawn.setYHeadRot((float) 0);
												entityToSpawn.setDeltaMovement(0, 0, 0);
												if (entityToSpawn instanceof Mob)
													((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
															((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
												world.addFreshEntity(entityToSpawn);
											}
											{
												double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 1000);
												NarutoShippudenModVariables.ifPresent(entity, capability -> {
															capability.ChakraAmount = _setval;
															capability.syncPlayerVariables(entity);
														});
											}
										} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 999) {
											if (entity instanceof Player && !entity.level().isClientSide()) {
												((Player) entity).sendSystemMessage(Component.literal("Not Enough Chakra"));
											}
										}
									} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 34) {
										if (entity instanceof Player && !entity.level().isClientSide()) {
											((Player) entity).sendSystemMessage(Component.literal("Not Enough Ninjutsu"));
										}
									}
								} else if (!(NarutoShippudenModVariables.get(entity).isshikidojutsulearn >= 2)) {
									if (entity instanceof Player && !entity.level().isClientSide()) {
										((Player) entity).sendSystemMessage(Component.literal("You haven't unlocked this technique."));
									}
								}
							}
							if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
								if (entity instanceof Player)
									((Player) entity).getCooldowns().addCooldown(new ItemStack(IsshikiDojutsuReleaseTechniqueItem.block), (int) 200);
							} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
								if (entity instanceof Player)
									((Player) entity).getCooldowns().addCooldown(new ItemStack(IsshikiDojutsuReleaseTechniqueItem.block), (int) 160);
							} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
								if (entity instanceof Player)
									((Player) entity).getCooldowns().addCooldown(new ItemStack(IsshikiDojutsuReleaseTechniqueItem.block), (int) 120);
							} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
								if (entity instanceof Player)
									((Player) entity).getCooldowns().addCooldown(new ItemStack(IsshikiDojutsuReleaseTechniqueItem.block), (int) 80);
							} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
								if (entity instanceof Player)
									((Player) entity).getCooldowns().addCooldown(new ItemStack(IsshikiDojutsuReleaseTechniqueItem.block), (int) 40);
							}
						} else if (entity.isShiftKeyDown()) {
							if (NarutoShippudenModVariables.get(entity).isshikidojutsutechnique == 0) {
								{
									double _setval = 1;
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.isshikidojutsutechnique = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
								if (entity instanceof Player && !entity.level().isClientSide()) {
									((Player) entity).sendOverlayMessage(Component.literal("Selected: Disruption Cube"));
								}
							} else if (NarutoShippudenModVariables.get(entity).isshikidojutsutechnique == 1) {
								{
									double _setval = 0;
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.isshikidojutsutechnique = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
								if (entity instanceof Player && !entity.level().isClientSide()) {
									((Player) entity).sendOverlayMessage(Component.literal("Selected: Sukunahikona"));
								}
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).isshikidojutsuactivate == false) {
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendSystemMessage(Component.literal("Activate Kokugan"));
						}
					}
				} else if (NarutoShippudenModVariables.get(entity).isshikidojutsu == false) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("You haven't unlocked this release."));
					}
				}
			}
		}
	}

	public static class KakashiMSharinganAwakeProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure KakashiMSharinganAwake!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (entity instanceof Player && !entity.level().isClientSide()) {
				((Player) entity).sendSystemMessage(Component.literal("You feel flow of emotions as you awaken the Mangekyou Sharingan!"));
			}
			{
				double _setval = (Mth.nextInt(RandomSource.create(), 1000, 1500));
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.Mangekyou_Sharingan_Technique_Use_Max = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				boolean _setval = (true);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.MangekyouSharinganKakashi = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				boolean _setval = (true);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.Mangekyou_Sharingan = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.NAUSEA, (int) 200, (int) 4, (false), (false)));
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.BLINDNESS, (int) 60, (int) 1, (false), (false)));
			{
				String _setval = "1x1";
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.dojutsums = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof Player) {
				ItemStack _setstack = new ItemStack(MangekyouSharinganKakashiReleaseItem.block);
				_setstack.setCount((int) 1);
				Compat.giveItemToPlayer(((Player) entity), _setstack);
			}
		}
	}

	public static class KakashiSharinganAwake10SecondsProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("world") == null) {
				if (!dependencies.containsKey("world"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure KakashiSharinganAwake10Seconds!");
				return;
			}
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure KakashiSharinganAwake10Seconds!");
				return;
			}
			LevelAccessor world = (LevelAccessor) dependencies.get("world");
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).SharinganKakashi == false) {
				new Object() {
					private int ticks = 0;
					private float waitTicks;
					private LevelAccessor world;

					public void start(LevelAccessor world, int waitTicks) {
						this.waitTicks = waitTicks;
						Registration.listen(NeoForge.EVENT_BUS, this);
						this.world = world;
					}

					@SubscribeEvent
					public void tick(ServerTickEvent.Post event) {
						if (true) {
							this.ticks += 1;
							if (this.ticks >= this.waitTicks)
								run();
						}
					}

					private void run() {
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendSystemMessage(
									Component.literal("You suddenly feel a surge of power through you as you awaken the Sharingan!"));
						}
						{
							boolean _setval = (true);
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.SharinganKakashi = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof LivingEntity)
							((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.NAUSEA, (int) 200, (int) 4, (false), (false)));
						if (entity instanceof LivingEntity)
							((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.BLINDNESS, (int) 60, (int) 1, (false), (false)));
						{
							String _setval = "1x1";
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.dojutsusharingan = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof Player) {
							ItemStack _setstack = new ItemStack(SharinganReleaseItem.block);
							_setstack.setCount((int) 1);
							Compat.giveItemToPlayer(((Player) entity), _setstack);
						}
						NeoForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 200);
			} else if (NarutoShippudenModVariables.get(entity).SharinganKakashi == true) {
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendSystemMessage(Component.literal("You've already unlocked sharingan."));
				}
			}
		}
	}

	public static class KakashiSharinganAwakeProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure KakashiSharinganAwake!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (entity instanceof Player && !entity.level().isClientSide()) {
				((Player) entity).sendSystemMessage(
						Component.literal("You suddenly feel a surge of power through you as you awaken the Sharingan!"));
			}
			{
				boolean _setval = (true);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.SharinganKakashi = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.NAUSEA, (int) 200, (int) 4, (false), (false)));
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.BLINDNESS, (int) 60, (int) 1, (false), (false)));
			{
				String _setval = "1x1";
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.dojutsusharingan = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof Player) {
				ItemStack _setstack = new ItemStack(SharinganReleaseItem.block);
				_setstack.setCount((int) 1);
				Compat.giveItemToPlayer(((Player) entity), _setstack);
			}
		}
	}

	public static class KamuiDimensionPlayerEntersDimensionProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("world") == null) {
				if (!dependencies.containsKey("world"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure KamuiDimensionPlayerEntersDimension!");
				return;
			}
			if (dependencies.get("x") == null) {
				if (!dependencies.containsKey("x"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency x for procedure KamuiDimensionPlayerEntersDimension!");
				return;
			}
			if (dependencies.get("z") == null) {
				if (!dependencies.containsKey("z"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency z for procedure KamuiDimensionPlayerEntersDimension!");
				return;
			}
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure KamuiDimensionPlayerEntersDimension!");
				return;
			}
			LevelAccessor world = (LevelAccessor) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			Entity entity = (Entity) dependencies.get("entity");
			double notair = 0;
			notair = 64;
			for (int index0 = 0; index0 < (int) (9); index0++) {
				if (world.isEmptyBlock(BlockPos.containing(x, notair, z))) {
					{
						Entity _ent = entity;
						_ent.teleportTo(x, notair, z);
						if (_ent instanceof ServerPlayer) {
							((ServerPlayer) _ent).connection.teleport(x, notair, z, _ent.getYRot(), _ent.getXRot());
						}
					}
				} else if (!world.isEmptyBlock(BlockPos.containing(x, notair, z))) {
					notair = (notair + 1);
				}
			}
		}
	}

	public static class KamuiTower1AdditionalGenerationConditionProcedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("world") == null) {
				if (!dependencies.containsKey("world"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure KamuiTower1AdditionalGenerationCondition!");
				return false;
			}
			if (dependencies.get("x") == null) {
				if (!dependencies.containsKey("x"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency x for procedure KamuiTower1AdditionalGenerationCondition!");
				return false;
			}
			if (dependencies.get("z") == null) {
				if (!dependencies.containsKey("z"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency z for procedure KamuiTower1AdditionalGenerationCondition!");
				return false;
			}
			LevelAccessor world = (LevelAccessor) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			if (world.isEmptyBlock(BlockPos.containing(x, 64, z - 1)) && world.isEmptyBlock(BlockPos.containing(x + 1, 64, z - 1))
					&& world.isEmptyBlock(BlockPos.containing(x + 2, 64, z - 1)) && world.isEmptyBlock(BlockPos.containing(x - 1, 64, z))
					&& world.isEmptyBlock(BlockPos.containing(x - 1, 64, z + 1)) && world.isEmptyBlock(BlockPos.containing(x - 1, 64, z + 2))
					&& world.isEmptyBlock(BlockPos.containing(x, 64, z + 3)) && world.isEmptyBlock(BlockPos.containing(x + 1, 64, z + 3))
					&& world.isEmptyBlock(BlockPos.containing(x + 2, 64, z + 3)) && world.isEmptyBlock(BlockPos.containing(x + 3, 64, z))
					&& world.isEmptyBlock(BlockPos.containing(x + 3, 64, z + 1)) && world.isEmptyBlock(BlockPos.containing(x + 3, 64, z + 2))) {
				return true;
			}
			return false;
		}
	}

	public static class KamuiTower4AdditionalGenerationConditionProcedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("world") == null) {
				if (!dependencies.containsKey("world"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure KamuiTower4AdditionalGenerationCondition!");
				return false;
			}
			if (dependencies.get("x") == null) {
				if (!dependencies.containsKey("x"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency x for procedure KamuiTower4AdditionalGenerationCondition!");
				return false;
			}
			if (dependencies.get("z") == null) {
				if (!dependencies.containsKey("z"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency z for procedure KamuiTower4AdditionalGenerationCondition!");
				return false;
			}
			LevelAccessor world = (LevelAccessor) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			if (world.isEmptyBlock(BlockPos.containing(x, 64, z - 1)) && world.isEmptyBlock(BlockPos.containing(x + 1, 64, z - 1))
					&& world.isEmptyBlock(BlockPos.containing(x + 2, 64, z - 1)) && world.isEmptyBlock(BlockPos.containing(x + 3, 64, z - 1))
					&& world.isEmptyBlock(BlockPos.containing(x - 1, 64, z)) && world.isEmptyBlock(BlockPos.containing(x - 1, 64, z + 1))
					&& world.isEmptyBlock(BlockPos.containing(x - 1, 64, z + 2)) && world.isEmptyBlock(BlockPos.containing(x - 1, 64, z + 3))
					&& world.isEmptyBlock(BlockPos.containing(x, 64, z + 3)) && world.isEmptyBlock(BlockPos.containing(x + 1, 64, z + 3))
					&& world.isEmptyBlock(BlockPos.containing(x + 2, 64, z + 3)) && world.isEmptyBlock(BlockPos.containing(x + 3, 64, z + 3))
					&& world.isEmptyBlock(BlockPos.containing(x + 3, 64, z)) && world.isEmptyBlock(BlockPos.containing(x + 3, 64, z + 1))
					&& world.isEmptyBlock(BlockPos.containing(x + 3, 64, z + 2)) && world.isEmptyBlock(BlockPos.containing(x + 3, 64, z + 3))) {
				return true;
			}
			return false;
		}
	}

	public static class KamuiTower7AdditionalGenerationConditionProcedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("world") == null) {
				if (!dependencies.containsKey("world"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure KamuiTower7AdditionalGenerationCondition!");
				return false;
			}
			if (dependencies.get("x") == null) {
				if (!dependencies.containsKey("x"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency x for procedure KamuiTower7AdditionalGenerationCondition!");
				return false;
			}
			if (dependencies.get("z") == null) {
				if (!dependencies.containsKey("z"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency z for procedure KamuiTower7AdditionalGenerationCondition!");
				return false;
			}
			LevelAccessor world = (LevelAccessor) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			if (world.isEmptyBlock(BlockPos.containing(x, 64, z - 1)) && world.isEmptyBlock(BlockPos.containing(x + 1, 64, z - 1))
					&& world.isEmptyBlock(BlockPos.containing(x + 2, 64, z - 1)) && world.isEmptyBlock(BlockPos.containing(x + 3, 64, z - 1))
					&& world.isEmptyBlock(BlockPos.containing(x + 4, 64, z - 1)) && world.isEmptyBlock(BlockPos.containing(x - 1, 64, z))
					&& world.isEmptyBlock(BlockPos.containing(x - 1, 64, z + 1)) && world.isEmptyBlock(BlockPos.containing(x - 1, 64, z + 2))
					&& world.isEmptyBlock(BlockPos.containing(x - 1, 64, z + 3)) && world.isEmptyBlock(BlockPos.containing(x - 1, 64, z + 4))
					&& world.isEmptyBlock(BlockPos.containing(x, 64, z + 3)) && world.isEmptyBlock(BlockPos.containing(x + 1, 64, z + 3))
					&& world.isEmptyBlock(BlockPos.containing(x + 2, 64, z + 3)) && world.isEmptyBlock(BlockPos.containing(x + 3, 64, z + 3))
					&& world.isEmptyBlock(BlockPos.containing(x + 4, 64, z + 3)) && world.isEmptyBlock(BlockPos.containing(x + 3, 64, z))
					&& world.isEmptyBlock(BlockPos.containing(x + 3, 64, z + 1)) && world.isEmptyBlock(BlockPos.containing(x + 3, 64, z + 2))
					&& world.isEmptyBlock(BlockPos.containing(x + 3, 64, z + 3)) && world.isEmptyBlock(BlockPos.containing(x + 3, 64, z + 4))) {
				return true;
			}
			return false;
		}
	}

	public static class KetsuryuganAwake10SecondsProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("world") == null) {
				if (!dependencies.containsKey("world"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure KetsuryuganAwake10Seconds!");
				return;
			}
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure KetsuryuganAwake10Seconds!");
				return;
			}
			LevelAccessor world = (LevelAccessor) dependencies.get("world");
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).ketsuryugan == false) {
				new Object() {
					private int ticks = 0;
					private float waitTicks;
					private LevelAccessor world;

					public void start(LevelAccessor world, int waitTicks) {
						this.waitTicks = waitTicks;
						Registration.listen(NeoForge.EVENT_BUS, this);
						this.world = world;
					}

					@SubscribeEvent
					public void tick(ServerTickEvent.Post event) {
						if (true) {
							this.ticks += 1;
							if (this.ticks >= this.waitTicks)
								run();
						}
					}

					private void run() {
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendSystemMessage(
									Component.literal(
											"You feel that the blood of the Chinoike clan flows in your veins, you have awakened the Ketsuryugan"));
						}
						{
							String _setval = "1x1";
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.dojutsuketsuryugan = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof Player) {
							ItemStack _setstack = new ItemStack(KetsuryuganReleaseItem.block);
							_setstack.setCount((int) 1);
							Compat.giveItemToPlayer(((Player) entity), _setstack);
						}
						{
							boolean _setval = (true);
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.ketsuryugan = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						NeoForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 200);
			} else if (NarutoShippudenModVariables.get(entity).ketsuryugan == true) {
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendSystemMessage(Component.literal("You've already unlocked ketsuryugan."));
				}
			}
		}
	}

	public static class KetsuryuganAwakeProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure KetsuryuganAwake!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (entity instanceof Player && !entity.level().isClientSide()) {
				((Player) entity).sendSystemMessage(
						Component.literal("You feel that the blood of the Chinoike clan flows in your veins, you have awakened the Ketsuryugan"));
			}
			{
				String _setval = "1x1";
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.dojutsuketsuryugan = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof Player) {
				ItemStack _setstack = new ItemStack(KetsuryuganReleaseItem.block);
				_setstack.setCount((int) 1);
				Compat.giveItemToPlayer(((Player) entity), _setstack);
			}
			{
				boolean _setval = (true);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.ketsuryugan = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}

	public static class MSharinganAwakeProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure MSharinganAwake!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (entity instanceof Player && !entity.level().isClientSide()) {
				((Player) entity).sendSystemMessage(Component.literal("A pitch black crow gave you a letter!"));
			}
			if (entity instanceof Player) {
				ItemStack _setstack = new ItemStack(LetterFromBrotherItem.block);
				_setstack.setCount((int) 1);
				Compat.giveItemToPlayer(((Player) entity), _setstack);
			}
			{
				boolean _setval = (true);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.mangekyouletter = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}

	public static class MangekyouOtsutsukiAwakeProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure MangekyouOtsutsukiAwake!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			double random = 0;
			random = (Mth.nextInt(RandomSource.create(), 1, 5));
			if (random == 1) {
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(MangekyouSharinganSasukeReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.MangekyouSharinganSasuke = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (random == 2) {
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(MangekyouSharinganMadaraReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.MangekyouSharinganMadara = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (random == 3) {
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(MangekyouSharinganItachiReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.MangekyouSharinganItachi = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (random == 4) {
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(MangekyouSharinganShisuiReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.MangekyouSharinganShisui = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (random == 5) {
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(MangekyouSharinganObitoReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.MangekyouSharinganObito = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			{
				String _setval = "1x1";
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.dojutsums = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				boolean _setval = (true);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.otsutsuki_mangekyou = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				boolean _setval = (true);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.Mangekyou_Sharingan = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof Player && !entity.level().isClientSide()) {
				((Player) entity).sendSystemMessage(Component.literal("You've awakened Mangekyou Sharingan!"));
			}
		}
	}

	public static class MangekyouSharinganItachiReleaseRightclickedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure MangekyouSharinganItachiReleaseRightclicked!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (!entity.isShiftKeyDown()) {
				if (NarutoShippudenModVariables.get(entity).MangekyouSharinganRelease == 0) {
					if (NarutoShippudenModVariables.get(entity).mangekyoushrainganitachiamaterasulearn == 0) {
						if (NarutoShippudenModVariables.get(entity).jp >= 10) {
							if (NarutoShippudenModVariables.get(entity).mangekyoushrainganitachisusanolearn == 0) {
								if (entity instanceof Player) {
									ItemStack _setstack = new ItemStack(MangekyouSharinganItachiReleaseTechniqueItem.block);
									_setstack.setCount((int) 1);
									Compat.giveItemToPlayer(((Player) entity), _setstack);
								}
							}
							{
								double _setval = 1;
								NarutoShippudenModVariables.ifPresent(entity, capability -> {
									capability.mangekyoushrainganitachiamaterasulearn = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = (NarutoShippudenModVariables.get(entity).jp - 10);
								NarutoShippudenModVariables.ifPresent(entity, capability -> {
									capability.jp = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendSystemMessage(Component.literal("-10 JP"));
							}
						} else if (NarutoShippudenModVariables.get(entity).jp <= 9) {
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendSystemMessage(Component.literal("Not Enough JP"));
							}
						}
					}
				} else if (NarutoShippudenModVariables.get(entity).MangekyouSharinganRelease == 1) {
					if (NarutoShippudenModVariables.get(entity).mangekyoushrainganitachisusanorelease == 0) {
						if (NarutoShippudenModVariables.get(entity).jp >= 10) {
							{
								double _setval = 1;
								NarutoShippudenModVariables.ifPresent(entity, capability -> {
									capability.mangekyoushrainganitachisusanolearn = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = (NarutoShippudenModVariables.get(entity).jp - 10);
								NarutoShippudenModVariables.ifPresent(entity, capability -> {
									capability.jp = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = (NarutoShippudenModVariables.get(entity).mangekyoushrainganitachisusanorelease + 1);
								NarutoShippudenModVariables.ifPresent(entity, capability -> {
									capability.mangekyoushrainganitachisusanorelease = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendSystemMessage(Component.literal("-10 JP"));
							}
						} else if (NarutoShippudenModVariables.get(entity).jp <= 9) {
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendSystemMessage(Component.literal("Not Enough JP"));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).mangekyoushrainganitachisusanorelease == 1) {
						if (NarutoShippudenModVariables.get(entity).jp >= 20) {
							{
								double _setval = 2;
								NarutoShippudenModVariables.ifPresent(entity, capability -> {
									capability.mangekyoushrainganitachisusanolearn = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = (NarutoShippudenModVariables.get(entity).jp - 20);
								NarutoShippudenModVariables.ifPresent(entity, capability -> {
									capability.jp = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = (NarutoShippudenModVariables.get(entity).mangekyoushrainganitachisusanorelease + 1);
								NarutoShippudenModVariables.ifPresent(entity, capability -> {
									capability.mangekyoushrainganitachisusanorelease = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendSystemMessage(Component.literal("-20 JP"));
							}
						} else if (NarutoShippudenModVariables.get(entity).jp <= 19) {
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendSystemMessage(Component.literal("Not Enough JP"));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).mangekyoushrainganitachisusanorelease == 2) {
						if (NarutoShippudenModVariables.get(entity).jp >= 30) {
							{
								double _setval = 3;
								NarutoShippudenModVariables.ifPresent(entity, capability -> {
									capability.mangekyoushrainganitachisusanolearn = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = (NarutoShippudenModVariables.get(entity).jp - 30);
								NarutoShippudenModVariables.ifPresent(entity, capability -> {
									capability.jp = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = (NarutoShippudenModVariables.get(entity).mangekyoushrainganitachisusanorelease + 1);
								NarutoShippudenModVariables.ifPresent(entity, capability -> {
									capability.mangekyoushrainganitachisusanorelease = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendSystemMessage(Component.literal("-30 JP"));
							}
						} else if (NarutoShippudenModVariables.get(entity).jp <= 29) {
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendSystemMessage(Component.literal("Not Enough JP"));
							}
						}
					}
				}
			} else if (entity.isShiftKeyDown()) {
				if (NarutoShippudenModVariables.get(entity).MangekyouSharinganRelease == 0) {
					{
						double _setval = 1;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.MangekyouSharinganRelease = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Selected: Susano"));
					}
				} else if (NarutoShippudenModVariables.get(entity).MangekyouSharinganRelease == 1) {
					{
						double _setval = 0;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.MangekyouSharinganRelease = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Selected: Amaterasu"));
					}
				}
			}
		}
	}

	public static class MangekyouSharinganItachiReleaseTechniqueEntitySwingsItemProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER
							.warn("Failed to load dependency entity for procedure MangekyouSharinganItachiReleaseTechniqueEntitySwingsItem!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			{
				double _setval = (NarutoShippudenModVariables.get(entity).Mangekyou_Sharingan_Technique_Use_Max);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.Mangekyou_Sharingan_Technique_Use = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}

	public static class MangekyouSharinganItachiReleaseTechniqueRightclickedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER
							.warn("Failed to load dependency entity for procedure MangekyouSharinganItachiReleaseTechniqueRightclicked!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).MangekyouSharinganItachi == true) {
				if (!entity.isShiftKeyDown()) {
					if (NarutoShippudenModVariables.get(entity).MangekyouSharinganActivate == true) {
						if (NarutoShippudenModVariables.get(entity).mangekyoushrainganitachiamaterasulearn >= 1) {
							if (NarutoShippudenModVariables.get(entity).ninjutsu >= 20) {
								if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 350) {
									{
										Entity _shootFrom = entity;
										Level projectileLevel = _shootFrom.level();
										if (!projectileLevel.isClientSide()) {
											Projectile _entityToSpawn = new Object() {
												public Projectile getArrow(Level world, float damage, int knockback) {
													ModArrow entityToSpawn = new AmaterasuFlameItem.ArrowCustomEntity(AmaterasuFlameItem.arrow,
															world);

													entityToSpawn.setBaseDamage(damage);
													Compat.setKnockback(entityToSpawn, knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, 5, 1);
											_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
											_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1, 0);
											projectileLevel.addFreshEntity(_entityToSpawn);
										}
									}
									{
										double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 350);
										NarutoShippudenModVariables.ifPresent(entity, capability -> {
											capability.ChakraAmount = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									{
										double _setval = (NarutoShippudenModVariables.get(entity).Mangekyou_Sharingan_Technique_Use + 1);
										NarutoShippudenModVariables.ifPresent(entity, capability -> {
											capability.Mangekyou_Sharingan_Technique_Use = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 349) {
									if (entity instanceof Player && !entity.level().isClientSide()) {
										((Player) entity).sendSystemMessage(Component.literal("Not Enough Chakra"));
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 19) {
								if (entity instanceof Player && !entity.level().isClientSide()) {
									((Player) entity).sendSystemMessage(Component.literal("Not Enough Ninjutsu"));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).mangekyoushrainganitachiamaterasulearn >= 1)) {
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendSystemMessage(Component.literal("You haven't unlocked this technique."));
							}
						}
						if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
							if (entity instanceof Player)
								((Player) entity).getCooldowns().addCooldown(new ItemStack(MangekyouSharinganItachiReleaseTechniqueItem.block), (int) 200);
						} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
							if (entity instanceof Player)
								((Player) entity).getCooldowns().addCooldown(new ItemStack(MangekyouSharinganItachiReleaseTechniqueItem.block), (int) 160);
						} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
							if (entity instanceof Player)
								((Player) entity).getCooldowns().addCooldown(new ItemStack(MangekyouSharinganItachiReleaseTechniqueItem.block), (int) 120);
						} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
							if (entity instanceof Player)
								((Player) entity).getCooldowns().addCooldown(new ItemStack(MangekyouSharinganItachiReleaseTechniqueItem.block), (int) 80);
						} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
							if (entity instanceof Player)
								((Player) entity).getCooldowns().addCooldown(new ItemStack(MangekyouSharinganItachiReleaseTechniqueItem.block), (int) 40);
						}
					} else if (NarutoShippudenModVariables.get(entity).MangekyouSharinganActivate == false) {
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Activate Mangekyou Sharingan"));
						}
					}
				} else if (entity.isShiftKeyDown()) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Selected: Amaterasu"));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).MangekyouSharinganItachi == false) {
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("You haven't unlocked this release."));
				}
			}
		}
	}

	public static class MangekyouSharinganKakashiReleaseRightclickedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure MangekyouSharinganKakashiReleaseRightclicked!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (!entity.isShiftKeyDown()) {
				if (NarutoShippudenModVariables.get(entity).mangekyousharingankakashikamuilearn == 0) {
					if (NarutoShippudenModVariables.get(entity).jp >= 35) {
						if (entity instanceof Player) {
							ItemStack _setstack = new ItemStack(MangekyouSharinganKakashiReleaseTechniqueItem.block);
							_setstack.setCount((int) 1);
							Compat.giveItemToPlayer(((Player) entity), _setstack);
						}
						{
							double _setval = 1;
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.mangekyousharingankakashikamuilearn = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = (NarutoShippudenModVariables.get(entity).jp - 35);
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.jp = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendSystemMessage(Component.literal("-35 JP"));
						}
					} else if (NarutoShippudenModVariables.get(entity).jp <= 34) {
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendSystemMessage(Component.literal("Not Enough JP"));
						}
					}
				}
			} else if (entity.isShiftKeyDown()) {
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("Selected: Kamui"));
				}
			}
		}
	}

	public static class MangekyouSharinganKakashiReleaseTechniqueRightclickedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("world") == null) {
				if (!dependencies.containsKey("world"))
					NarutoShippudenMod.LOGGER
							.warn("Failed to load dependency world for procedure MangekyouSharinganKakashiReleaseTechniqueRightclicked!");
				return;
			}
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER
							.warn("Failed to load dependency entity for procedure MangekyouSharinganKakashiReleaseTechniqueRightclicked!");
				return;
			}
			LevelAccessor world = (LevelAccessor) dependencies.get("world");
			Entity entity = (Entity) dependencies.get("entity");
			double distance = 0;
			boolean found = false;
			if (NarutoShippudenModVariables.get(entity).MangekyouSharinganKakashi == true) {
				if (!entity.isShiftKeyDown()) {
					if (NarutoShippudenModVariables.get(entity).MangekyouSharinganActivate == true) {
						if (NarutoShippudenModVariables.get(entity).mangekyousharingankakashikamuilearn >= 1) {
							if (NarutoShippudenModVariables.get(entity).ninjutsu >= 20) {
								if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 350) {
									distance = 10;
									for (int index0 = 0; index0 < (int) (10); index0++) {
										if (found == false) {
											if (((Entity) world.getEntitiesOfClass(LivingEntity.class,
													new AABB(
															(entity.level()
																	.clip(new ClipContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																					entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																			ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																	.getBlockPos().getX()) - (1 / 2d),
															(entity.level()
																	.clip(new ClipContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																					entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																			ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																	.getBlockPos().getY()) - (1 / 2d),
															(entity.level()
																	.clip(new ClipContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																					entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																			ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																	.getBlockPos().getZ()) - (1 / 2d),
															(entity.level()
																	.clip(new ClipContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																					entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																			ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																	.getBlockPos().getX()) + (1 / 2d),
															(entity.level()
																	.clip(new ClipContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																					entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																			ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																	.getBlockPos().getY()) + (1 / 2d),
															(entity.level()
																	.clip(new ClipContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																					entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																			ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																	.getBlockPos().getZ()) + (1 / 2d)),
													null).stream().sorted(new Object() {
														Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
															return Comparator
																	.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.distanceToSqr(_x, _y, _z)));
														}
													}.compareDistOf(
															(entity.level()
																	.clip(new ClipContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																					entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																			ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																	.getBlockPos().getX()),
															(entity.level()
																	.clip(new ClipContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																					entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																			ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																	.getBlockPos().getY()),
															(entity.level()
																	.clip(new ClipContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																					entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																			ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																	.getBlockPos().getZ())))
													.findFirst().orElse(null)) != null) {
												if (!(((Entity) world.getEntitiesOfClass(LivingEntity.class, new AABB(
														(entity.level()
																.clip(new ClipContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																				entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																		ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getX()) - (1 / 2d),
														(entity.level()
																.clip(new ClipContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																				entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																		ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getY()) - (1 / 2d),
														(entity.level()
																.clip(new ClipContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																				entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																		ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getZ()) - (1 / 2d),
														(entity.level()
																.clip(new ClipContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																				entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																		ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getX()) + (1 / 2d),
														(entity.level()
																.clip(new ClipContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																				entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																		ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getY()) + (1 / 2d),
														(entity.level()
																.clip(new ClipContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																				entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																		ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getZ()) + (1 / 2d)),
														null).stream().sorted(new Object() {
															Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																return Comparator.comparing(
																		(Function<Entity, Double>) (_entcnd -> _entcnd.distanceToSqr(_x, _y, _z)));
															}
														}.compareDistOf(
																(entity.level().clip(new ClipContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																				entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																		ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																		.getBlockPos().getX()),
																(entity.level()
																		.clip(new ClipContext(entity.getEyePosition(1f),
																				entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																						entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																				ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE,
																				entity))
																		.getBlockPos().getY()),
																(entity.level().clip(new ClipContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																				entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																		ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																		.getBlockPos().getZ())))
														.findFirst().orElse(null)) == entity)) {
													if (!((((Entity) world.getEntitiesOfClass(LivingEntity.class, new AABB(
															(entity.level()
																	.clip(new ClipContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																					entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																			ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																	.getBlockPos().getX()) - (1 / 2d),
															(entity.level()
																	.clip(new ClipContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																					entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																			ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																	.getBlockPos().getY()) - (1 / 2d),
															(entity.level()
																	.clip(new ClipContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																					entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																			ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																	.getBlockPos().getZ()) - (1 / 2d),
															(entity.level()
																	.clip(new ClipContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																					entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																			ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																	.getBlockPos().getX()) + (1 / 2d),
															(entity.level()
																	.clip(new ClipContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																					entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																			ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																	.getBlockPos().getY()) + (1 / 2d),
															(entity.level()
																	.clip(new ClipContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																					entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																			ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																	.getBlockPos().getZ()) + (1 / 2d)),
															null).stream().sorted(new Object() {
																Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																	return Comparator.comparing(
																			(Function<Entity, Double>) (_entcnd -> _entcnd.distanceToSqr(_x, _y, _z)));
																}
															}.compareDistOf(
																	(entity.level().clip(new ClipContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																					entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																			ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																			.getBlockPos().getX()),
																	(entity.level().clip(new ClipContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																					entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																			ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																			.getBlockPos().getY()),
																	(entity.level().clip(new ClipContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																					entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																			ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																			.getBlockPos().getZ())))
															.findFirst().orElse(null)).level().dimension()) == (ResourceKey.create(
																	Registries.DIMENSION, Identifier.parse("naruto_shippuden:kamui_dimension"))))) {
														{
															Entity _ent = ((Entity) world.getEntitiesOfClass(LivingEntity.class, new AABB(
																	(entity.level().clip(new ClipContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																					entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																			ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																			.getBlockPos().getX()) - (1 / 2d),
																	(entity.level().clip(new ClipContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																					entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																			ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																			.getBlockPos().getY()) - (1 / 2d),
																	(entity.level().clip(new ClipContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																					entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																			ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																			.getBlockPos().getZ()) - (1 / 2d),
																	(entity.level().clip(new ClipContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																					entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																			ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																			.getBlockPos().getX()) + (1 / 2d),
																	(entity.level().clip(new ClipContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																					entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																			ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																			.getBlockPos().getY()) + (1 / 2d),
																	(entity.level().clip(new ClipContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																					entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																			ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																			.getBlockPos().getZ()) + (1 / 2d)),
																	null).stream().sorted(new Object() {
																		Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																			return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd
																					.distanceToSqr(_x, _y, _z)));
																		}
																	}.compareDistOf(
																			(entity.level().clip(new ClipContext(entity.getEyePosition(1f),
																					entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																							entity.getViewVector(1f).y * distance,
																							entity.getViewVector(1f).z * distance),
																					ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE,
																					entity)).getBlockPos().getX()),
																			(entity.level().clip(new ClipContext(entity.getEyePosition(1f),
																					entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																							entity.getViewVector(1f).y * distance,
																							entity.getViewVector(1f).z * distance),
																					ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE,
																					entity)).getBlockPos().getY()),
																			(entity.level().clip(new ClipContext(entity.getEyePosition(1f),
																					entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																							entity.getViewVector(1f).y * distance,
																							entity.getViewVector(1f).z * distance),
																					ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE,
																					entity)).getBlockPos().getZ())))
																	.findFirst().orElse(null));
															if (!_ent.level().isClientSide() && _ent.level().getServer() != null) {
																Compat.runCommand(_ent, "/execute in naruto_shippuden:kamui_dimension run tp ~ 71 ~");
															}
														}
													} else if ((((Entity) world.getEntitiesOfClass(LivingEntity.class, new AABB(
															(entity.level()
																	.clip(new ClipContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																					entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																			ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																	.getBlockPos().getX()) - (1 / 2d),
															(entity.level()
																	.clip(new ClipContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																					entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																			ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																	.getBlockPos().getY()) - (1 / 2d),
															(entity.level()
																	.clip(new ClipContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																					entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																			ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																	.getBlockPos().getZ()) - (1 / 2d),
															(entity.level()
																	.clip(new ClipContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																					entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																			ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																	.getBlockPos().getX()) + (1 / 2d),
															(entity.level()
																	.clip(new ClipContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																					entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																			ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																	.getBlockPos().getY()) + (1 / 2d),
															(entity.level()
																	.clip(new ClipContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																					entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																			ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																	.getBlockPos().getZ()) + (1 / 2d)),
															null).stream().sorted(new Object() {
																Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																	return Comparator.comparing(
																			(Function<Entity, Double>) (_entcnd -> _entcnd.distanceToSqr(_x, _y, _z)));
																}
															}.compareDistOf(
																	(entity.level().clip(new ClipContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																					entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																			ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																			.getBlockPos().getX()),
																	(entity.level().clip(new ClipContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																					entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																			ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																			.getBlockPos().getY()),
																	(entity.level().clip(new ClipContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																					entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																			ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																			.getBlockPos().getZ())))
															.findFirst().orElse(null)).level().dimension()) == (ResourceKey.create(
																	Registries.DIMENSION, Identifier.parse("naruto_shippuden:kamui_dimension")))) {
														{
															Entity _ent = ((Entity) world.getEntitiesOfClass(LivingEntity.class, new AABB(
																	(entity.level().clip(new ClipContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																					entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																			ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																			.getBlockPos().getX()) - (1 / 2d),
																	(entity.level().clip(new ClipContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																					entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																			ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																			.getBlockPos().getY()) - (1 / 2d),
																	(entity.level().clip(new ClipContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																					entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																			ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																			.getBlockPos().getZ()) - (1 / 2d),
																	(entity.level().clip(new ClipContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																					entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																			ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																			.getBlockPos().getX()) + (1 / 2d),
																	(entity.level().clip(new ClipContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																					entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																			ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																			.getBlockPos().getY()) + (1 / 2d),
																	(entity.level().clip(new ClipContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																					entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																			ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																			.getBlockPos().getZ()) + (1 / 2d)),
																	null).stream().sorted(new Object() {
																		Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																			return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd
																					.distanceToSqr(_x, _y, _z)));
																		}
																	}.compareDistOf(
																			(entity.level().clip(new ClipContext(entity.getEyePosition(1f),
																					entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																							entity.getViewVector(1f).y * distance,
																							entity.getViewVector(1f).z * distance),
																					ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE,
																					entity)).getBlockPos().getX()),
																			(entity.level().clip(new ClipContext(entity.getEyePosition(1f),
																					entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																							entity.getViewVector(1f).y * distance,
																							entity.getViewVector(1f).z * distance),
																					ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE,
																					entity)).getBlockPos().getY()),
																			(entity.level().clip(new ClipContext(entity.getEyePosition(1f),
																					entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																							entity.getViewVector(1f).y * distance,
																							entity.getViewVector(1f).z * distance),
																					ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE,
																					entity)).getBlockPos().getZ())))
																	.findFirst().orElse(null));
															if (!_ent.level().isClientSide() && _ent.level().getServer() != null) {
																Compat.runCommand(_ent, "/execute in minecraft:overworld run tp ~ ~ ~");
															}
														}
													}
													if (!(((Entity) world.getEntitiesOfClass(LivingEntity.class, new AABB(
															(entity.level()
																	.clip(new ClipContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																					entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																			ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																	.getBlockPos().getX()) - (1 / 2d),
															(entity.level()
																	.clip(new ClipContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																					entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																			ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																	.getBlockPos().getY()) - (1 / 2d),
															(entity.level()
																	.clip(new ClipContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																					entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																			ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																	.getBlockPos().getZ()) - (1 / 2d),
															(entity.level()
																	.clip(new ClipContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																					entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																			ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																	.getBlockPos().getX()) + (1 / 2d),
															(entity.level()
																	.clip(new ClipContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																					entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																			ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																	.getBlockPos().getY()) + (1 / 2d),
															(entity.level()
																	.clip(new ClipContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																					entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																			ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																	.getBlockPos().getZ()) + (1 / 2d)),
															null).stream().sorted(new Object() {
																Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																	return Comparator.comparing(
																			(Function<Entity, Double>) (_entcnd -> _entcnd.distanceToSqr(_x, _y, _z)));
																}
															}.compareDistOf(
																	(entity.level().clip(new ClipContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																					entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																			ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																			.getBlockPos().getX()),
																	(entity.level().clip(new ClipContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																					entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																			ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																			.getBlockPos().getY()),
																	(entity.level().clip(new ClipContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																					entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																			ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																			.getBlockPos().getZ())))
															.findFirst().orElse(null)) instanceof Player)) {
														if (!((Entity) world.getEntitiesOfClass(LivingEntity.class, new AABB(
																(entity.level().clip(new ClipContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																				entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																		ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																		.getBlockPos().getX()) - (1 / 2d),
																(entity.level().clip(new ClipContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																				entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																		ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																		.getBlockPos().getY()) - (1 / 2d),
																(entity.level().clip(new ClipContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																				entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																		ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																		.getBlockPos().getZ()) - (1 / 2d),
																(entity.level().clip(new ClipContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																				entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																		ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																		.getBlockPos().getX()) + (1 / 2d),
																(entity.level().clip(new ClipContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																				entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																		ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																		.getBlockPos().getY()) + (1 / 2d),
																(entity.level().clip(new ClipContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																				entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																		ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																		.getBlockPos().getZ()) + (1 / 2d)),
																null).stream().sorted(new Object() {
																	Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																		return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd
																				.distanceToSqr(_x, _y, _z)));
																	}
																}.compareDistOf(
																		(entity.level().clip(new ClipContext(entity.getEyePosition(1f),
																				entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																						entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																				ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE,
																				entity)).getBlockPos().getX()),
																		(entity.level().clip(new ClipContext(entity.getEyePosition(1f),
																				entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																						entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																				ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE,
																				entity)).getBlockPos().getY()),
																		(entity.level().clip(new ClipContext(entity.getEyePosition(1f),
																				entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																						entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																				ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE,
																				entity)).getBlockPos().getZ())))
																.findFirst().orElse(null)).level().isClientSide())
															((Entity) world
																	.getEntitiesOfClass(LivingEntity.class,
																			new AABB(
																					(entity.level().clip(new ClipContext(
																							entity.getEyePosition(1f),
																							entity.getEyePosition(1f).add(
																									entity.getViewVector(1f).x * distance,
																									entity.getViewVector(1f).y * distance,
																									entity.getViewVector(1f).z * distance),
																							ClipContext.Block.OUTLINE,
																							ClipContext.Fluid.NONE, entity)).getBlockPos().getX())
																							- (1 / 2d),
																					(entity.level().clip(new ClipContext(
																							entity.getEyePosition(1f),
																							entity.getEyePosition(1f).add(
																									entity.getViewVector(1f).x * distance,
																									entity.getViewVector(1f).y * distance,
																									entity.getViewVector(1f).z * distance),
																							ClipContext.Block.OUTLINE,
																							ClipContext.Fluid.NONE, entity)).getBlockPos().getY())
																							- (1 / 2d),
																					(entity.level().clip(new ClipContext(
																							entity.getEyePosition(1f),
																							entity.getEyePosition(1f).add(
																									entity.getViewVector(1f).x * distance,
																									entity.getViewVector(1f).y * distance,
																									entity.getViewVector(1f).z * distance),
																							ClipContext.Block.OUTLINE,
																							ClipContext.Fluid.NONE, entity)).getBlockPos().getZ())
																							- (1 / 2d),
																					(entity.level().clip(new ClipContext(
																							entity.getEyePosition(1f),
																							entity.getEyePosition(1f).add(
																									entity.getViewVector(1f).x * distance,
																									entity.getViewVector(1f).y * distance,
																									entity.getViewVector(1f).z * distance),
																							ClipContext.Block.OUTLINE,
																							ClipContext.Fluid.NONE, entity)).getBlockPos().getX())
																							+ (1 / 2d),
																					(entity.level().clip(new ClipContext(
																							entity.getEyePosition(1f),
																							entity.getEyePosition(1f).add(
																									entity.getViewVector(1f).x * distance,
																									entity.getViewVector(1f).y * distance,
																									entity.getViewVector(1f).z * distance),
																							ClipContext.Block.OUTLINE,
																							ClipContext.Fluid.NONE, entity)).getBlockPos().getY())
																							+ (1 / 2d),
																					(entity.level().clip(new ClipContext(
																							entity.getEyePosition(1f),
																							entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																									entity.getViewVector(1f).y * distance,
																									entity.getViewVector(1f).z * distance),
																							ClipContext.Block.OUTLINE,
																							ClipContext.Fluid.NONE, entity)).getBlockPos().getZ())
																							+ (1 / 2d)),
																			null)
																	.stream().sorted(new Object() {
																		Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																			return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd
																					.distanceToSqr(_x, _y, _z)));
																		}
																	}.compareDistOf(
																			(entity.level().clip(new ClipContext(entity.getEyePosition(1f),
																					entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																							entity.getViewVector(1f).y * distance,
																							entity.getViewVector(1f).z * distance),
																					ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE,
																					entity)).getBlockPos().getX()),
																			(entity.level().clip(new ClipContext(entity.getEyePosition(1f),
																					entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																							entity.getViewVector(1f).y * distance,
																							entity.getViewVector(1f).z * distance),
																					ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE,
																					entity)).getBlockPos().getY()),
																			(entity.level().clip(new ClipContext(entity.getEyePosition(1f),
																					entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																							entity.getViewVector(1f).y * distance,
																							entity.getViewVector(1f).z * distance),
																					ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE,
																					entity)).getBlockPos().getZ())))
																	.findFirst().orElse(null)).discard();
													}
													found = (true);
												}
											} else if (!(((Entity) world.getEntitiesOfClass(LivingEntity.class,
													new AABB(
															(entity.level()
																	.clip(new ClipContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																					entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																			ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																	.getBlockPos().getX()) - (1 / 2d),
															(entity.level()
																	.clip(new ClipContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																					entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																			ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																	.getBlockPos().getY()) - (1 / 2d),
															(entity.level()
																	.clip(new ClipContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																					entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																			ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																	.getBlockPos().getZ()) - (1 / 2d),
															(entity.level()
																	.clip(new ClipContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																					entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																			ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																	.getBlockPos().getX()) + (1 / 2d),
															(entity.level()
																	.clip(new ClipContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																					entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																			ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																	.getBlockPos().getY()) + (1 / 2d),
															(entity.level()
																	.clip(new ClipContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																					entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																			ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																	.getBlockPos().getZ()) + (1 / 2d)),
													null).stream().sorted(new Object() {
														Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
															return Comparator
																	.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.distanceToSqr(_x, _y, _z)));
														}
													}.compareDistOf(
															(entity.level()
																	.clip(new ClipContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																					entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																			ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																	.getBlockPos().getX()),
															(entity.level()
																	.clip(new ClipContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																					entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																			ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																	.getBlockPos().getY()),
															(entity.level()
																	.clip(new ClipContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																					entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																			ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																	.getBlockPos().getZ())))
													.findFirst().orElse(null)) != null)) {
												distance = (distance + 1);
											}
										}
									}
									if (found == true) {
										{
											double _setval = (NarutoShippudenModVariables.get(entity).Mangekyou_Sharingan_Technique_Use + 1);
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.Mangekyou_Sharingan_Technique_Use = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 350);
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
										world.addParticle(KamuiParticleParticle.particle,
												(entity.level()
														.clip(new ClipContext(entity.getEyePosition(1f),
																entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																		entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
														.getBlockPos().getX()),
												(entity.level()
														.clip(new ClipContext(entity.getEyePosition(1f),
																entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																		entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
														.getBlockPos().getY()),
												(entity.level()
														.clip(new ClipContext(entity.getEyePosition(1f),
																entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																		entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
														.getBlockPos().getZ()),
												0, 0, 0);
										if (world instanceof Level && !world.isClientSide()) {
											((Level) world).playSound(null,
													BlockPos.containing(
															entity.level()
																	.clip(new ClipContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																					entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																			ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																	.getBlockPos().getX(),
															entity.level()
																	.clip(new ClipContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																					entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																			ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																	.getBlockPos().getY(),
															entity.level()
																	.clip(new ClipContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																					entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																			ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																	.getBlockPos().getZ()),
													(net.minecraft.sounds.SoundEvent) BuiltInRegistries.SOUND_EVENT
															.getValue(Identifier.parse("naruto_shippuden:kamui")),
													SoundSource.NEUTRAL, (float) 1, (float) 1);
										} else {
											((Level) world).playLocalSound(
													(entity.level()
															.clip(new ClipContext(entity.getEyePosition(1f),
																	entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																			entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																	ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
															.getBlockPos().getX()),
													(entity.level().clip(new ClipContext(entity.getEyePosition(1f),
															entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																	entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
															ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()),
													(entity.level()
															.clip(new ClipContext(entity.getEyePosition(1f),
																	entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																			entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																	ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
															.getBlockPos().getZ()),
													(net.minecraft.sounds.SoundEvent) BuiltInRegistries.SOUND_EVENT
															.getValue(Identifier.parse("naruto_shippuden:kamui")),
													SoundSource.NEUTRAL, (float) 1, (float) 1, false);
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 349) {
									if (entity instanceof Player && !entity.level().isClientSide()) {
										((Player) entity).sendSystemMessage(Component.literal("Not Enough Chakra"));
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 19) {
								if (entity instanceof Player && !entity.level().isClientSide()) {
									((Player) entity).sendSystemMessage(Component.literal("Not Enough Ninjutsu"));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).mangekyousharingankakashikamuilearn >= 1)) {
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendSystemMessage(Component.literal("You haven't unlocked this technique."));
							}
						}
						if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
							if (entity instanceof Player)
								((Player) entity).getCooldowns().addCooldown(new ItemStack(MangekyouSharinganKakashiReleaseTechniqueItem.block), (int) 200);
						} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
							if (entity instanceof Player)
								((Player) entity).getCooldowns().addCooldown(new ItemStack(MangekyouSharinganKakashiReleaseTechniqueItem.block), (int) 160);
						} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
							if (entity instanceof Player)
								((Player) entity).getCooldowns().addCooldown(new ItemStack(MangekyouSharinganKakashiReleaseTechniqueItem.block), (int) 120);
						} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
							if (entity instanceof Player)
								((Player) entity).getCooldowns().addCooldown(new ItemStack(MangekyouSharinganKakashiReleaseTechniqueItem.block), (int) 80);
						} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
							if (entity instanceof Player)
								((Player) entity).getCooldowns().addCooldown(new ItemStack(MangekyouSharinganKakashiReleaseTechniqueItem.block), (int) 40);
						}
					} else if (NarutoShippudenModVariables.get(entity).MangekyouSharinganActivate == false) {
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Activate Mangekyou Sharingan"));
						}
					}
				} else if (entity.isShiftKeyDown()) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Selected: Kamui Long-Range"));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).MangekyouSharinganKakashi == false) {
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("You haven't unlocked this release."));
				}
			}
		}
	}

	public static class MangekyouSharinganMadaraReleaseRightclickedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure MangekyouSharinganMadaraReleaseRightclicked!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (!entity.isShiftKeyDown()) {
				if (NarutoShippudenModVariables.get(entity).mangekyousharinganmadarasusanorelease == 0) {
					if (NarutoShippudenModVariables.get(entity).jp >= 10) {
						{
							double _setval = 1;
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.mangekyousharinganmadarasusanolearn = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = (NarutoShippudenModVariables.get(entity).jp - 10);
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.jp = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = (NarutoShippudenModVariables.get(entity).mangekyousharinganmadarasusanorelease + 1);
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.mangekyousharinganmadarasusanorelease = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendSystemMessage(Component.literal("-10 JP"));
						}
					} else if (NarutoShippudenModVariables.get(entity).jp <= 9) {
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendSystemMessage(Component.literal("Not Enough JP"));
						}
					}
				} else if (NarutoShippudenModVariables.get(entity).mangekyousharinganmadarasusanorelease == 1) {
					if (NarutoShippudenModVariables.get(entity).jp >= 20) {
						{
							double _setval = 2;
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.mangekyousharinganmadarasusanolearn = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = (NarutoShippudenModVariables.get(entity).jp - 20);
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.jp = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = (NarutoShippudenModVariables.get(entity).mangekyousharinganmadarasusanorelease + 1);
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.mangekyousharinganmadarasusanorelease = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendSystemMessage(Component.literal("-20 JP"));
						}
					} else if (NarutoShippudenModVariables.get(entity).jp <= 19) {
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendSystemMessage(Component.literal("Not Enough JP"));
						}
					}
				} else if (NarutoShippudenModVariables.get(entity).mangekyousharinganmadarasusanorelease == 2) {
					if (NarutoShippudenModVariables.get(entity).jp >= 30) {
						{
							double _setval = 3;
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.mangekyousharinganmadarasusanolearn = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = (NarutoShippudenModVariables.get(entity).jp - 30);
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.jp = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = (NarutoShippudenModVariables.get(entity).mangekyousharinganmadarasusanorelease + 1);
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.mangekyousharinganmadarasusanorelease = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendSystemMessage(Component.literal("-30 JP"));
						}
					} else if (NarutoShippudenModVariables.get(entity).jp <= 29) {
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendSystemMessage(Component.literal("Not Enough JP"));
						}
					}
				} else if (NarutoShippudenModVariables.get(entity).mangekyousharinganmadarasusanorelease == 3) {
					if (NarutoShippudenModVariables.get(entity).jp >= 40) {
						{
							double _setval = 4;
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.mangekyousharinganmadarasusanolearn = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = (NarutoShippudenModVariables.get(entity).jp - 40);
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.jp = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = (NarutoShippudenModVariables.get(entity).mangekyousharinganmadarasusanorelease + 1);
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.mangekyousharinganmadarasusanorelease = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendSystemMessage(Component.literal("-40 JP"));
						}
					} else if (NarutoShippudenModVariables.get(entity).jp <= 39) {
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendSystemMessage(Component.literal("Not Enough JP"));
						}
					}
				}
			} else if (entity.isShiftKeyDown()) {
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("Selected: Susano"));
				}
			}
		}
	}

	public static class MangekyouSharinganObitoReleaseRightclickProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("world") == null) {
				if (!dependencies.containsKey("world"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure MangekyouSharinganObitoReleaseRightclick!");
				return;
			}
			if (dependencies.get("x") == null) {
				if (!dependencies.containsKey("x"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency x for procedure MangekyouSharinganObitoReleaseRightclick!");
				return;
			}
			if (dependencies.get("y") == null) {
				if (!dependencies.containsKey("y"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency y for procedure MangekyouSharinganObitoReleaseRightclick!");
				return;
			}
			if (dependencies.get("z") == null) {
				if (!dependencies.containsKey("z"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency z for procedure MangekyouSharinganObitoReleaseRightclick!");
				return;
			}
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure MangekyouSharinganObitoReleaseRightclick!");
				return;
			}
			LevelAccessor world = (LevelAccessor) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			Entity entity = (Entity) dependencies.get("entity");
			boolean found = false;
			double distance = 0;
			if (NarutoShippudenModVariables.get(entity).MangekyouSharinganObito == true) {
				if (!entity.isShiftKeyDown()) {
					if (NarutoShippudenModVariables.get(entity).MangekyouSharinganActivate == true) {
						if (NarutoShippudenModVariables.get(entity).mangekyousharinganobitokamuitechnique == 0) {
							if (NarutoShippudenModVariables.get(entity).mangekyousharinganobitokamuilearn >= 1) {
								if (NarutoShippudenModVariables.get(entity).ninjutsu >= 20) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 350) {
										if (!((entity.level().dimension()) == (ResourceKey.create(Registries.DIMENSION,
												Identifier.parse("naruto_shippuden:kamui_dimension"))))) {
											{
												Entity _ent = entity;
												if (!_ent.level().isClientSide() && _ent.level().getServer() != null) {
													Compat.runCommand(_ent, "/execute in naruto_shippuden:kamui_dimension run tp ~ 71 ~");
												}
											}
										} else if ((entity.level().dimension()) == (ResourceKey.create(Registries.DIMENSION,
												Identifier.parse("naruto_shippuden:kamui_dimension")))) {
											{
												Entity _ent = entity;
												if (!_ent.level().isClientSide() && _ent.level().getServer() != null) {
													Compat.runCommand(_ent, "/execute in minecraft:overworld run tp ~ ~ ~");
												}
											}
										}
										world.addParticle(KamuiParticleParticle.particle, x, y, z, 0, 0, 0);
										if (world instanceof Level && !world.isClientSide()) {
											((Level) world).playSound(null, BlockPos.containing(x, y, z),
													(net.minecraft.sounds.SoundEvent) BuiltInRegistries.SOUND_EVENT
															.getValue(Identifier.parse("naruto_shippuden:kamui")),
													SoundSource.NEUTRAL, (float) 1, (float) 1);
										} else {
											((Level) world).playLocalSound(x, y, z,
													(net.minecraft.sounds.SoundEvent) BuiltInRegistries.SOUND_EVENT
															.getValue(Identifier.parse("naruto_shippuden:kamui")),
													SoundSource.NEUTRAL, (float) 1, (float) 1, false);
										}
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 350);
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
										{
											double _setval = (NarutoShippudenModVariables.get(entity).Mangekyou_Sharingan_Technique_Use + 1);
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.Mangekyou_Sharingan_Technique_Use = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 349) {
										if (entity instanceof Player && !entity.level().isClientSide()) {
											((Player) entity).sendSystemMessage(Component.literal("Not Enough Chakra"));
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 19) {
									if (entity instanceof Player && !entity.level().isClientSide()) {
										((Player) entity).sendSystemMessage(Component.literal("Not Enough Ninjutsu"));
									}
								}
							} else if (!(NarutoShippudenModVariables.get(entity).mangekyousharinganobitokamuilearn >= 1)) {
								if (entity instanceof Player && !entity.level().isClientSide()) {
									((Player) entity).sendSystemMessage(Component.literal("You haven't unlocked this technique."));
								}
							}
						} else if (NarutoShippudenModVariables.get(entity).mangekyousharinganobitokamuitechnique == 1) {
							if (NarutoShippudenModVariables.get(entity).mangekyousharinganobitokamuilearn >= 2) {
								if (NarutoShippudenModVariables.get(entity).ninjutsu >= 20) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 350) {
										distance = 1;
										for (int index0 = 0; index0 < (int) (5); index0++) {
											if (found == false) {
												if (((Entity) world.getEntitiesOfClass(LivingEntity.class, new AABB(
														(entity.level()
																.clip(new ClipContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																				entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																		ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getX()) - (1 / 2d),
														(entity.level()
																.clip(new ClipContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																				entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																		ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getY()) - (1 / 2d),
														(entity.level()
																.clip(new ClipContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																				entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																		ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getZ()) - (1 / 2d),
														(entity.level()
																.clip(new ClipContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																				entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																		ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getX()) + (1 / 2d),
														(entity.level()
																.clip(new ClipContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																				entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																		ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getY()) + (1 / 2d),
														(entity.level()
																.clip(new ClipContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																				entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																		ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getZ()) + (1 / 2d)),
														null).stream().sorted(new Object() {
															Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																return Comparator.comparing(
																		(Function<Entity, Double>) (_entcnd -> _entcnd.distanceToSqr(_x, _y, _z)));
															}
														}.compareDistOf(
																(entity.level().clip(new ClipContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																				entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																		ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																		.getBlockPos().getX()),
																(entity.level()
																		.clip(new ClipContext(entity.getEyePosition(1f),
																				entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																						entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																				ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE,
																				entity))
																		.getBlockPos().getY()),
																(entity.level().clip(new ClipContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																				entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																		ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																		.getBlockPos().getZ())))
														.findFirst().orElse(null)) != null) {
													if (!(((Entity) world.getEntitiesOfClass(LivingEntity.class, new AABB(
															(entity.level()
																	.clip(new ClipContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																					entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																			ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																	.getBlockPos().getX()) - (1 / 2d),
															(entity.level()
																	.clip(new ClipContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																					entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																			ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																	.getBlockPos().getY()) - (1 / 2d),
															(entity.level()
																	.clip(new ClipContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																					entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																			ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																	.getBlockPos().getZ()) - (1 / 2d),
															(entity.level()
																	.clip(new ClipContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																					entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																			ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																	.getBlockPos().getX()) + (1 / 2d),
															(entity.level()
																	.clip(new ClipContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																					entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																			ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																	.getBlockPos().getY()) + (1 / 2d),
															(entity.level()
																	.clip(new ClipContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																					entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																			ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																	.getBlockPos().getZ()) + (1 / 2d)),
															null).stream().sorted(new Object() {
																Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																	return Comparator.comparing(
																			(Function<Entity, Double>) (_entcnd -> _entcnd.distanceToSqr(_x, _y, _z)));
																}
															}.compareDistOf(
																	(entity.level().clip(new ClipContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																					entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																			ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																			.getBlockPos().getX()),
																	(entity.level().clip(new ClipContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																					entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																			ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																			.getBlockPos().getY()),
																	(entity.level().clip(new ClipContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																					entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																			ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																			.getBlockPos().getZ())))
															.findFirst().orElse(null)) == entity)) {
														if (!((((Entity) world.getEntitiesOfClass(LivingEntity.class, new AABB(
																(entity.level().clip(new ClipContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																				entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																		ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																		.getBlockPos().getX()) - (1 / 2d),
																(entity.level().clip(new ClipContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																				entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																		ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																		.getBlockPos().getY()) - (1 / 2d),
																(entity.level().clip(new ClipContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																				entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																		ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																		.getBlockPos().getZ()) - (1 / 2d),
																(entity.level().clip(new ClipContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																				entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																		ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																		.getBlockPos().getX()) + (1 / 2d),
																(entity.level().clip(new ClipContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																				entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																		ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																		.getBlockPos().getY()) + (1 / 2d),
																(entity.level().clip(new ClipContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																				entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																		ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																		.getBlockPos().getZ()) + (1 / 2d)),
																null).stream().sorted(new Object() {
																	Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																		return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd
																				.distanceToSqr(_x, _y, _z)));
																	}
																}.compareDistOf(
																		(entity.level().clip(new ClipContext(entity.getEyePosition(1f),
																				entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																						entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																				ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE,
																				entity)).getBlockPos().getX()),
																		(entity.level().clip(new ClipContext(entity.getEyePosition(1f),
																				entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																						entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																				ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE,
																				entity)).getBlockPos().getY()),
																		(entity.level().clip(new ClipContext(entity.getEyePosition(1f),
																				entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																						entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																				ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE,
																				entity)).getBlockPos().getZ())))
																.findFirst().orElse(null)).level().dimension()) == (ResourceKey.create(
																		Registries.DIMENSION, Identifier.parse("naruto_shippuden:kamui_dimension"))))) {
															{
																Entity _ent = ((Entity) world
																		.getEntitiesOfClass(LivingEntity.class,
																				new AABB(
																						(entity.level()
																								.clip(
																										new ClipContext(entity.getEyePosition(1f),
																												entity.getEyePosition(1f).add(
																														entity.getViewVector(1f).x * distance,
																														entity.getViewVector(1f).y * distance,
																														entity.getViewVector(1f).z * distance),
																												ClipContext.Block.OUTLINE,
																												ClipContext.Fluid.NONE, entity))
																								.getBlockPos().getX()) - (1 / 2d),
																						(entity.level()
																								.clip(
																										new ClipContext(entity.getEyePosition(1f),
																												entity.getEyePosition(1f).add(
																														entity.getViewVector(1f).x * distance,
																														entity.getViewVector(1f).y * distance,
																														entity.getViewVector(1f).z * distance),
																												ClipContext.Block.OUTLINE,
																												ClipContext.Fluid.NONE, entity))
																								.getBlockPos().getY()) - (1 / 2d),
																						(entity.level()
																								.clip(
																										new ClipContext(entity.getEyePosition(1f),
																												entity.getEyePosition(1f).add(
																														entity.getViewVector(1f).x * distance,
																														entity.getViewVector(1f).y * distance,
																														entity.getViewVector(1f).z * distance),
																												ClipContext.Block.OUTLINE,
																												ClipContext.Fluid.NONE, entity))
																								.getBlockPos().getZ()) - (1 / 2d),
																						(entity.level()
																								.clip(
																										new ClipContext(entity.getEyePosition(1f),
																												entity.getEyePosition(1f).add(
																														entity.getViewVector(1f).x * distance,
																														entity.getViewVector(1f).y * distance,
																														entity.getViewVector(1f).z * distance),
																												ClipContext.Block.OUTLINE,
																												ClipContext.Fluid.NONE, entity))
																								.getBlockPos().getX()) + (1 / 2d),
																						(entity.level()
																								.clip(
																										new ClipContext(entity.getEyePosition(1f),
																												entity.getEyePosition(1f).add(
																														entity.getViewVector(1f).x * distance,
																														entity.getViewVector(1f).y * distance,
																														entity.getViewVector(1f).z * distance),
																												ClipContext.Block.OUTLINE,
																												ClipContext.Fluid.NONE, entity))
																								.getBlockPos().getY()) + (1 / 2d),
																						(entity.level()
																								.clip(
																										new ClipContext(entity.getEyePosition(1f),
																												entity.getEyePosition(1f).add(
																														entity.getViewVector(1f).x * distance,
																														entity.getViewVector(1f).y * distance,
																														entity.getViewVector(1f).z * distance),
																												ClipContext.Block.OUTLINE,
																												ClipContext.Fluid.NONE, entity))
																								.getBlockPos().getZ()) + (1 / 2d)),
																				null)
																		.stream().sorted(new Object() {
																			Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																				return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd
																						.distanceToSqr(_x, _y, _z)));
																			}
																		}.compareDistOf(
																				(entity.level().clip(new ClipContext(
																						entity.getEyePosition(1f),
																						entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																								entity.getViewVector(1f).y * distance,
																								entity.getViewVector(1f).z * distance),
																						ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE,
																						entity)).getBlockPos().getX()),
																				(entity.level().clip(new ClipContext(
																						entity.getEyePosition(1f),
																						entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																								entity.getViewVector(1f).y * distance,
																								entity.getViewVector(1f).z * distance),
																						ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE,
																						entity)).getBlockPos().getY()),
																				(entity.level()
																						.clip(new ClipContext(entity.getEyePosition(1f),
																								entity.getEyePosition(1f).add(
																										entity.getViewVector(1f).x * distance,
																										entity.getViewVector(1f).y * distance,
																										entity.getViewVector(1f).z * distance),
																								ClipContext.Block.OUTLINE,
																								ClipContext.Fluid.NONE, entity))
																						.getBlockPos().getZ())))
																		.findFirst().orElse(null));
																if (!_ent.level().isClientSide() && _ent.level().getServer() != null) {
																	Compat.runCommand(_ent, "/execute in naruto_shippuden:kamui_dimension run tp ~ ~ ~");
																}
															}
														} else if ((((Entity) world.getEntitiesOfClass(LivingEntity.class, new AABB(
																(entity.level().clip(new ClipContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																				entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																		ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																		.getBlockPos().getX()) - (1 / 2d),
																(entity.level().clip(new ClipContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																				entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																		ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																		.getBlockPos().getY()) - (1 / 2d),
																(entity.level().clip(new ClipContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																				entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																		ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																		.getBlockPos().getZ()) - (1 / 2d),
																(entity.level().clip(new ClipContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																				entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																		ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																		.getBlockPos().getX()) + (1 / 2d),
																(entity.level().clip(new ClipContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																				entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																		ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																		.getBlockPos().getY()) + (1 / 2d),
																(entity.level().clip(new ClipContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																				entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																		ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																		.getBlockPos().getZ()) + (1 / 2d)),
																null).stream().sorted(new Object() {
																	Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																		return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd
																				.distanceToSqr(_x, _y, _z)));
																	}
																}.compareDistOf(
																		(entity.level().clip(new ClipContext(entity.getEyePosition(1f),
																				entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																						entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																				ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE,
																				entity)).getBlockPos().getX()),
																		(entity.level().clip(new ClipContext(entity.getEyePosition(1f),
																				entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																						entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																				ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE,
																				entity)).getBlockPos().getY()),
																		(entity.level().clip(new ClipContext(entity.getEyePosition(1f),
																				entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																						entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																				ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE,
																				entity)).getBlockPos().getZ())))
																.findFirst().orElse(null)).level().dimension()) == (ResourceKey.create(
																		Registries.DIMENSION, Identifier.parse("naruto_shippuden:kamui_dimension")))) {
															{
																Entity _ent = ((Entity) world
																		.getEntitiesOfClass(LivingEntity.class,
																				new AABB(
																						(entity.level()
																								.clip(
																										new ClipContext(entity.getEyePosition(1f),
																												entity.getEyePosition(1f).add(
																														entity.getViewVector(1f).x * distance,
																														entity.getViewVector(1f).y * distance,
																														entity.getViewVector(1f).z * distance),
																												ClipContext.Block.OUTLINE,
																												ClipContext.Fluid.NONE, entity))
																								.getBlockPos().getX()) - (1 / 2d),
																						(entity.level()
																								.clip(
																										new ClipContext(entity.getEyePosition(1f),
																												entity.getEyePosition(1f).add(
																														entity.getViewVector(1f).x * distance,
																														entity.getViewVector(1f).y * distance,
																														entity.getViewVector(1f).z * distance),
																												ClipContext.Block.OUTLINE,
																												ClipContext.Fluid.NONE, entity))
																								.getBlockPos().getY()) - (1 / 2d),
																						(entity.level()
																								.clip(
																										new ClipContext(entity.getEyePosition(1f),
																												entity.getEyePosition(1f).add(
																														entity.getViewVector(1f).x * distance,
																														entity.getViewVector(1f).y * distance,
																														entity.getViewVector(1f).z * distance),
																												ClipContext.Block.OUTLINE,
																												ClipContext.Fluid.NONE, entity))
																								.getBlockPos().getZ()) - (1 / 2d),
																						(entity.level()
																								.clip(
																										new ClipContext(entity.getEyePosition(1f),
																												entity.getEyePosition(1f).add(
																														entity.getViewVector(1f).x * distance,
																														entity.getViewVector(1f).y * distance,
																														entity.getViewVector(1f).z * distance),
																												ClipContext.Block.OUTLINE,
																												ClipContext.Fluid.NONE, entity))
																								.getBlockPos().getX()) + (1 / 2d),
																						(entity.level()
																								.clip(
																										new ClipContext(entity.getEyePosition(1f),
																												entity.getEyePosition(1f).add(
																														entity.getViewVector(1f).x * distance,
																														entity.getViewVector(1f).y * distance,
																														entity.getViewVector(1f).z * distance),
																												ClipContext.Block.OUTLINE,
																												ClipContext.Fluid.NONE, entity))
																								.getBlockPos().getY()) + (1 / 2d),
																						(entity.level()
																								.clip(
																										new ClipContext(entity.getEyePosition(1f),
																												entity.getEyePosition(1f).add(
																														entity.getViewVector(1f).x * distance,
																														entity.getViewVector(1f).y * distance,
																														entity.getViewVector(1f).z * distance),
																												ClipContext.Block.OUTLINE,
																												ClipContext.Fluid.NONE, entity))
																								.getBlockPos().getZ()) + (1 / 2d)),
																				null)
																		.stream().sorted(new Object() {
																			Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																				return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd
																						.distanceToSqr(_x, _y, _z)));
																			}
																		}.compareDistOf(
																				(entity.level().clip(new ClipContext(
																						entity.getEyePosition(1f),
																						entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																								entity.getViewVector(1f).y * distance,
																								entity.getViewVector(1f).z * distance),
																						ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE,
																						entity)).getBlockPos().getX()),
																				(entity.level().clip(new ClipContext(
																						entity.getEyePosition(1f),
																						entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																								entity.getViewVector(1f).y * distance,
																								entity.getViewVector(1f).z * distance),
																						ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE,
																						entity)).getBlockPos().getY()),
																				(entity.level()
																						.clip(new ClipContext(entity.getEyePosition(1f),
																								entity.getEyePosition(1f).add(
																										entity.getViewVector(1f).x * distance,
																										entity.getViewVector(1f).y * distance,
																										entity.getViewVector(1f).z * distance),
																								ClipContext.Block.OUTLINE,
																								ClipContext.Fluid.NONE, entity))
																						.getBlockPos().getZ())))
																		.findFirst().orElse(null));
																if (!_ent.level().isClientSide() && _ent.level().getServer() != null) {
																	Compat.runCommand(_ent, "/execute in minecraft:overworld run tp ~ ~ ~");
																}
															}
														}
														if (!(((Entity) world.getEntitiesOfClass(LivingEntity.class, new AABB(
																(entity.level().clip(new ClipContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																				entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																		ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																		.getBlockPos().getX()) - (1 / 2d),
																(entity.level().clip(new ClipContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																				entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																		ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																		.getBlockPos().getY()) - (1 / 2d),
																(entity.level().clip(new ClipContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																				entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																		ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																		.getBlockPos().getZ()) - (1 / 2d),
																(entity.level().clip(new ClipContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																				entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																		ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																		.getBlockPos().getX()) + (1 / 2d),
																(entity.level().clip(new ClipContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																				entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																		ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																		.getBlockPos().getY()) + (1 / 2d),
																(entity.level().clip(new ClipContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																				entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																		ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																		.getBlockPos().getZ()) + (1 / 2d)),
																null).stream().sorted(new Object() {
																	Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																		return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd
																				.distanceToSqr(_x, _y, _z)));
																	}
																}.compareDistOf(
																		(entity.level().clip(new ClipContext(entity.getEyePosition(1f),
																				entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																						entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																				ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE,
																				entity)).getBlockPos().getX()),
																		(entity.level().clip(new ClipContext(entity.getEyePosition(1f),
																				entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																						entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																				ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE,
																				entity)).getBlockPos().getY()),
																		(entity.level().clip(new ClipContext(entity.getEyePosition(1f),
																				entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																						entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																				ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE,
																				entity)).getBlockPos().getZ())))
																.findFirst().orElse(null)) instanceof Player)) {
															if (!((Entity) world
																	.getEntitiesOfClass(LivingEntity.class,
																			new AABB(
																					(entity.level().clip(new ClipContext(
																							entity.getEyePosition(1f),
																							entity.getEyePosition(1f).add(
																									entity.getViewVector(1f).x * distance,
																									entity.getViewVector(1f).y * distance,
																									entity.getViewVector(1f).z * distance),
																							ClipContext.Block.OUTLINE,
																							ClipContext.Fluid.NONE, entity)).getBlockPos().getX())
																							- (1 / 2d),
																					(entity.level().clip(new ClipContext(
																							entity.getEyePosition(1f),
																							entity.getEyePosition(1f).add(
																									entity.getViewVector(1f).x * distance,
																									entity.getViewVector(1f).y * distance,
																									entity.getViewVector(1f).z * distance),
																							ClipContext.Block.OUTLINE,
																							ClipContext.Fluid.NONE, entity)).getBlockPos().getY())
																							- (1 / 2d),
																					(entity.level().clip(new ClipContext(
																							entity.getEyePosition(1f),
																							entity.getEyePosition(1f).add(
																									entity.getViewVector(1f).x * distance,
																									entity.getViewVector(1f).y * distance,
																									entity.getViewVector(1f).z * distance),
																							ClipContext.Block.OUTLINE,
																							ClipContext.Fluid.NONE, entity)).getBlockPos().getZ())
																							- (1 / 2d),
																					(entity.level().clip(new ClipContext(
																							entity.getEyePosition(1f),
																							entity.getEyePosition(1f).add(
																									entity.getViewVector(1f).x * distance,
																									entity.getViewVector(1f).y * distance,
																									entity.getViewVector(1f).z * distance),
																							ClipContext.Block.OUTLINE,
																							ClipContext.Fluid.NONE, entity)).getBlockPos().getX())
																							+ (1 / 2d),
																					(entity.level().clip(new ClipContext(
																							entity.getEyePosition(1f),
																							entity.getEyePosition(1f).add(
																									entity.getViewVector(1f).x * distance,
																									entity.getViewVector(1f).y * distance,
																									entity.getViewVector(1f).z * distance),
																							ClipContext.Block.OUTLINE,
																							ClipContext.Fluid.NONE, entity)).getBlockPos().getY())
																							+ (1 / 2d),
																					(entity.level().clip(new ClipContext(
																							entity.getEyePosition(1f),
																							entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																									entity.getViewVector(1f).y * distance,
																									entity.getViewVector(1f).z * distance),
																							ClipContext.Block.OUTLINE,
																							ClipContext.Fluid.NONE, entity)).getBlockPos().getZ())
																							+ (1 / 2d)),
																			null)
																	.stream().sorted(new Object() {
																		Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																			return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd
																					.distanceToSqr(_x, _y, _z)));
																		}
																	}.compareDistOf(
																			(entity.level().clip(new ClipContext(entity.getEyePosition(1f),
																					entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																							entity.getViewVector(1f).y * distance,
																							entity.getViewVector(1f).z * distance),
																					ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE,
																					entity)).getBlockPos().getX()),
																			(entity.level().clip(new ClipContext(entity.getEyePosition(1f),
																					entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																							entity.getViewVector(1f).y * distance,
																							entity.getViewVector(1f).z * distance),
																					ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE,
																					entity)).getBlockPos().getY()),
																			(entity.level().clip(new ClipContext(entity.getEyePosition(1f),
																					entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																							entity.getViewVector(1f).y * distance,
																							entity.getViewVector(1f).z * distance),
																					ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE,
																					entity)).getBlockPos().getZ())))
																	.findFirst().orElse(null)).level().isClientSide())
																((Entity) world
																		.getEntitiesOfClass(LivingEntity.class,
																				new AABB(
																						(entity.level()
																								.clip(
																										new ClipContext(entity.getEyePosition(1f),
																												entity.getEyePosition(1f).add(
																														entity.getViewVector(1f).x * distance,
																														entity.getViewVector(1f).y * distance,
																														entity.getViewVector(1f).z * distance),
																												ClipContext.Block.OUTLINE,
																												ClipContext.Fluid.NONE, entity))
																								.getBlockPos().getX()) - (1 / 2d),
																						(entity.level()
																								.clip(
																										new ClipContext(entity.getEyePosition(1f),
																												entity.getEyePosition(1f).add(
																														entity.getViewVector(1f).x * distance,
																														entity.getViewVector(1f).y * distance,
																														entity.getViewVector(1f).z * distance),
																												ClipContext.Block.OUTLINE,
																												ClipContext.Fluid.NONE, entity))
																								.getBlockPos().getY()) - (1 / 2d),
																						(entity.level()
																								.clip(
																										new ClipContext(entity.getEyePosition(1f),
																												entity.getEyePosition(1f).add(
																														entity.getViewVector(1f).x * distance,
																														entity.getViewVector(1f).y * distance,
																														entity.getViewVector(1f).z * distance),
																												ClipContext.Block.OUTLINE,
																												ClipContext.Fluid.NONE, entity))
																								.getBlockPos().getZ()) - (1 / 2d),
																						(entity.level()
																								.clip(
																										new ClipContext(entity.getEyePosition(1f),
																												entity.getEyePosition(1f).add(
																														entity.getViewVector(1f).x * distance,
																														entity.getViewVector(1f).y * distance,
																														entity.getViewVector(1f).z * distance),
																												ClipContext.Block.OUTLINE,
																												ClipContext.Fluid.NONE, entity))
																								.getBlockPos().getX()) + (1 / 2d),
																						(entity.level()
																								.clip(
																										new ClipContext(entity.getEyePosition(1f),
																												entity.getEyePosition(1f).add(
																														entity.getViewVector(1f).x * distance,
																														entity.getViewVector(1f).y * distance,
																														entity.getViewVector(1f).z * distance),
																												ClipContext.Block.OUTLINE,
																												ClipContext.Fluid.NONE, entity))
																								.getBlockPos().getY()) + (1 / 2d),
																						(entity.level()
																								.clip(
																										new ClipContext(entity.getEyePosition(1f),
																												entity.getEyePosition(1f).add(
																														entity.getViewVector(1f).x * distance,
																														entity.getViewVector(1f).y * distance,
																														entity.getViewVector(1f).z * distance),
																												ClipContext.Block.OUTLINE,
																												ClipContext.Fluid.NONE, entity))
																								.getBlockPos().getZ()) + (1 / 2d)),
																				null)
																		.stream().sorted(new Object() {
																			Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																				return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd
																						.distanceToSqr(_x, _y, _z)));
																			}
																		}.compareDistOf(
																				(entity.level().clip(new ClipContext(
																						entity.getEyePosition(1f),
																						entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																								entity.getViewVector(1f).y * distance,
																								entity.getViewVector(1f).z * distance),
																						ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE,
																						entity)).getBlockPos().getX()),
																				(entity.level().clip(new ClipContext(
																						entity.getEyePosition(1f),
																						entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																								entity.getViewVector(1f).y * distance,
																								entity.getViewVector(1f).z * distance),
																						ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE,
																						entity)).getBlockPos().getY()),
																				(entity.level()
																						.clip(new ClipContext(entity.getEyePosition(1f),
																								entity.getEyePosition(1f).add(
																										entity.getViewVector(1f).x * distance,
																										entity.getViewVector(1f).y * distance,
																										entity.getViewVector(1f).z * distance),
																								ClipContext.Block.OUTLINE,
																								ClipContext.Fluid.NONE, entity))
																						.getBlockPos().getZ())))
																		.findFirst().orElse(null)).discard();
														}
														found = (true);
													}
												} else if (!(((Entity) world.getEntitiesOfClass(LivingEntity.class, new AABB(
														(entity.level()
																.clip(new ClipContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																				entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																		ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getX()) - (1 / 2d),
														(entity.level()
																.clip(new ClipContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																				entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																		ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getY()) - (1 / 2d),
														(entity.level()
																.clip(new ClipContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																				entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																		ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getZ()) - (1 / 2d),
														(entity.level()
																.clip(new ClipContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																				entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																		ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getX()) + (1 / 2d),
														(entity.level()
																.clip(new ClipContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																				entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																		ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getY()) + (1 / 2d),
														(entity.level()
																.clip(new ClipContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																				entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																		ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getZ()) + (1 / 2d)),
														null).stream().sorted(new Object() {
															Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																return Comparator.comparing(
																		(Function<Entity, Double>) (_entcnd -> _entcnd.distanceToSqr(_x, _y, _z)));
															}
														}.compareDistOf(
																(entity.level().clip(new ClipContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																				entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																		ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																		.getBlockPos().getX()),
																(entity.level()
																		.clip(new ClipContext(entity.getEyePosition(1f),
																				entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																						entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																				ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE,
																				entity))
																		.getBlockPos().getY()),
																(entity.level().clip(new ClipContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																				entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																		ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																		.getBlockPos().getZ())))
														.findFirst().orElse(null)) != null)) {
													distance = (distance + 1);
												}
											}
										}
										if (found == true) {
											{
												double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 350);
												NarutoShippudenModVariables.ifPresent(entity, capability -> {
															capability.ChakraAmount = _setval;
															capability.syncPlayerVariables(entity);
														});
											}
											{
												double _setval = (NarutoShippudenModVariables.get(entity).Mangekyou_Sharingan_Technique_Use
														+ 1);
												NarutoShippudenModVariables.ifPresent(entity, capability -> {
															capability.Mangekyou_Sharingan_Technique_Use = _setval;
															capability.syncPlayerVariables(entity);
														});
											}
											world.addParticle(KamuiParticleParticle.particle,
													(entity.level()
															.clip(new ClipContext(entity.getEyePosition(1f),
																	entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																			entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																	ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
															.getBlockPos().getX()),
													(entity.level().clip(new ClipContext(entity.getEyePosition(1f),
															entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																	entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
															ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()),
													(entity.level()
															.clip(new ClipContext(entity.getEyePosition(1f),
																	entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																			entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																	ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
															.getBlockPos().getZ()),
													0, 0, 0);
											if (world instanceof Level && !world.isClientSide()) {
												((Level) world).playSound(null, BlockPos.containing(
														entity.level()
																.clip(new ClipContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																				entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																		ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getX(),
														entity.level()
																.clip(new ClipContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																				entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																		ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getY(),
														entity.level()
																.clip(new ClipContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																				entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																		ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getZ()),
														(net.minecraft.sounds.SoundEvent) BuiltInRegistries.SOUND_EVENT
																.getValue(Identifier.parse("naruto_shippuden:kamui")),
														SoundSource.NEUTRAL, (float) 1, (float) 1);
											} else {
												((Level) world).playLocalSound(
														(entity.level()
																.clip(new ClipContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																				entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																		ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getX()),
														(entity.level()
																.clip(new ClipContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																				entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																		ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getY()),
														(entity.level()
																.clip(new ClipContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																				entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																		ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getZ()),
														(net.minecraft.sounds.SoundEvent) BuiltInRegistries.SOUND_EVENT
																.getValue(Identifier.parse("naruto_shippuden:kamui")),
														SoundSource.NEUTRAL, (float) 1, (float) 1, false);
											}
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 349) {
										if (entity instanceof Player && !entity.level().isClientSide()) {
											((Player) entity).sendSystemMessage(Component.literal("Not Enough Chakra"));
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 19) {
									if (entity instanceof Player && !entity.level().isClientSide()) {
										((Player) entity).sendSystemMessage(Component.literal("Not Enough Ninjutsu"));
									}
								}
							} else if (!(NarutoShippudenModVariables.get(entity).mangekyousharinganobitokamuilearn >= 2)) {
								if (entity instanceof Player && !entity.level().isClientSide()) {
									((Player) entity).sendSystemMessage(Component.literal("You haven't unlocked this technique."));
								}
							}
						} else if (NarutoShippudenModVariables.get(entity).mangekyousharinganobitokamuitechnique == 2) {
							if (NarutoShippudenModVariables.get(entity).mangekyousharinganobitokamuilearn >= 3) {
								if (NarutoShippudenModVariables.get(entity).ninjutsu >= 30) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 500) {
										{
											boolean _setval = (true);
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.KamuiPhantomPhase = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
										entity.setPermanentlyInvulnerable((true));
										if (entity instanceof Player) {
											((Player) entity).getAbilities().flying = (true);
											((Player) entity).onUpdateAbilities();
										}
										new Object() {
											private int ticks = 0;
											private float waitTicks;
											private LevelAccessor world;

											public void start(LevelAccessor world, int waitTicks) {
												this.waitTicks = waitTicks;
												Registration.listen(NeoForge.EVENT_BUS, this);
												this.world = world;
											}

											@SubscribeEvent
											public void tick(ServerTickEvent.Post event) {
												if (true) {
													this.ticks += 1;
													if (this.ticks >= this.waitTicks)
														run();
												}
											}

											private void run() {
												{
													boolean _setval = (false);
													NarutoShippudenModVariables.ifPresent(entity, capability -> {
																capability.KamuiPhantomPhase = _setval;
																capability.syncPlayerVariables(entity);
															});
												}
												entity.setPermanentlyInvulnerable((false));
												if (entity instanceof Player) {
													((Player) entity).getAbilities().flying = (false);
													((Player) entity).onUpdateAbilities();
												}
												NeoForge.EVENT_BUS.unregister(this);
											}
										}.start(world, (int) 15);
										{
											double _setval = (NarutoShippudenModVariables.get(entity).Mangekyou_Sharingan_Technique_Use + 1);
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.Mangekyou_Sharingan_Technique_Use = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 500);
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 499) {
										if (entity instanceof Player && !entity.level().isClientSide()) {
											((Player) entity).sendSystemMessage(Component.literal("Not Enough Chakra"));
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 29) {
									if (entity instanceof Player && !entity.level().isClientSide()) {
										((Player) entity).sendSystemMessage(Component.literal("Not Enough Ninjutsu"));
									}
								}
							} else if (!(NarutoShippudenModVariables.get(entity).mangekyousharinganobitokamuilearn >= 3)) {
								if (entity instanceof Player && !entity.level().isClientSide()) {
									((Player) entity).sendSystemMessage(Component.literal("You haven't unlocked this technique."));
								}
							}
						}
						if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
							if (entity instanceof Player)
								((Player) entity).getCooldowns().addCooldown(new ItemStack(MangekyouSharinganObitoReleaseTechniqueItem.block), (int) 200);
						} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
							if (entity instanceof Player)
								((Player) entity).getCooldowns().addCooldown(new ItemStack(MangekyouSharinganObitoReleaseTechniqueItem.block), (int) 160);
						} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
							if (entity instanceof Player)
								((Player) entity).getCooldowns().addCooldown(new ItemStack(MangekyouSharinganObitoReleaseTechniqueItem.block), (int) 120);
						} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
							if (entity instanceof Player)
								((Player) entity).getCooldowns().addCooldown(new ItemStack(MangekyouSharinganObitoReleaseTechniqueItem.block), (int) 80);
						} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
							if (entity instanceof Player)
								((Player) entity).getCooldowns().addCooldown(new ItemStack(MangekyouSharinganObitoReleaseTechniqueItem.block), (int) 40);
						}
					} else if (NarutoShippudenModVariables.get(entity).MangekyouSharinganActivate == false) {
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Activate Mangekyou Sharingan"));
						}
					}
				} else if (entity.isShiftKeyDown()) {
					if (NarutoShippudenModVariables.get(entity).mangekyousharinganobitokamuitechnique == 0) {
						{
							double _setval = 1;
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.mangekyousharinganobitokamuitechnique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Selected: Kamui Short-Range"));
						}
					} else if (NarutoShippudenModVariables.get(entity).mangekyousharinganobitokamuitechnique == 1) {
						{
							double _setval = 2;
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.mangekyousharinganobitokamuitechnique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Selected: Kamui Phantom Phasing"));
						}
					} else if (NarutoShippudenModVariables.get(entity).mangekyousharinganobitokamuitechnique == 2) {
						{
							double _setval = 0;
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.mangekyousharinganobitokamuitechnique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Selected: Kamui Self-Teleportation"));
						}
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).MangekyouSharinganObito == false) {
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("You haven't unlocked this release."));
				}
			}
		}
	}

	public static class MangekyouSharinganObitoReleaseRightclickedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure MangekyouSharinganObitoReleaseRightclicked!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (!entity.isShiftKeyDown()) {
				if (NarutoShippudenModVariables.get(entity).MangekyouSharinganRelease == 0) {
					if (NarutoShippudenModVariables.get(entity).mangekyousharinganobitokamuirelease == 0) {
						if (NarutoShippudenModVariables.get(entity).jp >= 20) {
							if (NarutoShippudenModVariables.get(entity).mangekyousharinganobitosusanolearn == 0) {
								if (entity instanceof Player) {
									ItemStack _setstack = new ItemStack(MangekyouSharinganObitoReleaseTechniqueItem.block);
									_setstack.setCount((int) 1);
									Compat.giveItemToPlayer(((Player) entity), _setstack);
								}
							}
							{
								double _setval = 1;
								NarutoShippudenModVariables.ifPresent(entity, capability -> {
									capability.mangekyousharinganobitokamuilearn = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = (NarutoShippudenModVariables.get(entity).jp - 20);
								NarutoShippudenModVariables.ifPresent(entity, capability -> {
									capability.jp = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = (NarutoShippudenModVariables.get(entity).mangekyousharinganobitokamuirelease + 1);
								NarutoShippudenModVariables.ifPresent(entity, capability -> {
									capability.mangekyousharinganobitokamuirelease = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendSystemMessage(Component.literal("-20 JP"));
							}
						} else if (NarutoShippudenModVariables.get(entity).jp <= 19) {
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendSystemMessage(Component.literal("Not Enough JP"));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).mangekyousharinganobitokamuirelease == 1) {
						if (NarutoShippudenModVariables.get(entity).jp >= 30) {
							{
								double _setval = 2;
								NarutoShippudenModVariables.ifPresent(entity, capability -> {
									capability.mangekyousharinganobitokamuilearn = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = (NarutoShippudenModVariables.get(entity).jp - 15);
								NarutoShippudenModVariables.ifPresent(entity, capability -> {
									capability.jp = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = (NarutoShippudenModVariables.get(entity).mangekyousharinganobitokamuirelease + 1);
								NarutoShippudenModVariables.ifPresent(entity, capability -> {
									capability.mangekyousharinganobitokamuirelease = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendSystemMessage(Component.literal("-30 JP"));
							}
						} else if (NarutoShippudenModVariables.get(entity).jp <= 29) {
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendSystemMessage(Component.literal("Not Enough JP"));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).mangekyousharinganobitokamuirelease == 2) {
						if (NarutoShippudenModVariables.get(entity).jp >= 35) {
							{
								double _setval = 3;
								NarutoShippudenModVariables.ifPresent(entity, capability -> {
									capability.mangekyousharinganobitokamuilearn = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = (NarutoShippudenModVariables.get(entity).jp - 35);
								NarutoShippudenModVariables.ifPresent(entity, capability -> {
									capability.jp = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = (NarutoShippudenModVariables.get(entity).mangekyousharinganobitokamuirelease + 1);
								NarutoShippudenModVariables.ifPresent(entity, capability -> {
									capability.mangekyousharinganobitokamuirelease = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendSystemMessage(Component.literal("-35 JP"));
							}
						} else if (NarutoShippudenModVariables.get(entity).jp <= 34) {
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendSystemMessage(Component.literal("Not Enough JP"));
							}
						}
					}
				} else if (NarutoShippudenModVariables.get(entity).MangekyouSharinganRelease == 1) {
					if (NarutoShippudenModVariables.get(entity).mangekyousharinganobitosusanorelease == 0) {
						if (NarutoShippudenModVariables.get(entity).jp >= 10) {
							{
								double _setval = 1;
								NarutoShippudenModVariables.ifPresent(entity, capability -> {
									capability.mangekyousharinganobitosusanolearn = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = (NarutoShippudenModVariables.get(entity).jp - 10);
								NarutoShippudenModVariables.ifPresent(entity, capability -> {
									capability.jp = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = (NarutoShippudenModVariables.get(entity).mangekyousharinganobitosusanorelease + 1);
								NarutoShippudenModVariables.ifPresent(entity, capability -> {
									capability.mangekyousharinganobitosusanorelease = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendSystemMessage(Component.literal("-10 JP"));
							}
						} else if (NarutoShippudenModVariables.get(entity).jp <= 9) {
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendSystemMessage(Component.literal("Not Enough JP"));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).mangekyousharinganobitosusanorelease == 1) {
						if (NarutoShippudenModVariables.get(entity).jp >= 20) {
							{
								double _setval = 2;
								NarutoShippudenModVariables.ifPresent(entity, capability -> {
									capability.mangekyousharinganobitosusanolearn = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = (NarutoShippudenModVariables.get(entity).jp - 20);
								NarutoShippudenModVariables.ifPresent(entity, capability -> {
									capability.jp = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = (NarutoShippudenModVariables.get(entity).mangekyousharinganobitosusanorelease + 1);
								NarutoShippudenModVariables.ifPresent(entity, capability -> {
									capability.mangekyousharinganobitosusanorelease = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendSystemMessage(Component.literal("-20 JP"));
							}
						} else if (NarutoShippudenModVariables.get(entity).jp <= 19) {
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendSystemMessage(Component.literal("Not Enough JP"));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).mangekyousharinganobitosusanorelease == 2) {
						if (NarutoShippudenModVariables.get(entity).jp >= 30) {
							{
								double _setval = 3;
								NarutoShippudenModVariables.ifPresent(entity, capability -> {
									capability.mangekyousharinganobitosusanolearn = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = (NarutoShippudenModVariables.get(entity).jp - 30);
								NarutoShippudenModVariables.ifPresent(entity, capability -> {
									capability.jp = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = (NarutoShippudenModVariables.get(entity).mangekyousharinganobitosusanorelease + 1);
								NarutoShippudenModVariables.ifPresent(entity, capability -> {
									capability.mangekyousharinganobitosusanorelease = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendSystemMessage(Component.literal("-30 JP"));
							}
						} else if (NarutoShippudenModVariables.get(entity).jp <= 29) {
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendSystemMessage(Component.literal("Not Enough JP"));
							}
						}
					}
				}
			} else if (entity.isShiftKeyDown()) {
				if (NarutoShippudenModVariables.get(entity).MangekyouSharinganRelease == 0) {
					{
						double _setval = 1;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.MangekyouSharinganRelease = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Selected: Susano"));
					}
				} else if (NarutoShippudenModVariables.get(entity).MangekyouSharinganRelease == 1) {
					{
						double _setval = 0;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.MangekyouSharinganRelease = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Selected: Kamui"));
					}
				}
			}
		}
	}

	public static class MangekyouSharinganSasukeReleaseRightclickProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("world") == null) {
				if (!dependencies.containsKey("world"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure MangekyouSharinganSasukeReleaseRightclick!");
				return;
			}
			if (dependencies.get("x") == null) {
				if (!dependencies.containsKey("x"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency x for procedure MangekyouSharinganSasukeReleaseRightclick!");
				return;
			}
			if (dependencies.get("y") == null) {
				if (!dependencies.containsKey("y"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency y for procedure MangekyouSharinganSasukeReleaseRightclick!");
				return;
			}
			if (dependencies.get("z") == null) {
				if (!dependencies.containsKey("z"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency z for procedure MangekyouSharinganSasukeReleaseRightclick!");
				return;
			}
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure MangekyouSharinganSasukeReleaseRightclick!");
				return;
			}
			LevelAccessor world = (LevelAccessor) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).MangekyouSharinganSasuke == true) {
				if (!entity.isShiftKeyDown()) {
					if (NarutoShippudenModVariables.get(entity).MangekyouSharinganActivate == true) {
						if (NarutoShippudenModVariables.get(entity).mangekyousharingansasukeamaterasutechnique == 0) {
							if (NarutoShippudenModVariables.get(entity).mangekyousharingansasukeamaterasulearn >= 1) {
								if (NarutoShippudenModVariables.get(entity).ninjutsu >= 20) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 350) {
										{
											Entity _shootFrom = entity;
											Level projectileLevel = _shootFrom.level();
											if (!projectileLevel.isClientSide()) {
												Projectile _entityToSpawn = new Object() {
													public Projectile getArrow(Level world, float damage, int knockback) {
														ModArrow entityToSpawn = new AmaterasuFlameItem.ArrowCustomEntity(
																AmaterasuFlameItem.arrow, world);

														entityToSpawn.setBaseDamage(damage);
														Compat.setKnockback(entityToSpawn, knockback);
														entityToSpawn.setSilent(true);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, 5, 1);
												_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
												_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1,
														0);
												projectileLevel.addFreshEntity(_entityToSpawn);
											}
										}
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 350);
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
										{
											double _setval = (NarutoShippudenModVariables.get(entity).Mangekyou_Sharingan_Technique_Use + 1);
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.Mangekyou_Sharingan_Technique_Use = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 349) {
										if (entity instanceof Player && !entity.level().isClientSide()) {
											((Player) entity).sendSystemMessage(Component.literal("Not Enough Chakra"));
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 19) {
									if (entity instanceof Player && !entity.level().isClientSide()) {
										((Player) entity).sendSystemMessage(Component.literal("Not Enough Ninjutsu"));
									}
								}
							} else if (!(NarutoShippudenModVariables.get(entity).mangekyousharingansasukeamaterasulearn >= 1)) {
								if (entity instanceof Player && !entity.level().isClientSide()) {
									((Player) entity).sendSystemMessage(Component.literal("You haven't unlocked this technique."));
								}
							}
						} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansasukeamaterasutechnique == 1) {
							if (NarutoShippudenModVariables.get(entity).mangekyousharingansasukeamaterasulearn >= 2) {
								if (NarutoShippudenModVariables.get(entity).ninjutsu >= 25) {
									if (NarutoShippudenModVariables.get(entity).Kagutsuchi == false) {
										{
											boolean _setval = (true);
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.Kagutsuchi = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
										{
											double _setval = (NarutoShippudenModVariables.get(entity).Mangekyou_Sharingan_Technique_Use + 1);
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.Mangekyou_Sharingan_Technique_Use = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).Kagutsuchi == true) {
										{
											boolean _setval = (false);
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.Kagutsuchi = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 24) {
									if (entity instanceof Player && !entity.level().isClientSide()) {
										((Player) entity).sendSystemMessage(Component.literal("Not Enough Ninjutsu"));
									}
								}
							} else if (!(NarutoShippudenModVariables.get(entity).mangekyousharingansasukeamaterasulearn >= 2)) {
								if (entity instanceof Player && !entity.level().isClientSide()) {
									((Player) entity).sendSystemMessage(Component.literal("You haven't unlocked this technique."));
								}
							}
						} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansasukeamaterasutechnique == 2) {
							if (NarutoShippudenModVariables.get(entity).mangekyousharingansasukeamaterasulearn >= 3) {
								if (NarutoShippudenModVariables.get(entity).ninjutsu >= 30) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 500) {
										if (world instanceof ServerLevel) {
											((ServerLevel) world).sendParticles(AmaterasuFireParticle.particle, x, (y + 1.5), z, (int) 100, 0, 0, 0, 0.1);
										}
										{
											List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(x - (10 / 2d),
													y - (10 / 2d), z - (10 / 2d), x + (10 / 2d), y + (10 / 2d), z + (10 / 2d)), e -> true).stream()
													.sorted(new Object() {
														Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
															return Comparator
																	.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.distanceToSqr(_x, _y, _z)));
														}
													}.compareDistOf(x, y, z)).collect(Collectors.toList());
											for (Entity entityiterator : _entfound) {
												if (entityiterator instanceof Player) {
													if (NarutoShippudenModVariables.get(entityiterator).mangekyousharingansasukeamaterasulearn == 0) {
														if (NarutoShippudenModVariables.get(entityiterator).MangekyouSharinganSasuke == false
																&& NarutoShippudenModVariables.get(entityiterator).MangekyouSharinganItachi == false) {
															if (!(entity == entityiterator)) {
																entityiterator.getPersistentData().putBoolean("Amaterasu", (true));
																if (entityiterator instanceof LivingEntity)
																	((LivingEntity) entityiterator).addEffect(
																			new MobEffectInstance(MobEffects.WITHER, (int) 999999, (int) 3, (false), (false)));
																entityiterator.hurt(Compat.damage().wither(), (float) 5);
															}
														}
													}
												} else if (!(entityiterator instanceof Player)) {
													if (entityiterator instanceof LivingEntity)
														((LivingEntity) entityiterator).addEffect(
																new MobEffectInstance(MobEffects.WITHER, (int) 999999, (int) 3, (false), (false)));
													entityiterator.hurt(Compat.damage().wither(), (float) 5);
												}
											}
										}
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 500);
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
										{
											double _setval = (NarutoShippudenModVariables.get(entity).Mangekyou_Sharingan_Technique_Use + 1);
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.Mangekyou_Sharingan_Technique_Use = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 499) {
										if (entity instanceof Player && !entity.level().isClientSide()) {
											((Player) entity).sendSystemMessage(Component.literal("Not Enough Chakra"));
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 29) {
									if (entity instanceof Player && !entity.level().isClientSide()) {
										((Player) entity).sendSystemMessage(Component.literal("Not Enough Ninjutsu"));
									}
								}
							} else if (!(NarutoShippudenModVariables.get(entity).mangekyousharingansasukeamaterasulearn >= 3)) {
								if (entity instanceof Player && !entity.level().isClientSide()) {
									((Player) entity).sendSystemMessage(Component.literal("You haven't unlocked this technique."));
								}
							}
						} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansasukeamaterasutechnique == 3) {
							if (NarutoShippudenModVariables.get(entity).mangekyousharingansasukeamaterasulearn >= 4) {
								if (NarutoShippudenModVariables.get(entity).ninjutsu >= 35) {
									if (NarutoShippudenModVariables.get(entity).AmaterasuSusano == false) {
										{
											boolean _setval = (true);
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.AmaterasuSusano = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
										{
											double _setval = (NarutoShippudenModVariables.get(entity).Mangekyou_Sharingan_Technique_Use + 1);
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.Mangekyou_Sharingan_Technique_Use = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).AmaterasuSusano == true) {
										{
											boolean _setval = (false);
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.AmaterasuSusano = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 34) {
									if (entity instanceof Player && !entity.level().isClientSide()) {
										((Player) entity).sendSystemMessage(Component.literal("Not Enough Ninjutsu"));
									}
								}
							} else if (!(NarutoShippudenModVariables.get(entity).mangekyousharingansasukeamaterasulearn >= 4)) {
								if (entity instanceof Player && !entity.level().isClientSide()) {
									((Player) entity).sendSystemMessage(Component.literal("You haven't unlocked this technique."));
								}
							}
						}
						if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
							if (entity instanceof Player)
								((Player) entity).getCooldowns().addCooldown(new ItemStack(MangekyouSharinganSasukeReleaseTechniqueItem.block), (int) 200);
						} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
							if (entity instanceof Player)
								((Player) entity).getCooldowns().addCooldown(new ItemStack(MangekyouSharinganSasukeReleaseTechniqueItem.block), (int) 160);
						} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
							if (entity instanceof Player)
								((Player) entity).getCooldowns().addCooldown(new ItemStack(MangekyouSharinganSasukeReleaseTechniqueItem.block), (int) 120);
						} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
							if (entity instanceof Player)
								((Player) entity).getCooldowns().addCooldown(new ItemStack(MangekyouSharinganSasukeReleaseTechniqueItem.block), (int) 80);
						} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
							if (entity instanceof Player)
								((Player) entity).getCooldowns().addCooldown(new ItemStack(MangekyouSharinganSasukeReleaseTechniqueItem.block), (int) 40);
						}
					} else if (NarutoShippudenModVariables.get(entity).MangekyouSharinganActivate == false) {
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Activate Mangekyou Sharingan"));
						}
					}
				} else if (entity.isShiftKeyDown()) {
					if (NarutoShippudenModVariables.get(entity).mangekyousharingansasukeamaterasutechnique == 0) {
						{
							double _setval = 1;
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.mangekyousharingansasukeamaterasutechnique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Selected: Blaze Release: Kagutsuchi"));
						}
					} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansasukeamaterasutechnique == 1) {
						{
							double _setval = 2;
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.mangekyousharingansasukeamaterasutechnique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Selected: Blaze Release: Honoikazuchi"));
						}
					} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansasukeamaterasutechnique == 2) {
						{
							double _setval = 3;
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.mangekyousharingansasukeamaterasutechnique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Selected: Amaterasu: Flame Wrapping Fire"));
						}
					} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansasukeamaterasutechnique == 3) {
						{
							double _setval = 0;
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.mangekyousharingansasukeamaterasutechnique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Selected: Amaterasu"));
						}
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).MangekyouSharinganSasuke == false) {
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("You haven't unlocked this release."));
				}
			}
		}
	}

	public static class MangekyouSharinganSasukeReleaseRightclickedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure MangekyouSharinganSasukeReleaseRightclicked!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (!entity.isShiftKeyDown()) {
				if (NarutoShippudenModVariables.get(entity).MangekyouSharinganRelease == 0) {
					if (NarutoShippudenModVariables.get(entity).mangekyousharingansasukeamaterasurelease == 0) {
						if (NarutoShippudenModVariables.get(entity).jp >= 10) {
							if (NarutoShippudenModVariables.get(entity).mangekyousharingansasukesusanolearn == 0) {
								if (entity instanceof Player) {
									ItemStack _setstack = new ItemStack(MangekyouSharinganSasukeReleaseTechniqueItem.block);
									_setstack.setCount((int) 1);
									Compat.giveItemToPlayer(((Player) entity), _setstack);
								}
							}
							{
								double _setval = 1;
								NarutoShippudenModVariables.ifPresent(entity, capability -> {
									capability.mangekyousharingansasukeamaterasulearn = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = (NarutoShippudenModVariables.get(entity).jp - 10);
								NarutoShippudenModVariables.ifPresent(entity, capability -> {
									capability.jp = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = (NarutoShippudenModVariables.get(entity).mangekyousharingansasukeamaterasurelease + 1);
								NarutoShippudenModVariables.ifPresent(entity, capability -> {
									capability.mangekyousharingansasukeamaterasurelease = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendSystemMessage(Component.literal("-10 JP"));
							}
						} else if (NarutoShippudenModVariables.get(entity).jp <= 9) {
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendSystemMessage(Component.literal("Not Enough JP"));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansasukeamaterasurelease == 1) {
						if (NarutoShippudenModVariables.get(entity).jp >= 15) {
							{
								double _setval = 2;
								NarutoShippudenModVariables.ifPresent(entity, capability -> {
									capability.mangekyousharingansasukeamaterasulearn = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = (NarutoShippudenModVariables.get(entity).jp - 15);
								NarutoShippudenModVariables.ifPresent(entity, capability -> {
									capability.jp = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = (NarutoShippudenModVariables.get(entity).mangekyousharingansasukeamaterasurelease + 1);
								NarutoShippudenModVariables.ifPresent(entity, capability -> {
									capability.mangekyousharingansasukeamaterasurelease = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendSystemMessage(Component.literal("-15 JP"));
							}
						} else if (NarutoShippudenModVariables.get(entity).jp <= 14) {
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendSystemMessage(Component.literal("Not Enough JP"));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansasukeamaterasurelease == 2) {
						if (NarutoShippudenModVariables.get(entity).jp >= 20) {
							{
								double _setval = 3;
								NarutoShippudenModVariables.ifPresent(entity, capability -> {
									capability.mangekyousharingansasukeamaterasulearn = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = (NarutoShippudenModVariables.get(entity).jp - 20);
								NarutoShippudenModVariables.ifPresent(entity, capability -> {
									capability.jp = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = (NarutoShippudenModVariables.get(entity).mangekyousharingansasukeamaterasurelease + 1);
								NarutoShippudenModVariables.ifPresent(entity, capability -> {
									capability.mangekyousharingansasukeamaterasurelease = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendSystemMessage(Component.literal("-20 JP"));
							}
						} else if (NarutoShippudenModVariables.get(entity).jp <= 19) {
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendSystemMessage(Component.literal("Not Enough JP"));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansasukeamaterasurelease == 3) {
						if (NarutoShippudenModVariables.get(entity).jp >= 25) {
							{
								double _setval = 4;
								NarutoShippudenModVariables.ifPresent(entity, capability -> {
									capability.mangekyousharingansasukeamaterasulearn = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = (NarutoShippudenModVariables.get(entity).jp - 25);
								NarutoShippudenModVariables.ifPresent(entity, capability -> {
									capability.jp = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = (NarutoShippudenModVariables.get(entity).mangekyousharingansasukeamaterasurelease + 1);
								NarutoShippudenModVariables.ifPresent(entity, capability -> {
									capability.mangekyousharingansasukeamaterasurelease = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendSystemMessage(Component.literal("-25 JP"));
							}
						} else if (NarutoShippudenModVariables.get(entity).jp <= 24) {
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendSystemMessage(Component.literal("Not Enough JP"));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansasukeamaterasurelease == 4) {
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendSystemMessage(Component.literal("Wait For Newer Updates"));
						}
					}
				} else if (NarutoShippudenModVariables.get(entity).MangekyouSharinganRelease == 1) {
					if (NarutoShippudenModVariables.get(entity).mangekyousharingansasukesusanorelease == 0) {
						if (NarutoShippudenModVariables.get(entity).jp >= 10) {
							{
								double _setval = 1;
								NarutoShippudenModVariables.ifPresent(entity, capability -> {
									capability.mangekyousharingansasukesusanolearn = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = (NarutoShippudenModVariables.get(entity).jp - 10);
								NarutoShippudenModVariables.ifPresent(entity, capability -> {
									capability.jp = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = (NarutoShippudenModVariables.get(entity).mangekyousharingansasukesusanorelease + 1);
								NarutoShippudenModVariables.ifPresent(entity, capability -> {
									capability.mangekyousharingansasukesusanorelease = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendSystemMessage(Component.literal("-10 JP"));
							}
						} else if (NarutoShippudenModVariables.get(entity).jp <= 9) {
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendSystemMessage(Component.literal("Not Enough JP"));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansasukesusanorelease == 1) {
						if (NarutoShippudenModVariables.get(entity).jp >= 20) {
							{
								double _setval = 2;
								NarutoShippudenModVariables.ifPresent(entity, capability -> {
									capability.mangekyousharingansasukesusanolearn = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = (NarutoShippudenModVariables.get(entity).jp - 20);
								NarutoShippudenModVariables.ifPresent(entity, capability -> {
									capability.jp = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = (NarutoShippudenModVariables.get(entity).mangekyousharingansasukesusanorelease + 1);
								NarutoShippudenModVariables.ifPresent(entity, capability -> {
									capability.mangekyousharingansasukesusanorelease = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendSystemMessage(Component.literal("-20 JP"));
							}
						} else if (NarutoShippudenModVariables.get(entity).jp <= 19) {
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendSystemMessage(Component.literal("Not Enough JP"));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansasukesusanorelease == 2) {
						if (NarutoShippudenModVariables.get(entity).jp >= 30) {
							{
								double _setval = 3;
								NarutoShippudenModVariables.ifPresent(entity, capability -> {
									capability.mangekyousharingansasukesusanolearn = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = (NarutoShippudenModVariables.get(entity).jp - 30);
								NarutoShippudenModVariables.ifPresent(entity, capability -> {
									capability.jp = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = (NarutoShippudenModVariables.get(entity).mangekyousharingansasukesusanorelease + 1);
								NarutoShippudenModVariables.ifPresent(entity, capability -> {
									capability.mangekyousharingansasukesusanorelease = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendSystemMessage(Component.literal("-30 JP"));
							}
						} else if (NarutoShippudenModVariables.get(entity).jp <= 29) {
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendSystemMessage(Component.literal("Not Enough JP"));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansasukesusanorelease == 3) {
						if (NarutoShippudenModVariables.get(entity).jp >= 40) {
							{
								double _setval = 4;
								NarutoShippudenModVariables.ifPresent(entity, capability -> {
									capability.mangekyousharingansasukesusanolearn = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = (NarutoShippudenModVariables.get(entity).jp - 40);
								NarutoShippudenModVariables.ifPresent(entity, capability -> {
									capability.jp = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = (NarutoShippudenModVariables.get(entity).mangekyousharingansasukesusanorelease + 1);
								NarutoShippudenModVariables.ifPresent(entity, capability -> {
									capability.mangekyousharingansasukesusanorelease = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendSystemMessage(Component.literal("-40 JP"));
							}
						} else if (NarutoShippudenModVariables.get(entity).jp <= 39) {
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendSystemMessage(Component.literal("Not Enough JP"));
							}
						}
					}
				}
			} else if (entity.isShiftKeyDown()) {
				if (NarutoShippudenModVariables.get(entity).MangekyouSharinganRelease == 0) {
					{
						double _setval = 1;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.MangekyouSharinganRelease = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Selected: Susano"));
					}
				} else if (NarutoShippudenModVariables.get(entity).MangekyouSharinganRelease == 1) {
					{
						double _setval = 0;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.MangekyouSharinganRelease = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Selected: Amaterasu"));
					}
				}
			}
		}
	}

	public static class MangekyouSharinganShisuiReleaseRightclickedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure MangekyouSharinganShisuiReleaseRightclicked!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (!entity.isShiftKeyDown()) {
				if (NarutoShippudenModVariables.get(entity).mangekyousharinganshisuisusanorelease == 0) {
					if (NarutoShippudenModVariables.get(entity).jp >= 10) {
						{
							double _setval = 1;
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.mangekyousharinganshisuisusanolearn = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = (NarutoShippudenModVariables.get(entity).jp - 10);
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.jp = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = (NarutoShippudenModVariables.get(entity).mangekyousharinganshisuisusanorelease + 1);
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.mangekyousharinganshisuisusanorelease = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendSystemMessage(Component.literal("-10 JP"));
						}
					} else if (NarutoShippudenModVariables.get(entity).jp <= 9) {
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendSystemMessage(Component.literal("Not Enough JP"));
						}
					}
				} else if (NarutoShippudenModVariables.get(entity).mangekyousharinganshisuisusanorelease == 1) {
					if (NarutoShippudenModVariables.get(entity).jp >= 20) {
						{
							double _setval = 2;
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.mangekyousharinganshisuisusanolearn = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = (NarutoShippudenModVariables.get(entity).jp - 20);
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.jp = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = (NarutoShippudenModVariables.get(entity).mangekyousharinganshisuisusanorelease + 1);
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.mangekyousharinganshisuisusanorelease = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendSystemMessage(Component.literal("-20 JP"));
						}
					} else if (NarutoShippudenModVariables.get(entity).jp <= 19) {
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendSystemMessage(Component.literal("Not Enough JP"));
						}
					}
				} else if (NarutoShippudenModVariables.get(entity).mangekyousharinganshisuisusanorelease == 2) {
					if (NarutoShippudenModVariables.get(entity).jp >= 30) {
						{
							double _setval = 3;
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.mangekyousharinganshisuisusanolearn = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = (NarutoShippudenModVariables.get(entity).jp - 30);
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.jp = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = (NarutoShippudenModVariables.get(entity).mangekyousharinganshisuisusanorelease + 1);
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.mangekyousharinganshisuisusanorelease = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendSystemMessage(Component.literal("-30 JP"));
						}
					} else if (NarutoShippudenModVariables.get(entity).jp <= 29) {
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendSystemMessage(Component.literal("Not Enough JP"));
						}
					}
				} else if (NarutoShippudenModVariables.get(entity).mangekyousharinganshisuisusanorelease == 3) {
					if (NarutoShippudenModVariables.get(entity).jp >= 40) {
						{
							double _setval = 4;
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.mangekyousharinganshisuisusanolearn = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = (NarutoShippudenModVariables.get(entity).jp - 40);
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.jp = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = (NarutoShippudenModVariables.get(entity).mangekyousharinganshisuisusanorelease + 1);
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.mangekyousharinganshisuisusanorelease = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendSystemMessage(Component.literal("-40 JP"));
						}
					} else if (NarutoShippudenModVariables.get(entity).jp <= 39) {
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendSystemMessage(Component.literal("Not Enough JP"));
						}
					}
				}
			} else if (entity.isShiftKeyDown()) {
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("Selected: Susano"));
				}
			}
		}
	}

	public static class RinneganAwakeProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure RinneganAwake!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).uchihareleaselogic == true) {
				if (NarutoShippudenModVariables.get(entity).firereleaselogic == true
						&& NarutoShippudenModVariables.get(entity).earthreleaselogic == true
						&& NarutoShippudenModVariables.get(entity).lightningreleaselogic == true
						&& NarutoShippudenModVariables.get(entity).windreleaselogic == true
						&& NarutoShippudenModVariables.get(entity).waterreleaselogic == true
						&& NarutoShippudenModVariables.get(entity).woodreleaselogic == true) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(Component.literal("You've awakened Rinnegan!"));
					}
					{
						String _setval = "1x1";
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.dojutsurinnegan = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player) {
						ItemStack _setstack = new ItemStack(RinneganReleaseItem.block);
						_setstack.setCount((int) 1);
						Compat.giveItemToPlayer(((Player) entity), _setstack);
					}
					{
						boolean _setval = (true);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.rinnegan = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).otsutsukireleaselogic == true) {
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendSystemMessage(Component.literal("You've awakened Rinnegan!"));
				}
				{
					String _setval = "1x1";
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.dojutsurinnegan = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(RinneganReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.rinnegan = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
	}

	public static class SharinganAwake10SecondsProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("world") == null) {
				if (!dependencies.containsKey("world"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure SharinganAwake10Seconds!");
				return;
			}
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure SharinganAwake10Seconds!");
				return;
			}
			LevelAccessor world = (LevelAccessor) dependencies.get("world");
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).sharingan == false) {
				new Object() {
					private int ticks = 0;
					private float waitTicks;
					private LevelAccessor world;

					public void start(LevelAccessor world, int waitTicks) {
						this.waitTicks = waitTicks;
						Registration.listen(NeoForge.EVENT_BUS, this);
						this.world = world;
					}

					@SubscribeEvent
					public void tick(ServerTickEvent.Post event) {
						if (true) {
							this.ticks += 1;
							if (this.ticks >= this.waitTicks)
								run();
						}
					}

					private void run() {
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendSystemMessage(
									Component.literal("You suddenly feel a surge of power through you as you awaken the Sharingan!"));
						}
						{
							boolean _setval = (true);
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.sharingan = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof LivingEntity)
							((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.NAUSEA, (int) 200, (int) 4, (false), (false)));
						if (entity instanceof LivingEntity)
							((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.BLINDNESS, (int) 60, (int) 1, (false), (false)));
						{
							String _setval = "1x1";
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.dojutsusharingan = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof Player) {
							ItemStack _setstack = new ItemStack(SharinganReleaseItem.block);
							_setstack.setCount((int) 1);
							Compat.giveItemToPlayer(((Player) entity), _setstack);
						}
						NeoForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 200);
			} else if (NarutoShippudenModVariables.get(entity).sharingan == true) {
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendSystemMessage(Component.literal("You've already unlocked sharingan."));
				}
			}
		}
	}

	public static class SharinganAwakeProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure SharinganAwake!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (entity instanceof Player && !entity.level().isClientSide()) {
				((Player) entity).sendSystemMessage(
						Component.literal("You suddenly feel a surge of power through you as you awaken the Sharingan!"));
			}
			{
				boolean _setval = (true);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.sharingan = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.NAUSEA, (int) 200, (int) 4, (false), (false)));
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.BLINDNESS, (int) 60, (int) 1, (false), (false)));
			{
				String _setval = "1x1";
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.dojutsusharingan = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof Player) {
				ItemStack _setstack = new ItemStack(SharinganReleaseItem.block);
				_setstack.setCount((int) 1);
				Compat.giveItemToPlayer(((Player) entity), _setstack);
			}
		}
	}

	public static class SharinganReleaseRightclickedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure SharinganReleaseRightclicked!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).sharinganrelease == 0) {
				if (NarutoShippudenModVariables.get(entity).jp >= 15) {
					if (entity instanceof Player) {
						ItemStack _setstack = new ItemStack(SharinganReleaseTechniqueItem.block);
						_setstack.setCount((int) 1);
						Compat.giveItemToPlayer(((Player) entity), _setstack);
					}
					{
						double _setval = 1;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.sharinganlearn = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 15);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).sharinganrelease + 1);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.sharinganrelease = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(Component.literal("-15 JP"));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 14) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(Component.literal("Not Enough JP"));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).sharinganrelease == 1) {
				if (NarutoShippudenModVariables.get(entity).jp >= 20) {
					{
						double _setval = 2;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.sharinganlearn = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 20);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).sharinganrelease + 1);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.sharinganrelease = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(Component.literal("-20 JP"));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 19) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(Component.literal("Not Enough JP"));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).sharinganrelease == 2) {
				if (NarutoShippudenModVariables.get(entity).jp >= 25) {
					{
						double _setval = 3;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.sharinganlearn = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 25);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).sharinganrelease + 1);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.sharinganrelease = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(Component.literal("-25 JP"));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 24) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(Component.literal("Not Enough JP"));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).sharinganrelease == 3) {
				if (NarutoShippudenModVariables.get(entity).jp >= 30) {
					{
						boolean _setval = (true);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.izanagi = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = 4;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.sharinganlearn = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 30);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).sharinganrelease + 1);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.sharinganrelease = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(Component.literal("-30 JP"));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 29) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(Component.literal("Not Enough JP"));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).sharinganrelease == 4) {
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendSystemMessage(Component.literal("Wait For Newer Updates"));
				}
			}
		}
	}

	public static class SharinganReleaseTechniqueRightclickedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("world") == null) {
				if (!dependencies.containsKey("world"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure SharinganReleaseTechniqueRightclicked!");
				return;
			}
			if (dependencies.get("x") == null) {
				if (!dependencies.containsKey("x"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency x for procedure SharinganReleaseTechniqueRightclicked!");
				return;
			}
			if (dependencies.get("y") == null) {
				if (!dependencies.containsKey("y"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency y for procedure SharinganReleaseTechniqueRightclicked!");
				return;
			}
			if (dependencies.get("z") == null) {
				if (!dependencies.containsKey("z"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency z for procedure SharinganReleaseTechniqueRightclicked!");
				return;
			}
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure SharinganReleaseTechniqueRightclicked!");
				return;
			}
			LevelAccessor world = (LevelAccessor) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).sharingan == true) {
				if (!entity.isShiftKeyDown()) {
					if (NarutoShippudenModVariables.get(entity).sharinganactivate == true) {
						if (NarutoShippudenModVariables.get(entity).sharingantechnique == 0) {
							if (NarutoShippudenModVariables.get(entity).sharinganlearn >= 1) {
								if (NarutoShippudenModVariables.get(entity).ninjutsu >= 10) {
									if (NarutoShippudenModVariables.get(entity).genjutsu >= 5) {
										if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 200) {
											{
												Entity _shootFrom = entity;
												Level projectileLevel = _shootFrom.level();
												if (!projectileLevel.isClientSide()) {
													Projectile _entityToSpawn = new Object() {
														public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
															ModArrow entityToSpawn = new CoercionSharinganItem.ArrowCustomEntity(
																	CoercionSharinganItem.arrow, world);
															entityToSpawn.setOwner(shooter);
															entityToSpawn.setBaseDamage(damage);
															Compat.setKnockback(entityToSpawn, knockback);
															entityToSpawn.setSilent(true);

															return entityToSpawn;
														}
													}.getArrow(projectileLevel, entity, 12, 0);
													_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
													_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z,
															1, 0);
													projectileLevel.addFreshEntity(_entityToSpawn);
												}
											}
											{
												double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 200);
												NarutoShippudenModVariables.ifPresent(entity, capability -> {
															capability.ChakraAmount = _setval;
															capability.syncPlayerVariables(entity);
														});
											}
										} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 199) {
											if (entity instanceof Player && !entity.level().isClientSide()) {
												((Player) entity).sendSystemMessage(Component.literal("Not Enough Genjutsu"));
											}
										}
									} else if (NarutoShippudenModVariables.get(entity).genjutsu <= 4) {
										if (entity instanceof Player && !entity.level().isClientSide()) {
											((Player) entity).sendSystemMessage(Component.literal("Not Enough Ninjutsu"));
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 9) {
									if (entity instanceof Player && !entity.level().isClientSide()) {
										((Player) entity).sendSystemMessage(Component.literal("Not Enough Ninjutsu"));
									}
								}
							} else if (!(NarutoShippudenModVariables.get(entity).sharinganlearn >= 1)) {
								if (entity instanceof Player && !entity.level().isClientSide()) {
									((Player) entity).sendSystemMessage(Component.literal("You haven't unlocked this technique."));
								}
							}
						} else if (NarutoShippudenModVariables.get(entity).sharingantechnique == 1) {
							if (NarutoShippudenModVariables.get(entity).sharinganlearn >= 2) {
								if (NarutoShippudenModVariables.get(entity).ninjutsu >= 20) {
									if (NarutoShippudenModVariables.get(entity).genjutsu >= 10) {
										if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 350) {
											if (world instanceof ServerLevel) {
												Entity entityToSpawn = new CrowEntity.CustomEntity(CrowEntity.entity, (Level) world);
												entityToSpawn.snapTo((x - 4), (y + 2), z,
														(float) (Mth.nextInt(RandomSource.create(), -179, 180)), (float) 0);
												entityToSpawn.setYBodyRot((float) (Mth.nextInt(RandomSource.create(), -179, 180)));
												entityToSpawn.setYHeadRot((float) (Mth.nextInt(RandomSource.create(), -179, 180)));
												entityToSpawn.setDeltaMovement(0, 0, 0);
												if (entityToSpawn instanceof Mob)
													((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
															((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
												world.addFreshEntity(entityToSpawn);
											}
											if (world instanceof ServerLevel) {
												Entity entityToSpawn = new CrowEntity.CustomEntity(CrowEntity.entity, (Level) world);
												entityToSpawn.snapTo((x + 4), (y + 2), z,
														(float) (Mth.nextInt(RandomSource.create(), -179, 180)), (float) 0);
												entityToSpawn.setYBodyRot((float) (Mth.nextInt(RandomSource.create(), -179, 180)));
												entityToSpawn.setYHeadRot((float) (Mth.nextInt(RandomSource.create(), -179, 180)));
												entityToSpawn.setDeltaMovement(0, 0, 0);
												if (entityToSpawn instanceof Mob)
													((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
															((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
												world.addFreshEntity(entityToSpawn);
											}
											if (world instanceof ServerLevel) {
												Entity entityToSpawn = new CrowEntity.CustomEntity(CrowEntity.entity, (Level) world);
												entityToSpawn.snapTo(x, (y + 2), (z + 4),
														(float) (Mth.nextInt(RandomSource.create(), -179, 180)), (float) 0);
												entityToSpawn.setYBodyRot((float) (Mth.nextInt(RandomSource.create(), -179, 180)));
												entityToSpawn.setYHeadRot((float) (Mth.nextInt(RandomSource.create(), -179, 180)));
												entityToSpawn.setDeltaMovement(0, 0, 0);
												if (entityToSpawn instanceof Mob)
													((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
															((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
												world.addFreshEntity(entityToSpawn);
											}
											if (world instanceof ServerLevel) {
												Entity entityToSpawn = new CrowEntity.CustomEntity(CrowEntity.entity, (Level) world);
												entityToSpawn.snapTo(x, (y + 2), (z - 4),
														(float) (Mth.nextInt(RandomSource.create(), -179, 180)), (float) 0);
												entityToSpawn.setYBodyRot((float) (Mth.nextInt(RandomSource.create(), -179, 180)));
												entityToSpawn.setYHeadRot((float) (Mth.nextInt(RandomSource.create(), -179, 180)));
												entityToSpawn.setDeltaMovement(0, 0, 0);
												if (entityToSpawn instanceof Mob)
													((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
															((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
												world.addFreshEntity(entityToSpawn);
											}
											if (world instanceof ServerLevel) {
												Entity entityToSpawn = new CrowEntity.CustomEntity(CrowEntity.entity, (Level) world);
												entityToSpawn.snapTo(x, (y + 2), (z - 3),
														(float) (Mth.nextInt(RandomSource.create(), -179, 180)), (float) 0);
												entityToSpawn.setYBodyRot((float) (Mth.nextInt(RandomSource.create(), -179, 180)));
												entityToSpawn.setYHeadRot((float) (Mth.nextInt(RandomSource.create(), -179, 180)));
												entityToSpawn.setDeltaMovement(0, 0, 0);
												if (entityToSpawn instanceof Mob)
													((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
															((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
												world.addFreshEntity(entityToSpawn);
											}
											if (world instanceof ServerLevel) {
												Entity entityToSpawn = new CrowEntity.CustomEntity(CrowEntity.entity, (Level) world);
												entityToSpawn.snapTo(x, (y + 2), (z + 3),
														(float) (Mth.nextInt(RandomSource.create(), -179, 180)), (float) 0);
												entityToSpawn.setYBodyRot((float) (Mth.nextInt(RandomSource.create(), -179, 180)));
												entityToSpawn.setYHeadRot((float) (Mth.nextInt(RandomSource.create(), -179, 180)));
												entityToSpawn.setDeltaMovement(0, 0, 0);
												if (entityToSpawn instanceof Mob)
													((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
															((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
												world.addFreshEntity(entityToSpawn);
											}
											if (world instanceof ServerLevel) {
												Entity entityToSpawn = new CrowEntity.CustomEntity(CrowEntity.entity, (Level) world);
												entityToSpawn.snapTo((x + 3), (y + 2), z,
														(float) (Mth.nextInt(RandomSource.create(), -179, 180)), (float) 0);
												entityToSpawn.setYBodyRot((float) (Mth.nextInt(RandomSource.create(), -179, 180)));
												entityToSpawn.setYHeadRot((float) (Mth.nextInt(RandomSource.create(), -179, 180)));
												entityToSpawn.setDeltaMovement(0, 0, 0);
												if (entityToSpawn instanceof Mob)
													((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
															((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
												world.addFreshEntity(entityToSpawn);
											}
											if (world instanceof ServerLevel) {
												Entity entityToSpawn = new CrowEntity.CustomEntity(CrowEntity.entity, (Level) world);
												entityToSpawn.snapTo((x - 3), (y + 2), z,
														(float) (Mth.nextInt(RandomSource.create(), -179, 180)), (float) 0);
												entityToSpawn.setYBodyRot((float) (Mth.nextInt(RandomSource.create(), -179, 180)));
												entityToSpawn.setYHeadRot((float) (Mth.nextInt(RandomSource.create(), -179, 180)));
												entityToSpawn.setDeltaMovement(0, 0, 0);
												if (entityToSpawn instanceof Mob)
													((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
															((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
												world.addFreshEntity(entityToSpawn);
											}
											if (world instanceof ServerLevel) {
												Entity entityToSpawn = new CrowEntity.CustomEntity(CrowEntity.entity, (Level) world);
												entityToSpawn.snapTo((x - 2), (y + 2), z,
														(float) (Mth.nextInt(RandomSource.create(), -179, 180)), (float) 0);
												entityToSpawn.setYBodyRot((float) (Mth.nextInt(RandomSource.create(), -179, 180)));
												entityToSpawn.setYHeadRot((float) (Mth.nextInt(RandomSource.create(), -179, 180)));
												entityToSpawn.setDeltaMovement(0, 0, 0);
												if (entityToSpawn instanceof Mob)
													((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
															((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
												world.addFreshEntity(entityToSpawn);
											}
											if (world instanceof ServerLevel) {
												Entity entityToSpawn = new CrowEntity.CustomEntity(CrowEntity.entity, (Level) world);
												entityToSpawn.snapTo((x + 2), (y + 2), z,
														(float) (Mth.nextInt(RandomSource.create(), -179, 180)), (float) 0);
												entityToSpawn.setYBodyRot((float) (Mth.nextInt(RandomSource.create(), -179, 180)));
												entityToSpawn.setYHeadRot((float) (Mth.nextInt(RandomSource.create(), -179, 180)));
												entityToSpawn.setDeltaMovement(0, 0, 0);
												if (entityToSpawn instanceof Mob)
													((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
															((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
												world.addFreshEntity(entityToSpawn);
											}
											if (world instanceof ServerLevel) {
												Entity entityToSpawn = new CrowEntity.CustomEntity(CrowEntity.entity, (Level) world);
												entityToSpawn.snapTo(x, (y + 2), (z + 2),
														(float) (Mth.nextInt(RandomSource.create(), -179, 180)), (float) 0);
												entityToSpawn.setYBodyRot((float) (Mth.nextInt(RandomSource.create(), -179, 180)));
												entityToSpawn.setYHeadRot((float) (Mth.nextInt(RandomSource.create(), -179, 180)));
												entityToSpawn.setDeltaMovement(0, 0, 0);
												if (entityToSpawn instanceof Mob)
													((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
															((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
												world.addFreshEntity(entityToSpawn);
											}
											if (world instanceof ServerLevel) {
												Entity entityToSpawn = new CrowEntity.CustomEntity(CrowEntity.entity, (Level) world);
												entityToSpawn.snapTo(x, (y + 2), (z - 2),
														(float) (Mth.nextInt(RandomSource.create(), -179, 180)), (float) 0);
												entityToSpawn.setYBodyRot((float) (Mth.nextInt(RandomSource.create(), -179, 180)));
												entityToSpawn.setYHeadRot((float) (Mth.nextInt(RandomSource.create(), -179, 180)));
												entityToSpawn.setDeltaMovement(0, 0, 0);
												if (entityToSpawn instanceof Mob)
													((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
															((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
												world.addFreshEntity(entityToSpawn);
											}
											if (world instanceof ServerLevel) {
												Entity entityToSpawn = new CrowEntity.CustomEntity(CrowEntity.entity, (Level) world);
												entityToSpawn.snapTo((x - 2), (y + 2), (z + 2),
														(float) (Mth.nextInt(RandomSource.create(), -179, 180)), (float) 0);
												entityToSpawn.setYBodyRot((float) (Mth.nextInt(RandomSource.create(), -179, 180)));
												entityToSpawn.setYHeadRot((float) (Mth.nextInt(RandomSource.create(), -179, 180)));
												entityToSpawn.setDeltaMovement(0, 0, 0);
												if (entityToSpawn instanceof Mob)
													((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
															((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
												world.addFreshEntity(entityToSpawn);
											}
											if (world instanceof ServerLevel) {
												Entity entityToSpawn = new CrowEntity.CustomEntity(CrowEntity.entity, (Level) world);
												entityToSpawn.snapTo((x + 2), (y + 2), (z - 2),
														(float) (Mth.nextInt(RandomSource.create(), -179, 180)), (float) 0);
												entityToSpawn.setYBodyRot((float) (Mth.nextInt(RandomSource.create(), -179, 180)));
												entityToSpawn.setYHeadRot((float) (Mth.nextInt(RandomSource.create(), -179, 180)));
												entityToSpawn.setDeltaMovement(0, 0, 0);
												if (entityToSpawn instanceof Mob)
													((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
															((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
												world.addFreshEntity(entityToSpawn);
											}
											if (world instanceof ServerLevel) {
												Entity entityToSpawn = new CrowEntity.CustomEntity(CrowEntity.entity, (Level) world);
												entityToSpawn.snapTo((x + 3), (y + 2), (z - 3),
														(float) (Mth.nextInt(RandomSource.create(), -179, 180)), (float) 0);
												entityToSpawn.setYBodyRot((float) (Mth.nextInt(RandomSource.create(), -179, 180)));
												entityToSpawn.setYHeadRot((float) (Mth.nextInt(RandomSource.create(), -179, 180)));
												entityToSpawn.setDeltaMovement(0, 0, 0);
												if (entityToSpawn instanceof Mob)
													((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
															((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
												world.addFreshEntity(entityToSpawn);
											}
											if (world instanceof ServerLevel) {
												Entity entityToSpawn = new CrowEntity.CustomEntity(CrowEntity.entity, (Level) world);
												entityToSpawn.snapTo((x - 3), (y + 2), (z + 3),
														(float) (Mth.nextInt(RandomSource.create(), -179, 180)), (float) 0);
												entityToSpawn.setYBodyRot((float) (Mth.nextInt(RandomSource.create(), -179, 180)));
												entityToSpawn.setYHeadRot((float) (Mth.nextInt(RandomSource.create(), -179, 180)));
												entityToSpawn.setDeltaMovement(0, 0, 0);
												if (entityToSpawn instanceof Mob)
													((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
															((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
												world.addFreshEntity(entityToSpawn);
											}
											if (world instanceof ServerLevel) {
												Entity entityToSpawn = new CrowEntity.CustomEntity(CrowEntity.entity, (Level) world);
												entityToSpawn.snapTo((x - 4), (y + 2), (z + 4),
														(float) (Mth.nextInt(RandomSource.create(), -179, 180)), (float) 0);
												entityToSpawn.setYBodyRot((float) (Mth.nextInt(RandomSource.create(), -179, 180)));
												entityToSpawn.setYHeadRot((float) (Mth.nextInt(RandomSource.create(), -179, 180)));
												entityToSpawn.setDeltaMovement(0, 0, 0);
												if (entityToSpawn instanceof Mob)
													((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
															((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
												world.addFreshEntity(entityToSpawn);
											}
											if (world instanceof ServerLevel) {
												Entity entityToSpawn = new CrowEntity.CustomEntity(CrowEntity.entity, (Level) world);
												entityToSpawn.snapTo((x + 4), (y + 2), (z - 4),
														(float) (Mth.nextInt(RandomSource.create(), -179, 180)), (float) 0);
												entityToSpawn.setYBodyRot((float) (Mth.nextInt(RandomSource.create(), -179, 180)));
												entityToSpawn.setYHeadRot((float) (Mth.nextInt(RandomSource.create(), -179, 180)));
												entityToSpawn.setDeltaMovement(0, 0, 0);
												if (entityToSpawn instanceof Mob)
													((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
															((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
												world.addFreshEntity(entityToSpawn);
											}
											if (world instanceof ServerLevel) {
												Entity entityToSpawn = new CrowEntity.CustomEntity(CrowEntity.entity, (Level) world);
												entityToSpawn.snapTo((x + 4), (y + 2), (z + 4),
														(float) (Mth.nextInt(RandomSource.create(), -179, 180)), (float) 0);
												entityToSpawn.setYBodyRot((float) (Mth.nextInt(RandomSource.create(), -179, 180)));
												entityToSpawn.setYHeadRot((float) (Mth.nextInt(RandomSource.create(), -179, 180)));
												entityToSpawn.setDeltaMovement(0, 0, 0);
												if (entityToSpawn instanceof Mob)
													((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
															((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
												world.addFreshEntity(entityToSpawn);
											}
											if (world instanceof ServerLevel) {
												Entity entityToSpawn = new CrowEntity.CustomEntity(CrowEntity.entity, (Level) world);
												entityToSpawn.snapTo((x - 3), (y + 2), (z - 3),
														(float) (Mth.nextInt(RandomSource.create(), -179, 180)), (float) 0);
												entityToSpawn.setYBodyRot((float) (Mth.nextInt(RandomSource.create(), -179, 180)));
												entityToSpawn.setYHeadRot((float) (Mth.nextInt(RandomSource.create(), -179, 180)));
												entityToSpawn.setDeltaMovement(0, 0, 0);
												if (entityToSpawn instanceof Mob)
													((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
															((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
												world.addFreshEntity(entityToSpawn);
											}
											if (world instanceof ServerLevel) {
												Entity entityToSpawn = new CrowEntity.CustomEntity(CrowEntity.entity, (Level) world);
												entityToSpawn.snapTo((x - 4), (y + 2), (z - 4),
														(float) (Mth.nextInt(RandomSource.create(), -179, 180)), (float) 0);
												entityToSpawn.setYBodyRot((float) (Mth.nextInt(RandomSource.create(), -179, 180)));
												entityToSpawn.setYHeadRot((float) (Mth.nextInt(RandomSource.create(), -179, 180)));
												entityToSpawn.setDeltaMovement(0, 0, 0);
												if (entityToSpawn instanceof Mob)
													((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
															((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
												world.addFreshEntity(entityToSpawn);
											}
											if (world instanceof ServerLevel) {
												Entity entityToSpawn = new CrowEntity.CustomEntity(CrowEntity.entity, (Level) world);
												entityToSpawn.snapTo((x + 3), (y + 2), (z + 3),
														(float) (Mth.nextInt(RandomSource.create(), -179, 180)), (float) 0);
												entityToSpawn.setYBodyRot((float) (Mth.nextInt(RandomSource.create(), -179, 180)));
												entityToSpawn.setYHeadRot((float) (Mth.nextInt(RandomSource.create(), -179, 180)));
												entityToSpawn.setDeltaMovement(0, 0, 0);
												if (entityToSpawn instanceof Mob)
													((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
															((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
												world.addFreshEntity(entityToSpawn);
											}
											if (world instanceof ServerLevel) {
												Entity entityToSpawn = new CrowEntity.CustomEntity(CrowEntity.entity, (Level) world);
												entityToSpawn.snapTo((x + 2), (y + 2), (z + 2),
														(float) (Mth.nextInt(RandomSource.create(), -179, 180)), (float) 0);
												entityToSpawn.setYBodyRot((float) (Mth.nextInt(RandomSource.create(), -179, 180)));
												entityToSpawn.setYHeadRot((float) (Mth.nextInt(RandomSource.create(), -179, 180)));
												entityToSpawn.setDeltaMovement(0, 0, 0);
												if (entityToSpawn instanceof Mob)
													((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
															((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
												world.addFreshEntity(entityToSpawn);
											}
											if (world instanceof ServerLevel) {
												Entity entityToSpawn = new CrowEntity.CustomEntity(CrowEntity.entity, (Level) world);
												entityToSpawn.snapTo((x - 2), (y + 2), (z - 2),
														(float) (Mth.nextInt(RandomSource.create(), -179, 180)), (float) 0);
												entityToSpawn.setYBodyRot((float) (Mth.nextInt(RandomSource.create(), -179, 180)));
												entityToSpawn.setYHeadRot((float) (Mth.nextInt(RandomSource.create(), -179, 180)));
												entityToSpawn.setDeltaMovement(0, 0, 0);
												if (entityToSpawn instanceof Mob)
													((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
															((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
												world.addFreshEntity(entityToSpawn);
											}
											{
												List<Entity> _entfound = world
														.getEntitiesOfClass(Entity.class, new AABB(x - (10 / 2d), y - (10 / 2d),
																z - (10 / 2d), x + (10 / 2d), y + (10 / 2d), z + (10 / 2d)), e -> true)
														.stream().sorted(new Object() {
															Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																return Comparator.comparing(
																		(Function<Entity, Double>) (_entcnd -> _entcnd.distanceToSqr(_x, _y, _z)));
															}
														}.compareDistOf(x, y, z)).collect(Collectors.toList());
												for (Entity entityiterator : _entfound) {
													if (!(entity == entityiterator)) {
														if (entityiterator instanceof LivingEntity)
															((LivingEntity) entityiterator).addEffect(
																	new MobEffectInstance(MobEffects.BLINDNESS, (int) 200, (int) 1, (false), (false)));
													}
												}
											}
											if (entity instanceof LivingEntity)
												((LivingEntity) entity)
														.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, (int) 200, (int) 1, (false), (false)));
											{
												double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 350);
												NarutoShippudenModVariables.ifPresent(entity, capability -> {
															capability.ChakraAmount = _setval;
															capability.syncPlayerVariables(entity);
														});
											}
										} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 349) {
											if (entity instanceof Player && !entity.level().isClientSide()) {
												((Player) entity).sendSystemMessage(Component.literal("Not Enough Chakra"));
											}
										}
									} else if (NarutoShippudenModVariables.get(entity).genjutsu <= 9) {
										if (entity instanceof Player && !entity.level().isClientSide()) {
											((Player) entity).sendSystemMessage(Component.literal("Not Enough Genjutsu"));
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 19) {
									if (entity instanceof Player && !entity.level().isClientSide()) {
										((Player) entity).sendSystemMessage(Component.literal("Not Enough Ninjutsu"));
									}
								}
							} else if (!(NarutoShippudenModVariables.get(entity).sharinganlearn >= 2)) {
								if (entity instanceof Player && !entity.level().isClientSide()) {
									((Player) entity).sendSystemMessage(Component.literal("You haven't unlocked this technique."));
								}
							}
						} else if (NarutoShippudenModVariables.get(entity).sharingantechnique == 2) {
							if (NarutoShippudenModVariables.get(entity).sharinganlearn >= 3) {
								if (NarutoShippudenModVariables.get(entity).ninjutsu >= 30) {
									if (NarutoShippudenModVariables.get(entity).genjutsu >= 15) {
										if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 500) {
											{
												Entity _shootFrom = entity;
												Level projectileLevel = _shootFrom.level();
												if (!projectileLevel.isClientSide()) {
													Projectile _entityToSpawn = new Object() {
														public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
															ModArrow entityToSpawn = new DemonicIllusionShacklingStakesTechniqueItem.ArrowCustomEntity(
																	DemonicIllusionShacklingStakesTechniqueItem.arrow, world);
															entityToSpawn.setOwner(shooter);
															entityToSpawn.setBaseDamage(damage);
															Compat.setKnockback(entityToSpawn, knockback);
															entityToSpawn.setSilent(true);

															return entityToSpawn;
														}
													}.getArrow(projectileLevel, entity, 1, 0);
													_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
													_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z,
															4, 0);
													projectileLevel.addFreshEntity(_entityToSpawn);
												}
											}
											{
												double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 500);
												NarutoShippudenModVariables.ifPresent(entity, capability -> {
															capability.ChakraAmount = _setval;
															capability.syncPlayerVariables(entity);
														});
											}
										} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 499) {
											if (entity instanceof Player && !entity.level().isClientSide()) {
												((Player) entity).sendSystemMessage(Component.literal("Not Enough Chakra"));
											}
										}
									} else if (NarutoShippudenModVariables.get(entity).genjutsu <= 14) {
										if (entity instanceof Player && !entity.level().isClientSide()) {
											((Player) entity).sendSystemMessage(Component.literal("Not Enough Genjutsu"));
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 29) {
									if (entity instanceof Player && !entity.level().isClientSide()) {
										((Player) entity).sendSystemMessage(Component.literal("Not Enough Ninjutsu"));
									}
								}
							} else if (!(NarutoShippudenModVariables.get(entity).sharinganlearn >= 3)) {
								if (entity instanceof Player && !entity.level().isClientSide()) {
									((Player) entity).sendSystemMessage(Component.literal("You haven't unlocked this technique."));
								}
							}
						}
						if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
							if (entity instanceof Player)
								((Player) entity).getCooldowns().addCooldown(new ItemStack(SharinganReleaseTechniqueItem.block), (int) 200);
						} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
							if (entity instanceof Player)
								((Player) entity).getCooldowns().addCooldown(new ItemStack(SharinganReleaseTechniqueItem.block), (int) 160);
						} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
							if (entity instanceof Player)
								((Player) entity).getCooldowns().addCooldown(new ItemStack(SharinganReleaseTechniqueItem.block), (int) 120);
						} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
							if (entity instanceof Player)
								((Player) entity).getCooldowns().addCooldown(new ItemStack(SharinganReleaseTechniqueItem.block), (int) 80);
						} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
							if (entity instanceof Player)
								((Player) entity).getCooldowns().addCooldown(new ItemStack(SharinganReleaseTechniqueItem.block), (int) 40);
						}
					} else if (NarutoShippudenModVariables.get(entity).sharinganactivate == false) {
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendSystemMessage(Component.literal("Activate your Sharingan"));
						}
					}
				} else if (entity.isShiftKeyDown()) {
					if (NarutoShippudenModVariables.get(entity).sharingantechnique == 0) {
						{
							double _setval = 1;
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.sharingantechnique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Selected: Demonic Illusion: Mirage Crow"));
						}
					} else if (NarutoShippudenModVariables.get(entity).sharingantechnique == 1) {
						{
							double _setval = 2;
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.sharingantechnique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Selected: Demonic Illusion: Shackling Stakes Technique"));
						}
					} else if (NarutoShippudenModVariables.get(entity).sharingantechnique == 2) {
						{
							double _setval = 0;
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.sharingantechnique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Selected: Coercion Sharingan"));
						}
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).sharingan == false) {
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("You haven't unlocked Sharingan"));
				}
			}
		}
	}

	public static class ShimuraSharinganAwake10SecondsProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("world") == null) {
				if (!dependencies.containsKey("world"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure ShimuraSharinganAwake10Seconds!");
				return;
			}
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure ShimuraSharinganAwake10Seconds!");
				return;
			}
			LevelAccessor world = (LevelAccessor) dependencies.get("world");
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).SharinganShimura == false) {
				new Object() {
					private int ticks = 0;
					private float waitTicks;
					private LevelAccessor world;

					public void start(LevelAccessor world, int waitTicks) {
						this.waitTicks = waitTicks;
						Registration.listen(NeoForge.EVENT_BUS, this);
						this.world = world;
					}

					@SubscribeEvent
					public void tick(ServerTickEvent.Post event) {
						if (true) {
							this.ticks += 1;
							if (this.ticks >= this.waitTicks)
								run();
						}
					}

					private void run() {
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendSystemMessage(
									Component.literal("You suddenly feel a surge of power through you as you awaken the Sharingan!"));
						}
						{
							boolean _setval = (true);
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.SharinganShimura = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							String _setval = "1x1";
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.dojutsusharingan = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof LivingEntity)
							((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.NAUSEA, (int) 200, (int) 4, (false), (false)));
						if (entity instanceof LivingEntity)
							((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.BLINDNESS, (int) 60, (int) 1, (false), (false)));
						if (entity instanceof Player) {
							ItemStack _setstack = new ItemStack(SharinganReleaseItem.block);
							_setstack.setCount((int) 1);
							Compat.giveItemToPlayer(((Player) entity), _setstack);
						}
						NeoForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 200);
			} else if (NarutoShippudenModVariables.get(entity).SharinganShimura == true) {
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendSystemMessage(Component.literal("You've already unlocked sharingan."));
				}
			}
		}
	}

	public static class ShimuraSharinganAwakeProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure ShimuraSharinganAwake!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (entity instanceof Player && !entity.level().isClientSide()) {
				((Player) entity).sendSystemMessage(
						Component.literal("You suddenly feel a surge of power through you as you awaken the Sharingan!"));
			}
			{
				boolean _setval = (true);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.SharinganShimura = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				String _setval = "1x1";
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.dojutsusharingan = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.NAUSEA, (int) 200, (int) 4, (false), (false)));
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.BLINDNESS, (int) 60, (int) 1, (false), (false)));
			if (entity instanceof Player) {
				ItemStack _setstack = new ItemStack(SharinganReleaseItem.block);
				_setstack.setCount((int) 1);
				Compat.giveItemToPlayer(((Player) entity), _setstack);
			}
		}
	}

	public static class TenseiganAwake10SecondsProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("world") == null) {
				if (!dependencies.containsKey("world"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure TenseiganAwake10Seconds!");
				return;
			}
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure TenseiganAwake10Seconds!");
				return;
			}
			LevelAccessor world = (LevelAccessor) dependencies.get("world");
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).tenseigan == false) {
				new Object() {
					private int ticks = 0;
					private float waitTicks;
					private LevelAccessor world;

					public void start(LevelAccessor world, int waitTicks) {
						this.waitTicks = waitTicks;
						Registration.listen(NeoForge.EVENT_BUS, this);
						this.world = world;
					}

					@SubscribeEvent
					public void tick(ServerTickEvent.Post event) {
						if (true) {
							this.ticks += 1;
							if (this.ticks >= this.waitTicks)
								run();
						}
					}

					private void run() {
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendSystemMessage(Component.literal("You've awakened Tenseigan!"));
						}
						{
							String _setval = "1x1";
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.dojutsutenseigan = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof Player) {
							ItemStack _setstack = new ItemStack(TenseiganReleaseItem.block);
							_setstack.setCount((int) 1);
							Compat.giveItemToPlayer(((Player) entity), _setstack);
						}
						{
							boolean _setval = (true);
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.tenseigan = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						NeoForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 200);
			} else if (NarutoShippudenModVariables.get(entity).tenseigan == true) {
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendSystemMessage(Component.literal("You've already unlocked tenseigan."));
				}
			}
		}
	}

	public static class TenseiganAwakeProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure TenseiganAwake!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (entity instanceof Player && !entity.level().isClientSide()) {
				((Player) entity).sendSystemMessage(Component.literal("You've awakened Tenseigan!"));
			}
			{
				String _setval = "1x1";
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.dojutsutenseigan = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof Player) {
				ItemStack _setstack = new ItemStack(TenseiganReleaseItem.block);
				_setstack.setCount((int) 1);
				Compat.giveItemToPlayer(((Player) entity), _setstack);
			}
			{
				boolean _setval = (true);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.tenseigan = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}


}
