from utils.python.predef import *


class Solution:
    def maximizeGreatness(self, nums: List[int]) -> int:
        nums.sort()

        n = len(nums)
        j = 0
        cnt = 0
        for i in range(n):
            while j < n and nums[j] <= nums[i]:
                j += 1
            if j == n:
                break
            cnt += 1
            j += 1
        return cnt


if __name__ == '__main__':
    print(Solution().maximizeGreatness(nums=[1, 3, 5, 2, 1, 3, 1]))
    print(Solution().maximizeGreatness(nums=[1, 2, 3, 4]))
