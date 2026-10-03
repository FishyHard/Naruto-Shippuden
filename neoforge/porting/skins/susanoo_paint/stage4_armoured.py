"""How Sasuke's Armoured (stage 4) is painted: its own copy of the painting rules, so changing this stage's look
never changes another's (each stage's texture file has its own approach). susanoo_convert.py calls texel() for every pixel,
hidden() to ask whether a pixel covered by another block of the same part is left out, and joins() whether a box's edges may
run on into a level neighbour without a rim."""
import math
import os

from susanoo_convert import BASE, EYES, _h, _noise, _noise3

STAGE = '4'


def hidden(mat, bone):
    return False


def joins(e):
    return bool(e.get('susanoo_ring') or e.get('susanoo_column'))


def texel(mat, r, x, y, fw, fh, t, cap, seed, face, h01, wp=None, up=0.0, disc=None, long_axis=None, edges=None, plates2d=None, column=False, bone=None, ring=False, hair=False):
    """One pixel of a face, shaded the way Java Edition's mobs are: big soft areas of a base tone, darker low on the body and
    lighter high on it, each face a little lighter along its top and darker along its bottom (no outlines), blots of a
    lighter tone for the chakra's pattern, quiet noise. x, y on the face (fw x fh); h01: how high up the whole model this row
    is (0 the bottom, 1 the top); t how far along toward the tip (flame, feathers); cap: the face is the tip's end (1) or
    the root's (0)."""
    if wp is not None:
        blot = _noise3(wp, 2.6, 7)
        pattern = _noise3(wp, 6.0, 13)
    else:
        blot = _noise(x, y, 3, seed)
        pattern = _noise(x, y, 5.5, seed + 13)
    if mat == 'eye':
        if face not in ('front', 'back'):
            return EYES[1], 255
        if fw <= 2 or fh <= 1:
            return EYES[3], 255
        if y == fh - 1 or x in (0, fw - 1):
            return EYES[2], 255                               # the eye's lower rim and corners: deeper
        if (x, y) == (1, 0):
            return EYES[4], 255                               # a glint
        return EYES[3], 255
    if mat == 'black':
        # Amaterasu, drawn the way vanilla draws fire (its fire texture's shapes, in black): jagged tongues two pixels wide rising
        # from the bottom of each face to uneven heights, each with a black outline, deep purple inside and a brighter purple
        # core low down; the smoke-black between and above them
        smoke, outline, inner, core = (6, 3, 10), (18, 6, 28), r[1], r[2]
        if face == 'bottom':
            return smoke, 252
        if face == 'top':
            return (inner if _h(x, y, seed + 3) < 0.25 else outline), 252
        v = (fh - 1 - y) / max(1, fh - 1)                     # 0 at the bottom row, 1 at the top
        col = x // 2
        top = 0.35 + 0.5 * _h(col, 0, seed + 11)               # this tongue's height
        left = 0.35 + 0.5 * _h(col - 1, 0, seed + 11)
        right = 0.35 + 0.5 * _h(col + 1, 0, seed + 11)
        if v > top:
            return smoke, 252
        # the tongue's outline: its tip, and its sides where it stands above its neighbours
        side = (x % 2 == 0 and v > left) or (x % 2 == 1 and v > right)
        if v > top - 1.0 / fh or side:
            return outline, 252
        if v < top * 0.45 and _h(x, y, seed + 5) > 0.15:
            return core, 252                                   # the bright heart low in the fire
        return inner, 252
    if mat == 'bright':
        mid = 0 < x < fw - 1 and 0 < y < fh - 1
        return (r[5] if mid else r[4]), 235
    side = face in ('front', 'back', 'left', 'right')
    if mat == 'flame' and os.environ.get('SUSANOO_STYLE', 'D') == 'D':
        mat = 'armor'                                         # the hair: the same glow as every other part (no tip dots)
    if mat == 'flame':
        # a lock of flame hair: deep at the root, white at the tip, a lighter middle
        k = 1.0 if t is None else (cap if cap is not None else t)
        if cap is not None:
            k = cap
        tone = 2 + int(k * 3.4)                               # up to the second-lightest tone, only at the very tip
        if t is not None and cap is None:
            across = (y, fh) if fw >= fh else (x, fw)
            if across[1] >= 3 and across[0] in (0, across[1] - 1):
                tone -= 1
        return r[max(1, min(5, tone))], 205 + int(k * 35)
    base, alpha = BASE.get(mat, BASE[None])
    tone = base
    # the model's own pixel grid (whole Blockbench units), so neighbouring boxes share every pixel's pattern
    q = (int(math.floor(wp[0] + 1e-3)), int(math.floor(wp[1] + 1e-3)), int(math.floor(wp[2] + 1e-3))) if wp is not None else (x, y, seed)

    def ph(a, b, c, salt):
        v = (a * 73856093) ^ (b * 19349663) ^ (c * 83492791) ^ (salt * 2654435761)
        v = (v ^ (v >> 13)) * 1274126177
        return ((v ^ (v >> 16)) & 0xffffffff) / 0xffffffff
    # almost flat: only the odd pixel half a step off, so big faces don't look printed
    d = ph(*q, 3)
    dither = -0.5 if d < 0.03 else 0.5 if d > 0.97 else 0
    if mat == 'bone':
        tone = 4
    if mat == 'feather':
        k = 0.5 if t is None else (cap if cap is not None else t)
        tone += (1 if k > 0.7 else 0) - (1 if k < 0.2 else 0)
        along_u = fw >= fh
        if cap is None and ((y == fh // 2) if along_u else (x == fw // 2)) and min(fw, fh) >= 3:
            tone += 1                                         # the quill
    # the whole body: darker low down (in two steps), a little lighter high up
    if mat in ('armor', 'flesh', 'row', 'band', None):
        tone += -1.5 if h01 < 0.1 else -0.75 if h01 < 0.3 else (0.5 if h01 > 0.88 else 0)
    # lit from above: faces looking up lighter, looking down darker
    if up > 0.6:
        tone += 0.75
    elif up < -0.6:
        tone -= 0.75
    if mat == 'band' and side and fh >= 3 and y in (0, fh - 1):
        tone += 2                                             # the band's pale rim along its top and bottom edge
    tone += dither
    # the chakra's lines, the anime's linework: thin darker streaks wavering up the sides, broken into flames, laid on
    # the model's own grid so they run on across boxes that meet
    if mat in ('armor', 'flesh', 'row', None) and wp is not None and abs(up) < 0.6:
        col = q[0] + q[2]
        wave = int(round(1.4 * math.sin(q[1] * 0.45 + ph(col // 9, 0, 0, 41) * 6.28)))
        if (col + wave) % 9 == 0 and ph(col // 9, q[1] // 5, 0, 43) < 0.55:
            tone -= 1.25
    # bone: now and then a pair of darker pits
    if mat == 'bone' and wp is not None:
        cq = (q[0] // 5, q[1] // 5, q[2] // 5)
        if ph(*cq, 11) < 0.18:
            ox, oy, oz = (int(ph(*cq, 21 + k) * 3) for k in range(3))
            if (q[0] - cq[0] * 5 - ox) in (0, 1) and q[1] - cq[1] * 5 == oy and (q[2] - cq[2] * 5 - oz) in (0, 1):
                tone -= 1.25
    style = os.environ.get('SUSANOO_STYLE', 'D')               # D, the user's pick (the others kept to compare)
    if style != 'A' and mat in ('armor', 'flesh', 'row', 'band', 'roll', 'bone', None):
        e = min(x, fw - 1 - x, y, fh - 1 - y)
        reach = 3
        if style == 'B':
            # anime linework: a pale see-through fill, dark purple lines along every edge
            if e == 0 and min(fw, fh) >= 3:
                return r[1], 240
            tone = 4 + (0.5 if up > 0.6 else 0) - (0.75 if h01 < 0.2 else 0)
            alpha = 150
        elif style == 'C':
            # vanilla mob shading: each face lit along its top, shaded along its bottom two rows, sides a half step down
            tone = base + (0.75 if up > 0.6 else -0.75 if up < -0.6 else 0)
            if side and fh >= 4:
                tone += 1 if y == 0 else -1 if y == fh - 1 else -0.5 if (y == fh - 2 and fh >= 8) else 0
                if fw >= 6 and x in (0, fw - 1):
                    tone -= 0.5
            if mat == 'bone':
                tone += 1
            tone += -0.5 if d < 0.06 else 0.5 if d > 0.94 else 0
        elif style == 'D':
            # an energy glow (the Complete's, which the user liked), the same on every part: deep at the rim, bright in the
            # middle within three pixels, thin pieces reaching the same bright middle across their width
            if mat == 'row' and disc is not None and wp is not None:
                cx, cy, rad = disc
                e = max(rad - math.hypot(wp[0] - cx, wp[1] - cy), 0) / 2.2      # the shield: one glow over the disc
                reach = 5.5                                                    # (wide, so its middle stays deeper)
                # (item 5) a spiral winding out from the boss to the rim, three turns, a dark line two pixels wide
                dx, dy = wp[0] - cx, wp[1] - cy
                dist = math.hypot(dx, dy)
                ang = math.atan2(dy, dx)
                gap = (rad - 10) / 3.0                                        # the spiral's spacing between its turns
                along = (dist - 10 - ang / (2 * math.pi) * gap) % gap
                if 10 < dist < rad - 3 and min(along, gap - along) < 1.1:
                    e = 0
            else:
                # the rim only along the face's open edges: where it runs on into another part, no line (they join up)
                if edges is not None:
                    ux = [edges[k] for k in ('-u', '+u') if edges[k] is not None]
                    vy = [edges[k] for k in ('-v', '+v') if edges[k] is not None]
                else:
                    ux, vy = [x, fw - 1 - x], [y, fh - 1 - y]
                near = ux + vy
                e = min(near) if near else 3
                reach = max(1.0, min(3.0, (min(fw, fh) - 1) / 2))
            if plates2d and wp is not None:
                # the Humanoid's torso: the plates it was built from, each glowing from its own edges like the Armoured's
                # plates, a darker seam where two meet; the outline's own rim on top of that
                best = None
                for cx, cy, ang, pw, ph in plates2d:
                    dx, dy = wp[0] - cx, wp[1] - cy
                    qx = dx * math.cos(ang) + dy * math.sin(ang)
                    qy = -dx * math.sin(ang) + dy * math.cos(ang)
                    dd = min(pw / 2 - abs(qx), ph / 2 - abs(qy))
                    if dd >= 0 and (best is None or dd > best):
                        best = dd
                if best is not None:
                    e = min(e, best - 1.0)                 # a two-pixel seam, then a wide glow (the user: thicker)
                    reach = 5
            if column and wp is not None and abs(up) < 0.6 and int(math.floor(wp[1] + 1e-3)) % 4 == 0:
                e = min(e, 0.6)                           # the spine's vertebrae: a seam every four pixels
            if min(fw, fh) <= 2 and False and mat == 'flesh' and max(fw, fh) >= 6 and not plates2d:
                along = min(x, fw - 1 - x) if fw > fh else min(y, fh - 1 - y)
                tone = 1.5 + min(along / 3.0, 1.0) * 2.55 + (0.5 if up > 0.6 else 0)
            elif min(fw, fh) <= 2 and not plates2d and disc is None:
                # a face one or two pixels across (a band's top, a rib's side): too thin for a rim and a middle, one tone
                tone = 2.9 + (0.6 if up > 0.6 else -0.4 if up < -0.6 else 0)
            else:
                tone = 1.5 + min(max(e, 0) / reach, 1.0) * 2.55 + (0.5 if up > 0.6 else 0)
            alpha = 236 if mat == 'flesh' else 222 if mat == 'row' else 205 if column else 214
    if bone in ('body', 'right_arm', 'left_arm') and mat not in ('eye', 'dark', 'black', 'row', 'mark'):
        alpha = 244                                       # (item 7) nearly solid: no plates showing through
    tone = max(0.0, min(5.0, tone))
    lo = int(math.floor(tone))
    f = tone - lo
    if f < 1e-6:
        return r[lo], alpha
    return tuple(int(r[lo][k] + (r[lo + 1][k] - r[lo][k]) * f) for k in range(3)), alpha
