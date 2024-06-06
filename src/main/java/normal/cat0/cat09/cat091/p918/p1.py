from utils.python.predef import *


class Solution:
    def fuck(self, nums: List[int]) -> int:
        s, ans = 0, -inf
        for i in range(len(nums)):
            s = max(s, 0) + nums[i]
            ans = max(ans, s)
        return ans

    def maxSubarraySumCircular(self, nums: List[int]) -> int:
        ans = self.fuck(nums)
        if len(nums) >= 3:
            ans = max(ans, sum(nums) + self.fuck([-nums[i] for i in range(1, len(nums) - 1)]))
        return ans


if __name__ == '__main__':
    print(Solution().maxSubarraySumCircular(nums=[1, -2, 3, -2]))
    print(Solution().maxSubarraySumCircular(nums=[5, -3, 5]))
    print(Solution().maxSubarraySumCircular(nums=[3, -2, 2, -3]))
