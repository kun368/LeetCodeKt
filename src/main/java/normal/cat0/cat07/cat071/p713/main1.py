from typing import *


class Solution:
    def numSubarrayProductLessThanK(self, nums: List[int], k: int) -> int:
        N = len(nums)
        pre_v = [-1] * N
        for i in range(1, N):
            pre_v[i] = (i - 1) if nums[i - 1] > 1 else pre_v[i - 1]

        ans = 0
        for i in range(N):
            mul = nums[i]
            left = i
            while left >= 0 and mul < k:
                left = pre_v[left]
                mul *= nums[left]
            ans += i - left
        return ans


if __name__ == '__main__':
    print(Solution().numSubarrayProductLessThanK(nums=[10, 5, 2, 6], k=100))
    print(Solution().numSubarrayProductLessThanK(nums=[1, 2, 3], k=0))
