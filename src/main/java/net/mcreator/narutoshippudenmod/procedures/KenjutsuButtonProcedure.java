package net.mcreator.narutoshippudenmod.procedures;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables;
import net.mcreator.narutoshippudenmod.NarutoShippudenMod;

import java.util.Map;

public class KenjutsuButtonProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure KenjutsuButton!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (NarutoShippudenModVariables.get(entity).sp >= NarutoShippudenModVariables.get(entity).spusecount) {
			{
				double _setval = (NarutoShippudenModVariables.get(entity).sp
						- NarutoShippudenModVariables.get(entity).spusecount);
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.sp = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = (NarutoShippudenModVariables.get(entity).kenjutsu
						+ NarutoShippudenModVariables.get(entity).spusecount);
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.kenjutsu = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if (NarutoShippudenModVariables.get(entity).sp <= NarutoShippudenModVariables.get(entity).spusecount) {
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(
						("Not Enough SP Use Selected: " + NarutoShippudenModVariables.get(entity).spusecount)),
						(false));
			}
		}
	}
}
