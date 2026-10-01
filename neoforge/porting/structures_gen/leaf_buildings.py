"""The Hidden Leaf's everyday buildings, in the landmarks' detail: the Ninja Academy and its yard, Ichiraku Ramen and the
hospital. Each is furnished inside, since the story's chapters 1 to 3 play out in them.

Faces south (+z); y 0..1 is foundation, the ground floor is y = 2 (leaf.G)."""
import math
from build import Build, Mix, st, stairs, slab, log, AIR, OPP, _hash
from leaf import G, chair, table, bed, tree, lamp_post, water_tank
from leaf_landmarks import plaster, SHINOBI_6

GREEN = 'waxed_oxidized_cut_copper'
GREEN_ST = 'waxed_oxidized_cut_copper_stairs'
GREEN_SLAB = 'waxed_oxidized_cut_copper_slab'
TRIM = 'calcite'
RED = 'red_concrete'
OUT = {'south': (0, 1), 'north': (0, -1), 'east': (1, 0), 'west': (-1, 0)}
FENCE = st('spruce_fence', waterlogged=False)
LEAVES = st('oak_leaves', distance=1, persistent=True, waterlogged=False)
AZALEA = st('azalea_leaves', distance=1, persistent=True, waterlogged=False)


def lamp(b, x, y, z):
    b.set(x, y, z, st('lantern', hanging=True, waterlogged=False))


def chain(b, x, y, z):
    b.set(x, y, z, st('iron_chain', axis='y', waterlogged=False))


def plaster_shell(b, x1, y1, z1, x2, y2, z2, salt=0, inner=AIR):
    """A box whose walls are the village's salmon plaster, the inside cleared."""
    for y in range(y1, y2 + 1):
        for x in range(x1, x2 + 1):
            for z in range(z1, z2 + 1):
                edge = x in (x1, x2) or z in (z1, z2)
                if edge:
                    u = x + z if z in (z1, z2) else z - x
                    b.set(x, y, z, plaster(u, y, salt))
                elif inner is not None:
                    b.set(x, y, z, inner)


def window(b, x, y, z, side, w=2, h=3, pane='glass_pane'):
    """A window `w` wide and `h` high in the wall at (x, z) (x along a south/north wall, z along an east/west one), with a
    white sill outside and a white lintel."""
    ox, oz = OUT[side]
    along = (1, 0) if side in ('south', 'north') else (0, 1)
    for i in range(w):
        px, pz = x + along[0] * i, z + along[1] * i
        for dy in range(h):
            b.set(px, y + dy, pz, pane)
        b.set(px, y - 1, pz, TRIM)
        b.set(px, y + h, pz, TRIM)
        b.set(px + ox, y - 1, pz + oz, slab('smooth_quartz_slab', 'top'))


def eave(b, x1, z1, x2, z2, y, stair=GREEN_ST, depth=2, skip=lambda x, z: False):
    """A pent roof round a box at height y: `depth` rows of tiles stepping down and out from the wall."""
    for k in range(depth):
        yy = y - k
        for x in range(x1 - 1 - k, x2 + 2 + k):
            for (z, f) in ((z1 - 1 - k, 'south'), (z2 + 1 + k, 'north')):
                if not skip(x, z):
                    b.set(x, yy, z, stairs(stair, f))
        for z in range(z1 - k, z2 + 1 + k):
            for (x, f) in ((x1 - 1 - k, 'east'), (x2 + 1 + k, 'west')):
                if not skip(x, z):
                    b.set(x, yy, z, stairs(stair, f))


def rows_of_desks(b, x1, x2, z0, y0, rows, facing='north'):
    """A classroom's rising rows: each row a desk (an upturned stair) and a bench behind it, a step higher than the last."""
    back = OPP[facing]
    for r in range(rows):
        z = z0 + r * 2
        if r:
            b.fill(x1, y0, z, x2, y0 + r - 1, z + 1, 'spruce_planks')
        for x in range(x1, x2 + 1):
            b.set(x, y0 + r, z, stairs('spruce_stairs', facing, top=True) if x % 4 else 'spruce_planks')
            b.set(x, y0 + r, z + 1, stairs('spruce_stairs', back))
            if (x + r) % 5 == 0:
                b.set(x, y0 + r + 1, z, st('white_carpet'))


# ---------------------------------------------------------------- the Ninja Academy
def academy():
    """Three storeys of salmon plaster with white trim and green tiled eaves, a front block carrying the round 忍 crest,
    and a flat roof with water tanks. Inside: the teachers' room and the exam room on the ground floor, two classrooms
    of rising rows on the first, the library and a training hall on the second, a corridor along the front of each."""
    W, D = 49, 34
    b = Build(W, 40, D)
    x1, z1, x2, z2 = 4, 4, 44, 20
    m = (x1 + x2) // 2
    F = (G, G + 6, G + 12)          # walking levels; each floor block is one below
    top = G + 17                    # the roof slab
    b.fill(x1 - 1, 0, z1 - 1, x2 + 1, G - 1, z2 + 6, 'stone_bricks')
    plaster_shell(b, x1, G, z1, x2, top, z2, salt=11)
    # the plinth and the white bands at each floor
    for x in range(x1, x2 + 1):
        for z in (z1, z2):
            b.set(x, G, z, 'polished_granite')
            for y in (G + 5, G + 11):
                b.set(x, y, z, TRIM)
    for z in range(z1, z2 + 1):
        for x in (x1, x2):
            b.set(x, G, z, 'polished_granite')
            for y in (G + 5, G + 11):
                b.set(x, y, z, TRIM)
    # floors and the roof
    b.fill(x1 + 1, G - 1, z1 + 1, x2 - 1, G - 1, z2 - 1, 'polished_andesite')
    for y in (G + 5, G + 11):
        b.fill(x1 + 1, y, z1 + 1, x2 - 1, y, z2 - 1, 'oak_planks')
    b.fill(x1, top, z1, x2, top, z2, 'smooth_stone')
    # the roof's edge: a green tiled cornice and a white parapet
    for x in range(x1 - 1, x2 + 2):
        b.set(x, top, z1 - 1, stairs(GREEN_ST, 'south', top=True)); b.set(x, top, z2 + 1, stairs(GREEN_ST, 'north', top=True))
        b.set(x, top + 1, z1 - 1, slab(GREEN_SLAB)); b.set(x, top + 1, z2 + 1, slab(GREEN_SLAB))
    for z in range(z1, z2 + 1):
        b.set(x1 - 1, top, z, stairs(GREEN_ST, 'east', top=True)); b.set(x2 + 1, top, z, stairs(GREEN_ST, 'west', top=True))
        b.set(x1 - 1, top + 1, z, slab(GREEN_SLAB)); b.set(x2 + 1, top + 1, z, slab(GREEN_SLAB))
    for x in range(x1, x2 + 1):
        b.set(x, top + 1, z1, TRIM); b.set(x, top + 1, z2, TRIM)
    for z in range(z1, z2 + 1):
        b.set(x1, top + 1, z, TRIM); b.set(x2, top + 1, z, TRIM)
    # the ground floor's pent roof, all round but for the front block
    fb1, fb2 = m - 6, m + 6         # the front block
    eave(b, x1, z1, x2, z2, G + 5, skip=lambda x, z: fb1 - 1 <= x <= fb2 + 1 and z > z2)
    # windows: pairs every five blocks on every floor, all four sides
    for fy in F:
        y = fy + 1
        for x in range(x1 + 3, x2 - 2, 5):
            if not (fb1 - 1 <= x <= fb2):
                window(b, x, y, z2, 'south')
            window(b, x, y, z1, 'north')
        for z in range(z1 + 3, z2 - 2, 5):
            window(b, x1, y, z, 'west'); window(b, x2, y, z, 'east')

    # ---- the front block: the entrance, and the crest on its face
    fz2 = z2 + 4
    ftop = top + 7
    plaster_shell(b, fb1, G, z2, fb2, ftop, fz2, salt=12, inner=None)
    b.fill(fb1 + 1, G, z2 + 1, fb2 - 1, ftop - 1, fz2 - 1, AIR)
    b.fill(fb1 + 1, G, z2, fb2 - 1, G + 3, z2, AIR)                 # open into the corridor
    b.fill(fb1 + 1, G - 1, z2, fb2 - 1, G - 1, fz2 - 1, 'polished_andesite')
    for y in (G + 5, G + 11, top):
        b.fill(fb1 + 1, y, z2 + 1, fb2 - 1, y, fz2 - 1, 'oak_planks')
        b.fill(fb1 + 1, y, z2, fb2 - 1, y, z2, 'oak_planks')
        b.fill(fb1 + 1, y + 1, z2, fb2 - 1, y + 3, z2, AIR) if y < top else None
    for x in (fb1, fb2):
        b.fill(x, G, fz2, x, ftop, fz2, log('stripped_dark_oak_log'))
        b.fill(x, G, z2 + 1, x, ftop, z2 + 1, log('stripped_dark_oak_log'))
    for x in range(fb1, fb2 + 1):
        for y in (G + 5, G + 11, top):
            b.set(x, y, fz2, TRIM)
    for z in range(z2, fz2 + 1):
        for y in (G + 5, G + 11, top):
            b.set(fb1, y, z, TRIM); b.set(fb2, y, z, TRIM)
    for fy in F[1:]:
        window(b, fb1, fy + 1, z2 + 2, 'west', w=2); window(b, fb2, fy + 1, z2 + 2, 'east', w=2)
    b.hip(fb1, z2, fb2, fz2, ftop + 1, GREEN_ST, GREEN, over=1, eave=GREEN_ST)
    # the doors and their porch roof
    for x in range(m - 1, m + 2):
        b.fill(x, G, fz2, x, G + 3, fz2, AIR)
    b.door(m - 1, G, fz2, 'spruce', 'south', 'left'); b.door(m + 1, G, fz2, 'spruce', 'south', 'right')
    b.set(m, G, fz2, AIR); b.set(m, G + 1, fz2, AIR)
    b.fill(m - 1, G + 2, fz2, m + 1, G + 3, fz2, 'stripped_spruce_wood[axis=x]')
    for x in range(m - 4, m + 5):
        b.set(x, G + 4, fz2 + 1, stairs(GREEN_ST, 'north'))
        b.set(x, G + 4, fz2 + 2, stairs(GREEN_ST, 'north', top=True)) if False else None
        b.set(x, G + 3, fz2 + 2, stairs(GREEN_ST, 'north'))
    for x in (m - 4, m + 4):
        b.fill(x, G, fz2 + 2, x, G + 2, fz2 + 2, log('stripped_dark_oak_log'))
    lamp(b, m - 3, G + 2, fz2 + 1); lamp(b, m + 3, G + 2, fz2 + 1)
    for x in range(m - 3, m + 4):
        for z in range(fz2 + 1, fz2 + 5):
            b.set(x, G - 1, z, 'polished_andesite' if abs(x - m) < 3 else 'stone_bricks')
    # the crest: a white disc ringed in red, 忍 in the middle
    cy, cz_ = G + 16, fz2 + 1
    for dx in range(-7, 8):
        for dy in range(-7, 8):
            d = math.hypot(dx, dy)
            if d <= 6.2:
                b.set(m + dx, cy + dy, cz_, TRIM)
            elif d <= 7.1:
                b.set(m + dx, cy + dy, cz_, RED)
    b.glyph(SHINOBI_6, m - 3, cy - 4, cz_, RED)
    # the vestibule: shoe lockers along both sides, a mat
    for z in range(z2 + 1, fz2):
        for y in (G, G + 1, G + 2):
            for x, f in ((fb1 + 1, 'east'), (fb2 - 1, 'west')):
                b.set(x, y, z, st('chiseled_bookshelf', facing=f, slot_0_occupied=False, slot_1_occupied=(y + z) % 2 == 0,
                                  slot_2_occupied=False, slot_3_occupied=(z % 3 == 0), slot_4_occupied=False, slot_5_occupied=False))
    for x in range(m - 2, m + 3):
        for z in range(z2 + 1, fz2):
            b.set(x, G, z, st('green_carpet') if abs(x - m) < 2 else st('white_carpet'))
    lamp(b, m, G + 4, z2 + 2)

    # ---- inside: a corridor along the front of each floor, the rooms behind it
    cw = z2 - 4                     # the corridor's back wall
    s1, s2 = m - 7, m + 7           # the stair hall between the rooms
    for fy in F:
        b.fill(x1 + 1, fy, cw, x2 - 1, fy + 4, cw, 'white_terracotta')
        for x in range(x1 + 1, x2):
            b.set(x, fy, cw, 'stripped_spruce_wood[axis=x]')
            b.set(x, fy + 4, cw, 'stripped_spruce_wood[axis=x]')
        for x in (s1, s2):
            b.fill(x, fy, z1 + 1, x, fy + 4, cw, 'white_terracotta')
            b.fill(x, fy, z1 + 1, x, fy, cw, 'stripped_spruce_wood[axis=z]')
        b.fill(s1 + 1, fy, cw, s2 - 1, fy + 3, cw, AIR)          # the stair hall opens on the corridor
        # doors into the rooms
        for dx in (x1 + 4, s1 - 3, s2 + 3, x2 - 4):
            b.door(dx, fy, cw, 'spruce', 'south', 'left')
        # corridor: lamps, plants, a bench
        for x in range(x1 + 4, x2 - 2, 6):
            lamp(b, x, fy + 4, z2 - 2)
        for x in (x1 + 1, x2 - 1):
            b.set(x, fy, z2 - 2, 'potted_bamboo')
        for x in range(x1 + 8, x1 + 12):
            b.set(x, fy, cw + 1, stairs('spruce_stairs', 'north'))
        for x in range(x2 - 11, x2 - 7):
            b.set(x, fy, cw + 1, stairs('spruce_stairs', 'north'))
    # the stairs: two flights, west then east, with railings round the holes
    for fy, sx in ((F[0], m - 4), (F[1], m + 3)):
        for i in range(6):
            for dx in (0, 1):
                b.set(sx + dx, fy + i, cw - 1 - i, stairs('spruce_stairs', 'north'))
                for h in range(1, 4):
                    b.set(sx + dx, fy + i + h, cw - 1 - i, AIR)
        for dx in (-1, 2):
            for z in range(cw - 6, cw):
                if b.get(sx + dx, fy + 6, z) in (None, AIR):
                    b.set(sx + dx, fy + 6, z, st('dark_oak_fence', waterlogged=False))
        b.set(sx, fy + 6, cw - 1, st('dark_oak_fence', waterlogged=False)) if False else None
    for fy in F:
        lamp(b, m, fy + 4, z1 + 3)
        b.set(m, fy, z1 + 1, 'potted_fern')

    # ground floor, west: the teachers' room
    y0 = F[0]
    for row in range(2):
        for x in range(x1 + 3, s1 - 2, 3):
            z = z1 + 3 + row * 4
            b.set(x, y0, z, 'spruce_planks'); b.set(x + 1, y0, z, 'spruce_planks')
            b.set(x, y0 + 1, z, st('white_carpet')) if (x + row) % 2 else b.set(x + 1, y0 + 1, z, 'flower_pot')
            chair(b, x, y0, z + 1, 'north')
    b.fill(x1 + 1, y0, z1 + 1, x1 + 1, y0 + 2, cw - 2, 'bookshelf')
    b.set(s1 - 1, y0, z1 + 1, st('brewing_stand', has_bottle_0=False, has_bottle_1=False, has_bottle_2=False))
    b.set(s1 - 2, y0, z1 + 1, st('barrel', facing='up', open=False))
    lamp(b, x1 + 6, y0 + 4, z1 + 6); lamp(b, s1 - 5, y0 + 4, z1 + 6)
    # ground floor, east: the exam room — the examiners' table with the headbands on it, an open floor for the clones
    ex = (s2 + x2) // 2
    for x in range(ex - 4, ex + 5):
        b.set(x, y0, z1 + 3, stairs('dark_oak_stairs', 'south', top=True))
    for x in (ex - 2, ex + 2):
        chair(b, x, y0, z1 + 2, 'south')
    for x in (ex - 3, ex - 1, ex, ex + 1, ex + 3):
        b.set(x, y0 + 1, z1 + 3, st('blue_carpet') if x != ex else st('white_carpet'))
    for x in range(s2 + 2, x2 - 1):
        for z in range(z1 + 6, cw - 1):
            b.set(x, y0 - 1, z, 'oak_planks' if (x + z) % 2 else 'stripped_oak_wood[axis=y]')
    b.set(x2 - 1, y0, z1 + 1, 'potted_bamboo'); b.set(s2 + 1, y0, z1 + 1, 'potted_bamboo')
    lamp(b, ex, y0 + 4, z1 + 4); lamp(b, ex, y0 + 4, z1 + 9)
    # first floor: two classrooms, the blackboard on the north wall, the rows rising toward the corridor
    y1 = F[1]
    for (rx1, rx2) in ((x1 + 1, s1 - 1), (s2 + 1, x2 - 1)):
        b.fill(rx1 + 2, y1 + 1, z1 + 1, rx2 - 2, y1 + 2, z1 + 1, 'black_concrete')
        b.fill(rx1 + 2, y1 + 3, z1 + 1, rx2 - 2, y1 + 3, z1 + 1, 'stripped_spruce_wood[axis=x]')
        b.set(rx1 + 3, y1 + 2, z1 + 2, st('white_wall_banner', facing='south')) if False else None
        mid = (rx1 + rx2) // 2
        b.set(mid, y1, z1 + 3, st('lectern', facing='south', has_book=True, powered=False))
        b.set(mid - 2, y1, z1 + 3, 'spruce_planks'); b.set(mid + 2, y1, z1 + 3, 'spruce_planks')
        b.set(mid + 2, y1 + 1, z1 + 3, 'flower_pot')
        rows_of_desks(b, rx1 + 2, rx2 - 2, z1 + 5, y1, 3)
        lamp(b, mid - 4, y1 + 4, z1 + 4); lamp(b, mid + 4, y1 + 4, z1 + 4); lamp(b, mid, y1 + 4, z1 + 8)
    # chalk on the boards: 忍 and a few lines
    b.glyph(['#.###.#', '.......', '###.###'], x1 + 5, y1 + 1, z1 + 2, 'white_carpet') if False else None
    # second floor, west: the library
    y2 = F[2]
    for z in range(z1 + 2, cw - 1, 3):
        b.fill(x1 + 3, y2, z, s1 - 3, y2 + 2, z, 'bookshelf')
    b.set((x1 + s1) // 2, y2, cw - 1, st('lectern', facing='north', has_book=True, powered=False)) if False else None
    lamp(b, x1 + 6, y2 + 4, z1 + 4); lamp(b, s1 - 5, y2 + 4, z1 + 9)
    # second floor, east: the training hall — a wooden floor, targets on the north wall, straw dummies
    for x in range(s2 + 1, x2):
        for z in range(z1 + 1, cw):
            b.set(x, y2 - 1, z, 'stripped_oak_wood[axis=y]' if (x + z) % 3 else 'oak_planks')
    for x in range(s2 + 3, x2 - 1, 4):
        b.set(x, y2 + 1, z1 + 1, st('target', power=0))
    for x in (s2 + 4, x2 - 4):
        b.set(x, y2, cw - 3, log('stripped_oak_log')); b.set(x, y2 + 1, cw - 3, 'hay_block[axis=y]')
    b.fill(x2 - 1, y2, z1 + 2, x2 - 1, y2, z1 + 6, st('spruce_trapdoor', facing='west', half='bottom', open=True,
                                                       powered=False, waterlogged=False))
    lamp(b, (s2 + x2) // 2, y2 + 4, z1 + 6)

    # ---- the roof: water tanks, a stair house, vents
    rt = top + 1
    water_tank(b, x1 + 5, rt, z1 + 4)
    water_tank(b, x2 - 5, rt, z1 + 4)
    water_tank(b, x2 - 10, rt, z1 + 5)
    for (x, z) in ((x1 + 12, z1 + 3), (x2 - 15, z2 - 3)):
        b.set(x, rt, z, 'smooth_stone'); b.set(x, rt + 1, z, st('iron_trapdoor', facing='north', half='bottom', open=False,
                                                                    powered=False, waterlogged=False))
    # trees and lamps by the door
    for x in (m - 9, m + 9):
        b.set(x, G - 1, z2 + 4, 'grass_block[snowy=false]')
        tree(b, x, G, z2 + 4, height=5, r=2)
    for x in (fb1 - 2, fb2 + 2):
        lamp_post(b, x, G, fz2 + 3)
    return b


# ---------------------------------------------------------------- the Academy yard
def academy_yard():
    """The yard before the Academy: the swing on the big tree, the row of wooden posts, the throwing targets, a sparring
    ring, benches, all inside a low wall with a gap toward the street."""
    W, D = 49, 27
    b = Build(W, 18, D)
    # the ground: packed earth with grass at the edges
    for x in range(W):
        for z in range(D):
            edge = x < 3 or x > W - 4 or z > D - 4
            v = _hash(x, 0, z, 91)
            b.set(x, G - 1, z, 'grass_block[snowy=false]' if edge else
                  ('coarse_dirt' if v < 0.25 else 'dirt_path' if v < 0.75 else 'gravel' if v < 0.85 else 'packed_mud'))
            b.set(x, G - 2, z, 'dirt')
    # the low wall with a fence on it, open in the middle of the south side
    for x in range(W):
        for z in (D - 1,):
            if abs(x - W // 2) > 3:
                b.set(x, G, z, 'stone_bricks'); b.set(x, G + 1, z, FENCE)
    for z in range(D):
        for x in (0, W - 1):
            b.set(x, G, z, 'stone_bricks'); b.set(x, G + 1, z, FENCE)
    for x in (W // 2 - 4, W // 2 + 4):
        b.fill(x, G, D - 1, x, G + 2, D - 1, 'stone_bricks'); b.set(x, G + 3, D - 1, st('lantern', hanging=False, waterlogged=False))
    # the swing tree: a broad oak, a branch out to the east, the seat on two ropes
    tx, tz = 7, 8
    for y in range(G, G + 8):
        b.set(tx, y, tz, log('oak_log'))
        if y < G + 3:
            b.set(tx + 1, y, tz, log('oak_log')); b.set(tx, y, tz + 1, log('oak_log')); b.set(tx + 1, y, tz + 1, log('oak_log'))
    for dx in range(1, 7):
        b.set(tx + dx, G + 6 + (1 if dx > 5 else 0), tz, log('oak_log', 'x'))
    for z in (tz - 1, tz + 1):
        b.set(tx + 5, G + 6, z, log('oak_log', 'z'))
    for dy in range(-2, 3):
        rr = 5 - abs(dy)
        for dx in range(-rr - 1, rr + 2):
            for dz in range(-rr, rr + 1):
                if dx * dx * 0.7 + dz * dz <= rr * rr and (tx + 1 + dx, G + 9 + dy, tz + dz) not in b.blocks:
                    b.set(tx + 1 + dx, G + 9 + dy, tz + dz, LEAVES)
    for y in range(G + 2, G + 6):
        b.set(tx + 5, y, tz, st('iron_chain', axis='y', waterlogged=False)) if False else None
        b.set(tx + 5, y, tz - 1, FENCE if False else st('iron_chain', axis='y', waterlogged=False))
        b.set(tx + 5, y, tz + 1, st('iron_chain', axis='y', waterlogged=False))
    for z in (tz - 1, tz, tz + 1):
        b.set(tx + 5, G + 1, z, slab('oak_slab', 'top'))
    # the wooden posts, in a row along the north
    for i, x in enumerate(range(20, 33, 3)):
        b.fill(x, G - 1, 3, x, G + 1 + (i % 2), 3, log('stripped_oak_log'))
        b.set(x, G + 2 + (i % 2), 3, slab('oak_slab'))
    # throwing targets on the east, and the marks to throw from
    for z in range(4, 18, 3):
        b.set(W - 3, G, z, 'hay_block[axis=y]'); b.set(W - 3, G + 1, z, st('target', power=0))
        b.set(W - 14, G - 1, z, 'smooth_stone')
    # the sparring ring
    cx, cz = 24, 15
    for dx in range(-7, 8):
        for dz in range(-5, 6):
            e = (dx / 7.4) ** 2 + (dz / 5.4) ** 2
            if e <= 1:
                b.set(cx + dx, G - 1, cz + dz, 'sand' if e < 0.78 else 'smooth_sandstone')
    for (dx, dz) in ((-7, 0), (7, 0)):
        b.set(cx + dx, G, cz + dz, 'smooth_sandstone_slab[type=bottom,waterlogged=false]')
    # benches under the tree and along the wall, straw dummies
    for x in range(3, 8):
        b.set(x, G, D - 4, stairs('spruce_stairs', 'south'))
    for x in range(36, 41):
        b.set(x, G, D - 4, stairs('spruce_stairs', 'south'))
    for x in (14, 34):
        b.set(x, G, 12, log('stripped_oak_log')); b.set(x, G + 1, 12, 'hay_block[axis=y]')
        b.set(x - 1, G + 1, 12, st('spruce_fence', waterlogged=False)); b.set(x + 1, G + 1, 12, st('spruce_fence', waterlogged=False))
        b.set(x, G + 2, 12, 'carved_pumpkin[facing=south]') if False else None
    # bushes and flowers along the walls
    for (x, z) in ((2, 20), (2, 14), (W - 3, 22), (16, D - 3), (32, D - 3), (W - 6, 2), (40, 3)):
        b.set(x, G, z, AZALEA); b.set(x, G + 1, z, AZALEA) if (x + z) % 2 else None
    for (x, z) in ((3, 3), (12, 22), (30, 23), (44, 24), (18, 2)):
        b.set(x, G, z, 'poppy' if (x + z) % 2 else 'dandelion')
    tree(b, W - 5, G, D - 5, height=6, r=3)
    lamp_post(b, 17, G, 8); lamp_post(b, 33, G, 8)
    return b


# ---------------------------------------------------------------- Ichiraku Ramen
NOREN = [  # the five cloths over the counter, ラ ー メ ン 一楽, as red banner marks on white
    [('stripe_top', 'red'), ('stripe_middle', 'red'), ('stripe_downleft', 'red')],
    [('stripe_middle', 'red')],
    [('cross', 'red')],
    [('stripe_downleft', 'red'), ('square_top_left', 'red')],
    [('stripe_top', 'red'), ('straight_cross', 'red')],
]
METAL = 'dark_prismarine'


def ramen_shop():
    """Ichiraku, as in the anime: a small stand with five stools at the bar, five noren banners painted ラーメン一楽 over
    the opening, a corrugated metal pent roof; beside the counter a closed bit of wall with the gas cylinders; above, a
    little set-back storey with a balcony and a water tank; a paper lantern hanging at the corner."""
    W, D = 17, 13
    b = Build(W, 19, D)
    x1, z1, x2, z2 = 2, 2, 14, 8
    xo = 10                          # the opening is x1+1 .. xo-1, the closed wall beyond
    b.fill(x1, 0, z1, x2, G - 1, z2, 'stone_bricks')
    PLASTER = Mix(('white_terracotta', 6), ('smooth_sandstone', 2), salt=97)
    BOARDS = Mix(('stripped_spruce_log[axis=y]', 3), ('spruce_planks', 1), ('stripped_oak_log[axis=y]', 1), salt=98)
    # ground storey: G .. G+4, the floor block above at G+5
    for y in range(G, G + 5):
        for x in range(x1, x2 + 1):
            b.set(x, y, z1, PLASTER)
            b.set(x, y, z2, (BOARDS if y < G + 2 else PLASTER) if x >= xo else AIR)
        for z in range(z1, z2 + 1):
            b.set(x1, y, z, PLASTER); b.set(x2, y, z, PLASTER)
    for x in (x1, xo, x2):
        b.fill(x, G, z2, x, G + 4, z2, log('stripped_dark_oak_log'))
    b.fill(x1 + 1, G + 4, z2, xo - 1, G + 4, z2, 'stripped_dark_oak_wood[axis=x]')     # the noren rail
    b.fill(x1 + 1, G - 1, z1 + 1, x2 - 1, G - 1, z2, 'spruce_planks')
    b.fill(x1 + 1, G - 1, z2 - 1, xo - 1, G - 1, z2, 'smooth_sandstone')
    b.fill(x1, G + 5, z1, x2, G + 5, z2, 'spruce_planks')
    # the bar: wood with a white top, five stools, the kitchen right behind it
    for x in range(x1 + 1, xo):
        b.set(x, G, z2 - 2, 'stripped_spruce_wood[axis=x]')
        b.set(x, G + 1, z2 - 2, slab('smooth_quartz_slab'))
        if (x - x1) % 2:
            b.set(x, G, z2 - 1, st('iron_chain', axis='y', waterlogged=False))     # a thin metal stool post
            b.cushion(x, G + 1, z2 - 1, 'brown')
    for i, blk in enumerate(('water_cauldron[level=3]', st('campfire', facing='south', lit=True, signal_fire=False, waterlogged=False),
                             'water_cauldron[level=3]', st('smoker', facing='south', lit=True), st('barrel', facing='up', open=False))):
        b.set(x1 + 1 + i, G, z1 + 1, blk)
    b.set(x1 + 1, G, z1 + 2, 'crafting_table')
    for x in range(x1 + 1, xo):
        b.set(x, G + 2, z1 + 1, slab('spruce_slab', 'top'))
    b.set(x1 + 2, G + 3, z1 + 1, 'flower_pot'); b.set(x1 + 4, G + 3, z1 + 1, 'flower_pot')
    lamp(b, x1 + 3, G + 4, z2 - 3)
    # the back room behind the closed wall
    b.fill(xo, G, z1 + 1, xo, G + 4, z2 - 1, PLASTER)
    b.door(xo, G, z1 + 2, 'spruce', 'east')
    b.set(x2 - 1, G, z1 + 1, st('chest', facing='south', type='single', waterlogged=False))
    b.set(x2 - 1, G, z1 + 2, st('barrel', facing='up', open=False))
    # the noren: five banners hanging from the rail
    for i, pats in enumerate(NOREN):
        b.banner(x1 + 2 + i, G + 4, z2 + 1, 'south', 'white', pats)
    # the pent roof over the front
    for x in range(x1 - 1, x2 + 2):
        b.set(x, G + 5, z2 + 1, stairs(METAL + '_stairs', 'north'))
        b.set(x, G + 5, z2 + 2, slab(METAL + '_slab'))
    for z in range(z1, z2 + 1):
        b.set(x1 - 1, G + 5, z, stairs(METAL + '_stairs', 'east')); b.set(x2 + 1, G + 5, z, stairs(METAL + '_stairs', 'west'))
    # a little window and the gas cylinders on the closed wall, a paper note
    b.set(x2 - 1, G + 2, z2, 'glass_pane'); b.set(x2 - 2, G + 2, z2, 'glass_pane')
    b.set(xo + 1, G + 2, z2 + 1, st('birch_trapdoor', facing='south', half='top', open=True, powered=False, waterlogged=False))
    for x in (xo + 1, xo + 2):
        b.set(x, G, z2 + 1, 'terracotta'); b.set(x, G + 1, z2 + 1, 'terracotta')
        b.set(x, G + 2, z2 + 1, slab('mud_brick_slab')) if x != xo + 1 else None
    # the paper lantern on a bracket at the corner
    b.set(x1 - 1, G + 4, z2 + 1, st('dark_oak_fence', waterlogged=False))
    b.set(x1 - 1, G + 2, z2 + 1, st('iron_chain', axis='y', waterlogged=False)) if False else None
    b.set(x1 - 1, G + 3, z2 + 1, 'white_wool'); b.set(x1 - 1, G + 2, z2 + 1, 'red_wool')
    b.set(x1 - 1, G, z2 + 1, st('lantern', hanging=False, waterlogged=False)) if False else None
    # the upper storey, set back, with a balcony on the roof below and a round water tank
    ux1, ux2, uz2 = x1 + 3, x2, z2 - 3
    for x in range(ux1, ux2 + 1):
        for z in range(z1, uz2 + 1):
            for y in range(G + 6, G + 10):
                b.set(x, y, z, PLASTER if x in (ux1, ux2) or z in (z1, uz2) else AIR)
    for x in (ux1 + 2, ux1 + 3, ux2 - 2):
        b.set(x, G + 7, uz2, 'glass_pane'); b.set(x, G + 8, uz2, 'glass_pane')
    b.door(ux1 + 5, G + 6, uz2, 'spruce', 'south')
    for x in range(ux1, ux2 + 1):
        b.set(x, G + 6, z2, st('dark_oak_fence', waterlogged=False))
    b.hip(ux1, z1, ux2, uz2, G + 10, METAL + '_stairs', METAL, over=1, eave=METAL + '_stairs')
    for y in range(G + 6, G + 11):
        b.ring(x1 + 1, y, z1 + 2, 1.5, 'light_gray_terracotta' if y % 2 else 'gray_terracotta')
    b.disc(x1 + 1, G + 11, z1 + 2, 1.5, slab('smooth_stone_slab'))
    # the street in front
    for x in range(W):
        for z in range(z2 + 1, D):
            if b.get(x, G - 1, z) is None:
                b.set(x, G - 1, z, 'dirt_path' if _hash(x, 0, z, 93) < 0.7 else 'coarse_dirt')
    return b


# ---------------------------------------------------------------- the hospital
def hospital():
    """Konoha Hospital: a pale four-storey block with blue-tinted windows in long bands, a front canopy with the red
    cross, and the flat roof (railed, with water tanks) where Naruto and Sasuke fight in chapter 3. Inside: the lobby with
    reception and benches, wards of curtained beds, an operating room, the stairs up to the roof."""
    W, D = 45, 30
    b = Build(W, 38, D)
    x1, z1, x2, z2 = 3, 3, 41, 21
    m = (x1 + x2) // 2
    F = (G, G + 5, G + 10, G + 15)
    top = G + 19
    sx0 = x2 - 9                     # the stairs' west end
    WALL = Mix(('white_concrete', 6), ('white_terracotta', 1), ('calcite', 2), salt=96)
    b.fill(x1 - 1, 0, z1 - 1, x2 + 1, G - 1, z2 + 7, 'stone_bricks')
    b.box(x1, G, z1, x2, top, z2, WALL)
    for x in range(x1, x2 + 1):
        for z in (z1, z2):
            b.set(x, G, z, 'light_gray_concrete')
            for fy in F[1:]:
                b.set(x, fy - 1, z, 'light_blue_terracotta')
    for z in range(z1, z2 + 1):
        for x in (x1, x2):
            b.set(x, G, z, 'light_gray_concrete')
            for fy in F[1:]:
                b.set(x, fy - 1, z, 'light_blue_terracotta')
    b.fill(x1 + 1, G - 1, z1 + 1, x2 - 1, G - 1, z2 - 1, 'smooth_quartz')
    for fy in F[1:]:
        b.fill(x1 + 1, fy - 1, z1 + 1, x2 - 1, fy - 1, z2 - 1, 'smooth_stone')
    b.fill(x1, top, z1, x2, top, z2, 'smooth_stone')
    # window bands: long runs of tinted panes with white mullions
    for fy in F:
        for y in (fy + 1, fy + 2):
            for x in range(x1 + 2, x2 - 1):
                if (x - x1) % 4 == 1:
                    continue
                if fy == G and m - 4 <= x <= m + 4:
                    continue
                b.set(x, y, z2, 'light_blue_stained_glass_pane'); b.set(x, y, z1, 'light_blue_stained_glass_pane')
            for z in range(z1 + 2, z2 - 1):
                if (z - z1) % 4 == 1:
                    continue
                b.set(x1, y, z, 'light_blue_stained_glass_pane'); b.set(x2, y, z, 'light_blue_stained_glass_pane')
    # corners: pilasters standing out a little
    for (x, z) in ((x1, z1), (x1, z2), (x2, z1), (x2, z2)):
        b.fill(x, G, z, x, top + 1, z, 'smooth_quartz')
    # the roof: a railing, the water tanks, the stair house
    for x in range(x1, x2 + 1):
        b.set(x, top + 1, z1, 'smooth_quartz_slab[type=bottom,waterlogged=false]'); b.set(x, top + 1, z2, 'smooth_quartz_slab[type=bottom,waterlogged=false]')
        b.set(x, top + 2, z1, st('iron_bars', east=True, west=True, north=False, south=False, waterlogged=False))
        b.set(x, top + 2, z2, st('iron_bars', east=True, west=True, north=False, south=False, waterlogged=False))
    for z in range(z1, z2 + 1):
        b.set(x1, top + 1, z, 'smooth_quartz_slab[type=bottom,waterlogged=false]'); b.set(x2, top + 1, z, 'smooth_quartz_slab[type=bottom,waterlogged=false]')
        b.set(x1, top + 2, z, st('iron_bars', north=True, south=True, east=False, west=False, waterlogged=False))
        b.set(x2, top + 2, z, st('iron_bars', north=True, south=True, east=False, west=False, waterlogged=False))
    rt = top + 1
    for (x, z) in ((x1 + 5, z1 + 5), (x1 + 11, z1 + 5), (x1 + 5, z2 - 5)):
        for dx, dz in ((-1, -1), (1, -1), (-1, 1), (1, 1)):
            b.fill(x + dx, rt, z + dz, x + dx, rt + 2, z + dz, st('iron_bars', east=False, north=False, south=False, west=False, waterlogged=False))
        for y in range(rt + 3, rt + 6):
            b.disc(x, y, z, 2, 'white_concrete' if y < rt + 5 else 'light_gray_concrete')
        b.disc(x, rt + 6, z, 1.5, slab('smooth_stone_slab'))
    hx1, hz1, hx2, hz2 = sx0 - 3, z1 + 1, sx0 + 6, z1 + 7
    b.box(hx1, rt, hz1, hx2, rt + 4, hz2, WALL)
    b.fill(hx1 + 1, rt, hz1 + 1, hx2 - 1, rt + 3, hz2 - 1, AIR)
    b.fill(hx1 - 1, rt + 5, hz1 - 1, hx2 + 1, rt + 5, hz2 + 1, slab('smooth_quartz_slab'))
    b.door(sx0 + 1, rt, hz2, 'birch', 'south')
    # the canopy and the cross
    for x in range(m - 6, m + 7):
        for z in range(z2 + 1, z2 + 6):
            b.set(x, G + 4, z, slab('smooth_quartz_slab', 'top'))
        b.set(x, G + 5, z2 + 5, slab('smooth_quartz_slab'))
    for x in (m - 6, m + 6):
        b.fill(x, G, z2 + 5, x, G + 3, z2 + 5, 'smooth_quartz')
    for x in range(m - 3, m + 4):
        b.fill(x, G, z2, x, G + 3, z2, AIR)
    for x in (m - 2, m - 1, m + 1, m + 2):
        b.door(x, G, z2, 'birch', 'south', 'left' if x < m else 'right')
    b.fill(m - 3, G + 2, z2, m + 3, G + 3, z2, 'light_blue_stained_glass') if False else None
    for x in range(m - 7, m + 8):
        for z in range(z2 + 1, z2 + 7):
            b.set(x, G - 1, z, 'polished_andesite' if abs(x - m) < 6 else 'stone_bricks')
    cross = ['..###..', '..###..', '#######', '#######', '#######', '..###..', '..###..']
    b.fill(m - 4, G + 6, z2 + 1, m + 4, G + 14, z2 + 1, TRIM)
    b.glyph(cross, m - 3, G + 7, z2 + 1, RED)
    lamp(b, m - 3, G + 3, z2 + 3); lamp(b, m + 3, G + 3, z2 + 3)

    # ---- inside. Ground floor: the lobby, reception, benches; a corridor runs east-west through every floor
    cz1, cz2 = z1 + 8, z1 + 10          # the corridor
    y0 = F[0]
    for fy in F:
        for z in (cz1 - 1, cz2 + 1):
            b.fill(x1 + 1, fy, z, x2 - 1, fy + 3, z, 'white_concrete')
            for x in range(x1 + 1, x2):
                b.set(x, fy + 3, z, 'light_blue_terracotta') if False else None
        for x in range(x1 + 1, x2, 4):
            lamp(b, x + 1, fy + 3, cz1 + 1)
            for z, f in ((cz1 - 1, 'north'), (cz2 + 1, 'south')):
                if (x // 4) % 2 == 0:
                    b.door(x + 2, fy, z, 'birch', f)
    # lobby: the front rooms on the ground floor are one open hall
    b.fill(m - 9, y0, cz2 + 1, m + 9, y0 + 3, cz2 + 1, AIR)
    for x in range(m - 5, m + 6):
        b.set(x, y0, z2 - 6, stairs('birch_stairs', 'south', top=True)) if abs(x - m) > 0 else b.set(x, y0, z2 - 6, 'birch_planks')
    chair(b, m - 2, y0, z2 - 7, 'south'); chair(b, m + 2, y0, z2 - 7, 'south')
    b.set(m, y0 + 1, z2 - 6, st('white_carpet'))
    for side in (-1, 1):
        for row in range(2):
            for k in range(4):
                b.set(m + side * (9 + k), y0, z2 - 4 + row * 2, stairs('birch_stairs', 'south'))
        b.set(m + side * 15, y0, z2 - 1, 'potted_bamboo')
    for x in range(x1 + 1, x2):
        for z in range(cz2 + 2, z2):
            if b.get(x, y0 - 1, z) == 'smooth_quartz' and (x + z) % 2 == 0:
                b.set(x, y0 - 1, z, 'white_concrete')
    # wards on every other floor: beds along the walls with white curtains between, a chair and a pot by each
    for fy in F[1:]:
        for (zw, f, zz) in ((z1 + 1, 'north', 1), (z2 - 1, 'south', -1)):
            for x in range(x1 + 2, x2 - 1, 3):
                if b.get(x, fy, zw) not in (None, AIR) or (f == 'north' and x >= sx0 - 3):
                    continue
                bed(b, x, fy, zw, f, 'white')
                b.set(x + 1, fy, zw, 'potted_white_tulip' if (x + fy) % 2 else st('white_carpet'))
                b.set(x - 1, fy + 2, zw + zz, st('white_wall_banner', facing='east')) if False else None
    # an operating room on the first floor, west end: a table under strong lights
    oy = F[1]
    for x in range(x1 + 1, x1 + 9):
        for z in range(z1 + 1, cz1 - 1):
            b.set(x, oy, z, AIR)
            b.set(x, oy - 1, z, 'light_blue_concrete' if (x + z) % 2 else 'white_concrete')
    b.set(x1 + 4, oy, z1 + 3, 'smooth_quartz'); b.set(x1 + 4, oy, z1 + 4, 'smooth_quartz')
    b.set(x1 + 4, oy + 1, z1 + 3, st('white_carpet')); b.set(x1 + 4, oy + 1, z1 + 4, st('white_carpet'))
    b.set(x1 + 4, oy + 3, z1 + 3, 'sea_lantern'); b.set(x1 + 4, oy + 3, z1 + 4, 'sea_lantern')
    b.set(x1 + 1, oy, z1 + 1, st('brewing_stand', has_bottle_0=True, has_bottle_1=True, has_bottle_2=False))
    b.set(x1 + 2, oy, z1 + 1, 'water_cauldron[level=3]')
    # the stairs in the north-east room: flights along x, east then west, up to the roof's stair house
    for k, fy in enumerate(F):
        rows, d = ((z1 + 2, z1 + 3), 1) if k % 2 == 0 else ((z1 + 4, z1 + 5), -1)
        for i in range(5):
            x = sx0 + i if d == 1 else sx0 + 4 - i
            for z in rows:
                b.set(x, fy + i, z, stairs('quartz_stairs', 'east' if d == 1 else 'west'))
                for h in range(1, 4):
                    if fy + i + h <= top:
                        b.set(x, fy + i + h, z, AIR)
    return b


PIECES = {'academy': academy, 'academy_yard': academy_yard, 'ramen_shop': ramen_shop, 'hospital': hospital}
