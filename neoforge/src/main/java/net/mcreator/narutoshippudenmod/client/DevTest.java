package net.mcreator.narutoshippudenmod.client;

import net.mcreator.narutoshippudenmod.NarutoShippudenMod;
import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables;
import net.minecraft.client.CameraType;
import net.minecraft.client.Minecraft;
import net.minecraft.client.Screenshot;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.screens.Screen;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ClientTickEvent;

/**
 * Development-only visual check, enabled with -Dnaruto.devtest=true (./gradlew runClient -PdevTest): logs which screen
 * is open, and once in a world turns on a dojutsu, switches to the front camera and saves screenshots.
 */
@EventBusSubscriber(modid = "naruto_shippuden", value = Dist.CLIENT)
public final class DevTest {
	private static final boolean ENABLED = Boolean.getBoolean("naruto.devtest");
	private static int ticks;
	private static int inWorld;

	/** -Dnaruto.devtest.screens=true: open every mod screen in turn and save run/screenshots/screen_<name>.png. */
	private static final boolean SCREENS = Boolean.getBoolean("naruto.devtest.screens");
	private static final String[] MENUS = {"InfoCardGuis$InfoCardGui", "InfoCardGuis$InfoCardDojutsuGui", "InfoCardGuis$InfoCardMiniGameGui",
			"InfoCardGuis$InfoCardMissionsGui", "InfoCardGuis$InfoCardUpgradeGui", "InfoCardGuis$StatSelectGui", "CheatGuis$MangekyouSharinganCheatGui",
			"CheatGuis$NarutoShippudenCheatDojutsuGUIGui", "CheatGuis$NarutoShippudenCheatGUIGui", "CheatGuis$NarutoShippudenCheatKekkeiGenkaiGUIGui",
			"CheatGuis$PasswordGUIDojutsuGui", "MiscGuis$AdventCalendarGUIGui", "MiscGuis$GeninHeadbandSelectGui", "MiscGuis$PatreonKitGui",
			"JutsuCreationGuis$CreateJutsuGUIGui", "JutsuCreationGuis$CreateJutsuGUI2Gui"};
	private static final java.util.List<Runnable> STEPS = new java.util.ArrayList<>();
	private static int step;
	private static int screenTicks;

	private DevTest() {
	}

	private static void shot(Minecraft mc, String name) {
		Screenshot.grab(mc.gameDirectory, "screen_" + name + ".png", mc.gameRenderer.mainRenderTarget(), 1,
				msg -> NarutoShippudenMod.LOGGER.info("DEVTEST {}", msg.getString()));
	}

	private static void onServer(Minecraft mc, java.util.function.Consumer<net.minecraft.server.level.ServerPlayer> task) {
		var server = mc.getSingleplayerServer();
		server.execute(() -> task.accept(server.getPlayerList().getPlayer(mc.player.getUUID())));
	}

	private static void command(Minecraft mc, String command) {
		onServer(mc, player -> player.level().getServer().getCommands().performPrefixedCommand(player.createCommandSourceStack().withPermission(
				net.minecraft.server.permissions.LevelBasedPermissionSet.OWNER), command));
	}

	private static void click(Minecraft mc, String label) {
		if (mc.gui.screen() != null)
			for (var child : java.util.List.copyOf(mc.gui.screen().children()))
				if (child instanceof net.minecraft.client.gui.components.AbstractButton b && b.getMessage().getString().equals(label)) {
					b.onPress(new net.minecraft.client.input.KeyEvent(com.mojang.blaze3d.platform.InputConstants.KEY_RETURN, 0, 0));
					return;
				}
	}

	private static void open(Minecraft mc, String menu) {
		onServer(mc, player -> {
			try {
				var ctor = Class.forName("net.mcreator.narutoshippudenmod.gui." + menu + "$GuiContainerMod").getConstructor(int.class,
						net.minecraft.world.entity.player.Inventory.class, net.minecraft.network.FriendlyByteBuf.class);
				var pos = player.blockPosition();
				player.openMenu(new net.minecraft.world.SimpleMenuProvider((id, inv, p) -> {
					try {
						return (net.minecraft.world.inventory.AbstractContainerMenu) ctor.newInstance(id, inv,
								new net.minecraft.network.FriendlyByteBuf(io.netty.buffer.Unpooled.buffer()).writeBlockPos(pos));
					} catch (ReflectiveOperationException e) {
						throw new RuntimeException(e);
					}
				}, net.minecraft.network.chat.Component.literal(menu)), buf -> buf.writeBlockPos(pos));
			} catch (ReflectiveOperationException e) {
				NarutoShippudenMod.LOGGER.error("DEVTEST cannot open {}", menu, e);
			}
		});
	}

	/** Every mod screen, the cheat tabs, then NPCs and the Byakugan outline in the world; 60 ticks per step. */
	private static void buildSteps(Minecraft mc) {
		STEPS.add(() -> shot(mc, "hud"));
		for (String menu : MENUS) {
			String name = menu.substring(menu.indexOf('$') + 1);
			STEPS.add(() -> open(mc, menu));
			STEPS.add(() -> shot(mc, name));
			if (name.equals("NarutoShippudenCheatGUIGui")) {
				STEPS.add(() -> click(mc, "Dojutsu"));
				STEPS.add(() -> shot(mc, name + "_dojutsu"));
				STEPS.add(() -> click(mc, "Kekkei Genkai"));
				STEPS.add(() -> shot(mc, name + "_kekkei"));
				STEPS.add(() -> click(mc, "Player"));
			}
		}
		STEPS.add(() -> {
			mc.player.closeContainer();
			mc.options.setCameraType(CameraType.FIRST_PERSON);
			onServer(mc, player -> {
				player.setYRot(0);
				player.setXRot(10);
				NarutoShippudenModVariables.ifPresent(player, v -> {
					v.byakugan = true;
					v.byakuganactivate = true;
					v.syncPlayerVariables(player);
				});
			});
			command(mc, "tp @s ~ ~ ~ 0 10");
			command(mc, "summon naruto_shippuden:asuma ~-1.5 ~ ~4 {NoAI:1b,Rotation:[180f,0f]}");
			command(mc, "summon naruto_shippuden:shikamaru ~1.5 ~ ~4 {NoAI:1b,Rotation:[180f,0f]}");
			command(mc, "summon minecraft:zombie ~ ~ ~10 {NoAI:1b,Rotation:[180f,0f]}");
		});
		STEPS.add(() -> shot(mc, "world"));
		// jutsu: learn from the fire scroll, choose on the wheel, cast
		STEPS.add(() -> {
			command(mc, "clear @s");
			command(mc, "give @s naruto_shippuden:fire_release");
			command(mc, "give @s naruto_shippuden:fire_release_technique");
			command(mc, "naruto set jp 100 @s");
			command(mc, "naruto set ninjutsu 50 @s");
			command(mc, "naruto set chakra 500 @s");
			mc.player.getInventory().setSelectedSlot(0);
		});
		STEPS.add(() -> mc.gui.setScreen(new JutsuClient.ScrollScreen(
				net.mcreator.narutoshippudenmod.core.jutsu.Jutsus.RELEASES.get(net.minecraft.resources.Identifier.parse("naruto_shippuden:fire_release")),
				net.minecraft.network.chat.Component.literal("Fire Release"))));
		STEPS.add(() -> click(mc, "15 JP"));
		STEPS.add(() -> shot(mc, "jutsu_scroll"));
		STEPS.add(() -> {
			mc.player.closeContainer();
			mc.gui.setScreen(null);
			for (int slot = 0; slot < 9; slot++)
				if (net.mcreator.narutoshippudenmod.core.jutsu.Jutsus.technique(mc.player.getInventory().getItem(slot)) != null)
					mc.player.getInventory().setSelectedSlot(slot);
		});
		STEPS.add(() -> {
			if (JutsuClient.held(mc.player) != null)
				mc.gui.setScreen(new JutsuClient.WheelScreen(JutsuClient.held(mc.player)));
		});
		STEPS.add(() -> shot(mc, "jutsu_wheel"));
		STEPS.add(() -> {
			mc.gui.setScreen(null);
			NarutoShippudenMod.LOGGER.info("DEVTEST chakra before cast {}", NarutoShippudenModVariables.get(mc.player).ChakraAmount);
			mc.gameMode.useItem(mc.player, net.minecraft.world.InteractionHand.MAIN_HAND);
		});
		STEPS.add(() -> {
			NarutoShippudenMod.LOGGER.info("DEVTEST chakra after cast {} cooldown {}", NarutoShippudenModVariables.get(mc.player).ChakraAmount,
					mc.player.getCooldowns().isOnCooldown(mc.player.getMainHandItem()));
			mc.gameMode.useItem(mc.player, net.minecraft.world.InteractionHand.MAIN_HAND);
			shot(mc, "jutsu_cast");
		});
		STEPS.add(() -> {
			command(mc, "give @s naruto_shippuden:mangekyou_sharingan_sasuke_release");
			command(mc, "naruto set jp 40 @s");
		});
		STEPS.add(() -> mc.gui.setScreen(new JutsuClient.ScrollScreen(
				net.mcreator.narutoshippudenmod.core.jutsu.Jutsus.RELEASES.get(net.minecraft.resources.Identifier.parse("naruto_shippuden:mangekyou_sharingan_sasuke_release")),
				net.minecraft.network.chat.Component.literal("Mangekyou Sharingan (Sasuke)"))));
		STEPS.add(() -> click(mc, "10 JP"));
		STEPS.add(() -> shot(mc, "jutsu_scroll_ms"));
		STEPS.add(() -> {
			mc.gui.setScreen(null);
			NarutoShippudenMod.LOGGER.info("DEVTEST still connected {}", mc.getConnection() != null);
		});
		STEPS.add(() -> {
			NarutoShippudenMod.LOGGER.info("DEVTEST screens done");
			mc.stop();
		});
	}

	private static void screens(Minecraft mc, Screen screen) {
		if (++screenTicks < 60)
			return;
		screenTicks = 0;
		if (STEPS.isEmpty())
			buildSteps(mc);
		if (step < STEPS.size())
			STEPS.get(step++).run();
	}

	@SubscribeEvent
	public static void tick(ClientTickEvent.Post event) {
		if (!ENABLED)
			return;
		Minecraft mc = Minecraft.getInstance();
		ticks++;
		Screen screen = mc.gui.screen();
		if (ticks % 100 == 0 && screen != null) {
			StringBuilder widgets = new StringBuilder();
			for (var child : screen.children())
				if (child instanceof AbstractWidget w)
					widgets.append(" [").append(w.getMessage().getString()).append(']');
			NarutoShippudenMod.LOGGER.info("DEVTEST screen {} '{}'{}", screen.getClass().getName(), screen.getTitle().getString(), widgets);
			// the custom dimensions make the game ask about experimental settings before loading the test world
			for (var child : screen.children())
				if (!(screen instanceof net.mcreator.narutoshippudenmod.gui.ModScreen) && child instanceof net.minecraft.client.gui.components.AbstractButton b && (b.getMessage().getString().startsWith("I Know What") || b.getMessage().getString().equals("Select") || b.getMessage().getString().equals("Continue")))
					b.onPress(new net.minecraft.client.input.KeyEvent(com.mojang.blaze3d.platform.InputConstants.KEY_RETURN, 0, 0));
		}
		if (SCREENS && mc.player != null) {
			screens(mc, screen);
			return;
		}
		if (mc.player == null || screen != null)
			return;
		inWorld++;
		if (inWorld == 1) {
			NarutoShippudenMod.LOGGER.info("DEVTEST in world");
			mc.options.setCameraType(CameraType.THIRD_PERSON_FRONT);
		}
		String mode = System.getProperty("naruto.devtest.dojutsu", "byakugan");
		NarutoShippudenModVariables.PlayerVariables vars = NarutoShippudenModVariables.get(mc.player);
		if ("byakugan".equals(mode)) {
			vars.byakugan = true;
			vars.byakuganactivate = true;
			vars.dojutsubyakugan = "1x1";
		}
		if (inWorld % 100 == 0 && inWorld <= 300) {
			Screenshot.grab(mc.gameDirectory, "devtest_" + inWorld + ".png", mc.gameRenderer.mainRenderTarget(), 1,
					msg -> NarutoShippudenMod.LOGGER.info("DEVTEST {}", msg.getString()));
		}
	}
}
