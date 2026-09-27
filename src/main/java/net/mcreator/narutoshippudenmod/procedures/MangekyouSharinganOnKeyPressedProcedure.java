package net.mcreator.narutoshippudenmod.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables;
import net.mcreator.narutoshippudenmod.NarutoShippudenMod;

import java.util.Map;

public class MangekyouSharinganOnKeyPressedProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure MangekyouSharinganOnKeyPressed!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency x for procedure MangekyouSharinganOnKeyPressed!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency y for procedure MangekyouSharinganOnKeyPressed!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency z for procedure MangekyouSharinganOnKeyPressed!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure MangekyouSharinganOnKeyPressed!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		if (NarutoShippudenModVariables.get(entity).MangekyouSharinganSasuke == true
				|| NarutoShippudenModVariables.get(entity).MangekyouSharinganItachi == true
				|| NarutoShippudenModVariables.get(entity).MangekyouSharinganMadara == true
				|| NarutoShippudenModVariables.get(entity).MangekyouSharinganObito == true
				|| NarutoShippudenModVariables.get(entity).MangekyouSharinganShisui == true
				|| NarutoShippudenModVariables.get(entity).MangekyouSharinganKakashi == true) {
			if (NarutoShippudenModVariables.get(entity).MangekyouSharinganActivate == false) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u00A7cMangekyou Sharingan!"), (false));
				}
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.STRENGTH, (int) 999999, (int) 1, (false), (false)));
				{
					boolean _setval = (true);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.MangekyouSharinganActivate = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (world instanceof World && !world.isRemote()) {
					((World) world).playSound(null, new BlockPos(x, y, z),
							(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
									.getValue(new ResourceLocation("naruto_shippuden:mangekyou_sharingan")),
							SoundCategory.NEUTRAL, (float) 1, (float) 1);
				} else {
					((World) world).playSound(x, y, z,
							(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
									.getValue(new ResourceLocation("naruto_shippuden:mangekyou_sharingan")),
							SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
				}
			} else if (NarutoShippudenModVariables.get(entity).MangekyouSharinganActivate == true) {
				if (entity instanceof LivingEntity) {
					((LivingEntity) entity).removePotionEffect(Effects.STRENGTH);
				}
				{
					boolean _setval = (false);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.MangekyouSharinganActivate = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		} else if (NarutoShippudenModVariables.get(entity).MangekyouSharinganSasuke == false
				|| NarutoShippudenModVariables.get(entity).MangekyouSharinganItachi == false
				|| NarutoShippudenModVariables.get(entity).MangekyouSharinganMadara == false
				|| NarutoShippudenModVariables.get(entity).MangekyouSharinganObito == false
				|| NarutoShippudenModVariables.get(entity).MangekyouSharinganShisui == false
				|| NarutoShippudenModVariables.get(entity).MangekyouSharinganKakashi == false) {
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked Mangekyou Sharingan"), (false));
			}
		}
	}
}
