package net.mcreator.narutoshippudenmod.story;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.trading.ItemCost;
import net.minecraft.world.item.trading.Merchant;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.item.trading.MerchantOffers;

import java.util.Optional;

import org.jspecify.annotations.Nullable;

/**
 * A story character's shop (Teuchi's ramen): the vanilla trading screen, opened from their dialogue, with the offers their
 * character file lists: "shop": {"line": the player's choice that opens it, "offers": [{"wants": [{"id", "count"}, ...]
 * (one or two), "gives": {"id", "count"}, "max_uses"}]}. A shop opens fresh each time, so it never runs out.
 */
public final class StoryShop implements Merchant {
	private final StoryNpc.Npc npc;
	private MerchantOffers offers;
	private @Nullable Player trading;

	private StoryShop(StoryNpc.Npc npc, MerchantOffers offers) {
		this.npc = npc;
		this.offers = offers;
	}

	public static void open(ServerPlayer player, StoryNpc.Npc npc, Story.Character character) {
		MerchantOffers offers = new MerchantOffers();
		for (JsonElement e : character.shop().getAsJsonArray("offers")) {
			JsonObject o = e.getAsJsonObject();
			var wants = o.getAsJsonArray("wants");
			ItemCost a = cost(wants.get(0).getAsJsonObject());
			Optional<ItemCost> b = wants.size() > 1 ? Optional.of(cost(wants.get(1).getAsJsonObject())) : Optional.empty();
			ItemStack gives = new ItemStack(item(o.getAsJsonObject("gives")), count(o.getAsJsonObject("gives")));
			offers.add(new MerchantOffer(a, b, gives, o.has("max_uses") ? o.get("max_uses").getAsInt() : 64, 0, 0));
		}
		StoryShop shop = new StoryShop(npc, offers);
		shop.setTradingPlayer(player);
		shop.openTradingScreen(player, Component.literal(character.name()), 0);
	}

	private static Item item(JsonObject o) {
		return BuiltInRegistries.ITEM.getValue(Identifier.parse(o.get("id").getAsString()));
	}

	private static int count(JsonObject o) {
		return o.has("count") ? o.get("count").getAsInt() : 1;
	}

	private static ItemCost cost(JsonObject o) {
		return new ItemCost(item(o), count(o));
	}

	@Override
	public void setTradingPlayer(@Nullable Player player) {
		trading = player;
	}

	@Override
	public @Nullable Player getTradingPlayer() {
		return trading;
	}

	@Override
	public MerchantOffers getOffers() {
		return offers;
	}

	@Override
	public void overrideOffers(MerchantOffers offers) {
		this.offers = offers;
	}

	@Override
	public void notifyTrade(MerchantOffer offer) {
		offer.increaseUses();
		npc.level().playSound(null, npc.blockPosition(), SoundEvents.VILLAGER_YES, SoundSource.NEUTRAL, 0.6F, 1.0F);
	}

	@Override
	public void notifyTradeUpdated(ItemStack itemStack) {
	}

	@Override
	public int getVillagerXp() {
		return 0;
	}

	@Override
	public void overrideXp(int xp) {
	}

	@Override
	public boolean showProgressBar() {
		return false;
	}

	@Override
	public SoundEvent getNotifyTradeSound() {
		return SoundEvents.VILLAGER_YES;
	}

	@Override
	public boolean isClientSide() {
		return false;
	}

	@Override
	public boolean stillValid(Player player) {
		return trading == player && npc.isAlive() && player.distanceToSqr(npc) < 8 * 8;
	}
}
