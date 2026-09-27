package net.mcreator.narutoshippudenmod.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.entity.PlayerRenderer;
import net.minecraft.client.entity.player.AbstractClientPlayerEntity;

import net.mcreator.narutoshippudenmod.entity.renderer.WolfRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.TwoHeadAkamaruRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.ThreeHeadAkamaruRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.SpikedHumanBulletTankRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.SkeletonSusanoShisuiRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.SkeletonSusanoSasukeRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.SkeletonSusanoObitoRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.SkeletonSusanoMadaraRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.SkeletonSusanoItachiRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.RibcageSusanoRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.MonsterCatRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.MagnetWingsRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.MagnetHandsSneakRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.MagnetHandsRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.MagnetCoatSneakRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.MagnetCoatRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.InsectJarTechniqueRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.IceMirrorRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.HumanoidSusanoShisuiRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.HumanoidSusanoSasukeRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.HumanoidSusanoObitoRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.HumanoidSusanoMadaraRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.HumanoidSusanoItachiRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.HumanBulletTankRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.FangRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.EightTrigramsPalmsRevolvingHeavenRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.DrowningWaterBlobTechniqueEntitySneakRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.DrowningWaterBlobTechniqueEntityRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.DeadDemonConsumingSealRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.DanceoftheLarchSneakRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.DanceOfTheLarchRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.CatChakraModeSneakRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.CatChakraModeRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.ButterflyModeRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.ArmoredSusanoShisuiRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.ArmoredSusanoSasukeRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.ArmoredSusanoMadaraRenderer;
import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables;
import net.mcreator.narutoshippudenmod.core.ModelSwapRenderers;
import net.mcreator.narutoshippudenmod.NarutoShippudenMod;

import java.util.Map;
import java.util.HashMap;

import java.io.File;

public class PlayerModelChangeProcedure {
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
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure PlayerModelChange!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		File playerskin = new File("");

		// Enter the FTL code here
		Object _obj = dependencies.get("event");
		RenderLivingEvent _evt = (RenderLivingEvent) _obj;
		if (NarutoShippudenModVariables.get(entity).inuzuka_mode == 1) {
			if (_evt.getRenderer() instanceof PlayerRenderer) {
				if (_evt instanceof RenderLivingEvent.Pre) {
					_evt.setCanceled(true);
				}
				ModelSwapRenderers.renderPlayerAs(_evt, "naruto_shippuden:textures/entities/two_head_akamaru.png", TwoHeadAkamaruRenderer.ModelTwo_Head_Akamaru::new);
			}
		}
		if (NarutoShippudenModVariables.get(entity).inuzuka_mode == 2) {
			if (_evt.getRenderer() instanceof PlayerRenderer) {
				if (_evt instanceof RenderLivingEvent.Pre) {
					_evt.setCanceled(true);
				}
				ModelSwapRenderers.renderPlayerAs(_evt, "naruto_shippuden:textures/entities/two_head_akamaru.png", ThreeHeadAkamaruRenderer.ModelThree_Head_Akamaru::new);
			}
		}
		if (NarutoShippudenModVariables.get(entity).PassingFang == true) {
			if (_evt.getRenderer() instanceof PlayerRenderer) {
				if (_evt instanceof RenderLivingEvent.Pre) {
					_evt.setCanceled(true);
				}
				ModelSwapRenderers.renderPlayerAs(_evt, "naruto_shippuden:textures/entities/passing_fang.png", FangRenderer.Modelfang::new);
			}
		}
		if (NarutoShippudenModVariables.get(entity).tenromode == true) {
			if (_evt.getRenderer() instanceof PlayerRenderer) {
				if (_evt instanceof RenderLivingEvent.Pre) {
					_evt.setCanceled(true);
				}
				ModelSwapRenderers.renderPlayerAs(_evt, "naruto_shippuden:textures/entities/wolf.png", WolfRenderer.Modelwolf::new);
			}
		}
		if (NarutoShippudenModVariables.get(entity).izunochakramode == true) {
			if (entity.isSneaking()) {
				if (_evt.getRenderer() instanceof PlayerRenderer) {
					if (_evt instanceof RenderLivingEvent.Pre) {
						//  _evt.setCanceled(true); 
					}
					ModelSwapRenderers.renderPlayerAs(_evt, "naruto_shippuden:textures/entities/catchakramode.png", CatChakraModeSneakRenderer.Modelcatchakramodesneak::new);
				}
			} else if (!entity.isSneaking()) {
				if (_evt.getRenderer() instanceof PlayerRenderer) {
					if (_evt instanceof RenderLivingEvent.Pre) {
						//  _evt.setCanceled(true); 
					}
					ModelSwapRenderers.renderPlayerAs(_evt, "naruto_shippuden:textures/entities/catchakramode.png", CatChakraModeRenderer.Modelcatchakramode::new);
				}
			}
		}
		if (NarutoShippudenModVariables.get(entity).izunocat == true) {
			if (_evt.getRenderer() instanceof PlayerRenderer) {
				if (_evt instanceof RenderLivingEvent.Pre) {
					_evt.setCanceled(true);
				}
				ModelSwapRenderers.renderPlayerAs(_evt, "naruto_shippuden:textures/entities/monstercat.png", MonsterCatRenderer.Modelmonstercat::new);
			}
		}
		if (entity.getPersistentData().getBoolean("mirror") == true) {
			if (!ModelSwapRenderers.isOwnRenderer(_evt.getRenderer())) {
				if (_evt instanceof RenderLivingEvent.Pre) {
					//  _evt.setCanceled(true); 
				}
				ModelSwapRenderers.renderMobAs(_evt, "naruto_shippuden:textures/entities/mirror.png", IceMirrorRenderer.Modelice_mirror::new);
			}
		}
		if (NarutoShippudenModVariables.get(entity).ice_mirror == true) {
			if (_evt.getRenderer() instanceof PlayerRenderer) {
				if (_evt instanceof RenderLivingEvent.Pre) {
					//  _evt.setCanceled(true); 
				}
				ModelSwapRenderers.renderPlayerAs(_evt, "naruto_shippuden:textures/entities/mirror.png", IceMirrorRenderer.Modelice_mirror::new);
			}
		}
		if (entity.getPersistentData().getBoolean("waterblob") == true) {
			if (!ModelSwapRenderers.isOwnRenderer(_evt.getRenderer())) {
				if (_evt instanceof RenderLivingEvent.Pre) {
					//  _evt.setCanceled(true); 
				}
				ModelSwapRenderers.renderMobAs(_evt, "naruto_shippuden:textures/entities/drowning_water_blob_technique.png", DrowningWaterBlobTechniqueEntityRenderer.ModelDrowning_Water_Blob_Technique::new);
			}
		}
		if (NarutoShippudenModVariables.get(entity).waterblob == true) {
			if (entity.isSneaking()) {
				if (_evt.getRenderer() instanceof PlayerRenderer) {
					if (_evt instanceof RenderLivingEvent.Pre) {
						//  _evt.setCanceled(true); 
					}
					ModelSwapRenderers.renderPlayerAs(_evt, "naruto_shippuden:textures/entities/drowning_water_blob_technique.png", DrowningWaterBlobTechniqueEntitySneakRenderer.ModelDrowning_Water_Blob_Technique_Sneak::new);
				}
			} else if (!entity.isSneaking()) {
				if (_evt.getRenderer() instanceof PlayerRenderer) {
					if (_evt instanceof RenderLivingEvent.Pre) {
						//  _evt.setCanceled(true); 
					}
					ModelSwapRenderers.renderPlayerAs(_evt, "naruto_shippuden:textures/entities/drowning_water_blob_technique.png", DrowningWaterBlobTechniqueEntityRenderer.ModelDrowning_Water_Blob_Technique::new);
				}
			}
		}
		if (NarutoShippudenModVariables.get(entity).DanceOfTheLarch == true) {
			if (entity.isSneaking()) {
				if (_evt.getRenderer() instanceof PlayerRenderer) {
					if (_evt instanceof RenderLivingEvent.Pre) {
						//  _evt.setCanceled(true); 
					}
					ModelSwapRenderers.renderPlayerAs(_evt, "naruto_shippuden:textures/entities/bone.png", DanceoftheLarchSneakRenderer.ModelDance_of_the_Larch_Sneak::new);
				}
			} else if (!entity.isSneaking()) {
				if (_evt.getRenderer() instanceof PlayerRenderer) {
					if (_evt instanceof RenderLivingEvent.Pre) {
						//  _evt.setCanceled(true); 
					}
					ModelSwapRenderers.renderPlayerAs(_evt, "naruto_shippuden:textures/entities/bone.png", DanceOfTheLarchRenderer.ModelDance_of_the_Larch::new);
				}
			}
		}
		if (NarutoShippudenModVariables.get(entity).hoshigakireleaselogic == true) {
			if (_evt.getRenderer() instanceof PlayerRenderer) {
				if (_evt instanceof RenderLivingEvent.Pre) {
					//  _evt.setCanceled(true); 
				}
				ModelSwapRenderers.renderDojutsu(_evt, "naruto_shippuden:textures/face_paint/hoshigaki.png");
			}
		}
		if (NarutoShippudenModVariables.get(entity).magnet_coat == 1) {
			if (entity.isSneaking()) {
				if (_evt.getRenderer() instanceof PlayerRenderer) {
					if (_evt instanceof RenderLivingEvent.Pre) {
						//  _evt.setCanceled(true); 
					}
					ModelSwapRenderers.renderPlayerAs(_evt, "naruto_shippuden:textures/entities/iron_sand.png", MagnetCoatSneakRenderer.ModelBlack_Iron_Sand_Coat_Sneak::new);
				}
			} else if (!entity.isSneaking()) {
				if (_evt.getRenderer() instanceof PlayerRenderer) {
					if (_evt instanceof RenderLivingEvent.Pre) {
						//  _evt.setCanceled(true); 
					}
					ModelSwapRenderers.renderPlayerAs(_evt, "naruto_shippuden:textures/entities/iron_sand.png", MagnetCoatRenderer.ModelBlack_Iron_Sand_Coat::new);
				}
			}
		} else if (NarutoShippudenModVariables.get(entity).magnet_coat == 2) {
			if (entity.isSneaking()) {
				if (_evt.getRenderer() instanceof PlayerRenderer) {
					if (_evt instanceof RenderLivingEvent.Pre) {
						//  _evt.setCanceled(true); 
					}
					ModelSwapRenderers.renderPlayerAs(_evt, "naruto_shippuden:textures/entities/iron_sand.png", MagnetHandsSneakRenderer.ModelBlack_Iron_Sand_Hand_Sneak::new);
				}
			} else if (!entity.isSneaking()) {
				if (_evt.getRenderer() instanceof PlayerRenderer) {
					if (_evt instanceof RenderLivingEvent.Pre) {
						//  _evt.setCanceled(true); 
					}
					ModelSwapRenderers.renderPlayerAs(_evt, "naruto_shippuden:textures/entities/iron_sand.png", MagnetHandsRenderer.ModelBlack_Iron_Sand_Hand::new);
				}
			}
		} else if (NarutoShippudenModVariables.get(entity).magnet_coat == 3) {
			if (_evt.getRenderer() instanceof PlayerRenderer) {
				if (_evt instanceof RenderLivingEvent.Pre) {
					//  _evt.setCanceled(true); 
				}
				ModelSwapRenderers.renderPlayerAs(_evt, "naruto_shippuden:textures/entities/iron_sand.png", MagnetWingsRenderer.ModelBlack_Iron_Sand_Wings::new);
			}
		}
		if (NarutoShippudenModVariables.get(entity).deathgod == true) {
			if (_evt.getRenderer() instanceof PlayerRenderer) {
				if (_evt instanceof RenderLivingEvent.Pre) {
					//  _evt.setCanceled(true); 
				}
				ModelSwapRenderers.renderPlayerAs(_evt, "naruto_shippuden:textures/entities/dead_demon_consuming_seal.png", DeadDemonConsumingSealRenderer.ModelDead_Demon_Consuming_Seal::new);
			}
		}
		if (NarutoShippudenModVariables.get(entity).EightTrigramsPalmsRevolvingHeaven == true) {
			if (_evt.getRenderer() instanceof PlayerRenderer) {
				if (_evt instanceof RenderLivingEvent.Pre) {
					_evt.setCanceled(true);
				}
				ModelSwapRenderers.renderPlayerAs(_evt, "naruto_shippuden:textures/entities/eight_trigrams_palms_revolving_heaven.png", EightTrigramsPalmsRevolvingHeavenRenderer.Modeleight_trigrams_palms_revolving_heaven::new);
			}
		}
		if (NarutoShippudenModVariables.get(entity).InsectJarTechnique == true) {
			if (_evt.getRenderer() instanceof PlayerRenderer) {
				if (_evt instanceof RenderLivingEvent.Pre) {
					_evt.setCanceled(true);
				}
				ModelSwapRenderers.renderPlayerAs(_evt, "naruto_shippuden:textures/entities/bugs.png", InsectJarTechniqueRenderer.Modeleight_trigrams_palms_revolving_heaven::new);
			}
		}
		if (NarutoShippudenModVariables.get(entity).HumanBulletTank == true) {
			if (_evt.getRenderer() instanceof PlayerRenderer) {
				if (_evt instanceof RenderLivingEvent.Pre) {
					_evt.setCanceled(true);
				}
				ModelSwapRenderers.renderPlayerAs(_evt, "naruto_shippuden:textures/entities/human_bullet_tank.png", HumanBulletTankRenderer.ModelHuman_Bullet_Tank::new);
			}
		}
		if (NarutoShippudenModVariables.get(entity).SpikedHumanBulletTank == true) {
			if (_evt.getRenderer() instanceof PlayerRenderer) {
				if (_evt instanceof RenderLivingEvent.Pre) {
					_evt.setCanceled(true);
				}
				ModelSwapRenderers.renderPlayerAs(_evt, "naruto_shippuden:textures/entities/spiked_human_bullet_tank.png", SpikedHumanBulletTankRenderer.Modelspiked_human_bullet_tank::new);
			}
		}
		if (NarutoShippudenModVariables.get(entity).ButterflyMode == true) {
			if ((NarutoShippudenModVariables.get(entity).ButterFlyModeColor).equals("Blue")) {
				if (_evt.getRenderer() instanceof PlayerRenderer) {
					if (_evt instanceof RenderLivingEvent.Pre) {
						//  _evt.setCanceled(true); 
					}
					ModelSwapRenderers.renderPlayerAs(_evt, "naruto_shippuden:textures/entities/akimichi_butterfly_blue.png", ButterflyModeRenderer.ModelButterflyMode::new);
				}
			} else if ((NarutoShippudenModVariables.get(entity).ButterFlyModeColor).equals("Green")) {
				if (_evt.getRenderer() instanceof PlayerRenderer) {
					if (_evt instanceof RenderLivingEvent.Pre) {
						//  _evt.setCanceled(true); 
					}
					ModelSwapRenderers.renderPlayerAs(_evt, "naruto_shippuden:textures/entities/akimichi_butterfly_green.png", ButterflyModeRenderer.ModelButterflyMode::new);
				}
			} else if ((NarutoShippudenModVariables.get(entity).ButterFlyModeColor).equals("Orange")) {
				if (_evt.getRenderer() instanceof PlayerRenderer) {
					if (_evt instanceof RenderLivingEvent.Pre) {
						//  _evt.setCanceled(true); 
					}
					ModelSwapRenderers.renderPlayerAs(_evt, "naruto_shippuden:textures/entities/akimichi_butterfly_orange.png", ButterflyModeRenderer.ModelButterflyMode::new);
				}
			} else if ((NarutoShippudenModVariables.get(entity).ButterFlyModeColor).equals("Pink")) {
				if (_evt.getRenderer() instanceof PlayerRenderer) {
					if (_evt instanceof RenderLivingEvent.Pre) {
						//  _evt.setCanceled(true); 
					}
					ModelSwapRenderers.renderPlayerAs(_evt, "naruto_shippuden:textures/entities/akimichi_butterfly_pink.png", ButterflyModeRenderer.ModelButterflyMode::new);
				}
			} else if ((NarutoShippudenModVariables.get(entity).ButterFlyModeColor).equals("Purple")) {
				if (_evt.getRenderer() instanceof PlayerRenderer) {
					if (_evt instanceof RenderLivingEvent.Pre) {
						//  _evt.setCanceled(true); 
					}
					ModelSwapRenderers.renderPlayerAs(_evt, "naruto_shippuden:textures/entities/akimichi_butterfly_purple.png", ButterflyModeRenderer.ModelButterflyMode::new);
				}
			} else if ((NarutoShippudenModVariables.get(entity).ButterFlyModeColor).equals("Red")) {
				if (_evt.getRenderer() instanceof PlayerRenderer) {
					if (_evt instanceof RenderLivingEvent.Pre) {
						//  _evt.setCanceled(true); 
					}
					ModelSwapRenderers.renderPlayerAs(_evt, "naruto_shippuden:textures/entities/akimichi_butterfly_red.png", ButterflyModeRenderer.ModelButterflyMode::new);
				}
			} else if ((NarutoShippudenModVariables.get(entity).ButterFlyModeColor).equals("Yellow")) {
				if (_evt.getRenderer() instanceof PlayerRenderer) {
					if (_evt instanceof RenderLivingEvent.Pre) {
						//  _evt.setCanceled(true); 
					}
					ModelSwapRenderers.renderPlayerAs(_evt, "naruto_shippuden:textures/entities/akimichi_butterfly_yellow.png", ButterflyModeRenderer.ModelButterflyMode::new);
				}
			}
		}
		if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 1) {
			if (NarutoShippudenModVariables.get(entity).MangekyouSharinganSasuke == true) {
				if (_evt.getRenderer() instanceof PlayerRenderer) {
					if (_evt instanceof RenderLivingEvent.Pre) {
						//  _evt.setCanceled(true); 
					}
					ModelSwapRenderers.renderPlayerAs(_evt, "naruto_shippuden:textures/susano/susano_sasuke.png", RibcageSusanoRenderer.Modelribcage::new);
				}
			} else if (NarutoShippudenModVariables.get(entity).MangekyouSharinganItachi == true) {
				if (_evt.getRenderer() instanceof PlayerRenderer) {
					if (_evt instanceof RenderLivingEvent.Pre) {
						//  _evt.setCanceled(true); 
					}
					ModelSwapRenderers.renderPlayerAs(_evt, "naruto_shippuden:textures/susano/susano_itachi.png", RibcageSusanoRenderer.Modelribcage::new);
				}
			} else if (NarutoShippudenModVariables.get(entity).MangekyouSharinganMadara == true) {
				if (_evt.getRenderer() instanceof PlayerRenderer) {
					if (_evt instanceof RenderLivingEvent.Pre) {
						//  _evt.setCanceled(true); 
					}
					ModelSwapRenderers.renderPlayerAs(_evt, "naruto_shippuden:textures/susano/susano_madara.png", RibcageSusanoRenderer.Modelribcage::new);
				}
			} else if (NarutoShippudenModVariables.get(entity).MangekyouSharinganObito == true) {
				if (_evt.getRenderer() instanceof PlayerRenderer) {
					if (_evt instanceof RenderLivingEvent.Pre) {
						//  _evt.setCanceled(true); 
					}
					ModelSwapRenderers.renderPlayerAs(_evt, "naruto_shippuden:textures/susano/susano_obito.png", RibcageSusanoRenderer.Modelribcage::new);
				}
			} else if (NarutoShippudenModVariables.get(entity).MangekyouSharinganShisui == true) {
				if (_evt.getRenderer() instanceof PlayerRenderer) {
					if (_evt instanceof RenderLivingEvent.Pre) {
						//  _evt.setCanceled(true); 
					}
					ModelSwapRenderers.renderPlayerAs(_evt, "naruto_shippuden:textures/susano/susano_shisui.png", RibcageSusanoRenderer.Modelribcage::new);
				}
			}
		} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 2) {
			if (NarutoShippudenModVariables.get(entity).MangekyouSharinganSasuke == true) {
				if (_evt.getRenderer() instanceof PlayerRenderer) {
					if (_evt instanceof RenderLivingEvent.Pre) {
						//  _evt.setCanceled(true); 
					}
					ModelSwapRenderers.renderPlayerAs(_evt, "naruto_shippuden:textures/susano/susano_sasuke.png", SkeletonSusanoSasukeRenderer.Modelsusanoskeletonsasuke::new);
				}
			} else if (NarutoShippudenModVariables.get(entity).MangekyouSharinganItachi == true) {
				if (_evt.getRenderer() instanceof PlayerRenderer) {
					if (_evt instanceof RenderLivingEvent.Pre) {
						//  _evt.setCanceled(true); 
					}
					ModelSwapRenderers.renderPlayerAs(_evt, "naruto_shippuden:textures/susano/susano_itachi.png", SkeletonSusanoItachiRenderer.Modelsusanoskeletonitachi::new);
				}
			} else if (NarutoShippudenModVariables.get(entity).MangekyouSharinganMadara == true) {
				if (_evt.getRenderer() instanceof PlayerRenderer) {
					if (_evt instanceof RenderLivingEvent.Pre) {
						//  _evt.setCanceled(true); 
					}
					ModelSwapRenderers.renderPlayerAs(_evt, "naruto_shippuden:textures/susano/susano_madara.png", SkeletonSusanoMadaraRenderer.Modelsusanoskeletonmadara::new);
				}
			} else if (NarutoShippudenModVariables.get(entity).MangekyouSharinganObito == true) {
				if (_evt.getRenderer() instanceof PlayerRenderer) {
					if (_evt instanceof RenderLivingEvent.Pre) {
						//  _evt.setCanceled(true); 
					}
					ModelSwapRenderers.renderPlayerAs(_evt, "naruto_shippuden:textures/susano/susano_obito.png", SkeletonSusanoObitoRenderer.Modelsusanoskeletonobito::new);
				}
			} else if (NarutoShippudenModVariables.get(entity).MangekyouSharinganShisui == true) {
				if (_evt.getRenderer() instanceof PlayerRenderer) {
					if (_evt instanceof RenderLivingEvent.Pre) {
						//  _evt.setCanceled(true); 
					}
					ModelSwapRenderers.renderPlayerAs(_evt, "naruto_shippuden:textures/susano/susano_shisui.png", SkeletonSusanoShisuiRenderer.Modelsusanoskeletonshisui::new);
				}
			}
		} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 3) {
			if (NarutoShippudenModVariables.get(entity).MangekyouSharinganSasuke == true) {
				if (_evt.getRenderer() instanceof PlayerRenderer) {
					if (_evt instanceof RenderLivingEvent.Pre) {
						//  _evt.setCanceled(true); 
					}
					ModelSwapRenderers.renderPlayerAs(_evt, "naruto_shippuden:textures/susano/susano_sasuke.png", HumanoidSusanoSasukeRenderer.Modelsusanohumanoidsasuke::new);
				}
			} else if (NarutoShippudenModVariables.get(entity).MangekyouSharinganItachi == true) {
				if (_evt.getRenderer() instanceof PlayerRenderer) {
					if (_evt instanceof RenderLivingEvent.Pre) {
						//  _evt.setCanceled(true); 
					}
					ModelSwapRenderers.renderPlayerAs(_evt, "naruto_shippuden:textures/susano/susano_itachi.png", HumanoidSusanoItachiRenderer.Modelsusanohumanoiditachi::new);
				}
			} else if (NarutoShippudenModVariables.get(entity).MangekyouSharinganMadara == true) {
				if (_evt.getRenderer() instanceof PlayerRenderer) {
					if (_evt instanceof RenderLivingEvent.Pre) {
						//  _evt.setCanceled(true); 
					}
					ModelSwapRenderers.renderPlayerAs(_evt, "naruto_shippuden:textures/susano/susano_madara.png", HumanoidSusanoMadaraRenderer.Modelsusanohumanoidmadara::new);
				}
			} else if (NarutoShippudenModVariables.get(entity).MangekyouSharinganObito == true) {
				if (_evt.getRenderer() instanceof PlayerRenderer) {
					if (_evt instanceof RenderLivingEvent.Pre) {
						//  _evt.setCanceled(true); 
					}
					ModelSwapRenderers.renderPlayerAs(_evt, "naruto_shippuden:textures/susano/susano_obito.png", HumanoidSusanoObitoRenderer.Modelsusanohumanoidobito::new);
				}
			} else if (NarutoShippudenModVariables.get(entity).MangekyouSharinganShisui == true) {
				if (_evt.getRenderer() instanceof PlayerRenderer) {
					if (_evt instanceof RenderLivingEvent.Pre) {
						//  _evt.setCanceled(true); 
					}
					ModelSwapRenderers.renderPlayerAs(_evt, "naruto_shippuden:textures/susano/susano_shisui.png", HumanoidSusanoShisuiRenderer.Modelsusanohumanoidshisui::new);
				}
			}
		} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 4) {
			if (NarutoShippudenModVariables.get(entity).MangekyouSharinganSasuke == true) {
				if (_evt.getRenderer() instanceof PlayerRenderer) {
					if (_evt instanceof RenderLivingEvent.Pre) {
						//  _evt.setCanceled(true); 
					}
					ModelSwapRenderers.renderPlayerAs(_evt, "naruto_shippuden:textures/susano/susano_sasuke.png", ArmoredSusanoSasukeRenderer.Modelsusanoarmoredsasuke::new);
				}
			} else if (NarutoShippudenModVariables.get(entity).MangekyouSharinganMadara == true) {
				if (_evt.getRenderer() instanceof PlayerRenderer) {
					if (_evt instanceof RenderLivingEvent.Pre) {
						//  _evt.setCanceled(true); 
					}
					ModelSwapRenderers.renderPlayerAs(_evt, "naruto_shippuden:textures/susano/susano_madara.png", ArmoredSusanoMadaraRenderer.Modelsusanoarmoredmadara::new);
				}
			} else if (NarutoShippudenModVariables.get(entity).MangekyouSharinganShisui == true) {
				if (_evt.getRenderer() instanceof PlayerRenderer) {
					if (_evt instanceof RenderLivingEvent.Pre) {
						//  _evt.setCanceled(true); 
					}
					ModelSwapRenderers.renderPlayerAs(_evt, "naruto_shippuden:textures/susano/susano_shisui.png", ArmoredSusanoShisuiRenderer.Modelsusanoarmoredshisui::new);
				}
			}
		}
	}
}
