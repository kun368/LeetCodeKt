from utils.python.predef import *


class Solution:
    def maxScore(self, a: List[int], b: List[int]) -> int:
        n = len(b)
        dp = [[-(1 << 30)] * 5 for _ in range(n + 1)]
        for i in range(n + 1):
            dp[i][0] = 0

        for i in range(1, n + 1):
            for j in range(1, 5):
                dp[i][j] = dp[i - 1][j]
                if i >= j:
                    dp[i][j] = max(dp[i][j], dp[i - 1][j - 1] + a[j - 1] * b[i - 1])

        return dp[n][4]


if __name__ == '__main__':
    print(Solution().maxScore(a=[3, 2, 5, 6], b=[2, -6, 4, -5, -3, 2, -7]))
    print(Solution().maxScore(a=[-1, 4, 5, -2], b=[-5, -1, -3, -2, -4]))
