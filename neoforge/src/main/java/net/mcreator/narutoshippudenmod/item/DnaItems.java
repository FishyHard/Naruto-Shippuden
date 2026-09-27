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
import net.mcreator.narutoshippudenmod.procedures.KekkeiGenkaiProcedures.BoilDNAImplantMobProcedure;
import net.mcreator.narutoshippudenmod.procedures.KekkeiGenkaiProcedures.BoilDNARightClickedProcedure;
import net.mcreator.narutoshippudenmod.procedures.KekkeiGenkaiProcedures.BoneDNAImplantMobProcedure;
import net.mcreator.narutoshippudenmod.procedures.KekkeiGenkaiProcedures.BoneDNARightClickedProcedure;
import net.mcreator.narutoshippudenmod.procedures.KekkeiGenkaiProcedures.DustDNAImplantMobProcedure;
import net.mcreator.narutoshippudenmod.procedures.KekkeiGenkaiProcedures.DustDNARightClickedProcedure;
import net.mcreator.narutoshippudenmod.procedures.KekkeiGenkaiProcedures.IceDNAImplantMobProcedure;
import net.mcreator.narutoshippudenmod.procedures.KekkeiGenkaiProcedures.IceDNARightClickedProcedure;
import net.mcreator.narutoshippudenmod.procedures.KekkeiGenkaiProcedures.MagnetDNAImplantMobProcedure;
import net.mcreator.narutoshippudenmod.procedures.KekkeiGenkaiProcedures.MagnetDNARightClickedProcedure;
import net.mcreator.narutoshippudenmod.procedures.KekkeiGenkaiProcedures.SmokeDNAImplantMobProcedure;
import net.mcreator.narutoshippudenmod.procedures.KekkeiGenkaiProcedures.SmokeDNARightClickedProcedure;
import net.mcreator.narutoshippudenmod.procedures.KekkeiGenkaiProcedures.SteelDNAImplantMobProcedure;
import net.mcreator.narutoshippudenmod.procedures.KekkeiGenkaiProcedures.SteelDNARightClickedProcedure;
import net.mcreator.narutoshippudenmod.procedures.KekkeiGenkaiProcedures.StormDNAImplantMobProcedure;
import net.mcreator.narutoshippudenmod.procedures.KekkeiGenkaiProcedures.StormDNARightClickedProcedure;
import net.mcreator.narutoshippudenmod.procedures.KekkeiGenkaiProcedures.SwiftDNAImplantMobProcedure;
import net.mcreator.narutoshippudenmod.procedures.KekkeiGenkaiProcedures.SwiftDNARightClickedProcedure;
import net.mcreator.narutoshippudenmod.procedures.KekkeiGenkaiProcedures.TyphoonDNAImplantMobProcedure;
import net.mcreator.narutoshippudenmod.procedures.KekkeiGenkaiProcedures.TyphoonDNARightClickedProcedure;
import net.mcreator.narutoshippudenmod.procedures.KekkeiGenkaiProcedures.UndefinedDNARightclickedProcedure;
import net.mcreator.narutoshippudenmod.procedures.KekkeiGenkaiProcedures.WoodDNAImplantMobProcedure;
import net.mcreator.narutoshippudenmod.procedures.KekkeiGenkaiProcedures.WoodDNARightClickedProcedure;
import net.mcreator.narutoshippudenmod.procedures.NatureReleaseProcedures.EarthDNAImplantMobProcedure;
import net.mcreator.narutoshippudenmod.procedures.NatureReleaseProcedures.EarthDNARightClickedProcedure;
import net.mcreator.narutoshippudenmod.procedures.NatureReleaseProcedures.FireDNAImplantMobProcedure;
import net.mcreator.narutoshippudenmod.procedures.NatureReleaseProcedures.FireDNARightclickedProcedure;
import net.mcreator.narutoshippudenmod.procedures.NatureReleaseProcedures.LightningDNAImplantMobProcedure;
import net.mcreator.narutoshippudenmod.procedures.NatureReleaseProcedures.LightningDNARightClickedProcedure;
import net.mcreator.narutoshippudenmod.procedures.NatureReleaseProcedures.WaterDNAImplantMobProcedure;
import net.mcreator.narutoshippudenmod.procedures.NatureReleaseProcedures.WaterDNARightClickedProcedure;
import net.mcreator.narutoshippudenmod.procedures.NatureReleaseProcedures.WindDNAImplantMobProcedure;
import net.mcreator.narutoshippudenmod.procedures.NatureReleaseProcedures.WindDNARightClickedProcedure;
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

			@Override
			public void appendHoverText(ItemStack itemstack, Item.TooltipContext world, net.minecraft.world.item.component.TooltipDisplay display, java.util.function.Consumer<Component> list, TooltipFlag flag) {
				super.appendHoverText(itemstack, world, display, list, flag);
				list.accept(Component.literal("Implant Chance 50%"));
			}

			@Override
			public InteractionResult use(Level world, Player entity, InteractionHand hand) {
				InteractionResult ar = super.use(world, entity, hand);
				ItemStack itemstack = entity.getItemInHand(hand);
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();

				BoilDNARightClickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}

			@Override
			public void hurtEnemy(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
				super.hurtEnemy(itemstack, entity, sourceentity);
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
				Level world = entity.level();

				BoilDNAImplantMobProcedure.executeProcedure(
						Stream.of(new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("sourceentity", sourceentity))
								.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return;
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

			@Override
			public void appendHoverText(ItemStack itemstack, Item.TooltipContext world, net.minecraft.world.item.component.TooltipDisplay display, java.util.function.Consumer<Component> list, TooltipFlag flag) {
				super.appendHoverText(itemstack, world, display, list, flag);
				list.accept(Component.literal("Implant Chance 50%"));
			}

			@Override
			public InteractionResult use(Level world, Player entity, InteractionHand hand) {
				InteractionResult ar = super.use(world, entity, hand);
				ItemStack itemstack = entity.getItemInHand(hand);
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();

				BoneDNARightClickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}

			@Override
			public void hurtEnemy(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
				super.hurtEnemy(itemstack, entity, sourceentity);
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
				Level world = entity.level();

				BoneDNAImplantMobProcedure.executeProcedure(
						Stream.of(new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("sourceentity", sourceentity))
								.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return;
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

			@Override
			public void appendHoverText(ItemStack itemstack, Item.TooltipContext world, net.minecraft.world.item.component.TooltipDisplay display, java.util.function.Consumer<Component> list, TooltipFlag flag) {
				super.appendHoverText(itemstack, world, display, list, flag);
				list.accept(Component.literal("Implant Chance 50%"));
			}

			@Override
			public InteractionResult use(Level world, Player entity, InteractionHand hand) {
				InteractionResult ar = super.use(world, entity, hand);
				ItemStack itemstack = entity.getItemInHand(hand);
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();

				DustDNARightClickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}

			@Override
			public void hurtEnemy(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
				super.hurtEnemy(itemstack, entity, sourceentity);
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
				Level world = entity.level();

				DustDNAImplantMobProcedure.executeProcedure(
						Stream.of(new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("sourceentity", sourceentity))
								.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return;
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

			@Override
			public void appendHoverText(ItemStack itemstack, Item.TooltipContext world, net.minecraft.world.item.component.TooltipDisplay display, java.util.function.Consumer<Component> list, TooltipFlag flag) {
				super.appendHoverText(itemstack, world, display, list, flag);
				list.accept(Component.literal("Implant Chance 70%"));
			}

			@Override
			public InteractionResult use(Level world, Player entity, InteractionHand hand) {
				InteractionResult ar = super.use(world, entity, hand);
				ItemStack itemstack = entity.getItemInHand(hand);
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();

				EarthDNARightClickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}

			@Override
			public void hurtEnemy(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
				super.hurtEnemy(itemstack, entity, sourceentity);
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
				Level world = entity.level();

				EarthDNAImplantMobProcedure.executeProcedure(
						Stream.of(new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("sourceentity", sourceentity))
								.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return;
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

			@Override
			public void appendHoverText(ItemStack itemstack, Item.TooltipContext world, net.minecraft.world.item.component.TooltipDisplay display, java.util.function.Consumer<Component> list, TooltipFlag flag) {
				super.appendHoverText(itemstack, world, display, list, flag);
				list.accept(Component.literal("Implant Chance 70%"));
			}

			@Override
			public InteractionResult use(Level world, Player entity, InteractionHand hand) {
				InteractionResult ar = super.use(world, entity, hand);
				ItemStack itemstack = entity.getItemInHand(hand);
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();

				FireDNARightclickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}

			@Override
			public void hurtEnemy(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
				super.hurtEnemy(itemstack, entity, sourceentity);
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
				Level world = entity.level();

				FireDNAImplantMobProcedure.executeProcedure(
						Stream.of(new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("sourceentity", sourceentity))
								.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return;
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

			@Override
			public void appendHoverText(ItemStack itemstack, Item.TooltipContext world, net.minecraft.world.item.component.TooltipDisplay display, java.util.function.Consumer<Component> list, TooltipFlag flag) {
				super.appendHoverText(itemstack, world, display, list, flag);
				list.accept(Component.literal("Implant Chance 50%"));
			}

			@Override
			public InteractionResult use(Level world, Player entity, InteractionHand hand) {
				InteractionResult ar = super.use(world, entity, hand);
				ItemStack itemstack = entity.getItemInHand(hand);
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();

				IceDNARightClickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}

			@Override
			public void hurtEnemy(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
				super.hurtEnemy(itemstack, entity, sourceentity);
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
				Level world = entity.level();

				IceDNAImplantMobProcedure.executeProcedure(
						Stream.of(new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("sourceentity", sourceentity))
								.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return;
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

			@Override
			public void appendHoverText(ItemStack itemstack, Item.TooltipContext world, net.minecraft.world.item.component.TooltipDisplay display, java.util.function.Consumer<Component> list, TooltipFlag flag) {
				super.appendHoverText(itemstack, world, display, list, flag);
				list.accept(Component.literal("Implant Chance 70%"));
			}

			@Override
			public InteractionResult use(Level world, Player entity, InteractionHand hand) {
				InteractionResult ar = super.use(world, entity, hand);
				ItemStack itemstack = entity.getItemInHand(hand);
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();

				LightningDNARightClickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}

			@Override
			public void hurtEnemy(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
				super.hurtEnemy(itemstack, entity, sourceentity);
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
				Level world = entity.level();

				LightningDNAImplantMobProcedure.executeProcedure(
						Stream.of(new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("sourceentity", sourceentity))
								.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return;
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

			@Override
			public void appendHoverText(ItemStack itemstack, Item.TooltipContext world, net.minecraft.world.item.component.TooltipDisplay display, java.util.function.Consumer<Component> list, TooltipFlag flag) {
				super.appendHoverText(itemstack, world, display, list, flag);
				list.accept(Component.literal("Implant Chance 50%"));
			}

			@Override
			public InteractionResult use(Level world, Player entity, InteractionHand hand) {
				InteractionResult ar = super.use(world, entity, hand);
				ItemStack itemstack = entity.getItemInHand(hand);
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();

				MagnetDNARightClickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}

			@Override
			public void hurtEnemy(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
				super.hurtEnemy(itemstack, entity, sourceentity);
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
				Level world = entity.level();

				MagnetDNAImplantMobProcedure.executeProcedure(
						Stream.of(new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("sourceentity", sourceentity))
								.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return;
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

			@Override
			public void appendHoverText(ItemStack itemstack, Item.TooltipContext world, net.minecraft.world.item.component.TooltipDisplay display, java.util.function.Consumer<Component> list, TooltipFlag flag) {
				super.appendHoverText(itemstack, world, display, list, flag);
				list.accept(Component.literal("Implant Chance 50%"));
			}

			@Override
			public InteractionResult use(Level world, Player entity, InteractionHand hand) {
				InteractionResult ar = super.use(world, entity, hand);
				ItemStack itemstack = entity.getItemInHand(hand);
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();

				SmokeDNARightClickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}

			@Override
			public void hurtEnemy(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
				super.hurtEnemy(itemstack, entity, sourceentity);
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
				Level world = entity.level();

				SmokeDNAImplantMobProcedure.executeProcedure(
						Stream.of(new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("sourceentity", sourceentity))
								.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return;
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

			@Override
			public void appendHoverText(ItemStack itemstack, Item.TooltipContext world, net.minecraft.world.item.component.TooltipDisplay display, java.util.function.Consumer<Component> list, TooltipFlag flag) {
				super.appendHoverText(itemstack, world, display, list, flag);
				list.accept(Component.literal("Implant Chance 50%"));
			}

			@Override
			public InteractionResult use(Level world, Player entity, InteractionHand hand) {
				InteractionResult ar = super.use(world, entity, hand);
				ItemStack itemstack = entity.getItemInHand(hand);
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();

				SteelDNARightClickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}

			@Override
			public void hurtEnemy(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
				super.hurtEnemy(itemstack, entity, sourceentity);
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
				Level world = entity.level();

				SteelDNAImplantMobProcedure.executeProcedure(
						Stream.of(new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("sourceentity", sourceentity))
								.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return;
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

			@Override
			public void appendHoverText(ItemStack itemstack, Item.TooltipContext world, net.minecraft.world.item.component.TooltipDisplay display, java.util.function.Consumer<Component> list, TooltipFlag flag) {
				super.appendHoverText(itemstack, world, display, list, flag);
				list.accept(Component.literal("Implant Chance 50%"));
			}

			@Override
			public InteractionResult use(Level world, Player entity, InteractionHand hand) {
				InteractionResult ar = super.use(world, entity, hand);
				ItemStack itemstack = entity.getItemInHand(hand);
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();

				StormDNARightClickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}

			@Override
			public void hurtEnemy(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
				super.hurtEnemy(itemstack, entity, sourceentity);
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
				Level world = entity.level();

				StormDNAImplantMobProcedure.executeProcedure(
						Stream.of(new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("sourceentity", sourceentity))
								.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return;
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

			@Override
			public void appendHoverText(ItemStack itemstack, Item.TooltipContext world, net.minecraft.world.item.component.TooltipDisplay display, java.util.function.Consumer<Component> list, TooltipFlag flag) {
				super.appendHoverText(itemstack, world, display, list, flag);
				list.accept(Component.literal("Implant Chance 50%"));
			}

			@Override
			public InteractionResult use(Level world, Player entity, InteractionHand hand) {
				InteractionResult ar = super.use(world, entity, hand);
				ItemStack itemstack = entity.getItemInHand(hand);
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();

				SwiftDNARightClickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}

			@Override
			public void hurtEnemy(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
				super.hurtEnemy(itemstack, entity, sourceentity);
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
				Level world = entity.level();

				SwiftDNAImplantMobProcedure.executeProcedure(
						Stream.of(new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("sourceentity", sourceentity))
								.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return;
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

			@Override
			public void appendHoverText(ItemStack itemstack, Item.TooltipContext world, net.minecraft.world.item.component.TooltipDisplay display, java.util.function.Consumer<Component> list, TooltipFlag flag) {
				super.appendHoverText(itemstack, world, display, list, flag);
				list.accept(Component.literal("Implant Chance 50%"));
			}

			@Override
			public InteractionResult use(Level world, Player entity, InteractionHand hand) {
				InteractionResult ar = super.use(world, entity, hand);
				ItemStack itemstack = entity.getItemInHand(hand);
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();

				TyphoonDNARightClickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}

			@Override
			public void hurtEnemy(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
				super.hurtEnemy(itemstack, entity, sourceentity);
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
				Level world = entity.level();

				TyphoonDNAImplantMobProcedure.executeProcedure(
						Stream.of(new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("sourceentity", sourceentity))
								.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return;
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

			@Override
			public void appendHoverText(ItemStack itemstack, Item.TooltipContext world, net.minecraft.world.item.component.TooltipDisplay display, java.util.function.Consumer<Component> list, TooltipFlag flag) {
				super.appendHoverText(itemstack, world, display, list, flag);
				list.accept(Component.literal("Identifying chance 50%"));
			}

			@Override
			public InteractionResult use(Level world, Player entity, InteractionHand hand) {
				InteractionResult ar = super.use(world, entity, hand);
				ItemStack itemstack = entity.getItemInHand(hand);
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();

				UndefinedDNARightclickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
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

			@Override
			public void appendHoverText(ItemStack itemstack, Item.TooltipContext world, net.minecraft.world.item.component.TooltipDisplay display, java.util.function.Consumer<Component> list, TooltipFlag flag) {
				super.appendHoverText(itemstack, world, display, list, flag);
				list.accept(Component.literal("Implant Chance 70%"));
			}

			@Override
			public InteractionResult use(Level world, Player entity, InteractionHand hand) {
				InteractionResult ar = super.use(world, entity, hand);
				ItemStack itemstack = entity.getItemInHand(hand);
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();

				WaterDNARightClickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}

			@Override
			public void hurtEnemy(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
				super.hurtEnemy(itemstack, entity, sourceentity);
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
				Level world = entity.level();

				WaterDNAImplantMobProcedure.executeProcedure(
						Stream.of(new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("sourceentity", sourceentity))
								.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return;
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

			@Override
			public void appendHoverText(ItemStack itemstack, Item.TooltipContext world, net.minecraft.world.item.component.TooltipDisplay display, java.util.function.Consumer<Component> list, TooltipFlag flag) {
				super.appendHoverText(itemstack, world, display, list, flag);
				list.accept(Component.literal("Implant Chance 70%"));
			}

			@Override
			public InteractionResult use(Level world, Player entity, InteractionHand hand) {
				InteractionResult ar = super.use(world, entity, hand);
				ItemStack itemstack = entity.getItemInHand(hand);
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();

				WindDNARightClickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}

			@Override
			public void hurtEnemy(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
				super.hurtEnemy(itemstack, entity, sourceentity);
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
				Level world = entity.level();

				WindDNAImplantMobProcedure.executeProcedure(
						Stream.of(new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("sourceentity", sourceentity))
								.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return;
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

			@Override
			public void appendHoverText(ItemStack itemstack, Item.TooltipContext world, net.minecraft.world.item.component.TooltipDisplay display, java.util.function.Consumer<Component> list, TooltipFlag flag) {
				super.appendHoverText(itemstack, world, display, list, flag);
				list.accept(Component.literal("Implant Chance 50%"));
			}

			@Override
			public InteractionResult use(Level world, Player entity, InteractionHand hand) {
				InteractionResult ar = super.use(world, entity, hand);
				ItemStack itemstack = entity.getItemInHand(hand);
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();

				WoodDNARightClickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}

			@Override
			public void hurtEnemy(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
				super.hurtEnemy(itemstack, entity, sourceentity);
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
				Level world = entity.level();

				WoodDNAImplantMobProcedure.executeProcedure(
						Stream.of(new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("sourceentity", sourceentity))
								.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return;
			}
		}
	}
}
