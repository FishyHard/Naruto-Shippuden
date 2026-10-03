"""The user's Susanoo models (Blockbench, porting/susanoo_src/*.bbmodel) made into the mod's Susanoo (client/SusanooModels):
their shapes as they are, bone for bone and cube for cube, with a new texture painted the vanilla way: each box face a pale
glow of its owner's colour with a darker pixel outline round it (the anime's line art), the top face lighter, the bottom
darker, the odd bright fleck; the eyes (the yellow of the user's texture) glowing yellow.

Each model becomes assets/naruto_shippuden/susanoo/<owner>_<stage>.json (bones: name, pivot, rotation, boxes with their UV
offset; the bones the renderer moves renamed for their role: body, head, right_arm, left_arm, right_leg, left_leg,
right_wing, left_wing, weapon) and textures/entities/susanoo/<owner>_<stage>.png, in both resource trees.

Blockbench to Minecraft: x and y flip (a model's +x is its left, -y up), z stays; rotations flip about x and y. A bone given a
role gets its pivot moved where it should turn (shoulder, hip, neck, wing root), found from its boxes.

`python3 susanoo_convert.py [preview_dir]`"""
import base64
import io
import json
import math
import os
import sys

from PIL import Image

HERE = os.path.dirname(os.path.abspath(__file__))
NEO = os.path.normpath(os.path.join(HERE, '..', '..'))
SRC = os.path.join(NEO, 'porting', 'susanoo_src')
TREES = [os.path.join(NEO, 'src/main/resources'), os.path.join(NEO, 'porting/res_override')]

# (owner, stage): source file, roles {bone: role}, reparent {role: parent role}, extra settings
MODELS = {
    # Sasuke's own models, rigged by sasuke_rig.py (parts named for what they move, pivots on the joints, no flicker)
    ('*', 1): ('sasuke/ribcage', {}, {}, {'keep_pivots': True}),
    ('sasuke', 2): ('sasuke/skeleton', {}, {}, {'keep_pivots': True}),
    ('sasuke', 3): ('sasuke/humanoid', {}, {}, {'keep_pivots': True}),
    ('sasuke', 4): ('sasuke/armoured', {}, {}, {'keep_pivots': True}),
    ('sasuke', 5): ('sasuke/complete', {}, {}, {'keep_pivots': True, 'seat': 'head'}),
    # the Complete one's other poses: floating in the air, flying fast (client/SusanooRenderer picks one)
    ('sasuke', '5_float'): ('sasuke/complete_float', {}, {}, {'keep_pivots': True, 'seat': 'head'}),
    ('sasuke', '5_fly'): ('sasuke/complete_fly', {}, {}, {'keep_pivots': True, 'seat': 'head'}),
}
# the other owners (owner_rig.py): Sasuke's Skeleton without its horns for all; each one's own Humanoid and Armoured; Sasuke's
# Complete for those not yet given their own changes
for _o in ('itachi', 'shisui', 'madara', 'obito'):
    MODELS[(_o, 2)] = ('common/skeleton', {}, {}, {'keep_pivots': True})
for _o in ('shisui', 'itachi', 'madara', 'obito'):
    MODELS[(_o, 3)] = (_o + '/humanoid', {}, {}, {'keep_pivots': True, 'seat_tag': 'torso'})
    MODELS[(_o, 4)] = (_o + '/armoured', {}, {}, {'keep_pivots': True})
    for _k, _n in ((5, 'complete'), ('5_float', 'complete_float'), ('5_fly', 'complete_fly')):
        MODELS[(_o, _k)] = (_o + '/' + _n, {}, {}, {'keep_pivots': True, 'seat': 'head'})
OWNERS = ['sasuke', 'itachi', 'shisui', 'madara', 'obito']


def _h(x, y, salt):
    v = (x * 73856093) ^ (y * 19349663) ^ (salt * 83492791)
    v = (v ^ (v >> 13)) * 1274126177
    return ((v ^ (v >> 16)) & 0xffffffff) / 0xffffffff


# ------------------------------------------------------------------ blockbench geometry
def rot(p, origin, angles):
    """A point turned about origin by Blockbench's euler angles (degrees; R = Rz Ry Rx, so x is applied first)."""
    x, y, z = (p[i] - origin[i] for i in range(3))
    ax, ay, az = (math.radians(a) for a in angles)
    c, s = math.cos(ax), math.sin(ax); y, z = y * c - z * s, y * s + z * c
    c, s = math.cos(ay), math.sin(ay); x, z = x * c + z * s, -x * s + z * c
    c, s = math.cos(az), math.sin(az); x, y = x * c - y * s, x * s + y * c
    return (x + origin[0], y + origin[1], z + origin[2])


def load(name):
    d = json.load(open(os.path.join(SRC, name + '.bbmodel')))
    tex = None
    if d.get('textures'):
        src = d['textures'][0].get('source', '')
        if src.startswith('data:image'):
            tex = Image.open(io.BytesIO(base64.b64decode(src.split(',')[1]))).convert('RGBA')
            res = d.get('resolution', {'width': tex.width, 'height': tex.height})
            tex = tex.resize((res['width'], res['height']), Image.NEAREST)
    return d, tex


def is_eye(e, tex):
    """Whether the user's texture paints this box yellow (an eye)."""
    if tex is None:
        return False
    face = e.get('faces', {}).get('north') or next(iter(e.get('faces', {}).values()), None)
    if not face or 'uv' not in face:
        return False
    u0, v0, u1, v1 = face['uv']
    u0, u1 = sorted((u0, u1)); v0, v1 = sorted((v0, v1))
    n = yellow = 0
    for u in range(int(u0), max(int(u0) + 1, int(math.ceil(u1)))):
        for v in range(int(v0), max(int(v0) + 1, int(math.ceil(v1)))):
            if 0 <= u < tex.width and 0 <= v < tex.height:
                r, g, b, a = tex.getpixel((u, v))
                if a > 0:
                    n += 1
                    if r > 190 and g > 150 and b < 140:
                        yellow += 1
    return n > 0 and yellow / n > 0.35


def world_corners(e, chain):
    f, t = e['from'], e['to']
    pts = [(x, y, z) for x in (f[0], t[0]) for y in (f[1], t[1]) for z in (f[2], t[2])]
    pts = [rot(p, e.get('origin', [0, 0, 0]), e.get('rotation', [0, 0, 0])) for p in pts]
    for go, gr in reversed(chain):
        pts = [rot(p, go, gr) for p in pts]
    return pts


# ------------------------------------------------------------------ conversion
def convert(name, roles, reparent, extra):
    d, tex = load(name) if isinstance(name, str) else (name, None)
    els = {e['uuid']: e for e in d['elements']}
    bones = {}          # name -> {name, parent, origin (bb), rotation (bb), cubes: [element]}
    order = []

    def walk(node, parent, chain):
        if isinstance(node, str):
            e = els.get(node)
            if e and e.get('type', 'cube') == 'cube' and e.get('visibility', True) is not False:
                bones[parent]['cubes'].append(e)
                wc = world_corners(e, chain)
                bones[parent]['world'].extend(wc)
                e['_wy'] = (min(q[1] for q in wc), max(q[1] for q in wc))
                e['_wc'] = wc
                e['_chain'] = chain
            return
        nm = node['name']
        base = nm
        k = 2
        while nm in bones:
            nm = base + '_' + str(k); k += 1
        nm = roles.get(base, nm) if base in roles and roles[base] not in bones else nm
        bones[nm] = {'name': nm, 'parent': parent, 'origin': list(node.get('origin', [0, 0, 0])), 'rotation': list(node.get('rotation', [0, 0, 0])),
                     'cubes': [], 'world': [], 'children': []}
        order.append(nm)
        if parent:
            bones[parent]['children'].append(nm)
        g = (node.get('origin', [0, 0, 0]), node.get('rotation', [0, 0, 0]))
        for ch in node.get('children', []):
            walk(ch, nm, chain + [g])
    bones['__root'] = {'name': '__root', 'parent': None, 'origin': [0, 0, 0], 'rotation': [0, 0, 0], 'cubes': [], 'world': [], 'children': []}
    for n in d['outliner']:
        walk(n, '__root', [])
    # bones left out (the user disliked them: the armoured one's wheel)
    for gone in extra.get('drop', []):
        if gone in bones:
            def remove(nm):
                for c in list(bones[nm]['children']):
                    remove(c)
                del bones[nm]
                if nm in order:
                    order.remove(nm)
            parent = bones[gone]['parent']
            bones[parent]['children'].remove(gone)
            remove(gone)

    def subtree_world(nm):
        pts = list(bones[nm]['world'])
        for c in bones[nm]['children']:
            pts += subtree_world(c)
        return pts

    # move a role bone under its new parent (only unrotated bones; the user's are)
    for role, new_parent in reparent.items():
        if role in bones and new_parent in bones and bones[role]['parent'] != new_parent:
            old = bones[role]['parent']
            bones[old]['children'].remove(role)
            bones[new_parent]['children'].append(role)
            bones[role]['parent'] = new_parent

    # pivots where the parts turn, from their boxes (only for unrotated bones, whose boxes don't move with it)
    def bbox(nm):
        pts = subtree_world(nm)
        if not pts:
            return None
        return [min(p[i] for p in pts) for i in range(3)], [max(p[i] for p in pts) for i in range(3)]
    for nm in ([] if extra.get('keep_pivots') else list(bones)):
        if nm not in ('body', 'head', 'right_arm', 'left_arm', 'right_leg', 'left_leg', 'right_wing', 'left_wing') or any(bones[nm]['rotation']):
            continue
        b = bbox(nm)
        if not b:
            continue
        lo, hi = b
        cx, cz = (lo[0] + hi[0]) / 2, (lo[2] + hi[2]) / 2
        if nm == 'body':
            pivot = [0, lo[1], cz]
        elif nm == 'head':
            pivot = [cx, lo[1], cz]
        elif nm in ('right_arm', 'left_arm', 'right_leg', 'left_leg'):
            pivot = [cx, hi[1] - (hi[1] - lo[1]) * 0.12, cz]
        else:
            inner = lo[0] if abs(lo[0]) < abs(hi[0]) else hi[0]
            pivot = [inner, lo[1] + (hi[1] - lo[1]) * 0.35, lo[2]]
        bones[nm]['origin'] = pivot

    # where the user stands in it: the origin, or (the Complete stage) its belly
    lo_all = [min(p[i] for p in subtree_world('__root')) for i in range(3)]
    hi_all = [max(p[i] for p in subtree_world('__root')) for i in range(3)]
    lift = 0

    # boxes: their faces' UV laid out afresh and painted
    boxes = []
    for nm in order:
        for e in bones[nm]['cubes']:
            size = [e['to'][i] - e['from'][i] for i in range(3)]
            boxes.append((nm, e, size, e.get('mat') or e.get('susanoo_mat') or ('eye' if is_eye(e, tex) else None)))
    for e in [b[1] for b in boxes]:
        lo, hi = e.get('_wy', (0, 1))
        e['_h01'] = ((lo - lo_all[1]) / max(1e-6, hi_all[1] - lo_all[1]), (hi - lo_all[1]) / max(1e-6, hi_all[1] - lo_all[1]))
    layout, tw, th = pack([b[2] for b in boxes])

    def mc_pivot(origin, parent_origin):
        return [-(origin[0] - parent_origin[0]), -(origin[1] - parent_origin[1]), origin[2] - parent_origin[2]]

    def mc_rot(r):
        return [-math.radians(r[0]), -math.radians(r[1]), math.radians(r[2])]

    out_bones = []
    index = {id(b[1]): i for i, b in enumerate(boxes)}

    def emit(nm, parent_origin, parent_name):
        b = bones[nm]
        origin = b['origin']
        pivot = mc_pivot(origin, parent_origin)
        if parent_name is None:
            pivot = [-(origin[0]), -(origin[1] - lift), origin[2]]
        cubes = []
        for e in b['cubes']:
            i = index[id(e)]
            size = boxes[i][2]
            r = e.get('rotation', [0, 0, 0])
            o = e.get('origin', [0, 0, 0])
            entry = {'uv': layout[i], 'size': [round(v, 4) for v in size], 'inflate': e.get('inflate', 0)}
            if any(r):
                entry['pivot'] = [round(v, 4) for v in mc_pivot(o, origin)]
                entry['rot'] = [round(v, 5) for v in mc_rot(r)]
                entry['from'] = [round(-(e['to'][0] - o[0]), 4), round(-(e['to'][1] - o[1]), 4), round(e['from'][2] - o[2], 4)]
            else:
                entry['from'] = [round(-(e['to'][0] - origin[0]), 4), round(-(e['to'][1] - origin[1]), 4), round(e['from'][2] - origin[2], 4)]
            cubes.append(entry)
        out_bones.append({'name': nm, 'parent': parent_name, 'pivot': [round(v, 4) for v in pivot], 'rot': [round(v, 5) for v in mc_rot(b['rotation'])],
                          'cubes': cubes})
        for c in b['children']:
            emit(c, origin, nm)
    for c in bones['__root']['children']:
        emit(c, [0, 0, 0], None)
    # the middle of its body (its torso's boxes, not hair or weapons), where the renderer puts its user
    # (the Complete one: its head, where its user sits, standing and flying)
    seat_part = extra.get('seat', 'body')
    tag = extra.get('seat_tag')                                 # only the boxes of that name (an owner's torso rows)
    body = [q for nm, e, size, mat in boxes if nm == seat_part and mat not in ('flame', 'bright', 'eye', 'black')
            and (tag is None or e.get('name') == tag) for q in e.get('_wc', [])]
    seat = [round((min(q[i] for q in body) + max(q[i] for q in body)) / 2, 2) for i in (0, 2, 1)] if body else [0, 0, 0]   # x, z, y
    return {'texture': [tw, th], 'height': round(hi_all[1] - lo_all[1], 2), 'bottom': round(lo_all[1], 2), 'seat': seat,
            'bones': out_bones}, boxes, layout, (tw, th)


def pack(sizes):
    """Shelf-packs the box nets (2(d+w) x (d+h), whole pixels, a pixel apart): their UV offsets and the texture's size."""
    nets = []
    for i, (w, h, d) in enumerate(sizes):
        W, H, D = (max(1, int(math.floor(v + 0.5))) for v in (w, h, d))   # as Java rounds them (SusanooModels.box)
        nets.append((i, 2 * (D + W) + 1, D + H + 1))
    width = 512
    while True:
        layout, x, y, row = {}, 0, 0, 0
        for i, nw, nh in sorted(nets, key=lambda n: -n[2]):
            if x + nw > width:
                x, y, row = 0, y + row, 0
            layout[i] = [x, y]
            x += nw
            row = max(row, nh)
        height = y + row
        if height <= width * 2 or width >= 4096:
            break
        width *= 2
    th = 1
    while th < height:
        th *= 2
    return layout, width, max(th, 64)


# each owner's ramp, darkest (the outline) to lightest: the chakra's colour in seven tones
RAMPS = {
    # shadows lean blue, lights lean pink, the way vanilla shifts the hue along a ramp
    'sasuke': ((30, 14, 78), (56, 30, 124), (86, 50, 166), (120, 78, 206), (160, 112, 236), (204, 160, 252), (238, 214, 255)),
    'itachi': ((80, 14, 6), (140, 36, 18), (196, 70, 40), (238, 112, 72), (255, 156, 116), (255, 200, 170), (255, 236, 222)),
    'shisui': ((8, 56, 26), (20, 104, 50), (40, 156, 82), (84, 204, 122), (140, 236, 166), (196, 252, 210), (236, 255, 240)),
    'madara': ((12, 22, 92), (30, 52, 160), (58, 92, 214), (100, 136, 246), (148, 178, 255), (200, 216, 255), (238, 244, 255)),
    'obito': ((20, 56, 82), (44, 100, 136), (80, 148, 186), (128, 196, 228), (176, 226, 246), (214, 244, 255), (246, 252, 255)),
}
EYES = ((120, 70, 0), (214, 140, 30), (255, 200, 70), (255, 228, 110), (255, 246, 200))

# the faces of a box-UV net, as Minecraft lays them out: where (from the net's corner), size, which way the texture's u and v
# run in the cube's own (Minecraft) axes, and which face of the cube it is (the axis it faces along, -1 the low side)
NET = {
    'top': (lambda D, W, H: (D, 0, W, D), ((0, 1), (2, -1)), (1, -1)),
    'bottom': (lambda D, W, H: (D + W, 0, W, D), ((0, 1), (2, 1)), (1, 1)),
    'right': (lambda D, W, H: (0, D, D, H), ((2, -1), (1, 1)), (0, -1)),
    'front': (lambda D, W, H: (D, D, W, H), ((0, 1), (1, 1)), (2, -1)),
    'left': (lambda D, W, H: (D + W, D, D, H), ((2, 1), (1, 1)), (0, 1)),
    'back': (lambda D, W, H: (2 * D + W, D, W, H), ((0, -1), (1, 1)), (2, 1)),
}


def _noise(x, y, cell, salt):
    """Blots of value noise in 0..1 over cells of `cell` pixels (clumps, the way vanilla's textures speckle)."""
    gx, gy = x / cell, y / cell
    x0, y0 = int(math.floor(gx)), int(math.floor(gy))
    fx, fy = gx - x0, gy - y0
    a, b = _h(x0, y0, salt), _h(x0 + 1, y0, salt)
    c, d = _h(x0, y0 + 1, salt), _h(x0 + 1, y0 + 1, salt)
    top = a + (b - a) * fx
    return top + ((c + (d - c) * fx) - top) * fy


# the tone each material is built around (an index into the owner's ramp) and how see-through it is
BASE = {'band': (3, 215), 'roll': (3, 225), 'bone': (4, 232), 'armor': (3, 222), 'row': (3, 222), 'flesh': (3, 190), 'feather': (3, 218), 'dark': (1, 235),
        None: (3, 200)}


def _noise3(p, cell, salt):
    """Smooth value noise over the model's own space (so boxes that touch carry on each other's pattern)."""
    g = [v / cell for v in p]
    i0 = [int(math.floor(v)) for v in g]
    f = [v - i for v, i in zip(g, i0)]

    def h(a, b, c):
        v = (a * 73856093) ^ (b * 19349663) ^ (c * 83492791) ^ (salt * 2654435761)
        v = (v ^ (v >> 13)) * 1274126177
        return ((v ^ (v >> 16)) & 0xffffffff) / 0xffffffff
    out = 0.0
    for dx in (0, 1):
        for dy in (0, 1):
            for dz in (0, 1):
                w = (f[0] if dx else 1 - f[0]) * (f[1] if dy else 1 - f[1]) * (f[2] if dz else 1 - f[2])
                out += w * h(i0[0] + dx, i0[1] + dy, i0[2] + dz)
    return out


# texel(): each stage's own, in susanoo_paint/


STAGE = ['5']                                               # the stage being painted (set by the main loop)


def style(stage):
    """The painting module for a stage (susanoo_paint/stage<N>_<name>.py); the Complete's poses share the Complete's."""
    import importlib
    n = str(stage).split('_')[0]
    mod = {'1': 'stage1_ribcage', '2': 'stage2_skeleton', '3': 'stage3_humanoid', '4': 'stage4_armoured', '5': 'stage5_complete'}[n]
    return importlib.import_module('susanoo_paint.' + mod)


def paint(boxes, layout, size, owner, salt):
    """Each box's six faces painted for what it is (its material), the way Java Edition's mobs are: soft stepped shading on
    each face, a little noise, no outlines; flame and feathers shade from root to tip."""
    global STYLE
    STYLE = style(STAGE[0])
    r = RAMPS[owner]
    im = Image.new('RGBA', size, (0, 0, 0, 0))
    px = im.load()

    def frame(e, sizes):
        # a box in the model's space: its middle, its three axes, half its size, and the box round it
        chain = e.get('_chain', [])

        def world(mc):
            p = (e['to'][0] - mc[0], e['to'][1] - mc[1], e['from'][2] + mc[2])
            p = rot(p, e.get('origin', [0, 0, 0]), e.get('rotation', [0, 0, 0]) or [0, 0, 0])
            for go, gr in reversed(chain):
                p = rot(p, go, gr or [0, 0, 0])
            return p
        c = world([sizes[0] / 2, sizes[1] / 2, sizes[2] / 2])
        axes = []
        for k in range(3):
            q = [sizes[0] / 2, sizes[1] / 2, sizes[2] / 2]
            q[k] += 1
            a = world(q)
            axes.append([a[j] - c[j] for j in range(3)])
        corners = [world([sx * sizes[0], sy * sizes[1], sz * sizes[2]]) for sx in (0, 1) for sy in (0, 1) for sz in (0, 1)]
        lo = [min(p[j] for p in corners) for j in range(3)]
        hi = [max(p[j] for p in corners) for j in range(3)]
        return c, axes, [v / 2 for v in sizes], lo, hi
    frames = [frame(b[1], b[2]) for b in boxes]

    def inside(p, f):
        c, axes, half, lo, hi = f
        if any(p[j] < lo[j] - 0.05 or p[j] > hi[j] + 0.05 for j in range(3)):
            return False
        q = [p[j] - c[j] for j in range(3)]
        return all(abs(sum(q[j] * axes[k][j] for j in range(3))) <= half[k] + 0.05 for k in range(3))
    for i, (bone, e, (w, h, d), mat) in enumerate(boxes):
        u, v = layout[i]
        W, H, D = (max(1, int(math.floor(x + 0.5))) for x in (w, h, d))   # as Java rounds them (SusanooModels.box)
        tip = e.get('susanoo_tip')
        if tip is not None:
            axis, sgn = tip
            sgn = -sgn if axis in (0, 1) else sgn               # Blockbench to Minecraft: x and y flip
        seed = salt * 31 + i * 7
        sizes = (w, h, d)
        npx = (W, H, D)
        chain = e.get('_chain', [])

        def world(mc):
            # a point in the cube's Minecraft frame (from its low corner) into the model's Blockbench space
            p = (e['to'][0] - mc[0], e['to'][1] - mc[1], e['from'][2] + mc[2])
            p = rot(p, e.get('origin', [0, 0, 0]), e.get('rotation', [0, 0, 0]) or [0, 0, 0])
            for go, gr in reversed(chain):
                p = rot(p, go, gr or [0, 0, 0])
            return p
        for face, (where, (ua, va), (fa, fs)) in NET.items():
            x0, y0, fw, fh = where(D, W, H)
            if fw <= 0 or fh <= 0:
                continue

            def mc_point(px_, py_):
                q = [0.0, 0.0, 0.0]
                q[fa] = 0.0 if fs < 0 else sizes[fa]
                su, sv = sizes[ua[0]] / max(1, npx[ua[0]]), sizes[va[0]] / max(1, npx[va[0]])
                q[ua[0]] = px_ * su if ua[1] > 0 else sizes[ua[0]] - px_ * su
                q[va[0]] = py_ * sv if va[1] > 0 else sizes[va[0]] - py_ * sv
                return q
            p00 = world(mc_point(0.5, 0.5))
            p10 = world(mc_point(1.5, 0.5))
            p01 = world(mc_point(0.5, 1.5))
            du = [p10[k] - p00[k] for k in range(3)]
            dv = [p01[k] - p00[k] for k in range(3)]
            # which way the face looks, in the world (its outward normal's height)
            mid = world(mc_point(fw / 2, fh / 2))
            inner = [0.0, 0.0, 0.0]
            inner[fa] = sizes[fa] / 2
            for k in range(3):
                if k != fa:
                    inner[k] = sizes[k] / 2
            cin = world(inner)
            nv = [mid[k] - cin[k] for k in range(3)]
            ln = math.sqrt(sum(v * v for v in nv)) or 1
            up = nv[1] / ln
            # which of the face's texture axes runs along the box's longest side (None: the face is its end)
            la = max(range(3), key=lambda k: sizes[k])
            long_axis = 'u' if ua[0] == la else 'v' if va[0] == la else None
            if e.get('susanoo_ring'):
                long_axis = 'u' if va[0] == 1 else None       # a ring's band: rims along its top and bottom only
            if e.get('susanoo_column'):
                long_axis = 'v' if va[0] == 1 else None       # the spine's column: rims down its two sides only
            if e.get('susanoo_knob'):
                long_axis = None                              # a knob on the spine: lit all over, no dark rim
            # the boxes this face might run into
            _, _, _, mlo, mhi = frames[i]
            # (only boxes of the same part: parts move, and a face hidden under an arm would open a hole when it swings)
            near_boxes = [f for j, f in enumerate(frames) if j != i and boxes[j][0] == bone
                          and all(f[3][k] <= mhi[k] + 1.5 and f[4][k] >= mlo[k] - 1.5 for k in range(3))]
            lu = math.sqrt(sum(v * v for v in du)) or 1
            lv = math.sqrt(sum(v * v for v in dv)) or 1
            uu = [v / lu for v in du]
            vv = [v / lv for v in dv]
            nn = [v / ln for v in nv]
            for x in range(fw):
                for y in range(fh):
                    t = cap = None
                    if tip is not None:
                        if fa == axis:
                            cap = 1.0 if fs == sgn else 0.0
                        elif ua[0] == axis:
                            f = (x + 0.5) / fw
                            t = f if ua[1] * sgn > 0 else 1 - f
                        elif va[0] == axis:
                            f = (y + 0.5) / fh
                            t = f if va[1] * sgn > 0 else 1 - f
                    # how high up the model this pixel is (side faces run top to bottom; tops and bottoms at their edge)
                    lo01, hi01 = e.get('_h01', (0.5, 0.5))
                    if face in ('top', 'bottom'):
                        h01 = hi01 if face == 'top' else lo01
                    else:
                        h01 = hi01 + (lo01 - hi01) * (y + 0.5) / fh
                    wp = [p00[k] + du[k] * x + dv[k] * y for k in range(3)]
                    X, Y = u + x0 + x, v + y0 + y
                    # under another box's surface: not drawn at all, so a see-through Susanoo shows only its skin, not
                    # the edges of the parts inside it
                    # (the Humanoid's big overlapping plates only: elsewhere parts stacked close (armour courses, feathers,
                    # band panels) would lose faces each other needs and show holes)
                    if near_boxes and STYLE.hidden(mat, bone):
                        # the whole pixel, its middle and its four corners: one partly covered stays (else two parts crossing
                        # at a slant would each lose their edge pixels and leave holes)
                        def covered(px_off):
                            pr = [wp[k] + nn[k] * 0.08 + du[k] * px_off[0] + dv[k] * px_off[1] for k in range(3)]
                            return any(inside(pr, f) for f in near_boxes)
                        if all(covered(o_) for o_ in ((0, 0), (-0.45, -0.45), (0.45, -0.45), (-0.45, 0.45), (0.45, 0.45))):
                            if 0 <= X < size[0] and 0 <= Y < size[1]:
                                px[X, Y] = (0, 0, 0, 0)
                            continue
                    # how far this pixel is from each edge of its face, or None where that edge runs into another box
                    edges = {}
                    for key, dist, axis_v, step, sgn in (('-u', x, uu, lu, -1), ('+u', fw - 1 - x, uu, lu, 1),
                                                         ('-v', y, vv, lv, -1), ('+v', fh - 1 - y, vv, lv, 1)):
                        if dist > 3 or not near_boxes or not STYLE.joins(e):
                            edges[key] = dist
                            continue
                        reach_out = (dist + 0.5) * step + 0.5
                        # joined only where the next box's surface carries on level with this face (a step down or up
                        # keeps its rim: the user saw half-rimmed plates)
                        under = [wp[k] + sgn * axis_v[k] * reach_out - nn[k] * 0.35 for k in range(3)]
                        over = [wp[k] + sgn * axis_v[k] * reach_out + nn[k] * 0.35 for k in range(3)]
                        flush = any(inside(under, f) for f in near_boxes) and not any(inside(over, f) for f in near_boxes)
                        edges[key] = None if flush else dist
                    c, a = STYLE.texel(mat, r, x, y, fw, fh, t, cap, seed + sum(map(ord, face)), face, h01, wp, up, e.get('susanoo_disc'), long_axis,
                                 edges, e.get('susanoo_plates2d') if face in ('front', 'back') else None, bool(e.get('susanoo_column')),
                                 bone=bone, ring=bool(e.get('susanoo_ring')), hair=e.get('mat') == 'flame' or e.get('susanoo_mat') == 'flame')
                    X, Y = u + x0 + x, v + y0 + y
                    if 0 <= X < size[0] and 0 <= Y < size[1]:
                        px[X, Y] = tuple(c) + (a,)
    return im


def write(owner, stage, model, texture):
    for t in TREES:
        md = os.path.join(t, 'assets/naruto_shippuden/susanoo')
        td = os.path.join(t, 'assets/naruto_shippuden/textures/entities/susanoo')
        os.makedirs(md, exist_ok=True)
        os.makedirs(td, exist_ok=True)
        json.dump(model, open(os.path.join(md, f'{owner}_{stage}.json'), 'w'), separators=(',', ':'))
        texture.save(os.path.join(td, f'{owner}_{stage}.png'))


if __name__ == '__main__':
    import susanoo_designs
    # --only=3,4: repaint just those stages (the others' files left exactly as they are, so a fix to one stage can't change
    # another the user has approved)
    only = next((a.split('=', 1)[1].split(',') for a in sys.argv[1:] if a.startswith('--only=')), None)
    # --owner=shisui: only that owner's files
    who = next((a.split('=', 1)[1] for a in sys.argv[1:] if a.startswith('--owner=')), None)
    args = [a for a in sys.argv[1:] if not a.startswith(('--only=', '--owner='))]
    preview = args[0] if args else None
    # the user's Sasuke (and the shared Ribcage), then the new designs for the others (susanoo_designs.py)
    jobs = dict(MODELS)
    for key, model in susanoo_designs.designs().items():
        jobs.setdefault(key, (model.bb(), {}, {}, {}))
    for (owner, stage), (src, roles, reparent, extra) in jobs.items():
        if only is not None and str(stage) not in only:
            continue
        if who is not None and owner != who:
            continue
        model, boxes, layout, size = convert(src, roles, reparent, extra)
        for o in (OWNERS if owner == '*' else [owner]):
            STAGE[0] = str(stage)
            tex = paint(boxes, layout, size, o, sum(map(ord, str(stage))) + len(o))
            write(o, stage, model, tex)
            if preview:
                tex.save(os.path.join(preview, f'tex_{o}_{stage}.png'))
        print(owner, stage, src if isinstance(src, str) else 'design', len(boxes), 'boxes', size, [b['name'] for b in model['bones'] if not b['name'].startswith(('hexadecagon', 'Body_r', 'cube'))][:14])
