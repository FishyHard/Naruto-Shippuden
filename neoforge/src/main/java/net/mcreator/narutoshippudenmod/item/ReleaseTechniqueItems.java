package net.mcreator.narutoshippudenmod.item;

import net.mcreator.narutoshippudenmod.compat.Registration;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import net.mcreator.narutoshippudenmod.NarutoShippudenModElements;
import net.mcreator.narutoshippudenmod.itemgroup.ModItemGroups.ReleaseTechniqueItemGroup;
import net.mcreator.narutoshippudenmod.procedures.CustomJutsuProcedures.CustomEarthReleaseTechniqueRightClickedProcedure;
import net.mcreator.narutoshippudenmod.procedures.CustomJutsuProcedures.CustomFireReleaseTechniqueRightclickedProcedure;
import net.mcreator.narutoshippudenmod.procedures.CustomJutsuProcedures.CustomLightningReleaseTechniqueRightClickedProcedure;
import net.mcreator.narutoshippudenmod.procedures.CustomJutsuProcedures.CustomWaterReleaseTechniqueRightClickedProcedure;
import net.mcreator.narutoshippudenmod.procedures.CustomJutsuProcedures.CustomWindReleaseTechniqueRightClickedProcedure;
import net.mcreator.narutoshippudenmod.procedures.KekkeiGenkaiProcedures.BoilReleaseTechniqueLivingEntityIsHitWithItemProcedure;
import net.mcreator.narutoshippudenmod.procedures.KekkeiGenkaiProcedures.BoilReleaseTechniqueRightclickedProcedure;
import net.mcreator.narutoshippudenmod.procedures.KekkeiGenkaiProcedures.BoneReleaseTechniqueRightclickedProcedure;
import net.mcreator.narutoshippudenmod.procedures.KekkeiGenkaiProcedures.DustReleaseTechniqueRightclickedProcedure;
import net.mcreator.narutoshippudenmod.procedures.KekkeiGenkaiProcedures.IceReleaseTechniqueRightclickedProcedure;
import net.mcreator.narutoshippudenmod.procedures.KekkeiGenkaiProcedures.MagnetReleaseTechniqueRightclickedProcedure;
import net.mcreator.narutoshippudenmod.procedures.KekkeiGenkaiProcedures.SmokeReleaseTechniqueLivingEntityIsHitWithItemProcedure;
import net.mcreator.narutoshippudenmod.procedures.KekkeiGenkaiProcedures.SmokeReleaseTechniqueRightclickedProcedure;
import net.mcreator.narutoshippudenmod.procedures.KekkeiGenkaiProcedures.SteelReleaseTechniqueRightclickedProcedure;
import net.mcreator.narutoshippudenmod.procedures.KekkeiGenkaiProcedures.StormReleaseTechniqueRightclickedProcedure;
import net.mcreator.narutoshippudenmod.procedures.KekkeiGenkaiProcedures.SwiftReleaseTechniqueRightclickedProcedure;
import net.mcreator.narutoshippudenmod.procedures.KekkeiGenkaiProcedures.TyphoonReleaseTechniqueRightclickedProcedure;
import net.mcreator.narutoshippudenmod.procedures.KekkeiGenkaiProcedures.WoodReleaseTechniqueRightclickedProcedure;
import net.mcreator.narutoshippudenmod.procedures.NatureReleaseProcedures.EarthReleaseTechniqueRightclickedProcedure;
import net.mcreator.narutoshippudenmod.procedures.NatureReleaseProcedures.FireReleaseTechniqueRightclickedProcedure;
import net.mcreator.narutoshippudenmod.procedures.NatureReleaseProcedures.LightningReleaseTechniqueRightclickedProcedure;
import net.mcreator.narutoshippudenmod.procedures.NatureReleaseProcedures.WaterReleaseTechniqueRightclickedProcedure;
import net.mcreator.narutoshippudenmod.procedures.NatureReleaseProcedures.WindReleaseTechniqueRightclickedProcedure;
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


public final class ReleaseTechniqueItems {
	private ReleaseTechniqueItems() {
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class BoilReleaseTechniqueItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder("boil_release_technique", v -> block = (Item) v);
		}

		public BoilReleaseTechniqueItem(NarutoShippudenModElements instance) {
			super(instance, 1068);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("boil_release_technique", "ReleaseTechniqueItemGroup").stacksTo(1).rarity(Rarity.COMMON));
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
				list.accept(Component.literal("\u00A72Skilled Mist Technique: \u00A7bChakra cost: 500 \u00A73Ninjutsu required: 25"));
				list.accept(Component.literal("\u00A72Steam Dash: \u00A7bChakra cost: 350 \u00A73Ninjutsu required: 30"));
				list.accept(Component.literal("\u00A72Unrivalled Strength: \u00A7bChakra cost: 400 \u00A73Ninjutsu required: 35"));
			}

			@Override
			public InteractionResult use(Level world, Player entity, InteractionHand hand) {
				InteractionResult ar = super.use(world, entity, hand);
				ItemStack itemstack = entity.getItemInHand(hand);
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();

				BoilReleaseTechniqueRightclickedProcedure.executeProcedure(Stream
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

				BoilReleaseTechniqueLivingEntityIsHitWithItemProcedure.executeProcedure(
						Stream.of(new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("sourceentity", sourceentity))
								.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class BoneReleaseTechniqueItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder("bone_release_technique", v -> block = (Item) v);
		}

		public BoneReleaseTechniqueItem(NarutoShippudenModElements instance) {
			super(instance, 952);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("bone_release_technique", "ReleaseTechniqueItemGroup").stacksTo(1).rarity(Rarity.COMMON));
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
				list.accept(Component.literal("\u00A72Dance of the Camellia: \u00A7bChakra cost: 200 \u00A73Ninjutsu required: 20"));
				list.accept(Component.literal("\u00A72Dance of the Clematis Flower: \u00A7bChakra cost: 350 \u00A73Ninjutsu required: 25"));
				list.accept(Component.literal("\u00A72Dance of the Larch: \u00A7bChakra cost: 80/sec \u00A73Ninjutsu required: 30"));
			}

			@Override
			public InteractionResult use(Level world, Player entity, InteractionHand hand) {
				InteractionResult ar = super.use(world, entity, hand);
				ItemStack itemstack = entity.getItemInHand(hand);
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();

				BoneReleaseTechniqueRightclickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class CustomEarthReleaseTechniqueItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder("custom_earth_release_technique", v -> block = (Item) v);
		}

		public CustomEarthReleaseTechniqueItem(NarutoShippudenModElements instance) {
			super(instance, 516);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("custom_earth_release_technique", null).stacksTo(1).rarity(Rarity.COMMON));
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
				list.accept(Component.literal("Shift Right-Click to show info about jutsu."));
			}

			@Override
			public InteractionResult use(Level world, Player entity, InteractionHand hand) {
				InteractionResult ar = super.use(world, entity, hand);
				ItemStack itemstack = entity.getItemInHand(hand);
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();

				CustomEarthReleaseTechniqueRightClickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class CustomFireReleaseTechniqueItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder("custom_fire_release_technique", v -> block = (Item) v);
		}

		public CustomFireReleaseTechniqueItem(NarutoShippudenModElements instance) {
			super(instance, 493);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("custom_fire_release_technique", null).stacksTo(1).rarity(Rarity.COMMON));
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
				list.accept(Component.literal("Shift Right-Click to show info about jutsu."));
			}

			@Override
			public InteractionResult use(Level world, Player entity, InteractionHand hand) {
				InteractionResult ar = super.use(world, entity, hand);
				ItemStack itemstack = entity.getItemInHand(hand);
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();

				CustomFireReleaseTechniqueRightclickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class CustomLightningReleaseTechniqueItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder("custom_lightning_release_technique", v -> block = (Item) v);
		}

		public CustomLightningReleaseTechniqueItem(NarutoShippudenModElements instance) {
			super(instance, 510);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("custom_lightning_release_technique", null).stacksTo(1).rarity(Rarity.COMMON));
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
				list.accept(Component.literal("Shift Right-Click to show info about jutsu."));
			}

			@Override
			public InteractionResult use(Level world, Player entity, InteractionHand hand) {
				InteractionResult ar = super.use(world, entity, hand);
				ItemStack itemstack = entity.getItemInHand(hand);
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();

				CustomLightningReleaseTechniqueRightClickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class CustomWaterReleaseTechniqueItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder("custom_water_release_technique", v -> block = (Item) v);
		}

		public CustomWaterReleaseTechniqueItem(NarutoShippudenModElements instance) {
			super(instance, 514);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("custom_water_release_technique", null).stacksTo(1).rarity(Rarity.COMMON));
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
				list.accept(Component.literal("Shift Right-Click to show info about jutsu."));
			}

			@Override
			public InteractionResult use(Level world, Player entity, InteractionHand hand) {
				InteractionResult ar = super.use(world, entity, hand);
				ItemStack itemstack = entity.getItemInHand(hand);
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();

				CustomWaterReleaseTechniqueRightClickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class CustomWindReleaseTechniqueItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder("custom_wind_release_technique", v -> block = (Item) v);
		}

		public CustomWindReleaseTechniqueItem(NarutoShippudenModElements instance) {
			super(instance, 512);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("custom_wind_release_technique", null).stacksTo(1).rarity(Rarity.COMMON));
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
				list.accept(Component.literal("Shift Right-Click to show info about jutsu."));
			}

			@Override
			public InteractionResult use(Level world, Player entity, InteractionHand hand) {
				InteractionResult ar = super.use(world, entity, hand);
				ItemStack itemstack = entity.getItemInHand(hand);
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();

				CustomWindReleaseTechniqueRightClickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class DustReleaseTechniqueItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder("dust_release_technique", v -> block = (Item) v);
		}

		public DustReleaseTechniqueItem(NarutoShippudenModElements instance) {
			super(instance, 1079);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("dust_release_technique", "ReleaseTechniqueItemGroup").stacksTo(1).rarity(Rarity.COMMON));
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
						"\u00A72Detachment of the Primitive Level Technique: \u00A7bChakra cost: 5000 \u00A73Ninjutsu required: 70"));
			}

			@Override
			public InteractionResult use(Level world, Player entity, InteractionHand hand) {
				InteractionResult ar = super.use(world, entity, hand);
				ItemStack itemstack = entity.getItemInHand(hand);
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();

				DustReleaseTechniqueRightclickedProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z), new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class EarthReleaseTechniqueItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder("earth_release_technique", v -> block = (Item) v);
		}

		public EarthReleaseTechniqueItem(NarutoShippudenModElements instance) {
			super(instance, 13);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("earth_release_technique", "ReleaseTechniqueItemGroup").stacksTo(1).rarity(Rarity.COMMON));
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
				list.accept(Component.literal("\u00A72Fist Rock Technique: \u00A7bChakra cost: 100 \u00A73Ninjutsu required: 5"));
				list.accept(Component.literal("\u00A72Golem Technique: \u00A7bChakra cost: 150 \u00A73Ninjutsu required: 10"));
				list.accept(Component.literal("\u00A72Earth-Style Wall: \u00A7bChakra cost: 200 \u00A73Ninjutsu required: 15"));
				list.accept(Component.literal("\u00A72Earth Spear: \u00A7bChakra cost: 250 \u00A73Ninjutsu required: 20"));
			}

			@Override
			public InteractionResult use(Level world, Player entity, InteractionHand hand) {
				InteractionResult ar = super.use(world, entity, hand);
				ItemStack itemstack = entity.getItemInHand(hand);
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();

				EarthReleaseTechniqueRightclickedProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z), new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class FireReleaseTechniqueItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder("fire_release_technique", v -> block = (Item) v);
		}

		public FireReleaseTechniqueItem(NarutoShippudenModElements instance) {
			super(instance, 11);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("fire_release_technique", "ReleaseTechniqueItemGroup").stacksTo(1).rarity(Rarity.COMMON));
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
				list.accept(Component.literal("\u00A72Running Fire: \u00A7bChakra cost: 100 \u00A73Ninjutsu required: 5"));
				list.accept(Component.literal("\u00A72Great Fireball Technique: \u00A7bChakra cost: 150 \u00A73Ninjutsu required: 10"));
				list.accept(Component.literal("\u00A72Great Dragon Fire Technique: \u00A7bChakra cost: 200 \u00A73Ninjutsu required: 15"));
				list.accept(Component.literal("\u00A72Phoenix Flower Jutsu: \u00A7bChakra cost: 250 \u00A73Ninjutsu required: 20"));
			}

			@Override
			public InteractionResult use(Level world, Player entity, InteractionHand hand) {
				InteractionResult ar = super.use(world, entity, hand);
				ItemStack itemstack = entity.getItemInHand(hand);
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();

				FireReleaseTechniqueRightclickedProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z), new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class IceReleaseTechniqueItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder("ice_release_technique", v -> block = (Item) v);
		}

		public IceReleaseTechniqueItem(NarutoShippudenModElements instance) {
			super(instance, 807);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("ice_release_technique", "ReleaseTechniqueItemGroup").stacksTo(1).rarity(Rarity.COMMON));
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
				list.accept(Component.literal("\u00A72Certain-Kill Ice Spears: \u00A7bChakra cost: 300 \u00A73Ninjutsu required: 20"));
				list.accept(Component.literal("\u00A72Demonic Mirroring Ice Crystals: \u00A7bChakra cost: 500 \u00A73Ninjutsu required: 30"));
				list.accept(Component.literal("\u00A72Black Dragon Blizzard: \u00A7bChakra cost: 750 \u00A73Ninjutsu required: 35"));
			}

			@Override
			public InteractionResult use(Level world, Player entity, InteractionHand hand) {
				InteractionResult ar = super.use(world, entity, hand);
				ItemStack itemstack = entity.getItemInHand(hand);
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();

				IceReleaseTechniqueRightclickedProcedure
						.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("entity", entity))
								.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class LightningReleaseTechniqueItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder("lightning_release_technique", v -> block = (Item) v);
		}

		public LightningReleaseTechniqueItem(NarutoShippudenModElements instance) {
			super(instance, 15);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("lightning_release_technique", "ReleaseTechniqueItemGroup").stacksTo(1).rarity(Rarity.COMMON));
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
				list.accept(Component.literal("\u00A72Lightning Ball Technique: \u00A7bChakra cost: 100 \u00A73Ninjutsu required: 5"));
				list.accept(Component.literal("\u00A72Chidori Senbon: \u00A7bChakra cost: 150 \u00A73Ninjutsu required: 10"));
				list.accept(Component.literal("\u00A72Lariat: \u00A7bChakra cost: 200 \u00A73Ninjutsu required: 15"));
				list.accept(Component.literal("\u00A72Kirin: \u00A7bChakra cost: 250 \u00A73Ninjutsu required: 20"));
			}

			@Override
			public InteractionResult use(Level world, Player entity, InteractionHand hand) {
				InteractionResult ar = super.use(world, entity, hand);
				ItemStack itemstack = entity.getItemInHand(hand);
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();

				LightningReleaseTechniqueRightclickedProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z), new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class MagnetReleaseTechniqueItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder("magnet_release_technique", v -> block = (Item) v);
		}

		public MagnetReleaseTechniqueItem(NarutoShippudenModElements instance) {
			super(instance, 554);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("magnet_release_technique", "ReleaseTechniqueItemGroup").stacksTo(1).rarity(Rarity.COMMON));
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
				list.accept(Component.literal("\u00A72Iron Sand Coat: \u00A7bChakra cost: 100/sec \u00A73Ninjutsu required: 25"));
				list.accept(Component.literal("\u00A72Iron Sand Drizzle: \u00A7bChakra cost: 500 \u00A73Ninjutsu required: 30"));
				list.accept(Component.literal("\u00A72Black Iron Fist: \u00A7bChakra cost: 140/sec \u00A73Ninjutsu required: 35"));
				list.accept(Component.literal("\u00A72Iron Sand: Black Iron Wings: \u00A7bChakra cost: 120/sec \u00A73Ninjutsu required: 40"));
			}

			@Override
			public InteractionResult use(Level world, Player entity, InteractionHand hand) {
				InteractionResult ar = super.use(world, entity, hand);
				ItemStack itemstack = entity.getItemInHand(hand);
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();

				MagnetReleaseTechniqueRightclickedProcedure
						.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("entity", entity))
								.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class SmokeReleaseTechniqueItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder("smoke_release_technique", v -> block = (Item) v);
		}

		public SmokeReleaseTechniqueItem(NarutoShippudenModElements instance) {
			super(instance, 461);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("smoke_release_technique", "ReleaseTechniqueItemGroup").stacksTo(1).rarity(Rarity.COMMON));
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
				list.accept(Component.literal("\u00A72Smoke Form: \u00A7bChakra cost: 80/sec \u00A73Ninjutsu required: 20"));
				list.accept(Component.literal("\u00A72Smoke Fist: \u00A7bChakra cost: 750 \u00A73Ninjutsu required: 35"));
				list.accept(Component.literal("\u00A72Smoke Gun: \u00A7bChakra cost: 1000 \u00A73Ninjutsu required: 50"));
			}

			@Override
			public InteractionResult use(Level world, Player entity, InteractionHand hand) {
				InteractionResult ar = super.use(world, entity, hand);
				ItemStack itemstack = entity.getItemInHand(hand);
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();

				SmokeReleaseTechniqueRightclickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
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

				SmokeReleaseTechniqueLivingEntityIsHitWithItemProcedure.executeProcedure(
						Stream.of(new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("sourceentity", sourceentity))
								.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class SteelReleaseTechniqueItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder("steel_release_technique", v -> block = (Item) v);
		}

		public SteelReleaseTechniqueItem(NarutoShippudenModElements instance) {
			super(instance, 1083);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("steel_release_technique", "ReleaseTechniqueItemGroup").stacksTo(1).rarity(Rarity.COMMON));
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
				list.accept(Component.literal("\u00A72Impervious Armour: \u00A7bChakra cost: 140/sec \u00A73Ninjutsu required: 20"));
				list.accept(Component.literal("\u00A72Steel Projectile: \u00A7bChakra cost: 450 \u00A73Ninjutsu required: 25"));
			}

			@Override
			public InteractionResult use(Level world, Player entity, InteractionHand hand) {
				InteractionResult ar = super.use(world, entity, hand);
				ItemStack itemstack = entity.getItemInHand(hand);
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();

				SteelReleaseTechniqueRightclickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class StormReleaseTechniqueItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder("storm_release_technique", v -> block = (Item) v);
		}

		public StormReleaseTechniqueItem(NarutoShippudenModElements instance) {
			super(instance, 744);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("storm_release_technique", "ReleaseTechniqueItemGroup").stacksTo(1).rarity(Rarity.COMMON));
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
				list.accept(Component.literal("\u00A72Laser Circus: \u00A7bChakra cost: 30/sec \u00A73Ninjutsu required: 25"));
				list.accept(Component.literal("\u00A72Thunder Cloud Inner Wave: \u00A7bChakra cost: 500 \u00A73Ninjutsu required: 30"));
			}

			@Override
			public InteractionResult use(Level world, Player entity, InteractionHand hand) {
				InteractionResult ar = super.use(world, entity, hand);
				ItemStack itemstack = entity.getItemInHand(hand);
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();

				StormReleaseTechniqueRightclickedProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z), new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class SwiftReleaseTechniqueItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder("swift_release_technique", v -> block = (Item) v);
		}

		public SwiftReleaseTechniqueItem(NarutoShippudenModElements instance) {
			super(instance, 1064);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("swift_release_technique", "ReleaseTechniqueItemGroup").stacksTo(1).rarity(Rarity.COMMON));
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
						"\u00A72Shadowless Flight: \u00A7bChakra cost: 80/sec \u00A73Ninjutsu required: 30 \u00A7aTaijutsu required: 20"));
			}

			@Override
			public InteractionResult use(Level world, Player entity, InteractionHand hand) {
				InteractionResult ar = super.use(world, entity, hand);
				ItemStack itemstack = entity.getItemInHand(hand);
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();

				SwiftReleaseTechniqueRightclickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class TyphoonReleaseTechniqueItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder("typhoon_release_technique", v -> block = (Item) v);
		}

		public TyphoonReleaseTechniqueItem(NarutoShippudenModElements instance) {
			super(instance, 1053);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("typhoon_release_technique", "ReleaseTechniqueItemGroup").stacksTo(1).rarity(Rarity.COMMON));
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
				list.accept(Component.literal("\u00A72Great Consecutive Bursting Strong Winds: \u00A7bChakra cost: 300 \u00A73Ninjutsu required: 20"));
				list.accept(
						Component.literal("\u00A72Great Consecutive Bursting Extreme Winds: \u00A7bChakra cost: 450 \u00A73Ninjutsu required: 25"));
			}

			@Override
			public InteractionResult use(Level world, Player entity, InteractionHand hand) {
				InteractionResult ar = super.use(world, entity, hand);
				ItemStack itemstack = entity.getItemInHand(hand);
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();

				TyphoonReleaseTechniqueRightclickedProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z), new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class WaterReleaseTechniqueItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder("water_release_technique", v -> block = (Item) v);
		}

		public WaterReleaseTechniqueItem(NarutoShippudenModElements instance) {
			super(instance, 12);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("water_release_technique", "ReleaseTechniqueItemGroup").stacksTo(1).rarity(Rarity.COMMON));
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
				list.accept(Component.literal("\u00A72Water Formation Wall: \u00A7bChakra cost: 100 \u00A73Ninjutsu required: 5"));
				list.accept(Component.literal("\u00A72Water Gun: \u00A7bChakra cost: 150 \u00A73Ninjutsu required: 10"));
				list.accept(Component.literal("\u00A72Water Shark Bullet Technique: \u00A7bChakra cost: 200 \u00A73Ninjutsu required: 15"));
				list.accept(Component.literal("\u00A72Water Dragon Bullet Technique: \u00A7bChakra cost: 250 \u00A73Ninjutsu required: 20"));
			}

			@Override
			public InteractionResult use(Level world, Player entity, InteractionHand hand) {
				InteractionResult ar = super.use(world, entity, hand);
				ItemStack itemstack = entity.getItemInHand(hand);
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();

				WaterReleaseTechniqueRightclickedProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z), new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class WindReleaseTechniqueItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder("wind_release_technique", v -> block = (Item) v);
		}

		public WindReleaseTechniqueItem(NarutoShippudenModElements instance) {
			super(instance, 14);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("wind_release_technique", "ReleaseTechniqueItemGroup").stacksTo(1).rarity(Rarity.COMMON));
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
				list.accept(Component.literal("\u00A72Boruto Stream: \u00A7bChakra cost: 100 \u00A73Ninjutsu required: 5"));
				list.accept(Component.literal("\u00A72Vacuum Sphere: \u00A7bChakra cost: 150 \u00A73Ninjutsu required: 10"));
				list.accept(Component.literal("\u00A72Wind Mode: \u00A7bChakra cost: 20/sec \u00A73Ninjutsu required: 15"));
				list.accept(Component.literal("\u00A72Rasenshuriken: \u00A7bChakra cost: 250 \u00A73Ninjutsu required: 20"));
			}

			@Override
			public InteractionResult use(Level world, Player entity, InteractionHand hand) {
				InteractionResult ar = super.use(world, entity, hand);
				ItemStack itemstack = entity.getItemInHand(hand);
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();

				WindReleaseTechniqueRightclickedProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z), new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class WoodReleaseTechniqueItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder("wood_release_technique", v -> block = (Item) v);
		}

		public WoodReleaseTechniqueItem(NarutoShippudenModElements instance) {
			super(instance, 786);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("wood_release_technique", "ReleaseTechniqueItemGroup").stacksTo(1).rarity(Rarity.COMMON));
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
				list.accept(Component.literal("\u00A72Wood Dragon Technique: \u00A7bChakra cost: 300 \u00A73Ninjutsu required: 25"));
				list.accept(Component.literal("\u00A72Tree Bind Flourishing Burial: \u00A7bChakra cost: 500 \u00A73Ninjutsu required: 30"));
				list.accept(Component.literal("\u00A72Wood Human Technique: \u00A7bChakra cost: 650 \u00A73Ninjutsu required: 35"));
			}

			@Override
			public InteractionResult use(Level world, Player entity, InteractionHand hand) {
				InteractionResult ar = super.use(world, entity, hand);
				ItemStack itemstack = entity.getItemInHand(hand);
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();

				WoodReleaseTechniqueRightclickedProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z), new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}
}
