from utils.python.predef import *


class Solution:
    def longestSemiRepetitiveSubstring(self, s: str) -> int:
        ans = 1
        for i in range(len(s)):
            t = 0
            for j in range(i + 1, len(s)):
                if s[j] == s[j - 1]:
                    t += 1
                if t >= 2:
                    break
                ans = max(ans, j - i + 1)
        return ans


if __name__ == '__main__':
    print(Solution().longestSemiRepetitiveSubstring(s="52233"))
    print(Solution().longestSemiRepetitiveSubstring(s="5494"))
    print(Solution().longestSemiRepetitiveSubstring(s="1111111"))
