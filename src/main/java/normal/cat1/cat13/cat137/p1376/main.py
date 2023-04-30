from utils.python.predef import *


class Solution:
    def dfs(self, cur, g, informTime):
        if cur not in g:
            return 0
        return max(self.dfs(i, g, informTime) for i in g[cur]) + informTime[cur]

    def numOfMinutes(self, n: int, headID: int, manager: List[int], informTime: List[int]) -> int:
        g = defaultdict(list)
        for i, v in enumerate(manager):
            g[v].append(i)
        return self.dfs(headID, g, informTime)


if __name__ == '__main__':
    print(Solution().numOfMinutes(n = 1, headID = 0, manager = [-1], informTime = [0]))
    print(Solution().numOfMinutes(n = 6, headID = 2, manager = [2,2,-1,2,2,2], informTime = [0,0,1,0,0,0]))
