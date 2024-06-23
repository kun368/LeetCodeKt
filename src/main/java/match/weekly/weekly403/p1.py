from utils.python.predef import *


class Solution:
    def minimumAverage(self, nums: List[int]) -> float:
        from sortedcontainers import SortedList
        a = SortedList(nums)
        ans = inf
        for i in range(len(nums) // 2):
            x = a.pop(0)
            y = a.pop(-1)
            ans = min(ans, (x + y) / 2)
        return ans


if __name__ == '__main__':
    print(Solution().minimumAverage(nums=[7, 8, 3, 4, 15, 13, 4, 1]))
    print(Solution().minimumAverage(nums=[1, 9, 8, 3, 10, 5]))
    print(Solution().minimumAverage(nums=[1, 2, 3, 7, 8, 9]))
