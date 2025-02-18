package net.mcreator.narutoshippudenmod.procedures;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables;
import net.mcreator.narutoshippudenmod.NarutoShippudenMod;

import java.util.Map;

public class BoilReleaseTechniqueLivingEntityIsHitWithItemProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure BoilReleaseTechniqueLivingEntityIsHitWithItem!");
			return;
		}
		if (dependencies.get("sourceentity") == null) {
			if (!dependencies.containsKey("sourceentity"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency sourceentity for procedure BoilReleaseTechniqueLivingEntityIsHitWithItem!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		boolean isNegative = false;
		double yaw = 0;
		if ((sourceentity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).UnrivaledStrength == true) {
			if ((sourceentity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount >= 400) {
				if (sourceentity.rotationYaw < 0) {
					yaw = Math.abs(sourceentity.rotationYaw);
					isNegative = (true);
				} else {
					isNegative = (false);
					yaw = (sourceentity.rotationYaw);
				}
				if (yaw % 360 >= 0 && yaw % 360 < 22.5) {
					entity.setMotion(0, 1.5, (6 + Math.sin(yaw)));
				} else if (yaw % 360 >= 22.5 && yaw % 360 < 80) {
					if (isNegative == true) {
						entity.setMotion((6 + Math.cos(yaw)), 1.5, (6 + Math.sin(yaw)));
					} else {
						entity.setMotion(((-6) - Math.cos(yaw)), 1.5, (6 + Math.sin(yaw)));
					}
				} else if (yaw % 360 >= 80 && yaw % 360 < 112.5) {
					if (isNegative == true) {
						entity.setMotion((6 + Math.cos(yaw)), 1.5, 0);
					} else {
						entity.setMotion(((-6) - Math.cos(yaw)), 1.5, 0);
					}
				} else if (yaw % 360 >= 112.5 && yaw % 360 <= 157.5) {
					if (isNegative == true) {
						entity.setMotion((6 + Math.cos(yaw)), 1.5, ((-6) - Math.sin(yaw)));
					} else {
						entity.setMotion(((-6) - Math.cos(yaw)), 1.5, ((-6) - Math.sin(yaw)));
					}
				} else if (yaw % 360 >= 157.5 && yaw % 360 < 202.5) {
					entity.setMotion(0, 1.5, ((-6) - Math.sin(yaw)));
				} else if (yaw % 360 >= 202.5 && yaw % 360 < 247.5) {
					if (isNegative == true) {
						entity.setMotion(((-6) - Math.cos(yaw)), 1.5, ((-6) - Math.sin(yaw)));
					} else {
						entity.setMotion((6 + Math.cos(yaw)), 1.5, ((-6) - Math.sin(yaw)));
					}
				} else if (yaw % 360 >= 247.5 && yaw % 360 < 292.5) {
					if (isNegative == true) {
						entity.setMotion(((-6) - Math.cos(yaw)), 1.5, 0);
					} else {
						entity.setMotion((6 + Math.cos(yaw)), 1.5, 0);
					}
				} else if (yaw % 360 >= 292.5 && yaw % 360 < 337.5) {
					if (isNegative == true) {
						entity.setMotion(((-6) - Math.cos(yaw)), 1.5, (6 + Math.sin(yaw)));
					} else {
						entity.setMotion((6 + Math.cos(yaw)), 1.5, (6 + Math.sin(yaw)));
					}
				} else if (yaw % 360 >= 337.5 && yaw % 360 <= 360) {
					entity.setMotion(0, 1.5, (6 + Math.sin(yaw)));
				}
				entity.attackEntityFrom(DamageSource.GENERIC, (float) 25);
				{
					double _setval = ((sourceentity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount - 400);
					sourceentity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ChakraAmount = _setval;
						capability.syncPlayerVariables(sourceentity);
					});
				}
			} else if ((sourceentity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount <= 399) {
				if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
					((PlayerEntity) sourceentity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
				}
			}
		}
	}
}
