package net.mcreator.narutoshippudenmod.gui;

import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables;

import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.screens.inventory.InventoryScreen;
import net.minecraft.client.input.KeyEvent;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import org.jspecify.annotations.Nullable;

/**
 * Shared look of the mod's screens, kept close to vanilla containers: the inventory panel, a dark grey title, sunken
 * slot boxes, vanilla buttons and the game font. Conditions are the MCreator display procedures (they only read the
 * player), buttons send their id to the server exactly like the generated screens did.
 */
public abstract class ModScreen<M extends AbstractContainerMenu> extends AbstractContainerScreen<M> {
	public static final int TEXT = 0xFF404040;
	public static final int MUTED = 0xFF707070;
	static final Identifier PANEL = Identifier.fromNamespaceAndPath("naruto_shippuden", "panel");
	static final Identifier INSET = Identifier.fromNamespaceAndPath("naruto_shippuden", "inset");
	static final Identifier XP_BACKGROUND = Identifier.withDefaultNamespace("hud/experience_bar_background");
	static final Identifier XP_PROGRESS = Identifier.withDefaultNamespace("hud/experience_bar_progress");

	protected final Player entity;
	protected final int x, y, z;
	private final List<Runnable> refresh = new ArrayList<>();

	/** An icon shown when its procedure is true, with a tooltip. */
	public record Icon(Predicate<Map<String, Object>> shown, String texture, String name) {
	}

	protected static Icon icon(Predicate<Map<String, Object>> shown, String texture, String name) {
		return new Icon(shown, texture, name);
	}

	protected ModScreen(M menu, Inventory inventory, Component title, int width, int height, Player entity, int x, int y, int z) {
		super(menu, inventory, title, width, height);
		this.entity = entity;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	/** Sends a button press to the server and runs it on the client, like the generated screens. */
	protected abstract void send(int id);

	protected NarutoShippudenModVariables.PlayerVariables vars() {
		return NarutoShippudenModVariables.get(entity);
	}

	protected boolean is(Predicate<Map<String, Object>> procedure) {
		Map<String, Object> dependencies = new HashMap<>();
		dependencies.put("entity", entity);
		return procedure.test(dependencies);
	}

	@Override
	protected void init() {
		refresh.clear();
		super.init();
	}

	protected Button button(String label, int id, int bx, int by, int width) {
		return button(label, id, bx, by, width, 20, null);
	}

	/** A button that is only shown (and only works) while {@code shownIf} is true. */
	protected Button button(String label, int id, int bx, int by, int width, int height, @Nullable Predicate<Map<String, Object>> shownIf) {
		Button button = Button.builder(Component.literal(label), b -> {
			if (shownIf == null || is(shownIf))
				send(id);
		}).bounds(leftPos + bx, topPos + by, width, height).build();
		addRenderableWidget(button);
		if (shownIf != null)
			refresh.add(() -> button.visible = is(shownIf));
		return button;
	}

	/** Runs every frame before drawing, for state that follows the player's variables. */
	protected void onRefresh(Runnable runnable) {
		refresh.add(runnable);
	}

	/** A text field the procedures read back through {@code guistate.get("text:" + key)}. */
	@SuppressWarnings({"rawtypes", "unchecked"})
	protected EditBox textField(String key, int bx, int by, int width, Map guistate) {
		EditBox box = new EditBox(font, leftPos + bx, topPos + by, width, 20, Component.literal(""));
		box.setMaxLength(32767);
		guistate.put("text:" + key, box);
		addRenderableWidget(box);
		return box;
	}

	@Override
	public void extractRenderState(GuiGraphicsExtractor graphics, int mouseX, int mouseY, float partialTicks) {
		refresh.forEach(Runnable::run);
		super.extractRenderState(graphics, mouseX, mouseY, partialTicks);
	}

	@Override
	public void extractBackground(GuiGraphicsExtractor graphics, int mouseX, int mouseY, float partialTicks) {
		super.extractBackground(graphics, mouseX, mouseY, partialTicks);
		graphics.blitSprite(RenderPipelines.GUI_TEXTURED, PANEL, leftPos, topPos, imageWidth, imageHeight);
		background(graphics, mouseX, mouseY);
	}

	/** Draws on top of the panel; coordinates are relative to the panel, like labels. */
	protected void background(GuiGraphicsExtractor graphics, int mouseX, int mouseY) {
	}

	@Override
	protected void extractLabels(GuiGraphicsExtractor graphics, int mouseX, int mouseY) {
		graphics.text(font, title, 8, 6, TEXT, false);
		labels(graphics, mouseX, mouseY);
	}

	protected void labels(GuiGraphicsExtractor graphics, int mouseX, int mouseY) {
	}

	@Override
	public boolean keyPressed(KeyEvent event) {
		if (event.key() == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		if (getFocused() instanceof EditBox box && box.isFocused()) {
			box.keyPressed(event);
			return true;
		}
		return super.keyPressed(event);
	}

	// ------------------------------------------------------------------ drawing helpers (relative to the panel)

	protected void inset(GuiGraphicsExtractor graphics, int bx, int by, int width, int height) {
		graphics.blitSprite(RenderPipelines.GUI_TEXTURED, INSET, leftPos + bx, topPos + by, width, height);
	}

	/** A sunken box with a black inside, like the player preview of the inventory. */
	protected void darkInset(GuiGraphicsExtractor graphics, int bx, int by, int width, int height) {
		inset(graphics, bx, by, width, height);
		graphics.fill(leftPos + bx + 1, topPos + by + 1, leftPos + bx + width - 1, topPos + by + height - 1, 0xFF000000);
	}

	protected void texture(GuiGraphicsExtractor graphics, String name, int bx, int by, int width, int height) {
		Identifier texture = Identifier.fromNamespaceAndPath("naruto_shippuden", "textures/screens/" + name + ".png");
		graphics.blit(RenderPipelines.GUI_TEXTURED, texture, leftPos + bx, topPos + by, 0, 0, width, height, width, height);
	}

	/** An 18x18 slot holding a 16x16 icon; shows the name as a tooltip when hovered. */
	protected void iconSlot(GuiGraphicsExtractor graphics, @Nullable Icon icon, int bx, int by, int mouseX, int mouseY) {
		inset(graphics, bx, by, 18, 18);
		if (icon == null)
			return;
		texture(graphics, icon.texture(), bx + 1, by + 1, 16, 16);
		if (hovered(bx, by, 18, 18, mouseX, mouseY)) {
			graphics.fill(leftPos + bx + 1, topPos + by + 1, leftPos + bx + 17, topPos + by + 17, 0x80FFFFFF);
			graphics.setTooltipForNextFrame(Component.literal(icon.name()), mouseX, mouseY);
		}
	}

	protected boolean hovered(int bx, int by, int width, int height, int mouseX, int mouseY) {
		return mouseX >= leftPos + bx && mouseX < leftPos + bx + width && mouseY >= topPos + by && mouseY < topPos + by + height;
	}

	/** The icons whose procedures are currently true, in order. */
	protected List<Icon> shown(Icon[] icons) {
		List<Icon> list = new ArrayList<>();
		for (Icon icon : icons)
			if (is(icon.shown()))
				list.add(icon);
		return list;
	}

	protected @Nullable Icon first(Icon[] icons) {
		for (Icon icon : icons)
			if (is(icon.shown()))
				return icon;
		return null;
	}

	/** The player in a black box, following the mouse like in the inventory. */
	protected void playerPreview(GuiGraphicsExtractor graphics, int bx, int by, int width, int height, int mouseX, int mouseY) {
		darkInset(graphics, bx, by, width, height);
		InventoryScreen.extractEntityInInventoryFollowsMouse(graphics, leftPos + bx + 1, topPos + by + 1, leftPos + bx + width - 1,
				topPos + by + height - 1, 30, 0.0625F, mouseX, mouseY, entity);
	}

	/** The vanilla experience bar, cut to {@code width} (at most 182) instead of stretched. */
	protected void progressBar(GuiGraphicsExtractor graphics, int bx, int by, int width, float progress) {
		bar(graphics, XP_BACKGROUND, XP_PROGRESS, leftPos + bx, topPos + by, width, progress);
	}

	/** Draws a 182x5 bar sprite pair cut to {@code width}, keeping the right end cap. */
	public static void bar(GuiGraphicsExtractor graphics, Identifier background, Identifier progress, int left, int top, int width, float fraction) {
		graphics.blitSprite(RenderPipelines.GUI_TEXTURED, background, 182, 5, 0, 0, left, top, width - 1, 5);
		graphics.blitSprite(RenderPipelines.GUI_TEXTURED, background, 182, 5, 181, 0, left + width - 1, top, 1, 5);
		int filled = (int) (Math.max(0, Math.min(1, fraction)) * width);
		if (filled > 0)
			graphics.blitSprite(RenderPipelines.GUI_TEXTURED, progress, 182, 5, 0, 0, left, top, Math.min(filled, width - 1), 5);
		if (filled >= width)
			graphics.blitSprite(RenderPipelines.GUI_TEXTURED, progress, 182, 5, 181, 0, left + width - 1, top, 1, 5);
	}

	protected void text(GuiGraphicsExtractor graphics, String text, int tx, int ty) {
		graphics.text(font, text, tx, ty, TEXT, false);
	}

	protected void textRight(GuiGraphicsExtractor graphics, String text, int right, int ty) {
		graphics.text(font, text, right - font.width(text), ty, TEXT, false);
	}

	protected void textCentered(GuiGraphicsExtractor graphics, String text, int center, int ty, int color) {
		graphics.text(font, text, center - font.width(text) / 2, ty, color, false);
	}

	protected static String number(double value) {
		return String.valueOf((int) value);
	}

	/** MCreator stores some empty strings as a quoted {@code ""}; show those (and blanks) as {@code fallback}. */
	protected static String clean(@Nullable String value, String fallback) {
		if (value == null)
			return fallback;
		String trimmed = value.replace("\"", "").trim();
		return trimmed.isEmpty() ? fallback : trimmed;
	}
}
