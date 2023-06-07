from utils.python.predef import *


class Solution:
    @cache
    def integerBreak(self, n: int) -> int:
        if n == 1:
            return 1
        ans = 0
        for i in range(1, n):
            ans = max(ans, i * max(n - i, self.integerBreak(n - i)))
        return ans


if __name__ == '__main__':
    for i in range(2, 59):
        print(i, Solution().integerBreak(i))
