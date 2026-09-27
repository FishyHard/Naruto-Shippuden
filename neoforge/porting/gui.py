"""GUI screens (gui/*Screens.java) and menus (gui/*Guis.java) for 26.3."""
import re
from rules import find_block, split_header, method_blocks

SCREENS = []  # (menu element class, screen class)


def split_args(s):
    """Split a call's argument text on top-level commas."""
    out, depth, cur, i = [], 0, '', 0
    while i < len(s):
        c = s[i]
        if c == '"':
            j = i + 1
            while s[j] != '"':
                j += 2 if s[j] == '\\' else 1
            cur += s[i:j + 1]
            i = j + 1
            continue
        if c in '([{':
            depth += 1
        elif c in ')]}':
            depth -= 1
        if c == ',' and depth == 0:
            out.append(cur.strip())
            cur = ''
        else:
            cur += c
        i += 1
    if cur.strip():
        out.append(cur.strip())
    return out


def color(expr):
    try:
        v = int(expr)
        if v >= 0:
            return '0x%08X' % (v | 0xFF000000)
    except ValueError:
        pass
    return expr


def convert_screens(path, text):
    head, body = split_header(text)
    # size moves into the super constructor
    def ctor(m):
        blk = m.group(0)
        w = re.search(r'this\.imageWidth = (\d+);', blk)
        h = re.search(r'this\.imageHeight = (\d+);', blk)
        if w and h:
            blk = re.sub(r'\n\s*this\.imageWidth = \d+;', '', blk)
            blk = re.sub(r'\n\s*this\.imageHeight = \d+;', '', blk)
            blk = blk.replace('super(container, inventory, text);', 'super(container, inventory, text, %s, %s);' % (w.group(1), h.group(1)))
        return blk
    body = re.sub(r'public \w+GuiWindow\(\w+\.GuiContainerMod container, Inventory inventory,\s*Component text\) \{.*?\n\t\t\}', ctor, body, flags=re.S)
    # the base screen draws background, widgets and tooltips
    body = method_blocks(body, r'@Override\s*\n\s*public void render\(PoseStack \w+, int \w+, int \w+, float \w+\)\s*\{', lambda m, b: '')

    def bg(m, b):
        b = re.sub(r'\n\s*RenderSystem\.\w+\([^;]*\);', '', b)
        b = re.sub(r'Minecraft\.getInstance\(\)\.getTextureManager\(\)\s*\.bind\(([^;]*)\);', r'_tex = \1;', b)
        b = re.sub(r'this\.blit\(\w+, ', 'graphics.blit(RenderPipelines.GUI_TEXTURED, _tex, ', b)
        return ('@Override\n\t\tpublic void extractBackground(GuiGraphicsExtractor graphics, int gx, int gy, float partialTicks) {\n'
                '\t\t\tsuper.extractBackground(graphics, gx, gy, partialTicks);\n\t\t\tIdentifier _tex = null;' + b)
    body = method_blocks(body, r'@Override\s*\n\s*protected void renderBg\(PoseStack \w+, float \w+, int \w+, int \w+\)\s*\{', bg)

    def labels(m, b):
        def draw(mm):
            args = split_args(mm.group(1))
            return 'graphics.text(this.font, %s, %s, %s, %s, false);' % (args[1], args[2], args[3], color(args[4]))
        b = re.sub(r'this\.font\.draw\((.*?)\);(?=\s*\n)', draw, b, flags=re.S)
        return '@Override\n\t\tprotected void extractLabels(GuiGraphicsExtractor graphics, int mouseX, int mouseY) {' + b
    body = method_blocks(body, r'@Override\s*\n\s*protected void renderLabels\(PoseStack \w+, int \w+, int \w+\)\s*\{', labels)

    def keys(m, b):
        key, b1, c1 = m.groups()
        b = b.replace('super.keyPressed(%s, %s, %s)' % (key, b1, c1), 'super.keyPressed(event)')
        b = re.sub(r'(\w+)\.keyPressed\(%s, %s, %s\)' % (key, b1, c1), r'\1.keyPressed(event)', b)
        return '@Override\n\t\tpublic boolean keyPressed(KeyEvent event) {\n\t\t\tint %s = event.key();' % key + b
    body = method_blocks(body, r'@Override\s*\n\s*public boolean keyPressed\(int (\w+), int (\w+), int (\w+)\)\s*\{', keys)

    def tick(m, b):
        return m.group(0).replace('public void tick()', 'protected void containerTick()') + re.sub(r'\n\s*\w+\.tick\(\);', '', b).replace('super.tick();', 'super.containerTick();')
    body = method_blocks(body, r'public void tick\(\)\s*\{', tick)
    body = re.sub(r'\n\s*(?:Minecraft\.getInstance\(\)|minecraft)\.keyboardHandler\.setSendRepeatsToGui\(\w+\);', '', body)

    counter = [0]

    def init(m, b):
        b = b.replace('super.init(minecraft, width, height);', 'super.init();')
        b = re.sub(r'this\.children\.add\(([\w.]+)\);', r'this.addRenderableWidget(\1);', b)
        out, pos = [], 0
        for bm in re.finditer(r'this\.addButton\(new Button\(', b):
            if bm.start() < pos:
                continue
            i = bm.end()
            depth = 1
            j = i
            while depth:
                c = b[j]
                if c == '"':
                    j = b.index('"', j + 1)
                elif c == '(':
                    depth += 1
                elif c == ')':
                    depth -= 1
                j += 1
            args = split_args(b[i:j - 1])
            x, y, w, h, label, action = args[0], args[1], args[2], args[3], args[4], ', '.join(args[5:])
            build = 'Button.builder(%s, %s).bounds(%s, %s, %s, %s).build()' % (label, action, x, y, w, h)
            out.append(b[pos:bm.start()])
            if b[j:j + 2] == ' {':
                anon_end = find_block(b, j)
                anon = b[j:anon_end]
                cond = re.search(r'if \((.*?)\)\s*super\.render\(', anon, re.S)
                counter[0] += 1
                var = '_button%d' % counter[0]
                out.append('Button %s = %s;\n\t\t\tthis.addRenderableWidget(%s);\n\t\t\t_visibility.add(() -> %s.visible = %s)'
                           % (var, build, var, var, cond.group(1) if cond else 'true'))
                pos = anon_end + 1 if b[anon_end] == ')' else anon_end
            else:
                out.append('this.addRenderableWidget(%s)' % build)
                pos = j + 1 if b[j] == ')' else j
        out.append(b[pos:])
        return '@Override\n\t\tprotected void init() {' + ''.join(out)
    body = method_blocks(body, r'@Override\s*\n\s*public void init\(Minecraft \w+, int \w+, int \w+\)\s*\{', init)
    # screens with conditional buttons: refresh visibility every frame
    def add_visibility(m):
        blk = m.group(0)
        if '_visibility.add(' not in blk:
            return blk
        return blk.replace('{', '''{
		private final java.util.List<Runnable> _visibility = new java.util.ArrayList<>();

		@Override
		public void extractRenderState(GuiGraphicsExtractor graphics, int mouseX, int mouseY, float partialTicks) {
			_visibility.forEach(Runnable::run);
			super.extractRenderState(graphics, mouseX, mouseY, partialTicks);
		}
''', 1)
    out, pos = [], 0
    for sm in re.finditer(r'public static class \w+GuiWindow extends AbstractContainerScreen<[\w.]+> \{', body):
        e = find_block(body, sm.start())
        out.append(body[pos:sm.start()])
        out.append(add_visibility(re.match(r'(?s).*', body[sm.start():e])))
        pos = e
    out.append(body[pos:])
    body = ''.join(out)
    imports = ['net.minecraft.client.gui.GuiGraphicsExtractor', 'net.minecraft.client.renderer.RenderPipelines', 'net.minecraft.client.input.KeyEvent',
               'net.minecraft.resources.Identifier', 'net.minecraft.client.gui.components.Button']
    have = set(re.findall(r'^import ([\w.]+);', head, re.M))
    head = head.rstrip('\n') + '\n' + ''.join('import %s;\n' % i for i in imports if i not in have) + '\n'
    return head + body


def convert_menus(path, text):
    head, body = split_header(text)
    body = body.replace('private static MenuType<GuiContainerMod> containerType = null;', 'public static MenuType<GuiContainerMod> containerType = null;')
    body = body.replace('containerType = new MenuType<>(new GuiContainerModFactory());', 'containerType = IMenuTypeExtension.create(new GuiContainerModFactory());')

    def handler(m):
        name = re.search(r'setRegistryName\("(\w+)"\)', m.group(0)).group(1)
        return m.group(0)
    names = {}
    for m in re.finditer(r'public static class (\w+Gui) extends NarutoShippudenModElements\.ModElement \{', body):
        blk = body[m.start():find_block(body, m.start())]
        n = re.search(r'containerType\.setRegistryName\("(\w+)"\)', blk)
        scr = re.search(r'MenuScreens\.register\(containerType, (\w+)::new\)', blk)
        if n:
            names[m.group(1)] = n.group(1)
        if scr:
            SCREENS.append((m.group(1), scr.group(1)))
    for cls, name in names.items():
        body = re.sub(r'(public static class %s extends NarutoShippudenModElements\.ModElement \{.*?)(?:NarutoShippudenMod\.MOD_BUS\.register\(new ContainerRegisterHandler\(\)\)|Registration\.listen\(NarutoShippudenMod\.MOD_BUS, new ContainerRegisterHandler\(\)\));' % cls,
                      lambda m: m.group(1) + 'Registration.add(Registries.MENU, "%s", () -> containerType, null);' % name, body, count=1, flags=re.S)
    body = re.sub(r'\n\s*public static class ContainerRegisterHandler \{.*?\n\t\t\}\n', '\n', body, flags=re.S)
    body = re.sub(r'\n\s*@OnlyIn\(Dist\.CLIENT\)\s*\n\s*public void initElements\(\) \{\s*DeferredWorkQueue\.runLater\([^;]*\);\s*\}', '', body)
    body = body.replace('public GuiContainerMod create(int id, Inventory inv, FriendlyByteBuf extraData)',
                        'public GuiContainerMod create(int id, Inventory inv, net.minecraft.network.RegistryFriendlyByteBuf extraData)')
    body = re.sub(r'\n\s*private IItemHandler internal;', '', body)
    body = re.sub(r'\n\s*this\.internal = new ItemStackHandler\(\d+\);', '', body)
    if 'quickMoveStack' not in body:
        body = body.replace('''			@Override
			public boolean stillValid(Player player) {
				return true;
			}''', '''			@Override
			public boolean stillValid(Player player) {
				return true;
			}

			@Override
			public ItemStack quickMoveStack(Player player, int index) {
				return ItemStack.EMPTY;
			}''')
    imports = ['net.neoforged.neoforge.common.extensions.IMenuTypeExtension', 'net.minecraft.core.registries.Registries',
               'net.mcreator.narutoshippudenmod.compat.Registration', 'net.minecraft.world.item.ItemStack']
    have = set(re.findall(r'^import ([\w.]+);', head, re.M))
    head = head.rstrip('\n') + '\n' + ''.join('import %s;\n' % i for i in imports if i not in have) + '\n'
    return head + body
