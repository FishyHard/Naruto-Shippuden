package net.mcreator.narutoshippudenmod.client;

import net.mcreator.narutoshippudenmod.NarutoShippudenMod;
import net.mcreator.narutoshippudenmod.keybind.ModKeyBindings.*;
import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.InputEvent;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;

/** The mod's key mappings and what pressing them does on the client (the server side is in ModKeyBindings). */
@EventBusSubscriber(modid = "naruto_shippuden", value = Dist.CLIENT)
public final class ModKeyMappings {
	private ModKeyMappings() {
	}

	static final KeyMapping BACKDASHKEYBINDING = new KeyMapping("key.naruto_shippuden.backdash", InputConstants.KEY_S, KeyMapping.Category.MISC);
	static final KeyMapping BYAKUGANKEYBINDING = new KeyMapping("key.naruto_shippuden.byakugan", InputConstants.KEY_B, KeyMapping.Category.MISC);
	static final KeyMapping CHAKRACONTROLKEYBINDING = new KeyMapping("key.naruto_shippuden.chakra_control", InputConstants.KEY_G, KeyMapping.Category.MISC);
	private static long ChakraControlKeyBinding_lastpress = 0;
	static final KeyMapping FORWARDDASHKEYBINDING = new KeyMapping("key.naruto_shippuden.forwarddash", InputConstants.KEY_W, KeyMapping.Category.MISC);
	private static long ForwardDashKeyBinding_lastpress = 0;
	static final KeyMapping INFOCARDOPENKEYBINDING = new KeyMapping("key.naruto_shippuden.info_card_open", InputConstants.KEY_I, KeyMapping.Category.MISC);
	static final KeyMapping ISSHIKIDOJUTSUKEYBINDING = new KeyMapping("key.naruto_shippuden.isshiki_dojutsu", InputConstants.KEY_H, KeyMapping.Category.MISC);
	static final KeyMapping JUTSUPOWERKEYBINDING = new KeyMapping("key.naruto_shippuden.jutsu_power", InputConstants.KEY_MINUS, KeyMapping.Category.MISC);
	static final KeyMapping KETSURYUGANKEYBINDING = new KeyMapping("key.naruto_shippuden.ketsuryugan", InputConstants.KEY_K, KeyMapping.Category.MISC);
	static final KeyMapping LEFTDASHKEYBINDING = new KeyMapping("key.naruto_shippuden.leftdash", InputConstants.KEY_A, KeyMapping.Category.MISC);
	static final KeyMapping MANGEKYOUSHARINGANKEYBINDING = new KeyMapping("key.naruto_shippuden.mangekyou_sharingan", InputConstants.KEY_N, KeyMapping.Category.MISC);
	static final KeyMapping RIGHTDASHKEYBINDING = new KeyMapping("key.naruto_shippuden.rightdash", InputConstants.KEY_D, KeyMapping.Category.MISC);
	static final KeyMapping RINNEGANKEYBINDING = new KeyMapping("key.naruto_shippuden.rinnegan", InputConstants.KEY_Z, KeyMapping.Category.MISC);
	static final KeyMapping SHARINGANKEYBINDING = new KeyMapping("key.naruto_shippuden.sharingan", InputConstants.KEY_V, KeyMapping.Category.MISC);
	static final KeyMapping SUSANOKEYBINDING = new KeyMapping("key.naruto_shippuden.susano", InputConstants.KEY_J, KeyMapping.Category.MISC);
	static final KeyMapping TENSEIGANKEYBINDING = new KeyMapping("key.naruto_shippuden.tenseigan", InputConstants.KEY_C, KeyMapping.Category.MISC);
	static final KeyMapping UPDASHKEYBINDING = new KeyMapping("key.naruto_shippuden.updash", InputConstants.KEY_SPACE, KeyMapping.Category.MISC);
	private static long UpDashKeyBinding_lastpress = 0;

	@SubscribeEvent
	public static void register(RegisterKeyMappingsEvent event) {
		event.register(BACKDASHKEYBINDING);
		event.register(BYAKUGANKEYBINDING);
		event.register(CHAKRACONTROLKEYBINDING);
		event.register(FORWARDDASHKEYBINDING);
		event.register(INFOCARDOPENKEYBINDING);
		event.register(ISSHIKIDOJUTSUKEYBINDING);
		event.register(JUTSUPOWERKEYBINDING);
		event.register(KETSURYUGANKEYBINDING);
		event.register(LEFTDASHKEYBINDING);
		event.register(MANGEKYOUSHARINGANKEYBINDING);
		event.register(RIGHTDASHKEYBINDING);
		event.register(RINNEGANKEYBINDING);
		event.register(SHARINGANKEYBINDING);
		event.register(SUSANOKEYBINDING);
		event.register(TENSEIGANKEYBINDING);
		event.register(UPDASHKEYBINDING);
	}

	@SubscribeEvent
	public static void onKey(InputEvent.Key event) {
		onBackDashKeyBinding(event);
		onByakuganKeyBinding(event);
		onChakraControlKeyBinding(event);
		onForwardDashKeyBinding(event);
		onInfoCardOpenKeyBinding(event);
		onIsshikiDojutsuKeyBinding(event);
		onJutsuPowerKeyBinding(event);
		onKetsuryuganKeyBinding(event);
		onLeftDashKeyBinding(event);
		onMangekyouSharinganKeyBinding(event);
		onRightDashKeyBinding(event);
		onRinneganKeyBinding(event);
		onSharinganKeyBinding(event);
		onSusanoKeyBinding(event);
		onTenseiganKeyBinding(event);
		onUpDashKeyBinding(event);
	}

	private static void onBackDashKeyBinding(InputEvent.Key event) {

			if (Minecraft.getInstance().gui.screen() == null) {
				if (event.getKey() == BACKDASHKEYBINDING.getKey().getValue()) {
					if (event.getAction() == InputConstants.PRESS) {
						NarutoShippudenMod.PACKET_HANDLER.sendToServer(new BackDashKeyBinding.KeyBindingPressedMessage(0, 0));
						BackDashKeyBinding.pressAction(Minecraft.getInstance().player, 0, 0);
					}
				}
			}
	}

	private static void onByakuganKeyBinding(InputEvent.Key event) {

			if (Minecraft.getInstance().gui.screen() == null) {
				if (event.getKey() == BYAKUGANKEYBINDING.getKey().getValue()) {
					if (event.getAction() == InputConstants.PRESS) {
						NarutoShippudenMod.PACKET_HANDLER.sendToServer(new ByakuganKeyBinding.KeyBindingPressedMessage(0, 0));
						ByakuganKeyBinding.pressAction(Minecraft.getInstance().player, 0, 0);
					}
				}
			}
	}

	private static void onChakraControlKeyBinding(InputEvent.Key event) {

			if (Minecraft.getInstance().gui.screen() == null) {
				if (event.getKey() == CHAKRACONTROLKEYBINDING.getKey().getValue()) {
					if (event.getAction() == InputConstants.PRESS) {
						NarutoShippudenMod.PACKET_HANDLER.sendToServer(new ChakraControlKeyBinding.KeyBindingPressedMessage(0, 0));
						ChakraControlKeyBinding.pressAction(Minecraft.getInstance().player, 0, 0);
						ChakraControlKeyBinding_lastpress = System.currentTimeMillis();
					} else if (event.getAction() == InputConstants.RELEASE) {
						int dt = (int) (System.currentTimeMillis() - ChakraControlKeyBinding_lastpress);
						NarutoShippudenMod.PACKET_HANDLER.sendToServer(new ChakraControlKeyBinding.KeyBindingPressedMessage(1, dt));
						ChakraControlKeyBinding.pressAction(Minecraft.getInstance().player, 1, dt);
					}
				}
			}
	}


	private static void onForwardDashKeyBinding(InputEvent.Key event) {

			if (Minecraft.getInstance().gui.screen() == null) {
				if (event.getKey() == FORWARDDASHKEYBINDING.getKey().getValue()) {
					if (event.getAction() == InputConstants.PRESS) {
						NarutoShippudenMod.PACKET_HANDLER.sendToServer(new ForwardDashKeyBinding.KeyBindingPressedMessage(0, 0));
						ForwardDashKeyBinding.pressAction(Minecraft.getInstance().player, 0, 0);
						ForwardDashKeyBinding_lastpress = System.currentTimeMillis();
					} else if (event.getAction() == InputConstants.RELEASE) {
						int dt = (int) (System.currentTimeMillis() - ForwardDashKeyBinding_lastpress);
						NarutoShippudenMod.PACKET_HANDLER.sendToServer(new ForwardDashKeyBinding.KeyBindingPressedMessage(1, dt));
						ForwardDashKeyBinding.pressAction(Minecraft.getInstance().player, 1, dt);
					}
				}
			}
	}

	private static void onInfoCardOpenKeyBinding(InputEvent.Key event) {

			if (Minecraft.getInstance().gui.screen() == null) {
				if (event.getKey() == INFOCARDOPENKEYBINDING.getKey().getValue()) {
					if (event.getAction() == InputConstants.PRESS) {
						NarutoShippudenMod.PACKET_HANDLER.sendToServer(new InfoCardOpenKeyBinding.KeyBindingPressedMessage(0, 0));
						InfoCardOpenKeyBinding.pressAction(Minecraft.getInstance().player, 0, 0);
					}
				}
			}
	}

	private static void onIsshikiDojutsuKeyBinding(InputEvent.Key event) {

			if (Minecraft.getInstance().gui.screen() == null) {
				if (event.getKey() == ISSHIKIDOJUTSUKEYBINDING.getKey().getValue()) {
					if (event.getAction() == InputConstants.PRESS) {
						NarutoShippudenMod.PACKET_HANDLER.sendToServer(new IsshikiDojutsuKeyBinding.KeyBindingPressedMessage(0, 0));
						IsshikiDojutsuKeyBinding.pressAction(Minecraft.getInstance().player, 0, 0);
					}
				}
			}
	}

	private static void onJutsuPowerKeyBinding(InputEvent.Key event) {

			if (Minecraft.getInstance().gui.screen() == null) {
				if (event.getKey() == JUTSUPOWERKEYBINDING.getKey().getValue()) {
					if (event.getAction() == InputConstants.PRESS) {
						NarutoShippudenMod.PACKET_HANDLER.sendToServer(new JutsuPowerKeyBinding.KeyBindingPressedMessage(0, 0));
						JutsuPowerKeyBinding.pressAction(Minecraft.getInstance().player, 0, 0);
					}
				}
			}
	}

	private static void onKetsuryuganKeyBinding(InputEvent.Key event) {

			if (Minecraft.getInstance().gui.screen() == null) {
				if (event.getKey() == KETSURYUGANKEYBINDING.getKey().getValue()) {
					if (event.getAction() == InputConstants.PRESS) {
						NarutoShippudenMod.PACKET_HANDLER.sendToServer(new KetsuryuganKeyBinding.KeyBindingPressedMessage(0, 0));
						KetsuryuganKeyBinding.pressAction(Minecraft.getInstance().player, 0, 0);
					}
				}
			}
	}

	private static void onLeftDashKeyBinding(InputEvent.Key event) {

			if (Minecraft.getInstance().gui.screen() == null) {
				if (event.getKey() == LEFTDASHKEYBINDING.getKey().getValue()) {
					if (event.getAction() == InputConstants.PRESS) {
						NarutoShippudenMod.PACKET_HANDLER.sendToServer(new LeftDashKeyBinding.KeyBindingPressedMessage(0, 0));
						LeftDashKeyBinding.pressAction(Minecraft.getInstance().player, 0, 0);
					}
				}
			}
	}

	private static void onMangekyouSharinganKeyBinding(InputEvent.Key event) {

			if (Minecraft.getInstance().gui.screen() == null) {
				if (event.getKey() == MANGEKYOUSHARINGANKEYBINDING.getKey().getValue()) {
					if (event.getAction() == InputConstants.PRESS) {
						NarutoShippudenMod.PACKET_HANDLER.sendToServer(new MangekyouSharinganKeyBinding.KeyBindingPressedMessage(0, 0));
						MangekyouSharinganKeyBinding.pressAction(Minecraft.getInstance().player, 0, 0);
					}
				}
			}
	}

	private static void onRightDashKeyBinding(InputEvent.Key event) {

			if (Minecraft.getInstance().gui.screen() == null) {
				if (event.getKey() == RIGHTDASHKEYBINDING.getKey().getValue()) {
					if (event.getAction() == InputConstants.PRESS) {
						NarutoShippudenMod.PACKET_HANDLER.sendToServer(new RightDashKeyBinding.KeyBindingPressedMessage(0, 0));
						RightDashKeyBinding.pressAction(Minecraft.getInstance().player, 0, 0);
					}
				}
			}
	}

	private static void onRinneganKeyBinding(InputEvent.Key event) {

			if (Minecraft.getInstance().gui.screen() == null) {
				if (event.getKey() == RINNEGANKEYBINDING.getKey().getValue()) {
					if (event.getAction() == InputConstants.PRESS) {
						NarutoShippudenMod.PACKET_HANDLER.sendToServer(new RinneganKeyBinding.KeyBindingPressedMessage(0, 0));
						RinneganKeyBinding.pressAction(Minecraft.getInstance().player, 0, 0);
					}
				}
			}
	}

	private static void onSharinganKeyBinding(InputEvent.Key event) {

			if (Minecraft.getInstance().gui.screen() == null) {
				if (event.getKey() == SHARINGANKEYBINDING.getKey().getValue()) {
					if (event.getAction() == InputConstants.PRESS) {
						NarutoShippudenMod.PACKET_HANDLER.sendToServer(new SharinganKeyBinding.KeyBindingPressedMessage(0, 0));
						SharinganKeyBinding.pressAction(Minecraft.getInstance().player, 0, 0);
					}
				}
			}
	}

	private static void onSusanoKeyBinding(InputEvent.Key event) {

			if (Minecraft.getInstance().gui.screen() == null) {
				if (event.getKey() == SUSANOKEYBINDING.getKey().getValue()) {
					if (event.getAction() == InputConstants.PRESS) {
						NarutoShippudenMod.PACKET_HANDLER.sendToServer(new SusanoKeyBinding.KeyBindingPressedMessage(0, 0));
						SusanoKeyBinding.pressAction(Minecraft.getInstance().player, 0, 0);
					}
				}
			}
	}

	private static void onTenseiganKeyBinding(InputEvent.Key event) {

			if (Minecraft.getInstance().gui.screen() == null) {
				if (event.getKey() == TENSEIGANKEYBINDING.getKey().getValue()) {
					if (event.getAction() == InputConstants.PRESS) {
						NarutoShippudenMod.PACKET_HANDLER.sendToServer(new TenseiganKeyBinding.KeyBindingPressedMessage(0, 0));
						TenseiganKeyBinding.pressAction(Minecraft.getInstance().player, 0, 0);
					}
				}
			}
	}

	private static void onUpDashKeyBinding(InputEvent.Key event) {

			if (Minecraft.getInstance().gui.screen() == null) {
				if (event.getKey() == UPDASHKEYBINDING.getKey().getValue()) {
					if (event.getAction() == InputConstants.PRESS) {
						NarutoShippudenMod.PACKET_HANDLER.sendToServer(new UpDashKeyBinding.KeyBindingPressedMessage(0, 0));
						UpDashKeyBinding.pressAction(Minecraft.getInstance().player, 0, 0);
						UpDashKeyBinding_lastpress = System.currentTimeMillis();
					} else if (event.getAction() == InputConstants.RELEASE) {
						int dt = (int) (System.currentTimeMillis() - UpDashKeyBinding_lastpress);
						NarutoShippudenMod.PACKET_HANDLER.sendToServer(new UpDashKeyBinding.KeyBindingPressedMessage(1, dt));
						UpDashKeyBinding.pressAction(Minecraft.getInstance().player, 1, dt);
					}
				}
			}
	}
}
