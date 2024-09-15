from utils.python.predef import *


class Solution:
    def getSneakyNumbers(self, nums: List[int]) -> List[int]:
        count = Counter(nums)
        return [num for num, freq in count.items() if freq > 1]


if __name__ == '__main__':
    print(Solution().getSneakyNumbers(nums=[0, 1, 1, 0]))
    print(Solution().getSneakyNumbers(nums=[0, 3, 2, 1, 3, 2]))
    print(Solution().getSneakyNumbers(nums=[7, 1, 5, 4, 3, 4, 6, 0, 9, 5, 8, 2]))
