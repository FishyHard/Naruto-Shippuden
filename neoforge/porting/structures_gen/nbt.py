"""A small NBT reader and writer (gzip, big-endian), enough for structure templates and level.dat.

Values: dict = compound, list = list, str = string, and the typed wrappers below for numbers and arrays
(a plain int is written as Int, a plain float as Double)."""
import gzip, struct, io


class Byte(int): pass
class Short(int): pass
class Long(int): pass
class Float(float): pass
class ByteArray(list): pass
class IntArray(list): pass
class LongArray(list): pass


def _tag(v):
    if isinstance(v, bool) or isinstance(v, Byte): return 1
    if isinstance(v, Short): return 2
    if isinstance(v, Long): return 4
    if isinstance(v, int): return 3
    if isinstance(v, Float): return 5
    if isinstance(v, float): return 6
    if isinstance(v, ByteArray): return 7
    if isinstance(v, str): return 8
    if isinstance(v, IntArray): return 11
    if isinstance(v, LongArray): return 12
    if isinstance(v, list): return 9
    if isinstance(v, dict): return 10
    raise TypeError(type(v))


def _str(out, s):
    b = s.encode('utf-8')
    out.write(struct.pack('>H', len(b))); out.write(b)


def _write(out, t, v):
    if t == 1: out.write(struct.pack('>b', int(v)))
    elif t == 2: out.write(struct.pack('>h', v))
    elif t == 3: out.write(struct.pack('>i', v))
    elif t == 4: out.write(struct.pack('>q', v))
    elif t == 5: out.write(struct.pack('>f', v))
    elif t == 6: out.write(struct.pack('>d', v))
    elif t == 7: out.write(struct.pack('>i', len(v))); out.write(bytes((x & 255) for x in v))
    elif t == 8: _str(out, v)
    elif t == 9:
        et = _tag(v[0]) if v else 0
        out.write(struct.pack('>bi', et, len(v)))
        for x in v: _write(out, et, x)
    elif t == 10:
        for k, x in v.items():
            xt = _tag(x); out.write(struct.pack('>b', xt)); _str(out, k); _write(out, xt, x)
        out.write(b'\0')
    elif t == 11: out.write(struct.pack('>i', len(v))); out.write(struct.pack('>%di' % len(v), *v))
    elif t == 12: out.write(struct.pack('>i', len(v))); out.write(struct.pack('>%dq' % len(v), *v))


def write(path, root):
    out = io.BytesIO()
    out.write(b'\x0a'); _str(out, ''); _write(out, 10, root)
    with gzip.open(path, 'wb') as f: f.write(out.getvalue())


def _rstr(f):
    n, = struct.unpack('>H', f.read(2)); return f.read(n).decode('utf-8')


def _read(f, t):
    if t == 1: return Byte(struct.unpack('>b', f.read(1))[0])
    if t == 2: return Short(struct.unpack('>h', f.read(2))[0])
    if t == 3: return struct.unpack('>i', f.read(4))[0]
    if t == 4: return Long(struct.unpack('>q', f.read(8))[0])
    if t == 5: return Float(struct.unpack('>f', f.read(4))[0])
    if t == 6: return struct.unpack('>d', f.read(8))[0]
    if t == 7: n, = struct.unpack('>i', f.read(4)); return ByteArray(struct.unpack('>%db' % n, f.read(n)))
    if t == 8: return _rstr(f)
    if t == 9:
        et, n = struct.unpack('>bi', f.read(5)); return [_read(f, et) for _ in range(n)]
    if t == 10:
        d = {}
        while True:
            xt = f.read(1)[0]
            if xt == 0: return d
            k = _rstr(f); d[k] = _read(f, xt)
    if t == 11: n, = struct.unpack('>i', f.read(4)); return IntArray(struct.unpack('>%di' % n, f.read(4 * n)))
    if t == 12: n, = struct.unpack('>i', f.read(4)); return LongArray(struct.unpack('>%dq' % n, f.read(8 * n)))
    raise ValueError(t)


def read(path):
    with gzip.open(path, 'rb') as f:
        data = io.BytesIO(f.read())
    assert data.read(1) == b'\x0a'; _rstr(data)
    return _read(data, 10)
