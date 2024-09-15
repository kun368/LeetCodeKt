from utils.python.predef import *


class StringHash:
    def __init__(self, s):
        n = len(s)
        self.BASE = BASE = 131313  # 131, 131313
        self.MOD = MOD = 10 ** 13 + 7  # 10**9+7, 998244353, 10**13+7
        self.h = h = [0] * (n + 1)
        self.p = p = [1] * (n + 1)
        for i in range(1, n + 1):
            p[i] = (p[i - 1] * BASE) % MOD
            h[i] = (h[i - 1] * BASE % MOD + ord(s[i - 1])) % MOD

    def get_hash(self, l, r):  # [l,r)
        return (self.h[r] - self.h[l] * self.p[r - l] % self.MOD) % self.MOD


class Solution:
    def minValidStrings(self, words: List[str], target: str) -> int:
        ha_set = set()
        for w in words:
            for h in StringHash(w).h:
                ha_set.add(h)

        target_sh = StringHash(target)
        n = len(target)
        nums = []
        for i in range(n):
            def check(x):
                return target_sh.get_hash(i, x) not in ha_set

            ins = bisect_left(range(i + 1, n + 1), True, key=check)
            nums.append(ins)

        # 45. 跳跃游戏 II
        cnt = 0
        l, r = 0, 0
        while r < n:
            cnt += 1
            new_r = max(i + nums[i] for i in range(l, r + 1))
            l, r = r + 1, new_r
            if r < l:
                return -1
        return cnt


if __name__ == '__main__':
    print(Solution().minValidStrings(words=["abc", "aaaaa", "bcdef"], target="aabcdabc"))
    print(Solution().minValidStrings(words=["abababab", "ab"], target="ababaababa"))
    print(Solution().minValidStrings(words=["abcdef"], target="xyz"))
