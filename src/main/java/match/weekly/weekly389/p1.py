from utils.python.predef import *


class Solution:
    def isSubstringPresent(self, s: str) -> bool:
        reversed_s = s[::-1]
        for i in range(len(s) - 1):
            substr = s[i:i + 2]
            if substr in reversed_s:
                return True
        return False


if __name__ == '__main__':
    print(Solution().isSubstringPresent(s="leetcode"))
    print(Solution().isSubstringPresent(s="abcba"))
    print(Solution().isSubstringPresent(s="abcd"))
