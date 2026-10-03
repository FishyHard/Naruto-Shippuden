"""Sasuke's Susanoo, cleaned up from the user's Blockbench files (porting/susanoo_src/*.bbmodel) into rigged ones
(porting/susanoo_src/sasuke/*.bbmodel, which open in Blockbench too) that susanoo_convert.py makes into the mod's models.

What the user's files had wrong, and what this does about it:
  * groups named bone, bone2..., the arms and legs swapped left for right, a wing in both wing groups, the Skeleton's arms
    inside its body, helper groups (Body_r1...) that only carry a turn, pivots far from the joints they should turn at.
    Every cube is baked into the world (its groups' turns folded into its own), then put in one of a few groups named for
    what they move (body, head, right_arm, left_arm, right_leg, left_leg, right_wing, left_wing, weapon, shield), each with its
    pivot on the joint: shoulder, neck, hip, the wing's root.
  * faces of two cubes lying in one plane flicker in game (z-fighting): the smaller of the two is pushed out a little.
  * flat cubes (no thickness) are given some.
  * the Humanoid's back was one flat slab: it gets a spine, shoulder blades and ribs; the Armoured one gets back its shield,
    remade larger and as a solid disc (the user disliked the old wheel of wedges).

Blockbench's frame: y up, -z the front, +x the model's right.

`python3 sasuke_rig.py [preview_dir]` writes the rigged files (and pictures of them from four sides into preview_dir)."""
import copy
import json
import math
import os
import sys

HERE = os.path.dirname(os.path.abspath(__file__))
SRC = os.path.normpath(os.path.join(HERE, '..', 'susanoo_src'))
OUT = os.path.join(SRC, 'sasuke')

PARTS = ('body', 'head', 'right_arm', 'left_arm', 'right_leg', 'left_leg', 'right_wing', 'left_wing', 'weapon', 'shield', 'ring0', 'ring1',
         'ring2', 'ring3', 'ring4')
PARENT = {'head': 'body', 'right_arm': 'body', 'left_arm': 'body', 'right_wing': 'body', 'left_wing': 'body', 'weapon': 'left_arm',
          'shield': 'left_arm', 'body': None, 'right_leg': None, 'left_leg': None, 'ring0': 'body', 'ring1': 'body', 'ring2': 'body',
          'ring3': 'body', 'ring4': 'body'}


# ------------------------------------------------------------------ rotations (Blockbench and Minecraft: R = Rz Ry Rx)
def mat(angles):
    ax, ay, az = (math.radians(a) for a in angles)
    cx, sx, cy, sy, cz, sz = math.cos(ax), math.sin(ax), math.cos(ay), math.sin(ay), math.cos(az), math.sin(az)
    rx = [[1, 0, 0], [0, cx, -sx], [0, sx, cx]]
    ry = [[cy, 0, sy], [0, 1, 0], [-sy, 0, cy]]
    rz = [[cz, -sz, 0], [sz, cz, 0], [0, 0, 1]]
    return mul(rz, mul(ry, rx))


def mul(a, b):
    return [[sum(a[i][k] * b[k][j] for k in range(3)) for j in range(3)] for i in range(3)]


def app(m, v):
    return [sum(m[i][k] * v[k] for k in range(3)) for i in range(3)]


def angles(m):
    """The Blockbench euler angles of a rotation matrix (m = Rz Ry Rx)."""
    sy = max(-1.0, min(1.0, -m[2][0]))
    ay = math.asin(sy)
    if abs(sy) < 0.99999:
        ax = math.atan2(m[2][1], m[2][2])
        az = math.atan2(m[1][0], m[0][0])
    else:
        ax = math.atan2(sy * m[0][1], m[1][1])
        az = 0.0
    out = [math.degrees(a) for a in (ax, ay, az)]
    return [0.0 if abs(a) < 1e-4 else round(a, 4) for a in out]


IDENTITY = [[1, 0, 0], [0, 1, 0], [0, 0, 1]]


class Cube:
    """A cube in the world: its size, centre and turn (about its centre)."""

    def __init__(self, size, centre, m=IDENTITY, src=None, inflate=0.0, mat_=None, tag=None):
        self.size, self.centre, self.m, self.src, self.inflate, self.mat, self.tag = list(size), list(centre), m, src, inflate, mat_, tag
        self.part = None
        self.tip = None
        self.disc = None
        self.ring = False
        self.column = False
        self.knob = False
        self.plates2d = None

    def corners(self):
        hx, hy, hz = (s / 2 + self.inflate for s in self.size)
        out = []
        for x in (-hx, hx):
            for y in (-hy, hy):
                for z in (-hz, hz):
                    p = app(self.m, [x, y, z])
                    out.append([p[i] + self.centre[i] for i in range(3)])
        return out

    def bounds(self):
        c = self.corners()
        return [min(p[i] for p in c) for i in range(3)], [max(p[i] for p in c) for i in range(3)]


def baked(path):
    """The cubes of a Blockbench file in the world, each with the group path it came from (and 'eye' where the user's
    texture paints it yellow)."""
    from susanoo_convert import is_eye, load
    d, tex = load(os.path.basename(path)[:-len('.bbmodel')])
    els = {e['uuid']: e for e in d['elements']}
    out = []

    def walk(node, chain, names):
        if isinstance(node, str):
            e = els.get(node)
            if not e or e.get('type', 'cube') != 'cube' or e.get('visibility', True) is False:
                return
            f, t = e['from'], e['to']
            size = [t[i] - f[i] for i in range(3)]
            centre = [(f[i] + t[i]) / 2 for i in range(3)]
            m = IDENTITY
            # the cube's own turn, then each group's, outermost last
            steps = [(e.get('origin', [0, 0, 0]), e.get('rotation', [0, 0, 0]) or [0, 0, 0])] + list(reversed(chain))
            for o, r in steps:
                if any(r):
                    rm = mat(r)
                    centre = [v + o[i] for i, v in enumerate(app(rm, [centre[i] - o[i] for i in range(3)]))]
                    m = mul(rm, m)
            out.append(Cube(size, centre, m, '/'.join(names), e.get('inflate', 0), 'eye' if is_eye(e, tex) else None))
            return
        chain2 = chain + [(node.get('origin', [0, 0, 0]), node.get('rotation', [0, 0, 0]) or [0, 0, 0])]
        for ch in node.get('children', []):
            walk(ch, chain2, names + [node['name']])
    for n in d['outliner']:
        walk(n, [], [])
    return out


# ------------------------------------------------------------------ each model's parts
def group_of(c, depth=1):
    parts = c.src.split('/')
    return parts[depth] if len(parts) > depth else parts[-1]


def centre(c):
    lo, hi = c.bounds()
    return [(lo[i] + hi[i]) / 2 for i in range(3)]


# the Ribcage's rings, bottom to top: (height of the band's middle, its radius); an egg, widest a little below the middle
RINGS = ((3.5, 11.5), (9.5, 14.0), (15.5, 15.0), (21.5, 14.5), (27.5, 12.5))
RING_H, RING_T, RING_GAP = 3.6, 1.3, 30                   # band height, thickness, half the opening at the front (degrees)


def assign_ribcage(cs):
    """Stage 1, made anew after the anime: no bones of the user's model, only bands of chakra (ribcage())."""
    for c in cs:
        c.part = None
    return {'body': [0, 0, 1], **{'ring%d' % i: [0, y, 1] for i, (y, r) in enumerate(SKELETON_RINGS)}}


def turned_box(part, cx, cy, cz, w, h, d, yaw, mat_, tag):
    """A box turned about the vertical by yaw degrees (about its own middle)."""
    c = Cube([w, h, d], [cx, cy, cz], mat([0, yaw, 0]), 'added', 0, mat_, tag)
    c.part = part
    return c


def bands(rings, zc, height, thick, gap, part_of, n=20, roll=2.6):
    """Flat bands of chakra wrapped round a middle (x 0, z zc): panels round each circle as wide as its chord at the
    outside (no gaps), the front left open where the two ends roll outward like a scroll. rings: (height, radius) each."""
    out = []
    for i, (y, r) in enumerate(rings):
        part = part_of(i)
        step = 360.0 / n
        # as wide as the circle's chord on its inside: neighbouring panels then never overlap (overlaps were pushed apart
        # by the flicker fix one side at a time, which left one side of a ring thicker than the other)
        chord = 2 * (r - thick / 2) * math.tan(math.radians(step / 2)) + 0.05
        for j in range(n):
            ang = j * step + step / 2                     # 0 is the back (+z), going round through the right (+x)
            off = min(abs(ang - 180), 360 - abs(ang - 180))
            if off < gap:
                continue
            a = math.radians(ang)
            out.append(turned_box(part, math.sin(a) * r, y, zc + math.cos(a) * r, chord, height, thick, ang, 'band', 'band'))
            out[-1].ring = True                           # painted rimmed along its top and bottom, whatever its proportions
        # (the band just ends there, rimmed like the rest of its outline: the user disliked the blocks rolled at its ends)
    return out


def ribcage():
    """Stage 1, the way the anime and the games draw it: five flat bands of chakra wrapped round its user one above another,
    an egg (narrower at the top and the bottom), each open at the front where its two ends curl outward like a scroll; a
    spine down the back holding them."""
    # the Skeleton's own bands (the user liked them there): the same rings, band and rolls, round the user
    zc = 1.0
    out = bands(SKELETON_RINGS, zc, 5.0, 1.6, 30, lambda i: 'ring%d' % i, n=22, roll=3.2)
    # the spine behind, joining the bands where they pass at the back
    path = [(y, zc + r + 0.8 + 2.2) for y, r in SKELETON_RINGS]
    out += spine([(SKELETON_RINGS[0][0] - 2.5, path[0][1])] + path, 1.0, 'body')   # its foot level with the bottom band's
    return out


def assign_skeleton(cs):
    for c in cs:
        x, y, z = centre(c)
        if 'hexadecagon' in c.src:
            c.part = None                                   # the old round spine: a new one is built (spine())
        elif 'Head' in c.src:
            c.part = 'head'
        elif abs(x) > 20 and y < 41.5:
            c.part = 'right_arm' if x > 0 else 'left_arm'
        elif y < 41:
            c.part = None                                   # the ribs: bands like the Ribcage stage's instead (skeleton_ribs())
        else:
            c.part = 'body'
    return {'body': [0, -16, 0], 'head': [0, 52, 2], 'right_arm': [26, 42, 4.6], 'left_arm': [-26, 42, 4.6]}


SKELETON_RINGS = ((6, 13.5), (14, 16.5), (22, 18.0), (30, 17.5), (38, 15.5))


def skeleton_ribs():
    """The Skeleton's ribs drawn the way the Ribcage stage draws them (the user's wish): bands round its middle, bigger, with
    the spine behind them running on up its neck to the skull."""
    zc = -3.0
    out = bands(SKELETON_RINGS, zc, 5.0, 1.6, 30, lambda i: 'body', n=22, roll=3.2)
    back = [(y, zc + r + 0.8 + 2.2) for y, r in SKELETON_RINGS]
    out += spine([(-12, back[0][1] - 2)] + back + [(46, back[-1][1] - 1), (54, 10), (61, 4)], 1.0, 'body')
    return out


def assign_humanoid(cs):
    for c in cs:
        g = group_of(c)
        c.part = {'head': None, 'Body': 'body', 'LeftHand': 'left_arm', 'RightHand': 'right_arm'}.get(g, 'body')
        if 'Weapon' in c.src:
            c.part = 'right_arm'
    return {'body': [0, 0, 16], 'head': [0, 70, 14], 'right_arm': [32, 66, 16], 'left_arm': [-32, 66, 16]}


def assign_armoured(cs):
    for c in cs:
        g = group_of(c)
        x, y, z = centre(c)
        if g == 'bone':
            c.part = 'right_arm'
        elif g == 'bone3':
            c.part = 'left_arm'
        elif g == 'hexadecagon':
            c.part = None                                   # the old wheel: remade below
        else:
            c.part = 'body'
    return {'body': [0, 0, 0], 'head': [0, 60, 0], 'right_arm': [30, 50, -2], 'left_arm': [-30, 50, -2]}


def assign_complete(cs, pose):
    for c in cs:
        g = group_of(c, 0)
        x, y, z = centre(c)
        c.part = {'bone6': 'head', 'bone3': 'body', 'bone4': 'left_arm', 'bone5': 'right_arm', 'bone': 'left_leg', 'bone2': 'right_leg',
                  'bone9': 'weapon'}.get(g)
        if g in ('bone7', 'bone8'):
            c.part = 'right_wing' if x > 0 else 'left_wing'
    if pose == 'fly':
        piv = {'body': [0, 30, 0], 'head': [0, 30, -38], 'right_arm': [26, 30, -30], 'left_arm': [-26, 30, -30], 'right_leg': [11, 28, 42],
               'left_leg': [-11, 28, 42], 'weapon': [-24, 30, -30]}
    else:
        piv = {'body': [0, 76, 20], 'head': [0, 160, 20], 'right_arm': [28, 150, 22], 'left_arm': [-28, 150, 22], 'right_leg': [11, 78, 11],
               'left_leg': [-11, 78, 11], 'weapon': [-24, 70, 0]}
    for w in ('right_wing', 'left_wing'):
        piv[w] = wing_root(cs, w)
    merge_plates(cs, ('right_arm', 'left_arm'))
    return piv


def merge_plates(cs, parts):
    """The Complete's shoulder plates: two thin plates tilted opposite ways into a little ridge, overlapping along its peak
    (a doubled strip there). One flat plate instead, turned only about z like them, covering both."""
    for part in parts:
        thin = [c for c in cs if c.part == part and min(c.size) <= 2.5 and max(c.size) >= 15]
        used = set()
        for i, a in enumerate(thin):
            for j, b in enumerate(thin):
                if j <= i or i in used or j in used:
                    continue
                if any(abs(a.centre[k] - b.centre[k]) > 0.5 for k in (0, 1)) or abs(a.centre[2] - b.centre[2]) > max(a.size) or \
                        any(abs(sorted(a.size)[k] - sorted(b.size)[k]) > 0.3 for k in range(3)):
                    continue
                ang = math.degrees(math.atan2(a.m[1][0], a.m[0][0]))
                lo_z = min(a.bounds()[0][2], b.bounds()[0][2])
                hi_z = max(a.bounds()[1][2], b.bounds()[1][2])
                a.m = mat([0, 0, ang])
                a.centre = [(a.centre[0] + b.centre[0]) / 2, (a.centre[1] + b.centre[1]) / 2, (lo_z + hi_z) / 2]
                a.size = [a.size[0], a.size[1], hi_z - lo_z]
                b.part = None
                used.update((i, j))


# ------------------------------------------------------------------ materials (what the painter in susanoo_convert.py draws)
def turned(c):
    return any(abs(c.m[i][j] - (1 if i == j else 0)) > 1e-3 for i in range(3) for j in range(3))


def spike(c):
    """A small turned cube: a lock of the flame hair."""
    return turned(c) and max(c.size) < 16


def mats_bone(c):
    """Ribcage and Skeleton: everything in the bands' style and colour (the user's wish): long pieces are bands, chunky
    ones (joints, knuckles, the skull's blocks) are rolls."""
    long_side = max(c.size)
    short = sorted(c.size)[1]
    return 'band' if long_side >= 2.2 * short else 'roll'


def mats_humanoid(c):
    """The Humanoid in the Skeleton's style (the user's wish): bands and rolls, the bow and arrow light, the crown flame;
    its big body plates soft flesh."""
    if c.part == 'head' and spike(c) and c.bounds()[0][1] > 74:
        return 'flame'
    if c.part in ('right_arm', 'left_arm') and min(c.size) < 2.5:
        return 'bright'                                     # the bow, its string, the arrow
    if c.part == 'body' and min(c.size) >= 6 and max(c.size) >= 20:
        return 'flesh'
    return mats_bone(c)


def mats_armoured(c):
    # the user's Amaterasu: the flame held up in the right hand (its base block and its tongues), black
    if c.part == 'right_arm':
        (x0, y0, z0), (x1, y1, z1) = c.bounds()
        if z0 > -49.5 and z1 < -32.5 and y0 >= 15:
            c.tip = [1, 1]
            return 'black'
    if c.part == 'body' and spike(c) and c.bounds()[0][1] >= 40:
        return 'flame'
    return 'armor'


def mats_complete(c):
    if c.part in ('right_wing', 'left_wing'):
        return 'feather'
    if c.part == 'weapon' or (c.part == 'right_arm' and sorted(c.size)[1] < 2.5 and max(c.size) > 20):   # a string, not a plate
        return 'bright'
    if c.part == 'head' and spike(c):
        return 'flame'
    return 'armor'


def tips(cs):
    """Which end of each lock of flame and each feather is its tip (painted lightest): along its longest side, the end that
    points away from the middle of its part (and, for flame, upward)."""
    mids = {}
    for c in cs:
        mids.setdefault(c.part, []).append(c.centre)
    mids = {k: [sum(p[i] for p in v) / len(v) for i in range(3)] for k, v in mids.items()}
    for c in cs:
        if c.mat not in ('flame', 'feather'):
            continue
        a = max(range(3), key=lambda i: c.size[i])
        d = [c.m[i][a] for i in range(3)]
        out = [c.centre[i] - mids[c.part][i] for i in range(3)]
        lo = math.sqrt(sum(v * v for v in out)) or 1
        score = sum(d[i] * out[i] / lo for i in range(3)) + (0.6 * d[1] if c.mat == 'flame' else -0.3 * d[1])
        c.tip = [a, 1 if score >= 0 else -1]


# ------------------------------------------------------------------ additions
def box(part, lo, hi, mat_=None, tag=None):
    size = [hi[i] - lo[i] for i in range(3)]
    c = Cube(size, [(lo[i] + hi[i]) / 2 for i in range(3)], IDENTITY, 'added', 0, mat_, tag)
    c.part = part
    return c


def humanoid_trunk(cs):
    """The Humanoid's torso made one piece (the user's wish: connected, open, one body): the outline its trunk and the plates
    fanning out to the shoulders make together, seen from the front, filled with rows two pixels tall (like the shield), as
    deep as the trunk. No plate crosses another inside it, and its one rim runs round the outside."""
    big = [c for c in cs if c.part == 'body' and not turned(c) and c.size[0] * c.size[1] * c.size[2] > 20000]
    if not big:
        return []
    lo = [min(c.bounds()[0][k] for c in big) for k in range(3)]
    hi = [max(c.bounds()[1][k] for c in big) for k in range(3)]
    # every body piece facing the front (turned about z only, or not at all) and of some size: the slabs, the plates fanning
    # out to the shoulders, the collar, the small pieces at the shoulders
    plates = [c for c in cs if c.part == 'body' and abs(c.m[2][2]) > 0.999 and c.size[0] * c.size[1] * c.size[2] > 400
              and not (min(c.size) <= 3.5 and c.size[1] >= 40)]

    def covered(x, y):
        for c in plates:
            q = app([[c.m[j][i] for j in range(3)] for i in range(3)], [x - c.centre[0], y - c.centre[1], 0])
            if abs(q[0]) <= c.size[0] / 2 and abs(q[1]) <= c.size[1] / 2:
                return True
        return False
    ys = [p for c in plates for p in (c.bounds()[0][1], c.bounds()[1][1])]
    xs = [p for c in plates for p in (c.bounds()[0][0], c.bounds()[1][0])]
    y0, y1 = math.floor(min(ys)), math.ceil(max(ys))
    xm = math.ceil(max(abs(v) for v in xs))
    out = []
    step = 2
    # the shoulder line: the highest row still running unbroken across the middle; the spikes' inner side above it
    shoulder = y1
    for y in range(y0, y1, step):
        if not covered(0.5, y + step / 2):
            shoulder = y
            break
    inner = 17
    for y in range(y0, y1, step):
        row = [covered(x + 0.5, y + step / 2) for x in range(-xm, xm)]
        x = 0
        while x < len(row):
            if not row[x]:
                x += 1
                continue
            start = x
            while x < len(row) and row[x]:
                x += 1
            x0, x1 = start - xm, x - xm
            if y >= shoulder:
                # above the shoulders the spikes stand clear of the head: their inner side cut straight (a stepped notch
                # there showed every step's top as a band across the body)
                if x0 < 0 < x1:
                    continue
                if x1 <= 0:
                    x1 = min(x1, -inner)
                else:
                    x0 = max(x0, inner)
                if x1 - x0 < 1:
                    continue
            out.append(box('body', [x0, y, lo[2]], [x1, y + step, hi[2]], 'flesh', 'torso'))
    # the plates it was made of, kept as shading (each glows from its own edges, a darker seam where they meet)
    p2d = []
    for c in plates:
        ang = math.atan2(c.m[1][0], c.m[0][0])
        p2d.append([round(c.centre[0], 3), round(c.centre[1], 3), round(ang, 5), round(c.size[0], 3), round(c.size[1], 3)])
    for c in out:
        c.plates2d = p2d
    for c in plates:
        c.part = None
    # the long thin rods that held the old slabs (inside them, now poking out of the new torso's front)
    for c in cs:
        if c.part == 'body' and not turned(c) and min(c.size) <= 3.5 and c.size[1] >= 40:
            c.part = None
    return out


def humanoid_back(cs):
    """The Humanoid's back: the old flat slabs a little thinner, over them a spine of vertebrae, two shoulder blades and ribs
    curving round the sides, the way the Skeleton stage's bones show through."""
    out = []                                              # (no spine: the user's call)
    for side in (1, -1):
        # the shoulder blades
        x0, x1 = sorted((side * 4, side * 17))
        out.append(box('body', [x0, 46, 25.5], [x1, 62, 28], 'armor', 'blade'))
        x0, x1 = sorted((side * 6, side * 14))
        out.append(box('body', [x0, 40, 25.5], [x1, 46, 27.5], 'armor', 'blade'))
        # ribs round the back: bars from the spine out to the sides
        for y in (14, 22, 30, 38):
            x0, x1 = sorted((side * 3, side * 15))
            out.append(box('body', [x0, y, 26], [x1, y + 2.5, 27.6], 'bone', 'rib'))
    return out


def armoured_shield():
    """Sasuke's shield, a solid round one on the left forearm: rows of a pixel circle, a raised rim and a boss in the middle."""
    out = []
    cx, cy, z = -62, 38, -54                              # held out on the left forearm, beside the body
    r = 38
    step = 4
    for y in range(-r, r, step):
        yc = y + step / 2
        half = math.sqrt(max(0.0, r * r - yc * yc))
        half = round(half / 2) * 2
        if half < 4:
            continue
        out.append(box('shield', [cx - half, cy + y, z - 3], [cx + half, cy + y + step, z + 3], 'row', 'shield'))
        out[-1].disc = [cx, cy, r]
        # the rim: the row's two ends stand out
        for s in (-1, 1):
            x0, x1 = sorted((cx + s * half, cx + s * (half - 5)))
            out.append(box('shield', [x0, cy + y, z - 5], [x1, cy + y + step, z - 3], 'roll', 'rim'))
    # top and bottom of the rim
    out.append(box('shield', [cx - 18, cy + r - 6, z - 5], [cx + 18, cy + r - 2, z - 3], 'roll', 'rim'))
    out.append(box('shield', [cx - 18, cy - r + 2, z - 5], [cx + 18, cy - r + 6, z - 3], 'roll', 'rim'))
    # the boss and a cross of bands
    out.append(box('shield', [cx - 9, cy - 9, z - 9], [cx + 9, cy + 9, z - 3], 'armor', 'boss'))
    out.append(box('shield', [cx - 4, cy - 4, z - 11], [cx + 4, cy + 4, z - 9], 'dark', 'boss'))
    # (no cross of bands: a spiral is painted on it instead)
    return out


# ------------------------------------------------------------------ the spine (every stage) and the new ribcage
def spine(path, k, part, lying=False):
    """A spine up the back along a path of (y, z) points (x 0): a column of straight blocks, one per point, each reaching
    halfway to its neighbours, stepping back and forth to follow the path the way vanilla builds a curve; vertebrae painted
    on it as seams (no knobs)."""
    out = []
    w, d = 5 * k, 4 * k
    # only where the path bends (the neck), walked in small steps so its blocks overlap with no gaps; straight stretches as
    # they were
    fine = [path[0]]
    for (y0, z0), (y1, z1) in zip(path, path[1:]):
        n = max(1, int(math.ceil(abs(z1 - z0) / (1.5 * k)))) if abs(z1 - z0) > 2 * k else 1
        for i in range(1, n + 1):
            fine.append((y0 + (y1 - y0) * i / n, z0 + (z1 - z0) * i / n))
    path = fine
    ys = [p[0] for p in path]
    for i, (y, z) in enumerate(path):
        y0 = ys[0] if i == 0 else (ys[i - 1] + y) / 2
        y1 = ys[-1] if i == len(path) - 1 else (y + ys[i + 1]) / 2
        if y1 - y0 < 0.5:
            continue
        c = box(part, [-w / 2, y0, z - d / 2], [w / 2, y1, z + d / 2], 'band', 'spine')
        c.column = True
        out.append(c)
    return out


def back_line(cs, part, lo, hi, step, lying=False, skip=('flame',)):
    """Points up the middle of a part's back, just standing out of it: (y, z) pairs (lying: (z, y), the back facing up)."""
    out = []
    a = lo
    while a <= hi:
        best = None
        for c in cs:
            if c.part != part or c.mat in skip:
                continue
            l, h = c.bounds()
            if l[0] > 5 or h[0] < -5:
                continue
            if not lying and l[1] <= a <= h[1]:
                best = h[2] if best is None else max(best, h[2])
            if lying and l[2] <= a <= h[2]:
                best = h[1] if best is None else max(best, h[1])
        if best is not None:
            out.append((a, best + 0.6))
        a += step
    # smooth the line so the spine runs straight rather than stepping round every plate
    sm = []
    for i, (a, b) in enumerate(out):
        near = [q[1] for q in out[max(0, i - 2):i + 3]]
        sm.append((a, max(near)))
    return sm


def eyes_on(cs, part, centres, y, w, h, socket=1.0, mask=None):
    """Glowing eyes on a face: for each eye a dark socket and the yellow eye in it, laid on the front of whatever of the
    part is frontmost there. mask: (x0, x1, y0, y1) a dark plate behind them first (a face in shadow, the Armoured's)."""
    out = []

    def front(x0, x1, y0, y1):
        zs = [c.bounds()[0][2] for c in cs + out if c.part == part and c.bounds()[0][0] < x1 and c.bounds()[1][0] > x0
              and c.bounds()[0][1] < y1 and c.bounds()[1][1] > y0]
        return min(zs) if zs else 0
    if mask:
        x0, x1, y0, y1 = mask
        z = front(x0, x1, y0, y1)
        out.append(box(part, [x0, y0, z - 0.6], [x1, y1, z], 'dark', 'mask'))
    for cx in centres:
        x0, x1 = cx - w / 2 - socket, cx + w / 2 + socket
        z = front(x0, x1, y - h / 2 - socket, y + h / 2 + socket)
        if socket:
            out.append(box(part, [x0, y - h / 2 - socket, z - 0.5], [x1, y + h / 2 + socket, z], 'dark', 'socket'))
            z -= 0.5
        out.append(box(part, [cx - w / 2, y - h / 2, z - 0.5], [cx + w / 2, y + h / 2, z], 'eye', 'eye'))
    return out


def face_eyes(cs, part='head'):
    """Eyes on the face block of a head (its biggest straight block): set a little above its middle, a quarter in from
    each side."""
    hc = [c for c in cs if c.part == part and not turned(c)]
    if not hc:
        return []
    f = max(hc, key=lambda c: c.size[0] * c.size[1] * c.size[2])
    (x0, y0, _), (x1, y1, _) = f.bounds()
    W, H = x1 - x0, y1 - y0
    ex = W * 0.27
    return eyes_on(cs, part, [-ex, ex], y0 + H * 0.58, max(2.0, W * 0.17), max(2.0, H * 0.12), socket=0)


def amaterasu(part, cx, y0, cz):
    """Amaterasu's black flames held in an open palm: a heap of black fire on the palm, tongues rising from it, the middle
    tallest, each leaning a little out from the middle, lighter at its tip."""
    out = []
    k = 1.6
    out.append(box(part, [cx - 8 * k, y0, cz - 8 * k], [cx + 8 * k, y0 + 6 * k, cz + 8 * k], 'black', 'amaterasu'))
    for (dx, dz, h, w) in ((0, 0, 22, 6), (-5, -4, 16, 5), (5, -4, 18, 5), (-5, 4, 14, 5), (5, 4, 15, 5), (0, -7, 13, 4),
                           (0, 7, 12, 4), (-8, 0, 11, 4), (8, 0, 12, 4), (-7, -7, 9, 3), (7, 7, 9, 3)):
        c = box(part, [cx + (dx - w / 2) * k, y0 + 4 * k, cz + (dz - w / 2) * k],
                [cx + (dx + w / 2) * k, y0 + (4 + h) * k, cz + (dz + w / 2) * k], 'black', 'amaterasu')
        c.tip = [1, 1]
        out.append(c)
    return out


def skeleton_head(cs):
    """The Skeleton's skull made anew from straight blocks (the user found the old one odd), the horns kept: a cranium with a
    brow ridge, round dark sockets with glowing eyes, the nose's dark hollow, cheekbones, a row of upper teeth and a jaw with
    its own teeth below."""
    for c in cs:
        if c.part == 'head' and not (abs(centre(c)[0]) > 9 and centre(c)[1] > 60):
            c.part = None                                   # all but the horns
        elif c.part == 'head':
            a = max(range(3), key=lambda k: c.size[k])     # the horn's segments: longer, so they meet with no gap
            c.size[a] += 1.6
    out = []

    def b(lo, hi, m='bone', tag='skull'):
        out.append(box('head', lo, hi, m, tag))
    b([-8, 61, -11], [8, 74, 3], 'roll', 'cranium')
    b([-9, 69, -12.5], [9, 71.5, -10], 'roll', 'brow')
    for s_ in (1, -1):
        x0, x1 = sorted((s_ * 1.5, s_ * 7))
        b([x0, 64, -11.6], [x1, 69, -11], 'dark', 'socket')
        x0, x1 = sorted((s_ * 2.5, s_ * 6))
        b([x0, 65, -12.1], [x1, 67.5, -11.6], 'eye', 'eye')
        x0, x1 = sorted((s_ * 6, s_ * 9))
        b([x0, 61, -11.5], [x1, 64, -4], 'roll', 'cheek')
    b([-1.2, 61.5, -11.6], [1.2, 64, -11], 'dark', 'nose')
    for i in range(6):
        x = -5.5 + i * 2.2
        b([x - 0.8, 58, -10.5], [x + 0.8, 61, -9], 'band', 'tooth')
    b([-6.5, 57.5, -9], [6.5, 61, -1], 'dark', 'mouth')
    b([-7, 53, -10], [7, 57.5, 1], 'roll', 'jaw')
    for i in range(6):
        x = -5.5 + i * 2.2
        b([x - 0.8, 57.5, -9.5], [x + 0.8, 59.5, -8], 'band', 'tooth')
    return out


def humanoid_head():
    """The Humanoid's head made anew from straight blocks (the user's was turned plates, hard to paint): a skull with a brow
    ridge, sockets with glowing eyes, a nose ridge, cheekbones, a jaw with teeth, horns stepping up and out like the
    Skeleton's, and a crest of flame; set on a neck over the torso's middle."""
    out = []

    def b(lo, hi, m='armor', tag='head'):
        out.append(box('head', lo, hi, m, tag))
    b([-5, 66, 9], [5, 74, 19], 'roll', 'neck')
    b([-9, 74, 3], [9, 92, 21], 'armor', 'skull')
    b([-7, 69, 4], [7, 74, 18], 'armor', 'jaw')
    b([-10, 85, 1], [10, 88, 4], 'armor', 'brow')
    b([-1, 77, 1.5], [1, 84, 3], 'armor', 'nose')
    for s_ in (1, -1):
        x0, x1 = sorted((s_ * 6, s_ * 10))
        b([x0, 77, 2], [x1, 80, 8], 'armor', 'cheek')
        # the horns, stepping up and out
        for (a0, a1, y0, y1, z0, z1) in ((9, 12, 84, 88, 9, 14), (11, 14, 87, 91, 9.5, 13.5), (13, 16, 90, 95, 10, 13), (14.5, 17, 94, 100, 10.5, 12.5)):
            x0, x1 = sorted((s_ * a0, s_ * a1))
            b([x0, y0, z0], [x1, y1, z1], 'roll', 'horn')
    b([-6, 74, 2.4], [6, 75.5, 3], 'bright', 'teeth')
    b([-6, 72.5, 3.4], [6, 74, 4], 'dark', 'mouth')
    # the crest of flame over the skull, the middle tallest
    for i, x in enumerate((-6, -3, 0, 3, 6)):
        h = 7 + (2 - abs(i - 2)) * 3
        b([x - 1.25, 92, 9], [x + 1.25, 92 + h, 12], 'flame', 'crest')
        b([x - 1.25, 92, 14], [x + 1.25, 92 + h * 0.7, 17], 'flame', 'crest')
    out += eyes_on(out, 'head', [-4.5, 4.5], 82, 4, 2, socket=0.6)
    # a third bigger, from the neck's foot, to suit the broad torso
    k, base = 1.35, (0, 66, 14)
    for c in out:
        c.centre = [base[i] + (c.centre[i] - base[i]) * k for i in range(3)]
        c.size = [v * k for v in c.size]
    return out


def wing_root(cs, part):
    """Where a wing turns: the middle of its innermost feathers, at their inner edge."""
    w = sorted((c for c in cs if c.part == part), key=lambda c: min(abs(v) for v in (c.bounds()[0][0], c.bounds()[1][0])))[:5]
    if not w:
        return None
    pts = [centre(c) for c in w]
    inner = min(min(abs(c.bounds()[0][0]), abs(c.bounds()[1][0])) for c in w)
    sx = 1 if pts[0][0] > 0 else -1
    return [sx * inner, sum(p[1] for p in pts) / len(pts), sum(p[2] for p in pts) / len(pts)]


# ------------------------------------------------------------------ z-fighting
def planes(c):
    """Each face of a cube: (outward normal, distance, its four corners)."""
    hx, hy, hz = (s / 2 + c.inflate for s in c.size)
    out = []
    for axis in range(3):
        for sgn in (-1, 1):
            n = [0, 0, 0]
            n[axis] = sgn
            nw = app(c.m, n)
            quad = []
            others = [a for a in range(3) if a != axis]
            for a, b in ((-1, -1), (1, -1), (1, 1), (-1, 1)):
                p = [0, 0, 0]
                p[axis] = sgn * (hx, hy, hz)[axis]
                p[others[0]] = a * (hx, hy, hz)[others[0]]
                p[others[1]] = b * (hx, hy, hz)[others[1]]
                q = app(c.m, p)
                quad.append([q[i] + c.centre[i] for i in range(3)])
            out.append((axis, sgn, nw, sum(nw[i] * quad[0][i] for i in range(3)), quad))
    return out


def overlap(qa, qb, n):
    """The area two coplanar quads share (both convex), by clipping one with the other in the plane."""
    u = [qa[1][i] - qa[0][i] for i in range(3)]
    lu = math.sqrt(sum(v * v for v in u)) or 1
    u = [v / lu for v in u]
    v = [n[1] * u[2] - n[2] * u[1], n[2] * u[0] - n[0] * u[2], n[0] * u[1] - n[1] * u[0]]
    pa = [(sum(p[i] * u[i] for i in range(3)), sum(p[i] * v[i] for i in range(3))) for p in qa]
    pb = [(sum(p[i] * u[i] for i in range(3)), sum(p[i] * v[i] for i in range(3))) for p in qb]

    def area(poly):
        return abs(sum(poly[i][0] * poly[(i + 1) % len(poly)][1] - poly[(i + 1) % len(poly)][0] * poly[i][1] for i in range(len(poly)))) / 2

    def ccw(poly):
        s = sum(poly[i][0] * poly[(i + 1) % len(poly)][1] - poly[(i + 1) % len(poly)][0] * poly[i][1] for i in range(len(poly)))
        return poly if s > 0 else poly[::-1]
    pa, pb = ccw(pa), ccw(pb)
    out = pa
    for i in range(len(pb)):
        a, b = pb[i], pb[(i + 1) % len(pb)]
        inp, out = out, []
        if not inp:
            break

        def inside(p):
            return (b[0] - a[0]) * (p[1] - a[1]) - (b[1] - a[1]) * (p[0] - a[0]) >= -1e-9

        def cut(p, q):
            dx, dy = q[0] - p[0], q[1] - p[1]
            ex, ey = b[0] - a[0], b[1] - a[1]
            den = dx * ey - dy * ex
            if abs(den) < 1e-12:
                return p
            t = ((a[0] - p[0]) * ey - (a[1] - p[1]) * ex) / den
            return (p[0] + dx * t, p[1] + dy * t)
        for j in range(len(inp)):
            p, q = inp[j], inp[(j + 1) % len(inp)]
            if inside(q):
                if not inside(p):
                    out.append(cut(p, q))
                out.append(q)
            elif inside(p):
                out.append(cut(p, q))
    return area(out) if len(out) >= 3 else 0.0


def fix_fights(cs, gap=0.12, rounds=14):
    """Pushes out the smaller of each two cubes whose faces lie in one plane (facing the same way) and overlap."""
    total = 0
    for _ in range(rounds):
        fixed = 0
        bounds = [c.bounds() for c in cs]
        faces = [planes(c) for c in cs]
        for i in range(len(cs)):
            for j in range(i + 1, len(cs)):
                (la, ha), (lb, hb) = bounds[i], bounds[j]
                if any(la[k] > hb[k] + 0.05 or lb[k] > ha[k] + 0.05 for k in range(3)):
                    continue
                for ai, asg, na, da, qa in faces[i]:
                    for bi, bsg, nb, db, qb in faces[j]:
                        if sum(na[k] * nb[k] for k in range(3)) > 0.9995 and abs(da - db) < 0.03 and overlap(qa, qb, na) > 0.04:
                            # the one with the smaller face goes out
                            # the one with the smaller face goes out; ties settled by things a mirror doesn't change
                            # (size, then height, depth, distance from the middle), never by which cube came first, so
                            # both sides of the model come out alike
                            def key(c, a):
                                return (round(c.size[(a + 1) % 3] * c.size[(a + 2) % 3], 3), round(c.size[0] * c.size[1] * c.size[2], 3),
                                        round(c.centre[1], 3), round(c.centre[2], 3), round(abs(c.centre[0]), 3))
                            c, axis, sgn = (cs[i], ai, asg) if key(cs[i], ai) <= key(cs[j], bi) else (cs[j], bi, bsg)
                            grow(c, axis, sgn, gap)
                            fixed += 1
        total += fixed
        if not fixed:
            break
    return total


def mirror_pairs(cs):
    """Each cube on the model's right (x > 0) and its twin on the left (mirrored place, size and turn)."""
    S = [[-1, 0, 0], [0, 1, 0], [0, 0, 1]]
    pairs = []
    used = set()
    for i, c in enumerate(cs):
        if c.centre[0] <= 0.3:
            continue
        want = mul(S, mul(c.m, S))
        for j, o in enumerate(cs):
            if j in used or j == i or o.part is None or o.centre[0] >= -0.3:
                continue
            if abs(o.centre[0] + c.centre[0]) > 0.4 or abs(o.centre[1] - c.centre[1]) > 0.4 or abs(o.centre[2] - c.centre[2]) > 0.4:
                continue
            if any(abs(o.size[k] - c.size[k]) > 0.4 for k in range(3)):
                continue
            if any(abs(o.m[a][b] - want[a][b]) > 1e-3 for a in range(3) for b in range(3)):
                continue
            pairs.append((i, j))
            used.add(j)
            break
    return pairs


def symmetrise(cs, pairs):
    """The left twin made the exact mirror of the right one (after the flicker fix, which settles overlaps one at a time
    and so leaves the two sides a little different)."""
    S = [[-1, 0, 0], [0, 1, 0], [0, 0, 1]]
    for i, j in pairs:
        c, o = cs[i], cs[j]
        o.size = list(c.size)
        o.centre = [-c.centre[0], c.centre[1], c.centre[2]]
        o.m = mul(S, mul(c.m, S))


def grow(c, axis, sgn, d):
    """One face of a cube moved out by d (its far face stays)."""
    c.size[axis] += d
    shift = [0, 0, 0]
    shift[axis] = sgn * d / 2
    s = app(c.m, shift)
    c.centre = [c.centre[i] + s[i] for i in range(3)]


def drop_hidden(cs):
    """Cubes lying wholly inside another of the same part: in a see-through Susanoo their faces show through as panels that
    shouldn't be there (the Humanoid's body), so they go."""
    inv = []
    for c in cs:
        m = c.m
        inv.append([[m[j][i] for j in range(3)] for i in range(3)])   # the transpose turns world into the cube's frame
    keep = []
    for i, c in enumerate(cs):
        hidden = False
        pts = c.corners()
        for j, o in enumerate(cs):
            if i == j or o.part != c.part or o.mat in ('flame', 'eye') or c.mat in ('eye',):
                continue
            if o.size[0] * o.size[1] * o.size[2] <= c.size[0] * c.size[1] * c.size[2]:
                continue
            ok = True
            for p in pts:
                q = app(inv[j], [p[k] - o.centre[k] for k in range(3)])
                if any(abs(q[k]) > o.size[k] / 2 + 0.3 for k in range(3)):
                    ok = False
                    break
            if ok:
                hidden = True
                break
        if not hidden:
            keep.append(c)
    return keep


def drop_stacked(cs, share=0.6):
    """Plates stacked inside one another (the same turn, each a little thinner and shifted, the user's way of bevelling a
    plate): in a see-through Susanoo every one of them shows its outline, so only the biggest of each stack stays."""
    def same(a, b):
        return all(abs(a.m[i][j] - b.m[i][j]) < 1e-3 for i in range(3) for j in range(3))
    vol = [c.size[0] * c.size[1] * c.size[2] for c in cs]
    drop = set()
    for i, c in enumerate(cs):
        for j, o in enumerate(cs):
            if i == j or j in drop or o.part != c.part or vol[j] < vol[i] or (vol[j] == vol[i] and j > i) or not same(c, o):
                continue
            # both in o's frame (they share its turn): the overlap of two boxes
            inv = [[o.m[k][l] for k in range(3)] for l in range(3)]
            d = app(inv, [c.centre[k] - o.centre[k] for k in range(3)])
            ov = 1.0
            for k in range(3):
                lo = max(d[k] - c.size[k] / 2, -o.size[k] / 2)
                hi = min(d[k] + c.size[k] / 2, o.size[k] / 2)
                ov *= max(0.0, hi - lo)
            if ov >= share * vol[i]:
                drop.add(i)
                break
    return [c for i, c in enumerate(cs) if i not in drop]


def thicken(cs, least=0.3):
    n = 0
    for c in cs:
        for a in range(3):
            if c.size[a] < least:
                c.size[a] = least
                n += 1
    return n


# ------------------------------------------------------------------ writing a Blockbench file
def write_bb(name, cs, pivots, out_dir=OUT):
    elements, groups = [], {}
    for p in PARTS:
        if p in pivots or any(c.part == p for c in cs):
            groups[p] = {'name': p, 'origin': [round(v, 4) for v in pivots.get(p, [0, 0, 0])], 'rotation': [0, 0, 0], 'uuid': 'g-' + p,
                         'export': True, 'isOpen': True, 'visibility': True, 'children': []}
    for i, c in enumerate(cs):
        if c.part is None:
            continue
        a = angles(c.m)
        f = [c.centre[k] - c.size[k] / 2 for k in range(3)]
        t = [c.centre[k] + c.size[k] / 2 for k in range(3)]
        e = {'name': c.tag or 'cube', 'type': 'cube', 'uuid': 'c%04d' % i, 'from': [round(v, 4) for v in f], 'to': [round(v, 4) for v in t],
             'origin': [round(v, 4) for v in c.centre], 'rotation': a, 'inflate': c.inflate, 'autouv': 0, 'box_uv': True, 'faces': {}}
        if c.mat:
            e['susanoo_mat'] = c.mat
        if c.tip:
            e['susanoo_tip'] = c.tip
        if c.disc:
            e['susanoo_disc'] = c.disc
        if c.ring:
            e['susanoo_ring'] = 1
        if c.column:
            e['susanoo_column'] = 1
        if c.knob:
            e['susanoo_knob'] = 1
        if c.plates2d:
            e['susanoo_plates2d'] = c.plates2d
        elements.append(e)
        groups[c.part]['children'].append(e['uuid'])
    roots = []
    for p in PARTS:
        if p not in groups:
            continue
        par = PARENT[p]
        while par and par not in groups:
            par = PARENT[par]
        (groups[par]['children'] if par else roots).append(groups[p])
    d = {'meta': {'format_version': '4.10', 'model_format': 'modded_entity', 'box_uv': True}, 'name': name,
         'resolution': {'width': 256, 'height': 256}, 'elements': elements, 'outliner': roots, 'textures': []}
    os.makedirs(out_dir, exist_ok=True)
    json.dump(d, open(os.path.join(out_dir, name + '.bbmodel'), 'w'), indent=1)
    return d


# ------------------------------------------------------------------ preview (flat shaded, painter's order, four sides)
COLOURS = {'body': (170, 140, 230), 'head': (235, 120, 120), 'right_arm': (110, 200, 130), 'left_arm': (110, 170, 235),
           'right_leg': (230, 190, 90), 'left_leg': (230, 140, 70), 'right_wing': (150, 150, 150), 'left_wing': (110, 110, 110),
           'weapon': (240, 240, 120), 'shield': (90, 210, 220)}


def preview(cs, pivots, path, size=420):
    from PIL import Image, ImageDraw
    cs = [c for c in cs if c.part]
    allc = [p for c in cs for p in c.corners()]
    lo = [min(p[i] for p in allc) for i in range(3)]
    hi = [max(p[i] for p in allc) for i in range(3)]
    mid = [(lo[i] + hi[i]) / 2 for i in range(3)]
    span = max(hi[i] - lo[i] for i in range(3)) * 1.08
    views = [('front', 0), ('right side', 90), ('back', 180), ('three-quarter', 35)]
    sheet = Image.new('RGB', (size * 4, size + 20), (236, 236, 242))
    for vi, (label, yaw) in enumerate(views):
        img = Image.new('RGB', (size, size), (236, 236, 242))
        dr = ImageDraw.Draw(img)
        a = math.radians(yaw)
        # the camera looks along +z from -z (the front) turned by yaw about y; screen x is the model's left (its right on our left)
        def proj(p):
            x, y, z = (p[i] - mid[i] for i in range(3))
            xr = x * math.cos(a) - z * math.sin(a)
            zr = x * math.sin(a) + z * math.cos(a)
            return (-xr, y, zr)
        polys = []
        for c in cs:
            for axis, sgn, n, d, quad in planes(c):
                q = [proj(p) for p in quad]
                nz = n[0] * math.sin(a) + n[2] * math.cos(a)
                if nz > 0.001:
                    continue                                    # faces turned away
                shade = 0.55 + 0.45 * max(0.0, n[1] * 0.7 - nz * 0.5)
                polys.append((sum(v[2] for v in q) / 4, q, c.part, shade))
        polys.sort(key=lambda t: -t[0])
        for depth, q, part, shade in polys:
            col = tuple(int(v * shade) for v in COLOURS.get(part, (200, 200, 200)))
            pts = [((v[0] / span + 0.5) * size, (0.5 - v[1] / span) * size) for v in q]
            dr.polygon(pts, fill=col, outline=(40, 30, 50))
        for part, pv in pivots.items():
            v = proj(pv)
            x, y = (v[0] / span + 0.5) * size, (0.5 - v[1] / span) * size
            dr.ellipse([x - 3, y - 3, x + 3, y + 3], fill=(255, 0, 0))
        dr.text((6, size - 14), label, fill=(30, 30, 30))
        sheet.paste(img, (vi * size, 0))
    sheet.save(path)


# ------------------------------------------------------------------ the models
JOBS = [
    ('ribcage', 'susanoskeletonsasuke', assign_ribcage, lambda cs: ribcage(), mats_bone),
    ('skeleton', 'susanoskeletonsasuke', assign_skeleton,
     lambda cs: skeleton_ribs() + skeleton_head(cs), mats_bone),
    ('humanoid', 'susanohumanoidsasuke', assign_humanoid, lambda cs: humanoid_trunk(cs) + humanoid_head(), mats_humanoid),
    ('armoured', 'susanoarmoredsasuke', assign_armoured,
     lambda cs: armoured_shield() + eyes_on(cs, 'body', [-4, 4], 57.5, 4, 2, socket=0, mask=(-8, 8, 53, 62))
     , mats_armoured),
    # the Complete one is armoured all over: no spine (the user's call)
    ('complete', 'susanoperfectsasukestand', lambda cs: assign_complete(cs, 'stand'), face_eyes, mats_complete),
    ('complete_float', 'susanoperfectsasukefloat', lambda cs: assign_complete(cs, 'float'), face_eyes, mats_complete),
    ('complete_fly', 'susanoperfectsasukeflying', lambda cs: assign_complete(cs, 'fly'), face_eyes, mats_complete),
]


def rig(name, src, assign, extra, mats):
    cs = baked(os.path.join(SRC, src + '.bbmodel'))
    pivots = assign(cs)
    for c in cs:
        if c.part and not c.mat:
            c.mat = mats(c)
    if extra:
        cs += extra(cs)
    cs = [c for c in cs if c.part]
    before = len(cs)
    cs = drop_hidden(cs)
    if name == 'humanoid':
        cs = drop_stacked(cs)
    if len(cs) != before:
        print('  ', name, 'hidden cubes dropped:', before - len(cs))
    thin = thicken(cs)
    pairs = mirror_pairs(cs)
    fights = 0
    for _ in range(4):                                    # settle overlaps, mirror, until both hold
        n = fix_fights(cs)
        symmetrise(cs, pairs)
        fights += n
        if not n:
            break
    # twins overlapping each other across the middle can't both be exact mirrors without their faces meeting in one plane:
    # one of them stands a hair (0.12) proud there, too little to see
    fights += fix_fights(cs)
    tips(cs)
    return cs, pivots, thin, fights


if __name__ == '__main__':
    prev = sys.argv[1] if len(sys.argv) > 1 else None
    for name, src, assign, extra, mats in JOBS:
        cs, pivots, thin, fights = rig(name, src, assign, extra, mats)
        write_bb(name, cs, pivots)
        counts = {}
        for c in cs:
            counts[c.part] = counts.get(c.part, 0) + 1
        kinds = {}
        for c in cs:
            kinds[c.mat] = kinds.get(c.mat, 0) + 1
        print(name, len(cs), 'cubes', counts, kinds, 'thickened', thin, 'z-fights fixed', fights)
        if prev:
            preview(cs, pivots, os.path.join(prev, 'rig_' + name + '.png'))
