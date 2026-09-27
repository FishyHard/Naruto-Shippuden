package net.mcreator.narutoshippudenmod.item;

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

public final class ReleaseItems {
	private ReleaseItems() {
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class BoilReleaseItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:boil_release")
		public static final Item block = null;

		public BoilReleaseItem(NarutoShippudenModElements instance) {
			super(instance, 1065);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(new Item.Properties().group(ReleasesItemGroup.tab).maxStackSize(1).rarity(Rarity.EPIC));
				setRegistryName("boil_release");
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
				list.add(new StringTextComponent("\u00A76Learn Boil Release: Skilled Mist Technique \u00A74Cost: 20 JP"));
				list.add(new StringTextComponent("\u00A76Learn Boil Release: Steam Dash \u00A74Cost: 25 JP"));
				list.add(new StringTextComponent("\u00A76Learn Boil Release: Unrivalled Strength \u00A74Cost: 30 JP"));
			}

			@Override
			public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
				ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
				ItemStack itemstack = ar.getResult();
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();

				BoilReleaseRightClickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class BoneReleaseItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:bone_release")
		public static final Item block = null;

		public BoneReleaseItem(NarutoShippudenModElements instance) {
			super(instance, 951);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(new Item.Properties().group(ReleasesItemGroup.tab).maxStackSize(1).rarity(Rarity.EPIC));
				setRegistryName("bone_release");
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
				list.add(new StringTextComponent("\u00A76Learn Bone Release: Dance of the Camellia \u00A74Cost: 15 JP"));
				list.add(new StringTextComponent("\u00A76Learn Bone Release: Dance of the Clematis: Flower \u00A74Cost: 20 JP"));
				list.add(new StringTextComponent("\u00A76Learn Bone Release: Dance of the Larch \u00A74Cost: 25 JP"));
			}

			@Override
			public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
				ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
				ItemStack itemstack = ar.getResult();
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();

				BoneReleaseRightclickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class ChakraNatureResetItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:chakra_nature_reset")
		public static final Item block = null;

		public ChakraNatureResetItem(NarutoShippudenModElements instance) {
			super(instance, 1025);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(new Item.Properties().group(ReleasesItemGroup.tab).maxStackSize(1).rarity(Rarity.EPIC));
				setRegistryName("chakra_nature_reset");
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
				list.add(new StringTextComponent("Right-Click to reset your chakra natures"));
			}

			@Override
			public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
				ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
				ItemStack itemstack = ar.getResult();
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();

				ChakraNatureResetRightclickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class DustReleaseItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:dust_release")
		public static final Item block = null;

		public DustReleaseItem(NarutoShippudenModElements instance) {
			super(instance, 1078);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(new Item.Properties().group(ReleasesItemGroup.tab).maxStackSize(1).rarity(Rarity.EPIC));
				setRegistryName("dust_release");
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
				list.add(new StringTextComponent("\u00A76Learn Dust Release: Detachment of the Primitive World Technique \u00A74Cost: 100 JP"));
			}

			@Override
			public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
				ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
				ItemStack itemstack = ar.getResult();
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();

				DustReleaseRightClickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class EarthReleaseItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:earth_release")
		public static final Item block = null;

		public EarthReleaseItem(NarutoShippudenModElements instance) {
			super(instance, 9);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(new Item.Properties().group(ReleasesItemGroup.tab).maxStackSize(1).rarity(Rarity.EPIC));
				setRegistryName("earth_release");
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
				list.add(new StringTextComponent("\u00A76Learn Earth Release: Fist Rock Technique \u00A74Cost: 5 JP"));
				list.add(new StringTextComponent("\u00A76Learn Earth Release: Golem Technique \u00A74Cost: 10 JP"));
				list.add(new StringTextComponent("\u00A76Learn Earth Release: Earth-Style Wall \u00A74Cost: 15 JP"));
				list.add(new StringTextComponent("\u00A76Learn Earth Release: Earth Spear \u00A74Cost: 20 JP"));
			}

			@Override
			public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
				ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
				ItemStack itemstack = ar.getResult();
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();

				EarthReleaseRightClickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class FireReleaseItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:fire_release")
		public static final Item block = null;

		public FireReleaseItem(NarutoShippudenModElements instance) {
			super(instance, 5);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(new Item.Properties().group(ReleasesItemGroup.tab).maxStackSize(1).rarity(Rarity.EPIC));
				setRegistryName("fire_release");
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
				list.add(new StringTextComponent("\u00A76Learn Fire Release: Running Fire \u00A74Cost: 5 JP"));
				list.add(new StringTextComponent("\u00A76Learn Fire Release: Great Fireball Technique \u00A74Cost: 10 JP"));
				list.add(new StringTextComponent("\u00A76Learn Fire Release: Great Dragon Fire Technique \u00A74Cost: 15 JP"));
				list.add(new StringTextComponent("\u00A76Learn Fire Release: Phoenix Flower Jutsu \u00A74Cost: 20 JP"));
			}

			@Override
			public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
				ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
				ItemStack itemstack = ar.getResult();
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();

				FireReleaseRightclickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class IceReleaseItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:ice_release")
		public static final Item block = null;

		public IceReleaseItem(NarutoShippudenModElements instance) {
			super(instance, 806);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(new Item.Properties().group(ReleasesItemGroup.tab).maxStackSize(1).rarity(Rarity.EPIC));
				setRegistryName("ice_release");
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
				list.add(new StringTextComponent("\u00A76Learn Ice Release: Certain-Kill Ice Spears \u00A74Cost: 15 JP"));
				list.add(new StringTextComponent("\u00A76Learn Ice Release: Demonic Mirroring Ice Crystals \u00A74Cost: 20 JP"));
				list.add(new StringTextComponent("\u00A76Learn Ice Release: Black Dragon Blizzard \u00A74Cost: 25 JP"));
			}

			@Override
			public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
				ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
				ItemStack itemstack = ar.getResult();
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();

				IceReleaseRightclickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class LightningReleaseItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:lightning_release")
		public static final Item block = null;

		public LightningReleaseItem(NarutoShippudenModElements instance) {
			super(instance, 10);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(new Item.Properties().group(ReleasesItemGroup.tab).maxStackSize(1).rarity(Rarity.EPIC));
				setRegistryName("lightning_release");
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
				list.add(new StringTextComponent("\u00A76Learn Lightning Release: Lightning Ball Technique \u00A74Cost: 5 JP"));
				list.add(new StringTextComponent("\u00A76Learn Lightning Release: Chidori Senbon \u00A74Cost: 10 JP"));
				list.add(new StringTextComponent("\u00A76Learn Lightning Release: Lariat \u00A74Cost: 15 JP"));
				list.add(new StringTextComponent("\u00A76Learn Lightning Release: Kirin \u00A74Cost: 20 JP"));
			}

			@Override
			public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
				ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
				ItemStack itemstack = ar.getResult();
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();

				LightningReleaseRightClickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class MagnetReleaseItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:magnet_release")
		public static final Item block = null;

		public MagnetReleaseItem(NarutoShippudenModElements instance) {
			super(instance, 553);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(new Item.Properties().group(ReleasesItemGroup.tab).maxStackSize(1).rarity(Rarity.EPIC));
				setRegistryName("magnet_release");
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
				list.add(new StringTextComponent("\u00A76Learn Magnet Release: Iron Sand Coat \u00A74Cost: 25 JP"));
				list.add(new StringTextComponent("\u00A76Learn Magnet Release: Iron Sand Drizzle \u00A74Cost: 30 JP"));
				list.add(new StringTextComponent("\u00A76Learn Magnet Release: Black Iron Fist \u00A74Cost: 35 JP"));
				list.add(new StringTextComponent("\u00A76Learn Magnet Release: Iron Sand: Black Iron Wings \u00A74Cost: 40 JP"));
			}

			@Override
			public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
				ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
				ItemStack itemstack = ar.getResult();
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();

				MagnetReleaseRightclickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class SmokeReleaseItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:smoke_release")
		public static final Item block = null;

		public SmokeReleaseItem(NarutoShippudenModElements instance) {
			super(instance, 459);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(new Item.Properties().group(ReleasesItemGroup.tab).maxStackSize(1).rarity(Rarity.EPIC));
				setRegistryName("smoke_release");
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
				list.add(new StringTextComponent("\u00A76Learn Smoke Release: Smoke Form \u00A74Cost: 25 JP"));
				list.add(new StringTextComponent("\u00A76Learn Smoke Release: Smoke Fist \u00A74Cost: 30 JP"));
				list.add(new StringTextComponent("\u00A76Learn Smoke Release: Smoke Gun \u00A74Cost: 35 JP"));
			}

			@Override
			public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
				ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
				ItemStack itemstack = ar.getResult();
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();

				SmokeReleaseRightclickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class SteelReleaseItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:steel_release")
		public static final Item block = null;

		public SteelReleaseItem(NarutoShippudenModElements instance) {
			super(instance, 1082);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(new Item.Properties().group(ReleasesItemGroup.tab).maxStackSize(1).rarity(Rarity.EPIC));
				setRegistryName("steel_release");
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
				list.add(new StringTextComponent("\u00A76Learn Steel Release: Impervious Armour \u00A74Cost: 25 JP"));
				list.add(new StringTextComponent("\u00A76Learn Steel Release: Steel Projectile \u00A74Cost: 30 JP"));
			}

			@Override
			public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
				ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
				ItemStack itemstack = ar.getResult();
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();

				SteelReleaseRightClickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class StormReleaseItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:storm_release")
		public static final Item block = null;

		public StormReleaseItem(NarutoShippudenModElements instance) {
			super(instance, 743);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(new Item.Properties().group(ReleasesItemGroup.tab).maxStackSize(1).rarity(Rarity.EPIC));
				setRegistryName("storm_release");
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
				list.add(new StringTextComponent("\u00A76Learn Storm Release: Laser Circus \u00A74Cost: 25 JP"));
				list.add(new StringTextComponent("\u00A76Learn Storm Release: Thunder Cloud Inner Wave \u00A74Cost: 30 JP"));
			}

			@Override
			public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
				ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
				ItemStack itemstack = ar.getResult();
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();

				StormReleaseRightclickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class SwiftReleaseItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:swift_release")
		public static final Item block = null;

		public SwiftReleaseItem(NarutoShippudenModElements instance) {
			super(instance, 1063);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(new Item.Properties().group(ReleasesItemGroup.tab).maxStackSize(1).rarity(Rarity.EPIC));
				setRegistryName("swift_release");
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
				list.add(new StringTextComponent("\u00A76Learn Swift Release: Shadowless Flight \u00A74Cost: 35 JP"));
			}

			@Override
			public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
				ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
				ItemStack itemstack = ar.getResult();
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();

				SwiftReleaseRightClickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class TyphoonReleaseItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:typhoon_release")
		public static final Item block = null;

		public TyphoonReleaseItem(NarutoShippudenModElements instance) {
			super(instance, 1052);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(new Item.Properties().group(ReleasesItemGroup.tab).maxStackSize(1).rarity(Rarity.EPIC));
				setRegistryName("typhoon_release");
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
				list.add(new StringTextComponent("\u00A76Learn Typhoon Release: Great Consecutive Bursting Strong Winds \u00A74Cost: 25 JP"));
				list.add(new StringTextComponent(
						"\u00A76Learn Typhoon Release: Typhoon Release: Great Consecutive Bursting Extreme Winds \u00A74Cost: 30 JP"));
			}

			@Override
			public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
				ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
				ItemStack itemstack = ar.getResult();
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();

				TyphoonReleaseRightClickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class WaterReleaseItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:water_release")
		public static final Item block = null;

		public WaterReleaseItem(NarutoShippudenModElements instance) {
			super(instance, 8);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(new Item.Properties().group(ReleasesItemGroup.tab).maxStackSize(1).rarity(Rarity.EPIC));
				setRegistryName("water_release");
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
				list.add(new StringTextComponent("\u00A76Learn Water Release: Water Formation Wall \u00A74Cost: 5 JP"));
				list.add(new StringTextComponent("\u00A76Learn Water Release: Water Gun \u00A74Cost: 10 JP"));
				list.add(new StringTextComponent("\u00A76Learn Water Release: Water Shark Bullet Technique \u00A74Cost: 15 JP"));
				list.add(new StringTextComponent("\u00A76Learn Water Release: Water Dragon \u00A74Cost: 20 JP"));
			}

			@Override
			public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
				ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
				ItemStack itemstack = ar.getResult();
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();

				WaterReleaseRightClickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class WindReleaseItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:wind_release")
		public static final Item block = null;

		public WindReleaseItem(NarutoShippudenModElements instance) {
			super(instance, 7);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(new Item.Properties().group(ReleasesItemGroup.tab).maxStackSize(1).rarity(Rarity.EPIC));
				setRegistryName("wind_release");
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
				list.add(new StringTextComponent("\u00A76Learn Wind Release: Boruto Stream \u00A74Cost: 5 JP"));
				list.add(new StringTextComponent("\u00A76Learn Wind Release: Vacuum Sphere \u00A74Cost: 10 JP"));
				list.add(new StringTextComponent("\u00A76Learn Wind Release: Wind Mode \u00A74Cost: 15 JP"));
				list.add(new StringTextComponent("\u00A76Learn Wind Release: Rasenshuriken \u00A74Cost: 20 JP"));
			}

			@Override
			public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
				ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
				ItemStack itemstack = ar.getResult();
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();

				WindReleaseRightclickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class WoodReleaseItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:wood_release")
		public static final Item block = null;

		public WoodReleaseItem(NarutoShippudenModElements instance) {
			super(instance, 785);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(new Item.Properties().group(ReleasesItemGroup.tab).maxStackSize(1).rarity(Rarity.EPIC));
				setRegistryName("wood_release");
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
				list.add(new StringTextComponent("\u00A76Learn Wood Release: Wood Dragon Technique \u00A74Cost: 20 JP"));
				list.add(new StringTextComponent("\u00A76Learn Wood Release: Tree Bind Flourishing Burial \u00A74Cost: 25 JP"));
				list.add(new StringTextComponent("\u00A76Learn Wood Release: Wood Human Technique \u00A74Cost: 30 JP"));
			}

			@Override
			public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
				ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
				ItemStack itemstack = ar.getResult();
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();

				WoodReleaseRightclickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}
}
