"""The story characters' skins, drawn as code: 64x64 player skins (the modern layout, wide or slim arms) in the vanilla manner,
flat colours, a shade lighter on top and darker below, faces like Steve's (two-pixel eyes). Each character is a small spec;
run `python3 skins.py` (Pillow) to write textures/entities/story/<id>.png into both resource trees and a preview sheet.

Coordinates follow the skin layout: every part is a box (w, h, d) whose net starts at its texture offset: top and bottom on the
first d rows, then right, front, left and back side by side."""
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


def shade(c, f):
    return (max(0, min(255, int(c[0] * f))), max(0, min(255, int(c[1] * f))), max(0, min(255, int(c[2] * f))), c[3])


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


class Skin:
    def __init__(self, slim=False):
        self.im = Image.new('RGBA', (64, 64), (0, 0, 0, 0))
        self.slim = slim

    def faces(self, part):
        """face name -> (x0, y0, w, h) of that face of the part's net."""
        u, v, w, h, d = PARTS[part]
        if self.slim and part in SLIM:
            w = 3
        return {'top': (u + d, v, w, d), 'bottom': (u + d + w, v, w, d), 'right': (u, v + d, d, h),
                'front': (u + d, v + d, w, h), 'left': (u + d + w, v + d, d, h), 'back': (u + 2 * d + w, v + d, w, h)}

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

    def fill(self, part, colour, rows=None, only=None, folds=True):
        """A colour lit from above, as vanilla's skins are: tops lighter, sides and the bottom row of each band darker,
        the outer columns of the front a touch darker, and a few soft folds (rows = (from, to) of the side faces)."""
        salt = sum(map(ord, part))
        def fn(face, x, y, w, h):
            if face == 'top':
                return shade(colour, 1.08) if rows is None or rows[0] == 0 else None
            if face == 'bottom':
                return shade(colour, 0.78) if rows is None or rows[1] >= h else None
            if rows is not None and not rows[0] <= y < rows[1]:
                return None
            f = 0.88 if face in ('left', 'right') else 1.0
            if folds and h >= 8:
                f *= 1.08 - 0.2 * y / (h - 1)                # lit from above: light at the top, darker toward the hem
            end = rows[1] if rows else h
            if y == end - 1 and end - (rows[0] if rows else 0) > 2:
                f *= 0.9                                     # the hem
            if face in ('front', 'back') and (x == 0 or x == w - 1):
                f *= 0.96
            if folds and h >= 8 and _h(x, y, salt) < 0.09:
                f *= 0.92                                    # a fold
            if folds and h >= 8 and y < 2 and _h(x, y, salt + 7) < 0.15:
                f *= 1.05                                    # light on the shoulders
            return shade(colour, f)
        self.paint(part, fn, only)

    def px(self, part, face, x, y, colour):
        x0, y0, w, h = self.faces(part)[face]
        if 0 <= x < w and 0 <= y < h:
            self.im.putpixel((x0 + x, y0 + y), colour)

    def save(self, name):
        for t in TREES:
            d = os.path.join(t, 'assets/naruto_shippuden/textures/entities/story')
            os.makedirs(d, exist_ok=True)
            self.im.save(os.path.join(d, name + '.png'))


# ---------------------------------------------------------------- the pieces every character is made of

def face(s, skin, eye, hair, fringe, side=3, back=6, whiskers=None, marks=None, glasses=None, pale_eyes=False, brows=True,
         spikes=None, lashes=False):
    """The head, in the manner of the good Naruto skins: hair in three tones (light streaks, base, dark ends) over the top,
    down the sides (side rows) and back (back rows); a fringe (rows per front column) with a jagged dark edge; on the hat
    layer the hair stands out round the head (spikes: rows per hat column hanging down the front, for spiky hair); eyes two
    pixels tall (white outside, the iris inside with a light top), eyebrows, a soft chin; no mouth, as anime faces."""
    s.fill('head', skin, folds=False)
    light, dark, deep = shade(hair, 1.18), shade(hair, 0.8), shade(hair, 0.65)

    def strand(x, y, salt, depth):
        v = _h(x, 0, salt)
        c = light if v < 0.22 else hair if v < 0.7 else dark
        if y >= depth - 1:
            c = deep if v < 0.5 else dark                  # the ends of the hair are its darkest
        elif y == 0 and v < 0.5:
            c = light
        return c

    s.paint('head', lambda f, x, y, w, h: (light if (x * 2 + y) % 5 == 0 else hair if (x + y) % 3 else dark) if f == 'top' else None)
    s.paint('head', lambda f, x, y, w, h: strand(x, y, 11, side) if f in ('left', 'right') and y < side else None)
    s.paint('head', lambda f, x, y, w, h: strand(x, y, 12, back) if f == 'back' and y < back else None)
    s.paint('head', lambda f, x, y, w, h: strand(x, y, 13, fringe[x]) if f == 'front' and y < fringe[x] else None)
    # the fringe's shadow on the skin below it
    for x in range(8):
        if 0 < fringe[x] < 8:
            s.px('head', 'front', x, fringe[x], shade(skin, 0.88))
    for f in ('left', 'right'):
        if side <= 5:
            s.px('head', f, 3, 5, shade(skin, 0.84)); s.px('head', f, 4, 5, shade(skin, 0.84))
    # the hat layer: the hair's volume round the head, spikes hanging over the front if any
    hat_side = max(1, min(side, 3))
    s.paint('hat', lambda f, x, y, w, h: (light if (x * 3 + y) % 4 == 0 else hair if (x + 2 * y) % 3 else dark) if f == 'top' else None)
    s.paint('hat', lambda f, x, y, w, h: strand(x, y, 21, hat_side) if f in ('left', 'right', 'back') and y < hat_side else None)
    if spikes:
        s.paint('hat', lambda f, x, y, w, h: strand(x, y, 23, spikes[x]) if f == 'front' and y < spikes[x] else None)
    white = rgb('#F6F6F6')
    if brows:
        for x in (1, 2, 5, 6):
            if fringe[x] <= 3 and not (spikes and spikes[x] > 3):
                s.px('head', 'front', x, 3, deep)
    if pale_eyes:
        # the Byakugan at rest: pale lavender, no pupils, a faint ring
        for x, outer in ((1, True), (2, False), (5, False), (6, True)):
            s.px('head', 'front', x, 4, rgb('#ECE8F6') if not outer else rgb('#F8F8FC'))
            s.px('head', 'front', x, 5, rgb('#D6CEEA') if not outer else rgb('#E8E4F2'))
    elif eye is not None:
        for x, outer in ((1, True), (2, False), (5, False), (6, True)):
            if outer:
                s.px('head', 'front', x, 4, white); s.px('head', 'front', x, 5, shade(white, 0.92))
            else:
                s.px('head', 'front', x, 4, shade(eye, 1.3)); s.px('head', 'front', x, 5, eye)
        if lashes:
            s.px('head', 'front', 0, 4, deep); s.px('head', 'front', 7, 4, deep)
    for x in range(1, 7):
        s.px('head', 'front', x, 7, shade(skin, 0.94))
    if whiskers:
        for (x, y) in ((0, 6), (1, 6), (6, 6), (7, 6)):
            s.px('head', 'front', x, y, whiskers)
    if marks:
        for (x, y, c) in marks:
            s.px('head', 'front', x, y, c)
    if glasses:
        for x in range(1, 7):
            s.px('head', 'front', x, 4, glasses); s.px('head', 'front', x, 5, glasses)
        s.px('head', 'front', 0, 4, shade(glasses, 1.3)); s.px('head', 'front', 7, 4, shade(glasses, 1.3))
        s.px('head', 'front', 2, 4, shade(glasses, 1.8)); s.px('head', 'front', 5, 4, shade(glasses, 1.8))


def headband(s, cloth=rgb('#2B3A6B'), metal=rgb('#B8BEC6'), row=2):
    """The Leaf forehead protector: a cloth band round the head on the hat layer, a metal plate with the leaf mark in front."""
    s.paint('hat', lambda f, x, y, w, h: cloth if f in ('left', 'right', 'back') and y in (row, row + 1) else None)
    for x in range(1, 7):
        for y in (row, row + 1):
            s.px('hat', 'front', x, y, metal)
    mark = shade(metal, 0.55)
    for (x, y) in ((3, row), (4, row + 1), (3, row + 1)):
        s.px('hat', 'front', x, y, mark)
    s.px('hat', 'front', 0, row, cloth); s.px('hat', 'front', 7, row, cloth)
    s.px('hat', 'front', 0, row + 1, cloth); s.px('hat', 'front', 7, row + 1, cloth)


def torso(s, colour, collar=None, zip=None, belt=None, trim=None):
    s.fill('body', colour)
    if collar:
        s.paint('body', lambda f, x, y, w, h: collar if y == 0 and f != 'top' and f != 'bottom' else None)
        s.paint('body', lambda f, x, y, w, h: collar if f == 'top' else None)
    if zip:
        s.paint('body', lambda f, x, y, w, h: zip if f == 'front' and x in (3, 4) and 1 <= y < 10 else None)
    if belt:
        s.paint('body', lambda f, x, y, w, h: belt if f not in ('top', 'bottom') and y in (10, 11) else None)
    if trim:
        s.paint('body', lambda f, x, y, w, h: trim if f == 'front' and (x == 0 or x == w - 1) else None)


def arms(s, sleeve, skin, sleeve_rows=12, cuff=None, warmer=None):
    """Sleeves down to sleeve_rows, then bare arm; a cuff on the last sleeve row; warmers (bandages) on the forearm."""
    for a in ('rarm', 'larm'):
        s.fill(a, skin, folds=False)
        s.fill(a, sleeve, rows=(0, sleeve_rows))
        if cuff and sleeve_rows < 12:
            s.paint(a, lambda f, x, y, w, h: cuff if f not in ('top', 'bottom') and y == sleeve_rows - 1 else None)
        if warmer:
            s.paint(a, lambda f, x, y, w, h: (warmer if y % 2 else shade(warmer, 0.9)) if f not in ('top', 'bottom') and 6 <= y < 11 else None)


def legs(s, pants, shoe, skin=None, pants_rows=12, shoe_rows=2, wrap=None, toes=None):
    """Trousers down to pants_rows, bare leg below if skin, and the shinobi sandals: shoe_rows of shoe with the toes
    showing at the front (toes: their colour, the skin by default)."""
    toe = toes or skin or SKIN
    for l in ('rleg', 'lleg'):
        s.fill(l, skin or pants, folds=False)
        s.fill(l, pants, rows=(0, pants_rows))
        s.fill(l, shoe, rows=(12 - shoe_rows, 12), folds=False)
        # open toes, and the sandal's strap above them
        s.paint(l, lambda f, x, y, w, h: shade(toe, 0.95) if f == 'front' and y == 11 and x in (1, 2) else None)
        s.paint(l, lambda f, x, y, w, h: shade(shoe, 0.8) if f in ('front', 'left', 'right', 'back') and y == 12 - shoe_rows - 1 and skin else None)
        if wrap:
            s.paint(l, lambda f, x, y, w, h: wrap if f not in ('top', 'bottom') and y in wrap_rows(pants_rows) else None)


def wrap_rows(pants_rows):
    return range(pants_rows, 10)


SKIN = rgb('#F2C6A0')
EYE_DARK = rgb('#2A2A33')


# ---------------------------------------------------------------- the characters

def naruto():
    s = Skin()
    face(s, SKIN, rgb('#2E6FD6'), rgb('#F5C332'), fringe=[3, 3, 2, 2, 3, 2, 3, 3], side=4, back=8, whiskers=rgb('#9A6E50'),
         spikes=[3, 1, 2, 1, 2, 1, 2, 3])
    # spikes of hair stand out on the hat layer, and the green goggles of his Academy days on his forehead
    s.paint('hat', lambda f, x, y, w, h: rgb('#F5C332') if (f == 'top' and (x + y) % 3 == 0) or (f in ('left', 'right', 'back') and y == 0 and x % 2 == 0) else None)
    s.paint('hat', lambda f, x, y, w, h: rgb('#4D8C4A') if f in ('left', 'right', 'back') and y == 2 else None)
    for x in range(1, 7):
        s.px('hat', 'front', x, 2, rgb('#7CC8E8') if x in (2, 5) else rgb('#4D8C4A'))
    orange, blue = rgb('#F07A1E'), rgb('#2B3A6B')
    torso(s, orange, collar=rgb('#F2F2F2'), zip=rgb('#E0E0E0'))
    s.paint('body', lambda f, x, y, w, h: blue if f not in ('top', 'bottom') and y < 3 else None)
    s.paint('body', lambda f, x, y, w, h: rgb('#F2F2F2') if f == 'front' and y == 0 and x in (2, 3, 4, 5) else None)
    arms(s, orange, SKIN, sleeve_rows=11, cuff=rgb('#F2F2F2'))
    for a in ('rarm', 'larm'):
        s.fill(a, blue, rows=(0, 3))
    legs(s, orange, rgb('#2B3A6B'), skin=SKIN, pants_rows=9, shoe_rows=2)
    return s


def sasuke():
    s = Skin()
    hair = rgb('#1C1E2A')
    face(s, SKIN, EYE_DARK, hair, fringe=[5, 3, 2, 2, 2, 2, 3, 5], side=6, back=8, spikes=[6, 3, 1, 0, 0, 1, 3, 6])
    s.paint('hat', lambda f, x, y, w, h: shade(hair, 0.8) if f == 'back' and y < 5 and x % 2 == 1 else None)   # the spikes at the back
    navy = rgb('#1F2B57')
    torso(s, navy, collar=navy)
    s.paint('body', lambda f, x, y, w, h: shade(navy, 1.25) if y == 0 and f not in ('top', 'bottom') else None)
    # the Uchiha fan on the back: red over white
    for (x, y, c) in ((3, 3, '#C42A2A'), (4, 3, '#C42A2A'), (2, 4, '#C42A2A'), (3, 4, '#C42A2A'), (4, 4, '#C42A2A'), (5, 4, '#C42A2A'),
                      (2, 5, '#F2F2F2'), (3, 5, '#F2F2F2'), (4, 5, '#F2F2F2'), (5, 5, '#F2F2F2'), (3, 6, '#F2F2F2'), (4, 6, '#F2F2F2'),
                      (3, 7, '#8C8C8C'), (4, 7, '#8C8C8C')):
        s.px('body', 'back', x, y, rgb(c))
    arms(s, navy, SKIN, sleeve_rows=3, warmer=rgb('#E8E8E8'))
    legs(s, rgb('#E6E6E6'), rgb('#2B3A6B'), skin=SKIN, pants_rows=6, shoe_rows=2)
    s.fill('lleg', rgb('#F2F2F2'), rows=(6, 8))     # bandage on the thigh
    return s


def sakura():
    s = Skin(slim=True)
    hair = rgb('#F2A1B9')
    face(s, SKIN, rgb('#3E9A5A'), hair, fringe=[7, 3, 2, 2, 2, 2, 3, 7], side=8, back=8, lashes=True, spikes=[7, 2, 1, 0, 0, 1, 2, 7])
    s.paint('hat', lambda f, x, y, w, h: hair if f in ('left', 'right', 'back') and y >= 6 else None)
    # the red ribbon Ino gave her, tied round her head
    s.paint('hat', lambda f, x, y, w, h: rgb('#C42A2A') if f in ('front', 'left', 'right', 'back') and y == 1 else None)
    s.px('hat', 'right', 1, 2, rgb('#C42A2A')); s.px('hat', 'right', 2, 2, rgb('#C42A2A'))
    red = rgb('#C4302E')
    torso(s, red, collar=red)
    s.paint('body', lambda f, x, y, w, h: rgb('#F2F2F2') if f == 'front' and y == 0 and 2 <= x <= 5 else None)   # the white collar
    arms(s, red, SKIN, sleeve_rows=2)
    for a in ('rarm', 'larm'):
        s.paint(a, lambda f, x, y, w, h: rgb('#E8E8E8') if f not in ('top', 'bottom') and 7 <= y < 11 else None)
    legs(s, rgb('#385A3A'), rgb('#2B3A6B'), skin=SKIN, pants_rows=5, shoe_rows=2)
    s.fill('jacket', red, rows=(9, 12), only=('front', 'back', 'left', 'right'))   # the dress hangs over the shorts
    return s


def shikamaru():
    s = Skin()
    hair = rgb('#202024')
    face(s, SKIN, EYE_DARK, hair, fringe=[3, 2, 2, 1, 1, 2, 2, 3], side=4, back=7)
    for (x, y) in ((3, 0), (4, 0), (3, 1), (4, 1), (2, 0), (5, 0)):     # the pineapple tail on top
        s.px('hat', 'top', x, y + 3, hair)
    s.paint('hat', lambda f, x, y, w, h: hair if f == 'back' and x in (3, 4) and y < 2 else None)
    s.px('head', 'left', 5, 5, rgb('#D8C060')); s.px('head', 'right', 2, 5, rgb('#D8C060'))   # earrings
    grey, brown = rgb('#8A8478'), rgb('#6E5236')
    torso(s, grey, collar=brown, trim=brown)
    s.paint('body', lambda f, x, y, w, h: rgb('#5A5650') if f == 'front' and 1 <= x <= 6 and y < 9 and (x + y) % 2 == 0 else None)  # the mesh shirt
    arms(s, rgb('#5A5650'), SKIN, sleeve_rows=6)
    legs(s, brown, rgb('#2B3A6B'), skin=SKIN, pants_rows=9, shoe_rows=2)
    return s


def ino():
    s = Skin(slim=True)
    hair = rgb('#F2E6A6')
    face(s, SKIN, rgb('#5DA9D6'), hair, fringe=[6, 5, 3, 2, 2, 2, 2, 6], side=8, back=8, lashes=True, spikes=[6, 5, 4, 1, 0, 0, 1, 2])
    s.paint('hat', lambda f, x, y, w, h: hair if f == 'back' and x in (3, 4) else None)    # the long ponytail
    purple = rgb('#7B3C8F')
    torso(s, purple, collar=purple, belt=rgb('#E8E8E8'))
    arms(s, purple, SKIN, sleeve_rows=2, warmer=rgb('#E8E8E8'))
    legs(s, purple, rgb('#2B3A6B'), skin=SKIN, pants_rows=4, shoe_rows=2)
    for l in ('rleg', 'lleg'):
        s.paint(l, lambda f, x, y, w, h: rgb('#E8E8E8') if f not in ('top', 'bottom') and 5 <= y < 10 else None)
    return s


def choji():
    s = Skin()
    hair = rgb('#7A4A26')
    face(s, SKIN, EYE_DARK, hair, fringe=[3, 3, 2, 2, 2, 2, 3, 3], side=5, back=7,
         marks=[(0, 6, rgb('#C44A4A')), (7, 6, rgb('#C44A4A')), (1, 6, rgb('#D46A6A')), (6, 6, rgb('#D46A6A'))])
    s.paint('hat', lambda f, x, y, w, h: hair if f == 'top' and (x + y) % 2 == 0 else None)
    green = rgb('#3E7C3C')
    torso(s, green, collar=rgb('#F2F2F2'))
    s.paint('body', lambda f, x, y, w, h: rgb('#F2F2F2') if f not in ('top', 'bottom') and y < 2 else None)   # the scarf
    s.paint('body', lambda f, x, y, w, h: rgb('#E0C040') if f == 'front' and (x, y) in ((3, 5), (4, 5), (3, 6), (4, 6)) else None)
    arms(s, green, SKIN, sleeve_rows=5)
    legs(s, rgb('#5A5A64'), rgb('#2B3A6B'), skin=SKIN, pants_rows=9)
    return s


def hinata():
    s = Skin(slim=True)
    hair = rgb('#2C2C52')
    face(s, SKIN, None, hair, fringe=[8, 3, 3, 3, 3, 3, 3, 8], side=8, back=8, pale_eyes=True, lashes=True, spikes=[8, 3, 2, 2, 2, 2, 3, 8])
    cream, trim = rgb('#D9CFE4'), rgb('#7B5A9B')
    torso(s, cream, collar=trim, zip=trim)
    arms(s, cream, SKIN, sleeve_rows=11, cuff=trim)
    legs(s, rgb('#2C2C48'), rgb('#2B3A6B'), skin=SKIN, pants_rows=10)
    return s


def kiba():
    s = Skin()
    hair = rgb('#5A3A22')
    face(s, SKIN, EYE_DARK, hair, fringe=[3, 3, 2, 3, 2, 3, 3, 3], side=5, back=7, spikes=[2, 1, 2, 1, 1, 2, 1, 2],
         marks=[(1, 6, rgb('#C42A2A')), (6, 6, rgb('#C42A2A')), (1, 7, rgb('#C42A2A')), (6, 7, rgb('#C42A2A'))])
    grey, fur = rgb('#7C7C80'), rgb('#E8E4DC')
    torso(s, grey, collar=fur, zip=rgb('#5A5A5E'))
    s.paint('jacket', lambda f, x, y, w, h: fur if f in ('back',) and y < 3 else None)   # the fur-lined hood down his back
    arms(s, grey, SKIN, sleeve_rows=11, cuff=fur)
    legs(s, rgb('#3A3A44'), rgb('#2B3A6B'), skin=SKIN, pants_rows=10)
    return s


def shino():
    s = Skin()
    hair = rgb('#3A2C22')
    face(s, SKIN, EYE_DARK, hair, fringe=[3, 3, 3, 3, 3, 3, 3, 3], side=5, back=7, glasses=rgb('#16161C'))
    coat = rgb('#7A867A')
    s.paint('hat', lambda f, x, y, w, h: coat if f in ('front', 'left', 'right', 'back') and y >= 5 else None)   # the high collar over his face
    s.paint('hat', lambda f, x, y, w, h: hair if f == 'top' and (x * y) % 3 == 0 else None)
    torso(s, coat, collar=coat, zip=shade(coat, 0.8))
    arms(s, coat, SKIN, sleeve_rows=12)
    legs(s, rgb('#3C3A36'), rgb('#2B3A6B'), pants_rows=12)
    return s


def mizuki():
    s = Skin()
    hair = rgb('#AFC6D8')
    face(s, SKIN, EYE_DARK, hair, fringe=[5, 3, 2, 2, 2, 2, 3, 5], side=8, back=8)
    s.paint('hat', lambda f, x, y, w, h: hair if f == 'back' and y >= 5 else None)
    navy, vest = rgb('#28304A'), rgb('#5E7050')
    torso(s, vest, collar=vest, zip=shade(vest, 0.8))
    s.paint('body', lambda f, x, y, w, h: shade(vest, 0.85) if f == 'front' and y in (4, 7) and x not in (3, 4) else None)   # the vest's pockets
    arms(s, navy, SKIN, sleeve_rows=11)
    for a in ('rarm', 'larm'):
        s.fill(a, rgb('#B03030'), rows=(1, 2))      # the red swirl patch, as Iruka's
    legs(s, navy, rgb('#2B3A6B'), pants_rows=10)
    return s


def hiruzen():
    s = Skin()
    skin_old = rgb('#E8BC94')
    face(s, skin_old, EYE_DARK, rgb('#8C8C8C'), fringe=[1, 0, 0, 0, 0, 0, 0, 1], side=3, back=5,
         marks=[(2, 7, rgb('#B0B0B0')), (3, 7, rgb('#B0B0B0')), (4, 7, rgb('#B0B0B0')), (5, 7, rgb('#B0B0B0'))])   # his goatee
    # the Hokage's hat: white with a red front panel and the kanji for fire
    white, red = rgb('#F2F2F0'), rgb('#C42A2A')
    s.paint('hat', lambda f, x, y, w, h: white if f in ('top', 'left', 'right', 'back') and (f == 'top' or y < 3) else None)
    for x in range(8):
        for y in range(3):
            s.px('hat', 'front', x, y, red if 2 <= x <= 5 else white)
    s.px('hat', 'front', 3, 1, white); s.px('hat', 'front', 4, 1, white)
    robe = rgb('#F0EEE8')
    torso(s, robe, collar=red)
    # the robe's red lapels, crossing at the chest
    s.paint('body', lambda f, x, y, w, h: red if f == 'front' and ((x == 2 + y and y < 3) or (x == 5 - y and y < 3) or (x in (3, 4) and 3 <= y < 8)) else None)
    s.paint('body', lambda f, x, y, w, h: rgb('#3A3A3A') if f not in ('top', 'bottom') and y == 8 else None)   # the sash
    arms(s, robe, skin_old, sleeve_rows=11, cuff=red)
    legs(s, robe, rgb('#2B3A6B'), pants_rows=12)
    s.fill('jacket', robe, rows=(9, 12), only=('front', 'back', 'left', 'right'))
    return s


def tatsumi():
    """The player's jonin sensei (an original character): dark grey spiky hair, a scar over one eye, the flak vest."""
    s = Skin()
    hair = rgb('#3C3F48')
    face(s, SKIN, EYE_DARK, hair, fringe=[4, 3, 2, 2, 2, 2, 3, 4], side=6, back=8,
         marks=[(5, 3, rgb('#B07A6A')), (5, 5, rgb('#B07A6A'))])
    s.paint('hat', lambda f, x, y, w, h: hair if f == 'top' and (x + 2 * y) % 3 == 0 else None)
    navy, vest = rgb('#28304A'), rgb('#5E7050')
    torso(s, vest, collar=vest, zip=shade(vest, 0.8))
    s.paint('body', lambda f, x, y, w, h: shade(vest, 0.85) if f == 'front' and y in (4, 7) and x not in (3, 4) else None)
    arms(s, navy, SKIN, sleeve_rows=11)
    for a in ('rarm', 'larm'):
        s.fill(a, rgb('#B03030'), rows=(1, 2))
    legs(s, navy, rgb('#2B3A6B'), pants_rows=10)
    return s


def ren():
    """A squadmate (original): messy brown hair, a red scarf, a sand-coloured jacket (he wears the real headband item)."""
    s = Skin()
    hair = rgb('#6A4426')
    face(s, SKIN, rgb('#3A6A3A'), hair, fringe=[3, 4, 2, 3, 2, 3, 4, 3], side=5, back=7, spikes=[2, 3, 1, 2, 1, 2, 3, 2])
    jacket, scarf = rgb('#C8B48A'), rgb('#B82E2E')
    torso(s, jacket, collar=scarf, zip=shade(jacket, 0.8))
    s.paint('body', lambda f, x, y, w, h: scarf if f not in ('top', 'bottom') and y < 2 else None)
    s.paint('jacket', lambda f, x, y, w, h: scarf if f == 'front' and x in (5, 6) and 2 <= y < 6 else None)   # the scarf's end
    arms(s, jacket, SKIN, sleeve_rows=10, cuff=shade(jacket, 0.8))
    legs(s, rgb('#3A3E4A'), rgb('#2B3A6B'), skin=SKIN, pants_rows=10)
    return s


def yui():
    """A squadmate (original): a black bob, the headband round her neck, a white and teal medic's top."""
    s = Skin(slim=True)
    hair = rgb('#1E1E26')
    face(s, SKIN, rgb('#4A5AA8'), hair, fringe=[6, 3, 2, 2, 2, 2, 3, 6], side=7, back=7, lashes=True, spikes=[6, 3, 2, 1, 1, 2, 3, 6])
    white, teal = rgb('#EEF2F0'), rgb('#3A9A8E')
    torso(s, white, collar=rgb('#2B3A6B'), trim=teal)
    s.paint('body', lambda f, x, y, w, h: rgb('#B8BEC6') if f == 'front' and y == 0 and 2 <= x <= 5 else None)   # the plate at her neck
    s.paint('body', lambda f, x, y, w, h: teal if f not in ('top', 'bottom') and y in (9, 10) else None)
    arms(s, white, SKIN, sleeve_rows=4, warmer=teal)
    legs(s, rgb('#2E3A48'), rgb('#2B3A6B'), skin=SKIN, pants_rows=9)
    return s


CHARACTERS = {'naruto': naruto, 'sasuke': sasuke, 'sakura': sakura, 'shikamaru_kid': shikamaru, 'ino': ino, 'choji': choji,
              'hinata': hinata, 'kiba': kiba, 'shino': shino, 'mizuki': mizuki, 'hiruzen': hiruzen,
              'tatsumi': tatsumi, 'ren': ren, 'yui': yui}


def front_view(s):
    """The skin seen from the front, as a 16x32 picture (for the preview sheet)."""
    v = Image.new('RGBA', (16, 32), (0, 0, 0, 0))
    def put(part, face, x, y):
        x0, y0, w, h = s.faces(part)[face]
        v.alpha_composite(s.im.crop((x0, y0, x0 + w, y0 + h)), (x, y))
    aw = 3 if s.slim else 4
    put('head', 'front', 4, 0); put('hat', 'front', 4, 0)
    put('body', 'front', 4, 8); put('jacket', 'front', 4, 8)
    put('rarm', 'front', 4 - aw, 8); put('rsleeve', 'front', 4 - aw, 8)
    put('larm', 'front', 12, 8); put('lsleeve', 'front', 12, 8)
    put('rleg', 'front', 4, 20); put('rpants', 'front', 4, 20)
    put('lleg', 'front', 8, 20); put('lpants', 'front', 8, 20)
    return v


def back_view(s):
    v = Image.new('RGBA', (16, 32), (0, 0, 0, 0))
    def put(part, face, x, y):
        x0, y0, w, h = s.faces(part)[face]
        v.alpha_composite(s.im.crop((x0, y0, x0 + w, y0 + h)), (x, y))
    aw = 3 if s.slim else 4
    put('head', 'back', 4, 0); put('hat', 'back', 4, 0)
    put('body', 'back', 4, 8); put('jacket', 'back', 4, 8)
    put('larm', 'back', 4 - aw, 8); put('lsleeve', 'back', 4 - aw, 8)
    put('rarm', 'back', 12, 8); put('rsleeve', 'back', 12, 8)
    put('lleg', 'back', 4, 20); put('lpants', 'back', 4, 20)
    put('rleg', 'back', 8, 20); put('rpants', 'back', 8, 20)
    return v


if __name__ == '__main__':
    out = sys.argv[1] if len(sys.argv) > 1 else None
    sheet = Image.new('RGBA', (len(CHARACTERS) * 40 * 4, 34 * 8), (198, 198, 198, 255))
    for i, (name, make) in enumerate(CHARACTERS.items()):
        s = make()
        s.save(name)
        sheet.alpha_composite(front_view(s).resize((64, 128), Image.NEAREST), (i * 160 + 6, 8))
        sheet.alpha_composite(back_view(s).resize((64, 128), Image.NEAREST), (i * 160 + 80, 8))
    if out:
        sheet.save(out)
    print(len(CHARACTERS), 'skins')
