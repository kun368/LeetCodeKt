from utils.python.predef import *


class Solution:
    def findValueOfPartition(self, nums: List[int]) -> int:
        return min(b - a for a, b in pairwise(sorted(nums)))


if __name__ == '__main__':
    print(Solution().findValueOfPartition(nums=[1, 3, 2, 4]))
    print(Solution().findValueOfPartition(nums=[100, 1, 10]))
