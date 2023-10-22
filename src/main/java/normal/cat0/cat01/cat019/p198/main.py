from utils.python.predef import *


class Solution:
    def rob(self, nums: List[int]) -> int:
        if len(nums) <= 2: return max(nums)
        dp = [nums[0], max(nums[0], nums[1])]
        for i in range(2, len(nums)):
            dp.append(max(nums[i] + dp[i - 2], dp[i - 1]))
        return dp[-1]


if __name__ == '__main__':
    print(Solution().rob([1, 2, 3, 1]))
    print(Solution().rob([2, 7, 9, 3, 1]))
