from utils.python.predef import *


class Solution:
    def shortestPathBinaryMatrix(self, grid: List[List[int]]) -> int:
        n = len(grid)
        vis = set()
        qu = deque()

        can = lambda x, y: 0 <= x < n and 0 <= y < n and grid[x][y] == 0 and (x, y) not in vis
        if not can(0, 0): return -1
        qu.append((0, 0, 1))
        vis.add((0, 0))
        while qu:
            cur_x, cur_y, cur_d = qu.popleft()
            if cur_x == n - 1 and cur_y == n - 1:
                return cur_d
            for dx, dy in product([-1, 0, 1], [-1, 0, 1]):
                nx, ny = cur_x + dx, cur_y + dy
                if can(nx, ny):
                    qu.append((nx, ny, cur_d + 1))
                    vis.add((nx, ny))
        return -1


if __name__ == '__main__':
    print(Solution().shortestPathBinaryMatrix(grid=[[0, 1], [1, 0]]))
    print(Solution().shortestPathBinaryMatrix(grid=[[0, 0, 0], [1, 1, 0], [1, 1, 0]]))
    print(Solution().shortestPathBinaryMatrix(grid=[[1, 0, 0], [1, 1, 0], [1, 1, 0]]))
