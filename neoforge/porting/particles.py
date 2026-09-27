"""particle/ModParticles.java -> common particle types + client/ModParticleProviders.java."""
import re
from rules import find_block, split_header

CLIENT = []  # (particle class, client code)
CLIENT_IMPORTS = set()


def convert(path, text):
    head, body = split_header(text)
    common = []
    names = []
    for m in re.finditer(r'(?:@Mod\.EventBusSubscriber\([^)]*\)\s*\n\s*)?public static class (\w+Particle) \{', body):
        cls = m.group(1)
        start = body.index('public static class', m.start())
        block = body[start:find_block(body, start)]
        name = re.search(r'setRegistryName\("(\w+)"\)', block).group(1)
        names.append(cls)
        cs = block.index('private static class CustomParticle')
        cs = block.rindex('@OnlyIn', 0, cs)
        client = block[cs:block.rindex('}')]
        client = client.replace('private static class', 'static class')
        client = re.sub(r'super\((\w+), (\w+), (\w+), (\w+)\);', r'super(\1, \2, \3, \4, spriteSet.first());', client)
        client = re.sub(r'public ParticleRenderType getRenderType\(\) \{\s*return ParticleRenderType\.(\w+);\s*\}',
                        lambda mm: 'public SingleQuadParticle.Layer getLayer() {\n\t\t\t\treturn SingleQuadParticle.Layer.%s;\n\t\t\t}'
                        % ('TRANSLUCENT' if 'TRANSLUCENT' in mm.group(1) else 'OPAQUE'), client)
        client = re.sub(r'(double \w+Speed,?\s*double \w+Speed,?\s*double \w+Speed)\)', r'\1, RandomSource random)', client)
        client = re.sub(r'(double \w+, double \w+, double \w+, double \w+, double \w+,\s*double \w+)\) \{\s*return new CustomParticle', r'\1, RandomSource random) {\n\t\t\t\treturn new CustomParticle', client)
        client = client.replace('getLightColor(float', 'getLightCoords(float')
        client = re.sub(r'this\.pickSprite\((\w+)\);', r'this.setSprite(\1.get(this.random));', client)
        CLIENT.append((cls, client))
        common.append('\tpublic static class %s {\n\t\tpublic static SimpleParticleType particle;\n\n\t\tstatic void register() {\n'
                      '\t\t\tRegistration.add(Registries.PARTICLE_TYPE, "%s", () -> new SimpleParticleType(false), h -> particle = (SimpleParticleType) h.value());\n'
                      '\t\t}\n\t}' % (cls, name))
    for imp in re.findall(r'^import ([\w.]+);', head, re.M):
        CLIENT_IMPORTS.add(imp)
    out = ('package net.mcreator.narutoshippudenmod.particle;\n\nimport net.minecraft.core.particles.SimpleParticleType;\n'
           'import net.minecraft.core.registries.Registries;\nimport net.mcreator.narutoshippudenmod.compat.Registration;\n\n'
           'public final class ModParticles {\n\tprivate ModParticles() {\n\t}\n\n\tpublic static void register() {\n'
           + ''.join('\t\t%s.register();\n' % c for c in names) + '\t}\n\n' + '\n\n'.join(common) + '\n}\n')
    return out


def client_file():
    imports = sorted(i for i in CLIENT_IMPORTS if not i.startswith('net.neoforged.fml.common.Mod') and 'RegistryEvent' not in i)
    imports += ['net.minecraft.client.particle.SingleQuadParticle', 'net.minecraft.util.RandomSource',
                'net.mcreator.narutoshippudenmod.particle.ModParticles', 'net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent']
    lines = ['package net.mcreator.narutoshippudenmod.client;', ''] + ['import %s;' % i for i in sorted(set(imports))] + ['',
             '/** Particle behaviour and providers (client only). */', '@OnlyIn(Dist.CLIENT)', 'public final class ModParticleProviders {',
             '\tprivate ModParticleProviders() {', '\t}', '', '\tpublic static void register(RegisterParticleProvidersEvent event) {']
    lines += ['\t\tevent.registerSpriteSet(ModParticles.%s.particle, %s.CustomParticleFactory::new);' % (c, c) for c, _ in CLIENT]
    lines.append('\t}')
    for c, code in CLIENT:
        lines += ['', '\tstatic class %s {' % c, '\t\t' + code.strip(), '\t}']
    lines.append('}')
    return '\n'.join(lines) + '\n'
