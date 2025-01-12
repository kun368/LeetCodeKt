from utils.python.predef import *


class Solution:
    def zigzagTraversal(self, grid: List[List[int]]) -> List[int]:
        m, n = len(grid), len(grid[0])
        result = []
        for i in range(m):
            if i % 2 == 0:
                result.extend(grid[i])
            else:
                result.extend(grid[i][::-1])
        return result[0::2]


if __name__ == '__main__':
    print(Solution().zigzagTraversal(grid=[[1, 2], [3, 4]]))
    print(Solution().zigzagTraversal(grid=[[2, 1], [2, 1], [2, 1]]))
    print(Solution().zigzagTraversal(grid=[[1, 2, 3], [4, 5, 6], [7, 8, 9]]))
