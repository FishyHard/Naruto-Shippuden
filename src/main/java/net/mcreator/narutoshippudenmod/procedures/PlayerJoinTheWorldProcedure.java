package net.mcreator.narutoshippudenmod.procedures;

import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.fml.loading.FMLPaths;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.world.GameRules;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.BlockPos;
import net.minecraft.network.PacketBuffer;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.inventory.container.Container;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.narutoshippudenmod.item.WoodReleaseItem;
import net.mcreator.narutoshippudenmod.item.TyphoonReleaseItem;
import net.mcreator.narutoshippudenmod.item.SwiftReleaseItem;
import net.mcreator.narutoshippudenmod.item.StoryModeItem;
import net.mcreator.narutoshippudenmod.item.StormReleaseItem;
import net.mcreator.narutoshippudenmod.item.SteelReleaseItem;
import net.mcreator.narutoshippudenmod.item.SmokeReleaseItem;
import net.mcreator.narutoshippudenmod.item.MagnetReleaseItem;
import net.mcreator.narutoshippudenmod.item.IchirakuRamenItem;
import net.mcreator.narutoshippudenmod.item.IceReleaseItem;
import net.mcreator.narutoshippudenmod.item.DustReleaseItem;
import net.mcreator.narutoshippudenmod.item.ClanPaperItem;
import net.mcreator.narutoshippudenmod.item.ChakraPaperItem;
import net.mcreator.narutoshippudenmod.item.BoneReleaseItem;
import net.mcreator.narutoshippudenmod.item.BoilReleaseItem;
import net.mcreator.narutoshippudenmod.gui.StatSelectGui;
import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables;
import net.mcreator.narutoshippudenmod.NarutoShippudenMod;

import java.util.Random;
import java.util.Map;
import java.util.HashMap;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

import io.netty.buffer.Unpooled;

import com.google.gson.Gson;

public class PlayerJoinTheWorldProcedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
			Entity entity = event.getPlayer();
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("x", entity.getPosX());
			dependencies.put("y", entity.getPosY());
			dependencies.put("z", entity.getPosZ());
			dependencies.put("world", entity.world);
			dependencies.put("entity", entity);
			dependencies.put("event", event);
			executeProcedure(dependencies);
		}
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure PlayerJoinTheWorld!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency x for procedure PlayerJoinTheWorld!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency y for procedure PlayerJoinTheWorld!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency z for procedure PlayerJoinTheWorld!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure PlayerJoinTheWorld!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		com.google.gson.JsonObject mainjsonobject = new com.google.gson.JsonObject();
		File NarutoShippuden = new File("");
		File PlayerSkin = new File("");
		String PlayerName = "";
		double Random = 0;
		double randomkkg = 0;
		NarutoShippuden = (File) new File((FMLPaths.GAMEDIR.get().toString() + "/config/narutoshippuden"),
				File.separator + "narutoshippudenconfig.json");
		{
			try {
				BufferedReader bufferedReader = new BufferedReader(new FileReader(NarutoShippuden));
				StringBuilder jsonstringbuilder = new StringBuilder();
				String line;
				while ((line = bufferedReader.readLine()) != null) {
					jsonstringbuilder.append(line);
				}
				bufferedReader.close();
				mainjsonobject = new Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
				if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).joinworld == false) {
					if (mainjsonobject.get("clan_random").getAsBoolean() == false) {
						{
							Entity _ent = entity;
							if (_ent instanceof ServerPlayerEntity) {
								BlockPos _bpos = new BlockPos(x, y, z);
								NetworkHooks.openGui((ServerPlayerEntity) _ent, new INamedContainerProvider() {
									@Override
									public ITextComponent getDisplayName() {
										return new StringTextComponent("StatSelect");
									}

									@Override
									public Container createMenu(int id, PlayerInventory inventory, PlayerEntity player) {
										return new StatSelectGui.GuiContainerMod(id, inventory,
												new PacketBuffer(Unpooled.buffer()).writeBlockPos(_bpos));
									}
								}, _bpos);
							}
						}
					} else if (mainjsonobject.get("clan_random").getAsBoolean() == true) {
						if (entity instanceof PlayerEntity) {
							ItemStack _setstack = new ItemStack(ChakraPaperItem.block);
							_setstack.setCount((int) 1);
							ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
						}
						if (entity instanceof PlayerEntity) {
							ItemStack _setstack = new ItemStack(ClanPaperItem.block);
							_setstack.setCount((int) 1);
							ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
						}
						Random = (MathHelper.nextInt(new Random(), 1, 1000));
						if (Random <= mainjsonobject.get("kekkei_genkai_spawn_chance").getAsDouble() * 10) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Looks like you were borned with Kekkei Genkai."),
										(true));
							}
							randomkkg = (MathHelper.nextInt(new Random(), 1, 11));
							if (randomkkg == 1) {
								if (entity instanceof PlayerEntity) {
									ItemStack _setstack = new ItemStack(SmokeReleaseItem.block);
									_setstack.setCount((int) 1);
									ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
								}
								{
									boolean _setval = (true);
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.smokereleaselogic = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if (randomkkg == 2) {
								if (entity instanceof PlayerEntity) {
									ItemStack _setstack = new ItemStack(MagnetReleaseItem.block);
									_setstack.setCount((int) 1);
									ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
								}
								{
									boolean _setval = (true);
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.magnetreleaselogic = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if (randomkkg == 3) {
								if (entity instanceof PlayerEntity) {
									ItemStack _setstack = new ItemStack(StormReleaseItem.block);
									_setstack.setCount((int) 1);
									ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
								}
								{
									boolean _setval = (true);
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.stormreleaselogic = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if (randomkkg == 4) {
								if (entity instanceof PlayerEntity) {
									ItemStack _setstack = new ItemStack(WoodReleaseItem.block);
									_setstack.setCount((int) 1);
									ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
								}
								{
									boolean _setval = (true);
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.woodreleaselogic = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if (randomkkg == 5) {
								if (entity instanceof PlayerEntity) {
									ItemStack _setstack = new ItemStack(IceReleaseItem.block);
									_setstack.setCount((int) 1);
									ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
								}
								{
									boolean _setval = (true);
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.icereleaselogic = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if (randomkkg == 6) {
								if (entity instanceof PlayerEntity) {
									ItemStack _setstack = new ItemStack(BoneReleaseItem.block);
									_setstack.setCount((int) 1);
									ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
								}
								{
									boolean _setval = (true);
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.bonereleaselogic = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if (randomkkg == 7) {
								if (entity instanceof PlayerEntity) {
									ItemStack _setstack = new ItemStack(TyphoonReleaseItem.block);
									_setstack.setCount((int) 1);
									ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
								}
								{
									boolean _setval = (true);
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.typhoonreleaslogic = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if (randomkkg == 8) {
								if (entity instanceof PlayerEntity) {
									ItemStack _setstack = new ItemStack(SwiftReleaseItem.block);
									_setstack.setCount((int) 1);
									ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
								}
								{
									boolean _setval = (true);
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.swiftreleaselogic = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if (randomkkg == 9) {
								if (entity instanceof PlayerEntity) {
									ItemStack _setstack = new ItemStack(BoilReleaseItem.block);
									_setstack.setCount((int) 1);
									ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
								}
								{
									boolean _setval = (true);
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.boilreleaselogic = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if (randomkkg == 10) {
								if (entity instanceof PlayerEntity) {
									ItemStack _setstack = new ItemStack(DustReleaseItem.block);
									_setstack.setCount((int) 1);
									ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
								}
								{
									boolean _setval = (true);
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.dustreleaselogic = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if (randomkkg == 11) {
								if (entity instanceof PlayerEntity) {
									ItemStack _setstack = new ItemStack(SteelReleaseItem.block);
									_setstack.setCount((int) 1);
									ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
								}
								{
									boolean _setval = (true);
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.steelreleaselogic = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							}
						}
					}
					if (world instanceof World) {
						((World) world).getGameRules().get(GameRules.KEEP_INVENTORY).set((true), ((World) world).getServer());
					}
					if (world instanceof World) {
						((World) world).getGameRules().get(GameRules.FALL_DAMAGE).set((false), ((World) world).getServer());
					}
					if (entity instanceof PlayerEntity) {
						ItemStack _setstack = new ItemStack(IchirakuRamenItem.block);
						_setstack.setCount((int) 16);
						ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
					}
					if (entity instanceof PlayerEntity) {
						ItemStack _setstack = new ItemStack(StoryModeItem.block);
						_setstack.setCount((int) 1);
						ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
					}
					{
						boolean _setval = (true);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.joinworld = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						String _setval = (entity.getDisplayName().getString());
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.player_name = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					PlayerName = (entity.getDisplayName().getString());
				} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).joinworld == true) {
					if (world instanceof World) {
						((World) world).getGameRules().get(GameRules.KEEP_INVENTORY).set((true), ((World) world).getServer());
					}
					if (world instanceof World) {
						((World) world).getGameRules().get(GameRules.FALL_DAMAGE).set((false), ((World) world).getServer());
					}
				}
				if ((entity.getDisplayName().getString()).equals("BoxDeity")) {
					{
						boolean _setval = (true);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.BoxDeity = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						String _setval = "Voltic Mode";
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.DojutsuSelectResize = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
				if ((entity.getDisplayName().getString()).equals("TheSirMarcus")) {
					{
						boolean _setval = (true);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.TheSirMarcus = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						String _setval = "Furamingogan";
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.DojutsuSelectResize = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
