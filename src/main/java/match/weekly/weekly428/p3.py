from utils.python.predef import *


class StringHash:
    def __init__(self, s):
        n = len(s)
        self.BASE = BASE = 131
        self.MOD = MOD = 998244353  # 10**9+7, 998244353, 10**13+7
        self.h = h = [0] * (n + 1)
        self.p = p = [1] * (n + 1)
        for i in range(1, n + 1):
            p[i] = (p[i - 1] * BASE) % MOD
            h[i] = (h[i - 1] * BASE % MOD + s[i - 1]) % MOD

    def get_hash(self, l, r):  # [l,r)
        return (self.h[r] - self.h[l] * self.p[r - l] % self.MOD) % self.MOD


class Solution:
    def beautifulSplits(self, nums: List[int]) -> int:
        n = len(nums)
        sh = StringHash(nums)
        ret = 0
        for l1 in range(1, n):
            for l2 in range(1, n):
                l3 = n - l1 - l2
                ic(nums[:l1], nums[l1:l1 + l2], nums[l1 + l2:])
                if l3 < 1:
                    continue
                if l2 >= l1 and sh.get_hash(0, l1) == sh.get_hash(l1, l1 + l1):
                    ret += 1
                elif l3 >= l2 and sh.get_hash(l1, l1 + l2) == sh.get_hash(l1 + l2, l1 + l2 + l2):
                    ret += 1
        return ret


if __name__ == '__main__':
    print(Solution().beautifulSplits(nums=[1, 1, 2, 1]))
    print(Solution().beautifulSplits(nums=[1, 2, 3, 4]))
    print(Solution().beautifulSplits(nums=[1, 2, 3, 4, 3, 4, 5, 6]))
