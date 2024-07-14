from utils.python.predef import *


class Solution:
    def getSmallestString(self, s: str) -> str:
        ls = list(s)
        ans = ''.join(ls)
        for i in range(len(ls) - 1):
            if int(ls[i]) % 2 == int(ls[i + 1]) % 2:
                ls[i], ls[i + 1] = ls[i + 1], ls[i]
                ans = min(ans, ''.join(ls))
                ls[i], ls[i + 1] = ls[i + 1], ls[i]
        return ans


if __name__ == '__main__':
    print(Solution().getSmallestString(s="45320"))
    print(Solution().getSmallestString(s="001"))
    print(Solution().getSmallestString(s="10"))
