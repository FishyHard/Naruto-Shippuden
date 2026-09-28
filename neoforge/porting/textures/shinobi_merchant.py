"""Shinobi Merchant skin, 64x32 (1.16 humanoid layout): straw hat, brown travel cloak over a beige kimono, red obi, wrapped limbs."""
import os
from png import Canvas

SKIN, SKIN_D = (219, 170, 130), (190, 140, 104)
HAIR = (58, 40, 30)
STRAW, STRAW_D = (214, 186, 110), (170, 140, 72)
CLOAK, CLOAK_D = (107, 74, 43), (84, 57, 33)
KIMONO = (200, 180, 138)
OBI = (122, 32, 32)
WRAP = (217, 210, 192)
PANTS = (46, 52, 64)
SANDAL = (90, 58, 34)

c = Canvas(64, 32)


def box(u, v, w, h, d, fill):
    """Fill every face of a box whose texture starts at (u, v) with fill(face, x0, y0, width, height)."""
    faces = {'top': (u + d, v, w, d), 'bottom': (u + d + w, v, w, d), 'right': (u, v + d, d, h), 'front': (u + d, v + d, w, h),
             'left': (u + d + w, v + d, d, h), 'back': (u + 2 * d + w, v + d, w, h)}
    for face, (x, y, fw, fh) in faces.items():
        fill(face, x, y, fw, fh)


def head(face, x, y, w, h):
    c.rect(x, y, x + w, y + h, SKIN, 6)
    if face in ('top', 'back'):
        c.rect(x, y, x + w, y + h, HAIR, 5)
    elif face in ('left', 'right'):
        c.rect(x, y, x + w, y + 4, HAIR, 5)
        c.rect(x + (w - 2 if face == 'right' else 0), y + 4, x + (w if face == 'right' else 2), y + 6, HAIR, 5)
    elif face == 'front':
        c.rect(x, y + 3, x + w, y + 4, HAIR, 5)
        for ex in (1, 5):
            c.set(x + ex, y + 4, (255, 255, 255))
            c.set(x + ex + 1, y + 4, (40, 30, 30))
        c.rect(x + 3, y + 5, x + 5, y + 6, SKIN_D)
        c.rect(x + 3, y + 6, x + 5, y + 7, (150, 90, 80))


def hat(face, x, y, w, h):
    if face == 'top':
        c.rect(x, y, x + w, y + h, STRAW, 10)
        for i in range(0, w, 3):
            c.rect(x + i, y, x + i + 1, y + h, STRAW_D)
    elif face in ('front', 'back', 'left', 'right'):
        c.rect(x, y, x + w, y + 3, STRAW, 10)
        c.rect(x, y + 2, x + w, y + 3, STRAW_D)


def body(face, x, y, w, h):
    c.rect(x, y, x + w, y + h, CLOAK, 6)
    if face == 'front':
        # kimono showing in a V under the open cloak
        for row in range(0, 7):
            half = max(0, 3 - row // 2)
            c.rect(x + 4 - half - 1, y + row, x + 4 + half + 1, y + row + 1, KIMONO, 5)
        c.rect(x, y + 7, x + w, y + 9, OBI, 4)
        c.rect(x + 3, y + 9, x + 5, y + h, CLOAK_D, 4)
    elif face in ('left', 'right', 'back'):
        c.rect(x, y + 7, x + w, y + 9, OBI, 4)
        if face == 'back':
            c.rect(x + 1, y + 1, x + w - 1, y + 6, CLOAK_D, 4)


def arm(face, x, y, w, h):
    c.rect(x, y, x + w, y + h, CLOAK, 6)
    if face not in ('top', 'bottom'):
        c.rect(x, y + 7, x + w, y + 10, WRAP, 6)
        c.rect(x, y + 10, x + w, y + h, SKIN, 6)
    elif face == 'bottom':
        c.rect(x, y, x + w, y + h, SKIN, 6)


def leg(face, x, y, w, h):
    c.rect(x, y, x + w, y + h, PANTS, 5)
    if face not in ('top', 'bottom'):
        c.rect(x, y + 6, x + w, y + 10, WRAP, 6)
        c.rect(x, y + 10, x + w, y + h, SANDAL, 5)
        if face == 'front':
            c.rect(x + 1, y + 10, x + w - 1, y + 11, SKIN, 4)
    elif face == 'bottom':
        c.rect(x, y, x + w, y + h, SANDAL, 5)


box(0, 0, 8, 8, 8, head)
box(32, 0, 8, 8, 8, hat)
box(16, 16, 8, 12, 4, body)
box(40, 16, 4, 12, 4, arm)
box(0, 16, 4, 12, 4, leg)

HERE = os.path.dirname(os.path.abspath(__file__))
for root in ('res_override', '../src/main/resources'):
    out = os.path.join(HERE, '..', root, 'assets/naruto_shippuden/textures/entities/shinobi_merchant.png')
    os.makedirs(os.path.dirname(out), exist_ok=True)
    c.save(out)
print('saved shinobi_merchant.png')
