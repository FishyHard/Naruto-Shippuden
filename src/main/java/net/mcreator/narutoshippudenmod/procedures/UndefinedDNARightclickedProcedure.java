package net.mcreator.narutoshippudenmod.procedures;

import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.fml.loading.FMLPaths;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.MathHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.narutoshippudenmod.item.WoodDNAReleaseItem;
import net.mcreator.narutoshippudenmod.item.WindDNAItem;
import net.mcreator.narutoshippudenmod.item.WaterDNAReleaseItem;
import net.mcreator.narutoshippudenmod.item.UndefinedDNAItem;
import net.mcreator.narutoshippudenmod.item.TyphoonDNAReleaseItem;
import net.mcreator.narutoshippudenmod.item.SwiftDNAReleaseItem;
import net.mcreator.narutoshippudenmod.item.StormDNAReleaseItem;
import net.mcreator.narutoshippudenmod.item.SteelDNAReleaseItem;
import net.mcreator.narutoshippudenmod.item.SmokeDNAReleaseItem;
import net.mcreator.narutoshippudenmod.item.MagnetDNAReleaseItem;
import net.mcreator.narutoshippudenmod.item.LightningDNAItem;
import net.mcreator.narutoshippudenmod.item.IceDNAReleaseItem;
import net.mcreator.narutoshippudenmod.item.FireDNAReleaseItem;
import net.mcreator.narutoshippudenmod.item.EarthDNAItem;
import net.mcreator.narutoshippudenmod.item.DustDNAReleaseItem;
import net.mcreator.narutoshippudenmod.item.BoneDNAReleaseItem;
import net.mcreator.narutoshippudenmod.item.BoilDNAReleaseItem;
import net.mcreator.narutoshippudenmod.NarutoShippudenMod;

import java.util.Random;
import java.util.Map;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

import com.google.gson.Gson;

public class UndefinedDNARightclickedProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure UndefinedDNARightclicked!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		File NarutoShippuden = new File("");
		com.google.gson.JsonObject mainjsonobject = new com.google.gson.JsonObject();
		Entity shadow = null;
		double randomdna = 0;
		double randomdna2 = 0;
		double random = 0;
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
				randomdna = (MathHelper.nextInt(new Random(), 1, 10));
				if (randomdna <= 5) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You failed to identify DNA"), (false));
					}
				} else if (randomdna >= 6) {
					random = (MathHelper.nextInt(new Random(), 1, 1000));
					if (random >= mainjsonobject.get("dna_kekkei_genkai_identify").getAsDouble() * 10 + 1) {
						randomdna2 = (MathHelper.nextInt(new Random(), 1, 5));
						if (randomdna2 == 1) {
							if (entity instanceof PlayerEntity) {
								ItemStack _setstack = new ItemStack(FireDNAReleaseItem.block);
								_setstack.setCount((int) 1);
								ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
							}
						} else if (randomdna2 == 2) {
							if (entity instanceof PlayerEntity) {
								ItemStack _setstack = new ItemStack(WaterDNAReleaseItem.block);
								_setstack.setCount((int) 1);
								ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
							}
						} else if (randomdna2 == 3) {
							if (entity instanceof PlayerEntity) {
								ItemStack _setstack = new ItemStack(LightningDNAItem.block);
								_setstack.setCount((int) 1);
								ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
							}
						} else if (randomdna2 == 4) {
							if (entity instanceof PlayerEntity) {
								ItemStack _setstack = new ItemStack(WindDNAItem.block);
								_setstack.setCount((int) 1);
								ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
							}
						} else if (randomdna2 == 5) {
							if (entity instanceof PlayerEntity) {
								ItemStack _setstack = new ItemStack(EarthDNAItem.block);
								_setstack.setCount((int) 1);
								ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
							}
						}
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You succesfully identified DNA"), (false));
						}
					} else if (random <= mainjsonobject.get("dna_kekkei_genkai_identify").getAsDouble() * 10) {
						randomkkg = (MathHelper.nextInt(new Random(), 1, 11));
						if (randomkkg == 1) {
							if (entity instanceof PlayerEntity) {
								ItemStack _setstack = new ItemStack(IceDNAReleaseItem.block);
								_setstack.setCount((int) 1);
								ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
							}
						} else if (randomkkg == 2) {
							if (entity instanceof PlayerEntity) {
								ItemStack _setstack = new ItemStack(WoodDNAReleaseItem.block);
								_setstack.setCount((int) 1);
								ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
							}
						} else if (randomkkg == 3) {
							if (entity instanceof PlayerEntity) {
								ItemStack _setstack = new ItemStack(MagnetDNAReleaseItem.block);
								_setstack.setCount((int) 1);
								ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
							}
						} else if (randomkkg == 4) {
							if (entity instanceof PlayerEntity) {
								ItemStack _setstack = new ItemStack(StormDNAReleaseItem.block);
								_setstack.setCount((int) 1);
								ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
							}
						} else if (randomkkg == 5) {
							if (entity instanceof PlayerEntity) {
								ItemStack _setstack = new ItemStack(SmokeDNAReleaseItem.block);
								_setstack.setCount((int) 1);
								ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
							}
						} else if (randomkkg == 6) {
							if (entity instanceof PlayerEntity) {
								ItemStack _setstack = new ItemStack(SteelDNAReleaseItem.block);
								_setstack.setCount((int) 1);
								ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
							}
						} else if (randomkkg == 7) {
							if (entity instanceof PlayerEntity) {
								ItemStack _setstack = new ItemStack(BoilDNAReleaseItem.block);
								_setstack.setCount((int) 1);
								ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
							}
						} else if (randomkkg == 8) {
							if (entity instanceof PlayerEntity) {
								ItemStack _setstack = new ItemStack(BoneDNAReleaseItem.block);
								_setstack.setCount((int) 1);
								ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
							}
						} else if (randomkkg == 9) {
							if (entity instanceof PlayerEntity) {
								ItemStack _setstack = new ItemStack(SwiftDNAReleaseItem.block);
								_setstack.setCount((int) 1);
								ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
							}
						} else if (randomkkg == 10) {
							if (entity instanceof PlayerEntity) {
								ItemStack _setstack = new ItemStack(TyphoonDNAReleaseItem.block);
								_setstack.setCount((int) 1);
								ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
							}
						} else if (randomkkg == 11) {
							if (entity instanceof PlayerEntity) {
								ItemStack _setstack = new ItemStack(DustDNAReleaseItem.block);
								_setstack.setCount((int) 1);
								ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
							}
						}
					}
				}
				if (entity instanceof PlayerEntity) {
					ItemStack _stktoremove = new ItemStack(UndefinedDNAItem.block);
					((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
							((PlayerEntity) entity).container.func_234641_j_());
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
