package net.mcreator.narutoshippudenmod.procedures;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.narutoshippudenmod.item.GeninSunagakureRedItem;
import net.mcreator.narutoshippudenmod.item.GeninSunagakureItem;
import net.mcreator.narutoshippudenmod.item.GeninSunagakureBlackItem;
import net.mcreator.narutoshippudenmod.item.GeninKumogakureRedItem;
import net.mcreator.narutoshippudenmod.item.GeninKumogakureItem;
import net.mcreator.narutoshippudenmod.item.GeninKumogakureBlackItem;
import net.mcreator.narutoshippudenmod.item.GeninKonohagakureRedItem;
import net.mcreator.narutoshippudenmod.item.GeninKonohagakureItem;
import net.mcreator.narutoshippudenmod.item.GeninKonohagakureBlackItem;
import net.mcreator.narutoshippudenmod.item.GeninKirigakureRedItem;
import net.mcreator.narutoshippudenmod.item.GeninKirigakureItem;
import net.mcreator.narutoshippudenmod.item.GeninKirigakureBlackItem;
import net.mcreator.narutoshippudenmod.item.GeninIwagakureRedItem;
import net.mcreator.narutoshippudenmod.item.GeninIwagakureItem;
import net.mcreator.narutoshippudenmod.item.GeninIwagakureBlackItem;
import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables;
import net.mcreator.narutoshippudenmod.NarutoShippudenMod;

import java.util.Map;

public class HeadbandSelectProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure HeadbandSelect!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).HeadbandSelect == 0) {
			if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).village).equals("Hidden Leaf")) {
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(GeninKonohagakureItem.helmet);
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
			} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).village).equals("Hidden Stone")) {
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(GeninIwagakureItem.helmet);
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
			} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).village).equals("Hidden Mist")) {
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(GeninKirigakureItem.helmet);
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
			} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).village).equals("Hidden Sand")) {
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(GeninSunagakureItem.helmet);
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
			} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).village).equals("Hidden Cloud")) {
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(GeninKumogakureItem.helmet);
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
			}
		} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).HeadbandSelect == 1) {
			if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).village).equals("Hidden Leaf")) {
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(GeninKonohagakureBlackItem.helmet);
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
			} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).village).equals("Hidden Stone")) {
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(GeninIwagakureBlackItem.helmet);
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
			} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).village).equals("Hidden Mist")) {
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(GeninKirigakureBlackItem.helmet);
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
			} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).village).equals("Hidden Sand")) {
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(GeninSunagakureBlackItem.helmet);
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
			} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).village).equals("Hidden Cloud")) {
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(GeninKumogakureBlackItem.helmet);
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
			}
		} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).HeadbandSelect == 2) {
			if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).village).equals("Hidden Leaf")) {
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(GeninKonohagakureRedItem.helmet);
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
			} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).village).equals("Hidden Stone")) {
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(GeninIwagakureRedItem.helmet);
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
			} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).village).equals("Hidden Mist")) {
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(GeninKirigakureRedItem.helmet);
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
			} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).village).equals("Hidden Sand")) {
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(GeninSunagakureRedItem.helmet);
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
			} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).village).equals("Hidden Cloud")) {
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(GeninKumogakureRedItem.helmet);
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
			}
		}
		{
			String _setval = "Genin";
			entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.rank = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			double _setval = 22;
			entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.storymode = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		if (entity instanceof PlayerEntity)
			((PlayerEntity) entity).closeScreen();
	}
}
