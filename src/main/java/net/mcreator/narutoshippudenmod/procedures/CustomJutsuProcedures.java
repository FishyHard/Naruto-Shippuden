package net.mcreator.narutoshippudenmod.procedures;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;
import net.mcreator.narutoshippudenmod.NarutoShippudenMod;
import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables;
import net.mcreator.narutoshippudenmod.item.JutsuProjectileItems.EarthBallItem;
import net.mcreator.narutoshippudenmod.item.JutsuProjectileItems.EarthDiskItem;
import net.mcreator.narutoshippudenmod.item.JutsuProjectileItems.EarthWaveItem;
import net.mcreator.narutoshippudenmod.item.JutsuProjectileItems.FireBallItem;
import net.mcreator.narutoshippudenmod.item.JutsuProjectileItems.FireDiskItem;
import net.mcreator.narutoshippudenmod.item.JutsuProjectileItems.FireWaveItem;
import net.mcreator.narutoshippudenmod.item.JutsuProjectileItems.LightningBallCustomItem;
import net.mcreator.narutoshippudenmod.item.JutsuProjectileItems.LightningDiskItem;
import net.mcreator.narutoshippudenmod.item.JutsuProjectileItems.LightningWaveItem;
import net.mcreator.narutoshippudenmod.item.JutsuProjectileItems.WaterBallItem;
import net.mcreator.narutoshippudenmod.item.JutsuProjectileItems.WaterDiskItem;
import net.mcreator.narutoshippudenmod.item.JutsuProjectileItems.WaterWaveItem;
import net.mcreator.narutoshippudenmod.item.JutsuProjectileItems.WindBallItem;
import net.mcreator.narutoshippudenmod.item.JutsuProjectileItems.WindDiskItem;
import net.mcreator.narutoshippudenmod.item.JutsuProjectileItems.WindWaveItem;
import net.mcreator.narutoshippudenmod.item.ReleaseTechniqueItems.CustomEarthReleaseTechniqueItem;
import net.mcreator.narutoshippudenmod.item.ReleaseTechniqueItems.CustomFireReleaseTechniqueItem;
import net.mcreator.narutoshippudenmod.item.ReleaseTechniqueItems.CustomLightningReleaseTechniqueItem;
import net.mcreator.narutoshippudenmod.item.ReleaseTechniqueItems.CustomWaterReleaseTechniqueItem;
import net.mcreator.narutoshippudenmod.item.ReleaseTechniqueItems.CustomWindReleaseTechniqueItem;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.items.ItemHandlerHelper;

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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Earth")
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
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Earth")
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
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Earth")
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
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Earth")
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
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Earth")
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
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Earth")
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
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Earth")
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
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Earth")
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
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Earth")
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
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Earth")
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
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Earth")
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
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Earth")
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
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Earth")
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
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Earth")
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
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Earth")
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
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Earth")
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
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Earth")
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
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Earth")
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
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Earth")
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
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Earth")
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
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Earth")
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
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Earth")
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
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Earth")
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
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Earth")
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
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Earth")
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
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Earth")
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
					&& (NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Earth")
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.customjutsujpcost = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
	}

	public static class CustomEarthReleaseTechniqueRightClickedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure CustomEarthReleaseTechniqueRightClicked!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (!entity.isSneaking()) {
				if (NarutoShippudenModVariables.get(entity).customjutsuchakra1save == 100) {
					if (NarutoShippudenModVariables.get(entity).ninjutsu >= 5) {
						if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 100) {
							if ((NarutoShippudenModVariables.get(entity).customjutsutype1save).equals("Ball")) {
								if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Slow")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new EarthBallItem.ArrowCustomEntity(EarthBallItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 10, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Medium")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new EarthBallItem.ArrowCustomEntity(EarthBallItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 10, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 3, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Fast")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new EarthBallItem.ArrowCustomEntity(EarthBallItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 10, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 5, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								}
							} else if ((NarutoShippudenModVariables.get(entity).customjutsutype1save).equals("Wave")) {
								if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Slow")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new EarthWaveItem.ArrowCustomEntity(EarthWaveItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 15, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Medium")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new EarthWaveItem.ArrowCustomEntity(EarthWaveItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 15, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 3, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Fast")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new EarthWaveItem.ArrowCustomEntity(EarthWaveItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 15, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 5, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								}
							} else if ((NarutoShippudenModVariables.get(entity).customjutsutype1save).equals("Disk")) {
								if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Slow")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new EarthDiskItem.ArrowCustomEntity(EarthDiskItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 20, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Medium")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new EarthDiskItem.ArrowCustomEntity(EarthDiskItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 20, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 3, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Fast")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new EarthDiskItem.ArrowCustomEntity(EarthDiskItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 20, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 5, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								}
							}
							{
								double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 100);
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.ChakraAmount = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 99) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 4) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu (5 Required)"), (false));
						}
					}
				} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra1save == 200) {
					if (NarutoShippudenModVariables.get(entity).ninjutsu >= 15) {
						if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 200) {
							if ((NarutoShippudenModVariables.get(entity).customjutsutype1save).equals("Ball")) {
								if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Slow")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new EarthBallItem.ArrowCustomEntity(EarthBallItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 13, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Medium")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new EarthBallItem.ArrowCustomEntity(EarthBallItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 13, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 3, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Fast")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new EarthBallItem.ArrowCustomEntity(EarthBallItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 13, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 5, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								}
							} else if ((NarutoShippudenModVariables.get(entity).customjutsutype1save).equals("Wave")) {
								if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Slow")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new EarthWaveItem.ArrowCustomEntity(EarthWaveItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 18, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Medium")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new EarthWaveItem.ArrowCustomEntity(EarthWaveItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 18, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 3, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Fast")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new EarthWaveItem.ArrowCustomEntity(EarthWaveItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 18, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 5, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								}
							} else if ((NarutoShippudenModVariables.get(entity).customjutsutype1save).equals("Disk")) {
								if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Slow")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new EarthDiskItem.ArrowCustomEntity(EarthDiskItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 23, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Medium")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new EarthDiskItem.ArrowCustomEntity(EarthDiskItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 23, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 3, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Fast")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new EarthDiskItem.ArrowCustomEntity(EarthDiskItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 23, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 5, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								}
							}
						} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 199) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 14) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu (15 Required)"), (false));
						}
					}
				} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra1save == 300) {
					if (NarutoShippudenModVariables.get(entity).ninjutsu >= 25) {
						if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 300) {
							if ((NarutoShippudenModVariables.get(entity).customjutsutype1save).equals("Ball")) {
								if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Slow")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new EarthBallItem.ArrowCustomEntity(EarthBallItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 16, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Medium")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new EarthBallItem.ArrowCustomEntity(EarthBallItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 16, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 3, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Fast")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new EarthBallItem.ArrowCustomEntity(EarthBallItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 16, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 5, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								}
							} else if ((NarutoShippudenModVariables.get(entity).customjutsutype1save).equals("Wave")) {
								if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Slow")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new EarthWaveItem.ArrowCustomEntity(EarthWaveItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 21, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Medium")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new EarthWaveItem.ArrowCustomEntity(EarthWaveItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 21, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 3, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Fast")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new EarthWaveItem.ArrowCustomEntity(EarthWaveItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 21, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 5, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								}
							} else if ((NarutoShippudenModVariables.get(entity).customjutsutype1save).equals("Disk")) {
								if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Slow")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new EarthDiskItem.ArrowCustomEntity(EarthDiskItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 26, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Medium")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new EarthDiskItem.ArrowCustomEntity(EarthDiskItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 26, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 3, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Fast")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new EarthDiskItem.ArrowCustomEntity(EarthDiskItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 26, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 5, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								}
							}
							{
								double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 100);
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.ChakraAmount = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 299) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 24) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu (25 Required)"), (false));
						}
					}
				} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra1save == 400) {
					if (NarutoShippudenModVariables.get(entity).ninjutsu >= 30) {
						if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 400) {
							if ((NarutoShippudenModVariables.get(entity).customjutsutype1save).equals("Ball")) {
								if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Slow")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new EarthBallItem.ArrowCustomEntity(EarthBallItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 19, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Medium")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new EarthBallItem.ArrowCustomEntity(EarthBallItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 19, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 3, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Fast")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new EarthBallItem.ArrowCustomEntity(EarthBallItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 19, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 5, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								}
							} else if ((NarutoShippudenModVariables.get(entity).customjutsutype1save).equals("Wave")) {
								if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Slow")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new EarthWaveItem.ArrowCustomEntity(EarthWaveItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 24, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Medium")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new EarthWaveItem.ArrowCustomEntity(EarthWaveItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 24, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 3, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Fast")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new EarthWaveItem.ArrowCustomEntity(EarthWaveItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 24, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 5, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								}
							} else if ((NarutoShippudenModVariables.get(entity).customjutsutype1save).equals("Disk")) {
								if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Slow")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new EarthDiskItem.ArrowCustomEntity(EarthDiskItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 29, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Medium")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new EarthDiskItem.ArrowCustomEntity(EarthDiskItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 29, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 3, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Fast")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new EarthDiskItem.ArrowCustomEntity(EarthDiskItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 29, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 5, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								}
							}
							{
								double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 100);
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.ChakraAmount = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 399) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 29) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu (30 Required)"), (false));
						}
					}
				} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra1save == 500) {
					if (NarutoShippudenModVariables.get(entity).ninjutsu >= 35) {
						if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 500) {
							if ((NarutoShippudenModVariables.get(entity).customjutsutype1save).equals("Ball")) {
								if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Slow")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new EarthBallItem.ArrowCustomEntity(EarthBallItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 22, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Medium")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new EarthBallItem.ArrowCustomEntity(EarthBallItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 22, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 3, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Fast")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new EarthBallItem.ArrowCustomEntity(EarthBallItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 22, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 5, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								}
							} else if ((NarutoShippudenModVariables.get(entity).customjutsutype1save).equals("Wave")) {
								if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Slow")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new EarthWaveItem.ArrowCustomEntity(EarthWaveItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 27, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Medium")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new EarthWaveItem.ArrowCustomEntity(EarthWaveItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 27, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 3, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Fast")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new EarthWaveItem.ArrowCustomEntity(EarthWaveItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 27, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 5, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								}
							} else if ((NarutoShippudenModVariables.get(entity).customjutsutype1save).equals("Disk")) {
								if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Slow")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new EarthDiskItem.ArrowCustomEntity(EarthDiskItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 32, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Medium")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new EarthDiskItem.ArrowCustomEntity(EarthDiskItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 32, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 3, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Fast")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new EarthDiskItem.ArrowCustomEntity(EarthDiskItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 32, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 5, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								}
							}
							{
								double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 100);
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.ChakraAmount = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 499) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 34) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu (35 Required)"), (false));
						}
					}
				}
			} else if (entity.isSneaking()) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity)
							.sendStatusMessage(
									new StringTextComponent(
											("Jutsu Info: " + "Jutsu Name: "
													+ NarutoShippudenModVariables.get(entity).jutsunamesave1
													+ " Release: "
													+ NarutoShippudenModVariables.get(entity).customjutsurelease1save
													+ " Type: "
													+ NarutoShippudenModVariables.get(entity).customjutsutype1save
													+ " Speed: "
													+ NarutoShippudenModVariables.get(entity).customjutsuspeed1save
													+ " \u00A7bChakra Cost: "
													+ NarutoShippudenModVariables.get(entity).customjutsuchakra1save)),
									(false));
				}
			}
		}
	}

	public static class CustomFireReleaseTechniqueRightclickedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure CustomFireReleaseTechniqueRightclicked!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (!entity.isSneaking()) {
				if (NarutoShippudenModVariables.get(entity).customjutsuchakra1save == 100) {
					if (NarutoShippudenModVariables.get(entity).ninjutsu >= 5) {
						if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 100) {
							if ((NarutoShippudenModVariables.get(entity).customjutsutype1save).equals("Ball")) {
								if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Slow")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new FireBallItem.ArrowCustomEntity(FireBallItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 15, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Medium")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new FireBallItem.ArrowCustomEntity(FireBallItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 15, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 3, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Fast")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new FireBallItem.ArrowCustomEntity(FireBallItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 15, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 5, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								}
							} else if ((NarutoShippudenModVariables.get(entity).customjutsutype1save).equals("Wave")) {
								if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Slow")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new FireWaveItem.ArrowCustomEntity(FireWaveItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 20, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Medium")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new FireWaveItem.ArrowCustomEntity(FireWaveItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 20, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 3, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Fast")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new FireWaveItem.ArrowCustomEntity(FireWaveItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 20, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 5, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								}
							} else if ((NarutoShippudenModVariables.get(entity).customjutsutype1save).equals("Disk")) {
								if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Slow")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new FireDiskItem.ArrowCustomEntity(FireDiskItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 25, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Medium")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new FireDiskItem.ArrowCustomEntity(FireDiskItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 25, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 3, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Fast")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new FireDiskItem.ArrowCustomEntity(FireDiskItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 25, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 5, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								}
							}
							{
								double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 100);
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.ChakraAmount = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 99) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 4) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu (5 Required)"), (false));
						}
					}
				} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra1save == 200) {
					if (NarutoShippudenModVariables.get(entity).ninjutsu >= 15) {
						if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 200) {
							if ((NarutoShippudenModVariables.get(entity).customjutsutype1save).equals("Ball")) {
								if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Slow")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new FireBallItem.ArrowCustomEntity(FireBallItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 18, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Medium")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new FireBallItem.ArrowCustomEntity(FireBallItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 18, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 3, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Fast")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new FireBallItem.ArrowCustomEntity(FireBallItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 18, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 5, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								}
							} else if ((NarutoShippudenModVariables.get(entity).customjutsutype1save).equals("Wave")) {
								if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Slow")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new FireWaveItem.ArrowCustomEntity(FireWaveItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 23, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Medium")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new FireWaveItem.ArrowCustomEntity(FireWaveItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 23, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 3, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Fast")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new FireWaveItem.ArrowCustomEntity(FireWaveItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 23, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 5, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								}
							} else if ((NarutoShippudenModVariables.get(entity).customjutsutype1save).equals("Disk")) {
								if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Slow")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new FireDiskItem.ArrowCustomEntity(FireDiskItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 28, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Medium")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new FireDiskItem.ArrowCustomEntity(FireDiskItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 28, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 3, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Fast")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new FireDiskItem.ArrowCustomEntity(FireDiskItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 28, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 5, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								}
							}
							{
								double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 200);
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.ChakraAmount = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 199) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 14) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu (15 Required)"), (false));
						}
					}
				} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra1save == 300) {
					if (NarutoShippudenModVariables.get(entity).ninjutsu >= 25) {
						if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 300) {
							if ((NarutoShippudenModVariables.get(entity).customjutsutype1save).equals("Ball")) {
								if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Slow")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new FireBallItem.ArrowCustomEntity(FireBallItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 21, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Medium")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new FireBallItem.ArrowCustomEntity(FireBallItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 21, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 3, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Fast")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new FireBallItem.ArrowCustomEntity(FireBallItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 21, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 5, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								}
							} else if ((NarutoShippudenModVariables.get(entity).customjutsutype1save).equals("Wave")) {
								if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Slow")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new FireWaveItem.ArrowCustomEntity(FireWaveItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 26, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Medium")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new FireWaveItem.ArrowCustomEntity(FireWaveItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 26, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 3, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Fast")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new FireWaveItem.ArrowCustomEntity(FireWaveItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 26, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 5, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								}
							} else if ((NarutoShippudenModVariables.get(entity).customjutsutype1save).equals("Disk")) {
								if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Slow")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new FireDiskItem.ArrowCustomEntity(FireDiskItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 31, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Medium")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new FireDiskItem.ArrowCustomEntity(FireDiskItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 31, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 3, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Fast")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new FireDiskItem.ArrowCustomEntity(FireDiskItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 31, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 5, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								}
							}
							{
								double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 300);
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.ChakraAmount = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 299) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 24) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu (25 Required)"), (false));
						}
					}
				} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra1save == 400) {
					if (NarutoShippudenModVariables.get(entity).ninjutsu >= 30) {
						if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 400) {
							if ((NarutoShippudenModVariables.get(entity).customjutsutype1save).equals("Ball")) {
								if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Slow")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new FireBallItem.ArrowCustomEntity(FireBallItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 24, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Medium")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new FireBallItem.ArrowCustomEntity(FireBallItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 24, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 3, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Fast")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new FireBallItem.ArrowCustomEntity(FireBallItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 24, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 5, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								}
							} else if ((NarutoShippudenModVariables.get(entity).customjutsutype1save).equals("Wave")) {
								if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Slow")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new FireWaveItem.ArrowCustomEntity(FireWaveItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 29, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Medium")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new FireWaveItem.ArrowCustomEntity(FireWaveItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 29, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 3, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Fast")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new FireWaveItem.ArrowCustomEntity(FireWaveItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 29, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 5, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								}
							} else if ((NarutoShippudenModVariables.get(entity).customjutsutype1save).equals("Disk")) {
								if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Slow")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new FireDiskItem.ArrowCustomEntity(FireDiskItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 34, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Medium")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new FireDiskItem.ArrowCustomEntity(FireDiskItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 34, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 3, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Fast")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new FireDiskItem.ArrowCustomEntity(FireDiskItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 34, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 5, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								}
							}
							{
								double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 400);
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.ChakraAmount = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 399) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 29) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu (30 Required)"), (false));
						}
					}
				} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra1save == 500) {
					if (NarutoShippudenModVariables.get(entity).ninjutsu >= 35) {
						if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 500) {
							if ((NarutoShippudenModVariables.get(entity).customjutsutype1save).equals("Ball")) {
								if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Slow")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new FireBallItem.ArrowCustomEntity(FireBallItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 27, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Medium")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new FireBallItem.ArrowCustomEntity(FireBallItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 27, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 3, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Fast")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new FireBallItem.ArrowCustomEntity(FireBallItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 27, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 5, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								}
							} else if ((NarutoShippudenModVariables.get(entity).customjutsutype1save).equals("Wave")) {
								if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Slow")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new FireWaveItem.ArrowCustomEntity(FireWaveItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 32, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Medium")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new FireWaveItem.ArrowCustomEntity(FireWaveItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 32, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 3, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Fast")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new FireWaveItem.ArrowCustomEntity(FireWaveItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 32, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 5, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								}
							} else if ((NarutoShippudenModVariables.get(entity).customjutsutype1save).equals("Disk")) {
								if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Slow")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new FireDiskItem.ArrowCustomEntity(FireDiskItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 37, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Medium")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new FireDiskItem.ArrowCustomEntity(FireDiskItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 37, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 3, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Fast")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new FireDiskItem.ArrowCustomEntity(FireDiskItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 37, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 5, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								}
							}
							{
								double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 500);
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.ChakraAmount = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 499) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 34) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu (35 Required)"), (false));
						}
					}
				}
			} else if (entity.isSneaking()) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity)
							.sendStatusMessage(
									new StringTextComponent(
											("Jutsu Info: " + "Jutsu Name: "
													+ NarutoShippudenModVariables.get(entity).jutsunamesave1
													+ " Release: "
													+ NarutoShippudenModVariables.get(entity).customjutsurelease1save
													+ " Type: "
													+ NarutoShippudenModVariables.get(entity).customjutsutype1save
													+ " Speed: "
													+ NarutoShippudenModVariables.get(entity).customjutsuspeed1save
													+ " \u00A7bChakra Cost: "
													+ NarutoShippudenModVariables.get(entity).customjutsuchakra1save)),
									(false));
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.customjutsuchakra = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
				{
					double _setval = 400;
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.customjutsuchakra = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
				{
					double _setval = 300;
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.customjutsuchakra = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
				{
					double _setval = 200;
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.customjutsuchakra = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
				{
					double _setval = 100;
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.customjutsurelease = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if ((NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Earth")) {
				{
					String _setval = "Water";
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.customjutsurelease = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if ((NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Water")) {
				{
					String _setval = "Lightning";
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.customjutsurelease = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if ((NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Lightning")) {
				{
					String _setval = "Wind";
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.customjutsurelease = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if ((NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Wind")) {
				{
					String _setval = "Fire";
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.customjutsuspeed = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Medium")) {
				{
					String _setval = "Slow";
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.customjutsuspeed = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Fast")) {
				{
					String _setval = "Medium";
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.customjutsutype = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Wave")) {
				{
					String _setval = "Disk";
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.customjutsutype = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Disk")) {
				{
					String _setval = "Ball";
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.customjutsuchakra = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
				{
					double _setval = 300;
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.customjutsuchakra = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
				{
					double _setval = 400;
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.customjutsuchakra = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
				{
					double _setval = 500;
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.customjutsuchakra = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
				{
					double _setval = 100;
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.customjutsurelease = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if ((NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Wind")) {
				{
					String _setval = "Lightning";
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.customjutsurelease = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if ((NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Lightning")) {
				{
					String _setval = "Water";
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.customjutsurelease = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if ((NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Water")) {
				{
					String _setval = "Earth";
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.customjutsurelease = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if ((NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Earth")) {
				{
					String _setval = "Fire";
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.customjutsuspeed = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Medium")) {
				{
					String _setval = "Fast";
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.customjutsuspeed = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Fast")) {
				{
					String _setval = "Slow";
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.customjutsutype = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Disk")) {
				{
					String _setval = "Wave";
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.customjutsutype = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Wave")) {
				{
					String _setval = "Ball";
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.customjutsutype = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
	}

	public static class CustomLightningReleaseTechniqueRightClickedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure CustomLightningReleaseTechniqueRightClicked!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (!entity.isSneaking()) {
				if (NarutoShippudenModVariables.get(entity).customjutsuchakra1save == 100) {
					if (NarutoShippudenModVariables.get(entity).ninjutsu >= 5) {
						if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 100) {
							if ((NarutoShippudenModVariables.get(entity).customjutsutype1save).equals("Ball")) {
								if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Slow")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new LightningBallCustomItem.ArrowCustomEntity(
															LightningBallCustomItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 15, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Medium")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new LightningBallCustomItem.ArrowCustomEntity(
															LightningBallCustomItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 15, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 3, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Fast")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new LightningBallCustomItem.ArrowCustomEntity(
															LightningBallCustomItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 15, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 5, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								}
							} else if ((NarutoShippudenModVariables.get(entity).customjutsutype1save).equals("Wave")) {
								if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Slow")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new LightningWaveItem.ArrowCustomEntity(LightningWaveItem.arrow,
															world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 20, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Medium")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new LightningWaveItem.ArrowCustomEntity(LightningWaveItem.arrow,
															world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 20, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 3, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Fast")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new LightningWaveItem.ArrowCustomEntity(LightningWaveItem.arrow,
															world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 20, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 5, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								}
							} else if ((NarutoShippudenModVariables.get(entity).customjutsutype1save).equals("Disk")) {
								if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Slow")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new LightningDiskItem.ArrowCustomEntity(LightningDiskItem.arrow,
															world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 25, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Medium")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new LightningDiskItem.ArrowCustomEntity(LightningDiskItem.arrow,
															world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 25, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 3, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Fast")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new LightningDiskItem.ArrowCustomEntity(LightningDiskItem.arrow,
															world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 25, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 5, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								}
							}
							{
								double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 100);
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.ChakraAmount = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 99) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 4) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu (5 Required)"), (false));
						}
					}
				} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra1save == 200) {
					if (NarutoShippudenModVariables.get(entity).ninjutsu >= 15) {
						if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 200) {
							if ((NarutoShippudenModVariables.get(entity).customjutsutype1save).equals("Ball")) {
								if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Slow")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new LightningBallCustomItem.ArrowCustomEntity(
															LightningBallCustomItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 18, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Medium")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new LightningBallCustomItem.ArrowCustomEntity(
															LightningBallCustomItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 18, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 3, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Fast")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new LightningBallCustomItem.ArrowCustomEntity(
															LightningBallCustomItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 18, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 5, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								}
							} else if ((NarutoShippudenModVariables.get(entity).customjutsutype1save).equals("Wave")) {
								if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Slow")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new LightningWaveItem.ArrowCustomEntity(LightningWaveItem.arrow,
															world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 23, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Medium")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new LightningWaveItem.ArrowCustomEntity(LightningWaveItem.arrow,
															world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 23, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 3, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Fast")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new LightningWaveItem.ArrowCustomEntity(LightningWaveItem.arrow,
															world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 23, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 5, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								}
							} else if ((NarutoShippudenModVariables.get(entity).customjutsutype1save).equals("Disk")) {
								if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Slow")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new LightningDiskItem.ArrowCustomEntity(LightningDiskItem.arrow,
															world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 28, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Medium")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new LightningDiskItem.ArrowCustomEntity(LightningDiskItem.arrow,
															world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 28, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 3, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Fast")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new LightningDiskItem.ArrowCustomEntity(LightningDiskItem.arrow,
															world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 28, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 5, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								}
							}
							{
								double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 100);
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.ChakraAmount = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 199) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 14) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu (15 Required)"), (false));
						}
					}
				} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra1save == 300) {
					if (NarutoShippudenModVariables.get(entity).ninjutsu >= 25) {
						if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 300) {
							if ((NarutoShippudenModVariables.get(entity).customjutsutype1save).equals("Ball")) {
								if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Slow")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new LightningBallCustomItem.ArrowCustomEntity(
															LightningBallCustomItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 21, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Medium")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new LightningBallCustomItem.ArrowCustomEntity(
															LightningBallCustomItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 21, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 3, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Fast")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new LightningBallCustomItem.ArrowCustomEntity(
															LightningBallCustomItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 21, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 5, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								}
							} else if ((NarutoShippudenModVariables.get(entity).customjutsutype1save).equals("Wave")) {
								if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Slow")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new LightningWaveItem.ArrowCustomEntity(LightningWaveItem.arrow,
															world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 26, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Medium")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new LightningWaveItem.ArrowCustomEntity(LightningWaveItem.arrow,
															world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 26, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 3, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Fast")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new LightningWaveItem.ArrowCustomEntity(LightningWaveItem.arrow,
															world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 26, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 5, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								}
							} else if ((NarutoShippudenModVariables.get(entity).customjutsutype1save).equals("Disk")) {
								if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Slow")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new LightningDiskItem.ArrowCustomEntity(LightningDiskItem.arrow,
															world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 31, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Medium")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new LightningDiskItem.ArrowCustomEntity(LightningDiskItem.arrow,
															world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 31, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 3, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Fast")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new LightningDiskItem.ArrowCustomEntity(LightningDiskItem.arrow,
															world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 31, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 5, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								}
							}
							{
								double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 100);
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.ChakraAmount = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 299) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 24) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu (25 Required)"), (false));
						}
					}
				} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra1save == 400) {
					if (NarutoShippudenModVariables.get(entity).ninjutsu >= 30) {
						if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 400) {
							if ((NarutoShippudenModVariables.get(entity).customjutsutype1save).equals("Ball")) {
								if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Slow")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new LightningBallCustomItem.ArrowCustomEntity(
															LightningBallCustomItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 24, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Medium")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new LightningBallCustomItem.ArrowCustomEntity(
															LightningBallCustomItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 24, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 3, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Fast")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new LightningBallCustomItem.ArrowCustomEntity(
															LightningBallCustomItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 24, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 5, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								}
							} else if ((NarutoShippudenModVariables.get(entity).customjutsutype1save).equals("Wave")) {
								if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Slow")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new LightningWaveItem.ArrowCustomEntity(LightningWaveItem.arrow,
															world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 29, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Medium")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new LightningWaveItem.ArrowCustomEntity(LightningWaveItem.arrow,
															world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 29, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 3, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Fast")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new LightningWaveItem.ArrowCustomEntity(LightningWaveItem.arrow,
															world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 29, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 5, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								}
							} else if ((NarutoShippudenModVariables.get(entity).customjutsutype1save).equals("Disk")) {
								if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Slow")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new LightningDiskItem.ArrowCustomEntity(LightningDiskItem.arrow,
															world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 34, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Medium")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new LightningDiskItem.ArrowCustomEntity(LightningDiskItem.arrow,
															world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 34, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 3, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Fast")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new LightningDiskItem.ArrowCustomEntity(LightningDiskItem.arrow,
															world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 34, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 5, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								}
							}
							{
								double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 100);
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.ChakraAmount = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 399) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 29) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu (30 Required)"), (false));
						}
					}
				} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra1save == 500) {
					if (NarutoShippudenModVariables.get(entity).ninjutsu >= 35) {
						if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 500) {
							if ((NarutoShippudenModVariables.get(entity).customjutsutype1save).equals("Ball")) {
								if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Slow")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new LightningBallCustomItem.ArrowCustomEntity(
															LightningBallCustomItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 27, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Medium")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new LightningBallCustomItem.ArrowCustomEntity(
															LightningBallCustomItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 27, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 3, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Fast")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new LightningBallCustomItem.ArrowCustomEntity(
															LightningBallCustomItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 27, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 5, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								}
							} else if ((NarutoShippudenModVariables.get(entity).customjutsutype1save).equals("Wave")) {
								if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Slow")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new LightningWaveItem.ArrowCustomEntity(LightningWaveItem.arrow,
															world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 32, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Medium")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new LightningWaveItem.ArrowCustomEntity(LightningWaveItem.arrow,
															world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 32, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 3, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Fast")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new LightningWaveItem.ArrowCustomEntity(LightningWaveItem.arrow,
															world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 32, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 5, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								}
							} else if ((NarutoShippudenModVariables.get(entity).customjutsutype1save).equals("Disk")) {
								if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Slow")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new LightningDiskItem.ArrowCustomEntity(LightningDiskItem.arrow,
															world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 37, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Medium")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new LightningDiskItem.ArrowCustomEntity(LightningDiskItem.arrow,
															world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 37, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 3, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Fast")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new LightningDiskItem.ArrowCustomEntity(LightningDiskItem.arrow,
															world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 37, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 5, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								}
							}
							{
								double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 100);
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.ChakraAmount = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 499) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 34) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu (35 Required)"), (false));
						}
					}
				}
			} else if (entity.isSneaking()) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity)
							.sendStatusMessage(
									new StringTextComponent(
											("Jutsu Info: " + "Jutsu Name: "
													+ NarutoShippudenModVariables.get(entity).jutsunamesave1
													+ " Release: "
													+ NarutoShippudenModVariables.get(entity).customjutsurelease1save
													+ " Type: "
													+ NarutoShippudenModVariables.get(entity).customjutsutype1save
													+ " Speed: "
													+ NarutoShippudenModVariables.get(entity).customjutsuspeed1save
													+ " \u00A7bChakra Cost: "
													+ NarutoShippudenModVariables.get(entity).customjutsuchakra1save)),
									(false));
				}
			}
		}
	}

	public static class CustomWaterReleaseTechniqueRightClickedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure CustomWaterReleaseTechniqueRightClicked!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (!entity.isSneaking()) {
				if (NarutoShippudenModVariables.get(entity).customjutsuchakra1save == 100) {
					if (NarutoShippudenModVariables.get(entity).ninjutsu >= 5) {
						if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 100) {
							if ((NarutoShippudenModVariables.get(entity).customjutsutype1save).equals("Ball")) {
								if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Slow")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new WaterBallItem.ArrowCustomEntity(WaterBallItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 10, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Medium")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new WaterBallItem.ArrowCustomEntity(WaterBallItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 10, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 3, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Fast")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new WaterBallItem.ArrowCustomEntity(WaterBallItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 10, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 5, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								}
							} else if ((NarutoShippudenModVariables.get(entity).customjutsutype1save).equals("Wave")) {
								if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Slow")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new WaterWaveItem.ArrowCustomEntity(WaterWaveItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 15, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Medium")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new WaterWaveItem.ArrowCustomEntity(WaterWaveItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 15, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 3, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Fast")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new WaterWaveItem.ArrowCustomEntity(WaterWaveItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 15, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 5, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								}
							} else if ((NarutoShippudenModVariables.get(entity).customjutsutype1save).equals("Disk")) {
								if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Slow")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new WaterDiskItem.ArrowCustomEntity(WaterDiskItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 20, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Medium")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new WaterDiskItem.ArrowCustomEntity(WaterDiskItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 20, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 3, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Fast")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new WaterDiskItem.ArrowCustomEntity(WaterDiskItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 20, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 5, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								}
							}
							{
								double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 100);
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.ChakraAmount = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 99) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 4) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu (5 Required)"), (false));
						}
					}
				} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra1save == 200) {
					if (NarutoShippudenModVariables.get(entity).ninjutsu >= 15) {
						if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 200) {
							if ((NarutoShippudenModVariables.get(entity).customjutsutype1save).equals("Ball")) {
								if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Slow")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new WaterBallItem.ArrowCustomEntity(WaterBallItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 13, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Medium")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new WaterBallItem.ArrowCustomEntity(WaterBallItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 13, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 3, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Fast")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new WaterBallItem.ArrowCustomEntity(WaterBallItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 13, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 5, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								}
							} else if ((NarutoShippudenModVariables.get(entity).customjutsutype1save).equals("Wave")) {
								if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Slow")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new WaterWaveItem.ArrowCustomEntity(WaterWaveItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 18, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Medium")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new WaterWaveItem.ArrowCustomEntity(WaterWaveItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 18, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 3, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Fast")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new WaterWaveItem.ArrowCustomEntity(WaterWaveItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 18, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 5, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								}
							} else if ((NarutoShippudenModVariables.get(entity).customjutsutype1save).equals("Disk")) {
								if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Slow")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new WaterDiskItem.ArrowCustomEntity(WaterDiskItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 23, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Medium")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new WaterDiskItem.ArrowCustomEntity(WaterDiskItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 23, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 3, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Fast")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new WaterDiskItem.ArrowCustomEntity(WaterDiskItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 23, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 5, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								}
							}
						} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 199) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 14) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu (15 Required)"), (false));
						}
					}
				} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra1save == 300) {
					if (NarutoShippudenModVariables.get(entity).ninjutsu >= 25) {
						if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 300) {
							if ((NarutoShippudenModVariables.get(entity).customjutsutype1save).equals("Ball")) {
								if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Slow")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new WaterBallItem.ArrowCustomEntity(WaterBallItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 16, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Medium")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new WaterBallItem.ArrowCustomEntity(WaterBallItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 16, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 3, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Fast")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new WaterBallItem.ArrowCustomEntity(WaterBallItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 16, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 5, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								}
							} else if ((NarutoShippudenModVariables.get(entity).customjutsutype1save).equals("Wave")) {
								if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Slow")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new WaterWaveItem.ArrowCustomEntity(WaterWaveItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 21, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Medium")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new WaterWaveItem.ArrowCustomEntity(WaterWaveItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 21, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 3, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Fast")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new WaterWaveItem.ArrowCustomEntity(WaterWaveItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 21, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 5, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								}
							} else if ((NarutoShippudenModVariables.get(entity).customjutsutype1save).equals("Disk")) {
								if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Slow")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new WaterDiskItem.ArrowCustomEntity(WaterDiskItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 26, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Medium")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new WaterDiskItem.ArrowCustomEntity(WaterDiskItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 26, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 3, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Fast")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new WaterDiskItem.ArrowCustomEntity(WaterDiskItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 26, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 5, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								}
							}
							{
								double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 100);
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.ChakraAmount = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 299) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 24) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu (25 Required)"), (false));
						}
					}
				} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra1save == 400) {
					if (NarutoShippudenModVariables.get(entity).ninjutsu >= 30) {
						if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 400) {
							if ((NarutoShippudenModVariables.get(entity).customjutsutype1save).equals("Ball")) {
								if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Slow")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new WaterBallItem.ArrowCustomEntity(WaterBallItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 19, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Medium")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new WaterBallItem.ArrowCustomEntity(WaterBallItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 19, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 3, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Fast")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new WaterBallItem.ArrowCustomEntity(WaterBallItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 19, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 5, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								}
							} else if ((NarutoShippudenModVariables.get(entity).customjutsutype1save).equals("Wave")) {
								if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Slow")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new WaterWaveItem.ArrowCustomEntity(WaterWaveItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 24, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Medium")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new WaterWaveItem.ArrowCustomEntity(WaterWaveItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 24, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 3, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Fast")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new WaterWaveItem.ArrowCustomEntity(WaterWaveItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 24, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 5, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								}
							} else if ((NarutoShippudenModVariables.get(entity).customjutsutype1save).equals("Disk")) {
								if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Slow")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new WaterDiskItem.ArrowCustomEntity(WaterDiskItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 29, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Medium")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new WaterDiskItem.ArrowCustomEntity(WaterDiskItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 29, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 3, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Fast")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new WaterDiskItem.ArrowCustomEntity(WaterDiskItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 29, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 5, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								}
							}
							{
								double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 100);
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.ChakraAmount = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 399) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 29) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu (30 Required)"), (false));
						}
					}
				} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra1save == 500) {
					if (NarutoShippudenModVariables.get(entity).ninjutsu >= 35) {
						if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 500) {
							if ((NarutoShippudenModVariables.get(entity).customjutsutype1save).equals("Ball")) {
								if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Slow")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new WaterBallItem.ArrowCustomEntity(WaterBallItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 22, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Medium")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new WaterBallItem.ArrowCustomEntity(WaterBallItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 22, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 3, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Fast")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new WaterBallItem.ArrowCustomEntity(WaterBallItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 22, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 5, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								}
							} else if ((NarutoShippudenModVariables.get(entity).customjutsutype1save).equals("Wave")) {
								if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Slow")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new WaterWaveItem.ArrowCustomEntity(WaterWaveItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 27, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Medium")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new WaterWaveItem.ArrowCustomEntity(WaterWaveItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 27, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 3, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Fast")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new WaterWaveItem.ArrowCustomEntity(WaterWaveItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 27, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 5, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								}
							} else if ((NarutoShippudenModVariables.get(entity).customjutsutype1save).equals("Disk")) {
								if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Slow")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new WaterDiskItem.ArrowCustomEntity(WaterDiskItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 32, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Medium")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new WaterDiskItem.ArrowCustomEntity(WaterDiskItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 32, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 3, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Fast")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new WaterDiskItem.ArrowCustomEntity(WaterDiskItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 32, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 5, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								}
							}
							{
								double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 100);
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.ChakraAmount = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 499) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 34) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu (35 Required)"), (false));
						}
					}
				}
			} else if (entity.isSneaking()) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity)
							.sendStatusMessage(
									new StringTextComponent(
											("Jutsu Info: " + "Jutsu Name: "
													+ NarutoShippudenModVariables.get(entity).jutsunamesave1
													+ " Release: "
													+ NarutoShippudenModVariables.get(entity).customjutsurelease1save
													+ " Type: "
													+ NarutoShippudenModVariables.get(entity).customjutsutype1save
													+ " Speed: "
													+ NarutoShippudenModVariables.get(entity).customjutsuspeed1save
													+ " \u00A7bChakra Cost: "
													+ NarutoShippudenModVariables.get(entity).customjutsuchakra1save)),
									(false));
				}
			}
		}
	}

	public static class CustomWindReleaseTechniqueRightClickedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure CustomWindReleaseTechniqueRightClicked!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (!entity.isSneaking()) {
				if (NarutoShippudenModVariables.get(entity).customjutsuchakra1save == 100) {
					if (NarutoShippudenModVariables.get(entity).ninjutsu >= 5) {
						if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 100) {
							if ((NarutoShippudenModVariables.get(entity).customjutsutype1save).equals("Ball")) {
								if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Slow")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new WindBallItem.ArrowCustomEntity(WindBallItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 15, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Medium")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new WindBallItem.ArrowCustomEntity(WindBallItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 15, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 3, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Fast")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new WindBallItem.ArrowCustomEntity(WindBallItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 15, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 5, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								}
							} else if ((NarutoShippudenModVariables.get(entity).customjutsutype1save).equals("Wave")) {
								if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Slow")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new WindWaveItem.ArrowCustomEntity(WindWaveItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 20, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Medium")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new WindWaveItem.ArrowCustomEntity(WindWaveItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 20, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 3, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Fast")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new WindWaveItem.ArrowCustomEntity(WindWaveItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 20, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 5, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								}
							} else if ((NarutoShippudenModVariables.get(entity).customjutsutype1save).equals("Disk")) {
								if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Slow")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new WindDiskItem.ArrowCustomEntity(WindDiskItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 25, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Medium")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new WindDiskItem.ArrowCustomEntity(WindDiskItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 25, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 3, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Fast")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new WindDiskItem.ArrowCustomEntity(WindDiskItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 25, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 5, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								}
							}
							{
								double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 100);
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.ChakraAmount = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 99) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 4) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu (5 Required)"), (false));
						}
					}
				} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra1save == 200) {
					if (NarutoShippudenModVariables.get(entity).ninjutsu >= 15) {
						if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 200) {
							if ((NarutoShippudenModVariables.get(entity).customjutsutype1save).equals("Ball")) {
								if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Slow")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new WindBallItem.ArrowCustomEntity(WindBallItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 18, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Medium")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new WindBallItem.ArrowCustomEntity(WindBallItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 18, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 3, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Fast")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new WindBallItem.ArrowCustomEntity(WindBallItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 18, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 5, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								}
							} else if ((NarutoShippudenModVariables.get(entity).customjutsutype1save).equals("Wave")) {
								if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Slow")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new WindWaveItem.ArrowCustomEntity(WindWaveItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 23, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Medium")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new WindWaveItem.ArrowCustomEntity(WindWaveItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 23, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 3, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Fast")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new WindWaveItem.ArrowCustomEntity(WindWaveItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 23, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 5, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								}
							} else if ((NarutoShippudenModVariables.get(entity).customjutsutype1save).equals("Disk")) {
								if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Slow")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new WindDiskItem.ArrowCustomEntity(WindDiskItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 28, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Medium")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new WindDiskItem.ArrowCustomEntity(WindDiskItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 28, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 3, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Fast")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new WindDiskItem.ArrowCustomEntity(WindDiskItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 28, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 5, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								}
							}
							{
								double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 100);
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.ChakraAmount = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 199) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 14) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu (15 Required)"), (false));
						}
					}
				} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra1save == 300) {
					if (NarutoShippudenModVariables.get(entity).ninjutsu >= 25) {
						if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 300) {
							if ((NarutoShippudenModVariables.get(entity).customjutsutype1save).equals("Ball")) {
								if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Slow")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new WindBallItem.ArrowCustomEntity(WindBallItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 21, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Medium")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new WindBallItem.ArrowCustomEntity(WindBallItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 21, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 3, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Fast")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new WindBallItem.ArrowCustomEntity(WindBallItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 21, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 5, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								}
							} else if ((NarutoShippudenModVariables.get(entity).customjutsutype1save).equals("Wave")) {
								if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Slow")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new WindWaveItem.ArrowCustomEntity(WindWaveItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 26, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Medium")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new WindWaveItem.ArrowCustomEntity(WindWaveItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 26, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 3, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Fast")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new WindWaveItem.ArrowCustomEntity(WindWaveItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 26, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 5, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								}
							} else if ((NarutoShippudenModVariables.get(entity).customjutsutype1save).equals("Disk")) {
								if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Slow")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new WindDiskItem.ArrowCustomEntity(WindDiskItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 31, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Medium")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new WindDiskItem.ArrowCustomEntity(WindDiskItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 31, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 3, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Fast")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new WindDiskItem.ArrowCustomEntity(WindDiskItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 31, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 5, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								}
							}
							{
								double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 100);
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.ChakraAmount = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 299) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 24) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu (25 Required)"), (false));
						}
					}
				} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra1save == 400) {
					if (NarutoShippudenModVariables.get(entity).ninjutsu >= 30) {
						if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 400) {
							if ((NarutoShippudenModVariables.get(entity).customjutsutype1save).equals("Ball")) {
								if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Slow")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new WindBallItem.ArrowCustomEntity(WindBallItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 24, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Medium")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new WindBallItem.ArrowCustomEntity(WindBallItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 24, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 3, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Fast")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new WindBallItem.ArrowCustomEntity(WindBallItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 24, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 5, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								}
							} else if ((NarutoShippudenModVariables.get(entity).customjutsutype1save).equals("Wave")) {
								if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Slow")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new WindWaveItem.ArrowCustomEntity(WindWaveItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 29, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Medium")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new WindWaveItem.ArrowCustomEntity(WindWaveItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 29, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 3, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Fast")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new WindWaveItem.ArrowCustomEntity(WindWaveItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 29, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 5, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								}
							} else if ((NarutoShippudenModVariables.get(entity).customjutsutype1save).equals("Disk")) {
								if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Slow")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new WindDiskItem.ArrowCustomEntity(WindDiskItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 34, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Medium")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new WindDiskItem.ArrowCustomEntity(WindDiskItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 34, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 3, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Fast")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new WindDiskItem.ArrowCustomEntity(WindDiskItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 34, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 5, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								}
							}
							{
								double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 100);
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.ChakraAmount = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 399) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 29) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu (30 Required)"), (false));
						}
					}
				} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra1save == 500) {
					if (NarutoShippudenModVariables.get(entity).ninjutsu >= 35) {
						if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 500) {
							if ((NarutoShippudenModVariables.get(entity).customjutsutype1save).equals("Ball")) {
								if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Slow")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new WindBallItem.ArrowCustomEntity(WindBallItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 27, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Medium")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new WindBallItem.ArrowCustomEntity(WindBallItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 27, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 3, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Fast")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new WindBallItem.ArrowCustomEntity(WindBallItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 27, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 5, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								}
							} else if ((NarutoShippudenModVariables.get(entity).customjutsutype1save).equals("Wave")) {
								if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Slow")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new WindWaveItem.ArrowCustomEntity(WindWaveItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 32, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Medium")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new WindWaveItem.ArrowCustomEntity(WindWaveItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 32, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 3, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Fast")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new WindWaveItem.ArrowCustomEntity(WindWaveItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 32, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 5, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								}
							} else if ((NarutoShippudenModVariables.get(entity).customjutsutype1save).equals("Disk")) {
								if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Slow")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new WindDiskItem.ArrowCustomEntity(WindDiskItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 37, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Medium")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new WindDiskItem.ArrowCustomEntity(WindDiskItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 37, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 3, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed1save).equals("Fast")) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new WindDiskItem.ArrowCustomEntity(WindDiskItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 37, 0);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 5, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								}
							}
							{
								double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 100);
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.ChakraAmount = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 499) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 34) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu (35 Required)"), (false));
						}
					}
				}
			} else if (entity.isSneaking()) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity)
							.sendStatusMessage(
									new StringTextComponent(
											("Jutsu Info: " + "Jutsu Name: "
													+ NarutoShippudenModVariables.get(entity).jutsunamesave1
													+ " Release: "
													+ NarutoShippudenModVariables.get(entity).customjutsurelease1save
													+ " Type: "
													+ NarutoShippudenModVariables.get(entity).customjutsutype1save
													+ " Speed: "
													+ NarutoShippudenModVariables.get(entity).customjutsuspeed1save
													+ " \u00A7bChakra Cost: "
													+ NarutoShippudenModVariables.get(entity).customjutsuchakra1save)),
									(false));
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
						TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:Jutsu_Name");
						if (_tf != null) {
							return _tf.getText();
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
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
										{
											double _setval = 25;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
										{
											double _setval = 30;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
										{
											double _setval = 35;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
										{
											double _setval = 40;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Medium")) {
									if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
										{
											double _setval = 25;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
										{
											double _setval = 30;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
										{
											double _setval = 35;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
										{
											double _setval = 40;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
										{
											double _setval = 45;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Fast")) {
									if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
										{
											double _setval = 30;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
										{
											double _setval = 35;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
										{
											double _setval = 40;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
										{
											double _setval = 45;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
										{
											double _setval = 50;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
										{
											double _setval = 30;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
										{
											double _setval = 35;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
										{
											double _setval = 40;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
										{
											double _setval = 45;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Medium")) {
									if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
										{
											double _setval = 30;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
										{
											double _setval = 35;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
										{
											double _setval = 40;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
										{
											double _setval = 45;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
										{
											double _setval = 50;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Fast")) {
									if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
										{
											double _setval = 35;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
										{
											double _setval = 40;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
										{
											double _setval = 45;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
										{
											double _setval = 50;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
										{
											double _setval = 55;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
										{
											double _setval = 35;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
										{
											double _setval = 40;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
										{
											double _setval = 45;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
										{
											double _setval = 50;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Medium")) {
									if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
										{
											double _setval = 35;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
										{
											double _setval = 40;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
										{
											double _setval = 45;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
										{
											double _setval = 50;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
										{
											double _setval = 55;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Fast")) {
									if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
										{
											double _setval = 40;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
										{
											double _setval = 45;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
										{
											double _setval = 50;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
										{
											double _setval = 55;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
										{
											double _setval = 60;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									}
								}
							}
							{
								boolean _setval = (true);
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
										{
											double _setval = 25;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
										{
											double _setval = 30;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
										{
											double _setval = 35;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
										{
											double _setval = 40;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Medium")) {
									if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
										{
											double _setval = 25;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
										{
											double _setval = 30;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
										{
											double _setval = 35;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
										{
											double _setval = 40;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
										{
											double _setval = 45;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Fast")) {
									if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
										{
											double _setval = 30;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
										{
											double _setval = 35;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
										{
											double _setval = 40;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
										{
											double _setval = 50;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
										{
											double _setval = 30;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
										{
											double _setval = 35;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
										{
											double _setval = 40;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
										{
											double _setval = 45;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Medium")) {
									if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
										{
											double _setval = 30;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
										{
											double _setval = 35;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
										{
											double _setval = 40;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
										{
											double _setval = 45;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
										{
											double _setval = 50;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Fast")) {
									if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
										{
											double _setval = 35;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
										{
											double _setval = 40;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
										{
											double _setval = 45;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
										{
											double _setval = 50;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
										{
											double _setval = 55;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
										{
											double _setval = 35;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
										{
											double _setval = 40;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
										{
											double _setval = 45;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
										{
											double _setval = 50;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Medium")) {
									if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
										{
											double _setval = 35;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
										{
											double _setval = 40;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
										{
											double _setval = 45;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
										{
											double _setval = 50;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
										{
											double _setval = 55;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Fast")) {
									if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
										{
											double _setval = 40;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
										{
											double _setval = 45;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
										{
											double _setval = 50;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
										{
											double _setval = 55;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
										{
											double _setval = 60;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									}
								}
							}
							{
								boolean _setval = (true);
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
										{
											double _setval = 25;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
										{
											double _setval = 30;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
										{
											double _setval = 35;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
										{
											double _setval = 40;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Medium")) {
									if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
										{
											double _setval = 25;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
										{
											double _setval = 30;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
										{
											double _setval = 35;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
										{
											double _setval = 40;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
										{
											double _setval = 45;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Fast")) {
									if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
										{
											double _setval = 30;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
										{
											double _setval = 35;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
										{
											double _setval = 40;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
										{
											double _setval = 45;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
										{
											double _setval = 50;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
										{
											double _setval = 30;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
										{
											double _setval = 35;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
										{
											double _setval = 40;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
										{
											double _setval = 45;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Medium")) {
									if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
										{
											double _setval = 30;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
										{
											double _setval = 35;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
										{
											double _setval = 40;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
										{
											double _setval = 45;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
										{
											double _setval = 50;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Fast")) {
									if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
										{
											double _setval = 35;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
										{
											double _setval = 40;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
										{
											double _setval = 45;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
										{
											double _setval = 50;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
										{
											double _setval = 55;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
										{
											double _setval = 35;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
										{
											double _setval = 40;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
										{
											double _setval = 45;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
										{
											double _setval = 50;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Medium")) {
									if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
										{
											double _setval = 35;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
										{
											double _setval = 40;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
										{
											double _setval = 45;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
										{
											double _setval = 50;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
										{
											double _setval = 55;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Fast")) {
									if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
										{
											double _setval = 40;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
										{
											double _setval = 45;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
										{
											double _setval = 50;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
										{
											double _setval = 55;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
										{
											double _setval = 60;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									}
								}
							}
							{
								boolean _setval = (true);
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
										{
											double _setval = 20;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
										{
											double _setval = 25;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
										{
											double _setval = 30;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
										{
											double _setval = 35;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Medium")) {
									if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
										{
											double _setval = 20;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
										{
											double _setval = 25;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
										{
											double _setval = 30;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
										{
											double _setval = 35;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
										{
											double _setval = 40;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Fast")) {
									if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
										{
											double _setval = 25;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
										{
											double _setval = 30;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
										{
											double _setval = 35;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
										{
											double _setval = 40;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
										{
											double _setval = 45;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
										{
											double _setval = 25;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
										{
											double _setval = 30;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
										{
											double _setval = 35;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
										{
											double _setval = 40;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Medium")) {
									if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
										{
											double _setval = 25;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
										{
											double _setval = 30;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
										{
											double _setval = 35;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
										{
											double _setval = 40;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
										{
											double _setval = 45;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Fast")) {
									if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
										{
											double _setval = 30;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
										{
											double _setval = 35;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
										{
											double _setval = 40;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
										{
											double _setval = 45;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
										{
											double _setval = 50;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
										{
											double _setval = 30;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
										{
											double _setval = 35;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
										{
											double _setval = 40;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
										{
											double _setval = 45;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Medium")) {
									if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
										{
											double _setval = 30;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
										{
											double _setval = 35;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
										{
											double _setval = 40;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
										{
											double _setval = 45;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
										{
											double _setval = 50;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Fast")) {
									if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
										{
											double _setval = 35;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
										{
											double _setval = 40;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
										{
											double _setval = 45;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
										{
											double _setval = 50;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
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
							{
								boolean _setval = (true);
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
										{
											double _setval = 20;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
										{
											double _setval = 25;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
										{
											double _setval = 30;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
										{
											double _setval = 35;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Medium")) {
									if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
										{
											double _setval = 20;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
										{
											double _setval = 25;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
										{
											double _setval = 30;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
										{
											double _setval = 35;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
										{
											double _setval = 40;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Fast")) {
									if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
										{
											double _setval = 25;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
										{
											double _setval = 30;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
										{
											double _setval = 35;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
										{
											double _setval = 40;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
										{
											double _setval = 45;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
										{
											double _setval = 25;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
										{
											double _setval = 30;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
										{
											double _setval = 35;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
										{
											double _setval = 40;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Medium")) {
									if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
										{
											double _setval = 25;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
										{
											double _setval = 30;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
										{
											double _setval = 35;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
										{
											double _setval = 40;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
										{
											double _setval = 45;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Fast")) {
									if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
										{
											double _setval = 30;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
										{
											double _setval = 35;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
										{
											double _setval = 40;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
										{
											double _setval = 45;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
										{
											double _setval = 50;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
										{
											double _setval = 30;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
										{
											double _setval = 35;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
										{
											double _setval = 40;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
										{
											double _setval = 45;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Medium")) {
									if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
										{
											double _setval = 30;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
										{
											double _setval = 35;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
										{
											double _setval = 40;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
										{
											double _setval = 45;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
										{
											double _setval = 50;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									}
								} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Fast")) {
									if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
										{
											double _setval = 35;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
										{
											double _setval = 40;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
										{
											double _setval = 45;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
										{
											double _setval = 50;
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.customjutsujpcost = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
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
							{
								boolean _setval = (true);
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.customjutsuearth = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						}
						{
							String _setval = (NarutoShippudenModVariables.get(entity).customjutsutype);
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.customjutsutypesave = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							String _setval = (NarutoShippudenModVariables.get(entity).customjutsuspeed);
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.customjutsuspeedsave = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							String _setval = (NarutoShippudenModVariables.get(entity).customjutsurelease);
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.customjutsureleasesave = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							String _setval = (new Object() {
								public String getText() {
									TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:Jutsu_Name");
									if (_tf != null) {
										return _tf.getText();
									}
									return "";
								}
							}.getText());
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.jutsunamesave = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = (NarutoShippudenModVariables.get(entity).customjutsuchakra);
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.customjutsuchakrasave = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							boolean _setval = (true);
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.customjutsujpreadybuy = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Press Learn button again"), (false));
						}
					} else if (NarutoShippudenModVariables.get(entity).customjutsujpreadybuy == true) {
						if (NarutoShippudenModVariables.get(entity).jp >= NarutoShippudenModVariables.get(entity).customjutsujpcost) {
							{
								double _setval = (NarutoShippudenModVariables.get(entity).jp
										- NarutoShippudenModVariables.get(entity).customjutsujpcost);
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.jp = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity)
										.sendStatusMessage(
												new StringTextComponent(
														("-" + NarutoShippudenModVariables.get(entity).customjutsujpcost + " JP")),
												(false));
							}
							{
								String _setval = (NarutoShippudenModVariables.get(entity).customjutsutypesave);
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.customjutsutype1save = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								String _setval = (NarutoShippudenModVariables.get(entity).customjutsuspeedsave);
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.customjutsuspeed1save = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								String _setval = (NarutoShippudenModVariables.get(entity).customjutsureleasesave);
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.customjutsurelease1save = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								String _setval = (NarutoShippudenModVariables.get(entity).jutsunamesave);
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.jutsunamesave1 = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = (NarutoShippudenModVariables.get(entity).customjutsuchakrasave);
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.customjutsuchakra1save = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								boolean _setval = (false);
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.customjutsujpreadybuy = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							if ((NarutoShippudenModVariables.get(entity).customjutsureleasesave).equals("Fire")) {
								customjutsuname = new ItemStack(CustomFireReleaseTechniqueItem.block);
								((customjutsuname)).setDisplayName(new StringTextComponent(
										("Fire Release: " + NarutoShippudenModVariables.get(entity).jutsunamesave1)));
								if (entity instanceof PlayerEntity) {
									ItemStack _setstack = (customjutsuname);
									_setstack.setCount((int) 1);
									ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
								}
							} else if ((NarutoShippudenModVariables.get(entity).customjutsureleasesave).equals("Lightning")) {
								customjutsuname = new ItemStack(CustomLightningReleaseTechniqueItem.block);
								((customjutsuname)).setDisplayName(new StringTextComponent(
										("Lightning Release: " + NarutoShippudenModVariables.get(entity).jutsunamesave1)));
								if (entity instanceof PlayerEntity) {
									ItemStack _setstack = (customjutsuname);
									_setstack.setCount((int) 1);
									ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
								}
							} else if ((NarutoShippudenModVariables.get(entity).customjutsureleasesave).equals("Wind")) {
								customjutsuname = new ItemStack(CustomWindReleaseTechniqueItem.block);
								((customjutsuname)).setDisplayName(new StringTextComponent(
										("Wind Release: " + NarutoShippudenModVariables.get(entity).jutsunamesave1)));
								if (entity instanceof PlayerEntity) {
									ItemStack _setstack = (customjutsuname);
									_setstack.setCount((int) 1);
									ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
								}
							} else if ((NarutoShippudenModVariables.get(entity).customjutsureleasesave).equals("Water")) {
								customjutsuname = new ItemStack(CustomWaterReleaseTechniqueItem.block);
								((customjutsuname)).setDisplayName(new StringTextComponent(
										("Water Release: " + NarutoShippudenModVariables.get(entity).jutsunamesave1)));
								if (entity instanceof PlayerEntity) {
									ItemStack _setstack = (customjutsuname);
									_setstack.setCount((int) 1);
									ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
								}
							} else if ((NarutoShippudenModVariables.get(entity).customjutsureleasesave).equals("Earth")) {
								customjutsuname = new ItemStack(CustomEarthReleaseTechniqueItem.block);
								((customjutsuname)).setDisplayName(new StringTextComponent(
										("Earth Release: " + NarutoShippudenModVariables.get(entity).jutsunamesave1)));
								if (entity instanceof PlayerEntity) {
									ItemStack _setstack = (customjutsuname);
									_setstack.setCount((int) 1);
									ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
								}
							}
							{
								boolean _setval = (true);
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.customjutsu1learn = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							if (entity instanceof PlayerEntity)
								((PlayerEntity) entity).closeScreen();
						} else if (NarutoShippudenModVariables.get(entity).jp <= NarutoShippudenModVariables.get(entity).customjutsujpcost - 1) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough JP"), (false));
							}
							{
								boolean _setval = (false);
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.customjutsujpreadybuy = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						}
					}
				} else if ((new Object() {
					public String getText() {
						TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:Jutsu_Name");
						if (_tf != null) {
							return _tf.getText();
						}
						return "";
					}
				}.getText()).equals("")) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Name your jutsu"), (false));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).customjutsucheckpricelogic == false) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Check price first of all"), (false));
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
			if (((entity instanceof PlayerEntity)
					? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(CustomLightningReleaseTechniqueItem.block))
					: false)
					|| ((entity instanceof PlayerEntity)
							? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(CustomWindReleaseTechniqueItem.block))
							: false)
					|| ((entity instanceof PlayerEntity)
							? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(CustomWaterReleaseTechniqueItem.block))
							: false)
					|| ((entity instanceof PlayerEntity)
							? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(CustomEarthReleaseTechniqueItem.block))
							: false)
					|| ((entity instanceof PlayerEntity)
							? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(CustomFireReleaseTechniqueItem.block))
							: false)) {
				if (NarutoShippudenModVariables.get(entity).customjutsujpcost == 10) {
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp + 5);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else if (NarutoShippudenModVariables.get(entity).customjutsujpcost == 15) {
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp + 8);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else if (NarutoShippudenModVariables.get(entity).customjutsujpcost == 20) {
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp + 10);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else if (NarutoShippudenModVariables.get(entity).customjutsujpcost == 25) {
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp + 13);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else if (NarutoShippudenModVariables.get(entity).customjutsujpcost == 30) {
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp + 15);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else if (NarutoShippudenModVariables.get(entity).customjutsujpcost == 35) {
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp + 18);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else if (NarutoShippudenModVariables.get(entity).customjutsujpcost == 40) {
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp + 20);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else if (NarutoShippudenModVariables.get(entity).customjutsujpcost == 45) {
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp + 23);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else if (NarutoShippudenModVariables.get(entity).customjutsujpcost == 50) {
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp + 25);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else if (NarutoShippudenModVariables.get(entity).customjutsujpcost == 55) {
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp + 28);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else if (NarutoShippudenModVariables.get(entity).customjutsujpcost == 60) {
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp + 30);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else if (NarutoShippudenModVariables.get(entity).customjutsujpcost == 65) {
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp + 33);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
				{
					boolean _setval = (false);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.customjutsu1learn = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof PlayerEntity)
					((PlayerEntity) entity).closeScreen();
				if (entity instanceof PlayerEntity) {
					ItemStack _stktoremove = new ItemStack(CustomFireReleaseTechniqueItem.block);
					((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
							((PlayerEntity) entity).container.func_234641_j_());
				}
				if (entity instanceof PlayerEntity) {
					ItemStack _stktoremove = new ItemStack(CustomLightningReleaseTechniqueItem.block);
					((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
							((PlayerEntity) entity).container.func_234641_j_());
				}
				if (entity instanceof PlayerEntity) {
					ItemStack _stktoremove = new ItemStack(CustomWindReleaseTechniqueItem.block);
					((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
							((PlayerEntity) entity).container.func_234641_j_());
				}
				if (entity instanceof PlayerEntity) {
					ItemStack _stktoremove = new ItemStack(CustomWaterReleaseTechniqueItem.block);
					((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
							((PlayerEntity) entity).container.func_234641_j_());
				}
				if (entity instanceof PlayerEntity) {
					ItemStack _stktoremove = new ItemStack(CustomEarthReleaseTechniqueItem.block);
					((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
							((PlayerEntity) entity).container.func_234641_j_());
				}
			} else if (!((entity instanceof PlayerEntity)
					? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(CustomLightningReleaseTechniqueItem.block))
					: false)
					|| !((entity instanceof PlayerEntity)
							? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(CustomWindReleaseTechniqueItem.block))
							: false)
					|| !((entity instanceof PlayerEntity)
							? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(CustomWaterReleaseTechniqueItem.block))
							: false)
					|| !((entity instanceof PlayerEntity)
							? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(CustomEarthReleaseTechniqueItem.block))
							: false)
					|| !((entity instanceof PlayerEntity)
							? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(CustomFireReleaseTechniqueItem.block))
							: false)) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Take your custom jutsu in inventory"), (false));
				}
			}
		}
	}
}
