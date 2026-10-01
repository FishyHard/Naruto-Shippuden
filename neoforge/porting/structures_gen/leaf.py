"""The Hidden Leaf Village's buildings (story chapters 1 and 2).

Every piece faces south (+z). y 0..1 is foundation (sunk into the ground); the ground floor is y = 2."""
from build import Build, st, stairs, slab, log, AIR, LEFT, RIGHT, OPP

G = 2  # ground floor height inside a template

# ---------------------------------------------------------------- palette
CREAM = 'smooth_sandstone'
CREAM2 = 'white_terracotta'
BAND = 'terracotta'
BASE = 'stone_bricks'
BASE2 = 'mossy_stone_bricks'
FLOOR = 'spruce_planks'
BEAM = 'stripped_dark_oak_log'
DARK = 'dark_oak_planks'
RED = 'red_terracotta'
RED2 = 'red_concrete'
WHITE = 'white_concrete'
ORANGE_ROOF, ORANGE_FULL = 'acacia_stairs', 'acacia_planks'
RED_ROOF, RED_FULL = 'mangrove_stairs', 'mangrove_planks'
GREEN_ROOF, GREEN_FULL = 'waxed_oxidized_cut_copper_stairs', 'waxed_oxidized_cut_copper'
DARK_ROOF = 'dark_oak_stairs'
PANE = 'glass_pane'
LEAVES = st('oak_leaves', distance=1, persistent=True, waterlogged=False)

# ---------------------------------------------------------------- glyphs (top row first)
FIRE = [  # 火
    '....#....',
    '.#..#..#.',
    '.#..#..#.',
    '#...#...#',
    '....#....',
    '...#.#...',
    '..#...#..',
    '.#.....#.',
    '#.......#',
]
A = [  # あ
    '...#.....',
    '#########',
    '...#.....',
    '..#####..',
    '.#.#...#.',
    '#..#...#.',
    '#.#....#.',
    '.#....#..',
    '.....#...',
]
N = [  # ん
    '...#.....',
    '...#.....',
    '..#......',
    '..#......',
    '.#.##....',
    '.##..#...',
    '.#...#..#',
    '#....#.#.',
    '#.....#..',
]
SHINOBI = [  # 忍
    '#######',
    '....#.#',
    '...#..#',
    '..#.#.#',
    '.#..#..',
    '..#....',
    '#.#.#.#',
    '#.#..##',
    '#..##.#',
]
CROSS = ['.###.', '#####', '#####', '#####', '.###.']


# ---------------------------------------------------------------- shared pieces
def foundation(b, x1, z1, x2, z2, top=BASE):
    b.fill(x1, 0, z1, x2, G - 1, z2, BASE)
    b.fill(x1, G - 1, z1, x2, G - 1, z2, top)


def windows_x(b, x1, x2, y, z, every=3, height=2, pane=PANE, skip=()):
    for x in range(x1, x2 + 1, every):
        if x in skip:
            continue
        for dy in range(height):
            b.set(x, y + dy, z, pane)


def windows_z(b, z1, z2, y, x, every=3, height=2, pane=PANE, skip=()):
    for z in range(z1, z2 + 1, every):
        if z in skip:
            continue
        for dy in range(height):
            b.set(x, y + dy, z, pane)


def band(b, x1, z1, x2, z2, y, state=BAND):
    """A horizontal stripe round a rectangular building's outside."""
    for x in range(x1, x2 + 1):
        b.set(x, y, z1, state); b.set(x, y, z2, state)
    for z in range(z1, z2 + 1):
        b.set(x1, y, z, state); b.set(x2, y, z, state)


def corners(b, x1, z1, x2, z2, y1, y2, state=BEAM):
    for x, z in ((x1, z1), (x1, z2), (x2, z1), (x2, z2)):
        b.fill(x, y1, z, x, y2, z, log(state))


def flight(b, x, y, z, facing, steps, stair=st('spruce_stairs'), clear=3):
    """Stairs climbing `steps` blocks toward `facing` from (x, y, z), with headroom cleared above."""
    dx, dz = {'north': (0, -1), 'south': (0, 1), 'east': (1, 0), 'west': (-1, 0)}[facing]
    for i in range(steps):
        sx, sy, sz = x + dx * i, y + i, z + dz * i
        b.set(sx, sy, sz, stairs(stair.split('[')[0], facing))
        for h in range(1, clear + 1):
            b.set(sx, sy + h, sz, AIR)


def water_tank(b, x, y, z):
    """The round water tanks on Leaf rooftops: a short drum on legs."""
    for dx, dz in ((-1, -1), (1, -1), (-1, 1), (1, 1)):
        b.set(x + dx, y, z + dz, st('spruce_fence', waterlogged=False))
    b.disc(x, y + 1, z, 1.5, 'light_gray_terracotta')
    b.disc(x, y + 2, z, 1.5, 'light_gray_terracotta')
    b.disc(x, y + 3, z, 1.5, slab('smooth_stone_slab'))


def table(b, x, y, z, top='spruce_pressure_plate'):
    b.set(x, y, z, st('spruce_fence', waterlogged=False))
    b.set(x, y + 1, z, st(top, powered=False))


def chair(b, x, y, z, facing):
    # a stair "seat": its back (the full side) is where the sitter leans
    b.set(x, y, z, stairs('spruce_stairs', OPP[facing]))


def bed(b, x, y, z, facing='north', color='white'):
    """`facing` is where the head points; the head is at (x, z), the foot one step back."""
    dx, dz = {'north': (0, 1), 'south': (0, -1), 'east': (-1, 0), 'west': (1, 0)}[facing]
    b.set(x, y, z, st(color + '_bed', facing=facing, part='head', occupied=False))
    b.set(x + dx, y, z + dz, st(color + '_bed', facing=facing, part='foot', occupied=False))


def wall_banner(b, x, y, z, facing, color='white'):
    b.set(x, y, z, st(color + '_wall_banner', facing=facing))


def tree(b, x, y, z, height=6, r=3, trunk='oak_log', leaves=LEAVES):
    """A tree, if it has room: nothing but air or leaves where its trunk and crown would go (so trees never grow into
    buildings). Returns whether it was planted."""
    for yy in range(y, y + height + 3):
        rr = 0 if yy < y + height - 2 else r + 1
        for dx in range(-rr, rr + 1):
            for dz in range(-rr, rr + 1):
                s_ = b.blocks.get((x + dx, yy, z + dz))
                if s_ is not None and s_ != AIR and 'leaves' not in s_:
                    return False
    for i in range(height):
        b.set(x, y + i, z, log(trunk))
    top = y + height
    for dy in range(-2, 2):
        rr = r - (1 if dy == 1 else 0) - (1 if dy == -2 else 0)
        for dx in range(-rr, rr + 1):
            for dz in range(-rr, rr + 1):
                if dx * dx + dz * dz <= rr * rr + 1 and (x + dx, top + dy, z + dz) not in b.blocks:
                    b.set(x + dx, top + dy, z + dz, leaves)
    b.set(x, top + 2, z, leaves)
    return True


def lamp_post(b, x, y, z, h=3):
    for i in range(h):
        b.set(x, y + i, z, st('dark_oak_fence', waterlogged=False))
    b.lantern(x, y + h, z)


# ---------------------------------------------------------------- houses
def house_a():
    """Two floors, flat roof with a parapet and a water tank: the typical Leaf home."""
    b = Build(11, 15, 11)
    x1, z1, x2, z2 = 1, 1, 9, 9
    foundation(b, x1, z1, x2, z2, FLOOR)
    b.box(x1, G, z1, x2, G + 8, z2, CREAM)
    corners(b, x1, z1, x2, z2, G, G + 8)
    band(b, x1, z1, x2, z2, G + 4)
    b.fill(x1 + 1, G + 4, z1 + 1, x2 - 1, G + 4, z2 - 1, FLOOR)  # upper floor
    band(b, x1, z1, x2, z2, G + 8)
    # flat roof and parapet
    b.fill(x1, G + 9, z1, x2, G + 9, z2, slab('smooth_sandstone_slab', 'double'))
    for x in range(x1, x2 + 1):
        for z in (z1, z2):
            b.set(x, G + 10, z, slab('smooth_sandstone_slab'))
    for z in range(z1, z2 + 1):
        for x in (x1, x2):
            b.set(x, G + 10, z, slab('smooth_sandstone_slab'))
    water_tank(b, 6, G + 10, 4)
    # front: door with a small awning
    b.door(5, G, z2, 'spruce', 'south')
    for x in range(4, 7):
        b.set(x, G + 3, z2 + 1, stairs(ORANGE_ROOF, 'north'))
    windows_x(b, 3, 7, G + 1, z2, every=4)
    windows_x(b, 3, 7, G + 5, z2, every=2)
    windows_x(b, 3, 7, G + 1, z1, every=4)
    windows_x(b, 3, 7, G + 5, z1, every=4)
    windows_z(b, 3, 7, G + 1, x1, every=4)
    windows_z(b, 3, 7, G + 5, x2, every=4)
    # inside: a kitchen corner, a table, a ladder up, a bed upstairs
    b.set(x2 - 1, G, z1 + 1, st('barrel', facing='up', open=False))
    b.set(x2 - 2, G, z1 + 1, st('smoker', facing='south', lit=False))
    b.set(x2 - 3, G, z1 + 1, 'water_cauldron[level=3]')
    table(b, 4, G, 5)
    chair(b, 3, G, 5, 'east'); chair(b, 5, G, 5, 'west')
    for y in range(G, G + 5):
        b.set(x1 + 1, y, z1 + 1, st('ladder', facing='south', waterlogged=False))
    b.set(x1 + 1, G + 4, z1 + 1, st('ladder', facing='south', waterlogged=False))
    bed(b, 7, G + 5, 6, 'north', 'red')
    b.set(7, G + 5, 3, st('chest', facing='south', type='single', waterlogged=False))
    b.lantern(5, G + 3, 5, hanging=True)
    b.lantern(5, G + 7, 5, hanging=True)
    b.set(3, G + 5, 7, 'potted_bamboo')
    return b


def house_b():
    """A long two-floor house with an orange hip roof and a balcony."""
    b = Build(11, 17, 15)
    x1, z1, x2, z2 = 1, 1, 9, 12
    foundation(b, x1, z1, x2, z2, FLOOR)
    b.box(x1, G, z1, x2, G + 8, z2, CREAM2)
    corners(b, x1, z1, x2, z2, G, G + 8)
    band(b, x1, z1, x2, z2, G + 4, BAND)
    b.fill(x1 + 1, G + 4, z1 + 1, x2 - 1, G + 4, z2 - 1, FLOOR)
    b.hip(x1, z1, x2, z2, G + 9, ORANGE_ROOF, ORANGE_FULL, over=1, eave=DARK_ROOF)
    b.fill(x1, G + 9, z1, x2, G + 9, z2, ORANGE_FULL)
    b.hip(x1, z1, x2, z2, G + 9, ORANGE_ROOF, ORANGE_FULL, over=1)
    # balcony over the door
    b.fill(3, G + 4, z2 + 1, 7, G + 4, z2 + 2, slab('spruce_slab', 'top'))
    for x in range(3, 8):
        b.set(x, G + 5, z2 + 2, st('spruce_fence', waterlogged=False))
    b.set(3, G + 5, z2 + 1, st('spruce_fence', waterlogged=False))
    b.set(7, G + 5, z2 + 1, st('spruce_fence', waterlogged=False))
    b.door(5, G + 5, z2, 'spruce', 'south')
    b.door(5, G, z2, 'spruce', 'south')
    b.lantern(5, G + 3, z2 + 1, hanging=True)
    windows_x(b, 3, 7, G + 1, z2, every=4)
    windows_z(b, 3, 10, G + 1, x1, every=3)
    windows_z(b, 3, 10, G + 5, x1, every=3)
    windows_z(b, 3, 10, G + 1, x2, every=3)
    windows_z(b, 3, 10, G + 5, x2, every=3)
    windows_x(b, 3, 7, G + 5, z1, every=2)
    # inside
    flight(b, x1 + 1, G, z1 + 6, 'north', 4)
    b.fill(x1 + 1, G + 4, z1 + 2, x1 + 1, G + 4, z1 + 5, AIR)
    table(b, 6, G, 8); chair(b, 6, G, 9, 'north'); chair(b, 6, G, 7, 'south')
    b.set(x2 - 1, G, z1 + 1, st('crafting_table'))
    b.set(x2 - 2, G, z1 + 1, st('furnace', facing='south', lit=False))
    bed(b, 7, G + 5, 3, 'north', 'blue')
    bed(b, 4, G + 5, 9, 'north', 'blue')
    b.set(7, G + 5, 9, st('bookshelf'))
    b.lantern(5, G + 3, 6, hanging=True)
    b.lantern(5, G + 8, 6, hanging=True)
    return b


def house_round():
    """A round house with a green cone roof."""
    b = Build(15, 17, 15)
    c = 7
    for y in range(0, G):
        b.disc(c, y, c, 6, BASE)
    b.disc(c, G - 1, c, 5, FLOOR)
    b.cylinder(c, G, c, 6, G + 7, CREAM)
    b.ring(c, G + 3, c, 6, BAND)
    b.disc(c, G + 4, c, 5, FLOOR)
    b.cylinder(c, G + 5, c, 6, G + 7, CREAM, inner=AIR)
    b.ring(c, G + 7, c, 6, BAND)
    b.cone(c, G + 8, c, 7, GREEN_ROOF, GREEN_FULL, eave=DARK_ROOF)
    for (x, z) in b.ring_points(c, c, 6):
        if (x + z) % 4 == 0 and z != c + 6:
            b.set(x, G + 1, z, PANE); b.set(x, G + 5, z, PANE)
    b.door(c, G, c + 6, 'spruce', 'south')
    b.set(c, G + 2, c + 6, CREAM)
    for y in range(G, G + 5):
        b.set(c, y, c - 5, st('ladder', facing='south', waterlogged=False))
    b.set(c, G + 4, c - 5, st('ladder', facing='south', waterlogged=False))
    table(b, c, G, c); chair(b, c - 1, G, c, 'east'); chair(b, c + 1, G, c, 'west')
    b.set(c + 4, G, c - 2, st('barrel', facing='up', open=False))
    bed(b, c + 3, G + 5, c - 1, 'north', 'green')
    b.lantern(c, G + 3, c, hanging=True)
    b.lantern(c, G + 7, c, hanging=True)
    b.set(c + 2, G + 3, c + 7, stairs(DARK_ROOF, 'north'))
    b.set(c - 2, G + 3, c + 7, stairs(DARK_ROOF, 'north'))
    return b


# ---------------------------------------------------------------- the Hokage tower (mission desk and the Kage's office)
def hokage_tower():
    R = 12
    b = Build(29, 40, 29)
    c = 14
    for y in range(0, G):
        b.disc(c, y, c, R + 1, BASE)
    b.disc(c, G - 1, c, R - 1, 'polished_andesite')
    # three floors of red walls with white bands
    b.cylinder(c, G, c, R, G + 17, RED)
    for y in (G + 5, G + 11, G + 17):
        b.ring(c, y, c, R, WHITE)
        b.disc(c, y, c, R - 1, FLOOR)
    # window rings
    for (x, z) in b.ring_points(c, c, R):
        ang = (x - c, z - c)
        if (x * 3 + z) % 5 == 0:
            for y in (G + 2, G + 3, G + 8, G + 9, G + 14, G + 15):
                b.set(x, y, z, 'orange_stained_glass_pane' if y < G + 6 else PANE)
    # entrance: a wide door with a porch roof
    for x in range(c - 2, c + 3):
        for y in range(G, G + 4):
            b.set(x, y, c + R, AIR)
            b.set(x, y, c + R - 1, AIR)
    for x in range(c - 3, c + 4):
        b.set(x, G + 4, c + R + 1, stairs(RED_ROOF, 'north'))
        b.set(x, G + 4, c + R, RED_FULL)
    b.set(c - 3, G, c + R + 1, log(BEAM)); b.set(c - 3, G + 1, c + R + 1, log(BEAM))
    b.set(c - 3, G + 2, c + R + 1, log(BEAM)); b.set(c - 3, G + 3, c + R + 1, log(BEAM))
    b.set(c + 3, G, c + R + 1, log(BEAM)); b.set(c + 3, G + 1, c + R + 1, log(BEAM))
    b.set(c + 3, G + 2, c + R + 1, log(BEAM)); b.set(c + 3, G + 3, c + R + 1, log(BEAM))
    b.lantern(c - 2, G + 3, c + R + 1, hanging=True)
    b.lantern(c + 2, G + 3, c + R + 1, hanging=True)
    # roof: a shallow red cone ring, then the round white sign with 火 at the front
    top = G + 18
    b.disc(c, top, c, R, RED_FULL)
    rr = R + 1
    y = top
    for k in range(3):
        for (x, z) in b.ring_points(c, c, rr - k):
            dx, dz = c - x, c - z
            f = ('east' if dx > 0 else 'west') if abs(dx) >= abs(dz) else ('south' if dz > 0 else 'north')
            b.set(x, y + k, z, stairs(RED_ROOF, f))
        b.disc(c, y + k, c, rr - k - 1, RED_FULL)
    # a drum on the roof
    b.cylinder(c, top + 3, c, 6, top + 7, RED)
    b.ring(c, top + 7, c, 6, WHITE)
    b.cone(c, top + 8, c, 7, RED_ROOF, RED_FULL, eave=RED_ROOF)
    # the round 火 sign facing south, standing at the front of the roof
    sz = c + 7
    for dx in range(-6, 7):
        for dy in range(-6, 7):
            if dx * dx + dy * dy <= 42:
                b.set(c + dx, top + 9 + dy, sz, WHITE)
            elif dx * dx + dy * dy <= 56:
                b.set(c + dx, top + 9 + dy, sz, RED2)
    b.glyph(FIRE, c - 4, top + 5, sz, RED2)
    for y in range(top + 1, top + 4):
        b.set(c - 2, y, sz, log(BEAM)); b.set(c + 2, y, sz, log(BEAM))
    # ground floor: the mission desk
    for x in range(c - 4, c + 5):
        b.set(x, G, c - 2, stairs('spruce_stairs', 'north', top=True))
    b.set(c - 5, G, c - 2, st('spruce_planks')); b.set(c + 5, G, c - 2, st('spruce_planks'))
    for x in (c - 3, c, c + 3):
        chair(b, x, G, c - 3, 'south')
    b.set(c - 2, G + 1, c - 2, st('lectern', facing='south', has_book=False, powered=False))
    for x in range(c - 6, c + 7):
        if b.get(x, G, c - 9) is None or b.get(x, G, c - 9) == AIR:
            pass
    for x in range(c - 5, c + 6):
        for y in (G, G + 1, G + 2):
            if b.get(x, y, c - 10) == AIR:
                b.set(x, y, c - 10, 'bookshelf')
    # a board of mission scrolls behind the desk
    for x in range(c - 3, c + 4):
        b.set(x, G + 2, c - 9, 'spruce_planks')
        b.set(x, G + 3, c - 9, 'spruce_planks')
    b.lantern(c, G + 4, c, hanging=True)
    b.lantern(c - 6, G + 4, c + 3, hanging=True)
    b.lantern(c + 6, G + 4, c + 3, hanging=True)
    # stairs between floors along the east wall
    for fy in (G, G + 6):
        flight(b, c + 9, fy, c + 4, 'north', 5)
        flight(b, c + 9, fy + 5, c - 1, 'north', 1)
        b.fill(c + 9, fy + 5, c - 1, c + 9, fy + 5, c + 4, AIR) if fy + 5 in (G + 5, G + 11) else None
    for fy in (G, G + 6):
        b.fill(c + 9, fy + 5, c, c + 9, fy + 5, c + 4, AIR)
    flight(b, c + 9, G + 12, c + 4, 'north', 5)
    b.fill(c + 9, G + 17, c, c + 9, G + 17, c + 4, AIR)
    # top floor: the Kage's office, the desk before the north windows
    oy = G + 12
    for x in range(c - 2, c + 3):
        b.set(x, oy, c - 6, stairs('dark_oak_stairs', 'south', top=True))
    chair(b, c, oy, c - 7, 'south')
    b.set(c - 2, oy + 1, c - 6, 'potted_bamboo')
    for x in (c - 5, c + 5):
        b.set(x, oy, c - 8, 'bookshelf'); b.set(x, oy + 1, c - 8, 'bookshelf')
    for x in range(c - 3, c + 4):
        b.set(x, oy, c + 2, st('red_carpet'))
        b.set(x, oy, c + 1, st('red_carpet'))
    b.lantern(c, oy + 4, c, hanging=True)
    # middle floor: a meeting room
    my = G + 6
    for x in range(c - 4, c + 5):
        b.set(x, my, c, slab('dark_oak_slab', 'top'))
    for x in range(c - 4, c + 5, 2):
        chair(b, x, my, c - 1, 'south'); chair(b, x, my, c + 1, 'north')
    b.lantern(c, my + 4, c, hanging=True)
    return b


# ---------------------------------------------------------------- the gate and wall
def gate():
    """The great gate: two tall posts, a roofed beam, open green doors painted あ and ん, guard booth inside."""
    W, D = 37, 15
    b = Build(W, 30, D)
    z0 = 4  # the wall line (wall is z0..z0+2)
    mid = W // 2
    gap = 6  # half the opening
    # walls left and right
    for x in list(range(0, mid - gap - 3)) + list(range(mid + gap + 4, W)):
        b.fill(x, 0, z0, x, G + 15, z0 + 2, CREAM2)
        b.fill(x, 0, z0, x, G, z0 + 2, BASE)
        b.set(x, G + 12, z0 + 2, BAND)
        b.set(x, G + 12, z0, BAND)
        b.set(x, G + 16, z0 - 1, stairs(DARK_ROOF, 'south'))
        b.set(x, G + 16, z0 + 3, stairs(DARK_ROOF, 'north'))
        b.set(x, G + 16, z0, DARK); b.set(x, G + 16, z0 + 1, DARK); b.set(x, G + 16, z0 + 2, DARK)
        b.set(x, G + 17, z0 + 1, slab('dark_oak_slab'))
    # the posts
    for px in (mid - gap - 3, mid + gap + 1):
        b.fill(px, 0, z0 - 1, px + 2, G + 18, z0 + 3, 'stripped_spruce_log[axis=y]')
        b.fill(px, 0, z0 - 1, px + 2, G, z0 + 3, BASE)
    # the opening
    b.fill(mid - gap, G, z0 - 1, mid + gap, G + 13, z0 + 3, AIR)
    b.fill(mid - gap, 0, z0 - 1, mid + gap, G - 1, z0 + 3, 'polished_andesite')
    # the beam with 忍 and the roof
    b.fill(mid - gap - 4, G + 14, z0 - 1, mid + gap + 4, G + 17, z0 + 3, DARK)
    b.fill(mid - 4, G + 14, z0 + 4, mid + 4, G + 17, z0 + 4, WHITE)
    b.glyph(SHINOBI, mid - 3, G + 14, z0 + 4, RED2) if False else None
    b.fill(mid - 4, G + 14, z0 - 2, mid + 4, G + 17, z0 - 2, WHITE)
    for x in range(mid - gap - 6, mid + gap + 7):
        b.set(x, G + 18, z0 - 3, stairs(DARK_ROOF, 'south'))
        b.set(x, G + 18, z0 + 5, stairs(DARK_ROOF, 'north'))
        b.fill(x, G + 18, z0 - 2, x, G + 18, z0 + 4, DARK)
        b.set(x, G + 19, z0 - 2, stairs(DARK_ROOF, 'south'))
        b.set(x, G + 19, z0 + 4, stairs(DARK_ROOF, 'north'))
        b.fill(x, G + 19, z0 - 1, x, G + 19, z0 + 3, DARK)
        b.set(x, G + 20, z0 - 1, stairs(DARK_ROOF, 'south'))
        b.set(x, G + 20, z0 + 3, stairs(DARK_ROOF, 'north'))
        b.fill(x, G + 20, z0, x, G + 20, z0 + 2, DARK)
        b.set(x, G + 21, z0, stairs(DARK_ROOF, 'south'))
        b.set(x, G + 21, z0 + 2, stairs(DARK_ROOF, 'north'))
        b.set(x, G + 21, z0 + 1, slab('dark_oak_slab'))
        b.set(x, G + 17, z0 - 3, stairs(DARK_ROOF, 'north', top=True))
        b.set(x, G + 17, z0 + 5, stairs(DARK_ROOF, 'south', top=True))
    # 火 signs on the beam, both faces: south is the outside (the village is north)
    b.glyph(FIRE, mid - 4, G + 13, z0 + 4, RED2)
    b.fill(mid - 5, G + 13, z0 + 4, mid + 5, G + 17, z0 + 4, WHITE) if False else None
    b.glyph(FIRE, mid - 4, G + 13, z0 - 2, RED2, flip=True)
    # the doors: open, folded back against the inside (north) of the wall, painted あ and ん
    for x in range(mid - gap - 2 - 6, mid - gap - 2):
        b.fill(x + 1, G, z0 - 1, x + 1, G + 12, z0 - 1, 'green_terracotta')
    for x in range(mid + gap + 3, mid + gap + 3 + 6):
        b.fill(x - 1, G, z0 - 1, x - 1, G + 12, z0 - 1, 'green_terracotta')
    b.glyph(A, mid - gap - 2 - 7 + 1, G + 2, z0 - 1, RED2) if False else None
    # the doors are 6 wide; the glyphs (9 wide) go on a 6-wide door as their middle part — draw a red ring instead
    for (dx0) in (mid - gap - 8, mid + gap + 2):
        for y in range(G + 1, G + 12):
            b.set(dx0 + 0, y, z0 - 2, AIR)
    # 'あ' and 'ん' painted large across both doors' inner faces (7 wide each)
    small_a = ['..#....', '#######', '..#....', '.#####.', '#.#..#.', '##...#.', '.#..#..']
    small_n = ['..#....', '..#....', '.#.....', '.##....', '#..#...', '#..#..#', '#...##.']
    b.glyph(small_a, mid - gap - 8, G + 4, z0 - 2, RED2)
    b.glyph(small_n, mid + gap + 2, G + 4, z0 - 2, RED2)
    # guard booth inside, to the east: a roofed desk with two seats
    bx = mid + gap + 4
    bz = 0
    b.fill(bx, G, bz, bx + 7, G, bz + 2, st('spruce_planks'))
    for x in range(bx, bx + 8):
        b.set(x, G + 1, bz + 2, slab('spruce_slab', 'top'))
    for x in (bx, bx + 7):
        for y in range(G + 1, G + 5):
            b.set(x, y, bz, log(BEAM)); b.set(x, y, bz + 2, log(BEAM))
    for x in range(bx - 1, bx + 9):
        b.set(x, G + 5, bz + 3, stairs(DARK_ROOF, 'south'))
        b.set(x, G + 5, bz + 2, DARK); b.set(x, G + 5, bz + 1, DARK); b.set(x, G + 5, bz, DARK)
    chair(b, bx + 2, G + 1, bz + 1, 'south'); chair(b, bx + 5, G + 1, bz + 1, 'south')
    b.lantern(bx + 4, G + 4, bz + 1, hanging=True)
    # lanterns either side outside
    lamp_post(b, mid - gap - 4, G, z0 + 5)
    lamp_post(b, mid + gap + 4, G, z0 + 5)
    return b


def wall():
    """A straight piece of the village wall (16 long), to be tiled round the village."""
    b = Build(16, 20, 5)
    for x in range(16):
        b.fill(x, 0, 1, x, G + 15, 3, CREAM2)
        b.fill(x, 0, 1, x, G, 3, BASE)
        b.set(x, G + 12, 3, BAND); b.set(x, G + 12, 1, BAND)
        b.set(x, G + 16, 0, stairs(DARK_ROOF, 'south'))
        b.set(x, G + 16, 4, stairs(DARK_ROOF, 'north'))
        b.fill(x, G + 16, 1, x, G + 16, 3, DARK)
        b.set(x, G + 17, 2, slab('dark_oak_slab'))
        if x % 8 == 3:
            b.fill(x, G + 2, 3, x, G + 11, 3, log(BEAM))
            b.fill(x, G + 2, 1, x, G + 11, 1, log(BEAM))
    return b


# ---------------------------------------------------------------- the Academy
def academy():
    """Three floors, an orange hip roof, a porch over the door, a classroom of rising rows before a blackboard."""
    W, D = 31, 19
    b = Build(W, 26, D)
    x1, z1, x2, z2 = 1, 1, W - 2, 15
    foundation(b, x1, z1, x2, z2, FLOOR)
    b.box(x1, G, z1, x2, G + 13, z2, CREAM)
    corners(b, x1, z1, x2, z2, G, G + 13)
    for x in (x1 + 7, x2 - 7):
        b.fill(x, G, z2, x, G + 13, z2, log(BEAM)); b.fill(x, G, z1, x, G + 13, z1, log(BEAM))
    for y in (G + 4, G + 9):
        band(b, x1, z1, x2, z2, y)
        b.fill(x1 + 1, y, z1 + 1, x2 - 1, y, z2 - 1, FLOOR)
    band(b, x1, z1, x2, z2, G + 13)
    b.fill(x1, G + 14, z1, x2, G + 14, z2, ORANGE_FULL)
    b.hip(x1, z1, x2, z2, G + 14, ORANGE_ROOF, ORANGE_FULL, over=1, eave=DARK_ROOF)
    # windows on every floor
    for y in (G + 1, G + 6, G + 10):
        windows_x(b, x1 + 2, x2 - 2, y, z2, every=3, height=2, skip=(x1 + 7, x2 - 7, 14, 15, 16))
        windows_x(b, x1 + 2, x2 - 2, y, z1, every=3, height=2, skip=(x1 + 7, x2 - 7))
        windows_z(b, z1 + 3, z2 - 3, y, x1, every=3)
        windows_z(b, z1 + 3, z2 - 3, y, x2, every=3)
    # the front door and porch
    m = W // 2
    for x in (m - 1, m, m + 1):
        for y in range(G, G + 3):
            b.set(x, y, z2, AIR)
    b.door(m - 1, G, z2, 'spruce', 'south', 'left')
    b.door(m + 1, G, z2, 'spruce', 'south', 'right')
    b.set(m, G, z2, AIR); b.set(m, G + 1, z2, AIR)
    for x in range(m - 3, m + 4):
        b.set(x, G + 4, z2 + 2, stairs(ORANGE_ROOF, 'north'))
        b.set(x, G + 4, z2 + 1, ORANGE_FULL)
    for x in (m - 3, m + 3):
        for y in range(G, G + 4):
            b.set(x, y, z2 + 2, log(BEAM))
    b.lantern(m, G + 3, z2 + 1, hanging=True)
    # the 忍 crest over the porch
    b.fill(m - 4, G + 5, z2 + 1, m + 4, G + 14, z2 + 1, WHITE)
    b.glyph(SHINOBI, m - 3, G + 5, z2 + 1, RED2)
    # ground floor: hall, a staircase, the teachers' room
    flight(b, x2 - 2, G, z1 + 7, 'north', 4)
    b.fill(x2 - 2, G + 4, z1 + 2, x2 - 2, G + 4, z1 + 6, AIR)
    flight(b, x2 - 2, G + 5, z1 + 7, 'north', 4)
    b.fill(x2 - 2, G + 9, z1 + 2, x2 - 2, G + 9, z1 + 6, AIR)
    for x in range(x1 + 2, x1 + 7):
        table(b, x, G, z1 + 3)
    for x in range(x1 + 2, x1 + 7):
        chair(b, x, G, z1 + 4, 'north')
    b.fill(x1 + 1, G, z1 + 1, x1 + 6, G + 2, z1 + 1, 'bookshelf')
    for x in range(x1 + 2, x2 - 1, 6):
        b.lantern(x, G + 3, 8, hanging=True)
    # first floor: the classroom — rows of desks rising toward the back (south), the blackboard on the north wall
    cy = G + 5
    b.fill(x1 + 4, cy, z1, x2 - 6, cy + 2, z1, 'black_concrete')
    b.fill(x1 + 3, cy + 3, z1 + 1, x2 - 5, cy + 3, z1 + 1, slab('spruce_slab', 'top')) if False else None
    b.set(m, cy, z1 + 3, st('lectern', facing='south', has_book=False, powered=False))
    for row in range(4):
        z = z1 + 6 + row * 2
        h = row  # each row one step higher
        if h:
            b.fill(x1 + 3, cy, z, x2 - 5, cy + h - 1, z + 1, FLOOR)
        for x in range(x1 + 3, x2 - 4):
            b.set(x, cy + h, z, slab('spruce_slab', 'bottom') if x % 2 else stairs('spruce_stairs', 'north', top=True))
            b.set(x, cy + h, z + 1, stairs('spruce_stairs', 'south'))
    for x in range(x1 + 3, x2 - 1, 5):
        b.lantern(x, cy + 3, 4, hanging=True)
    # second floor: a library
    ly = G + 10
    for z in range(z1 + 2, z2 - 1, 3):
        b.fill(x1 + 3, ly, z, x2 - 5, ly + 1, z, 'bookshelf')
    for x in range(x1 + 3, x2 - 4, 6):
        b.lantern(x, ly + 2, 3, hanging=True)
    return b


def academy_yard():
    """The yard in front of the Academy: the swing tree, throwing targets and a sparring ring."""
    b = Build(31, 14, 21)
    # the swing tree
    tree(b, 5, G, 5, height=7, r=4)
    for x in range(5, 9):
        b.set(x, G + 6, 5, log('oak_log', 'x'))
    for y in range(G + 2, G + 6):
        b.set(8, y, 4, st('iron_chain', axis='y', waterlogged=False)); b.set(8, y, 6, st('iron_chain', axis='y', waterlogged=False))
    b.set(8, G + 1, 4, slab('oak_slab', 'top')); b.set(8, G + 1, 5, slab('oak_slab', 'top')); b.set(8, G + 1, 6, slab('oak_slab', 'top'))
    for y in range(G + 1, G + 6):
        b.set(8, y, 5, AIR)
    # throwing targets on posts
    for i, z in enumerate((3, 7, 11, 15)):
        b.set(27, G, z, st('spruce_fence', waterlogged=False))
        b.set(27, G + 1, z, st('target', power=0))
        b.set(16, G - 1, z, 'coarse_dirt')  # where to throw from
    # sparring ring of sand bordered with stone
    cx, cz = 15, 13
    for dx in range(-5, 6):
        for dz in range(-4, 5):
            edge = abs(dx) == 5 or abs(dz) == 4
            b.set(cx + dx, G - 1, cz + dz, 'stone_bricks' if edge else 'sand')
    # training dummies (wooden posts with a cross beam)
    for x in (4, 9):
        b.fill(x, G, 15, x, G + 1, 15, log('stripped_oak_log'))
        b.set(x, G + 2, 15, 'hay_block[axis=y]')
        b.set(x - 1, G + 1, 15, log('stripped_oak_log', 'x')); b.set(x + 1, G + 1, 15, log('stripped_oak_log', 'x'))
    # benches
    for x in range(20, 25):
        b.set(x, G, 19, stairs('spruce_stairs', 'south'))
    lamp_post(b, 12, G, 1)
    lamp_post(b, 19, G, 1)
    return b


# ---------------------------------------------------------------- Ichiraku Ramen
def ramen_shop():
    b = Build(11, 9, 10)
    x1, z1, x2, z2 = 1, 1, 9, 7
    foundation(b, x1, z1, x2, z2, FLOOR)
    # back and side walls; the front is the open counter
    b.fill(x1, G, z1, x2, G + 3, z1, CREAM2)
    b.fill(x1, G, z1, x1, G + 3, z2, CREAM2)
    b.fill(x2, G, z1, x2, G + 3, z2, CREAM2)
    b.fill(x1 + 1, G, z1 + 1, x2 - 1, G + 3, z2, AIR)
    # the counter and the stools in front of it
    for x in range(x1 + 1, x2):
        b.set(x, G, z2 - 1, st('spruce_planks'))
        b.set(x, G + 1, z2 - 1, slab('spruce_slab', 'bottom'))
    for x in range(x1 + 1, x2, 2):
        b.set(x, G, z2 + 1, st('spruce_fence', waterlogged=False))
        b.set(x, G + 1, z2 + 1, st('red_carpet'))
    # the kitchen: the pots, a stove and the counter behind
    b.set(x1 + 2, G, z1 + 1, 'water_cauldron[level=3]')
    b.set(x1 + 3, G, z1 + 1, st('smoker', facing='south', lit=True))
    b.set(x1 + 4, G, z1 + 1, 'water_cauldron[level=3]')
    b.set(x1 + 5, G, z1 + 1, st('barrel', facing='up', open=False))
    b.set(x1 + 6, G, z1 + 1, st('barrel', facing='up', open=False))
    b.set(x1 + 7, G, z1 + 1, st('crafting_table'))
    b.fill(x1 + 2, G + 2, z1 + 1, x1 + 6, G + 2, z1 + 1, slab('spruce_slab', 'top'))
    # the roof and the white noren cloths over the counter
    b.fill(x1, G + 4, z1, x2, G + 4, z2, RED_FULL)
    b.gable(x1, z1, x2, z2, G + 4, RED_ROOF, slab('mangrove_slab'), axis='x', over=1)
    for x in range(x1 + 1, x2):
        wall_banner(b, x, G + 3, z2, 'south', 'white')
    b.lantern(x1, G + 3, z2 + 1, hanging=True) if False else None
    b.set(x1 - 0, G + 3, z2 + 1, st('red_wall_banner', facing='south')) if False else None
    b.lantern(x1 + 1, G + 3, z2 - 2, hanging=True)
    b.lantern(x2 - 1, G + 3, z2 - 2, hanging=True)
    b.lantern(x1, G + 4, z2 + 2, hanging=True) if False else None
    return b


# ---------------------------------------------------------------- the hospital
def hospital():
    W, D = 25, 17
    b = Build(W, 24, D + 3)
    x1, z1, x2, z2 = 1, 1, W - 2, D - 1
    foundation(b, x1, z1, x2, z2, 'white_concrete')
    b.box(x1, G, z1, x2, G + 14, z2, 'white_concrete')
    for y in (G + 5, G + 10):
        band(b, x1, z1, x2, z2, y, 'light_gray_concrete')
        b.fill(x1 + 1, y, z1 + 1, x2 - 1, y, z2 - 1, 'smooth_quartz')
    band(b, x1, z1, x2, z2, G + 14, 'light_gray_concrete')
    b.fill(x1, G + 15, z1, x2, G + 15, z2, slab('smooth_quartz_slab', 'double'))
    for x in range(x1, x2 + 1):
        b.set(x, G + 16, z1, slab('smooth_quartz_slab')); b.set(x, G + 16, z2, slab('smooth_quartz_slab'))
    for z in range(z1, z2 + 1):
        b.set(x1, G + 16, z, slab('smooth_quartz_slab')); b.set(x2, G + 16, z, slab('smooth_quartz_slab'))
    water_tank(b, x1 + 4, G + 16, z1 + 4)
    water_tank(b, x2 - 4, G + 16, z1 + 4)
    for y in (G + 1, G + 6, G + 11):
        windows_x(b, x1 + 2, x2 - 2, y, z2, every=2, height=3 if y > G + 1 else 2, pane='light_blue_stained_glass_pane',
                  skip=(11, 12, 13))
        windows_x(b, x1 + 2, x2 - 2, y, z1, every=2, height=3 if y > G + 1 else 2, pane='light_blue_stained_glass_pane')
        windows_z(b, z1 + 2, z2 - 2, y, x1, every=2, height=3 if y > G + 1 else 2, pane='light_blue_stained_glass_pane')
        windows_z(b, z1 + 2, z2 - 2, y, x2, every=2, height=3 if y > G + 1 else 2, pane='light_blue_stained_glass_pane')
    m = W // 2
    for x in (m - 1, m, m + 1):
        for y in range(G, G + 3):
            b.set(x, y, z2, AIR)
    b.door(m - 1, G, z2, 'birch', 'south', 'left'); b.door(m + 1, G, z2, 'birch', 'south', 'right')
    for x in range(m - 3, m + 4):
        b.set(x, G + 4, z2 + 1, slab('smooth_quartz_slab', 'top'))
        b.set(x, G + 4, z2 + 2, slab('smooth_quartz_slab', 'top'))
    # the red cross over the door
    b.glyph(CROSS, m - 2, G + 7, z2 + 1, RED2) if False else None
    cross = ['..#..', '..#..', '#####', '..#..', '..#..']
    b.fill(m - 3, G + 6, z2 + 1, m + 3, G + 12, z2 + 1, 'white_concrete')
    b.glyph(cross, m - 2, G + 7, z2 + 1, RED2)
    # wards: rows of beds
    for fy in (G, G + 6, G + 11):
        for x in range(x1 + 2, x2 - 1, 3):
            if fy == G and m - 3 <= x <= m + 3:
                continue
            bed(b, x, fy, z1 + 1, 'north', 'white')
            b.set(x + 1, fy, z1 + 1, st('white_carpet'))
        for x in range(x1 + 3, x2 - 1, 6):
            b.lantern(x, fy + 3 if fy == G else fy + 3, 8, hanging=True)
    # reception
    for x in range(m - 3, m + 4):
        b.set(x, G, z2 - 5, stairs('birch_stairs', 'south', top=True))
    flight(b, x2 - 2, G, z2 - 2, 'north', 5)
    b.fill(x2 - 2, G + 5, z2 - 7, x2 - 2, G + 5, z2 - 3, AIR)
    flight(b, x2 - 2, G + 6, z2 - 2, 'north', 4)
    b.fill(x2 - 2, G + 10, z2 - 6, x2 - 2, G + 10, z2 - 3, AIR)
    return b


# ---------------------------------------------------------------- a market stall
def stall(color='red'):
    b = Build(7, 7, 6)
    for x in (0, 6):
        for z in (1, 4):
            b.fill(x, G, z, x, G + 3, z, st('spruce_fence', waterlogged=False))
    for x in range(0, 7):
        for z in range(0, 6):
            b.set(x, G + 4, z, st('%s_wool' % (color if x % 2 == 0 else 'white')))
    for x in range(1, 6):
        b.set(x, G, 4, st('spruce_planks'))
        b.set(x, G + 1, 4, slab('spruce_slab'))
    b.set(1, G, 1, st('barrel', facing='up', open=False)); b.set(2, G, 1, st('barrel', facing='up', open=False))
    b.set(4, G, 1, 'hay_block[axis=y]'); b.set(5, G, 1, st('composter', level=0))
    b.lantern(3, G + 3, 2, hanging=True)
    return b


# ---------------------------------------------------------------- Training Ground 3 (the bell test)
def training_ground():
    b = Build(25, 14, 25)
    # three posts in a row
    for x in (8, 12, 16):
        b.fill(x, G - 1, 10, x, G + 1, 10, log('stripped_oak_log'))
        b.set(x, G + 2, 10, slab('oak_slab'))
    # the memorial stone: a dark polished slab, wider than deep
    for x in range(10, 15):
        for y in range(G, G + 3 + (1 if 11 <= x <= 13 else 0)):
            b.set(x, y, 16, 'polished_blackstone')
    b.set(12, G + 4, 16, slab('polished_blackstone_slab'))
    for x in range(10, 15):
        b.set(x, G - 1, 17, 'gravel'); b.set(x, G - 1, 15, 'gravel')
    # trees round the clearing
    for (x, z) in ((2, 3), (21, 4), (3, 20), (21, 20), (12, 2), (1, 12)):
        tree(b, x, G, z, height=6, r=3)
    # a stream on the east side
    for z in range(0, 25):
        xw = 22 + (1 if 6 < z < 15 else 0)
        b.set(xw, G - 1, z, 'water'); b.set(xw + 1, G - 1, z, 'water')
        b.set(xw - 1, G - 1, z, 'sand')
    # a log to sit on
    for x in range(4, 8):
        b.set(x, G, 21, log('oak_log', 'x'))
    return b


PIECES = {
    'gate': gate, 'wall': wall, 'hokage_tower': hokage_tower, 'academy': academy, 'academy_yard': academy_yard,
    'house_a': house_a, 'house_b': house_b, 'house_round': house_round, 'ramen_shop': ramen_shop,
    'hospital': hospital, 'stall_red': lambda: stall('red'), 'stall_blue': lambda: stall('blue'),
    'training_ground': training_ground,
}
