"""Translate the remapped 1.16.5 sources (official member names) toward NeoForge 26.3.

Stages: class renames (SRG class names -> Mojang 1.16.5 -> 26.3), then ordered regex code rules.
Re-runnable: always starts from the pristine remapped tree.
"""
import os, re, sys, shutil, collections

SRC = '/home/user/remap/src/main/java'
DST = '/home/user/Naruto-Shippuden/neoforge/src/main/java'
MC = '/home/user/mcsrc'
HERE = os.path.dirname(os.path.abspath(__file__))

# ---------------------------------------------------------------- class renames
classmap = dict(l.split() for l in open(os.path.join(HERE, 'classmap.txt')))

# 1.16.5 Mojang name (or Forge name) -> 26.3 name. None = drop the import (handled by code rules / compat layer).
MANUAL = {}
for line in open(os.path.join(HERE, 'manual_classes.txt')):
    line = line.split('#')[0].strip()
    if line:
        a, b = line.split()
        MANUAL[a] = None if b == '-' else b

mc_by_simple = collections.defaultdict(list)
for root, _, files in os.walk(os.path.join(MC, 'net')):
    for f in files:
        if f.endswith('.java'):
            mc_by_simple[f[:-5]].append(os.path.join(root, f)[len(MC) + 1:-5].replace('/', '.'))


def exists_26(fqn):
    return os.path.exists(os.path.join(MC, fqn.replace('.', '/') + '.java'))


def target_class(fqn):
    """Final 26.3 name for an imported class, or None if it must be dropped."""
    if fqn in MANUAL:
        return MANUAL[fqn]
    m = classmap.get(fqn, fqn)
    if m in MANUAL:
        return MANUAL[m]
    if not m.startswith('net.minecraft') or exists_26(m):
        return m
    cands = mc_by_simple.get(m.rsplit('.', 1)[1], [])
    if len(cands) == 1:
        return cands[0]
    return m  # left for the compiler to report


IMPORT_RE = re.compile(r'^import ([\w.]+);[ \t]*\r?$', re.M)


def rename_classes(text):
    renames = {}
    new_imports = []

    def on_import(m):
        fqn = m.group(1)
        if not re.match(r'(net\.minecraft|com\.mojang)', fqn):
            return m.group(0)
        tgt = target_class(fqn)
        if tgt is None:
            return ''
        old_simple, new_simple = fqn.rsplit('.', 1)[1], tgt.rsplit('.', 1)[1]
        if old_simple != new_simple:
            renames[old_simple] = new_simple
        return 'import %s;' % tgt

    text = IMPORT_RE.sub(on_import, text)
    # inline fully-qualified references
    def on_fqn(m):
        tgt = target_class(m.group(0))
        return tgt if tgt else m.group(0)
    text = re.sub(r'\bnet\.minecraft(?:forge)?(?:\.[a-z]\w*)+\.[A-Z]\w*', on_fqn, text)
    if renames:
        body_start = text.find('\n', max((m.end() for m in IMPORT_RE.finditer(text)), default=0))
        head, body = text[:body_start], text[body_start:]
        pat = re.compile(r'(?<![\w.])(' + '|'.join(map(re.escape, sorted(renames, key=len, reverse=True))) + r')\b')
        body = pat.sub(lambda m: renames[m.group(1)], body)
        text = head + body
    return text


# ---------------------------------------------------------------- code rules
RULES = []  # (compiled regex, replacement, flags-applied) loaded from rules.py
sys.path.insert(0, HERE)
import rules  # noqa: E402


NESTED = [l.split() for l in open(os.path.join(HERE, 'nested.txt')) if l.strip()]
NESTED_RE = re.compile(r'\b(' + '|'.join(sorted({re.escape(o) for o, _, _ in NESTED}, key=len, reverse=True)) + r')\.(\w+)\b')
NESTED_MAP = {(o, i): n for o, i, n in NESTED}


def rename_nested(text):
    return NESTED_RE.sub(lambda m: m.group(1) + '.' + NESTED_MAP.get((m.group(1), m.group(2)), m.group(2)), text)


import renderers  # noqa: E402


def transform(path, text):
    text = text.replace('\r\n', '\n')
    if path.startswith('net/mcreator/narutoshippudenmod/entity/renderer/'):
        text = renderers.convert_renderer_group(path, text)
        return text.replace('MathHelper.', 'Mth.')
    text = rename_classes(text)
    text = rename_nested(text)
    for rule in rules.RULES:
        text = rule(path, text)
    for suffix, fn in POST.items():
        if path.endswith(suffix):
            text = fn(path, text)
    return text


import effects  # noqa: E402
import armor  # noqa: E402
import gui  # noqa: E402
import blocks  # noqa: E402
import particles  # noqa: E402
import keybinds  # noqa: E402
import itemgroups  # noqa: E402
import structures  # noqa: E402
import overlay  # noqa: E402

POST = {
    'potion/ModEffects.java': effects.convert,
    'item/ArmorItems.java': armor.convert,
    'block/ModBlocks.java': blocks.convert,
    'particle/ModParticles.java': particles.convert,
    'keybind/ModKeyBindings.java': keybinds.convert,
    'itemgroup/ModItemGroups.java': itemgroups.convert,
    'world/structure/KamuiTowerStructures.java': structures.convert,
    'gui/overlay/ChakraBarOverlay.java': overlay.convert,
    'Screens.java': gui.convert_screens,
    'Guis.java': gui.convert_menus,
}


def client_hub():
    regs = sorted(set(renderers.RENDERER_CLASSES))
    lines = ['package net.mcreator.narutoshippudenmod.client;', '',
             'import net.mcreator.narutoshippudenmod.entity.renderer.*;',
             'import net.neoforged.api.distmarker.Dist;', 'import net.neoforged.bus.api.SubscribeEvent;',
             'import net.neoforged.fml.common.EventBusSubscriber;', 'import net.neoforged.neoforge.client.event.EntityRenderersEvent;',
             'import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;',
             'import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;',
             'import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;',
             'import net.mcreator.narutoshippudenmod.gui.*;'] + ['import net.mcreator.narutoshippudenmod.gui.%s.*;' % g for g in
             sorted(f[:-5] for f in os.listdir(os.path.join(SRC, 'net/mcreator/narutoshippudenmod/gui')) if f.endswith('.java'))] + ['',
             '/** Client-side registration: entity renderers, model layers and item extensions. */',
             '@EventBusSubscriber(modid = "naruto_shippuden", value = Dist.CLIENT)', 'public final class ModClient {', '\tprivate ModClient() {', '\t}', '',
             '\t@SubscribeEvent', '\tpublic static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {']
    lines += ['\t\t%s.registerRenderers(event);' % r for r in regs]
    lines += ['\t}', '', '\t@SubscribeEvent', '\tpublic static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {']
    lines += ['\t\t%s.registerLayers(event);' % r for r in regs]
    lines += ['\t\tArmorModels.registerLayers(event);', '\t}', '', '\t@SubscribeEvent',
              '\tpublic static void registerParticles(RegisterParticleProvidersEvent event) {', '\t\tModParticleProviders.register(event);', '\t}', '',
              '\t@SubscribeEvent', '\tpublic static void registerScreens(RegisterMenuScreensEvent event) {']
    lines += ['\t\tevent.register(%s.containerType, %s::new);' % (g, w) for g, w in gui.SCREENS]
    lines += ['\t}', '', '\t@SubscribeEvent',
              '\tpublic static void registerExtensions(RegisterClientExtensionsEvent event) {', '\t\tArmorModels.registerExtensions(event);', '\t}', '}']
    return '\n'.join(lines) + '\n'


def main():
    if os.path.exists(DST):
        shutil.rmtree(DST)
    n = 0
    for root, _, files in os.walk(SRC):
        for f in files:
            if not f.endswith('.java'):
                continue
            src = os.path.join(root, f)
            rel = os.path.relpath(src, SRC)
            if rel in rules.SKIP:
                continue
            out = os.path.join(DST, rel)
            os.makedirs(os.path.dirname(out), exist_ok=True)
            text = transform(rel, open(src, encoding='utf-8').read())
            # @OnlyIn no longer strips anything and NeoForge reports every use
            text = re.sub(r'^[ \t]*@OnlyIn\(Dist\.CLIENT\)[ \t]*\n', '', text, flags=re.M)
            text = re.sub(r'@OnlyIn\(Dist\.CLIENT\)\s*', '', text)
            open(out, 'w', encoding='utf-8').write(text)
            n += 1
    # generated client registration
    base = os.path.join(DST, 'net/mcreator/narutoshippudenmod/client')
    os.makedirs(base, exist_ok=True)
    no_only_in = lambda t: re.sub(r'@OnlyIn\(Dist\.CLIENT\)\s*', '', t)
    open(os.path.join(base, 'ArmorModels.java'), 'w').write(no_only_in(armor.client_file()))
    open(os.path.join(base, 'ModParticleProviders.java'), 'w').write(no_only_in(particles.client_file()))
    open(os.path.join(base, 'ModKeyMappings.java'), 'w').write(keybinds.client_file())
    open(os.path.join(base, 'ModClient.java'), 'w').write(client_hub())
    # hand-written files override / add
    over = os.path.join(HERE, 'override')
    for root, _, files in os.walk(over):
        for f in files:
            src = os.path.join(root, f)
            out = os.path.join(DST, os.path.relpath(src, over))
            os.makedirs(os.path.dirname(out), exist_ok=True)
            shutil.copy(src, out)
            n += 1
    print('wrote', n, 'files')
    import resources
    resources.build()


if __name__ == '__main__':
    main()
