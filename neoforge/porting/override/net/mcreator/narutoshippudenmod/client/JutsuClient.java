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
import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;

import java.util.List;
import java.util.Optional;

import org.jspecify.annotations.Nullable;

/** Client half of {@link Jutsus}: the jutsu wheel (hold X), the jutsu scroll screen and the item tooltips. */
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

	@SubscribeEvent
	public static void tooltip(ItemTooltipEvent event) {
		if (event.getEntity() == null)
			return;
		PlayerVariables variables = NarutoShippudenModVariables.get(event.getEntity());
		Technique technique = Jutsus.technique(event.getItemStack());
		List<Component> lines = event.getToolTip();
		if (technique != null) {
			lines.removeIf(line -> line.getString().startsWith("Shift Right-Click"));
			lines.add(Component.literal("Jutsu: " + technique.selected(variables).name()).withStyle(ChatFormatting.GOLD));
			lines.add(Component.literal("Right-click to use, hold ").append(WHEEL.getTranslatedKeyMessage()).append(" to choose")
					.withStyle(ChatFormatting.GRAY));
		} else if (Jutsus.release(event.getItemStack()) != null) {
			lines.add(Component.literal("Right-click to open the jutsu scroll").withStyle(ChatFormatting.GRAY));
		}
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
		stack.set(DataComponents.USE_COOLDOWN, new UseCooldown(0.0F, Optional.of(jutsu.cooldownGroup())));
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

		private int boxX(int i) {
			return width / 2 + (int) (Mth.cos(angle(i)) * (count() <= 4 ? 70 : 96)) - 55;
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
				graphics.blitSprite(RenderPipelines.GUI_TEXTURED, i == hovered ? PANEL : INSET, x, y, 110, 20);
				float cooldown = player.getCooldowns().getCooldownPercent(probes[i], a);
				if (cooldown > 0)
					graphics.fill(x + 1, y + 1, x + 1 + (int) (108 * cooldown), y + 19, 0x60000000);
				String name = font.plainSubstrByWidth(jutsu.name(), 102);
				int color = !learned ? 0xFF9A9A9A : i == hovered ? TEXT : i == selected ? 0xFFFFFF55 : 0xFFFFFFFF;
				graphics.text(font, name, x + 55 - font.width(name) / 2, y + 6, color, i != hovered && learned);
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
	/** Every tier of a release: what it unlocks, what it needs, the JP price and a Learn button for the next one. */
	static class ScrollScreen extends Screen {
		private static final int W = 276, ROW = 30, ROWS = 5;
		private final Release release;
		private int scroll;
		private int owned = -1;
		private double jp = -1;

		ScrollScreen(Release release, Component name) {
			super(name);
			this.release = release;
		}

		private int left() {
			return (width - W) / 2;
		}

		private int top() {
			return (height - (26 + ROWS * ROW + 6)) / 2;
		}

		private int maxScroll() {
			return Math.max(0, release.tiers().size() - ROWS);
		}

		@Override
		protected void init() {
			PlayerVariables variables = NarutoShippudenModVariables.get(minecraft.player);
			owned = release.owned(variables);
			jp = variables.jp;
			for (int row = 0; row < ROWS && scroll + row < release.tiers().size(); row++) {
				int tier = scroll + row;
				if (tier < owned)
					continue;
				Tier info = release.tiers().get(tier);
				Button learn = Button.builder(Component.literal(info.cost() + " JP"), b -> send("learn", release.item().toString(), 0))
						.bounds(left() + W - 8 - 8 - 56, top() + 20 + row * ROW + 3, 56, 20).build();
				learn.active = tier == owned && variables.jp >= info.cost();
				learn.setTooltip(net.minecraft.client.gui.components.Tooltip.create(Component.literal(tier == owned
						? variables.jp >= info.cost() ? "Learn for " + info.cost() + " JP" : "Not enough JP"
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
			PlayerVariables variables = NarutoShippudenModVariables.get(minecraft.player);
			if (release.owned(variables) != owned || variables.jp != jp)
				rebuildWidgets();
			super.extractRenderState(graphics, mouseX, mouseY, a);
		}

		@Override
		public void extractBackground(GuiGraphicsExtractor graphics, int mouseX, int mouseY, float a) {
			super.extractBackground(graphics, mouseX, mouseY, a);
			PlayerVariables variables = NarutoShippudenModVariables.get(minecraft.player);
			int x = left(), y = top();
			graphics.blitSprite(RenderPipelines.GUI_TEXTURED, PANEL, x, y, W, 26 + ROWS * ROW + 6);
			graphics.text(font, title, x + 8, y + 6, TEXT, false);
			String jpText = "JP: " + (int) variables.jp;
			graphics.text(font, jpText, x + W - 8 - font.width(jpText), y + 6, TEXT, false);
			for (int row = 0; row < ROWS && scroll + row < release.tiers().size(); row++) {
				int tier = scroll + row, ry = y + 20 + row * ROW;
				Tier info = release.tiers().get(tier);
				graphics.blitSprite(RenderPipelines.GUI_TEXTURED, INSET, x + 8, ry, W - 16 - 8, ROW - 2);
				List<Jutsu> unlocks = release.unlocks(info);
				String name = unlocks.isEmpty() ? info.gives() == null ? "Tier " + (tier + 1)
						: "Unlocks " + new ItemStack(BuiltInRegistries.ITEM.getValue(info.gives())).getHoverName().getString()
						: unlocks.getFirst().name();
				String detail = unlocks.isEmpty() ? "" : details(unlocks.getFirst(), variables);
				boolean learned = tier < owned;
				int textRight = learned ? W - 16 - 8 - 22 : W - 16 - 8 - 64;
				graphics.text(font, font.plainSubstrByWidth(name, textRight - 8), x + 13, ry + 5, learned ? 0xFFFFFF55 : 0xFFFFFFFF, true);
				graphics.text(font, font.plainSubstrByWidth(detail, textRight - 8), x + 13, ry + 16, 0xFFD0D0D0, true);
				if (learned)
					graphics.blitSprite(RenderPipelines.GUI_TEXTURED, CHECKMARK, x + W - 8 - 8 - 20, ry + 10, 9, 8);
			}
			// scrollbar
			int barX = x + W - 8 - 6, barTop = y + 20, barHeight = ROWS * ROW - 2;
			graphics.blitSprite(RenderPipelines.GUI_TEXTURED, INSET, barX, barTop, 6, barHeight);
			int thumb = maxScroll() == 0 ? barHeight - 2 : Math.max(10, barHeight * ROWS / release.tiers().size());
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
