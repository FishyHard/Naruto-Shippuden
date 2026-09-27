package net.mcreator.narutoshippudenmod.procedures;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.narutoshippudenmod.item.MangekyouSharinganItachiReleaseTechniqueItem;
import net.mcreator.narutoshippudenmod.item.AmaterasuFlameItem;
import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables;
import net.mcreator.narutoshippudenmod.NarutoShippudenMod;

import java.util.Map;

public class MangekyouSharinganItachiReleaseTechniqueRightclickedProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NarutoShippudenMod.LOGGER
						.warn("Failed to load dependency entity for procedure MangekyouSharinganItachiReleaseTechniqueRightclicked!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (NarutoShippudenModVariables.get(entity).MangekyouSharinganItachi == true) {
			if (!entity.isSneaking()) {
				if (NarutoShippudenModVariables.get(entity).MangekyouSharinganActivate == true) {
					if (NarutoShippudenModVariables.get(entity).mangekyoushrainganitachiamaterasulearn >= 1) {
						if (NarutoShippudenModVariables.get(entity).ninjutsu >= 20) {
							if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 350) {
								{
									Entity _shootFrom = entity;
									World projectileLevel = _shootFrom.world;
									if (!projectileLevel.isRemote()) {
										ProjectileEntity _entityToSpawn = new Object() {
											public ProjectileEntity getArrow(World world, float damage, int knockback) {
												AbstractArrowEntity entityToSpawn = new AmaterasuFlameItem.ArrowCustomEntity(AmaterasuFlameItem.arrow,
														world);

												entityToSpawn.setDamage(damage);
												entityToSpawn.setKnockbackStrength(knockback);
												entityToSpawn.setSilent(true);

												return entityToSpawn;
											}
										}.getArrow(projectileLevel, 5, 1);
										_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
										_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1, 0);
										projectileLevel.addEntity(_entityToSpawn);
									}
								}
								{
									double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 350);
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.ChakraAmount = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
								{
									double _setval = (NarutoShippudenModVariables.get(entity).Mangekyou_Sharingan_Technique_Use + 1);
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.Mangekyou_Sharingan_Technique_Use = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 349) {
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
								}
							}
						} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 19) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu"), (false));
							}
						}
					} else if (!(NarutoShippudenModVariables.get(entity).mangekyoushrainganitachiamaterasulearn >= 1)) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this technique."), (false));
						}
					}
					if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(MangekyouSharinganItachiReleaseTechniqueItem.block, (int) 200);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(MangekyouSharinganItachiReleaseTechniqueItem.block, (int) 160);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(MangekyouSharinganItachiReleaseTechniqueItem.block, (int) 120);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(MangekyouSharinganItachiReleaseTechniqueItem.block, (int) 80);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(MangekyouSharinganItachiReleaseTechniqueItem.block, (int) 40);
					}
				} else if (NarutoShippudenModVariables.get(entity).MangekyouSharinganActivate == false) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Activate Mangekyou Sharingan"), (true));
					}
				}
			} else if (entity.isSneaking()) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Selected: Amaterasu"), (true));
				}
			}
		} else if (NarutoShippudenModVariables.get(entity).MangekyouSharinganItachi == false) {
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this release."), (true));
			}
		}
	}
}
