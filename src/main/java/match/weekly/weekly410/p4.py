from utils.python.predef import *


class PreSum1:
    def __init__(self, data):
        self.s = list(accumulate(data)) + [0]

    def query(self, i, j):  # [i, j]
        if i > j:
            return 0
        return self.s[j] - self.s[i - 1]


class Solution:
    def countOfPairs(self, nums: List[int]) -> int:
        MOD = 10 ** 9 + 7
        n = len(nums)

        dp = [[0] * (nums[i] + 1) for i in range(n)]
        dp[n - 1] = [1] * (nums[-1] + 1)

        ps = [PreSum1([]) for _ in range(n)]
        ps[n - 1] = PreSum1(dp[n - 1])

        for i in range(n - 2, -1, -1):
            for x in range(0, nums[i] + 1):
                y = nums[i] - x
                a = max(x, nums[i + 1] - y)
                b = nums[i + 1]
                dp[i][x] = ps[i + 1].query(a, b) % MOD
            ps[i] = PreSum1(dp[i])

        return sum(dp[0]) % MOD


if __name__ == '__main__':
    print(Solution().countOfPairs(nums=[2, 3, 2]))
    print(Solution().countOfPairs(nums=[5, 5, 5, 5]))
    print(Solution().countOfPairs(nums=[16, 5]))
