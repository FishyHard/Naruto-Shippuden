package net.mcreator.narutoshippudenmod.procedures;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.narutoshippudenmod.entity.HiddenStoneShinobiEntity;
import net.mcreator.narutoshippudenmod.entity.HiddenSandShinobiEntity;
import net.mcreator.narutoshippudenmod.entity.HiddenMistShinobiEntity;
import net.mcreator.narutoshippudenmod.entity.HiddenLeafShinobiEntity;
import net.mcreator.narutoshippudenmod.entity.HiddenCloudShinobiEntity;
import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables;
import net.mcreator.narutoshippudenmod.NarutoShippudenMod;

import java.util.Map;

public class HiddenShinobiKillsEntityProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure HiddenShinobiKillsEntity!");
			return;
		}
		if (dependencies.get("sourceentity") == null) {
			if (!dependencies.containsKey("sourceentity"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency sourceentity for procedure HiddenShinobiKillsEntity!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		if (entity instanceof PlayerEntity) {
			if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).storymode == 16) {
				if (!((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).StoryModeGeninFight).equals(" ")) {
					if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoShippudenModVariables.PlayerVariables())).StoryModeGeninFight).equals("Leaf")) {
						if (sourceentity instanceof HiddenLeafShinobiEntity.CustomEntity) {
							{
								String _setval = "Defeat";
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.StoryModeGeninFight = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = 17;
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.storymode = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						}
					} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoShippudenModVariables.PlayerVariables())).StoryModeGeninFight).equals("Sand")) {
						if (sourceentity instanceof HiddenSandShinobiEntity.CustomEntity) {
							{
								String _setval = "Defeat";
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.StoryModeGeninFight = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = 17;
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.storymode = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						}
					} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoShippudenModVariables.PlayerVariables())).StoryModeGeninFight).equals("Stone")) {
						if (sourceentity instanceof HiddenStoneShinobiEntity.CustomEntity) {
							{
								String _setval = "Defeat";
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.StoryModeGeninFight = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = 17;
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.storymode = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						}
					} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoShippudenModVariables.PlayerVariables())).StoryModeGeninFight).equals("Cloud")) {
						if (sourceentity instanceof HiddenCloudShinobiEntity.CustomEntity) {
							{
								String _setval = "Defeat";
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.StoryModeGeninFight = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = 17;
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.storymode = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						}
					} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoShippudenModVariables.PlayerVariables())).StoryModeGeninFight).equals("Mist")) {
						if (sourceentity instanceof HiddenMistShinobiEntity.CustomEntity) {
							{
								String _setval = "Defeat";
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.StoryModeGeninFight = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = 17;
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.storymode = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						}
					}
					if (!sourceentity.world.isRemote())
						sourceentity.remove();
				}
			}
		}
	}
}
