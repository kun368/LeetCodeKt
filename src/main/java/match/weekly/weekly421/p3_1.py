from utils.python.predef import *


class Solution:
    def subsequencePairCount(self, nums: List[int]) -> int:
        dp = defaultdict(int)
        MOD = 10 ** 9 + 7

        def g(a, b):
            if a is None: return b
            if b is None: return a
            return gcd(a, b)

        for idx, v in enumerate(nums):
            next_dp = defaultdict(int, dp)
            next_dp[(v, None)] += 1
            next_dp[(None, v)] += 1
            for (seq1_gcd, seq2_gcd), cnt in dp.items():
                next_dp[(g(seq1_gcd, v), seq2_gcd)] += cnt
                next_dp[(seq1_gcd, g(seq2_gcd, v))] += cnt
            dp = next_dp

        ans = 0
        for (seq1_gcd, seq2_gcd), cnt in dp.items():
            if seq1_gcd == seq2_gcd:
                ans = (ans + cnt) % MOD
        return ans


if __name__ == '__main__':
    print(Solution().subsequencePairCount(nums=[1, 2, 3, 4]))
    print(Solution().subsequencePairCount(nums=[10, 20, 30]))
    print(Solution().subsequencePairCount(nums=[1, 1, 1, 1]))
