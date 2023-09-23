from utils.python.predef import *


class Solution:
    def countWays(self, nums: List[int]) -> int:
        nums.sort()
        ans = 0
        if nums[0] > 0:
            ans += 1
        for i in range(len(nums)):
            if i + 1 == len(nums):
                if nums[i] < i + 1:
                    ans += 1
            else:
                if nums[i] < i + 1 < nums[i + 1]:
                    ans += 1
        return ans


if __name__ == '__main__':
    print(Solution().countWays(nums=[1, 1]))
    print(Solution().countWays(nums=[6, 0, 3, 3, 6, 7, 2, 7]))
