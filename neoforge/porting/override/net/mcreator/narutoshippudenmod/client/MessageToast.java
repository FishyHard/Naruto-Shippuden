package net.mcreator.narutoshippudenmod.client;

import net.minecraft.client.DeltaTracker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.Style;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Mth;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ClientChatReceivedEvent;
import net.neoforged.neoforge.client.event.RegisterGuiLayersEvent;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Messages above the hotbar (not enough chakra, a jutsu chosen, an eye opened) shown as a small dark panel with an icon, like the
 * item notices of vanilla-style mods: the icon is what the message is about (the technique in hand, an experience bottle for XP
 * and JP, the eye itself for dojutsu, the player's own Mangekyou for the Susanoo), a "Label: value" message has a grey label, and anything in brackets is grey too. It fades out after
 * a couple of seconds, and a new message replaces it.
 */
@EventBusSubscriber(modid = "naruto_shippuden", value = Dist.CLIENT)
public final class MessageToast {
	private static final int SHOWN = 50, FADE = 10, GREY = 0xFFAAAAAA, WHITE = 0xFFFFFFFF;
	private static final Pattern BRACKETS = Pattern.compile("\\([^)]*\\)");
	private static final Pattern DOJUTSU = Pattern.compile("(?i).*(sharingan|byakugan|rinnegan|tenseigan|ketsuryugan|kokugan|mangekyou|susanoo|dojutsu).*");
	private static final Pattern PROGRESS = Pattern.compile("(?i).*(\\bXP\\b|\\bJP\\b|\\bSP\\b|^Level ).*");
	private static final Pattern STAT = Pattern.compile("^[+-]\\d+ (Ninjutsu|Taijutsu|Genjutsu|Kenjutsu|Shurikenjutsu|Summoning|Kinjutsu|Senjutsu|Medicine|Speed|IQ).*");

	private static Component message = Component.empty();
	private static ItemStack icon = ItemStack.EMPTY;
	private static long shownAt = -1000;

	private MessageToast() {
	}

	@SubscribeEvent
	public static void received(ClientChatReceivedEvent.System event) {
		if (!event.isOverlay())
			return;
		Minecraft minecraft = Minecraft.getInstance();
		if (minecraft.player == null)
			return;
		event.setCanceled(true);
		message = style(event.getMessage());
		icon = icon(event.getMessage().getString());
		shownAt = minecraft.player.tickCount;
	}

	private static ItemStack icon(String text) {
		if (PROGRESS.matcher(text).matches())
			return new ItemStack(Items.EXPERIENCE_BOTTLE);
		if (STAT.matcher(text).matches())
			return new ItemStack(Items.BOOK);
		ItemStack eye = eyeIcon(text.toLowerCase(java.util.Locale.ROOT));
		if (!eye.isEmpty())
			return eye;
		var player = Minecraft.getInstance().player;
		ItemStack held = player.getMainHandItem().isEmpty() ? player.getOffhandItem() : player.getMainHandItem();
		return held.copy();
	}

	private static final String[][] EYES = { { "sharingan", "sharingan_release" }, { "byakugan", "byakugan_release" },
			{ "rinnegan", "rinnegan_release" }, { "tenseigan", "tenseigan_release" }, { "ketsuryugan", "ketsuryugan_release" },
			{ "kokugan", "isshiki_dojutsu_release" } };

	/** A dojutsu message shows that eye; the Mangekyou and the Susanoo show the player's own Mangekyou. */
	private static ItemStack eyeIcon(String text) {
		if (!DOJUTSU.matcher(text).matches())
			return ItemStack.EMPTY;
		if (text.contains("mangekyou") || text.contains("susanoo")) {
			var v = net.mcreator.narutoshippudenmod.NarutoShippudenModVariables.get(Minecraft.getInstance().player);
			String whose = v.MangekyouSharinganItachi ? "itachi" : v.MangekyouSharinganSasuke ? "sasuke" : v.MangekyouSharinganMadara ? "madara"
					: v.MangekyouSharinganObito ? "obito" : v.MangekyouSharinganShisui ? "shisui" : v.MangekyouSharinganKakashi ? "kakashi" : null;
			return whose == null ? item("sharingan_release") : item("mangekyou_sharingan_" + whose + "_release");
		}
		for (String[] eye : EYES)
			if (text.contains(eye[0]))
				return item(eye[1]);
		return new ItemStack(Items.ENDER_EYE);
	}

	private static ItemStack item(String id) {
		return new ItemStack(net.minecraft.core.registries.BuiltInRegistries.ITEM.getValue(Identifier.fromNamespaceAndPath("naruto_shippuden", id)));
	}

	/** A message the server already styled keeps its colours; a plain one gets a grey label and grey brackets. */
	private static Component style(Component raw) {
		if (!raw.getStyle().isEmpty() || !raw.getSiblings().isEmpty())
			return raw;
		String text = raw.getString();
		MutableComponent out = Component.empty();
		int colon = text.indexOf(": ");
		if (colon > 0 && colon < 28) {
			out.append(Component.literal(text.substring(0, colon + 1)).withStyle(Style.EMPTY.withColor(GREY)));
			text = text.substring(colon + 1);
		}
		Matcher m = BRACKETS.matcher(text);
		int at = 0;
		while (m.find()) {
			out.append(Component.literal(text.substring(at, m.start())).withStyle(Style.EMPTY.withColor(WHITE)));
			out.append(Component.literal(m.group()).withStyle(Style.EMPTY.withColor(GREY)));
			at = m.end();
		}
		out.append(Component.literal(text.substring(at)).withStyle(Style.EMPTY.withColor(WHITE)));
		return out;
	}

	public static void render(GuiGraphicsExtractor graphics, DeltaTracker delta) {
		Minecraft minecraft = Minecraft.getInstance();
		if (minecraft.player == null)
			return;
		float age = minecraft.player.tickCount - shownAt + delta.getGameTimeDeltaPartialTick(false);
		if (age < 0 || age > SHOWN + FADE)
			return;
		float alpha = age < 3 ? age / 3 : age > SHOWN ? 1 - (age - SHOWN) / FADE : 1;
		int a = Mth.clamp((int) (alpha * 255), 8, 255);
		Font font = minecraft.font;
		boolean withIcon = !icon.isEmpty();
		int textWidth = font.width(message), w = textWidth + 10 + (withIcon ? 18 : 0), h = 18;
		int x = graphics.guiWidth() / 2 - w / 2, y = graphics.guiHeight() - 82;
		graphics.fill(x, y, x + w, y + h, (int) (a * 0.62F) << 24);
		graphics.fill(x, y, x + w, y + 1, (int) (a * 0.25F) << 24 | 0xFFFFFF);
		if (withIcon && a > 128)
			graphics.item(icon, x + 4, y + 1);
		graphics.text(font, message, x + 5 + (withIcon ? 18 : 0), y + 5, a << 24 | 0xFFFFFF, true);
	}

	@SubscribeEvent
	public static void register(RegisterGuiLayersEvent event) {
		event.registerAboveAll(Identifier.fromNamespaceAndPath("naruto_shippuden", "message_toast"), MessageToast::render);
	}
}
