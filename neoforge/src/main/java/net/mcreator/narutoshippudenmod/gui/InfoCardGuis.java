package net.mcreator.narutoshippudenmod.gui;

import net.mcreator.narutoshippudenmod.compat.Registration;
import net.mcreator.narutoshippudenmod.NarutoShippudenMod;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Stream;
import net.mcreator.narutoshippudenmod.NarutoShippudenModElements;
import net.mcreator.narutoshippudenmod.gui.InfoCardScreens.InfoCardDojutsuGuiWindow;
import net.mcreator.narutoshippudenmod.gui.InfoCardScreens.InfoCardGuiWindow;
import net.mcreator.narutoshippudenmod.gui.InfoCardScreens.InfoCardMiniGameGuiWindow;
import net.mcreator.narutoshippudenmod.gui.InfoCardScreens.InfoCardMissionsGuiWindow;
import net.mcreator.narutoshippudenmod.gui.InfoCardScreens.InfoCardUpgradeGuiWindow;
import net.mcreator.narutoshippudenmod.gui.InfoCardScreens.StatSelectGuiWindow;
import net.mcreator.narutoshippudenmod.procedures.GuiProcedures.ButtonDojutsuSelect2MinusProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiProcedures.ButtonDojutsuSelect2PlusProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiProcedures.ButtonSelectPressProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiProcedures.ClanReleaseMinusProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiProcedures.ClanReleasePlusProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiProcedures.DojutsuButtonMinusProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiProcedures.DojutsuButtonPlusProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiProcedures.EyesHeightButtonMinusProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiProcedures.GenjutsuButtonProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiProcedures.IQButtonProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiProcedures.InfoCardMiniGameThisGUIIsClosedProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiProcedures.InfoCardMiniGameWhileThisGUIIsOpenTickProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiProcedures.InfoCardNextPageProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiProcedures.JutsuCreateGUIOpenProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiProcedures.JutsuPowerButtonProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiProcedures.KenjutsuButtonProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiProcedures.KinjutsuButtonProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiProcedures.MedicalButtonProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiProcedures.MiniGameGUIOpenProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiProcedures.NatureReleaseMinusProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiProcedures.NatureReleasePlusProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiProcedures.NinjutsuButtonProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiProcedures.OpenDojutsuInfoCardProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiProcedures.PressButtonMiniProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiProcedures.PupilsHeightButtonMinusProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiProcedures.QuestGUIOpenProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiProcedures.SelectDojutsuInfoProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiProcedures.SenjutsuButtonProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiProcedures.ShurikenjutsuButtonProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiProcedures.Spuse10Procedure;
import net.mcreator.narutoshippudenmod.procedures.GuiProcedures.Spuse1Procedure;
import net.mcreator.narutoshippudenmod.procedures.GuiProcedures.Spuse5Procedure;
import net.mcreator.narutoshippudenmod.procedures.GuiProcedures.SummoningButtonProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiProcedures.TaijutsuButtonProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiProcedures.VIllageSelectPlusProcedure;
import net.mcreator.narutoshippudenmod.procedures.GuiProcedures.VillageSelectMinusProcedure;
import net.mcreator.narutoshippudenmod.procedures.KeybindProcedures.InfoCardOpenOnKeyPressedProcedure;
import net.mcreator.narutoshippudenmod.procedures.PlayerProcedures.SpeedProcedure;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.Slot;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.common.NeoForge;

import net.neoforged.bus.api.SubscribeEvent;


import net.neoforged.neoforge.network.IContainerFactory;
import net.mcreator.narutoshippudenmod.compat.NetworkEvent;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.ItemStack;

public final class InfoCardGuis {
	private InfoCardGuis() {
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class InfoCardDojutsuGui extends NarutoShippudenModElements.ModElement {
		public static HashMap guistate = new HashMap();
		public static MenuType<GuiContainerMod> containerType = null;

		public InfoCardDojutsuGui(NarutoShippudenModElements instance) {
			super(instance, 336);
			elements.addNetworkMessage(ButtonPressedMessage.class, ButtonPressedMessage::buffer, ButtonPressedMessage::new,
					ButtonPressedMessage::handler);
			elements.addNetworkMessage(GUISlotChangedMessage.class, GUISlotChangedMessage::buffer, GUISlotChangedMessage::new,
					GUISlotChangedMessage::handler);
			containerType = IMenuTypeExtension.create(new GuiContainerModFactory());
			Registration.add(Registries.MENU, "info_card_dojutsu", () -> containerType, null);
		}

		public static class GuiContainerModFactory implements IContainerFactory {
			public GuiContainerMod create(int id, Inventory inv, net.minecraft.network.RegistryFriendlyByteBuf extraData) {
				return new GuiContainerMod(id, inv, extraData);
			}
		}

		public static class GuiContainerMod extends AbstractContainerMenu implements Supplier<Map<Integer, Slot>> {
			Level world;
			Player entity;
			int x, y, z;
			private Map<Integer, Slot> customSlots = new HashMap<>();
			private boolean bound = false;

			public GuiContainerMod(int id, Inventory inv, FriendlyByteBuf extraData) {
				super(containerType, id);
				this.entity = inv.player;
				this.world = inv.player.level();
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
			public boolean stillValid(Player player) {
				return true;
			}

			@Override
			public ItemStack quickMoveStack(Player player, int index) {
				return ItemStack.EMPTY;
			}
		}

		public static class ButtonPressedMessage {
			int buttonID, x, y, z;

			public ButtonPressedMessage(FriendlyByteBuf buffer) {
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

			public static void buffer(ButtonPressedMessage message, FriendlyByteBuf buffer) {
				buffer.writeInt(message.buttonID);
				buffer.writeInt(message.x);
				buffer.writeInt(message.y);
				buffer.writeInt(message.z);
			}

			public static void handler(ButtonPressedMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
				NetworkEvent.Context context = contextSupplier.get();
				context.enqueueWork(() -> {
					Player entity = context.getSender();
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

			public GUISlotChangedMessage(FriendlyByteBuf buffer) {
				this.slotID = buffer.readInt();
				this.x = buffer.readInt();
				this.y = buffer.readInt();
				this.z = buffer.readInt();
				this.changeType = buffer.readInt();
				this.meta = buffer.readInt();
			}

			public static void buffer(GUISlotChangedMessage message, FriendlyByteBuf buffer) {
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
					Player entity = context.getSender();
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

		static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
			Level world = entity.level();
			// security measure to prevent arbitrary chunk generation
			if (!world.hasChunkAt(BlockPos.containing(x, y, z)))
				return;
			if (buttonID == 0) {

				InfoCardOpenOnKeyPressedProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z), new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 1) {

				DojutsuButtonMinusProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 2) {

				DojutsuButtonPlusProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 3) {

				PupilsHeightButtonMinusProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 4) {

				PupilsHeightButtonMinusProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 5) {

				EyesHeightButtonMinusProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 6) {

				EyesHeightButtonMinusProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 7) {

				SelectDojutsuInfoProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 8) {

				ButtonDojutsuSelect2MinusProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 9) {

				ButtonDojutsuSelect2PlusProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
		}

		private static void handleSlotAction(Player entity, int slotID, int changeType, int meta, int x, int y, int z) {
			Level world = entity.level();
			// security measure to prevent arbitrary chunk generation
			if (!world.hasChunkAt(BlockPos.containing(x, y, z)))
				return;
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class InfoCardGui extends NarutoShippudenModElements.ModElement {
		public static HashMap guistate = new HashMap();
		public static MenuType<GuiContainerMod> containerType = null;

		public InfoCardGui(NarutoShippudenModElements instance) {
			super(instance, 20);
			elements.addNetworkMessage(ButtonPressedMessage.class, ButtonPressedMessage::buffer, ButtonPressedMessage::new,
					ButtonPressedMessage::handler);
			elements.addNetworkMessage(GUISlotChangedMessage.class, GUISlotChangedMessage::buffer, GUISlotChangedMessage::new,
					GUISlotChangedMessage::handler);
			containerType = IMenuTypeExtension.create(new GuiContainerModFactory());
			Registration.add(Registries.MENU, "info_card", () -> containerType, null);
		}

		public static class GuiContainerModFactory implements IContainerFactory {
			public GuiContainerMod create(int id, Inventory inv, net.minecraft.network.RegistryFriendlyByteBuf extraData) {
				return new GuiContainerMod(id, inv, extraData);
			}
		}

		public static class GuiContainerMod extends AbstractContainerMenu implements Supplier<Map<Integer, Slot>> {
			Level world;
			Player entity;
			int x, y, z;
			private Map<Integer, Slot> customSlots = new HashMap<>();
			private boolean bound = false;

			public GuiContainerMod(int id, Inventory inv, FriendlyByteBuf extraData) {
				super(containerType, id);
				this.entity = inv.player;
				this.world = inv.player.level();
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
			public boolean stillValid(Player player) {
				return true;
			}

			@Override
			public ItemStack quickMoveStack(Player player, int index) {
				return ItemStack.EMPTY;
			}
		}

		public static class ButtonPressedMessage {
			int buttonID, x, y, z;

			public ButtonPressedMessage(FriendlyByteBuf buffer) {
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

			public static void buffer(ButtonPressedMessage message, FriendlyByteBuf buffer) {
				buffer.writeInt(message.buttonID);
				buffer.writeInt(message.x);
				buffer.writeInt(message.y);
				buffer.writeInt(message.z);
			}

			public static void handler(ButtonPressedMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
				NetworkEvent.Context context = contextSupplier.get();
				context.enqueueWork(() -> {
					Player entity = context.getSender();
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

			public GUISlotChangedMessage(FriendlyByteBuf buffer) {
				this.slotID = buffer.readInt();
				this.x = buffer.readInt();
				this.y = buffer.readInt();
				this.z = buffer.readInt();
				this.changeType = buffer.readInt();
				this.meta = buffer.readInt();
			}

			public static void buffer(GUISlotChangedMessage message, FriendlyByteBuf buffer) {
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
					Player entity = context.getSender();
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

		static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
			Level world = entity.level();
			// security measure to prevent arbitrary chunk generation
			if (!world.hasChunkAt(BlockPos.containing(x, y, z)))
				return;
			if (buttonID == 0) {

				InfoCardNextPageProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z), new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 1) {

				QuestGUIOpenProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z), new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 2) {

				MiniGameGUIOpenProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z), new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 3) {

				OpenDojutsuInfoCardProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z), new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 4) {

				JutsuCreateGUIOpenProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z), new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
		}

		private static void handleSlotAction(Player entity, int slotID, int changeType, int meta, int x, int y, int z) {
			Level world = entity.level();
			// security measure to prevent arbitrary chunk generation
			if (!world.hasChunkAt(BlockPos.containing(x, y, z)))
				return;
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class InfoCardMiniGameGui extends NarutoShippudenModElements.ModElement {
		public static HashMap guistate = new HashMap();
		public static MenuType<GuiContainerMod> containerType = null;

		public InfoCardMiniGameGui(NarutoShippudenModElements instance) {
			super(instance, 229);
			elements.addNetworkMessage(ButtonPressedMessage.class, ButtonPressedMessage::buffer, ButtonPressedMessage::new,
					ButtonPressedMessage::handler);
			elements.addNetworkMessage(GUISlotChangedMessage.class, GUISlotChangedMessage::buffer, GUISlotChangedMessage::new,
					GUISlotChangedMessage::handler);
			containerType = IMenuTypeExtension.create(new GuiContainerModFactory());
			Registration.add(Registries.MENU, "info_card_mini_game", () -> containerType, null);
			Registration.listen(NeoForge.EVENT_BUS, this);
		}

		@SubscribeEvent
		public void onPlayerTick(PlayerTickEvent.Post event) {
			Player entity = event.getEntity();
			if (true && entity.containerMenu instanceof GuiContainerMod) {
				Level world = entity.level();
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();

				InfoCardMiniGameWhileThisGUIIsOpenTickProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
		}

		public static class GuiContainerModFactory implements IContainerFactory {
			public GuiContainerMod create(int id, Inventory inv, net.minecraft.network.RegistryFriendlyByteBuf extraData) {
				return new GuiContainerMod(id, inv, extraData);
			}
		}

		public static class GuiContainerMod extends AbstractContainerMenu implements Supplier<Map<Integer, Slot>> {
			Level world;
			Player entity;
			int x, y, z;
			private Map<Integer, Slot> customSlots = new HashMap<>();
			private boolean bound = false;

			public GuiContainerMod(int id, Inventory inv, FriendlyByteBuf extraData) {
				super(containerType, id);
				this.entity = inv.player;
				this.world = inv.player.level();
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
			public boolean stillValid(Player player) {
				return true;
			}

			@Override
			public ItemStack quickMoveStack(Player player, int index) {
				return ItemStack.EMPTY;
			}

			@Override
			public void removed(Player playerIn) {
				super.removed(playerIn);

				InfoCardMiniGameThisGUIIsClosedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
		}

		public static class ButtonPressedMessage {
			int buttonID, x, y, z;

			public ButtonPressedMessage(FriendlyByteBuf buffer) {
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

			public static void buffer(ButtonPressedMessage message, FriendlyByteBuf buffer) {
				buffer.writeInt(message.buttonID);
				buffer.writeInt(message.x);
				buffer.writeInt(message.y);
				buffer.writeInt(message.z);
			}

			public static void handler(ButtonPressedMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
				NetworkEvent.Context context = contextSupplier.get();
				context.enqueueWork(() -> {
					Player entity = context.getSender();
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

			public GUISlotChangedMessage(FriendlyByteBuf buffer) {
				this.slotID = buffer.readInt();
				this.x = buffer.readInt();
				this.y = buffer.readInt();
				this.z = buffer.readInt();
				this.changeType = buffer.readInt();
				this.meta = buffer.readInt();
			}

			public static void buffer(GUISlotChangedMessage message, FriendlyByteBuf buffer) {
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
					Player entity = context.getSender();
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

		static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
			Level world = entity.level();
			// security measure to prevent arbitrary chunk generation
			if (!world.hasChunkAt(BlockPos.containing(x, y, z)))
				return;
			if (buttonID == 0) {

				InfoCardOpenOnKeyPressedProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z), new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 1) {

				PressButtonMiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 2) {

				PressButtonMiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 3) {

				PressButtonMiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 4) {

				PressButtonMiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 5) {

				PressButtonMiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 6) {

				PressButtonMiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 7) {

				PressButtonMiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 8) {

				PressButtonMiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 9) {

				PressButtonMiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 10) {

				PressButtonMiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 11) {

				PressButtonMiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 12) {

				PressButtonMiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 13) {

				PressButtonMiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 14) {

				PressButtonMiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 15) {

				PressButtonMiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 16) {

				PressButtonMiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 17) {

				PressButtonMiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 18) {

				PressButtonMiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 19) {

				PressButtonMiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 20) {

				PressButtonMiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 21) {

				PressButtonMiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 22) {

				PressButtonMiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 23) {

				PressButtonMiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 24) {

				PressButtonMiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 25) {

				PressButtonMiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 26) {

				PressButtonMiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 27) {

				PressButtonMiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 28) {

				PressButtonMiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 29) {

				PressButtonMiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 30) {

				PressButtonMiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 31) {

				PressButtonMiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 32) {

				PressButtonMiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 33) {

				PressButtonMiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 34) {

				PressButtonMiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 35) {

				PressButtonMiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 36) {

				PressButtonMiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 37) {

				PressButtonMiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 38) {

				PressButtonMiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 39) {

				PressButtonMiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 40) {

				PressButtonMiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 41) {

				PressButtonMiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 42) {

				PressButtonMiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 43) {

				PressButtonMiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 44) {

				PressButtonMiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 45) {

				PressButtonMiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 46) {

				PressButtonMiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 47) {

				PressButtonMiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 48) {

				PressButtonMiniProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
		}

		private static void handleSlotAction(Player entity, int slotID, int changeType, int meta, int x, int y, int z) {
			Level world = entity.level();
			// security measure to prevent arbitrary chunk generation
			if (!world.hasChunkAt(BlockPos.containing(x, y, z)))
				return;
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class InfoCardMissionsGui extends NarutoShippudenModElements.ModElement {
		public static HashMap guistate = new HashMap();
		public static MenuType<GuiContainerMod> containerType = null;

		public InfoCardMissionsGui(NarutoShippudenModElements instance) {
			super(instance, 222);
			elements.addNetworkMessage(ButtonPressedMessage.class, ButtonPressedMessage::buffer, ButtonPressedMessage::new,
					ButtonPressedMessage::handler);
			elements.addNetworkMessage(GUISlotChangedMessage.class, GUISlotChangedMessage::buffer, GUISlotChangedMessage::new,
					GUISlotChangedMessage::handler);
			containerType = IMenuTypeExtension.create(new GuiContainerModFactory());
			Registration.add(Registries.MENU, "info_card_missions", () -> containerType, null);
		}

		public static class GuiContainerModFactory implements IContainerFactory {
			public GuiContainerMod create(int id, Inventory inv, net.minecraft.network.RegistryFriendlyByteBuf extraData) {
				return new GuiContainerMod(id, inv, extraData);
			}
		}

		public static class GuiContainerMod extends AbstractContainerMenu implements Supplier<Map<Integer, Slot>> {
			Level world;
			Player entity;
			int x, y, z;
			private Map<Integer, Slot> customSlots = new HashMap<>();
			private boolean bound = false;

			public GuiContainerMod(int id, Inventory inv, FriendlyByteBuf extraData) {
				super(containerType, id);
				this.entity = inv.player;
				this.world = inv.player.level();
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
			public boolean stillValid(Player player) {
				return true;
			}

			@Override
			public ItemStack quickMoveStack(Player player, int index) {
				return ItemStack.EMPTY;
			}
		}

		public static class ButtonPressedMessage {
			int buttonID, x, y, z;

			public ButtonPressedMessage(FriendlyByteBuf buffer) {
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

			public static void buffer(ButtonPressedMessage message, FriendlyByteBuf buffer) {
				buffer.writeInt(message.buttonID);
				buffer.writeInt(message.x);
				buffer.writeInt(message.y);
				buffer.writeInt(message.z);
			}

			public static void handler(ButtonPressedMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
				NetworkEvent.Context context = contextSupplier.get();
				context.enqueueWork(() -> {
					Player entity = context.getSender();
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

			public GUISlotChangedMessage(FriendlyByteBuf buffer) {
				this.slotID = buffer.readInt();
				this.x = buffer.readInt();
				this.y = buffer.readInt();
				this.z = buffer.readInt();
				this.changeType = buffer.readInt();
				this.meta = buffer.readInt();
			}

			public static void buffer(GUISlotChangedMessage message, FriendlyByteBuf buffer) {
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
					Player entity = context.getSender();
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

		static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
			Level world = entity.level();
			// security measure to prevent arbitrary chunk generation
			if (!world.hasChunkAt(BlockPos.containing(x, y, z)))
				return;
			if (buttonID == 0) {

				InfoCardOpenOnKeyPressedProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z), new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
		}

		private static void handleSlotAction(Player entity, int slotID, int changeType, int meta, int x, int y, int z) {
			Level world = entity.level();
			// security measure to prevent arbitrary chunk generation
			if (!world.hasChunkAt(BlockPos.containing(x, y, z)))
				return;
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class InfoCardUpgradeGui extends NarutoShippudenModElements.ModElement {
		public static HashMap guistate = new HashMap();
		public static MenuType<GuiContainerMod> containerType = null;

		public InfoCardUpgradeGui(NarutoShippudenModElements instance) {
			super(instance, 19);
			elements.addNetworkMessage(ButtonPressedMessage.class, ButtonPressedMessage::buffer, ButtonPressedMessage::new,
					ButtonPressedMessage::handler);
			elements.addNetworkMessage(GUISlotChangedMessage.class, GUISlotChangedMessage::buffer, GUISlotChangedMessage::new,
					GUISlotChangedMessage::handler);
			containerType = IMenuTypeExtension.create(new GuiContainerModFactory());
			Registration.add(Registries.MENU, "info_card_upgrade", () -> containerType, null);
		}

		public static class GuiContainerModFactory implements IContainerFactory {
			public GuiContainerMod create(int id, Inventory inv, net.minecraft.network.RegistryFriendlyByteBuf extraData) {
				return new GuiContainerMod(id, inv, extraData);
			}
		}

		public static class GuiContainerMod extends AbstractContainerMenu implements Supplier<Map<Integer, Slot>> {
			Level world;
			Player entity;
			int x, y, z;
			private Map<Integer, Slot> customSlots = new HashMap<>();
			private boolean bound = false;

			public GuiContainerMod(int id, Inventory inv, FriendlyByteBuf extraData) {
				super(containerType, id);
				this.entity = inv.player;
				this.world = inv.player.level();
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
			public boolean stillValid(Player player) {
				return true;
			}

			@Override
			public ItemStack quickMoveStack(Player player, int index) {
				return ItemStack.EMPTY;
			}
		}

		public static class ButtonPressedMessage {
			int buttonID, x, y, z;

			public ButtonPressedMessage(FriendlyByteBuf buffer) {
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

			public static void buffer(ButtonPressedMessage message, FriendlyByteBuf buffer) {
				buffer.writeInt(message.buttonID);
				buffer.writeInt(message.x);
				buffer.writeInt(message.y);
				buffer.writeInt(message.z);
			}

			public static void handler(ButtonPressedMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
				NetworkEvent.Context context = contextSupplier.get();
				context.enqueueWork(() -> {
					Player entity = context.getSender();
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

			public GUISlotChangedMessage(FriendlyByteBuf buffer) {
				this.slotID = buffer.readInt();
				this.x = buffer.readInt();
				this.y = buffer.readInt();
				this.z = buffer.readInt();
				this.changeType = buffer.readInt();
				this.meta = buffer.readInt();
			}

			public static void buffer(GUISlotChangedMessage message, FriendlyByteBuf buffer) {
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
					Player entity = context.getSender();
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

		static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
			Level world = entity.level();
			// security measure to prevent arbitrary chunk generation
			if (!world.hasChunkAt(BlockPos.containing(x, y, z)))
				return;
			if (buttonID == 0) {

				InfoCardOpenOnKeyPressedProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z), new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 1) {

				Spuse1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 2) {

				Spuse5Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 3) {

				Spuse10Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 4) {

				NinjutsuButtonProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 5) {

				TaijutsuButtonProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 6) {

				KenjutsuButtonProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 7) {

				ShurikenjutsuButtonProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 8) {

				SummoningButtonProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 9) {

				KinjutsuButtonProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 10) {

				SenjutsuButtonProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 11) {

				MedicalButtonProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z), new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 12) {

				SpeedProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z), new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 13) {

				JutsuPowerButtonProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 14) {

				GenjutsuButtonProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 15) {

				IQButtonProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
		}

		private static void handleSlotAction(Player entity, int slotID, int changeType, int meta, int x, int y, int z) {
			Level world = entity.level();
			// security measure to prevent arbitrary chunk generation
			if (!world.hasChunkAt(BlockPos.containing(x, y, z)))
				return;
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class StatSelectGui extends NarutoShippudenModElements.ModElement {
		public static HashMap guistate = new HashMap();
		public static MenuType<GuiContainerMod> containerType = null;

		public StatSelectGui(NarutoShippudenModElements instance) {
			super(instance, 53);
			elements.addNetworkMessage(ButtonPressedMessage.class, ButtonPressedMessage::buffer, ButtonPressedMessage::new,
					ButtonPressedMessage::handler);
			elements.addNetworkMessage(GUISlotChangedMessage.class, GUISlotChangedMessage::buffer, GUISlotChangedMessage::new,
					GUISlotChangedMessage::handler);
			containerType = IMenuTypeExtension.create(new GuiContainerModFactory());
			Registration.add(Registries.MENU, "stat_select", () -> containerType, null);
		}

		public static class GuiContainerModFactory implements IContainerFactory {
			public GuiContainerMod create(int id, Inventory inv, net.minecraft.network.RegistryFriendlyByteBuf extraData) {
				return new GuiContainerMod(id, inv, extraData);
			}
		}

		public static class GuiContainerMod extends AbstractContainerMenu implements Supplier<Map<Integer, Slot>> {
			Level world;
			Player entity;
			int x, y, z;
			private Map<Integer, Slot> customSlots = new HashMap<>();
			private boolean bound = false;

			public GuiContainerMod(int id, Inventory inv, FriendlyByteBuf extraData) {
				super(containerType, id);
				this.entity = inv.player;
				this.world = inv.player.level();
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
			public boolean stillValid(Player player) {
				return true;
			}

			@Override
			public ItemStack quickMoveStack(Player player, int index) {
				return ItemStack.EMPTY;
			}
		}

		public static class ButtonPressedMessage {
			int buttonID, x, y, z;

			public ButtonPressedMessage(FriendlyByteBuf buffer) {
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

			public static void buffer(ButtonPressedMessage message, FriendlyByteBuf buffer) {
				buffer.writeInt(message.buttonID);
				buffer.writeInt(message.x);
				buffer.writeInt(message.y);
				buffer.writeInt(message.z);
			}

			public static void handler(ButtonPressedMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
				NetworkEvent.Context context = contextSupplier.get();
				context.enqueueWork(() -> {
					Player entity = context.getSender();
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

			public GUISlotChangedMessage(FriendlyByteBuf buffer) {
				this.slotID = buffer.readInt();
				this.x = buffer.readInt();
				this.y = buffer.readInt();
				this.z = buffer.readInt();
				this.changeType = buffer.readInt();
				this.meta = buffer.readInt();
			}

			public static void buffer(GUISlotChangedMessage message, FriendlyByteBuf buffer) {
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
					Player entity = context.getSender();
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

		static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
			Level world = entity.level();
			// security measure to prevent arbitrary chunk generation
			if (!world.hasChunkAt(BlockPos.containing(x, y, z)))
				return;
			if (buttonID == 0) {

				ClanReleaseMinusProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 1) {

				ClanReleasePlusProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 2) {

				VillageSelectMinusProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 3) {

				VIllageSelectPlusProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 4) {

				ButtonSelectPressProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 5) {

				NatureReleaseMinusProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (buttonID == 6) {

				NatureReleasePlusProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
		}

		private static void handleSlotAction(Player entity, int slotID, int changeType, int meta, int x, int y, int z) {
			Level world = entity.level();
			// security measure to prevent arbitrary chunk generation
			if (!world.hasChunkAt(BlockPos.containing(x, y, z)))
				return;
		}
	}
}
