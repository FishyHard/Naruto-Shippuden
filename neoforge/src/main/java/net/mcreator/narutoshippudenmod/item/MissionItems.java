package net.mcreator.narutoshippudenmod.item;

import net.minecraft.core.registries.Registries;
import net.mcreator.narutoshippudenmod.compat.Registration;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import net.mcreator.narutoshippudenmod.NarutoShippudenModElements;
import net.mcreator.narutoshippudenmod.itemgroup.ModItemGroups.MissionsItemGroup;
import net.mcreator.narutoshippudenmod.procedures.KekkeiGenkaiProcedures.IronDefenseRightclickedProcedure;
import net.mcreator.narutoshippudenmod.procedures.MissionAndCommandProcedures.LetterFromBrotherRightclickedProcedure;
import net.mcreator.narutoshippudenmod.procedures.MissionAndCommandProcedures.PillageThePostRightclickedProcedure;
import net.mcreator.narutoshippudenmod.procedures.MissionAndCommandProcedures.SaveTheVillageRightclickedProcedure;
import net.mcreator.narutoshippudenmod.procedures.MissionAndCommandProcedures.StoryModeRightclickedProcedure;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemUseAnimation;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;


public final class MissionItems {
	private MissionItems() {
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class AsumaQuestCItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "asuma_quest_c", v -> block = (Item) v);
		}

		public AsumaQuestCItem(NarutoShippudenModElements instance) {
			super(instance, 392);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("asuma_quest_c", "MissionsItemGroup").stacksTo(1).rarity(Rarity.COMMON));
			}

			@Override
			public ItemUseAnimation getUseAnimation(ItemStack itemstack) {
				return ItemUseAnimation.EAT;
			}

			@Override
			public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
				return 1F;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class IronDefenseItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "iron_defense", v -> block = (Item) v);
		}

		public IronDefenseItem(NarutoShippudenModElements instance) {
			super(instance, 1050);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("iron_defense", "MissionsItemGroup").stacksTo(1).rarity(Rarity.COMMON));
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
			public void appendHoverText(ItemStack itemstack, Item.TooltipContext world, net.minecraft.world.item.component.TooltipDisplay display, java.util.function.Consumer<Component> list, TooltipFlag flag) {
				super.appendHoverText(itemstack, world, display, list, flag);
				list.accept(Component.literal("Build an Iron Golem"));
			}

			@Override
			public InteractionResult use(Level world, Player entity, InteractionHand hand) {
				InteractionResult ar = super.use(world, entity, hand);
				ItemStack itemstack = entity.getItemInHand(hand);
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();

				IronDefenseRightclickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class LetterFromBrotherItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "letter_from_brother", v -> block = (Item) v);
		}

		public LetterFromBrotherItem(NarutoShippudenModElements instance) {
			super(instance, 334);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("letter_from_brother", null).stacksTo(1).rarity(Rarity.EPIC));
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

				LetterFromBrotherRightclickedProcedure
						.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("entity", entity))
								.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class PillageThePostItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "pillage_the_post", v -> block = (Item) v);
		}

		public PillageThePostItem(NarutoShippudenModElements instance) {
			super(instance, 1048);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("pillage_the_post", "MissionsItemGroup").stacksTo(1).rarity(Rarity.COMMON));
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
			public void appendHoverText(ItemStack itemstack, Item.TooltipContext world, net.minecraft.world.item.component.TooltipDisplay display, java.util.function.Consumer<Component> list, TooltipFlag flag) {
				super.appendHoverText(itemstack, world, display, list, flag);
				list.accept(Component.literal("Kill 5 Pillagers"));
			}

			@Override
			public InteractionResult use(Level world, Player entity, InteractionHand hand) {
				InteractionResult ar = super.use(world, entity, hand);
				ItemStack itemstack = entity.getItemInHand(hand);
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();

				PillageThePostRightclickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class SaveTheVillageItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "save_the_village", v -> block = (Item) v);
		}

		public SaveTheVillageItem(NarutoShippudenModElements instance) {
			super(instance, 1046);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("save_the_village", "MissionsItemGroup").stacksTo(1).rarity(Rarity.COMMON));
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
			public void appendHoverText(ItemStack itemstack, Item.TooltipContext world, net.minecraft.world.item.component.TooltipDisplay display, java.util.function.Consumer<Component> list, TooltipFlag flag) {
				super.appendHoverText(itemstack, world, display, list, flag);
				list.accept(Component.literal("Kill 10 Zombies"));
			}

			@Override
			public InteractionResult use(Level world, Player entity, InteractionHand hand) {
				InteractionResult ar = super.use(world, entity, hand);
				ItemStack itemstack = entity.getItemInHand(hand);
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();

				SaveTheVillageRightclickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class ShikamaruQuestDItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "shikamaru_quest_d", v -> block = (Item) v);
		}

		public ShikamaruQuestDItem(NarutoShippudenModElements instance) {
			super(instance, 224);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("shikamaru_quest_d", "MissionsItemGroup").stacksTo(1).rarity(Rarity.COMMON));
			}

			@Override
			public ItemUseAnimation getUseAnimation(ItemStack itemstack) {
				return ItemUseAnimation.EAT;
			}

			@Override
			public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
				return 1F;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class StoryModeItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "story_mode", v -> block = (Item) v);
		}

		public StoryModeItem(NarutoShippudenModElements instance) {
			super(instance, 356);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("story_mode", "CreativeModeTab").stacksTo(1).rarity(Rarity.EPIC));
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

				StoryModeRightclickedProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z), new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}
}
