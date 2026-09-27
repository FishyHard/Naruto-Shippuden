"""Rewrite entity/renderer/* group files: converted models + generated 26.3 renderer registration."""
import re
import models

RENDERER_CLASSES = []  # fully qualified-ish names "Group.XRenderer" collected for the client registry


def convert_renderer_group(path, text):
    group = path.rsplit('/', 1)[1][:-5]
    out = []
    pos = 0
    for m in re.finditer(r'(?m)^\t(?:@OnlyIn\(Dist\.CLIENT\)\n\t)?public static class (\w+Renderer) \{', text):
        start = m.start()
        end = models.find_block(text, text.index('public static class', start))
        name = m.group(1)
        block = text[start:end]
        out.append(text[pos:start])
        out.append(convert_renderer(group, name, block))
        pos = end
        RENDERER_CLASSES.append(group + '.' + name)
    out.append(text[pos:])
    text = ''.join(out)
    # header: replace imports wholesale; the rewritten classes only need these
    body = text[text.index('public final class'):]
    header = 'package net.mcreator.narutoshippudenmod.entity.renderer;\n\n' + CLIENT_IMPORTS + '\n'
    return header + body


CLIENT_IMPORTS = '\n'.join('import %s;' % i for i in [
    'net.minecraft.client.model.EntityModel', 'net.minecraft.client.model.geom.ModelLayerLocation', 'net.minecraft.client.model.geom.ModelPart',
    'net.minecraft.client.model.geom.PartPose', 'net.minecraft.client.model.geom.builders.CubeDeformation',
    'net.minecraft.client.model.geom.builders.CubeListBuilder', 'net.minecraft.client.model.geom.builders.LayerDefinition',
    'net.minecraft.client.model.geom.builders.MeshDefinition', 'net.minecraft.client.model.geom.builders.PartDefinition',
    'net.minecraft.client.renderer.entity.state.EntityRenderState', 'net.minecraft.client.renderer.entity.state.LivingEntityRenderState',
    'net.minecraft.resources.Identifier', 'net.minecraft.util.Mth', 'net.neoforged.api.distmarker.Dist', 'net.neoforged.api.distmarker.OnlyIn',
    'net.neoforged.neoforge.client.event.EntityRenderersEvent', 'net.mcreator.narutoshippudenmod.client.ModRenderers',
]) + '\n' + '\n'.join('import net.mcreator.narutoshippudenmod.%s.%s.*;' % (pkg, f[:-5])
                         for pkg in ('entity', 'item')
                         for f in sorted(__import__('os').listdir('/home/user/remap/src/main/java/net/mcreator/narutoshippudenmod/' + pkg))
                         if f.endswith('.java'))


def tex(s):
    return 'Identifier.parse("%s")' % s


def convert_renderer(group, name, block):
    converted, model_names = models.convert_all(block, group + '_' + name[:-len('Renderer')])
    regs = []
    # plain mob renderer with a custom model
    for m in re.finditer(r'registerEntityRenderingHandler\(([\w.]+),\s*\w+ -> \{\s*return new MobRenderer\(\w+, new (\w+)\(\), ([\d.]+)f\) \{'
                         r'.*?return new (?:ResourceLocation|Identifier)\("([^"]+)"\);', block, re.S):
        ent, model, shadow, texture = m.groups()
        regs.append('ModRenderers.mob(event, %s, %s.LAYER, %s::new, %sF, %s);' % (ent, model, model, shadow, tex(texture)))
    # humanoid renderer (default player-shaped model), optionally with an armor layer
    for m in re.finditer(r'registerEntityRenderingHandler\(([\w.]+),\s*\w+ -> \{\s*BipedRenderer customRender = new BipedRenderer\(\w+, new \w+\(0\), ([\d.]+)f\) \{'
                         r'.*?return new (?:ResourceLocation|Identifier)\("([^"]+)"\);.*?return customRender;', block, re.S):
        ent, shadow, texture = m.groups()
        armor = 'BipedArmorLayer' in m.group(0) or 'HumanoidArmorLayer' in m.group(0)
        regs.append('ModRenderers.humanoid(event, %s, %sF, %s, %s);' % (ent, shadow, tex(texture), 'true' if armor else 'false'))
    # projectile renderer drawing a model rotated to the flight direction
    for m in re.finditer(r'registerEntityRenderingHandler\(([\w.]+),\s*\w+ -> new CustomRender\(\w+\)\)', block):
        ent = m.group(1)
        cr = re.search(r'class CustomRender extends EntityRenderer<[\w.]+> \{.*?new (?:ResourceLocation|Identifier)\("([^"]+)"\).*?EntityModel model = new (\w+)\(\);', block, re.S)
        texture, model = cr.groups()
        regs.append('ModRenderers.projectile(event, %s, %s.LAYER, %s::new, %s);' % (ent, model, model, tex(texture)))
    for m in re.finditer(r'registerEntityRenderingHandler\(([\w.]+),\s*\w+ -> new SpriteRenderer\(', block):
        regs.append('ModRenderers.sprite(event, %s);' % m.group(1))
    if not regs:
        raise ValueError('no renderer registration recognised in ' + name)
    lines = ['\t@OnlyIn(Dist.CLIENT)', '\tpublic static class %s {' % name,
             '\t\tpublic static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {']
    lines += ['\t\t\t' + r for r in regs]
    lines += ['\t\t}', '', '\t\tpublic static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {']
    lines += ['\t\t\tevent.registerLayerDefinition(%s.LAYER, %s::createBodyLayer);' % (mn, mn) for mn in model_names]
    lines += ['\t\t}']
    # keep only the converted model classes from the old block
    for mn in model_names:
        mm = re.search(r'public static class %s extends EntityModel<EntityRenderState> \{' % mn, converted)
        s = mm.start()
        e = models.find_block(converted, s)
        lines.append('')
        lines.append('\t\t' + converted[s:e].replace('\n\t\t\t', '\n\t\t').replace('\n\t\t', '\n\t\t'))
    lines.append('\t}')
    return '\n'.join(lines)
