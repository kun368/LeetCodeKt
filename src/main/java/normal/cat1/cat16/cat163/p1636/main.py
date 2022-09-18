from utils.python.predef import *


class Solution:
    def frequencySort(self, nums: List[int]) -> List[int]:
        counter = Counter(nums)
        return sorted(nums, key=lambda x: (counter[x], -x))


if __name__ == '__main__':
    print(Solution().frequencySort(nums=[1, 1, 2, 2, 2, 3]))
    print(Solution().frequencySort(nums=[2, 3, 1, 3, 2]))
    print(Solution().frequencySort(nums=[-1, 1, -6, 4, 5, -6, 1, 4, 1]))
