package net.mcreator.narutoshippudenmod.item;

import net.mcreator.narutoshippudenmod.compat.Registration;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import net.mcreator.narutoshippudenmod.NarutoShippudenModElements;
import net.mcreator.narutoshippudenmod.itemgroup.ModItemGroups.ReleasesItemGroup;
import net.mcreator.narutoshippudenmod.procedures.ClanProcedures.ChakraNatureResetRightclickedProcedure;
import net.mcreator.narutoshippudenmod.procedures.KekkeiGenkaiProcedures.BoilReleaseRightClickedProcedure;
import net.mcreator.narutoshippudenmod.procedures.KekkeiGenkaiProcedures.BoneReleaseRightclickedProcedure;
import net.mcreator.narutoshippudenmod.procedures.KekkeiGenkaiProcedures.DustReleaseRightClickedProcedure;
import net.mcreator.narutoshippudenmod.procedures.KekkeiGenkaiProcedures.IceReleaseRightclickedProcedure;
import net.mcreator.narutoshippudenmod.procedures.KekkeiGenkaiProcedures.MagnetReleaseRightclickedProcedure;
import net.mcreator.narutoshippudenmod.procedures.KekkeiGenkaiProcedures.SmokeReleaseRightclickedProcedure;
import net.mcreator.narutoshippudenmod.procedures.KekkeiGenkaiProcedures.SteelReleaseRightClickedProcedure;
import net.mcreator.narutoshippudenmod.procedures.KekkeiGenkaiProcedures.StormReleaseRightclickedProcedure;
import net.mcreator.narutoshippudenmod.procedures.KekkeiGenkaiProcedures.SwiftReleaseRightClickedProcedure;
import net.mcreator.narutoshippudenmod.procedures.KekkeiGenkaiProcedures.TyphoonReleaseRightClickedProcedure;
import net.mcreator.narutoshippudenmod.procedures.KekkeiGenkaiProcedures.WoodReleaseRightclickedProcedure;
import net.mcreator.narutoshippudenmod.procedures.NatureReleaseProcedures.EarthReleaseRightClickedProcedure;
import net.mcreator.narutoshippudenmod.procedures.NatureReleaseProcedures.FireReleaseRightclickedProcedure;
import net.mcreator.narutoshippudenmod.procedures.NatureReleaseProcedures.LightningReleaseRightClickedProcedure;
import net.mcreator.narutoshippudenmod.procedures.NatureReleaseProcedures.WaterReleaseRightClickedProcedure;
import net.mcreator.narutoshippudenmod.procedures.NatureReleaseProcedures.WindReleaseRightclickedProcedure;
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


public final class ReleaseItems {
	private ReleaseItems() {
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class BoilReleaseItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder("boil_release", v -> block = (Item) v);
		}

		public BoilReleaseItem(NarutoShippudenModElements instance) {
			super(instance, 1065);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("boil_release", "ReleasesItemGroup").stacksTo(1).rarity(Rarity.EPIC));
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
				list.accept(Component.literal("\u00A76Learn Boil Release: Skilled Mist Technique \u00A74Cost: 20 JP"));
				list.accept(Component.literal("\u00A76Learn Boil Release: Steam Dash \u00A74Cost: 25 JP"));
				list.accept(Component.literal("\u00A76Learn Boil Release: Unrivalled Strength \u00A74Cost: 30 JP"));
			}

			@Override
			public InteractionResult use(Level world, Player entity, InteractionHand hand) {
				InteractionResult ar = super.use(world, entity, hand);
				ItemStack itemstack = entity.getItemInHand(hand);
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();

				BoilReleaseRightClickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class BoneReleaseItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder("bone_release", v -> block = (Item) v);
		}

		public BoneReleaseItem(NarutoShippudenModElements instance) {
			super(instance, 951);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("bone_release", "ReleasesItemGroup").stacksTo(1).rarity(Rarity.EPIC));
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
				list.accept(Component.literal("\u00A76Learn Bone Release: Dance of the Camellia \u00A74Cost: 15 JP"));
				list.accept(Component.literal("\u00A76Learn Bone Release: Dance of the Clematis: Flower \u00A74Cost: 20 JP"));
				list.accept(Component.literal("\u00A76Learn Bone Release: Dance of the Larch \u00A74Cost: 25 JP"));
			}

			@Override
			public InteractionResult use(Level world, Player entity, InteractionHand hand) {
				InteractionResult ar = super.use(world, entity, hand);
				ItemStack itemstack = entity.getItemInHand(hand);
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();

				BoneReleaseRightclickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class ChakraNatureResetItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder("chakra_nature_reset", v -> block = (Item) v);
		}

		public ChakraNatureResetItem(NarutoShippudenModElements instance) {
			super(instance, 1025);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("chakra_nature_reset", "ReleasesItemGroup").stacksTo(1).rarity(Rarity.EPIC));
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
				list.accept(Component.literal("Right-Click to reset your chakra natures"));
			}

			@Override
			public InteractionResult use(Level world, Player entity, InteractionHand hand) {
				InteractionResult ar = super.use(world, entity, hand);
				ItemStack itemstack = entity.getItemInHand(hand);
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();

				ChakraNatureResetRightclickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class DustReleaseItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder("dust_release", v -> block = (Item) v);
		}

		public DustReleaseItem(NarutoShippudenModElements instance) {
			super(instance, 1078);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("dust_release", "ReleasesItemGroup").stacksTo(1).rarity(Rarity.EPIC));
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
				list.accept(Component.literal("\u00A76Learn Dust Release: Detachment of the Primitive Level Technique \u00A74Cost: 100 JP"));
			}

			@Override
			public InteractionResult use(Level world, Player entity, InteractionHand hand) {
				InteractionResult ar = super.use(world, entity, hand);
				ItemStack itemstack = entity.getItemInHand(hand);
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();

				DustReleaseRightClickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class EarthReleaseItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder("earth_release", v -> block = (Item) v);
		}

		public EarthReleaseItem(NarutoShippudenModElements instance) {
			super(instance, 9);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("earth_release", "ReleasesItemGroup").stacksTo(1).rarity(Rarity.EPIC));
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
				list.accept(Component.literal("\u00A76Learn Earth Release: Fist Rock Technique \u00A74Cost: 5 JP"));
				list.accept(Component.literal("\u00A76Learn Earth Release: Golem Technique \u00A74Cost: 10 JP"));
				list.accept(Component.literal("\u00A76Learn Earth Release: Earth-Style Wall \u00A74Cost: 15 JP"));
				list.accept(Component.literal("\u00A76Learn Earth Release: Earth Spear \u00A74Cost: 20 JP"));
			}

			@Override
			public InteractionResult use(Level world, Player entity, InteractionHand hand) {
				InteractionResult ar = super.use(world, entity, hand);
				ItemStack itemstack = entity.getItemInHand(hand);
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();

				EarthReleaseRightClickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class FireReleaseItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder("fire_release", v -> block = (Item) v);
		}

		public FireReleaseItem(NarutoShippudenModElements instance) {
			super(instance, 5);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("fire_release", "ReleasesItemGroup").stacksTo(1).rarity(Rarity.EPIC));
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
				list.accept(Component.literal("\u00A76Learn Fire Release: Running Fire \u00A74Cost: 5 JP"));
				list.accept(Component.literal("\u00A76Learn Fire Release: Great Fireball Technique \u00A74Cost: 10 JP"));
				list.accept(Component.literal("\u00A76Learn Fire Release: Great Dragon Fire Technique \u00A74Cost: 15 JP"));
				list.accept(Component.literal("\u00A76Learn Fire Release: Phoenix Flower Jutsu \u00A74Cost: 20 JP"));
			}

			@Override
			public InteractionResult use(Level world, Player entity, InteractionHand hand) {
				InteractionResult ar = super.use(world, entity, hand);
				ItemStack itemstack = entity.getItemInHand(hand);
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();

				FireReleaseRightclickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class IceReleaseItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder("ice_release", v -> block = (Item) v);
		}

		public IceReleaseItem(NarutoShippudenModElements instance) {
			super(instance, 806);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("ice_release", "ReleasesItemGroup").stacksTo(1).rarity(Rarity.EPIC));
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
				list.accept(Component.literal("\u00A76Learn Ice Release: Certain-Kill Ice Spears \u00A74Cost: 15 JP"));
				list.accept(Component.literal("\u00A76Learn Ice Release: Demonic Mirroring Ice Crystals \u00A74Cost: 20 JP"));
				list.accept(Component.literal("\u00A76Learn Ice Release: Black Dragon Blizzard \u00A74Cost: 25 JP"));
			}

			@Override
			public InteractionResult use(Level world, Player entity, InteractionHand hand) {
				InteractionResult ar = super.use(world, entity, hand);
				ItemStack itemstack = entity.getItemInHand(hand);
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();

				IceReleaseRightclickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class LightningReleaseItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder("lightning_release", v -> block = (Item) v);
		}

		public LightningReleaseItem(NarutoShippudenModElements instance) {
			super(instance, 10);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("lightning_release", "ReleasesItemGroup").stacksTo(1).rarity(Rarity.EPIC));
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
				list.accept(Component.literal("\u00A76Learn Lightning Release: Lightning Ball Technique \u00A74Cost: 5 JP"));
				list.accept(Component.literal("\u00A76Learn Lightning Release: Chidori Senbon \u00A74Cost: 10 JP"));
				list.accept(Component.literal("\u00A76Learn Lightning Release: Lariat \u00A74Cost: 15 JP"));
				list.accept(Component.literal("\u00A76Learn Lightning Release: Kirin \u00A74Cost: 20 JP"));
			}

			@Override
			public InteractionResult use(Level world, Player entity, InteractionHand hand) {
				InteractionResult ar = super.use(world, entity, hand);
				ItemStack itemstack = entity.getItemInHand(hand);
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();

				LightningReleaseRightClickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class MagnetReleaseItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder("magnet_release", v -> block = (Item) v);
		}

		public MagnetReleaseItem(NarutoShippudenModElements instance) {
			super(instance, 553);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("magnet_release", "ReleasesItemGroup").stacksTo(1).rarity(Rarity.EPIC));
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
				list.accept(Component.literal("\u00A76Learn Magnet Release: Iron Sand Coat \u00A74Cost: 25 JP"));
				list.accept(Component.literal("\u00A76Learn Magnet Release: Iron Sand Drizzle \u00A74Cost: 30 JP"));
				list.accept(Component.literal("\u00A76Learn Magnet Release: Black Iron Fist \u00A74Cost: 35 JP"));
				list.accept(Component.literal("\u00A76Learn Magnet Release: Iron Sand: Black Iron Wings \u00A74Cost: 40 JP"));
			}

			@Override
			public InteractionResult use(Level world, Player entity, InteractionHand hand) {
				InteractionResult ar = super.use(world, entity, hand);
				ItemStack itemstack = entity.getItemInHand(hand);
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();

				MagnetReleaseRightclickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class SmokeReleaseItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder("smoke_release", v -> block = (Item) v);
		}

		public SmokeReleaseItem(NarutoShippudenModElements instance) {
			super(instance, 459);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("smoke_release", "ReleasesItemGroup").stacksTo(1).rarity(Rarity.EPIC));
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
				list.accept(Component.literal("\u00A76Learn Smoke Release: Smoke Form \u00A74Cost: 25 JP"));
				list.accept(Component.literal("\u00A76Learn Smoke Release: Smoke Fist \u00A74Cost: 30 JP"));
				list.accept(Component.literal("\u00A76Learn Smoke Release: Smoke Gun \u00A74Cost: 35 JP"));
			}

			@Override
			public InteractionResult use(Level world, Player entity, InteractionHand hand) {
				InteractionResult ar = super.use(world, entity, hand);
				ItemStack itemstack = entity.getItemInHand(hand);
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();

				SmokeReleaseRightclickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class SteelReleaseItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder("steel_release", v -> block = (Item) v);
		}

		public SteelReleaseItem(NarutoShippudenModElements instance) {
			super(instance, 1082);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("steel_release", "ReleasesItemGroup").stacksTo(1).rarity(Rarity.EPIC));
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
				list.accept(Component.literal("\u00A76Learn Steel Release: Impervious Armour \u00A74Cost: 25 JP"));
				list.accept(Component.literal("\u00A76Learn Steel Release: Steel Projectile \u00A74Cost: 30 JP"));
			}

			@Override
			public InteractionResult use(Level world, Player entity, InteractionHand hand) {
				InteractionResult ar = super.use(world, entity, hand);
				ItemStack itemstack = entity.getItemInHand(hand);
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();

				SteelReleaseRightClickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class StormReleaseItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder("storm_release", v -> block = (Item) v);
		}

		public StormReleaseItem(NarutoShippudenModElements instance) {
			super(instance, 743);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("storm_release", "ReleasesItemGroup").stacksTo(1).rarity(Rarity.EPIC));
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
				list.accept(Component.literal("\u00A76Learn Storm Release: Laser Circus \u00A74Cost: 25 JP"));
				list.accept(Component.literal("\u00A76Learn Storm Release: Thunder Cloud Inner Wave \u00A74Cost: 30 JP"));
			}

			@Override
			public InteractionResult use(Level world, Player entity, InteractionHand hand) {
				InteractionResult ar = super.use(world, entity, hand);
				ItemStack itemstack = entity.getItemInHand(hand);
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();

				StormReleaseRightclickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class SwiftReleaseItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder("swift_release", v -> block = (Item) v);
		}

		public SwiftReleaseItem(NarutoShippudenModElements instance) {
			super(instance, 1063);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("swift_release", "ReleasesItemGroup").stacksTo(1).rarity(Rarity.EPIC));
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
				list.accept(Component.literal("\u00A76Learn Swift Release: Shadowless Flight \u00A74Cost: 35 JP"));
			}

			@Override
			public InteractionResult use(Level world, Player entity, InteractionHand hand) {
				InteractionResult ar = super.use(world, entity, hand);
				ItemStack itemstack = entity.getItemInHand(hand);
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();

				SwiftReleaseRightClickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class TyphoonReleaseItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder("typhoon_release", v -> block = (Item) v);
		}

		public TyphoonReleaseItem(NarutoShippudenModElements instance) {
			super(instance, 1052);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("typhoon_release", "ReleasesItemGroup").stacksTo(1).rarity(Rarity.EPIC));
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
				list.accept(Component.literal("\u00A76Learn Typhoon Release: Great Consecutive Bursting Strong Winds \u00A74Cost: 25 JP"));
				list.accept(Component.literal(
						"\u00A76Learn Typhoon Release: Typhoon Release: Great Consecutive Bursting Extreme Winds \u00A74Cost: 30 JP"));
			}

			@Override
			public InteractionResult use(Level world, Player entity, InteractionHand hand) {
				InteractionResult ar = super.use(world, entity, hand);
				ItemStack itemstack = entity.getItemInHand(hand);
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();

				TyphoonReleaseRightClickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class WaterReleaseItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder("water_release", v -> block = (Item) v);
		}

		public WaterReleaseItem(NarutoShippudenModElements instance) {
			super(instance, 8);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("water_release", "ReleasesItemGroup").stacksTo(1).rarity(Rarity.EPIC));
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
				list.accept(Component.literal("\u00A76Learn Water Release: Water Formation Wall \u00A74Cost: 5 JP"));
				list.accept(Component.literal("\u00A76Learn Water Release: Water Gun \u00A74Cost: 10 JP"));
				list.accept(Component.literal("\u00A76Learn Water Release: Water Shark Bullet Technique \u00A74Cost: 15 JP"));
				list.accept(Component.literal("\u00A76Learn Water Release: Water Dragon \u00A74Cost: 20 JP"));
			}

			@Override
			public InteractionResult use(Level world, Player entity, InteractionHand hand) {
				InteractionResult ar = super.use(world, entity, hand);
				ItemStack itemstack = entity.getItemInHand(hand);
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();

				WaterReleaseRightClickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class WindReleaseItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder("wind_release", v -> block = (Item) v);
		}

		public WindReleaseItem(NarutoShippudenModElements instance) {
			super(instance, 7);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("wind_release", "ReleasesItemGroup").stacksTo(1).rarity(Rarity.EPIC));
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
				list.accept(Component.literal("\u00A76Learn Wind Release: Boruto Stream \u00A74Cost: 5 JP"));
				list.accept(Component.literal("\u00A76Learn Wind Release: Vacuum Sphere \u00A74Cost: 10 JP"));
				list.accept(Component.literal("\u00A76Learn Wind Release: Wind Mode \u00A74Cost: 15 JP"));
				list.accept(Component.literal("\u00A76Learn Wind Release: Rasenshuriken \u00A74Cost: 20 JP"));
			}

			@Override
			public InteractionResult use(Level world, Player entity, InteractionHand hand) {
				InteractionResult ar = super.use(world, entity, hand);
				ItemStack itemstack = entity.getItemInHand(hand);
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();

				WindReleaseRightclickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class WoodReleaseItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder("wood_release", v -> block = (Item) v);
		}

		public WoodReleaseItem(NarutoShippudenModElements instance) {
			super(instance, 785);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("wood_release", "ReleasesItemGroup").stacksTo(1).rarity(Rarity.EPIC));
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
				list.accept(Component.literal("\u00A76Learn Wood Release: Wood Dragon Technique \u00A74Cost: 20 JP"));
				list.accept(Component.literal("\u00A76Learn Wood Release: Tree Bind Flourishing Burial \u00A74Cost: 25 JP"));
				list.accept(Component.literal("\u00A76Learn Wood Release: Wood Human Technique \u00A74Cost: 30 JP"));
			}

			@Override
			public InteractionResult use(Level world, Player entity, InteractionHand hand) {
				InteractionResult ar = super.use(world, entity, hand);
				ItemStack itemstack = entity.getItemInHand(hand);
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();

				WoodReleaseRightclickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}
}
