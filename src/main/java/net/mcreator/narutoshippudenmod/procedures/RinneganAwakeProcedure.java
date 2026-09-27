package net.mcreator.narutoshippudenmod.procedures;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.narutoshippudenmod.item.RinneganReleaseItem;
import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables;
import net.mcreator.narutoshippudenmod.NarutoShippudenMod;

import java.util.Map;

public class RinneganAwakeProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure RinneganAwake!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (NarutoShippudenModVariables.get(entity).uchihareleaselogic == true) {
			if (NarutoShippudenModVariables.get(entity).firereleaselogic == true
					&& NarutoShippudenModVariables.get(entity).earthreleaselogic == true
					&& NarutoShippudenModVariables.get(entity).lightningreleaselogic == true
					&& NarutoShippudenModVariables.get(entity).windreleaselogic == true
					&& NarutoShippudenModVariables.get(entity).waterreleaselogic == true
					&& NarutoShippudenModVariables.get(entity).woodreleaselogic == true) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You've awakened Rinnegan!"), (false));
				}
				{
					String _setval = "1x1";
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.dojutsurinnegan = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(RinneganReleaseItem.block);
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
				{
					boolean _setval = (true);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.rinnegan = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		} else if (NarutoShippudenModVariables.get(entity).otsutsukireleaselogic == true) {
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You've awakened Rinnegan!"), (false));
			}
			{
				String _setval = "1x1";
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.dojutsurinnegan = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof PlayerEntity) {
				ItemStack _setstack = new ItemStack(RinneganReleaseItem.block);
				_setstack.setCount((int) 1);
				ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
			}
			{
				boolean _setval = (true);
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.rinnegan = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
