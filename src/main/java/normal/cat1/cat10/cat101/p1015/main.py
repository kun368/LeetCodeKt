from utils.python.predef import *


class Solution:
    def smallestRepunitDivByK(self, k: int) -> int:
        if k % 2 == 0 or k % 5 == 0:
            return -1
        rem = 0
        ans = 0
        while True:
            ans += 1
            rem = (rem * 10 + 1) % k
            if rem == 0:
                return ans


if __name__ == '__main__':
    print(Solution().smallestRepunitDivByK(k=1))
    print(Solution().smallestRepunitDivByK(k=2))
    print(Solution().smallestRepunitDivByK(k=3))
    print(Solution().smallestRepunitDivByK(k=6))
    print(Solution().smallestRepunitDivByK(k=7))
