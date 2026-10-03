"""The other owners' Susanoo (Shisui first; Itachi, Madara, Obito to follow), built as code in Blockbench's frame (y up, -z the
front, +x the model's right, the user's feet at the origin) and finished the way sasuke_rig.py finishes Sasuke's: named parts
with their pivots on the joints, mirror-exact halves, no flickering faces. Written to porting/susanoo_src/<owner>/*.bbmodel
(they open in Blockbench), made into the mod's models and painted by susanoo_convert.py.

The user's plan (2026-10-04): every owner's Ribcage and Skeleton are Sasuke's shapes without the horns, in the owner's colour;
the Humanoid and Armoured are each owner's own; the Complete is Sasuke's type with small changes.

`python3 owner_rig.py [preview_dir]`"""
import math
import os
import sys

import sasuke_rig as R
from sasuke_rig import Cube, box, mat

SWAP = {'right_arm': 'left_arm', 'left_arm': 'right_arm', 'right_leg': 'left_leg', 'left_leg': 'right_leg',
        'right_wing': 'left_wing', 'left_wing': 'right_wing'}


def rb(part, centre, size, rot=(0, 0, 0), m='armor', tag=None):
    """A box about its own middle, turned (Blockbench angles, x first)."""
    c = Cube(list(size), list(centre), mat(list(rot)) if any(rot) else R.IDENTITY, 'added', 0, m, tag)
    c.part = part
    return c


def mirrored(c):
    """A cube's twin across the middle (its part swapped left for right)."""
    a = R.angles(c.m)
    t = rb(SWAP.get(c.part, c.part), [-c.centre[0], c.centre[1], c.centre[2]], c.size, (a[0], -a[1], -a[2]), c.mat, c.tag)
    t.tip, t.ring, t.column, t.knob, t.plates2d = c.tip, c.ring, c.column, c.knob, c.plates2d
    return t


def both(cs):
    """The right side's cubes and their mirrors."""
    return cs + [mirrored(c) for c in cs]


def rows(part, y0, y1, half, front, back, m='flesh', tag='torso', step=2):
    """A trunk made of rows two pixels tall, each as wide as half(y)*2 and as deep as front(y)..back(y), the way the user liked
    Sasuke's Humanoid torso: one connected piece."""
    out = []
    y = y0
    while y < y1:
        yc = y + step / 2
        hw = round(half(yc))
        if hw >= 1:
            out.append(box(part, [-hw, y, round(front(yc))], [hw, y + step, round(back(yc))], m, tag))
        y += step
    return out


def lerp_curve(pts):
    """A function through (y, value) points, straight between them."""
    pts = sorted(pts)

    def f(y):
        if y <= pts[0][0]:
            return pts[0][1]
        for (a, va), (b, vb) in zip(pts, pts[1:]):
            if y <= b:
                return va + (vb - va) * (y - a) / (b - a)
        return pts[-1][1]
    return f


def knob(part, cx, cy, z, r=3.5, depth=2.0, m='roll', tag='knob'):
    """A round knob on a front face at depth z (its back): a pixel circle of two crossed boxes."""
    return [box(part, [cx - r, cy - r + 1, z - depth], [cx + r, cy + r - 1, z], m, tag),
            box(part, [cx - r + 1, cy - r, z - depth + 0.4], [cx + r - 1, cy + r, z - 0.4], m, tag)]


def spiral_sword(part, start, frame, grip=24.0, blade=80.0, width=7.0, guard=True):
    """Shisui's sword: a grip, a guard and a blade twisted like a drill, every short section turned a little further about the
    blade's length than the one below it (its edges winding up it as spirals), round a thin core, narrowing to the point. It runs
    along frame's local +z from start (the grip's end)."""
    out = []

    def at(d, size, twist=0.0, m='bright', tag='sword'):
        ax = R.app(frame, [0, 0, 1])
        c = Cube(list(size), [start[i] + ax[i] * d for i in range(3)], R.mul(frame, mat([0, 0, twist])) if twist else frame, 'added', 0, m, tag)
        c.part = part
        out.append(c)
    at(grip / 2, [3.5, 3.5, grip], m='band', tag='grip')
    if guard:
        at(grip + 1.2, [width + 5, 4, 2.4], m='roll', tag='guard')
    # the blade: wide at the guard, winding up to a thin point, each section a little narrower and turned a little further
    seg = 4.0
    n = int(blade // seg)
    for i in range(n):
        k = 1.0 - i / n                                             # 1 at the guard, near 0 at the tip
        w = max(1.5, 1.5 + (width - 1.5) * k)
        at(grip + 2.4 + seg * (i + 0.5), [w, 5.0 if w > 6 else 2.5, seg + 0.5], twist=i * 24.0, tag='blade')
    return out


def finish(cs, mirror=True):
    """sasuke_rig.rig's finishing steps for cubes made here."""
    cs = [c for c in cs if c.part]
    cs = R.drop_hidden(cs)
    R.thicken(cs)
    pairs = R.mirror_pairs(cs) if mirror else []
    fights = 0
    for _ in range(4):
        n = R.fix_fights(cs)
        if pairs:
            R.symmetrise(cs, pairs)
        fights += n
        if not n:
            break
    fights += R.fix_fights(cs)
    R.tips(cs)
    return cs, fights


# ------------------------------------------------------------------ every owner: Sasuke's Skeleton without the horns
def skeleton_plain(cs):
    for c in cs:
        if c.part == 'head' and abs(R.centre(c)[0]) > 9 and R.centre(c)[1] > 60:
            c.part = None                                   # the horns
    return R.skeleton_ribs() + R.skeleton_head(cs)


# ------------------------------------------------------------------ Shisui (green)
def shisui_humanoid():
    """Shisui's Humanoid, after the user's reference (Storm's): a broad torso rising out of a ring of flame (no legs), its belly
    plated in rows with two round knobs on each, heavy round shoulders, long arms with big clawed hands, and a fierce head with a
    wide jaw of teeth, a crest on its brow and a mane of flame spikes round it."""
    out = []
    # --- the trunk: narrow at the flame, broad at the chest, the chest deeper than the belly
    half = lerp_curve([(0, 17), (6, 17), (20, 20), (40, 24), (52, 28), (64, 30), (70, 26), (74, 20)])
    front = lerp_curve([(0, -11), (6, -11), (30, -12), (48, -15), (62, -16), (74, -11)])
    back = lerp_curve([(0, 11), (6, 11), (40, 13), (62, 15), (74, 11)])
    trunk = rows('body', 0, 74, half, front, back)
    # the plates it reads as (painted as seams): four belly plates, two pecs, the collar
    p2d = [[0, 13 + 9 * i, 0, 2 * half(13 + 9 * i) - 2, 9] for i in range(4)]
    p2d += [[s * 13, 56, 0, 24, 14] for s in (1, -1)] + [[0, 68, 0, 46, 8]]
    for c in trunk:
        c.plates2d = p2d
    out += trunk
    # two knobs on each belly plate
    for i in range(4):
        y = 13 + 9 * i
        for s in (1, -1):
            out += knob('body', s * 8, y, round(front(y)), r=3.5)
    # --- the ring of flame it rises out of: thin tongues of uneven height leaning outward
    for i in range(18):
        deg = i * 20 + 10
        a = math.radians(deg)
        h = 10 + 10 * (0.5 + 0.5 * math.sin(i * 2.3 + 0.7))
        cx, cz = math.sin(a) * 20, math.cos(a) * 18
        out.append(rb('body', [cx + math.sin(a) * h * 0.13, h / 2, cz + math.cos(a) * h * 0.13], [4, h, 4], (16, deg, 0), 'flame', 'flame'))
    return out


def shisui_arm():
    """The right arm (mirrored for the left): from the shoulder down and out, the forearm reaching forward, a big hand with four
    claws and a thumb."""
    p = 'right_arm'
    out = [
        # the shoulder, round: a core, a cap on top, rounded front and back
        box(p, [26, 54, -12], [44, 70, 12], 'flesh', 'shoulder'),
        box(p, [28, 70, -9], [42, 74, 9], 'flesh', 'shoulder'),
        box(p, [44, 56, -9], [47, 68, 9], 'flesh', 'shoulder'),
        rb(p, [42, 46, 0], [15, 22, 15], (0, 0, 8), 'flesh', 'upper'),
        box(p, [37, 30, -24], [51, 42, 6], 'flesh', 'fore'),
        box(p, [36, 28, -36], [52, 43, -24], 'flesh', 'fist'),
    ]
    for i, y in enumerate((30, 33.5, 37, 40.5)):
        out.append(box(p, [35, y, -37.5], [44, y + 3, -35.5], 'flesh', 'finger'))
    return out


def shisui_head():
    """The head: a skull with a jaw full of teeth, a heavy brow with the crest on it, eyes; a mane of flame rising up and back
    from it like the reference's, its middle tallest."""
    p = 'head'
    out = [
        box(p, [-6, 72, -5], [6, 78, 7], 'flesh', 'neck'),
        box(p, [-9, 78, -11], [9, 98, 7], 'armor', 'skull'),
        box(p, [-9, 74, -13], [9, 82, 1], 'armor', 'jaw'),
        box(p, [-10, 90, -13], [10, 93, -9], 'armor', 'brow'),
        box(p, [-2, 93, -12], [2, 98, -10], 'bright', 'crest'),
        box(p, [-1.5, 84, -12.5], [1.5, 90, -11], 'armor', 'nose'),
        box(p, [-8, 81.5, -13.6], [8, 83, -13], 'bright', 'teeth'),
        box(p, [-7, 80, -13.6], [7, 81.5, -12.6], 'dark', 'mouth'),
    ]
    out += R.eyes_on(out, p, [-4.5, 4.5], 87.5, 4, 2, socket=0.6)
    # the mane: flame locks rising from the crown and the back of the skull, leaning back, the middle ones tallest
    for layer, (z, angs, base_y) in enumerate(((5, (-36, -18, 0, 18, 36), 96), (1, (-27, -9, 9, 27), 97))):
        for ang in angs:
            L = 22 - abs(ang) * 0.25 - layer * 5
            a = math.radians(ang)
            cx, cy = math.sin(a) * (4 + L / 2), base_y + math.cos(a) * L / 2
            out.append(rb(p, [cx, cy, z + 2 + L * 0.2], [4, L, 4], (22, 0, -ang), 'flame', 'mane'))
    for sx in (1, -1):
        for j, (y, L) in enumerate(((92, 12), (84, 10))):
            ang = sx * (70 + j * 15)
            a = math.radians(ang)
            out.append(rb(p, [math.sin(a) * (8 + L / 2), y + math.cos(a) * L / 2, 3], [4, L, 4], (15, 0, -ang), 'flame', 'mane'))
    return out


def shisui_sword_humanoid():
    return spiral_sword('right_arm', [44, 22, -30], mat([-90, 0, 0]), grip=26, blade=76, width=18)


def shisui_armoured_extra(cs):
    """Sasuke's Armoured for Shisui (the user's wish): no Amaterasu and no shield, the spiral sword upright in the right hand
    instead, where the flame was held."""
    for c in cs:
        if c.mat == 'black':
            c.part = None
        elif c.part == 'right_arm' and c.centre[2] < -30 and c.centre[1] < 17:
            c.part = None                                   # the open palm and its fingers: a fist round the grip instead
    fist = [box('right_arm', [47, 6, -47], [61, 20, -33], 'armor', 'fist')]
    for y in (7, 10.5, 14, 17.5):                         # the fingers wrapped round the grip, across its front
        fist.append(box('right_arm', [47.5, y, -49], [60.5, y + 3, -47], 'armor', 'finger'))
    fist.append(box('right_arm', [45, 14, -45], [47, 20, -36], 'armor', 'thumb'))
    return (R.eyes_on(cs, 'body', [-4, 4], 57.5, 4, 2, socket=0, mask=(-8, 8, 53, 62)) + fist
            + spiral_sword('right_arm', [54, 0, -40], mat([-90, 0, 0]), grip=28, blade=84, width=20))


def complete_sword(cs, blade_fn=None):
    """The Complete's sword with the owner's blade (Shisui's spiral by default): Sasuke's grip kept, his straight blade
    swapped."""
    w = [c for c in cs if c.part == 'weapon']
    if not w:
        return R.face_eyes(cs)
    grip = max(w, key=lambda c: c.size[0] * c.size[1] * c.size[2] if max(c.size) < 40 and c.size[2] > 20 else 0)
    frame = grip.m
    ax = R.app(frame, [0, 0, 1])
    blade = [c for c in w if max(c.size) >= 40]
    # which way along the grip the blade lies
    bc = blade[0].centre
    sgn = 1 if sum((bc[i] - grip.centre[i]) * ax[i] for i in range(3)) > 0 else -1
    if sgn < 0:
        frame = R.mul(frame, mat([0, 180, 0]))
        ax = [-v for v in ax]
    start = [grip.centre[i] - ax[i] * grip.size[2] / 2 for i in range(3)]
    for c in w:
        c.part = None
    if blade_fn:
        return R.face_eyes(cs) + blade_fn('weapon', start, frame, grip.size[2])
    return R.face_eyes(cs) + spiral_sword('weapon', start, frame, grip=grip.size[2], blade=96, width=22)


def shisui_jobs():
    hum = shisui_humanoid() + shisui_head()
    arm = shisui_arm()
    hum += arm + [mirrored(c) for c in arm] + shisui_sword_humanoid()
    pivots_h = {'body': [0, 0, 0], 'head': [0, 74, 0], 'right_arm': [36, 62, 0], 'left_arm': [-36, 62, 0]}
    return [('humanoid', hum, pivots_h)]


def shisui_rigged():
    """Shisui's stages made from Sasuke's (rigged the way sasuke_rig.py rigs them, with Shisui's changes)."""
    out = [('armoured', 'susanoarmoredsasuke', R.assign_armoured, shisui_armoured_extra, R.mats_armoured)]
    for name, pose, src in (('complete', 'stand', 'susanoperfectsasukestand'), ('complete_float', 'float', 'susanoperfectsasukefloat'),
                            ('complete_fly', 'fly', 'susanoperfectsasukeflying')):
        out.append((name, src, (lambda pz: lambda cs: R.assign_complete(cs, pz))(pose), complete_sword, R.mats_complete))
    return out



# ------------------------------------------------------------------ Itachi (red-orange)
def totsuka(part, start, frame, grip=0.0, gourd=True, blade=80.0, width=12.0):
    """The Totsuka Sword: a blade of white flame rising from the mouth of a sake gourd (or, on the Complete, from Sasuke's grip):
    its sections wavering side to side and in width, tongues of flame licking off its edges, narrowing to a point. Along frame's
    local +z from start."""
    out = []
    ax = R.app(frame, [0, 0, 1])
    side = R.app(frame, [1, 0, 0])

    def at(d, size, dx=0.0, roll=0.0, m='bright', tag='totsuka'):
        c = Cube(list(size), [start[i] + ax[i] * d + side[i] * dx for i in range(3)],
                 R.mul(frame, mat([0, 0, 0]) if not roll else mat([0, roll, 0])) if roll else frame, 'added', 0, m, tag)
        c.part = part
        out.append(c)
    d = grip
    if gourd:
        # the gourd: a big bulb, a waist, a smaller bulb, the mouth
        for length, w, m in ((12, 14, 'roll'), (3, 7, 'band'), (9, 11, 'roll'), (3, 6, 'band')):
            at(d + length / 2, [w, w, length], m=m, tag='gourd')
            d += length
    seg = 4.0
    n = int(blade // seg)
    for i in range(n):
        k = 1.0 - 0.85 * i / n                                    # narrowing toward the point
        w = max(2.0, width * k * (0.85 + 0.2 * math.sin(i * 1.3)))
        dx = 1.6 * math.sin(i * 0.7) * k
        at(d + seg * (i + 0.5), [w, 3.0, seg + 0.5], dx=dx, tag='blade')
        if i % 3 == 1 and i < n - 3:
            # a tongue of flame licking off the edge, leaning up and out
            s_ = 1 if (i // 3) % 2 == 0 else -1
            at(d + seg * (i + 1.0), [3.0, 2.5, 7.0 * k + 2], dx=dx + s_ * (w / 2 + 1.5 * k), roll=-s_ * 30, tag='lick')
    return out


def disc_shield(part, cx, cy, z, r, step=4):
    """A round shield facing the front, rows of a pixel circle painted as one glow with a spiral (Itachi's Yata Mirror), a
    raised rim and a boss."""
    out = []
    for y in range(-r, r, step):
        yc = y + step / 2
        half = round(math.sqrt(max(0.0, r * r - yc * yc)) / 2) * 2
        if half < 4:
            continue
        out.append(box(part, [cx - half, cy + y, z - 2.5], [cx + half, cy + y + step, z + 2.5], 'row', 'mirror'))
        out[-1].disc = [cx, cy, r]
        for s_ in (-1, 1):
            x0, x1 = sorted((cx + s_ * half, cx + s_ * (half - 4)))
            out.append(box(part, [x0, cy + y, z - 4], [x1, cy + y + step, z - 2.5], 'roll', 'rim'))
    out.append(box(part, [cx - 6, cy - 6, z - 6], [cx + 6, cy + 6, z - 2.5], 'armor', 'boss'))
    return out


def itachi_humanoid():
    """Itachi's Humanoid, after the user's references: a robed trunk rising from the ground, a sash across it from the right
    shoulder to the left hip and a belt, broad sloping shoulders; the Totsuka gourd in the right fist, the Yata Mirror on the
    left forearm."""
    out = []
    half = lerp_curve([(0, 22), (10, 21), (26, 21), (44, 25), (58, 28), (66, 28), (72, 22), (76, 16)])
    front = lerp_curve([(0, -13), (30, -12), (50, -15), (64, -15), (76, -10)])
    back = lerp_curve([(0, 13), (40, 13), (62, 15), (76, 10)])
    trunk = rows('body', 0, 76, half, front, back)
    p2d = [[0, 66, 0, 52, 14], [0, 46, 0, 50, 26], [0, 16, 0, 44, 32]]   # chest, belly, the robe's skirt
    for c in trunk:
        c.plates2d = p2d
    out += trunk
    # the belt
    out.append(box('body', [-22, 28, round(front(30)) - 2], [22, 34, round(back(30)) + 1], 'roll', 'belt'))
    # the sash: a band two rows at a time, from over the right shoulder down across the chest to the left hip
    for y in range(34, 70, 2):
        xc = -18 + (y - 34) * (40 / 36.0)                         # left hip (x -18) up to the right shoulder (x 22)
        z = round(front(y + 1)) - 2
        out.append(box('body', [round(xc) - 6, y, z], [round(xc) + 6, y + 2, z + 2], 'band', 'sash'))
    return out


def itachi_arm():
    p = 'right_arm'
    return [
        box(p, [24, 56, -11], [40, 70, 11], 'flesh', 'shoulder'),
        box(p, [26, 70, -8], [38, 73, 8], 'flesh', 'shoulder'),
        rb(p, [38, 47, 0], [13, 22, 13], (0, 0, 8), 'flesh', 'upper'),
        box(p, [33, 32, -22], [45, 43, 5], 'flesh', 'fore'),
        box(p, [32, 30, -33], [46, 44, -22], 'flesh', 'fist'),
    ] + [box(p, [31, y, -34.5], [40, y + 3, -32.5], 'flesh', 'finger') for y in (31, 34.5, 38, 41.5)]


def itachi_head():
    """A tengu's face: a long nose stepping out and down, a mask over the jaw with dark slits, a jewel on the brow, a horn curling
    up from the crown, a hood round the back and sides."""
    p = 'head'
    out = [
        box(p, [-6, 74, -5], [6, 80, 7], 'flesh', 'neck'),
        box(p, [-8, 79, -10], [8, 97, 7], 'armor', 'skull'),
        box(p, [-8, 75, -12], [8, 84, 0], 'armor', 'jawmask'),
        box(p, [-9, 90, -12], [9, 93, -9], 'armor', 'brow'),
        box(p, [-2, 93, -11.5], [2, 97, -9.5], 'bright', 'jewel'),
        box(p, [-2, 84, -14], [2, 90, -10], 'armor', 'nose'),
        box(p, [-1.5, 81, -18], [1.5, 86, -14], 'armor', 'nose'),
        box(p, [-1, 79, -21], [1, 83, -18], 'armor', 'nose'),
        # the horn, curling up and back from the crown
        box(p, [-2, 97, -6], [2, 103, -2], 'roll', 'horn'),
        box(p, [-2, 102, -3], [2, 108, 1], 'roll', 'horn'),
        box(p, [-1.5, 107, 0], [1.5, 112, 4], 'roll', 'horn'),
        # the hood
        box(p, [-11, 78, -6], [-8, 99, 9], 'armor', 'hood'),
        box(p, [8, 78, -6], [11, 99, 9], 'armor', 'hood'),
        box(p, [-11, 78, 7], [11, 99, 10], 'armor', 'hood'),
        box(p, [-11, 97, -9], [11, 100, 9], 'armor', 'hood'),
    ]
    for s_ in (1, -1):
        for y in (77.5, 80):                                       # the mask's slits
            x0, x1 = sorted((s_ * 2.5, s_ * 6.5))
            out.append(box(p, [x0, y, -12.6], [x1, y + 1, -12], 'dark', 'slit'))
    out += R.eyes_on(out, p, [-4.5, 4.5], 88, 4, 2, socket=0.6)
    return out


def itachi_jobs():
    hum = itachi_humanoid() + itachi_head()
    arm = itachi_arm()
    hum += arm + [mirrored(c) for c in arm]
    hum += totsuka('right_arm', [39, 30, -28], mat([-90, 0, 0]), grip=0, gourd=True, blade=64, width=12)
    hum += disc_shield('left_arm', -46, 40, -38, 20)
    pivots = {'body': [0, 0, 0], 'head': [0, 76, 0], 'right_arm': [32, 63, 0], 'left_arm': [-32, 63, 0]}
    return [('humanoid', hum, pivots)]


def itachi_armoured_extra(cs):
    """Sasuke's Armoured for Itachi: the Totsuka Sword's gourd in the right fist where Amaterasu was, his shield kept as the Yata
    Mirror, a tengu's long nose on the face."""
    for c in cs:
        if c.mat == 'black':
            c.part = None
        elif c.part == 'right_arm' and c.centre[2] < -30 and c.centre[1] < 17:
            c.part = None
    fist = [box('right_arm', [47, 6, -47], [61, 20, -33], 'armor', 'fist')]
    for y in (7, 10.5, 14, 17.5):
        fist.append(box('right_arm', [47.5, y, -49], [60.5, y + 3, -47], 'armor', 'finger'))
    fist.append(box('right_arm', [45, 14, -45], [47, 20, -36], 'armor', 'thumb'))
    eyes = R.eyes_on(cs, 'body', [-4, 4], 57.5, 4, 2, socket=0, mask=(-8, 8, 53, 62))
    z = eyes[0].bounds()[0][2]                                     # the face's front (the mask)
    nose = [box('body', [-2, 52, z - 4], [2, 57, z], 'armor', 'nose'), box('body', [-1.5, 50, z - 8], [1.5, 54, z - 4], 'armor', 'nose'),
            box('body', [-1, 48.5, z - 11], [1, 51.5, z - 8], 'armor', 'nose')]
    return (eyes + nose + fist + R.armoured_shield()
            + totsuka('right_arm', [54, 20, -40], mat([-90, 0, 0]), grip=0, gourd=True, blade=72, width=14))


def itachi_rigged():
    out = [('armoured', 'susanoarmoredsasuke', R.assign_armoured, itachi_armoured_extra, R.mats_armoured)]
    blade = lambda part, start, frame, grip: totsuka(part, start, frame, grip=grip, gourd=False, blade=96, width=16)
    for name, pose, src in (('complete', 'stand', 'susanoperfectsasukestand'), ('complete_float', 'float', 'susanoperfectsasukefloat'),
                            ('complete_fly', 'fly', 'susanoperfectsasukeflying')):
        out.append((name, src, (lambda pz: lambda cs: R.assign_complete(cs, pz))(pose), lambda cs: complete_sword(cs, blade), R.mats_complete))
    return out


# ------------------------------------------------------------------ Madara (blue)
def katana(part, start, frame, grip=24.0, blade=80.0, width=5.0):
    """A long straight sword: a wrapped grip, a square guard, a plain blade narrowing at its point. Along frame's local +z."""
    out = []
    ax = R.app(frame, [0, 0, 1])

    def at(d, size, m, tag):
        c = Cube(list(size), [start[i] + ax[i] * d for i in range(3)], frame, 'added', 0, m, tag)
        c.part = part
        out.append(c)
    at(grip / 2, [3.5, 3.5, grip], 'band', 'grip')
    at(grip + 1.2, [10, 10, 2.4], 'roll', 'guard')
    body = blade - 8
    at(grip + 2.4 + body / 2, [width, 2.0, body], 'bright', 'blade')
    at(grip + 2.4 + body + 3, [width * 0.6, 1.6, 6], 'bright', 'tip')
    at(grip + 2.4 + body + 7, [width * 0.3, 1.2, 2], 'bright', 'tip')
    return out


def kris(part, start, frame, grip=10.0, blade=56.0, width=6.0):
    """Madara's kris: a short grip, a broad guard, a blade waving side to side along its length, narrowing at the point. Along
    frame's local +z from start."""
    out = []
    ax = R.app(frame, [0, 0, 1])
    side = R.app(frame, [0, 1, 0])                                 # its flat faces the front

    def at(d, size, dx, m, tag):
        c = Cube(list(size), [start[i] + ax[i] * d + side[i] * dx for i in range(3)], frame, 'added', 0, m, tag)
        c.part = part
        out.append(c)
    at(grip / 2, [3, 3, grip], 0, 'band', 'grip')
    at(grip + 1.2, [4, width + 6, 2.4], 1.5, 'roll', 'guard')
    seg = 4.0
    n = int(blade // seg)
    for i in range(n):
        k = 1.0 if i < n - 4 else (n - i) / 5.0
        at(grip + 2.4 + seg * (i + 0.5), [2.0, max(1.5, width * k), seg + 0.5], 2.2 * math.sin(i * 0.95), 'bright', 'kris')
    return out


def turned_round(cs):
    """Cubes turned half round about the vertical (the front side made the back one, its right hand still its right)."""
    r = mat([0, 180, 0])
    out = []
    for c in cs:
        t = Cube(list(c.size), R.app(r, c.centre), R.mul(r, c.m), 'added', 0, c.mat, c.tag)
        t.part = 'body'
        t.tip = c.tip
        out.append(t)
    return out


def madara_humanoid():
    """Madara's Humanoid, after the anime (the wiki's picture): two sides joined along the spine, back to back, each with its own
    face and its own pair of arms (Ryomen Sukuna). A lean trunk, wide shoulders, long arms: on each side the right hand holds a
    waving kris, the left one is raised with its claws spread."""
    out = []
    half = lerp_curve([(0, 17), (20, 17), (40, 21), (56, 27), (66, 29), (72, 22), (76, 14)])
    front = lerp_curve([(0, -11), (30, -11), (52, -14), (64, -14), (76, -9)])
    back = lambda y: -front(y)
    trunk = rows('body', 0, 76, half, front, back)
    # two chests, front and back, and the belly between
    p2d = [[s * 12, 60, 0, 22, 14] for s in (1, -1)] + [[0, 40, 0, 30, 24], [0, 14, 0, 32, 26]]
    for c in trunk:
        c.plates2d = p2d
    return out + trunk


def madara_arms():
    """One side's arms: (right, left) cube lists, front side."""
    r, l = 'right_arm', 'left_arm'
    right = [
        box(r, [24, 56, -10], [40, 72, 10], 'flesh', 'shoulder'),
        rb(r, [45, 52, -2], [11, 24, 11], (0, 0, 35), 'flesh', 'upper'),
        box(r, [47, 34, -24], [58, 44, 0], 'flesh', 'fore'),
        box(r, [46, 32, -33], [59, 45, -24], 'flesh', 'hand'),
    ] + kris(r, [58, 38.5, -28.5], mat([0, 90, -20]), grip=12, blade=52, width=7)
    left = [
        box(l, [-40, 56, -10], [-24, 72, 10], 'flesh', 'shoulder'),
        rb(l, [-45, 76, -2], [11, 24, 11], (0, 0, 35), 'flesh', 'upper'),
        rb(l, [-55, 90, -12], [10, 10, 24], (25, 0, 0), 'flesh', 'fore'),
        box(l, [-63, 90, -32], [-48, 100, -22], 'flesh', 'palm'),
    ]
    for i, x in enumerate((-61, -57, -53, -49)):
        left.append(rb(l, [x + 0.5, 91, -37], [2.5, 2.5, 10], (-25, 0, 0), 'flesh', 'finger'))
        left.append(rb(l, [x + 0.5, 87.5, -42.5], [2, 2, 4], (-55, 0, 0), 'bright', 'claw'))
    left.append(rb(l, [-46, 92, -28], [2.5, 2.5, 9], (0, -40, 0), 'flesh', 'thumb'))
    return right, left


def madara_head():
    """Two faces back to back on one skull: the front one with long fangs in its lower jaw and two tusks growing up from it, the
    back one with long fangs in its upper jaw; a single tall horn rising from the crown, tapering to a point."""
    p = 'head'
    out = [
        box(p, [-6, 74, -6], [6, 80, 6], 'flesh', 'neck'),
        box(p, [-8, 79, -9], [8, 99, 9], 'armor', 'skull'),
    ]
    for f in (-1, 1):                                              # -1 the front face, +1 the back one
        z0 = f * 9

        def zb(a, b_):
            return sorted((z0 + f * a, z0 + f * b_))
        out.append(box(p, [-9, 90, zb(0, 3)[0]], [9, 93, zb(0, 3)[1]], 'armor', 'brow'))
        out.append(box(p, [-7, 75, zb(-6, 2)[0]], [7, 82, zb(-6, 2)[1]], 'armor', 'jaw'))
        out.append(box(p, [-1.5, 84, zb(0, 1.5)[0]], [1.5, 90, zb(0, 1.5)[1]], 'armor', 'nose'))
        out.append(box(p, [-6, 81, zb(1.5, 2.1)[0]], [6, 82.5, zb(1.5, 2.1)[1]], 'dark', 'mouth'))
        for s_ in (1, -1):
            x0, x1 = sorted((s_ * 2.5, s_ * 6.5))
            out.append(box(p, [x0, 86.5, zb(0, 0.6)[0]], [x1, 88.5, zb(0, 0.6)[1]], 'eye', 'eye'))
            fx0, fx1 = sorted((s_ * 3, s_ * 4.5))
            if f < 0:
                # the front: fangs rising from the lower jaw, tusks curving up at its corners
                out.append(box(p, [fx0, 82, zb(2, 3)[0]], [fx1, 86, zb(2, 3)[1]], 'bright', 'fang'))
                out.append(rb(p, [s_ * 8.5, 85, z0 - 3], [2, 9, 2], (0, 0, s_ * 15), 'bright', 'tusk'))
            else:
                # the back: fangs hanging from the upper jaw
                out.append(box(p, [fx0, 78.5, zb(2, 3)[0]], [fx1, 82.5, zb(2, 3)[1]], 'bright', 'fang'))
    # the horn: a tall cone stepping in to a point, from the crown
    y = 99
    for w, h in ((12, 5), (9, 5), (7, 5), (5, 4), (3, 4), (1.5, 3)):
        out.append(box(p, [-w / 2, y, -w / 2], [w / 2, y + h, w / 2], 'armor', 'horn'))
        y += h
    k, base = 1.3, (0, 74, 0)                             # a third bigger, from the neck's foot
    for c in out:
        c.centre = [base[i] + (c.centre[i] - base[i]) * k for i in range(3)]
        c.size = [v * k for v in c.size]
    return out


def madara_humanoid_extra(cs):
    """Madara's Humanoid on Sasuke's (its body and shading the user approved): no bow or arrow, Madara's two-faced horned head
    instead of Sasuke's, a kris in the raised right hand, and the same arms again turned to the back (the second side, its
    own right hand with its own kris)."""
    for c in cs:
        if c.part in ('right_arm', 'left_arm') and c.mat == 'bright':
            c.part = None                                      # the bow, its string, the arrow
    out = R.humanoid_trunk(cs)
    torso = [c for c in out if c.tag == 'torso']
    zc = (min(c.bounds()[0][2] for c in torso) + max(c.bounds()[1][2] for c in torso)) / 2 if torso else 0.0
    # the head, set on Sasuke's neck (its foot at y 66, z 14) a little bigger
    for c in madara_head():
        c.centre = [c.centre[0] * 1.05, 66 + (c.centre[1] - 74) * 1.05, zc + c.centre[2] * 1.05]
        c.size = [v * 1.05 for v in c.size]
        out.append(c)
    kr = kris('right_arm', [46, 60, -17], mat([-90, 0, 0]), grip=10, blade=52, width=8)
    out += kr
    # the back side's arms: the front ones (and the kris) turned half round about the torso's middle
    r = mat([0, 180, 0])
    for c in [c for c in cs if c.part in ('right_arm', 'left_arm')] + kr:
        rel = [c.centre[0], c.centre[1], c.centre[2] - zc]
        q = R.app(r, rel)
        # a little higher and wider than the front pair, so both pairs show from either side
        t = Cube(list(c.size), [q[0] * 1.12, q[1] + 14, q[2] + zc], R.mul(r, c.m), 'added', c.inflate, c.mat, c.tag)
        t.part = 'body'
        out.append(t)
    return out


def madara_jobs():
    return []


def madara_armoured_extra(cs):
    """Sasuke's Armoured for Madara: no Amaterasu and no shield, a long katana upright in the right fist."""
    for c in cs:
        if c.mat == 'black':
            c.part = None
        elif c.part == 'right_arm' and c.centre[2] < -30 and c.centre[1] < 17:
            c.part = None
    fist = [box('right_arm', [47, 6, -47], [61, 20, -33], 'armor', 'fist')]
    for y in (7, 10.5, 14, 17.5):
        fist.append(box('right_arm', [47.5, y, -49], [60.5, y + 3, -47], 'armor', 'finger'))
    fist.append(box('right_arm', [45, 14, -45], [47, 20, -36], 'armor', 'thumb'))
    return (R.eyes_on(cs, 'body', [-4, 4], 57.5, 4, 2, socket=0, mask=(-8, 8, 53, 62)) + fist
            + katana('right_arm', [54, 0, -40], mat([-90, 0, 0]), grip=28, blade=90, width=6))


def madara_complete_extra(cs):
    """Sasuke's Complete for Madara (the anime's: spiky hair and a tengu face like Sasuke's): a jewel on its forehead."""
    out = R.face_eyes(cs)
    hc = [c for c in cs if c.part == 'head' and not R.turned(c)]
    if hc:
        f = max(hc, key=lambda c: c.size[0] * c.size[1] * c.size[2])
        (x0, y0, z0), (x1, y1, z1) = f.bounds()
        k = (x1 - x0) / 16.0
        y = y0 + (y1 - y0) * 0.82
        out.append(box('head', [-1.5 * k, y - 1.5 * k, z0 - 0.8 * k], [1.5 * k, y + 1.5 * k, z0], 'bright', 'jewel'))
        out.append(box('head', [-0.8 * k, y - 2.5 * k, z0 - 0.6 * k], [0.8 * k, y + 2.5 * k, z0], 'bright', 'jewel'))
    return out


def madara_rigged():
    out = [('humanoid', 'susanohumanoidsasuke', R.assign_humanoid, madara_humanoid_extra, R.mats_humanoid),
           ('armoured', 'susanoarmoredsasuke', R.assign_armoured, madara_armoured_extra, R.mats_armoured)]
    for name, pose, src in (('complete', 'stand', 'susanoperfectsasukestand'), ('complete_float', 'float', 'susanoperfectsasukefloat'),
                            ('complete_fly', 'fly', 'susanoperfectsasukeflying')):
        out.append((name, src, (lambda pz: lambda cs: R.assign_complete(cs, pz))(pose), madara_complete_extra, R.mats_complete))
    return out


# ------------------------------------------------------------------ Obito (pale blue; Kakashi's Complete in the manga, with Obito's eyes)
def kamui_shuriken(part, cx, cy, cz, r=12.0, m='dark'):
    """A Kamui shuriken facing the front: a hub and three blades curving round it like the Mangekyo's pattern, each a chain of
    short boxes along a spiral arc, wide at the hub and tapering to a hooked point."""
    out = [box(part, [cx - 3, cy - 3, cz - 1.5], [cx + 3, cy + 3, cz + 1.5], m, 'hub'),
           box(part, [cx - 1.2, cy - 1.2, cz - 2.1], [cx + 1.2, cy + 1.2, cz + 2.1], 'roll', 'pin')]
    for b in range(3):
        a0 = b * 120.0
        n = 7
        for i in range(n):
            t = (i + 0.5) / n
            ang = math.radians(a0 + t * 110)
            rad = 3 + t * (r - 3)
            x, y = cx + math.cos(ang) * rad, cy + math.sin(ang) * rad
            w = 5.0 * (1 - t) + 1.5
            tangent = math.degrees(ang) + 90 - 25                     # along the arc, leaning out
            out.append(rb(part, [x, y, cz], [w, (r - 3) / n * 1.9 + 1, 2.4], (0, 0, tangent - 90), m, 'blade'))
    return out


def obito_head():
    """The Humanoid's head for Obito: the tengu face of Sasuke's Humanoid without its horns and crest, a forehead protector's
    plate across the brow, two locks of hair falling either side of the face, a hole in the chin and the scar down over the left
    eye (Kakashi's)."""
    out = []

    def b(lo, hi, m='armor', tag='head'):
        out.append(box('head', lo, hi, m, tag))
    b([-5, 66, 9], [5, 74, 19], 'roll', 'neck')
    b([-9, 74, 3], [9, 92, 21], 'armor', 'skull')
    b([-7, 69, 4], [7, 74, 18], 'armor', 'jaw')
    b([-10, 85, 1], [10, 89, 4], 'roll', 'protector')
    b([-2, 86, 0.4], [2, 88, 1], 'bright', 'emblem')
    b([-1, 77, 1.5], [1, 84, 3], 'armor', 'nose')
    b([-1.5, 70, 3.4], [1.5, 72, 4], 'dark', 'chinhole')
    b([-6, 74, 2.4], [6, 75.5, 3], 'dark', 'mouth')
    for s_ in (1, -1):
        x0, x1 = sorted((s_ * 9, s_ * 12))
        b([x0, 72, 4], [x1, 90, 9], 'flame', 'lock')            # the locks of hair either side of the face
        x0, x1 = sorted((s_ * 9, s_ * 13))
        b([x0, 86, 4], [x1, 94, 20], 'flame', 'hair')
    b([-9, 92, 4], [9, 96, 20], 'flame', 'hair')
    out += R.eyes_on(out, 'head', [-4.5, 4.5], 81, 4, 2, socket=0.6)
    b([-5, 77, 1.6], [-4, 85, 2.1], 'dark', 'scar')            # over the left eye (the model's left is -x)
    k, base = 1.35, (0, 66, 14)
    for c in out:
        c.centre = [base[i] + (c.centre[i] - base[i]) * k for i in range(3)]
        c.size = [v * k for v in c.size]
    return out


def obito_humanoid_extra(cs):
    """Sasuke's Humanoid for Obito: no bow or arrow, Obito's head, a Kamui shuriken in each hand."""
    for c in cs:
        if c.part in ('right_arm', 'left_arm') and c.mat == 'bright':
            c.part = None
    return (R.humanoid_trunk(cs) + obito_head() + kamui_shuriken('right_arm', 46, 70, -20, r=12)
            + kamui_shuriken('left_arm', -53, 33, -26, r=12))


def obito_armoured_extra(cs):
    """Sasuke's Armoured for Obito: no shield, a Kamui shuriken standing over the open right palm where Amaterasu burned, the
    scar down over the left eye."""
    for c in cs:
        if c.mat == 'black':
            c.part = None
    eyes = R.eyes_on(cs, 'body', [-4, 4], 57.5, 4, 2, socket=0, mask=(-8, 8, 53, 62))
    z = min(c.bounds()[0][2] for c in eyes)
    scar = [box('body', [-4.6, 52, z - 0.5], [-3.6, 63, z], 'dark', 'scar')]
    return eyes + scar + kamui_shuriken('right_arm', 54.3, 36, -41.3, r=16)


def obito_complete_extra(cs):
    """Sasuke's Complete for Obito (Kakashi's in the manga): a forehead protector's plate across the brow, the scar down over the
    left eye, and a Kamui shuriken in the right hand (the sword stays in the left)."""
    out = R.face_eyes(cs)
    hc = [c for c in cs if c.part == 'head' and not R.turned(c)]
    if hc:
        f = max(hc, key=lambda c: c.size[0] * c.size[1] * c.size[2])
        (x0, y0, z0), (x1, y1, z1) = f.bounds()
        W, H = x1 - x0, y1 - y0
        k = W / 16.0
        out.append(box('head', [x0 - 0.5 * k, y0 + H * 0.74, z0 - 1.2 * k], [x1 + 0.5 * k, y0 + H * 0.9, z0], 'armor', 'protector'))
        out.append(box('head', [-1.5 * k, y0 + H * 0.77, z0 - 1.6 * k], [1.5 * k, y0 + H * 0.87, z0 - 1.2 * k], 'bright', 'emblem'))
        ex = -W * 0.27
        out.append(box('head', [ex - 0.5 * k, y0 + H * 0.35, z0 - 0.7 * k], [ex + 0.5 * k, y0 + H * 0.72, z0], 'dark', 'scar'))
    # the right hand: the right arm's farthest point from its shoulder
    arm = [c for c in cs if c.part == 'right_arm']
    if arm:
        sh = max(arm, key=lambda c: c.centre[1])
        hand = max(arm, key=lambda c: sum((c.centre[i] - sh.centre[i]) ** 2 for i in range(3)))
        lo, hi = hand.bounds()
        out += kamui_shuriken('right_arm', (lo[0] + hi[0]) / 2, (lo[1] + hi[1]) / 2, lo[2] - 3, r=18)
    return out


def obito_rigged():
    out = [('humanoid', 'susanohumanoidsasuke', R.assign_humanoid, obito_humanoid_extra, R.mats_humanoid),
           ('armoured', 'susanoarmoredsasuke', R.assign_armoured, obito_armoured_extra, R.mats_armoured)]
    for name, pose, src in (('complete', 'stand', 'susanoperfectsasukestand'), ('complete_float', 'float', 'susanoperfectsasukefloat'),
                            ('complete_fly', 'fly', 'susanoperfectsasukeflying')):
        out.append((name, src, (lambda pz: lambda cs: R.assign_complete(cs, pz))(pose), obito_complete_extra, R.mats_complete))
    return out


OWNERS = {'shisui': shisui_jobs, 'itachi': itachi_jobs, 'madara': madara_jobs}
RIGGED = {'shisui': shisui_rigged, 'itachi': itachi_rigged, 'madara': madara_rigged, 'obito': obito_rigged}

if __name__ == '__main__':
    prev = next((a for a in sys.argv[1:] if not a.startswith('--')), None)
    who = next((a.split('=', 1)[1] for a in sys.argv[1:] if a.startswith('--owner=')), None)
    # the plain Skeleton every other owner shares
    cs, pivots, thin, fights = R.rig('skeleton', 'susanoskeletonsasuke', R.assign_skeleton, skeleton_plain, R.mats_bone)
    R.write_bb('skeleton', cs, pivots, os.path.join(R.SRC, 'common'))
    print('common skeleton', len(cs), 'cubes, z-fights fixed', fights)
    if prev:
        R.preview(cs, pivots, os.path.join(prev, 'common_skeleton.png'))
    for owner, jobs in OWNERS.items():
        if who and owner != who:
            continue
        for name, cs, pivots in jobs():
            cs, fights = finish(cs)
            R.write_bb(name, cs, pivots, os.path.join(R.SRC, owner))
            kinds = {}
            for c in cs:
                kinds[c.mat] = kinds.get(c.mat, 0) + 1
            print(owner, name, len(cs), 'cubes', kinds, 'z-fights fixed', fights)
            if prev:
                R.preview(cs, pivots, os.path.join(prev, f'{owner}_{name}.png'))
    for owner, jobs in RIGGED.items():
        if who and owner != who:
            continue
        for name, src, assign, extra, mats in jobs():
            cs, pivots, thin, fights = R.rig(name, src, assign, extra, mats)
            R.write_bb(name, cs, pivots, os.path.join(R.SRC, owner))
            print(owner, name, len(cs), 'cubes (from Sasuke\'s), z-fights fixed', fights)
            if prev:
                R.preview(cs, pivots, os.path.join(prev, f'{owner}_{name}.png'))
