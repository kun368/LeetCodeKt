from utils.python.predef import *


class Solution:
    def specialArray(self, nums: List[int]) -> int:
        nums.sort()
        N = len(nums)
        for i in range(N + 1):
            pos = N - i
            if (pos == N or nums[pos] >= i) and (pos == 0 or nums[pos - 1] < i):
                return i
        return -1


if __name__ == '__main__':
    print(Solution().specialArray(nums=[3, 5]))
    print(Solution().specialArray(nums=[0, 0]))
    print(Solution().specialArray(nums=[0, 4, 3, 0, 4]))
    print(Solution().specialArray(nums=[3, 6, 7, 7, 0]))
