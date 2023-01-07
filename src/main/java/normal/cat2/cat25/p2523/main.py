from utils.python.predef import *


class Solution:
    def closestPrimes(self, left: int, right: int) -> List[int]:
        sz = right + 5
        isp = [True] * sz
        isp[0] = isp[1] = False
        for i in range(2, int(sqrt(sz)) + 1):
            if not isp[i]: continue
            for j in range(i * i, sz, i):
                isp[j] = False

        pri = [a for a, b in enumerate(isp) if b and left <= a <= right]
        if len(pri) <= 1:
            return [-1, -1]

        min_span = pri[-1] - pri[0]
        ans = pri[:2]
        for i in range(0, len(pri) - 1):
            span = pri[i + 1] - pri[i]
            if span < min_span:
                min_span = span
                ans = [pri[i], pri[i + 1]]
        return ans


if __name__ == '__main__':
    print(Solution().closestPrimes(left=10, right=19))
    print(Solution().closestPrimes(left=4, right=6))
