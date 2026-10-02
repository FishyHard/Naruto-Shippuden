"""The story's worn gear, drawn as code in the vanilla manner (the same ramps and light as skins.py): the Hokage's hat (its own
model, client/StoryGearClient: a broad stepped cone with a red front panel and the kanji for fire, the cloth hanging at the
back) and the jonin vest (a chestplate on vanilla's armour model). Writes the worn textures and the inventory icons into both
resource trees: `python3 gear.py [preview.png]`."""
import os
import sys
from PIL import Image

from skins import TREES, LIGHT, SIDES, _h, rgb, tone

CLEAR = (0, 0, 0, 0)


def net(u, v, w, h, d):
    """A box's faces on the texture (as ModelPart boxes lay them out)."""
    return {'top': (u + d, v, w, d), 'bottom': (u + d + w, v, w, d), 'right': (u, v + d, d, h), 'front': (u + d, v + d, w, h),
            'left': (u + d + w, v + d, d, h), 'back': (u + 2 * d + w, v + d, w, h)}


def paint_box(im, box, fn):
    for face, (x0, y0, w, h) in net(*box).items():
        for x in range(w):
            for y in range(h):
                c = fn(face, x, y, w, h)
                if c is not None:
                    im.putpixel((x0 + x, y0 + y), c)


def material(base, salt, rough=0.5):
    """Lit per face, a gradient down the sides, darker edges, the grain in clumps (as skins.cloth)."""
    def fn(face, x, y, w, h):
        t = LIGHT[face]
        if face in SIDES:
            t += 0.6 * (0.5 - y / max(1, h - 1)) - (0.25 if x in (0, w - 1) else 0)
        elif face == 'top':
            t -= 0.2 * (x in (0, w - 1) or y in (0, h - 1))
        k = sum(map(ord, face))
        t += (_h((x + y % 2) // 2, y // 2, salt + k) - 0.5) * rough * 1.2
        v = _h(x, y, salt + k + 1)
        t += -0.3 if v < 0.06 else 0.25 if v > 0.95 else 0
        return tone(base, t)
    return fn


# ---------------------------------------------------------------- the Hokage's hat

WHITE, RED, CLOTH = rgb('#F0EEE6'), rgb('#C42A2A'), rgb('#E8E6DE')
# the model's boxes (client/StoryGearClient): texture offset and size (w, h, d)
BRIM = (0, 0, 14, 1, 14)
TIER = (0, 16, 10, 2, 10)
CROWN = (0, 30, 6, 2, 6)
TIP = (24, 30, 2, 1, 2)
VEIL = (0, 40, 9, 8, 1)
FIRE = ['.#..#.', '.####.', '..##..', '.#..#.']   # 火, small


def hokage_hat():
    im = Image.new('RGBA', (64, 64), CLEAR)
    paint_box(im, BRIM, material(WHITE, 3))
    # the brim's rim: a red line round its edge, darker underneath
    def rim(face, x, y, w, h):
        if face == 'bottom':
            return tone(WHITE, -1.0)
        if face in SIDES:
            return tone(RED, LIGHT[face] - (0.2 if x in (0, w - 1) else 0))
        if face == 'top' and (x in (0, w - 1) or y in (0, h - 1)):
            return tone(RED, 0.6)
        return None
    paint_box(im, BRIM, rim)
    paint_box(im, TIER, material(WHITE, 5))
    # the front panel of the tier: red, with the kanji in white
    x0, y0, w, h = net(*TIER)['front']
    for x in range(w):
        for y in range(h):
            if 2 <= x <= 7:
                im.putpixel((x0 + x, y0 + y), tone(RED, 0.3 if y == 0 else -0.2))
    paint_box(im, CROWN, material(WHITE, 7))
    x0, y0, w, h = net(*CROWN)['front']
    for x in range(w):
        im.putpixel((x0 + x, y0), tone(RED, 0.2)); im.putpixel((x0 + x, y0 + 1), tone(RED, -0.3))
    # the kanji goes on the brim's top, in front (it is what shows from the front of a broad hat)
    tx, ty, tw, th = net(*BRIM)['top']
    for r, row in enumerate(FIRE):
        for c, ch in enumerate(row):
            px = (tx + 4 + c, ty + th - 1 - len(FIRE) + r)
            im.putpixel(px, tone(RED, 0.4 if ch == '#' else 0.0) if ch == '#' else im.getpixel(px))
    paint_box(im, TIP, material(RED, 9, 0.3))
    # the white cloth hanging at the back of the neck
    def veil(face, x, y, w, h):
        t = LIGHT[face] + 0.4 * (0.5 - y / 7) + (-0.35 if (x + y // 3) % 3 == 0 else 0)
        return tone(CLOTH, t)
    paint_box(im, VEIL, veil)
    return im


def hat_icon():
    im = Image.new('RGBA', (16, 16), CLEAR)
    rows = [  # a stepped cone seen from the front: the tip, the crown, the tier with its panel, the brim
        '.......rr.......',
        '......wwww......',
        '.....wwwwww.....',
        '....wwRRRRww....',
        '...wwwRwwRww....',
        '..wwwwRRRRwww...',
        '.wwwwwwwwwwwww..',
        'rrrrrrrrrrrrrrr.',
        '.ddddddddddddd..',
    ]
    for y, row in enumerate(rows):
        for x, ch in enumerate(row):
            yy = y + 4
            if ch == 'w':
                im.putpixel((x, yy), tone(WHITE, 0.3 - 0.12 * y + (0.3 if x < 6 else 0)))
            elif ch in 'rR':
                im.putpixel((x, yy), tone(RED, 0.2 - 0.05 * y + (0.3 if x < 6 else 0)))
            elif ch == 'd':
                im.putpixel((x, yy), tone(WHITE, -1.2))
    return outline(im)


# ---------------------------------------------------------------- the jonin vest (vanilla's armour model, 64x32)

VEST = rgb('#5E7050')
BODY = (16, 16, 8, 12, 4)


def jonin_vest():
    im = Image.new('RGBA', (64, 32), CLEAR)
    paint_box(im, BODY, material(VEST, 21, 0.45))
    x0, y0, w, h = net(*BODY)['front']
    put = lambda x, y, t: im.putpixel((x0 + x, y0 + y), tone(VEST, t))
    for y in range(12):
        put(0, y, -0.4); put(7, y, -0.4)
    # the collar, the zip, two rows of scroll pockets each side, the waist band
    for x in range(8):
        put(x, 0, 0.7)
    for y in range(1, 10):
        put(3, y, -1.0); put(4, y, -0.2)
    for (px, py) in ((0, 2), (5, 2), (0, 5), (5, 5)):
        for x in range(px, px + 3):
            put(x, py, 0.6); put(x, py + 1, -0.05); put(x, py + 2, -0.85)
    for x in range(8):
        put(x, 10, -0.3); put(x, 11, -0.7)
    bx, by, bw, bh = net(*BODY)['back']
    for x in range(8):
        im.putpixel((bx + x, by), tone(VEST, 0.2)); im.putpixel((bx + x, by + 10), tone(VEST, -0.9))
    swirl = rgb('#B8322E')
    for (x, y) in ((3, 3), (4, 3), (5, 4), (5, 5), (4, 6), (3, 6), (2, 5), (3, 5), (4, 4)):
        im.putpixel((bx + x, by + y), tone(swirl, -0.1 if (x + y) % 2 else 0.1))
    # the sides open under the arms
    for side in ('left', 'right'):
        sx, sy, sw, sh = net(*BODY)[side]
        for y in range(1, 5):
            for x in (1, 2):
                im.putpixel((sx + x, sy + y), CLEAR)
    tx, ty, tw, th = net(*BODY)['top']
    for x in range(tw):
        for y in range(th):
            im.putpixel((tx + x, ty + y), tone(VEST, 0.9) if (x in (0, tw - 1) or y in (0, th - 1)) else CLEAR)
    return im


def vest_icon():
    im = Image.new('RGBA', (16, 16), CLEAR)
    rows = [
        '...cc....cc.....',
        '..cvvc..cvvc....',
        '..vvvvzzvvvv....',
        '..vppvzzvppv....',
        '..vddvzzvddv....',
        '..vvvvzzvvvv....',
        '..vppvzzvppv....',
        '..vddvzzvddv....',
        '..vvvvzzvvvv....',
        '..bbbbbbbbbb....',
    ]
    for y, row in enumerate(rows):
        for x, ch in enumerate(row):
            yy, xx = y + 3, x + 1
            t = {'c': 0.7, 'v': 0.15 - 0.06 * y + (0.2 if x < 6 else -0.1), 'p': 0.6, 'd': -0.9, 'z': -0.8, 'b': -0.5}.get(ch)
            if t is not None:
                im.putpixel((xx, yy), tone(VEST, t))
    return outline(im)


def outline(im):
    """A dark outline round the icon, as vanilla's items have where they meet the slot."""
    out = im.copy()
    for x in range(16):
        for y in range(16):
            if im.getpixel((x, y))[3]:
                continue
            for dx, dy in ((1, 0), (-1, 0), (0, 1), (0, -1)):
                if 0 <= x + dx < 16 and 0 <= y + dy < 16 and im.getpixel((x + dx, y + dy))[3]:
                    c = im.getpixel((x + dx, y + dy))
                    out.putpixel((x, y), tone(c, -2.4))
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
    save(vest, 'entity/equipment/humanoid/jonin_vest.png')
    save(hat_icon(), 'item/hokage_hat.png')
    save(vest_icon(), 'item/jonin_vest.png')
    if len(sys.argv) > 1:
        sheet = Image.new('RGBA', (64 * 8 + 32 * 8 * 2, 64 * 8), (40, 42, 50, 255))
        sheet.alpha_composite(hat.resize((512, 512), Image.NEAREST), (0, 0))
        sheet.alpha_composite(vest.resize((512, 256), Image.NEAREST), (512, 0))
        sheet.alpha_composite(hat_icon().resize((128, 128), Image.NEAREST), (512, 300))
        sheet.alpha_composite(vest_icon().resize((128, 128), Image.NEAREST), (700, 300))
        sheet.save(sys.argv[1])
    print('gear written')
