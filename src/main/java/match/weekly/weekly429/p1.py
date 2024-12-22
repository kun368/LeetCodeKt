from utils.python.predef import *


class Solution:
    def minimumOperations(self, nums: List[int]) -> int:
        for i in range(0, len(nums) + 10, 3):
            if len(nums[i:]) == len(set(nums[i:])):
                return i // 3


if __name__ == '__main__':
    print(Solution().minimumOperations(nums=[1, 2, 3, 4, 2, 3, 3, 5, 7]))
    print(Solution().minimumOperations(nums=[4, 5, 6, 4, 4]))
    print(Solution().minimumOperations(nums=[6, 7, 8, 9]))
