"""1.16.5 resources -> 26.3 resources (neoforge/src/main/resources).

Assets are copied as they were; what changed in the formats is generated or rewritten here: item model definitions,
texture atlases for the mod's items/ and blocks/ folders, block render types, equipment assets, the post effect,
data folder names, recipes, tags, dimensions, biomes, tower features and mob spawns.
"""
import json
import os
import shutil

import armor
import blocks
import rules
import structures

HERE = os.path.dirname(os.path.abspath(__file__))
OLD = os.path.join(HERE, '..', '..', 'src', 'main', 'resources')
if not os.path.isdir(OLD):
    OLD = '/home/user/Naruto-Shippuden/src/main/resources'
NEW = os.path.join(HERE, '..', 'src', 'main', 'resources')
if not os.path.isdir(os.path.join(NEW, 'META-INF')):
    NEW = '/home/user/Naruto-Shippuden/neoforge/src/main/resources'
NS = 'naruto_shippuden'

# 1.16 spawn egg colours (primary, secondary), from the SpawnEggItem constructors
SPAWN_EGGS = {
    'asuma_spawn_egg': (-11513752, -7510683),
    'hidden_cloud_shinobi_spawn_egg': (-591950, -11311731),
    'hidden_leaf_shinobi_spawn_egg': (-13750738, -13024682),
    'hidden_mist_shinobi_spawn_egg': (-11190234, -13024682),
    'hidden_sand_shinobi_spawn_egg': (-10066330, -15132391),
    'hidden_stone_shinobi_spawn_egg': (-6126278, -4748748),
    'shikamaru_spawn_egg': (-10182549, -12500671),
    'kurama_spawn_egg': (-1149696, -5302505),
}

# biomes renamed or merged since 1.16
BIOME_RENAMES = {'taiga_mountains': 'taiga', 'mountains': 'windswept_hills', 'wooded_mountains': 'windswept_forest',
                 'giant_tree_taiga': 'old_growth_pine_taiga', 'jungle_edge': 'sparse_jungle', 'tall_birch_forest': 'old_growth_birch_forest'}


def write(rel, data):
    path = os.path.join(NEW, rel)
    os.makedirs(os.path.dirname(path), exist_ok=True)
    with open(path, 'w', encoding='utf-8') as f:
        if isinstance(data, str):
            f.write(data)
        else:
            json.dump(data, f, indent=2)
            f.write('\n')


def load(rel):
    with open(os.path.join(OLD, rel), encoding='utf-8') as f:
        return json.load(f)


def color(value):
    return '#%06x' % (value & 0xFFFFFF)


# ---------------------------------------------------------------- assets
def copy_assets():
    src = os.path.join(OLD, 'assets', NS)
    dst = os.path.join(NEW, 'assets', NS)
    if os.path.exists(dst):
        shutil.rmtree(dst)
    shutil.copytree(src, dst, ignore=shutil.ignore_patterns('shaders'))


def item_definitions():
    item_dir = os.path.join(OLD, 'assets', NS, 'models', 'item')
    n = 0
    for f in sorted(os.listdir(item_dir)):
        if not f.endswith('.json'):
            continue
        name = f[:-5]
        if name in SPAWN_EGGS:
            continue
        write('assets/%s/items/%s' % (NS, f), {'model': {'type': 'minecraft:model', 'model': '%s:item/%s' % (NS, name)}})
        n += 1
    # spawn eggs: the tinted template model is gone, so draw a two-layer egg and tint it per mob
    spawn_egg_textures()
    write('assets/%s/models/item/spawn_egg.json' % NS, {'parent': 'minecraft:item/generated', 'textures': {
        'layer0': '%s:item/spawn_egg' % NS, 'layer1': '%s:item/spawn_egg_overlay' % NS}})
    for name, (primary, secondary) in SPAWN_EGGS.items():
        path = os.path.join(NEW, 'assets', NS, 'models', 'item', name + '.json')
        if os.path.exists(path):
            os.remove(path)
        write('assets/%s/items/%s.json' % (NS, name), {'model': {
            'type': 'minecraft:model', 'model': '%s:item/spawn_egg' % NS,
            'tints': [{'type': 'minecraft:constant', 'value': primary & 0xFFFFFF}, {'type': 'minecraft:constant', 'value': secondary & 0xFFFFFF}]}})
        n += 1
    return n


EGG = [
    '................',
    '......####......',
    '.....#oooo#.....',
    '....#oooooo#....',
    '....#oooooo#....',
    '...#oooooooo#...',
    '...#oooooooo#...',
    '..#oooooooooo#..',
    '..#oooooooooo#..',
    '..#oooooooooo#..',
    '..#oooooooooo#..',
    '..#oooooooooo#..',
    '...#oooooooo#...',
    '....#oooooo#....',
    '.....######.....',
    '................',
]
SPOTS = [(6, 3), (7, 3), (9, 5), (10, 5), (5, 7), (6, 7), (10, 8), (11, 8), (11, 9), (4, 10), (5, 10), (5, 11), (8, 11), (9, 11), (8, 12)]


def spawn_egg_textures():
    from PIL import Image
    base = Image.new('RGBA', (16, 16), (0, 0, 0, 0))
    over = Image.new('RGBA', (16, 16), (0, 0, 0, 0))
    for y, row in enumerate(EGG):
        for x, c in enumerate(row):
            if c == '#':
                base.putpixel((x, y), (150, 150, 150, 255))
            elif c == 'o':
                # light from the upper left
                shade = 255 - max(0, (x - 4) * 6) - max(0, (y - 4) * 5)
                base.putpixel((x, y), (shade, shade, shade, 255))
    for x, y in SPOTS:
        if EGG[y][x] == 'o':
            over.putpixel((x, y), (255, 255, 255, 255))
    d = os.path.join(NEW, 'assets', NS, 'textures', 'item')
    os.makedirs(d, exist_ok=True)
    base.save(os.path.join(d, 'spawn_egg.png'))
    over.save(os.path.join(d, 'spawn_egg_overlay.png'))


def atlases():
    # 26.3 only stitches block/ and item/ by default; the mod keeps its textures in blocks/ and items/.
    # Block models may only use the block atlas; item models fall back to it for their blocks/ textures.
    write('assets/minecraft/atlases/items.json', {'sources': [
        {'type': 'minecraft:directory', 'source': 'items', 'prefix': 'items/'},
        {'type': 'minecraft:directory', 'source': 'item', 'prefix': 'item/'}]})
    write('assets/minecraft/atlases/blocks.json', {'sources': [
        {'type': 'minecraft:directory', 'source': 'blocks', 'prefix': 'blocks/'}]})


def clamp_uvs():
    """Some Blockbench models have UVs past the texture edge; 1.16 sampled whatever was next to the sprite, 26.3
    refuses to bake the model. Clamp them onto the texture."""
    root = os.path.join(NEW, 'assets', NS, 'models')
    for d, _, files in os.walk(root):
        for f in files:
            path = os.path.join(d, f)
            try:
                data = json.load(open(path, encoding='utf-8-sig'))
            except ValueError:
                print('resources: not JSON, left as is:', os.path.relpath(path, root))
                continue
            changed = False
            for e in data.get('elements', []):
                for face in e.get('faces', {}).values():
                    uv = face.get('uv')
                    if uv and any(v < 0 or v > 16 for v in uv):
                        face['uv'] = [min(16, max(0, v)) for v in uv]
                        changed = True
            if changed:
                write(os.path.relpath(path, NEW), data)


def block_render_types():
    """Blocks drawn with cutout/translucent layers get the render type in their models (was RenderTypeLookup)."""
    for name, rt in blocks.RENDER_TYPES.items():
        state_file = os.path.join(NEW, 'assets', NS, 'blockstates', name + '.json')
        if not os.path.exists(state_file):
            continue
        state = json.load(open(state_file))
        models = set()
        for v in state.get('variants', {}).values():
            for entry in (v if isinstance(v, list) else [v]):
                models.add(entry['model'])
        for part in state.get('multipart', []):
            for entry in (part['apply'] if isinstance(part['apply'], list) else [part['apply']]):
                models.add(entry['model'])
        for model in models:
            ns, path = model.split(':', 1) if ':' in model else ('minecraft', model)
            if ns != NS:
                continue
            f = os.path.join(NEW, 'assets', NS, 'models', path + '.json')
            if os.path.exists(f):
                data = json.load(open(f))
                data['render_type'] = 'minecraft:' + rt
                write(os.path.relpath(f, NEW), data)


def equipment_assets():
    # headbands draw with their own model and texture (client item extensions); the asset only has to exist
    for name in armor.EQUIPMENT_ASSETS:
        write('assets/%s/equipment/%s.json' % (NS, name), {'layers': {'humanoid': [{'texture': '%s:%s' % (NS, name)}]}})


def post_effects():
    # 1.16 coercion sharingan: colour_convolve + bits, now written like vanilla's creeper effect
    write('assets/%s/post_effect/coercionsharingan.json' % NS, {
        'targets': {'swap': {}},
        'passes': [
            {'vertex_shader': 'minecraft:core/screenquad', 'fragment_shader': 'minecraft:post/color_convolve',
             'inputs': [{'sampler_name': 'In', 'target': 'minecraft:main'}], 'output': 'swap',
             'uniforms': {'ColorConfig': [
                 {'name': 'RedMatrix', 'type': 'vec3', 'value': [0.3, 0.59, 0.11]},
                 {'name': 'GreenMatrix', 'type': 'vec3', 'value': [0.15, 0.28, 0.06]},
                 {'name': 'BlueMatrix', 'type': 'vec3', 'value': [0.0, 0.0, 0.0]}]}},
            {'vertex_shader': 'minecraft:core/screenquad', 'fragment_shader': 'minecraft:post/bits',
             'inputs': [{'sampler_name': 'In', 'target': 'swap'}], 'output': 'minecraft:main',
             'uniforms': {'BitsConfig': [
                 {'name': 'Resolution', 'type': 'float', 'value': 16.0},
                 {'name': 'MosaicSize', 'type': 'float', 'value': 4.0}]}}]})


# ---------------------------------------------------------------- data
def ingredient(value):
    if isinstance(value, list):
        return [ingredient(v) for v in value]
    if 'tag' in value:
        return '#' + value['tag']
    return value['item']


def recipes():
    d = os.path.join(OLD, 'data', NS, 'recipes')
    for f in sorted(os.listdir(d)):
        r = load('data/%s/recipes/%s' % (NS, f))
        out = {'type': r['type'], 'category': 'misc'}
        if 'group' in r:
            out['group'] = r['group']
        if r['type'] == 'minecraft:crafting_shaped':
            out['key'] = {k: ingredient(v) for k, v in r['key'].items()}
            out['pattern'] = r['pattern']
        elif r['type'] == 'minecraft:crafting_shapeless':
            out['ingredients'] = [ingredient(v) for v in r['ingredients']]
        else:
            out = dict(r)
            if 'ingredient' in out:
                out['ingredient'] = ingredient(out['ingredient'])
        res = r['result']
        if isinstance(res, str):
            res = {'item': res}
        out['result'] = {'id': res['item']}
        if res.get('count', 1) != 1:
            out['result']['count'] = res['count']
        write('data/%s/recipe/%s' % (NS, f), out)


def advancements():
    d = os.path.join(OLD, 'data', NS, 'advancements')
    for f in sorted(os.listdir(d)):
        a = load('data/%s/advancements/%s' % (NS, f))
        icon = a.get('display', {}).get('icon')
        if icon and 'item' in icon:
            icon['id'] = icon.pop('item')
        write('data/%s/advancement/%s' % (NS, f), a)


def tags():
    for f in os.listdir(os.path.join(OLD, 'data', NS, 'tags', 'items')):
        write('data/%s/tags/item/%s' % (NS, f), load('data/%s/tags/items/%s' % (NS, f)))
    tools = {}
    levels = {}
    for name, (tool, level) in blocks.MINEABLE.items():
        tools.setdefault(tool, []).append('%s:%s' % (NS, name))
        tag = {1: 'needs_stone_tool', 2: 'needs_iron_tool', 3: 'needs_diamond_tool'}.get(level)
        if tag:
            levels.setdefault(tag, []).append('%s:%s' % (NS, name))
    for tool, values in tools.items():
        write('data/minecraft/tags/block/mineable/%s.json' % tool, {'replace': False, 'values': sorted(values)})
    for tag, values in levels.items():
        write('data/minecraft/tags/block/%s.json' % tag, {'replace': False, 'values': sorted(values)})


def structures_nbt():
    src = os.path.join(OLD, 'data', NS, 'structures')
    dst = os.path.join(NEW, 'data', NS, 'structure')
    os.makedirs(dst, exist_ok=True)
    for f in os.listdir(src):
        shutil.copy(os.path.join(src, f), os.path.join(dst, f))


def overrides():
    src = os.path.join(HERE, 'res_override')
    for root, _, files in os.walk(src):
        for f in files:
            rel = os.path.relpath(os.path.join(root, f), src)
            out = os.path.join(NEW, rel)
            os.makedirs(os.path.dirname(out), exist_ok=True)
            shutil.copy(os.path.join(root, f), out)


# ---------------------------------------------------------------- world generation
NO_SPAWNS = {'argument': {'spawn_costs': {}, 'spawns_by_category': {}}, 'modifier': 'overlay'}


def dimensions():
    mc = os.path.join(HERE, 'vanilla')
    # Kamui: a flat kamui_void floor up to y=63 in a black, skyless space. 1.16 had biome depth -1 / scale 0 and
    # kamui_void as the fluid below sea level 63, which filled everything to a flat top at 63; the Kamui technique
    # teleports to y=71 and the enter procedure drops the player to the first air from y=64 (towers stand on 64).
    noise = json.load(open(os.path.join(mc, 'floating_islands.json')))
    noise['default_block'] = '%s:kamui_void' % NS
    noise['default_fluid'] = 'minecraft:air'
    noise['disable_mob_generation'] = True
    noise['material_rule'] = {'type': 'minecraft:sequence', 'sequence': []}
    noise['sea_level'] = 63
    noise['noise_router']['final_density'] = {'type': 'minecraft:gradient', 'axis': 'y', 'from_coordinate': 63,
                                              'from_value': 1.0, 'to_coordinate': 64, 'to_value': -1.0}
    noise.pop('debug_functions', None)
    write('data/%s/worldgen/noise_settings/kamui_dimension.json' % NS, noise)
    write('data/%s/dimension_type/kamui_dimension.json' % NS, {
        'ambient_light': 0.5,
        'attributes': {
            'minecraft:gameplay/bed_rule': {'can_set_spawn': 'never', 'can_sleep': 'never', 'destroy_on_use': False},
            'minecraft:gameplay/respawn_anchor_works': False,
            'minecraft:gameplay/can_start_raid': False,
            # 26.3 lights skyless dimensions with this colour instead of ambient_light (1.16: 0.5 -> half brightness)
            'minecraft:visual/ambient_light_color': '#808080',
            'minecraft:visual/fog_color': '#000000',
            'minecraft:visual/sky_color': '#000000',
            'minecraft:visual/sky_light_factor': 0.0,
        },
        'coordinate_scale': 1.0, 'has_ceiling': False, 'has_ender_dragon_fight': False, 'has_fixed_time': True,
        'has_skylight': False, 'height': 256, 'infiniburn': '#minecraft:infiniburn_overworld', 'logical_height': 256, 'min_y': 0,
        'monster_spawn_block_light_limit': 0, 'monster_spawn_light_level': 0, 'skybox': 'none'})
    write('data/%s/dimension/kamui_dimension.json' % NS, {
        'type': '%s:kamui_dimension' % NS,
        'generator': {'type': 'minecraft:noise', 'settings': '%s:kamui_dimension' % NS,
                      'biome_source': {'type': 'minecraft:fixed', 'biome': '%s:kamui_biome' % NS}}})
    write('data/%s/worldgen/biome/kamui_biome.json' % NS, {
        # sky and fog stay black from the dimension type (1.16 forced a black fog colour there)
        'attributes': {'minecraft:gameplay/natural_mob_spawns': NO_SPAWNS, 'minecraft:visual/water_fog_color': color(329011)},
        'carvers': [], 'downfall': 0.1, 'has_precipitation': False, 'temperature': 0.5,
        'effects': {'water_color': color(4159204), 'foliage_color': color(10387789), 'grass_color': color(9470285)},
        # step 4 = surface structures: the kamui towers place themselves inside the chunk
        'features': [[], [], [], [], ['%s:%s' % (NS, f) for f in structures.FEATURES], [], [], [], [], [], []]})
    for f in structures.FEATURES:
        write('data/%s/worldgen/feature/%s.json' % (NS, f), {'type': '%s:%s' % (NS, f)})
        write('data/%s/worldgen/placed_feature/%s.json' % (NS, f), {'feature': '%s:%s' % (NS, f), 'placement': []})


def spawns():
    for key, category, weight, lo, hi, biomes in rules.SPAWNS:
        ids = ['minecraft:' + BIOME_RENAMES.get(b, b) for b in biomes] if biomes else '#minecraft:is_overworld'
        count = lo if lo == hi else {'type': 'minecraft:uniform', 'min_inclusive': lo, 'max_inclusive': hi}
        write('data/%s/neoforge/biome_modifier/spawn_%s.json' % (NS, key), {
            'type': 'neoforge:add_spawns', 'biomes': sorted(set(ids)) if isinstance(ids, list) else ids,
            'spawners': {'type': '%s:%s' % (NS, key), 'count': count, 'weight': weight}})


def build():
    copy_assets()
    items = item_definitions()
    atlases()
    clamp_uvs()
    block_render_types()
    equipment_assets()
    post_effects()
    for d in ('data',):
        p = os.path.join(NEW, d)
        if os.path.exists(p):
            shutil.rmtree(p)
    recipes()
    advancements()
    tags()
    structures_nbt()
    dimensions()
    spawns()
    overrides()
    print('resources: %d item models, %d spawn biome modifiers' % (items, len(rules.SPAWNS)))
