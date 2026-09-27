package net.mcreator.narutoshippudenmod.procedures;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.narutoshippudenmod.item.MangekyouSharinganSasukeReleaseTechniqueItem;
import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables;
import net.mcreator.narutoshippudenmod.NarutoShippudenMod;

import java.util.Map;

public class MangekyouSharinganSasukeReleaseRightclickedProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure MangekyouSharinganSasukeReleaseRightclicked!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (!entity.isSneaking()) {
			if (NarutoShippudenModVariables.get(entity).MangekyouSharinganRelease == 0) {
				if (NarutoShippudenModVariables.get(entity).mangekyousharingansasukeamaterasurelease == 0) {
					if (NarutoShippudenModVariables.get(entity).jp >= 10) {
						if (NarutoShippudenModVariables.get(entity).mangekyousharingansasukesusanolearn == 0) {
							if (entity instanceof PlayerEntity) {
								ItemStack _setstack = new ItemStack(MangekyouSharinganSasukeReleaseTechniqueItem.block);
								_setstack.setCount((int) 1);
								ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
							}
						}
						{
							double _setval = 1;
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.mangekyousharingansasukeamaterasulearn = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = (NarutoShippudenModVariables.get(entity).jp - 10);
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.jp = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = (NarutoShippudenModVariables.get(entity).mangekyousharingansasukeamaterasurelease + 1);
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.mangekyousharingansasukeamaterasurelease = _setval;
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
				} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansasukeamaterasurelease == 1) {
					if (NarutoShippudenModVariables.get(entity).jp >= 15) {
						{
							double _setval = 2;
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.mangekyousharingansasukeamaterasulearn = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = (NarutoShippudenModVariables.get(entity).jp - 15);
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.jp = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = (NarutoShippudenModVariables.get(entity).mangekyousharingansasukeamaterasurelease + 1);
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.mangekyousharingansasukeamaterasurelease = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("-15 JP"), (false));
						}
					} else if (NarutoShippudenModVariables.get(entity).jp <= 14) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough JP"), (false));
						}
					}
				} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansasukeamaterasurelease == 2) {
					if (NarutoShippudenModVariables.get(entity).jp >= 20) {
						{
							double _setval = 3;
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.mangekyousharingansasukeamaterasulearn = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = (NarutoShippudenModVariables.get(entity).jp - 20);
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.jp = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = (NarutoShippudenModVariables.get(entity).mangekyousharingansasukeamaterasurelease + 1);
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.mangekyousharingansasukeamaterasurelease = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("-20 JP"), (false));
						}
					} else if (NarutoShippudenModVariables.get(entity).jp <= 19) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough JP"), (false));
						}
					}
				} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansasukeamaterasurelease == 3) {
					if (NarutoShippudenModVariables.get(entity).jp >= 25) {
						{
							double _setval = 4;
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.mangekyousharingansasukeamaterasulearn = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = (NarutoShippudenModVariables.get(entity).jp - 25);
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.jp = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = (NarutoShippudenModVariables.get(entity).mangekyousharingansasukeamaterasurelease + 1);
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.mangekyousharingansasukeamaterasurelease = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("-25 JP"), (false));
						}
					} else if (NarutoShippudenModVariables.get(entity).jp <= 24) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough JP"), (false));
						}
					}
				} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansasukeamaterasurelease == 4) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Wait For Newer Updates"), (false));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).MangekyouSharinganRelease == 1) {
				if (NarutoShippudenModVariables.get(entity).mangekyousharingansasukesusanorelease == 0) {
					if (NarutoShippudenModVariables.get(entity).jp >= 10) {
						{
							double _setval = 1;
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.mangekyousharingansasukesusanolearn = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = (NarutoShippudenModVariables.get(entity).jp - 10);
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.jp = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = (NarutoShippudenModVariables.get(entity).mangekyousharingansasukesusanorelease + 1);
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.mangekyousharingansasukesusanorelease = _setval;
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
				} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansasukesusanorelease == 1) {
					if (NarutoShippudenModVariables.get(entity).jp >= 20) {
						{
							double _setval = 2;
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.mangekyousharingansasukesusanolearn = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = (NarutoShippudenModVariables.get(entity).jp - 20);
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.jp = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = (NarutoShippudenModVariables.get(entity).mangekyousharingansasukesusanorelease + 1);
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.mangekyousharingansasukesusanorelease = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("-20 JP"), (false));
						}
					} else if (NarutoShippudenModVariables.get(entity).jp <= 19) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough JP"), (false));
						}
					}
				} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansasukesusanorelease == 2) {
					if (NarutoShippudenModVariables.get(entity).jp >= 30) {
						{
							double _setval = 3;
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.mangekyousharingansasukesusanolearn = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = (NarutoShippudenModVariables.get(entity).jp - 30);
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.jp = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = (NarutoShippudenModVariables.get(entity).mangekyousharingansasukesusanorelease + 1);
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.mangekyousharingansasukesusanorelease = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("-30 JP"), (false));
						}
					} else if (NarutoShippudenModVariables.get(entity).jp <= 29) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough JP"), (false));
						}
					}
				} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansasukesusanorelease == 3) {
					if (NarutoShippudenModVariables.get(entity).jp >= 40) {
						{
							double _setval = 4;
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.mangekyousharingansasukesusanolearn = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = (NarutoShippudenModVariables.get(entity).jp - 40);
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.jp = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = (NarutoShippudenModVariables.get(entity).mangekyousharingansasukesusanorelease + 1);
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.mangekyousharingansasukesusanorelease = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("-40 JP"), (false));
						}
					} else if (NarutoShippudenModVariables.get(entity).jp <= 39) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough JP"), (false));
						}
					}
				}
			}
		} else if (entity.isSneaking()) {
			if (NarutoShippudenModVariables.get(entity).MangekyouSharinganRelease == 0) {
				{
					double _setval = 1;
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.MangekyouSharinganRelease = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Selected: Susano"), (true));
				}
			} else if (NarutoShippudenModVariables.get(entity).MangekyouSharinganRelease == 1) {
				{
					double _setval = 0;
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.MangekyouSharinganRelease = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Selected: Amaterasu"), (true));
				}
			}
		}
	}
}
