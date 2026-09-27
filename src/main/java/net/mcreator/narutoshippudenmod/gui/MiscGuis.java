package net.mcreator.narutoshippudenmod.gui;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Stream;
import net.mcreator.narutoshippudenmod.NarutoShippudenModElements;
import net.mcreator.narutoshippudenmod.gui.MiscScreens.AdventCalendarGUIGuiWindow;
import net.mcreator.narutoshippudenmod.gui.MiscScreens.GeninHeadbandSelectGuiWindow;
import net.mcreator.narutoshippudenmod.gui.MiscScreens.PatreonKitGuiWindow;
import net.mcreator.narutoshippudenmod.procedures.GiftProcedures.GiftOpen10Procedure;
import net.mcreator.narutoshippudenmod.procedures.GiftProcedures.GiftOpen11Procedure;
import net.mcreator.narutoshippudenmod.procedures.GiftProcedures.GiftOpen12Procedure;
import net.mcreator.narutoshippudenmod.procedures.GiftProcedures.GiftOpen13Procedure;
import net.mcreator.narutoshippudenmod.procedures.GiftProcedures.GiftOpen14Procedure;
import net.mcreator.narutoshippudenmod.procedures.GiftProcedures.GiftOpen15Procedure;
import net.mcreator.narutoshippudenmod.procedures.GiftProcedures.GiftOpen16Procedure;
import net.mcreator.narutoshippudenmod.procedures.GiftProcedures.GiftOpen17Procedure;
import net.mcreator.narutoshippudenmod.procedures.GiftProcedures.GiftOpen18Procedure;
import net.mcreator.narutoshippudenmod.procedures.GiftProcedures.GiftOpen19Procedure;
import net.mcreator.narutoshippudenmod.procedures.GiftProcedures.GiftOpen1Procedure;
import net.mcreator.narutoshippudenmod.procedures.GiftProcedures.GiftOpen20Procedure;
import net.mcreator.narutoshippudenmod.procedures.GiftProcedures.GiftOpen21Procedure;
import net.mcreator.narutoshippudenmod.procedures.GiftProcedures.GiftOpen22Procedure;
import net.mcreator.narutoshippudenmod.procedures.GiftProcedures.GiftOpen23Procedure;
import net.mcreator.narutoshippudenmod.procedures.GiftProcedures.GiftOpen24Procedure;
import net.mcreator.narutoshippudenmod.procedures.GiftProcedures.GiftOpen25Procedure;
import net.mcreator.narutoshippudenmod.procedures.GiftProcedures.GiftOpen2Procedure;
import net.mcreator.narutoshippudenmod.procedures.GiftProcedures.GiftOpen3Procedure;
import net.mcreator.narutoshippudenmod.procedures.GiftProcedures.GiftOpen4Procedure;
import net.mcreator.narutoshippudenmod.procedures.GiftProcedures.GiftOpen5Procedure;
import net.mcreator.narutoshippudenmod.procedures.GiftProcedures.GiftOpen6Procedure;
import net.mcreator.narutoshippudenmod.procedures.GiftProcedures.GiftOpen7Procedure;
import net.mcreator.narutoshippudenmod.procedures.GiftProcedures.GiftOpen8Procedure;
import net.mcreator.narutoshippudenmod.procedures.GiftProcedures.GiftOpen9Procedure;
import net.mcreator.narutoshippudenmod.procedures.GuiProcedures.HeadbandSelectBackProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiProcedures.HeadbandSelectNextProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiProcedures.HeadbandSelectProcedure;
import net.mcreator.narutoshippudenmod.procedures.MissionAndCommandProcedures.PatreonKitClaimProcedure;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.inventory.container.Slot;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.network.IContainerFactory;
import net.minecraftforge.fml.network.NetworkEvent;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public final class MiscGuis {
	private MiscGuis() {
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class AdventCalendarGUIGui extends NarutoShippudenModElements.ModElement {
		public static HashMap guistate = new HashMap();
		private static ContainerType<GuiContainerMod> containerType = null;

		public AdventCalendarGUIGui(NarutoShippudenModElements instance) {
			super(instance, 845);
			elements.addNetworkMessage(ButtonPressedMessage.class, ButtonPressedMessage::buffer, ButtonPressedMessage::new,
					ButtonPressedMessage::handler);
			elements.addNetworkMessage(GUISlotChangedMessage.class, GUISlotChangedMessage::buffer, GUISlotChangedMessage::new,
					GUISlotChangedMessage::handler);
			containerType = new ContainerType<>(new GuiContainerModFactory());
			FMLJavaModLoadingContext.get().getModEventBus().register(new ContainerRegisterHandler());
		}

		private static class ContainerRegisterHandler {
			@SubscribeEvent
			public void registerContainer(RegistryEvent.Register<ContainerType<?>> event) {
				event.getRegistry().register(containerType.setRegistryName("advent_calendar_gui"));
			}
		}

		@OnlyIn(Dist.CLIENT)
		public void initElements() {
			DeferredWorkQueue.runLater(() -> ScreenManager.registerFactory(containerType, AdventCalendarGUIGuiWindow::new));
		}

		public static class GuiContainerModFactory implements IContainerFactory {
			public GuiContainerMod create(int id, PlayerInventory inv, PacketBuffer extraData) {
				return new GuiContainerMod(id, inv, extraData);
			}
		}

		public static class GuiContainerMod extends Container implements Supplier<Map<Integer, Slot>> {
			World world;
			PlayerEntity entity;
			int x, y, z;
			private IItemHandler internal;
			private Map<Integer, Slot> customSlots = new HashMap<>();
			private boolean bound = false;

			public GuiContainerMod(int id, PlayerInventory inv, PacketBuffer extraData) {
				super(containerType, id);
				this.entity = inv.player;
				this.world = inv.player.world;
				this.internal = new ItemStackHandler(0);
				BlockPos pos = null;
				if (extraData != null) {
					pos = extraData.readBlockPos();
					this.x = pos.getX();
					this.y = pos.getY();
					this.z = pos.getZ();
				}
			}

			public Map<Integer, Slot> get() {
				return customSlots;
			}

			@Override
			public boolean canInteractWith(PlayerEntity player) {
				return true;
			}
		}

		public static class ButtonPressedMessage {
			int buttonID, x, y, z;

			public ButtonPressedMessage(PacketBuffer buffer) {
				this.buttonID = buffer.readInt();
				this.x = buffer.readInt();
				this.y = buffer.readInt();
				this.z = buffer.readInt();
			}

			public ButtonPressedMessage(int buttonID, int x, int y, int z) {
				this.buttonID = buttonID;
				this.x = x;
				this.y = y;
				this.z = z;
			}

			public static void buffer(ButtonPressedMessage message, PacketBuffer buffer) {
				buffer.writeInt(message.buttonID);
				buffer.writeInt(message.x);
				buffer.writeInt(message.y);
				buffer.writeInt(message.z);
			}

			public static void handler(ButtonPressedMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
				NetworkEvent.Context context = contextSupplier.get();
				context.enqueueWork(() -> {
					PlayerEntity entity = context.getSender();
					int buttonID = message.buttonID;
					int x = message.x;
					int y = message.y;
					int z = message.z;
					handleButtonAction(entity, buttonID, x, y, z);
				});
				context.setPacketHandled(true);
			}
		}

		public static class GUISlotChangedMessage {
			int slotID, x, y, z, changeType, meta;

			public GUISlotChangedMessage(int slotID, int x, int y, int z, int changeType, int meta) {
				this.slotID = slotID;
				this.x = x;
				this.y = y;
				this.z = z;
				this.changeType = changeType;
				this.meta = meta;
			}

			public GUISlotChangedMessage(PacketBuffer buffer) {
				this.slotID = buffer.readInt();
				this.x = buffer.readInt();
				this.y = buffer.readInt();
				this.z = buffer.readInt();
				this.changeType = buffer.readInt();
				this.meta = buffer.readInt();
			}

			public static void buffer(GUISlotChangedMessage message, PacketBuffer buffer) {
				buffer.writeInt(message.slotID);
				buffer.writeInt(message.x);
				buffer.writeInt(message.y);
				buffer.writeInt(message.z);
				buffer.writeInt(message.changeType);
				buffer.writeInt(message.meta);
			}

			public static void handler(GUISlotChangedMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
				NetworkEvent.Context context = contextSupplier.get();
				context.enqueueWork(() -> {
					PlayerEntity entity = context.getSender();
					int slotID = message.slotID;
					int changeType = message.changeType;
					int meta = message.meta;
					int x = message.x;
					int y = message.y;
					int z = message.z;
					handleSlotAction(entity, slotID, changeType, meta, x, y, z);
				});
				context.setPacketHandled(true);
			}
		}

		static void handleButtonAction(PlayerEntity entity, int buttonID, int x, int y, int z) {
			World world = entity.world;
			// security measure to prevent arbitrary chunk generation
			if (!world.isBlockLoaded(new BlockPos(x, y, z)))
				return;
			if (buttonID == 0) {

				GiftOpen1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 1) {

				GiftOpen2Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 2) {

				GiftOpen3Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 3) {

				GiftOpen4Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 4) {

				GiftOpen8Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 5) {

				GiftOpen6Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 6) {

				GiftOpen7Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 7) {

				GiftOpen5Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 8) {

				GiftOpen9Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 9) {

				GiftOpen10Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 10) {

				GiftOpen11Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 11) {

				GiftOpen12Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 12) {

				GiftOpen13Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 13) {

				GiftOpen14Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 14) {

				GiftOpen15Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 15) {

				GiftOpen16Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 16) {

				GiftOpen17Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 17) {

				GiftOpen18Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 18) {

				GiftOpen19Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 19) {

				GiftOpen20Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 20) {

				GiftOpen21Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 21) {

				GiftOpen22Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 22) {

				GiftOpen23Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 23) {

				GiftOpen24Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 24) {

				GiftOpen25Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
		}

		private static void handleSlotAction(PlayerEntity entity, int slotID, int changeType, int meta, int x, int y, int z) {
			World world = entity.world;
			// security measure to prevent arbitrary chunk generation
			if (!world.isBlockLoaded(new BlockPos(x, y, z)))
				return;
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class GeninHeadbandSelectGui extends NarutoShippudenModElements.ModElement {
		public static HashMap guistate = new HashMap();
		private static ContainerType<GuiContainerMod> containerType = null;

		public GeninHeadbandSelectGui(NarutoShippudenModElements instance) {
			super(instance, 1196);
			elements.addNetworkMessage(ButtonPressedMessage.class, ButtonPressedMessage::buffer, ButtonPressedMessage::new,
					ButtonPressedMessage::handler);
			elements.addNetworkMessage(GUISlotChangedMessage.class, GUISlotChangedMessage::buffer, GUISlotChangedMessage::new,
					GUISlotChangedMessage::handler);
			containerType = new ContainerType<>(new GuiContainerModFactory());
			FMLJavaModLoadingContext.get().getModEventBus().register(new ContainerRegisterHandler());
		}

		private static class ContainerRegisterHandler {
			@SubscribeEvent
			public void registerContainer(RegistryEvent.Register<ContainerType<?>> event) {
				event.getRegistry().register(containerType.setRegistryName("genin_headband_select"));
			}
		}

		@OnlyIn(Dist.CLIENT)
		public void initElements() {
			DeferredWorkQueue.runLater(() -> ScreenManager.registerFactory(containerType, GeninHeadbandSelectGuiWindow::new));
		}

		public static class GuiContainerModFactory implements IContainerFactory {
			public GuiContainerMod create(int id, PlayerInventory inv, PacketBuffer extraData) {
				return new GuiContainerMod(id, inv, extraData);
			}
		}

		public static class GuiContainerMod extends Container implements Supplier<Map<Integer, Slot>> {
			World world;
			PlayerEntity entity;
			int x, y, z;
			private IItemHandler internal;
			private Map<Integer, Slot> customSlots = new HashMap<>();
			private boolean bound = false;

			public GuiContainerMod(int id, PlayerInventory inv, PacketBuffer extraData) {
				super(containerType, id);
				this.entity = inv.player;
				this.world = inv.player.world;
				this.internal = new ItemStackHandler(0);
				BlockPos pos = null;
				if (extraData != null) {
					pos = extraData.readBlockPos();
					this.x = pos.getX();
					this.y = pos.getY();
					this.z = pos.getZ();
				}
			}

			public Map<Integer, Slot> get() {
				return customSlots;
			}

			@Override
			public boolean canInteractWith(PlayerEntity player) {
				return true;
			}
		}

		public static class ButtonPressedMessage {
			int buttonID, x, y, z;

			public ButtonPressedMessage(PacketBuffer buffer) {
				this.buttonID = buffer.readInt();
				this.x = buffer.readInt();
				this.y = buffer.readInt();
				this.z = buffer.readInt();
			}

			public ButtonPressedMessage(int buttonID, int x, int y, int z) {
				this.buttonID = buttonID;
				this.x = x;
				this.y = y;
				this.z = z;
			}

			public static void buffer(ButtonPressedMessage message, PacketBuffer buffer) {
				buffer.writeInt(message.buttonID);
				buffer.writeInt(message.x);
				buffer.writeInt(message.y);
				buffer.writeInt(message.z);
			}

			public static void handler(ButtonPressedMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
				NetworkEvent.Context context = contextSupplier.get();
				context.enqueueWork(() -> {
					PlayerEntity entity = context.getSender();
					int buttonID = message.buttonID;
					int x = message.x;
					int y = message.y;
					int z = message.z;
					handleButtonAction(entity, buttonID, x, y, z);
				});
				context.setPacketHandled(true);
			}
		}

		public static class GUISlotChangedMessage {
			int slotID, x, y, z, changeType, meta;

			public GUISlotChangedMessage(int slotID, int x, int y, int z, int changeType, int meta) {
				this.slotID = slotID;
				this.x = x;
				this.y = y;
				this.z = z;
				this.changeType = changeType;
				this.meta = meta;
			}

			public GUISlotChangedMessage(PacketBuffer buffer) {
				this.slotID = buffer.readInt();
				this.x = buffer.readInt();
				this.y = buffer.readInt();
				this.z = buffer.readInt();
				this.changeType = buffer.readInt();
				this.meta = buffer.readInt();
			}

			public static void buffer(GUISlotChangedMessage message, PacketBuffer buffer) {
				buffer.writeInt(message.slotID);
				buffer.writeInt(message.x);
				buffer.writeInt(message.y);
				buffer.writeInt(message.z);
				buffer.writeInt(message.changeType);
				buffer.writeInt(message.meta);
			}

			public static void handler(GUISlotChangedMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
				NetworkEvent.Context context = contextSupplier.get();
				context.enqueueWork(() -> {
					PlayerEntity entity = context.getSender();
					int slotID = message.slotID;
					int changeType = message.changeType;
					int meta = message.meta;
					int x = message.x;
					int y = message.y;
					int z = message.z;
					handleSlotAction(entity, slotID, changeType, meta, x, y, z);
				});
				context.setPacketHandled(true);
			}
		}

		static void handleButtonAction(PlayerEntity entity, int buttonID, int x, int y, int z) {
			World world = entity.world;
			// security measure to prevent arbitrary chunk generation
			if (!world.isBlockLoaded(new BlockPos(x, y, z)))
				return;
			if (buttonID == 0) {

				HeadbandSelectBackProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 1) {

				HeadbandSelectNextProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 2) {

				HeadbandSelectProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
		}

		private static void handleSlotAction(PlayerEntity entity, int slotID, int changeType, int meta, int x, int y, int z) {
			World world = entity.world;
			// security measure to prevent arbitrary chunk generation
			if (!world.isBlockLoaded(new BlockPos(x, y, z)))
				return;
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class PatreonKitGui extends NarutoShippudenModElements.ModElement {
		public static HashMap guistate = new HashMap();
		private static ContainerType<GuiContainerMod> containerType = null;

		public PatreonKitGui(NarutoShippudenModElements instance) {
			super(instance, 325);
			elements.addNetworkMessage(ButtonPressedMessage.class, ButtonPressedMessage::buffer, ButtonPressedMessage::new,
					ButtonPressedMessage::handler);
			elements.addNetworkMessage(GUISlotChangedMessage.class, GUISlotChangedMessage::buffer, GUISlotChangedMessage::new,
					GUISlotChangedMessage::handler);
			containerType = new ContainerType<>(new GuiContainerModFactory());
			FMLJavaModLoadingContext.get().getModEventBus().register(new ContainerRegisterHandler());
		}

		private static class ContainerRegisterHandler {
			@SubscribeEvent
			public void registerContainer(RegistryEvent.Register<ContainerType<?>> event) {
				event.getRegistry().register(containerType.setRegistryName("patreon_kit"));
			}
		}

		@OnlyIn(Dist.CLIENT)
		public void initElements() {
			DeferredWorkQueue.runLater(() -> ScreenManager.registerFactory(containerType, PatreonKitGuiWindow::new));
		}

		public static class GuiContainerModFactory implements IContainerFactory {
			public GuiContainerMod create(int id, PlayerInventory inv, PacketBuffer extraData) {
				return new GuiContainerMod(id, inv, extraData);
			}
		}

		public static class GuiContainerMod extends Container implements Supplier<Map<Integer, Slot>> {
			World world;
			PlayerEntity entity;
			int x, y, z;
			private IItemHandler internal;
			private Map<Integer, Slot> customSlots = new HashMap<>();
			private boolean bound = false;

			public GuiContainerMod(int id, PlayerInventory inv, PacketBuffer extraData) {
				super(containerType, id);
				this.entity = inv.player;
				this.world = inv.player.world;
				this.internal = new ItemStackHandler(0);
				BlockPos pos = null;
				if (extraData != null) {
					pos = extraData.readBlockPos();
					this.x = pos.getX();
					this.y = pos.getY();
					this.z = pos.getZ();
				}
			}

			public Map<Integer, Slot> get() {
				return customSlots;
			}

			@Override
			public boolean canInteractWith(PlayerEntity player) {
				return true;
			}
		}

		public static class ButtonPressedMessage {
			int buttonID, x, y, z;

			public ButtonPressedMessage(PacketBuffer buffer) {
				this.buttonID = buffer.readInt();
				this.x = buffer.readInt();
				this.y = buffer.readInt();
				this.z = buffer.readInt();
			}

			public ButtonPressedMessage(int buttonID, int x, int y, int z) {
				this.buttonID = buttonID;
				this.x = x;
				this.y = y;
				this.z = z;
			}

			public static void buffer(ButtonPressedMessage message, PacketBuffer buffer) {
				buffer.writeInt(message.buttonID);
				buffer.writeInt(message.x);
				buffer.writeInt(message.y);
				buffer.writeInt(message.z);
			}

			public static void handler(ButtonPressedMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
				NetworkEvent.Context context = contextSupplier.get();
				context.enqueueWork(() -> {
					PlayerEntity entity = context.getSender();
					int buttonID = message.buttonID;
					int x = message.x;
					int y = message.y;
					int z = message.z;
					handleButtonAction(entity, buttonID, x, y, z);
				});
				context.setPacketHandled(true);
			}
		}

		public static class GUISlotChangedMessage {
			int slotID, x, y, z, changeType, meta;

			public GUISlotChangedMessage(int slotID, int x, int y, int z, int changeType, int meta) {
				this.slotID = slotID;
				this.x = x;
				this.y = y;
				this.z = z;
				this.changeType = changeType;
				this.meta = meta;
			}

			public GUISlotChangedMessage(PacketBuffer buffer) {
				this.slotID = buffer.readInt();
				this.x = buffer.readInt();
				this.y = buffer.readInt();
				this.z = buffer.readInt();
				this.changeType = buffer.readInt();
				this.meta = buffer.readInt();
			}

			public static void buffer(GUISlotChangedMessage message, PacketBuffer buffer) {
				buffer.writeInt(message.slotID);
				buffer.writeInt(message.x);
				buffer.writeInt(message.y);
				buffer.writeInt(message.z);
				buffer.writeInt(message.changeType);
				buffer.writeInt(message.meta);
			}

			public static void handler(GUISlotChangedMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
				NetworkEvent.Context context = contextSupplier.get();
				context.enqueueWork(() -> {
					PlayerEntity entity = context.getSender();
					int slotID = message.slotID;
					int changeType = message.changeType;
					int meta = message.meta;
					int x = message.x;
					int y = message.y;
					int z = message.z;
					handleSlotAction(entity, slotID, changeType, meta, x, y, z);
				});
				context.setPacketHandled(true);
			}
		}

		static void handleButtonAction(PlayerEntity entity, int buttonID, int x, int y, int z) {
			World world = entity.world;
			// security measure to prevent arbitrary chunk generation
			if (!world.isBlockLoaded(new BlockPos(x, y, z)))
				return;
			if (buttonID == 0) {

				PatreonKitClaimProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
		}

		private static void handleSlotAction(PlayerEntity entity, int slotID, int changeType, int meta, int x, int y, int z) {
			World world = entity.world;
			// security measure to prevent arbitrary chunk generation
			if (!world.isBlockLoaded(new BlockPos(x, y, z)))
				return;
		}
	}
}
