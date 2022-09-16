from utils.python.predef import *


class Solution:
    MOD = int(1e9 + 7)

    def calc_len(self, arr):
        ca, cb = arr[0]
        tot = cb - ca
        for i in range(1, len(arr)):
            a, b = arr[i]
            if a <= cb:
                tot += max(0, b - cb)
                cb = max(b, cb)
            else:
                tot += b - a
                ca, cb = a, b
        return tot

    def rectangleArea(self, rectangles: List[List[int]]) -> int:
        from collections import Counter
        hm = defaultdict(list)
        for x1, y1, x2, y2 in rectangles:
            hm[x1].append((1, y1, y2))
            hm[x2].append((-1, y1, y2))

        ans = 0
        pre_x = None
        cur = Counter()
        for x in sorted(hm.keys()):
            if pre_x is not None and len(cur) > 0:
                cur_sz = (x - pre_x) * self.calc_len(sorted(cur.keys())) % self.MOD
                ans = (ans + cur_sz) % self.MOD
            cur.update({(a, b): tp for tp, a, b in hm[x]})
            cur += Counter()
            pre_x = x
        return ans


if __name__ == '__main__':
    print(Solution().rectangleArea(rectangles=[[0, 0, 2, 2], [1, 0, 2, 3], [1, 0, 3, 1]]))
    print(Solution().rectangleArea(rectangles=[[0, 0, 1000000000, 1000000000]]))
