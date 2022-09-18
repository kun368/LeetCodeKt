from utils.python.predef import *

from utils.python.template import UnionFind


class Solution:
    def largestIsland(self, grid: List[List[int]]) -> int:
        n = len(grid)
        uf = UnionFind(n * n)
        for i in range(n):
            for j in range(n):
                idx = i * n + j
                if grid[i][j] == 1:
                    if i > 0 and grid[i - 1][j] == 1:
                        uf.union(idx, (i - 1) * n + j)
                    if j > 0 and grid[i][j - 1] == 1:
                        uf.union(idx, i * n + (j - 1))

        sz = defaultdict(int)
        for i in range(n):
            for j in range(n):
                idx = i * n + j
                if grid[i][j] == 1:
                    sz[uf.find(idx)] += 1

        ans = 0
        DIR_4 = ((-1, 0), (1, 0), (0, -1), (0, 1))
        for i in range(n):
            for j in range(n):
                if grid[i][j] == 1:
                    ans = max(ans, sz[uf.find(i * n + j)])
                    continue
                ids = set()
                for dx, dy in DIR_4:
                    xx, yy = i + dx, j + dy
                    idx = xx * n + yy
                    if 0 <= xx < n and 0 <= yy < n and grid[xx][yy] == 1:
                        ids.add(uf.find(idx))
                cur_sz = 1
                for p in ids:
                    cur_sz += sz[p]
                ans = max(ans, cur_sz)
        return ans


if __name__ == '__main__':
    print(Solution().largestIsland(grid=[[1, 0], [0, 1]]))
    print(Solution().largestIsland(grid=[[1, 1], [1, 0]]))
    print(Solution().largestIsland(grid=[[1, 1], [1, 1]]))
