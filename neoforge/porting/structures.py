"""world/structure/KamuiTowerStructures.java -> 26.3 Features; placement goes to data json (see resources step)."""
import re
from rules import find_block, split_header

FEATURES = []  # feature names needing configured/placed feature + biome modifier json


def convert(path, text):
    head, body = split_header(text)
    out = []
    names = []
    for m in re.finditer(r'public static class (\w+Structure) \{', body):
        cls = m.group(1)
        block = body[m.start():find_block(body, m.start())]
        name = re.search(r'feature\.setRegistryName\("(\w+)"\)', block).group(1)
        pm = re.search(r'public boolean place\(WorldGenLevel world, ChunkGenerator generator, RandomSource random, BlockPos pos, NoneFeatureConfiguration config\)\s*\{', block)
        place = block[pm.end():find_block(block, pm.start()) - 1]
        place = re.sub(r'StructureTemplate template = world\.getLevel\(\)\.getStructureManager\(\)\s*\.getOrCreate\(([^;]*)\);',
                       r'StructureTemplate template = world.getLevel().getServer().getStructureTemplateManager().getOrCreate(\1);', place)
        place = re.sub(r'template\.placeInWorldChunk\(world, spawnTo,\s*(new StructurePlaceSettings\(\).*?)\.setChunkPos\(null\)(.*?),\s*random\);',
                       r'template.placeInWorld(world, spawnTo, spawnTo, \1\2, random, 2);', place, flags=re.S)
        FEATURES.append(name)
        names.append(cls)
        out.append('''	public record %s() implements Feature {
		public static final MapCodec<%s> CODEC = MapCodec.unit(%s::new);

		static void register() {
			Registration.add(Registries.FEATURE_TYPE, "%s", () -> CODEC, null);
		}

		@Override
		public MapCodec<%s> codec() {
			return CODEC;
		}

		@Override
		public boolean place(WorldGenLevel world, ChunkGenerator generator, RandomSource random, BlockPos pos) {
%s
		}
	}''' % (cls, cls, cls, name, cls, place.rstrip()))
    imports = ['net.minecraft.world.level.levelgen.feature.Feature', 'com.mojang.serialization.MapCodec',
               'net.minecraft.world.level.chunk.ChunkGenerator', 'net.minecraft.core.registries.Registries',
               'net.mcreator.narutoshippudenmod.compat.Registration', 'net.minecraft.util.RandomSource', 'net.minecraft.world.level.WorldGenLevel',
               'net.minecraft.core.BlockPos']
    head = re.sub(r'^import .*(ConfiguredFeature|FeatureDecorator|DecoratorConfiguration|FeatureConfiguration|BiomeLoadingEvent|RegistryEvent|ChunkGenerator|levelgen\.feature\.Feature;).*;\n', '', head, flags=re.M)
    have = set(re.findall(r'^import ([\w.]+);', head, re.M))
    head = head.rstrip('\n') + '\n' + ''.join('import %s;\n' % i for i in imports if i not in have) + '\n'
    return (head + 'public final class KamuiTowerStructures {\n\tprivate KamuiTowerStructures() {\n\t}\n\n\tpublic static void register() {\n'
            + ''.join('\t\t%s.register();\n' % c for c in names) + '\t}\n\n' + '\n\n'.join(out) + '\n}\n')
