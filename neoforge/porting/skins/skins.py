"""The story characters' skins, drawn as code: 64x64 player skins (the modern layout, wide or slim arms), painted the way the
good hand-made Naruto skins are:

- every colour is a ramp of tones whose shadows lean cool and highlights warm (not just darker and lighter);
- each face of a box is lit for where it points (tops brightest, the front, then the sides, the back, the bottoms), with a
  soft gradient down every part and shadow where parts meet: under the chin, in the armpits, between the legs;
- clothes have seams, hems, folds at the elbows and knees, pockets and zips; what stands out (vests, collars, cuffs,
  holsters, scarves) is on the outer layer, so it has depth;
- hair is strands in clumps, with a band of shine and dark tips, and its volume stands out on the hat layer with a jagged
  edge, so the silhouette is the character's;
- faces: two-pixel eyes (the white outside, the iris with a dark pupil top and a lit bottom), brows, ears, a nose's shade.

Each character is a function; run `python3 skins.py [sheet.png]` (Pillow) to write textures/entities/story/<id>.png into
both resource trees, and a preview sheet. Coordinates follow the skin layout: every part is a box (w, h, d) whose net starts at
its texture offset: top and bottom on the first d rows, then right, front, left and back side by side."""
import colorsys
import os
import sys
from PIL import Image

HERE = os.path.dirname(os.path.abspath(__file__))
NEO = os.path.normpath(os.path.join(HERE, '..', '..'))
TREES = [os.path.join(NEO, 'src/main/resources'), os.path.join(NEO, 'porting/res_override')]


def _h(x, y, salt):
    v = (x * 73856093) ^ (y * 19349663) ^ (salt * 83492791)
    v = (v ^ (v >> 13)) * 1274126177
    return ((v ^ (v >> 16)) & 0xffffffff) / 0xffffffff


def rgb(h):
    h = h.lstrip('#')
    return (int(h[0:2], 16), int(h[2:4], 16), int(h[4:6], 16), 255)


def tone(c, t):
    """The colour lit by t (about -3 .. 2): brighter and warmer up, darker, more saturated and cooler down."""
    r, g, b = c[0] / 255, c[1] / 255, c[2] / 255
    h, s, v = colorsys.rgb_to_hsv(r, g, b)
    if t >= 0:
        v = v + (1 - v) * 0.18 * t + v * 0.04 * t
        s = s * (1 - 0.09 * t)
        target = 0.14                                  # highlights lean toward yellow
    else:
        v = v * (1 + 0.15 * t)
        s = min(1, s * (1 - 0.07 * t) + (0.04 * -t if s > 0.05 else 0))
        target = 0.68                                  # shadows lean toward blue-violet
    if s > 0.08:
        d = (target - h + 0.5) % 1 - 0.5
        h = (h + d * min(abs(t), 3) * 0.035) % 1
    v = max(0, min(1, v))
    r, g, b = colorsys.hsv_to_rgb(h, max(0, min(1, s)), v)
    return (int(r * 255 + 0.5), int(g * 255 + 0.5), int(b * 255 + 0.5), c[3])


CLEAR = (0, 0, 0, 0)
# box nets: name -> (u, v, w, h, d)
PARTS = {
    'head': (0, 0, 8, 8, 8), 'hat': (32, 0, 8, 8, 8),
    'body': (16, 16, 8, 12, 4), 'jacket': (16, 32, 8, 12, 4),
    'rarm': (40, 16, 4, 12, 4), 'rsleeve': (40, 32, 4, 12, 4),
    'larm': (32, 48, 4, 12, 4), 'lsleeve': (48, 48, 4, 12, 4),
    'rleg': (0, 16, 4, 12, 4), 'rpants': (0, 32, 4, 12, 4),
    'lleg': (16, 48, 4, 12, 4), 'lpants': (0, 48, 4, 12, 4),
}
SLIM = {'rarm', 'rsleeve', 'larm', 'lsleeve'}
OUTER = {'head': 'hat', 'body': 'jacket', 'rarm': 'rsleeve', 'larm': 'lsleeve', 'rleg': 'rpants', 'lleg': 'lpants'}
SIDES = ('front', 'right', 'left', 'back')
# how each face is lit: from above and a little from the front-left
LIGHT = {'top': 1.1, 'front': 0.0, 'left': -0.45, 'right': -0.7, 'back': -0.6, 'bottom': -1.6}


class Skin:
    def __init__(self, slim=False):
        self.im = Image.new('RGBA', (64, 64), CLEAR)
        self.slim = slim

    def faces(self, part):
        """face name -> (x0, y0, w, h) of that face of the part's net."""
        u, v, w, h, d = PARTS[part]
        if self.slim and part in SLIM:
            w = 3
        return {'top': (u + d, v, w, d), 'bottom': (u + d + w, v, w, d), 'right': (u, v + d, d, h),
                'front': (u + d, v + d, w, h), 'left': (u + d + w, v + d, d, h), 'back': (u + 2 * d + w, v + d, w, h)}

    def size(self, part, face):
        return self.faces(part)[face][2:]

    def paint(self, part, fn, only=None):
        """fn(face, x, y, w, h) -> colour or None, for every pixel of the part's faces (x, y inside the face)."""
        for face, (x0, y0, w, h) in self.faces(part).items():
            if only and face not in only:
                continue
            for x in range(w):
                for y in range(h):
                    c = fn(face, x, y, w, h)
                    if c is not None:
                        self.im.putpixel((x0 + x, y0 + y), c)

    def px(self, part, face, x, y, colour):
        x0, y0, w, h = self.faces(part)[face]
        if 0 <= x < w and 0 <= y < h and colour is not None:
            self.im.putpixel((x0 + x, y0 + y), colour)

    def get(self, part, face, x, y):
        x0, y0, w, h = self.faces(part)[face]
        return self.im.getpixel((x0 + x, y0 + y)) if 0 <= x < w and 0 <= y < h else None

    def save(self, name):
        for t in TREES:
            d = os.path.join(t, 'assets/naruto_shippuden/textures/entities/story')
            os.makedirs(d, exist_ok=True)
            self.im.save(os.path.join(d, name + '.png'))


def outer_edge(face, x, w):
    """The columns of a side face that border the next face (for the edge's shade)."""
    return face in SIDES and (x == 0 or x == w - 1)


# ---------------------------------------------------------------- cloth, skin: the materials

def cloth(s, part, base, rows=None, only=None, salt=0, rough=0.5, grad=0.9, edge=0.25, ao_top=0.0, inner=None):
    """A material over the part's faces, lit per face, with a gradient down it (grad), darker edges (edge), a sparse grain
    (rough), shadow along the top row (ao_top: under the head, a collar) and on the inner side (inner: 'left'/'right', the
    face toward the body). rows = (from, to) limits it to a band of the side faces (tops and bottoms only when it reaches)."""
    salt += sum(map(ord, part)) * 7

    def fn(face, x, y, w, h):
        if face == 'top' and rows is not None and rows[0] > 0:
            return None
        if face == 'bottom' and rows is not None and rows[1] < PARTS[part][3]:
            return None
        if face in SIDES and rows is not None and not rows[0] <= y < rows[1]:
            return None
        t = LIGHT[face]
        if face in SIDES:
            t += grad * (0.5 - y / max(1, h - 1))
            if outer_edge(face, x, w):
                t -= edge
            if ao_top and y == 0:
                t -= ao_top
            if inner and face == inner:
                t -= 0.35
        elif face == 'top':
            t -= 0.25 * (x in (0, w - 1)) + 0.25 * (y in (0, h - 1))
        # the grain in clumps, as vanilla's textures are: patches two or three pixels across a little lighter or darker,
        # and a few single pixels
        k = sum(map(ord, face))
        clump = _h((x + (y % 2)) // 2, y // 2, salt + k) - 0.5
        t += clump * 0.7 * rough * 2
        v = _h(x, y, salt + k + 1)
        if v < 0.12 * rough:
            t -= 0.35
        elif v > 1 - 0.08 * rough:
            t += 0.3
        return tone(base, t)
    s.paint(part, fn, only)


def skin_fill(s, part, colour, only=None):
    cloth(s, part, colour, only=only, rough=0.12, grad=0.5, edge=0.15, salt=3)


def ring(s, part, rows, colour, t=0.0, faces=SIDES):
    """A band round the part (a belt, a cuff, a strap): lit per face, its top row catching the light."""
    rows = list(rows)

    def fn(face, x, y, w, h):
        if face in faces and y in rows:
            k = LIGHT[face] + t - (0.3 if outer_edge(face, x, w) else 0)
            if len(rows) > 1:
                k += 0.35 if y == rows[0] else -0.25 if y == rows[-1] else 0
            return tone(colour, k)
        return None
    s.paint(part, fn)


def hem(s, part, row, base, faces=SIDES):
    """A darker seam row where a garment ends (lit per face)."""
    s.paint(part, lambda f, x, y, w, h: tone(base, LIGHT[f] - 0.9) if f in faces and y == row else None)


def fold(s, part, face, pts, base, depth=0.7):
    """Creases: darker pixels, each with a lit pixel above it (the cloth's ridge)."""
    for (x, y) in pts:
        s.px(part, face, x, y, tone(base, LIGHT[face] - depth))
        if y > 0:
            c = s.get(part, face, x, y - 1)
            if c is not None and c[3] > 0:
                s.px(part, face, x, y - 1, tone(base, LIGHT[face] + 0.35))


def bandage(s, part, rows, outer=True, base=rgb('#ECE8DE')):
    """White wraps round a limb, wound diagonally (on the outer layer, so they stand out)."""
    p = OUTER[part] if outer else part
    rows = list(rows)

    def fn(face, x, y, w, h):
        if face in SIDES and y in rows:
            k = LIGHT[face] * 0.6 - (0.3 if outer_edge(face, x, w) else 0)
            if (x + y) % 3 == 0:
                k -= 0.55                                   # the edge of each turn
            return tone(base, k)
        return None
    s.paint(p, fn)


def sandals(s, colour=rgb('#2E3A70'), skin=None, wrap=True, high=2):
    """Shinobi sandals: the sole and straps in blue, the toes out at the front, the heel open; a white wrap at the ankle."""
    for l in ('rleg', 'lleg'):
        def fn(face, x, y, w, h):
            if face == 'bottom':
                return tone(colour, -1.2)
            if face not in SIDES or y < 12 - high:
                return None
            k = LIGHT[face] + (0.3 if y == 12 - high else -0.2)
            if face == 'front' and y == 11 and x in (1, 2) and skin:
                return tone(skin, 0.1 if x == 1 else -0.1)   # the toes
            if face == 'back' and y == 12 - high and x in (1, 2) and skin:
                return tone(skin, -0.5)                      # the open heel
            return tone(colour, k - (0.25 if outer_edge(face, x, w) else 0))
        s.paint(l, fn)
        if wrap:
            bandage(s, l, [12 - high - 1], outer=False)


# ---------------------------------------------------------------- bodies

def torso(s, base, salt=0):
    cloth(s, 'body', base, salt=salt, ao_top=0.55)
    # shadow under the arms down the sides
    s.paint('body', lambda f, x, y, w, h: tone(base, LIGHT[f] - 0.5) if f in ('front', 'back') and x in (0, w - 1) and 1 <= y <= 3 else None)


def hand(s, arm, skin):
    """The hand: the last row a touch darker, the bottom (the palm's end) darkest."""
    s.paint(arm, lambda f, x, y, w, h: tone(skin, LIGHT[f] - 0.3) if f in SIDES and y == 11 else None)
    s.paint(arm, lambda f, x, y, w, h: tone(skin, -1.0) if f == 'bottom' else None)


def sleeves(s, base, skin, rows=12, cuff=None, crease=True):
    """Sleeves to `rows`, bare arm below; the inner face toward the body darker; a crease at the elbow."""
    for a, inner in (('rarm', 'left'), ('larm', 'right')):
        skin_fill(s, a, skin)
        s.paint(a, lambda f, x, y, w, h: tone(skin, LIGHT[f] - 0.4) if f == inner else None)
        hand(s, a, skin)
        if rows > 0:
            cloth(s, a, base, rows=(0, rows), inner=inner, salt=5)
            if rows < 12:
                hem(s, a, rows - 1, cuff or base)
            if crease and rows >= 7:
                w = s.size(a, 'front')[0]
                fold(s, a, 'front', [(0, 5), (w - 1, 6)], base)
                fold(s, a, 'right' if a == 'rarm' else 'left', [(1, 6), (2, 5)], base)


def trousers(s, base, skin=None, rows=12, salt=0, knee=True):
    """Trousers to `rows` (shorts or rolled legs), bare leg below; shadow between the legs and under the body; creases."""
    for l, inner in (('rleg', 'left'), ('lleg', 'right')):
        if skin:
            skin_fill(s, l, skin)
            s.paint(l, lambda f, x, y, w, h: tone(skin, LIGHT[f] - 0.35) if f == inner else None)
        cloth(s, l, base, rows=(0, rows), inner=inner, ao_top=0.5, salt=salt + 11)
        if rows < 12:
            hem(s, l, rows - 1, base)
        if knee and rows >= 8:
            fold(s, l, 'front', [(1, 6), (2, 7)], base, 0.55)
        if rows >= 10:
            fold(s, l, 'front', [(0, rows - 2), (3, rows - 2)], base, 0.5)


def holster(s, leg='rleg', pouch_c=rgb('#3A3A44'), rows=(1, 3)):
    """The kunai holster on the thigh, on the outer layer: one white strap round the leg, the pouch on its outer side."""
    bandage(s, leg, [rows[0] + 1])
    p = OUTER[leg]
    side = 'right' if leg == 'rleg' else 'left'
    for y in range(rows[0], rows[1] + 1):
        for x in (1, 2):
            s.px(p, side, x, y, tone(pouch_c, (0.5 if y == rows[0] else -0.1) + LIGHT[side]))
    s.px(p, side, 1, rows[1] + 1, tone(pouch_c, -0.8))


def pouch(s, colour=rgb('#6B4A30')):
    """The tool pouch on the back of the belt."""
    for x in (3, 4):
        for y in (9, 10):
            s.px('jacket', 'back', x, y, tone(colour, 0.3 if y == 9 else -0.3))
    s.px('jacket', 'back', 2, 10, tone(colour, -0.6)); s.px('jacket', 'back', 5, 10, tone(colour, -0.6))


def collar(s, colour, rows=(0,), faces=SIDES, top=True):
    """A collar (or scarf) round the neck on the outer layer: lit, its rim on the jacket's top face round the neck hole."""
    rows = list(rows)
    s.paint('jacket', lambda f, x, y, w, h: tone(colour, LIGHT[f] * 0.6 + (0.35 if y == rows[0] else -0.25)) if f in faces and y in rows else None)
    if top:
        s.paint('jacket', lambda f, x, y, w, h: (tone(colour, 1.0) if (x in (0, w - 1) or y in (0, h - 1)) else CLEAR) if f == 'top' else None)


def flak_vest(s, vest=rgb('#5E7050'), shirt=rgb('#26304E')):
    """The Leaf's chunin and jonin vest over the long-sleeved shirt: the thick collar and the scroll pockets stand out on the
    outer layer, the red swirl on the back."""
    torso(s, shirt)
    cloth(s, 'jacket', vest, rows=(0, 11), salt=21, rough=0.4)
    s.paint('jacket', lambda f, x, y, w, h: CLEAR if f in ('left', 'right') and 1 <= y <= 4 and x in (1, 2) else None)   # open under the arms
    s.paint('jacket', lambda f, x, y, w, h: CLEAR if f == 'bottom' or (f in SIDES and y == 11) else None)
    collar(s, vest)
    # the front: the zip down the middle, two rows of scroll pockets each side
    for y in range(1, 10):
        s.px('jacket', 'front', 3, y, tone(vest, -1.0))
        s.px('jacket', 'front', 4, y, tone(vest, -0.2))
    for (x0, y0) in ((0, 2), (5, 2), (0, 5), (5, 5)):
        for x in range(x0, x0 + 3):
            s.px('jacket', 'front', x, y0, tone(vest, 0.6))          # the pocket's lit flap
            s.px('jacket', 'front', x, y0 + 1, tone(vest, -0.1))
            s.px('jacket', 'front', x, y0 + 2, tone(vest, -0.9))     # its shadow
    ring(s, 'jacket', [9, 10], tone(vest, -0.4))                     # the waist band
    swirl = rgb('#B8322E')
    for (x, y) in ((3, 3), (4, 3), (5, 4), (5, 5), (4, 6), (3, 6), (2, 5), (3, 5), (4, 4)):
        s.px('jacket', 'back', x, y, tone(swirl, -0.1 if (x + y) % 2 else 0.1))


def swirl_patch(s, colour=rgb('#B8322E'), row=1):
    """The red swirl patches on the shirt's upper arms (Leaf shinobi uniform), standing out on the sleeve layer."""
    for a, side in (('rsleeve', 'right'), ('lsleeve', 'left')):
        w = s.size(a, side)[0]
        for x in range(w):
            for y in (row, row + 1):
                s.px(a, side, x, y, tone(colour, LIGHT[side] + (0.3 if y == row else -0.2)))
        s.px(a, side, 1, row, tone(colour, 0.9))


# ---------------------------------------------------------------- heads

SKIN = rgb('#F3C8A2')
EYE_DARK = rgb('#2A2A36')
WHITE = rgb('#F4F4F2')


def head(s, skin=SKIN):
    """The bare head: skin lit per face, ears on the sides, the jaw's shade, the nose's, the neck's shadow under it."""
    skin_fill(s, 'head', skin)
    for side, x, out in (('right', 4, 5), ('left', 3, 2)):
        s.px('head', side, x, 4, tone(skin, LIGHT[side] - 0.15))
        s.px('head', side, x, 5, tone(skin, LIGHT[side] - 0.6))
        s.px('head', side, out, 5, tone(skin, LIGHT[side] - 0.3))
    for x in range(8):
        s.px('head', 'front', x, 7, tone(skin, -0.3))
    s.px('head', 'front', 0, 7, tone(skin, -0.6)); s.px('head', 'front', 7, 7, tone(skin, -0.6))
    s.px('head', 'front', 4, 6, tone(skin, -0.25))
    s.paint('head', lambda f, x, y, w, h: tone(skin, -1.3) if f == 'bottom' else None)


def eyes(s, iris, brows=None, lashes=None, pale=False, sclera=WHITE, row=4):
    """Two-pixel eyes: the white outside, the iris inside (a dark pupil at the top, the colour lit below), a brow above.
    pale: the Byakugan at rest (pale lavender, no pupil)."""
    for x, outer in ((1, True), (2, False), (5, False), (6, True)):
        if pale:
            s.px('head', 'front', x, row, tone(rgb('#F2EEF8'), 0.3 if outer else 0))
            s.px('head', 'front', x, row + 1, tone(rgb('#DCD4EE'), 0 if outer else -0.3))
        elif outer:
            s.px('head', 'front', x, row, sclera)
            s.px('head', 'front', x, row + 1, tone(sclera, -0.35))
        else:
            s.px('head', 'front', x, row, tone(iris, -1.6))
            s.px('head', 'front', x, row + 1, tone(iris, 0.6))
    if brows:
        for x in (1, 2, 5, 6):
            s.px('head', 'front', x, row - 1, brows)
    if lashes:
        s.px('head', 'front', 0, row, lashes); s.px('head', 'front', 7, row, lashes)


def blush(s, colour=rgb('#F0A0A0'), row=6):
    s.px('head', 'front', 1, row, tone(colour, 0.1)); s.px('head', 'front', 6, row, tone(colour, 0.1))


def hair(s, base, front, side, back, hat_front=None, hat_side=None, hat_back=None, salt=1, shine=True, crown=True, cape=0,
         width=3):
    """Hair as strands, the way the good hair sheets paint it: regular strands `width` pixels apart with a darker line between
    them, a smooth gradient from the roots (light) to the tips (dark), a band of sheen across near the top, and the tips
    rounded off. front: rows of hair per column of the face (8); side: rows per column of the side faces, from the back of the
    head to the front (8); back: rows per column of the back. The hat layer carries the hair's volume over all of it (hat_front,
    hat_side, hat_back the same way; None: nothing there), a shade lighter, while the head layer under it is the shadow
    side. cape: rows the hair falls below the head down the back (on the body's outer layer)."""
    def strand(face, x, y, depth, layer, y0=0):
        k = (x + salt + (1 if face in ('left', 'back') else 0)) % width
        t = (0.3, 0.05, -0.15, 0.0)[k] if k < width - 1 else -0.55        # the strand, and the dark line between strands
        yy = y + y0
        span = max(1, depth + y0 - 1)
        t += 0.55 - 1.0 * yy / span                                     # roots light, tips dark
        if shine and yy in (1, 2) and k < width - 1 and face != 'back':
            t += 0.45 if yy == 1 else 0.2                              # the sheen
        if y == depth - 1 and depth > 1:
            t -= 0.25                                                   # the tip
        t += LIGHT[face] * 0.4 + (0.12 if layer else -0.25)
        return tone(base, t)

    def draw(part, fr, sd, bk, layer):
        if fr is not None:
            s.paint(part, lambda f, x, y, w, h: strand(f, x, y, fr[x], layer) if f == 'front' and y < fr[x] else None)
        if sd is not None:
            # the right face's columns run back to front; the left face's front to back
            s.paint(part, lambda f, x, y, w, h: strand(f, x, y, sd[x], layer) if f == 'right' and y < sd[x] else None)
            s.paint(part, lambda f, x, y, w, h: strand(f, x, y, sd[7 - x], layer) if f == 'left' and y < sd[7 - x] else None)
        if bk is not None:
            s.paint(part, lambda f, x, y, w, h: strand(f, x, y, bk[x], layer) if f == 'back' and y < bk[x] else None)

    def top(f, x, y, w, h, layer):
        """The crown: strands running from the front to the back, lit."""
        if f != 'top':
            return None
        k = (x + salt) % width
        t = (0.4, 0.1, -0.1, 0.05)[k] if k < width - 1 else -0.45
        t += 0.5 - 0.1 * y + (0.1 if layer else -0.25)
        if y in (2, 3) and k < width - 1:
            t += 0.25                                                   # the crown's sheen
        return tone(base, t)
    draw('head', front, side, back, 0)
    s.paint('head', lambda f, x, y, w, h: top(f, x, y, w, h, 0))
    if crown and (hat_front is not None or hat_side is not None or hat_back is not None):
        s.paint('hat', lambda f, x, y, w, h: top(f, x, y, w, h, 1))
    draw('hat', hat_front, hat_side, hat_back, 1)
    if cape:
        # the hair falling down the back, below the head
        s.paint('jacket', lambda f, x, y, w, h: strand('back', x, y, cape, 1, y0=8) if f == 'back' and y < cape - (1 if x in (0, 7) else 0) else None)
        s.paint('jacket', lambda f, x, y, w, h: strand(f, x, y, 2, 1, y0=8) if f in ('left', 'right') and y < 2 and x >= 2 else None)


def headband_painted(s, part='hat', row=2, cloth_c=rgb('#24305A'), metal=rgb('#C2C8D0')):
    """A forehead protector drawn on (for one worn where no item can go: round the neck)."""
    s.paint(part, lambda f, x, y, w, h: tone(cloth_c, LIGHT[f] * 0.5 + (0.2 if y == row else -0.3)) if f in ('left', 'right', 'back') and y in (row, row + 1) else None)
    for x in range(1, 7):
        for y in (row, row + 1):
            s.px(part, 'front', x, y, tone(metal, 0.4 if y == row else -0.2))
    s.px(part, 'front', 3, row, tone(metal, -1.0)); s.px(part, 'front', 4, row + 1, tone(metal, -1.0)); s.px(part, 'front', 3, row + 1, tone(metal, -0.8))
    for x in (0, 7):
        s.px(part, 'front', x, row, tone(cloth_c, 0)); s.px(part, 'front', x, row + 1, tone(cloth_c, -0.3))


def goggles(s, strap=rgb('#3E7A40'), lens=rgb('#7FC8E8'), row=1):
    """Naruto's Academy goggles, up on his forehead (hat layer, so they stand out of the hair)."""
    s.paint('hat', lambda f, x, y, w, h: tone(strap, LIGHT[f] * 0.6 + (0.25 if y == row else -0.35)) if f in ('left', 'right', 'back') and y in (row, row + 1) else None)
    for x in range(8):
        for y in (row, row + 1):
            c = tone(lens, 0.6 if y == row else -0.2) if x in (1, 2, 5, 6) else tone(strap, 0.2 if y == row else -0.4)
            s.px('hat', 'front', x, y, c)
    s.px('hat', 'front', 1, row, WHITE); s.px('hat', 'front', 5, row, WHITE)   # glints


# ---------------------------------------------------------------- the characters

def naruto(genin=False):
    """Part 1 Naruto: spiky blond hair, blue eyes, whiskers; the orange tracksuit with the navy shoulders, the white collar
    and zip, the red swirl on the back; the holster on his right thigh; the Academy's goggles (as a genin he wears the
    headband instead: the item)."""
    s = Skin()
    blond, eye, orange, navy = rgb('#F6C838'), rgb('#3A7FE0'), rgb('#F27A1A'), rgb('#25305E')
    head(s)
    eyes(s, eye, brows=tone(blond, -1.2))
    for (x, y) in ((0, 5), (1, 6), (6, 6), (7, 5)):
        s.px('head', 'front', x, y, tone(SKIN, -1.1))        # the whisker marks
    hair(s, blond, front=[3, 2, 3, 2, 3, 2, 3, 3], side=[7, 6, 6, 5, 5, 4, 3, 3], back=[7, 6, 7, 6, 7, 6, 7, 6],
         hat_front=[3, 1, 3, 1, 2, 1, 3, 3], hat_side=[6, 5, 6, 4, 5, 3, 3, 3], hat_back=[7, 5, 7, 5, 7, 5, 7, 5], salt=3, width=2)
    if not genin:
        goggles(s)
    torso(s, orange)
    cloth(s, 'body', navy, rows=(0, 3), salt=2)              # the navy across the shoulders and upper back
    cloth(s, 'body', navy, only=('top',), salt=2)
    s.paint('body', lambda f, x, y, w, h: tone(navy, LIGHT[f] - 0.8) if f in SIDES and y == 3 else None)
    collar(s, WHITE)
    for y in range(1, 11):
        s.px('body', 'front', 4, y, tone(orange, -0.9 if y > 2 else -0.3))
    s.px('body', 'front', 4, 3, WHITE); s.px('body', 'front', 4, 4, tone(WHITE, -0.4))   # the zip's pull
    for (x, y) in ((3, 4), (4, 4), (5, 5), (5, 6), (4, 7), (3, 7), (2, 6), (3, 6), (4, 5)):
        s.px('body', 'back', x, y, tone(rgb('#C8322C'), 0 if (x + y) % 2 else -0.3))   # the swirl on the back
    ring(s, 'body', [10, 11], orange, -0.3)
    fold(s, 'body', 'front', [(1, 7), (6, 8), (2, 9)], orange, 0.55)
    sleeves(s, orange, SKIN, rows=11, cuff=orange)
    for a in ('rarm', 'larm'):
        cloth(s, a, navy, rows=(0, 3), salt=4)
        s.paint(a, lambda f, x, y, w, h: tone(navy, LIGHT[f] - 0.8) if f in SIDES and y == 3 else None)
        ring(s, a, [10], orange, -0.2)
    trousers(s, orange, skin=SKIN, rows=9)
    ring(s, 'rleg', [8], orange, 0.2); ring(s, 'lleg', [8], orange, 0.2)   # rolled up above the ankles
    holster(s, 'rleg')
    sandals(s, skin=SKIN, wrap=False)
    return s


def naruto_genin():
    return naruto(genin=True)


def sasuke():
    """Sasuke: blue-black hair spiked out at the back, the navy high-collar shirt with the Uchiha fan on the back, white arm
    warmers, white shorts, the holster on his right thigh."""
    s = Skin()
    hair_c, navy = rgb('#1E2236'), rgb('#22305E')
    head(s)
    eyes(s, EYE_DARK, brows=tone(hair_c, -0.5))
    hair(s, hair_c, front=[6, 3, 2, 4, 2, 3, 3, 6], side=[8, 8, 7, 7, 6, 6, 5, 7], back=[8, 8, 8, 8, 8, 8, 8, 8],
         hat_front=[6, 2, 1, 3, 1, 2, 2, 6], hat_side=[8, 7, 7, 6, 5, 4, 4, 6], hat_back=[8, 7, 8, 7, 8, 7, 8, 7], salt=9)
    torso(s, navy)
    # the high collar standing up behind the neck (outer layer), open in front
    collar(s, navy, faces=('left', 'right', 'back'))
    s.px('body', 'front', 3, 0, tone(SKIN, -0.4)); s.px('body', 'front', 4, 0, tone(SKIN, -0.4))
    for (x, y, c, t) in ((3, 3, '#D03030', 0.2), (4, 3, '#D03030', 0.2), (2, 4, '#D03030', 0), (3, 4, '#D03030', 0), (4, 4, '#D03030', 0),
                         (5, 4, '#D03030', -0.2), (2, 5, '#F2F2F0', 0), (3, 5, '#F2F2F0', 0), (4, 5, '#F2F2F0', -0.2), (5, 5, '#F2F2F0', -0.4),
                         (3, 6, '#F2F2F0', -0.3), (4, 6, '#F2F2F0', -0.5), (3, 7, '#9A9A9A', 0), (4, 7, '#9A9A9A', -0.3)):
        s.px('body', 'back', x, y, tone(rgb(c), t))          # the fan: red over white
    fold(s, 'body', 'front', [(2, 7), (5, 8)], navy, 0.5)
    hem(s, 'body', 11, navy)
    sleeves(s, navy, SKIN, rows=3)
    for a in ('rarm', 'larm'):
        bandage(s, a, range(6, 11))                          # the arm warmers
    trousers(s, rgb('#E8E8E4'), skin=SKIN, rows=7)
    holster(s, 'rleg', rows=(3, 5))
    sandals(s, skin=SKIN)
    return s


def sakura():
    """Sakura: long pink hair with the red ribbon, the red qipao with the white circle on the back, dark green shorts."""
    s = Skin(slim=True)
    pink, red, green = rgb('#F4A6BE'), rgb('#C83632'), rgb('#3E6A42')
    head(s)
    eyes(s, rgb('#3FA060'), lashes=tone(pink, -2), brows=tone(pink, -0.8))
    blush(s)
    hair(s, pink, front=[8, 3, 2, 2, 1, 2, 3, 8], side=[8, 8, 8, 8, 8, 8, 8, 8], back=[8, 8, 8, 8, 8, 8, 8, 8],
         hat_front=[8, 2, 1, 0, 0, 1, 2, 8], hat_side=[8, 8, 8, 8, 8, 7, 8, 8], hat_back=[8, 8, 8, 8, 8, 8, 8, 8], salt=17, cape=3)
    # the ribbon round her head
    s.paint('hat', lambda f, x, y, w, h: tone(red, LIGHT[f] * 0.5 + 0.3) if f in SIDES and y == 1 and not (f == 'front' and x in (0, 7)) else None)
    s.px('hat', 'right', 2, 2, tone(red, -0.4)); s.px('hat', 'right', 3, 2, tone(red, -0.2))
    torso(s, red)
    for side in ('front', 'back'):                           # the hair over the shoulders
        for x in (0, 7):
            s.px('jacket', side, x, 0, tone(pink, -0.3)); s.px('jacket', side, x, 1, tone(pink, -0.8))
    for x in (2, 3, 4, 5):
        s.px('body', 'front', x, 0, tone(WHITE, -0.2))       # the white collar
    for (x, y) in ((3, 3), (4, 3), (2, 4), (5, 4), (2, 5), (5, 5), (3, 6), (4, 6)):
        s.px('body', 'back', x, y, tone(WHITE, -0.3))        # the circle on the back
    ring(s, 'body', [8], tone(red, -0.4))
    # the dress's skirt over the shorts, on the outer layer, slit at the sides
    cloth(s, 'jacket', red, rows=(9, 12), only=SIDES, salt=8)
    s.paint('jacket', lambda f, x, y, w, h: CLEAR if f in ('left', 'right') and y >= 10 and x in (1, 2) else None)
    hem(s, 'jacket', 11, red, faces=('front', 'back'))
    sleeves(s, red, SKIN, rows=2)
    for a in ('rarm', 'larm'):
        bandage(s, a, range(7, 10))                          # elbow pads
    trousers(s, green, skin=SKIN, rows=6, knee=False)
    holster(s, 'rleg', rows=(3, 4))
    sandals(s, skin=SKIN)
    return s


def shikamaru():
    """Shikamaru: the pineapple ponytail, earrings, the open grey jacket over the mesh shirt, brown trousers."""
    s = Skin()
    hair_c, mesh, jacket, brown = rgb('#24242A'), rgb('#4E4C48'), rgb('#7E786C'), rgb('#6A4E34')
    head(s)
    eyes(s, EYE_DARK, brows=tone(hair_c, 0))
    s.px('head', 'front', 1, 4, tone(SKIN, -0.4)); s.px('head', 'front', 6, 4, tone(SKIN, -0.4))   # half-lidded, bored
    hair(s, hair_c, front=[3, 2, 1, 1, 1, 1, 2, 3], side=[5, 5, 4, 4, 3, 3, 3, 3], back=[5, 5, 5, 5, 5, 5, 5, 5],
         hat_front=[1, 0, 0, 0, 0, 0, 0, 1], hat_side=[4, 4, 3, 3, 2, 2, 2, 2], hat_back=[4, 4, 5, 6, 6, 5, 4, 4], salt=23)
    for (x, y) in ((3, 0), (4, 0), (2, 1), (3, 1), (4, 1), (5, 1), (3, 2), (4, 2)):
        s.px('hat', 'top', x, y, tone(hair_c, 0.6 if (x + y) % 2 else 0.1))   # the ponytail, up on top
    for x in (3, 4):
        s.px('hat', 'back', x, 0, tone(hair_c, 0.5))
    s.px('head', 'left', 3, 6, rgb('#D8C060')); s.px('head', 'right', 4, 6, rgb('#D8C060'))   # earrings
    torso(s, mesh)
    s.paint('body', lambda f, x, y, w, h: tone(mesh, 0.6) if f == 'front' and (x + y) % 2 == 0 and y < 10 else None)
    cloth(s, 'jacket', jacket, salt=4)
    s.paint('jacket', lambda f, x, y, w, h: CLEAR if (f == 'front' and 2 <= x <= 5) or f in ('top', 'bottom') else None)
    s.paint('jacket', lambda f, x, y, w, h: tone(brown, LIGHT[f]) if f == 'front' and x in (1, 6) else None)   # the trim
    sleeves(s, jacket, SKIN, rows=6, cuff=brown)
    trousers(s, brown, skin=SKIN, rows=10)
    holster(s, 'rleg')
    sandals(s, skin=SKIN)
    return s


def ino():
    """Ino: the long blonde ponytail and the fringe over one eye, the purple top and skirt, wraps on her arms and legs."""
    s = Skin(slim=True)
    blonde, purple = rgb('#F4E4A0'), rgb('#7A3E92')
    head(s)
    eyes(s, rgb('#58A8D8'), lashes=tone(blonde, -2.2), brows=tone(blonde, -1))
    blush(s)
    hair(s, blonde, front=[7, 6, 6, 2, 1, 1, 2, 5], side=[8, 8, 7, 6, 6, 6, 7, 7], back=[8, 8, 8, 8, 8, 8, 8, 8],
         hat_front=[7, 6, 6, 3, 0, 0, 1, 4], hat_side=[7, 6, 5, 4, 4, 4, 5, 6], hat_back=[7, 7, 8, 8, 8, 8, 7, 7], salt=29)
    torso(s, purple)
    for y in range(0, 9):                                    # the ponytail down her back
        for x in (3, 4):
            s.px('jacket', 'back', x, y, tone(blonde, 0.3 - y * 0.12 - (0.3 if x == 4 else 0)))
    s.px('body', 'front', 3, 0, tone(SKIN, -0.3)); s.px('body', 'front', 4, 0, tone(SKIN, -0.3))
    ring(s, 'body', [7], tone(purple, -0.5))
    fold(s, 'body', 'front', [(2, 4), (5, 5)], purple, 0.5)
    cloth(s, 'jacket', purple, rows=(8, 12), only=SIDES, salt=6)   # the skirt
    hem(s, 'jacket', 11, purple)
    sleeves(s, purple, SKIN, rows=2)
    for a in ('rarm', 'larm'):
        bandage(s, a, range(5, 10))
    trousers(s, purple, skin=SKIN, rows=3, knee=False)
    for l in ('rleg', 'lleg'):
        bandage(s, l, range(3, 9))
    sandals(s, skin=SKIN, wrap=False)
    return s


def choji():
    """Choji: spiky brown hair, the swirls on his cheeks, the white scarf, the green coat with the kanji for food."""
    s = Skin()
    hair_c, green, white = rgb('#8A5228'), rgb('#3E7C3C'), rgb('#F0EEE8')
    head(s)
    eyes(s, EYE_DARK, brows=tone(hair_c, -0.6))
    for (x, y) in ((0, 6), (1, 6), (6, 6), (7, 6)):
        s.px('head', 'front', x, y, tone(rgb('#D04848'), 0 if x in (0, 7) else 0.3))
    hair(s, hair_c, front=[3, 2, 2, 1, 1, 2, 2, 3], side=[6, 6, 5, 5, 4, 4, 3, 3], back=[6, 7, 6, 7, 6, 7, 6, 7],
         hat_front=[2, 0, 1, 0, 0, 1, 0, 2], hat_side=[5, 5, 4, 4, 3, 3, 2, 2], hat_back=[6, 5, 6, 5, 6, 5, 6, 5], salt=31, width=2)
    torso(s, green)
    collar(s, white, rows=(0, 1))
    for (x, y, t) in ((3, 4, 0.4), (4, 4, 0.2), (2, 5, 0.2), (5, 5, -0.2), (3, 6, 0), (4, 6, -0.3)):
        s.px('body', 'front', x, y, tone(rgb('#E8C840'), t))
    s.px('body', 'front', 3, 5, rgb('#6A3A1A')); s.px('body', 'front', 4, 5, tone(rgb('#6A3A1A'), -0.2))
    ring(s, 'body', [9, 10], rgb('#6A6670'))                  # the sash
    sleeves(s, green, SKIN, rows=5)
    for a in ('rarm', 'larm'):
        cloth(s, a, rgb('#5A5A60'), rows=(7, 11), salt=2)    # arm guards
    trousers(s, rgb('#5E5E68'), skin=SKIN, rows=9)
    holster(s, 'rleg')
    sandals(s, skin=SKIN)
    return s


def hinata():
    """Hinata: short indigo hair with long locks framing her face, the resting Byakugan, the cream hooded jacket with the
    purple trim and fur collar, navy trousers."""
    s = Skin(slim=True)
    hair_c, coat, trim = rgb('#2A2C5A'), rgb('#DCD2E8'), rgb('#7C5CA0')
    head(s)
    eyes(s, None, pale=True, lashes=tone(hair_c, -0.5), brows=tone(hair_c, 0.2))
    blush(s)
    hair(s, hair_c, front=[8, 3, 3, 3, 3, 3, 3, 8], side=[6, 6, 6, 6, 6, 7, 8, 8], back=[6, 6, 6, 6, 6, 6, 6, 6],
         hat_front=[8, 2, 2, 2, 2, 2, 2, 8], hat_side=[6, 6, 5, 5, 5, 6, 8, 8], hat_back=[6, 6, 6, 6, 6, 6, 6, 6], salt=37)
    torso(s, coat)
    cloth(s, 'jacket', coat, salt=12, rough=0.3)
    s.paint('jacket', lambda f, x, y, w, h: CLEAR if f in ('top', 'bottom') else None)
    s.paint('jacket', lambda f, x, y, w, h: tone(coat, LIGHT[f] + 0.4) if f == 'back' and y < 3 else None)   # the hood, down
    s.paint('jacket', lambda f, x, y, w, h: tone(trim, LIGHT[f] + 0.2) if f == 'back' and y == 3 else None)
    for y in range(12):
        s.px('jacket', 'front', 3, y, tone(trim, 0.1)); s.px('jacket', 'front', 4, y, tone(coat, -0.6))
    ring(s, 'jacket', [11], trim)
    collar(s, rgb('#E6DEF2'), top=False)                      # the fur collar
    for x in (0, 7):                                          # her locks over it
        s.px('jacket', 'front', x, 0, tone(hair_c, 0.2)); s.px('jacket', 'front', x, 1, tone(hair_c, -0.4))
    sleeves(s, coat, SKIN, rows=11, cuff=trim)
    for a in ('rarm', 'larm'):
        ring(s, a, [10], trim)
    trousers(s, rgb('#2E3054'), skin=SKIN, rows=10)
    holster(s, 'rleg')
    sandals(s, skin=SKIN)
    return s


def kiba():
    """Kiba: wild brown hair, the red Inuzuka fangs on his cheeks, the grey coat with the fur-lined hood down his back."""
    s = Skin()
    hair_c, coat, fur = rgb('#5A3A22'), rgb('#7C7C84'), rgb('#ECE6DA')
    head(s)
    eyes(s, rgb('#3A2A22'), brows=tone(hair_c, -0.4))
    for (x, y) in ((1, 6), (6, 6), (1, 7), (6, 7)):
        s.px('head', 'front', x, y, tone(rgb('#C42A2A'), 0.1 if y == 6 else -0.2))
    hair(s, hair_c, front=[3, 2, 3, 2, 2, 3, 2, 3], side=[6, 6, 5, 5, 4, 4, 3, 3], back=[6, 7, 6, 7, 6, 7, 6, 7],
         hat_front=[3, 1, 2, 0, 1, 2, 1, 3], hat_side=[6, 5, 5, 4, 4, 3, 3, 3], hat_back=[7, 5, 7, 5, 7, 5, 7, 5], salt=41, width=2)
    torso(s, coat)
    cloth(s, 'jacket', coat, salt=14)
    s.paint('jacket', lambda f, x, y, w, h: CLEAR if f in ('top', 'bottom') else None)
    s.paint('jacket', lambda f, x, y, w, h: tone(fur, LIGHT[f] + (0.4 if (x + y) % 2 else 0.1)) if f in SIDES and y == 0 else None)
    s.paint('jacket', lambda f, x, y, w, h: tone(fur, LIGHT[f] + (0.3 if (x + y) % 2 else -0.1)) if f == 'back' and y in (1, 2) else None)
    for y in range(1, 12):
        s.px('jacket', 'front', 4, y, tone(coat, -1.0))
    for x0 in (1, 5):
        for x in (x0, x0 + 1):
            s.px('jacket', 'front', x, 7, tone(coat, 0.5)); s.px('jacket', 'front', x, 8, tone(coat, -0.8))
    sleeves(s, coat, SKIN, rows=11, cuff=fur)
    for a in ('rarm', 'larm'):
        ring(s, a, [10], fur)
    trousers(s, rgb('#383844'), skin=SKIN, rows=10)
    holster(s, 'rleg')
    sandals(s, skin=SKIN)
    return s


def shino():
    """Shino: round dark glasses, the high collar up over his mouth, the long grey-green coat."""
    s = Skin()
    hair_c, coat, dark = rgb('#3A2C22'), rgb('#7C887A'), rgb('#16161E')
    head(s)
    for x in range(0, 8):
        s.px('head', 'front', x, 4, tone(dark, 0))
        if 1 <= x <= 6:
            s.px('head', 'front', x, 5, tone(dark, -0.2))
    s.px('head', 'front', 1, 4, rgb('#6A7A90')); s.px('head', 'front', 5, 4, rgb('#6A7A90'))   # glints
    hair(s, hair_c, front=[3, 3, 3, 2, 2, 3, 3, 3], side=[5, 5, 4, 4, 3, 3, 3, 3], back=[5, 6, 5, 6, 5, 6, 5, 6],
         hat_front=[2, 1, 2, 1, 1, 2, 1, 2], hat_side=[5, 4, 4, 3, 3, 3, 2, 2], hat_back=[6, 5, 6, 5, 6, 5, 6, 5], salt=43, width=2)
    s.paint('hat', lambda f, x, y, w, h: tone(coat, LIGHT[f] * 0.6 + (0.4 if y == 6 else 0)) if f in SIDES and y >= 6 else None)
    torso(s, coat)
    cloth(s, 'jacket', coat, salt=15)
    s.paint('jacket', lambda f, x, y, w, h: CLEAR if f in ('top', 'bottom') else None)
    for y in range(1, 12):
        s.px('jacket', 'front', 4, y, tone(coat, -0.9))
    for y in (2, 5, 8):
        s.px('jacket', 'front', 5, y, tone(rgb('#B8B8A8'), 0.2))   # the buttons
    sleeves(s, coat, SKIN, rows=12)
    trousers(s, rgb('#3E3C38'), rows=12)
    holster(s, 'rleg')
    sandals(s, skin=SKIN)
    return s


def chunin(s, skin):
    """The Leaf's chunin and jonin uniform: the vest over the navy shirt with the swirl patches, navy trousers wrapped at the
    shins, the holster."""
    navy = rgb('#26304E')
    flak_vest(s, shirt=navy)
    sleeves(s, navy, skin, rows=11, cuff=navy)
    swirl_patch(s)
    for a in ('rarm', 'larm'):
        ring(s, a, [10], navy, -0.4)
    trousers(s, navy, rows=12)
    for l in ('rleg', 'lleg'):
        bandage(s, l, range(7, 10))
    holster(s, 'rleg')
    sandals(s, skin=skin, wrap=False)


def iruka():
    """Iruka-sensei: dark brown hair tied up in a short ponytail, the scar across the bridge of his nose, the chunin's vest
    (he wears the real headband item)."""
    s = Skin()
    tan, hair_c = rgb('#E2B088'), rgb('#3A2A1E')
    head(s, tan)
    eyes(s, EYE_DARK, brows=tone(hair_c, -0.3))
    for x in range(1, 7):
        s.px('head', 'front', x, 6, tone(rgb('#C88870'), 0 if x in (3, 4) else -0.2))   # the scar
    hair(s, hair_c, front=[3, 2, 1, 1, 1, 1, 2, 3], side=[5, 5, 4, 4, 3, 3, 3, 3], back=[5, 5, 5, 5, 5, 5, 5, 5],
         hat_front=[1, 0, 0, 0, 0, 0, 0, 1], hat_side=[4, 4, 3, 3, 2, 2, 2, 2], hat_back=[4, 4, 5, 5, 5, 5, 4, 4], salt=47)
    for (x, y) in ((3, 0), (4, 0), (3, 1), (4, 1), (2, 1), (5, 1)):
        s.px('hat', 'top', x, y, tone(hair_c, 0.5 if (x + y) % 2 else 0))   # the ponytail, up at the back
    for x in (3, 4):
        s.px('hat', 'back', x, 0, tone(hair_c, 0.4)); s.px('hat', 'back', x, 1, tone(hair_c, -0.1))
    chunin(s, tan)
    return s


def mizuki():
    """Mizuki: long pale blue-grey hair to his shoulders, the chunin's vest."""
    s = Skin()
    hair_c = rgb('#B0C6D8')
    head(s)
    eyes(s, rgb('#3A3A48'), brows=tone(hair_c, -1.2))
    hair(s, hair_c, front=[6, 3, 2, 2, 2, 2, 3, 6], side=[8, 8, 8, 8, 8, 8, 7, 7], back=[8, 8, 8, 8, 8, 8, 8, 8],
         hat_front=[6, 2, 1, 1, 1, 1, 2, 6], hat_side=[8, 8, 8, 7, 6, 5, 5, 6], hat_back=[8, 8, 8, 8, 8, 8, 8, 8], salt=53, cape=2)
    chunin(s, SKIN)
    return s


def hiruzen():
    """The Third Hokage, in his shinobi uniform: the dark grey shirt and trousers with the swirl patches, a grey goatee and
    the lines of age. He wears the real Hokage's hat and jonin vest over it (story/StoryGear)."""
    s = Skin()
    old, grey, shirt = rgb('#E6BA92'), rgb('#9A9A9A'), rgb('#2E3240')
    head(s, old)
    eyes(s, EYE_DARK, brows=tone(grey, 0))
    s.px('head', 'front', 1, 6, tone(old, -0.5)); s.px('head', 'front', 6, 6, tone(old, -0.5))   # the lines of age
    for x in range(2, 6):
        s.px('head', 'front', x, 7, tone(grey, 0.1 if x in (3, 4) else -0.2))   # the goatee
    s.px('head', 'front', 3, 6, grey); s.px('head', 'front', 4, 6, tone(grey, -0.2))
    hair(s, grey, front=[2, 1, 0, 0, 0, 0, 1, 2], side=[5, 5, 5, 4, 4, 3, 3, 2], back=[5, 5, 5, 5, 5, 5, 5, 5],
         hat_side=[4, 4, 4, 3, 3, 2, 2, 1], hat_back=[5, 5, 5, 5, 5, 5, 5, 5], salt=59)
    torso(s, shirt)
    fold(s, 'body', 'front', [(2, 5), (5, 6)], shirt, 0.5)
    sleeves(s, shirt, old, rows=11, cuff=shirt)
    swirl_patch(s)
    for a in ('rarm', 'larm'):
        ring(s, a, [10], shirt, -0.4)
    trousers(s, shirt, rows=12)
    for l in ('rleg', 'lleg'):
        bandage(s, l, range(7, 10))
    holster(s, 'rleg')
    sandals(s, skin=old, wrap=False)
    return s


def tatsumi():
    """The player's jonin sensei (an original character): dark grey spiky hair, a scar over his left eye, the jonin's vest."""
    s = Skin()
    hair_c = rgb('#3E424C')
    head(s)
    eyes(s, EYE_DARK, brows=tone(hair_c, -0.5))
    for y in (3, 4, 5, 6):
        s.px('head', 'front', 5, y, tone(rgb('#B07A6A'), 0 if y != 4 else -0.4))   # the scar through his eye
    hair(s, hair_c, front=[4, 3, 2, 3, 2, 2, 3, 4], side=[6, 6, 5, 5, 4, 4, 3, 3], back=[7, 6, 7, 6, 7, 6, 7, 6],
         hat_front=[3, 1, 2, 1, 2, 1, 1, 3], hat_side=[6, 5, 5, 4, 4, 3, 3, 3], hat_back=[7, 5, 7, 5, 7, 5, 7, 5], salt=61, width=2)
    chunin(s, SKIN)
    return s


def ren():
    """A squadmate (original): messy brown hair, a red scarf, a sand-coloured jacket (he wears the real headband item)."""
    s = Skin()
    hair_c, jacket, scarf = rgb('#6E4628'), rgb('#C8B48A'), rgb('#BE302E')
    head(s)
    eyes(s, rgb('#3A7A3A'), brows=tone(hair_c, -0.6))
    hair(s, hair_c, front=[3, 4, 2, 3, 2, 3, 4, 3], side=[6, 6, 5, 5, 4, 4, 3, 3], back=[6, 7, 6, 7, 6, 7, 6, 7],
         hat_front=[2, 3, 1, 2, 1, 2, 3, 2], hat_side=[6, 5, 5, 4, 4, 3, 3, 3], hat_back=[7, 6, 7, 6, 7, 6, 7, 6], salt=67, width=2)
    torso(s, jacket)
    collar(s, scarf, rows=(0, 1))
    for y in range(2, 6):                                     # the scarf's end down the front
        s.px('jacket', 'front', 5, y, tone(scarf, 0.1 - y * 0.1)); s.px('jacket', 'front', 6, y, tone(scarf, -0.3 - y * 0.1))
    for y in range(2, 11):
        s.px('body', 'front', 3, y, tone(jacket, -0.8))
    ring(s, 'body', [10, 11], jacket, -0.3)
    sleeves(s, jacket, SKIN, rows=10, cuff=jacket)
    for a in ('rarm', 'larm'):
        ring(s, a, [9], jacket, -0.3)
    trousers(s, rgb('#3A3E4A'), skin=SKIN, rows=10)
    holster(s, 'rleg')
    sandals(s, skin=SKIN)
    return s


def yui():
    """A squadmate (original): a black bob, the headband round her neck, a white and teal medic's top."""
    s = Skin(slim=True)
    hair_c, white, teal = rgb('#1E1E28'), rgb('#EEF2F0'), rgb('#3A9A8E')
    head(s)
    eyes(s, rgb('#4A5AB0'), lashes=tone(hair_c, 0), brows=tone(hair_c, 0.3))
    blush(s)
    hair(s, hair_c, front=[7, 3, 2, 2, 2, 2, 3, 7], side=[7, 7, 7, 7, 7, 7, 7, 7], back=[7, 7, 7, 7, 7, 7, 7, 7],
         hat_front=[7, 3, 2, 1, 1, 2, 3, 7], hat_side=[7, 7, 6, 6, 6, 6, 7, 7], hat_back=[7, 7, 7, 7, 7, 7, 7, 7], salt=71)
    torso(s, white)
    headband_painted(s, part='jacket', row=0)                  # her headband, round her neck
    s.paint('body', lambda f, x, y, w, h: tone(teal, LIGHT[f] + 0.1) if f in ('front', 'back') and x in (0, w - 1) and y >= 2 else None)
    ring(s, 'body', [8, 9], teal)
    fold(s, 'body', 'front', [(2, 5), (5, 6)], white, 0.5)
    sleeves(s, white, SKIN, rows=4)
    for a in ('rarm', 'larm'):
        cloth(s, a, teal, rows=(6, 11), salt=9)               # arm warmers
        ring(s, a, [6], teal, 0.3)
    trousers(s, rgb('#2E3A48'), skin=SKIN, rows=9)
    holster(s, 'rleg')
    sandals(s, skin=SKIN)
    return s


CHARACTERS = {'naruto': naruto, 'naruto_genin': naruto_genin, 'sasuke': sasuke, 'sakura': sakura, 'shikamaru_kid': shikamaru,
              'ino': ino, 'choji': choji, 'hinata': hinata, 'kiba': kiba, 'shino': shino, 'iruka': iruka, 'mizuki': mizuki,
              'hiruzen': hiruzen, 'tatsumi': tatsumi, 'ren': ren, 'yui': yui}


# ---------------------------------------------------------------- previews

def view(s, back=False):
    """The skin seen from the front (or back), outer layers over the inner ones, as a 16x32 picture."""
    v = Image.new('RGBA', (16, 32), CLEAR)
    f = 'back' if back else 'front'

    def put(part, x, y):
        for p in (part, OUTER[part]):
            x0, y0, w, h = s.faces(p)[f]
            v.alpha_composite(s.im.crop((x0, y0, x0 + w, y0 + h)), (x, y))
    aw = 3 if s.slim else 4
    put('head', 4, 0)
    put('body', 4, 8)
    put('larm' if back else 'rarm', 4 - aw, 8)
    put('rarm' if back else 'larm', 12, 8)
    put('lleg' if back else 'rleg', 4, 20)
    put('rleg' if back else 'lleg', 8, 20)
    return v


if __name__ == '__main__':
    out = sys.argv[1] if len(sys.argv) > 1 else None
    n = len(CHARACTERS)
    sheet = Image.new('RGBA', (n * 176, 300), (190, 190, 190, 255))
    for i, (name, make) in enumerate(CHARACTERS.items()):
        s = make()
        s.save(name)
        sheet.alpha_composite(view(s).resize((80, 160), Image.NEAREST), (i * 176 + 4, 8))
        sheet.alpha_composite(view(s, True).resize((80, 160), Image.NEAREST), (i * 176 + 90, 8))
        sheet.alpha_composite(s.im.resize((128, 128), Image.NEAREST), (i * 176 + 20, 170))
    if out:
        sheet.save(out)
    print(n, 'skins')
