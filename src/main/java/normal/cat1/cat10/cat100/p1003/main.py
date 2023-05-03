from utils.python.predef import *


class Solution:
    def isValid(self, s: str) -> bool:
        while (n := s.replace('abc', '')) != s:
            s = n
        return len(s) == 0


if __name__ == '__main__':
    print(Solution().isValid(s="aabcbc"))
    print(Solution().isValid(s="abcabcababcc"))
    print(Solution().isValid(s="abccba"))
