package net.mcreator.narutoshippudenmod.gui;

import net.mcreator.narutoshippudenmod.NarutoShippudenMod;
import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables.PlayerVariables;
import net.mcreator.narutoshippudenmod.core.jutsu.CustomJutsu;
import net.mcreator.narutoshippudenmod.core.jutsu.CustomJutsu.Design;
import net.mcreator.narutoshippudenmod.core.jutsu.CustomJutsu.Form;
import net.mcreator.narutoshippudenmod.core.jutsu.engine.JutsuRank;
import net.mcreator.narutoshippudenmod.gui.JutsuCreationGuis.CreateJutsuGUIGui;

import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.Tooltip;
import net.minecraft.network.chat.Component;
import net.minecraft.util.FormattedCharSequence;
import net.minecraft.world.entity.player.Inventory;

import java.util.List;

/**
 * The Jutsu page of the info card: the player's custom jutsu (four slots) and the editor that makes one. A made jutsu goes on the
 * wheel of its release's technique (see {@link CustomJutsu}); its price, chakra and cooldown follow from its rank, shown live.
 */
public final class JutsuCreationScreens {
	private JutsuCreationScreens() {
	}

	/** What the editor is set to (kept while the page is reopened, e.g. after switching tabs). */
	private static String name = "";
	private static int release, form = Form.SPHERE.ordinal(), size = 1, speed = 1, power = 1;

	public static class CreateJutsuGUIGuiWindow extends ModScreen<CreateJutsuGUIGui.GuiContainerMod> {
		private static final int W = 300, H = 196;
		private boolean editing;
		private String shown = "";
		private EditBox nameBox;

		public CreateJutsuGUIGuiWindow(CreateJutsuGUIGui.GuiContainerMod container, Inventory inventory, Component text) {
			super(container, inventory, Component.literal("Custom Jutsu"), W, H, container.entity, container.x, container.y, container.z);
		}

		@Override
		protected void send(int id) {
			NarutoShippudenMod.PACKET_HANDLER.sendToServer(new CreateJutsuGUIGui.ButtonPressedMessage(id, x, y, z));
		}

		private List<Design> designs() {
			return CustomJutsu.designs(vars());
		}

		private List<String> releases() {
			return CustomJutsu.releases(vars());
		}

		/** The design as the editor has it now (null when the player has no release to make one with). */
		private Design design() {
			List<String> releases = releases();
			if (releases.isEmpty())
				return null;
			release = Math.floorMod(release, releases.size());
			return new Design(CustomJutsu.cleanName(name), releases.get(release), Form.values()[form], size, speed, power);
		}

		@Override
		protected void init() {
			super.init();
			pageTabs("jutsu");
			shown = vars().custom_jutsu + "/" + (int) vars().jp;
			if (editing)
				editor();
			else
				list();
		}

		private void list() {
			List<Design> designs = designs();
			for (int i = 0; i < designs.size(); i++) {
				int slot = i;
				Design design = designs.get(i);
				addRenderableWidget(Button.builder(Component.literal("Forget"), b -> action("forget_jutsu", "", slot))
						.bounds(leftPos + W - 8 - 4 - 52, topPos + 43 + i * 28, 52, 20)
						.tooltip(Tooltip.create(Component.literal("Gives back " + design.price() / 2 + " JP (half the price)"))).build());
			}
			Button create = Button.builder(Component.literal("Create Jutsu"), b -> {
				editing = true;
				rebuildWidgets();
			}).bounds(leftPos + 8, topPos + H - 8 - 20, 100, 20).build();
			create.active = designs.size() < CustomJutsu.SLOTS && !releases().isEmpty();
			if (!create.active)
				create.setTooltip(Tooltip.create(Component.literal(releases().isEmpty() ? "You need a chakra nature first" : "All slots are used")));
			addRenderableWidget(create);
		}

		private void editor() {
			nameBox = new EditBox(font, leftPos + 58, topPos + 40, W - 8 - 58, 20, Component.literal("Name"));
			nameBox.setMaxLength(CustomJutsu.NAME_LENGTH);
			nameBox.setValue(name);
			nameBox.setHint(Component.literal("Name your jutsu"));
			nameBox.setResponder(value -> name = value);
			addRenderableWidget(nameBox);
			setInitialFocus(nameBox);
			int rows = 5;
			for (int row = 0; row < rows; row++) {
				int r = row;
				addRenderableWidget(Button.builder(Component.literal("<"), b -> step(r, -1)).bounds(leftPos + 58, topPos + 64 + row * 20, 16, 18).build());
				addRenderableWidget(Button.builder(Component.literal(">"), b -> step(r, 1)).bounds(leftPos + 170, topPos + 64 + row * 20, 16, 18).build());
			}
			addRenderableWidget(Button.builder(Component.literal("Back"), b -> {
				editing = false;
				rebuildWidgets();
			}).bounds(leftPos + W - 8 - 60 - 4 - 60, topPos + H - 8 - 20, 60, 20).build());
			Button create = Button.builder(Component.literal("Create"), b -> {
				Design design = design();
				if (design != null) {
					action("custom_jutsu", design.encode(), 0);
					name = "";
					editing = false;
				}
			}).bounds(leftPos + W - 8 - 60, topPos + H - 8 - 20, 60, 20).build();
			addRenderableWidget(create);
			onRefresh(() -> {
				String problem = problem();
				create.active = problem == null;
				create.setTooltip(problem == null ? null : Tooltip.create(Component.literal(problem)));
			});
		}

		private String problem() {
			Design design = design();
			if (design == null)
				return "You need a chakra nature first";
			if (!CustomJutsu.learned(vars(), design.release()))
				return "Learn a jutsu from the " + design.releaseTitle() + " scroll first";
			if (design.name().isEmpty())
				return "Give the jutsu a name";
			if (designs().size() >= CustomJutsu.SLOTS)
				return "All slots are used";
			if (designs().stream().anyMatch(d -> d.name().equalsIgnoreCase(design.name())))
				return "You already have a jutsu called that";
			if (vars().jp < design.price())
				return "Not enough JP";
			return null;
		}

		private void step(int row, int by) {
			switch (row) {
				case 0 -> release += by;
				case 1 -> form = Math.floorMod(form + by, Form.values().length);
				case 2 -> size = Math.floorMod(size + by, CustomJutsu.SIZES.length);
				case 3 -> speed = Math.floorMod(speed + by, CustomJutsu.SPEEDS.length);
				default -> power = Math.floorMod(power - 1 + by, CustomJutsu.MAX_POWER) + 1;
			}
		}

		@Override
		public void extractRenderState(GuiGraphicsExtractor graphics, int mouseX, int mouseY, float partialTicks) {
			// the server answered (a jutsu made or forgotten, JP changed): show the new state
			String now = vars().custom_jutsu + "/" + (int) vars().jp;
			if (!now.equals(shown)) {
				// a jutsu made or forgotten goes back to the list; JP alone just refreshes
				if (!now.startsWith(vars().custom_jutsu + "/") || !shown.startsWith(vars().custom_jutsu + "/"))
					editing = false;
				rebuildWidgets();
			}
			super.extractRenderState(graphics, mouseX, mouseY, partialTicks);
		}

		@Override
		protected void background(GuiGraphicsExtractor graphics, int mouseX, int mouseY) {
			if (!editing) {
				for (int i = 0; i < CustomJutsu.SLOTS; i++)
					inset(graphics, 8, 40 + i * 28, W - 16, 26);
			} else {
				inset(graphics, 192, 64, W - 8 - 192, 98);
			}
		}

		@Override
		protected void labels(GuiGraphicsExtractor graphics, int mouseX, int mouseY) {
			PlayerVariables vars = vars();
			String jp = "JP: " + (int) vars.jp;
			graphics.text(font, jp, W - 8 - font.width(jp), 6, TEXT, false);
			if (editing)
				editorLabels(graphics, mouseX, mouseY);
			else
				listLabels(graphics);
		}

		private void listLabels(GuiGraphicsExtractor graphics) {
			List<Design> designs = designs();
			for (int i = 0; i < CustomJutsu.SLOTS; i++) {
				int y = 40 + i * 28;
				if (i >= designs.size()) {
					graphics.text(font, "Empty slot", 14, y + 9, 0xFFB0B0B0, true);
					continue;
				}
				Design design = designs.get(i);
				graphics.text(font, font.plainSubstrByWidth(design.name(), W - 16 - 70), 14, y + 4, 0xFFFFFFFF, true);
				String info = design.releaseTitle() + " · " + design.form().title + " · Rank " + design.rank();
				graphics.text(font, font.plainSubstrByWidth(info, W - 16 - 70), 14, y + 15, 0xFFD0D0D0, true);
			}
			graphics.text(font, "They join their release's wheel", 116, H - 8 - 14, MUTED, false);
		}

		private void editorLabels(GuiGraphicsExtractor graphics, int mouseX, int mouseY) {
			text(graphics, "Name", 8, 46);
			Design design = design();
			String[] names = { "Release", "Form", "Size", "Speed", "Power" };
			String[] values = design == null ? new String[] { "-", "-", "-", "-", "-" }
					: new String[] { design.releaseTitle(), design.form().title, CustomJutsu.SIZES[size], CustomJutsu.SPEEDS[speed], power + " / " + CustomJutsu.MAX_POWER };
			for (int row = 0; row < names.length; row++) {
				int y = 64 + row * 20;
				text(graphics, names[row], 8, y + 5);
				// a release not learned from its scroll yet is shown in red (Create says why)
				boolean unlearned = row == 0 && design != null && !CustomJutsu.learned(vars(), design.release());
				textCentered(graphics, values[row], 122, y + 5, unlearned ? 0xFFB02020 : TEXT);
			}
			if (design == null)
				return;
			JutsuRank rank = design.rank();
			int x = 197, y = 69;
			graphics.text(font, "Rank " + rank, x, y, 0xFFFFFF55, true);
			String[] lines = { design.price() + " JP", rank.chakra + " chakra", seconds(rank.cooldowns()[1]) + " cooldown", rank.ninjutsu + " Ninjutsu",
					String.format("%.0f damage", design.damage()) };
			for (int i = 0; i < lines.length; i++)
				graphics.text(font, lines[i], x, y + 12 + i * 10, i == 0 && vars().jp < design.price() ? 0xFFFF6060 : 0xFFE0E0E0, true);
			List<FormattedCharSequence> about = font.split(Component.literal(design.form().description), W - 8 - 192 - 10);
			for (int i = 0; i < Math.min(2, about.size()); i++)
				graphics.text(font, about.get(i), x, y + 68 + i * 10, 0xFFB0B0B0, true);
		}

		private static String seconds(int ticks) {
			return ticks % 20 == 0 ? ticks / 20 + "s" : String.format("%.1fs", ticks / 20.0);
		}
	}
}
