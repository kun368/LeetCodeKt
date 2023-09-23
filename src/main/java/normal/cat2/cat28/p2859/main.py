from utils.python.predef import *


class Solution:
    def sumIndicesWithKSetBits(self, nums: List[int], k: int) -> int:
        return sum(v for i, v in enumerate(nums) if int(i).bit_count() == k)


if __name__ == '__main__':
    print(Solution().sumIndicesWithKSetBits(nums=[5, 10, 1, 5, 2], k=1))
    print(Solution().sumIndicesWithKSetBits(nums=[4, 3, 2, 1], k=2))
