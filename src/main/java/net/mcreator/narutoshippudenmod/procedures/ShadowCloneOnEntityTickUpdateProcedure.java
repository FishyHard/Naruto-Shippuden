package net.mcreator.narutoshippudenmod.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.Hand;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.narutoshippudenmod.NarutoShippudenMod;

import java.util.stream.Collectors;
import java.util.function.Function;
import java.util.Map;
import java.util.List;
import java.util.Comparator;

public class ShadowCloneOnEntityTickUpdateProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure ShadowCloneOnEntityTickUpdate!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency x for procedure ShadowCloneOnEntityTickUpdate!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency y for procedure ShadowCloneOnEntityTickUpdate!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency z for procedure ShadowCloneOnEntityTickUpdate!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure ShadowCloneOnEntityTickUpdate!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		Entity playerowner = null;
		playerowner = (entity instanceof TameableEntity) ? ((TameableEntity) entity).getOwner() : null;
		{
			List<Entity> _entfound = world
					.getEntitiesWithinAABB(Entity.class,
							new AxisAlignedBB(x - (15 / 2d), y - (15 / 2d), z - (15 / 2d), x + (15 / 2d), y + (15 / 2d), z + (15 / 2d)), null)
					.stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
						}
					}.compareDistOf(x, y, z)).collect(Collectors.toList());
			for (Entity entityiterator : _entfound) {
				if (entityiterator instanceof PlayerEntity) {
					if (playerowner == entityiterator) {
						if (entity instanceof LivingEntity) {
							if (entity instanceof PlayerEntity)
								((PlayerEntity) entity).inventory.armorInventory.set((int) 0,
										((playerowner instanceof LivingEntity)
												? ((LivingEntity) playerowner).getItemStackFromSlot(EquipmentSlotType.FEET)
												: ItemStack.EMPTY));
							else
								((LivingEntity) entity).setItemStackToSlot(EquipmentSlotType.FEET,
										((playerowner instanceof LivingEntity)
												? ((LivingEntity) playerowner).getItemStackFromSlot(EquipmentSlotType.FEET)
												: ItemStack.EMPTY));
							if (entity instanceof ServerPlayerEntity)
								((ServerPlayerEntity) entity).inventory.markDirty();
						}
						if (entity instanceof LivingEntity) {
							if (entity instanceof PlayerEntity)
								((PlayerEntity) entity).inventory.armorInventory.set((int) 1,
										((playerowner instanceof LivingEntity)
												? ((LivingEntity) playerowner).getItemStackFromSlot(EquipmentSlotType.LEGS)
												: ItemStack.EMPTY));
							else
								((LivingEntity) entity).setItemStackToSlot(EquipmentSlotType.LEGS,
										((playerowner instanceof LivingEntity)
												? ((LivingEntity) playerowner).getItemStackFromSlot(EquipmentSlotType.LEGS)
												: ItemStack.EMPTY));
							if (entity instanceof ServerPlayerEntity)
								((ServerPlayerEntity) entity).inventory.markDirty();
						}
						if (entity instanceof LivingEntity) {
							if (entity instanceof PlayerEntity)
								((PlayerEntity) entity).inventory.armorInventory.set((int) 2,
										((playerowner instanceof LivingEntity)
												? ((LivingEntity) playerowner).getItemStackFromSlot(EquipmentSlotType.CHEST)
												: ItemStack.EMPTY));
							else
								((LivingEntity) entity).setItemStackToSlot(EquipmentSlotType.CHEST,
										((playerowner instanceof LivingEntity)
												? ((LivingEntity) playerowner).getItemStackFromSlot(EquipmentSlotType.CHEST)
												: ItemStack.EMPTY));
							if (entity instanceof ServerPlayerEntity)
								((ServerPlayerEntity) entity).inventory.markDirty();
						}
						if (entity instanceof LivingEntity) {
							if (entity instanceof PlayerEntity)
								((PlayerEntity) entity).inventory.armorInventory.set((int) 3,
										((playerowner instanceof LivingEntity)
												? ((LivingEntity) playerowner).getItemStackFromSlot(EquipmentSlotType.HEAD)
												: ItemStack.EMPTY));
							else
								((LivingEntity) entity).setItemStackToSlot(EquipmentSlotType.HEAD,
										((playerowner instanceof LivingEntity)
												? ((LivingEntity) playerowner).getItemStackFromSlot(EquipmentSlotType.HEAD)
												: ItemStack.EMPTY));
							if (entity instanceof ServerPlayerEntity)
								((ServerPlayerEntity) entity).inventory.markDirty();
						}
						if (entity instanceof LivingEntity) {
							ItemStack _setstack = ((playerowner instanceof LivingEntity)
									? ((LivingEntity) playerowner).getHeldItemMainhand()
									: ItemStack.EMPTY);
							_setstack.setCount((int) ((((playerowner instanceof LivingEntity)
									? ((LivingEntity) playerowner).getHeldItemMainhand()
									: ItemStack.EMPTY)).getCount()));
							((LivingEntity) entity).setHeldItem(Hand.MAIN_HAND, _setstack);
							if (entity instanceof ServerPlayerEntity)
								((ServerPlayerEntity) entity).inventory.markDirty();
						}
						if (entity instanceof LivingEntity) {
							ItemStack _setstack = ((playerowner instanceof LivingEntity)
									? ((LivingEntity) playerowner).getHeldItemOffhand()
									: ItemStack.EMPTY);
							_setstack.setCount((int) ((((playerowner instanceof LivingEntity)
									? ((LivingEntity) playerowner).getHeldItemOffhand()
									: ItemStack.EMPTY)).getCount()));
							((LivingEntity) entity).setHeldItem(Hand.OFF_HAND, _setstack);
							if (entity instanceof ServerPlayerEntity)
								((ServerPlayerEntity) entity).inventory.markDirty();
						}
					}
				}
			}
		}
	}
}
