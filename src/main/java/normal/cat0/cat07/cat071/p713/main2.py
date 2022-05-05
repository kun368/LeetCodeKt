from typing import *


class Solution:
    def numSubarrayProductLessThanK(self, nums: List[int], k: int) -> int:
        if k <= 1:
            return 0
        tot, left = 1, 0
        ans = 0
        for i in range(len(nums)):
            tot *= nums[i]
            while tot >= k and left <= i:
                tot //= nums[left]
                left += 1
            ans += i - left + 1
        return ans


if __name__ == '__main__':
    print(Solution().numSubarrayProductLessThanK(nums=[10, 5, 2, 6], k=100))
    print(Solution().numSubarrayProductLessThanK(nums=[1, 2, 3], k=0))
    print(Solution().numSubarrayProductLessThanK(nums=[1, 1, 1], k=1))
