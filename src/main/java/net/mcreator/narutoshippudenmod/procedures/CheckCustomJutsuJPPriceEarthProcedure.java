package net.mcreator.narutoshippudenmod.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables;
import net.mcreator.narutoshippudenmod.NarutoShippudenMod;

import java.util.Map;

public class CheckCustomJutsuJPPriceEarthProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure CheckCustomJutsuJPPriceEarth!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsutype).equals("Ball")
				&& ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuspeed).equals("Slow")
				&& ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsurelease).equals("Earth")
				&& (entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 100) {
			{
				double _setval = 15;
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.customjutsujpcost = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsutype).equals("Wave")
				&& ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuspeed).equals("Slow")
				&& ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsurelease).equals("Earth")
				&& (entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 100) {
			{
				double _setval = 20;
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.customjutsujpcost = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsutype).equals("Disk")
				&& ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuspeed).equals("Slow")
				&& ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsurelease).equals("Earth")
				&& (entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 100) {
			{
				double _setval = 25;
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.customjutsujpcost = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsutype).equals("Ball")
				&& ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuspeed).equals("Medium")
				&& ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsurelease).equals("Earth")
				&& (entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 100) {
			{
				double _setval = 20;
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.customjutsujpcost = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsutype).equals("Ball")
				&& ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuspeed).equals("Fast")
				&& ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsurelease).equals("Earth")
				&& (entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 100) {
			{
				double _setval = 25;
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.customjutsujpcost = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsutype).equals("Wave")
				&& ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuspeed).equals("Medium")
				&& ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsurelease).equals("Earth")
				&& (entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 100) {
			{
				double _setval = 25;
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.customjutsujpcost = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsutype).equals("Wave")
				&& ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuspeed).equals("Fast")
				&& ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsurelease).equals("Earth")
				&& (entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 100) {
			{
				double _setval = 30;
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.customjutsujpcost = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsutype).equals("Disk")
				&& ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuspeed).equals("Medium")
				&& ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsurelease).equals("Earth")
				&& (entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 100) {
			{
				double _setval = 30;
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.customjutsujpcost = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsutype).equals("Disk")
				&& ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuspeed).equals("Fast")
				&& ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsurelease).equals("Earth")
				&& (entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 100) {
			{
				double _setval = 35;
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.customjutsujpcost = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsutype).equals("Ball")
				&& ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuspeed).equals("Slow")
				&& ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsurelease).equals("Earth")
				&& (entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 200) {
			{
				double _setval = 20;
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.customjutsujpcost = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsutype).equals("Ball")
				&& ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuspeed).equals("Slow")
				&& ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsurelease).equals("Earth")
				&& (entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 300) {
			{
				double _setval = 25;
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.customjutsujpcost = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsutype).equals("Ball")
				&& ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuspeed).equals("Slow")
				&& ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsurelease).equals("Earth")
				&& (entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 400) {
			{
				double _setval = 30;
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.customjutsujpcost = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsutype).equals("Ball")
				&& ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuspeed).equals("Slow")
				&& ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsurelease).equals("Earth")
				&& (entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 500) {
			{
				double _setval = 35;
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.customjutsujpcost = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsutype).equals("Ball")
				&& ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuspeed).equals("Medium")
				&& ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsurelease).equals("Earth")
				&& (entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 200) {
			{
				double _setval = 25;
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.customjutsujpcost = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsutype).equals("Ball")
				&& ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuspeed).equals("Medium")
				&& ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsurelease).equals("Earth")
				&& (entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 300) {
			{
				double _setval = 30;
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.customjutsujpcost = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsutype).equals("Ball")
				&& ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuspeed).equals("Medium")
				&& ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsurelease).equals("Earth")
				&& (entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 400) {
			{
				double _setval = 35;
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.customjutsujpcost = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsutype).equals("Ball")
				&& ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuspeed).equals("Medium")
				&& ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsurelease).equals("Earth")
				&& (entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 500) {
			{
				double _setval = 40;
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.customjutsujpcost = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsutype).equals("Ball")
				&& ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuspeed).equals("Fast")
				&& ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsurelease).equals("Water")
				&& (entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 200) {
			{
				double _setval = 30;
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.customjutsujpcost = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsutype).equals("Ball")
				&& ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuspeed).equals("Fast")
				&& ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsurelease).equals("Earth")
				&& (entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 300) {
			{
				double _setval = 35;
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.customjutsujpcost = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsutype).equals("Ball")
				&& ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuspeed).equals("Fast")
				&& ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsurelease).equals("Earth")
				&& (entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 400) {
			{
				double _setval = 40;
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.customjutsujpcost = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsutype).equals("Ball")
				&& ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuspeed).equals("Fast")
				&& ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsurelease).equals("Earth")
				&& (entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 500) {
			{
				double _setval = 45;
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.customjutsujpcost = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsutype).equals("Wave")
				&& ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuspeed).equals("Slow")
				&& ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsurelease).equals("Earth")
				&& (entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 200) {
			{
				double _setval = 25;
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.customjutsujpcost = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsutype).equals("Wave")
				&& ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuspeed).equals("Slow")
				&& ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsurelease).equals("Earth")
				&& (entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 300) {
			{
				double _setval = 30;
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.customjutsujpcost = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsutype).equals("Wave")
				&& ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuspeed).equals("Slow")
				&& ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsurelease).equals("Earth")
				&& (entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 400) {
			{
				double _setval = 35;
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.customjutsujpcost = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsutype).equals("Wave")
				&& ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuspeed).equals("Slow")
				&& ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsurelease).equals("Earth")
				&& (entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 500) {
			{
				double _setval = 40;
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.customjutsujpcost = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsutype).equals("Wave")
				&& ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuspeed).equals("Medium")
				&& ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsurelease).equals("Earth")
				&& (entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 200) {
			{
				double _setval = 30;
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.customjutsujpcost = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsutype).equals("Wave")
				&& ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuspeed).equals("Medium")
				&& ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsurelease).equals("Earth")
				&& (entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 300) {
			{
				double _setval = 35;
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.customjutsujpcost = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsutype).equals("Wave")
				&& ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuspeed).equals("Medium")
				&& ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsurelease).equals("Earth")
				&& (entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 400) {
			{
				double _setval = 40;
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.customjutsujpcost = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsutype).equals("Wave")
				&& ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuspeed).equals("Medium")
				&& ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsurelease).equals("Earth")
				&& (entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 500) {
			{
				double _setval = 45;
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.customjutsujpcost = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsutype).equals("Wave")
				&& ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuspeed).equals("Fast")
				&& ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsurelease).equals("Earth")
				&& (entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 200) {
			{
				double _setval = 35;
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.customjutsujpcost = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsutype).equals("Wave")
				&& ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuspeed).equals("Fast")
				&& ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsurelease).equals("Earth")
				&& (entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 300) {
			{
				double _setval = 40;
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.customjutsujpcost = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsutype).equals("Wave")
				&& ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuspeed).equals("Fast")
				&& ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsurelease).equals("Earth")
				&& (entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 400) {
			{
				double _setval = 45;
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.customjutsujpcost = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsutype).equals("Wave")
				&& ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuspeed).equals("Fast")
				&& ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsurelease).equals("Earth")
				&& (entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 500) {
			{
				double _setval = 50;
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.customjutsujpcost = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsutype).equals("Disk")
				&& ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuspeed).equals("Slow")
				&& ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsurelease).equals("Earth")
				&& (entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 200) {
			{
				double _setval = 30;
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.customjutsujpcost = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsutype).equals("Disk")
				&& ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuspeed).equals("Slow")
				&& ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsurelease).equals("Earth")
				&& (entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 300) {
			{
				double _setval = 35;
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.customjutsujpcost = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsutype).equals("Disk")
				&& ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuspeed).equals("Slow")
				&& ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsurelease).equals("Earth")
				&& (entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 400) {
			{
				double _setval = 40;
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.customjutsujpcost = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsutype).equals("Disk")
				&& ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuspeed).equals("Slow")
				&& ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsurelease).equals("Earth")
				&& (entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 500) {
			{
				double _setval = 45;
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.customjutsujpcost = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsutype).equals("Disk")
				&& ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuspeed).equals("Medium")
				&& ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsurelease).equals("Earth")
				&& (entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 200) {
			{
				double _setval = 35;
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.customjutsujpcost = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsutype).equals("Disk")
				&& ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuspeed).equals("Medium")
				&& ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsurelease).equals("Earth")
				&& (entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 300) {
			{
				double _setval = 40;
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.customjutsujpcost = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsutype).equals("Disk")
				&& ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuspeed).equals("Medium")
				&& ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsurelease).equals("Earth")
				&& (entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 400) {
			{
				double _setval = 45;
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.customjutsujpcost = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsutype).equals("Disk")
				&& ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuspeed).equals("Medium")
				&& ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsurelease).equals("Earth")
				&& (entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 500) {
			{
				double _setval = 50;
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.customjutsujpcost = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsutype).equals("Disk")
				&& ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuspeed).equals("Fast")
				&& ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsurelease).equals("Earth")
				&& (entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 200) {
			{
				double _setval = 40;
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.customjutsujpcost = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsutype).equals("Disk")
				&& ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuspeed).equals("Fast")
				&& ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsurelease).equals("Earth")
				&& (entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 300) {
			{
				double _setval = 45;
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.customjutsujpcost = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsutype).equals("Disk")
				&& ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuspeed).equals("Fast")
				&& ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsurelease).equals("Earth")
				&& (entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 400) {
			{
				double _setval = 50;
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.customjutsujpcost = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsutype).equals("Disk")
				&& ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuspeed).equals("Fast")
				&& ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsurelease).equals("Earth")
				&& (entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 500) {
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
