from utils.python.predef import *


class Solution:
    def minMovesToCaptureTheQueen(self, a: int, b: int, c: int, d: int, e: int, f: int) -> int:
        ans = 2
        for dx, dy in [(-1, 0), (1, 0), (0, 1), (0, -1)]:
            xx, yy = a, b
            while 1 <= xx <= 8 and 1 <= yy <= 8:
                if xx == e and yy == f:
                    ans = min(ans, 1)
                if xx == c and yy == d:
                    break
                xx, yy = xx + dx, yy + dy

        for dx, dy in [(-1, -1), (1, 1), (-1, 1), (1, -1)]:
            xx, yy = c, d
            while 1 <= xx <= 8 and 1 <= yy <= 8:
                if xx == e and yy == f:
                    ans = min(ans, 1)
                if xx == a and yy == b:
                    break
                xx, yy = xx + dx, yy + dy
        return ans
