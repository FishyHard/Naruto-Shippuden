package net.mcreator.narutoshippudenmod.procedures;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.narutoshippudenmod.item.DanceOfTheClematisFlowerItem;
import net.mcreator.narutoshippudenmod.item.DanceOfTheCamelliaItem;
import net.mcreator.narutoshippudenmod.item.BoneReleaseTechniqueItem;
import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables;
import net.mcreator.narutoshippudenmod.NarutoShippudenMod;

import java.util.Map;

public class BoneReleaseTechniqueRightclickedProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure BoneReleaseTechniqueRightclicked!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (NarutoShippudenModVariables.get(entity).bonereleaselogic == true) {
			if (!entity.isSneaking()) {
				if (NarutoShippudenModVariables.get(entity).bonetechnique == 0) {
					if (NarutoShippudenModVariables.get(entity).bonelearn >= 1) {
						if (NarutoShippudenModVariables.get(entity).ninjutsu >= 20) {
							if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 200) {
								if (entity instanceof PlayerEntity) {
									ItemStack _setstack = new ItemStack(DanceOfTheCamelliaItem.block);
									_setstack.setCount((int) 1);
									ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
								}
								if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
									if (entity instanceof PlayerEntity)
										((PlayerEntity) entity).getCooldownTracker().setCooldown(BoneReleaseTechniqueItem.block, (int) 750);
								} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
									if (entity instanceof PlayerEntity)
										((PlayerEntity) entity).getCooldownTracker().setCooldown(BoneReleaseTechniqueItem.block, (int) 500);
								} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
									if (entity instanceof PlayerEntity)
										((PlayerEntity) entity).getCooldownTracker().setCooldown(BoneReleaseTechniqueItem.block, (int) 300);
								} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
									if (entity instanceof PlayerEntity)
										((PlayerEntity) entity).getCooldownTracker().setCooldown(BoneReleaseTechniqueItem.block, (int) 200);
								} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
									if (entity instanceof PlayerEntity)
										((PlayerEntity) entity).getCooldownTracker().setCooldown(BoneReleaseTechniqueItem.block, (int) 100);
								}
							} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 199) {
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
								}
							}
						} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 19) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu"), (false));
							}
						}
					} else if (!(NarutoShippudenModVariables.get(entity).bonelearn >= 1)) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this technique."), (false));
						}
					}
				} else if (NarutoShippudenModVariables.get(entity).bonetechnique == 1) {
					if (NarutoShippudenModVariables.get(entity).bonelearn >= 2) {
						if (NarutoShippudenModVariables.get(entity).ninjutsu >= 25) {
							if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 350) {
								if (entity instanceof PlayerEntity) {
									ItemStack _setstack = new ItemStack(DanceOfTheClematisFlowerItem.block);
									_setstack.setCount((int) 1);
									ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
								}
								if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
									if (entity instanceof PlayerEntity)
										((PlayerEntity) entity).getCooldownTracker().setCooldown(BoneReleaseTechniqueItem.block, (int) 750);
								} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
									if (entity instanceof PlayerEntity)
										((PlayerEntity) entity).getCooldownTracker().setCooldown(BoneReleaseTechniqueItem.block, (int) 500);
								} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
									if (entity instanceof PlayerEntity)
										((PlayerEntity) entity).getCooldownTracker().setCooldown(BoneReleaseTechniqueItem.block, (int) 300);
								} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
									if (entity instanceof PlayerEntity)
										((PlayerEntity) entity).getCooldownTracker().setCooldown(BoneReleaseTechniqueItem.block, (int) 200);
								} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
									if (entity instanceof PlayerEntity)
										((PlayerEntity) entity).getCooldownTracker().setCooldown(BoneReleaseTechniqueItem.block, (int) 100);
								}
							} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 349) {
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
								}
							}
						} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 24) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu"), (false));
							}
						}
					} else if (!(NarutoShippudenModVariables.get(entity).bonelearn >= 2)) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this technique."), (false));
						}
					}
				} else if (NarutoShippudenModVariables.get(entity).bonetechnique == 2) {
					if (NarutoShippudenModVariables.get(entity).bonelearn >= 3) {
						if (NarutoShippudenModVariables.get(entity).ninjutsu >= 30) {
							if (NarutoShippudenModVariables.get(entity).DanceOfTheLarch == false) {
								{
									boolean _setval = (true);
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.DanceOfTheLarch = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if (NarutoShippudenModVariables.get(entity).DanceOfTheLarch == true) {
								{
									boolean _setval = (false);
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.DanceOfTheLarch = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
								if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
									if (entity instanceof PlayerEntity)
										((PlayerEntity) entity).getCooldownTracker().setCooldown(BoneReleaseTechniqueItem.block, (int) 750);
								} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
									if (entity instanceof PlayerEntity)
										((PlayerEntity) entity).getCooldownTracker().setCooldown(BoneReleaseTechniqueItem.block, (int) 500);
								} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
									if (entity instanceof PlayerEntity)
										((PlayerEntity) entity).getCooldownTracker().setCooldown(BoneReleaseTechniqueItem.block, (int) 300);
								} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
									if (entity instanceof PlayerEntity)
										((PlayerEntity) entity).getCooldownTracker().setCooldown(BoneReleaseTechniqueItem.block, (int) 200);
								} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
									if (entity instanceof PlayerEntity)
										((PlayerEntity) entity).getCooldownTracker().setCooldown(BoneReleaseTechniqueItem.block, (int) 100);
								}
							}
						} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 29) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu"), (false));
							}
						}
					} else if (!(NarutoShippudenModVariables.get(entity).bonelearn >= 3)) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this technique."), (false));
						}
					}
				}
			} else if (entity.isSneaking()) {
				if (NarutoShippudenModVariables.get(entity).bonetechnique == 0) {
					{
						double _setval = 1;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.bonetechnique = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Selected: Dance of the Clematis: Flower"), (true));
					}
				} else if (NarutoShippudenModVariables.get(entity).bonetechnique == 1) {
					{
						double _setval = 2;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.bonetechnique = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Selected: Dance of the Larch"), (true));
					}
				} else if (NarutoShippudenModVariables.get(entity).bonetechnique == 2) {
					{
						double _setval = 0;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.bonetechnique = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Selected: Dance of the Camellia"), (true));
					}
				}
			}
		} else if (NarutoShippudenModVariables.get(entity).bonereleaselogic == false) {
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this release."), (true));
			}
		}
	}
}
