"""The Leaf as it stands in Chikyū, read back from the layout (data/naruto_shippuden/village/leaf.json) and the templates,
for placing story scenes: what block is at a world position, how high the ground is, where there's room to stand.
(The open ground between pieces is the generator's: grass at y 64, so the first air is 65.)

    python3 world.py x z          the column's blocks from y 60 up
    python3 world.py x z r        the ground height round (x, z), and which spots in reach are clear to stand on
"""
import json, os, sys
import nbt

HERE = os.path.dirname(os.path.abspath(__file__))
RES = os.path.join(HERE, '..', '..', 'src', 'main', 'resources', 'data', 'naruto_shippuden')
OX, OZ, Y0, SURFACE = -200, -215, 63, 64

_layout = None
_templates = {}


def layout():
    global _layout
    if _layout is None:
        _layout = json.load(open(os.path.join(RES, 'village', 'leaf.json')))
    return _layout


def template(name):
    if name not in _templates:
        d = nbt.read(os.path.join(RES, 'structure', name + '.nbt'))
        pal = [p['Name'] if 'Name' in p else p['id'] for p in d['palette']]
        props = [p.get('Properties', p.get('properties', {})) for p in d['palette']]
        blocks = {}
        for b in d['blocks']:
            blocks[tuple(b['pos'])] = (pal[b['state']].replace('minecraft:', ''), props[b['state']])
        _templates[name] = (d['size'], blocks)
    return _templates[name]


def _to_template(rot, dx, dz):
    """World offset from the piece's origin to the template's own x, z (the inverse of StructureTemplate.transform)."""
    if rot == 'clockwise_90':          # (x, z) -> (-z, x)
        return dz, -dx
    if rot == 'counterclockwise_90':   # (x, z) -> (z, -x)
        return -dz, dx
    if rot == '180':
        return -dx, -dz
    return dx, dz


def pieces_at(x, z):
    for p in layout()['pieces']:
        name = p['piece']
        if name.startswith('leaf/mountain_'):
            continue
        tx, tz = _to_template(p['rotation'], x - (p['x'] + OX), z - (p['z'] + OZ))
        size, _ = template(name)
        if 0 <= tx < size[0] and 0 <= tz < size[2]:
            yield p, tx, tz


def block(x, y, z):
    """The block a piece puts at (x, y, z), or 'grass_block'/'air' for the open ground (None: a piece leaves it as is)."""
    for p, tx, tz in pieces_at(x, z):
        _, blocks = template(p['piece'])
        b = blocks.get((tx, y - Y0, tz))
        if b and b[0] != 'structure_void':
            return b[0]
    return 'grass_block' if y <= SURFACE else 'air'


SOFT = ('air', 'grass', 'fern', 'flower', 'poppy', 'dandelion', 'tulip', 'daisy', 'bluet', 'orchid', 'allium',
        'cornflower', 'lily', 'carpet', 'cave_air', 'torch', 'button', 'pressure_plate', 'snow', 'petals')


def passable(name):
    return name is None or any(k in name for k in SOFT) and 'grass_block' not in name


def ground(x, z, top=200):
    """The y a player stands at in this column: the first passable block (two of them) over a solid one, from the
    bottom up (so the floor of a building, not its roof)."""
    for y in range(SURFACE, top):
        if not passable(block(x, y - 1, z)) and passable(block(x, y, z)) and passable(block(x, y + 1, z)):
            return y
    return None


def clear(x, z, r=1):
    """Room to stand or lie at (x, z): the ground level the same across the square of reach r, nothing in the way."""
    y = ground(x, z)
    if y is None:
        return None
    for dx in range(-r, r + 1):
        for dz in range(-r, r + 1):
            if ground(x + dx, z + dz) != y:
                return None
            for h in (0, 1, 2):
                if not passable(block(x + dx, y + h, z + dz)):
                    return None
    return y


if __name__ == '__main__':
    x, z = int(sys.argv[1]), int(sys.argv[2])
    if len(sys.argv) > 3:
        r = int(sys.argv[3])
        for zz in range(z - r, z + r + 1):
            print(zz, ' '.join('%3s' % (clear(xx, zz) if clear(xx, zz) is not None else '.') for xx in range(x - r, x + r + 1)))
    else:
        for y in range(60, 100):
            print(y, block(x, y, z))
