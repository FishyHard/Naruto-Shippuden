"""Makes data/hokage_rock_faces.json, the carving map for the Hokage Rock, from a front-on picture of the cliff.

    <venv with Pillow>/python rock_map.py <picture> <vanilla block textures dir>

The picture is cropped to the faces; each block-sized cell gets a block (the stone whose texture colour is nearest) and a
depth: the heads bulge out as 3D shapes (ellipses below, in crop pixels), and the picture's shading carves the detail into
them (dark = deeper). Only the map is kept, not the picture."""
import json, math, os, sys
from PIL import Image, ImageFilter

CROP = (420, 40, 1280, 520)     # the faces, in the 1710x900 picture
PX = 6.0                        # picture pixels per block
HEADS = [  # name, centre x, y, radius x, y (crop pixels), how far it stands out (blocks)
    ('first', 115, 225, 92, 150, 13),
    ('second', 285, 280, 82, 140, 15),
    ('third', 455, 175, 115, 170, 12),
    ('fourth', 590, 330, 95, 150, 16),
    ('fifth', 765, 190, 100, 160, 12),
]
FEATURES = {  # name: face centre x, eye line y, nose tip y, mouth y, chin y, half face width (crop pixels)
    'first': (117, 210, 248, 275, 318, 50),
    'second': (292, 283, 320, 347, 382, 52),
    'third': (458, 152, 192, 228, 270, 55),
    'fourth': (588, 345, 385, 415, 452, 42),
    'fifth': (772, 150, 188, 225, 262, 42),
}


def band(t, a, b, soft=0.15):
    """1 inside a..b, easing to 0 over `soft` outside it."""
    if t < a - soft or t > b + soft:
        return 0.0
    if t < a:
        return (t - a + soft) / soft
    if t > b:
        return (b + soft - t) / soft
    return 1.0


def relief(name, px, py):
    """The sculpted shape of a face, in blocks out (+) or in (-): a brow that overhangs deep-set eyes, a nose that stands
    well out with a shadowed underside, cheekbones, a cut mouth, a jutting chin and a deep recess under the jaw, so the
    features still read from below and from the side, where the picture's shading alone would look flat."""
    cx, ey, ny, my, chy, hw = FEATURES[name]
    unit = ny - ey
    u = (px - cx) / hw
    v = (py - ey) / unit                    # 0 at the eyes, 1 at the nose tip
    vm = (py - my) / unit
    vc = (py - chy) / unit
    au = abs(u)
    r = 0.0
    r += 2.5 * band(v, -0.65, -0.2) * band(au, 0, 0.95)                             # the brow
    r -= 3.0 * band(v, -0.15, 0.4, 0.12) * band(au, 0.15, 0.72, 0.1)                # the eye sockets
    r += (1.5 + 3.5 * max(0.0, min(1.0, v))) * band(v, -0.3, 1.0, 0.05) * band(au, 0, 0.1 + 0.12 * max(0, v), 0.06)  # the nose
    r -= 1.5 * band(v, 1.08, 1.3, 0.05) * band(au, 0, 0.35)                         # under the nose
    r += 1.2 * band(v, 0.45, 1.0) * band(au, 0.3, 0.8)                              # the cheekbones
    r -= 1.8 * band(vm, -0.08, 0.08, 0.06) * band(au, 0, 0.42, 0.08)                # the mouth
    r += 1.5 * band(vc, -0.7, -0.05) * band(au, 0, 0.45)                            # the chin
    r -= 4.0 * band(vc, 0.1, 0.9, 0.12) * band(au, 0, 0.9)                          # the shadow under the jaw
    r -= 1.8 * band(au, 0.95, 1.2, 0.08) * band(v, -0.8, (chy - ey) / unit)         # the face's edge, apart from the hair
    return r


STONES = ['sandstone', 'smooth_sandstone', 'cut_sandstone', 'smooth_red_sandstone', 'terracotta', 'brown_terracotta',
          'white_terracotta', 'granite', 'polished_granite', 'packed_mud', 'dripstone_block', 'mud_bricks',
          'pink_terracotta']


def main(picture, textures):
    def avg(name):
        for n in (name, name + '_top', name.replace('smooth_', '') + '_top'):
            p = os.path.join(textures, n + '.png')
            if os.path.exists(p):
                return Image.open(p).convert('RGB').resize((1, 1), Image.Resampling.BOX).getpixel((0, 0))
        raise SystemExit('no texture for ' + name)
    palette = [(s, avg(s)) for s in STONES]
    im = Image.open(picture).convert('RGB').crop(CROP)
    w, h = int(im.width / PX), int(im.height / PX)
    small = im.resize((w, h), Image.Resampling.BOX)
    lum = small.convert('L')
    blur = lum.filter(ImageFilter.GaussianBlur(4))
    cells = []
    top = []
    for x in range(w):
        # the cliff's top in this column: the first cell from the top that is rock (warm), not sky or the buildings above
        t = 0
        for y in range(h):
            r, g, b = small.getpixel((x, y))
            if r > b + 18 and not (r > 200 and g > 190 and b > 180):
                t = y
                break
        top.append(t)
    for y in range(h):
        row = []
        for x in range(w):
            r, g, b = small.getpixel((x, y))
            stone = min(palette, key=lambda p: sum((a - c) ** 2 for a, c in zip(p[1], (r, g, b))))[0]
            detail = (lum.getpixel((x, y)) - blur.getpixel((x, y))) / 14.0
            heads = {}
            for name, cx, cy, rx, ry, out in HEADS:
                e = ((x * PX - cx) / rx) ** 2 + ((y * PX - cy) / ry) ** 2
                if e < 1:
                    shape = out * math.sqrt(1 - e) ** 0.7 + relief(name, x * PX, y * PX)
                    heads[name] = round(max(0.3, shape), 2)
            row.append([STONES.index(stone), round(detail, 2), heads])
        cells.append(row)
    out = os.path.join(os.path.dirname(os.path.abspath(__file__)), 'data', 'hokage_rock_faces.json')
    json.dump({'w': w, 'h': h, 'stones': STONES, 'top': top, 'cells': cells}, open(out, 'w'), separators=(',', ':'))
    print(out, w, h)


if __name__ == '__main__':
    main(sys.argv[1], sys.argv[2])
