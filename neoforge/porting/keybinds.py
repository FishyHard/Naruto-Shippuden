"""keybind/ModKeyBindings.java: keep messages + press actions (common), move key mappings and input handling to client/ModKeyMappings.java."""
import re
from rules import find_block, split_header, for_each_element

CLIENT = []  # (element class, key name, key code, client fields, onKey body)


def convert(path, text):
    head, body = split_header(text)

    def per_element(block):
        cls = re.search(r'public static class (\w+) extends', block).group(1)
        km = re.search(r'keys = new KeyMapping\("([^"]*)", ((?:GLFW|InputConstants)\.\w+), "[^"]*"\);', block)
        ki = re.search(r'public void onKeyInput\(InputEvent\.KeyInputEvent event\)\s*\{', block)
        if not km or not ki:
            return block
        on_key = block[ki.end():find_block(block, ki.start()) - 1]
        fields = re.findall(r'\n\s*private (long|int|boolean|double) (\w+)( = [^;]+)?;', block)
        on_key = re.sub(r'new KeyBindingPressedMessage\(', 'new %s.KeyBindingPressedMessage(' % cls, on_key)
        on_key = re.sub(r'(?<![\w.])pressAction\(', '%s.pressAction(' % cls, on_key)
        key_name = km.group(1) or 'key.naruto_shippuden.' + cls[:-len('KeyBinding')].lower()
        CLIENT.append((cls, key_name, km.group(2), fields, on_key))
        # drop client parts from the common element
        block = re.sub(r'\n\s*@OnlyIn\(Dist\.CLIENT\)\s*\n\s*private KeyMapping keys;', '', block)
        block = re.sub(r'\n\s*@Override\s*\n\s*@OnlyIn\(Dist\.CLIENT\)\s*\n\s*public void initElements\(\) \{.*?\n\t\t\}', '', block, flags=re.S)
        mk = re.search(r'\n\s*@SubscribeEvent\s*\n\s*@OnlyIn\(Dist\.CLIENT\)\s*\n\s*public void onKeyInput\(InputEvent\.KeyInputEvent event\)\s*\{', block)
        block = block[:mk.start()] + block[find_block(block, mk.start()):]
        for t, n, _ in fields:
            block = re.sub(r'\n\s*private %s %s( = [^;]+)?;' % (t, n), '', block)
        block = block.replace('private static void pressAction(', 'public static void pressAction(')
        return block

    body = for_each_element(body, per_element)
    return head + body


def client_file():
    lines = ['package net.mcreator.narutoshippudenmod.client;', '',
             'import net.mcreator.narutoshippudenmod.NarutoShippudenMod;',
             'import net.mcreator.narutoshippudenmod.keybind.ModKeyBindings.*;',
             'import com.mojang.blaze3d.platform.InputConstants;',
             'import net.minecraft.client.KeyMapping;', 'import net.minecraft.client.Minecraft;',
             'import net.neoforged.api.distmarker.Dist;', 'import net.neoforged.bus.api.SubscribeEvent;',
             'import net.neoforged.fml.common.EventBusSubscriber;', 'import net.neoforged.neoforge.client.event.InputEvent;',
             'import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;', '',
             '/** The mod\'s key mappings and what pressing them does on the client (the server side is in ModKeyBindings). */',
             '@EventBusSubscriber(modid = "naruto_shippuden", value = Dist.CLIENT)', 'public final class ModKeyMappings {',
             '\tprivate ModKeyMappings() {', '\t}', '']
    for cls, name, code, fields, on_key in CLIENT:
        lines.append('\tstatic final KeyMapping %s = new KeyMapping("%s", %s, KeyMapping.Category.MISC);' % (cls.upper(), name, code))
        for t, n, init in fields:
            lines.append('\tprivate static %s %s_%s%s;' % (t, cls, n, init or ''))
    lines += ['', '\t@SubscribeEvent', '\tpublic static void register(RegisterKeyMappingsEvent event) {']
    lines += ['\t\tevent.register(%s);' % cls.upper() for cls, _, _, _, _ in CLIENT]
    lines += ['\t}', '', '\t@SubscribeEvent', '\tpublic static void onKey(InputEvent.Key event) {']
    lines += ['\t\ton%s(event);' % cls for cls, _, _, _, _ in CLIENT]
    lines.append('\t}')
    for cls, name, code, fields, on_key in CLIENT:
        body = on_key.replace('keys.', '%s.' % cls.upper())
        for t, n, _ in fields:
            body = re.sub(r'(?<![\w.])%s\b' % n, '%s_%s' % (cls, n), body)
        lines += ['', '\tprivate static void on%s(InputEvent.Key event) {' % cls, body.rstrip(), '\t}']
    lines.append('}')
    return '\n'.join(lines) + '\n'
