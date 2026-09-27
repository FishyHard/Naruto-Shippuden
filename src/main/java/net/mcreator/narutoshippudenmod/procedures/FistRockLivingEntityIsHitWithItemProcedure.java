package net.mcreator.narutoshippudenmod.procedures;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.DamageSource;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.narutoshippudenmod.item.FistRockItem;
import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables;
import net.mcreator.narutoshippudenmod.NarutoShippudenMod;

import java.util.Map;

public class FistRockLivingEntityIsHitWithItemProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure FistRockLivingEntityIsHitWithItem!");
			return;
		}
		if (dependencies.get("sourceentity") == null) {
			if (!dependencies.containsKey("sourceentity"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency sourceentity for procedure FistRockLivingEntityIsHitWithItem!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		if (NarutoShippudenModVariables.get(sourceentity).ninjutsu >= 5) {
			if (NarutoShippudenModVariables.get(sourceentity).ChakraAmount >= 20) {
				if (NarutoShippudenModVariables.get(sourceentity).jutsupower == 0) {
					entity.attackEntityFrom(DamageSource.GENERIC, (float) 5);
				} else if (NarutoShippudenModVariables.get(sourceentity).jutsupower == 1) {
					entity.attackEntityFrom(DamageSource.GENERIC, (float) 6);
				} else if (NarutoShippudenModVariables.get(sourceentity).jutsupower == 2) {
					entity.attackEntityFrom(DamageSource.GENERIC, (float) 7);
				} else if (NarutoShippudenModVariables.get(sourceentity).jutsupower == 3) {
					entity.attackEntityFrom(DamageSource.GENERIC, (float) 8);
				} else if (NarutoShippudenModVariables.get(sourceentity).jutsupower == 4) {
					entity.attackEntityFrom(DamageSource.GENERIC, (float) 9);
				} else if (NarutoShippudenModVariables.get(sourceentity).jutsupower == 5) {
					entity.attackEntityFrom(DamageSource.GENERIC, (float) 10);
				} else if (NarutoShippudenModVariables.get(sourceentity).jutsupower == 6) {
					entity.attackEntityFrom(DamageSource.GENERIC, (float) 11);
				} else if (NarutoShippudenModVariables.get(sourceentity).jutsupower == 7) {
					entity.attackEntityFrom(DamageSource.GENERIC, (float) 12);
				} else if (NarutoShippudenModVariables.get(sourceentity).jutsupower == 8) {
					entity.attackEntityFrom(DamageSource.GENERIC, (float) 13);
				} else if (NarutoShippudenModVariables.get(sourceentity).jutsupower == 9) {
					entity.attackEntityFrom(DamageSource.GENERIC, (float) 14);
				}
				if (sourceentity instanceof PlayerEntity) {
					ItemStack _stktoremove = new ItemStack(FistRockItem.block);
					((PlayerEntity) sourceentity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
							((PlayerEntity) sourceentity).container.func_234641_j_());
				}
				{
					double _setval = (NarutoShippudenModVariables.get(sourceentity).ChakraAmount - 20);
					sourceentity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ChakraAmount = _setval;
						capability.syncPlayerVariables(sourceentity);
					});
				}
			} else if (NarutoShippudenModVariables.get(sourceentity).ChakraAmount <= 19) {
				if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
					((PlayerEntity) sourceentity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
				}
			}
		} else if (NarutoShippudenModVariables.get(sourceentity).ninjutsu <= 4) {
			if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
				((PlayerEntity) sourceentity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu"), (false));
			}
		}
	}
}
