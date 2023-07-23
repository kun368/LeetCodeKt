from utils.python.predef import *


class Solution:
    def paintWalls(self, cost: List[int], time: List[int]) -> int:
        @cache
        def dfs(pos, extra):
            if extra > pos:
                return 0
            if pos < 0:
                return 1 << 30
            return min(cost[pos] + dfs(pos - 1, extra + time[pos]), dfs(pos - 1, extra - 1))

        return dfs(len(cost) - 1, 0)


if __name__ == '__main__':
    print(Solution().paintWalls(cost=[1, 2, 3, 2], time=[1, 2, 3, 2]))
    print(Solution().paintWalls(cost=[2, 3, 4, 2], time=[1, 1, 1, 1]))
