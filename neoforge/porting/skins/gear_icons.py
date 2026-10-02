"""The Hokage's hat and the jonin vest's inventory icons: the original mod's own drawings (48 and 36 pixels), redrawn by
hand at vanilla's 16x16 with the same shapes, colours and black outline. `python3 gear_icons.py [preview.png]`."""
import os
import sys
from PIL import Image

from skins import TREES

# Shaded the vanilla way (u/SirIkaros' guide): each material is a ramp whose darker colours are more saturated and lighter
# ones less; the outline is that material's darkest colour, not black, lighter along the top and with a second, darker
# colour along the bottom; light comes from the top left, and a few pixels of neighbouring shades are let in for grain.
HAT = [
    "................",
    ".......66.......",
    ".....665411.....",
    "...6654433311...",
    ".664433333L3211.",
    "644333333L3L2221",
    ".12222aea222221.",
    "..aedae3dadcba..",
    "..addaaaaacbca..",
    ".aebdaxxxadbcca.",
    ".adbdayyyadccca.",
    ".adddayyyaccbca.",
    "addcdaaaaaccbcca",
    "accbcca..acccbba",
    ".qqbbq....qbbqq.",
    "...qq......qq...",
]
VEST = [
    "................",
    ".....oooooO.....",
    "....ohhllnnO....",
    "...olhOvvOnvO...",
    "..olGOhvvnOGvO..",
    "..olGlOhnOGnvO..",
    "..olGGlOOGGnvO..",
    "..olGGGznGGnvO..",
    "..olPPPZnPPPvO..",
    "..olPpPznPpPvO..",
    "..olPPPZnPPPvO..",
    "..olPpPznPpPvO..",
    "..olPPPZnPPPvO..",
    "..OvnvvzvvvvvO..",
    "..XXXXXXXXXXXX..",
    "................",
]
COLOURS = {
    # the hat's red, its white cloth and the shadow under it
    '6': (0xA0, 0x3A, 0x26, 255), '1': (0x4A, 0x0C, 0x06, 255), '2': (0x7A, 0x18, 0x0A, 255),
    '3': (0xA6, 0x26, 0x12, 255), '4': (0xC4, 0x46, 0x2C, 255), '5': (0xD8, 0x76, 0x60, 255),
    'L': (0xD0, 0xBC, 0xB6, 255),
    'a': (0x4C, 0x4A, 0x58, 255), 'q': (0x2C, 0x2A, 0x38, 255), 'b': (0x9A, 0x9A, 0xA8, 255),
    'c': (0xC6, 0xC6, 0xCC, 255), 'd': (0xE4, 0xE4, 0xE0, 255), 'e': (0xFA, 0xFA, 0xF2, 255),
    'x': (0x2A, 0x24, 0x24, 255), 'y': (0x46, 0x3C, 0x3A, 255),
    # the vest's green, its pockets and zip
    'o': (0x3A, 0x50, 0x30, 255), 'O': (0x1E, 0x2C, 0x18, 255), 'X': (0x10, 0x1A, 0x0C, 255),
    'v': (0x40, 0x58, 0x32, 255), 'n': (0x56, 0x70, 0x44, 255), 'G': (0x6C, 0x88, 0x58, 255),
    'l': (0x88, 0xA2, 0x74, 255), 'h': (0xA8, 0xBC, 0x96, 255),
    'P': (0x2E, 0x42, 0x26, 255), 'p': (0x7E, 0x9A, 0x6A, 255),
    'z': (0x34, 0x46, 0x2C, 255), 'Z': (0x9C, 0xAE, 0x8E, 255),
}


def draw(rows):
    im = Image.new('RGBA', (16, 16), (0, 0, 0, 0))
    for y, row in enumerate(rows):
        for x, ch in enumerate(row):
            if ch in COLOURS:
                im.putpixel((x, y), COLOURS[ch])
    return im


if __name__ == '__main__':
    hat, vest = draw(HAT), draw(VEST)
    for t in TREES:
        d = os.path.join(t, 'assets/naruto_shippuden/textures/item')
        hat.save(os.path.join(d, 'hokage_hat.png'))
        vest.save(os.path.join(d, 'jonin_vest.png'))
    if len(sys.argv) > 1:
        sheet = Image.new('RGBA', (360, 180), (139, 139, 139, 255))
        sheet.alpha_composite(hat.resize((160, 160), Image.NEAREST), (10, 10))
        sheet.alpha_composite(vest.resize((160, 160), Image.NEAREST), (190, 10))
        sheet.save(sys.argv[1])
    print('icons written')
