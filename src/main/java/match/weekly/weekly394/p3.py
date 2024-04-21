from utils.python.predef import *


class Solution:
    def minimumOperations(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])

        @cache
        def dfs(cur_col, v):
            diff = sum([1 for t in range(m) if grid[t][cur_col] != v])
            if cur_col == n - 1:
                return diff
            ans = inf
            for nv in range(12):
                if nv == v:
                    continue
                ans = min(ans, diff + dfs(cur_col + 1, nv))
            return ans

        ret = inf
        for v in range(12):
            ret = min(ret, dfs(0, v))
        return ret


if __name__ == '__main__':
    print(Solution().minimumOperations(grid=[[1, 0, 2], [1, 0, 2]]))
    print(Solution().minimumOperations(grid=[[1, 1, 1], [0, 0, 0]]))
    print(Solution().minimumOperations(grid=[[1], [2], [3]]))
