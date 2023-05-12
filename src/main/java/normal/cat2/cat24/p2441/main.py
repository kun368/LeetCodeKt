from utils.python.predef import *


class Solution:
    def findMaxK(self, nums: List[int]) -> int:
        s = set(nums)
        return max((i for i in nums if i > 0 and -i in s), default=-1)


if __name__ == '__main__':
    print(Solution().findMaxK(nums=[-1, 2, -3, 3]))
    print(Solution().findMaxK(nums=[-1, 10, 6, 7, -7, 1]))
    print(Solution().findMaxK(nums=[-10, 8, 6, 7, -2, -3]))
