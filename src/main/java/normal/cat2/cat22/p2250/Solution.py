from bisect import *
from collections import *
from typing import *


class Solution:
    def countRectangles(self, rectangles: List[List[int]], points: List[List[int]]) -> List[int]:
        rh = defaultdict(list)
        for x, y in rectangles:
            rh[y].append(x)
        for i in rh.values():
            i.sort()

        ret = []
        for x, y in points:
            ans = 0
            for h, ids in rh.items():
                if h < y:
                    continue
                ans += len(ids) - bisect_left(ids, x)
            ret.append(ans)
        return ret


if __name__ == '__main__':
    print(Solution().countRectangles(
        [[1, 2], [2, 3], [2, 5]],
        [[2, 1], [1, 4]]
    ))
    print(Solution().countRectangles(
        [[1, 1], [2, 2], [3, 3]],
        [[1, 3], [1, 1]]
    ))
