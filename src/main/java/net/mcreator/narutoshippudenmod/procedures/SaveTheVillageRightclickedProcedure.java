package net.mcreator.narutoshippudenmod.procedures;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.narutoshippudenmod.item.SaveTheVillageItem;
import net.mcreator.narutoshippudenmod.item.BanknoteOfRyoItem;
import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables;
import net.mcreator.narutoshippudenmod.NarutoShippudenMod;

import java.util.Map;

public class SaveTheVillageRightclickedProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure SaveTheVillageRightclicked!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).zombiekillcount >= 10) {
			if (entity instanceof PlayerEntity) {
				ItemStack _setstack = new ItemStack(BanknoteOfRyoItem.block);
				_setstack.setCount((int) 20);
				ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
			}
			if (entity instanceof PlayerEntity) {
				ItemStack _stktoremove = new ItemStack(SaveTheVillageItem.block);
				((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
						((PlayerEntity) entity).container.func_234641_j_());
			}
		} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).zombiekillcount <= 9) {
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Kill 10 Zombies"), (false));
			}
		}
	}
}
