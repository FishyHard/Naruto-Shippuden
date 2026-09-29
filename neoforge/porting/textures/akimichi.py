"""Akimichi Human Bullet Tank texture (128x128, one material per band so any cube looks right): Choji's red armour cloth with
plate seams (top half), gold trim (y 64-95) and dark spiked hair (y 96-127)."""
import os
from png import Canvas
from jutsu import smooth_noise

HERE = os.path.dirname(os.path.abspath(__file__))
OUT = os.path.join(HERE, '..', '..', 'src', 'main', 'resources', 'assets', 'naruto_shippuden', 'textures', 'entities', 'jutsu')
OVERRIDE = os.path.join(HERE, '..', 'res_override', 'assets', 'naruto_shippuden', 'textures', 'entities', 'jutsu')


def shade(c, f):
    return tuple(max(0, min(255, int(v * f))) for v in c)


def tank():
    c = Canvas(128, 128)
    big, fine = smooth_noise(128, 6), smooth_noise(128, 24)
    red, seam, gold, gold_dark, hair = (178, 42, 38), (96, 20, 20), (224, 178, 72), (150, 108, 36), (58, 40, 30)
    for y in range(128):
        for x in range(128):
            v = 0.55 * big(x, y) + 0.45 * fine(x, y)
            if y < 64:
                # armour plates: a darker seam every 8 pixels, lighter plate edges
                col = shade(red, 0.78 + 0.35 * v)
                if y % 8 == 0 or x % 16 == 0:
                    col = shade(seam, 0.9 + 0.2 * v)
                elif y % 8 == 1:
                    col = shade(red, 1.12)
            elif y < 96:
                col = shade(gold, 0.8 + 0.3 * v) if (y // 3) % 3 else shade(gold_dark, 0.95)
            else:
                col = shade(hair, 0.7 + 0.6 * v)
            c.set(x, y, col)
    return c


def steel():
    """A light, fully opaque brushed-metal texture (tinted per weapon: steel, dark iron, a purple poisoned blade, paper)."""
    c = Canvas(128, 128)
    big, fine = smooth_noise(128, 6), smooth_noise(128, 32)
    for y in range(128):
        for x in range(128):
            v = 0.5 * big(x, y) + 0.5 * fine(x, y * 4 % 128)
            c.set(x, y, shade((235, 235, 240), 0.82 + 0.2 * v))
    return c


if __name__ == '__main__':
    for folder in (OUT, OVERRIDE):
        os.makedirs(folder, exist_ok=True)
        tank().save(os.path.join(folder, 'akimichi_tank.png'))
        steel().save(os.path.join(folder, 'steel.png'))
    print('akimichi_tank.png')
