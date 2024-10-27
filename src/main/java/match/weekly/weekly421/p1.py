from utils.python.predef import *


class Solution:
    def maxScore(self, nums: List[int]) -> int:
        n = len(nums)
        if n == 0:
            return 0
        if n == 1:
            return nums[0] * nums[0]
        max_score = gcd(*nums) * lcm(*nums)
        for i in range(n):
            remaining = nums[:i] + nums[i + 1:]
            current_gcd = gcd(*remaining)
            current_lcm = lcm(*remaining)
            max_score = max(max_score, current_gcd * current_lcm)
        return max_score


if __name__ == '__main__':
    print(Solution().maxScore(nums=[2, 4, 8, 16]))
    print(Solution().maxScore(nums=[1, 2, 3, 4, 5]))
    print(Solution().maxScore(nums=[3]))
    print(Solution().maxScore(nums=[6, 14, 20]))  # 840
