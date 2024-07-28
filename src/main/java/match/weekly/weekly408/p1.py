from utils.python.predef import *


class Solution:
    def canAliceWin(self, nums: List[int]) -> bool:
        ss = sum(nums)
        s1 = 0
        for i in nums:
            if len(str(i)) == 1:
                s1 += i
        s2 = 0
        for i in nums:
            if len(str(i)) == 2:
                s2 += i
        return s1 > ss - s1 or s2 > ss - s2


if __name__ == '__main__':
    print(Solution().canAliceWin(nums=[1, 2, 3, 4, 10]))
    print(Solution().canAliceWin(nums=[1, 2, 3, 4, 5, 14]))
    print(Solution().canAliceWin(nums = [5, 5, 5, 25]))
