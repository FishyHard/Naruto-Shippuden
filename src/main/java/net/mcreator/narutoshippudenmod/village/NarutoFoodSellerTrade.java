
package net.mcreator.narutoshippudenmod.village;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.common.BasicTrade;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.merchant.villager.VillagerTrades;
import net.minecraft.entity.merchant.villager.VillagerProfession;

import net.mcreator.narutoshippudenmod.item.IchirakuRamenItem;
import net.mcreator.narutoshippudenmod.item.BanknoteOfRyoItem;

import java.util.List;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class NarutoFoodSellerTrade {
	@SubscribeEvent
	public static void registerTrades(VillagerTradesEvent event) {
		Int2ObjectMap<List<VillagerTrades.ITrade>> trades = event.getTrades();
		if (event.getType() == VillagerProfession.FARMER) {
			trades.get(1)
					.add(new BasicTrade(new ItemStack(BanknoteOfRyoItem.block, (int) (2)), new ItemStack(IchirakuRamenItem.block), 10, 2, 0.05f));
		}
	}
}
