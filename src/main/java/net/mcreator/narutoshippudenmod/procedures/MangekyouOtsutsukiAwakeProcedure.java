package net.mcreator.narutoshippudenmod.procedures;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.MathHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.narutoshippudenmod.item.MangekyouSharinganShisuiReleaseItem;
import net.mcreator.narutoshippudenmod.item.MangekyouSharinganSasukeReleaseItem;
import net.mcreator.narutoshippudenmod.item.MangekyouSharinganObitoReleaseItem;
import net.mcreator.narutoshippudenmod.item.MangekyouSharinganMadaraReleaseItem;
import net.mcreator.narutoshippudenmod.item.MangekyouSharinganItachiReleaseItem;
import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables;
import net.mcreator.narutoshippudenmod.NarutoShippudenMod;

import java.util.Random;
import java.util.Map;

public class MangekyouOtsutsukiAwakeProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure MangekyouOtsutsukiAwake!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double random = 0;
		random = (MathHelper.nextInt(new Random(), 1, 5));
		if (random == 1) {
			if (entity instanceof PlayerEntity) {
				ItemStack _setstack = new ItemStack(MangekyouSharinganSasukeReleaseItem.block);
				_setstack.setCount((int) 1);
				ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
			}
			{
				boolean _setval = (true);
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.MangekyouSharinganSasuke = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if (random == 2) {
			if (entity instanceof PlayerEntity) {
				ItemStack _setstack = new ItemStack(MangekyouSharinganMadaraReleaseItem.block);
				_setstack.setCount((int) 1);
				ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
			}
			{
				boolean _setval = (true);
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.MangekyouSharinganMadara = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if (random == 3) {
			if (entity instanceof PlayerEntity) {
				ItemStack _setstack = new ItemStack(MangekyouSharinganItachiReleaseItem.block);
				_setstack.setCount((int) 1);
				ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
			}
			{
				boolean _setval = (true);
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.MangekyouSharinganItachi = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if (random == 4) {
			if (entity instanceof PlayerEntity) {
				ItemStack _setstack = new ItemStack(MangekyouSharinganShisuiReleaseItem.block);
				_setstack.setCount((int) 1);
				ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
			}
			{
				boolean _setval = (true);
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.MangekyouSharinganShisui = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if (random == 5) {
			if (entity instanceof PlayerEntity) {
				ItemStack _setstack = new ItemStack(MangekyouSharinganObitoReleaseItem.block);
				_setstack.setCount((int) 1);
				ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
			}
			{
				boolean _setval = (true);
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.MangekyouSharinganObito = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		{
			String _setval = "1x1";
			entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.dojutsums = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			boolean _setval = (true);
			entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.otsutsuki_mangekyou = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			boolean _setval = (true);
			entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.Mangekyou_Sharingan = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
			((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You've awakened Mangekyou Sharingan!"), (false));
		}
	}
}
