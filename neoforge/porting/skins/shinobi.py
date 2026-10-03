"""The hidden villages' shinobi (core/jutsu/ShinobiAI): six looks for each village, drawn as code with the story skins' painter
(skins.py), so they sit beside the story characters. Variant n of a village fights in ShinobiAI.Style n:

    0 balanced (the village's old look, remade at 64x64), 1 taijutsu, 2 marksman, 3 ninjutsu, 4 kenjutsu, 5 medical ninja

and its look says so: wraps and bare arms for the brawlers, holsters and pouches for the marksmen, a sword on the back for
the swordsmen, a medic's colours for the medics. Nothing that is an item is painted on: the forehead protector (the genin
headband) and the Leaf's jonin vest are worn as real armour (ShinobiAI.dress). None should look like a canon character.

`python3 shinobi.py [sheet.png]` writes textures/entities/shinobi/<village>_<n>.png into both resource trees."""
import os
import sys

from PIL import Image

import skins
from skins import (Skin, rgb, tone, cloth, ring, hem, fold, bandage, sandals, torso, sleeves, trousers, holster, pouch, collar,
                   head, eyes, hair, LIGHT, SIDES, OUTER, CLEAR, WHITE, EYE_DARK, SKIN, outer_edge, _h)

TAN = rgb('#D9A47A')
DARK = rgb('#8C5A3A')
PALE = rgb('#F6D6BC')
METAL = rgb('#C2C8D0')
BAND = rgb('#24305A')          # the usual navy cloth
BLACK = rgb('#26262C')

def head_wrap(s, colour, face_cloth=False, row=2):
    """A cloth wrapped round the whole head (the desert's, a hood), over the hair on the hat layer."""
    def fn(f, x, y, w, h):
        if f == 'bottom':
            return None
        if f == 'front' and y >= row:
            return None
        if f in ('left', 'right') and y >= 6 and ((f == 'right' and x >= 5) or (f == 'left' and x <= 2)):
            return None
        t = LIGHT[f] * 0.8 + 0.1 - 0.05 * y
        if f in SIDES and (x + y + (2 if f == 'back' else 0)) % 5 == 0:
            t -= 0.4                                     # the folds of the wrap, running round
        return tone(colour, t)
    s.paint('hat', fn)
    s.paint('head', lambda f, x, y, w, h: tone(colour, LIGHT[f] - 0.3) if (f in ('left', 'right', 'back') and y < 7) or f == 'top' or (f == 'front' and y < row) else None)
    if face_cloth:
        mask(s, colour)


def mask(s, colour, rows=(5, 6, 7), part='hat'):
    """A cloth over the nose and mouth (and round the jaw), on the hat layer."""
    rows = list(rows)

    def fn(f, x, y, w, h):
        if y not in rows:
            return None
        if f == 'front':
            return tone(colour, (0.25 if y == rows[0] else -0.1 - 0.1 * (y - rows[0])) - (0.3 if x in (0, 7) else 0))
        if f == 'right' and x >= 4:
            return tone(colour, LIGHT[f] - 0.1 * (y - rows[0]))
        if f == 'left' and x <= 3:
            return tone(colour, LIGHT[f] - 0.1 * (y - rows[0]))
        return None
    s.paint(part, fn)
    s.px(part, 'front', 4, rows[0], tone(colour, 0.5))   # the nose under it


def hunter_mask(s, colour=rgb('#EFEDE6'), mark=rgb('#B8322E')):
    """A hunter-nin's mask over the whole face: eye slits, the village's red marks."""
    for x in range(8):
        for y in range(1, 8):
            t = 0.3 - 0.06 * y - (0.25 if x in (0, 7) else 0)
            s.px('hat', 'front', x, y, tone(colour, t))
    for x in (1, 2, 5, 6):
        s.px('hat', 'front', x, 4, tone(BLACK, -0.3))
    for (x, y) in ((3, 2), (4, 2), (2, 6), (5, 6), (3, 7), (4, 7)):
        s.px('hat', 'front', x, y, tone(mark, 0))


def vest(s, colour, straps='both', pockets=True, salt=0):
    """A flak vest on the jacket layer: both shoulders (Leaf, Mist, Stone) or one strap over a shoulder (Sand, Cloud: 'right'
    or 'left' = over that shoulder); a collar; scroll pockets in front."""
    cloth(s, 'jacket', colour, rows=(0, 11), salt=21 + salt, rough=0.4)
    s.paint('jacket', lambda f, x, y, w, h: CLEAR if f == 'bottom' or (f in SIDES and y == 11) else None)
    s.paint('jacket', lambda f, x, y, w, h: CLEAR if f in ('left', 'right') and 1 <= y <= 4 and x in (1, 2) else None)
    if straps in ('right', 'left'):
        # the vest covers the chest from the waist up to the far side's armpit, a strap over one shoulder
        on_right = straps == 'right'

        def cut(f, x, y, w, h):
            if f in ('front', 'back'):
                xx = x if (f == 'front') == on_right else w - 1 - x
                # the strap: two columns over the shoulder down to the vest's top edge, which runs diagonally
                if y < 4 and not (xx <= 1 + y // 2):
                    return CLEAR
            if f == 'top':
                xx = x if on_right else w - 1 - x
                if xx > 2:
                    return CLEAR
            if f == ('left' if on_right else 'right') and y < 4:
                return CLEAR
            return None
        s.paint('jacket', cut)
    else:
        collar(s, colour)
    if pockets:
        for (x0, y0) in ((0, 5), (5, 5)):
            for x in range(x0, x0 + 3):
                if s.get('jacket', 'front', x, y0) and s.get('jacket', 'front', x, y0)[3]:
                    s.px('jacket', 'front', x, y0, tone(colour, 0.6))
                    s.px('jacket', 'front', x, y0 + 1, tone(colour, -0.1))
                    s.px('jacket', 'front', x, y0 + 2, tone(colour, -0.9))
    ring(s, 'jacket', [9, 10], tone(colour, -0.4))
    if straps == 'both':
        for y in range(1, 10):
            s.px('jacket', 'front', 3, y, tone(colour, -1.0))
            s.px('jacket', 'front', 4, y, tone(colour, -0.2))


def sword_back(s, hilt=rgb('#3A3040'), guard=rgb('#C8A848'), blade=None):
    """A sword slung across the back: the hilt over the right shoulder, the sheath running down to the left hip."""
    pts = [(6, 0), (6, 1), (5, 2), (5, 3), (4, 4), (4, 5), (3, 6), (3, 7), (2, 8), (2, 9), (1, 10), (1, 11)]
    sheath = blade or rgb('#4A3A2E')
    for i, (x, y) in enumerate(pts):
        c = hilt if i < 2 else guard if i == 2 else sheath
        s.px('jacket', 'back', x, y, tone(c, 0.3 - i * 0.04))
        if i > 2:
            s.px('jacket', 'back', x + 1, y, tone(c, -0.5))
    s.px('jacket', 'top', 6, 3, tone(hilt, 0.6))
    s.px('jacket', 'top', 7, 3, tone(hilt, 0.2))
    for x in (0, 7):
        s.px('jacket', 'front', x, 3, tone(rgb('#5A4634'), -0.2))        # the strap over the chest
    for (x, y) in ((1, 4), (2, 5), (3, 6), (4, 7), (5, 8), (6, 9)):
        s.px('jacket', 'front', x, y, tone(rgb('#5A4634'), -0.1 - y * 0.03))


def big_sword_back(s, blade=rgb('#B8C0C8')):
    """One of the Mist's great swords on the back: the broad blade upright, the hilt over the shoulder."""
    for y in range(0, 12):
        for x in (2, 3, 4, 5):
            t = 0.4 - y * 0.06 - (0.4 if x in (2, 5) else 0)
            s.px('jacket', 'back', x, y, tone(blade, t))
    s.px('jacket', 'back', 4, 2, tone(blade, -1.4)); s.px('jacket', 'back', 4, 3, tone(blade, -1.2))   # the hole near its tip
    for x in (3, 4):
        s.px('jacket', 'top', x, 3, tone(rgb('#3A3040'), 0.4))


def scroll_back(s, colour=rgb('#E8DCC0'), band=rgb('#B8322E')):
    """A big scroll across the lower back."""
    for x in range(8):
        for y in (8, 9):
            s.px('jacket', 'back', x, y, tone(colour, 0.3 if y == 8 else -0.3) if x not in (3, 4) else tone(band, 0.2 if y == 8 else -0.2))


def quiver(s, colour=rgb('#6B4A30')):
    """A shuriken and kunai pouch on each hip and on the back."""
    pouch(s, colour)
    for l, side in (('rpants', 'right'), ('lpants', 'left')):
        for y in (0, 1, 2):
            for x in (1, 2):
                s.px(l, side, x, y, tone(colour, LIGHT[side] + (0.4 if y == 0 else -0.2)))


def wraps(s, part, rows, colour=rgb('#ECE8DE')):
    bandage(s, part, rows, base=colour)


def robe(s, colour, rows=(0, 12), open_front=False, salt=0):
    """A long coat or robe: the body's outer layer and the legs' outer layer to `rows[1]` rows down the legs."""
    cloth(s, 'jacket', colour, salt=33 + salt, rough=0.4)
    s.paint('jacket', lambda f, x, y, w, h: CLEAR if f in ('top', 'bottom') else None)
    if open_front:
        s.paint('jacket', lambda f, x, y, w, h: CLEAR if f == 'front' and x in (3, 4) else None)
    for leg, pants in (('rleg', 'rpants'), ('lleg', 'lpants')):
        cloth(s, pants, colour, rows=(0, rows[1]), only=SIDES, salt=35 + salt, rough=0.4)
        hem(s, pants, rows[1] - 1, colour)
        inner = 'left' if leg == 'rleg' else 'right'
        s.paint(pants, lambda f, x, y, w, h: CLEAR if f == inner else None)
        if open_front:
            s.paint(pants, lambda f, x, y, w, h: CLEAR if f == 'front' and ((leg == 'rleg' and x == 3) or (leg == 'lleg' and x == 0)) else None)


def sash(s, colour, rows=(8, 9)):
    ring(s, 'jacket', list(rows), colour)
    s.px('jacket', 'front', 5, rows[1] + 1, tone(colour, -0.2)); s.px('jacket', 'front', 6, rows[1] + 2, tone(colour, -0.4))


def cross_strap(s, colour, front=True):
    """A broad band from the right shoulder to the left hip."""
    for face in (('front', 'back') if front else ('back',)):
        for y in range(0, 11):
            x = y * 7 // 10 if face == 'front' else 7 - y * 7 // 10
            for dx in (0, 1):
                if 0 <= x + dx < 8:
                    s.px('jacket', face, x + dx, y, tone(colour, LIGHT[face] + (0.3 if dx == 0 else -0.2) - y * 0.03))


def gloves(s, colour, rows=(9, 12)):
    for a in ('rarm', 'larm'):
        cloth(s, a, colour, rows=rows, salt=41, rough=0.3)


def leg_warmers(s, colour, rows=(6, 10)):
    for l in ('rpants', 'lpants'):
        cloth(s, l, colour, rows=rows, only=SIDES, salt=43, rough=0.3)
        ring(s, l, [rows[0]], colour, 0.3)


def shirt(s, base, skin, sleeve_rows=12, salt=0):
    torso(s, base, salt=salt)
    sleeves(s, base, skin, rows=sleeve_rows)


def legs(s, base, skin, rows=12, sandal=BAND, wrap=True, holster_leg='rleg'):
    trousers(s, base, skin=skin, rows=rows)
    if holster_leg:
        holster(s, holster_leg)
    sandals(s, colour=sandal, skin=skin, wrap=wrap)


def face(s, skin_c, iris=EYE_DARK, hair_c=None, scar=False, stern=False):
    head(s, skin_c)
    eyes(s, iris, brows=tone(hair_c or BLACK, -0.5))
    if stern:
        s.px('head', 'front', 2, 3, tone(hair_c or BLACK, -0.8)); s.px('head', 'front', 5, 3, tone(hair_c or BLACK, -0.8))
    if scar:
        for y in (5, 6):
            s.px('head', 'front', 2, y, tone(skin_c, -0.7))


SPIKY = dict(front=[3, 2, 3, 2, 3, 2, 3, 3], side=[6, 6, 5, 5, 4, 4, 3, 3], back=[7, 6, 7, 6, 7, 6, 7, 6],
             hat_front=[2, 1, 2, 1, 2, 1, 2, 2], hat_side=[6, 5, 5, 4, 4, 3, 3, 3], hat_back=[7, 5, 7, 5, 7, 5, 7, 5], width=2)
SHORT = dict(front=[2, 1, 1, 1, 1, 1, 1, 2], side=[4, 4, 3, 3, 3, 2, 2, 2], back=[4, 4, 4, 4, 4, 4, 4, 4],
             hat_front=[1, 0, 0, 0, 0, 0, 0, 1], hat_side=[3, 3, 2, 2, 2, 1, 1, 1], hat_back=[4, 3, 4, 3, 4, 3, 4, 3], width=2)
LONG = dict(front=[8, 3, 2, 2, 2, 2, 3, 8], side=[8, 8, 8, 8, 8, 7, 7, 7], back=[8, 8, 8, 8, 8, 8, 8, 8],
            hat_front=[8, 2, 1, 1, 1, 1, 2, 8], hat_side=[8, 8, 7, 7, 7, 6, 6, 6], hat_back=[8, 8, 8, 8, 8, 8, 8, 8], style='smooth')
BOB = dict(front=[6, 3, 2, 2, 2, 2, 3, 6], side=[6, 6, 6, 6, 6, 6, 5, 5], back=[6, 6, 6, 6, 6, 6, 6, 6],
           hat_front=[6, 2, 1, 1, 1, 1, 2, 6], hat_side=[6, 6, 6, 5, 5, 5, 5, 5], hat_back=[6, 6, 6, 6, 6, 6, 6, 6], style='smooth')
TIED = dict(front=[3, 2, 1, 1, 1, 1, 2, 3], side=[5, 5, 4, 4, 3, 3, 3, 3], back=[5, 5, 5, 5, 5, 5, 5, 5],
            hat_front=[1, 0, 0, 0, 0, 0, 0, 1], hat_side=[4, 4, 3, 3, 2, 2, 2, 2], hat_back=[5, 5, 6, 7, 7, 6, 5, 5], style='smooth')
WILD = dict(front=[4, 3, 2, 4, 2, 3, 3, 4], side=[8, 8, 7, 7, 6, 6, 5, 6], back=[8, 8, 8, 8, 8, 8, 8, 8],
            hat_front=[4, 2, 1, 3, 1, 2, 2, 4], hat_side=[8, 7, 7, 6, 5, 4, 4, 5], hat_back=[8, 7, 8, 7, 8, 7, 8, 7])


def tail(s, colour, length=7):
    """A ponytail down the back (on the body's outer layer)."""
    for y in range(length):
        for x in (3, 4):
            s.px('jacket', 'back', x, y, tone(colour, 0.2 - y * 0.1 - (0.3 if x == 4 else 0)))


# ---------------------------------------------------------------- hair, drawn as the reference skins draw it
# Each hairstyle is drawn by hand, face by face, on five shades of the hair's colour: d(ark), s(hade), b(ase), l(ight),
# h(ighlight); '.' leaves what is there (the skin), '_' clears. The head layer is the hair itself, in strands, with a jagged
# hairline and darker tips. The hat layer has only locks and tufts standing out, with gaps where the hair under shows:
# never a full cap over the head (that reads as a helmet). Side faces run from the back of the head to the front (the right
# face; the left one is mirrored). The crown is painted for every style.

def hair_ramp(c):
    def f(k, add):
        return tuple(max(0, min(255, int(v * k + add))) for v in c[:3]) + (255,)
    if 0.3 * c[0] + 0.59 * c[1] + 0.11 * c[2] > 165:
        # light hair (white, blond): its colour is the highlight, the rest steps down from it, so nothing clips to white
        return {'d': f(0.55, 0), 's': f(0.7, 0), 'b': f(0.83, 0), 'l': f(0.93, 0), 'h': c}
    return {'d': f(0.58, 0), 's': f(0.8, 0), 'b': c, 'l': f(1.12, 14), 'h': f(1.25, 28)}


SPIKY_SIDE = ["bblbhblb", "sbsbbsbb", "bsbsbsbs", "sbsdsb.d", "dsd.....", "ds......", "d......."]
SPIKY_BACK = ["lbhblbhl", "bsbbsbbs", "sbsbsbsb", "bsbsbsbs", "sdsbsdsb", "dsdsdsds", "d.sd.ds."]
LONG_SIDE = ["lbhblbhb", "bsbbsbbs", "sbsbsbsb", "bsbsbsbs", "sbsbsbsb", "bsbsbsbs", "sdsbsdsb", "dsdsdsds"]
BOB_SIDE = ["lbhblbhb", "bsbbsbbs", "sbsbsbsb", "bsbsbsbs", "sbsbsbsb", "dsbsdsbs", "d.d.d.d."]
BOB_BACK = ["lbhblbhb", "bsbbsbbs", "sbsbsbsb", "bsbsbsbs", "sbsbsbsb", "bsbsbsbs", "dsdsdsds"]
WILD_SIDE = ["blhbblhb", "sbsblbsb", "bsbsbsbs", "sbsbsbs.", "bsbs....", "sbs.....", "dsd.....", "d.d....."]
WILD_BACK = ["lbhblbhl", "bsblbsbl", "sbsbsbsb", "bsbsbsbs", "sbsbsbsb", "bsbsbsbs", "dsbsdsbs", "d.ds.d.s"]
WILD_HAT = {'right': ["h.l.h.l.", ".s.b..b.", "", "b.......", "", "s.......", "", "d......."],
            'back': ["l.h.l.h.", ".b.s.b.s", "", "", "b..s..b.", "", "", "s.d..s.d"]}

HAIRSTYLES = {
    # short and spiky, points over the brow
    'spiky': dict(front=["lbhlblhb", "sbbsbbsb", "ds.bd.sd", "d......d"], side=SPIKY_SIDE, back=SPIKY_BACK,
                  hat=dict(front=["h..l..h.", ".b...s.."], right=["l.h..l.h", ".s..b...", "b.......", "s.......", "d......."],
                           back=["h.l..h.l", ".b.s..b.", "", "", ".s...s..", "", "s..d..s."]), spikes=0.35),
    # parted and swept to one side
    'parted': dict(front=["lhlbblbh", "bbhbsbbs", "sbsbd.sd", "dsd....d"], side=SPIKY_SIDE, back=SPIKY_BACK,
                   hat=dict(front=["lh.b....", ".lb.....", "..s....."], right=["l..h....", ".s......", "s......."],
                            back=["..l..h..", ".b....s.", "", "", "", "", "s....d.."]), spikes=0.15),
    # cropped short
    'short': dict(front=["sbsbbsbs", "d.s..s.d"], side=["bsbbsbbs", "sbsbsbs.", "dsds....", "ds......", "d......."],
                  back=["sbsbsbsb", "bsbsbsbs", "sdsbsdsb", "dsdsdsds", ".d.d.d.d"], hat=dict(), spikes=0.0),
    # combed back and tied at the nape
    'tied': dict(front=["lbhbblhb", "dsb..bsd", "d......d"], side=["blbhblbl", "sbsbsbsb", "bsbsbsb.", "sbsd....", "dsd.....", "ds......"],
                 back=["lbhbblhb", "bsblbsbl", "sbsbsbsb", "bsbddbsb", "sdsbbsds", "dsdssdsd", ".d....d."],
                 hat=dict(right=["...l....", "..s.l..."], back=["", "", "...ss...", "..sdds..", "...bb..."]), spikes=0.0),
    # straight to the shoulders, a fringe parted in the middle, framing the face
    'long': dict(front=["hlbbhlbl", "bsbbsbbs", "sbd..dbs", "b......b", "s......s", "b......b", "s......s", "d......d"],
                 side=LONG_SIDE, back=LONG_SIDE,
                 hat=dict(front=["l......l", "b......b", "s......s", "b......b", "s......s", "d......d"],
                          right=["l.h..l.h", "b.b..b.s", "s.s..s.b", "b.d..b.s", "s....s.d", "d....d.."],
                          back=["l.hl.h.l", "b.bs.b.s", "s.sb.s.b", "b.sd.b.s", "s.d..d.d", "d......."]), spikes=0.0),
    # a bob to the chin with a straight fringe
    'bob': dict(front=["hlbbhlbl", "bsbbsbbs", "sdsbsdsb", "b......b", "s......s", "d......d"], side=BOB_SIDE, back=BOB_BACK,
                hat=dict(front=["l......l", "b......b", "s......s", "d......d"], right=["l..h.l..", "b..b.s..", "s..s.b..", "d..b.s..", "...d.d.."],
                         back=["l.h..h.l", "b.b..b.s", "s.s..s.b", "b.d..d.s", "d......d"]), spikes=0.0),
    # long, messy and spiky to the nape
    'wild': dict(front=["hlblhblh", "bsblbsbs", "sd.bs.ds", "d.d...d."], side=WILD_SIDE, back=WILD_BACK,
                 hat=dict(front=["h.l.h..l", ".b..s.b."], **WILD_HAT), spikes=0.45),
    # a long fringe swept down over one eye
    'swept': dict(front=["hlbbhlbl", "bbsbbsbb", "lbbsb.ds", "bsbd...d", "sbd.....", "db......"], side=BOB_SIDE, back=BOB_BACK,
                  hat=dict(front=["", "lb......", "bs......", "sb......", "d......."], right=["l..h....", "b..s....", "s......."],
                           back=["l..h..l.", "b..s..b.", "", "s..d..s."]), spikes=0.1),
    # shaggy, uneven, over the brows
    'shaggy': dict(front=["lhblbhlb", "bsbbsbbs", "sbdsbsds", "d.d.s.d."], side=WILD_SIDE, back=WILD_BACK,
                   hat=dict(front=["l..h.l..", ".s..b..s"], **WILD_HAT), spikes=0.3),
}


def hairdo(s, style, colour, salt=0, cape=0):
    """Paints a hairstyle of HAIRSTYLES in this colour (salt: where the strands' shades are swapped, so two heads of one style
    differ)."""
    st, r = HAIRSTYLES[style], hair_ramp(colour)
    swap = {'b': 'l', 'l': 'b', 's': 'b'}

    shades = 'dsblh'
    streak = [1, 0, -1, 0, 1, -1, 0, 0]

    def put(part, face, rows, mirror=False):
        """The grid gives the shape; the shade runs in strands: each column a step lighter or darker than its neighbours
        all the way down, lit at the root, a step darker every two rows, darker at each tip."""
        for y, row in enumerate(rows):
            for x, ch in enumerate(row):
                if ch == '.':
                    continue
                xx = 7 - x if mirror else x
                if ch == '_':
                    s.px(part, face, xx, y, CLEAR)
                    continue
                above = y > 0 and x < len(rows[y - 1]) and rows[y - 1][x] not in '._'
                below = y + 1 < len(rows) and x < len(rows[y + 1]) and rows[y + 1][x] not in '._'
                if part == 'head':
                    k = 3 - y // 2 + streak[(x + salt) % 8]
                else:
                    # a lock: lit where it starts, its own shade along it
                    k = 3 + (1 if not above else 0) - (1 if y >= 3 else 0) + (streak[(x + salt) % 8] if above else 0)
                if not below:
                    k -= 1
                if ch == 'h':
                    k += 1
                elif ch == 'd':
                    k -= 1
                s.px(part, face, xx, y, r[shades[max(0, min(4, k))]])
    put('head', 'front', st['front'])
    put('head', 'right', st['side'])
    put('head', 'left', st['side'], mirror=True)
    put('head', 'back', st['back'])
    # the crown: lit, strands running back, a darker whorl
    for x in range(8):
        for y in range(8):
            k = 'l' if (x + salt) % 4 != 1 else 'h'
            if (x + y + salt) % 6 == 0:
                k = 'b'
            if (x, y) in ((4, 5), (3, 6)):
                k = 's'
            s.px('head', 'top', x, y, r[k])
    hat = st['hat']
    put('hat', 'front', hat.get('front', []))
    put('hat', 'right', hat.get('right', []))
    put('hat', 'left', hat.get('right', []), mirror=True)
    put('hat', 'back', hat.get('back', []))
    # tufts round the crown's edge (spiky styles): a ring of lit points, not a cap
    if st['spikes']:
        for x in range(8):
            for y in range(8):
                if (x in (0, 7) or y in (0, 7)) and _h(x, y, salt + 91) < st['spikes']:
                    s.px('hat', 'top', x, y, r['h' if _h(x, y, salt + 3) < 0.5 else 'l'])
    if cape:
        for x in range(8):
            for y in range(cape - (1 if x in (0, 7) else 0)):
                s.px('jacket', 'back', x, y, r['dsbsdsbs'[(x + y) % 8] if y == cape - 1 else 'bslbsbls'[(x + salt) % 8]])


# ================================================================ the Leaf (fire): navy and green

def leaf_0():
    """The old Leaf shinobi remade: all in black, black spiky hair, grey wraps on the forearms and shins."""
    s = Skin()
    hc = rgb('#1E1E26')
    face(s, SKIN, hair_c=hc)
    hairdo(s, 'spiky', hc, salt=101)
    shirt(s, rgb('#2A2A30'), SKIN, sleeve_rows=12)
    fold(s, 'body', 'front', [(2, 6), (5, 7)], rgb('#2A2A30'), 0.5)
    ring(s, 'body', [9], rgb('#4A4A52'))
    for a in ('rarm', 'larm'):
        wraps(s, a, range(6, 11), rgb('#B8B8B4'))
    legs(s, rgb('#24242A'), SKIN, sandal=BLACK)
    for l in ('rleg', 'lleg'):
        wraps(s, l, range(7, 10), rgb('#B8B8B4'))
    return s


def leaf_1():
    """A taijutsu fighter: a sand-coloured gi crossed at the chest and tied with a dark belt, navy trousers bound at the shins,
    black fingerless gloves, short brown hair with a little topknot."""
    s = Skin()
    hc, gi, belt = rgb('#5A3A24'), rgb('#CBB894'), rgb('#3A2A22')
    face(s, TAN, iris=rgb('#5A3A24'), hair_c=hc, stern=True)
    hairdo(s, 'short', hc, salt=103)
    for (x, y) in ((3, 3), (4, 3), (3, 4), (4, 4)):
        s.px('hat', 'top', x, y, tone(hc, 0.3 if (x + y) % 2 else -0.1))      # the topknot
    s.px('hat', 'back', 3, 0, tone(hc, 0.2)); s.px('hat', 'back', 4, 0, tone(hc, -0.1))
    torso(s, gi)
    for y in range(0, 7):                                # the gi's crossed front, the skin showing at the V
        for x in range(3 - y // 2, 5 + y // 2) if y < 3 else ():
            s.px('body', 'front', x, y, tone(TAN, -0.1 - y * 0.1))
        s.px('body', 'front', max(0, 2 - y // 3) + y // 2, y, tone(gi, -0.7))
    cloth(s, 'jacket', gi, rows=(7, 12), only=SIDES, salt=31)   # the gi's skirt over the trousers' tops
    ring(s, 'jacket', [6, 7], belt)
    s.px('jacket', 'front', 2, 8, tone(belt, -0.2)); s.px('jacket', 'front', 2, 9, tone(belt, -0.4))
    sleeves(s, gi, TAN, rows=5)
    gloves(s, BLACK, rows=(9, 12))
    for a in ('rarm', 'larm'):
        s.paint(a, lambda f, x, y, w, h: tone(TAN, LIGHT[f]) if f == 'front' and y == 11 and x in (1, 2) else None)   # the fingers
    trousers(s, rgb('#2E3650'), skin=TAN, rows=12)
    for l in ('rleg', 'lleg'):
        wraps(s, l, range(6, 10), rgb('#D8D0BE'))
    sandals(s, colour=BLACK, skin=TAN, wrap=False)
    return s


def leaf_2():
    """A marksman: the navy uniform, a pouch on each hip and one on the back, the protector on his arm, a brown ponytail."""
    s = Skin()
    hc, navy = rgb('#6A4428'), rgb('#26304E')
    face(s, SKIN, iris=rgb('#3A5A2A'), hair_c=hc)
    hairdo(s, 'tied', hc, salt=105)
    tail(s, hc, 5)
    shirt(s, navy, SKIN, sleeve_rows=12)
    skins.swirl_patch(s)
    for a in ('rarm', 'larm'):
        cloth(s, a, BLACK, rows=(10, 12), salt=7)
    quiver(s)
    legs(s, navy, SKIN, rows=12, holster_leg='lleg')
    holster(s, 'rleg', rows=(4, 6))
    return s


def leaf_3():
    """A ninjutsu specialist: the navy uniform with the red swirls on the arms (the Chunin and Jonin wear the real jonin vest
    over it), dark hair, a scroll on the back."""
    s = Skin()
    hc, navy = rgb('#3A2A22'), rgb('#26304E')
    face(s, SKIN, hair_c=hc)
    hairdo(s, 'parted', hc, salt=107)
    torso(s, navy)
    fold(s, 'body', 'front', [(2, 6), (5, 7)], navy, 0.5)
    ring(s, 'body', [9, 10], tone(navy, -0.4))
    scroll_back(s)
    sleeves(s, navy, SKIN, rows=12)
    skins.swirl_patch(s)
    for a in ('rarm', 'larm'):
        ring(s, a, [10], navy, -0.5)
    legs(s, navy, SKIN)
    return s


def leaf_4():
    """A swordsman: long black hair in a high tail, a dark blue coat with a pale lining over a light grey kimono, dark grey
    hakama, a sword across his back."""
    s = Skin()
    hc, coat, kimono, hakama, lining = rgb('#18161E'), rgb('#22304A'), rgb('#C8C8C4'), rgb('#3A3A42'), rgb('#D8D4C8')
    face(s, PALE, iris=rgb('#3A3A5A'), hair_c=hc, stern=True)
    hairdo(s, 'tied', hc, salt=109)
    tail(s, hc, 7)
    torso(s, kimono)
    for y in range(0, 6):                                # the kimono's crossed collar
        s.px('body', 'front', 3 + (y + 1) // 3, y, tone(kimono, -0.8))
    robe(s, coat, rows=(0, 9), open_front=True)
    for x in (2, 5):
        for y in range(12):
            s.px('jacket', 'front', x, y, tone(lining, 0.1 - y * 0.04))       # the coat's pale lining at its open edges
    sword_back(s, hilt=rgb('#E8E4DA'), guard=rgb('#2A2A30'), blade=rgb('#1A1A20'))
    sleeves(s, coat, PALE, rows=11)
    for a in ('rarm', 'larm'):
        ring(s, a, [10], lining, -0.1)
    trousers(s, hakama, skin=PALE, rows=11, knee=False)
    sandals(s, colour=BLACK, skin=PALE)
    return s


def leaf_5():
    """A medical ninja: a brown bob, a white medic's top with green trim over the navy uniform, a pouch of
    bandages."""
    s = Skin()
    hc, navy, white, green = rgb('#7A4A2A'), rgb('#26304E'), rgb('#EEF0EA'), rgb('#4A8A4A')
    face(s, SKIN, iris=rgb('#4A7A3A'), hair_c=hc)
    skins.blush(s)
    hairdo(s, 'bob', hc, salt=111)
    torso(s, white)
    s.paint('body', lambda f, x, y, w, h: tone(green, LIGHT[f] + 0.1) if f in ('front', 'back') and x in (0, w - 1) and y >= 1 else None)
    ring(s, 'body', [8, 9], green)
    fold(s, 'body', 'front', [(2, 5), (5, 6)], white, 0.5)
    sleeves(s, navy, SKIN, rows=12)
    for a in ('rarm', 'larm'):
        ring(s, a, [9, 10], white, -0.1)
    legs(s, navy, SKIN)
    pouch(s, rgb('#E8E4DA'))
    return s


# ================================================================ the Sand (wind): sand, grey and wraps

def sand_0():
    """The old Sand shinobi remade: the open grey jacket over a white shirt, black trousers, brown hair."""
    s = Skin()
    hc, grey = rgb('#5A3E2A'), rgb('#7A7A74')
    face(s, TAN, hair_c=hc)
    hairdo(s, 'parted', hc, salt=201)
    torso(s, rgb('#E6E4DE'))
    robe(s, grey, rows=(0, 4), open_front=True)
    for x in (2, 5):
        for y in range(12):
            s.px('jacket', 'front', x, y, tone(grey, 0.4 if x == 2 else -0.4))
    sleeves(s, grey, TAN, rows=11)
    legs(s, rgb('#26262C'), TAN, sandal=BLACK, wrap=False)
    return s


def sand_1():
    """A taijutsu fighter: a sleeveless sand-coloured top, wrapped forearms and shins, a dark buzz cut, a sash."""
    s = Skin()
    hc, top = rgb('#2A2420'), rgb('#C8AE7E')
    face(s, DARK, hair_c=hc, stern=True)
    hairdo(s, 'short', hc, salt=203)
    shirt(s, top, DARK, sleeve_rows=0)
    for a in ('rarm', 'larm'):
        wraps(s, a, range(5, 12), rgb('#E2D8C2'))
    sash(s, rgb('#8A3A2A'))
    legs(s, rgb('#6A5A44'), DARK, rows=12, sandal=rgb('#5A4634'), holster_leg=None)
    for l in ('rleg', 'lleg'):
        wraps(s, l, range(6, 10), rgb('#E2D8C2'))
    return s


def sand_2():
    """A marksman: the Sand's flak vest with its one strap over a grey shirt, a white desert wrap round the head and mouth."""
    s = Skin()
    shirt_c, vest_c = rgb('#5A5A60'), rgb('#B09A6A')
    face(s, TAN, iris=rgb('#3A6A7A'))
    head_wrap(s, rgb('#E8E2D2'), face_cloth=True)
    torso(s, shirt_c)
    vest(s, vest_c, straps='right', salt=7)
    sleeves(s, shirt_c, TAN, rows=12)
    gloves(s, rgb('#3A3A40'), rows=(10, 12))
    quiver(s)
    legs(s, shirt_c, TAN, holster_leg='lleg')
    holster(s, 'rleg', rows=(4, 6))
    return s


def sand_3():
    """A ninjutsu specialist: a long dark red robe with a broad sash, red hair, the protector round the neck, a scroll."""
    s = Skin()
    hc, robe_c = rgb('#B8442E'), rgb('#6A2A30')
    face(s, TAN, iris=rgb('#3A7A6A'), hair_c=hc)
    hairdo(s, 'wild', hc, salt=205)
    torso(s, rgb('#2A2A30'))
    robe(s, robe_c, rows=(0, 9))
    sash(s, rgb('#D8C8A0'))
    scroll_back(s)
    sleeves(s, robe_c, TAN, rows=11)
    legs(s, rgb('#2A2A30'), TAN, holster_leg=None)
    return s


def sand_4():
    """A swordsman: a hooded grey cloak, a red scarf, a curved sword on his back, the protector on the hood."""
    s = Skin()
    cloak, scarf = rgb('#6A6458'), rgb('#B8322E')
    face(s, TAN, iris=rgb('#7A5A2A'), stern=True)
    hairdo(s, 'short', rgb('#2A2420'), salt=207)
    head_wrap(s, cloak)
    torso(s, rgb('#3A3630'))
    robe(s, cloak, rows=(0, 6), open_front=True)
    collar(s, scarf, rows=(0, 1))
    for y in range(2, 6):
        s.px('jacket', 'front', 6, y, tone(scarf, 0.1 - y * 0.1))
    sword_back(s, hilt=rgb('#2A2A30'), guard=rgb('#C8A848'), blade=rgb('#3A2E26'))
    sleeves(s, cloak, TAN, rows=11)
    legs(s, rgb('#3A3630'), TAN, sandal=rgb('#5A4634'), holster_leg=None)
    return s


def sand_5():
    """A medical ninja: a pale robe with a brown sash and a white veil over the hair, the protector on the forehead."""
    s = Skin()
    robe_c, veil = rgb('#E2D6BC'), rgb('#F2EEE6')
    face(s, TAN, iris=rgb('#5A4A8A'), hair_c=rgb('#3A2A22'))
    skins.blush(s)
    head_wrap(s, veil, row=3)
    for x in (0, 7):                                     # the veil falling past the shoulders
        for y in range(0, 3):
            s.px('jacket', 'front', x, y, tone(veil, -0.2 - y * 0.1))
    torso(s, robe_c)
    robe(s, robe_c, rows=(0, 8))
    sash(s, rgb('#7A5232'))
    sleeves(s, robe_c, TAN, rows=10)
    legs(s, rgb('#8A7A60'), TAN, sandal=rgb('#5A4634'), holster_leg=None)
    return s


# ================================================================ the Mist (water): grey-blue, camouflage, masks

def mist_0():
    """The old Mist shinobi remade: brown and maroon, a quilted vest with the checked pattern, long dark blue hair."""
    s = Skin()
    hc, brown = rgb('#22263A'), rgb('#5E4440')
    face(s, PALE, hair_c=hc)
    hairdo(s, 'long', hc, salt=301)
    shirt(s, brown, PALE, sleeve_rows=11)
    for y in range(1, 9):                                # the checked panel down the front
        for x in (2, 3, 4, 5):
            s.px('body', 'front', x, y, tone(rgb('#A89A80'), 0.2 if (x + y) % 2 else -0.4))
    ring(s, 'body', [9], rgb('#7A5A30'))
    legs(s, brown, PALE, rows=12, sandal=BLACK)
    for l in ('rleg', 'lleg'):
        wraps(s, l, range(8, 10), rgb('#D8D2C8'))
    return s


def mist_1():
    """A taijutsu fighter: shaggy dark teal hair, a scar across the nose, a sleeveless grey-blue top with a high collar and a
    broad black belt, metal guards on the forearms, dark knee-length trousers and bound feet."""
    s = Skin()
    hc, top, guard = rgb('#1E4A4E'), rgb('#56687A'), rgb('#9EA8B2')
    face(s, PALE, iris=rgb('#2A6A6A'), hair_c=hc, stern=True)
    for x in (2, 3, 4, 5):
        s.px('head', 'front', x, 5, tone(PALE, -0.6 if x in (3, 4) else -0.4))   # the scar over the nose
    hairdo(s, 'shaggy', hc, salt=303)
    torso(s, top)
    collar(s, top, rows=(0, 1), faces=('left', 'right', 'back'))
    ring(s, 'body', [8, 9], BLACK)
    s.px('body', 'front', 3, 8, tone(guard, 0.4)); s.px('body', 'front', 4, 8, tone(guard, 0)); s.px('body', 'front', 3, 9, tone(guard, -0.3)); s.px('body', 'front', 4, 9, tone(guard, -0.5))
    sleeves(s, top, PALE, rows=0)
    for a in ('rarm', 'larm'):
        cloth(s, OUTER[a], guard, rows=(6, 10), only=SIDES, salt=17, rough=0.3)
        ring(s, OUTER[a], [6], guard, 0.4)
        ring(s, OUTER[a], [9], guard, -0.5)
    trousers(s, rgb('#2A2E3A'), skin=PALE, rows=8)
    for l in ('rleg', 'lleg'):
        wraps(s, l, range(9, 12), rgb('#D8D2C8'))
    sandals(s, colour=BLACK, skin=PALE, wrap=False)
    return s


def mist_2():
    """A marksman: the Mist's grey-green flak vest with its ribbing, a blue-grey shirt, light blue hair, senbon pouches."""
    s = Skin()
    hc, shirt_c, vest_c = rgb('#8ABCD0'), rgb('#4A5A72'), rgb('#6E7A68')
    face(s, PALE, iris=rgb('#3A6A9A'), hair_c=rgb('#4A7A8A'))
    hairdo(s, 'spiky', hc, salt=305)
    torso(s, shirt_c)
    vest(s, vest_c, straps='both', pockets=False, salt=9)
    for y in range(1, 9):                                # the vest's ribbing
        for x in (1, 6):
            s.px('jacket', 'front', x, y, tone(vest_c, -0.6))
    sleeves(s, shirt_c, PALE, rows=12)
    quiver(s, rgb('#3A3A44'))
    legs(s, shirt_c, PALE, sandal=BLACK, holster_leg='lleg')
    holster(s, 'rleg', rows=(4, 6))
    return s


def mist_3():
    """A ninjutsu specialist of the hunter-nin: the white mask with its red marks, a dark green robe, long black hair."""
    s = Skin()
    hc, robe_c = rgb('#16161C'), rgb('#2E4A44')
    face(s, PALE, hair_c=hc)
    hairdo(s, 'long', hc, salt=307)
    hunter_mask(s)
    torso(s, robe_c)
    robe(s, robe_c, rows=(0, 8))
    sash(s, rgb('#8A8A70'))
    sleeves(s, robe_c, PALE, rows=11)
    legs(s, robe_c, PALE, sandal=BLACK, holster_leg=None)
    return s


def mist_4():
    """A swordsman of the Mist's great blades: messy dark brown hair, a dark grey sleeveless top with a red sash, a great
    sword on his back, black arm warmers."""
    s = Skin()
    hc, top = rgb('#3A2A22'), rgb('#3E4248')
    face(s, PALE, iris=rgb('#6A4A2A'), hair_c=hc, stern=True)
    hairdo(s, 'wild', hc, salt=309)
    shirt(s, top, PALE, sleeve_rows=0)
    big_sword_back(s)
    sash(s, rgb('#A8302A'))
    for a in ('rarm', 'larm'):
        cloth(s, a, BLACK, rows=(6, 12), salt=19)
        ring(s, a, [6], BLACK, 0.3)
    trousers(s, rgb('#4A4E5A'), skin=PALE, rows=12)
    sandals(s, colour=BLACK, skin=PALE)
    return s


def mist_5():
    """A medical ninja: a blue kimono with a white sash, long dark hair, the protector round the neck."""
    s = Skin()
    hc, blue = rgb('#2A2232'), rgb('#3A5A8A')
    face(s, PALE, iris=rgb('#5A5AAA'), hair_c=hc)
    skins.blush(s)
    hairdo(s, 'long', hc, salt=311, cape=3)
    torso(s, blue)
    for y in range(0, 8):                                # the kimono's crossed front
        x = 2 + y // 3
        s.px('body', 'front', min(5, x), y, tone(WHITE, -0.2))
    robe(s, blue, rows=(0, 9))
    sash(s, WHITE)
    sleeves(s, blue, PALE, rows=11)
    legs(s, rgb('#2A3448'), PALE, sandal=BLACK, holster_leg=None)
    return s


# ================================================================ the Cloud (lightning): the one-strap vest, dark and gold

CLOUD_VEST = rgb('#E8E2D0')


def cloud_0():
    """The old Cloud shinobi remade: dark skin, white hair, the white vest across the chest, dark clothes."""
    s = Skin()
    hc = rgb('#E8E6E0')
    face(s, DARK, hair_c=rgb('#8A8A8A'))
    hairdo(s, 'spiky', hc, salt=401)
    shirt(s, rgb('#2A2632'), DARK, sleeve_rows=3)
    vest(s, CLOUD_VEST, straps='right', salt=11)
    for a in ('rarm', 'larm'):
        ring(s, a, [7, 8], rgb('#C8C4BC'))
    legs(s, rgb('#22202A'), DARK, sandal=rgb('#4A3A5A'))
    return s


def cloud_1():
    """A taijutsu fighter: blond, a sleeveless black top under the Cloud's vest, gold bracers and white wraps."""
    s = Skin()
    hc = rgb('#E8C450')
    face(s, DARK, hair_c=rgb('#8A6A20'), stern=True)
    hairdo(s, 'short', hc, salt=403)
    shirt(s, BLACK, DARK, sleeve_rows=0)
    vest(s, CLOUD_VEST, straps='left', pockets=False, salt=13)
    for a in ('rarm', 'larm'):
        ring(s, a, [7, 8], rgb('#D8A830'))
        wraps(s, a, range(9, 12))
    legs(s, rgb('#2A2632'), DARK, sandal=BLACK, holster_leg=None)
    for l in ('rleg', 'lleg'):
        wraps(s, l, range(8, 10))
    return s


def cloud_2():
    """A marksman: fair, blond hair tied back, the Cloud's vest over black, pouches on both hips and the back."""
    s = Skin()
    hc = rgb('#F0D46A')
    face(s, SKIN, iris=rgb('#3A6AB0'), hair_c=rgb('#A8862A'))
    hairdo(s, 'tied', hc, salt=405)
    tail(s, hc, 5)
    torso(s, BLACK)
    vest(s, CLOUD_VEST, straps='right', salt=15)
    sleeves(s, BLACK, SKIN, rows=12)
    gloves(s, rgb('#3A3A44'), rows=(10, 12))
    quiver(s, rgb('#4A3A2E'))
    legs(s, BLACK, SKIN, sandal=BLACK, holster_leg='lleg')
    holster(s, 'rleg', rows=(4, 6))
    return s


def cloud_3():
    """A ninjutsu specialist: dark skin, red hair, the Cloud's vest over a black shirt, a scroll at her back."""
    s = Skin()
    hc = rgb('#C83A2E')
    face(s, DARK, iris=rgb('#C8A030'), hair_c=rgb('#7A2018'))
    hairdo(s, 'bob', hc, salt=407)
    torso(s, BLACK)
    vest(s, CLOUD_VEST, straps='left', salt=17)
    scroll_back(s, band=rgb('#3A5AB0'))
    sleeves(s, BLACK, DARK, rows=6)
    for a in ('rarm', 'larm'):
        ring(s, a, [10], rgb('#D8A830'))
    legs(s, BLACK, DARK, sandal=BLACK)
    return s


def cloud_4():
    """A swordsman: dark skin, white hair over one eye, the black long-sleeved shirt and the vest, a sword on his back."""
    s = Skin()
    hc = rgb('#EEECE6')
    face(s, DARK, hair_c=rgb('#8A8A8A'))
    hairdo(s, 'swept', hc, salt=409)
    torso(s, BLACK)
    vest(s, CLOUD_VEST, straps='right', pockets=False, salt=19)
    sword_back(s, hilt=rgb('#3A3040'), guard=rgb('#D8A830'), blade=rgb('#2A2A30'))
    sleeves(s, BLACK, DARK, rows=12)
    legs(s, BLACK, DARK, sandal=BLACK, holster_leg=None)
    return s


def cloud_5():
    """A medical ninja: dark hair in a bob, a white coat with gold trim over black, the protector on her arm."""
    s = Skin()
    hc, coat = rgb('#2A2232'), rgb('#EEEAE0')
    face(s, SKIN, iris=rgb('#6A4A2A'), hair_c=hc)
    skins.blush(s)
    hairdo(s, 'bob', hc, salt=411)
    torso(s, BLACK)
    robe(s, coat, rows=(0, 6), open_front=True)
    for x in (2, 5):
        for y in range(12):
            s.px('jacket', 'front', x, y, tone(rgb('#D8A830'), 0.1 - y * 0.05))
    sleeves(s, coat, SKIN, rows=11)
    legs(s, BLACK, SKIN, sandal=BLACK, holster_leg=None)
    return s


# ================================================================ the Stone (earth): red, brown and one sleeve

STONE_RED, STONE_VEST = rgb('#8A2E2A'), rgb('#7A6248')


def one_sleeve(s, base, skin, bare='larm'):
    """The Stone's uniform: one long sleeve, the other arm bare under a mesh."""
    sleeves(s, base, skin, rows=12)
    skin_arm = bare
    skins.skin_fill(s, skin_arm, skin)
    skins.hand(s, skin_arm, skin)
    # the mesh: a fine dark grid over the skin, a shade, not a pattern
    s.paint(skin_arm, lambda f, x, y, w, h: tone(skin, LIGHT[f] - 0.55) if f in SIDES and y < 9 and (x + y) % 2 == 0 else None)
    ring(s, skin_arm, [9], rgb('#4A4440'), -0.2)


def stone_0():
    """The old Stone shinobi remade: a tan robe with a white collar and a brown belt, sandy hair."""
    s = Skin()
    hc, robe_c = rgb('#D8C090'), rgb('#B0905A')
    face(s, SKIN, hair_c=rgb('#8A7040'))
    hairdo(s, 'parted', hc, salt=501)
    torso(s, robe_c)
    for (x, y) in ((3, 0), (4, 0), (3, 1), (4, 2), (3, 3), (4, 4), (3, 5)):
        s.px('body', 'front', x, y, tone(WHITE, -0.1 - y * 0.05))   # the white collar, crossing down
    robe(s, robe_c, rows=(0, 6))
    sash(s, rgb('#6A3A22'))
    sleeves(s, robe_c, SKIN, rows=11)
    legs(s, BLACK, SKIN, sandal=BLACK, holster_leg=None)
    return s


def stone_1():
    """A taijutsu fighter: broad, bald, the red one-sleeved uniform and the brown vest, wrapped fists."""
    s = Skin()
    face(s, TAN, hair_c=rgb('#3A2A22'), stern=True)
    s.paint('head', lambda f, x, y, w, h: tone(TAN, LIGHT[f] + 0.3) if f == 'top' else None)
    torso(s, STONE_RED)
    vest(s, STONE_VEST, straps='both', pockets=False, salt=21)
    one_sleeve(s, STONE_RED, TAN)
    for a in ('rarm', 'larm'):
        wraps(s, a, range(9, 12))
    legs(s, rgb('#4A3A2E'), TAN, sandal=BLACK, holster_leg=None)
    return s


def stone_2():
    """A marksman: black hair under goggles, the red uniform, the Stone's vest with its pockets, a red scarf."""
    s = Skin()
    hc = rgb('#1E1A1A')
    face(s, SKIN, iris=rgb('#7A3A2A'), hair_c=hc)
    hairdo(s, 'spiky', hc, salt=503)
    skins.goggles(s, strap=rgb('#5A4634'), lens=rgb('#E8A040'), row=0)
    torso(s, STONE_RED)
    vest(s, STONE_VEST, straps='both', salt=23)
    collar(s, rgb('#B8322E'), rows=(0, 1))
    one_sleeve(s, STONE_RED, SKIN)
    quiver(s)
    legs(s, rgb('#4A3A2E'), SKIN, sandal=BLACK, holster_leg='lleg')
    holster(s, 'rleg', rows=(4, 6))
    return s


def stone_3():
    """A ninjutsu specialist: short black hair, the red uniform with the brown vest, a mesh on the bare arm, a skirt panel."""
    s = Skin()
    hc = rgb('#1A1620')
    face(s, SKIN, iris=rgb('#4A2A3A'), hair_c=hc)
    skins.blush(s)
    hairdo(s, 'bob', hc, salt=505)
    torso(s, STONE_RED)
    vest(s, STONE_VEST, straps='both', salt=25)
    one_sleeve(s, STONE_RED, SKIN, bare='rarm')
    legs(s, rgb('#2A2A30'), SKIN, sandal=BLACK)
    for l in ('rpants', 'lpants'):
        cloth(s, l, STONE_VEST, rows=(0, 4), only=SIDES, salt=27)
        hem(s, l, 3, STONE_VEST)
    return s


def stone_4():
    """A swordsman: long grey hair, a grey robe over the red uniform, a sword on his back."""
    s = Skin()
    hc = rgb('#8A8A90')
    face(s, TAN, hair_c=rgb('#5A5A60'), stern=True, scar=True)
    hairdo(s, 'long', hc, salt=507)
    torso(s, STONE_RED)
    robe(s, rgb('#5A5650'), rows=(0, 7), open_front=True)
    sword_back(s)
    sleeves(s, rgb('#5A5650'), TAN, rows=11)
    legs(s, rgb('#3A3630'), TAN, sandal=BLACK, holster_leg=None)
    return s


def stone_5():
    """A medical ninja: an earth-brown robe with a white apron, brown hair in a bun, the protector on the forehead."""
    s = Skin()
    hc, robe_c = rgb('#5A3A22'), rgb('#7A5A3A')
    face(s, SKIN, iris=rgb('#5A7A3A'), hair_c=hc)
    skins.blush(s)
    hairdo(s, 'tied', hc, salt=509)
    for (x, y) in ((3, 2), (4, 2), (3, 3), (4, 3)):
        s.px('hat', 'top', x, y, tone(hc, 0.4 if (x + y) % 2 else 0))          # the bun
    torso(s, robe_c)
    robe(s, robe_c, rows=(0, 8))
    for x in range(1, 7):                                # the apron
        for y in range(5, 12):
            s.px('jacket', 'front', x, y, tone(rgb('#EEEAE0'), 0.1 - y * 0.03 - (0.3 if x in (1, 6) else 0)))
    sleeves(s, robe_c, SKIN, rows=11)
    for a in ('rarm', 'larm'):
        ring(s, a, [9, 10], WHITE, -0.1)
    legs(s, rgb('#3A2E26'), SKIN, sandal=BLACK, holster_leg=None)
    return s


VILLAGES = ('leaf', 'sand', 'mist', 'cloud', 'stone')
ALL = {f'{v}_{i}': globals()[f'{v}_{i}'] for v in VILLAGES for i in range(6)}


def save(s, name):
    for t in skins.TREES:
        d = os.path.join(t, 'assets/naruto_shippuden/textures/entities/shinobi')
        os.makedirs(d, exist_ok=True)
        s.im.save(os.path.join(d, name + '.png'))


if __name__ == '__main__':
    out = sys.argv[1] if len(sys.argv) > 1 else None
    sheet = Image.new('RGBA', (6 * 176, 5 * 176), (190, 190, 190, 255))
    for name, make in ALL.items():
        s = make()
        save(s, name)
        v, i = name.split('_')
        r, c = VILLAGES.index(v), int(i)
        sheet.alpha_composite(skins.view(s).resize((80, 160), Image.NEAREST), (c * 176 + 4, r * 176 + 8))
        sheet.alpha_composite(skins.view(s, True).resize((80, 160), Image.NEAREST), (c * 176 + 90, r * 176 + 8))
    if out:
        sheet.save(out)
    print(len(ALL), 'skins')
