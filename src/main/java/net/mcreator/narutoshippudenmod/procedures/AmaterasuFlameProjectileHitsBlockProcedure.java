package net.mcreator.narutoshippudenmod.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;

import net.mcreator.narutoshippudenmod.block.AmaterasuBlock;
import net.mcreator.narutoshippudenmod.NarutoShippudenMod;

import java.util.Map;

public class AmaterasuFlameProjectileHitsBlockProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure AmaterasuFlameProjectileHitsBlock!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency x for procedure AmaterasuFlameProjectileHitsBlock!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency y for procedure AmaterasuFlameProjectileHitsBlock!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency z for procedure AmaterasuFlameProjectileHitsBlock!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		if (world.isAirBlock(new BlockPos(x, y + 1, z))) {
			world.setBlockState(new BlockPos(x, y + 1, z), AmaterasuBlock.block.getDefaultState(), 3);
		} else if (!world.isAirBlock(new BlockPos(x, y + 1, z))) {
			if (!world.getBlockState(new BlockPos(x, y + 1, z)).isSolid()) {
				world.setBlockState(new BlockPos(x, y + 1, z), AmaterasuBlock.block.getDefaultState(), 3);
			}
		}
	}
}
