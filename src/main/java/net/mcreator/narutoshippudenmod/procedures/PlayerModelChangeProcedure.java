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
		if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).inuzuka_mode == 1) {
			if (_evt.getRenderer() instanceof PlayerRenderer) {
				if (_evt instanceof RenderLivingEvent.Pre) {
					_evt.setCanceled(true);
				}
				new com.kleiders.kleidersplayerrenderer.KleidersPlayerRenderer(_evt.getRenderer().getRenderManager(),
						new ResourceLocation("naruto_shippuden:textures/entities/two_head_akamaru.png"),
						new TwoHeadAkamaruRenderer.ModelTwo_Head_Akamaru()).render((AbstractClientPlayerEntity) _evt.getEntity(),
								_evt.getEntity().rotationYaw, _evt.getPartialRenderTick(), _evt.getMatrixStack(), _evt.getBuffers(), _evt.getLight());
			}
		}
		if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).inuzuka_mode == 2) {
			if (_evt.getRenderer() instanceof PlayerRenderer) {
				if (_evt instanceof RenderLivingEvent.Pre) {
					_evt.setCanceled(true);
				}
				new com.kleiders.kleidersplayerrenderer.KleidersPlayerRenderer(_evt.getRenderer().getRenderManager(),
						new ResourceLocation("naruto_shippuden:textures/entities/two_head_akamaru.png"),
						new ThreeHeadAkamaruRenderer.ModelThree_Head_Akamaru()).render((AbstractClientPlayerEntity) _evt.getEntity(),
								_evt.getEntity().rotationYaw, _evt.getPartialRenderTick(), _evt.getMatrixStack(), _evt.getBuffers(), _evt.getLight());
			}
		}
		if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).PassingFang == true) {
			if (_evt.getRenderer() instanceof PlayerRenderer) {
				if (_evt instanceof RenderLivingEvent.Pre) {
					_evt.setCanceled(true);
				}
				new com.kleiders.kleidersplayerrenderer.KleidersPlayerRenderer(_evt.getRenderer().getRenderManager(),
						new ResourceLocation("naruto_shippuden:textures/entities/passing_fang.png"), new FangRenderer.Modelfang())
						.render((AbstractClientPlayerEntity) _evt.getEntity(), _evt.getEntity().rotationYaw, _evt.getPartialRenderTick(),
								_evt.getMatrixStack(), _evt.getBuffers(), _evt.getLight());
			}
		}
		if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).tenromode == true) {
			if (_evt.getRenderer() instanceof PlayerRenderer) {
				if (_evt instanceof RenderLivingEvent.Pre) {
					_evt.setCanceled(true);
				}
				new com.kleiders.kleidersplayerrenderer.KleidersPlayerRenderer(_evt.getRenderer().getRenderManager(),
						new ResourceLocation("naruto_shippuden:textures/entities/wolf.png"), new WolfRenderer.Modelwolf())
						.render((AbstractClientPlayerEntity) _evt.getEntity(), _evt.getEntity().rotationYaw, _evt.getPartialRenderTick(),
								_evt.getMatrixStack(), _evt.getBuffers(), _evt.getLight());
			}
		}
		if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).izunochakramode == true) {
			if (entity.isSneaking()) {
				if (_evt.getRenderer() instanceof PlayerRenderer) {
					if (_evt instanceof RenderLivingEvent.Pre) {
						//  _evt.setCanceled(true); 
					}
					new com.kleiders.kleidersplayerrenderer.KleidersPlayerRenderer(_evt.getRenderer().getRenderManager(),
							new ResourceLocation("naruto_shippuden:textures/entities/catchakramode.png"),
							new CatChakraModeSneakRenderer.Modelcatchakramodesneak()).render((AbstractClientPlayerEntity) _evt.getEntity(),
									_evt.getEntity().rotationYaw, _evt.getPartialRenderTick(), _evt.getMatrixStack(), _evt.getBuffers(),
									_evt.getLight());
				}
			} else if (!entity.isSneaking()) {
				if (_evt.getRenderer() instanceof PlayerRenderer) {
					if (_evt instanceof RenderLivingEvent.Pre) {
						//  _evt.setCanceled(true); 
					}
					new com.kleiders.kleidersplayerrenderer.KleidersPlayerRenderer(_evt.getRenderer().getRenderManager(),
							new ResourceLocation("naruto_shippuden:textures/entities/catchakramode.png"),
							new CatChakraModeRenderer.Modelcatchakramode()).render((AbstractClientPlayerEntity) _evt.getEntity(),
									_evt.getEntity().rotationYaw, _evt.getPartialRenderTick(), _evt.getMatrixStack(), _evt.getBuffers(),
									_evt.getLight());
				}
			}
		}
		if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).izunocat == true) {
			if (_evt.getRenderer() instanceof PlayerRenderer) {
				if (_evt instanceof RenderLivingEvent.Pre) {
					_evt.setCanceled(true);
				}
				new com.kleiders.kleidersplayerrenderer.KleidersPlayerRenderer(_evt.getRenderer().getRenderManager(),
						new ResourceLocation("naruto_shippuden:textures/entities/monstercat.png"), new MonsterCatRenderer.Modelmonstercat())
						.render((AbstractClientPlayerEntity) _evt.getEntity(), _evt.getEntity().rotationYaw, _evt.getPartialRenderTick(),
								_evt.getMatrixStack(), _evt.getBuffers(), _evt.getLight());
			}
		}
		if (entity.getPersistentData().getBoolean("mirror") == true) {
			if (!(_evt.getRenderer() instanceof com.kleiders.kleidersplayerrenderer.KleidersEntityRenderer)) {
				if (_evt instanceof RenderLivingEvent.Pre) {
					//  _evt.setCanceled(true); 
				}
				new com.kleiders.kleidersplayerrenderer.KleidersEntityRenderer(_evt.getRenderer().getRenderManager(),
						new ResourceLocation("naruto_shippuden:textures/entities/mirror.png"), new IceMirrorRenderer.Modelice_mirror())
						.render((MobEntity) _evt.getEntity(), _evt.getEntity().rotationYaw, _evt.getPartialRenderTick(), _evt.getMatrixStack(),
								_evt.getBuffers(), _evt.getLight());
			}
		}
		if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).ice_mirror == true) {
			if (_evt.getRenderer() instanceof PlayerRenderer) {
				if (_evt instanceof RenderLivingEvent.Pre) {
					//  _evt.setCanceled(true); 
				}
				new com.kleiders.kleidersplayerrenderer.KleidersPlayerRenderer(_evt.getRenderer().getRenderManager(),
						new ResourceLocation("naruto_shippuden:textures/entities/mirror.png"), new IceMirrorRenderer.Modelice_mirror())
						.render((AbstractClientPlayerEntity) _evt.getEntity(), _evt.getEntity().rotationYaw, _evt.getPartialRenderTick(),
								_evt.getMatrixStack(), _evt.getBuffers(), _evt.getLight());
			}
		}
		if (entity.getPersistentData().getBoolean("waterblob") == true) {
			if (!(_evt.getRenderer() instanceof com.kleiders.kleidersplayerrenderer.KleidersEntityRenderer)) {
				if (_evt instanceof RenderLivingEvent.Pre) {
					//  _evt.setCanceled(true); 
				}
				new com.kleiders.kleidersplayerrenderer.KleidersEntityRenderer(_evt.getRenderer().getRenderManager(),
						new ResourceLocation("naruto_shippuden:textures/entities/drowning_water_blob_technique.png"),
						new DrowningWaterBlobTechniqueEntityRenderer.ModelDrowning_Water_Blob_Technique()).render((MobEntity) _evt.getEntity(),
								_evt.getEntity().rotationYaw, _evt.getPartialRenderTick(), _evt.getMatrixStack(), _evt.getBuffers(), _evt.getLight());
			}
		}
		if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).waterblob == true) {
			if (entity.isSneaking()) {
				if (_evt.getRenderer() instanceof PlayerRenderer) {
					if (_evt instanceof RenderLivingEvent.Pre) {
						//  _evt.setCanceled(true); 
					}
					new com.kleiders.kleidersplayerrenderer.KleidersPlayerRenderer(_evt.getRenderer().getRenderManager(),
							new ResourceLocation("naruto_shippuden:textures/entities/drowning_water_blob_technique.png"),
							new DrowningWaterBlobTechniqueEntitySneakRenderer.ModelDrowning_Water_Blob_Technique_Sneak())
							.render((AbstractClientPlayerEntity) _evt.getEntity(), _evt.getEntity().rotationYaw, _evt.getPartialRenderTick(),
									_evt.getMatrixStack(), _evt.getBuffers(), _evt.getLight());
				}
			} else if (!entity.isSneaking()) {
				if (_evt.getRenderer() instanceof PlayerRenderer) {
					if (_evt instanceof RenderLivingEvent.Pre) {
						//  _evt.setCanceled(true); 
					}
					new com.kleiders.kleidersplayerrenderer.KleidersPlayerRenderer(_evt.getRenderer().getRenderManager(),
							new ResourceLocation("naruto_shippuden:textures/entities/drowning_water_blob_technique.png"),
							new DrowningWaterBlobTechniqueEntityRenderer.ModelDrowning_Water_Blob_Technique())
							.render((AbstractClientPlayerEntity) _evt.getEntity(), _evt.getEntity().rotationYaw, _evt.getPartialRenderTick(),
									_evt.getMatrixStack(), _evt.getBuffers(), _evt.getLight());
				}
			}
		}
		if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).DanceOfTheLarch == true) {
			if (entity.isSneaking()) {
				if (_evt.getRenderer() instanceof PlayerRenderer) {
					if (_evt instanceof RenderLivingEvent.Pre) {
						//  _evt.setCanceled(true); 
					}
					new com.kleiders.kleidersplayerrenderer.KleidersPlayerRenderer(_evt.getRenderer().getRenderManager(),
							new ResourceLocation("naruto_shippuden:textures/entities/bone.png"),
							new DanceoftheLarchSneakRenderer.ModelDance_of_the_Larch_Sneak()).render((AbstractClientPlayerEntity) _evt.getEntity(),
									_evt.getEntity().rotationYaw, _evt.getPartialRenderTick(), _evt.getMatrixStack(), _evt.getBuffers(),
									_evt.getLight());
				}
			} else if (!entity.isSneaking()) {
				if (_evt.getRenderer() instanceof PlayerRenderer) {
					if (_evt instanceof RenderLivingEvent.Pre) {
						//  _evt.setCanceled(true); 
					}
					new com.kleiders.kleidersplayerrenderer.KleidersPlayerRenderer(_evt.getRenderer().getRenderManager(),
							new ResourceLocation("naruto_shippuden:textures/entities/bone.png"),
							new DanceOfTheLarchRenderer.ModelDance_of_the_Larch()).render((AbstractClientPlayerEntity) _evt.getEntity(),
									_evt.getEntity().rotationYaw, _evt.getPartialRenderTick(), _evt.getMatrixStack(), _evt.getBuffers(),
									_evt.getLight());
				}
			}
		}
		if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).hoshigakireleaselogic == true) {
			if (_evt.getRenderer() instanceof PlayerRenderer) {
				if (_evt instanceof RenderLivingEvent.Pre) {
					//  _evt.setCanceled(true); 
				}
				new com.kleiders.kleidersplayerrenderer.InternalPlayerRenderer(_evt.getRenderer().getRenderManager(),
						new ResourceLocation("naruto_shippuden:textures/face_paint/hoshigaki.png"))
						.render((AbstractClientPlayerEntity) _evt.getEntity(), _evt.getEntity().rotationYaw, _evt.getPartialRenderTick(),
								_evt.getMatrixStack(), _evt.getBuffers(), _evt.getLight());
			}
		}
		if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).magnet_coat == 1) {
			if (entity.isSneaking()) {
				if (_evt.getRenderer() instanceof PlayerRenderer) {
					if (_evt instanceof RenderLivingEvent.Pre) {
						//  _evt.setCanceled(true); 
					}
					new com.kleiders.kleidersplayerrenderer.KleidersPlayerRenderer(_evt.getRenderer().getRenderManager(),
							new ResourceLocation("naruto_shippuden:textures/entities/iron_sand.png"),
							new MagnetCoatSneakRenderer.ModelBlack_Iron_Sand_Coat_Sneak()).render((AbstractClientPlayerEntity) _evt.getEntity(),
									_evt.getEntity().rotationYaw, _evt.getPartialRenderTick(), _evt.getMatrixStack(), _evt.getBuffers(),
									_evt.getLight());
				}
			} else if (!entity.isSneaking()) {
				if (_evt.getRenderer() instanceof PlayerRenderer) {
					if (_evt instanceof RenderLivingEvent.Pre) {
						//  _evt.setCanceled(true); 
					}
					new com.kleiders.kleidersplayerrenderer.KleidersPlayerRenderer(_evt.getRenderer().getRenderManager(),
							new ResourceLocation("naruto_shippuden:textures/entities/iron_sand.png"),
							new MagnetCoatRenderer.ModelBlack_Iron_Sand_Coat()).render((AbstractClientPlayerEntity) _evt.getEntity(),
									_evt.getEntity().rotationYaw, _evt.getPartialRenderTick(), _evt.getMatrixStack(), _evt.getBuffers(),
									_evt.getLight());
				}
			}
		} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).magnet_coat == 2) {
			if (entity.isSneaking()) {
				if (_evt.getRenderer() instanceof PlayerRenderer) {
					if (_evt instanceof RenderLivingEvent.Pre) {
						//  _evt.setCanceled(true); 
					}
					new com.kleiders.kleidersplayerrenderer.KleidersPlayerRenderer(_evt.getRenderer().getRenderManager(),
							new ResourceLocation("naruto_shippuden:textures/entities/iron_sand.png"),
							new MagnetHandsSneakRenderer.ModelBlack_Iron_Sand_Hand_Sneak()).render((AbstractClientPlayerEntity) _evt.getEntity(),
									_evt.getEntity().rotationYaw, _evt.getPartialRenderTick(), _evt.getMatrixStack(), _evt.getBuffers(),
									_evt.getLight());
				}
			} else if (!entity.isSneaking()) {
				if (_evt.getRenderer() instanceof PlayerRenderer) {
					if (_evt instanceof RenderLivingEvent.Pre) {
						//  _evt.setCanceled(true); 
					}
					new com.kleiders.kleidersplayerrenderer.KleidersPlayerRenderer(_evt.getRenderer().getRenderManager(),
							new ResourceLocation("naruto_shippuden:textures/entities/iron_sand.png"),
							new MagnetHandsRenderer.ModelBlack_Iron_Sand_Hand()).render((AbstractClientPlayerEntity) _evt.getEntity(),
									_evt.getEntity().rotationYaw, _evt.getPartialRenderTick(), _evt.getMatrixStack(), _evt.getBuffers(),
									_evt.getLight());
				}
			}
		} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).magnet_coat == 3) {
			if (_evt.getRenderer() instanceof PlayerRenderer) {
				if (_evt instanceof RenderLivingEvent.Pre) {
					//  _evt.setCanceled(true); 
				}
				new com.kleiders.kleidersplayerrenderer.KleidersPlayerRenderer(_evt.getRenderer().getRenderManager(),
						new ResourceLocation("naruto_shippuden:textures/entities/iron_sand.png"),
						new MagnetWingsRenderer.ModelBlack_Iron_Sand_Wings()).render((AbstractClientPlayerEntity) _evt.getEntity(),
								_evt.getEntity().rotationYaw, _evt.getPartialRenderTick(), _evt.getMatrixStack(), _evt.getBuffers(), _evt.getLight());
			}
		}
		if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).deathgod == true) {
			if (_evt.getRenderer() instanceof PlayerRenderer) {
				if (_evt instanceof RenderLivingEvent.Pre) {
					//  _evt.setCanceled(true); 
				}
				new com.kleiders.kleidersplayerrenderer.KleidersPlayerRenderer(_evt.getRenderer().getRenderManager(),
						new ResourceLocation("naruto_shippuden:textures/entities/dead_demon_consuming_seal.png"),
						new DeadDemonConsumingSealRenderer.ModelDead_Demon_Consuming_Seal()).render((AbstractClientPlayerEntity) _evt.getEntity(),
								_evt.getEntity().rotationYaw, _evt.getPartialRenderTick(), _evt.getMatrixStack(), _evt.getBuffers(), _evt.getLight());
			}
		}
		if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).EightTrigramsPalmsRevolvingHeaven == true) {
			if (_evt.getRenderer() instanceof PlayerRenderer) {
				if (_evt instanceof RenderLivingEvent.Pre) {
					_evt.setCanceled(true);
				}
				new com.kleiders.kleidersplayerrenderer.KleidersPlayerRenderer(_evt.getRenderer().getRenderManager(),
						new ResourceLocation("naruto_shippuden:textures/entities/eight_trigrams_palms_revolving_heaven.png"),
						new EightTrigramsPalmsRevolvingHeavenRenderer.Modeleight_trigrams_palms_revolving_heaven())
						.render((AbstractClientPlayerEntity) _evt.getEntity(), _evt.getEntity().rotationYaw, _evt.getPartialRenderTick(),
								_evt.getMatrixStack(), _evt.getBuffers(), _evt.getLight());
			}
		}
		if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).InsectJarTechnique == true) {
			if (_evt.getRenderer() instanceof PlayerRenderer) {
				if (_evt instanceof RenderLivingEvent.Pre) {
					_evt.setCanceled(true);
				}
				new com.kleiders.kleidersplayerrenderer.KleidersPlayerRenderer(_evt.getRenderer().getRenderManager(),
						new ResourceLocation("naruto_shippuden:textures/entities/bugs.png"),
						new InsectJarTechniqueRenderer.Modeleight_trigrams_palms_revolving_heaven())
						.render((AbstractClientPlayerEntity) _evt.getEntity(), _evt.getEntity().rotationYaw, _evt.getPartialRenderTick(),
								_evt.getMatrixStack(), _evt.getBuffers(), _evt.getLight());
			}
		}
		if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).HumanBulletTank == true) {
			if (_evt.getRenderer() instanceof PlayerRenderer) {
				if (_evt instanceof RenderLivingEvent.Pre) {
					_evt.setCanceled(true);
				}
				new com.kleiders.kleidersplayerrenderer.KleidersPlayerRenderer(_evt.getRenderer().getRenderManager(),
						new ResourceLocation("naruto_shippuden:textures/entities/human_bullet_tank.png"),
						new HumanBulletTankRenderer.ModelHuman_Bullet_Tank()).render((AbstractClientPlayerEntity) _evt.getEntity(),
								_evt.getEntity().rotationYaw, _evt.getPartialRenderTick(), _evt.getMatrixStack(), _evt.getBuffers(), _evt.getLight());
			}
		}
		if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).SpikedHumanBulletTank == true) {
			if (_evt.getRenderer() instanceof PlayerRenderer) {
				if (_evt instanceof RenderLivingEvent.Pre) {
					_evt.setCanceled(true);
				}
				new com.kleiders.kleidersplayerrenderer.KleidersPlayerRenderer(_evt.getRenderer().getRenderManager(),
						new ResourceLocation("naruto_shippuden:textures/entities/spiked_human_bullet_tank.png"),
						new SpikedHumanBulletTankRenderer.Modelspiked_human_bullet_tank()).render((AbstractClientPlayerEntity) _evt.getEntity(),
								_evt.getEntity().rotationYaw, _evt.getPartialRenderTick(), _evt.getMatrixStack(), _evt.getBuffers(), _evt.getLight());
			}
		}
		if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).ButterflyMode == true) {
			if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).ButterFlyModeColor).equals("Blue")) {
				if (_evt.getRenderer() instanceof PlayerRenderer) {
					if (_evt instanceof RenderLivingEvent.Pre) {
						//  _evt.setCanceled(true); 
					}
					new com.kleiders.kleidersplayerrenderer.KleidersPlayerRenderer(_evt.getRenderer().getRenderManager(),
							new ResourceLocation("naruto_shippuden:textures/entities/akimichi_butterfly_blue.png"),
							new ButterflyModeRenderer.ModelButterflyMode()).render((AbstractClientPlayerEntity) _evt.getEntity(),
									_evt.getEntity().rotationYaw, _evt.getPartialRenderTick(), _evt.getMatrixStack(), _evt.getBuffers(),
									_evt.getLight());
				}
			} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).ButterFlyModeColor).equals("Green")) {
				if (_evt.getRenderer() instanceof PlayerRenderer) {
					if (_evt instanceof RenderLivingEvent.Pre) {
						//  _evt.setCanceled(true); 
					}
					new com.kleiders.kleidersplayerrenderer.KleidersPlayerRenderer(_evt.getRenderer().getRenderManager(),
							new ResourceLocation("naruto_shippuden:textures/entities/akimichi_butterfly_green.png"),
							new ButterflyModeRenderer.ModelButterflyMode()).render((AbstractClientPlayerEntity) _evt.getEntity(),
									_evt.getEntity().rotationYaw, _evt.getPartialRenderTick(), _evt.getMatrixStack(), _evt.getBuffers(),
									_evt.getLight());
				}
			} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).ButterFlyModeColor).equals("Orange")) {
				if (_evt.getRenderer() instanceof PlayerRenderer) {
					if (_evt instanceof RenderLivingEvent.Pre) {
						//  _evt.setCanceled(true); 
					}
					new com.kleiders.kleidersplayerrenderer.KleidersPlayerRenderer(_evt.getRenderer().getRenderManager(),
							new ResourceLocation("naruto_shippuden:textures/entities/akimichi_butterfly_orange.png"),
							new ButterflyModeRenderer.ModelButterflyMode()).render((AbstractClientPlayerEntity) _evt.getEntity(),
									_evt.getEntity().rotationYaw, _evt.getPartialRenderTick(), _evt.getMatrixStack(), _evt.getBuffers(),
									_evt.getLight());
				}
			} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).ButterFlyModeColor).equals("Pink")) {
				if (_evt.getRenderer() instanceof PlayerRenderer) {
					if (_evt instanceof RenderLivingEvent.Pre) {
						//  _evt.setCanceled(true); 
					}
					new com.kleiders.kleidersplayerrenderer.KleidersPlayerRenderer(_evt.getRenderer().getRenderManager(),
							new ResourceLocation("naruto_shippuden:textures/entities/akimichi_butterfly_pink.png"),
							new ButterflyModeRenderer.ModelButterflyMode()).render((AbstractClientPlayerEntity) _evt.getEntity(),
									_evt.getEntity().rotationYaw, _evt.getPartialRenderTick(), _evt.getMatrixStack(), _evt.getBuffers(),
									_evt.getLight());
				}
			} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).ButterFlyModeColor).equals("Purple")) {
				if (_evt.getRenderer() instanceof PlayerRenderer) {
					if (_evt instanceof RenderLivingEvent.Pre) {
						//  _evt.setCanceled(true); 
					}
					new com.kleiders.kleidersplayerrenderer.KleidersPlayerRenderer(_evt.getRenderer().getRenderManager(),
							new ResourceLocation("naruto_shippuden:textures/entities/akimichi_butterfly_purple.png"),
							new ButterflyModeRenderer.ModelButterflyMode()).render((AbstractClientPlayerEntity) _evt.getEntity(),
									_evt.getEntity().rotationYaw, _evt.getPartialRenderTick(), _evt.getMatrixStack(), _evt.getBuffers(),
									_evt.getLight());
				}
			} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).ButterFlyModeColor).equals("Red")) {
				if (_evt.getRenderer() instanceof PlayerRenderer) {
					if (_evt instanceof RenderLivingEvent.Pre) {
						//  _evt.setCanceled(true); 
					}
					new com.kleiders.kleidersplayerrenderer.KleidersPlayerRenderer(_evt.getRenderer().getRenderManager(),
							new ResourceLocation("naruto_shippuden:textures/entities/akimichi_butterfly_red.png"),
							new ButterflyModeRenderer.ModelButterflyMode()).render((AbstractClientPlayerEntity) _evt.getEntity(),
									_evt.getEntity().rotationYaw, _evt.getPartialRenderTick(), _evt.getMatrixStack(), _evt.getBuffers(),
									_evt.getLight());
				}
			} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).ButterFlyModeColor).equals("Yellow")) {
				if (_evt.getRenderer() instanceof PlayerRenderer) {
					if (_evt instanceof RenderLivingEvent.Pre) {
						//  _evt.setCanceled(true); 
					}
					new com.kleiders.kleidersplayerrenderer.KleidersPlayerRenderer(_evt.getRenderer().getRenderManager(),
							new ResourceLocation("naruto_shippuden:textures/entities/akimichi_butterfly_yellow.png"),
							new ButterflyModeRenderer.ModelButterflyMode()).render((AbstractClientPlayerEntity) _evt.getEntity(),
									_evt.getEntity().rotationYaw, _evt.getPartialRenderTick(), _evt.getMatrixStack(), _evt.getBuffers(),
									_evt.getLight());
				}
			}
		}
		if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).mangekyousharingansusanostage == 1) {
			if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).MangekyouSharinganSasuke == true) {
				if (_evt.getRenderer() instanceof PlayerRenderer) {
					if (_evt instanceof RenderLivingEvent.Pre) {
						//  _evt.setCanceled(true); 
					}
					new com.kleiders.kleidersplayerrenderer.KleidersPlayerRenderer(_evt.getRenderer().getRenderManager(),
							new ResourceLocation("naruto_shippuden:textures/susano/susano_sasuke.png"), new RibcageSusanoRenderer.Modelribcage())
							.render((AbstractClientPlayerEntity) _evt.getEntity(), _evt.getEntity().rotationYaw, _evt.getPartialRenderTick(),
									_evt.getMatrixStack(), _evt.getBuffers(), _evt.getLight());
				}
			} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).MangekyouSharinganItachi == true) {
				if (_evt.getRenderer() instanceof PlayerRenderer) {
					if (_evt instanceof RenderLivingEvent.Pre) {
						//  _evt.setCanceled(true); 
					}
					new com.kleiders.kleidersplayerrenderer.KleidersPlayerRenderer(_evt.getRenderer().getRenderManager(),
							new ResourceLocation("naruto_shippuden:textures/susano/susano_itachi.png"), new RibcageSusanoRenderer.Modelribcage())
							.render((AbstractClientPlayerEntity) _evt.getEntity(), _evt.getEntity().rotationYaw, _evt.getPartialRenderTick(),
									_evt.getMatrixStack(), _evt.getBuffers(), _evt.getLight());
				}
			} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).MangekyouSharinganMadara == true) {
				if (_evt.getRenderer() instanceof PlayerRenderer) {
					if (_evt instanceof RenderLivingEvent.Pre) {
						//  _evt.setCanceled(true); 
					}
					new com.kleiders.kleidersplayerrenderer.KleidersPlayerRenderer(_evt.getRenderer().getRenderManager(),
							new ResourceLocation("naruto_shippuden:textures/susano/susano_madara.png"), new RibcageSusanoRenderer.Modelribcage())
							.render((AbstractClientPlayerEntity) _evt.getEntity(), _evt.getEntity().rotationYaw, _evt.getPartialRenderTick(),
									_evt.getMatrixStack(), _evt.getBuffers(), _evt.getLight());
				}
			} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).MangekyouSharinganObito == true) {
				if (_evt.getRenderer() instanceof PlayerRenderer) {
					if (_evt instanceof RenderLivingEvent.Pre) {
						//  _evt.setCanceled(true); 
					}
					new com.kleiders.kleidersplayerrenderer.KleidersPlayerRenderer(_evt.getRenderer().getRenderManager(),
							new ResourceLocation("naruto_shippuden:textures/susano/susano_obito.png"), new RibcageSusanoRenderer.Modelribcage())
							.render((AbstractClientPlayerEntity) _evt.getEntity(), _evt.getEntity().rotationYaw, _evt.getPartialRenderTick(),
									_evt.getMatrixStack(), _evt.getBuffers(), _evt.getLight());
				}
			} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).MangekyouSharinganShisui == true) {
				if (_evt.getRenderer() instanceof PlayerRenderer) {
					if (_evt instanceof RenderLivingEvent.Pre) {
						//  _evt.setCanceled(true); 
					}
					new com.kleiders.kleidersplayerrenderer.KleidersPlayerRenderer(_evt.getRenderer().getRenderManager(),
							new ResourceLocation("naruto_shippuden:textures/susano/susano_shisui.png"), new RibcageSusanoRenderer.Modelribcage())
							.render((AbstractClientPlayerEntity) _evt.getEntity(), _evt.getEntity().rotationYaw, _evt.getPartialRenderTick(),
									_evt.getMatrixStack(), _evt.getBuffers(), _evt.getLight());
				}
			}
		} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).mangekyousharingansusanostage == 2) {
			if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).MangekyouSharinganSasuke == true) {
				if (_evt.getRenderer() instanceof PlayerRenderer) {
					if (_evt instanceof RenderLivingEvent.Pre) {
						//  _evt.setCanceled(true); 
					}
					new com.kleiders.kleidersplayerrenderer.KleidersPlayerRenderer(_evt.getRenderer().getRenderManager(),
							new ResourceLocation("naruto_shippuden:textures/susano/susano_sasuke.png"),
							new SkeletonSusanoSasukeRenderer.Modelsusanoskeletonsasuke()).render((AbstractClientPlayerEntity) _evt.getEntity(),
									_evt.getEntity().rotationYaw, _evt.getPartialRenderTick(), _evt.getMatrixStack(), _evt.getBuffers(),
									_evt.getLight());
				}
			} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).MangekyouSharinganItachi == true) {
				if (_evt.getRenderer() instanceof PlayerRenderer) {
					if (_evt instanceof RenderLivingEvent.Pre) {
						//  _evt.setCanceled(true); 
					}
					new com.kleiders.kleidersplayerrenderer.KleidersPlayerRenderer(_evt.getRenderer().getRenderManager(),
							new ResourceLocation("naruto_shippuden:textures/susano/susano_itachi.png"),
							new SkeletonSusanoItachiRenderer.Modelsusanoskeletonitachi()).render((AbstractClientPlayerEntity) _evt.getEntity(),
									_evt.getEntity().rotationYaw, _evt.getPartialRenderTick(), _evt.getMatrixStack(), _evt.getBuffers(),
									_evt.getLight());
				}
			} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).MangekyouSharinganMadara == true) {
				if (_evt.getRenderer() instanceof PlayerRenderer) {
					if (_evt instanceof RenderLivingEvent.Pre) {
						//  _evt.setCanceled(true); 
					}
					new com.kleiders.kleidersplayerrenderer.KleidersPlayerRenderer(_evt.getRenderer().getRenderManager(),
							new ResourceLocation("naruto_shippuden:textures/susano/susano_madara.png"),
							new SkeletonSusanoMadaraRenderer.Modelsusanoskeletonmadara()).render((AbstractClientPlayerEntity) _evt.getEntity(),
									_evt.getEntity().rotationYaw, _evt.getPartialRenderTick(), _evt.getMatrixStack(), _evt.getBuffers(),
									_evt.getLight());
				}
			} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).MangekyouSharinganObito == true) {
				if (_evt.getRenderer() instanceof PlayerRenderer) {
					if (_evt instanceof RenderLivingEvent.Pre) {
						//  _evt.setCanceled(true); 
					}
					new com.kleiders.kleidersplayerrenderer.KleidersPlayerRenderer(_evt.getRenderer().getRenderManager(),
							new ResourceLocation("naruto_shippuden:textures/susano/susano_obito.png"),
							new SkeletonSusanoObitoRenderer.Modelsusanoskeletonobito()).render((AbstractClientPlayerEntity) _evt.getEntity(),
									_evt.getEntity().rotationYaw, _evt.getPartialRenderTick(), _evt.getMatrixStack(), _evt.getBuffers(),
									_evt.getLight());
				}
			} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).MangekyouSharinganShisui == true) {
				if (_evt.getRenderer() instanceof PlayerRenderer) {
					if (_evt instanceof RenderLivingEvent.Pre) {
						//  _evt.setCanceled(true); 
					}
					new com.kleiders.kleidersplayerrenderer.KleidersPlayerRenderer(_evt.getRenderer().getRenderManager(),
							new ResourceLocation("naruto_shippuden:textures/susano/susano_shisui.png"),
							new SkeletonSusanoShisuiRenderer.Modelsusanoskeletonshisui()).render((AbstractClientPlayerEntity) _evt.getEntity(),
									_evt.getEntity().rotationYaw, _evt.getPartialRenderTick(), _evt.getMatrixStack(), _evt.getBuffers(),
									_evt.getLight());
				}
			}
		} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).mangekyousharingansusanostage == 3) {
			if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).MangekyouSharinganSasuke == true) {
				if (_evt.getRenderer() instanceof PlayerRenderer) {
					if (_evt instanceof RenderLivingEvent.Pre) {
						//  _evt.setCanceled(true); 
					}
					new com.kleiders.kleidersplayerrenderer.KleidersPlayerRenderer(_evt.getRenderer().getRenderManager(),
							new ResourceLocation("naruto_shippuden:textures/susano/susano_sasuke.png"),
							new HumanoidSusanoSasukeRenderer.Modelsusanohumanoidsasuke()).render((AbstractClientPlayerEntity) _evt.getEntity(),
									_evt.getEntity().rotationYaw, _evt.getPartialRenderTick(), _evt.getMatrixStack(), _evt.getBuffers(),
									_evt.getLight());
				}
			} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).MangekyouSharinganItachi == true) {
				if (_evt.getRenderer() instanceof PlayerRenderer) {
					if (_evt instanceof RenderLivingEvent.Pre) {
						//  _evt.setCanceled(true); 
					}
					new com.kleiders.kleidersplayerrenderer.KleidersPlayerRenderer(_evt.getRenderer().getRenderManager(),
							new ResourceLocation("naruto_shippuden:textures/susano/susano_itachi.png"),
							new HumanoidSusanoItachiRenderer.Modelsusanohumanoiditachi()).render((AbstractClientPlayerEntity) _evt.getEntity(),
									_evt.getEntity().rotationYaw, _evt.getPartialRenderTick(), _evt.getMatrixStack(), _evt.getBuffers(),
									_evt.getLight());
				}
			} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).MangekyouSharinganMadara == true) {
				if (_evt.getRenderer() instanceof PlayerRenderer) {
					if (_evt instanceof RenderLivingEvent.Pre) {
						//  _evt.setCanceled(true); 
					}
					new com.kleiders.kleidersplayerrenderer.KleidersPlayerRenderer(_evt.getRenderer().getRenderManager(),
							new ResourceLocation("naruto_shippuden:textures/susano/susano_madara.png"),
							new HumanoidSusanoMadaraRenderer.Modelsusanohumanoidmadara()).render((AbstractClientPlayerEntity) _evt.getEntity(),
									_evt.getEntity().rotationYaw, _evt.getPartialRenderTick(), _evt.getMatrixStack(), _evt.getBuffers(),
									_evt.getLight());
				}
			} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).MangekyouSharinganObito == true) {
				if (_evt.getRenderer() instanceof PlayerRenderer) {
					if (_evt instanceof RenderLivingEvent.Pre) {
						//  _evt.setCanceled(true); 
					}
					new com.kleiders.kleidersplayerrenderer.KleidersPlayerRenderer(_evt.getRenderer().getRenderManager(),
							new ResourceLocation("naruto_shippuden:textures/susano/susano_obito.png"),
							new HumanoidSusanoObitoRenderer.Modelsusanohumanoidobito()).render((AbstractClientPlayerEntity) _evt.getEntity(),
									_evt.getEntity().rotationYaw, _evt.getPartialRenderTick(), _evt.getMatrixStack(), _evt.getBuffers(),
									_evt.getLight());
				}
			} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).MangekyouSharinganShisui == true) {
				if (_evt.getRenderer() instanceof PlayerRenderer) {
					if (_evt instanceof RenderLivingEvent.Pre) {
						//  _evt.setCanceled(true); 
					}
					new com.kleiders.kleidersplayerrenderer.KleidersPlayerRenderer(_evt.getRenderer().getRenderManager(),
							new ResourceLocation("naruto_shippuden:textures/susano/susano_shisui.png"),
							new HumanoidSusanoShisuiRenderer.Modelsusanohumanoidshisui()).render((AbstractClientPlayerEntity) _evt.getEntity(),
									_evt.getEntity().rotationYaw, _evt.getPartialRenderTick(), _evt.getMatrixStack(), _evt.getBuffers(),
									_evt.getLight());
				}
			}
		} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).mangekyousharingansusanostage == 4) {
			if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).MangekyouSharinganSasuke == true) {
				if (_evt.getRenderer() instanceof PlayerRenderer) {
					if (_evt instanceof RenderLivingEvent.Pre) {
						//  _evt.setCanceled(true); 
					}
					new com.kleiders.kleidersplayerrenderer.KleidersPlayerRenderer(_evt.getRenderer().getRenderManager(),
							new ResourceLocation("naruto_shippuden:textures/susano/susano_sasuke.png"),
							new ArmoredSusanoSasukeRenderer.Modelsusanoarmoredsasuke()).render((AbstractClientPlayerEntity) _evt.getEntity(),
									_evt.getEntity().rotationYaw, _evt.getPartialRenderTick(), _evt.getMatrixStack(), _evt.getBuffers(),
									_evt.getLight());
				}
			} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).MangekyouSharinganMadara == true) {
				if (_evt.getRenderer() instanceof PlayerRenderer) {
					if (_evt instanceof RenderLivingEvent.Pre) {
						//  _evt.setCanceled(true); 
					}
					new com.kleiders.kleidersplayerrenderer.KleidersPlayerRenderer(_evt.getRenderer().getRenderManager(),
							new ResourceLocation("naruto_shippuden:textures/susano/susano_madara.png"),
							new ArmoredSusanoMadaraRenderer.Modelsusanoarmoredmadara()).render((AbstractClientPlayerEntity) _evt.getEntity(),
									_evt.getEntity().rotationYaw, _evt.getPartialRenderTick(), _evt.getMatrixStack(), _evt.getBuffers(),
									_evt.getLight());
				}
			} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).MangekyouSharinganShisui == true) {
				if (_evt.getRenderer() instanceof PlayerRenderer) {
					if (_evt instanceof RenderLivingEvent.Pre) {
						//  _evt.setCanceled(true); 
					}
					new com.kleiders.kleidersplayerrenderer.KleidersPlayerRenderer(_evt.getRenderer().getRenderManager(),
							new ResourceLocation("naruto_shippuden:textures/susano/susano_shisui.png"),
							new ArmoredSusanoShisuiRenderer.Modelsusanoarmoredshisui()).render((AbstractClientPlayerEntity) _evt.getEntity(),
									_evt.getEntity().rotationYaw, _evt.getPartialRenderTick(), _evt.getMatrixStack(), _evt.getBuffers(),
									_evt.getLight());
				}
			}
		}
	}
}
