from utils.python.predef import *


class Solution:
    def maximumTotalCost(self, nums: List[int]) -> int:
        @cache
        def dfs(idx):
            if idx < 0:
                return 0
            ans = nums[idx] + dfs(idx - 1)
            if idx >= 1:
                ans = max(ans, -nums[idx] + nums[idx - 1] + dfs(idx - 2))
            return ans

        return dfs(len(nums) - 1)


if __name__ == '__main__':
    print(Solution().maximumTotalCost(nums=[1, -2, 3, 4]))
    print(Solution().maximumTotalCost(nums=[1, -1, 1, -1]))
    print(Solution().maximumTotalCost(nums=[0]))
    print(Solution().maximumTotalCost(nums=[1, -1]))
