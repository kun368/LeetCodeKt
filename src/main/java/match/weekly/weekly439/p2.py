from utils.python.predef import *


def diff(x, y):
    x = ord(x) - ord('a')
    y = ord(y) - ord('a')
    return min((x - y) % 26, (y - x) % 26)


class Solution:
    def longestPalindromicSubsequence(self, s: str, k: int) -> int:
        n = len(s)
        dp = []
        for i in range(k + 1):
            dp.append([[0] * n for _ in range(n)])
        for kk in range(k + 1):
            for i in range(n - 1, -1, -1):
                dp[kk][i][i] = 1
                for j in range(i + 1, n):
                    if s[i] == s[j]:
                        dp[kk][i][j] = dp[kk][i + 1][j - 1] + 2
                        continue
                    if (df := diff(s[i], s[j])) <= kk:
                        dp[kk][i][j] = max(dp[kk][i][j], dp[kk - df][i + 1][j - 1] + 2)
                    dp[kk][i][j] = max(dp[kk][i][j], dp[kk][i + 1][j], dp[kk][i][j - 1])
        return dp[k][0][n - 1]


if __name__ == '__main__':
    # ic(diff('a', 'b'))
    # ic(diff('b', 'a'))
    # ic(diff('a', 'z'))
    print(Solution().longestPalindromicSubsequence(s="abced", k=2))
    print(Solution().longestPalindromicSubsequence(s="aaazzz", k=4))
