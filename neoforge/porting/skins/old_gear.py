"""The original mod's textures for the Hokage's hat and the jonin jacket (for client/OldGearModels), in the vanilla manner:
the jacket's 512px painting brought down to 64px (two pixels a unit of its 32-unit model), and over both the clumped grain
vanilla's textures have, so flat colour reads as cloth. Reads the 1.16 workspace's textures: `python3 old_gear.py <dir>`."""
import os
import sys
from PIL import Image

from skins import TREES, _h


def grain(im, salt):
    out = im.copy()
    for x in range(im.width):
        for y in range(im.height):
            r, g, b, a = im.getpixel((x, y))
            if a == 0:
                continue
            t = (_h((x + y % 2) // 2, y // 2, salt) - 0.5) * 0.16 + (_h(x, y, salt + 1) - 0.5) * 0.06
            out.putpixel((x, y), tuple(max(0, min(255, int(c * (1 + t)))) for c in (r, g, b)) + (a,))
    return out


def save(im, name):
    for t in TREES:
        p = os.path.join(t, 'assets/naruto_shippuden/textures/entities', name)
        os.makedirs(os.path.dirname(p), exist_ok=True)
        im.save(p)


if __name__ == '__main__':
    src = sys.argv[1]
    hat = Image.open(os.path.join(src, 'hokage_hat.png')).convert('RGBA')
    save(grain(hat, 3), 'hokage_hat_old.png')
    jacket = Image.open(os.path.join(src, 'jonin_jacket.png')).convert('RGBA').resize((64, 64), Image.BOX)
    save(grain(jacket, 7), 'jonin_jacket_old.png')
    print('old gear textures written')
