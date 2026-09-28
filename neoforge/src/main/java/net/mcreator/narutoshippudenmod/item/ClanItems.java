package net.mcreator.narutoshippudenmod.item;

import net.mcreator.narutoshippudenmod.compat.Compat;
import net.minecraft.util.RandomSource;
import net.minecraft.core.registries.Registries;
import net.mcreator.narutoshippudenmod.compat.Registration;
import net.mcreator.narutoshippudenmod.compat.ModArrow;

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
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.ItemSupplier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.projectile.arrow.AbstractArrow;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemUseAnimation;
import net.minecraft.network.protocol.Packet;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;



import net.minecraft.core.registries.BuiltInRegistries;


public final class ClanItems {
	private ClanItems() {
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class AburameReleaseItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "aburame_release", v -> block = (Item) v);
		}

		public AburameReleaseItem(NarutoShippudenModElements instance) {
			super(instance, 118);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("aburame_release", "ClansItemGroup").stacksTo(1).rarity(Rarity.EPIC));
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

				AburameReleaseRightclickProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class AkimichiReleaseItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "akimichi_release", v -> block = (Item) v);
		}

		public AkimichiReleaseItem(NarutoShippudenModElements instance) {
			super(instance, 119);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("akimichi_release", "ClansItemGroup").stacksTo(1).rarity(Rarity.EPIC));
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

				AkimichiReleaseRightclickProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class ChinoikeReleaseItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "chinoike_release", v -> block = (Item) v);
		}

		public ChinoikeReleaseItem(NarutoShippudenModElements instance) {
			super(instance, 120);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("chinoike_release", "ClansItemGroup").stacksTo(1).rarity(Rarity.EPIC));
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
	public static class ClanResetStatItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "clan_reset_stat", v -> block = (Item) v);
		}

		public ClanResetStatItem(NarutoShippudenModElements instance) {
			super(instance, 422);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("clan_reset_stat", "ClansItemGroup").stacksTo(1).rarity(Rarity.EPIC));
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

				ClanResetRightclickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class DanceOfTheCamelliaItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "dance_of_the_camellia", v -> block = (Item) v);
		}

		public DanceOfTheCamelliaItem(NarutoShippudenModElements instance) {
			super(instance, 956);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("dance_of_the_camellia", null).stacksTo(1).rarity(Rarity.COMMON));
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
			public void hurtEnemy(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
				super.hurtEnemy(itemstack, entity, sourceentity);
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
				Level world = entity.level();

				DanceOfTheCamelliaLivingEntityIsHitWithItemProcedure.executeProcedure(
						Stream.of(new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("sourceentity", sourceentity))
								.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class DanceOfTheClematisFlowerItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "dance_of_the_clematis_flower", v -> block = (Item) v);
		}

		public DanceOfTheClematisFlowerItem(NarutoShippudenModElements instance) {
			super(instance, 958);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("dance_of_the_clematis_flower", null).stacksTo(1).rarity(Rarity.COMMON));
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
			public void hurtEnemy(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
				super.hurtEnemy(itemstack, entity, sourceentity);
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
				Level world = entity.level();

				DanceOfTheClematisFlowerLivingEntityIsHitWithItemProcedure.executeProcedure(
						Stream.of(new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("sourceentity", sourceentity))
								.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class EightTrigramsTwinLionsCrumblingAttackItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "eight_trigrams_twin_lions_crumbling_attack", v -> block = (Item) v);
		}

		public EightTrigramsTwinLionsCrumblingAttackItem(NarutoShippudenModElements instance) {
			super(instance, 456);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("eight_trigrams_twin_lions_crumbling_attack", null).stacksTo(1).rarity(Rarity.COMMON));
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
			public void hurtEnemy(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
				super.hurtEnemy(itemstack, entity, sourceentity);
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
				Level world = entity.level();

				EightTrigramsTwinLionsCrumblingAttackLivingEntityIsHitWithItemProcedure.executeProcedure(
						Stream.of(new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("sourceentity", sourceentity))
								.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class FumaReleaseItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "fuma_release", v -> block = (Item) v);
		}

		public FumaReleaseItem(NarutoShippudenModElements instance) {
			super(instance, 406);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("fuma_release", "ClansItemGroup").stacksTo(1).rarity(Rarity.EPIC));
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

				FumaReleaseRightclickProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class FumaShurikenClanItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "fuma_shuriken_clan", v -> block = (Item) v);
		}
		public static EntityType<ArrowCustomEntity> arrow;

		public FumaShurikenClanItem(NarutoShippudenModElements instance) {
			super(instance, 986);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemRanged());
			elements.entities.add(() -> arrow = (EntityType.Builder.<ArrowCustomEntity>of(ArrowCustomEntity::new, MobCategory.MISC) .setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1) .sized(0.5f, 0.5f)).build(Registration.entityKey("projectile_fuma_shuriken_clan")));
		}

		public static class ItemRanged extends Item {
			public ItemRanged() {
				super(Registration.itemProps("fuma_shuriken_clan", null).stacksTo(1));
			}

			@Override
			public InteractionResult use(Level world, Player entity, InteractionHand hand) {
				entity.startUsingItem(hand);
				return InteractionResult.SUCCESS;
			}

			@Override
			public ItemUseAnimation getUseAnimation(ItemStack itemstack) {
				return ItemUseAnimation.NONE;
			}

			@Override
			public int getUseDuration(ItemStack itemstack, LivingEntity user) {
				return 72000;
			}

			@Override
			public boolean releaseUsing(ItemStack itemstack, Level world, LivingEntity entityLiving, int timeLeft) {
				if (!world.isClientSide() && entityLiving instanceof ServerPlayer) {
					ServerPlayer entity = (ServerPlayer) entityLiving;
					double x = entity.getX();
					double y = entity.getY();
					double z = entity.getZ();
					if (true) {
						ArrowCustomEntity entityarrow = shoot(world, entity, world.getRandom(), 0f, 0, 0);
						itemstack.hurtAndBreak(1, entity, entity.getUsedItemHand());
						entityarrow.pickup = AbstractArrow.Pickup.DISALLOWED;
					}
				}
				return true;
			}
		}

		public static class ArrowCustomEntity extends ModArrow implements ItemSupplier {

			public ArrowCustomEntity(EntityType<? extends ArrowCustomEntity> type, Level world) {
				super(type, world);
			}

			public ArrowCustomEntity(EntityType<? extends ArrowCustomEntity> type, double x, double y, double z, Level world) {
				super(type, x, y, z, world);
			}

			public ArrowCustomEntity(EntityType<? extends ArrowCustomEntity> type, LivingEntity entity, Level world) {
				super(type, entity, world);
			}

			@Override
			public ItemStack getItem() {
				return new ItemStack(FumaShurikenItem.block);
			}

			@Override
			protected ItemStack getPickupItem() {
				return ItemStack.EMPTY;
			}

			@Override
			protected void doPostHurtEffects(LivingEntity entity) {
				super.doPostHurtEffects(entity);
				entity.setArrowCount(entity.getArrowCount() - 1);
			}

			@Override
			public void tick() {
				super.tick();
				double x = this.getX();
				double y = this.getY();
				double z = this.getZ();
				Level world = this.level();
				Entity entity = this.getOwner();
				Entity immediatesourceentity = this;
				if (this.isInGround())
					this.discard();
			}
		}

		public static ArrowCustomEntity shoot(Level world, LivingEntity entity, RandomSource random, float power, double damage, int knockback) {
			ArrowCustomEntity entityarrow = new ArrowCustomEntity(arrow, entity, world);
			entityarrow.shoot(entity.getViewVector(1).x, entity.getViewVector(1).y, entity.getViewVector(1).z, power * 2, 0);
			entityarrow.setSilent(true);
			entityarrow.setCritArrow(false);
			entityarrow.setBaseDamage(damage);
			Compat.setKnockback(entityarrow, knockback);
			world.addFreshEntity(entityarrow);
			double x = entity.getX();
			double y = entity.getY();
			double z = entity.getZ();
			world.playSound((Player) null, (double) x, (double) y, (double) z,
					Compat.sound(""), SoundSource.PLAYERS, 1,
					1f / (random.nextFloat() * 0.5f + 1) + (power / 2));
			return entityarrow;
		}

		public static ArrowCustomEntity shoot(LivingEntity entity, LivingEntity target) {
			ArrowCustomEntity entityarrow = new ArrowCustomEntity(arrow, entity, entity.level());
			double d0 = target.getY() + (double) target.getEyeHeight() - 1.1;
			double d1 = target.getX() - entity.getX();
			double d3 = target.getZ() - entity.getZ();
			entityarrow.shoot(d1, d0 - entityarrow.getY() + (double) (float) Math.sqrt(d1 * d1 + d3 * d3) * 0.2F, d3, 0f * 2, 12.0F);
			entityarrow.setSilent(true);
			entityarrow.setBaseDamage(0);
			Compat.setKnockback(entityarrow, 0);
			entityarrow.setCritArrow(false);
			entity.level().addFreshEntity(entityarrow);
			double x = entity.getX();
			double y = entity.getY();
			double z = entity.getZ();
			entity.level().playSound((Player) null, (double) x, (double) y, (double) z,
					Compat.sound(""), SoundSource.PLAYERS, 1,
					1f / (RandomSource.create().nextFloat() * 0.5f + 1));
			return entityarrow;
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class GentleStepTwinLionFistsItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "gentle_step_twin_lion_fists", v -> block = (Item) v);
		}

		public GentleStepTwinLionFistsItem(NarutoShippudenModElements instance) {
			super(instance, 454);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("gentle_step_twin_lion_fists", null).stacksTo(1).rarity(Rarity.COMMON));
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
			public void hurtEnemy(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
				super.hurtEnemy(itemstack, entity, sourceentity);
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
				Level world = entity.level();

				GentleStepTwinLionFistsLivingEntityIsHitWithItemProcedure.executeProcedure(
						Stream.of(new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("sourceentity", sourceentity))
								.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class HatakeReleaseItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "hatake_release", v -> block = (Item) v);
		}

		public HatakeReleaseItem(NarutoShippudenModElements instance) {
			super(instance, 104);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("hatake_release", "ClansItemGroup").stacksTo(1).rarity(Rarity.EPIC));
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

				HatakeReleaseRightclickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class HoshigakiReleaseItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "hoshigaki_release", v -> block = (Item) v);
		}

		public HoshigakiReleaseItem(NarutoShippudenModElements instance) {
			super(instance, 407);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("hoshigaki_release", "ClansItemGroup").stacksTo(1).rarity(Rarity.EPIC));
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

				HoshigakiReleaseRightclickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class HozukiReleaseItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "hozuki_release", v -> block = (Item) v);
		}

		public HozukiReleaseItem(NarutoShippudenModElements instance) {
			super(instance, 408);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("hozuki_release", "ClansItemGroup").stacksTo(1).rarity(Rarity.EPIC));
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

				HozukiReleaseRightclickProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class HyugaReleaseItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "hyuga_release", v -> block = (Item) v);
		}

		public HyugaReleaseItem(NarutoShippudenModElements instance) {
			super(instance, 103);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("hyuga_release", "ClansItemGroup").stacksTo(1).rarity(Rarity.EPIC));
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

				HyugaReleaseRightclickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class IburiReleaseItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "iburi_release", v -> block = (Item) v);
		}

		public IburiReleaseItem(NarutoShippudenModElements instance) {
			super(instance, 105);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("iburi_release", "ClansItemGroup").stacksTo(1).rarity(Rarity.EPIC));
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

				IburiReleaseRightclickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class InuzukaReleaseItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "inuzuka_release", v -> block = (Item) v);
		}

		public InuzukaReleaseItem(NarutoShippudenModElements instance) {
			super(instance, 106);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("inuzuka_release", "ClansItemGroup").stacksTo(1).rarity(Rarity.EPIC));
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

				InuzukaReleaseRightclickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class IzunoReleaseItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "izuno_release", v -> block = (Item) v);
		}

		public IzunoReleaseItem(NarutoShippudenModElements instance) {
			super(instance, 411);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("izuno_release", "ClansItemGroup").stacksTo(1).rarity(Rarity.EPIC));
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

				IzunoReleaseRightclickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class KaguyaReleaseItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "kaguya_release", v -> block = (Item) v);
		}

		public KaguyaReleaseItem(NarutoShippudenModElements instance) {
			super(instance, 409);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("kaguya_release", "ClansItemGroup").stacksTo(1).rarity(Rarity.EPIC));
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

				KaguyaReleaseRightclickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class KazekageReleaseItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "kazekage_release", v -> block = (Item) v);
		}

		public KazekageReleaseItem(NarutoShippudenModElements instance) {
			super(instance, 107);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("kazekage_release", "ClansItemGroup").stacksTo(1).rarity(Rarity.EPIC));
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

				KazekageReleaseRightclickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class KuramaReleaseItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "kurama_release", v -> block = (Item) v);
		}

		public KuramaReleaseItem(NarutoShippudenModElements instance) {
			super(instance, 402);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("kurama_release", "ClansItemGroup").stacksTo(1).rarity(Rarity.EPIC));
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
	public static class LeeReleaseItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "lee_release", v -> block = (Item) v);
		}

		public LeeReleaseItem(NarutoShippudenModElements instance) {
			super(instance, 108);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("lee_release", "ClansItemGroup").stacksTo(1).rarity(Rarity.EPIC));
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

				LeeReleaseRightclickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class NamikazeReleaseItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "namikaze_release", v -> block = (Item) v);
		}

		public NamikazeReleaseItem(NarutoShippudenModElements instance) {
			super(instance, 109);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("namikaze_release", "ClansItemGroup").stacksTo(1).rarity(Rarity.EPIC));
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

				NamikazeReleaseRightclickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class NaraReleaseItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "nara_release", v -> block = (Item) v);
		}

		public NaraReleaseItem(NarutoShippudenModElements instance) {
			super(instance, 110);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("nara_release", "ClansItemGroup").stacksTo(1).rarity(Rarity.EPIC));
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
	public static class OtsutsukiReleaseItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "otsutsuki_release", v -> block = (Item) v);
		}

		public OtsutsukiReleaseItem(NarutoShippudenModElements instance) {
			super(instance, 111);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("otsutsuki_release", "ClansItemGroup").stacksTo(1).rarity(Rarity.EPIC));
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

				OtsutsukiReleaseRightclickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class SarutobiReleaseItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "sarutobi_release", v -> block = (Item) v);
		}

		public SarutobiReleaseItem(NarutoShippudenModElements instance) {
			super(instance, 405);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("sarutobi_release", "ClansItemGroup").stacksTo(1).rarity(Rarity.EPIC));
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

				SarutobiReleaseRightclickProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class SenjuReleaseItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "senju_release", v -> block = (Item) v);
		}

		public SenjuReleaseItem(NarutoShippudenModElements instance) {
			super(instance, 112);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("senju_release", "ClansItemGroup").stacksTo(1).rarity(Rarity.EPIC));
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

				SenjuReleaseRightclickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class ShimuraReleaseItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "shimura_release", v -> block = (Item) v);
		}

		public ShimuraReleaseItem(NarutoShippudenModElements instance) {
			super(instance, 113);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("shimura_release", "ClansItemGroup").stacksTo(1).rarity(Rarity.EPIC));
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
	public static class ShurikenClanItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "shuriken_clan", v -> block = (Item) v);
		}
		public static EntityType<ArrowCustomEntity> arrow;

		public ShurikenClanItem(NarutoShippudenModElements instance) {
			super(instance, 985);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemRanged());
			elements.entities.add(() -> arrow = (EntityType.Builder.<ArrowCustomEntity>of(ArrowCustomEntity::new, MobCategory.MISC) .setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1) .sized(0.5f, 0.5f)).build(Registration.entityKey("projectile_shuriken_clan")));
		}

		public static class ItemRanged extends Item {
			public ItemRanged() {
				super(Registration.itemProps("shuriken_clan", null).stacksTo(1));
			}

			@Override
			public InteractionResult use(Level world, Player entity, InteractionHand hand) {
				entity.startUsingItem(hand);
				return InteractionResult.SUCCESS;
			}

			@Override
			public ItemUseAnimation getUseAnimation(ItemStack itemstack) {
				return ItemUseAnimation.NONE;
			}

			@Override
			public int getUseDuration(ItemStack itemstack, LivingEntity user) {
				return 72000;
			}

			@Override
			public boolean releaseUsing(ItemStack itemstack, Level world, LivingEntity entityLiving, int timeLeft) {
				if (!world.isClientSide() && entityLiving instanceof ServerPlayer) {
					ServerPlayer entity = (ServerPlayer) entityLiving;
					double x = entity.getX();
					double y = entity.getY();
					double z = entity.getZ();
					if (true) {
						ArrowCustomEntity entityarrow = shoot(world, entity, world.getRandom(), 2f, 0, 0);
						itemstack.hurtAndBreak(1, entity, entity.getUsedItemHand());
						entityarrow.pickup = AbstractArrow.Pickup.DISALLOWED;
					}
				}
				return true;
			}
		}

		public static class ArrowCustomEntity extends ModArrow implements ItemSupplier {

			public ArrowCustomEntity(EntityType<? extends ArrowCustomEntity> type, Level world) {
				super(type, world);
			}

			public ArrowCustomEntity(EntityType<? extends ArrowCustomEntity> type, double x, double y, double z, Level world) {
				super(type, x, y, z, world);
			}

			public ArrowCustomEntity(EntityType<? extends ArrowCustomEntity> type, LivingEntity entity, Level world) {
				super(type, entity, world);
			}

			@Override
			public ItemStack getItem() {
				return ItemStack.EMPTY;
			}

			@Override
			protected ItemStack getPickupItem() {
				return ItemStack.EMPTY;
			}

			@Override
			protected void doPostHurtEffects(LivingEntity entity) {
				super.doPostHurtEffects(entity);
				entity.setArrowCount(entity.getArrowCount() - 1);
			}

			@Override
			public void tick() {
				super.tick();
				double x = this.getX();
				double y = this.getY();
				double z = this.getZ();
				Level world = this.level();
				Entity entity = this.getOwner();
				Entity immediatesourceentity = this;
				if (this.isInGround())
					this.discard();
			}
		}

		public static ArrowCustomEntity shoot(Level world, LivingEntity entity, RandomSource random, float power, double damage, int knockback) {
			ArrowCustomEntity entityarrow = new ArrowCustomEntity(arrow, entity, world);
			entityarrow.shoot(entity.getViewVector(1).x, entity.getViewVector(1).y, entity.getViewVector(1).z, power * 2, 0);
			entityarrow.setSilent(true);
			entityarrow.setCritArrow(false);
			entityarrow.setBaseDamage(damage);
			Compat.setKnockback(entityarrow, knockback);
			world.addFreshEntity(entityarrow);
			double x = entity.getX();
			double y = entity.getY();
			double z = entity.getZ();
			world.playSound((Player) null, (double) x, (double) y, (double) z,
					Compat.sound(""), SoundSource.PLAYERS, 1,
					1f / (random.nextFloat() * 0.5f + 1) + (power / 2));
			return entityarrow;
		}

		public static ArrowCustomEntity shoot(LivingEntity entity, LivingEntity target) {
			ArrowCustomEntity entityarrow = new ArrowCustomEntity(arrow, entity, entity.level());
			double d0 = target.getY() + (double) target.getEyeHeight() - 1.1;
			double d1 = target.getX() - entity.getX();
			double d3 = target.getZ() - entity.getZ();
			entityarrow.shoot(d1, d0 - entityarrow.getY() + (double) (float) Math.sqrt(d1 * d1 + d3 * d3) * 0.2F, d3, 2f * 2, 12.0F);
			entityarrow.setSilent(true);
			entityarrow.setBaseDamage(0);
			Compat.setKnockback(entityarrow, 0);
			entityarrow.setCritArrow(false);
			entity.level().addFreshEntity(entityarrow);
			double x = entity.getX();
			double y = entity.getY();
			double z = entity.getZ();
			entity.level().playSound((Player) null, (double) x, (double) y, (double) z,
					Compat.sound(""), SoundSource.PLAYERS, 1,
					1f / (RandomSource.create().nextFloat() * 0.5f + 1));
			return entityarrow;
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class TenroReleaseItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "tenro_release", v -> block = (Item) v);
		}

		public TenroReleaseItem(NarutoShippudenModElements instance) {
			super(instance, 114);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("tenro_release", "ClansItemGroup").stacksTo(1).rarity(Rarity.EPIC));
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

				TenroReleaseRightclickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class ToroiUniqueFumaShurikenClanItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "toroi_unique_fuma_shuriken_clan", v -> block = (Item) v);
		}
		public static EntityType<ArrowCustomEntity> arrow;

		public ToroiUniqueFumaShurikenClanItem(NarutoShippudenModElements instance) {
			super(instance, 987);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemRanged());
			elements.entities.add(() -> arrow = (EntityType.Builder.<ArrowCustomEntity>of(ArrowCustomEntity::new, MobCategory.MISC) .setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1) .sized(0.5f, 0.5f)).build(Registration.entityKey("projectile_toroi_unique_fuma_shuriken_clan")));
		}

		public static class ItemRanged extends Item {
			public ItemRanged() {
				super(Registration.itemProps("toroi_unique_fuma_shuriken_clan", null).stacksTo(1));
			}

			@Override
			public InteractionResult use(Level world, Player entity, InteractionHand hand) {
				entity.startUsingItem(hand);
				return InteractionResult.SUCCESS;
			}

			@Override
			public ItemUseAnimation getUseAnimation(ItemStack itemstack) {
				return ItemUseAnimation.NONE;
			}

			@Override
			public int getUseDuration(ItemStack itemstack, LivingEntity user) {
				return 72000;
			}

			@Override
			public boolean releaseUsing(ItemStack itemstack, Level world, LivingEntity entityLiving, int timeLeft) {
				if (!world.isClientSide() && entityLiving instanceof ServerPlayer) {
					ServerPlayer entity = (ServerPlayer) entityLiving;
					double x = entity.getX();
					double y = entity.getY();
					double z = entity.getZ();
					if (true) {
						ArrowCustomEntity entityarrow = shoot(world, entity, world.getRandom(), 0f, 0, 0);
						itemstack.hurtAndBreak(1, entity, entity.getUsedItemHand());
						entityarrow.pickup = AbstractArrow.Pickup.DISALLOWED;
					}
				}
				return true;
			}
		}

		public static class ArrowCustomEntity extends ModArrow implements ItemSupplier {

			public ArrowCustomEntity(EntityType<? extends ArrowCustomEntity> type, Level world) {
				super(type, world);
			}

			public ArrowCustomEntity(EntityType<? extends ArrowCustomEntity> type, double x, double y, double z, Level world) {
				super(type, x, y, z, world);
			}

			public ArrowCustomEntity(EntityType<? extends ArrowCustomEntity> type, LivingEntity entity, Level world) {
				super(type, entity, world);
			}

			@Override
			public ItemStack getItem() {
				return new ItemStack(ToroiUniqueFumaShurikenItem.block);
			}

			@Override
			protected ItemStack getPickupItem() {
				return ItemStack.EMPTY;
			}

			@Override
			protected void doPostHurtEffects(LivingEntity entity) {
				super.doPostHurtEffects(entity);
				entity.setArrowCount(entity.getArrowCount() - 1);
			}

			@Override
			public void tick() {
				super.tick();
				double x = this.getX();
				double y = this.getY();
				double z = this.getZ();
				Level world = this.level();
				Entity entity = this.getOwner();
				Entity immediatesourceentity = this;
				if (this.isInGround())
					this.discard();
			}
		}

		public static ArrowCustomEntity shoot(Level world, LivingEntity entity, RandomSource random, float power, double damage, int knockback) {
			ArrowCustomEntity entityarrow = new ArrowCustomEntity(arrow, entity, world);
			entityarrow.shoot(entity.getViewVector(1).x, entity.getViewVector(1).y, entity.getViewVector(1).z, power * 2, 0);
			entityarrow.setSilent(true);
			entityarrow.setCritArrow(false);
			entityarrow.setBaseDamage(damage);
			Compat.setKnockback(entityarrow, knockback);
			world.addFreshEntity(entityarrow);
			double x = entity.getX();
			double y = entity.getY();
			double z = entity.getZ();
			world.playSound((Player) null, (double) x, (double) y, (double) z,
					Compat.sound(""), SoundSource.PLAYERS, 1,
					1f / (random.nextFloat() * 0.5f + 1) + (power / 2));
			return entityarrow;
		}

		public static ArrowCustomEntity shoot(LivingEntity entity, LivingEntity target) {
			ArrowCustomEntity entityarrow = new ArrowCustomEntity(arrow, entity, entity.level());
			double d0 = target.getY() + (double) target.getEyeHeight() - 1.1;
			double d1 = target.getX() - entity.getX();
			double d3 = target.getZ() - entity.getZ();
			entityarrow.shoot(d1, d0 - entityarrow.getY() + (double) (float) Math.sqrt(d1 * d1 + d3 * d3) * 0.2F, d3, 0f * 2, 12.0F);
			entityarrow.setSilent(true);
			entityarrow.setBaseDamage(0);
			Compat.setKnockback(entityarrow, 0);
			entityarrow.setCritArrow(false);
			entity.level().addFreshEntity(entityarrow);
			double x = entity.getX();
			double y = entity.getY();
			double z = entity.getZ();
			entity.level().playSound((Player) null, (double) x, (double) y, (double) z,
					Compat.sound(""), SoundSource.PLAYERS, 1,
					1f / (RandomSource.create().nextFloat() * 0.5f + 1));
			return entityarrow;
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class TsuchigumoReleaseItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "tsuchigumo_release", v -> block = (Item) v);
		}

		public TsuchigumoReleaseItem(NarutoShippudenModElements instance) {
			super(instance, 115);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("tsuchigumo_release", "ClansItemGroup").stacksTo(1).rarity(Rarity.EPIC));
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

				TsuchigumoReleaseRightclickProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class UchihaReleaseItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "uchiha_release", v -> block = (Item) v);
		}

		public UchihaReleaseItem(NarutoShippudenModElements instance) {
			super(instance, 100);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("uchiha_release", "ClansItemGroup").stacksTo(1).rarity(Rarity.EPIC));
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
	public static class UzumakiReleaseItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "uzumaki_release", v -> block = (Item) v);
		}

		public UzumakiReleaseItem(NarutoShippudenModElements instance) {
			super(instance, 102);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("uzumaki_release", "ClansItemGroup").stacksTo(1).rarity(Rarity.EPIC));
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

				UzumakiReleaseRightclickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class YukiReleaseItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "yuki_release", v -> block = (Item) v);
		}

		public YukiReleaseItem(NarutoShippudenModElements instance) {
			super(instance, 117);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("yuki_release", "ClansItemGroup").stacksTo(1).rarity(Rarity.EPIC));
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

				YukiReleaseRightclickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}
}
