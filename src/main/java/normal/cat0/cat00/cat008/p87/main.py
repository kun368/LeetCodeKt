from utils.python.predef import *

class Solution:
    def isScramble(self, s1: str, s2: str) -> bool:
        @cache
        def dfs(x, y, cur):
            tar = s2[x:y]
            if tar == cur:
                return True
            if sorted(tar) != sorted(cur):
                return False
            ret = False
            for i in range(x + 1, y):
                ret |= dfs(x, i, cur[:i-x]) and dfs(i, y, cur[i-x:])
                ret |= dfs(y-(i-x), y, cur[:i-x]) and dfs(x, y-(i-x), cur[i-x:])
            return ret
        return dfs(0, len(s1), s1)


if __name__ == '__main__':
    print(Solution().isScramble(s1 = "great", s2 = "rgeat"))
    print(Solution().isScramble(s1 = "abcde", s2 = "caebd"))
    print(Solution().isScramble(s1 = "a", s2 = "a"))
