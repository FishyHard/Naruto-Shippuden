package net.mcreator.narutoshippudenmod.client;

import net.mcreator.narutoshippudenmod.core.MultipartHitbox;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.debug.DebugScreenEntries;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.debug.DebugRenderer;
import net.minecraft.gizmos.GizmoStyle;
import net.minecraft.gizmos.Gizmos;
import net.minecraft.util.ARGB;
import net.minecraft.util.debug.DebugValueAccess;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterDebugRenderersEvent;
import net.neoforged.neoforge.entity.PartEntity;

/** F3+B: vanilla only draws the ender dragon's parts; this draws the {@link MultipartHitbox} parts the same way. */
@EventBusSubscriber(modid = "naruto_shippuden", value = Dist.CLIENT)
public final class PartHitboxDebugRenderer implements DebugRenderer.SimpleDebugRenderer {
	private static final int COLOR = ARGB.colorFromFloat(1.0F, 0.25F, 1.0F, 0.0F);
	private final Minecraft minecraft;

	private PartHitboxDebugRenderer(Minecraft minecraft) {
		this.minecraft = minecraft;
	}

	@SubscribeEvent
	public static void register(RegisterDebugRenderersEvent event) {
		if (Minecraft.getInstance().debugEntries.isCurrentlyEnabled(DebugScreenEntries.ENTITY_HITBOXES))
			event.register(PartHitboxDebugRenderer::new);
	}

	@Override
	public void emitGizmos(double camX, double camY, double camZ, DebugValueAccess debugValues, Frustum frustum, float partialTicks) {
		if (minecraft.level == null)
			return;
		for (Entity entity : minecraft.level.entitiesForRendering()) {
			if (!entity.isMultipartEntity() || entity.isInvisible())
				continue;
			for (PartEntity<?> part : entity.getParts()) {
				if (!(part instanceof MultipartHitbox.Part) || !frustum.isVisible(part.getBoundingBox()))
					continue;
				Vec3 offset = part.getPosition(partialTicks).subtract(part.position());
				Gizmos.cuboid(part.getBoundingBox().move(offset), GizmoStyle.stroke(COLOR));
			}
		}
	}
}
