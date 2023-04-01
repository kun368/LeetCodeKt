from utils.python.predef import *


class Solution:
    def findScore(self, nums: List[int]) -> int:
        from sortedcontainers import SortedList
        ls = SortedList()
        for i, v in enumerate(nums):
            ls.add((v, i))
        ans = 0
        while len(ls) > 0:
            v, i = ls.pop(0)
            ans += v
            if i > 0:
                ls.discard((nums[i - 1], i - 1))
            if i < len(nums) - 1:
                ls.discard((nums[i + 1], i + 1))
        return ans


if __name__ == '__main__':
    print(Solution().findScore(nums=[2, 1, 3, 4, 5, 2]))
    print(Solution().findScore(nums=[2, 3, 5, 1, 3, 2]))
