package net.mcreator.narutoshippudenmod.item;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Stream;
import net.mcreator.narutoshippudenmod.NarutoShippudenModElements;
import net.mcreator.narutoshippudenmod.entity.renderer.ProjectileRenderers.FumaShurikenClanRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.ProjectileRenderers.ShurikenClanRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.ProjectileRenderers.ToroiUniqueFumaShurikenClanRenderer;
import net.mcreator.narutoshippudenmod.item.WeaponItems.FumaShurikenItem;
import net.mcreator.narutoshippudenmod.item.WeaponItems.ToroiUniqueFumaShurikenItem;
import net.mcreator.narutoshippudenmod.itemgroup.ModItemGroups.ClansItemGroup;
import net.mcreator.narutoshippudenmod.procedures.ClanProcedures.AburameReleaseRightclickProcedure;
import net.mcreator.narutoshippudenmod.procedures.ClanProcedures.AkimichiReleaseRightclickProcedure;
import net.mcreator.narutoshippudenmod.procedures.ClanProcedures.ClanResetRightclickedProcedure;
import net.mcreator.narutoshippudenmod.procedures.ClanProcedures.DanceOfTheCamelliaLivingEntityIsHitWithItemProcedure;
import net.mcreator.narutoshippudenmod.procedures.ClanProcedures.DanceOfTheClematisFlowerLivingEntityIsHitWithItemProcedure;
import net.mcreator.narutoshippudenmod.procedures.ClanProcedures.EightTrigramsTwinLionsCrumblingAttackLivingEntityIsHitWithItemProcedure;
import net.mcreator.narutoshippudenmod.procedures.ClanProcedures.FumaReleaseRightclickProcedure;
import net.mcreator.narutoshippudenmod.procedures.ClanProcedures.GentleStepTwinLionFistsLivingEntityIsHitWithItemProcedure;
import net.mcreator.narutoshippudenmod.procedures.ClanProcedures.HatakeReleaseRightclickedProcedure;
import net.mcreator.narutoshippudenmod.procedures.ClanProcedures.HoshigakiReleaseRightclickedProcedure;
import net.mcreator.narutoshippudenmod.procedures.ClanProcedures.HozukiReleaseRightclickProcedure;
import net.mcreator.narutoshippudenmod.procedures.ClanProcedures.HyugaReleaseRightclickedProcedure;
import net.mcreator.narutoshippudenmod.procedures.ClanProcedures.IburiReleaseRightclickedProcedure;
import net.mcreator.narutoshippudenmod.procedures.ClanProcedures.InuzukaReleaseRightclickedProcedure;
import net.mcreator.narutoshippudenmod.procedures.ClanProcedures.IzunoReleaseRightclickedProcedure;
import net.mcreator.narutoshippudenmod.procedures.ClanProcedures.KaguyaReleaseRightclickedProcedure;
import net.mcreator.narutoshippudenmod.procedures.ClanProcedures.KazekageReleaseRightclickedProcedure;
import net.mcreator.narutoshippudenmod.procedures.ClanProcedures.LeeReleaseRightclickedProcedure;
import net.mcreator.narutoshippudenmod.procedures.ClanProcedures.NamikazeReleaseRightclickedProcedure;
import net.mcreator.narutoshippudenmod.procedures.ClanProcedures.OtsutsukiReleaseRightclickedProcedure;
import net.mcreator.narutoshippudenmod.procedures.ClanProcedures.SarutobiReleaseRightclickProcedure;
import net.mcreator.narutoshippudenmod.procedures.ClanProcedures.SenjuReleaseRightclickedProcedure;
import net.mcreator.narutoshippudenmod.procedures.ClanProcedures.TenroReleaseRightclickedProcedure;
import net.mcreator.narutoshippudenmod.procedures.ClanProcedures.TsuchigumoReleaseRightclickProcedure;
import net.mcreator.narutoshippudenmod.procedures.ClanProcedures.UzumakiReleaseRightclickedProcedure;
import net.mcreator.narutoshippudenmod.procedures.ClanProcedures.YukiReleaseRightclickedProcedure;
import net.minecraft.block.BlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.IRendersAsItem;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.item.UseAction;
import net.minecraft.network.IPacket;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ObjectHolder;

public final class ClanItems {
	private ClanItems() {
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class AburameReleaseItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:aburame_release")
		public static final Item block = null;

		public AburameReleaseItem(NarutoShippudenModElements instance) {
			super(instance, 118);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(new Item.Properties().group(ClansItemGroup.tab).maxStackSize(1).rarity(Rarity.EPIC));
				setRegistryName("aburame_release");
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
				list.add(new StringTextComponent("\u00A76Learn Aburame Release: Poison Cloud Technique \u00A74Cost: 10 JP"));
				list.add(new StringTextComponent("\u00A76Learn Aburame Release: Insect Jar Technique  \u00A74Cost: 15 JP"));
				list.add(new StringTextComponent("\u00A76Learn Aburame Release: Insect Bog  \u00A74Cost: 20 JP"));
			}

			@Override
			public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
				ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
				ItemStack itemstack = ar.getResult();
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();

				AburameReleaseRightclickProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class AkimichiReleaseItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:akimichi_release")
		public static final Item block = null;

		public AkimichiReleaseItem(NarutoShippudenModElements instance) {
			super(instance, 119);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(new Item.Properties().group(ClansItemGroup.tab).maxStackSize(1).rarity(Rarity.EPIC));
				setRegistryName("akimichi_release");
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
				list.add(new StringTextComponent("\u00A76Learn Akimichi Release: Calorie Control \u00A74Cost: 15 JP"));
				list.add(new StringTextComponent("\u00A76Learn Akimichi Release: Human Bullet Tank \u00A74Cost: 20 JP"));
				list.add(new StringTextComponent("\u00A76Learn Akimichi Release: Spiked Human Bullet Tank \u00A74Cost: 25 JP"));
				list.add(new StringTextComponent("\u00A76Learn Akimichi Release: Butterfly Mode \u00A74Cost: 30 JP"));
			}

			@Override
			public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
				ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
				ItemStack itemstack = ar.getResult();
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();

				AkimichiReleaseRightclickProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class ChinoikeReleaseItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:chinoike_release")
		public static final Item block = null;

		public ChinoikeReleaseItem(NarutoShippudenModElements instance) {
			super(instance, 120);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(new Item.Properties().group(ClansItemGroup.tab).maxStackSize(1).rarity(Rarity.EPIC));
				setRegistryName("chinoike_release");
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
	public static class ClanResetStatItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:clan_reset_stat")
		public static final Item block = null;

		public ClanResetStatItem(NarutoShippudenModElements instance) {
			super(instance, 422);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(new Item.Properties().group(ClansItemGroup.tab).maxStackSize(1).rarity(Rarity.EPIC));
				setRegistryName("clan_reset_stat");
			}

			@Override
			public UseAction getUseAction(ItemStack itemstack) {
				return UseAction.EAT;
			}

			@Override
			public boolean hasContainerItem() {
				return true;
			}

			@Override
			public ItemStack getContainerItem(ItemStack itemstack) {
				return new ItemStack(this);
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
				list.add(new StringTextComponent("Right-Click to reset your clan"));
			}

			@Override
			public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
				ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
				ItemStack itemstack = ar.getResult();
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();

				ClanResetRightclickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class DanceOfTheCamelliaItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:dance_of_the_camellia")
		public static final Item block = null;

		public DanceOfTheCamelliaItem(NarutoShippudenModElements instance) {
			super(instance, 956);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(new Item.Properties().group(null).maxStackSize(1).rarity(Rarity.COMMON));
				setRegistryName("dance_of_the_camellia");
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
			public boolean hitEntity(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
				boolean retval = super.hitEntity(itemstack, entity, sourceentity);
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();
				World world = entity.world;

				DanceOfTheCamelliaLivingEntityIsHitWithItemProcedure.executeProcedure(
						Stream.of(new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("sourceentity", sourceentity))
								.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return retval;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class DanceOfTheClematisFlowerItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:dance_of_the_clematis_flower")
		public static final Item block = null;

		public DanceOfTheClematisFlowerItem(NarutoShippudenModElements instance) {
			super(instance, 958);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(new Item.Properties().group(null).maxStackSize(1).rarity(Rarity.COMMON));
				setRegistryName("dance_of_the_clematis_flower");
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
			public boolean hitEntity(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
				boolean retval = super.hitEntity(itemstack, entity, sourceentity);
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();
				World world = entity.world;

				DanceOfTheClematisFlowerLivingEntityIsHitWithItemProcedure.executeProcedure(
						Stream.of(new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("sourceentity", sourceentity))
								.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return retval;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class EightTrigramsTwinLionsCrumblingAttackItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:eight_trigrams_twin_lions_crumbling_attack")
		public static final Item block = null;

		public EightTrigramsTwinLionsCrumblingAttackItem(NarutoShippudenModElements instance) {
			super(instance, 456);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(new Item.Properties().group(null).maxStackSize(1).rarity(Rarity.COMMON));
				setRegistryName("eight_trigrams_twin_lions_crumbling_attack");
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
			public boolean hitEntity(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
				boolean retval = super.hitEntity(itemstack, entity, sourceentity);
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();
				World world = entity.world;

				EightTrigramsTwinLionsCrumblingAttackLivingEntityIsHitWithItemProcedure.executeProcedure(
						Stream.of(new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("sourceentity", sourceentity))
								.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return retval;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class FumaReleaseItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:fuma_release")
		public static final Item block = null;

		public FumaReleaseItem(NarutoShippudenModElements instance) {
			super(instance, 406);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(new Item.Properties().group(ClansItemGroup.tab).maxStackSize(1).rarity(Rarity.EPIC));
				setRegistryName("fuma_release");
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
				list.add(new StringTextComponent("\u00A76Learn Fuma Release: Shuriken \u00A74Cost: 10 JP"));
				list.add(new StringTextComponent("\u00A76Learn Fuma Release: Fuma Shuriken  \u00A74Cost: 15 JP"));
				list.add(new StringTextComponent("\u00A76Learn Fuma Release: Toroi Unique Fuma Shuriken \u00A74Cost: 20 JP"));
			}

			@Override
			public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
				ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
				ItemStack itemstack = ar.getResult();
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();

				FumaReleaseRightclickProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class FumaShurikenClanItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:fuma_shuriken_clan")
		public static final Item block = null;
		public static final EntityType arrow = (EntityType.Builder.<ArrowCustomEntity>create(ArrowCustomEntity::new, EntityClassification.MISC)
				.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).setCustomClientFactory(ArrowCustomEntity::new)
				.size(0.5f, 0.5f)).build("projectile_fuma_shuriken_clan").setRegistryName("projectile_fuma_shuriken_clan");

		public FumaShurikenClanItem(NarutoShippudenModElements instance) {
			super(instance, 986);
			FMLJavaModLoadingContext.get().getModEventBus().register(new FumaShurikenClanRenderer.ModelRegisterHandler());
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemRanged());
			elements.entities.add(() -> arrow);
		}

		public static class ItemRanged extends Item {
			public ItemRanged() {
				super(new Item.Properties().group(null).maxStackSize(0));
				setRegistryName("fuma_shuriken_clan");
			}

			@Override
			public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
				entity.setActiveHand(hand);
				return new ActionResult(ActionResultType.SUCCESS, entity.getHeldItem(hand));
			}

			@Override
			public UseAction getUseAction(ItemStack itemstack) {
				return UseAction.NONE;
			}

			@Override
			public int getUseDuration(ItemStack itemstack) {
				return 72000;
			}

			@Override
			public void onPlayerStoppedUsing(ItemStack itemstack, World world, LivingEntity entityLiving, int timeLeft) {
				if (!world.isRemote && entityLiving instanceof ServerPlayerEntity) {
					ServerPlayerEntity entity = (ServerPlayerEntity) entityLiving;
					double x = entity.getPosX();
					double y = entity.getPosY();
					double z = entity.getPosZ();
					if (true) {
						ArrowCustomEntity entityarrow = shoot(world, entity, random, 0f, 0, 0);
						itemstack.damageItem(1, entity, e -> e.sendBreakAnimation(entity.getActiveHand()));
						entityarrow.pickupStatus = AbstractArrowEntity.PickupStatus.DISALLOWED;
					}
				}
			}
		}

		@OnlyIn(value = Dist.CLIENT, _interface = IRendersAsItem.class)
		public static class ArrowCustomEntity extends AbstractArrowEntity implements IRendersAsItem {
			public ArrowCustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
				super(arrow, world);
			}

			public ArrowCustomEntity(EntityType<? extends ArrowCustomEntity> type, World world) {
				super(type, world);
			}

			public ArrowCustomEntity(EntityType<? extends ArrowCustomEntity> type, double x, double y, double z, World world) {
				super(type, x, y, z, world);
			}

			public ArrowCustomEntity(EntityType<? extends ArrowCustomEntity> type, LivingEntity entity, World world) {
				super(type, entity, world);
			}

			@Override
			public IPacket<?> createSpawnPacket() {
				return NetworkHooks.getEntitySpawningPacket(this);
			}

			@Override
			@OnlyIn(Dist.CLIENT)
			public ItemStack getItem() {
				return new ItemStack(FumaShurikenItem.block);
			}

			@Override
			protected ItemStack getArrowStack() {
				return ItemStack.EMPTY;
			}

			@Override
			protected void arrowHit(LivingEntity entity) {
				super.arrowHit(entity);
				entity.setArrowCountInEntity(entity.getArrowCountInEntity() - 1);
			}

			@Override
			public void tick() {
				super.tick();
				double x = this.getPosX();
				double y = this.getPosY();
				double z = this.getPosZ();
				World world = this.world;
				Entity entity = this.func_234616_v_();
				Entity immediatesourceentity = this;
				if (this.inGround)
					this.remove();
			}
		}

		public static ArrowCustomEntity shoot(World world, LivingEntity entity, Random random, float power, double damage, int knockback) {
			ArrowCustomEntity entityarrow = new ArrowCustomEntity(arrow, entity, world);
			entityarrow.shoot(entity.getLook(1).x, entity.getLook(1).y, entity.getLook(1).z, power * 2, 0);
			entityarrow.setSilent(true);
			entityarrow.setIsCritical(false);
			entityarrow.setDamage(damage);
			entityarrow.setKnockbackStrength(knockback);
			world.addEntity(entityarrow);
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			world.playSound((PlayerEntity) null, (double) x, (double) y, (double) z,
					(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("")), SoundCategory.PLAYERS, 1,
					1f / (random.nextFloat() * 0.5f + 1) + (power / 2));
			return entityarrow;
		}

		public static ArrowCustomEntity shoot(LivingEntity entity, LivingEntity target) {
			ArrowCustomEntity entityarrow = new ArrowCustomEntity(arrow, entity, entity.world);
			double d0 = target.getPosY() + (double) target.getEyeHeight() - 1.1;
			double d1 = target.getPosX() - entity.getPosX();
			double d3 = target.getPosZ() - entity.getPosZ();
			entityarrow.shoot(d1, d0 - entityarrow.getPosY() + (double) MathHelper.sqrt(d1 * d1 + d3 * d3) * 0.2F, d3, 0f * 2, 12.0F);
			entityarrow.setSilent(true);
			entityarrow.setDamage(0);
			entityarrow.setKnockbackStrength(0);
			entityarrow.setIsCritical(false);
			entity.world.addEntity(entityarrow);
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			entity.world.playSound((PlayerEntity) null, (double) x, (double) y, (double) z,
					(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("")), SoundCategory.PLAYERS, 1,
					1f / (new Random().nextFloat() * 0.5f + 1));
			return entityarrow;
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class GentleStepTwinLionFistsItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:gentle_step_twin_lion_fists")
		public static final Item block = null;

		public GentleStepTwinLionFistsItem(NarutoShippudenModElements instance) {
			super(instance, 454);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(new Item.Properties().group(null).maxStackSize(1).rarity(Rarity.COMMON));
				setRegistryName("gentle_step_twin_lion_fists");
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
			public boolean hitEntity(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
				boolean retval = super.hitEntity(itemstack, entity, sourceentity);
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();
				World world = entity.world;

				GentleStepTwinLionFistsLivingEntityIsHitWithItemProcedure.executeProcedure(
						Stream.of(new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("sourceentity", sourceentity))
								.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return retval;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class HatakeReleaseItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:hatake_release")
		public static final Item block = null;

		public HatakeReleaseItem(NarutoShippudenModElements instance) {
			super(instance, 104);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(new Item.Properties().group(ClansItemGroup.tab).maxStackSize(1).rarity(Rarity.EPIC));
				setRegistryName("hatake_release");
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
				list.add(new StringTextComponent("\u00A76Learn Hatake Release: White Light Chakra Sword \u00A74Cost: 5 JP"));
			}

			@Override
			public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
				ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
				ItemStack itemstack = ar.getResult();
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();

				HatakeReleaseRightclickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class HoshigakiReleaseItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:hoshigaki_release")
		public static final Item block = null;

		public HoshigakiReleaseItem(NarutoShippudenModElements instance) {
			super(instance, 407);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(new Item.Properties().group(ClansItemGroup.tab).maxStackSize(1).rarity(Rarity.EPIC));
				setRegistryName("hoshigaki_release");
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
				list.add(new StringTextComponent("\u00A76Learn Hoshigaki Release: Water Release"));
				list.add(new StringTextComponent("Hoshigaki Release \u00A74Cost: 5 JP"));
			}

			@Override
			public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
				ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
				ItemStack itemstack = ar.getResult();
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();

				HoshigakiReleaseRightclickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class HozukiReleaseItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:hozuki_release")
		public static final Item block = null;

		public HozukiReleaseItem(NarutoShippudenModElements instance) {
			super(instance, 408);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(new Item.Properties().group(ClansItemGroup.tab).maxStackSize(1).rarity(Rarity.EPIC));
				setRegistryName("hozuki_release");
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
				list.add(new StringTextComponent("\u00A76Learn Hozuki Release: Drowning Water Blob Technique \u00A74Cost: 10 JP"));
				list.add(new StringTextComponent("\u00A76Learn Hozuki Release: Water Gun Technique  \u00A74Cost: 15 JP"));
				list.add(new StringTextComponent("\u00A76Learn Hozuki Release: Great Water Arm Technique \u00A74Cost: 20 JP"));
			}

			@Override
			public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
				ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
				ItemStack itemstack = ar.getResult();
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();

				HozukiReleaseRightclickProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class HyugaReleaseItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:hyuga_release")
		public static final Item block = null;

		public HyugaReleaseItem(NarutoShippudenModElements instance) {
			super(instance, 103);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(new Item.Properties().group(ClansItemGroup.tab).maxStackSize(1).rarity(Rarity.EPIC));
				setRegistryName("hyuga_release");
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
				list.add(new StringTextComponent("\u00A76Learn Hyuga Release: Gentle Fist \u00A74Cost: 15 JP"));
				list.add(new StringTextComponent("\u00A76Learn Hyuga Release: Gentle Step Twin Lion Fists \u00A74Cost: 20 JP"));
				list.add(new StringTextComponent("\u00A76Learn Hyuga Release: Eight Trigrams Twin Lions Crumbling Attack \u00A74Cost: 25 JP"));
				list.add(new StringTextComponent("\u00A76Learn Hyuga Release: Eight Trigrams Palms Revolving Heaven \u00A74Cost: 30 JP"));
				list.add(new StringTextComponent("\u00A76Learn Hyuga Release: Eight Trigrams Sixty-Four Palms \u00A74Cost: 35 JP"));
			}

			@Override
			public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
				ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
				ItemStack itemstack = ar.getResult();
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();

				HyugaReleaseRightclickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class IburiReleaseItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:iburi_release")
		public static final Item block = null;

		public IburiReleaseItem(NarutoShippudenModElements instance) {
			super(instance, 105);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(new Item.Properties().group(ClansItemGroup.tab).maxStackSize(1).rarity(Rarity.EPIC));
				setRegistryName("iburi_release");
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
				list.add(new StringTextComponent("\u00A76Learn Iburi Release: Smoke Release \u00A74Cost: 5 JP"));
			}

			@Override
			public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
				ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
				ItemStack itemstack = ar.getResult();
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();

				IburiReleaseRightclickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class InuzukaReleaseItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:inuzuka_release")
		public static final Item block = null;

		public InuzukaReleaseItem(NarutoShippudenModElements instance) {
			super(instance, 106);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(new Item.Properties().group(ClansItemGroup.tab).maxStackSize(1).rarity(Rarity.EPIC));
				setRegistryName("inuzuka_release");
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
				list.add(new StringTextComponent("\u00A76Learn Inuzuka Release: Akamaru \u00A74Cost: 5 JP"));
				list.add(new StringTextComponent("\u00A76Learn Inuzuka Release: Passing Fang \u00A74Cost: 10 JP"));
				list.add(new StringTextComponent("\u00A76Learn Inuzuka Release: Double-Headed Wolf \u00A74Cost: 15 JP"));
				list.add(new StringTextComponent("\u00A76Learn Inuzuka Release: Three-Headed Wolf \u00A74Cost: 20 JP"));
			}

			@Override
			public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
				ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
				ItemStack itemstack = ar.getResult();
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();

				InuzukaReleaseRightclickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class IzunoReleaseItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:izuno_release")
		public static final Item block = null;

		public IzunoReleaseItem(NarutoShippudenModElements instance) {
			super(instance, 411);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(new Item.Properties().group(ClansItemGroup.tab).maxStackSize(1).rarity(Rarity.EPIC));
				setRegistryName("izuno_release");
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
				list.add(new StringTextComponent("\u00A76Learn Izuno Release: Cat Covering \u00A74Cost: 25 JP"));
				list.add(new StringTextComponent("\u00A76Learn Izuno Release: Monster Cat Beckoning Technique \u00A74Cost: 30 JP"));
			}

			@Override
			public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
				ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
				ItemStack itemstack = ar.getResult();
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();

				IzunoReleaseRightclickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class KaguyaReleaseItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:kaguya_release")
		public static final Item block = null;

		public KaguyaReleaseItem(NarutoShippudenModElements instance) {
			super(instance, 409);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(new Item.Properties().group(ClansItemGroup.tab).maxStackSize(1).rarity(Rarity.EPIC));
				setRegistryName("kaguya_release");
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
				list.add(new StringTextComponent("\u00A76Learn Kaguya Release: Bone Release \u00A74Cost: 5 JP"));
			}

			@Override
			public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
				ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
				ItemStack itemstack = ar.getResult();
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();

				KaguyaReleaseRightclickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class KazekageReleaseItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:kazekage_release")
		public static final Item block = null;

		public KazekageReleaseItem(NarutoShippudenModElements instance) {
			super(instance, 107);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(new Item.Properties().group(ClansItemGroup.tab).maxStackSize(1).rarity(Rarity.EPIC));
				setRegistryName("kazekage_release");
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
				list.add(new StringTextComponent("\u00A76Learn Kazekage Release: Magnet Release \u00A74Cost: 5 JP"));
			}

			@Override
			public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
				ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
				ItemStack itemstack = ar.getResult();
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();

				KazekageReleaseRightclickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class KuramaReleaseItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:kurama_release")
		public static final Item block = null;

		public KuramaReleaseItem(NarutoShippudenModElements instance) {
			super(instance, 402);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(new Item.Properties().group(ClansItemGroup.tab).maxStackSize(1).rarity(Rarity.EPIC));
				setRegistryName("kurama_release");
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
	public static class LeeReleaseItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:lee_release")
		public static final Item block = null;

		public LeeReleaseItem(NarutoShippudenModElements instance) {
			super(instance, 108);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(new Item.Properties().group(ClansItemGroup.tab).maxStackSize(1).rarity(Rarity.EPIC));
				setRegistryName("lee_release");
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
				list.add(new StringTextComponent("\u00A76Learn Lee Release: Drunken Fist \u00A74Cost: 10 JP"));
				list.add(new StringTextComponent("\u00A76Learn Lee Release: Gate of Opening \u00A74Cost: 20 JP"));
				list.add(new StringTextComponent("\u00A76Learn Lee Release: Gate of Healing \u00A74Cost: 25 JP"));
				list.add(new StringTextComponent("\u00A76Learn Lee Release: Gate of Life \u00A74Cost: 30 JP"));
				list.add(new StringTextComponent("\u00A76Learn Lee Release: Gate of Pain \u00A74Cost: 35 JP"));
				list.add(new StringTextComponent("\u00A76Learn Lee Release: Gate of Limit \u00A74Cost: 40 JP"));
				list.add(new StringTextComponent("\u00A76Learn Lee Release: Gate of View \u00A74Cost: 45 JP"));
				list.add(new StringTextComponent("\u00A76Learn Lee Release: Gate of Wonder \u00A74Cost: 50 JP"));
				list.add(new StringTextComponent("\u00A76Learn Lee Release: Gate of Death \u00A74Cost: 55 JP"));
			}

			@Override
			public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
				ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
				ItemStack itemstack = ar.getResult();
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();

				LeeReleaseRightclickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class NamikazeReleaseItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:namikaze_release")
		public static final Item block = null;

		public NamikazeReleaseItem(NarutoShippudenModElements instance) {
			super(instance, 109);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(new Item.Properties().group(ClansItemGroup.tab).maxStackSize(1).rarity(Rarity.EPIC));
				setRegistryName("namikaze_release");
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
				list.add(new StringTextComponent("\u00A76Learn Namikaze Release: Storm Release \u00A74Cost: 5 JP"));
				list.add(new StringTextComponent("\u00A76Learn Namikaze Release: Flying Thunder God Kunai Technique \u00A74Cost: 10 JP"));
			}

			@Override
			public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
				ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
				ItemStack itemstack = ar.getResult();
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();

				NamikazeReleaseRightclickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class NaraReleaseItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:nara_release")
		public static final Item block = null;

		public NaraReleaseItem(NarutoShippudenModElements instance) {
			super(instance, 110);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(new Item.Properties().group(ClansItemGroup.tab).maxStackSize(1).rarity(Rarity.EPIC));
				setRegistryName("nara_release");
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
	public static class OtsutsukiReleaseItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:otsutsuki_release")
		public static final Item block = null;

		public OtsutsukiReleaseItem(NarutoShippudenModElements instance) {
			super(instance, 111);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(new Item.Properties().group(ClansItemGroup.tab).maxStackSize(1).rarity(Rarity.EPIC));
				setRegistryName("otsutsuki_release");
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
				list.add(new StringTextComponent("\u00A76Learn Otsutsuki Release: Tool Creation Technique \u00A74Cost: 35 JP"));
			}

			@Override
			public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
				ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
				ItemStack itemstack = ar.getResult();
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();

				OtsutsukiReleaseRightclickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class SarutobiReleaseItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:sarutobi_release")
		public static final Item block = null;

		public SarutobiReleaseItem(NarutoShippudenModElements instance) {
			super(instance, 405);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(new Item.Properties().group(ClansItemGroup.tab).maxStackSize(1).rarity(Rarity.EPIC));
				setRegistryName("sarutobi_release");
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
				list.add(new StringTextComponent("\u00A76Learn Sarutobi Release: Ash Pile Burning \u00A74Cost: 10 JP"));
				list.add(new StringTextComponent("\u00A76Learn Sarutobi Release: Fire Dragon Flame Bullet  \u00A74Cost: 15 JP"));
			}

			@Override
			public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
				ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
				ItemStack itemstack = ar.getResult();
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();

				SarutobiReleaseRightclickProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class SenjuReleaseItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:senju_release")
		public static final Item block = null;

		public SenjuReleaseItem(NarutoShippudenModElements instance) {
			super(instance, 112);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(new Item.Properties().group(ClansItemGroup.tab).maxStackSize(1).rarity(Rarity.EPIC));
				setRegistryName("senju_release");
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
				list.add(new StringTextComponent("\u00A76Learn Senju Release: Wood Release \u00A74Cost: 5 JP"));
			}

			@Override
			public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
				ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
				ItemStack itemstack = ar.getResult();
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();

				SenjuReleaseRightclickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class ShimuraReleaseItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:shimura_release")
		public static final Item block = null;

		public ShimuraReleaseItem(NarutoShippudenModElements instance) {
			super(instance, 113);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(new Item.Properties().group(ClansItemGroup.tab).maxStackSize(1).rarity(Rarity.EPIC));
				setRegistryName("shimura_release");
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
	public static class ShurikenClanItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:shuriken_clan")
		public static final Item block = null;
		public static final EntityType arrow = (EntityType.Builder.<ArrowCustomEntity>create(ArrowCustomEntity::new, EntityClassification.MISC)
				.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).setCustomClientFactory(ArrowCustomEntity::new)
				.size(0.5f, 0.5f)).build("projectile_shuriken_clan").setRegistryName("projectile_shuriken_clan");

		public ShurikenClanItem(NarutoShippudenModElements instance) {
			super(instance, 985);
			FMLJavaModLoadingContext.get().getModEventBus().register(new ShurikenClanRenderer.ModelRegisterHandler());
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemRanged());
			elements.entities.add(() -> arrow);
		}

		public static class ItemRanged extends Item {
			public ItemRanged() {
				super(new Item.Properties().group(null).maxStackSize(0));
				setRegistryName("shuriken_clan");
			}

			@Override
			public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
				entity.setActiveHand(hand);
				return new ActionResult(ActionResultType.SUCCESS, entity.getHeldItem(hand));
			}

			@Override
			public UseAction getUseAction(ItemStack itemstack) {
				return UseAction.NONE;
			}

			@Override
			public int getUseDuration(ItemStack itemstack) {
				return 72000;
			}

			@Override
			public void onPlayerStoppedUsing(ItemStack itemstack, World world, LivingEntity entityLiving, int timeLeft) {
				if (!world.isRemote && entityLiving instanceof ServerPlayerEntity) {
					ServerPlayerEntity entity = (ServerPlayerEntity) entityLiving;
					double x = entity.getPosX();
					double y = entity.getPosY();
					double z = entity.getPosZ();
					if (true) {
						ArrowCustomEntity entityarrow = shoot(world, entity, random, 2f, 0, 0);
						itemstack.damageItem(1, entity, e -> e.sendBreakAnimation(entity.getActiveHand()));
						entityarrow.pickupStatus = AbstractArrowEntity.PickupStatus.DISALLOWED;
					}
				}
			}
		}

		@OnlyIn(value = Dist.CLIENT, _interface = IRendersAsItem.class)
		public static class ArrowCustomEntity extends AbstractArrowEntity implements IRendersAsItem {
			public ArrowCustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
				super(arrow, world);
			}

			public ArrowCustomEntity(EntityType<? extends ArrowCustomEntity> type, World world) {
				super(type, world);
			}

			public ArrowCustomEntity(EntityType<? extends ArrowCustomEntity> type, double x, double y, double z, World world) {
				super(type, x, y, z, world);
			}

			public ArrowCustomEntity(EntityType<? extends ArrowCustomEntity> type, LivingEntity entity, World world) {
				super(type, entity, world);
			}

			@Override
			public IPacket<?> createSpawnPacket() {
				return NetworkHooks.getEntitySpawningPacket(this);
			}

			@Override
			@OnlyIn(Dist.CLIENT)
			public ItemStack getItem() {
				return ItemStack.EMPTY;
			}

			@Override
			protected ItemStack getArrowStack() {
				return ItemStack.EMPTY;
			}

			@Override
			protected void arrowHit(LivingEntity entity) {
				super.arrowHit(entity);
				entity.setArrowCountInEntity(entity.getArrowCountInEntity() - 1);
			}

			@Override
			public void tick() {
				super.tick();
				double x = this.getPosX();
				double y = this.getPosY();
				double z = this.getPosZ();
				World world = this.world;
				Entity entity = this.func_234616_v_();
				Entity immediatesourceentity = this;
				if (this.inGround)
					this.remove();
			}
		}

		public static ArrowCustomEntity shoot(World world, LivingEntity entity, Random random, float power, double damage, int knockback) {
			ArrowCustomEntity entityarrow = new ArrowCustomEntity(arrow, entity, world);
			entityarrow.shoot(entity.getLook(1).x, entity.getLook(1).y, entity.getLook(1).z, power * 2, 0);
			entityarrow.setSilent(true);
			entityarrow.setIsCritical(false);
			entityarrow.setDamage(damage);
			entityarrow.setKnockbackStrength(knockback);
			world.addEntity(entityarrow);
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			world.playSound((PlayerEntity) null, (double) x, (double) y, (double) z,
					(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("")), SoundCategory.PLAYERS, 1,
					1f / (random.nextFloat() * 0.5f + 1) + (power / 2));
			return entityarrow;
		}

		public static ArrowCustomEntity shoot(LivingEntity entity, LivingEntity target) {
			ArrowCustomEntity entityarrow = new ArrowCustomEntity(arrow, entity, entity.world);
			double d0 = target.getPosY() + (double) target.getEyeHeight() - 1.1;
			double d1 = target.getPosX() - entity.getPosX();
			double d3 = target.getPosZ() - entity.getPosZ();
			entityarrow.shoot(d1, d0 - entityarrow.getPosY() + (double) MathHelper.sqrt(d1 * d1 + d3 * d3) * 0.2F, d3, 2f * 2, 12.0F);
			entityarrow.setSilent(true);
			entityarrow.setDamage(0);
			entityarrow.setKnockbackStrength(0);
			entityarrow.setIsCritical(false);
			entity.world.addEntity(entityarrow);
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			entity.world.playSound((PlayerEntity) null, (double) x, (double) y, (double) z,
					(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("")), SoundCategory.PLAYERS, 1,
					1f / (new Random().nextFloat() * 0.5f + 1));
			return entityarrow;
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class TenroReleaseItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:tenro_release")
		public static final Item block = null;

		public TenroReleaseItem(NarutoShippudenModElements instance) {
			super(instance, 114);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(new Item.Properties().group(ClansItemGroup.tab).maxStackSize(1).rarity(Rarity.EPIC));
				setRegistryName("tenro_release");
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
				list.add(new StringTextComponent("\u00A76Learn Tenro Release: Beast-Human Fury Kicks \u00A74Cost: 15 JP"));
				list.add(new StringTextComponent("\u00A76Learn Tenro Release: Beast-Human Transformation Technique  \u00A74Cost: 20 JP"));
				list.add(new StringTextComponent("\u00A76Learn Tenro Release: Beast-Human Needle Senbon \u00A74Cost: 25 JP"));
			}

			@Override
			public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
				ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
				ItemStack itemstack = ar.getResult();
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();

				TenroReleaseRightclickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class ToroiUniqueFumaShurikenClanItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:toroi_unique_fuma_shuriken_clan")
		public static final Item block = null;
		public static final EntityType arrow = (EntityType.Builder.<ArrowCustomEntity>create(ArrowCustomEntity::new, EntityClassification.MISC)
				.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).setCustomClientFactory(ArrowCustomEntity::new)
				.size(0.5f, 0.5f)).build("projectile_toroi_unique_fuma_shuriken_clan").setRegistryName("projectile_toroi_unique_fuma_shuriken_clan");

		public ToroiUniqueFumaShurikenClanItem(NarutoShippudenModElements instance) {
			super(instance, 987);
			FMLJavaModLoadingContext.get().getModEventBus().register(new ToroiUniqueFumaShurikenClanRenderer.ModelRegisterHandler());
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemRanged());
			elements.entities.add(() -> arrow);
		}

		public static class ItemRanged extends Item {
			public ItemRanged() {
				super(new Item.Properties().group(null).maxStackSize(0));
				setRegistryName("toroi_unique_fuma_shuriken_clan");
			}

			@Override
			public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
				entity.setActiveHand(hand);
				return new ActionResult(ActionResultType.SUCCESS, entity.getHeldItem(hand));
			}

			@Override
			public UseAction getUseAction(ItemStack itemstack) {
				return UseAction.NONE;
			}

			@Override
			public int getUseDuration(ItemStack itemstack) {
				return 72000;
			}

			@Override
			public void onPlayerStoppedUsing(ItemStack itemstack, World world, LivingEntity entityLiving, int timeLeft) {
				if (!world.isRemote && entityLiving instanceof ServerPlayerEntity) {
					ServerPlayerEntity entity = (ServerPlayerEntity) entityLiving;
					double x = entity.getPosX();
					double y = entity.getPosY();
					double z = entity.getPosZ();
					if (true) {
						ArrowCustomEntity entityarrow = shoot(world, entity, random, 0f, 0, 0);
						itemstack.damageItem(1, entity, e -> e.sendBreakAnimation(entity.getActiveHand()));
						entityarrow.pickupStatus = AbstractArrowEntity.PickupStatus.DISALLOWED;
					}
				}
			}
		}

		@OnlyIn(value = Dist.CLIENT, _interface = IRendersAsItem.class)
		public static class ArrowCustomEntity extends AbstractArrowEntity implements IRendersAsItem {
			public ArrowCustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
				super(arrow, world);
			}

			public ArrowCustomEntity(EntityType<? extends ArrowCustomEntity> type, World world) {
				super(type, world);
			}

			public ArrowCustomEntity(EntityType<? extends ArrowCustomEntity> type, double x, double y, double z, World world) {
				super(type, x, y, z, world);
			}

			public ArrowCustomEntity(EntityType<? extends ArrowCustomEntity> type, LivingEntity entity, World world) {
				super(type, entity, world);
			}

			@Override
			public IPacket<?> createSpawnPacket() {
				return NetworkHooks.getEntitySpawningPacket(this);
			}

			@Override
			@OnlyIn(Dist.CLIENT)
			public ItemStack getItem() {
				return new ItemStack(ToroiUniqueFumaShurikenItem.block);
			}

			@Override
			protected ItemStack getArrowStack() {
				return ItemStack.EMPTY;
			}

			@Override
			protected void arrowHit(LivingEntity entity) {
				super.arrowHit(entity);
				entity.setArrowCountInEntity(entity.getArrowCountInEntity() - 1);
			}

			@Override
			public void tick() {
				super.tick();
				double x = this.getPosX();
				double y = this.getPosY();
				double z = this.getPosZ();
				World world = this.world;
				Entity entity = this.func_234616_v_();
				Entity immediatesourceentity = this;
				if (this.inGround)
					this.remove();
			}
		}

		public static ArrowCustomEntity shoot(World world, LivingEntity entity, Random random, float power, double damage, int knockback) {
			ArrowCustomEntity entityarrow = new ArrowCustomEntity(arrow, entity, world);
			entityarrow.shoot(entity.getLook(1).x, entity.getLook(1).y, entity.getLook(1).z, power * 2, 0);
			entityarrow.setSilent(true);
			entityarrow.setIsCritical(false);
			entityarrow.setDamage(damage);
			entityarrow.setKnockbackStrength(knockback);
			world.addEntity(entityarrow);
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			world.playSound((PlayerEntity) null, (double) x, (double) y, (double) z,
					(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("")), SoundCategory.PLAYERS, 1,
					1f / (random.nextFloat() * 0.5f + 1) + (power / 2));
			return entityarrow;
		}

		public static ArrowCustomEntity shoot(LivingEntity entity, LivingEntity target) {
			ArrowCustomEntity entityarrow = new ArrowCustomEntity(arrow, entity, entity.world);
			double d0 = target.getPosY() + (double) target.getEyeHeight() - 1.1;
			double d1 = target.getPosX() - entity.getPosX();
			double d3 = target.getPosZ() - entity.getPosZ();
			entityarrow.shoot(d1, d0 - entityarrow.getPosY() + (double) MathHelper.sqrt(d1 * d1 + d3 * d3) * 0.2F, d3, 0f * 2, 12.0F);
			entityarrow.setSilent(true);
			entityarrow.setDamage(0);
			entityarrow.setKnockbackStrength(0);
			entityarrow.setIsCritical(false);
			entity.world.addEntity(entityarrow);
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			entity.world.playSound((PlayerEntity) null, (double) x, (double) y, (double) z,
					(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("")), SoundCategory.PLAYERS, 1,
					1f / (new Random().nextFloat() * 0.5f + 1));
			return entityarrow;
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class TsuchigumoReleaseItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:tsuchigumo_release")
		public static final Item block = null;

		public TsuchigumoReleaseItem(NarutoShippudenModElements instance) {
			super(instance, 115);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(new Item.Properties().group(ClansItemGroup.tab).maxStackSize(1).rarity(Rarity.EPIC));
				setRegistryName("tsuchigumo_release");
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
				list.add(new StringTextComponent("\u00A76Learn Tsuchigumo Release: Fury \u00A74Cost: 20 JP"));
			}

			@Override
			public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
				ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
				ItemStack itemstack = ar.getResult();
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();

				TsuchigumoReleaseRightclickProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class UchihaReleaseItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:uchiha_release")
		public static final Item block = null;

		public UchihaReleaseItem(NarutoShippudenModElements instance) {
			super(instance, 100);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(new Item.Properties().group(ClansItemGroup.tab).maxStackSize(1).rarity(Rarity.EPIC));
				setRegistryName("uchiha_release");
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
	public static class UzumakiReleaseItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:uzumaki_release")
		public static final Item block = null;

		public UzumakiReleaseItem(NarutoShippudenModElements instance) {
			super(instance, 102);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(new Item.Properties().group(ClansItemGroup.tab).maxStackSize(1).rarity(Rarity.EPIC));
				setRegistryName("uzumaki_release");
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
				list.add(new StringTextComponent("\u00A76Learn Uzumaki Release: Adamantine Sealing Chains \u00A74Cost: 15 JP"));
				list.add(new StringTextComponent("\u00A76Learn Uzumaki Release: Heal Bite \u00A74Cost: 20 JP"));
				list.add(new StringTextComponent("\u00A76Learn Uzumaki Release: Dead Demon Consuming Seal \u00A74Cost: 25 JP"));
			}

			@Override
			public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
				ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
				ItemStack itemstack = ar.getResult();
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();

				UzumakiReleaseRightclickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class YukiReleaseItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:yuki_release")
		public static final Item block = null;

		public YukiReleaseItem(NarutoShippudenModElements instance) {
			super(instance, 117);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(new Item.Properties().group(ClansItemGroup.tab).maxStackSize(1).rarity(Rarity.EPIC));
				setRegistryName("yuki_release");
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
				list.add(new StringTextComponent("\u00A76Learn Yuki Release: Ice Release \u00A74Cost: 5 JP"));
			}

			@Override
			public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
				ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
				ItemStack itemstack = ar.getResult();
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();

				YukiReleaseRightclickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}
}
