package net.mcreator.narutoshippudenmod.procedures;

import net.minecraft.util.DamageSource;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.narutoshippudenmod.item.GentleStepTwinLionFistsItem;
import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables;
import net.mcreator.narutoshippudenmod.NarutoShippudenMod;

import java.util.Map;

public class GentleStepTwinLionFistsLivingEntityIsHitWithItemProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure GentleStepTwinLionFistsLivingEntityIsHitWithItem!");
			return;
		}
		if (dependencies.get("sourceentity") == null) {
			if (!dependencies.containsKey("sourceentity"))
				NarutoShippudenMod.LOGGER
						.warn("Failed to load dependency sourceentity for procedure GentleStepTwinLionFistsLivingEntityIsHitWithItem!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		if ((sourceentity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).jutsupower == 0) {
			entity.attackEntityFrom(DamageSource.GENERIC, (float) 15);
		} else if ((sourceentity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).jutsupower == 1) {
			entity.attackEntityFrom(DamageSource.GENERIC, (float) 16);
		} else if ((sourceentity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).jutsupower == 2) {
			entity.attackEntityFrom(DamageSource.GENERIC, (float) 17);
		} else if ((sourceentity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).jutsupower == 3) {
			entity.attackEntityFrom(DamageSource.GENERIC, (float) 18);
		} else if ((sourceentity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).jutsupower == 4) {
			entity.attackEntityFrom(DamageSource.GENERIC, (float) 19);
		} else if ((sourceentity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).jutsupower == 5) {
			entity.attackEntityFrom(DamageSource.GENERIC, (float) 20);
		} else if ((sourceentity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).jutsupower == 6) {
			entity.attackEntityFrom(DamageSource.GENERIC, (float) 21);
		} else if ((sourceentity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).jutsupower == 7) {
			entity.attackEntityFrom(DamageSource.GENERIC, (float) 22);
		} else if ((sourceentity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).jutsupower == 8) {
			entity.attackEntityFrom(DamageSource.GENERIC, (float) 23);
		} else if ((sourceentity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).jutsupower == 9) {
			entity.attackEntityFrom(DamageSource.GENERIC, (float) 24);
		}
		if (sourceentity instanceof PlayerEntity) {
			ItemStack _stktoremove = new ItemStack(GentleStepTwinLionFistsItem.block);
			((PlayerEntity) sourceentity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 2,
					((PlayerEntity) sourceentity).container.func_234641_j_());
		}
	}
}
