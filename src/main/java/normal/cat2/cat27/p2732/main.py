from utils.python.predef import *


class Solution:
    def goodSubsetofBinaryMatrix(self, grid: List[List[int]]) -> List[int]:
        N = len(grid)
        for i in range(N):
            a = grid[i]
            sa = sorted(a)
            if sa[-1] == 0:
                return [i]
            if sa[0] == 1:
                continue
            for j in range(i + 1, N):
                b = grid[j]
                if all(x + y <= 1 for x, y in zip(a, b)):
                    return [i, j]
        return []


if __name__ == '__main__':
    print(Solution().goodSubsetofBinaryMatrix(grid=[[0, 1, 1, 0], [0, 0, 0, 1], [1, 1, 1, 1]]))
    print(Solution().goodSubsetofBinaryMatrix(grid=[[0]]))
    print(Solution().goodSubsetofBinaryMatrix(grid=[[1, 1, 1], [1, 1, 1]]))
