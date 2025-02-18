package net.mcreator.narutoshippudenmod.procedures;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables;
import net.mcreator.narutoshippudenmod.NarutoShippudenMod;

import java.util.Map;

public class HiramekareiToolInHandTickProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure HiramekareiToolInHandTick!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency itemstack for procedure HiramekareiToolInHandTick!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		if (itemstack.getOrCreateTag().getBoolean("ChakraStoring") == true) {
			if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount >= 1) {
				if (!(itemstack.getOrCreateTag().getDouble("Chakra") >= 3000)) {
					{
						double _setval = ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount - 1);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.ChakraAmount = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					itemstack.getOrCreateTag().putDouble("Chakra", (itemstack.getOrCreateTag().getDouble("Chakra") + 1));
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(
								new StringTextComponent(("Chakra Storing: " + Math.round(itemstack.getOrCreateTag().getDouble("Chakra")))), (true));
					}
				}
			}
		}
		if (itemstack.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem()
				|| itemstack.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
						.getItem()) {
			if (itemstack.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
					.getItem()) {
				if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).kenjutsu <= 44) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Kenjutsu"), (true));
					}
					if (entity instanceof PlayerEntity) {
						PlayerEntity _player_ = (PlayerEntity) entity;
						if (!_player_.getHeldItemMainhand().isEmpty() && _player_.getHeldItemMainhand().getCount() > 0) {
							_player_.dropItem(new ItemStack(_player_.getHeldItemMainhand().getItem(), 1), false, false);
							_player_.getHeldItemMainhand().shrink(1);
						}
					}
				}
			} else if (itemstack.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
					.getItem()) {
				if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).kenjutsu <= 44) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Kenjutsu"), (true));
					}
					if (entity instanceof PlayerEntity) {
						PlayerEntity _player_ = (PlayerEntity) entity;
						if (!_player_.getHeldItemOffhand().isEmpty() && _player_.getHeldItemOffhand().getCount() > 0) {
							_player_.dropItem(new ItemStack(_player_.getHeldItemOffhand().getItem(), 1), false, false);
							_player_.getHeldItemOffhand().shrink(1);
						}
					}
				}
			}
		}
	}
}
