package net.mcreator.narutoshippudenmod.procedures;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.client.gui.widget.TextFieldWidget;

import net.mcreator.narutoshippudenmod.item.CustomWindReleaseTechniqueItem;
import net.mcreator.narutoshippudenmod.item.CustomWaterReleaseTechniqueItem;
import net.mcreator.narutoshippudenmod.item.CustomLightningReleaseTechniqueItem;
import net.mcreator.narutoshippudenmod.item.CustomFireReleaseTechniqueItem;
import net.mcreator.narutoshippudenmod.item.CustomEarthReleaseTechniqueItem;
import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables;
import net.mcreator.narutoshippudenmod.NarutoShippudenMod;

import java.util.Map;
import java.util.HashMap;

public class LearnCustomJutsu1Procedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure LearnCustomJutsu1!");
			return;
		}
		if (dependencies.get("guistate") == null) {
			if (!dependencies.containsKey("guistate"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency guistate for procedure LearnCustomJutsu1!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		HashMap guistate = (HashMap) dependencies.get("guistate");
		ItemStack customjutsuname = ItemStack.EMPTY;
		if (NarutoShippudenModVariables.get(entity).customjutsucheckpricelogic == true) {
			if (!(new Object() {
				public String getText() {
					TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:Jutsu_Name");
					if (_tf != null) {
						return _tf.getText();
					}
					return "";
				}
			}.getText()).equals("")) {
				if (NarutoShippudenModVariables.get(entity).customjutsujpreadybuy == false) {
					if ((NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Fire")) {
						if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Ball")) {
							if ((NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Slow")) {
								if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
									{
										double _setval = 20;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
									{
										double _setval = 25;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
									{
										double _setval = 30;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
									{
										double _setval = 35;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
									{
										double _setval = 40;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								}
							} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Medium")) {
								if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
									{
										double _setval = 25;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
									{
										double _setval = 30;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
									{
										double _setval = 35;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
									{
										double _setval = 40;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
									{
										double _setval = 45;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								}
							} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Fast")) {
								if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
									{
										double _setval = 30;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
									{
										double _setval = 35;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
									{
										double _setval = 40;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
									{
										double _setval = 45;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
									{
										double _setval = 50;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								}
							}
						} else if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Wave")) {
							if ((NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Slow")) {
								if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
									{
										double _setval = 25;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
									{
										double _setval = 30;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
									{
										double _setval = 35;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
									{
										double _setval = 40;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
									{
										double _setval = 45;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								}
							} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Medium")) {
								if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
									{
										double _setval = 30;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
									{
										double _setval = 35;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
									{
										double _setval = 40;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
									{
										double _setval = 45;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
									{
										double _setval = 50;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								}
							} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Fast")) {
								if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
									{
										double _setval = 35;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
									{
										double _setval = 40;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
									{
										double _setval = 45;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
									{
										double _setval = 50;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
									{
										double _setval = 55;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								}
							}
						} else if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Disk")) {
							if ((NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Slow")) {
								if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
									{
										double _setval = 30;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
									{
										double _setval = 35;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
									{
										double _setval = 40;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
									{
										double _setval = 45;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
									{
										double _setval = 50;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								}
							} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Medium")) {
								if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
									{
										double _setval = 35;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
									{
										double _setval = 40;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
									{
										double _setval = 45;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
									{
										double _setval = 50;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
									{
										double _setval = 55;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								}
							} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Fast")) {
								if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
									{
										double _setval = 40;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
									{
										double _setval = 45;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
									{
										double _setval = 50;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
									{
										double _setval = 55;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
									{
										double _setval = 60;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								}
							}
						}
						{
							boolean _setval = (true);
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.customjutsufire = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					} else if ((NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Wind")) {
						if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Ball")) {
							if ((NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Slow")) {
								if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
									{
										double _setval = 20;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
									{
										double _setval = 25;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
									{
										double _setval = 30;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
									{
										double _setval = 35;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
									{
										double _setval = 40;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								}
							} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Medium")) {
								if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
									{
										double _setval = 25;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
									{
										double _setval = 30;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
									{
										double _setval = 35;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
									{
										double _setval = 40;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
									{
										double _setval = 45;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								}
							} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Fast")) {
								if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
									{
										double _setval = 30;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
									{
										double _setval = 35;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
									{
										double _setval = 40;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
									{
										double _setval = 50;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								}
							}
						} else if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Wave")) {
							if ((NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Slow")) {
								if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
									{
										double _setval = 25;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
									{
										double _setval = 30;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
									{
										double _setval = 35;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
									{
										double _setval = 40;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
									{
										double _setval = 45;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								}
							} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Medium")) {
								if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
									{
										double _setval = 30;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
									{
										double _setval = 35;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
									{
										double _setval = 40;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
									{
										double _setval = 45;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
									{
										double _setval = 50;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								}
							} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Fast")) {
								if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
									{
										double _setval = 35;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
									{
										double _setval = 40;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
									{
										double _setval = 45;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
									{
										double _setval = 50;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
									{
										double _setval = 55;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								}
							}
						} else if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Disk")) {
							if ((NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Slow")) {
								if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
									{
										double _setval = 30;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
									{
										double _setval = 35;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
									{
										double _setval = 40;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
									{
										double _setval = 45;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
									{
										double _setval = 50;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								}
							} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Medium")) {
								if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
									{
										double _setval = 35;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
									{
										double _setval = 40;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
									{
										double _setval = 45;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
									{
										double _setval = 50;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
									{
										double _setval = 55;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								}
							} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Fast")) {
								if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
									{
										double _setval = 40;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
									{
										double _setval = 45;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
									{
										double _setval = 50;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
									{
										double _setval = 55;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
									{
										double _setval = 60;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								}
							}
						}
						{
							boolean _setval = (true);
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.customjutsuwind = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					} else if ((NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Lightning")) {
						if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Ball")) {
							if ((NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Slow")) {
								if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
									{
										double _setval = 20;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
									{
										double _setval = 25;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
									{
										double _setval = 30;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
									{
										double _setval = 35;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
									{
										double _setval = 40;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								}
							} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Medium")) {
								if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
									{
										double _setval = 25;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
									{
										double _setval = 30;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
									{
										double _setval = 35;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
									{
										double _setval = 40;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
									{
										double _setval = 45;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								}
							} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Fast")) {
								if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
									{
										double _setval = 30;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
									{
										double _setval = 35;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
									{
										double _setval = 40;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
									{
										double _setval = 45;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
									{
										double _setval = 50;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								}
							}
						} else if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Wave")) {
							if ((NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Slow")) {
								if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
									{
										double _setval = 25;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
									{
										double _setval = 30;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
									{
										double _setval = 35;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
									{
										double _setval = 40;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
									{
										double _setval = 45;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								}
							} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Medium")) {
								if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
									{
										double _setval = 30;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
									{
										double _setval = 35;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
									{
										double _setval = 40;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
									{
										double _setval = 45;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
									{
										double _setval = 50;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								}
							} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Fast")) {
								if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
									{
										double _setval = 35;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
									{
										double _setval = 40;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
									{
										double _setval = 45;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
									{
										double _setval = 50;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
									{
										double _setval = 55;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								}
							}
						} else if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Disk")) {
							if ((NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Slow")) {
								if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
									{
										double _setval = 30;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
									{
										double _setval = 35;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
									{
										double _setval = 40;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
									{
										double _setval = 45;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
									{
										double _setval = 50;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								}
							} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Medium")) {
								if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
									{
										double _setval = 35;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
									{
										double _setval = 40;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
									{
										double _setval = 45;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
									{
										double _setval = 50;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
									{
										double _setval = 55;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								}
							} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Fast")) {
								if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
									{
										double _setval = 40;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
									{
										double _setval = 45;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
									{
										double _setval = 50;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
									{
										double _setval = 55;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
									{
										double _setval = 60;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								}
							}
						}
						{
							boolean _setval = (true);
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.customjutsulightning = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					} else if ((NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Water")) {
						if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Ball")) {
							if ((NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Slow")) {
								if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
									{
										double _setval = 15;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
									{
										double _setval = 20;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
									{
										double _setval = 25;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
									{
										double _setval = 30;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
									{
										double _setval = 35;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								}
							} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Medium")) {
								if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
									{
										double _setval = 20;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
									{
										double _setval = 25;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
									{
										double _setval = 30;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
									{
										double _setval = 35;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
									{
										double _setval = 40;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								}
							} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Fast")) {
								if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
									{
										double _setval = 25;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
									{
										double _setval = 30;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
									{
										double _setval = 35;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
									{
										double _setval = 40;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
									{
										double _setval = 45;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								}
							}
						} else if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Wave")) {
							if ((NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Slow")) {
								if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
									{
										double _setval = 20;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
									{
										double _setval = 25;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
									{
										double _setval = 30;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
									{
										double _setval = 35;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
									{
										double _setval = 40;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								}
							} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Medium")) {
								if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
									{
										double _setval = 25;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
									{
										double _setval = 30;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
									{
										double _setval = 35;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
									{
										double _setval = 40;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
									{
										double _setval = 45;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								}
							} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Fast")) {
								if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
									{
										double _setval = 30;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
									{
										double _setval = 35;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
									{
										double _setval = 40;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
									{
										double _setval = 45;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
									{
										double _setval = 50;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								}
							}
						} else if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Disk")) {
							if ((NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Slow")) {
								if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
									{
										double _setval = 25;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
									{
										double _setval = 30;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
									{
										double _setval = 35;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
									{
										double _setval = 40;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
									{
										double _setval = 45;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								}
							} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Medium")) {
								if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
									{
										double _setval = 30;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
									{
										double _setval = 35;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
									{
										double _setval = 40;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
									{
										double _setval = 45;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
									{
										double _setval = 50;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								}
							} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Fast")) {
								if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
									{
										double _setval = 35;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
									{
										double _setval = 40;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
									{
										double _setval = 45;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
									{
										double _setval = 50;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
									{
										double _setval = 55;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								}
							}
						}
						{
							boolean _setval = (true);
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.customjutsuwater = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					} else if ((NarutoShippudenModVariables.get(entity).customjutsurelease).equals("Earth")) {
						if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Ball")) {
							if ((NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Slow")) {
								if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
									{
										double _setval = 15;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
									{
										double _setval = 20;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
									{
										double _setval = 25;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
									{
										double _setval = 30;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
									{
										double _setval = 35;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								}
							} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Medium")) {
								if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
									{
										double _setval = 20;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
									{
										double _setval = 25;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
									{
										double _setval = 30;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
									{
										double _setval = 35;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
									{
										double _setval = 40;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								}
							} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Fast")) {
								if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
									{
										double _setval = 25;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
									{
										double _setval = 30;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
									{
										double _setval = 35;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
									{
										double _setval = 40;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
									{
										double _setval = 45;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								}
							}
						} else if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Wave")) {
							if ((NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Slow")) {
								if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
									{
										double _setval = 20;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
									{
										double _setval = 25;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
									{
										double _setval = 30;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
									{
										double _setval = 35;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
									{
										double _setval = 40;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								}
							} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Medium")) {
								if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
									{
										double _setval = 25;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
									{
										double _setval = 30;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
									{
										double _setval = 35;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
									{
										double _setval = 40;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
									{
										double _setval = 45;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								}
							} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Fast")) {
								if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
									{
										double _setval = 30;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
									{
										double _setval = 35;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
									{
										double _setval = 40;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
									{
										double _setval = 45;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
									{
										double _setval = 50;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								}
							}
						} else if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Disk")) {
							if ((NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Slow")) {
								if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
									{
										double _setval = 25;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
									{
										double _setval = 30;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
									{
										double _setval = 35;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
									{
										double _setval = 40;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
									{
										double _setval = 45;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								}
							} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Medium")) {
								if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
									{
										double _setval = 30;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
									{
										double _setval = 35;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
									{
										double _setval = 40;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
									{
										double _setval = 45;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
									{
										double _setval = 50;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								}
							} else if ((NarutoShippudenModVariables.get(entity).customjutsuspeed).equals("Fast")) {
								if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 100) {
									{
										double _setval = 35;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 200) {
									{
										double _setval = 40;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 300) {
									{
										double _setval = 45;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 400) {
									{
										double _setval = 50;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).customjutsuchakra == 500) {
									{
										double _setval = 55;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								}
							}
						}
						{
							boolean _setval = (true);
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.customjutsuearth = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
					{
						String _setval = (NarutoShippudenModVariables.get(entity).customjutsutype);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.customjutsutypesave = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						String _setval = (NarutoShippudenModVariables.get(entity).customjutsuspeed);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.customjutsuspeedsave = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						String _setval = (NarutoShippudenModVariables.get(entity).customjutsurelease);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.customjutsureleasesave = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						String _setval = (new Object() {
							public String getText() {
								TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:Jutsu_Name");
								if (_tf != null) {
									return _tf.getText();
								}
								return "";
							}
						}.getText());
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.jutsunamesave = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).customjutsuchakra);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.customjutsuchakrasave = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						boolean _setval = (true);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.customjutsujpreadybuy = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Press Learn button again"), (false));
					}
				} else if (NarutoShippudenModVariables.get(entity).customjutsujpreadybuy == true) {
					if (NarutoShippudenModVariables.get(entity).jp >= NarutoShippudenModVariables.get(entity).customjutsujpcost) {
						{
							double _setval = (NarutoShippudenModVariables.get(entity).jp
									- NarutoShippudenModVariables.get(entity).customjutsujpcost);
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.jp = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity)
									.sendStatusMessage(
											new StringTextComponent(
													("-" + NarutoShippudenModVariables.get(entity).customjutsujpcost + " JP")),
											(false));
						}
						{
							String _setval = (NarutoShippudenModVariables.get(entity).customjutsutypesave);
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.customjutsutype1save = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							String _setval = (NarutoShippudenModVariables.get(entity).customjutsuspeedsave);
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.customjutsuspeed1save = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							String _setval = (NarutoShippudenModVariables.get(entity).customjutsureleasesave);
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.customjutsurelease1save = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							String _setval = (NarutoShippudenModVariables.get(entity).jutsunamesave);
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.jutsunamesave1 = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = (NarutoShippudenModVariables.get(entity).customjutsuchakrasave);
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.customjutsuchakra1save = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							boolean _setval = (false);
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.customjutsujpreadybuy = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if ((NarutoShippudenModVariables.get(entity).customjutsureleasesave).equals("Fire")) {
							customjutsuname = new ItemStack(CustomFireReleaseTechniqueItem.block);
							((customjutsuname)).setDisplayName(new StringTextComponent(
									("Fire Release: " + NarutoShippudenModVariables.get(entity).jutsunamesave1)));
							if (entity instanceof PlayerEntity) {
								ItemStack _setstack = (customjutsuname);
								_setstack.setCount((int) 1);
								ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
							}
						} else if ((NarutoShippudenModVariables.get(entity).customjutsureleasesave).equals("Lightning")) {
							customjutsuname = new ItemStack(CustomLightningReleaseTechniqueItem.block);
							((customjutsuname)).setDisplayName(new StringTextComponent(
									("Lightning Release: " + NarutoShippudenModVariables.get(entity).jutsunamesave1)));
							if (entity instanceof PlayerEntity) {
								ItemStack _setstack = (customjutsuname);
								_setstack.setCount((int) 1);
								ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
							}
						} else if ((NarutoShippudenModVariables.get(entity).customjutsureleasesave).equals("Wind")) {
							customjutsuname = new ItemStack(CustomWindReleaseTechniqueItem.block);
							((customjutsuname)).setDisplayName(new StringTextComponent(
									("Wind Release: " + NarutoShippudenModVariables.get(entity).jutsunamesave1)));
							if (entity instanceof PlayerEntity) {
								ItemStack _setstack = (customjutsuname);
								_setstack.setCount((int) 1);
								ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
							}
						} else if ((NarutoShippudenModVariables.get(entity).customjutsureleasesave).equals("Water")) {
							customjutsuname = new ItemStack(CustomWaterReleaseTechniqueItem.block);
							((customjutsuname)).setDisplayName(new StringTextComponent(
									("Water Release: " + NarutoShippudenModVariables.get(entity).jutsunamesave1)));
							if (entity instanceof PlayerEntity) {
								ItemStack _setstack = (customjutsuname);
								_setstack.setCount((int) 1);
								ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
							}
						} else if ((NarutoShippudenModVariables.get(entity).customjutsureleasesave).equals("Earth")) {
							customjutsuname = new ItemStack(CustomEarthReleaseTechniqueItem.block);
							((customjutsuname)).setDisplayName(new StringTextComponent(
									("Earth Release: " + NarutoShippudenModVariables.get(entity).jutsunamesave1)));
							if (entity instanceof PlayerEntity) {
								ItemStack _setstack = (customjutsuname);
								_setstack.setCount((int) 1);
								ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
							}
						}
						{
							boolean _setval = (true);
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.customjutsu1learn = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).closeScreen();
					} else if (NarutoShippudenModVariables.get(entity).jp <= NarutoShippudenModVariables.get(entity).customjutsujpcost - 1) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough JP"), (false));
						}
						{
							boolean _setval = (false);
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.customjutsujpreadybuy = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
				}
			} else if ((new Object() {
				public String getText() {
					TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:Jutsu_Name");
					if (_tf != null) {
						return _tf.getText();
					}
					return "";
				}
			}.getText()).equals("")) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Name your jutsu"), (false));
				}
			}
		} else if (NarutoShippudenModVariables.get(entity).customjutsucheckpricelogic == false) {
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Check price first of all"), (false));
			}
		}
	}
}
