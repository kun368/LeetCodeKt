from utils.python.predef import *


class Solution:
    def findMin(self, nums: List[int]) -> int:
        while len(nums) >= 2 and nums[-1] == nums[-2]:
            nums.pop()

        l, r, ok = 0, len(nums) - 1, len(nums) - 1
        while l < r:
            mid = (l + r) // 2
            if nums[mid] < nums[-1]:
                ok = mid
                r = mid
            else:
                l = mid + 1
        return nums[ok]


if __name__ == '__main__':
    print(Solution().findMin(nums=[1, 3, 5]))
    print(Solution().findMin(nums=[2, 2, 2, 0, 1]))
