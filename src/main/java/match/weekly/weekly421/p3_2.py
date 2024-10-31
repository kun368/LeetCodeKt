from utils.python.predef import *


class Solution:
    def subsequencePairCount(self, nums: List[int]) -> int:
        MOD = 10 ** 9 + 7
        dp = defaultdict(int)
        dp[(0, 0)] = 1

        for idx, v in enumerate(nums):
            next_dp = dp.copy()
            for (g1, g2), cnt in dp.items():
                next_dp[(gcd(g1, v), g2)] += cnt
                next_dp[(g1, gcd(g2, v))] += cnt
            dp = next_dp

        return sum(cnt for (g1, g2), cnt in dp.items() if g1 == g2 != 0) % MOD


if __name__ == '__main__':
    print(Solution().subsequencePairCount(nums=[1, 2, 3, 4]))
    print(Solution().subsequencePairCount(nums=[10, 20, 30]))
    print(Solution().subsequencePairCount(nums=[1, 1, 1, 1]))
