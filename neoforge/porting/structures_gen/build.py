"""Building blocks for the story's structures, written as vanilla structure templates (.nbt).

Coordinates: x east, y up, z south, from the template's corner. Every structure faces south (+z): its entrance is on the
high-z side, and the village layout rotates it into place. Positions never set are structure voids (the ground stays);
`air` volumes clear what is there.
"""
import math, os
import nbt

DATA_VERSION = 5023  # Minecraft 26.3
HERE = os.path.dirname(os.path.abspath(__file__))
BLOCKS = set(open(os.path.join(HERE, 'blocks.txt')).read().split())
AIR = 'air'

# stairs and other facing blocks: the side a 'facing' points to, turned left/right
LEFT = {'north': 'west', 'west': 'south', 'south': 'east', 'east': 'north'}
RIGHT = {v: k for k, v in LEFT.items()}
OPP = {'north': 'south', 'south': 'north', 'east': 'west', 'west': 'east'}


def st(name, **props):
    """A block state string, 'oak_stairs[facing=north,half=bottom]'."""
    if not props:
        return name
    return '%s[%s]' % (name, ','.join('%s=%s' % (k, str(v).lower()) for k, v in sorted(props.items())))


def stairs(name, facing, top=False):
    return st(name, facing=facing, half='top' if top else 'bottom', shape='straight', waterlogged=False)


def slab(name, kind='bottom'):
    return st(name, type=kind, waterlogged=False)


def log(name, axis='y'):
    return st(name, axis=axis)


def _hash(x, y, z, salt=0):
    h = (x * 73856093) ^ (y * 19349663) ^ (z * 83492791) ^ (salt * 2654435761)
    h = (h ^ (h >> 13)) * 1274126177
    return ((h ^ (h >> 16)) & 0xffffffff) / 0xffffffff


class Mix:
    """A weathered surface: picks one of several states per position, by weight, the same every run."""

    def __init__(self, *pairs, salt=0):
        self.pairs = [(s, w) for s, w in pairs]
        self.total = sum(w for _, w in self.pairs)
        self.salt = salt

    def at(self, x, y, z):
        r = _hash(x, y, z, self.salt) * self.total
        for s, w in self.pairs:
            r -= w
            if r <= 0:
                return s
        return self.pairs[-1][0]


class Build:
    def __init__(self, w, h, d):
        self.nbt = {}          # block entity data by position (banner patterns, ...)
        self.entities = []     # (x, y, z, nbt) with x, y, z as doubles inside the template
        self.w, self.h, self.d = w, h, d
        self.blocks = {}

    # ------------------------------------------------------------------ basics
    def inside(self, x, y, z):
        return 0 <= x < self.w and 0 <= y < self.h and 0 <= z < self.d

    def set(self, x, y, z, state):
        if self.inside(x, y, z):
            if isinstance(state, Mix):
                state = state.at(x, y, z)
            self.blocks[(x, y, z)] = state

    def get(self, x, y, z):
        return self.blocks.get((x, y, z))

    def fill(self, x1, y1, z1, x2, y2, z2, state):
        for x in range(min(x1, x2), max(x1, x2) + 1):
            for y in range(min(y1, y2), max(y1, y2) + 1):
                for z in range(min(z1, z2), max(z1, z2) + 1):
                    self.set(x, y, z, state)

    def box(self, x1, y1, z1, x2, y2, z2, wall, inner=AIR):
        """Walls on the four sides from y1 to y2, the inside cleared."""
        self.fill(x1, y1, z1, x2, y2, z2, wall)
        if inner is not None:
            self.fill(x1 + 1, y1, z1 + 1, x2 - 1, y2, z2 - 1, inner)

    def floor(self, x1, y, z1, x2, z2, state):
        self.fill(x1, y, z1, x2, y, z2, state)

    def replace(self, x1, y1, z1, x2, y2, z2, old, new):
        for x in range(min(x1, x2), max(x1, x2) + 1):
            for y in range(min(y1, y2), max(y1, y2) + 1):
                for z in range(min(z1, z2), max(z1, z2) + 1):
                    if self.get(x, y, z) == old:
                        self.set(x, y, z, new)

    # ------------------------------------------------------------------ round shapes
    @staticmethod
    def in_circle(dx, dz, r):
        return dx * dx + dz * dz <= (r + 0.45) ** 2

    def disc(self, cx, y, cz, r, state):
        r_i = int(math.ceil(r))
        for dx in range(-r_i, r_i + 1):
            for dz in range(-r_i, r_i + 1):
                if self.in_circle(dx, dz, r):
                    self.set(cx + dx, y, cz + dz, state)

    def ring(self, cx, y, cz, r, state, thick=1):
        r_i = int(math.ceil(r))
        for dx in range(-r_i, r_i + 1):
            for dz in range(-r_i, r_i + 1):
                if self.in_circle(dx, dz, r) and not self.in_circle(dx, dz, r - thick):
                    self.set(cx + dx, y, cz + dz, state)

    def ring_points(self, cx, cz, r):
        r_i = int(math.ceil(r))
        return [(cx + dx, cz + dz) for dx in range(-r_i, r_i + 1) for dz in range(-r_i, r_i + 1)
                if self.in_circle(dx, dz, r) and not self.in_circle(dx, dz, r - 1)]

    def cylinder(self, cx, y1, cz, r, y2, wall, inner=AIR):
        for y in range(y1, y2 + 1):
            if inner is not None:
                self.disc(cx, y, cz, r - 1, inner)
            self.ring(cx, y, cz, r, wall)

    # ------------------------------------------------------------------ roofs
    def gable(self, x1, z1, x2, z2, y, stair, ridge, axis='x', over=1, gable_wall=None, eave=None):
        """A pitched roof over x1..x2, z1..z2 (the walls' outer edge), ridge along `axis`, starting at height y.
        `over` blocks of overhang; `eave` (an upside-down stair or slab) lines the underside of the lowest row."""
        if axis == 'x':
            a1, a2 = x1 - over, x2 + over
            lo, hi = z1 - over, z2 + over
        else:
            a1, a2 = z1 - over, z2 + over
            lo, hi = x1 - over, x2 + over
        i = 0
        while lo + i <= hi - i:
            yy = y + i
            for a in range(a1, a2 + 1):
                def put(b, state):
                    if axis == 'x':
                        self.set(a, yy, b, state)
                    else:
                        self.set(b, yy, a, state)
                if lo + i == hi - i:
                    put(lo + i, ridge)
                else:
                    put(lo + i, stairs(stair, 'south' if axis == 'x' else 'east'))
                    put(hi - i, stairs(stair, 'north' if axis == 'x' else 'west'))
            # gable ends: the wall rises under the roof
            if gable_wall and i > 0:
                for b in range(lo + i, hi - i + 1):
                    for a in ((x1, x2) if axis == 'x' else (z1, z2)):
                        if axis == 'x':
                            if self.get(a, yy - 1, b) is None or self.get(a, yy - 1, b) == AIR:
                                self.set(a, yy - 1, b, gable_wall)
                        else:
                            if self.get(b, yy - 1, a) is None or self.get(b, yy - 1, a) == AIR:
                                self.set(b, yy - 1, a, gable_wall)
            i += 1
        if eave:
            for a in range(a1, a2 + 1):
                for b, f in ((lo, 'south' if axis == 'x' else 'east'), (hi, 'north' if axis == 'x' else 'west')):
                    pos = (a, y - 1, b) if axis == 'x' else (b, y - 1, a)
                    if self.get(*pos) in (None, AIR):
                        self.set(*pos, eave if '[' in eave else stairs(eave, f, top=True))

    def hip(self, x1, z1, x2, z2, y, stair, top, over=1, eave=None, layers=None):
        """A hip roof: every side slopes up; rings of stairs shrink until the top (filled with `top`)."""
        a1, b1, a2, b2 = x1 - over, z1 - over, x2 + over, z2 + over
        i = 0
        while a1 + i <= a2 - i and b1 + i <= b2 - i and (layers is None or i < layers):
            yy = y + i
            xa, xb, za, zb = a1 + i, a2 - i, b1 + i, b2 - i
            if xa == xb or za == zb or (layers is not None and i == layers - 1):
                self.fill(xa, yy, za, xb, yy, zb, top)
                break
            for x in range(xa, xb + 1):
                self.set(x, yy, za, stairs(stair, 'south'))
                self.set(x, yy, zb, stairs(stair, 'north'))
            for z in range(za + 1, zb):
                self.set(xa, yy, z, stairs(stair, 'east'))
                self.set(xb, yy, z, stairs(stair, 'west'))
            if xb - xa >= 2 and zb - za >= 2:
                self.fill(xa + 1, yy, za + 1, xb - 1, yy, zb - 1, top)
            i += 1
        if eave:
            for x in range(a1, a2 + 1):
                for z, f in ((b1, 'south'), (b2, 'north')):
                    if self.get(x, y - 1, z) in (None, AIR):
                        self.set(x, y - 1, z, stairs(eave, f, top=True))
            for z in range(b1 + 1, b2):
                for x, f in ((a1, 'east'), (a2, 'west')):
                    if self.get(x, y - 1, z) in (None, AIR):
                        self.set(x, y - 1, z, stairs(eave, f, top=True))
        return i

    def cone(self, cx, y, cz, r, stair, top, eave=None):
        """A round roof: rings of stairs facing the middle, shrinking by one a layer."""
        rr = r
        yy = y
        while rr >= 1:
            for (x, z) in self.ring_points(cx, cz, rr):
                dx, dz = cx - x, cz - z
                f = ('east' if dx > 0 else 'west') if abs(dx) >= abs(dz) else ('south' if dz > 0 else 'north')
                self.set(x, yy, z, stairs(stair, f))
            self.disc(cx, yy, cz, rr - 1, top)
            rr -= 1
            yy += 1
        self.set(cx, yy, cz, top)
        if eave:
            for (x, z) in self.ring_points(cx, cz, r):
                dx, dz = cx - x, cz - z
                f = ('east' if dx > 0 else 'west') if abs(dx) >= abs(dz) else ('south' if dz > 0 else 'north')
                if self.get(x, y - 1, z) in (None, AIR):
                    self.set(x, y - 1, z, stairs(eave, f, top=True))
        return yy

    # ------------------------------------------------------------------ details
    def door(self, x, y, z, wood, facing='south', hinge='left'):
        self.set(x, y, z, st(wood + '_door', facing=facing, half='lower', hinge=hinge, open=False, powered=False))
        self.set(x, y + 1, z, st(wood + '_door', facing=facing, half='upper', hinge=hinge, open=False, powered=False))

    def glyph(self, rows, x0, y0, z0, state, plane='xy', flip=False):
        """Pixel art: rows of '#' (top row first) drawn on a wall. plane 'xy' runs along x, 'zy' along z."""
        n = len(rows)
        for r, line in enumerate(rows):
            for c, ch in enumerate(line):
                if ch == '#':
                    c2 = len(line) - 1 - c if flip else c
                    if plane == 'xy':
                        self.set(x0 + c2, y0 + n - 1 - r, z0, state)
                    else:
                        self.set(x0, y0 + n - 1 - r, z0 + c2, state)

    def banner(self, x, y, z, facing, color, patterns=()):
        """A wall banner with patterns: [(pattern, colour), ...] in vanilla names, e.g. ('stripe_top', 'red')."""
        self.set(x, y, z, st(color + '_wall_banner', facing=facing))
        self.nbt[(x, y, z)] = {'id': 'minecraft:banner',
                               'patterns': [{'pattern': 'minecraft:' + p, 'color': c} for p, c in patterns]}

    def cushion(self, x, y, z, color='brown'):
        """A vanilla cushion (an entity) resting on the block below (x, y, z)."""
        self.entities.append((x + 0.5, float(y), z + 0.5, {
            'id': 'minecraft:cushion', 'color': color, 'block_pos': nbt.IntArray([x, y, z])}))

    def lantern(self, x, y, z, hanging=False, kind='lantern'):
        self.set(x, y, z, st(kind, hanging=hanging, waterlogged=False))

    # ------------------------------------------------------------------ output
    def check(self):
        bad = sorted({s.split('[')[0] for s in self.blocks.values() if s.split('[')[0] not in BLOCKS})
        if bad:
            raise ValueError('unknown blocks: %s' % bad)

    # ------------------------------------------------------------------ connections
    # A template is placed during world generation, where blocks never update their neighbours: fences, panes, bars and
    # walls keep whatever connections they were saved with. connect() works them out from the neighbours inside the
    # template, as vanilla would when they are placed by hand.
    NOT_SOLID = ('air', 'slab', 'stairs', 'fence', 'pane', 'iron_bars', '_wall', 'door', 'torch', 'lantern', 'flower', 'sapling',
                 'carpet', 'sign', 'banner', 'button', 'lever', 'pressure_plate', 'rail', 'grass', 'fern', 'vine', 'ladder', 'chain',
                 'candle', 'pot', 'rod', 'water', 'lava', 'snow', 'bed', 'bell', 'campfire', 'cauldron', 'anvil', 'lectern', 'cake',
                 'dandelion', 'poppy', 'tulip', 'orchid', 'allium', 'bluet', 'daisy', 'cornflower', 'lily', 'bush', 'roots', 'head',
                 'skull', 'scaffolding', 'cobweb', 'tripwire', 'string', 'hopper', 'brewing', 'grindstone', 'stonecutter', 'azalea',
                 'mushroom', 'dripleaf', 'pickle', 'kelp', 'seagrass', 'coral', 'petals', 'leaf_litter', 'frame', 'end_rod', 'bamboo')

    @staticmethod
    def parse(state):
        name, _, rest = state.partition('[')
        props = dict(p.split('=') for p in rest[:-1].split(',')) if rest else {}
        return name, props

    @staticmethod
    def kind(name):
        if name.endswith('_fence') and not name.endswith('fence_gate'):
            return 'nether_fence' if name.startswith('nether_brick') else 'fence'
        if name.endswith('_pane') or name == 'iron_bars':
            return 'pane'
        if name.endswith('_wall') and not any(k in name for k in ('torch', 'sign', 'banner', 'head', 'skull', 'fan')):
            return 'wall'
        return None

    def solid(self, name):
        return not any(k in name for k in self.NOT_SOLID) and name not in ('glass',) or name.endswith('glass')

    def connect(self):
        sides = {'north': (0, -1), 'south': (0, 1), 'west': (-1, 0), 'east': (1, 0)}
        out = {}
        for (x, y, z), state in self.blocks.items():
            name, props = self.parse(state)
            k = self.kind(name)
            if k is None:
                continue
            links = {}
            for side, (dx, dz) in sides.items():
                other = self.blocks.get((x + dx, y, z + dz))
                on = False
                if other:
                    oname, _ = self.parse(other)
                    ok = self.kind(oname)
                    if k in ('fence', 'nether_fence'):
                        on = ok == k or oname.endswith('fence_gate') or self.solid(oname)
                    elif k == 'pane':
                        on = ok in ('pane', 'wall') or self.solid(oname)
                    else:
                        on = ok in ('wall', 'pane') or oname.endswith('fence_gate') or self.solid(oname)
                links[side] = on
            if k == 'wall':
                above = self.blocks.get((x, y + 1, z))
                for side, on in links.items():
                    props[side] = 'none' if not on else 'low'
                straight = (links['north'] and links['south'] and not links['east'] and not links['west']) or \
                           (links['east'] and links['west'] and not links['north'] and not links['south'])
                props['up'] = 'false' if straight and not (above and self.parse(above)[0] != 'air') else 'true'
            else:
                for side, on in links.items():
                    props[side] = 'true' if on else 'false'
            props.setdefault('waterlogged', 'false')
            out[(x, y, z)] = '%s[%s]' % (name, ','.join('%s=%s' % kv for kv in sorted(props.items())))
        self.blocks.update(out)
        self.stair_shapes()

    def stair_shapes(self):
        """Stairs beside stairs turned across them join into corners, as vanilla's StairBlock.getStairsShape works them out
        when they are placed by hand (a template keeps the shape it was saved with)."""
        step = {'north': (0, -1), 'south': (0, 1), 'west': (-1, 0), 'east': (1, 0)}
        axis = {'north': 'z', 'south': 'z', 'west': 'x', 'east': 'x'}

        def stair(x, y, z):
            s = self.blocks.get((x, y, z))
            if not s or '_stairs' not in s.split('[')[0]:
                return None
            return self.parse(s)[1]

        def can_take(props, x, y, z, side):
            dx, dz = step[side]
            n = stair(x + dx, y, z + dz)
            return n is None or n.get('facing') != props['facing'] or n.get('half') != props['half']

        out = {}
        for (x, y, z), s in self.blocks.items():
            name, props = self.parse(s)
            if not name.endswith('_stairs') or 'facing' not in props:
                continue
            f, shape = props['facing'], 'straight'
            dx, dz = step[f]
            front = stair(x + dx, y, z + dz)
            back = stair(x - dx, y, z - dz)
            if front and front.get('half') == props.get('half') and axis[front['facing']] != axis[f] \
                    and can_take(props, x, y, z, OPP[front['facing']]):
                shape = 'outer_left' if front['facing'] == LEFT[f] else 'outer_right'
            elif back and back.get('half') == props.get('half') and axis[back['facing']] != axis[f] \
                    and can_take(props, x, y, z, back['facing']):
                shape = 'inner_left' if back['facing'] == LEFT[f] else 'inner_right'
            props['shape'] = shape
            out[(x, y, z)] = '%s[%s]' % (name, ','.join('%s=%s' % kv for kv in sorted(props.items())))
        self.blocks.update(out)

    def save(self, path):
        self.connect()
        self.check()
        palette, index = [], {}
        blocks = []
        for (x, y, z), s in sorted(self.blocks.items(), key=lambda kv: (kv[0][1], kv[0][2], kv[0][0])):
            if s not in index:
                index[s] = len(palette)
                name, _, rest = s.partition('[')
                entry = {'id': 'minecraft:' + name}
                if rest:
                    entry['properties'] = dict(p.split('=') for p in rest[:-1].split(','))
                palette.append(entry)
            entry = {'pos': [x, y, z], 'state': index[s]}
            if (x, y, z) in self.nbt:
                entry['nbt'] = self.nbt[(x, y, z)]
            blocks.append(entry)
        os.makedirs(os.path.dirname(path), exist_ok=True)
        nbt.write(path, {'DataVersion': DATA_VERSION, 'size': [self.w, self.h, self.d], 'palette': palette,
                         'blocks': blocks, 'entities': [
                             {'pos': [float(x), float(y), float(z)],
                              'blockPos': [int(math.floor(x)), int(math.floor(y)), int(math.floor(z))], 'nbt': tag}
                             for (x, y, z, tag) in self.entities]})
        return len(blocks)


def inward(cx, cz, x, z):
    """The horizontal facing from (x, z) toward the centre (cx, cz)."""
    dx, dz = cx - x, cz - z
    return ('east' if dx > 0 else 'west') if abs(dx) >= abs(dz) else ('south' if dz > 0 else 'north')


def angle_of(cx, cz, x, z):
    return (math.atan2(z - cz, x - cx) + 2 * math.pi) % (2 * math.pi)


WOODS = ('oak', 'spruce', 'birch', 'jungle', 'acacia', 'dark_oak', 'mangrove', 'cherry', 'bamboo', 'crimson', 'warped', 'pale_oak')


def skirt(b, cx, y, cz, r_out, layers, stair_at, eave=None, fill=None):
    """A sloped ring roof round a drum (the Hokage tower's tiers): `layers` rings of stairs facing the middle, from radius
    r_out at height y, one in and one up each layer. stair_at(x, z, k) names the stair block of each spot."""
    for k in range(layers):
        rr = r_out - k
        for (x, z) in b.ring_points(cx, cz, rr):
            name = stair_at(x, z, k)
            b.set(x, y + k, z, stairs(name, inward(cx, cz, x, z)))
            # solid under the raised rows: where a row stands two above its neighbour (round a ring the radii don't
            # step evenly) the gap under it would show as a hole in the roof
            base = name[:-len('_stairs')]
            base = base + '_planks' if base in WOODS else base
            for yy in range(y, y + k):
                if b.get(x, yy, z) in (None, AIR):
                    b.set(x, yy, z, base)
    if eave:
        for (x, z) in b.ring_points(cx, cz, r_out):
            if b.get(x, y - 1, z) in (None, AIR):
                b.set(x, y - 1, z, stairs(eave, inward(cx, cz, x, z), top=True))
