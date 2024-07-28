from utils.python.predef import *


class UnionFind:
    def __init__(self, size):
        self.parent = list(range(size))

    def union(self, a, b):
        self.parent[self.find(a)] = self.find(b)

    def find(self, x) -> int:
        if x != self.parent[x]:
            self.parent[x] = self.find(self.parent[x])
        return self.parent[x]


def circles_intersect(circle1, circle2):
    x1, y1, r1 = circle1
    x2, y2, r2 = circle2
    distance = math.sqrt((x2 - x1) ** 2 + (y2 - y1) ** 2)
    return distance <= (r1 + r2)


def point_to_segment_distance(px, py, x1, y1, x2, y2):
    line_length = math.sqrt((x2 - x1) ** 2 + (y2 - y1) ** 2)
    if line_length == 0:
        return math.sqrt((px - x1) ** 2 + (py - y1) ** 2)
    t = max(0, min(1, ((px - x1) * (x2 - x1) + (py - y1) * (y2 - y1)) / line_length ** 2))
    nearest_x = x1 + t * (x2 - x1)
    nearest_y = y1 + t * (y2 - y1)
    return math.sqrt((px - nearest_x) ** 2 + (py - nearest_y) ** 2)


def circle_touches_segment(circle, segment):
    cx, cy, r = circle
    (x1, y1), (x2, y2) = segment
    distance = point_to_segment_distance(cx, cy, x1, y1, x2, y2)
    return distance <= r


class Solution:
    def canReachCorner(self, X: int, Y: int, circles: List[List[int]]) -> bool:
        edges = [
            [(0, 0), (X, 0)],  # 底边
            [(0, 0), (0, Y)],  # 左边
            [(0, Y), (X, Y)],  # 顶边
            [(X, 0), (X, Y)]  # 右边
        ]
        n = len(circles)
        uf = UnionFind(n + 10)
        for i in range(n):
            for t in range(4):
                if circle_touches_segment(circles[i], edges[t]):
                    uf.union(i, n + t)
            for j in range(i + 1, n):
                if circles_intersect(circles[i], circles[j]):
                    uf.union(i, j)

        if uf.find(n + 0) == uf.find(n + 1) or uf.find(n + 2) == uf.find(n + 3):
            return False
        if uf.find(n + 0) == uf.find(n + 2) or uf.find(n + 1) == uf.find(n + 3):
            return False
        return True


if __name__ == '__main__':
    print(Solution().canReachCorner(X=3, Y=4, circles=[[2, 1, 1]]))
    print(Solution().canReachCorner(X=3, Y=3, circles=[[1, 1, 2]]))
    print(Solution().canReachCorner(X=3, Y=3, circles=[[2, 1, 1], [1, 2, 1]]))
    print(Solution().canReachCorner(X=5, Y=8, circles=[[4, 7, 1]]))  # false
