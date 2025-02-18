package net.mcreator.narutoshippudenmod.procedures;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.MathHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.narutoshippudenmod.item.MagnetReleaseItem;
import net.mcreator.narutoshippudenmod.item.MagnetDNAReleaseItem;
import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables;
import net.mcreator.narutoshippudenmod.NarutoShippudenMod;

import java.util.Random;
import java.util.Map;

public class MagnetDNARightClickedProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure MagnetDNARightClicked!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double random = 0;
		if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).magnetreleaselogic == false) {
			random = (MathHelper.nextInt(new Random(), 1, 100));
			if (random <= 50) {
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(MagnetReleaseItem.block);
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Magnet Release implanted succesfully"), (false));
				}
				{
					boolean _setval = (true);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.magnetreleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (random >= 51) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Magnet Release implanted failed"), (false));
				}
			}
			if (entity instanceof PlayerEntity) {
				ItemStack _stktoremove = new ItemStack(MagnetDNAReleaseItem.block);
				((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
						((PlayerEntity) entity).container.func_234641_j_());
			}
		} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).magnetreleaselogic == true) {
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You already have Magnet Release"), (false));
			}
		}
	}
}
