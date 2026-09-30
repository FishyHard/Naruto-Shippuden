package net.mcreator.narutoshippudenmod.procedures;

import net.mcreator.narutoshippudenmod.compat.Compat;
import net.mcreator.narutoshippudenmod.compat.ModArrow;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;
import net.mcreator.narutoshippudenmod.NarutoShippudenMod;
import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables;
import net.mcreator.narutoshippudenmod.item.ReleaseTechniqueItems.CustomEarthReleaseTechniqueItem;
import net.mcreator.narutoshippudenmod.item.ReleaseTechniqueItems.CustomFireReleaseTechniqueItem;
import net.mcreator.narutoshippudenmod.item.ReleaseTechniqueItems.CustomLightningReleaseTechniqueItem;
import net.mcreator.narutoshippudenmod.item.ReleaseTechniqueItems.CustomWaterReleaseTechniqueItem;
import net.mcreator.narutoshippudenmod.item.ReleaseTechniqueItems.CustomWindReleaseTechniqueItem;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.arrow.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;

public final class CustomJutsuProcedures {
	private CustomJutsuProcedures() {
	}

	public static class CheckCustomJutsuJPPriceEarthProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure CheckCustomJutsuJPPriceEarth!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Ball")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Slow")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Earth")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
				{
					double _setval = 15;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Wave")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Slow")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Earth")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
				{
					double _setval = 20;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Disk")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Slow")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Earth")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
				{
					double _setval = 25;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Ball")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Medium")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Earth")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
				{
					double _setval = 20;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Ball")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Fast")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Earth")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
				{
					double _setval = 25;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Wave")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Medium")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Earth")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
				{
					double _setval = 25;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Wave")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Fast")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Earth")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
				{
					double _setval = 30;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Disk")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Medium")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Earth")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
				{
					double _setval = 30;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Disk")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Fast")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Earth")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
				{
					double _setval = 35;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Ball")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Slow")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Earth")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
				{
					double _setval = 20;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Ball")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Slow")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Earth")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
				{
					double _setval = 25;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Ball")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Slow")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Earth")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
				{
					double _setval = 30;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Ball")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Slow")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Earth")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
				{
					double _setval = 35;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Ball")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Medium")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Earth")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
				{
					double _setval = 25;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Ball")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Medium")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Earth")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
				{
					double _setval = 30;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Ball")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Medium")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Earth")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
				{
					double _setval = 35;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Ball")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Medium")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Earth")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
				{
					double _setval = 40;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
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
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Ball")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Fast")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Earth")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
				{
					double _setval = 35;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Ball")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Fast")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Earth")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
				{
					double _setval = 40;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Ball")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Fast")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Earth")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
				{
					double _setval = 45;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Wave")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Slow")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Earth")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
				{
					double _setval = 25;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Wave")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Slow")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Earth")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
				{
					double _setval = 30;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Wave")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Slow")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Earth")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
				{
					double _setval = 35;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Wave")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Slow")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Earth")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
				{
					double _setval = 40;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Wave")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Medium")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Earth")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
				{
					double _setval = 30;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Wave")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Medium")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Earth")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
				{
					double _setval = 35;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Wave")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Medium")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Earth")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
				{
					double _setval = 40;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Wave")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Medium")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Earth")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
				{
					double _setval = 45;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Wave")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Fast")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Earth")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
				{
					double _setval = 35;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Wave")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Fast")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Earth")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
				{
					double _setval = 40;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Wave")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Fast")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Earth")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
				{
					double _setval = 45;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Wave")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Fast")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Earth")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
				{
					double _setval = 50;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Disk")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Slow")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Earth")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
				{
					double _setval = 30;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Disk")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Slow")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Earth")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
				{
					double _setval = 35;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Disk")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Slow")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Earth")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
				{
					double _setval = 40;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Disk")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Slow")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Earth")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
				{
					double _setval = 45;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Disk")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Medium")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Earth")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
				{
					double _setval = 35;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Disk")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Medium")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Earth")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
				{
					double _setval = 40;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Disk")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Medium")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Earth")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
				{
					double _setval = 45;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Disk")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Medium")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Earth")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
				{
					double _setval = 50;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Disk")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Fast")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Earth")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
				{
					double _setval = 40;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Disk")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Fast")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Earth")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
				{
					double _setval = 45;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Disk")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Fast")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Earth")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
				{
					double _setval = 50;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Disk")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Fast")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Earth")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
				{
					double _setval = 55;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
	}

	public static class CheckCustomJutsuJPPriceFireProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure CheckCustomJutsuJPPriceFire!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Ball")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Slow")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Fire")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
				{
					double _setval = 20;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Wave")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Slow")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Fire")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
				{
					double _setval = 25;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Disk")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Slow")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Fire")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
				{
					double _setval = 30;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Ball")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Medium")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Fire")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
				{
					double _setval = 25;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Ball")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Fast")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Fire")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
				{
					double _setval = 30;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Wave")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Medium")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Fire")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
				{
					double _setval = 30;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Wave")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Fast")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Fire")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
				{
					double _setval = 35;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Disk")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Medium")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Fire")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
				{
					double _setval = 35;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Disk")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Fast")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Fire")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
				{
					double _setval = 40;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Ball")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Slow")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Fire")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
				{
					double _setval = 25;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Ball")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Slow")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Fire")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
				{
					double _setval = 30;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Ball")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Slow")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Fire")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
				{
					double _setval = 35;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Ball")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Slow")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Fire")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
				{
					double _setval = 40;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Ball")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Medium")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Fire")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
				{
					double _setval = 30;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Ball")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Medium")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Fire")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
				{
					double _setval = 35;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Ball")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Medium")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Fire")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
				{
					double _setval = 40;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Ball")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Medium")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Fire")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
				{
					double _setval = 45;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Ball")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Fast")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Fire")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
				{
					double _setval = 35;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Ball")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Fast")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Fire")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
				{
					double _setval = 40;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Ball")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Fast")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Fire")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
				{
					double _setval = 45;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Ball")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Fast")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Fire")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
				{
					double _setval = 50;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Wave")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Slow")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Fire")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
				{
					double _setval = 30;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Wave")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Slow")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Fire")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
				{
					double _setval = 35;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Wave")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Slow")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Fire")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
				{
					double _setval = 40;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Wave")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Slow")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Fire")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
				{
					double _setval = 45;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Wave")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Medium")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Fire")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
				{
					double _setval = 35;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Wave")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Medium")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Fire")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
				{
					double _setval = 40;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Wave")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Medium")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Fire")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
				{
					double _setval = 45;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Wave")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Medium")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Fire")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
				{
					double _setval = 50;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Wave")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Fast")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Fire")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
				{
					double _setval = 40;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Wave")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Fast")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Fire")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
				{
					double _setval = 45;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Wave")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Fast")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Fire")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
				{
					double _setval = 50;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Wave")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Fast")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Fire")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
				{
					double _setval = 55;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Disk")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Slow")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Fire")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
				{
					double _setval = 35;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Disk")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Slow")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Fire")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
				{
					double _setval = 40;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Disk")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Slow")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Fire")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
				{
					double _setval = 45;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Disk")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Slow")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Fire")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
				{
					double _setval = 50;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Disk")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Medium")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Fire")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
				{
					double _setval = 40;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Disk")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Medium")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Fire")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
				{
					double _setval = 45;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Disk")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Medium")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Fire")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
				{
					double _setval = 50;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Disk")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Medium")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Fire")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
				{
					double _setval = 55;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Disk")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Fast")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Fire")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
				{
					double _setval = 45;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Disk")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Fast")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Fire")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
				{
					double _setval = 50;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Disk")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Fast")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Fire")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
				{
					double _setval = 55;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Disk")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Fast")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Fire")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
				{
					double _setval = 60;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
	}

	public static class CheckCustomJutsuJPPriceLightningProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure CheckCustomJutsuJPPriceLightning!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Ball")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Slow")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Lightning")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
				{
					double _setval = 20;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Wave")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Slow")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Lightning")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
				{
					double _setval = 25;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Disk")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Slow")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Lightning")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
				{
					double _setval = 30;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Ball")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Medium")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Lightning")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
				{
					double _setval = 25;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Ball")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Fast")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Lightning")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
				{
					double _setval = 30;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Wave")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Medium")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Lightning")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
				{
					double _setval = 30;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Wave")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Fast")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Lightning")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
				{
					double _setval = 35;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Disk")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Medium")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Lightning")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
				{
					double _setval = 35;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Disk")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Fast")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Lightning")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
				{
					double _setval = 40;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Ball")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Slow")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Lightning")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
				{
					double _setval = 25;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Ball")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Slow")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Lightning")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
				{
					double _setval = 30;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Ball")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Slow")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Lightning")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
				{
					double _setval = 35;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Ball")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Slow")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Lightning")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
				{
					double _setval = 40;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Ball")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Medium")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Lightning")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
				{
					double _setval = 30;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Ball")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Medium")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Lightning")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
				{
					double _setval = 35;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Ball")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Medium")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Lightning")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
				{
					double _setval = 40;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Ball")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Medium")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Lightning")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
				{
					double _setval = 45;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Ball")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Fast")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Lightning")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
				{
					double _setval = 35;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Ball")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Fast")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Lightning")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
				{
					double _setval = 40;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Ball")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Fast")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Lightning")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
				{
					double _setval = 45;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Ball")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Fast")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Lightning")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
				{
					double _setval = 50;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Wave")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Slow")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Lightning")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
				{
					double _setval = 30;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Wave")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Slow")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Lightning")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
				{
					double _setval = 35;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Wave")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Slow")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Lightning")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
				{
					double _setval = 40;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Wave")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Slow")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Lightning")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
				{
					double _setval = 45;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Wave")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Medium")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Lightning")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
				{
					double _setval = 35;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Wave")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Medium")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Lightning")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
				{
					double _setval = 40;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Wave")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Medium")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Lightning")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
				{
					double _setval = 45;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Wave")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Medium")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Lightning")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
				{
					double _setval = 50;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Wave")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Fast")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Lightning")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
				{
					double _setval = 40;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Wave")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Fast")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Lightning")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
				{
					double _setval = 45;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Wave")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Fast")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Lightning")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
				{
					double _setval = 50;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Wave")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Fast")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Lightning")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
				{
					double _setval = 55;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Disk")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Slow")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Lightning")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
				{
					double _setval = 35;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Disk")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Slow")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Lightning")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
				{
					double _setval = 40;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Disk")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Slow")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Lightning")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
				{
					double _setval = 45;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Disk")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Slow")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Lightning")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
				{
					double _setval = 50;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Disk")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Medium")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Lightning")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
				{
					double _setval = 40;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Disk")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Medium")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Lightning")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
				{
					double _setval = 45;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Disk")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Medium")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Lightning")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
				{
					double _setval = 50;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Disk")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Medium")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Lightning")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
				{
					double _setval = 55;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Disk")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Fast")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Lightning")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
				{
					double _setval = 45;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Disk")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Fast")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Lightning")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
				{
					double _setval = 50;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Disk")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Fast")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Lightning")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
				{
					double _setval = 55;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Disk")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Fast")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Lightning")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
				{
					double _setval = 60;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
	}

	public static class CheckCustomJutsuJPPriceProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure CheckCustomJutsuJPPrice!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");

			CheckCustomJutsuJPPriceFireProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));

			CheckCustomJutsuJPPriceWindProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));

			CheckCustomJutsuJPPriceLightningProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));

			CheckCustomJutsuJPPriceWaterProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));

			CheckCustomJutsuJPPriceEarthProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			{
				boolean _setval = (true);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.customjutsucheckpricelogic = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}

	public static class CheckCustomJutsuJPPriceWaterProcedure {

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
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
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
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
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
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
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
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
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
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
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
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
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
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
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
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
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
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
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
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
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
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
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
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
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
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
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
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
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
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
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
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
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
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
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
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
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
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
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
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
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
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
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
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
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
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
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
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
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
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
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
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
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
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
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
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
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
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
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
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
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
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
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
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
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
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
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
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
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
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
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
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
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
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
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
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
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
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
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
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
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
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
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
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
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
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
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
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
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
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
	}

	public static class CheckCustomJutsuJPPriceWindProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure CheckCustomJutsuJPPriceWind!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Ball")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Slow")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Wind")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
				{
					double _setval = 20;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Wave")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Slow")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Wind")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
				{
					double _setval = 25;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Disk")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Slow")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Wind")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
				{
					double _setval = 30;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Ball")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Medium")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Wind")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
				{
					double _setval = 25;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Ball")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Fast")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Wind")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
				{
					double _setval = 30;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Wave")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Medium")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Wind")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
				{
					double _setval = 30;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Wave")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Fast")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Wind")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
				{
					double _setval = 35;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Disk")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Medium")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Wind")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
				{
					double _setval = 35;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Disk")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Fast")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Wind")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
				{
					double _setval = 40;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Ball")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Slow")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Wind")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
				{
					double _setval = 25;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Ball")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Slow")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Wind")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
				{
					double _setval = 30;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Ball")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Slow")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Wind")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
				{
					double _setval = 35;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Ball")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Slow")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Wind")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
				{
					double _setval = 40;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Ball")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Medium")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Wind")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
				{
					double _setval = 30;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Ball")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Medium")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Wind")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
				{
					double _setval = 35;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Ball")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Medium")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Wind")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
				{
					double _setval = 40;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Ball")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Medium")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Wind")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
				{
					double _setval = 45;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Ball")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Fast")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Wind")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
				{
					double _setval = 35;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Ball")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Fast")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Wind")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
				{
					double _setval = 40;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Ball")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Fast")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Wind")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
				{
					double _setval = 45;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Ball")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Fast")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Wind")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
				{
					double _setval = 50;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Wave")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Slow")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Wind")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
				{
					double _setval = 30;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Wave")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Slow")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Wind")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
				{
					double _setval = 35;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Wave")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Slow")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Wind")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
				{
					double _setval = 40;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Wave")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Slow")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Wind")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
				{
					double _setval = 45;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Wave")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Medium")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Wind")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
				{
					double _setval = 35;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Wave")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Medium")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Wind")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
				{
					double _setval = 40;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Wave")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Medium")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Wind")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
				{
					double _setval = 45;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Wave")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Medium")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Wind")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
				{
					double _setval = 50;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Wave")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Fast")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Wind")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
				{
					double _setval = 40;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Wave")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Fast")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Wind")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
				{
					double _setval = 45;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Wave")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Fast")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Wind")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
				{
					double _setval = 50;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Wave")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Fast")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Wind")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
				{
					double _setval = 55;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Disk")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Slow")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Wind")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
				{
					double _setval = 35;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Disk")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Slow")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Wind")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
				{
					double _setval = 40;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Disk")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Slow")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Wind")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
				{
					double _setval = 45;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Disk")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Slow")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Wind")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
				{
					double _setval = 50;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Disk")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Medium")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Wind")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
				{
					double _setval = 40;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Disk")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Medium")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Wind")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
				{
					double _setval = 45;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Disk")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Medium")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Wind")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
				{
					double _setval = 50;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Disk")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Medium")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Wind")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
				{
					double _setval = 55;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Disk")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Fast")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Wind")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
				{
					double _setval = 45;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Disk")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Fast")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Wind")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
				{
					double _setval = 50;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Disk")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Fast")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Wind")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
				{
					double _setval = 55;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Disk")
					&& (NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Fast")
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Wind")
					&& NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
				{
					double _setval = 60;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
	}



	public static class CustomJutsuButtonMinusChakraProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure CustomJutsuButtonMinusChakra!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
				{
					double _setval = 500;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsuchakra = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
				{
					double _setval = 400;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsuchakra = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
				{
					double _setval = 300;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsuchakra = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
				{
					double _setval = 200;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsuchakra = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
				{
					double _setval = 100;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsuchakra = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
	}

	public static class CustomJutsuButtonMinusFireProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure CustomJutsuButtonMinusFire!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if ((NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Fire")) {
				{
					String _setval = "Earth";
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsurelease = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if ((NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Earth")) {
				{
					String _setval = "Water";
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsurelease = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if ((NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Water")) {
				{
					String _setval = "Lightning";
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsurelease = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if ((NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Lightning")) {
				{
					String _setval = "Wind";
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsurelease = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if ((NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Wind")) {
				{
					String _setval = "Fire";
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsurelease = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
	}

	public static class CustomJutsuButtonMinusSpeedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure CustomJutsuButtonMinusSpeed!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if ((NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Slow")) {
				{
					String _setval = "Fast";
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsuspeed = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Medium")) {
				{
					String _setval = "Slow";
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsuspeed = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Fast")) {
				{
					String _setval = "Medium";
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsuspeed = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
	}

	public static class CustomJutsuButtonMinusTypeProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure CustomJutsuButtonMinusType!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Ball")) {
				{
					String _setval = "Wave";
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsutype = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Wave")) {
				{
					String _setval = "Disk";
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsutype = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Disk")) {
				{
					String _setval = "Ball";
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsutype = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
	}

	public static class CustomJutsuButtonPlusChakraProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure CustomJutsuButtonPlusChakra!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
				{
					double _setval = 200;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsuchakra = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
				{
					double _setval = 300;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsuchakra = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
				{
					double _setval = 400;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsuchakra = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
				{
					double _setval = 500;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsuchakra = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
				{
					double _setval = 100;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsuchakra = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
	}

	public static class CustomJutsuButtonPlusFireProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure CustomJutsuButtonPlusFire!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if ((NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Fire")) {
				{
					String _setval = "Wind";
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsurelease = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if ((NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Wind")) {
				{
					String _setval = "Lightning";
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsurelease = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if ((NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Lightning")) {
				{
					String _setval = "Water";
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsurelease = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if ((NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Water")) {
				{
					String _setval = "Earth";
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsurelease = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if ((NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Earth")) {
				{
					String _setval = "Fire";
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsurelease = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
	}

	public static class CustomJutsuButtonPlusSpeedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure CustomJutsuButtonPlusSpeed!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if ((NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Slow")) {
				{
					String _setval = "Medium";
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsuspeed = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Medium")) {
				{
					String _setval = "Fast";
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsuspeed = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Fast")) {
				{
					String _setval = "Slow";
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsuspeed = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
	}

	public static class CustomJutsuButtonPlusTypeProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure CustomJutsuButtonPlusType!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Ball")) {
				{
					String _setval = "Disk";
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsutype = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Disk")) {
				{
					String _setval = "Wave";
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsutype = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Wave")) {
				{
					String _setval = "Ball";
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsutype = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
	}




	public static class LearnCustomJutsu1Procedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure LearnCustomJutsu1!");
				return;
			}
			if (dependencies.get("guistate") == null) {
				if (!dependencies.containsKey("guistate"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency guistate for procedure LearnCustomJutsu1!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			HashMap guistate = (HashMap) dependencies.get("guistate");
			ItemStack customjutsuname = ItemStack.EMPTY;
			if (NarutoShippudenModVariables.get(entity).customjutsucheckpricelogic == true) {
				if (!(new Object() {
					public String getText() {
						EditBox _tf = (EditBox) guistate.get("text:Jutsu_Name");
						if (_tf != null) {
							return _tf.getValue();
						}
						return "";
					}
				}.getText()).equals("")) {
					if (NarutoShippudenModVariables.get(entity).customjutsujpreadybuy == false) {
						if ((NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Fire")) {
							if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Ball")) {
								if ((NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Slow")) {
									if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
										{
											double _setval = 20;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
										{
											double _setval = 25;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
										{
											double _setval = 30;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
										{
											double _setval = 35;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
										{
											double _setval = 40;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Medium")) {
									if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
										{
											double _setval = 25;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
										{
											double _setval = 30;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
										{
											double _setval = 35;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
										{
											double _setval = 40;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
										{
											double _setval = 45;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Fast")) {
									if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
										{
											double _setval = 30;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
										{
											double _setval = 35;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
										{
											double _setval = 40;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
										{
											double _setval = 45;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
										{
											double _setval = 50;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									}
								}
							} else if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Wave")) {
								if ((NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Slow")) {
									if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
										{
											double _setval = 25;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
										{
											double _setval = 30;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
										{
											double _setval = 35;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
										{
											double _setval = 40;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
										{
											double _setval = 45;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Medium")) {
									if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
										{
											double _setval = 30;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
										{
											double _setval = 35;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
										{
											double _setval = 40;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
										{
											double _setval = 45;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
										{
											double _setval = 50;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Fast")) {
									if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
										{
											double _setval = 35;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
										{
											double _setval = 40;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
										{
											double _setval = 45;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
										{
											double _setval = 50;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
										{
											double _setval = 55;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									}
								}
							} else if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Disk")) {
								if ((NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Slow")) {
									if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
										{
											double _setval = 30;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
										{
											double _setval = 35;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
										{
											double _setval = 40;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
										{
											double _setval = 45;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
										{
											double _setval = 50;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Medium")) {
									if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
										{
											double _setval = 35;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
										{
											double _setval = 40;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
										{
											double _setval = 45;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
										{
											double _setval = 50;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
										{
											double _setval = 55;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Fast")) {
									if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
										{
											double _setval = 40;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
										{
											double _setval = 45;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
										{
											double _setval = 50;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
										{
											double _setval = 55;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
										{
											double _setval = 60;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									}
								}
							}
							{
								boolean _setval = (true);
								NarutoShippudenModVariables.ifPresent(entity, capability -> {
									capability.customjutsufire = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						} else if ((NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Wind")) {
							if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Ball")) {
								if ((NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Slow")) {
									if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
										{
											double _setval = 20;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
										{
											double _setval = 25;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
										{
											double _setval = 30;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
										{
											double _setval = 35;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
										{
											double _setval = 40;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Medium")) {
									if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
										{
											double _setval = 25;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
										{
											double _setval = 30;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
										{
											double _setval = 35;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
										{
											double _setval = 40;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
										{
											double _setval = 45;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Fast")) {
									if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
										{
											double _setval = 30;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
										{
											double _setval = 35;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
										{
											double _setval = 40;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
										{
											double _setval = 50;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									}
								}
							} else if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Wave")) {
								if ((NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Slow")) {
									if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
										{
											double _setval = 25;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
										{
											double _setval = 30;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
										{
											double _setval = 35;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
										{
											double _setval = 40;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
										{
											double _setval = 45;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Medium")) {
									if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
										{
											double _setval = 30;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
										{
											double _setval = 35;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
										{
											double _setval = 40;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
										{
											double _setval = 45;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
										{
											double _setval = 50;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Fast")) {
									if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
										{
											double _setval = 35;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
										{
											double _setval = 40;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
										{
											double _setval = 45;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
										{
											double _setval = 50;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
										{
											double _setval = 55;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									}
								}
							} else if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Disk")) {
								if ((NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Slow")) {
									if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
										{
											double _setval = 30;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
										{
											double _setval = 35;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
										{
											double _setval = 40;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
										{
											double _setval = 45;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
										{
											double _setval = 50;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Medium")) {
									if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
										{
											double _setval = 35;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
										{
											double _setval = 40;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
										{
											double _setval = 45;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
										{
											double _setval = 50;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
										{
											double _setval = 55;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Fast")) {
									if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
										{
											double _setval = 40;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
										{
											double _setval = 45;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
										{
											double _setval = 50;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
										{
											double _setval = 55;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
										{
											double _setval = 60;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									}
								}
							}
							{
								boolean _setval = (true);
								NarutoShippudenModVariables.ifPresent(entity, capability -> {
									capability.customjutsuwind = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						} else if ((NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Lightning")) {
							if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Ball")) {
								if ((NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Slow")) {
									if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
										{
											double _setval = 20;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
										{
											double _setval = 25;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
										{
											double _setval = 30;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
										{
											double _setval = 35;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
										{
											double _setval = 40;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Medium")) {
									if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
										{
											double _setval = 25;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
										{
											double _setval = 30;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
										{
											double _setval = 35;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
										{
											double _setval = 40;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
										{
											double _setval = 45;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Fast")) {
									if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
										{
											double _setval = 30;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
										{
											double _setval = 35;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
										{
											double _setval = 40;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
										{
											double _setval = 45;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
										{
											double _setval = 50;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									}
								}
							} else if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Wave")) {
								if ((NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Slow")) {
									if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
										{
											double _setval = 25;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
										{
											double _setval = 30;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
										{
											double _setval = 35;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
										{
											double _setval = 40;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
										{
											double _setval = 45;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Medium")) {
									if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
										{
											double _setval = 30;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
										{
											double _setval = 35;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
										{
											double _setval = 40;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
										{
											double _setval = 45;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
										{
											double _setval = 50;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Fast")) {
									if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
										{
											double _setval = 35;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
										{
											double _setval = 40;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
										{
											double _setval = 45;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
										{
											double _setval = 50;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
										{
											double _setval = 55;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									}
								}
							} else if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Disk")) {
								if ((NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Slow")) {
									if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
										{
											double _setval = 30;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
										{
											double _setval = 35;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
										{
											double _setval = 40;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
										{
											double _setval = 45;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
										{
											double _setval = 50;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Medium")) {
									if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
										{
											double _setval = 35;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
										{
											double _setval = 40;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
										{
											double _setval = 45;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
										{
											double _setval = 50;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
										{
											double _setval = 55;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Fast")) {
									if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
										{
											double _setval = 40;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
										{
											double _setval = 45;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
										{
											double _setval = 50;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
										{
											double _setval = 55;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
										{
											double _setval = 60;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									}
								}
							}
							{
								boolean _setval = (true);
								NarutoShippudenModVariables.ifPresent(entity, capability -> {
									capability.customjutsulightning = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						} else if ((NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Water")) {
							if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Ball")) {
								if ((NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Slow")) {
									if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
										{
											double _setval = 15;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
										{
											double _setval = 20;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
										{
											double _setval = 25;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
										{
											double _setval = 30;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
										{
											double _setval = 35;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Medium")) {
									if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
										{
											double _setval = 20;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
										{
											double _setval = 25;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
										{
											double _setval = 30;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
										{
											double _setval = 35;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
										{
											double _setval = 40;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Fast")) {
									if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
										{
											double _setval = 25;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
										{
											double _setval = 30;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
										{
											double _setval = 35;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
										{
											double _setval = 40;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
										{
											double _setval = 45;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									}
								}
							} else if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Wave")) {
								if ((NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Slow")) {
									if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
										{
											double _setval = 20;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
										{
											double _setval = 25;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
										{
											double _setval = 30;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
										{
											double _setval = 35;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
										{
											double _setval = 40;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Medium")) {
									if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
										{
											double _setval = 25;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
										{
											double _setval = 30;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
										{
											double _setval = 35;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
										{
											double _setval = 40;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
										{
											double _setval = 45;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Fast")) {
									if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
										{
											double _setval = 30;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
										{
											double _setval = 35;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
										{
											double _setval = 40;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
										{
											double _setval = 45;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
										{
											double _setval = 50;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									}
								}
							} else if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Disk")) {
								if ((NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Slow")) {
									if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
										{
											double _setval = 25;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
										{
											double _setval = 30;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
										{
											double _setval = 35;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
										{
											double _setval = 40;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
										{
											double _setval = 45;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Medium")) {
									if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
										{
											double _setval = 30;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
										{
											double _setval = 35;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
										{
											double _setval = 40;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
										{
											double _setval = 45;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
										{
											double _setval = 50;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Fast")) {
									if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
										{
											double _setval = 35;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
										{
											double _setval = 40;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
										{
											double _setval = 45;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
										{
											double _setval = 50;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
										{
											double _setval = 55;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									}
								}
							}
							{
								boolean _setval = (true);
								NarutoShippudenModVariables.ifPresent(entity, capability -> {
									capability.customjutsuwater = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						} else if ((NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Earth")) {
							if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Ball")) {
								if ((NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Slow")) {
									if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
										{
											double _setval = 15;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
										{
											double _setval = 20;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
										{
											double _setval = 25;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
										{
											double _setval = 30;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
										{
											double _setval = 35;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Medium")) {
									if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
										{
											double _setval = 20;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
										{
											double _setval = 25;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
										{
											double _setval = 30;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
										{
											double _setval = 35;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
										{
											double _setval = 40;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Fast")) {
									if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
										{
											double _setval = 25;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
										{
											double _setval = 30;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
										{
											double _setval = 35;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
										{
											double _setval = 40;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
										{
											double _setval = 45;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									}
								}
							} else if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Wave")) {
								if ((NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Slow")) {
									if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
										{
											double _setval = 20;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
										{
											double _setval = 25;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
										{
											double _setval = 30;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
										{
											double _setval = 35;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
										{
											double _setval = 40;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Medium")) {
									if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
										{
											double _setval = 25;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
										{
											double _setval = 30;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
										{
											double _setval = 35;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
										{
											double _setval = 40;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
										{
											double _setval = 45;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Fast")) {
									if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
										{
											double _setval = 30;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
										{
											double _setval = 35;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
										{
											double _setval = 40;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
										{
											double _setval = 45;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
										{
											double _setval = 50;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									}
								}
							} else if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Disk")) {
								if ((NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Slow")) {
									if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
										{
											double _setval = 25;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
										{
											double _setval = 30;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
										{
											double _setval = 35;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
										{
											double _setval = 40;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
										{
											double _setval = 45;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Medium")) {
									if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
										{
											double _setval = 30;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
										{
											double _setval = 35;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
										{
											double _setval = 40;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
										{
											double _setval = 45;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
										{
											double _setval = 50;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Fast")) {
									if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
										{
											double _setval = 35;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
										{
											double _setval = 40;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
										{
											double _setval = 45;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
										{
											double _setval = 50;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
										{
											double _setval = 55;
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									}
								}
							}
							{
								boolean _setval = (true);
								NarutoShippudenModVariables.ifPresent(entity, capability -> {
									capability.customjutsuearth = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						}
						{
							String _setval = (NarutoShippudenModVariables.get(entity).customjutsutype);
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.customjutsutypesave = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							String _setval = (NarutoShippudenModVariables.get(entity).customjutsuspeed);
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.customjutsuspeedsave = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							String _setval = (NarutoShippudenModVariables.get(entity).customjutsurelease);
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.customjutsureleasesave = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							String _setval = (new Object() {
								public String getText() {
									EditBox _tf = (EditBox) guistate.get("text:Jutsu_Name");
									if (_tf != null) {
										return _tf.getValue();
									}
									return "";
								}
							}.getText());
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.jutsunamesave = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = (NarutoShippudenModVariables.get(entity).customjutsuchakra);
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.customjutsuchakrasave = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							boolean _setval = (true);
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.customjutsujpreadybuy = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Press Learn button again"));
						}
					} else if (NarutoShippudenModVariables.get(entity).customjutsujpreadybuy == true) {
						if (NarutoShippudenModVariables.get(entity).jp >= NarutoShippudenModVariables.get(entity).customjutsujpcost) {
							{
								double _setval = (NarutoShippudenModVariables.get(entity).jp
										- NarutoShippudenModVariables.get(entity).customjutsujpcost);
								NarutoShippudenModVariables.ifPresent(entity, capability -> {
									capability.jp = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity)
										.sendSystemMessage(
												Component.literal(
														("-" + NarutoShippudenModVariables.get(entity).customjutsujpcost + " JP")));
							}
							{
								String _setval = (NarutoShippudenModVariables.get(entity).customjutsutypesave);
								NarutoShippudenModVariables.ifPresent(entity, capability -> {
									capability.customjutsutype1save = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								String _setval = (NarutoShippudenModVariables.get(entity).customjutsuspeedsave);
								NarutoShippudenModVariables.ifPresent(entity, capability -> {
									capability.customjutsuspeed1save = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								String _setval = (NarutoShippudenModVariables.get(entity).customjutsureleasesave);
								NarutoShippudenModVariables.ifPresent(entity, capability -> {
									capability.customjutsurelease1save = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								String _setval = (NarutoShippudenModVariables.get(entity).jutsunamesave);
								NarutoShippudenModVariables.ifPresent(entity, capability -> {
									capability.jutsunamesave1 = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = (NarutoShippudenModVariables.get(entity).customjutsuchakrasave);
								NarutoShippudenModVariables.ifPresent(entity, capability -> {
									capability.customjutsuchakra1save = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								boolean _setval = (false);
								NarutoShippudenModVariables.ifPresent(entity, capability -> {
									capability.customjutsujpreadybuy = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							if ((NarutoShippudenModVariables.get(entity).customjutsureleasesave).equals("Fire")) {
								customjutsuname = new ItemStack(CustomFireReleaseTechniqueItem.block);
								Compat.setName((customjutsuname), Component.literal(
										("Fire Release: " + NarutoShippudenModVariables.get(entity).jutsunamesave1)));
								if (entity instanceof Player) {
									ItemStack _setstack = (customjutsuname);
									_setstack.setCount((int) 1);
									Compat.giveItemToPlayer(((Player) entity), _setstack);
								}
							} else if ((NarutoShippudenModVariables.get(entity).customjutsureleasesave).equals("Lightning")) {
								customjutsuname = new ItemStack(CustomLightningReleaseTechniqueItem.block);
								Compat.setName((customjutsuname), Component.literal(
										("Lightning Release: " + NarutoShippudenModVariables.get(entity).jutsunamesave1)));
								if (entity instanceof Player) {
									ItemStack _setstack = (customjutsuname);
									_setstack.setCount((int) 1);
									Compat.giveItemToPlayer(((Player) entity), _setstack);
								}
							} else if ((NarutoShippudenModVariables.get(entity).customjutsureleasesave).equals("Wind")) {
								customjutsuname = new ItemStack(CustomWindReleaseTechniqueItem.block);
								Compat.setName((customjutsuname), Component.literal(
										("Wind Release: " + NarutoShippudenModVariables.get(entity).jutsunamesave1)));
								if (entity instanceof Player) {
									ItemStack _setstack = (customjutsuname);
									_setstack.setCount((int) 1);
									Compat.giveItemToPlayer(((Player) entity), _setstack);
								}
							} else if ((NarutoShippudenModVariables.get(entity).customjutsureleasesave).equals("Water")) {
								customjutsuname = new ItemStack(CustomWaterReleaseTechniqueItem.block);
								Compat.setName((customjutsuname), Component.literal(
										("Water Release: " + NarutoShippudenModVariables.get(entity).jutsunamesave1)));
								if (entity instanceof Player) {
									ItemStack _setstack = (customjutsuname);
									_setstack.setCount((int) 1);
									Compat.giveItemToPlayer(((Player) entity), _setstack);
								}
							} else if ((NarutoShippudenModVariables.get(entity).customjutsureleasesave).equals("Earth")) {
								customjutsuname = new ItemStack(CustomEarthReleaseTechniqueItem.block);
								Compat.setName((customjutsuname), Component.literal(
										("Earth Release: " + NarutoShippudenModVariables.get(entity).jutsunamesave1)));
								if (entity instanceof Player) {
									ItemStack _setstack = (customjutsuname);
									_setstack.setCount((int) 1);
									Compat.giveItemToPlayer(((Player) entity), _setstack);
								}
							}
							{
								boolean _setval = (true);
								NarutoShippudenModVariables.ifPresent(entity, capability -> {
									capability.customjutsu1learn = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							if (entity instanceof Player)
								((Player) entity).closeContainer();
						} else if (NarutoShippudenModVariables.get(entity).jp <= NarutoShippudenModVariables.get(entity).customjutsujpcost - 1) {
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendOverlayMessage(Component.literal("Not enough JP"));
							}
							{
								boolean _setval = (false);
								NarutoShippudenModVariables.ifPresent(entity, capability -> {
									capability.customjutsujpreadybuy = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						}
					}
				} else if ((new Object() {
					public String getText() {
						EditBox _tf = (EditBox) guistate.get("text:Jutsu_Name");
						if (_tf != null) {
							return _tf.getValue();
						}
						return "";
					}
				}.getText()).equals("")) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Name your jutsu"));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).customjutsucheckpricelogic == false) {
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("Check price first of all"));
				}
			}
		}
	}

	public static class UnlearnCustomJutsu1Procedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure UnlearnCustomJutsu1!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (((entity instanceof Player)
					? ((Player) entity).getInventory().contains(new ItemStack(CustomLightningReleaseTechniqueItem.block))
					: false)
					|| ((entity instanceof Player)
							? ((Player) entity).getInventory().contains(new ItemStack(CustomWindReleaseTechniqueItem.block))
							: false)
					|| ((entity instanceof Player)
							? ((Player) entity).getInventory().contains(new ItemStack(CustomWaterReleaseTechniqueItem.block))
							: false)
					|| ((entity instanceof Player)
							? ((Player) entity).getInventory().contains(new ItemStack(CustomEarthReleaseTechniqueItem.block))
							: false)
					|| ((entity instanceof Player)
							? ((Player) entity).getInventory().contains(new ItemStack(CustomFireReleaseTechniqueItem.block))
							: false)) {
				if (NarutoShippudenModVariables.get(entity).customjutsujpcost == 10) {
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp + 5);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else if (NarutoShippudenModVariables.get(entity).customjutsujpcost == 15) {
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp + 8);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else if (NarutoShippudenModVariables.get(entity).customjutsujpcost == 20) {
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp + 10);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else if (NarutoShippudenModVariables.get(entity).customjutsujpcost == 25) {
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp + 13);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else if (NarutoShippudenModVariables.get(entity).customjutsujpcost == 30) {
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp + 15);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else if (NarutoShippudenModVariables.get(entity).customjutsujpcost == 35) {
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp + 18);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else if (NarutoShippudenModVariables.get(entity).customjutsujpcost == 40) {
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp + 20);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else if (NarutoShippudenModVariables.get(entity).customjutsujpcost == 45) {
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp + 23);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else if (NarutoShippudenModVariables.get(entity).customjutsujpcost == 50) {
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp + 25);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else if (NarutoShippudenModVariables.get(entity).customjutsujpcost == 55) {
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp + 28);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else if (NarutoShippudenModVariables.get(entity).customjutsujpcost == 60) {
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp + 30);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else if (NarutoShippudenModVariables.get(entity).customjutsujpcost == 65) {
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp + 33);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
				{
					boolean _setval = (false);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.customjutsu1learn = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof Player)
					((Player) entity).closeContainer();
				if (entity instanceof Player) {
					ItemStack _stktoremove = new ItemStack(CustomFireReleaseTechniqueItem.block);
					((Player) entity).getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, (int) 1,
							((Player) entity).inventoryMenu.getCraftSlots());
				}
				if (entity instanceof Player) {
					ItemStack _stktoremove = new ItemStack(CustomLightningReleaseTechniqueItem.block);
					((Player) entity).getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, (int) 1,
							((Player) entity).inventoryMenu.getCraftSlots());
				}
				if (entity instanceof Player) {
					ItemStack _stktoremove = new ItemStack(CustomWindReleaseTechniqueItem.block);
					((Player) entity).getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, (int) 1,
							((Player) entity).inventoryMenu.getCraftSlots());
				}
				if (entity instanceof Player) {
					ItemStack _stktoremove = new ItemStack(CustomWaterReleaseTechniqueItem.block);
					((Player) entity).getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, (int) 1,
							((Player) entity).inventoryMenu.getCraftSlots());
				}
				if (entity instanceof Player) {
					ItemStack _stktoremove = new ItemStack(CustomEarthReleaseTechniqueItem.block);
					((Player) entity).getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, (int) 1,
							((Player) entity).inventoryMenu.getCraftSlots());
				}
			} else if (!((entity instanceof Player)
					? ((Player) entity).getInventory().contains(new ItemStack(CustomLightningReleaseTechniqueItem.block))
					: false)
					|| !((entity instanceof Player)
							? ((Player) entity).getInventory().contains(new ItemStack(CustomWindReleaseTechniqueItem.block))
							: false)
					|| !((entity instanceof Player)
							? ((Player) entity).getInventory().contains(new ItemStack(CustomWaterReleaseTechniqueItem.block))
							: false)
					|| !((entity instanceof Player)
							? ((Player) entity).getInventory().contains(new ItemStack(CustomEarthReleaseTechniqueItem.block))
							: false)
					|| !((entity instanceof Player)
							? ((Player) entity).getInventory().contains(new ItemStack(CustomFireReleaseTechniqueItem.block))
							: false)) {
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("Take your custom jutsu in inventory"));
				}
			}
		}
	}
}
