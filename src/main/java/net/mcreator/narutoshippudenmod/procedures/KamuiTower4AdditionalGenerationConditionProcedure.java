package net.mcreator.narutoshippudenmod.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;

import net.mcreator.narutoshippudenmod.NarutoShippudenMod;

import java.util.Map;

public class KamuiTower4AdditionalGenerationConditionProcedure {

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure KamuiTower4AdditionalGenerationCondition!");
			return false;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency x for procedure KamuiTower4AdditionalGenerationCondition!");
			return false;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency z for procedure KamuiTower4AdditionalGenerationCondition!");
			return false;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		if (world.isAirBlock(new BlockPos(x, 64, z - 1)) && world.isAirBlock(new BlockPos(x + 1, 64, z - 1))
				&& world.isAirBlock(new BlockPos(x + 2, 64, z - 1)) && world.isAirBlock(new BlockPos(x + 3, 64, z - 1))
				&& world.isAirBlock(new BlockPos(x - 1, 64, z)) && world.isAirBlock(new BlockPos(x - 1, 64, z + 1))
				&& world.isAirBlock(new BlockPos(x - 1, 64, z + 2)) && world.isAirBlock(new BlockPos(x - 1, 64, z + 3))
				&& world.isAirBlock(new BlockPos(x, 64, z + 3)) && world.isAirBlock(new BlockPos(x + 1, 64, z + 3))
				&& world.isAirBlock(new BlockPos(x + 2, 64, z + 3)) && world.isAirBlock(new BlockPos(x + 3, 64, z + 3))
				&& world.isAirBlock(new BlockPos(x + 3, 64, z)) && world.isAirBlock(new BlockPos(x + 3, 64, z + 1))
				&& world.isAirBlock(new BlockPos(x + 3, 64, z + 2)) && world.isAirBlock(new BlockPos(x + 3, 64, z + 3))) {
			return true;
		}
		return false;
	}
}
