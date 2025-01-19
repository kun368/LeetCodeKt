from utils.python.predef import *


class Solution:
    def subarraySum(self, nums: List[int]) -> int:
        ans = 0
        for i, v in enumerate(nums):
            start = max(0, i - nums[i])
            ans += sum(nums[start:i + 1])
        return ans


if __name__ == '__main__':
    print(Solution().subarraySum(nums=[2, 3, 1]))
    print(Solution().subarraySum(nums=[3, 1, 1, 2]))
