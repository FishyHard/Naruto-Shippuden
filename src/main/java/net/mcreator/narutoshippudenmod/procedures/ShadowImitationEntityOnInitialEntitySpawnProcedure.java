package net.mcreator.narutoshippudenmod.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.narutoshippudenmod.NarutoShippudenMod;

import java.util.function.Function;
import java.util.Map;
import java.util.Comparator;

public class ShadowImitationEntityOnInitialEntitySpawnProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure ShadowImitationEntityOnInitialEntitySpawn!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure ShadowImitationEntityOnInitialEntitySpawn!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		Entity entity = (Entity) dependencies.get("entity");
		if (((Entity) world
				.getEntitiesWithinAABB(PlayerEntity.class,
						new AxisAlignedBB((entity.getPosX()) - (40 / 2d), (entity.getPosY()) - (40 / 2d), (entity.getPosZ()) - (40 / 2d),
								(entity.getPosX()) + (40 / 2d), (entity.getPosY()) + (40 / 2d), (entity.getPosZ()) + (40 / 2d)),
						null)
				.stream().sorted(new Object() {
					Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
						return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
					}
				}.compareDistOf((entity.getPosX()), (entity.getPosY()), (entity.getPosZ()))).findFirst().orElse(null)) != null) {
			if ((entity instanceof TameableEntity) && (((Entity) world
					.getEntitiesWithinAABB(PlayerEntity.class,
							new AxisAlignedBB((entity.getPosX()) - (40 / 2d), (entity.getPosY()) - (40 / 2d), (entity.getPosZ()) - (40 / 2d),
									(entity.getPosX()) + (40 / 2d), (entity.getPosY()) + (40 / 2d), (entity.getPosZ()) + (40 / 2d)),
							null)
					.stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
						}
					}.compareDistOf((entity.getPosX()), (entity.getPosY()), (entity.getPosZ()))).findFirst().orElse(null)) instanceof PlayerEntity)) {
				((TameableEntity) entity).setTamed(true);
				((TameableEntity) entity).setTamedBy((PlayerEntity) ((Entity) world
						.getEntitiesWithinAABB(PlayerEntity.class,
								new AxisAlignedBB((entity.getPosX()) - (40 / 2d), (entity.getPosY()) - (40 / 2d), (entity.getPosZ()) - (40 / 2d),
										(entity.getPosX()) + (40 / 2d), (entity.getPosY()) + (40 / 2d), (entity.getPosZ()) + (40 / 2d)),
								null)
						.stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
							}
						}.compareDistOf((entity.getPosX()), (entity.getPosY()), (entity.getPosZ()))).findFirst().orElse(null)));
			}
		}
		if (((Entity) world
				.getEntitiesWithinAABB(LivingEntity.class,
						new AxisAlignedBB((entity.getPosX()) - (10 / 2d), (entity.getPosY()) - (10 / 2d), (entity.getPosZ()) - (10 / 2d),
								(entity.getPosX()) + (10 / 2d), (entity.getPosY()) + (10 / 2d), (entity.getPosZ()) + (10 / 2d)),
						null)
				.stream().sorted(new Object() {
					Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
						return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
					}
				}.compareDistOf((entity.getPosX()), (entity.getPosY()), (entity.getPosZ()))).findFirst().orElse(null)) != null) {
			entity.startRiding(((Entity) world
					.getEntitiesWithinAABB(LivingEntity.class,
							new AxisAlignedBB((entity.getPosX()) - (10 / 2d), (entity.getPosY()) - (10 / 2d), (entity.getPosZ()) - (10 / 2d),
									(entity.getPosX()) + (10 / 2d), (entity.getPosY()) + (10 / 2d), (entity.getPosZ()) + (10 / 2d)),
							null)
					.stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
						}
					}.compareDistOf((entity.getPosX()), (entity.getPosY()), (entity.getPosZ()))).findFirst().orElse(null)));
		}
	}
}
