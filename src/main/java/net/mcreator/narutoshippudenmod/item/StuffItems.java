package net.mcreator.narutoshippudenmod.item;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import net.mcreator.narutoshippudenmod.NarutoShippudenModElements;
import net.mcreator.narutoshippudenmod.itemgroup.ModItemGroups.StuffItemGroup;
import net.mcreator.narutoshippudenmod.procedures.ClanProcedures.ChakraPaperRightclickedProcedure;
import net.mcreator.narutoshippudenmod.procedures.ClanProcedures.ClanPaperRightclickedProcedure;
import net.minecraft.block.BlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
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

public final class StuffItems {
	private StuffItems() {
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class BanknoteOfRyoItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:banknote_of_ryo")
		public static final Item block = null;

		public BanknoteOfRyoItem(NarutoShippudenModElements instance) {
			super(instance, 284);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(new Item.Properties().group(StuffItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON));
				setRegistryName("banknote_of_ryo");
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
			public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
				super.addInformation(itemstack, world, list, flag);
				list.add(new StringTextComponent("(200 Gold Ryo)"));
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class BronzeRyoItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:bronze_ryo")
		public static final Item block = null;

		public BronzeRyoItem(NarutoShippudenModElements instance) {
			super(instance, 87);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(new Item.Properties().group(StuffItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON));
				setRegistryName("bronze_ryo");
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
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class CaseOfRyoItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:case_of_ryo")
		public static final Item block = null;

		public CaseOfRyoItem(NarutoShippudenModElements instance) {
			super(instance, 286);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(new Item.Properties().group(StuffItemGroup.tab).maxStackSize(1).rarity(Rarity.COMMON));
				setRegistryName("case_of_ryo");
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
			public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
				super.addInformation(itemstack, world, list, flag);
				list.add(new StringTextComponent("(500000 Gold Ryo)"));
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class ChakraPaperItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:chakra_paper")
		public static final Item block = null;

		public ChakraPaperItem(NarutoShippudenModElements instance) {
			super(instance, 155);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(new Item.Properties().group(StuffItemGroup.tab).maxStackSize(1).rarity(Rarity.EPIC));
				setRegistryName("chakra_paper");
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

				ChakraPaperRightclickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class ClanPaperItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:clan_paper")
		public static final Item block = null;

		public ClanPaperItem(NarutoShippudenModElements instance) {
			super(instance, 156);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(new Item.Properties().group(StuffItemGroup.tab).maxStackSize(1).rarity(Rarity.EPIC));
				setRegistryName("clan_paper");
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

				ClanPaperRightclickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class GoldRyoItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:gold_ryo")
		public static final Item block = null;

		public GoldRyoItem(NarutoShippudenModElements instance) {
			super(instance, 89);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(new Item.Properties().group(StuffItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON));
				setRegistryName("gold_ryo");
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
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class IronStickItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:iron_stick")
		public static final Item block = null;

		public IronStickItem(NarutoShippudenModElements instance) {
			super(instance, 311);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(new Item.Properties().group(StuffItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON));
				setRegistryName("iron_stick");
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
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class SharpIronItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:sharp_iron")
		public static final Item block = null;

		public SharpIronItem(NarutoShippudenModElements instance) {
			super(instance, 312);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(new Item.Properties().group(StuffItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON));
				setRegistryName("sharp_iron");
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
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class ShogiItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:shogi")
		public static final Item block = null;

		public ShogiItem(NarutoShippudenModElements instance) {
			super(instance, 226);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(new Item.Properties().group(StuffItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON));
				setRegistryName("shogi");
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
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class ShogiboardItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:shogiboard")
		public static final Item block = null;

		public ShogiboardItem(NarutoShippudenModElements instance) {
			super(instance, 227);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(new Item.Properties().group(StuffItemGroup.tab).maxStackSize(1).rarity(Rarity.COMMON));
				setRegistryName("shogiboard");
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
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class SilverRyoItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:silver_ryo")
		public static final Item block = null;

		public SilverRyoItem(NarutoShippudenModElements instance) {
			super(instance, 88);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(new Item.Properties().group(StuffItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON));
				setRegistryName("silver_ryo");
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
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class WadOfRyoItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:wad_of_ryo")
		public static final Item block = null;

		public WadOfRyoItem(NarutoShippudenModElements instance) {
			super(instance, 285);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(new Item.Properties().group(StuffItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON));
				setRegistryName("wad_of_ryo");
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
			public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
				super.addInformation(itemstack, world, list, flag);
				list.add(new StringTextComponent("(10000 Gold Ryo)"));
			}
		}
	}
}
