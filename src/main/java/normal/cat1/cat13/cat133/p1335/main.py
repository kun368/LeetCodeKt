from utils.python.predef import *


class Solution:
    def minDifficulty(self, jobDifficulty: List[int], d: int) -> int:
        inf = 1 << 31

        @cache
        def dfs(i, j):
            if i == -1 and j == 0: return 0
            if i + 1 < j or j <= 0: return inf
            ps = 0
            ans = inf
            for p in range(i, j - 2, -1):
                ps = max(jobDifficulty[p], ps)
                ans = min(ps + dfs(p - 1, j - 1), ans)
            return ans

        ans = dfs(len(jobDifficulty) - 1, d)
        return -1 if ans >= inf else ans


if __name__ == '__main__':
    print(Solution().minDifficulty(jobDifficulty=[6, 5, 4, 3, 2, 1], d=2))
    print(Solution().minDifficulty(jobDifficulty=[9, 9, 9], d=4))
    print(Solution().minDifficulty(jobDifficulty=[1, 1, 1], d=3))
    print(Solution().minDifficulty(jobDifficulty=[7, 1, 7, 1, 7, 1], d=3))
    print(Solution().minDifficulty(jobDifficulty=[11, 111, 22, 222, 33, 333, 44, 444], d=6))
