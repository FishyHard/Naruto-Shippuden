"""The Hidden Leaf's landmarks: the Hokage tower, the great gate, the Hokage Rock and the water towers.

Faces south (+z); y 0..1 is foundation, the ground floor is y = 2 (leaf.G)."""
import math
from build import Build, Mix, st, stairs, slab, log, AIR, OPP, skirt, inward, angle_of, _hash
from leaf import G, FIRE, flight, chair, table, bed, lamp_post, tree, BEAM, FLOOR, DARK_ROOF

RED_WALL = Mix(('red_terracotta', 8), ('red_concrete', 2), ('pink_terracotta', 1), salt=1)
WHITE = 'smooth_quartz'
RED = 'red_concrete'
SALMON = Mix(('terracotta', 10), ('granite', 2), ('smooth_red_sandstone', 1), salt=2)
STONE_LIGHT = Mix(('smooth_sandstone', 5), ('cut_sandstone', 1), ('calcite', 1), salt=3)
COPPER = 'waxed_oxidized_copper'
COPPER_FRAME = 'waxed_oxidized_cut_copper'

FIRE_SMALL = [  # 火, 11x11
    '.....#.....',
    '..#..#..#..',
    '..#..#..#..',
    '.#...#...#.',
    '.....#.....',
    '.....#.....',
    '....#.#....',
    '...#...#...',
    '..#.....#..',
    '.#.......#.',
    '#.........#',
]
FIRE_9 = [  # 火, 9x9
    '....#....',
    '.#..#..#.',
    '.#..#..#.',
    '..#.#.#..',
    '....#....',
    '...#.#...',
    '..#...#..',
    '.#.....#.',
    '#.......#',
]
SHINOBI = [  # 忍, 7x8: 刃 over 心
    '######.',
    '..#..#.',
    '.#.#.#.',
    '#...##.',
    '.......',
    '..#..#.',
    '#.#...#',
    '..####.',
]
SHINOBI_6 = [  # 忍, 6x9, for the gate's sign
    '######',
    '..#..#',
    '#.#..#',
    '.#...#',
    '#...##',
    '......',
    '...#..',
    '#.#..#',
    '..###.',
]
LEAF = [  # the Leaf's swirl, 7x8
    '..###..',
    '.#...#.',
    '#..#..#',
    '#.#.#.#',
    '#..##.#',
    '.#...#.',
    '..###..',
    '.....##',
]
A_BIG = [  # あ, 9x13
    '....#....',
    '.#######.',
    '....#....',
    '....#....',
    '..######.',
    '.#..#...#',
    '#...#...#',
    '#..#....#',
    '#..#....#',
    '#.#....#.',
    '.#....#..',
    '.....#...',
    '.........',
]
N_BIG = [  # ん, 9x13
    '....#....',
    '....#....',
    '...#.....',
    '...#.....',
    '..#......',
    '..#......',
    '..###....',
    '.#...#...',
    '.#...#...',
    '.#...#...',
    '#....#..#',
    '#....#.#.',
    '#.....#..',
]


def stripes(main, line, every=4, edge=None):
    """Stair names for a skirt roof: radial stripes of `line` among `main`, the outer ring `edge`."""
    def at(x, z, k, _c=[None]):
        return main
    return at


# ---------------------------------------------------------------- the Hokage tower
VERMILION = Mix(('red_concrete', 7), ('red_terracotta', 2), ('pink_terracotta', 1), salt=1)
ORANGE_TILE = 'acacia_stairs'
TRIM = 'black_terracotta'


def hokage_tower():
    """The Hokage's residence as in the anime: three stacked red drums with rows of small windows, each ringed by a
    golden tiled skirt; the top drum carries the round 火 emblem and a flat roof with a railing and white horns. Two smaller
    drums stand either side with trees on their roofs; cables hang across the walls. A low white wall with orange coping
    rings the grounds, with a gatehouse under a curved orange roof at the front.
    Inside: the mission desk (ground), a meeting floor, the Hokage's office (top)."""
    R_WALL = 28
    W = 2 * R_WALL + 5
    b = Build(W, 62, W + 2)
    c = cz = W // 2
    for y in range(0, G):
        b.disc(c, y, cz, R_WALL, 'stone_bricks')
    b.disc(c, G - 1, cz, R_WALL - 1, Mix(('smooth_sandstone', 5), ('sandstone', 2), ('dirt_path', 1), salt=7))

    def tiles(cx, cz_):
        def at(x, z, k):
            if k == 0:
                return 'waxed_cut_copper_stairs'
            seg = int(angle_of(cx, cz_, x, z) / (2 * math.pi) * 72)
            return 'bamboo_mosaic_stairs' if seg % 6 == 0 else 'acacia_stairs'
        return at

    def windows(cx, cz_, y, r, every, skip_front=4):
        for (x, z) in b.ring_points(cx, cz_, r):
            k = int(angle_of(cx, cz_, x, z) / (2 * math.pi) * r * 2 * math.pi)
            if k % every == 0 and not (z > cz_ + r - 3 and abs(x - cx) <= skip_front):
                b.set(x, y, z, 'black_stained_glass_pane')

    def drum(cx, cz_, r, y1, y2):
        for y in range(y1, y2 + 1):
            b.ring(cx, y, cz_, r, VERMILION)
            if y > y1:
                b.disc(cx, y, cz_, r - 1, AIR)

    def cable(cx, cz_, r, y, a1, a2, sag=2.0):
        """A cable hanging across a drum's wall between two angles."""
        n = max(2, int(abs(a2 - a1) * r))
        for i in range(n + 1):
            t = i / n
            a = a1 + (a2 - a1) * t
            yy = y - sag * 4 * t * (1 - t)
            x, z = cx + round((r + 0.6) * math.cos(a)), cz_ + round((r + 0.6) * math.sin(a))
            if b.get(x, round(yy), z) in (None, AIR):
                b.set(x, round(yy), z, st('iron_chain', axis='y', waterlogged=False) if False else 'tripwire[attached=false,disarmed=false,east=false,north=false,powered=false,south=false,west=false]')

    # ---- the side drums, with trees on their roofs
    for sx in (c - 17, c + 17):
        drum(sx, cz - 2, 8, G, G + 13)
        b.disc(sx, G - 1, cz - 2, 7, FLOOR)
        windows(sx, cz - 2, G + 2, 8, 3, 0)
        skirt(b, sx, G + 7, cz - 2, 11, 3, tiles(sx, cz - 2), eave='dark_oak_stairs')
        windows(sx, cz - 2, G + 11, 8, 3, 0)
        b.disc(sx, G + 13, cz - 2, 7, 'moss_block')
        b.ring(sx, G + 14, cz - 2, 8, slab('smooth_quartz_slab'))
        for (tx, tz) in ((sx - 3, cz - 4), (sx + 3, cz), (sx, cz + 2)):
            b.set(tx, G + 14, tz, log('oak_log'))
            for dx in range(-2, 3):
                for dz in range(-2, 3):
                    for dy in range(0, 3):
                        if dx * dx + dz * dz + dy * dy <= 6:
                            b.set(tx + dx, G + 15 + dy, tz + dz, LEAVES_DARK)
    # ---- the main stack
    drum(c, cz, 17, G, G + 9)
    b.disc(c, G - 1, cz, 16, 'polished_andesite')
    windows(c, cz, G + 3, 17, 4, 6)
    windows(c, cz, G + 6, 17, 4, 6)
    b.ring(c, G + 9, cz, 17, TRIM)
    skirt(b, c, G + 10, cz, 21, 5, tiles(c, cz), eave='dark_oak_stairs')
    b.disc(c, G + 10, cz, 16, FLOOR)
    drum(c, cz, 14, G + 10, G + 23)
    for y in (G + 15, G + 18, G + 21):
        windows(c, cz, y, 14, 3)
    b.ring(c, G + 23, cz, 14, TRIM)
    skirt(b, c, G + 24, cz, 17, 4, tiles(c, cz), eave='dark_oak_stairs')
    b.disc(c, G + 24, cz, 13, FLOOR)
    drum(c, cz, 11, G + 24, G + 37)
    windows(c, cz, G + 35, 11, 3, 7)
    # the roof: flat, a white rim and railing, four horns
    top = G + 38
    b.disc(c, top, cz, 11, 'smooth_stone')
    b.ring(c, top, cz, 11, 'smooth_quartz')
    b.ring(c, top + 1, cz, 11, 'iron_bars[east=false,north=false,south=false,west=false,waterlogged=false]')
    b.set(c, top + 1, cz, st('lightning_rod', facing='up', powered=False, waterlogged=False))
    # the horns: slim white curves leaning out from the rim, one block thick
    for ang in (0.75, 2.4, 3.9, 5.5):
        for h in range(0, 6):
            rad = 10.0 + 0.12 * h * h
            for tw in ((-1, 0, 1) if h < 2 else (0,)):
                x = c + round(rad * math.cos(ang + tw * 0.09))
                z = cz + round(rad * math.sin(ang + tw * 0.09))
                b.set(x, top + 1 + h, z, 'smooth_quartz' if h < 5 else 'quartz_slab[type=bottom,waterlogged=false]')
    # the emblem on the top drum's front: a grey frame, a red disc, a dark 火
    pz = cz + 12
    pc = G + 31
    for dx in range(-6, 7):
        for dy in range(-6, 7):
            d = dx * dx + dy * dy
            if d <= 22:
                b.set(c + dx, pc + dy, pz, 'orange_concrete' if False else 'red_concrete')
            elif d <= 34:
                b.set(c + dx, pc + dy, pz, 'light_gray_concrete')
    b.glyph(FIRE_9, c - 4, pc - 4, pz, 'black_terracotta')
    for y in range(pc - 4, pc + 5):
        b.set(c - 7, y, pz, 'light_gray_concrete'); b.set(c + 7, y, pz, 'light_gray_concrete')
    # cables across the walls
    for (r, y) in ((17.2, G + 8), (14.2, G + 22), (11.2, G + 36)):
        for k in range(6):
            a1 = k * math.pi / 3 + 0.3
            cable(c, cz, r, y, a1, a1 + math.pi / 3 * 0.9, sag=2.5)
    # ---- the door in the main drum, under a little curved roof
    dz = cz + 17
    b.fill(c - 2, G, dz - 1, c + 2, G + 4, dz, AIR)
    b.fill(c - 3, G, dz + 1, c - 3, G + 4, dz + 1, 'smooth_quartz')
    b.fill(c + 3, G, dz + 1, c + 3, G + 4, dz + 1, 'smooth_quartz')
    b.fill(c - 2, G, dz, c + 2, G + 3, dz, 'spruce_planks')
    b.door(c - 1, G, dz, 'spruce', 'south', 'left'); b.door(c + 1, G, dz, 'spruce', 'south', 'right')
    b.set(c, G, dz, AIR); b.set(c, G + 1, dz, AIR)
    for x in range(c - 4, c + 5):
        b.set(x, G + 5, dz + 1, stairs('acacia_stairs', 'north'))
        b.set(x, G + 5, dz + 2, stairs('acacia_stairs', 'north')) if abs(x - c) >= 4 else None
    b.set(c - 5, G + 4, dz + 2, stairs('acacia_stairs', 'east', top=True)); b.set(c + 5, G + 4, dz + 2, stairs('acacia_stairs', 'west', top=True))
    # ---- the low wall round the grounds, and the gatehouse
    for (x, z) in b.ring_points(c, cz, R_WALL):
        if z > cz + R_WALL - 4 and abs(x - c) <= 4:
            continue
        b.fill(x, G, z, x, G + 2, z, Mix(('white_concrete', 5), ('calcite', 2), salt=71))
        b.set(x, G + 3, z, slab('acacia_slab'))
    for (x, z) in b.ring_points(c, cz, R_WALL - 1):
        if not (z > cz + R_WALL - 5 and abs(x - c) <= 4) and (x + z) % 7 == 0:
            b.set(x, G + 1, z, AIR) if False else None
    gz = cz + R_WALL
    for x in (c - 5, c + 5):
        b.fill(x, G - 1, gz - 1, x, G + 4, gz - 1, 'smooth_quartz')
        b.fill(x, G - 1, gz + 1, x, G + 4, gz + 1, 'smooth_quartz')
    b.fill(c - 6, G + 5, gz - 2, c + 6, G + 5, gz + 2, 'spruce_planks')
    b.hip(c - 6, gz - 2, c + 6, gz + 2, G + 6, 'acacia_stairs', 'acacia_planks', over=1, eave='acacia_stairs', layers=2)
    for x in (c - 7, c + 7):
        b.set(x, G + 6, gz - 3, stairs('acacia_stairs', 'south'))
        b.set(x, G + 6, gz + 3, stairs('acacia_stairs', 'north'))
    b.set(c - 8, G + 6, gz, stairs('acacia_stairs', 'east', top=True)); b.set(c + 8, G + 6, gz, stairs('acacia_stairs', 'west', top=True))
    for x in (c - 3, c + 3):
        b.set(x, G + 4, gz + 2, st('lantern', hanging=True, waterlogged=False))
    for z in range(cz + 18, gz + 3):
        for x in range(c - 2, c + 3):
            b.set(x, G - 1, z, 'polished_andesite')
    # pipes and tanks in the yard
    for (tx, tz) in ((c - 22, cz + 10), (c + 22, cz + 10)):
        water_tank_small(b, tx, G, tz)

    interior(b, c, cz)
    return b


def spiral(b, cx, cz, y1, y2, floors):
    """A spiral staircase round a stone column from y1 up to y2; each floor in `floors` gets a hole round it, railed but for
    the side the stairs arrive on."""
    ring = [(1, 0), (1, 1), (0, 1), (-1, 1), (-1, 0), (-1, -1), (0, -1), (1, -1)]
    facing = ['south', 'south', 'west', 'west', 'north', 'north', 'east', 'east']
    for y in range(y1, y2 + 1):
        b.set(cx, y, cz, 'polished_andesite' if y % 4 else 'chiseled_stone_bricks')
    for fy in floors:
        for dx in range(-1, 2):
            for dz in range(-1, 2):
                if dx or dz:
                    b.set(cx + dx, fy, cz + dz, AIR)
    for i in range(y2 - y1):
        dx, dz = ring[i % 8]
        y = y1 + i
        b.set(cx + dx, y, cz + dz, stairs('spruce_stairs', facing[i % 8]))
        for h in range(1, 4):
            if b.get(cx + dx, y + h, cz + dz) not in (None,) and (y + h) in floors:
                b.set(cx + dx, y + h, cz + dz, AIR)
    for fy in floors:
        arrive = ring[(fy - y1) % 8]
        for dx in range(-2, 3):
            for dz in range(-2, 3):
                if max(abs(dx), abs(dz)) == 2:
                    near = (max(-1, min(1, dx)), max(-1, min(1, dz)))
                    if near == arrive or (abs(dx) == 2 and abs(dz) == 2):
                        continue
                    if b.get(cx + dx, fy + 1, cz + dz) in (None, AIR):
                        b.set(cx + dx, fy + 1, cz + dz, st('dark_oak_fence', waterlogged=False))


def lining(b, cx, cz, r, y1, y2, wood='stripped_spruce_wood[axis=y]', band='spruce_planks'):
    """Wood panelling on the inside of a drum, leaving the windows clear."""
    for (x, z) in b.ring_points(cx, cz, r):
        for y in range(y1, y2 + 1):
            if b.get(x, y, z) in (None, AIR):
                b.set(x, y, z, wood if (y - y1) % 4 else band)


def interior(b, c, cz):
    G_ = G
    seat = lambda x, y, z, f: chair(b, x, y, z, f)
    lamp = lambda x, y, z: b.set(x, y, z, st('lantern', hanging=True, waterlogged=False))
    chain = lambda x, y, z: b.set(x, y, z, st('iron_chain', axis='y', waterlogged=False))

    # ================= ground floor (G .. G+9): the Mission Assignment Hall
    y0 = G_
    for x in range(c - 16, c + 17):
        for z in range(cz - 16, cz + 17):
            dx, dz = x - c, z - cz
            if dx * dx + dz * dz <= 15.5 ** 2:
                ring_ = int(math.hypot(dx, dz))
                b.set(x, y0 - 1, z, 'polished_andesite' if ring_ % 6 else 'spruce_planks')
    lining(b, c, cz, 16, y0, y0 + 1)
    # pillars holding the floor above, with beams
    for i in range(8):
        a = i * math.pi / 4 + math.pi / 8
        px, pz = c + round(10 * math.cos(a)), cz + round(10 * math.sin(a))
        b.fill(px, y0, pz, px, y0 + 8, pz, 'stripped_dark_oak_log[axis=y]')
        b.set(px, y0 + 9, pz, 'dark_oak_planks')
        for k in range(1, 10):
            bx, bz = c + round((10 - k) * math.cos(a)), cz + round((10 - k) * math.sin(a))
            if k < 10:
                b.set(bx, y0 + 9, bz, 'stripped_dark_oak_log[axis=x]' if abs(math.cos(a)) > abs(math.sin(a)) else 'stripped_dark_oak_log[axis=z]')
    # the long desk at the back where the Hokage and the chunin hand out missions
    dz_ = cz - 6
    for x in range(c - 7, c + 8):
        b.set(x, y0, dz_, stairs('dark_oak_stairs', 'north', top=True))
    b.set(c - 8, y0, dz_, 'dark_oak_planks'); b.set(c + 8, y0, dz_, 'dark_oak_planks')
    for x in range(c - 6, c + 7, 3):
        seat(x, y0, dz_ - 1, 'south')
    for x in (c - 5, c - 1, c + 2, c + 6):
        b.set(x, y0 + 1, dz_, st('white_carpet'))           # papers
    b.set(c - 3, y0 + 1, dz_, 'flower_pot'); b.set(c + 4, y0 + 1, dz_, st('candle', candles=2, lit=False, waterlogged=False))
    b.set(c, y0 + 1, dz_, st('lectern', facing='south', has_book=False, powered=False))
    # behind: the mission-scroll wall and 火 banners
    for x in range(c - 8, c + 9):
        for y in range(y0, y0 + 4):
            z = cz - 14
            while b.get(x, y, z) not in (None, AIR) and z > cz - 16:
                z += 0
                break
            b.set(x, y, cz - 13, st('chiseled_bookshelf', facing='south', slot_0_occupied=(x + y) % 3 == 0,
                                       slot_1_occupied=(x * y) % 2 == 0, slot_2_occupied=True, slot_3_occupied=(x + 2 * y) % 4 == 0,
                                       slot_4_occupied=x % 2 == 0, slot_5_occupied=(y % 2 == 1)))
    for x in (c - 5, c, c + 5):
        b.set(x, y0 + 5, cz - 12, st('red_wall_banner', facing='south'))
    # benches for the teams waiting, on both sides
    for side in (-1, 1):
        for row in range(3):
            z = cz + 2 + row * 3
            for k in range(4):
                b.set(c + side * (5 + k), y0, z, stairs('spruce_stairs', 'south'))
        # potted plants and lamps along the wall
        for z in (cz - 2, cz + 6, cz + 12):
            b.set(c + side * 14, y0, z, 'potted_fern' if z % 2 else 'potted_bamboo')
    # the reception counter by the door (west) and a notice board (east)
    for z in range(cz + 9, cz + 14):
        b.set(c - 11, y0, z, stairs('spruce_stairs', 'east', top=True))
    seat(c - 12, y0, cz + 11, 'east')
    b.set(c - 12, y0 + 1, cz + 9, 'barrel[facing=up,open=false]') if False else None
    for z in range(cz + 7, cz + 12):
        for y in (y0 + 1, y0 + 2):
            b.set(c + 15, y, z, 'spruce_planks')
        b.set(c + 14, y0 + 1, z, st('white_wall_banner', facing='west')) if z % 2 else None
    # lights
    for (x, z) in ((c, cz), (c - 6, cz + 6), (c + 6, cz + 6), (c - 6, cz - 2), (c + 6, cz - 2)):
        chain(x, y0 + 9, z); lamp(x, y0 + 8, z)
    for i in range(12):
        a = i * math.pi / 6
        x, z = c + round(13 * math.cos(a)), cz + round(13 * math.sin(a))
        chain(x, y0 + 9, z); chain(x, y0 + 8, z); lamp(x, y0 + 7, z)
    for x in range(c - 1, c + 2):
        for z in range(cz - 5, cz + 17):
            if b.get(x, y0, z) == AIR:
                b.set(x, y0, z, st('red_carpet'))
    # doorways into the side drums
    for side in (-1, 1):
        b.fill(c + side * 12, y0, cz - 3, c + side * 16, y0 + 3, cz - 1, AIR)
        b.set(c + side * 14, y0 + 4, cz - 2, st('lantern', hanging=True, waterlogged=False))

    # ---- the west drum: the archives
    ax = c - 17
    for (x, z) in b.ring_points(ax, cz - 2, 7):
        if b.get(x, y0, z) == AIR:
            for y in range(y0, y0 + 4):
                b.set(x, y, z, 'bookshelf')
    for (x, z) in b.ring_points(ax, cz - 2, 4):
        b.set(x, y0, z, 'bookshelf'); b.set(x, y0 + 1, z, 'bookshelf')
    b.set(ax, y0, cz - 2, st('lectern', facing='south', has_book=False, powered=False))
    for y in range(y0, y0 + 6):
        b.set(ax - 6, y, cz - 2, st('ladder', facing='east', waterlogged=False)) if b.get(ax - 6, y, cz - 2) == AIR else None
    lamp(ax, y0 + 6, cz - 2)
    # ---- the east drum: the jonin standby room
    jx = c + 17
    for k, (dx, dz) in enumerate(((-2, -3), (2, -3), (-2, 1), (2, 1))):
        table(b, jx + dx, y0, cz - 2 + dz)
        seat(jx + dx - 1, y0, cz - 2 + dz, 'east'); seat(jx + dx + 1, y0, cz - 2 + dz, 'west')
    b.set(jx + 4, y0, cz - 6, 'brewing_stand[has_bottle_0=false,has_bottle_1=false,has_bottle_2=false]')
    b.set(jx + 5, y0, cz - 4, 'barrel[facing=up,open=false]'); b.set(jx + 5, y0, cz - 3, 'smoker[facing=west,lit=false]')
    lamp(jx, y0 + 6, cz - 2)

    # ================= second floor (G+10 .. G+16): the council room
    y1 = G_ + 11
    b.disc(c, y1 - 1, cz, 13, 'dark_oak_planks')
    lining(b, c, cz, 13, y1, y1 + 1)
    b.disc(c, y1 + 6, cz, 13, 'spruce_planks')        # a ceiling: the floor above
    b.ring(c, y1, cz, 5, slab('dark_oak_slab', 'top'))
    b.ring(c, y1, cz, 4, slab('dark_oak_slab', 'top'))
    for (x, z) in b.ring_points(c, cz, 6):
        seat(x, y1, z, OPP[inward(c, cz, x, z)])
    b.set(c, y1, cz, st('cartography_table'))
    b.set(c, y1 + 1, cz, st('white_carpet'))
    for (x, z) in ((c - 3, cz), (c + 3, cz), (c, cz - 3), (c, cz + 3)):
        b.set(x, y1 + 1, z, st('candle', candles=1, lit=False, waterlogged=False))
    for (x, z) in b.ring_points(c, cz, 12):
        if z < cz - 8 and b.get(x, y1 + 3, z) in (None, AIR) and x % 3 == 0:
            b.set(x, y1 + 3, z, st('red_wall_banner', facing=OPP[inward(c, cz, x, z)]))
    chain(c, y1 + 5, cz); lamp(c, y1 + 4, cz)
    for (x, z) in ((c - 9, cz), (c + 9, cz), (c, cz + 9)):
        lamp(x, y1 + 5, z)

    # ================= third floor (G+17 .. G+23): the Hokage's private quarters
    y2 = G_ + 18
    b.disc(c, y2 - 1, cz, 13, 'bamboo_mosaic')            # tatami
    for (x, z) in b.ring_points(c, cz, 8):
        b.set(x, y2 - 1, z, 'stripped_bamboo_block[axis=y]')
    lining(b, c, cz, 13, y2, y2 + 1, wood='bamboo_planks', band='stripped_bamboo_block[axis=y]')
    bed(b, c - 8, y2, cz - 6, 'north', 'red')
    b.set(c - 6, y2, cz - 8, st('chest', facing='south', type='single', waterlogged=False))
    b.set(c - 5, y2, cz - 8, 'bookshelf'); b.set(c - 4, y2, cz - 8, 'bookshelf')
    # a low tea table with cushions
    b.set(c + 4, y2, cz + 2, slab('bamboo_slab'))
    b.set(c + 4, y2 + 1, cz + 2, 'flower_pot')
    for (x, z) in ((c + 3, cz + 2), (c + 5, cz + 2), (c + 4, cz + 1), (c + 4, cz + 3)):
        b.set(x, y2, z, st('red_carpet'))
    b.set(c + 8, y2, cz - 6, 'potted_bamboo'); b.set(c - 9, y2, cz + 5, 'potted_azalea_bush')
    b.set(c + 7, y2, cz + 7, st('decorated_pot', cracked=False, facing='north', waterlogged=False))
    for (x, z) in ((c, cz - 6), (c + 5, cz + 5), (c - 5, cz + 5)):
        lamp(x, y2 + 5, z)

    # ================= fourth floor (G+24 .. G+31): the Hokage's office
    y3 = G_ + 25
    b.disc(c, y3 - 1, cz, 10, 'dark_oak_planks')
    for x in range(c - 3, c + 4):
        for z in range(cz - 6, cz + 9):
            b.set(x, y3 - 1, z, 'red_wool')
    lining(b, c, cz, 10, y3, y3 + 1, wood='dark_oak_planks', band='stripped_dark_oak_wood[axis=y]')
    # the desk, facing the door, the window behind
    for x in range(c - 3, c + 4):
        b.set(x, y3, cz - 5, stairs('dark_oak_stairs', 'south', top=True))
    b.set(c - 4, y3, cz - 5, 'dark_oak_planks'); b.set(c + 4, y3, cz - 5, 'dark_oak_planks')
    seat(c, y3, cz - 6, 'south')
    b.set(c - 2, y3 + 1, cz - 5, st('white_carpet')); b.set(c - 1, y3 + 1, cz - 5, st('white_carpet'))
    b.set(c + 2, y3 + 1, cz - 5, 'potted_bamboo'); b.set(c + 1, y3 + 1, cz - 5, st('candle', candles=3, lit=False, waterlogged=False))
    for x in range(c - 4, c + 5):
        for y in (y3 + 1, y3 + 2, y3 + 3, y3 + 4):
            b.set(x, y, cz - 10, 'glass_pane')
    # bookcases and the old Hokage banners along the walls
    for (x, z) in b.ring_points(c, cz, 9):
        if abs(x - c) >= 6 and z < cz + 3:
            for y in range(y3, y3 + 3):
                if b.get(x, y, z) in (None, AIR):
                    b.set(x, y, z, 'bookshelf')
    for (x, z) in ((c - 7, cz + 4), (c + 7, cz + 4)):
        b.set(x, y3 + 3, z, st('white_wall_banner', facing='east' if x < c else 'west'))
    # guest seats and a low table before the desk
    for x in (c - 2, c + 2):
        seat(x, y3, cz, 'north')
    b.set(c, y3, cz + 2, slab('dark_oak_slab')); b.set(c, y3 + 1, cz + 2, 'flower_pot')
    for (x, z) in ((c, cz - 2), (c - 6, cz + 4), (c + 6, cz + 4)):
        chain(x, y3 + 6, z); lamp(x, y3 + 5, z)
    b.disc(c, y3 + 7, cz, 10, 'spruce_planks')          # the top storey's floor

    # ================= top (G+32 .. G+37): the store room, a ladder to the roof
    y4 = G_ + 33
    for (x, z) in ((c - 6, cz - 5), (c - 5, cz - 6), (c + 6, cz - 5), (c - 7, cz + 2), (c + 7, cz + 3)):
        b.set(x, y4, z, 'barrel[facing=up,open=false]')
        b.set(x, y4 + 1, z, 'barrel[facing=up,open=false]') if (x + z) % 2 else None
    b.set(c + 5, y4, cz + 6, st('chest', facing='west', type='single', waterlogged=False))
    lamp(c, y4 + 3, cz)
    for y in range(y4, G_ + 39):
        b.set(c - 3, y, cz, st('ladder', facing='east', waterlogged=False))
        b.set(c - 4, y, cz, 'spruce_planks') if y < G_ + 38 else None
    b.set(c - 3, G_ + 38, cz, st('spruce_trapdoor', facing='east', half='bottom', open=False, powered=False, waterlogged=False))
    # the staircase through every floor
    spiral(b, c + 5, cz + 4, G_, G_ + 33, (G_ + 10, G_ + 17, G_ + 24, G_ + 32))
    # the quarters and the office are private: the stairs arrive in a small landing, walled off, with a door into the room
    sx, sz = c + 5, cz + 4
    for (fy, ceil) in ((G_ + 17, G_ + 23), (G_ + 24, G_ + 31)):
        for dx in range(-3, 4):
            for dz in range(-3, 4):
                if max(abs(dx), abs(dz)) != 3:
                    continue
                x, z = sx + dx, sz + dz
                if (x - c) ** 2 + (z - cz) ** 2 > 10.4 ** 2:
                    continue
                corner = abs(dx) == 3 and abs(dz) == 3
                for y in range(fy + 1, ceil + 1):
                    if b.get(x, y, z) in (None, AIR) or 'fence' in (b.get(x, y, z) or '') or 'carpet' in (b.get(x, y, z) or ''):
                        b.set(x, y, z, 'stripped_dark_oak_log[axis=y]' if corner else
                              ('stripped_spruce_wood[axis=y]' if y in (fy + 1, ceil) else 'white_terracotta'))
        b.door(sx - 3, fy + 1, sz, 'spruce', facing='west')
        b.set(sx - 4, fy + 1, sz, AIR); b.set(sx - 4, fy + 2, sz, AIR)


LEAVES_DARK = st('dark_oak_leaves', distance=1, persistent=True, waterlogged=False)


def water_tank_small(b, x, y, z):
    for dx, dz in ((-1, -1), (1, -1), (-1, 1), (1, 1)):
        b.fill(x + dx, y, z + dz, x + dx, y + 1, z + dz, st('iron_bars', east=False, north=False, south=False, west=False, waterlogged=False))
    b.disc(x, y + 2, z, 1.5, 'white_concrete')
    b.disc(x, y + 3, z, 1.5, 'white_concrete')
    b.disc(x, y + 4, z, 1.5, slab('smooth_stone_slab'))


def noise(x, y, size, salt):
    """Smooth value noise in 0..1: hashed corners every `size` blocks, blended."""
    gx, gy = x / size, y / size
    x0, y0 = math.floor(gx), math.floor(gy)
    fx, fy = gx - x0, gy - y0
    fx, fy = fx * fx * (3 - 2 * fx), fy * fy * (3 - 2 * fy)
    h = lambda i, j: _hash(i, j, 0, salt)
    top = h(x0, y0) * (1 - fx) + h(x0 + 1, y0) * fx
    bot = h(x0, y0 + 1) * (1 - fx) + h(x0 + 1, y0 + 1) * fx
    return top * (1 - fy) + bot * fy


def plaster(x, y, salt=0):
    """The gate wall's salmon plaster: soft patches of lighter and darker colour, no joints."""
    v = 0.7 * noise(x, y, 7, 81 + salt) + 0.3 * noise(x, y, 3, 82 + salt) + (_hash(x, y, salt, 83) - 0.5) * 0.05
    if v < 0.27:
        return 'granite'
    if v < 0.80:
        return 'terracotta'
    return 'white_terracotta' if v > 0.86 else 'smooth_red_sandstone'


# ---------------------------------------------------------------- the great gate
def gate():
    """The Leaf's main gate: a thick salmon wall, a light stone frame painted 忍 (leaf) 忍, a green tiled roof, the tall
    green doors swung open outward with あ and ん, pipes along the wall, and the guard booth inside."""
    W, D = 63, 26
    b = Build(W, 40, D)
    m = W // 2
    z1, z2 = 8, 11          # the wall's thickness (north = inside, south = outside)
    half = 9                # half the opening (19 wide)
    oh = G + 18             # the opening's top
    top = oh + 15           # the wall's top
    # the wall: plain salmon plaster in soft patches, on a stone footing
    for x in range(W):
        for y in range(0, top + 1):
            for z in range(z1, z2 + 1):
                b.set(x, y, z, plaster(x if z == z2 else -x, y, 0 if z == z2 else 5))
    b.fill(0, 0, z1, W - 1, G - 1, z2, 'stone_bricks')
    # the roof along the wall: green tiles
    for x in range(W):
        b.set(x, top + 1, z1 - 1, stairs('mossy_stone_brick_stairs', 'south'))
        b.set(x, top + 1, z2 + 1, stairs('mossy_stone_brick_stairs', 'north'))
        b.fill(x, top + 1, z1, x, top + 1, z2, 'mossy_stone_bricks')
        b.set(x, top + 2, z1, stairs('mossy_stone_brick_stairs', 'south'))
        b.set(x, top + 2, z2, stairs('mossy_stone_brick_stairs', 'north'))
        b.set(x, top + 2, z1 + 1, slab('mossy_stone_brick_slab', 'double'))
        b.set(x, top + 2, z1 + 2, slab('mossy_stone_brick_slab', 'double'))
        b.set(x, top + 3, z1 + 1, slab('mossy_stone_brick_slab'))
        b.set(x, top + 3, z1 + 2, slab('mossy_stone_brick_slab'))
        b.set(x, top, z1 - 1, stairs('mossy_stone_brick_stairs', 'south', top=True))
        b.set(x, top, z2 + 1, stairs('mossy_stone_brick_stairs', 'north', top=True))
    # the opening
    b.fill(m - half, G, z1 - 1, m + half, oh - 1, z2 + 1, AIR)
    b.fill(m - half, G - 1, 0, m + half, G - 1, D - 1, Mix(('gravel', 2), ('coarse_dirt', 2), ('dirt_path', 3), salt=9))
    # the frame: two light pillars and a sign board across the top, standing out from the outside face
    fz = z2 + 1
    BOARD = 'calcite'
    pw = 4
    for x in list(range(m - half - pw, m - half)) + list(range(m + half + 1, m + half + pw + 1)):
        b.fill(x, G - 1, fz, x, oh - 1, fz, STONE_LIGHT)
    b.fill(m - half - pw, oh, fz, m + half + pw, oh + 12, fz, BOARD)
    for x in range(m - half - pw, m + half + pw + 1):
        b.set(x, oh + 13, fz, slab('smooth_quartz_slab'))
        b.set(x, oh - 1, fz, slab('smooth_quartz_slab', 'top')) if m - half <= x <= m + half else None
    for x in (m - half - pw, m + half + pw):     # the board's end posts, a step proud
        b.fill(x, oh, fz + 1, x, oh + 12, fz + 1, 'smooth_quartz')
    b.set(m - half, oh - 2, fz, stairs('smooth_quartz_stairs', 'east', top=True))
    b.set(m + half, oh - 2, fz, stairs('smooth_quartz_stairs', 'west', top=True))
    # the paint: 忍 (leaf) 忍, small and spaced like the anime's sign
    b.glyph(SHINOBI_6, m - 11, oh + 2, fz, RED)
    b.glyph(LEAF, m - 3, oh + 3, fz, RED)
    b.glyph(SHINOBI_6, m + 6, oh + 2, fz, RED)
    # the doors: swung open outward at 45 degrees, each away from the opening, painted あ and ん on the faces toward the road
    L = 11
    for side, glyph in ((-1, A_BIG), (1, N_BIG)):
        hinge = m + side * half
        for i in range(L):
            x, z = hinge + side * i, fz + 1 + i
            for xx in (x, x - side):           # two blocks per step, so the diagonal reads solid
                edge = i in (0, L - 1)
                for y in range(G, oh):
                    b.set(xx, y, z, COPPER_FRAME if edge or y in (G, oh - 1) else COPPER)
        # the paint: column c of the glyph on step i, on the block nearer the road
        n = len(glyph)
        for r, line in enumerate(glyph):
            for c, ch in enumerate(line):
                if ch != '#':
                    continue
                i = (1 + c) if side == 1 else (L - 2 - c)
                x, z = hinge + side * i - side, fz + 1 + i
                b.set(x, G + 1 + (n - 1 - r), z, RED)
    # pipes along the wall, east of the gate: two rising, one running along under the roof
    for px in (m + half + 9, m + half + 14):
        for y in range(G, top - 1):
            for dx, dz in ((0, 0), (1, 0), (-1, 0), (0, 1)):
                b.set(px + dx, y, z2 + 2 + dz, 'light_gray_concrete' if y % 7 else 'polished_andesite')
    for x in range(m + half + 8, W):
        for dy, dz in ((0, 0), (1, 0), (-1, 0), (0, 1)):
            b.set(x, top - 2 + dy, z2 + 2 + dz, 'light_gray_concrete' if x % 9 else 'polished_andesite')
    # a small stone figure by the west door, and trees either side
    b.set(m - half - 13, G, fz + 3, 'stone_bricks'); b.set(m - half - 13, G + 1, fz + 3, 'polished_andesite')
    b.set(m - half - 13, G + 2, fz + 3, 'stone_button[face=floor,facing=south,powered=false]')
    tree(b, 5, G, 19, height=8, r=4)
    tree(b, W - 6, G, 21, height=7, r=4)
    # inside: the guard booth to the east, lamps
    bx, bz = m + 3, 1
    b.fill(bx, G, bz, bx + 9, G, bz + 3, 'spruce_planks')
    for x in range(bx, bx + 10):
        b.set(x, G + 1, bz + 3, slab('spruce_slab', 'top'))
    for x in (bx, bx + 9):
        for y in range(G + 1, G + 5):
            b.set(x, y, bz, log(BEAM)); b.set(x, y, bz + 3, log(BEAM))
    for x in range(bx - 1, bx + 11):
        b.set(x, G + 5, bz + 4, stairs(DARK_ROOF, 'south'))
        b.fill(x, G + 5, bz, x, G + 5, bz + 3, 'dark_oak_planks')
        b.set(x, G + 5, bz - 1, stairs(DARK_ROOF, 'north'))
    chair(b, bx + 3, G + 1, bz + 2, 'south'); chair(b, bx + 6, G + 1, bz + 2, 'south')
    b.lantern(bx + 5, G + 4, bz + 2, hanging=True)
    lamp_post(b, m - half - 2, G, z1 - 2)
    lamp_post(b, m + half + 2, G, z1 - 2)
    return b


# ---------------------------------------------------------------- the Hokage Rock
def _cell(x, z, size, salt):
    return _hash(x // size, 0, z // size, salt)


class Head:
    """One Hokage's head, sculpted in the round: an ellipsoid face with brow, eye hollows, nose and mouth, and the hair
    (or headgear) that tells them apart. Coordinates are relative to the head's centre; +z is the face's front."""

    def __init__(self, kind, rx=10.0, ry=13.0, rz=10.0):
        self.kind, self.rx, self.ry, self.rz = kind, rx, ry, rz

    @staticmethod
    def ell(dx, dy, dz, cx, cy, cz, ax, ay, az):
        return ((dx - cx) / ax) ** 2 + ((dy - cy) / ay) ** 2 + ((dz - cz) / az) ** 2 <= 1

    def face(self, dx, dy, dz):
        k = 1 - 0.28 * max(0.0, -dy) / self.ry          # narrower toward the chin
        return self.ell(dx, dy, dz, 0, 0, 0, self.rx * k, self.ry, self.rz * (0.85 + 0.15 * k))

    def at(self, dx, dy, dz):
        """'face', 'hair', 'band', 'deep' (a hollow left open) or None."""
        rz = self.rz
        # hollows first: eyes and mouth
        for ex in (-4.0, 4.0):
            if self.ell(dx, dy, dz, ex, 2.0, rz - 0.4, 2.9, 1.8, 3.0):
                return None
        if self.ell(dx, dy, dz, 0, -6.2, rz - 1.0, 3.8, 0.9, 2.4):
            return None
        part = None
        if self.face(dx, dy, dz):
            part = 'face'
        # brow, nose, chin
        if self.ell(dx, dy, dz, 0, 3.9, rz - 1.5, 8.0, 1.0, 2.0):
            part = 'face'
        if self.ell(dx, dy, dz, 0, -1.3, rz - 0.2, 1.4, 3.6, 2.0):
            part = 'face'
        if self.ell(dx, dy, dz, 0, -10.0, rz - 3.5, 3.5, 2.5, 3.0):
            part = 'face'
        hair = self.hair(dx, dy, dz)
        if hair and (part is None or hair == 'band' or dy > 5.5 or dz < rz * 0.35):
            part = hair
        return part

    def hair(self, dx, dy, dz):
        kind, rx, ry, rz = self.kind, self.rx, self.ry, self.rz
        if kind == 'first':
            # long straight hair, parted in the middle, down past the jaw either side
            if self.ell(dx, dy, dz, 0, 2.0, -1.5, rx + 2.0, ry + 1.8, rz + 0.5):
                if abs(dx) < 0.6 and dy > 7 and dz > 0:
                    return None
                if dy > 6 or abs(dx) > rx - 2.0 or dz < 1:
                    return 'hair'
            if rx - 2.5 <= abs(dx) <= rx + 2.5 and -15 <= dy <= 2 and -7 <= dz <= 5:
                return 'hair'
        elif kind == 'second':
            # short, swept-back hair over a forehead protector
            if dy > 5 and self.ell(dx, dy, dz, 0, 1.5, -1.0, rx + 1.0, ry + 1.2, rz + 0.4):
                if 5 < dy <= 8 and dz > -2:
                    return 'band'
                return 'hair'
        elif kind == 'third':
            # spiky hair standing up, a forehead protector, a goatee
            if 5 < dy <= 8 and self.ell(dx, dy, dz, 0, 0, 0, rx + 0.9, ry + 0.9, rz + 0.9) and dz > -3:
                return 'band'
            if dy > 7:
                ang = math.atan2(dx, dy)
                lim = ry + 1.5 + 3.5 * abs(math.sin(ang * 5.0))
                if dx * dx / (rx + 1) ** 2 + dy * dy / lim ** 2 + (dz + 1) ** 2 / (rz + 0.5) ** 2 <= 1:
                    return 'hair'
            if self.ell(dx, dy, dz, 0, -13.0, rz - 3.0, 2.2, 3.0, 2.2):
                return 'hair'
        elif kind == 'fourth':
            # big spiky hair and a long fringe falling over the forehead and down the sides
            if dy > 3:
                ang = math.atan2(dx, dy + 2)
                lim = ry + 3 + 5 * abs(math.sin(ang * 4.0 + 0.4))
                if dx * dx / (rx + 2.5) ** 2 + (dy - 1) ** 2 / lim ** 2 + (dz + 1.5) ** 2 / (rz + 1) ** 2 <= 1:
                    if dz > rz - 3.5 and dy < 7:
                        # the fringe: strands of different lengths
                        if dy > 7 - (2 + 4 * abs(math.sin(dx * 0.9))):
                            return 'hair'
                        return None
                    return 'hair'
            if rx - 1.5 <= abs(dx) <= rx + 2 and -6 <= dy <= 4 and -3 <= dz <= rz - 2:
                return 'hair'
        return None


def hokage_rock(faces=('first', 'second', 'third', 'fourth')):
    """The Hokage Rock: a cliff with the Hokage heads carved in it, staggered as in the anime, above a craggy talus and
    with trees along the top. The heads and the cliff around them follow data/hokage_rock_faces.json (rock_map.py): each
    head bulges out as a 3D shape and its features are carved in by the picture's shading. `faces` picks which heads are
    carved (the fifth, Tsunade's, is added later in the story); where a head is left out the cliff is plain rock.
    The cliff looks south; its foot sits on the ground."""
    import json, os
    data = json.load(open(os.path.join(os.path.dirname(os.path.abspath(__file__)), 'data', 'hokage_rock_faces.json')))
    mw, mh, stones = data['w'], data['h'], data['stones']
    MARGIN, Y0, ZC = 16, 16, 30
    W, H, D = mw + 2 * MARGIN, Y0 + mh + 14, 82
    b = Build(W, H, D)
    plain = Mix(('sandstone', 4), ('smooth_sandstone', 3), ('cut_sandstone', 2), ('terracotta', 1), salt=72)

    def cell(mx, my):
        return data['cells'][my][mx]

    # the cliff top for every column: from the picture over the map, falling away beyond it
    tops = []
    for x in range(W):
        mx = x - MARGIN
        if 0 <= mx < mw:
            t = Y0 + (mh - 1 - data['top'][mx])
        else:
            edge = min(x, W - 1 - x)
            t = Y0 + mh - 1 - (MARGIN - edge) * 2.5
        tops.append(int(t + 2 * math.sin(x * 0.3)))

    def front_at(x, y):
        """How far south the rock comes at (x, y), and the stone of its face."""
        base = ZC + (Y0 + mh - y) * 0.06 + 0.8 * math.sin(x * 0.4 + y * 0.1)
        mx, my = x - MARGIN, Y0 + mh - 1 - y
        if 0 <= mx < mw and 0 <= my < mh:
            stone_i, detail, heads = cell(mx, my)
            out = max([v for k, v in heads.items() if k in faces] or [0.0])
            carved = out > 0 or any(k in faces for k in heads)
            if any(k not in faces for k in heads) and out == 0:
                # a head not carved yet: plain cliff
                return base, plain
            return base + out + detail * (0.55 if carved else 0.6), stones[stone_i]
        return base, plain

    # the face's depth everywhere, smoothed a little so the carving reads as sculpted planes, not pixel noise
    raw = [[front_at(x, y) for y in range(H)] for x in range(W)]
    def smooth(x, y):
        tot = wt = 0.0
        for dx in (-1, 0, 1):
            for dy in (-1, 0, 1):
                if 0 <= x + dx < W and 0 <= y + dy < H:
                    k = 4 if dx == dy == 0 else 2 if dx == 0 or dy == 0 else 1
                    tot += raw[x + dx][y + dy][0] * k
                    wt += k
        return tot / wt
    # under a chin the rock steps back at most 2 blocks a row, like a neck, instead of leaving the head hanging in the air
    fronts = {}
    for x in range(W):
        above = None
        for y in range(H - 1, -1, -1):
            if y > tops[x]:
                continue
            f = smooth(x, y)
            if above is not None:
                f = max(f, above - 2.0)
            fronts[x, y] = above = f
    for x in range(W):
        for y in range(H):
            if y > tops[x]:
                continue
            f, stone = fronts[x, y], raw[x][y][1]
            front = min(D - 1, int(round(f)))
            # the face block and the few behind it (the sides of the heads show them)
            for z in range(0, front + 1):
                b.set(x, y, z, stone if z >= front - 3 else 'sandstone')
        # the plateau on top: grass, then trees
        t = tops[x]
        for z in range(0, int(ZC) - 2):
            b.set(x, t, z, 'grass_block[snowy=false]')
    # the talus at the cliff's foot: crags of rock, falling toward the village
    for x in range(W):
        for z in range(ZC, D):
            h = Y0 + 2 - (z - ZC) * 0.42
            edge = min(x, W - 1 - x)
            h = min(h, 2 + edge * 0.9)
            c3 = _cell(x, z, 3, 51)
            h += (c3 - 0.5) * 6 + (_cell(x + 1, z + 2, 5, 52) - 0.5) * 4
            if c3 > 0.94:
                h += 6
            for y in range(max(0, int(h) - 4), int(h) + 1):
                if (x, y, z) not in b.blocks:
                    v = _hash(x, y // 3, z, 62)
                    b.set(x, y, z, 'terracotta' if v < 0.1 else plain)
            if h > 2 and _hash(x, 0, z, 63) < 0.15:
                b.set(x, int(h) + 1, z, 'short_grass') if (x, int(h) + 1, z) not in b.blocks else None
    for x in range(W):
        for z in range(ZC, D):
            for y in range(0, 2):
                b.set(x, y, z, b.get(x, y, z) or plain)
    # trees along the top
    for tx in range(6, W - 6, 8):
        tz = 6 + (tx * 7) % 14
        ty = tops[tx] + 1
        if ty + 9 < H:
            tree(b, tx, ty, tz, height=5 + tx % 3, r=3)
    return b


def hokage_rock_five():
    """The Hokage Rock once Tsunade is the Fifth Hokage."""
    return hokage_rock(('first', 'second', 'third', 'fourth', 'fifth'))


# ---------------------------------------------------------------- a water tower with 忍
def water_tower():
    b = Build(11, 26, 11)
    c = 5
    for y in range(0, G):
        b.disc(c, y, c, 4, 'stone_bricks')
    b.cylinder(c, G, c, 4, G + 17, Mix(('white_concrete', 6), ('light_gray_concrete', 1), salt=21), inner=AIR)
    for y in (G + 5, G + 11, G + 17):
        b.ring(c, y, c, 4, 'light_gray_concrete')
    b.disc(c, G + 18, c, 4, slab('smooth_stone_slab'))
    b.cone(c, G + 19, c, 4, 'light_blue_terracotta' if False else 'dark_prismarine_stairs', 'dark_prismarine')
    b.glyph(['#####', '...#.', '.#.#.', '..#..', '.#...', '#.#.#', '#..##'], c - 2, G + 8, c + 4, 'purple_concrete')
    b.door(c, G, c + 4, 'iron', 'south')
    return b
