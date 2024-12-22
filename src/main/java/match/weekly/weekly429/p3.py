from utils.python.predef import *


class Solution:
    def minLength(self, s: str, numOps: int) -> int:
        n = len(s)
        s = [int(i) for i in s]

        def check(con_len):
            @cache
            def dfs(idx, target):
                if idx < 0:
                    return 0
                tot_diff = 0
                ret = 1 << 30
                for i in range(idx, idx - con_len, -1):
                    if s[i] != target:
                        tot_diff += 1
                    ret = min(ret, dfs(i - 1, 1 - target) + tot_diff)
                return ret

            return dfs(n - 1, 0) <= numOps or dfs(n - 1, 1) <= numOps

        # ic(check(2))
        return bisect_left(range(1, n + 1), 1, key=check) + 1


if __name__ == '__main__':
    print(Solution().minLength(s="000001", numOps=1))  # 2
    print(Solution().minLength(s="0000", numOps=2))  # 1
    print(Solution().minLength(s="0101", numOps=0))  # 1
    print(Solution().minLength(s="1101", numOps=1))  # 1
    print(Solution().minLength(s="00100", numOps=2))  # 1
    print(Solution().minLength(s="110001", numOps=1))  # 2
