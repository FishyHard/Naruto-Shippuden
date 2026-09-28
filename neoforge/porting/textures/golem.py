"""Golem textures (128x128, one material everywhere so any cube looks right): cracked stone with moss for the Earth Golem, bark
with grain and leaves for the Wood Human. The eye strip at (112, 120) glows amber or green."""
import os
import random
from png import Canvas
from jutsu import smooth_noise

HERE = os.path.dirname(os.path.abspath(__file__))


def shade(c, f):
    return tuple(max(0, min(255, int(v * f))) for v in c)


def golem(name, base, dark, light, accent, eye, seed, wood):
    random.seed(seed)
    c = Canvas(128, 128)
    big, fine = smooth_noise(128, 6), smooth_noise(128, 24)
    for y in range(128):
        for x in range(128):
            if wood:
                v = 0.55 * big(x, y) + 0.45 * fine(x * 3 % 128, y)
                grain = 0.85 + 0.25 * ((x * 7 + int(8 * big(x, y) * 4)) % 5 == 0)
                col = shade(base, 0.75 + 0.45 * v) if grain < 1 else shade(light, 0.8 + 0.3 * v)
            else:
                v = 0.6 * big(x, y) + 0.4 * fine(x, y)
                col = shade(base, 0.7 + 0.55 * v)
                if fine(x, y) > 0.82:
                    col = shade(light, 0.95)
            c.set(x, y, col)
    # cracks (stone) or deep bark furrows (wood)
    for _ in range(26 if not wood else 40):
        x, y = random.randrange(128), random.randrange(128)
        for _ in range(random.randrange(6, 18)):
            c.set(x, y, dark)
            if wood:
                y = (y + 1) % 128
                x = (x + random.choice((0, 0, 0, 1, -1))) % 128
            else:
                x = (x + random.choice((-1, 0, 1))) % 128
                y = (y + random.choice((0, 1, 1))) % 128
    # moss / leaves in patches
    for _ in range(18):
        cx, cy, r = random.randrange(128), random.randrange(128), random.randrange(2, 5)
        for y in range(cy - r, cy + r + 1):
            for x in range(cx - r, cx + r + 1):
                if (x - cx) ** 2 + (y - cy) ** 2 <= r * r and random.random() < 0.7:
                    c.set(x % 128, y % 128, shade(accent, 0.8 + 0.4 * random.random()))
    c.rect(112, 120, 128, 128, eye)
    for root in ('res_override', '../src/main/resources'):
        out = os.path.join(HERE, '..', root, 'assets/naruto_shippuden/textures/entities/jutsu', name + '.png')
        os.makedirs(os.path.dirname(out), exist_ok=True)
        c.save(out)


golem('earth_golem', (112, 98, 86), (46, 38, 32), (150, 138, 124), (92, 122, 58), (255, 176, 60), 3, False)
golem('wood_golem', (110, 76, 44), (52, 34, 20), (150, 110, 70), (96, 150, 60), (190, 255, 120), 4, True)
print('saved earth_golem.png, wood_golem.png')
