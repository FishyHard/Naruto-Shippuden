"""The Genin headbands' inventory icons (five villages x blue, red, black cloth), at vanilla's 16x16 after u/SirIkaros' guide
(see rank_icons.py). The old 64x64 icons shrank their symbols to a smudge in the slot, so here the metal plate fills the icon
front-on and the village's symbol is engraved across most of it, big and dark against the polished plate with a lit lip
under each groove, so the five read apart at a glance: the Leaf's spiral, the Sand's hourglass, the Mist's slashes, the
Cloud's cloud, the Stone's peaks. The cloth shows round the plate, its knot's tails at the top right.
`python3 band_icons.py [preview.png]`."""
import os
import sys
from PIL import Image

from skins import TREES

BAND = [
    "................",
    "............kk..",
    "...........kLLk.",
    "..bbbbbbbbbbbbk.",
    "LTTTTTTTTTTTTTTB",
    "LOhhhhhhhhhhhhOB",
    "LOhppppppppppmOS",
    "BOhppppppppppmOS",
    "BOhppppppppppmOS",
    "BOhppppppppppmOS",
    "BOhppppppppppmOS",
    "SOmmmmmmmmmmmmOS",
    "SQQQQQQQQQQQQQQk",
    ".kkSSSSSSSSSSkk.",
    "...kkkkkkkkkk...",
    "................",
]
# the plate: its outline (lighter along the top, darkest along the bottom), the lit rim, the polished face, its shade
PLATE = {'T': '#5C6678', 'O': '#353B4C', 'Q': '#1C2030', 'h': '#BCC4CE', 'p': '#9AA2B0', 'm': '#7C8494'}
GROOVE, LIP = '#262B3A', '#B4BCC8'
CLOTH = {
    # light, base, shade, outline (dark, saturated), the ring's inside
    'blue': ('#4C70D4', '#2E4EB4', '#213A8E', '#121C58', '#0E1640'),
    'red': ('#D4504A', '#AC302E', '#82222A', '#561218', '#3A0A10'),
    'black': ('#565666', '#3A3A48', '#2A2A35', '#16161D', '#0C0C11'),
}
# each symbol in the plate's face (x 3..12, y 6..10), '#' a groove
SYMBOLS = {
    'leaf': ["..#####..",
             ".#.....#.",
             ".#.###.#.",
             "##.#...#.",
             "#..#####."],
    'sand': [".#######.",
             "..#...#..",
             "...#.#...",
             "..#...#..",
             ".#######."],
    'mist': ["....#..#.",
             "...#..#..",
             "..#..#..#",
             ".#..#..#.",
             "#..#..#.."],
    'cloud': ["..##.##..",
              ".#..#..#.",
              "#.......#",
              "#.......#",
              ".#######."],
    'stone': ["...#.....",
              "..#.#.#..",
              ".#...#.#.",
              "#.......#",
              "#########"],
}


def hexc(h):
    h = h.lstrip('#')
    return (int(h[0:2], 16), int(h[2:4], 16), int(h[4:6], 16), 255)


def band(village, colour):
    light, base, shade, out, inside = CLOTH[colour]
    pal = dict(PLATE)
    pal.update({'L': light, 'B': base, 'S': shade, 'k': out, 'b': inside})
    im = Image.new('RGBA', (16, 16), (0, 0, 0, 0))
    for y, row in enumerate(BAND):
        assert len(row) == 16
        for x, ch in enumerate(row):
            if ch in pal:
                im.putpixel((x, y), hexc(pal[ch]))
    # dirt: the cloth's shades let into each other, a scuff on the plate
    for (x, y, c) in ((0, 6, base), (15, 7, shade), (5, 13, base), (10, 13, out), (7, 5, PLATE['p'])):
        im.putpixel((x, y), hexc(c))
    sym = SYMBOLS[village]
    x0 = 3 + (10 - len(sym[0])) // 2
    grooves = {(x0 + dx, 6 + dy) for dy, row in enumerate(sym) for dx, v in enumerate(row) if v == '#'}
    for x, y in grooves:
        im.putpixel((x, y), hexc(GROOVE))
    # the groove's lower lip catches the light, where the plate's face shows below it
    for x, y in grooves:
        if (x, y + 1) not in grooves and 3 <= x <= 12 and y + 1 <= 10:
            im.putpixel((x, y + 1), hexc(LIP))
    return im


if __name__ == '__main__':
    icons = {(v, c): band(v, c) for v in SYMBOLS for c in CLOTH}
    for t in TREES:
        d = os.path.join(t, 'assets/naruto_shippuden/textures/items')
        os.makedirs(d, exist_ok=True)
        for (v, c), im in icons.items():
            im.save(os.path.join(d, 'hidden_%s_%s_inventory.png' % (v, c)))
    if len(sys.argv) > 1:
        sheet = Image.new('RGBA', (5 * 136, 3 * 136 + 30), (139, 139, 139, 255))
        for i, v in enumerate(SYMBOLS):
            for j, c in enumerate(CLOTH):
                sheet.alpha_composite(icons[v, c].resize((128, 128), Image.NEAREST), (i * 136 + 4, j * 136 + 4))
                sheet.alpha_composite(icons[v, c], (i * 60 + j * 18 + 4, 3 * 136 + 8))
        sheet.save(sys.argv[1])
    print(len(icons), 'headbands written')
