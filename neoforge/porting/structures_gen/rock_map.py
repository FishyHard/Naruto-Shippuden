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
                    heads[name] = round(out * math.sqrt(1 - e) ** 0.7, 2)
            row.append([STONES.index(stone), round(detail, 2), heads])
        cells.append(row)
    out = os.path.join(os.path.dirname(os.path.abspath(__file__)), 'data', 'hokage_rock_faces.json')
    json.dump({'w': w, 'h': h, 'stones': STONES, 'top': top, 'cells': cells}, open(out, 'w'), separators=(',', ':'))
    print(out, w, h)


if __name__ == '__main__':
    main(sys.argv[1], sys.argv[2])
