"""Writes the story's structure templates and the flat-world preview plan.

    python3 gen.py [piece ...]      (run from porting/structures_gen)

Templates go to data/naruto_shippuden/structure/<village>/<piece>.nbt in both resource trees. The preview plan
(run/structure_preview.txt) places each piece in a row and frames it from the front and the back; view it with
    ./gradlew runClient -PdevTest -PquickPlay=structtest -PdevOnly=structures
"""
import math, os, sys
import leaf, leaf_landmarks, leaf_houses

HERE = os.path.dirname(os.path.abspath(__file__))
NEO = os.path.normpath(os.path.join(HERE, '..', '..'))
TREES = [os.path.join(NEO, 'src/main/resources'), os.path.join(NEO, 'porting/res_override')]
LEAF = dict(leaf.PIECES)
for old in ('house_a', 'house_b', 'house_round'):
    del LEAF[old]
LEAF.update(gate=leaf_landmarks.gate, hokage_tower=leaf_landmarks.hokage_tower, hokage_rock=leaf_landmarks.hokage_rock,
            hokage_rock_five=leaf_landmarks.hokage_rock_five,
            water_tower=leaf_landmarks.water_tower)
LEAF.update(leaf_houses.VARIANTS)
VILLAGES = {'leaf': LEAF}
GROUND = -60          # the flat world's surface (the first air block)
EXTRA_SHOTS = {
    # name: (dx, dy, dz, look_dx, look_dy, look_dz) from the template corner: views from inside
    'leaf/gate': [('outside', 29.5, 6, 40, 29.5, 12, 9)],
    'leaf/hokage_rock': [('close', 87, 50, 175, 87, 60, 30)],
    'leaf/hokage_rock_five': [('close', 87, 50, 175, 87, 60, 30), ('angle', 30, 45, 120, 87, 60, 30)],
    'leaf/hokage_tower': [('hall', 30.5, 7, 45, 30.5, 4, 18), ('archives', 41, 6, 28.5, 12, 3, 28), ('standby', 20, 6, 28.5, 48, 3, 28),
                          ('council', 30.5, 17, 41, 30.5, 13, 30), ('quarters', 37, 23, 39, 26, 20, 25),
                          ('office', 30.5, 31, 38, 30.5, 28, 24), ('street', 38, 6, 80, 30, 26, 30), ('aerial', 75, 60, 85, 30, 20, 30)],
    'leaf/academy': [('classroom', 15.5, 12.5, 15.5, 15.5, 9, 2)],
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


if __name__ == '__main__':
    main(set(sys.argv[1:]))
