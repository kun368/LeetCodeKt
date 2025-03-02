from utils.python.predef import *


class Solution:
    def largestInteger(self, nums: List[int], k: int) -> int:
        dig = sorted(list(set(nums)), reverse=True)
        for i in dig:
            cnt = 0
            for st in range(0, len(nums) - k + 1):
                if i in nums[st:st + k]:
                    cnt += 1
            if cnt == 1:
                return i
        return -1


if __name__ == '__main__':
    print(Solution().largestInteger(nums=[3, 9, 2, 1, 7], k=3))
    print(Solution().largestInteger(nums=[3, 9, 7, 2, 1, 7], k=4))
    print(Solution().largestInteger(nums=[0, 0], k=1))
