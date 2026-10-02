"""Brings Blockbench models exported for 1.15-1.16 (MCP mappings: ModelRenderer, setRotationPoint, setTextureOffset().addBox,
addChild, setRotationAngle) into 26.3 as LayerDefinitions, for armour drawn on the humanoid model: the model's root part
becomes the humanoid part it was worn as ("head" for a helmet, "body" for a chestplate), everything under it its children.

    python3 models_import.py <Model.java> <root part> <humanoid part> <method name> [more models...] > out.java

writes a class of static methods returning the LayerDefinitions (one helper method per branch of the root, so a model of
hundreds of cubes stays under Java's method size limit)."""
import re
import sys

NUM = r'(-?[\d.]+)F?'


def parse(path):
    src = open(path, encoding='utf-8').read()
    tw = int(re.search(r'textureWidth\s*=\s*(\d+)', src).group(1))
    th = int(re.search(r'textureHeight\s*=\s*(\d+)', src).group(1))
    parts, order = {}, []

    def part(name):
        if name not in parts:
            parts[name] = {'pivot': (0, 0, 0), 'rot': (0, 0, 0), 'boxes': [], 'children': [], 'parent': None}
            order.append(name)
        return parts[name]
    for line in src.splitlines():
        line = line.strip()
        m = re.match(r'(\w+) = new ModelRenderer\(this\);', line)
        if m:
            part(m.group(1))
            continue
        m = re.match(r'(\w+)\.setRotationPoint\(%s, %s, %s\);' % (NUM, NUM, NUM), line)
        if m:
            part(m.group(1))['pivot'] = tuple(float(m.group(i)) for i in (2, 3, 4))
            continue
        m = re.match(r'setRotationAngle\((\w+), %s, %s, %s\);' % (NUM, NUM, NUM), line)
        if m:
            part(m.group(1))['rot'] = tuple(float(m.group(i)) for i in (2, 3, 4))
            continue
        m = re.match(r'(\w+)\.addChild\((\w+)\);', line)
        if m:
            part(m.group(1))['children'].append(m.group(2))
            part(m.group(2))['parent'] = m.group(1)
            continue
        m = re.match(r'(\w+)\.setTextureOffset\((\d+), (\d+)\)\.addBox\(%s, %s, %s, %s, %s, %s, %s, (true|false)\);'
                     % (NUM, NUM, NUM, NUM, NUM, NUM, NUM), line)
        if m:
            g = m.groups()
            part(g[0])['boxes'].append((int(g[1]), int(g[2]), [float(v) for v in g[3:9]], float(g[9]), g[10] == 'true'))
    return tw, th, parts, order


def f(v):
    s = ('%.4f' % v).rstrip('0').rstrip('.')
    return (s if s not in ('-0', '') else '0') + 'F'


def cubes(p):
    out = 'CubeListBuilder.create()'
    mirror = False
    for (u, v, (x, y, z, w, h, d), inflate, mir) in p['boxes']:
        if mir != mirror:
            out += '.mirror(%s)' % ('true' if mir else 'false')
            mirror = mir
        out += '\n\t\t\t\t.texOffs(%d, %d).addBox(%s, %s, %s, %s, %s, %s, new CubeDeformation(%s))' % (u, v, f(x), f(y), f(z), f(w), f(h), f(d), f(inflate))
    return out


def pose(p):
    (x, y, z), (a, b, c) = p['pivot'], p['rot']
    if a == b == c == 0:
        return 'PartPose.offset(%s, %s, %s)' % (f(x), f(y), f(z))
    return 'PartPose.offsetAndRotation(%s, %s, %s, %s, %s, %s)' % (f(x), f(y), f(z), f(a), f(b), f(c))


def emit(path, root, humanoid, method):
    tw, th, parts, order = parse(path)
    helpers = []

    def part_method(name):
        """A method adding this part to its parent, then its children (each part with children has its own method, so
        none grows past Java's limit)."""
        p = parts[name]
        mname = '%s_%s' % (method, name.lower())
        body = ['\t\tPartDefinition self = parent.addOrReplaceChild("%s", %s, %s);' % (name.lower(), cubes(p), pose(p))]
        for c in p['children']:
            if parts[c]['children']:
                body.append('\t\t%s(self);' % part_method(c))
            else:
                body.append('\t\tself.addOrReplaceChild("%s", %s, %s);' % (c.lower(), cubes(parts[c]), pose(parts[c])))
        helpers.append('\tprivate static void %s(PartDefinition parent) {\n%s\n\t}\n' % (mname, '\n'.join(body)))
        return mname
    r = parts[root]
    # the root takes the humanoid part's place: its pivot is the part's (only x and z: the y is the part's own), and its
    # rotation is the wearer's, so neither is kept
    lines = ['\t\tPartDefinition top = emptied(mesh).addOrReplaceChild("%s", %s, PartPose.offset(%s, 0, %s));'
             % (humanoid, cubes(r), f(r['pivot'][0]), f(r['pivot'][2]))]
    if humanoid == 'head':
        lines.append('\t\ttop.addOrReplaceChild("hat", CubeListBuilder.create(), PartPose.ZERO);')
    for c in r['children']:
        if parts[c]['children']:
            lines.append('\t\t%s(top);' % part_method(c))
        else:
            lines.append('\t\ttop.addOrReplaceChild("%s", %s, %s);' % (c.lower(), cubes(parts[c]), pose(parts[c])))
    lines.append('\t\treturn LayerDefinition.create(mesh, %d, %d);' % (tw, th))
    body = '\tpublic static LayerDefinition %s() {\n\t\tMeshDefinition mesh = HumanoidModel.createMesh(CubeDeformation.NONE, 0.0F);\n%s\n\t}\n' % (method, '\n'.join(lines))
    return body + '\n' + '\n'.join(reversed(helpers))


if __name__ == '__main__':
    args = sys.argv[1:]
    out = []
    while args:
        path, root, humanoid, method = args[:4]
        args = args[4:]
        out.append(emit(path, root, humanoid, method))
    print('\n'.join(out))
