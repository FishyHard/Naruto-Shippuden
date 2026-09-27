package net.mcreator.narutoshippudenmod.item;

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
import net.minecraft.block.BlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
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

public final class ReleaseTechniqueItems {
	private ReleaseTechniqueItems() {
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class BoilReleaseTechniqueItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:boil_release_technique")
		public static final Item block = null;

		public BoilReleaseTechniqueItem(NarutoShippudenModElements instance) {
			super(instance, 1068);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(new Item.Properties().group(ReleaseTechniqueItemGroup.tab).maxStackSize(1).rarity(Rarity.COMMON));
				setRegistryName("boil_release_technique");
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
				list.add(new StringTextComponent("\u00A72Skilled Mist Technique: \u00A7bChakra cost: 500 \u00A73Ninjutsu required: 25"));
				list.add(new StringTextComponent("\u00A72Steam Dash: \u00A7bChakra cost: 350 \u00A73Ninjutsu required: 30"));
				list.add(new StringTextComponent("\u00A72Unrivalled Strength: \u00A7bChakra cost: 400 \u00A73Ninjutsu required: 35"));
			}

			@Override
			public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
				ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
				ItemStack itemstack = ar.getResult();
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();

				BoilReleaseTechniqueRightclickedProcedure.executeProcedure(Stream
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

				BoilReleaseTechniqueLivingEntityIsHitWithItemProcedure.executeProcedure(
						Stream.of(new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("sourceentity", sourceentity))
								.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return retval;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class BoneReleaseTechniqueItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:bone_release_technique")
		public static final Item block = null;

		public BoneReleaseTechniqueItem(NarutoShippudenModElements instance) {
			super(instance, 952);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(new Item.Properties().group(ReleaseTechniqueItemGroup.tab).maxStackSize(1).rarity(Rarity.COMMON));
				setRegistryName("bone_release_technique");
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
				list.add(new StringTextComponent("\u00A72Dance of the Camellia: \u00A7bChakra cost: 200 \u00A73Ninjutsu required: 20"));
				list.add(new StringTextComponent("\u00A72Dance of the Clematis Flower: \u00A7bChakra cost: 350 \u00A73Ninjutsu required: 25"));
				list.add(new StringTextComponent("\u00A72Dance of the Larch: \u00A7bChakra cost: 80/sec \u00A73Ninjutsu required: 30"));
			}

			@Override
			public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
				ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
				ItemStack itemstack = ar.getResult();
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();

				BoneReleaseTechniqueRightclickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class CustomEarthReleaseTechniqueItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:custom_earth_release_technique")
		public static final Item block = null;

		public CustomEarthReleaseTechniqueItem(NarutoShippudenModElements instance) {
			super(instance, 516);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(new Item.Properties().group(null).maxStackSize(1).rarity(Rarity.COMMON));
				setRegistryName("custom_earth_release_technique");
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
				list.add(new StringTextComponent("Shift Right-Click to show info about jutsu."));
			}

			@Override
			public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
				ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
				ItemStack itemstack = ar.getResult();
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();

				CustomEarthReleaseTechniqueRightClickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class CustomFireReleaseTechniqueItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:custom_fire_release_technique")
		public static final Item block = null;

		public CustomFireReleaseTechniqueItem(NarutoShippudenModElements instance) {
			super(instance, 493);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(new Item.Properties().group(null).maxStackSize(1).rarity(Rarity.COMMON));
				setRegistryName("custom_fire_release_technique");
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
				list.add(new StringTextComponent("Shift Right-Click to show info about jutsu."));
			}

			@Override
			public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
				ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
				ItemStack itemstack = ar.getResult();
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();

				CustomFireReleaseTechniqueRightclickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class CustomLightningReleaseTechniqueItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:custom_lightning_release_technique")
		public static final Item block = null;

		public CustomLightningReleaseTechniqueItem(NarutoShippudenModElements instance) {
			super(instance, 510);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(new Item.Properties().group(null).maxStackSize(1).rarity(Rarity.COMMON));
				setRegistryName("custom_lightning_release_technique");
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
				list.add(new StringTextComponent("Shift Right-Click to show info about jutsu."));
			}

			@Override
			public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
				ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
				ItemStack itemstack = ar.getResult();
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();

				CustomLightningReleaseTechniqueRightClickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class CustomWaterReleaseTechniqueItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:custom_water_release_technique")
		public static final Item block = null;

		public CustomWaterReleaseTechniqueItem(NarutoShippudenModElements instance) {
			super(instance, 514);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(new Item.Properties().group(null).maxStackSize(1).rarity(Rarity.COMMON));
				setRegistryName("custom_water_release_technique");
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
				list.add(new StringTextComponent("Shift Right-Click to show info about jutsu."));
			}

			@Override
			public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
				ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
				ItemStack itemstack = ar.getResult();
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();

				CustomWaterReleaseTechniqueRightClickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class CustomWindReleaseTechniqueItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:custom_wind_release_technique")
		public static final Item block = null;

		public CustomWindReleaseTechniqueItem(NarutoShippudenModElements instance) {
			super(instance, 512);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(new Item.Properties().group(null).maxStackSize(1).rarity(Rarity.COMMON));
				setRegistryName("custom_wind_release_technique");
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
				list.add(new StringTextComponent("Shift Right-Click to show info about jutsu."));
			}

			@Override
			public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
				ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
				ItemStack itemstack = ar.getResult();
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();

				CustomWindReleaseTechniqueRightClickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class DustReleaseTechniqueItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:dust_release_technique")
		public static final Item block = null;

		public DustReleaseTechniqueItem(NarutoShippudenModElements instance) {
			super(instance, 1079);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(new Item.Properties().group(ReleaseTechniqueItemGroup.tab).maxStackSize(1).rarity(Rarity.COMMON));
				setRegistryName("dust_release_technique");
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
						"\u00A72Detachment of the Primitive World Technique: \u00A7bChakra cost: 5000 \u00A73Ninjutsu required: 70"));
			}

			@Override
			public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
				ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
				ItemStack itemstack = ar.getResult();
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();

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
		@ObjectHolder("naruto_shippuden:earth_release_technique")
		public static final Item block = null;

		public EarthReleaseTechniqueItem(NarutoShippudenModElements instance) {
			super(instance, 13);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(new Item.Properties().group(ReleaseTechniqueItemGroup.tab).maxStackSize(1).rarity(Rarity.COMMON));
				setRegistryName("earth_release_technique");
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
				list.add(new StringTextComponent("\u00A72Fist Rock Technique: \u00A7bChakra cost: 100 \u00A73Ninjutsu required: 5"));
				list.add(new StringTextComponent("\u00A72Golem Technique: \u00A7bChakra cost: 150 \u00A73Ninjutsu required: 10"));
				list.add(new StringTextComponent("\u00A72Earth-Style Wall: \u00A7bChakra cost: 200 \u00A73Ninjutsu required: 15"));
				list.add(new StringTextComponent("\u00A72Earth Spear: \u00A7bChakra cost: 250 \u00A73Ninjutsu required: 20"));
			}

			@Override
			public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
				ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
				ItemStack itemstack = ar.getResult();
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();

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
		@ObjectHolder("naruto_shippuden:fire_release_technique")
		public static final Item block = null;

		public FireReleaseTechniqueItem(NarutoShippudenModElements instance) {
			super(instance, 11);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(new Item.Properties().group(ReleaseTechniqueItemGroup.tab).maxStackSize(1).rarity(Rarity.COMMON));
				setRegistryName("fire_release_technique");
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
				list.add(new StringTextComponent("\u00A72Running Fire: \u00A7bChakra cost: 100 \u00A73Ninjutsu required: 5"));
				list.add(new StringTextComponent("\u00A72Great Fireball Technique: \u00A7bChakra cost: 150 \u00A73Ninjutsu required: 10"));
				list.add(new StringTextComponent("\u00A72Great Dragon Fire Technique: \u00A7bChakra cost: 200 \u00A73Ninjutsu required: 15"));
				list.add(new StringTextComponent("\u00A72Phoenix Flower Jutsu: \u00A7bChakra cost: 250 \u00A73Ninjutsu required: 20"));
			}

			@Override
			public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
				ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
				ItemStack itemstack = ar.getResult();
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();

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
		@ObjectHolder("naruto_shippuden:ice_release_technique")
		public static final Item block = null;

		public IceReleaseTechniqueItem(NarutoShippudenModElements instance) {
			super(instance, 807);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(new Item.Properties().group(ReleaseTechniqueItemGroup.tab).maxStackSize(1).rarity(Rarity.COMMON));
				setRegistryName("ice_release_technique");
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
				list.add(new StringTextComponent("\u00A72Certain-Kill Ice Spears: \u00A7bChakra cost: 300 \u00A73Ninjutsu required: 20"));
				list.add(new StringTextComponent("\u00A72Demonic Mirroring Ice Crystals: \u00A7bChakra cost: 500 \u00A73Ninjutsu required: 30"));
				list.add(new StringTextComponent("\u00A72Black Dragon Blizzard: \u00A7bChakra cost: 750 \u00A73Ninjutsu required: 35"));
			}

			@Override
			public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
				ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
				ItemStack itemstack = ar.getResult();
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();

				IceReleaseTechniqueRightclickedProcedure
						.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("entity", entity))
								.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class LightningReleaseTechniqueItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:lightning_release_technique")
		public static final Item block = null;

		public LightningReleaseTechniqueItem(NarutoShippudenModElements instance) {
			super(instance, 15);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(new Item.Properties().group(ReleaseTechniqueItemGroup.tab).maxStackSize(1).rarity(Rarity.COMMON));
				setRegistryName("lightning_release_technique");
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
				list.add(new StringTextComponent("\u00A72Lightning Ball Technique: \u00A7bChakra cost: 100 \u00A73Ninjutsu required: 5"));
				list.add(new StringTextComponent("\u00A72Chidori Senbon: \u00A7bChakra cost: 150 \u00A73Ninjutsu required: 10"));
				list.add(new StringTextComponent("\u00A72Lariat: \u00A7bChakra cost: 200 \u00A73Ninjutsu required: 15"));
				list.add(new StringTextComponent("\u00A72Kirin: \u00A7bChakra cost: 250 \u00A73Ninjutsu required: 20"));
			}

			@Override
			public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
				ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
				ItemStack itemstack = ar.getResult();
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();

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
		@ObjectHolder("naruto_shippuden:magnet_release_technique")
		public static final Item block = null;

		public MagnetReleaseTechniqueItem(NarutoShippudenModElements instance) {
			super(instance, 554);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(new Item.Properties().group(ReleaseTechniqueItemGroup.tab).maxStackSize(1).rarity(Rarity.COMMON));
				setRegistryName("magnet_release_technique");
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
				list.add(new StringTextComponent("\u00A72Iron Sand Coat: \u00A7bChakra cost: 100/sec \u00A73Ninjutsu required: 25"));
				list.add(new StringTextComponent("\u00A72Iron Sand Drizzle: \u00A7bChakra cost: 500 \u00A73Ninjutsu required: 30"));
				list.add(new StringTextComponent("\u00A72Black Iron Fist: \u00A7bChakra cost: 140/sec \u00A73Ninjutsu required: 35"));
				list.add(new StringTextComponent("\u00A72Iron Sand: Black Iron Wings: \u00A7bChakra cost: 120/sec \u00A73Ninjutsu required: 40"));
			}

			@Override
			public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
				ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
				ItemStack itemstack = ar.getResult();
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();

				MagnetReleaseTechniqueRightclickedProcedure
						.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("entity", entity))
								.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class SmokeReleaseTechniqueItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:smoke_release_technique")
		public static final Item block = null;

		public SmokeReleaseTechniqueItem(NarutoShippudenModElements instance) {
			super(instance, 461);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(new Item.Properties().group(ReleaseTechniqueItemGroup.tab).maxStackSize(1).rarity(Rarity.COMMON));
				setRegistryName("smoke_release_technique");
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
				list.add(new StringTextComponent("\u00A72Smoke Form: \u00A7bChakra cost: 80/sec \u00A73Ninjutsu required: 20"));
				list.add(new StringTextComponent("\u00A72Smoke Fist: \u00A7bChakra cost: 750 \u00A73Ninjutsu required: 35"));
				list.add(new StringTextComponent("\u00A72Smoke Gun: \u00A7bChakra cost: 1000 \u00A73Ninjutsu required: 50"));
			}

			@Override
			public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
				ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
				ItemStack itemstack = ar.getResult();
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();

				SmokeReleaseTechniqueRightclickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
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

				SmokeReleaseTechniqueLivingEntityIsHitWithItemProcedure.executeProcedure(
						Stream.of(new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("sourceentity", sourceentity))
								.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return retval;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class SteelReleaseTechniqueItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:steel_release_technique")
		public static final Item block = null;

		public SteelReleaseTechniqueItem(NarutoShippudenModElements instance) {
			super(instance, 1083);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(new Item.Properties().group(ReleaseTechniqueItemGroup.tab).maxStackSize(1).rarity(Rarity.COMMON));
				setRegistryName("steel_release_technique");
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
				list.add(new StringTextComponent("\u00A72Impervious Armour: \u00A7bChakra cost: 140/sec \u00A73Ninjutsu required: 20"));
				list.add(new StringTextComponent("\u00A72Steel Projectile: \u00A7bChakra cost: 450 \u00A73Ninjutsu required: 25"));
			}

			@Override
			public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
				ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
				ItemStack itemstack = ar.getResult();
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();

				SteelReleaseTechniqueRightclickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class StormReleaseTechniqueItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:storm_release_technique")
		public static final Item block = null;

		public StormReleaseTechniqueItem(NarutoShippudenModElements instance) {
			super(instance, 744);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(new Item.Properties().group(ReleaseTechniqueItemGroup.tab).maxStackSize(1).rarity(Rarity.COMMON));
				setRegistryName("storm_release_technique");
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
				list.add(new StringTextComponent("\u00A72Laser Circus: \u00A7bChakra cost: 30/sec \u00A73Ninjutsu required: 25"));
				list.add(new StringTextComponent("\u00A72Thunder Cloud Inner Wave: \u00A7bChakra cost: 500 \u00A73Ninjutsu required: 30"));
			}

			@Override
			public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
				ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
				ItemStack itemstack = ar.getResult();
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();

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
		@ObjectHolder("naruto_shippuden:swift_release_technique")
		public static final Item block = null;

		public SwiftReleaseTechniqueItem(NarutoShippudenModElements instance) {
			super(instance, 1064);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(new Item.Properties().group(ReleaseTechniqueItemGroup.tab).maxStackSize(1).rarity(Rarity.COMMON));
				setRegistryName("swift_release_technique");
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
						"\u00A72Shadowless Flight: \u00A7bChakra cost: 80/sec \u00A73Ninjutsu required: 30 \u00A7aTaijutsu required: 20"));
			}

			@Override
			public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
				ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
				ItemStack itemstack = ar.getResult();
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();

				SwiftReleaseTechniqueRightclickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class TyphoonReleaseTechniqueItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:typhoon_release_technique")
		public static final Item block = null;

		public TyphoonReleaseTechniqueItem(NarutoShippudenModElements instance) {
			super(instance, 1053);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(new Item.Properties().group(ReleaseTechniqueItemGroup.tab).maxStackSize(1).rarity(Rarity.COMMON));
				setRegistryName("typhoon_release_technique");
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
				list.add(new StringTextComponent("\u00A72Great Consecutive Bursting Strong Winds: \u00A7bChakra cost: 300 \u00A73Ninjutsu required: 20"));
				list.add(
						new StringTextComponent("\u00A72Great Consecutive Bursting Extreme Winds: \u00A7bChakra cost: 450 \u00A73Ninjutsu required: 25"));
			}

			@Override
			public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
				ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
				ItemStack itemstack = ar.getResult();
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();

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
		@ObjectHolder("naruto_shippuden:water_release_technique")
		public static final Item block = null;

		public WaterReleaseTechniqueItem(NarutoShippudenModElements instance) {
			super(instance, 12);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(new Item.Properties().group(ReleaseTechniqueItemGroup.tab).maxStackSize(1).rarity(Rarity.COMMON));
				setRegistryName("water_release_technique");
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
				list.add(new StringTextComponent("\u00A72Water Formation Wall: \u00A7bChakra cost: 100 \u00A73Ninjutsu required: 5"));
				list.add(new StringTextComponent("\u00A72Water Gun: \u00A7bChakra cost: 150 \u00A73Ninjutsu required: 10"));
				list.add(new StringTextComponent("\u00A72Water Shark Bullet Technique: \u00A7bChakra cost: 200 \u00A73Ninjutsu required: 15"));
				list.add(new StringTextComponent("\u00A72Water Dragon Bullet Technique: \u00A7bChakra cost: 250 \u00A73Ninjutsu required: 20"));
			}

			@Override
			public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
				ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
				ItemStack itemstack = ar.getResult();
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();

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
		@ObjectHolder("naruto_shippuden:wind_release_technique")
		public static final Item block = null;

		public WindReleaseTechniqueItem(NarutoShippudenModElements instance) {
			super(instance, 14);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(new Item.Properties().group(ReleaseTechniqueItemGroup.tab).maxStackSize(1).rarity(Rarity.COMMON));
				setRegistryName("wind_release_technique");
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
				list.add(new StringTextComponent("\u00A72Boruto Stream: \u00A7bChakra cost: 100 \u00A73Ninjutsu required: 5"));
				list.add(new StringTextComponent("\u00A72Vacuum Sphere: \u00A7bChakra cost: 150 \u00A73Ninjutsu required: 10"));
				list.add(new StringTextComponent("\u00A72Wind Mode: \u00A7bChakra cost: 20/sec \u00A73Ninjutsu required: 15"));
				list.add(new StringTextComponent("\u00A72Rasenshuriken: \u00A7bChakra cost: 250 \u00A73Ninjutsu required: 20"));
			}

			@Override
			public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
				ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
				ItemStack itemstack = ar.getResult();
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();

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
		@ObjectHolder("naruto_shippuden:wood_release_technique")
		public static final Item block = null;

		public WoodReleaseTechniqueItem(NarutoShippudenModElements instance) {
			super(instance, 786);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(new Item.Properties().group(ReleaseTechniqueItemGroup.tab).maxStackSize(1).rarity(Rarity.COMMON));
				setRegistryName("wood_release_technique");
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
				list.add(new StringTextComponent("\u00A72Wood Dragon Technique: \u00A7bChakra cost: 300 \u00A73Ninjutsu required: 25"));
				list.add(new StringTextComponent("\u00A72Tree Bind Flourishing Burial: \u00A7bChakra cost: 500 \u00A73Ninjutsu required: 30"));
				list.add(new StringTextComponent("\u00A72Wood Human Technique: \u00A7bChakra cost: 650 \u00A73Ninjutsu required: 35"));
			}

			@Override
			public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
				ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
				ItemStack itemstack = ar.getResult();
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();

				WoodReleaseTechniqueRightclickedProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z), new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}
}
