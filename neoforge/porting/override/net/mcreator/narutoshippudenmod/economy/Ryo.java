package net.mcreator.narutoshippudenmod.economy;

import net.mcreator.narutoshippudenmod.compat.Compat;
import net.mcreator.narutoshippudenmod.item.StuffItems.BronzeRyoItem;
import net.mcreator.narutoshippudenmod.item.StuffItems.GoldRyoItem;
import net.mcreator.narutoshippudenmod.item.StuffItems.SilverRyoItem;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;

import java.util.ArrayList;
import java.util.List;

/** The mod's money: Bronze, Silver and Gold Ryo, 9 of one crafting into 1 of the next (like nuggets and ingots). */
public final class Ryo {
	public static final int SILVER = 9;
	public static final int GOLD = 81;

	private Ryo() {
	}

	/** The fewest coins worth this many Bronze Ryo. */
	public static List<ItemStack> coins(int bronze) {
		List<ItemStack> stacks = new ArrayList<>();
		add(stacks, GoldRyoItem.block, bronze / GOLD);
		add(stacks, SilverRyoItem.block, bronze % GOLD / SILVER);
		add(stacks, BronzeRyoItem.block, bronze % SILVER);
		return stacks;
	}

	private static void add(List<ItemStack> stacks, Item item, int count) {
		for (; count > 0; count -= item.getDefaultMaxStackSize()) {
			stacks.add(new ItemStack(item, Math.min(count, item.getDefaultMaxStackSize())));
		}
	}

	public static void give(Player player, int bronze) {
		for (ItemStack stack : coins(bronze))
			Compat.giveItemToPlayer(player, stack);
	}

	public static void drop(ServerLevel level, Vec3 pos, int bronze) {
		for (ItemStack stack : coins(bronze)) {
			ItemEntity item = new ItemEntity(level, pos.x, pos.y + 0.5, pos.z, stack);
			item.setDefaultPickUpDelay();
			level.addFreshEntity(item);
		}
	}

	/** "2 Gold, 3 Silver" style price text. */
	public static String format(int bronze) {
		List<String> parts = new ArrayList<>();
		if (bronze / GOLD > 0)
			parts.add(bronze / GOLD + " Gold");
		if (bronze % GOLD / SILVER > 0)
			parts.add(bronze % GOLD / SILVER + " Silver");
		if (bronze % SILVER > 0 || parts.isEmpty())
			parts.add(bronze % SILVER + " Bronze");
		return String.join(", ", parts);
	}
}
