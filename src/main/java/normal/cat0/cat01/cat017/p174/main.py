from utils.python.predef import *


class Solution:
    def calculateMinimumHP(self, dungeon: List[List[int]]) -> int:
        n, m = len(dungeon), len(dungeon[0])

        @cache
        def dfs(x: int, y: int):
            if x == n - 1 and y == m - 1:
                return max(-dungeon[x][y] + 1, 1)

            ans = []
            for dx, dy in ((1, 0), (0, 1)):
                nx, ny = x + dx, y + dy
                if nx >= n or ny >= m:
                    continue
                ans.append(max(dfs(nx, ny) - dungeon[x][y], 1))
            return min(ans)

        return dfs(0, 0)


if __name__ == '__main__':
    print(Solution().calculateMinimumHP(dungeon=[[-2, -3, 3], [-5, -10, 1], [10, 30, -5]]))
    print(Solution().calculateMinimumHP(dungeon=[[0]]))
