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
import net.mcreator.narutoshippudenmod.entity.SummonEntities.CrowEntity;
import net.mcreator.narutoshippudenmod.item.DojutsuItems.ByakuganReleaseItem;
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
import net.mcreator.narutoshippudenmod.item.MissionItems.LetterFromBrotherItem;
import net.mcreator.narutoshippudenmod.item.TechniqueItems.IsshikiDojutsuReleaseTechniqueItem;
import net.mcreator.narutoshippudenmod.item.TechniqueItems.MangekyouSharinganItachiReleaseTechniqueItem;
import net.mcreator.narutoshippudenmod.item.TechniqueItems.MangekyouSharinganKakashiReleaseTechniqueItem;
import net.mcreator.narutoshippudenmod.item.TechniqueItems.MangekyouSharinganObitoReleaseTechniqueItem;
import net.mcreator.narutoshippudenmod.item.TechniqueItems.MangekyouSharinganSasukeReleaseTechniqueItem;
import net.mcreator.narutoshippudenmod.item.TechniqueItems.SharinganReleaseTechniqueItem;
import net.mcreator.narutoshippudenmod.particle.ModParticles.AmaterasuFireParticle;
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
								if (!java.util.Objects.equals(capability.dojutsubyakugan, _setval)) {
									capability.dojutsubyakugan = _setval;
									capability.syncPlayerVariables(entity);
								}
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
								if (!java.util.Objects.equals(capability.byakugan, _setval)) {
									capability.byakugan = _setval;
									capability.syncPlayerVariables(entity);
								}
							});
						}
						NeoForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 200);
			} else if (NarutoShippudenModVariables.get(entity).byakugan == true) {
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("You've already unlocked the Byakugan"));
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
					if (!java.util.Objects.equals(capability.dojutsubyakugan, _setval)) {
						capability.dojutsubyakugan = _setval;
						capability.syncPlayerVariables(entity);
					}
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
					if (!java.util.Objects.equals(capability.byakugan, _setval)) {
						capability.byakugan = _setval;
						capability.syncPlayerVariables(entity);
					}
				});
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
								if (!java.util.Objects.equals(capability.isshikidojutsu, _setval)) {
									capability.isshikidojutsu = _setval;
									capability.syncPlayerVariables(entity);
								}
							});
						}
						if (entity instanceof LivingEntity)
							((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.NAUSEA, (int) 200, (int) 4, (false), (false)));
						if (entity instanceof LivingEntity)
							((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.BLINDNESS, (int) 60, (int) 1, (false), (false)));
						{
							String _setval = "1x1";
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								if (!java.util.Objects.equals(capability.dojutsuisshiki, _setval)) {
									capability.dojutsuisshiki = _setval;
									capability.syncPlayerVariables(entity);
								}
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
					((Player) entity).sendOverlayMessage(Component.literal("You've already unlocked the Kokugan"));
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
					if (!java.util.Objects.equals(capability.isshikidojutsu, _setval)) {
						capability.isshikidojutsu = _setval;
						capability.syncPlayerVariables(entity);
					}
				});
			}
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.NAUSEA, (int) 200, (int) 4, (false), (false)));
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.BLINDNESS, (int) 60, (int) 1, (false), (false)));
			{
				String _setval = "1x1";
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					if (!java.util.Objects.equals(capability.dojutsuisshiki, _setval)) {
						capability.dojutsuisshiki = _setval;
						capability.syncPlayerVariables(entity);
					}
				});
			}
			if (entity instanceof Player) {
				ItemStack _setstack = new ItemStack(IsshikiDojutsuReleaseItem.block);
				_setstack.setCount((int) 1);
				Compat.giveItemToPlayer(((Player) entity), _setstack);
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
					if (!java.util.Objects.equals(capability.Mangekyou_Sharingan_Technique_Use_Max, _setval)) {
						capability.Mangekyou_Sharingan_Technique_Use_Max = _setval;
						capability.syncPlayerVariables(entity);
					}
				});
			}
			{
				boolean _setval = (true);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					if (!java.util.Objects.equals(capability.MangekyouSharinganKakashi, _setval)) {
						capability.MangekyouSharinganKakashi = _setval;
						capability.syncPlayerVariables(entity);
					}
				});
			}
			{
				boolean _setval = (true);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					if (!java.util.Objects.equals(capability.Mangekyou_Sharingan, _setval)) {
						capability.Mangekyou_Sharingan = _setval;
						capability.syncPlayerVariables(entity);
					}
				});
			}
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.NAUSEA, (int) 200, (int) 4, (false), (false)));
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.BLINDNESS, (int) 60, (int) 1, (false), (false)));
			{
				String _setval = "1x1";
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					if (!java.util.Objects.equals(capability.dojutsums, _setval)) {
						capability.dojutsums = _setval;
						capability.syncPlayerVariables(entity);
					}
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
								if (!java.util.Objects.equals(capability.SharinganKakashi, _setval)) {
									capability.SharinganKakashi = _setval;
									capability.syncPlayerVariables(entity);
								}
							});
						}
						if (entity instanceof LivingEntity)
							((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.NAUSEA, (int) 200, (int) 4, (false), (false)));
						if (entity instanceof LivingEntity)
							((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.BLINDNESS, (int) 60, (int) 1, (false), (false)));
						{
							String _setval = "1x1";
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								if (!java.util.Objects.equals(capability.dojutsusharingan, _setval)) {
									capability.dojutsusharingan = _setval;
									capability.syncPlayerVariables(entity);
								}
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
					((Player) entity).sendOverlayMessage(Component.literal("You've already unlocked the Sharingan"));
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
					if (!java.util.Objects.equals(capability.SharinganKakashi, _setval)) {
						capability.SharinganKakashi = _setval;
						capability.syncPlayerVariables(entity);
					}
				});
			}
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.NAUSEA, (int) 200, (int) 4, (false), (false)));
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.BLINDNESS, (int) 60, (int) 1, (false), (false)));
			{
				String _setval = "1x1";
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					if (!java.util.Objects.equals(capability.dojutsusharingan, _setval)) {
						capability.dojutsusharingan = _setval;
						capability.syncPlayerVariables(entity);
					}
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
								if (!java.util.Objects.equals(capability.dojutsuketsuryugan, _setval)) {
									capability.dojutsuketsuryugan = _setval;
									capability.syncPlayerVariables(entity);
								}
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
								if (!java.util.Objects.equals(capability.ketsuryugan, _setval)) {
									capability.ketsuryugan = _setval;
									capability.syncPlayerVariables(entity);
								}
							});
						}
						NeoForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 200);
			} else if (NarutoShippudenModVariables.get(entity).ketsuryugan == true) {
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("You've already unlocked the Ketsuryugan"));
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
					if (!java.util.Objects.equals(capability.dojutsuketsuryugan, _setval)) {
						capability.dojutsuketsuryugan = _setval;
						capability.syncPlayerVariables(entity);
					}
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
					if (!java.util.Objects.equals(capability.ketsuryugan, _setval)) {
						capability.ketsuryugan = _setval;
						capability.syncPlayerVariables(entity);
					}
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
					if (!java.util.Objects.equals(capability.mangekyouletter, _setval)) {
						capability.mangekyouletter = _setval;
						capability.syncPlayerVariables(entity);
					}
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
						if (!java.util.Objects.equals(capability.MangekyouSharinganSasuke, _setval)) {
							capability.MangekyouSharinganSasuke = _setval;
							capability.syncPlayerVariables(entity);
						}
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
						if (!java.util.Objects.equals(capability.MangekyouSharinganMadara, _setval)) {
							capability.MangekyouSharinganMadara = _setval;
							capability.syncPlayerVariables(entity);
						}
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
						if (!java.util.Objects.equals(capability.MangekyouSharinganItachi, _setval)) {
							capability.MangekyouSharinganItachi = _setval;
							capability.syncPlayerVariables(entity);
						}
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
						if (!java.util.Objects.equals(capability.MangekyouSharinganShisui, _setval)) {
							capability.MangekyouSharinganShisui = _setval;
							capability.syncPlayerVariables(entity);
						}
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
						if (!java.util.Objects.equals(capability.MangekyouSharinganObito, _setval)) {
							capability.MangekyouSharinganObito = _setval;
							capability.syncPlayerVariables(entity);
						}
					});
				}
			}
			{
				String _setval = "1x1";
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					if (!java.util.Objects.equals(capability.dojutsums, _setval)) {
						capability.dojutsums = _setval;
						capability.syncPlayerVariables(entity);
					}
				});
			}
			{
				boolean _setval = (true);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					if (!java.util.Objects.equals(capability.otsutsuki_mangekyou, _setval)) {
						capability.otsutsuki_mangekyou = _setval;
						capability.syncPlayerVariables(entity);
					}
				});
			}
			{
				boolean _setval = (true);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					if (!java.util.Objects.equals(capability.Mangekyou_Sharingan, _setval)) {
						capability.Mangekyou_Sharingan = _setval;
						capability.syncPlayerVariables(entity);
					}
				});
			}
			if (entity instanceof Player && !entity.level().isClientSide()) {
				((Player) entity).sendSystemMessage(Component.literal("You've awakened Mangekyou Sharingan!"));
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
					if (!java.util.Objects.equals(capability.Mangekyou_Sharingan_Technique_Use, _setval)) {
						capability.Mangekyou_Sharingan_Technique_Use = _setval;
						capability.syncPlayerVariables(entity);
					}
				});
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
							if (!java.util.Objects.equals(capability.dojutsurinnegan, _setval)) {
								capability.dojutsurinnegan = _setval;
								capability.syncPlayerVariables(entity);
							}
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
							if (!java.util.Objects.equals(capability.rinnegan, _setval)) {
								capability.rinnegan = _setval;
								capability.syncPlayerVariables(entity);
							}
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
						if (!java.util.Objects.equals(capability.dojutsurinnegan, _setval)) {
							capability.dojutsurinnegan = _setval;
							capability.syncPlayerVariables(entity);
						}
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
						if (!java.util.Objects.equals(capability.rinnegan, _setval)) {
							capability.rinnegan = _setval;
							capability.syncPlayerVariables(entity);
						}
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
								if (!java.util.Objects.equals(capability.sharingan, _setval)) {
									capability.sharingan = _setval;
									capability.syncPlayerVariables(entity);
								}
							});
						}
						if (entity instanceof LivingEntity)
							((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.NAUSEA, (int) 200, (int) 4, (false), (false)));
						if (entity instanceof LivingEntity)
							((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.BLINDNESS, (int) 60, (int) 1, (false), (false)));
						{
							String _setval = "1x1";
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								if (!java.util.Objects.equals(capability.dojutsusharingan, _setval)) {
									capability.dojutsusharingan = _setval;
									capability.syncPlayerVariables(entity);
								}
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
					((Player) entity).sendOverlayMessage(Component.literal("You've already unlocked the Sharingan"));
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
					if (!java.util.Objects.equals(capability.sharingan, _setval)) {
						capability.sharingan = _setval;
						capability.syncPlayerVariables(entity);
					}
				});
			}
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.NAUSEA, (int) 200, (int) 4, (false), (false)));
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.BLINDNESS, (int) 60, (int) 1, (false), (false)));
			{
				String _setval = "1x1";
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					if (!java.util.Objects.equals(capability.dojutsusharingan, _setval)) {
						capability.dojutsusharingan = _setval;
						capability.syncPlayerVariables(entity);
					}
				});
			}
			if (entity instanceof Player) {
				ItemStack _setstack = new ItemStack(SharinganReleaseItem.block);
				_setstack.setCount((int) 1);
				Compat.giveItemToPlayer(((Player) entity), _setstack);
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
								if (!java.util.Objects.equals(capability.SharinganShimura, _setval)) {
									capability.SharinganShimura = _setval;
									capability.syncPlayerVariables(entity);
								}
							});
						}
						{
							String _setval = "1x1";
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								if (!java.util.Objects.equals(capability.dojutsusharingan, _setval)) {
									capability.dojutsusharingan = _setval;
									capability.syncPlayerVariables(entity);
								}
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
					((Player) entity).sendOverlayMessage(Component.literal("You've already unlocked the Sharingan"));
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
					if (!java.util.Objects.equals(capability.SharinganShimura, _setval)) {
						capability.SharinganShimura = _setval;
						capability.syncPlayerVariables(entity);
					}
				});
			}
			{
				String _setval = "1x1";
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					if (!java.util.Objects.equals(capability.dojutsusharingan, _setval)) {
						capability.dojutsusharingan = _setval;
						capability.syncPlayerVariables(entity);
					}
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
								if (!java.util.Objects.equals(capability.dojutsutenseigan, _setval)) {
									capability.dojutsutenseigan = _setval;
									capability.syncPlayerVariables(entity);
								}
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
								if (!java.util.Objects.equals(capability.tenseigan, _setval)) {
									capability.tenseigan = _setval;
									capability.syncPlayerVariables(entity);
								}
							});
						}
						NeoForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 200);
			} else if (NarutoShippudenModVariables.get(entity).tenseigan == true) {
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("You've already unlocked the Tenseigan"));
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
					if (!java.util.Objects.equals(capability.dojutsutenseigan, _setval)) {
						capability.dojutsutenseigan = _setval;
						capability.syncPlayerVariables(entity);
					}
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
					if (!java.util.Objects.equals(capability.tenseigan, _setval)) {
						capability.tenseigan = _setval;
						capability.syncPlayerVariables(entity);
					}
				});
			}
		}
	}

}
