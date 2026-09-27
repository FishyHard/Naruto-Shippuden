package net.mcreator.narutoshippudenmod.keybind;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Stream;
import net.mcreator.narutoshippudenmod.NarutoShippudenMod;
import net.mcreator.narutoshippudenmod.NarutoShippudenModElements;
import net.mcreator.narutoshippudenmod.procedures.KeybindProcedures.BackDashOnKeyPressedProcedure;
import net.mcreator.narutoshippudenmod.procedures.KeybindProcedures.ByakuganOnKeyPressedProcedure;
import net.mcreator.narutoshippudenmod.procedures.KeybindProcedures.ChakraControlOnKeyPressedProcedure;
import net.mcreator.narutoshippudenmod.procedures.KeybindProcedures.ChakraControlOnKeyReleasedProcedure;
import net.mcreator.narutoshippudenmod.procedures.KeybindProcedures.CustomDojutsuOnKeyPressedProcedure;
import net.mcreator.narutoshippudenmod.procedures.KeybindProcedures.ForwardDashOnKeyPressedProcedure;
import net.mcreator.narutoshippudenmod.procedures.KeybindProcedures.ForwardDashOnKeyReleasedProcedure;
import net.mcreator.narutoshippudenmod.procedures.KeybindProcedures.InfoCardOpenOnKeyPressedProcedure;
import net.mcreator.narutoshippudenmod.procedures.KeybindProcedures.IsshikiDojutsuOnKeyPressedProcedure;
import net.mcreator.narutoshippudenmod.procedures.KeybindProcedures.JutsuPowerOnKeyPressedProcedure;
import net.mcreator.narutoshippudenmod.procedures.KeybindProcedures.KetsuryuganOnKeyPressedProcedure;
import net.mcreator.narutoshippudenmod.procedures.KeybindProcedures.LeftDashOnKeyPressedProcedure;
import net.mcreator.narutoshippudenmod.procedures.KeybindProcedures.MangekyouSharinganOnKeyPressedProcedure;
import net.mcreator.narutoshippudenmod.procedures.KeybindProcedures.RightDashOnKeyPressedProcedure;
import net.mcreator.narutoshippudenmod.procedures.KeybindProcedures.RinneganOnKeyPressedProcedure;
import net.mcreator.narutoshippudenmod.procedures.KeybindProcedures.SharinganOnKeyPressedProcedure;
import net.mcreator.narutoshippudenmod.procedures.KeybindProcedures.SusanoOnKeyPressedProcedure;
import net.mcreator.narutoshippudenmod.procedures.KeybindProcedures.TenseiganOnKeyPressedProcedure;
import net.mcreator.narutoshippudenmod.procedures.KeybindProcedures.UpDashOnKeyPressedProcedure;
import net.mcreator.narutoshippudenmod.procedures.KeybindProcedures.UpDashOnKeyReleasedProcedure;
import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.client.event.InputEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.bus.api.SubscribeEvent;

import net.mcreator.narutoshippudenmod.compat.NetworkEvent;
import org.lwjgl.glfw.GLFW;

public final class ModKeyBindings {
	private ModKeyBindings() {
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class BackDashKeyBinding extends NarutoShippudenModElements.ModElement {
		@OnlyIn(Dist.CLIENT)
		private KeyMapping keys;

		public BackDashKeyBinding(NarutoShippudenModElements instance) {
			super(instance, 1173);
			elements.addNetworkMessage(KeyBindingPressedMessage.class, KeyBindingPressedMessage::buffer, KeyBindingPressedMessage::new,
					KeyBindingPressedMessage::handler);
		}

		@Override
		@OnlyIn(Dist.CLIENT)
		public void initElements() {
			keys = new KeyMapping("", GLFW.GLFW_KEY_S, "");
			NeoForge.EVENT_BUS.register(this);
		}

		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void onKeyInput(InputEvent.KeyInputEvent event) {
			if (Minecraft.getInstance().screen == null) {
				if (event.getKey() == keys.getKey().getValue()) {
					if (event.getAction() == GLFW.GLFW_PRESS) {
						NarutoShippudenMod.PACKET_HANDLER.sendToServer(new KeyBindingPressedMessage(0, 0));
						pressAction(Minecraft.getInstance().player, 0, 0);
					}
				}
			}
		}

		public static class KeyBindingPressedMessage {
			int type, pressedms;

			public KeyBindingPressedMessage(int type, int pressedms) {
				this.type = type;
				this.pressedms = pressedms;
			}

			public KeyBindingPressedMessage(FriendlyByteBuf buffer) {
				this.type = buffer.readInt();
				this.pressedms = buffer.readInt();
			}

			public static void buffer(KeyBindingPressedMessage message, FriendlyByteBuf buffer) {
				buffer.writeInt(message.type);
				buffer.writeInt(message.pressedms);
			}

			public static void handler(KeyBindingPressedMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
				NetworkEvent.Context context = contextSupplier.get();
				context.enqueueWork(() -> {
					pressAction(context.getSender(), message.type, message.pressedms);
				});
				context.setPacketHandled(true);
			}
		}

		private static void pressAction(Player entity, int type, int pressedms) {
			Level world = entity.level();
			double x = entity.getX();
			double y = entity.getY();
			double z = entity.getZ();
			// security measure to prevent arbitrary chunk generation
			if (!world.hasChunkAt(BlockPos.containing(x, y, z)))
				return;
			if (type == 0) {

				BackDashOnKeyPressedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class ByakuganKeyBinding extends NarutoShippudenModElements.ModElement {
		@OnlyIn(Dist.CLIENT)
		private KeyMapping keys;

		public ByakuganKeyBinding(NarutoShippudenModElements instance) {
			super(instance, 375);
			elements.addNetworkMessage(KeyBindingPressedMessage.class, KeyBindingPressedMessage::buffer, KeyBindingPressedMessage::new,
					KeyBindingPressedMessage::handler);
		}

		@Override
		@OnlyIn(Dist.CLIENT)
		public void initElements() {
			keys = new KeyMapping("key.naruto_shippuden.byakugan", GLFW.GLFW_KEY_B, "key.categories.misc");
			ClientRegistry.registerKeyBinding(keys);
			NeoForge.EVENT_BUS.register(this);
		}

		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void onKeyInput(InputEvent.KeyInputEvent event) {
			if (Minecraft.getInstance().screen == null) {
				if (event.getKey() == keys.getKey().getValue()) {
					if (event.getAction() == GLFW.GLFW_PRESS) {
						NarutoShippudenMod.PACKET_HANDLER.sendToServer(new KeyBindingPressedMessage(0, 0));
						pressAction(Minecraft.getInstance().player, 0, 0);
					}
				}
			}
		}

		public static class KeyBindingPressedMessage {
			int type, pressedms;

			public KeyBindingPressedMessage(int type, int pressedms) {
				this.type = type;
				this.pressedms = pressedms;
			}

			public KeyBindingPressedMessage(FriendlyByteBuf buffer) {
				this.type = buffer.readInt();
				this.pressedms = buffer.readInt();
			}

			public static void buffer(KeyBindingPressedMessage message, FriendlyByteBuf buffer) {
				buffer.writeInt(message.type);
				buffer.writeInt(message.pressedms);
			}

			public static void handler(KeyBindingPressedMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
				NetworkEvent.Context context = contextSupplier.get();
				context.enqueueWork(() -> {
					pressAction(context.getSender(), message.type, message.pressedms);
				});
				context.setPacketHandled(true);
			}
		}

		private static void pressAction(Player entity, int type, int pressedms) {
			Level world = entity.level();
			double x = entity.getX();
			double y = entity.getY();
			double z = entity.getZ();
			// security measure to prevent arbitrary chunk generation
			if (!world.hasChunkAt(BlockPos.containing(x, y, z)))
				return;
			if (type == 0) {

				ByakuganOnKeyPressedProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z), new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class ChakraControlKeyBinding extends NarutoShippudenModElements.ModElement {
		@OnlyIn(Dist.CLIENT)
		private KeyMapping keys;
		private long lastpress = 0;

		public ChakraControlKeyBinding(NarutoShippudenModElements instance) {
			super(instance, 472);
			elements.addNetworkMessage(KeyBindingPressedMessage.class, KeyBindingPressedMessage::buffer, KeyBindingPressedMessage::new,
					KeyBindingPressedMessage::handler);
		}

		@Override
		@OnlyIn(Dist.CLIENT)
		public void initElements() {
			keys = new KeyMapping("key.naruto_shippuden.chakra_control", GLFW.GLFW_KEY_G, "key.categories.misc");
			ClientRegistry.registerKeyBinding(keys);
			NeoForge.EVENT_BUS.register(this);
		}

		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void onKeyInput(InputEvent.KeyInputEvent event) {
			if (Minecraft.getInstance().screen == null) {
				if (event.getKey() == keys.getKey().getValue()) {
					if (event.getAction() == GLFW.GLFW_PRESS) {
						NarutoShippudenMod.PACKET_HANDLER.sendToServer(new KeyBindingPressedMessage(0, 0));
						pressAction(Minecraft.getInstance().player, 0, 0);
						lastpress = System.currentTimeMillis();
					} else if (event.getAction() == GLFW.GLFW_RELEASE) {
						int dt = (int) (System.currentTimeMillis() - lastpress);
						NarutoShippudenMod.PACKET_HANDLER.sendToServer(new KeyBindingPressedMessage(1, dt));
						pressAction(Minecraft.getInstance().player, 1, dt);
					}
				}
			}
		}

		public static class KeyBindingPressedMessage {
			int type, pressedms;

			public KeyBindingPressedMessage(int type, int pressedms) {
				this.type = type;
				this.pressedms = pressedms;
			}

			public KeyBindingPressedMessage(FriendlyByteBuf buffer) {
				this.type = buffer.readInt();
				this.pressedms = buffer.readInt();
			}

			public static void buffer(KeyBindingPressedMessage message, FriendlyByteBuf buffer) {
				buffer.writeInt(message.type);
				buffer.writeInt(message.pressedms);
			}

			public static void handler(KeyBindingPressedMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
				NetworkEvent.Context context = contextSupplier.get();
				context.enqueueWork(() -> {
					pressAction(context.getSender(), message.type, message.pressedms);
				});
				context.setPacketHandled(true);
			}
		}

		private static void pressAction(Player entity, int type, int pressedms) {
			Level world = entity.level();
			double x = entity.getX();
			double y = entity.getY();
			double z = entity.getZ();
			// security measure to prevent arbitrary chunk generation
			if (!world.hasChunkAt(BlockPos.containing(x, y, z)))
				return;
			if (type == 0) {

				ChakraControlOnKeyPressedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (type == 1) {

				ChakraControlOnKeyReleasedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class CustomDojutsuKeyBinding extends NarutoShippudenModElements.ModElement {
		@OnlyIn(Dist.CLIENT)
		private KeyMapping keys;

		public CustomDojutsuKeyBinding(NarutoShippudenModElements instance) {
			super(instance, 673);
			elements.addNetworkMessage(KeyBindingPressedMessage.class, KeyBindingPressedMessage::buffer, KeyBindingPressedMessage::new,
					KeyBindingPressedMessage::handler);
		}

		@Override
		@OnlyIn(Dist.CLIENT)
		public void initElements() {
			keys = new KeyMapping("key.naruto_shippuden.custom_dojutsu", GLFW.GLFW_KEY_R, "key.categories.misc");
			ClientRegistry.registerKeyBinding(keys);
			NeoForge.EVENT_BUS.register(this);
		}

		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void onKeyInput(InputEvent.KeyInputEvent event) {
			if (Minecraft.getInstance().screen == null) {
				if (event.getKey() == keys.getKey().getValue()) {
					if (event.getAction() == GLFW.GLFW_PRESS) {
						NarutoShippudenMod.PACKET_HANDLER.sendToServer(new KeyBindingPressedMessage(0, 0));
						pressAction(Minecraft.getInstance().player, 0, 0);
					}
				}
			}
		}

		public static class KeyBindingPressedMessage {
			int type, pressedms;

			public KeyBindingPressedMessage(int type, int pressedms) {
				this.type = type;
				this.pressedms = pressedms;
			}

			public KeyBindingPressedMessage(FriendlyByteBuf buffer) {
				this.type = buffer.readInt();
				this.pressedms = buffer.readInt();
			}

			public static void buffer(KeyBindingPressedMessage message, FriendlyByteBuf buffer) {
				buffer.writeInt(message.type);
				buffer.writeInt(message.pressedms);
			}

			public static void handler(KeyBindingPressedMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
				NetworkEvent.Context context = contextSupplier.get();
				context.enqueueWork(() -> {
					pressAction(context.getSender(), message.type, message.pressedms);
				});
				context.setPacketHandled(true);
			}
		}

		private static void pressAction(Player entity, int type, int pressedms) {
			Level world = entity.level();
			double x = entity.getX();
			double y = entity.getY();
			double z = entity.getZ();
			// security measure to prevent arbitrary chunk generation
			if (!world.hasChunkAt(BlockPos.containing(x, y, z)))
				return;
			if (type == 0) {

				CustomDojutsuOnKeyPressedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class ForwardDashKeyBinding extends NarutoShippudenModElements.ModElement {
		@OnlyIn(Dist.CLIENT)
		private KeyMapping keys;
		private long lastpress = 0;

		public ForwardDashKeyBinding(NarutoShippudenModElements instance) {
			super(instance, 1170);
			elements.addNetworkMessage(KeyBindingPressedMessage.class, KeyBindingPressedMessage::buffer, KeyBindingPressedMessage::new,
					KeyBindingPressedMessage::handler);
		}

		@Override
		@OnlyIn(Dist.CLIENT)
		public void initElements() {
			keys = new KeyMapping("", GLFW.GLFW_KEY_W, "");
			NeoForge.EVENT_BUS.register(this);
		}

		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void onKeyInput(InputEvent.KeyInputEvent event) {
			if (Minecraft.getInstance().screen == null) {
				if (event.getKey() == keys.getKey().getValue()) {
					if (event.getAction() == GLFW.GLFW_PRESS) {
						NarutoShippudenMod.PACKET_HANDLER.sendToServer(new KeyBindingPressedMessage(0, 0));
						pressAction(Minecraft.getInstance().player, 0, 0);
						lastpress = System.currentTimeMillis();
					} else if (event.getAction() == GLFW.GLFW_RELEASE) {
						int dt = (int) (System.currentTimeMillis() - lastpress);
						NarutoShippudenMod.PACKET_HANDLER.sendToServer(new KeyBindingPressedMessage(1, dt));
						pressAction(Minecraft.getInstance().player, 1, dt);
					}
				}
			}
		}

		public static class KeyBindingPressedMessage {
			int type, pressedms;

			public KeyBindingPressedMessage(int type, int pressedms) {
				this.type = type;
				this.pressedms = pressedms;
			}

			public KeyBindingPressedMessage(FriendlyByteBuf buffer) {
				this.type = buffer.readInt();
				this.pressedms = buffer.readInt();
			}

			public static void buffer(KeyBindingPressedMessage message, FriendlyByteBuf buffer) {
				buffer.writeInt(message.type);
				buffer.writeInt(message.pressedms);
			}

			public static void handler(KeyBindingPressedMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
				NetworkEvent.Context context = contextSupplier.get();
				context.enqueueWork(() -> {
					pressAction(context.getSender(), message.type, message.pressedms);
				});
				context.setPacketHandled(true);
			}
		}

		private static void pressAction(Player entity, int type, int pressedms) {
			Level world = entity.level();
			double x = entity.getX();
			double y = entity.getY();
			double z = entity.getZ();
			// security measure to prevent arbitrary chunk generation
			if (!world.hasChunkAt(BlockPos.containing(x, y, z)))
				return;
			if (type == 0) {

				ForwardDashOnKeyPressedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (type == 1) {

				ForwardDashOnKeyReleasedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class InfoCardOpenKeyBinding extends NarutoShippudenModElements.ModElement {
		@OnlyIn(Dist.CLIENT)
		private KeyMapping keys;

		public InfoCardOpenKeyBinding(NarutoShippudenModElements instance) {
			super(instance, 18);
			elements.addNetworkMessage(KeyBindingPressedMessage.class, KeyBindingPressedMessage::buffer, KeyBindingPressedMessage::new,
					KeyBindingPressedMessage::handler);
		}

		@Override
		@OnlyIn(Dist.CLIENT)
		public void initElements() {
			keys = new KeyMapping("key.naruto_shippuden.info_card_open", GLFW.GLFW_KEY_I, "key.categories.misc");
			ClientRegistry.registerKeyBinding(keys);
			NeoForge.EVENT_BUS.register(this);
		}

		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void onKeyInput(InputEvent.KeyInputEvent event) {
			if (Minecraft.getInstance().screen == null) {
				if (event.getKey() == keys.getKey().getValue()) {
					if (event.getAction() == GLFW.GLFW_PRESS) {
						NarutoShippudenMod.PACKET_HANDLER.sendToServer(new KeyBindingPressedMessage(0, 0));
						pressAction(Minecraft.getInstance().player, 0, 0);
					}
				}
			}
		}

		public static class KeyBindingPressedMessage {
			int type, pressedms;

			public KeyBindingPressedMessage(int type, int pressedms) {
				this.type = type;
				this.pressedms = pressedms;
			}

			public KeyBindingPressedMessage(FriendlyByteBuf buffer) {
				this.type = buffer.readInt();
				this.pressedms = buffer.readInt();
			}

			public static void buffer(KeyBindingPressedMessage message, FriendlyByteBuf buffer) {
				buffer.writeInt(message.type);
				buffer.writeInt(message.pressedms);
			}

			public static void handler(KeyBindingPressedMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
				NetworkEvent.Context context = contextSupplier.get();
				context.enqueueWork(() -> {
					pressAction(context.getSender(), message.type, message.pressedms);
				});
				context.setPacketHandled(true);
			}
		}

		private static void pressAction(Player entity, int type, int pressedms) {
			Level world = entity.level();
			double x = entity.getX();
			double y = entity.getY();
			double z = entity.getZ();
			// security measure to prevent arbitrary chunk generation
			if (!world.hasChunkAt(BlockPos.containing(x, y, z)))
				return;
			if (type == 0) {

				InfoCardOpenOnKeyPressedProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z), new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class IsshikiDojutsuKeyBinding extends NarutoShippudenModElements.ModElement {
		@OnlyIn(Dist.CLIENT)
		private KeyMapping keys;

		public IsshikiDojutsuKeyBinding(NarutoShippudenModElements instance) {
			super(instance, 546);
			elements.addNetworkMessage(KeyBindingPressedMessage.class, KeyBindingPressedMessage::buffer, KeyBindingPressedMessage::new,
					KeyBindingPressedMessage::handler);
		}

		@Override
		@OnlyIn(Dist.CLIENT)
		public void initElements() {
			keys = new KeyMapping("key.naruto_shippuden.isshiki_dojutsu", GLFW.GLFW_KEY_H, "key.categories.misc");
			ClientRegistry.registerKeyBinding(keys);
			NeoForge.EVENT_BUS.register(this);
		}

		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void onKeyInput(InputEvent.KeyInputEvent event) {
			if (Minecraft.getInstance().screen == null) {
				if (event.getKey() == keys.getKey().getValue()) {
					if (event.getAction() == GLFW.GLFW_PRESS) {
						NarutoShippudenMod.PACKET_HANDLER.sendToServer(new KeyBindingPressedMessage(0, 0));
						pressAction(Minecraft.getInstance().player, 0, 0);
					}
				}
			}
		}

		public static class KeyBindingPressedMessage {
			int type, pressedms;

			public KeyBindingPressedMessage(int type, int pressedms) {
				this.type = type;
				this.pressedms = pressedms;
			}

			public KeyBindingPressedMessage(FriendlyByteBuf buffer) {
				this.type = buffer.readInt();
				this.pressedms = buffer.readInt();
			}

			public static void buffer(KeyBindingPressedMessage message, FriendlyByteBuf buffer) {
				buffer.writeInt(message.type);
				buffer.writeInt(message.pressedms);
			}

			public static void handler(KeyBindingPressedMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
				NetworkEvent.Context context = contextSupplier.get();
				context.enqueueWork(() -> {
					pressAction(context.getSender(), message.type, message.pressedms);
				});
				context.setPacketHandled(true);
			}
		}

		private static void pressAction(Player entity, int type, int pressedms) {
			Level world = entity.level();
			double x = entity.getX();
			double y = entity.getY();
			double z = entity.getZ();
			// security measure to prevent arbitrary chunk generation
			if (!world.hasChunkAt(BlockPos.containing(x, y, z)))
				return;
			if (type == 0) {

				IsshikiDojutsuOnKeyPressedProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z), new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class JutsuPowerKeyBinding extends NarutoShippudenModElements.ModElement {
		@OnlyIn(Dist.CLIENT)
		private KeyMapping keys;

		public JutsuPowerKeyBinding(NarutoShippudenModElements instance) {
			super(instance, 150);
			elements.addNetworkMessage(KeyBindingPressedMessage.class, KeyBindingPressedMessage::buffer, KeyBindingPressedMessage::new,
					KeyBindingPressedMessage::handler);
		}

		@Override
		@OnlyIn(Dist.CLIENT)
		public void initElements() {
			keys = new KeyMapping("key.naruto_shippuden.jutsu_power", GLFW.GLFW_KEY_MINUS, "key.categories.misc");
			ClientRegistry.registerKeyBinding(keys);
			NeoForge.EVENT_BUS.register(this);
		}

		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void onKeyInput(InputEvent.KeyInputEvent event) {
			if (Minecraft.getInstance().screen == null) {
				if (event.getKey() == keys.getKey().getValue()) {
					if (event.getAction() == GLFW.GLFW_PRESS) {
						NarutoShippudenMod.PACKET_HANDLER.sendToServer(new KeyBindingPressedMessage(0, 0));
						pressAction(Minecraft.getInstance().player, 0, 0);
					}
				}
			}
		}

		public static class KeyBindingPressedMessage {
			int type, pressedms;

			public KeyBindingPressedMessage(int type, int pressedms) {
				this.type = type;
				this.pressedms = pressedms;
			}

			public KeyBindingPressedMessage(FriendlyByteBuf buffer) {
				this.type = buffer.readInt();
				this.pressedms = buffer.readInt();
			}

			public static void buffer(KeyBindingPressedMessage message, FriendlyByteBuf buffer) {
				buffer.writeInt(message.type);
				buffer.writeInt(message.pressedms);
			}

			public static void handler(KeyBindingPressedMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
				NetworkEvent.Context context = contextSupplier.get();
				context.enqueueWork(() -> {
					pressAction(context.getSender(), message.type, message.pressedms);
				});
				context.setPacketHandled(true);
			}
		}

		private static void pressAction(Player entity, int type, int pressedms) {
			Level world = entity.level();
			double x = entity.getX();
			double y = entity.getY();
			double z = entity.getZ();
			// security measure to prevent arbitrary chunk generation
			if (!world.hasChunkAt(BlockPos.containing(x, y, z)))
				return;
			if (type == 0) {

				JutsuPowerOnKeyPressedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class KetsuryuganKeyBinding extends NarutoShippudenModElements.ModElement {
		@OnlyIn(Dist.CLIENT)
		private KeyMapping keys;

		public KetsuryuganKeyBinding(NarutoShippudenModElements instance) {
			super(instance, 377);
			elements.addNetworkMessage(KeyBindingPressedMessage.class, KeyBindingPressedMessage::buffer, KeyBindingPressedMessage::new,
					KeyBindingPressedMessage::handler);
		}

		@Override
		@OnlyIn(Dist.CLIENT)
		public void initElements() {
			keys = new KeyMapping("key.naruto_shippuden.ketsuryugan", GLFW.GLFW_KEY_K, "key.categories.misc");
			ClientRegistry.registerKeyBinding(keys);
			NeoForge.EVENT_BUS.register(this);
		}

		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void onKeyInput(InputEvent.KeyInputEvent event) {
			if (Minecraft.getInstance().screen == null) {
				if (event.getKey() == keys.getKey().getValue()) {
					if (event.getAction() == GLFW.GLFW_PRESS) {
						NarutoShippudenMod.PACKET_HANDLER.sendToServer(new KeyBindingPressedMessage(0, 0));
						pressAction(Minecraft.getInstance().player, 0, 0);
					}
				}
			}
		}

		public static class KeyBindingPressedMessage {
			int type, pressedms;

			public KeyBindingPressedMessage(int type, int pressedms) {
				this.type = type;
				this.pressedms = pressedms;
			}

			public KeyBindingPressedMessage(FriendlyByteBuf buffer) {
				this.type = buffer.readInt();
				this.pressedms = buffer.readInt();
			}

			public static void buffer(KeyBindingPressedMessage message, FriendlyByteBuf buffer) {
				buffer.writeInt(message.type);
				buffer.writeInt(message.pressedms);
			}

			public static void handler(KeyBindingPressedMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
				NetworkEvent.Context context = contextSupplier.get();
				context.enqueueWork(() -> {
					pressAction(context.getSender(), message.type, message.pressedms);
				});
				context.setPacketHandled(true);
			}
		}

		private static void pressAction(Player entity, int type, int pressedms) {
			Level world = entity.level();
			double x = entity.getX();
			double y = entity.getY();
			double z = entity.getZ();
			// security measure to prevent arbitrary chunk generation
			if (!world.hasChunkAt(BlockPos.containing(x, y, z)))
				return;
			if (type == 0) {

				KetsuryuganOnKeyPressedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class LeftDashKeyBinding extends NarutoShippudenModElements.ModElement {
		@OnlyIn(Dist.CLIENT)
		private KeyMapping keys;

		public LeftDashKeyBinding(NarutoShippudenModElements instance) {
			super(instance, 1171);
			elements.addNetworkMessage(KeyBindingPressedMessage.class, KeyBindingPressedMessage::buffer, KeyBindingPressedMessage::new,
					KeyBindingPressedMessage::handler);
		}

		@Override
		@OnlyIn(Dist.CLIENT)
		public void initElements() {
			keys = new KeyMapping("", GLFW.GLFW_KEY_A, "");
			NeoForge.EVENT_BUS.register(this);
		}

		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void onKeyInput(InputEvent.KeyInputEvent event) {
			if (Minecraft.getInstance().screen == null) {
				if (event.getKey() == keys.getKey().getValue()) {
					if (event.getAction() == GLFW.GLFW_PRESS) {
						NarutoShippudenMod.PACKET_HANDLER.sendToServer(new KeyBindingPressedMessage(0, 0));
						pressAction(Minecraft.getInstance().player, 0, 0);
					}
				}
			}
		}

		public static class KeyBindingPressedMessage {
			int type, pressedms;

			public KeyBindingPressedMessage(int type, int pressedms) {
				this.type = type;
				this.pressedms = pressedms;
			}

			public KeyBindingPressedMessage(FriendlyByteBuf buffer) {
				this.type = buffer.readInt();
				this.pressedms = buffer.readInt();
			}

			public static void buffer(KeyBindingPressedMessage message, FriendlyByteBuf buffer) {
				buffer.writeInt(message.type);
				buffer.writeInt(message.pressedms);
			}

			public static void handler(KeyBindingPressedMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
				NetworkEvent.Context context = contextSupplier.get();
				context.enqueueWork(() -> {
					pressAction(context.getSender(), message.type, message.pressedms);
				});
				context.setPacketHandled(true);
			}
		}

		private static void pressAction(Player entity, int type, int pressedms) {
			Level world = entity.level();
			double x = entity.getX();
			double y = entity.getY();
			double z = entity.getZ();
			// security measure to prevent arbitrary chunk generation
			if (!world.hasChunkAt(BlockPos.containing(x, y, z)))
				return;
			if (type == 0) {

				LeftDashOnKeyPressedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class MangekyouSharinganKeyBinding extends NarutoShippudenModElements.ModElement {
		@OnlyIn(Dist.CLIENT)
		private KeyMapping keys;

		public MangekyouSharinganKeyBinding(NarutoShippudenModElements instance) {
			super(instance, 638);
			elements.addNetworkMessage(KeyBindingPressedMessage.class, KeyBindingPressedMessage::buffer, KeyBindingPressedMessage::new,
					KeyBindingPressedMessage::handler);
		}

		@Override
		@OnlyIn(Dist.CLIENT)
		public void initElements() {
			keys = new KeyMapping("key.naruto_shippuden.mangekyou_sharingan", GLFW.GLFW_KEY_N, "key.categories.misc");
			ClientRegistry.registerKeyBinding(keys);
			NeoForge.EVENT_BUS.register(this);
		}

		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void onKeyInput(InputEvent.KeyInputEvent event) {
			if (Minecraft.getInstance().screen == null) {
				if (event.getKey() == keys.getKey().getValue()) {
					if (event.getAction() == GLFW.GLFW_PRESS) {
						NarutoShippudenMod.PACKET_HANDLER.sendToServer(new KeyBindingPressedMessage(0, 0));
						pressAction(Minecraft.getInstance().player, 0, 0);
					}
				}
			}
		}

		public static class KeyBindingPressedMessage {
			int type, pressedms;

			public KeyBindingPressedMessage(int type, int pressedms) {
				this.type = type;
				this.pressedms = pressedms;
			}

			public KeyBindingPressedMessage(FriendlyByteBuf buffer) {
				this.type = buffer.readInt();
				this.pressedms = buffer.readInt();
			}

			public static void buffer(KeyBindingPressedMessage message, FriendlyByteBuf buffer) {
				buffer.writeInt(message.type);
				buffer.writeInt(message.pressedms);
			}

			public static void handler(KeyBindingPressedMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
				NetworkEvent.Context context = contextSupplier.get();
				context.enqueueWork(() -> {
					pressAction(context.getSender(), message.type, message.pressedms);
				});
				context.setPacketHandled(true);
			}
		}

		private static void pressAction(Player entity, int type, int pressedms) {
			Level world = entity.level();
			double x = entity.getX();
			double y = entity.getY();
			double z = entity.getZ();
			// security measure to prevent arbitrary chunk generation
			if (!world.hasChunkAt(BlockPos.containing(x, y, z)))
				return;
			if (type == 0) {

				MangekyouSharinganOnKeyPressedProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z), new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class RightDashKeyBinding extends NarutoShippudenModElements.ModElement {
		@OnlyIn(Dist.CLIENT)
		private KeyMapping keys;

		public RightDashKeyBinding(NarutoShippudenModElements instance) {
			super(instance, 1172);
			elements.addNetworkMessage(KeyBindingPressedMessage.class, KeyBindingPressedMessage::buffer, KeyBindingPressedMessage::new,
					KeyBindingPressedMessage::handler);
		}

		@Override
		@OnlyIn(Dist.CLIENT)
		public void initElements() {
			keys = new KeyMapping("", GLFW.GLFW_KEY_D, "");
			NeoForge.EVENT_BUS.register(this);
		}

		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void onKeyInput(InputEvent.KeyInputEvent event) {
			if (Minecraft.getInstance().screen == null) {
				if (event.getKey() == keys.getKey().getValue()) {
					if (event.getAction() == GLFW.GLFW_PRESS) {
						NarutoShippudenMod.PACKET_HANDLER.sendToServer(new KeyBindingPressedMessage(0, 0));
						pressAction(Minecraft.getInstance().player, 0, 0);
					}
				}
			}
		}

		public static class KeyBindingPressedMessage {
			int type, pressedms;

			public KeyBindingPressedMessage(int type, int pressedms) {
				this.type = type;
				this.pressedms = pressedms;
			}

			public KeyBindingPressedMessage(FriendlyByteBuf buffer) {
				this.type = buffer.readInt();
				this.pressedms = buffer.readInt();
			}

			public static void buffer(KeyBindingPressedMessage message, FriendlyByteBuf buffer) {
				buffer.writeInt(message.type);
				buffer.writeInt(message.pressedms);
			}

			public static void handler(KeyBindingPressedMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
				NetworkEvent.Context context = contextSupplier.get();
				context.enqueueWork(() -> {
					pressAction(context.getSender(), message.type, message.pressedms);
				});
				context.setPacketHandled(true);
			}
		}

		private static void pressAction(Player entity, int type, int pressedms) {
			Level world = entity.level();
			double x = entity.getX();
			double y = entity.getY();
			double z = entity.getZ();
			// security measure to prevent arbitrary chunk generation
			if (!world.hasChunkAt(BlockPos.containing(x, y, z)))
				return;
			if (type == 0) {

				RightDashOnKeyPressedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class RinneganKeyBinding extends NarutoShippudenModElements.ModElement {
		@OnlyIn(Dist.CLIENT)
		private KeyMapping keys;

		public RinneganKeyBinding(NarutoShippudenModElements instance) {
			super(instance, 779);
			elements.addNetworkMessage(KeyBindingPressedMessage.class, KeyBindingPressedMessage::buffer, KeyBindingPressedMessage::new,
					KeyBindingPressedMessage::handler);
		}

		@Override
		@OnlyIn(Dist.CLIENT)
		public void initElements() {
			keys = new KeyMapping("key.naruto_shippuden.rinnegan", GLFW.GLFW_KEY_Z, "key.categories.misc");
			ClientRegistry.registerKeyBinding(keys);
			NeoForge.EVENT_BUS.register(this);
		}

		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void onKeyInput(InputEvent.KeyInputEvent event) {
			if (Minecraft.getInstance().screen == null) {
				if (event.getKey() == keys.getKey().getValue()) {
					if (event.getAction() == GLFW.GLFW_PRESS) {
						NarutoShippudenMod.PACKET_HANDLER.sendToServer(new KeyBindingPressedMessage(0, 0));
						pressAction(Minecraft.getInstance().player, 0, 0);
					}
				}
			}
		}

		public static class KeyBindingPressedMessage {
			int type, pressedms;

			public KeyBindingPressedMessage(int type, int pressedms) {
				this.type = type;
				this.pressedms = pressedms;
			}

			public KeyBindingPressedMessage(FriendlyByteBuf buffer) {
				this.type = buffer.readInt();
				this.pressedms = buffer.readInt();
			}

			public static void buffer(KeyBindingPressedMessage message, FriendlyByteBuf buffer) {
				buffer.writeInt(message.type);
				buffer.writeInt(message.pressedms);
			}

			public static void handler(KeyBindingPressedMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
				NetworkEvent.Context context = contextSupplier.get();
				context.enqueueWork(() -> {
					pressAction(context.getSender(), message.type, message.pressedms);
				});
				context.setPacketHandled(true);
			}
		}

		private static void pressAction(Player entity, int type, int pressedms) {
			Level world = entity.level();
			double x = entity.getX();
			double y = entity.getY();
			double z = entity.getZ();
			// security measure to prevent arbitrary chunk generation
			if (!world.hasChunkAt(BlockPos.containing(x, y, z)))
				return;
			if (type == 0) {

				RinneganOnKeyPressedProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z), new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class SharinganKeyBinding extends NarutoShippudenModElements.ModElement {
		@OnlyIn(Dist.CLIENT)
		private KeyMapping keys;

		public SharinganKeyBinding(NarutoShippudenModElements instance) {
			super(instance, 374);
			elements.addNetworkMessage(KeyBindingPressedMessage.class, KeyBindingPressedMessage::buffer, KeyBindingPressedMessage::new,
					KeyBindingPressedMessage::handler);
		}

		@Override
		@OnlyIn(Dist.CLIENT)
		public void initElements() {
			keys = new KeyMapping("key.naruto_shippuden.sharingan", GLFW.GLFW_KEY_V, "key.categories.misc");
			ClientRegistry.registerKeyBinding(keys);
			NeoForge.EVENT_BUS.register(this);
		}

		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void onKeyInput(InputEvent.KeyInputEvent event) {
			if (Minecraft.getInstance().screen == null) {
				if (event.getKey() == keys.getKey().getValue()) {
					if (event.getAction() == GLFW.GLFW_PRESS) {
						NarutoShippudenMod.PACKET_HANDLER.sendToServer(new KeyBindingPressedMessage(0, 0));
						pressAction(Minecraft.getInstance().player, 0, 0);
					}
				}
			}
		}

		public static class KeyBindingPressedMessage {
			int type, pressedms;

			public KeyBindingPressedMessage(int type, int pressedms) {
				this.type = type;
				this.pressedms = pressedms;
			}

			public KeyBindingPressedMessage(FriendlyByteBuf buffer) {
				this.type = buffer.readInt();
				this.pressedms = buffer.readInt();
			}

			public static void buffer(KeyBindingPressedMessage message, FriendlyByteBuf buffer) {
				buffer.writeInt(message.type);
				buffer.writeInt(message.pressedms);
			}

			public static void handler(KeyBindingPressedMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
				NetworkEvent.Context context = contextSupplier.get();
				context.enqueueWork(() -> {
					pressAction(context.getSender(), message.type, message.pressedms);
				});
				context.setPacketHandled(true);
			}
		}

		private static void pressAction(Player entity, int type, int pressedms) {
			Level world = entity.level();
			double x = entity.getX();
			double y = entity.getY();
			double z = entity.getZ();
			// security measure to prevent arbitrary chunk generation
			if (!world.hasChunkAt(BlockPos.containing(x, y, z)))
				return;
			if (type == 0) {

				SharinganOnKeyPressedProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z), new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class SusanoKeyBinding extends NarutoShippudenModElements.ModElement {
		@OnlyIn(Dist.CLIENT)
		private KeyMapping keys;

		public SusanoKeyBinding(NarutoShippudenModElements instance) {
			super(instance, 1226);
			elements.addNetworkMessage(KeyBindingPressedMessage.class, KeyBindingPressedMessage::buffer, KeyBindingPressedMessage::new,
					KeyBindingPressedMessage::handler);
		}

		@Override
		@OnlyIn(Dist.CLIENT)
		public void initElements() {
			keys = new KeyMapping("key.naruto_shippuden.susano", GLFW.GLFW_KEY_J, "key.categories.misc");
			ClientRegistry.registerKeyBinding(keys);
			NeoForge.EVENT_BUS.register(this);
		}

		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void onKeyInput(InputEvent.KeyInputEvent event) {
			if (Minecraft.getInstance().screen == null) {
				if (event.getKey() == keys.getKey().getValue()) {
					if (event.getAction() == GLFW.GLFW_PRESS) {
						NarutoShippudenMod.PACKET_HANDLER.sendToServer(new KeyBindingPressedMessage(0, 0));
						pressAction(Minecraft.getInstance().player, 0, 0);
					}
				}
			}
		}

		public static class KeyBindingPressedMessage {
			int type, pressedms;

			public KeyBindingPressedMessage(int type, int pressedms) {
				this.type = type;
				this.pressedms = pressedms;
			}

			public KeyBindingPressedMessage(FriendlyByteBuf buffer) {
				this.type = buffer.readInt();
				this.pressedms = buffer.readInt();
			}

			public static void buffer(KeyBindingPressedMessage message, FriendlyByteBuf buffer) {
				buffer.writeInt(message.type);
				buffer.writeInt(message.pressedms);
			}

			public static void handler(KeyBindingPressedMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
				NetworkEvent.Context context = contextSupplier.get();
				context.enqueueWork(() -> {
					pressAction(context.getSender(), message.type, message.pressedms);
				});
				context.setPacketHandled(true);
			}
		}

		private static void pressAction(Player entity, int type, int pressedms) {
			Level world = entity.level();
			double x = entity.getX();
			double y = entity.getY();
			double z = entity.getZ();
			// security measure to prevent arbitrary chunk generation
			if (!world.hasChunkAt(BlockPos.containing(x, y, z)))
				return;
			if (type == 0) {

				SusanoOnKeyPressedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class TenseiganKeyBinding extends NarutoShippudenModElements.ModElement {
		@OnlyIn(Dist.CLIENT)
		private KeyMapping keys;

		public TenseiganKeyBinding(NarutoShippudenModElements instance) {
			super(instance, 778);
			elements.addNetworkMessage(KeyBindingPressedMessage.class, KeyBindingPressedMessage::buffer, KeyBindingPressedMessage::new,
					KeyBindingPressedMessage::handler);
		}

		@Override
		@OnlyIn(Dist.CLIENT)
		public void initElements() {
			keys = new KeyMapping("key.naruto_shippuden.tenseigan", GLFW.GLFW_KEY_C, "key.categories.misc");
			ClientRegistry.registerKeyBinding(keys);
			NeoForge.EVENT_BUS.register(this);
		}

		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void onKeyInput(InputEvent.KeyInputEvent event) {
			if (Minecraft.getInstance().screen == null) {
				if (event.getKey() == keys.getKey().getValue()) {
					if (event.getAction() == GLFW.GLFW_PRESS) {
						NarutoShippudenMod.PACKET_HANDLER.sendToServer(new KeyBindingPressedMessage(0, 0));
						pressAction(Minecraft.getInstance().player, 0, 0);
					}
				}
			}
		}

		public static class KeyBindingPressedMessage {
			int type, pressedms;

			public KeyBindingPressedMessage(int type, int pressedms) {
				this.type = type;
				this.pressedms = pressedms;
			}

			public KeyBindingPressedMessage(FriendlyByteBuf buffer) {
				this.type = buffer.readInt();
				this.pressedms = buffer.readInt();
			}

			public static void buffer(KeyBindingPressedMessage message, FriendlyByteBuf buffer) {
				buffer.writeInt(message.type);
				buffer.writeInt(message.pressedms);
			}

			public static void handler(KeyBindingPressedMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
				NetworkEvent.Context context = contextSupplier.get();
				context.enqueueWork(() -> {
					pressAction(context.getSender(), message.type, message.pressedms);
				});
				context.setPacketHandled(true);
			}
		}

		private static void pressAction(Player entity, int type, int pressedms) {
			Level world = entity.level();
			double x = entity.getX();
			double y = entity.getY();
			double z = entity.getZ();
			// security measure to prevent arbitrary chunk generation
			if (!world.hasChunkAt(BlockPos.containing(x, y, z)))
				return;
			if (type == 0) {

				TenseiganOnKeyPressedProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
								new AbstractMap.SimpleEntry<>("z", z), new AbstractMap.SimpleEntry<>("entity", entity))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class UpDashKeyBinding extends NarutoShippudenModElements.ModElement {
		@OnlyIn(Dist.CLIENT)
		private KeyMapping keys;
		private long lastpress = 0;

		public UpDashKeyBinding(NarutoShippudenModElements instance) {
			super(instance, 1175);
			elements.addNetworkMessage(KeyBindingPressedMessage.class, KeyBindingPressedMessage::buffer, KeyBindingPressedMessage::new,
					KeyBindingPressedMessage::handler);
		}

		@Override
		@OnlyIn(Dist.CLIENT)
		public void initElements() {
			keys = new KeyMapping("", GLFW.GLFW_KEY_SPACE, "");
			NeoForge.EVENT_BUS.register(this);
		}

		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void onKeyInput(InputEvent.KeyInputEvent event) {
			if (Minecraft.getInstance().screen == null) {
				if (event.getKey() == keys.getKey().getValue()) {
					if (event.getAction() == GLFW.GLFW_PRESS) {
						NarutoShippudenMod.PACKET_HANDLER.sendToServer(new KeyBindingPressedMessage(0, 0));
						pressAction(Minecraft.getInstance().player, 0, 0);
						lastpress = System.currentTimeMillis();
					} else if (event.getAction() == GLFW.GLFW_RELEASE) {
						int dt = (int) (System.currentTimeMillis() - lastpress);
						NarutoShippudenMod.PACKET_HANDLER.sendToServer(new KeyBindingPressedMessage(1, dt));
						pressAction(Minecraft.getInstance().player, 1, dt);
					}
				}
			}
		}

		public static class KeyBindingPressedMessage {
			int type, pressedms;

			public KeyBindingPressedMessage(int type, int pressedms) {
				this.type = type;
				this.pressedms = pressedms;
			}

			public KeyBindingPressedMessage(FriendlyByteBuf buffer) {
				this.type = buffer.readInt();
				this.pressedms = buffer.readInt();
			}

			public static void buffer(KeyBindingPressedMessage message, FriendlyByteBuf buffer) {
				buffer.writeInt(message.type);
				buffer.writeInt(message.pressedms);
			}

			public static void handler(KeyBindingPressedMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
				NetworkEvent.Context context = contextSupplier.get();
				context.enqueueWork(() -> {
					pressAction(context.getSender(), message.type, message.pressedms);
				});
				context.setPacketHandled(true);
			}
		}

		private static void pressAction(Player entity, int type, int pressedms) {
			Level world = entity.level();
			double x = entity.getX();
			double y = entity.getY();
			double z = entity.getZ();
			// security measure to prevent arbitrary chunk generation
			if (!world.hasChunkAt(BlockPos.containing(x, y, z)))
				return;
			if (type == 0) {

				UpDashOnKeyPressedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
			if (type == 1) {

				UpDashOnKeyReleasedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			}
		}
	}
}
