from utils.python.predef import *


class Solution:
    def zigzagTraversal(self, grid: List[List[int]]) -> List[int]:
        return [x for i, v in enumerate(grid) for x in v[::1 - 2 * (i % 2)]][::2]


if __name__ == '__main__':
    print(Solution().zigzagTraversal(grid=[[1, 2], [3, 4]]))
    print(Solution().zigzagTraversal(grid=[[2, 1], [2, 1], [2, 1]]))
    print(Solution().zigzagTraversal(grid=[[1, 2, 3], [4, 5, 6], [7, 8, 9]]))
