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
import net.mcreator.narutoshippudenmod.entity.renderer.ProjectileRenderers.CoercionSharinganRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.ProjectileRenderers.FuramingoganBeamRenderer;
import net.mcreator.narutoshippudenmod.itemgroup.ModItemGroups.DojutsuItemGroup;
import net.mcreator.narutoshippudenmod.procedures.DojutsuProcedures.CoercionSharinganProjectileHitsLivingEntityProcedure;
import net.mcreator.narutoshippudenmod.procedures.DojutsuProcedures.FuramingoganBeamProjectileHitsLivingEntityProcedure;
import net.mcreator.narutoshippudenmod.procedures.DojutsuProcedures.FuramingoganReleaseRightclickedProcedure;
import net.mcreator.narutoshippudenmod.procedures.DojutsuProcedures.FuramingoganTechniqueRightclickedProcedure;
import net.mcreator.narutoshippudenmod.procedures.DojutsuProcedures.IsshikiDojutsuReleaseRightclickedProcedure;
import net.mcreator.narutoshippudenmod.procedures.DojutsuProcedures.MangekyouSharinganItachiReleaseRightclickedProcedure;
import net.mcreator.narutoshippudenmod.procedures.DojutsuProcedures.MangekyouSharinganKakashiReleaseRightclickedProcedure;
import net.mcreator.narutoshippudenmod.procedures.DojutsuProcedures.MangekyouSharinganMadaraReleaseRightclickedProcedure;
import net.mcreator.narutoshippudenmod.procedures.DojutsuProcedures.MangekyouSharinganObitoReleaseRightclickedProcedure;
import net.mcreator.narutoshippudenmod.procedures.DojutsuProcedures.MangekyouSharinganSasukeReleaseRightclickedProcedure;
import net.mcreator.narutoshippudenmod.procedures.DojutsuProcedures.MangekyouSharinganShisuiReleaseRightclickedProcedure;
import net.mcreator.narutoshippudenmod.procedures.DojutsuProcedures.SharinganReleaseRightclickedProcedure;
import net.mcreator.narutoshippudenmod.procedures.DojutsuProcedures.VolticModeReleaseRightclickedProcedure;
import net.mcreator.narutoshippudenmod.procedures.DojutsuProcedures.VolticModeTechniqueRightclickedProcedure;
import net.mcreator.narutoshippudenmod.procedures.JutsuEffectProcedures.GreatFireballWhileProjectileFlyingTickProcedure;
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
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.util.Mth;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;



import net.minecraft.core.registries.BuiltInRegistries;


public final class DojutsuItems {
	private DojutsuItems() {
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class ByakuganReleaseItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "byakugan_release", v -> block = (Item) v);
		}

		public ByakuganReleaseItem(NarutoShippudenModElements instance) {
			super(instance, 363);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("byakugan_release", "DojutsuItemGroup").stacksTo(1).rarity(Rarity.EPIC));
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
	public static class CoercionSharinganItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "coercion_sharingan", v -> block = (Item) v);
		}
		public static EntityType<ArrowCustomEntity> arrow;

		public CoercionSharinganItem(NarutoShippudenModElements instance) {
			super(instance, 436);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemRanged());
			elements.entities.add(() -> arrow = (EntityType.Builder.<ArrowCustomEntity>of(ArrowCustomEntity::new, MobCategory.MISC) .setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1) .sized(0.5f, 0.5f)).build(Registration.entityKey("projectile_coercion_sharingan")));
		}

		public static class ItemRanged extends Item {
			public ItemRanged() {
				super(Registration.itemProps("coercion_sharingan", null).stacksTo(1));
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
						ArrowCustomEntity entityarrow = shoot(world, entity, world.getRandom(), 12f, 1, 0);
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
			public void onHitEntity(EntityHitResult entityRayTraceResult) {
				super.onHitEntity(entityRayTraceResult);
				Entity entity = entityRayTraceResult.getEntity();
				Entity sourceentity = this.getOwner();
				Entity immediatesourceentity = this;
				double x = this.getX();
				double y = this.getY();
				double z = this.getZ();
				Level world = this.level();

				CoercionSharinganProjectileHitsLivingEntityProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z), new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
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

				GreatFireballWhileProjectileFlyingTickProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("immediatesourceentity", immediatesourceentity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
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
			entityarrow.shoot(d1, d0 - entityarrow.getY() + (double) (float) Math.sqrt(d1 * d1 + d3 * d3) * 0.2F, d3, 12f * 2, 12.0F);
			entityarrow.setSilent(true);
			entityarrow.setBaseDamage(1);
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
	public static class FuramingoganBeamItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "furamingogan_beam", v -> block = (Item) v);
		}
		public static EntityType<ArrowCustomEntity> arrow;

		public FuramingoganBeamItem(NarutoShippudenModElements instance) {
			super(instance, 704);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemRanged());
			elements.entities.add(() -> arrow = (EntityType.Builder.<ArrowCustomEntity>of(ArrowCustomEntity::new, MobCategory.MISC) .setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1) .sized(2.5f, 2.5f)).build(Registration.entityKey("projectile_furamingogan_beam")));
		}

		public static class ItemRanged extends Item {
			public ItemRanged() {
				super(Registration.itemProps("furamingogan_beam", null).stacksTo(1));
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
						ArrowCustomEntity entityarrow = shoot(world, entity, world.getRandom(), 4f, 1, 0);
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
			public void onHitEntity(EntityHitResult entityRayTraceResult) {
				super.onHitEntity(entityRayTraceResult);
				Entity entity = entityRayTraceResult.getEntity();
				Entity sourceentity = this.getOwner();
				Entity immediatesourceentity = this;
				double x = this.getX();
				double y = this.getY();
				double z = this.getZ();
				Level world = this.level();

				FuramingoganBeamProjectileHitsLivingEntityProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
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

				GreatFireballWhileProjectileFlyingTickProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("immediatesourceentity", immediatesourceentity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
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
			entityarrow.shoot(d1, d0 - entityarrow.getY() + (double) (float) Math.sqrt(d1 * d1 + d3 * d3) * 0.2F, d3, 4f * 2, 12.0F);
			entityarrow.setSilent(true);
			entityarrow.setBaseDamage(1);
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
	public static class FuramingoganReleaseItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "furamingogan_release", v -> block = (Item) v);
		}

		public FuramingoganReleaseItem(NarutoShippudenModElements instance) {
			super(instance, 695);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("furamingogan_release", null).stacksTo(1).rarity(Rarity.EPIC));
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
				list.accept(Component.literal("\u00A76Learn Furamingogan Release: Furamingogan Secret Ritual \u00A74Cost: 15 JP"));
				list.accept(Component.literal("\u00A76Learn Furamingogan Release: Furamingogan Beam \u00A74Cost: 20 JP"));
				list.accept(Component.literal("\u00A76Learn Furamingogan Release: Furamingogan Jump \u00A74Cost: 25 JP"));
			}

			@Override
			public InteractionResult use(Level world, Player entity, InteractionHand hand) {
				InteractionResult ar = super.use(world, entity, hand);
				ItemStack itemstack = entity.getItemInHand(hand);
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();

				FuramingoganReleaseRightclickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class FuramingoganTechniqueItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "furamingogan_technique", v -> block = (Item) v);
		}

		public FuramingoganTechniqueItem(NarutoShippudenModElements instance) {
			super(instance, 701);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("furamingogan_technique", null).stacksTo(1).rarity(Rarity.COMMON));
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
				list.accept(Component.literal("\u00A72Furamingogan Secret Ritual: \u00A7bChakra cost: 150 \u00A73Ninjutsu required: 15"));
				list.accept(Component.literal("\u00A72Furamingogan Beam: \u00A7bChakra cost: 350 \u00A73Ninjutsu required: 20"));
				list.accept(Component.literal("\u00A72Furamingogan Jump: \u00A7bChakra cost: 500 \u00A73Ninjutsu required: 25"));
			}

			@Override
			public InteractionResult use(Level world, Player entity, InteractionHand hand) {
				InteractionResult ar = super.use(world, entity, hand);
				ItemStack itemstack = entity.getItemInHand(hand);
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();

				FuramingoganTechniqueRightclickedProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z), new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class IsshikiDojutsuReleaseItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "isshiki_dojutsu_release", v -> block = (Item) v);
		}

		public IsshikiDojutsuReleaseItem(NarutoShippudenModElements instance) {
			super(instance, 534);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("isshiki_dojutsu_release", "DojutsuItemGroup").stacksTo(1).rarity(Rarity.EPIC));
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
				list.accept(Component.literal("\u00A76Learn Isshiki Dojutsu Release: Sukunahikona \u00A74Cost: 25 JP"));
				list.accept(Component.literal("\u00A76Learn Isshiki Dojutsu Release: Disruption Cube \u00A74Cost: 40 JP"));
			}

			@Override
			public InteractionResult use(Level world, Player entity, InteractionHand hand) {
				InteractionResult ar = super.use(world, entity, hand);
				ItemStack itemstack = entity.getItemInHand(hand);
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();

				IsshikiDojutsuReleaseRightclickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class KetsuryuganReleaseItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "ketsuryugan_release", v -> block = (Item) v);
		}

		public KetsuryuganReleaseItem(NarutoShippudenModElements instance) {
			super(instance, 364);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("ketsuryugan_release", "DojutsuItemGroup").stacksTo(1).rarity(Rarity.EPIC));
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
	public static class MangekyouSharinganItachiReleaseItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "mangekyou_sharingan_itachi_release", v -> block = (Item) v);
		}

		public MangekyouSharinganItachiReleaseItem(NarutoShippudenModElements instance) {
			super(instance, 592);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("mangekyou_sharingan_itachi_release", "DojutsuItemGroup").stacksTo(1).rarity(Rarity.EPIC));
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
				list.accept(Component.literal("Right-Click to use release"));
				list.accept(Component.literal("Sneak and Right-Click to select or change release"));
				list.accept(Component.literal("\u00A78Amaterasu:"));
				list.accept(Component.literal("\u00A76Learn Amaterasu Release: Amaterasu \u00A74Cost: 10 JP"));
				list.accept(Component.literal("\u00A7cSusano:"));
				list.accept(Component.literal("\u00A76Learn Susano Release: Ribcage \u00A74Cost: 10 JP"));
				list.accept(Component.literal("\u00A76Learn Susano Release: Skeletal Susano \u00A74Cost: 20 JP"));
				list.accept(Component.literal("\u00A76Learn Susano Release: Humanoid Susano \u00A74Cost: 30 JP"));
			}

			@Override
			public InteractionResult use(Level world, Player entity, InteractionHand hand) {
				InteractionResult ar = super.use(world, entity, hand);
				ItemStack itemstack = entity.getItemInHand(hand);
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();

				MangekyouSharinganItachiReleaseRightclickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class MangekyouSharinganKakashiReleaseItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "mangekyou_sharingan_kakashi_release", v -> block = (Item) v);
		}

		public MangekyouSharinganKakashiReleaseItem(NarutoShippudenModElements instance) {
			super(instance, 647);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("mangekyou_sharingan_kakashi_release", "DojutsuItemGroup").stacksTo(1).rarity(Rarity.EPIC));
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
				list.accept(Component.literal("\u00A78Kamui:"));
				list.accept(Component.literal("\u00A76Learn Kamui Release: Kamui Long-Range \u00A74Cost: 35 JP"));
			}

			@Override
			public InteractionResult use(Level world, Player entity, InteractionHand hand) {
				InteractionResult ar = super.use(world, entity, hand);
				ItemStack itemstack = entity.getItemInHand(hand);
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();

				MangekyouSharinganKakashiReleaseRightclickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class MangekyouSharinganMadaraReleaseItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "mangekyou_sharingan_madara_release", v -> block = (Item) v);
		}

		public MangekyouSharinganMadaraReleaseItem(NarutoShippudenModElements instance) {
			super(instance, 591);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("mangekyou_sharingan_madara_release", "DojutsuItemGroup").stacksTo(1).rarity(Rarity.EPIC));
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
				list.accept(Component.literal("\u00A71Susano:"));
				list.accept(Component.literal("\u00A76Learn Susano Release: Ribcage \u00A74Cost: 10 JP"));
				list.accept(Component.literal("\u00A76Learn Susano Release: Skeletal Susano \u00A74Cost: 20 JP"));
				list.accept(Component.literal("\u00A76Learn Susano Release: Humanoid Susano \u00A74Cost: 30 JP"));
				list.accept(Component.literal("\u00A76Learn Susano Release: Armored Susano \u00A74Cost: 40 JP"));
			}

			@Override
			public InteractionResult use(Level world, Player entity, InteractionHand hand) {
				InteractionResult ar = super.use(world, entity, hand);
				ItemStack itemstack = entity.getItemInHand(hand);
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();

				MangekyouSharinganMadaraReleaseRightclickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class MangekyouSharinganObitoReleaseItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "mangekyou_sharingan_obito_release", v -> block = (Item) v);
		}

		public MangekyouSharinganObitoReleaseItem(NarutoShippudenModElements instance) {
			super(instance, 594);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("mangekyou_sharingan_obito_release", "DojutsuItemGroup").stacksTo(1).rarity(Rarity.EPIC));
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
				list.accept(Component.literal("Right-Click to use release"));
				list.accept(Component.literal("Sneak and Right-Click to select or change release"));
				list.accept(Component.literal("\u00A78Kamui:"));
				list.accept(Component.literal("\u00A76Learn Kamui Release: Kamui Self-Teleportation \u00A74Cost: 20 JP"));
				list.accept(Component.literal("\u00A76Learn Kamui Release: Kamui Short-Range \u00A74Cost: 30 JP"));
				list.accept(Component.literal("\u00A76Learn Kamui Release: Kamui Phantom Phasing \u00A74Cost: 35 JP"));
				list.accept(Component.literal("\u00A7bSusano:"));
				list.accept(Component.literal("\u00A76Learn Susano Release: Ribcage \u00A74Cost: 10 JP"));
				list.accept(Component.literal("\u00A76Learn Susano Release: Skeletal Susano \u00A74Cost: 20 JP"));
				list.accept(Component.literal("\u00A76Learn Susano Release: Humanoid Susano \u00A74Cost: 30 JP"));
			}

			@Override
			public InteractionResult use(Level world, Player entity, InteractionHand hand) {
				InteractionResult ar = super.use(world, entity, hand);
				ItemStack itemstack = entity.getItemInHand(hand);
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();

				MangekyouSharinganObitoReleaseRightclickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class MangekyouSharinganSasukeReleaseItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "mangekyou_sharingan_sasuke_release", v -> block = (Item) v);
		}

		public MangekyouSharinganSasukeReleaseItem(NarutoShippudenModElements instance) {
			super(instance, 590);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("mangekyou_sharingan_sasuke_release", "DojutsuItemGroup").stacksTo(1).rarity(Rarity.EPIC));
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
				list.accept(Component.literal("Right-Click to use release"));
				list.accept(Component.literal("Sneak and Right-Click to select or change release"));
				list.accept(Component.literal("\u00A78Amaterasu:"));
				list.accept(Component.literal("\u00A76Learn Amaterasu Release: Amaterasu \u00A74Cost: 10 JP"));
				list.accept(Component.literal("\u00A76Learn Amaterasu Release: Blaze Release: Kagutsuchi \u00A74Cost: 15 JP"));
				list.accept(Component.literal("\u00A76Learn Amaterasu Release: Flame Wrapping Fire \u00A74Cost: 20 JP"));
				list.accept(Component.literal("\u00A76Learn Amaterasu Release: Blaze Release: Honoikazuchi \u00A74Cost: 25 JP"));
				list.accept(Component.literal("\u00A75Susano:"));
				list.accept(Component.literal("\u00A76Learn Susano Release: Ribcage \u00A74Cost: 10 JP"));
				list.accept(Component.literal("\u00A76Learn Susano Release: Skeletal Susano \u00A74Cost: 20 JP"));
				list.accept(Component.literal("\u00A76Learn Susano Release: Humanoid Susano \u00A74Cost: 30 JP"));
				list.accept(Component.literal("\u00A76Learn Susano Release: Armored Susano \u00A74Cost: 40 JP"));
			}

			@Override
			public InteractionResult use(Level world, Player entity, InteractionHand hand) {
				InteractionResult ar = super.use(world, entity, hand);
				ItemStack itemstack = entity.getItemInHand(hand);
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();

				MangekyouSharinganSasukeReleaseRightclickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class MangekyouSharinganShisuiReleaseItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "mangekyou_sharingan_shisui_release", v -> block = (Item) v);
		}

		public MangekyouSharinganShisuiReleaseItem(NarutoShippudenModElements instance) {
			super(instance, 593);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("mangekyou_sharingan_shisui_release", "DojutsuItemGroup").stacksTo(1).rarity(Rarity.EPIC));
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
				list.accept(Component.literal("\u00A72Susano:"));
				list.accept(Component.literal("\u00A76Learn Susano Release: Ribcage \u00A74Cost: 10 JP"));
				list.accept(Component.literal("\u00A76Learn Susano Release: Skeletal Susano \u00A74Cost: 20 JP"));
				list.accept(Component.literal("\u00A76Learn Susano Release: Humanoid Susano \u00A74Cost: 30 JP"));
				list.accept(Component.literal("\u00A76Learn Susano Release: Armored Susano \u00A74Cost: 40 JP"));
			}

			@Override
			public InteractionResult use(Level world, Player entity, InteractionHand hand) {
				InteractionResult ar = super.use(world, entity, hand);
				ItemStack itemstack = entity.getItemInHand(hand);
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();

				MangekyouSharinganShisuiReleaseRightclickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class RinneganReleaseItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "rinnegan_release", v -> block = (Item) v);
		}

		public RinneganReleaseItem(NarutoShippudenModElements instance) {
			super(instance, 769);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("rinnegan_release", "DojutsuItemGroup").stacksTo(1).rarity(Rarity.EPIC));
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
	public static class SharinganReleaseItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "sharingan_release", v -> block = (Item) v);
		}

		public SharinganReleaseItem(NarutoShippudenModElements instance) {
			super(instance, 333);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("sharingan_release", "DojutsuItemGroup").stacksTo(1).rarity(Rarity.EPIC));
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
				list.accept(Component.literal("\u00A76Learn Sharingan Release: Coercion Sharingan \u00A74Cost: 15 JP"));
				list.accept(Component.literal("\u00A76Learn Sharingan Release: Demonic Illusion: Mirage Crow \u00A74Cost: 20 JP"));
				list.accept(Component.literal("\u00A76Learn Sharingan Release: Demonic Illusion: Shackling Stakes Technique \u00A74Cost: 25 JP"));
				list.accept(Component.literal("\u00A76Learn Sharingan Release: Izanagi \u00A74Cost: 30 JP"));
			}

			@Override
			public InteractionResult use(Level world, Player entity, InteractionHand hand) {
				InteractionResult ar = super.use(world, entity, hand);
				ItemStack itemstack = entity.getItemInHand(hand);
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();

				SharinganReleaseRightclickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class TenseiganReleaseItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "tenseigan_release", v -> block = (Item) v);
		}

		public TenseiganReleaseItem(NarutoShippudenModElements instance) {
			super(instance, 799);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("tenseigan_release", "DojutsuItemGroup").stacksTo(1).rarity(Rarity.EPIC));
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
	public static class VolticModeReleaseItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "voltic_mode_release", v -> block = (Item) v);
		}

		public VolticModeReleaseItem(NarutoShippudenModElements instance) {
			super(instance, 583);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("voltic_mode_release", null).stacksTo(1).rarity(Rarity.EPIC));
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
				list.accept(Component.literal("\u00A76Learn Voltic Mode: Voltic Hammer \u00A74Cost: 25 JP"));
				list.accept(Component.literal("\u00A76Learn Voltic Mode: Voltic Execution \u00A74Cost: 35 JP"));
				list.accept(Component.literal("\u00A76Learn Voltic Mode: Voltic Thomas Cannon \u00A74Cost: 50 JP"));
			}

			@Override
			public InteractionResult use(Level world, Player entity, InteractionHand hand) {
				InteractionResult ar = super.use(world, entity, hand);
				ItemStack itemstack = entity.getItemInHand(hand);
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();

				VolticModeReleaseRightclickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class VolticModeTechniqueItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "voltic_mode_technique", v -> block = (Item) v);
		}

		public VolticModeTechniqueItem(NarutoShippudenModElements instance) {
			super(instance, 587);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("voltic_mode_technique", null).stacksTo(1).rarity(Rarity.COMMON));
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
				list.accept(Component.literal("\u00A72Voltic Hammer: \u00A7bChakra cost: 100 \u00A73Ninjutsu required: 15"));
				list.accept(Component.literal("\u00A72Voltic Execution: \u00A7bChakra cost: 450 \u00A73Ninjutsu required: 20"));
				list.accept(Component.literal("\u00A72Voltic Thomas Cannon: \u00A7bChakra cost: 500 \u00A73Ninjutsu required: 25"));
			}

			@Override
			public InteractionResult use(Level world, Player entity, InteractionHand hand) {
				InteractionResult ar = super.use(world, entity, hand);
				ItemStack itemstack = entity.getItemInHand(hand);
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();

				VolticModeTechniqueRightclickedProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z), new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}
}
