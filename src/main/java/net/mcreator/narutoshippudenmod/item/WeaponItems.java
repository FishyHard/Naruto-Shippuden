package net.mcreator.narutoshippudenmod.item;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import net.mcreator.narutoshippudenmod.NarutoShippudenModElements;
import net.mcreator.narutoshippudenmod.itemgroup.ModItemGroups.WeaponsItemGroup;
import net.mcreator.narutoshippudenmod.procedures.ClanProcedures.OtsutsukiToolsSwitchProcedure;
import net.mcreator.narutoshippudenmod.procedures.WeaponProcedures.AsumaChakraBladeToolInHandTickProcedure;
import net.mcreator.narutoshippudenmod.procedures.WeaponProcedures.ChakraBladeRightclickedProcedure;
import net.mcreator.narutoshippudenmod.procedures.WeaponProcedures.ExplosiveKunaiRightclickedProcedure;
import net.mcreator.narutoshippudenmod.procedures.WeaponProcedures.FlyingThunderGodKunaiEntitySwingsItemProcedure;
import net.mcreator.narutoshippudenmod.procedures.WeaponProcedures.FlyingThunderGodKunaiRightclickedProcedure;
import net.mcreator.narutoshippudenmod.procedures.WeaponProcedures.FumaShurikenRightclickedProcedure;
import net.mcreator.narutoshippudenmod.procedures.WeaponProcedures.GunbaiBlockToolInHandTickProcedure;
import net.mcreator.narutoshippudenmod.procedures.WeaponProcedures.GunbaiRightclickedProcedure;
import net.mcreator.narutoshippudenmod.procedures.WeaponProcedures.GunbaiSItemInInventoryTickProcedure;
import net.mcreator.narutoshippudenmod.procedures.WeaponProcedures.GunbaiShieldOnPlayerStoppedUsingProcedure;
import net.mcreator.narutoshippudenmod.procedures.WeaponProcedures.GunbaiToolInHandTickProcedure;
import net.mcreator.narutoshippudenmod.procedures.WeaponProcedures.HidanTripleBladeScytheToolInHandTickProcedure;
import net.mcreator.narutoshippudenmod.procedures.WeaponProcedures.HiramekareiEntitySwingsItemProcedure;
import net.mcreator.narutoshippudenmod.procedures.WeaponProcedures.HiramekareiRightclickedProcedure;
import net.mcreator.narutoshippudenmod.procedures.WeaponProcedures.HiramekareiToolInHandTickProcedure;
import net.mcreator.narutoshippudenmod.procedures.WeaponProcedures.KabutowariRightclickedProcedure;
import net.mcreator.narutoshippudenmod.procedures.WeaponProcedures.KabutowariToolInHandTickProcedure;
import net.mcreator.narutoshippudenmod.procedures.WeaponProcedures.KatanaToolInHandTickProcedure;
import net.mcreator.narutoshippudenmod.procedures.WeaponProcedures.KibaSwordRightclickedProcedure;
import net.mcreator.narutoshippudenmod.procedures.WeaponProcedures.KibaSwordToolInHandTickProcedure;
import net.mcreator.narutoshippudenmod.procedures.WeaponProcedures.KubikiribochoToolInHandTickProcedure;
import net.mcreator.narutoshippudenmod.procedures.WeaponProcedures.KunaiRightclickedProcedure;
import net.mcreator.narutoshippudenmod.procedures.WeaponProcedures.KusanagiSasukeLivingEntityIsHitWithToolProcedure;
import net.mcreator.narutoshippudenmod.procedures.WeaponProcedures.KusanagiSasukeRightclickedProcedure;
import net.mcreator.narutoshippudenmod.procedures.WeaponProcedures.KusanagiSasukeToolInHandTickProcedure;
import net.mcreator.narutoshippudenmod.procedures.WeaponProcedures.NuibariRightclickedProcedure;
import net.mcreator.narutoshippudenmod.procedures.WeaponProcedures.NuibariToolInHandTickProcedure;
import net.mcreator.narutoshippudenmod.procedures.WeaponProcedures.PoisonKunaiRightclickedProcedure;
import net.mcreator.narutoshippudenmod.procedures.WeaponProcedures.SamehadaLivingEntityIsHitWithToolProcedure;
import net.mcreator.narutoshippudenmod.procedures.WeaponProcedures.SamehadaRightclickedProcedure;
import net.mcreator.narutoshippudenmod.procedures.WeaponProcedures.SamehadaToolInInventoryTickProcedure;
import net.mcreator.narutoshippudenmod.procedures.WeaponProcedures.ShibukiLivingEntityIsHitWithToolProcedure;
import net.mcreator.narutoshippudenmod.procedures.WeaponProcedures.ShibukiRightclickedProcedure;
import net.mcreator.narutoshippudenmod.procedures.WeaponProcedures.ShibukiToolInHandTickProcedure;
import net.mcreator.narutoshippudenmod.procedures.WeaponProcedures.ShibukiToolInInventoryTickProcedure;
import net.mcreator.narutoshippudenmod.procedures.WeaponProcedures.ShichiseikenToolInHandTickProcedure;
import net.mcreator.narutoshippudenmod.procedures.WeaponProcedures.ShurikenRightclickedProcedure;
import net.mcreator.narutoshippudenmod.procedures.WeaponProcedures.TantoToolInHandTickProcedure;
import net.mcreator.narutoshippudenmod.procedures.WeaponProcedures.ToolsDamageProcedure;
import net.mcreator.narutoshippudenmod.procedures.WeaponProcedures.ToroiUniqueFumaShurikenRightclickedProcedure;
import net.mcreator.narutoshippudenmod.procedures.WeaponProcedures.WhiteLightChakraSabreRightclickedProcedure;
import net.mcreator.narutoshippudenmod.procedures.WeaponProcedures.WhiteLightChakraSabreToolInHandTickProcedure;
import net.minecraft.block.BlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.item.SwordItem;
import net.minecraft.item.UseAction;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.registries.ObjectHolder;

public final class WeaponItems {
	private WeaponItems() {
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class ChakraBladeItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:chakra_blade")
		public static final Item block = null;

		public ChakraBladeItem(NarutoShippudenModElements instance) {
			super(instance, 1318);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new SwordItem(new IItemTier() {
				public int getMaxUses() {
					return 10000;
				}

				public float getEfficiency() {
					return 0f;
				}

				public float getAttackDamage() {
					return 12f;
				}

				public int getHarvestLevel() {
					return 0;
				}

				public int getEnchantability() {
					return 30;
				}

				public Ingredient getRepairMaterial() {
					return Ingredient.EMPTY;
				}
			}, 3, -2.4f, new Item.Properties().group(WeaponsItemGroup.tab)) {
				@Override
				public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
					super.addInformation(itemstack, world, list, flag);
					list.add(new StringTextComponent("\u00A72Flying Swallow: \u00A7bChakra cost: 20/sec"));
					list.add(new StringTextComponent("\u00A78Kenjutsu Required: 20"));
				}

				@Override
				public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
					ActionResult<ItemStack> retval = super.onItemRightClick(world, entity, hand);
					ItemStack itemstack = retval.getResult();
					double x = entity.getPosX();
					double y = entity.getPosY();
					double z = entity.getPosZ();

					ChakraBladeRightclickedProcedure.executeProcedure(
							Stream.of(new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("itemstack", itemstack))
									.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
					return retval;
				}

				@Override
				public void inventoryTick(ItemStack itemstack, World world, Entity entity, int slot, boolean selected) {
					super.inventoryTick(itemstack, world, entity, slot, selected);
					double x = entity.getPosX();
					double y = entity.getPosY();
					double z = entity.getPosZ();
					if (selected)

						AsumaChakraBladeToolInHandTickProcedure.executeProcedure(
								Stream.of(new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("itemstack", itemstack))
										.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				}
			}.setRegistryName("chakra_blade"));
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class ExplosiveKunaiItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:explosive_kunai")
		public static final Item block = null;

		public ExplosiveKunaiItem(NarutoShippudenModElements instance) {
			super(instance, 314);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(new Item.Properties().group(WeaponsItemGroup.tab).maxStackSize(16).rarity(Rarity.COMMON));
				setRegistryName("explosive_kunai");
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
				list.add(new StringTextComponent("\u00A77Shurikenjutsu Required: 20"));
			}

			@Override
			public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
				ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
				ItemStack itemstack = ar.getResult();
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();

				ExplosiveKunaiRightclickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
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

				ToolsDamageProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("itemstack", itemstack)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return retval;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class FlyingThunderGodKunaiItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:flying_thunder_god_kunai")
		public static final Item block = null;

		public FlyingThunderGodKunaiItem(NarutoShippudenModElements instance) {
			super(instance, 731);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(new Item.Properties().group(WeaponsItemGroup.tab).maxStackSize(1).rarity(Rarity.COMMON));
				setRegistryName("flying_thunder_god_kunai");
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
				list.add(new StringTextComponent("\u00A7bChakra cost: 50"));
				list.add(new StringTextComponent("\u00A73Ninjutsu Required: 10"));
				list.add(new StringTextComponent("\u00A77Shurikenjutsu Required: 25"));
			}

			@Override
			public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
				ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
				ItemStack itemstack = ar.getResult();
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();

				FlyingThunderGodKunaiRightclickedProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z), new AbstractMap.SimpleEntry<>("entity", entity),
								new AbstractMap.SimpleEntry<>("itemstack", itemstack))
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

				FlyingThunderGodKunaiEntitySwingsItemProcedure.executeProcedure(Stream
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
		@ObjectHolder("naruto_shippuden:fuma_shuriken")
		public static final Item block = null;

		public FumaShurikenItem(NarutoShippudenModElements instance) {
			super(instance, 976);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(new Item.Properties().group(WeaponsItemGroup.tab).maxStackSize(16).rarity(Rarity.COMMON));
				setRegistryName("fuma_shuriken");
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
			public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlotType slot) {
				if (slot == EquipmentSlotType.MAINHAND) {
					ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
					builder.putAll(super.getAttributeModifiers(slot));
					builder.put(Attributes.ATTACK_DAMAGE,
							new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Item modifier", (double) 0, AttributeModifier.Operation.ADDITION));
					builder.put(Attributes.ATTACK_SPEED,
							new AttributeModifier(ATTACK_SPEED_MODIFIER, "Item modifier", -2.4, AttributeModifier.Operation.ADDITION));
				}
				return super.getAttributeModifiers(slot);
			}

			@Override
			public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
				super.addInformation(itemstack, world, list, flag);
				list.add(new StringTextComponent("\u00A77Shurikenjutsu Required: 20"));
			}

			@Override
			public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
				ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
				ItemStack itemstack = ar.getResult();
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();

				FumaShurikenRightclickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
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

				ToolsDamageProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("itemstack", itemstack)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return retval;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class GunbaiBlockItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:gunbai_block")
		public static final Item block = null;

		public GunbaiBlockItem(NarutoShippudenModElements instance) {
			super(instance, 1285);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new SwordItem(new IItemTier() {
				public int getMaxUses() {
					return 10000;
				}

				public float getEfficiency() {
					return 0f;
				}

				public float getAttackDamage() {
					return 20f;
				}

				public int getHarvestLevel() {
					return 0;
				}

				public int getEnchantability() {
					return 30;
				}

				public Ingredient getRepairMaterial() {
					return Ingredient.EMPTY;
				}
			}, 3, -2.7f, new Item.Properties().group(null)) {
				@Override
				public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
					super.addInformation(itemstack, world, list, flag);
					list.add(new StringTextComponent("Right-Click to use technique"));
					list.add(new StringTextComponent("Sneak and Right-Click to select or change technique"));
					list.add(new StringTextComponent("\u00A72Block: Blocks any Attack"));
					list.add(new StringTextComponent("\u00A72Wind Push: Pushes Enemies away from you"));
					list.add(new StringTextComponent("\u00A78Kenjutsu Required: 25"));
				}

				@Override
				public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
					ActionResult<ItemStack> retval = super.onItemRightClick(world, entity, hand);
					ItemStack itemstack = retval.getResult();
					double x = entity.getPosX();
					double y = entity.getPosY();
					double z = entity.getPosZ();

					GunbaiShieldOnPlayerStoppedUsingProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
							.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
					return retval;
				}

				@Override
				public void inventoryTick(ItemStack itemstack, World world, Entity entity, int slot, boolean selected) {
					super.inventoryTick(itemstack, world, entity, slot, selected);
					double x = entity.getPosX();
					double y = entity.getPosY();
					double z = entity.getPosZ();
					if (selected)

						GunbaiBlockToolInHandTickProcedure.executeProcedure(
								Stream.of(new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("itemstack", itemstack))
										.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));

					GunbaiSItemInInventoryTickProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
							(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				}
			}.setRegistryName("gunbai_block"));
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class GunbaiItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:gunbai")
		public static final Item block = null;

		public GunbaiItem(NarutoShippudenModElements instance) {
			super(instance, 214);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new SwordItem(new IItemTier() {
				public int getMaxUses() {
					return 10000;
				}

				public float getEfficiency() {
					return 0f;
				}

				public float getAttackDamage() {
					return 20f;
				}

				public int getHarvestLevel() {
					return 0;
				}

				public int getEnchantability() {
					return 30;
				}

				public Ingredient getRepairMaterial() {
					return Ingredient.EMPTY;
				}
			}, 3, -2.7f, new Item.Properties().group(WeaponsItemGroup.tab)) {
				@Override
				public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
					super.addInformation(itemstack, world, list, flag);
					list.add(new StringTextComponent("Right-Click to use technique"));
					list.add(new StringTextComponent("Sneak and Right-Click to select or change technique"));
					list.add(new StringTextComponent("\u00A72Block: Blocks any Attack"));
					list.add(new StringTextComponent("\u00A72Wind Push: Pushes Enemies away from you"));
					list.add(new StringTextComponent("\u00A78Kenjutsu Required: 25"));
				}

				@Override
				public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
					ActionResult<ItemStack> retval = super.onItemRightClick(world, entity, hand);
					ItemStack itemstack = retval.getResult();
					double x = entity.getPosX();
					double y = entity.getPosY();
					double z = entity.getPosZ();

					GunbaiRightclickedProcedure.executeProcedure(Stream
							.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("y", y),
									new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("itemstack", itemstack))
							.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
					return retval;
				}

				@Override
				public void inventoryTick(ItemStack itemstack, World world, Entity entity, int slot, boolean selected) {
					super.inventoryTick(itemstack, world, entity, slot, selected);
					double x = entity.getPosX();
					double y = entity.getPosY();
					double z = entity.getPosZ();
					if (selected)

						GunbaiToolInHandTickProcedure.executeProcedure(
								Stream.of(new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("itemstack", itemstack))
										.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				}
			}.setRegistryName("gunbai"));
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class HiramekareiHammerFormItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:hiramekarei_hammer_form")
		public static final Item block = null;

		public HiramekareiHammerFormItem(NarutoShippudenModElements instance) {
			super(instance, 1292);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new SwordItem(new IItemTier() {
				public int getMaxUses() {
					return 10000;
				}

				public float getEfficiency() {
					return 0f;
				}

				public float getAttackDamage() {
					return 26f;
				}

				public int getHarvestLevel() {
					return 0;
				}

				public int getEnchantability() {
					return 30;
				}

				public Ingredient getRepairMaterial() {
					return Ingredient.EMPTY;
				}
			}, 3, -3.7f, new Item.Properties().group(null)) {
				@Override
				public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
					super.addInformation(itemstack, world, list, flag);
					list.add(new StringTextComponent("Right-Click to use technique"));
					list.add(new StringTextComponent("Sneak and Right-Click to select or change technique"));
					list.add(new StringTextComponent("\u00A72Chakra Storing: \u00A7bChakra cost: 20/sec"));
					list.add(new StringTextComponent("\u00A72Long-sword Form: \u00A7bChakra cost: 20/sec from Sword"));
					list.add(new StringTextComponent("\u00A72Twinsword Form: \u00A7bChakra cost: 20/sec from Sword"));
					list.add(new StringTextComponent("\u00A72Hammer Form: \u00A7bChakra cost: 300 from Sword"));
					list.add(new StringTextComponent("\u00A78Kenjutsu Required: 45"));
				}

				@Override
				public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
					ActionResult<ItemStack> retval = super.onItemRightClick(world, entity, hand);
					ItemStack itemstack = retval.getResult();
					double x = entity.getPosX();
					double y = entity.getPosY();
					double z = entity.getPosZ();

					HiramekareiRightclickedProcedure.executeProcedure(Stream
							.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x),
									new AbstractMap.SimpleEntry<>("y", y), new AbstractMap.SimpleEntry<>("z", z),
									new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("itemstack", itemstack))
							.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
					return retval;
				}

				@Override
				public boolean onEntitySwing(ItemStack itemstack, LivingEntity entity) {
					boolean retval = super.onEntitySwing(itemstack, entity);
					double x = entity.getPosX();
					double y = entity.getPosY();
					double z = entity.getPosZ();
					World world = entity.world;

					HiramekareiEntitySwingsItemProcedure.executeProcedure(
							Stream.of(new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("itemstack", itemstack))
									.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
					return retval;
				}

				@Override
				public void inventoryTick(ItemStack itemstack, World world, Entity entity, int slot, boolean selected) {
					super.inventoryTick(itemstack, world, entity, slot, selected);
					double x = entity.getPosX();
					double y = entity.getPosY();
					double z = entity.getPosZ();
					if (selected)

						HiramekareiToolInHandTickProcedure.executeProcedure(
								Stream.of(new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("itemstack", itemstack))
										.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				}
			}.setRegistryName("hiramekarei_hammer_form"));
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class HiramekareiItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:hiramekarei")
		public static final Item block = null;

		public HiramekareiItem(NarutoShippudenModElements instance) {
			super(instance, 215);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new SwordItem(new IItemTier() {
				public int getMaxUses() {
					return 10000;
				}

				public float getEfficiency() {
					return 0f;
				}

				public float getAttackDamage() {
					return 18f;
				}

				public int getHarvestLevel() {
					return 0;
				}

				public int getEnchantability() {
					return 30;
				}

				public Ingredient getRepairMaterial() {
					return Ingredient.EMPTY;
				}
			}, 3, -3.2f, new Item.Properties().group(WeaponsItemGroup.tab)) {
				@Override
				public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
					super.addInformation(itemstack, world, list, flag);
					list.add(new StringTextComponent("Right-Click to use technique"));
					list.add(new StringTextComponent("Sneak and Right-Click to select or change technique"));
					list.add(new StringTextComponent("\u00A72Chakra Storing: \u00A7bChakra cost: 20/sec"));
					list.add(new StringTextComponent("\u00A72Long-sword Form: \u00A7bChakra cost: 20/sec from Sword"));
					list.add(new StringTextComponent("\u00A72Twinsword Form: \u00A7bChakra cost: 20/sec from Sword"));
					list.add(new StringTextComponent("\u00A72Hammer Form: \u00A7bChakra cost: 300 from Sword"));
					list.add(new StringTextComponent("\u00A78Kenjutsu Required: 45"));
				}

				@Override
				public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
					ActionResult<ItemStack> retval = super.onItemRightClick(world, entity, hand);
					ItemStack itemstack = retval.getResult();
					double x = entity.getPosX();
					double y = entity.getPosY();
					double z = entity.getPosZ();

					HiramekareiRightclickedProcedure.executeProcedure(Stream
							.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x),
									new AbstractMap.SimpleEntry<>("y", y), new AbstractMap.SimpleEntry<>("z", z),
									new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("itemstack", itemstack))
							.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
					return retval;
				}

				@Override
				public boolean onEntitySwing(ItemStack itemstack, LivingEntity entity) {
					boolean retval = super.onEntitySwing(itemstack, entity);
					double x = entity.getPosX();
					double y = entity.getPosY();
					double z = entity.getPosZ();
					World world = entity.world;

					HiramekareiEntitySwingsItemProcedure.executeProcedure(
							Stream.of(new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("itemstack", itemstack))
									.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
					return retval;
				}

				@Override
				public void inventoryTick(ItemStack itemstack, World world, Entity entity, int slot, boolean selected) {
					super.inventoryTick(itemstack, world, entity, slot, selected);
					double x = entity.getPosX();
					double y = entity.getPosY();
					double z = entity.getPosZ();
					if (selected)

						HiramekareiToolInHandTickProcedure.executeProcedure(
								Stream.of(new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("itemstack", itemstack))
										.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				}
			}.setRegistryName("hiramekarei"));
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class HiramekareiSplittedItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:hiramekarei_splitted")
		public static final Item block = null;

		public HiramekareiSplittedItem(NarutoShippudenModElements instance) {
			super(instance, 216);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new SwordItem(new IItemTier() {
				public int getMaxUses() {
					return 10000;
				}

				public float getEfficiency() {
					return 0f;
				}

				public float getAttackDamage() {
					return 14f;
				}

				public int getHarvestLevel() {
					return 0;
				}

				public int getEnchantability() {
					return 30;
				}

				public Ingredient getRepairMaterial() {
					return Ingredient.EMPTY;
				}
			}, 3, -2.6f, new Item.Properties().group(null)) {
				@Override
				public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
					super.addInformation(itemstack, world, list, flag);
					list.add(new StringTextComponent("Right-Click to use technique"));
					list.add(new StringTextComponent("Sneak and Right-Click to select or change technique"));
					list.add(new StringTextComponent("\u00A72Chakra Storing: \u00A7bChakra cost: 20/sec"));
					list.add(new StringTextComponent("\u00A72Long-sword Form: \u00A7bChakra cost: 20/sec from Sword"));
					list.add(new StringTextComponent("\u00A72Twinsword Form: \u00A7bChakra cost: 20/sec from Sword"));
					list.add(new StringTextComponent("\u00A72Hammer Form: \u00A7bChakra cost: 300 from Sword"));
					list.add(new StringTextComponent("\u00A78Kenjutsu Required: 45"));
				}

				@Override
				public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
					ActionResult<ItemStack> retval = super.onItemRightClick(world, entity, hand);
					ItemStack itemstack = retval.getResult();
					double x = entity.getPosX();
					double y = entity.getPosY();
					double z = entity.getPosZ();

					HiramekareiRightclickedProcedure.executeProcedure(Stream
							.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x),
									new AbstractMap.SimpleEntry<>("y", y), new AbstractMap.SimpleEntry<>("z", z),
									new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("itemstack", itemstack))
							.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
					return retval;
				}

				@Override
				public boolean onEntitySwing(ItemStack itemstack, LivingEntity entity) {
					boolean retval = super.onEntitySwing(itemstack, entity);
					double x = entity.getPosX();
					double y = entity.getPosY();
					double z = entity.getPosZ();
					World world = entity.world;

					HiramekareiEntitySwingsItemProcedure.executeProcedure(
							Stream.of(new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("itemstack", itemstack))
									.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
					return retval;
				}

				@Override
				public void inventoryTick(ItemStack itemstack, World world, Entity entity, int slot, boolean selected) {
					super.inventoryTick(itemstack, world, entity, slot, selected);
					double x = entity.getPosX();
					double y = entity.getPosY();
					double z = entity.getPosZ();
					if (selected)

						HiramekareiToolInHandTickProcedure.executeProcedure(
								Stream.of(new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("itemstack", itemstack))
										.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				}
			}.setRegistryName("hiramekarei_splitted"));
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class KabutowariItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:kabutowari")
		public static final Item block = null;

		public KabutowariItem(NarutoShippudenModElements instance) {
			super(instance, 212);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new SwordItem(new IItemTier() {
				public int getMaxUses() {
					return 10000;
				}

				public float getEfficiency() {
					return 0f;
				}

				public float getAttackDamage() {
					return 18f;
				}

				public int getHarvestLevel() {
					return 0;
				}

				public int getEnchantability() {
					return 30;
				}

				public Ingredient getRepairMaterial() {
					return Ingredient.EMPTY;
				}
			}, 3, -3f, new Item.Properties().group(WeaponsItemGroup.tab)) {
				@Override
				public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
					super.addInformation(itemstack, world, list, flag);
					list.add(new StringTextComponent("\u00A72Kabutowari Hammer: Throws up Enemies in air"));
					list.add(new StringTextComponent("\u00A78Kenjutsu Required: 45"));
				}

				@Override
				public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
					ActionResult<ItemStack> retval = super.onItemRightClick(world, entity, hand);
					ItemStack itemstack = retval.getResult();
					double x = entity.getPosX();
					double y = entity.getPosY();
					double z = entity.getPosZ();

					KabutowariRightclickedProcedure.executeProcedure(Stream
							.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x),
									new AbstractMap.SimpleEntry<>("y", y), new AbstractMap.SimpleEntry<>("z", z),
									new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("itemstack", itemstack))
							.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
					return retval;
				}

				@Override
				public void inventoryTick(ItemStack itemstack, World world, Entity entity, int slot, boolean selected) {
					super.inventoryTick(itemstack, world, entity, slot, selected);
					double x = entity.getPosX();
					double y = entity.getPosY();
					double z = entity.getPosZ();
					if (selected)

						KabutowariToolInHandTickProcedure.executeProcedure(
								Stream.of(new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("itemstack", itemstack))
										.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				}
			}.setRegistryName("kabutowari"));
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class KatanaItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:katana")
		public static final Item block = null;

		public KatanaItem(NarutoShippudenModElements instance) {
			super(instance, 210);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new SwordItem(new IItemTier() {
				public int getMaxUses() {
					return 10000;
				}

				public float getEfficiency() {
					return 0f;
				}

				public float getAttackDamage() {
					return 10f;
				}

				public int getHarvestLevel() {
					return 0;
				}

				public int getEnchantability() {
					return 30;
				}

				public Ingredient getRepairMaterial() {
					return Ingredient.EMPTY;
				}
			}, 3, -2.5f, new Item.Properties().group(WeaponsItemGroup.tab)) {
				@Override
				public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
					super.addInformation(itemstack, world, list, flag);
					list.add(new StringTextComponent("\u00A78Kenjutsu Required: 15"));
				}

				@Override
				public void inventoryTick(ItemStack itemstack, World world, Entity entity, int slot, boolean selected) {
					super.inventoryTick(itemstack, world, entity, slot, selected);
					double x = entity.getPosX();
					double y = entity.getPosY();
					double z = entity.getPosZ();
					if (selected)

						KatanaToolInHandTickProcedure.executeProcedure(
								Stream.of(new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("itemstack", itemstack))
										.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				}
			}.setRegistryName("katana"));
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class KatanaJonin1Item extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:katana_jonin_1")
		public static final Item block = null;

		public KatanaJonin1Item(NarutoShippudenModElements instance) {
			super(instance, 681);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new SwordItem(new IItemTier() {
				public int getMaxUses() {
					return 10000;
				}

				public float getEfficiency() {
					return 0f;
				}

				public float getAttackDamage() {
					return 12f;
				}

				public int getHarvestLevel() {
					return 0;
				}

				public int getEnchantability() {
					return 30;
				}

				public Ingredient getRepairMaterial() {
					return Ingredient.EMPTY;
				}
			}, 3, -2.5f, new Item.Properties().group(null)) {
			}.setRegistryName("katana_jonin_1"));
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class KibaSwordItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:kiba_sword")
		public static final Item block = null;

		public KibaSwordItem(NarutoShippudenModElements instance) {
			super(instance, 209);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new SwordItem(new IItemTier() {
				public int getMaxUses() {
					return 10000;
				}

				public float getEfficiency() {
					return 0f;
				}

				public float getAttackDamage() {
					return 12f;
				}

				public int getHarvestLevel() {
					return 0;
				}

				public int getEnchantability() {
					return 30;
				}

				public Ingredient getRepairMaterial() {
					return Ingredient.EMPTY;
				}
			}, 3, -2.5f, new Item.Properties().group(WeaponsItemGroup.tab)) {
				@Override
				public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
					super.addInformation(itemstack, world, list, flag);
					list.add(new StringTextComponent("Right-Click to use technique"));
					list.add(new StringTextComponent("Sneak and Right-Click to select or change technique"));
					list.add(new StringTextComponent("\u00A72Lightning Ball: \u00A7bChakra cost: 100 \u00A73Ninjutsu required: 5"));
					list.add(new StringTextComponent("\u00A72Lightning: \u00A7bChakra cost: 150 \u00A73Ninjutsu required: 10"));
					list.add(new StringTextComponent("\u00A72Lightning Wave: \u00A7bChakra cost: 200 \u00A73Ninjutsu required: 15"));
					list.add(new StringTextComponent("\u00A78Kenjutsu Required: 45"));
				}

				@Override
				public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
					ActionResult<ItemStack> retval = super.onItemRightClick(world, entity, hand);
					ItemStack itemstack = retval.getResult();
					double x = entity.getPosX();
					double y = entity.getPosY();
					double z = entity.getPosZ();

					KibaSwordRightclickedProcedure.executeProcedure(Stream
							.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x),
									new AbstractMap.SimpleEntry<>("y", y), new AbstractMap.SimpleEntry<>("z", z),
									new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("itemstack", itemstack))
							.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
					return retval;
				}

				@Override
				public void inventoryTick(ItemStack itemstack, World world, Entity entity, int slot, boolean selected) {
					super.inventoryTick(itemstack, world, entity, slot, selected);
					double x = entity.getPosX();
					double y = entity.getPosY();
					double z = entity.getPosZ();
					if (selected)

						KibaSwordToolInHandTickProcedure.executeProcedure(
								Stream.of(new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("itemstack", itemstack))
										.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				}
			}.setRegistryName("kiba_sword"));
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class KubikiribochoItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:kubikiribocho")
		public static final Item block = null;

		public KubikiribochoItem(NarutoShippudenModElements instance) {
			super(instance, 203);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new SwordItem(new IItemTier() {
				public int getMaxUses() {
					return 3000;
				}

				public float getEfficiency() {
					return 0f;
				}

				public float getAttackDamage() {
					return 16f;
				}

				public int getHarvestLevel() {
					return 0;
				}

				public int getEnchantability() {
					return 30;
				}

				public Ingredient getRepairMaterial() {
					return Ingredient.EMPTY;
				}
			}, 3, -3.3f, new Item.Properties().group(WeaponsItemGroup.tab)) {
				@Override
				public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
					super.addInformation(itemstack, world, list, flag);
					list.add(new StringTextComponent("\u00A72The sword regeneration: +15 Durability to sword after Mob/Player kill"));
					list.add(new StringTextComponent("\u00A78Kenjutsu Required: 45"));
				}

				@Override
				public void inventoryTick(ItemStack itemstack, World world, Entity entity, int slot, boolean selected) {
					super.inventoryTick(itemstack, world, entity, slot, selected);
					double x = entity.getPosX();
					double y = entity.getPosY();
					double z = entity.getPosZ();
					if (selected)

						KubikiribochoToolInHandTickProcedure.executeProcedure(
								Stream.of(new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("itemstack", itemstack))
										.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				}
			}.setRegistryName("kubikiribocho"));
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class KunaiItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:kunai")
		public static final Item block = null;

		public KunaiItem(NarutoShippudenModElements instance) {
			super(instance, 313);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(new Item.Properties().group(WeaponsItemGroup.tab).maxStackSize(16).rarity(Rarity.COMMON));
				setRegistryName("kunai");
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
			public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlotType slot) {
				if (slot == EquipmentSlotType.MAINHAND) {
					ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
					builder.putAll(super.getAttributeModifiers(slot));
					builder.put(Attributes.ATTACK_DAMAGE,
							new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Item modifier", (double) 0, AttributeModifier.Operation.ADDITION));
					builder.put(Attributes.ATTACK_SPEED,
							new AttributeModifier(ATTACK_SPEED_MODIFIER, "Item modifier", -2.4, AttributeModifier.Operation.ADDITION));
				}
				return super.getAttributeModifiers(slot);
			}

			@Override
			public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
				super.addInformation(itemstack, world, list, flag);
				list.add(new StringTextComponent("\u00A77Shurikenjutsu Required: 10"));
			}

			@Override
			public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
				ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
				ItemStack itemstack = ar.getResult();
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();

				KunaiRightclickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
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

				ToolsDamageProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("itemstack", itemstack)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return retval;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class KusanagiSasukeItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:kusanagi_sasuke")
		public static final Item block = null;

		public KusanagiSasukeItem(NarutoShippudenModElements instance) {
			super(instance, 204);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new SwordItem(new IItemTier() {
				public int getMaxUses() {
					return 10000;
				}

				public float getEfficiency() {
					return 0f;
				}

				public float getAttackDamage() {
					return 12f;
				}

				public int getHarvestLevel() {
					return 0;
				}

				public int getEnchantability() {
					return 30;
				}

				public Ingredient getRepairMaterial() {
					return Ingredient.EMPTY;
				}
			}, 3, -2.5f, new Item.Properties().group(WeaponsItemGroup.tab)) {
				@Override
				public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
					super.addInformation(itemstack, world, list, flag);
					list.add(new StringTextComponent("\u00A72Channel Lightning Chakra: \u00A7bChakra cost: 20/sec"));
					list.add(new StringTextComponent("\u00A78Kenjutsu Required: 25"));
				}

				@Override
				public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
					ActionResult<ItemStack> retval = super.onItemRightClick(world, entity, hand);
					ItemStack itemstack = retval.getResult();
					double x = entity.getPosX();
					double y = entity.getPosY();
					double z = entity.getPosZ();

					KusanagiSasukeRightclickedProcedure.executeProcedure(
							Stream.of(new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("itemstack", itemstack))
									.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
					return retval;
				}

				@Override
				public boolean hitEntity(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
					boolean retval = super.hitEntity(itemstack, entity, sourceentity);
					double x = entity.getPosX();
					double y = entity.getPosY();
					double z = entity.getPosZ();
					World world = entity.world;

					KusanagiSasukeLivingEntityIsHitWithToolProcedure.executeProcedure(
							Stream.of(new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("itemstack", itemstack))
									.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
					return retval;
				}

				@Override
				public void inventoryTick(ItemStack itemstack, World world, Entity entity, int slot, boolean selected) {
					super.inventoryTick(itemstack, world, entity, slot, selected);
					double x = entity.getPosX();
					double y = entity.getPosY();
					double z = entity.getPosZ();
					if (selected)

						KusanagiSasukeToolInHandTickProcedure.executeProcedure(
								Stream.of(new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("itemstack", itemstack))
										.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				}
			}.setRegistryName("kusanagi_sasuke"));
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class NuibariItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:nuibari")
		public static final Item block = null;

		public NuibariItem(NarutoShippudenModElements instance) {
			super(instance, 208);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new SwordItem(new IItemTier() {
				public int getMaxUses() {
					return 10000;
				}

				public float getEfficiency() {
					return 0f;
				}

				public float getAttackDamage() {
					return 12f;
				}

				public int getHarvestLevel() {
					return 0;
				}

				public int getEnchantability() {
					return 30;
				}

				public Ingredient getRepairMaterial() {
					return Ingredient.EMPTY;
				}
			}, 3, -3.3f, new Item.Properties().group(WeaponsItemGroup.tab)) {
				@Override
				public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
					super.addInformation(itemstack, world, list, flag);
					list.add(new StringTextComponent("Right-Click to use technique"));
					list.add(new StringTextComponent("Sneak and Right-Click to select or change technique"));
					list.add(new StringTextComponent("\u00A72Nuibari: Throw Needle"));
					list.add(new StringTextComponent("\u00A72Nuibari: Pull Needle"));
					list.add(new StringTextComponent("\u00A78Kenjutsu Required: 45"));
				}

				@Override
				public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
					ActionResult<ItemStack> retval = super.onItemRightClick(world, entity, hand);
					ItemStack itemstack = retval.getResult();
					double x = entity.getPosX();
					double y = entity.getPosY();
					double z = entity.getPosZ();

					NuibariRightclickedProcedure.executeProcedure(Stream
							.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("entity", entity),
									new AbstractMap.SimpleEntry<>("itemstack", itemstack))
							.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
					return retval;
				}

				@Override
				public void inventoryTick(ItemStack itemstack, World world, Entity entity, int slot, boolean selected) {
					super.inventoryTick(itemstack, world, entity, slot, selected);
					double x = entity.getPosX();
					double y = entity.getPosY();
					double z = entity.getPosZ();
					if (selected)

						NuibariToolInHandTickProcedure.executeProcedure(
								Stream.of(new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("itemstack", itemstack))
										.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				}
			}.setRegistryName("nuibari"));
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class OtsutsukiAxeItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:otsutsuki_axe")
		public static final Item block = null;

		public OtsutsukiAxeItem(NarutoShippudenModElements instance) {
			super(instance, 753);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new SwordItem(new IItemTier() {
				public int getMaxUses() {
					return 0;
				}

				public float getEfficiency() {
					return 0f;
				}

				public float getAttackDamage() {
					return 20f;
				}

				public int getHarvestLevel() {
					return 0;
				}

				public int getEnchantability() {
					return 0;
				}

				public Ingredient getRepairMaterial() {
					return Ingredient.EMPTY;
				}
			}, 3, -3.3f, new Item.Properties().group(null)) {
				@Override
				public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
					super.addInformation(itemstack, world, list, flag);
					list.add(new StringTextComponent("Sneak Right-Click to change weapon type"));
					list.add(new StringTextComponent("Right-Click transform weapon"));
				}

				@Override
				public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
					ActionResult<ItemStack> retval = super.onItemRightClick(world, entity, hand);
					ItemStack itemstack = retval.getResult();
					double x = entity.getPosX();
					double y = entity.getPosY();
					double z = entity.getPosZ();

					OtsutsukiToolsSwitchProcedure.executeProcedure(
							Stream.of(new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("itemstack", itemstack))
									.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
					return retval;
				}
			}.setRegistryName("otsutsuki_axe"));
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class OtsutsukiBatItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:otsutsuki_bat")
		public static final Item block = null;

		public OtsutsukiBatItem(NarutoShippudenModElements instance) {
			super(instance, 754);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new SwordItem(new IItemTier() {
				public int getMaxUses() {
					return 0;
				}

				public float getEfficiency() {
					return 0f;
				}

				public float getAttackDamage() {
					return 14f;
				}

				public int getHarvestLevel() {
					return 0;
				}

				public int getEnchantability() {
					return 0;
				}

				public Ingredient getRepairMaterial() {
					return Ingredient.EMPTY;
				}
			}, 3, -2.9f, new Item.Properties().group(null)) {
				@Override
				public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
					super.addInformation(itemstack, world, list, flag);
					list.add(new StringTextComponent("Sneak Right-Click to change weapon type"));
					list.add(new StringTextComponent("Right-Click transform weapon"));
				}

				@Override
				public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
					ActionResult<ItemStack> retval = super.onItemRightClick(world, entity, hand);
					ItemStack itemstack = retval.getResult();
					double x = entity.getPosX();
					double y = entity.getPosY();
					double z = entity.getPosZ();

					OtsutsukiToolsSwitchProcedure.executeProcedure(
							Stream.of(new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("itemstack", itemstack))
									.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
					return retval;
				}
			}.setRegistryName("otsutsuki_bat"));
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class OtsutsukiBladeItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:otsutsuki_blade")
		public static final Item block = null;

		public OtsutsukiBladeItem(NarutoShippudenModElements instance) {
			super(instance, 755);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new SwordItem(new IItemTier() {
				public int getMaxUses() {
					return 0;
				}

				public float getEfficiency() {
					return 0f;
				}

				public float getAttackDamage() {
					return 10f;
				}

				public int getHarvestLevel() {
					return 0;
				}

				public int getEnchantability() {
					return 0;
				}

				public Ingredient getRepairMaterial() {
					return Ingredient.EMPTY;
				}
			}, 3, -2.2f, new Item.Properties().group(null)) {
				@Override
				public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
					super.addInformation(itemstack, world, list, flag);
					list.add(new StringTextComponent("Sneak Right-Click to change weapon type"));
					list.add(new StringTextComponent("Right-Click transform weapon"));
				}

				@Override
				public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
					ActionResult<ItemStack> retval = super.onItemRightClick(world, entity, hand);
					ItemStack itemstack = retval.getResult();
					double x = entity.getPosX();
					double y = entity.getPosY();
					double z = entity.getPosZ();

					OtsutsukiToolsSwitchProcedure.executeProcedure(
							Stream.of(new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("itemstack", itemstack))
									.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
					return retval;
				}
			}.setRegistryName("otsutsuki_blade"));
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class OtsutsukiChoppingSwordItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:otsutsuki_chopping_sword")
		public static final Item block = null;

		public OtsutsukiChoppingSwordItem(NarutoShippudenModElements instance) {
			super(instance, 756);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new SwordItem(new IItemTier() {
				public int getMaxUses() {
					return 0;
				}

				public float getEfficiency() {
					return 0f;
				}

				public float getAttackDamage() {
					return 18f;
				}

				public int getHarvestLevel() {
					return 0;
				}

				public int getEnchantability() {
					return 0;
				}

				public Ingredient getRepairMaterial() {
					return Ingredient.EMPTY;
				}
			}, 3, -3.1f, new Item.Properties().group(null)) {
				@Override
				public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
					super.addInformation(itemstack, world, list, flag);
					list.add(new StringTextComponent("Sneak Right-Click to change weapon type"));
					list.add(new StringTextComponent("Right-Click transform weapon"));
				}

				@Override
				public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
					ActionResult<ItemStack> retval = super.onItemRightClick(world, entity, hand);
					ItemStack itemstack = retval.getResult();
					double x = entity.getPosX();
					double y = entity.getPosY();
					double z = entity.getPosZ();

					OtsutsukiToolsSwitchProcedure.executeProcedure(
							Stream.of(new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("itemstack", itemstack))
									.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
					return retval;
				}
			}.setRegistryName("otsutsuki_chopping_sword"));
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class OtsutsukiHammerItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:otsutsuki_hammer")
		public static final Item block = null;

		public OtsutsukiHammerItem(NarutoShippudenModElements instance) {
			super(instance, 757);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new SwordItem(new IItemTier() {
				public int getMaxUses() {
					return 0;
				}

				public float getEfficiency() {
					return 0f;
				}

				public float getAttackDamage() {
					return 22f;
				}

				public int getHarvestLevel() {
					return 0;
				}

				public int getEnchantability() {
					return 0;
				}

				public Ingredient getRepairMaterial() {
					return Ingredient.EMPTY;
				}
			}, 3, -3.5f, new Item.Properties().group(null)) {
				@Override
				public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
					super.addInformation(itemstack, world, list, flag);
					list.add(new StringTextComponent("Sneak Right-Click to change weapon type"));
					list.add(new StringTextComponent("Right-Click transform weapon"));
				}

				@Override
				public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
					ActionResult<ItemStack> retval = super.onItemRightClick(world, entity, hand);
					ItemStack itemstack = retval.getResult();
					double x = entity.getPosX();
					double y = entity.getPosY();
					double z = entity.getPosZ();

					OtsutsukiToolsSwitchProcedure.executeProcedure(
							Stream.of(new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("itemstack", itemstack))
									.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
					return retval;
				}
			}.setRegistryName("otsutsuki_hammer"));
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class OtsutsukiKatanaItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:otsutsuki_katana")
		public static final Item block = null;

		public OtsutsukiKatanaItem(NarutoShippudenModElements instance) {
			super(instance, 758);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new SwordItem(new IItemTier() {
				public int getMaxUses() {
					return 0;
				}

				public float getEfficiency() {
					return 0f;
				}

				public float getAttackDamage() {
					return 13f;
				}

				public int getHarvestLevel() {
					return 0;
				}

				public int getEnchantability() {
					return 0;
				}

				public Ingredient getRepairMaterial() {
					return Ingredient.EMPTY;
				}
			}, 3, -3f, new Item.Properties().group(null)) {
				@Override
				public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
					super.addInformation(itemstack, world, list, flag);
					list.add(new StringTextComponent("Sneak Right-Click to change weapon type"));
					list.add(new StringTextComponent("Right-Click transform weapon"));
				}

				@Override
				public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
					ActionResult<ItemStack> retval = super.onItemRightClick(world, entity, hand);
					ItemStack itemstack = retval.getResult();
					double x = entity.getPosX();
					double y = entity.getPosY();
					double z = entity.getPosZ();

					OtsutsukiToolsSwitchProcedure.executeProcedure(
							Stream.of(new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("itemstack", itemstack))
									.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
					return retval;
				}
			}.setRegistryName("otsutsuki_katana"));
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class OtsutsukiSpearItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:otsutsuki_spear")
		public static final Item block = null;

		public OtsutsukiSpearItem(NarutoShippudenModElements instance) {
			super(instance, 759);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new SwordItem(new IItemTier() {
				public int getMaxUses() {
					return 0;
				}

				public float getEfficiency() {
					return 0f;
				}

				public float getAttackDamage() {
					return 15f;
				}

				public int getHarvestLevel() {
					return 0;
				}

				public int getEnchantability() {
					return 0;
				}

				public Ingredient getRepairMaterial() {
					return Ingredient.EMPTY;
				}
			}, 3, -2.6f, new Item.Properties().group(null)) {
				@Override
				public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
					super.addInformation(itemstack, world, list, flag);
					list.add(new StringTextComponent("Sneak Right-Click to change weapon type"));
					list.add(new StringTextComponent("Right-Click transform weapon"));
				}

				@Override
				public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
					ActionResult<ItemStack> retval = super.onItemRightClick(world, entity, hand);
					ItemStack itemstack = retval.getResult();
					double x = entity.getPosX();
					double y = entity.getPosY();
					double z = entity.getPosZ();

					OtsutsukiToolsSwitchProcedure.executeProcedure(
							Stream.of(new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("itemstack", itemstack))
									.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
					return retval;
				}
			}.setRegistryName("otsutsuki_spear"));
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class OtsutsukiSwordItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:otsutsuki_sword")
		public static final Item block = null;

		public OtsutsukiSwordItem(NarutoShippudenModElements instance) {
			super(instance, 760);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new SwordItem(new IItemTier() {
				public int getMaxUses() {
					return 0;
				}

				public float getEfficiency() {
					return 0f;
				}

				public float getAttackDamage() {
					return 18f;
				}

				public int getHarvestLevel() {
					return 0;
				}

				public int getEnchantability() {
					return 0;
				}

				public Ingredient getRepairMaterial() {
					return Ingredient.EMPTY;
				}
			}, 3, -2.8f, new Item.Properties().group(null)) {
				@Override
				public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
					super.addInformation(itemstack, world, list, flag);
					list.add(new StringTextComponent("Sneak Right-Click to change weapon type"));
					list.add(new StringTextComponent("Right-Click transform weapon"));
				}

				@Override
				public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
					ActionResult<ItemStack> retval = super.onItemRightClick(world, entity, hand);
					ItemStack itemstack = retval.getResult();
					double x = entity.getPosX();
					double y = entity.getPosY();
					double z = entity.getPosZ();

					OtsutsukiToolsSwitchProcedure.executeProcedure(
							Stream.of(new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("itemstack", itemstack))
									.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
					return retval;
				}
			}.setRegistryName("otsutsuki_sword"));
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class PoisonKunaiItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:poison_kunai")
		public static final Item block = null;

		public PoisonKunaiItem(NarutoShippudenModElements instance) {
			super(instance, 1324);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(new Item.Properties().group(WeaponsItemGroup.tab).maxStackSize(16).rarity(Rarity.COMMON));
				setRegistryName("poison_kunai");
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
			public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlotType slot) {
				if (slot == EquipmentSlotType.MAINHAND) {
					ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
					builder.putAll(super.getAttributeModifiers(slot));
					builder.put(Attributes.ATTACK_DAMAGE,
							new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Item modifier", (double) 0, AttributeModifier.Operation.ADDITION));
					builder.put(Attributes.ATTACK_SPEED,
							new AttributeModifier(ATTACK_SPEED_MODIFIER, "Item modifier", -2.4, AttributeModifier.Operation.ADDITION));
				}
				return super.getAttributeModifiers(slot);
			}

			@Override
			public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
				super.addInformation(itemstack, world, list, flag);
				list.add(new StringTextComponent("\u00A77Shurikenjutsu Required: 15"));
			}

			@Override
			public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
				ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
				ItemStack itemstack = ar.getResult();
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();

				PoisonKunaiRightclickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
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

				ToolsDamageProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("itemstack", itemstack)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return retval;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class SamehadaItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:samehada")
		public static final Item block = null;

		public SamehadaItem(NarutoShippudenModElements instance) {
			super(instance, 207);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new SwordItem(new IItemTier() {
				public int getMaxUses() {
					return 10000;
				}

				public float getEfficiency() {
					return 0f;
				}

				public float getAttackDamage() {
					return 18f;
				}

				public int getHarvestLevel() {
					return 0;
				}

				public int getEnchantability() {
					return 30;
				}

				public Ingredient getRepairMaterial() {
					return Ingredient.EMPTY;
				}
			}, 3, -2.8f, new Item.Properties().group(WeaponsItemGroup.tab)) {
				@Override
				public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
					super.addInformation(itemstack, world, list, flag);
					list.add(new StringTextComponent("Right-Click to use technique"));
					list.add(new StringTextComponent("Sneak and Right-Click to select or change technique"));
					list.add(new StringTextComponent("\u00A72Samehada: \u00A7bChakra cost: 10/sec"));
					list.add(new StringTextComponent("\u00A72Chakra Steal: +5% Chakra Amount of Mob you hit"));
					list.add(new StringTextComponent("\u00A72Chakra Heal:  +0.2% HP of Mob you hit"));
					list.add(new StringTextComponent("\u00A78Kenjutsu Required: 45"));
				}

				@Override
				public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
					ActionResult<ItemStack> retval = super.onItemRightClick(world, entity, hand);
					ItemStack itemstack = retval.getResult();
					double x = entity.getPosX();
					double y = entity.getPosY();
					double z = entity.getPosZ();

					SamehadaRightclickedProcedure.executeProcedure(
							Stream.of(new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("itemstack", itemstack))
									.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
					return retval;
				}

				@Override
				public boolean hitEntity(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
					boolean retval = super.hitEntity(itemstack, entity, sourceentity);
					double x = entity.getPosX();
					double y = entity.getPosY();
					double z = entity.getPosZ();
					World world = entity.world;

					SamehadaLivingEntityIsHitWithToolProcedure.executeProcedure(Stream
							.of(new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("sourceentity", sourceentity),
									new AbstractMap.SimpleEntry<>("itemstack", itemstack))
							.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
					return retval;
				}

				@Override
				public void inventoryTick(ItemStack itemstack, World world, Entity entity, int slot, boolean selected) {
					super.inventoryTick(itemstack, world, entity, slot, selected);
					double x = entity.getPosX();
					double y = entity.getPosY();
					double z = entity.getPosZ();
					if (selected)

						SamehadaToolInInventoryTickProcedure.executeProcedure(
								Stream.of(new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("itemstack", itemstack))
										.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				}
			}.setRegistryName("samehada"));
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class ShibukiItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:shibuki")
		public static final Item block = null;

		public ShibukiItem(NarutoShippudenModElements instance) {
			super(instance, 213);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new SwordItem(new IItemTier() {
				public int getMaxUses() {
					return 10000;
				}

				public float getEfficiency() {
					return 0f;
				}

				public float getAttackDamage() {
					return 16f;
				}

				public int getHarvestLevel() {
					return 0;
				}

				public int getEnchantability() {
					return 30;
				}

				public Ingredient getRepairMaterial() {
					return Ingredient.EMPTY;
				}
			}, 3, -3.2f, new Item.Properties().group(WeaponsItemGroup.tab)) {
				@Override
				public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
					super.addInformation(itemstack, world, list, flag);
					list.add(new StringTextComponent("Right-Click to use technique"));
					list.add(new StringTextComponent("Sneak and Right-Click to select or change technique"));
					list.add(new StringTextComponent("\u00A72Paper Bomb Trap: \u00A7bChakra cost: 350"));
					list.add(new StringTextComponent("\u00A72Explosion: \u00A7bChakra cost: 20/sec"));
					list.add(new StringTextComponent("\u00A72Explosions Trail: \u00A7bChakra cost: 100/sec"));
					list.add(new StringTextComponent("\u00A78Kenjutsu Required: 45"));
				}

				@Override
				public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
					ActionResult<ItemStack> retval = super.onItemRightClick(world, entity, hand);
					ItemStack itemstack = retval.getResult();
					double x = entity.getPosX();
					double y = entity.getPosY();
					double z = entity.getPosZ();

					ShibukiRightclickedProcedure.executeProcedure(Stream
							.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("y", y),
									new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("itemstack", itemstack))
							.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
					return retval;
				}

				@Override
				public boolean hitEntity(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
					boolean retval = super.hitEntity(itemstack, entity, sourceentity);
					double x = entity.getPosX();
					double y = entity.getPosY();
					double z = entity.getPosZ();
					World world = entity.world;

					ShibukiLivingEntityIsHitWithToolProcedure.executeProcedure(Stream
							.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("entity", entity),
									new AbstractMap.SimpleEntry<>("sourceentity", sourceentity), new AbstractMap.SimpleEntry<>("itemstack", itemstack))
							.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
					return retval;
				}

				@Override
				public void inventoryTick(ItemStack itemstack, World world, Entity entity, int slot, boolean selected) {
					super.inventoryTick(itemstack, world, entity, slot, selected);
					double x = entity.getPosX();
					double y = entity.getPosY();
					double z = entity.getPosZ();
					if (selected)

						ShibukiToolInHandTickProcedure.executeProcedure(
								Stream.of(new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("itemstack", itemstack))
										.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));

					ShibukiToolInInventoryTickProcedure.executeProcedure(Stream
							.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("entity", entity),
									new AbstractMap.SimpleEntry<>("itemstack", itemstack))
							.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				}
			}.setRegistryName("shibuki"));
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class ShichiseikenItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:shichiseiken")
		public static final Item block = null;

		public ShichiseikenItem(NarutoShippudenModElements instance) {
			super(instance, 1278);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new SwordItem(new IItemTier() {
				public int getMaxUses() {
					return 10000;
				}

				public float getEfficiency() {
					return 0f;
				}

				public float getAttackDamage() {
					return 17f;
				}

				public int getHarvestLevel() {
					return 0;
				}

				public int getEnchantability() {
					return 30;
				}

				public Ingredient getRepairMaterial() {
					return Ingredient.EMPTY;
				}
			}, 3, -3f, new Item.Properties().group(WeaponsItemGroup.tab)) {
				@Override
				public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
					super.addInformation(itemstack, world, list, flag);
					list.add(new StringTextComponent("\u00A78Kenjutsu Required: 35"));
				}

				@Override
				public void inventoryTick(ItemStack itemstack, World world, Entity entity, int slot, boolean selected) {
					super.inventoryTick(itemstack, world, entity, slot, selected);
					double x = entity.getPosX();
					double y = entity.getPosY();
					double z = entity.getPosZ();
					if (selected)

						ShichiseikenToolInHandTickProcedure.executeProcedure(
								Stream.of(new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("itemstack", itemstack))
										.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				}
			}.setRegistryName("shichiseiken"));
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class ShurikenItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:shuriken")
		public static final Item block = null;

		public ShurikenItem(NarutoShippudenModElements instance) {
			super(instance, 315);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(new Item.Properties().group(WeaponsItemGroup.tab).maxStackSize(16).rarity(Rarity.COMMON));
				setRegistryName("shuriken");
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
				list.add(new StringTextComponent("\u00A77Shurikenjutsu Required: 5"));
			}

			@Override
			public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
				ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
				ItemStack itemstack = ar.getResult();
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();

				ShurikenRightclickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
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

				ToolsDamageProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("itemstack", itemstack)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return retval;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class TantoItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:tanto")
		public static final Item block = null;

		public TantoItem(NarutoShippudenModElements instance) {
			super(instance, 205);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new SwordItem(new IItemTier() {
				public int getMaxUses() {
					return 10000;
				}

				public float getEfficiency() {
					return 0f;
				}

				public float getAttackDamage() {
					return 5f;
				}

				public int getHarvestLevel() {
					return 0;
				}

				public int getEnchantability() {
					return 30;
				}

				public Ingredient getRepairMaterial() {
					return Ingredient.EMPTY;
				}
			}, 3, -2.7f, new Item.Properties().group(WeaponsItemGroup.tab)) {
				@Override
				public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
					super.addInformation(itemstack, world, list, flag);
					list.add(new StringTextComponent("\u00A78Kenjutsu Required: 5"));
				}

				@Override
				public void inventoryTick(ItemStack itemstack, World world, Entity entity, int slot, boolean selected) {
					super.inventoryTick(itemstack, world, entity, slot, selected);
					double x = entity.getPosX();
					double y = entity.getPosY();
					double z = entity.getPosZ();
					if (selected)

						TantoToolInHandTickProcedure.executeProcedure(
								Stream.of(new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("itemstack", itemstack))
										.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				}
			}.setRegistryName("tanto"));
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class ToroiUniqueFumaShurikenItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:toroi_unique_fuma_shuriken")
		public static final Item block = null;

		public ToroiUniqueFumaShurikenItem(NarutoShippudenModElements instance) {
			super(instance, 974);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(new Item.Properties().group(WeaponsItemGroup.tab).maxStackSize(16).rarity(Rarity.COMMON));
				setRegistryName("toroi_unique_fuma_shuriken");
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
			public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlotType slot) {
				if (slot == EquipmentSlotType.MAINHAND) {
					ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
					builder.putAll(super.getAttributeModifiers(slot));
					builder.put(Attributes.ATTACK_DAMAGE,
							new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Item modifier", (double) 0, AttributeModifier.Operation.ADDITION));
					builder.put(Attributes.ATTACK_SPEED,
							new AttributeModifier(ATTACK_SPEED_MODIFIER, "Item modifier", -2.4, AttributeModifier.Operation.ADDITION));
				}
				return super.getAttributeModifiers(slot);
			}

			@Override
			public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
				super.addInformation(itemstack, world, list, flag);
				list.add(new StringTextComponent("\u00A77Shurikenjutsu Required: 25"));
			}

			@Override
			public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
				ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
				ItemStack itemstack = ar.getResult();
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();

				ToroiUniqueFumaShurikenRightclickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
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

				ToolsDamageProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("itemstack", itemstack)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return retval;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class TripleBladeScytheItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:triple_blade_scythe")
		public static final Item block = null;

		public TripleBladeScytheItem(NarutoShippudenModElements instance) {
			super(instance, 1316);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new SwordItem(new IItemTier() {
				public int getMaxUses() {
					return 10000;
				}

				public float getEfficiency() {
					return 0f;
				}

				public float getAttackDamage() {
					return 13f;
				}

				public int getHarvestLevel() {
					return 0;
				}

				public int getEnchantability() {
					return 30;
				}

				public Ingredient getRepairMaterial() {
					return Ingredient.EMPTY;
				}
			}, 3, -3f, new Item.Properties().group(WeaponsItemGroup.tab)) {
				@Override
				public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
					super.addInformation(itemstack, world, list, flag);
					list.add(new StringTextComponent("\u00A78Kenjutsu Required: 30"));
				}

				@Override
				public void inventoryTick(ItemStack itemstack, World world, Entity entity, int slot, boolean selected) {
					super.inventoryTick(itemstack, world, entity, slot, selected);
					double x = entity.getPosX();
					double y = entity.getPosY();
					double z = entity.getPosZ();
					if (selected)

						HidanTripleBladeScytheToolInHandTickProcedure.executeProcedure(
								Stream.of(new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("itemstack", itemstack))
										.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				}
			}.setRegistryName("triple_blade_scythe"));
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class WhiteLightChakraSabreItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:white_light_chakra_sabre")
		public static final Item block = null;

		public WhiteLightChakraSabreItem(NarutoShippudenModElements instance) {
			super(instance, 1301);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new SwordItem(new IItemTier() {
				public int getMaxUses() {
					return 10000;
				}

				public float getEfficiency() {
					return 0f;
				}

				public float getAttackDamage() {
					return 6f;
				}

				public int getHarvestLevel() {
					return 0;
				}

				public int getEnchantability() {
					return 30;
				}

				public Ingredient getRepairMaterial() {
					return Ingredient.EMPTY;
				}
			}, 3, -2.6f, new Item.Properties().group(WeaponsItemGroup.tab)) {
				@Override
				public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
					super.addInformation(itemstack, world, list, flag);
					list.add(new StringTextComponent("\u00A72White Light Chakra Sabre: \u00A7bChakra cost: 20/sec"));
					list.add(new StringTextComponent("\u00A78Kenjutsu Required: 10"));
				}

				@Override
				public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
					ActionResult<ItemStack> retval = super.onItemRightClick(world, entity, hand);
					ItemStack itemstack = retval.getResult();
					double x = entity.getPosX();
					double y = entity.getPosY();
					double z = entity.getPosZ();

					WhiteLightChakraSabreRightclickedProcedure.executeProcedure(
							Stream.of(new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("itemstack", itemstack))
									.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
					return retval;
				}

				@Override
				public void inventoryTick(ItemStack itemstack, World world, Entity entity, int slot, boolean selected) {
					super.inventoryTick(itemstack, world, entity, slot, selected);
					double x = entity.getPosX();
					double y = entity.getPosY();
					double z = entity.getPosZ();
					if (selected)

						WhiteLightChakraSabreToolInHandTickProcedure.executeProcedure(
								Stream.of(new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("itemstack", itemstack))
										.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				}
			}.setRegistryName("white_light_chakra_sabre"));
		}
	}
}
