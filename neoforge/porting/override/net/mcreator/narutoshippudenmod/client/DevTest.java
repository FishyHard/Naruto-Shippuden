package net.mcreator.narutoshippudenmod.client;

import net.mcreator.narutoshippudenmod.NarutoShippudenMod;
import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables;
import net.mcreator.narutoshippudenmod.core.NarutoActions;
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
			"CheatGuis$PasswordGUIDojutsuGui", "MiscGuis$GeninHeadbandSelectGui", "MiscGuis$PatreonKitGui",
			"JutsuCreationGuis$CreateJutsuGUIGui"};
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
				dog.snapTo(p.getX() + 1.6, p.getY(), p.getZ(), 0, 0);
				dog.setYBodyRot(0);
				// looking round at the camera, where the neck used to come apart
				dog.setYHeadRot(-45);
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
		// batch 6: the resting Byakugan gives way to an open Tenseigan, the message panel, shadow clones, Flying Raijin, the Inuzuka wheel
		STEPS.add(() -> {
			command(mc, "gamemode creative");
			command(mc, "fill -6 220 -6 6 226 12 air");
			command(mc, "tp @s 0.5 220 0.5 0 0");
			mc.options.setCameraType(CameraType.THIRD_PERSON_FRONT);
			onServer(mc, p -> NarutoShippudenModVariables.ifPresent(p, v -> {
				v.byakugan = true;
				v.byakuganactivate = false;
				v.tenseigan = true;
				v.tenseiganactivate = true;
				v.syncPlayerVariables(p);
			}));
		});
		STEPS.add(() -> shot(mc, "b6_tenseigan"));
		STEPS.add(() -> {
			onServer(mc, p -> {
				NarutoShippudenModVariables.ifPresent(p, v -> {
					v.tenseiganactivate = false;
					v.ninjutsu = 100;
					v.ChakraAmount = v.ChakraMax;
					v.syncPlayerVariables(p);
				});
				p.setItemInHand(net.minecraft.world.InteractionHand.MAIN_HAND,
						new net.minecraft.world.item.ItemStack(net.mcreator.narutoshippudenmod.item.WeaponItems.FlyingThunderGodKunaiItem.block));
				net.mcreator.narutoshippudenmod.core.jutsu.ShadowClones.cast(p);
			});
			mc.options.setCameraType(CameraType.THIRD_PERSON_BACK);
			nextDelay = 20;
		});
		STEPS.add(() -> shot(mc, "b6_clones_toast"));
		STEPS.add(() -> onServer(mc, p -> {
			p.setItemInHand(net.minecraft.world.InteractionHand.MAIN_HAND,
					new net.minecraft.world.item.ItemStack(net.mcreator.narutoshippudenmod.item.TechniqueItems.ShadowCloneTechniqueItem.block));
			p.setShiftKeyDown(true);
			net.mcreator.narutoshippudenmod.core.jutsu.Jutsus.cast(p, net.minecraft.world.InteractionHand.MAIN_HAND);
			p.setShiftKeyDown(false);
			NarutoShippudenMod.LOGGER.info("DEVTEST clones after release: {}", net.mcreator.narutoshippudenmod.core.jutsu.ShadowClones.clonesOf(p).size());
		}));
		STEPS.add(() -> {
			command(mc, "kill @e[type=naruto_shippuden:shadow_clone]");
			onServer(mc, p -> raijin(p, 1));
			command(mc, "tp @s 0.5 220 8.5 180 20");
		});
		STEPS.add(() -> {
			NarutoShippudenMod.LOGGER.info("DEVTEST raijin before z={}", mc.player.getZ());
			onServer(mc, p -> raijin(p, 3));
		});
		STEPS.add(() -> NarutoShippudenMod.LOGGER.info("DEVTEST raijin after z={}", mc.player.getZ()));
		STEPS.add(() -> mc.gui.setScreen(new JutsuClient.WheelScreen(net.mcreator.narutoshippudenmod.core.jutsu.Jutsus.TECHNIQUES
				.get(net.minecraft.resources.Identifier.fromNamespaceAndPath("naruto_shippuden", "inuzuka_release_technique")))));
		STEPS.add(() -> shot(mc, "b6_inuzuka_wheel"));
		STEPS.add(() -> mc.gui.setScreen(new JutsuClient.WheelScreen(net.mcreator.narutoshippudenmod.core.jutsu.Jutsus.TECHNIQUES
				.get(net.minecraft.resources.Identifier.fromNamespaceAndPath("naruto_shippuden", "flying_thunder_god_kunai")))));
		STEPS.add(() -> shot(mc, "b6_raijin_wheel"));
		STEPS.add(() -> {
			mc.gui.setScreen(null);
			onServer(mc, p -> p.sendOverlayMessage(net.minecraft.network.chat.Component.literal("Byakugan activated")));
			nextDelay = 10;
		});
		STEPS.add(() -> shot(mc, "b6_toast_byakugan"));
		STEPS.add(() -> mc.gui.setScreen(null));
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

	/** Casts a Flying Raijin option from the kunai's wheel, the way a right-click does. */
	private static void raijin(net.minecraft.server.level.ServerPlayer p, int option) {
		p.setItemInHand(net.minecraft.world.InteractionHand.MAIN_HAND,
				new net.minecraft.world.item.ItemStack(net.mcreator.narutoshippudenmod.item.WeaponItems.FlyingThunderGodKunaiItem.block));
		NarutoShippudenModVariables.ifPresent(p, v -> {
			v.flyingthundergodkunaiteleportselect = option;
			v.shurikenjutsu = Math.max(v.shurikenjutsu, 40);
		});
		p.getCooldowns().removeCooldown(net.minecraft.resources.Identifier.fromNamespaceAndPath("naruto_shippuden", "flying_thunder_god_kunai/" + option));
		net.mcreator.narutoshippudenmod.core.jutsu.Jutsus.cast(p, net.minecraft.world.InteractionHand.MAIN_HAND);
	}

	/** Against a dedicated server (not singleplayer). */
	private static boolean multiplayer(Minecraft mc) {
		return mc.getSingleplayerServer() == null;
	}

	/** In multiplayer, tells the watcher client (if one joined) to save a screenshot too. */
	private static void signal(Minecraft mc, String name) {
		if (multiplayer(mc))
			command(mc, "narutodev shot " + name);
	}

	/** The watcher (-Dnaruto.devtest.only=watch): the screenshot the server asked for, taken on the next tick. */
	private static @org.jspecify.annotations.Nullable String watchShot;

	@SubscribeEvent
	public static void onWatchSignal(net.neoforged.neoforge.client.event.ClientChatReceivedEvent.System event) {
		String text = event.getMessage().getString();
		if (!ENABLED || !System.getProperty("naruto.devtest.only", "").equals("watch") || !text.startsWith("DEVSHOT "))
			return;
		event.setCanceled(true);
		watchShot = text.substring(8);
	}

	/**
	 * Runs server code for a test step: directly on the singleplayer server, or on a dedicated server through /narutodev (which runs
	 * the same code, core/DevServer).
	 */
	private static void server(Minecraft mc, String devCommand, java.util.function.Consumer<net.minecraft.server.level.ServerPlayer> task) {
		if (mc.getSingleplayerServer() != null)
			onServer(mc, task);
		else
			command(mc, "narutodev " + devCommand);
	}

	private static void onServer(Minecraft mc, java.util.function.Consumer<net.minecraft.server.level.ServerPlayer> task) {
		var server = mc.getSingleplayerServer();
		server.execute(() -> task.accept(server.getPlayerList().getPlayer(mc.player.getUUID())));
	}

	private static void command(Minecraft mc, String command) {
		// against a dedicated server: as the player (an operator there)
		if (mc.getSingleplayerServer() == null) {
			mc.player.connection.sendCommand(command);
			return;
		}
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
		if (System.getProperty("naruto.devtest.only", "").equals("mpsusanoo")) {
			// against the dedicated server, with the watcher: the eyes and each Susanoo stage, seen by both players
			STEPS.add(() -> {
				mc.gui.setScreen(null);
				mc.options.pauseOnLostFocus = false;
				if (mc.getConnection().getOnlinePlayers().size() < 2 && ticks < 2400) {
					step--;
					nextDelay = 20;
					return;
				}
				command(mc, "gamemode creative");
				command(mc, "tp @s 0 -60 0 0 0");
				command(mc, "narutodev watch");
			});
			for (int stage = 0; stage <= 3; stage++) {
				int s = stage;
				STEPS.add(() -> {
					command(mc, "narutodev susanoo " + s);
					nextDelay = 40;
				});
				STEPS.add(() -> {
					mc.options.setCameraType(CameraType.THIRD_PERSON_FRONT);
					nextDelay = 10;
				});
				STEPS.add(() -> {
					shot(mc, "mp_susanoo_" + s);
					signal(mc, "mp_susanoo_" + s);
					NarutoShippudenMod.LOGGER.info("DEVTEST susanoo stage {} here: {}", s, NarutoShippudenModVariables.get(mc.player).mangekyousharingansusanostage);
				});
			}
			STEPS.add(() -> signal(mc, "done"));
			STEPS.add(mc::stop);
			return;
		}
		if (System.getProperty("naruto.devtest.only", "").equals("watch")) {
			// a second player: screenshots when the caster's test says so (DEVSHOT in chat), stops on "done"
			STEPS.add(() -> {
				mc.gui.setScreen(null);
				mc.options.pauseOnLostFocus = false;
				NarutoShippudenMod.LOGGER.info("DEVTEST watching as {}", mc.player.getName().getString());
			});
			return;
		}
		if (System.getProperty("naruto.devtest.only", "").equals("jutsu")) {
			jutsuSteps(mc);
			STEPS.add(() -> signal(mc, "done"));
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
		if (System.getProperty("naruto.devtest.only", "").equals("shinobi")) {
			shinobiSteps(mc);
			STEPS.add(mc::stop);
			return;
		}
		if (System.getProperty("naruto.devtest.only", "").equals("kurama")) {
			kuramaSteps(mc);
			STEPS.add(mc::stop);
			return;
		}
		if (System.getProperty("naruto.devtest.only", "").equals("stats")) {
			// capped upgrading: 292 Medicine with 10 SP per click goes to 300 and keeps 2 SP; then the info card
			STEPS.add(() -> {
				setupFight(mc);
				onServer(mc, player -> NarutoShippudenModVariables.ifPresent(player, v -> {
					v.medicine = 292;
					v.speed = 10;
					v.sp = 10;
					v.spusecount = 10;
					v.syncPlayerVariables(player);
				}));
				nextDelay = 20;
			});
			STEPS.add(() -> {
				onServer(mc, player -> {
					net.mcreator.narutoshippudenmod.core.Stats.upgrade(player, "Medicine");
					net.mcreator.narutoshippudenmod.core.Stats.upgrade(player, "Speed");
				});
				nextDelay = 20;
			});
			STEPS.add(() -> {
				onServer(mc, player -> NarutoShippudenMod.LOGGER.info("DEVTEST stats: medicine {} sp {} max health {} speed {}",
						NarutoShippudenModVariables.get(player).medicine, NarutoShippudenModVariables.get(player).sp, player.getMaxHealth(),
						player.getAttributeValue(net.minecraft.world.entity.ai.attributes.Attributes.MOVEMENT_SPEED)));
				open(mc, "InfoCardGuis$InfoCardUpgradeGui");
				nextDelay = 20;
			});
			STEPS.add(() -> {
				shot(mc, "stats_page");
				open(mc, "InfoCardGuis$InfoCardGui");
				nextDelay = 20;
			});
			STEPS.add(() -> {
				shot(mc, "stats_card");
				mc.player.closeContainer();
				nextDelay = 5;
			});
			STEPS.add(mc::stop);
			return;
		}
		if (System.getProperty("naruto.devtest.only", "").equals("customscreen")) {
			customScreenSteps(mc);
			STEPS.add(mc::stop);
			return;
		}
		if (System.getProperty("naruto.devtest.only", "").equals("tabs")) {
			// each of the mod's creative tabs, opened in the creative inventory
			STEPS.add(() -> command(mc, "gamemode creative"));
			for (String tab : new String[] { "nature_releases", "kekkei_genkai", "dna", "clans", "dojutsu", "weapons", "headbands", "shinobi_items" }) {
				STEPS.add(() -> {
					net.minecraft.world.item.CreativeModeTab creative = net.minecraft.core.registries.BuiltInRegistries.CREATIVE_MODE_TAB
							.getValue(net.minecraft.resources.Identifier.fromNamespaceAndPath("naruto_shippuden", tab));
					var screen = new net.minecraft.client.gui.screens.inventory.CreativeModeInventoryScreen(mc.player, mc.level.enabledFeatures(), false);
					mc.gui.setScreen(screen);
					try {
						var select = screen.getClass().getDeclaredMethod("selectTab", net.minecraft.world.item.CreativeModeTab.class);
						select.setAccessible(true);
						select.invoke(screen, creative);
					} catch (ReflectiveOperationException e) {
						throw new RuntimeException(e);
					}
					NarutoShippudenMod.LOGGER.info("DEVTEST tab {}: {} items", tab, creative.getDisplayItems().size());
					nextDelay = 10;
				});
				STEPS.add(() -> shot(mc, "tab_" + tab));
			}
			STEPS.add(mc::stop);
			return;
		}
		if (System.getProperty("naruto.devtest.only", "").equals("perf")) {
			// stand still for 20 s (two DEVTEST tick lines), then with Chakra Control, the Sharingan and a clan
			STEPS.add(() -> {
				mc.gui.setScreen(null);
				mc.options.pauseOnLostFocus = false;
				command(mc, "execute in minecraft:overworld run spreadplayers 0 0 0 1 false @s");
				nextDelay = 420;
			});
			STEPS.add(() -> {
				NarutoShippudenMod.LOGGER.info("DEVTEST perf: now with chakra control, sharingan, uchiha");
				onServer(mc, player -> NarutoShippudenModVariables.ifPresent(player, v -> {
					v.Chakra_Control = true;
					v.sharingan = v.sharinganactivate = v.uchihareleaselogic = true;
					v.syncPlayerVariables(player);
				}));
				nextDelay = 420;
			});
			STEPS.add(mc::stop);
			return;
		}
		if (System.getProperty("naruto.devtest.only", "").equals("headband")) {
			STEPS.add(() -> {
				mc.gui.setScreen(null);
				mc.options.pauseOnLostFocus = false;
				command(mc, "time set day");
				command(mc, "execute in minecraft:overworld run spreadplayers 0 0 0 1 false @s");
				command(mc, "item replace entity @s armor.head with naruto_shippuden:genin_konohagakure_helmet");
				command(mc, "tp @s ~ ~ ~ 0 0");
				mc.options.setCameraType(CameraType.THIRD_PERSON_BACK);
			});
			STEPS.add(() -> shot(mc, "headband_back"));
			STEPS.add(() -> command(mc, "tp @s ~ ~ ~ 90 0"));
			STEPS.add(() -> shot(mc, "headband_side"));
			STEPS.add(() -> {
				command(mc, "tp @s ~ ~ ~ 0 0");
				mc.options.setCameraType(CameraType.THIRD_PERSON_FRONT);
			});
			STEPS.add(() -> shot(mc, "headband_front"));
			STEPS.add(() -> {
				mc.options.setCameraType(CameraType.FIRST_PERSON);
				command(mc, "give @s naruto_shippuden:ice_dna_release");
				for (String id : new String[] { "ice_dna_release", "fire_dna_release", "undefined_dna" }) {
					net.minecraft.world.item.ItemStack stack = new net.minecraft.world.item.ItemStack(
							net.minecraft.core.registries.BuiltInRegistries.ITEM.getValue(net.minecraft.resources.Identifier.fromNamespaceAndPath("naruto_shippuden", id)));
					NarutoShippudenMod.LOGGER.info("DEVTEST dna tooltip {}: {}", id, stack.getTooltipLines(net.minecraft.world.item.Item.TooltipContext.of(mc.level), mc.player,
							net.minecraft.world.item.TooltipFlag.NORMAL).stream().map(c -> c.getString()).toList());
				}
			});
			STEPS.add(mc::stop);
			return;
		}
		if (System.getProperty("naruto.devtest.only", "").equals("dna")) {
			dnaSteps(mc);
			STEPS.add(mc::stop);
			return;
		}
		if (System.getProperty("naruto.devtest.only", "").equals("learned")) {
			learnedSteps(mc);
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
		return nature.endsWith("technique") || net.mcreator.narutoshippudenmod.core.jutsu.Weapons.KENJUTSU.containsKey(nature) ? nature
				: nature + "_release_technique";
	}

	private static boolean weapon(String nature) {
		return net.mcreator.narutoshippudenmod.core.jutsu.Weapons.KENJUTSU.containsKey(nature);
	}


	private static void jutsuSteps(Minecraft mc) {
		String[] natures = { "fire", "water", "wind", "earth", "lightning", "boil", "bone", "dust", "ice", "magnet", "smoke", "steel", "storm", "swift",
				"typhoon", "wood", "aburame", "akimichi", "fuma", "hozuki", "hyuga", "inuzuka", "lee", "nara", "sarutobi", "uzumaki",
				"tsuchigumo", "uchiha", "yamanaka", "sharingan", "byakugan", "ketsuryugan", "rinnegan", "tenseigan", "isshiki_dojutsu", "mangekyou_sharingan_itachi_release_technique",
				"mangekyou_sharingan_kakashi_release_technique", "mangekyou_sharingan_obito_release_technique", "mangekyou_sharingan_sasuke_release_technique",
				"mangekyou_sharingan_shisui_release_technique", "mangekyou_sharingan_madara_release_technique", "white_light_chakra_sabre", "chakra_blade",
				"kusanagi_sasuke", "gunbai", "triple_blade_scythe", "shichiseiken", "samehada", "kubikiribocho", "hiramekarei", "kabutowari", "kiba_sword",
				"nuibari", "shibuki" };
		String only = System.getProperty("naruto.devtest.jutsu", "");
		if (multiplayer(mc) && Boolean.getBoolean("naruto.devtest.watcher"))
			// wait (up to two minutes) for the watcher to join
			STEPS.add(() -> {
				mc.gui.setScreen(null);
				if (mc.getConnection().getOnlinePlayers().size() < 2 && ticks < 2400) {
					step--;
					nextDelay = 20;
				} else
					NarutoShippudenMod.LOGGER.info("DEVTEST players online: {}", mc.getConnection().getOnlinePlayers().size());
			});
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
			server(mc, "setup", net.mcreator.narutoshippudenmod.core.DevServer::setup);
			for (int i = -2; i <= 2; i++)
				command(mc, "summon minecraft:husk ~" + i * 2 + " ~ ~16 {NoAI:1b,PersistenceRequired:1b,attributes:[{id:\"minecraft:max_health\",base:500}],Health:500f}");
			if (multiplayer(mc))
				command(mc, "narutodev watch");
		});
		for (String nature : natures) {
			if (!only.isEmpty() && !java.util.List.of(only.split(",")).contains(nature))
				continue;
			NarutoShippudenModVariables.PlayerVariables withCustom = new NarutoShippudenModVariables.PlayerVariables();
			withCustom.custom_jutsu = net.mcreator.narutoshippudenmod.core.DevServer.TEST_CUSTOM;
			int count = net.mcreator.narutoshippudenmod.core.jutsu.Jutsus.TECHNIQUES
					.get(net.minecraft.resources.Identifier.fromNamespaceAndPath("naruto_shippuden", item(nature))).jutsu(withCustom).size();
			for (int index = 0; index < count; index++) {
				int i = index;
				int freeze = nature.equals("lightning") && i == 3 ? 19 : nature.equals("lightning") && i == 2 ? 13 : FREEZE_AT[Math.min(i, 3)];
				STEPS.add(() -> {
					command(mc, "item replace entity @s weapon.mainhand with naruto_shippuden:" + item(nature));
					if (arena[0] == null)
						arena[0] = mc.player.position();
					// transformations and dashes carry the player off: end them and go back to the arena (weapons: closer, most arts are short)
					command(mc, String.format(java.util.Locale.ROOT, "tp @s %.2f %.2f %.2f 0 5", arena[0].x, arena[0].y, arena[0].z + (weapon(nature) ? 9 : 0)));
					server(mc, "prepare " + nature + " " + i, player -> net.mcreator.narutoshippudenmod.core.DevServer.prepare(player, nature, i));
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
					signal(mc, "jutsu_" + nature + "_" + i + "_a");
					command(mc, String.format(java.util.Locale.ROOT, "tp @s %.2f %.2f %.2f 0 5", home[0].x, home[0].y, home[0].z));
					command(mc, "tick unfreeze");
					mc.options.setCameraType(CameraType.THIRD_PERSON_BACK);
					nextDelay = 24;
				});
				STEPS.add(() -> {
					shot(mc, "jutsu_" + nature + "_" + i + "_b");
					signal(mc, "jutsu_" + nature + "_" + i + "_b");
					NarutoShippudenMod.LOGGER.info("DEVTEST cast {} {}: chakra {}", nature, i, NarutoShippudenModVariables.get(mc.player).ChakraAmount);
					nextDelay = 60;
				});
				if (nature.equals("magnet") && (i == 0 || i == 4))
					// the iron sand from the front: the open hood, the hands' palms, the wings
					{
						STEPS.add(() -> {
							mc.options.setCameraType(CameraType.THIRD_PERSON_FRONT);
							nextDelay = 4;
						});
						STEPS.add(() -> {
							shot(mc, "jutsu_magnet_" + i + "_front");
							nextDelay = 4;
						});
						STEPS.add(() -> {
							mc.options.setCameraType(CameraType.THIRD_PERSON_BACK);
							nextDelay = 2;
						});
					}
				if (nature.equals("nara") && i == 1)
					// Shadow Imitation: the caught husk copies the caster's steps
					for (int step = 0; step <= 6; step++) {
						int n = step;
						STEPS.add(() -> {
							server(mc, "mimic " + n, player -> net.mcreator.narutoshippudenmod.core.DevServer.mimic(player, n));
							if (n < 6)
								command(mc, "tp @s ~0.5 ~ ~");
							if (n == 6)
								shot(mc, "jutsu_nara_mimic");
							nextDelay = 3;
						});
					}
			}
		}
	}

	/** Clears a flat open arena around the player: w wide, from z0 to z1 ahead. */
	private static void arena(Minecraft mc, int w, int z0, int z1) {
		for (int z = z0; z < z1; z += 8)
			for (int x = -w; x < w; x += 16) {
				String box = "~" + x + " %s ~" + z + " ~" + (x + 15) + " %s ~" + Math.min(z1, z + 7);
				command(mc, "fill " + String.format(box, "~", "~24") + " air");
				command(mc, "fill " + String.format(box, "~-1", "~-1") + " grass_block");
				command(mc, "fill " + String.format(box, "~-3", "~-2") + " dirt");
			}
	}

	private static void setupFight(Minecraft mc) {
		mc.gui.setScreen(null);
		mc.options.pauseOnLostFocus = false;
		command(mc, "execute in minecraft:overworld run spreadplayers 0 0 0 1 false @s");
		command(mc, "kill @e[type=!player]");
		command(mc, "time set day");
		command(mc, "weather clear");
		command(mc, "gamemode creative");
		command(mc, "clear @s");
		command(mc, "tp @s ~ ~ ~ 0 5");
	}

	/** A Jonin of each village against a training husk: footwork, kunai, signs and jutsu, then a blow it answers with Substitution. */
	private static void shinobiSteps(Minecraft mc) {
		STEPS.add(() -> {
			setupFight(mc);
			arena(mc, 24, -8, 40);
			nextDelay = 40;
		});
		for (String village : new String[] { "leaf", "mist", "sand", "stone", "cloud" }) {
			STEPS.add(() -> {
				command(mc, "kill @e[type=!player]");
				command(mc, "summon minecraft:husk ~ ~ ~20 {NoAI:1b,PersistenceRequired:1b,attributes:[{id:\"minecraft:max_health\",base:1000}],Health:1000f}");
				command(mc, "summon naruto_shippuden:hidden_" + village + "_shinobi ~ ~ ~8");
				nextDelay = 5;
			});
			STEPS.add(() -> {
				onServer(mc, player -> {
					var level = player.level();
					var box = player.getBoundingBox().inflate(40);
					var shinobi = level.getEntitiesOfClass(net.minecraft.world.entity.PathfinderMob.class, box,
							e -> e.getPersistentData().contains("ShinobiRank")).stream().findFirst().orElse(null);
					var husk = level.getEntitiesOfClass(net.minecraft.world.entity.monster.zombie.Husk.class, box).stream().findFirst().orElse(null);
					if (shinobi != null && husk != null) {
						net.mcreator.narutoshippudenmod.core.jutsu.ShinobiAI.spawned(shinobi, 2);
						shinobi.setTarget(husk);
					}
					NarutoShippudenMod.LOGGER.info("DEVTEST shinobi {}: {} vs {}", village, shinobi == null ? "none" : shinobi.getName().getString(), husk);
				});
				command(mc, "tp @s ~-13 ~4 ~13 facing ~ ~1 ~13");
				nextDelay = 10;
			});
			for (int shot = 0; shot < 14; shot++) {
				int n = shot;
				STEPS.add(() -> {
					shot(mc, "shinobi_" + village + "_" + n);
					onServer(mc, player -> {
						var box = player.getBoundingBox().inflate(40);
						player.level().getEntitiesOfClass(net.minecraft.world.entity.PathfinderMob.class, box, e -> e.getPersistentData().contains("ShinobiRank"))
								.forEach(e -> NarutoShippudenMod.LOGGER.info("DEVTEST shinobi {} {}: chakra {} hp {}", village, n,
										(int) e.getPersistentData().getDoubleOr("ChakraAmount", 0), e.getHealth()));
						player.level().getEntitiesOfClass(net.minecraft.world.entity.monster.zombie.Husk.class, box)
								.forEach(h -> NarutoShippudenMod.LOGGER.info("DEVTEST shinobi {} {}: husk hp {}", village, n, h.getHealth()));
					});
					if (n == 10)
						command(mc, "damage @e[type=naruto_shippuden:hidden_" + village + "_shinobi,limit=1] 6 minecraft:player_attack by @s");
					nextDelay = n == 10 ? 2 : 16;
				});
			}
		}
	}

	/** Kurama against a training husk, seen from the side: claws, tails, roar, Tailed Beast Balls, the leap. */
	private static void kuramaSteps(Minecraft mc) {
		STEPS.add(() -> {
			setupFight(mc);
			arena(mc, 48, -16, 72);
			nextDelay = 60;
		});
		STEPS.add(() -> {
			command(mc, "summon minecraft:husk ~ ~ ~6 {NoAI:1b,PersistenceRequired:1b,attributes:[{id:\"minecraft:max_health\",base:5000}],Health:5000f}");
			command(mc, "summon naruto_shippuden:kurama ~ ~ ~40");
			nextDelay = 5;
		});
		String[] positions = { "~-40 ~12 ~24 facing ~ ~6 ~24", "~0 ~18 ~-18 facing ~ ~6 ~24" };
		for (int shot = 0; shot < 40; shot++) {
			int n = shot;
			STEPS.add(() -> {
				onServer(mc, player -> {
					var box = player.getBoundingBox().inflate(80);
					var kurama = player.level().getEntitiesOfClass(net.minecraft.world.entity.Mob.class, box,
							e -> e instanceof net.mcreator.narutoshippudenmod.entity.SummonEntities.KuramaEntity.CustomEntity).stream().findFirst().orElse(null);
					var husk = player.level().getEntitiesOfClass(net.minecraft.world.entity.monster.zombie.Husk.class, box).stream().findFirst().orElse(null);
					if (kurama != null && husk != null) {
						if (kurama.getTarget() != husk)
							kurama.setTarget(husk);
						NarutoShippudenMod.LOGGER.info("DEVTEST kurama {}: hp {} at {} husk hp {} at {}", n, kurama.getHealth(), kurama.blockPosition(), husk.getHealth(),
								husk.blockPosition());
					}
				});
				if (n == 0)
					command(mc, "tp @s " + positions[0]);
				if (n == 22) {
					// move the husk far away: the leap and the Tailed Beast Ball
					command(mc, "tp @e[type=minecraft:husk] ~ ~ ~-10");
					command(mc, "tp @s " + positions[1]);
				}
				shot(mc, "kurama_" + n);
				nextDelay = 12;
			});
		}
	}

	/** The Jutsu page: the list, the editor with a name typed in, the made jutsu in the list and on the Fire Release wheel. */
	private static void customScreenSteps(Minecraft mc) {
		STEPS.add(() -> {
			setupFight(mc);
			onServer(mc, player -> NarutoShippudenModVariables.ifPresent(player, v -> {
				v.firereleaselogic = v.windreleaselogic = true;
				v.firelearn = 5;
				net.mcreator.narutoshippudenmod.core.jutsu.Jutsus.migrate(v, true);
				v.jp = 300;
				v.custom_jutsu = "Hidden Flame Bullets|fire|BULLETS|1|2|2";
				v.syncPlayerVariables(player);
			}));
			command(mc, "item replace entity @s weapon.mainhand with naruto_shippuden:fire_release_technique");
			nextDelay = 20;
		});
		STEPS.add(() -> {
			open(mc, "JutsuCreationGuis$CreateJutsuGUIGui");
			nextDelay = 20;
		});
		STEPS.add(() -> {
			shot(mc, "custom_list");
			click(mc, "Create Jutsu");
			nextDelay = 10;
		});
		STEPS.add(() -> {
			if (mc.gui.screen() != null)
				for (var child : mc.gui.screen().children())
					if (child instanceof net.minecraft.client.gui.components.EditBox box)
						box.setValue("Blazing Dragon Fang");
			click(mc, ">");
			nextDelay = 5;
		});
		STEPS.add(() -> {
			shot(mc, "custom_editor");
			click(mc, "Create");
			nextDelay = 20;
		});
		STEPS.add(() -> {
			shot(mc, "custom_made");
			NarutoShippudenMod.LOGGER.info("DEVTEST custom: {} / jp {}", NarutoShippudenModVariables.get(mc.player).custom_jutsu.replace("\n", " ; "),
					NarutoShippudenModVariables.get(mc.player).jp);
			mc.player.closeContainer();
			nextDelay = 10;
		});
		STEPS.add(() -> {
			mc.gui.setScreen(new JutsuClient.WheelScreen(net.mcreator.narutoshippudenmod.core.jutsu.Jutsus.TECHNIQUES
					.get(net.minecraft.resources.Identifier.fromNamespaceAndPath("naruto_shippuden", "fire_release_technique"))));
			nextDelay = 10;
		});
		STEPS.add(() -> {
			shot(mc, "custom_wheel");
			mc.gui.setScreen(null);
			nextDelay = 5;
		});
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
	/** DNA: kekkei genkai needing their natures, Medicine setting the chance, identifying, shinobi drops, the config switch, tooltips. */
	private static void dnaSteps(Minecraft mc) {
		java.util.function.Function<String, net.mcreator.narutoshippudenmod.core.jutsu.Dna.Kind> kind = id -> java.util.stream.Stream
				.concat(net.mcreator.narutoshippudenmod.core.jutsu.Dna.NATURES.stream(), net.mcreator.narutoshippudenmod.core.jutsu.Dna.KEKKEI_GENKAI.stream())
				.filter(k -> k.id().equals(id)).findFirst().orElseThrow();
		java.util.function.BiFunction<net.minecraft.server.level.ServerPlayer, String, String> implant = (player, id) -> {
			net.mcreator.narutoshippudenmod.core.jutsu.Dna.Kind k = kind.apply(id);
			net.minecraft.world.item.ItemStack stack = new net.minecraft.world.item.ItemStack(
					net.minecraft.core.registries.BuiltInRegistries.ITEM.getValue(net.minecraft.resources.Identifier.fromNamespaceAndPath("naruto_shippuden", k.item())));
			net.mcreator.narutoshippudenmod.core.jutsu.Dna.implant(player, player, stack, k);
			return "used " + (stack.isEmpty()) + " has " + k.has().test(NarutoShippudenModVariables.get(player));
		};
		STEPS.add(() -> {
			mc.gui.setScreen(null);
			command(mc, "clear @s");
			command(mc, "kill @e[type=!player]");
			onServer(mc, player -> {
				NarutoShippudenModVariables.ifPresent(player, v -> {
					for (var k : net.mcreator.narutoshippudenmod.core.jutsu.Dna.NATURES)
						k.set().accept(v, false);
					for (var k : net.mcreator.narutoshippudenmod.core.jutsu.Dna.KEKKEI_GENKAI)
						k.set().accept(v, false);
					v.medicine = 0;
				});
				net.mcreator.narutoshippudenmod.core.NarutoConfig.COMBINE_NATURES.set(true);
				NarutoShippudenMod.LOGGER.info("DEVTEST dna chance medicine 0: nature {} kekkei genkai {}",
						net.mcreator.narutoshippudenmod.core.jutsu.Dna.chance(kind.apply("fire"), NarutoShippudenModVariables.get(player)),
						net.mcreator.narutoshippudenmod.core.jutsu.Dna.chance(kind.apply("ice"), NarutoShippudenModVariables.get(player)));
				NarutoShippudenMod.LOGGER.info("DEVTEST dna ice without natures: {}", implant.apply(player, "ice"));
				NarutoShippudenModVariables.ifPresent(player, v -> v.medicine = 300);
				NarutoShippudenMod.LOGGER.info("DEVTEST dna chance medicine 300: nature {} kekkei genkai {}",
						net.mcreator.narutoshippudenmod.core.jutsu.Dna.chance(kind.apply("fire"), NarutoShippudenModVariables.get(player)),
						net.mcreator.narutoshippudenmod.core.jutsu.Dna.chance(kind.apply("ice"), NarutoShippudenModVariables.get(player)));
				NarutoShippudenMod.LOGGER.info("DEVTEST dna water: {}", implant.apply(player, "water"));
				NarutoShippudenMod.LOGGER.info("DEVTEST dna ice with water only: {}", implant.apply(player, "ice"));
				NarutoShippudenMod.LOGGER.info("DEVTEST dna wind: {}", implant.apply(player, "wind"));
				NarutoShippudenMod.LOGGER.info("DEVTEST dna ice with water and wind: {}", implant.apply(player, "ice"));
				NarutoShippudenMod.LOGGER.info("DEVTEST dna ice again: {}", implant.apply(player, "ice"));
				net.mcreator.narutoshippudenmod.core.NarutoConfig.COMBINE_NATURES.set(false);
				NarutoShippudenMod.LOGGER.info("DEVTEST dna dust with combining off: {}", implant.apply(player, "dust"));
				net.mcreator.narutoshippudenmod.core.NarutoConfig.COMBINE_NATURES.set(true);
				// failures at Medicine 0 use the DNA up
				NarutoShippudenModVariables.ifPresent(player, v -> v.medicine = 0);
				int got = 0, tries = 40;
				for (int i = 0; i < tries; i++) {
					NarutoShippudenModVariables.ifPresent(player, v -> v.lightningreleaselogic = false);
					implant.apply(player, "lightning");
					if (NarutoShippudenModVariables.get(player).lightningreleaselogic)
						got++;
				}
				NarutoShippudenMod.LOGGER.info("DEVTEST dna lightning at medicine 0: {} of {}", got, tries);
				// identifying
				player.getInventory().clearContent();
				net.minecraft.world.item.ItemStack undefined = new net.minecraft.world.item.ItemStack(
						net.minecraft.core.registries.BuiltInRegistries.ITEM.getValue(net.minecraft.resources.Identifier.fromNamespaceAndPath("naruto_shippuden", "undefined_dna")), 100);
				for (int i = 0; i < 100; i++)
					net.mcreator.narutoshippudenmod.core.jutsu.Dna.identify(player, undefined);
				int natures = 0, kekkeiGenkai = 0;
				for (net.minecraft.world.item.ItemStack stack : player.getInventory().getNonEquipmentItems()) {
					var k = net.mcreator.narutoshippudenmod.core.jutsu.Dna.kind(stack);
					if (k != null) {
						if (k.natural())
							natures += stack.getCount();
						else
							kekkeiGenkai += stack.getCount();
					}
				}
				NarutoShippudenMod.LOGGER.info("DEVTEST dna identify 100: natures {} kekkei genkai {} left {}", natures, kekkeiGenkai, undefined.getCount());
				player.getInventory().clearContent();
			});
			// drops: twenty Jonin and twenty zombies
			for (int i = 0; i < 20; i++) {
				command(mc, "summon naruto_shippuden:hidden_leaf_shinobi ~" + (i % 5 * 2 - 4) + " ~ ~6 {NoAI:1b,NeoForgeData:{ShinobiRank:2}}");
				command(mc, "summon minecraft:zombie ~" + (i % 5 * 2 - 4) + " ~ ~-6 {NoAI:1b}");
			}
			nextDelay = 40;
		});
		STEPS.add(() -> {
			command(mc, "kill @e[type=naruto_shippuden:hidden_leaf_shinobi]");
			command(mc, "kill @e[type=minecraft:zombie]");
		});
		STEPS.add(() -> onServer(mc, player -> {
			java.util.List<net.minecraft.world.entity.item.ItemEntity> items = player.level().getEntitiesOfClass(net.minecraft.world.entity.item.ItemEntity.class,
					player.getBoundingBox().inflate(20), e -> true);
			long front = items.stream().filter(e -> e.getZ() > player.getZ() && net.mcreator.narutoshippudenmod.core.jutsu.Dna.undefined(e.getItem())).count();
			long back = items.stream().filter(e -> e.getZ() < player.getZ() && net.mcreator.narutoshippudenmod.core.jutsu.Dna.undefined(e.getItem())).count();
			NarutoShippudenMod.LOGGER.info("DEVTEST dna drops: 20 Jonin {} / 20 zombies {}", front, back);
		}));
		// tooltips
		STEPS.add(() -> {
			command(mc, "kill @e[type=item]");
			command(mc, "give @s naruto_shippuden:ice_dna_release");
			command(mc, "give @s naruto_shippuden:dust_dna_release");
			command(mc, "give @s naruto_shippuden:undefined_dna");
		});
		STEPS.add(() -> {
			for (String id : new String[] { "ice_dna_release", "dust_dna_release", "undefined_dna" }) {
				net.minecraft.world.item.ItemStack stack = new net.minecraft.world.item.ItemStack(
						net.minecraft.core.registries.BuiltInRegistries.ITEM.getValue(net.minecraft.resources.Identifier.fromNamespaceAndPath("naruto_shippuden", id)));
				NarutoShippudenMod.LOGGER.info("DEVTEST dna tooltip {}: {}", id, stack.getTooltipLines(net.minecraft.world.item.Item.TooltipContext.of(mc.level), mc.player,
						net.minecraft.world.item.TooltipFlag.NORMAL).stream().map(c -> c.getString()).toList());
			}
		});
	}

	/** Learned jutsu by id: migrating old counts, buying in order, order independence, and the Obito and Sasuke scrolls. */
	private static void learnedSteps(Minecraft mc) {
		java.util.function.Function<String, net.mcreator.narutoshippudenmod.core.jutsu.Jutsus.Technique> technique = id -> net.mcreator.narutoshippudenmod.core.jutsu.Jutsus.TECHNIQUES
				.get(net.minecraft.resources.Identifier.fromNamespaceAndPath("naruto_shippuden", id));
		java.util.function.Function<String, net.mcreator.narutoshippudenmod.core.jutsu.Jutsus.Release> release = id -> net.mcreator.narutoshippudenmod.core.jutsu.Jutsus.RELEASES
				.get(net.minecraft.resources.Identifier.fromNamespaceAndPath("naruto_shippuden", id));
		java.util.function.BiConsumer<String, net.minecraft.server.level.ServerPlayer> report = (what, player) -> {
			NarutoShippudenModVariables.PlayerVariables v = NarutoShippudenModVariables.get(player);
			for (String id : new String[] { "fire_release", "mangekyou_sharingan_obito_release", "mangekyou_sharingan_sasuke_release" }) {
				net.mcreator.narutoshippudenmod.core.jutsu.Jutsus.Release r = release.apply(id);
				StringBuilder line = new StringBuilder();
				for (net.mcreator.narutoshippudenmod.core.jutsu.Jutsus.Jutsu j : r.tracks().getFirst().technique().jutsu)
					line.append(j.isLearned(v) ? "1" : "0");
				StringBuilder owned = new StringBuilder();
				for (net.mcreator.narutoshippudenmod.core.jutsu.Jutsus.Track t : r.tracks())
					owned.append(t.owned(v)).append(' ');
				NarutoShippudenMod.LOGGER.info("DEVTEST learned {} {}: {} owned {}", what, id, line, owned.toString().trim());
			}
			NarutoShippudenMod.LOGGER.info("DEVTEST learned {} counts: firelearn {} fire_release {} obito {}/{} susanoo {} sasuke {}/{} jp {} set [{}]", what, v.firelearn,
					v.fire_release, v.mangekyousharinganobitokamuilearn, v.mangekyousharinganobitokamuirelease, v.mangekyousharinganobitosusanorelease,
					v.mangekyousharingansasukeamaterasulearn, v.mangekyousharingansasukeamaterasurelease, v.jp, v.learned_jutsu);
		};
		STEPS.add(() -> {
			mc.gui.setScreen(null);
			command(mc, "clear @s");
			// an old-style save: three fire jutsu by count, nothing in the set
			onServer(mc, player -> NarutoShippudenModVariables.ifPresent(player, v -> {
				v.firereleaselogic = true;
				v.learned_jutsu = "";
				v.learned_jutsu_migrated = false;
				v.firelearn = v.fire_release = 3;
				v.mangekyousharinganobitokamuilearn = v.mangekyousharinganobitokamuirelease = v.mangekyousharinganobitosusanorelease = 0;
				v.mangekyousharinganobitosusanolearn = 0;
				v.mangekyousharingansasukeamaterasulearn = v.mangekyousharingansasukeamaterasurelease = v.mangekyousharingansasukesusanorelease = 0;
				v.mangekyousharingansasukesusanolearn = 0;
				v.MangekyouSharinganRelease = 0;
				report.accept("old", player);
				net.mcreator.narutoshippudenmod.core.jutsu.Jutsus.migrate(v, false);
				report.accept("migrated", player);
				v.jp = 1000;
				v.syncPlayerVariables(player);
			}));
		});
		STEPS.add(() -> onServer(mc, player -> {
			net.mcreator.narutoshippudenmod.core.jutsu.Jutsus.learn(player, release.apply("fire_release").item(), 0);
			report.accept("bought4", player);
			// order no longer matters: with only the fifth jutsu in the set, it alone is learned and the next tier to buy is the first
			NarutoShippudenModVariables.ifPresent(player, v -> v.learned_jutsu = technique.apply("fire_release_technique").jutsu.get(4).key());
			report.accept("onlyfifth", player);
			net.mcreator.narutoshippudenmod.core.jutsu.Jutsus.learn(player, release.apply("fire_release").item(), 0);
			report.accept("thenfirst", player);
			// the migration runs once: clearing the counts changes nothing now
			NarutoShippudenModVariables.ifPresent(player, v -> {
				v.firelearn = v.fire_release = 0;
				net.mcreator.narutoshippudenmod.core.jutsu.Jutsus.migrate(v, false);
			});
			report.accept("countscleared", player);
		}));
		// the Obito scroll: names and prices of every tier
		STEPS.add(() -> {
			for (String id : new String[] { "mangekyou_sharingan_obito_release", "mangekyou_sharingan_sasuke_release" })
				for (net.mcreator.narutoshippudenmod.core.jutsu.Jutsus.Track t : release.apply(id).tracks())
					for (int i = 0; i < t.tiers().size(); i++)
						NarutoShippudenMod.LOGGER.info("DEVTEST scroll {} [{}] {}: {} JP", id, t.label(), t.name(i), t.tiers().get(i).cost());
			onServer(mc, player -> NarutoShippudenModVariables.ifPresent(player, v -> {
				v.sharingan = v.MangekyouSharinganObito = true;
				v.MangekyouSharinganSasuke = false;
				v.syncPlayerVariables(player);
			}));
			command(mc, "give @s naruto_shippuden:mangekyou_sharingan_obito_release");
		});
		STEPS.add(() -> mc.gui.setScreen(new JutsuClient.ScrollScreen(release.apply("mangekyou_sharingan_obito_release"),
				net.minecraft.network.chat.Component.literal("Mangekyou Sharingan (Obito)"))));
		STEPS.add(() -> shot(mc, "learned_obito_scroll_new"));
		STEPS.add(() -> {
			mc.gui.setScreen(null);
			onServer(mc, player -> {
				for (int i = 0; i < 2; i++)
					net.mcreator.narutoshippudenmod.core.jutsu.Jutsus.learn(player, release.apply("mangekyou_sharingan_obito_release").item(), 0);
				// the Susanoo track still goes through the old procedure
				net.mcreator.narutoshippudenmod.core.jutsu.Jutsus.learn(player, release.apply("mangekyou_sharingan_obito_release").item(), 1);
				report.accept("obito", player);
				NarutoShippudenMod.LOGGER.info("DEVTEST learned obito item given: {}",
						player.getInventory().contains(new net.minecraft.world.item.ItemStack(net.minecraft.core.registries.BuiltInRegistries.ITEM
								.getValue(net.minecraft.resources.Identifier.fromNamespaceAndPath("naruto_shippuden", "mangekyou_sharingan_obito_release_technique")))));
			});
		});
		STEPS.add(() -> mc.gui.setScreen(new JutsuClient.ScrollScreen(release.apply("mangekyou_sharingan_obito_release"),
				net.minecraft.network.chat.Component.literal("Mangekyou Sharingan (Obito)"))));
		STEPS.add(() -> shot(mc, "learned_obito_scroll_bought"));
		STEPS.add(() -> {
			mc.gui.setScreen(null);
			for (int slot = 0; slot < 9; slot++)
				if (net.mcreator.narutoshippudenmod.core.jutsu.Jutsus.technique(mc.player.getInventory().getItem(slot)) != null)
					mc.player.getInventory().setSelectedSlot(slot);
		});
		STEPS.add(() -> {
			if (JutsuClient.held(mc.player) != null)
				mc.gui.setScreen(new JutsuClient.WheelScreen(JutsuClient.held(mc.player)));
		});
		STEPS.add(() -> shot(mc, "learned_obito_wheel"));
		// a second Mangekyou: only the newest one stays; then Sasuke's scroll
		STEPS.add(() -> {
			mc.gui.setScreen(null);
			onServer(mc, player -> NarutoShippudenModVariables.ifPresent(player, v -> {
				v.MangekyouSharinganSasuke = true;
				v.syncPlayerVariables(player);
			}));
		});
		STEPS.add(() -> onServer(mc, player -> {
			NarutoShippudenModVariables.PlayerVariables v = NarutoShippudenModVariables.get(player);
			NarutoShippudenMod.LOGGER.info("DEVTEST learned one mangekyou: obito {} sasuke {}", v.MangekyouSharinganObito, v.MangekyouSharinganSasuke);
			net.mcreator.narutoshippudenmod.core.jutsu.Jutsus.learn(player, release.apply("mangekyou_sharingan_sasuke_release").item(), 0);
			report.accept("sasuke", player);
			// every Susanoo stage, and one more that must do nothing
			for (int i = 0; i < 5; i++) {
				double jp = NarutoShippudenModVariables.get(player).jp;
				net.mcreator.narutoshippudenmod.core.jutsu.Jutsus.learn(player, release.apply("mangekyou_sharingan_sasuke_release").item(), 1);
				NarutoShippudenModVariables.PlayerVariables after = NarutoShippudenModVariables.get(player);
				NarutoShippudenMod.LOGGER.info("DEVTEST learned susanoo buy {}: stage {} bought {} cost {} jutsu {}", i, after.mangekyousharingansasukesusanolearn,
						after.mangekyousharingansasukesusanorelease, jp - after.jp, after.mangekyousharingansasukeamaterasulearn);
			}
		}));
		STEPS.add(() -> mc.gui.setScreen(new JutsuClient.ScrollScreen(release.apply("mangekyou_sharingan_sasuke_release"),
				net.minecraft.network.chat.Component.literal("Mangekyou Sharingan (Sasuke)"))));
		STEPS.add(() -> shot(mc, "learned_sasuke_scroll"));
	}

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
		if (watchShot != null && mc.player != null) {
			String name = watchShot;
			watchShot = null;
			if (name.equals("done"))
				mc.stop();
			else {
				shot(mc, "watch_" + name);
				for (net.minecraft.world.entity.player.Player other : mc.level.players())
					if (other != mc.player) {
						NarutoShippudenModVariables.PlayerVariables o = NarutoShippudenModVariables.get(other);
						NarutoShippudenMod.LOGGER.info("DEVTEST watcher sees {}: susanoo {} itachi {} ms {} sharingan {}", other.getName().getString(),
								o.mangekyousharingansusanostage, o.MangekyouSharinganItachi, o.MangekyouSharinganActivate, o.sharinganactivate);
					}
			}
		}
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
