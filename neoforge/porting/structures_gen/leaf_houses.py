"""Leaf homes and shops: one builder, many looks (roof shape and colour, walls, floors, balconies, tanks, signs).

Faces south (+z); y 0..1 is foundation, the ground floor is y = 2."""
import math
from build import Build, Mix, st, stairs, slab, log, AIR, OPP, skirt, inward, _hash
from leaf import G, FLOOR, flight, chair, table, bed, water_tank, wall_banner, lamp_post

# roof colours: (stairs, full block, slab)
ROOFS = {
    'orange': ('acacia_stairs', 'acacia_planks', 'acacia_slab'),
    'red': ('mangrove_stairs', 'mangrove_planks', 'mangrove_slab'),
    'green': ('waxed_oxidized_cut_copper_stairs', 'waxed_oxidized_cut_copper', 'waxed_oxidized_cut_copper_slab'),
    'blue': ('dark_prismarine_stairs', 'dark_prismarine', 'dark_prismarine_slab'),
    'brown': ('dark_oak_stairs', 'dark_oak_planks', 'dark_oak_slab'),
    'copper': ('waxed_cut_copper_stairs', 'waxed_cut_copper', 'waxed_cut_copper_slab'),
    'tan': ('smooth_sandstone_stairs', 'smooth_sandstone', 'smooth_sandstone_slab'),
}
WALLS = {
    'cream': Mix(('smooth_sandstone', 8), ('cut_sandstone', 1), salt=31),
    'white': Mix(('white_concrete', 6), ('calcite', 2), ('white_terracotta', 1), salt=32),
    'peach': Mix(('white_terracotta', 6), ('smooth_sandstone', 1), salt=33),
    'sand': Mix(('sandstone', 3), ('smooth_sandstone', 5), salt=34),
    'pale': Mix(('pale_oak_planks', 5), ('birch_planks', 2), salt=35),
}
BANDS = {'cream': 'terracotta', 'white': 'light_blue_terracotta', 'peach': 'brown_terracotta', 'sand': 'orange_terracotta',
         'pale': 'stripped_dark_oak_log[axis=x]'}


def window(b, x, y, z, facing, h=2, shutters=True, flowers=False):
    """A window in a wall at (x, z): panes, shutters (open trapdoors) either side, a flower box under it."""
    for dy in range(h):
        b.set(x, y + dy, z, 'glass_pane')
    if not shutters:
        return
    dx, dz = {'south': (0, 1), 'north': (0, -1), 'east': (1, 0), 'west': (-1, 0)}[facing]
    left = {'south': (-1, 0), 'north': (1, 0), 'east': (0, -1), 'west': (0, 1)}[facing]
    for side in (1, -1):
        sx, sz = x + left[0] * side + dx, z + left[1] * side + dz
        for dy in range(h):
            if b.get(sx, y + dy, sz) in (None, AIR):
                b.set(sx, y + dy, sz, st('spruce_trapdoor', facing=facing if side == 1 else facing, half='bottom',
                                         open=True, powered=False, waterlogged=False))
    if flowers:
        fx, fz = x + dx, z + dz
        if b.get(fx, y - 1, fz) in (None, AIR):
            b.set(fx, y - 1, fz, st('spruce_trapdoor', facing=OPP[facing], half='top', open=False, powered=False, waterlogged=False))
            b.set(fx, y, fz, 'potted_red_tulip' if (x + z) % 2 else 'potted_azure_bluet')


def house(w=9, d=9, floors=2, walls='cream', roof='orange', kind='hip', seed=0, balcony=False, shop=None, tank=False,
          ac=True, chimney=False):
    """kind: 'hip', 'gable', 'flat' (parapet), 'tiered' (two roofs, the upper smaller), 'dome' (a round top storey)."""
    over = 2
    pad = 3
    W, D = w + 2 * pad, d + 2 * pad + 2
    fh = 4  # storey height
    H = G + floors * fh + 14
    b = Build(W, H, D)
    x1, z1, x2, z2 = pad, pad, pad + w - 1, pad + d - 1
    wall = WALLS[walls]
    band_state = BANDS[walls]
    rs, rf, rsl = ROOFS[roof]
    # foundation and walls
    b.fill(x1, 0, z1, x2, G - 1, z2, 'stone_bricks')
    b.fill(x1 - 1, G - 1, z1 - 1, x2 + 1, G - 1, z2 + 1, Mix(('stone_bricks', 3), ('mossy_stone_bricks', 1), salt=seed))
    top_y = G + floors * fh - 1
    b.box(x1, G, z1, x2, top_y, z2, wall)
    for x, z in ((x1, z1), (x1, z2), (x2, z1), (x2, z2)):
        b.fill(x, G, z, x, top_y, z, log('stripped_dark_oak_log'))
    for f in range(1, floors + 1):
        y = G + f * fh - 1
        for x in range(x1, x2 + 1):
            b.set(x, y, z1, band_state); b.set(x, y, z2, band_state)
        for z in range(z1, z2 + 1):
            b.set(x1, y, z, band_state); b.set(x2, y, z, band_state)
        if f < floors:
            b.fill(x1 + 1, y, z1 + 1, x2 - 1, y, z2 - 1, FLOOR)
    b.fill(x1 + 1, G - 1, z1 + 1, x2 - 1, G - 1, z2 - 1, FLOOR)
    # windows round every floor
    for f in range(floors):
        y = G + f * fh + 1
        for x in range(x1 + 2, x2 - 1, 3):
            if not (f == 0 and abs(x - (x1 + x2) // 2) <= 1):
                window(b, x, y, z2, 'south', flowers=(f > 0 and seed % 2 == 0))
            window(b, x, y, z1, 'north')
        for z in range(z1 + 2, z2 - 1, 3):
            window(b, x1, y, z, 'west')
            window(b, x2, y, z, 'east')
    # the door, a step and an awning
    mx = (x1 + x2) // 2
    b.door(mx, G, z2, 'spruce', 'south')
    b.set(mx, G - 1, z2 + 1, 'polished_andesite')
    for x in range(mx - 1, mx + 2):
        b.set(x, G + 2, z2 + 1, stairs(rs, 'north'))
    b.lantern(mx + 1, G + 1, z2 + 1, hanging=False) if False else None
    # a shop front: a counter window, an awning in cloth, banners as a sign
    if shop:
        for x in range(x1 + 1, mx - 1):
            b.set(x, G + 1, z2, AIR); b.set(x, G, z2, slab('spruce_slab', 'top'))
            b.set(x, G + 1, z2, AIR)
        for x in range(x1, mx):
            b.set(x, G + 2, z2 + 1, st('%s_wool' % shop if x % 2 else 'white_wool'))
            b.set(x, G + 2, z2 + 2, st('%s_carpet' % shop if x % 2 else 'white_carpet'))
        wall_banner(b, mx + 2, G + 2, z2 + 1, 'south', shop)
    # balcony on the upper floor
    if balcony and floors > 1:
        by = G + fh
        b.fill(x1 + 1, by - 1, z2 + 1, x2 - 1, by - 1, z2 + 2, slab('spruce_slab', 'top'))
        for x in range(x1 + 1, x2):
            b.set(x, by, z2 + 2, st('spruce_fence', waterlogged=False))
        b.set(x1 + 1, by, z2 + 1, st('spruce_fence', waterlogged=False)); b.set(x2 - 1, by, z2 + 1, st('spruce_fence', waterlogged=False))
        b.door(mx, by, z2, 'spruce', 'south')
    # air conditioners and pipes on the side wall
    if ac:
        for f in range(floors):
            b.set(x2 + 1, G + f * fh + 2, z1 + 2 + (f * 3) % max(1, d - 4), st('smoker', facing='east', lit=False))
    # roofs
    ry = top_y + 1
    if kind == 'hip':
        b.fill(x1, ry, z1, x2, ry, z2, rf)
        b.hip(x1, z1, x2, z2, ry, rs, rf, over=1, eave=rs)
    elif kind == 'gable':
        b.fill(x1, ry, z1, x2, ry, z2, rf)
        b.gable(x1, z1, x2, z2, ry, rs, slab(rsl), axis='x' if w >= d else 'z', over=1, gable_wall=wall, eave=rs)
    elif kind == 'flat':
        b.fill(x1, ry, z1, x2, ry, z2, slab('smooth_stone_slab', 'double'))
        for x in range(x1, x2 + 1):
            b.set(x, ry + 1, z1, slab(rsl)); b.set(x, ry + 1, z2, slab(rsl))
        for z in range(z1, z2 + 1):
            b.set(x1, ry + 1, z, slab(rsl)); b.set(x2, ry + 1, z, slab(rsl))
        tank = True
    elif kind == 'tiered':
        b.fill(x1, ry, z1, x2, ry, z2, rf)
        b.hip(x1, z1, x2, z2, ry, rs, rf, over=2, eave=rs, layers=3)
        # the upper storey, set back
        ux1, uz1, ux2, uz2 = x1 + 2, z1 + 2, x2 - 2, z2 - 2
        b.box(ux1, ry + 2, uz1, ux2, ry + 5, uz2, wall)
        for x in range(ux1 + 1, ux2, 2):
            b.set(x, ry + 3, uz2, 'glass_pane'); b.set(x, ry + 3, uz1, 'glass_pane')
        b.fill(ux1, ry + 6, uz1, ux2, ry + 6, uz2, rf)
        b.hip(ux1, uz1, ux2, uz2, ry + 6, rs, rf, over=1, eave=rs)
    elif kind == 'dome':
        cx, cz = (x1 + x2) // 2, (z1 + z2) // 2
        r = min(w, d) // 2 - 1
        b.fill(x1, ry, z1, x2, ry, z2, slab('smooth_stone_slab', 'double'))
        b.cylinder(cx, ry + 1, cz, r, ry + 4, wall)
        b.ring(cx, ry + 4, cz, r, band_state)
        for (x, z) in b.ring_points(cx, cz, r):
            if (x + z) % 3 == 0:
                b.set(x, ry + 2, z, 'glass_pane')
        b.cone(cx, ry + 5, cz, r + 1, rs, rf, eave=rs)
    if tank:
        water_tank(b, x2 - 2, ry + 1, z1 + 2)
    if chimney:
        b.fill(x1 + 1, ry, z1 + 1, x1 + 1, ry + 6, z1 + 1, 'bricks')
        b.set(x1 + 1, ry + 7, z1 + 1, 'campfire[facing=north,lit=false,signal_fire=false,waterlogged=false]')
    # inside: a little furniture
    table(b, mx, G, (z1 + z2) // 2)
    chair(b, mx - 1, G, (z1 + z2) // 2, 'east'); chair(b, mx + 1, G, (z1 + z2) // 2, 'west')
    b.set(x2 - 1, G, z1 + 1, st('barrel', facing='up', open=False))
    b.set(x2 - 2, G, z1 + 1, st('furnace', facing='south', lit=False))
    for f in range(floors - 1):
        for y in range(G + f * fh, G + (f + 1) * fh):
            b.set(x1 + 1, y, z1 + 1, st('ladder', facing='south', waterlogged=False))
        b.set(x1 + 1, G + (f + 1) * fh - 1, z1 + 1, st('ladder', facing='south', waterlogged=False))
    if floors > 1:
        bed(b, x2 - 1, G + fh, z1 + 2, 'north', ['red', 'blue', 'green', 'yellow'][seed % 4])
    for f in range(floors):
        b.lantern(mx, G + f * fh + fh - 2, (z1 + z2) // 2 - 1, hanging=True)
    return b


VARIANTS = {
    'house_orange_hip': lambda: house(9, 9, 2, 'cream', 'orange', 'hip', seed=1, balcony=True),
    'house_blue_tiered': lambda: house(11, 9, 2, 'white', 'blue', 'tiered', seed=2),
    'house_green_dome': lambda: house(9, 9, 2, 'peach', 'green', 'dome', seed=3),
    'house_red_gable': lambda: house(11, 7, 2, 'sand', 'red', 'gable', seed=4, chimney=True),
    'house_flat_tall': lambda: house(7, 9, 3, 'cream', 'copper', 'flat', seed=5),
    'house_flat_wide': lambda: house(13, 9, 2, 'white', 'red', 'flat', seed=6, balcony=True),
    'shop_orange': lambda: house(11, 9, 2, 'cream', 'orange', 'hip', seed=7, shop='orange'),
    'shop_blue': lambda: house(9, 9, 2, 'peach', 'blue', 'gable', seed=8, shop='light_blue'),
    'house_brown_tiered': lambda: house(9, 11, 1, 'pale', 'brown', 'tiered', seed=9),
}
