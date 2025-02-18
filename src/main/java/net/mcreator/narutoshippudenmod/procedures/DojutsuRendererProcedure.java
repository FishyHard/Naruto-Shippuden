package net.mcreator.narutoshippudenmod.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.entity.PlayerRenderer;
import net.minecraft.client.entity.player.AbstractClientPlayerEntity;

import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables;
import net.mcreator.narutoshippudenmod.NarutoShippudenMod;

import java.util.Map;
import java.util.HashMap;

public class DojutsuRendererProcedure {
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
		if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).byakugan == true) {
			if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).byakuganactivate == true) {
				if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).dojutsubyakugan).equals("1x1")) {
					if (_evt.getRenderer() instanceof PlayerRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						new com.kleiders.kleidersplayerrenderer.InternalPlayerRenderer(_evt.getRenderer().getRenderManager(),
								new ResourceLocation("naruto_shippuden:textures/dojutsu/byakugan/byakugan_2x1_pupils_1x1.png"))
								.render((AbstractClientPlayerEntity) _evt.getEntity(), _evt.getEntity().rotationYaw, _evt.getPartialRenderTick(),
										_evt.getMatrixStack(), _evt.getBuffers(), _evt.getLight());
					}
				} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).dojutsubyakugan).equals("2x1")) {
					if (_evt.getRenderer() instanceof PlayerRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						new com.kleiders.kleidersplayerrenderer.InternalPlayerRenderer(_evt.getRenderer().getRenderManager(),
								new ResourceLocation("naruto_shippuden:textures/dojutsu/byakugan/byakugan_2x1_pupils_2x1.png"))
								.render((AbstractClientPlayerEntity) _evt.getEntity(), _evt.getEntity().rotationYaw, _evt.getPartialRenderTick(),
										_evt.getMatrixStack(), _evt.getBuffers(), _evt.getLight());
					}
				} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).dojutsubyakugan).equals("1x2")) {
					if (_evt.getRenderer() instanceof PlayerRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						new com.kleiders.kleidersplayerrenderer.InternalPlayerRenderer(_evt.getRenderer().getRenderManager(),
								new ResourceLocation("naruto_shippuden:textures/dojutsu/byakugan/byakugan_2x2_pupils_1x1.png"))
								.render((AbstractClientPlayerEntity) _evt.getEntity(), _evt.getEntity().rotationYaw, _evt.getPartialRenderTick(),
										_evt.getMatrixStack(), _evt.getBuffers(), _evt.getLight());
					}
				} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).dojutsubyakugan).equals("2x2")) {
					if (_evt.getRenderer() instanceof PlayerRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						new com.kleiders.kleidersplayerrenderer.InternalPlayerRenderer(_evt.getRenderer().getRenderManager(),
								new ResourceLocation("naruto_shippuden:textures/dojutsu/byakugan/byakugan_2x2_pupils_1x2.png"))
								.render((AbstractClientPlayerEntity) _evt.getEntity(), _evt.getEntity().rotationYaw, _evt.getPartialRenderTick(),
										_evt.getMatrixStack(), _evt.getBuffers(), _evt.getLight());
					}
				}
			} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).byakuganactivate == false) {
				if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).dojutsubyakugan).equals("1x1")) {
					if (_evt.getRenderer() instanceof PlayerRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						new com.kleiders.kleidersplayerrenderer.InternalPlayerRenderer(_evt.getRenderer().getRenderManager(),
								new ResourceLocation("naruto_shippuden:textures/dojutsu/byakugan/byakugan_2x1_pupils_1x1_not_active.png"))
								.render((AbstractClientPlayerEntity) _evt.getEntity(), _evt.getEntity().rotationYaw, _evt.getPartialRenderTick(),
										_evt.getMatrixStack(), _evt.getBuffers(), _evt.getLight());
					}
				} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).dojutsubyakugan).equals("2x1")) {
					if (_evt.getRenderer() instanceof PlayerRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						new com.kleiders.kleidersplayerrenderer.InternalPlayerRenderer(_evt.getRenderer().getRenderManager(),
								new ResourceLocation("naruto_shippuden:textures/dojutsu/byakugan/byakugan_2x1_pupils_2x1_not_active.png"))
								.render((AbstractClientPlayerEntity) _evt.getEntity(), _evt.getEntity().rotationYaw, _evt.getPartialRenderTick(),
										_evt.getMatrixStack(), _evt.getBuffers(), _evt.getLight());
					}
				} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).dojutsubyakugan).equals("1x2")) {
					if (_evt.getRenderer() instanceof PlayerRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						new com.kleiders.kleidersplayerrenderer.InternalPlayerRenderer(_evt.getRenderer().getRenderManager(),
								new ResourceLocation("naruto_shippuden:textures/dojutsu/byakugan/byakugan_2x2_pupils_1x1_not_active.png"))
								.render((AbstractClientPlayerEntity) _evt.getEntity(), _evt.getEntity().rotationYaw, _evt.getPartialRenderTick(),
										_evt.getMatrixStack(), _evt.getBuffers(), _evt.getLight());
					}
				} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).dojutsubyakugan).equals("2x2")) {
					if (_evt.getRenderer() instanceof PlayerRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						new com.kleiders.kleidersplayerrenderer.InternalPlayerRenderer(_evt.getRenderer().getRenderManager(),
								new ResourceLocation("naruto_shippuden:textures/dojutsu/byakugan/byakugan_2x2_pupils_1x2_not_active.png"))
								.render((AbstractClientPlayerEntity) _evt.getEntity(), _evt.getEntity().rotationYaw, _evt.getPartialRenderTick(),
										_evt.getMatrixStack(), _evt.getBuffers(), _evt.getLight());
					}
				}
			}
		}
		if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).ketsuryuganactivate == true) {
			if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).dojutsuketsuryugan).equals("1x1")) {
				if (_evt.getRenderer() instanceof PlayerRenderer) {
					if (_evt instanceof RenderLivingEvent.Pre) {
						//  _evt.setCanceled(true); 
					}
					new com.kleiders.kleidersplayerrenderer.InternalPlayerRenderer(_evt.getRenderer().getRenderManager(),
							new ResourceLocation("naruto_shippuden:textures/dojutsu/ketsuryugan/ketsuryugan_2x1_pupils_1x1.png"))
							.render((AbstractClientPlayerEntity) _evt.getEntity(), _evt.getEntity().rotationYaw, _evt.getPartialRenderTick(),
									_evt.getMatrixStack(), _evt.getBuffers(), _evt.getLight());
				}
			} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).dojutsuketsuryugan).equals("2x1")) {
				if (_evt.getRenderer() instanceof PlayerRenderer) {
					if (_evt instanceof RenderLivingEvent.Pre) {
						//  _evt.setCanceled(true); 
					}
					new com.kleiders.kleidersplayerrenderer.InternalPlayerRenderer(_evt.getRenderer().getRenderManager(),
							new ResourceLocation("naruto_shippuden:textures/dojutsu/ketsuryugan/ketsuryugan_2x1_pupils_2x1.png"))
							.render((AbstractClientPlayerEntity) _evt.getEntity(), _evt.getEntity().rotationYaw, _evt.getPartialRenderTick(),
									_evt.getMatrixStack(), _evt.getBuffers(), _evt.getLight());
				}
			} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).dojutsuketsuryugan).equals("1x2")) {
				if (_evt.getRenderer() instanceof PlayerRenderer) {
					if (_evt instanceof RenderLivingEvent.Pre) {
						//  _evt.setCanceled(true); 
					}
					new com.kleiders.kleidersplayerrenderer.InternalPlayerRenderer(_evt.getRenderer().getRenderManager(),
							new ResourceLocation("naruto_shippuden:textures/dojutsu/ketsuryugan/ketsuryugan_2x2_pupils_1x1.png"))
							.render((AbstractClientPlayerEntity) _evt.getEntity(), _evt.getEntity().rotationYaw, _evt.getPartialRenderTick(),
									_evt.getMatrixStack(), _evt.getBuffers(), _evt.getLight());
				}
			} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).dojutsuketsuryugan).equals("2x2")) {
				if (_evt.getRenderer() instanceof PlayerRenderer) {
					if (_evt instanceof RenderLivingEvent.Pre) {
						//  _evt.setCanceled(true); 
					}
					new com.kleiders.kleidersplayerrenderer.InternalPlayerRenderer(_evt.getRenderer().getRenderManager(),
							new ResourceLocation("naruto_shippuden:textures/dojutsu/ketsuryugan/ketsuryugan_2x2_pupils_1x2.png"))
							.render((AbstractClientPlayerEntity) _evt.getEntity(), _evt.getEntity().rotationYaw, _evt.getPartialRenderTick(),
									_evt.getMatrixStack(), _evt.getBuffers(), _evt.getLight());
				}
			}
		}
		if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).sharinganactivate == true) {
			if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).sharingan == true) {
				if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).dojutsusharingan).equals("1x1")) {
					if (_evt.getRenderer() instanceof PlayerRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						new com.kleiders.kleidersplayerrenderer.InternalPlayerRenderer(_evt.getRenderer().getRenderManager(),
								new ResourceLocation("naruto_shippuden:textures/dojutsu/sharingan/sharingan2px1px.png"))
								.render((AbstractClientPlayerEntity) _evt.getEntity(), _evt.getEntity().rotationYaw, _evt.getPartialRenderTick(),
										_evt.getMatrixStack(), _evt.getBuffers(), _evt.getLight());
					}
				} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).dojutsusharingan).equals("2x1")) {
					if (_evt.getRenderer() instanceof PlayerRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						new com.kleiders.kleidersplayerrenderer.InternalPlayerRenderer(_evt.getRenderer().getRenderManager(),
								new ResourceLocation("naruto_shippuden:textures/dojutsu/sharingan/sharingan2px1px2.png"))
								.render((AbstractClientPlayerEntity) _evt.getEntity(), _evt.getEntity().rotationYaw, _evt.getPartialRenderTick(),
										_evt.getMatrixStack(), _evt.getBuffers(), _evt.getLight());
					}
				} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).dojutsusharingan).equals("1x2")) {
					if (_evt.getRenderer() instanceof PlayerRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						new com.kleiders.kleidersplayerrenderer.InternalPlayerRenderer(_evt.getRenderer().getRenderManager(),
								new ResourceLocation("naruto_shippuden:textures/dojutsu/sharingan/sharingan2px2px2.png"))
								.render((AbstractClientPlayerEntity) _evt.getEntity(), _evt.getEntity().rotationYaw, _evt.getPartialRenderTick(),
										_evt.getMatrixStack(), _evt.getBuffers(), _evt.getLight());
					}
				} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).dojutsusharingan).equals("2x2")) {
					if (_evt.getRenderer() instanceof PlayerRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						new com.kleiders.kleidersplayerrenderer.InternalPlayerRenderer(_evt.getRenderer().getRenderManager(),
								new ResourceLocation("naruto_shippuden:textures/dojutsu/sharingan/sharingan2px2px1.png"))
								.render((AbstractClientPlayerEntity) _evt.getEntity(), _evt.getEntity().rotationYaw, _evt.getPartialRenderTick(),
										_evt.getMatrixStack(), _evt.getBuffers(), _evt.getLight());
					}
				}
			}
			if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).SharinganKakashi == true) {
				if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).dojutsusharingan).equals("1x1")) {
					if (_evt.getRenderer() instanceof PlayerRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						new com.kleiders.kleidersplayerrenderer.InternalPlayerRenderer(_evt.getRenderer().getRenderManager(),
								new ResourceLocation("naruto_shippuden:textures/dojutsu/sharingan/kakashi/kakashisharingan2px1px.png"))
								.render((AbstractClientPlayerEntity) _evt.getEntity(), _evt.getEntity().rotationYaw, _evt.getPartialRenderTick(),
										_evt.getMatrixStack(), _evt.getBuffers(), _evt.getLight());
					}
				} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).dojutsusharingan).equals("2x1")) {
					if (_evt.getRenderer() instanceof PlayerRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						new com.kleiders.kleidersplayerrenderer.InternalPlayerRenderer(_evt.getRenderer().getRenderManager(),
								new ResourceLocation("naruto_shippuden:textures/dojutsu/sharingan/kakashi/kakashisharingan2px1px2.png"))
								.render((AbstractClientPlayerEntity) _evt.getEntity(), _evt.getEntity().rotationYaw, _evt.getPartialRenderTick(),
										_evt.getMatrixStack(), _evt.getBuffers(), _evt.getLight());
					}
				} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).dojutsusharingan).equals("1x2")) {
					if (_evt.getRenderer() instanceof PlayerRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						new com.kleiders.kleidersplayerrenderer.InternalPlayerRenderer(_evt.getRenderer().getRenderManager(),
								new ResourceLocation("naruto_shippuden:textures/dojutsu/sharingan/kakashi/kakashisharingan2px2px2.png"))
								.render((AbstractClientPlayerEntity) _evt.getEntity(), _evt.getEntity().rotationYaw, _evt.getPartialRenderTick(),
										_evt.getMatrixStack(), _evt.getBuffers(), _evt.getLight());
					}
				} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).dojutsusharingan).equals("2x2")) {
					if (_evt.getRenderer() instanceof PlayerRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						new com.kleiders.kleidersplayerrenderer.InternalPlayerRenderer(_evt.getRenderer().getRenderManager(),
								new ResourceLocation("naruto_shippuden:textures/dojutsu/sharingan/kakashi/kakashisharingan2px2px1.png"))
								.render((AbstractClientPlayerEntity) _evt.getEntity(), _evt.getEntity().rotationYaw, _evt.getPartialRenderTick(),
										_evt.getMatrixStack(), _evt.getBuffers(), _evt.getLight());
					}
				}
			}
		}
		if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).MangekyouSharinganActivate == true) {
			if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).MangekyouSharinganSasuke == true) {
				if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).dojutsums).equals("1x1")) {
					if (_evt.getRenderer() instanceof PlayerRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						new com.kleiders.kleidersplayerrenderer.InternalPlayerRenderer(_evt.getRenderer().getRenderManager(),
								new ResourceLocation("naruto_shippuden:textures/dojutsu/mangekyou_sharingan/sasuke/sasukemangekyo2px1px.png"))
								.render((AbstractClientPlayerEntity) _evt.getEntity(), _evt.getEntity().rotationYaw, _evt.getPartialRenderTick(),
										_evt.getMatrixStack(), _evt.getBuffers(), _evt.getLight());
					}
				} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).dojutsums).equals("2x1")) {
					if (_evt.getRenderer() instanceof PlayerRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						new com.kleiders.kleidersplayerrenderer.InternalPlayerRenderer(_evt.getRenderer().getRenderManager(),
								new ResourceLocation("naruto_shippuden:textures/dojutsu/mangekyou_sharingan/sasuke/sasukemangekyo2px1px2.png"))
								.render((AbstractClientPlayerEntity) _evt.getEntity(), _evt.getEntity().rotationYaw, _evt.getPartialRenderTick(),
										_evt.getMatrixStack(), _evt.getBuffers(), _evt.getLight());
					}
				} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).dojutsums).equals("1x2")) {
					if (_evt.getRenderer() instanceof PlayerRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						new com.kleiders.kleidersplayerrenderer.InternalPlayerRenderer(_evt.getRenderer().getRenderManager(),
								new ResourceLocation("naruto_shippuden:textures/dojutsu/mangekyou_sharingan/sasuke/sasukemangekyo2px2px2.png"))
								.render((AbstractClientPlayerEntity) _evt.getEntity(), _evt.getEntity().rotationYaw, _evt.getPartialRenderTick(),
										_evt.getMatrixStack(), _evt.getBuffers(), _evt.getLight());
					}
				} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).dojutsums).equals("2x2")) {
					if (_evt.getRenderer() instanceof PlayerRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						new com.kleiders.kleidersplayerrenderer.InternalPlayerRenderer(_evt.getRenderer().getRenderManager(),
								new ResourceLocation("naruto_shippuden:textures/dojutsu/mangekyou_sharingan/sasuke/sasukemangekyo2px2px1.png"))
								.render((AbstractClientPlayerEntity) _evt.getEntity(), _evt.getEntity().rotationYaw, _evt.getPartialRenderTick(),
										_evt.getMatrixStack(), _evt.getBuffers(), _evt.getLight());
					}
				}
			} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).MangekyouSharinganItachi == true) {
				if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).dojutsums).equals("1x1")) {
					if (_evt.getRenderer() instanceof PlayerRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						new com.kleiders.kleidersplayerrenderer.InternalPlayerRenderer(_evt.getRenderer().getRenderManager(),
								new ResourceLocation("naruto_shippuden:textures/dojutsu/mangekyou_sharingan/itachi/itachimangekyo2px1px.png"))
								.render((AbstractClientPlayerEntity) _evt.getEntity(), _evt.getEntity().rotationYaw, _evt.getPartialRenderTick(),
										_evt.getMatrixStack(), _evt.getBuffers(), _evt.getLight());
					}
				} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).dojutsums).equals("2x1")) {
					if (_evt.getRenderer() instanceof PlayerRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						new com.kleiders.kleidersplayerrenderer.InternalPlayerRenderer(_evt.getRenderer().getRenderManager(),
								new ResourceLocation("naruto_shippuden:textures/dojutsu/mangekyou_sharingan/itachi/itachimangekyo2px1px2.png"))
								.render((AbstractClientPlayerEntity) _evt.getEntity(), _evt.getEntity().rotationYaw, _evt.getPartialRenderTick(),
										_evt.getMatrixStack(), _evt.getBuffers(), _evt.getLight());
					}
				} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).dojutsums).equals("1x2")) {
					if (_evt.getRenderer() instanceof PlayerRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						new com.kleiders.kleidersplayerrenderer.InternalPlayerRenderer(_evt.getRenderer().getRenderManager(),
								new ResourceLocation("naruto_shippuden:textures/dojutsu/mangekyou_sharingan/itachi/itachimangekyo2px2px2.png"))
								.render((AbstractClientPlayerEntity) _evt.getEntity(), _evt.getEntity().rotationYaw, _evt.getPartialRenderTick(),
										_evt.getMatrixStack(), _evt.getBuffers(), _evt.getLight());
					}
				} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).dojutsums).equals("2x2")) {
					if (_evt.getRenderer() instanceof PlayerRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						new com.kleiders.kleidersplayerrenderer.InternalPlayerRenderer(_evt.getRenderer().getRenderManager(),
								new ResourceLocation("naruto_shippuden:textures/dojutsu/mangekyou_sharingan/itachi/itachimangekyo2px2px1.png"))
								.render((AbstractClientPlayerEntity) _evt.getEntity(), _evt.getEntity().rotationYaw, _evt.getPartialRenderTick(),
										_evt.getMatrixStack(), _evt.getBuffers(), _evt.getLight());
					}
				}
			} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).MangekyouSharinganMadara == true) {
				if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).dojutsums).equals("1x1")) {
					if (_evt.getRenderer() instanceof PlayerRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						new com.kleiders.kleidersplayerrenderer.InternalPlayerRenderer(_evt.getRenderer().getRenderManager(),
								new ResourceLocation("naruto_shippuden:textures/dojutsu/mangekyou_sharingan/madara/madaramangekyo2px1px.png"))
								.render((AbstractClientPlayerEntity) _evt.getEntity(), _evt.getEntity().rotationYaw, _evt.getPartialRenderTick(),
										_evt.getMatrixStack(), _evt.getBuffers(), _evt.getLight());
					}
				} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).dojutsums).equals("2x1")) {
					if (_evt.getRenderer() instanceof PlayerRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						new com.kleiders.kleidersplayerrenderer.InternalPlayerRenderer(_evt.getRenderer().getRenderManager(),
								new ResourceLocation("naruto_shippuden:textures/dojutsu/mangekyou_sharingan/madara/madaramangekyo2px1px2.png"))
								.render((AbstractClientPlayerEntity) _evt.getEntity(), _evt.getEntity().rotationYaw, _evt.getPartialRenderTick(),
										_evt.getMatrixStack(), _evt.getBuffers(), _evt.getLight());
					}
				} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).dojutsums).equals("1x2")) {
					if (_evt.getRenderer() instanceof PlayerRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						new com.kleiders.kleidersplayerrenderer.InternalPlayerRenderer(_evt.getRenderer().getRenderManager(),
								new ResourceLocation("naruto_shippuden:textures/dojutsu/mangekyou_sharingan/madara/madaramangekyo2px2px2.png"))
								.render((AbstractClientPlayerEntity) _evt.getEntity(), _evt.getEntity().rotationYaw, _evt.getPartialRenderTick(),
										_evt.getMatrixStack(), _evt.getBuffers(), _evt.getLight());
					}
				} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).dojutsums).equals("2x2")) {
					if (_evt.getRenderer() instanceof PlayerRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						new com.kleiders.kleidersplayerrenderer.InternalPlayerRenderer(_evt.getRenderer().getRenderManager(),
								new ResourceLocation("naruto_shippuden:textures/dojutsu/mangekyou_sharingan/madara/madaramangekyo2px2px1.png"))
								.render((AbstractClientPlayerEntity) _evt.getEntity(), _evt.getEntity().rotationYaw, _evt.getPartialRenderTick(),
										_evt.getMatrixStack(), _evt.getBuffers(), _evt.getLight());
					}
				}
			} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).MangekyouSharinganObito == true) {
				if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).dojutsums).equals("1x1")) {
					if (_evt.getRenderer() instanceof PlayerRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						new com.kleiders.kleidersplayerrenderer.InternalPlayerRenderer(_evt.getRenderer().getRenderManager(),
								new ResourceLocation("naruto_shippuden:textures/dojutsu/mangekyou_sharingan/obito/obitomangekyo2px1px.png"))
								.render((AbstractClientPlayerEntity) _evt.getEntity(), _evt.getEntity().rotationYaw, _evt.getPartialRenderTick(),
										_evt.getMatrixStack(), _evt.getBuffers(), _evt.getLight());
					}
				} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).dojutsums).equals("2x1")) {
					if (_evt.getRenderer() instanceof PlayerRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						new com.kleiders.kleidersplayerrenderer.InternalPlayerRenderer(_evt.getRenderer().getRenderManager(),
								new ResourceLocation("naruto_shippuden:textures/dojutsu/mangekyou_sharingan/obito/obitomangekyo2px1px2"))
								.render((AbstractClientPlayerEntity) _evt.getEntity(), _evt.getEntity().rotationYaw, _evt.getPartialRenderTick(),
										_evt.getMatrixStack(), _evt.getBuffers(), _evt.getLight());
					}
				} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).dojutsums).equals("1x2")) {
					if (_evt.getRenderer() instanceof PlayerRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						new com.kleiders.kleidersplayerrenderer.InternalPlayerRenderer(_evt.getRenderer().getRenderManager(),
								new ResourceLocation("naruto_shippuden:textures/dojutsu/mangekyou_sharingan/obito/obitomangekyo2px2px2.png"))
								.render((AbstractClientPlayerEntity) _evt.getEntity(), _evt.getEntity().rotationYaw, _evt.getPartialRenderTick(),
										_evt.getMatrixStack(), _evt.getBuffers(), _evt.getLight());
					}
				} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).dojutsums).equals("2x2")) {
					if (_evt.getRenderer() instanceof PlayerRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						new com.kleiders.kleidersplayerrenderer.InternalPlayerRenderer(_evt.getRenderer().getRenderManager(),
								new ResourceLocation("naruto_shippuden:textures/dojutsu/mangekyou_sharingan/obito/obitomangekyo2px2px1.png"))
								.render((AbstractClientPlayerEntity) _evt.getEntity(), _evt.getEntity().rotationYaw, _evt.getPartialRenderTick(),
										_evt.getMatrixStack(), _evt.getBuffers(), _evt.getLight());
					}
				}
			} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).MangekyouSharinganShisui == true) {
				if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).dojutsums).equals("1x1")) {
					if (_evt.getRenderer() instanceof PlayerRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						new com.kleiders.kleidersplayerrenderer.InternalPlayerRenderer(_evt.getRenderer().getRenderManager(),
								new ResourceLocation("naruto_shippuden:textures/dojutsu/mangekyou_sharingan/shisui/shisuimangekyo2px1px.png"))
								.render((AbstractClientPlayerEntity) _evt.getEntity(), _evt.getEntity().rotationYaw, _evt.getPartialRenderTick(),
										_evt.getMatrixStack(), _evt.getBuffers(), _evt.getLight());
					}
				} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).dojutsums).equals("2x1")) {
					if (_evt.getRenderer() instanceof PlayerRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						new com.kleiders.kleidersplayerrenderer.InternalPlayerRenderer(_evt.getRenderer().getRenderManager(),
								new ResourceLocation("naruto_shippuden:textures/dojutsu/mangekyou_sharingan/shisui/shisuimangekyo2px1px2.png"))
								.render((AbstractClientPlayerEntity) _evt.getEntity(), _evt.getEntity().rotationYaw, _evt.getPartialRenderTick(),
										_evt.getMatrixStack(), _evt.getBuffers(), _evt.getLight());
					}
				} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).dojutsums).equals("1x2")) {
					if (_evt.getRenderer() instanceof PlayerRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						new com.kleiders.kleidersplayerrenderer.InternalPlayerRenderer(_evt.getRenderer().getRenderManager(),
								new ResourceLocation("naruto_shippuden:textures/dojutsu/mangekyou_sharingan/shisui/shisuimangekyo2px2px2.png"))
								.render((AbstractClientPlayerEntity) _evt.getEntity(), _evt.getEntity().rotationYaw, _evt.getPartialRenderTick(),
										_evt.getMatrixStack(), _evt.getBuffers(), _evt.getLight());
					}
				} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).dojutsums).equals("2x2")) {
					if (_evt.getRenderer() instanceof PlayerRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						new com.kleiders.kleidersplayerrenderer.InternalPlayerRenderer(_evt.getRenderer().getRenderManager(),
								new ResourceLocation("naruto_shippuden:textures/dojutsu/mangekyou_sharingan/shisui/shisuimangekyo2px2px1.png"))
								.render((AbstractClientPlayerEntity) _evt.getEntity(), _evt.getEntity().rotationYaw, _evt.getPartialRenderTick(),
										_evt.getMatrixStack(), _evt.getBuffers(), _evt.getLight());
					}
				}
			} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).MangekyouSharinganKakashi == true) {
				if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).dojutsums).equals("1x1")) {
					if (_evt.getRenderer() instanceof PlayerRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						new com.kleiders.kleidersplayerrenderer.InternalPlayerRenderer(_evt.getRenderer().getRenderManager(),
								new ResourceLocation("naruto_shippuden:textures/dojutsu/mangekyou_sharingan/kakashi/kakashimangekyo2px1px.png"))
								.render((AbstractClientPlayerEntity) _evt.getEntity(), _evt.getEntity().rotationYaw, _evt.getPartialRenderTick(),
										_evt.getMatrixStack(), _evt.getBuffers(), _evt.getLight());
					}
				} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).dojutsums).equals("2x1")) {
					if (_evt.getRenderer() instanceof PlayerRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						new com.kleiders.kleidersplayerrenderer.InternalPlayerRenderer(_evt.getRenderer().getRenderManager(),
								new ResourceLocation("naruto_shippuden:textures/dojutsu/mangekyou_sharingan/kakashi/kakashimangekyo2px1px2.png"))
								.render((AbstractClientPlayerEntity) _evt.getEntity(), _evt.getEntity().rotationYaw, _evt.getPartialRenderTick(),
										_evt.getMatrixStack(), _evt.getBuffers(), _evt.getLight());
					}
				} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).dojutsums).equals("1x2")) {
					if (_evt.getRenderer() instanceof PlayerRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						new com.kleiders.kleidersplayerrenderer.InternalPlayerRenderer(_evt.getRenderer().getRenderManager(),
								new ResourceLocation("naruto_shippuden:textures/dojutsu/mangekyou_sharingan/kakashi/kakashimangekyo2px2px2.png"))
								.render((AbstractClientPlayerEntity) _evt.getEntity(), _evt.getEntity().rotationYaw, _evt.getPartialRenderTick(),
										_evt.getMatrixStack(), _evt.getBuffers(), _evt.getLight());
					}
				} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).dojutsums).equals("2x2")) {
					if (_evt.getRenderer() instanceof PlayerRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						new com.kleiders.kleidersplayerrenderer.InternalPlayerRenderer(_evt.getRenderer().getRenderManager(),
								new ResourceLocation("naruto_shippuden:textures/dojutsu/mangekyou_sharingan/kakashi/kakashimangekyo2px2px1.png"))
								.render((AbstractClientPlayerEntity) _evt.getEntity(), _evt.getEntity().rotationYaw, _evt.getPartialRenderTick(),
										_evt.getMatrixStack(), _evt.getBuffers(), _evt.getLight());
					}
				}
			}
		}
		if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).rinneganactivate == true) {
			if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).dojutsurinnegan).equals("1x1")) {
				if (_evt.getRenderer() instanceof PlayerRenderer) {
					if (_evt instanceof RenderLivingEvent.Pre) {
						//  _evt.setCanceled(true); 
					}
					new com.kleiders.kleidersplayerrenderer.InternalPlayerRenderer(_evt.getRenderer().getRenderManager(),
							new ResourceLocation("naruto_shippuden:textures/dojutsu/rinnegan/rinnegan_2x1_pupils_1x1.png"))
							.render((AbstractClientPlayerEntity) _evt.getEntity(), _evt.getEntity().rotationYaw, _evt.getPartialRenderTick(),
									_evt.getMatrixStack(), _evt.getBuffers(), _evt.getLight());
				}
			} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).dojutsurinnegan).equals("2x1")) {
				if (_evt.getRenderer() instanceof PlayerRenderer) {
					if (_evt instanceof RenderLivingEvent.Pre) {
						//  _evt.setCanceled(true); 
					}
					new com.kleiders.kleidersplayerrenderer.InternalPlayerRenderer(_evt.getRenderer().getRenderManager(),
							new ResourceLocation("naruto_shippuden:textures/dojutsu/rinnegan/rinnegan_2x1_pupils_2x1.png"))
							.render((AbstractClientPlayerEntity) _evt.getEntity(), _evt.getEntity().rotationYaw, _evt.getPartialRenderTick(),
									_evt.getMatrixStack(), _evt.getBuffers(), _evt.getLight());
				}
			} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).dojutsurinnegan).equals("1x2")) {
				if (_evt.getRenderer() instanceof PlayerRenderer) {
					if (_evt instanceof RenderLivingEvent.Pre) {
						//  _evt.setCanceled(true); 
					}
					new com.kleiders.kleidersplayerrenderer.InternalPlayerRenderer(_evt.getRenderer().getRenderManager(),
							new ResourceLocation("naruto_shippuden:textures/dojutsu/rinnegan/rinnegan_2x2_pupils_1x1.png"))
							.render((AbstractClientPlayerEntity) _evt.getEntity(), _evt.getEntity().rotationYaw, _evt.getPartialRenderTick(),
									_evt.getMatrixStack(), _evt.getBuffers(), _evt.getLight());
				}
			} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).dojutsurinnegan).equals("2x2")) {
				if (_evt.getRenderer() instanceof PlayerRenderer) {
					if (_evt instanceof RenderLivingEvent.Pre) {
						//  _evt.setCanceled(true); 
					}
					new com.kleiders.kleidersplayerrenderer.InternalPlayerRenderer(_evt.getRenderer().getRenderManager(),
							new ResourceLocation("naruto_shippuden:textures/dojutsu/rinnegan/rinnegan_2x2_pupils_1x2.png"))
							.render((AbstractClientPlayerEntity) _evt.getEntity(), _evt.getEntity().rotationYaw, _evt.getPartialRenderTick(),
									_evt.getMatrixStack(), _evt.getBuffers(), _evt.getLight());
				}
			}
		}
		if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).tenseiganactivate == true) {
			if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).dojutsutenseigan).equals("1x1")) {
				if (_evt.getRenderer() instanceof PlayerRenderer) {
					if (_evt instanceof RenderLivingEvent.Pre) {
						//  _evt.setCanceled(true); 
					}
					new com.kleiders.kleidersplayerrenderer.InternalPlayerRenderer(_evt.getRenderer().getRenderManager(),
							new ResourceLocation("naruto_shippuden:textures/dojutsu/tenseigan/tenseigan_2x1_pupils_1x1.png"))
							.render((AbstractClientPlayerEntity) _evt.getEntity(), _evt.getEntity().rotationYaw, _evt.getPartialRenderTick(),
									_evt.getMatrixStack(), _evt.getBuffers(), _evt.getLight());
				}
			} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).dojutsutenseigan).equals("2x1")) {
				if (_evt.getRenderer() instanceof PlayerRenderer) {
					if (_evt instanceof RenderLivingEvent.Pre) {
						//  _evt.setCanceled(true); 
					}
					new com.kleiders.kleidersplayerrenderer.InternalPlayerRenderer(_evt.getRenderer().getRenderManager(),
							new ResourceLocation("naruto_shippuden:textures/dojutsu/tenseigan/tenseigan_2x1_pupils_2x1.png"))
							.render((AbstractClientPlayerEntity) _evt.getEntity(), _evt.getEntity().rotationYaw, _evt.getPartialRenderTick(),
									_evt.getMatrixStack(), _evt.getBuffers(), _evt.getLight());
				}
			} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).dojutsutenseigan).equals("1x2")) {
				if (_evt.getRenderer() instanceof PlayerRenderer) {
					if (_evt instanceof RenderLivingEvent.Pre) {
						//  _evt.setCanceled(true); 
					}
					new com.kleiders.kleidersplayerrenderer.InternalPlayerRenderer(_evt.getRenderer().getRenderManager(),
							new ResourceLocation("naruto_shippuden:textures/dojutsu/tenseigan/tenseigan_2x2_pupils_1x1.png"))
							.render((AbstractClientPlayerEntity) _evt.getEntity(), _evt.getEntity().rotationYaw, _evt.getPartialRenderTick(),
									_evt.getMatrixStack(), _evt.getBuffers(), _evt.getLight());
				}
			} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).dojutsutenseigan).equals("2x2")) {
				if (_evt.getRenderer() instanceof PlayerRenderer) {
					if (_evt instanceof RenderLivingEvent.Pre) {
						//  _evt.setCanceled(true); 
					}
					new com.kleiders.kleidersplayerrenderer.InternalPlayerRenderer(_evt.getRenderer().getRenderManager(),
							new ResourceLocation("naruto_shippuden:textures/dojutsu/tenseigan/tenseigan_2x2_pupils_1x2.png"))
							.render((AbstractClientPlayerEntity) _evt.getEntity(), _evt.getEntity().rotationYaw, _evt.getPartialRenderTick(),
									_evt.getMatrixStack(), _evt.getBuffers(), _evt.getLight());
				}
			}
		}
		if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).isshikidojutsuactivate == true) {
			if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).dojutsuisshiki).equals("1x1")) {
				if (_evt.getRenderer() instanceof PlayerRenderer) {
					if (_evt instanceof RenderLivingEvent.Pre) {
						//  _evt.setCanceled(true); 
					}
					new com.kleiders.kleidersplayerrenderer.InternalPlayerRenderer(_evt.getRenderer().getRenderManager(),
							new ResourceLocation("naruto_shippuden:textures/dojutsu/isshiki/isshiki_dojutsu_2x1_pupils_1x1.png"))
							.render((AbstractClientPlayerEntity) _evt.getEntity(), _evt.getEntity().rotationYaw, _evt.getPartialRenderTick(),
									_evt.getMatrixStack(), _evt.getBuffers(), _evt.getLight());
				}
			} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).dojutsuisshiki).equals("2x1")) {
				if (_evt.getRenderer() instanceof PlayerRenderer) {
					if (_evt instanceof RenderLivingEvent.Pre) {
						//  _evt.setCanceled(true); 
					}
					new com.kleiders.kleidersplayerrenderer.InternalPlayerRenderer(_evt.getRenderer().getRenderManager(),
							new ResourceLocation("naruto_shippuden:textures/dojutsu/isshiki/isshiki_dojutsu_2x1_pupils_2x1.png"))
							.render((AbstractClientPlayerEntity) _evt.getEntity(), _evt.getEntity().rotationYaw, _evt.getPartialRenderTick(),
									_evt.getMatrixStack(), _evt.getBuffers(), _evt.getLight());
				}
			} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).dojutsuisshiki).equals("1x2")) {
				if (_evt.getRenderer() instanceof PlayerRenderer) {
					if (_evt instanceof RenderLivingEvent.Pre) {
						//  _evt.setCanceled(true); 
					}
					new com.kleiders.kleidersplayerrenderer.InternalPlayerRenderer(_evt.getRenderer().getRenderManager(),
							new ResourceLocation("naruto_shippuden:textures/dojutsu/isshiki/isshiki_dojutsu_2x2_pupils_1x1.png"))
							.render((AbstractClientPlayerEntity) _evt.getEntity(), _evt.getEntity().rotationYaw, _evt.getPartialRenderTick(),
									_evt.getMatrixStack(), _evt.getBuffers(), _evt.getLight());
				}
			} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).dojutsuisshiki).equals("2x2")) {
				if (_evt.getRenderer() instanceof PlayerRenderer) {
					if (_evt instanceof RenderLivingEvent.Pre) {
						//  _evt.setCanceled(true); 
					}
					new com.kleiders.kleidersplayerrenderer.InternalPlayerRenderer(_evt.getRenderer().getRenderManager(),
							new ResourceLocation("naruto_shippuden:textures/dojutsu/isshiki/isshiki_dojutsu_2x2_pupils_1x2.png"))
							.render((AbstractClientPlayerEntity) _evt.getEntity(), _evt.getEntity().rotationYaw, _evt.getPartialRenderTick(),
									_evt.getMatrixStack(), _evt.getBuffers(), _evt.getLight());
				}
			}
		}
		if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).shimura_active == true) {
			if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).dojutsusharingan).equals("1x1")) {
				if (_evt.getRenderer() instanceof PlayerRenderer) {
					if (_evt instanceof RenderLivingEvent.Pre) {
						//  _evt.setCanceled(true); 
					}
					new com.kleiders.kleidersplayerrenderer.InternalPlayerRenderer(_evt.getRenderer().getRenderManager(),
							new ResourceLocation("naruto_shippuden:textures/dojutsu/shimura/sharingan2px1px.png"))
							.render((AbstractClientPlayerEntity) _evt.getEntity(), _evt.getEntity().rotationYaw, _evt.getPartialRenderTick(),
									_evt.getMatrixStack(), _evt.getBuffers(), _evt.getLight());
				}
			} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).dojutsusharingan).equals("2x1")) {
				if (_evt.getRenderer() instanceof PlayerRenderer) {
					if (_evt instanceof RenderLivingEvent.Pre) {
						//  _evt.setCanceled(true); 
					}
					new com.kleiders.kleidersplayerrenderer.InternalPlayerRenderer(_evt.getRenderer().getRenderManager(),
							new ResourceLocation("naruto_shippuden:textures/dojutsu/shimura/sharingan2px1px2.png"))
							.render((AbstractClientPlayerEntity) _evt.getEntity(), _evt.getEntity().rotationYaw, _evt.getPartialRenderTick(),
									_evt.getMatrixStack(), _evt.getBuffers(), _evt.getLight());
				}
			} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).dojutsusharingan).equals("1x2")) {
				if (_evt.getRenderer() instanceof PlayerRenderer) {
					if (_evt instanceof RenderLivingEvent.Pre) {
						//  _evt.setCanceled(true); 
					}
					new com.kleiders.kleidersplayerrenderer.InternalPlayerRenderer(_evt.getRenderer().getRenderManager(),
							new ResourceLocation("naruto_shippuden:textures/dojutsu/shimura/sharingan2px2px2.png"))
							.render((AbstractClientPlayerEntity) _evt.getEntity(), _evt.getEntity().rotationYaw, _evt.getPartialRenderTick(),
									_evt.getMatrixStack(), _evt.getBuffers(), _evt.getLight());
				}
			} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).dojutsusharingan).equals("2x2")) {
				if (_evt.getRenderer() instanceof PlayerRenderer) {
					if (_evt instanceof RenderLivingEvent.Pre) {
						//  _evt.setCanceled(true); 
					}
					new com.kleiders.kleidersplayerrenderer.InternalPlayerRenderer(_evt.getRenderer().getRenderManager(),
							new ResourceLocation("naruto_shippuden:textures/dojutsu/shimura/sharingan2px2px1.png"))
							.render((AbstractClientPlayerEntity) _evt.getEntity(), _evt.getEntity().rotationYaw, _evt.getPartialRenderTick(),
									_evt.getMatrixStack(), _evt.getBuffers(), _evt.getLight());
				}
			}
			if (_evt.getRenderer() instanceof PlayerRenderer) {
				if (_evt instanceof RenderLivingEvent.Pre) {
					//  _evt.setCanceled(true); 
				}
				new com.kleiders.kleidersplayerrenderer.InternalPlayerRenderer(_evt.getRenderer().getRenderManager(),
						new ResourceLocation("naruto_shippuden:textures/dojutsu/shimura/shimura_body.png"))
						.render((AbstractClientPlayerEntity) _evt.getEntity(), _evt.getEntity().rotationYaw, _evt.getPartialRenderTick(),
								_evt.getMatrixStack(), _evt.getBuffers(), _evt.getLight());
			}
			if (_evt.getRenderer() instanceof PlayerRenderer) {
				if (_evt instanceof RenderLivingEvent.Pre) {
					//  _evt.setCanceled(true); 
				}
				new com.kleiders.kleidersplayerrenderer.InternalPlayerRenderer(_evt.getRenderer().getRenderManager(),
						new ResourceLocation("naruto_shippuden:textures/dojutsu/shimura/shimura_head_open.png"))
						.render((AbstractClientPlayerEntity) _evt.getEntity(), _evt.getEntity().rotationYaw, _evt.getPartialRenderTick(),
								_evt.getMatrixStack(), _evt.getBuffers(), _evt.getLight());
			}
		} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).shimura_active == false) {
			if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).shimurareleaselogic == true) {
				if (_evt.getRenderer() instanceof PlayerRenderer) {
					if (_evt instanceof RenderLivingEvent.Pre) {
						//  _evt.setCanceled(true); 
					}
					new com.kleiders.kleidersplayerrenderer.InternalPlayerRenderer(_evt.getRenderer().getRenderManager(),
							new ResourceLocation("naruto_shippuden:textures/dojutsu/shimura/shimura_body.png"))
							.render((AbstractClientPlayerEntity) _evt.getEntity(), _evt.getEntity().rotationYaw, _evt.getPartialRenderTick(),
									_evt.getMatrixStack(), _evt.getBuffers(), _evt.getLight());
				}
				if (_evt.getRenderer() instanceof PlayerRenderer) {
					if (_evt instanceof RenderLivingEvent.Pre) {
						//  _evt.setCanceled(true); 
					}
					new com.kleiders.kleidersplayerrenderer.InternalPlayerRenderer(_evt.getRenderer().getRenderManager(),
							new ResourceLocation("naruto_shippuden:textures/dojutsu/shimura/shimura_head.png"))
							.render((AbstractClientPlayerEntity) _evt.getEntity(), _evt.getEntity().rotationYaw, _evt.getPartialRenderTick(),
									_evt.getMatrixStack(), _evt.getBuffers(), _evt.getLight());
				}
			}
		}
	}
}
