from utils.python.predef import *


class Solution:
    def numDistinct(self, s: str, t: str) -> int:
        dp = [[0] * (len(t) + 10) for _ in range(len(s) + 10)]
        for i, iv in enumerate(s):
            for j, jv in enumerate(t):
                if j > i:
                    continue
                dp[i][j] = dp[i-1][j]
                if iv == jv:
                    dp[i][j] += 1 if j == 0 else dp[i-1][j-1]
        return dp[len(s)-1][len(t)-1]


if __name__ == '__main__':
    print(Solution().numDistinct(s="rabbbit", t="rabbit"))  # 3
    print(Solution().numDistinct(s="babgbag", t="bag"))  # 5
    print(Solution().numDistinct(s="aab", t="abb"))  # 0
    print(Solution().numDistinct(s="aabb", t="abb"))  # 2
