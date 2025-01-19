from utils.python.predef import *


class Solution:
    def minCost(self, n: int, cost: List[List[int]]) -> int:
        def nxt(lv, rv):
            for i in range(3):
                for j in range(3):
                    if i != j and i != lv and j != rv:
                        yield i, j

        @cache
        def dfs(idx, lv, rv):
            if idx >= n // 2:
                return 0
            l = (n // 2) - idx - 1
            r = (n // 2) + idx
            ans = 1 << 50
            cur_ans = cost[l][lv] + cost[r][rv]
            for nxt_lv, nxt_rv in nxt(lv, rv):
                ans = min(ans, cur_ans + dfs(idx + 1, nxt_lv, nxt_rv))
            return ans

        ans = 1 << 50
        for nxt_lv, nxt_rv in nxt(-1, -2):
            ans = min(ans, dfs(0, nxt_lv, nxt_rv))
        return ans


if __name__ == '__main__':
    print(Solution().minCost(n=4, cost=[[3, 5, 7], [6, 2, 9], [4, 8, 1], [7, 3, 5]]))
    print(Solution().minCost(n=6, cost=[[2, 4, 6], [5, 3, 8], [7, 1, 9], [4, 6, 2], [3, 5, 7], [8, 2, 4]]))
