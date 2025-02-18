package net.mcreator.narutoshippudenmod.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.Entity;

import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables;
import net.mcreator.narutoshippudenmod.NarutoShippudenMod;

import java.util.function.Function;
import java.util.Map;
import java.util.Comparator;

public class FollowAkamaruProcedure {

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure FollowAkamaru!");
			return false;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure FollowAkamaru!");
			return false;
		}
		IWorld world = (IWorld) dependencies.get("world");
		Entity entity = (Entity) dependencies.get("entity");
		if (((Entity) world
				.getEntitiesWithinAABB(PlayerEntity.class,
						new AxisAlignedBB((entity.getPosX()) - (32 / 2d), (entity.getPosY()) - (32 / 2d), (entity.getPosZ()) - (32 / 2d),
								(entity.getPosX()) + (32 / 2d), (entity.getPosY()) + (32 / 2d), (entity.getPosZ()) + (32 / 2d)),
						null)
				.stream().sorted(new Object() {
					Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
						return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
					}
				}.compareDistOf((entity.getPosX()), (entity.getPosY()), (entity.getPosZ()))).findFirst().orElse(null)) != null) {
			if (((entity instanceof TameableEntity)
					? ((TameableEntity) entity).getOwner()
					: null) == ((Entity) world
							.getEntitiesWithinAABB(PlayerEntity.class,
									new AxisAlignedBB((entity.getPosX()) - (32 / 2d), (entity.getPosY()) - (32 / 2d), (entity.getPosZ()) - (32 / 2d),
											(entity.getPosX()) + (32 / 2d), (entity.getPosY()) + (32 / 2d), (entity.getPosZ()) + (32 / 2d)),
									null)
							.stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
								}
							}.compareDistOf((entity.getPosX()), (entity.getPosY()), (entity.getPosZ()))).findFirst().orElse(null))
					&& (((Entity) world
							.getEntitiesWithinAABB(PlayerEntity.class,
									new AxisAlignedBB((entity.getPosX()) - (32 / 2d), (entity.getPosY()) - (32 / 2d), (entity.getPosZ()) - (32 / 2d),
											(entity.getPosX()) + (32 / 2d), (entity.getPosY()) + (32 / 2d), (entity.getPosZ()) + (32 / 2d)),
									null)
							.stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
								}
							}.compareDistOf((entity.getPosX()), (entity.getPosY()), (entity.getPosZ()))).findFirst().orElse(null))
							.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoShippudenModVariables.PlayerVariables())).FollowAkamaru == true) {
				return true;
			}
		}
		return false;
	}
}
