from utils.python.predef import *


class Solution:
    def equalPairs(self, grid: List[List[int]]) -> int:
        n = len(grid)
        a, b = Counter(), Counter()
        for i in range(n):
            a.update([tuple(grid[i])])
            b.update([tuple(grid[j][i] for j in range(n))])

        ans = 0
        for i in a.keys():
            if i not in b: continue
            ans += a[i] * b[i]
        return ans


if __name__ == '__main__':
    print(Solution().equalPairs([[3, 2, 1], [1, 7, 6], [2, 7, 7]]))
    print(Solution().equalPairs([[3, 1, 2, 2], [1, 4, 4, 5], [2, 4, 2, 2], [2, 4, 2, 2]]))
