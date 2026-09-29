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

	/** Wings on a sneaking player, Akamaru sitting / as the Man Beast Clone / as a fang, the eye wheel, and phasing through a wall. */
	private static void batch5Steps(Minecraft mc) {
		java.util.function.Consumer<Integer> form = f -> onServer(mc, p -> {
			for (var dog : p.level().getEntitiesOfClass(net.mcreator.narutoshippudenmod.entity.SummonEntities.AkamaruEntity.CustomEntity.class,
					p.getBoundingBox().inflate(8), d -> true))
				dog.setForm(f);
		});
		STEPS.add(() -> {
			mc.gui.setScreen(null);
			mc.options.pauseOnLostFocus = false;
			command(mc, "execute in minecraft:overworld run tp @s 0.5 220 0.5 0 10");
			command(mc, "fill -6 219 -6 6 219 12 glass");
			command(mc, "fill -6 220 -6 6 224 12 air");
			command(mc, "effect clear @s");
			command(mc, "effect give @s instant_health 1 10");
			command(mc, "time set day");
			command(mc, "gamemode survival");
			mc.options.setCameraType(CameraType.THIRD_PERSON_BACK);
			onServer(mc, p -> NarutoShippudenModVariables.ifPresent(p, v -> {
				v.ButterflyMode = true;
				v.ButterFlyModeColor = "Gold";
				v.syncPlayerVariables(p);
			}));
		});
		STEPS.add(() -> mc.options.keyShift.setDown(true));
		STEPS.add(() -> shot(mc, "b5_wings_sneak"));
		STEPS.add(() -> {
			mc.options.keyShift.setDown(false);
			onServer(mc, p -> NarutoShippudenModVariables.ifPresent(p, v -> {
				v.ButterflyMode = false;
				v.syncPlayerVariables(p);
			}));
			command(mc, "tp @s 0.5 220 0.5 -90 15");
			mc.options.setCameraType(CameraType.FIRST_PERSON);
			onServer(mc, p -> {
				var dog = new net.mcreator.narutoshippudenmod.entity.SummonEntities.AkamaruEntity.CustomEntity(
						net.mcreator.narutoshippudenmod.entity.SummonEntities.AkamaruEntity.entity, p.level());
				dog.snapTo(p.getX() + 2.5, p.getY(), p.getZ(), 0, 0);
				dog.setYBodyRot(0);
				dog.setYHeadRot(0);
				dog.setInSittingPose(true);
				dog.setNoAi(true);
				dog.tame(p);
				dog.setOrderedToSit(true);
				p.level().addFreshEntity(dog);
			});
		});
		STEPS.add(() -> shot(mc, "b5_akamaru_sit"));
		STEPS.add(() -> form.accept(1));
		STEPS.add(() -> shot(mc, "b5_akamaru_clone"));
		STEPS.add(() -> form.accept(2));
		STEPS.add(() -> shot(mc, "b5_akamaru_fang"));
		STEPS.add(() -> {
			form.accept(0);
			command(mc, "kill @e[type=naruto_shippuden:akamaru]");
			mc.gui.setScreen(new EyeKeys.EyeWheel(net.mcreator.narutoshippudenmod.core.Eyes.EYES));
		});
		STEPS.add(() -> shot(mc, "b5_eye_wheel"));
		STEPS.add(() -> {
			mc.gui.setScreen(null);
			command(mc, "tp @s 0.5 220 0.5 0 0");
			command(mc, "fill -2 220 3 2 222 4 stone");
			onServer(mc, p -> NarutoShippudenModVariables.ifPresent(p, v -> {
				v.KamuiPhantomPhase = true;
				v.syncPlayerVariables(p);
			}));
		});
		STEPS.add(() -> {
			NarutoShippudenMod.LOGGER.info("DEVTEST phasing from z={}", mc.player.getZ());
			mc.options.keyUp.setDown(true);
		});
		STEPS.add(() -> {
			mc.options.keyUp.setDown(false);
			NarutoShippudenMod.LOGGER.info("DEVTEST phasing to z={}", mc.player.getZ());
			onServer(mc, p -> NarutoShippudenModVariables.ifPresent(p, v -> {
				v.KamuiPhantomPhase = false;
				v.syncPlayerVariables(p);
			}));
			command(mc, "gamemode creative");
		});
		// thrown weapons fly as jutsu projectiles
		STEPS.add(() -> {
			command(mc, "gamemode creative");
			command(mc, "fill -6 220 -6 6 226 12 air");
			command(mc, "tp @s 0.5 220 0.5 0 -5");
			mc.options.setCameraType(CameraType.FIRST_PERSON);
		});
		STEPS.add(() -> {
			onServer(mc, p -> {
				net.minecraft.world.entity.EntityType<?>[] types = { net.mcreator.narutoshippudenmod.item.ProjectileItems.ShurikenBulletItem.arrow,
						net.mcreator.narutoshippudenmod.item.ProjectileItems.KunaiBulletItem.arrow,
						net.mcreator.narutoshippudenmod.item.ProjectileItems.FumaShurikenBulletItem.arrow,
						net.mcreator.narutoshippudenmod.item.ProjectileItems.ExplosiveKunaiBulletItem.arrow };
				for (int i = 0; i < types.length; i++) {
					var arrow = (net.mcreator.narutoshippudenmod.compat.ModArrow) types[i].create(p.level(), net.minecraft.world.entity.EntitySpawnReason.TRIGGERED);
					arrow.setOwner(p);
					arrow.setPos(p.getX() + (i - 1.5) * 0.8, p.getEyeY() - 0.2, p.getZ() + 1);
					arrow.shoot(0, 0.02, 1, 0.35F, 0);
					p.level().addFreshEntity(arrow);
				}
			});
			nextDelay = 12;
		});
		STEPS.add(() -> shot(mc, "b5_thrown"));
		// gliding with the Sharingan open and butterfly wings: eyes and wings stay on the body
		STEPS.add(() -> {
			command(mc, "gamemode survival");
			command(mc, "tp @s 0.5 260 0.5 0 20");
			command(mc, "item replace entity @s armor.chest with elytra");
			onServer(mc, p -> NarutoShippudenModVariables.ifPresent(p, v -> {
				v.sharingan = true;
				v.sharinganactivate = true;
				v.ButterflyMode = true;
				v.syncPlayerVariables(p);
			}));
			mc.options.setCameraType(CameraType.THIRD_PERSON_BACK);
		});
		STEPS.add(() -> {
			mc.player.startFallFlying();
			mc.player.connection.send(new net.minecraft.network.protocol.game.ServerboundPlayerCommandPacket(mc.player,
					net.minecraft.network.protocol.game.ServerboundPlayerCommandPacket.Action.START_FALL_FLYING));
			nextDelay = 20;
		});
		STEPS.add(() -> shot(mc, "b5_glide"));
		STEPS.add(() -> {
			command(mc, "item replace entity @s armor.chest with air");
			onServer(mc, p -> NarutoShippudenModVariables.ifPresent(p, v -> {
				v.sharinganactivate = false;
				v.ButterflyMode = false;
				v.syncPlayerVariables(p);
			}));
			command(mc, "gamemode creative");
		});
		// chakra control: walk out over water, then walk up a wall
		STEPS.add(() -> {
			command(mc, "gamemode survival");
			command(mc, "weather clear");
			command(mc, "fill -6 220 -6 6 224 12 air");
			command(mc, "fill -3 219 2 3 219 10 water");
			command(mc, "fill -3 220 11 3 226 11 stone");
			command(mc, "tp @s 0.5 220 0.5 0 0");
			onServer(mc, p -> NarutoShippudenModVariables.ifPresent(p, v -> {
				v.Chakra_Control = true;
				v.ChakraAmount = v.ChakraMax;
				v.syncPlayerVariables(p);
			}));
		});
		STEPS.add(() -> mc.options.keyUp.setDown(true));
		STEPS.add(() -> NarutoShippudenMod.LOGGER.info("DEVTEST chakra control after 3s: y={} z={}", mc.player.getY(), mc.player.getZ()));
		STEPS.add(() -> {
			NarutoShippudenMod.LOGGER.info("DEVTEST chakra control after 6s: y={} z={}", mc.player.getY(), mc.player.getZ());
			mc.options.keyUp.setDown(false);
			command(mc, "gamemode creative");
		});
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
		if (System.getProperty("naruto.devtest.only", "").equals("weapons")) {
			weaponSteps(mc);
			STEPS.add(mc::stop);
			return;
		}
		if (System.getProperty("naruto.devtest.only", "").equals("akimichi")) {
			STEPS.add(() -> {
				mc.gui.setScreen(null);
				mc.options.pauseOnLostFocus = false;
				command(mc, "execute in minecraft:overworld run spreadplayers 0 0 0 1 false @s");
				command(mc, "time set day");
				mc.options.setCameraType(CameraType.THIRD_PERSON_FRONT);
				onServer(mc, p -> NarutoShippudenModVariables.ifPresent(p, v -> {
					v.HumanBulletTank = true;
					v.syncPlayerVariables(p);
				}));
			});
			STEPS.add(() -> shot(mc, "aki_tank"));
			STEPS.add(() -> onServer(mc, p -> NarutoShippudenModVariables.ifPresent(p, v -> {
				v.HumanBulletTank = false;
				v.ButterflyMode = true;
				v.syncPlayerVariables(p);
			})));
			STEPS.add(() -> shot(mc, "aki_wings"));
			STEPS.add(() -> mc.options.setCameraType(CameraType.THIRD_PERSON_BACK));
			STEPS.add(() -> shot(mc, "aki_wings_back"));
			STEPS.add(() -> onServer(mc, p -> NarutoShippudenModVariables.ifPresent(p, v -> {
				v.ButterflyMode = false;
				v.syncPlayerVariables(p);
			})));
			STEPS.add(mc::stop);
			return;
		}
		if (System.getProperty("naruto.devtest.only", "").equals("batch5")) {
			batch5Steps(mc);
			STEPS.add(mc::stop);
			return;
		}
		if (System.getProperty("naruto.devtest.only", "").equals("eyes")) {
			eyeSteps(mc);
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

	private static String item(String nature) {
		return nature.endsWith("technique") ? nature : nature + "_release_technique";
	}

	private static void jutsuSteps(Minecraft mc) {
		String[] natures = { "fire", "water", "wind", "earth", "lightning", "boil", "bone", "dust", "ice", "magnet", "smoke", "steel", "storm", "swift",
				"typhoon", "wood", "aburame", "akimichi", "fuma", "hozuki", "hyuga", "inuzuka", "lee", "sarutobi", "uzumaki",
				"tsuchigumo", "sharingan", "isshiki_dojutsu", "mangekyou_sharingan_itachi_release_technique",
				"mangekyou_sharingan_kakashi_release_technique", "mangekyou_sharingan_obito_release_technique", "mangekyou_sharingan_sasuke_release_technique" };
		String only = System.getProperty("naruto.devtest.jutsu", "");
		STEPS.add(() -> {
			mc.gui.setScreen(null);
			mc.options.pauseOnLostFocus = false;
			// back to the overworld surface (a Kamui test may have left the player in its dimension)
			command(mc, "execute in minecraft:overworld run spreadplayers 0 0 0 1 false @s");
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
				v.inuzukareleaselogic = v.leereleaselogic = v.sarutobireleaselogic = true;
				v.uzumakireleaselogic = v.tsuchigumoreleaselogic = true;
				v.aburamelearn = v.akimichilearn = v.fumalearn = v.hozukilearn = v.hyugalearn = v.inuzukalearn = v.leelearn = 9;
				v.sarutobilearn = v.uzumakilearn = v.tsuchigumolearn = 9;
				v.taijutsu = v.summoning = 60;
				v.sharingan = v.sharinganactivate = v.isshikidojutsu = v.isshikidojutsuactivate = v.MangekyouSharinganActivate = true;
				v.sharinganlearn = v.isshikidojutsulearn = v.mangekyoushrainganitachiamaterasulearn = 9;
				v.mangekyousharingankakashikamuilearn = v.mangekyousharinganobitokamuilearn = v.mangekyousharingansasukeamaterasulearn = 9;
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
					.get(net.minecraft.resources.Identifier.fromNamespaceAndPath("naruto_shippuden", item(nature))).jutsu.size();
			for (int index = 0; index < count; index++) {
				int i = index;
				int freeze = nature.equals("lightning") && i == 3 ? 19 : nature.equals("lightning") && i == 2 ? 13 : FREEZE_AT[Math.min(i, 3)];
				STEPS.add(() -> {
					command(mc, "item replace entity @s weapon.mainhand with naruto_shippuden:" + item(nature));
					if (arena[0] == null)
						arena[0] = mc.player.position();
					// transformations and dashes carry the player off: end them and go back to the arena
					command(mc, String.format(java.util.Locale.ROOT, "tp @s %.2f %.2f %.2f 0 5", arena[0].x, arena[0].y, arena[0].z));
					onServer(mc, player -> {
						net.mcreator.narutoshippudenmod.core.jutsu.ClanJutsu.stop(player);
						NarutoShippudenModVariables.ifPresent(player, v -> {
							v.ChakraAmount = 5000;
							v.syncPlayerVariables(player);
						});
						player.getCooldowns().removeCooldown(net.minecraft.resources.Identifier.fromNamespaceAndPath("naruto_shippuden", item(nature) + "/" + i));
						player.removeAllEffects();
						net.mcreator.narutoshippudenmod.core.jutsu.Jutsus.select(player,
								net.minecraft.resources.Identifier.fromNamespaceAndPath("naruto_shippuden", item(nature)), i);
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
					// jutsu that land on the target: frame the training targets instead of the caster
					boolean onTarget = nature.startsWith("isshiki") || nature.startsWith("mangekyou");
					boolean onCaster = nature.equals("akimichi");
					command(mc, nature.equals("lightning") && i == 3 ? "execute at @s rotated ~ 0 run tp @s ^-14 ^3 ^4 facing ^ ^12 ^14"
							: onCaster ? "execute at @s rotated ~ 0 run tp @s ^-3 ^2 ^-4 facing ^ ^1.2 ^" : onTarget ? "execute at @s rotated ~ 0 run tp @s ^-11 ^4 ^12 facing ^ ^1.5 ^16" : "execute at @s rotated ~ 0 run tp @s ^-8 ^2.5 ^7 facing ^ ^1 ^7");
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

	/** The Dojutsu key (open, step up to the Mangekyou, the wheel, close all) and the Susanoo growing stage by stage. */
	private static void eyeSteps(Minecraft mc) {
		STEPS.add(() -> {
			mc.gui.setScreen(null);
			mc.options.pauseOnLostFocus = false;
			mc.options.setCameraType(CameraType.THIRD_PERSON_FRONT);
			command(mc, "execute in minecraft:overworld run tp @s 0 ~ 0");
			command(mc, "time set day");
			onServer(mc, player -> NarutoShippudenModVariables.ifPresent(player, v -> {
				v.sharingan = v.MangekyouSharinganItachi = v.byakugan = true;
				v.sharinganactivate = v.MangekyouSharinganActivate = v.byakuganactivate = false;
				v.mangekyousharingansusanostage = 0;
				v.mangekyoushrainganitachisusanolearn = 3;
				v.ChakraMax = v.ChakraAmount = 5000;
				v.syncPlayerVariables(player);
			}));
		});
		java.util.function.Consumer<java.util.function.Consumer<net.minecraft.server.level.ServerPlayer>> server = task -> onServer(mc, task);
		String[] log = { "" };
		java.util.function.Consumer<String> state = label -> NarutoShippudenMod.LOGGER.info("DEVTEST eyes {}: sharingan {} mangekyou {} byakugan {} susanoo {}", label,
				NarutoShippudenModVariables.get(mc.player).sharinganactivate, NarutoShippudenModVariables.get(mc.player).MangekyouSharinganActivate,
				NarutoShippudenModVariables.get(mc.player).byakuganactivate, NarutoShippudenModVariables.get(mc.player).mangekyousharingansusanostage);
		STEPS.add(() -> server.accept(p -> net.mcreator.narutoshippudenmod.core.Eyes.select(p, "sharingan")));
		STEPS.add(() -> { state.accept("select sharingan"); shot(mc, "eyes_sharingan"); });
		STEPS.add(() -> server.accept(p -> net.mcreator.narutoshippudenmod.core.Eyes.tap(p, false)));
		STEPS.add(() -> { state.accept("tap again"); shot(mc, "eyes_mangekyou"); });
		for (int i = 0; i < 3; i++)
			STEPS.add(() -> server.accept(net.mcreator.narutoshippudenmod.core.Eyes::growSusanoo));
		STEPS.add(() -> { state.accept("susanoo x3"); shot(mc, "eyes_susanoo"); });
		STEPS.add(() -> mc.gui.setScreen(new EyeKeys.EyeWheel(net.mcreator.narutoshippudenmod.core.Eyes.owned(NarutoShippudenModVariables.get(mc.player)))));
		STEPS.add(() -> shot(mc, "eyes_wheel"));
		STEPS.add(() -> { mc.gui.setScreen(null); server.accept(p -> net.mcreator.narutoshippudenmod.core.Eyes.select(p, "byakugan")); });
		STEPS.add(() -> { state.accept("select byakugan"); shot(mc, "eyes_byakugan"); });
		STEPS.add(() -> server.accept(p -> net.mcreator.narutoshippudenmod.core.Eyes.tap(p, true)));
		STEPS.add(() -> { state.accept("sneak tap"); NarutoShippudenMod.LOGGER.info("DEVTEST eyes key category {}", EyeKeys.DOJUTSU.getCategory().label().getString()); });
	}

	/** The thrown weapons in a row in front of the camera, held still, from the front and the side. */
	private static void weaponSteps(Minecraft mc) {
		STEPS.add(() -> {
			mc.gui.setScreen(null);
			mc.options.pauseOnLostFocus = false;
			mc.options.setCameraType(CameraType.FIRST_PERSON);
			command(mc, "execute in minecraft:overworld run spreadplayers 0 0 0 1 false @s");
			command(mc, "time set day");
			command(mc, "kill @e[type=!player]");
			command(mc, "fill ~-12 ~ ~-4 ~12 ~12 ~16 air");
			command(mc, "tp @s ~ ~ ~ 0 10");
		});
		STEPS.add(() -> {
			command(mc, "tick freeze");
			onServer(mc, player -> {
				net.minecraft.world.entity.EntityType<?>[] types = { net.mcreator.narutoshippudenmod.item.ProjectileItems.ShurikenBulletItem.arrow,
						net.mcreator.narutoshippudenmod.item.ProjectileItems.KunaiBulletItem.arrow,
						net.mcreator.narutoshippudenmod.item.ProjectileItems.PoisonKunaiBulletItem.arrow,
						net.mcreator.narutoshippudenmod.item.ProjectileItems.ExplosiveKunaiBulletItem.arrow,
						net.mcreator.narutoshippudenmod.item.ProjectileItems.FlyingThunderGodKunaiBulletItem.arrow,
						net.mcreator.narutoshippudenmod.item.ProjectileItems.FumaShurikenBulletItem.arrow };
				for (int i = 0; i < types.length; i++) {
					net.minecraft.world.entity.Entity e = types[i].create(player.level(), net.minecraft.world.entity.EntitySpawnReason.COMMAND);
					e.snapTo(player.getX() + (i - 2.5) * 0.9, player.getEyeY() - 0.4, player.getZ() + 3, 90, 0);
					e.setNoGravity(true);
					player.level().addFreshEntity(e);
				}
			});
			nextDelay = 10;
		});
		STEPS.add(() -> shot(mc, "weapons"));
		STEPS.add(() -> {
			command(mc, "execute at @s run tp @s ~3 ~ ~3 90 10");
			nextDelay = 10;
		});
		STEPS.add(() -> shot(mc, "weapons_side"));
		STEPS.add(() -> command(mc, "tick unfreeze"));
	}

	/** Jutsu models side by side, frozen in the air in front of the camera. */
	private static void modelSteps(Minecraft mc) {
		STEPS.add(() -> {
			mc.gui.setScreen(null);
			mc.options.setCameraType(CameraType.FIRST_PERSON);
			command(mc, "execute in minecraft:overworld run spreadplayers 0 0 0 1 false @s");
			command(mc, "kill @e[type=!player]");
			command(mc, "time set day");
			command(mc, "tp @s ~ ~ ~ 0 0");
			command(mc, "fill ~-12 ~ ~-4 ~12 ~12 ~16 air");
			String[] ids = System.getProperty("naruto.devtest.models", "kirin,projectile_great_fire_dragon,projectile_great_fireball,projectile_lightning_ball,projectile_rasenshuriken")
					.split(",");
			for (int i = 0; i < ids.length; i++)
				command(mc, "summon naruto_shippuden:" + ids[i] + " ~" + (i - ids.length / 2) * 3 + " ~1.5 ~8 {NoAI:1b,NoGravity:1b,Motion:[0d,0d,0d],Rotation:[180f,0f]}");
			// thrown weapons vanish once they stop: hold everything still
			command(mc, "tick freeze");
		});
		STEPS.add(() -> shot(mc, "models"));
		STEPS.add(() -> command(mc, "tp @s ~ ~ ~ 60 0"));
		STEPS.add(() -> shot(mc, "models_side"));
		STEPS.add(() -> command(mc, "tick unfreeze"));
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
