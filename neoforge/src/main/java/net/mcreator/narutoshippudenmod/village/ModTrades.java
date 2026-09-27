package net.mcreator.narutoshippudenmod.village;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import java.util.List;
import net.mcreator.narutoshippudenmod.item.FoodItems.IchirakuRamenItem;
import net.mcreator.narutoshippudenmod.item.StuffItems.BanknoteOfRyoItem;
import net.mcreator.narutoshippudenmod.item.StuffItems.WadOfRyoItem;
import net.mcreator.narutoshippudenmod.item.WeaponItems.ChakraBladeItem;
import net.minecraft.world.entity.npc.villager.VillagerProfession;
import net.minecraft.world.item.trading.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;


import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;

public final class ModTrades {
	private ModTrades() {
	}

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
	public static class NarutoBladerTrade {
		@SubscribeEvent
		public static void registerTrades(VillagerTradesEvent event) {
			Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
			if (event.getType() == VillagerProfession.WEAPONSMITH) {
				trades.get(1).add(new BasicTrade(new ItemStack(WadOfRyoItem.block), new ItemStack(Items.IRON_INGOT, (int) (20)),
						new ItemStack(ChakraBladeItem.block), 1, 7, 0.05f));
			}
		}
	}

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
	public static class NarutoFoodSellerTrade {
		@SubscribeEvent
		public static void registerTrades(VillagerTradesEvent event) {
			Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
			if (event.getType() == VillagerProfession.FARMER) {
				trades.get(1)
						.add(new BasicTrade(new ItemStack(BanknoteOfRyoItem.block, (int) (2)), new ItemStack(IchirakuRamenItem.block), 10, 2, 0.05f));
			}
		}
	}
}
