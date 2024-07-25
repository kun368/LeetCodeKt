from utils.python.predef import *


class Solution:
    def minimumOperations(self, nums: List[int], target: List[int]) -> int:
        return sum(max(0, abs(j) - abs(i)) if (i >= 0) == (j >= 0) else abs(j)
                   for i, j in pairwise([0] + [y - x for x, y in zip(nums, target)]))


if __name__ == '__main__':
    print(Solution().minimumOperations(nums=[3, 5, 1, 2], target=[4, 6, 2, 4]))
    print(Solution().minimumOperations(nums=[1, 3, 2], target=[2, 1, 4]))
