"""The mission scrolls' inventory icons, D to SS, drawn at vanilla's 16x16 after u/SirIkaros' "How to texture like
Minecraft": first the shape (a hanging scroll: two rollers wider than the paper, rounded caps), then the outline (each
material's darker, more saturated colour; the top outline lighter, a second darker colour along the bottom), the shading
(darker = more saturated, light from the top left), and dirt (neighbouring shades let in). The rank is inked on the paper
in its colour, and the scroll gets finer as the rank rises: wooden caps (D), copper (C), iron (B), gold (A), gold and a red
cord (S), dark lacquered rollers with gold and a purple cord (SS). `python3 rank_icons.py [preview.png]`."""
import os
import sys
from PIL import Image

from skins import TREES

SHAPE = [
    "................",
    ".cCRRRRRRRRRRCc.",
    ".kKrrrrrrrrrrKk.",
    "...OppppppppO...",
    "...OpmmmmmmsO...",
    "...OpmmmmmmsO...",
    "...OpmmmmmmsO...",
    "...OpmmmmmmsO...",
    "...OpmmmmmmsO...",
    "...OpmmmmmmsO...",
    "...OpmmmmmmsO...",
    "...OssssssssO...",
    ".cCRRRRRRRRRRCc.",
    ".kKrrrrrrrrrrKk.",
    "..qqqqqqqqqqqq..",
    "................",
]
FONT = {
    'D': ["XXX.", "X..X", "X..X", "X..X", "X..X", "XXX."],
    'C': [".XXX", "X...", "X...", "X...", "X...", ".XXX"],
    'B': ["XXX.", "X..X", "XXX.", "X..X", "X..X", "XXX."],
    'A': [".XX.", "X..X", "X..X", "XXXX", "X..X", "X..X"],
    'S': [".XXX", "X...", ".XX.", "...X", "...X", "XXX."],
}
SMALL = {'S': [".XX", "X..", ".X.", "..X", "..X", "XX."]}
# the paper: outline (saturated tan), light edge, mid, shade
PAPER = {'O': '#8A6430', 'p': '#F6EDCF', 'm': '#E6D6A6', 's': '#CBB27A', 'dirt': '#D8C48E'}
RANKS = {
    # ink (light, dark), roller wood (lit top, shaded bottom), cap (lit, shaded), bottom outline, cord or None
    'd': dict(ink=('#5C4630', '#3A2A1A'), wood=('#B0814A', '#7A5530'), cap=('#8A6034', '#5C3E20'), under='#3E2A16', cord=None),
    'c': dict(ink=('#3A8A3E', '#1F5A24'), wood=('#B0814A', '#7A5530'), cap=('#E08A56', '#A0502E'), under='#3E2A16', cord=None),
    'b': dict(ink=('#2E66C8', '#173E84'), wood=('#B0814A', '#7A5530'), cap=('#F0F0F0', '#9C9CA6'), under='#3E2A16', cord=None),
    'a': dict(ink=('#CC2E2E', '#7E1616'), wood=('#8C5A34', '#5A3820'), cap=('#FADC5A', '#C0961E'), under='#2E1C0E', cord=None),
    's': dict(ink=('#D6941A', '#8A5A0C'), wood=('#6A4428', '#422814'), cap=('#FADC5A', '#C0961E'), under='#24160A', cord=('#D8403A', '#8E1E1E')),
    'ss': dict(ink=('#8A3ACC', '#521E84'), wood=('#5A4854', '#34282F'), cap=('#FADC5A', '#C0961E'), under='#1C1418', cord=('#B05CE8', '#6A2A9C')),
}


def hexc(h):
    h = h.lstrip('#')
    return (int(h[0:2], 16), int(h[2:4], 16), int(h[4:6], 16), 255)


def scroll(rank):
    r = RANKS[rank]
    pal = dict(PAPER)
    pal.update({'R': r['wood'][0], 'r': r['wood'][1], 'C': r['cap'][0], 'K': r['cap'][1], 'c': r['cap'][1], 'k': r['under'],
                'q': r['under']})
    im = Image.new('RGBA', (16, 16), (0, 0, 0, 0))
    for y, row in enumerate(SHAPE):
        for x, ch in enumerate(row):
            if ch in pal:
                im.putpixel((x, y), hexc(pal[ch]))
    px = lambda x, y, c: im.putpixel((x, y), hexc(c))
    # dirt: neighbouring shades let in, in the paper and along the rollers
    for (x, y) in ((6, 9), (9, 5), (7, 10), (10, 8)):
        px(x, y, PAPER['dirt'])
    for x in (5, 9):
        px(x, 1, r['wood'][1]); px(x + 1, 12, r['wood'][1])
    # the rank inked on the paper, its strokes a darker shade along their bottom and right
    text = rank.upper()
    glyphs = [FONT[ch] for ch in text] if len(text) == 1 else [SMALL['S'], SMALL['S']]
    width = sum(len(g[0]) for g in glyphs) + len(glyphs) - 1
    x0 = 4 + (8 - width + 1) // 2
    for g in glyphs:
        for dy, row in enumerate(g):
            for dx, v in enumerate(row):
                if v != 'X':
                    continue
                edge = dy + 1 >= len(g) or g[dy + 1][dx] != 'X'
                px(x0 + dx, 4 + dy, r['ink'][1] if edge else r['ink'][0])
        x0 += len(g[0]) + 1
    # the finest scrolls' cord, hanging from the bottom roller's middle
    if r['cord']:
        px(7, 14, r['cord'][0]); px(8, 14, r['cord'][1]); px(7, 15, r['cord'][1])
    return im


if __name__ == '__main__':
    icons = {k: scroll(k) for k in RANKS}
    for t in TREES:
        d = os.path.join(t, 'assets/naruto_shippuden/textures/items')
        os.makedirs(d, exist_ok=True)
        for k, im in icons.items():
            im.save(os.path.join(d, 'mission_rank_%s.png' % k))
    if len(sys.argv) > 1:
        sheet = Image.new('RGBA', (6 * 130 + 6 * 20, 130), (139, 139, 139, 255))
        for i, im in enumerate(icons.values()):
            sheet.alpha_composite(im.resize((120, 120), Image.NEAREST), (i * 130 + 5, 5))
            sheet.alpha_composite(im, (6 * 130 + i * 20 + 2, 60))
        sheet.save(sys.argv[1])
    print('rank scrolls written')
