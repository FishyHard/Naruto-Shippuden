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
		if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsucheckpricelogic == true) {
			if (!(new Object() {
				public String getText() {
					TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:Jutsu_Name");
					if (_tf != null) {
						return _tf.getText();
					}
					return "";
				}
			}.getText()).equals("")) {
				if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsujpreadybuy == false) {
					if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsurelease).equals("Fire")) {
						if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsutype).equals("Ball")) {
							if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuspeed).equals("Slow")) {
								if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 100) {
									{
										double _setval = 20;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 200) {
									{
										double _setval = 25;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 300) {
									{
										double _setval = 30;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 400) {
									{
										double _setval = 35;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 500) {
									{
										double _setval = 40;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								}
							} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuspeed).equals("Medium")) {
								if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 100) {
									{
										double _setval = 25;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 200) {
									{
										double _setval = 30;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 300) {
									{
										double _setval = 35;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 400) {
									{
										double _setval = 40;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 500) {
									{
										double _setval = 45;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								}
							} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuspeed).equals("Fast")) {
								if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 100) {
									{
										double _setval = 30;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 200) {
									{
										double _setval = 35;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 300) {
									{
										double _setval = 40;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 400) {
									{
										double _setval = 45;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 500) {
									{
										double _setval = 50;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								}
							}
						} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsutype).equals("Wave")) {
							if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuspeed).equals("Slow")) {
								if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 100) {
									{
										double _setval = 25;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 200) {
									{
										double _setval = 30;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 300) {
									{
										double _setval = 35;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 400) {
									{
										double _setval = 40;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 500) {
									{
										double _setval = 45;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								}
							} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuspeed).equals("Medium")) {
								if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 100) {
									{
										double _setval = 30;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 200) {
									{
										double _setval = 35;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 300) {
									{
										double _setval = 40;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 400) {
									{
										double _setval = 45;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 500) {
									{
										double _setval = 50;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								}
							} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuspeed).equals("Fast")) {
								if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 100) {
									{
										double _setval = 35;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 200) {
									{
										double _setval = 40;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 300) {
									{
										double _setval = 45;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 400) {
									{
										double _setval = 50;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 500) {
									{
										double _setval = 55;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								}
							}
						} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsutype).equals("Disk")) {
							if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuspeed).equals("Slow")) {
								if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 100) {
									{
										double _setval = 30;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 200) {
									{
										double _setval = 35;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 300) {
									{
										double _setval = 40;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 400) {
									{
										double _setval = 45;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 500) {
									{
										double _setval = 50;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								}
							} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuspeed).equals("Medium")) {
								if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 100) {
									{
										double _setval = 35;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 200) {
									{
										double _setval = 40;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 300) {
									{
										double _setval = 45;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 400) {
									{
										double _setval = 50;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 500) {
									{
										double _setval = 55;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								}
							} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuspeed).equals("Fast")) {
								if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 100) {
									{
										double _setval = 40;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 200) {
									{
										double _setval = 45;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 300) {
									{
										double _setval = 50;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 400) {
									{
										double _setval = 55;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 500) {
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
					} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsurelease).equals("Wind")) {
						if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsutype).equals("Ball")) {
							if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuspeed).equals("Slow")) {
								if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 100) {
									{
										double _setval = 20;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 200) {
									{
										double _setval = 25;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 300) {
									{
										double _setval = 30;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 400) {
									{
										double _setval = 35;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 500) {
									{
										double _setval = 40;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								}
							} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuspeed).equals("Medium")) {
								if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 100) {
									{
										double _setval = 25;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 200) {
									{
										double _setval = 30;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 300) {
									{
										double _setval = 35;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 400) {
									{
										double _setval = 40;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 500) {
									{
										double _setval = 45;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								}
							} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuspeed).equals("Fast")) {
								if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 100) {
									{
										double _setval = 30;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 200) {
									{
										double _setval = 35;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 300) {
									{
										double _setval = 40;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 500) {
									{
										double _setval = 50;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								}
							}
						} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsutype).equals("Wave")) {
							if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuspeed).equals("Slow")) {
								if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 100) {
									{
										double _setval = 25;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 200) {
									{
										double _setval = 30;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 300) {
									{
										double _setval = 35;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 400) {
									{
										double _setval = 40;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 500) {
									{
										double _setval = 45;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								}
							} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuspeed).equals("Medium")) {
								if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 100) {
									{
										double _setval = 30;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 200) {
									{
										double _setval = 35;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 300) {
									{
										double _setval = 40;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 400) {
									{
										double _setval = 45;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 500) {
									{
										double _setval = 50;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								}
							} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuspeed).equals("Fast")) {
								if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 100) {
									{
										double _setval = 35;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 200) {
									{
										double _setval = 40;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 300) {
									{
										double _setval = 45;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 400) {
									{
										double _setval = 50;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 500) {
									{
										double _setval = 55;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								}
							}
						} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsutype).equals("Disk")) {
							if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuspeed).equals("Slow")) {
								if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 100) {
									{
										double _setval = 30;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 200) {
									{
										double _setval = 35;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 300) {
									{
										double _setval = 40;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 400) {
									{
										double _setval = 45;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 500) {
									{
										double _setval = 50;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								}
							} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuspeed).equals("Medium")) {
								if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 100) {
									{
										double _setval = 35;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 200) {
									{
										double _setval = 40;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 300) {
									{
										double _setval = 45;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 400) {
									{
										double _setval = 50;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 500) {
									{
										double _setval = 55;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								}
							} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuspeed).equals("Fast")) {
								if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 100) {
									{
										double _setval = 40;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 200) {
									{
										double _setval = 45;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 300) {
									{
										double _setval = 50;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 400) {
									{
										double _setval = 55;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 500) {
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
					} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsurelease).equals("Lightning")) {
						if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsutype).equals("Ball")) {
							if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuspeed).equals("Slow")) {
								if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 100) {
									{
										double _setval = 20;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 200) {
									{
										double _setval = 25;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 300) {
									{
										double _setval = 30;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 400) {
									{
										double _setval = 35;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 500) {
									{
										double _setval = 40;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								}
							} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuspeed).equals("Medium")) {
								if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 100) {
									{
										double _setval = 25;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 200) {
									{
										double _setval = 30;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 300) {
									{
										double _setval = 35;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 400) {
									{
										double _setval = 40;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 500) {
									{
										double _setval = 45;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								}
							} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuspeed).equals("Fast")) {
								if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 100) {
									{
										double _setval = 30;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 200) {
									{
										double _setval = 35;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 300) {
									{
										double _setval = 40;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 400) {
									{
										double _setval = 45;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 500) {
									{
										double _setval = 50;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								}
							}
						} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsutype).equals("Wave")) {
							if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuspeed).equals("Slow")) {
								if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 100) {
									{
										double _setval = 25;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 200) {
									{
										double _setval = 30;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 300) {
									{
										double _setval = 35;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 400) {
									{
										double _setval = 40;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 500) {
									{
										double _setval = 45;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								}
							} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuspeed).equals("Medium")) {
								if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 100) {
									{
										double _setval = 30;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 200) {
									{
										double _setval = 35;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 300) {
									{
										double _setval = 40;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 400) {
									{
										double _setval = 45;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 500) {
									{
										double _setval = 50;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								}
							} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuspeed).equals("Fast")) {
								if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 100) {
									{
										double _setval = 35;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 200) {
									{
										double _setval = 40;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 300) {
									{
										double _setval = 45;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 400) {
									{
										double _setval = 50;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 500) {
									{
										double _setval = 55;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								}
							}
						} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsutype).equals("Disk")) {
							if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuspeed).equals("Slow")) {
								if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 100) {
									{
										double _setval = 30;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 200) {
									{
										double _setval = 35;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 300) {
									{
										double _setval = 40;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 400) {
									{
										double _setval = 45;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 500) {
									{
										double _setval = 50;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								}
							} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuspeed).equals("Medium")) {
								if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 100) {
									{
										double _setval = 35;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 200) {
									{
										double _setval = 40;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 300) {
									{
										double _setval = 45;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 400) {
									{
										double _setval = 50;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 500) {
									{
										double _setval = 55;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								}
							} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuspeed).equals("Fast")) {
								if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 100) {
									{
										double _setval = 40;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 200) {
									{
										double _setval = 45;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 300) {
									{
										double _setval = 50;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 400) {
									{
										double _setval = 55;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 500) {
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
					} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsurelease).equals("Water")) {
						if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsutype).equals("Ball")) {
							if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuspeed).equals("Slow")) {
								if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 100) {
									{
										double _setval = 15;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 200) {
									{
										double _setval = 20;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 300) {
									{
										double _setval = 25;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 400) {
									{
										double _setval = 30;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 500) {
									{
										double _setval = 35;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								}
							} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuspeed).equals("Medium")) {
								if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 100) {
									{
										double _setval = 20;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 200) {
									{
										double _setval = 25;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 300) {
									{
										double _setval = 30;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 400) {
									{
										double _setval = 35;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 500) {
									{
										double _setval = 40;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								}
							} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuspeed).equals("Fast")) {
								if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 100) {
									{
										double _setval = 25;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 200) {
									{
										double _setval = 30;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 300) {
									{
										double _setval = 35;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 400) {
									{
										double _setval = 40;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 500) {
									{
										double _setval = 45;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								}
							}
						} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsutype).equals("Wave")) {
							if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuspeed).equals("Slow")) {
								if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 100) {
									{
										double _setval = 20;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 200) {
									{
										double _setval = 25;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 300) {
									{
										double _setval = 30;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 400) {
									{
										double _setval = 35;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 500) {
									{
										double _setval = 40;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								}
							} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuspeed).equals("Medium")) {
								if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 100) {
									{
										double _setval = 25;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 200) {
									{
										double _setval = 30;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 300) {
									{
										double _setval = 35;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 400) {
									{
										double _setval = 40;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 500) {
									{
										double _setval = 45;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								}
							} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuspeed).equals("Fast")) {
								if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 100) {
									{
										double _setval = 30;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 200) {
									{
										double _setval = 35;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 300) {
									{
										double _setval = 40;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 400) {
									{
										double _setval = 45;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 500) {
									{
										double _setval = 50;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								}
							}
						} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsutype).equals("Disk")) {
							if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuspeed).equals("Slow")) {
								if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 100) {
									{
										double _setval = 25;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 200) {
									{
										double _setval = 30;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 300) {
									{
										double _setval = 35;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 400) {
									{
										double _setval = 40;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 500) {
									{
										double _setval = 45;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								}
							} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuspeed).equals("Medium")) {
								if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 100) {
									{
										double _setval = 30;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 200) {
									{
										double _setval = 35;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 300) {
									{
										double _setval = 40;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 400) {
									{
										double _setval = 45;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 500) {
									{
										double _setval = 50;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								}
							} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuspeed).equals("Fast")) {
								if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 100) {
									{
										double _setval = 35;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 200) {
									{
										double _setval = 40;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 300) {
									{
										double _setval = 45;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 400) {
									{
										double _setval = 50;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 500) {
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
					} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsurelease).equals("Earth")) {
						if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsutype).equals("Ball")) {
							if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuspeed).equals("Slow")) {
								if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 100) {
									{
										double _setval = 15;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 200) {
									{
										double _setval = 20;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 300) {
									{
										double _setval = 25;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 400) {
									{
										double _setval = 30;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 500) {
									{
										double _setval = 35;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								}
							} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuspeed).equals("Medium")) {
								if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 100) {
									{
										double _setval = 20;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 200) {
									{
										double _setval = 25;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 300) {
									{
										double _setval = 30;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 400) {
									{
										double _setval = 35;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 500) {
									{
										double _setval = 40;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								}
							} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuspeed).equals("Fast")) {
								if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 100) {
									{
										double _setval = 25;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 200) {
									{
										double _setval = 30;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 300) {
									{
										double _setval = 35;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 400) {
									{
										double _setval = 40;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 500) {
									{
										double _setval = 45;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								}
							}
						} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsutype).equals("Wave")) {
							if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuspeed).equals("Slow")) {
								if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 100) {
									{
										double _setval = 20;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 200) {
									{
										double _setval = 25;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 300) {
									{
										double _setval = 30;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 400) {
									{
										double _setval = 35;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 500) {
									{
										double _setval = 40;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								}
							} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuspeed).equals("Medium")) {
								if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 100) {
									{
										double _setval = 25;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 200) {
									{
										double _setval = 30;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 300) {
									{
										double _setval = 35;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 400) {
									{
										double _setval = 40;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 500) {
									{
										double _setval = 45;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								}
							} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuspeed).equals("Fast")) {
								if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 100) {
									{
										double _setval = 30;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 200) {
									{
										double _setval = 35;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 300) {
									{
										double _setval = 40;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 400) {
									{
										double _setval = 45;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 500) {
									{
										double _setval = 50;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								}
							}
						} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsutype).equals("Disk")) {
							if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuspeed).equals("Slow")) {
								if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 100) {
									{
										double _setval = 25;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 200) {
									{
										double _setval = 30;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 300) {
									{
										double _setval = 35;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 400) {
									{
										double _setval = 40;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 500) {
									{
										double _setval = 45;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								}
							} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuspeed).equals("Medium")) {
								if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 100) {
									{
										double _setval = 30;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 200) {
									{
										double _setval = 35;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 300) {
									{
										double _setval = 40;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 400) {
									{
										double _setval = 45;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 500) {
									{
										double _setval = 50;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								}
							} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuspeed).equals("Fast")) {
								if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 100) {
									{
										double _setval = 35;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 200) {
									{
										double _setval = 40;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 300) {
									{
										double _setval = 45;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 400) {
									{
										double _setval = 50;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.customjutsujpcost = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra == 500) {
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
						String _setval = ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsutype);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.customjutsutypesave = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						String _setval = ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuspeed);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.customjutsuspeedsave = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						String _setval = ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsurelease);
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
						double _setval = ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakra);
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
				} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsujpreadybuy == true) {
					if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoShippudenModVariables.PlayerVariables())).jp >= (entity
									.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsujpcost) {
						{
							double _setval = ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NarutoShippudenModVariables.PlayerVariables())).jp
									- (entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsujpcost);
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.jp = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity)
									.sendStatusMessage(
											new StringTextComponent(
													("-" + (entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
															.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsujpcost + " JP")),
											(false));
						}
						{
							String _setval = ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsutypesave);
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.customjutsutype1save = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							String _setval = ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuspeedsave);
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.customjutsuspeed1save = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							String _setval = ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsureleasesave);
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.customjutsurelease1save = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							String _setval = ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NarutoShippudenModVariables.PlayerVariables())).jutsunamesave);
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.jutsunamesave1 = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsuchakrasave);
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
						if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsureleasesave).equals("Fire")) {
							customjutsuname = new ItemStack(CustomFireReleaseTechniqueItem.block);
							((customjutsuname)).setDisplayName(new StringTextComponent(
									("Fire Release: " + (entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new NarutoShippudenModVariables.PlayerVariables())).jutsunamesave1)));
							if (entity instanceof PlayerEntity) {
								ItemStack _setstack = (customjutsuname);
								_setstack.setCount((int) 1);
								ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
							}
						} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsureleasesave).equals("Lightning")) {
							customjutsuname = new ItemStack(CustomLightningReleaseTechniqueItem.block);
							((customjutsuname)).setDisplayName(new StringTextComponent(
									("Lightning Release: " + (entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new NarutoShippudenModVariables.PlayerVariables())).jutsunamesave1)));
							if (entity instanceof PlayerEntity) {
								ItemStack _setstack = (customjutsuname);
								_setstack.setCount((int) 1);
								ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
							}
						} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsureleasesave).equals("Wind")) {
							customjutsuname = new ItemStack(CustomWindReleaseTechniqueItem.block);
							((customjutsuname)).setDisplayName(new StringTextComponent(
									("Wind Release: " + (entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new NarutoShippudenModVariables.PlayerVariables())).jutsunamesave1)));
							if (entity instanceof PlayerEntity) {
								ItemStack _setstack = (customjutsuname);
								_setstack.setCount((int) 1);
								ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
							}
						} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsureleasesave).equals("Water")) {
							customjutsuname = new ItemStack(CustomWaterReleaseTechniqueItem.block);
							((customjutsuname)).setDisplayName(new StringTextComponent(
									("Water Release: " + (entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new NarutoShippudenModVariables.PlayerVariables())).jutsunamesave1)));
							if (entity instanceof PlayerEntity) {
								ItemStack _setstack = (customjutsuname);
								_setstack.setCount((int) 1);
								ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
							}
						} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsureleasesave).equals("Earth")) {
							customjutsuname = new ItemStack(CustomEarthReleaseTechniqueItem.block);
							((customjutsuname)).setDisplayName(new StringTextComponent(
									("Earth Release: " + (entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new NarutoShippudenModVariables.PlayerVariables())).jutsunamesave1)));
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
					} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoShippudenModVariables.PlayerVariables())).jp <= (entity
									.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsujpcost - 1) {
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
		} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).customjutsucheckpricelogic == false) {
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Check price first of all"), (false));
			}
		}
	}
}
