package net.mcreator.narutoshippudenmod.procedures;

import net.minecraft.util.DamageSource;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.narutoshippudenmod.item.EightTrigramsTwinLionsCrumblingAttackItem;
import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables;
import net.mcreator.narutoshippudenmod.NarutoShippudenMod;

import java.util.Map;

public class EightTrigramsTwinLionsCrumblingAttackLivingEntityIsHitWithItemProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NarutoShippudenMod.LOGGER
						.warn("Failed to load dependency entity for procedure EightTrigramsTwinLionsCrumblingAttackLivingEntityIsHitWithItem!");
			return;
		}
		if (dependencies.get("sourceentity") == null) {
			if (!dependencies.containsKey("sourceentity"))
				NarutoShippudenMod.LOGGER
						.warn("Failed to load dependency sourceentity for procedure EightTrigramsTwinLionsCrumblingAttackLivingEntityIsHitWithItem!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		if (NarutoShippudenModVariables.get(sourceentity).jutsupower == 0) {
			entity.attackEntityFrom(DamageSource.GENERIC, (float) 20);
		} else if (NarutoShippudenModVariables.get(sourceentity).jutsupower == 1) {
			entity.attackEntityFrom(DamageSource.GENERIC, (float) 21);
		} else if (NarutoShippudenModVariables.get(sourceentity).jutsupower == 2) {
			entity.attackEntityFrom(DamageSource.GENERIC, (float) 22);
		} else if (NarutoShippudenModVariables.get(sourceentity).jutsupower == 3) {
			entity.attackEntityFrom(DamageSource.GENERIC, (float) 23);
		} else if (NarutoShippudenModVariables.get(sourceentity).jutsupower == 4) {
			entity.attackEntityFrom(DamageSource.GENERIC, (float) 24);
		} else if (NarutoShippudenModVariables.get(sourceentity).jutsupower == 5) {
			entity.attackEntityFrom(DamageSource.GENERIC, (float) 25);
		} else if (NarutoShippudenModVariables.get(sourceentity).jutsupower == 6) {
			entity.attackEntityFrom(DamageSource.GENERIC, (float) 26);
		} else if (NarutoShippudenModVariables.get(sourceentity).jutsupower == 7) {
			entity.attackEntityFrom(DamageSource.GENERIC, (float) 27);
		} else if (NarutoShippudenModVariables.get(sourceentity).jutsupower == 8) {
			entity.attackEntityFrom(DamageSource.GENERIC, (float) 28);
		} else if (NarutoShippudenModVariables.get(sourceentity).jutsupower == 9) {
			entity.attackEntityFrom(DamageSource.GENERIC, (float) 29);
		}
		if (sourceentity instanceof PlayerEntity) {
			ItemStack _stktoremove = new ItemStack(EightTrigramsTwinLionsCrumblingAttackItem.block);
			((PlayerEntity) sourceentity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 2,
					((PlayerEntity) sourceentity).container.func_234641_j_());
		}
	}
}
