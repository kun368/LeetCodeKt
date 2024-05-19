from utils.python.predef import *


class Solution:
    def waysToReachStair(self, k: int) -> int:
        @cache
        def dfs(cur, pre_minus, cur_jump):
            ans = int(cur == k)
            if not pre_minus:
                ans += dfs(cur - 1, True, cur_jump)
            if cur <= k + 10:
                ans += dfs(cur + (1 << cur_jump), False, cur_jump + 1)
            return ans

        return dfs(1, False, 0)


if __name__ == '__main__':
    print(Solution().waysToReachStair(int(0)))
    print(Solution().waysToReachStair(int(1)))
    print(Solution().waysToReachStair(int(10)))
    print(Solution().waysToReachStair(int(10000)))
    print(Solution().waysToReachStair(int(100000)))
    print(Solution().waysToReachStair(int(1000000000)))
