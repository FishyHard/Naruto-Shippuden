package net.mcreator.narutoshippudenmod.procedures;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables;
import net.mcreator.narutoshippudenmod.NarutoShippudenMod;

import java.util.Map;

public class SmokeReleaseTechniqueLivingEntityIsHitWithItemProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure SmokeReleaseTechniqueLivingEntityIsHitWithItem!");
			return;
		}
		if (dependencies.get("sourceentity") == null) {
			if (!dependencies.containsKey("sourceentity"))
				NarutoShippudenMod.LOGGER
						.warn("Failed to load dependency sourceentity for procedure SmokeReleaseTechniqueLivingEntityIsHitWithItem!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		if (NarutoShippudenModVariables.get(sourceentity).ninjutsu >= 35) {
			if (NarutoShippudenModVariables.get(sourceentity).ChakraAmount >= 750) {
				if (NarutoShippudenModVariables.get(sourceentity).jutsupower == 0) {
					entity.attackEntityFrom(DamageSource.GENERIC, (float) 35);
				} else if (NarutoShippudenModVariables.get(sourceentity).jutsupower == 1) {
					entity.attackEntityFrom(DamageSource.GENERIC, (float) 36);
				} else if (NarutoShippudenModVariables.get(sourceentity).jutsupower == 2) {
					entity.attackEntityFrom(DamageSource.GENERIC, (float) 37);
				} else if (NarutoShippudenModVariables.get(sourceentity).jutsupower == 3) {
					entity.attackEntityFrom(DamageSource.GENERIC, (float) 38);
				} else if (NarutoShippudenModVariables.get(sourceentity).jutsupower == 4) {
					entity.attackEntityFrom(DamageSource.GENERIC, (float) 39);
				} else if (NarutoShippudenModVariables.get(sourceentity).jutsupower == 5) {
					entity.attackEntityFrom(DamageSource.GENERIC, (float) 40);
				} else if (NarutoShippudenModVariables.get(sourceentity).jutsupower == 6) {
					entity.attackEntityFrom(DamageSource.GENERIC, (float) 41);
				} else if (NarutoShippudenModVariables.get(sourceentity).jutsupower == 7) {
					entity.attackEntityFrom(DamageSource.GENERIC, (float) 42);
				} else if (NarutoShippudenModVariables.get(sourceentity).jutsupower == 8) {
					entity.attackEntityFrom(DamageSource.GENERIC, (float) 43);
				} else if (NarutoShippudenModVariables.get(sourceentity).jutsupower == 9) {
					entity.attackEntityFrom(DamageSource.GENERIC, (float) 44);
				}
				{
					double _setval = (NarutoShippudenModVariables.get(sourceentity).ChakraAmount - 750);
					sourceentity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ChakraAmount = _setval;
						capability.syncPlayerVariables(sourceentity);
					});
				}
			} else if (NarutoShippudenModVariables.get(sourceentity).ChakraAmount <= 749) {
				if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
					((PlayerEntity) sourceentity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
				}
			}
		} else if (NarutoShippudenModVariables.get(sourceentity).ninjutsu <= 34) {
			if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
				((PlayerEntity) sourceentity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu"), (false));
			}
		}
	}
}
