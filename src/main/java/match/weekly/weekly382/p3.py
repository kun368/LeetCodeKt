from utils.python.predef import *


class Solution:
    def flowerGame(self, n: int, m: int) -> int:
        ans = 0
        for i in range(1, n + 1):
            if i % 2 == 1:
                ans += m // 2
            else:
                ans += (m + 1) // 2
        return ans


if __name__ == '__main__':
    print(Solution().flowerGame(n=3, m=2))
    print(Solution().flowerGame(n=1, m=1))
