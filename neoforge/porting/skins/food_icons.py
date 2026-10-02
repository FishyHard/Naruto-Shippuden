"""Ichiraku ramen's inventory icon, drawn by hand at vanilla's 16x16 like the vanilla soups (mushroom stew, rabbit stew):
the white Ichiraku bowl with its red meander band and 一, the broth with chashu, a half egg, a naruto fishcake and green
onion, chopsticks resting in it. Shaded the vanilla way (gear_icons.py): no black outline, each material's own darkest
colour instead, lighter along the top and darker along the bottom, light from the top left.
`python3 food_icons.py [preview.png]`."""
import os
import sys
from PIL import Image

from skins import TREES

RAMEN = [
    "............S...",
    "...........S..S.",
    "..........S..S..",
    "....kkkkkSkkS...",
    "..kkhhhhShhSkk..",
    ".ohEYBCCNPsGBmo.",
    ".ohEEbcCPNBgbmo.",
    ".olhhhhhhhhhhmo.",
    ".olRrRrRrRrRrdo.",
    "..olhhllllllmo..",
    "..olhllRRRllmo..",
    "...olllllllmo...",
    "....omllllmdo...",
    ".....qddddq.....",
    ".....qqqqqq.....",
    "................",
]
COLOURS = {
    # the bowl: white ceramic, its outline the darkest of it (lighter along the top, darker underneath)
    'o': '#6E6C7E', 'k': '#9C9AAA', 'q': '#4E4C5C',
    'h': '#FFFFFF', 'l': '#EBEAF0', 'm': '#CFCED8', 'd': '#ABAAB8',
    'R': '#B01E2A', 'r': '#D8463E',
    # the broth and what's in it
    'B': '#E9C88C', 'b': '#CFA463', 'C': '#C47A62', 'c': '#9C5444', 'E': '#FBF6EA', 'Y': '#F0A030',
    'N': '#FBF8F2', 'P': '#E5577A', 'G': '#7CC844', 'g': '#4C9A2C',
    # the chopsticks (darker where they're in the broth)
    'S': '#E6C48A', 's': '#B48A52',
}


def draw(rows):
    im = Image.new('RGBA', (16, 16), (0, 0, 0, 0))
    for y, row in enumerate(rows):
        assert len(row) == 16, (y, row)
        for x, ch in enumerate(row):
            if ch in COLOURS:
                c = COLOURS[ch].lstrip('#')
                im.putpixel((x, y), (int(c[0:2], 16), int(c[2:4], 16), int(c[4:6], 16), 255))
    return im


if __name__ == '__main__':
    ramen = draw(RAMEN)
    for t in TREES:
        d = os.path.join(t, 'assets/naruto_shippuden/textures/items')
        os.makedirs(d, exist_ok=True)
        ramen.save(os.path.join(d, 'ichiraku_ramen.png'))
    if len(sys.argv) > 1:
        sheet = Image.new('RGBA', (180, 180), (139, 139, 139, 255))
        sheet.alpha_composite(ramen.resize((160, 160), Image.NEAREST), (10, 10))
        sheet.save(sys.argv[1])
    print('ramen written')
