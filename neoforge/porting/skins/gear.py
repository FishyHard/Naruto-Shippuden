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
# the roof (client/StoryGearClient): four sides, each nine strips (w, 1, 1), w = 18 - 2k, strip k of side s at texture
# (s % 2 * 40, s // 2 * 18 + k * 2); the rim (18, 1, 18) at (0, 36); the cloth's sides (1, 11, 10) at (80, 0), its back
# (12, 11, 1) at (80, 21)
STRIPS = 9
RIM = (0, 36, 18, 1, 18)
CLOTH_SIDE = (80, 0, 1, 11, 10)
CLOTH_BACK = (80, 21, 12, 11, 1)
HAT_RED, INK = rgb('#9C3034'), rgb('#4A1A1E')
# 火 in red on the white triangle, by rows up the slope from the rim (row 0 at the rim)
FIRE = {6: '..#..', 5: '#.#.#', 4: '..#..', 3: '..#..', 2: '.#.#.', 1: '#...#'}


def hokage_hat():
    """The Hokage's hat: the low red pyramid, the white triangle on its front with the kanji in red and an ink line round
    it, the white rim, the white cloth hanging over the sides and back of the head."""
    im = Image.new('RGBA', (128, 64), CLEAR)
    for side in range(4):
        for k in range(STRIPS):
            w = 18 - 2 * k
            box = (side % 2 * 40, side // 2 * 18 + k * 2, w, 1, 1)

            def fn(face, x, y, fw, fh, side=side, k=k, w=w):
                cx = x - (w - 1) / 2
                gy = k                                                  # rows up the slope from the rim
                cloth = (_h(x, y + 7 * k, 41 + side) - 0.5) * 0.35 + (-0.12 if (x + gy) % 3 == 0 else 0)
                lit = (0.55, 0.15, -0.1, 0.25)[side]                    # the front and the left catch the light
                if face == 'top':
                    if side == 0:
                        half = 4.5 - 0.42 * gy
                        if abs(cx) < half:
                            row = FIRE.get(gy)
                            gx = int(round(cx + 2))
                            if row and 0 <= gx < 5 and row[gx] == '#':
                                return tone(HAT_RED, 0.15 + cloth * 0.5)
                            return tone(WHITE, 0.7 + cloth * 0.5 - 0.03 * gy)
                        if abs(cx) < half + 1:
                            return tone(INK, 0.1)                       # the ink line round the triangle
                    return tone(HAT_RED, lit + 0.02 * gy + cloth)
                if face == 'front':                                     # the strip's edge, seen at the rim
                    return tone(HAT_RED, lit - 0.5)
                return tone(HAT_RED, lit - 0.8)
            paint_box(im, box, fn)

    def rim(face, x, y, w, h):
        if face == 'top':
            return tone(WHITE, 0.6)
        if face == 'bottom':
            return tone(WHITE, -0.9 + 0.04 * max(abs(x - 8.5), abs(y - 8.5)))
        return tone(WHITE, LIGHT[face] * 0.5 + 0.35 + (_h(x, y, 3) - 0.5) * 0.15)
    paint_box(im, RIM, rim)

    def drape(face, x, y, w, h):
        # the white cloth: soft vertical folds, darker deep under the brim and toward its hem
        if face in ('top', 'bottom'):
            return tone(CLOTH, -0.6)
        t = LIGHT[face] * 0.6 + 0.35 - 0.05 * y + (-0.3 if x % 3 == 2 else 0.12 if x % 3 == 0 else 0) + (_h(x, y, 9) - 0.5) * 0.18
        if y == 0:
            t -= 0.5                                                    # the brim's shadow
        return tone(CLOTH, t)
    paint_box(im, CLOTH_SIDE, drape)
    paint_box(im, CLOTH_BACK, drape)
    return im


def hat_icon():
    """The hat from the front: the red pyramid with the white triangle and the kanji, the rim, the cloth hanging under it."""
    im = Image.new('RGBA', (16, 16), CLEAR)
    rows = [
        '.......rr.......',
        '.....rrrrrr.....',
        '...rrrrkkrrrr...',
        '.rrrrrkwwkrrrrr.',
        'rrrrrkwRwwkrrrrr',
        'wwwwwwwwwwwwwwww',
        '..cc........cc..',
        '..cc........cc..',
        '..cc........cc..',
        '..cc........cc..',
    ]
    for y, row in enumerate(rows):
        for x, ch in enumerate(row):
            lit = 0.3 if x < 7 else 0.0
            c = {'r': tone(HAT_RED, lit + 0.1 * y), 'k': tone(INK, 0), 'w': tone(WHITE, 0.4 if y > 4 else 0.6), 'R': tone(HAT_RED, 0.2),
                 'c': tone(CLOTH, lit - 0.1 * (y - 6))}.get(ch)
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
        sheet.alpha_composite(hat.resize((512, 256), Image.NEAREST), (0, 0))
        sheet.alpha_composite(vest.resize((512, 256), Image.NEAREST), (520, 0))
        sheet.alpha_composite(hat_icon().resize((192, 192), Image.NEAREST), (540, 290))
        sheet.alpha_composite(vest_icon().resize((192, 192), Image.NEAREST), (760, 290))
        sheet.save(sys.argv[1])
    print('gear written')
