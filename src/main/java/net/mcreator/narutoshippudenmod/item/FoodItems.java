package net.mcreator.narutoshippudenmod.item;

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
import net.minecraft.block.BlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.item.UseAction;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.registries.ObjectHolder;

public final class FoodItems {
	private FoodItems() {
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class AdventCalendarItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:advent_calendar")
		public static final Item block = null;

		public AdventCalendarItem(NarutoShippudenModElements instance) {
			super(instance, 843);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(new Item.Properties().group(null).maxStackSize(1).rarity(Rarity.EPIC));
				setRegistryName("advent_calendar");
			}

			@Override
			public UseAction getUseAction(ItemStack itemstack) {
				return UseAction.EAT;
			}

			@Override
			public int getItemEnchantability() {
				return 0;
			}

			@Override
			public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
				return 1F;
			}

			@Override
			public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
				ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
				ItemStack itemstack = ar.getResult();
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();

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
		@ObjectHolder("naruto_shippuden:christmas_ramen")
		public static final Item block = null;

		public ChristmasRamenItem(NarutoShippudenModElements instance) {
			super(instance, 871);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(new Item.Properties().group(null).maxStackSize(16).rarity(Rarity.EPIC).food((new Food.Builder()).hunger(15).saturation(0.3f)

						.meat().build()));
				setRegistryName("christmas_ramen");
			}

			@Override
			public int getItemEnchantability() {
				return 0;
			}

			@Override
			public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
				return 1F;
			}

			@Override
			public ItemStack onItemUseFinish(ItemStack itemstack, World world, LivingEntity entity) {
				ItemStack retval = super.onItemUseFinish(itemstack, world, entity);
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();

				ChristmasRamenPlayerFinishesUsingItemProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return retval;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class GingerbreadItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:gingerbread")
		public static final Item block = null;

		public GingerbreadItem(NarutoShippudenModElements instance) {
			super(instance, 873);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(new Item.Properties().group(null).maxStackSize(16).rarity(Rarity.EPIC).food((new Food.Builder()).hunger(15).saturation(0.3f)

						.meat().build()));
				setRegistryName("gingerbread");
			}

			@Override
			public int getItemEnchantability() {
				return 0;
			}

			@Override
			public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
				return 1F;
			}

			@Override
			public ItemStack onItemUseFinish(ItemStack itemstack, World world, LivingEntity entity) {
				ItemStack retval = super.onItemUseFinish(itemstack, world, entity);
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();

				GingerbreadPlayerFinishesUsingItemProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return retval;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class IchirakuRamenItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:ichiraku_ramen")
		public static final Item block = null;

		public IchirakuRamenItem(NarutoShippudenModElements instance) {
			super(instance, 85);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(new Item.Properties().group(FoodItemGroup.tab).maxStackSize(64).rarity(Rarity.EPIC)
						.food((new Food.Builder()).hunger(15).saturation(0.3f)

								.meat().build()));
				setRegistryName("ichiraku_ramen");
			}

			@Override
			public int getItemEnchantability() {
				return 0;
			}

			@Override
			public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
				return 1F;
			}

			@Override
			public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
				super.addInformation(itemstack, world, list, flag);
				list.add(new StringTextComponent("The best food agreed by the 7th Hokage Naruto Uzumaki."));
			}

			@Override
			public ItemStack onItemUseFinish(ItemStack itemstack, World world, LivingEntity entity) {
				ItemStack retval = super.onItemUseFinish(itemstack, world, entity);
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();

				IchirakuRamenPlayerFinishesUsingItemProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return retval;
			}
		}
	}
}
