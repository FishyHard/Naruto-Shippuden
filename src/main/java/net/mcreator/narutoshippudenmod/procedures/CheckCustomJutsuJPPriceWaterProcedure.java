package net.mcreator.narutoshippudenmod.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables;
import net.mcreator.narutoshippudenmod.NarutoShippudenMod;

import java.util.Map;

public class CheckCustomJutsuJPPriceWaterProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure CheckCustomJutsuJPPriceWater!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Ball")
				&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Slow")
				&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Water")
				&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
			{
				double _setval = 15;
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.customjutsujpcost = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Wave")
				&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Slow")
				&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Water")
				&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
			{
				double _setval = 20;
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.customjutsujpcost = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Disk")
				&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Slow")
				&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Water")
				&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
			{
				double _setval = 25;
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.customjutsujpcost = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Ball")
				&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Medium")
				&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Water")
				&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
			{
				double _setval = 20;
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.customjutsujpcost = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Ball")
				&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Fast")
				&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Water")
				&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
			{
				double _setval = 25;
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.customjutsujpcost = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Wave")
				&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Medium")
				&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Water")
				&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
			{
				double _setval = 25;
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.customjutsujpcost = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Wave")
				&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Fast")
				&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Water")
				&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
			{
				double _setval = 30;
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.customjutsujpcost = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Disk")
				&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Medium")
				&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Water")
				&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
			{
				double _setval = 30;
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.customjutsujpcost = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Disk")
				&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Fast")
				&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Water")
				&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
			{
				double _setval = 35;
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.customjutsujpcost = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Ball")
				&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Slow")
				&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Water")
				&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
			{
				double _setval = 20;
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.customjutsujpcost = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Ball")
				&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Slow")
				&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Water")
				&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
			{
				double _setval = 25;
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.customjutsujpcost = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Ball")
				&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Slow")
				&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Water")
				&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
			{
				double _setval = 30;
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.customjutsujpcost = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Ball")
				&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Slow")
				&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Water")
				&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
			{
				double _setval = 35;
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.customjutsujpcost = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Ball")
				&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Medium")
				&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Water")
				&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
			{
				double _setval = 25;
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.customjutsujpcost = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Ball")
				&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Medium")
				&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Water")
				&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
			{
				double _setval = 30;
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.customjutsujpcost = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Ball")
				&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Medium")
				&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Water")
				&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
			{
				double _setval = 35;
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.customjutsujpcost = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Ball")
				&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Medium")
				&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Water")
				&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
			{
				double _setval = 40;
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.customjutsujpcost = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Ball")
				&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Fast")
				&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Water")
				&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
			{
				double _setval = 30;
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.customjutsujpcost = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Ball")
				&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Fast")
				&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Water")
				&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
			{
				double _setval = 35;
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.customjutsujpcost = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Ball")
				&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Fast")
				&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Water")
				&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
			{
				double _setval = 40;
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.customjutsujpcost = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Ball")
				&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Fast")
				&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Water")
				&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
			{
				double _setval = 45;
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.customjutsujpcost = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Wave")
				&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Slow")
				&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Water")
				&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
			{
				double _setval = 25;
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.customjutsujpcost = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Wave")
				&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Slow")
				&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Water")
				&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
			{
				double _setval = 30;
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.customjutsujpcost = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Wave")
				&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Slow")
				&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Water")
				&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
			{
				double _setval = 35;
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.customjutsujpcost = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Wave")
				&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Slow")
				&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Water")
				&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
			{
				double _setval = 40;
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.customjutsujpcost = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Wave")
				&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Medium")
				&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Water")
				&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
			{
				double _setval = 30;
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.customjutsujpcost = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Wave")
				&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Medium")
				&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Water")
				&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
			{
				double _setval = 35;
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.customjutsujpcost = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Wave")
				&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Medium")
				&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Water")
				&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
			{
				double _setval = 40;
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.customjutsujpcost = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Wave")
				&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Medium")
				&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Water")
				&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
			{
				double _setval = 45;
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.customjutsujpcost = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Wave")
				&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Fast")
				&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Water")
				&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
			{
				double _setval = 35;
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.customjutsujpcost = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Wave")
				&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Fast")
				&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Water")
				&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
			{
				double _setval = 40;
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.customjutsujpcost = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Wave")
				&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Fast")
				&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Water")
				&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
			{
				double _setval = 45;
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.customjutsujpcost = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Wave")
				&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Fast")
				&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Water")
				&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
			{
				double _setval = 50;
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.customjutsujpcost = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Disk")
				&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Slow")
				&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Water")
				&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
			{
				double _setval = 30;
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.customjutsujpcost = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Disk")
				&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Slow")
				&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Water")
				&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
			{
				double _setval = 35;
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.customjutsujpcost = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Disk")
				&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Slow")
				&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Water")
				&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
			{
				double _setval = 40;
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.customjutsujpcost = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Disk")
				&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Slow")
				&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Water")
				&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
			{
				double _setval = 45;
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.customjutsujpcost = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Disk")
				&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Medium")
				&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Water")
				&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
			{
				double _setval = 35;
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.customjutsujpcost = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Disk")
				&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Medium")
				&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Water")
				&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
			{
				double _setval = 40;
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.customjutsujpcost = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Disk")
				&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Medium")
				&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Water")
				&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
			{
				double _setval = 45;
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.customjutsujpcost = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Disk")
				&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Medium")
				&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Water")
				&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
			{
				double _setval = 50;
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.customjutsujpcost = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Disk")
				&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Fast")
				&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Water")
				&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
			{
				double _setval = 40;
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.customjutsujpcost = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Disk")
				&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Fast")
				&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Water")
				&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
			{
				double _setval = 45;
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.customjutsujpcost = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Disk")
				&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Fast")
				&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Water")
				&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
			{
				double _setval = 50;
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.customjutsujpcost = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Disk")
				&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Fast")
				&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Water")
				&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
			{
				double _setval = 55;
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.customjutsujpcost = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
