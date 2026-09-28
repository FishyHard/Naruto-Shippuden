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
		if (System.getProperty("naruto.devtest.only", "").equals("jutsu")) {
			jutsuSteps(mc);
			STEPS.add(mc::stop);
			return;
		}
		if (System.getProperty("naruto.devtest.only", "").equals("models")) {
			modelSteps(mc);
			STEPS.add(mc::stop);
			return;
		}
		if (System.getProperty("naruto.devtest.only", "").equals("economy")) {
			economySteps(mc);
			STEPS.add(mc::stop);
			return;
		}
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
		// item descriptions: log a few, and show the technique, scroll, weapon and a multi-track scroll
		for (String id : new String[] { "fire_release_technique", "fire_release", "samehada", "mangekyou_sharingan_sasuke_release", "shadow_clone_technique" }) {
			net.minecraft.world.item.ItemStack stack = new net.minecraft.world.item.ItemStack(
					net.minecraft.core.registries.BuiltInRegistries.ITEM.getValue(net.minecraft.resources.Identifier.fromNamespaceAndPath("naruto_shippuden", id)));
			STEPS.add(() -> {
				NarutoShippudenMod.LOGGER.info("DEVTEST tooltip {}: {}", id, stack.getTooltipLines(net.minecraft.world.item.Item.TooltipContext.of(mc.level),
						mc.player, net.minecraft.world.item.TooltipFlag.NORMAL).stream().map(c -> c.getString()).toList());
				mc.gui.setScreen(new Screen(net.minecraft.network.chat.Component.literal("tooltip")) {
					@Override
					public void extractRenderState(net.minecraft.client.gui.GuiGraphicsExtractor graphics, int mouseX, int mouseY, float a) {
						super.extractRenderState(graphics, mouseX, mouseY, a);
						graphics.item(stack, width / 2 - 8, height / 2 - 40);
						graphics.setTooltipForNextFrame(font, stack, width / 2 - 60, height / 2 - 10);
					}
				});
			});
			STEPS.add(() -> shot(mc, "tooltip_" + id));
		}
		economySteps(mc);
		STEPS.add(() -> {
			NarutoShippudenMod.LOGGER.info("DEVTEST screens done");
			mc.stop();
		});
	}

	private static void run(net.minecraft.server.level.ServerPlayer player, String command) {
		player.level().getServer().getCommands().performPrefixedCommand(player.createCommandSourceStack().withPermission(
				net.minecraft.server.permissions.LevelBasedPermissionSet.OWNER), command);
	}

	private static void logProgress(net.minecraft.server.level.ServerPlayer player, String when) {
		var v = NarutoShippudenModVariables.get(player);
		long coins = player.level().getEntities(net.minecraft.world.entity.EntityTypes.ITEM, player.getBoundingBox().inflate(16), e -> true).stream()
				.filter(e -> e.getItem().getItem().toString().contains("ryo")).mapToInt(e -> e.getItem().getCount()).sum();
		NarutoShippudenMod.LOGGER.info("DEVTEST progress {}: level {} xp {}/{} jp {} sp {} chakraMax {} ryo on ground {}", when, v.LEVELSTAT, v.LEVEL, v.LEVELMAX,
				v.jp, v.sp, v.ChakraMax, coins);
	}

	/** Casts every remade nature jutsu at a row of training targets and screenshots each in flight and afterwards. */
	private static final int[] FREEZE_AT = { 7, 9, 12, 12 };
	private static final net.minecraft.world.phys.Vec3[] home = new net.minecraft.world.phys.Vec3[1];
	private static final net.minecraft.world.phys.Vec3[] arena = new net.minecraft.world.phys.Vec3[1];

	private static void jutsuSteps(Minecraft mc) {
		String[] natures = { "fire", "water", "wind", "earth", "lightning", "boil", "bone", "dust", "ice", "magnet", "smoke", "steel", "storm", "swift",
				"typhoon", "wood", "aburame", "akimichi", "fuma", "hozuki", "hyuga", "inuzuka", "izuno", "lee", "sarutobi", "tenro", "uzumaki",
				"tsuchigumo" };
		String only = System.getProperty("naruto.devtest.jutsu", "");
		STEPS.add(() -> {
			mc.gui.setScreen(null);
			mc.options.pauseOnLostFocus = false;
			arena[0] = mc.player.position();
			mc.options.setCameraType(CameraType.THIRD_PERSON_BACK);
			command(mc, "kill @e[type=!player]");
			command(mc, "time set day");
			command(mc, "weather clear");
			command(mc, "gamemode creative");
			command(mc, "clear @s");
			command(mc, "tp @s ~ ~ ~ 0 5");
			// a flat, open arena so the side camera sees the whole jutsu
			for (String half : new String[] { "~-24 %s ~-8 ~0 %s ~32", "~1 %s ~-8 ~24 %s ~32" }) {
				command(mc, "fill " + String.format(half, "~", "~20") + " air");
				command(mc, "fill " + String.format(half, "~-1", "~-1") + " grass_block");
				command(mc, "fill " + String.format(half, "~-4", "~-2") + " dirt");
			}
			onServer(mc, player -> NarutoShippudenModVariables.ifPresent(player, v -> {
				v.firereleaselogic = v.waterreleaselogic = v.windreleaselogic = v.earthreleaselogic = v.lightningreleaselogic = true;
				v.firelearn = v.waterlearn = v.windlearn = v.earthlearn = v.lightninglearn = 4;
				v.boilreleaselogic = v.bonereleaselogic = v.dustreleaselogic = v.icereleaselogic = v.magnetreleaselogic = v.smokereleaselogic = true;
				v.steelreleaselogic = v.stormreleaselogic = v.swiftreleaselogic = v.typhoonreleaslogic = v.woodreleaselogic = true;
				v.boillearn = v.bonelearn = v.dustlearn = v.icelearn = v.magnetlearn = v.smokelearn = v.steellearn = v.stormlearn = v.swiftlearn = 4;
				v.typhoonlearn = v.woodlearn = 4;
				v.aburamereleaselogic = v.akimichireleaselogic = v.fumareleaselogic = v.hozukireleaselogic = v.hyugareleaselogic = true;
				v.inuzukareleaselogic = v.izunoreleaselogic = v.leereleaselogic = v.sarutobireleaselogic = v.tenroreleaselogic = true;
				v.uzumakireleaselogic = v.tsuchigumoreleaselogic = true;
				v.aburamelearn = v.akimichilearn = v.fumalearn = v.hozukilearn = v.hyugalearn = v.inuzukalearn = v.izunolearn = v.leelearn = 9;
				v.sarutobilearn = v.tenrolearn = v.uzumakilearn = v.tsuchigumolearn = 9;
				v.taijutsu = v.summoning = 60;
				v.ninjutsu = 60;
				v.byakuganactivate = false;
				v.ChakraMax = 5000;
				v.ChakraAmount = 5000;
				v.syncPlayerVariables(player);
			}));
			for (int i = -2; i <= 2; i++)
				command(mc, "summon minecraft:husk ~" + i * 2 + " ~ ~16 {NoAI:1b,PersistenceRequired:1b,attributes:[{id:\"minecraft:max_health\",base:500}],Health:500f}");
		});
		for (String nature : natures) {
			if (!only.isEmpty() && !java.util.List.of(only.split(",")).contains(nature))
				continue;
			int count = net.mcreator.narutoshippudenmod.core.jutsu.Jutsus.TECHNIQUES
					.get(net.minecraft.resources.Identifier.fromNamespaceAndPath("naruto_shippuden", nature + "_release_technique")).jutsu.size();
			for (int index = 0; index < count; index++) {
				int i = index;
				int freeze = nature.equals("lightning") && i == 3 ? 19 : nature.equals("lightning") && i == 2 ? 13 : FREEZE_AT[Math.min(i, 3)];
				STEPS.add(() -> {
					command(mc, "item replace entity @s weapon.mainhand with naruto_shippuden:" + nature + "_release_technique");
					// transformations and dashes carry the player off: end them and go back to the arena
					command(mc, String.format(java.util.Locale.ROOT, "tp @s %.2f %.2f %.2f 0 5", arena[0].x, arena[0].y, arena[0].z));
					onServer(mc, player -> {
						net.mcreator.narutoshippudenmod.core.jutsu.ClanJutsu.stop(player);
						NarutoShippudenModVariables.ifPresent(player, v -> {
							v.ChakraAmount = 5000;
							v.syncPlayerVariables(player);
						});
						player.getCooldowns().removeCooldown(net.minecraft.resources.Identifier.fromNamespaceAndPath("naruto_shippuden", nature + "_release_technique/" + i));
						player.removeAllEffects();
						net.mcreator.narutoshippudenmod.core.jutsu.Jutsus.select(player,
								net.minecraft.resources.Identifier.fromNamespaceAndPath("naruto_shippuden", nature + "_release_technique"), i);
					});
					nextDelay = 5;
				});
				STEPS.add(() -> {
					home[0] = mc.player.position();
					mc.options.setCameraType(CameraType.THIRD_PERSON_BACK);
					mc.gameMode.useItem(mc.player, net.minecraft.world.InteractionHand.MAIN_HAND);
					nextDelay = freeze;
				});
				STEPS.add(() -> {
					command(mc, "tick freeze");
					// Kirin comes from the sky: look up at its dive
					command(mc, nature.equals("lightning") && i == 3 ? "execute at @s rotated ~ 0 run tp @s ^-14 ^3 ^4 facing ^ ^12 ^14"
							: "execute at @s rotated ~ 0 run tp @s ^-8 ^2.5 ^7 facing ^ ^1 ^7");
					mc.options.setCameraType(CameraType.FIRST_PERSON);
					nextDelay = 6;
				});
				STEPS.add(() -> {
					shot(mc, "jutsu_" + nature + "_" + i + "_a");
					command(mc, String.format(java.util.Locale.ROOT, "tp @s %.2f %.2f %.2f 0 5", home[0].x, home[0].y, home[0].z));
					command(mc, "tick unfreeze");
					mc.options.setCameraType(CameraType.THIRD_PERSON_BACK);
					nextDelay = 24;
				});
				STEPS.add(() -> {
					shot(mc, "jutsu_" + nature + "_" + i + "_b");
					NarutoShippudenMod.LOGGER.info("DEVTEST cast {} {}: chakra {}", nature, i, NarutoShippudenModVariables.get(mc.player).ChakraAmount);
					nextDelay = 60;
				});
			}
		}
	}

	/** Jutsu models side by side, frozen in the air in front of the camera. */
	private static void modelSteps(Minecraft mc) {
		STEPS.add(() -> {
			mc.gui.setScreen(null);
			mc.options.setCameraType(CameraType.FIRST_PERSON);
			command(mc, "kill @e[type=!player]");
			command(mc, "time set day");
			command(mc, "tp @s ~ ~ ~ 0 0");
			String[] ids = System.getProperty("naruto.devtest.models", "kirin,projectile_great_fire_dragon,projectile_great_fireball,projectile_lightning_ball,projectile_rasenshuriken")
					.split(",");
			for (int i = 0; i < ids.length; i++)
				command(mc, "summon naruto_shippuden:" + ids[i] + " ~" + (i - ids.length / 2) * 3 + " ~1.5 ~8 {NoAI:1b,NoGravity:1b,Motion:[0d,0d,0d],Rotation:[180f,0f]}");
		});
		STEPS.add(() -> shot(mc, "models"));
		STEPS.add(() -> command(mc, "tp @s ~ ~ ~ 60 0"));
		STEPS.add(() -> shot(mc, "models_side"));
	}

	/** The Shinobi Merchant's shop, and a kill made by a jutsu summon counting for the player. */
	private static void economySteps(Minecraft mc) {
		STEPS.add(() -> {
			mc.gui.setScreen(null);
			command(mc, "kill @e[type=!player]");
			command(mc, "time set day");
			command(mc, "tp @s ~ ~ ~ 0 10");
			command(mc, "summon naruto_shippuden:shinobi_merchant ~ ~ ~3 {NoAI:1b,Rotation:[180f,0f]}");
			command(mc, "give @s naruto_shippuden:gold_ryo 3");
		});
		STEPS.add(() -> shot(mc, "merchant_world"));
		STEPS.add(() -> onServer(mc, player -> player.level().getEntities(net.mcreator.narutoshippudenmod.economy.ShinobiMerchant.entity,
				player.getBoundingBox().inflate(8), e -> true).forEach(m -> m.mobInteract(player, net.minecraft.world.InteractionHand.MAIN_HAND))));
		STEPS.add(() -> shot(mc, "merchant_trades"));
		STEPS.add(() -> {
			mc.player.closeContainer();
			onServer(mc, player -> {
				logProgress(player, "before kill");
				net.mcreator.narutoshippudenmod.core.Progression.casting(player,
						() -> run(player, "summon minecraft:iron_golem ~ ~ ~-5 {Tags:[\"helper\"],NoAI:1b}"));
				run(player, "summon minecraft:zombie ~2 ~ ~-5 {Tags:[\"victim\"],NoAI:1b}");
				run(player, "damage @e[tag=victim,limit=1] 100 minecraft:mob_attack by @e[tag=helper,limit=1]");
			});
		});
		STEPS.add(() -> onServer(mc, player -> {
			logProgress(player, "after summon kill");
			net.mcreator.narutoshippudenmod.core.Progression.addXp(player, 300);
			logProgress(player, "after 300 xp");
		}));
		STEPS.add(() -> shot(mc, "level_up"));
	}

	/** Ticks before the next step (a step may shorten it, e.g. to screenshot a jutsu in flight). */
	private static int nextDelay = 60;

	private static void screens(Minecraft mc, Screen screen) {
		if (++screenTicks < nextDelay)
			return;
		screenTicks = 0;
		nextDelay = 60;
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
