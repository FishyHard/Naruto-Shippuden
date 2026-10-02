"""The original mod's Hokage hat and jonin jacket (client/OldGearModels) with textures in the vanilla manner. Their own
textures are flat colour and most of their boxes share one spot of it, so no box can be shaded on its own: this gives
every box its own net on a new texture (one pixel a unit, as vanilla's armour), then paints each pixel from the colour the
old texture had there, on a ramp of that colour's shades (darker more saturated, lighter less, as vanilla's): lighter
up the item and on a face's top edge, darker down it and on the bottom edge, folds down the hat's cloth, and the clumped
grain vanilla's cloth has.

    python3 gear_repack.py [/path/to/1.16/workspace]

writes override/.../client/OldGearModels.java and textures/entities/hokage_hat_old.png, jonin_jacket_old.png."""
import math
import os
import sys
from PIL import Image

import models_import as mi

sys.path.insert(0, os.path.join(os.path.dirname(os.path.abspath(__file__)), 'skins'))
from skins import TREES, _h  # noqa: E402

HERE = os.path.dirname(os.path.abspath(__file__))
WORKSPACE = sys.argv[1] if len(sys.argv) > 1 else '/Volumes/KINGSTON/PC/WorkspaceBackup/narutoshippuden'
OUT = os.path.join(HERE, 'override/net/mcreator/narutoshippudenmod/client/OldGearModels.java')

# each colour of the old textures and its ramp, darkest first; `base` is the step a face takes before shading
RAMPS = {
    'red': dict(base=2, ramp=[(0x4A, 0x0C, 0x06), (0x7A, 0x18, 0x0A), (0xA6, 0x26, 0x12), (0xC4, 0x46, 0x2C), (0xD8, 0x76, 0x60)]),
    'white': dict(base=4, ramp=[(0x4C, 0x4A, 0x58), (0x9A, 0x9A, 0xA8), (0xBC, 0xBC, 0xC4), (0xD6, 0xD6, 0xD6), (0xEA, 0xEA, 0xE4), (0xFA, 0xFA, 0xF2)]),
    'green': dict(base=3, ramp=[(0x1E, 0x2C, 0x18), (0x40, 0x58, 0x32), (0x56, 0x70, 0x44), (0x6C, 0x88, 0x58), (0x80, 0x9A, 0x6C), (0x98, 0xB0, 0x86)]),
    'black': dict(base=1, ramp=[(0x10, 0x10, 0x14), (0x22, 0x20, 0x26), (0x34, 0x32, 0x38)]),
}
# the old textures' colours, and which ramp each belongs to
OLD = [((153, 64, 77), 'red'), ((238, 238, 238), 'white'), ((0x78, 0x90, 0x78), 'green'), ((0x9E, 0x3A, 0x44), 'red'),
       ((230, 230, 230), 'white'), ((20, 20, 20), 'black')]


def material(c):
    return min(OLD, key=lambda o: sum((a - b) ** 2 for a, b in zip(o[0], c[:3])))[1]


def rot(p, r):
    """PartPose's rotation (Z, Y, X: X is applied first)."""
    x, y, z = p
    a, b, c = r
    y, z = y * math.cos(a) - z * math.sin(a), y * math.sin(a) + z * math.cos(a)
    x, z = x * math.cos(b) + z * math.sin(b), -x * math.sin(b) + z * math.cos(b)
    x, y = x * math.cos(c) - y * math.sin(c), x * math.sin(c) + y * math.cos(c)
    return x, y, z


def to_model(parts, name, p):
    while name:
        part = parts[name]
        p = rot(p, part['rot'])
        p = tuple(a + b for a, b in zip(p, part['pivot']))
        name = part['parent']
    return p


def faces(w, h, d):
    """A box's six faces in its net: (name, u, v, width, height) and, for a pixel (i, j) of it, where on the box it is
    (fractions of the box's x, y, z)."""
    return [
        ('top', d, 0, w, d, lambda i, j: ((i + .5) / w, 0, (j + .5) / d)),
        ('bottom', d + w, 0, w, d, lambda i, j: ((i + .5) / w, 1, (j + .5) / d)),
        ('side', 0, d, d, h, lambda i, j: (0, (j + .5) / h, 1 - (i + .5) / d)),
        ('side', d, d, w, h, lambda i, j: ((i + .5) / w, (j + .5) / h, 0)),
        ('side', d + w, d, d, h, lambda i, j: (1, (j + .5) / h, (i + .5) / d)),
        ('side', 2 * d + w, d, w, h, lambda i, j: (1 - (i + .5) / w, (j + .5) / h, 1)),
    ]


def pack(sizes, width):
    """Shelf packing, tallest first: the spot of each net and the height used."""
    order = sorted(range(len(sizes)), key=lambda k: (-sizes[k][1], -sizes[k][0]))
    spots, x, y, shelf = {}, 0, 0, 0
    for k in order:
        w, h = sizes[k]
        if x + w > width:
            x, y, shelf = 0, y + shelf, 0
        spots[k] = (x, y)
        x += w
        shelf = max(shelf, h)
    return spots, y + shelf


def quads(parts, name, box):
    """A box's six faces in model space: (normal, plane offset, corners)."""
    _, _, (x, y, z, w, h, d), inflate, _ = box
    lo = (x - inflate, y - inflate, z - inflate)
    hi = (x + w + inflate, y + h + inflate, z + d + inflate)
    out = []
    for axis in range(3):
        for side in (lo, hi):
            corners = []
            for a in (lo, hi):
                for b in (lo, hi):
                    p = [0, 0, 0]
                    p[axis] = side[axis]
                    p[(axis + 1) % 3] = a[(axis + 1) % 3]
                    p[(axis + 2) % 3] = b[(axis + 2) % 3]
                    corners.append(to_model(parts, name, tuple(p)))
            o = to_model(parts, name, (0, 0, 0))
            e = [0, 0, 0]
            e[axis] = 1
            n = tuple(a - b for a, b in zip(to_model(parts, name, tuple(e)), o))
            out.append((n, sum(a * b for a, b in zip(n, corners[0])), corners))
    return out


def _overlap(qa, qb):
    """Whether two faces lie on one plane and cover some of the same area of it."""
    (na, ca, pa), (nb, cb, pb) = qa, qb
    dot = sum(a * b for a, b in zip(na, nb))
    if abs(dot) < 0.999 or abs(ca - cb * (1 if dot > 0 else -1)) > 0.02:
        return False
    # two axes in the plane
    t = (1, 0, 0) if abs(na[0]) < 0.9 else (0, 1, 0)
    u = (na[1] * t[2] - na[2] * t[1], na[2] * t[0] - na[0] * t[2], na[0] * t[1] - na[1] * t[0])
    v = (na[1] * u[2] - na[2] * u[1], na[2] * u[0] - na[0] * u[2], na[0] * u[1] - na[1] * u[0])
    for axis in (u, v):
        sa = [sum(a * b for a, b in zip(axis, p)) for p in pa]
        sb = [sum(a * b for a, b in zip(axis, p)) for p in pb]
        if min(max(sa), max(sb)) - max(min(sa), min(sb)) < 0.01:
            return False
    return True


def unfight(parts, boxes):
    """Boxes with faces on one plane flicker in turn as the camera moves (z-fighting): each box with a face on another's
    is grown a hair past it, the smaller box over the larger, as many hairs as boxes it sits on that way."""
    def volume(nk):
        _, _, (x, y, z, w, h, d), _, _ = parts[nk[0]]['boxes'][nk[1]]
        return (w + .01) * (h + .01) * (d + .01)
    faces_of = {nk: quads(parts, nk[0], parts[nk[0]]['boxes'][nk[1]]) for nk in boxes}
    level, fixed = {}, 0
    for nk in sorted(boxes, key=volume, reverse=True):
        under = [level[o] for o in level if any(_overlap(a, b) for a in faces_of[nk] for b in faces_of[o])]
        level[nk] = 1 + max(under) if under else 0
        if level[nk]:
            u, v, dims, inflate, mir = parts[nk[0]]['boxes'][nk[1]]
            parts[nk[0]]['boxes'][nk[1]] = (u, v, dims, inflate + 0.015 * level[nk], mir)
            fixed += 1
    return fixed


def repack(path, old_tex, width, salt, folds=None):
    """Re-UVs the model in `path` in place of its parsed parts and paints its texture; returns (parts, order, tw, th, image)."""
    tw, th, parts, order = mi.parse(path)
    print('%s: %d boxes lifted off faces they shared' % (os.path.basename(path),
          unfight(parts, [(name, k) for name in order for k in range(len(parts[name]['boxes']))])))
    old = Image.open(old_tex).convert('RGBA')
    scale = old.width / tw
    boxes = [(name, k) for name in order for k in range(len(parts[name]['boxes']))]
    sizes = []
    for name, k in boxes:
        _, _, (x, y, z, w, h, d), _, _ = parts[name]['boxes'][k]
        w, h, d = int(w), int(h), int(d)
        sizes.append((max(1, 2 * (w + d)), max(1, h + d)))
    spots, used = pack(sizes, width)
    height = 1 << max(5, (used - 1).bit_length())
    # where every pixel lands on the model, for the item's height range
    pixels = []
    for n, (name, k) in enumerate(boxes):
        u0, v0, (x, y, z, w, h, d), inflate, mir = parts[name]['boxes'][k]
        nu, nv = spots[n]
        for fname, fu, fv, fw, fh, at in faces(int(w), int(h), int(d)):
            for i in range(int(fw)):
                for j in range(int(fh)):
                    fx, fy, fz = at(i, j)
                    p = to_model(parts, name, (x - inflate + fx * (w + 2 * inflate), y - inflate + fy * (h + 2 * inflate), z - inflate + fz * (d + 2 * inflate)))
                    c = old.getpixel((min(old.width - 1, int((u0 + fu + i + .5) * scale)), min(old.height - 1, int((v0 + fv + j + .5) * scale))))
                    pixels.append((nu + fu + i, nv + fv + j, fname, j, int(fh), p, c))
        parts[name]['boxes'][k] = (nu, nv, [x, y, z, w, h, d], inflate, mir)
    ys = [p[5][1] for p in pixels if p[6][3]]
    top, bottom = min(ys), max(ys)
    im = Image.new('RGBA', (width, height), (0, 0, 0, 0))
    for (px, py, fname, row, rows, (x, y, z), c) in pixels:
        if c[3] == 0:
            continue
        m = RAMPS[material(c)]
        s = m['base'] + 0.0
        s += 0.9 - 1.8 * (y - top) / max(1e-6, bottom - top)          # lighter up the item
        if fname == 'top':
            s += 0.6
        elif fname == 'bottom':
            s -= 0.8
        elif rows >= 3:
            s += 0.7 if row == 0 else -0.8 if row == rows - 1 else 0  # a face's lit top edge and shaded bottom one
        if folds and material(c) == 'white' and fname == 'side' and y > folds[0]:
            s += 0.9 * math.sin(math.atan2(z, x) * folds[1])         # the cloth's folds, round the head
        g = (_h(int(px) // 2, int(py) // 2, salt) - 0.5) * 1.1 + (_h(int(px), int(py), salt + 1) - 0.5) * 0.6
        s = max(0, min(len(m['ramp']) - 1, round(s + g)))
        im.putpixel((int(px), int(py)), m['ramp'][s] + (255,))
    return parts, order, width, height, im


def emit(parts, order, tw, th, root, humanoid, method):
    """models_import's emitter, fed the re-UV'd parts."""
    real = mi.parse
    mi.parse = lambda _path: (tw, th, parts, order)
    try:
        return mi.emit(None, root, humanoid, method)
    finally:
        mi.parse = real


# the Uzumaki crest on the jacket's back, bolder than the old texture's (which comes out a blob at a pixel a unit): a red
# disc with a dark spiral, lit from the top left; 4 light, 3 red, 2 shade, 1 the spiral (RAMPS['red'] steps), '.' left as is
CREST = [
    ".4433.",
    "411113",
    "413213",
    "413113",
    "313222",
    ".2112.",
]


def crest(jacket):
    parts, im = jacket[0], jacket[4]
    u, v, (x, y, z, w, h, d), _, _ = parts['Body']['boxes'][0]  # the jacket's body
    bu, bv = u + 2 * int(d) + int(w), v + int(d)                 # its back face
    for j, row in enumerate(CREST):
        for i, ch in enumerate(row):
            if ch != '.':
                im.putpixel((int(bu) + 1 + i, int(bv) + 2 + j), RAMPS['red']['ramp'][int(ch)] + (255,))


def save(im, name):
    for t in TREES:
        p = os.path.join(t, 'assets/naruto_shippuden/textures/entities', name)
        os.makedirs(os.path.dirname(p), exist_ok=True)
        im.save(p)


if __name__ == '__main__':
    models = os.path.join(WORKSPACE, 'models')
    tex = os.path.join(WORKSPACE, 'src/main/resources/assets/naruto_shippuden/textures')
    # the cloth hangs below the brim (model y > -6.5: the head's top is -8, the roof above it), folds a quarter-turn apart
    hat = repack(os.path.join(models, 'ModelHokage_Hat.java'), os.path.join(tex, 'hokage_hat.png'), 128, 3, folds=(-6.5, 9))
    jacket = repack(os.path.join(models, 'ModelJonin_Jacket.java'), os.path.join(tex, 'jonin_jacket.png'), 64, 7)
    save(hat[4], 'hokage_hat_old.png')
    crest(jacket)
    save(jacket[4], 'jonin_jacket_old.png')
    src = open(OUT, encoding='utf-8').read()
    head = src[:src.index('\tpublic static LayerDefinition hokageHat()')]
    body = emit(*hat[:4], 'Hokage_Hat', 'head', 'hokageHat') + '\n' + emit(*jacket[:4], 'Body', 'body', 'joninJacket')
    open(OUT, 'w', encoding='utf-8').write(head + body + '\n}\n')
    print('hat %dx%d, jacket %dx%d' % (hat[2], hat[3], jacket[2], jacket[3]))
