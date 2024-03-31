from utils.python.predef import *


class Solution:
    def minimumDistance(self, points: List[List[int]]) -> int:
        from sortedcontainers import SortedList
        A, C = SortedList(), SortedList()
        for x, y in points:
            A.add(x + y)
            C.add(x - y)

        ans = 1 << 60
        for x, y in points:
            A.pop(A.bisect_left(x + y))
            C.pop(C.bisect_left(x - y))
            a = A[-1] - A[0]
            c = C[-1] - C[0]
            ans = min(ans, max(a, c))
            A.add(x + y)
            C.add(x - y)
        return ans
