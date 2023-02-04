from utils.python.predef import *


class Solution:
    def countQuadruplets(self, nums: List[int]) -> int:
        from sortedcontainers import SortedList
        n = len(nums)
        ans = 0
        left = SortedList([nums[0]])
        for j in range(1, n - 2):
            right = 1 if nums[n - 1] > nums[j] else 0
            for k in range(n - 2, j, -1):
                if nums[k] < nums[j]:
                    ans += left.bisect_left(nums[k]) * right
                right += 1 if nums[k] > nums[j] else 0
            left.add(nums[j])
        return ans


if __name__ == '__main__':
    print(Solution().countQuadruplets(nums=[1, 3, 2, 4, 5]))
    print(Solution().countQuadruplets(nums=[1, 2, 3, 4]))
