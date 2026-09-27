package net.mcreator.narutoshippudenmod.block;

import net.minecraft.util.RandomSource;
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






public final class ModBlocks {
	private ModBlocks() {
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class AmaterasuBlock extends NarutoShippudenModElements.ModElement {
				public static Block block;
		static {
			Registration.holder("amaterasu", v -> block = (Block) v);
		}
				public static BlockEntityType<CustomTileEntity> tileEntityType;
		static {
			Registration.holder("amaterasu", v -> tileEntityType = (BlockEntityType<CustomTileEntity>) v);
		}

		public AmaterasuBlock(NarutoShippudenModElements instance) {
			super(instance, 1203);
			NarutoShippudenMod.MOD_BUS.register(new TileEntityRegisterHandler());
		}

		@Override
		public void initElements() {
			elements.blocks.add(() -> new CustomBlock());
			elements.items.add(() -> new BlockItem(block, new Item.Properties().tab(null)).setRegistryName(block.getRegistryName()));
		}

		public static class TileEntityRegisterHandler {
			@SubscribeEvent
			public void registerTileEntity(RegistryEvent.Register<BlockEntityType<?>> event) {
				event.getRegistry().register(BlockEntityType.Builder.of(CustomTileEntity::new, block).build(null).setRegistryName("amaterasu"));
			}
		}

		@Override
		@OnlyIn(Dist.CLIENT)
		public void clientLoad(FMLClientSetupEvent event) {
			RenderTypeLookup.setRenderLayer(block, RenderType.cutoutMipped());
		}

		public static class CustomBlock extends Block {
			public CustomBlock() {
				super(Block.Properties.of(Material.FIRE)
						.sound(new DeferredSoundType(1.0f, 1.0f, () -> new SoundEvent(Identifier.parse("block.fire.ambient")),
								() -> new SoundEvent(Identifier.parse("block.fire.ambient")),
								() -> new SoundEvent(Identifier.parse("block.fire.ambient")),
								() -> new SoundEvent(Identifier.parse("entity.player.hurt_on_fire")),
								() -> new SoundEvent(Identifier.parse("block.fire.ambient"))))
						.strength(-1, 3600000).lightLevel(s -> 0).noCollission().noOcclusion().isRedstoneConductor((bs, br, bp) -> false));
				setRegistryName("amaterasu");
			}

			@Override
			public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
				return true;
			}

			@Override
			public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
				return 0;
			}

			@Override
			public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
				Vec3 offset = state.getOffset(world, pos);
				return Shapes.or(box(0, 0, 0, 16, 1, 16))

						.move(offset.x, offset.y, offset.z);
			}

			@Override
			public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
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
				world.getBlockTicks().scheduleTick(pos, this, 1);

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
				world.getBlockTicks().scheduleTick(pos, this, 1);
			}

			@Override
			public void entityInside(BlockState blockstate, Level world, BlockPos pos, Entity entity) {
				super.entityInside(blockstate, world, pos, entity);
				int x = pos.getX();
				int y = pos.getY();
				int z = pos.getZ();

				AmaterasuEntityCollidesInTheBlockProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}

			@Override
			public MenuProvider getMenuProvider(BlockState state, Level worldIn, BlockPos pos) {
				BlockEntity tileEntity = worldIn.getBlockEntity(pos);
				return tileEntity instanceof MenuProvider ? (MenuProvider) tileEntity : null;
			}

			@Override
			public boolean hasTileEntity(BlockState state) {
				return true;
			}

			@Override
			public BlockEntity createTileEntity(BlockState state, BlockGetter world) {
				return new CustomTileEntity();
			}

			@Override
			public boolean triggerEvent(BlockState state, Level world, BlockPos pos, int eventID, int eventParam) {
				super.triggerEvent(state, world, pos, eventID, eventParam);
				BlockEntity tileentity = world.getBlockEntity(pos);
				return tileentity == null ? false : tileentity.triggerEvent(eventID, eventParam);
			}
		}

		public static class CustomTileEntity extends RandomizableContainerBlockEntity implements WorldlyContainer {
			private NonNullList<ItemStack> stacks = NonNullList.<ItemStack>withSize(0, ItemStack.EMPTY);

			protected CustomTileEntity() {
				super(tileEntityType);
			}

			@Override
			public void load(BlockState blockState, CompoundTag compound) {
				super.load(blockState, compound);
				if (!this.tryLoadLootTable(compound)) {
					this.stacks = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
				}
				ContainerHelper.loadAllItems(compound, this.stacks);
			}

			@Override
			public CompoundTag save(CompoundTag compound) {
				super.save(compound);
				if (!this.trySaveLootTable(compound)) {
					ContainerHelper.saveAllItems(compound, this.stacks);
				}
				return compound;
			}

			@Override
			public ClientboundBlockEntityDataPacket getUpdatePacket() {
				return new ClientboundBlockEntityDataPacket(this.worldPosition, 0, this.getUpdateTag());
			}

			@Override
			public CompoundTag getUpdateTag() {
				return this.save(new CompoundTag());
			}

			@Override
			public void onDataPacket(Connection net, ClientboundBlockEntityDataPacket pkt) {
				this.load(this.getBlockState(), StackTag.of(pkt));
			}

			@Override
			public int getContainerSize() {
				return stacks.size();
			}

			@Override
			public boolean isEmpty() {
				for (ItemStack itemstack : this.stacks)
					if (!itemstack.isEmpty())
						return false;
				return true;
			}

			@Override
			public Component getDefaultName() {
				return Component.literal("amaterasu");
			}

			@Override
			public int getMaxStackSize() {
				return 64;
			}

			@Override
			public AbstractContainerMenu createMenu(int id, Inventory player) {
				return ChestMenu.threeRows(id, player, this);
			}

			@Override
			public Component getDisplayName() {
				return Component.literal("Amaterasu");
			}

			@Override
			protected NonNullList<ItemStack> getItems() {
				return this.stacks;
			}

			@Override
			protected void setItems(NonNullList<ItemStack> stacks) {
				this.stacks = stacks;
			}

			@Override
			public boolean canPlaceItem(int index, ItemStack stack) {
				return true;
			}

			@Override
			public int[] getSlotsForFace(Direction side) {
				return IntStream.range(0, this.getContainerSize()).toArray();
			}

			@Override
			public boolean canPlaceItemThroughFace(int index, ItemStack stack, @Nullable Direction direction) {
				return this.canPlaceItem(index, stack);
			}

			@Override
			public boolean canTakeItemThroughFace(int index, ItemStack stack, Direction direction) {
				return true;
			}

			private final LazyOptional<? extends IItemHandler>[] handlers = SidedInvWrapper.create(this, Direction.values());

			@Override
			public <T> LazyOptional<T> getCapability(Capability<T> capability, @Nullable Direction facing) {
				if (!this.remove && facing != null && capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
					return handlers[facing.ordinal()].cast();
				return super.getCapability(capability, facing);
			}

			@Override
			public void setRemoved() {
				super.setRemoved();
				for (LazyOptional<? extends IItemHandler> handler : handlers)
					handler.invalidate();
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class AmaterasuSpreadBlock extends NarutoShippudenModElements.ModElement {
				public static Block block;
		static {
			Registration.holder("amaterasu_spread", v -> block = (Block) v);
		}
				public static BlockEntityType<CustomTileEntity> tileEntityType;
		static {
			Registration.holder("amaterasu_spread", v -> tileEntityType = (BlockEntityType<CustomTileEntity>) v);
		}

		public AmaterasuSpreadBlock(NarutoShippudenModElements instance) {
			super(instance, 1208);
			NarutoShippudenMod.MOD_BUS.register(new TileEntityRegisterHandler());
		}

		@Override
		public void initElements() {
			elements.blocks.add(() -> new CustomBlock());
			elements.items.add(() -> new BlockItem(block, new Item.Properties().tab(null)).setRegistryName(block.getRegistryName()));
		}

		public static class TileEntityRegisterHandler {
			@SubscribeEvent
			public void registerTileEntity(RegistryEvent.Register<BlockEntityType<?>> event) {
				event.getRegistry().register(BlockEntityType.Builder.of(CustomTileEntity::new, block).build(null).setRegistryName("amaterasu_spread"));
			}
		}

		@Override
		@OnlyIn(Dist.CLIENT)
		public void clientLoad(FMLClientSetupEvent event) {
			RenderTypeLookup.setRenderLayer(block, RenderType.cutoutMipped());
		}

		public static class CustomBlock extends Block {
			public CustomBlock() {
				super(Block.Properties.of(Material.FIRE)
						.sound(new DeferredSoundType(1.0f, 1.0f, () -> new SoundEvent(Identifier.parse("block.fire.ambient")),
								() -> new SoundEvent(Identifier.parse("block.fire.ambient")),
								() -> new SoundEvent(Identifier.parse("block.fire.ambient")),
								() -> new SoundEvent(Identifier.parse("entity.player.hurt_on_fire")),
								() -> new SoundEvent(Identifier.parse("block.fire.ambient"))))
						.strength(-1, 3600000).lightLevel(s -> 0).noCollission().noOcclusion().isRedstoneConductor((bs, br, bp) -> false));
				setRegistryName("amaterasu_spread");
			}

			@Override
			public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
				return true;
			}

			@Override
			public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
				return 0;
			}

			@Override
			public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
				Vec3 offset = state.getOffset(world, pos);
				return Shapes.or(box(0, 0, 0, 16, 1, 16))

						.move(offset.x, offset.y, offset.z);
			}

			@Override
			public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
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
				world.getBlockTicks().scheduleTick(pos, this, 1);

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
				world.getBlockTicks().scheduleTick(pos, this, 1);
			}

			@Override
			public void entityInside(BlockState blockstate, Level world, BlockPos pos, Entity entity) {
				super.entityInside(blockstate, world, pos, entity);
				int x = pos.getX();
				int y = pos.getY();
				int z = pos.getZ();

				AmaterasuEntityCollidesInTheBlockProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}

			@Override
			public MenuProvider getMenuProvider(BlockState state, Level worldIn, BlockPos pos) {
				BlockEntity tileEntity = worldIn.getBlockEntity(pos);
				return tileEntity instanceof MenuProvider ? (MenuProvider) tileEntity : null;
			}

			@Override
			public boolean hasTileEntity(BlockState state) {
				return true;
			}

			@Override
			public BlockEntity createTileEntity(BlockState state, BlockGetter world) {
				return new CustomTileEntity();
			}

			@Override
			public boolean triggerEvent(BlockState state, Level world, BlockPos pos, int eventID, int eventParam) {
				super.triggerEvent(state, world, pos, eventID, eventParam);
				BlockEntity tileentity = world.getBlockEntity(pos);
				return tileentity == null ? false : tileentity.triggerEvent(eventID, eventParam);
			}
		}

		public static class CustomTileEntity extends RandomizableContainerBlockEntity implements WorldlyContainer {
			private NonNullList<ItemStack> stacks = NonNullList.<ItemStack>withSize(0, ItemStack.EMPTY);

			protected CustomTileEntity() {
				super(tileEntityType);
			}

			@Override
			public void load(BlockState blockState, CompoundTag compound) {
				super.load(blockState, compound);
				if (!this.tryLoadLootTable(compound)) {
					this.stacks = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
				}
				ContainerHelper.loadAllItems(compound, this.stacks);
			}

			@Override
			public CompoundTag save(CompoundTag compound) {
				super.save(compound);
				if (!this.trySaveLootTable(compound)) {
					ContainerHelper.saveAllItems(compound, this.stacks);
				}
				return compound;
			}

			@Override
			public ClientboundBlockEntityDataPacket getUpdatePacket() {
				return new ClientboundBlockEntityDataPacket(this.worldPosition, 0, this.getUpdateTag());
			}

			@Override
			public CompoundTag getUpdateTag() {
				return this.save(new CompoundTag());
			}

			@Override
			public void onDataPacket(Connection net, ClientboundBlockEntityDataPacket pkt) {
				this.load(this.getBlockState(), StackTag.of(pkt));
			}

			@Override
			public int getContainerSize() {
				return stacks.size();
			}

			@Override
			public boolean isEmpty() {
				for (ItemStack itemstack : this.stacks)
					if (!itemstack.isEmpty())
						return false;
				return true;
			}

			@Override
			public Component getDefaultName() {
				return Component.literal("amaterasu_spread");
			}

			@Override
			public int getMaxStackSize() {
				return 64;
			}

			@Override
			public AbstractContainerMenu createMenu(int id, Inventory player) {
				return ChestMenu.threeRows(id, player, this);
			}

			@Override
			public Component getDisplayName() {
				return Component.literal("Amaterasu");
			}

			@Override
			protected NonNullList<ItemStack> getItems() {
				return this.stacks;
			}

			@Override
			protected void setItems(NonNullList<ItemStack> stacks) {
				this.stacks = stacks;
			}

			@Override
			public boolean canPlaceItem(int index, ItemStack stack) {
				return true;
			}

			@Override
			public int[] getSlotsForFace(Direction side) {
				return IntStream.range(0, this.getContainerSize()).toArray();
			}

			@Override
			public boolean canPlaceItemThroughFace(int index, ItemStack stack, @Nullable Direction direction) {
				return this.canPlaceItem(index, stack);
			}

			@Override
			public boolean canTakeItemThroughFace(int index, ItemStack stack, Direction direction) {
				return true;
			}

			private final LazyOptional<? extends IItemHandler>[] handlers = SidedInvWrapper.create(this, Direction.values());

			@Override
			public <T> LazyOptional<T> getCapability(Capability<T> capability, @Nullable Direction facing) {
				if (!this.remove && facing != null && capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
					return handlers[facing.ordinal()].cast();
				return super.getCapability(capability, facing);
			}

			@Override
			public void setRemoved() {
				super.setRemoved();
				for (LazyOptional<? extends IItemHandler> handler : handlers)
					handler.invalidate();
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class DustBlockBlock extends NarutoShippudenModElements.ModElement {
				public static Block block;
		static {
			Registration.holder("dust_block", v -> block = (Block) v);
		}

		public DustBlockBlock(NarutoShippudenModElements instance) {
			super(instance, 1070);
		}

		@Override
		public void initElements() {
			elements.blocks.add(() -> new CustomBlock());
			elements.items.add(() -> new BlockItem(block, new Item.Properties().tab(null)).setRegistryName(block.getRegistryName()));
		}

		@Override
		@OnlyIn(Dist.CLIENT)
		public void clientLoad(FMLClientSetupEvent event) {
			RenderTypeLookup.setRenderLayer(block, RenderType.translucent());
		}

		public static class CustomBlock extends Block {
			public static final EnumProperty FACING = HorizontalDirectionalBlock.FACING;

			public CustomBlock() {
				super(Block.Properties.of(Material.AIR)
						.sound(new DeferredSoundType(1.0f, 1.0f, () -> new SoundEvent(Identifier.parse("naruto_shippuden:dust_release")),
								() -> new SoundEvent(Identifier.parse("naruto_shippuden:dust_release")),
								() -> new SoundEvent(Identifier.parse("naruto_shippuden:dust_release")),
								() -> new SoundEvent(Identifier.parse("naruto_shippuden:dust_release")),
								() -> new SoundEvent(Identifier.parse("naruto_shippuden:dust_release"))))
						.strength(-1, 3600000).lightLevel(s -> 0).noOcclusion().isRedstoneConductor((bs, br, bp) -> false));
				this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
				setRegistryName("dust_block");
			}

			@OnlyIn(Dist.CLIENT)
			public boolean skipRendering(BlockState state, BlockState adjacentBlockState, Direction side) {
				return adjacentBlockState.getBlock() == this ? true : super.skipRendering(state, adjacentBlockState, side);
			}

			@Override
			public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
				return true;
			}

			@Override
			public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
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
			public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
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
			Registration.holder("dust_block_view_2", v -> block = (Block) v);
		}

		public DustBlockView2Block(NarutoShippudenModElements instance) {
			super(instance, 1074);
		}

		@Override
		public void initElements() {
			elements.blocks.add(() -> new CustomBlock());
			elements.items.add(() -> new BlockItem(block, new Item.Properties().tab(null)).setRegistryName(block.getRegistryName()));
		}

		@Override
		@OnlyIn(Dist.CLIENT)
		public void clientLoad(FMLClientSetupEvent event) {
			RenderTypeLookup.setRenderLayer(block, RenderType.translucent());
		}

		public static class CustomBlock extends Block {
			public static final EnumProperty FACING = HorizontalDirectionalBlock.FACING;

			public CustomBlock() {
				super(Block.Properties.of(Material.AIR)
						.sound(new DeferredSoundType(1.0f, 1.0f, () -> new SoundEvent(Identifier.parse("naruto_shippuden:dust_release")),
								() -> new SoundEvent(Identifier.parse("naruto_shippuden:dust_release")),
								() -> new SoundEvent(Identifier.parse("naruto_shippuden:dust_release")),
								() -> new SoundEvent(Identifier.parse("naruto_shippuden:dust_release")),
								() -> new SoundEvent(Identifier.parse("naruto_shippuden:dust_release"))))
						.strength(-1, 3600000).lightLevel(s -> 0).noOcclusion().isRedstoneConductor((bs, br, bp) -> false));
				this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
				setRegistryName("dust_block_view_2");
			}

			@OnlyIn(Dist.CLIENT)
			public boolean skipRendering(BlockState state, BlockState adjacentBlockState, Direction side) {
				return adjacentBlockState.getBlock() == this ? true : super.skipRendering(state, adjacentBlockState, side);
			}

			@Override
			public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
				return true;
			}

			@Override
			public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
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
			public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
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
			Registration.holder("dust_block_view_3", v -> block = (Block) v);
		}

		public DustBlockView3Block(NarutoShippudenModElements instance) {
			super(instance, 1076);
		}

		@Override
		public void initElements() {
			elements.blocks.add(() -> new CustomBlock());
			elements.items.add(() -> new BlockItem(block, new Item.Properties().tab(null)).setRegistryName(block.getRegistryName()));
		}

		@Override
		@OnlyIn(Dist.CLIENT)
		public void clientLoad(FMLClientSetupEvent event) {
			RenderTypeLookup.setRenderLayer(block, RenderType.translucent());
		}

		public static class CustomBlock extends Block {
			public static final EnumProperty FACING = HorizontalDirectionalBlock.FACING;

			public CustomBlock() {
				super(Block.Properties.of(Material.AIR)
						.sound(new DeferredSoundType(1.0f, 1.0f, () -> new SoundEvent(Identifier.parse("naruto_shippuden:dust_release")),
								() -> new SoundEvent(Identifier.parse("naruto_shippuden:dust_release")),
								() -> new SoundEvent(Identifier.parse("naruto_shippuden:dust_release")),
								() -> new SoundEvent(Identifier.parse("naruto_shippuden:dust_release")),
								() -> new SoundEvent(Identifier.parse("naruto_shippuden:dust_release"))))
						.strength(-1, 3600000).lightLevel(s -> 0).noOcclusion().isRedstoneConductor((bs, br, bp) -> false));
				this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
				setRegistryName("dust_block_view_3");
			}

			@OnlyIn(Dist.CLIENT)
			public boolean skipRendering(BlockState state, BlockState adjacentBlockState, Direction side) {
				return adjacentBlockState.getBlock() == this ? true : super.skipRendering(state, adjacentBlockState, side);
			}

			@Override
			public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
				return true;
			}

			@Override
			public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
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
			public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
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
			Registration.holder("dust_block_view", v -> block = (Block) v);
		}

		public DustBlockViewBlock(NarutoShippudenModElements instance) {
			super(instance, 1072);
		}

		@Override
		public void initElements() {
			elements.blocks.add(() -> new CustomBlock());
			elements.items.add(() -> new BlockItem(block, new Item.Properties().tab(null)).setRegistryName(block.getRegistryName()));
		}

		@Override
		@OnlyIn(Dist.CLIENT)
		public void clientLoad(FMLClientSetupEvent event) {
			RenderTypeLookup.setRenderLayer(block, RenderType.translucent());
		}

		public static class CustomBlock extends Block {
			public static final EnumProperty FACING = HorizontalDirectionalBlock.FACING;

			public CustomBlock() {
				super(Block.Properties.of(Material.AIR)
						.sound(new DeferredSoundType(1.0f, 1.0f, () -> new SoundEvent(Identifier.parse("naruto_shippuden:dust_release")),
								() -> new SoundEvent(Identifier.parse("naruto_shippuden:dust_release")),
								() -> new SoundEvent(Identifier.parse("naruto_shippuden:dust_release")),
								() -> new SoundEvent(Identifier.parse("naruto_shippuden:dust_release")),
								() -> new SoundEvent(Identifier.parse("naruto_shippuden:dust_release"))))
						.strength(-1, 3600000).lightLevel(s -> 0).noOcclusion().isRedstoneConductor((bs, br, bp) -> false));
				this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
				setRegistryName("dust_block_view");
			}

			@OnlyIn(Dist.CLIENT)
			public boolean skipRendering(BlockState state, BlockState adjacentBlockState, Direction side) {
				return adjacentBlockState.getBlock() == this ? true : super.skipRendering(state, adjacentBlockState, side);
			}

			@Override
			public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
				return true;
			}

			@Override
			public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
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
			public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
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
			Registration.holder("earth_wall", v -> block = (Block) v);
		}

		public EarthWallBlock(NarutoShippudenModElements instance) {
			super(instance, 97);
		}

		@Override
		public void initElements() {
			elements.blocks.add(() -> new CustomBlock());
			elements.items.add(() -> new BlockItem(block, new Item.Properties().tab(null)).setRegistryName(block.getRegistryName()));
		}

		public static class CustomBlock extends Block {
			public CustomBlock() {
				super(Block.Properties.of(Material.DIRT).sound(SoundType.GRAVEL).strength(-1, 3600000).lightLevel(s -> 0));
				setRegistryName("earth_wall");
			}

			@Override
			public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
				return 15;
			}

			@Override
			public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
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
			Registration.holder("kamui_stone", v -> block = (Block) v);
		}

		public KamuiStoneBlock(NarutoShippudenModElements instance) {
			super(instance, 1236);
		}

		@Override
		public void initElements() {
			elements.blocks.add(() -> new CustomBlock());
			elements.items.add(() -> new BlockItem(block, new Item.Properties().tab(BlocksItemGroup.tab)).setRegistryName(block.getRegistryName()));
		}

		public static class CustomBlock extends Block {
			public CustomBlock() {
				super(Block.Properties.of(Material.STONE).sound(SoundType.STONE).strength(1f, 10f).lightLevel(s -> 0).harvestLevel(2)
						.harvestTool(ToolType.PICKAXE));
				setRegistryName("kamui_stone");
			}

			@Override
			public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
				return 15;
			}

			@Override
			public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
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
			Registration.holder("kamui_void", v -> block = (Block) v);
		}

		public KamuiVoidBlock(NarutoShippudenModElements instance) {
			super(instance, 1234);
		}

		@Override
		public void initElements() {
			elements.blocks.add(() -> new CustomBlock());
			elements.items.add(() -> new BlockItem(block, new Item.Properties().tab(null)).setRegistryName(block.getRegistryName()));
		}

		public static class CustomBlock extends Block {
			public CustomBlock() {
				super(Block.Properties.of(Material.DECORATION).sound(SoundType.STONE).strength(-1, 3600000).lightLevel(s -> 0));
				setRegistryName("kamui_void");
			}

			@Override
			public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
				return 15;
			}

			@Override
			public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
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
			Registration.holder("nara_shadow", v -> block = (Block) v);
		}

		public NaraShadowBlock(NarutoShippudenModElements instance) {
			super(instance, 993);
		}

		@Override
		public void initElements() {
			elements.blocks.add(() -> new CustomBlock());
			elements.items.add(() -> new BlockItem(block, new Item.Properties().tab(null)).setRegistryName(block.getRegistryName()));
		}

		public static class CustomBlock extends Block {
			public CustomBlock() {
				super(Block.Properties.of(Material.WATER).sound(SoundType.GRAVEL).strength(-1, 3600000).lightLevel(s -> 0)
						.noCollission());
				setRegistryName("nara_shadow");
			}

			@Override
			public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
				return 15;
			}

			@Override
			public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
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
			Registration.holder("paper_bomb", v -> block = (Block) v);
		}

		public PaperBombBlock(NarutoShippudenModElements instance) {
			super(instance, 1290);
		}

		@Override
		public void initElements() {
			elements.blocks.add(() -> new CustomBlock());
			elements.items.add(() -> new BlockItem(block, new Item.Properties().tab(BlocksItemGroup.tab)).setRegistryName(block.getRegistryName()));
		}

		@Override
		@OnlyIn(Dist.CLIENT)
		public void clientLoad(FMLClientSetupEvent event) {
			RenderTypeLookup.setRenderLayer(block, RenderType.cutoutMipped());
		}

		public static class CustomBlock extends FallingBlock {
			public static final EnumProperty FACING = HorizontalDirectionalBlock.FACING;

			public CustomBlock() {
				super(Block.Properties.of(Material.CLOTH_DECORATION).sound(SoundType.VINE).strength(0.1f, 0.1f).lightLevel(s -> 0)
						.noCollission().noOcclusion().isRedstoneConductor((bs, br, bp) -> false));
				this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
				setRegistryName("paper_bomb");
			}

			@Override
			public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
				return true;
			}

			@Override
			public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
				return 0;
			}

			@Override
			public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
				Vec3 offset = state.getOffset(world, pos);
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
			public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
				List<ItemStack> dropsOriginal = super.getDrops(state, builder);
				if (!dropsOriginal.isEmpty())
					return dropsOriginal;
				return Collections.singletonList(new ItemStack(this, 1));
			}

			@Override
			public void entityInside(BlockState blockstate, Level world, BlockPos pos, Entity entity) {
				super.entityInside(blockstate, world, pos, entity);
				int x = pos.getX();
				int y = pos.getY();
				int z = pos.getZ();

				PaperBombEntityWalksOnTheBlockProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}

			@Override
			public void stepOn(Level world, BlockPos pos, Entity entity) {
				super.stepOn(world, pos, entity);
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
			Registration.holder("waterwall", v -> block = (Block) v);
		}

		public WaterwallBlock(NarutoShippudenModElements instance) {
			super(instance, 90);
		}

		@Override
		public void initElements() {
			elements.blocks.add(() -> new CustomBlock());
			elements.items.add(() -> new BlockItem(block, new Item.Properties().tab(null)).setRegistryName(block.getRegistryName()));
		}

		public static class CustomBlock extends Block {
			public CustomBlock() {
				super(Block.Properties.of(Material.WATER).sound(SoundType.GRAVEL).strength(-1, 3600000).lightLevel(s -> 0)
						.noCollission());
				setRegistryName("waterwall");
			}

			@Override
			public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
				return 15;
			}

			@Override
			public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
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
			public void entityInside(BlockState blockstate, Level world, BlockPos pos, Entity entity) {
				super.entityInside(blockstate, world, pos, entity);
				int x = pos.getX();
				int y = pos.getY();
				int z = pos.getZ();

				WaterwallEntityCollidesInTheBlockProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
		}
	}
}
