"""Tiny PNG writer and pixel canvas for the hand-drawn textures (no PIL needed)."""
import struct
import zlib


class Canvas:
    def __init__(self, w, h):
        self.w, self.h = w, h
        self.px = [[(0, 0, 0, 0)] * w for _ in range(h)]

    def set(self, x, y, c):
        if 0 <= x < self.w and 0 <= y < self.h:
            self.px[y][x] = c if len(c) == 4 else (*c, 255)

    def rect(self, x0, y0, x1, y1, c, noise=0):
        """Fill [x0,x1) x [y0,y1), optionally with vanilla-like per-pixel shading noise."""
        for y in range(y0, y1):
            for x in range(x0, x1):
                if noise:
                    n = ((x * 7349 + y * 5381) ^ (x * y * 131)) % (2 * noise + 1) - noise
                    self.set(x, y, tuple(max(0, min(255, v + n)) for v in c[:3]))
                else:
                    self.set(x, y, c)

    def save(self, path):
        raw = b''.join(b'\x00' + b''.join(struct.pack('4B', *p) for p in row) for row in self.px)

        def chunk(t, d):
            return struct.pack('>I', len(d)) + t + d + struct.pack('>I', zlib.crc32(t + d) & 0xffffffff)
        with open(path, 'wb') as f:
            f.write(b'\x89PNG\r\n\x1a\n' + chunk(b'IHDR', struct.pack('>IIBBBBB', self.w, self.h, 8, 6, 0, 0, 0))
                    + chunk(b'IDAT', zlib.compress(raw, 9)) + chunk(b'IEND', b''))
