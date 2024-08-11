from utils.python.predef import *


class Solution:
    def countOfPairs(self, nums: List[int]) -> int:
        MOD = 10 ** 9 + 7
        n = len(nums)

        @cache
        def dfs(index: int, prev1: int, prev2: int) -> int:
            if index == n:
                return 1

            total_count = 0
            for x in range(prev1, nums[index] + 1):
                y = nums[index] - x
                if y > prev2:
                    continue
                total_count = (total_count + dfs(index + 1, x, y)) % MOD
            return total_count

        return dfs(0, 0, nums[0])


if __name__ == '__main__':
    print(Solution().countOfPairs(nums=[2, 3, 2]))
    print(Solution().countOfPairs(nums=[5, 5, 5, 5]))
