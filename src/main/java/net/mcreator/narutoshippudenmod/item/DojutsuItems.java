package net.mcreator.narutoshippudenmod.item;

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
import net.minecraft.util.math.EntityRayTraceResult;
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

public final class DojutsuItems {
	private DojutsuItems() {
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class ByakuganReleaseItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:byakugan_release")
		public static final Item block = null;

		public ByakuganReleaseItem(NarutoShippudenModElements instance) {
			super(instance, 363);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(new Item.Properties().group(DojutsuItemGroup.tab).maxStackSize(1).rarity(Rarity.EPIC));
				setRegistryName("byakugan_release");
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
	public static class CoercionSharinganItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:coercion_sharingan")
		public static final Item block = null;
		public static final EntityType arrow = (EntityType.Builder.<ArrowCustomEntity>create(ArrowCustomEntity::new, EntityClassification.MISC)
				.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).setCustomClientFactory(ArrowCustomEntity::new)
				.size(0.5f, 0.5f)).build("projectile_coercion_sharingan").setRegistryName("projectile_coercion_sharingan");

		public CoercionSharinganItem(NarutoShippudenModElements instance) {
			super(instance, 436);
			FMLJavaModLoadingContext.get().getModEventBus().register(new CoercionSharinganRenderer.ModelRegisterHandler());
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemRanged());
			elements.entities.add(() -> arrow);
		}

		public static class ItemRanged extends Item {
			public ItemRanged() {
				super(new Item.Properties().group(null).maxStackSize(0));
				setRegistryName("coercion_sharingan");
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
						ArrowCustomEntity entityarrow = shoot(world, entity, random, 12f, 1, 0);
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
			public void onEntityHit(EntityRayTraceResult entityRayTraceResult) {
				super.onEntityHit(entityRayTraceResult);
				Entity entity = entityRayTraceResult.getEntity();
				Entity sourceentity = this.func_234616_v_();
				Entity immediatesourceentity = this;
				double x = this.getPosX();
				double y = this.getPosY();
				double z = this.getPosZ();
				World world = this.world;

				CoercionSharinganProjectileHitsLivingEntityProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z), new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
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

				GreatFireballWhileProjectileFlyingTickProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("immediatesourceentity", immediatesourceentity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
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
			entityarrow.shoot(d1, d0 - entityarrow.getPosY() + (double) MathHelper.sqrt(d1 * d1 + d3 * d3) * 0.2F, d3, 12f * 2, 12.0F);
			entityarrow.setSilent(true);
			entityarrow.setDamage(1);
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
	public static class FuramingoganBeamItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:furamingogan_beam")
		public static final Item block = null;
		public static final EntityType arrow = (EntityType.Builder.<ArrowCustomEntity>create(ArrowCustomEntity::new, EntityClassification.MISC)
				.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).setCustomClientFactory(ArrowCustomEntity::new)
				.size(2.5f, 2.5f)).build("projectile_furamingogan_beam").setRegistryName("projectile_furamingogan_beam");

		public FuramingoganBeamItem(NarutoShippudenModElements instance) {
			super(instance, 704);
			FMLJavaModLoadingContext.get().getModEventBus().register(new FuramingoganBeamRenderer.ModelRegisterHandler());
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemRanged());
			elements.entities.add(() -> arrow);
		}

		public static class ItemRanged extends Item {
			public ItemRanged() {
				super(new Item.Properties().group(null).maxStackSize(0));
				setRegistryName("furamingogan_beam");
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
						ArrowCustomEntity entityarrow = shoot(world, entity, random, 4f, 1, 0);
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
			public void onEntityHit(EntityRayTraceResult entityRayTraceResult) {
				super.onEntityHit(entityRayTraceResult);
				Entity entity = entityRayTraceResult.getEntity();
				Entity sourceentity = this.func_234616_v_();
				Entity immediatesourceentity = this;
				double x = this.getPosX();
				double y = this.getPosY();
				double z = this.getPosZ();
				World world = this.world;

				FuramingoganBeamProjectileHitsLivingEntityProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
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

				GreatFireballWhileProjectileFlyingTickProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("immediatesourceentity", immediatesourceentity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
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
			entityarrow.shoot(d1, d0 - entityarrow.getPosY() + (double) MathHelper.sqrt(d1 * d1 + d3 * d3) * 0.2F, d3, 4f * 2, 12.0F);
			entityarrow.setSilent(true);
			entityarrow.setDamage(1);
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
	public static class FuramingoganReleaseItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:furamingogan_release")
		public static final Item block = null;

		public FuramingoganReleaseItem(NarutoShippudenModElements instance) {
			super(instance, 695);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(new Item.Properties().group(null).maxStackSize(1).rarity(Rarity.EPIC));
				setRegistryName("furamingogan_release");
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
				list.add(new StringTextComponent("\u00A76Learn Furamingogan Release: Furamingogan Secret Ritual \u00A74Cost: 15 JP"));
				list.add(new StringTextComponent("\u00A76Learn Furamingogan Release: Furamingogan Beam \u00A74Cost: 20 JP"));
				list.add(new StringTextComponent("\u00A76Learn Furamingogan Release: Furamingogan Jump \u00A74Cost: 25 JP"));
			}

			@Override
			public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
				ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
				ItemStack itemstack = ar.getResult();
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();

				FuramingoganReleaseRightclickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class FuramingoganTechniqueItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:furamingogan_technique")
		public static final Item block = null;

		public FuramingoganTechniqueItem(NarutoShippudenModElements instance) {
			super(instance, 701);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(new Item.Properties().group(null).maxStackSize(1).rarity(Rarity.COMMON));
				setRegistryName("furamingogan_technique");
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
				list.add(new StringTextComponent("\u00A72Furamingogan Secret Ritual: \u00A7bChakra cost: 150 \u00A73Ninjutsu required: 15"));
				list.add(new StringTextComponent("\u00A72Furamingogan Beam: \u00A7bChakra cost: 350 \u00A73Ninjutsu required: 20"));
				list.add(new StringTextComponent("\u00A72Furamingogan Jump: \u00A7bChakra cost: 500 \u00A73Ninjutsu required: 25"));
			}

			@Override
			public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
				ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
				ItemStack itemstack = ar.getResult();
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();

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
		@ObjectHolder("naruto_shippuden:isshiki_dojutsu_release")
		public static final Item block = null;

		public IsshikiDojutsuReleaseItem(NarutoShippudenModElements instance) {
			super(instance, 534);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(new Item.Properties().group(DojutsuItemGroup.tab).maxStackSize(1).rarity(Rarity.EPIC));
				setRegistryName("isshiki_dojutsu_release");
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
				list.add(new StringTextComponent("\u00A76Learn Isshiki Dojutsu Release: Sukunahikona \u00A74Cost: 25 JP"));
				list.add(new StringTextComponent("\u00A76Learn Isshiki Dojutsu Release: Disruption Cube \u00A74Cost: 40 JP"));
			}

			@Override
			public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
				ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
				ItemStack itemstack = ar.getResult();
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();

				IsshikiDojutsuReleaseRightclickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class KetsuryuganReleaseItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:ketsuryugan_release")
		public static final Item block = null;

		public KetsuryuganReleaseItem(NarutoShippudenModElements instance) {
			super(instance, 364);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(new Item.Properties().group(DojutsuItemGroup.tab).maxStackSize(1).rarity(Rarity.EPIC));
				setRegistryName("ketsuryugan_release");
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
	public static class MangekyouSharinganItachiReleaseItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:mangekyou_sharingan_itachi_release")
		public static final Item block = null;

		public MangekyouSharinganItachiReleaseItem(NarutoShippudenModElements instance) {
			super(instance, 592);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(new Item.Properties().group(DojutsuItemGroup.tab).maxStackSize(1).rarity(Rarity.EPIC));
				setRegistryName("mangekyou_sharingan_itachi_release");
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
				list.add(new StringTextComponent("Right-Click to use release"));
				list.add(new StringTextComponent("Sneak and Right-Click to select or change release"));
				list.add(new StringTextComponent("\u00A78Amaterasu:"));
				list.add(new StringTextComponent("\u00A76Learn Amaterasu Release: Amaterasu \u00A74Cost: 10 JP"));
				list.add(new StringTextComponent("\u00A7cSusano:"));
				list.add(new StringTextComponent("\u00A76Learn Susano Release: Ribcage \u00A74Cost: 10 JP"));
				list.add(new StringTextComponent("\u00A76Learn Susano Release: Skeletal Susano \u00A74Cost: 20 JP"));
				list.add(new StringTextComponent("\u00A76Learn Susano Release: Humanoid Susano \u00A74Cost: 30 JP"));
			}

			@Override
			public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
				ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
				ItemStack itemstack = ar.getResult();
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();

				MangekyouSharinganItachiReleaseRightclickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class MangekyouSharinganKakashiReleaseItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:mangekyou_sharingan_kakashi_release")
		public static final Item block = null;

		public MangekyouSharinganKakashiReleaseItem(NarutoShippudenModElements instance) {
			super(instance, 647);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(new Item.Properties().group(DojutsuItemGroup.tab).maxStackSize(1).rarity(Rarity.EPIC));
				setRegistryName("mangekyou_sharingan_kakashi_release");
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
				list.add(new StringTextComponent("\u00A78Kamui:"));
				list.add(new StringTextComponent("\u00A76Learn Kamui Release: Kamui Long-Range \u00A74Cost: 35 JP"));
			}

			@Override
			public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
				ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
				ItemStack itemstack = ar.getResult();
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();

				MangekyouSharinganKakashiReleaseRightclickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class MangekyouSharinganMadaraReleaseItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:mangekyou_sharingan_madara_release")
		public static final Item block = null;

		public MangekyouSharinganMadaraReleaseItem(NarutoShippudenModElements instance) {
			super(instance, 591);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(new Item.Properties().group(DojutsuItemGroup.tab).maxStackSize(1).rarity(Rarity.EPIC));
				setRegistryName("mangekyou_sharingan_madara_release");
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
				list.add(new StringTextComponent("\u00A71Susano:"));
				list.add(new StringTextComponent("\u00A76Learn Susano Release: Ribcage \u00A74Cost: 10 JP"));
				list.add(new StringTextComponent("\u00A76Learn Susano Release: Skeletal Susano \u00A74Cost: 20 JP"));
				list.add(new StringTextComponent("\u00A76Learn Susano Release: Humanoid Susano \u00A74Cost: 30 JP"));
				list.add(new StringTextComponent("\u00A76Learn Susano Release: Armored Susano \u00A74Cost: 40 JP"));
			}

			@Override
			public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
				ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
				ItemStack itemstack = ar.getResult();
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();

				MangekyouSharinganMadaraReleaseRightclickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class MangekyouSharinganObitoReleaseItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:mangekyou_sharingan_obito_release")
		public static final Item block = null;

		public MangekyouSharinganObitoReleaseItem(NarutoShippudenModElements instance) {
			super(instance, 594);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(new Item.Properties().group(DojutsuItemGroup.tab).maxStackSize(1).rarity(Rarity.EPIC));
				setRegistryName("mangekyou_sharingan_obito_release");
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
				list.add(new StringTextComponent("Right-Click to use release"));
				list.add(new StringTextComponent("Sneak and Right-Click to select or change release"));
				list.add(new StringTextComponent("\u00A78Kamui:"));
				list.add(new StringTextComponent("\u00A76Learn Kamui Release: Kamui Self-Teleportation \u00A74Cost: 20 JP"));
				list.add(new StringTextComponent("\u00A76Learn Kamui Release: Kamui Short-Range \u00A74Cost: 30 JP"));
				list.add(new StringTextComponent("\u00A76Learn Kamui Release: Kamui Phantom Phasing \u00A74Cost: 35 JP"));
				list.add(new StringTextComponent("\u00A7bSusano:"));
				list.add(new StringTextComponent("\u00A76Learn Susano Release: Ribcage \u00A74Cost: 10 JP"));
				list.add(new StringTextComponent("\u00A76Learn Susano Release: Skeletal Susano \u00A74Cost: 20 JP"));
				list.add(new StringTextComponent("\u00A76Learn Susano Release: Humanoid Susano \u00A74Cost: 30 JP"));
			}

			@Override
			public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
				ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
				ItemStack itemstack = ar.getResult();
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();

				MangekyouSharinganObitoReleaseRightclickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class MangekyouSharinganSasukeReleaseItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:mangekyou_sharingan_sasuke_release")
		public static final Item block = null;

		public MangekyouSharinganSasukeReleaseItem(NarutoShippudenModElements instance) {
			super(instance, 590);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(new Item.Properties().group(DojutsuItemGroup.tab).maxStackSize(1).rarity(Rarity.EPIC));
				setRegistryName("mangekyou_sharingan_sasuke_release");
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
				list.add(new StringTextComponent("Right-Click to use release"));
				list.add(new StringTextComponent("Sneak and Right-Click to select or change release"));
				list.add(new StringTextComponent("\u00A78Amaterasu:"));
				list.add(new StringTextComponent("\u00A76Learn Amaterasu Release: Amaterasu \u00A74Cost: 10 JP"));
				list.add(new StringTextComponent("\u00A76Learn Amaterasu Release: Blaze Release: Kagutsuchi \u00A74Cost: 15 JP"));
				list.add(new StringTextComponent("\u00A76Learn Amaterasu Release: Flame Wrapping Fire \u00A74Cost: 20 JP"));
				list.add(new StringTextComponent("\u00A76Learn Amaterasu Release: Blaze Release: Honoikazuchi \u00A74Cost: 25 JP"));
				list.add(new StringTextComponent("\u00A75Susano:"));
				list.add(new StringTextComponent("\u00A76Learn Susano Release: Ribcage \u00A74Cost: 10 JP"));
				list.add(new StringTextComponent("\u00A76Learn Susano Release: Skeletal Susano \u00A74Cost: 20 JP"));
				list.add(new StringTextComponent("\u00A76Learn Susano Release: Humanoid Susano \u00A74Cost: 30 JP"));
				list.add(new StringTextComponent("\u00A76Learn Susano Release: Armored Susano \u00A74Cost: 40 JP"));
			}

			@Override
			public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
				ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
				ItemStack itemstack = ar.getResult();
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();

				MangekyouSharinganSasukeReleaseRightclickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class MangekyouSharinganShisuiReleaseItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:mangekyou_sharingan_shisui_release")
		public static final Item block = null;

		public MangekyouSharinganShisuiReleaseItem(NarutoShippudenModElements instance) {
			super(instance, 593);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(new Item.Properties().group(DojutsuItemGroup.tab).maxStackSize(1).rarity(Rarity.EPIC));
				setRegistryName("mangekyou_sharingan_shisui_release");
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
				list.add(new StringTextComponent("\u00A72Susano:"));
				list.add(new StringTextComponent("\u00A76Learn Susano Release: Ribcage \u00A74Cost: 10 JP"));
				list.add(new StringTextComponent("\u00A76Learn Susano Release: Skeletal Susano \u00A74Cost: 20 JP"));
				list.add(new StringTextComponent("\u00A76Learn Susano Release: Humanoid Susano \u00A74Cost: 30 JP"));
				list.add(new StringTextComponent("\u00A76Learn Susano Release: Armored Susano \u00A74Cost: 40 JP"));
			}

			@Override
			public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
				ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
				ItemStack itemstack = ar.getResult();
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();

				MangekyouSharinganShisuiReleaseRightclickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class RinneganReleaseItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:rinnegan_release")
		public static final Item block = null;

		public RinneganReleaseItem(NarutoShippudenModElements instance) {
			super(instance, 769);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(new Item.Properties().group(DojutsuItemGroup.tab).maxStackSize(1).rarity(Rarity.EPIC));
				setRegistryName("rinnegan_release");
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
	public static class SharinganReleaseItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:sharingan_release")
		public static final Item block = null;

		public SharinganReleaseItem(NarutoShippudenModElements instance) {
			super(instance, 333);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(new Item.Properties().group(DojutsuItemGroup.tab).maxStackSize(1).rarity(Rarity.EPIC));
				setRegistryName("sharingan_release");
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
				list.add(new StringTextComponent("\u00A76Learn Sharingan Release: Coercion Sharingan \u00A74Cost: 15 JP"));
				list.add(new StringTextComponent("\u00A76Learn Sharingan Release: Demonic Illusion: Mirage Crow \u00A74Cost: 20 JP"));
				list.add(new StringTextComponent("\u00A76Learn Sharingan Release: Demonic Illusion: Shackling Stakes Technique \u00A74Cost: 25 JP"));
				list.add(new StringTextComponent("\u00A76Learn Sharingan Release: Izanagi \u00A74Cost: 30 JP"));
			}

			@Override
			public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
				ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
				ItemStack itemstack = ar.getResult();
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();

				SharinganReleaseRightclickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class TenseiganReleaseItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:tenseigan_release")
		public static final Item block = null;

		public TenseiganReleaseItem(NarutoShippudenModElements instance) {
			super(instance, 799);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(new Item.Properties().group(DojutsuItemGroup.tab).maxStackSize(1).rarity(Rarity.EPIC));
				setRegistryName("tenseigan_release");
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
	public static class VolticModeReleaseItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:voltic_mode_release")
		public static final Item block = null;

		public VolticModeReleaseItem(NarutoShippudenModElements instance) {
			super(instance, 583);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(new Item.Properties().group(null).maxStackSize(1).rarity(Rarity.EPIC));
				setRegistryName("voltic_mode_release");
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
				list.add(new StringTextComponent("\u00A76Learn Voltic Mode: Voltic Hammer \u00A74Cost: 25 JP"));
				list.add(new StringTextComponent("\u00A76Learn Voltic Mode: Voltic Execution \u00A74Cost: 35 JP"));
				list.add(new StringTextComponent("\u00A76Learn Voltic Mode: Voltic Thomas Cannon \u00A74Cost: 50 JP"));
			}

			@Override
			public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
				ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
				ItemStack itemstack = ar.getResult();
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();

				VolticModeReleaseRightclickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class VolticModeTechniqueItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:voltic_mode_technique")
		public static final Item block = null;

		public VolticModeTechniqueItem(NarutoShippudenModElements instance) {
			super(instance, 587);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(new Item.Properties().group(null).maxStackSize(1).rarity(Rarity.COMMON));
				setRegistryName("voltic_mode_technique");
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
				list.add(new StringTextComponent("\u00A72Voltic Hammer: \u00A7bChakra cost: 100 \u00A73Ninjutsu required: 15"));
				list.add(new StringTextComponent("\u00A72Voltic Execution: \u00A7bChakra cost: 450 \u00A73Ninjutsu required: 20"));
				list.add(new StringTextComponent("\u00A72Voltic Thomas Cannon: \u00A7bChakra cost: 500 \u00A73Ninjutsu required: 25"));
			}

			@Override
			public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
				ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
				ItemStack itemstack = ar.getResult();
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();

				VolticModeTechniqueRightclickedProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z), new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				return ar;
			}
		}
	}
}
