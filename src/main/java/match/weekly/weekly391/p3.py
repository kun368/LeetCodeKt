from utils.python.predef import *


class Solution:
    def countAlternatingSubarrays(self, nums: List[int]) -> int:
        st = 0
        ans = 1
        for i in range(1, len(nums)):
            if nums[i] == nums[i - 1]:
                st = i
            ans += i - st + 1
        return ans