from utils.python.predef import *


class Solution:
    def maximumLength(self, nums: List[int]) -> int:
        cnt0, cnt1 = 0, 0
        ha = 0
        for idx, v in enumerate(nums):
            if v % 2 == 0:
                cnt0 += 1
            else:
                cnt1 += 1

            if idx == 0:
                ha = 1
            elif nums[idx] % 2 != nums[idx - 1] % 2:
                ha += 1
        return max(ha, cnt1, cnt0)


if __name__ == '__main__':
    print(Solution().maximumLength(nums=[1, 2, 3, 4]))
    print(Solution().maximumLength(nums=[1, 2, 1, 1, 2, 1, 2]))
    print(Solution().maximumLength(nums=[1, 3]))
    print(Solution().maximumLength(nums=[2, 39, 23]))
