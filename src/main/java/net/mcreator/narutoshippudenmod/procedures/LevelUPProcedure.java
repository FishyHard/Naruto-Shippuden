package net.mcreator.narutoshippudenmod.procedures;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables;
import net.mcreator.narutoshippudenmod.NarutoShippudenMod;

import java.util.Map;

import java.io.File;

public class LevelUPProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure LevelUP!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		Entity shadow = null;
		File NarutoShippuden = new File("");
		if (!(NarutoShippudenModVariables.get(entity).LEVELSTAT == NarutoShippudenModVariables.get(entity).LevelStatMaxChange)) {
			if (NarutoShippudenModVariables.get(entity).LEVEL >= NarutoShippudenModVariables.get(entity).LEVELMAX) {
				if (NarutoShippudenModVariables.get(entity).LEVEL == NarutoShippudenModVariables.get(entity).LEVELMAX) {
					{
						double _setval = 0;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.LEVEL = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).LEVELMAX + 1);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.LEVELMAX = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).LEVELSTAT + 1);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.LEVELSTAT = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp + 1);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).sp + 1);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.sp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(
								new StringTextComponent(
										("Level Up! Level: " + NarutoShippudenModVariables.get(entity).LEVELSTAT + " JP +1" + " SP +1")),
								(true));
					}
				}
				if (NarutoShippudenModVariables.get(entity).LEVEL >= NarutoShippudenModVariables.get(entity).LEVELMAX) {
					{
						double _setval = (NarutoShippudenModVariables.get(entity).LEVEL
								- NarutoShippudenModVariables.get(entity).LEVELMAX);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.LEVEL = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).LEVELMAX + 1);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.LEVELMAX = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).LEVELSTAT + 1);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.LEVELSTAT = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp + 1);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).sp + 1);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.sp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(
								new StringTextComponent(
										("Level Up! Level: " + NarutoShippudenModVariables.get(entity).LEVELSTAT + " JP +1" + " SP +1")),
								(true));
					}
				}
			}
			if (NarutoShippudenModVariables.get(entity).LEVELMINIGAME >= NarutoShippudenModVariables.get(entity).LEVELMAXMINIGAME) {
				if (NarutoShippudenModVariables.get(entity).LEVELMINIGAME == NarutoShippudenModVariables.get(entity).LEVELMAXMINIGAME) {
					{
						double _setval = 0;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.LEVELMINIGAME = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).LEVELMAXMINIGAME + 2);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.LEVELMAXMINIGAME = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).LEVELSTATMINIGAME + 1);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.LEVELSTATMINIGAME = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp + 1);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).sp + 1);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.sp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity)
								.sendStatusMessage(
										new StringTextComponent(("Level Up! Level: "
												+ NarutoShippudenModVariables.get(entity).LEVELSTATMINIGAME
												+ " JP +1" + " SP +1")),
										(true));
					}
				}
				if (NarutoShippudenModVariables.get(entity).LEVELMINIGAME >= NarutoShippudenModVariables.get(entity).LEVELMAXMINIGAME) {
					{
						double _setval = (NarutoShippudenModVariables.get(entity).LEVELMINIGAME
								- NarutoShippudenModVariables.get(entity).LEVELMAXMINIGAME);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.LEVELMINIGAME = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).LEVELMAXMINIGAME + 2);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.LEVELMAXMINIGAME = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).LEVELSTATMINIGAME + 1);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.LEVELSTATMINIGAME = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp + 1);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).sp + 1);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.sp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity)
								.sendStatusMessage(
										new StringTextComponent(("Level Up! Level: "
												+ NarutoShippudenModVariables.get(entity).LEVELSTATMINIGAME
												+ " JP +1" + " SP +1")),
										(true));
					}
				}
			}
		} else if (NarutoShippudenModVariables.get(entity).LEVELSTAT == NarutoShippudenModVariables.get(entity).LevelStatMaxChange) {
			{
				double _setval = 1;
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.LEVELMAX = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = (NarutoShippudenModVariables.get(entity).LevelStatMaxChange + 100);
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.LevelStatMaxChange = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
