package net.mcreator.narutoshippudenmod.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.narutoshippudenmod.block.PaperBombBlock;
import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables;
import net.mcreator.narutoshippudenmod.NarutoShippudenMod;

import java.util.Map;

public class ShibukiRightclickedProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure ShibukiRightclicked!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency y for procedure ShibukiRightclicked!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure ShibukiRightclicked!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency itemstack for procedure ShibukiRightclicked!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		double distance = 0;
		double yfound = 0;
		boolean found = false;
		boolean heightfound = false;
		boolean reach = false;
		ItemStack copy2 = ItemStack.EMPTY;
		ItemStack copy = ItemStack.EMPTY;
		if (!entity.isSneaking()) {
			if (itemstack.getOrCreateTag().getDouble("ShibukiMode") == 0) {
				if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount >= 350) {
					if (entity instanceof LivingEntity)
						((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.RESISTANCE, (int) 20, (int) 254, (false), (false)));
					distance = 2;
					yfound = 0;
					for (int index0 = 0; index0 < (int) (5); index0++) {
						for (int index1 = 0; index1 < (int) (6); index1++) {
							if (world
									.isAirBlock(
											new BlockPos(
													entity.world
															.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																	entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																			entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																	RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
															.getPos().getX(),
													y + yfound,
													entity.world
															.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																	entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																			entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																	RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
															.getPos().getZ()))
									|| !world.getBlockState(new BlockPos(
											entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
													entity.getEyePosition(1f).add(entity.getLook(1f).x * distance, entity.getLook(1f).y * distance,
															entity.getLook(1f).z * distance),
													RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getX(),
											y + yfound,
											entity.world
													.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
															entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																	entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
															RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
													.getPos().getZ()))
											.isSolid()) {
								world.setBlockState(
										new BlockPos(
												entity.world
														.rayTraceBlocks(
																new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																				entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
														.getPos().getX(),
												y + yfound,
												entity.world
														.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																		entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
														.getPos().getZ()),
										PaperBombBlock.block.getDefaultState(), 3);
								found = (true);
							} else if (!world
									.isAirBlock(
											new BlockPos(
													entity.world
															.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																	entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																			entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																	RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
															.getPos().getX(),
													y + yfound,
													entity.world
															.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																	entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																			entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																	RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
															.getPos().getZ()))
									&& world.getBlockState(new BlockPos(
											entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
													entity.getEyePosition(1f).add(entity.getLook(1f).x * distance, entity.getLook(1f).y * distance,
															entity.getLook(1f).z * distance),
													RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getX(),
											y + yfound,
											entity.world
													.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
															entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																	entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
															RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
													.getPos().getZ()))
											.isSolid()) {
								yfound = (yfound + 1);
							}
						}
						if (found == true) {
							distance = (distance + 1);
							found = (false);
							yfound = 0;
						}
					}
					{
						double _setval = ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount - 350);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.ChakraAmount = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount <= 349) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
					}
				}
			} else if (itemstack.getOrCreateTag().getDouble("ShibukiMode") == 1) {
				if (itemstack.getOrCreateTag().getBoolean("ShibukiExplosion") == true) {
					itemstack.getOrCreateTag().putBoolean("ShibukiExplosion", (false));
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Shibuki Explosion: Off"), (true));
					}
				} else if (itemstack.getOrCreateTag().getBoolean("ShibukiExplosion") == false) {
					itemstack.getOrCreateTag().putBoolean("ShibukiExplosion", (true));
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Shibuki Explosion: On"), (true));
					}
				}
			} else if (itemstack.getOrCreateTag().getDouble("ShibukiMode") == 2) {
				if (itemstack.getOrCreateTag().getBoolean("ShibukiExplosionTrail") == true) {
					itemstack.getOrCreateTag().putBoolean("ShibukiExplosionTrail", (false));
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Shibuki Explosion Trail: Off"), (true));
					}
				} else if (itemstack.getOrCreateTag().getBoolean("ShibukiExplosionTrail") == false) {
					itemstack.getOrCreateTag().putBoolean("ShibukiExplosionTrail", (true));
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Shibuki Explosion Trail: On"), (true));
					}
				}
			}
		} else if (entity.isSneaking()) {
			if (itemstack.getOrCreateTag().getDouble("ShibukiMode") == 0) {
				itemstack.getOrCreateTag().putDouble("ShibukiMode", 1);
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Shibuki: Explosion"), (true));
				}
			} else if (itemstack.getOrCreateTag().getDouble("ShibukiMode") == 1) {
				itemstack.getOrCreateTag().putDouble("ShibukiMode", 2);
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Shibuki: Explosion Trail"), (true));
				}
			} else if (itemstack.getOrCreateTag().getDouble("ShibukiMode") == 2) {
				itemstack.getOrCreateTag().putDouble("ShibukiMode", 0);
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Shibuki: Paper Bomb Trap"), (true));
				}
			}
		}
	}
}
