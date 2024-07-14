from utils.python.predef import *


class Solution:
    def minimumCost(self, m: int, n: int, horizontalCut: List[int], verticalCut: List[int]) -> int:
        horizontalCut.sort()
        verticalCut.sort()
        hh, vv = 1, 1
        ans = 0
        while len(horizontalCut) + len(verticalCut) > 0:
            if len(verticalCut) == 0 or (len(horizontalCut) > 0 and horizontalCut[-1] > verticalCut[-1]):
                ans += horizontalCut.pop() * hh
                vv += 1
            else:
                ans += verticalCut.pop() * vv
                hh += 1
        return ans


if __name__ == '__main__':
    print(Solution().minimumCost(m=3, n=2, horizontalCut=[1, 3], verticalCut=[5]))
    print(Solution().minimumCost(m=2, n=2, horizontalCut=[7], verticalCut=[4]))
