from utils.python.predef import *


class Solution:
    def maxScore(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])

        @cache
        def dfs(i, j):
            if i == 0 and j == 0:
                return grid[i][j], -inf

            if i > 0:
                min_v_1, max_diff_1 = dfs(i - 1, j)
            else:
                min_v_1, max_diff_1 = inf, -inf
            if j > 0:
                min_v_2, max_diff_2 = dfs(i, j - 1)
            else:
                min_v_2, max_diff_2 = inf, -inf

            max_diff = max(max_diff_1, max_diff_2, grid[i][j] - min(min_v_1, min_v_2))
            min_v = min(min_v_1, min_v_2, grid[i][j])
            return min_v, max_diff

        return dfs(m - 1, n - 1)[1]


if __name__ == '__main__':
    print(Solution().maxScore(grid=[[9, 5, 7, 3], [8, 9, 6, 1], [6, 7, 14, 3], [2, 5, 3, 1]]))
    print(Solution().maxScore(grid=[[4, 3, 2], [3, 2, 1]]))
