from typing import List
from collections import Counter, defaultdict
import math

pri = (2, 3, 5, 7, 11, 13, 17, 19, 23, 29)
mod = 1000000007


class Solution:
    def numberOfGoodSubsets(self, nums: List[int]) -> int:
        counter = Counter(nums)
        dp = defaultdict(int)
        dp[1] = (1 << counter[1]) % mod
        for i in range(2, 31):
            if counter[i] == 0 or any([i % (p * p) == 0 for p in pri]):
                continue
            for j in tuple(dp.keys()):
                if math.gcd(j, i) != 1: continue
                dp[i * j] = (dp[i * j] + counter[i] * dp[j]) % mod
        return (sum(dp.values()) - dp[1]) % mod


if __name__ == '__main__':
    print(Solution().numberOfGoodSubsets([1, 2, 3, 4]))
    print(Solution().numberOfGoodSubsets([4, 2, 3, 15]))
    print(Solution().numberOfGoodSubsets([2, 3, 5]))
