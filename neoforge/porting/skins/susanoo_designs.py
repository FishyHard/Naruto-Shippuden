"""New Susanoo for Itachi, Shisui, Madara and Obito (the user kept their own Sasuke ones, susanoo_convert.py), drawn as code in
Blockbench's coordinates (y up, -z the front, +x the model's right, the user's feet at the origin) and made into the mod's
models by susanoo_convert.py, painted the same way: a pale glow in the owner's colour, an outline round every face.

Each owner keeps one look through the stages (the user's references):
  Itachi  red-orange: a tengu face with its long nose, a mask over the jaw, spirals on the shoulders; the Totsuka gourd and
          sword in the right hand, the Yata Mirror in the left; hooded from the Armoured stage on.
  Shisui  green: a crown of spikes, ringed plates down the belly, a sword.
  Madara  blue: a tall crest sweeping forward, four arms (the upper pair raised in a sign), twin swords on the back.
  Obito   pale blue: a crest with its emblem, a mane of flame, a robe and sash; two black Kamui shuriken.
Every Complete one stands on legs and has wings of overlapping feather tiles.

Stages: 2 skeleton (about 5 blocks), 3 humanoid (6), 4 armoured (8), 5 complete (drawn 18 blocks tall by the renderer)."""
import math

# box materials the painter knows: None (the glow), 'eye', 'dark', 'armor', 'bright', 'mark', 'black'


class Model:
    """Bones and boxes; k scales and oy lifts everything added while they're set (the same parts at another stage's size)."""

    def __init__(self):
        self.elements, self.root, self.groups = [], [], {}
        self.k, self.oy = 1.0, 0.0

    def _p(self, x, y, z):
        return [x * self.k, y * self.k + self.oy, z * self.k]

    def bone(self, name, origin, parent=None):
        g = {'name': name, 'origin': self._p(*origin), 'rotation': [0, 0, 0], 'children': [], 'uuid': name}
        (self.groups[parent]['children'] if parent else self.root).append(g)
        self.groups[name] = g
        return name

    def box(self, bone, cx, cy, cz, w, h, d, mat=None, rot=None, pivot=None):
        c = self._p(cx, cy, cz)
        w, h, d = w * self.k, h * self.k, d * self.k
        e = {'type': 'cube', 'from': [c[0] - w / 2, c[1] - h / 2, c[2] - d / 2], 'to': [c[0] + w / 2, c[1] + h / 2, c[2] + d / 2],
             'uuid': 'e%d' % len(self.elements), 'mat': mat}
        if rot:
            e['rotation'] = list(rot)
            e['origin'] = self._p(*pivot) if pivot else c
        self.elements.append(e)
        self.groups[bone]['children'].append(e['uuid'])

    def sym(self, bone, cx, cy, cz, w, h, d, mat=None, rot=None, pivot=None):
        """A box and its mirror across the middle (x and the turns about y and z flipped)."""
        self.box(bone, cx, cy, cz, w, h, d, mat, rot, pivot)
        self.box(bone, -cx, cy, cz, w, h, d, mat, (rot[0], -rot[1], -rot[2]) if rot else None,
                 (-pivot[0], pivot[1], pivot[2]) if pivot else None)

    def bb(self):
        return {'elements': self.elements, 'outliner': self.root}


# ------------------------------------------------------------------ the skeleton
def skeleton(owner):
    m = Model()
    m.bone('body', (0, 0, 0))
    m.box('body', 0, 40, 9, 4, 80, 4)                                      # the spine
    for i, (y, half) in enumerate(zip((14, 22, 30, 38, 46), (9, 11, 12.5, 13, 12))):
        m.sym('body', half, y, 1, 2.4, 2.4, 18)                            # the ribs round the sides
        m.box('body', 0, y, 9.5, half * 2, 2.4, 2.4)                       # joined at the spine
        m.sym('body', half - 2.5, y, -8, 5, 2.4, 2.4, rot=(0, -20, 0))      # curling in at the front
    m.box('body', 0, 55, 5, 34, 3, 3)                                      # the collarbones
    m.box('body', 0, 61, 6, 3.5, 8, 3.5)                                   # the neck
    m.bone('head', (0, 63, 4), 'body')
    m.box('head', 0, 71, 3, 14, 12, 14)
    m.box('head', 0, 63, 1, 11, 3, 11)                                     # the jaw
    m.sym('head', 3.6, 71, -4.3, 4, 3.4, 1, 'dark')                        # sockets
    m.sym('head', 3.6, 71, -4.9, 2.2, 1.6, 0.6, 'eye')
    m.box('head', 0, 67.3, -4.3, 2, 2, 1, 'dark')                          # the nose
    m.box('head', 0, 64.8, -4.4, 10, 1.3, 1, 'bright')                     # the grin
    for name, side in (('right_arm', 1), ('left_arm', -1)):
        m.bone(name, (17 * side, 55, 5), 'body')
        m.box(name, 18 * side, 45, 5, 3, 20, 3)                            # upper arm
        m.box(name, 18 * side, 35, 5, 4.5, 4.5, 4.5)                       # elbow
        m.box(name, 18 * side, 25, 1, 3, 20, 3, rot=(22, 0, 0), pivot=(18 * side, 35, 5))
        m.box(name, 18 * side, 13, -3, 7, 5, 6, rot=(22, 0, 0), pivot=(18 * side, 35, 5))      # the palm
        for f in range(4):
            m.box(name, 18 * side + (f - 1.5) * 1.7, 7.5, -4.5, 1.3, 7, 1.3, rot=(30, 0, 0), pivot=(18 * side, 35, 5))
    head_bones(m, owner, 'head', 71, 1.0, skeleton=True)
    return m


# ------------------------------------------------------------------ heads
def head_bones(m, owner, bone, cy, k, skeleton=False, armoured=False):
    """Each owner's head over a skull or face centred at height cy (k: its size)."""
    if owner == 'itachi':
        # the long tengu nose
        m.box(bone, 0, cy - 2 * k, -(9 if not skeleton else 5) * k - 5 * k, 3 * k, 3 * k, 11 * k, rot=(-18, 0, 0),
              pivot=(0, cy, -6 * k if not skeleton else -4))
        if not skeleton:
            m.box(bone, 0, cy - 7 * k, -11.6 * k, 21 * k, 7 * k, 2.5 * k, 'mark')          # the mask over the jaw
            m.sym(bone, 10.5 * k, cy + 4 * k, 1 * k, 2 * k, 8 * k, 4 * k, rot=(0, 0, -18), pivot=(10.5 * k, cy, 1 * k))   # ears
            if armoured:
                m.box(bone, 0, cy + 11 * k, 1 * k, 25 * k, 6 * k, 25 * k, 'armor')            # the hood
                m.box(bone, 0, cy + 2 * k, 8 * k, 25 * k, 20 * k, 10 * k, 'armor')
                m.sym(bone, 12 * k, cy + 2 * k, 0, 2.5 * k, 20 * k, 23 * k, 'armor')
                m.box(bone, 0, cy + 16 * k, -3 * k, 10 * k, 6 * k, 10 * k, 'armor', rot=(25, 0, 0))
    elif owner == 'shisui':
        n = 5 if skeleton else 9
        for i in range(n):
            x = (i - (n - 1) / 2) * (3 if skeleton else 2.6) * k
            h = (6 if skeleton else 9) * k + (n // 2 - abs(i - n // 2)) * 1.6 * k
            m.box(bone, x, cy + (6.5 if skeleton else 10) * k + h / 2, (1 - abs(i - n // 2) * 0.6) * k, 2.4 * k, h, 2.4 * k, 'armor' if armoured else None,
                  rot=(-12, 0, -x / k * 2.2), pivot=(x, cy + (6 if skeleton else 9.5) * k, 0))
        if not skeleton:
            m.sym(bone, 5 * k, cy + 3.6 * k, -10.8 * k, 7 * k, 1.8 * k, 1.4 * k, 'dark', rot=(0, 0, 16), pivot=(5 * k, cy + 3.6 * k, -10.8 * k))  # scowl
    elif owner == 'madara':
        base = cy + (6 if skeleton else 9) * k
        m.box(bone, 0, base + 9 * k, -3 * k, 4.5 * k, 20 * k, 4.5 * k, 'armor' if armoured else None, rot=(-32, 0, 0), pivot=(0, base, 0))
        m.box(bone, 0, base + 22 * k, -14 * k, 3 * k, 12 * k, 3 * k, 'armor' if armoured else None, rot=(-58, 0, 0), pivot=(0, base, 0))
        if not skeleton:
            m.sym(bone, 4 * k, cy - 6 * k, -10.6 * k, 1.5 * k, 3 * k, 1.2 * k, 'bright')   # fangs
    elif owner == 'obito':
        if skeleton:
            m.sym(bone, 7 * k, cy + 9 * k, 1, 2.4 * k, 8 * k, 2.4 * k, rot=(0, 0, -28), pivot=(7 * k, cy + 6 * k, 1))
        else:
            m.box(bone, 0, cy + 9.5 * k, -10.8 * k, 7 * k, 5 * k, 1.5 * k, 'armor')          # the crest and its emblem
            m.box(bone, 0, cy + 9.5 * k, -11.7 * k, 2.4 * k, 2.4 * k, 0.6 * k, 'dark')
            for i in range(7):
                x = (i - 3) * 3 * k
                h = (10 + (3 - abs(i - 3)) * 2.5) * k
                m.box(bone, x, cy + 10 * k + h / 2, (4 + abs(i - 3)) * k, 3 * k, h, 3 * k, None, rot=(28, 0, -x / k * 2), pivot=(x, cy + 9 * k, 4 * k))


def face(m, owner, bone, cy, armoured):
    """The face of the Humanoid and later stages: the skull, brow, eyes, a mouth of teeth, cheekbones, then the owner's."""
    m.box(bone, 0, cy, 0, 20, 20, 20)
    m.box(bone, 0, cy + 4, -10.6, 20, 2.6, 2.2, 'armor' if armoured else None)
    m.sym(bone, 5, cy + 1.5, -10.4, 6, 2.4, 1, 'eye')
    m.box(bone, 0, cy - 6, -10.4, 14, 3.6, 1, 'dark')
    m.box(bone, 0, cy - 4.8, -10.8, 13, 1.2, 1, 'bright')
    m.box(bone, 0, cy - 7.2, -10.8, 13, 1.2, 1, 'bright')
    m.sym(bone, 8.2, cy - 2, -9.6, 4, 3, 3)
    head_bones(m, owner, bone, cy, 1.0, armoured=armoured)


# ------------------------------------------------------------------ the humanoid (and, armoured, its plates)
def upper_body(m, owner, armoured):
    m.bone('body', (0, 14, 0))
    m.box('body', 0, 7, 0, 26, 12, 20)                                     # the waist, fading out
    m.box('body', 0, 24, 0, 22, 20, 16)                                    # abdomen
    m.box('body', 0, 38, 0, 28, 10, 20)
    m.box('body', 0, 50, 0, 36, 14, 22)                                    # chest
    m.sym('body', 8, 52, -11.6, 14, 9, 2)                                  # pecs
    for j in range(3):
        m.sym('body', 4.5, 18 + j * 6, -8.6, 7, 4, 1.6)                    # the abs
    m.box('body', 0, 58, 2, 22, 4, 14)                                     # traps
    m.box('body', 0, 61, 1, 12, 6, 12)                                     # neck
    m.bone('head', (0, 62, 0), 'body')
    face(m, owner, 'head', 72, armoured)
    for name, side in (('right_arm', 1), ('left_arm', -1)):
        m.bone(name, (22 * side, 56, 0), 'body')
        m.box(name, 24 * side, 54, 0, 16, 14, 16)                          # deltoid
        m.box(name, 25 * side, 41, 0, 12, 20, 12)
        m.box(name, 25 * side, 23, 0, 11, 18, 11)                          # forearm
        m.box(name, 25 * side, 10, 0, 13, 10, 13)                          # fist
        m.box(name, 25 * side, 8, -6.8, 12, 4, 1.6)                        # knuckles
        m.box(name, 19.5 * side, 12, -3, 3, 6, 4)                          # thumb
        if armoured:
            m.box(name, 26 * side, 63, 0, 22, 5, 22, 'armor')              # pauldron
            m.box(name, 36.5 * side, 56, 0, 2.5, 12, 22, 'armor')
            m.box(name, 25 * side, 24, 0, 13, 12, 13, 'armor')             # vambrace
    if armoured:
        m.box('body', 0, 51, -11.9, 38, 14, 2, 'armor')                    # breastplate
        for j in range(3):
            m.box('body', 0, 40 - j * 6, -10.6 + j * 0.5, 30 - j * 4, 5, 2, 'armor')
        m.box('body', 0, 50, 11.8, 38, 18, 2, 'armor')
        m.sym('body', 9, 6, -10, 14, 16, 2, 'armor', rot=(10, 0, 0), pivot=(9, 14, -10))     # tassets
    owner_body(m, owner, armoured)


def owner_body(m, owner, armoured):
    if owner == 'itachi':
        for name, side in (('right_arm', 1), ('left_arm', -1)):
            m.box(name, 32.6 * side, 54, 0, 1.6, 10, 10, 'mark')           # the spirals on the shoulders
        m.box('right_arm', 25, 9, -11, 11, 9, 9, 'armor')                  # the Totsuka gourd, held out in the fist
        m.box('right_arm', 25, 16, -11, 6, 5, 6, 'armor')
        # the Yata Mirror on the left forearm, facing forward: a round shield of strips
        for i, y in enumerate(range(-12, 13, 3)):
            w = 2 * math.sqrt(max(0, 13 * 13 - y * y))
            m.box('left_arm', -27, 26 + y, -9.5, w, 3, 2, 'bright' if abs(y) < 9 else 'mark')
        if armoured:
            m.box('right_arm', 25, 42, -11, 3, 50, 3, 'bright', rot=(-28, 0, 0), pivot=(25, 18, -11))   # the sword of light, out of the gourd
    elif owner == 'shisui':
        for j in range(4):
            m.box('body', 0, 16 + j * 6, -8.7, 20, 4, 1.4, 'armor')        # ringed plates down the belly
            m.sym('body', 5.5, 16 + j * 6, -9.6, 3, 3, 0.8, 'mark')
        if armoured:
            m.box('right_arm', 25, 40, -6, 3, 48, 4, 'bright', rot=(-25, 0, 0), pivot=(25, 10, -6))   # the sword, held up
            m.box('right_arm', 25, 17, -6, 9, 2, 7, 'armor', rot=(-25, 0, 0), pivot=(25, 10, -6))     # its guard
    elif owner == 'madara':
        for j in range(4):
            m.box('body', 0, 4 - j * 5, 4, 16 - j * 2, 2.4, 10, 'bright')  # the ribs below, where the body ends
        m.box('body', 0, -4, 9, 3.5, 22, 3.5, 'bright')
        for name, side in (('right_upper', 1), ('left_upper', -1)):
            # the second pair, raised in a sign beside the head
            m.bone(name, (20 * side, 60, 6), 'body')
            m.box(name, 27 * side, 72, 6, 10, 20, 10, rot=(0, 0, -18 * side), pivot=(20 * side, 62, 6))
            m.box(name, 30 * side, 90, 4, 9, 18, 9, rot=(0, 0, 8 * side), pivot=(30 * side, 82, 6))
            m.box(name, 29 * side, 101, 2, 9, 8, 6)
            m.box(name, 28 * side, 108, 2, 2.5, 8, 2.5)
            m.box(name, 31 * side, 107, 2, 2.5, 7, 2.5)
        if armoured:
            for side in (1, -1):
                m.box('body', 0, 60, 14, 3, 64, 2, 'bright', rot=(0, 0, 35 * side), pivot=(0, 50, 14))   # the twin swords on the back
                m.box('body', 18 * side, 86, 14, 4, 12, 3, 'dark', rot=(0, 0, 35 * side), pivot=(0, 50, 14))
    elif owner == 'obito':
        m.box('body', 0, 30, 0, 24.4, 4, 16.4, 'mark')                     # the sash
        if armoured:
            m.box('body', 0, 18, 0, 30, 18, 22, 'armor')                   # the robe below the sash


def humanoid(owner, armoured=False):
    m = Model()
    if armoured:
        m.k = 1.35
    upper_body(m, owner, armoured)
    return m


# ------------------------------------------------------------------ the complete Susanoo
def complete(owner):
    m = Model()
    # legs, long and heavy: thigh, knee plate, shin and greave, foot; the hips at 104
    for name, side in (('right_leg', 1), ('left_leg', -1)):
        m.bone(name, (13 * side, 104, 0))
        m.box(name, 13 * side, 86, 0, 20, 36, 20)
        m.box(name, 13 * side, 66, -10.6, 15, 10, 2, 'armor')
        m.box(name, 13 * side, 38, 0, 17, 56, 17)                          # the shin, down onto the foot
        m.box(name, 13 * side, 40, -9, 17, 40, 2, 'armor')
        m.box(name, 13 * side, 5, -4, 18, 10, 26, 'armor')
    # the upper body is the armoured one's, a third bigger, its waist on the hips
    k = 1.3
    m.k, m.oy = k, 106 - 14 * k
    upper_body(m, owner, True)
    m.k, m.oy = 1.0, 0.0
    top = 106 + (82 - 14) * k                                              # the top of the head
    # the skirt of plates over the thighs (Obito: a long robe)
    if owner == 'obito':
        m.box('body', 0, 84, 0, 46, 48, 30, 'armor')
    else:
        m.box('body', 0, 92, -12.5, 36, 30, 3, 'armor', rot=(8, 0, 0), pivot=(0, 106, -12))
        m.box('body', 0, 92, 12.5, 36, 30, 3, 'armor', rot=(-8, 0, 0), pivot=(0, 106, 12))
        m.sym('body', 20, 92, 0, 3, 30, 22, 'armor', rot=(0, 0, 8), pivot=(19, 106, 0))
    # the wings, behind the back: tall columns of feather tiles, the inner ones highest, stepping down and out
    for name, side in (('right_wing', 1), ('left_wing', -1)):
        m.bone(name, (10 * side, 170, 20), 'body')
        cols = 5
        for c in range(cols):
            x = (22 + c * 9) * side
            y_top = top + 22 - c * 16
            y_bot = 120 + c * 8
            m.box(name, x, y_top + 2, 22 + c * 1.5, 9, 6, 3, 'armor')                # the column's lit top
            y = y_top
            row = 0
            while y > y_bot:
                m.box(name, x, y - 6, 22 + c * 1.5 + (row % 2) * 0.6, 9, 12, 2, 'armor' if (row + c) % 5 == 0 else None,
                      rot=(6, 0, -4 * side), pivot=(x, y, 22))
                y -= 9
                row += 1
        m.box(name, 30 * side, top - 4, 21, 46, 4, 4, 'armor', rot=(0, 0, 18 * side), pivot=(10 * side, 170, 21))      # the wing's arm along the top
    if owner == 'obito':
        # the two great Kamui shuriken, one in each fist
        for arm, side in (('right_arm', 1), ('left_arm', -1)):
            hx, hy, hz = 25 * side * k, 106 - 14 * k + 10 * k, -24
            m.box(arm, hx, hy, hz, 12, 12, 5, 'black')                   # the hub
            m.box(arm, hx, hy, hz - 2.8, 4, 4, 1, 'mark')
            for b in range(3):
                a = b * 120 + (15 if side > 0 else -15)
                m.box(arm, hx, hy + 16, hz, 9, 24, 3, 'black', rot=(0, 0, a), pivot=(hx, hy, hz))          # a blade
                # its hooked tip, swept round the way the shuriken turns
                rad = math.radians(a)
                tx, ty = hx - math.sin(rad) * 27, hy + math.cos(rad) * 27
                m.box(arm, tx, ty + 6, hz, 6, 14, 3, 'black', rot=(0, 0, a + 55 * side), pivot=(tx, ty, hz))
    return m


def designs():
    out = {}
    for owner in ('itachi', 'shisui', 'madara', 'obito'):
        out[(owner, 2)] = skeleton(owner)
        out[(owner, 3)] = humanoid(owner)
        out[(owner, 4)] = humanoid(owner, armoured=True)
        out[(owner, 5)] = complete(owner)
    return out
