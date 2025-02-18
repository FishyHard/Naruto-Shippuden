package net.mcreator.narutoshippudenmod.procedures;

import net.minecraft.util.math.MathHelper;
import net.minecraft.entity.Entity;

import net.mcreator.narutoshippudenmod.entity.HiddenStoneShinobiEntity;
import net.mcreator.narutoshippudenmod.entity.HiddenSandShinobiEntity;
import net.mcreator.narutoshippudenmod.entity.HiddenMistShinobiEntity;
import net.mcreator.narutoshippudenmod.entity.HiddenLeafShinobiEntity;
import net.mcreator.narutoshippudenmod.entity.HiddenCloudShinobiEntity;
import net.mcreator.narutoshippudenmod.entity.AsumaEntity;
import net.mcreator.narutoshippudenmod.NarutoShippudenMod;

import java.util.Random;
import java.util.Map;

public class NarutoShippudenEntityChakraProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure NarutoShippudenEntityChakra!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double randomchakra = 0;
		if (entity instanceof HiddenCloudShinobiEntity.CustomEntity || entity instanceof HiddenLeafShinobiEntity.CustomEntity
				|| entity instanceof HiddenMistShinobiEntity.CustomEntity || entity instanceof HiddenSandShinobiEntity.CustomEntity
				|| entity instanceof HiddenStoneShinobiEntity.CustomEntity) {
			randomchakra = (MathHelper.nextInt(new Random(), 1, 25));
			entity.getPersistentData().putDouble("ChakraAmount", (1000 + randomchakra * 100));
			entity.getPersistentData().putDouble("ChakraMax", (1000 + randomchakra * 100));
		} else if (entity instanceof AsumaEntity.CustomEntity) {
			randomchakra = (MathHelper.nextInt(new Random(), 1, 20));
			entity.getPersistentData().putDouble("ChakraAmount", (2500 + randomchakra * 100));
			entity.getPersistentData().putDouble("ChakraMax", (2500 + randomchakra * 100));
			{
				Entity _ent = entity;
				if (!_ent.world.isRemote && _ent.world.getServer() != null) {
					_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
							"/data merge entity @s {HandItems:[{},{},{id:\"minecraft:egg\",Count:1b},{}],HandDropChances:[0.000F,0.000F,0.000F,0.000F]}");
				}
			}
		}
	}
}
