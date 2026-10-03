"""The Susanoo's textures (client/SusanooModels), one per owner, 256x256, drawn as code in vanilla's way: a few tones in clumps,
light from above, nothing smooth. Every box of a Susanoo takes its pixels from one zone of the texture:

    chakra (0,0 128x128)   the flesh: mottled chakra, see-through, the way the anime's Susanoo looks
    bone   (128,0 128x64)  ribs, skull, teeth: paler and denser
    armour (128,64 128x64) plates in rows, each with a lit lip and a dark seam, a rivet here and there
    dark   (0,128 64x64)   mouths, sockets, Obito's shuriken: deep and nearly opaque
    flame  (64,128 64x64)  flame: tongues of light with gaps between them
    eye    (128,128 16x16) the glowing eyes
    weapon (144,128 112x64) bows, blades: the brightest core
    mark   (0,192 128x64)  the owner's markings: Itachi's spirals, Shisui's rings, a mask's lines
    plate  (128,192 128x64) trims, sashes, feathers: dark with lit edges

`python3 susanoo.py [sheet.png]` writes textures/entities/susanoo/<owner>.png into both resource trees."""
import colorsys
import math
import os
import sys

from PIL import Image

HERE = os.path.dirname(os.path.abspath(__file__))
NEO = os.path.normpath(os.path.join(HERE, '..', '..'))
TREES = [os.path.join(NEO, 'src/main/resources'), os.path.join(NEO, 'porting/res_override')]

OWNERS = {
    #          base       light      dark       eyes
    'sasuke': ('#8E5BE8', '#C9A6FF', '#4A2694', '#FFE680'),
    'itachi': ('#E8542E', '#FFA066', '#8A2014', '#FFE680'),
    'shisui': ('#3FC66A', '#A6F7B6', '#1C743A', '#F2FFE6'),
    'madara': ('#4466E8', '#9CBAFF', '#1C2C88', '#E6F2FF'),
    'obito': ('#7EC0E0', '#D6F4FF', '#3E7090', '#FFFFFF'),
}


def rgb(h):
    h = h.lstrip('#')
    return tuple(int(h[i:i + 2], 16) for i in (0, 2, 4))


def mix(a, b, t):
    return tuple(int(a[i] + (b[i] - a[i]) * t + 0.5) for i in range(3))


def _h(x, y, salt):
    v = (x * 73856093) ^ (y * 19349663) ^ (salt * 83492791)
    v = (v ^ (v >> 13)) * 1274126177
    return ((v ^ (v >> 16)) & 0xffffffff) / 0xffffffff


def noise(x, y, cell, salt):
    """Smooth value noise in 0..1 over cells of `cell` pixels."""
    gx, gy = x / cell, y / cell
    x0, y0 = int(math.floor(gx)), int(math.floor(gy))
    fx, fy = gx - x0, gy - y0
    fx, fy = fx * fx * (3 - 2 * fx), fy * fy * (3 - 2 * fy)
    a, b = _h(x0, y0, salt), _h(x0 + 1, y0, salt)
    c, d = _h(x0, y0 + 1, salt), _h(x0 + 1, y0 + 1, salt)
    return (a + (b - a) * fx) + ((c + (d - c) * fx) - (a + (b - a) * fx)) * fy


def ramp(base, light, dark):
    return [dark, mix(dark, base, 0.5), base, mix(base, light, 0.5), light]


def zone(im, x0, y0, w, h, fn):
    for y in range(h):
        for x in range(w):
            c = fn(x, y)
            if c is not None:
                im.putpixel((x0 + x, y0 + y), c)


def texture(name):
    base, light, dark, eye = (rgb(c) for c in OWNERS[name])
    r = ramp(base, light, dark)
    salt = sum(map(ord, name))
    im = Image.new('RGBA', (256, 256), (0, 0, 0, 0))

    def chakra(x, y):
        # the mottled chakra: big soft blots in four tones, quantised (no gradients), and the odd bright fleck
        n = noise(x, y, 6, salt) * 0.65 + noise(x, y, 3, salt + 7) * 0.35
        k = 1 if n < 0.32 else 2 if n < 0.55 else 3 if n < 0.78 else 4
        if _h(x, y, salt + 3) < 0.04:
            k = min(4, k + 1)
        a = 140 + (k - 2) * 18
        return r[k] + (a,)
    zone(im, 0, 0, 128, 128, chakra)

    bone_r = ramp(mix(base, (255, 255, 255), 0.35), mix(light, (255, 255, 255), 0.55), mix(base, dark, 0.3))

    def bone(x, y):
        n = noise(x, y, 4, salt + 11)
        k = 2 if n < 0.45 else 3 if n < 0.8 else 4
        if y % 6 == 5 or _h(x, y, salt + 13) < 0.05:
            k = 1                                             # cracks and the joins between segments
        return bone_r[k] + (205,)
    zone(im, 128, 0, 128, 64, bone)

    def armour(x, y):
        row = y % 5
        k = 3 if row == 0 else 0 if row == 4 else 2
        if row in (1, 2) and noise(x, y, 5, salt + 17) > 0.62:
            k = 3
        if row == 2 and x % 9 == 4:
            k = 4                                             # rivets
        return mix(r[k], dark, 0.15) + (215,)
    zone(im, 128, 64, 128, 64, armour)

    def deep(x, y):
        k = 0 if noise(x, y, 3, salt + 19) < 0.6 else 1
        return mix(r[k], (10, 6, 16), 0.55) + (225,)
    zone(im, 0, 128, 64, 64, deep)

    def flame(x, y):
        # tongues rising in every band of eight rows, gaps between them
        band = y % 8
        tongue = int(noise(x, y // 8, 2, salt + 23) * 9)
        if band < 8 - tongue:
            return (0, 0, 0, 0)
        k = 4 if band >= 6 else 3 if band >= 3 else 2
        return r[k] + (170 + band * 8,)
    zone(im, 64, 128, 64, 64, flame)

    zone(im, 128, 128, 16, 16, lambda x, y: (mix(eye, (255, 255, 255), 0.4) if (x + y) % 5 == 0 else eye) + (255,))

    def weapon(x, y):
        n = noise(x, y, 3, salt + 29)
        return (mix(light, (255, 255, 255), 0.3) if n > 0.55 else light) + (235,)
    zone(im, 144, 128, 112, 64, weapon)

    def mark(x, y):
        tx, ty = x % 8 - 3.5, y % 8 - 3.5
        d = math.hypot(tx, ty)
        if name == 'itachi':
            # a spiral: the line's angle winds with its distance
            a = (math.atan2(ty, tx) / (2 * math.pi) + d / 3.2) % 1
            on = a < 0.25 and d < 4
        elif name == 'shisui':
            on = 2.2 < d < 3.4
        else:
            on = x % 8 == 0 or y % 8 == 0
        c = mix(r[0], dark, 0.4) if on else r[2]
        return c + (200 if on else 150,)
    zone(im, 0, 192, 128, 64, mark)

    def plate(x, y):
        edge = y % 6 in (0, 5) or x % 12 == 0
        return (r[3] if edge else mix(r[1], dark, 0.3)) + (220,)
    zone(im, 128, 192, 128, 64, plate)
    return im


if __name__ == '__main__':
    out = sys.argv[1] if len(sys.argv) > 1 else None
    sheet = Image.new('RGBA', (len(OWNERS) * 264, 264), (60, 60, 60, 255))
    for i, name in enumerate(OWNERS):
        im = texture(name)
        for t in TREES:
            d = os.path.join(t, 'assets/naruto_shippuden/textures/entities/susanoo')
            os.makedirs(d, exist_ok=True)
            im.save(os.path.join(d, name + '.png'))
        sheet.alpha_composite(im, (i * 264 + 4, 4))
    if out:
        sheet.save(out)
    print(len(OWNERS), 'textures')
