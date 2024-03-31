from utils.python.predef import *


class Solution:
    def maximumLengthSubstring(self, s: str) -> int:
        ans = 0
        for i in range(len(s)):
            for j in range(i + 1, len(s) + 1):
                if max(Counter(s[i:j]).values()) <= 2:
                    ans = max(ans, j - i)
        return ans