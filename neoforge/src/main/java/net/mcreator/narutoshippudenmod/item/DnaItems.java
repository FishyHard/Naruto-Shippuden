package net.mcreator.narutoshippudenmod.item;

import net.minecraft.core.registries.Registries;
import net.mcreator.narutoshippudenmod.compat.Registration;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import net.mcreator.narutoshippudenmod.NarutoShippudenModElements;
import net.mcreator.narutoshippudenmod.itemgroup.ModItemGroups.DNAItemGroup;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.entity.LivingEntity;
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

public final class DnaItems {
	private DnaItems() {
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class BoilDNAReleaseItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "boil_dna_release", v -> block = (Item) v);
		}

		public BoilDNAReleaseItem(NarutoShippudenModElements instance) {
			super(instance, 1121);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("boil_dna_release", "DNAItemGroup").stacksTo(1).rarity(Rarity.EPIC));
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
	public static class BoneDNAReleaseItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "bone_dna_release", v -> block = (Item) v);
		}

		public BoneDNAReleaseItem(NarutoShippudenModElements instance) {
			super(instance, 1122);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("bone_dna_release", "DNAItemGroup").stacksTo(1).rarity(Rarity.EPIC));
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
	public static class DustDNAReleaseItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "dust_dna_release", v -> block = (Item) v);
		}

		public DustDNAReleaseItem(NarutoShippudenModElements instance) {
			super(instance, 1125);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("dust_dna_release", "DNAItemGroup").stacksTo(1).rarity(Rarity.EPIC));
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
	public static class EarthDNAItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "earth_dna", v -> block = (Item) v);
		}

		public EarthDNAItem(NarutoShippudenModElements instance) {
			super(instance, 298);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("earth_dna", "DNAItemGroup").stacksTo(1).rarity(Rarity.EPIC));
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
	public static class FireDNAReleaseItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "fire_dna_release", v -> block = (Item) v);
		}

		public FireDNAReleaseItem(NarutoShippudenModElements instance) {
			super(instance, 291);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("fire_dna_release", "DNAItemGroup").stacksTo(1).rarity(Rarity.EPIC));
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
	public static class IceDNAReleaseItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "ice_dna_release", v -> block = (Item) v);
		}

		public IceDNAReleaseItem(NarutoShippudenModElements instance) {
			super(instance, 1115);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("ice_dna_release", "DNAItemGroup").stacksTo(1).rarity(Rarity.EPIC));
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
	public static class LightningDNAItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "lightning_dna", v -> block = (Item) v);
		}

		public LightningDNAItem(NarutoShippudenModElements instance) {
			super(instance, 294);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("lightning_dna", "DNAItemGroup").stacksTo(1).rarity(Rarity.EPIC));
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
	public static class MagnetDNAReleaseItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "magnet_dna_release", v -> block = (Item) v);
		}

		public MagnetDNAReleaseItem(NarutoShippudenModElements instance) {
			super(instance, 1117);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("magnet_dna_release", "DNAItemGroup").stacksTo(1).rarity(Rarity.EPIC));
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
	public static class SmokeDNAReleaseItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "smoke_dna_release", v -> block = (Item) v);
		}

		public SmokeDNAReleaseItem(NarutoShippudenModElements instance) {
			super(instance, 1119);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("smoke_dna_release", "DNAItemGroup").stacksTo(1).rarity(Rarity.EPIC));
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
	public static class SteelDNAReleaseItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "steel_dna_release", v -> block = (Item) v);
		}

		public SteelDNAReleaseItem(NarutoShippudenModElements instance) {
			super(instance, 1120);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("steel_dna_release", "DNAItemGroup").stacksTo(1).rarity(Rarity.EPIC));
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
	public static class StormDNAReleaseItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "storm_dna_release", v -> block = (Item) v);
		}

		public StormDNAReleaseItem(NarutoShippudenModElements instance) {
			super(instance, 1118);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("storm_dna_release", "DNAItemGroup").stacksTo(1).rarity(Rarity.EPIC));
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
	public static class SwiftDNAReleaseItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "swift_dna_release", v -> block = (Item) v);
		}

		public SwiftDNAReleaseItem(NarutoShippudenModElements instance) {
			super(instance, 1123);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("swift_dna_release", "DNAItemGroup").stacksTo(1).rarity(Rarity.EPIC));
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
	public static class TyphoonDNAReleaseItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "typhoon_dna_release", v -> block = (Item) v);
		}

		public TyphoonDNAReleaseItem(NarutoShippudenModElements instance) {
			super(instance, 1124);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("typhoon_dna_release", "DNAItemGroup").stacksTo(1).rarity(Rarity.EPIC));
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
	public static class UndefinedDNAItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "undefined_dna", v -> block = (Item) v);
		}

		public UndefinedDNAItem(NarutoShippudenModElements instance) {
			super(instance, 288);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("undefined_dna", "DNAItemGroup").stacksTo(1).rarity(Rarity.EPIC));
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
	public static class WaterDNAReleaseItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "water_dna_release", v -> block = (Item) v);
		}

		public WaterDNAReleaseItem(NarutoShippudenModElements instance) {
			super(instance, 301);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("water_dna_release", "DNAItemGroup").stacksTo(1).rarity(Rarity.EPIC));
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
	public static class WindDNAItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "wind_dna", v -> block = (Item) v);
		}

		public WindDNAItem(NarutoShippudenModElements instance) {
			super(instance, 296);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("wind_dna", "DNAItemGroup").stacksTo(1).rarity(Rarity.EPIC));
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
	public static class WoodDNAReleaseItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "wood_dna_release", v -> block = (Item) v);
		}

		public WoodDNAReleaseItem(NarutoShippudenModElements instance) {
			super(instance, 1116);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("wood_dna_release", "DNAItemGroup").stacksTo(1).rarity(Rarity.EPIC));
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
