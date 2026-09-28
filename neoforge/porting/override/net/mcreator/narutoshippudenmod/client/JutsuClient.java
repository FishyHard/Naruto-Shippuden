package net.mcreator.narutoshippudenmod.client;

import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables;
import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables.PlayerVariables;
import net.mcreator.narutoshippudenmod.core.NarutoActions;
import net.mcreator.narutoshippudenmod.core.jutsu.Jutsus;
import net.mcreator.narutoshippudenmod.core.jutsu.Jutsus.Jutsu;
import net.mcreator.narutoshippudenmod.core.jutsu.Jutsus.Release;
import net.mcreator.narutoshippudenmod.core.jutsu.Jutsus.Technique;
import net.mcreator.narutoshippudenmod.core.jutsu.Jutsus.Tier;

import com.mojang.blaze3d.platform.InputConstants;

import net.minecraft.ChatFormatting;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.input.KeyEvent;
import net.minecraft.client.input.MouseButtonEvent;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.UseCooldown;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.neoforged.neoforge.client.network.ClientPacketDistributor;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;

import java.util.List;
import java.util.Optional;

import org.jspecify.annotations.Nullable;

/** Client half of {@link Jutsus}: the jutsu wheel (hold X), the jutsu scroll screen (tooltips are in ItemDescriptions). */
@EventBusSubscriber(modid = "naruto_shippuden", value = Dist.CLIENT)
public final class JutsuClient {
	public static final KeyMapping WHEEL = new KeyMapping("key.naruto_shippuden.jutsu_wheel", InputConstants.KEY_X, KeyMapping.Category.MISC);
	static final Identifier PANEL = Identifier.fromNamespaceAndPath("naruto_shippuden", "panel");
	static final Identifier INSET = Identifier.fromNamespaceAndPath("naruto_shippuden", "inset");
	static final Identifier CHECKMARK = Identifier.withDefaultNamespace("icon/checkmark");
	static final int TEXT = 0xFF404040;

	private JutsuClient() {
	}

	@SubscribeEvent
	public static void registerKeys(RegisterKeyMappingsEvent event) {
		event.register(WHEEL);
	}

	private static void send(String kind, String key, double amount) {
		ClientPacketDistributor.sendToServer(new NarutoActions.Action(kind, key, amount));
	}

	/** The technique item in either hand, main hand first. */
	static @Nullable Technique held(LocalPlayer player) {
		for (InteractionHand hand : InteractionHand.values()) {
			Technique technique = Jutsus.technique(player.getItemInHand(hand));
			if (technique != null)
				return technique;
		}
		return null;
	}

	@SubscribeEvent
	public static void tick(ClientTickEvent.Post event) {
		Minecraft minecraft = Minecraft.getInstance();
		if (minecraft.player == null || minecraft.gui.screen() != null)
			return;
		while (WHEEL.consumeClick()) {
			Technique technique = held(minecraft.player);
			if (technique != null)
				minecraft.gui.setScreen(new WheelScreen(technique));
			else
				minecraft.player.sendOverlayMessage(Component.literal("Hold a technique item to choose a jutsu"));
		}
	}

	@SubscribeEvent
	public static void onRightClickItem(PlayerInteractEvent.RightClickItem event) {
		Release release = Jutsus.release(event.getItemStack());
		if (release != null && event.getLevel().isClientSide())
			Minecraft.getInstance().gui.setScreen(new ScrollScreen(release, event.getItemStack().getHoverName()));
	}

	// ------------------------------------------------------------------ shared text
	static String seconds(int ticks) {
		return ticks % 20 == 0 ? ticks / 20 + "s" : String.format("%.1fs", ticks / 20.0);
	}

	static String details(Jutsu jutsu, PlayerVariables variables) {
		StringBuilder text = new StringBuilder();
		if (jutsu.statName() != null)
			text.append(jutsu.statName()).append(' ').append((int) jutsu.statMin()).append("  ");
		if (jutsu.chakra() > 0)
			text.append((int) jutsu.chakra()).append(" chakra  ");
		int cooldown = jutsu.cooldown(variables);
		if (cooldown > 0)
			text.append(seconds(cooldown));
		return text.toString().trim();
	}

	/** A stack whose cooldown group is this jutsu, to read its cooldown from the player's ItemCooldowns. */
	static ItemStack cooldownProbe(Jutsu jutsu) {
		ItemStack stack = new ItemStack(BuiltInRegistries.ITEM.getValue(jutsu.technique().item));
		stack.set(DataComponents.USE_COOLDOWN, new UseCooldown(0.05F, Optional.of(jutsu.cooldownGroup())));
		return stack;
	}

	// ------------------------------------------------------------------ the wheel
	/** Hold the key, point at a jutsu, let go (or click). */
	static class WheelScreen extends Screen {
		private final Technique technique;
		private final ItemStack[] probes;
		private int hovered = -1;

		WheelScreen(Technique technique) {
			super(Component.literal("Jutsu Wheel"));
			this.technique = technique;
			this.probes = technique.jutsu.stream().map(JutsuClient::cooldownProbe).toArray(ItemStack[]::new);
		}

		@Override
		public boolean isPauseScreen() {
			return false;
		}

		@Override
		public void extractBackground(GuiGraphicsExtractor graphics, int mouseX, int mouseY, float a) {
			graphics.fillGradient(0, 0, width, height, 0x60000000, 0x80000000);
		}

		private int count() {
			return technique.jutsu.size();
		}

		/** Box width: wide enough for the longest name (up to 170), so names are not cut. */
		private int boxWidth() {
			int widest = 0;
			for (Jutsu jutsu : technique.jutsu)
				widest = Math.max(widest, font.width(jutsu.name()));
			return Mth.clamp(widest + 12, 90, 170);
		}

		private int boxX(int i) {
			return width / 2 + (int) (Mth.cos(angle(i)) * (boxWidth() / 2 + (count() <= 4 ? 18 : 40))) - boxWidth() / 2;
		}

		private int boxY(int i) {
			return height / 2 + (int) (Mth.sin(angle(i)) * (count() <= 4 ? 52 : 66)) - 10;
		}

		private float angle(int i) {
			return (float) (-Math.PI / 2 + i * 2 * Math.PI / count());
		}

		@Override
		public void extractRenderState(GuiGraphicsExtractor graphics, int mouseX, int mouseY, float a) {
			super.extractRenderState(graphics, mouseX, mouseY, a);
			LocalPlayer player = minecraft.player;
			PlayerVariables variables = NarutoShippudenModVariables.get(player);
			double dx = mouseX - width / 2.0, dy = mouseY - height / 2.0;
			if (dx * dx + dy * dy > 18 * 18) {
				double mouseAngle = Math.atan2(dy, dx) + Math.PI / 2;
				hovered = Math.floorMod((int) Math.round(mouseAngle / (2 * Math.PI) * count()), count());
			} else {
				hovered = -1;
			}
			int selected = technique.selected(variables).index();
			for (int i = 0; i < count(); i++) {
				Jutsu jutsu = technique.jutsu.get(i);
				int x = boxX(i), y = boxY(i);
				boolean learned = jutsu.isLearned(variables);
				int w = boxWidth();
				graphics.blitSprite(RenderPipelines.GUI_TEXTURED, i == hovered ? PANEL : INSET, x, y, w, 20);
				float cooldown = player.getCooldowns().getCooldownPercent(probes[i], a);
				if (cooldown > 0)
					graphics.fill(x + 1, y + 1, x + 1 + (int) ((w - 2) * cooldown), y + 19, 0x60000000);
				String name = font.plainSubstrByWidth(jutsu.name(), w - 8);
				int color = !learned ? 0xFF9A9A9A : i == hovered ? TEXT : i == selected ? 0xFFFFFF55 : 0xFFFFFFFF;
				graphics.text(font, name, x + w / 2 - font.width(name) / 2, y + 6, color, i != hovered && learned);
			}
			// the middle: the item and what the pointed-at jutsu needs
			graphics.item(new ItemStack(BuiltInRegistries.ITEM.getValue(technique.item)), width / 2 - 8, height / 2 - 8);
			Jutsu focus = technique.jutsu.get(hovered >= 0 ? hovered : selected);
			String line = focus.isLearned(variables) ? details(focus, variables) : "Learn it from the jutsu scroll";
			graphics.centeredText(font, Component.literal(focus.name()).withStyle(ChatFormatting.YELLOW), width / 2, height / 2 + 96, -1);
			graphics.centeredText(font, line, width / 2, height / 2 + 108, focus.meetsStat(variables) ? 0xFFE0E0E0 : 0xFFFF6060);
		}

		private void choose() {
			if (hovered >= 0 && hovered != technique.selected(NarutoShippudenModVariables.get(minecraft.player)).index())
				send("jutsu", technique.item.toString(), hovered);
			onClose();
		}

		@Override
		public boolean keyReleased(KeyEvent event) {
			if (WHEEL.matches(event)) {
				choose();
				return true;
			}
			return super.keyReleased(event);
		}

		@Override
		public boolean mouseClicked(MouseButtonEvent event, boolean doubleClick) {
			choose();
			return true;
		}
	}

	// ------------------------------------------------------------------ the jutsu scroll
	/**
	 * Every tier of a release, track by track (a Mangekyou scroll lists its jutsu and its Susanoo): what it unlocks, what it
	 * needs, the JP price and a Learn button on the next tier of each track.
	 */
	static class ScrollScreen extends Screen {
		private static final int W = 300, ROW = 30, ROWS = 6;
		private final Release release;
		/** Flattened list: header rows (tier -1) and tier rows. */
		private final List<int[]> rows = new java.util.ArrayList<>();
		private int scroll;
		private String state = "";

		ScrollScreen(Release release, Component name) {
			super(name);
			this.release = release;
			boolean headers = release.tracks().size() > 1;
			for (int t = 0; t < release.tracks().size(); t++) {
				if (headers)
					rows.add(new int[] {t, -1});
				for (int tier = 0; tier < release.tracks().get(t).tiers().size(); tier++)
					rows.add(new int[] {t, tier});
			}
		}

		private int left() {
			return (width - W) / 2;
		}

		private int top() {
			return (height - (26 + ROWS * ROW + 6)) / 2;
		}

		private int maxScroll() {
			return Math.max(0, rows.size() - ROWS);
		}

		private String state(PlayerVariables variables) {
			StringBuilder text = new StringBuilder().append(variables.jp);
			for (Jutsus.Track track : release.tracks())
				text.append('/').append(track.owned(variables));
			return text.toString();
		}

		private String header(int track) {
			Jutsus.Track info = release.tracks().get(track);
			if (!info.label().isEmpty())
				return info.label();
			return "Jutsu";
		}

		@Override
		protected void init() {
			PlayerVariables variables = NarutoShippudenModVariables.get(minecraft.player);
			state = state(variables);
			for (int row = 0; row < ROWS && scroll + row < rows.size(); row++) {
				int track = rows.get(scroll + row)[0], tier = rows.get(scroll + row)[1];
				Jutsus.Track info = release.tracks().get(track);
				int owned = info.owned(variables);
				if (tier < owned)
					continue;
				Tier price = info.tiers().get(tier);
				Button learn = Button.builder(Component.literal(price.cost() + " JP"), b -> send("learn", release.item().toString(), track))
						.bounds(left() + W - 8 - 8 - 56, top() + 20 + row * ROW + 4, 56, 20).build();
				learn.active = tier == owned && variables.jp >= price.cost();
				learn.setTooltip(net.minecraft.client.gui.components.Tooltip.create(Component.literal(tier == owned
						? variables.jp >= price.cost() ? "Learn for " + price.cost() + " JP" : "Not enough JP"
						: "Learn the ones above first")));
				addRenderableWidget(learn);
			}
		}

		@Override
		public boolean isPauseScreen() {
			return false;
		}

		@Override
		public void extractRenderState(GuiGraphicsExtractor graphics, int mouseX, int mouseY, float a) {
			if (!state(NarutoShippudenModVariables.get(minecraft.player)).equals(state))
				rebuildWidgets();
			super.extractRenderState(graphics, mouseX, mouseY, a);
		}

		@Override
		public void extractBackground(GuiGraphicsExtractor graphics, int mouseX, int mouseY, float a) {
			super.extractBackground(graphics, mouseX, mouseY, a);
			PlayerVariables variables = NarutoShippudenModVariables.get(minecraft.player);
			int x = left(), y = top();
			graphics.blitSprite(RenderPipelines.GUI_TEXTURED, PANEL, x, y, W, 26 + ROWS * ROW + 6);
			String jpText = "JP: " + (int) variables.jp;
			graphics.text(font, font.plainSubstrByWidth(title.getString(), W - 24 - font.width(jpText)), x + 8, y + 6, TEXT, false);
			graphics.text(font, jpText, x + W - 8 - font.width(jpText), y + 6, TEXT, false);
			for (int row = 0; row < ROWS && scroll + row < rows.size(); row++) {
				int track = rows.get(scroll + row)[0], tier = rows.get(scroll + row)[1], ry = y + 20 + row * ROW;
				Jutsus.Track info = release.tracks().get(track);
				if (tier < 0) {
					graphics.text(font, header(track), x + 10, ry + 16, TEXT, false);
					continue;
				}
				graphics.blitSprite(RenderPipelines.GUI_TEXTURED, INSET, x + 8, ry, W - 16 - 8, ROW - 2);
				boolean learned = tier < info.owned(variables);
				String name = info.name(tier);
				List<Jutsu> unlocks = info.unlocks(info.tiers().get(tier));
				String detail = unlocks.isEmpty() ? "" : details(unlocks.getFirst(), variables);
				int textWidth = (learned ? W - 16 - 8 - 26 : W - 16 - 8 - 66) - 8;
				String shown = font.plainSubstrByWidth(name, textWidth);
				graphics.text(font, shown, x + 13, ry + 5, learned ? 0xFFFFFF55 : 0xFFFFFFFF, true);
				graphics.text(font, font.plainSubstrByWidth(detail, textWidth), x + 13, ry + 16, 0xFFD0D0D0, true);
				if (!shown.equals(name) && mouseX >= x + 8 && mouseX < x + 8 + textWidth && mouseY >= ry && mouseY < ry + ROW - 2)
					graphics.setTooltipForNextFrame(Component.literal(name), mouseX, mouseY);
				if (learned)
					graphics.blitSprite(RenderPipelines.GUI_TEXTURED, CHECKMARK, x + W - 8 - 8 - 20, ry + 10, 9, 8);
			}
			// scrollbar
			int barX = x + W - 8 - 6, barTop = y + 20, barHeight = ROWS * ROW - 2;
			graphics.blitSprite(RenderPipelines.GUI_TEXTURED, INSET, barX, barTop, 6, barHeight);
			int thumb = maxScroll() == 0 ? barHeight - 2 : Math.max(10, (barHeight - 2) * ROWS / rows.size());
			int thumbY = barTop + 1 + (maxScroll() == 0 ? 0 : (barHeight - 2 - thumb) * scroll / maxScroll());
			graphics.fill(barX + 1, thumbY, barX + 5, thumbY + thumb, 0xFFC6C6C6);
			graphics.fill(barX + 1, thumbY, barX + 4, thumbY + thumb - 1, 0xFFFFFFFF);
		}

		@Override
		public boolean mouseScrolled(double mouseX, double mouseY, double scrollX, double scrollY) {
			int next = Mth.clamp(scroll - (int) Math.signum(scrollY), 0, maxScroll());
			if (next != scroll) {
				scroll = next;
				rebuildWidgets();
			}
			return true;
		}
	}
}
