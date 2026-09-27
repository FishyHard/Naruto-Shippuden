package net.mcreator.narutoshippudenmod.procedures;

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
import net.mcreator.narutoshippudenmod.item.DojutsuItems.FuramingoganBeamItem;
import net.mcreator.narutoshippudenmod.item.DojutsuItems.FuramingoganTechniqueItem;
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
import net.mcreator.narutoshippudenmod.item.DojutsuItems.VolticModeTechniqueItem;
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
import net.mcreator.narutoshippudenmod.particle.ModParticles.FuramingoganParticleParticle;
import net.mcreator.narutoshippudenmod.particle.ModParticles.KamuiParticleParticle;
import net.mcreator.narutoshippudenmod.particle.ModParticles.VolticParticleParticle;
import net.mcreator.narutoshippudenmod.potion.ModEffects.CoercionSharinganEffectPotionEffect;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.AbstractClientPlayerEntity;
import net.minecraft.client.renderer.entity.PlayerRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.registries.ForgeRegistries;

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
			IWorld world = (IWorld) dependencies.get("world");
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).byakugan == false) {
				new Object() {
					private int ticks = 0;
					private float waitTicks;
					private IWorld world;

					public void start(IWorld world, int waitTicks) {
						this.waitTicks = waitTicks;
						MinecraftForge.EVENT_BUS.register(this);
						this.world = world;
					}

					@SubscribeEvent
					public void tick(TickEvent.ServerTickEvent event) {
						if (event.phase == TickEvent.Phase.END) {
							this.ticks += 1;
							if (this.ticks >= this.waitTicks)
								run();
						}
					}

					private void run() {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(
									"You feel that the blood of the Hyuga clan flows in your veins, you have awakened the Byakugan"), (false));
						}
						{
							String _setval = "1x1";
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.dojutsubyakugan = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof PlayerEntity) {
							ItemStack _setstack = new ItemStack(ByakuganReleaseItem.block);
							_setstack.setCount((int) 1);
							ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
						}
						{
							boolean _setval = (true);
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.byakugan = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						MinecraftForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 200);
			} else if (NarutoShippudenModVariables.get(entity).byakugan == true) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You've already unlocked byakugan."), (false));
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
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(
						new StringTextComponent("You feel that the blood of the Hyuga clan flows in your veins, you have awakened the Byakugan"),
						(false));
			}
			{
				String _setval = "1x1";
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.dojutsubyakugan = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof PlayerEntity) {
				ItemStack _setstack = new ItemStack(ByakuganReleaseItem.block);
				_setstack.setCount((int) 1);
				ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
			}
			{
				boolean _setval = (true);
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
			IWorld world = (IWorld) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			Entity entity = (Entity) dependencies.get("entity");
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.BLINDNESS, (int) 100, (int) 3, (false), (false)));
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SLOWNESS, (int) 100, (int) 1, (false), (false)));
			if (entity instanceof LivingEntity)
				((LivingEntity) entity)
						.addPotionEffect(new EffectInstance(CoercionSharinganEffectPotionEffect.potion, (int) 100, (int) 1, (false), (false)));
			if (world instanceof World && !world.isRemote()) {
				((World) world).playSound(null, new BlockPos(x, y, z),
						(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("naruto_shippuden:sharingan")),
						SoundCategory.NEUTRAL, (float) 1, (float) 1);
			} else {
				((World) world).playSound(x, y, z,
						(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("naruto_shippuden:sharingan")),
						SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
			}
			if (world.isRemote()) {
				Minecraft.getInstance().gameRenderer.displayItemActivation(new ItemStack(SharinganReleaseTechniqueItem.block));
			}
		}
	}

	public static class DojutsuRendererProcedure {
		@Mod.EventBusSubscriber
		private static class GlobalTrigger {
			@OnlyIn(Dist.CLIENT)
			@SubscribeEvent
			public static void KleidersRenderEvent(RenderLivingEvent event) {
				Entity entity = event.getEntity();
				World world = entity.world;
				double i = entity.getPosX();
				double j = entity.getPosY();
				double k = entity.getPosZ();
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
						if (_evt.getRenderer() instanceof PlayerRenderer) {
							if (_evt instanceof RenderLivingEvent.Pre) {
								//  _evt.setCanceled(true); 
							}
							ModelSwapRenderers.renderDojutsu(_evt, "naruto_shippuden:textures/dojutsu/byakugan/byakugan_2x1_pupils_1x1.png");
						}
					} else if ((NarutoShippudenModVariables.get(entity).dojutsubyakugan).equals("2x1")) {
						if (_evt.getRenderer() instanceof PlayerRenderer) {
							if (_evt instanceof RenderLivingEvent.Pre) {
								//  _evt.setCanceled(true); 
							}
							ModelSwapRenderers.renderDojutsu(_evt, "naruto_shippuden:textures/dojutsu/byakugan/byakugan_2x1_pupils_2x1.png");
						}
					} else if ((NarutoShippudenModVariables.get(entity).dojutsubyakugan).equals("1x2")) {
						if (_evt.getRenderer() instanceof PlayerRenderer) {
							if (_evt instanceof RenderLivingEvent.Pre) {
								//  _evt.setCanceled(true); 
							}
							ModelSwapRenderers.renderDojutsu(_evt, "naruto_shippuden:textures/dojutsu/byakugan/byakugan_2x2_pupils_1x1.png");
						}
					} else if ((NarutoShippudenModVariables.get(entity).dojutsubyakugan).equals("2x2")) {
						if (_evt.getRenderer() instanceof PlayerRenderer) {
							if (_evt instanceof RenderLivingEvent.Pre) {
								//  _evt.setCanceled(true); 
							}
							ModelSwapRenderers.renderDojutsu(_evt, "naruto_shippuden:textures/dojutsu/byakugan/byakugan_2x2_pupils_1x2.png");
						}
					}
				} else if (NarutoShippudenModVariables.get(entity).byakuganactivate == false) {
					if ((NarutoShippudenModVariables.get(entity).dojutsubyakugan).equals("1x1")) {
						if (_evt.getRenderer() instanceof PlayerRenderer) {
							if (_evt instanceof RenderLivingEvent.Pre) {
								//  _evt.setCanceled(true); 
							}
							ModelSwapRenderers.renderDojutsu(_evt, "naruto_shippuden:textures/dojutsu/byakugan/byakugan_2x1_pupils_1x1_not_active.png");
						}
					} else if ((NarutoShippudenModVariables.get(entity).dojutsubyakugan).equals("2x1")) {
						if (_evt.getRenderer() instanceof PlayerRenderer) {
							if (_evt instanceof RenderLivingEvent.Pre) {
								//  _evt.setCanceled(true); 
							}
							ModelSwapRenderers.renderDojutsu(_evt, "naruto_shippuden:textures/dojutsu/byakugan/byakugan_2x1_pupils_2x1_not_active.png");
						}
					} else if ((NarutoShippudenModVariables.get(entity).dojutsubyakugan).equals("1x2")) {
						if (_evt.getRenderer() instanceof PlayerRenderer) {
							if (_evt instanceof RenderLivingEvent.Pre) {
								//  _evt.setCanceled(true); 
							}
							ModelSwapRenderers.renderDojutsu(_evt, "naruto_shippuden:textures/dojutsu/byakugan/byakugan_2x2_pupils_1x1_not_active.png");
						}
					} else if ((NarutoShippudenModVariables.get(entity).dojutsubyakugan).equals("2x2")) {
						if (_evt.getRenderer() instanceof PlayerRenderer) {
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
					if (_evt.getRenderer() instanceof PlayerRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						ModelSwapRenderers.renderDojutsu(_evt, "naruto_shippuden:textures/dojutsu/ketsuryugan/ketsuryugan_2x1_pupils_1x1.png");
					}
				} else if ((NarutoShippudenModVariables.get(entity).dojutsuketsuryugan).equals("2x1")) {
					if (_evt.getRenderer() instanceof PlayerRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						ModelSwapRenderers.renderDojutsu(_evt, "naruto_shippuden:textures/dojutsu/ketsuryugan/ketsuryugan_2x1_pupils_2x1.png");
					}
				} else if ((NarutoShippudenModVariables.get(entity).dojutsuketsuryugan).equals("1x2")) {
					if (_evt.getRenderer() instanceof PlayerRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						ModelSwapRenderers.renderDojutsu(_evt, "naruto_shippuden:textures/dojutsu/ketsuryugan/ketsuryugan_2x2_pupils_1x1.png");
					}
				} else if ((NarutoShippudenModVariables.get(entity).dojutsuketsuryugan).equals("2x2")) {
					if (_evt.getRenderer() instanceof PlayerRenderer) {
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
						if (_evt.getRenderer() instanceof PlayerRenderer) {
							if (_evt instanceof RenderLivingEvent.Pre) {
								//  _evt.setCanceled(true); 
							}
							ModelSwapRenderers.renderDojutsu(_evt, "naruto_shippuden:textures/dojutsu/sharingan/sharingan2px1px.png");
						}
					} else if ((NarutoShippudenModVariables.get(entity).dojutsusharingan).equals("2x1")) {
						if (_evt.getRenderer() instanceof PlayerRenderer) {
							if (_evt instanceof RenderLivingEvent.Pre) {
								//  _evt.setCanceled(true); 
							}
							ModelSwapRenderers.renderDojutsu(_evt, "naruto_shippuden:textures/dojutsu/sharingan/sharingan2px1px2.png");
						}
					} else if ((NarutoShippudenModVariables.get(entity).dojutsusharingan).equals("1x2")) {
						if (_evt.getRenderer() instanceof PlayerRenderer) {
							if (_evt instanceof RenderLivingEvent.Pre) {
								//  _evt.setCanceled(true); 
							}
							ModelSwapRenderers.renderDojutsu(_evt, "naruto_shippuden:textures/dojutsu/sharingan/sharingan2px2px2.png");
						}
					} else if ((NarutoShippudenModVariables.get(entity).dojutsusharingan).equals("2x2")) {
						if (_evt.getRenderer() instanceof PlayerRenderer) {
							if (_evt instanceof RenderLivingEvent.Pre) {
								//  _evt.setCanceled(true); 
							}
							ModelSwapRenderers.renderDojutsu(_evt, "naruto_shippuden:textures/dojutsu/sharingan/sharingan2px2px1.png");
						}
					}
				}
				if (NarutoShippudenModVariables.get(entity).SharinganKakashi == true) {
					if ((NarutoShippudenModVariables.get(entity).dojutsusharingan).equals("1x1")) {
						if (_evt.getRenderer() instanceof PlayerRenderer) {
							if (_evt instanceof RenderLivingEvent.Pre) {
								//  _evt.setCanceled(true); 
							}
							ModelSwapRenderers.renderDojutsu(_evt, "naruto_shippuden:textures/dojutsu/sharingan/kakashi/kakashisharingan2px1px.png");
						}
					} else if ((NarutoShippudenModVariables.get(entity).dojutsusharingan).equals("2x1")) {
						if (_evt.getRenderer() instanceof PlayerRenderer) {
							if (_evt instanceof RenderLivingEvent.Pre) {
								//  _evt.setCanceled(true); 
							}
							ModelSwapRenderers.renderDojutsu(_evt, "naruto_shippuden:textures/dojutsu/sharingan/kakashi/kakashisharingan2px1px2.png");
						}
					} else if ((NarutoShippudenModVariables.get(entity).dojutsusharingan).equals("1x2")) {
						if (_evt.getRenderer() instanceof PlayerRenderer) {
							if (_evt instanceof RenderLivingEvent.Pre) {
								//  _evt.setCanceled(true); 
							}
							ModelSwapRenderers.renderDojutsu(_evt, "naruto_shippuden:textures/dojutsu/sharingan/kakashi/kakashisharingan2px2px2.png");
						}
					} else if ((NarutoShippudenModVariables.get(entity).dojutsusharingan).equals("2x2")) {
						if (_evt.getRenderer() instanceof PlayerRenderer) {
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
						if (_evt.getRenderer() instanceof PlayerRenderer) {
							if (_evt instanceof RenderLivingEvent.Pre) {
								//  _evt.setCanceled(true); 
							}
							ModelSwapRenderers.renderDojutsu(_evt, "naruto_shippuden:textures/dojutsu/mangekyou_sharingan/sasuke/sasukemangekyo2px1px.png");
						}
					} else if ((NarutoShippudenModVariables.get(entity).dojutsums).equals("2x1")) {
						if (_evt.getRenderer() instanceof PlayerRenderer) {
							if (_evt instanceof RenderLivingEvent.Pre) {
								//  _evt.setCanceled(true); 
							}
							ModelSwapRenderers.renderDojutsu(_evt, "naruto_shippuden:textures/dojutsu/mangekyou_sharingan/sasuke/sasukemangekyo2px1px2.png");
						}
					} else if ((NarutoShippudenModVariables.get(entity).dojutsums).equals("1x2")) {
						if (_evt.getRenderer() instanceof PlayerRenderer) {
							if (_evt instanceof RenderLivingEvent.Pre) {
								//  _evt.setCanceled(true); 
							}
							ModelSwapRenderers.renderDojutsu(_evt, "naruto_shippuden:textures/dojutsu/mangekyou_sharingan/sasuke/sasukemangekyo2px2px2.png");
						}
					} else if ((NarutoShippudenModVariables.get(entity).dojutsums).equals("2x2")) {
						if (_evt.getRenderer() instanceof PlayerRenderer) {
							if (_evt instanceof RenderLivingEvent.Pre) {
								//  _evt.setCanceled(true); 
							}
							ModelSwapRenderers.renderDojutsu(_evt, "naruto_shippuden:textures/dojutsu/mangekyou_sharingan/sasuke/sasukemangekyo2px2px1.png");
						}
					}
				} else if (NarutoShippudenModVariables.get(entity).MangekyouSharinganItachi == true) {
					if ((NarutoShippudenModVariables.get(entity).dojutsums).equals("1x1")) {
						if (_evt.getRenderer() instanceof PlayerRenderer) {
							if (_evt instanceof RenderLivingEvent.Pre) {
								//  _evt.setCanceled(true); 
							}
							ModelSwapRenderers.renderDojutsu(_evt, "naruto_shippuden:textures/dojutsu/mangekyou_sharingan/itachi/itachimangekyo2px1px.png");
						}
					} else if ((NarutoShippudenModVariables.get(entity).dojutsums).equals("2x1")) {
						if (_evt.getRenderer() instanceof PlayerRenderer) {
							if (_evt instanceof RenderLivingEvent.Pre) {
								//  _evt.setCanceled(true); 
							}
							ModelSwapRenderers.renderDojutsu(_evt, "naruto_shippuden:textures/dojutsu/mangekyou_sharingan/itachi/itachimangekyo2px1px2.png");
						}
					} else if ((NarutoShippudenModVariables.get(entity).dojutsums).equals("1x2")) {
						if (_evt.getRenderer() instanceof PlayerRenderer) {
							if (_evt instanceof RenderLivingEvent.Pre) {
								//  _evt.setCanceled(true); 
							}
							ModelSwapRenderers.renderDojutsu(_evt, "naruto_shippuden:textures/dojutsu/mangekyou_sharingan/itachi/itachimangekyo2px2px2.png");
						}
					} else if ((NarutoShippudenModVariables.get(entity).dojutsums).equals("2x2")) {
						if (_evt.getRenderer() instanceof PlayerRenderer) {
							if (_evt instanceof RenderLivingEvent.Pre) {
								//  _evt.setCanceled(true); 
							}
							ModelSwapRenderers.renderDojutsu(_evt, "naruto_shippuden:textures/dojutsu/mangekyou_sharingan/itachi/itachimangekyo2px2px1.png");
						}
					}
				} else if (NarutoShippudenModVariables.get(entity).MangekyouSharinganMadara == true) {
					if ((NarutoShippudenModVariables.get(entity).dojutsums).equals("1x1")) {
						if (_evt.getRenderer() instanceof PlayerRenderer) {
							if (_evt instanceof RenderLivingEvent.Pre) {
								//  _evt.setCanceled(true); 
							}
							ModelSwapRenderers.renderDojutsu(_evt, "naruto_shippuden:textures/dojutsu/mangekyou_sharingan/madara/madaramangekyo2px1px.png");
						}
					} else if ((NarutoShippudenModVariables.get(entity).dojutsums).equals("2x1")) {
						if (_evt.getRenderer() instanceof PlayerRenderer) {
							if (_evt instanceof RenderLivingEvent.Pre) {
								//  _evt.setCanceled(true); 
							}
							ModelSwapRenderers.renderDojutsu(_evt, "naruto_shippuden:textures/dojutsu/mangekyou_sharingan/madara/madaramangekyo2px1px2.png");
						}
					} else if ((NarutoShippudenModVariables.get(entity).dojutsums).equals("1x2")) {
						if (_evt.getRenderer() instanceof PlayerRenderer) {
							if (_evt instanceof RenderLivingEvent.Pre) {
								//  _evt.setCanceled(true); 
							}
							ModelSwapRenderers.renderDojutsu(_evt, "naruto_shippuden:textures/dojutsu/mangekyou_sharingan/madara/madaramangekyo2px2px2.png");
						}
					} else if ((NarutoShippudenModVariables.get(entity).dojutsums).equals("2x2")) {
						if (_evt.getRenderer() instanceof PlayerRenderer) {
							if (_evt instanceof RenderLivingEvent.Pre) {
								//  _evt.setCanceled(true); 
							}
							ModelSwapRenderers.renderDojutsu(_evt, "naruto_shippuden:textures/dojutsu/mangekyou_sharingan/madara/madaramangekyo2px2px1.png");
						}
					}
				} else if (NarutoShippudenModVariables.get(entity).MangekyouSharinganObito == true) {
					if ((NarutoShippudenModVariables.get(entity).dojutsums).equals("1x1")) {
						if (_evt.getRenderer() instanceof PlayerRenderer) {
							if (_evt instanceof RenderLivingEvent.Pre) {
								//  _evt.setCanceled(true); 
							}
							ModelSwapRenderers.renderDojutsu(_evt, "naruto_shippuden:textures/dojutsu/mangekyou_sharingan/obito/obitomangekyo2px1px.png");
						}
					} else if ((NarutoShippudenModVariables.get(entity).dojutsums).equals("2x1")) {
						if (_evt.getRenderer() instanceof PlayerRenderer) {
							if (_evt instanceof RenderLivingEvent.Pre) {
								//  _evt.setCanceled(true); 
							}
							ModelSwapRenderers.renderDojutsu(_evt, "naruto_shippuden:textures/dojutsu/mangekyou_sharingan/obito/obitomangekyo2px1px2");
						}
					} else if ((NarutoShippudenModVariables.get(entity).dojutsums).equals("1x2")) {
						if (_evt.getRenderer() instanceof PlayerRenderer) {
							if (_evt instanceof RenderLivingEvent.Pre) {
								//  _evt.setCanceled(true); 
							}
							ModelSwapRenderers.renderDojutsu(_evt, "naruto_shippuden:textures/dojutsu/mangekyou_sharingan/obito/obitomangekyo2px2px2.png");
						}
					} else if ((NarutoShippudenModVariables.get(entity).dojutsums).equals("2x2")) {
						if (_evt.getRenderer() instanceof PlayerRenderer) {
							if (_evt instanceof RenderLivingEvent.Pre) {
								//  _evt.setCanceled(true); 
							}
							ModelSwapRenderers.renderDojutsu(_evt, "naruto_shippuden:textures/dojutsu/mangekyou_sharingan/obito/obitomangekyo2px2px1.png");
						}
					}
				} else if (NarutoShippudenModVariables.get(entity).MangekyouSharinganShisui == true) {
					if ((NarutoShippudenModVariables.get(entity).dojutsums).equals("1x1")) {
						if (_evt.getRenderer() instanceof PlayerRenderer) {
							if (_evt instanceof RenderLivingEvent.Pre) {
								//  _evt.setCanceled(true); 
							}
							ModelSwapRenderers.renderDojutsu(_evt, "naruto_shippuden:textures/dojutsu/mangekyou_sharingan/shisui/shisuimangekyo2px1px.png");
						}
					} else if ((NarutoShippudenModVariables.get(entity).dojutsums).equals("2x1")) {
						if (_evt.getRenderer() instanceof PlayerRenderer) {
							if (_evt instanceof RenderLivingEvent.Pre) {
								//  _evt.setCanceled(true); 
							}
							ModelSwapRenderers.renderDojutsu(_evt, "naruto_shippuden:textures/dojutsu/mangekyou_sharingan/shisui/shisuimangekyo2px1px2.png");
						}
					} else if ((NarutoShippudenModVariables.get(entity).dojutsums).equals("1x2")) {
						if (_evt.getRenderer() instanceof PlayerRenderer) {
							if (_evt instanceof RenderLivingEvent.Pre) {
								//  _evt.setCanceled(true); 
							}
							ModelSwapRenderers.renderDojutsu(_evt, "naruto_shippuden:textures/dojutsu/mangekyou_sharingan/shisui/shisuimangekyo2px2px2.png");
						}
					} else if ((NarutoShippudenModVariables.get(entity).dojutsums).equals("2x2")) {
						if (_evt.getRenderer() instanceof PlayerRenderer) {
							if (_evt instanceof RenderLivingEvent.Pre) {
								//  _evt.setCanceled(true); 
							}
							ModelSwapRenderers.renderDojutsu(_evt, "naruto_shippuden:textures/dojutsu/mangekyou_sharingan/shisui/shisuimangekyo2px2px1.png");
						}
					}
				} else if (NarutoShippudenModVariables.get(entity).MangekyouSharinganKakashi == true) {
					if ((NarutoShippudenModVariables.get(entity).dojutsums).equals("1x1")) {
						if (_evt.getRenderer() instanceof PlayerRenderer) {
							if (_evt instanceof RenderLivingEvent.Pre) {
								//  _evt.setCanceled(true); 
							}
							ModelSwapRenderers.renderDojutsu(_evt, "naruto_shippuden:textures/dojutsu/mangekyou_sharingan/kakashi/kakashimangekyo2px1px.png");
						}
					} else if ((NarutoShippudenModVariables.get(entity).dojutsums).equals("2x1")) {
						if (_evt.getRenderer() instanceof PlayerRenderer) {
							if (_evt instanceof RenderLivingEvent.Pre) {
								//  _evt.setCanceled(true); 
							}
							ModelSwapRenderers.renderDojutsu(_evt, "naruto_shippuden:textures/dojutsu/mangekyou_sharingan/kakashi/kakashimangekyo2px1px2.png");
						}
					} else if ((NarutoShippudenModVariables.get(entity).dojutsums).equals("1x2")) {
						if (_evt.getRenderer() instanceof PlayerRenderer) {
							if (_evt instanceof RenderLivingEvent.Pre) {
								//  _evt.setCanceled(true); 
							}
							ModelSwapRenderers.renderDojutsu(_evt, "naruto_shippuden:textures/dojutsu/mangekyou_sharingan/kakashi/kakashimangekyo2px2px2.png");
						}
					} else if ((NarutoShippudenModVariables.get(entity).dojutsums).equals("2x2")) {
						if (_evt.getRenderer() instanceof PlayerRenderer) {
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
					if (_evt.getRenderer() instanceof PlayerRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						ModelSwapRenderers.renderDojutsu(_evt, "naruto_shippuden:textures/dojutsu/rinnegan/rinnegan_2x1_pupils_1x1.png");
					}
				} else if ((NarutoShippudenModVariables.get(entity).dojutsurinnegan).equals("2x1")) {
					if (_evt.getRenderer() instanceof PlayerRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						ModelSwapRenderers.renderDojutsu(_evt, "naruto_shippuden:textures/dojutsu/rinnegan/rinnegan_2x1_pupils_2x1.png");
					}
				} else if ((NarutoShippudenModVariables.get(entity).dojutsurinnegan).equals("1x2")) {
					if (_evt.getRenderer() instanceof PlayerRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						ModelSwapRenderers.renderDojutsu(_evt, "naruto_shippuden:textures/dojutsu/rinnegan/rinnegan_2x2_pupils_1x1.png");
					}
				} else if ((NarutoShippudenModVariables.get(entity).dojutsurinnegan).equals("2x2")) {
					if (_evt.getRenderer() instanceof PlayerRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						ModelSwapRenderers.renderDojutsu(_evt, "naruto_shippuden:textures/dojutsu/rinnegan/rinnegan_2x2_pupils_1x2.png");
					}
				}
			}
			if (NarutoShippudenModVariables.get(entity).tenseiganactivate == true) {
				if ((NarutoShippudenModVariables.get(entity).dojutsutenseigan).equals("1x1")) {
					if (_evt.getRenderer() instanceof PlayerRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						ModelSwapRenderers.renderDojutsu(_evt, "naruto_shippuden:textures/dojutsu/tenseigan/tenseigan_2x1_pupils_1x1.png");
					}
				} else if ((NarutoShippudenModVariables.get(entity).dojutsutenseigan).equals("2x1")) {
					if (_evt.getRenderer() instanceof PlayerRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						ModelSwapRenderers.renderDojutsu(_evt, "naruto_shippuden:textures/dojutsu/tenseigan/tenseigan_2x1_pupils_2x1.png");
					}
				} else if ((NarutoShippudenModVariables.get(entity).dojutsutenseigan).equals("1x2")) {
					if (_evt.getRenderer() instanceof PlayerRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						ModelSwapRenderers.renderDojutsu(_evt, "naruto_shippuden:textures/dojutsu/tenseigan/tenseigan_2x2_pupils_1x1.png");
					}
				} else if ((NarutoShippudenModVariables.get(entity).dojutsutenseigan).equals("2x2")) {
					if (_evt.getRenderer() instanceof PlayerRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						ModelSwapRenderers.renderDojutsu(_evt, "naruto_shippuden:textures/dojutsu/tenseigan/tenseigan_2x2_pupils_1x2.png");
					}
				}
			}
			if (NarutoShippudenModVariables.get(entity).isshikidojutsuactivate == true) {
				if ((NarutoShippudenModVariables.get(entity).dojutsuisshiki).equals("1x1")) {
					if (_evt.getRenderer() instanceof PlayerRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						ModelSwapRenderers.renderDojutsu(_evt, "naruto_shippuden:textures/dojutsu/isshiki/isshiki_dojutsu_2x1_pupils_1x1.png");
					}
				} else if ((NarutoShippudenModVariables.get(entity).dojutsuisshiki).equals("2x1")) {
					if (_evt.getRenderer() instanceof PlayerRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						ModelSwapRenderers.renderDojutsu(_evt, "naruto_shippuden:textures/dojutsu/isshiki/isshiki_dojutsu_2x1_pupils_2x1.png");
					}
				} else if ((NarutoShippudenModVariables.get(entity).dojutsuisshiki).equals("1x2")) {
					if (_evt.getRenderer() instanceof PlayerRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						ModelSwapRenderers.renderDojutsu(_evt, "naruto_shippuden:textures/dojutsu/isshiki/isshiki_dojutsu_2x2_pupils_1x1.png");
					}
				} else if ((NarutoShippudenModVariables.get(entity).dojutsuisshiki).equals("2x2")) {
					if (_evt.getRenderer() instanceof PlayerRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						ModelSwapRenderers.renderDojutsu(_evt, "naruto_shippuden:textures/dojutsu/isshiki/isshiki_dojutsu_2x2_pupils_1x2.png");
					}
				}
			}
			if (NarutoShippudenModVariables.get(entity).shimura_active == true) {
				if ((NarutoShippudenModVariables.get(entity).dojutsusharingan).equals("1x1")) {
					if (_evt.getRenderer() instanceof PlayerRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						ModelSwapRenderers.renderDojutsu(_evt, "naruto_shippuden:textures/dojutsu/shimura/sharingan2px1px.png");
					}
				} else if ((NarutoShippudenModVariables.get(entity).dojutsusharingan).equals("2x1")) {
					if (_evt.getRenderer() instanceof PlayerRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						ModelSwapRenderers.renderDojutsu(_evt, "naruto_shippuden:textures/dojutsu/shimura/sharingan2px1px2.png");
					}
				} else if ((NarutoShippudenModVariables.get(entity).dojutsusharingan).equals("1x2")) {
					if (_evt.getRenderer() instanceof PlayerRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						ModelSwapRenderers.renderDojutsu(_evt, "naruto_shippuden:textures/dojutsu/shimura/sharingan2px2px2.png");
					}
				} else if ((NarutoShippudenModVariables.get(entity).dojutsusharingan).equals("2x2")) {
					if (_evt.getRenderer() instanceof PlayerRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						ModelSwapRenderers.renderDojutsu(_evt, "naruto_shippuden:textures/dojutsu/shimura/sharingan2px2px1.png");
					}
				}
				if (_evt.getRenderer() instanceof PlayerRenderer) {
					if (_evt instanceof RenderLivingEvent.Pre) {
						//  _evt.setCanceled(true); 
					}
					ModelSwapRenderers.renderDojutsu(_evt, "naruto_shippuden:textures/dojutsu/shimura/shimura_body.png");
				}
				if (_evt.getRenderer() instanceof PlayerRenderer) {
					if (_evt instanceof RenderLivingEvent.Pre) {
						//  _evt.setCanceled(true); 
					}
					ModelSwapRenderers.renderDojutsu(_evt, "naruto_shippuden:textures/dojutsu/shimura/shimura_head_open.png");
				}
			} else if (NarutoShippudenModVariables.get(entity).shimura_active == false) {
				if (NarutoShippudenModVariables.get(entity).shimurareleaselogic == true) {
					if (_evt.getRenderer() instanceof PlayerRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						ModelSwapRenderers.renderDojutsu(_evt, "naruto_shippuden:textures/dojutsu/shimura/shimura_body.png");
					}
					if (_evt.getRenderer() instanceof PlayerRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						ModelSwapRenderers.renderDojutsu(_evt, "naruto_shippuden:textures/dojutsu/shimura/shimura_head.png");
					}
				}
			}
		}
	}

	public static class FuramingoganBeamProjectileHitsLivingEntityProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure FuramingoganBeamProjectileHitsLivingEntity!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.POISON, (int) 100, (int) 2, (false), (false)));
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SLOWNESS, (int) 100, (int) 0, (false), (false)));
		}
	}

	public static class FuramingoganReleaseRightclickedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure FuramingoganReleaseRightclicked!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).furamingoganrelease == 0) {
				if (NarutoShippudenModVariables.get(entity).jp >= 15) {
					if (entity instanceof PlayerEntity) {
						ItemStack _setstack = new ItemStack(FuramingoganTechniqueItem.block);
						_setstack.setCount((int) 1);
						ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
					}
					{
						double _setval = 1;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.furamingoganlearn = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 15);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).furamingoganrelease + 1);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.furamingoganrelease = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("-15 JP"), (false));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 14) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough JP"), (false));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).furamingoganrelease == 1) {
				if (NarutoShippudenModVariables.get(entity).jp >= 20) {
					{
						double _setval = 2;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.furamingoganlearn = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 20);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).furamingoganrelease + 1);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.furamingoganrelease = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("-20 JP"), (false));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 19) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough JP"), (false));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).furamingoganrelease == 2) {
				if (NarutoShippudenModVariables.get(entity).jp >= 25) {
					{
						double _setval = 3;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.furamingoganlearn = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 25);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).furamingoganrelease + 1);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.furamingoganrelease = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("-25 JP"), (false));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 24) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough JP"), (false));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).furamingoganrelease == 3) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Wait For Newer Updates"), (false));
				}
			}
		}
	}

	public static class FuramingoganTechniqueRightclickedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("world") == null) {
				if (!dependencies.containsKey("world"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure FuramingoganTechniqueRightclicked!");
				return;
			}
			if (dependencies.get("x") == null) {
				if (!dependencies.containsKey("x"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency x for procedure FuramingoganTechniqueRightclicked!");
				return;
			}
			if (dependencies.get("y") == null) {
				if (!dependencies.containsKey("y"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency y for procedure FuramingoganTechniqueRightclicked!");
				return;
			}
			if (dependencies.get("z") == null) {
				if (!dependencies.containsKey("z"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency z for procedure FuramingoganTechniqueRightclicked!");
				return;
			}
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure FuramingoganTechniqueRightclicked!");
				return;
			}
			IWorld world = (IWorld) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			Entity entity = (Entity) dependencies.get("entity");
			double zRadius3 = 0;
			double zRadius2 = 0;
			double zRadius = 0;
			double xRadius6 = 0;
			double xRadius7 = 0;
			double particleAmount = 0;
			double xRadius8 = 0;
			double zRadius8 = 0;
			double xRadius2 = 0;
			double zRadius7 = 0;
			double xRadius3 = 0;
			double zRadius6 = 0;
			double xRadius4 = 0;
			double zRadius5 = 0;
			double zRadius4 = 0;
			double xRadius5 = 0;
			double loop = 0;
			double loop2 = 0;
			double loop3 = 0;
			double yaw = 0;
			double loop8 = 0;
			double loop6 = 0;
			double xRadius = 0;
			double loop7 = 0;
			double loop4 = 0;
			double loop5 = 0;
			double xBeam = 0;
			double yBeam = 0;
			double zBeam = 0;
			double beam = 0;
			if (NarutoShippudenModVariables.get(entity).TheSirMarcus == true) {
				if (!entity.isSneaking()) {
					if (NarutoShippudenModVariables.get(entity).furamingogan_technique == 0) {
						if (NarutoShippudenModVariables.get(entity).furamingoganlearn >= 1) {
							if (NarutoShippudenModVariables.get(entity).ninjutsu >= 15) {
								if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 150) {
									{
										List<Entity> _entfound = world.getEntitiesWithinAABB(Entity.class, new AxisAlignedBB(x - (12 / 2d), y - (12 / 2d),
												z - (12 / 2d), x + (12 / 2d), y + (12 / 2d), z + (12 / 2d)), null).stream().sorted(new Object() {
													Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
														return Comparator
																.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
													}
												}.compareDistOf(x, y, z)).collect(Collectors.toList());
										for (Entity entityiterator : _entfound) {
											if (!(entityiterator == entity)) {
												entityiterator.attackEntityFrom(DamageSource.GENERIC, (float) 10);
												if (entityiterator instanceof LivingEntity)
													((LivingEntity) entityiterator)
															.addPotionEffect(new EffectInstance(Effects.POISON, (int) 160, (int) 2, (false), (false)));
											}
										}
									}
									loop = 0;
									particleAmount = 80;
									xRadius = 6;
									zRadius = 6;
									loop2 = 0;
									xRadius2 = 3;
									zRadius2 = 3;
									while (loop < particleAmount) {
										world.addParticle(FuramingoganParticleParticle.particle,
												(x + 0 + Math.cos(((Math.PI * 2) / particleAmount) * loop) * xRadius), y,
												(z + 0 + Math.sin(((Math.PI * 2) / particleAmount) * loop) * zRadius), 0, 0, 0);
										loop = (loop + 1);
									}
									while (loop2 < particleAmount) {
										world.addParticle(FuramingoganParticleParticle.particle,
												(x + 0 + Math.cos(((Math.PI * 2) / particleAmount) * loop2) * xRadius2), y,
												(z + 0 + Math.sin(((Math.PI * 2) / particleAmount) * loop2) * zRadius2), 0, 0, 0);
										loop2 = (loop2 + 1);
									}
									{
										double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 150);
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.ChakraAmount = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
										if (entity instanceof PlayerEntity)
											((PlayerEntity) entity).getCooldownTracker().setCooldown(FuramingoganTechniqueItem.block, (int) 750);
									} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
										if (entity instanceof PlayerEntity)
											((PlayerEntity) entity).getCooldownTracker().setCooldown(FuramingoganTechniqueItem.block, (int) 500);
									} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
										if (entity instanceof PlayerEntity)
											((PlayerEntity) entity).getCooldownTracker().setCooldown(FuramingoganTechniqueItem.block, (int) 400);
									} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
										if (entity instanceof PlayerEntity)
											((PlayerEntity) entity).getCooldownTracker().setCooldown(FuramingoganTechniqueItem.block, (int) 300);
									} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
										if (entity instanceof PlayerEntity)
											((PlayerEntity) entity).getCooldownTracker().setCooldown(FuramingoganTechniqueItem.block, (int) 200);
									}
								} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 149) {
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 14) {
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu"), (false));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).furamingoganlearn >= 1)) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this technique."), (false));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).furamingogan_technique == 1) {
						if (NarutoShippudenModVariables.get(entity).furamingoganlearn >= 2) {
							if (NarutoShippudenModVariables.get(entity).ninjutsu >= 20) {
								if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 350) {
									beam = 0;
									while (beam < 50) {
										{
											Entity _shootFrom = entity;
											World projectileLevel = _shootFrom.world;
											if (!projectileLevel.isRemote()) {
												ProjectileEntity _entityToSpawn = new Object() {
													public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
														AbstractArrowEntity entityToSpawn = new FuramingoganBeamItem.ArrowCustomEntity(
																FuramingoganBeamItem.arrow, world);
														entityToSpawn.setShooter(shooter);
														entityToSpawn.setDamage(damage);
														entityToSpawn.setKnockbackStrength(knockback);
														entityToSpawn.setSilent(true);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 25, 0);
												_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
												_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1,
														0);
												projectileLevel.addEntity(_entityToSpawn);
											}
										}
										world.addParticle(FuramingoganParticleParticle.particle,
												(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
														entity.getEyePosition(1f).add(entity.getLook(1f).x * beam, entity.getLook(1f).y * beam,
																entity.getLook(1f).z * beam),
														RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getX()),
												(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
														entity.getEyePosition(1f).add(entity.getLook(1f).x * beam, entity.getLook(1f).y * beam,
																entity.getLook(1f).z * beam),
														RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getY()),
												(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
														entity.getEyePosition(1f).add(entity.getLook(1f).x * beam, entity.getLook(1f).y * beam,
																entity.getLook(1f).z * beam),
														RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getZ()),
												0, 0, 0);
										beam = (beam + 1);
									}
									{
										double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 350);
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.ChakraAmount = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
										if (entity instanceof PlayerEntity)
											((PlayerEntity) entity).getCooldownTracker().setCooldown(FuramingoganTechniqueItem.block, (int) 1500);
									} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
										if (entity instanceof PlayerEntity)
											((PlayerEntity) entity).getCooldownTracker().setCooldown(FuramingoganTechniqueItem.block, (int) 1000);
									} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
										if (entity instanceof PlayerEntity)
											((PlayerEntity) entity).getCooldownTracker().setCooldown(FuramingoganTechniqueItem.block, (int) 750);
									} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
										if (entity instanceof PlayerEntity)
											((PlayerEntity) entity).getCooldownTracker().setCooldown(FuramingoganTechniqueItem.block, (int) 500);
									} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
										if (entity instanceof PlayerEntity)
											((PlayerEntity) entity).getCooldownTracker().setCooldown(FuramingoganTechniqueItem.block, (int) 250);
									}
								} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 349) {
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 19) {
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu"), (false));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).furamingoganlearn >= 2)) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this technique."), (false));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).furamingogan_technique == 2) {
						if (NarutoShippudenModVariables.get(entity).furamingoganlearn >= 3) {
							if (NarutoShippudenModVariables.get(entity).ninjutsu >= 25) {
								if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 500) {
									entity.setMotion(0, 3, 0);
									new Object() {
										private int ticks = 0;
										private float waitTicks;
										private IWorld world;

										public void start(IWorld world, int waitTicks) {
											this.waitTicks = waitTicks;
											MinecraftForge.EVENT_BUS.register(this);
											this.world = world;
										}

										@SubscribeEvent
										public void tick(TickEvent.ServerTickEvent event) {
											if (event.phase == TickEvent.Phase.END) {
												this.ticks += 1;
												if (this.ticks >= this.waitTicks)
													run();
											}
										}

										private void run() {
											entity.setMotion(0, (-10), 0);
											MinecraftForge.EVENT_BUS.unregister(this);
										}
									}.start(world, (int) 35);
									{
										boolean _setval = (true);
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.furamingogan_jump = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									{
										double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 500);
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.ChakraAmount = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
										if (entity instanceof PlayerEntity)
											((PlayerEntity) entity).getCooldownTracker().setCooldown(FuramingoganTechniqueItem.block, (int) 2500);
									} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
										if (entity instanceof PlayerEntity)
											((PlayerEntity) entity).getCooldownTracker().setCooldown(FuramingoganTechniqueItem.block, (int) 2000);
									} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
										if (entity instanceof PlayerEntity)
											((PlayerEntity) entity).getCooldownTracker().setCooldown(FuramingoganTechniqueItem.block, (int) 1500);
									} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
										if (entity instanceof PlayerEntity)
											((PlayerEntity) entity).getCooldownTracker().setCooldown(FuramingoganTechniqueItem.block, (int) 1000);
									} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
										if (entity instanceof PlayerEntity)
											((PlayerEntity) entity).getCooldownTracker().setCooldown(FuramingoganTechniqueItem.block, (int) 500);
									}
								} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 499) {
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 24) {
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu"), (false));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).furamingoganlearn >= 3)) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this technique."), (false));
							}
						}
					}
				} else if (entity.isSneaking()) {
					if (NarutoShippudenModVariables.get(entity).furamingogan_technique == 0) {
						{
							double _setval = 1;
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.furamingogan_technique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Selected: Furamingogan Beam"), (true));
						}
					} else if (NarutoShippudenModVariables.get(entity).furamingogan_technique == 1) {
						{
							double _setval = 2;
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.furamingogan_technique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Selected: Furamingogan Jump"), (true));
						}
					} else if (NarutoShippudenModVariables.get(entity).furamingogan_technique == 2) {
						{
							double _setval = 0;
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.furamingogan_technique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Selected: Furamingogan Secret Ritual "), (true));
						}
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).TheSirMarcus == false) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this release."), (true));
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
			IWorld world = (IWorld) dependencies.get("world");
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).isshikidojutsu == false) {
				new Object() {
					private int ticks = 0;
					private float waitTicks;
					private IWorld world;

					public void start(IWorld world, int waitTicks) {
						this.waitTicks = waitTicks;
						MinecraftForge.EVENT_BUS.register(this);
						this.world = world;
					}

					@SubscribeEvent
					public void tick(TickEvent.ServerTickEvent event) {
						if (event.phase == TickEvent.Phase.END) {
							this.ticks += 1;
							if (this.ticks >= this.waitTicks)
								run();
						}
					}

					private void run() {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You've awakened Isshiki Dojutsu!"), (false));
						}
						{
							boolean _setval = (true);
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.isshikidojutsu = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof LivingEntity)
							((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.NAUSEA, (int) 200, (int) 4, (false), (false)));
						if (entity instanceof LivingEntity)
							((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.BLINDNESS, (int) 60, (int) 1, (false), (false)));
						{
							String _setval = "1x1";
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.dojutsuisshiki = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof PlayerEntity) {
							ItemStack _setstack = new ItemStack(IsshikiDojutsuReleaseItem.block);
							_setstack.setCount((int) 1);
							ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
						}
						MinecraftForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 200);
			} else if (NarutoShippudenModVariables.get(entity).isshikidojutsu == true) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You've already unlocked isshiki dojutsu."), (false));
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
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You've awakened Isshiki Dojutsu!"), (false));
			}
			{
				boolean _setval = (true);
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.isshikidojutsu = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.NAUSEA, (int) 200, (int) 4, (false), (false)));
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.BLINDNESS, (int) 60, (int) 1, (false), (false)));
			{
				String _setval = "1x1";
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.dojutsuisshiki = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof PlayerEntity) {
				ItemStack _setstack = new ItemStack(IsshikiDojutsuReleaseItem.block);
				_setstack.setCount((int) 1);
				ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
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
					if (entity instanceof PlayerEntity) {
						ItemStack _setstack = new ItemStack(IsshikiDojutsuReleaseTechniqueItem.block);
						_setstack.setCount((int) 1);
						ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
					}
					{
						double _setval = 1;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.isshikidojutsulearn = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 25);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("-25 JP"), (false));
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).isshikidojutsurelease + 1);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.isshikidojutsurelease = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 24) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough JP"), (false));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).isshikidojutsurelease == 1) {
				if (NarutoShippudenModVariables.get(entity).jp >= 40) {
					{
						double _setval = 2;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.isshikidojutsulearn = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 40);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).isshikidojutsurelease + 1);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.isshikidojutsurelease = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("-40 JP"), (false));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 39) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough JP"), (false));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).isshikidojutsurelease == 2) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Wait For Newer Updates"), (false));
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
			if (entity.isSneaking()) {
				if (NarutoShippudenModVariables.get(entity).sukunahikonasize == 0.1) {
					{
						double _setval = 0.2;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.sukunahikonasize = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Size: 0.2"), (true));
					}
				} else if (NarutoShippudenModVariables.get(entity).sukunahikonasize == 0.2) {
					{
						double _setval = 0.3;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.sukunahikonasize = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Size: 0.3"), (true));
					}
				} else if (NarutoShippudenModVariables.get(entity).sukunahikonasize == 0.3) {
					{
						double _setval = 0.4;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.sukunahikonasize = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Size: 0.4"), (true));
					}
				} else if (NarutoShippudenModVariables.get(entity).sukunahikonasize == 0.4) {
					{
						double _setval = 0.5;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.sukunahikonasize = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Size: 0.5"), (true));
					}
				} else if (NarutoShippudenModVariables.get(entity).sukunahikonasize == 0.5) {
					{
						double _setval = 0.6;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.sukunahikonasize = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Size: 0.6"), (true));
					}
				} else if (NarutoShippudenModVariables.get(entity).sukunahikonasize == 0.6) {
					{
						double _setval = 0.7;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.sukunahikonasize = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Size: 0.7"), (true));
					}
				} else if (NarutoShippudenModVariables.get(entity).sukunahikonasize == 0.7) {
					{
						double _setval = 0.8;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.sukunahikonasize = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Size: 0.8"), (true));
					}
				} else if (NarutoShippudenModVariables.get(entity).sukunahikonasize == 0.8) {
					{
						double _setval = 0.9;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.sukunahikonasize = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Size: 0.9"), (true));
					}
				} else if (NarutoShippudenModVariables.get(entity).sukunahikonasize == 0.9) {
					{
						double _setval = 1;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.sukunahikonasize = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Size: 1"), (true));
					}
				} else if (NarutoShippudenModVariables.get(entity).sukunahikonasize == 1) {
					{
						double _setval = 0.1;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.sukunahikonasize = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Size: 0.1"), (true));
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
			IWorld world = (IWorld) dependencies.get("world");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			Entity entity = (Entity) dependencies.get("entity");
			{
				if (NarutoShippudenModVariables.get(entity).isshikidojutsu == true) {
					if (NarutoShippudenModVariables.get(entity).isshikidojutsuactivate == true) {
						if (!entity.isSneaking()) {
							if (NarutoShippudenModVariables.get(entity).isshikidojutsutechnique == 0) {
								if (NarutoShippudenModVariables.get(entity).isshikidojutsulearn >= 1) {
									if (NarutoShippudenModVariables.get(entity).ninjutsu >= 25) {
										if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 500) {
											{
												Entity _ent = entity;
												if (!_ent.world.isRemote && _ent.world.getServer() != null) {
													EntityScale.set(_ent, EntityScale.BASE, NarutoShippudenModVariables.get(entity).sukunahikonasize);
												}
											}
											{
												double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 500);
												entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
														.ifPresent(capability -> {
															capability.ChakraAmount = _setval;
															capability.syncPlayerVariables(entity);
														});
											}
										} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 499) {
											if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
												((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
											}
										}
									} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 24) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu"), (false));
										}
									}
								} else if (!(NarutoShippudenModVariables.get(entity).isshikidojutsulearn >= 1)) {
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this technique."),
												(false));
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).isshikidojutsutechnique == 1) {
								if (NarutoShippudenModVariables.get(entity).isshikidojutsulearn >= 2) {
									if (NarutoShippudenModVariables.get(entity).ninjutsu >= 35) {
										if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 1000) {
											if (world instanceof ServerWorld) {
												Entity entityToSpawn = new DisruptionCubeEntity.CustomEntity(DisruptionCubeEntity.entity, (World) world);
												entityToSpawn.setLocationAndAngles(
														(entity.world
																.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * 20,
																				entity.getLook(1f).y * 20, entity.getLook(1f).z * 20),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																.getPos().getX()),
														(y + 20),
														(entity.world
																.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * 20,
																				entity.getLook(1f).y * 20, entity.getLook(1f).z * 20),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																.getPos().getZ()),
														(float) 0, (float) 0);
												entityToSpawn.setRenderYawOffset((float) 0);
												entityToSpawn.setRotationYawHead((float) 0);
												entityToSpawn.setMotion(0, 0, 0);
												if (entityToSpawn instanceof MobEntity)
													((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
															world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
															(ILivingEntityData) null, (CompoundNBT) null);
												world.addEntity(entityToSpawn);
											}
											{
												double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 1000);
												entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
														.ifPresent(capability -> {
															capability.ChakraAmount = _setval;
															capability.syncPlayerVariables(entity);
														});
											}
										} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 999) {
											if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
												((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
											}
										}
									} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 34) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu"), (false));
										}
									}
								} else if (!(NarutoShippudenModVariables.get(entity).isshikidojutsulearn >= 2)) {
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this technique."),
												(false));
									}
								}
							}
							if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
								if (entity instanceof PlayerEntity)
									((PlayerEntity) entity).getCooldownTracker().setCooldown(IsshikiDojutsuReleaseTechniqueItem.block, (int) 200);
							} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
								if (entity instanceof PlayerEntity)
									((PlayerEntity) entity).getCooldownTracker().setCooldown(IsshikiDojutsuReleaseTechniqueItem.block, (int) 160);
							} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
								if (entity instanceof PlayerEntity)
									((PlayerEntity) entity).getCooldownTracker().setCooldown(IsshikiDojutsuReleaseTechniqueItem.block, (int) 120);
							} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
								if (entity instanceof PlayerEntity)
									((PlayerEntity) entity).getCooldownTracker().setCooldown(IsshikiDojutsuReleaseTechniqueItem.block, (int) 80);
							} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
								if (entity instanceof PlayerEntity)
									((PlayerEntity) entity).getCooldownTracker().setCooldown(IsshikiDojutsuReleaseTechniqueItem.block, (int) 40);
							}
						} else if (entity.isSneaking()) {
							if (NarutoShippudenModVariables.get(entity).isshikidojutsutechnique == 0) {
								{
									double _setval = 1;
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.isshikidojutsutechnique = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Selected: Disruption Cube"), (true));
								}
							} else if (NarutoShippudenModVariables.get(entity).isshikidojutsutechnique == 1) {
								{
									double _setval = 0;
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.isshikidojutsutechnique = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Selected: Sukunahikona"), (true));
								}
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).isshikidojutsuactivate == false) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Activate Isshiki Dojutsu"), (false));
						}
					}
				} else if (NarutoShippudenModVariables.get(entity).isshikidojutsu == false) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this release."), (true));
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
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You feel flow of emotions as you awaken the Mangekyou Sharingan!"),
						(false));
			}
			{
				double _setval = (MathHelper.nextInt(new Random(), 1000, 1500));
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Mangekyou_Sharingan_Technique_Use_Max = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				boolean _setval = (true);
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.MangekyouSharinganKakashi = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				boolean _setval = (true);
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Mangekyou_Sharingan = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.NAUSEA, (int) 200, (int) 4, (false), (false)));
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.BLINDNESS, (int) 60, (int) 1, (false), (false)));
			{
				String _setval = "1x1";
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.dojutsums = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof PlayerEntity) {
				ItemStack _setstack = new ItemStack(MangekyouSharinganKakashiReleaseItem.block);
				_setstack.setCount((int) 1);
				ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
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
			IWorld world = (IWorld) dependencies.get("world");
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).SharinganKakashi == false) {
				new Object() {
					private int ticks = 0;
					private float waitTicks;
					private IWorld world;

					public void start(IWorld world, int waitTicks) {
						this.waitTicks = waitTicks;
						MinecraftForge.EVENT_BUS.register(this);
						this.world = world;
					}

					@SubscribeEvent
					public void tick(TickEvent.ServerTickEvent event) {
						if (event.phase == TickEvent.Phase.END) {
							this.ticks += 1;
							if (this.ticks >= this.waitTicks)
								run();
						}
					}

					private void run() {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(
									new StringTextComponent("You suddenly feel a surge of power through you as you awaken the Sharingan!"), (false));
						}
						{
							boolean _setval = (true);
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.SharinganKakashi = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof LivingEntity)
							((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.NAUSEA, (int) 200, (int) 4, (false), (false)));
						if (entity instanceof LivingEntity)
							((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.BLINDNESS, (int) 60, (int) 1, (false), (false)));
						{
							String _setval = "1x1";
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.dojutsusharingan = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof PlayerEntity) {
							ItemStack _setstack = new ItemStack(SharinganReleaseItem.block);
							_setstack.setCount((int) 1);
							ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
						}
						MinecraftForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 200);
			} else if (NarutoShippudenModVariables.get(entity).SharinganKakashi == true) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You've already unlocked sharingan."), (false));
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
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(
						new StringTextComponent("You suddenly feel a surge of power through you as you awaken the Sharingan!"), (false));
			}
			{
				boolean _setval = (true);
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.SharinganKakashi = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.NAUSEA, (int) 200, (int) 4, (false), (false)));
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.BLINDNESS, (int) 60, (int) 1, (false), (false)));
			{
				String _setval = "1x1";
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.dojutsusharingan = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof PlayerEntity) {
				ItemStack _setstack = new ItemStack(SharinganReleaseItem.block);
				_setstack.setCount((int) 1);
				ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
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
			IWorld world = (IWorld) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			Entity entity = (Entity) dependencies.get("entity");
			double notair = 0;
			notair = 64;
			for (int index0 = 0; index0 < (int) (9); index0++) {
				if (world.isAirBlock(new BlockPos(x, notair, z))) {
					{
						Entity _ent = entity;
						_ent.setPositionAndUpdate(x, notair, z);
						if (_ent instanceof ServerPlayerEntity) {
							((ServerPlayerEntity) _ent).connection.setPlayerLocation(x, notair, z, _ent.rotationYaw, _ent.rotationPitch,
									Collections.emptySet());
						}
					}
				} else if (!world.isAirBlock(new BlockPos(x, notair, z))) {
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
			IWorld world = (IWorld) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			if (world.isAirBlock(new BlockPos(x, 64, z - 1)) && world.isAirBlock(new BlockPos(x + 1, 64, z - 1))
					&& world.isAirBlock(new BlockPos(x + 2, 64, z - 1)) && world.isAirBlock(new BlockPos(x - 1, 64, z))
					&& world.isAirBlock(new BlockPos(x - 1, 64, z + 1)) && world.isAirBlock(new BlockPos(x - 1, 64, z + 2))
					&& world.isAirBlock(new BlockPos(x, 64, z + 3)) && world.isAirBlock(new BlockPos(x + 1, 64, z + 3))
					&& world.isAirBlock(new BlockPos(x + 2, 64, z + 3)) && world.isAirBlock(new BlockPos(x + 3, 64, z))
					&& world.isAirBlock(new BlockPos(x + 3, 64, z + 1)) && world.isAirBlock(new BlockPos(x + 3, 64, z + 2))) {
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
			IWorld world = (IWorld) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			if (world.isAirBlock(new BlockPos(x, 64, z - 1)) && world.isAirBlock(new BlockPos(x + 1, 64, z - 1))
					&& world.isAirBlock(new BlockPos(x + 2, 64, z - 1)) && world.isAirBlock(new BlockPos(x + 3, 64, z - 1))
					&& world.isAirBlock(new BlockPos(x - 1, 64, z)) && world.isAirBlock(new BlockPos(x - 1, 64, z + 1))
					&& world.isAirBlock(new BlockPos(x - 1, 64, z + 2)) && world.isAirBlock(new BlockPos(x - 1, 64, z + 3))
					&& world.isAirBlock(new BlockPos(x, 64, z + 3)) && world.isAirBlock(new BlockPos(x + 1, 64, z + 3))
					&& world.isAirBlock(new BlockPos(x + 2, 64, z + 3)) && world.isAirBlock(new BlockPos(x + 3, 64, z + 3))
					&& world.isAirBlock(new BlockPos(x + 3, 64, z)) && world.isAirBlock(new BlockPos(x + 3, 64, z + 1))
					&& world.isAirBlock(new BlockPos(x + 3, 64, z + 2)) && world.isAirBlock(new BlockPos(x + 3, 64, z + 3))) {
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
			IWorld world = (IWorld) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			if (world.isAirBlock(new BlockPos(x, 64, z - 1)) && world.isAirBlock(new BlockPos(x + 1, 64, z - 1))
					&& world.isAirBlock(new BlockPos(x + 2, 64, z - 1)) && world.isAirBlock(new BlockPos(x + 3, 64, z - 1))
					&& world.isAirBlock(new BlockPos(x + 4, 64, z - 1)) && world.isAirBlock(new BlockPos(x - 1, 64, z))
					&& world.isAirBlock(new BlockPos(x - 1, 64, z + 1)) && world.isAirBlock(new BlockPos(x - 1, 64, z + 2))
					&& world.isAirBlock(new BlockPos(x - 1, 64, z + 3)) && world.isAirBlock(new BlockPos(x - 1, 64, z + 4))
					&& world.isAirBlock(new BlockPos(x, 64, z + 3)) && world.isAirBlock(new BlockPos(x + 1, 64, z + 3))
					&& world.isAirBlock(new BlockPos(x + 2, 64, z + 3)) && world.isAirBlock(new BlockPos(x + 3, 64, z + 3))
					&& world.isAirBlock(new BlockPos(x + 4, 64, z + 3)) && world.isAirBlock(new BlockPos(x + 3, 64, z))
					&& world.isAirBlock(new BlockPos(x + 3, 64, z + 1)) && world.isAirBlock(new BlockPos(x + 3, 64, z + 2))
					&& world.isAirBlock(new BlockPos(x + 3, 64, z + 3)) && world.isAirBlock(new BlockPos(x + 3, 64, z + 4))) {
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
			IWorld world = (IWorld) dependencies.get("world");
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).ketsuryugan == false) {
				new Object() {
					private int ticks = 0;
					private float waitTicks;
					private IWorld world;

					public void start(IWorld world, int waitTicks) {
						this.waitTicks = waitTicks;
						MinecraftForge.EVENT_BUS.register(this);
						this.world = world;
					}

					@SubscribeEvent
					public void tick(TickEvent.ServerTickEvent event) {
						if (event.phase == TickEvent.Phase.END) {
							this.ticks += 1;
							if (this.ticks >= this.waitTicks)
								run();
						}
					}

					private void run() {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(
									new StringTextComponent(
											"You feel that the blood of the Chinoike clan flows in your veins, you have awakened the Ketsuryugan"),
									(false));
						}
						{
							String _setval = "1x1";
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.dojutsuketsuryugan = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof PlayerEntity) {
							ItemStack _setstack = new ItemStack(KetsuryuganReleaseItem.block);
							_setstack.setCount((int) 1);
							ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
						}
						{
							boolean _setval = (true);
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.ketsuryugan = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						MinecraftForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 200);
			} else if (NarutoShippudenModVariables.get(entity).ketsuryugan == true) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You've already unlocked ketsuryugan."), (false));
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
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(
						new StringTextComponent("You feel that the blood of the Chinoike clan flows in your veins, you have awakened the Ketsuryugan"),
						(false));
			}
			{
				String _setval = "1x1";
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.dojutsuketsuryugan = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof PlayerEntity) {
				ItemStack _setstack = new ItemStack(KetsuryuganReleaseItem.block);
				_setstack.setCount((int) 1);
				ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
			}
			{
				boolean _setval = (true);
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("A pitch black crow gave you a letter!"), (false));
			}
			if (entity instanceof PlayerEntity) {
				ItemStack _setstack = new ItemStack(LetterFromBrotherItem.block);
				_setstack.setCount((int) 1);
				ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
			}
			{
				boolean _setval = (true);
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
			random = (MathHelper.nextInt(new Random(), 1, 5));
			if (random == 1) {
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(MangekyouSharinganSasukeReleaseItem.block);
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
				{
					boolean _setval = (true);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.MangekyouSharinganSasuke = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (random == 2) {
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(MangekyouSharinganMadaraReleaseItem.block);
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
				{
					boolean _setval = (true);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.MangekyouSharinganMadara = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (random == 3) {
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(MangekyouSharinganItachiReleaseItem.block);
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
				{
					boolean _setval = (true);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.MangekyouSharinganItachi = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (random == 4) {
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(MangekyouSharinganShisuiReleaseItem.block);
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
				{
					boolean _setval = (true);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.MangekyouSharinganShisui = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (random == 5) {
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(MangekyouSharinganObitoReleaseItem.block);
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
				{
					boolean _setval = (true);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.MangekyouSharinganObito = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			{
				String _setval = "1x1";
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.dojutsums = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				boolean _setval = (true);
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.otsutsuki_mangekyou = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				boolean _setval = (true);
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Mangekyou_Sharingan = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You've awakened Mangekyou Sharingan!"), (false));
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
			if (!entity.isSneaking()) {
				if (NarutoShippudenModVariables.get(entity).MangekyouSharinganRelease == 0) {
					if (NarutoShippudenModVariables.get(entity).mangekyoushrainganitachiamaterasulearn == 0) {
						if (NarutoShippudenModVariables.get(entity).jp >= 10) {
							if (NarutoShippudenModVariables.get(entity).mangekyoushrainganitachisusanolearn == 0) {
								if (entity instanceof PlayerEntity) {
									ItemStack _setstack = new ItemStack(MangekyouSharinganItachiReleaseTechniqueItem.block);
									_setstack.setCount((int) 1);
									ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
								}
							}
							{
								double _setval = 1;
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.mangekyoushrainganitachiamaterasulearn = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = (NarutoShippudenModVariables.get(entity).jp - 10);
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.jp = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("-10 JP"), (false));
							}
						} else if (NarutoShippudenModVariables.get(entity).jp <= 9) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough JP"), (false));
							}
						}
					}
				} else if (NarutoShippudenModVariables.get(entity).MangekyouSharinganRelease == 1) {
					if (NarutoShippudenModVariables.get(entity).mangekyoushrainganitachisusanorelease == 0) {
						if (NarutoShippudenModVariables.get(entity).jp >= 10) {
							{
								double _setval = 1;
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.mangekyoushrainganitachisusanolearn = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = (NarutoShippudenModVariables.get(entity).jp - 10);
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.jp = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = (NarutoShippudenModVariables.get(entity).mangekyoushrainganitachisusanorelease + 1);
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.mangekyoushrainganitachisusanorelease = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("-10 JP"), (false));
							}
						} else if (NarutoShippudenModVariables.get(entity).jp <= 9) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough JP"), (false));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).mangekyoushrainganitachisusanorelease == 1) {
						if (NarutoShippudenModVariables.get(entity).jp >= 20) {
							{
								double _setval = 2;
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.mangekyoushrainganitachisusanolearn = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = (NarutoShippudenModVariables.get(entity).jp - 20);
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.jp = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = (NarutoShippudenModVariables.get(entity).mangekyoushrainganitachisusanorelease + 1);
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.mangekyoushrainganitachisusanorelease = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("-20 JP"), (false));
							}
						} else if (NarutoShippudenModVariables.get(entity).jp <= 19) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough JP"), (false));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).mangekyoushrainganitachisusanorelease == 2) {
						if (NarutoShippudenModVariables.get(entity).jp >= 30) {
							{
								double _setval = 3;
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.mangekyoushrainganitachisusanolearn = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = (NarutoShippudenModVariables.get(entity).jp - 30);
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.jp = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = (NarutoShippudenModVariables.get(entity).mangekyoushrainganitachisusanorelease + 1);
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.mangekyoushrainganitachisusanorelease = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("-30 JP"), (false));
							}
						} else if (NarutoShippudenModVariables.get(entity).jp <= 29) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough JP"), (false));
							}
						}
					}
				}
			} else if (entity.isSneaking()) {
				if (NarutoShippudenModVariables.get(entity).MangekyouSharinganRelease == 0) {
					{
						double _setval = 1;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.MangekyouSharinganRelease = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Selected: Susano"), (true));
					}
				} else if (NarutoShippudenModVariables.get(entity).MangekyouSharinganRelease == 1) {
					{
						double _setval = 0;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.MangekyouSharinganRelease = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Selected: Amaterasu"), (true));
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
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
				if (!entity.isSneaking()) {
					if (NarutoShippudenModVariables.get(entity).MangekyouSharinganActivate == true) {
						if (NarutoShippudenModVariables.get(entity).mangekyoushrainganitachiamaterasulearn >= 1) {
							if (NarutoShippudenModVariables.get(entity).ninjutsu >= 20) {
								if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 350) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new AmaterasuFlameItem.ArrowCustomEntity(AmaterasuFlameItem.arrow,
															world);

													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, 5, 1);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
									{
										double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 350);
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.ChakraAmount = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									{
										double _setval = (NarutoShippudenModVariables.get(entity).Mangekyou_Sharingan_Technique_Use + 1);
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.Mangekyou_Sharingan_Technique_Use = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 349) {
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 19) {
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu"), (false));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).mangekyoushrainganitachiamaterasulearn >= 1)) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this technique."), (false));
							}
						}
						if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
							if (entity instanceof PlayerEntity)
								((PlayerEntity) entity).getCooldownTracker().setCooldown(MangekyouSharinganItachiReleaseTechniqueItem.block, (int) 200);
						} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
							if (entity instanceof PlayerEntity)
								((PlayerEntity) entity).getCooldownTracker().setCooldown(MangekyouSharinganItachiReleaseTechniqueItem.block, (int) 160);
						} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
							if (entity instanceof PlayerEntity)
								((PlayerEntity) entity).getCooldownTracker().setCooldown(MangekyouSharinganItachiReleaseTechniqueItem.block, (int) 120);
						} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
							if (entity instanceof PlayerEntity)
								((PlayerEntity) entity).getCooldownTracker().setCooldown(MangekyouSharinganItachiReleaseTechniqueItem.block, (int) 80);
						} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
							if (entity instanceof PlayerEntity)
								((PlayerEntity) entity).getCooldownTracker().setCooldown(MangekyouSharinganItachiReleaseTechniqueItem.block, (int) 40);
						}
					} else if (NarutoShippudenModVariables.get(entity).MangekyouSharinganActivate == false) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Activate Mangekyou Sharingan"), (true));
						}
					}
				} else if (entity.isSneaking()) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Selected: Amaterasu"), (true));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).MangekyouSharinganItachi == false) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this release."), (true));
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
			if (!entity.isSneaking()) {
				if (NarutoShippudenModVariables.get(entity).mangekyousharingankakashikamuilearn == 0) {
					if (NarutoShippudenModVariables.get(entity).jp >= 35) {
						if (entity instanceof PlayerEntity) {
							ItemStack _setstack = new ItemStack(MangekyouSharinganKakashiReleaseTechniqueItem.block);
							_setstack.setCount((int) 1);
							ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
						}
						{
							double _setval = 1;
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.mangekyousharingankakashikamuilearn = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = (NarutoShippudenModVariables.get(entity).jp - 35);
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.jp = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("-35 JP"), (false));
						}
					} else if (NarutoShippudenModVariables.get(entity).jp <= 34) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough JP"), (false));
						}
					}
				}
			} else if (entity.isSneaking()) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Selected: Kamui"), (true));
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
			IWorld world = (IWorld) dependencies.get("world");
			Entity entity = (Entity) dependencies.get("entity");
			double distance = 0;
			boolean found = false;
			if (NarutoShippudenModVariables.get(entity).MangekyouSharinganKakashi == true) {
				if (!entity.isSneaking()) {
					if (NarutoShippudenModVariables.get(entity).MangekyouSharinganActivate == true) {
						if (NarutoShippudenModVariables.get(entity).mangekyousharingankakashikamuilearn >= 1) {
							if (NarutoShippudenModVariables.get(entity).ninjutsu >= 20) {
								if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 350) {
									distance = 10;
									for (int index0 = 0; index0 < (int) (10); index0++) {
										if (found == false) {
											if (((Entity) world.getEntitiesWithinAABB(LivingEntity.class,
													new AxisAlignedBB(
															(entity.world
																	.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																					entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																			RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																	.getPos().getX()) - (1 / 2d),
															(entity.world
																	.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																					entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																			RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																	.getPos().getY()) - (1 / 2d),
															(entity.world
																	.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																					entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																			RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																	.getPos().getZ()) - (1 / 2d),
															(entity.world
																	.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																					entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																			RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																	.getPos().getX()) + (1 / 2d),
															(entity.world
																	.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																					entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																			RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																	.getPos().getY()) + (1 / 2d),
															(entity.world
																	.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																					entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																			RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																	.getPos().getZ()) + (1 / 2d)),
													null).stream().sorted(new Object() {
														Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
															return Comparator
																	.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
														}
													}.compareDistOf(
															(entity.world
																	.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																					entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																			RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																	.getPos().getX()),
															(entity.world
																	.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																					entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																			RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																	.getPos().getY()),
															(entity.world
																	.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																					entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																			RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																	.getPos().getZ())))
													.findFirst().orElse(null)) != null) {
												if (!(((Entity) world.getEntitiesWithinAABB(LivingEntity.class, new AxisAlignedBB(
														(entity.world
																.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																				entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																.getPos().getX()) - (1 / 2d),
														(entity.world
																.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																				entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																.getPos().getY()) - (1 / 2d),
														(entity.world
																.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																				entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																.getPos().getZ()) - (1 / 2d),
														(entity.world
																.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																				entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																.getPos().getX()) + (1 / 2d),
														(entity.world
																.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																				entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																.getPos().getY()) + (1 / 2d),
														(entity.world
																.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																				entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																.getPos().getZ()) + (1 / 2d)),
														null).stream().sorted(new Object() {
															Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																return Comparator.comparing(
																		(Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
															}
														}.compareDistOf(
																(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																				entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																		.getPos().getX()),
																(entity.world
																		.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																				entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																						entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																				RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE,
																				entity))
																		.getPos().getY()),
																(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																				entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																		.getPos().getZ())))
														.findFirst().orElse(null)) == entity)) {
													if (!((((Entity) world.getEntitiesWithinAABB(LivingEntity.class, new AxisAlignedBB(
															(entity.world
																	.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																					entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																			RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																	.getPos().getX()) - (1 / 2d),
															(entity.world
																	.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																					entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																			RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																	.getPos().getY()) - (1 / 2d),
															(entity.world
																	.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																					entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																			RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																	.getPos().getZ()) - (1 / 2d),
															(entity.world
																	.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																					entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																			RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																	.getPos().getX()) + (1 / 2d),
															(entity.world
																	.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																					entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																			RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																	.getPos().getY()) + (1 / 2d),
															(entity.world
																	.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																					entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																			RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																	.getPos().getZ()) + (1 / 2d)),
															null).stream().sorted(new Object() {
																Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																	return Comparator.comparing(
																			(Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
																}
															}.compareDistOf(
																	(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																					entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																			RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																			.getPos().getX()),
																	(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																					entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																			RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																			.getPos().getY()),
																	(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																					entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																			RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																			.getPos().getZ())))
															.findFirst().orElse(null)).world.getDimensionKey()) == (RegistryKey.getOrCreateKey(
																	Registry.WORLD_KEY, new ResourceLocation("naruto_shippuden:kamui_dimension"))))) {
														{
															Entity _ent = ((Entity) world.getEntitiesWithinAABB(LivingEntity.class, new AxisAlignedBB(
																	(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																					entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																			RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																			.getPos().getX()) - (1 / 2d),
																	(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																					entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																			RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																			.getPos().getY()) - (1 / 2d),
																	(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																					entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																			RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																			.getPos().getZ()) - (1 / 2d),
																	(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																					entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																			RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																			.getPos().getX()) + (1 / 2d),
																	(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																					entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																			RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																			.getPos().getY()) + (1 / 2d),
																	(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																					entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																			RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																			.getPos().getZ()) + (1 / 2d)),
																	null).stream().sorted(new Object() {
																		Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																			return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd
																					.getDistanceSq(_x, _y, _z)));
																		}
																	}.compareDistOf(
																			(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																					entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																							entity.getLook(1f).y * distance,
																							entity.getLook(1f).z * distance),
																					RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE,
																					entity)).getPos().getX()),
																			(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																					entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																							entity.getLook(1f).y * distance,
																							entity.getLook(1f).z * distance),
																					RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE,
																					entity)).getPos().getY()),
																			(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																					entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																							entity.getLook(1f).y * distance,
																							entity.getLook(1f).z * distance),
																					RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE,
																					entity)).getPos().getZ())))
																	.findFirst().orElse(null));
															if (!_ent.world.isRemote && _ent.world.getServer() != null) {
																_ent.world.getServer().getCommandManager().handleCommand(
																		_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
																		"/execute in naruto_shippuden:kamui_dimension run tp ~ 71 ~");
															}
														}
													} else if ((((Entity) world.getEntitiesWithinAABB(LivingEntity.class, new AxisAlignedBB(
															(entity.world
																	.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																					entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																			RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																	.getPos().getX()) - (1 / 2d),
															(entity.world
																	.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																					entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																			RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																	.getPos().getY()) - (1 / 2d),
															(entity.world
																	.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																					entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																			RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																	.getPos().getZ()) - (1 / 2d),
															(entity.world
																	.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																					entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																			RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																	.getPos().getX()) + (1 / 2d),
															(entity.world
																	.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																					entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																			RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																	.getPos().getY()) + (1 / 2d),
															(entity.world
																	.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																					entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																			RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																	.getPos().getZ()) + (1 / 2d)),
															null).stream().sorted(new Object() {
																Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																	return Comparator.comparing(
																			(Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
																}
															}.compareDistOf(
																	(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																					entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																			RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																			.getPos().getX()),
																	(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																					entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																			RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																			.getPos().getY()),
																	(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																					entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																			RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																			.getPos().getZ())))
															.findFirst().orElse(null)).world.getDimensionKey()) == (RegistryKey.getOrCreateKey(
																	Registry.WORLD_KEY, new ResourceLocation("naruto_shippuden:kamui_dimension")))) {
														{
															Entity _ent = ((Entity) world.getEntitiesWithinAABB(LivingEntity.class, new AxisAlignedBB(
																	(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																					entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																			RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																			.getPos().getX()) - (1 / 2d),
																	(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																					entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																			RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																			.getPos().getY()) - (1 / 2d),
																	(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																					entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																			RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																			.getPos().getZ()) - (1 / 2d),
																	(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																					entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																			RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																			.getPos().getX()) + (1 / 2d),
																	(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																					entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																			RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																			.getPos().getY()) + (1 / 2d),
																	(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																					entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																			RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																			.getPos().getZ()) + (1 / 2d)),
																	null).stream().sorted(new Object() {
																		Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																			return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd
																					.getDistanceSq(_x, _y, _z)));
																		}
																	}.compareDistOf(
																			(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																					entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																							entity.getLook(1f).y * distance,
																							entity.getLook(1f).z * distance),
																					RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE,
																					entity)).getPos().getX()),
																			(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																					entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																							entity.getLook(1f).y * distance,
																							entity.getLook(1f).z * distance),
																					RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE,
																					entity)).getPos().getY()),
																			(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																					entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																							entity.getLook(1f).y * distance,
																							entity.getLook(1f).z * distance),
																					RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE,
																					entity)).getPos().getZ())))
																	.findFirst().orElse(null));
															if (!_ent.world.isRemote && _ent.world.getServer() != null) {
																_ent.world.getServer().getCommandManager().handleCommand(
																		_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
																		"/execute in minecraft:overworld run tp ~ ~ ~");
															}
														}
													}
													if (!(((Entity) world.getEntitiesWithinAABB(LivingEntity.class, new AxisAlignedBB(
															(entity.world
																	.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																					entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																			RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																	.getPos().getX()) - (1 / 2d),
															(entity.world
																	.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																					entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																			RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																	.getPos().getY()) - (1 / 2d),
															(entity.world
																	.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																					entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																			RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																	.getPos().getZ()) - (1 / 2d),
															(entity.world
																	.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																					entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																			RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																	.getPos().getX()) + (1 / 2d),
															(entity.world
																	.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																					entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																			RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																	.getPos().getY()) + (1 / 2d),
															(entity.world
																	.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																					entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																			RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																	.getPos().getZ()) + (1 / 2d)),
															null).stream().sorted(new Object() {
																Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																	return Comparator.comparing(
																			(Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
																}
															}.compareDistOf(
																	(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																					entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																			RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																			.getPos().getX()),
																	(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																					entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																			RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																			.getPos().getY()),
																	(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																					entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																			RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																			.getPos().getZ())))
															.findFirst().orElse(null)) instanceof PlayerEntity)) {
														if (!((Entity) world.getEntitiesWithinAABB(LivingEntity.class, new AxisAlignedBB(
																(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																				entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																		.getPos().getX()) - (1 / 2d),
																(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																				entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																		.getPos().getY()) - (1 / 2d),
																(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																				entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																		.getPos().getZ()) - (1 / 2d),
																(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																				entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																		.getPos().getX()) + (1 / 2d),
																(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																				entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																		.getPos().getY()) + (1 / 2d),
																(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																				entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																		.getPos().getZ()) + (1 / 2d)),
																null).stream().sorted(new Object() {
																	Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																		return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd
																				.getDistanceSq(_x, _y, _z)));
																	}
																}.compareDistOf(
																		(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																				entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																						entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																				RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE,
																				entity)).getPos().getX()),
																		(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																				entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																						entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																				RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE,
																				entity)).getPos().getY()),
																		(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																				entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																						entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																				RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE,
																				entity)).getPos().getZ())))
																.findFirst().orElse(null)).world.isRemote())
															((Entity) world
																	.getEntitiesWithinAABB(LivingEntity.class,
																			new AxisAlignedBB(
																					(entity.world.rayTraceBlocks(new RayTraceContext(
																							entity.getEyePosition(1f),
																							entity.getEyePosition(1f).add(
																									entity.getLook(1f).x * distance,
																									entity.getLook(1f).y * distance,
																									entity.getLook(1f).z * distance),
																							RayTraceContext.BlockMode.OUTLINE,
																							RayTraceContext.FluidMode.NONE, entity)).getPos().getX())
																							- (1 / 2d),
																					(entity.world.rayTraceBlocks(new RayTraceContext(
																							entity.getEyePosition(1f),
																							entity.getEyePosition(1f).add(
																									entity.getLook(1f).x * distance,
																									entity.getLook(1f).y * distance,
																									entity.getLook(1f).z * distance),
																							RayTraceContext.BlockMode.OUTLINE,
																							RayTraceContext.FluidMode.NONE, entity)).getPos().getY())
																							- (1 / 2d),
																					(entity.world.rayTraceBlocks(new RayTraceContext(
																							entity.getEyePosition(1f),
																							entity.getEyePosition(1f).add(
																									entity.getLook(1f).x * distance,
																									entity.getLook(1f).y * distance,
																									entity.getLook(1f).z * distance),
																							RayTraceContext.BlockMode.OUTLINE,
																							RayTraceContext.FluidMode.NONE, entity)).getPos().getZ())
																							- (1 / 2d),
																					(entity.world.rayTraceBlocks(new RayTraceContext(
																							entity.getEyePosition(1f),
																							entity.getEyePosition(1f).add(
																									entity.getLook(1f).x * distance,
																									entity.getLook(1f).y * distance,
																									entity.getLook(1f).z * distance),
																							RayTraceContext.BlockMode.OUTLINE,
																							RayTraceContext.FluidMode.NONE, entity)).getPos().getX())
																							+ (1 / 2d),
																					(entity.world.rayTraceBlocks(new RayTraceContext(
																							entity.getEyePosition(1f),
																							entity.getEyePosition(1f).add(
																									entity.getLook(1f).x * distance,
																									entity.getLook(1f).y * distance,
																									entity.getLook(1f).z * distance),
																							RayTraceContext.BlockMode.OUTLINE,
																							RayTraceContext.FluidMode.NONE, entity)).getPos().getY())
																							+ (1 / 2d),
																					(entity.world.rayTraceBlocks(new RayTraceContext(
																							entity.getEyePosition(1f),
																							entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																									entity.getLook(1f).y * distance,
																									entity.getLook(1f).z * distance),
																							RayTraceContext.BlockMode.OUTLINE,
																							RayTraceContext.FluidMode.NONE, entity)).getPos().getZ())
																							+ (1 / 2d)),
																			null)
																	.stream().sorted(new Object() {
																		Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																			return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd
																					.getDistanceSq(_x, _y, _z)));
																		}
																	}.compareDistOf(
																			(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																					entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																							entity.getLook(1f).y * distance,
																							entity.getLook(1f).z * distance),
																					RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE,
																					entity)).getPos().getX()),
																			(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																					entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																							entity.getLook(1f).y * distance,
																							entity.getLook(1f).z * distance),
																					RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE,
																					entity)).getPos().getY()),
																			(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																					entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																							entity.getLook(1f).y * distance,
																							entity.getLook(1f).z * distance),
																					RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE,
																					entity)).getPos().getZ())))
																	.findFirst().orElse(null)).remove();
													}
													found = (true);
												}
											} else if (!(((Entity) world.getEntitiesWithinAABB(LivingEntity.class,
													new AxisAlignedBB(
															(entity.world
																	.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																					entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																			RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																	.getPos().getX()) - (1 / 2d),
															(entity.world
																	.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																					entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																			RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																	.getPos().getY()) - (1 / 2d),
															(entity.world
																	.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																					entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																			RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																	.getPos().getZ()) - (1 / 2d),
															(entity.world
																	.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																					entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																			RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																	.getPos().getX()) + (1 / 2d),
															(entity.world
																	.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																					entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																			RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																	.getPos().getY()) + (1 / 2d),
															(entity.world
																	.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																					entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																			RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																	.getPos().getZ()) + (1 / 2d)),
													null).stream().sorted(new Object() {
														Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
															return Comparator
																	.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
														}
													}.compareDistOf(
															(entity.world
																	.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																					entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																			RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																	.getPos().getX()),
															(entity.world
																	.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																					entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																			RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																	.getPos().getY()),
															(entity.world
																	.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																					entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																			RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																	.getPos().getZ())))
													.findFirst().orElse(null)) != null)) {
												distance = (distance + 1);
											}
										}
									}
									if (found == true) {
										{
											double _setval = (NarutoShippudenModVariables.get(entity).Mangekyou_Sharingan_Technique_Use + 1);
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.Mangekyou_Sharingan_Technique_Use = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 350);
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
										world.addParticle(KamuiParticleParticle.particle,
												(entity.world
														.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																		entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
														.getPos().getX()),
												(entity.world
														.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																		entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
														.getPos().getY()),
												(entity.world
														.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																		entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
														.getPos().getZ()),
												0, 0, 0);
										if (world instanceof World && !world.isRemote()) {
											((World) world).playSound(null,
													new BlockPos(
															entity.world
																	.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																					entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																			RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																	.getPos().getX(),
															entity.world
																	.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																					entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																			RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																	.getPos().getY(),
															entity.world
																	.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																					entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																			RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																	.getPos().getZ()),
													(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
															.getValue(new ResourceLocation("naruto_shippuden:kamui")),
													SoundCategory.NEUTRAL, (float) 1, (float) 1);
										} else {
											((World) world).playSound(
													(entity.world
															.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																	entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																			entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																	RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
															.getPos().getX()),
													(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
															entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																	entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
															RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getY()),
													(entity.world
															.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																	entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																			entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																	RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
															.getPos().getZ()),
													(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
															.getValue(new ResourceLocation("naruto_shippuden:kamui")),
													SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 349) {
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 19) {
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu"), (false));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).mangekyousharingankakashikamuilearn >= 1)) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this technique."), (false));
							}
						}
						if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
							if (entity instanceof PlayerEntity)
								((PlayerEntity) entity).getCooldownTracker().setCooldown(MangekyouSharinganKakashiReleaseTechniqueItem.block, (int) 200);
						} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
							if (entity instanceof PlayerEntity)
								((PlayerEntity) entity).getCooldownTracker().setCooldown(MangekyouSharinganKakashiReleaseTechniqueItem.block, (int) 160);
						} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
							if (entity instanceof PlayerEntity)
								((PlayerEntity) entity).getCooldownTracker().setCooldown(MangekyouSharinganKakashiReleaseTechniqueItem.block, (int) 120);
						} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
							if (entity instanceof PlayerEntity)
								((PlayerEntity) entity).getCooldownTracker().setCooldown(MangekyouSharinganKakashiReleaseTechniqueItem.block, (int) 80);
						} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
							if (entity instanceof PlayerEntity)
								((PlayerEntity) entity).getCooldownTracker().setCooldown(MangekyouSharinganKakashiReleaseTechniqueItem.block, (int) 40);
						}
					} else if (NarutoShippudenModVariables.get(entity).MangekyouSharinganActivate == false) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Activate Mangekyou Sharingan"), (true));
						}
					}
				} else if (entity.isSneaking()) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Selected: Kamui Long-Range"), (true));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).MangekyouSharinganKakashi == false) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this release."), (true));
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
			if (!entity.isSneaking()) {
				if (NarutoShippudenModVariables.get(entity).mangekyousharinganmadarasusanorelease == 0) {
					if (NarutoShippudenModVariables.get(entity).jp >= 10) {
						{
							double _setval = 1;
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.mangekyousharinganmadarasusanolearn = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = (NarutoShippudenModVariables.get(entity).jp - 10);
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.jp = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = (NarutoShippudenModVariables.get(entity).mangekyousharinganmadarasusanorelease + 1);
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.mangekyousharinganmadarasusanorelease = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("-10 JP"), (false));
						}
					} else if (NarutoShippudenModVariables.get(entity).jp <= 9) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough JP"), (false));
						}
					}
				} else if (NarutoShippudenModVariables.get(entity).mangekyousharinganmadarasusanorelease == 1) {
					if (NarutoShippudenModVariables.get(entity).jp >= 20) {
						{
							double _setval = 2;
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.mangekyousharinganmadarasusanolearn = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = (NarutoShippudenModVariables.get(entity).jp - 20);
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.jp = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = (NarutoShippudenModVariables.get(entity).mangekyousharinganmadarasusanorelease + 1);
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.mangekyousharinganmadarasusanorelease = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("-20 JP"), (false));
						}
					} else if (NarutoShippudenModVariables.get(entity).jp <= 19) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough JP"), (false));
						}
					}
				} else if (NarutoShippudenModVariables.get(entity).mangekyousharinganmadarasusanorelease == 2) {
					if (NarutoShippudenModVariables.get(entity).jp >= 30) {
						{
							double _setval = 3;
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.mangekyousharinganmadarasusanolearn = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = (NarutoShippudenModVariables.get(entity).jp - 30);
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.jp = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = (NarutoShippudenModVariables.get(entity).mangekyousharinganmadarasusanorelease + 1);
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.mangekyousharinganmadarasusanorelease = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("-30 JP"), (false));
						}
					} else if (NarutoShippudenModVariables.get(entity).jp <= 29) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough JP"), (false));
						}
					}
				} else if (NarutoShippudenModVariables.get(entity).mangekyousharinganmadarasusanorelease == 3) {
					if (NarutoShippudenModVariables.get(entity).jp >= 40) {
						{
							double _setval = 4;
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.mangekyousharinganmadarasusanolearn = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = (NarutoShippudenModVariables.get(entity).jp - 40);
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.jp = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = (NarutoShippudenModVariables.get(entity).mangekyousharinganmadarasusanorelease + 1);
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.mangekyousharinganmadarasusanorelease = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("-40 JP"), (false));
						}
					} else if (NarutoShippudenModVariables.get(entity).jp <= 39) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough JP"), (false));
						}
					}
				}
			} else if (entity.isSneaking()) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Selected: Susano"), (true));
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
			IWorld world = (IWorld) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			Entity entity = (Entity) dependencies.get("entity");
			boolean found = false;
			double distance = 0;
			if (NarutoShippudenModVariables.get(entity).MangekyouSharinganObito == true) {
				if (!entity.isSneaking()) {
					if (NarutoShippudenModVariables.get(entity).MangekyouSharinganActivate == true) {
						if (NarutoShippudenModVariables.get(entity).mangekyousharinganobitokamuitechnique == 0) {
							if (NarutoShippudenModVariables.get(entity).mangekyousharinganobitokamuilearn >= 1) {
								if (NarutoShippudenModVariables.get(entity).ninjutsu >= 20) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 350) {
										if (!((entity.world.getDimensionKey()) == (RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
												new ResourceLocation("naruto_shippuden:kamui_dimension"))))) {
											{
												Entity _ent = entity;
												if (!_ent.world.isRemote && _ent.world.getServer() != null) {
													_ent.world.getServer().getCommandManager().handleCommand(
															_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
															"/execute in naruto_shippuden:kamui_dimension run tp ~ 71 ~");
												}
											}
										} else if ((entity.world.getDimensionKey()) == (RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
												new ResourceLocation("naruto_shippuden:kamui_dimension")))) {
											{
												Entity _ent = entity;
												if (!_ent.world.isRemote && _ent.world.getServer() != null) {
													_ent.world.getServer().getCommandManager().handleCommand(
															_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
															"/execute in minecraft:overworld run tp ~ ~ ~");
												}
											}
										}
										world.addParticle(KamuiParticleParticle.particle, x, y, z, 0, 0, 0);
										if (world instanceof World && !world.isRemote()) {
											((World) world).playSound(null, new BlockPos(x, y, z),
													(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
															.getValue(new ResourceLocation("naruto_shippuden:kamui")),
													SoundCategory.NEUTRAL, (float) 1, (float) 1);
										} else {
											((World) world).playSound(x, y, z,
													(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
															.getValue(new ResourceLocation("naruto_shippuden:kamui")),
													SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
										}
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 350);
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
										{
											double _setval = (NarutoShippudenModVariables.get(entity).Mangekyou_Sharingan_Technique_Use + 1);
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.Mangekyou_Sharingan_Technique_Use = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 349) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 19) {
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu"), (false));
									}
								}
							} else if (!(NarutoShippudenModVariables.get(entity).mangekyousharinganobitokamuilearn >= 1)) {
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this technique."), (false));
								}
							}
						} else if (NarutoShippudenModVariables.get(entity).mangekyousharinganobitokamuitechnique == 1) {
							if (NarutoShippudenModVariables.get(entity).mangekyousharinganobitokamuilearn >= 2) {
								if (NarutoShippudenModVariables.get(entity).ninjutsu >= 20) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 350) {
										distance = 1;
										for (int index0 = 0; index0 < (int) (5); index0++) {
											if (found == false) {
												if (((Entity) world.getEntitiesWithinAABB(LivingEntity.class, new AxisAlignedBB(
														(entity.world
																.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																				entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																.getPos().getX()) - (1 / 2d),
														(entity.world
																.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																				entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																.getPos().getY()) - (1 / 2d),
														(entity.world
																.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																				entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																.getPos().getZ()) - (1 / 2d),
														(entity.world
																.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																				entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																.getPos().getX()) + (1 / 2d),
														(entity.world
																.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																				entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																.getPos().getY()) + (1 / 2d),
														(entity.world
																.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																				entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																.getPos().getZ()) + (1 / 2d)),
														null).stream().sorted(new Object() {
															Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																return Comparator.comparing(
																		(Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
															}
														}.compareDistOf(
																(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																				entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																		.getPos().getX()),
																(entity.world
																		.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																				entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																						entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																				RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE,
																				entity))
																		.getPos().getY()),
																(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																				entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																		.getPos().getZ())))
														.findFirst().orElse(null)) != null) {
													if (!(((Entity) world.getEntitiesWithinAABB(LivingEntity.class, new AxisAlignedBB(
															(entity.world
																	.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																					entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																			RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																	.getPos().getX()) - (1 / 2d),
															(entity.world
																	.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																					entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																			RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																	.getPos().getY()) - (1 / 2d),
															(entity.world
																	.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																					entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																			RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																	.getPos().getZ()) - (1 / 2d),
															(entity.world
																	.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																					entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																			RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																	.getPos().getX()) + (1 / 2d),
															(entity.world
																	.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																					entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																			RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																	.getPos().getY()) + (1 / 2d),
															(entity.world
																	.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																					entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																			RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																	.getPos().getZ()) + (1 / 2d)),
															null).stream().sorted(new Object() {
																Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																	return Comparator.comparing(
																			(Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
																}
															}.compareDistOf(
																	(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																					entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																			RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																			.getPos().getX()),
																	(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																					entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																			RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																			.getPos().getY()),
																	(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																					entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																			RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																			.getPos().getZ())))
															.findFirst().orElse(null)) == entity)) {
														if (!((((Entity) world.getEntitiesWithinAABB(LivingEntity.class, new AxisAlignedBB(
																(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																				entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																		.getPos().getX()) - (1 / 2d),
																(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																				entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																		.getPos().getY()) - (1 / 2d),
																(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																				entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																		.getPos().getZ()) - (1 / 2d),
																(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																				entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																		.getPos().getX()) + (1 / 2d),
																(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																				entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																		.getPos().getY()) + (1 / 2d),
																(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																				entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																		.getPos().getZ()) + (1 / 2d)),
																null).stream().sorted(new Object() {
																	Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																		return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd
																				.getDistanceSq(_x, _y, _z)));
																	}
																}.compareDistOf(
																		(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																				entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																						entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																				RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE,
																				entity)).getPos().getX()),
																		(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																				entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																						entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																				RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE,
																				entity)).getPos().getY()),
																		(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																				entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																						entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																				RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE,
																				entity)).getPos().getZ())))
																.findFirst().orElse(null)).world.getDimensionKey()) == (RegistryKey.getOrCreateKey(
																		Registry.WORLD_KEY, new ResourceLocation("naruto_shippuden:kamui_dimension"))))) {
															{
																Entity _ent = ((Entity) world
																		.getEntitiesWithinAABB(LivingEntity.class,
																				new AxisAlignedBB(
																						(entity.world
																								.rayTraceBlocks(
																										new RayTraceContext(entity.getEyePosition(1f),
																												entity.getEyePosition(1f).add(
																														entity.getLook(1f).x * distance,
																														entity.getLook(1f).y * distance,
																														entity.getLook(1f).z * distance),
																												RayTraceContext.BlockMode.OUTLINE,
																												RayTraceContext.FluidMode.NONE, entity))
																								.getPos().getX()) - (1 / 2d),
																						(entity.world
																								.rayTraceBlocks(
																										new RayTraceContext(entity.getEyePosition(1f),
																												entity.getEyePosition(1f).add(
																														entity.getLook(1f).x * distance,
																														entity.getLook(1f).y * distance,
																														entity.getLook(1f).z * distance),
																												RayTraceContext.BlockMode.OUTLINE,
																												RayTraceContext.FluidMode.NONE, entity))
																								.getPos().getY()) - (1 / 2d),
																						(entity.world
																								.rayTraceBlocks(
																										new RayTraceContext(entity.getEyePosition(1f),
																												entity.getEyePosition(1f).add(
																														entity.getLook(1f).x * distance,
																														entity.getLook(1f).y * distance,
																														entity.getLook(1f).z * distance),
																												RayTraceContext.BlockMode.OUTLINE,
																												RayTraceContext.FluidMode.NONE, entity))
																								.getPos().getZ()) - (1 / 2d),
																						(entity.world
																								.rayTraceBlocks(
																										new RayTraceContext(entity.getEyePosition(1f),
																												entity.getEyePosition(1f).add(
																														entity.getLook(1f).x * distance,
																														entity.getLook(1f).y * distance,
																														entity.getLook(1f).z * distance),
																												RayTraceContext.BlockMode.OUTLINE,
																												RayTraceContext.FluidMode.NONE, entity))
																								.getPos().getX()) + (1 / 2d),
																						(entity.world
																								.rayTraceBlocks(
																										new RayTraceContext(entity.getEyePosition(1f),
																												entity.getEyePosition(1f).add(
																														entity.getLook(1f).x * distance,
																														entity.getLook(1f).y * distance,
																														entity.getLook(1f).z * distance),
																												RayTraceContext.BlockMode.OUTLINE,
																												RayTraceContext.FluidMode.NONE, entity))
																								.getPos().getY()) + (1 / 2d),
																						(entity.world
																								.rayTraceBlocks(
																										new RayTraceContext(entity.getEyePosition(1f),
																												entity.getEyePosition(1f).add(
																														entity.getLook(1f).x * distance,
																														entity.getLook(1f).y * distance,
																														entity.getLook(1f).z * distance),
																												RayTraceContext.BlockMode.OUTLINE,
																												RayTraceContext.FluidMode.NONE, entity))
																								.getPos().getZ()) + (1 / 2d)),
																				null)
																		.stream().sorted(new Object() {
																			Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																				return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd
																						.getDistanceSq(_x, _y, _z)));
																			}
																		}.compareDistOf(
																				(entity.world.rayTraceBlocks(new RayTraceContext(
																						entity.getEyePosition(1f),
																						entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																								entity.getLook(1f).y * distance,
																								entity.getLook(1f).z * distance),
																						RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE,
																						entity)).getPos().getX()),
																				(entity.world.rayTraceBlocks(new RayTraceContext(
																						entity.getEyePosition(1f),
																						entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																								entity.getLook(1f).y * distance,
																								entity.getLook(1f).z * distance),
																						RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE,
																						entity)).getPos().getY()),
																				(entity.world
																						.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																								entity.getEyePosition(1f).add(
																										entity.getLook(1f).x * distance,
																										entity.getLook(1f).y * distance,
																										entity.getLook(1f).z * distance),
																								RayTraceContext.BlockMode.OUTLINE,
																								RayTraceContext.FluidMode.NONE, entity))
																						.getPos().getZ())))
																		.findFirst().orElse(null));
																if (!_ent.world.isRemote && _ent.world.getServer() != null) {
																	_ent.world.getServer().getCommandManager().handleCommand(
																			_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
																			"/execute in naruto_shippuden:kamui_dimension run tp ~ ~ ~");
																}
															}
														} else if ((((Entity) world.getEntitiesWithinAABB(LivingEntity.class, new AxisAlignedBB(
																(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																				entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																		.getPos().getX()) - (1 / 2d),
																(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																				entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																		.getPos().getY()) - (1 / 2d),
																(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																				entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																		.getPos().getZ()) - (1 / 2d),
																(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																				entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																		.getPos().getX()) + (1 / 2d),
																(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																				entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																		.getPos().getY()) + (1 / 2d),
																(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																				entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																		.getPos().getZ()) + (1 / 2d)),
																null).stream().sorted(new Object() {
																	Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																		return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd
																				.getDistanceSq(_x, _y, _z)));
																	}
																}.compareDistOf(
																		(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																				entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																						entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																				RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE,
																				entity)).getPos().getX()),
																		(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																				entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																						entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																				RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE,
																				entity)).getPos().getY()),
																		(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																				entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																						entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																				RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE,
																				entity)).getPos().getZ())))
																.findFirst().orElse(null)).world.getDimensionKey()) == (RegistryKey.getOrCreateKey(
																		Registry.WORLD_KEY, new ResourceLocation("naruto_shippuden:kamui_dimension")))) {
															{
																Entity _ent = ((Entity) world
																		.getEntitiesWithinAABB(LivingEntity.class,
																				new AxisAlignedBB(
																						(entity.world
																								.rayTraceBlocks(
																										new RayTraceContext(entity.getEyePosition(1f),
																												entity.getEyePosition(1f).add(
																														entity.getLook(1f).x * distance,
																														entity.getLook(1f).y * distance,
																														entity.getLook(1f).z * distance),
																												RayTraceContext.BlockMode.OUTLINE,
																												RayTraceContext.FluidMode.NONE, entity))
																								.getPos().getX()) - (1 / 2d),
																						(entity.world
																								.rayTraceBlocks(
																										new RayTraceContext(entity.getEyePosition(1f),
																												entity.getEyePosition(1f).add(
																														entity.getLook(1f).x * distance,
																														entity.getLook(1f).y * distance,
																														entity.getLook(1f).z * distance),
																												RayTraceContext.BlockMode.OUTLINE,
																												RayTraceContext.FluidMode.NONE, entity))
																								.getPos().getY()) - (1 / 2d),
																						(entity.world
																								.rayTraceBlocks(
																										new RayTraceContext(entity.getEyePosition(1f),
																												entity.getEyePosition(1f).add(
																														entity.getLook(1f).x * distance,
																														entity.getLook(1f).y * distance,
																														entity.getLook(1f).z * distance),
																												RayTraceContext.BlockMode.OUTLINE,
																												RayTraceContext.FluidMode.NONE, entity))
																								.getPos().getZ()) - (1 / 2d),
																						(entity.world
																								.rayTraceBlocks(
																										new RayTraceContext(entity.getEyePosition(1f),
																												entity.getEyePosition(1f).add(
																														entity.getLook(1f).x * distance,
																														entity.getLook(1f).y * distance,
																														entity.getLook(1f).z * distance),
																												RayTraceContext.BlockMode.OUTLINE,
																												RayTraceContext.FluidMode.NONE, entity))
																								.getPos().getX()) + (1 / 2d),
																						(entity.world
																								.rayTraceBlocks(
																										new RayTraceContext(entity.getEyePosition(1f),
																												entity.getEyePosition(1f).add(
																														entity.getLook(1f).x * distance,
																														entity.getLook(1f).y * distance,
																														entity.getLook(1f).z * distance),
																												RayTraceContext.BlockMode.OUTLINE,
																												RayTraceContext.FluidMode.NONE, entity))
																								.getPos().getY()) + (1 / 2d),
																						(entity.world
																								.rayTraceBlocks(
																										new RayTraceContext(entity.getEyePosition(1f),
																												entity.getEyePosition(1f).add(
																														entity.getLook(1f).x * distance,
																														entity.getLook(1f).y * distance,
																														entity.getLook(1f).z * distance),
																												RayTraceContext.BlockMode.OUTLINE,
																												RayTraceContext.FluidMode.NONE, entity))
																								.getPos().getZ()) + (1 / 2d)),
																				null)
																		.stream().sorted(new Object() {
																			Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																				return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd
																						.getDistanceSq(_x, _y, _z)));
																			}
																		}.compareDistOf(
																				(entity.world.rayTraceBlocks(new RayTraceContext(
																						entity.getEyePosition(1f),
																						entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																								entity.getLook(1f).y * distance,
																								entity.getLook(1f).z * distance),
																						RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE,
																						entity)).getPos().getX()),
																				(entity.world.rayTraceBlocks(new RayTraceContext(
																						entity.getEyePosition(1f),
																						entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																								entity.getLook(1f).y * distance,
																								entity.getLook(1f).z * distance),
																						RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE,
																						entity)).getPos().getY()),
																				(entity.world
																						.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																								entity.getEyePosition(1f).add(
																										entity.getLook(1f).x * distance,
																										entity.getLook(1f).y * distance,
																										entity.getLook(1f).z * distance),
																								RayTraceContext.BlockMode.OUTLINE,
																								RayTraceContext.FluidMode.NONE, entity))
																						.getPos().getZ())))
																		.findFirst().orElse(null));
																if (!_ent.world.isRemote && _ent.world.getServer() != null) {
																	_ent.world.getServer().getCommandManager().handleCommand(
																			_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
																			"/execute in minecraft:overworld run tp ~ ~ ~");
																}
															}
														}
														if (!(((Entity) world.getEntitiesWithinAABB(LivingEntity.class, new AxisAlignedBB(
																(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																				entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																		.getPos().getX()) - (1 / 2d),
																(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																				entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																		.getPos().getY()) - (1 / 2d),
																(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																				entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																		.getPos().getZ()) - (1 / 2d),
																(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																				entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																		.getPos().getX()) + (1 / 2d),
																(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																				entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																		.getPos().getY()) + (1 / 2d),
																(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																				entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																		.getPos().getZ()) + (1 / 2d)),
																null).stream().sorted(new Object() {
																	Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																		return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd
																				.getDistanceSq(_x, _y, _z)));
																	}
																}.compareDistOf(
																		(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																				entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																						entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																				RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE,
																				entity)).getPos().getX()),
																		(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																				entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																						entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																				RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE,
																				entity)).getPos().getY()),
																		(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																				entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																						entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																				RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE,
																				entity)).getPos().getZ())))
																.findFirst().orElse(null)) instanceof PlayerEntity)) {
															if (!((Entity) world
																	.getEntitiesWithinAABB(LivingEntity.class,
																			new AxisAlignedBB(
																					(entity.world.rayTraceBlocks(new RayTraceContext(
																							entity.getEyePosition(1f),
																							entity.getEyePosition(1f).add(
																									entity.getLook(1f).x * distance,
																									entity.getLook(1f).y * distance,
																									entity.getLook(1f).z * distance),
																							RayTraceContext.BlockMode.OUTLINE,
																							RayTraceContext.FluidMode.NONE, entity)).getPos().getX())
																							- (1 / 2d),
																					(entity.world.rayTraceBlocks(new RayTraceContext(
																							entity.getEyePosition(1f),
																							entity.getEyePosition(1f).add(
																									entity.getLook(1f).x * distance,
																									entity.getLook(1f).y * distance,
																									entity.getLook(1f).z * distance),
																							RayTraceContext.BlockMode.OUTLINE,
																							RayTraceContext.FluidMode.NONE, entity)).getPos().getY())
																							- (1 / 2d),
																					(entity.world.rayTraceBlocks(new RayTraceContext(
																							entity.getEyePosition(1f),
																							entity.getEyePosition(1f).add(
																									entity.getLook(1f).x * distance,
																									entity.getLook(1f).y * distance,
																									entity.getLook(1f).z * distance),
																							RayTraceContext.BlockMode.OUTLINE,
																							RayTraceContext.FluidMode.NONE, entity)).getPos().getZ())
																							- (1 / 2d),
																					(entity.world.rayTraceBlocks(new RayTraceContext(
																							entity.getEyePosition(1f),
																							entity.getEyePosition(1f).add(
																									entity.getLook(1f).x * distance,
																									entity.getLook(1f).y * distance,
																									entity.getLook(1f).z * distance),
																							RayTraceContext.BlockMode.OUTLINE,
																							RayTraceContext.FluidMode.NONE, entity)).getPos().getX())
																							+ (1 / 2d),
																					(entity.world.rayTraceBlocks(new RayTraceContext(
																							entity.getEyePosition(1f),
																							entity.getEyePosition(1f).add(
																									entity.getLook(1f).x * distance,
																									entity.getLook(1f).y * distance,
																									entity.getLook(1f).z * distance),
																							RayTraceContext.BlockMode.OUTLINE,
																							RayTraceContext.FluidMode.NONE, entity)).getPos().getY())
																							+ (1 / 2d),
																					(entity.world.rayTraceBlocks(new RayTraceContext(
																							entity.getEyePosition(1f),
																							entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																									entity.getLook(1f).y * distance,
																									entity.getLook(1f).z * distance),
																							RayTraceContext.BlockMode.OUTLINE,
																							RayTraceContext.FluidMode.NONE, entity)).getPos().getZ())
																							+ (1 / 2d)),
																			null)
																	.stream().sorted(new Object() {
																		Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																			return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd
																					.getDistanceSq(_x, _y, _z)));
																		}
																	}.compareDistOf(
																			(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																					entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																							entity.getLook(1f).y * distance,
																							entity.getLook(1f).z * distance),
																					RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE,
																					entity)).getPos().getX()),
																			(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																					entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																							entity.getLook(1f).y * distance,
																							entity.getLook(1f).z * distance),
																					RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE,
																					entity)).getPos().getY()),
																			(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																					entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																							entity.getLook(1f).y * distance,
																							entity.getLook(1f).z * distance),
																					RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE,
																					entity)).getPos().getZ())))
																	.findFirst().orElse(null)).world.isRemote())
																((Entity) world
																		.getEntitiesWithinAABB(LivingEntity.class,
																				new AxisAlignedBB(
																						(entity.world
																								.rayTraceBlocks(
																										new RayTraceContext(entity.getEyePosition(1f),
																												entity.getEyePosition(1f).add(
																														entity.getLook(1f).x * distance,
																														entity.getLook(1f).y * distance,
																														entity.getLook(1f).z * distance),
																												RayTraceContext.BlockMode.OUTLINE,
																												RayTraceContext.FluidMode.NONE, entity))
																								.getPos().getX()) - (1 / 2d),
																						(entity.world
																								.rayTraceBlocks(
																										new RayTraceContext(entity.getEyePosition(1f),
																												entity.getEyePosition(1f).add(
																														entity.getLook(1f).x * distance,
																														entity.getLook(1f).y * distance,
																														entity.getLook(1f).z * distance),
																												RayTraceContext.BlockMode.OUTLINE,
																												RayTraceContext.FluidMode.NONE, entity))
																								.getPos().getY()) - (1 / 2d),
																						(entity.world
																								.rayTraceBlocks(
																										new RayTraceContext(entity.getEyePosition(1f),
																												entity.getEyePosition(1f).add(
																														entity.getLook(1f).x * distance,
																														entity.getLook(1f).y * distance,
																														entity.getLook(1f).z * distance),
																												RayTraceContext.BlockMode.OUTLINE,
																												RayTraceContext.FluidMode.NONE, entity))
																								.getPos().getZ()) - (1 / 2d),
																						(entity.world
																								.rayTraceBlocks(
																										new RayTraceContext(entity.getEyePosition(1f),
																												entity.getEyePosition(1f).add(
																														entity.getLook(1f).x * distance,
																														entity.getLook(1f).y * distance,
																														entity.getLook(1f).z * distance),
																												RayTraceContext.BlockMode.OUTLINE,
																												RayTraceContext.FluidMode.NONE, entity))
																								.getPos().getX()) + (1 / 2d),
																						(entity.world
																								.rayTraceBlocks(
																										new RayTraceContext(entity.getEyePosition(1f),
																												entity.getEyePosition(1f).add(
																														entity.getLook(1f).x * distance,
																														entity.getLook(1f).y * distance,
																														entity.getLook(1f).z * distance),
																												RayTraceContext.BlockMode.OUTLINE,
																												RayTraceContext.FluidMode.NONE, entity))
																								.getPos().getY()) + (1 / 2d),
																						(entity.world
																								.rayTraceBlocks(
																										new RayTraceContext(entity.getEyePosition(1f),
																												entity.getEyePosition(1f).add(
																														entity.getLook(1f).x * distance,
																														entity.getLook(1f).y * distance,
																														entity.getLook(1f).z * distance),
																												RayTraceContext.BlockMode.OUTLINE,
																												RayTraceContext.FluidMode.NONE, entity))
																								.getPos().getZ()) + (1 / 2d)),
																				null)
																		.stream().sorted(new Object() {
																			Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																				return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd
																						.getDistanceSq(_x, _y, _z)));
																			}
																		}.compareDistOf(
																				(entity.world.rayTraceBlocks(new RayTraceContext(
																						entity.getEyePosition(1f),
																						entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																								entity.getLook(1f).y * distance,
																								entity.getLook(1f).z * distance),
																						RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE,
																						entity)).getPos().getX()),
																				(entity.world.rayTraceBlocks(new RayTraceContext(
																						entity.getEyePosition(1f),
																						entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																								entity.getLook(1f).y * distance,
																								entity.getLook(1f).z * distance),
																						RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE,
																						entity)).getPos().getY()),
																				(entity.world
																						.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																								entity.getEyePosition(1f).add(
																										entity.getLook(1f).x * distance,
																										entity.getLook(1f).y * distance,
																										entity.getLook(1f).z * distance),
																								RayTraceContext.BlockMode.OUTLINE,
																								RayTraceContext.FluidMode.NONE, entity))
																						.getPos().getZ())))
																		.findFirst().orElse(null)).remove();
														}
														found = (true);
													}
												} else if (!(((Entity) world.getEntitiesWithinAABB(LivingEntity.class, new AxisAlignedBB(
														(entity.world
																.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																				entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																.getPos().getX()) - (1 / 2d),
														(entity.world
																.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																				entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																.getPos().getY()) - (1 / 2d),
														(entity.world
																.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																				entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																.getPos().getZ()) - (1 / 2d),
														(entity.world
																.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																				entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																.getPos().getX()) + (1 / 2d),
														(entity.world
																.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																				entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																.getPos().getY()) + (1 / 2d),
														(entity.world
																.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																				entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																.getPos().getZ()) + (1 / 2d)),
														null).stream().sorted(new Object() {
															Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																return Comparator.comparing(
																		(Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
															}
														}.compareDistOf(
																(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																				entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																		.getPos().getX()),
																(entity.world
																		.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																				entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																						entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																				RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE,
																				entity))
																		.getPos().getY()),
																(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																				entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																		.getPos().getZ())))
														.findFirst().orElse(null)) != null)) {
													distance = (distance + 1);
												}
											}
										}
										if (found == true) {
											{
												double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 350);
												entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
														.ifPresent(capability -> {
															capability.ChakraAmount = _setval;
															capability.syncPlayerVariables(entity);
														});
											}
											{
												double _setval = (NarutoShippudenModVariables.get(entity).Mangekyou_Sharingan_Technique_Use
														+ 1);
												entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
														.ifPresent(capability -> {
															capability.Mangekyou_Sharingan_Technique_Use = _setval;
															capability.syncPlayerVariables(entity);
														});
											}
											world.addParticle(KamuiParticleParticle.particle,
													(entity.world
															.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																	entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																			entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																	RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
															.getPos().getX()),
													(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
															entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																	entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
															RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getY()),
													(entity.world
															.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																	entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																			entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																	RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
															.getPos().getZ()),
													0, 0, 0);
											if (world instanceof World && !world.isRemote()) {
												((World) world).playSound(null, new BlockPos(
														entity.world
																.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																				entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																.getPos().getX(),
														entity.world
																.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																				entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																.getPos().getY(),
														entity.world
																.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																				entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																.getPos().getZ()),
														(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
																.getValue(new ResourceLocation("naruto_shippuden:kamui")),
														SoundCategory.NEUTRAL, (float) 1, (float) 1);
											} else {
												((World) world).playSound(
														(entity.world
																.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																				entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																.getPos().getX()),
														(entity.world
																.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																				entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																.getPos().getY()),
														(entity.world
																.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																				entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																.getPos().getZ()),
														(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
																.getValue(new ResourceLocation("naruto_shippuden:kamui")),
														SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
											}
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 349) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 19) {
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu"), (false));
									}
								}
							} else if (!(NarutoShippudenModVariables.get(entity).mangekyousharinganobitokamuilearn >= 2)) {
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this technique."), (false));
								}
							}
						} else if (NarutoShippudenModVariables.get(entity).mangekyousharinganobitokamuitechnique == 2) {
							if (NarutoShippudenModVariables.get(entity).mangekyousharinganobitokamuilearn >= 3) {
								if (NarutoShippudenModVariables.get(entity).ninjutsu >= 30) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 500) {
										{
											boolean _setval = (true);
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.KamuiPhantomPhase = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
										entity.setInvulnerable((true));
										if (entity instanceof PlayerEntity) {
											((PlayerEntity) entity).abilities.isFlying = (true);
											((PlayerEntity) entity).sendPlayerAbilities();
										}
										new Object() {
											private int ticks = 0;
											private float waitTicks;
											private IWorld world;

											public void start(IWorld world, int waitTicks) {
												this.waitTicks = waitTicks;
												MinecraftForge.EVENT_BUS.register(this);
												this.world = world;
											}

											@SubscribeEvent
											public void tick(TickEvent.ServerTickEvent event) {
												if (event.phase == TickEvent.Phase.END) {
													this.ticks += 1;
													if (this.ticks >= this.waitTicks)
														run();
												}
											}

											private void run() {
												{
													boolean _setval = (false);
													entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
															.ifPresent(capability -> {
																capability.KamuiPhantomPhase = _setval;
																capability.syncPlayerVariables(entity);
															});
												}
												entity.setInvulnerable((false));
												if (entity instanceof PlayerEntity) {
													((PlayerEntity) entity).abilities.isFlying = (false);
													((PlayerEntity) entity).sendPlayerAbilities();
												}
												MinecraftForge.EVENT_BUS.unregister(this);
											}
										}.start(world, (int) 15);
										{
											double _setval = (NarutoShippudenModVariables.get(entity).Mangekyou_Sharingan_Technique_Use + 1);
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.Mangekyou_Sharingan_Technique_Use = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 500);
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 499) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 29) {
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu"), (false));
									}
								}
							} else if (!(NarutoShippudenModVariables.get(entity).mangekyousharinganobitokamuilearn >= 3)) {
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this technique."), (false));
								}
							}
						}
						if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
							if (entity instanceof PlayerEntity)
								((PlayerEntity) entity).getCooldownTracker().setCooldown(MangekyouSharinganObitoReleaseTechniqueItem.block, (int) 200);
						} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
							if (entity instanceof PlayerEntity)
								((PlayerEntity) entity).getCooldownTracker().setCooldown(MangekyouSharinganObitoReleaseTechniqueItem.block, (int) 160);
						} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
							if (entity instanceof PlayerEntity)
								((PlayerEntity) entity).getCooldownTracker().setCooldown(MangekyouSharinganObitoReleaseTechniqueItem.block, (int) 120);
						} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
							if (entity instanceof PlayerEntity)
								((PlayerEntity) entity).getCooldownTracker().setCooldown(MangekyouSharinganObitoReleaseTechniqueItem.block, (int) 80);
						} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
							if (entity instanceof PlayerEntity)
								((PlayerEntity) entity).getCooldownTracker().setCooldown(MangekyouSharinganObitoReleaseTechniqueItem.block, (int) 40);
						}
					} else if (NarutoShippudenModVariables.get(entity).MangekyouSharinganActivate == false) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Activate Mangekyou Sharingan"), (true));
						}
					}
				} else if (entity.isSneaking()) {
					if (NarutoShippudenModVariables.get(entity).mangekyousharinganobitokamuitechnique == 0) {
						{
							double _setval = 1;
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.mangekyousharinganobitokamuitechnique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Selected: Kamui Short-Range"), (true));
						}
					} else if (NarutoShippudenModVariables.get(entity).mangekyousharinganobitokamuitechnique == 1) {
						{
							double _setval = 2;
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.mangekyousharinganobitokamuitechnique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Selected: Kamui Phantom Phasing"), (true));
						}
					} else if (NarutoShippudenModVariables.get(entity).mangekyousharinganobitokamuitechnique == 2) {
						{
							double _setval = 0;
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.mangekyousharinganobitokamuitechnique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Selected: Kamui Self-Teleportation"), (true));
						}
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).MangekyouSharinganObito == false) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this release."), (true));
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
			if (!entity.isSneaking()) {
				if (NarutoShippudenModVariables.get(entity).MangekyouSharinganRelease == 0) {
					if (NarutoShippudenModVariables.get(entity).mangekyousharinganobitokamuirelease == 0) {
						if (NarutoShippudenModVariables.get(entity).jp >= 20) {
							if (NarutoShippudenModVariables.get(entity).mangekyousharinganobitosusanolearn == 0) {
								if (entity instanceof PlayerEntity) {
									ItemStack _setstack = new ItemStack(MangekyouSharinganObitoReleaseTechniqueItem.block);
									_setstack.setCount((int) 1);
									ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
								}
							}
							{
								double _setval = 1;
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.mangekyousharinganobitokamuilearn = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = (NarutoShippudenModVariables.get(entity).jp - 20);
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.jp = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = (NarutoShippudenModVariables.get(entity).mangekyousharinganobitokamuirelease + 1);
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.mangekyousharinganobitokamuirelease = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("-20 JP"), (false));
							}
						} else if (NarutoShippudenModVariables.get(entity).jp <= 19) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough JP"), (false));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).mangekyousharinganobitokamuirelease == 1) {
						if (NarutoShippudenModVariables.get(entity).jp >= 30) {
							{
								double _setval = 2;
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.mangekyousharinganobitokamuilearn = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = (NarutoShippudenModVariables.get(entity).jp - 15);
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.jp = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = (NarutoShippudenModVariables.get(entity).mangekyousharinganobitokamuirelease + 1);
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.mangekyousharinganobitokamuirelease = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("-30 JP"), (false));
							}
						} else if (NarutoShippudenModVariables.get(entity).jp <= 29) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough JP"), (false));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).mangekyousharinganobitokamuirelease == 2) {
						if (NarutoShippudenModVariables.get(entity).jp >= 35) {
							{
								double _setval = 3;
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.mangekyousharinganobitokamuilearn = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = (NarutoShippudenModVariables.get(entity).jp - 35);
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.jp = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = (NarutoShippudenModVariables.get(entity).mangekyousharinganobitokamuirelease + 1);
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.mangekyousharinganobitokamuirelease = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("-35 JP"), (false));
							}
						} else if (NarutoShippudenModVariables.get(entity).jp <= 34) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough JP"), (false));
							}
						}
					}
				} else if (NarutoShippudenModVariables.get(entity).MangekyouSharinganRelease == 1) {
					if (NarutoShippudenModVariables.get(entity).mangekyousharinganobitosusanorelease == 0) {
						if (NarutoShippudenModVariables.get(entity).jp >= 10) {
							{
								double _setval = 1;
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.mangekyousharinganobitosusanolearn = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = (NarutoShippudenModVariables.get(entity).jp - 10);
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.jp = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = (NarutoShippudenModVariables.get(entity).mangekyousharinganobitosusanorelease + 1);
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.mangekyousharinganobitosusanorelease = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("-10 JP"), (false));
							}
						} else if (NarutoShippudenModVariables.get(entity).jp <= 9) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough JP"), (false));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).mangekyousharinganobitosusanorelease == 1) {
						if (NarutoShippudenModVariables.get(entity).jp >= 20) {
							{
								double _setval = 2;
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.mangekyousharinganobitosusanolearn = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = (NarutoShippudenModVariables.get(entity).jp - 20);
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.jp = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = (NarutoShippudenModVariables.get(entity).mangekyousharinganobitosusanorelease + 1);
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.mangekyousharinganobitosusanorelease = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("-20 JP"), (false));
							}
						} else if (NarutoShippudenModVariables.get(entity).jp <= 19) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough JP"), (false));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).mangekyousharinganobitosusanorelease == 2) {
						if (NarutoShippudenModVariables.get(entity).jp >= 30) {
							{
								double _setval = 3;
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.mangekyousharinganobitosusanolearn = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = (NarutoShippudenModVariables.get(entity).jp - 30);
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.jp = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = (NarutoShippudenModVariables.get(entity).mangekyousharinganobitosusanorelease + 1);
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.mangekyousharinganobitosusanorelease = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("-30 JP"), (false));
							}
						} else if (NarutoShippudenModVariables.get(entity).jp <= 29) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough JP"), (false));
							}
						}
					}
				}
			} else if (entity.isSneaking()) {
				if (NarutoShippudenModVariables.get(entity).MangekyouSharinganRelease == 0) {
					{
						double _setval = 1;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.MangekyouSharinganRelease = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Selected: Susano"), (true));
					}
				} else if (NarutoShippudenModVariables.get(entity).MangekyouSharinganRelease == 1) {
					{
						double _setval = 0;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.MangekyouSharinganRelease = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Selected: Kamui"), (true));
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
			IWorld world = (IWorld) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).MangekyouSharinganSasuke == true) {
				if (!entity.isSneaking()) {
					if (NarutoShippudenModVariables.get(entity).MangekyouSharinganActivate == true) {
						if (NarutoShippudenModVariables.get(entity).mangekyousharingansasukeamaterasutechnique == 0) {
							if (NarutoShippudenModVariables.get(entity).mangekyousharingansasukeamaterasulearn >= 1) {
								if (NarutoShippudenModVariables.get(entity).ninjutsu >= 20) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 350) {
										{
											Entity _shootFrom = entity;
											World projectileLevel = _shootFrom.world;
											if (!projectileLevel.isRemote()) {
												ProjectileEntity _entityToSpawn = new Object() {
													public ProjectileEntity getArrow(World world, float damage, int knockback) {
														AbstractArrowEntity entityToSpawn = new AmaterasuFlameItem.ArrowCustomEntity(
																AmaterasuFlameItem.arrow, world);

														entityToSpawn.setDamage(damage);
														entityToSpawn.setKnockbackStrength(knockback);
														entityToSpawn.setSilent(true);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, 5, 1);
												_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
												_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1,
														0);
												projectileLevel.addEntity(_entityToSpawn);
											}
										}
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 350);
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
										{
											double _setval = (NarutoShippudenModVariables.get(entity).Mangekyou_Sharingan_Technique_Use + 1);
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.Mangekyou_Sharingan_Technique_Use = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 349) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 19) {
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu"), (false));
									}
								}
							} else if (!(NarutoShippudenModVariables.get(entity).mangekyousharingansasukeamaterasulearn >= 1)) {
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this technique."), (false));
								}
							}
						} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansasukeamaterasutechnique == 1) {
							if (NarutoShippudenModVariables.get(entity).mangekyousharingansasukeamaterasulearn >= 2) {
								if (NarutoShippudenModVariables.get(entity).ninjutsu >= 25) {
									if (NarutoShippudenModVariables.get(entity).Kagutsuchi == false) {
										{
											boolean _setval = (true);
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.Kagutsuchi = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
										{
											double _setval = (NarutoShippudenModVariables.get(entity).Mangekyou_Sharingan_Technique_Use + 1);
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.Mangekyou_Sharingan_Technique_Use = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).Kagutsuchi == true) {
										{
											boolean _setval = (false);
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.Kagutsuchi = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 24) {
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu"), (false));
									}
								}
							} else if (!(NarutoShippudenModVariables.get(entity).mangekyousharingansasukeamaterasulearn >= 2)) {
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this technique."), (false));
								}
							}
						} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansasukeamaterasutechnique == 2) {
							if (NarutoShippudenModVariables.get(entity).mangekyousharingansasukeamaterasulearn >= 3) {
								if (NarutoShippudenModVariables.get(entity).ninjutsu >= 30) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 500) {
										if (world instanceof ServerWorld) {
											((ServerWorld) world).spawnParticle(AmaterasuFireParticle.particle, x, (y + 1.5), z, (int) 100, 0, 0, 0, 0.1);
										}
										{
											List<Entity> _entfound = world.getEntitiesWithinAABB(Entity.class, new AxisAlignedBB(x - (10 / 2d),
													y - (10 / 2d), z - (10 / 2d), x + (10 / 2d), y + (10 / 2d), z + (10 / 2d)), null).stream()
													.sorted(new Object() {
														Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
															return Comparator
																	.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
														}
													}.compareDistOf(x, y, z)).collect(Collectors.toList());
											for (Entity entityiterator : _entfound) {
												if (entityiterator instanceof PlayerEntity) {
													if (NarutoShippudenModVariables.get(entityiterator).mangekyousharingansasukeamaterasulearn == 0) {
														if (NarutoShippudenModVariables.get(entityiterator).MangekyouSharinganSasuke == false
																&& NarutoShippudenModVariables.get(entityiterator).MangekyouSharinganItachi == false) {
															if (!(entity == entityiterator)) {
																entityiterator.getPersistentData().putBoolean("Amaterasu", (true));
																if (entityiterator instanceof LivingEntity)
																	((LivingEntity) entityiterator).addPotionEffect(
																			new EffectInstance(Effects.WITHER, (int) 999999, (int) 3, (false), (false)));
																entityiterator.attackEntityFrom(DamageSource.WITHER, (float) 5);
															}
														}
													}
												} else if (!(entityiterator instanceof PlayerEntity)) {
													if (entityiterator instanceof LivingEntity)
														((LivingEntity) entityiterator).addPotionEffect(
																new EffectInstance(Effects.WITHER, (int) 999999, (int) 3, (false), (false)));
													entityiterator.attackEntityFrom(DamageSource.WITHER, (float) 5);
												}
											}
										}
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 500);
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
										{
											double _setval = (NarutoShippudenModVariables.get(entity).Mangekyou_Sharingan_Technique_Use + 1);
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.Mangekyou_Sharingan_Technique_Use = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 499) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 29) {
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu"), (false));
									}
								}
							} else if (!(NarutoShippudenModVariables.get(entity).mangekyousharingansasukeamaterasulearn >= 3)) {
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this technique."), (false));
								}
							}
						} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansasukeamaterasutechnique == 3) {
							if (NarutoShippudenModVariables.get(entity).mangekyousharingansasukeamaterasulearn >= 4) {
								if (NarutoShippudenModVariables.get(entity).ninjutsu >= 35) {
									if (NarutoShippudenModVariables.get(entity).AmaterasuSusano == false) {
										{
											boolean _setval = (true);
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.AmaterasuSusano = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
										{
											double _setval = (NarutoShippudenModVariables.get(entity).Mangekyou_Sharingan_Technique_Use + 1);
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.Mangekyou_Sharingan_Technique_Use = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).AmaterasuSusano == true) {
										{
											boolean _setval = (false);
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.AmaterasuSusano = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 34) {
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu"), (false));
									}
								}
							} else if (!(NarutoShippudenModVariables.get(entity).mangekyousharingansasukeamaterasulearn >= 4)) {
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this technique."), (false));
								}
							}
						}
						if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
							if (entity instanceof PlayerEntity)
								((PlayerEntity) entity).getCooldownTracker().setCooldown(MangekyouSharinganSasukeReleaseTechniqueItem.block, (int) 200);
						} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
							if (entity instanceof PlayerEntity)
								((PlayerEntity) entity).getCooldownTracker().setCooldown(MangekyouSharinganSasukeReleaseTechniqueItem.block, (int) 160);
						} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
							if (entity instanceof PlayerEntity)
								((PlayerEntity) entity).getCooldownTracker().setCooldown(MangekyouSharinganSasukeReleaseTechniqueItem.block, (int) 120);
						} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
							if (entity instanceof PlayerEntity)
								((PlayerEntity) entity).getCooldownTracker().setCooldown(MangekyouSharinganSasukeReleaseTechniqueItem.block, (int) 80);
						} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
							if (entity instanceof PlayerEntity)
								((PlayerEntity) entity).getCooldownTracker().setCooldown(MangekyouSharinganSasukeReleaseTechniqueItem.block, (int) 40);
						}
					} else if (NarutoShippudenModVariables.get(entity).MangekyouSharinganActivate == false) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Activate Mangekyou Sharingan"), (true));
						}
					}
				} else if (entity.isSneaking()) {
					if (NarutoShippudenModVariables.get(entity).mangekyousharingansasukeamaterasutechnique == 0) {
						{
							double _setval = 1;
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.mangekyousharingansasukeamaterasutechnique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Selected: Blaze Release: Kagutsuchi"), (true));
						}
					} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansasukeamaterasutechnique == 1) {
						{
							double _setval = 2;
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.mangekyousharingansasukeamaterasutechnique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Selected: Blaze Release: Honoikazuchi"), (true));
						}
					} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansasukeamaterasutechnique == 2) {
						{
							double _setval = 3;
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.mangekyousharingansasukeamaterasutechnique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Selected: Amaterasu: Flame Wrapping Fire"), (true));
						}
					} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansasukeamaterasutechnique == 3) {
						{
							double _setval = 0;
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.mangekyousharingansasukeamaterasutechnique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Selected: Amaterasu"), (true));
						}
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).MangekyouSharinganSasuke == false) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this release."), (true));
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
			if (!entity.isSneaking()) {
				if (NarutoShippudenModVariables.get(entity).MangekyouSharinganRelease == 0) {
					if (NarutoShippudenModVariables.get(entity).mangekyousharingansasukeamaterasurelease == 0) {
						if (NarutoShippudenModVariables.get(entity).jp >= 10) {
							if (NarutoShippudenModVariables.get(entity).mangekyousharingansasukesusanolearn == 0) {
								if (entity instanceof PlayerEntity) {
									ItemStack _setstack = new ItemStack(MangekyouSharinganSasukeReleaseTechniqueItem.block);
									_setstack.setCount((int) 1);
									ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
								}
							}
							{
								double _setval = 1;
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.mangekyousharingansasukeamaterasulearn = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = (NarutoShippudenModVariables.get(entity).jp - 10);
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.jp = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = (NarutoShippudenModVariables.get(entity).mangekyousharingansasukeamaterasurelease + 1);
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.mangekyousharingansasukeamaterasurelease = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("-10 JP"), (false));
							}
						} else if (NarutoShippudenModVariables.get(entity).jp <= 9) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough JP"), (false));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansasukeamaterasurelease == 1) {
						if (NarutoShippudenModVariables.get(entity).jp >= 15) {
							{
								double _setval = 2;
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.mangekyousharingansasukeamaterasulearn = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = (NarutoShippudenModVariables.get(entity).jp - 15);
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.jp = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = (NarutoShippudenModVariables.get(entity).mangekyousharingansasukeamaterasurelease + 1);
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.mangekyousharingansasukeamaterasurelease = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("-15 JP"), (false));
							}
						} else if (NarutoShippudenModVariables.get(entity).jp <= 14) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough JP"), (false));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansasukeamaterasurelease == 2) {
						if (NarutoShippudenModVariables.get(entity).jp >= 20) {
							{
								double _setval = 3;
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.mangekyousharingansasukeamaterasulearn = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = (NarutoShippudenModVariables.get(entity).jp - 20);
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.jp = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = (NarutoShippudenModVariables.get(entity).mangekyousharingansasukeamaterasurelease + 1);
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.mangekyousharingansasukeamaterasurelease = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("-20 JP"), (false));
							}
						} else if (NarutoShippudenModVariables.get(entity).jp <= 19) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough JP"), (false));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansasukeamaterasurelease == 3) {
						if (NarutoShippudenModVariables.get(entity).jp >= 25) {
							{
								double _setval = 4;
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.mangekyousharingansasukeamaterasulearn = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = (NarutoShippudenModVariables.get(entity).jp - 25);
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.jp = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = (NarutoShippudenModVariables.get(entity).mangekyousharingansasukeamaterasurelease + 1);
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.mangekyousharingansasukeamaterasurelease = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("-25 JP"), (false));
							}
						} else if (NarutoShippudenModVariables.get(entity).jp <= 24) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough JP"), (false));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansasukeamaterasurelease == 4) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Wait For Newer Updates"), (false));
						}
					}
				} else if (NarutoShippudenModVariables.get(entity).MangekyouSharinganRelease == 1) {
					if (NarutoShippudenModVariables.get(entity).mangekyousharingansasukesusanorelease == 0) {
						if (NarutoShippudenModVariables.get(entity).jp >= 10) {
							{
								double _setval = 1;
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.mangekyousharingansasukesusanolearn = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = (NarutoShippudenModVariables.get(entity).jp - 10);
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.jp = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = (NarutoShippudenModVariables.get(entity).mangekyousharingansasukesusanorelease + 1);
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.mangekyousharingansasukesusanorelease = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("-10 JP"), (false));
							}
						} else if (NarutoShippudenModVariables.get(entity).jp <= 9) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough JP"), (false));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansasukesusanorelease == 1) {
						if (NarutoShippudenModVariables.get(entity).jp >= 20) {
							{
								double _setval = 2;
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.mangekyousharingansasukesusanolearn = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = (NarutoShippudenModVariables.get(entity).jp - 20);
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.jp = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = (NarutoShippudenModVariables.get(entity).mangekyousharingansasukesusanorelease + 1);
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.mangekyousharingansasukesusanorelease = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("-20 JP"), (false));
							}
						} else if (NarutoShippudenModVariables.get(entity).jp <= 19) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough JP"), (false));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansasukesusanorelease == 2) {
						if (NarutoShippudenModVariables.get(entity).jp >= 30) {
							{
								double _setval = 3;
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.mangekyousharingansasukesusanolearn = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = (NarutoShippudenModVariables.get(entity).jp - 30);
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.jp = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = (NarutoShippudenModVariables.get(entity).mangekyousharingansasukesusanorelease + 1);
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.mangekyousharingansasukesusanorelease = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("-30 JP"), (false));
							}
						} else if (NarutoShippudenModVariables.get(entity).jp <= 29) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough JP"), (false));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansasukesusanorelease == 3) {
						if (NarutoShippudenModVariables.get(entity).jp >= 40) {
							{
								double _setval = 4;
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.mangekyousharingansasukesusanolearn = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = (NarutoShippudenModVariables.get(entity).jp - 40);
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.jp = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = (NarutoShippudenModVariables.get(entity).mangekyousharingansasukesusanorelease + 1);
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.mangekyousharingansasukesusanorelease = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("-40 JP"), (false));
							}
						} else if (NarutoShippudenModVariables.get(entity).jp <= 39) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough JP"), (false));
							}
						}
					}
				}
			} else if (entity.isSneaking()) {
				if (NarutoShippudenModVariables.get(entity).MangekyouSharinganRelease == 0) {
					{
						double _setval = 1;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.MangekyouSharinganRelease = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Selected: Susano"), (true));
					}
				} else if (NarutoShippudenModVariables.get(entity).MangekyouSharinganRelease == 1) {
					{
						double _setval = 0;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.MangekyouSharinganRelease = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Selected: Amaterasu"), (true));
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
			if (!entity.isSneaking()) {
				if (NarutoShippudenModVariables.get(entity).mangekyousharinganshisuisusanorelease == 0) {
					if (NarutoShippudenModVariables.get(entity).jp >= 10) {
						{
							double _setval = 1;
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.mangekyousharinganshisuisusanolearn = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = (NarutoShippudenModVariables.get(entity).jp - 10);
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.jp = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = (NarutoShippudenModVariables.get(entity).mangekyousharinganshisuisusanorelease + 1);
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.mangekyousharinganshisuisusanorelease = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("-10 JP"), (false));
						}
					} else if (NarutoShippudenModVariables.get(entity).jp <= 9) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough JP"), (false));
						}
					}
				} else if (NarutoShippudenModVariables.get(entity).mangekyousharinganshisuisusanorelease == 1) {
					if (NarutoShippudenModVariables.get(entity).jp >= 20) {
						{
							double _setval = 2;
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.mangekyousharinganshisuisusanolearn = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = (NarutoShippudenModVariables.get(entity).jp - 20);
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.jp = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = (NarutoShippudenModVariables.get(entity).mangekyousharinganshisuisusanorelease + 1);
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.mangekyousharinganshisuisusanorelease = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("-20 JP"), (false));
						}
					} else if (NarutoShippudenModVariables.get(entity).jp <= 19) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough JP"), (false));
						}
					}
				} else if (NarutoShippudenModVariables.get(entity).mangekyousharinganshisuisusanorelease == 2) {
					if (NarutoShippudenModVariables.get(entity).jp >= 30) {
						{
							double _setval = 3;
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.mangekyousharinganshisuisusanolearn = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = (NarutoShippudenModVariables.get(entity).jp - 30);
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.jp = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = (NarutoShippudenModVariables.get(entity).mangekyousharinganshisuisusanorelease + 1);
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.mangekyousharinganshisuisusanorelease = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("-30 JP"), (false));
						}
					} else if (NarutoShippudenModVariables.get(entity).jp <= 29) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough JP"), (false));
						}
					}
				} else if (NarutoShippudenModVariables.get(entity).mangekyousharinganshisuisusanorelease == 3) {
					if (NarutoShippudenModVariables.get(entity).jp >= 40) {
						{
							double _setval = 4;
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.mangekyousharinganshisuisusanolearn = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = (NarutoShippudenModVariables.get(entity).jp - 40);
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.jp = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = (NarutoShippudenModVariables.get(entity).mangekyousharinganshisuisusanorelease + 1);
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.mangekyousharinganshisuisusanorelease = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("-40 JP"), (false));
						}
					} else if (NarutoShippudenModVariables.get(entity).jp <= 39) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough JP"), (false));
						}
					}
				}
			} else if (entity.isSneaking()) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Selected: Susano"), (true));
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
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You've awakened Rinnegan!"), (false));
					}
					{
						String _setval = "1x1";
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.dojutsurinnegan = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity) {
						ItemStack _setstack = new ItemStack(RinneganReleaseItem.block);
						_setstack.setCount((int) 1);
						ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
					}
					{
						boolean _setval = (true);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.rinnegan = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).otsutsukireleaselogic == true) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You've awakened Rinnegan!"), (false));
				}
				{
					String _setval = "1x1";
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.dojutsurinnegan = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(RinneganReleaseItem.block);
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
				{
					boolean _setval = (true);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
			IWorld world = (IWorld) dependencies.get("world");
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).sharingan == false) {
				new Object() {
					private int ticks = 0;
					private float waitTicks;
					private IWorld world;

					public void start(IWorld world, int waitTicks) {
						this.waitTicks = waitTicks;
						MinecraftForge.EVENT_BUS.register(this);
						this.world = world;
					}

					@SubscribeEvent
					public void tick(TickEvent.ServerTickEvent event) {
						if (event.phase == TickEvent.Phase.END) {
							this.ticks += 1;
							if (this.ticks >= this.waitTicks)
								run();
						}
					}

					private void run() {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(
									new StringTextComponent("You suddenly feel a surge of power through you as you awaken the Sharingan!"), (false));
						}
						{
							boolean _setval = (true);
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.sharingan = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof LivingEntity)
							((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.NAUSEA, (int) 200, (int) 4, (false), (false)));
						if (entity instanceof LivingEntity)
							((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.BLINDNESS, (int) 60, (int) 1, (false), (false)));
						{
							String _setval = "1x1";
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.dojutsusharingan = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof PlayerEntity) {
							ItemStack _setstack = new ItemStack(SharinganReleaseItem.block);
							_setstack.setCount((int) 1);
							ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
						}
						MinecraftForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 200);
			} else if (NarutoShippudenModVariables.get(entity).sharingan == true) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You've already unlocked sharingan."), (false));
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
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(
						new StringTextComponent("You suddenly feel a surge of power through you as you awaken the Sharingan!"), (false));
			}
			{
				boolean _setval = (true);
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.sharingan = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.NAUSEA, (int) 200, (int) 4, (false), (false)));
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.BLINDNESS, (int) 60, (int) 1, (false), (false)));
			{
				String _setval = "1x1";
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.dojutsusharingan = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof PlayerEntity) {
				ItemStack _setstack = new ItemStack(SharinganReleaseItem.block);
				_setstack.setCount((int) 1);
				ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
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
					if (entity instanceof PlayerEntity) {
						ItemStack _setstack = new ItemStack(SharinganReleaseTechniqueItem.block);
						_setstack.setCount((int) 1);
						ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
					}
					{
						double _setval = 1;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.sharinganlearn = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 15);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).sharinganrelease + 1);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.sharinganrelease = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("-15 JP"), (false));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 14) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough JP"), (false));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).sharinganrelease == 1) {
				if (NarutoShippudenModVariables.get(entity).jp >= 20) {
					{
						double _setval = 2;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.sharinganlearn = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 20);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).sharinganrelease + 1);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.sharinganrelease = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("-20 JP"), (false));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 19) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough JP"), (false));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).sharinganrelease == 2) {
				if (NarutoShippudenModVariables.get(entity).jp >= 25) {
					{
						double _setval = 3;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.sharinganlearn = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 25);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).sharinganrelease + 1);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.sharinganrelease = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("-25 JP"), (false));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 24) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough JP"), (false));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).sharinganrelease == 3) {
				if (NarutoShippudenModVariables.get(entity).jp >= 30) {
					{
						boolean _setval = (true);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.izanagi = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = 4;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.sharinganlearn = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 30);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).sharinganrelease + 1);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.sharinganrelease = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("-30 JP"), (false));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 29) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough JP"), (false));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).sharinganrelease == 4) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Wait For Newer Updates"), (false));
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
			IWorld world = (IWorld) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).sharingan == true) {
				if (!entity.isSneaking()) {
					if (NarutoShippudenModVariables.get(entity).sharinganactivate == true) {
						if (NarutoShippudenModVariables.get(entity).sharingantechnique == 0) {
							if (NarutoShippudenModVariables.get(entity).sharinganlearn >= 1) {
								if (NarutoShippudenModVariables.get(entity).ninjutsu >= 10) {
									if (NarutoShippudenModVariables.get(entity).genjutsu >= 5) {
										if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 200) {
											{
												Entity _shootFrom = entity;
												World projectileLevel = _shootFrom.world;
												if (!projectileLevel.isRemote()) {
													ProjectileEntity _entityToSpawn = new Object() {
														public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
															AbstractArrowEntity entityToSpawn = new CoercionSharinganItem.ArrowCustomEntity(
																	CoercionSharinganItem.arrow, world);
															entityToSpawn.setShooter(shooter);
															entityToSpawn.setDamage(damage);
															entityToSpawn.setKnockbackStrength(knockback);
															entityToSpawn.setSilent(true);

															return entityToSpawn;
														}
													}.getArrow(projectileLevel, entity, 12, 0);
													_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
													_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z,
															1, 0);
													projectileLevel.addEntity(_entityToSpawn);
												}
											}
											{
												double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 200);
												entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
														.ifPresent(capability -> {
															capability.ChakraAmount = _setval;
															capability.syncPlayerVariables(entity);
														});
											}
										} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 199) {
											if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
												((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Genjutsu"), (false));
											}
										}
									} else if (NarutoShippudenModVariables.get(entity).genjutsu <= 4) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu"), (false));
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 9) {
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu"), (false));
									}
								}
							} else if (!(NarutoShippudenModVariables.get(entity).sharinganlearn >= 1)) {
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this technique."), (false));
								}
							}
						} else if (NarutoShippudenModVariables.get(entity).sharingantechnique == 1) {
							if (NarutoShippudenModVariables.get(entity).sharinganlearn >= 2) {
								if (NarutoShippudenModVariables.get(entity).ninjutsu >= 20) {
									if (NarutoShippudenModVariables.get(entity).genjutsu >= 10) {
										if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 350) {
											if (world instanceof ServerWorld) {
												Entity entityToSpawn = new CrowEntity.CustomEntity(CrowEntity.entity, (World) world);
												entityToSpawn.setLocationAndAngles((x - 4), (y + 2), z,
														(float) (MathHelper.nextInt(new Random(), -179, 180)), (float) 0);
												entityToSpawn.setRenderYawOffset((float) (MathHelper.nextInt(new Random(), -179, 180)));
												entityToSpawn.setRotationYawHead((float) (MathHelper.nextInt(new Random(), -179, 180)));
												entityToSpawn.setMotion(0, 0, 0);
												if (entityToSpawn instanceof MobEntity)
													((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
															world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
															(ILivingEntityData) null, (CompoundNBT) null);
												world.addEntity(entityToSpawn);
											}
											if (world instanceof ServerWorld) {
												Entity entityToSpawn = new CrowEntity.CustomEntity(CrowEntity.entity, (World) world);
												entityToSpawn.setLocationAndAngles((x + 4), (y + 2), z,
														(float) (MathHelper.nextInt(new Random(), -179, 180)), (float) 0);
												entityToSpawn.setRenderYawOffset((float) (MathHelper.nextInt(new Random(), -179, 180)));
												entityToSpawn.setRotationYawHead((float) (MathHelper.nextInt(new Random(), -179, 180)));
												entityToSpawn.setMotion(0, 0, 0);
												if (entityToSpawn instanceof MobEntity)
													((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
															world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
															(ILivingEntityData) null, (CompoundNBT) null);
												world.addEntity(entityToSpawn);
											}
											if (world instanceof ServerWorld) {
												Entity entityToSpawn = new CrowEntity.CustomEntity(CrowEntity.entity, (World) world);
												entityToSpawn.setLocationAndAngles(x, (y + 2), (z + 4),
														(float) (MathHelper.nextInt(new Random(), -179, 180)), (float) 0);
												entityToSpawn.setRenderYawOffset((float) (MathHelper.nextInt(new Random(), -179, 180)));
												entityToSpawn.setRotationYawHead((float) (MathHelper.nextInt(new Random(), -179, 180)));
												entityToSpawn.setMotion(0, 0, 0);
												if (entityToSpawn instanceof MobEntity)
													((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
															world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
															(ILivingEntityData) null, (CompoundNBT) null);
												world.addEntity(entityToSpawn);
											}
											if (world instanceof ServerWorld) {
												Entity entityToSpawn = new CrowEntity.CustomEntity(CrowEntity.entity, (World) world);
												entityToSpawn.setLocationAndAngles(x, (y + 2), (z - 4),
														(float) (MathHelper.nextInt(new Random(), -179, 180)), (float) 0);
												entityToSpawn.setRenderYawOffset((float) (MathHelper.nextInt(new Random(), -179, 180)));
												entityToSpawn.setRotationYawHead((float) (MathHelper.nextInt(new Random(), -179, 180)));
												entityToSpawn.setMotion(0, 0, 0);
												if (entityToSpawn instanceof MobEntity)
													((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
															world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
															(ILivingEntityData) null, (CompoundNBT) null);
												world.addEntity(entityToSpawn);
											}
											if (world instanceof ServerWorld) {
												Entity entityToSpawn = new CrowEntity.CustomEntity(CrowEntity.entity, (World) world);
												entityToSpawn.setLocationAndAngles(x, (y + 2), (z - 3),
														(float) (MathHelper.nextInt(new Random(), -179, 180)), (float) 0);
												entityToSpawn.setRenderYawOffset((float) (MathHelper.nextInt(new Random(), -179, 180)));
												entityToSpawn.setRotationYawHead((float) (MathHelper.nextInt(new Random(), -179, 180)));
												entityToSpawn.setMotion(0, 0, 0);
												if (entityToSpawn instanceof MobEntity)
													((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
															world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
															(ILivingEntityData) null, (CompoundNBT) null);
												world.addEntity(entityToSpawn);
											}
											if (world instanceof ServerWorld) {
												Entity entityToSpawn = new CrowEntity.CustomEntity(CrowEntity.entity, (World) world);
												entityToSpawn.setLocationAndAngles(x, (y + 2), (z + 3),
														(float) (MathHelper.nextInt(new Random(), -179, 180)), (float) 0);
												entityToSpawn.setRenderYawOffset((float) (MathHelper.nextInt(new Random(), -179, 180)));
												entityToSpawn.setRotationYawHead((float) (MathHelper.nextInt(new Random(), -179, 180)));
												entityToSpawn.setMotion(0, 0, 0);
												if (entityToSpawn instanceof MobEntity)
													((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
															world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
															(ILivingEntityData) null, (CompoundNBT) null);
												world.addEntity(entityToSpawn);
											}
											if (world instanceof ServerWorld) {
												Entity entityToSpawn = new CrowEntity.CustomEntity(CrowEntity.entity, (World) world);
												entityToSpawn.setLocationAndAngles((x + 3), (y + 2), z,
														(float) (MathHelper.nextInt(new Random(), -179, 180)), (float) 0);
												entityToSpawn.setRenderYawOffset((float) (MathHelper.nextInt(new Random(), -179, 180)));
												entityToSpawn.setRotationYawHead((float) (MathHelper.nextInt(new Random(), -179, 180)));
												entityToSpawn.setMotion(0, 0, 0);
												if (entityToSpawn instanceof MobEntity)
													((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
															world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
															(ILivingEntityData) null, (CompoundNBT) null);
												world.addEntity(entityToSpawn);
											}
											if (world instanceof ServerWorld) {
												Entity entityToSpawn = new CrowEntity.CustomEntity(CrowEntity.entity, (World) world);
												entityToSpawn.setLocationAndAngles((x - 3), (y + 2), z,
														(float) (MathHelper.nextInt(new Random(), -179, 180)), (float) 0);
												entityToSpawn.setRenderYawOffset((float) (MathHelper.nextInt(new Random(), -179, 180)));
												entityToSpawn.setRotationYawHead((float) (MathHelper.nextInt(new Random(), -179, 180)));
												entityToSpawn.setMotion(0, 0, 0);
												if (entityToSpawn instanceof MobEntity)
													((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
															world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
															(ILivingEntityData) null, (CompoundNBT) null);
												world.addEntity(entityToSpawn);
											}
											if (world instanceof ServerWorld) {
												Entity entityToSpawn = new CrowEntity.CustomEntity(CrowEntity.entity, (World) world);
												entityToSpawn.setLocationAndAngles((x - 2), (y + 2), z,
														(float) (MathHelper.nextInt(new Random(), -179, 180)), (float) 0);
												entityToSpawn.setRenderYawOffset((float) (MathHelper.nextInt(new Random(), -179, 180)));
												entityToSpawn.setRotationYawHead((float) (MathHelper.nextInt(new Random(), -179, 180)));
												entityToSpawn.setMotion(0, 0, 0);
												if (entityToSpawn instanceof MobEntity)
													((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
															world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
															(ILivingEntityData) null, (CompoundNBT) null);
												world.addEntity(entityToSpawn);
											}
											if (world instanceof ServerWorld) {
												Entity entityToSpawn = new CrowEntity.CustomEntity(CrowEntity.entity, (World) world);
												entityToSpawn.setLocationAndAngles((x + 2), (y + 2), z,
														(float) (MathHelper.nextInt(new Random(), -179, 180)), (float) 0);
												entityToSpawn.setRenderYawOffset((float) (MathHelper.nextInt(new Random(), -179, 180)));
												entityToSpawn.setRotationYawHead((float) (MathHelper.nextInt(new Random(), -179, 180)));
												entityToSpawn.setMotion(0, 0, 0);
												if (entityToSpawn instanceof MobEntity)
													((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
															world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
															(ILivingEntityData) null, (CompoundNBT) null);
												world.addEntity(entityToSpawn);
											}
											if (world instanceof ServerWorld) {
												Entity entityToSpawn = new CrowEntity.CustomEntity(CrowEntity.entity, (World) world);
												entityToSpawn.setLocationAndAngles(x, (y + 2), (z + 2),
														(float) (MathHelper.nextInt(new Random(), -179, 180)), (float) 0);
												entityToSpawn.setRenderYawOffset((float) (MathHelper.nextInt(new Random(), -179, 180)));
												entityToSpawn.setRotationYawHead((float) (MathHelper.nextInt(new Random(), -179, 180)));
												entityToSpawn.setMotion(0, 0, 0);
												if (entityToSpawn instanceof MobEntity)
													((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
															world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
															(ILivingEntityData) null, (CompoundNBT) null);
												world.addEntity(entityToSpawn);
											}
											if (world instanceof ServerWorld) {
												Entity entityToSpawn = new CrowEntity.CustomEntity(CrowEntity.entity, (World) world);
												entityToSpawn.setLocationAndAngles(x, (y + 2), (z - 2),
														(float) (MathHelper.nextInt(new Random(), -179, 180)), (float) 0);
												entityToSpawn.setRenderYawOffset((float) (MathHelper.nextInt(new Random(), -179, 180)));
												entityToSpawn.setRotationYawHead((float) (MathHelper.nextInt(new Random(), -179, 180)));
												entityToSpawn.setMotion(0, 0, 0);
												if (entityToSpawn instanceof MobEntity)
													((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
															world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
															(ILivingEntityData) null, (CompoundNBT) null);
												world.addEntity(entityToSpawn);
											}
											if (world instanceof ServerWorld) {
												Entity entityToSpawn = new CrowEntity.CustomEntity(CrowEntity.entity, (World) world);
												entityToSpawn.setLocationAndAngles((x - 2), (y + 2), (z + 2),
														(float) (MathHelper.nextInt(new Random(), -179, 180)), (float) 0);
												entityToSpawn.setRenderYawOffset((float) (MathHelper.nextInt(new Random(), -179, 180)));
												entityToSpawn.setRotationYawHead((float) (MathHelper.nextInt(new Random(), -179, 180)));
												entityToSpawn.setMotion(0, 0, 0);
												if (entityToSpawn instanceof MobEntity)
													((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
															world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
															(ILivingEntityData) null, (CompoundNBT) null);
												world.addEntity(entityToSpawn);
											}
											if (world instanceof ServerWorld) {
												Entity entityToSpawn = new CrowEntity.CustomEntity(CrowEntity.entity, (World) world);
												entityToSpawn.setLocationAndAngles((x + 2), (y + 2), (z - 2),
														(float) (MathHelper.nextInt(new Random(), -179, 180)), (float) 0);
												entityToSpawn.setRenderYawOffset((float) (MathHelper.nextInt(new Random(), -179, 180)));
												entityToSpawn.setRotationYawHead((float) (MathHelper.nextInt(new Random(), -179, 180)));
												entityToSpawn.setMotion(0, 0, 0);
												if (entityToSpawn instanceof MobEntity)
													((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
															world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
															(ILivingEntityData) null, (CompoundNBT) null);
												world.addEntity(entityToSpawn);
											}
											if (world instanceof ServerWorld) {
												Entity entityToSpawn = new CrowEntity.CustomEntity(CrowEntity.entity, (World) world);
												entityToSpawn.setLocationAndAngles((x + 3), (y + 2), (z - 3),
														(float) (MathHelper.nextInt(new Random(), -179, 180)), (float) 0);
												entityToSpawn.setRenderYawOffset((float) (MathHelper.nextInt(new Random(), -179, 180)));
												entityToSpawn.setRotationYawHead((float) (MathHelper.nextInt(new Random(), -179, 180)));
												entityToSpawn.setMotion(0, 0, 0);
												if (entityToSpawn instanceof MobEntity)
													((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
															world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
															(ILivingEntityData) null, (CompoundNBT) null);
												world.addEntity(entityToSpawn);
											}
											if (world instanceof ServerWorld) {
												Entity entityToSpawn = new CrowEntity.CustomEntity(CrowEntity.entity, (World) world);
												entityToSpawn.setLocationAndAngles((x - 3), (y + 2), (z + 3),
														(float) (MathHelper.nextInt(new Random(), -179, 180)), (float) 0);
												entityToSpawn.setRenderYawOffset((float) (MathHelper.nextInt(new Random(), -179, 180)));
												entityToSpawn.setRotationYawHead((float) (MathHelper.nextInt(new Random(), -179, 180)));
												entityToSpawn.setMotion(0, 0, 0);
												if (entityToSpawn instanceof MobEntity)
													((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
															world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
															(ILivingEntityData) null, (CompoundNBT) null);
												world.addEntity(entityToSpawn);
											}
											if (world instanceof ServerWorld) {
												Entity entityToSpawn = new CrowEntity.CustomEntity(CrowEntity.entity, (World) world);
												entityToSpawn.setLocationAndAngles((x - 4), (y + 2), (z + 4),
														(float) (MathHelper.nextInt(new Random(), -179, 180)), (float) 0);
												entityToSpawn.setRenderYawOffset((float) (MathHelper.nextInt(new Random(), -179, 180)));
												entityToSpawn.setRotationYawHead((float) (MathHelper.nextInt(new Random(), -179, 180)));
												entityToSpawn.setMotion(0, 0, 0);
												if (entityToSpawn instanceof MobEntity)
													((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
															world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
															(ILivingEntityData) null, (CompoundNBT) null);
												world.addEntity(entityToSpawn);
											}
											if (world instanceof ServerWorld) {
												Entity entityToSpawn = new CrowEntity.CustomEntity(CrowEntity.entity, (World) world);
												entityToSpawn.setLocationAndAngles((x + 4), (y + 2), (z - 4),
														(float) (MathHelper.nextInt(new Random(), -179, 180)), (float) 0);
												entityToSpawn.setRenderYawOffset((float) (MathHelper.nextInt(new Random(), -179, 180)));
												entityToSpawn.setRotationYawHead((float) (MathHelper.nextInt(new Random(), -179, 180)));
												entityToSpawn.setMotion(0, 0, 0);
												if (entityToSpawn instanceof MobEntity)
													((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
															world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
															(ILivingEntityData) null, (CompoundNBT) null);
												world.addEntity(entityToSpawn);
											}
											if (world instanceof ServerWorld) {
												Entity entityToSpawn = new CrowEntity.CustomEntity(CrowEntity.entity, (World) world);
												entityToSpawn.setLocationAndAngles((x + 4), (y + 2), (z + 4),
														(float) (MathHelper.nextInt(new Random(), -179, 180)), (float) 0);
												entityToSpawn.setRenderYawOffset((float) (MathHelper.nextInt(new Random(), -179, 180)));
												entityToSpawn.setRotationYawHead((float) (MathHelper.nextInt(new Random(), -179, 180)));
												entityToSpawn.setMotion(0, 0, 0);
												if (entityToSpawn instanceof MobEntity)
													((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
															world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
															(ILivingEntityData) null, (CompoundNBT) null);
												world.addEntity(entityToSpawn);
											}
											if (world instanceof ServerWorld) {
												Entity entityToSpawn = new CrowEntity.CustomEntity(CrowEntity.entity, (World) world);
												entityToSpawn.setLocationAndAngles((x - 3), (y + 2), (z - 3),
														(float) (MathHelper.nextInt(new Random(), -179, 180)), (float) 0);
												entityToSpawn.setRenderYawOffset((float) (MathHelper.nextInt(new Random(), -179, 180)));
												entityToSpawn.setRotationYawHead((float) (MathHelper.nextInt(new Random(), -179, 180)));
												entityToSpawn.setMotion(0, 0, 0);
												if (entityToSpawn instanceof MobEntity)
													((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
															world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
															(ILivingEntityData) null, (CompoundNBT) null);
												world.addEntity(entityToSpawn);
											}
											if (world instanceof ServerWorld) {
												Entity entityToSpawn = new CrowEntity.CustomEntity(CrowEntity.entity, (World) world);
												entityToSpawn.setLocationAndAngles((x - 4), (y + 2), (z - 4),
														(float) (MathHelper.nextInt(new Random(), -179, 180)), (float) 0);
												entityToSpawn.setRenderYawOffset((float) (MathHelper.nextInt(new Random(), -179, 180)));
												entityToSpawn.setRotationYawHead((float) (MathHelper.nextInt(new Random(), -179, 180)));
												entityToSpawn.setMotion(0, 0, 0);
												if (entityToSpawn instanceof MobEntity)
													((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
															world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
															(ILivingEntityData) null, (CompoundNBT) null);
												world.addEntity(entityToSpawn);
											}
											if (world instanceof ServerWorld) {
												Entity entityToSpawn = new CrowEntity.CustomEntity(CrowEntity.entity, (World) world);
												entityToSpawn.setLocationAndAngles((x + 3), (y + 2), (z + 3),
														(float) (MathHelper.nextInt(new Random(), -179, 180)), (float) 0);
												entityToSpawn.setRenderYawOffset((float) (MathHelper.nextInt(new Random(), -179, 180)));
												entityToSpawn.setRotationYawHead((float) (MathHelper.nextInt(new Random(), -179, 180)));
												entityToSpawn.setMotion(0, 0, 0);
												if (entityToSpawn instanceof MobEntity)
													((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
															world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
															(ILivingEntityData) null, (CompoundNBT) null);
												world.addEntity(entityToSpawn);
											}
											if (world instanceof ServerWorld) {
												Entity entityToSpawn = new CrowEntity.CustomEntity(CrowEntity.entity, (World) world);
												entityToSpawn.setLocationAndAngles((x + 2), (y + 2), (z + 2),
														(float) (MathHelper.nextInt(new Random(), -179, 180)), (float) 0);
												entityToSpawn.setRenderYawOffset((float) (MathHelper.nextInt(new Random(), -179, 180)));
												entityToSpawn.setRotationYawHead((float) (MathHelper.nextInt(new Random(), -179, 180)));
												entityToSpawn.setMotion(0, 0, 0);
												if (entityToSpawn instanceof MobEntity)
													((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
															world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
															(ILivingEntityData) null, (CompoundNBT) null);
												world.addEntity(entityToSpawn);
											}
											if (world instanceof ServerWorld) {
												Entity entityToSpawn = new CrowEntity.CustomEntity(CrowEntity.entity, (World) world);
												entityToSpawn.setLocationAndAngles((x - 2), (y + 2), (z - 2),
														(float) (MathHelper.nextInt(new Random(), -179, 180)), (float) 0);
												entityToSpawn.setRenderYawOffset((float) (MathHelper.nextInt(new Random(), -179, 180)));
												entityToSpawn.setRotationYawHead((float) (MathHelper.nextInt(new Random(), -179, 180)));
												entityToSpawn.setMotion(0, 0, 0);
												if (entityToSpawn instanceof MobEntity)
													((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
															world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
															(ILivingEntityData) null, (CompoundNBT) null);
												world.addEntity(entityToSpawn);
											}
											{
												List<Entity> _entfound = world
														.getEntitiesWithinAABB(Entity.class, new AxisAlignedBB(x - (10 / 2d), y - (10 / 2d),
																z - (10 / 2d), x + (10 / 2d), y + (10 / 2d), z + (10 / 2d)), null)
														.stream().sorted(new Object() {
															Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																return Comparator.comparing(
																		(Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
															}
														}.compareDistOf(x, y, z)).collect(Collectors.toList());
												for (Entity entityiterator : _entfound) {
													if (!(entity == entityiterator)) {
														if (entityiterator instanceof LivingEntity)
															((LivingEntity) entityiterator).addPotionEffect(
																	new EffectInstance(Effects.BLINDNESS, (int) 200, (int) 1, (false), (false)));
													}
												}
											}
											if (entity instanceof LivingEntity)
												((LivingEntity) entity)
														.addPotionEffect(new EffectInstance(Effects.INVISIBILITY, (int) 200, (int) 1, (false), (false)));
											{
												double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 350);
												entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
														.ifPresent(capability -> {
															capability.ChakraAmount = _setval;
															capability.syncPlayerVariables(entity);
														});
											}
										} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 349) {
											if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
												((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
											}
										}
									} else if (NarutoShippudenModVariables.get(entity).genjutsu <= 9) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Genjutsu"), (false));
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 19) {
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu"), (false));
									}
								}
							} else if (!(NarutoShippudenModVariables.get(entity).sharinganlearn >= 2)) {
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this technique."), (false));
								}
							}
						} else if (NarutoShippudenModVariables.get(entity).sharingantechnique == 2) {
							if (NarutoShippudenModVariables.get(entity).sharinganlearn >= 3) {
								if (NarutoShippudenModVariables.get(entity).ninjutsu >= 30) {
									if (NarutoShippudenModVariables.get(entity).genjutsu >= 15) {
										if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 500) {
											{
												Entity _shootFrom = entity;
												World projectileLevel = _shootFrom.world;
												if (!projectileLevel.isRemote()) {
													ProjectileEntity _entityToSpawn = new Object() {
														public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
															AbstractArrowEntity entityToSpawn = new DemonicIllusionShacklingStakesTechniqueItem.ArrowCustomEntity(
																	DemonicIllusionShacklingStakesTechniqueItem.arrow, world);
															entityToSpawn.setShooter(shooter);
															entityToSpawn.setDamage(damage);
															entityToSpawn.setKnockbackStrength(knockback);
															entityToSpawn.setSilent(true);

															return entityToSpawn;
														}
													}.getArrow(projectileLevel, entity, 1, 0);
													_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
													_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z,
															4, 0);
													projectileLevel.addEntity(_entityToSpawn);
												}
											}
											{
												double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 500);
												entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
														.ifPresent(capability -> {
															capability.ChakraAmount = _setval;
															capability.syncPlayerVariables(entity);
														});
											}
										} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 499) {
											if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
												((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
											}
										}
									} else if (NarutoShippudenModVariables.get(entity).genjutsu <= 14) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Genjutsu"), (false));
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 29) {
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu"), (false));
									}
								}
							} else if (!(NarutoShippudenModVariables.get(entity).sharinganlearn >= 3)) {
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this technique."), (false));
								}
							}
						}
						if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
							if (entity instanceof PlayerEntity)
								((PlayerEntity) entity).getCooldownTracker().setCooldown(SharinganReleaseTechniqueItem.block, (int) 200);
						} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
							if (entity instanceof PlayerEntity)
								((PlayerEntity) entity).getCooldownTracker().setCooldown(SharinganReleaseTechniqueItem.block, (int) 160);
						} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
							if (entity instanceof PlayerEntity)
								((PlayerEntity) entity).getCooldownTracker().setCooldown(SharinganReleaseTechniqueItem.block, (int) 120);
						} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
							if (entity instanceof PlayerEntity)
								((PlayerEntity) entity).getCooldownTracker().setCooldown(SharinganReleaseTechniqueItem.block, (int) 80);
						} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
							if (entity instanceof PlayerEntity)
								((PlayerEntity) entity).getCooldownTracker().setCooldown(SharinganReleaseTechniqueItem.block, (int) 40);
						}
					} else if (NarutoShippudenModVariables.get(entity).sharinganactivate == false) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Activate your Sharingan"), (false));
						}
					}
				} else if (entity.isSneaking()) {
					if (NarutoShippudenModVariables.get(entity).sharingantechnique == 0) {
						{
							double _setval = 1;
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.sharingantechnique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Selected: Demonic Illusion: Mirage Crow"), (true));
						}
					} else if (NarutoShippudenModVariables.get(entity).sharingantechnique == 1) {
						{
							double _setval = 2;
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.sharingantechnique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Selected: Demonic Illusion: Shackling Stakes Technique"),
									(true));
						}
					} else if (NarutoShippudenModVariables.get(entity).sharingantechnique == 2) {
						{
							double _setval = 0;
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.sharingantechnique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Selected: Coercion Sharingan"), (true));
						}
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).sharingan == false) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked Sharingan"), (true));
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
			IWorld world = (IWorld) dependencies.get("world");
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).SharinganShimura == false) {
				new Object() {
					private int ticks = 0;
					private float waitTicks;
					private IWorld world;

					public void start(IWorld world, int waitTicks) {
						this.waitTicks = waitTicks;
						MinecraftForge.EVENT_BUS.register(this);
						this.world = world;
					}

					@SubscribeEvent
					public void tick(TickEvent.ServerTickEvent event) {
						if (event.phase == TickEvent.Phase.END) {
							this.ticks += 1;
							if (this.ticks >= this.waitTicks)
								run();
						}
					}

					private void run() {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(
									new StringTextComponent("You suddenly feel a surge of power through you as you awaken the Sharingan!"), (false));
						}
						{
							boolean _setval = (true);
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.SharinganShimura = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							String _setval = "1x1";
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.dojutsusharingan = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof LivingEntity)
							((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.NAUSEA, (int) 200, (int) 4, (false), (false)));
						if (entity instanceof LivingEntity)
							((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.BLINDNESS, (int) 60, (int) 1, (false), (false)));
						if (entity instanceof PlayerEntity) {
							ItemStack _setstack = new ItemStack(SharinganReleaseItem.block);
							_setstack.setCount((int) 1);
							ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
						}
						MinecraftForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 200);
			} else if (NarutoShippudenModVariables.get(entity).SharinganShimura == true) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You've already unlocked sharingan."), (false));
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
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(
						new StringTextComponent("You suddenly feel a surge of power through you as you awaken the Sharingan!"), (false));
			}
			{
				boolean _setval = (true);
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.SharinganShimura = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				String _setval = "1x1";
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.dojutsusharingan = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.NAUSEA, (int) 200, (int) 4, (false), (false)));
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.BLINDNESS, (int) 60, (int) 1, (false), (false)));
			if (entity instanceof PlayerEntity) {
				ItemStack _setstack = new ItemStack(SharinganReleaseItem.block);
				_setstack.setCount((int) 1);
				ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
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
			IWorld world = (IWorld) dependencies.get("world");
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).tenseigan == false) {
				new Object() {
					private int ticks = 0;
					private float waitTicks;
					private IWorld world;

					public void start(IWorld world, int waitTicks) {
						this.waitTicks = waitTicks;
						MinecraftForge.EVENT_BUS.register(this);
						this.world = world;
					}

					@SubscribeEvent
					public void tick(TickEvent.ServerTickEvent event) {
						if (event.phase == TickEvent.Phase.END) {
							this.ticks += 1;
							if (this.ticks >= this.waitTicks)
								run();
						}
					}

					private void run() {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You've awakened Tenseigan!"), (false));
						}
						{
							String _setval = "1x1";
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.dojutsutenseigan = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof PlayerEntity) {
							ItemStack _setstack = new ItemStack(TenseiganReleaseItem.block);
							_setstack.setCount((int) 1);
							ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
						}
						{
							boolean _setval = (true);
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.tenseigan = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						MinecraftForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 200);
			} else if (NarutoShippudenModVariables.get(entity).tenseigan == true) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You've already unlocked tenseigan."), (false));
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
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You've awakened Tenseigan!"), (false));
			}
			{
				String _setval = "1x1";
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.dojutsutenseigan = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof PlayerEntity) {
				ItemStack _setstack = new ItemStack(TenseiganReleaseItem.block);
				_setstack.setCount((int) 1);
				ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
			}
			{
				boolean _setval = (true);
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.tenseigan = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}

	public static class VolticModeReleaseRightclickedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure VolticModeReleaseRightclicked!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).volticrelease == 0) {
				if (NarutoShippudenModVariables.get(entity).jp >= 25) {
					if (entity instanceof PlayerEntity) {
						ItemStack _setstack = new ItemStack(VolticModeTechniqueItem.block);
						_setstack.setCount((int) 1);
						ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
					}
					{
						double _setval = 1;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.volticlearn = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 24);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).volticrelease + 1);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.volticrelease = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("-25 JP"), (false));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 4) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough JP"), (false));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).volticrelease == 1) {
				if (NarutoShippudenModVariables.get(entity).jp >= 35) {
					{
						double _setval = 2;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.volticlearn = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 35);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).volticrelease + 1);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.volticrelease = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("-35 JP"), (false));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 9) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough JP"), (false));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).volticrelease == 2) {
				if (NarutoShippudenModVariables.get(entity).jp >= 50) {
					{
						double _setval = 3;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.volticlearn = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 50);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).volticrelease + 1);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.volticrelease = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("-50 JP"), (false));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 14) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough JP"), (false));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).volticrelease == 3) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Wait For Newer Updates"), (false));
				}
			}
		}
	}

	public static class VolticModeTechniqueRightclickedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("world") == null) {
				if (!dependencies.containsKey("world"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure VolticModeTechniqueRightclicked!");
				return;
			}
			if (dependencies.get("x") == null) {
				if (!dependencies.containsKey("x"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency x for procedure VolticModeTechniqueRightclicked!");
				return;
			}
			if (dependencies.get("y") == null) {
				if (!dependencies.containsKey("y"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency y for procedure VolticModeTechniqueRightclicked!");
				return;
			}
			if (dependencies.get("z") == null) {
				if (!dependencies.containsKey("z"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency z for procedure VolticModeTechniqueRightclicked!");
				return;
			}
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure VolticModeTechniqueRightclicked!");
				return;
			}
			IWorld world = (IWorld) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			Entity entity = (Entity) dependencies.get("entity");
			double xRadius = 0;
			double loop = 0;
			double zRadius = 0;
			double particleAmount = 0;
			double loop2 = 0;
			double xRadius2 = 0;
			double zRadius2 = 0;
			double particleAmount2 = 0;
			double xRadius3 = 0;
			double zRadius3 = 0;
			double loop3 = 0;
			double xRadius4 = 0;
			double zRadius4 = 0;
			double loop4 = 0;
			double xRadius5 = 0;
			double zRadius5 = 0;
			double loop5 = 0;
			double xRadius6 = 0;
			double zRadius6 = 0;
			double loop6 = 0;
			double xRadius7 = 0;
			double zRadius7 = 0;
			double loop7 = 0;
			double zRadius8 = 0;
			double xRadius8 = 0;
			double loop8 = 0;
			double yaw = 0;
			if (NarutoShippudenModVariables.get(entity).BoxDeity == true) {
				if (!entity.isSneaking()) {
					yaw = (entity.rotationYaw);
					if (NarutoShippudenModVariables.get(entity).voltic_technique == 0) {
						if (NarutoShippudenModVariables.get(entity).volticlearn >= 1) {
							if (NarutoShippudenModVariables.get(entity).ninjutsu >= 15) {
								if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 100) {
									if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
										if (entity instanceof PlayerEntity)
											((PlayerEntity) entity).getCooldownTracker().setCooldown(VolticModeTechniqueItem.block, (int) 200);
									} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
										if (entity instanceof PlayerEntity)
											((PlayerEntity) entity).getCooldownTracker().setCooldown(VolticModeTechniqueItem.block, (int) 160);
									} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
										if (entity instanceof PlayerEntity)
											((PlayerEntity) entity).getCooldownTracker().setCooldown(VolticModeTechniqueItem.block, (int) 120);
									} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
										if (entity instanceof PlayerEntity)
											((PlayerEntity) entity).getCooldownTracker().setCooldown(VolticModeTechniqueItem.block, (int) 80);
									} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
										if (entity instanceof PlayerEntity)
											((PlayerEntity) entity).getCooldownTracker().setCooldown(VolticModeTechniqueItem.block, (int) 40);
									}
									{
										List<Entity> _entfound = world.getEntitiesWithinAABB(Entity.class, new AxisAlignedBB(x - (10 / 2d), y - (10 / 2d),
												z - (10 / 2d), x + (10 / 2d), y + (10 / 2d), z + (10 / 2d)), null).stream().sorted(new Object() {
													Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
														return Comparator
																.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
													}
												}.compareDistOf(x, y, z)).collect(Collectors.toList());
										for (Entity entityiterator : _entfound) {
											if (!(entityiterator == entity)) {
												entityiterator.attackEntityFrom(DamageSource.GENERIC, (float) 15);
												if (entityiterator instanceof LivingEntity)
													((LivingEntity) entityiterator)
															.addPotionEffect(new EffectInstance(Effects.SLOWNESS, (int) 160, (int) 2, (false), (false)));
											}
										}
									}
									loop = 0;
									particleAmount = 80;
									xRadius = 4;
									zRadius = 4;
									loop2 = 0;
									xRadius2 = 3.5;
									zRadius2 = 3.5;
									loop3 = 0;
									xRadius3 = 3;
									zRadius3 = 3;
									loop4 = 0;
									xRadius4 = 2.5;
									zRadius4 = 2.5;
									loop5 = 0;
									xRadius5 = 2;
									zRadius5 = 2;
									loop6 = 0;
									xRadius6 = 1.5;
									zRadius6 = 1.5;
									loop7 = 0;
									xRadius7 = 1;
									zRadius7 = 1;
									loop8 = 0;
									zRadius8 = 0.5;
									xRadius8 = 0.5;
									while (loop < particleAmount) {
										world.addParticle(VolticParticleParticle.particle,
												(x + 0 + Math.cos(((Math.PI * 2) / particleAmount) * loop) * xRadius), y,
												(z + 0 + Math.sin(((Math.PI * 2) / particleAmount) * loop) * zRadius), 0, 0, 0);
										loop = (loop + 1);
									}
									while (loop2 < particleAmount) {
										world.addParticle(VolticParticleParticle.particle,
												(x + 0 + Math.cos(((Math.PI * 2) / particleAmount) * loop2) * xRadius2), y,
												(z + 0 + Math.sin(((Math.PI * 2) / particleAmount) * loop2) * zRadius2), 0, 0, 0);
										loop2 = (loop2 + 1);
									}
									while (loop3 < particleAmount) {
										world.addParticle(VolticParticleParticle.particle,
												(x + 0 + Math.cos(((Math.PI * 2) / particleAmount) * loop3) * xRadius3), y,
												(z + 0 + Math.sin(((Math.PI * 2) / particleAmount) * loop3) * zRadius3), 0, 0, 0);
										loop3 = (loop3 + 1);
									}
									while (loop4 < particleAmount) {
										world.addParticle(VolticParticleParticle.particle,
												(x + 0 + Math.cos(((Math.PI * 2) / particleAmount) * loop4) * xRadius4), y,
												(z + 0 + Math.sin(((Math.PI * 2) / particleAmount) * loop4) * zRadius4), 0, 0, 0);
										loop4 = (loop4 + 1);
									}
									while (loop5 < particleAmount) {
										world.addParticle(VolticParticleParticle.particle,
												(x + 0 + Math.cos(((Math.PI * 2) / particleAmount) * loop5) * xRadius5), y,
												(z + 0 + Math.sin(((Math.PI * 2) / particleAmount) * loop5) * zRadius5), 0, 0, 0);
										loop5 = (loop5 + 1);
									}
									while (loop6 < particleAmount) {
										world.addParticle(VolticParticleParticle.particle,
												(x + 0 + Math.cos(((Math.PI * 2) / particleAmount) * loop6) * xRadius6), y,
												(z + 0 + Math.sin(((Math.PI * 2) / particleAmount) * loop6) * zRadius6), 0, 0, 0);
										loop6 = (loop6 + 1);
									}
									while (loop7 < particleAmount) {
										world.addParticle(VolticParticleParticle.particle,
												(x + 0 + Math.cos(((Math.PI * 2) / particleAmount) * loop7) * xRadius7), y,
												(z + 0 + Math.sin(((Math.PI * 2) / particleAmount) * loop7) * zRadius7), 0, 0, 0);
										loop7 = (loop7 + 1);
									}
									while (loop8 < particleAmount) {
										world.addParticle(VolticParticleParticle.particle,
												(x + 0 + Math.cos(((Math.PI * 2) / particleAmount) * loop8) * xRadius8), y,
												(z + 0 + Math.sin(((Math.PI * 2) / particleAmount) * loop8) * zRadius8), 0, 0, 0);
										loop8 = (loop8 + 1);
									}
								} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 99) {
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 14) {
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu"), (false));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).volticlearn >= 1)) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this technique."), (false));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).voltic_technique == 1) {
						if (NarutoShippudenModVariables.get(entity).volticlearn >= 2) {
							if (NarutoShippudenModVariables.get(entity).ninjutsu >= 20) {
								if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 450) {
									if (entity instanceof PlayerEntity) {
										ItemStack _setstack = new ItemStack(BladeOfLightningItem.block);
										_setstack.setCount((int) 1);
										ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
									}
									{
										double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 450);
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.ChakraAmount = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
										if (entity instanceof PlayerEntity)
											((PlayerEntity) entity).getCooldownTracker().setCooldown(VolticModeTechniqueItem.block, (int) 3000);
									} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
										if (entity instanceof PlayerEntity)
											((PlayerEntity) entity).getCooldownTracker().setCooldown(VolticModeTechniqueItem.block, (int) 2500);
									} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
										if (entity instanceof PlayerEntity)
											((PlayerEntity) entity).getCooldownTracker().setCooldown(VolticModeTechniqueItem.block, (int) 2000);
									} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
										if (entity instanceof PlayerEntity)
											((PlayerEntity) entity).getCooldownTracker().setCooldown(VolticModeTechniqueItem.block, (int) 1500);
									} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
										if (entity instanceof PlayerEntity)
											((PlayerEntity) entity).getCooldownTracker().setCooldown(VolticModeTechniqueItem.block, (int) 1000);
									}
								} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 449) {
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 19) {
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu"), (false));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).volticlearn >= 2)) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this technique."), (false));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).voltic_technique == 2) {
						if (NarutoShippudenModVariables.get(entity).volticlearn >= 3) {
							if (NarutoShippudenModVariables.get(entity).ninjutsu >= 25) {
								if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 500) {
									entity.setMotion((7 * Math.cos((yaw + 90) * (Math.PI / 180))), 2, (7 * Math.sin((yaw + 90) * (Math.PI / 180))));
									{
										double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 500);
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.ChakraAmount = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
										if (entity instanceof PlayerEntity)
											((PlayerEntity) entity).getCooldownTracker().setCooldown(VolticModeTechniqueItem.block, (int) 3500);
									} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
										if (entity instanceof PlayerEntity)
											((PlayerEntity) entity).getCooldownTracker().setCooldown(VolticModeTechniqueItem.block, (int) 3000);
									} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
										if (entity instanceof PlayerEntity)
											((PlayerEntity) entity).getCooldownTracker().setCooldown(VolticModeTechniqueItem.block, (int) 2500);
									} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
										if (entity instanceof PlayerEntity)
											((PlayerEntity) entity).getCooldownTracker().setCooldown(VolticModeTechniqueItem.block, (int) 2000);
									} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
										if (entity instanceof PlayerEntity)
											((PlayerEntity) entity).getCooldownTracker().setCooldown(VolticModeTechniqueItem.block, (int) 1500);
									}
									{
										boolean _setval = (true);
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.VolticThomasCannonDamage = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 499) {
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 24) {
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu"), (false));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).volticlearn >= 3)) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this technique."), (false));
							}
						}
					}
				} else if (entity.isSneaking()) {
					if (NarutoShippudenModVariables.get(entity).voltic_technique == 0) {
						{
							double _setval = 1;
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.voltic_technique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Selected: Voltic Execution"), (true));
						}
					} else if (NarutoShippudenModVariables.get(entity).voltic_technique == 1) {
						{
							double _setval = 2;
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.voltic_technique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Selected: Voltic Thomas Cannon"), (true));
						}
					} else if (NarutoShippudenModVariables.get(entity).voltic_technique == 2) {
						{
							double _setval = 0;
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.voltic_technique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Selected: Voltic Hammer"), (true));
						}
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).BoxDeity == false) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this release."), (true));
				}
			}
		}
	}
}
