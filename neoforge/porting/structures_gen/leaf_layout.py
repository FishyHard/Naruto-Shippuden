"""The Hidden Leaf's layout, after the village map: the Hokage Rock and the mountains close the north; under the Rock the
Hokage residence faces a plaza; the Academy and its training grounds are north-west, the exam stadium west, a lake
south-west; the main street runs from the plaza to the great gate in the south, over the river; the hospital and the
Hyūga quarter are north-east, past the river the Uchiha quarter; Ichiraku stands on the main street. Every house faces
the street it stands on.

layout(sizes, origins) -> {'pieces': [{'piece', 'x', 'z', 'rotation'}], 'roads': [[x1, z1, x2, z2, block]]}: x, z is the
origin to place the template at with that rotation (as /place template takes it); sizes is {piece: (w, h, d)}, origins
{piece: (x, z)} for the pieces that know their own place (the wall's arcs, the mountains, the river)."""
import math
from leaf_ring import CX, CZ, R, GATE_Z, ROCK_X0, ROCK_Z0, river_dist, polar

HOUSES = ['house_orange_hip', 'house_blue_tiered', 'house_red_gable', 'house_flat_tall', 'house_green_dome',
          'shop_orange', 'house_flat_wide', 'house_brown_tiered', 'shop_blue']
MAIN = (CX - 3, CX + 3)                # the main street's x range, the bridge's deck width

# streets: x1, z1, x2, z2. Each ends on another street, the plaza or a building's door.
STREETS = [
    (MAIN[0], 169, MAIN[1], GATE_Z + 6),        # the main street, from the plaza to the gate
    (140, 156, 260, 168),                       # the plaza before the residence
    (155, 230, 330, 234),                       # avenue A
    (155, 290, 312, 294),                       # avenue B
    (150, 141, 154, 328),                       # the west road
    (64, 170, 149, 173),                        # past the Academy yard and the training ground's path
    (260, 141, 264, 318),                       # the east road
    (232, 141, 259, 144),                       # from the plaza's corner to the hospital
    (265, 141, 320, 144),
    (110, 368, 290, 371),                       # south of the river, along the wall
]
BRIDGES = [(MAIN[0] - 1, 342)]                  # x, z of bridges on the main street


def layout(sizes, origins):
    pieces, roads, taken = [], [], []

    def free(x1, z1, x2, z2, gap=1):
        for (a1, b1, a2, b2) in taken:
            if not (x2 + gap < a1 or x1 - gap > a2 or z2 + gap < b1 or z1 - gap > b2):
                return False
        return True

    def inside(x1, z1, x2, z2, margin=10):
        for (x, z) in ((x1, z1), (x2, z1), (x1, z2), (x2, z2), ((x1 + x2) / 2, (z1 + z2) / 2)):
            r, ang = polar(x, z)
            if r > R - margin or river_dist(x, z) < 7:
                return False
            if r > R - 24 and 190 < ang < 350:
                return False            # under the mountains
        return True

    def put(name, x0, z0, rot='none', block=True):
        w, _, d = sizes[name]
        if rot == 'none':
            ox, oz, fw, fd = x0, z0, w, d
        elif rot == 'counterclockwise_90':
            ox, oz, fw, fd = x0, z0 + w - 1, d, w
        elif rot == 'clockwise_90':
            ox, oz, fw, fd = x0 + d - 1, z0, d, w
        else:
            ox, oz, fw, fd = x0 + w - 1, z0 + d - 1, w, d
        pieces.append({'piece': 'leaf/' + name, 'x': ox, 'z': oz, 'rotation': rot})
        if block:
            taken.append((x0, z0, x0 + fw - 1, z0 + fd - 1))

    def own(name):
        ox, oz = origins[name]
        pieces.append({'piece': 'leaf/' + name, 'x': ox, 'z': oz, 'rotation': 'none'})

    # the land: mountains, the river and the lake, the wall's arcs and the gate
    own('mountain_west'); own('mountain_north'); own('mountain_east'); own('river')
    for i in range(6):
        own('wall_arc_%d' % i)
    gw = sizes['gate'][0]
    put('gate', CX - gw // 2, GATE_Z)
    for s in STREETS:
        roads.append(list(s) + ['path'])
        taken.append(s)
    for (bx, bz) in BRIDGES:
        put('bridge', bx, bz)

    # the landmarks
    put('hokage_rock', ROCK_X0, ROCK_Z0)
    put('hokage_tower', CX - 30, 92)
    put('academy', 92, 104)
    put('academy_yard', 92, 139)
    put('training_ground', 48, 128)
    put('exam_stadium', 43, 181)
    put('hospital', 270, 110)
    put('water_tower', 155, 118)
    put('water_tower', 233, 118)
    put('ramen_shop', MAIN[0] - sizes['ramen_shop'][2] - 1, 262, 'counterclockwise_90')
    # the quarters and the places between missions
    put('hyuga_compound', 290, 150, '180')              # its gate north, onto the road past the hospital
    put('uchiha_quarter', 268, 238, '180')              # its gate north, onto avenue A
    put('akimichi_compound', 210, 238, '180')
    put('bbq_restaurant', 208, 272)                     # Yakiniku Q, on avenue B
    put('hot_springs', 212, 298, '180')
    put('flower_shop', MAIN[0] - 14, 300, 'counterclockwise_90')
    put('nara_forest', 100, 298)

    # houses along every street, facing it, wherever there is room
    k = [0]

    def line(x1, z1, x2, z2):
        horizontal = x2 - x1 > z2 - z1
        for side in (-1, 1):
            pos = x1 if horizontal else z1
            end = x2 if horizontal else z2
            while pos < end:
                name = HOUSES[(k[0] * 4 + 1) % len(HOUSES)]
                k[0] += 1
                w, _, d = sizes[name]
                if horizontal:
                    fw, fd = w, d
                    zz = z1 - fd - 1 if side < 0 else z2 + 2
                    rect = (pos, zz, pos + fw - 1, zz + fd - 1)
                    rot = 'none' if side < 0 else '180'
                else:
                    fw, fd = d, w
                    xx = x1 - fw - 1 if side < 0 else x2 + 2
                    rect = (xx, pos, xx + fw - 1, pos + fd - 1)
                    rot = 'counterclockwise_90' if side < 0 else 'clockwise_90'
                length = fw if horizontal else fd
                if rect[2 if horizontal else 3] <= end and free(*rect) and inside(*rect):
                    put(name, rect[0], rect[1], rot)
                    pos += length + 1
                else:
                    pos += 3

    for s in STREETS:
        line(*s)

    # groves in the open ground left over, so the village is not a lawn between the houses
    g = 0
    for gz in range(100, 400, 5):
        for gx in range(10, 400, 5):
            rect = (gx, gz, gx + 12, gz + 12)
            if free(*rect, gap=1) and inside(*rect, margin=8):
                put('grove_%d' % (g % 4), gx, gz)
                g += 1
    return {'pieces': pieces, 'roads': roads}
