"""The ninja tools' and story papers' inventory icons, drawn at vanilla's 16x16 after u/SirIkaros' "How to texture like
Minecraft" (see rank_icons.py): shape first, an outline in each material's darker, more saturated colour (lighter along the
top, a second dark along the bottom), shading lit from the top left, then a few dirty pixels. Held tools lie on the vanilla
diagonal, handle bottom left, point top right: the Iron Stick and Iron Blade they're forged from, the kunai (poisoned: its tip
coated purple; explosive: a tag tied on), the shuriken. The papers are vanilla paper's sheet: the Clan Paper with its "?",
the Chakra Paper with the five natures' dots, and the resets the same papers struck through in red. The DNA keeps its bottle.
`python3 tool_icons.py [preview.png]`."""
import os
import sys
from PIL import Image

from skins import TREES


def hexc(h):
    h = h.lstrip('#')
    return (int(h[0:2], 16), int(h[2:4], 16), int(h[4:6], 16), 255)


def draw(rows, colours):
    im = Image.new('RGBA', (16, 16), (0, 0, 0, 0))
    assert len(rows) == 16
    for y, row in enumerate(rows):
        assert len(row) == 16, (y, row)
        for x, ch in enumerate(row):
            if ch in colours:
                im.putpixel((x, y), hexc(colours[ch]))
    return im


def put(im, pixels, colour):
    for x, y in pixels:
        im.putpixel((x, y), hexc(colour))


# iron, slightly cool like vanilla's: highlight, light, mid, shade, outline (top, lighter), outline (bottom, darkest)
IRON = dict(hi='#E2E7EE', li='#B6BECA', mid='#8F97A5', sh='#6A7282', top='#566070', out='#323848', low='#1C2030')


def diagonal(cells):
    """A tool along the vanilla diagonal. cells(t, s) -> colour or None, where t = x - y runs along the tool from the bottom
    left (-14) to the top right (14), and s = x + y - 15 across it, negative on the lit upper-left side."""
    im = Image.new('RGBA', (16, 16), (0, 0, 0, 0))
    for y in range(16):
        for x in range(16):
            c = cells(x - y, x + y - 15)
            if c:
                im.putpixel((x, y), hexc(c))
    return im


def iron_stick():
    def cells(t, s):
        if not -11 <= t <= 11:
            return None
        end = abs(t) == 11
        if s == -1:
            return IRON['top'] if end else (IRON['li'] if t % 5 else IRON['mid'])
        if s == 0:
            return IRON['out'] if end else (IRON['hi'] if -7 <= t <= -3 else IRON['mid'] if t % 4 else IRON['sh'])
        if s == 1:
            return IRON['low'] if t > -11 else None
        return None
    return diagonal(cells)


def iron_blade():
    """An unhandled straight blade: a square tang at the bottom left, the edge widening off it, a point at the top right."""
    def cells(t, s):
        if -12 <= t <= -8:                      # the tang, dark unpolished iron
            if s in (0, 1):
                return IRON['sh'] if s == 0 and t > -12 else IRON['out']
            return None
        if not -7 <= t <= 12:
            return None
        half = 2 if t <= 6 else (1 if t <= 10 else 0)
        lo, hi = -half - (0 if half else 0), half + 1
        if not lo <= s <= hi:
            return None
        if t == 12 or (t == 11 and s == 1):
            return IRON['out']
        if s == lo:
            return IRON['top']
        if s == hi:
            return IRON['low']
        if t == -7:                             # the shoulder
            return IRON['out']
        # the bevel: the lit edge, the polished flat, the ridge's shade
        k = s - lo
        shade = [IRON['top'], IRON['hi'] if -4 <= t <= 2 else IRON['li'], IRON['mid'], IRON['mid'], IRON['sh']][min(k, 4)]
        if k == 1 and t in (5, 9):
            shade = IRON['mid']                 # dirt: neighbouring shades let in
        if k == 2 and t in (-2, 4):
            shade = IRON['li']
        if k in (2, 3) and t in (0, 7):
            shade = IRON['sh']
        return shade
    return diagonal(cells)


def kunai(tip=None, tag=False):
    """The kunai: a ring, a cloth-wrapped grip, the leaf-shaped blade with its ridge. tip: (light, dark) poison on the blade's
    point half. tag: an explosive tag tied on below the blade."""
    WRAP = ('#A8946A', '#7E6A44', '#4A3A20')
    GRIP = ('#3C3844', '#26242C', '#141318')

    def cells(t, s):
        if 1 <= t <= 13:                         # the blade: widest a third of the way up, a ridge down its middle
            half = {1: 1, 2: 1, 3: 2, 4: 2, 5: 2, 6: 2, 7: 2, 8: 1, 9: 1, 10: 1, 11: 0, 12: 0, 13: 0}[t]
            lo, hi = (-half, half + 1) if half else (0, 0 if t > 11 else 1)
            if not lo <= s <= hi:
                return None
            poison = tip and t >= 7
            if t == 13:
                c = IRON['out']
            elif s == lo:
                c = IRON['top']
            elif s == hi:
                c = IRON['low']
            elif s == 0:
                c = IRON['hi'] if 3 <= t <= 5 else IRON['li']   # the ridge's lit face
            elif s < 0:
                c = IRON['li'] if t in (4, 6) else IRON['mid']
            else:
                c = IRON['sh'] if s == hi - 1 and half > 1 else IRON['mid']
            if t == 1 and lo < s < hi:
                c = IRON['sh']                   # the blade's root, in the grip's shadow
            if poison:
                c = {IRON['top']: tip[1], IRON['low']: '#2E1440', IRON['hi']: tip[0], IRON['li']: tip[0],
                     IRON['mid']: tip[1], IRON['sh']: tip[1], IRON['out']: '#2E1440'}[c]
            return c
        if -7 <= t <= 0:                          # the grip: dark iron, cloth wound round it
            if s not in (0, 1):
                return None
            if t == 0:
                return GRIP[2] if s else GRIP[1]
            wound = (t + 7) % 3 == 0
            if s == 0:
                return WRAP[0] if wound else GRIP[0]
            return WRAP[1] if wound else GRIP[2]
        return None
    im = diagonal(cells)
    # the ring at the grip's end, its inside open, lit from the top left
    put(im, [(1, 12), (2, 12), (0, 13)], IRON['mid'])
    put(im, [(3, 12), (0, 14)], IRON['sh'])
    put(im, [(3, 13), (3, 14), (1, 15), (2, 15)], IRON['out'])
    if tip:
        put(im, [(13, 4)], tip[1])               # a drop running off the point
    if tag:
        # the tag hanging from the grip: paper, its seal in red
        put(im, [(9, 10), (10, 10), (9, 11), (9, 12), (9, 13)], '#DCD4BE')
        put(im, [(11, 10), (11, 11), (11, 12), (10, 13), (11, 13)], '#C4B898')
        put(im, [(12, 10), (12, 11), (12, 12), (12, 13), (9, 14), (10, 14), (11, 14), (12, 14)], '#7A6544')
        put(im, [(10, 11), (10, 12)], '#C42A22')
        put(im, [(11, 12)], '#8A1A16')
        put(im, [(8, 9)], '#9C8558')              # its string
    return im


SHURIKEN_ROWS = [
    "................",
    ".......TO.......",
    ".......HQ.......",
    "......THDQ......",
    "......HLMQ......",
    ".....THLMDQ.....",
    "...TTHLOOMDQQ...",
    ".THHHLO..LDDDDQ.",
    ".TLLMMO..LDDDQQ.",
    "...QQMMLLDDQQ...",
    ".....QMDDDQ.....",
    "......MDDQ......",
    "......QDDQ......",
    ".......DQ.......",
    ".......QQ.......",
    "................",
]
# dark blued steel: highlight, light, mid, shade; the outline lighter along the top, darkest along the bottom; the hole's
# near rim in shadow and its far rim catching the light
SHURIKEN = {'H': '#A4ACBC', 'L': '#7C8496', 'M': '#58606F', 'D': '#3E4452', 'T': '#5C6476', 'O': '#22252E', 'Q': '#121419'}


def shuriken():
    im = draw(SHURIKEN_ROWS, SHURIKEN)
    put(im, [(7, 4), (10, 8)], SHURIKEN['M'])           # dirt
    put(im, [(4, 8), (8, 11)], SHURIKEN['L'])
    return im


# the paper: vanilla paper's sheet, outline a saturated grey-tan, lighter on top and a darker one along the bottom
PAPER_ROWS = [
    "................",
    "................",
    "....tttttt......",
    "..ttHHHHHHtttt..",
    ".oHHHHHHHHHHHHo.",
    ".oHPPPPPPPPPPPo.",
    "..oPPPPPPPPPPmo.",
    "..oPPPPPPPPPPmo.",
    "..oPPPPPPPPPPmo.",
    ".oPPPPPPPPPPPmo.",
    ".oPPPPPPPPPPmmo.",
    ".oPmmmmmmmmmmso.",
    "..qqssssssssqq..",
    "......qqqqqq....",
    "................",
    "................",
]
PAPER = {'t': '#A49678', 'H': '#EEE8D8', 'P': '#DCD4BE', 'm': '#C4B898', 's': '#A69676', 'o': '#7A6544', 'q': '#4E3E26'}


def paper(marks):
    im = draw(PAPER_ROWS, PAPER)
    put(im, [(5, 7), (10, 9), (3, 9), (8, 10)], PAPER['m'])     # dirt
    put(im, [(4, 5), (9, 4), (6, 6)], PAPER['H'])
    for colour, pixels in marks:
        put(im, pixels, colour)
    return im


QUESTION = [('#2A2622', [(6, 5), (7, 5), (8, 5), (9, 6), (8, 7), (7, 8), (7, 10)]), ('#55504A', [(5, 6), (9, 7)])]
# fire, water, wind, earth, lightning: each a lit pixel over its darker one
NATURES = [('#F0503A', [(4, 6)]), ('#A82418', [(4, 7)]), ('#4C8CF0', [(10, 5)]), ('#2450A8', [(10, 6)]),
           ('#66D888', [(11, 9)]), ('#2C9A50', [(11, 10)]), ('#A87A48', [(5, 9)]), ('#6E4A26', [(5, 10)]),
           ('#FAE44A', [(8, 8)]), ('#C0A018', [(8, 9)])]
# the red stroke through a reset paper, darker along its lower edge
STRIKE = [('#C8302A', [(3, 4), (4, 5), (5, 6), (6, 7), (8, 8), (9, 9), (10, 10), (11, 11), (11, 4), (10, 5), (9, 6),
                       (7, 8), (6, 9), (5, 10), (4, 11), (7, 7), (8, 7)]),
          ('#801412', [(4, 4), (12, 4), (12, 11), (3, 11), (7, 9), (8, 9)])]

DNA_ROWS = [
    "......kkkk......",
    ".....kCCCCk.....",
    ".....KccccK.....",
    "......gGGg......",
    "......gwRg......",
    ".....gwRrRg.....",
    ".....gwrHrg.....",
    ".....gwRdRg.....",
    ".....gwdRrg.....",
    ".....gwRrRg.....",
    ".....gwrHrg.....",
    ".....gwRdRg.....",
    ".....gwdRrg.....",
    ".....grrrrq.....",
    "......qqqq......",
    "................",
]
# the bottle (old style kept: a stoppered vial of red with the helix in it): cap, glass, liquid, the helix's two strands
DNA = {'k': '#A04430', 'C': '#D8806A', 'c': '#B85E48', 'K': '#6E2A1C', 'g': '#6A7688', 'G': '#C8D2DC', 'w': '#B4C2D0',
       'R': '#C02424', 'r': '#8A1414', 'H': '#E8B4AC', 'd': '#4A0A0E', 'q': '#3E4656'}


def icons():
    return {
        'iron_stick': iron_stick(),
        'sharp_iron': iron_blade(),
        'kunai_texture': kunai(),
        'poison_kunai': kunai(tip=('#9A50C8', '#5E2290')),
        'explosive_kunai_texture': kunai(tag=True),
        'shuriken': shuriken(),
        'clan_paper': paper(QUESTION),
        'chakra_paper': paper(NATURES),
        'clan_reseter': paper(QUESTION + STRIKE),
        'chakra_nature_reseter': paper(NATURES + STRIKE),
        'dna': draw(DNA_ROWS, DNA),
    }


if __name__ == '__main__':
    out = icons()
    for t in TREES:
        d = os.path.join(t, 'assets/naruto_shippuden/textures/items')
        os.makedirs(d, exist_ok=True)
        for k, im in out.items():
            im.save(os.path.join(d, k + '.png'))
    if len(sys.argv) > 1:
        n = len(out)
        sheet = Image.new('RGBA', (6 * 136, 2 * 136 + 40), (139, 139, 139, 255))
        for i, im in enumerate(out.values()):
            sheet.alpha_composite(im.resize((128, 128), Image.NEAREST), ((i % 6) * 136 + 4, (i // 6) * 136 + 4))
            sheet.alpha_composite(im, (i * 20 + 4, 2 * 136 + 12))
        sheet.save(sys.argv[1])
    print(len(out), 'icons written')
