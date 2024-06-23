from utils.python.predef import *


class Solution:
    def solve(self, grid: List[List[int]]) -> int:
        n, m = len(grid), len(grid[0])
        a1, b1 = inf, inf
        a_last, b_last = -inf, -inf
        for i in range(n):
            for j in range(m):
                if grid[i][j] == 1:
                    a1 = min(a1, i)
                    b1 = min(b1, j)
                    a_last = max(a_last, i)
                    b_last = max(b_last, j)

        @cache
        def find(x1, y1, x2, y2):
            flag = 0
            a, b = inf, -inf
            x, y = inf, -inf
            for i in range(x1, x2 + 1):
                for j in range(y1, y2 + 1):
                    if grid[i][j] == 1:
                        a = min(a, i)
                        b = max(b, i)
                        x = min(x, j)
                        y = max(y, j)
                        flag = 1
            return (b - a + 1) * (y - x + 1) if flag else inf

        def check(a2, b2):
            below_has = a2 < a_last
            right_has = b2 < b_last
            cur_area = find(a1, b1, a2, b2)
            res = inf
            res = min(res, find(a2 + 1, b1, a_last, b2) + find(a1, b2 + 1, a_last, b_last))
            res = min(res, find(a2 + 1, b1, a_last, b_last) + find(a1, b2 + 1, a2, b_last))
            if below_has and not right_has:
                for i in range(a2 + 1, a_last):
                    res = min(res, find(a2 + 1, b1, i, b_last) + find(i + 1, b1, a_last, b_last))
            if not below_has and right_has:
                for i in range(b2 + 1, b_last):
                    res = min(res, find(a1, b2 + 1, a_last, i) + find(a1, i + 1, a_last, b_last))
            # ic((a1, b1), (a2, b2), cur_area, res, below_has, right_has)
            return cur_area + res

        ans = inf
        for a2 in range(a1, a_last + 1):
            for b2 in range(b1, b_last + 1):
                ans = min(ans, check(a2, b2))
        return ans

    def minimumSum(self, grid: List[List[int]]) -> int:
        return min(
            self.solve(grid),
            self.solve(list(reversed(grid))),
            self.solve([list(reversed(i)) for i in grid]),
            self.solve(list(reversed([list(reversed(i)) for i in grid]))),
        )


if __name__ == '__main__':
    # print(Solution().minimumSum(grid=[[1, 0, 1], [1, 1, 1]]))
    # print(Solution().minimumSum(grid=[[1, 0, 1, 0], [0, 1, 0, 1]]))
    # print(Solution().minimumSum(grid=[[0, 1], [1, 1]]))  # 3
    # print(Solution().minimumSum(grid=[
    #     [0, 0, 0],
    #     [0, 0, 1],
    #     [0, 0, 1],
    #     [0, 1, 0]]
    # ))  # 3
    print(Solution().minimumSum(grid=[
        [0, 1, 0, 1],
        [0, 1, 0, 0],
        [0, 1, 0, 1]
    ]))  # 5
