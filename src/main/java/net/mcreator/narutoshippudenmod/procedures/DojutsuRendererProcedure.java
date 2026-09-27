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
import net.mcreator.narutoshippudenmod.core.ModelSwapRenderers;
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
