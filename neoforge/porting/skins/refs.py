"""The story's skins taken from the hand-made reference skins in refs/ (picked by the user as the quality to aim for), with
what the story needs changed: no headband painted on the forehead before graduation (those graduates are given the real
headband item, story/chapter1.py; Shikamaru's on his arm and Hinata's round her neck stay painted), Naruto's goggles at the Academy, and no vest painted on Iruka, who wears the real jonin vest item.
skins.py writes these with the rest; a 64x32 skin is brought to 64x64 first."""
import os

from PIL import Image

from skins import Skin, rgb, tone

REFS = os.path.join(os.path.dirname(os.path.abspath(__file__)), 'refs')
# the head's four side faces as columns of the net (right, front, left, back), and the hat layer's
HEAD_X, HAT_X, FRONT = range(0, 32), range(32, 64), range(8, 16)


def legacy(im):
    """64x32 -> 64x64: the left arm and leg mirrored from the right, as the game does for old skins."""
    if im.height == 64:
        return im
    out = Image.new('RGBA', (64, 64), (0, 0, 0, 0))
    out.paste(im, (0, 0))

    def mirror(u, v, nu, nv):
        w, h, d = 4, 12, 4
        src = {'top': (u + d, v, w, d), 'bottom': (u + d + w, v, w, d), 'right': (u, v + d, d, h), 'front': (u + d, v + d, w, h),
               'left': (u + d + w, v + d, d, h), 'back': (u + 2 * d + w, v + d, w, h)}
        dst = {'top': (nu + d, nv), 'bottom': (nu + d + w, nv), 'left': (nu, nv + d), 'front': (nu + d, nv + d),
               'right': (nu + d + w, nv + d), 'back': (nu + 2 * d + w, nv + d)}
        for f, (x, y, fw, fh) in src.items():
            out.paste(im.crop((x, y, x + fw, y + fh)).transpose(Image.FLIP_LEFT_RIGHT), dst[f])
    mirror(0, 16, 16, 48)
    mirror(40, 16, 32, 48)
    return out


def load(name):
    im = legacy(Image.open(os.path.join(REFS, name + '.png')).convert('RGBA'))
    slim = all(im.getpixel((54, y))[3] == 0 and im.getpixel((55, y))[3] == 0 for y in range(20, 32))
    s = Skin(slim=slim)
    s.im = im
    return s


def _dist(a, b):
    return sum((x - y) ** 2 for x, y in zip(a[:3], b[:3])) ** 0.5


def _lum(c):
    return 0.3 * c[0] + 0.59 * c[1] + 0.11 * c[2]


def strip_band(s, top):
    """Takes off a headband painted round the head at rows top, top + 1 of the face: the hair above is carried down over
    it (on the front, the fringe under it if there is one, else the hair above in shadow), and the band's own pixels on
    the hat layer (its plate, the knot at the back) are cleared."""
    im = s.im
    y0, y1 = 8 + top, 9 + top
    band = {im.getpixel((x, y)) for x in HEAD_X for y in (y0, y1)}
    for x in HEAD_X:
        above, above2 = im.getpixel((x, y0 - 1)), im.getpixel((x, max(8, y0 - 2)))
        im.putpixel((x, y0), above)
        below = im.getpixel((x, y1 + 1))
        if x in FRONT:
            im.putpixel((x, y1), below if _dist(below, above) < 70 else tone(above, -0.6))
        else:
            im.putpixel((x, y1), above2)
        if x not in FRONT and bluish(im.getpixel((x, y1 + 1))):     # where the band sits a row lower round the back
            im.putpixel((x, y1 + 1), im.getpixel((x, y1)))
    for x in HAT_X:
        for y in range(8, 16):
            c = im.getpixel((x, y))
            if c in band or c[3] and bluish(c) and y0 - 1 <= y <= y1 + 1:
                im.putpixel((x, y), (0, 0, 0, 0))


def recolour(s, xs, ys, mapping):
    """Each pixel whose colour `mapping` takes (a function of the colour, None to leave it) gets the new colour."""
    for x in xs:
        for y in ys:
            c = s.im.getpixel((x, y))
            if c[3]:
                n = mapping(c)
                if n is not None:
                    s.im.putpixel((x, y), n)


def shade_as(c, base, ref_lum):
    """`base`, lighter or darker as `c` is against ref_lum."""
    return tone(base, (_lum(c) - ref_lum) / 28)


def bluish(c):
    return c[2] > c[0] + 25 and c[2] > c[1] and _lum(c) < 120


def greyish(c):
    return max(c[:3]) - min(c[:3]) < 18 and _lum(c) > 90


# ---------------------------------------------------------------- the characters

def naruto_genin():
    return load('naruto')


def naruto():
    """At the Academy: the headband's cloth is the goggles' green strap and its plate their lenses."""
    s = load('naruto')
    strap, lens, frame = rgb('#3E7A40'), rgb('#86CCEA'), rgb('#3A3E48')
    recolour(s, HEAD_X, (10, 11), lambda c: shade_as(c, strap, 50) if bluish(c) else None)
    for x in FRONT:
        for y in (10, 11):
            c = s.im.getpixel((x, y))
            if greyish(c) or _lum(c) > 90 and not bluish(c):
                s.im.putpixel((x, y), shade_as(c, lens, 180) if _lum(c) > 150 else frame)
    # the plate's rim and the knot at the back on the hat layer go
    recolour(s, HAT_X, range(8, 16), lambda c: (0, 0, 0, 0) if bluish(c) or greyish(c) else None)
    return s


def sasuke():
    s = load('sasuke')
    strip_band(s, 2)
    return s


def kiba():
    s = load('kiba')
    strip_band(s, 2)
    return s


def shino():
    s = load('shino')
    strip_band(s, 1)
    return s


def choji():
    """His bandana stays (it is his own), without the plate on it."""
    s = load('choji')
    cloth_c = s.im.getpixel((9, 10))
    recolour(s, FRONT, (10, 11), lambda c: shade_as(c, cloth_c, 170) if greyish(c) else None)
    return s


def iruka():
    """In his navy shirt, for the real jonin vest to go over: the vest's body and shoulder straps painted out."""
    s = load('iruka')
    navy = rgb('#30334B')
    from skins import torso, ring
    torso(s, navy, salt=47)
    ring(s, 'body', [0], navy, -0.5)
    for x in range(16, 40):          # the jacket layer: nothing of the vest
        for y in range(32, 48):
            s.im.putpixel((x, y), (0, 0, 0, 0))

    def greenish(c):
        return c[1] > c[2] + 6 and c[1] >= c[0] and _lum(c) < 150
    for xs, ys in ((range(40, 56), range(16, 32)), (range(32, 48), range(48, 64)), (range(40, 56), range(32, 48)), (range(48, 64), range(48, 64))):
        recolour(s, xs, ys, lambda c: shade_as(c, navy, 110) if greenish(c) else None)
    return s


REF_CHARACTERS = {'naruto': naruto, 'naruto_genin': naruto_genin, 'sasuke': sasuke, 'sakura': lambda: load('sakura'),
                  'shikamaru_kid': lambda: load('shikamaru'), 'ino': lambda: load('ino'), 'choji': choji, 'hinata': lambda: load('hinata'), 'kiba': kiba,
                  'shino': shino, 'iruka': iruka}
