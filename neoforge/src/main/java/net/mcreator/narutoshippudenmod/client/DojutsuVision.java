package net.mcreator.narutoshippudenmod.client;

import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables;

import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.renderstate.RegisterRenderStateModifiersEvent;

/**
 * Byakugan and Tenseigan: while active, every living entity within 250 blocks gets the glowing outline. 1.16 set the
 * glowing flag on the client when the key was pressed; in 26.3 that flag always comes from the server, so the outline
 * is added to the render state instead (it follows entities that come into range, too).
 */
@EventBusSubscriber(modid = "naruto_shippuden", value = Dist.CLIENT)
public final class DojutsuVision {
	private static final double RANGE = 250;
	private static final int OUTLINE = 0xFFFFFFFF;

	private DojutsuVision() {
	}

	@SubscribeEvent
	@SuppressWarnings({"rawtypes", "unchecked"})
	public static void register(RegisterRenderStateModifiersEvent event) {
		event.registerEntityModifier((Class) LivingEntityRenderer.class, (entity, state) -> outline((LivingEntity) entity, (LivingEntityRenderState) state));
	}

	private static void outline(LivingEntity entity, LivingEntityRenderState state) {
		LocalPlayer player = Minecraft.getInstance().player;
		if (player == null || entity == player || state.appearsGlowing() || !active(player))
			return;
		if (entity.distanceToSqr(player) <= RANGE * RANGE)
			state.outlineColor = OUTLINE;
	}

	private static boolean active(LocalPlayer player) {
		NarutoShippudenModVariables.PlayerVariables vars = NarutoShippudenModVariables.get(player);
		return vars.byakugan && vars.byakuganactivate || vars.tenseigan && vars.tenseiganactivate;
	}
}
