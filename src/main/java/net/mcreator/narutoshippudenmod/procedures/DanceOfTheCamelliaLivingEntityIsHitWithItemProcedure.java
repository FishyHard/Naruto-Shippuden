package net.mcreator.narutoshippudenmod.procedures;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.DamageSource;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.narutoshippudenmod.item.DanceOfTheCamelliaItem;
import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables;
import net.mcreator.narutoshippudenmod.NarutoShippudenMod;

import java.util.Map;

public class DanceOfTheCamelliaLivingEntityIsHitWithItemProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DanceOfTheCamelliaLivingEntityIsHitWithItem!");
			return;
		}
		if (dependencies.get("sourceentity") == null) {
			if (!dependencies.containsKey("sourceentity"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency sourceentity for procedure DanceOfTheCamelliaLivingEntityIsHitWithItem!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		if (NarutoShippudenModVariables.get(sourceentity).ninjutsu >= 15) {
			if (NarutoShippudenModVariables.get(sourceentity).ChakraAmount >= 200) {
				entity.attackEntityFrom(DamageSource.GENERIC, (float) 20);
				if (sourceentity instanceof PlayerEntity) {
					ItemStack _stktoremove = new ItemStack(DanceOfTheCamelliaItem.block);
					((PlayerEntity) sourceentity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
							((PlayerEntity) sourceentity).container.func_234641_j_());
				}
				{
					double _setval = (NarutoShippudenModVariables.get(sourceentity).ChakraAmount - 200);
					sourceentity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ChakraAmount = _setval;
						capability.syncPlayerVariables(sourceentity);
					});
				}
			} else if (NarutoShippudenModVariables.get(sourceentity).ChakraAmount <= 199) {
				if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
					((PlayerEntity) sourceentity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
				}
			}
		} else if (NarutoShippudenModVariables.get(sourceentity).ninjutsu <= 14) {
			if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
				((PlayerEntity) sourceentity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu"), (false));
			}
		}
	}
}
