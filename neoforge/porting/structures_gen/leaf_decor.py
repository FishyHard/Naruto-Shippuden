"""The Hidden Leaf's greenery and street furniture, made from the finished layout: lamps along every street, trees and
bushes over the open ground, flowers, tall grass and worn patches, never on a building, a street or the water.

decor(layout) -> a Build with .origin, to place like any other piece."""
import math
from build import Build, st, AIR, _hash
from leaf import G, tree, lamp_post
from leaf_ring import CX, CZ, R, river_dist, polar

LEAVES = {
    'oak': st('oak_leaves', distance=1, persistent=True, waterlogged=False),
    'birch': st('birch_leaves', distance=1, persistent=True, waterlogged=False),
    'cherry': st('cherry_leaves', distance=1, persistent=True, waterlogged=False),
    'dark_oak': st('dark_oak_leaves', distance=1, persistent=True, waterlogged=False),
}
FLOWERS = ['poppy', 'dandelion', 'azure_bluet', 'oxeye_daisy', 'cornflower', 'red_tulip', 'white_tulip', 'allium']


def decor(lay):
    x1, z1, x2, z2 = CX - R, 96, CX + R, CZ + R
    b = Build(x2 - x1 + 1, G + 14, z2 - z1 + 1)
    rects = [tuple(r) for r in lay['taken']]
    streets = [tuple(r[:4]) for r in lay['roads']]

    # a coarse grid of what is in the way, for quick distance checks
    near = {}
    def mark(r, kind):
        for x in range(r[0], r[2] + 1):
            for z in range(r[1], r[3] + 1):
                near[(x, z)] = kind
    for r in rects:
        mark(r, 'b')
    for r in streets:
        mark(r, 's')

    def clear(x, z, d):
        """Nothing built, no street, no water, within d of (x, z), and inside the village."""
        r, ang = polar(x, z)
        if r > R - 7 or (r > R - 16 and 186 <= ang <= 354) or z < 100:
            return False
        if river_dist(x, z) < d + 4.5:
            return False
        for dx in range(-d, d + 1):
            for dz in range(-d, d + 1):
                if (x + dx, z + dz) in near:
                    return False
        return True

    def L(x, z):
        return x - x1, z - z1

    # lamps along both sides of every street, every 12 blocks
    for (sx1, sz1, sx2, sz2) in streets:
        horizontal = sx2 - sx1 > sz2 - sz1
        for t in range(0, (sx2 - sx1 if horizontal else sz2 - sz1) + 1, 12):
            for side in (-1, 1):
                if horizontal:
                    x, z = sx1 + t, (sz1 - 1 if side < 0 else sz2 + 1)
                else:
                    x, z = (sx1 - 1 if side < 0 else sx2 + 1), sz1 + t
                r, _ = polar(x, z)
                if (x, z) not in near and r < R - 6 and river_dist(x, z) > 6:
                    lx, lz = L(x, z)
                    lamp_post(b, lx, G, lz)
                    near[(x, z)] = 'l'

    # trees and bushes on a jittered grid over the open ground
    for gz in range(z1, z2, 6):
        for gx in range(x1, x2, 6):
            x = gx + int(_hash(gx, 0, gz, 151) * 5)
            z = gz + int(_hash(gx, 1, gz, 152) * 5)
            v = _hash(x, 2, z, 153)
            if v < 0.62 and clear(x, z, 4):
                kind = ['oak', 'oak', 'birch', 'cherry', 'dark_oak'][int(_hash(x, 3, z, 154) * 5)]
                lx, lz = L(x, z)
                if tree(b, lx, G, lz, height=4 + int(_hash(x, 4, z, 155) * 3), r=2 + int(_hash(x, 5, z, 156) * 2),
                        trunk=kind + '_log', leaves=LEAVES[kind]):
                    for dx in range(-2, 3):
                        for dz in range(-2, 3):
                            if dx * dx + dz * dz <= 5 and _hash(x + dx, 6, z + dz, 157) < 0.5:
                                b.set(lx + dx, G - 1, lz + dz, 'podzol[snowy=false]' if kind == 'dark_oak' else 'coarse_dirt')
                    for dx in range(-3, 4):
                        for dz in range(-3, 4):
                            near.setdefault((x + dx, z + dz), 't')
            elif v < 0.85 and clear(x, z, 2):
                lx, lz = L(x, z)
                bush = st('azalea_leaves' if v < 0.75 else 'flowering_azalea_leaves', distance=1, persistent=True, waterlogged=False)
                for (dx, dz) in ((0, 0), (1, 0), (0, 1)):
                    b.set(lx + dx, G, lz + dz, bush)
                b.set(lx, G + 1, lz, bush)
                near[(x, z)] = 'u'

    # flowers, tall grass and worn earth on the open ground that is left
    for x in range(x1, x2 + 1):
        for z in range(z1, z2 + 1):
            if (x, z) in near:
                continue
            r, ang = polar(x, z)
            if r > R - 5 or (r > R - 14 and 186 <= ang <= 354) or z < 100 or river_dist(x, z) < 6:
                continue
            v = _hash(x, 7, z, 158)
            lx, lz = L(x, z)
            # flowers grow in patches, not evenly
            patch = _hash(x // 5, 8, z // 5, 159)
            if patch > 0.7 and v < 0.35:
                b.set(lx, G, lz, FLOWERS[int(_hash(x // 5, 9, z // 5, 160) * len(FLOWERS))])
            elif v < 0.12:
                b.set(lx, G, lz, 'short_grass')
            elif v < 0.14:
                b.set(lx, G, lz, st('tall_grass', half='lower')); b.set(lx, G + 1, lz, st('tall_grass', half='upper'))
            elif v > 0.985:
                b.set(lx, G - 1, lz, 'coarse_dirt')
    b.origin = (x1, z1)
    return b
