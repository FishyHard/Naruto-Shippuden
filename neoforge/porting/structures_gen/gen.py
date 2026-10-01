"""Writes the story's structure templates and the flat-world preview plan.

    python3 gen.py [piece ...]      (run from porting/structures_gen)

Templates go to data/naruto_shippuden/structure/<village>/<piece>.nbt in both resource trees. The preview plan
(run/structure_preview.txt) places each piece in a row and frames it from the front and the back; view it with
    ./gradlew runClient -PdevTest -PquickPlay=structtest -PdevOnly=structures
"""
import math, os, sys
import json
import leaf, leaf_landmarks, leaf_houses, leaf_buildings, leaf_layout, leaf_ring, leaf_districts, leaf_decor

HERE = os.path.dirname(os.path.abspath(__file__))
NEO = os.path.normpath(os.path.join(HERE, '..', '..'))
TREES = [os.path.join(NEO, 'src/main/resources'), os.path.join(NEO, 'porting/res_override')]
LEAF = dict(leaf.PIECES)
for old in ('house_a', 'house_b', 'house_round'):
    del LEAF[old]
LEAF.update(gate=leaf_landmarks.gate, hokage_tower=leaf_landmarks.hokage_tower, hokage_rock=leaf_landmarks.hokage_rock,
            hokage_rock_fifth=leaf_landmarks.hokage_rock_fifth,
            water_tower=leaf_landmarks.water_tower)
LEAF.update(leaf_houses.VARIANTS)
LEAF.update(leaf_buildings.PIECES)
LEAF.update(leaf_ring.PIECES)
LEAF.update(leaf_districts.PIECES)
LEAF.update(wall=leaf_landmarks.village_wall, wall_pipes=lambda: leaf_landmarks.village_wall(pipes=True))
VILLAGES = {'leaf': LEAF}
GROUND = -60          # the flat world's surface (the first air block)
EXTRA_SHOTS = {
    # name: (dx, dy, dz, look_dx, look_dy, look_dz) from the template corner: views from inside
    'leaf/gate': [('outside', 29.5, 6, 40, 29.5, 12, 9)],
    'leaf/hokage_rock': [('close', 87, 50, 175, 87, 60, 30)],
    'leaf/hokage_rock_fifth': [('close', 87, 50, 175, 87, 60, 30), ('angle', 30, 45, 120, 87, 60, 30),
                              ('below', 70, 12, 95, 75, 62, 40), ('below_side', 20, 10, 90, 70, 60, 40)],
    'leaf/hokage_tower': [('roof', 48, 50, 48, 30, 41, 30), ('landing', 24, 29, 37, 33, 27, 34), ('hall', 30.5, 7, 45, 30.5, 4, 18), ('standby', 20, 6, 28.5, 48, 3, 28),
                          ('council', 30.5, 17, 41, 30.5, 13, 30), ('quarters', 24, 22, 37, 36, 19, 24),
                          ('office', 30.5, 31, 38, 30.5, 28, 24), ('street', 38, 6, 80, 30, 26, 30), ('aerial', 75, 60, 85, 30, 20, 30)],
    'leaf/academy': [('classroom', 12, 11, 15, 12, 8, 5), ('exam', 36, 5, 15, 36, 3, 5), ('library', 12, 17, 15, 12, 14, 5),
                     ('hall', 21, 4.5, 22, 24, 3, 12), ('crest', 24, 15, 46, 24, 16, 25), ('training', 36, 17, 15, 36, 14, 5)],
    'leaf/academy_yard': [('swing', 20, 6, 16, 10, 5, 8)],
    'leaf/ramen_shop': [('street', 12, 4, 16, 6, 4, 8), ('counter', 5, 4, 12, 5, 3, 5)],
    'leaf/hospital': [('lobby', 22, 5, 19, 22, 3, 13), ('roof', 8, 26, 18, 30, 21, 8), ('ward', 10, 9, 14, 20, 8, 20)],
}


def look(cx, cy, cz, tx, ty, tz):
    dx, dy, dz = tx - cx, ty - cy, tz - cz
    yaw = math.degrees(math.atan2(-dx, dz))
    pitch = math.degrees(math.atan2(-dy, math.hypot(dx, dz)))
    return '%.1f %.1f %.1f %.1f %.1f' % (cx, cy, cz, yaw, pitch)


def main(only):
    plan = ['# written by porting/structures_gen/gen.py']
    x = 0
    z = 0
    for village, pieces in VILLAGES.items():
        for name, make in pieces.items():
            b = make()
            n = 0
            for tree in TREES:
                n = b.save(os.path.join(tree, 'data/naruto_shippuden/structure/%s/%s.nbt' % (village, name)))
            print('%s/%s: %dx%dx%d, %d blocks' % (village, name, b.w, b.h, b.d, n))
            if only and name not in only:
                x += b.w + 16
                continue
            y0 = GROUND - leaf.G
            plan.append('place %s/%s %d %d %d' % (village, name, x, y0, z))
            # the middle of the piece, and two three-quarter views
            mx, my, mz = x + b.w / 2, GROUND + b.h * 0.35, z + b.d / 2
            r = max(b.w, b.d, b.h) * 0.85 + 4
            plan.append('shot %s_%s_front %s' % (village, name, look(mx + r * 0.6, GROUND + b.h * 0.75 + 4, mz + r, mx, my, mz)))
            plan.append('shot %s_%s_back %s' % (village, name, look(mx - r * 0.6, GROUND + b.h * 0.75 + 4, mz - r, mx, my, mz)))
            for (shot, cx, cy, cz, tx, ty, tz) in EXTRA_SHOTS.get('%s/%s' % (village, name), []):
                plan.append('shot %s_%s_%s %s' % (village, name, shot, look(x + cx, y0 + cy, z + cz, x + tx, y0 + ty, z + tz)))
            x += b.w + 16
    with open(os.path.join(NEO, 'run/structure_preview.txt'), 'w') as f:
        f.write('\n'.join(plan) + '\n')


VILLAGE_SHOTS = [  # name, camera, target (village coordinates, y from the ground)
    ('skyline', (200, 70, 450), (200, 25, 160)),
    ('gate_in', (200, 4, 384), (200, 18, 190)),
    ('plaza', (200, 4, 178), (200, 40, 60)),
    ('stadium', (150, 40, 330), (95, 10, 245)),
    ('stadium_in', (95, 30, 280), (95, 28, 196)),
    ('ichiraku', (202, 3, 270), (180, 3, 270)),
    ('river', (240, 8, 372), (200, 2, 350)),
    ('rock_join', (60, 40, 150), (113, 40, 40)),
    ('gate_join', (250, 12, 425), (169, 22, 397)),
    ('uchiha', (299, 35, 222), (299, 0, 275)),
    ('hyuga', (319, 35, 138), (319, 0, 180)),
    ('springs', (232, 25, 290), (232, 0, 318)),
    ('stands', (95, 32, 300), (95, 25, 250)),
    ('training', (66, 20, 175), (66, 2, 145)),
    ('aerial', (450, 160, 470), (200, 0, 215)),
    ('top', (200, 250, 226), (200, 0, 215)),
]
STAY = (200, 20, 430, 180, 10)          # where the game is left open to fly round in: x, y above ground, z, yaw, pitch


def village():
    """Builds every Leaf piece, writes the layout to data/naruto_shippuden/village/leaf.json, and a preview plan that
    places the whole village in the flat world and frames it."""
    sizes, origins = {}, dict(leaf_ring.ORIGINS)
    for name, make in LEAF.items():
        b = make()
        if hasattr(b, 'origin'):
            origins[name] = b.origin
        for tree in TREES:
            b.save(os.path.join(tree, 'data/naruto_shippuden/structure/leaf/%s.nbt' % name))
        sizes[name] = (b.w, b.h, b.d)
    lay = leaf_layout.layout(sizes, origins)
    # the greenery and lamps, made to fit round everything the layout placed
    d = leaf_decor.decor(lay)
    for tree in TREES:
        d.save(os.path.join(tree, 'data/naruto_shippuden/structure/leaf/decor.nbt'))
    sizes['decor'] = (d.w, d.h, d.d)
    lay['pieces'].append({'piece': 'leaf/decor', 'x': d.origin[0], 'z': d.origin[1], 'rotation': 'none'})
    lay.pop('taken', None)
    for tree in TREES:
        path = os.path.join(tree, 'data/naruto_shippuden/village/leaf.json')
        os.makedirs(os.path.dirname(path), exist_ok=True)
        with open(path, 'w') as f:
            json.dump(lay, f, indent=1)
    y0 = GROUND - leaf.G
    plan = ['# written by porting/structures_gen/gen.py --village']
    for (x1, z1, x2, z2, kind) in lay['roads']:
        for zz in range(z1, z2 + 1, 64):
            plan.append('cmd fill %d %d %d %d %d %d dirt_path' % (x1, GROUND - 1, zz, x2, GROUND - 1, min(z2, zz + 63)))
    for p in lay['pieces']:
        w, _, d = sizes[p['piece'].split('/')[1]]
        line = 'place %s %d %d %d %s' % (p['piece'], p['x'], y0, p['z'], p['rotation'])
        if max(w, d) > 100:
            line += ' %d %d' % (p['x'] + w // 2, p['z'] + d // 2)     # a big piece: load round its middle
        plan.append(line)
    for (name, c, t) in VILLAGE_SHOTS:
        plan.append('cmd time set 6000')
        plan.append('shot village_%s %s' % (name, look(c[0], GROUND + c[1], c[2], t[0], GROUND + t[1], t[2])))
    plan.append('stay %d %d %d %d %d' % (STAY[0], GROUND + STAY[1], STAY[2], STAY[3], STAY[4]))
    with open(os.path.join(NEO, 'run/structure_preview.txt'), 'w') as f:
        f.write('\n'.join(plan) + '\n')
    print(len(lay['pieces']), 'pieces')


if __name__ == '__main__':
    if sys.argv[1:] == ['--village']:
        village()
    else:
        main(set(sys.argv[1:]))
