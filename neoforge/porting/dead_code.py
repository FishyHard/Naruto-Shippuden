"""Finds the member classes of the big generated files (procedures, entities, renderers, projectile items, effects, particles) that
nothing live refers to, walking references from everything else (items, GUIs, core, event listeners, spawn eggs); an entity keeps its
renderer. Run after porting: python3 dead_code.py dead_classes.txt, then the dead_code rule removes them."""
import os, re, sys, glob, collections
HERE = os.path.dirname(os.path.abspath(__file__))
sys.path.insert(0, HERE)
from rules import find_block
ROOT = os.path.join(HERE, '..', 'src', 'main', 'java', 'net', 'mcreator', 'narutoshippudenmod') + '/'
CANDIDATE_FILES = glob.glob(ROOT + 'procedures/*.java') + glob.glob(ROOT + 'entity/*.java') + glob.glob(ROOT + 'entity/renderer/*.java') \
    + [ROOT + 'item/ProjectileItems.java', ROOT + 'item/JutsuProjectileItems.java', ROOT + 'potion/ModEffects.java'] + glob.glob(ROOT + 'particle/*.java')
REGISTRY = [ROOT + 'client/ModClient.java']   # registration lines, removable with the class they register

units = {}      # name -> (file, start, end)
def strip_imports(t):
    # an import of a nested class still counts (code uses its short name); imports of the member classes themselves don't
    return re.sub(r'^import [\w.]*\.(?:\w*Procedures|\w*Entities|\w*Renderers|\w*Items|ModEffects|\w*Particle)\.\w+;$', '', t, flags=re.M)
for f in CANDIDATE_FILES:
    t = open(f).read()
    for m in re.finditer(r'\n\t(?:@[\w.]+(?:\([^)]*\))?\s*)*public static class (\w+)', t):
        end = find_block(t, m.end())
        units[m.group(1)] = (f, m.start(), end)
names = set(units)
# nested classes (a renderer's model, an entity's CustomEntity) stand for the member class around them
alias = {n: n for n in names}
for n, (f, s0, e0) in units.items():
    for inner in re.findall(r'\bclass (\w+)', open(f).read()[s0:e0]):
        if inner not in names and inner not in ('CustomEntity', 'ItemCustom', 'ArrowCustomEntity', 'GlobalTrigger', 'EntityAttributesRegisterHandler'):
            alias.setdefault(inner, n)
tok = re.compile(r'\b[A-Z]\w+\b')
def refs(text):
    return {alias[w] for w in tok.findall(text) if w in alias}

root_refs = set()
for f in glob.glob(ROOT + '**/*.java', recursive=True):
    t = open(f).read()
    if f in REGISTRY:
        continue
    if f in CANDIDATE_FILES:
        # the parts outside the member classes (headers, file-level code)
        spans = sorted((s, e) for (ff, s, e) in units.values() if ff == f)
        pos, rest = 0, []
        for s, e in spans:
            rest.append(t[pos:s]); pos = e
        rest.append(t[pos:])
        root_refs |= refs(strip_imports(''.join(rest)))
    else:
        root_refs |= refs(strip_imports(t))

texts = {n: open(u[0]).read()[u[1]:u[2]] for n, u in units.items()}
live = set()
todo = []
def mark(n):
    if n not in live:
        live.add(n); todo.append(n)
for n in root_refs: mark(n)
for n, t in texts.items():
    # event listeners, and things players can get (spawn eggs)
    if re.search(r'@SubscribeEvent\s+public static', t) or 'spawn_egg' in t or 'SpawnEgg' in t:
        mark(n)
renderers = {n for n in names if '/entity/renderer/' in units[n][0]}
def spread():
    while todo:
        n = todo.pop()
        # live code may use a renderer's model directly (Susanoo, model swaps); an entity keeps its renderer (below)
        for r in refs(texts[n]) - {n}:
            mark(r)
while True:
    spread()
    # a renderer lives while what it draws lives: a live member class, or an entity or arrow of a class outside them (an item's)
    more = [n for n in renderers - live if refs(texts[n]) & (live - renderers)
            or any(owner not in names for owner in re.findall(r'\b(\w+)\.(?:entity|arrow)\b', texts[n]))]
    if not more:
        break
    for n in more:
        mark(n)
dead = sorted(names - live)
by_file = collections.defaultdict(list)
for n in dead: by_file[os.path.relpath(units[n][0], ROOT)].append(n)
total = 0
for f, ns in sorted(by_file.items()):
    lines = sum(texts[n].count('\n') for n in ns)
    total += lines
    print(f, len(ns), 'classes', lines, 'lines')
print('dead', len(dead), 'of', len(names), 'lines', total)
if len(sys.argv) > 1:
    # the list only grows: once removed, a class is not in the sources to be found again
    old = set(open(sys.argv[1]).read().split()) if os.path.exists(sys.argv[1]) else set()
    open(sys.argv[1], 'w').write('\n'.join(sorted(old | set(dead))) + '\n')
