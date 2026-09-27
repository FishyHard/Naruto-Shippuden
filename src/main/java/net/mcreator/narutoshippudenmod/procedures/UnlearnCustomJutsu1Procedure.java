package net.mcreator.narutoshippudenmod.procedures;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.narutoshippudenmod.item.CustomWindReleaseTechniqueItem;
import net.mcreator.narutoshippudenmod.item.CustomWaterReleaseTechniqueItem;
import net.mcreator.narutoshippudenmod.item.CustomLightningReleaseTechniqueItem;
import net.mcreator.narutoshippudenmod.item.CustomFireReleaseTechniqueItem;
import net.mcreator.narutoshippudenmod.item.CustomEarthReleaseTechniqueItem;
import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables;
import net.mcreator.narutoshippudenmod.NarutoShippudenMod;

import java.util.Map;

public class UnlearnCustomJutsu1Procedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure UnlearnCustomJutsu1!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (((entity instanceof PlayerEntity)
				? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(CustomLightningReleaseTechniqueItem.block))
				: false)
				|| ((entity instanceof PlayerEntity)
						? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(CustomWindReleaseTechniqueItem.block))
						: false)
				|| ((entity instanceof PlayerEntity)
						? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(CustomWaterReleaseTechniqueItem.block))
						: false)
				|| ((entity instanceof PlayerEntity)
						? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(CustomEarthReleaseTechniqueItem.block))
						: false)
				|| ((entity instanceof PlayerEntity)
						? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(CustomFireReleaseTechniqueItem.block))
						: false)) {
			if (NarutoShippudenModVariables.get(entity).customjutsujpcost == 10) {
				{
					double _setval = (NarutoShippudenModVariables.get(entity).jp + 5);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.jp = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (NarutoShippudenModVariables.get(entity).customjutsujpcost == 15) {
				{
					double _setval = (NarutoShippudenModVariables.get(entity).jp + 8);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.jp = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (NarutoShippudenModVariables.get(entity).customjutsujpcost == 20) {
				{
					double _setval = (NarutoShippudenModVariables.get(entity).jp + 10);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.jp = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (NarutoShippudenModVariables.get(entity).customjutsujpcost == 25) {
				{
					double _setval = (NarutoShippudenModVariables.get(entity).jp + 13);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.jp = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (NarutoShippudenModVariables.get(entity).customjutsujpcost == 30) {
				{
					double _setval = (NarutoShippudenModVariables.get(entity).jp + 15);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.jp = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (NarutoShippudenModVariables.get(entity).customjutsujpcost == 35) {
				{
					double _setval = (NarutoShippudenModVariables.get(entity).jp + 18);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.jp = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (NarutoShippudenModVariables.get(entity).customjutsujpcost == 40) {
				{
					double _setval = (NarutoShippudenModVariables.get(entity).jp + 20);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.jp = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (NarutoShippudenModVariables.get(entity).customjutsujpcost == 45) {
				{
					double _setval = (NarutoShippudenModVariables.get(entity).jp + 23);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.jp = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (NarutoShippudenModVariables.get(entity).customjutsujpcost == 50) {
				{
					double _setval = (NarutoShippudenModVariables.get(entity).jp + 25);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.jp = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (NarutoShippudenModVariables.get(entity).customjutsujpcost == 55) {
				{
					double _setval = (NarutoShippudenModVariables.get(entity).jp + 28);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.jp = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (NarutoShippudenModVariables.get(entity).customjutsujpcost == 60) {
				{
					double _setval = (NarutoShippudenModVariables.get(entity).jp + 30);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.jp = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (NarutoShippudenModVariables.get(entity).customjutsujpcost == 65) {
				{
					double _setval = (NarutoShippudenModVariables.get(entity).jp + 33);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.jp = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			{
				boolean _setval = (false);
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.customjutsu1learn = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof PlayerEntity)
				((PlayerEntity) entity).closeScreen();
			if (entity instanceof PlayerEntity) {
				ItemStack _stktoremove = new ItemStack(CustomFireReleaseTechniqueItem.block);
				((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
						((PlayerEntity) entity).container.func_234641_j_());
			}
			if (entity instanceof PlayerEntity) {
				ItemStack _stktoremove = new ItemStack(CustomLightningReleaseTechniqueItem.block);
				((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
						((PlayerEntity) entity).container.func_234641_j_());
			}
			if (entity instanceof PlayerEntity) {
				ItemStack _stktoremove = new ItemStack(CustomWindReleaseTechniqueItem.block);
				((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
						((PlayerEntity) entity).container.func_234641_j_());
			}
			if (entity instanceof PlayerEntity) {
				ItemStack _stktoremove = new ItemStack(CustomWaterReleaseTechniqueItem.block);
				((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
						((PlayerEntity) entity).container.func_234641_j_());
			}
			if (entity instanceof PlayerEntity) {
				ItemStack _stktoremove = new ItemStack(CustomEarthReleaseTechniqueItem.block);
				((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
						((PlayerEntity) entity).container.func_234641_j_());
			}
		} else if (!((entity instanceof PlayerEntity)
				? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(CustomLightningReleaseTechniqueItem.block))
				: false)
				|| !((entity instanceof PlayerEntity)
						? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(CustomWindReleaseTechniqueItem.block))
						: false)
				|| !((entity instanceof PlayerEntity)
						? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(CustomWaterReleaseTechniqueItem.block))
						: false)
				|| !((entity instanceof PlayerEntity)
						? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(CustomEarthReleaseTechniqueItem.block))
						: false)
				|| !((entity instanceof PlayerEntity)
						? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(CustomFireReleaseTechniqueItem.block))
						: false)) {
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Take your custom jutsu in inventory"), (false));
			}
		}
	}
}
