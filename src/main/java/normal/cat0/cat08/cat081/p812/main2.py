from typing import *
from itertools import combinations

# https://math.stackexchange.com/questions/516219/finding-out-the-area-of-a-triangle-if-the-coordinates-of-the-three-vertices-are
class Solution:
    def largestTriangleArea(self, points: List[List[int]]) -> float:
        return max(abs((x2 - x1) * (y3 - y1) - (x3 - x1) * (y2 - y1)) / 2 for (x1, y1), (x2, y2), (x3, y3) in combinations(points, 3))


if __name__ == '__main__':
    print(Solution().largestTriangleArea(points=[[0, 0], [0, 1], [1, 0], [0, 2], [2, 0]]))
