from utils.python.predef import *


class Solution:
    def findMaximumScore(self, nums: List[int]) -> int:
        cur_max = nums[0]
        ans = 0
        for i in range(1, len(nums)):
            ans += cur_max
            cur_max = max(cur_max, nums[i])
        return ans


if __name__ == '__main__':
    print(Solution().findMaximumScore(nums=[1, 3, 1, 5]))
    print(Solution().findMaximumScore(nums=[4, 3, 1, 3, 2]))
    print(Solution().findMaximumScore(nums=[4, 100, 0, 1000, 0, 0]))
