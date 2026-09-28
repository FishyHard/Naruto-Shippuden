package net.mcreator.narutoshippudenmod.economy;

import net.mcreator.narutoshippudenmod.NarutoShippudenMod;
import net.mcreator.narutoshippudenmod.NarutoShippudenModElements;
import net.mcreator.narutoshippudenmod.compat.Registration;

import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.SpawnPlacementTypes;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.InteractGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.LookAtTradingPlayerGoal;
import net.minecraft.world.entity.ai.goal.MoveTowardsRestrictionGoal;
import net.minecraft.world.entity.ai.goal.PanicGoal;
import net.minecraft.world.entity.ai.goal.TradeWithPlayerGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.village.poi.PoiManager;
import net.minecraft.world.entity.ai.village.poi.PoiTypes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.npc.villager.AbstractVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.item.trading.MerchantOffers;
import net.minecraft.world.item.trading.TradeSet;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.event.tick.LevelTickEvent;

import java.util.List;

import org.jspecify.annotations.Nullable;

/**
 * The Shinobi Merchant: a travelling trader who sells ninja tools, weapons, armor and food for Ryo and buys mob loot. Like the
 * wandering trader he turns up near a player (at the village bell when there is one) every day or so and leaves after two days.
 */
@NarutoShippudenModElements.ModElement.Tag
public class ShinobiMerchant extends NarutoShippudenModElements.ModElement {
	public static EntityType<Merchant> entity;
	private static final String[] TRADE_SETS = { "tools", "weapons", "headbands", "food", "buying" };
	private static int spawnDelay = 24000;
	private static int spawnChance = 25;

	public ShinobiMerchant(NarutoShippudenModElements instance) {
		super(instance, 5000);
		Registration.listen(NarutoShippudenMod.MOD_BUS, this);
		NeoForge.EVENT_BUS.addListener(ShinobiMerchant::tick);
	}

	@Override
	public void initElements() {
		elements.entities.add(() -> entity = EntityType.Builder.<Merchant>of(Merchant::new, MobCategory.CREATURE).sized(0.6F, 1.95F).clientTrackingRange(10)
				.build(Registration.entityKey("shinobi_merchant")));
		elements.items.add(() -> new SpawnEggItem(Registration.itemProps("shinobi_merchant_spawn_egg", "SpawnEggsItemGroup").spawnEgg(entity)));
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
	}

	@SubscribeEvent
	public void attributes(EntityAttributeCreationEvent event) {
		event.put(entity, Mob.createMobAttributes().add(Attributes.MOVEMENT_SPEED, 0.5).add(Attributes.MAX_HEALTH, 20).build());
	}

	private static ResourceKey<TradeSet> tradeSet(String name) {
		return ResourceKey.create(Registries.TRADE_SET, Identifier.fromNamespaceAndPath(NarutoShippudenMod.MODID, "shinobi_merchant/" + name));
	}

	// ------------------------------------------------------------------ spawning, like WanderingTraderSpawner
	private static void tick(LevelTickEvent.Post event) {
		if (!(event.getLevel() instanceof ServerLevel level) || level.dimension() != Level.OVERWORLD || level.getGameTime() % 1200 != 0)
			return;
		if ((spawnDelay -= 1200) > 0)
			return;
		spawnDelay = 24000;
		if (level.getRandom().nextInt(100) >= spawnChance) {
			spawnChance = Math.min(spawnChance + 25, 75);
			return;
		}
		List<ServerPlayer> players = level.players();
		if (players.isEmpty())
			return;
		ServerPlayer player = players.get(level.getRandom().nextInt(players.size()));
		if (!level.getEntities(entity, player.getBoundingBox().inflate(128), e -> true).isEmpty())
			return;
		BlockPos centre = level.getPoiManager().find(p -> p.is(PoiTypes.MEETING), p -> true, player.blockPosition(), 48, PoiManager.Occupancy.ANY)
				.orElse(player.blockPosition());
		for (int i = 0; i < 10; i++) {
			int x = centre.getX() + level.getRandom().nextInt(64) - 32, z = centre.getZ() + level.getRandom().nextInt(64) - 32;
			BlockPos pos = new BlockPos(x, level.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, x, z), z);
			if (SpawnPlacementTypes.ON_GROUND.isSpawnPositionOk(level, pos, entity) && level.noCollision(entity.getSpawnAABB(pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5))) {
				Merchant merchant = entity.spawn(level, pos, EntitySpawnReason.EVENT);
				if (merchant != null) {
					merchant.despawnDelay = 48000;
					merchant.setHomeTo(centre, 16);
					spawnChance = 25;
				}
				return;
			}
		}
	}

	public static class Merchant extends AbstractVillager {
		private int despawnDelay;

		public Merchant(EntityType<? extends Merchant> type, Level level) {
			super(type, level);
		}

		@Override
		protected void registerGoals() {
			goalSelector.addGoal(0, new FloatGoal(this));
			goalSelector.addGoal(1, new TradeWithPlayerGoal(this));
			goalSelector.addGoal(1, new AvoidEntityGoal<>(this, Monster.class, 8.0F, 0.5, 0.5));
			goalSelector.addGoal(1, new PanicGoal(this, 0.5));
			goalSelector.addGoal(1, new LookAtTradingPlayerGoal(this));
			goalSelector.addGoal(4, new MoveTowardsRestrictionGoal(this, 0.35));
			goalSelector.addGoal(8, new WaterAvoidingRandomStrollGoal(this, 0.35));
			goalSelector.addGoal(9, new InteractGoal(this, Player.class, 3.0F, 1.0F));
			goalSelector.addGoal(10, new LookAtPlayerGoal(this, Mob.class, 8.0F));
		}

		@Override
		public @Nullable AgeableMob getBreedOffspring(ServerLevel level, AgeableMob partner) {
			return null;
		}

		@Override
		public boolean showProgressBar() {
			return false;
		}

		@Override
		public InteractionResult mobInteract(Player player, InteractionHand hand) {
			if (!isAlive() || isTrading() || isBaby())
				return super.mobInteract(player, hand);
			if (hand == InteractionHand.MAIN_HAND)
				player.awardStat(Stats.TALKED_TO_VILLAGER);
			if (!level().isClientSide() && !getOffers().isEmpty()) {
				setTradingPlayer(player);
				openTradingScreen(player, getDisplayName(), 1);
			}
			return InteractionResult.SUCCESS_SERVER;
		}

		@Override
		protected void updateTrades(ServerLevel level) {
			MerchantOffers offers = getOffers();
			for (String name : TRADE_SETS)
				addOffersFromTradeSet(level, offers, tradeSet(name));
			// a legendary blade now and then
			if (random.nextInt(5) < 2)
				addOffersFromTradeSet(level, offers, tradeSet("rare"));
		}

		@Override
		protected void rewardTradeXp(MerchantOffer offer) {
		}

		@Override
		public void aiStep() {
			super.aiStep();
			if (!level().isClientSide() && despawnDelay > 0 && !isTrading() && --despawnDelay == 0)
				discard();
		}

		@Override
		protected void addAdditionalSaveData(ValueOutput output) {
			super.addAdditionalSaveData(output);
			output.putInt("DespawnDelay", despawnDelay);
		}

		@Override
		protected void readAdditionalSaveData(ValueInput input) {
			super.readAdditionalSaveData(input);
			despawnDelay = input.getIntOr("DespawnDelay", 0);
		}

		@Override
		public boolean removeWhenFarAway(double distSqr) {
			return false;
		}

		@Override
		protected SoundEvent getAmbientSound() {
			return isTrading() ? SoundEvents.WANDERING_TRADER_TRADE : SoundEvents.WANDERING_TRADER_AMBIENT;
		}

		@Override
		protected SoundEvent getHurtSound(DamageSource source) {
			return SoundEvents.WANDERING_TRADER_HURT;
		}

		@Override
		protected SoundEvent getDeathSound() {
			return SoundEvents.WANDERING_TRADER_DEATH;
		}

		@Override
		protected SoundEvent getTradeUpdatedSound(boolean validTrade) {
			return validTrade ? SoundEvents.WANDERING_TRADER_YES : SoundEvents.WANDERING_TRADER_NO;
		}

		@Override
		public SoundEvent getNotifyTradeSound() {
			return SoundEvents.WANDERING_TRADER_YES;
		}
	}
}
