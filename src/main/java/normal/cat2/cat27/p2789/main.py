from utils.python.predef import *


class Solution:
    def maxArrayValue(self, nums: List[int]) -> int:
        ans = 0
        s = 0
        for i in reversed(range(len(nums))):
            if nums[i] <= s:
                s += nums[i]
            else:
                s = nums[i]
            ans = max(ans, s)
        return ans


if __name__ == '__main__':
    print(Solution().maxArrayValue(nums=[2, 3, 7, 9, 3]))
    print(Solution().maxArrayValue(nums=[5, 3, 3]))
