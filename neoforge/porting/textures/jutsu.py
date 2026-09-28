"""Grayscale chakra textures for the jutsu models (the renderer tints them per element): soft noise and swirl streaks."""
import math
import os
import random
from png import Canvas

random.seed(7)
HERE = os.path.dirname(os.path.abspath(__file__))


def smooth_noise(size, cells):
    grid = [[random.random() for _ in range(cells + 1)] for _ in range(cells + 1)]

    def at(x, y):
        gx, gy = x / size * cells, y / size * cells
        x0, y0 = int(gx), int(gy)
        fx, fy = gx - x0, gy - y0
        fx, fy = fx * fx * (3 - 2 * fx), fy * fy * (3 - 2 * fy)
        top = grid[y0][x0] * (1 - fx) + grid[y0][(x0 + 1) % cells] * fx
        bottom = grid[(y0 + 1) % cells][x0] * (1 - fx) + grid[(y0 + 1) % cells][(x0 + 1) % cells] * fx
        return top * (1 - fy) + bottom * fy
    return at


def save(canvas, name):
    for root in ('res_override', '../src/main/resources'):
        out = os.path.join(HERE, '..', root, 'assets/naruto_shippuden/textures/entities/jutsu', name)
        os.makedirs(os.path.dirname(out), exist_ok=True)
        canvas.save(out)


# chakra: bright, softly mottled (pixel-art sized blotches)
c = Canvas(128, 128)
n1, n2 = smooth_noise(128, 8), smooth_noise(128, 32)
for y in range(128):
    for x in range(128):
        v = 0.65 * n1(x, y) + 0.35 * n2(x, y)
        g = int(170 + 85 * v)
        c.set(x, y, (g, g, g, 255))
save(c, 'chakra.png')

# swirl: diagonal streaks for the energy swirl layer (scrolls over time)
c = Canvas(64, 64)
n = smooth_noise(64, 8)
for y in range(64):
    for x in range(64):
        v = 0.5 + 0.5 * math.sin((x + y) * math.pi / 8 + n(x, y) * 4)
        g = int(255 * v ** 3)
        c.set(x, y, (g, g, g, 255))
save(c, 'swirl.png')
print('saved chakra.png, swirl.png')
