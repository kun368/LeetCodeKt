from utils.python.predef import *


class Solution:
    def findMaximumNumber(self, k: int, x: int) -> int:
        def check(n: int) -> bool:
            ans = 0
            for i in range(1, 100):
                if i % x != 0:
                    continue
                span = pow(2, i)
                a, b = (n + 1) // span, (n + 1) % span
                add = a * (span // 2) + max(0, b - span // 2)
                ans += add
            # print(n, ans)
            return ans > k

        idx = bisect_left(range(1 << 60), 1, key=check)
        return idx - 1


if __name__ == '__main__':
    print(Solution().findMaximumNumber(k=9, x=1))
    print(Solution().findMaximumNumber(k=7, x=2))
    print(Solution().findMaximumNumber(k=1e18, x=8))
