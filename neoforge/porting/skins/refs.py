"""The story's skins taken from the hand-made reference skins in refs/ (picked by the user as the quality to aim for), with
what the story needs changed: no headband and no vest painted on anyone (the NPCs wear the real headband and jonin vest
items, story/chapter1.py), and Naruto's goggles at the Academy.
skins.py writes these with the rest; a 64x32 skin is brought to 64x64 first."""
import os

from PIL import Image

import heads
import skins
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
    # on the hat layer only the band's own pixels go (its cloth and knot, the plate's rim on the front), not the hair's
    for x in HAT_X:
        for y in range(8 if x >= 56 else y0 - 1, y1 + (5 if x >= 56 else 3)):   # the knot, over all the back's top
            c = im.getpixel((x, y))
            if c[3] and (bluish(c) or greyish(c) and x in range(40, 48)):
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
    """The headbands' navy cloth (and dark blue hair, which only stripping a band's rows ever looks at)."""
    return c[2] > c[0] + 15 and c[2] > c[1] + 10 and _lum(c) < 120


def greyish(c):
    return max(c[:3]) - min(c[:3]) < 18 and _lum(c) > 90


def hair_from(s, donor, is_hair, colour, skin, skin_lum, keep_front_rows=0, hat_rest=True):
    """`donor`'s hair (the pixels is_hair picks, on the head and its hat layer) put on `s`, each through colour(c): where
    the donor has hair this skin gets it; where the donor has skin, this skin keeps its own, or, where its own was hair,
    the donor's skin in this skin's tone (skin, shaded as the donor's is against skin_lum). The hat layer is the donor's.
    keep_front_rows: the face's rows from that one down are this skin's own, whatever the donor has there; hat_rest:
    whether what else the donor's hat layer has (a hair tie) comes too."""
    for part in ('head', 'hat'):
        for face, (x0, y0, w, h) in s.faces(part).items():
            for y in range(h):
                for x in range(w):
                    p = (x0 + x, y0 + y)
                    d, own = donor.im.getpixel(p), s.im.getpixel(p)
                    if part == 'head' and face == 'front' and keep_front_rows and y >= keep_front_rows:
                        continue
                    if d[3] and is_hair(d):
                        s.im.putpixel(p, colour(d))
                    elif part == 'hat':
                        s.im.putpixel(p, d if hat_rest and d[3] and not is_hair(d) else (0, 0, 0, 0))
                    elif d[3] and (own[0] < 150 or not own[3]):
                        s.im.putpixel(p, shade_as(d, skin, skin_lum))


def on_ramp(r, lo, hi, shift=0):
    """A colour mapped by its lightness, from lo to hi, onto the five shades of r."""
    return lambda c: r[max(0, min(4, round((_lum(c) - lo) / max(1, hi - lo) * 4) + shift))]


# ---------------------------------------------------------------- the characters

def naruto_genin():
    """The reference's hair, without the headband (it is the real item)."""
    s = load('naruto')
    strip_band(s, 2)
    return s


def naruto():
    """At the Academy, his goggles on his forehead where the headband was."""
    s = load('naruto')
    strip_band(s, 2)
    heads.naruto_goggles(s)
    return s


def sasuke():
    s = load('sasuke')
    strip_band(s, 2)
    for x in range(32, 64):          # the collar ring painted round the bottom of the head: his shirt has its own
        if bluish(s.im.getpixel((x, 15))):
            s.im.putpixel((x, 15), (0, 0, 0, 0))
    # his eyes black, not the Sharingan's red, drawn clean: the whites outside, the pupils in, a shade darker below
    heads.grid(s, 'head', 'front', [".", ".", ".", ".HHHHHH.", ".WPssPW.", ".wpsspw.", "s......s"],
               {'W': rgb('#F6F6F8'), 'w': rgb('#D8D8E2'), 'P': rgb('#101016'), 'p': rgb('#2C2C38'), 's': rgb('#FFCBB9'), 'H': rgb('#0C0C0E')})
    for x in (35, 36):               # the Uchiha fan on his back rounded at the top
        s.im.putpixel((x, 21), (0x6B, 0x22, 0x22, 255))
    return s


def sakura():
    s = load('sakura')
    heads.sakura(s)
    return s


def mizuki():
    """skins.py's Mizuki, his face drawn afresh under the hair of heads.py."""
    s = skins.mizuki()
    skins.head(s)
    skins.eyes(s, rgb('#3A3A48'), brows=tone(rgb('#B0C6D8'), -1.2))
    heads.mizuki(s, load('hinata'))
    return s


def kiba():
    s = load('kiba')
    strip_band(s, 2)
    return s


def shino():
    """Shino as at the Academy: his hood down, spiky dark brown hair (the Naruto reference's, in his colour), small round
    dark glasses, and his coat's high collar up over his mouth."""
    s = load('shino')
    strip_band(s, 1)
    for x in range(32, 64):          # the hood off
        for y in range(0, 16):
            s.im.putpixel((x, y), (0, 0, 0, 0))
    naruto = load('naruto')
    strip_band(naruto, 2)
    hair = heads.ramp('#1C1410', '#2C201A', '#3C2C24', '#503C30', '#664E3E')
    tan = rgb('#DBB79B')
    hair_from(s, naruto, lambda c: c[0] > 200 and c[1] > 140 and c[2] < 135, on_ramp(hair, 168, 214, 0), tan, 190, keep_front_rows=3, hat_rest=False)
    coat = rgb('#6D8066')            # his coat's green
    pal = {'h': hair[2], 'H': hair[1], 'k': tan, 'K': tone(tan, -0.6), 'G': rgb('#0E0E12'), 'g': rgb('#3C3C4C'),
           'c': tone(coat, 0.5), 'C': coat, 'D': tone(coat, -0.6)}
    pal.update({'W': rgb('#F0F0F0'), 'I': rgb('#3A2A22'), 'F': rgb('#0A0A0E'), 'L': rgb('#1C1C24'), 'l': rgb('#4A4A5C')})
    # his own eyes on the head, the round dark glasses over them standing out on the hat layer
    heads.grid(s, 'head', 'front', [".", ".", ".", "HKKKKKKH", "HWIkkIWH", "kkkKKkkk", "CCCCCCCC", "DDDDDDDD"], pal)
    heads.grid(s, 'hat', 'front', ["_", "_", "_", "FlLFFlLF", "_LL__LL_", "_"], pal)
    heads.grid(s, 'hat', 'right', [".", ".", ".", ".....FFF"], pal)
    heads.grid(s, 'hat', 'left', [".", ".", ".", "FFF....."], pal)
    # the collar, standing out round his jaw on the hat layer
    for face in ('front', 'right', 'left', 'back'):
        heads.grid(s, 'hat', face, [".", ".", ".", ".", ".", ".", "cccccccc", "CCCCCCCC"], pal)
    for face in ('right', 'left', 'back'):
        heads.grid(s, 'head', face, [".", ".", ".", ".", ".", ".", "CCCCCCCC", "DDDDDDDD"], pal)
    return s


def choji():
    """Without his headband bandana: the band and its plate painted out, and the cloth over his crown given back to his
    hair (each blue pixel takes the nearest hair beside it in its row)."""
    s = load('choji')
    strip_band(s, 2)
    im = s.im
    for y in range(0, 16):
        for x in range(0, 32):
            if im.getpixel((x, y))[3] and bluish(im.getpixel((x, y))):
                face = x // 8 * 8
                near = [im.getpixel((xx, y)) for xx in sorted(range(face, face + 8), key=lambda xx: abs(xx - x))
                        if im.getpixel((xx, y))[3] and not bluish(im.getpixel((xx, y)))]
                if not near and y + 1 < 16:
                    near = [im.getpixel((x, y + 1))]
                if near:
                    im.putpixel((x, y), near[0])
        for x in range(32, 64):
            if im.getpixel((x, y))[3] and bluish(im.getpixel((x, y))):
                im.putpixel((x, y), (0, 0, 0, 0))
    return s


def hinata():
    """Without the headband round her neck."""
    s = load('hinata')
    for x in range(16, 40):
        for y in (20, 21, 22):
            if bluish(s.im.getpixel((x, y))):
                s.im.putpixel((x, y), s.im.getpixel((x, 23)))
        for y in (36, 37, 38):
            if bluish(s.im.getpixel((x, y))):
                s.im.putpixel((x, y), (0, 0, 0, 0))
    return s


def shikamaru():
    """Without the headband on his arm."""
    s = load('shikamaru')
    for x in range(48, 64):          # the sleeve layer: the band's pixels go, the shirt under them shows
        for y in range(48, 64):
            if bluish(s.im.getpixel((x, y))):
                s.im.putpixel((x, y), (0, 0, 0, 0))
    for x in range(32, 48):          # the arm itself: the shirt carried over the band
        for y in range(52, 64):
            if bluish(s.im.getpixel((x, y))):
                up, down = s.im.getpixel((x, y - 1)), s.im.getpixel((x, min(63, y + 2)))
                s.im.putpixel((x, y), up if not bluish(up) else down)
    return s


def yui():
    """Our own squadmate, on Hinata's head (the reference's dark hair, cut to the jaw) with her own blue eyes; her body is
    skins.py's."""
    import skins
    s = skins.yui()
    h = load('hinata')
    for x in range(0, 64):
        for y in range(0, 16):
            s.im.putpixel((x, y), h.im.getpixel((x, y)))
    iris, white = rgb('#4A5AB0'), rgb('#F4F4F4')
    for x, y in ((9, 13), (14, 13), (9, 14), (14, 14)):
        s.im.putpixel((x, y), white)
    for x, y in ((10, 13), (13, 13)):
        s.im.putpixel((x, y), tone(iris, 0.4))
    for x, y in ((10, 14), (13, 14)):
        s.im.putpixel((x, y), tone(iris, -0.4))
    return s


def iruka():
    """In his navy shirt, for the real jonin vest and headband to go over (the vest and headband painted out), his hair
    tied up in its ponytail."""
    s = load('iruka')
    strip_band(s, 2)
    # his hair tied up as Shikamaru's is (the Shikamaru reference's hair, in his brown); the hat layer is Shikamaru's,
    # so the vest's collar that was on it, under his chin, goes too
    hair_from(s, load('shikamaru'), lambda c: _lum(c) < 60, on_ramp(heads.IRUKA_HAIR, 0, 48, 1), rgb('#F2B692'), 205)
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


REF_CHARACTERS = {'naruto': naruto, 'naruto_genin': naruto_genin, 'sasuke': sasuke, 'sakura': sakura,
                  'shikamaru_kid': shikamaru, 'ino': lambda: load('ino'), 'choji': choji, 'hinata': hinata, 'kiba': kiba,
                  'shino': shino, 'iruka': iruka, 'yui': yui, 'mizuki': mizuki}
