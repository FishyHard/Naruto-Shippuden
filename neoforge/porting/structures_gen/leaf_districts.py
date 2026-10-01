"""The Hidden Leaf's quarters and the places the story visits between missions: the Uchiha quarter (the police
headquarters, the Naka Shrine), the Hyūga compound, the Akimichi compound, the Nara deer forest, Yakiniku Q, the hot
springs, the Yamanaka flower shop, and groves of trees to break up the open ground.

The traditional houses here (white plaster, dark timber, grey tiled roofs, a veranda) face south or north; compounds are
built facing south (their gate in the south wall) and turned in the layout. Faces south (+z); y 0..1 is foundation, the
ground floor is y = 2 (leaf.G)."""
import math
from build import Build, Mix, st, stairs, slab, log, AIR, _hash
from leaf import G, tree, lamp_post

TILE, TILE_FULL, TILE_SLAB = 'deepslate_tile_stairs', 'deepslate_tiles', 'deepslate_tile_slab'
PLASTER = Mix(('white_terracotta', 3), ('calcite', 4), ('smooth_quartz', 1), salt=131)
TIMBER = 'stripped_dark_oak_log'
OAK_LEAVES = st('oak_leaves', distance=1, persistent=True, waterlogged=False)
AZALEA = st('azalea_leaves', distance=1, persistent=True, waterlogged=False)
FLIP = {'north': 'south', 'south': 'north'}

UCHIHA_FAN = [  # the Uchiha crest: a paper fan, red above white, on a handle
    '..RRR..',
    '.RRRRR.',
    'RRRRRRR',
    'RRRRRRR',
    'WWWWWWW',
    'WWWWWWW',
    '.WWWWW.',
    '..WWW..',
    '...H...',
    '...H...',
]
COLOURS = {'R': 'red_concrete', 'W': 'white_concrete', 'H': 'dark_oak_planks', 'B': 'black_concrete', 'G': 'gray_concrete',
           'Y': 'yellow_concrete', 'O': 'orange_concrete', 'L': 'light_gray_concrete'}
HYUGA = [  # a stylised Hyūga crest: a white eye in a grey ring
    '..GGG..',
    '.G...G.',
    'G.WWW.G',
    'G.W.W.G',
    'G.WWW.G',
    '.G...G.',
    '..GGG..',
]
AKIMICHI = ['.OOO.', 'O.O.O', 'OOOOO', 'O.O.O', '.OOO.']        # a round crest with the character's cross
NARA = ['B...B', '.B.B.', '..B..', '.B.B.', 'B...B']             # antlers, crossed


def paint(b, rows, x0, y0, z0, plane='xy', flip=False):
    """A crest in several colours (letters in COLOURS), the top row first."""
    n = len(rows)
    for r, line in enumerate(rows):
        for k, ch in enumerate(line):
            if ch in COLOURS:
                k2 = len(line) - 1 - k if flip else k
                if plane == 'xy':
                    b.set(x0 + k2, y0 + n - 1 - r, z0, COLOURS[ch])
                else:
                    b.set(x0, y0 + n - 1 - r, z0 + k2, COLOURS[ch])


# ---------------------------------------------------------------- the traditional house
def trad_house(b, x1, z1, w, d, facing='south', storeys=1, seed=0, big=False):
    """A traditional house with its footprint x1..x1+w-1, z1..z1+d-1 inside `b`: a stone plinth, white plaster between
    dark timber posts, paper-screen windows, a veranda along the front under the eaves, a grey tiled hip roof (a second
    tier when `big`), tatami inside with a low table, cushions and a futon."""
    x2, z2 = x1 + w - 1, z1 + d - 1
    front = z2 if facing == 'south' else z1
    back = z1 if facing == 'south' else z2
    out = 1 if facing == 'south' else -1
    hh = 4 * storeys
    b.fill(x1, G - 1, z1, x2, G - 1, z2, 'stone_bricks')
    # the veranda: a deck a step up, along the front, outside the wall line
    vz = front - out * 0                         # the wall line stays at `front`; the deck is the row in front
    for x in range(x1 - 1, x2 + 2):
        b.set(x, G - 1, front + out, 'spruce_planks')
        b.set(x, G - 1, front + 2 * out, slab('spruce_slab', 'top'))
    # the walls
    for y in range(G, G + hh):
        for x in range(x1, x2 + 1):
            for z in (z1, z2):
                post = (x - x1) % 3 == 0 or x == x2
                b.set(x, y, z, log(TIMBER) if post else PLASTER)
        for z in range(z1 + 1, z2):
            for x in (x1, x2):
                post = (z - z1) % 3 == 0
                b.set(x, y, z, log(TIMBER) if post else PLASTER)
    for x in range(x1, x2 + 1):
        for z in (z1, z2):
            b.set(x, G + 3, z, 'stripped_dark_oak_wood[axis=x]')
    b.fill(x1 + 1, G - 1, z1 + 1, x2 - 1, G - 1, z2 - 1, 'bamboo_mosaic')
    for s_ in range(1, storeys):
        b.fill(x1 + 1, G + 4 * s_ - 1, z1 + 1, x2 - 1, G + 4 * s_ - 1, z2 - 1, 'spruce_planks')
    # paper-screen windows between the posts, a sliding door in the middle of the front
    for s_ in range(storeys):
        y = G + 4 * s_ + 1
        for x in range(x1 + 1, x2):
            if (x - x1) % 3 != 0:
                b.set(x, y, front, 'white_stained_glass'); b.set(x, y + 1, front, 'white_stained_glass')
                if (x - x1) % 3 == 1:
                    b.set(x, y, back, 'white_stained_glass')
        for z in range(z1 + 1, z2):
            if (z - z1) % 3 == 1:
                b.set(x1, y, z, 'white_stained_glass'); b.set(x2, y, z, 'white_stained_glass')
    mx = x1 + w // 2
    b.door(mx, G, front, 'spruce', facing, 'left')
    b.set(mx, G + 2, front, PLASTER) if (mx - x1) % 3 else None
    # the eaves over the veranda and the roof
    ry = G + hh
    b.fill(x1, ry, z1, x2, ry, z2, 'dark_oak_planks')
    b.hip(x1, z1, x2, z2, ry, TILE, TILE_FULL, over=2, eave=TILE, layers=None if not big else 3)
    if big:
        b.fill(x1 + 2, ry + 3, z1 + 2, x2 - 2, ry + 4, z2 - 2, PLASTER)
        b.hip(x1 + 2, z1 + 2, x2 - 2, z2 - 2, ry + 5, TILE, TILE_FULL, over=1, eave=TILE)
    # posts holding the eaves at the veranda's edge
    for x in (x1 - 1, x2 + 1):
        b.fill(x, G, front + out, x, ry - 1, front + out, st('dark_oak_fence', waterlogged=False))
    # inside: a low table, cushions round it, a futon, a hanging scroll, a lantern
    cz_ = (z1 + z2) // 2
    b.set(mx, G, cz_, slab('dark_oak_slab'))
    for dx in (-1, 1):
        b.cushion(mx + dx, G, cz_, ['red', 'blue', 'brown', 'green'][(seed + dx) % 4])
    b.set(x1 + 1, G, back + out, st('white_carpet')); b.set(x1 + 2, G, back + out, st('white_carpet'))
    b.set(x2 - 1, G + 2, back + out, st('white_wall_banner', facing=facing))
    b.set(mx, G + 3, cz_, st('lantern', hanging=True, waterlogged=False))
    b.set(x2 - 1, G, back + out, st('chest', facing=facing, type='single', waterlogged=False))


def compound_wall(b, x1, z1, x2, z2, gate_w=5, crest=None, crest_every=14, h=4):
    """A compound's wall: white plaster on a stone base, a grey tiled cap, posts every few blocks; a gate in the middle
    of the south side under a small roof, the clan's crest over it and along the outside."""
    gm = (x1 + x2) // 2
    for x in range(x1, x2 + 1):
        for z in range(z1, z2 + 1):
            if x not in (x1, x2) and z not in (z1, z2):
                continue
            if z == z2 and abs(x - gm) <= gate_w // 2:
                continue
            for y in range(G - 1, G + h):
                post = (x + z) % 6 == 0
                b.set(x, y, z, 'stone_bricks' if y < G + 1 else (log(TIMBER) if post else PLASTER))
            b.set(x, G + h, z, TILE_FULL)
            b.set(x, G + h + 1, z, slab(TILE_SLAB))
    # the cap's edges
    for x in range(x1 - 1, x2 + 2):
        for z, f in ((z1 - 1, 'south'), (z1 + 1, 'north'), (z2 - 1, 'south'), (z2 + 1, 'north')):
            if z in (z2 - 1, z2 + 1) and abs(x - gm) <= gate_w // 2:
                continue
            if x1 <= x <= x2 and b.get(x, G + h, z) in (None, AIR):
                b.set(x, G + h, z, stairs(TILE, f))
    for z in range(z1, z2 + 1):
        for x, f in ((x1 - 1, 'east'), (x1 + 1, 'west'), (x2 - 1, 'east'), (x2 + 1, 'west')):
            if b.get(x, G + h, z) in (None, AIR):
                b.set(x, G + h, z, stairs(TILE, f))
    # the gate: two tall posts, a beam, a little roof, the crest above
    gh = h + 3
    for x in (gm - gate_w // 2 - 1, gm + gate_w // 2 + 1):
        b.fill(x, G - 1, z2, x, G + gh, z2, log(TIMBER))
    b.fill(gm - gate_w // 2, G + gh - 2, z2, gm + gate_w // 2, G + gh, z2, 'dark_oak_planks')
    b.fill(gm - gate_w // 2 - 2, G + gh + 1, z2 - 1, gm + gate_w // 2 + 2, G + gh + 1, z2 + 1, TILE_FULL)
    for x in range(gm - gate_w // 2 - 2, gm + gate_w // 2 + 3):
        b.set(x, G + gh + 1, z2 + 2, stairs(TILE, 'north')); b.set(x, G + gh + 1, z2 - 2, stairs(TILE, 'south'))
        b.set(x, G + gh + 2, z2, slab(TILE_SLAB))
    for z in range(z2 - 2, z2 + 3):
        b.set(gm - gate_w // 2 - 3, G + gh + 1, z, stairs(TILE, 'east')); b.set(gm + gate_w // 2 + 3, G + gh + 1, z, stairs(TILE, 'west'))
    for x in range(gm - gate_w // 2, gm + gate_w // 2 + 1):
        b.set(x, G - 1, z2, 'polished_andesite')
    if crest:
        ch, cw = len(crest), len(crest[0])
        # a white board in front of the beam carries the crest
        by = G + gh + 2
        b.fill(gm - cw // 2 - 1, by, z2, gm + cw // 2 + 1, by + ch + 1, z2, 'white_concrete')
        b.fill(gm - cw // 2 - 2, by + ch + 2, z2, gm + cw // 2 + 2, by + ch + 2, z2, slab(TILE_SLAB))
        paint(b, crest, gm - cw // 2, by + 1, z2 + 1)
        paint(b, crest, gm - cw // 2, by + 1, z2 - 1, flip=True)          # and on the inside face
        # and along the outside of the wall, painted on the plaster
        for x in list(range(x1 + 6, gm - gate_w, crest_every)) + list(range(gm + gate_w + 4, x2 - cw, crest_every)):
            if ch <= h + 1:
                paint(b, crest, x, G, z2 + 1)
    lamp_post(b, gm - gate_w // 2 - 2, G, z2 + 2); lamp_post(b, gm + gate_w // 2 + 2, G, z2 + 2)


def ground(b, x1, z1, x2, z2, salt, grass=0.7):
    for x in range(x1, x2 + 1):
        for z in range(z1, z2 + 1):
            v = _hash(x, 0, z, salt)
            b.set(x, G - 1, z, 'grass_block[snowy=false]' if v < grass else 'coarse_dirt' if v < grass + 0.15 else 'dirt_path')
            b.set(x, G - 2, z, 'dirt')


def path(b, x1, z1, x2, z2, block='dirt_path'):
    for x in range(x1, x2 + 1):
        for z in range(z1, z2 + 1):
            b.set(x, G - 1, z, block)


def stone_lantern(b, x, z):
    b.set(x, G, z, 'stone_bricks'); b.set(x, G + 1, z, st('stone_brick_wall', up=True, north='none', south='none', east='none', west='none', waterlogged=False))
    b.set(x, G + 2, z, st('lantern', hanging=False, waterlogged=False))


# ---------------------------------------------------------------- the Uchiha quarter
def police_hq(b, x1, z1, w, d):
    """The Konoha Military Police headquarters: a stout two-storey block of grey stone and white plaster, the police mark
    (the Uchiha fan in a star) over the door, a front that opens onto the street outside the quarter's wall."""
    x2, z2 = x1 + w - 1, z1 + d - 1
    b.fill(x1, G - 1, z1, x2, G - 1, z2, 'stone_bricks')
    WALL = Mix(('polished_andesite', 3), ('stone_bricks', 2), ('andesite', 1), salt=132)
    b.box(x1, G, z1, x2, G + 9, z2, WALL)
    b.fill(x1 + 1, G, z1 + 1, x2 - 1, G + 8, z2 - 1, AIR)
    b.fill(x1 + 1, G - 1, z1 + 1, x2 - 1, G - 1, z2 - 1, 'polished_andesite')
    b.fill(x1 + 1, G + 4, z1 + 1, x2 - 1, G + 4, z2 - 1, 'spruce_planks')
    for x in range(x1, x2 + 1):
        for y in (G + 4, G + 9):
            b.set(x, y, z2, 'white_concrete'); b.set(x, y, z1, 'white_concrete')
    for x in range(x1 + 2, x2 - 1, 3):
        for y in (G + 1, G + 6):
            if not (y == G + 1 and abs(x - (x1 + x2) // 2) <= 2):
                b.set(x, y, z2, 'glass_pane'); b.set(x, y + 1, z2, 'glass_pane')
            b.set(x, y, z1, 'glass_pane')
    m = (x1 + x2) // 2
    b.fill(m - 1, G, z2, m + 1, G + 2, z2, AIR)
    b.door(m - 1, G, z2, 'dark_oak', 'south', 'right'); b.door(m + 1, G, z2, 'dark_oak', 'south', 'left')
    b.set(m, G, z2, AIR); b.set(m, G + 1, z2, AIR)
    # the police mark: a fan inside a star, on a dark board
    b.fill(m - 5, G + 5, z2 + 1, m + 5, G + 14, z2 + 1, 'black_concrete')
    for (dx, dy) in ((-5, 9), (5, 9), (-5, 0), (5, 0)):
        b.set(m + dx, G + 5 + dy, z2 + 1, AIR)
    paint(b, UCHIHA_FAN, m - 3, G + 5, z2 + 2)
    b.fill(x1, G + 10, z1, x2, G + 10, z2, 'smooth_stone_slab[type=double,waterlogged=false]')
    for x in range(x1, x2 + 1):
        b.set(x, G + 11, z1, slab('smooth_stone_slab')); b.set(x, G + 11, z2, slab('smooth_stone_slab'))
    # inside: desks, a holding cell, stairs
    for x in range(x1 + 2, x2 - 2, 4):
        b.set(x, G, z1 + 3, 'dark_oak_planks'); b.set(x + 1, G, z1 + 3, 'dark_oak_planks')
        b.set(x, G, z1 + 4, stairs('dark_oak_stairs', 'south'))
        b.set(x, G + 1, z1 + 3, st('white_carpet'))
    for y in range(G, G + 3):
        b.fill(x2 - 4, y, z1 + 1, x2 - 4, y, z1 + 4, st('iron_bars', north=True, south=True, east=False, west=False, waterlogged=False))
    for i in range(4):
        b.set(x1 + 1, G + i, z2 - 2 - i, stairs('spruce_stairs', 'north'))
        b.set(x1 + 1, G + 4, z2 - 2 - i, AIR) if i > 0 else None
    for x in range(x1 + 3, x2 - 2, 5):
        b.set(x, G + 3, (z1 + z2) // 2, st('lantern', hanging=True, waterlogged=False))


def naka_shrine(b, x1, z1):
    """The Naka Shrine: a small shrine of dark wood on a raised stone floor, a red torii before it, stone lanterns."""
    w, d = 9, 7
    x2, z2 = x1 + w - 1, z1 + d - 1
    b.fill(x1 - 1, G - 1, z1 - 1, x2 + 1, G, z2 + 1, 'stone_bricks')
    for y in range(G + 1, G + 5):
        for x in range(x1, x2 + 1):
            for z in (z1, z2):
                b.set(x, y, z, log(TIMBER) if x in (x1, x2) or y == G + 4 else ('dark_oak_planks' if z == z1 else AIR))
        for z in range(z1, z2 + 1):
            b.set(x1, y, z, log(TIMBER)); b.set(x2, y, z, log(TIMBER))
    b.fill(x1, G + 5, z1, x2, G + 5, z2, 'dark_oak_planks')
    b.gable(x1, z1, x2, z2, G + 5, TILE, slab(TILE_SLAB), axis='x', over=2, eave=TILE, gable_wall='dark_oak_planks')
    b.set((x1 + x2) // 2, G + 1, z1 + 1, st('decorated_pot', cracked=False, facing='south', waterlogged=False))
    b.set((x1 + x2) // 2, G + 3, z2, st('bell', attachment='ceiling', facing='south', powered=False))
    m = (x1 + x2) // 2
    tz = z2 + 5
    for x in (m - 3, m + 3):
        b.fill(x, G, tz, x, G + 5, tz, 'red_concrete')
    b.fill(m - 4, G + 6, tz, m + 4, G + 6, tz, 'red_concrete')
    b.fill(m - 3, G + 4, tz, m + 3, G + 4, tz, 'red_concrete')
    b.set(m - 5, G + 6, tz, slab('blackstone_slab')); b.set(m + 5, G + 6, tz, slab('blackstone_slab'))
    b.fill(m - 4, G + 7, tz, m + 4, G + 7, tz, slab('blackstone_slab'))
    for z in range(z2 + 2, tz + 4):
        b.set(m, G - 1, z, 'gravel'); b.set(m - 1, G - 1, z, 'gravel'); b.set(m + 1, G - 1, z, 'gravel')
    stone_lantern(b, m - 3, z2 + 3); stone_lantern(b, m + 3, z2 + 3)


def uchiha_quarter():
    """The Uchiha quarter: a walled district with its gate under the clan's fan; inside, lanes of traditional houses,
    the clan head's larger house at the far end (Sasuke's home), the Naka Shrine, and by the gate the Military Police
    headquarters, whose front opens onto the street outside."""
    W, D = 63, 68
    b = Build(W, 32, D)
    ground(b, 0, 0, W - 1, D - 1, 133, grass=0.75)
    compound_wall(b, 0, 0, W - 1, D - 3, gate_w=5, crest=UCHIHA_FAN, crest_every=13, h=5)
    gm = W // 2
    # the lanes: one up from the gate, two across
    path(b, gm - 1, 8, gm + 1, D - 4)
    for lz in (21, 43):
        path(b, 3, lz, W - 4, lz + 2)
    # houses facing the lanes
    k = 0
    for lz in (21, 43):
        for x in list(range(4, gm - 3, 13)) + list(range(gm + 4, W - 12, 13)):
            if lz == 43 and gm + 4 <= x and False:
                continue
            trad_house(b, x, lz - 9, 10, 7, 'south', seed=k); k += 1
            if lz == 21 or x < gm:
                trad_house(b, x, lz + 4, 10, 7, 'north', seed=k); k += 1
    # the clan head's house at the north end, larger, two tiers of roof
    trad_house(b, gm - 9, 2, 19, 9, 'south', seed=7, big=True)
    # the shrine in the north-west, the police headquarters by the gate in the south-east
    naka_shrine(b, 4, 2)
    police_hq(b, W - 22, D - 17, 20, 14)
    for x in range(W - 22, W - 2):
        b.set(x, G - 1, D - 3, 'polished_andesite')
    # trees and lanterns along the lanes
    for (x, z) in ((gm - 4, 30), (gm + 4, 30), (gm - 4, 52), (14, 33), (48, 33), (8, 58), (24, 58)):
        tree(b, x, G, z, height=5, r=2)
    for x in range(6, W - 6, 9):
        if abs(x - gm) > 3:
            lamp_post(b, x, G, 24)
    return b


# ---------------------------------------------------------------- the Hyūga compound
def hyuga_compound():
    """The Hyūga compound: a long main hall with two tiers of roof, wings either side round a courtyard with a pond and
    a little bridge, the sanded yard where the Gentle Fist is trained, the whole inside a crested wall."""
    W, D = 60, 56
    b = Build(W, 34, D)
    ground(b, 0, 0, W - 1, D - 1, 134, grass=0.8)
    compound_wall(b, 0, 0, W - 1, D - 3, gate_w=5, crest=HYUGA, crest_every=12, h=5)
    gm = W // 2
    trad_house(b, gm - 14, 3, 29, 11, 'south', seed=1, big=True)           # the main hall
    trad_house(b, 4, 18, 11, 16, 'south', seed=2)                          # the west wing
    trad_house(b, W - 15, 18, 11, 16, 'south', seed=3)                     # the east wing
    # the courtyard pond and its bridge
    px, pz = gm, 26
    for x in range(px - 9, px + 10):
        for z in range(pz - 5, pz + 6):
            e = ((x - px) / 8.6) ** 2 + ((z - pz) / 4.8) ** 2
            if e <= 1:
                b.set(x, G - 1, z, 'water'); b.set(x, G - 2, z, 'water'); b.set(x, G - 3, z, 'gravel')
            elif e <= 1.35:
                b.set(x, G - 1, z, 'mossy_cobblestone' if _hash(x, 0, z, 135) < 0.5 else 'stone')
    for z in range(pz - 6, pz + 7):
        rise = 1 if abs(z - pz) <= 3 else 0
        b.set(px, G - 1 + rise, z, 'red_concrete' if abs(z - pz) in (4,) else 'spruce_planks')
        b.set(px - 1, G + rise, z, st('mangrove_fence', waterlogged=False)) if abs(z - pz) < 5 else None
        b.set(px + 1, G + rise, z, st('mangrove_fence', waterlogged=False)) if abs(z - pz) < 5 else None
        b.set(px, G + rise, z, AIR)
    path(b, gm - 1, 33, gm + 1, D - 4, 'gravel')
    path(b, gm - 1, 14, gm + 1, pz - 7, 'gravel')
    # the training yard: sand, posts, in the south-west
    for x in range(5, 24):
        for z in range(38, 51):
            b.set(x, G - 1, z, 'sand' if (x + z) % 7 else 'smooth_sandstone')
    for x in (8, 13, 18):
        b.fill(x, G, 41, x, G + 2, 41, log('stripped_oak_log'))
    # gardens in the south-east: azaleas, a maple-red tree, stone lanterns
    for (x, z) in ((40, 40), (46, 44), (52, 39), (44, 49)):
        b.set(x, G, z, AZALEA); b.set(x + 1, G, z, AZALEA); b.set(x, G + 1, z, AZALEA)
    tree(b, 49, G, 46, height=5, r=3, trunk='cherry_log', leaves=st('cherry_leaves', distance=1, persistent=True, waterlogged=False))
    for (x, z) in ((gm - 4, 36), (gm + 4, 36), (gm - 4, 48), (gm + 4, 48)):
        stone_lantern(b, x, z)
    return b


# ---------------------------------------------------------------- the Akimichi compound
def akimichi_compound():
    """The Akimichi compound: a broad house and a kitchen garden inside a crested wall, a big outdoor grill."""
    W, D = 36, 32
    b = Build(W, 24, D)
    ground(b, 0, 0, W - 1, D - 1, 136, grass=0.8)
    compound_wall(b, 0, 0, W - 1, D - 3, gate_w=3, crest=AKIMICHI, crest_every=12, h=4)
    trad_house(b, 5, 3, 25, 9, 'south', seed=4, big=True)
    path(b, W // 2 - 1, 15, W // 2 + 1, D - 4)
    for x in range(4, 14):
        for z in range(18, 27):
            b.set(x, G - 1, z, 'farmland[moisture=7]' if (z % 3) else 'water')
            if z % 3:
                b.set(x, G, z, st('carrots', age=7) if x % 2 else st('potatoes', age=7))
    for x in range(23, 30):
        for z in range(19, 25):
            b.set(x, G - 1, z, 'stone_bricks')
    b.set(26, G, 21, st('campfire', facing='north', lit=True, signal_fire=False, waterlogged=False))
    for (x, z) in ((24, 21), (28, 21), (26, 19), (26, 23)):
        b.cushion(x, G, z, 'orange')
    return b


# ---------------------------------------------------------------- the Nara deer forest
def nara_forest():
    """The Nara clan's forest, where their deer live: dense old trees round a small clearing with the Nara house, a
    stream-side bench, the antler crest over the gate."""
    W, D = 40, 24
    b = Build(W, 22, D)
    ground(b, 0, 0, W - 1, D - 1, 137, grass=0.85)
    for (x, z) in [(x, z) for x in range(2, W - 1, 4) for z in range(2, D - 1, 4)]:
        x2, z2 = x + (z * 5) % 3 - 1, z + (x * 3) % 3 - 1
        if 12 <= x2 <= 27 and 6 <= z2 <= 20:
            continue
        tree(b, x2, G, z2, height=7 + (x + z) % 3, r=2, trunk='dark_oak_log' if (x + z) % 3 else 'spruce_log',
             leaves=OAK_LEAVES if (x + z) % 2 else st('dark_oak_leaves', distance=1, persistent=True, waterlogged=False))
    trad_house(b, 14, 8, 12, 8, 'south', seed=5)
    path(b, 19, 18, 21, D - 1)
    for x in (17, 23):
        b.fill(x, G, D - 2, x, G + 4, D - 2, log(TIMBER))
    b.fill(17, G + 5, D - 2, 23, G + 5, D - 2, 'dark_oak_planks')
    b.fill(18, G + 6, D - 2, 22, G + 10, D - 2, 'white_concrete')
    paint(b, NARA, 18, G + 6, D - 1)
    return b


# ---------------------------------------------------------------- Yakiniku Q
def bbq_restaurant():
    """Yakiniku Q, the barbecue restaurant where Team 10 eats: two storeys of dark wood and red, a red awning and banners,
    booths inside each with a grill in the middle of the table and cushioned benches."""
    W, D = 17, 15
    b = Build(W, 18, D)
    x1, z1, x2, z2 = 1, 1, 15, 11
    b.fill(x1, 0, z1, x2, G - 1, z2, 'stone_bricks')
    WOOD = Mix(('dark_oak_planks', 3), ('spruce_planks', 1), salt=138)
    b.box(x1, G, z1, x2, G + 8, z2, WOOD)
    b.fill(x1 + 1, G, z1 + 1, x2 - 1, G + 7, z2 - 1, AIR)
    b.fill(x1 + 1, G - 1, z1 + 1, x2 - 1, G - 1, z2 - 1, 'polished_blackstone_bricks')
    b.fill(x1 + 1, G + 4, z1 + 1, x2 - 1, G + 4, z2 - 1, 'dark_oak_planks')
    for x in range(x1, x2 + 1):
        b.set(x, G + 4, z2, 'red_terracotta'); b.set(x, G + 8, z2, 'red_terracotta')
    for x in range(x1 + 1, x2):
        if x % 3:
            b.set(x, G + 1, z2, 'glass_pane'); b.set(x, G + 2, z2, 'glass_pane')
            b.set(x, G + 6, z2, 'glass_pane')
    m = (x1 + x2) // 2
    b.fill(m - 1, G, z2, m + 1, G + 2, z2, AIR)
    b.door(m - 1, G, z2, 'dark_oak', 'south', 'right'); b.door(m + 1, G, z2, 'dark_oak', 'south', 'left')
    b.set(m, G, z2, AIR); b.set(m, G + 1, z2, AIR)
    for x in range(x1 - 1, x2 + 2):
        b.set(x, G + 3, z2 + 1, stairs('mangrove_stairs', 'north'))
        b.set(x, G + 8, z2 + 1, stairs('mangrove_stairs', 'north'))
    for x in (x1 + 1, x1 + 3, x2 - 3, x2 - 1):
        b.banner(x, G + 7, z2 + 1, 'south', 'red', [('circle', 'white'), ('border', 'black')])
    b.fill(x1, G + 9, z1, x2, G + 9, z2, 'dark_oak_planks')
    b.gable(x1, z1, x2, z2, G + 9, TILE, slab(TILE_SLAB), axis='x', over=1, eave=TILE, gable_wall=WOOD)
    # booths: a table with a grill in the middle, cushioned benches either side
    for y0 in (G, G + 5):
        for x in (x1 + 3, x1 + 8, x1 + 12):
            if y0 == G and abs(x - m) < 2:
                continue
            for z in (z1 + 3, z1 + 7):
                b.set(x, y0, z, 'polished_blackstone'); b.set(x + 1, y0, z, 'polished_blackstone')
                b.set(x, y0 + 1, z, st('iron_trapdoor', facing='north', half='bottom', open=False, powered=False, waterlogged=False))
                for zz in (z - 1, z + 1):
                    for xx in (x, x + 1):
                        b.set(xx, y0, zz, slab('dark_oak_slab'))
                        b.cushion(xx, y0, zz, 'red')
        b.set(m, y0 + 3, z1 + 5, st('lantern', hanging=True, waterlogged=False))
    for i in range(4):
        b.set(x2 - 1, G + i, z1 + 1 + i, stairs('spruce_stairs', 'south'))
        b.set(x2 - 1, G + 4, z1 + 1 + i, AIR)
    return b


# ---------------------------------------------------------------- the hot springs
def hot_springs():
    """The hot springs: a bathhouse with a red and a blue noren over its two entrances, behind it two outdoor pools edged
    with rocks and divided by a bamboo fence, stone lanterns, trees."""
    W, D = 40, 36
    b = Build(W, 20, D)
    ground(b, 0, 0, W - 1, D - 1, 139, grass=0.85)
    trad_house(b, 6, D - 13, 28, 9, 'south', seed=6, big=True)
    # doors out the back of the bathhouse to each pool, stepping stones down to the water
    for x in (11, 28):
        b.door(x, G, D - 13, 'spruce', 'north', 'left')
        for z in range(D - 15, 17, -1):
            b.set(x, G - 1, z, 'smooth_stone')
            b.set(x, G, z, AIR)
    # the two entrances' noren
    for x in (14, 25):
        b.door(x, G, D - 5, 'spruce', 'south', 'left')
    for x in range(12, 17):
        b.banner(x, G + 3, D - 4, 'south', 'red', [('stripe_bottom', 'white')])
    for x in range(23, 28):
        b.banner(x, G + 3, D - 4, 'south', 'blue', [('stripe_bottom', 'white')])
    # the pools
    for (cx, cz, rx, rz) in ((11, 11, 8.5, 6.5), (28, 11, 8.5, 6.5)):
        for x in range(int(cx - rx) - 2, int(cx + rx) + 3):
            for z in range(int(cz - rz) - 2, int(cz + rz) + 3):
                e = ((x - cx) / rx) ** 2 + ((z - cz) / rz) ** 2
                if e <= 1:
                    b.set(x, G - 1, z, 'water'); b.set(x, G - 2, z, 'water'); b.set(x, G - 3, z, 'smooth_stone')
                elif e <= 1.45:
                    v = _hash(x, 0, z, 140)
                    b.set(x, G - 1, z, 'mossy_cobblestone' if v < 0.4 else 'stone')
                    if v > 0.75:
                        b.set(x, G, z, 'cobblestone' if v < 0.9 else 'mossy_cobblestone')
    # the bamboo fence between them, and round the back
    for z in range(1, D - 13):
        b.fill(19, G, z, 20, G + 3, z, 'bamboo_block[axis=y]')
    for x in range(0, W):
        b.fill(x, G, 0, x, G + 3, 0, 'bamboo_block[axis=y]')
    for z in range(0, D - 12):
        b.fill(0, G, z, 0, G + 3, z, 'bamboo_block[axis=y]'); b.fill(W - 1, G, z, W - 1, G + 3, z, 'bamboo_block[axis=y]')
    # and in to the bathhouse's sides, so the baths are closed all round
    for x in list(range(0, 6)) + list(range(34, W)):
        b.fill(x, G, D - 12, x, G + 3, D - 12, 'bamboo_block[axis=y]')
    for (x, z) in ((3, 3), (16, 18), (23, 18), (36, 3)):
        stone_lantern(b, x, z)
    tree(b, 4, G, 20, height=5, r=3, trunk='cherry_log', leaves=st('cherry_leaves', distance=1, persistent=True, waterlogged=False))
    tree(b, 35, G, 20, height=5, r=3)
    path(b, 13, D - 3, 15, D - 1, 'gravel'); path(b, 24, D - 3, 26, D - 1, 'gravel')
    return b


# ---------------------------------------------------------------- the Yamanaka flower shop
def flower_shop():
    """The Yamanaka flower shop, Ino's family's: a small two-storey shop, its front open onto buckets and shelves of
    flowers, a striped awning, the family upstairs."""
    W, D = 13, 13
    b = Build(W, 16, D)
    x1, z1, x2, z2 = 1, 1, 11, 8
    b.fill(x1, 0, z1, x2, G - 1, z2 + 3, 'stone_bricks')
    WALL = Mix(('white_terracotta', 3), ('pink_terracotta', 1), salt=141)
    b.box(x1, G, z1, x2, G + 8, z2, WALL)
    b.fill(x1 + 1, G, z1 + 1, x2 - 1, G + 7, z2 - 1, AIR)
    b.fill(x1 + 1, G - 1, z1 + 1, x2 - 1, G - 1, z2 - 1, 'birch_planks')
    b.fill(x1 + 1, G + 4, z1 + 1, x2 - 1, G + 4, z2 - 1, 'birch_planks')
    b.fill(x1 + 1, G, z2, x2 - 1, G + 2, z2, AIR)
    for x in range(x1 - 1, x2 + 2):
        b.set(x, G + 3, z2 + 1, st('%s_wool' % ('pink' if x % 2 else 'white')))
        b.set(x, G + 3, z2 + 2, st('%s_carpet' % ('pink' if x % 2 else 'white')))
    flowers = ['potted_red_tulip', 'potted_pink_tulip', 'potted_oxeye_daisy', 'potted_allium', 'potted_blue_orchid',
               'potted_cornflower', 'potted_lily_of_the_valley', 'potted_poppy', 'potted_orange_tulip']
    for i, x in enumerate(range(x1 + 1, x2)):
        b.set(x, G, z2 + 1, slab('birch_slab', 'top'))
        b.set(x, G + 1, z2 + 1, flowers[i % len(flowers)])
        b.set(x, G, z1 + 1, slab('birch_slab', 'top')); b.set(x, G + 1, z1 + 1, flowers[(i + 3) % len(flowers)])
        b.set(x, G + 2, z1 + 1, slab('birch_slab', 'top')); b.set(x, G + 3, z1 + 1, flowers[(i + 5) % len(flowers)])
    for x in range(x1 + 1, x2, 2):
        b.set(x, G + 6, z2, 'glass_pane'); b.set(x, G + 6, z1, 'glass_pane')
    b.fill(x1, G + 9, z1, x2, G + 9, z2, 'birch_planks')
    b.hip(x1, z1, x2, z2, G + 9, 'mangrove_stairs', 'mangrove_planks', over=1, eave='mangrove_stairs')
    b.set((x1 + x2) // 2, G + 2, (z1 + z2) // 2, st('lantern', hanging=True, waterlogged=False))
    for i in range(4):
        b.set(x2 - 1, G + i, z2 - 2 - i, stairs('birch_stairs', 'north'))
        b.set(x2 - 1, G + 4, z2 - 2 - i, AIR)
    return b


# ---------------------------------------------------------------- groves
def grove(seed=0):
    """A clump of trees and bushes for an empty corner, so the village is not a lawn between the houses."""
    S = 13
    b = Build(S, 14, S)
    for x in range(S):
        for z in range(S):
            if (x - 6) ** 2 + (z - 6) ** 2 <= 40:
                v = _hash(x, seed, z, 142)
                b.set(x, G - 1, z, 'grass_block[snowy=false]' if v < 0.6 else 'podzol[snowy=false]' if v < 0.85 else 'coarse_dirt')
    spots = [(4, 4), (9, 5), (5, 9), (8, 9)][:2 + seed % 3]
    for i, (x, z) in enumerate(spots):
        kind = (seed + i) % 4
        if kind == 3:
            tree(b, x, G, z, height=5, r=3, trunk='cherry_log', leaves=st('cherry_leaves', distance=1, persistent=True, waterlogged=False))
        else:
            tree(b, x, G, z, height=5 + (seed + i) % 3, r=3 if kind else 2,
                 trunk='birch_log' if kind == 2 else 'oak_log', leaves=OAK_LEAVES if kind != 2 else st('birch_leaves', distance=1, persistent=True, waterlogged=False))
    for (x, z) in ((2, 7), (10, 2), (11, 8), (6, 1)):
        if (x * z + seed) % 3:
            b.set(x, G, z, AZALEA if (x + seed) % 2 else st('flowering_azalea_leaves', distance=1, persistent=True, waterlogged=False))
    for (x, z) in ((3, 2), (10, 11), (1, 5)):
        b.set(x, G, z, ['poppy', 'dandelion', 'azure_bluet', 'oxeye_daisy'][(x + z + seed) % 4])
    return b


PIECES = {'uchiha_quarter': uchiha_quarter, 'hyuga_compound': hyuga_compound, 'akimichi_compound': akimichi_compound,
          'nara_forest': nara_forest, 'bbq_restaurant': bbq_restaurant, 'hot_springs': hot_springs,
          'flower_shop': flower_shop}
PIECES.update({'grove_%d' % i: (lambda i=i: grove(i)) for i in range(4)})
