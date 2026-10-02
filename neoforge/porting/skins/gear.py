"""The story's worn gear, drawn as code in the vanilla manner (the same ramps and light as skins.py), each on its own model
(client/StoryGearClient), so it has the depth the real thing has:

- the Hokage's hat: a broad brim (white, a red rim, woven straw under it), then a cone in steps: two white tiers trimmed in
  red, the kanji for fire in red on the first one's front, the top tiers and the tip red; the white cloth hanging at the back of the neck;
- the jonin vest: the padded body (vertical quilting, side seams, the waist band, the red swirl on the back), a thick rolled
  collar standing round the neck, and four scroll pockets standing out of the chest.

Writes the worn textures and the inventory icons into both resource trees: `python3 gear.py [preview.png]`."""
import os
import sys
from PIL import Image

from skins import TREES, LIGHT, SIDES, _h, rgb, tone

CLEAR = (0, 0, 0, 0)


def net(u, v, w, h, d):
    """A box's faces on the texture, as ModelPart boxes lay them out."""
    return {'top': (u + d, v, w, d), 'bottom': (u + d + w, v, w, d), 'right': (u, v + d, d, h), 'front': (u + d, v + d, w, h),
            'left': (u + d + w, v + d, d, h), 'back': (u + 2 * d + w, v + d, w, h)}


def paint_box(im, box, fn, only=None):
    for face, (x0, y0, w, h) in net(*box).items():
        if only and face not in only:
            continue
        for x in range(w):
            for y in range(h):
                c = fn(face, x, y, w, h)
                if c is not None:
                    im.putpixel((x0 + x, y0 + y), c)


def px(im, box, face, x, y, c):
    x0, y0, w, h = net(*box)[face]
    if 0 <= x < w and 0 <= y < h:
        im.putpixel((x0 + x, y0 + y), c)


def material(base, salt, rough=0.5, grad=0.6, edge=0.25):
    """Lit per face, a gradient down the sides, darker edges, the grain in clumps (as skins.cloth)."""
    def fn(face, x, y, w, h):
        t = LIGHT[face]
        if face in SIDES:
            t += grad * (0.5 - y / max(1, h - 1)) - (edge if x in (0, w - 1) else 0)
        elif face == 'top':
            t -= 0.2 * (x in (0, w - 1) or y in (0, h - 1))
        k = sum(map(ord, face))
        t += (_h((x + y % 2) // 2, y // 2, salt + k) - 0.5) * rough * 1.2
        v = _h(x, y, salt + k + 1)
        t += -0.3 if v < 0.06 else 0.25 if v > 0.95 else 0
        return tone(base, t)
    return fn


# ---------------------------------------------------------------- the Hokage's hat (64x64)

WHITE, RED, STRAW, CLOTH = rgb('#F2F0E8'), rgb('#C02A28'), rgb('#C8A870'), rgb('#ECEAE2')
# the boxes, as client/StoryGearClient builds them: texture offset (u, v) and size (w, h, d)
BRIM = (0, 0, 16, 1, 16)
TIER1 = (0, 17, 13, 3, 13)
TIER2 = (0, 33, 10, 2, 10)
TIER3 = (0, 45, 7, 1, 7)
TIP = (28, 45, 4, 1, 4)
KNOB = (44, 45, 2, 1, 2)
VEIL = (0, 53, 10, 6, 1)
FIRE = ['#.#.#', '.###.', '#...#']      # 火, in three rows


def hokage_hat():
    im = Image.new('RGBA', (64, 64), CLEAR)

    def brim(face, x, y, w, h):
        if face == 'bottom':
            # the woven straw under the brim: a lattice, darker toward the middle (the head's shadow)
            d = max(abs(x - 7.5), abs(y - 7.5))
            t = -0.6 + 0.08 * d + (-0.3 if (x + y) % 3 == 0 else 0.1 if (x - y) % 3 == 0 else 0)
            return tone(STRAW, t)
        if face in SIDES:
            return tone(RED, LIGHT[face] + 0.15 - (0.25 if x in (0, w - 1) else 0))
        # the top: white, the weave's spokes running out from the middle, the red rim round the edge
        if x in (0, w - 1) or y in (0, h - 1):
            return tone(RED, 0.7)
        t = 1.0 - 0.04 * max(abs(x - 7.5), abs(y - 7.5))
        if x in (4, 11) or y in (4, 11):
            t -= 0.25
        return tone(WHITE, t + (_h(x, y, 3) - 0.5) * 0.25)
    paint_box(im, BRIM, brim)

    def cone(colour, salt, trim=None):
        mat = material(colour, salt, rough=0.35, grad=0.5)

        def fn(face, x, y, w, h):
            if face == 'bottom':
                return tone(colour, -1.0)
            if face == 'top':
                return tone(colour, 1.0 - 0.05 * max(abs(x - (w - 1) / 2), abs(y - (h - 1) / 2)) + (_h(x, y, salt) - 0.5) * 0.2)
            c = mat(face, x, y, w, h)
            if trim is not None and y == h - 1:
                c = tone(trim, LIGHT[face] - 0.1)
            return c
        return fn
    paint_box(im, TIER1, cone(WHITE, 5, trim=RED))
    # the kanji on the front of the first tier
    for r, row in enumerate(FIRE):
        for c, ch in enumerate(row):
            if ch == '#':
                px(im, TIER1, 'front', 4 + c, r, tone(RED, 0.15 if r == 0 else -0.1))
    paint_box(im, TIER2, cone(WHITE, 7, trim=RED))
    paint_box(im, TIER3, cone(RED, 9))
    paint_box(im, TIP, cone(RED, 11))
    paint_box(im, KNOB, cone(tone(RED, -0.4), 13))

    def veil(face, x, y, w, h):
        if face in ('top', 'bottom'):
            return tone(CLOTH, -0.4)
        t = LIGHT[face] + 0.5 * (0.5 - y / 5) + (-0.35 if x % 3 == 2 else 0.1 if x % 3 == 0 else 0)   # its folds
        c = tone(CLOTH, t)
        return tone(RED, LIGHT[face]) if y == h - 1 else c
    paint_box(im, VEIL, veil)
    return im


def hat_icon():
    im = Image.new('RGBA', (16, 16), CLEAR)
    rows = [
        '.......kk.......',
        '......rrrr......',
        '.....rrrrrr.....',
        '....wwwwwwww....',
        '...wwRwRwRwww...',
        '...wwwRRRwwww...',
        '...wwRwwwRwww...',
        '...RRRRRRRRRR...',
        'rrrrrrrrrrrrrrrr',
        '.ssssssssssssss.',
    ]
    for y, row in enumerate(rows):
        for x, ch in enumerate(row):
            lit = 0.35 if x < 7 else -0.05
            c = {'w': tone(WHITE, lit + 0.2 - 0.05 * y), 'R': tone(RED, lit), 'r': tone(RED, lit + 0.1 - 0.05 * y),
                 'k': tone(RED, -0.6), 's': tone(STRAW, -0.7 + (0.2 if x % 2 else 0))}.get(ch)
            if c:
                im.putpixel((x, y + 3), c)
    return outline(im)


# ---------------------------------------------------------------- the jonin vest (64x32)

VEST = rgb('#5C6E48')
VBODY = (0, 0, 8, 12, 4)
VCOLLAR = (0, 16, 9, 2, 5)
VPOCKET = (28, 16, 3, 3, 1)


def jonin_vest():
    im = Image.new('RGBA', (64, 32), CLEAR)
    mat = material(VEST, 21, rough=0.45, grad=0.7)

    def body(face, x, y, w, h):
        if face == 'top':
            # the shoulders, round the neck hole
            return tone(VEST, 0.9) if (x in (0, w - 1) or y in (0, h - 1)) else CLEAR
        if face == 'bottom':
            return CLEAR
        if face in ('left', 'right') and 1 <= y <= 4 and x in (1, 2):
            return CLEAR                                          # open under the arms
        c = mat(face, x, y, w, h)
        t = 0
        if face in ('front', 'back') and y < 10:
            t += 0.18 if x % 2 == 0 else -0.12                    # the vertical quilting of its padding
        if y == 10:
            t += 0.3                                              # the waist band, lit on top
        elif y == 11:
            t -= 0.6
        return tone(c, t)
    paint_box(im, VBODY, body)
    # the zip down the front, a seam over each shoulder, the swirl on the back
    for y in range(0, 10):
        px(im, VBODY, 'front', 3, y, tone(VEST, -1.1))
        px(im, VBODY, 'front', 4, y, tone(VEST, -0.25))
    px(im, VBODY, 'front', 4, 1, tone(rgb('#C8C8C0'), 0.2))      # the zip's pull
    for f in ('front', 'back'):
        for x in (0, 7):
            for y in range(0, 10):
                px(im, VBODY, f, x, y, tone(VEST, LIGHT[f] - 0.45))
    swirl = rgb('#B8322E')
    for (x, y) in ((3, 3), (4, 3), (5, 4), (5, 5), (4, 6), (3, 6), (2, 5), (3, 5), (4, 4)):
        px(im, VBODY, 'back', x, y, tone(swirl, -0.1 if (x + y) % 2 else 0.15))

    def collar(face, x, y, w, h):
        if face == 'top':
            return tone(VEST, 1.0) if (x in (0, w - 1) or y in (0, h - 1)) else CLEAR
        if face == 'bottom':
            return CLEAR
        # rolled thick: lit along the top, deep in the fold below, ribbed
        t = LIGHT[face] + (0.55 if y == 0 else -0.45) + (-0.15 if x % 2 else 0.05)
        return tone(VEST, t)
    paint_box(im, VCOLLAR, collar)

    def pocket(face, x, y, w, h):
        if face == 'top':
            return tone(VEST, 1.0)
        if face == 'bottom':
            return tone(VEST, -1.1)
        if face == 'front':
            if y == 0:
                return tone(VEST, 0.65)                           # the flap, lit
            if y == 1 and x == 1:
                return tone(rgb('#3A3A30'), 0)                    # its snap
            return tone(VEST, -0.05 if y == 1 else -0.35)
        return tone(VEST, LIGHT[face] - 0.2)
    paint_box(im, VPOCKET, pocket)
    return im


def vest_icon():
    im = Image.new('RGBA', (16, 16), CLEAR)
    rows = [
        '...cccc..cccc...',
        '..cvvvc..cvvvc..',
        '..vvvvvzzvvvvv..',
        '..vppvvzzvvppv..',
        '..vqqvvzzvvqqv..',
        '..vddvvzzvvddv..',
        '..vppvvzzvvppv..',
        '..vqqvvzzvvqqv..',
        '..vddvvzzvvddv..',
        '..vvvvvzzvvvvv..',
        '..bbbbbbbbbbbb..',
        '..eeeeeeeeeeee..',
    ]
    for y, row in enumerate(rows):
        for x, ch in enumerate(row):
            lit = 0.25 if x < 7 else -0.1
            t = {'c': 0.7 + lit, 'v': 0.1 - 0.04 * y + lit + (0.12 if x % 2 else -0.08), 'p': 0.6 + lit, 'q': 0.0 + lit,
                 'd': -0.9, 'z': -1.0, 'b': 0.2 + lit, 'e': -0.8}.get(ch)
            if t is not None:
                im.putpixel((x, y + 2), tone(VEST, t))
    return outline(im)


def outline(im):
    """A dark outline round the icon, as vanilla's items have."""
    out = im.copy()
    for x in range(16):
        for y in range(16):
            if im.getpixel((x, y))[3]:
                continue
            for dx, dy in ((1, 0), (-1, 0), (0, 1), (0, -1)):
                if 0 <= x + dx < 16 and 0 <= y + dy < 16 and im.getpixel((x + dx, y + dy))[3]:
                    out.putpixel((x, y), tone(im.getpixel((x + dx, y + dy)), -2.4))
                    break
    return out


def save(im, rel):
    for t in TREES:
        p = os.path.join(t, 'assets/naruto_shippuden/textures', rel)
        os.makedirs(os.path.dirname(p), exist_ok=True)
        im.save(p)


if __name__ == '__main__':
    hat, vest = hokage_hat(), jonin_vest()
    save(hat, 'entities/hokage_hat.png')
    save(hat, 'entity/equipment/humanoid/hokage_hat.png')
    save(vest, 'entities/jonin_vest.png')
    save(vest, 'entity/equipment/humanoid/jonin_vest.png')
    save(hat_icon(), 'item/hokage_hat.png')
    save(vest_icon(), 'item/jonin_vest.png')
    if len(sys.argv) > 1:
        sheet = Image.new('RGBA', (1024 + 300, 512), (40, 42, 50, 255))
        sheet.alpha_composite(hat.resize((512, 512), Image.NEAREST), (0, 0))
        sheet.alpha_composite(vest.resize((512, 256), Image.NEAREST), (520, 0))
        sheet.alpha_composite(hat_icon().resize((192, 192), Image.NEAREST), (540, 290))
        sheet.alpha_composite(vest_icon().resize((192, 192), Image.NEAREST), (760, 290))
        sheet.save(sys.argv[1])
    print('gear written')
