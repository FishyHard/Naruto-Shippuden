"""Convert 1.16 Blockbench/MCP entity models (ModelRenderer + texOffs/addBox) to 26.3 LayerDefinitions.

Geometry, pivots, rotations and mirroring are carried over exactly. renderToBuffer translate/scale calls become a
wrapper part with the equivalent pose. setupAnim bodies are kept, with the old parameters mapped from the render state.
"""
import re

NUM = r'(-?\d+(?:\.\d+)?)[FfDd]?'


def find_block(text, start):
    """Index just past the '}' matching the first '{' at/after start."""
    i = text.index('{', start)
    depth = 0
    in_str = None
    while True:
        c = text[i]
        if in_str:
            if c == '\\':
                i += 1
            elif c == in_str:
                in_str = None
        elif c in '"\'':
            in_str = c
        elif c == '{':
            depth += 1
        elif c == '}':
            depth -= 1
            if depth == 0:
                return i + 1
        i += 1


def fnum(s):
    v = float(s)
    return ('%sF' % repr(v)) if v != int(v) else ('%d.0F' % int(v))


class Part:
    def __init__(self, name):
        self.name = name
        self.pos = (0.0, 0.0, 0.0)
        self.rot = (0.0, 0.0, 0.0)
        self.cubes = []  # (u, v, x, y, z, w, h, d, inflate, mirror)
        self.children = []
        self.parent = None
        self.mirror = False


def parse_model(cls_name, body):
    ctor = re.search(r'public ' + cls_name + r'\(\)\s*\{', body)
    ctor_end = find_block(body, ctor.start())
    ctor_body = body[ctor.end():ctor_end - 1]
    tex_w = int(re.search(r'texWidth\s*=\s*(\d+)', ctor_body).group(1))
    tex_h = int(re.search(r'texHeight\s*=\s*(\d+)', ctor_body).group(1))
    parts = {}
    order = []
    for st in re.split(r';', ctor_body):
        st = ' '.join(st.split())
        if not st:
            continue
        m = re.match(r'(\w+) = new ModelPart\(this(?:, \d+, \d+)?\)$', st) or re.match(r'(\w+) = new ModelRenderer\(this(?:, \d+, \d+)?\)$', st)
        if m:
            parts[m[1]] = Part(m[1]); order.append(m[1]); continue
        m = re.match(r'(\w+)\.setPos\(%s, %s, %s\)$' % (NUM, NUM, NUM), st)
        if m:
            parts[m[1]].pos = tuple(float(x) for x in m.groups()[1:]); continue
        m = re.match(r'(\w+)\.addChild\((\w+)\)$', st)
        if m:
            parts[m[1]].children.append(m[2]); parts[m[2]].parent = m[1]; continue
        m = re.match(r'setRotationAngle\((\w+), %s, %s, %s\)$' % (NUM, NUM, NUM), st)
        if m:
            parts[m[1]].rot = tuple(float(x) for x in m.groups()[1:]); continue
        m = re.match(r'(\w+)\.mirror = (true|false)$', st)
        if m:
            parts[m[1]].mirror = m[2] == 'true'; continue
        m = re.match(r'(\w+).texOffs\((-?\d+), (-?\d+)\)\.addBox\(%s, %s, %s, %s, %s, %s, %s(?:, (true|false))?\)$'
                     % (NUM, NUM, NUM, NUM, NUM, NUM, NUM), st)
        if m:
            g = m.groups()
            p = parts[g[0]]
            mirror = p.mirror if g[10] is None else g[10] == 'true'
            p.cubes.append((int(g[1]), int(g[2])) + tuple(float(x) for x in g[3:10]) + (mirror,)); continue
        m = re.match(r'(\w+).texOffs\((-?\d+), (-?\d+)\)\.addBox\(%s, %s, %s, (\d+), (\d+), (\d+)(?:, %s)?(?:, (true|false))?\)$'
                     % (NUM, NUM, NUM, NUM), st)
        if m:
            g = m.groups()
            p = parts[g[0]]
            p.cubes.append((int(g[1]), int(g[2]), float(g[3]), float(g[4]), float(g[5]), float(g[6]), float(g[7]), float(g[8]),
                            float(g[9] or 0), p.mirror if g[10] is None else g[10] == 'true')); continue
        if re.match(r'(texWidth|texHeight) = \d+$', st):
            continue
        raise ValueError('%s: unhandled model statement: %s' % (cls_name, st))
    return parts, order, tex_w, tex_h


def convert_model(cls_name, body, layer_id):
    parts, order, tex_w, tex_h = parse_model(cls_name, body)
    # which top-level parts are drawn, and under which transform
    groups = []  # (offset(x,y,z) in pixels, scale, [parts])
    rtb = re.search(r'public void renderToBuffer\([^)]*\)\s*\{', body)
    off, sc = [0.0, 0.0, 0.0], [1.0, 1.0, 1.0]
    if rtb:
        rtb_body = body[rtb.end():find_block(body, rtb.start()) - 1]
        for st in re.split(r';', rtb_body):
            st = ' '.join(st.split())
            if not st:
                continue
            m = re.match(r'\w+\.translate\(%s, %s, %s\)$' % (NUM, NUM, NUM), st)
            if m:
                t = [float(x) for x in m.groups()]
                off = [off[i] + sc[i] * t[i] * 16 for i in range(3)]; continue
            m = re.match(r'\w+\.scale\(%s, %s, %s\)$' % (NUM, NUM, NUM), st)
            if m:
                s = [float(x) for x in m.groups()]
                sc = [sc[i] * s[i] for i in range(3)]; continue
            m = re.match(r'(\w+)\.render\(', st)
            if m and m[1] in parts:
                key = (tuple(off), tuple(sc))
                if groups and groups[-1][0] == key:
                    groups[-1][1].append(m[1])
                else:
                    groups.append((key, [m[1]]))
                continue
            if re.match(r'\w+\.(pushPose|popPose)\(\)$', st):
                raise ValueError('%s: push/pop in renderToBuffer' % cls_name)
            raise ValueError('%s: unhandled render statement: %s' % (cls_name, st))
    else:
        groups.append((((0.0, 0.0, 0.0), (1.0, 1.0, 1.0)), [p for p in order if parts[p].parent is None]))

    field_names = re.findall(r'private final (?:ModelPart|ModelRenderer) (\w+);', body)
    lines = []
    ind = '\t\t\t'
    lines.append('public static class %s extends EntityModel<EntityRenderState> {' % cls_name)
    lines.append('\tpublic static final ModelLayerLocation LAYER = new ModelLayerLocation('
                 'Identifier.fromNamespaceAndPath("naruto_shippuden", "%s"), "main");' % layer_id)
    for f in field_names:
        lines.append('\tpublic final ModelPart %s;' % f)
    lines.append('')
    lines.append('\tpublic %s(ModelPart root) {' % cls_name)
    lines.append('\t\tsuper(root);')

    def path_to(name):
        chain = []
        n = name
        while n is not None:
            chain.append(n)
            n = parts[n].parent
        chain.reverse()
        return chain

    group_of = {}
    for gi, (key, tops) in enumerate(groups):
        for t in tops:
            group_of[t] = gi
    for f in field_names:
        chain = path_to(f)
        top = chain[0]
        if top in group_of:
            expr = 'root.getChild("transform%d")' % group_of[top]
        else:
            expr = 'root.getChild("unused")'
        for c in chain:
            expr += '.getChild("%s")' % c
        lines.append('\t\tthis.%s = %s;' % (f, expr))
    lines.append('\t}')
    lines.append('')
    lines.append('\tpublic static LayerDefinition createBodyLayer() {')
    lines.append('\t\tMeshDefinition mesh = new MeshDefinition();')
    lines.append('\t\tPartDefinition root = mesh.getRoot();')

    def emit(name, parent_var, var_counter=[0]):
        p = parts[name]
        cubes = 'CubeListBuilder.create()'
        cur_mirror = False
        for (u, v, x, y, z, w, h, d, infl, mir) in p.cubes:
            if mir != cur_mirror:
                cubes += '.mirror(%s)' % ('true' if mir else 'false')
                cur_mirror = mir
            deform = ', new CubeDeformation(%s)' % fnum(infl) if infl else ''
            cubes += '.texOffs(%d, %d).addBox(%s, %s, %s, %s, %s, %s%s)' % (u, v, fnum(x), fnum(y), fnum(z), fnum(w), fnum(h), fnum(d), deform)
        pose = 'PartPose.offsetAndRotation(%s, %s, %s, %s, %s, %s)' % tuple(fnum(v) for v in p.pos + p.rot)
        var_counter[0] += 1
        var = 'p%d' % var_counter[0]
        lines.append('\t\tPartDefinition %s = %s.addOrReplaceChild("%s", %s, %s);' % (var, parent_var, name, cubes, pose))
        for c in p.children:
            emit(c, var)

    drawn = set()
    for gi, ((off3, sc3), tops) in enumerate(groups):
        pose = 'PartPose.offset(%s, %s, %s)' % tuple(fnum(v) for v in off3)
        if sc3 != (1.0, 1.0, 1.0):
            pose += '.scaled(%s, %s, %s)' % tuple(fnum(v) for v in sc3)
        lines.append('\t\tPartDefinition transform%d = root.addOrReplaceChild("transform%d", CubeListBuilder.create(), %s);' % (gi, gi, pose))
        for t in tops:
            emit(t, 'transform%d' % gi)
            drawn.add(t)
    undrawn = [p for p in order if parts[p].parent is None and p not in drawn]
    if undrawn:
        lines.append('\t\tPartDefinition unused = root.addOrReplaceChild("unused", CubeListBuilder.create(), PartPose.ZERO);')
        for t in undrawn:
            emit(t, 'unused')
    lines.append('\t\treturn LayerDefinition.create(mesh, %d, %d);' % (tex_w, tex_h))
    lines.append('\t}')
    if undrawn:
        lines.append('')
        lines.append('\t@Override')
        lines.append('\tpublic void setupAnim(EntityRenderState state) {')
        lines.append('\t\tsuper.setupAnim(state);')
        lines.append('\t\tthis.root().getChild("unused").visible = false;')
        lines.append('\t\tsetupAnimCompat(state);')
        lines.append('\t}')
    sa = re.search(r'public void setupAnim\((\w+) (\w+), float (\w+), float (\w+), float (\w+), float (\w+), float (\w+)\)\s*\{', body)
    if sa:
        sa_body = body[sa.end():find_block(body, sa.start()) - 1]
        e, f, f1, f2, f3, f4 = sa.groups()[1:]
        if not undrawn:
            lines.append('')
            lines.append('\t@Override')
            lines.append('\tpublic void setupAnim(EntityRenderState state) {')
            lines.append('\t\tsuper.setupAnim(state);')
            lines.append('\t\tsetupAnimCompat(state);')
            lines.append('\t}')
        lines.append('')
        lines.append('\tprivate void setupAnimCompat(EntityRenderState state) {')
        lines.append('\t\tfloat %s = 0, %s = 0, %s = state.ageInTicks, %s = 0, %s = 0;' % (f, f1, f2, f3, f4))
        lines.append('\t\tif (state instanceof LivingEntityRenderState living) {')
        lines.append('\t\t\t%s = living.walkAnimationPos;' % f)
        lines.append('\t\t\t%s = living.walkAnimationSpeed;' % f1)
        lines.append('\t\t\t%s = living.yRot;' % f3)
        lines.append('\t\t\t%s = living.xRot;' % f4)
        lines.append('\t\t}')
        if re.search(r'\b%s\b' % e, sa_body):
            raise ValueError('%s: setupAnim uses the entity' % cls_name)
        for l in sa_body.strip('\n').split('\n'):
            lines.append('\t' + l.strip() if l.strip() else '')
        lines.append('\t}')
    elif undrawn:
        lines.append('')
        lines.append('\tprivate void setupAnimCompat(EntityRenderState state) {')
        lines.append('\t}')
    lines.append('}')
    return '\n'.join(lines)


MODEL_DECL = re.compile(r'(?m)^(\t*)(?:// .*\n\1)*public static class (\w+) extends EntityModel<\w+> \{')


def convert_all(text, prefix):
    """Replace every model class in a file. Returns (text, [model names])."""
    out = []
    pos = 0
    names = []
    for m in MODEL_DECL.finditer(text):
        if m.start() < pos:
            continue
        indent, name = m.group(1), m.group(2)
        start = text.index('public static class', m.start())
        end = find_block(text, start)
        layer_id = (prefix + '_' + name).lower()
        new = convert_model(name, text[start:end], layer_id)
        out.append(text[pos:start])
        out.append(new.replace('\n', '\n' + indent))
        pos = end
        names.append(name)
    out.append(text[pos:])
    return ''.join(out), names


def emit_part(parts, name, parent_var, part_name=None, pose_override=None, counter=None):
    """Code lines adding the part (and its children) under parent_var. Returns list of lines."""
    counter = counter if counter is not None else [0]
    lines = []
    p = parts[name]
    cubes = 'CubeListBuilder.create()'
    cur_mirror = False
    for (u, v, x, y, z, w, h, d, infl, mir) in p.cubes:
        if mir != cur_mirror:
            cubes += '.mirror(%s)' % ('true' if mir else 'false')
            cur_mirror = mir
        deform = ', new CubeDeformation(%s)' % fnum(infl) if infl else ''
        cubes += '.texOffs(%d, %d).addBox(%s, %s, %s, %s, %s, %s%s)' % (u, v, fnum(x), fnum(y), fnum(z), fnum(w), fnum(h), fnum(d), deform)
    pose = pose_override or 'PartPose.offsetAndRotation(%s, %s, %s, %s, %s, %s)' % tuple(fnum(v) for v in p.pos + p.rot)
    counter[0] += 1
    var = 'p%d' % counter[0]
    lines.append('PartDefinition %s = %s.addOrReplaceChild("%s", %s, %s);' % (var, parent_var, part_name or name, cubes, pose))
    for c in p.children:
        lines += emit_part(parts, c, var, counter=counter)
    return lines
