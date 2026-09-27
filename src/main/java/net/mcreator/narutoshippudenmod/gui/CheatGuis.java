package net.mcreator.narutoshippudenmod.gui;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Stream;
import net.mcreator.narutoshippudenmod.NarutoShippudenModElements;
import net.mcreator.narutoshippudenmod.gui.CheatScreens.MangekyouSharinganCheatGuiWindow;
import net.mcreator.narutoshippudenmod.gui.CheatScreens.NarutoShippudenCheatDojutsuGUIGuiWindow;
import net.mcreator.narutoshippudenmod.gui.CheatScreens.NarutoShippudenCheatGUIGuiWindow;
import net.mcreator.narutoshippudenmod.gui.CheatScreens.NarutoShippudenCheatKekkeiGenkaiGUIGuiWindow;
import net.mcreator.narutoshippudenmod.gui.CheatScreens.PasswordGUIDojutsuGuiWindow;
import net.mcreator.narutoshippudenmod.procedures.CheatProcedures.CheatDojutstuButtonShimuraProcedure;
import net.mcreator.narutoshippudenmod.procedures.CheatProcedures.CheatDojutsuButtonBackProcedure;
import net.mcreator.narutoshippudenmod.procedures.CheatProcedures.CheatDojutsuButtonByakuganProcedure;
import net.mcreator.narutoshippudenmod.procedures.CheatProcedures.CheatDojutsuButtonIsshikiDojutsuProcedure;
import net.mcreator.narutoshippudenmod.procedures.CheatProcedures.CheatDojutsuButtonKetsuryuganProcedure;
import net.mcreator.narutoshippudenmod.procedures.CheatProcedures.CheatDojutsuButtonProcedure;
import net.mcreator.narutoshippudenmod.procedures.CheatProcedures.CheatDojutsuButtonRinneganProcedure;
import net.mcreator.narutoshippudenmod.procedures.CheatProcedures.CheatDojutsuButtonSharinganProcedure;
import net.mcreator.narutoshippudenmod.procedures.CheatProcedures.CheatDojutsuButtonTenseiganProcedure;
import net.mcreator.narutoshippudenmod.procedures.CheatProcedures.CheatKekkeiGenkaiButtonBoilReleaseProcedure;
import net.mcreator.narutoshippudenmod.procedures.CheatProcedures.CheatKekkeiGenkaiButtonBoneReleaseProcedure;
import net.mcreator.narutoshippudenmod.procedures.CheatProcedures.CheatKekkeiGenkaiButtonDustReleaseProcedure;
import net.mcreator.narutoshippudenmod.procedures.CheatProcedures.CheatKekkeiGenkaiButtonIceReleaseProcedure;
import net.mcreator.narutoshippudenmod.procedures.CheatProcedures.CheatKekkeiGenkaiButtonMagnetReleaseProcedure;
import net.mcreator.narutoshippudenmod.procedures.CheatProcedures.CheatKekkeiGenkaiButtonProcedure;
import net.mcreator.narutoshippudenmod.procedures.CheatProcedures.CheatKekkeiGenkaiButtonSmokeReleaseProcedure;
import net.mcreator.narutoshippudenmod.procedures.CheatProcedures.CheatKekkeiGenkaiButtonSteelReleaseProcedure;
import net.mcreator.narutoshippudenmod.procedures.CheatProcedures.CheatKekkeiGenkaiButtonStormReleaseProcedure;
import net.mcreator.narutoshippudenmod.procedures.CheatProcedures.CheatKekkeiGenkaiButtonSwiftReleaseProcedure;
import net.mcreator.narutoshippudenmod.procedures.CheatProcedures.CheatKekkeiGenkaiButtonTyphoonReleaseProcedure;
import net.mcreator.narutoshippudenmod.procedures.CheatProcedures.CheatKekkeiGenkaiButtonWoodReleaseProcedure;
import net.mcreator.narutoshippudenmod.procedures.CheatProcedures.ItachiMSCheatProcedure;
import net.mcreator.narutoshippudenmod.procedures.CheatProcedures.KakashiMSCheatProcedure;
import net.mcreator.narutoshippudenmod.procedures.CheatProcedures.KakashiSharinganCheatProcedure;
import net.mcreator.narutoshippudenmod.procedures.CheatProcedures.MadaraMSCheatProcedure;
import net.mcreator.narutoshippudenmod.procedures.CheatProcedures.MangekyouCheatGUIOpenProcedure;
import net.mcreator.narutoshippudenmod.procedures.CheatProcedures.ObitoMSCheatProcedure;
import net.mcreator.narutoshippudenmod.procedures.CheatProcedures.SasukeMSCheatProcedure;
import net.mcreator.narutoshippudenmod.procedures.CheatProcedures.ShisuiMSCheatProcedure;
import net.mcreator.narutoshippudenmod.procedures.DojutsuProcedures.ByakuganAwake10SecondsProcedure;
import net.mcreator.narutoshippudenmod.procedures.DojutsuProcedures.IsshikiDojutsuAwake10SecondsProcedure;
import net.mcreator.narutoshippudenmod.procedures.DojutsuProcedures.KakashiSharinganAwake10SecondsProcedure;
import net.mcreator.narutoshippudenmod.procedures.DojutsuProcedures.KetsuryuganAwake10SecondsProcedure;
import net.mcreator.narutoshippudenmod.procedures.DojutsuProcedures.SharinganAwake10SecondsProcedure;
import net.mcreator.narutoshippudenmod.procedures.DojutsuProcedures.ShimuraSharinganAwake10SecondsProcedure;
import net.mcreator.narutoshippudenmod.procedures.DojutsuProcedures.TenseiganAwake10SecondsProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiProcedures.JPADD100Procedure;
import net.mcreator.narutoshippudenmod.procedures.GuiProcedures.JPADD10Procedure;
import net.mcreator.narutoshippudenmod.procedures.GuiProcedures.JPMINUS100Procedure;
import net.mcreator.narutoshippudenmod.procedures.GuiProcedures.JPMINUS10Procedure;
import net.mcreator.narutoshippudenmod.procedures.GuiProcedures.LevelXPAdd100Procedure;
import net.mcreator.narutoshippudenmod.procedures.GuiProcedures.LoginButtonProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiProcedures.RankSetAcademyStudentProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiProcedures.RankSetChuninProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiProcedures.RankSetGeninProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiProcedures.RankSetJoninProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiProcedures.RankSetKageProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiProcedures.ResetDojutsuProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiProcedures.ResetInfoStatsProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiProcedures.ResetLevelJPandSPProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiProcedures.ResetUpgradeStatsProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiProcedures.SPADD100Procedure;
import net.mcreator.narutoshippudenmod.procedures.GuiProcedures.SPADD10Procedure;
import net.mcreator.narutoshippudenmod.procedures.GuiProcedures.SPMINUS100Procedure;
import net.mcreator.narutoshippudenmod.procedures.GuiProcedures.SPMINUS10Procedure;
import net.mcreator.narutoshippudenmod.procedures.GuiProcedures.SelectMenuProcedure;
import net.mcreator.narutoshippudenmod.procedures.PlayerProcedures.ADDMAXCHAKRAProcedure;
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

public final class CheatGuis {
	private CheatGuis() {
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class MangekyouSharinganCheatGui extends NarutoShippudenModElements.ModElement {
		public static HashMap guistate = new HashMap();
		private static ContainerType<GuiContainerMod> containerType = null;

		public MangekyouSharinganCheatGui(NarutoShippudenModElements instance) {
			super(instance, 640);
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
				event.getRegistry().register(containerType.setRegistryName("mangekyou_sharingan_cheat"));
			}
		}

		@OnlyIn(Dist.CLIENT)
		public void initElements() {
			DeferredWorkQueue.runLater(() -> ScreenManager.registerFactory(containerType, MangekyouSharinganCheatGuiWindow::new));
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

				SasukeMSCheatProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 1) {

				MadaraMSCheatProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 2) {

				ItachiMSCheatProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 3) {

				ObitoMSCheatProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 4) {

				ShisuiMSCheatProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 5) {

				KakashiMSCheatProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
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
	public static class NarutoShippudenCheatDojutsuGUIGui extends NarutoShippudenModElements.ModElement {
		public static HashMap guistate = new HashMap();
		private static ContainerType<GuiContainerMod> containerType = null;

		public NarutoShippudenCheatDojutsuGUIGui(NarutoShippudenModElements instance) {
			super(instance, 380);
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
				event.getRegistry().register(containerType.setRegistryName("naruto_shippuden_cheat_dojutsu_gui"));
			}
		}

		@OnlyIn(Dist.CLIENT)
		public void initElements() {
			DeferredWorkQueue.runLater(() -> ScreenManager.registerFactory(containerType, NarutoShippudenCheatDojutsuGUIGuiWindow::new));
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

				CheatDojutsuButtonSharinganProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 1) {

				CheatDojutsuButtonByakuganProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 2) {

				CheatDojutsuButtonKetsuryuganProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 3) {

				CheatDojutsuButtonBackProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z), new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 4) {

				SharinganAwake10SecondsProcedure
						.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("entity", entity))
								.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 5) {

				ByakuganAwake10SecondsProcedure
						.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("entity", entity))
								.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 6) {

				KetsuryuganAwake10SecondsProcedure
						.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("entity", entity))
								.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 7) {

				ResetDojutsuProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 8) {

				CheatDojutsuButtonIsshikiDojutsuProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 9) {

				MangekyouCheatGUIOpenProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z), new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 10) {

				KakashiSharinganCheatProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 11) {

				CheatDojutsuButtonRinneganProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 12) {

				CheatDojutsuButtonTenseiganProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 13) {

				TenseiganAwake10SecondsProcedure
						.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("entity", entity))
								.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 14) {

				IsshikiDojutsuAwake10SecondsProcedure
						.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("entity", entity))
								.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 15) {

				CheatDojutstuButtonShimuraProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 16) {

				KakashiSharinganAwake10SecondsProcedure
						.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("entity", entity))
								.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 17) {

				ShimuraSharinganAwake10SecondsProcedure
						.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("entity", entity))
								.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
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
	public static class NarutoShippudenCheatGUIGui extends NarutoShippudenModElements.ModElement {
		public static HashMap guistate = new HashMap();
		private static ContainerType<GuiContainerMod> containerType = null;

		public NarutoShippudenCheatGUIGui(NarutoShippudenModElements instance) {
			super(instance, 28);
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
				event.getRegistry().register(containerType.setRegistryName("naruto_shippuden_cheat_gui"));
			}
		}

		@OnlyIn(Dist.CLIENT)
		public void initElements() {
			DeferredWorkQueue.runLater(() -> ScreenManager.registerFactory(containerType, NarutoShippudenCheatGUIGuiWindow::new));
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

				JPADD100Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 1) {

				JPADD10Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 2) {

				SPADD100Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 3) {

				SPADD10Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 4) {

				JPMINUS100Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 5) {

				ADDMAXCHAKRAProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 6) {

				JPMINUS10Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 7) {

				SPMINUS100Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 8) {

				SPMINUS10Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 9) {

				RankSetGeninProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 10) {

				RankSetAcademyStudentProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 11) {

				RankSetChuninProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 12) {

				RankSetJoninProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 13) {

				RankSetKageProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 14) {

				CheatDojutsuButtonProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z), new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 15) {

				CheatKekkeiGenkaiButtonProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z), new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 16) {

				ResetUpgradeStatsProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 17) {

				ResetInfoStatsProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 18) {

				SelectMenuProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z), new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 19) {

				ResetLevelJPandSPProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 20) {

				LevelXPAdd100Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
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
	public static class NarutoShippudenCheatKekkeiGenkaiGUIGui extends NarutoShippudenModElements.ModElement {
		public static HashMap guistate = new HashMap();
		private static ContainerType<GuiContainerMod> containerType = null;

		public NarutoShippudenCheatKekkeiGenkaiGUIGui(NarutoShippudenModElements instance) {
			super(instance, 466);
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
				event.getRegistry().register(containerType.setRegistryName("naruto_shippuden_cheat_kekkei_genkai_gui"));
			}
		}

		@OnlyIn(Dist.CLIENT)
		public void initElements() {
			DeferredWorkQueue.runLater(() -> ScreenManager.registerFactory(containerType, NarutoShippudenCheatKekkeiGenkaiGUIGuiWindow::new));
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

				CheatKekkeiGenkaiButtonWoodReleaseProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 2) {

				CheatKekkeiGenkaiButtonSmokeReleaseProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 3) {

				CheatDojutsuButtonBackProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z), new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 4) {

				CheatKekkeiGenkaiButtonIceReleaseProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 5) {

				CheatKekkeiGenkaiButtonStormReleaseProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 6) {

				CheatKekkeiGenkaiButtonBoilReleaseProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 7) {

				CheatKekkeiGenkaiButtonDustReleaseProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 8) {

				CheatKekkeiGenkaiButtonSteelReleaseProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 9) {

				CheatKekkeiGenkaiButtonSwiftReleaseProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 13) {

				CheatKekkeiGenkaiButtonTyphoonReleaseProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 14) {

				CheatKekkeiGenkaiButtonMagnetReleaseProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 15) {

				CheatKekkeiGenkaiButtonBoneReleaseProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
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
	public static class PasswordGUIDojutsuGui extends NarutoShippudenModElements.ModElement {
		public static HashMap guistate = new HashMap();
		private static ContainerType<GuiContainerMod> containerType = null;

		public PasswordGUIDojutsuGui(NarutoShippudenModElements instance) {
			super(instance, 580);
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
				event.getRegistry().register(containerType.setRegistryName("password_gui_dojutsu"));
			}
		}

		@OnlyIn(Dist.CLIENT)
		public void initElements() {
			DeferredWorkQueue.runLater(() -> ScreenManager.registerFactory(containerType, PasswordGUIDojutsuGuiWindow::new));
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

				LoginButtonProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z), new AbstractMap.SimpleEntry<>("entity", entity),
								new AbstractMap.SimpleEntry<>("guistate", guistate))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
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
