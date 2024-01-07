from utils.python.predef import *

class Solution:
    def hasTrailingZeros(self, nums: List[int]) -> bool:
        result = 0
        for num in nums:
            if num % 2 == 0:
                result += 1
        return result >= 2


if __name__ == '__main__':
    print(Solution().hasTrailingZeros(nums=[1, 2, 3, 4, 5]))
    print(Solution().hasTrailingZeros(nums = [2,4,8,16]))
    print(Solution().hasTrailingZeros(nums=[1, 2, 3, 4, 5]))
