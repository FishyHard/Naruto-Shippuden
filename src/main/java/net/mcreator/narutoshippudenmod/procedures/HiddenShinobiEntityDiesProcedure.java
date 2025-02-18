package net.mcreator.narutoshippudenmod.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.narutoshippudenmod.entity.HiddenStoneShinobiEntity;
import net.mcreator.narutoshippudenmod.entity.HiddenSandShinobiEntity;
import net.mcreator.narutoshippudenmod.entity.HiddenMistShinobiEntity;
import net.mcreator.narutoshippudenmod.entity.HiddenLeafShinobiEntity;
import net.mcreator.narutoshippudenmod.entity.HiddenCloudShinobiEntity;
import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables;
import net.mcreator.narutoshippudenmod.NarutoShippudenMod;

import java.util.stream.Collectors;
import java.util.function.Function;
import java.util.Map;
import java.util.List;
import java.util.Comparator;

public class HiddenShinobiEntityDiesProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure HiddenShinobiEntityDies!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency x for procedure HiddenShinobiEntityDies!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency y for procedure HiddenShinobiEntityDies!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency z for procedure HiddenShinobiEntityDies!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure HiddenShinobiEntityDies!");
			return;
		}
		if (dependencies.get("sourceentity") == null) {
			if (!dependencies.containsKey("sourceentity"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency sourceentity for procedure HiddenShinobiEntityDies!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		if (sourceentity instanceof PlayerEntity) {
			if ((sourceentity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).storymode == 16) {
				if (!((sourceentity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).StoryModeGeninFight).equals(" ")) {
					if (((sourceentity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoShippudenModVariables.PlayerVariables())).StoryModeGeninFight).equals("Leaf")) {
						if (entity instanceof HiddenLeafShinobiEntity.CustomEntity) {
							{
								double _setval = 17;
								sourceentity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.storymode = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
							{
								String _setval = "Win";
								sourceentity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.StoryModeGeninFight = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
						}
					} else if (((sourceentity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoShippudenModVariables.PlayerVariables())).StoryModeGeninFight).equals("Sand")) {
						if (entity instanceof HiddenSandShinobiEntity.CustomEntity) {
							{
								double _setval = 17;
								sourceentity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.storymode = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
							{
								String _setval = "Win";
								sourceentity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.StoryModeGeninFight = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
						}
					} else if (((sourceentity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoShippudenModVariables.PlayerVariables())).StoryModeGeninFight).equals("Stone")) {
						if (entity instanceof HiddenStoneShinobiEntity.CustomEntity) {
							{
								double _setval = 17;
								sourceentity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.storymode = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
							{
								String _setval = "Win";
								sourceentity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.StoryModeGeninFight = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
						}
					} else if (((sourceentity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoShippudenModVariables.PlayerVariables())).StoryModeGeninFight).equals("Cloud")) {
						if (entity instanceof HiddenCloudShinobiEntity.CustomEntity) {
							{
								double _setval = 17;
								sourceentity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.storymode = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
							{
								String _setval = "Win";
								sourceentity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.StoryModeGeninFight = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
						}
					} else if (((sourceentity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoShippudenModVariables.PlayerVariables())).StoryModeGeninFight).equals("Mist")) {
						if (entity instanceof HiddenMistShinobiEntity.CustomEntity) {
							{
								double _setval = 17;
								sourceentity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.storymode = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
							{
								String _setval = "Win";
								sourceentity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.StoryModeGeninFight = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
						}
					}
				}
			}
		}
		{
			List<Entity> _entfound = world
					.getEntitiesWithinAABB(Entity.class,
							new AxisAlignedBB(x - (25 / 2d), y - (25 / 2d), z - (25 / 2d), x + (25 / 2d), y + (25 / 2d), z + (25 / 2d)), null)
					.stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
						}
					}.compareDistOf(x, y, z)).collect(Collectors.toList());
			for (Entity entityiterator : _entfound) {
				if (entityiterator instanceof PlayerEntity) {
					if ((entityiterator.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoShippudenModVariables.PlayerVariables())).storymode == 16) {
						if (!((entityiterator.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NarutoShippudenModVariables.PlayerVariables())).StoryModeGeninFight).equals(" ")) {
							if (((entityiterator.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NarutoShippudenModVariables.PlayerVariables())).StoryModeGeninFight).equals("Leaf")) {
								if (entity instanceof HiddenLeafShinobiEntity.CustomEntity) {
									{
										double _setval = 17;
										entityiterator.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
												.ifPresent(capability -> {
													capability.storymode = _setval;
													capability.syncPlayerVariables(entityiterator);
												});
									}
									{
										String _setval = "Win";
										entityiterator.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
												.ifPresent(capability -> {
													capability.StoryModeGeninFight = _setval;
													capability.syncPlayerVariables(entityiterator);
												});
									}
								}
							} else if (((entityiterator.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NarutoShippudenModVariables.PlayerVariables())).StoryModeGeninFight).equals("Sand")) {
								if (entity instanceof HiddenSandShinobiEntity.CustomEntity) {
									{
										double _setval = 17;
										entityiterator.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
												.ifPresent(capability -> {
													capability.storymode = _setval;
													capability.syncPlayerVariables(entityiterator);
												});
									}
									{
										String _setval = "Win";
										entityiterator.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
												.ifPresent(capability -> {
													capability.StoryModeGeninFight = _setval;
													capability.syncPlayerVariables(entityiterator);
												});
									}
								}
							} else if (((entityiterator.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NarutoShippudenModVariables.PlayerVariables())).StoryModeGeninFight).equals("Stone")) {
								if (entity instanceof HiddenStoneShinobiEntity.CustomEntity) {
									{
										double _setval = 17;
										entityiterator.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
												.ifPresent(capability -> {
													capability.storymode = _setval;
													capability.syncPlayerVariables(entityiterator);
												});
									}
									{
										String _setval = "Win";
										entityiterator.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
												.ifPresent(capability -> {
													capability.StoryModeGeninFight = _setval;
													capability.syncPlayerVariables(entityiterator);
												});
									}
								}
							} else if (((entityiterator.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NarutoShippudenModVariables.PlayerVariables())).StoryModeGeninFight).equals("Cloud")) {
								if (entity instanceof HiddenCloudShinobiEntity.CustomEntity) {
									{
										double _setval = 17;
										entityiterator.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
												.ifPresent(capability -> {
													capability.storymode = _setval;
													capability.syncPlayerVariables(entityiterator);
												});
									}
									{
										String _setval = "Win";
										entityiterator.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
												.ifPresent(capability -> {
													capability.StoryModeGeninFight = _setval;
													capability.syncPlayerVariables(entityiterator);
												});
									}
								}
							} else if (((entityiterator.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NarutoShippudenModVariables.PlayerVariables())).StoryModeGeninFight).equals("Mist")) {
								if (entity instanceof HiddenMistShinobiEntity.CustomEntity) {
									{
										double _setval = 17;
										entityiterator.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
												.ifPresent(capability -> {
													capability.storymode = _setval;
													capability.syncPlayerVariables(entityiterator);
												});
									}
									{
										String _setval = "Win";
										entityiterator.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
												.ifPresent(capability -> {
													capability.StoryModeGeninFight = _setval;
													capability.syncPlayerVariables(entityiterator);
												});
									}
								}
							}
						}
					}
				}
			}
		}
	}
}
