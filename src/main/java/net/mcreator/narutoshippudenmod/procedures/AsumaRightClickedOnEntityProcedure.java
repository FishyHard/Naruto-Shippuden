package net.mcreator.narutoshippudenmod.procedures;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.Entity;

import net.mcreator.narutoshippudenmod.item.WadOfRyoItem;
import net.mcreator.narutoshippudenmod.item.ChakraBladeItem;
import net.mcreator.narutoshippudenmod.item.BanknoteOfRyoItem;
import net.mcreator.narutoshippudenmod.item.AsumaQuestCItem;
import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables;
import net.mcreator.narutoshippudenmod.NarutoShippudenMod;

import java.util.Map;

public class AsumaRightClickedOnEntityProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure AsumaRightClickedOnEntity!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency x for procedure AsumaRightClickedOnEntity!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency y for procedure AsumaRightClickedOnEntity!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency z for procedure AsumaRightClickedOnEntity!");
			return;
		}
		if (dependencies.get("sourceentity") == null) {
			if (!dependencies.containsKey("sourceentity"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency sourceentity for procedure AsumaRightClickedOnEntity!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		if ((sourceentity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).asumaquest == false) {
			if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
				((PlayerEntity) sourceentity).sendStatusMessage(new StringTextComponent("Asuma: Bring me Chakra Blade from Weaponsmith Villager."),
						(false));
			}
			if (world instanceof World && !world.isRemote()) {
				ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(AsumaQuestCItem.block));
				entityToSpawn.setPickupDelay((int) 10);
				world.addEntity(entityToSpawn);
			}
			{
				boolean _setval = (true);
				sourceentity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.asumaquest = _setval;
					capability.syncPlayerVariables(sourceentity);
				});
			}
		} else if ((sourceentity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).asumaquest == true) {
			if (((sourceentity instanceof PlayerEntity)
					? ((PlayerEntity) sourceentity).inventory.hasItemStack(new ItemStack(ChakraBladeItem.block))
					: false)
					&& ((sourceentity instanceof PlayerEntity)
							? ((PlayerEntity) sourceentity).inventory.hasItemStack(new ItemStack(ChakraBladeItem.block))
							: false)) {
				if ((sourceentity instanceof PlayerEntity)
						? ((PlayerEntity) sourceentity).inventory.hasItemStack(new ItemStack(AsumaQuestCItem.block))
						: false) {
					if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
						((PlayerEntity) sourceentity).sendStatusMessage(new StringTextComponent("Asuma: Thank you for bringing me my chakra blades!"),
								(false));
					}
					if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
						((PlayerEntity) sourceentity).sendStatusMessage(new StringTextComponent("Asuma: Here is your reward."), (false));
					}
					if (sourceentity instanceof PlayerEntity) {
						ItemStack _stktoremove = new ItemStack(AsumaQuestCItem.block);
						((PlayerEntity) sourceentity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
								((PlayerEntity) sourceentity).container.func_234641_j_());
					}
					if (sourceentity instanceof PlayerEntity) {
						ItemStack _stktoremove = new ItemStack(ChakraBladeItem.block);
						((PlayerEntity) sourceentity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 2,
								((PlayerEntity) sourceentity).container.func_234641_j_());
					}
					if (sourceentity instanceof PlayerEntity) {
						ItemStack _setstack = new ItemStack(WadOfRyoItem.block);
						_setstack.setCount((int) 2);
						ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) sourceentity), _setstack);
					}
					if (sourceentity instanceof PlayerEntity) {
						ItemStack _setstack = new ItemStack(BanknoteOfRyoItem.block);
						_setstack.setCount((int) 10);
						ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) sourceentity), _setstack);
					}
					{
						double _setval = ((sourceentity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NarutoShippudenModVariables.PlayerVariables())).C_Mission + 1);
						sourceentity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.C_Mission = _setval;
							capability.syncPlayerVariables(sourceentity);
						});
					}
					{
						boolean _setval = (false);
						sourceentity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.asumaquest = _setval;
							capability.syncPlayerVariables(sourceentity);
						});
					}
				} else if (!((sourceentity instanceof PlayerEntity)
						? ((PlayerEntity) sourceentity).inventory.hasItemStack(new ItemStack(AsumaQuestCItem.block))
						: false)) {
					if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
						((PlayerEntity) sourceentity).sendStatusMessage(
								new StringTextComponent("Asuma: I think you forgot your Mission Document take it and get back."), (false));
					}
				}
			} else if (!(((sourceentity instanceof PlayerEntity)
					? ((PlayerEntity) sourceentity).inventory.hasItemStack(new ItemStack(ChakraBladeItem.block))
					: false)
					&& ((sourceentity instanceof PlayerEntity)
							? ((PlayerEntity) sourceentity).inventory.hasItemStack(new ItemStack(ChakraBladeItem.block))
							: false))) {
				if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
					((PlayerEntity) sourceentity)
							.sendStatusMessage(new StringTextComponent("Asuma: Bring me Chakra Blade from Weaponsmith Villager."), (false));
				}
			}
		}
	}
}
