package net.mcreator.narutoshippudenmod.client;

import net.mcreator.narutoshippudenmod.entity.renderer.*;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;
import net.mcreator.narutoshippudenmod.gui.*;
import net.mcreator.narutoshippudenmod.gui.CheatGuis.*;
import net.mcreator.narutoshippudenmod.gui.CheatScreens.*;
import net.mcreator.narutoshippudenmod.gui.InfoCardGuis.*;
import net.mcreator.narutoshippudenmod.gui.InfoCardScreens.*;
import net.mcreator.narutoshippudenmod.gui.JutsuCreationGuis.*;
import net.mcreator.narutoshippudenmod.gui.JutsuCreationScreens.*;
import net.mcreator.narutoshippudenmod.gui.MiscGuis.*;
import net.mcreator.narutoshippudenmod.gui.MiscScreens.*;

/** Client-side registration: entity renderers, model layers and item extensions. */
@EventBusSubscriber(modid = "naruto_shippuden", value = Dist.CLIENT)
public final class ModClient {
	private ModClient() {
	}

	@SubscribeEvent
	public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
		JutsuRenderers.DanceOfTheLarchRenderer.registerRenderers(event);
		JutsuRenderers.DanceoftheLarchSneakRenderer.registerRenderers(event);
		JutsuRenderers.DeadDemonConsumingSealRenderer.registerRenderers(event);
		JutsuRenderers.DrowningWaterBlobTechniqueEntityRenderer.registerRenderers(event);
		JutsuRenderers.DrowningWaterBlobTechniqueEntitySneakRenderer.registerRenderers(event);
		JutsuRenderers.EightTrigramsPalmsRevolvingHeavenRenderer.registerRenderers(event);
		JutsuRenderers.FangRenderer.registerRenderers(event);
		JutsuRenderers.FlyingThunderGodKunaiEntityRenderer.registerRenderers(event);
		JutsuRenderers.IceMirrorRenderer.registerRenderers(event);
		JutsuRenderers.InsectJarTechniqueRenderer.registerRenderers(event);
		JutsuRenderers.MagnetCoatRenderer.registerRenderers(event);
		JutsuRenderers.MagnetCoatSneakRenderer.registerRenderers(event);
		JutsuRenderers.MagnetHandsRenderer.registerRenderers(event);
		JutsuRenderers.MagnetHandsSneakRenderer.registerRenderers(event);
		JutsuRenderers.MagnetWingsRenderer.registerRenderers(event);
		JutsuRenderers.ShadowImitationEntity2Renderer.registerRenderers(event);
		JutsuRenderers.ShadowImitationEntityRenderer.registerRenderers(event);
		NpcRenderers.AsumaRenderer.registerRenderers(event);
		NpcRenderers.EarthGolemShinobiRenderer.registerRenderers(event);
		NpcRenderers.HiddenCloudShinobiRenderer.registerRenderers(event);
		NpcRenderers.HiddenLeafShinobiRenderer.registerRenderers(event);
		NpcRenderers.HiddenMistShinobiRenderer.registerRenderers(event);
		NpcRenderers.HiddenSandShinobiRenderer.registerRenderers(event);
		NpcRenderers.HiddenStoneShinobiRenderer.registerRenderers(event);
		NpcRenderers.IrukaSenseiCloneRenderer.registerRenderers(event);
		NpcRenderers.IrukaSenseiRenderer.registerRenderers(event);
		NpcRenderers.ShikamaruRenderer.registerRenderers(event);
		NpcRenderers.TrainingDummyRenderer.registerRenderers(event);
		ProjectileRenderers.GreatFireDragonRenderer.registerRenderers(event);
		ProjectileRenderers.LaserCircusRenderer.registerRenderers(event);
		ProjectileRenderers.UzumakiChainRenderer.registerRenderers(event);
		SummonRenderers.AkamaruRenderer.registerRenderers(event);
		SummonRenderers.CrowRenderer.registerRenderers(event);
		SummonRenderers.EarthGolemRenderer.registerRenderers(event);
		SummonRenderers.KuramaRenderer.registerRenderers(event);
		SusanoRenderers.ArmoredSusanoMadaraRenderer.registerRenderers(event);
		SusanoRenderers.ArmoredSusanoSasukeRenderer.registerRenderers(event);
		SusanoRenderers.ArmoredSusanoShisuiRenderer.registerRenderers(event);
		SusanoRenderers.HumanoidSusanoItachiRenderer.registerRenderers(event);
		SusanoRenderers.HumanoidSusanoMadaraRenderer.registerRenderers(event);
		SusanoRenderers.HumanoidSusanoObitoRenderer.registerRenderers(event);
		SusanoRenderers.HumanoidSusanoSasukeRenderer.registerRenderers(event);
		SusanoRenderers.HumanoidSusanoShisuiRenderer.registerRenderers(event);
		SusanoRenderers.RibcageSusanoRenderer.registerRenderers(event);
		SusanoRenderers.SkeletonSusanoItachiRenderer.registerRenderers(event);
		SusanoRenderers.SkeletonSusanoMadaraRenderer.registerRenderers(event);
		SusanoRenderers.SkeletonSusanoObitoRenderer.registerRenderers(event);
		SusanoRenderers.SkeletonSusanoSasukeRenderer.registerRenderers(event);
		SusanoRenderers.SkeletonSusanoShisuiRenderer.registerRenderers(event);
	}

	@SubscribeEvent
	public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
		JutsuRenderers.DanceOfTheLarchRenderer.registerLayers(event);
		JutsuRenderers.DanceoftheLarchSneakRenderer.registerLayers(event);
		JutsuRenderers.DeadDemonConsumingSealRenderer.registerLayers(event);
		JutsuRenderers.DrowningWaterBlobTechniqueEntityRenderer.registerLayers(event);
		JutsuRenderers.DrowningWaterBlobTechniqueEntitySneakRenderer.registerLayers(event);
		JutsuRenderers.EightTrigramsPalmsRevolvingHeavenRenderer.registerLayers(event);
		JutsuRenderers.FangRenderer.registerLayers(event);
		JutsuRenderers.FlyingThunderGodKunaiEntityRenderer.registerLayers(event);
		JutsuRenderers.IceMirrorRenderer.registerLayers(event);
		JutsuRenderers.InsectJarTechniqueRenderer.registerLayers(event);
		JutsuRenderers.MagnetCoatRenderer.registerLayers(event);
		JutsuRenderers.MagnetCoatSneakRenderer.registerLayers(event);
		JutsuRenderers.MagnetHandsRenderer.registerLayers(event);
		JutsuRenderers.MagnetHandsSneakRenderer.registerLayers(event);
		JutsuRenderers.MagnetWingsRenderer.registerLayers(event);
		JutsuRenderers.ShadowCloneRenderer.registerLayers(event);
		JutsuRenderers.ShadowImitationEntity2Renderer.registerLayers(event);
		JutsuRenderers.ShadowImitationEntityRenderer.registerLayers(event);
		NpcRenderers.AsumaRenderer.registerLayers(event);
		NpcRenderers.EarthGolemShinobiRenderer.registerLayers(event);
		NpcRenderers.HiddenCloudShinobiRenderer.registerLayers(event);
		NpcRenderers.HiddenLeafShinobiRenderer.registerLayers(event);
		NpcRenderers.HiddenMistShinobiRenderer.registerLayers(event);
		NpcRenderers.HiddenSandShinobiRenderer.registerLayers(event);
		NpcRenderers.HiddenStoneShinobiRenderer.registerLayers(event);
		NpcRenderers.IrukaSenseiCloneRenderer.registerLayers(event);
		NpcRenderers.IrukaSenseiRenderer.registerLayers(event);
		NpcRenderers.ShikamaruRenderer.registerLayers(event);
		NpcRenderers.TrainingDummyRenderer.registerLayers(event);
		ProjectileRenderers.ExplosiveKunaiBulletRenderer.registerLayers(event);
		ProjectileRenderers.FlyingThunderGodKunaiBulletRenderer.registerLayers(event);
		ProjectileRenderers.FumaShurikenBulletRenderer.registerLayers(event);
		ProjectileRenderers.GreatFireDragonRenderer.registerLayers(event);
		ProjectileRenderers.KunaiBulletRenderer.registerLayers(event);
		ProjectileRenderers.LaserCircusRenderer.registerLayers(event);
		ProjectileRenderers.PoisonKunaiBulletRenderer.registerLayers(event);
		ProjectileRenderers.ShurikenBulletRenderer.registerLayers(event);
		ProjectileRenderers.ToroiUniqueFumaShurikenBulletRenderer.registerLayers(event);
		ProjectileRenderers.UzumakiChainRenderer.registerLayers(event);
		SummonRenderers.AkamaruRenderer.registerLayers(event);
		SummonRenderers.CrowRenderer.registerLayers(event);
		SummonRenderers.EarthGolemRenderer.registerLayers(event);
		SummonRenderers.KuramaRenderer.registerLayers(event);
		SusanoRenderers.ArmoredSusanoMadaraRenderer.registerLayers(event);
		SusanoRenderers.ArmoredSusanoSasukeRenderer.registerLayers(event);
		SusanoRenderers.ArmoredSusanoShisuiRenderer.registerLayers(event);
		SusanoRenderers.HumanoidSusanoItachiRenderer.registerLayers(event);
		SusanoRenderers.HumanoidSusanoMadaraRenderer.registerLayers(event);
		SusanoRenderers.HumanoidSusanoObitoRenderer.registerLayers(event);
		SusanoRenderers.HumanoidSusanoSasukeRenderer.registerLayers(event);
		SusanoRenderers.HumanoidSusanoShisuiRenderer.registerLayers(event);
		SusanoRenderers.RibcageSusanoRenderer.registerLayers(event);
		SusanoRenderers.SkeletonSusanoItachiRenderer.registerLayers(event);
		SusanoRenderers.SkeletonSusanoMadaraRenderer.registerLayers(event);
		SusanoRenderers.SkeletonSusanoObitoRenderer.registerLayers(event);
		SusanoRenderers.SkeletonSusanoSasukeRenderer.registerLayers(event);
		SusanoRenderers.SkeletonSusanoShisuiRenderer.registerLayers(event);
		ArmorModels.registerLayers(event);
	}

	@SubscribeEvent
	public static void registerParticles(RegisterParticleProvidersEvent event) {
		ModParticleProviders.register(event);
	}

	@SubscribeEvent
	public static void registerScreens(RegisterMenuScreensEvent event) {
		event.register(InfoCardDojutsuGui.containerType, InfoCardDojutsuGuiWindow::new);
		event.register(InfoCardGui.containerType, InfoCardGuiWindow::new);
		event.register(InfoCardMiniGameGui.containerType, InfoCardMiniGameGuiWindow::new);
		event.register(InfoCardMissionsGui.containerType, InfoCardMissionsGuiWindow::new);
		event.register(InfoCardUpgradeGui.containerType, InfoCardUpgradeGuiWindow::new);
		event.register(StatSelectGui.containerType, StatSelectGuiWindow::new);
		event.register(CreateJutsuGUIGui.containerType, CreateJutsuGUIGuiWindow::new);
		event.register(MangekyouSharinganCheatGui.containerType, MangekyouSharinganCheatGuiWindow::new);
		event.register(NarutoShippudenCheatDojutsuGUIGui.containerType, NarutoShippudenCheatDojutsuGUIGuiWindow::new);
		event.register(NarutoShippudenCheatGUIGui.containerType, NarutoShippudenCheatGUIGuiWindow::new);
		event.register(NarutoShippudenCheatKekkeiGenkaiGUIGui.containerType, NarutoShippudenCheatKekkeiGenkaiGUIGuiWindow::new);
	}

	@SubscribeEvent
	public static void registerExtensions(RegisterClientExtensionsEvent event) {
		ArmorModels.registerExtensions(event);
	}
}
