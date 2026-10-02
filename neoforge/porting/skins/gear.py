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
# the cone, a pixel narrower each step up: (width, texture offset), from the brim to the top; then the tip and the cloth
CONE = [(16, (0, 0)), (14, (64, 0)), (12, (0, 17)), (10, (48, 17)), (8, (88, 17)), (6, (0, 30))]
TIP = (24, 30, 4, 1, 4)
KNOB = (40, 30, 2, 1, 2)
VEIL = (48, 30, 10, 7, 1)
# 火 in white on the red front panel, one row per step from the top step down to the step above the brim
FIRE = ['..#..', '#.#.#', '..#..', '.#.#.', '#...#']


def hokage_hat():
    """A white woven cone, a pixel narrower each step: the red panel down its front narrowing to the top with the kanji
    for fire in white across the steps, a red rim round the brim, woven straw under it, the red tip, the cloth at the back."""
    im = Image.new('RGBA', (128, 64), CLEAR)
    steps = len(CONE)
    for i, (w, (u, v)) in enumerate(CONE):
        box = (u, v, w, 1, w)
        row = steps - 1 - i                         # the glyph's row on this step's front (the top step is row 0)
        panel = 1 + (i * 3) // 2                     # the red panel's half-width here: wide at the brim, narrow at the top

        def fn(face, x, y, fw, fh, w=w, i=i, row=row, panel=panel):
            if face == 'bottom':
                if i == 0:
                    d = max(abs(x - 7.5), abs(y - 7.5))
                    return tone(STRAW, -0.7 + 0.07 * d + (-0.3 if (x + y) % 3 == 0 else 0.1 if (x - y) % 3 == 0 else 0))
                return tone(WHITE, -1.2)
            weave = (-0.22 if (x + y) % 4 == 0 else 0.12 if (x - y) % 4 == 0 else 0) + (_h(x, y, 7 + i) - 0.5) * 0.25
            if face == 'top':
                # only the ring the next step up leaves bare shows; the front of it belongs to the panel
                c = w / 2 - 0.5
                front_band = y >= c and abs(x - c) <= panel
                if i == 0 and (x in (0, fw - 1) or y in (0, fw - 1)):
                    return tone(RED, 0.65)
                return tone(RED if front_band and i > 0 else WHITE, 0.95 - 0.04 * i + weave)
            t = LIGHT[face] + 0.15 + weave - (0.2 if x in (0, fw - 1) else 0)
            if i == 0:
                return tone(RED, LIGHT[face] + 0.15 - (0.2 if x in (0, fw - 1) else 0))   # the brim's red rim
            if face == 'front':
                c = (fw - 1) / 2
                if abs(x - c) <= panel:
                    g = FIRE[row] if 0 <= row < len(FIRE) else '.....'
                    gx = int(x - (c - 2))
                    if 0 <= gx < 5 and g[gx] == '#':
                        return tone(WHITE, 0.25)
                    return tone(RED, 0.15 + weave * 0.6)
            return tone(WHITE, t)
        paint_box(im, box, fn)
    red = material(RED, 11, rough=0.3, grad=0.3)
    paint_box(im, TIP, lambda f, x, y, w, h: tone(RED, 0.6) if f == 'top' else red(f, x, y, w, h))
    paint_box(im, KNOB, lambda f, x, y, w, h: tone(RED, 0.2 if f == 'top' else -0.4))

    def veil(face, x, y, w, h):
        if face in ('top', 'bottom'):
            return tone(CLOTH, -0.4)
        t = LIGHT[face] + 0.45 * (0.5 - y / 6) + (-0.35 if x % 3 == 2 else 0.1 if x % 3 == 0 else 0) + (_h(x, y, 5) - 0.5) * 0.2
        return tone(RED, LIGHT[face]) if y == h - 1 else tone(CLOTH, t)
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
        sheet.alpha_composite(hat.resize((512, 256), Image.NEAREST), (0, 0))
        sheet.alpha_composite(vest.resize((512, 256), Image.NEAREST), (520, 0))
        sheet.alpha_composite(hat_icon().resize((192, 192), Image.NEAREST), (540, 290))
        sheet.alpha_composite(vest_icon().resize((192, 192), Image.NEAREST), (760, 290))
        sheet.save(sys.argv[1])
    print('gear written')
