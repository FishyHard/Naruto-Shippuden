package net.mcreator.narutoshippudenmod.procedures;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.narutoshippudenmod.item.ChakraBladeItem;
import net.mcreator.narutoshippudenmod.NarutoShippudenMod;

import java.util.Map;

public class ChakraBladeRightclickedProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure ChakraBladeRightclicked!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency itemstack for procedure ChakraBladeRightclicked!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem() == itemstack.getItem()
				&& ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
						.getItem() == ChakraBladeItem.block) {
			if (itemstack.getOrCreateTag().getBoolean("FlyingSwallow") == true) {
				itemstack.getOrCreateTag().putBoolean("FlyingSwallow", (false));
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Flying Swallow: Off"), (true));
				}
			} else if (itemstack.getOrCreateTag().getBoolean("FlyingSwallow") == false) {
				itemstack.getOrCreateTag().putBoolean("FlyingSwallow", (true));
				itemstack.getOrCreateTag().putDouble("FlyingSwallowSharp", 0);
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Flying Swallow: On"), (true));
				}
			}
		} else {
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Take Second Chakra Blade In Your Left Hand"), (true));
			}
		}
	}
}
