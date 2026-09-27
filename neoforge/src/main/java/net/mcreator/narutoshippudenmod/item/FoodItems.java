package net.mcreator.narutoshippudenmod.item;

import net.minecraft.core.registries.Registries;
import net.mcreator.narutoshippudenmod.compat.Registration;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import net.mcreator.narutoshippudenmod.NarutoShippudenModElements;
import net.mcreator.narutoshippudenmod.itemgroup.ModItemGroups.FoodItemGroup;
import net.mcreator.narutoshippudenmod.procedures.GiftProcedures.AdventCalendarRightclickedProcedure;
import net.mcreator.narutoshippudenmod.procedures.GiftProcedures.ChristmasRamenPlayerFinishesUsingItemProcedure;
import net.mcreator.narutoshippudenmod.procedures.GiftProcedures.GingerbreadPlayerFinishesUsingItemProcedure;
import net.mcreator.narutoshippudenmod.procedures.MissionAndCommandProcedures.IchirakuRamenPlayerFinishesUsingItemProcedure;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemUseAnimation;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;


public final class FoodItems {
	private FoodItems() {
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class AdventCalendarItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "advent_calendar", v -> block = (Item) v);
		}

		public AdventCalendarItem(NarutoShippudenModElements instance) {
			super(instance, 843);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("advent_calendar", null).stacksTo(1).rarity(Rarity.EPIC));
			}

			@Override
			public ItemUseAnimation getUseAnimation(ItemStack itemstack) {
				return ItemUseAnimation.EAT;
			}

			@Override
			public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
				return 1F;
			}

			@Override
			public InteractionResult use(Level world, Player entity, InteractionHand hand) {
				InteractionResult ar = super.use(world, entity, hand);
				ItemStack itemstack = entity.getItemInHand(hand);
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();

				AdventCalendarRightclickedProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z), new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class ChristmasRamenItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "christmas_ramen", v -> block = (Item) v);
		}

		public ChristmasRamenItem(NarutoShippudenModElements instance) {
			super(instance, 871);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("christmas_ramen", null).stacksTo(16).rarity(Rarity.EPIC).food((new FoodProperties.Builder()).nutrition(15).saturationModifier(0.3f).build()));
			}

			@Override
			public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
				return 1F;
			}

			@Override
			public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
				ItemStack retval = super.finishUsingItem(itemstack, world, entity);
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();

				ChristmasRamenPlayerFinishesUsingItemProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return retval;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class GingerbreadItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "gingerbread", v -> block = (Item) v);
		}

		public GingerbreadItem(NarutoShippudenModElements instance) {
			super(instance, 873);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("gingerbread", null).stacksTo(16).rarity(Rarity.EPIC).food((new FoodProperties.Builder()).nutrition(15).saturationModifier(0.3f).build()));
			}

			@Override
			public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
				return 1F;
			}

			@Override
			public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
				ItemStack retval = super.finishUsingItem(itemstack, world, entity);
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();

				GingerbreadPlayerFinishesUsingItemProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return retval;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class IchirakuRamenItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "ichiraku_ramen", v -> block = (Item) v);
		}

		public IchirakuRamenItem(NarutoShippudenModElements instance) {
			super(instance, 85);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("ichiraku_ramen", "FoodItemGroup").stacksTo(64).rarity(Rarity.EPIC)
						.food((new FoodProperties.Builder()).nutrition(15).saturationModifier(0.3f).build()));
			}

			@Override
			public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
				return 1F;
			}

			@Override
			public void appendHoverText(ItemStack itemstack, Item.TooltipContext world, net.minecraft.world.item.component.TooltipDisplay display, java.util.function.Consumer<Component> list, TooltipFlag flag) {
				super.appendHoverText(itemstack, world, display, list, flag);
				list.accept(Component.literal("The best food agreed by the 7th Hokage Naruto Uzumaki."));
			}

			@Override
			public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
				ItemStack retval = super.finishUsingItem(itemstack, world, entity);
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();

				IchirakuRamenPlayerFinishesUsingItemProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return retval;
			}
		}
	}
}
