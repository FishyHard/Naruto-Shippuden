package net.mcreator.narutoshippudenmod.procedures;

import net.minecraft.util.math.MathHelper;
import net.minecraft.entity.Entity;

import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables;
import net.mcreator.narutoshippudenmod.NarutoShippudenMod;

import java.util.Random;
import java.util.Map;

public class InfoCardMiniGameWhileThisGUIIsOpenTickProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure InfoCardMiniGameWhileThisGUIIsOpenTick!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity.ticksExisted % 10 == 0) {
			{
				double _setval = (MathHelper.nextInt(new Random(), 1, 48));
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Mini_Game_Timer_Button = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
