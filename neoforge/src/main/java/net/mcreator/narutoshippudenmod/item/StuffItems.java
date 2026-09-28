package net.mcreator.narutoshippudenmod.item;

import net.minecraft.core.registries.Registries;
import net.mcreator.narutoshippudenmod.compat.Registration;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import net.mcreator.narutoshippudenmod.NarutoShippudenModElements;
import net.mcreator.narutoshippudenmod.itemgroup.ModItemGroups.StuffItemGroup;
import net.mcreator.narutoshippudenmod.procedures.ClanProcedures.ChakraPaperRightclickedProcedure;
import net.mcreator.narutoshippudenmod.procedures.ClanProcedures.ClanPaperRightclickedProcedure;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemUseAnimation;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;


public final class StuffItems {
	private StuffItems() {
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class BanknoteOfRyoItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "banknote_of_ryo", v -> block = (Item) v);
		}

		public BanknoteOfRyoItem(NarutoShippudenModElements instance) {
			super(instance, 284);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("banknote_of_ryo", "StuffItemGroup").stacksTo(64).rarity(Rarity.COMMON));
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
	public static class BronzeRyoItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "bronze_ryo", v -> block = (Item) v);
		}

		public BronzeRyoItem(NarutoShippudenModElements instance) {
			super(instance, 87);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("bronze_ryo", "StuffItemGroup").stacksTo(64).rarity(Rarity.COMMON));
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
	public static class CaseOfRyoItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "case_of_ryo", v -> block = (Item) v);
		}

		public CaseOfRyoItem(NarutoShippudenModElements instance) {
			super(instance, 286);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("case_of_ryo", "StuffItemGroup").stacksTo(1).rarity(Rarity.COMMON));
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
	public static class ChakraPaperItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "chakra_paper", v -> block = (Item) v);
		}

		public ChakraPaperItem(NarutoShippudenModElements instance) {
			super(instance, 155);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("chakra_paper", "StuffItemGroup").stacksTo(1).rarity(Rarity.EPIC));
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

				ChakraPaperRightclickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class ClanPaperItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "clan_paper", v -> block = (Item) v);
		}

		public ClanPaperItem(NarutoShippudenModElements instance) {
			super(instance, 156);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("clan_paper", "StuffItemGroup").stacksTo(1).rarity(Rarity.EPIC));
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

				ClanPaperRightclickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class GoldRyoItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "gold_ryo", v -> block = (Item) v);
		}

		public GoldRyoItem(NarutoShippudenModElements instance) {
			super(instance, 89);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("gold_ryo", "StuffItemGroup").stacksTo(64).rarity(Rarity.COMMON));
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
	public static class IronStickItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "iron_stick", v -> block = (Item) v);
		}

		public IronStickItem(NarutoShippudenModElements instance) {
			super(instance, 311);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("iron_stick", "StuffItemGroup").stacksTo(64).rarity(Rarity.COMMON));
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
	public static class SharpIronItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "sharp_iron", v -> block = (Item) v);
		}

		public SharpIronItem(NarutoShippudenModElements instance) {
			super(instance, 312);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("sharp_iron", "StuffItemGroup").stacksTo(64).rarity(Rarity.COMMON));
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
	public static class ShogiItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "shogi", v -> block = (Item) v);
		}

		public ShogiItem(NarutoShippudenModElements instance) {
			super(instance, 226);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("shogi", "StuffItemGroup").stacksTo(64).rarity(Rarity.COMMON));
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
	public static class ShogiboardItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "shogiboard", v -> block = (Item) v);
		}

		public ShogiboardItem(NarutoShippudenModElements instance) {
			super(instance, 227);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("shogiboard", "StuffItemGroup").stacksTo(1).rarity(Rarity.COMMON));
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
	public static class SilverRyoItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "silver_ryo", v -> block = (Item) v);
		}

		public SilverRyoItem(NarutoShippudenModElements instance) {
			super(instance, 88);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("silver_ryo", "StuffItemGroup").stacksTo(64).rarity(Rarity.COMMON));
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
	public static class WadOfRyoItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "wad_of_ryo", v -> block = (Item) v);
		}

		public WadOfRyoItem(NarutoShippudenModElements instance) {
			super(instance, 285);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("wad_of_ryo", "StuffItemGroup").stacksTo(64).rarity(Rarity.COMMON));
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
}
