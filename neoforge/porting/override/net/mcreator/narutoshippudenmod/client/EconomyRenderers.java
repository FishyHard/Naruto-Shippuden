package net.mcreator.narutoshippudenmod.client;

import net.mcreator.narutoshippudenmod.economy.ShinobiMerchant;

import net.minecraft.resources.Identifier;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

@EventBusSubscriber(modid = "naruto_shippuden", value = Dist.CLIENT)
public final class EconomyRenderers {
	private EconomyRenderers() {
	}

	@SubscribeEvent
	public static void renderers(EntityRenderersEvent.RegisterRenderers event) {
		ModRenderers.humanoid(event, ShinobiMerchant.entity, 0.5F,
				Identifier.fromNamespaceAndPath("naruto_shippuden", "textures/entities/shinobi_merchant.png"), false);
	}
}
