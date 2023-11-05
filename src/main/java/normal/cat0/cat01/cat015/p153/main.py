from utils.python.predef import *


class Solution:
    def findMin(self, nums: List[int]) -> int:
        if nums[0] < nums[-1]:
            return nums[0]

        l, r, ok = 0, len(nums), len(nums)
        while l < r:
            mid = (l + r) // 2
            if nums[mid] <= nums[-1]:
                ok = mid
                r = mid
            else:
                l = mid + 1
        return nums[ok]


if __name__ == '__main__':
    print(Solution().findMin(nums=[3, 4, 5, 1, 2]))
    print(Solution().findMin(nums=[4, 5, 6, 7, 0, 1, 2]))
    print(Solution().findMin(nums=[11, 13, 15, 17]))
