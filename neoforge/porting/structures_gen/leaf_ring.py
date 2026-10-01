"""The Hidden Leaf's round shape, after the village map: a circular wall round the south half, broken by the great gate;
mountains closing the north half either side of the Hokage Rock; the river that comes in from the north-east, bends
round through the village and leaves in the south-west, with a lake beside it.

Village coordinates: x east, z south, from the village's north-west corner. Every piece here knows its own place:
ORIGINS[name] is the (x, z) of its template's corner."""
import math
from build import Build, Mix, st, stairs, slab, AIR, inward, _hash
from leaf import G, tree
from leaf_landmarks import plaster

CX, CZ, R = 200, 215, 185            # the circle the wall follows
TOP = G + 33                         # the wall's top, as the gate's
GATE_HALF = 31.5                     # half the gate template's width
RIVER = [(470, 120), (395, 160), (360, 215), (345, 270), (318, 318), (270, 342), (200, 350), (140, 345), (100, 330),
         (70, 322), (40, 345), (5, 380), (-40, 420)]
RIVER_W = 4.0                        # half width of the water
LAKE = (66, 306, 20)                 # x, z, radius
MOUNTAIN_FROM = R - 12               # where the slopes rise, north of the circle's middle
GATE_Z = int(round(CZ + math.sqrt(R * R - GATE_HALF * GATE_HALF) - 9.5))   # the gate template's z: its wall's ends on the circle


def _seg_dist(px, pz, a, b):
    ax, az = a
    bx, bz = b
    dx, dz = bx - ax, bz - az
    t = max(0.0, min(1.0, ((px - ax) * dx + (pz - az) * dz) / (dx * dx + dz * dz)))
    return math.hypot(px - ax - t * dx, pz - az - t * dz)


def river_dist(x, z):
    """How far (x, z) is from the river's middle line (the lake counts as river)."""
    d = min(_seg_dist(x, z, RIVER[i], RIVER[i + 1]) for i in range(len(RIVER) - 1))
    lx, lz, lr = LAKE
    return min(d, max(0.0, math.hypot(x - lx, z - lz) - lr + RIVER_W))


def is_water(x, z):
    return river_dist(x, z) <= RIVER_W


def polar(x, z):
    """Distance from the circle's centre and the angle in degrees (0 east, 90 south, 180 west, 270 north)."""
    return math.hypot(x - CX, z - CZ), math.degrees(math.atan2(z - CZ, x - CX)) % 360


# ---------------------------------------------------------------- the wall, in arcs
GATE_ANG = math.degrees(math.asin(GATE_HALF / R))
ARCS = [(-14, 22), (22, 52), (52, 91.5 - GATE_ANG), (88.5 + GATE_ANG, 128), (128, 158), (158, 194)]   # the arcs reach a little into the gate's ends


def _arc_box(a1, a2):
    xs, zs = [], []
    for k in range(0, 41):
        a = math.radians(a1 + (a2 - a1) * k / 40)
        for r in (R - 4, R + 3):
            xs.append(CX + r * math.cos(a)); zs.append(CZ + r * math.sin(a))
    return int(math.floor(min(xs))) - 1, int(math.floor(min(zs))) - 1, int(math.ceil(max(xs))) + 1, int(math.ceil(max(zs))) + 1


def wall_arc(i):
    """One arc of the wall: the gate's plaster and green tiles, curving round the circle; the river passes under it."""
    a1, a2 = ARCS[i]
    x1, z1, x2, z2 = _arc_box(a1, a2)
    b = Build(x2 - x1 + 1, TOP + 5, z2 - z1 + 1)
    for x in range(x1, x2 + 1):
        for z in range(z1, z2 + 1):
            r, ang = polar(x + 0.5, z + 0.5)
            a = ang if ang <= 200 else ang - 360
            if not (a1 <= a < a2):
                continue
            lx, lz = x - x1, z - z1
            water = is_water(x + 0.5, z + 0.5)
            u = int(a * R * math.pi / 180)
            if R - 2 <= r < R + 2:
                for y in range(0, TOP + 1):
                    if water and y < G + 6:
                        if y >= G - 2:
                            b.set(lx, y, lz, 'water' if y < G else AIR)
                        continue
                    b.set(lx, y, lz, 'stone_bricks' if y < G else plaster(u, y, 0 if r > R else 5))
                b.set(lx, TOP + 1, lz, 'mossy_stone_bricks')
                if R - 1 <= r < R + 1:
                    b.set(lx, TOP + 2, lz, slab('mossy_stone_brick_slab', 'double'))
                    b.set(lx, TOP + 3, lz, slab('mossy_stone_brick_slab'))
                else:
                    f = inward(CX, CZ, x, z)
                    b.set(lx, TOP + 2, lz, stairs('mossy_stone_brick_stairs', f if r > R else {'north': 'south', 'south': 'north', 'east': 'west', 'west': 'east'}[f]))
            elif R - 3 <= r < R - 2 or R + 2 <= r < R + 3:
                f = inward(CX, CZ, x, z)
                out = f if r >= R + 2 else {'north': 'south', 'south': 'north', 'east': 'west', 'west': 'east'}[f]
                b.set(lx, TOP + 1, lz, stairs('mossy_stone_brick_stairs', out))
                b.set(lx, TOP, lz, stairs('mossy_stone_brick_stairs', out, top=True))
    return b


# ---------------------------------------------------------------- the mountains closing the north
ROCK_X0, ROCK_Z0 = CX - 87, 8            # the Hokage Rock template's corner
FACES_X1, FACES_X2 = ROCK_X0 + 16, ROCK_X0 + 159   # the carved part of it
RIDGE_Z = 60                             # the mountains rise north of here everywhere


def mountain(part):
    """The steep wooded mountains round the north of the village: they rise from the circle's edge (from the wall's very
    ends) and from behind the Hokage Rock, plain sandstone cliffs with grass and trees on their tops. `part` is 'west',
    'north' (behind the Rock) or 'east'; the three meet without gaps, and the Rock's own carved face is left to it."""
    x1, x2 = {'west': (-70, FACES_X1 - 1), 'north': (FACES_X1, FACES_X2), 'east': (FACES_X2 + 1, 2 * CX + 70)}[part]
    z1, z2 = -70, CZ + 12
    HMAX = 84
    b = Build(x2 - x1 + 1, G + HMAX + 10, z2 - z1 + 1)
    ROCK = Mix(('sandstone', 4), ('smooth_sandstone', 2), ('terracotta', 1), ('granite', 1), salt=111)
    tops = {}
    for x in range(x1, x2 + 1):
        for z in range(z1, z2 + 1):
            if FACES_X1 <= x <= FACES_X2 and z >= ROCK_Z0:
                continue                            # the Rock itself is there
            if is_water(x + 0.5, z + 0.5):
                continue
            r, ang = polar(x + 0.5, z + 0.5)
            north = 186 <= ang <= 354
            d = max((r - MOUNTAIN_FROM) if north else -99, RIDGE_Z - z)
            if d <= 0:
                continue
            n = (_hash(x // 4, 0, z // 4, 112) - 0.5) * 6 + (_hash(x // 9, 1, z // 9, 113) - 0.5) * 12
            h = min(HMAX - 6.0, d * 3.0) + n * min(1.0, d / 6)
            # fade out toward the far edges of the land, so the range ends in slopes, not a cut
            edge = min(x - (-70), 2 * CX + 70 - x, z - (-70))
            h *= max(0.0, min(1.0, edge / 40.0))
            if h < 1:
                continue
            tops[(x, z)] = (G - 1 + int(h), d)
    # solid down to the lowest of the neighbours (or the ground at an edge), so nothing hangs in the air
    for (x, z), (hy, d) in tops.items():
        low = min(tops.get((x + dx, z + dz), (G - 2, 0))[0] for dx, dz in ((1, 0), (-1, 0), (0, 1), (0, -1)))
        for y in range(max(0, min(low, hy) - 2), hy + 1):
            b.set(x - x1, y, z - z1, ROCK)
        if d > 9:
            b.set(x - x1, hy, z - z1, 'grass_block[snowy=false]')
    tops = {k: v[0] for k, v in tops.items()}
    for (x, z), hy in tops.items():
        if (x * 7 + z * 13) % 47 == 0 and hy + 9 < G + HMAX + 10:
            if all(abs(tops.get((x + dx, z + dz), -99) - hy) <= 2 for dx in (-2, 2) for dz in (-2, 2)):
                tree(b, x - x1, hy + 1, z - z1, height=5 + x % 3, r=3)
    b.origin = (x1, z1)
    return b


# ---------------------------------------------------------------- the river, the lake, the bridges
def river():
    """The river and the lake: water two deep between sandy banks, a gravel bed."""
    xs = [p[0] for p in RIVER] + [LAKE[0] - LAKE[2], LAKE[0] + LAKE[2]]
    zs = [p[1] for p in RIVER] + [LAKE[1] - LAKE[2], LAKE[1] + LAKE[2]]
    x1, z1, x2, z2 = int(min(xs)) - 8, int(min(zs)) - 8, int(max(xs)) + 8, int(max(zs)) + 8
    b = Build(x2 - x1 + 1, G + 2, z2 - z1 + 1)
    for x in range(x1, x2 + 1):
        for z in range(z1, z2 + 1):
            d = river_dist(x + 0.5, z + 0.5)
            if d > RIVER_W + 2.5:
                continue
            lx, lz = x - x1, z - z1
            if d <= RIVER_W:
                deep = d < RIVER_W - 1.5
                b.set(lx, G - 4, lz, 'gravel' if _hash(x, 0, z, 114) < 0.7 else 'sand')
                b.set(lx, G - 3, lz, 'water' if deep else ('gravel' if _hash(x, 1, z, 115) < 0.5 else 'sand'))
                b.set(lx, G - 2, lz, 'water'); b.set(lx, G - 1, lz, 'water')
                b.set(lx, G, lz, AIR)
            else:
                b.set(lx, G - 1, lz, 'sand' if d < RIVER_W + 1.3 else ('grass_block[snowy=false]' if _hash(x, 2, z, 116) < 0.6 else 'coarse_dirt'))
                if d > RIVER_W + 1.3 and _hash(x, 3, z, 117) < 0.12:
                    b.set(lx, G, lz, 'short_grass')
    b.origin = (x1, z1)
    return b


def bridge(length=17, width=7):
    """A red wooden arched bridge running north-south, for streets crossing the river."""
    b = Build(width + 2, G + 6, length)
    mid = (length - 1) / 2
    for z in range(length):
        rise = int(round(2.2 * (1 - ((z - mid) / mid) ** 2)))
        for x in range(1, width + 1):
            b.set(x, G - 1 + rise, z, 'spruce_planks' if (x + z) % 5 else 'stripped_spruce_wood[axis=z]')
            if rise:
                b.set(x, G - 2 + rise, z, slab('spruce_slab', 'top'))
        for x in (0, width + 1):
            b.set(x, G - 1 + rise, z, 'stripped_mangrove_wood[axis=z]')
            b.set(x, G + rise, z, st('mangrove_fence', waterlogged=False))
            if z % 4 == 0:
                b.set(x, G + 1 + rise, z, st('mangrove_fence', waterlogged=False))
                b.set(x, G + 2 + rise, z, st('lantern', hanging=False, waterlogged=False)) if z in (0, length - 1) else None
    return b


PIECES = {'wall_arc_%d' % i: (lambda i=i: wall_arc(i)) for i in range(len(ARCS))}
PIECES.update(mountain_west=lambda: mountain('west'), mountain_north=lambda: mountain('north'),
              mountain_east=lambda: mountain('east'), river=river,
              bridge=bridge)
ORIGINS = {'wall_arc_%d' % i: _arc_box(*ARCS[i])[:2] for i in range(len(ARCS))}
