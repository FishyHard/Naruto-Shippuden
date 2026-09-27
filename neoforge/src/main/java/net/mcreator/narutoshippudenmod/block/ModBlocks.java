package net.mcreator.narutoshippudenmod.block;

import net.mcreator.narutoshippudenmod.compat.Compat;
import net.minecraft.util.RandomSource;
import net.minecraft.core.registries.Registries;
import net.mcreator.narutoshippudenmod.compat.Registration;
import net.mcreator.narutoshippudenmod.NarutoShippudenMod;
import net.mcreator.narutoshippudenmod.compat.StackTag;

import java.util.AbstractMap;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import javax.annotation.Nullable;
import net.mcreator.narutoshippudenmod.NarutoShippudenModElements;
import net.mcreator.narutoshippudenmod.itemgroup.ModItemGroups.BlocksItemGroup;
import net.mcreator.narutoshippudenmod.procedures.ClanProcedures.NaraShadowUpdateTickProcedure;
import net.mcreator.narutoshippudenmod.procedures.JutsuEffectProcedures.AmaterasuBlockAddedProcedure;
import net.mcreator.narutoshippudenmod.procedures.JutsuEffectProcedures.AmaterasuEntityCollidesInTheBlockProcedure;
import net.mcreator.narutoshippudenmod.procedures.JutsuEffectProcedures.AmaterasuUpdateTickProcedure;
import net.mcreator.narutoshippudenmod.procedures.JutsuEffectProcedures.AmaterasuUpdateTickSpreadProcedure;
import net.mcreator.narutoshippudenmod.procedures.JutsuEffectProcedures.EarthWallBlockAddedProcedure;
import net.mcreator.narutoshippudenmod.procedures.JutsuEffectProcedures.WaterwallEntityCollidesInTheBlockProcedure;
import net.mcreator.narutoshippudenmod.procedures.KekkeiGenkaiProcedures.DustBlockBlockAddedProcedure;
import net.mcreator.narutoshippudenmod.procedures.KekkeiGenkaiProcedures.DustBlockView2BlockAddedProcedure;
import net.mcreator.narutoshippudenmod.procedures.KekkeiGenkaiProcedures.DustBlockView3BlockAddedProcedure;
import net.mcreator.narutoshippudenmod.procedures.KekkeiGenkaiProcedures.DustBlockViewBlockAddedProcedure;
import net.mcreator.narutoshippudenmod.procedures.WeaponProcedures.PaperBombEntityWalksOnTheBlockProcedure;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.client.resources.model.sprite.Material;
import net.minecraft.client.renderer.rendertype.RenderType;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.WorldlyContainer;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.inventory.ChestMenu;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.entity.RandomizableContainerBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.core.NonNullList;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.Vec3;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.server.level.ServerLevel;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;


import net.neoforged.neoforge.common.util.DeferredSoundType;


import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.entity.InsideBlockEffectApplier;

public final class ModBlocks {
	private ModBlocks() {
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class AmaterasuBlock extends NarutoShippudenModElements.ModElement {
				public static Block block;
		static {
			Registration.holder(Registries.BLOCK, "amaterasu", v -> block = (Block) v);
		}
				public static BlockEntityType<CustomTileEntity> tileEntityType;
		static {
			Registration.holder(Registries.BLOCK_ENTITY_TYPE, "amaterasu", v -> tileEntityType = (BlockEntityType<CustomTileEntity>) v);
		}

		public AmaterasuBlock(NarutoShippudenModElements instance) {
			super(instance, 1203);
			Registration.add(Registries.BLOCK_ENTITY_TYPE, "amaterasu", () -> new BlockEntityType<>(CustomTileEntity::new, block), null);
		}

		@Override
		public void initElements() {
			elements.blocks.add(() -> new CustomBlock());
			elements.items.add(() -> new BlockItem(block, Registration.itemProps("amaterasu", null).useBlockDescriptionPrefix()));
		}

		public static class CustomBlock extends Block implements EntityBlock {
			public CustomBlock() {
				super(Registration.blockProps("amaterasu", BlockBehaviour.Properties.of().replaceable()
						.sound(new DeferredSoundType(1.0f, 1.0f, () -> Compat.sound("block.fire.ambient"),
								() -> Compat.sound("block.fire.ambient"),
								() -> Compat.sound("block.fire.ambient"),
								() -> Compat.sound("entity.player.hurt_on_fire"),
								() -> Compat.sound("block.fire.ambient")))
						.strength(-1, 3600000).lightLevel(s -> 0).noCollision().noOcclusion().isRedstoneConductor((bs, br, bp) -> false)));
			}

			@Override
			protected boolean propagatesSkylightDown(BlockState state) {
				return true;
			}

			@Override
			protected int getLightDampening(BlockState state) {
				return 0;
			}

			@Override
			public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
				Vec3 offset = state.getOffset(pos);
				return Shapes.or(box(0, 0, 0, 16, 1, 16))

						.move(offset.x, offset.y, offset.z);
			}

			@Override
			public List<ItemStack> getDrops(BlockState state, LootParams.Builder builder) {
				List<ItemStack> dropsOriginal = super.getDrops(state, builder);
				if (!dropsOriginal.isEmpty())
					return dropsOriginal;
				return Collections.singletonList(new ItemStack(this, 1));
			}

			@Override
			public void onPlace(BlockState blockstate, Level world, BlockPos pos, BlockState oldState, boolean moving) {
				super.onPlace(blockstate, world, pos, oldState, moving);
				int x = pos.getX();
				int y = pos.getY();
				int z = pos.getZ();
				world.scheduleTick(pos, this, 1);

				AmaterasuBlockAddedProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}

			@Override
			public void tick(BlockState blockstate, ServerLevel world, BlockPos pos, RandomSource random) {
				super.tick(blockstate, world, pos, random);
				int x = pos.getX();
				int y = pos.getY();
				int z = pos.getZ();

				AmaterasuUpdateTickSpreadProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				world.scheduleTick(pos, this, 1);
			}

			@Override
			protected void entityInside(BlockState blockstate, Level world, BlockPos pos, Entity entity, InsideBlockEffectApplier effectApplier, boolean isPrecise) {
				super.entityInside(blockstate, world, pos, entity, effectApplier, isPrecise);
				int x = pos.getX();
				int y = pos.getY();
				int z = pos.getZ();

				AmaterasuEntityCollidesInTheBlockProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}

			@Override
			public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
				return new CustomTileEntity(pos, state);
			}
		}

		public static class CustomTileEntity extends BlockEntity {
			public CustomTileEntity(BlockPos pos, BlockState state) {
				super(tileEntityType, pos, state);
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class AmaterasuSpreadBlock extends NarutoShippudenModElements.ModElement {
				public static Block block;
		static {
			Registration.holder(Registries.BLOCK, "amaterasu_spread", v -> block = (Block) v);
		}
				public static BlockEntityType<CustomTileEntity> tileEntityType;
		static {
			Registration.holder(Registries.BLOCK_ENTITY_TYPE, "amaterasu_spread", v -> tileEntityType = (BlockEntityType<CustomTileEntity>) v);
		}

		public AmaterasuSpreadBlock(NarutoShippudenModElements instance) {
			super(instance, 1208);
			Registration.add(Registries.BLOCK_ENTITY_TYPE, "amaterasu_spread", () -> new BlockEntityType<>(CustomTileEntity::new, block), null);
		}

		@Override
		public void initElements() {
			elements.blocks.add(() -> new CustomBlock());
			elements.items.add(() -> new BlockItem(block, Registration.itemProps("amaterasu_spread", null).useBlockDescriptionPrefix()));
		}

		public static class CustomBlock extends Block implements EntityBlock {
			public CustomBlock() {
				super(Registration.blockProps("amaterasu_spread", BlockBehaviour.Properties.of().replaceable()
						.sound(new DeferredSoundType(1.0f, 1.0f, () -> Compat.sound("block.fire.ambient"),
								() -> Compat.sound("block.fire.ambient"),
								() -> Compat.sound("block.fire.ambient"),
								() -> Compat.sound("entity.player.hurt_on_fire"),
								() -> Compat.sound("block.fire.ambient")))
						.strength(-1, 3600000).lightLevel(s -> 0).noCollision().noOcclusion().isRedstoneConductor((bs, br, bp) -> false)));
			}

			@Override
			protected boolean propagatesSkylightDown(BlockState state) {
				return true;
			}

			@Override
			protected int getLightDampening(BlockState state) {
				return 0;
			}

			@Override
			public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
				Vec3 offset = state.getOffset(pos);
				return Shapes.or(box(0, 0, 0, 16, 1, 16))

						.move(offset.x, offset.y, offset.z);
			}

			@Override
			public List<ItemStack> getDrops(BlockState state, LootParams.Builder builder) {
				List<ItemStack> dropsOriginal = super.getDrops(state, builder);
				if (!dropsOriginal.isEmpty())
					return dropsOriginal;
				return Collections.singletonList(new ItemStack(this, 1));
			}

			@Override
			public void onPlace(BlockState blockstate, Level world, BlockPos pos, BlockState oldState, boolean moving) {
				super.onPlace(blockstate, world, pos, oldState, moving);
				int x = pos.getX();
				int y = pos.getY();
				int z = pos.getZ();
				world.scheduleTick(pos, this, 1);

				AmaterasuBlockAddedProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}

			@Override
			public void tick(BlockState blockstate, ServerLevel world, BlockPos pos, RandomSource random) {
				super.tick(blockstate, world, pos, random);
				int x = pos.getX();
				int y = pos.getY();
				int z = pos.getZ();

				AmaterasuUpdateTickProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				world.scheduleTick(pos, this, 1);
			}

			@Override
			protected void entityInside(BlockState blockstate, Level world, BlockPos pos, Entity entity, InsideBlockEffectApplier effectApplier, boolean isPrecise) {
				super.entityInside(blockstate, world, pos, entity, effectApplier, isPrecise);
				int x = pos.getX();
				int y = pos.getY();
				int z = pos.getZ();

				AmaterasuEntityCollidesInTheBlockProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}

			@Override
			public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
				return new CustomTileEntity(pos, state);
			}
		}

		public static class CustomTileEntity extends BlockEntity {
			public CustomTileEntity(BlockPos pos, BlockState state) {
				super(tileEntityType, pos, state);
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class DustBlockBlock extends NarutoShippudenModElements.ModElement {
				public static Block block;
		static {
			Registration.holder(Registries.BLOCK, "dust_block", v -> block = (Block) v);
		}

		public DustBlockBlock(NarutoShippudenModElements instance) {
			super(instance, 1070);
		}

		@Override
		public void initElements() {
			elements.blocks.add(() -> new CustomBlock());
			elements.items.add(() -> new BlockItem(block, Registration.itemProps("dust_block", null).useBlockDescriptionPrefix()));
		}

		public static class CustomBlock extends Block {
			public static final EnumProperty<Direction> FACING = HorizontalDirectionalBlock.FACING;

			public CustomBlock() {
				super(Registration.blockProps("dust_block", BlockBehaviour.Properties.of().replaceable()
						.sound(new DeferredSoundType(1.0f, 1.0f, () -> Compat.sound("naruto_shippuden:dust_release"),
								() -> Compat.sound("naruto_shippuden:dust_release"),
								() -> Compat.sound("naruto_shippuden:dust_release"),
								() -> Compat.sound("naruto_shippuden:dust_release"),
								() -> Compat.sound("naruto_shippuden:dust_release")))
						.strength(-1, 3600000).lightLevel(s -> 0).noOcclusion().isRedstoneConductor((bs, br, bp) -> false)));
				this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean skipRendering(BlockState state, BlockState adjacentBlockState, Direction side) {
				return adjacentBlockState.getBlock() == this ? true : super.skipRendering(state, adjacentBlockState, side);
			}

			@Override
			protected boolean propagatesSkylightDown(BlockState state) {
				return true;
			}

			@Override
			protected int getLightDampening(BlockState state) {
				return 0;
			}

			@Override
			protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
				builder.add(FACING);
			}

			@Override
			public BlockState getStateForPlacement(BlockPlaceContext context) {
				return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
			}

			public BlockState rotate(BlockState state, Rotation rot) {
				return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
			}

			public BlockState mirror(BlockState state, Mirror mirrorIn) {
				return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
			}

			@Override
			public List<ItemStack> getDrops(BlockState state, LootParams.Builder builder) {
				List<ItemStack> dropsOriginal = super.getDrops(state, builder);
				if (!dropsOriginal.isEmpty())
					return dropsOriginal;
				return Collections.singletonList(new ItemStack(this, 0));
			}

			@Override
			public void onPlace(BlockState blockstate, Level world, BlockPos pos, BlockState oldState, boolean moving) {
				super.onPlace(blockstate, world, pos, oldState, moving);
				int x = pos.getX();
				int y = pos.getY();
				int z = pos.getZ();

				DustBlockBlockAddedProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class DustBlockView2Block extends NarutoShippudenModElements.ModElement {
				public static Block block;
		static {
			Registration.holder(Registries.BLOCK, "dust_block_view_2", v -> block = (Block) v);
		}

		public DustBlockView2Block(NarutoShippudenModElements instance) {
			super(instance, 1074);
		}

		@Override
		public void initElements() {
			elements.blocks.add(() -> new CustomBlock());
			elements.items.add(() -> new BlockItem(block, Registration.itemProps("dust_block_view_2", null).useBlockDescriptionPrefix()));
		}

		public static class CustomBlock extends Block {
			public static final EnumProperty<Direction> FACING = HorizontalDirectionalBlock.FACING;

			public CustomBlock() {
				super(Registration.blockProps("dust_block_view_2", BlockBehaviour.Properties.of().replaceable()
						.sound(new DeferredSoundType(1.0f, 1.0f, () -> Compat.sound("naruto_shippuden:dust_release"),
								() -> Compat.sound("naruto_shippuden:dust_release"),
								() -> Compat.sound("naruto_shippuden:dust_release"),
								() -> Compat.sound("naruto_shippuden:dust_release"),
								() -> Compat.sound("naruto_shippuden:dust_release")))
						.strength(-1, 3600000).lightLevel(s -> 0).noOcclusion().isRedstoneConductor((bs, br, bp) -> false)));
				this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean skipRendering(BlockState state, BlockState adjacentBlockState, Direction side) {
				return adjacentBlockState.getBlock() == this ? true : super.skipRendering(state, adjacentBlockState, side);
			}

			@Override
			protected boolean propagatesSkylightDown(BlockState state) {
				return true;
			}

			@Override
			protected int getLightDampening(BlockState state) {
				return 0;
			}

			@Override
			protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
				builder.add(FACING);
			}

			@Override
			public BlockState getStateForPlacement(BlockPlaceContext context) {
				return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
			}

			public BlockState rotate(BlockState state, Rotation rot) {
				return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
			}

			public BlockState mirror(BlockState state, Mirror mirrorIn) {
				return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
			}

			@Override
			public List<ItemStack> getDrops(BlockState state, LootParams.Builder builder) {
				List<ItemStack> dropsOriginal = super.getDrops(state, builder);
				if (!dropsOriginal.isEmpty())
					return dropsOriginal;
				return Collections.singletonList(new ItemStack(this, 0));
			}

			@Override
			public void onPlace(BlockState blockstate, Level world, BlockPos pos, BlockState oldState, boolean moving) {
				super.onPlace(blockstate, world, pos, oldState, moving);
				int x = pos.getX();
				int y = pos.getY();
				int z = pos.getZ();

				DustBlockView2BlockAddedProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class DustBlockView3Block extends NarutoShippudenModElements.ModElement {
				public static Block block;
		static {
			Registration.holder(Registries.BLOCK, "dust_block_view_3", v -> block = (Block) v);
		}

		public DustBlockView3Block(NarutoShippudenModElements instance) {
			super(instance, 1076);
		}

		@Override
		public void initElements() {
			elements.blocks.add(() -> new CustomBlock());
			elements.items.add(() -> new BlockItem(block, Registration.itemProps("dust_block_view_3", null).useBlockDescriptionPrefix()));
		}

		public static class CustomBlock extends Block {
			public static final EnumProperty<Direction> FACING = HorizontalDirectionalBlock.FACING;

			public CustomBlock() {
				super(Registration.blockProps("dust_block_view_3", BlockBehaviour.Properties.of().replaceable()
						.sound(new DeferredSoundType(1.0f, 1.0f, () -> Compat.sound("naruto_shippuden:dust_release"),
								() -> Compat.sound("naruto_shippuden:dust_release"),
								() -> Compat.sound("naruto_shippuden:dust_release"),
								() -> Compat.sound("naruto_shippuden:dust_release"),
								() -> Compat.sound("naruto_shippuden:dust_release")))
						.strength(-1, 3600000).lightLevel(s -> 0).noOcclusion().isRedstoneConductor((bs, br, bp) -> false)));
				this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean skipRendering(BlockState state, BlockState adjacentBlockState, Direction side) {
				return adjacentBlockState.getBlock() == this ? true : super.skipRendering(state, adjacentBlockState, side);
			}

			@Override
			protected boolean propagatesSkylightDown(BlockState state) {
				return true;
			}

			@Override
			protected int getLightDampening(BlockState state) {
				return 0;
			}

			@Override
			protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
				builder.add(FACING);
			}

			@Override
			public BlockState getStateForPlacement(BlockPlaceContext context) {
				return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
			}

			public BlockState rotate(BlockState state, Rotation rot) {
				return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
			}

			public BlockState mirror(BlockState state, Mirror mirrorIn) {
				return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
			}

			@Override
			public List<ItemStack> getDrops(BlockState state, LootParams.Builder builder) {
				List<ItemStack> dropsOriginal = super.getDrops(state, builder);
				if (!dropsOriginal.isEmpty())
					return dropsOriginal;
				return Collections.singletonList(new ItemStack(this, 0));
			}

			@Override
			public void onPlace(BlockState blockstate, Level world, BlockPos pos, BlockState oldState, boolean moving) {
				super.onPlace(blockstate, world, pos, oldState, moving);
				int x = pos.getX();
				int y = pos.getY();
				int z = pos.getZ();

				DustBlockView3BlockAddedProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class DustBlockViewBlock extends NarutoShippudenModElements.ModElement {
				public static Block block;
		static {
			Registration.holder(Registries.BLOCK, "dust_block_view", v -> block = (Block) v);
		}

		public DustBlockViewBlock(NarutoShippudenModElements instance) {
			super(instance, 1072);
		}

		@Override
		public void initElements() {
			elements.blocks.add(() -> new CustomBlock());
			elements.items.add(() -> new BlockItem(block, Registration.itemProps("dust_block_view", null).useBlockDescriptionPrefix()));
		}

		public static class CustomBlock extends Block {
			public static final EnumProperty<Direction> FACING = HorizontalDirectionalBlock.FACING;

			public CustomBlock() {
				super(Registration.blockProps("dust_block_view", BlockBehaviour.Properties.of().replaceable()
						.sound(new DeferredSoundType(1.0f, 1.0f, () -> Compat.sound("naruto_shippuden:dust_release"),
								() -> Compat.sound("naruto_shippuden:dust_release"),
								() -> Compat.sound("naruto_shippuden:dust_release"),
								() -> Compat.sound("naruto_shippuden:dust_release"),
								() -> Compat.sound("naruto_shippuden:dust_release")))
						.strength(-1, 3600000).lightLevel(s -> 0).noOcclusion().isRedstoneConductor((bs, br, bp) -> false)));
				this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean skipRendering(BlockState state, BlockState adjacentBlockState, Direction side) {
				return adjacentBlockState.getBlock() == this ? true : super.skipRendering(state, adjacentBlockState, side);
			}

			@Override
			protected boolean propagatesSkylightDown(BlockState state) {
				return true;
			}

			@Override
			protected int getLightDampening(BlockState state) {
				return 0;
			}

			@Override
			protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
				builder.add(FACING);
			}

			@Override
			public BlockState getStateForPlacement(BlockPlaceContext context) {
				return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
			}

			public BlockState rotate(BlockState state, Rotation rot) {
				return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
			}

			public BlockState mirror(BlockState state, Mirror mirrorIn) {
				return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
			}

			@Override
			public List<ItemStack> getDrops(BlockState state, LootParams.Builder builder) {
				List<ItemStack> dropsOriginal = super.getDrops(state, builder);
				if (!dropsOriginal.isEmpty())
					return dropsOriginal;
				return Collections.singletonList(new ItemStack(this, 0));
			}

			@Override
			public void onPlace(BlockState blockstate, Level world, BlockPos pos, BlockState oldState, boolean moving) {
				super.onPlace(blockstate, world, pos, oldState, moving);
				int x = pos.getX();
				int y = pos.getY();
				int z = pos.getZ();

				DustBlockViewBlockAddedProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class EarthWallBlock extends NarutoShippudenModElements.ModElement {
				public static Block block;
		static {
			Registration.holder(Registries.BLOCK, "earth_wall", v -> block = (Block) v);
		}

		public EarthWallBlock(NarutoShippudenModElements instance) {
			super(instance, 97);
		}

		@Override
		public void initElements() {
			elements.blocks.add(() -> new CustomBlock());
			elements.items.add(() -> new BlockItem(block, Registration.itemProps("earth_wall", null).useBlockDescriptionPrefix()));
		}

		public static class CustomBlock extends Block {
			public CustomBlock() {
				super(Registration.blockProps("earth_wall", BlockBehaviour.Properties.of().sound(SoundType.GRAVEL).strength(-1, 3600000).lightLevel(s -> 0)));
			}

			@Override
			protected int getLightDampening(BlockState state) {
				return 15;
			}

			@Override
			public List<ItemStack> getDrops(BlockState state, LootParams.Builder builder) {
				List<ItemStack> dropsOriginal = super.getDrops(state, builder);
				if (!dropsOriginal.isEmpty())
					return dropsOriginal;
				return Collections.singletonList(new ItemStack(this, 1));
			}

			@Override
			public void onPlace(BlockState blockstate, Level world, BlockPos pos, BlockState oldState, boolean moving) {
				super.onPlace(blockstate, world, pos, oldState, moving);
				int x = pos.getX();
				int y = pos.getY();
				int z = pos.getZ();

				EarthWallBlockAddedProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class KamuiStoneBlock extends NarutoShippudenModElements.ModElement {
				public static Block block;
		static {
			Registration.holder(Registries.BLOCK, "kamui_stone", v -> block = (Block) v);
		}

		public KamuiStoneBlock(NarutoShippudenModElements instance) {
			super(instance, 1236);
		}

		@Override
		public void initElements() {
			elements.blocks.add(() -> new CustomBlock());
			elements.items.add(() -> new BlockItem(block, Registration.itemProps("kamui_stone", "BlocksItemGroup").useBlockDescriptionPrefix()));
		}

		public static class CustomBlock extends Block {
			public CustomBlock() {
				super(Registration.blockProps("kamui_stone", BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(1f, 10f).lightLevel(s -> 0).requiresCorrectToolForDrops()));
			}

			@Override
			protected int getLightDampening(BlockState state) {
				return 15;
			}

			@Override
			public List<ItemStack> getDrops(BlockState state, LootParams.Builder builder) {
				List<ItemStack> dropsOriginal = super.getDrops(state, builder);
				if (!dropsOriginal.isEmpty())
					return dropsOriginal;
				return Collections.singletonList(new ItemStack(this, 1));
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class KamuiVoidBlock extends NarutoShippudenModElements.ModElement {
				public static Block block;
		static {
			Registration.holder(Registries.BLOCK, "kamui_void", v -> block = (Block) v);
		}

		public KamuiVoidBlock(NarutoShippudenModElements instance) {
			super(instance, 1234);
		}

		@Override
		public void initElements() {
			elements.blocks.add(() -> new CustomBlock());
			elements.items.add(() -> new BlockItem(block, Registration.itemProps("kamui_void", null).useBlockDescriptionPrefix()));
		}

		public static class CustomBlock extends Block {
			public CustomBlock() {
				super(Registration.blockProps("kamui_void", BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(-1, 3600000).lightLevel(s -> 0)));
			}

			@Override
			protected int getLightDampening(BlockState state) {
				return 15;
			}

			@Override
			public List<ItemStack> getDrops(BlockState state, LootParams.Builder builder) {
				List<ItemStack> dropsOriginal = super.getDrops(state, builder);
				if (!dropsOriginal.isEmpty())
					return dropsOriginal;
				return Collections.singletonList(new ItemStack(this, 1));
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class NaraShadowBlock extends NarutoShippudenModElements.ModElement {
				public static Block block;
		static {
			Registration.holder(Registries.BLOCK, "nara_shadow", v -> block = (Block) v);
		}

		public NaraShadowBlock(NarutoShippudenModElements instance) {
			super(instance, 993);
		}

		@Override
		public void initElements() {
			elements.blocks.add(() -> new CustomBlock());
			elements.items.add(() -> new BlockItem(block, Registration.itemProps("nara_shadow", null).useBlockDescriptionPrefix()));
		}

		public static class CustomBlock extends Block {
			public CustomBlock() {
				super(Registration.blockProps("nara_shadow", BlockBehaviour.Properties.of().replaceable().sound(SoundType.GRAVEL).strength(-1, 3600000).lightLevel(s -> 0)
						.noCollision()));
			}

			@Override
			protected int getLightDampening(BlockState state) {
				return 15;
			}

			@Override
			public List<ItemStack> getDrops(BlockState state, LootParams.Builder builder) {
				List<ItemStack> dropsOriginal = super.getDrops(state, builder);
				if (!dropsOriginal.isEmpty())
					return dropsOriginal;
				return Collections.singletonList(new ItemStack(this, 1));
			}

			@Override
			public void setPlacedBy(Level world, BlockPos pos, BlockState blockstate, LivingEntity entity, ItemStack itemstack) {
				super.setPlacedBy(world, pos, blockstate, entity, itemstack);
				int x = pos.getX();
				int y = pos.getY();
				int z = pos.getZ();

				NaraShadowUpdateTickProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class PaperBombBlock extends NarutoShippudenModElements.ModElement {
				public static Block block;
		static {
			Registration.holder(Registries.BLOCK, "paper_bomb", v -> block = (Block) v);
		}

		public PaperBombBlock(NarutoShippudenModElements instance) {
			super(instance, 1290);
		}

		@Override
		public void initElements() {
			elements.blocks.add(() -> new CustomBlock());
			elements.items.add(() -> new BlockItem(block, Registration.itemProps("paper_bomb", "BlocksItemGroup").useBlockDescriptionPrefix()));
		}

		public static class CustomBlock extends FallingBlock {
			@Override
			public int getDustColor(BlockState state, BlockGetter level, BlockPos pos) {
				return -8356741;
			}

			public static final EnumProperty<Direction> FACING = HorizontalDirectionalBlock.FACING;

			public CustomBlock() {
				super(Registration.blockProps("paper_bomb", BlockBehaviour.Properties.of().sound(SoundType.VINE).strength(0.1f, 0.1f).lightLevel(s -> 0)
						.noCollision().noOcclusion().isRedstoneConductor((bs, br, bp) -> false)));
				this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
			}

			@Override
			protected boolean propagatesSkylightDown(BlockState state) {
				return true;
			}

			@Override
			protected int getLightDampening(BlockState state) {
				return 0;
			}

			@Override
			public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
				Vec3 offset = state.getOffset(pos);
				switch ((Direction) state.getValue(FACING)) {
					case SOUTH :
					default :
						return Shapes.or(box(12, 0, 10, 4, 1, 6))

								.move(offset.x, offset.y, offset.z);
					case NORTH :
						return Shapes.or(box(4, 0, 6, 12, 1, 10))

								.move(offset.x, offset.y, offset.z);
					case EAST :
						return Shapes.or(box(10, 0, 4, 6, 1, 12))

								.move(offset.x, offset.y, offset.z);
					case WEST :
						return Shapes.or(box(6, 0, 12, 10, 1, 4))

								.move(offset.x, offset.y, offset.z);
				}
			}

			@Override
			protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
				builder.add(FACING);
			}

			@Override
			public BlockState getStateForPlacement(BlockPlaceContext context) {
				return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
			}

			public BlockState rotate(BlockState state, Rotation rot) {
				return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
			}

			public BlockState mirror(BlockState state, Mirror mirrorIn) {
				return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
			}

			@Override
			public List<ItemStack> getDrops(BlockState state, LootParams.Builder builder) {
				List<ItemStack> dropsOriginal = super.getDrops(state, builder);
				if (!dropsOriginal.isEmpty())
					return dropsOriginal;
				return Collections.singletonList(new ItemStack(this, 1));
			}

			@Override
			protected void entityInside(BlockState blockstate, Level world, BlockPos pos, Entity entity, InsideBlockEffectApplier effectApplier, boolean isPrecise) {
				super.entityInside(blockstate, world, pos, entity, effectApplier, isPrecise);
				int x = pos.getX();
				int y = pos.getY();
				int z = pos.getZ();

				PaperBombEntityWalksOnTheBlockProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}

			@Override
			public void stepOn(Level world, BlockPos pos, BlockState onState, Entity entity) {
				super.stepOn(world, pos, onState, entity);
				int x = pos.getX();
				int y = pos.getY();
				int z = pos.getZ();
				BlockState blockstate = world.getBlockState(pos);

				PaperBombEntityWalksOnTheBlockProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}

			@Override
			public void onProjectileHit(Level world, BlockState blockstate, BlockHitResult hit, Projectile entity) {
				BlockPos pos = hit.getBlockPos();
				int x = pos.getX();
				int y = pos.getY();
				int z = pos.getZ();
				double hitX = hit.getLocation().x;
				double hitY = hit.getLocation().y;
				double hitZ = hit.getLocation().z;
				Direction direction = hit.getDirection();

				PaperBombEntityWalksOnTheBlockProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class WaterwallBlock extends NarutoShippudenModElements.ModElement {
				public static Block block;
		static {
			Registration.holder(Registries.BLOCK, "waterwall", v -> block = (Block) v);
		}

		public WaterwallBlock(NarutoShippudenModElements instance) {
			super(instance, 90);
		}

		@Override
		public void initElements() {
			elements.blocks.add(() -> new CustomBlock());
			elements.items.add(() -> new BlockItem(block, Registration.itemProps("waterwall", null).useBlockDescriptionPrefix()));
		}

		public static class CustomBlock extends Block {
			public CustomBlock() {
				super(Registration.blockProps("waterwall", BlockBehaviour.Properties.of().replaceable().sound(SoundType.GRAVEL).strength(-1, 3600000).lightLevel(s -> 0)
						.noCollision()));
			}

			@Override
			protected int getLightDampening(BlockState state) {
				return 15;
			}

			@Override
			public List<ItemStack> getDrops(BlockState state, LootParams.Builder builder) {
				List<ItemStack> dropsOriginal = super.getDrops(state, builder);
				if (!dropsOriginal.isEmpty())
					return dropsOriginal;
				return Collections.singletonList(new ItemStack(this, 1));
			}

			@Override
			public void onPlace(BlockState blockstate, Level world, BlockPos pos, BlockState oldState, boolean moving) {
				super.onPlace(blockstate, world, pos, oldState, moving);
				int x = pos.getX();
				int y = pos.getY();
				int z = pos.getZ();

				EarthWallBlockAddedProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}

			@Override
			protected void entityInside(BlockState blockstate, Level world, BlockPos pos, Entity entity, InsideBlockEffectApplier effectApplier, boolean isPrecise) {
				super.entityInside(blockstate, world, pos, entity, effectApplier, isPrecise);
				int x = pos.getX();
				int y = pos.getY();
				int z = pos.getZ();

				WaterwallEntityCollidesInTheBlockProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
		}
	}
}
