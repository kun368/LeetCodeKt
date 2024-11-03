from utils.python.predef import *


class Solution:
    def isBalanced(self, num: str) -> bool:
        s1, s2 = 0, 0
        for idx, v in enumerate(num):
            if idx % 2 == 0:
                s1 += int(v)
            else:
                s2 += int(v)
        return s1 == s2


if __name__ == '__main__':
    print(Solution().isBalanced(num="1234"))
    print(Solution().isBalanced(num="24123"))
