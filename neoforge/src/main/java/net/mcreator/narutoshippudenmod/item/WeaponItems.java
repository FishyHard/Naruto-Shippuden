package net.mcreator.narutoshippudenmod.item;

import net.minecraft.core.registries.Registries;
import net.mcreator.narutoshippudenmod.compat.Registration;
import net.minecraft.server.level.ServerLevel;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import net.mcreator.narutoshippudenmod.NarutoShippudenModElements;
import net.mcreator.narutoshippudenmod.itemgroup.ModItemGroups.WeaponsItemGroup;
import net.mcreator.narutoshippudenmod.procedures.WeaponProcedures.ExplosiveKunaiRightclickedProcedure;
import net.mcreator.narutoshippudenmod.procedures.WeaponProcedures.FumaShurikenRightclickedProcedure;
import net.mcreator.narutoshippudenmod.procedures.WeaponProcedures.KunaiRightclickedProcedure;
import net.mcreator.narutoshippudenmod.procedures.WeaponProcedures.PoisonKunaiRightclickedProcedure;
import net.mcreator.narutoshippudenmod.procedures.WeaponProcedures.ShurikenRightclickedProcedure;
import net.mcreator.narutoshippudenmod.procedures.WeaponProcedures.ToolsDamageProcedure;
import net.mcreator.narutoshippudenmod.procedures.WeaponProcedures.ToroiUniqueFumaShurikenRightclickedProcedure;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;

import net.minecraft.world.item.ItemUseAnimation;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;

import net.mcreator.narutoshippudenmod.procedures.ClanProcedures.OtsutsukiToolsSwitchProcedure;

public final class WeaponItems {
	private WeaponItems() {
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class ChakraBladeItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "chakra_blade", v -> block = (Item) v);
		}

		public ChakraBladeItem(NarutoShippudenModElements instance) {
			super(instance, 1318);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new Item(Registration.itemProps("chakra_blade", "WeaponsItemGroup").sword(new ToolMaterial(net.minecraft.tags.BlockTags.INCORRECT_FOR_WOODEN_TOOL, 10000, 0f, 12f, 30, net.minecraft.tags.ItemTags.WOODEN_TOOL_MATERIALS), 3, -2.4f)) {

				@Override
				public InteractionResult use(Level world, Player entity, InteractionHand hand) {
					InteractionResult retval = super.use(world, entity, hand);
					ItemStack itemstack = entity.getItemInHand(hand);
					double x = entity.getX();
					double y = entity.getY();
					double z = entity.getZ();

					net.mcreator.narutoshippudenmod.core.jutsu.ClanJutsu.unused(
							Stream.of(new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("itemstack", itemstack))
									.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
					return retval;
				}

				@Override
				public void inventoryTick(ItemStack itemstack, ServerLevel world, Entity entity, net.minecraft.world.entity.EquipmentSlot equipmentSlot) {
				int slot = 0;
				boolean selected = equipmentSlot == net.minecraft.world.entity.EquipmentSlot.MAINHAND;
					super.inventoryTick(itemstack, world, entity, equipmentSlot);
					double x = entity.getX();
					double y = entity.getY();
					double z = entity.getZ();
					if (selected)

						net.mcreator.narutoshippudenmod.core.jutsu.ClanJutsu.unused(
								Stream.of(new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("itemstack", itemstack))
										.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				}
			});
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class ExplosiveKunaiItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "explosive_kunai", v -> block = (Item) v);
		}

		public ExplosiveKunaiItem(NarutoShippudenModElements instance) {
			super(instance, 314);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("explosive_kunai", "WeaponsItemGroup").stacksTo(16).rarity(Rarity.COMMON));
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

				ExplosiveKunaiRightclickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
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

				ToolsDamageProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("itemstack", itemstack)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return retval;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class FlyingThunderGodKunaiItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "flying_thunder_god_kunai", v -> block = (Item) v);
		}

		public FlyingThunderGodKunaiItem(NarutoShippudenModElements instance) {
			super(instance, 731);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("flying_thunder_god_kunai", "WeaponsItemGroup").stacksTo(1).rarity(Rarity.COMMON));
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

				net.mcreator.narutoshippudenmod.core.jutsu.ClanJutsu.unused(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z), new AbstractMap.SimpleEntry<>("entity", entity),
								new AbstractMap.SimpleEntry<>("itemstack", itemstack))
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

				net.mcreator.narutoshippudenmod.core.jutsu.ClanJutsu.unused(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z), new AbstractMap.SimpleEntry<>("entity", entity),
								new AbstractMap.SimpleEntry<>("itemstack", itemstack))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return retval;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class FumaShurikenItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "fuma_shuriken", v -> block = (Item) v);
		}

		public FumaShurikenItem(NarutoShippudenModElements instance) {
			super(instance, 976);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("fuma_shuriken", "WeaponsItemGroup").stacksTo(16).rarity(Rarity.COMMON));
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

				FumaShurikenRightclickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
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

				ToolsDamageProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("itemstack", itemstack)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return retval;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class GunbaiBlockItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "gunbai_block", v -> block = (Item) v);
		}

		public GunbaiBlockItem(NarutoShippudenModElements instance) {
			super(instance, 1285);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new Item(Registration.itemProps("gunbai_block", null).sword(new ToolMaterial(net.minecraft.tags.BlockTags.INCORRECT_FOR_WOODEN_TOOL, 10000, 0f, 20f, 30, net.minecraft.tags.ItemTags.WOODEN_TOOL_MATERIALS), 3, -2.7f)) {

				@Override
				public InteractionResult use(Level world, Player entity, InteractionHand hand) {
					InteractionResult retval = super.use(world, entity, hand);
					ItemStack itemstack = entity.getItemInHand(hand);
					double x = entity.getX();
					double y = entity.getY();
					double z = entity.getZ();

					net.mcreator.narutoshippudenmod.core.jutsu.ClanJutsu.unused(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
							.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
					return retval;
				}

				@Override
				public void inventoryTick(ItemStack itemstack, ServerLevel world, Entity entity, net.minecraft.world.entity.EquipmentSlot equipmentSlot) {
				int slot = 0;
				boolean selected = equipmentSlot == net.minecraft.world.entity.EquipmentSlot.MAINHAND;
					super.inventoryTick(itemstack, world, entity, equipmentSlot);
					double x = entity.getX();
					double y = entity.getY();
					double z = entity.getZ();
					if (selected)

						net.mcreator.narutoshippudenmod.core.jutsu.ClanJutsu.unused(
								Stream.of(new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("itemstack", itemstack))
										.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));

					net.mcreator.narutoshippudenmod.core.jutsu.ClanJutsu.unused(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
							(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				}
			});
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class GunbaiItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "gunbai", v -> block = (Item) v);
		}

		public GunbaiItem(NarutoShippudenModElements instance) {
			super(instance, 214);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new Item(Registration.itemProps("gunbai", "WeaponsItemGroup").sword(new ToolMaterial(net.minecraft.tags.BlockTags.INCORRECT_FOR_WOODEN_TOOL, 10000, 0f, 20f, 30, net.minecraft.tags.ItemTags.WOODEN_TOOL_MATERIALS), 3, -2.7f)) {

				@Override
				public InteractionResult use(Level world, Player entity, InteractionHand hand) {
					InteractionResult retval = super.use(world, entity, hand);
					ItemStack itemstack = entity.getItemInHand(hand);
					double x = entity.getX();
					double y = entity.getY();
					double z = entity.getZ();

					net.mcreator.narutoshippudenmod.core.jutsu.ClanJutsu.unused(Stream
							.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("y", y),
									new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("itemstack", itemstack))
							.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
					return retval;
				}

				@Override
				public void inventoryTick(ItemStack itemstack, ServerLevel world, Entity entity, net.minecraft.world.entity.EquipmentSlot equipmentSlot) {
				int slot = 0;
				boolean selected = equipmentSlot == net.minecraft.world.entity.EquipmentSlot.MAINHAND;
					super.inventoryTick(itemstack, world, entity, equipmentSlot);
					double x = entity.getX();
					double y = entity.getY();
					double z = entity.getZ();
					if (selected)

						net.mcreator.narutoshippudenmod.core.jutsu.ClanJutsu.unused(
								Stream.of(new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("itemstack", itemstack))
										.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				}
			});
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class HiramekareiHammerFormItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "hiramekarei_hammer_form", v -> block = (Item) v);
		}

		public HiramekareiHammerFormItem(NarutoShippudenModElements instance) {
			super(instance, 1292);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new Item(Registration.itemProps("hiramekarei_hammer_form", null).sword(new ToolMaterial(net.minecraft.tags.BlockTags.INCORRECT_FOR_WOODEN_TOOL, 10000, 0f, 26f, 30, net.minecraft.tags.ItemTags.WOODEN_TOOL_MATERIALS), 3, -3.7f)) {

				@Override
				public InteractionResult use(Level world, Player entity, InteractionHand hand) {
					InteractionResult retval = super.use(world, entity, hand);
					ItemStack itemstack = entity.getItemInHand(hand);
					double x = entity.getX();
					double y = entity.getY();
					double z = entity.getZ();

					net.mcreator.narutoshippudenmod.core.jutsu.ClanJutsu.unused(Stream
							.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x),
									new AbstractMap.SimpleEntry<>("y", y), new AbstractMap.SimpleEntry<>("z", z),
									new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("itemstack", itemstack))
							.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
					return retval;
				}

				@Override
				public boolean onEntitySwing(ItemStack itemstack, LivingEntity entity, InteractionHand hand) {
					boolean retval = super.onEntitySwing(itemstack, entity, hand);
					double x = entity.getX();
					double y = entity.getY();
					double z = entity.getZ();
					Level world = entity.level();

					net.mcreator.narutoshippudenmod.core.jutsu.ClanJutsu.unused(
							Stream.of(new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("itemstack", itemstack))
									.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
					return retval;
				}

				@Override
				public void inventoryTick(ItemStack itemstack, ServerLevel world, Entity entity, net.minecraft.world.entity.EquipmentSlot equipmentSlot) {
				int slot = 0;
				boolean selected = equipmentSlot == net.minecraft.world.entity.EquipmentSlot.MAINHAND;
					super.inventoryTick(itemstack, world, entity, equipmentSlot);
					double x = entity.getX();
					double y = entity.getY();
					double z = entity.getZ();
					if (selected)

						net.mcreator.narutoshippudenmod.core.jutsu.ClanJutsu.unused(
								Stream.of(new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("itemstack", itemstack))
										.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				}
			});
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class HiramekareiItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "hiramekarei", v -> block = (Item) v);
		}

		public HiramekareiItem(NarutoShippudenModElements instance) {
			super(instance, 215);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new Item(Registration.itemProps("hiramekarei", "WeaponsItemGroup").sword(new ToolMaterial(net.minecraft.tags.BlockTags.INCORRECT_FOR_WOODEN_TOOL, 10000, 0f, 18f, 30, net.minecraft.tags.ItemTags.WOODEN_TOOL_MATERIALS), 3, -3.2f)) {

				@Override
				public InteractionResult use(Level world, Player entity, InteractionHand hand) {
					InteractionResult retval = super.use(world, entity, hand);
					ItemStack itemstack = entity.getItemInHand(hand);
					double x = entity.getX();
					double y = entity.getY();
					double z = entity.getZ();

					net.mcreator.narutoshippudenmod.core.jutsu.ClanJutsu.unused(Stream
							.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x),
									new AbstractMap.SimpleEntry<>("y", y), new AbstractMap.SimpleEntry<>("z", z),
									new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("itemstack", itemstack))
							.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
					return retval;
				}

				@Override
				public boolean onEntitySwing(ItemStack itemstack, LivingEntity entity, InteractionHand hand) {
					boolean retval = super.onEntitySwing(itemstack, entity, hand);
					double x = entity.getX();
					double y = entity.getY();
					double z = entity.getZ();
					Level world = entity.level();

					net.mcreator.narutoshippudenmod.core.jutsu.ClanJutsu.unused(
							Stream.of(new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("itemstack", itemstack))
									.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
					return retval;
				}

				@Override
				public void inventoryTick(ItemStack itemstack, ServerLevel world, Entity entity, net.minecraft.world.entity.EquipmentSlot equipmentSlot) {
				int slot = 0;
				boolean selected = equipmentSlot == net.minecraft.world.entity.EquipmentSlot.MAINHAND;
					super.inventoryTick(itemstack, world, entity, equipmentSlot);
					double x = entity.getX();
					double y = entity.getY();
					double z = entity.getZ();
					if (selected)

						net.mcreator.narutoshippudenmod.core.jutsu.ClanJutsu.unused(
								Stream.of(new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("itemstack", itemstack))
										.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				}
			});
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class HiramekareiSplittedItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "hiramekarei_splitted", v -> block = (Item) v);
		}

		public HiramekareiSplittedItem(NarutoShippudenModElements instance) {
			super(instance, 216);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new Item(Registration.itemProps("hiramekarei_splitted", null).sword(new ToolMaterial(net.minecraft.tags.BlockTags.INCORRECT_FOR_WOODEN_TOOL, 10000, 0f, 14f, 30, net.minecraft.tags.ItemTags.WOODEN_TOOL_MATERIALS), 3, -2.6f)) {

				@Override
				public InteractionResult use(Level world, Player entity, InteractionHand hand) {
					InteractionResult retval = super.use(world, entity, hand);
					ItemStack itemstack = entity.getItemInHand(hand);
					double x = entity.getX();
					double y = entity.getY();
					double z = entity.getZ();

					net.mcreator.narutoshippudenmod.core.jutsu.ClanJutsu.unused(Stream
							.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x),
									new AbstractMap.SimpleEntry<>("y", y), new AbstractMap.SimpleEntry<>("z", z),
									new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("itemstack", itemstack))
							.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
					return retval;
				}

				@Override
				public boolean onEntitySwing(ItemStack itemstack, LivingEntity entity, InteractionHand hand) {
					boolean retval = super.onEntitySwing(itemstack, entity, hand);
					double x = entity.getX();
					double y = entity.getY();
					double z = entity.getZ();
					Level world = entity.level();

					net.mcreator.narutoshippudenmod.core.jutsu.ClanJutsu.unused(
							Stream.of(new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("itemstack", itemstack))
									.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
					return retval;
				}

				@Override
				public void inventoryTick(ItemStack itemstack, ServerLevel world, Entity entity, net.minecraft.world.entity.EquipmentSlot equipmentSlot) {
				int slot = 0;
				boolean selected = equipmentSlot == net.minecraft.world.entity.EquipmentSlot.MAINHAND;
					super.inventoryTick(itemstack, world, entity, equipmentSlot);
					double x = entity.getX();
					double y = entity.getY();
					double z = entity.getZ();
					if (selected)

						net.mcreator.narutoshippudenmod.core.jutsu.ClanJutsu.unused(
								Stream.of(new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("itemstack", itemstack))
										.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				}
			});
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class KabutowariItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "kabutowari", v -> block = (Item) v);
		}

		public KabutowariItem(NarutoShippudenModElements instance) {
			super(instance, 212);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new Item(Registration.itemProps("kabutowari", "WeaponsItemGroup").sword(new ToolMaterial(net.minecraft.tags.BlockTags.INCORRECT_FOR_WOODEN_TOOL, 10000, 0f, 18f, 30, net.minecraft.tags.ItemTags.WOODEN_TOOL_MATERIALS), 3, -3f)) {

				@Override
				public InteractionResult use(Level world, Player entity, InteractionHand hand) {
					InteractionResult retval = super.use(world, entity, hand);
					ItemStack itemstack = entity.getItemInHand(hand);
					double x = entity.getX();
					double y = entity.getY();
					double z = entity.getZ();

					net.mcreator.narutoshippudenmod.core.jutsu.ClanJutsu.unused(Stream
							.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x),
									new AbstractMap.SimpleEntry<>("y", y), new AbstractMap.SimpleEntry<>("z", z),
									new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("itemstack", itemstack))
							.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
					return retval;
				}

				@Override
				public void inventoryTick(ItemStack itemstack, ServerLevel world, Entity entity, net.minecraft.world.entity.EquipmentSlot equipmentSlot) {
				int slot = 0;
				boolean selected = equipmentSlot == net.minecraft.world.entity.EquipmentSlot.MAINHAND;
					super.inventoryTick(itemstack, world, entity, equipmentSlot);
					double x = entity.getX();
					double y = entity.getY();
					double z = entity.getZ();
					if (selected)

						net.mcreator.narutoshippudenmod.core.jutsu.ClanJutsu.unused(
								Stream.of(new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("itemstack", itemstack))
										.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				}
			});
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class KatanaItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "katana", v -> block = (Item) v);
		}

		public KatanaItem(NarutoShippudenModElements instance) {
			super(instance, 210);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new Item(Registration.itemProps("katana", "WeaponsItemGroup").sword(new ToolMaterial(net.minecraft.tags.BlockTags.INCORRECT_FOR_WOODEN_TOOL, 10000, 0f, 10f, 30, net.minecraft.tags.ItemTags.WOODEN_TOOL_MATERIALS), 3, -2.5f)) {

				@Override
				public void inventoryTick(ItemStack itemstack, ServerLevel world, Entity entity, net.minecraft.world.entity.EquipmentSlot equipmentSlot) {
				int slot = 0;
				boolean selected = equipmentSlot == net.minecraft.world.entity.EquipmentSlot.MAINHAND;
					super.inventoryTick(itemstack, world, entity, equipmentSlot);
					double x = entity.getX();
					double y = entity.getY();
					double z = entity.getZ();
					if (selected)

						net.mcreator.narutoshippudenmod.core.jutsu.ClanJutsu.unused(
								Stream.of(new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("itemstack", itemstack))
										.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				}
			});
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class KatanaJonin1Item extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "katana_jonin_1", v -> block = (Item) v);
		}

		public KatanaJonin1Item(NarutoShippudenModElements instance) {
			super(instance, 681);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new Item(Registration.itemProps("katana_jonin_1", null).sword(new ToolMaterial(net.minecraft.tags.BlockTags.INCORRECT_FOR_WOODEN_TOOL, 10000, 0f, 12f, 30, net.minecraft.tags.ItemTags.WOODEN_TOOL_MATERIALS), 3, -2.5f)) {
			});
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class KibaSwordItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "kiba_sword", v -> block = (Item) v);
		}

		public KibaSwordItem(NarutoShippudenModElements instance) {
			super(instance, 209);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new Item(Registration.itemProps("kiba_sword", "WeaponsItemGroup").sword(new ToolMaterial(net.minecraft.tags.BlockTags.INCORRECT_FOR_WOODEN_TOOL, 10000, 0f, 12f, 30, net.minecraft.tags.ItemTags.WOODEN_TOOL_MATERIALS), 3, -2.5f)) {

				@Override
				public InteractionResult use(Level world, Player entity, InteractionHand hand) {
					InteractionResult retval = super.use(world, entity, hand);
					ItemStack itemstack = entity.getItemInHand(hand);
					double x = entity.getX();
					double y = entity.getY();
					double z = entity.getZ();

					net.mcreator.narutoshippudenmod.core.jutsu.ClanJutsu.unused(Stream
							.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x),
									new AbstractMap.SimpleEntry<>("y", y), new AbstractMap.SimpleEntry<>("z", z),
									new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("itemstack", itemstack))
							.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
					return retval;
				}

				@Override
				public void inventoryTick(ItemStack itemstack, ServerLevel world, Entity entity, net.minecraft.world.entity.EquipmentSlot equipmentSlot) {
				int slot = 0;
				boolean selected = equipmentSlot == net.minecraft.world.entity.EquipmentSlot.MAINHAND;
					super.inventoryTick(itemstack, world, entity, equipmentSlot);
					double x = entity.getX();
					double y = entity.getY();
					double z = entity.getZ();
					if (selected)

						net.mcreator.narutoshippudenmod.core.jutsu.ClanJutsu.unused(
								Stream.of(new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("itemstack", itemstack))
										.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				}
			});
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class KubikiribochoItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "kubikiribocho", v -> block = (Item) v);
		}

		public KubikiribochoItem(NarutoShippudenModElements instance) {
			super(instance, 203);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new Item(Registration.itemProps("kubikiribocho", "WeaponsItemGroup").sword(new ToolMaterial(net.minecraft.tags.BlockTags.INCORRECT_FOR_WOODEN_TOOL, 3000, 0f, 16f, 30, net.minecraft.tags.ItemTags.WOODEN_TOOL_MATERIALS), 3, -3.3f)) {

				@Override
				public void inventoryTick(ItemStack itemstack, ServerLevel world, Entity entity, net.minecraft.world.entity.EquipmentSlot equipmentSlot) {
				int slot = 0;
				boolean selected = equipmentSlot == net.minecraft.world.entity.EquipmentSlot.MAINHAND;
					super.inventoryTick(itemstack, world, entity, equipmentSlot);
					double x = entity.getX();
					double y = entity.getY();
					double z = entity.getZ();
					if (selected)

						net.mcreator.narutoshippudenmod.core.jutsu.ClanJutsu.unused(
								Stream.of(new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("itemstack", itemstack))
										.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				}
			});
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class KunaiItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "kunai", v -> block = (Item) v);
		}

		public KunaiItem(NarutoShippudenModElements instance) {
			super(instance, 313);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("kunai", "WeaponsItemGroup").stacksTo(16).rarity(Rarity.COMMON));
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

				KunaiRightclickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
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

				ToolsDamageProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("itemstack", itemstack)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return retval;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class KusanagiSasukeItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "kusanagi_sasuke", v -> block = (Item) v);
		}

		public KusanagiSasukeItem(NarutoShippudenModElements instance) {
			super(instance, 204);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new Item(Registration.itemProps("kusanagi_sasuke", "WeaponsItemGroup").sword(new ToolMaterial(net.minecraft.tags.BlockTags.INCORRECT_FOR_WOODEN_TOOL, 10000, 0f, 12f, 30, net.minecraft.tags.ItemTags.WOODEN_TOOL_MATERIALS), 3, -2.5f)) {

				@Override
				public InteractionResult use(Level world, Player entity, InteractionHand hand) {
					InteractionResult retval = super.use(world, entity, hand);
					ItemStack itemstack = entity.getItemInHand(hand);
					double x = entity.getX();
					double y = entity.getY();
					double z = entity.getZ();

					net.mcreator.narutoshippudenmod.core.jutsu.ClanJutsu.unused(
							Stream.of(new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("itemstack", itemstack))
									.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
					return retval;
				}

				@Override
				public void hurtEnemy(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
					super.hurtEnemy(itemstack, entity, sourceentity);
					double x = entity.getX();
					double y = entity.getY();
					double z = entity.getZ();
					Level world = entity.level();

					net.mcreator.narutoshippudenmod.core.jutsu.ClanJutsu.unused(
							Stream.of(new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("itemstack", itemstack))
									.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
					return;
				}

				@Override
				public void inventoryTick(ItemStack itemstack, ServerLevel world, Entity entity, net.minecraft.world.entity.EquipmentSlot equipmentSlot) {
				int slot = 0;
				boolean selected = equipmentSlot == net.minecraft.world.entity.EquipmentSlot.MAINHAND;
					super.inventoryTick(itemstack, world, entity, equipmentSlot);
					double x = entity.getX();
					double y = entity.getY();
					double z = entity.getZ();
					if (selected)

						net.mcreator.narutoshippudenmod.core.jutsu.ClanJutsu.unused(
								Stream.of(new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("itemstack", itemstack))
										.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				}
			});
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class NuibariItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "nuibari", v -> block = (Item) v);
		}

		public NuibariItem(NarutoShippudenModElements instance) {
			super(instance, 208);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new Item(Registration.itemProps("nuibari", "WeaponsItemGroup").sword(new ToolMaterial(net.minecraft.tags.BlockTags.INCORRECT_FOR_WOODEN_TOOL, 10000, 0f, 12f, 30, net.minecraft.tags.ItemTags.WOODEN_TOOL_MATERIALS), 3, -3.3f)) {

				@Override
				public InteractionResult use(Level world, Player entity, InteractionHand hand) {
					InteractionResult retval = super.use(world, entity, hand);
					ItemStack itemstack = entity.getItemInHand(hand);
					double x = entity.getX();
					double y = entity.getY();
					double z = entity.getZ();

					net.mcreator.narutoshippudenmod.core.jutsu.ClanJutsu.unused(Stream
							.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("entity", entity),
									new AbstractMap.SimpleEntry<>("itemstack", itemstack))
							.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
					return retval;
				}

				@Override
				public void inventoryTick(ItemStack itemstack, ServerLevel world, Entity entity, net.minecraft.world.entity.EquipmentSlot equipmentSlot) {
				int slot = 0;
				boolean selected = equipmentSlot == net.minecraft.world.entity.EquipmentSlot.MAINHAND;
					super.inventoryTick(itemstack, world, entity, equipmentSlot);
					double x = entity.getX();
					double y = entity.getY();
					double z = entity.getZ();
					if (selected)

						net.mcreator.narutoshippudenmod.core.jutsu.ClanJutsu.unused(
								Stream.of(new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("itemstack", itemstack))
										.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				}
			});
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class PoisonKunaiItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "poison_kunai", v -> block = (Item) v);
		}

		public PoisonKunaiItem(NarutoShippudenModElements instance) {
			super(instance, 1324);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("poison_kunai", "WeaponsItemGroup").stacksTo(16).rarity(Rarity.COMMON));
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

				PoisonKunaiRightclickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
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

				ToolsDamageProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("itemstack", itemstack)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return retval;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class SamehadaItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "samehada", v -> block = (Item) v);
		}

		public SamehadaItem(NarutoShippudenModElements instance) {
			super(instance, 207);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new Item(Registration.itemProps("samehada", "WeaponsItemGroup").sword(new ToolMaterial(net.minecraft.tags.BlockTags.INCORRECT_FOR_WOODEN_TOOL, 10000, 0f, 18f, 30, net.minecraft.tags.ItemTags.WOODEN_TOOL_MATERIALS), 3, -2.8f)) {

				@Override
				public InteractionResult use(Level world, Player entity, InteractionHand hand) {
					InteractionResult retval = super.use(world, entity, hand);
					ItemStack itemstack = entity.getItemInHand(hand);
					double x = entity.getX();
					double y = entity.getY();
					double z = entity.getZ();

					net.mcreator.narutoshippudenmod.core.jutsu.ClanJutsu.unused(
							Stream.of(new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("itemstack", itemstack))
									.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
					return retval;
				}

				@Override
				public void hurtEnemy(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
					super.hurtEnemy(itemstack, entity, sourceentity);
					double x = entity.getX();
					double y = entity.getY();
					double z = entity.getZ();
					Level world = entity.level();

					net.mcreator.narutoshippudenmod.core.jutsu.ClanJutsu.unused(Stream
							.of(new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("sourceentity", sourceentity),
									new AbstractMap.SimpleEntry<>("itemstack", itemstack))
							.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
					return;
				}

				@Override
				public void inventoryTick(ItemStack itemstack, ServerLevel world, Entity entity, net.minecraft.world.entity.EquipmentSlot equipmentSlot) {
				int slot = 0;
				boolean selected = equipmentSlot == net.minecraft.world.entity.EquipmentSlot.MAINHAND;
					super.inventoryTick(itemstack, world, entity, equipmentSlot);
					double x = entity.getX();
					double y = entity.getY();
					double z = entity.getZ();
					if (selected)

						net.mcreator.narutoshippudenmod.core.jutsu.ClanJutsu.unused(
								Stream.of(new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("itemstack", itemstack))
										.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				}
			});
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class ShibukiItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "shibuki", v -> block = (Item) v);
		}

		public ShibukiItem(NarutoShippudenModElements instance) {
			super(instance, 213);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new Item(Registration.itemProps("shibuki", "WeaponsItemGroup").sword(new ToolMaterial(net.minecraft.tags.BlockTags.INCORRECT_FOR_WOODEN_TOOL, 10000, 0f, 16f, 30, net.minecraft.tags.ItemTags.WOODEN_TOOL_MATERIALS), 3, -3.2f)) {

				@Override
				public InteractionResult use(Level world, Player entity, InteractionHand hand) {
					InteractionResult retval = super.use(world, entity, hand);
					ItemStack itemstack = entity.getItemInHand(hand);
					double x = entity.getX();
					double y = entity.getY();
					double z = entity.getZ();

					net.mcreator.narutoshippudenmod.core.jutsu.ClanJutsu.unused(Stream
							.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("y", y),
									new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("itemstack", itemstack))
							.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
					return retval;
				}

				@Override
				public void hurtEnemy(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
					super.hurtEnemy(itemstack, entity, sourceentity);
					double x = entity.getX();
					double y = entity.getY();
					double z = entity.getZ();
					Level world = entity.level();

					net.mcreator.narutoshippudenmod.core.jutsu.ClanJutsu.unused(Stream
							.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("entity", entity),
									new AbstractMap.SimpleEntry<>("sourceentity", sourceentity), new AbstractMap.SimpleEntry<>("itemstack", itemstack))
							.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
					return;
				}

				@Override
				public void inventoryTick(ItemStack itemstack, ServerLevel world, Entity entity, net.minecraft.world.entity.EquipmentSlot equipmentSlot) {
				int slot = 0;
				boolean selected = equipmentSlot == net.minecraft.world.entity.EquipmentSlot.MAINHAND;
					super.inventoryTick(itemstack, world, entity, equipmentSlot);
					double x = entity.getX();
					double y = entity.getY();
					double z = entity.getZ();
					if (selected)

						net.mcreator.narutoshippudenmod.core.jutsu.ClanJutsu.unused(
								Stream.of(new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("itemstack", itemstack))
										.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));

					net.mcreator.narutoshippudenmod.core.jutsu.ClanJutsu.unused(Stream
							.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("entity", entity),
									new AbstractMap.SimpleEntry<>("itemstack", itemstack))
							.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				}
			});
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class ShichiseikenItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "shichiseiken", v -> block = (Item) v);
		}

		public ShichiseikenItem(NarutoShippudenModElements instance) {
			super(instance, 1278);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new Item(Registration.itemProps("shichiseiken", "WeaponsItemGroup").sword(new ToolMaterial(net.minecraft.tags.BlockTags.INCORRECT_FOR_WOODEN_TOOL, 10000, 0f, 17f, 30, net.minecraft.tags.ItemTags.WOODEN_TOOL_MATERIALS), 3, -3f)) {

				@Override
				public void inventoryTick(ItemStack itemstack, ServerLevel world, Entity entity, net.minecraft.world.entity.EquipmentSlot equipmentSlot) {
				int slot = 0;
				boolean selected = equipmentSlot == net.minecraft.world.entity.EquipmentSlot.MAINHAND;
					super.inventoryTick(itemstack, world, entity, equipmentSlot);
					double x = entity.getX();
					double y = entity.getY();
					double z = entity.getZ();
					if (selected)

						net.mcreator.narutoshippudenmod.core.jutsu.ClanJutsu.unused(
								Stream.of(new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("itemstack", itemstack))
										.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				}
			});
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class ShurikenItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "shuriken", v -> block = (Item) v);
		}

		public ShurikenItem(NarutoShippudenModElements instance) {
			super(instance, 315);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("shuriken", "WeaponsItemGroup").stacksTo(16).rarity(Rarity.COMMON));
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

				ShurikenRightclickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
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

				ToolsDamageProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("itemstack", itemstack)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return retval;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class TantoItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "tanto", v -> block = (Item) v);
		}

		public TantoItem(NarutoShippudenModElements instance) {
			super(instance, 205);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new Item(Registration.itemProps("tanto", "WeaponsItemGroup").sword(new ToolMaterial(net.minecraft.tags.BlockTags.INCORRECT_FOR_WOODEN_TOOL, 10000, 0f, 5f, 30, net.minecraft.tags.ItemTags.WOODEN_TOOL_MATERIALS), 3, -2.7f)) {

				@Override
				public void inventoryTick(ItemStack itemstack, ServerLevel world, Entity entity, net.minecraft.world.entity.EquipmentSlot equipmentSlot) {
				int slot = 0;
				boolean selected = equipmentSlot == net.minecraft.world.entity.EquipmentSlot.MAINHAND;
					super.inventoryTick(itemstack, world, entity, equipmentSlot);
					double x = entity.getX();
					double y = entity.getY();
					double z = entity.getZ();
					if (selected)

						net.mcreator.narutoshippudenmod.core.jutsu.ClanJutsu.unused(
								Stream.of(new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("itemstack", itemstack))
										.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				}
			});
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class ToroiUniqueFumaShurikenItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "toroi_unique_fuma_shuriken", v -> block = (Item) v);
		}

		public ToroiUniqueFumaShurikenItem(NarutoShippudenModElements instance) {
			super(instance, 974);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("toroi_unique_fuma_shuriken", "WeaponsItemGroup").stacksTo(16).rarity(Rarity.COMMON));
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

				ToroiUniqueFumaShurikenRightclickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
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

				ToolsDamageProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("itemstack", itemstack)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return retval;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class TripleBladeScytheItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "triple_blade_scythe", v -> block = (Item) v);
		}

		public TripleBladeScytheItem(NarutoShippudenModElements instance) {
			super(instance, 1316);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new Item(Registration.itemProps("triple_blade_scythe", "WeaponsItemGroup").sword(new ToolMaterial(net.minecraft.tags.BlockTags.INCORRECT_FOR_WOODEN_TOOL, 10000, 0f, 13f, 30, net.minecraft.tags.ItemTags.WOODEN_TOOL_MATERIALS), 3, -3f)) {

				@Override
				public void inventoryTick(ItemStack itemstack, ServerLevel world, Entity entity, net.minecraft.world.entity.EquipmentSlot equipmentSlot) {
				int slot = 0;
				boolean selected = equipmentSlot == net.minecraft.world.entity.EquipmentSlot.MAINHAND;
					super.inventoryTick(itemstack, world, entity, equipmentSlot);
					double x = entity.getX();
					double y = entity.getY();
					double z = entity.getZ();
					if (selected)

						net.mcreator.narutoshippudenmod.core.jutsu.ClanJutsu.unused(
								Stream.of(new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("itemstack", itemstack))
										.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				}
			});
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class WhiteLightChakraSabreItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "white_light_chakra_sabre", v -> block = (Item) v);
		}

		public WhiteLightChakraSabreItem(NarutoShippudenModElements instance) {
			super(instance, 1301);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new Item(Registration.itemProps("white_light_chakra_sabre", "WeaponsItemGroup").sword(new ToolMaterial(net.minecraft.tags.BlockTags.INCORRECT_FOR_WOODEN_TOOL, 10000, 0f, 6f, 30, net.minecraft.tags.ItemTags.WOODEN_TOOL_MATERIALS), 3, -2.6f)) {

				@Override
				public InteractionResult use(Level world, Player entity, InteractionHand hand) {
					InteractionResult retval = super.use(world, entity, hand);
					ItemStack itemstack = entity.getItemInHand(hand);
					double x = entity.getX();
					double y = entity.getY();
					double z = entity.getZ();

					net.mcreator.narutoshippudenmod.core.jutsu.ClanJutsu.unused(
							Stream.of(new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("itemstack", itemstack))
									.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
					return retval;
				}

				@Override
				public void inventoryTick(ItemStack itemstack, ServerLevel world, Entity entity, net.minecraft.world.entity.EquipmentSlot equipmentSlot) {
				int slot = 0;
				boolean selected = equipmentSlot == net.minecraft.world.entity.EquipmentSlot.MAINHAND;
					super.inventoryTick(itemstack, world, entity, equipmentSlot);
					double x = entity.getX();
					double y = entity.getY();
					double z = entity.getZ();
					if (selected)

						net.mcreator.narutoshippudenmod.core.jutsu.ClanJutsu.unused(
								Stream.of(new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("itemstack", itemstack))
										.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				}
			});
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class OtsutsukiAxeItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "otsutsuki_axe", v -> block = (Item) v);
		}

		public OtsutsukiAxeItem(NarutoShippudenModElements instance) {
			super(instance, 753);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new Item(Registration.itemProps("otsutsuki_axe", null).sword(new ToolMaterial(net.minecraft.tags.BlockTags.INCORRECT_FOR_WOODEN_TOOL, 0, 0f, 20f, 1, net.minecraft.tags.ItemTags.WOODEN_TOOL_MATERIALS), 3, -3.3f)) {

				@Override
				public InteractionResult use(Level world, Player entity, InteractionHand hand) {
					InteractionResult retval = super.use(world, entity, hand);
					ItemStack itemstack = entity.getItemInHand(hand);
					double x = entity.getX();
					double y = entity.getY();
					double z = entity.getZ();

					OtsutsukiToolsSwitchProcedure.executeProcedure(
							Stream.of(new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("itemstack", itemstack))
									.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
					return retval;
				}
			});
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class OtsutsukiBatItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "otsutsuki_bat", v -> block = (Item) v);
		}

		public OtsutsukiBatItem(NarutoShippudenModElements instance) {
			super(instance, 754);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new Item(Registration.itemProps("otsutsuki_bat", null).sword(new ToolMaterial(net.minecraft.tags.BlockTags.INCORRECT_FOR_WOODEN_TOOL, 0, 0f, 14f, 1, net.minecraft.tags.ItemTags.WOODEN_TOOL_MATERIALS), 3, -2.9f)) {

				@Override
				public InteractionResult use(Level world, Player entity, InteractionHand hand) {
					InteractionResult retval = super.use(world, entity, hand);
					ItemStack itemstack = entity.getItemInHand(hand);
					double x = entity.getX();
					double y = entity.getY();
					double z = entity.getZ();

					OtsutsukiToolsSwitchProcedure.executeProcedure(
							Stream.of(new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("itemstack", itemstack))
									.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
					return retval;
				}
			});
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class OtsutsukiBladeItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "otsutsuki_blade", v -> block = (Item) v);
		}

		public OtsutsukiBladeItem(NarutoShippudenModElements instance) {
			super(instance, 755);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new Item(Registration.itemProps("otsutsuki_blade", null).sword(new ToolMaterial(net.minecraft.tags.BlockTags.INCORRECT_FOR_WOODEN_TOOL, 0, 0f, 10f, 1, net.minecraft.tags.ItemTags.WOODEN_TOOL_MATERIALS), 3, -2.2f)) {

				@Override
				public InteractionResult use(Level world, Player entity, InteractionHand hand) {
					InteractionResult retval = super.use(world, entity, hand);
					ItemStack itemstack = entity.getItemInHand(hand);
					double x = entity.getX();
					double y = entity.getY();
					double z = entity.getZ();

					OtsutsukiToolsSwitchProcedure.executeProcedure(
							Stream.of(new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("itemstack", itemstack))
									.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
					return retval;
				}
			});
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class OtsutsukiChoppingSwordItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "otsutsuki_chopping_sword", v -> block = (Item) v);
		}

		public OtsutsukiChoppingSwordItem(NarutoShippudenModElements instance) {
			super(instance, 756);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new Item(Registration.itemProps("otsutsuki_chopping_sword", null).sword(new ToolMaterial(net.minecraft.tags.BlockTags.INCORRECT_FOR_WOODEN_TOOL, 0, 0f, 18f, 1, net.minecraft.tags.ItemTags.WOODEN_TOOL_MATERIALS), 3, -3.1f)) {

				@Override
				public InteractionResult use(Level world, Player entity, InteractionHand hand) {
					InteractionResult retval = super.use(world, entity, hand);
					ItemStack itemstack = entity.getItemInHand(hand);
					double x = entity.getX();
					double y = entity.getY();
					double z = entity.getZ();

					OtsutsukiToolsSwitchProcedure.executeProcedure(
							Stream.of(new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("itemstack", itemstack))
									.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
					return retval;
				}
			});
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class OtsutsukiHammerItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "otsutsuki_hammer", v -> block = (Item) v);
		}

		public OtsutsukiHammerItem(NarutoShippudenModElements instance) {
			super(instance, 757);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new Item(Registration.itemProps("otsutsuki_hammer", null).sword(new ToolMaterial(net.minecraft.tags.BlockTags.INCORRECT_FOR_WOODEN_TOOL, 0, 0f, 22f, 1, net.minecraft.tags.ItemTags.WOODEN_TOOL_MATERIALS), 3, -3.5f)) {

				@Override
				public InteractionResult use(Level world, Player entity, InteractionHand hand) {
					InteractionResult retval = super.use(world, entity, hand);
					ItemStack itemstack = entity.getItemInHand(hand);
					double x = entity.getX();
					double y = entity.getY();
					double z = entity.getZ();

					OtsutsukiToolsSwitchProcedure.executeProcedure(
							Stream.of(new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("itemstack", itemstack))
									.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
					return retval;
				}
			});
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class OtsutsukiKatanaItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "otsutsuki_katana", v -> block = (Item) v);
		}

		public OtsutsukiKatanaItem(NarutoShippudenModElements instance) {
			super(instance, 758);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new Item(Registration.itemProps("otsutsuki_katana", null).sword(new ToolMaterial(net.minecraft.tags.BlockTags.INCORRECT_FOR_WOODEN_TOOL, 0, 0f, 13f, 1, net.minecraft.tags.ItemTags.WOODEN_TOOL_MATERIALS), 3, -3f)) {

				@Override
				public InteractionResult use(Level world, Player entity, InteractionHand hand) {
					InteractionResult retval = super.use(world, entity, hand);
					ItemStack itemstack = entity.getItemInHand(hand);
					double x = entity.getX();
					double y = entity.getY();
					double z = entity.getZ();

					OtsutsukiToolsSwitchProcedure.executeProcedure(
							Stream.of(new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("itemstack", itemstack))
									.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
					return retval;
				}
			});
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class OtsutsukiSpearItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "otsutsuki_spear", v -> block = (Item) v);
		}

		public OtsutsukiSpearItem(NarutoShippudenModElements instance) {
			super(instance, 759);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new Item(Registration.itemProps("otsutsuki_spear", null).sword(new ToolMaterial(net.minecraft.tags.BlockTags.INCORRECT_FOR_WOODEN_TOOL, 0, 0f, 15f, 1, net.minecraft.tags.ItemTags.WOODEN_TOOL_MATERIALS), 3, -2.6f)) {

				@Override
				public InteractionResult use(Level world, Player entity, InteractionHand hand) {
					InteractionResult retval = super.use(world, entity, hand);
					ItemStack itemstack = entity.getItemInHand(hand);
					double x = entity.getX();
					double y = entity.getY();
					double z = entity.getZ();

					OtsutsukiToolsSwitchProcedure.executeProcedure(
							Stream.of(new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("itemstack", itemstack))
									.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
					return retval;
				}
			});
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class OtsutsukiSwordItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "otsutsuki_sword", v -> block = (Item) v);
		}

		public OtsutsukiSwordItem(NarutoShippudenModElements instance) {
			super(instance, 760);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new Item(Registration.itemProps("otsutsuki_sword", null).sword(new ToolMaterial(net.minecraft.tags.BlockTags.INCORRECT_FOR_WOODEN_TOOL, 0, 0f, 18f, 1, net.minecraft.tags.ItemTags.WOODEN_TOOL_MATERIALS), 3, -2.8f)) {

				@Override
				public InteractionResult use(Level world, Player entity, InteractionHand hand) {
					InteractionResult retval = super.use(world, entity, hand);
					ItemStack itemstack = entity.getItemInHand(hand);
					double x = entity.getX();
					double y = entity.getY();
					double z = entity.getZ();

					OtsutsukiToolsSwitchProcedure.executeProcedure(
							Stream.of(new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("itemstack", itemstack))
									.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
					return retval;
				}
			});
		}
	}
}
