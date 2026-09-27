package net.mcreator.narutoshippudenmod.item;

import net.mcreator.narutoshippudenmod.compat.Registration;

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


public final class TechniqueItems {
	private TechniqueItems() {
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class AburameReleaseTechniqueItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder("aburame_release_technique", v -> block = (Item) v);
		}

		public AburameReleaseTechniqueItem(NarutoShippudenModElements instance) {
			super(instance, 930);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("aburame_release_technique", "TechniquesItemGroup").stacksTo(1).rarity(Rarity.COMMON));
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
				list.accept(Component.literal("Right-Click to use technique"));
				list.accept(Component.literal("Sneak and Right-Click to select or change technique"));
				list.accept(Component.literal("\u00A72Poison Cloud Technique: \u00A7bChakra cost: 250 \u00A73Ninjutsu required: 20"));
				list.accept(Component.literal("\u00A72Insect Jar Technique: \u00A7bChakra cost: 500 \u00A73Ninjutsu required: 25"));
				list.accept(Component.literal("\u00A72Insect Bog: \u00A7bChakra cost: 650 \u00A73Ninjutsu required: 30"));
			}

			@Override
			public InteractionResult use(Level world, Player entity, InteractionHand hand) {
				InteractionResult ar = super.use(world, entity, hand);
				ItemStack itemstack = entity.getItemInHand(hand);
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();

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
				public static Item block;
		static {
			Registration.holder("akimichi_release_technique", v -> block = (Item) v);
		}

		public AkimichiReleaseTechniqueItem(NarutoShippudenModElements instance) {
			super(instance, 1016);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("akimichi_release_technique", "TechniquesItemGroup").stacksTo(1).rarity(Rarity.COMMON));
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
				list.accept(Component.literal("Right-Click to use technique"));
				list.accept(Component.literal("Sneak and Right-Click to select or change technique"));
				list.accept(Component.literal("Sneak and Left-Click to change Calorie Control size"));
				list.accept(Component.literal("\u00A72Calorie Control: \u00A7bChakra cost: 300 \u00A73Ninjutsu required: 20"));
				list.accept(Component.literal("\u00A72Human Bullet Tank: \u00A7bChakra cost: 40/sec \u00A73Ninjutsu required: 25"));
				list.accept(Component.literal("\u00A72Spiked Human Bullet Tank: \u00A7bChakra cost: 60/sec \u00A73Ninjutsu required: 30"));
				list.accept(Component.literal("\u00A72Butterfly Mode: \u00A7bChakra cost: 80/sec \u00A73Ninjutsu required: 35"));
			}

			@Override
			public InteractionResult use(Level world, Player entity, InteractionHand hand) {
				InteractionResult ar = super.use(world, entity, hand);
				ItemStack itemstack = entity.getItemInHand(hand);
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();

				AkimichiReleaseTechniqueRightclickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}

			@Override
			public boolean onEntitySwing(ItemStack itemstack, LivingEntity entity, InteractionHand hand) {
				boolean retval = super.onEntitySwing(itemstack, entity, hand);
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
				Level world = entity.level();

				AkimichiReleaseTechniqueEntitySwingsItemProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return retval;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class FumaReleaseTechniqueItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder("fuma_release_technique", v -> block = (Item) v);
		}

		public FumaReleaseTechniqueItem(NarutoShippudenModElements instance) {
			super(instance, 982);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("fuma_release_technique", "TechniquesItemGroup").stacksTo(1).rarity(Rarity.COMMON));
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
				list.accept(Component.literal("Right-Click to use technique"));
				list.accept(Component.literal("Sneak and Right-Click to select or change technique"));
				list.accept(Component.literal("\u00A72Shuriken: \u00A7bChakra cost: 30 \u00A73Ninjutsu required: 15"));
				list.accept(Component.literal("\u00A77Shurikenjutsu Required: 5"));
				list.accept(Component.literal("\u00A72Fuma Shuriken: \u00A7bChakra cost: 50 \u00A73Ninjutsu required: 20"));
				list.accept(Component.literal("\u00A77Shurikenjutsu Required: 20"));
				list.accept(Component.literal("\u00A72Toroi Unique Fuma Shuriken: \u00A7bChakra cost: 80 \u00A73Ninjutsu required: 25"));
				list.accept(Component.literal("\u00A77Shurikenjutsu Required: 25"));
			}

			@Override
			public InteractionResult use(Level world, Player entity, InteractionHand hand) {
				InteractionResult ar = super.use(world, entity, hand);
				ItemStack itemstack = entity.getItemInHand(hand);
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();

				FumaReleaseTechniqueRightclickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class HoshigakiReleaseTechniqueItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder("hoshigaki_release_technique", v -> block = (Item) v);
		}

		public HoshigakiReleaseTechniqueItem(NarutoShippudenModElements instance) {
			super(instance, 962);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("hoshigaki_release_technique", "TechniquesItemGroup").stacksTo(1).rarity(Rarity.COMMON));
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
	public static class HozukiReleaseTechniqueItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder("hozuki_release_technique", v -> block = (Item) v);
		}

		public HozukiReleaseTechniqueItem(NarutoShippudenModElements instance) {
			super(instance, 941);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("hozuki_release_technique", "TechniquesItemGroup").stacksTo(1).rarity(Rarity.COMMON));
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
				list.accept(Component.literal("Right-Click to use technique"));
				list.accept(Component.literal("Sneak and Right-Click to select or change technique"));
				list.accept(Component.literal("\u00A72Drowning Water Blob Technique: \u00A7bChakra cost: 200 \u00A73Ninjutsu required: 15"));
				list.accept(Component.literal("\u00A72Water Gun Technique: \u00A7bChakra cost: 300 \u00A73Ninjutsu required: 20"));
				list.accept(Component.literal("\u00A72Great Water Arm Technique: \u00A7bChakra cost: 40/sec \u00A73Ninjutsu required: 25"));
			}

			@Override
			public InteractionResult use(Level world, Player entity, InteractionHand hand) {
				InteractionResult ar = super.use(world, entity, hand);
				ItemStack itemstack = entity.getItemInHand(hand);
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();

				HozukiReleaseTechniqueRightclickedProcedure
						.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("entity", entity))
								.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class HyugaReleaseTechniqueItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder("hyuga_release_technique", v -> block = (Item) v);
		}

		public HyugaReleaseTechniqueItem(NarutoShippudenModElements instance) {
			super(instance, 451);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("hyuga_release_technique", "TechniquesItemGroup").stacksTo(1).rarity(Rarity.COMMON));
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
				list.accept(Component.literal("Right-Click to use technique"));
				list.accept(Component.literal("Sneak and Right-Click to select or change technique"));
				list.accept(Component.literal("\u00A72Gentle Fist: \u00A7bChakra cost: 200 \u00A73Ninjutsu required: 10"));
				list.accept(Component.literal("\u00A72Gentle Step Twin Lion Fists: \u00A7bChakra cost: 350 \u00A73Ninjutsu required: 20"));
				list.accept(Component.literal(
						"\u00A72Eight Trigrams Twin Lions Crumbling Attack: \u00A7bChakra cost: 500 \u00A73Ninjutsu required: 30"));
				list.accept(Component.literal("\u00A72Eight Trigrams Palms Revolving Heaven: \u00A7bChakra cost: 650 \u00A73Ninjutsu required: 40"));
				list.accept(Component.literal("\u00A72Eight Trigrams Sixty-Four Palms: \u00A7bChakra cost: 900 \u00A73Ninjutsu required: 45"));
			}

			@Override
			public InteractionResult use(Level world, Player entity, InteractionHand hand) {
				InteractionResult ar = super.use(world, entity, hand);
				ItemStack itemstack = entity.getItemInHand(hand);
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();

				HyugaReleaseTechniqueRightclickedProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z), new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}

			@Override
			public void hurtEnemy(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
				super.hurtEnemy(itemstack, entity, sourceentity);
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
				Level world = entity.level();

				HyugaReleaseTechniqueLivingEntityIsHitWithItemProcedure.executeProcedure(
						Stream.of(new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("sourceentity", sourceentity))
								.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class InuzukaReleaseTechniqueItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder("inuzuka_release_technique", v -> block = (Item) v);
		}

		public InuzukaReleaseTechniqueItem(NarutoShippudenModElements instance) {
			super(instance, 560);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("inuzuka_release_technique", "TechniquesItemGroup").stacksTo(1).rarity(Rarity.COMMON));
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
				list.accept(Component.literal("Right-Click to use technique"));
				list.accept(Component.literal("Sneak and Right-Click to select or change technique"));
				list.accept(Component.literal("\u00A72Akamaru: \u00A7bChakra cost: 200 \u00A73Ninjutsu required: 10 \u00A7cSummoning required: 10"));
				list.accept(Component.literal("\u00A72Passing Fang: \u00A7bChakra cost: 350 \u00A73Ninjutsu required: 15"));
				list.accept(Component.literal(
						"\u00A72Two-Headed Wolf: \u00A7bChakra cost: 500 \u00A73Ninjutsu required: 20 \u00A7cSummoning required: 20"));
				list.accept(Component.literal(
						"\u00A72Three-Headed Wolf: \u00A7bChakra cost: 750 \u00A73Ninjutsu required: 25 \u00A7cSummoning required: 25"));
			}

			@Override
			public InteractionResult use(Level world, Player entity, InteractionHand hand) {
				InteractionResult ar = super.use(world, entity, hand);
				ItemStack itemstack = entity.getItemInHand(hand);
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();

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
				public static Item block;
		static {
			Registration.holder("isshiki_dojutsu_release_technique", v -> block = (Item) v);
		}

		public IsshikiDojutsuReleaseTechniqueItem(NarutoShippudenModElements instance) {
			super(instance, 535);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("isshiki_dojutsu_release_technique", "TechniquesItemGroup").stacksTo(1).rarity(Rarity.COMMON));
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
				list.accept(Component.literal("Right-Click to use technique"));
				list.accept(Component.literal("Sneak and Right-Click to select or change technique"));
				list.accept(Component.literal("Sneak and Left-Click to change size of Sukunahikona"));
				list.accept(Component.literal("\u00A72Sukunahikona: \u00A7bChakra cost: 500 \u00A73Ninjutsu required: 25"));
				list.accept(Component.literal("\u00A72Disruption Cube: \u00A7bChakra cost: 1000 \u00A73Ninjutsu required: 35"));
			}

			@Override
			public InteractionResult use(Level world, Player entity, InteractionHand hand) {
				InteractionResult ar = super.use(world, entity, hand);
				ItemStack itemstack = entity.getItemInHand(hand);
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();

				IsshikiDojutsuReleaseTechniqueRightclickedProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}

			@Override
			public boolean onEntitySwing(ItemStack itemstack, LivingEntity entity, InteractionHand hand) {
				boolean retval = super.onEntitySwing(itemstack, entity, hand);
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
				Level world = entity.level();

				IsshikiDojutsuReleaseTechniqueEntitySwingsItemProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return retval;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class IzunoReleaseTechniqueItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder("izuno_release_technique", v -> block = (Item) v);
		}

		public IzunoReleaseTechniqueItem(NarutoShippudenModElements instance) {
			super(instance, 838);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("izuno_release_technique", "TechniquesItemGroup").stacksTo(1).rarity(Rarity.COMMON));
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
				list.accept(Component.literal("\u00A72Cat Covering: \u00A7bChakra cost: 20/sec \u00A73Ninjutsu required: 20"));
				list.accept(Component.literal("\u00A72Monster Cat Beckoning Technique: \u00A7bChakra cost: 60/sec \u00A73Ninjutsu required: 25"));
			}

			@Override
			public InteractionResult use(Level world, Player entity, InteractionHand hand) {
				InteractionResult ar = super.use(world, entity, hand);
				ItemStack itemstack = entity.getItemInHand(hand);
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();

				IzunoReleaseTechniqueRightclickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class LeeReleaseDrunkenFistItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder("lee_release_drunken_fist", v -> block = (Item) v);
		}

		public LeeReleaseDrunkenFistItem(NarutoShippudenModElements instance) {
			super(instance, 706);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("lee_release_drunken_fist", "TechniquesItemGroup").stacksTo(1).rarity(Rarity.COMMON)
						.food((new FoodProperties.Builder()).nutrition(0).saturationMod(0f).alwaysEat().build()));
			}

			@Override
			public ItemUseAnimation getUseAnimation(ItemStack itemstack) {
				return ItemUseAnimation.DRINK;
			}

			@Override
			public net.minecraft.sounds.SoundEvent getEatingSound() {
				return net.minecraft.sounds.SoundEvents.GENERIC_DRINK;
			}

			@Override
			public int getUseDuration(ItemStack itemstack, LivingEntity user) {
				return 140;
			}

			@Override
			public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
				return 1F;
			}

			@Override
			public void appendHoverText(ItemStack itemstack, Item.TooltipContext world, net.minecraft.world.item.component.TooltipDisplay display, java.util.function.Consumer<Component> list, TooltipFlag flag) {
				super.appendHoverText(itemstack, world, display, list, flag);
				list.accept(Component.literal("\u00A72Drunken Fist: \u00A7bChakra cost: 0 \u00A73Ninjutsu required: 0"));
			}

			@Override
			public InteractionResult use(Level world, Player entity, InteractionHand hand) {
				InteractionResult ar = super.use(world, entity, hand);
				ItemStack itemstack = entity.getItemInHand(hand);
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();

				LeeReleaseDrunkenFistRightclickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}

			@Override
			public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
				ItemStack retval = new ItemStack(LeeReleaseDrunkenFistItem.block);
				super.finishUsingItem(itemstack, world, entity);
				if (itemstack.isEmpty()) {
					return retval;
				} else {
					if (entity instanceof Player) {
						Player player = (Player) entity;
						if (!player.isCreative() && !player.getInventory().add(retval))
							player.drop(retval, false);
					}
					return itemstack;
				}
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class LeeReleaseTechniqueItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder("lee_release_technique", v -> block = (Item) v);
		}

		public LeeReleaseTechniqueItem(NarutoShippudenModElements instance) {
			super(instance, 679);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("lee_release_technique", "TechniquesItemGroup").stacksTo(1).rarity(Rarity.COMMON));
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
				list.accept(Component.literal("Right-Click to use technique"));
				list.accept(Component.literal("Sneak and Right-Click to select or change technique"));
				list.accept(Component.literal("\u00A72Gate Of Opening: \u00A7aTaijutsu required: 15"));
				list.accept(Component.literal("\u00A72Gate Of Healing: \u00A7aTaijutsu required: 30"));
				list.accept(Component.literal("\u00A72Gate Of Life: \u00A7aTaijutsu required: 45"));
				list.accept(Component.literal("\u00A72Gate Of Pain: \u00A7aTaijutsu required: 60"));
				list.accept(Component.literal("\u00A72Gate Of Limit: \u00A7aTaijutsu required: 75"));
				list.accept(Component.literal("\u00A72Gate Of View: \u00A7aTaijutsu required: 90"));
				list.accept(Component.literal("\u00A72Gate Of Wonder: \u00A7aTaijutsu required: 105"));
				list.accept(Component.literal("\u00A72Gate Of Death: \u00A7aTaijutsu required: 120"));
			}

			@Override
			public InteractionResult use(Level world, Player entity, InteractionHand hand) {
				InteractionResult ar = super.use(world, entity, hand);
				ItemStack itemstack = entity.getItemInHand(hand);
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();

				LeeReleaseTechniqueRightclickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}

			@Override
			public boolean onEntitySwing(ItemStack itemstack, LivingEntity entity, InteractionHand hand) {
				boolean retval = super.onEntitySwing(itemstack, entity, hand);
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
				Level world = entity.level();

				LeeReleaseTechniqueLivingEntityIsHitWithItemProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return retval;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class MangekyouSharinganItachiReleaseTechniqueItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder("mangekyou_sharingan_itachi_release_technique", v -> block = (Item) v);
		}

		public MangekyouSharinganItachiReleaseTechniqueItem(NarutoShippudenModElements instance) {
			super(instance, 1230);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("mangekyou_sharingan_itachi_release_technique", "TechniquesItemGroup").stacksTo(1).rarity(Rarity.COMMON));
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
				list.accept(Component.literal("Right-Click to use technique"));
				list.accept(Component.literal("Sneak and Right-Click to select or change technique"));
				list.accept(Component.literal("\u00A78Amaterasu"));
				list.accept(Component.literal("\u00A72Amaterasu:  \u00A7bChakra cost: 350 \u00A73Ninjutsu required: 20"));
				list.accept(Component.literal("\u00A7cSusano"));
				list.accept(Component.literal("\u00A72Ribcage: \u00A7bChakra cost: 20/sec"));
				list.accept(Component.literal("\u00A72Skeletal Susano: \u00A7bChakra cost: 60/sec"));
				list.accept(Component.literal("\u00A72Humanoid Susano: \u00A7bChakra cost: 100/sec"));
				list.accept(Component.literal("\u00A72Armored Susano: \u00A7bChakra cost: 140/sec"));
				list.accept(Component.literal("\u00A72Perfect Susano: \u00A7bChakra cost: 180/sec"));
			}

			@Override
			public InteractionResult use(Level world, Player entity, InteractionHand hand) {
				InteractionResult ar = super.use(world, entity, hand);
				ItemStack itemstack = entity.getItemInHand(hand);
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();

				MangekyouSharinganItachiReleaseTechniqueRightclickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}

			@Override
			public boolean onEntitySwing(ItemStack itemstack, LivingEntity entity, InteractionHand hand) {
				boolean retval = super.onEntitySwing(itemstack, entity, hand);
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
				Level world = entity.level();

				MangekyouSharinganItachiReleaseTechniqueEntitySwingsItemProcedure
						.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
								(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return retval;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class MangekyouSharinganKakashiReleaseTechniqueItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder("mangekyou_sharingan_kakashi_release_technique", v -> block = (Item) v);
		}

		public MangekyouSharinganKakashiReleaseTechniqueItem(NarutoShippudenModElements instance) {
			super(instance, 1252);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("mangekyou_sharingan_kakashi_release_technique", "TechniquesItemGroup").stacksTo(1).rarity(Rarity.COMMON));
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
				list.accept(Component.literal("Right-Click to use technique"));
				list.accept(Component.literal("Sneak and Right-Click to select or change technique"));
				list.accept(Component.literal("\u00A78Kamui"));
				list.accept(Component.literal("\u00A72Kamui Long-Range:  \u00A7bChakra cost: 350 \u00A73Ninjutsu required: 20"));
			}

			@Override
			public InteractionResult use(Level world, Player entity, InteractionHand hand) {
				InteractionResult ar = super.use(world, entity, hand);
				ItemStack itemstack = entity.getItemInHand(hand);
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();

				MangekyouSharinganKakashiReleaseTechniqueRightclickedProcedure
						.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("entity", entity))
								.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class MangekyouSharinganObitoReleaseTechniqueItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder("mangekyou_sharingan_obito_release_technique", v -> block = (Item) v);
		}

		public MangekyouSharinganObitoReleaseTechniqueItem(NarutoShippudenModElements instance) {
			super(instance, 1255);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("mangekyou_sharingan_obito_release_technique", "TechniquesItemGroup").stacksTo(1).rarity(Rarity.COMMON));
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
				list.accept(Component.literal("Right-Click to use technique"));
				list.accept(Component.literal("Sneak and Right-Click to select or change technique"));
				list.accept(Component.literal("\u00A78Kamui"));
				list.accept(Component.literal("\u00A72Kamui Self-Teleportation:  \u00A7bChakra cost: 350 \u00A73Ninjutsu required: 20"));
				list.accept(Component.literal("\u00A72Kamui Short-Range:  \u00A7bChakra cost: 350 \u00A73Ninjutsu required: 20"));
				list.accept(Component.literal("\u00A72Kamui Phantom Phasing:  \u00A7bChakra cost: 350 \u00A73Ninjutsu required: 20"));
			}

			@Override
			public InteractionResult use(Level world, Player entity, InteractionHand hand) {
				InteractionResult ar = super.use(world, entity, hand);
				ItemStack itemstack = entity.getItemInHand(hand);
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();

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
				public static Item block;
		static {
			Registration.holder("mangekyou_sharingan_sasuke_release_technique", v -> block = (Item) v);
		}

		public MangekyouSharinganSasukeReleaseTechniqueItem(NarutoShippudenModElements instance) {
			super(instance, 1217);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("mangekyou_sharingan_sasuke_release_technique", "TechniquesItemGroup").stacksTo(1).rarity(Rarity.COMMON));
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
				list.accept(Component.literal("Right-Click to use technique"));
				list.accept(Component.literal("Sneak and Right-Click to select or change technique"));
				list.accept(Component.literal("\u00A78Amaterasu"));
				list.accept(Component.literal("\u00A72Amaterasu:  \u00A7bChakra cost: 350 \u00A73Ninjutsu required: 20"));
				list.accept(Component.literal("\u00A72Blaze Release: Kagutsuchi: \u00A7bChakra cost: 100/sec \u00A73Ninjutsu required: 25"));
				list.accept(Component.literal("\u00A72Blaze Release: Honoikazuchi: \u00A7bChakra cost: 500 \u00A73Ninjutsu required: 30"));
				list.accept(Component.literal("\u00A72Amaterasu: Flame Wrapping Fire: \u00A7bChakra cost: 20/sec \u00A73Ninjutsu required: 35"));
				list.accept(Component.literal("\u00A75Susano"));
				list.accept(Component.literal("\u00A72Ribcage: \u00A7bChakra cost: 20/sec"));
				list.accept(Component.literal("\u00A72Skeletal Susano: \u00A7bChakra cost: 60/sec"));
				list.accept(Component.literal("\u00A72Humanoid Susano: \u00A7bChakra cost: 100/sec"));
				list.accept(Component.literal("\u00A72Armored Susano: \u00A7bChakra cost: 140/sec"));
				list.accept(Component.literal("\u00A72Perfect Susano: \u00A7bChakra cost: 180/sec"));
			}

			@Override
			public InteractionResult use(Level world, Player entity, InteractionHand hand) {
				InteractionResult ar = super.use(world, entity, hand);
				ItemStack itemstack = entity.getItemInHand(hand);
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();

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
				public static Item block;
		static {
			Registration.holder("nara_release_technique", v -> block = (Item) v);
		}

		public NaraReleaseTechniqueItem(NarutoShippudenModElements instance) {
			super(instance, 992);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("nara_release_technique", "TechniquesItemGroup").stacksTo(1).rarity(Rarity.COMMON));
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

				NaraReleaseTechniqueRightclickedProcedure.executeProcedure(Collections.emptyMap());
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class SarutobiReleaseTechniqueItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder("sarutobi_release_technique", v -> block = (Item) v);
		}

		public SarutobiReleaseTechniqueItem(NarutoShippudenModElements instance) {
			super(instance, 935);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("sarutobi_release_technique", "TechniquesItemGroup").stacksTo(1).rarity(Rarity.COMMON));
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
				list.accept(Component.literal("Right-Click to use technique"));
				list.accept(Component.literal("Sneak and Right-Click to select or change technique"));
				list.accept(Component.literal("\u00A72Ash Pile Burning: \u00A7bChakra cost: 250 \u00A73Ninjutsu required: 20"));
				list.accept(Component.literal("\u00A72Fire Dragon Flame Bullet: \u00A7bChakra cost: 350 \u00A73Ninjutsu required: 25"));
			}

			@Override
			public InteractionResult use(Level world, Player entity, InteractionHand hand) {
				InteractionResult ar = super.use(world, entity, hand);
				ItemStack itemstack = entity.getItemInHand(hand);
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();

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
				public static Item block;
		static {
			Registration.holder("shadow_clone_technique", v -> block = (Item) v);
		}

		public ShadowCloneTechniqueItem(NarutoShippudenModElements instance) {
			super(instance, 1186);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("shadow_clone_technique", "TechniquesItemGroup").stacksTo(1).rarity(Rarity.COMMON)
						.food((new FoodProperties.Builder()).nutrition(0).saturationMod(0f).alwaysEat().build()));
			}

			@Override
			public ItemUseAnimation getUseAnimation(ItemStack itemstack) {
				return ItemUseAnimation.NONE;
			}

			@Override
			public int getUseDuration(ItemStack itemstack, LivingEntity user) {
				return 0;
			}

			@Override
			public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
				return 1F;
			}

			@Override
			public void appendHoverText(ItemStack itemstack, Item.TooltipContext world, net.minecraft.world.item.component.TooltipDisplay display, java.util.function.Consumer<Component> list, TooltipFlag flag) {
				super.appendHoverText(itemstack, world, display, list, flag);
				list.accept(Component.literal("\u00A72Shadow Clone Technique: \u00A7bChakra cost: 30 \u00A73Ninjutsu required: 5"));
			}

			@Override
			public InteractionResult use(Level world, Player entity, InteractionHand hand) {
				InteractionResult ar = super.use(world, entity, hand);
				ItemStack itemstack = entity.getItemInHand(hand);
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();

				ShadowCloneTechniqueRightclickedProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z), new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}

			@Override
			public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
				ItemStack retval = new ItemStack(LeeReleaseDrunkenFistItem.block);
				super.finishUsingItem(itemstack, world, entity);
				if (itemstack.isEmpty()) {
					return retval;
				} else {
					if (entity instanceof Player) {
						Player player = (Player) entity;
						if (!player.isCreative() && !player.getInventory().add(retval))
							player.drop(retval, false);
					}
					return itemstack;
				}
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class SharinganReleaseTechniqueItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder("sharingan_release_technique", v -> block = (Item) v);
		}

		public SharinganReleaseTechniqueItem(NarutoShippudenModElements instance) {
			super(instance, 395);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("sharingan_release_technique", "TechniquesItemGroup").stacksTo(1).rarity(Rarity.COMMON));
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
				list.accept(Component.literal("Right-Click to use technique"));
				list.accept(Component.literal("Sneak and Right-Click to select or change technique"));
				list.accept(Component.literal(
						"\u00A72Coercion Sharingan: \u00A7bChakra cost: 200 \u00A73Ninjutsu required: 10 \u00A74Genjutsu required: 5"));
				list.accept(Component.literal(
						"\u00A72Demonic Illusion: Mirage Crow: \u00A7bChakra cost: 350 \u00A73Ninjutsu required: 20 \u00A74Genjutsu required: 10"));
				list.accept(Component.literal(
						"\u00A72Demonic Illusion: Shackling Stakes Technique: \u00A7bChakra cost: 500 \u00A73Ninjutsu required: 30 \u00A74Genjutsu required: 15"));
				list.accept(Component.literal("\u00A72Izanagi: \u00A7bActivate Sharingan"));
			}

			@Override
			public InteractionResult use(Level world, Player entity, InteractionHand hand) {
				InteractionResult ar = super.use(world, entity, hand);
				ItemStack itemstack = entity.getItemInHand(hand);
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();

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
				public static Item block;
		static {
			Registration.holder("tenro_release_technique", v -> block = (Item) v);
		}

		public TenroReleaseTechniqueItem(NarutoShippudenModElements instance) {
			super(instance, 833);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("tenro_release_technique", "TechniquesItemGroup").stacksTo(1).rarity(Rarity.COMMON));
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
				list.accept(Component.literal("Right-Click to use technique"));
				list.accept(Component.literal("Sneak and Right-Click to select or change technique"));
				list.accept(Component.literal("\u00A72Beast-Human Fury Kicks: \u00A7bChakra cost: 50 \u00A73Ninjutsu required: 15"));
				list.accept(Component.literal("\u00A72Beast-Human Transformation Technique: \u00A7bChakra cost: 50/sec \u00A73Ninjutsu required: 20"));
				list.accept(Component.literal("\u00A72Beast-Human Needle Senbon \u00A7bChakra cost: 300 \u00A73Ninjutsu required: 25"));
			}

			@Override
			public InteractionResult use(Level world, Player entity, InteractionHand hand) {
				InteractionResult ar = super.use(world, entity, hand);
				ItemStack itemstack = entity.getItemInHand(hand);
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();

				TenroReleaseTechniqueRightclickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class TsuchigumoReleaseTechniqueItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder("tsuchigumo_release_technique", v -> block = (Item) v);
		}

		public TsuchigumoReleaseTechniqueItem(NarutoShippudenModElements instance) {
			super(instance, 448);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("tsuchigumo_release_technique", "TechniquesItemGroup").stacksTo(1).rarity(Rarity.COMMON));
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
				list.accept(Component.literal("\u00A72Fury: \u00A7bChakra cost: 300 \u00A73Ninjutsu required: 20"));
			}

			@Override
			public InteractionResult use(Level world, Player entity, InteractionHand hand) {
				InteractionResult ar = super.use(world, entity, hand);
				ItemStack itemstack = entity.getItemInHand(hand);
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();

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
				public static Item block;
		static {
			Registration.holder("uzumaki_release_technique", v -> block = (Item) v);
		}

		public UzumakiReleaseTechniqueItem(NarutoShippudenModElements instance) {
			super(instance, 443);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("uzumaki_release_technique", "TechniquesItemGroup").stacksTo(1).rarity(Rarity.COMMON));
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
				list.accept(Component.literal("Right-Click to use technique"));
				list.accept(Component.literal("Sneak and Right-Click to select or change technique"));
				list.accept(Component.literal("\u00A72Adamantine Sealing Chains: \u00A7bChakra cost: 20/sec \u00A73Ninjutsu required: 10"));
				list.accept(Component.literal("\u00A72Heal Bite: \u00A7bChakra cost: 350 \u00A73Ninjutsu required: 20"));
				list.accept(Component.literal("\u00A72Dead Demon Consuming Seal: \u00A7bChakra cost: 500 \u00A73Ninjutsu required: 30"));
			}

			@Override
			public InteractionResult use(Level world, Player entity, InteractionHand hand) {
				InteractionResult ar = super.use(world, entity, hand);
				ItemStack itemstack = entity.getItemInHand(hand);
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();

				UzumakiReleaseTechniqueRightclickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}

			@Override
			public void hurtEnemy(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
				super.hurtEnemy(itemstack, entity, sourceentity);
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
				Level world = entity.level();

				UzumakiReleaseTechniqueLivingEntityIsHitWithItemProcedure.executeProcedure(
						Stream.of(new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("sourceentity", sourceentity))
								.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return;
			}
		}
	}
}
