from typing import *


class Solution:

    def dis(self, p1, p2):
        return ((p1[0] - p2[0]) ** 2 + (p1[1] - p2[1]) ** 2) ** 0.5

    def largestTriangleArea(self, points: List[List[int]]) -> float:
        best = 0
        N = len(points)
        for i in range(N):
            for j in range(i + 1, N):
                for k in range(j + 1, N):
                    p1, p2, p3 = points[i], points[j], points[k]
                    a, b, c = self.dis(p1, p2), self.dis(p1, p3), self.dis(p2, p3)
                    s = (a + b + c) / 2
                    area = max(0.0, (s * (s - a) * (s - b) * (s - c))) ** 0.5
                    best = max(best, area)
        return best


if __name__ == '__main__':
    print(Solution().largestTriangleArea(points=[[0, 0], [0, 1], [1, 0], [0, 2], [2, 0]]))
    print(Solution().largestTriangleArea(
        points=[[35, -23], [-12, -48], [-34, -40], [21, -25], [-35, -44], [24, 1], [16, -9], [41, 4], [-36, -49],
                [42, -49], [-37, -20], [-35, 11], [-2, -36], [18, 21], [18, 8], [-24, 14], [-23, -11], [-8, 44],
                [-19, -3], [0, -10], [-21, -4], [23, 18], [20, 11], [-42, 24], [6, -19]]))
