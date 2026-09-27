package net.mcreator.narutoshippudenmod.procedures;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.narutoshippudenmod.item.LeeReleaseDrunkenFistItem;
import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables;
import net.mcreator.narutoshippudenmod.NarutoShippudenMod;

import java.util.Map;

public class LeeReleaseDrunkenFistRightclickedProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure LeeReleaseDrunkenFistRightclicked!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (NarutoShippudenModVariables.get(entity).leereleaselogic == true) {
			if (NarutoShippudenModVariables.get(entity).leelearn >= 1) {
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.NAUSEA, (int) 1800, (int) 2, (false), (false)));
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.STRENGTH, (int) 1800, (int) 1, (false), (false)));
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.RESISTANCE, (int) 1800, (int) 1, (false), (false)));
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SPEED, (int) 1800, (int) 0, (false), (false)));
				if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
					if (entity instanceof PlayerEntity)
						((PlayerEntity) entity).getCooldownTracker().setCooldown(LeeReleaseDrunkenFistItem.block, (int) 3000);
				} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
					if (entity instanceof PlayerEntity)
						((PlayerEntity) entity).getCooldownTracker().setCooldown(LeeReleaseDrunkenFistItem.block, (int) 2500);
				} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
					if (entity instanceof PlayerEntity)
						((PlayerEntity) entity).getCooldownTracker().setCooldown(LeeReleaseDrunkenFistItem.block, (int) 2200);
				} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
					if (entity instanceof PlayerEntity)
						((PlayerEntity) entity).getCooldownTracker().setCooldown(LeeReleaseDrunkenFistItem.block, (int) 2000);
				} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
					if (entity instanceof PlayerEntity)
						((PlayerEntity) entity).getCooldownTracker().setCooldown(LeeReleaseDrunkenFistItem.block, (int) 1800);
				}
			} else if (!(NarutoShippudenModVariables.get(entity).leelearn >= 1)) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this technique."), (false));
				}
			}
		} else if (NarutoShippudenModVariables.get(entity).leereleaselogic == false) {
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this release."), (true));
			}
		}
	}
}
