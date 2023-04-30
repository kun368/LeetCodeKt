from utils.python.predef import *


class Solution:
    def get_s(self, nums: List[int], curLen: int):
        s = [sum(nums[:curLen])]
        for i in range(curLen, len(nums)):
            s.append(s[-1] + nums[i] - nums[i-curLen])
        return s

    def maxSumTwoNoOverlap(self, nums: List[int], firstLen: int, secondLen: int) -> int:
        s1, s2 = self.get_s(nums, firstLen), self.get_s(nums, secondLen)
        best = 0
        for i in range(len(s1)):
            for j in range(len(s2)):
                if i + firstLen <= j or j + secondLen <= i:
                    best = max(best, s1[i] + s2[j])
        return best


if __name__ == '__main__':
    print(Solution().maxSumTwoNoOverlap(
        nums=[0, 6, 5, 2, 2, 5, 1, 9, 4], firstLen=1, secondLen=2)
    )
    print(Solution().maxSumTwoNoOverlap(
        nums=[3, 8, 1, 3, 2, 1, 8, 9, 0], firstLen=3, secondLen=2)
    )
    print(Solution().maxSumTwoNoOverlap(
        nums=[2, 1, 5, 6, 0, 9, 5, 0, 3, 8], firstLen=4, secondLen=3)
    )
    print(Solution().maxSumTwoNoOverlap(
        nums=[4, 5, 14, 16, 16, 20, 7, 13, 8, 15], firstLen=3, secondLen=5)  # 109
    )
