package net.mcreator.narutoshippudenmod.procedures;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.MathHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.narutoshippudenmod.item.FireReleaseItem;
import net.mcreator.narutoshippudenmod.item.FireDNAReleaseItem;
import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables;
import net.mcreator.narutoshippudenmod.NarutoShippudenMod;

import java.util.Random;
import java.util.Map;

public class FireDNARightclickedProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure FireDNARightclicked!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double randomfire = 0;
		if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).firereleaselogic == false) {
			randomfire = (MathHelper.nextInt(new Random(), 1, 100));
			if (randomfire <= 70) {
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(FireReleaseItem.block);
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Fire Release implanted succesfully"), (false));
				}
				{
					boolean _setval = (true);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.firereleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (randomfire >= 71) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Fire Release implanted failed"), (false));
				}
			}
			if (entity instanceof PlayerEntity) {
				ItemStack _stktoremove = new ItemStack(FireDNAReleaseItem.block);
				((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
						((PlayerEntity) entity).container.func_234641_j_());
			}
		} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).firereleaselogic == true) {
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You already have Fire Release"), (false));
			}
		}
	}
}
