from utils.python.predef import *


class Solution:
    def minimumArea(self, grid: List[List[int]]) -> int:
        n, m = len(grid), len(grid[0])

        a, b = inf, -inf
        x, y = inf, -inf
        for i in range(n):
            for j in range(m):
                if grid[i][j] == 1:
                    a = min(a, i)
                    b = max(b, i)
                    x = min(x, j)
                    y = max(y, j)
        return (b - a + 1) * (y - x + 1)


if __name__ == '__main__':
    print(Solution().minimumArea(grid=[[0, 1, 0], [1, 0, 1]]))
    print(Solution().minimumArea(grid=[[0, 0], [1, 0]]))
