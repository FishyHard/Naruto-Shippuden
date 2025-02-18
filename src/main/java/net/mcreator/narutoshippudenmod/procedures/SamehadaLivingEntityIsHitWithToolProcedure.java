package net.mcreator.narutoshippudenmod.procedures;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables;
import net.mcreator.narutoshippudenmod.NarutoShippudenMod;

import java.util.Map;

public class SamehadaLivingEntityIsHitWithToolProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure SamehadaLivingEntityIsHitWithTool!");
			return;
		}
		if (dependencies.get("sourceentity") == null) {
			if (!dependencies.containsKey("sourceentity"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency sourceentity for procedure SamehadaLivingEntityIsHitWithTool!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency itemstack for procedure SamehadaLivingEntityIsHitWithTool!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		double chakramaxuser = 0;
		double chakraamountuser = 0;
		if (itemstack.getOrCreateTag().getDouble("SamehadaMode") == 0) {
			if (entity instanceof PlayerEntity) {
				chakraamountuser = ((sourceentity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount
						+ ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount / 100) * 5);
				chakramaxuser = ((sourceentity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraMax);
				if (chakraamountuser <= chakramaxuser) {
					{
						double _setval = ((sourceentity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount
								+ ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount / 100) * 5);
						sourceentity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.ChakraAmount = _setval;
							capability.syncPlayerVariables(sourceentity);
						});
					}
				} else if (!(chakraamountuser <= chakramaxuser)) {
					{
						double _setval = ((sourceentity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraMax);
						sourceentity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.ChakraAmount = _setval;
							capability.syncPlayerVariables(sourceentity);
						});
					}
				}
			} else {
				if (!(entity.getPersistentData().getDouble("ChakraMax") == 0)) {
					chakraamountuser = ((sourceentity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount
							+ (entity.getPersistentData().getDouble("ChakraAmount") / 100) * 5);
					chakramaxuser = ((sourceentity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraMax);
					if (chakraamountuser <= chakramaxuser) {
						{
							double _setval = ((sourceentity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount
									+ (entity.getPersistentData().getDouble("ChakraAmount") / 100) * 5);
							sourceentity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.ChakraAmount = _setval;
								capability.syncPlayerVariables(sourceentity);
							});
						}
					} else if (!(chakraamountuser <= chakramaxuser)) {
						{
							double _setval = ((sourceentity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraMax);
							sourceentity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.ChakraAmount = _setval;
								capability.syncPlayerVariables(sourceentity);
							});
						}
					}
				}
			}
		} else if (itemstack.getOrCreateTag().getDouble("SamehadaMode") == 1) {
			if (entity instanceof PlayerEntity) {
				if (sourceentity instanceof LivingEntity)
					((LivingEntity) sourceentity)
							.setHealth((float) (((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHealth() : -1)
									+ Math.ceil(((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount / 5000) * 10)));
			} else {
				if (sourceentity instanceof LivingEntity)
					((LivingEntity) sourceentity)
							.setHealth((float) (((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHealth() : -1)
									+ Math.ceil((entity.getPersistentData().getDouble("ChakraAmount") / 5000) * 10)));
			}
		}
	}
}
