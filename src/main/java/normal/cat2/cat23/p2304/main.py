from utils.python.predef import *

from functools import cache


class Solution:
    def minPathCost(self, grid: List[List[int]], moveCost: List[List[int]]) -> int:
        M, N = len(grid), len(grid[0])
        pos = dict()
        for i in range(M):
            for j in range(N):
                pos[grid[i][j]] = (i, j)

        @cache
        def dfs(x):
            row = pos[x][0]
            if row == M - 1:
                return x
            ans = min(dfs(grid[row + 1][i]) + x + moveCost[x][i] for i in range(N))
            return ans

        return min(dfs(grid[0][i]) for i in range(N))


if __name__ == '__main__':
    print(Solution().minPathCost(grid=[[5, 3], [4, 0], [2, 1]],
                                 moveCost=[[9, 8], [1, 5], [10, 12], [18, 6], [2, 4], [14, 3]]))
    print(Solution().minPathCost(grid=[[5, 1, 2], [4, 0, 3]],
                                 moveCost=[[12, 10, 15], [20, 23, 8], [21, 7, 1], [8, 1, 13], [9, 10, 25], [5, 3, 2]]))
