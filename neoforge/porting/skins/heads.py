"""Hair and headgear drawn by hand over the reference skins (refs.py), where the reference's own wasn't what the story needs:
Naruto's spiky hair and his Academy goggles, Sasuke's bangs and spiky back, Iruka's ponytail, Sakura's long hair, Mizuki's.

Each hairstyle is on a ramp of five shades (darkest first, the darker the more saturated, as vanilla's), and drawn as the
reference skins draw hair: the base layer keeps the reference's shape of the hair, repainted in strands (columns a step
lighter or darker); the hat layer stands out from it in locks, each lock lit at its root and shaded at its tip, with gaps
of no colour between them."""
from skins import rgb

CLEAR = (0, 0, 0, 0)


def lum(c):
    return 0.3 * c[0] + 0.59 * c[1] + 0.11 * c[2]


def ramp(*hexes):
    return [rgb(h) for h in hexes]


def grid(s, part, face, rows, pal):
    """Paints a face from rows of characters: a colour from pal, '.' left as it is, '_' cleared."""
    for y, row in enumerate(rows):
        for x, ch in enumerate(row):
            if ch == '.':
                continue
            s.px(part, face, x, y, CLEAR if ch == '_' else pal[ch])


def clear(s, part):
    s.paint(part, lambda f, x, y, w, h: CLEAR)


STREAK = [0, 1, 0, -1, 1, 0, -1, 0]   # the strands: a column a step lighter or darker than its neighbours


def repaint(s, is_hair, r, salt=0):
    """The base layer's hair (the pixels is_hair picks) repainted on the ramp r: lit at the crown, a step darker each two
    rows down, in strands."""
    for face, (x0, y0, w, h) in s.faces('head').items():
        for x in range(w):
            for y in range(h):
                c = s.im.getpixel((x0 + x, y0 + y))
                if not c[3] or not is_hair(c):
                    continue
                if face == 'top':
                    k = 3 + (1 if (x + y + salt) % 5 == 0 else 0) - (1 if (x * 3 + y + salt) % 7 == 0 else 0)
                elif face == 'bottom':
                    k = 1
                else:
                    k = 3 - y // 3 + STREAK[(x + salt) % 8] * (1 if y > 0 else 0)
                s.im.putpixel((x0 + x, y0 + y), r[max(0, min(4, k))])


def locks(s, face, lengths, r, start=0, salt=0):
    """Locks of hair standing out on the hat layer, gaps between them where the hair under shows: lock x runs down from
    row `start` (or the start given with it, as (start, length)) for its length, lit at its root, shaded at its tip."""
    for x, n in enumerate(lengths):
        y0, n = (n if isinstance(n, tuple) else (start, n))
        for i in range(n):
            if i == 0:
                k = 3 + (1 if (x + salt) % 3 == 0 else 0)
            elif i == n - 1:
                k = 1 if n > 2 else 2
            else:
                k = 2 + (1 if (x + salt) % 4 == 1 else 0) - (1 if i >= 4 else 0)
            s.px('hat', face, x, y0 + i, r[max(0, min(4, k))])


def crown(s, r, salt=0, rows=range(8)):
    """The hat layer's top, filled: the crown's hair, lit, with strands running back (for smooth hair)."""
    for x in range(8):
        for y in rows:
            k = 3 + (1 if (x + salt) % 4 == 1 and y % 3 != 2 else 0) - (1 if (x + y + salt) % 6 == 0 else 0)
            s.px('hat', 'top', x, y, r[k])


def whorl(s, r, centre=(3.5, 3.0), strands=8, turn=0.2, width=0.5):
    """The hat layer's top for spiky hair: locks radiating from the crown with the hair under showing between them, so it
    reads as hair and not as a helmet; each lock lit at the crown, shaded toward its tip."""
    import math
    cx, cy = centre
    step = 2 * math.pi / strands
    for x in range(8):
        for y in range(8):
            dx, dy = x - cx, y - cy
            rad = math.hypot(dx, dy)
            a = math.atan2(dy, dx) - turn
            off = abs((a + step / 2) % step - step / 2) * rad   # how far off the nearest lock's line
            if rad < 1.1 or off < width + 0.12 * rad:
                k = 3 if rad < 2.4 else 2 if rad < 3.6 else 1
                s.px('hat', 'top', x, y, r[k])


# ---------------------------------------------------------------- Naruto

NARUTO_HAIR = ramp('#B4661A', '#DC8C1E', '#F2B630', '#FAD24A', '#FFEC8C')


def naruto_yellow(c):
    return c[0] > 200 and c[1] > 140 and c[2] < 135


def naruto(s, goggles):
    """Naruto's yellow hair in spikes every way, and at the Academy his goggles on his forehead: two round lenses in dark
    frames, the strap round his head over the hair."""
    r = NARUTO_HAIR
    # under the old headband: hair (it was the band's two rows)
    for face in ('right', 'left', 'back'):
        for x in range(8):
            for y in (2, 3):
                s.px('head', face, x, y, r[2])
    for x in range(8):
        for y in (2, 3):
            s.px('head', 'front', x, y, r[2])
    repaint(s, naruto_yellow, r, salt=3)
    clear(s, 'hat')
    whorl(s, r, centre=(3.5, 2.5), strands=9)
    locks(s, 'right', [5, 0, (1, 5), 3, 0, (1, 4), 0, 2], r)
    locks(s, 'left', [2, 0, (1, 4), 0, 3, (1, 5), 0, 5], r, salt=2)
    locks(s, 'back', [4, 0, (1, 5), 3, 0, (1, 6), 0, 4], r, salt=1)
    if goggles:
        locks(s, 'front', [2, 0, 0, 1, 0, 0, 0, 2], r, salt=1)
        pal = {'F': rgb('#2E3732'), 'f': rgb('#46524A'), 'L': rgb('#A6DCF2'), 'G': rgb('#F2FBFF'), 'M': rgb('#5FA8CE'),
               'T': rgb('#3E5E48'), 't': rgb('#56785E')}
        lenses = ["........", "........", "FGLffGLF", "FLMffLMF"]
        grid(s, 'head', 'front', lenses, pal)
        grid(s, 'hat', 'front', ["........", ".FF..FF.", "FGLffGLF", "FLMffLMF", ".FF..FF."], pal)
        for face in ('right', 'left', 'back'):
            grid(s, 'hat', face, ["........", "........", "tttttttt", "TTTTTTTT"], pal)
    else:
        locks(s, 'front', [3, 0, 2, 0, (0, 2), 0, 0, 3], r, salt=1)


# ---------------------------------------------------------------- Sasuke

SASUKE_HAIR = ramp('#0C0E16', '#171B29', '#222A40', '#33405F', '#4B5B85')


def sasuke_dark(c):
    return lum(c) < 75 and not c[0] > c[2] + 20


def sasuke(s):
    """Sasuke's blue-black hair: the long bangs either side of his face to his chin, a lock over his brow, his forehead
    clear (for the headband), the spiky back; no collar painted on the head."""
    r = SASUKE_HAIR
    k, K = rgb('#FFD3C0'), rgb('#E8B09C')
    pal = {'d': r[0], 's': r[1], 'b': r[2], 'l': r[3], 'h': r[4], 'k': k, 'K': K}
    grid(s, 'head', 'front', ["blhllhlb", "bsblbsbb", "bsKkksKb", "bsKkkKsb"], pal)
    repaint(s, sasuke_dark, r, salt=5)
    clear(s, 'hat')
    whorl(s, r, centre=(3.5, 2.0), strands=8, turn=0.5)
    grid(s, 'hat', 'front', ["l______l", "bs__s__b", "s___s__s", "s______s", "s______s", "s______s", "d______d", "________"], pal)
    locks(s, 'right', [6, 0, (1, 5), 0, 5, 0, (1, 5), 7], r, salt=1)
    locks(s, 'left', [7, (1, 5), 0, 5, 0, (1, 5), 0, 6], r, salt=3)
    locks(s, 'back', [6, 0, (1, 6), 0, 6, (1, 5), 0, 6], r, salt=2)


# ---------------------------------------------------------------- Iruka

IRUKA_HAIR = ramp('#24180F', '#3A281C', '#523A28', '#6C4E36', '#8A684A')


def brown(c):
    return lum(c) < 115 and c[0] > c[2] and not (c[0] > 200)


def iruka(s):
    """Iruka's dark brown hair pulled back and tied high in a short ponytail (the headband item over his brow)."""
    r = IRUKA_HAIR
    pal = {'d': r[0], 's': r[1], 'b': r[2], 'l': r[3], 'h': r[4]}
    repaint(s, brown, r, salt=7)
    clear(s, 'hat')
    # the ponytail, tied at the back of the crown: the tie, the tail standing up and fanning out behind
    grid(s, 'hat', 'top', ["_sbhbs__", "__llb___", "__dbd___", "___b____", "________", "________", "________", "________"], pal)
    grid(s, 'hat', 'back', ["_s_lb_s_", "__blhb__", "__dbbd__", "___ss___"], pal)
    # the hair smoothed back over the sides, a little proud of the head
    locks(s, 'right', [3, 3, 2, 2, 2, 1, 1, 0], r)
    locks(s, 'left', [0, 1, 1, 2, 2, 2, 3, 3], r)


# ---------------------------------------------------------------- Sakura

def sakura(s):
    """Her hair long, down her back to her shoulder blades (the reference's head kept), and no headband in it."""
    hair = [rgb('#C64C58'), rgb('#DD7A84'), rgb('#E89A9E'), rgb('#F2C3C3'), rgb('#F8DADA')]
    im = s.im

    def red(c):                      # the ribbon over her brow, not her hair
        return c[0] - c[1] > 90

    def band(c, face):               # its navy cloth; its metal plate (pale grey) only on top: her eyes' whites wrap round
        return c[3] and (c[2] > c[0] + 15 and lum(c) < 140 or face == 'top' and max(c[:3]) - min(c[:3]) < 30 and c[0] > 180)
    # the band's straps down the sides and its plate on top, on the base layer: the hair beside them carried over
    for face, (x0, y0, w, h) in s.faces('head').items():
        if face in ('front', 'bottom'):
            continue
        for y in range(h):
            for x in range(w):
                if band(im.getpixel((x0 + x, y0 + y)), face):
                    near = [im.getpixel((x0 + xx, y0 + y)) for xx in sorted(range(w), key=lambda xx: abs(xx - x))
                            if not band(im.getpixel((x0 + xx, y0 + y)), face) and not red(im.getpixel((x0 + xx, y0 + y)))]
                    im.putpixel((x0 + x, y0 + y), near[0] if near else hair[2])
    for face, (x0, y0, w, h) in s.faces('hat').items():
        for y in range(h):
            for x in range(w):
                if band(im.getpixel((x0 + x, y0 + y)), face):
                    im.putpixel((x0 + x, y0 + y), CLEAR)
    # the hat layer's back filled down to the neck, so the hair runs on down the back
    for y in range(3, 8):
        for x in range(8):
            if not s.get('hat', 'back', x, y)[3]:
                s.px('hat', 'back', x, y, hair[2 + STREAK[x] // 2 - (1 if y > 5 else 0)])
    # down the back, over the shirt, the ends uneven; a lock over each shoulder at the back
    ends = [6, 7, 5, 7, 6, 7, 5, 6]
    for x, n in enumerate(ends):
        for y in range(n):
            k = 3 - y // 3 + STREAK[x] * (1 if 0 < y < n - 1 else 0) - (1 if y == n - 1 else 0)
            s.px('jacket', 'back', x, y, hair[max(0, min(4, k))])
    for face, cols in (('right', (0, 1)), ('left', (3, 2))):
        for i, x in enumerate(cols):
            for y in range(4 - i * 2):
                s.px('jacket', face, x, y, hair[2 - (1 if y == 3 - i * 2 else 0)])


# ---------------------------------------------------------------- Mizuki

MIZUKI_HAIR = ramp('#5E7284', '#8296A8', '#A4B8C8', '#C4D4E0', '#E2ECF2')


def mizuki(s, hinata):
    """Mizuki's straight pale blue-grey hair to his jaw, with a long fringe: the hair of the Hinata reference (the same
    cut), on his own face."""
    def hair(c):
        return c[3] and (c[2] > c[0] + 8 and lum(c) < 130 or c[:3] == (0, 0, 0))
    for part in ('head', 'hat'):
        for face, (x0, y0, w, h) in s.faces(part).items():
            for y in range(h):
                for x in range(w):
                    c = hinata.im.getpixel((x0 + x, y0 + y))
                    if hair(c):
                        # the reference's shape, our own shades: its bright highlights would stand out as bars
                        k = 3 - (1 if lum(c) < 40 else 0) - (1 if y >= 5 and face in ('right', 'left', 'back') else 0) \
                            + (STREAK[x] if part == 'head' and face != 'front' and 0 < y < 5 else 0) * (x % 2)
                        s.im.putpixel((x0 + x, y0 + y), MIZUKI_HAIR[max(0, min(4, k))])
                    elif part == 'hat':
                        s.im.putpixel((x0 + x, y0 + y), CLEAR)
    crown(s, MIZUKI_HAIR, salt=4)
