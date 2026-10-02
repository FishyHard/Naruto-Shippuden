"""The Hokage's hat and the jonin vest's inventory icons: the original mod's own drawings (48 and 36 pixels), redrawn by
hand at vanilla's 16x16 with the same shapes, colours and black outline. `python3 gear_icons.py [preview.png]`."""
import os
import sys
from PIL import Image

from skins import TREES

HAT = [
    "................",
    ".......KK.......",
    ".....KKRRKK.....",
    "...KKRRRRRRKK...",
    ".KKRRRRRRRLRRKK.",
    "KRRRRRRRRLRLRRRK",
    ".KrrrrKWKrrrrrK.",
    "..KWWKWrWKWWWK..",
    "..KWWKKKKKWDWK..",
    ".KWDWKgggKWDWWK.",
    ".KWDWKgggKWWWWK.",
    ".KWWWKgggKWWDWK.",
    "KWWWWKKKKKWWDWWK",
    "KWWDWWK..KWWWWWK",
    ".KKWWK....KWWKK.",
    "...KK......KK...",
]
VEST = [
    "................",
    "................",
    "....KKKKKKKK....",
    "...KLGGddGGLK...",
    "..KGGKGddGKGGK..",
    ".KGGGGKzzKGGGGK.",
    ".KGGGGGzGGGGGGK.",
    ".KGKKKGZGKKKGGK.",
    ".KGKGKGzGKGKGGK.",
    ".KGKKKGZGKKKGGK.",
    ".KdKGKGzGKGKGGK.",
    ".KdKKKGZGKKKGGK.",
    ".KddGGGzGGGGGGK.",
    ".KKdddGZGGGGGKK.",
    "..KKKKKKKKKKKK..",
    "................",
]
COLOURS = {
    'K': (0, 0, 0, 255),
    'R': (0x93, 0x21, 0x00, 255), 'r': (0x6E, 0x18, 0x00, 255), 'L': (0xC0, 0xB8, 0xB8, 255),
    'W': (0xF0, 0xF0, 0xF0, 255), 'D': (0x2A, 0x2A, 0x2A, 255), 'g': (0xD6, 0xD6, 0xD6, 255),
    'G': (0x78, 0x90, 0x78, 255), 'd': (0x5C, 0x72, 0x5E, 255), 'z': (0x50, 0x68, 0x52, 255), 'Z': (0x8E, 0xA4, 0x8E, 255),
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
