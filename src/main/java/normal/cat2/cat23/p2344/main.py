from utils.python.predef import *


class Solution:
    def minOperations(self, nums: List[int], numsDivide: List[int]) -> int:
        g = gcd(*numsDivide)
        return next(iter(i for i, v in enumerate(sorted(nums)) if g % v == 0), -1)


if __name__ == '__main__':
    print(Solution().minOperations(nums=[2, 3, 2, 4, 3], numsDivide=[9, 6, 9, 3, 15]))
    print(Solution().minOperations(nums=[4, 3, 6], numsDivide=[8, 2, 6, 10]))
