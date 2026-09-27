/**
 * The code of this mod element is always locked.
 *
 * You can register new events in this class too.
 *
 * If you want to make a plain independent class, create it using
 * Project Browser -> New... and make sure to make the class
 * outside net.mcreator.narutoshippudenmod as this package is managed by MCreator.
 *
 * If you change workspace package, modid or prefix, you will need
 * to manually adapt this file to these changes or remake it.
 *
 * This class will be added in the mod root package.
*/
package net.mcreator.narutoshippudenmod;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;


import net.neoforged.bus.api.SubscribeEvent;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import java.util.Map;
import net.neoforged.neoforge.client.event.ComputeFovModifierEvent;
import net.neoforged.neoforge.client.event.ViewportEvent;
import net.neoforged.api.distmarker.OnlyIn;
import net.minecraft.client.CameraType;
import net.neoforged.bus.api.EventPriority;

public class OverlayEventHandler {
    @SubscribeEvent
    public void onRenderGameOverlayEventPre(RenderGameOverlayEvent event) {
        if (event.getType() != RenderGameOverlayEvent.ElementType.HEALTH)
            return;
        /* Don't render the vanilla health */
        event.setCanceled(true);
    }
}
