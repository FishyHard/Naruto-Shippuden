package net.mcreator.narutoshippudenmod.procedures;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.MathHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.narutoshippudenmod.item.StormReleaseItem;
import net.mcreator.narutoshippudenmod.item.StormDNAReleaseItem;
import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables;
import net.mcreator.narutoshippudenmod.NarutoShippudenMod;

import java.util.Random;
import java.util.Map;

public class StormDNAImplantMobProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure StormDNAImplantMob!");
			return;
		}
		if (dependencies.get("sourceentity") == null) {
			if (!dependencies.containsKey("sourceentity"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency sourceentity for procedure StormDNAImplantMob!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		double random = 0;
		if (entity instanceof PlayerEntity) {
			if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).stormreleaselogic == false) {
				random = (MathHelper.nextInt(new Random(), 1, 100));
				if (random <= 50) {
					if (entity instanceof PlayerEntity) {
						ItemStack _setstack = new ItemStack(StormReleaseItem.block);
						_setstack.setCount((int) 1);
						ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
					}
					{
						boolean _setval = (true);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.stormreleaselogic = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
						((PlayerEntity) sourceentity).sendStatusMessage(new StringTextComponent("Storm Release implanted succesfully"), (false));
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Storm Release implanted succesfully"), (false));
					}
				} else if (random >= 51) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Storm Release implanted failed"), (false));
					}
					if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
						((PlayerEntity) sourceentity).sendStatusMessage(new StringTextComponent("Storm Release implanted failed"), (false));
					}
				}
				if (sourceentity instanceof PlayerEntity) {
					ItemStack _stktoremove = new ItemStack(StormDNAReleaseItem.block);
					((PlayerEntity) sourceentity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
							((PlayerEntity) sourceentity).container.func_234641_j_());
				}
			} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).stormreleaselogic == true) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You already have Storm Release"), (false));
				}
			}
		} else if (!(entity instanceof PlayerEntity)) {
			if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
				((PlayerEntity) sourceentity).sendStatusMessage(new StringTextComponent("You can only implant DNA in player"), (false));
			}
		}
	}
}
