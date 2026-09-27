package net.mcreator.narutoshippudenmod.item;

import java.util.AbstractMap;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import net.mcreator.narutoshippudenmod.NarutoShippudenModElements;
import net.mcreator.narutoshippudenmod.itemgroup.ModItemGroups.TechniquesItemGroup;
import net.mcreator.narutoshippudenmod.procedures.ClanProcedures.AburameReleaseTechniqueRightclickedProcedure;
import net.mcreator.narutoshippudenmod.procedures.ClanProcedures.AkimichiReleaseTechniqueEntitySwingsItemProcedure;
import net.mcreator.narutoshippudenmod.procedures.ClanProcedures.AkimichiReleaseTechniqueRightclickedProcedure;
import net.mcreator.narutoshippudenmod.procedures.ClanProcedures.FumaReleaseTechniqueRightclickedProcedure;
import net.mcreator.narutoshippudenmod.procedures.ClanProcedures.HozukiReleaseTechniqueRightclickedProcedure;
import net.mcreator.narutoshippudenmod.procedures.ClanProcedures.HyugaReleaseTechniqueLivingEntityIsHitWithItemProcedure;
import net.mcreator.narutoshippudenmod.procedures.ClanProcedures.HyugaReleaseTechniqueRightclickedProcedure;
import net.mcreator.narutoshippudenmod.procedures.ClanProcedures.InuzukaReleaseTechniqueRightclickedProcedure;
import net.mcreator.narutoshippudenmod.procedures.ClanProcedures.IzunoReleaseTechniqueRightclickedProcedure;
import net.mcreator.narutoshippudenmod.procedures.ClanProcedures.LeeReleaseDrunkenFistRightclickedProcedure;
import net.mcreator.narutoshippudenmod.procedures.ClanProcedures.LeeReleaseTechniqueLivingEntityIsHitWithItemProcedure;
import net.mcreator.narutoshippudenmod.procedures.ClanProcedures.LeeReleaseTechniqueRightclickedProcedure;
import net.mcreator.narutoshippudenmod.procedures.ClanProcedures.NaraReleaseTechniqueRightclickedProcedure;
import net.mcreator.narutoshippudenmod.procedures.ClanProcedures.SarutobiReleaseTechniqueRightclickedProcedure;
import net.mcreator.narutoshippudenmod.procedures.ClanProcedures.ShadowCloneTechniqueRightclickedProcedure;
import net.mcreator.narutoshippudenmod.procedures.ClanProcedures.TenroReleaseTechniqueRightclickedProcedure;
import net.mcreator.narutoshippudenmod.procedures.ClanProcedures.TsuchigumoReleaseFuryRightclickedProcedure;
import net.mcreator.narutoshippudenmod.procedures.ClanProcedures.UzumakiReleaseTechniqueLivingEntityIsHitWithItemProcedure;
import net.mcreator.narutoshippudenmod.procedures.ClanProcedures.UzumakiReleaseTechniqueRightclickedProcedure;
import net.mcreator.narutoshippudenmod.procedures.DojutsuProcedures.IsshikiDojutsuReleaseTechniqueEntitySwingsItemProcedure;
import net.mcreator.narutoshippudenmod.procedures.DojutsuProcedures.IsshikiDojutsuReleaseTechniqueRightclickedProcedure;
import net.mcreator.narutoshippudenmod.procedures.DojutsuProcedures.MangekyouSharinganItachiReleaseTechniqueEntitySwingsItemProcedure;
import net.mcreator.narutoshippudenmod.procedures.DojutsuProcedures.MangekyouSharinganItachiReleaseTechniqueRightclickedProcedure;
import net.mcreator.narutoshippudenmod.procedures.DojutsuProcedures.MangekyouSharinganKakashiReleaseTechniqueRightclickedProcedure;
import net.mcreator.narutoshippudenmod.procedures.DojutsuProcedures.MangekyouSharinganObitoReleaseRightclickProcedure;
import net.mcreator.narutoshippudenmod.procedures.DojutsuProcedures.MangekyouSharinganSasukeReleaseRightclickProcedure;
import net.mcreator.narutoshippudenmod.procedures.DojutsuProcedures.SharinganReleaseTechniqueRightclickedProcedure;
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

public final class TechniqueItems {
	private TechniqueItems() {
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class AburameReleaseTechniqueItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:aburame_release_technique")
		public static final Item block = null;

		public AburameReleaseTechniqueItem(NarutoShippudenModElements instance) {
			super(instance, 930);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(new Item.Properties().group(TechniquesItemGroup.tab).maxStackSize(1).rarity(Rarity.COMMON));
				setRegistryName("aburame_release_technique");
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
				list.add(new StringTextComponent("Right-Click to use technique"));
				list.add(new StringTextComponent("Sneak and Right-Click to select or change technique"));
				list.add(new StringTextComponent("\u00A72Poison Cloud Technique: \u00A7bChakra cost: 250 \u00A73Ninjutsu required: 20"));
				list.add(new StringTextComponent("\u00A72Insect Jar Technique: \u00A7bChakra cost: 500 \u00A73Ninjutsu required: 25"));
				list.add(new StringTextComponent("\u00A72Insect Bog: \u00A7bChakra cost: 650 \u00A73Ninjutsu required: 30"));
			}

			@Override
			public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
				ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
				ItemStack itemstack = ar.getResult();
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();

				AburameReleaseTechniqueRightclickedProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z), new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class AkimichiReleaseTechniqueItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:akimichi_release_technique")
		public static final Item block = null;

		public AkimichiReleaseTechniqueItem(NarutoShippudenModElements instance) {
			super(instance, 1016);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(new Item.Properties().group(TechniquesItemGroup.tab).maxStackSize(1).rarity(Rarity.COMMON));
				setRegistryName("akimichi_release_technique");
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
				list.add(new StringTextComponent("Right-Click to use technique"));
				list.add(new StringTextComponent("Sneak and Right-Click to select or change technique"));
				list.add(new StringTextComponent("Sneak and Left-Click to change Calorie Control size"));
				list.add(new StringTextComponent("\u00A72Calorie Control: \u00A7bChakra cost: 300 \u00A73Ninjutsu required: 20"));
				list.add(new StringTextComponent("\u00A72Human Bullet Tank: \u00A7bChakra cost: 40/sec \u00A73Ninjutsu required: 25"));
				list.add(new StringTextComponent("\u00A72Spiked Human Bullet Tank: \u00A7bChakra cost: 60/sec \u00A73Ninjutsu required: 30"));
				list.add(new StringTextComponent("\u00A72Butterfly Mode: \u00A7bChakra cost: 80/sec \u00A73Ninjutsu required: 35"));
			}

			@Override
			public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
				ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
				ItemStack itemstack = ar.getResult();
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();

				AkimichiReleaseTechniqueRightclickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}

			@Override
			public boolean onEntitySwing(ItemStack itemstack, LivingEntity entity) {
				boolean retval = super.onEntitySwing(itemstack, entity);
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();
				World world = entity.world;

				AkimichiReleaseTechniqueEntitySwingsItemProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return retval;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class FumaReleaseTechniqueItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:fuma_release_technique")
		public static final Item block = null;

		public FumaReleaseTechniqueItem(NarutoShippudenModElements instance) {
			super(instance, 982);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(new Item.Properties().group(TechniquesItemGroup.tab).maxStackSize(1).rarity(Rarity.COMMON));
				setRegistryName("fuma_release_technique");
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
				list.add(new StringTextComponent("Right-Click to use technique"));
				list.add(new StringTextComponent("Sneak and Right-Click to select or change technique"));
				list.add(new StringTextComponent("\u00A72Shuriken: \u00A7bChakra cost: 30 \u00A73Ninjutsu required: 15"));
				list.add(new StringTextComponent("\u00A77Shurikenjutsu Required: 5"));
				list.add(new StringTextComponent("\u00A72Fuma Shuriken: \u00A7bChakra cost: 50 \u00A73Ninjutsu required: 20"));
				list.add(new StringTextComponent("\u00A77Shurikenjutsu Required: 20"));
				list.add(new StringTextComponent("\u00A72Toroi Unique Fuma Shuriken: \u00A7bChakra cost: 80 \u00A73Ninjutsu required: 25"));
				list.add(new StringTextComponent("\u00A77Shurikenjutsu Required: 25"));
			}

			@Override
			public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
				ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
				ItemStack itemstack = ar.getResult();
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();

				FumaReleaseTechniqueRightclickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class HoshigakiReleaseTechniqueItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:hoshigaki_release_technique")
		public static final Item block = null;

		public HoshigakiReleaseTechniqueItem(NarutoShippudenModElements instance) {
			super(instance, 962);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(new Item.Properties().group(TechniquesItemGroup.tab).maxStackSize(1).rarity(Rarity.COMMON));
				setRegistryName("hoshigaki_release_technique");
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
	public static class HozukiReleaseTechniqueItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:hozuki_release_technique")
		public static final Item block = null;

		public HozukiReleaseTechniqueItem(NarutoShippudenModElements instance) {
			super(instance, 941);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(new Item.Properties().group(TechniquesItemGroup.tab).maxStackSize(1).rarity(Rarity.COMMON));
				setRegistryName("hozuki_release_technique");
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
				list.add(new StringTextComponent("Right-Click to use technique"));
				list.add(new StringTextComponent("Sneak and Right-Click to select or change technique"));
				list.add(new StringTextComponent("\u00A72Drowning Water Blob Technique: \u00A7bChakra cost: 200 \u00A73Ninjutsu required: 15"));
				list.add(new StringTextComponent("\u00A72Water Gun Technique: \u00A7bChakra cost: 300 \u00A73Ninjutsu required: 20"));
				list.add(new StringTextComponent("\u00A72Great Water Arm Technique: \u00A7bChakra cost: 40/sec \u00A73Ninjutsu required: 25"));
			}

			@Override
			public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
				ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
				ItemStack itemstack = ar.getResult();
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();

				HozukiReleaseTechniqueRightclickedProcedure
						.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("entity", entity))
								.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class HyugaReleaseTechniqueItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:hyuga_release_technique")
		public static final Item block = null;

		public HyugaReleaseTechniqueItem(NarutoShippudenModElements instance) {
			super(instance, 451);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(new Item.Properties().group(TechniquesItemGroup.tab).maxStackSize(1).rarity(Rarity.COMMON));
				setRegistryName("hyuga_release_technique");
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
				list.add(new StringTextComponent("Right-Click to use technique"));
				list.add(new StringTextComponent("Sneak and Right-Click to select or change technique"));
				list.add(new StringTextComponent("\u00A72Gentle Fist: \u00A7bChakra cost: 200 \u00A73Ninjutsu required: 10"));
				list.add(new StringTextComponent("\u00A72Gentle Step Twin Lion Fists: \u00A7bChakra cost: 350 \u00A73Ninjutsu required: 20"));
				list.add(new StringTextComponent(
						"\u00A72Eight Trigrams Twin Lions Crumbling Attack: \u00A7bChakra cost: 500 \u00A73Ninjutsu required: 30"));
				list.add(new StringTextComponent("\u00A72Eight Trigrams Palms Revolving Heaven: \u00A7bChakra cost: 650 \u00A73Ninjutsu required: 40"));
				list.add(new StringTextComponent("\u00A72Eight Trigrams Sixty-Four Palms: \u00A7bChakra cost: 900 \u00A73Ninjutsu required: 45"));
			}

			@Override
			public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
				ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
				ItemStack itemstack = ar.getResult();
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();

				HyugaReleaseTechniqueRightclickedProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z), new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}

			@Override
			public boolean hitEntity(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
				boolean retval = super.hitEntity(itemstack, entity, sourceentity);
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();
				World world = entity.world;

				HyugaReleaseTechniqueLivingEntityIsHitWithItemProcedure.executeProcedure(
						Stream.of(new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("sourceentity", sourceentity))
								.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return retval;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class InuzukaReleaseTechniqueItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:inuzuka_release_technique")
		public static final Item block = null;

		public InuzukaReleaseTechniqueItem(NarutoShippudenModElements instance) {
			super(instance, 560);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(new Item.Properties().group(TechniquesItemGroup.tab).maxStackSize(1).rarity(Rarity.COMMON));
				setRegistryName("inuzuka_release_technique");
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
				list.add(new StringTextComponent("Right-Click to use technique"));
				list.add(new StringTextComponent("Sneak and Right-Click to select or change technique"));
				list.add(new StringTextComponent("\u00A72Akamaru: \u00A7bChakra cost: 200 \u00A73Ninjutsu required: 10 \u00A7cSummoning required: 10"));
				list.add(new StringTextComponent("\u00A72Passing Fang: \u00A7bChakra cost: 350 \u00A73Ninjutsu required: 15"));
				list.add(new StringTextComponent(
						"\u00A72Two-Headed Wolf: \u00A7bChakra cost: 500 \u00A73Ninjutsu required: 20 \u00A7cSummoning required: 20"));
				list.add(new StringTextComponent(
						"\u00A72Three-Headed Wolf: \u00A7bChakra cost: 750 \u00A73Ninjutsu required: 25 \u00A7cSummoning required: 25"));
			}

			@Override
			public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
				ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
				ItemStack itemstack = ar.getResult();
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();

				InuzukaReleaseTechniqueRightclickedProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z), new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class IsshikiDojutsuReleaseTechniqueItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:isshiki_dojutsu_release_technique")
		public static final Item block = null;

		public IsshikiDojutsuReleaseTechniqueItem(NarutoShippudenModElements instance) {
			super(instance, 535);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(new Item.Properties().group(TechniquesItemGroup.tab).maxStackSize(1).rarity(Rarity.COMMON));
				setRegistryName("isshiki_dojutsu_release_technique");
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
				list.add(new StringTextComponent("Right-Click to use technique"));
				list.add(new StringTextComponent("Sneak and Right-Click to select or change technique"));
				list.add(new StringTextComponent("Sneak and Left-Click to change size of Sukunahikona"));
				list.add(new StringTextComponent("\u00A72Sukunahikona: \u00A7bChakra cost: 500 \u00A73Ninjutsu required: 25"));
				list.add(new StringTextComponent("\u00A72Disruption Cube: \u00A7bChakra cost: 1000 \u00A73Ninjutsu required: 35"));
			}

			@Override
			public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
				ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
				ItemStack itemstack = ar.getResult();
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();

				IsshikiDojutsuReleaseTechniqueRightclickedProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}

			@Override
			public boolean onEntitySwing(ItemStack itemstack, LivingEntity entity) {
				boolean retval = super.onEntitySwing(itemstack, entity);
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();
				World world = entity.world;

				IsshikiDojutsuReleaseTechniqueEntitySwingsItemProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return retval;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class IzunoReleaseTechniqueItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:izuno_release_technique")
		public static final Item block = null;

		public IzunoReleaseTechniqueItem(NarutoShippudenModElements instance) {
			super(instance, 838);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(new Item.Properties().group(TechniquesItemGroup.tab).maxStackSize(1).rarity(Rarity.COMMON));
				setRegistryName("izuno_release_technique");
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
				list.add(new StringTextComponent("\u00A72Cat Covering: \u00A7bChakra cost: 20/sec \u00A73Ninjutsu required: 20"));
				list.add(new StringTextComponent("\u00A72Monster Cat Beckoning Technique: \u00A7bChakra cost: 60/sec \u00A73Ninjutsu required: 25"));
			}

			@Override
			public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
				ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
				ItemStack itemstack = ar.getResult();
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();

				IzunoReleaseTechniqueRightclickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class LeeReleaseDrunkenFistItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:lee_release_drunken_fist")
		public static final Item block = null;

		public LeeReleaseDrunkenFistItem(NarutoShippudenModElements instance) {
			super(instance, 706);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(new Item.Properties().group(TechniquesItemGroup.tab).maxStackSize(1).rarity(Rarity.COMMON)
						.food((new Food.Builder()).hunger(0).saturation(0f).setAlwaysEdible().build()));
				setRegistryName("lee_release_drunken_fist");
			}

			@Override
			public UseAction getUseAction(ItemStack itemstack) {
				return UseAction.DRINK;
			}

			@Override
			public net.minecraft.util.SoundEvent getEatSound() {
				return net.minecraft.util.SoundEvents.ENTITY_GENERIC_DRINK;
			}

			@Override
			public int getItemEnchantability() {
				return 0;
			}

			@Override
			public int getUseDuration(ItemStack itemstack) {
				return 140;
			}

			@Override
			public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
				return 1F;
			}

			@Override
			public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
				super.addInformation(itemstack, world, list, flag);
				list.add(new StringTextComponent("\u00A72Drunken Fist: \u00A7bChakra cost: 0 \u00A73Ninjutsu required: 0"));
			}

			@Override
			public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
				ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
				ItemStack itemstack = ar.getResult();
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();

				LeeReleaseDrunkenFistRightclickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}

			@Override
			public ItemStack onItemUseFinish(ItemStack itemstack, World world, LivingEntity entity) {
				ItemStack retval = new ItemStack(LeeReleaseDrunkenFistItem.block);
				super.onItemUseFinish(itemstack, world, entity);
				if (itemstack.isEmpty()) {
					return retval;
				} else {
					if (entity instanceof PlayerEntity) {
						PlayerEntity player = (PlayerEntity) entity;
						if (!player.isCreative() && !player.inventory.addItemStackToInventory(retval))
							player.dropItem(retval, false);
					}
					return itemstack;
				}
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class LeeReleaseTechniqueItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:lee_release_technique")
		public static final Item block = null;

		public LeeReleaseTechniqueItem(NarutoShippudenModElements instance) {
			super(instance, 679);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(new Item.Properties().group(TechniquesItemGroup.tab).maxStackSize(1).rarity(Rarity.COMMON));
				setRegistryName("lee_release_technique");
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
				list.add(new StringTextComponent("Right-Click to use technique"));
				list.add(new StringTextComponent("Sneak and Right-Click to select or change technique"));
				list.add(new StringTextComponent("\u00A72Gate Of Opening: \u00A7aTaijutsu required: 15"));
				list.add(new StringTextComponent("\u00A72Gate Of Healing: \u00A7aTaijutsu required: 30"));
				list.add(new StringTextComponent("\u00A72Gate Of Life: \u00A7aTaijutsu required: 45"));
				list.add(new StringTextComponent("\u00A72Gate Of Pain: \u00A7aTaijutsu required: 60"));
				list.add(new StringTextComponent("\u00A72Gate Of Limit: \u00A7aTaijutsu required: 75"));
				list.add(new StringTextComponent("\u00A72Gate Of View: \u00A7aTaijutsu required: 90"));
				list.add(new StringTextComponent("\u00A72Gate Of Wonder: \u00A7aTaijutsu required: 105"));
				list.add(new StringTextComponent("\u00A72Gate Of Death: \u00A7aTaijutsu required: 120"));
			}

			@Override
			public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
				ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
				ItemStack itemstack = ar.getResult();
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();

				LeeReleaseTechniqueRightclickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}

			@Override
			public boolean onEntitySwing(ItemStack itemstack, LivingEntity entity) {
				boolean retval = super.onEntitySwing(itemstack, entity);
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();
				World world = entity.world;

				LeeReleaseTechniqueLivingEntityIsHitWithItemProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return retval;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class MangekyouSharinganItachiReleaseTechniqueItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:mangekyou_sharingan_itachi_release_technique")
		public static final Item block = null;

		public MangekyouSharinganItachiReleaseTechniqueItem(NarutoShippudenModElements instance) {
			super(instance, 1230);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(new Item.Properties().group(TechniquesItemGroup.tab).maxStackSize(1).rarity(Rarity.COMMON));
				setRegistryName("mangekyou_sharingan_itachi_release_technique");
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
				list.add(new StringTextComponent("Right-Click to use technique"));
				list.add(new StringTextComponent("Sneak and Right-Click to select or change technique"));
				list.add(new StringTextComponent("\u00A78Amaterasu"));
				list.add(new StringTextComponent("\u00A72Amaterasu:  \u00A7bChakra cost: 350 \u00A73Ninjutsu required: 20"));
				list.add(new StringTextComponent("\u00A7cSusano"));
				list.add(new StringTextComponent("\u00A72Ribcage: \u00A7bChakra cost: 20/sec"));
				list.add(new StringTextComponent("\u00A72Skeletal Susano: \u00A7bChakra cost: 60/sec"));
				list.add(new StringTextComponent("\u00A72Humanoid Susano: \u00A7bChakra cost: 100/sec"));
				list.add(new StringTextComponent("\u00A72Armored Susano: \u00A7bChakra cost: 140/sec"));
				list.add(new StringTextComponent("\u00A72Perfect Susano: \u00A7bChakra cost: 180/sec"));
			}

			@Override
			public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
				ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
				ItemStack itemstack = ar.getResult();
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();

				MangekyouSharinganItachiReleaseTechniqueRightclickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}

			@Override
			public boolean onEntitySwing(ItemStack itemstack, LivingEntity entity) {
				boolean retval = super.onEntitySwing(itemstack, entity);
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();
				World world = entity.world;

				MangekyouSharinganItachiReleaseTechniqueEntitySwingsItemProcedure
						.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
								(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return retval;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class MangekyouSharinganKakashiReleaseTechniqueItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:mangekyou_sharingan_kakashi_release_technique")
		public static final Item block = null;

		public MangekyouSharinganKakashiReleaseTechniqueItem(NarutoShippudenModElements instance) {
			super(instance, 1252);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(new Item.Properties().group(TechniquesItemGroup.tab).maxStackSize(1).rarity(Rarity.COMMON));
				setRegistryName("mangekyou_sharingan_kakashi_release_technique");
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
				list.add(new StringTextComponent("Right-Click to use technique"));
				list.add(new StringTextComponent("Sneak and Right-Click to select or change technique"));
				list.add(new StringTextComponent("\u00A78Kamui"));
				list.add(new StringTextComponent("\u00A72Kamui Long-Range:  \u00A7bChakra cost: 350 \u00A73Ninjutsu required: 20"));
			}

			@Override
			public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
				ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
				ItemStack itemstack = ar.getResult();
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();

				MangekyouSharinganKakashiReleaseTechniqueRightclickedProcedure
						.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("entity", entity))
								.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class MangekyouSharinganObitoReleaseTechniqueItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:mangekyou_sharingan_obito_release_technique")
		public static final Item block = null;

		public MangekyouSharinganObitoReleaseTechniqueItem(NarutoShippudenModElements instance) {
			super(instance, 1255);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(new Item.Properties().group(TechniquesItemGroup.tab).maxStackSize(1).rarity(Rarity.COMMON));
				setRegistryName("mangekyou_sharingan_obito_release_technique");
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
				list.add(new StringTextComponent("Right-Click to use technique"));
				list.add(new StringTextComponent("Sneak and Right-Click to select or change technique"));
				list.add(new StringTextComponent("\u00A78Kamui"));
				list.add(new StringTextComponent("\u00A72Kamui Self-Teleportation:  \u00A7bChakra cost: 350 \u00A73Ninjutsu required: 20"));
				list.add(new StringTextComponent("\u00A72Kamui Short-Range:  \u00A7bChakra cost: 350 \u00A73Ninjutsu required: 20"));
				list.add(new StringTextComponent("\u00A72Kamui Phantom Phasing:  \u00A7bChakra cost: 350 \u00A73Ninjutsu required: 20"));
			}

			@Override
			public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
				ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
				ItemStack itemstack = ar.getResult();
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();

				MangekyouSharinganObitoReleaseRightclickProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z), new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class MangekyouSharinganSasukeReleaseTechniqueItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:mangekyou_sharingan_sasuke_release_technique")
		public static final Item block = null;

		public MangekyouSharinganSasukeReleaseTechniqueItem(NarutoShippudenModElements instance) {
			super(instance, 1217);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(new Item.Properties().group(TechniquesItemGroup.tab).maxStackSize(1).rarity(Rarity.COMMON));
				setRegistryName("mangekyou_sharingan_sasuke_release_technique");
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
				list.add(new StringTextComponent("Right-Click to use technique"));
				list.add(new StringTextComponent("Sneak and Right-Click to select or change technique"));
				list.add(new StringTextComponent("\u00A78Amaterasu"));
				list.add(new StringTextComponent("\u00A72Amaterasu:  \u00A7bChakra cost: 350 \u00A73Ninjutsu required: 20"));
				list.add(new StringTextComponent("\u00A72Blaze Release: Kagutsuchi: \u00A7bChakra cost: 100/sec \u00A73Ninjutsu required: 25"));
				list.add(new StringTextComponent("\u00A72Blaze Release: Honoikazuchi: \u00A7bChakra cost: 500 \u00A73Ninjutsu required: 30"));
				list.add(new StringTextComponent("\u00A72Amaterasu: Flame Wrapping Fire: \u00A7bChakra cost: 20/sec \u00A73Ninjutsu required: 35"));
				list.add(new StringTextComponent("\u00A75Susano"));
				list.add(new StringTextComponent("\u00A72Ribcage: \u00A7bChakra cost: 20/sec"));
				list.add(new StringTextComponent("\u00A72Skeletal Susano: \u00A7bChakra cost: 60/sec"));
				list.add(new StringTextComponent("\u00A72Humanoid Susano: \u00A7bChakra cost: 100/sec"));
				list.add(new StringTextComponent("\u00A72Armored Susano: \u00A7bChakra cost: 140/sec"));
				list.add(new StringTextComponent("\u00A72Perfect Susano: \u00A7bChakra cost: 180/sec"));
			}

			@Override
			public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
				ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
				ItemStack itemstack = ar.getResult();
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();

				MangekyouSharinganSasukeReleaseRightclickProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z), new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class NaraReleaseTechniqueItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:nara_release_technique")
		public static final Item block = null;

		public NaraReleaseTechniqueItem(NarutoShippudenModElements instance) {
			super(instance, 992);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(new Item.Properties().group(TechniquesItemGroup.tab).maxStackSize(1).rarity(Rarity.COMMON));
				setRegistryName("nara_release_technique");
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

				NaraReleaseTechniqueRightclickedProcedure.executeProcedure(Collections.emptyMap());
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class SarutobiReleaseTechniqueItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:sarutobi_release_technique")
		public static final Item block = null;

		public SarutobiReleaseTechniqueItem(NarutoShippudenModElements instance) {
			super(instance, 935);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(new Item.Properties().group(TechniquesItemGroup.tab).maxStackSize(1).rarity(Rarity.COMMON));
				setRegistryName("sarutobi_release_technique");
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
				list.add(new StringTextComponent("Right-Click to use technique"));
				list.add(new StringTextComponent("Sneak and Right-Click to select or change technique"));
				list.add(new StringTextComponent("\u00A72Ash Pile Burning: \u00A7bChakra cost: 250 \u00A73Ninjutsu required: 20"));
				list.add(new StringTextComponent("\u00A72Fire Dragon Flame Bullet: \u00A7bChakra cost: 350 \u00A73Ninjutsu required: 25"));
			}

			@Override
			public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
				ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
				ItemStack itemstack = ar.getResult();
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();

				SarutobiReleaseTechniqueRightclickedProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z), new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class ShadowCloneTechniqueItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:shadow_clone_technique")
		public static final Item block = null;

		public ShadowCloneTechniqueItem(NarutoShippudenModElements instance) {
			super(instance, 1186);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(new Item.Properties().group(TechniquesItemGroup.tab).maxStackSize(1).rarity(Rarity.COMMON)
						.food((new Food.Builder()).hunger(0).saturation(0f).setAlwaysEdible().build()));
				setRegistryName("shadow_clone_technique");
			}

			@Override
			public UseAction getUseAction(ItemStack itemstack) {
				return UseAction.NONE;
			}

			@Override
			public int getItemEnchantability() {
				return 0;
			}

			@Override
			public int getUseDuration(ItemStack itemstack) {
				return 0;
			}

			@Override
			public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
				return 1F;
			}

			@Override
			public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
				super.addInformation(itemstack, world, list, flag);
				list.add(new StringTextComponent("\u00A72Shadow Clone Technique: \u00A7bChakra cost: 30 \u00A73Ninjutsu required: 5"));
			}

			@Override
			public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
				ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
				ItemStack itemstack = ar.getResult();
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();

				ShadowCloneTechniqueRightclickedProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z), new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}

			@Override
			public ItemStack onItemUseFinish(ItemStack itemstack, World world, LivingEntity entity) {
				ItemStack retval = new ItemStack(LeeReleaseDrunkenFistItem.block);
				super.onItemUseFinish(itemstack, world, entity);
				if (itemstack.isEmpty()) {
					return retval;
				} else {
					if (entity instanceof PlayerEntity) {
						PlayerEntity player = (PlayerEntity) entity;
						if (!player.isCreative() && !player.inventory.addItemStackToInventory(retval))
							player.dropItem(retval, false);
					}
					return itemstack;
				}
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class SharinganReleaseTechniqueItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:sharingan_release_technique")
		public static final Item block = null;

		public SharinganReleaseTechniqueItem(NarutoShippudenModElements instance) {
			super(instance, 395);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(new Item.Properties().group(TechniquesItemGroup.tab).maxStackSize(1).rarity(Rarity.COMMON));
				setRegistryName("sharingan_release_technique");
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
				list.add(new StringTextComponent("Right-Click to use technique"));
				list.add(new StringTextComponent("Sneak and Right-Click to select or change technique"));
				list.add(new StringTextComponent(
						"\u00A72Coercion Sharingan: \u00A7bChakra cost: 200 \u00A73Ninjutsu required: 10 \u00A74Genjutsu required: 5"));
				list.add(new StringTextComponent(
						"\u00A72Demonic Illusion: Mirage Crow: \u00A7bChakra cost: 350 \u00A73Ninjutsu required: 20 \u00A74Genjutsu required: 10"));
				list.add(new StringTextComponent(
						"\u00A72Demonic Illusion: Shackling Stakes Technique: \u00A7bChakra cost: 500 \u00A73Ninjutsu required: 30 \u00A74Genjutsu required: 15"));
				list.add(new StringTextComponent("\u00A72Izanagi: \u00A7bActivate Sharingan"));
			}

			@Override
			public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
				ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
				ItemStack itemstack = ar.getResult();
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();

				SharinganReleaseTechniqueRightclickedProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z), new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class TenroReleaseTechniqueItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:tenro_release_technique")
		public static final Item block = null;

		public TenroReleaseTechniqueItem(NarutoShippudenModElements instance) {
			super(instance, 833);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(new Item.Properties().group(TechniquesItemGroup.tab).maxStackSize(1).rarity(Rarity.COMMON));
				setRegistryName("tenro_release_technique");
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
				list.add(new StringTextComponent("Right-Click to use technique"));
				list.add(new StringTextComponent("Sneak and Right-Click to select or change technique"));
				list.add(new StringTextComponent("\u00A72Beast-Human Fury Kicks: \u00A7bChakra cost: 50 \u00A73Ninjutsu required: 15"));
				list.add(new StringTextComponent("\u00A72Beast-Human Transformation Technique: \u00A7bChakra cost: 50/sec \u00A73Ninjutsu required: 20"));
				list.add(new StringTextComponent("\u00A72Beast-Human Needle Senbon \u00A7bChakra cost: 300 \u00A73Ninjutsu required: 25"));
			}

			@Override
			public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
				ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
				ItemStack itemstack = ar.getResult();
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();

				TenroReleaseTechniqueRightclickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class TsuchigumoReleaseTechniqueItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:tsuchigumo_release_technique")
		public static final Item block = null;

		public TsuchigumoReleaseTechniqueItem(NarutoShippudenModElements instance) {
			super(instance, 448);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(new Item.Properties().group(TechniquesItemGroup.tab).maxStackSize(1).rarity(Rarity.COMMON));
				setRegistryName("tsuchigumo_release_technique");
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
				list.add(new StringTextComponent("\u00A72Fury: \u00A7bChakra cost: 300 \u00A73Ninjutsu required: 20"));
			}

			@Override
			public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
				ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
				ItemStack itemstack = ar.getResult();
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();

				TsuchigumoReleaseFuryRightclickedProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z), new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class UzumakiReleaseTechniqueItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:uzumaki_release_technique")
		public static final Item block = null;

		public UzumakiReleaseTechniqueItem(NarutoShippudenModElements instance) {
			super(instance, 443);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(new Item.Properties().group(TechniquesItemGroup.tab).maxStackSize(1).rarity(Rarity.COMMON));
				setRegistryName("uzumaki_release_technique");
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
				list.add(new StringTextComponent("Right-Click to use technique"));
				list.add(new StringTextComponent("Sneak and Right-Click to select or change technique"));
				list.add(new StringTextComponent("\u00A72Adamantine Sealing Chains: \u00A7bChakra cost: 20/sec \u00A73Ninjutsu required: 10"));
				list.add(new StringTextComponent("\u00A72Heal Bite: \u00A7bChakra cost: 350 \u00A73Ninjutsu required: 20"));
				list.add(new StringTextComponent("\u00A72Dead Demon Consuming Seal: \u00A7bChakra cost: 500 \u00A73Ninjutsu required: 30"));
			}

			@Override
			public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
				ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
				ItemStack itemstack = ar.getResult();
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();

				UzumakiReleaseTechniqueRightclickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}

			@Override
			public boolean hitEntity(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
				boolean retval = super.hitEntity(itemstack, entity, sourceentity);
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();
				World world = entity.world;

				UzumakiReleaseTechniqueLivingEntityIsHitWithItemProcedure.executeProcedure(
						Stream.of(new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("sourceentity", sourceentity))
								.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return retval;
			}
		}
	}
}
