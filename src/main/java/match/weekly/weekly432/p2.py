from utils.python.predef import *


class Solution:
    def maximumAmount(self, coins: List[List[int]]) -> int:
        n, m = len(coins), len(coins[0])

        @cache
        def dfs(i, j, k):
            if i >= n or j >= m:
                return -(1 << 30)

            ps = list()
            if i == n - 1 and j == m - 1:
                ps.append(coins[i][j])
                if k and coins[i][j] < 0:
                    ps.append(0)
            else:
                ps.append(coins[i][j] + dfs(i, j + 1, k))
                ps.append(coins[i][j] + dfs(i + 1, j, k))
                if k and coins[i][j] < 0:
                    ps.append(dfs(i, j + 1, k - 1))
                    ps.append(dfs(i + 1, j, k - 1))
            return max(ps)

        return dfs(0, 0, 2)


if __name__ == '__main__':
    print(Solution().maximumAmount(coins=[[0, 1, -1], [1, -2, 3], [2, -3, 4]]))
    print(Solution().maximumAmount(coins=[[10, 10, 10], [10, 10, 10]]))
    print(Solution().maximumAmount(
        coins=[[-7, 12, 12, 13], [-6, 19, 19, -6], [9, -2, -10, 16], [-4, 14, -10, -9]]))  # 60
    print(Solution().maximumAmount(
        coins=[[-6, -15, -16, -8], [-10, 11, 6, 16], [1, 2, 18, 12], [15, 19, 4, 17]]))  # 64
