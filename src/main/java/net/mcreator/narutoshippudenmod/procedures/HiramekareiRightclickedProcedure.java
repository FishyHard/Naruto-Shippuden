package net.mcreator.narutoshippudenmod.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Hand;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.narutoshippudenmod.item.HiramekareiSplittedItem;
import net.mcreator.narutoshippudenmod.item.HiramekareiItem;
import net.mcreator.narutoshippudenmod.item.HiramekareiHammerFormItem;
import net.mcreator.narutoshippudenmod.NarutoShippudenMod;

import java.util.stream.Collectors;
import java.util.function.Function;
import java.util.Random;
import java.util.Map;
import java.util.List;
import java.util.Comparator;

public class HiramekareiRightclickedProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure HiramekareiRightclicked!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency x for procedure HiramekareiRightclicked!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency y for procedure HiramekareiRightclicked!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency z for procedure HiramekareiRightclicked!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure HiramekareiRightclicked!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency itemstack for procedure HiramekareiRightclicked!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		double durability = 0;
		double distance = 0;
		boolean reach = false;
		ItemStack copy = ItemStack.EMPTY;
		ItemStack copy2 = ItemStack.EMPTY;
		ItemStack modifier = ItemStack.EMPTY;
		if (!entity.isSneaking()) {
			if (itemstack.getOrCreateTag().getDouble("HiramekareiMode") == 0) {
				if (itemstack.getOrCreateTag().getBoolean("ChakraStoring") == true) {
					itemstack.getOrCreateTag().putBoolean("ChakraStoring", (false));
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Chakra Storing: Off"), (true));
					}
				} else if (itemstack.getOrCreateTag().getBoolean("ChakraStoring") == false) {
					itemstack.getOrCreateTag().putBoolean("ChakraStoring", (true));
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Chakra Storing: On"), (true));
					}
				}
			} else if (itemstack.getOrCreateTag().getDouble("HiramekareiMode") == 1) {
				if (itemstack.getOrCreateTag().getBoolean("HiramekareiSharp") == true) {
					itemstack.getOrCreateTag().putBoolean("HiramekareiSharp", (false));
					itemstack.getOrCreateTag().putDouble("HiramekareiSharp", 0);
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Hiramekarei Sharp: Off"), (true));
					}
				} else if (itemstack.getOrCreateTag().getBoolean("HiramekareiSharp") == false) {
					itemstack.getOrCreateTag().putBoolean("HiramekareiSharp", (true));
					itemstack.getOrCreateTag().putDouble("HiramekareiSharp", 1);
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Hiramekarei Sharp: On"), (true));
					}
				}
			} else if (itemstack.getOrCreateTag().getDouble("HiramekareiMode") == 2) {
				if (itemstack.getOrCreateTag().getBoolean("HiramekareiSharp") == true) {
					itemstack.getOrCreateTag().putBoolean("HiramekareiSharp", (false));
					itemstack.getOrCreateTag().putDouble("HiramekareiSharp", 0);
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Hiramekarei Sharp: Off"), (true));
					}
				} else if (itemstack.getOrCreateTag().getBoolean("HiramekareiSharp") == false) {
					itemstack.getOrCreateTag().putBoolean("HiramekareiSharp", (true));
					itemstack.getOrCreateTag().putDouble("HiramekareiSharp", 1);
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Hiramekarei Sharp: On"), (true));
					}
				}
			} else if (itemstack.getOrCreateTag().getDouble("HiramekareiMode") == 3) {
				if (itemstack.getOrCreateTag().getDouble("Chakra") >= 300) {
					distance = 1;
					for (int index0 = 0; index0 < (int) (4); index0++) {
						if (((Entity) world
								.getEntitiesWithinAABB(LivingEntity.class,
										new AxisAlignedBB(
												(entity.world
														.rayTraceBlocks(
																new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																				entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
														.getPos().getX()) - (5 / 2d),
												y - (5 / 2d),
												(entity.world
														.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																		entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
														.getPos().getZ()) - (5 / 2d),
												(entity.world
														.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																		entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
														.getPos().getX()) + (5 / 2d),
												y + (5 / 2d),
												(entity.world
														.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																		entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
														.getPos().getZ()) + (5 / 2d)),
										null)
								.stream().sorted(new Object() {
									Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
										return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
									}
								}.compareDistOf(
										(entity.world
												.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
														entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
														RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
												.getPos().getX()),
										y,
										(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
												entity.getEyePosition(1f).add(entity.getLook(1f).x * distance, entity.getLook(1f).y * distance,
														entity.getLook(1f).z * distance),
												RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getZ())))
								.findFirst().orElse(null)) != null) {
							{
								List<Entity> _entfound = world
										.getEntitiesWithinAABB(Entity.class,
												new AxisAlignedBB(
														(entity.world
																.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																				entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																.getPos().getX()) - (5 / 2d),
														y - (5 / 2d),
														(entity.world
																.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																				entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																.getPos().getZ()) - (5 / 2d),
														(entity.world
																.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																				entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																.getPos().getX()) + (5 / 2d),
														y + (5 / 2d),
														(entity.world
																.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																				entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																.getPos().getZ()) + (5 / 2d)),
												null)
										.stream().sorted(new Object() {
											Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
												return Comparator
														.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
											}
										}.compareDistOf(
												(entity.world
														.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																		entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
														.getPos().getX()),
												y,
												(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
														entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
														RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getZ())))
										.collect(Collectors.toList());
								for (Entity entityiterator : _entfound) {
									if (!(entity == entityiterator)) {
										reach = (true);
									}
								}
							}
						} else if (!(((Entity) world
								.getEntitiesWithinAABB(LivingEntity.class,
										new AxisAlignedBB(
												(entity.world
														.rayTraceBlocks(
																new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																				entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
														.getPos().getX()) - (5 / 2d),
												y - (5 / 2d),
												(entity.world
														.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																		entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
														.getPos().getZ()) - (5 / 2d),
												(entity.world
														.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																		entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
														.getPos().getX()) + (5 / 2d),
												y + (5 / 2d),
												(entity.world
														.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																		entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
														.getPos().getZ()) + (5 / 2d)),
										null)
								.stream().sorted(new Object() {
									Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
										return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
									}
								}.compareDistOf(
										(entity.world
												.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
														entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
														RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
												.getPos().getX()),
										y,
										(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
												entity.getEyePosition(1f).add(entity.getLook(1f).x * distance, entity.getLook(1f).y * distance,
														entity.getLook(1f).z * distance),
												RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getZ())))
								.findFirst().orElse(null)) != null)) {
							distance = (distance + 1);
						}
					}
					if (reach == true) {
						{
							List<Entity> _entfound = world
									.getEntitiesWithinAABB(Entity.class,
											new AxisAlignedBB(
													(entity.world
															.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																	entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																			entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																	RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
															.getPos().getX()) - (5 / 2d),
													y - (5 / 2d),
													(entity.world
															.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																	entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																			entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																	RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
															.getPos().getZ()) - (5 / 2d),
													(entity.world
															.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																	entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																			entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																	RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
															.getPos().getX()) + (5 / 2d),
													y + (5 / 2d),
													(entity.world
															.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																	entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																			entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																	RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
															.getPos().getZ()) + (5 / 2d)),
											null)
									.stream().sorted(new Object() {
										Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
											return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
										}
									}.compareDistOf(
											(entity.world
													.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
															entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																	entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
															RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
													.getPos().getX()),
											y,
											(entity.world
													.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
															entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																	entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
															RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
													.getPos().getZ())))
									.collect(Collectors.toList());
							for (Entity entityiterator : _entfound) {
								if (!(entity == entityiterator)) {
									entityiterator.setMotion(0, (MathHelper.nextInt(new Random(), 1, 3)), 0);
								}
							}
						}
						if (world instanceof World && !world.isRemote()) {
							((World) world).playSound(null, new BlockPos(x, y, z),
									(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.anvil.land")),
									SoundCategory.NEUTRAL, (float) 1, (float) 1);
						} else {
							((World) world).playSound(x, y, z,
									(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.anvil.land")),
									SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
						}
					}
					if (entity instanceof PlayerEntity)
						((PlayerEntity) entity).getCooldownTracker().setCooldown(itemstack.getItem(), (int) 300);
					itemstack.getOrCreateTag().putDouble("Chakra", (itemstack.getOrCreateTag().getDouble("Chakra") - 300));
				} else if (itemstack.getOrCreateTag().getDouble("Chakra") <= 299) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (true));
					}
				}
			}
		} else if (entity.isSneaking()) {
			if (itemstack.getOrCreateTag().getDouble("HiramekareiMode") == 0) {
				itemstack.getOrCreateTag().putDouble("HiramekareiMode", 1);
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Hiramekarei: Long-sword form"), (true));
				}
				copy = (itemstack.copy());
				copy2 = new ItemStack(HiramekareiItem.block);
				if (entity instanceof LivingEntity) {
					ItemStack _setstack = (copy2);
					_setstack.setCount((int) 1);
					((LivingEntity) entity).setHeldItem(Hand.MAIN_HAND, _setstack);
					if (entity instanceof ServerPlayerEntity)
						((ServerPlayerEntity) entity).inventory.markDirty();
				}
				{
					CompoundNBT _nbtTag = (copy).getTag();
					if (_nbtTag != null)
						(copy2).setTag(_nbtTag.copy());
				}
				(copy2).getOrCreateTag().putBoolean("ChakraStoring", (false));
				(copy2).getOrCreateTag().putBoolean("HiramekareiSharp", (false));
			} else if (itemstack.getOrCreateTag().getDouble("HiramekareiMode") == 1) {
				itemstack.getOrCreateTag().putDouble("HiramekareiMode", 2);
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Hiramekarei: Twinsword form"), (true));
				}
				copy = (itemstack.copy());
				copy2 = new ItemStack(HiramekareiSplittedItem.block);
				if (entity instanceof LivingEntity) {
					ItemStack _setstack = (copy2);
					_setstack.setCount((int) 1);
					((LivingEntity) entity).setHeldItem(Hand.MAIN_HAND, _setstack);
					if (entity instanceof ServerPlayerEntity)
						((ServerPlayerEntity) entity).inventory.markDirty();
				}
				{
					CompoundNBT _nbtTag = (copy).getTag();
					if (_nbtTag != null)
						(copy2).setTag(_nbtTag.copy());
				}
				(copy2).getOrCreateTag().putBoolean("ChakraStoring", (false));
				(copy2).getOrCreateTag().putBoolean("HiramekareiSharp", (false));
			} else if (itemstack.getOrCreateTag().getDouble("HiramekareiMode") == 2) {
				itemstack.getOrCreateTag().putDouble("HiramekareiMode", 3);
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Hiramekarei: Hammer form"), (true));
				}
				copy = (itemstack.copy());
				copy2 = new ItemStack(HiramekareiHammerFormItem.block);
				if (entity instanceof LivingEntity) {
					ItemStack _setstack = (copy2);
					_setstack.setCount((int) 1);
					((LivingEntity) entity).setHeldItem(Hand.MAIN_HAND, _setstack);
					if (entity instanceof ServerPlayerEntity)
						((ServerPlayerEntity) entity).inventory.markDirty();
				}
				{
					CompoundNBT _nbtTag = (copy).getTag();
					if (_nbtTag != null)
						(copy2).setTag(_nbtTag.copy());
				}
				(copy2).getOrCreateTag().putBoolean("ChakraStoring", (false));
				(copy2).getOrCreateTag().putBoolean("HiramekareiSharp", (false));
			} else if (itemstack.getOrCreateTag().getDouble("HiramekareiMode") == 3) {
				itemstack.getOrCreateTag().putDouble("HiramekareiMode", 0);
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Hiramekarei: Chakra Storing"), (true));
				}
				copy = (itemstack.copy());
				copy2 = new ItemStack(HiramekareiItem.block);
				if (entity instanceof LivingEntity) {
					ItemStack _setstack = (copy2);
					_setstack.setCount((int) 1);
					((LivingEntity) entity).setHeldItem(Hand.MAIN_HAND, _setstack);
					if (entity instanceof ServerPlayerEntity)
						((ServerPlayerEntity) entity).inventory.markDirty();
				}
				{
					CompoundNBT _nbtTag = (copy).getTag();
					if (_nbtTag != null)
						(copy2).setTag(_nbtTag.copy());
				}
				(copy2).getOrCreateTag().putBoolean("ChakraStoring", (false));
				(copy2).getOrCreateTag().putBoolean("HiramekareiSharp", (false));
			}
		}
	}
}
