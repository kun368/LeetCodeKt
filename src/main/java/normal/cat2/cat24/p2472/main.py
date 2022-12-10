from utils.python.predef import *


class Solution:
    def check(self, s):
        i, j = 0, len(s) - 1
        while i < j:
            if s[i] != s[j]:
                return False
            i, j = i + 1, j - 1
        return True

    def maxPalindromes(self, s: str, k: int) -> int:
        ans = 0
        i = 0
        while i < len(s):
            if i + k <= len(s) and self.check(s[i:i + k]):
                ans += 1
                i += k
            elif i + k + 1 <= len(s) and self.check(s[i:i + k + 1]):
                ans += 1
                i += k + 1
            else:
                i += 1
        return ans


if __name__ == '__main__':
    print(Solution().maxPalindromes(s="abaccdbbd", k=3))
    print(Solution().maxPalindromes(s="adbcda", k=2))
