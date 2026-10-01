package net.mcreator.narutoshippudenmod.world.chikyu;

import net.mcreator.narutoshippudenmod.compat.Registration;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUseAnimation;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;

import java.util.function.Consumer;

/**
 * The toriis' things: the green light filling each torii's passage ({@link ToriiPortalBlock}, so players see it is a
 * way through), and the Leaf Return Scroll, given on the way out to the overworld: read for five seconds (taking a hit
 * breaks the reading) it brings the reader back to the Leaf's gate, once every five minutes, from the overworld only.
 */
@EventBusSubscriber(modid = "naruto_shippuden")
public final class ChikyuContent {
	public static Block TORII_PORTAL;
	public static Item RETURN_SCROLL;
	static final int READ_TICKS = 100, COOLDOWN_TICKS = 6000;

	private ChikyuContent() {
	}

	public static void register() {
		Registration.add(Registries.BLOCK, "torii_portal", () -> new ToriiPortalBlock(Registration.blockProps("torii_portal",
				BlockBehaviour.Properties.of().noCollision().noOcclusion().noLootTable().strength(-1.0F, 3600000.0F).sound(SoundType.GLASS)
						.lightLevel(s -> 11).pushReaction(PushReaction.IMMOVEABLE))), h -> TORII_PORTAL = h.value());
		Registration.add(Registries.ITEM, "leaf_return_scroll", () -> new ReturnScroll(Registration.itemProps("leaf_return_scroll").stacksTo(1)),
				h -> RETURN_SCROLL = h.value());
	}

	/** The torii's light: thin, walk-through, unbreakable, giving off green sparkles. */
	public static class ToriiPortalBlock extends Block {
		private static final VoxelShape SHAPE = Block.box(0, 0, 6, 16, 16, 10);

		public ToriiPortalBlock(BlockBehaviour.Properties properties) {
			super(properties);
		}

		@Override
		protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
			return SHAPE;
		}

		@Override
		protected boolean propagatesSkylightDown(BlockState state) {
			return true;
		}

		@Override
		public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
			if (random.nextInt(3) == 0)
				level.addParticle(ParticleTypes.HAPPY_VILLAGER, pos.getX() + random.nextDouble(), pos.getY() + random.nextDouble(),
						pos.getZ() + 0.3 + random.nextDouble() * 0.4, 0, 0.02, 0);
			if (random.nextInt(200) == 0)
				level.playLocalSound(pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, SoundEvents.AMETHYST_BLOCK_CHIME, SoundSource.BLOCKS, 0.4f,
						0.6f + random.nextFloat() * 0.3f, false);
		}
	}

	/** The Leaf Return Scroll. */
	public static class ReturnScroll extends Item {
		public ReturnScroll(Item.Properties properties) {
			super(properties);
		}

		@Override
		public InteractionResult use(Level level, Player player, InteractionHand hand) {
			if (level.dimension() != Level.OVERWORLD) {
				player.sendOverlayMessage(Component.translatable("item.naruto_shippuden.leaf_return_scroll.only_overworld").withStyle(ChatFormatting.RED));
				return InteractionResult.FAIL;
			}
			player.startUsingItem(hand);
			return InteractionResult.CONSUME;
		}

		@Override
		public int getUseDuration(ItemStack stack, LivingEntity user) {
			return READ_TICKS;
		}

		@Override
		public ItemUseAnimation getUseAnimation(ItemStack stack) {
			return ItemUseAnimation.BOW;
		}

		@Override
		public void onUseTick(Level level, LivingEntity user, ItemStack stack, int ticksRemaining) {
			if (level instanceof ServerLevel server && ticksRemaining % 4 == 0)
				server.sendParticles(ParticleTypes.HAPPY_VILLAGER, user.getX(), user.getY() + 1.0, user.getZ(), 3, 0.5, 0.7, 0.5, 0.0);
		}

		@Override
		public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity user) {
			if (user instanceof ServerPlayer player && level.dimension() == Level.OVERWORLD) {
				player.getCooldowns().addCooldown(stack, COOLDOWN_TICKS);
				Chikyu.backToTheLeaf(player);
			}
			return stack;
		}

		@Override
		public void appendHoverText(ItemStack stack, Item.TooltipContext context, TooltipDisplay display, Consumer<Component> builder, TooltipFlag flag) {
			builder.accept(Component.translatable("item.naruto_shippuden.leaf_return_scroll.desc").withStyle(ChatFormatting.GRAY));
		}
	}

	/** Taking a hit breaks the scroll's reading. */
	@SubscribeEvent
	public static void onHurt(LivingDamageEvent.Post event) {
		if (event.getEntity() instanceof ServerPlayer player && player.isUsingItem() && player.getUseItem().getItem() == RETURN_SCROLL) {
			player.stopUsingItem();
			player.sendOverlayMessage(Component.translatable("item.naruto_shippuden.leaf_return_scroll.broken").withStyle(ChatFormatting.RED));
		}
	}
}
