package net.mcreator.narutoshippudenmod.procedures;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables;
import net.mcreator.narutoshippudenmod.NarutoShippudenMod;

import java.util.Map;

public class TrainingDummyEntityIsHurtProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure TrainingDummyEntityIsHurt!");
			return;
		}
		if (dependencies.get("sourceentity") == null) {
			if (!dependencies.containsKey("sourceentity"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency sourceentity for procedure TrainingDummyEntityIsHurt!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		if (entity.getPersistentData().getBoolean("Combat") == false) {
			if ((sourceentity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).storymode == 8) {
				if ((sourceentity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).TrainingDummyHits <= 99) {
					{
						double _setval = ((sourceentity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NarutoShippudenModVariables.PlayerVariables())).TrainingDummyHits + 1);
						sourceentity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.TrainingDummyHits = _setval;
							capability.syncPlayerVariables(sourceentity);
						});
					}
					if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
						((PlayerEntity) sourceentity)
								.sendStatusMessage(new StringTextComponent(("\u00A74Damage: "
										+ (new java.text.DecimalFormat("##.##")
												.format(Math.round(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMaxHealth() : -1)
														- ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1))))
										+ " \u00A76Hits: "
										+ new java.text.DecimalFormat("##.##")
												.format((sourceentity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
														.orElse(new NarutoShippudenModVariables.PlayerVariables())).TrainingDummyHits)
										+ "/100")), (true));
					}
					entity.getPersistentData().putDouble("TotalDamage",
							(entity.getPersistentData().getDouble("TotalDamage")
									+ ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMaxHealth() : -1)
									- ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)));
					if (entity instanceof LivingEntity)
						((LivingEntity) entity).setHealth((float) ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMaxHealth() : -1));
					entity.getPersistentData().putBoolean("Hurt", (true));
					entity.getPersistentData().putBoolean("Combat", (true));
				} else {
					if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
						((PlayerEntity) sourceentity)
								.sendStatusMessage(new StringTextComponent(("\u00A74Damage: " + (new java.text.DecimalFormat("##.##")
										.format(Math.round(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMaxHealth() : -1)
												- ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)))))),
										(true));
					}
					entity.getPersistentData().putDouble("TotalDamage",
							(entity.getPersistentData().getDouble("TotalDamage")
									+ ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMaxHealth() : -1)
									- ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)));
					if (entity instanceof LivingEntity)
						((LivingEntity) entity).setHealth((float) ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMaxHealth() : -1));
					entity.getPersistentData().putBoolean("Hurt", (true));
					entity.getPersistentData().putBoolean("Combat", (true));
				}
			} else {
				if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
					((PlayerEntity) sourceentity).sendStatusMessage(new StringTextComponent(("\u00A74Damage: " + (new java.text.DecimalFormat("##.##")
							.format(Math.round(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMaxHealth() : -1)
									- ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)))))),
							(true));
				}
				entity.getPersistentData().putDouble("TotalDamage",
						(entity.getPersistentData().getDouble("TotalDamage")
								+ ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMaxHealth() : -1)
								- ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)));
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).setHealth((float) ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMaxHealth() : -1));
				entity.getPersistentData().putBoolean("Hurt", (true));
				entity.getPersistentData().putBoolean("Combat", (true));
			}
		} else if (entity.getPersistentData().getBoolean("Combat") == true) {
			if (entity.getPersistentData().getBoolean("Hurt") == false) {
				entity.getPersistentData().putBoolean("Hurt", (true));
			}
		}
		if (entity.getPersistentData().getBoolean("Hurt") == true) {
			if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1) < ((entity instanceof LivingEntity)
					? ((LivingEntity) entity).getMaxHealth()
					: -1)) {
				if ((sourceentity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).storymode == 8) {
					if ((sourceentity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoShippudenModVariables.PlayerVariables())).TrainingDummyHits <= 99) {
						{
							double _setval = ((sourceentity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NarutoShippudenModVariables.PlayerVariables())).TrainingDummyHits + 1);
							sourceentity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.TrainingDummyHits = _setval;
								capability.syncPlayerVariables(sourceentity);
							});
						}
						if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
							((PlayerEntity) sourceentity).sendStatusMessage(
									new StringTextComponent(("\u00A74Damage: "
											+ (new java.text.DecimalFormat("##.##").format(
													Math.round(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMaxHealth() : -1)
															- ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1))))
											+ " \u00A76Hits: "
											+ new java.text.DecimalFormat("##.##")
													.format((sourceentity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
															.orElse(new NarutoShippudenModVariables.PlayerVariables())).TrainingDummyHits)
											+ "/100")),
									(true));
						}
						entity.getPersistentData().putDouble("TotalDamage",
								(entity.getPersistentData().getDouble("TotalDamage")
										+ ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMaxHealth() : -1)
										- ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)));
						if (entity instanceof LivingEntity)
							((LivingEntity) entity)
									.setHealth((float) ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMaxHealth() : -1));
						entity.getPersistentData().putBoolean("Hurt", (true));
						entity.getPersistentData().putBoolean("Combat", (true));
					} else {
						if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
							((PlayerEntity) sourceentity)
									.sendStatusMessage(
											new StringTextComponent(("\u00A74Damage: " + (new java.text.DecimalFormat("##.##").format(
													Math.round(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMaxHealth() : -1)
															- ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)))))),
											(true));
						}
						entity.getPersistentData().putDouble("TotalDamage",
								(entity.getPersistentData().getDouble("TotalDamage")
										+ ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMaxHealth() : -1)
										- ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)));
						if (entity instanceof LivingEntity)
							((LivingEntity) entity)
									.setHealth((float) ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMaxHealth() : -1));
						entity.getPersistentData().putBoolean("Hurt", (true));
						entity.getPersistentData().putBoolean("Combat", (true));
					}
				} else {
					if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
						((PlayerEntity) sourceentity)
								.sendStatusMessage(new StringTextComponent(("\u00A74Damage: " + (new java.text.DecimalFormat("##.##")
										.format(Math.round(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMaxHealth() : -1)
												- ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)))))),
										(true));
					}
					entity.getPersistentData().putDouble("TotalDamage",
							(entity.getPersistentData().getDouble("TotalDamage")
									+ ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMaxHealth() : -1)
									- ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)));
					if (entity instanceof LivingEntity)
						((LivingEntity) entity).setHealth((float) ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMaxHealth() : -1));
					entity.getPersistentData().putBoolean("Hurt", (true));
					entity.getPersistentData().putBoolean("Combat", (true));
				}
			}
		}
	}
}
