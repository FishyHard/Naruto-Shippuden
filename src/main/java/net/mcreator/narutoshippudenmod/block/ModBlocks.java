package net.mcreator.narutoshippudenmod.block;

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
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FallingBlock;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.container.ChestContainer;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.BlockItem;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootContext;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.tileentity.LockableLootTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import net.minecraft.util.Mirror;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.ForgeSoundType;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.wrapper.SidedInvWrapper;
import net.minecraftforge.registries.ObjectHolder;

public final class ModBlocks {
	private ModBlocks() {
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class AmaterasuBlock extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:amaterasu")
		public static final Block block = null;
		@ObjectHolder("naruto_shippuden:amaterasu")
		public static final TileEntityType<CustomTileEntity> tileEntityType = null;

		public AmaterasuBlock(NarutoShippudenModElements instance) {
			super(instance, 1203);
			FMLJavaModLoadingContext.get().getModEventBus().register(new TileEntityRegisterHandler());
		}

		@Override
		public void initElements() {
			elements.blocks.add(() -> new CustomBlock());
			elements.items.add(() -> new BlockItem(block, new Item.Properties().group(null)).setRegistryName(block.getRegistryName()));
		}

		private static class TileEntityRegisterHandler {
			@SubscribeEvent
			public void registerTileEntity(RegistryEvent.Register<TileEntityType<?>> event) {
				event.getRegistry().register(TileEntityType.Builder.create(CustomTileEntity::new, block).build(null).setRegistryName("amaterasu"));
			}
		}

		@Override
		@OnlyIn(Dist.CLIENT)
		public void clientLoad(FMLClientSetupEvent event) {
			RenderTypeLookup.setRenderLayer(block, RenderType.getCutoutMipped());
		}

		public static class CustomBlock extends Block {
			public CustomBlock() {
				super(Block.Properties.create(Material.FIRE)
						.sound(new ForgeSoundType(1.0f, 1.0f, () -> new SoundEvent(new ResourceLocation("block.fire.ambient")),
								() -> new SoundEvent(new ResourceLocation("block.fire.ambient")),
								() -> new SoundEvent(new ResourceLocation("block.fire.ambient")),
								() -> new SoundEvent(new ResourceLocation("entity.player.hurt_on_fire")),
								() -> new SoundEvent(new ResourceLocation("block.fire.ambient"))))
						.hardnessAndResistance(-1, 3600000).setLightLevel(s -> 0).doesNotBlockMovement().notSolid().setOpaque((bs, br, bp) -> false));
				setRegistryName("amaterasu");
			}

			@Override
			public boolean propagatesSkylightDown(BlockState state, IBlockReader reader, BlockPos pos) {
				return true;
			}

			@Override
			public int getOpacity(BlockState state, IBlockReader worldIn, BlockPos pos) {
				return 0;
			}

			@Override
			public VoxelShape getShape(BlockState state, IBlockReader world, BlockPos pos, ISelectionContext context) {
				Vector3d offset = state.getOffset(world, pos);
				return VoxelShapes.or(makeCuboidShape(0, 0, 0, 16, 1, 16))

						.withOffset(offset.x, offset.y, offset.z);
			}

			@Override
			public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
				List<ItemStack> dropsOriginal = super.getDrops(state, builder);
				if (!dropsOriginal.isEmpty())
					return dropsOriginal;
				return Collections.singletonList(new ItemStack(this, 1));
			}

			@Override
			public void onBlockAdded(BlockState blockstate, World world, BlockPos pos, BlockState oldState, boolean moving) {
				super.onBlockAdded(blockstate, world, pos, oldState, moving);
				int x = pos.getX();
				int y = pos.getY();
				int z = pos.getZ();
				world.getPendingBlockTicks().scheduleTick(pos, this, 1);

				AmaterasuBlockAddedProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}

			@Override
			public void tick(BlockState blockstate, ServerWorld world, BlockPos pos, Random random) {
				super.tick(blockstate, world, pos, random);
				int x = pos.getX();
				int y = pos.getY();
				int z = pos.getZ();

				AmaterasuUpdateTickSpreadProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				world.getPendingBlockTicks().scheduleTick(pos, this, 1);
			}

			@Override
			public void onEntityCollision(BlockState blockstate, World world, BlockPos pos, Entity entity) {
				super.onEntityCollision(blockstate, world, pos, entity);
				int x = pos.getX();
				int y = pos.getY();
				int z = pos.getZ();

				AmaterasuEntityCollidesInTheBlockProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}

			@Override
			public INamedContainerProvider getContainer(BlockState state, World worldIn, BlockPos pos) {
				TileEntity tileEntity = worldIn.getTileEntity(pos);
				return tileEntity instanceof INamedContainerProvider ? (INamedContainerProvider) tileEntity : null;
			}

			@Override
			public boolean hasTileEntity(BlockState state) {
				return true;
			}

			@Override
			public TileEntity createTileEntity(BlockState state, IBlockReader world) {
				return new CustomTileEntity();
			}

			@Override
			public boolean eventReceived(BlockState state, World world, BlockPos pos, int eventID, int eventParam) {
				super.eventReceived(state, world, pos, eventID, eventParam);
				TileEntity tileentity = world.getTileEntity(pos);
				return tileentity == null ? false : tileentity.receiveClientEvent(eventID, eventParam);
			}
		}

		public static class CustomTileEntity extends LockableLootTileEntity implements ISidedInventory {
			private NonNullList<ItemStack> stacks = NonNullList.<ItemStack>withSize(0, ItemStack.EMPTY);

			protected CustomTileEntity() {
				super(tileEntityType);
			}

			@Override
			public void read(BlockState blockState, CompoundNBT compound) {
				super.read(blockState, compound);
				if (!this.checkLootAndRead(compound)) {
					this.stacks = NonNullList.withSize(this.getSizeInventory(), ItemStack.EMPTY);
				}
				ItemStackHelper.loadAllItems(compound, this.stacks);
			}

			@Override
			public CompoundNBT write(CompoundNBT compound) {
				super.write(compound);
				if (!this.checkLootAndWrite(compound)) {
					ItemStackHelper.saveAllItems(compound, this.stacks);
				}
				return compound;
			}

			@Override
			public SUpdateTileEntityPacket getUpdatePacket() {
				return new SUpdateTileEntityPacket(this.pos, 0, this.getUpdateTag());
			}

			@Override
			public CompoundNBT getUpdateTag() {
				return this.write(new CompoundNBT());
			}

			@Override
			public void onDataPacket(NetworkManager net, SUpdateTileEntityPacket pkt) {
				this.read(this.getBlockState(), pkt.getNbtCompound());
			}

			@Override
			public int getSizeInventory() {
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
			public ITextComponent getDefaultName() {
				return new StringTextComponent("amaterasu");
			}

			@Override
			public int getInventoryStackLimit() {
				return 64;
			}

			@Override
			public Container createMenu(int id, PlayerInventory player) {
				return ChestContainer.createGeneric9X3(id, player, this);
			}

			@Override
			public ITextComponent getDisplayName() {
				return new StringTextComponent("Amaterasu");
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
			public boolean isItemValidForSlot(int index, ItemStack stack) {
				return true;
			}

			@Override
			public int[] getSlotsForFace(Direction side) {
				return IntStream.range(0, this.getSizeInventory()).toArray();
			}

			@Override
			public boolean canInsertItem(int index, ItemStack stack, @Nullable Direction direction) {
				return this.isItemValidForSlot(index, stack);
			}

			@Override
			public boolean canExtractItem(int index, ItemStack stack, Direction direction) {
				return true;
			}

			private final LazyOptional<? extends IItemHandler>[] handlers = SidedInvWrapper.create(this, Direction.values());

			@Override
			public <T> LazyOptional<T> getCapability(Capability<T> capability, @Nullable Direction facing) {
				if (!this.removed && facing != null && capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
					return handlers[facing.ordinal()].cast();
				return super.getCapability(capability, facing);
			}

			@Override
			public void remove() {
				super.remove();
				for (LazyOptional<? extends IItemHandler> handler : handlers)
					handler.invalidate();
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class AmaterasuSpreadBlock extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:amaterasu_spread")
		public static final Block block = null;
		@ObjectHolder("naruto_shippuden:amaterasu_spread")
		public static final TileEntityType<CustomTileEntity> tileEntityType = null;

		public AmaterasuSpreadBlock(NarutoShippudenModElements instance) {
			super(instance, 1208);
			FMLJavaModLoadingContext.get().getModEventBus().register(new TileEntityRegisterHandler());
		}

		@Override
		public void initElements() {
			elements.blocks.add(() -> new CustomBlock());
			elements.items.add(() -> new BlockItem(block, new Item.Properties().group(null)).setRegistryName(block.getRegistryName()));
		}

		private static class TileEntityRegisterHandler {
			@SubscribeEvent
			public void registerTileEntity(RegistryEvent.Register<TileEntityType<?>> event) {
				event.getRegistry().register(TileEntityType.Builder.create(CustomTileEntity::new, block).build(null).setRegistryName("amaterasu_spread"));
			}
		}

		@Override
		@OnlyIn(Dist.CLIENT)
		public void clientLoad(FMLClientSetupEvent event) {
			RenderTypeLookup.setRenderLayer(block, RenderType.getCutoutMipped());
		}

		public static class CustomBlock extends Block {
			public CustomBlock() {
				super(Block.Properties.create(Material.FIRE)
						.sound(new ForgeSoundType(1.0f, 1.0f, () -> new SoundEvent(new ResourceLocation("block.fire.ambient")),
								() -> new SoundEvent(new ResourceLocation("block.fire.ambient")),
								() -> new SoundEvent(new ResourceLocation("block.fire.ambient")),
								() -> new SoundEvent(new ResourceLocation("entity.player.hurt_on_fire")),
								() -> new SoundEvent(new ResourceLocation("block.fire.ambient"))))
						.hardnessAndResistance(-1, 3600000).setLightLevel(s -> 0).doesNotBlockMovement().notSolid().setOpaque((bs, br, bp) -> false));
				setRegistryName("amaterasu_spread");
			}

			@Override
			public boolean propagatesSkylightDown(BlockState state, IBlockReader reader, BlockPos pos) {
				return true;
			}

			@Override
			public int getOpacity(BlockState state, IBlockReader worldIn, BlockPos pos) {
				return 0;
			}

			@Override
			public VoxelShape getShape(BlockState state, IBlockReader world, BlockPos pos, ISelectionContext context) {
				Vector3d offset = state.getOffset(world, pos);
				return VoxelShapes.or(makeCuboidShape(0, 0, 0, 16, 1, 16))

						.withOffset(offset.x, offset.y, offset.z);
			}

			@Override
			public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
				List<ItemStack> dropsOriginal = super.getDrops(state, builder);
				if (!dropsOriginal.isEmpty())
					return dropsOriginal;
				return Collections.singletonList(new ItemStack(this, 1));
			}

			@Override
			public void onBlockAdded(BlockState blockstate, World world, BlockPos pos, BlockState oldState, boolean moving) {
				super.onBlockAdded(blockstate, world, pos, oldState, moving);
				int x = pos.getX();
				int y = pos.getY();
				int z = pos.getZ();
				world.getPendingBlockTicks().scheduleTick(pos, this, 1);

				AmaterasuBlockAddedProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}

			@Override
			public void tick(BlockState blockstate, ServerWorld world, BlockPos pos, Random random) {
				super.tick(blockstate, world, pos, random);
				int x = pos.getX();
				int y = pos.getY();
				int z = pos.getZ();

				AmaterasuUpdateTickProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				world.getPendingBlockTicks().scheduleTick(pos, this, 1);
			}

			@Override
			public void onEntityCollision(BlockState blockstate, World world, BlockPos pos, Entity entity) {
				super.onEntityCollision(blockstate, world, pos, entity);
				int x = pos.getX();
				int y = pos.getY();
				int z = pos.getZ();

				AmaterasuEntityCollidesInTheBlockProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}

			@Override
			public INamedContainerProvider getContainer(BlockState state, World worldIn, BlockPos pos) {
				TileEntity tileEntity = worldIn.getTileEntity(pos);
				return tileEntity instanceof INamedContainerProvider ? (INamedContainerProvider) tileEntity : null;
			}

			@Override
			public boolean hasTileEntity(BlockState state) {
				return true;
			}

			@Override
			public TileEntity createTileEntity(BlockState state, IBlockReader world) {
				return new CustomTileEntity();
			}

			@Override
			public boolean eventReceived(BlockState state, World world, BlockPos pos, int eventID, int eventParam) {
				super.eventReceived(state, world, pos, eventID, eventParam);
				TileEntity tileentity = world.getTileEntity(pos);
				return tileentity == null ? false : tileentity.receiveClientEvent(eventID, eventParam);
			}
		}

		public static class CustomTileEntity extends LockableLootTileEntity implements ISidedInventory {
			private NonNullList<ItemStack> stacks = NonNullList.<ItemStack>withSize(0, ItemStack.EMPTY);

			protected CustomTileEntity() {
				super(tileEntityType);
			}

			@Override
			public void read(BlockState blockState, CompoundNBT compound) {
				super.read(blockState, compound);
				if (!this.checkLootAndRead(compound)) {
					this.stacks = NonNullList.withSize(this.getSizeInventory(), ItemStack.EMPTY);
				}
				ItemStackHelper.loadAllItems(compound, this.stacks);
			}

			@Override
			public CompoundNBT write(CompoundNBT compound) {
				super.write(compound);
				if (!this.checkLootAndWrite(compound)) {
					ItemStackHelper.saveAllItems(compound, this.stacks);
				}
				return compound;
			}

			@Override
			public SUpdateTileEntityPacket getUpdatePacket() {
				return new SUpdateTileEntityPacket(this.pos, 0, this.getUpdateTag());
			}

			@Override
			public CompoundNBT getUpdateTag() {
				return this.write(new CompoundNBT());
			}

			@Override
			public void onDataPacket(NetworkManager net, SUpdateTileEntityPacket pkt) {
				this.read(this.getBlockState(), pkt.getNbtCompound());
			}

			@Override
			public int getSizeInventory() {
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
			public ITextComponent getDefaultName() {
				return new StringTextComponent("amaterasu_spread");
			}

			@Override
			public int getInventoryStackLimit() {
				return 64;
			}

			@Override
			public Container createMenu(int id, PlayerInventory player) {
				return ChestContainer.createGeneric9X3(id, player, this);
			}

			@Override
			public ITextComponent getDisplayName() {
				return new StringTextComponent("Amaterasu");
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
			public boolean isItemValidForSlot(int index, ItemStack stack) {
				return true;
			}

			@Override
			public int[] getSlotsForFace(Direction side) {
				return IntStream.range(0, this.getSizeInventory()).toArray();
			}

			@Override
			public boolean canInsertItem(int index, ItemStack stack, @Nullable Direction direction) {
				return this.isItemValidForSlot(index, stack);
			}

			@Override
			public boolean canExtractItem(int index, ItemStack stack, Direction direction) {
				return true;
			}

			private final LazyOptional<? extends IItemHandler>[] handlers = SidedInvWrapper.create(this, Direction.values());

			@Override
			public <T> LazyOptional<T> getCapability(Capability<T> capability, @Nullable Direction facing) {
				if (!this.removed && facing != null && capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
					return handlers[facing.ordinal()].cast();
				return super.getCapability(capability, facing);
			}

			@Override
			public void remove() {
				super.remove();
				for (LazyOptional<? extends IItemHandler> handler : handlers)
					handler.invalidate();
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class DustBlockBlock extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:dust_block")
		public static final Block block = null;

		public DustBlockBlock(NarutoShippudenModElements instance) {
			super(instance, 1070);
		}

		@Override
		public void initElements() {
			elements.blocks.add(() -> new CustomBlock());
			elements.items.add(() -> new BlockItem(block, new Item.Properties().group(null)).setRegistryName(block.getRegistryName()));
		}

		@Override
		@OnlyIn(Dist.CLIENT)
		public void clientLoad(FMLClientSetupEvent event) {
			RenderTypeLookup.setRenderLayer(block, RenderType.getTranslucent());
		}

		public static class CustomBlock extends Block {
			public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

			public CustomBlock() {
				super(Block.Properties.create(Material.AIR)
						.sound(new ForgeSoundType(1.0f, 1.0f, () -> new SoundEvent(new ResourceLocation("naruto_shippuden:dust_release")),
								() -> new SoundEvent(new ResourceLocation("naruto_shippuden:dust_release")),
								() -> new SoundEvent(new ResourceLocation("naruto_shippuden:dust_release")),
								() -> new SoundEvent(new ResourceLocation("naruto_shippuden:dust_release")),
								() -> new SoundEvent(new ResourceLocation("naruto_shippuden:dust_release"))))
						.hardnessAndResistance(-1, 3600000).setLightLevel(s -> 0).notSolid().setOpaque((bs, br, bp) -> false));
				this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH));
				setRegistryName("dust_block");
			}

			@OnlyIn(Dist.CLIENT)
			public boolean isSideInvisible(BlockState state, BlockState adjacentBlockState, Direction side) {
				return adjacentBlockState.getBlock() == this ? true : super.isSideInvisible(state, adjacentBlockState, side);
			}

			@Override
			public boolean propagatesSkylightDown(BlockState state, IBlockReader reader, BlockPos pos) {
				return true;
			}

			@Override
			public int getOpacity(BlockState state, IBlockReader worldIn, BlockPos pos) {
				return 0;
			}

			@Override
			protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
				builder.add(FACING);
			}

			@Override
			public BlockState getStateForPlacement(BlockItemUseContext context) {
				return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());
			}

			public BlockState rotate(BlockState state, Rotation rot) {
				return state.with(FACING, rot.rotate(state.get(FACING)));
			}

			public BlockState mirror(BlockState state, Mirror mirrorIn) {
				return state.rotate(mirrorIn.toRotation(state.get(FACING)));
			}

			@Override
			public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
				List<ItemStack> dropsOriginal = super.getDrops(state, builder);
				if (!dropsOriginal.isEmpty())
					return dropsOriginal;
				return Collections.singletonList(new ItemStack(this, 0));
			}

			@Override
			public void onBlockAdded(BlockState blockstate, World world, BlockPos pos, BlockState oldState, boolean moving) {
				super.onBlockAdded(blockstate, world, pos, oldState, moving);
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
		@ObjectHolder("naruto_shippuden:dust_block_view_2")
		public static final Block block = null;

		public DustBlockView2Block(NarutoShippudenModElements instance) {
			super(instance, 1074);
		}

		@Override
		public void initElements() {
			elements.blocks.add(() -> new CustomBlock());
			elements.items.add(() -> new BlockItem(block, new Item.Properties().group(null)).setRegistryName(block.getRegistryName()));
		}

		@Override
		@OnlyIn(Dist.CLIENT)
		public void clientLoad(FMLClientSetupEvent event) {
			RenderTypeLookup.setRenderLayer(block, RenderType.getTranslucent());
		}

		public static class CustomBlock extends Block {
			public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

			public CustomBlock() {
				super(Block.Properties.create(Material.AIR)
						.sound(new ForgeSoundType(1.0f, 1.0f, () -> new SoundEvent(new ResourceLocation("naruto_shippuden:dust_release")),
								() -> new SoundEvent(new ResourceLocation("naruto_shippuden:dust_release")),
								() -> new SoundEvent(new ResourceLocation("naruto_shippuden:dust_release")),
								() -> new SoundEvent(new ResourceLocation("naruto_shippuden:dust_release")),
								() -> new SoundEvent(new ResourceLocation("naruto_shippuden:dust_release"))))
						.hardnessAndResistance(-1, 3600000).setLightLevel(s -> 0).notSolid().setOpaque((bs, br, bp) -> false));
				this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH));
				setRegistryName("dust_block_view_2");
			}

			@OnlyIn(Dist.CLIENT)
			public boolean isSideInvisible(BlockState state, BlockState adjacentBlockState, Direction side) {
				return adjacentBlockState.getBlock() == this ? true : super.isSideInvisible(state, adjacentBlockState, side);
			}

			@Override
			public boolean propagatesSkylightDown(BlockState state, IBlockReader reader, BlockPos pos) {
				return true;
			}

			@Override
			public int getOpacity(BlockState state, IBlockReader worldIn, BlockPos pos) {
				return 0;
			}

			@Override
			protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
				builder.add(FACING);
			}

			@Override
			public BlockState getStateForPlacement(BlockItemUseContext context) {
				return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());
			}

			public BlockState rotate(BlockState state, Rotation rot) {
				return state.with(FACING, rot.rotate(state.get(FACING)));
			}

			public BlockState mirror(BlockState state, Mirror mirrorIn) {
				return state.rotate(mirrorIn.toRotation(state.get(FACING)));
			}

			@Override
			public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
				List<ItemStack> dropsOriginal = super.getDrops(state, builder);
				if (!dropsOriginal.isEmpty())
					return dropsOriginal;
				return Collections.singletonList(new ItemStack(this, 0));
			}

			@Override
			public void onBlockAdded(BlockState blockstate, World world, BlockPos pos, BlockState oldState, boolean moving) {
				super.onBlockAdded(blockstate, world, pos, oldState, moving);
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
		@ObjectHolder("naruto_shippuden:dust_block_view_3")
		public static final Block block = null;

		public DustBlockView3Block(NarutoShippudenModElements instance) {
			super(instance, 1076);
		}

		@Override
		public void initElements() {
			elements.blocks.add(() -> new CustomBlock());
			elements.items.add(() -> new BlockItem(block, new Item.Properties().group(null)).setRegistryName(block.getRegistryName()));
		}

		@Override
		@OnlyIn(Dist.CLIENT)
		public void clientLoad(FMLClientSetupEvent event) {
			RenderTypeLookup.setRenderLayer(block, RenderType.getTranslucent());
		}

		public static class CustomBlock extends Block {
			public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

			public CustomBlock() {
				super(Block.Properties.create(Material.AIR)
						.sound(new ForgeSoundType(1.0f, 1.0f, () -> new SoundEvent(new ResourceLocation("naruto_shippuden:dust_release")),
								() -> new SoundEvent(new ResourceLocation("naruto_shippuden:dust_release")),
								() -> new SoundEvent(new ResourceLocation("naruto_shippuden:dust_release")),
								() -> new SoundEvent(new ResourceLocation("naruto_shippuden:dust_release")),
								() -> new SoundEvent(new ResourceLocation("naruto_shippuden:dust_release"))))
						.hardnessAndResistance(-1, 3600000).setLightLevel(s -> 0).notSolid().setOpaque((bs, br, bp) -> false));
				this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH));
				setRegistryName("dust_block_view_3");
			}

			@OnlyIn(Dist.CLIENT)
			public boolean isSideInvisible(BlockState state, BlockState adjacentBlockState, Direction side) {
				return adjacentBlockState.getBlock() == this ? true : super.isSideInvisible(state, adjacentBlockState, side);
			}

			@Override
			public boolean propagatesSkylightDown(BlockState state, IBlockReader reader, BlockPos pos) {
				return true;
			}

			@Override
			public int getOpacity(BlockState state, IBlockReader worldIn, BlockPos pos) {
				return 0;
			}

			@Override
			protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
				builder.add(FACING);
			}

			@Override
			public BlockState getStateForPlacement(BlockItemUseContext context) {
				return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());
			}

			public BlockState rotate(BlockState state, Rotation rot) {
				return state.with(FACING, rot.rotate(state.get(FACING)));
			}

			public BlockState mirror(BlockState state, Mirror mirrorIn) {
				return state.rotate(mirrorIn.toRotation(state.get(FACING)));
			}

			@Override
			public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
				List<ItemStack> dropsOriginal = super.getDrops(state, builder);
				if (!dropsOriginal.isEmpty())
					return dropsOriginal;
				return Collections.singletonList(new ItemStack(this, 0));
			}

			@Override
			public void onBlockAdded(BlockState blockstate, World world, BlockPos pos, BlockState oldState, boolean moving) {
				super.onBlockAdded(blockstate, world, pos, oldState, moving);
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
		@ObjectHolder("naruto_shippuden:dust_block_view")
		public static final Block block = null;

		public DustBlockViewBlock(NarutoShippudenModElements instance) {
			super(instance, 1072);
		}

		@Override
		public void initElements() {
			elements.blocks.add(() -> new CustomBlock());
			elements.items.add(() -> new BlockItem(block, new Item.Properties().group(null)).setRegistryName(block.getRegistryName()));
		}

		@Override
		@OnlyIn(Dist.CLIENT)
		public void clientLoad(FMLClientSetupEvent event) {
			RenderTypeLookup.setRenderLayer(block, RenderType.getTranslucent());
		}

		public static class CustomBlock extends Block {
			public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

			public CustomBlock() {
				super(Block.Properties.create(Material.AIR)
						.sound(new ForgeSoundType(1.0f, 1.0f, () -> new SoundEvent(new ResourceLocation("naruto_shippuden:dust_release")),
								() -> new SoundEvent(new ResourceLocation("naruto_shippuden:dust_release")),
								() -> new SoundEvent(new ResourceLocation("naruto_shippuden:dust_release")),
								() -> new SoundEvent(new ResourceLocation("naruto_shippuden:dust_release")),
								() -> new SoundEvent(new ResourceLocation("naruto_shippuden:dust_release"))))
						.hardnessAndResistance(-1, 3600000).setLightLevel(s -> 0).notSolid().setOpaque((bs, br, bp) -> false));
				this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH));
				setRegistryName("dust_block_view");
			}

			@OnlyIn(Dist.CLIENT)
			public boolean isSideInvisible(BlockState state, BlockState adjacentBlockState, Direction side) {
				return adjacentBlockState.getBlock() == this ? true : super.isSideInvisible(state, adjacentBlockState, side);
			}

			@Override
			public boolean propagatesSkylightDown(BlockState state, IBlockReader reader, BlockPos pos) {
				return true;
			}

			@Override
			public int getOpacity(BlockState state, IBlockReader worldIn, BlockPos pos) {
				return 0;
			}

			@Override
			protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
				builder.add(FACING);
			}

			@Override
			public BlockState getStateForPlacement(BlockItemUseContext context) {
				return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());
			}

			public BlockState rotate(BlockState state, Rotation rot) {
				return state.with(FACING, rot.rotate(state.get(FACING)));
			}

			public BlockState mirror(BlockState state, Mirror mirrorIn) {
				return state.rotate(mirrorIn.toRotation(state.get(FACING)));
			}

			@Override
			public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
				List<ItemStack> dropsOriginal = super.getDrops(state, builder);
				if (!dropsOriginal.isEmpty())
					return dropsOriginal;
				return Collections.singletonList(new ItemStack(this, 0));
			}

			@Override
			public void onBlockAdded(BlockState blockstate, World world, BlockPos pos, BlockState oldState, boolean moving) {
				super.onBlockAdded(blockstate, world, pos, oldState, moving);
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
		@ObjectHolder("naruto_shippuden:earth_wall")
		public static final Block block = null;

		public EarthWallBlock(NarutoShippudenModElements instance) {
			super(instance, 97);
		}

		@Override
		public void initElements() {
			elements.blocks.add(() -> new CustomBlock());
			elements.items.add(() -> new BlockItem(block, new Item.Properties().group(null)).setRegistryName(block.getRegistryName()));
		}

		public static class CustomBlock extends Block {
			public CustomBlock() {
				super(Block.Properties.create(Material.EARTH).sound(SoundType.GROUND).hardnessAndResistance(-1, 3600000).setLightLevel(s -> 0));
				setRegistryName("earth_wall");
			}

			@Override
			public int getOpacity(BlockState state, IBlockReader worldIn, BlockPos pos) {
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
			public void onBlockAdded(BlockState blockstate, World world, BlockPos pos, BlockState oldState, boolean moving) {
				super.onBlockAdded(blockstate, world, pos, oldState, moving);
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
		@ObjectHolder("naruto_shippuden:kamui_stone")
		public static final Block block = null;

		public KamuiStoneBlock(NarutoShippudenModElements instance) {
			super(instance, 1236);
		}

		@Override
		public void initElements() {
			elements.blocks.add(() -> new CustomBlock());
			elements.items.add(() -> new BlockItem(block, new Item.Properties().group(BlocksItemGroup.tab)).setRegistryName(block.getRegistryName()));
		}

		public static class CustomBlock extends Block {
			public CustomBlock() {
				super(Block.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(1f, 10f).setLightLevel(s -> 0).harvestLevel(2)
						.harvestTool(ToolType.PICKAXE));
				setRegistryName("kamui_stone");
			}

			@Override
			public int getOpacity(BlockState state, IBlockReader worldIn, BlockPos pos) {
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
		@ObjectHolder("naruto_shippuden:kamui_void")
		public static final Block block = null;

		public KamuiVoidBlock(NarutoShippudenModElements instance) {
			super(instance, 1234);
		}

		@Override
		public void initElements() {
			elements.blocks.add(() -> new CustomBlock());
			elements.items.add(() -> new BlockItem(block, new Item.Properties().group(null)).setRegistryName(block.getRegistryName()));
		}

		public static class CustomBlock extends Block {
			public CustomBlock() {
				super(Block.Properties.create(Material.MISCELLANEOUS).sound(SoundType.STONE).hardnessAndResistance(-1, 3600000).setLightLevel(s -> 0));
				setRegistryName("kamui_void");
			}

			@Override
			public int getOpacity(BlockState state, IBlockReader worldIn, BlockPos pos) {
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
		@ObjectHolder("naruto_shippuden:nara_shadow")
		public static final Block block = null;

		public NaraShadowBlock(NarutoShippudenModElements instance) {
			super(instance, 993);
		}

		@Override
		public void initElements() {
			elements.blocks.add(() -> new CustomBlock());
			elements.items.add(() -> new BlockItem(block, new Item.Properties().group(null)).setRegistryName(block.getRegistryName()));
		}

		public static class CustomBlock extends Block {
			public CustomBlock() {
				super(Block.Properties.create(Material.WATER).sound(SoundType.GROUND).hardnessAndResistance(-1, 3600000).setLightLevel(s -> 0)
						.doesNotBlockMovement());
				setRegistryName("nara_shadow");
			}

			@Override
			public int getOpacity(BlockState state, IBlockReader worldIn, BlockPos pos) {
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
			public void onBlockPlacedBy(World world, BlockPos pos, BlockState blockstate, LivingEntity entity, ItemStack itemstack) {
				super.onBlockPlacedBy(world, pos, blockstate, entity, itemstack);
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
		@ObjectHolder("naruto_shippuden:paper_bomb")
		public static final Block block = null;

		public PaperBombBlock(NarutoShippudenModElements instance) {
			super(instance, 1290);
		}

		@Override
		public void initElements() {
			elements.blocks.add(() -> new CustomBlock());
			elements.items.add(() -> new BlockItem(block, new Item.Properties().group(BlocksItemGroup.tab)).setRegistryName(block.getRegistryName()));
		}

		@Override
		@OnlyIn(Dist.CLIENT)
		public void clientLoad(FMLClientSetupEvent event) {
			RenderTypeLookup.setRenderLayer(block, RenderType.getCutoutMipped());
		}

		public static class CustomBlock extends FallingBlock {
			public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

			public CustomBlock() {
				super(Block.Properties.create(Material.CARPET).sound(SoundType.VINE).hardnessAndResistance(0.1f, 0.1f).setLightLevel(s -> 0)
						.doesNotBlockMovement().notSolid().setOpaque((bs, br, bp) -> false));
				this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH));
				setRegistryName("paper_bomb");
			}

			@Override
			public boolean propagatesSkylightDown(BlockState state, IBlockReader reader, BlockPos pos) {
				return true;
			}

			@Override
			public int getOpacity(BlockState state, IBlockReader worldIn, BlockPos pos) {
				return 0;
			}

			@Override
			public VoxelShape getShape(BlockState state, IBlockReader world, BlockPos pos, ISelectionContext context) {
				Vector3d offset = state.getOffset(world, pos);
				switch ((Direction) state.get(FACING)) {
					case SOUTH :
					default :
						return VoxelShapes.or(makeCuboidShape(12, 0, 10, 4, 1, 6))

								.withOffset(offset.x, offset.y, offset.z);
					case NORTH :
						return VoxelShapes.or(makeCuboidShape(4, 0, 6, 12, 1, 10))

								.withOffset(offset.x, offset.y, offset.z);
					case EAST :
						return VoxelShapes.or(makeCuboidShape(10, 0, 4, 6, 1, 12))

								.withOffset(offset.x, offset.y, offset.z);
					case WEST :
						return VoxelShapes.or(makeCuboidShape(6, 0, 12, 10, 1, 4))

								.withOffset(offset.x, offset.y, offset.z);
				}
			}

			@Override
			protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
				builder.add(FACING);
			}

			@Override
			public BlockState getStateForPlacement(BlockItemUseContext context) {
				return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());
			}

			public BlockState rotate(BlockState state, Rotation rot) {
				return state.with(FACING, rot.rotate(state.get(FACING)));
			}

			public BlockState mirror(BlockState state, Mirror mirrorIn) {
				return state.rotate(mirrorIn.toRotation(state.get(FACING)));
			}

			@Override
			public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
				List<ItemStack> dropsOriginal = super.getDrops(state, builder);
				if (!dropsOriginal.isEmpty())
					return dropsOriginal;
				return Collections.singletonList(new ItemStack(this, 1));
			}

			@Override
			public void onEntityCollision(BlockState blockstate, World world, BlockPos pos, Entity entity) {
				super.onEntityCollision(blockstate, world, pos, entity);
				int x = pos.getX();
				int y = pos.getY();
				int z = pos.getZ();

				PaperBombEntityWalksOnTheBlockProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}

			@Override
			public void onEntityWalk(World world, BlockPos pos, Entity entity) {
				super.onEntityWalk(world, pos, entity);
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
			public void onProjectileCollision(World world, BlockState blockstate, BlockRayTraceResult hit, ProjectileEntity entity) {
				BlockPos pos = hit.getPos();
				int x = pos.getX();
				int y = pos.getY();
				int z = pos.getZ();
				double hitX = hit.getHitVec().x;
				double hitY = hit.getHitVec().y;
				double hitZ = hit.getHitVec().z;
				Direction direction = hit.getFace();

				PaperBombEntityWalksOnTheBlockProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class WaterwallBlock extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:waterwall")
		public static final Block block = null;

		public WaterwallBlock(NarutoShippudenModElements instance) {
			super(instance, 90);
		}

		@Override
		public void initElements() {
			elements.blocks.add(() -> new CustomBlock());
			elements.items.add(() -> new BlockItem(block, new Item.Properties().group(null)).setRegistryName(block.getRegistryName()));
		}

		public static class CustomBlock extends Block {
			public CustomBlock() {
				super(Block.Properties.create(Material.WATER).sound(SoundType.GROUND).hardnessAndResistance(-1, 3600000).setLightLevel(s -> 0)
						.doesNotBlockMovement());
				setRegistryName("waterwall");
			}

			@Override
			public int getOpacity(BlockState state, IBlockReader worldIn, BlockPos pos) {
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
			public void onBlockAdded(BlockState blockstate, World world, BlockPos pos, BlockState oldState, boolean moving) {
				super.onBlockAdded(blockstate, world, pos, oldState, moving);
				int x = pos.getX();
				int y = pos.getY();
				int z = pos.getZ();

				EarthWallBlockAddedProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}

			@Override
			public void onEntityCollision(BlockState blockstate, World world, BlockPos pos, Entity entity) {
				super.onEntityCollision(blockstate, world, pos, entity);
				int x = pos.getX();
				int y = pos.getY();
				int z = pos.getZ();

				WaterwallEntityCollidesInTheBlockProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
		}
	}
}
