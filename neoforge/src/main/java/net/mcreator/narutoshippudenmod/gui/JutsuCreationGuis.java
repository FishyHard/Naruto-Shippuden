package net.mcreator.narutoshippudenmod.gui;

import net.mcreator.narutoshippudenmod.NarutoShippudenMod;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Stream;
import net.mcreator.narutoshippudenmod.NarutoShippudenModElements;
import net.mcreator.narutoshippudenmod.gui.JutsuCreationScreens.CreateJutsuGUIGuiWindow;
import net.mcreator.narutoshippudenmod.procedures.GuiProcedures.JutsuCreateGUIOpenProcedure;
import net.mcreator.narutoshippudenmod.procedures.KeybindProcedures.InfoCardOpenOnKeyPressedProcedure;
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

import net.neoforged.bus.api.SubscribeEvent;

import net.neoforged.neoforge.network.IContainerFactory;
import net.mcreator.narutoshippudenmod.compat.NetworkEvent;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;
import net.minecraft.core.registries.Registries;
import net.mcreator.narutoshippudenmod.compat.Registration;
import net.minecraft.world.item.ItemStack;

public final class JutsuCreationGuis {
	private JutsuCreationGuis() {
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class CreateJutsuGUIGui extends NarutoShippudenModElements.ModElement {
		public static HashMap guistate = new HashMap();
		public static MenuType<GuiContainerMod> containerType = null;

		public CreateJutsuGUIGui(NarutoShippudenModElements instance) {
			super(instance, 474);
			elements.addNetworkMessage(ButtonPressedMessage.class, ButtonPressedMessage::buffer, ButtonPressedMessage::new,
					ButtonPressedMessage::handler);
			elements.addNetworkMessage(GUISlotChangedMessage.class, GUISlotChangedMessage::buffer, GUISlotChangedMessage::new,
					GUISlotChangedMessage::handler);
			containerType = IMenuTypeExtension.create(new GuiContainerModFactory());
			Registration.add(Registries.MENU, "create_jutsu_gui", () -> containerType, null);
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
		}

		private static void handleSlotAction(Player entity, int slotID, int changeType, int meta, int x, int y, int z) {
			Level world = entity.level();
			// security measure to prevent arbitrary chunk generation
			if (!world.hasChunkAt(BlockPos.containing(x, y, z)))
				return;
		}
	}
}
