from utils.python.predef import *


class Solution:
    def new21Game(self, n: int, k: int, maxPts: int) -> float:
        dp = [0] * (n + maxPts)
        for i in range(k, n + 1):
            dp[i] = 1
        acc = sum(dp[k: k + maxPts])
        for i in range(k - 1, -1, -1):
            dp[i] = acc / maxPts
            acc = acc + dp[i] - dp[i + maxPts]
        return dp[0]


if __name__ == '__main__':
    print(Solution().new21Game(n=10, k=1, maxPts=10))
    print(Solution().new21Game(n=6, k=1, maxPts=10))
    print(Solution().new21Game(n=21, k=17, maxPts=10))
    print(Solution().new21Game(n=5710, k=5070, maxPts=8516))
    print(Solution().new21Game(n=1, k=0, maxPts=1))
