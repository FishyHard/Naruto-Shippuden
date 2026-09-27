package net.mcreator.narutoshippudenmod.procedures;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.narutoshippudenmod.item.StormReleaseItem;
import net.mcreator.narutoshippudenmod.item.FlyingThunderGodKunaiItem;
import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables;
import net.mcreator.narutoshippudenmod.NarutoShippudenMod;

import java.util.Map;

public class NamikazeReleaseRightclickedProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure NamikazeReleaseRightclicked!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (NarutoShippudenModVariables.get(entity).namikaze_release == 0) {
			if (NarutoShippudenModVariables.get(entity).jp >= 5) {
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(StormReleaseItem.block);
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).jp - 5);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.jp = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).namikaze_release + 1);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.namikaze_release = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("-5 JP"), (false));
				}
				{
					boolean _setval = (true);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.stormreleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (NarutoShippudenModVariables.get(entity).jp <= 4) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough JP"), (false));
				}
			}
		} else if (NarutoShippudenModVariables.get(entity).namikaze_release == 1) {
			if (NarutoShippudenModVariables.get(entity).jp >= 10) {
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(FlyingThunderGodKunaiItem.block);
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).jp - 10);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.jp = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).namikaze_release + 1);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.namikaze_release = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("-10 JP"), (false));
				}
			} else if (NarutoShippudenModVariables.get(entity).jp <= 9) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough JP"), (false));
				}
			}
		}
	}
}
